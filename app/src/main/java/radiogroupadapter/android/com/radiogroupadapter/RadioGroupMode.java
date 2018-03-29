package radiogroupadapter.android.com.radiogroupadapter;

/**
 * Created by akshay trivedi on 25/03/18.
 */

public class RadioGroupMode {

    private String mModeName;
    private int mModeImage;
    private int mModeImageSelected;
    private boolean isModeSelected;

    public RadioGroupMode(String modeName, int modeImage, int modeImageSelected) {
        this.mModeName = modeName;
        this.mModeImage = modeImage;
        this.mModeImageSelected = modeImageSelected;
    }

    public String getModeName() {
        return mModeName;
    }

    public void setModeName(String modeName) {
        this.mModeName = modeName;
    }

    public int getModeImage() {
        return mModeImage;
    }

    public void setModeImage(int modeImage) {
        this.mModeImage = modeImage;
    }

    public int getModeImageSelected() {
        return mModeImageSelected;
    }

    public void setModeImageSelected(int modeImageSelected) {
        this.mModeImageSelected = modeImageSelected;
    }

    public boolean isModeSelected() {
        return isModeSelected;
    }

    public void setModeSelected(boolean modeSelected) {
        isModeSelected = modeSelected;
    }
}
