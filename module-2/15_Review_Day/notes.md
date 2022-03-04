# Spring Boot & JDBC Review

## Creating a new project from scratch

> Note: I rarely do this. I usually use a similar previous project as a starter and then delete all the src/test files. 

There are also instructions for how to do this in BootcampOS under the Intro to Tools, IntelliJ reading. 

- Open IntelliJ and choose New Project. 
- In the New Project wizard, select Maven. DO NOT check the box to "Create from archetype". Click Next.
- Fill in the name & location for your project. If you want to push this up to your personal portfolio, DO NOT nest it inside of your student-code directory or any other git project/repository.

- Create your main package in the src/main/java folder. If this is am personal project, you might use something like `com.yourname` or `com.yourGitHubUsername`instead of `com.techelevator`.
- Make the application class with a main method. This generally has a name ending in `App` or `Application`.
- Setup the Run Configuration. 
  - You should see "Add Configuration" in the upper right-hand section of IntelliJ. Choose "Application". 
  - Give it a name at the top
  - Set your main class, then click OK.

- Setup dependencies in the pom.xml file. There are several options on how you might do this:
  - You can search & add each individually in IntelliJ. This is a little tedious... I have never bothered to do this.
  - You can use the [Spring Initializer](https://start.spring.io/) to help you build a starter project OR a explore to copy/paste a new pom.xml into an existing project. 
  - *MY FAVORITE* You can copy/paste from a previous project's pom.xml to add the dependencies. We'll do this using the starter-snippets/pom.xml. 
- Once you have dependencies in your pom.xml, you need to reload the project dependencies. 
  - Do this by opening the "Maven" side-bar on the right hand side of the IDE.
  - Right-click your project and choose "Reload project" from the menu.

- Setup your postgres database.
- Configure your datasource 
  - Under src/main/resources, create an `application.properties` file. 
  - Use a previous project's file to help you setup the new one.
  - Add the datasource information, changing the database name, username & password as needed for the new database. 

- To make sure you have the Spring dependencies loaded & the configuration correct, go back to your main class and update it to start with Spring.

```
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PetFriendsApp {
    public static void main(String[] args) {
        SpringApplication.run(PetFriendsApp.class, args);
    }
}
```

- Run your application and it should start with Tomcat. Woot! Now you have a new foundation on which to build your application. 

