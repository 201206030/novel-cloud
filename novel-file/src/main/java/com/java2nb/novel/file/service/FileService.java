package com.java2nb.novel.file.service;


import java.io.File;

/**
 * 文件服务接口
 * @author xiongxiaoyang
 * @version 1.0
 * @since 2020/6/2
 */
public interface FileService {

    /**
     * 上传文件
     * @param file 上传文件
     * @return 上传地址
     * */
    String uploadFile(File file);

}
