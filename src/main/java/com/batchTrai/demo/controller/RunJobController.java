package com.batchTrai.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/springbatch")
@RequiredArgsConstructor
public class RunJobController {

    private final JobLauncher jobLauncher;
    private final Job job;

    @PostMapping("/jobs")
    public void csvToDb() {

        JobParameters jobParameter = new JobParametersBuilder()
                .addLong("Start At", System.currentTimeMillis())
                .addString("inputFilePath", "src/main/resources/Employee_Sample_Data.csv")
                .toJobParameters();

        try {
            jobLauncher.run(job, jobParameter);
        } catch (JobExecutionAlreadyRunningException | JobParametersInvalidException |
                 JobInstanceAlreadyCompleteException | JobRestartException e) {
            e.printStackTrace();
        }
    }
}
