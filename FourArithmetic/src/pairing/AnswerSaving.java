package pairing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class AnswerSaving {
    public static String answers="";
    public static int num = 1;

    public void Saving(File file2) throws IOException {
        FileWriter fw = new FileWriter(file2);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(answers);
        bw.flush();
        bw.close();
    }

    public void Write(String answer) {
        answers = answers + num + "." + answer + "\n";
        num++;
    }
}
