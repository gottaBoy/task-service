package SA.IM.Ctrl;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class IMAsyncCometEvent implements IIMCometEvent {
    private final AsyncContext context;
    private final Runnable cleanup;
    private final AtomicBoolean closed = new AtomicBoolean();
    private final AtomicBoolean cleanupScheduled = new AtomicBoolean();
    private final AtomicBoolean cleaned = new AtomicBoolean();

    public IMAsyncCometEvent(AsyncContext context, Runnable cleanup) {
        this.context = context;
        this.cleanup = cleanup;
        context.addListener(new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent event) {
                closed.set(true);
                if (!cleanupScheduled.get()) {
                    cleanupOnce();
                }
            }

            @Override
            public void onTimeout(AsyncEvent event) throws IOException {
                close();
            }

            @Override
            public void onError(AsyncEvent event) throws IOException {
                close();
            }

            @Override
            public void onStartAsync(AsyncEvent event) {
                event.getAsyncContext().addListener(this);
            }
        });
    }

    public boolean isClosed() {
        return closed.get();
    }

    private void cleanupOnce() {
        if (cleaned.compareAndSet(false, true)) {
            cleanup.run();
        }
    }

    @Override
    public void close() throws IOException {
        if (!closed.compareAndSet(false, true)) {
            return;
        }
        // Backend callers can hold their connection lock here. Run cleanup on
        // an async thread so it cannot invert the servlet/backend lock order.
        cleanupScheduled.set(true);
        Runnable cleanupTask = new Runnable() {
            @Override
            public void run() {
                cleanupOnce();
            }
        };
        try {
            context.start(cleanupTask);
        } catch (IllegalStateException ex) {
            Thread fallback = new Thread(cleanupTask, "im-comet-cleanup");
            fallback.setDaemon(true);
            fallback.setContextClassLoader(null);
            fallback.start();
        } finally {
            try {
                context.complete();
            } catch (IllegalStateException ex) {
                // The container already finished the request.
            }
        }
    }

    @Override
    public HttpServletRequest getHttpServletRequest() {
        return (HttpServletRequest) context.getRequest();
    }

    @Override
    public HttpServletResponse getHttpServletResponse() {
        return (HttpServletResponse) context.getResponse();
    }
}
