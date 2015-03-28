package arcanemaster.ui.fx;

import java.awt.Point;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Polygon;
import arcanemaster.map.grid.Grid;
import arcanemaster.map.grid.GridCoordinate;
import arcanemaster.map.grid.HexGrid;
import arcanemaster.map.grid.Tile;

public class FxTile extends ArcaneTile{
	
	public FxTile(Grid g, GridCoordinate gc) {
		super(g, gc);
		// TODO Auto-generated constructor stub
	}

	public void draw(GraphicsContext gc){
		
		// gc.setFill(terrain.getColor());
		Point[] points = grid.getVertices(location);
		gc.fillPolygon(getXvert(points), getYvert(points), points.length);
	}
	
	private double[] getXvert(Point[] points){
		double[] px = new double[points.length];
		for (int i = 0; i < points.length; i++){
			px[i]= (double)points[i].x;
		}
		return px;
	}
	
	private double[] getYvert(Point[] points){
		double[] py = new double[points.length];
		for (int i = 0; i < points.length; i++){
			py[i]= (double)points[i].y;
		}
		return py;
	}

}
