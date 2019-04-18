package com.neuedu.credit.Service;

import com.neuedu.credit.pojo.PersonInfo;

/**
 * @Created by elvin on 2018/9/25 15:01.
 * @Describe:
 */
public interface PersonInfoService {
    void add (PersonInfo personInfo);
    PersonInfo get(int id);
}
