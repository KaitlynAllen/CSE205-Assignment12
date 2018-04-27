import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

import javax.swing.JPanel;

public class WavePanel extends JPanel {
	private Color color;
	private Timer timer;
	private int delay, waveWidth, waveHeight, time = 0, step;
	private ArrayList<Dot> ptList;
	
	
	
	public WavePanel (Color color1){
	setBackground(Color.WHITE);
	color = color1;
	ptList = new ArrayList<Dot>();
	waveHeight = 72;
	waveWidth = 50;
	delay = 20;
	step = 1;
	time = 0;
	timer = new Timer(delay, new WaveListener());
	timer.start();
	}
	
	public void resume(){
		timer.start();
		time = 0;
		repaint();
	}
	
	public void clearPanel(){
		this.removeAll();
		this.updateUI();
		time = 0;
		timer.stop();
		ptList.clear();
		
	}
	
	public void changeColor (Color anotherColor){
		this.color = anotherColor;
	}
	
	public void setWaveWidth (int newWidth){
		waveWidth = newWidth;
	}
	
	public void setDelay (int delayNum){
		timer.setDelay(delayNum);
	}
	
	public void paintComponent(Graphics page){
		super.paintComponent(page);
		for(int i = 0; i< ptList.size(); i++){
			page.setColor(color);
			ptList.get(i).draw(page);
		}
		
	}
	
	private class WaveListener implements ActionListener{
		public void actionPerformed (ActionEvent event){
			time += step;
			int x = (waveWidth * time)/50;
			int y = (int)(waveHeight * Math.sin((0.0174533)*time)+ 85);
			Dot pt = new Dot(x,y,color);
			ptList.add(pt);
			repaint();
			if ( y == 0 || y == 170 || y == 340 || x == 500){
				timer.stop();
			}
		}
	}
	
}

