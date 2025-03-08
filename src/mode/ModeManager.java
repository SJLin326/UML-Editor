package mode;

public class ModeManager {

	private volatile static ModeManager instance;
	private static Mode currentMode;

	public ModeManager() {
		currentMode = new SelectMode();
	}

	public static ModeManager getInstance() {
		if (instance == null) {
			instance = new ModeManager();
		}
		return instance;
	}

	public static void setMode(Mode newMode) {
		currentMode = newMode;
	}

	public static Mode getMode() {
		return currentMode;
	}
}