package com.dasarathi.spring.ex11.job;

import com.dasarathi.spring.ex11.task.UserTaskOne;
import com.dasarathi.spring.ex11.task.UserTaskTwo;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class UserBatchConfig {

    @Autowired
    private JobBuilderFactory jobFactory;

    @Autowired
    private StepBuilderFactory stepFactory;

    @Bean
    public Step stepOne() {
        return stepFactory.get("EX11_STEP_ONE")
                .tasklet(new UserTaskOne())
                .build();
    }

    @Bean
    public Step stepTwo() {
        return stepFactory.get("EX11_STEP_TWO")
                .tasklet(new UserTaskTwo())
                .build();
    }

    @Bean
    public Job jobPreparation() {
        return jobFactory.get("EX11_JOB_ID_11")
                .incrementer(new RunIdIncrementer())
                .start(stepOne())
                .next(stepTwo())
                .build();
    }
}
