package zc.CommonClass;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class ComparatorTest {
        public static void main(String[] args) {
//        Map<StudentTree,Integer>map=new TreeMap<>(new Comparator<StudentTree>() {
//            @Override
//            public int compare(StudentTree o1, StudentTree o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });
            //构建TreeMap的时候要指定比较器
            Map<StudentTree,Integer> map=new TreeMap<>(new StudentByName());
            map.put(new StudentTree("a",99),2);
            map.put(new StudentTree("b",88),2);
            map.put(new StudentTree("c",77),3);

            for(var x:map.entrySet()){
                System.out.println(x.getValue());
            }
        }
    }

class StudentTree {
    private String name;
    private int score;

    public String getName(){
        return this.name;
    }

    public int getScore(){
        return this.score;
    }

    public StudentTree(String name,int score) {
        this.name = name;
        this.score = score;
    }


    @Override
    public String toString() {
        String msg=String.format("{%s:%d}",name,score);
        return msg;
    }
}

class StudentByName implements Comparator<StudentTree> {
    @Override
    public int compare(StudentTree o1, StudentTree o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
