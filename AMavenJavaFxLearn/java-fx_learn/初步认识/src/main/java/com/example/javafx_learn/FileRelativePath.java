package com.example.javafx_learn;

import java.net.URL;

/**
 * 获取相对路径
 */
public class FileRelativePath {

    public static String getRelativePath() {
        URL filePath = FileRelativePath.class.getResource("/image");
        // 放在本地文件系统里的图片文件要在文件路径前面加上"file:"
        assert filePath != null;
        return filePath.toExternalForm();
    }
}
