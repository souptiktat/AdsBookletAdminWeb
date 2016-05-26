/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.models;

import com.classified.admin.vo.ClassifiedAdvVO;
import com.classified.admin.vo.ResultVO;
import com.classifiedindia.model.DbConnection;
import java.sql.Blob;
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
public class ClassifiedAdvPhotoModel implements ClassifiedAdvPhoto{

    
    public ResultVO storeClassifiedAdvInfo(ClassifiedAdvVO classifiedAdvVO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    public ClassifiedAdvVO populateClassifiedAdvInfo(int classified_image_id) {
        ClassifiedAdvVO classifiedAdvVO= new ClassifiedAdvVO();
        try{
            if(0!=classified_image_id){
                DbConnection dbcon=new DbConnection();
                Connection conn=dbcon.dbConnect();
                Statement st2=conn.createStatement();
                String sqlQuery2= "select * from classified_adv_photo where classified_image_id= "+classified_image_id;
                System.out.println("Test Query:" +sqlQuery2);
                ResultSet rs1= st2.executeQuery(sqlQuery2);
                if(rs1.next()){
                    classifiedAdvVO.setClassified_image_id(rs1.getInt("classified_image_id"));
                    classifiedAdvVO.setClassified_id(rs1.getInt("classified_id"));
                    classifiedAdvVO.setClassified_small_image(rs1.getBlob("classified_small_image"));
                    classifiedAdvVO.setClassified_large_image(rs1.getBlob("classified_large_image"));
                }
            }
        }
        catch(Exception e){
            e.getMessage();
        }
        return classifiedAdvVO;
    }

  
    public ResultVO deleteClassifiedAdvInfo(int classified_image_id) {
        ResultVO resultVO= new ResultVO();
        try{
            if(0!=classified_image_id){
                DbConnection dbcon1=new DbConnection();
                Connection con1=dbcon1.dbConnect();
                Statement st1=con1.createStatement();
                String sqlQuery1="delete from classified_adv_photo where classified_image_id= "+classified_image_id;
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

  
    public ClassifiedAdvVO modifyClassifiedAdvInfo(ClassifiedAdvVO classifiedAdvVO) {
        if(null!=classifiedAdvVO){
            int classified_image_id= classifiedAdvVO.getClassified_image_id();
            int classified_id=classifiedAdvVO.getClassified_id();
            Blob classified_small_image= classifiedAdvVO.getClassified_small_image();
            Blob classified_large_image= classifiedAdvVO.getClassified_large_image();
            try{
                DbConnection dbcon2= new DbConnection();
                Connection con2= dbcon2.dbConnect();
                Statement st2= con2.createStatement();
                String updateQuery= "update classified_adv_photo set classified_id='"+classified_id+"', classified_small_image= '"+ classified_small_image +"', classified_large_image= '"+ classified_large_image +"' where classified_image_id=" + classified_image_id;
                System.out.println("Update Query:" + updateQuery);
                int rowsAffected1=st2.executeUpdate(updateQuery);
                if(rowsAffected1 > 0){
                    
                }
            }
            catch(Exception e){
                e.getMessage();
            }
        }
        return classifiedAdvVO;
    }

    
    public ResultVO searchClassifiedAdvInfo(int classified_image_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public List<ClassifiedAdvVO> viewAllClassifiedAdvInfo() {
        List<ClassifiedAdvVO> listOfClassifiedAdv=new ArrayList<ClassifiedAdvVO>();
        try{
            DbConnection dbcon=new DbConnection();
            Connection con=dbcon.dbConnect();
            Statement st=con.createStatement();
            String sqlQuery="select * from classified_adv_photo";
            ResultSet rs=st.executeQuery(sqlQuery);
            ClassifiedAdvVO classifiedAdvVO=null;
            while(rs.next()){
                classifiedAdvVO=new ClassifiedAdvVO();
                classifiedAdvVO.setClassified_image_id(rs.getInt("classified_image_id"));
                classifiedAdvVO.setClassified_id(rs.getInt("classified_id"));
                classifiedAdvVO.setClassified_small_image(rs.getBlob("classified_small_image"));
                classifiedAdvVO.setClassified_large_image(rs.getBlob("classified_large_image"));
                listOfClassifiedAdv.add(classifiedAdvVO);
            }
        }catch(Exception e){
            e.getMessage();
        }
        return listOfClassifiedAdv;
    }
    
    public boolean checkClassifiedAdvCredential(int classified_image_id) throws SQLException{
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        boolean status=false;
        ClassifiedAdvVO classifiedAdvVO= new ClassifiedAdvVO();
        DbConnection dbcon= new DbConnection();
        conn= dbcon.dbConnect();
        pstmt=conn.prepareStatement("select * from classified_adv_photo where classified_image_id=?");
        pstmt.setInt(1, classified_image_id);
        rs= pstmt.executeQuery();
        while(rs.next()){
            status= true;
        }
        pstmt.close();
        conn.close();
        return status;
    }
    
    public void postClassifiedAdv(ClassifiedAdvVO classifiedAdvVO) throws SQLException {
        Connection conn=null;
        PreparedStatement pstmt1= null;
        
        try{
            DbConnection dbcon=new DbConnection();
            conn= dbcon.dbConnect();
            System.out.println("Connection Established");
            if(null!=conn){
                pstmt1=conn.prepareStatement("insert into classified_adv_photo values(?,?,?,?)");
                pstmt1.setInt(1,classifiedAdvVO.getClassified_image_id());
                pstmt1.setInt(2,classifiedAdvVO.getClassified_id());
                pstmt1.setBlob(3, classifiedAdvVO.getClassified_small_image());
                pstmt1.setBlob(4, classifiedAdvVO.getClassified_large_image());
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
