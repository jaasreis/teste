package dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource{

    private String hostname;
    private int port;
    private String database;
    private String username;
    private String password;
    
    private Connection connection;
    
    public DataSource(){
        try{
            hostname = "localhost";
            port     = 3306;
            database = "cruddb";  
            username = "root";
            password = "";
            
            String url = "jdbc:mysql://"+hostname+":"+port+"/"+database;
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connection = (Connection) DriverManager.getConnection(url, username, password);
            System.out.println("Deu certo...");
        }
        catch(SQLException ex){
            System.err.println("Erro na conexão "+ex.getMessage());
        }
        catch(Exception ex){
            System.err.println("Erro geral "+ex.getMessage());
        }
    }
    
    public Connection getConnection(){
        return this.connection;
    }
    
    public void closeDataSource(){
        try{
            connection.close();
        }
        catch(Exception ex){
            System.err.println("Erro ao desconectar "+ex.getMessage());
        }
            
    }
    
    /*
    
CREATE TABLE `clientes` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `email` varchar(80) DEFAULT NULL,
  `telefone` varchar(45) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


INSERT INTO `clientes` (`id`, `nome`, `email`, `telefone`) VALUES
(1, 'Daniel', 'daniel@teste.com', '222222'),
(2, 'joao', 'joao@joao.com', '345353453');

    */
}