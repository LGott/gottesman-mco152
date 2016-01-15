package gottesman.nypl;

public class Response {

	Result[] result;
	Capture[] capture;

	public Result[] getResults() {
		return this.result;
	}

	public Capture[] getCaptures() {
		return this.capture;
	}
}