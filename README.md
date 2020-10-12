# Medcab Spring API

## About the project

Medcab allows you to get medications fast by finding prescriptions based on your symptoms.

## Heroku App: https://medcab2.herokuapp.com/


```shell script
https://medcab2.herokuapp.com/createnewuser
https://medcab2.herokuapp.com/login
https://medcab2.herokuapp.com/users/users
https://medcab2.herokuapp.com/users/currentuser
https://medcab2.herokuapp.com/strains/strains
https://medcab2.herokuapp.com/otherapis/strainmodel
https://medcab2.herokuapp.com/otherapis/strainmodel/{medical keywords}
https://medcab2.herokuapp.com/otherapis/toptenrating
https://medcab2.herokuapp.com/otherapis/toptenflavor
```

## createnewuser

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

## login
<details>
<summary>POST https://medcab2.herokuapp.com/createnewuser</summary>

```JSON
{
    "username": "finn the human",
    "password": "password"
}
```
OUTPUT

```JSON
{
  "access_token":"29ef8d09-e8cb-42c7-a061-ac350afca0a6",
  "token_type":"bearer",
  "scope":"read write trust"
}
```
</details>

## users

<details>
<summary>https://medcab2.herokuapp.com/users/users</summary>

```JSON
[
    {
        "userid": 4,
        "username": "jake the dog",
        "primaryemail": "jake@shape.go",
        "roles": [
            {
                "role": {
                    "roleid": 2,
                    "name": "USER"
                }
            }
        ],
        "currentStrain": null
    },
    {
        "userid": 5,
        "username": "ice king",
        "primaryemail": "kenny@ice.oo",
        "roles": [
            {
                "role": {
                    "roleid": 2,
                    "name": "USER"
                }
            }
        ],
        "currentStrain": null
    },
    {
        "userid": 6,
        "username": "bmo",
        "primaryemail": "bmo@at.oo",
        "roles": [
            {
                "role": {
                    "roleid": 2,
                    "name": "USER"
                }
            }
        ],
        "currentStrain": {
            "strain": "Truth Serum",
            "id": 2023,
            "flavors": "Spicy/Herbal, Citrus, Earthy",
            "effects": "Relaxed, Happy, Energetic, Talkative, Giggly",
            "medical": "Stress, Lack of Appetite",
            "type": "hybrid",
            "rating": 4.3
        }
    },
    {
        "userid": 7,
        "username": "finn the human",
        "primaryemail": "fth@oo.org",
        "roles": [
            {
                "role": {
                    "roleid": 2,
                    "name": "USER"
                }
            }
        ],
        "currentStrain": null
    }
]

```
</details>

<details>
<summary>https://medcab2.herokuapp.com/users/currentuser</summary>

```JSON
{
    "userid": 6,
    "username": "bmo",
    "primaryemail": "bmo@at.oo",
    "roles": [
        {
            "role": {
                "roleid": 2,
                "name": "USER"
            }
        }
    ],
    "currentStrain": {
        "strain": "Truth Serum",
        "id": 2023,
        "flavors": "Spicy/Herbal, Citrus, Earthy",
        "effects": "Relaxed, Happy, Energetic, Talkative, Giggly",
        "medical": "Stress, Lack of Appetite",
        "type": "hybrid",
        "rating": 4.3
    }
}
```
</details>

## strains
<details>
<summary>https://medcab2.herokuapp.com/strains/strains</summary>

```JSON
[
    {
        "id": 1,
        "strain": "Afpak",
        "rating": 4.2
    },
    {
        "id": 2,
        "strain": "African",
        "rating": 3.9
    },
    {
        "id": 3,
        "strain": "Afternoon Delight",
        "rating": 4.8
    },
    {
        "id": 4,
        "strain": "Afwreck",
        "rating": 4.2
    },
    {
        "id": 5,
        "strain": "Agent Orange",
        "rating": 4.2
    },
    {
        "id": 6,
        "strain": "Agent Tangie",
        "rating": 4.5
    },
    {
        "id": 8,
        "strain": "Alaska",
        "rating": 4.6
    },
    {
        "id": 9,
        "strain": "Alaska Thunder Grape",
        "rating": 5.0
    },
    {
        "id": 10,
        "strain": "Alaskan Ice",
        "rating": 4.4
    }
]
```
</details>

## strainmodel

<details>
<summary>https://medcab2.herokuapp.com/otherapis/strainmodel</summary>

```JSON
{
    "strain": "Truth Serum",
    "id": 2023,
    "flavors": "Spicy/Herbal, Citrus, Earthy",
    "effects": "Relaxed, Happy, Energetic, Talkative, Giggly",
    "medical": "Stress, Lack of Appetite",
    "type": "hybrid",
    "rating": 4.3
}
```
</details>

<details>
<summary>https://medcab2.herokuapp.com/otherapis/strainmodel/{medical terms}</summary>

```JSON
{
    "userid": 6,
    "username": "bmo",
    "primaryemail": "bmo@at.oo",
    "roles": [
        {
            "role": {
                "roleid": 2,
                "name": "USER"
            }
        }
    ],
    "currentStrain": {
        "strain": "King Cake",
        "id": 1167,
        "flavors": "Sweet, Vanilla, Citrus",
        "effects": "Relaxed, Euphoric, Happy, Creative, Uplifted",
        "medical": "Stress, Lack of Appetite, Eye Pressure",
        "type": "hybrid",
        "rating": 4.8
    }
}
```
</details>

<details>
<summary>https://medcab2.herokuapp.com/otherapis/toptenrating</summary>

```JSON
[
    {
        "strain": "Haze Heaven"
    },
    {
        "strain": "Fruit Spirit"
    },
    {
        "strain": "Jack Smack"
    },
    {
        "strain": "Supa Don"
    },
    {
        "strain": "Platinum Huckleberry Cookies"
    },
    {
        "strain": "Purple Jolly Rancher"
    },
    {
        "strain": "Blue Cheese"
    },
    {
        "strain": "Glad Max"
    },
    {
        "strain": "Bananas"
    },
    {
        "strain": "Alien Technology"
    }
]
```

</details>

<details>
<summary>https://medcab2.herokuapp.com/otherapis/toptenflavor</summary>

```JSON
[
    {
        "strain": "Haoma Mist"
    },
    {
        "strain": "Flowers For Algernon"
    },
    {
        "strain": "Bedford Glue"
    },
    {
        "strain": "Rainbow Jones"
    },
    {
        "strain": "Eastern European"
    },
    {
        "strain": "Ape Shit"
    },
    {
        "strain": "Jamba Juice"
    },
    {
        "strain": "Kali 47"
    },
    {
        "strain": "Big Smooth"
    },
    {
        "strain": "Negra 44"
    }
]
```
</details>






