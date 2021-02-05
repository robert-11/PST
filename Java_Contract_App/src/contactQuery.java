
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
    
    public void insertContact(contact cont)
    {
        Connection con = null;
        try {
            con = myConnection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement ps;
        
        try {
            ps = con.prepareStatement("INSERT INTO `mycontact`(`fname`, `lname`, `phone`, `email`, `inmatric`, `dataitp`, `status`, `userid`) VALUES (?,?,?,?,?,?,?,?)");
            ps.setString(1, cont.getFname());
            ps.setString(2, cont.getLname());
            ps.setString(3, cont.getPhone());
            ps.setString(4, cont.getEmail());
            ps.setString(5, cont.getInmatric());
            ps.setString(6, cont.getDataitp());
            ps.setString(7, cont.getStatus());
            ps.setInt(8, cont.getUid());
            
            if(ps.executeUpdate() !=0){
                JOptionPane.showMessageDialog(null, "New Contact Added");
                
            }else{
                JOptionPane.showMessageDialog(null, "Something Wrong");
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void updateContact(contact cont)
    {
        Connection con = null;
        try {
            con = myConnection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement ps;
        String updateQuery = "UPDATE `mycontact` SET `fname`=?,`lname`=?,`phone`=?,`email`=?,`inmatric`=?,`dataitp`=?, `status`=? WHERE `id` = ?";
        
        try {
            ps = con.prepareStatement(updateQuery);
            ps.setString(1, cont.getFname());
            ps.setString(2, cont.getLname());
            ps.setString(3, cont.getPhone());
            ps.setString(4, cont.getEmail());
            ps.setString(5, cont.getInmatric());
            ps.setString(6, cont.getDataitp());
            ps.setString(7, cont.getStatus());
            ps.setInt(8, cont.getCid());
            
            if(ps.executeUpdate() !=0){
                JOptionPane.showMessageDialog(null, "Contact Data Edited");
                
            }else{
                JOptionPane.showMessageDialog(null, "Something Wrong");
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void deleteContact(int cid)
    {
        Connection con = null;
        try {
            con = myConnection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement ps;
        
        try {
            ps = con.prepareStatement("DELETE FROM `mycontact` WHERE `id` = ?");
            ps.setInt(1, cid);

            
            if(ps.executeUpdate() !=0){
                JOptionPane.showMessageDialog(null, "Contact Deleted");
                
            }else{
                JOptionPane.showMessageDialog(null, "Something Wrong");
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    //crearea listei de contacte
    public ArrayList<contact> contactList( int userId){
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
            rs = st.executeQuery("SELECT `id`, `fname`, `lname`, `phone`, `email`, `inmatric`, `dataitp`, `status` FROM `mycontact` ");
            
            contact ct;
            
            while(rs.next()){
                ct = new contact(rs.getInt("id"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("inmatric"),
                        rs.getString("dataitp"),
                        rs.getString("status"),
                        userId);    
                
                clist.add(ct);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clist;
        
    }
    
    
}
