package com.qj.springbatchdemo.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


/****
 * author:lqm
 * 2019-05-27
 **/
@Slf4j
@Component
public class JobDemo {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    private int num = 0;

    public Job getJob(){
        return jobBuilderFactory.get("demoJob")
                .incrementer(new RunIdIncrementer())
                .start(getStep())
                .build();
    }

    public Step getStep(){
        return stepBuilderFactory.get("demoStep")
                .chunk(2)
                .reader(getReader())
                .processor(getProcessor())
                .writer(getWriter())
                .build();
    }

    public ItemProcessor getProcessor() {
        return (s)->{
            log.info("processor process data!");
            return s;
        };
    }

    public ItemReader<String> getReader(){
        return (()->{
            if(num == 0) {
                num++;
                return "ths first spring batch demo! read data";
            } else {
                return null;
            }
        });
    }

    public ItemWriter<String> getWriter(){
        return (list -> {
            list.stream().forEach(s-> log.info("received data is:{}",s));
        });

    }
}
