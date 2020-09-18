package com.lambdaschool.foundation;

import com.lambdaschool.foundation.models.Role;
import com.lambdaschool.foundation.models.Strain;
import com.lambdaschool.foundation.models.User;
import com.lambdaschool.foundation.models.UserRoles;
import com.lambdaschool.foundation.repository.StrainRepository;
import com.lambdaschool.foundation.services.RoleService;
import com.lambdaschool.foundation.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Transactional
@Component
public class SeedData
        implements CommandLineRunner {

    @Autowired
    StrainRepository strainrepos;

    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    @Transactional
    @Override
    public void run(String[] args)
            throws
            Exception {

        Role r2 = new Role("user");
        r2 = roleService.save(r2);

        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(),
                r2));
        User u3 = new User("Jake the Dog",
                "DiMaggio!",
                "jake@Shape.go",
                users);
        userService.save(u3);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(),
                r2));
        User u4 = new User("Ice King",
                "tom",
                "Kenny@ice.oo", users);
        userService.save(u4);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u5 = new User("BMO", "boop", "BMO@AT.OO", users);
        userService.save(u5);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u6 = new User("Finn the Human", "password", "FTH@oo.org", users);
        userService.save(u6);

        RestTemplate restTemplate = new RestTemplate();

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        restTemplate.getMessageConverters().add(converter);

        String requestURL = "https://med-cab-1415.herokuapp.com/strains";

        ParameterizedTypeReference<List<Strain>> responseType = new ParameterizedTypeReference<>() {
        };

        ResponseEntity<List<Strain>> responseEntity = restTemplate.exchange(requestURL,
                HttpMethod.GET,
                null,
                responseType);

        List<Strain> ourStrains = responseEntity.getBody();

        for (Strain s : ourStrains) {
            strainrepos.save(s);
        }
    }
}