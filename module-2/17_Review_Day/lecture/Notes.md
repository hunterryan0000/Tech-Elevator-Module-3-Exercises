# Spring Boot & JDBC Review

## Adding Auth

### Database

Update your postgres database to have a user table. 

See the included database.sql file.



### application.properties

The application properties file has been updated to configure the json web token used for authentication.

```
# jwt configuration
jwt.header=Authorization
jwt.base64-secret=6nFaEf+LZBliD4w8I2zdnTYQeaAt8JeIOk1TZ/KX7F88F9C18YLT8cywdDvAsl8F8vHISTWFaGW2H1qW9Udq1qzSxUebhuZLZuxZGaZq23tRvfugFBi7MIG7sZXrRLfNlgc6tQV7sUUTOIT+YCCZnzMLvZVYOs8Ia3LzLSD4OMlYLeRovwLQx2Dp0Xqrpf2Pfy/GQQcCoxLHo8upcWhzoAznIxq137k17/x+EOg64j8Z9cGVWyOa4C0DKbTliq4ogky+qfgp3LLIiC1Sf9MPLtfMAnn7kQZsRQokk7MPmgTBEMzRmZeLAzsoieqcf4pYJ+tbvL/9cgugECPDul4lHo3vQCbTU8gLO+5kcNnjEA9Bq0CX3OL1W6F5is5Oh7ebdI4z527Y6AokVi4ZRwE4PyU47Y7qIfDlB1Tt6Ve6Pf0LE3vvIVgDtULAsx3Sra/fgx4T8yMkXKh6xTRbqFj6JlyMIyozXtwJdsnj+uetmqPt6bVF+f6uTKTIKc7XrBO5X+W3BWND5iKY+4e4MkCsBGH+EnKqySv02MKvzr4kEZRFLF86u6yhQC8eF9lAr4m/JVHfgEbN7jBQUAG/I/X6cX0Qb+Jh9YvOfHXE2Qg9T2/6h+7mRj8H+wqyWIMAwAvc5n5+jqgvvzJIf7Kj+L73I4YzJY84v+ibLFjTkc1TLe8=
jwt.expiration=604800
jwt.token-validity-in-seconds=86400
jwt.token-validity-in-seconds-for-remember-me=108000
jwt.route.authentication.path=/login
jwt.route.authentication.refresh=/refresh

server.error.include-stacktrace=never
``` 

> Note when setting up your own applications, you should always generate a new base64, 512 bit secret to use for the new app. 
  - Open your terminal and run `openssl rand -base64 512` 
  - Copy the random string into the jwt.base64-secret. (You may need to remove the line breaks.)


### pom.xml

The pom.xml file has been updated to add the JWT Version information & dependencies for security.


```
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <java.version>11</java.version>
        <!-- ADD JWT VERSION -->
        <jjwt.version>0.11.1</jjwt.version>
    </properties>
```

```
<!-- Security - auth using json web token -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-test</artifactId>
            <!-- This is only needed for testing -->
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-api</artifactId>
            <version>${jjwt.version}</version>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-impl</artifactId>
            <version>${jjwt.version}</version>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-jackson</artifactId>
            <version>${jjwt.version}</version>
        </dependency>
```

- When updating an exiting project pom.xml, you will need to reload the project dependencies. 
  - Opening the "Maven" side-bar on the right hand side of the IDE.
  - Right-click your project and choose "Reload project" from the menu.


- Run your application to make sure it starts correctly. 

