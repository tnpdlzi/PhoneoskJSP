<%@page language="java" contentType="application/json; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@ page import="dto.Menu"%>
<%@ page import="dao.MenuDAO"%>
<%@ page import="jdbc.ConnectionProvider"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.*"%>

<%
	request.setCharacterEncoding("utf-8");
%>
 
<%
 	Connection conn = null;
  	try {
  		conn = ConnectionProvider.getConnection();
  	} catch (SQLException ex) {
  		out.println("Fail to connection.<br>");
  		out.println("SQLException: " + ex.getMessage());
  	}
  	
  	
  	String keyStr = request.getParameter("key");
  	int key = Integer.parseInt(keyStr);
  	MenuDAO menuDAO = MenuDAO.getInstance();
  	

  	
  		JSONObject jsonList = new JSONObject();
  		JSONArray itemList = new JSONArray();
  		List<Menu> menuList = menuDAO.selectListByStoreID(conn, key);
  		for(int i=0;i < menuList.size(); i++){
  	JSONObject tempJson = new JSONObject();
  		tempJson.put("storeID", menuList.get(i).getStoreID());
  		tempJson.put("menuID", menuList.get(i).getMenuID());
  		tempJson.put("menuName", menuList.get(i).getMenuName());
  		tempJson.put("price", menuList.get(i).getPrice());
  	itemList.add(tempJson);
  		}
  		jsonList.put("TOTAL",menuList.size());
  		jsonList.put("ITEMS",itemList);

  		System.out.println(jsonList);
  		out.print(jsonList);	

 %>