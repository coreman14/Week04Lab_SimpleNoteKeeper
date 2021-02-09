
package servlets;

import domain.Note;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Note note = new Note();
        String strCurrentLine = "";
        String allLine ="";
        BufferedReader br = new BufferedReader(new FileReader(new File(getServletContext().getRealPath("/WEB-INF/note.txt"))));
        note.setTitle(br.readLine());
        while ((strCurrentLine = br.readLine()) != null) {
            allLine = allLine + strCurrentLine+"\n";
            note.setContent(allLine);
        }
        request.setAttribute("note", note);//Sets note to note
        br.close();
        if (request.getParameter("edit") != null){
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp")
                .forward(request, response);
        }
        else{
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Note note;
        if (request.getParameter("note") == null){
            note = new Note();
            request.setAttribute("note", note);
        }
        else{
            note = (Note)request.getAttribute("note");
        }
        note.setTitle(request.getParameter("title"));
        note.setContent(request.getParameter("content"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(getServletContext().getRealPath("/WEB-INF/note.txt"),false)));
        pw.write(request.getParameter("title")+"\n");
        pw.write(request.getParameter("content"));
        pw.close();
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
    }


}
