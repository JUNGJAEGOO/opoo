package network;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Astart {
	static char map[][];
	static char wall='W';
	static boolean visit[][];
	static ArrayList<data> open[];
	static int endX,endY;
	public static void main(String args[]) throws IOException, InterruptedException {
		Scanner in =new Scanner(System.in);
		int startX = in.nextInt();
		int startY = in.nextInt();
		int N = 10;
		endX = in.nextInt();
		endY = in.nextInt();
		
		visit = new boolean[N+2][N+2];
		open = new ArrayList[8];
		for ( int i = 0 ; i < 8 ; i++) {
			open[i] = new ArrayList<>();
		}
		
		map = new char[N+2][N+2];
		
		for ( int i = 1 ; i <= N ; i++ ) {
			for (int j = 1 ; j <= N ; j++) {
				map[i][j] = '0';
			}
		}
		
		
	/*	
		S 0 0 0 0 0 0 0 0 0 
		0 0 0 0 0 0 0 0 0 0 
		0 0 0 0 W 0 0 0 0 0 
		0 0 0 0 W 0 0 0 0 0 
		W 0 W W W 0 0 W W W 
		0 0 0 0 W 0 0 0 0 0 
		0 0 0 0 W 0 0 0 0 0 
		0 0 0 0 W 0 0 0 0 0 
		0 0 0 0 0 0 0 0 0 0 
		0 0 0 0 0 0 0 0 0 E */
		
		
		
			for (int j = 1 ; j <= N ; j++) {
				map[5][j] = wall;
			}
			for (int j = 3 ; j <= N-2 ; j++) {
				map[j][5] = wall;
			}
		map[5][6] = '0';
		map[5][7] = '0';
		//map[5][2] = '0';
		
		map[startX][startY] = 'S';
		map[endX][endY] = 'E';
		visit[startX][startY] = true;
	
		for ( int i = 1 ; i <= N ; i++ ) {
			for (int j = 1 ; j <= N ; j++) {
				System.out.print(map[i][j]+" ");
			}System.out.println();
		}
		//System.out.println("--------------------");
		astar(startX,startY);
		
		for ( int i = 1 ; i <= N ; i++ ) {
			for (int j = 1 ; j <= N ; j++) {
				System.out.print(map[i][j]+" ");
			}System.out.println();
		}
	}
	
	public static void astar(int sX,int sY) throws IOException, InterruptedException {
		int nowx,nowy;
		nowx = sX; nowy = sY;
		for( int i = 0 ; i < 8 ; i++) {
			open[i].add(new data(0,0));
		}
		while ( true ) {
			
			
		double min = Integer.MAX_VALUE;
		for ( int i = 0 ; i < 8 ; i++) {
			open[i].remove(0);
		}
		
		{
			open[0].add(new data(nowx-1,nowy-1));
			open[1].add(new data(nowx-1,nowy));
			open[2].add(new data(nowx-1,nowy+1));
			open[3].add(new data(nowx,nowy-1));
			open[4].add(new data(nowx,nowy+1));
			open[5].add(new data(nowx+1,nowy-1));
			open[6].add(new data(nowx+1,nowy));
			open[7].add(new data(nowx+1,nowy+1));
		
		}
		
		int save = -1;
		
		for ( int i = 0 ; i < 8 ; i++) {
			//System.out.println(open[i].get(0).x+","+open[i].get(0).y);
			if ( visit[open[i].get(0).x][open[i].get(0).y] != true && (map[open[i].get(0).x][open[i].get(0).y] == '0' || map[open[i].get(0).x][open[i].get(0).y] == 'E')) {
				if ( min > open[i].get(0).length ) {
					save = i;
					min = open[i].get(0).length;
				}
			}
		}
		
		nowx = open[save].get(0).x;
		nowy = open[save].get(0).y;
		
		visit[nowx][nowy] = true;
		
		if ( nowx == endX && nowy == endY) { break;}
		
		map[nowx][nowy] = '*';
		
		for ( int i = 1 ; i <= 10 ; i++ ) {
			for (int j = 1 ; j <= 10 ; j++) {
				System.out.print(map[i][j]+" ");
			}System.out.println();
		}

		for (int i = 0; i < 2; ++i) { System.out.println();}
		Thread.sleep(500);
	}
		
	}
	
	public static class data{
		int x;
		int y;
		double length;
		data(int x,int y){
			this.x = x;
			this.y = y;
			length = Math.sqrt(Math.pow((x-endX),2)+Math.pow((y-endY),2));
		}
		
	}
}
