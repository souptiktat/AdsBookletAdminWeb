/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.models;

import com.classified.admin.vo.ClassifiedSubCategoryVO;
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
public class ClassifiedSubCategoryModel implements ClassifiedSubCategory{

    
    public ResultVO storeClassifiedSubInfo(ClassifiedSubCategoryVO classifiedSubCatVO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public ClassifiedSubCategoryVO populateClassifiedSubInfo(int classified_sub_category_id) {
        ClassifiedSubCategoryVO classifiedSubCatVO= new ClassifiedSubCategoryVO();
        try{
            if(0!=classified_sub_category_id){
                DbConnection dbcon=new DbConnection();
                Connection conn=dbcon.dbConnect();
                Statement st2=conn.createStatement();
                String sqlQuery2= "select * from classified_sub_category where classified_sub_category_id= "+classified_sub_category_id;
                System.out.println("Test Query:" +sqlQuery2);
                ResultSet rs1= st2.executeQuery(sqlQuery2);
                if(rs1.next()){
                    classifiedSubCatVO.setClassified_sub_category_id(rs1.getInt("classified_sub_category_id"));
                    classifiedSubCatVO.setClassified_category_id(rs1.getInt("classified_category_id"));
                    classifiedSubCatVO.setClassified_sub_category_name(rs1.getString("classified_sub_category_name"));
                                        
                }
            }
        }
        catch(Exception e){
            e.getMessage();
        }
        return classifiedSubCatVO;
    }

    public ResultVO deleteClassifiedSubInfo(int classified_sub_category_id) {
        ResultVO resultVO= new ResultVO();
        try{
            if(0!=classified_sub_category_id){
                DbConnection dbcon1=new DbConnection();
                Connection con1=dbcon1.dbConnect();
                Statement st1=con1.createStatement();
                String sqlQuery1="delete from classified_sub_category where classified_sub_category_id= "+classified_sub_category_id;
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

    
    public ClassifiedSubCategoryVO modifyClassifiedSubInfo(ClassifiedSubCategoryVO classifiedSubCatVO) {
        if(null!=classifiedSubCatVO){
            int classified_sub_category_id= classifiedSubCatVO.getClassified_sub_category_id();
            int classified_category_id=classifiedSubCatVO.getClassified_category_id();
            String classified_sub_category_name= classifiedSubCatVO.getClassified_sub_category_name();
            try{
                DbConnection dbcon2= new DbConnection();
                Connection con2= dbcon2.dbConnect();
                Statement st2= con2.createStatement();
                String updateQuery= "update classified_sub_category set classified_category_id='"+classified_category_id +"'classified_sub_category_name='"+classified_sub_category_name +"' where classified_sub_category_id=" + classified_sub_category_id;
                System.out.println("Update Query:" + updateQuery);
                int rowsAffected1=st2.executeUpdate(updateQuery);
                if(rowsAffected1 > 0){
                    
                }
            }
            catch(Exception e){
                e.getMessage();
            }
        }
        return classifiedSubCatVO;
    }

    
    public ResultVO searchClassifiedSubInfo(int classified_sub_category_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public List<ClassifiedSubCategoryVO> viewAllClassifiedSubInfo() {
        List<ClassifiedSubCategoryVO> listOfClassifiedSubCategory=new ArrayList<ClassifiedSubCategoryVO>();
        try{
            DbConnection dbcon=new DbConnection();
            Connection con=dbcon.dbConnect();
            Statement st=con.createStatement();
            String sqlQuery="select * from classified_sub_category";
            ResultSet rs=st.executeQuery(sqlQuery);
            ClassifiedSubCategoryVO classifiedSubCatVO=null;
            while(rs.next()){
                classifiedSubCatVO=new ClassifiedSubCategoryVO();
                classifiedSubCatVO.setClassified_sub_category_id(rs.getInt("classified_sub_category_id"));
                classifiedSubCatVO.setClassified_category_id(rs.getInt("classified_category_id"));
                classifiedSubCatVO.setClassified_sub_category_name(rs.getString("classified_sub_category_name"));
                listOfClassifiedSubCategory.add(classifiedSubCatVO);
            }
        }catch(Exception e){
            e.getMessage();
        }
        return listOfClassifiedSubCategory;
    }
    
    public boolean checkClassifiedSubCatCredential(int classified_sub_category_id) throws SQLException{
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        boolean status=false;
        ClassifiedSubCategoryVO classifiedSubCatVO= new ClassifiedSubCategoryVO();
        DbConnection dbcon= new DbConnection();
        conn= dbcon.dbConnect();
        pstmt=conn.prepareStatement("select * from classified_sub_category where classified_sub_category_id=?");
        pstmt.setInt(1, classified_sub_category_id);
        rs= pstmt.executeQuery();
        while(rs.next()){
            status= true;
        }
        pstmt.close();
        conn.close();
        return status;
    }
    
    public void postClassifiedSubCat(ClassifiedSubCategoryVO classifiedSubCatVO) throws SQLException{
        Connection conn=null;
        PreparedStatement pstmt1= null;
        
        try{
            DbConnection dbcon=new DbConnection();
            conn= dbcon.dbConnect();
            System.out.println("Connection Established");
            if(null!=conn){
                pstmt1=conn.prepareStatement("insert into classified_sub_category values(?,?,?)");
                pstmt1.setInt(1,classifiedSubCatVO.getClassified_sub_category_id());
                pstmt1.setInt(2,classifiedSubCatVO.getClassified_category_id());
                pstmt1.setString(3,classifiedSubCatVO.getClassified_sub_category_name());
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
