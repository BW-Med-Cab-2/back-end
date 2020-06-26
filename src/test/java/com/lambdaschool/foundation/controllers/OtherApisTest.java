package com.lambdaschool.foundation.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lambdaschool.foundation.models.Role;
import com.lambdaschool.foundation.models.User;
import com.lambdaschool.foundation.models.UserRoles;
import com.lambdaschool.foundation.services.UserService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.h2.server.web.WebApp;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@WithMockUser(username = "bmo", roles = {"USER", "ADMIN"})
public class OtherApisTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @MockBean
    private UserService userService;
    private List<User> userList;

    @Before
    public void setUp() throws
            Exception {
        userList = new ArrayList<>();

        Role r2 = new Role("user");
        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u3 = new User("Jake the Dog",
                "DiMaggio!",
                "jake@Shape.go",
                users);
        userList.add(u3);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(),
                r2));
        User u4 = new User("Ice King",
                "tom",
                "Kenny@ice.oo", users);
        userList.add(u4);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u5 = new User("BMO", "boop", "BMO@AT.OO", users);
        u5.setUserid(10);
        userList.add(u5);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u6 = new User("Finn the Human", "password", "FTH@oo.org", users);
        userList.add(u6);

        System.out.println("\n*** Seed Data ***");
        for (User u : userList) {
            System.out.println(u);
        }
        System.out.println("*** Seed Data ***\n");

        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .build();
    }

    @After
    public void tearDown() throws
            Exception {
    }

    @Test
    void getStrainModel() throws Exception {
        String apiUrl = "/otherapis/strainmodel/happy";

        Mockito.when(userService.findUserById(10))
                .thenReturn(userList.get(1));

        RequestBuilder rb = MockMvcRequestBuilders.get(apiUrl)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult r = mockMvc.perform(rb)
                .andReturn(); // this could throw an exception
        String tr = r.getResponse()
                .getContentAsString();

        ObjectMapper mapper = new ObjectMapper();
        String er = mapper.writeValueAsString(userList.get(1));

        System.out.println("Expect: " + er);
        System.out.println("Actual: " + tr);

        assertEquals("Rest API Returns List", er, tr);
    }

    @Test
    void getTopRated() {
    }

    @Test
    void getTopFlavor() {
    }

    @Test
    void sendStrainInfo() {
    }
}