package zc.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * - 唯一定位一台计算机
 *
 * - 127.0.0.1：本机localhost
 *
 * - ip地址分类：
 *
 *      IPV4：4个字节组成、IPV6：128位
 *
 *      公网（互联网）-私网（局域网）
 *
 * - 域名：记忆IP问题
 * */


/**
 * ### 端口
 *
 * 使用`class InetSocketAddress`
 *
 * 表示计算机上一个程序的进程
 *
 * 不同的进程有不同的端口号！用来区分软件
 *
 * 被规定0-65535
 *
 * TCP,UDP单个协议下端口号不能冲突
 *
 * 端口分类：1.共有端口0-1023（HTTP:80      HTTPS:443        FTP:21       Telent：23 )
 *
 *         2.程序注册端口：1024-49151，分配给用户或程序使用(Tomcat：8080       MySQL:3306)
 *
 * 		   3.动态、私有：49152-65535
 *
 * ```cmd命令```
 * netstat -ano        #cmd查看所有端口
 * netstat -ano|findstr "6000"        #查找特定端口
 * tasklist|findstr "7492"   #查看指定端口任务进程
 * ```cmd命令```
 *
 * 端口号和IP地址的组合得到一个网络套接字：Socket
 * */
public class TestInetAddress {
    public static void main(String[] args) {
        try {
            //查询本机地址
            InetAddress inetAddress1=InetAddress.getByName("127.0.0.1");
            System.out.println(inetAddress1);
            InetAddress inetAddress2=InetAddress.getByName("localhost");
            System.out.println(inetAddress2);
            InetAddress inetAddress3=InetAddress.getLocalHost();
            System.out.println(inetAddress3);

            //查询网站IP
            InetAddress inetAddress4=InetAddress.getByName("www.bilibili.com");
            System.out.println(inetAddress4);
            //常用方法
            System.out.println(inetAddress4.getHostName());//获得域名
            System.out.println(inetAddress4.getHostAddress());//获得ip
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
