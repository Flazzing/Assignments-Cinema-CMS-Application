
public class ComingSoonMovie {
	public String getMovieName() {
		return MovieName;
	}
	public void setMovieName(String movieName) {
		MovieName = movieName;
	}
	public String getReleaseDay() {
		return ReleaseDay;
	}
	public void setReleaseDay(String releaseDay) {
		ReleaseDay = releaseDay;
	}
	public String getReleaseMonth() {
		return ReleaseMonth;
	}
	public void setReleaseMonth(String releaseMonth) {
		ReleaseMonth = releaseMonth;
	}
	public ComingSoonMovie(String movieName, String releaseDay, String releaseMonth) {
		super();
		MovieName = movieName;
		ReleaseDay = releaseDay;
		ReleaseMonth = releaseMonth;
	}
	@Override
	public String toString() {
		return "ComingSoonMovie [MovieName=" + MovieName + ", ReleaseDay=" + ReleaseDay + ", ReleaseMonth="
				+ ReleaseMonth + "]";
	}
	private String MovieName= null;
	private String ReleaseDay= null;
	private String ReleaseMonth = null;
}
 