package arcanemaster.ui.fx;

import java.awt.Point;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Polygon;
import arcanemaster.map.ArcaneTile;
import arcanemaster.map.Resource;
import arcanemaster.map.Terrain;
import arcanemaster.map.grid.Grid;
import arcanemaster.map.grid.GridCoordinate;
import arcanemaster.map.grid.HexGrid;
import arcanemaster.map.grid.Tile;

public class FxTile extends ArcaneTile{
	
	Polygon hex;
	
	public FxTile() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FxTile(Terrain terrain, Point[] vertices) {
		this(terrain, Resource.NONE, vertices);
		// TODO Auto-generated constructor stub
	}
	
	public FxTile(Terrain terrain, Resource resource, Point[] vertices) {
		super(terrain, resource);
		hex = new Polygon(getVertices(vertices));
	}

	
//	public void draw(GraphicsContext gc){
//		
//		// gc.setFill(terrain.getColor());
//		Point[] points = grid.getVertices(location);
//		gc.fillPolygon(getXvert(points), getYvert(points), points.length);
//	}
	
//	private double[] getXvertices(Point[] points){
//		double[] px = new double[points.length];
//		for (int i = 0; i < points.length; i++){
//			px[i]= (double)points[i].x;
//		}
//		return px;
//	}
//	
//	private double[] getYvertices(Point[] points){
//		double[] py = new double[points.length];
//		for (int i = 0; i < points.length; i++){
//			py[i]= (double)points[i].y;
//		}
//		return py;
//	}
	
	private double[] getVertices(Point[] points){
		double[] vertices = new double[points.length*2];
		for (int i = 0; i < vertices.length; i++){
			vertices[i]= (double)points[i].x;
			i++;
			vertices[i] = (double)points[i].y;
		}
		return vertices;
	}
	
	public Polygon getPolygon(){
		return hex;
	}

}
