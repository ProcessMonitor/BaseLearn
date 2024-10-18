package com.cheems.baseapi.shanghai;

import lombok.Data;

import java.util.List;

/**
 * 普检/特检结果dto
 */
@Data
public class LongHuaResultDto {

    private Header header;
    private List<Data> data;

    @lombok.Data
    public static class Header {
        private String hospitalcode;     // 医院代码
        private String hospitalname;     // 医院名称
        private String token;            // 认证 token
        private String servicename;      // 服务名
    }

    @lombok.Data
    public static class Data {
        private Report report;
        private List<Order> order;
        private List<Item> item;

        @lombok.Data
        public static class Report {
            private String srclabcode;       // 送检机构代码
            private String srclabname;       // 送检机构名称
            private String targetlabcode;    // 检测机构代码
            private String targetlabname;    // 检测机构名称
            private String operatetime;      // 操作时间
            private String operatorcode;     // 操作员代码
            private String operatorname;     // 操作员姓名
            private String barcode;          // 条形码
            private String reportno;         // 报告编号
            private String patname;          // 病人名称
            private String patientid;        // 病人ID
            private String cureno;           // 治疗编号
            private String hospno;           // 住院号
            private String cardno;           // 卡号
            private String cardtype;         // 卡类型
            private String idnum;            // 身份证号
            private String birthday;         // 生日
            private String age;              // 年龄
            private String ageunit;          // 年龄单位
            private String sex;              // 性别
            private String wardorreg;        // 病区或门诊
            private String wardorregname;    // 病区或门诊名称
            private String samplecode;       // 样本编码
            private String samplename;       // 样本名称
            private String sampledescode;    // 样本描述编码
            private String sampledescname;   // 样本描述名称
            private String sampleshapecode;  // 样本形态编码
            private String sampleshapename;  // 样本形态名称
            private String testinstid;       // 检测机构ID
            private String testinstcode;     // 检测机构代码
            private String testinstname;     // 检测机构名称
            private String testtechno;       // 检测技术
            private String exectime;         // 执行时间
            private String execdoccode;      // 执行医生代码
            private String execdocname;      // 执行医生名称
            private String verifytime;       // 审核时间
            private String verifiercode;     // 审核医生代码
            private String verifiername;     // 审核医生名称
            private String reporttime;       // 报告时间
            private String pubtime;          // 发布时间
            private String pubdoccode;       // 发布医生代码
            private String pubdocname;       // 发布医生名称
            private String remark;           // 备注
            private String examresult;       // 检查结果
            private String labdiagnosis;     // 实验室诊断
            private String redoflag;         // 重复标识
            private String redosample;       // 重复样本
            private String redoreason;       // 重复原因
            private String redosampledesc;   // 重复样本描述
            private String panicflag;        // 紧急标识
            private String biohazardflag;    // 生物危害标识
            private String micflag;          // 微生物标识
            private String finishflag;       // 完成标识
        }

        @lombok.Data
        public static class Order {
            private String itemcode;       // 检验项目代码
            private String itemname;       // 检验项目名称
            private String itemtype;       // 检验项目类型
            private String itemqty;        // 检验项目数量
            private String itemunit;       // 项目单位
            private String price;          // 价格
            private String hisapplyno;     // HIS申请号
            private String groupno;        // 分组号
            private String logno;          // 日志号
            private String specimencode;   // 样本编码
            private String specimenname;   // 样本名称
            private String status;         // 状态
            private String chargeflag;     // 计费标识
        }

        @lombok.Data
        public static class Item {
            private String itemcode;       // 项目代码
            private String itemname;       // 项目名称
            private String resulttime;     // 结果时间
            private String result;         // 结果
            private String unit;           // 单位
            private String resulttype;     // 结果类型
            private String referencerange; // 参考范围
            private String highlowflag;    // 高低标识
            private String printorder;     // 打印顺序
            private String panicflag;      // 紧急标识
            private String panicrange;     // 紧急范围
            private String redoflag;       // 重复标识
        }
    }
}
