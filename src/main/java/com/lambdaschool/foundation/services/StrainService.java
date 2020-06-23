package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.models.Strain;

import java.util.List;

public interface StrainService {

    // get a list of all the strains...
    List<Strain> findAll();
}
