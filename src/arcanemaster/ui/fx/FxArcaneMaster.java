package arcanemaster.ui.fx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import arcanemaster.map.MapBoard;
import arcanemaster.map.grid.HexGrid;


public class FxArcaneMaster extends Application {
	
	private MapBoard.Size size = MapBoard.Size.SMALL;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Drawing Operations Test");
        Group root = new Group();
        Canvas canvas = new Canvas(1280, 720);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        FxMapBoard map = new FxMapBoard(new HexGrid(), size.dimensionY(), size.dimensionX(), false, false);
        map.draw(gc);
        // drawShapes(gc);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
	}

//	private void drawShapes(GraphicsContext gc) {
//		gc.setFill(Color.GREEN);
//        gc.setStroke(Color.BLUE);
//        gc.setLineWidth(5);
////        gc.strokeLine(40, 10, 10, 40);
////        gc.fillOval(10, 60, 30, 30);
////        gc.strokeOval(60, 60, 30, 30);
////        gc.fillRoundRect(110, 60, 30, 30, 10, 10);
////        gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
////        gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
////        gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
////        gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
////        gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
////        gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
////        gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
////        gc.fillPolygon(new double[]{10, 40, 10, 40},
////                       new double[]{210, 210, 240, 240}, 4);
////        gc.strokePolygon(new double[]{60, 90, 60, 90},
////                         new double[]{210, 210, 240, 240}, 4);
////        gc.strokePolyline(new double[]{110, 140, 110, 140},
////                          new double[]{210, 210, 240, 240}, 4);
////		HexGrid hg = new HexGrid();
////		Point[] points = hg.getVertices(new GridCoordinate(0,0));
////		for (Point point : points) {
////			System.out.println(point.toString());
////		}
//		for(int i = 0; i < 10; i++){
//			for(int j = 0; j < 10; j++){
//				printHex(gc, i, j);
//			}
//		}
//		
//		
//		
////		gc.fillPolygon(getXvert(points), getYvert(points), 6);
//		gc.setFill(Color.RED);
//		for(int i = 0; i < 10;i++){
//			printHex(gc, i, 1);
//		}
////		points = hg.getVertices(new GridCoordinate(0,1));
////		gc.fillPolygon(getXvert(points), getYvert(points), 6);
//		
//		
//	}
//	
//	private void printHex(GraphicsContext gc, int x, int y){
//		Point[] points = HexGrid.getVertices(x, y);
//		gc.fillPolygon(getXvert(points), getYvert(points), 6);
//	}
//	
//	private double[] getXvert(Point[] points){
//		double[] px = new double[points.length];
//		for (int i = 0; i < points.length; i++){
//			px[i]= (double)points[i].x;
//		}
//		return px;
//	}
//	
//	private double[] getYvert(Point[] points){
//		double[] py = new double[points.length];
//		for (int i = 0; i < points.length; i++){
//			py[i]= (double)points[i].y;
//		}
//		return py;
//	}

}
