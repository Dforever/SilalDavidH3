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

//remove from the list the element with the matching node info
public void remove(String matchData) {
	ListNode element = headNode;
	//not found
	boolean f = false;
	//iterate through the list until found or break
	while (element != null && !f) {
		//find the comparison indicator for element to matchData
		int compareDirection = element.getInfo().compareTo(matchData);
		if (compareDirection == 0) {
			f = true;
			break;
		} else {
			element = element.getTail();
		}
	}
	if (f) {
		//unlink the element from previous
		if (element.getHead() == null) {
			headNode = element.getTail();
		} else {
			element.getHead().setTail(element.getTail());
		}
		//check to see if it has a next list node
		if (element.getTail() != null) {
			element.getTail().setHead(element.getHead());
		} else {
			tailNode = element.getHead();
		}
		//delete it
		element = null;
	}
}

//remove all entris from list
public void removeALL() {
	while (headNode != null) {
		System.out.println("Removing node " + headNode.getInfo());
		ListNode nextListNode = headNode.getTail();

		//are we done?
		if (nextListNode != null) {
			nextListNode.setHead(null);
		} else {
			tailNode = null;
			headNode = null;
		}
		headNode = nextListNode;
	}
}

//add to the list
public void add(String info) {
	ListNode newItem = new ListNode(info);
	ListNode thisNode, tmp;
	boolean ins = false;

	//this is the new head - new list
	if (headNode == null) {
		System.out.println("***adding " + info + " to the new list as head ");
		headNode = newItem;
		tailNode = newItem;
	} else if (headNode.getInfo().compareTo(info) >= 0) {
		newItem.setTail(headNode);
		tmp = headNode;
		tmp.setHead(newItem);
		headNode = newItem;

		System.out.println("***adding " + info + " as the new head ");
	} else {
		tmp = headNode;
		thisNode = headNode.getTail();
		while (thisNode != null && !ins) {
			int isBefore = tmp.getInfo().compareTo(info);
			int isAfter = thisNode.getInfo().compareTo(info);
			if (isAfter >= 0 && isBefore <= 0) {
				newItem.setTail(thisNode);
				newItem.setHead(tmp);
				thisNode.setHead(newItem);
				tmp.setTail(newItem);
				ins = true;

				System.out.println("***adding " + info + " to the middle ");
				break;
			} else {
				tmp = thisNode;
				thisNode = thisNode.getTail();
			}
		}
		if (!ins) {
			tmp.setTail(newItem);
			newItem.setHead(tmp);
			tailNode = newItem;

			System.out.println("***adding " + info + " to the tail ");
		}
	}
}


}

