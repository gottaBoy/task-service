/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.WebConfig
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSStudioEnvHelper {
    private static PSStudioEnvHelper cmdHelper = new PSStudioEnvHelper();
    private static final Log log = LogFactory.getLog(PSStudioEnvHelper.class);
    private boolean bLinux = false;
    private String strToolFolder = null;
    private String strNDCacheFolder = null;
    private String strDynaInstFolder = null;
    private String strDepInstFolder = null;
    private String strTempFolder = null;

    public PSStudioEnvHelper() {
        if (StringHelper.compare((String)File.separator, (String)"/", (boolean)false) == 0) {
            this.bLinux = true;
        }
        if (WebConfig.getCurrent() != null) {
            this.strToolFolder = WebConfig.getCurrent().getAttribute("TOOLFOLDER", "");
            this.strNDCacheFolder = WebConfig.getCurrent().getAttribute("NDCACHEFOLDER", "");
            this.strDynaInstFolder = WebConfig.getCurrent().getAttribute("DYNAINSTFOLDER", "");
            this.strDepInstFolder = WebConfig.getCurrent().getAttribute("DEPINSTFOLDER", "");
            this.strTempFolder = WebConfig.getCurrent().getAttribute("TEMPFOLDER", "");
            if (StringHelper.isNullOrEmpty((String)this.strTempFolder)) {
                this.strTempFolder = String.format("%1$s%2$sTMP", this.strDynaInstFolder, File.separator);
            }
        }
    }

    public String getToolFolder() {
        return this.strToolFolder;
    }

    @Deprecated
    public void setrToolFolder(String string) {
        this.strToolFolder = string;
    }

    public void setToolFolder(String string) {
        this.strToolFolder = string;
    }

    public String getNDCacheFolder() {
        return this.strNDCacheFolder;
    }

    public void setNDCacheFolder(String string) {
        this.strNDCacheFolder = string;
    }

    public String getDynaInstFolder() {
        return this.strDynaInstFolder;
    }

    public void setDynaInstFolder(String string) {
        this.strDynaInstFolder = string;
    }

    public String getDepInstFolder() {
        return this.strDepInstFolder;
    }

    public void setDepInstFolder(String string) {
        this.strDepInstFolder = string;
    }

    public String getTempFolder() {
        return this.strTempFolder;
    }

    public void setTempFolder(String string) {
        this.strTempFolder = string;
    }

    public Result executeBat(String string) throws Exception {
        boolean bl;
        log.info((Object)StringHelper.format((String)"\u6267\u884c\u547d\u4ee4[%1$s]", (Object)string));
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Process process = Runtime.getRuntime().exec(string);
        WatchThread watchThread = new WatchThread(process);
        watchThread.start();
        process.waitFor();
        ArrayList<String> arrayList = watchThread.getStream();
        ArrayList<String> arrayList2 = watchThread.getErrorStream();
        watchThread.setOver(true);
        Result result = new Result();
        if (arrayList != null) {
            bl = true;
            for (String string2 : arrayList) {
                if (bl) {
                    bl = false;
                } else {
                    stringBuilderEx.append("\r\n");
                }
                stringBuilderEx.append(string2);
            }
            if (!bl) {
                result.setInfo(stringBuilderEx.toString());
            }
        }
        if (arrayList2 != null) {
            bl = true;
            stringBuilderEx.reset();
            for (String string2 : arrayList2) {
                if (bl) {
                    bl = false;
                } else {
                    stringBuilderEx.append("\r\n");
                }
                stringBuilderEx.append(string2);
            }
            if (!bl) {
                result.setErrorInfo(stringBuilderEx.toString());
            }
        }
        if (!StringHelper.isNullOrEmpty((String)result.getInfo())) {
            log.info((Object)StringHelper.format((String)"\u6267\u884c\u547d\u4ee4[%1$s]\u8fd4\u56de\u6b63\u5e38\u4fe1\u606f:\r\n%2$s", (Object)string, (Object)result.getInfo()));
        }
        if (!StringHelper.isNullOrEmpty((String)result.getErrorInfo())) {
            log.warn((Object)StringHelper.format((String)"\u6267\u884c\u547d\u4ee4[%1$s]\u8fd4\u56de\u9519\u8bef\u4fe1\u606f:\r\n%2$s", (Object)string, (Object)result.getErrorInfo()));
        }
        return result;
    }

    public boolean isLinux() {
        return this.bLinux;
    }

    public static PSStudioEnvHelper getCurrent() {
        return cmdHelper;
    }

    class WatchThread
    extends Thread {
        Process p;
        boolean over;
        ArrayList<String> stream;
        boolean bError = false;
        WatchThread errorWatchThread = null;

        public WatchThread(Process process) {
            this.p = process;
            this.over = false;
            this.stream = new ArrayList();
            this.errorWatchThread = new WatchThread(process, true);
        }

        public WatchThread(Process process, boolean bl) {
            this.p = process;
            this.over = false;
            this.stream = new ArrayList();
            this.bError = bl;
        }

        @Override
        public synchronized void start() {
            if (this.errorWatchThread != null) {
                this.errorWatchThread.start();
            }
            super.start();
        }

        @Override
        public void run() {
            Scanner scanner = null;
            try {
                String string;
                if (this.p == null) {
                    return;
                }
                scanner = new Scanner(this.bError ? this.p.getErrorStream() : this.p.getInputStream(), "GBK");
                while (scanner.hasNextLine() && !this.over) {
                    string = scanner.nextLine();
                    if (string.trim() == null || string.trim().equals("")) continue;
                    this.stream.add(string);
                }
                while (this.p != null && !this.over) {
                    while (scanner.hasNextLine() && !this.over) {
                        string = scanner.nextLine();
                        if (string.trim() == null || string.trim().equals("")) continue;
                        this.stream.add(string);
                    }
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            if (scanner != null) {
                scanner.close();
            }
        }

        public void setOver(boolean bl) {
            this.over = bl;
            if (this.errorWatchThread != null) {
                this.errorWatchThread.setOver(bl);
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

    public class Result {
        private String strInfo = null;
        private String strErrorInfo = null;

        public String getInfo() {
            return this.strInfo;
        }

        public void setInfo(String string) {
            this.strInfo = string;
        }

        public String getErrorInfo() {
            return this.strErrorInfo;
        }

        public void setErrorInfo(String string) {
            this.strErrorInfo = string;
        }
    }
}

