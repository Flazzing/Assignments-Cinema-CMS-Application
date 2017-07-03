
/**
	 * A object class serve for collectible framework
	 *
	 *It acts to facilitate the graphical display of the coming soon Movie table
	 *
	 *This section will sort the data accordingly to 2NF format
	 *
	 *
	 *
	 */

public class ComingSoonMovie {

	
	
	/************************************************************************
     *                                                                      *
     *                                                                      *
     * \defgroup Constructors                                               *
     * Constructors to help create the object 
     * super to call object class                    *
     *                                                                      *
     * @{                                                                   *
     ***********************************************************************/

	public ComingSoonMovie(String movieName, String releaseDay, String releaseMonth, String movieDescription,
			String movieImageDirectory) {
		super();
		MovieName = movieName;
		ReleaseDay = releaseDay;
		ReleaseMonth = releaseMonth;
		MovieDescription = movieDescription;
		MovieImageDirectory = movieImageDirectory;
	}
	private String MovieName= null;
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
	public String getMovieDescription() {
		return MovieDescription;
	}
	public void setMovieDescription(String movieDescription) {
		MovieDescription = movieDescription;
	}
	public String getMovieImageDirectory() {
		return MovieImageDirectory;
	}
	public void setMovieImageDirectory(String movieImageDirectory) {
		MovieImageDirectory = movieImageDirectory;
	}
	@Override
	public String toString() {
		return "ComingSoonMovie [MovieName=" + MovieName + ", ReleaseDay=" + ReleaseDay + ", ReleaseMonth="
				+ ReleaseMonth + ", MovieDescription=" + MovieDescription + ", MovieImageDirectory="
				+ MovieImageDirectory + "]";
	}
	private String ReleaseDay= null;
	private String ReleaseMonth = null;
	private String MovieDescription = null;
	private String MovieImageDirectory = null;
}
 