package com.bootmybatis.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by mr on 2018/12/29.
 */
@Controller
public class BatchController {
    @Autowired
    JobLauncher jobLauncher;
    @Autowired
    Job importJob;

    public JobParameters jobParameters;

    @RequestMapping(value = "/batch")
    @ResponseBody
    public String exec() throws Exception {
        String path = "data.xlsx";
        jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis()).addString("input.file.name", path).toJobParameters();
        jobLauncher.run(importJob, jobParameters);
        return "ok";
    }

}
