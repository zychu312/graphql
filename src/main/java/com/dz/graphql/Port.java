package com.dz.graphql;

public class Port {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsUp() {
        return isUp;
    }

    public void setIsUp(Boolean up) {
        isUp = up;
    }

    private String id;
    private Integer number;
    private String name;
    private Boolean isUp;


}
