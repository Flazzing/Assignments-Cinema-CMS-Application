


public class Ticket {
	
 /**
     * @param 
     * return
     */
	public Ticket(){
		super();	
	}
		
 /**
     * @param 
     * @return String 
     */
	public String getTicketMovieName() {
		return TicketMovieName;
	}
	
	 /**
     * @param ticketMovieName : String
     * @return void
     */
	
	public void setTicketMovieName(String ticketMovieName) {
		TicketMovieName = ticketMovieName;
	}
	
 /**
     * @param 
     * @return String
     */
	
	public String getTicketMovieTime() {
		return TicketMovieTime;
	}
	
     /**
     * @param ticketMovieName : String
     * @return void
     */

	public void setTicketMovieTime(String ticketMovieTime) {
		TicketMovieTime = ticketMovieTime;
	}
	
     /**
     * @param
     * @return String
     */
	
	public String getTicketDate() {
		return TicketDate;
	}
	
      /**
     * @param ticketData : String
     * @return void
     */
	
	public void setTicketDate(String ticketDate) {
		TicketDate = ticketDate;
	}
	
	 /**
     * @param
     * @return TicketSeat : String 
     */
	
	public String getTicketSeat() {
		return TicketSeat;
	}
	
	 /**
     * @param ticketSeat : String
     * @return void 
     */
	
	public void setTicketSeat(String ticketSeat) {
		TicketSeat = ticketSeat;
	}
	
	 /**
     * @param
     * @return TicketChildPrice : double 
     */
	
	public double getTicketChildPrice() {
		return TicketChildPrice;
	}
	
	 /**
     * @param ticketChildPrice : double
     * @return void 
     */
	
	public void setTicketChildPrice(double ticketChildPrice) {
		TicketChildPrice = ticketChildPrice;
	}
	
	 /**
     * @param 
     * @return TicketAdultPrice double 
     */
	
	public double getTicketAdultPrice() {
		return TicketAdultPrice;
	}
	
	 /**
     * @param ticketAdultPrice : double
     * @return void
     */
	
	public void setTicketAdultPrice(double ticketAdultPrice) {
		TicketAdultPrice = ticketAdultPrice;
	}
	
      /**
     * @param
     * @return getTicketType : String 
     */
	
	public String getTicketType() {
		return TicketType;
	}
	
	 /**
     * @param ticketType : String
     * @return void
     */
	
	public void setTicketType(String ticketType) {
		TicketType = ticketType;
	}
	
	 /**
     * @param 
     * @return validTotalPeople : int 
     */
	
	public int getValidTotalpeople() {
		return ValidTotalpeople;
	}
	
	 /**
     * @param validTotalpeople : int
     * @return void 
     */	
	public void setValidTotalpeople(int validTotalpeople) {
		ValidTotalpeople = validTotalpeople;
	}
 /**
     * @param
     * @return String 
     */
	

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
