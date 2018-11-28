package oxxy.kero.roiaculte.team7.khbich.Utils;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.annotations.NonNull;

public class JobExecutor  implements Executor {
    private final ThreadPoolExecutor threadPoolExecutor;


    public JobExecutor() {
        this.threadPoolExecutor = new ThreadPoolExecutor(3, 5, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>()
        , new JobThreadFactory());

    }

  public void execute(@NonNull Runnable runnable) {
        this.threadPoolExecutor.execute(runnable);
    }

    private static class JobThreadFactory implements ThreadFactory {
        private int counter = 0;

        @Override public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(runnable, "android_" + counter++);
        }
    }
}