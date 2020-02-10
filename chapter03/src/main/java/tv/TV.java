package tv;

public class TV {
	private int channel;
	private int volume;
	private boolean power;

	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}

	public int getChannel() {
		return channel;
	}

	public int getVolume() {
		return volume;
	}

	public boolean isPower() {
		return power;
	}

	public void power(boolean p) {
		if (p) {
			power = true;
		} else {
			power = false;
		}
	}

	public void channel(int channel) {
		if(channel<1) {
			this.channel = 255;
		}
		else if(channel > 255) {
			this.channel = 1;
		}
		else{
			this.channel = channel;
		}
	}

	public void channel(boolean up) {
		if(up) {
			channel ++;
		}
		else {
			channel --;
		}
		channel(channel);
		
		
	}

	public void volume(int volume) {
		if(volume<1) {
			this.volume = 255;
		}
		else if(volume > 255) {
			this.volume = 1;
		}
		else{
			this.volume = volume;
		}
	}

	public void volume(boolean up) {
		if(up) {
			volume ++;
		}
		else {
			volume --;
		}
		volume(volume);
	}

	public void status() {
		System.out.println("TV[channel=" + channel + ", volume=" + volume + ", power=" + power + "]");
	}
}
