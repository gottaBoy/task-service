/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.sun.jna.Platform
 *  com.sun.jna.Pointer
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSTSCmd
 *  net.ibizsys.pscore.srv.paasmgr.service.PSTSCmdService
 *  net.ibizsys.pscore.srv.util.PSStudioConsoleHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.DevStudio.IPSBKTask;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskSessionContext;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.JIT.Web.PSJITWebContext;
import SA.SRFDA.PS.Core.Log.IPSLogItem;
import SA.SRFDA.PS.Core.Log.PSLogItemImpl;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.Util.FileWriterHelper;
import SA.SRFDA.PS.Core.Util.FileWriterHelper2;
import SA.SRFDA.PS.Core.Util.JNA.Kernel32;
import SA.SRFDA.PS.Core.Util.JNA.W32API;
import com.sun.jna.Platform;
import com.sun.jna.Pointer;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTSCmd;
import net.ibizsys.pscore.srv.paasmgr.service.PSTSCmdService;
import net.ibizsys.pscore.srv.util.PSStudioConsoleHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSBKTaskImplBase
extends PSObjectImpl
implements IPSBKTask {
    private static final Log log = LogFactory.getLog(PSBKTaskImplBase.class);
    private boolean bIsCancel = false;
    private Process curBatProcess = null;
    private String strPSTaskServerId = "";
    private IPSBKTaskSessionContext iPSBKTaskSessionContext = null;
    private HashMap<String, Object> attributeMap = new HashMap();
    private String strQueueInfo = null;
    private ArrayList<IPSLogItem> psLogItemList = new ArrayList();
    private WatchThread curWatchThread = null;
    private long nCurPId = -1L;
    private String strStudioConsoleId = null;

    protected boolean isCancel() {
        return this.bIsCancel;
    }

    protected void setIsCancel(boolean bIsCancel) {
        this.bIsCancel = bIsCancel;
    }

    protected String onRun() throws Exception {
        return null;
    }

    @Override
    public void cancel(boolean bUserCancel, String strReason) {
        if (this.isCancel()) {
            return;
        }
        this.setIsCancel(true);
        try {
            WatchThread wt;
            if (this.curBatProcess != null) {
                this.curBatProcess.destroy();
            }
            if ((wt = this.curWatchThread) != null) {
                wt.setOver(true);
            }
            try {
                if (this.nCurPId != -1L && Platform.isWindows()) {
                    String strCmd = String.format("cmd.exe /c taskkill /PID %1$s /T /F ", this.nCurPId);
                    Runtime.getRuntime().exec(strCmd);
                }
            }
            catch (Exception e) {
                log.error((Object)e);
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        this.onCancel(bUserCancel, strReason);
    }

    protected abstract void onCancel(boolean var1, String var2);

    protected String runBat(String batName, boolean bResult) throws Exception {
        return this.runBat(batName, true, "GBK");
    }

    protected String runBat(String batName, boolean bResult, String strEncode) throws Exception {
        return this.runBat(batName, bResult, strEncode, true);
    }

    protected String runBat(String batName, boolean bResult, String strEncode, boolean bTrim) throws Exception {
        long pid = -1L;
        PSTSCmd psTSCmd = null;
        try {
            PSTSCmdService psTSCmdService;
            File file;
            log.debug((Object)StringHelper.format((String)"\u6267\u884c\u547d\u4ee4[%1$s]", (Object)batName));
            if (StringHelper.compare((String)PSTaskServerEnvImpl.getCurrent().getOSType(), (String)"LINUX", (boolean)true) == 0 && (file = new File(batName)).exists()) {
                String strCode = FileWriterHelper2.readFile(batName);
                strCode = strCode.replace("\r\n", "\n");
                FileWriterHelper.write(batName, strCode);
                Runtime.getRuntime().exec(StringHelper.format((String)"chmod u+x %1$s", (Object)batName));
            }
            if ((psTSCmd = this.createPSTSCmd()) != null) {
                psTSCmd.setTaskName(this.getName());
                psTSCmd.setPSTaskServerId(this.strPSTaskServerId);
                psTSCmd.setRunCmd(batName);
            }
            this.curBatProcess = Runtime.getRuntime().exec(batName);
            WatchThread wt = new WatchThread(this.curBatProcess, bResult, -1, strEncode, bTrim);
            wt.start();
            this.curWatchThread = wt;
            try {
                if (Platform.isWindows()) {
                    Field field = this.curBatProcess.getClass().getDeclaredField("handle");
                    field.setAccessible(true);
                    W32API.HANDLE handler = new W32API.HANDLE();
                    handler.setPointer(Pointer.createConstant((long)((Long)field.get(this.curBatProcess))));
                    this.nCurPId = pid = (long)Kernel32.INSTANCE.GetProcessId(handler);
                }
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
            try {
                if (pid != -1L && psTSCmd != null) {
                    psTSCmd.set("SRF_PERSONID", (Object)"SYSTEM");
                    psTSCmd.set("SRF_LOGINNAME", (Object)"SYSTEM");
                    psTSCmd.setPSTSCmdName(StringHelper.format((String)"%1$s", (Object)pid));
                    psTSCmdService = (PSTSCmdService)ServiceGlobal.getService(PSTSCmdService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                    psTSCmdService.create(psTSCmd, true);
                }
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
            this.curBatProcess.waitFor();
            this.curBatProcess = null;
            try {
                if (Platform.isWindows() && pid != -1L) {
                    String strCmd = String.format("cmd.exe /c taskkill /PID %1$s /T /F ", pid);
                    Runtime.getRuntime().exec(strCmd);
                }
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
            try {
                if (pid != -1L && psTSCmd != null) {
                    psTSCmdService = (PSTSCmdService)ServiceGlobal.getService(PSTSCmdService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                    psTSCmdService.remove(psTSCmd);
                }
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
            wt.setOver(true);
            this.curWatchThread = null;
            this.nCurPId = -1L;
            if (bResult) {
                ArrayList<String> commandStream = wt.getStream();
                StringBuilderEx sBuilderEx = new StringBuilderEx();
                for (String strInfo : commandStream) {
                    sBuilderEx.append(strInfo);
                    sBuilderEx.append("\r\n");
                }
                return sBuilderEx.toString();
            }
            return "";
        }
        catch (InterruptedException ex) {
            WatchThread wt = this.curWatchThread;
            if (wt != null) {
                wt.setOver(true);
            }
            try {
                if (Platform.isWindows() && pid != -1L) {
                    String strCmd = String.format("cmd.exe /c taskkill /PID %1$s /T /F ", pid);
                    Runtime.getRuntime().exec(strCmd);
                }
            }
            catch (Exception e) {
                log.error((Object)e);
            }
            try {
                if (pid != -1L && psTSCmd != null) {
                    PSTSCmdService psTSCmdService = (PSTSCmdService)ServiceGlobal.getService(PSTSCmdService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                    psTSCmdService.remove(psTSCmd);
                }
            }
            catch (Exception e) {
                log.error((Object)e);
            }
            return "\u4efb\u52a1\u88ab\u4e2d\u65ad";
        }
        catch (Exception ex) {
            WatchThread wt = this.curWatchThread;
            if (wt != null) {
                wt.setOver(true);
            }
            try {
                if (Platform.isWindows() && pid != -1L) {
                    String strCmd = String.format("cmd.exe /c taskkill /PID %1$s /T /F ", pid);
                    Runtime.getRuntime().exec(strCmd);
                }
            }
            catch (Exception e) {
                log.error((Object)e);
            }
            try {
                if (pid != -1L && psTSCmd != null) {
                    PSTSCmdService psTSCmdService = (PSTSCmdService)ServiceGlobal.getService(PSTSCmdService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                    psTSCmdService.remove(psTSCmd);
                }
            }
            catch (Exception e) {
                log.error((Object)e);
            }
            log.error((Object)ex);
            this.curBatProcess = null;
            String strInfo = ex.getMessage();
            if (StringHelper.isNullOrEmpty((String)strInfo)) {
                strInfo = "\u672a\u77e5\u9519\u8bef";
            }
            return strInfo;
        }
    }

    protected abstract PSTSCmd createPSTSCmd() throws Exception;

    protected void executeTask(Runnable command) {
        if (PSJITWebContext.getInstance() != null) {
            PSJITWebContext.setCurrent(null);
        }
        this.getPSBKTaskSessionContext().executeTask(command);
    }

    protected int getTaskThreadCount() {
        return this.iPSBKTaskSessionContext.getTaskThreadCount();
    }

    protected void setPSBKTaskSessionContext(IPSBKTaskSessionContext iPSBKTaskSessionContext) {
        this.iPSBKTaskSessionContext = iPSBKTaskSessionContext;
    }

    protected IPSBKTaskSessionContext getPSBKTaskSessionContext() {
        return this.iPSBKTaskSessionContext;
    }

    @Override
    public void setAttribute(String strKey, Object objValue) {
        this.attributeMap.put(strKey, objValue);
    }

    @Override
    public Object getAttribute(String strKey) {
        return this.attributeMap.get(strKey);
    }

    @Override
    public void setQueueInfo(int nPos, int nTotal) {
        String strQueueInfo = StringHelper.format((String)"\u6b63\u5728\u7b49\u5f85\u8c03\u5ea6,\u5f53\u524d\u4f4d\u7f6e[%1$s],\u961f\u5217\u957f\u5ea6[%2$s]", (Object)nPos, (Object)nTotal);
        if (StringHelper.compare((String)strQueueInfo, (String)this.strQueueInfo, (boolean)false) == 0) {
            return;
        }
        this.sendStudioConsole(null, "INFO", strQueueInfo);
        this.strQueueInfo = strQueueInfo;
        this.onUpdateQueueInfo(strQueueInfo);
    }

    protected abstract void onUpdateQueueInfo(String var1);

    protected ArrayList<IPSLogItem> getPSLogItemList() {
        return this.psLogItemList;
    }

    protected void log(int nLogLevel, IPSModelObject iPSModelObject, String strInfo, String strUserData) {
        this.log(nLogLevel, iPSModelObject, strInfo, strUserData, null);
    }

    protected void log(int nLogLevel, IPSModelObject iPSModelObject, String strInfo, String strUserData, String strUserData2) {
        PSLogItemImpl psLogItemImpl = new PSLogItemImpl();
        psLogItemImpl.setLogLevel(nLogLevel);
        psLogItemImpl.setLogInfo(strInfo);
        psLogItemImpl.setPSObject(iPSModelObject);
        psLogItemImpl.setUserData(strUserData);
        psLogItemImpl.setUserData2(strUserData2);
        this.psLogItemList.add(psLogItemImpl);
    }

    protected void log(int nLogLevel, IPSModelObject iPSModelObject, String strInfo) {
        this.log(nLogLevel, iPSModelObject, strInfo, null, null);
    }

    @Override
    public String getQueueInfo() {
        return this.strQueueInfo;
    }

    protected String getStudioConsoleId() {
        return this.strStudioConsoleId;
    }

    protected void setStudioConsoleId(String strStudioConsoleId) {
        this.strStudioConsoleId = strStudioConsoleId;
    }

    protected void sendStudioConsoleRaw(String strTopic, String strContent) {
        this.sendStudioConsoleRaw(strTopic, strContent, null);
    }

    protected void sendStudioConsoleRaw(String strTopic, String strContent, String strLogger) {
        if (PSTaskServerEnvImpl.getCurrent() != null && PSTaskServerEnvImpl.getCurrent().isDebugConsoleInfo()) {
            log.debug((Object)StringHelper.format((String)"CONSOLE[%1$s][%2$s][%3$s]", (Object)strTopic, (Object)strContent, (Object)strLogger));
        }
        if (PSStudioConsoleHelper.getCurrent() != null) {
            if (StringHelper.isNullOrEmpty((String)strTopic)) {
                strTopic = this.getStudioConsoleId();
            }
            if (StringHelper.isNullOrEmpty((String)strTopic)) {
                return;
            }
            PSStudioConsoleHelper.getCurrent().sendConsole(strTopic, strContent, strLogger);
        }
    }

    protected void sendStudioConsole(String strTopic, String strLogType, String strContent) {
        this.sendStudioConsole(strTopic, strLogType, strContent, null);
    }

    protected void sendStudioConsole(String strTopic, String strLogType, String strContent, String strLogger) {
        if (PSTaskServerEnvImpl.getCurrent() != null && PSTaskServerEnvImpl.getCurrent().isDebugConsoleInfo()) {
            log.debug((Object)StringHelper.format((String)"CONSOLE[%1$s][%2$s][%3$s][%4$s]", (Object)strTopic, (Object)strLogType, (Object)strContent, (Object)strLogger));
        }
        if (PSStudioConsoleHelper.getCurrent() != null) {
            if (StringHelper.isNullOrEmpty((String)strTopic)) {
                strTopic = this.getStudioConsoleId();
            }
            if (StringHelper.isNullOrEmpty((String)strTopic)) {
                return;
            }
            if (!StringHelper.isNullOrEmpty((String)strLogType)) {
                strContent = StringHelper.compare((String)strLogType, (String)"INFO", (boolean)false) == 0 ? PSStudioConsoleHelper.getContent((String)strContent, (int)34, (int)-1, (int)0) : (StringHelper.compare((String)strLogType, (String)"WARN", (boolean)false) == 0 ? PSStudioConsoleHelper.getContent((String)strContent, (int)33, (int)-1, (int)1) : (StringHelper.compare((String)strLogType, (String)"ERROR", (boolean)false) == 0 ? PSStudioConsoleHelper.getContent((String)strContent, (int)31, (int)-1, (int)1) : PSStudioConsoleHelper.getContent((String)strContent, (int)32, (int)-1, (int)0)));
            }
            PSStudioConsoleHelper.getCurrent().sendConsole(strTopic, strContent, strLogger);
        }
    }

    @Override
    public int getTaskLevel() {
        if (this.getParentPSBKTask() == null) {
            return 0;
        }
        return this.getParentPSBKTask().getTaskLevel() + 1;
    }

    protected String getTaskLevelPadding() {
        switch (this.getTaskLevel()) {
            case 0: {
                return "";
            }
            case 1: {
                return " ";
            }
            case 2: {
                return "  ";
            }
            case 3: {
                return "   ";
            }
            case 4: {
                return "    ";
            }
        }
        return "     ";
    }

    class WatchThread
    extends Thread {
        Process p;
        boolean over;
        ArrayList<String> stream;
        int nTimeout;
        boolean bResult;
        boolean bError = false;
        WatchThread errorWatchThread = null;
        private String strEncode = "GBK";
        boolean bTrim = true;

        public WatchThread(Process p, boolean bResult, int nTimeout, String strEncode, boolean bTrim) {
            this.p = p;
            if (!StringHelper.isNullOrEmpty((String)strEncode)) {
                this.strEncode = strEncode;
            }
            this.over = false;
            this.nTimeout = nTimeout;
            this.bResult = bResult;
            this.bTrim = bTrim;
            if (bResult) {
                this.stream = new ArrayList();
            }
            this.errorWatchThread = new WatchThread(p, false, nTimeout, true);
        }

        public WatchThread(Process p, boolean bResult, int nTimeout, boolean bError) {
            this.p = p;
            this.over = false;
            this.nTimeout = nTimeout;
            this.bResult = bResult;
            if (bResult) {
                this.stream = new ArrayList();
            }
            this.bError = bError;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void run() {
            Scanner br;
            block12: {
                block11: {
                    br = null;
                    try {
                        InputStream stream;
                        if (this.p == null) {
                            return;
                        }
                        if (this.bResult) {
                            br = new Scanner(this.bError ? this.p.getErrorStream() : this.p.getInputStream(), this.strEncode);
                            break block11;
                        }
                        InputStream inputStream = stream = this.bError ? this.p.getErrorStream() : this.p.getInputStream();
                        while (this.p != null && !this.over) {
                            if (stream.available() > 0) {
                                byte[] btmp = new byte[stream.available()];
                                stream.read(btmp);
                            }
                            Thread.sleep(50L);
                        }
                        stream.close();
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                    break block12;
                }
                while (this.p != null && !this.over) {
                    while (br.hasNextLine() && !this.over) {
                        String tempStream = br.nextLine();
                        if (!this.bResult) continue;
                        if (this.bTrim) {
                            if (tempStream.trim() == null || tempStream.trim().equals("")) continue;
                            this.stream.add(tempStream);
                            continue;
                        }
                        if (tempStream.trim() == null) {
                            this.stream.add("");
                            continue;
                        }
                        this.stream.add(tempStream);
                    }
                }
            }
            if (br != null) {
                br.close();
            }
        }

        public void setOver(boolean over) {
            if (this.errorWatchThread != null) {
                this.errorWatchThread.setOver(over);
            }
            this.over = over;
        }

        public ArrayList<String> getStream() {
            return this.stream;
        }

        @Override
        public synchronized void start() {
            if (this.errorWatchThread != null) {
                this.errorWatchThread.start();
            }
            super.start();
        }
    }
}
