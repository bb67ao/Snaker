/*
实现功能：
要建早一个蛇类
{作为每一个节点
当前坐标；
下次动作坐标；
}
方法1：实现动作监听，改变蛇头运动方向
方法2：刷新蛇长度的增加
方法3：刷新蛇节点坐标的改变
1.
 */

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Snakeline implements KeyListener {
	//static int p=0;
	static Snake[] s = new Snake[100];

	Snakeline(){
		for(int i=0;i<100;i++){
			s[i]=new Snake();
		}
		s[0].x0=240;
		s[0].y0=240;
		s[1].x0=220;
		s[1].y0=240;
		s[2].x0=200;
		s[2].y0=240;
		/*for (int i=0;i<4;i++){
				//s[i].T=true;
				MyFrame.coordinate[x0][y0]='*';
		}*/
	}

	@Override
	public void keyPressed(KeyEvent e){

		if(e.getKeyCode()==KeyEvent.VK_RIGHT&&s[0].currentdir!='L'&&s[0].s>0){
			//s[0].x1++;
			s[0].currentdir='R';
			s[0].s=0;
		}
		else if(e.getKeyCode()==KeyEvent.VK_LEFT&&s[0].currentdir!='R'&&s[0].s>0){
			//s[0].x1--;
			s[0].currentdir='L';
			s[0].s=0;
		}
		else if(e.getKeyCode()==KeyEvent.VK_UP&&s[0].currentdir!='D'&&s[0].s>0){
			//s[0].y1++;
			s[0].currentdir='U';
			s[0].s=0;
		}
		else if (e.getKeyCode()==KeyEvent.VK_DOWN&&s[0].currentdir!='U'&&s[0].s>0){
			//s[0].y1--;
			s[0].currentdir='D';
			s[0].s=0;
		}
		/*if(e.getKeyCode()==KeyEvent.VK_SPACE){
			if (MyFrame.M) {
				MyFrame.M = false;
			}
			else MyFrame.M=true;
		}*/


	}
	public void keyTyped(KeyEvent e){}
	public void keyReleased(KeyEvent e){}
	void addsnake (){
		//if (MyFrame.coordinate[x1][y1]=='$'){
			Snake.n++;
		//}
	}
	void refreshSnake(){
		while(MyFrame.M) {
			try{
				Thread.sleep(400);
			}
			catch (InterruptedException ex) {
				ex.printStackTrace();
			}

			if (s[0].currentdir == 'R') {
				s[0].s++;
				s[0].x1 += 20;
			}

			if (s[0].currentdir == 'L') {
				s[0].s++;
				s[0].x1 -= 20;
			}

			if (s[0].currentdir == 'U') {
				s[0].s++;
				s[0].y1 -= 20;
			}

			if (s[0].currentdir == 'D') {
				s[0].s++;
				s[0].y1 += 20;
			}

			s[1].x1 = s[0].x0;
			s[1].y1 = s[0].y0;
			for (int i = 0; i < Snake.n; i++) {
				s[i + 1].x1 = s[i].x0;
				s[i + 1].y1 = s[i].y0;
				s[i].x0 = s[i].x1;
				s[i].y0 = s[i].y1;
			}
		}

		//System.out.print(p++);
	}
	/*void eatfood(){
		if (s[0].y0==Food)*/
}
