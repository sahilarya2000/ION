package ion;

public class Show {
private String movie;
private float slot ;
private int showId;

Show(String movie ,int slot)
{	
this.movie = movie;
this.slot = slot;
}

public int getShowId() {
	return showId;
}

//public void setShowId(int showId) {
//	this.showId = showId;
//}

public String getMovie() {
	return movie;
}

public void setMovie(String movie) {
	this.movie = movie;
}

public float getSlot() {
	return slot;
}

public void setSlot(float slot) {
	this.slot = slot;
}

}
