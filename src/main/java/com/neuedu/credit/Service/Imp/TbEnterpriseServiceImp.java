package com.neuedu.credit.Service.Imp;

import com.neuedu.credit.Service.TbEnterpriseService;
import com.neuedu.credit.pojo.TbEnterprise;
import com.neuedu.credit.repository.TbEnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Created by elvin on 2018/9/25 16:32.
 * @Describe:
 */
@Service(value = "TbEnterpriseService")
public class TbEnterpriseServiceImp implements TbEnterpriseService {
    @Autowired
    TbEnterpriseRepository enterpriseRepository;

    @Override
    public TbEnterprise findById(int entid) {
        return enterpriseRepository.findById(entid).get();
    }

    @Override
    public TbEnterprise findByUserId(int userId) {
        int userType = 2;
        return enterpriseRepository.queryByUserId(userId, userType);
    }

    @Override
    public TbEnterprise save(TbEnterprise enterprise) {
        enterpriseRepository.save(enterprise);
        return enterprise;
    }
}
