package zc.LearningThread;

/**
 * 静态代理模式总结
 * 真是对象和代理对象都要实现同一个接口
 * 代理对象要代理真实角色
 *
 * 好处：代理对象可以做很多真实对象做不了的事情
 * 真实对象可以专注做自己的事情
 * */
public class StaticProxy {
    public static void main(String[] args) {

        You you=new You();
        WeddingCompany weddingCompany=new WeddingCompany(you);
        weddingCompany.HappyMarry();
    }
}

interface Marry{
    void HappyMarry();
}

//真实对象
class You implements Marry{
    @Override
    public void HappyMarry() {
        System.out.println("zc is going to marry lzn");
    }
}

class  WeddingCompany implements Marry{
    //代理谁--》真实目标角色
    private Marry target;

    public WeddingCompany(Marry target){
        this.target=target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();//这是真实对象
        after();
    }

    private void before(){
        System.out.println("结婚前，布置现场");
    }
    private void after(){
        System.out.println("结婚后，收取尾款");
    }
}