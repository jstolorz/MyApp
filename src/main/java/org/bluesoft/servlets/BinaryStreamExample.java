package main.java.org.bluesoft.servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "BinaryStreamExample", urlPatterns = { "/testBinary" })
public class BinaryStreamExample extends HttpServlet {

    private ServletOutputStream outputStream;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

                response.setContentType("image/jpg"); 
           
                ServletOutputStream outputStream = response.getOutputStream();    

                //C:\projects\java\java_ant\MyApp\src\main\webapp\public\images\rovinj_chorwacja.jpg

                InputStream inputStream = getServletContext().getResourceAsStream("public/images/rovinj_chorwacja.jpg");

                byte[] imageBytes = new byte[inputStream.available()];

                inputStream.read(imageBytes);

                outputStream.write(imageBytes);

                outputStream.flush();

            
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }
    
}
