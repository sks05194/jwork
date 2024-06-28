package practice.nodePackage;

import java.util.ArrayList;
import java.util.List;

/* 추가했으면 하는 기능들 (구현 완료 기능과 구현 예정 기능이 혼재되어 있음.)
기본 기능
노드 추가:
!	리스트의 끝에 노드를 추가.
!	리스트의 시작에 노드를 추가.
	특정 인덱스에 노드를 추가.
노드 삭제:
	리스트의 끝에서 노드 삭제.
	리스트의 시작에서 노드 삭제.
!	특정 인덱스의 노드 삭제.
노드 검색:
!	특정 값의 노드 검색.
!	특정 인덱스의 노드 검색.

고급 기능
리스트 순회:
!	리스트의 모든 노드를 순차적으로 출력.
	리스트의 모든 노드를 역순으로 출력.
리스트 크기 반환:
	리스트에 있는 노드의 개수 반환.
노드 업데이트:
	특정 인덱스의 노드 값을 업데이트.
리스트 정렬:
	노드 값을 기준으로 리스트 정렬.
중복 값 제거:
	리스트에서 중복된 값을 제거.
리스트 반전:
	리스트의 노드 순서를 반전.
부분 리스트 생성:
	시작 인덱스와 끝 인덱스를 기반으로 부분 리스트 생성.

추가 기능
특정 조건에 따른 노드 삭제:
	특정 조건을 만족하는 노드를 삭제.
리스트 합치기:
	두 개의 리스트를 합치는 기능.
리스트 비교:
	두 리스트가 동일한지 비교.
중간 노드 찾기:
	리스트의 중간에 위치한 노드 찾기.
순환 리스트 검사:
	리스트가 순환(circular)하는지 검사.
리스트에서 n번째 마지막 노드 찾기:
	리스트의 끝에서부터 n번째 위치한 노드 찾기.

예시 기능 설명
	노드 추가 (끝): 리스트의 끝에 새로운 노드를 추가하는 기능입니다.
	노드 삭제 (시작): 리스트의 첫 번째 노드를 삭제하는 기능입니다.
	노드 검색 (값): 특정 값을 가지는 노드를 찾아 반환하는 기능입니다.
	리스트 순회 (역순): 리스트의 모든 노드를 역순으로 순회하며 출력하는 기능입니다.
	리스트 정렬: 노드 값에 따라 리스트를 정렬하는 기능입니다.
 */

public class NodeList<T> {
	Node<T> headNode = null;
	Node<T> tailNode = null;

	public int size = 0;

	// 값으로 추가하기
	public void add(T t) {
		size++;

		if (headNode == null) {
			headNode = new Node<T>(t);
			tailNode = headNode;
			return;
		}

		tailNode.nextNode = new Node<T>(t);
		tailNode.nextNode.preNode = tailNode;
		tailNode = tailNode.nextNode;
	}

	// 값으로 찾기
	public Node<T> findNode(T t) {
		Node<T> curNode = headNode;

		while (curNode != null) {
			if (curNode.data.equals(t))
				return curNode;
			curNode = curNode.nextNode;
		}

		return null;
	}

	public boolean contains(T t) {
		if (findNode(t) == null)
			return false;
		return true;
	}

	// 인덱스로 찾기
	public Node<T> indexOf(int index) {
		if (index < 0 || index >= size)
			return null;

		Node<T> curNode = headNode;

		for (int i = 1; i <= index; i++)
			curNode = curNode.nextNode;

		return curNode;
	}

	// 객체 제거하기(객체)
	private void delNode(Node<T> delNode) {
		if (delNode == null)
			return;

		size--;

		// 제장된 데이터가 하나였을 경우
		if (size == 0) {
			headNode = null;
			tailNode = null;
			return;
		}
		// 저장된 데이터가 첫 번째 데이터였을 경우
		if (delNode == headNode) {
			headNode = delNode.nextNode;
			headNode.preNode = null;
			delNode.nextNode = null;
			return;
		}
		// 저장된 데이터가 마지막 데이터였을 경우
		if (delNode == tailNode) {
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

	// 객체 제거하기(값)
	public void deleteNode(T t) {
		Node<T> delNode = findNode(t);

		if (delNode == null)
			return;

		delNode(delNode);
	}

	// 중복되는 데이터 삭제
	public void removeDuplicates() {
		List<T> discoveredDatas = new ArrayList<T>();
		Node<T> curNode = headNode;
		Node<T> delNode = null;

		while (curNode != null) {
			if (discoveredDatas.contains(curNode.data)) {
				delNode = curNode;
				curNode = curNode.nextNode;
				delNode(delNode);
			} else {
				discoveredDatas.add(curNode.data);
				curNode = curNode.nextNode;
			}
		}
	}

	// 정렬
	public void sort() {
		// TODO: 나중에 만들게요...
	}

	// 자리 변경하기
	@SuppressWarnings("unused")
	private void change(Node<T> back, Node<T> front) {

	}

	// 출력하기
	@Override
	public String toString() {
		if (size == 0)
			return "[]";

		StringBuilder str = new StringBuilder("[ ");
		Node<T> curNode = headNode;

		while (curNode.nextNode != null) {
			str.append(curNode.toString() + ",  ");
			curNode = curNode.nextNode;
		}
		str.append(curNode.toString() + " ]");

		return str.toString();
	}
}

class Node<T> {
	Node<T> preNode = null;
	Node<T> nextNode = null;
	T data = null;

	Node(T t) {
		this.data = t;
	}

	Node() {
		this(null);
	}

	public T getData() {
		return data;
	}

	@Override
	public String toString() {
		return data.toString();
	}
}