package com.cheems.baseapi.shanghai;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class LongHuaPdfFilePushDto implements Serializable {

    // 头信息
    private LongHuaPdfPushHeadDto header;

    // 样本结果信息
    private List<SampleDataDto> data;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LongHuaPdfPushHeadDto implements Serializable {
        // 医疗机构代码
        private String hospitalcode;
        // 医疗机构名称
        private String hospitalname;
        // 用户token
        private String token;
        // 服务名称
        private String servicename;

    }

    @Data
    @NoArgsConstructor
    public static class SampleDataDto implements Serializable {

        // 报告信息
        private SampleReportDto report;

        // 医嘱项目信息
        private ReportFileDto file;


    }

    @Data
    @NoArgsConstructor
    public static class SampleReportDto implements Serializable {
        // 标本所属医疗机构代码 指采集机构 ,由各市区卫健委下发
        private String srclabcode;
        // 标本所属医疗机构名称
        private String srclabname;
        // 标本送往医疗机构代码 指检测机构,由各市区卫健委下发
        private String targetlabcode;
        // 标本送往医疗机构名称
        private String targetlabname;
        // 操作时间 DateTime(yyyy-MM-dd HH:mm:ss)
        private String operatetime;
        // 操作人工号
        private String operatorcode;
        // 操作人姓名
        private String operatorname;
        // 条码号
        private String barcode;
        // 报告单号 每家医疗机构不允许重复
        private String reportno;

    }

    @Data
    @NoArgsConstructor
    public static class ReportFileDto implements Serializable {

        // 报告文件实体类
        private List<SamplePdfDto> reportfile;

    }

    @Data
    @NoArgsConstructor
    public static class SamplePdfDto implements Serializable {

        // 文件名称
        private String filename;
        // 文件类型 报告文件标志，1 报告，0 非报告文件
        private String reportflag;
        // 图像二进制数据 Base64编码的字符串,文件小于1兆
        private String filedata;
        // 图像文件格式类型 0 bmp，1 jpg，2 gif，9pdf
        private String filetype;

    }






}
