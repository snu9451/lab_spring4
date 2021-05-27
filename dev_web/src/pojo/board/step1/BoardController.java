package pojo.board.step1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@Configuration
//@Controller
public class BoardController extends HttpServlet implements Action{
	//@Autowired
	//@Bean
	private BoardLogic boardLogic = new BoardLogic();
	private ActionForward forward = null;
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Map<String,Object> pmap = new HashMap<>();
		String path = null;
		boolean isRedirect = false;
		int result = 0;
		result = boardLogic.boardInsert(pmap);
		if(result == 1) {
			path = "boardInsertSuccess.jsp";
		}
		
		else if(result == 0) {
			path = "boardInsertFail.jsp";
		}
		res.sendRedirect(path);
		return null;
	}
	/*
	 * 자바이면 웹 서비스 즉 웹 어플리케이션 구현은 어렵다.
	 * 웹 어플리케이션을 구현 하려면 반드시 http프로토콜을 지원 받아야 한다.API
	 * http 프로토콜을 지원하는 API는 servlet-api.jar에 있다.
	 * 반드시 표준 서블릿을 상속 받아야 한다.
	 * 그랬더니 doGet을 오버라이드 할 수 있게 되었다.
	 * WAS인 톰캣 내부에 servlet-api.jar, jsp-api.jar가 내장됨
	 */
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException
	{
		execute(req,res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException
	{
		execute(req,res);		
	}	
}
