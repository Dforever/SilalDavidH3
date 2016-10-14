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


}
