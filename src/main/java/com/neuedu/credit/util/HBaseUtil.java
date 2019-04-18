package com.neuedu.credit.util;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Created by elvin on 2018/10/7 21:09.
 * @Describe: 自定义 HBase 公共类
 */
public class HBaseUtil {
    private static Configuration configuration;
    private static Connection connection;
    private static Long begintime = null;

    static {
        System.setProperty("hadoop.home.dir", "D:/ToolApps/Hbase-cli");
        configuration = HBaseConfiguration.create();
        configuration.set("hbase.zookeeper.property.clientPort", "2181");
        configuration.set("hbase.zookeeper.quorum", "hadoop.elvin.com");
        try {
            connection = ConnectionFactory.createConnection(configuration);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(configuration.get("hbase.master"));
    }

    /**
     * @return 成功返回true，失败报错返回false
     * @Created elvin yuan on 10:00 2018/10/19
     * @Describe //TODO admin Api Create Table
     * @Param tableName 表名
     * @Param familys 列族数组
     */
    public static boolean create(String tableName, List<String> columnFamilys) throws Exception {
        HBaseAdmin hBaseAdmin = (HBaseAdmin) connection.getAdmin();
        if (hBaseAdmin.tableExists(TableName.valueOf(tableName))) {
            System.out.println(tableName + "exists!");
            return false;
        } else {
            HTableDescriptor htd = new HTableDescriptor(TableName.valueOf(tableName));
            HColumnDescriptor tcd = new HColumnDescriptor("content");
            htd.addFamily(tcd);//创建列族
            hBaseAdmin.createTable(htd);
            // HBase 2.1 使用
//            TableDescriptorBuilder tableDescriptor = TableDescriptorBuilder.newBuilder(TableName.valueOf(tableName));
//            for (String columnFamily : columnFamilys) {
//                tableDescriptor.setColumnFamily(ColumnFamilyDescriptorBuilder.newBuilder(Bytes.toBytes(columnFamily)).build());
//            }
//            hBaseAdmin.createTable(tableDescriptor.build());
            System.out.println("创建" + tableName + "表成功");
        }
        return true;
    }

    /**
     * 添加数据
     *
     * @param tableName 表名
     * @param rowKey    行键
     * @param columns   列族1中的列
     * @param values    列族1中的列的值
     */
    public static boolean putRow(String tableName, String rowKey, String family, String[] columns, String[] values) {
        try {
            Table table = connection.getTable(TableName.valueOf(tableName));
            Put put = new Put(Bytes.toBytes(rowKey));
            put.setDurability(Durability.SKIP_WAL);
         /*   ColumnFamilyDescriptor[] columnFamilyDescriptors = table.getDescriptor().getColumnFamilies();
            for (ColumnFamilyDescriptor columnFamilyDescriptor : columnFamilyDescriptors) {
                String familyName = columnFamilyDescriptor.getNameAsString();
                if (familyName.equals(family)) {
                    for (int i = 0; i < columns.length; i++) {
                        put.addColumn(Bytes.toBytes(familyName),
                                Bytes.toBytes(columns[i]), Bytes.toBytes(values[i]));
                    }
                }
            }*/
            table.put(put);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 查询一行数据
     *
     * @param tableName  表名
     * @param rowKey     索引
     * @param familyName 列簇
     * @param columns    列名
     */
    public static Result getRow(String tableName, String familyName, String rowKey, String[] columns) {
        try {
            begintime = System.currentTimeMillis();
            Table table = connection.getTable(TableName.valueOf(tableName));
            Get get = new Get(Bytes.toBytes(rowKey));
            //指定列
            if (null != columns
                    && columns.length > 0) {
                for (String column : columns) {
                    get.addColumn(Bytes.toBytes(familyName), Bytes.toBytes(column));
                }
            }
            Result result = table.get(get);
            Long endtime = System.currentTimeMillis();
            long costTime = (endtime - begintime);
            System.out.println("用时  " + costTime + " 毫秒");
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @return 成功返回true，失败报错返回false
     * @Created elvin yuan on 9:58 2018/10/19
     * @Describe //TODO delete for rowkey list
     * @Param tableName 表名
     * @Param rowKeys 行健数组
     */
    public static boolean delete(String tableName, String[] rowKeys) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));
        List<Delete> deletes = new ArrayList<>();
        for (int i = 0; i < rowKeys.length; i++) {
            Delete delete = new Delete(Bytes.toBytes(rowKeys[i]));
            deletes.add(delete);
        }
        try {
            table.delete(deletes);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * @Created elvin yuan on 10:01 2018/10/19
     * @Describe //TODO scan Table mutiRows
     * @Param tableName 表名
     * @Param startRowKey 开始行的行健
     * @Param stopRowKey 结束行的行健
     * @return 多行结果List
     */
    public static List<Result> scan(String tableName, String startRowKey, String stopRowKey) {
        try {
            Table table = connection.getTable(TableName.valueOf(tableName));
            Scan scan = new Scan();
          /*  scan.withStartRow(Bytes.toBytes(startRowKey), true);
            scan.withStopRow(Bytes.toBytes(stopRowKey), true);*/
            ResultScanner resultScanner = table.getScanner(scan);
            List<Result> results = new ArrayList<>();
            for (Result result : resultScanner) {
                results.add(result);
            }
            return results;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }

}
