//package src;
//import java.util.ArrayList;
//import Cube.java
//
//public class CubeSolve extends Cube{
//
//	
//	public void solve() {//reorder/rename solve method names as more are added
//		
//		while (whiteCross() != true);
//	//	while(F2L()!= true);
//	//	while(OLL()!=true);
//	//	while(PLL()!=true);
//	//	while(finish()!=true);
//	}
//	
//	private boolean WhiteCross() { return WhiteCross(0);}
//	
//	private boolean WhiteCross(int state) {
//		//method that will take random cube and create the white cross
//		//sequentially find each white edge and move it to the right spot
//		//find edges and line them up in order: red, blue, orange, green (improve later)
//		int[][] white = this.getSide(0);
//		int[][] red = this.cube.getSide(1);
//		int[][] blue = this.cube.getSide(2);
//		int[][] green = this.cube.getSide(3);
//		int[][] orange = this.cube.getSide(4);
//		int[][] yellow = this.cube.getSide(5);
//		
//		while(state == 0) {//red white
//			
//			if(white[2][1] == 0 && red[0][1] == 1) {return WhiteCross(1);}
//			
//			if(yellow[0][1] == 0 && red[2][1] == 1 || yellow[0][1] == 1 && red[2][1] == 0) {
//				this.cube.faceTurn(1);
//				return WhiteCross(0);
//			}
//			
//			if(yellow[1][2] == 0 && blue[2][1] == 1 || yellow[1][2] == 1 && blue[2][1] == 0) {
//				this.cube.faceTurn(2);
//				return WhiteCross(0);
//			}
//			
//			if(yellow[2][1] == 0 && orange[2][1] == 1 || yellow[2][1] == 1 && orange[2][1] == 0) {
//				this.cube.faceTurn(4);
//				return WhiteCross(0);
//			}
//			
//			if(yellow[1][0] == 0 && green[2][1] == 1 || yellow[1][0] == 1 && green[2][1] == 0) {
//				this.cube.faceTurn(3);
//				return WhiteCross(0);
//			}
//			
//			if(red[1][2] == 1 && blue[1][0] == 0) {
//				this.cube.faceTurn(1, false);
//				return WhiteCross(0);
//			}
//				
//			if(red[1][2] == 0 && blue[1][0] == 1) {
//				this.cube.faceTurn(2);
//				this.cube.faceTurn(0);
//				return WhiteCross(0);
//			}
//			
//			if(blue[1][2] == 1 && orange[1][0] ==0) {
//				this.cube.faceTurn(2,false);
//				this.cube.faceTurn(0);
//				return WhiteCross(0);
//			}
//				
//			if(blue[1][2] == 0 && orange[1][0] ==1) {
//				this.cube.faceTurn(4);
//				this.cube.faceTurn(0,true,true);
//				return WhiteCross(0);
//			}
//			
//			if(orange[1][2] == 1 && green[1][0] ==0) {
//				this.cube.faceTurn(4,false);
//				this.cube.faceTurn(0,true,true);
//				return WhiteCross(0);
//			}
//				
//			if(orange[1][2] == 0 && green[1][0] ==1) {
//				this.cube.faceTurn(3);
//				this.cube.faceTurn(0,false);
//				return WhiteCross(0);
//			}
//			
//			if(green[1][2] == 1 && red[1][0] == 0) {
//				this.cube.faceTurn(3, false);
//				this.cube.faceTurn(0,false);
//				return WhiteCross(0);
//			}
//				
//			if(green[1][2] == 0 && red[1][0] == 1) {
//				this.cube.faceTurn(1);
//				return WhiteCross(0);
//			}
//			
//			if(white[2][1] == 1 && red[0][1] == 0) {
//				this.cube.faceTurn(1);
//				this.cube.faceTurn(0,false);
//				this.cube.faceTurn(2);
//				this.cube.faceTurn(0);
//				return WhiteCross(0);
//			}
//			
//			if(white[1][2] == 0 && blue[0][1] ==1) {
//				this.cube.faceTurn(0);
//				return WhiteCross(0);
//			}
//				
//			if(white[1][2] == 1 && blue[0][1] == 0) {
//				this.cube.faceTurn(2,false);
//				this.cube.faceTurn(1,false);
//				return WhiteCross(0);
//			}
//			
//			if(white[0][1] == 0 && orange[0][1] ==1) {
//				this.cube.faceTurn(0,true,true);
//				return WhiteCross(0);
//			}
//				
//			if(white[0][1] == 1 && orange[0][1] == 0) {
//				this.cube.faceTurn(4,false);
//				this.cube.faceTurn(0,false);
//				this.cube.faceTurn(1,false);
//				this.cube.faceTurn(0);
//				return WhiteCross(0);
//			}
//				
//			if(white[1][0] == 0 && green[0][1] ==1) {
//				this.cube.faceTurn(0,false);
//				return WhiteCross(0);
//			}
//				
//			if(white[1][0] == 1 && green[0][1] == 0) {
//				this.cube.faceTurn(3);
//				this.cube.faceTurn(1);
//				return WhiteCross(0);
//			}
//		}
//		
//		while(state == 1) {//white blue
//			
//			if(white[1][2] == 0 && blue[0][1] == 1) {return WhiteCross(2);}
//			
//			if(yellow[0][1] == 0 && red[2][1] == 2 || yellow[0][1] == 2 && red[2][1] == 0) {
//				this.cube.faceTurn(1);
//				return WhiteCross(1);
//			}
//			
//			if(yellow[1][2] == 0 && blue[2][1] == 2 || yellow[1][2] == 2 && blue[2][1] == 0) {
//				this.cube.faceTurn(2);
//				return WhiteCross(1);
//			}
//			
//			if(yellow[2][1] == 0 && orange[2][1] == 2 || yellow[2][1] == 2 && orange[2][1] == 0) {
//				this.cube.faceTurn(4);
//				return WhiteCross(1);
//			}
//			
//			if(yellow[1][0] == 0 && green[2][1] == 2 || yellow[1][0] == 2 && green[2][1] == 0) {
//				this.cube.faceTurn(3);
//				return WhiteCross(1);
//			}
//			
//			if(red[1][2] == 2 && blue[1][0] == 0) {
//				this.cube.faceTurn(0);
//				this.cube.faceTurn(1, false);
//				this.cube.faceTurn(0,false);
//				return WhiteCross(1);
//			}
//				
//			if(red[1][2] == 0 && blue[1][0] == 2) {
//				this.cube.faceTurn(2);
//				return WhiteCross(1);
//			}
//			
//			if(blue[1][2] == 2 && orange[1][0] ==0) {
//				this.cube.faceTurn(2,false);
//				return WhiteCross(1);
//			}
//				
//			if(blue[1][2] == 0 && orange[1][0] ==2) {
//				this.cube.faceTurn(0,false);
//				this.cube.faceTurn(4);
//				this.cube.faceTurn(0,true);
//				return WhiteCross(1);
//			}
//			
//			if(orange[1][2] == 2 && green[1][0] ==0) {
//				this.cube.faceTurn(0,false);
//				this.cube.faceTurn(4,false);
//				this.cube.faceTurn(0,true);
//				return WhiteCross(1);
//			}
//				
//			if(orange[1][2] == 0 && green[1][0] ==2) {
//				this.cube.faceTurn(0,true,true);
//				this.cube.faceTurn(3);
//				this.cube.faceTurn(0,false, true);
//				return WhiteCross(1);
//			}
//			
//			if(green[1][2] == 2 && red[1][0] == 0) {
//				this.cube.faceTurn(0,true,true);
//				this.cube.faceTurn(3, false);
//				this.cube.faceTurn(0,false, true);
//				return WhiteCross(1);
//			}
//				
//			if(green[1][2] == 0 && red[1][0] == 2) {
//				this.cube.faceTurn(0);
//				this.cube.faceTurn(1);
//				this.cube.faceTurn(0,false);
//				return WhiteCross(1);
//			}
//			
//			if(white[1][2] == 2 && blue[0][1] == 0) {
//				this.cube.faceTurn(2);
//				this.cube.faceTurn(0,false);
//				this.cube.faceTurn(4);
//				this.cube.faceTurn(0);			
//				return WhiteCross(1);
//			}
//			
//			if(white[0][1] == 0 && orange[0][1] ==2) {
//				this.cube.faceTurn(0);
//				return WhiteCross(1);
//			}
//				
//			if(white[0][1] == 2 && orange[0][1] == 0) {
//				this.cube.faceTurn(4,false);
//				this.cube.faceTurn(2,false);
//				return WhiteCross(1);
//			}
//				
//			if(white[1][0] == 0 && green[0][1] ==2) {
//				this.cube.faceTurn(0,false,true);
//				return WhiteCross(1);
//			}
//				
//			if(white[1][0] == 2 && green[0][1] == 0) {
//				this.cube.faceTurn(3);
//				this.cube.faceTurn(0);
//				this.cube.faceTurn(1);
//				this.cube.faceTurn(0,false);
//				return WhiteCross(1);
//			}
//		}
//		
//		while(state == 2) {//white orange
//			
//			if(white[0][1] == 0 && orange[0][1] == 4) {return WhiteCross(3);}
//			
//			if(yellow[0][1] == 0 && red[2][1] == 4 || yellow[0][1] == 4 && red[2][1] == 0) {
//				this.cube.faceTurn(1);
//				return WhiteCross(2);
//			}
//			
//			if(yellow[1][2] == 0 && blue[2][1] == 4 || yellow[1][2] == 4 && blue[2][1] == 0) {
//				this.cube.faceTurn(2);
//				return WhiteCross(2);
//			}
//			
//			if(yellow[2][1] == 0 && orange[2][1] == 4 || yellow[2][1] == 4 && orange[2][1] == 0) {
//				this.cube.faceTurn(4);
//				return WhiteCross(2);
//			}
//			
//			if(yellow[1][0] == 0 && green[2][1] == 4 || yellow[1][0] == 4 && green[2][1] == 0) {
//				this.cube.faceTurn(3);
//				return WhiteCross(2);
//			}
//			
//			if(red[1][2] == 4 && blue[1][0] == 0) {
//				this.cube.faceTurn(0, true, true);
//				this.cube.faceTurn(1, false);
//				this.cube.faceTurn(0,false, true);
//				return WhiteCross(2);
//			}
//				
//			if(red[1][2] == 0 && blue[1][0] == 4) {
//				this.cube.faceTurn(0);
//				this.cube.faceTurn(2);
//				this.cube.faceTurn(0,false);
//				return WhiteCross(2);
//			}
//			
//			if(blue[1][2] == 4 && orange[1][0] ==0) {
//				
//				this.cube.faceTurn(0);
//				this.cube.faceTurn(2,false);
//				this.cube.faceTurn(0,false);
//				return WhiteCross(2);
//			}
//				
//			if(blue[1][2] == 0 && orange[1][0] ==4) {
//				this.cube.faceTurn(2);
//				return WhiteCross(2);
//			}
//			
//			if(orange[1][2] == 4 && green[1][0] ==0) {
//				this.cube.faceTurn(4,false);
//				return WhiteCross(2);
//			}
//				
//			if(orange[1][2] == 0 && green[1][0] ==4) {
//				this.cube.faceTurn(0,false);
//				this.cube.faceTurn(3);
//				this.cube.faceTurn(0);
//				return WhiteCross(2);
//			}
//			
//			if(green[1][2] == 4 && red[1][0] == 0) {
//				this.cube.faceTurn(0,false);
//				this.cube.faceTurn(3, false);
//				this.cube.faceTurn(0);
//				return WhiteCross(2);
//			}
//				
//			if(green[1][2] == 0 && red[1][0] == 4) {
//				this.cube.faceTurn(0,true,true);
//				this.cube.faceTurn(1);
//				this.cube.faceTurn(0,false,true);
//				return WhiteCross(2);
//			}
//				
//			if(white[0][1] == 4 && orange[0][1] == 0) {
//				this.cube.faceTurn(4,false);
//				this.cube.faceTurn(0);
//				this.cube.faceTurn(2,false);
//				this.cube.faceTurn(0,false);
//				return WhiteCross(2);
//			}
//				
//			if(white[1][0] == 0 && green[0][1] ==4) {
//				this.cube.faceTurn(0,true);
//				return WhiteCross(2);
//			}
//				
//			if(white[1][0] == 2 && green[0][1] == 0) {
//				this.cube.faceTurn(3,false);
//				this.cube.faceTurn(4,false);
//				return WhiteCross(2);
//			}
//		}
//		
//		while(state == 3) {//white green
//			
//			if(white[1][0] == 0 && green[0][1] == 3) {return true;}
//			
//			if(yellow[0][1] == 0 && red[2][1] == 3 || yellow[0][1] == 3 && red[2][1] == 0) {
//				this.cube.faceTurn(1);
//				return WhiteCross(3);
//			}
//			
//			if(yellow[1][2] == 0 && blue[2][1] == 3 || yellow[1][2] == 3 && blue[2][1] == 0) {
//				this.cube.faceTurn(2);
//				return WhiteCross(3);
//			}
//			
//			if(yellow[2][1] == 0 && orange[2][1] == 3 || yellow[2][1] == 3 && orange[2][1] == 0) {
//				this.cube.faceTurn(4);
//				return WhiteCross(3);
//			}
//			
//			if(yellow[1][0] == 0 && green[2][1] == 3 || yellow[1][0] == 3 && green[2][1] == 0) {
//				this.cube.faceTurn(3);
//				return WhiteCross(3);
//			}
//			
//			if(red[1][2] == 3 && blue[1][0] == 0) {
//				this.cube.faceTurn(0, false);
//				this.cube.faceTurn(1, false);
//				this.cube.faceTurn(0);
//				return WhiteCross(3);
//			}
//				
//			if(red[1][2] == 0 && blue[1][0] == 3) {
//				this.cube.faceTurn(0, true, true);
//				this.cube.faceTurn(2);
//				this.cube.faceTurn(0,false, true);
//				return WhiteCross(3);
//			}
//			
//			if(blue[1][2] == 3 && orange[1][0] ==0) {
//				this.cube.faceTurn(0,true,true);
//				this.cube.faceTurn(2,false);
//				this.cube.faceTurn(0,false,true);
//				return WhiteCross(3);
//			}
//				
//			if(blue[1][2] == 0 && orange[1][0] ==3) {
//				this.cube.faceTurn(0);
//				this.cube.faceTurn(4);
//				this.cube.faceTurn(0,false);
//				return WhiteCross(3);
//			}
//			
//			if(orange[1][2] == 3 && green[1][0] ==0) {
//				this.cube.faceTurn(0);
//				this.cube.faceTurn(4,false);
//				this.cube.faceTurn(0,false);
//				return WhiteCross(3);
//			}
//				
//			if(orange[1][2] == 0 && green[1][0] ==3) {
//				this.cube.faceTurn(3);
//				return WhiteCross(3);
//			}
//			
//			if(green[1][2] == 3 && red[1][0] == 0) {
//				this.cube.faceTurn(3, false);
//				return WhiteCross(3);
//			}
//				
//			if(green[1][2] == 0 && red[1][0] == 3) {
//				this.cube.faceTurn(0,false);
//				this.cube.faceTurn(1);
//				this.cube.faceTurn(0);
//				return WhiteCross(3);
//			}
//		}
//		return false; //not reached
//	}
//	
//	public boolean F2L() {
//		return F2L(0);
//	}
//	
//	public boolean F2L(int status) { 
//	//status int starts at 0, increments by one each time a pair is F2Linserted
//		
//		int[][] white = this.cube.getSide(0);
//		int[][] red = this.cube.getSide(1);
//		int[][] blue = this.cube.getSide(2);
//		int[][] green = this.cube.getSide(3);
//		int[][] orange = this.cube.getSide(4);
//		int[][] yellow = this.cube.getSide(5);
//		
//		//corner 1 check
//		
//		while(status == 0) { //corner 1 - orange and green
//			
//			if(white[0][0] == 0 && orange[0][2] == 4 && green[0][0] == 3 && orange[1][0] == 4 && green[1][0] == 3)
//				return F2L(1);
//			
//			if(white[0][0] == 0 && orange[0][2] == 4 || white[0][0] == 3 && orange[0][2] == 0 || white[0][0] == 4 && orange[0][2] == 3) { //check if corner is in green-orange
//				this.cube.faceTurn(4);
//				this.cube.faceTurn(5);
//				this.cube.faceTurn(4, false);
//				this.cube.faceTurn(5, false);
//			}
//			
//			if(white[0][2] == 0 && blue[0][2] == 4 || white[0][2] == 3 && blue[0][2] == 0 || white[0][2] == 4 && blue[0][2] == 3) { // check if corner is in orange - blue
//				this.cube.faceTurn(2);
//				this.cube.faceTurn(5);
//				this.cube.faceTurn(2, false);	
//			}
//			
//			if(white[2][2] == 0 && red[0][2] == 4 || white[2][2] == 3 && red[0][2] == 0 || white[2][2] == 4 && red[0][2] == 3) { // check if corner is in blue - red
//				this.cube.faceTurn(1);
//				this.cube.faceTurn(5);
//				this.cube.faceTurn(1, false);
//				this.cube.faceTurn(5);
//			}
//			
//			if(white[2][0] == 0 && green[0][2] == 4 || white[2][0] == 3 && green[0][2] == 0 || white[2][0] == 4 && green[0][2] == 3) { // check if corner is in red - green
//				this.cube.faceTurn(3);
//				this.cube.faceTurn(5);
//				this.cube.faceTurn(3, false);
//				this.cube.faceTurn(5,true,true);
//			}
//			
//			//see if corner was in top layer already
//			if(yellow[0][0] == 3 && green[2][2] == 4 || yellow[0][0] == 4 && green[2][2] == 0 || yellow[0][0] == 0 && green[2][2] == 3) //check if corner is above red-green
//				this.cube.faceTurn(5,false);
//			
//			if(yellow[0][2] == 3 && red[2][2] == 4 || yellow[0][2] == 4 && red[2][2] == 0 || yellow[0][2] == 0 && red[2][2] == 3) //check if corner is above blue-red
//				this.cube.faceTurn(5,false,true);
//				
//			if(yellow[2][2] == 3 && blue[2][2] == 4 || yellow[2][2] == 4 && blue[2][2] == 0 || yellow[2][2] == 0 && blue[2][2] == 3)
//				this.cube.faceTurn(5);
//				
//			//corner has to be in top layer now right above where it should go in
//			
//			if(green[1][0] == 3 && orange[1][2] ==  4 || green[1][0] == 4 && orange[1][2] == 3) {//checks under corner slot (why its longer)
//				this.cube.faceTurn(4);
//				this.cube.faceTurn(5);
//				this.cube.faceTurn(4, false);
//				this.cube.faceTurn(5,true, true);
//				this.cube.faceTurn(4);
//				this.cube.faceTurn(5, false);
//				this.cube.faceTurn(4, false);
//			}
//			
//			if(orange[1][0] == 3 && blue[1][2] == 4|| orange[1][0] == 4 && blue[1][2] == 3) {//orange blue
//				this.cube.faceTurn(5);
//				this.cube.faceTurn(2);
//				this.cube.faceTurn(5,false);
//				this.cube.faceTurn(2,false);
//			}
//			
//			if(blue[1][0] == 3 && red[1][2] == 4|| blue[1][0] == 4 && red[1][2] == 3) { //blue-red
//				this.cube.faceTurn(1);
//				this.cube.faceTurn(5, false);
//				this.cube.faceTurn(1, false);
//				this.cube.faceTurn(5);
//			}	
//			
//			if(red[1][0] == 3 && green[1][2] == 4|| red[1][0] == 4 && green[1][2] == 3) { //red-green
//				this.cube.faceTurn(5, false);
//				this.cube.faceTurn(3);
//				this.cube.faceTurn(5, false);
//				this.cube.faceTurn(3, false);
//				this.cube.faceTurn(5,true,true);
//			}	
//			
//			if(yellow[2][1] == 3 && orange[2][1] == 4 || yellow[2][1] == 4 && orange[2][1] == 3) {//edge is directly to right (orange-yellow)
//				this.cube.faceTurn(3, false);
//				this.cube.faceTurn(5,true,true);
//				this.cube.faceTurn(3);
//				this.cube.faceTurn(5);
//				//should then activate next if statement
//			}
//			
//			if(yellow[1][2] == 3 && blue[2][1] == 4 || yellow[1][2] == 4 && blue[2][1] == 3) {// edge is in opposite spot of corner (blue-yellow)
//				this.cube.faceTurn(5);
//				this.cube.faceTurn(3, false);
//				this.cube.faceTurn(5, false);
//				this.cube.faceTurn(3);
//				this.cube.faceTurn(5, false);
//			}
//			
//			if(yellow[1][0] == 3 && orange[2][1] == 4 || yellow[1][0] == 4 && orange[2][1] == 3) {//edge is directly to left (green-yellow)
//				this.cube.faceTurn(3, false);
//				this.cube.faceTurn(5,true,true);
//				this.cube.faceTurn(3);
//				this.cube.faceTurn(5);	
//			}
//			//now matching corner and edge are in the top layer and corner to the left - ready for F2Linsert
//			this.cube.F2Linsert(0);
//		}
//		
//		while(status == 1) { //pair 2 - red - green
//			
//			if(white[2][0] == 0 && red[0][0] == 1 && red[1][0] == 1 && green[0][2] == 3 && green[1][2] == 3)
//				return F2L(2);
//			
//			if(white[2][0] == 0 && red[0][0] == 1 || white[2][0] == 1 && red[0][0] == 3 || white[2][0] == 3 && red[0][0] == 0) { //check if corner is in red - green
//				this.cube.faceTurn(3);
//				this.cube.faceTurn(5);
//				this.cube.faceTurn(3, false);
//				this.cube.faceTurn(5, false);
//			}
//			
//			if(white[0][2] == 0 && blue[0][2] == 1 || white[0][2] == 1  && blue[0][2] == 3 || white[0][2] == 3 && blue[0][2] == 0) { // check if corner is in orange - blue
//				this.cube.faceTurn(2);
//				this.cube.faceTurn(5);
//				this.cube.faceTurn(2, false);
//				this.cube.faceTurn(5);
//			}
//			
//			if(white[2][2] == 0 && blue[0][0] == 1 || white[2][2] == 1 && blue[0][0] == 3 || white[2][2] == 3 && blue[0][2] == 0) { // check if corner is in blue - red
//				this.cube.faceTurn(1);
//				this.cube.faceTurn(5);
//				this.cube.faceTurn(1, false);
//				this.cube.faceTurn(5,true,true);
//			}
//			
//			//see if corner was in top layer already
//			if(yellow[2][1] == 0 && green[2][0] == 1 || yellow[2][1] == 1 && green[2][0] == 3 || yellow[2][1] == 3 && green[2][0] == 0) //check if corner is above orange-green
//				this.cube.faceTurn(5);
//			
//			if(yellow[0][2] == 0 && red[2][2] == 1 || yellow[0][2] == 1 && red[2][2] == 3 || yellow[0][2] == 3 && red[2][2] == 0) //check if corner is above blue-red
//				this.cube.faceTurn(5,false);
//				
//			if(yellow[2][2] == 0 && blue[2][2] == 1 || yellow[2][2] == 1 && blue[2][2] == 3 || yellow[2][2] == 3 && blue[2][2] == 0)//check above blue-orange
//				this.cube.faceTurn(5, true, true);
//			
//			//corner has to be in top layer now right above where it should go in
//			
//			if(green[1][2] == 3 && red[1][0] ==  1 || green[1][2] == 1 && red[1][0] == 3) {//checks under corner slot (why its longer)
//				this.cube.faceTurn(3);
//				this.cube.faceTurn(5);
//				this.cube.faceTurn(3, false);
//				this.cube.faceTurn(5,true, true);
//				this.cube.faceTurn(3);
//				this.cube.faceTurn(5, false);
//				this.cube.faceTurn(3, false);
//			}
//			
//			if(blue[1][2] == 1 && orange[1][0] == 3|| blue[1][2] == 3 && orange[1][0] == 1) { //orange-blue
//				this.cube.faceTurn(2);
//				this.cube.faceTurn(5, false);
//				this.cube.faceTurn(2, false);
//				this.cube.faceTurn(5);
//			}	
//			
//			if(red[1][2] == 1 && blue[1][0] == 3|| red[1][2] == 3 && blue[1][0] == 1) { //blue-red
//				this.cube.faceTurn(5, false);
//				this.cube.faceTurn(1);
//				this.cube.faceTurn(5, false);
//				this.cube.faceTurn(1, false);
//				this.cube.faceTurn(5,true,true);
//			}	
//			
//			if(yellow[1][0] == 3 && green[2][1] == 1 || yellow[1][0] == 1 && green[2][1] == 3) {//edge is directly to right
//				this.cube.faceTurn(1, false);
//				this.cube.faceTurn(5,true,true);
//				this.cube.faceTurn(1);
//				this.cube.faceTurn(5);
//				//should then activate next if statement
//			}
//			
//			if(yellow[2][1] == 3 && orange[2][1] == 1 || yellow[2][1] == 1 && orange[2][1] == 3) {// edge is in opposite spot of corner
//				this.cube.faceTurn(5);
//				this.cube.faceTurn(2, false);
//				this.cube.faceTurn(5, false);
//				this.cube.faceTurn(2);
//				this.cube.faceTurn(5, false);
//			}
//			
//			if(yellow[0][1] == 3 && red[2][1] == 1 || yellow[0][1] == 1 && red[2][1] == 3) {//edge is directly to left
//				this.cube.faceTurn(1,false);
//				this.cube.faceTurn(5,true,true);
//				this.cube.faceTurn(1);
//				this.cube.faceTurn(5);	
//			}
//			
//			this.cube.F2Linsert(1);
//		}
//		
//		while(status == 2) {//pair 3 - blue-red
//			
//			if(white[2][2] == 0 && blue[0][0] == 2 && blue[1][0] == 2 && red[0][2] == 1 && red[1][2] == 1)
//				return F2L(3);
//			
//			if(white[2][2] == 0 && blue[0][0] == 2 || white[2][2] == 2 && blue[0][0] == 1 || white[2][2] == 1 && blue[0][0] == 0) { //check if corner is in blue-red
//				this.cube.faceTurn(1);
//				this.cube.faceTurn(5);
//				this.cube.faceTurn(1, false);
//				this.cube.faceTurn(5, false);
//			}
//			
//			if(white[0][2] == 0 && blue[0][2] == 2 || white[0][2] == 2 && blue[0][2] == 1 || white[0][2] == 1 && blue[0][2] == 0) { // check if corner is in orange-blue
//				this.cube.faceTurn(2);
//				this.cube.faceTurn(5);
//				this.cube.faceTurn(2, false);
//				this.cube.faceTurn(5,true,true);
//			}
//			
//			//see if corner was in top layer already
//			if(yellow[0][0] == 0 && green[2][2] == 2 || yellow[0][0] == 1 && green[2][2] == 0 || yellow[0][0] == 2 && green[2][2] == 1) //check if corner is above red-green
//				this.cube.faceTurn(5);
//			
//			if(yellow[2][0] == 0 && orange[2][2] == 2 || yellow[2][0] == 1 && orange[2][2] == 0 || yellow[2][0] == 2 && orange[2][2] == 1) //check if corner is above green-orange
//				this.cube.faceTurn(5,false,true);
//				
//			if(yellow[2][2] == 0 && blue[2][2] == 2 || yellow[2][2] == 1&& blue[2][2] == 0 || yellow[2][2] == 2  && blue[2][2] == 1)//check blue-orange
//				this.cube.faceTurn(5,false);
//				
//			//corner has to be in top layer now right above where it should go in
//			
//			if(blue[1][0] == 1 && red[1][2] ==  2 || blue[1][0] == 2 && red[1][2] == 1) {//checks under corner slot (why its longer)
//				this.cube.faceTurn(1);
//				this.cube.faceTurn(5);
//				this.cube.faceTurn(1, false);
//				this.cube.faceTurn(5,true, true);
//				this.cube.faceTurn(1);
//				this.cube.faceTurn(5, false);
//				this.cube.faceTurn(1, false);
//			}
//			
//			if(orange[1][0] == 1 && blue[1][2] == 2|| orange[1][0] == 2 && blue[1][2] == 1) {//orange blue
//				this.cube.faceTurn(5,false);
//				this.cube.faceTurn(2);
//				this.cube.faceTurn(5,false);
//				this.cube.faceTurn(2,false);
//				this.cube.faceTurn(5,true,true);
//			}
//			
//			if(yellow[0][1] == 1 && red[2][1] == 2 || yellow[0][1] == 2 && red[2][1] == 1) {//edge is directly to right (red)
//				this.cube.faceTurn(1);
//				this.cube.faceTurn(5,true,true);
//				this.cube.faceTurn(1,false);
//				this.cube.faceTurn(5,false);
//				//should then activate next if statement
//			}
//			
//			if(yellow[1][0] == 1 && green[2][1] == 2 || yellow[1][0] == 2 && green[2][1] == 1) {// edge is in opposite spot of corner (green)
//				this.cube.faceTurn(5, false);
//				this.cube.faceTurn(1);
//				this.cube.faceTurn(5, false);
//				this.cube.faceTurn(1, false);
//				this.cube.faceTurn(5);
//			}
//			
//			if(yellow[2][0] == 3 && blue[2][1] == 4 || yellow[2][0] == 4 && blue[2][1] == 3) {//edge is directly to left (blue)
//				this.cube.faceTurn(1);
//				this.cube.faceTurn(5,true,true);
//				this.cube.faceTurn(1, false);
//				this.cube.faceTurn(5,false);	
//			}
//			this.cube.F2Linsert(2);
//		}	
//		
//		while(status == 3) {//pair 4 - orange-blue
//			
//			if(white[0][2] == 0 && orange[0][0] == 4 && orange[1][0] == 4 && blue[0][2] == 2 && blue[1][2] == 2)
//				return true; //all pairs are matched up
//			
//			if(white[0][2] == 0 && orange[0][0] == 4 || white[0][2] == 2 && orange[0][0] == 0 || white[0][2] == 4 && orange[0][0] == 2) { //check if corner is in orange-blue
//				this.cube.faceTurn(2);
//				this.cube.faceTurn(5);
//				this.cube.faceTurn(2, false);
//				this.cube.faceTurn(5, false);
//			}
//			
//			//see if corner was in top layer already
//			if(yellow[0][2] == 0 && red[2][2] == 4 || yellow[0][2] == 2 && red[2][2] == 0 || yellow[0][2] == 4 && red[2][2] == 2) //check if corner is above blue-red
//				this.cube.faceTurn(5);
//			
//			if(yellow[0][0] == 0 && green[2][2] == 4 || yellow[0][0] == 2 && green[2][2] == 0 || yellow[0][0] == 4 && green[2][2] == 2) //check if corner is above red-green
//				this.cube.faceTurn(5,false,true);
//				
//			if(yellow[2][0] == 0 && orange[2][2] == 4 || yellow[2][0] == 2 && orange[2][2] == 0 || yellow[2][0] == 4  && orange[2][2] == 2)//check green-orange
//				this.cube.faceTurn(5,false);
//				
//			//corner has to be in top layer now right above where it should go in
//			
//			if(orange[1][0] == 2 && blue[1][2] ==  4 || orange[1][0] == 4 && blue[1][2] == 2) {//checks under corner slot (why its longer)
//				this.cube.faceTurn(2);
//				this.cube.faceTurn(5);
//				this.cube.faceTurn(2, false);
//				this.cube.faceTurn(5,true, true);
//				this.cube.faceTurn(2);
//				this.cube.faceTurn(5, false);
//				this.cube.faceTurn(2, false);
//			}
//			
//			if(yellow[1][2] == 4 && blue[2][1] == 2 || yellow[1][2] == 2 && blue[2][1] == 4) {//edge is directly to right (blue)
//				this.cube.faceTurn(2);
//				this.cube.faceTurn(5,true,true);
//				this.cube.faceTurn(2,false);
//				this.cube.faceTurn(5,false);
//				//should then activate next if statement
//			}
//			
//			if(yellow[0][1] == 4 && red[2][1] == 2 || yellow[0][1] == 2 && red[2][1] == 4) {// edge is in opposite spot of corner (red
//				this.cube.faceTurn(5, false);
//				this.cube.faceTurn(2);
//				this.cube.faceTurn(5, false);
//				this.cube.faceTurn(2, false);
//				this.cube.faceTurn(5);
//			}
//			
//			if(yellow[2][1] == 2 && orange[2][1] == 4 || yellow[2][1] == 4 && orange[2][1] == 2) {//edge is directly to left (orange)
//				this.cube.faceTurn(2);
//				this.cube.faceTurn(5,true,true);
//				this.cube.faceTurn(2, false);
//				this.cube.faceTurn(5,false);	
//			}
//			this.cube.F2Linsert(3);
//		}	
//		return false; //never reached
//	}
//		
//	public boolean OLL() {
//			
//			int[][] check = {{-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1}};//
//			int[][] yellow = this.cube.getSide(5);
//			int[][] red = this.cube.getSide(1);
//			int[][] blue = this.cube.getSide(2);
//			int[][] green = this.cube.getSide(3);
//			int[][] orange = this.cube.getSide(4);
//			
//			for(int x=1; x<4; x++) {
//				for(int y=1; y<4; y++)
//					check[x][y] = yellow[x-1][y-1];
//				}
//		
//			check[0][1] = red[2][0];
//			check[0][2] = red[2][1];
//			check[0][3] = red[2][2];
//			check[1][4] = blue[2][0];
//			check[2][4] = blue[2][1];
//			check[3][4] = blue[2][2];
//			check[1][0] = green[2][2];
//			check[2][0] = green[2][1];
//			check[3][0] = green[2][0];
//			check[4][1] = orange[2][2];
//			check[4][2] = orange[2][1];
//			check[4][3] = orange[2][0];
//			
//			int switchSelect1 = OLLSwitch1(yellow);
//			
//			if (switchSelect1 != 0) {
//				
//				System.out.println("Starting OLL first algorithm");
//				switch(switchSelect1) {
//				
//				case 1: this.cube.faceTurn(4); //line
//						this.cube.faceTurn(2);
//						this.cube.faceTurn(5);
//						this.cube.faceTurn(2,false);
//						this.cube.faceTurn(5,false);
//						this.cube.faceTurn(4,false);
//						break;
//				
//				case 2:	this.cube.faceTurn(4); //L
//						this.cube.faceTurn(5);
//						this.cube.faceTurn(2);
//						this.cube.faceTurn(5,false);
//						this.cube.faceTurn(2,false);
//						this.cube.faceTurn(4,false);
//						break;
//					
//				case 3:	this.cube.faceTurn(4); //'dot' case does case 1 and then case 2 algorithims
//						this.cube.faceTurn(2);
//						this.cube.faceTurn(5);
//						this.cube.faceTurn(2,false);
//						this.cube.faceTurn(5,false);
//						this.cube.faceTurn(4,false);
//						this.cube.faceTurn(5,true,true);
//						
//						this.cube.faceTurn(4);
//						this.cube.faceTurn(5);
//						this.cube.faceTurn(2);
//						this.cube.faceTurn(5,false);
//						this.cube.faceTurn(2,false);
//						this.cube.faceTurn(4,false);
//						break;
//						
//				case 4: this.cube.faceTurn(5);
//				}
//				return false;
//			}
//		
//			int switchSelect2 = OLLSwitch2(check);
//			
//			if(switchSelect2!=0 && switchSelect2!=8)
//				System.out.println("Starting OLL second algorithm:");
//			
//			switch(switchSelect2) {
//			
//			case 0:	this.cube.displayNet();
//					return true;
//			
//			case 1: this.cube.faceTurn(2,true,true); //(R2' D) (R' U2) (R D') (R' U2 R')
//					this.cube.faceTurn(0);
//					this.cube.faceTurn(2, false);
//					this.cube.faceTurn(5,true,true);
//					this.cube.faceTurn(2);
//					this.cube.faceTurn(0,false);
//					this.cube.faceTurn(2,false);
//					this.cube.faceTurn(5,true,true);
//					this.cube.faceTurn(2,false);
//					break;
//					
//			case 2: this.cube.faceTurn(3); //L F R' F' L' F R F'
//					this.cube.faceTurn(4);
//					this.cube.faceTurn(2,false);
//					this.cube.faceTurn(4, false);
//					this.cube.faceTurn(3, false);
//					this.cube.faceTurn(4);
//					this.cube.faceTurn(2);
//					this.cube.faceTurn(4, false);
//					break;	
//			
//			case 3: this.cube.faceTurn(2); //R U2 R' U' (R U R' U') (R U R' U') R U' R'
//					this.cube.faceTurn(5,true,true);
//					this.cube.faceTurn(2,false);
//					this.cube.faceTurn(5,false);
//					this.cube.faceTurn(2);
//					this.cube.faceTurn(5);
//					this.cube.faceTurn(2,false);
//					this.cube.faceTurn(5,false);
//					this.cube.faceTurn(2);
//					this.cube.faceTurn(5);
//					this.cube.faceTurn(2,false);
//					this.cube.faceTurn(5,false);
//					this.cube.faceTurn(2);
//					this.cube.faceTurn(5,false);
//					this.cube.faceTurn(2,false);
//					break;
//			
//			case 4: this.cube.faceTurn(2); //sune
//					this.cube.faceTurn(5);
//					this.cube.faceTurn(2, false);
//					this.cube.faceTurn(5);
//					this.cube.faceTurn(2);
//					this.cube.faceTurn(5,true,true);
//					this.cube.faceTurn(2, false);
//					break;
//				
//			case 5:	this.cube.faceTurn(2, false); //anti-sune
//					this.cube.faceTurn(5);
//					this.cube.faceTurn(3);
//					this.cube.faceTurn(5, false);
//					this.cube.faceTurn(2);
//					this.cube.faceTurn(5);
//					this.cube.faceTurn(3,false);
//					break;
//									
//			case 6: this.cube.faceTurn(2); //R U2' [R2 U'] [R2 U'] R2 U2' R
//					this.cube.faceTurn(5,true, true);
//					this.cube.faceTurn(2, true,true);
//					this.cube.faceTurn(5,false);
//					this.cube.faceTurn(2,true,true);
//					this.cube.faceTurn(5, false);
//					this.cube.faceTurn(2, true, true);
//					this.cube.faceTurn(5, true, true);
//					this.cube.faceTurn(2);
//					break;
//				
//			case 7: this.cube.faceTurn(2); //(R U2') (R2' U') (R2 U') (R2' U2' R)
//					this.cube.faceTurn(5,true,true);
//					this.cube.faceTurn(2, true, true);
//					this.cube.faceTurn(5,false);
//					this.cube.faceTurn(2, true, true);
//					this.cube.faceTurn(5, false);
//					this.cube.faceTurn(2, true, true);
//					this.cube.faceTurn(5, true, true);
//					this.cube.faceTurn(2);
//					break;
//			
//			case 8: this.cube.faceTurn(5);
//					break;
//			}
//			
//			return false;
//		}
//		
//	private boolean PLL() {
//		//load the array sides of the orange, green red and blue sides
//		 
//		int sideStatus[] = {-1, -1, -1, -1};
//		ArrayList<int[][]>check = new ArrayList<int[][]>();
//		check.add(this.cube.getSide(1));//red at index 0
//		check.add(this.cube.getSide(2));//blue at index 1
//		check.add(this.cube.getSide(3));//green at index 2
//		check.add(this.cube.getSide(4));//orange at index 3
//		boolean direction;
//		
//		for (int i=0; i <4; i++) {
//			sideStatus[i] = PLLCheck(check.get(i));
//		}
//		
//		if(sideStatus[0] == 2 && sideStatus[1] == 2 && sideStatus[2] == 2 && sideStatus[3] == 2)//all the top is the same
//			return true;//write another function to line up completed line with centers
//		
//		if(sideStatus[0] == 1 && sideStatus[1] == 1 || sideStatus[1] == 1 && sideStatus[2] == 1 || 
//		   sideStatus[2] == 1 && sideStatus[3] == 1 || sideStatus[3] == 1 && sideStatus[1] == 1) {// all corners match
//			
//		if(sideStatus[0] == 1 && sideStatus[1] == 1 && sideStatus[2] == 1 && sideStatus[3] == 1) {
//				PLLalg2(1, true);// default to turn red
//				return false;
//		}
//			
//			else {
//				for(int i = 0 ; i < 4; i++)
//					if(sideStatus[i] == 2) {
//						direction = PLLGetDir(i, check);
//						PLLalg2(i+1,direction);		
//			}
//			return false;
//			}}
//						
//		else if(sideStatus[0] ==  1 && sideStatus[1] == 0 || sideStatus[1] == 1 && sideStatus[2] == 0 ||
//		   sideStatus[2] ==  1 && sideStatus[3] == 0 || sideStatus[3] == 1 && sideStatus[0] == 0 ) {//only one corner set matches
//			for(int i = 0; i<4; i++) {
//				if(sideStatus[i] == 1)
//					PLLalg1(i+1);
//			}
//			return false;
//		}
//		
//		else
//			PLLalg1(1);//default to turn red
//				return false;
//		
//		}
//
//	private boolean finish() {
//		
//		int[][] front = this.cube.getSide(1);//loads red
//		
//		switch(front[2][1]) {
//		
//		case 1: this.cube.displayNet();
//				return true;
//		
//		case 2: System.out.println("Aligning top:");
//				this.cube.faceTurn(yellow, true);
//				return false;
//		
//		case 3: System.out.println("Aligning top:");
//				this.cube.faceTurn(yellow, false);
//				return false;
//		
//		case 4: System.out.println("Aligning top:");
//				this.cube.faceTurn(yellow, true, true);
//				return false;
//				
//		default: return false;
//		}
//	}
//}