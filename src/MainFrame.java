import javax.swing.JFrame;

public class MainFrame extends JFrame implements Runnable {

    private DrawPanel p;
    private DrawPanel t;
    private Thread windowThread;
    private static int mode;
    public MainFrame(String display) {
        super(display);
        int frameWidth = 460;
        int frameHeight = 400;
        // add a menu screen to ask user if they want vs AI or vs player
//        t = new DrawPanel();
//        this.add(t);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setSize(frameWidth, frameHeight);
//        this.setLocation(700    , 300);
//        this.setVisible(true);
//        startThread();


        p = new DrawPanel();
        this.add(p);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(frameWidth, frameHeight);
        this.setLocation(700    , 300);
        this.setVisible(true);
        startThread();

    }

    public void startThread() {
        windowThread = new Thread(this);
        windowThread.start();
    }

    public void run() {
        while (true) {
            p.repaint();
        }
    }
    public void restart(){

    }
}