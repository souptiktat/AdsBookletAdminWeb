/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classifiedindia.servlet;

import com.classifiedindia.model.DbConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccesoryServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        //create a buffer to hold the result
        StringBuffer buffer = new StringBuffer();

        System.out.println("Accesories AjaxServlet *********************************");
        //determine what service this request is for
        String service = request.getParameter("service");
        System.out.println("Accesories AjaxServlet service = "+service);

        if ("RetreiveModelList".equals(service)) {
        	//String category = request.getParameter("Category");
                //System.out.println("Accesories AjaxServlet = "+category);
        	//if (category != null && !category.equals("")){category

                    List lst = fetchResult();
                    for (int i =0; i < lst.size(); i++){
                        buffer.append(lst.get(i));
                    }

                    if(buffer.indexOf(",") != -1){
                	  buffer.replace(buffer.length() -1 , buffer.length(), "");
                    }
        	//}String category
            }

            //write the result
            if (buffer.length() > 0) {
                try {
                    PrintWriter out = response.getWriter();
                    out.print(buffer);
                    System.out.println("The buffer is"+buffer);
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public List fetchResult(){
            List lst = new ArrayList();
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/classifiedindia?user=root&password=root");
            //conn = DriverManager.getConnection("jdbc:mysql://alokmysql.cyk2u0lckoay.eu-west-1.rds.amazonaws.com:3306/classifiedindia?user=root&password=alokhalder");
            DbConnection  dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();
            //pstmt = conn.prepareStatement("select * from classifiedindia.classified_sub_category where classified_category_id = ?");
            //pstmt = conn.prepareStatement("select * from classifiedindia.model_table where brand_id = ?");
            //pstmt.setString(1, category);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM classifiedindia.accessories_type_table");

            //rs = pstmt.executeQuery();

            while(rs.next()){
                String name = rs.getString("accessory_name");
                String id = rs.getString("accessory_id");
                System.out.println("The sub categories name are"+name );
                lst.add(id);
                lst.add(".");
                lst.add(name);
                lst.add("#");

            }

            }catch(Exception e){
                e.printStackTrace();
            }finally{
              try{
                 if(null != rs){

                   rs.close();
               }
                if(null != stmt){

                   stmt.close();
               }
               if(null != conn){

                   conn.close();
               }
              }catch(SQLException e){
                 e.printStackTrace();
              }
            }

            return lst;

        }
}
