package org.example;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 클라이언트의 요청을 받은 DispatcherServlet은 HanlderMapping을 통해 Controller 객체를 검색하여 실행한다.
// 이때 어떤 Controller 객체가 검색되더라도 같은 코드로 실행하려면, 모든 Controller의 최상위 인터페이스가 필요하다.
public interface Controller {
    String handleRequest(HttpServletRequest req, HttpServletResponse res);
}
