package zc.Enum;

public class EnumTest {
    public static void main(String[] args) {
        Season spring=Season.SPRING;
        System.out.println(spring);

        Season1 winter=Season1.WINTER;
        System.out.println(winter);
        //value()方法，返回枚举类中的对象数组
        Season1[] values=Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
    }
}

//自定义枚举类
class Season{
    //1.声明season对象属性  private final修饰
    private final String name;
    private final String desc;

    //2.构造器
    Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    //3.提供当前枚举类的多个对象
    public static final Season SPRING=new Season("春天","春暖花开");
    public static final Season SUMMER=new Season("夏天","夏日炎炎");
    public static final Season AUTUMN=new Season("秋天","秋高气爽");
    public static final Season WINTER=new Season("冬天","白雪皑皑");

    //4.其他诉求：获取枚举类对象的属性
    public String getName() {
        return name;
    }
    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{"+name+":"+desc+"}";
    }
}

//使用enum关键字定义枚举类
//默认继承于java.lang.enum类
interface info{
    void show();
}
enum Season1 implements info{
    //1.提供当前枚举类的对象，多个对象之间用“,”，最后用“;"
    SPRING("春天","春暖花开"){
        //实现接口方法
        @Override
        public void show() {
            System.out.println(1);
        }
    },
    SUMMER("夏天","夏日炎炎"){
        @Override
        public void show() {
            System.out.println(2);
        }
    },
    AUTUMN("秋天","秋高气爽"){
        @Override
        public void show() {
            System.out.println(3);
        }
    },
    WINTER("冬天","白雪皑皑"){
        @Override
        public void show() {
            System.out.println(4);
        }
    };

    //2.声明season对象属性  private final修饰
    private final String name;
    private final String desc;

    //3.构造器
    Season1(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    //4.其他诉求：获取枚举类对象的属性
    public String getName() {
        return name;
    }
    public String getDesc() {
        return desc;
    }

    //假如不重写这个方法，打印出来的是枚举类的名称（SPRING,SUMMER,AUTUMN,WINTER）
    @Override
    public String toString() {
        return "Season{"+name+":"+desc+"}";
    }
}
