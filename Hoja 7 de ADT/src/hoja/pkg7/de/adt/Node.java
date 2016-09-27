/*Universidad del Valle de Guatemala
  Algoritmos y Estructura de datos
  Joyce Miranda
  Jorge Suchite
  Hoja de trabajo 7
  Fecha: 27/09/2016 */



package hoja.pkg7.de.adt;

public class Node<E, K> {

	private E key;
	private K value;
	private Node<E, K> left;
	private Node<E, K> right;
	

	public Node(E key, K value, Node<E, K> left, Node<E, K> right) {
		this.setKey(key);
		this.setValue(value);
		this.setLeft(left);
		this.setRight(right);
	}

	
	public E getKey() {
		return key;
	}

	
	public void setKey(E key) {
		this.key = key;
	}


	public K getValue() {
		return value;
	}

	
	public void setValue(K value) {
		this.value = value;
	}


	public Node<E, K> getLeft() {
		return left;
	}


	public void setLeft(Node<E, K> left) {
		this.left = left;
	}


	public Node<E, K> getRight() {
		return right;
	}

	
	public void setRight(Node<E, K> right) {
		this.right = right;
	}
}
