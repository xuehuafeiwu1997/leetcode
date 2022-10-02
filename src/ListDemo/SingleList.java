package ListDemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 单链表的构造方法
 *
 * @author xmy
 * @date 2022/4/30 10:04 下午
 */
public class SingleList {

    //尾插法构造单链表
    public ListNode createList(Integer[] elements) {
        if (elements == null || elements.length == 0) {
            return null;
        }
        ListNode<Integer> head = new ListNode<>(elements[0]);
        ListNode p = head;
        for (int i = 0; i < elements.length; i++) {

        }
        return null;
    }

    public static void main(String[] args) {
        List<Map<String, String>> mapList = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("test1", "xumingyang1");
        mapList.add(map);
        map.put("test2", "xumingyang2");
        System.out.println(map.toString());

        List<Map<String, String>> tempMapList = new ArrayList<>();
        Map<String, String> temp = new HashMap<>();
        for (String key : map.keySet()) {
            temp.put("temp" + key, map.get(key));
            tempMapList.add(temp);
        }
        System.out.println(tempMapList);
    }
}

class Demo {
    String name;
}
