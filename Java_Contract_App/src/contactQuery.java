
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class contactQuery {
    
    public boolean insertContact(contact cont)
    {
        boolean contactIsCreated = true;
        Connection con = null;
        try {
            con = myConnection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement ps;
        
        try {
            ps = con.prepareStatement("INSERT INTO `mycontact`(`fname`, `lname`, `email`, `phone`, `inmatric`, `dataitp`, `userid`) VALUES (?,?,?,?,?,?,?)");
            ps.setString(1, cont.getFname());
            ps.setString(2, cont.getLname());
            ps.setString(3, cont.getPhone());
            ps.setString(4, cont.getEmail());
            ps.setString(5, cont.getInmatric());
            ps.setString(6, cont.getDataitp());
            ps.setInt(7, cont.getUid());
            
            if(ps.executeUpdate() !=0){
                JOptionPane.showMessageDialog(null, "New Contact Added");
                contactIsCreated = true;
            }else{
                JOptionPane.showMessageDialog(null, "Something Wrong");
                contactIsCreated = false;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contactIsCreated;
    }
    
    public ArrayList<contact> contactList(){
        ArrayList<contact> clist = new ArrayList<contact>();
        
        Connection con = null;
        try {
            con = myConnection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Statement st;
        ResultSet rs;
        
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT `id`, `fname`, `lname`, `email`, `phone`, `inmatric`, `dataitp` FROM `mycontact` ");
            
            contact ct;
            
            while(rs.next()){
                ct = new contact(rs.getInt("id"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("inmatric"),
                        rs.getString("dataitp"),
                        0);    
                
                clist.add(ct);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clist;
        
    }
    
    
}
