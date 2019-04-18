package com.neuedu.credit.Service;

import com.neuedu.credit.pojo.TbUser;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Created by elvin on 2018/9/21 10:36.
 * @Describe:
 */
public interface TbUserService {
    List<TbUser> findAll();
    Page<TbUser> findByPageAndParams(String name,int pagenumber,int pageSize);
    void add(TbUser tbUser,int[] roleIds);
    Boolean register(TbUser tbUser);
    TbUser findById(int id);
    TbUser findByName(String name);
    void update(TbUser tbUser);
    TbUser bindMobile(String mobile, String code);
}
