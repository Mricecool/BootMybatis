package com.bootmybatis.batch;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * Job监听
 * Created by mr on 2018/12/29.
 */
public class BatchJobListener implements JobExecutionListener {

    long startTime;
    long endTime;

    @Override
    public void beforeJob(JobExecution jobExecution) {
        startTime = System.currentTimeMillis();
        System.out.println("Batch任务开始");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        endTime = System.currentTimeMillis();
        System.out.println("Batch任务结束，耗时 " + (endTime - startTime) + " ms");
    }
}
