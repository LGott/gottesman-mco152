package gottesman.UFO;

import java.util.ArrayList;

import com.google.gson.Gson;

public class UFOSightingList extends ArrayList<UFOSighting> {

	private static final long serialVersionUID = 1L;

	final Gson gson = new Gson();
}
