package com.hotusa.servlet;

import com.hotusa.main.Main;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;


@WebServlet("/servlet-main")
public class ServletMain extends HttpServlet {

    private static final Logger log202 = LogManager.getLogger("PRERESERVA");
    private static final Logger log3 = LogManager.getLogger("CONFIRM");
    private static final Logger logApp = LogManager.getLogger(ServletMain.class);

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        

        log202.info(System.getProperty("Log4jContextSelector"));
        log202.info(LogManager.getContext(false).getClass().getName());

        log3.info("Confirm!!");
        logApp.info("Serving request");

        StringBuilder xml = new StringBuilder();
        xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        xml.append("<response>\n");
        xml.append("  <status>OK</status>\n");
        xml.append("</response>\n");

        byte[] bytes = xml.toString().getBytes(StandardCharsets.UTF_8);

        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/xml;charset=UTF-8");
        response.setContentLength(bytes.length);
        response.setHeader("Cache-Control", "no-store");
        response.setCharacterEncoding("UTF-8");

        // getOutputStream en lugar de getWriter: más eficiente para bytes ya codificados
        response.getOutputStream().write(bytes);
    }

}
