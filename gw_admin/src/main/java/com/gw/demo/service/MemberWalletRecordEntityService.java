package com.gw.demo.service;
/**
 * @author xk
 * @version 创建时间：2024年7月19日
 * @description
 */

import com.baomidou.mybatisplus.extension.service.IService;
import com.gw.demo.entity.MemberWalletRecordEntity;

public interface MemberWalletRecordEntityService extends IService<MemberWalletRecordEntity> {
    void saveCacheMemberWalletRecord(MemberWalletRecordEntity memberWalletRecordEntity);
}
