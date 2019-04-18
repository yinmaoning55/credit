package com.neuedu.credit.Service;

import com.neuedu.credit.pojo.TbEnterprise;

/**
 * @Created by elvin on 2018/9/25 16:31.
 * @Describe:
 */
public interface TbEnterpriseService {
    TbEnterprise findById(int entid);
    TbEnterprise findByUserId(int userId);
    TbEnterprise save(TbEnterprise enterprise);
}
