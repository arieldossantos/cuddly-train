# Cuddly Train

![Heroku](https://heroku-badge.herokuapp.com/?app=cuddly-train)
[![codecov](https://codecov.io/gh/arieldossantos/cuddly-train/branch/main/graph/badge.svg)](https://codecov.io/gh/arieldossantos/cuddly-train)
### Acessando a API

Para acessar a API, você deve utilizar o endereço [https://cuddly-train.herokuapp.com/](https://cuddly-train.herokuapp.com/). Este endereço pode demorar alguns segundos para funcionar, mas é o que temos para hoje :(.

A API sempre te responderá com o header ```Content-Type: application/json```, ou seja, o retorno sempre será um ```JSON``` ou um ```Array``` contendo ```JSONs```

### Endpoints

#### Transações do usuário:

Este endpoint retorna as transações de um determinado usuário, referente a um período específico.

Request:
```
[GET] /<id>/transacoes/<ano>/<mes>
```

Retorno:
```
[
  {
     "descricao": "string(10, 60)"
     "data": "long(timestamp)"
     "valor": "integer(-9.999.999, 9.999.999)"
  }  
]
```

### Como compilar

Esta api é escrita totalmente em Kotlin com Gradle 6.3! Para que seja possível compilar a mesma, é necessário que você possua o JDK 1.8 instalado! 

Para rodar a API no seu computador, execute este comando no seu PC:

```sh
./gradlew clean jar
java -jar build/libs/cuddlytrain.jar
```
