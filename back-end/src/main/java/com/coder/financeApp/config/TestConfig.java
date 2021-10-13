package com.coder.financeApp.config;

import com.coder.financeApp.model.CashFlow;
import com.coder.financeApp.repository.CashFlowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

//@Configuration
//@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private CashFlowRepository userRepository;


    @Override
    public void run(String... args) throws Exception {

        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2021-09-31 23:34");

//        CashFlow c1 = new CashFlow(null, "Mercado", 188.0, "Louco", date.toInstant());
//        CashFlow c2 = new CashFlow(null, "Lojas americanas", 21.0, "Muito massa", date.toInstant());

//        userRepository.saveAll(Arrays.asList(c1, c2));

    }
}