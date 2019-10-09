package com.enlie.blog.service.impl;

import com.enlie.blog.dao.FlinkMapper;
import com.enlie.blog.service.FLinkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class FLinkServiceImpl implements FLinkService {
    @Resource
    private FlinkMapper flinkMapper;

    @Override
    public int deleteFlink(Integer id) {
        flinkMapper.deleteFlink(id);
        return 0;
    }
}
