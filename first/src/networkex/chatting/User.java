package networkex.chatting;

import java.io.*;
import java.net.*;
import java.util.*;

public class User {
	/*
	 * Java 간단한 채팅 참조 : https://lktprogrammer.tistory.com/64?category=672211 Hasmap
	 * 참조 : https://codechacha.com/ko/java-map-hashmap/ Iterator 참조 :
	 * https://vaert.tistory.com/108
	 */
	HashMap<String, DataOutputStream> clientmap = new HashMap<String, DataOutputStream>();
	// clientmap은 String형의 key와 DataOutputStream 형의 Value(값)을 받음

	/**
	 * 주석(시진핑 아님): 전달받은 닉네임을 key로, 전달받은 socket을 value로 하여 clientmap(유저 정보를 모아놓은 곳)
	 * 객체에 저장한다.
	 */
	public synchronized void AddClient(String name, Socket socket) {
		try {
			sendMsg(name + " 님이 입장하셨습니다.", "Server"); // server에 입장 메세지 전달
			clientmap.put(name, new DataOutputStream(socket.getOutputStream()));
			// HashMap의 put(key, value)함수는 key와 value를 받는다

			System.out.println("채팅 참여 인원 : " + clientmap.size());
		} catch (Exception e) {

		}
	}

	/**
	 * 주석: 받은 닉네임을 key로 받아 유저 정보에서 제거합니다.
	 * 
	 * @param name 죽일놈
	 */
	public synchronized void RemoveClient(String name) {
		try {
			clientmap.remove(name); // name value를 가지는 client 제거
			sendMsg(name + " 님이 퇴장하였습니다.", "Server");
			System.out.println("채팅 참여 인원 : " + clientmap.size());
		} catch (Exception e) {

		}
	}

	/**
	 * 주석: 모든 클라이언트에게 정보를 전달합니다.
	 * 
	 * @param msg  전달하고자 하는 메세지
	 * @param name 메세지를 전달한 메신저
	 */
	public synchronized void sendMsg(String msg, String name) throws Exception {
		// clientmap의 key 값들을 읽어옵니다.
		Iterator<String> iterator = clientmap.keySet().iterator();
		while (iterator.hasNext()) { // key 값의 next가 존재한다면 계속 루프
			// 채팅을 입력한 유저 이름을 받아와서
			String clientname = (String) iterator.next();
			// 양식대로 채팅을 출력합니다.
			clientmap.get(clientname).writeUTF(name + " : " + msg);
			// 서버에서 클라이언트들의 정보를 저장해 놓은 clientmap 객체 안의
			// 클라이언트에 모두 메세지를 전송하는 자리임.
			// 메세지 형식 => 닉네임 : 메세지
		}
	}
}