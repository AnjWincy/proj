package com.example.Task1.Controller;



import com.example.Task1.Response.Response;
import com.example.Task1.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping("/count")
    public String getCount() {
        return projectService.getCount();
    }

    @GetMapping("/project/{documentId}")
    public Response getProject(@PathVariable String documentId) {
        return projectService.getProjectId(documentId);
    }


}
