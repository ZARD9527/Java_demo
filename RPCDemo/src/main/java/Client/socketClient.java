package Client;

import Entity.Request;
import Entity.Response;

import java.io.*;
import java.net.Socket;

/**
 * @author y1881
 * @date 2020.3.28 9:28
 */

/**
 * 客户端代码包含两部分 socketClient.java和SocketClientProxy.java
 * 建立socket连接，发送请求并接收服务器返回信息
 */
public class socketClient {
    private Socket socket;
    public socketClient(){

    }

    /**
     * @param request 发送给服务器的请求
     * @param Ip
     * @param port
     * @return
     * @throws IOException
     */
    public Object invoke(Request request, String Ip, int port) throws IOException{
        socket = new Socket(Ip, port);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        ObjectOutputStream objOut;
        ObjectInputStream objIn;
        Response response = null;
        try{
            objOut = new ObjectOutputStream(out);
            objOut.writeObject(request);
            objOut.flush();
            objIn = new ObjectInputStream(in);
            Object res = objIn.readObject();
            if(res instanceof Response) {
                response = (Response) res;
            }else{
                throw new RuntimeException("返回对象不准确");
            }
        }catch (Exception e){
            System.out.println("error:" + e.getMessage());
        }finally {
            out.close();
            in.close();
            socket.close();
            return response.getObj();
        }
    }
}
