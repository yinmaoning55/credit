package com.neuedu.credit.repository;

import com.neuedu.credit.pojo.PersonInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Created by elvin on 2018/9/25 15:00.
 * @Describe:
 */
public interface PersonInfoRepository extends JpaRepository<PersonInfo, Integer> {
}
