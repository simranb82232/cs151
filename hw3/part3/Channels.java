package part3;

public enum Channels {
	CHANNEL1(1), CHANNEL2(2), CHANNEL3(3), CHANNEL4(4);
	private final int channelNum;
	
	private Channels(int channelNumber) {
		channelNum = channelNumber;
	}
	
	public int getChannelNumber() {
		return channelNum;
	}
}
