package com.online.nhy.controller;

import com.online.nhy.service.IWfBaseService;
import com.online.nhy.vo.WfBaseVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author NingHaiyang
 * @date 2020-05-25 11:09
 */
@RestController
@RequestMapping("/wf")
public class WfController {
    @Autowired
    private IWfBaseService wfBaseService;

    @ApiOperation(value = "查询网发信息", notes = "查询网发信息", httpMethod = "GET")
    @GetMapping(value = "/getWfBaseInfo.json")
    public Object getWfBaseInfo(HttpServletResponse response) {
        WfBaseVo wfBaseVo = new WfBaseVo();
        List<WfBaseVo> list =  wfBaseService.queryForList(wfBaseVo);
        return list;
    }
}
