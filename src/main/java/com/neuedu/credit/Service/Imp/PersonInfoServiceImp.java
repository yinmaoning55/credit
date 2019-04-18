package com.neuedu.credit.Service.Imp;

import com.neuedu.credit.Service.PersonInfoService;
import com.neuedu.credit.pojo.PersonInfo;
import com.neuedu.credit.repository.PersonInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Created by elvin on 2018/9/25 15:02.
 * @Describe:
 */
@Service(value = "PersonInfoService")
public class PersonInfoServiceImp implements PersonInfoService {
    @Autowired
    PersonInfoRepository personInfoRepository;

    @Override
    public void add(PersonInfo personInfo) {
        personInfoRepository.save(personInfo);
    }

    @Override
    public PersonInfo get(int id) {
        return personInfoRepository.findById(id).get();
    }
}
