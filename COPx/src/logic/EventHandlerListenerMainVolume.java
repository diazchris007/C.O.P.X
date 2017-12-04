package logic;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.Slider;
import javafx.scene.media.MediaPlayer;

public class EventHandlerListenerMainVolume implements InvalidationListener {

	Slider volumeSlider;
	MediaPlayer mediaPlayer;
	
	public EventHandlerListenerMainVolume(Slider vs, MediaPlayer mp) {
		volumeSlider = vs;
		mediaPlayer = mp;
	}
	
	@Override
	public void invalidated(Observable ov) {
		if (volumeSlider.isValueChanging()) {
			mediaPlayer.setVolume(volumeSlider.getValue() / 100.0);
   		}
	}
}