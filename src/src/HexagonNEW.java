package src;

import java.util.ArrayList;

import javafx.scene.shape.Polygon;

public class HexagonNEW {

	//Data Field	
	public char[] colors = new char[6];
	public int tileNum;
	public int positionNumber;
	public ArrayList<Polygon> triangles = new ArrayList<Polygon>(); 
	
	//Constructor
	public HexagonNEW(char[] colors, int tileNum) {
		this.colors = colors;
		this.tileNum = tileNum;
	}
	
	//Copy constructor
	public HexagonNEW(HexagonNEW copy) {
		
		for (int i = 0; i < this.colors.length; i++) {
			this.colors[i] = copy.colors[i];
		}
		this.tileNum = copy.tileNum;
		this.positionNumber = copy.positionNumber;
	}
	
	public HexagonNEW() {
		
	}
	
	///////////////////////////////////////////////////////////////////////
	//Getters and Setters		
	public int getTileNum() {
		return tileNum;
	}

	public char[] getColors() {
		return colors;
	}

	public void setColors(char[] colors) {
		this.colors = colors;
	}

	public void setTileNum(int tileNum) {
		this.tileNum = tileNum;
	}
	
	public int getPositionNumber() {
		return positionNumber;
	}

	public void setPositionNumber(int positionNumber) {
		this.positionNumber = positionNumber;
	}

	//rotate the colors of hexagon (Shift right by 1)
	public void rotate() {
		
		char temp = this.colors[colors.length - 1];
		
		//shift right		
		for (int i = this.colors.length - 2; i >= 0; i--) {
			this.colors[i + 1] = this.colors[i];
		}
		
		this.colors[0] = temp;		
	}

	@Override
	public String toString() {
		String output = "";
		
		output += "Tile #" + this.tileNum + "   ";
		
		for (int i = 0; i < this.colors.length; i++) {
			output += this.colors[i] + "   ";
		}
		
		
		return output;
	}
	
	@Override
	public boolean equals(Object i2) {
		if (!(i2 instanceof HexagonNEW)) {
			return false;
		}
		
		HexagonNEW temp = (HexagonNEW)i2;
		
		boolean numEqual = this.tileNum == temp.tileNum;
		
		boolean colorEqual = true;

		for (int i = 0; i < this.colors.length; i++ ) {
			colorEqual = this.colors[i] == temp.colors[i];
		}

		return numEqual && colorEqual;
	}

	public void copyColors(HexagonNEW hexagon) {
		this.colors = new char[6];
		for (int i = 0; i < this.colors.length; i++) {
			this.colors[i] = hexagon.colors[i];
		}
	}
	
	
	
}
