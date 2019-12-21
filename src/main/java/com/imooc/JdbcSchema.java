package com.imooc;

import java.sql.*;

public class JdbcSchema {
  public static void main(String[] args) throws SQLException {
    Connection conn = null;
    String sql;
    String url = "jdbc:mysql://localhost:3306/test?user=root&password=123456&useUnicode=true&characterEncoding=UTF8";
    try {
      Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
      conn = DriverManager.getConnection(url);
      Statement stmt = conn.createStatement();
      ResultSet resultSet = stmt.executeQuery("SELECT * FROM (SELECT a.ID, a.COMMAND, a.CONTENT, a.DESCRIPTION FROM(SELECT t.ID, t.COMMAND, t.DESCRIPTION, t.CONTENT FROM test.message as t) a) tbl");
      ResultSetMetaData metaData = resultSet.getMetaData();
      System.out.println("metaData.isSearchable(1) = " + metaData.isSearchable(1));
      System.out.println("metaData.isSearchable(2) = " + metaData.isSearchable(2));
      System.out.println("metaData.isSearchable(3) = " + metaData.isSearchable(3));
      System.out.println("metaData.isSearchable(4) = " + metaData.isSearchable(4));
      System.out.println("metaData.getColumnCount() = " + metaData.getColumnCount());
      System.out.println(metaData.getColumnLabel(1) + ", " + metaData.getColumnLabel(2) + ", " + metaData.getColumnLabel(3) + ", " + metaData.getColumnLabel(4));
      System.out.println(metaData.getColumnClassName(1) + ", " + metaData.getColumnClassName(2) + ", " + metaData.getColumnClassName(3) + ", " + metaData.getColumnClassName(4));
      System.out.println(metaData.getColumnType(1) + ", " + metaData.getColumnType(2) + ", " + metaData.getColumnType(3) + ", " + metaData.getColumnType(4));
      System.out.println(metaData.getColumnTypeName(1) + ", " + metaData.getColumnTypeName(2) + ", " + metaData.getColumnTypeName(3) + ", " + metaData.getColumnTypeName(4));
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
    conn.close();
  }
}
