package models;

public class Word {
	private String name;
	private int frequency;
	private double rate;
	
	public Word(String name, int frequency, double rate) {
		this.name = name;
		this.frequency = frequency;
		this.rate = rate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() +
				" [name: " + name + ", frequency: " + frequency + ", rate: " + rate + "]";
	}
}
