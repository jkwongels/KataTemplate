package com.elsevier.kata.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.elsevier.kata.Model.Item;
import com.elsevier.kata.Model.NewItemRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodoListServiceTest {

  private TodoListService todoListService;

  @BeforeEach
  void beforeEach(){

    todoListService = new TodoListService(new ArrayList<Item>());
  }

  @Test
  void willReturnTheList(){
    List<Item> list = todoListService.getList();
    assertEquals(list, new ArrayList<Item>());
  }

  @Test
  void willAddItemToTheList() throws Exception {
    String uuid = UUID.randomUUID().toString();
    List<Item> list = todoListService.addItem(new NewItemRequest("something for test"));
    assertEquals(list.get(0).getCompleted(), false);
    assertEquals(list.get(0).getContent(), "something for test");
  }

  @Test
  void willThrowExceptionWhenDuplicateItem() throws Exception{
    todoListService.addItem(new NewItemRequest("something for test"));
    assertThrows(Exception.class, () ->todoListService.addItem(new NewItemRequest("something for test")));
  }

  @Test
  void willRemoveAnItemToTheList() throws Exception {
    // add item to the list first
    String uuid = UUID.randomUUID().toString();
    List<Item> listWithAnItem = todoListService.addItem(new NewItemRequest("something for test"));

    // then remove it
    List<Item> list = todoListService.removeItem(listWithAnItem.get(0).getId());
    assertEquals(list, Collections.EMPTY_LIST);
  }
}
