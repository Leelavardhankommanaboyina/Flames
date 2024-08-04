package Model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FlamesServlet")
public class FlamesServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s1 = request.getParameter("s1");
        String s2 = request.getParameter("s2");
        String str1 = request.getParameter("s1");
        String str2 = request.getParameter("s2");
        
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        
        // Remove common characters
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (s2.indexOf(c) != -1) {
                s2 = s2.replaceFirst(String.valueOf(c), "");
                s1 = s1.replaceFirst(String.valueOf(c), "");
                i--;  // Decrement to check current index again after removing character
            }
        }
        
        int total = s1.length() + s2.length();
        
        ArrayList<Character> al = new ArrayList<>();
        al.add('f');
        al.add('l');
        al.add('a');
        al.add('m');
        al.add('e');
        al.add('s');
        
        int index = 0;
        while (al.size() > 1) {
            index = (index + total - 1) % al.size();
            al.remove(index);
        }
        
        response.setContentType("html/text");
        PrintWriter pw = response.getWriter();
        
        pw.print(str1+" and "+str2+" ");
        pw.print("You are ");
        
        switch(al.get(0)) {
            case 'f': pw.print("Friends"); break;
            case 'l': pw.print("Lovers"); break;
            case 'a': pw.print("Affection"); break;
            case 'm': pw.print("Marriage"); break;
            case 'e': pw.print("Enemies"); break;
            case 's': pw.print("Siblings"); break;
            default: pw.print("Undefined");
        }
    }
}
