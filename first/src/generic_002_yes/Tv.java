package generic_002_yes;

public class Tv {
	String programName;
	int channel;
	int volumn;
	int light;

	public Tv() {
		
	}

	public Tv(String programName, int channel, int volumn, int light) {
		this.programName = programName;
		this.channel = channel;
		this.volumn = volumn;
		this.light = light;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public int getVolumn() {
		return volumn;
	}

	public void setVolumn(int volumn) {
		this.volumn = volumn;
	}

	public int getLight() {
		return light;
	}

	public void setLight(int light) {
		this.light = light;
	}

	@Override
	public String toString() {
		return "Tv [programName=" + programName + ", channel=" + channel + "번, volumn=" + volumn + ", light=" + light
				+ "]";
	}
}