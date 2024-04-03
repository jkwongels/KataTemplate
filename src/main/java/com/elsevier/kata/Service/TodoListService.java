package com.elsevier.kata.Service;

import com.elsevier.kata.Model.Item;
import com.elsevier.kata.Model.NewItemRequest;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class TodoListService {
  private List<Item> beanList;

  public TodoListService(List<Item> beanList){
    this.beanList = beanList;
  }

  // get list
  public List<Item> getList(){
    return this.beanList;
  }

  // add item to list
  public List<Item> addItem(NewItemRequest newItemRequest) throws Exception {
    boolean isDuplicateContent = this.beanList.stream().anyMatch(item -> newItemRequest.getContent().equals(item.getContent()));
    if(isDuplicateContent){
      throw new Exception("Duplicate content found");
    }

    this.beanList.add(new Item(UUID.randomUUID().toString(), newItemRequest.getContent(), false));

    return this.beanList;
  }

  // remove item from list
  public List<Item> removeItem(String id){
    this.beanList = this.beanList.stream().filter(item -> !id.equals(item.getId())).collect(
        Collectors.toList());

    return this.beanList;
  }

}
