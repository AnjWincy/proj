package com.example.Task1.Service;

import com.example.Task1.Model.Data.Document;
import com.example.Task1.Model.Data.Folder;
import com.example.Task1.Model.JFile.DocumentData;
import com.example.Task1.Model.JFile.FolderData;
import com.example.Task1.Model.Data.Project;
import com.example.Task1.Model.JFile.ProjectData;
import com.example.Task1.Response.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProjectService{
//Springboot and VueJs
    ObjectMapper objectMapper=new ObjectMapper();

    File documentfile=new File("C:\\Users\\z046705\\Documents\\TASK\\document.json");
    File folderFile=new File("C:\\Users\\z046705\\Documents\\TASK\\folder.json");
    File projectFile=new File("C:\\Users\\z046705\\Documents\\TASK\\project.json");

    public String getCount(){
        try {
            Document document=objectMapper.readValue(documentfile,Document.class);
            Project project=objectMapper.readValue(projectFile, Project.class);
            Folder folder=objectMapper.readValue(folderFile, Folder.class);

            return "Project Count\t" + "Folder Count\t" +"Document Count\n\t" +project.getData().stream().count()+"\t\t\t\t" +folder.getData().stream().count() +"\t\t\t\t"+document.getData().stream().count();
        }
        catch (IOException e) {
            return "Invalid";
        }
    }

    public Response getProjectId(String documentId) {
        Response res = new Response();
        try {
            Document document=objectMapper.readValue(documentfile,Document.class);
            Project project=objectMapper.readValue(projectFile,Project.class);
            Folder folder=objectMapper.readValue(folderFile,Folder.class);

            Map<String,DocumentData> documentmap=document.getData().stream().collect(Collectors.toMap(d -> d.getDocumentId(), d -> d));
            Map<String, FolderData> foldermap=folder.getData().stream().collect(Collectors.toMap(f->f.getFolderId(),f -> f));
            Map<String, ProjectData> projectmap=project.getData().stream().collect(Collectors.toMap(p->p.getProjectId(),p -> p));

            DocumentData documentData=documentmap.get(documentId);

            if (documentData == null) {
                res.setDocumentId("No record found with respect to document ID:"+documentId);
                return res;
            }

            String documentParentId=documentData.getDocumentParentId();
            FolderData folderData=foldermap.get(documentParentId);

            String projectId=folderData.getFolderParentId();

            List<String> folderIdList=new ArrayList<>();

            folderIdList.add(folderData.getFolderId());

            while (projectId == null) {
                String parentFolderId=folderData.getParentFolderId();
                folderData=foldermap.get(parentFolderId);
                folderIdList.add(folderData.getFolderId());
                projectId=folderData.getFolderParentId();
            }
        //BRUNO
            ProjectData projectData=projectmap.get(projectId);
            res.setProjectId(projectData.getProjectId());
            res.setDocumentId(documentId);
            res.setDocumentName(documentData.getDocumentName());
            res.setFolderId(folderIdList);
            return res;

        } catch (IOException e) {
            res.setDocumentId("Error occurred while fetching data:");
            return res;
        }
    }
}
