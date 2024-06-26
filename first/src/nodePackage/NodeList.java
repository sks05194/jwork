package nodePackage;

public class NodeList<T> {
	Node<T> headNode = null;
	Node<T> tailNode = null;

	// 생성자
	public NodeList() {
	}

	// 객체 추가하기
	public void add(T t) {
		if (headNode == null) {
			headNode = new Node<T>(t);
			tailNode = headNode;
			return;
		}

		tailNode.nextNode = new Node<T>(t);
		tailNode.nextNode.preNode = tailNode;
		tailNode = tailNode.nextNode;
	}

	// 찾기
	public Node<T> findNode(T t) {
		Node<T> curNode = headNode;

		while (curNode.nextNode != null) {
			if (curNode.obj.equals(t))
				return curNode;
			curNode = curNode.nextNode;
		}

		return null;
	}

	// 객체 제거하기
	public void DeleteNode(T t) {
		Node<T> delNode = findNode(t);

		if (delNode == null)
			return;
		else if (delNode == headNode) {
			headNode = delNode.nextNode;
			headNode.preNode = null;
			delNode.nextNode = null;
			return;
		} else if (delNode == tailNode) {
			tailNode = delNode.preNode;
			tailNode.nextNode = null;
			delNode.preNode = null;
			return;
		}

		delNode.nextNode.preNode = delNode.preNode;
		delNode.preNode.nextNode = delNode.nextNode;
		delNode.preNode = null;
		delNode.nextNode = null;
	}
	
	// 인덱스로 찾기
	
	// 중복 검사

	// 출력하기
	@Override
	public String toString() {
		String str = "[ ";
		Node<T> curNode = headNode;

		while (curNode.nextNode != null) {
			str += curNode.toString() + ",  ";
			curNode = curNode.nextNode;
		}
		str += curNode.toString() + " ]";

		return str.trim();
	}
}

class Node<T> {
	Node<T> preNode = null;
	Node<T> nextNode = null;
	T obj = null;

	Node(T t) {
		this.obj = t;
	}

	Node() {
		this(null);
	}

	@Override
	public String toString() {
		return obj.toString();
	}
}