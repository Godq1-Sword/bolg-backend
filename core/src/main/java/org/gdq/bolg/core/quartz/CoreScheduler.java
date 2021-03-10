package org.gdq.bolg.core.quartz;

import lombok.extern.slf4j.Slf4j;
import org.gdq.bolg.core.util.QuartzUtil;
import org.quartz.JobBuilder;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 核心调度器
 *
 * @author gdq
 * date 2020/12/19
 */
@Slf4j
public class CoreScheduler {

    // 调度器
    private static Scheduler scheduler = null;

    static {
        try {
            scheduler = StdSchedulerFactory.getDefaultScheduler();
        } catch (SchedulerException e) {
            log.error("CoreScheduler创建失败,Error:" + e.getMessage());
        }
    }

    public static void execute() throws SchedulerException {
        // 执行调度器
        scheduler.scheduleJob(JobBuilder.newJob(StartJob.class).withIdentity("startJob", "core").build(),
                QuartzUtil.generateTrigger("0 1/3 * * * ? *"));
        scheduler.start();
    }

    public static void main(String[] args) throws SchedulerException {
        execute();
    }
}
