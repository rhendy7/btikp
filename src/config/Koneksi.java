
package config;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;





public class Koneksi
{
  private String user = "root";
  private String pass = "";
  private String url = "jdbc:mysql://localhost:3306/btikp";
  private Connection con = null;
  private Statement st = null;
  
  public Koneksi() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      return;
    } catch (ClassNotFoundException e) {
      System.out.println("Koneksi Gagal : " + e.getMessage());
    }
  }
    
  public Connection getConnection() throws SQLException {
    con = DriverManager.getConnection(url, user, pass);
    return con;
  }
  
  public ResultSet select(String sql) throws SQLException {
    con = DriverManager.getConnection(url, user, pass);
    st = con.createStatement();
    ResultSet rs = st.executeQuery(sql);
    return rs;
  }
  
  public void simpanData(String SQL){ 
     try { 
          Statement st = Koneksi.this.getConnection().createStatement();
          st.execute(SQL); 
          st.close(); 
          JOptionPane.showMessageDialog(null,"Data berhasil disimpan"); 
     } catch (Exception e) { 
           JOptionPane.showMessageDialog(null,"Maaf  Terjadi  Kesalahan    pada  bagian method simpanData : \n ["+e.toString() +"]"); 
     } 
 } 
}