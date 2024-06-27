package nodePackage;

import java.util.Vector;

public class NodeEx {
	public static void main(String[] args) {
		NodeList<Integer> nodeList = new NodeList<>();
		
		nodeList.add(1);
		nodeList.add(3);
		nodeList.add(2);
		nodeList.add(1);
		nodeList.add(4);
		
		System.out.println(nodeList);
		System.out.println(nodeList.headNode);
		System.out.println(nodeList.tailNode);
		
		nodeList.DeleteNode(2);
		System.out.println(nodeList);
		
		Vector<Integer> v = new Vector<Integer>();
		v.add(12);
		
		System.out.println(v.toString());
	}
}