package com.example.javafx_learn.A列表_树表格_多列列表.C_TreeTableView;

import java.io.File;

public class UploadItem {
    private long localId;        // 本地上传分配的ID
    private String localGUID;    // 本地上传分配的GUID
    private String thumb;
    private File filePath;       // 本地文件路径
    private String title;        // 标题, 默认为文件名, 但允许被用户改名
    private long size;           // 文件大小
    private long timeCreated;

    public UploadItem() {

    }

    public UploadItem(String title, long size, long timeCreated) {
        this.title = title;
        this.size = size;
        this.timeCreated = timeCreated;
    }

    public long getLocalId() {
        return localId;
    }

    public void setLocalId(long localId) {
        this.localId = localId;
    }

    public String getLocalGUID() {
        return localGUID;
    }

    public void setLocalGUID(String localGUID) {
        this.localGUID = localGUID;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public File getFilePath() {
        return filePath;
    }

    public void setFilePath(File filePath) {
        this.filePath = filePath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(long timeCreated) {
        this.timeCreated = timeCreated;
    }
}
