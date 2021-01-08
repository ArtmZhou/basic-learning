package zc.IO;

import java.io.File;

/**
 * File类的使用
 *
 * 1.File类的一个对象代表一个文件或一个文件目录（俗称：文件夹）
 * 2.File类声明在java.io包下
*/
public class FileTest {
    /**
     *1.创建File类的实例
     *      方式一：File(String filePath)
     *      方式二：File(String parentPath,String childPath)
     *      方式三：File(File parentFile,String childPath)
     *2.相对路径：相较于某个路径下，指明的路径
     *  绝对路径：包含盘符在内的文件或文件目录的路径
     *  注意：-->windows和DOS系统默认使用"\"来表示路径分隔符
     *       -->UNIX和URL使用"/"来表示路径分隔符
     *3.File类涉及文件和文件目录的创建、删除、重命名、修改时间、文件大小等方法；
     * 但并未涉及到写入或读取文件内容的操作，如需读取或者写入文件内容，必须使用IO流来完成
     * 4.File类的对象常会作为参数传递到流的构造器当中
     * */
    public void test1(){
        //方式一的相对路径创建
        File file=new File("helloworld.txt");//相对于当前module,如果是写在main方法下，则是相较于当前工程下
    }

    public void test2(){
        File file=new File("E:\\workspace\\githubcode\\basic learning\\src\\zc");
        //此类遍历file文件夹是输出所有的文件名
        String[] list=file.list();
        for(String s:list){
            System.out.println(s);
        }
        System.out.println("----------------------");
        //此类遍历file文件夹是输出所有的文件绝对路径
        File[] files=file.listFiles();
        for(File f:files){
            System.out.println(f);
        }

        //public boolean renameTo(File dest):把文件重命名为指定的文件路径（相当于移动文件并改名）
        //例如：file1.renameTo(file2)
        //     要想保证返回true，需要file1在硬盘中存在且file2不存在

        /*
         * boolean isDirectory() 判断是否是文件目录
         * boolean isFile()  判断是否是文件
         * boolean exists()  判断是否存在
         * boolean canRead()  判断是否可读
         * boolean canWrite()  判断是否可写
         * boolean isHidden()  判断是否隐藏
         * boolean createNewFile() 创建文件，如果存在，不创建，返回false
         * boolean mkdir()  创建文件目录。如果文件目录存在，不创建；如果此文件目录的上层目录不存在，也不创建
         * boolean mkdirs()  创建文件目录，如果上层文件目录不存在，一并创建
         * boolean delete()  删除文件或者文件夹   java中的删除不走回收站
          */
    }

    public static void main(String[] args) {
        new FileTest().test2();
    }
}

