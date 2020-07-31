package Data;
import java.sql.Connection;
import java.sql.DriverManager;

public class OracleConection {
private Connection conexion;

 public static void main(String[] args) {
  OracleConection obconeccion=new OracleConection();
    obconeccion.Conectar();
    }
    
    public Connection getConexion() {
        return conexion;
    }

        public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    
    public OracleConection Conectar()
    {
        try{
        Class.forName("oracle.jdbc.OracleDriver");
        String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:XE";
        conexion= DriverManager.getConnection(BaseDeDatos,"aplicacion_sbc","aplicacion_sbc");
        if(conexion!=null)
        {
        System.out.println("Conexion exitosa a esquema aplicacion_sbc");
        }
        else{System.out.println("Conexion fallida");}
        }
        catch(Exception e)
        {e.printStackTrace();}
       
    return this;
    }

}
