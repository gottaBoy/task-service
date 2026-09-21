/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.util;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSFileUtil {
    private static final Log log = LogFactory.getLog(PSFileUtil.class);

    public static long getFolderSize(File file) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        long l = System.currentTimeMillis();
        long l2 = forkJoinPool.invoke(new FileSizeFinder(file));
        long l3 = System.currentTimeMillis();
        log.debug((Object)StringHelper.format((String)"\u8ba1\u7b97\u76ee\u5f55[%1$s]\u8017\u65f6[%2$sms]\uff0c\u5927\u5c0f[%3$s]", (Object)file.getAbsolutePath(), (Object)(l3 - l), (Object)(l2 / 1024L)));
        return l2;
    }

    static class FileSizeFinder
    extends RecursiveTask<Long> {
        final File file;

        public FileSizeFinder(File file) {
            this.file = file;
        }

        @Override
        public Long compute() {
            long l = 0L;
            if (this.file.isFile()) {
                l = this.file.length();
            } else {
                File[] fileArray = this.file.listFiles();
                if (fileArray != null) {
                    ArrayList<FileSizeFinder> arrayList = new ArrayList<FileSizeFinder>();
                    for (File file : fileArray) {
                        if (file.isFile()) {
                            l += file.length();
                            continue;
                        }
                        arrayList.add(new FileSizeFinder(file));
                    }
                    for (ForkJoinTask forkJoinTask : FileSizeFinder.invokeAll(arrayList)) {
                        l += ((Long)forkJoinTask.join()).longValue();
                    }
                }
            }
            return l;
        }
    }
}

