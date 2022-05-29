package com.example;

public class StudentFormat {
    private Integer id;
    private String title;
    private boolean is_deleted;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return title;
    }

    public boolean isIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString(){
        return "LiteraryFormat { " + id + "; " + title + " }";
    }
}
