package com.qfedu.oss.service;

import com.qfedu.common.vo.R;
import org.springframework.web.multipart.MultipartFile;

public interface OssUrlService {
    //上传
    R upload(MultipartFile file);
    //查询所有的信息
    R queryAll();
    //查询oss的对象名称
    R queryOssAll();
    //删除文件
    R del(String objName);
}
