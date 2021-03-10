package org.gdq.bolg.core.util;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.TriggerBuilder;

/**
 * QuartzUtil
 *
 * @author gdq
 * date 2020/12/19
 */
public class QuartzUtil {

    /**
     * 生成触发器
     *
     * @param corn  cron表达式
     * @return CronTrigger cron触发器
     * @author wb-gdq845533 2020/12/19
     */
    public static CronTrigger generateTrigger(String corn) {
        return TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule(corn)).build();

    }

    /**
     * 生成JobDetail
     *
     * @param job   job实现类
     * @param name  job名称
     * @param group 组名
     * @return JobDetail job详情类
     * @author wb-gdq845533 2020/12/19
     */
    public static JobDetail generateJobDetail(Class<? extends Job> job, String name, String group) {
        return JobBuilder.newJob(job).withIdentity(name, group).build();
    }
}

