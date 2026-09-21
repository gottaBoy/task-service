/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.apache.ftpserver.DataConnectionConfigurationFactory
 *  org.apache.ftpserver.FtpServer
 *  org.apache.ftpserver.FtpServerFactory
 *  org.apache.ftpserver.ftplet.UserManager
 *  org.apache.ftpserver.listener.ListenerFactory
 *  org.apache.ftpserver.usermanager.ClearTextPasswordEncryptor
 *  org.apache.ftpserver.usermanager.PasswordEncryptor
 */
package SA.IM.Ctrl;

import SA.IM.Ctrl.DEDataCtrl.IMRemoteDEDataCtrl;
import SA.IM.Ctrl.Data.IMFile;
import SA.IM.Ctrl.Data.IMMTServer;
import SA.IM.Ctrl.Data.IMMeeting;
import SA.IM.Ctrl.Data.IMMessageLog;
import SA.IM.Ctrl.Data.IMSysInform;
import SA.IM.Ctrl.Data.IMUserFile;
import SA.IM.Ctrl.Data.IMUserMessage;
import SA.IM.Ctrl.IIMCometEvent;
import SA.IM.Ctrl.IIMMeetingInstance;
import SA.IM.Ctrl.IIMMeetingServerContext;
import SA.IM.Ctrl.IIMMeetingServerInstance;
import SA.IM.Ctrl.IIMRemoteAction;
import SA.IM.Ctrl.IMDisGroupMeetingInstance;
import SA.IM.Ctrl.IMException;
import SA.IM.Ctrl.IMFuncServerInstance;
import SA.IM.Ctrl.IMMTFtpUserManager;
import SA.IM.Ctrl.IMMeetingInstance;
import SA.IM.Ctrl.IMMessagePackage;
import SA.IM.Ctrl.IMRemoteAction;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Hashtable;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ftpserver.DataConnectionConfigurationFactory;
import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.UserManager;
import org.apache.ftpserver.listener.ListenerFactory;
import org.apache.ftpserver.usermanager.ClearTextPasswordEncryptor;
import org.apache.ftpserver.usermanager.PasswordEncryptor;

public class IMMeetingServerInstance
extends IMFuncServerInstance
implements IIMMeetingServerInstance,
IIMMeetingServerContext {
    private static final Hashtable<String, String> meetingRemoteActionMap = new Hashtable();
    private static final Hashtable<String, String> meetingRemoteActionMap2;
    private static final Log log;
    protected Hashtable<String, IIMMeetingInstance> imMeetingInstanceMap = new Hashtable();
    protected FtpServer ftpServer = null;
    protected IMMTServer imMTServer = new IMMTServer();
    protected IDEDataCtrl fileDataCtrl = null;
    protected IDEDataCtrl userFileDataCtrl = null;
    protected IDEDataCtrl messageLogDataCtrl = null;
    protected IDEDataCtrl userMessageDataCtrl = null;
    protected IDEDataCtrl sysInformDataCtrl = null;
    protected IMRemoteDEDataCtrl fileRemoteDataCtrl = null;
    protected IMRemoteDEDataCtrl userFileRemoteDataCtrl = null;
    protected IMRemoteDEDataCtrl messageLogRemoteDataCtrl = null;
    protected IMRemoteDEDataCtrl userMessageRemoteDataCtrl = null;
    protected IMRemoteDEDataCtrl sysInformRemoteDataCtrl = null;
    protected int nSaveDataCount = 0;
    private Vector<WorkThread> workThreads = new Vector();
    protected boolean bStartFTPServer = true;

    static {
        meetingRemoteActionMap.put("MEETINGATTEND", "MEETINGATTEND");
        meetingRemoteActionMap.put("MEETINGQUIT", "MEETINGQUIT");
        meetingRemoteActionMap.put("MEETINGMESSAGE", "MEETINGMESSAGE");
        meetingRemoteActionMap.put("MEETINGKEYDOWN", "MEETINGKEYDOWN");
        meetingRemoteActionMap.put("MEETINGINVITE", "MEETINGINVITE");
        meetingRemoteActionMap.put("MEETINGKICKEDOUT", "MEETINGKICKEDOUT");
        meetingRemoteActionMap.put("MEETINGFILEUPLOAD", "MEETINGFILEUPLOAD");
        meetingRemoteActionMap.put("MEETINGFILEUPLOADED", "MEETINGFILEUPLOADED");
        meetingRemoteActionMap.put("MEETINGFILEDOWNLOADING", "MEETINGFILEDOWNLOADING");
        meetingRemoteActionMap.put("MEETINGFILEDOWNLOADED", "MEETINGFILEDOWNLOADED");
        meetingRemoteActionMap.put("MEETINGTALKCALL", "MEETINGTALKCALL");
        meetingRemoteActionMap.put("MEETINGTALKANSWER", "MEETINGTALKANSWER");
        meetingRemoteActionMap.put("MEETINGTALKREJECT", "MEETINGTALKREJECT");
        meetingRemoteActionMap.put("MEETINGTALKSYNC", "MEETINGTALKSYNC");
        meetingRemoteActionMap.put("MEETINGTALKCLOSE", "MEETINGTALKCLOSE");
        meetingRemoteActionMap.put("MEETINGMESSAGECONFIRM", "MEETINGMESSAGECONFIRM");
        meetingRemoteActionMap.put("MEETINGACTIVE", "MEETINGACTIVE");
        meetingRemoteActionMap.put("MEETINGRENAME", "MEETINGRENAME");
        meetingRemoteActionMap2 = new Hashtable();
        meetingRemoteActionMap2.put("USERSESSIONLOGIN", "USERSESSIONLOGIN");
        meetingRemoteActionMap2.put("USERSESSIONLOGOUT", "USERSESSIONLOGOUT");
        log = LogFactory.getLog(IMMeetingServerInstance.class);
    }

    @Override
    protected void OnInit() throws Exception {
        super.OnInit();
        CallResult callResult = this.getIMModelHelper().GetIMMTServer(this.getServerId(), this.imMTServer);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u4f1a\u8bae\u670d\u52a1\u5668[%1$s]\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)callResult.getErrorInfo()));
        }
    }

    @Override
    protected IMMessagePackage OnProcessRemoteAction(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        if (meetingRemoteActionMap.containsKey(iIMRemoteActionContext.getAction())) {
            return this.OnMeetingRemoteAction(iIMRemoteActionContext);
        }
        if (meetingRemoteActionMap2.containsKey(iIMRemoteActionContext.getAction())) {
            return this.OnMeetingRemoteAction2(iIMRemoteActionContext);
        }
        return super.OnProcessRemoteAction(iIMRemoteActionContext);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected IMMessagePackage OnMeetingRemoteAction(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        boolean bCreateMeetingInstance = true;
        String strMeetingId = iIMRemoteActionContext.getParam("MEETINGID", "");
        if (StringHelper.IsNullOrEmpty((String)strMeetingId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u4f1a\u8bae\u6807\u8bc6");
        }
        IIMMeetingInstance imMeetingInstance = null;
        Hashtable<String, IIMMeetingInstance> hashtable = this.imMeetingInstanceMap;
        synchronized (hashtable) {
            imMeetingInstance = this.imMeetingInstanceMap.get(strMeetingId);
        }
        if (imMeetingInstance == null && bCreateMeetingInstance) {
            IMMeeting imMeeting = new IMMeeting();
            CallResult callResult = this.getIMModelHelper().GetIMMeeting(strMeetingId, imMeeting);
            if (callResult.IsError()) {
                if (callResult.getRetCode() == 3 || callResult.getRetCode() == 1003) {
                    throw new IMException(10003);
                }
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u4f1a\u8bae\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            this.UpdateMeetingState(imMeeting, true);
            imMeetingInstance = this.OnCreateMeetingInstance(imMeeting);
            imMeetingInstance.Init(this.iDAGlobalHelper, this, imMeeting);
            Hashtable<String, IIMMeetingInstance> hashtable2 = this.imMeetingInstanceMap;
            synchronized (hashtable2) {
                this.imMeetingInstanceMap.put(strMeetingId, imMeetingInstance);
            }
        }
        if (imMeetingInstance == null) {
            throw new IMException(10003);
        }
        return imMeetingInstance.ProcessRemoteAction(iIMRemoteActionContext);
    }

    protected IIMMeetingInstance OnCreateMeetingInstance(IMMeeting imMeeting) throws Exception {
        if (imMeeting.isMEETINGTYPENull()) {
            return new IMMeetingInstance();
        }
        switch (imMeeting.getMEETINGTYPE()) {
            case 2: {
                return new IMDisGroupMeetingInstance();
            }
        }
        return new IMMeetingInstance();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected IMMessagePackage OnMeetingRemoteAction2(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        Vector<IIMMeetingInstance> imMeetingInstances = new Vector<IIMMeetingInstance>();
        Hashtable<String, IIMMeetingInstance> hashtable = this.imMeetingInstanceMap;
        synchronized (hashtable) {
            imMeetingInstances.addAll(this.imMeetingInstanceMap.values());
        }
        for (IIMMeetingInstance imMeetingInstance : imMeetingInstances) {
            try {
                imMeetingInstance.ProcessRemoteAction(iIMRemoteActionContext);
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u4f1a\u8bae[%1$s]\u5904\u7406\u8fdc\u7a0b\u64cd\u4f5c[%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)imMeetingInstance.getMeetingId(), (Object)iIMRemoteActionContext.getAction(), (Object)ex.getMessage()), (Throwable)ex);
            }
        }
        return new IMMessagePackage();
    }

    @Override
    protected void OnServerTimer() {
        super.OnServerTimer();
        IMRemoteAction imRemoteAction = new IMRemoteAction();
        imRemoteAction.setAction("SERVERSYNC");
        imRemoteAction.setParam("MEETINGCOUNT", StringHelper.Format((String)"%1$s", (Object)this.imMeetingInstanceMap.size()));
        imRemoteAction.setParam("ASYNCDATACOUNT", StringHelper.Format((String)"%1$s", (Object)this.nSaveDataCount));
        this.AddRemoteActionToQueue(imRemoteAction);
        this.OnCheckThread();
    }

    protected void UpdateMeetingState(IMMeeting imMeeting, boolean bBegin) throws Exception {
        IMMeeting imMeetingClone = new IMMeeting();
        imMeetingClone.setIMMEETINGID(imMeeting.getIMMEETINGID());
        if (bBegin) {
            imMeetingClone.setIMMTSERVERID(this.getServerId());
            imMeetingClone.SetParamValue("BEGINTIME", new Timestamp(new Date().getTime()));
            imMeetingClone.setCLOSEFLAG(false);
        } else {
            imMeetingClone.setIMMTSERVERID(null);
            imMeetingClone.SetParamValue("ENDTIME", new Timestamp(new Date().getTime()));
            imMeetingClone.setCLOSEFLAG(true);
        }
        CallResult callResult = null;
        if (this.getCatalogServerStub().isLocalMode()) {
            IDEDataCtrl meetingDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl2("IM0080", "SYSTEM", null);
            callResult = meetingDataCtrl.Save(false, (BaseDataEntity)imMeetingClone);
        } else {
            IMRemoteDEDataCtrl meetingDataCtrl = new IMRemoteDEDataCtrl();
            meetingDataCtrl.Init("", "IM0080", "SYSTEM");
            callResult = meetingDataCtrl.Save(false, imMeetingClone);
        }
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u66f4\u65b0\u4f1a\u8bae\u72b6\u6001\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        imMeetingClone.CopyTo(imMeeting, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void RegisterUserConnection(String strMeetingId, String strUserId, String strUserSessionId, IIMCometEvent cometEvent) throws IMException {
        IIMMeetingInstance imMeetingInstance = null;
        Hashtable<String, IIMMeetingInstance> hashtable = this.imMeetingInstanceMap;
        synchronized (hashtable) {
            imMeetingInstance = this.imMeetingInstanceMap.get(strMeetingId);
        }
        if (imMeetingInstance == null) {
            throw new IMException(10003);
        }
        imMeetingInstance.RegisterUserConnection(strUserId, strUserSessionId, cometEvent);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void UnregisterUserConnection(String strMeetingId, String strUserId) throws IMException {
        IIMMeetingInstance imMeetingInstance = null;
        Hashtable<String, IIMMeetingInstance> hashtable = this.imMeetingInstanceMap;
        synchronized (hashtable) {
            imMeetingInstance = this.imMeetingInstanceMap.get(strMeetingId);
        }
        if (imMeetingInstance == null) {
            throw new IMException(10003);
        }
        imMeetingInstance.UnregisterUserConnection(strUserId);
    }

    @Override
    public String getFtpServerPath() {
        return this.imMTServer.getFTPSERVERPATH();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void OnDispatchMessage() {
        Vector<IIMMeetingInstance> imMeetingInstanceList = new Vector<IIMMeetingInstance>();
        Hashtable<String, IIMMeetingInstance> hashtable = this.imMeetingInstanceMap;
        synchronized (hashtable) {
            imMeetingInstanceList.addAll(this.imMeetingInstanceMap.values());
        }
        for (IIMMeetingInstance imMeetingInstance : imMeetingInstanceList) {
            imMeetingInstance.DispatchMessage();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void OnTestTimeout() {
        Vector<IIMMeetingInstance> imMeetingInstanceList = new Vector<IIMMeetingInstance>();
        Hashtable<String, IIMMeetingInstance> hashtable = this.imMeetingInstanceMap;
        synchronized (hashtable) {
            for (IIMMeetingInstance imMeetingInstance : this.imMeetingInstanceMap.values()) {
                imMeetingInstanceList.add(imMeetingInstance);
            }
        }
        for (IIMMeetingInstance imMeetingInstance : imMeetingInstanceList) {
            imMeetingInstance.TestTimeout();
            if (!imMeetingInstance.isTimeout()) continue;
            log.debug((Object)StringHelper.Format((String)"\u4f1a\u8bae[%1$s]\u8d85\u65f6\u5173\u95ed", (Object)imMeetingInstance.getMeetingId()));
            Hashtable<String, IIMMeetingInstance> hashtable2 = this.imMeetingInstanceMap;
            synchronized (hashtable2) {
                this.imMeetingInstanceMap.remove(imMeetingInstance.getMeetingId());
            }
            imMeetingInstance.Close();
            try {
                IMMeeting imMeeting = new IMMeeting();
                imMeeting.setIMMEETINGID(imMeetingInstance.getMeetingId());
                this.UpdateMeetingState(imMeeting, false);
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u5173\u95ed\u4f1a\u8bae\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void OnSaveData() {
        Vector<BaseDataEntity> datas = new Vector<BaseDataEntity>();
        Vector<IIMMeetingInstance> imMeetingInstances = new Vector<IIMMeetingInstance>();
        Hashtable<String, IIMMeetingInstance> hashtable = this.imMeetingInstanceMap;
        synchronized (hashtable) {
            imMeetingInstances.addAll(this.imMeetingInstanceMap.values());
        }
        for (IIMMeetingInstance imMeetingInstance : imMeetingInstances) {
            imMeetingInstance.FillSaveDatas(datas);
        }
        this.OnSaveData(datas);
    }

    protected void OnSaveData(Vector<BaseDataEntity> datas) {
        this.nSaveDataCount = datas.size();
        if (datas.size() == 0) {
            return;
        }
        log.debug((Object)StringHelper.Format((String)"\u5f85\u4fdd\u5b58\u5f02\u6b65\u6570\u636e[%1$s]", (Object)datas.size()));
        while (datas.size() > 0) {
            CallResult callResult;
            boolean bInsert;
            BaseDataEntity data = datas.remove(0);
            --this.nSaveDataCount;
            BaseDEDataCtrl.SetCallParamCheckKey((BaseDataEntity)data, (boolean)false);
            BaseDEDataCtrl.SetCallParamDALog((BaseDataEntity)data, (boolean)false);
            BaseDEDataCtrl.SetCallParamRetData((BaseDataEntity)data, (boolean)false);
            boolean bl = bInsert = data.GetParamIntValue("SRF_UPDATEMODE", 0) == 0;
            if (data instanceof IMFile) {
                callResult = null;
                callResult = this.getCatalogServerStub().isLocalMode() ? this.fileDataCtrl.Save(bInsert, data) : this.fileRemoteDataCtrl.Save(bInsert, data);
                if (!callResult.IsError()) continue;
                log.error((Object)StringHelper.Format((String)"\u4fdd\u5b58\u4f1a\u8bae\u6587\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                continue;
            }
            if (data instanceof IMUserFile) {
                callResult = null;
                callResult = this.getCatalogServerStub().isLocalMode() ? this.userFileDataCtrl.Save(bInsert, data) : this.userFileRemoteDataCtrl.Save(bInsert, data);
                if (!callResult.IsError()) continue;
                log.error((Object)StringHelper.Format((String)"\u4fdd\u5b58\u7528\u6237\u6587\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                continue;
            }
            if (data instanceof IMMessageLog) {
                callResult = null;
                callResult = this.getCatalogServerStub().isLocalMode() ? this.messageLogDataCtrl.Save(bInsert, data) : this.messageLogRemoteDataCtrl.Save(bInsert, data);
                if (!callResult.IsError()) continue;
                log.error((Object)StringHelper.Format((String)"\u4fdd\u5b58\u6d88\u606f\u8bb0\u5f55\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                continue;
            }
            if (data instanceof IMUserMessage) {
                callResult = null;
                callResult = this.getCatalogServerStub().isLocalMode() ? this.userMessageDataCtrl.Save(bInsert, data) : this.userMessageRemoteDataCtrl.Save(bInsert, data);
                if (!callResult.IsError()) continue;
                log.error((Object)StringHelper.Format((String)"\u4fdd\u5b58\u7528\u6237\u6d88\u606f\u8bb0\u5f55\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                continue;
            }
            if (!(data instanceof IMSysInform)) continue;
            callResult = null;
            callResult = this.getCatalogServerStub().isLocalMode() ? this.sysInformDataCtrl.Save(bInsert, data) : this.sysInformRemoteDataCtrl.Save(bInsert, data);
            if (!callResult.IsError()) continue;
            log.error((Object)StringHelper.Format((String)"\u4fdd\u5b58\u7cfb\u7edf\u901a\u77e5\u6d88\u606f\u8bb0\u5f55\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    @Override
    protected void OnShutdownServer() throws Exception {
        for (WorkThread workThread : this.workThreads) {
            workThread.setStopFlag();
        }
        for (WorkThread workThread : this.workThreads) {
            while (workThread.isAlive()) {
                Thread.sleep(100L);
            }
        }
        this.OnSaveData();
        this.fileDataCtrl = null;
        this.userFileDataCtrl = null;
        this.messageLogDataCtrl = null;
        this.userMessageDataCtrl = null;
        this.fileRemoteDataCtrl = null;
        this.userFileRemoteDataCtrl = null;
        this.messageLogRemoteDataCtrl = null;
        this.userMessageRemoteDataCtrl = null;
        if (this.bStartFTPServer) {
            this.OnShutdownFtpServer();
        }
        super.OnShutdownServer();
    }

    @Override
    protected void OnStartServer() throws Exception {
        super.OnStartServer();
        if (this.getCatalogServerStub().isLocalMode()) {
            this.fileDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl2("IM0090", "SYSTEM", null);
            this.userFileDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl2("IM0091", "SYSTEM", null);
            this.messageLogDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl2("IM0082", "SYSTEM", null);
            this.userMessageDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl2("IM0083", "SYSTEM", null);
            this.sysInformDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl2("IM0086", "SYSTEM", null);
        } else {
            this.fileRemoteDataCtrl = new IMRemoteDEDataCtrl();
            this.fileRemoteDataCtrl.Init("", "IM0090", "SYSTEM");
            this.userFileRemoteDataCtrl = new IMRemoteDEDataCtrl();
            this.userFileRemoteDataCtrl.Init("", "IM0091", "SYSTEM");
            this.messageLogRemoteDataCtrl = new IMRemoteDEDataCtrl();
            this.messageLogRemoteDataCtrl.Init("", "IM0082", "SYSTEM");
            this.userMessageRemoteDataCtrl = new IMRemoteDEDataCtrl();
            this.userMessageRemoteDataCtrl.Init("", "IM0083", "SYSTEM");
            this.sysInformRemoteDataCtrl = new IMRemoteDEDataCtrl();
            this.sysInformRemoteDataCtrl.Init("", "IM0086", "SYSTEM");
        }
        if (!this.imMTServer.isENABLEFTPSERVERNull()) {
            this.bStartFTPServer = this.imMTServer.getENABLEFTPSERVER();
        }
        if (this.bStartFTPServer) {
            this.OnStartFtpServer();
        }
        this.OnCheckThread();
    }

    protected int getDispatchMessageThreadCount() {
        return 20;
    }

    protected int getTimeoutThreadCount() {
        return 2;
    }

    protected int getSaveDataThreadCount() {
        return 1;
    }

    protected void OnStartFtpServer() throws Exception {
        if (this.ftpServer != null) {
            throw new Exception("\u670d\u52a1\u5668\u5df2\u7ecf\u542f\u52a8");
        }
        FtpServerFactory serverFactory = new FtpServerFactory();
        ListenerFactory factory = new ListenerFactory();
        int nPort = 2221;
        if (!this.imMTServer.isFTPPORTNull()) {
            nPort = this.imMTServer.getFTPPORT();
        }
        DataConnectionConfigurationFactory dataConnectionConfigurationFactory = new DataConnectionConfigurationFactory();
        if (!this.imMTServer.isFTPPASSIVEADDRNull()) {
            dataConnectionConfigurationFactory.setPassiveAddress(this.imMTServer.getFTPPASSIVEADDR());
        }
        if (!this.imMTServer.isFTPPASSIVEPORTNull()) {
            dataConnectionConfigurationFactory.setPassivePorts(this.imMTServer.getFTPPASSIVEPORT());
        }
        factory.setDataConnectionConfiguration(dataConnectionConfigurationFactory.createDataConnectionConfiguration());
        factory.setPort(nPort);
        serverFactory.addListener("default", factory.createListener());
        IMMTFtpUserManager imMTFtpUserManager = new IMMTFtpUserManager("", (PasswordEncryptor)new ClearTextPasswordEncryptor());
        imMTFtpUserManager.setRootFolder(this.imMTServer.getFTPROOT());
        serverFactory.setUserManager((UserManager)imMTFtpUserManager);
        this.ftpServer = serverFactory.createServer();
        this.ftpServer.start();
    }

    protected void OnShutdownFtpServer() throws Exception {
        if (this.ftpServer == null) {
            return;
        }
        this.ftpServer.stop();
        this.ftpServer = null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void OnCheckThread() {
        try {
            Vector<WorkThread> vector = this.workThreads;
            synchronized (vector) {
                WorkThread workThread;
                int nDispatchMessageCnt = 0;
                int nTimeoutCnt = 0;
                int nSaveDataCnt = 0;
                Vector<WorkThread> list = new Vector<WorkThread>();
                list.addAll(this.workThreads);
                for (WorkThread workThread2 : list) {
                    if (!workThread2.isAlive()) {
                        this.workThreads.remove(workThread2);
                        log.debug((Object)StringHelper.Format((String)"\u79fb\u9664\u5f02\u5e38\u7ebf\u7a0b"));
                        continue;
                    }
                    if (workThread2.getWorkType() == 1) {
                        ++nDispatchMessageCnt;
                        continue;
                    }
                    if (workThread2.getWorkType() == 2) {
                        ++nTimeoutCnt;
                        continue;
                    }
                    if (workThread2.getWorkType() != 3) continue;
                    ++nSaveDataCnt;
                }
                int i = nDispatchMessageCnt;
                while (i < this.getDispatchMessageThreadCount()) {
                    workThread = new WorkThread();
                    workThread.setWorkType(1);
                    this.workThreads.add(workThread);
                    workThread.start();
                    ++i;
                }
                i = nTimeoutCnt;
                while (i < this.getTimeoutThreadCount()) {
                    workThread = new WorkThread();
                    workThread.setWorkType(2);
                    this.workThreads.add(workThread);
                    workThread.start();
                    ++i;
                }
                i = nSaveDataCnt;
                while (i < this.getSaveDataThreadCount()) {
                    workThread = new WorkThread();
                    workThread.setWorkType(3);
                    this.workThreads.add(workThread);
                    workThread.start();
                    ++i;
                }
            }
        }
        catch (Exception ex) {
            log.debug((Object)ex);
        }
    }

    @Override
    public boolean isLocalMode() {
        return this.getCatalogServerStub().isLocalMode();
    }

    private class WorkThread
    extends Thread {
        public static final int WORK_DISPATCHMESSAGE = 1;
        public static final int WORK_TIMEOUT = 2;
        public static final int WORK_SAVEDATA = 3;
        protected boolean bStopFlag = false;
        protected int nWorkType = 1;

        private WorkThread() {
        }

        public void setStopFlag() {
            this.bStopFlag = true;
        }

        public void setWorkType(int nWorkType) {
            this.nWorkType = nWorkType;
        }

        public int getWorkType() {
            return this.nWorkType;
        }

        @Override
        public void run() {
            while (!this.bStopFlag) {
                try {
                    switch (this.nWorkType) {
                        case 1: {
                            IMMeetingServerInstance.this.OnDispatchMessage();
                            break;
                        }
                        case 2: {
                            IMMeetingServerInstance.this.OnTestTimeout();
                            break;
                        }
                        case 3: {
                            IMMeetingServerInstance.this.OnSaveData();
                        }
                    }
                    Thread.sleep(50L);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

