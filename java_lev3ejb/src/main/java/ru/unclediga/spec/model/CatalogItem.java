package ru.unclediga.spec.model;

public class CatalogItem {
    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public CatalogItem(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
