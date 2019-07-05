/*实现功能：
1.画图；
2.画出蛇的相应图标
 */


import javax.swing.*;
import java.awt.*;

public class MyFrame extends JPanel {
	static Snakeline s1 = new Snakeline();
	//static Run Runner = new Run();
	//Run Runner = new Run();
	int T=0;
	int x;
	int y;
	static boolean M=true;
	@Override
	public void paint(Graphics g) {
		if (M){
		/////////画底层图
		g.setColor(Color.white);
		for(int i=0;i<600;i+=20){
			for(int j=0;j<520;j+=20){
				g.fill3DRect(i,j,20,20,true);
			}
		}

		///////画边框
		g.setColor(Color.GRAY);
		for (int j = 0; j < 600; j += 20) {
			g.fill3DRect(j, 0, 20, 20, true);
			g.fill3DRect(j, 500, 20, 20, true);
		}
		for (int i = 0; i < 500; i += 20) {
			g.fill3DRect(0, i, 20, 20, true);
			g.fill3DRect(580, i, 20, 20, true);
		}
		/////食物
		if(T==0){
			this.x=new Food().x;
			this.y=new Food().y;
			//g.setColor(Color.blue);
			//g.fill3DRect(this.x,this.y,20,20,true);
			T=1;
		}


			if (s1.s[0].x0 == this.x && s1.s[0].y0 == this.y) {
				//Food fd =new Food();
				//this.x=new Food().x;
				//this.y=new Food().y;
				T = 0;
				s1.addsnake();
			}
			g.setColor(Color.blue);
			g.fill3DRect(this.x, this.y, 20, 20, true);
			/////蛇头
			g.setColor(Color.green);
			g.fill3DRect(s1.s[0].x0, s1.s[0].y0, 20, 20, true);

			/////蛇身
			for (int i = 1; i < Snake.n - 1; i++) {
				g.setColor(Color.red);
				//g.fill3DRect(Snakeline.s[i].x0,Snakeline.s[i].y0,20,20,true);
				g.fill3DRect(s1.s[i].x0, s1.s[i].y0, 20, 20, true);
			}
		}
		//判断死亡游戏结束
		for(int i=1;i<Snake.n-1;i++){
			if(s1.s[0].x0==s1.s[i].x0&&s1.s[0].y0==s1.s[i].y0||s1.s[0].x0==0||s1.s[0].x0==580||s1.s[0].y0==0||s1.s[0].y0==500){
				g.setColor(Color.red);
				g.setFont(new Font("arial",Font.BOLD, 50));
				g.drawString("Game Over",180,260);
				//s1.s[0].currentdir='M';
				M=false;
			}
		}


		/*if (M){
			//Threader.start();
			//Threader.run();
			//s1.refreshSnake();
		}*/


			//s1.refreshSnake();

			//Runner.run();
			repaint();

	}
	public static void main(String[] args){
		//s1.s[0].x0=240;
		//System.out.println(s1.s[0].x0);
		//Run Runner = new Run();
		//Thread Threader = new Thread(Runner);
		//Threader.start();


		JFrame f = new JFrame("Snaker");
		MyFrame m = new MyFrame();
		f.add(m);
		f.addKeyListener(s1);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(620,560);
		f.setVisible(true);
		while(true) {
			s1.refreshSnake();
		}
		//Runner.run();
	//	Snakeline sl=new Snakeline();


	}

}
