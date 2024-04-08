package SoundProcessing;

import javax.sound.sampled.*;

public class AudioFormatChecker {
    public static void main(String[] args) {
        Mixer.Info[] mixerInfos = AudioSystem.getMixerInfo();
        for (Mixer.Info info: mixerInfos){
            Mixer m = AudioSystem.getMixer(info);
            Line.Info[] lineInfos = m.getSourceLineInfo();
            for (Line.Info lineInfo: lineInfos){
                System.out.println(info.getName()+"---"+lineInfo);
                try {
                    Line line = m.getLine(lineInfo);
                    if (line instanceof SourceDataLine) {
                        SourceDataLine source = (SourceDataLine) line;
                        DataLine.Info i = (DataLine.Info) source.getLineInfo();
                        for (AudioFormat format: i.getFormats()) {
                            System.out.println(format);
                        }
                    }
                } catch (LineUnavailableException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}