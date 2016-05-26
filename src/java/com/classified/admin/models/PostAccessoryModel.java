/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.models;

import com.classified.admin.vo.PostAccessoryVO;
import com.classified.admin.vo.ResultVO;
import com.classifiedindia.model.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a
 */
public class PostAccessoryModel implements PostAccessory{

    
    public ResultVO storePostAccessoryInfo(PostAccessoryVO postAccessoryVO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public PostAccessoryVO populatePostAccessoryInfo(int accessory_adv_id) {
        PostAccessoryVO postAccessoryVO= new PostAccessoryVO();
        try{
            if(0!=accessory_adv_id){
                DbConnection dbcon1=new DbConnection();
                Connection conn=dbcon1.dbConnect();
                Statement st2=conn.createStatement();
                String sqlQuery2= "select * from post_accessory_section where accessory_adv_id= "+accessory_adv_id;
                System.out.println("Test Query:" +sqlQuery2);
                ResultSet rs1= st2.executeQuery(sqlQuery2);
                if(rs1.next()){
                    postAccessoryVO.setAccessory_adv_id(rs1.getInt("accessory_adv_id"));
                    postAccessoryVO.setAccess_img_id(rs1.getDouble("access_img_id"));
                    postAccessoryVO.setAccess_title(rs1.getString("access_title"));
                    postAccessoryVO.setAccess_condition(rs1.getString("access_condition"));
                    postAccessoryVO.setAccessry_brand_id(rs1.getInt("accessry_brand_id"));
                    postAccessoryVO.setAccessory_id(rs1.getInt("accessory_id"));
                    postAccessoryVO.setAccess_descript(rs1.getString("access_descript"));
                    postAccessoryVO.setAccess_typof_ad(rs1.getString("access_typof_ad"));
                    postAccessoryVO.setAccess_price(rs1.getDouble("access_price"));
                    postAccessoryVO.setAccess_xpect_price(rs1.getDouble("access_xpect_price"));
                    postAccessoryVO.setAccess_posting_date(rs1.getString("access_posting_date"));
                    postAccessoryVO.setAccess_subcat_id(rs1.getInt("access_subcat_id"));
                    
                }
            }
        }
        catch(Exception e){
            e.getMessage();
        }
        return postAccessoryVO;
    }

    
    public ResultVO deletePostAccessoryInfo(int accessory_adv_id) {
        ResultVO resultVO= new ResultVO();
        try{
            if(0!=accessory_adv_id){
                DbConnection dbcon1=new DbConnection();
                Connection con1=dbcon1.dbConnect();
                Statement st1=con1.createStatement();
                String sqlQuery1="delete from post_accessory_section where accessory_adv_id= "+accessory_adv_id;
                System.out.println("Test Query: " +sqlQuery1);
                int rowsAffected=st1.executeUpdate(sqlQuery1);
                if(rowsAffected >0){
                    resultVO.setMessage("One Row Deleted");
                }
                else{
                    resultVO.setMessage("No Row Deleted");
                }
            }
        }catch(Exception e){
            e.getMessage();
        }
        return resultVO;
    }

    
    public PostAccessoryVO modifyPostAccessoryInfo(PostAccessoryVO postAccessoryVO) {
        if(null!=postAccessoryVO){
            int accessory_adv_id= postAccessoryVO.getAccessory_adv_id();
            double access_img_id= postAccessoryVO.getAccess_img_id();
            String access_title= postAccessoryVO.getAccess_title();
            String access_condition= postAccessoryVO.getAccess_condition();
            int accessry_brand_id= postAccessoryVO.getAccessry_brand_id();
            int accessory_id= postAccessoryVO.getAccessory_id();
            String access_descript= postAccessoryVO.getAccess_descript();
            String access_typof_ad= postAccessoryVO.getAccess_typof_ad();
            double access_price= postAccessoryVO.getAccess_price();
            double access_xpect_price= postAccessoryVO.getAccess_xpect_price();
            String access_posting_date= postAccessoryVO.getAccess_posting_date();
            int access_subcat_id= postAccessoryVO.getAccess_subcat_id();
            try{
                DbConnection dbcon2= new DbConnection();
                Connection con2= dbcon2.dbConnect();
                Statement st2= con2.createStatement();
                String updateQuery= "update post_accessory_section set access_img_id='"+access_img_id+"', access_title= '"+ access_title +"', access_condition= '"+ access_condition +"', accessry_brand_id= '"+ accessry_brand_id +"', accessory_id= '"+ accessory_id +"', access_descript= '"+ access_descript +"', access_typof_ad= '"+ access_typof_ad +"', access_price= '"+ access_price +"', access_xpect_price= '"+ access_xpect_price +"', access_posting_date= '"+ access_posting_date +"', access_subcat_id= '"+ access_subcat_id +"' where accessory_adv_id=" + accessory_adv_id;
                System.out.println("Update Query:" + updateQuery);
                int rowsAffected1=st2.executeUpdate(updateQuery);
                if(rowsAffected1 > 0){
                    
                }
            }
            catch(Exception e){
                e.getMessage();
            }
        }
        return postAccessoryVO;
    }

    
    public ResultVO searchPostAccessoryInfo(int accessory_adv_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    public List<PostAccessoryVO> viewAllPostAccessoryInfo() {
        List<PostAccessoryVO> listOfPostAccessory=new ArrayList<PostAccessoryVO>();
        try{
            DbConnection dbcon=new DbConnection();
            Connection con=dbcon.dbConnect();
            Statement st=con.createStatement();
            String sqlQuery="select * from post_accessory_section";
            ResultSet rs=st.executeQuery(sqlQuery);
            PostAccessoryVO postAccessoryVO=null;
            while(rs.next()){
                postAccessoryVO=new PostAccessoryVO();
                postAccessoryVO.setAccessory_adv_id(rs.getInt("accessory_adv_id"));
                postAccessoryVO.setAccess_img_id(rs.getDouble("access_img_id"));
                postAccessoryVO.setAccess_title(rs.getString("access_title"));
                postAccessoryVO.setAccess_condition(rs.getString("access_condition"));
                postAccessoryVO.setAccessry_brand_id(rs.getInt("accessry_brand_id"));
                postAccessoryVO.setAccessory_id(rs.getInt("accessory_id"));
                postAccessoryVO.setAccess_descript(rs.getString("access_descript"));
                postAccessoryVO.setAccess_typof_ad(rs.getString("access_typof_ad"));
                postAccessoryVO.setAccess_price(rs.getDouble("access_price"));
                postAccessoryVO.setAccess_xpect_price(rs.getDouble("access_xpect_price"));
                postAccessoryVO.setAccess_posting_date(rs.getString("access_posting_date"));
                postAccessoryVO.setAccess_subcat_id(rs.getInt("access_subcat_id"));
                listOfPostAccessory.add(postAccessoryVO);
            }
        }catch(Exception e){
            e.getMessage();
        }
        return listOfPostAccessory;
    }
    
    public boolean checkPostAccessoryCredential(int accessory_adv_id) throws SQLException{
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        boolean status=false;
        PostAccessoryVO postAccessoryVO= new PostAccessoryVO();
        DbConnection dbcon= new DbConnection();
        conn= dbcon.dbConnect();
        pstmt=conn.prepareStatement("select * from post_accessory_section where accessory_adv_id=?");
        pstmt.setInt(1, accessory_adv_id);
        rs= pstmt.executeQuery();
        while(rs.next()){
            status= true;
        }
        pstmt.close();
        conn.close();
        return status;
    }
    
    public void postAccessoryType(PostAccessoryVO postAccessoryVO) throws SQLException {
        Connection conn=null;
        PreparedStatement pstmt1= null;
        
        try{
            DbConnection dbcon=new DbConnection();
            conn= dbcon.dbConnect();
            System.out.println("Connection Established");
            if(null!=conn){
                pstmt1=conn.prepareStatement("insert into post_accessory_section values(?,?,?,?,?,?,?,?,?,?,?,?)");
                pstmt1.setInt(1,postAccessoryVO.getAccessory_adv_id());
                pstmt1.setDouble(2, postAccessoryVO.getAccess_img_id());
                pstmt1.setString(3, postAccessoryVO.getAccess_title());
                pstmt1.setString(4, postAccessoryVO.getAccess_condition());
                pstmt1.setInt(5, postAccessoryVO.getAccessry_brand_id());
                pstmt1.setInt(6, postAccessoryVO.getAccessory_id());
                pstmt1.setString(7, postAccessoryVO.getAccess_descript());
                pstmt1.setString(8, postAccessoryVO.getAccess_typof_ad());
                pstmt1.setDouble(9, postAccessoryVO.getAccess_price());
                pstmt1.setDouble(10, postAccessoryVO.getAccess_xpect_price());
                pstmt1.setString(11, postAccessoryVO.getAccess_posting_date());
                pstmt1.setInt(12, postAccessoryVO.getAccess_subcat_id());
                pstmt1.execute();
            }
            else{
                System.out.println("Connection Not Found");
            }
        }
        catch(Exception e){
            System.out.println("Message" + e.getMessage());
            e.printStackTrace();
        }
        finally{
            conn.close();
        }
    }
    
    
}
