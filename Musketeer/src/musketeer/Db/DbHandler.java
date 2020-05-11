/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musketeer.Db;

/**
 *
 * @author ITD-STU
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import musketeer.pbo.kasir;

public class DbHandler {

    private Connection connection;
    private boolean connected;
    public List<kasir> test = new ArrayList<kasir>();
    public int counter = 0;

    public DbHandler() {
        this.connected = false;
    }

    public boolean connect(String _host, String _dbName, String _username, String _password) {
        String connectionString = "jdbc:mysql://" + _host + "/" + _dbName;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(connectionString, _username, _password);
            this.connected = true;
        } catch (Exception _e) {
            System.out.println("Exception: " + _e.getMessage());
            this.connected = false;
        }
        return (this.connected);
    }

    public void disconnect() {
        if (this.connected) {
            try {
                this.connection.close();
            } catch (Exception _e) {
                System.out.println("Exception: " + _e.getMessage());
            }
        }
        this.connected = false;
    }

    public boolean isConnected() {
        return (this.connected);
    }

    public void getalldaftarmenu() {
        //contact c = null;
        if (this.connected) {
            String query = "SELECT * FROM musketeer.Tables.daftarmenu";
            try {

                Statement stmt = this.connection.createStatement();

                ResultSet resultSet = stmt.executeQuery(query);

                while (resultSet.next()) {
                    counter++;
                    kasir k = new kasir();
                    k.setnamaPesanan(resultSet.getString("namaBarang"));
                    k.sethargaPesanan(resultSet.getString("hargaBarang"));
                    k.setbayar(resultSet.getString("jmlharga"));
                    k.setjumlah(resultSet.getInt("banyaknya"));
                    this.test.add(k);

                }
            } catch (Exception _e) {

                System.out.println("Exception: " + _e.getMessage());
            }
        }

    }

    public void tambahDaftarMenu(String _beforenamaPesanan, String _beforehargaPesanan, String _beforebayar, int _beforejumlah, String _afternamaPesanan, String _afterhargaPesanan, String _afterbayar, int _afterjumlah) {
        String query = "UPDATE daftarmenu SET namaBarang='" + _afternamaPesanan + "' , hargaBarang='" + _afterhargaPesanan + "', jmlharga='" + _afterbayar + "' , banyaknya='" + _afterjumlah + "' WHERE namaBarang='" + _beforenamaPesanan + "' AND hargaBarang='" + _beforehargaPesanan + "'AND jmlharga='" + _beforebayar + "'AND banyaknya='" + _beforejumlah + "'";      
        if (this.connected) {
            try {
                Statement stmt = this.connection.createStatement();
                ResultSet res = stmt.executeQuery(query);

            } catch (Exception _e) {
                System.out.println("Exception: " + _e.getMessage());
            }

        }

    }
}
