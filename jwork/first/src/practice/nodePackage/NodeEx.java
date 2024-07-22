package practice.nodePackage;

public class NodeEx {
	public static void main(String[] args) {
		NodeList<Integer> nodeList = new NodeList<>();

		nodeList.add(1);
		nodeList.add(3);
		nodeList.add(2);
		nodeList.add(1);
		nodeList.add(4);
		nodeList.add(7);
		nodeList.add(9);
		nodeList.add(8);
		nodeList.add(5);
		nodeList.add(3);
		nodeList.add(4);

		System.out.println(nodeList.indexOf(0).data.equals(nodeList.indexOf(3).data));
		System.out.println("4번 인덱스 : " + nodeList.indexOf(4));

		nodeList.removeDuplicates();
		System.out.println("중복 데이터 삭제 후 : " + nodeList);

		int cn = 7;
		if (nodeList.contains(cn))
			System.out.println(cn + "은 포함되어있습니다.");
		else
			System.out.println(cn + "은 포함되어있지 않습니다.");
	}
}