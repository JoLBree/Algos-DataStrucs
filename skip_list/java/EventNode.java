import java.util.LinkedList;

//
// EVENT.JAVA
//
// Describes a historical event via two public fields:
//  year        -- the year of the event (an integer)
//  description -- the text for the event (a String)
//

class EventNode {

	public EventNode[] next;
	public int height;
	public LinkedList<Event> events;
	public int key;

	public EventNode(int h, Event e) {
		height = h;
		next = new EventNode[height];
		events = new LinkedList<Event>();
		key = e.year;
		events.add(e);		
	}

	public void add(Event e){
		events.add(e);
	}

	// print method
	public String toString()
	{
		String r = ""+key+" ("+events.size()+")";
//		if (key == 1615 || key == 1645){
//			for (Event e : events){
//				r += e.description + ", ";
//			}
//		}
		//		for (Event e : events){
		//			r += e.description + ", ";
		//		}
		return r;
	}


}
