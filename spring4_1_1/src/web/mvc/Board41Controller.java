package web.mvc;

import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class Board41Controller extends MultiActionController {
	private Board41Logic boardLogic = null;
	//setter메소드를 통하여 게으른 객체 주입
	public void setBoardLogic(Board41Logic boardLogic) {
		this.boardLogic = boardLogic;
	}
}
