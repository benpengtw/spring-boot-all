package com.demo.springbootall.dto;
import lombok.Data;

@Data
public class DownloadReq  {
    private String projectId;
    private String bucketName;
    private String objectName;

}
