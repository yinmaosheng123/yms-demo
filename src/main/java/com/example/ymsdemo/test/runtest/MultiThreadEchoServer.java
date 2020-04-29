package com.example.ymsdemo.test.runtest;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 基于Socket的服务端多线程模式
 * 服务器会为每一个客户端连接启用一个线程，这个新的线程将全心全意为这个
 * 客户端服务。同时，为了接受客户端连接，服务器还会额外使用一个派发线程
 */
public class MultiThreadEchoServer {
    private static ExecutorService tp = Executors.newCachedThreadPool();
    static class HandleMsg implements Runnable{
        Socket clientSocket;
        public HandleMsg(Socket clientSocket){
            this.clientSocket = clientSocket;
        }


        @Override
        public void run() {
            BufferedReader is = null;
            PrintWriter os = null;
            try {
                is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                os = new PrintWriter(clientSocket.getOutputStream(),true);
                //从InputStream当中读取客户端所发送的数据
                String inputLine = null;
                long b = System.currentTimeMillis();
                while ((inputLine = is.readLine())!=null){
                    os.println(inputLine);
                }
                long e = System.currentTimeMillis();
                System.out.println("spend:"+(e-b)+"-ms");

            } catch (IOException e){
                e.printStackTrace();
            } finally {
                try {
                    if(is!=null)is.close();
                    if(os!=null)os.close();
                    clientSocket.close();
                } catch (IOException e){
                    e.printStackTrace();
                }


            }
        }
    }

    public static void main(String[] args) {
        ServerSocket echoServer = null;
        Socket clientSocker = null;
        try{
            echoServer = new ServerSocket(8000);
        } catch (IOException e){
            System.out.println(e);
            e.printStackTrace();
        }
        while (true){
            try {
                clientSocker = echoServer.accept();
                System.out.println(clientSocker.getRemoteSocketAddress() + "connect");
                tp.execute(new HandleMsg(clientSocker));
            } catch (IOException e){
                System.out.println(e);
            }
        }


    }

}
