package com.cheems.baseapi.feign;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public interface ApplyClient {
    /**
     * 获取申请单
     *
     * @param request QueryApplyRequest
     * @return  OutApplyInfoDTO
     */
    @RequestMapping(value = "/jianyan/middle/apply/get", method = RequestMethod.POST)
    Response<OutApplyInfoDTO> get(@RequestBody QueryApplyRequest request);

    /**
     * 获取申请单信息 FOR 病理
     * 按照数据库结构直接返回，不做处理
     * @param request
     * @return
     */
    @RequestMapping(value = "/pathology/middle/apply/get", method = RequestMethod.POST)
    Response<TbPathologyApplyMainDTO> getForPathology(@RequestBody QueryApplyRequest request);

    /**
     * 查询外送申请单(二级医院外送专用)
     * @param request
     * @return
     */
    @RequestMapping(value = "/jianyan/middle/apply/selectOutApplyInfo", method = RequestMethod.POST)
    Response<List<OutApplyInfoDTO>> selectOutApplyInfo(@RequestBody QueryOutApplyRequest request);

    /**
     * 签收
     *
     * @param request   {@link SignApplyInfoRequest}
     * @return
     */
    @RequestMapping(value = "/jianyan/middle/apply/sign", method = RequestMethod.POST)
    Response<OrgApplySampleMainDTO> sign(@RequestBody SignApplyInfoRequest request);

    /**
     * 取消签收
     * @param request   {@link SignCancelApplyInfoRequest}
     * @return
     */
    @RequestMapping(value = "/jianyan/middle/apply/cancelSign", method = RequestMethod.POST)
    Response<?> cancelSign(@RequestBody SignCancelApplyInfoRequest request);

    /**
     * 推送中间库样本数据信息
     */
    @RequestMapping(value = "/jianyan/middle/apply/push", method = RequestMethod.POST)
    Response<?> pushSampleInfo(@RequestBody SendApplyFormInfoRequest request);

    /**
     * 取消外送
     */
    @RequestMapping(value = "/jianyan/middle/apply/cancelSend", method = RequestMethod.POST)
    Response<?> cancelSend(@RequestBody CancelSendApplyRequest request);

    /**
     * 服务心跳监测
     * @return
     */
    @RequestMapping(value = "/jianyan/middle/apply/serviceMonitor", method = RequestMethod.POST)
    Response<?> serviceMonitor();
}
