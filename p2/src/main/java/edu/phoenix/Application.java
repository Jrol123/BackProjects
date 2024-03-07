package edu.phoenix;

import edu.phoenix.dao.Database;

public class Application {

  public static void main(String[] args) {
    System.out.print(Database.dataBase.isEmpty());
  }
}
