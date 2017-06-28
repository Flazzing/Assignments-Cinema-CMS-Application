import java.util.Arrays;

public class Movie {

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	private String MovieID;	
	@Override
	public String toString() {
		return "Movie [MovieID=" + MovieID + ", MovieName=" + MovieName + ", MovieStartTime=" + MovieStartTime
				+ ", MovieEndTime=" + MovieEndTime + ", MovieHall=" + MovieHall + ", MovieDirectory=" + MovieDirectory
				+ "]";
	}
	public Movie(String movieID, String movieName, String movieStartTime, String movieEndTime, String movieHall,
			String movieDirectory) {
		super();
		MovieID = movieID;
		MovieName = movieName;
		MovieStartTime = movieStartTime;
		MovieEndTime = movieEndTime;
		MovieHall = movieHall;
		MovieDirectory = movieDirectory;
	}
	public String getMovieID() {
		return MovieID;
	}
	public void setMovieID(String movieID) {
		MovieID = movieID;
	}
	public String getMovieName() {
		return MovieName;
	}
	public void setMovieName(String movieName) {
		MovieName = movieName;
	}
	public String getMovieStartTime() {
		return MovieStartTime;
	}
	public void setMovieStartTime(String movieStartTime) {
		MovieStartTime = movieStartTime;
	}
	public String getMovieEndTime() {
		return MovieEndTime;
	}
	public void setMovieEndTime(String movieEndTime) {
		MovieEndTime = movieEndTime;
	}
	public String getMovieHall() {
		return MovieHall;
	}
	public void setMovieHall(String movieHall) {
		MovieHall = movieHall;
	}
	public String getMovieDirectory() {
		return MovieDirectory;
	}
	public void setMovieDirectory(String movieDirectory) {
		MovieDirectory = movieDirectory;
	}
	private String MovieName;
	private String MovieStartTime;
	private String MovieEndTime;
	private String MovieHall;
	private String MovieDirectory;
	
	
	
}
