package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.FoundationApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FoundationApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StrainServiceImplTest {
    @Autowired
    StrainService strainService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void findAll() {
        assertEquals(1463, strainService.findAll().size());
    }
}