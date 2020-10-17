package com.example.demo.service;

import com.example.demo.models.Time;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@RequiredArgsConstructor
public class TimeService {
    public void parsingTime (@RequestParam String time){
        Time time1 = new Time();
        time1.setTime(time);
    }
}
