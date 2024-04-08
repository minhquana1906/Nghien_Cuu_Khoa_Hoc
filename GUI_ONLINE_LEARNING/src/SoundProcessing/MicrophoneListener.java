package SoundProcessing;

import javax.sound.sampled.*;

public class MicrophoneListener implements Runnable {
    private volatile boolean running;
    private boolean processing;

    public MicrophoneListener() {
        this.running = true;
        this.processing = false;
    }

    public boolean isProcessing() {
        return processing;
    }
    public void stop(){
        this.running = false;
    }

    @Override
    public void run() {
        try {
            AudioFormat format = new AudioFormat(16000, 8, 2, true, true);
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
            if (!AudioSystem.isLineSupported(info)) {
                System.out.println("Line not supported");
                System.exit(0);
            }
            TargetDataLine microphone = (TargetDataLine) AudioSystem.getLine(info);
            microphone.open(format);
            microphone.start();

            byte[] data = new byte[microphone.getBufferSize() / 5];
            int bytesRead;

            while (running) {
                bytesRead = microphone.read(data, 0, data.length);
                if (bytesRead > 0) {
                    processing = true;
                    System.out.println("Processing audio data");
                    // TODO: Process the audio data
                } else {
                    processing = false;
                    System.out.println("No audio data");
                }
            }
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}