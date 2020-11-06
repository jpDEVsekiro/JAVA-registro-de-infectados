package con_pack;
import java.rmi.UnexpectedException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionFactory 
{               
    private static final String url="";
    private static final String user="";
    private static final String pass="";
    private static ConnectionFactory conexaoUltil;
    public static  ConnectionFactory getInstance() 
       {
           if(conexaoUltil==null)
           {
             conexaoUltil=new  ConnectionFactory(); 
           }
           return(conexaoUltil);
           
       }
    public Connection getConnection() throws SQLException,ClassNotFoundException,UnexpectedException
    {
      Class.forName("com.mysql.jdbc.Driver");
      return(DriverManager.getConnection(url, user, pass));
      
    }
   
}
