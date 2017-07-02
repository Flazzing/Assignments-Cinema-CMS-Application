
public class Ticket {
	
	public Ticket(){
		super();	
	}
	

	

	public String getTicketMovieName() {
		return TicketMovieName;
	}
	public void setTicketMovieName(String ticketMovieName) {
		TicketMovieName = ticketMovieName;
	}
	public String getTicketMovieTime() {
		return TicketMovieTime;
	}
	public void setTicketMovieTime(String ticketMovieTime) {
		TicketMovieTime = ticketMovieTime;
	}
	public String getTicketDate() {
		return TicketDate;
	}
	public void setTicketDate(String ticketDate) {
		TicketDate = ticketDate;
	}
	public String getTicketSeat() {
		return TicketSeat;
	}
	public void setTicketSeat(String ticketSeat) {
		TicketSeat = ticketSeat;
	}
	public double getTicketChildPrice() {
		return TicketChildPrice;
	}
	public void setTicketChildPrice(double ticketChildPrice) {
		TicketChildPrice = ticketChildPrice;
	}
	public double getTicketAdultPrice() {
		return TicketAdultPrice;
	}
	public void setTicketAdultPrice(double ticketAdultPrice) {
		TicketAdultPrice = ticketAdultPrice;
	}
	public String getTicketType() {
		return TicketType;
	}
	public void setTicketType(String ticketType) {
		TicketType = ticketType;
	}
	public int getValidTotalpeople() {
		return ValidTotalpeople;
	}
	public void setValidTotalpeople(int validTotalpeople) {
		ValidTotalpeople = validTotalpeople;
	}




	private String TicketMovieName = null;
	@Override
	public String toString() {
		return "Ticket [TicketMovieName=" + TicketMovieName + ", TicketMovieTime=" + TicketMovieTime + ", TicketDate="
				+ TicketDate + ", TicketSeat=" + TicketSeat + ", TicketChildPrice=" + TicketChildPrice
				+ ", TicketAdultPrice=" + TicketAdultPrice + ", TicketType=" + TicketType + ", ValidTotalpeople="
				+ ValidTotalpeople + "]";
	}




	private String TicketMovieTime = null;
	private String TicketDate = null;	
	private String TicketSeat = null;	
	private double TicketChildPrice = 10;
	private double TicketAdultPrice = 15;
	private String TicketType = null;
	private int ValidTotalpeople =0;

}
