<%@page language="java" contentType="application/json; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@ page import="dto.Store"%>
<%@ page import="dao.StoreDAO"%>
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
  	
  	
  	String key = request.getParameter("key");
  	StoreDAO storeDAO = StoreDAO.getInstance();
  	

  		
  	if(key != null)
  	{
//  		JSONObject jsonList = new JSONObject();
//  		JSONArray itemList = new JSONArray();
  		Store store = storeDAO.selectByStoreID(conn, key);
  		JSONObject tempJson = new JSONObject();
  		tempJson.put("storeID", store.getStoreID());
  		tempJson.put("name", store.getName());
  		tempJson.put("address", store.getAddress());
  		tempJson.put("phone", store.getPhone());
  		tempJson.put("open", store.getOpen());
  		tempJson.put("close", store.getClose());
//  		itemList.add(tempJson);
//  		jsonList.put("DATAS",tempJson);

  		System.out.println(tempJson);
  		out.print(tempJson);
  	}  
  	

 %>