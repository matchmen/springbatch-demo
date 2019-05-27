package com.qj.springbatchdemo;

import com.qj.springbatchdemo.job.MyJobLauncher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbatchDemoApplicationTests {


    @Autowired
    MyJobLauncher myJobLauncher;



    @Test
    public void contextLoads() {
    }

    @Test
    public void jobTest(){
        myJobLauncher.runJob();
    }

}
