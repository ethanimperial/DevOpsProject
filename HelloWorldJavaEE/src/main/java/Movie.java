
public class Movie {
	
	public Movie(String title, String story, String cast, String genre, String rating, String duration,
			String releasedate, String ticketurl, String trailerurl, String image) {
		super();
		this.title = title;
		this.story = story;
		this.cast = cast;
		this.genre = genre;
		this.rating = rating;
		this.duration = duration;
		this.releasedate = releasedate;
		this.ticketurl = ticketurl;
		this.trailerurl = trailerurl;
		this.image = image;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}
	public String getCast() {
		return cast;
	}
	public void setCast(String cast) {
		this.cast = cast;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getReleasedate() {
		return releasedate;
	}
	public void setReleasedate(String releasedate) {
		this.releasedate = releasedate;
	}
	public String getTicketurl() {
		return ticketurl;
	}
	public void setTicketurl(String ticketurl) {
		this.ticketurl = ticketurl;
	}
	public String getTrailerurl() {
		return trailerurl;
	}
	public void setTrailerurl(String trailerurl) {
		this.trailerurl = trailerurl;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	protected String title;
	protected String story;
	protected String cast;
	protected String genre;
	protected String rating;
	protected String duration;
	protected String releasedate;
	protected String ticketurl;
	protected String trailerurl;
	protected String image;

}
