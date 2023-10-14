## projeto-integrador-2
Projeto Integrador, diciplina do curso de ciencia da computacao, universidade federal do ceara, campus Crateús.

### Compostição

Hibernate - JPA
Spring Boot
Docker 3.0
MySql - Xampp

### Container
Para iniciar o container execute
```
docker-compose up -d
```

Em seguinda entre em: http://localhost:8081/phpmyadmin/ 

Na aba SQL do PHPMyAdmin, execute esse comando para permitir o acesso remoto ao usuário desejado:
```
    GRANT ALL ON *.* TO 'root'@'%' identified by 'root';
    FLUSH PRIVILEGES;
```

Na aba SQL do PHPMyAdmin, crie o esquema que você utilizará para a aplicação:
```
CREATE SCHEMA web;
``` 

### Back
Com o servidor xampp executando e banco de dados web criado, execute o back end.

