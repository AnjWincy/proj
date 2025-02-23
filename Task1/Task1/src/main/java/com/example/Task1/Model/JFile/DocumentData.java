package com.example.Task1.Model.JFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DocumentData {

    @JsonProperty("id")
    private String documentId;

    @JsonProperty("name")
    private String documentName;

    @JsonProperty("parentId")
    private String documentParentId;

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

    public String getDocumentParentId() {
        return documentParentId;
    }

    public void setDocumentParentId(String documentParentId) {
        this.documentParentId = documentParentId;
    }
}
