package PythonConnection;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class WebCam {
    public static void main(String[] args) throws IOException {
        new WebCam().start();
    }
    public void start() throws IOException {
        // Xây dựng đường dẫn đến thư mục chứa tập lệnh Python
        String pythonScriptDirectory = "F:\\NCKH\\Supervision-for-Online-Learning\\";

        // Xây dựng đường dẫn đến tập lệnh Python
        String pythonScriptPath = pythonScriptDirectory + "Face_Detection.py";

        // Tạo ProcessBuilder để chạy tập lệnh Python
        ProcessBuilder processBuilder = new ProcessBuilder("python", pythonScriptPath);
        processBuilder.directory(new File(pythonScriptDirectory)); // Thiết lập thư mục làm việc của ProcessBuilder
        processBuilder.redirectErrorStream(true); // Chuyển hướng luồng lỗi sang luồng nhập

        // Bắt đầu quá trình thực thi tập lệnh Python
        Process process = processBuilder.start();

        // Đọc đầu ra của tập lệnh Python và in ra console
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
