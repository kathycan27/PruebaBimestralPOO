import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Tienda {
    private JPanel panel1;
    private JTextField txtfruta;
    private JTextField textField2;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton crearButton;
    private JButton buscarButton;
    private JButton btnactualizar;
    private JButton borrarButton;
    Statement st;
    ResultSet rs;
    PreparedStatement ps;
    public Tienda() {
        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                Connection conexion;
                try
                {
                    conexion = getConnection();

                    String query = "SELECT * FROM frutas" + " WHERE FRUTA = " + txtfruta.getText() + ";";

                    st = conexion.createStatement();
                    rs = st.executeQuery(query);
                    if (rs.next())
                    {
                        JOptionPane.showMessageDialog(null,"dado enco");
                    }else{
                        JOptionPane.showMessageDialog(null,"no");
                        conexion.close();
                    }

                } catch (HeadlessException |SQLException ex) {
                    System.err.println(ex);
                }



            }
        });
        btnactualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection con;
            }
        });
    }


    public static void main(String[] args) {
        JFrame frame=new JFrame("Tienda de abarrotes");
        frame.setContentPane(new Tienda().panel1);
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public static Connection getConnection() {
        Connection con = null;
        String base = "tienda";
        String url = "jdbc:mysql://localhost:3306/" + base;
        String user = "root";
        String password = "Luchito2724";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
        }
        return con;
    }
}

