package com.gw.demo.controller;

import com.gw.demo.entity.MemberWalletRecordEntity;
import com.gw.demo.service.MemberWalletRecordEntityService;
import com.gw.util.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/memberWalletRecord")
@RestController
public class MemberWalletRecordController {
    @Resource
    private MemberWalletRecordEntityService memberWalletRecordEntityService;

    @PostMapping("/add")
    public Result add(MemberWalletRecordEntity memberWalletRecordEntity) {
        memberWalletRecordEntityService.saveCacheMemberWalletRecord(memberWalletRecordEntity);
        return Result.success();

    }
}
