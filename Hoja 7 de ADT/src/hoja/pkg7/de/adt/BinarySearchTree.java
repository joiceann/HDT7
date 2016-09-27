package hoja.pkg7.de.adt;

/*Universidad del Valle de Guatemala
  Algoritmos y Estructura de datos
  Joyce Miranda
  Jorge Suchite
  Hoja de trabajo 7
  Fecha: 27/09/2016 */





/* guiado por http://stackoverflow.com/questions/33855821/binary-search-tree-class-remove-search-insert-remove-and-iterator-methods
*/


public class BinarySearchTree<E extends Comparable<E>, V> {

	private Node<E, V> root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	
	public V lookup(E key) {
		return lookup(root, key);
	}
	
	private V lookup(Node<E, V> n, E key) {
		if (n == null) {
			return null;
		} if (n.getKey().equals(key)) {
			return n.getValue();
		} if (key.compareTo(n.getKey()) < 0) {
			return lookup(n.getLeft(), key);
		} else {
			return lookup(n.getRight(), key);
		}
	}
	
	public void insert (E key, V value) throws Exception {
		root = insert(root, key, value);
	}
	
	
	private Node<E, V> insert(Node<E, V> n, E key, V value) throws Exception {
		if (n == null) {
			root = new Node<E, V> (key, value, null, null);
			return new Node<E, V> (key, value, null, null);
		} if (n.getKey().equals(key)) {
			throw new Exception();
		} if (key.compareTo(n.getKey()) < 0) {
			n.setLeft(insert(n.getLeft(), key, value));
			return n;
		} else {
			n.setRight(insert(n.getRight(), key, value));
			return n;
		}
	}
	

	public void inOrder() {
		inOrder(root);
	}
	

	private void inOrder(Node<E, V> node) {
		if (node == null) {
			return;
		}
		inOrder(node.getLeft());
		System.out.println(node.getKey() + ": " + node.getValue());
		inOrder(node.getRight());
	}
}
