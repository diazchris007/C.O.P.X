package logic;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;

public class EventHandlerExitApp implements EventHandler<WindowEvent>{
	
	@Override
	public void handle(WindowEvent arg0) {
		Platform.exit();
		System.exit(0);
	}
}
