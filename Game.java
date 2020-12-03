import java.awt.Canvas;

import javax.swing.JFrame;


public class Game extends Canvas implements Runnable{

	private boolean isRunning = false;

	public static final int WIDTH = 500;
	public static final int HEIGHT = 480;
	public static final String TITLE = "Pac-Man";

	private Thread thread ;

	public Game(){
		Dimension dimension = new Dimension(Game.WIDTH,Game.HEIGHT);
		setPreferredSize(dimension);
		setMinimumSize(dimension);
		setMaximumSize(dimension);
	}

	public synchronized void start(){
			if(isRunning) return;
			isRunning = true;
			thread = new Thread(this);
			thread.start();
	}
	
	public synchronized void stop(){
			if(!isRunning)return;
			isRunning = false;
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	private void tick(){
		System.out.println("WORKING");
	}

	private void render(){

	}

	@Override
	public void run() {

		while(isRunning){
			tick();
			render();
		}
		stop();
	}

	public static void main(String[]args){
		Game game = new Game();
		JFrame frame = new JFrame();
		frame.setTilte(Game.TITLE);
		frame.add(game);
		frame.setResizable(false);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		frame.setVisible(true);

		game.start();
	}



}


	