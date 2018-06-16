//package main.java.adt;
package adt;

/**

 * This class creates Lists to stock data.
 * @author Gabriel Abarca Aguilar
 */
public class List<T> {
	//Atributos
	private ListNode<T> head;
	private int length;
	//Constructor
	public List(){


	}


	public List(T value1, T value2) {

		add(value1);
		add(value2);

	}
	/**

	 * Verifies if the List is empty.
	 *

	 */
	//Validador de Lista Vacia
	public boolean empty(){
		return head == null;
	}
	//Metodos
	/**

	 * Adds values to the list.
	 * @param value: value to add.
	 */
	public void add(T value){//Agregar un miembro a la hilera al final
		ListNode<T>  New = new ListNode<T> (value);
		if (empty()){
			head = New;
		}
		else{
			ListNode<T>  aux = head;
			while(aux.getNext() != null){
				aux=aux.getNext();
			}
			aux.setNext(New);
		}
		length++;
	}
	/**

	 * Searches an element in the list
	 * @param reference: element to search.
	 */
	public boolean contains(T reference){
		ListNode<T> aux = head;
		boolean flag=false;
		while (aux != null && flag != true){
			if (reference == aux.getValue()){
				flag = true;
			}
			else{
				aux = aux.getNext();
			}
		}
		return flag;
	}
	public void delete(int pos) {//Obtener valor por referencia
		if(pos >= 0 && pos < length) {
			if (pos == 0){
				head = head.getNext();
			}else {
				ListNode<T> aux = head;
				for (int i = 0; i < pos; i++) {
					aux = aux.getNext();
				}
				ListNode<T> next = aux.getNext().getNext();
				aux.setNext(next);
			}
		}
	}

	/**
	 * Deletes an element in the list
	 * @param reference: element to delete.
	 */
	public void delete(T reference){//Elimina un miembro por referencia
		if (contains(reference)){
			if (head.getValue() == reference){
				head = head.getNext();
			}
			else{
				ListNode<T> aux = head;
				while(aux.getNext().getValue() != reference){
					aux = aux.getNext();
				}
				ListNode<T> next = aux.getNext().getNext();
				aux.setNext(next);
			}
			length--;
		}
	}
	/**

	 * Erases the list
	 */
	public void erase(){//Elimina la lista
		head = null;
		length = 0;
	}
	/**

	 * Searches an element in the list by the position.
	 * @param pos: position of the element.
	 */
	public T getValue(int pos) {//Obtener valor por referencia
		if(pos >= 0 && pos < length) {
			if (pos == 0){
				return head.getValue();
			}else {
				ListNode<T> aux = head;
				for (int i = 0; i < pos; i++) {
					aux = aux.getNext();
				}
				return aux.getValue();
			}
		}else {
			return null;
		}
	}
	public void print(){
		for (int i = 0; i<this.length;i++){
			System.out.println(this.getValue(i));
		}

	}
	//Getters y Setters
	public ListNode<T> getHead() {
		return head;
	}

	public void setHead(ListNode<T> head) {
		this.head = head;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

}
