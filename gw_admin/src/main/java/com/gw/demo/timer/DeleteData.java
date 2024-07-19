package com.gw.demo.timer;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gw.demo.entity.AdminNodeEntity;
import com.gw.demo.entity.MemberWalletRecordEntity;
import com.gw.demo.entity.SysDataLogEntity;
import com.gw.demo.mapper.AdminNodeEntityMapper;
import com.gw.demo.mapper.MemberWalletRecordEntityMapper;
import com.gw.demo.mapper.SysDataLogEntityMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

/**
 * @author xk
 * @version 创建时间：2024年7月19日
 * @description 定时任务，每天凌晨4点清除数据
 */
@Slf4j
@Component
public class DeleteData {
    @Resource
    private AdminNodeEntityMapper adminNodeEntityMapper;

    @Resource
    private SysDataLogEntityMapper sysDataLogEntityMapper;

    @Resource
    private MemberWalletRecordEntityMapper memberWalletRecordEntityMapper;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Scheduled(cron = "0 0 4 * * *")
    public void scheduled() {
        log.info("开始清除数据");
        adminNodeDelete();
        sysDataLogDelete();
        memberWalletRecordDelete();
        log.info("清除数据完成");
}

    private void memberWalletRecordDelete() {
        log.info("开始清除会员钱包记录");
        String format = getString(6);
       QueryWrapper<MemberWalletRecordEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.lt("created_at", format);
        memberWalletRecordEntityMapper.delete(queryWrapper);
        log.info("清除会员钱包记录完成");

    }

    private void sysDataLogDelete() {
        log.info("开始清除数据日志");
        String format = getString(3);
        QueryWrapper<SysDataLogEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.lt("created_at", format);
        sysDataLogEntityMapper.delete(queryWrapper);
        log.info("清除节点信息完成");
    }


    private String getString(int months) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime before = now.minusMonths(months);
        String format = sdf.format(before);
        return format;
    }

    private void adminNodeDelete() {
        log.info("开始清除节点信息");
        String format = getString(2);
        QueryWrapper<AdminNodeEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.lt("aduit_time", format)
        .eq("aduit_status",3);
        adminNodeEntityMapper.delete(queryWrapper);
        log.info("清除节点信息完成");
    }
}
