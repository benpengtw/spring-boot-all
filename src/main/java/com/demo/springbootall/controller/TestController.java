package com.demo.springbootall.controller;

import cn.hutool.core.lang.Dict;
import cn.hutool.json.JSONUtil;
import com.demo.springbootall.dto.DownloadReq;
import com.google.cloud.storage.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 测试 Controller
 * </p>
 *
 * @author yangkai.shen
 * @author chen qi
 * @date Created in 2018-10-01 22:10
 */
@Slf4j
@RestController
public class TestController {

    /**
     * 测试方法
     *
     * @param who 测试参数
     * @return {@link Dict}
     */
    @GetMapping("/test")
//    public Dict test(String who) {
//        return Dict.create().set("who", StrUtil.isBlank(who) ? "me" : who);
//    }
    public String checkTest(String who) {
        log.info(who);
//        System.out.println (who);
        return who;
    }

    @RequestMapping(value = "/download", method = RequestMethod.POST)
    @ResponseBody
    public URL GenerateV4GetObjectSignedUrl(
            @RequestBody DownloadReq req) throws StorageException {
        // String projectId = "my-project-id";
        // String bucketName = "my-bucket";
        // String objectName = "my-object";
        log.info(String.valueOf (req));
        Storage storage = StorageOptions.newBuilder().setProjectId(req.getProjectId ()).build().getService();

        // Define resource
        BlobInfo blobInfo = BlobInfo.newBuilder(BlobId.of(req.getBucketName (), req.getObjectName ())).build();
        log.info(String.valueOf (blobInfo));
        URL url = storage.signUrl(blobInfo, 15, TimeUnit.MINUTES, Storage.SignUrlOption.withV4Signature());
        log.info(String.valueOf (url));
        return url;
    }

    /**
     *  测试post json方法
     * @param map 请求的json参数
     * @return {@link Dict}
     */
    @PostMapping("/testJson")
    public Dict testJson(@RequestBody Map<String, Object> map) {

        final String jsonStr = JSONUtil.toJsonStr(map);
        log.info(jsonStr);
        return Dict.create().set("json", map);
    }
}
