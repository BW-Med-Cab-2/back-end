package com.lambdaschool.foundation.controllers;

import com.lambdaschool.foundation.models.Strain;
import com.lambdaschool.foundation.services.StrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/strains")
public class StrainController {
    @Autowired
    StrainService strainService;

    @GetMapping(value = "/strains",
    produces = {"application/json"})
    public ResponseEntity<?> listStrains() {
        List<Strain> allStrains = strainService.findAll();
        return new ResponseEntity<>(allStrains, HttpStatus.OK);
    }
}
