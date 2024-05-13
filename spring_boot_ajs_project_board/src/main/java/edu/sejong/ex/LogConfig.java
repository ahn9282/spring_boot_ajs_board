package edu.sejong.ex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.sejong.ex.LogTrace.LogTrace;
import edu.sejong.ex.LogTrace.ThreadLogTrace;

@Configuration
public class LogConfig {

    @Bean
    public LogTrace logTrace() {
      //  return new FieldTrace();
        return new ThreadLogTrace();
    }

}
