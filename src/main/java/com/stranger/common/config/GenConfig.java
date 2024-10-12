package com.stranger.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GenConfig {
    public static String author;

    public static String packageName;

    public static boolean autoRemovePre;

    public static String tablePrefix;

    public static String fileDownLoadPath;

    public static String urlPrefix;

    @Value("${gen.url-prefix}")
    public void setUrlPrefix(String urlPrefix) {
        com.stranger.common.config.GenConfig.urlPrefix = urlPrefix;
    }

    public static String getUrlPrefix() {
        return urlPrefix;
    }


    @Value("${gen.fileDownLoadPath}")
    public void setFileDownLoadPath(String fileDownLoadPath) {
        com.stranger.common.config.GenConfig.fileDownLoadPath = fileDownLoadPath;
    }

    public static String getAuthor() {
        return author;
    }

    @Value("${gen.author}")
    public void setAuthor(String author) {
        com.stranger.common.config.GenConfig.author = author;
    }

    public static String getPackageName() {
        return packageName;
    }

    @Value("${gen.packageName}")
    public void setPackageName(String packageName) {
        com.stranger.common.config.GenConfig.packageName = packageName;
    }

    public static boolean getAutoRemovePre() {
        return autoRemovePre;
    }

    @Value("${gen.autoRemovePre}")
    public void setAutoRemovePre(boolean autoRemovePre) {
        com.stranger.common.config.GenConfig.autoRemovePre = autoRemovePre;
    }

    public static String getTablePrefix() {
        return tablePrefix;
    }

    @Value("${gen.tablePrefix}")
    public void setTablePrefix(String tablePrefix) {
        com.stranger.common.config.GenConfig.tablePrefix = tablePrefix;
    }
}
