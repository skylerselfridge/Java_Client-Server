package serv;



import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import serv.SQL.MySQLCon;
import serv.net.PipelineFactory;
import serv.obj.Client;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class Server {

    int port;
    public static MySQLCon sql;
    public static ArrayList<Client> live_clients = new ArrayList<Client>();

    private static final ServerBootstrap bootstrap = new ServerBootstrap(
            new NioServerSocketChannelFactory(
                    Executors.newCachedThreadPool(),
                    Executors.newCachedThreadPool()
            )
    );
    private static final Logger logger = Logger.getLogger(Server.class.getName());

    public static void main(String[] args){
        Server server = new Server(8000);

        bootstrap.setOption("keepAlive",true);
        bootstrap.setPipelineFactory(new PipelineFactory());
        bootstrap.bind(new InetSocketAddress(server.port));



        logger.info("Server binded on port: " + server.port);

        //start up sql
        sql = new MySQLCon();
    }

    public Server(int port){
        this.port = port;
    }

    public static boolean addUserToServerList(Client user){
        for(Client c : live_clients){
           if(c.getUsername().equals(user.getUsername())){
               return false; //multilog error
           }
        }
        live_clients.add(user);
        return true;
    }
}
