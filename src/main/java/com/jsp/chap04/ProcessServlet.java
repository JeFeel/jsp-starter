package com.jsp.chap04;


import com.jsp.entity.Dancer;
import com.jsp.repository.DancerRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/dancer/process")

//register.jsp에서 입력하고 등록을 누르면 /dancer/process로 이어짐
//이곳 ProcessServlet에서 그 처리를 해준다
public class ProcessServlet extends HttpServlet {

    //댄서 저장소를 의존해야 한다.
    private final DancerRepository repository = new DancerRepository();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        //객체지향 프로그래밍을 위해 역할을 분산

        //form에서 넘어온 데이터 읽기 (클라이언트 데이터 처리 : controller)
        //form에서 전송한데이터 한글처리
        request.setCharacterEncoding("UTF-8");

        // DancerRegisterViewServlet에서 전달된 파라미터 읽기
        String name = request.getParameter("name");
        String crewName = request.getParameter("crewName");
        String danceLevel = request.getParameter("danceLevel");
        String[] genresArray = request.getParameterValues("genres");


        //Dancer 객체를 생성, 입력값 세팅 (business logic : model(자바 객체))
        //데이터베이스에 저장 (business logic : model(자바 객체))
        // --> 다른 클래스에 역할 위임  (repository)
        repository.save(name, crewName, danceLevel, genresArray);


        //댄서 목록을 브라우저에 출력 (jsp : view) - 뷰 포워딩
        // 저장소에 있는 댄서 목록을 jsp 파일로 전달 수 있는 방법이 필요
        //client -> servlet -> jsp 순으로 이어지는 흐름을 잊지 말것
        //servet이 먼저 데이터를 받고, 그 다음에 jsp로 넘겨줘야 함

        List<Dancer> dancerList = repository.findAll();
        // request 객체는 하나의 요청간에 데이터 수송이 가능
        request.setAttribute("dl", dancerList);

        RequestDispatcher dp
                = request.getRequestDispatcher("/WEB-INF/chap04/dancer/list.jsp");
        dp.forward(request, resp);
    }
}
