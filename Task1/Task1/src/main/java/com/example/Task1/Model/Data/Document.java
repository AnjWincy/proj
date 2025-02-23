package com.example.Task1.Model.Data;

import com.example.Task1.Model.JFile.DocumentData;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Document {

    @JsonProperty("data")
    private List<DocumentData> data;

    public List<DocumentData> getData() {
        return data;
    }

    public void setData(List<DocumentData> data) {
        this.data = data;
    }

}
