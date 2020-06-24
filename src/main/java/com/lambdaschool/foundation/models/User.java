package com.lambdaschool.foundation.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * The entity allowing interaction with the users table
 */
@ApiModel(value = "User",
        description = "Yes, this is an actual user")
@Entity
@Table(name = "users")
public class User
        extends Auditable
{
    @ApiModelProperty(name = "user id",
            value = "primary key for User",
            required = true,
            example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userid;

    @ApiModelProperty(name = "User Name",
            value = "Actual user name for sign on",
            required = true,
            example = "Some Name")
    @Size(min = 2,
            max = 30,
            message = "User Name must be between 2 and 30 characters")
    @NotNull
    @Column(nullable = false,
            unique = true)
    private String username;

    @ApiModelProperty(name = "password",
            value = "The password for this user",
            required = true,
            example = "ILuvM4th!")
    @Size(min = 4,
            message = "Password must 4 or more characters")
    @NotNull
    @Column(nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @ApiModelProperty(name = "primary email",
            value = "The email for this user",
            required = true,
            example = "john@lambdaschool.com")
    @NotNull
    @Column(nullable = false,
            unique = true)
    @Email
    private String primaryemail;

    @ApiModelProperty(name = "roles",
            value = "List of user roles for this users")
    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "user",
            allowSetters = true)
    private List<UserRoles> roles = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "currentstrain", referencedColumnName = "id")
    private StrainModel currentStrain;

    public User()
    {
    }

    public User(
            String username,
            String password,
            String primaryemail,
            List<UserRoles> userRoles)
    {
        setUsername(username);
        setPassword(password);
        setPrimaryemail(primaryemail);
        for (UserRoles ur : userRoles)
        {
            ur.setUser(this);
        }
        this.roles = userRoles;
    }

    public long getUserid()
    {
        return userid;
    }

    public void setUserid(long userid)
    {
        this.userid = userid;
    }

    public String getUsername()
    {
        if (username == null) // this is possible when updating a user
        {
            return null;
        } else
        {
            return username.toLowerCase();
        }
    }

    public void setUsername(String username)
    {
        this.username = username.toLowerCase();
    }

    public String getPrimaryemail()
    {
        if (primaryemail == null) // this is possible when updating a user
        {
            return null;
        } else
        {
            return primaryemail.toLowerCase();
        }
    }

    public void setPrimaryemail(String primaryemail)
    {
        this.primaryemail = primaryemail.toLowerCase();
    }

    public String getPassword()
    {
        return password;
    }

    public void setPasswordNoEncrypt(String password)
    {
        this.password = password;
    }

    public void setPassword(String password)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(password);
    }

    public List<UserRoles> getRoles()
    {
        return roles;
    }


    public void setRoles(List<UserRoles> roles)
    {
        this.roles = roles;
    }


    public void addRole(Role role)
    {
        roles.add(new UserRoles(this,
                                role));
    }

    public StrainModel getCurrentStrain() {
        return currentStrain;
    }

    public void setCurrentStrain(StrainModel currentStrain) {
        this.currentStrain = currentStrain;
    }

    @JsonIgnore
    public List<SimpleGrantedAuthority> getAuthority()
    {
        List<SimpleGrantedAuthority> rtnList = new ArrayList<>();

        for (UserRoles r : this.roles)
        {
            String myRole = "ROLE_" + r.getRole()
                    .getName()
                    .toUpperCase();
            rtnList.add(new SimpleGrantedAuthority(myRole));
        }

        return rtnList;
    }
}
