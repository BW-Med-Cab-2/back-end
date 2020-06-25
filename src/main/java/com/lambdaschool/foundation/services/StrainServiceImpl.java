package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.models.Strain;
import com.lambdaschool.foundation.repository.StrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "strainService")
public class StrainServiceImpl implements StrainService {

    @Autowired
    StrainRepository strainrepos;

    @Override
    public List<Strain> findAll() {
        List<Strain> list = new ArrayList<>();
        strainrepos.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }
}
