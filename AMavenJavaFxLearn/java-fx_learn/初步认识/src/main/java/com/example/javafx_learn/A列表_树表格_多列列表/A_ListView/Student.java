package com.example.javafx_learn.A列表_树表格_多列列表.A_ListView;

/**
 * Start Date: 2021/10/20
 * Author: 冯镠霖(fengliulin)
 */
public class Student {
    private int id;
    private String name;
    private boolean sex;

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public Student(int id, String name, boolean sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }
}
