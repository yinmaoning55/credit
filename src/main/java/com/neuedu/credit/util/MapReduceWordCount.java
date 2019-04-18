package com.neuedu.credit.util;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * @Created by elvin on 2018/11/2 14:15.
 * @Describe:
 */
public class MapReduceWordCount {

    public static void main(String args[]) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration conf= new Configuration();
//        conf.set("fs.default.name","hdfs://hadoop.elvin.com:9000");
//        conf.set("yarn.resourcemanager.hostname","hadoop.elvin.com");
        args = new String[]{
                "input/dream.txt",
                "wordcount"
        };
        String[] otherArgs = new GenericOptionsParser(conf,args).getRemainingArgs();
        if(otherArgs.length<2){
            System.out.println("Usage: wordcount <in> [<in>...] <out>");
            System.exit(2);
        }
        Job job = Job.getInstance(conf,"word count");
        job.setJarByClass(MapReduceWordCount.class);
        job.setMapperClass(TokenizerMapper.class);
        job.setCombinerClass(IntSumReducer.class);
        job.setReducerClass(IntSumReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        for (int i = 0; i < otherArgs.length-1; i++) {
            FileInputFormat.addInputPath(job,new Path(otherArgs[i]));
        }
        FileOutputFormat.setOutputPath(job,new Path(otherArgs[(otherArgs.length-1)]));
        System.exit(job.waitForCompletion(true) ? 0:1);
    }
    public static class IntSumReducer extends Reducer<Text,IntWritable, Text,IntWritable> {

        private IntWritable result = new IntWritable();
        public void reduce(Text key,Iterable<IntWritable> values,Reducer<Text,IntWritable,Text,IntWritable>.Context context)
                throws IOException, InterruptedException {
            int sum = 0;
            for (IntWritable val :
                    values) {
                sum += val.get();
            }
            this.result.set(sum);
            context.write(key,this.result);
        }
    }

    public static class TokenizerMapper extends Mapper<Object,Text,Text,IntWritable>{
        private static final IntWritable one = new IntWritable(1);
        private Text word = new Text();

        public void map(Object key,Text value,Mapper<Object,Text,Text,IntWritable>.Context context)
                throws IOException, InterruptedException {
            StringTokenizer itr = new StringTokenizer(value.toString());
            while (itr.hasMoreTokens()){
                this.word.set(itr.nextToken());
                context.write(this.word,one);
            }
        }
    }
}
