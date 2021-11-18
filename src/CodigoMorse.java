import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/*
 * Código Morse com mudança de cor. AVISO: LUZES PISCANTES!
 */

public class CodigoMorse {
	private boolean undecorated = false;
	
//	public CodigoMorse(String msg, boolean undecorated) throws InterruptedException, Exception {
//		this.undecorated = undecorated;
//		new CodigoMorse(msg);
//	}
	
	public CodigoMorse(String msg) throws InterruptedException, Exception {
		System.out.println(undecorated); //
		
		for(char ch : msg.toCharArray()) {
			if(ch != '-' && ch != '.' && ch != ' ')
				throw new Exception("\"Non-Morse\" character. Class accepts only '-', '.' and ' '.");
		}
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(3);
		frame.setSize(new Dimension(300, 300));
//		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(undecorated);
		frame.setResizable(false);
		
		frame.setVisible(true);
		
		frame.getContentPane().setBackground(Color.YELLOW);
		Thread.sleep(400);
		
		frame.getContentPane().setBackground(Color.WHITE);
		Thread.sleep(600);
		
		for(char ch : msg.toCharArray()) {
//			System.out.print(ch);
			frame.setTitle("" + ch);
			
			if(ch == '-' || ch == '.') {
				frame.getContentPane().setBackground(Color.BLACK);
				
				if(ch == '-')
					Thread.sleep(1000);
				else
					Thread.sleep(500);
				
				
			} else if(ch == ' ') {
				frame.setTitle("SPACE");
				frame.getContentPane().setBackground(Color.WHITE);
				Thread.sleep(500);
			}
			
			frame.getContentPane().setBackground(Color.WHITE);
			Thread.sleep(200);
		}
		
		frame.setTitle("");
		
		frame.getContentPane().setBackground(Color.WHITE);
		Thread.sleep(600);
		
		frame.getContentPane().setBackground(Color.GREEN);
		Thread.sleep(400);
		
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	}
	
	
	public static void main(String[] args) throws InterruptedException, Exception {
		new CodigoMorse(".--. . -.. .-. ---");
	}
}
