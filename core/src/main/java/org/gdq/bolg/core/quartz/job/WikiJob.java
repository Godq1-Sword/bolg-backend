package org.gdq.bolg.core.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * WikiJob
 *
 * @author gdq
 * date 2020/12/19
 */
public class WikiJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("helloWorld");
    }
}
