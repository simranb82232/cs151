package trs;

public class Section {
	private String section;
	public Section(String s) {
		section = s;
	}
	public int getMax() {
		if (section.equals("mf")) {
			return 150;
		}
		if (section.equals("sb")) {
			return 50;
		}
		if (section.equals("eb") || section.equals("wb")) {
			return 100;
		}
		return 0;
	}
}
