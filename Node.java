//This is derived from the link(https://github.com/csi-cen-213) on the CSI-213CLASS github
public class Node{
	//the data for the node
	private String data;
	//The node for Previous
	private Node pre;
	//The node for Next
	private Node nxt;
	//This constructor contains just solely data
	public Node(String Data) {
		data = Data;
		pre = null;
		nxt = null;

	}
	//This constructor has data, previous, and next
	public Node(String Data, Node Previous, Node Next) {
		data = Data;
		pre = Previous;
		nxt = Next;
	}
	//Will set the data element
	public void setData(String Data) {
		data = Data;
	}
	//Will set the node of previous
	public void setPrevious(Node Previous) {
		pre = Previous;
	}
	//Will set the node of next
	public void setNext(Node Next) {
		nxt = Next;
	}
	//This will return the data element
		public String getData() {
			return data;
	}
	//Getter that will return the node previous
	public Node getPrevious() {
		return pre;
	}
	//Getter that will return the node next
	public Node getNext() {
		return nxt;
	}

}