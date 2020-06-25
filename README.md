# Medcab Spring API


## Heroku App: https://medcab2.herokuapp.com/


```shell script
https://medcab2.herokuapp.com/createnewuser
https://medcab2.herokuapp.com/users/users
https://medcab2.herokuapp.com/users/currentuser
https://medcab2.herokuapp.com/strands/strands
https://medcab2.herokuapp.com/otherapis/strainmodel
https://medcab2.herokuapp.com/otherapis/strainmodel/{medical keywords}
https://medcab2.herokuapp.com/otherapis/toptenrating
https://medcab2.herokuapp.com/otherapis/toptenflavor
```

###createnewuser
<details>
<summary>POST https://medcab2.herokuapp.com/createnewuser</summary>

```JSON
{
    "username": "stumps",
    "password": "ILuvM4th!",
    "primaryemail": "cuteness@home.local"
}
```

OUTPUT

```JSON
{
    "access_token": "93b627fe-8753-4715-a848-4130250b6c85",
    "token_type": "bearer",
    "scope": "read trust write"
}
```

</details>

<details>
<summary>http://localhost:2019/logout</summary>

Use the authorization code from the createnewuser.

Authorization Code becomes invalid

</details>