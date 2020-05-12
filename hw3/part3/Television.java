package part3;

public class Television {
	public static void changeChannel(Channels channel) {
		switch(channel) {
			case CHANNEL1:
				System.out.println("Channel " + channel.getChannelNumber()
				+ ": " + 100*Math.random());
				break;
			
			case CHANNEL2:
				System.out.println("Channel " + channel.getChannelNumber()
				+ ": " + 100*Math.random());
				break;
				
			case CHANNEL3:
				System.out.println("Channel " + channel.getChannelNumber()
				+ ": " + 100*Math.random());
				break;
				
			case CHANNEL4:
				System.out.println("Channel " + channel.getChannelNumber()
				+ ": " + 100*Math.random());
				break;
		}
	}
	
	public static void main(String[] args) {
		Channels channel1 = Channels.CHANNEL1;
		Channels channel2 = Channels.CHANNEL2;
		Channels channel3 = Channels.CHANNEL3;
		Channels channel4 = Channels.CHANNEL4;
		changeChannel(channel1);
		changeChannel(channel2);
		changeChannel(channel3);
		changeChannel(channel4);
	}
}
