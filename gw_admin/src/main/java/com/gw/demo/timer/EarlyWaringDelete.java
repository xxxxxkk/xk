package com.gw.demo.timer;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gw.demo.entity.EarlyWarningEntity;
import com.gw.demo.mapper.EarlyWarningEntityMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

/**
 * @author xk
 * @version 创建时间：2024年7月19日
 * @description 定时任务，每月1号清除报警预警信息
 */
@Component
@Slf4j
public class EarlyWaringDelete {
    @Resource
    private EarlyWarningEntityMapper earlyWarningEntityMapper;


    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 定时任务
     */
    @Scheduled(cron = "0 0 1 * * *")
    public void scheduled() {
        deleteEarlyWarning();
    }

    private void deleteEarlyWarning() {
        log.info("开始清除报警预警信息");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime before = now.minusMonths(1);
        String format = sdf.format(before);
        QueryWrapper<EarlyWarningEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .lt("handle_end_time", format)
                .eq("status",1);
        earlyWarningEntityMapper.delete(queryWrapper);
        log.info("清除报警预警信息完成");

    }
}
