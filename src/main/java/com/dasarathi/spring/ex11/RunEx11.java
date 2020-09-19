package com.dasarathi.spring.ex11;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class RunEx11 {
    private static final Logger LOG = LoggerFactory.getLogger(RunEx11.class);
    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job runJob;

    public void run() throws Exception {
        Map<String, String> ex11KV = new HashMap<>();
        ex11KV.put("IDEA", "v2020.x");
        ex11KV.put("JDK", "v1.8.x");
        ex11KV.put("SPRING", "v5.x");
        ex11KV.put("BOOT", "v2.3.x");
        ex11KV.put("BATCH", "v4.2.x");

        Map<String, JobParameter> jobParameterMap = new HashMap<>();

        for (Map.Entry<String, String> entry : ex11KV.entrySet()) {
            jobParameterMap.put(entry.getKey(), new JobParameter(entry.getValue(), true));
        }

        jobParameterMap.put("APPLICATION", new JobParameter("SPRING.BOOT.BATCH", false));
        
        JobParameters jobParameters = new JobParametersBuilder(new JobParameters(jobParameterMap)).toJobParameters();
        jobLauncher.run(runJob, jobParameters);
    }
}
