package com.example.Task1.Model.JFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FolderData {

    @JsonProperty("id")
    private String folderId;

    @JsonProperty("name")
    private String folderName;

    @JsonProperty("parentId")
    private String folderParentId;

    @JsonProperty("parentFolderId")
    private String parentFolderId;

    public String getFolderId() {
        return folderId;
    }

    public void setFolderId(String folderId) {
        this.folderId = folderId;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public String getFolderParentId() {
        return folderParentId;
    }

    public void setFolderParentId(String folderParentId) {
        this.folderParentId = folderParentId;
    }

    public String getParentFolderId() {
        return parentFolderId;
    }

    public void setParentFolderId(String parentFolderId) {
        this.parentFolderId = parentFolderId;
    }

}
