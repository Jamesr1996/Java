import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.media.*;
import javax.swing.*;

public class PersonalPlayer {
	
	static void CreateWindow(){
		// Initialize the window
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		JFrame window = new JFrame();
		System.out.println("");
		
		window.setTitle("Project Media Player");
		window.getContentPane().setBackground(Color.BLACK);
		
		// Set fullscreen
		window.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		window.setSize(screenSize);
		window.setLayout(null);
		window.setVisible(true);		
		
		// Create panel to contain buttons
		JPanel controlPanel = new JPanel();		
		controlPanel.setSize(screenSize.width, 50);
		controlPanel.setLocation(0, screenSize.height-100);
		controlPanel.setBackground(Color.DARK_GRAY);
		
		// Create Buttons
		JButton play = new JButton();
		JButton forward = new JButton();
		JButton backward = new JButton();
		
		play.setText("Play");		
		play.setBounds(50, 150, 100, 30);		
		play.setBackground(Color.WHITE);
		play.setVisible(true);
		
		forward.setText(">>");		
		forward.setBounds(50, 150, 100, 30);	
		forward.setBackground(Color.WHITE);
		forward.setVisible(true);
		
		backward.setText("<<");		
		backward.setBackground(Color.WHITE);
		backward.setBounds(50, 150, 100, 30);		
		backward.setVisible(true);
		
		
		// Add content to control panel
		controlPanel.setVisible(true);
		controlPanel.add(backward);
		controlPanel.add(play);
		controlPanel.add(forward);
		
		
		
		// Create Video here
		JPanel videoPanel = new JPanel();
		
		try {
			
			Player mp = Manager.createRealizedPlayer(new File("E:/Supernatural Season 1/TEST1.avi").toURI().toURL());
			
			Component video = mp.getVisualComponent();
            Component controls = mp.getControlPanelComponent();
            
            if (video != null){
                videoPanel.add( video, BorderLayout.CENTER ); //add video component
                }
            if (controls != null){
                controlPanel.add( controls, BorderLayout.SOUTH ); //add controls
            }
            
            mp.start();
			
		} catch (MalformedURLException mue){										
			// TODO Auto-generated catch block
			mue.printStackTrace();
		} catch (CannotRealizeException cre) {
			// TODO Auto-generated catch block
			cre.printStackTrace();
		} catch (NoPlayerException npe) {
			// TODO Auto-generated catch block
			npe.printStackTrace();
		} catch (IOException ioe) {
			// TODO Auto-generated catch block
			ioe.printStackTrace();
		}
		
		
		
		window.add(controlPanel);
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.nanoTime();
		CreateWindow();
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println("Runtime: " + totalTime);
	}

}
