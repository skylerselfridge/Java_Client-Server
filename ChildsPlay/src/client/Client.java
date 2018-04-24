package client;

import client.obj.ClientObj;
import client.packets.impl.sent.LoginPacket;
import client.packets.impl.sent.RegistrationPacket;
import client.packets.impl.sent.UserInformationUpdatePacket;
import client.tools.Net;
import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import client.net.PipeLineFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class Client {

    int port;
    String host;
    public static Channel server_connection;
    public static ClientObj user;


    public Client(int port, String host){
        this.port = port;
        this.host = host;
    }

    public static void main(String[] args) throws Exception {

        Client client = new Client(8000,"127.0.0.1");

        ChannelFactory factory =
                new NioClientSocketChannelFactory(
                        Executors.newCachedThreadPool(),
                        Executors.newCachedThreadPool());

        ClientBootstrap bootstrap = new ClientBootstrap(factory);

        bootstrap.setPipelineFactory(new PipeLineFactory());

        bootstrap.setOption("keepAlive", true);

        server_connection = bootstrap.connect(new InetSocketAddress(client.host, client.port)).getChannel();

        System.out.println("Connected to server on port: " + client.port);

        Net.registerAccount("Skyler", "skylerscat#@$1","Skyler","Selfridge","Skyler.s@gmail.com","6074357305");

    }

}
