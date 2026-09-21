/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Util;

import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Scanner;
import net.ibizsys.paas.util.StringBuilderEx;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CmdHelper {
    private static CmdHelper cmdHelper = new CmdHelper();
    private static final Log log = LogFactory.getLog(CmdHelper.class);

    public Result executeBat(String batName) throws Exception {
        boolean bFirst;
        log.info((Object)StringHelper.Format((String)"\u6267\u884c\u547d\u4ee4[%1$s]", (Object)batName));
        StringBuilderEx sBuilderEx = new StringBuilderEx();
        Process ps = Runtime.getRuntime().exec(batName);
        WatchThread wt = new WatchThread(ps);
        wt.start();
        ps.waitFor();
        ArrayList<String> commandStream = wt.getStream();
        ArrayList<String> commandStream2 = wt.getErrorStream();
        wt.setOver(true);
        Result result = new Result();
        if (commandStream != null) {
            bFirst = true;
            for (String strInfo : commandStream) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    sBuilderEx.append("\r\n");
                }
                sBuilderEx.append(strInfo);
            }
            if (!bFirst) {
                result.setInfo(sBuilderEx.toString());
            }
        }
        if (commandStream2 != null) {
            bFirst = true;
            sBuilderEx.reset();
            for (String strInfo : commandStream2) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    sBuilderEx.append("\r\n");
                }
                sBuilderEx.append(strInfo);
            }
            if (!bFirst) {
                result.setErrorInfo(sBuilderEx.toString());
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)result.getInfo())) {
            log.info((Object)StringHelper.Format((String)"\u6267\u884c\u547d\u4ee4[%1$s]\u8fd4\u56de\u6b63\u5e38\u4fe1\u606f:\r\n%2$s", (Object)batName, (Object)result.getInfo()));
        }
        if (!StringHelper.IsNullOrEmpty((String)result.getErrorInfo())) {
            log.warn((Object)StringHelper.Format((String)"\u6267\u884c\u547d\u4ee4[%1$s]\u8fd4\u56de\u9519\u8bef\u4fe1\u606f:\r\n%2$s", (Object)batName, (Object)result.getErrorInfo()));
        }
        return result;
    }

    public static CmdHelper getInstance() {
        return cmdHelper;
    }

    public class Result {
        private String strInfo = null;
        private String strErrorInfo = null;

        public String getInfo() {
            return this.strInfo;
        }

        public void setInfo(String strInfo) {
            this.strInfo = strInfo;
        }

        public String getErrorInfo() {
            return this.strErrorInfo;
        }

        public void setErrorInfo(String strErrorInfo) {
            this.strErrorInfo = strErrorInfo;
        }
    }

    class WatchThread
    extends Thread {
        Process p;
        boolean over;
        ArrayList<String> stream;
        boolean bError = false;
        WatchThread errorWatchThread = null;

        public WatchThread(Process p) {
            this.p = p;
            this.over = false;
            this.stream = new ArrayList();
            this.errorWatchThread = new WatchThread(p, true);
        }

        public WatchThread(Process p, boolean bError) {
            this.p = p;
            this.over = false;
            this.stream = new ArrayList();
            this.bError = bError;
        }

        @Override
        public synchronized void start() {
            if (this.errorWatchThread != null) {
                this.errorWatchThread.start();
            }
            super.start();
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void run() {
            Scanner br;
            block7: {
                String tempStream;
                br = null;
                try {
                    if (this.p == null) {
                        return;
                    }
                    br = new Scanner(this.bError ? this.p.getErrorStream() : this.p.getInputStream(), "GBK");
                    while (br.hasNextLine() && !this.over) {
                        tempStream = br.nextLine();
                        if (tempStream.trim() == null || tempStream.trim().equals("")) continue;
                        this.stream.add(tempStream);
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                    break block7;
                }
                while (this.p != null && !this.over) {
                    while (br.hasNextLine() && !this.over) {
                        tempStream = br.nextLine();
                        if (tempStream.trim() == null || tempStream.trim().equals("")) continue;
                        this.stream.add(tempStream);
                    }
                }
            }
            if (br != null) {
                br.close();
            }
        }

        public void setOver(boolean over) {
            this.over = over;
            if (this.errorWatchThread != null) {
                this.errorWatchThread.setOver(over);
            }
        }

        public ArrayList<String> getStream() {
            return this.stream;
        }

        public ArrayList<String> getErrorStream() {
            if (this.errorWatchThread != null) {
                return this.errorWatchThread.getStream();
            }
            return null;
        }
    }
}

