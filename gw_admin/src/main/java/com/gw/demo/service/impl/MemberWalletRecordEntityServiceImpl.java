package com.gw.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gw.demo.entity.MemberWalletRecordEntity;
import com.gw.demo.mapper.MemberWalletRecordEntityMapper;
import com.gw.demo.service.MemberWalletRecordEntityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MemberWalletRecordEntityServiceImpl extends ServiceImpl<MemberWalletRecordEntityMapper, MemberWalletRecordEntity> implements MemberWalletRecordEntityService {

    @Resource
    private MemberWalletRecordEntityCacheService memberWalletRecordEntityCacheService;

    @Override
    public void saveCacheMemberWalletRecord(MemberWalletRecordEntity memberWalletRecordEntity) {
        memberWalletRecordEntityCacheService.cacheMemberWalletRecord(memberWalletRecordEntity);
    }
}
