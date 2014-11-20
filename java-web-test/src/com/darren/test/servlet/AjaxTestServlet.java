package com.darren.test.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class AjaxTestServlet
 */
@WebServlet("/AjaxTestServlet")
public class AjaxTestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("id", "001");
        map1.put("name", "darren");
        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("id", "002");
        map2.put("name", "zhang");
        list.add(map1);
        list.add(map2);
        Map<String, List<Map<String, String>>> value = new HashMap<String, List<Map<String, String>>>();
        value.put("name", list);
        // response.getWriter().write(list.toString());
        // response.getOutputStream().print(list.toString());

        JSONArray array = new JSONArray();
        JSONObject obj1 = new JSONObject();

        JSONObject obj2 = new JSONObject();
        try {
            obj1.put("id", "003");
            obj1.put("name", "darren");

            obj2.put("id", "004");
            obj2.put("name", "zhang");
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        array.put(obj1);
        array.put(obj2);
        response.getWriter().write(array.toString());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        // TODO Auto-generated method stub
    }

}
