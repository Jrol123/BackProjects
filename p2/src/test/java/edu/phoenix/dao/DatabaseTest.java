package edu.phoenix.dao;

import edu.phoenix.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DatabaseTest {
  private static final String NAME = "Name";
  private static final String LOGIN = "login";
  private static final String PASSWORD = "password";

  //? При полном тестировании всё ломается, но при частичном всё в порядке

  @Test
  void shouldAddUser() throws Exception {
    // Можно или так, или обработать исключения внутри, но тогда не будет работать 5-й тест
    assertTrue(Database.dataBase.isEmpty());

    Database.addUser(NAME, LOGIN, PASSWORD);

    assertEquals(1, Database.dataBase.size());

    User user = Database.dataBase.get(0);

    assertEquals(NAME, user.getName());
    assertEquals(LOGIN, user.getLogin());
    assertEquals(PASSWORD, user.getPassword());

    Database.dataBase.remove(0);

    assertTrue(Database.dataBase.isEmpty());
  }

  @Test
  void shouldReturnUser() {
    assertTrue(Database.dataBase.isEmpty());

    Database.dataBase.add(new User(NAME, LOGIN, PASSWORD));

    User user = Database.getUser(LOGIN, PASSWORD);

    assertNotNull(user);

    assertEquals(NAME, user.getName());
    assertEquals(LOGIN, user.getLogin());
    assertEquals(PASSWORD, user.getPassword());

    Database.dataBase.remove(0);

    assertTrue(Database.dataBase.isEmpty());
  }

  @Test
  void shouldDeleteUser() {
    assertTrue(Database.dataBase.isEmpty());

    Database.dataBase.add(new User(NAME, LOGIN, PASSWORD));

    Database.deleteUser(LOGIN);

    assertTrue(Database.dataBase.isEmpty());
  }

  @Test
  void shouldUpdateUser() {
    assertTrue(Database.dataBase.isEmpty());

    Database.dataBase.add(new User(NAME, LOGIN, PASSWORD));

    String updatedName = "new name";
    String updatedPassword = "new password";

    User updated = new User(updatedName, LOGIN, updatedPassword);

    Database.updateUser(updated);

    User fromDB = Database.dataBase.get(0);

    assertEquals(updatedName, fromDB.getName());
    assertEquals(updatedPassword, fromDB.getPassword());

    Database.dataBase.remove(0);

    assertTrue(Database.dataBase.isEmpty());
  }

  @Test
  void addEmptyUser(){
    assertTrue(Database.dataBase.isEmpty());

    Exception thrown = assertThrows(Exception.class, () -> Database.addUser("Artemii", "", ""));

      assertEquals("Параметры не могут быть пустыми", thrown.getMessage());
  }
}