package com.zpb.testtask.models;

public class SearchModel {

    private String SearchTag;

    public String getSearchTag() {
        return SearchTag;
    }

    public void setSearchTag(String searchTag) {
        SearchTag = searchTag;
    }

    public SearchModel(String searchTag) {
        SearchTag = searchTag;
    }
}
