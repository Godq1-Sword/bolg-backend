package org.gdq.bolg.core.quartz;

import lombok.SneakyThrows;
import org.gdq.bolg.core.util.QuartzUtil;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.Scheduler;

import java.util.Set;

/**
 * 定时任务检查器
 *
 * @author gdq
 * date 2020/12/19
 */
public class StartJob implements Job {

    @SuppressWarnings("unchecked")
    @SneakyThrows
    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        // 检查所有job
        Class<? extends Job> job = (Class<? extends Job>) Class.forName("org.gdq.bolg.core.quartz.job.WikiJob");
        // 添加至调度器
        Scheduler scheduler = jobExecutionContext.getScheduler();
        String name = "wikiJob";
        String group = "wiki";
        scheduler.scheduleJob(QuartzUtil.generateJobDetail(job, name, group),
                QuartzUtil.generateTrigger("1/1 * * * * ?"));
    }
}
