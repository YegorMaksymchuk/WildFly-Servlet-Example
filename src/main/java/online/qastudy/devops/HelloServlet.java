package online.qastudy.devops;

import java.io.*;
import java.net.UnknownHostException;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        java.net.InetAddress localMachine = null;
        try {
            localMachine = java.net.InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        String hostName = localMachine.getHostName();
        String userName = System.getProperty("user.name");
        String javaVersion = System.getProperty("java.version");
        String osName = System.getProperty("os.name");
        message = new StringBuilder("Hello World!")
                .append("<br>")
                .append("Hostname: " + hostName)
                .append("<br>")
                .append("OS : " + osName)
                .append("<br>")
                .append("Username: " + userName)
                .append("<br>")
                .append("This is a Java:" + javaVersion)
                .toString();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}