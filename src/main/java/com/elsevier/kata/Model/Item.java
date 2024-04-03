package com.elsevier.kata.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Item {

  String id;
  String content;
  Boolean completed;
}
