package com.elsevier.kata.Config;

import com.elsevier.kata.Model.Item;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TodoConfig {
  @Bean
  public List<Item> beanList(){
    return new ArrayList<>();
  }
}
