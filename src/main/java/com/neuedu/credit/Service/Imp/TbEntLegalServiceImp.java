package com.neuedu.credit.Service.Imp;

import com.neuedu.credit.Service.TbEntLegalService;
import com.neuedu.credit.pojo.TbEntLegal;
import com.neuedu.credit.repository.TbEntLegalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Created by elvin on 2018/10/12 15:57.
 * @Describe:
 */
@Service("TbEntLegalService")
public class TbEntLegalServiceImp implements TbEntLegalService {

    @Autowired
    TbEntLegalRepository entLegalRepository;

    @Override
    public void save(TbEntLegal entLegal) {
        entLegalRepository.save(entLegal);
    }
}
