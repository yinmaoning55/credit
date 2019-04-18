package com.neuedu.credit.Service.Imp;

import com.neuedu.credit.Service.CreditObjectionService;
import com.neuedu.credit.pojo.CreditObjection;
import com.neuedu.credit.repository.CreditObjectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Created by elvin on 2018/10/12 16:18.
 * @Describe:
 */
@Service("CreditObjectionService")
public class CreditObjectionServiceImp implements CreditObjectionService {

    @Autowired
    CreditObjectionRepository repository;
    @Override
    public void save(CreditObjection creditObjection) {
        repository.save(creditObjection);
    }
}
