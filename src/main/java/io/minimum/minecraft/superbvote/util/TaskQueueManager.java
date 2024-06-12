package io.minimum.minecraft.superbvote.util;

import org.bukkit.scheduler.BukkitRunnable;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TaskQueueManager extends BukkitRunnable {
    private ConcurrentLinkedQueue<Runnable> taskQueue = new ConcurrentLinkedQueue<>();

    public void queueTask(Runnable task) {
        taskQueue.add(task);
    }

    @Override
    public void run() {
        Runnable task = taskQueue.poll();
        if (task != null) {
            task.run();
        }
    }
}

