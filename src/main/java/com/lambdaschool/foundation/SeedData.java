package com.lambdaschool.foundation;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.lambdaschool.foundation.models.*;
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
import java.util.Locale;

/**
 * SeedData puts both known and random data into the database. It implements CommandLineRunner.
 * <p>
 * CoomandLineRunner: Spring Boot automatically runs the run method once and only once
 * after the application context has been loaded.
 */
@Transactional
@Component
public class SeedData
        implements CommandLineRunner
{

    @Autowired
    StrainRepository strainrepos;

    /**
     * Connects the Role Service to this process
     */
    @Autowired
    RoleService roleService;

    /**
     * Connects the user service to this process
     */
    @Autowired
    UserService userService;

    /**
     * Generates test, seed data for our application
     * First a set of known data is seeded into our database.
     * Second a random set of data using Java Faker is seeded into our database.
     * Note this process does not remove data from the database. So if data exists in the database
     * prior to running this process, that data remains in the database.
     *
     * @param args The parameter is required by the parent interface but is not used in this process.
     */
    @Transactional
    @Override
    public void run(String[] args)
            throws
            Exception
    {
        Role r1 = new Role("admin");
        Role r2 = new Role("user");
        Role r3 = new Role("data");

        r1 = roleService.save(r1);
        r2 = roleService.save(r2);
        r3 = roleService.save(r3);

        // Admin seed -------------------------------------------------------------------------

        // admin, data, user
//        ArrayList<UserRoles> admins = new ArrayList<>();


/*        admins.add(new UserRoles(new User(),
                                 r1));
        admins.add(new UserRoles(new User(),
                                 r2));
        admins.add(new UserRoles(new User(),
                                 r3));
        User u1 = new User("admin",
                           "password",
                           "admin@lambdaschool.local",
                           admins);
        u1.getUseremails()
                .add(new Useremail(u1,
                                   "admin@email.local"));
        u1.getUseremails()
                .add(new Useremail(u1,
                                   "admin@mymail.local"));

        userService.save(u1);*/


        // Admin seed end ---------------------------------------------------------------------
        // user
        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(),
                                r2));
        User u3 = new User("Jake the Dog",
                           "DiMaggio!",
                           "jake@Shape.go",
                           users);
        u3.getUseremails()
                .add(new Useremail(u3,
                                   "other@email.local"));
        userService.save(u3);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(),
                                r2));
        User u4 = new User("Ice King",
                           "tom",
                           "Kenny@ice.oo",
                           users);
        userService.save(u4);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(),
                                r2));
        User u5 = new User("BMO",
                           "boop",
                           "BMO@AT.OO",
                           users);
        userService.save(u5);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u6 = new User("Finn the Human", "password", "FTH@oo.org", users);
        userService.save(u6);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u7 = new User("tempuser", "password", "tempuser@gmail.com", users);
        userService.save(u7);


        RestTemplate restTemplate = new RestTemplate();

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        restTemplate.getMessageConverters().add(converter);

        String requestURL = "https://med-cab-1415.herokuapp.com/strains";

        ParameterizedTypeReference<List<Strain>> responseType = new ParameterizedTypeReference<>()
        {
        };

        ResponseEntity<List<Strain>> responseEntity = restTemplate.exchange(requestURL,
                HttpMethod.GET,
                null,
                responseType);

        List<Strain> ourStrains = responseEntity.getBody();

        for (Strain s : ourStrains) {
            strainrepos.save(s);
        }


        // STRAINS!!!
//        Strain s1 = new Strain("Afpak",
//                " Earthy, Chemical, Pine",
//                " Relaxed, Hungry, Happy, Sleepy",
//                "Depression, Insomnia, Pain, Stress, Lack of Appetite",
//                "hybrid",
//                4.2,
//                " Pine,Spicy/Herbal,Earthy");

//        strainrepos.save(s1);

        // using JavaFaker create a bunch of regular users
        // https://www.baeldung.com/java-faker
        // https://www.baeldung.com/regular-expressions-java

//        FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-US"),
//                                                                    new RandomService());
//        Faker nameFaker = new Faker(new Locale("en-US"));
//
//        for (int i = 0; i < 25; i++)
//        {
//            new User();
//            User fakeUser;
//
//            users = new ArrayList<>();
//            users.add(new UserRoles(new User(),
//                                    r2));
//            fakeUser = new User(nameFaker.name()
//                                        .username(),
//                                "password",
//                                nameFaker.internet()
//                                        .emailAddress(),
//                                users);
//            fakeUser.getUseremails()
//                    .add(new Useremail(fakeUser,
//                                       fakeValuesService.bothify("????##@gmail.com")));
//            userService.save(fakeUser);
//        }
    }
}