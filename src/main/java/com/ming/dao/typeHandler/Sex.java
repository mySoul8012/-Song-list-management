package com.ming.dao.typeHandler;

/**
 * @author ming
 */

public enum Sex {
    /**
     * 性别枚举
     */
    MALE(1, "男"), FEMALE(2, "女");
    /**
     * id
     */
    private int id;
    /**
     * 枚举名称
     */
    private String name;

    /**
     * 构造
     * @param id
     * @param name
     */
    private Sex(int id, String name){
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static Sex getSex(int id){
        if(id == 1){
            return MALE;
        }else if(id == 2){
            return FEMALE;
        }
        return  null;
    }
}
