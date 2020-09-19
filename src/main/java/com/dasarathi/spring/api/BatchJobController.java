package com.dasarathi.spring.api;

import com.dasarathi.spring.api.vo.CustomerService;
import com.dasarathi.spring.ex11.RunEx11;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/batch")
public class BatchJobController {
    private static final Logger LOG = LoggerFactory.getLogger(BatchJobController.class);
    private static final Random randomBoolean = new Random();
    private static final AtomicInteger counter = new AtomicInteger(10001);
    @Autowired
    private RunEx11 ex11;

    @GetMapping("/ex11/tasklet")
    public ResponseEntity startEx11() {
        CustomerService currentService = new CustomerService(CustomerService.createUID(), counter.incrementAndGet(), randomBoolean.nextBoolean());
        ex11.run(currentService);
        return ResponseEntity.ok(currentService);
    }

}
