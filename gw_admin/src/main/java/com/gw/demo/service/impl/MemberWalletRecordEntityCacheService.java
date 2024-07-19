package com.gw.demo.service.impl;

import com.gw.demo.entity.MemberWalletRecordEntity;
import com.gw.demo.service.MemberWalletRecordEntityService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 会员钱包记录service
 * @author xk
 * @Data 2024/7/19

 */
@Service
public class MemberWalletRecordEntityCacheService {
    private static final String CACHE_KEY = "MemberWalletRecordCache";
    private static final int BATCH_SIZE = 500;

    @Resource
    private RedisTemplate<String, MemberWalletRecordEntity> redisTemplate;

    @Resource
    private MemberWalletRecordEntityService memberWalletRecordEntityService;


    private List<MemberWalletRecordEntity> buffer = new CopyOnWriteArrayList<>();

    public void cacheMemberWalletRecord(MemberWalletRecordEntity entity) {
        buffer.add(entity);
        if (buffer.size() >= BATCH_SIZE) {
            saveToDatabase();
        } else {
            saveToRedis(entity);
        }
    }

    private synchronized void saveToDatabase() {
        if (!buffer.isEmpty()) {
            memberWalletRecordEntityService.saveBatch(buffer);
            buffer.clear();
        }
    }

    private void saveToRedis(MemberWalletRecordEntity entity) {
        redisTemplate.opsForList().rightPush(CACHE_KEY, entity);
    }
}
