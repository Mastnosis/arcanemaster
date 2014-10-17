package arcanemaster.map;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Map;

import arcanemaster.unit.Movement;
import arcanemaster.unit.Unit;

public class Board {
	
	int horizontalsize;
	int verticalsize;
	
	boolean horizontalwrap = false;
	boolean verticalwrap = false;
	
	List<Tile> tiles;
	
	public Board(){
		this(20, 10);
	}
	
	public Board(int horizontal, int vertical){
		this(horizontal, vertical, false, false);
	}
	
	public Board(int horizontal, int vertical, boolean wrapH, boolean wrapV){
		horizontalsize = horizontal;
		verticalsize = vertical;
		horizontalwrap = wrapH;
		verticalwrap = wrapV;
		initMap();
	}
	
	private void initMap(){
		tiles = new ArrayList<Tile>(horizontalsize*verticalsize);
		for(int i = 0; i < horizontalsize*verticalsize; i++){
			tiles.add(new Tile());
		}
	}
	
	public Set<Tile> getNeighbors(int h, int v){
		int offset = 1;  // even rows have above and below neighbors shifted one towards the negative
		if (v %2 == 1){	// check for odd rows
			offset = 0;
		}
		Set <Tile> neighbors = new LinkedHashSet<Tile>();  // edge tiles my have less than 6 neighbors otherwise a fixed array would be preferrable
		neighbors.add(getTile(h +1, v ));
		neighbors.add(getTile(h -1, v));
		neighbors.add(getTile(h - offset, v+1));
		neighbors.add(getTile(h +1 -offset, v+1));
		neighbors.add(getTile(h - offset, v-1));
		neighbors.add(getTile(h +1 -offset, v-1));
		for (Tile t: neighbors){
			if(t == null){
				neighbors.remove(t);	// get rid of all the null values so we don't have to deal with them in pathing calculations
			}
		}
		return neighbors;
	}
	
	public Tile getTile(int h, int v){
		if(h >= 0 && h < horizontalsize){
			if(v >= 0 && v < verticalsize){
				return tiles.get(h + horizontalsize * v);
			}
		}
		return null;
	}
	
	public Set<Tile> radius(Tile tile, int radius){
		Set<Tile> s = new LinkedHashSet<Tile>();
		if(radius >= 0){
			s.add(tile);
			for(; 0 < radius; radius--){
				for(Tile t:s){
				s.addAll(neighbors(t));
				}
			}
		}
		return s;
	}
	
	public Set<Tile> ring(Tile t, int r){
		Set<Tile> s = radius(t,r);
		s.removeAll(radius(t,r));
		return s;
	}
	
	public Set<Tile> neighbors(Tile t){
//		Set<Tile> s = new LinkedHashSet<Tile>();
//		Tile a,b,c,d,e,f;
//		int x,y;
//		if (null != t){
//			a = getTile(x, y);
//			b = getTile(x, y);
//			c = getTile(x, y);
//			d = getTile(x, y);
//			e = getTile(x, y);
//			f = getTile(x, y);
//			s.add(a);
//			s.add(b);
//		return ring(t, 1);
		return null;
	}
	
	private int getX(Tile t){
		//tiles.
		return 0;
	}
	
	private int getY(Tile t){
		return 0;
	}
	
	public Set<Tile> getShortestPath(Unit traveler, int originX, int originY, int destX, int destY){
		int origindex = originX + horizontalsize*originY;
		int destindex = destX + horizontalsize*destY;
		Tile currenttile = tiles.get(origindex);
				
		// create a list of all tiles and the movement cost to each
		Map<Tile,Integer> costs = new LinkedHashMap<Tile, Integer>();
		Set<Tile> unvisited = new LinkedHashSet<Tile>(tiles);
		// LinkedList<Tile> visited = new LinkedList<Tile>();
		
		// set all costs to MAXINT
		for(Tile t: unvisited){
			costs.put(t, Integer.MAX_VALUE);
		}
		
		// set movement cost to original hex to 0
		costs.put(currenttile, 0);
		
		boolean complete = false;
		
		while(!complete){
			// calculate the cost of moving to all neighbors
			for(Tile t: currenttile.getNeighbors()){
				if (unvisited.contains(t)){
					int turndelay = calculateDelay(costs.get(currenttile), 
							t.costToEnter(traveler.movement()), traveler.movement());  //this needs to be calculated to account for insufficient remaining move points in a turn
					int movecost = costs.get(currenttile) + t.costToEnter(traveler) + turndelay;
					if (movecost < costs.get(t)){
						costs.put(t, movecost);
					}
				}
			}

			// mark current tile visited
			unvisited.remove(currenttile);
			
			// break while if destination has been reached.
			if(currenttile.equals(tiles.get(destindex))){
				complete = true;
			}

			// get tile with lowest move cost and set as current tile
			int lowest = Integer.MAX_VALUE;
			//currenttile = unvisited.;  // grab the first element
			for(Tile t: unvisited){
				if (costs.get(t)< lowest){
					currenttile = t;
				}
			}
			// break loop if destination is unreachable
			if(costs.get(currenttile) == Integer.MAX_VALUE){
				complete = true;
			}
		}
		
		
		return determineOptimalPath(costs, tiles.get(destindex));
	}
	
	/*
	 * This method is required to account for movement costs where there is
	 * insufficient movement remaining in the current turn to enter the new hex.
	 * If the previous hex is occupied then it's cost must also be added since the unit must
	 * move in one complete motion.  It must wait until it can move through the occupied hex
	 * and into the target hex without interruption.
	 */
	private int calculateDelay(int costtocurrent, int costtoenternew, Movement move) {
		int delay = 0;
		/*
		 * calculate the number of movement points remaining in the turn after 
		 * moving to the current tile which may happen over multiple turns.
		 */
		
//		if (t.isOccupied()){
//			if (0 == move.getMovementPerTurn()-(move.getRemainingMove() - ))
//		}
//		int m = 0;
//		if (m < t.costToEnter(move)){
//			if(t.isOccupied()){
//				m += currenttile.costToEnter(move);
//			}
//			return m;
//		}
		return delay;
	}

	private Set<Tile> determineOptimalPath(Map<Tile, Integer> movementcosts, Tile destination){
		Set<Tile> path = new LinkedHashSet<Tile>();
		path.add(destination);
		Tile next = destination;
		while(movementcosts.get(next) <= 0){
			for(Tile t: next.getNeighbors()){
				
			}
		}
		return path;
	}

}
