package com.example.javafx_learn.A列表_树表格_多列列表.B_TreeView;

/**
 * Start Date: 2021/10/21
 * Author: 冯镠霖(fengliulin)
 */
public class ItemData {
    private String name; // 文件名
    private boolean isDir = false;

    public ItemData() {
    }

    public ItemData(String name, boolean isDir) {
        this.name = name;
        this.isDir = isDir;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDir() {
        return isDir;
    }

    public void setDir(boolean dir) {
        isDir = dir;
    }
}
