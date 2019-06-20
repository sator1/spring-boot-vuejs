package com.reccyltd.springbootvuejs.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reccyltd.springbootvuejs.domain.Project;
import com.reccyltd.springbootvuejs.domain.User;
import com.reccyltd.springbootvuejs.domain.Workspace;
import com.reccyltd.springbootvuejs.exception.UserNotFoundException;
import com.reccyltd.springbootvuejs.models.ProjectRequest;
import com.reccyltd.springbootvuejs.repository.ProjectRepository;
import com.reccyltd.springbootvuejs.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;

@RestController()
@RequestMapping("/api")
public class BackendController {

    public static final String HELLO_TEXT = "Hello from Spring Boot Backend!";
    public static final String SECURED_TEXT = "Hello from the secured resource!";
    private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);
    private static final ObjectMapper MAPPER = new ObjectMapper();


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping(path = "/hello")
    public @ResponseBody
    String sayHello() {
        LOG.info("GET called on /hello resource");
        return HELLO_TEXT;
    }

    @GetMapping(path = "/user/{id}")
    public @ResponseBody
    User getUserById(@PathVariable("id") long id) {

        return userRepository.findById(id).map(user -> {
            LOG.info("Reading user with id " + id + " from database.");
            return user;
        }).orElseThrow(() -> new UserNotFoundException("The user with the id " + id + " couldn't be found in the database."));
    }

    @RequestMapping(path = "/user/{lastName}/{firstName}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    long addNewUserPathVariables(@PathVariable("lastName") String lastName, @PathVariable("firstName") String firstName) {
        User savedUser = userRepository.save(new User(firstName, lastName));
        LOG.info(savedUser.toString() + " successfully saved into DB");
        return savedUser.getId();
    }

    @RequestMapping(path = "/secured", method = RequestMethod.GET)
    public @ResponseBody
    String getSecured() {
        LOG.info("GET successfully called on /secured resource");
        return SECURED_TEXT;
    }

    @GetMapping(path = "/project")
    public @ResponseBody
    String getProjects() {
        LOG.info("GET list of all projects");


//        List<Project> projects = new ArrayList<>(2);
//        List<Workspace> workspaces = new ArrayList<>();
//
//        workspaces.add(new Workspace("Product Detail Page", "Sven Johnson", Calendar.getInstance().getTime()));
//        workspaces.add(new Workspace("Product Listing Page", "Sven Johnson", Calendar.getInstance().getTime()));
//        workspaces.add(new Workspace("Checkout Upgrade", "Sven Johnson", Calendar.getInstance().getTime()));
//
//        projects.add(new Project("Boden", "Oliwer", Calendar.getInstance().getTime(), workspaces));
//
//        workspaces.clear();
//        workspaces.add(new Workspace("Search Results", "Sven Johnson", Calendar.getInstance().getTime()));
//        workspaces.add(new Workspace("Landing Page Upgrades", "Sven Johnson", Calendar.getInstance().getTime()));
//        projects.add(new Project("Unilever", "Oliwer", Calendar.getInstance().getTime(), workspaces));
//        return projects;

        return "{\"projects\":[{\"name\":\"Boden\",\"workspaces\":[{\"name\":\"Product Detail Page\"},{\"name\":\"Product Listing Page\"},{\"name\":\"Checkout Upgrade\"}]},{\"name\":\"Unilever\",\"workspaces\":[{\"name\":\"Search Results\"},{\"name\":\"Landing Page Upgrades\"}]}]}";
    }

    @PostMapping(path = "/project")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    Project addNewProject(@RequestBody ProjectRequest projectRequest) {
        Project project = new Project(projectRequest.getName(), projectRequest.getOwner(), Calendar.getInstance().getTime(), new ArrayList<Workspace>());
        Project newProject = projectRepository.save(project);
        LOG.info(newProject.toString() + " successfully saved into DB");
        return newProject;
    }
}
