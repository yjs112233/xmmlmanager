package yjs.xmml.xmmlmanager.thread;

import org.springframework.web.multipart.MultipartFile;

public class MyThread extends Thread{

    private MultipartFile file;
    public MyThread(MultipartFile file){
        this.file=file;
    }
    @Override
    public void run() {

    }

    public static MyThread getInstance(MultipartFile file){
        return new MyThread(file);
    }
}
