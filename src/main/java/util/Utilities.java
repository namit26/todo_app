package util;

import models.Todo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import store.Store;
import javax.servlet.http.Cookie;
import java.util.List;


public class Utilities {
    private static Utilities instance = null;
    public static Utilities getInstance(){
        if(instance == null){
            instance = new Utilities();
        }

        return instance;
    }
    public String trimString(String desc){
        String slicedDesc = "";
        for(int i = 0 ;i<25 && i<desc.length();i++){
            slicedDesc += desc.charAt(i);
        }
        slicedDesc += "...";
        return slicedDesc;
    }

    public boolean validateSession(Cookie[] cookies){
        Cookie cookie = null;
        for(Cookie temp : cookies){
            if("userToken".equals(temp.getName())){
                cookie = temp;
                break;
            }
        }
        if(Store.getInstance().getUserTokenMap().get(cookie.getValue()) == null){
            return false;
        }
        else{
            return true;
        }
    }

    public JSONObject makeJSONObject(List<Todo> todoList){
        Integer i = 1;
        JSONObject obj = new JSONObject();
        for(Todo todo:todoList){
            JSONArray array = new JSONArray();
            array.add(todo.getStatus());
            array.add(todo.getTodoId());
            array.add(todo.getTitle());
            array.add(todo.getDesc());
            array.add(todo.getCreated().toString());
            array.add(todo.getAssignedTo());
            obj.put(i.toString(), array);
            i++;
        }
        return obj;
    }

}


