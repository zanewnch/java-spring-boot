package littleGame;

import javax.swing.*;

public class test1 extends JFrame {
	public static void main(String[] args) {
		Game game = new Game();
		game.launch();
	}
}

class Game extends JFrame{
	public void launch(){
		this.setVisible(true);
		this.setSize(600,600);
		this.setLocationRelativeTo(null);
		this.setTitle("The window's title");
	}
}
