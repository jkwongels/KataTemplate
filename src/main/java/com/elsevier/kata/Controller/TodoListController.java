package com.elsevier.kata.Controller;

import com.elsevier.kata.Model.Item;
import com.elsevier.kata.Model.NewItemRequest;
import com.elsevier.kata.Service.TodoListService;
import java.util.List;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@Slf4j
public class TodoListController {

  @Autowired
  TodoListService todoListService;


  @GetMapping("")
  public ResponseEntity<List<Item>> getList() {
    return ResponseEntity.ok(todoListService.getList());
  }

  @PostMapping("add")
  public ResponseEntity<List<Item>> addItemToList(@RequestBody NewItemRequest newItemRequest)
      throws Exception {
    List<Item> newItemList = todoListService.addItem(newItemRequest);
    return ResponseEntity.ok(newItemList);
  }

  @DeleteMapping("remove/{id}")
  public ResponseEntity<List<Item>> removeAnItem(@PathVariable String id) {
    List<Item> newList = todoListService.removeItem(id);
    return ResponseEntity.ok(newList);
  }

}
