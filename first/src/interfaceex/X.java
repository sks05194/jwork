package interfaceex;

public interface X {
	void xmeth1();

	void xmeth2();
}

interface Y {
	void ymeth1();
}

interface Z extends X, Y {
	void zmeth1();
}