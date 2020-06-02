package com.java2nb.novel.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.Charsets;
import org.apache.http.client.utils.DateUtils;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import javax.imageio.ImageIO;
import java.io.*;
import java.util.Date;
import java.util.Objects;

/**
 * 文件操作工具类
 * @author xiongxiaoyang
 * @version 1.0
 * @since 2020/5/23
 */
@Slf4j
public class FileUtil {

    /**
     * 网络图片转临时文件
     * */
    public static File networkPic2Temp(String picSrc) {
        File picFile = null;
        InputStream input = null;
        OutputStream out = null;
        try {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
            ResponseEntity<Resource> resEntity = RestTemplateUtil.getInstance(Charsets.ISO_8859_1.name()).exchange(picSrc, HttpMethod.GET, requestEntity, Resource.class);
            input = Objects.requireNonNull(resEntity.getBody()).getInputStream();
            picFile = File.createTempFile("temp",picSrc.substring(picSrc.lastIndexOf(".")));
            File parentFile = picFile.getParentFile();

            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            out = new FileOutputStream(picFile);
            byte[] b = new byte[4096];
            for (int n; (n = input.read(b)) != -1; ) {
                out.write(b, 0, n);
            }

            out.flush();
            if( ImageIO.read(picFile) == null){
                return null;
            }

        }catch (Exception e){
            log.error(e.getMessage(),e);

            return null;
        }finally {
            if(input != null){
                try {
                    input.close();
                } catch (IOException e) {
                    log.error(e.getMessage(),e);
                }finally {
                    if(out != null){
                        try {
                            out.close();
                        } catch (IOException e) {
                            log.error(e.getMessage(),e);
                        }
                    }
                }
            }
            if(picFile != null) {
                //程序退出时删除临时文件
                picFile.deleteOnExit();
            }
        }



        return picFile;
    }



}
