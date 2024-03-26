package useinterface;

public class Square {
    private int vitri; //vi trí của ô
	private int giatri;
    private boolean isquan;
    public Square(int vitri, int giatri, boolean isquan) {
		this.vitri = vitri;
		this.giatri = giatri;
		this.isquan = isquan;
	}
	public int getGiatri() {
		return giatri;
	}

	public void setGiatri(int giatri) {
		this.giatri = giatri;
	}

	public boolean isQuan() {
		return isquan;
	}

	public void setQuan(boolean isquan) {
		this.isquan = isquan;
	}

	public int getViTri() {
		return vitri;
	}

	public void setViTri(int vitri) {
		this.vitri = vitri;
	}
}
