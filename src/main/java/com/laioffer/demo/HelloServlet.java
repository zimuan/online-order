package com.laioffer.demo;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import com.laioffer.demo.entity.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 回复前端请求的时候，告诉他返回的数据格式什么 data format
////        response.setContentType("text/html");
//        response.setContentType("application/json"); // data format
//
//        //  if we want to test username=vincent
////        String username = request.getParameter("username");
//
//        // read operation
//        PrintWriter out = response.getWriter(); // handler that can print data into response body
//        JSONObject object  = new JSONObject();
//        object.put("email", "sun@laioffer.com");
//        object.put("name", "Rick Sun");
//        object.put("age" ,45);

//        out.println(object);
//        out.println("<html><body>");
//        out.println("<h1>Hello " + username + "</h1>");
//        out.println("</body></html>");
//        // standard out put if using system.out.println 标准化输出窗口
        response.setContentType("application/json");

        ObjectMapper mapper = new ObjectMapper();

        Customer customer = new Customer();
        customer.setFirstName("Rick");
        customer.setLastName("Sun");
        customer.setPassword("1234567");
        customer.setEnabled(true);
        customer.setEmail("sun@laioffer.com");

        // 变成json数据
        response.getWriter().println(mapper.writeValueAsString(customer));
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 如何读取request body把json数据拿出来
//        JSONObject obj = new JSONObject(IOUtils.toString(request.getReader()));
//        String lastName = obj.getString("last_name");
//        int age = obj.getInt("age");
        // Read customer information from request body

        // 读取request body
        JSONObject jsonRequest = new JSONObject(IOUtils.toString(request.getReader()));
        String email = jsonRequest.getString("email");
        String firstName = jsonRequest.getString("first_name");
        String lastName = jsonRequest.getString("last_name");
        int age = jsonRequest.getInt("age");
        // Print customer information to IDE console
        System.out.println("Email is: " + email);
        System.out.println("First name is: " + firstName);
        System.out.println("Last name is: " + lastName);
        System.out.println("Age is: " + age);
        // Return status = ok as response body to the client
        response.setContentType("application/json");
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("status", "ok");
        response.getWriter().print(jsonResponse);

    }
    public void destroy() {
    }
}