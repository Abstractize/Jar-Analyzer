package main.java.adt;

public class ListNode<T>  {

	private T value;
	private ListNode<T> next;
	/**

	 * Constructor
	 * @param value: value inside the node.

	 */
	public ListNode(T value) {
		this.value = value;
		this.next = null;
	}
	/**

	 * Getters and Setters

	 */
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public ListNode<T> getNext() {
		return next;
	}
	public void setNext(ListNode<T> next) {
		this.next = next;
	}
	

}
