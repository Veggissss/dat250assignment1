## DAT250: Software Technology Experiment Assignment 4

### Experiment 1:
I used Postman to and ran the GET, POST,GET request and validated the outputs:

``
GET localhost:8080/counters
``

Response:

```json
{
    "red": 0,
    "green": 0
}
```

<br>

``
PUT localhost:8080/counters
``

Body:

```json
{
  "red": 3,
  "green": 2
}
```

Response:

```json
{
    "red": 3,
    "green": 2
}
```

<br>

``
GET localhost:8080/counters
``

Response:

```json
{
    "red": 3,
    "green": 2
}
```

### Experiment 2:
Repository: https://github.com/Veggissss/dat250-spring-counters-todos

### Technical Problems:
None