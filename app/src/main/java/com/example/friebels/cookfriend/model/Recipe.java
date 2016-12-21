package com.example.friebels.cookfriend.model;

public class Recipe {
    private String m_id;
    private String m_name;
    private String m_imageFilename;

    public Recipe(String id, String name, String s1, String s2, int i1, int i2, String imageFilename) {
        m_id = id;
        m_name = name;
        m_imageFilename = imageFilename;
    }

    public Recipe(String id, String name, String imageFilename) {
        m_id = id;
        m_name = name;
        m_imageFilename = imageFilename;
    }

    public String getId() {
        return m_id;
    }

    public void setId(String id) {
        m_id = id;
    }

    public String getName() {
        return m_name;
    }

    public void setName(String name) {
        m_name = name;
    }

    public String getImageFilename() {
        return m_imageFilename;
    }

    public void setImageFilename(String imageFilename) {
        m_imageFilename = imageFilename;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "m_id='" + m_id + '\'' +
                ", m_name='" + m_name + '\'' +
                ", m_imageFilename='" + m_imageFilename + '\'' +
                '}';
    }
}