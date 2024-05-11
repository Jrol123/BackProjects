package TList.DB;

import java.util.ArrayList;
import java.util.List;

public class Tasklist {
    public static List<Task> dataBase = new ArrayList<>();

    public static void addTask(String name, String inside){
        dataBase.add(new Task(dataBase.size(), name, inside));
    }

    public static Task returnTask(int id){
        return dataBase.get(id);
    }
}
