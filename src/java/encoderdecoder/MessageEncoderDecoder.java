/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encoderdecoder;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebServlet("/MessageEncoderDecoder")
public class MessageEncoderDecoder extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String option = request.getParameter("option");
        String message = request.getParameter("message");
        String result = "";

        Encoder encode = new Encoder();
        Decoder decode = new Decoder();

        if ("encode".equals(option)) {
            result = encode.encoded(message);
        } else if ("decode".equals(option)) {
            result = decode.decoded(message);
        }

        request.setAttribute("result", result);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
