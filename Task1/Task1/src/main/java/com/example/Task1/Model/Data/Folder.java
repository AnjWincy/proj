package com.example.Task1.Model.Data;

import com.example.Task1.Model.JFile.FolderData;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Folder {

    @JsonProperty("data")
    private List<FolderData> data;

    public List<FolderData> getData() {
        return data;
    }

    public void setData(List<FolderData> data) {
        this.data = data;
    }
}
