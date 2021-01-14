package zc.LearningThread;

/**
 * 必须是函数式接口，才能用lambda表达式
 *
 * ()->{}
 * ()是形参列表
 * ->是lambda操作符
 * {}是方法体
 * */
public class TestLambda {

    //3.静态内部类
    static class Like2 implements ILike{
        @Override
        public void lambda() {
            System.out.println("i like lambda2");
        }
    }
    public static void main(String[] args) {
        //定义一个ILike接口
        ILike like=new Like();
        like.lambda();

        like=new Like2();
        like.lambda();

        //4.局部内部类
        class Like3 implements ILike{
            @Override
            public void lambda() {
                System.out.println("i like lambda3");
            }
        }
        like=new Like3();
        like.lambda();


        //匿名内部类，没有类的名称，必须借助接口或者父类
        like =new ILike() {
            @Override
            public void lambda() {
                System.out.println("i like lambda4");
            }
        };
        like.lambda();

        //6.用lambda简化
        like=()->{
            System.out.println("i like lambda5");
        };
        like.lambda();

    }
}


//1.定义一个函数式接口
interface ILike{
    void lambda();
}

//2.实现类
class Like implements ILike{
    @Override
    public void lambda() {
        System.out.println("i like lambda");
    }
}