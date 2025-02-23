package com.example.Task1.Response;

import java.util.List;

public class Response {



    private String documentId;
    private String documentName;
    private List<String> folderId;
    private String projectId;

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public List<String> getFolderId() {
        return folderId;
    }

    public void setFolderId(List<String> folderId) {
        this.folderId = folderId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

}
