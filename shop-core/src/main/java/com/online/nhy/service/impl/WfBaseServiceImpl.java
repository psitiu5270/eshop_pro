package com.online.nhy.service.impl;

import com.online.nhy.domain.WfBasePo;
import com.online.nhy.mapper.WfBaseMapper;
import com.online.nhy.service.IWfBaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

@Service(value = "phContractService")
public class WfBaseServiceImpl extends BaseServiceImpl<WfBasePo, WfBaseMapper> implements IWfBaseService {
    private static Logger logger = LoggerFactory.getLogger(WfBaseServiceImpl.class);
}
