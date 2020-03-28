import Client.SocketClientProxy;
import Entity.Student;
import Service.StudentService;
import Server.Server;

import java.io.IOException;

/**
 * @author y1881
 * @date 2020.3.28 9:59
 */

/**
 * 首先开启服务端，等待客户端调用
 */
public class test {
    public static void main(String [] arg){
        new Thread( () ->  {
            try {
                Server server = new Server(12000);
                server.start();
            } catch (IOException e){
                System.out.println(e.getMessage());
            }
        } ).start();

        SocketClientProxy proxy = new SocketClientProxy();
        // 反射的知识 getProxy意思是获取服务端的StudentService?
        StudentService studentService = proxy.getProxy(StudentService.class);
        Student student = studentService.getInfo();
        System.out.println("获取学生名字:" + student.getName());
        System.out.println("获取学生年龄:" + student.getAge());
    }
}
