package com.dasarathi.spring.ex11.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class UserTaskTwo implements Tasklet {
    private static final Logger LOG = LoggerFactory.getLogger(UserTaskTwo.class);
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception
    {
        return RepeatStatus.FINISHED;
    }
}