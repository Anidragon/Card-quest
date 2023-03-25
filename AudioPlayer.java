
// Java program to play an Audio
// file using Clip Object
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioPlayer
{

	
	Clip clip;
	
	AudioInputStream audioInputStream;
	private File file;

	// constructor to initialize streams and clip
	public AudioPlayer(String FileName, boolean SoundEffect)
		throws UnsupportedAudioFileException,
		IOException, LineUnavailableException
	{
		file = new File(FileName);
		// create AudioInputStream object
		audioInputStream =
				AudioSystem.getAudioInputStream((file).getAbsoluteFile());
		
		// create clip reference
		clip = AudioSystem.getClip();
		
		// open audioInputStream to the clip
		clip.open(audioInputStream);
		
		if(!SoundEffect)
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		
		else if(SoundEffect)
			clip.loop(0);
		
	}

	public void stop() throws IOException, LineUnavailableException, UnsupportedAudioFileException
	{
			clip.stop();
			clip.flush();
			clip.drain();
			clip.close();
	}
	
	
	public void play()
	{
		
		clip.start();
		
	}	
	

}

