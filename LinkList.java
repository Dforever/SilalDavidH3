public class LinkList {
	private ListNode headNode;
	private ListNode tailNode;


public LinkList() {
	headNode = null;
	tailNode = null;
}

//print the list in the forward direction
public void print() {
	ListNode element = headNode;
	while (element != null)
	{
		System.out.print(element.getInfo());
		if (element != tailNode)
			System.out.print(" <=> ");
		element = element.getTail();
	}
	System.out.print("\n");
}

//print the list in the backward direction
public void reversePrint() {
	ListNode element = tailNode;
	while (element != null) {
		System.out.print(element.getInfo());
		if(element != headNode)
			System.out.print(" <=> ");
		element = element.getHead();
	}
	System.out.print("\n");
}

//Find the size of the list
public int size() {
	ListNode element = headNode;
	int count = 0;
	//go through each element
	while (element != null)
	{
		count = count + 1;
		element = element.getTail();
	}
	return count;
}

//does the list contain this node's info
public boolean contains(String matchData) {
	//start at the beginning
	ListNode element = headNode;
	boolean f = false;

	//go through the list
	while (element != null) {
		//compare the element with matchData
		int compareDirection = element.getInfo().compareTo(matchData);
		if (compareDirection == 0) {
			f= true;
			break;
		} else if (compareDirection > 0) {
			break;
		}
		element= element.getTail();
	}
	return f;
}


}
