package store;

import models.User;
import models.Todo;

import java.util.*;

public class Store {

    private static Store instance = null;
    private int todoId = 0;
    private Map<String, User> accounts = null;
    private List<Todo> todoList = null;
    private Map<String, String> userToken = null;
    //private Map<Date,Integer> deletedTodos = null;


    private Store(){
        this.accounts = new HashMap<String, User>();
        this.todoList = new ArrayList<Todo>();
        this.userToken = new HashMap<String, String>();
        /*this.deletedTodos = new HashMap<Date, Integer>();*/
    }

    public synchronized static Store getInstance(){
        if(instance == null){
            instance = new Store();
        }

        return instance;
    }


    public synchronized Map<String, User> getAccounts() {
        return accounts;
    }

    public synchronized List<Todo> getTodoList() {
        return todoList;
    }

    public synchronized Map<String, String> getUserTokenMap(){
        return userToken;
    }

    public synchronized long createUser(User u){

        long userExist = -1;
        if(!accounts.containsKey(u.getUserName())){
            //u.setUserId(++userId);
            accounts.put(u.getUserName(), u);
            userExist = 1;
        }

        return userExist;
    }

    public User findUser(String username){
        return accounts.get(username);
    }

    public synchronized Todo createTodo(User user,String title,String description){
        Todo todo = new Todo(todoId++,title,description);
        todo.setCreatedBy(user.getUserName());
        return todo;
    }
    public synchronized void setUserToken(String userToken,String username){
        this.userToken.put(userToken,username);
    }
}
