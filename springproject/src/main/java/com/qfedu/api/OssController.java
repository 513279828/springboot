package com.qfedu.api;

import com.qfedu.common.vo.R;
import com.qfedu.oss.service.OssUrlService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Api(value = "资源管理", tags = "资源管理")
@RestController
public class OssController {
    @Autowired
    private OssUrlService urlService;

    @ApiOperation(value = "实现资源的上传",notes = "实现资源的上传，返回访问路径信息")
    @PostMapping("/api/oss/upload.do")
    public R upload(MultipartFile file){
        return urlService.upload(file);
    }
    @ApiOperation(value = "查询数据库记录的上传信息",notes = "查询数据库记录的上传信息")
    @GetMapping("/api/oss/localall.do")
    public R localall(){
        return urlService.queryAll();
    }
    @ApiOperation(value = "查询OSS记录的对象信息",notes = "查询OSS记录的对象信息")
    @GetMapping("/api/oss/ossall.do")
    public R all(){
        return urlService.queryOssAll();
    }
    @ApiOperation(value = "删除文件",notes = "删除文件")
    @DeleteMapping("/api/oss/del.do")
    public R del(String objname){
        return urlService.del(objname);
    }

}
