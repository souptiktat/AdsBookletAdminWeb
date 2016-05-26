package com.classifiedindia.servlet;

import com.classifiedindia.model.DbConnection;
import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;


public class AjaxServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        //create a buffer to hold the result
        StringBuffer buffer = new StringBuffer();

        System.out.println("Ajax Servlet *********************************");
        //determine what service this request is for
        String service = request.getParameter("service");
        System.out.println("Ajax Servlet service = "+service);

        if ("RetreiveSubCategoryList".equals(service)) {
        	String category = request.getParameter("Category");
                System.out.println("Ajax Servlet Category = "+category);
        	if (category != null && !category.equals("")){

                    List lst = fetchResult(category);
                    for (int i =0; i < lst.size(); i++){
                        buffer.append(lst.get(i));
                    }

                    if(buffer.indexOf(",") != -1){
                	  buffer.replace(buffer.length() -1 , buffer.length(), "");
                    }
        	}
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

        public List fetchResult(String category){
            List lst = new ArrayList();
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/classifiedindia?user=root&password=root");
          //  conn = DriverManager.getConnection("jdbc:mysql://alokmysql.cyk2u0lckoay.eu-west-1.rds.amazonaws.com:3306/classifiedindia?user=root&password=alokhalder");
            DbConnection  dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();
            //pstmt = conn.prepareStatement("select * from classifiedindia.classified_sub_category where classified_category_id = ?");
            pstmt = conn.prepareStatement("select * from classifiedindia.district_table where state_id = ?");

            pstmt.setString(1, category);

            rs = pstmt.executeQuery();

            while(rs.next()){
                String name = rs.getString("district_name");
                String id = rs.getString("district_id");
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
                if(null != pstmt){

                   pstmt.close();
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










