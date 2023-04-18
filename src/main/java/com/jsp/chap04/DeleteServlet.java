package com.jsp.chap04;


import com.jsp.repository.DancerRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dancer/delete")
public class DeleteServlet extends HttpServlet {
    private final DancerRepository repository
            = new DancerRepository();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 클라이언트에서 전송한 이름을 읽어야함
        String name = req.getParameter("name");

        // repository에서 삭제 진행
        repository.delete(name);

        // 등록화면으로 이동 (리다이렉트)
        resp.sendRedirect("/dancer/join");

    }
}
