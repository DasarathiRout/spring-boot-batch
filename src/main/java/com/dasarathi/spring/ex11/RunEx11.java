package com.dasarathi.spring.ex11;

import com.dasarathi.spring.api.vo.CustomerService;
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

    public void run(CustomerService currentService) {
        Map<String, String> ex11KV = new HashMap<>();
        ex11KV.put("API", "v1.0");
        ex11KV.put("BID", Integer.toString(currentService.getId()));
        ex11KV.put("SSID", currentService.getName());
        ex11KV.put("STATUS", Boolean.toString(currentService.isActive()));
        Map<String, JobParameter> jobParameterMap = new HashMap<>();

        for (Map.Entry<String, String> entry : ex11KV.entrySet()) {
            jobParameterMap.put(entry.getKey(), new JobParameter(entry.getValue(), true));
        }

        jobParameterMap.put("APPLICATION", new JobParameter("SPRING.BOOT.BATCH", false));
        JobParameters jobParameters = new JobParametersBuilder(new JobParameters(jobParameterMap)).toJobParameters();

        try {
            jobLauncher.run(runJob, jobParameters);
        } catch (Exception e) {
            LOG.error("OOPS, Running Example-11 Failed.");
        } finally {
            ex11KV.clear();
            jobParameterMap.clear();
        }
    }
}
