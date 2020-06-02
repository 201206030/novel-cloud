package com.java2nb.novel.file.service.impl;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.CreateBucketRequest;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.java2nb.novel.common.utils.Constants;
import com.java2nb.novel.common.utils.UUIDUtil;
import com.java2nb.novel.file.config.OssProperties;
import com.java2nb.novel.file.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 *  文件服务接口实现类
 * @author xiongxiaoyang
 * @version 1.0
 * @since 2020/6/2
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class FileServiceImpl implements FileService {

    private final OssProperties ossProperties;

    @Override
    public String uploadFile(File file) {

        String fileName = file.getName();
        String filePath =
                Constants.LOCAL_PIC_PREFIX  + UUIDUtil.getUUID32() + fileName.substring(fileName.lastIndexOf("."));

        filePath = filePath.replaceFirst("/","");

        OSSClient ossClient = new OSSClient(ossProperties.getEndpoint(), ossProperties.getKeyId(), ossProperties.getKeySecret());
        try {
            //容器不存在，就创建
            if (!ossClient.doesBucketExist(ossProperties.getBucketName())) {
                ossClient.createBucket(ossProperties.getBucketName());
                CreateBucketRequest createBucketRequest = new CreateBucketRequest(ossProperties.getBucketName());
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                ossClient.createBucket(createBucketRequest);
            }
            //上传文件
            PutObjectResult result = ossClient.putObject(new PutObjectRequest(ossProperties.getBucketName(), filePath, file));
            //设置权限 这里是公开读
            ossClient.setBucketAcl(ossProperties.getBucketName(), CannedAccessControlList.PublicRead);

            if(result != null) {
                return ossProperties.getWebUrl() + "/" + filePath;
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            //关闭
            ossClient.shutdown();
        }

        return "/images/default.gif";
    }


}
