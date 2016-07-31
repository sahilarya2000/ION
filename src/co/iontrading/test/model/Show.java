package co.iontrading.test.model;

import java.time.LocalDate;

public class Show
{
	private String movie;

	private ShowSlot slot;

	private LocalDate showDate;
	
	private int audiNumber;

	public int getAudiNumber() {
		return audiNumber;
	}

	public void setAudiNumber(int audiNumber) {
		this.audiNumber = audiNumber;
	}

	public LocalDate getShowDate()
	{
		return showDate;
	}

	public void setShowDate(LocalDate showDate)
	{
		this.showDate = showDate;
	}

	private int showId;

	public int getShowId()
	{
		return showId;
	}

	public void setShowId(int showId)
	{
		this.showId = showId;
	}

	public String getMovie()
	{
		return movie;
	}

	public void setMovie(String movie)
	{
		this.movie = movie;
	}

	public ShowSlot getSlot()
	{
		return slot;
	}

	public void setSlot(ShowSlot slot)
	{
		this.slot = slot;
	}

}
