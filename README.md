
# PROJETO BACKEND ORDEM DE PEDIDOS

Backend feito em Java com Spring Boot, para um aplicativo de pedidos.


## Autor(a)

- [Ana Karolina](https://www.linkedin.com/in/karolina104016/)

  
## Modelo Conceitual

![modelo conceitual](https://github.com/anna104016/html/blob/main/html/diagrama.png)

## Modelo de camadas

![camadas](https://github.com/anna104016/html/blob/main/estrutura%20de%20camadas01.png)

## Exemplo de requisição JSON no Postaman

#### Post novo pedido

```http
  POST /pedidos
```

![requisição](https://github.com/anna104016/html/blob/main/html/novo%20pedido.PNG)

## API Reference

#### Get todos os pedios

```http
  GET /pedidos
```

#### Get pedido por id

```http
  GET /pedidos/${id}
```

#### Get cliente por id

```http
  GET /clientes/${id}
```

#### Post novo pedido

```http
  POST /pedidos
```


  
## Tecnologias usadas

- Java com SpringBoot
- Banco de dados h2 para testes
- Postman para teste de requisições
- JWT para geração de tokens

## Requisições 

- Inserir, deletar e atulizar Cliente;
- Inserir, deletar e atulizar Pedidos;
- Inserir Estados e Cidades.


  
