package com.qj.springbatchdemo.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/****
 *
 * author:lqm
 * 2019-05-27
 **/
@Configuration
@EnableBatchProcessing(modular = true)
public class MyJobLauncher {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private JobRegistry jobRegistry;

    @Autowired
    private JobDemo jobDemo;

    public void runJob(){

        try {
            //Job job = jobRegistry.getJob("demoJob");

            Job job = jobDemo.getJob();

            JobExecution jobExecution = jobLauncher.run(job,new JobParameters());

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
