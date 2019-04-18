package com.neuedu.credit.repository;

import com.neuedu.credit.pojo.TbEnterprise;
import javafx.scene.chart.ValueAxis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * @Created by elvin on 2018/9/25 16:24.
 * @Describe:
 */
public interface TbEnterpriseRepository  extends JpaRepository<TbEnterprise,Integer>,JpaSpecificationExecutor {

    @Query(value = "SELECT e.* FROM tb_enterprise AS e LEFT JOIN user_authentication AS a ON e.entid = a.authenticationinfo_id WHERE a.user_id = ?1 AND a.authenticationtype = ?2",nativeQuery = true)
    TbEnterprise queryByUserId (int userId,int userType);
}
