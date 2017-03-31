package ro.pub.cs.systems.eim.practicaltest01var01.practicaltest01var01;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Date;
import java.util.Random;

/**
 * Created by student on 31.03.2017.
 */
public class ProcessingThread extends Thread {
    private Context context = null;
    private boolean isRunning = true;

    private Random random = new Random();

    private String label;

    public ProcessingThread(Context context, String label) {
        this.context = context;

        this.label = label;
    }

    @Override
    public void run() {
        Log.d("[ProcessingThread]", "Thread has started!");
        while (isRunning) {
            sendMessage();
            sleep();
        }
        Log.d("[ProcessingThread]", "Thread has stopped!");
    }

    private void sendMessage() {
        Intent intent = new Intent();
        intent.setAction(Constants.actionTypes[random.nextInt(Constants.actionTypes.length)]);
        intent.putExtra("message", new Date(System.currentTimeMillis()) + " " + label);
        context.sendBroadcast(intent);
    }

    private void sleep() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public void stopThread() {
        isRunning = false;
    }
}
