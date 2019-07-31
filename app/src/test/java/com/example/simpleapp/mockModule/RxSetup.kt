
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.internal.schedulers.ExecutorScheduler
import io.reactivex.disposables.Disposable
import io.reactivex.Scheduler
import io.reactivex.annotations.NonNull
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit


fun setUpRxSchedulers() {
    val immediate = object : Scheduler() {
        override fun scheduleDirect(@NonNull run: Runnable, delay: Long, @NonNull unit: TimeUnit): Disposable {
            // this prevents StackOverflowErrors when scheduling with a delay
            return super.scheduleDirect(run, 0, unit)
        }

        override fun createWorker(): Worker {
            return ExecutorScheduler.ExecutorWorker(Executor { it.run() },true)
        }
    }

    RxJavaPlugins.setInitIoSchedulerHandler { scheduler -> immediate }
    RxJavaPlugins.setInitComputationSchedulerHandler { scheduler -> immediate }
    RxJavaPlugins.setInitNewThreadSchedulerHandler { scheduler -> immediate }
    RxJavaPlugins.setInitSingleSchedulerHandler { scheduler -> immediate }
    RxAndroidPlugins.setInitMainThreadSchedulerHandler { scheduler -> immediate }
}