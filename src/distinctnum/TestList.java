package distinctnum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @auther Yvqanlee
 * @data 2019/4/28 11:15
 */

/**
 * 测试list去重
 */
public class TestList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(11);
        list.add(22);
        System.out.println("原始list：" + list);

        getNewListByStream(list);
        //getNewListByDoubleFor(list);  //有bug
        getNewListBySet(list);
        getNewList(list);
        getNewListByList(list);
    }

    /**
     * 获得新的list
     * @param list  原始list
     * @return
     */
    private static void getNewListByStream(List<Integer> list){
        List<Integer> newList = list.stream().distinct().collect(Collectors.toList());
        System.out.println("java8Stream去重：" + newList);
    }

    /**
     * 双重for去重
     * @param list
     * @return
     */
    private static void getNewListByDoubleFor(List<Integer> list){
        for (int i=0;i<list.size();i++){
            for (int j=0;j<list.size();j++){
                if (i != j && list.get(i).equals(list.get(j))){
                    list.remove(list.get(j));
                }
            }
        }
        System.out.println("双重for去重：" + list);
    }

    /**
     * set集合判断去重
     * @param list
     * @return
     */
    private static void getNewListBySet(List<Integer> list){
        Set set = new HashSet();
        List<Integer> newList = new ArrayList<>();
        for (Integer integer : list){
            if (set.add(integer)){
                newList.add(integer);
            }
        }
        System.out.println("set去重：" + newList);
    }

    /**
     * set和list转换去重
     * @param list
     */
    private static void getNewList(List<Integer> list){
        Set set = new HashSet();
        List newList = new ArrayList();
        set.addAll(list);
        newList.addAll(set);
        System.out.println("set和list转换去重：" + newList);
    }

    /**
     * 遍历list给另外一个list
     * @param list
     */
    private static void getNewListByList(List<Integer> list){
        List<Integer> newList = new ArrayList<>();
        for (Integer integer : list){
            if (!newList.contains(integer)){
                newList.add(integer);
            }
        }
        System.out.println("通过list遍历后：" + newList);
    }



}
