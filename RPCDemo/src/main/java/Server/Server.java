package Server;

import Service.Imp.StudentServiceImp;
import Service.StudentService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author y1881
 * @date 2020.3.28 9:12
 */
public class Server {
    private ServerSocket serverSocket;
    private int servPort;

    public Server(int port) throws IOException {
        this.servPort = port;
        serverSocket = new ServerSocket(this.servPort);

    }
    public void start(){
        /**
         * corePoolSize:
         * maximumPoolSize:
         */
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 10,
                200, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10));
        while (true) {
            try {
                Socket sock = serverSocket.accept();
                ServerService service = new ServerService(sock);
                // 注册服务
                service.registerService(StudentService.class, StudentServiceImp.class);
                // 线程池执行这个服务
                threadPool.execute(service);
            } catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
