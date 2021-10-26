package practice;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author: neo
 * @date: 2021/10/26
 * @description: 图
 */
public class GraphPractice {

    public static void main(String[] args) {
        Map<String, List> graphMap = getGraphMap();
        System.out.println(searchMangoSeller(graphMap, "you"));
    }

    private static boolean searchMangoSeller(Map<String, List> graphMap, String name) {
        Deque<String> searchQueue = new LinkedList();
        searchQueue.addAll(graphMap.get(name));
        List searched = new LinkedList<>();
        
        while (!searchQueue.isEmpty()) {
            System.out.println("searchQueue:" + searchQueue);
            System.out.println("searched:" + searched + "\n");
            
            String person = searchQueue.pop();
            if (!searched.contains(person)) {
                if (personIsSeller(person)) {
                    System.out.println(person + " is a mango seller");
                    return true;
                } else {
                    searchQueue.addAll(graphMap.get(person));
                    searched.add(person);
                }
            }
        }

        return false;
    }

    private static boolean personIsSeller(String name) {
        return name.endsWith("m");
    }

    private static Map<String, List> getGraphMap() {
        Map<String, List> graphMap = new HashMap<>();

        List<String> list = new LinkedList();
        list.add("alice");
        list.add("bob");
        list.add("claire");
        graphMap.put("you", list);

        list = new LinkedList();
        list.add("anuj");
        list.add("peggy");
        graphMap.put("bob", list);

        list = new LinkedList();
        list.add("peggy");
        graphMap.put("alice", list);

        list = new LinkedList();
        list.add("thom");
        list.add("jonny");
        graphMap.put("claire", list);

        list = new LinkedList();
        graphMap.put("anuj", list);

        list = new LinkedList();
        graphMap.put("peggy", list);

        list = new LinkedList();
        graphMap.put("thom", list);

        list = new LinkedList();
        graphMap.put("jonny", list);
        
        return graphMap;
    }

}
