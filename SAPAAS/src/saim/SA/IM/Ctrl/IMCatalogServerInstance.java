/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.DefaultTransactionManager
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Base64
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  net.sf.json.JSONObject
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
import SA.IM.Ctrl.Data.IMCatalogServer;
import SA.IM.Ctrl.Data.IMFile;
import SA.IM.Ctrl.Data.IMMeeting;
import SA.IM.Ctrl.Data.IMOrgTree;
import SA.IM.Ctrl.Data.IMParticipant;
import SA.IM.Ctrl.Data.IMServer;
import SA.IM.Ctrl.Data.IMServerLog;
import SA.IM.Ctrl.Data.IMUser;
import SA.IM.Ctrl.Data.IMUserFile;
import SA.IM.Ctrl.Data.IMUserInform;
import SA.IM.Ctrl.Data.IMUserSession;
import SA.IM.Ctrl.Data.IMVersion;
import SA.IM.Ctrl.IIMCatalogServerInstance;
import SA.IM.Ctrl.IIMMeetingServerStub;
import SA.IM.Ctrl.IIMRemoteAction;
import SA.IM.Ctrl.IIMServerStub;
import SA.IM.Ctrl.IIMStateServerStub;
import SA.IM.Ctrl.IMException;
import SA.IM.Ctrl.IMMTFtpUserManager;
import SA.IM.Ctrl.IMMeetingServerStub;
import SA.IM.Ctrl.IMMessagePackage;
import SA.IM.Ctrl.IMRemoteAction;
import SA.IM.Ctrl.IMServerInstance;
import SA.IM.Ctrl.IMStateServerStub;
import SA.IM.Ctrl.IMStunServer;
import SA.IM.Ctrl.Message.IMInformMessage;
import SA.IM.Ctrl.Message.IMUserInformMessage;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DefaultTransactionManager;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Base64;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ftpserver.DataConnectionConfigurationFactory;
import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.UserManager;
import org.apache.ftpserver.listener.ListenerFactory;

public class IMCatalogServerInstance
extends IMServerInstance
implements IIMCatalogServerInstance {
    protected Vector<IIMStateServerStub> imStateServerStubList = new Vector();
    protected Vector<IIMMeetingServerStub> imMeetingServerStubList = new Vector();
    protected Hashtable<String, IIMServerStub> imServerStubMap = new Hashtable();
    protected Vector<IIMRemoteAction> remoteActionQueue = new Vector();
    protected Vector<IIMRemoteAction> remoteActionQueue2 = new Vector();
    private static final Log log = LogFactory.getLog(IMCatalogServerInstance.class);
    protected IMCatalogServer imCatalogServer = new IMCatalogServer();
    protected String strStunServerPath = "";
    protected Date lastRefreshVersionDate = null;
    protected Date lastRefreshOrgDate = null;
    protected Hashtable<String, IMVersion> supportIMVersionMap = new Hashtable();
    protected Hashtable<String, IMOrgTree> imOrgTreeMap = new Hashtable();
    protected IMVersion lastVersion = new IMVersion();
    protected IMMessagePackage lastVersionPackage = new IMMessagePackage();
    protected IDEDataCtrl imUserInformDataCtrl = null;
    protected IMRemoteDEDataCtrl imRemoteUserInformDataCtrl = null;
    protected IDEDataCtrl imServerLogDataCtrl = null;
    protected IMRemoteDEDataCtrl imServerLogRemoteDataCtrl = null;
    private boolean bGetEnableUserInform = false;
    private boolean bEnableUserInform = false;
    protected FtpServer ftpServer = null;
    private Hashtable<String, String> fileNameMap = new Hashtable();
    protected boolean bLocalMode = true;
    private DispatchMessageThread dispatchMessageThread = new DispatchMessageThread();
    private IMStunServer imStunServer = null;

    public boolean isLocalMode() {
        return this.bLocalMode;
    }

    public void setLocalMode(boolean bLocalMode) {
        this.bLocalMode = bLocalMode;
    }

    @Override
    protected void OnInit() throws Exception {
        super.OnInit();
        CallResult callResult = this.getIMModelHelper().GetIMCatalogServer(this.getServerId(), this.imCatalogServer);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u7f16\u7801\u670d\u52a1\u5668[%1$s]\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)callResult.getErrorInfo()));
        }
    }

    @Override
    protected IMMessagePackage OnProcessRemoteAction(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"SERVERSYNC", (boolean)true) == 0) {
            return this.OnServerSync(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"USERLOGIN", (boolean)true) == 0) {
            return this.OnUserLogin(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"CHECKVERSION", (boolean)true) == 0) {
            return this.OnCheckVersion(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"USERSESSIONLOGIN", (boolean)true) == 0) {
            return this.OnUserSessionLogin(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"USERSESSIONLOGOUT", (boolean)true) == 0) {
            return this.OnUserSessionLogout(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"USERINFOSYNC", (boolean)true) == 0) {
            return this.OnUserInfoSync(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"USERFULLINFOSYNC", (boolean)true) == 0) {
            return this.OnUserFullInfoSync(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"MEETINGOPEN", (boolean)true) == 0) {
            return this.OnMeetingOpen(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"MEETINGREOPEN", (boolean)true) == 0) {
            return this.OnMeetingReopen(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"MEETINGINVITE", (boolean)true) == 0) {
            return this.OnMeetingInvite(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"MEETINGKICKEDOUT", (boolean)true) == 0) {
            return this.OnMeetingKickedOut(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"SERVERLOGIN", (boolean)true) == 0) {
            return this.OnServerLogin(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"SERVERLOGOUT", (boolean)true) == 0) {
            return this.OnServerLogout(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"SERVERSHUTTINGDOWN", (boolean)true) == 0) {
            return this.OnServerShuttingDown(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"GETLASTVERSION", (boolean)true) == 0) {
            return this.OnGetLastVersion(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"USERINFORM", (boolean)true) == 0) {
            return this.OnUserInform(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"CANCELUSERINFORM", (boolean)true) == 0) {
            return this.OnCancelUserInform(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"MEETINGFILEUPLOAD", (boolean)true) == 0) {
            return this.OnMeetingFileUpload(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"MEETINGFILEUPLOADED", (boolean)true) == 0) {
            return this.OnMeetingFileUploaded(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"GETSERVERSTATUS", (boolean)true) == 0) {
            return this.OnGetServerStatus(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"USERICONSYNC", (boolean)true) == 0) {
            return this.OnUserIconSync(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"DISGROUPINVITE", (boolean)true) == 0) {
            return this.OnDisGroupInvite(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"DISGROUPQUIT", (boolean)true) == 0) {
            return this.OnDisGroupQuit(iIMRemoteActionContext);
        }
        return super.OnProcessRemoteAction(iIMRemoteActionContext);
    }

    protected IMMessagePackage OnUserIconSync(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        String strUserId = iIMRemoteActionContext.getParam("USERID", "");
        String strFileExt = iIMRemoteActionContext.getParam("FILENAME", "");
        String strContent = iIMRemoteActionContext.getContent();
        if (StringHelper.IsNullOrEmpty((String)strContent)) {
            throw new Exception("\u6ca1\u6709\u4e0a\u4f20\u56fe\u7247\u5185\u5bb9");
        }
        IMUser imUser = new IMUser();
        imUser.setIMUSERID(strUserId);
        this.UpdateUserIcon(imUser, strFileExt, strContent);
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        imMessagePackage.setExtInfo("filename", imUser.getICONPATH());
        return imMessagePackage;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected IMMessagePackage OnServerLogin(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        String strServerId = iIMRemoteActionContext.getParam("SERVERID", "");
        if (StringHelper.IsNullOrEmpty((String)strServerId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u670d\u52a1\u5668\u6807\u8bc6");
        }
        IMServer tmServer = new IMServer();
        CallResult callResult = this.getIMModelHelper().GetIMServer(strServerId, tmServer);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2IM\u670d\u52a1\u5668\u53d1\u751f\u9519\u8bef,%1$s", (Object)callResult.getErrorInfo()));
        }
        Hashtable<String, IIMServerStub> hashtable = this.imServerStubMap;
        synchronized (hashtable) {
            if (this.imServerStubMap.containsKey(strServerId)) {
                IIMServerStub iIMServerStubLast = this.imServerStubMap.get(strServerId);
                if (StringHelper.Compare((String)iIMServerStubLast.getServerType(), (String)"MEETINGSERVER", (boolean)true) == 0) {
                    this.imMeetingServerStubList.remove(iIMServerStubLast);
                }
                if (StringHelper.Compare((String)iIMServerStubLast.getServerType(), (String)"STATESERVER", (boolean)true) == 0) {
                    this.imStateServerStubList.remove(iIMServerStubLast);
                }
                this.imServerStubMap.remove(strServerId);
            }
        }
        IIMServerStub iIMServerStub = this.OnCreateIMServerStub(tmServer);
        iIMServerStub.Init(this.iDAGlobalHelper, tmServer);
        String strLocalMode = iIMRemoteActionContext.getParam("LOCALMODE", "");
        if (StringHelper.Compare((String)strLocalMode, (String)"TRUE", (boolean)true) == 0) {
            iIMServerStub.setLocalMode(true);
        }
        if (StringHelper.Compare((String)iIMServerStub.getServerType(), (String)"MEETINGSERVER", (boolean)true) == 0) {
            this.imMeetingServerStubList.add((IIMMeetingServerStub)iIMServerStub);
        }
        if (StringHelper.Compare((String)iIMServerStub.getServerType(), (String)"STATESERVER", (boolean)true) == 0) {
            this.imStateServerStubList.add((IIMStateServerStub)iIMServerStub);
        }
        this.imServerStubMap.put(strServerId, iIMServerStub);
        IMServerLog imServerLog = new IMServerLog();
        imServerLog.setIMSERVERID(strServerId);
        imServerLog.setLOGINFO("\u670d\u52a1\u5668\u767b\u5165");
        callResult = this.isLocalMode() ? this.imServerLogDataCtrl.Save(true, (BaseDataEntity)imServerLog) : this.imServerLogRemoteDataCtrl.Save(true, imServerLog);
        if (callResult.IsError()) {
            log.warn((Object)StringHelper.Format((String)"\u4fdd\u5b58\u670d\u52a1\u5668\u65e5\u5fd7\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        log.debug((Object)StringHelper.Format((String)"SERVER[%1$s]\u767b\u5165", (Object)strServerId));
        return new IMMessagePackage();
    }

    protected IIMServerStub OnCreateIMServerStub(IMServer tmServer) throws Exception {
        String strIMServerType = tmServer.getIMSERVERTYPE();
        if (StringHelper.Compare((String)strIMServerType, (String)"MEETINGSERVER", (boolean)true) == 0) {
            return new IMMeetingServerStub();
        }
        if (StringHelper.Compare((String)strIMServerType, (String)"STATESERVER", (boolean)true) == 0) {
            return new IMStateServerStub();
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u670d\u52a1\u5668\u7c7b\u578b[%1$s]", (Object)strIMServerType));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected IMMessagePackage OnServerLogout(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        String strServerId = iIMRemoteActionContext.getParam("SERVERID", "");
        if (StringHelper.IsNullOrEmpty((String)strServerId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u670d\u52a1\u5668\u6807\u8bc6");
        }
        Hashtable<String, IIMServerStub> hashtable = this.imServerStubMap;
        synchronized (hashtable) {
            if (this.imServerStubMap.containsKey(strServerId)) {
                IIMServerStub iIMServerStubLast = this.imServerStubMap.get(strServerId);
                if (StringHelper.Compare((String)iIMServerStubLast.getServerType(), (String)"MEETINGSERVER", (boolean)true) == 0) {
                    this.imMeetingServerStubList.remove(iIMServerStubLast);
                }
                if (StringHelper.Compare((String)iIMServerStubLast.getServerType(), (String)"STATESERVER", (boolean)true) == 0) {
                    this.imStateServerStubList.remove(iIMServerStubLast);
                }
                this.imServerStubMap.remove(strServerId);
            }
        }
        IMServerLog imServerLog = new IMServerLog();
        imServerLog.setIMSERVERID(strServerId);
        imServerLog.setLOGINFO("\u670d\u52a1\u5668\u6ce8\u9500");
        CallResult callResult = null;
        callResult = this.isLocalMode() ? this.imServerLogDataCtrl.Save(true, (BaseDataEntity)imServerLog) : this.imServerLogRemoteDataCtrl.Save(true, imServerLog);
        if (callResult.IsError()) {
            log.warn((Object)StringHelper.Format((String)"\u4fdd\u5b58\u670d\u52a1\u5668\u65e5\u5fd7\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        log.debug((Object)StringHelper.Format((String)"SERVER[%1$s]\u6ce8\u9500", (Object)strServerId));
        return new IMMessagePackage();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected IMMessagePackage OnServerSync(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        String strServerId = iIMRemoteActionContext.getParam("SERVERID", "");
        if (StringHelper.IsNullOrEmpty((String)strServerId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u670d\u52a1\u5668\u6807\u8bc6");
        }
        IIMServerStub iIMServerStubLast = null;
        Hashtable<String, IIMServerStub> hashtable = this.imServerStubMap;
        synchronized (hashtable) {
            if (this.imServerStubMap.containsKey(strServerId)) {
                iIMServerStubLast = this.imServerStubMap.get(strServerId);
            }
        }
        if (iIMServerStubLast == null) {
            throw new Exception("\u6ca1\u6709\u83b7\u53d6\u6307\u5b9a\u670d\u52a1\u5668");
        }
        log.debug((Object)StringHelper.Format((String)"SERVER[%1$s]\u540c\u6b65", (Object)strServerId));
        return iIMServerStubLast.ProcessRemoteAction(iIMRemoteActionContext);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected IMMessagePackage OnServerShuttingDown(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        String strServerId = iIMRemoteActionContext.getParam("SERVERID", "");
        if (StringHelper.IsNullOrEmpty((String)strServerId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u670d\u52a1\u5668\u6807\u8bc6");
        }
        IIMServerStub iIMServerStubLast = null;
        Hashtable<String, IIMServerStub> hashtable = this.imServerStubMap;
        synchronized (hashtable) {
            if (this.imServerStubMap.containsKey(strServerId)) {
                iIMServerStubLast = this.imServerStubMap.get(strServerId);
            }
        }
        if (iIMServerStubLast == null) {
            throw new Exception("\u6ca1\u6709\u83b7\u53d6\u6307\u5b9a\u670d\u52a1\u5668");
        }
        log.debug((Object)StringHelper.Format((String)"SERVER[%1$s]\u6b63\u5728\u5173\u95ed", (Object)strServerId));
        return iIMServerStubLast.ProcessRemoteAction(iIMRemoteActionContext);
    }

    protected IMMessagePackage OnUserSessionLogin(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMRemoteAction imRemoteActionClone = new IMRemoteAction();
        imRemoteActionClone.FromRemoteAction(iIMRemoteActionContext);
        this.AddRemoteActionToQueue(imRemoteActionClone, false);
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        imMessagePackage.setRetCode(0);
        return imMessagePackage;
    }

    protected IMMessagePackage OnUserSessionLogout(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMRemoteAction imRemoteActionClone = new IMRemoteAction();
        imRemoteActionClone.FromRemoteAction(iIMRemoteActionContext);
        this.AddRemoteActionToQueue(imRemoteActionClone, false);
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        imMessagePackage.setRetCode(0);
        return imMessagePackage;
    }

    protected IMMessagePackage OnUserInfoSync(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMRemoteAction imRemoteActionClone = new IMRemoteAction();
        imRemoteActionClone.FromRemoteAction(iIMRemoteActionContext);
        this.AddRemoteActionToQueue(imRemoteActionClone, false);
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        imMessagePackage.setRetCode(0);
        return imMessagePackage;
    }

    protected IMMessagePackage OnUserFullInfoSync(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMRemoteAction imRemoteActionClone = new IMRemoteAction();
        imRemoteActionClone.FromRemoteAction(iIMRemoteActionContext);
        this.AddRemoteActionToQueue(imRemoteActionClone, false);
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        imMessagePackage.setRetCode(0);
        return imMessagePackage;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected IMMessagePackage OnUserLogin(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        String strVersion = iIMRemoteActionContext.getParam("VERSION", "");
        if (StringHelper.IsNullOrEmpty((String)strVersion)) {
            throw new IMException(10006);
        }
        boolean bNeedUpdate = false;
        Hashtable<String, IMVersion> hashtable = this.supportIMVersionMap;
        synchronized (hashtable) {
            bNeedUpdate = !this.supportIMVersionMap.containsKey(strVersion);
        }
        if (bNeedUpdate) {
            throw new IMException(10006, "\u4ea7\u54c1\u9700\u8981\u66f4\u65b0\u624d\u80fd\u591f\u4f7f\u7528\u3002");
        }
        String strUserId = iIMRemoteActionContext.getParam("USERID", "");
        if (StringHelper.IsNullOrEmpty((String)strUserId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7528\u6237\u6807\u8bc6");
        }
        String strPassword = iIMRemoteActionContext.getParam("PASSWORD", "");
        if (StringHelper.IsNullOrEmpty((String)strPassword)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7528\u6237\u5bc6\u7801");
        }
        CallResult callResult = this.OnUserAuth(strUserId, strPassword);
        if (callResult.IsError()) {
            throw new IMException(10000);
        }
        IIMStateServerStub imStateServerStub = this.GetStateServer(iIMRemoteActionContext);
        IMUserSession imUserSession = new IMUserSession();
        String strIMDomain = "";
        if (callResult.getUserObject() != null && callResult.getUserObject() instanceof IMUser) {
            IMUser imUser = (IMUser)((Object)callResult.getUserObject());
            if (!imUser.isUSERLEVELNull()) {
                imUserSession.setUSERLEVEL(imUser.getUSERLEVEL());
            }
            if (!imUser.isTALKLEVELNull()) {
                imUserSession.setTALKLEVEL(imUser.getTALKLEVEL());
            }
            if (!StringHelper.IsNullOrEmpty((String)imUser.getIMUSERID())) {
                strUserId = imUser.getIMUSERID();
            }
            if (!StringHelper.IsNullOrEmpty((String)imUser.getIMDOMAIN())) {
                strIMDomain = imUser.getIMDOMAIN();
            }
            imUserSession.setLASTINFORMTIME(imUser.getLASTINFORMTIME());
        }
        imUserSession.setIMUSERID(strUserId);
        imUserSession.setREMOTEADDR(iIMRemoteActionContext.getRemoteAddress());
        imUserSession.setCLIENTINFO(iIMRemoteActionContext.getParam("CLIENTINFO", ""));
        imUserSession.setIMVERSION(iIMRemoteActionContext.getParam("VERSION", ""));
        this.OnCreateUserSession(imUserSession);
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        imMessagePackage.setRetCode(0);
        imMessagePackage.setExtInfo("USERSESSIONID", imUserSession.getIMUSERSESSIONID());
        imMessagePackage.setExtInfo("SERVERPATH", imStateServerStub.getServerPath());
        if (!imUserSession.isUSERLEVELNull()) {
            imMessagePackage.setExtInfo("USERLEVEL", StringHelper.Format((String)"%1$s", (Object)imUserSession.getUSERLEVEL()));
        }
        if (!imUserSession.isTALKLEVELNull()) {
            imMessagePackage.setExtInfo("TALKLEVEL", StringHelper.Format((String)"%1$s", (Object)imUserSession.getTALKLEVEL()));
        }
        imMessagePackage.setExtInfo("SERVERCOMETPATH", imStateServerStub.getServerCometPath());
        imMessagePackage.setExtInfo("STUNSERVERPATH", this.strStunServerPath);
        imMessagePackage.setExtInfo("USERID", imUserSession.getIMUSERID());
        imMessagePackage.setExtInfo("IMDOMAIN", strIMDomain);
        return imMessagePackage;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected IMMessagePackage OnCheckVersion(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        String strVersion = iIMRemoteActionContext.getParam("VERSION", "");
        if (StringHelper.IsNullOrEmpty((String)strVersion)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7248\u672c\u4fe1\u606f");
        }
        IMVersion imVersion = null;
        Hashtable<String, IMVersion> hashtable = this.supportIMVersionMap;
        synchronized (hashtable) {
            imVersion = this.supportIMVersionMap.get(strVersion);
        }
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        if (imVersion == null) {
            imMessagePackage.setRetCode(10006);
            imMessagePackage.setExtInfo("VERSION", this.lastVersion.getIMVERSIONNAME());
        } else {
            imMessagePackage.setRetCode(0);
        }
        return imMessagePackage;
    }

    protected IMMessagePackage OnUserInform(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        String strExpiredTime;
        String strInformTime;
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        IMUserInform imUserInform = new IMUserInform();
        String strSender = iIMRemoteActionContext.getParam("SENDER", "");
        String strReceiverType = iIMRemoteActionContext.getParam("RECEIVERTYPE", "");
        String strReceiver = iIMRemoteActionContext.getParam("RECEIVER", "");
        String strInformType = iIMRemoteActionContext.getParam("INFORMTYPE", "");
        if (!StringHelper.IsNullOrEmpty((String)strInformType)) {
            imUserInform.setINFORMTYPE(Integer.parseInt(strInformType));
        }
        imUserInform.setSENDER(strSender);
        imUserInform.setRECEIVERTYPE(strReceiverType);
        imUserInform.setRECEIVER(strReceiver);
        JSONObject contentJO = null;
        if (!StringHelper.IsNullOrEmpty((String)iIMRemoteActionContext.getContent())) {
            contentJO = JSONObject.fromString((String)iIMRemoteActionContext.getContent());
            if (contentJO.has("subject")) {
                imUserInform.setIMUSERINFORMNAME(contentJO.getString("subject"));
            }
            if (contentJO.has("content")) {
                imUserInform.setCONTENT(contentJO.getString("content"));
            }
            if (contentJO.has("richcontent")) {
                imUserInform.setRICHCONTENT(contentJO.getString("richcontent"));
            }
            if (contentJO.has("url")) {
                imUserInform.setURL(contentJO.getString("url"));
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)(strInformTime = iIMRemoteActionContext.getParam("INFORMTIME", "")))) {
            Date informTime = DateParser.Parse((String)strInformTime);
            imUserInform.setINFORMTIME(new Timestamp(informTime.getTime()));
        }
        if (!StringHelper.IsNullOrEmpty((String)(strExpiredTime = iIMRemoteActionContext.getParam("EXPIREDTIME", "")))) {
            Date expiredTime = DateParser.Parse((String)strExpiredTime);
            imUserInform.setEXPIREDTIME(new Timestamp(expiredTime.getTime()));
        }
        this.OnCreateUserInform(imUserInform);
        IMRemoteAction imRemoteActionClone = new IMRemoteAction();
        imRemoteActionClone.FromRemoteAction(iIMRemoteActionContext);
        imRemoteActionClone.setParam("INFORMTIME", StringHelper.Format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)imUserInform.getINFORMTIME()));
        imRemoteActionClone.setParam("USERINFORMID", imUserInform.getIMUSERINFORMID());
        this.AddRemoteActionToQueue(imRemoteActionClone, true);
        imMessagePackage.setExtInfo("USERINFORMID", imUserInform.getIMUSERINFORMID());
        return imMessagePackage;
    }

    protected void OnCreateUserInform(IMUserInform imUserInform) throws Exception {
        BaseDEDataCtrl.SetCallParamDALog((BaseDataEntity)imUserInform, (boolean)false);
        BaseDEDataCtrl.SetCallParamCheckKey((BaseDataEntity)imUserInform, (boolean)false);
        CallResult callResult = null;
        callResult = this.isLocalMode() ? this.imUserInformDataCtrl.Save(true, (BaseDataEntity)imUserInform) : this.imRemoteUserInformDataCtrl.Save(true, imUserInform);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u7528\u6237\u901a\u77e5\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    protected IMMessagePackage OnCancelUserInform(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        IMUserInform imUserInform = new IMUserInform();
        String strSender = iIMRemoteActionContext.getParam("SENDER", "");
        String strUserInformId = iIMRemoteActionContext.getParam("USERINFORMID", "");
        imUserInform.setIMUSERINFORMID(strUserInformId);
        this.OnCancelUserInform(imUserInform);
        imMessagePackage.setExtInfo("USERINFORMID", imUserInform.getIMUSERINFORMID());
        return imMessagePackage;
    }

    protected void OnCancelUserInform(IMUserInform imUserInform) throws Exception {
        imUserInform.setCANCELFLAG(true);
        CallResult callResult = null;
        callResult = this.isLocalMode() ? this.imUserInformDataCtrl.Save(false, (BaseDataEntity)imUserInform) : this.imRemoteUserInformDataCtrl.Save(false, imUserInform);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u53d6\u6d88\u7528\u6237\u901a\u77e5\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    protected IMMessagePackage OnGetLastVersion(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        return this.lastVersionPackage;
    }

    protected CallResult OnUserAuth(String strUserId, String strPassword) throws Exception {
        IMUser imUser = new IMUser();
        CallResult callResult = this.getIMModelHelper().GetIMUser(strUserId, imUser);
        if (callResult.IsOk()) {
            callResult.setUserObject((Object)imUser);
        }
        return callResult;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected IIMStateServerStub GetStateServer(IIMRemoteAction iIMRemoteAction) throws Exception {
        int nLastScore = 0;
        IIMStateServerStub iIMStateServerStub = null;
        Vector<IIMStateServerStub> vector = this.imStateServerStubList;
        synchronized (vector) {
            for (IIMStateServerStub serverStub : this.imStateServerStubList) {
                if (serverStub.isShuttingDown()) continue;
                if (iIMStateServerStub == null) {
                    iIMStateServerStub = serverStub;
                    nLastScore = iIMStateServerStub.CalcPriority(iIMRemoteAction);
                    continue;
                }
                int nCurScore = serverStub.CalcPriority(iIMRemoteAction);
                if (nCurScore <= nLastScore) continue;
                nLastScore = nCurScore;
                iIMStateServerStub = serverStub;
            }
        }
        if (iIMStateServerStub == null) {
            throw new Exception("\u6ca1\u6709\u53ef\u7528\u7684\u72b6\u6001\u670d\u52a1\u5668");
        }
        return iIMStateServerStub;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected IIMMeetingServerStub GetMeetingServer(IIMRemoteAction iIMRemoteAction) throws Exception {
        int nLastScore = 0;
        IIMMeetingServerStub iIMMeetingServerStub = null;
        Vector<IIMMeetingServerStub> vector = this.imMeetingServerStubList;
        synchronized (vector) {
            for (IIMMeetingServerStub serverStub : this.imMeetingServerStubList) {
                if (serverStub.isShuttingDown()) continue;
                if (iIMMeetingServerStub == null) {
                    iIMMeetingServerStub = serverStub;
                    nLastScore = iIMMeetingServerStub.CalcPriority(iIMRemoteAction);
                    continue;
                }
                int nCurScore = serverStub.CalcPriority(iIMRemoteAction);
                if (nCurScore <= nLastScore) continue;
                nLastScore = nCurScore;
                iIMMeetingServerStub = serverStub;
            }
        }
        if (iIMMeetingServerStub == null) {
            throw new Exception("\u6ca1\u6709\u53ef\u7528\u7684\u4f1a\u8bae\u670d\u52a1\u5668");
        }
        return iIMMeetingServerStub;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected IIMMeetingServerStub GetMeetingServer(String strServerId) throws Exception {
        Vector<IIMMeetingServerStub> vector = this.imMeetingServerStubList;
        synchronized (vector) {
            for (IIMMeetingServerStub iIMMeetingServerStub : this.imMeetingServerStubList) {
                if (StringHelper.Compare((String)iIMMeetingServerStub.getServerId(), (String)strServerId, (boolean)true) != 0) continue;
                return iIMMeetingServerStub;
            }
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7684\u4f1a\u8bae\u670d\u52a1\u5668[%1$s]", (Object)strServerId));
    }

    protected void OnCreateUserSession(IMUserSession imUserSession) throws Exception {
        BaseDEDataCtrl.SetCallParamCheckKey((BaseDataEntity)imUserSession, (boolean)false);
        BaseDEDataCtrl.SetCallParamDALog((BaseDataEntity)imUserSession, (boolean)false);
        CallResult callResult = null;
        if (this.isLocalMode()) {
            IDEDataCtrl userSessionDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl2("IM0071", "SYSTEM", null);
            callResult = userSessionDataCtrl.Save(true, (BaseDataEntity)imUserSession);
        } else {
            IMRemoteDEDataCtrl userSessionDataCtrl = new IMRemoteDEDataCtrl();
            userSessionDataCtrl.Init("", "IM0071", "SYSTEM");
            callResult = userSessionDataCtrl.Save(true, imUserSession);
        }
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58UserSession\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void AddRemoteActionToQueue(IMRemoteAction imRemoteActionContext, boolean bImmediately) {
        if (bImmediately) {
            Vector<IIMRemoteAction> vector = this.remoteActionQueue2;
            synchronized (vector) {
                imRemoteActionContext.setFromServer(true);
                this.remoteActionQueue2.add(imRemoteActionContext);
            }
        }
        Vector<IIMRemoteAction> vector = this.remoteActionQueue;
        synchronized (vector) {
            imRemoteActionContext.setFromServer(true);
            this.remoteActionQueue.add(imRemoteActionContext);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void OnDispatchRemoteAction() {
        Vector<IIMServerStub> serverList = new Vector<IIMServerStub>();
        block11: while (true) {
            IIMRemoteAction iIMRemoteAction = null;
            Vector<IIMRemoteAction> vector = this.remoteActionQueue2;
            synchronized (vector) {
                if (this.remoteActionQueue2.size() > 0) {
                    iIMRemoteAction = this.remoteActionQueue2.remove(0);
                }
            }
            if (iIMRemoteAction == null) {
                vector = this.remoteActionQueue;
                synchronized (vector) {
                    if (this.remoteActionQueue.size() > 0) {
                        iIMRemoteAction = this.remoteActionQueue.remove(0);
                    }
                }
            }
            if (iIMRemoteAction == null) break;
            serverList.clear();
            String strFromServerId = iIMRemoteAction.getParam("FROMSERVERID", "");
            Hashtable<String, IIMServerStub> hashtable = this.imServerStubMap;
            synchronized (hashtable) {
                for (String strKey : this.imServerStubMap.keySet()) {
                    if (StringHelper.Compare((String)strFromServerId, (String)strKey, (boolean)true) == 0) continue;
                    serverList.add(this.imServerStubMap.get(strKey));
                }
            }
            ((IMRemoteAction)iIMRemoteAction).setParam("SERVERID", this.getServerId());
            Iterator iterator = serverList.iterator();
            while (true) {
                if (!iterator.hasNext()) continue block11;
                IIMServerStub imServerStub = (IIMServerStub)iterator.next();
                if (imServerStub.isShuttingDown()) continue;
                try {
                    IMMessagePackage imMessagePackage = imServerStub.SendRemoteAction(iIMRemoteAction);
                    if (imMessagePackage.getRetCode() == 0) continue;
                    log.error((Object)StringHelper.Format((String)"\u5411\u670d\u52a1\u5668\u53d1\u9001\u8fdc\u7a0b\u64cd\u4f5c[%1$s]\u8fd4\u56de\u9519\u8bef\uff0c%2$s", (Object)iIMRemoteAction.getAction(), (Object)imMessagePackage.getRetCode()));
                }
                catch (Exception ex) {
                    log.error((Object)StringHelper.Format((String)"\u53d1\u9001\u8fdc\u7a0b\u64cd\u4f5c\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
                }
            }
        }
    }

    protected IMMessagePackage OnMeetingOpen(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMMeeting imMeeting = new IMMeeting();
        IIMMeetingServerStub iIMMeetingServerStub = null;
        Vector<String> participants = new Vector<String>();
        String strUserId = iIMRemoteActionContext.getParam("USERID", "");
        if (StringHelper.IsNullOrEmpty((String)strUserId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7528\u6237\u6807\u8bc6");
        }
        String strDisGroupId = iIMRemoteActionContext.getParam("DISGROUPID", "");
        if (!StringHelper.IsNullOrEmpty((String)strDisGroupId)) {
            imMeeting.setIMMEETINGID(strDisGroupId);
            this.OnGetMeeting(imMeeting);
        } else {
            participants.add(strUserId);
            int i = 2;
            while (i <= 10) {
                String strParamKey = StringHelper.Format((String)"%1$s%2$s", (Object)"USERID", (Object)i);
                String strUserIdTemp = iIMRemoteActionContext.getParam(strParamKey, "");
                if (!StringHelper.IsNullOrEmpty((String)strUserIdTemp)) {
                    participants.add(strUserIdTemp);
                }
                ++i;
            }
            imMeeting.setMEETINGTYPE(1);
            this.OnCreateMeeting(imMeeting, participants);
        }
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        imMessagePackage.setRetCode(0);
        if (!imMeeting.getCLOSEFLAG() && !StringHelper.IsNullOrEmpty((String)imMeeting.getIMMTSERVERID())) {
            try {
                iIMMeetingServerStub = this.GetMeetingServer(imMeeting.getIMMTSERVERID());
            }
            catch (Exception ex) {
                log.warn((Object)StringHelper.Format((String)"\u4f1a\u8bae\u670d\u52a1\u5668[%1$s]\u4e0d\u53ef\u7528", (Object)imMeeting.getIMMEETINGID()));
                iIMMeetingServerStub = this.GetMeetingServer(iIMRemoteActionContext);
            }
        } else {
            iIMMeetingServerStub = this.GetMeetingServer(iIMRemoteActionContext);
        }
        imMessagePackage.setExtInfo("MEETINGID", imMeeting.getIMMEETINGID());
        imMessagePackage.setExtInfo("MEETINGNAME", imMeeting.getIMMEETINGNAME());
        imMessagePackage.setExtInfo("MEETINGTYPE", imMeeting.getMEETINGTYPE());
        imMessagePackage.setExtInfo("SERVERPATH", iIMMeetingServerStub.getServerPath());
        imMessagePackage.setExtInfo("SERVERCOMETPATH", iIMMeetingServerStub.getServerCometPath());
        return imMessagePackage;
    }

    protected IMMessagePackage OnMeetingReopen(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        String strMeetingId = iIMRemoteActionContext.getParam("MEETINGID", "");
        if (StringHelper.IsNullOrEmpty((String)strMeetingId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u4f1a\u8bae\u6807\u8bc6");
        }
        IIMMeetingServerStub iIMMeetingServerStub = null;
        IMMeeting imMeeting = new IMMeeting();
        imMeeting.setIMMEETINGID(strMeetingId);
        this.OnGetMeeting(imMeeting);
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        imMessagePackage.setRetCode(0);
        if (!imMeeting.getCLOSEFLAG() && !StringHelper.IsNullOrEmpty((String)imMeeting.getIMMTSERVERID())) {
            try {
                iIMMeetingServerStub = this.GetMeetingServer(imMeeting.getIMMTSERVERID());
            }
            catch (Exception ex) {
                log.warn((Object)StringHelper.Format((String)"\u4f1a\u8bae\u670d\u52a1\u5668[%1$s]\u4e0d\u53ef\u7528", (Object)imMeeting.getIMMEETINGID()));
                iIMMeetingServerStub = this.GetMeetingServer(iIMRemoteActionContext);
            }
        } else {
            iIMMeetingServerStub = this.GetMeetingServer(iIMRemoteActionContext);
        }
        String strMeetingType = "1";
        if (!imMeeting.isMEETINGTYPENull()) {
            strMeetingType = StringHelper.Format((String)"%1$s", (Object)imMeeting.getMEETINGTYPE());
        }
        imMessagePackage.setExtInfo("MEETINGTYPE", strMeetingType);
        imMessagePackage.setExtInfo("MEETINGID", imMeeting.getIMMEETINGID());
        imMessagePackage.setExtInfo("MEETINGNAME", imMeeting.getIMMEETINGNAME());
        imMessagePackage.setExtInfo("SERVERPATH", iIMMeetingServerStub.getServerPath());
        imMessagePackage.setExtInfo("SERVERCOMETPATH", iIMMeetingServerStub.getServerCometPath());
        return imMessagePackage;
    }

    protected IMMessagePackage OnDisGroupInvite(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        if (iIMRemoteActionContext.isFromServer()) {
            IMRemoteAction imRemoteActionClone = new IMRemoteAction();
            imRemoteActionClone.FromRemoteAction(iIMRemoteActionContext);
            this.AddRemoteActionToQueue(imRemoteActionClone, true);
            IMMessagePackage imMessagePackage = new IMMessagePackage();
            imMessagePackage.setRetCode(0);
            return imMessagePackage;
        }
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        imMessagePackage.setRetCode(0);
        return imMessagePackage;
    }

    protected IMMessagePackage OnDisGroupQuit(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        if (iIMRemoteActionContext.isFromServer()) {
            IMRemoteAction imRemoteActionClone = new IMRemoteAction();
            imRemoteActionClone.FromRemoteAction(iIMRemoteActionContext);
            this.AddRemoteActionToQueue(imRemoteActionClone, true);
            IMMessagePackage imMessagePackage = new IMMessagePackage();
            imMessagePackage.setRetCode(0);
            return imMessagePackage;
        }
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        imMessagePackage.setRetCode(0);
        return imMessagePackage;
    }

    protected IMMessagePackage OnMeetingInvite(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        if (iIMRemoteActionContext.isFromServer()) {
            IMRemoteAction imRemoteActionClone = new IMRemoteAction();
            imRemoteActionClone.FromRemoteAction(iIMRemoteActionContext);
            this.AddRemoteActionToQueue(imRemoteActionClone, true);
            IMMessagePackage imMessagePackage = new IMMessagePackage();
            imMessagePackage.setRetCode(0);
            return imMessagePackage;
        }
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        imMessagePackage.setRetCode(0);
        return imMessagePackage;
    }

    protected IMMessagePackage OnMeetingKickedOut(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        if (iIMRemoteActionContext.isFromServer()) {
            IMRemoteAction imRemoteActionClone = new IMRemoteAction();
            imRemoteActionClone.FromRemoteAction(iIMRemoteActionContext);
            this.AddRemoteActionToQueue(imRemoteActionClone, true);
            IMMessagePackage imMessagePackage = new IMMessagePackage();
            imMessagePackage.setRetCode(0);
            return imMessagePackage;
        }
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        imMessagePackage.setRetCode(0);
        return imMessagePackage;
    }

    protected void OnCreateMeeting(IMMeeting imMeeting, Vector<String> participants) throws Exception {
        CallResult callResult;
        String strIMUserIds = "";
        if (participants.size() == 2) {
            String strUserId2;
            String strUserId = participants.get(0);
            strIMUserIds = StringHelper.Compare((String)strUserId, (String)(strUserId2 = participants.get(1)), (boolean)false) > 0 ? StringHelper.Format((String)"%1$s;%2$s", (Object)strUserId2, (Object)strUserId) : StringHelper.Format((String)"%1$s;%2$s", (Object)strUserId, (Object)strUserId2);
            IMMeeting imMeeting2 = new IMMeeting();
            callResult = this.getIMModelHelper().GetLastIMMeeting(strIMUserIds, imMeeting2);
            if (callResult.getRetCode() == 0) {
                imMeeting2.CopyTo(imMeeting, true);
                return;
            }
        } else {
            strIMUserIds = "NOTCALC";
        }
        imMeeting.setIMUSERIDS(strIMUserIds);
        if (this.isLocalMode()) {
            DefaultTransactionManager transactionManager = new DefaultTransactionManager();
            transactionManager.Init(this.getGlobalHelper());
            IDEDataCtrl meetingDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl2("IM0080", "SYSTEM", null);
            IDEDataCtrl participantDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl2("IM0081", "SYSTEM", null);
            transactionManager.Register(meetingDataCtrl);
            transactionManager.Register(participantDataCtrl);
            callResult = meetingDataCtrl.Save(true, (BaseDataEntity)imMeeting);
            if (callResult.IsError()) {
                transactionManager.Rollback();
                throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u4f1a\u8bae\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            for (String strParticipant : participants) {
                IMParticipant imParticipant = new IMParticipant();
                imParticipant.setIMMEETINGID(imMeeting.getIMMEETINGID());
                imParticipant.setIMUSERID(strParticipant);
                callResult = participantDataCtrl.Save(true, (BaseDataEntity)imParticipant);
                if (!callResult.IsError()) continue;
                transactionManager.Rollback();
                throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u4f1a\u8bae\u53c2\u4e0e\u4eba\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            transactionManager.Commit();
        } else {
            IMRemoteDEDataCtrl meetingDataCtrl = new IMRemoteDEDataCtrl();
            meetingDataCtrl.Init("", "IM0080", "SYSTEM");
            IMRemoteDEDataCtrl participantDataCtrl = new IMRemoteDEDataCtrl();
            participantDataCtrl.Init("", "IM0081", "SYSTEM");
            CallResult callResult2 = meetingDataCtrl.Save(true, imMeeting);
            if (callResult2.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u4f1a\u8bae\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult2.getErrorInfo()));
            }
            for (String strParticipant : participants) {
                IMParticipant imParticipant = new IMParticipant();
                imParticipant.setIMMEETINGID(imMeeting.getIMMEETINGID());
                imParticipant.setIMUSERID(strParticipant);
                callResult2 = participantDataCtrl.Save(true, imParticipant);
                if (!callResult2.IsError()) continue;
                throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u4f1a\u8bae\u53c2\u4e0e\u4eba\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult2.getErrorInfo()));
            }
        }
    }

    protected void OnGetMeeting(IMMeeting imMeeting) throws Exception {
        CallResult callResult = null;
        if (this.isLocalMode()) {
            IDEDataCtrl meetingDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl2("IM0080", "SYSTEM", null);
            callResult = meetingDataCtrl.Get((BaseDataEntity)imMeeting);
        } else {
            IMRemoteDEDataCtrl meetingDataCtrl = new IMRemoteDEDataCtrl();
            meetingDataCtrl.Init("", "IM0080", "SYSTEM");
            callResult = meetingDataCtrl.Get(imMeeting);
        }
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u4f1a\u8bae\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected IMMessagePackage OnMeetingFileUpload(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        String strUserId = iIMRemoteActionContext.getParam("USERID", "");
        String strFileName = iIMRemoteActionContext.getParam("FILENAME", "");
        IMFile imFile = new IMFile();
        imFile.setIMMEETINGID(iIMRemoteActionContext.getParam("IMMEETINGID", ""));
        imFile.setIMFILENAME(strFileName);
        imFile.setIMUSERID(strUserId);
        imFile.setIMMTSERVERID(iIMRemoteActionContext.getFromServerId());
        this.OnCreateFile(imFile);
        String uploadPassword = IMMTFtpUserManager.issueConfiguredUploadPassword(imFile.getIMFILEID());
        Hashtable<String, String> hashtable = this.fileNameMap;
        synchronized (hashtable) {
            this.fileNameMap.put(imFile.getIMFILEID(), strFileName);
        }
        imMessagePackage.setExtInfo("FILEID", imFile.getIMFILEID());
        imMessagePackage.setExtInfo("SERVERPATH", this.imCatalogServer.getFTPSERVERPATH());
        imMessagePackage.setExtInfo("LOGINNAME", imFile.getIMFILEID());
        imMessagePackage.setExtInfo("PASSWORD", uploadPassword);
        imMessagePackage.setExtInfo("FILENAME", imFile.getIMFILENAME());
        return imMessagePackage;
    }

    protected void OnCreateFile(IMFile imFile) throws Exception {
        Date date = new Date();
        if (StringHelper.IsNullOrEmpty((String)imFile.getIMFILEID())) {
            imFile.setIMFILEID(Helper.GenGuidEx());
        }
        imFile.SetParamValue("SENDTIME", new Timestamp(date.getTime()));
        if (this.isLocalMode()) {
            IDEDataCtrl imFileDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl2("IM0090", "SYSTEM", null);
            CallResult result = imFileDataCtrl.Save(true, imFile);
            if (result.IsError()) {
                throw new Exception(result.getErrorInfo());
            }
        } else {
            IMRemoteDEDataCtrl imFileDataCtrl = new IMRemoteDEDataCtrl();
            imFileDataCtrl.Init("", "IM0090", "SYSTEM");
            CallResult result = imFileDataCtrl.Save(true, imFile);
            if (result.IsError()) {
                throw new Exception(result.getErrorInfo());
            }
        }
        IMUserFile imUserFile = new IMUserFile();
        imUserFile.setIMFILEID(StringHelper.Format((String)"%1$s_%2$s", (Object)imFile.getIMFILEID(), (Object)imFile.getIMUSERID()));
        imUserFile.setSENDERFLAG(true);
        imUserFile.setIMFILEID(imFile.getIMFILEID());
        imUserFile.setIMUSERID(imFile.getIMUSERID());
        if (this.isLocalMode()) {
            IDEDataCtrl imUserFileDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl2("IM0091", "SYSTEM", null);
            CallResult result = imUserFileDataCtrl.Save(true, (BaseDataEntity)imUserFile);
            if (result.IsError()) {
                throw new Exception(result.getErrorInfo());
            }
        } else {
            IMRemoteDEDataCtrl imFileDataCtrl2 = new IMRemoteDEDataCtrl();
            imFileDataCtrl2.Init("", "IM0091", "SYSTEM");
            CallResult result = imFileDataCtrl2.Save(true, imUserFile);
            if (result.IsError()) {
                throw new Exception(result.getErrorInfo());
            }
        }
    }

    protected IMMessagePackage OnMeetingFileUploaded(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMMTFtpUserManager.revokeConfiguredUploadPassword(iIMRemoteActionContext.getParam("FILEID", ""));
        return new IMMessagePackage();
    }

    protected IMMessagePackage OnGetServerStatus(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMMessagePackage iMMessagePackage = new IMMessagePackage();
        StringBuilderEx stringBuilder = new StringBuilderEx();
        for (IIMServerStub iIMServerStub : this.imServerStubMap.values()) {
            String strStatus = iIMServerStub.getServerStatus();
            String strInfo = StringHelper.Format((String)"\u670d\u52a1\u5668[%1$s]:%2$s\r\n", (Object)iIMServerStub.getServerId(), (Object)strStatus);
            stringBuilder.Append(strInfo);
        }
        iMMessagePackage.setExtInfo("info", stringBuilder.toString());
        return iMMessagePackage;
    }

    @Override
    protected void OnShutdownServer() throws Exception {
        this.dispatchMessageThread.setStopFlag();
        while (this.dispatchMessageThread.isAlive()) {
            Thread.sleep(100L);
        }
        this.StopStunServer();
        this.ShutdownFtpServer();
        IMServerLog imServerLog = new IMServerLog();
        imServerLog.setIMSERVERID(this.getServerId());
        imServerLog.setLOGINFO("\u670d\u52a1\u5668\u5173\u95ed");
        if (this.isLocalMode()) {
            this.imServerLogDataCtrl.Save(true, (BaseDataEntity)imServerLog);
        } else {
            this.imServerLogRemoteDataCtrl.Save(true, imServerLog);
        }
        this.imUserInformDataCtrl = null;
        this.imRemoteUserInformDataCtrl = null;
        this.bGetEnableUserInform = false;
        this.imServerLogDataCtrl = null;
        this.imServerLogRemoteDataCtrl = null;
        super.OnShutdownServer();
    }

    @Override
    protected void OnStartServer() throws Exception {
        super.OnStartServer();
        if (this.isEnableUserInform()) {
            if (this.isLocalMode()) {
                this.imUserInformDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl2("IM0085", "SYSTEM", null);
            } else {
                this.imRemoteUserInformDataCtrl = new IMRemoteDEDataCtrl();
                this.imRemoteUserInformDataCtrl.Init("", "IM0085", "SYSTEM");
            }
        }
        IMServerLog imServerLog = new IMServerLog();
        imServerLog.setIMSERVERID(this.getServerId());
        imServerLog.setLOGINFO("\u670d\u52a1\u5668\u767b\u5165");
        if (this.isLocalMode()) {
            this.imServerLogDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl2("IM0022", "SYSTEM", null);
            this.imServerLogDataCtrl.Save(true, (BaseDataEntity)imServerLog);
        } else {
            this.imServerLogRemoteDataCtrl = new IMRemoteDEDataCtrl();
            this.imServerLogRemoteDataCtrl.Init("", "IM0022", "SYSTEM");
            this.imServerLogRemoteDataCtrl.Save(true, imServerLog);
        }
        CallResult callResult = this.getIMModelHelper().ResetIMUserOnlineState();
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u91cd\u7f6e\u7528\u6237\u5728\u7ebf\u72b6\u6001\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        this.RefreshVersions();
        this.RefreshOrgTrees(true);
        this.StartStunServer();
        this.StartFtpServer();
        this.dispatchMessageThread.start();
    }

    protected boolean isEnableUserInform() {
        if (!this.bGetEnableUserInform) {
            this.bEnableUserInform = this.OnGetEnableUserInform();
            this.bGetEnableUserInform = true;
        }
        return this.bEnableUserInform;
    }

    protected boolean OnGetEnableUserInform() {
        return true;
    }

    protected void StartStunServer() throws Exception {
        if (this.imStunServer != null) {
            return;
        }
        this.strStunServerPath = this.imCatalogServer.getSTUNSERVERPATH();
        if (this.imCatalogServer.getSTARTSTUNSERVER()) {
            this.imStunServer = new IMStunServer(this.imCatalogServer.getSTUNPORT(), InetAddress.getByName(this.imCatalogServer.getSTUNIP()), this.imCatalogServer.getSTUNPORT2(), InetAddress.getByName(this.imCatalogServer.getSTUNIP2()));
            this.imStunServer.Start();
            if (StringHelper.IsNullOrEmpty((String)this.strStunServerPath)) {
                this.strStunServerPath = StringHelper.Format((String)"STUN %1$s:%2$s", (Object)this.imCatalogServer.getSTUNIP(), (Object)this.imCatalogServer.getSTUNPORT());
            }
        }
    }

    protected void StopStunServer() throws Exception {
        if (this.imStunServer == null) {
            return;
        }
        this.imStunServer.Stop();
        this.imStunServer = null;
    }

    @Override
    protected void OnServerTimer() {
        super.OnServerTimer();
        this.RefreshVersions();
        this.RefreshOrgTrees(false);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void RefreshVersions() {
        Date curDate = new Date();
        if (this.lastRefreshVersionDate != null && curDate.getTime() - this.lastRefreshVersionDate.getTime() < 300000L) {
            return;
        }
        try {
            Vector<IMVersion> imVersions = new Vector<IMVersion>();
            CallResult callResult = this.getIMModelHelper().GetValidIMVersions(imVersions);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u6709\u6548\u7248\u672c\u4fe1\u606f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            Hashtable<String, IMVersion> hashtable = this.supportIMVersionMap;
            synchronized (hashtable) {
                this.supportIMVersionMap.clear();
                for (IMVersion imVersion : imVersions) {
                    this.supportIMVersionMap.put(imVersion.getIMVERSIONNAME(), imVersion);
                }
                if (imVersions.size() > 0 && imVersions.get(0).getINTERNALVER() != this.lastVersion.getINTERNALVER()) {
                    imVersions.get(0).CopyTo(this.lastVersion, true);
                    IMMessagePackage lastVersionPackage = new IMMessagePackage();
                    lastVersionPackage.setExtInfo("version", this.lastVersion.getIMVERSIONNAME());
                    lastVersionPackage.setExtInfo("caption", this.lastVersion.getCAPTION());
                    lastVersionPackage.setExtInfo("installurl", this.lastVersion.getINSTALLPATH());
                    lastVersionPackage.setExtInfo("description", this.lastVersion.getDESCRIPTION());
                    this.lastVersionPackage = lastVersionPackage;
                }
            }
            this.lastRefreshVersionDate = curDate;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5237\u65b0\u542f\u7528\u7684\u4ea7\u54c1\u7248\u672c\u4fe1\u606f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void RefreshOrgTrees(boolean bFirst) {
        Date curDate = new Date();
        if (this.lastRefreshOrgDate != null && curDate.getTime() - this.lastRefreshOrgDate.getTime() < 30000L) {
            return;
        }
        try {
            Vector<IMOrgTree> imOrgTrees = new Vector<IMOrgTree>();
            CallResult callResult = this.getIMModelHelper().GetIMOrgTrees(imOrgTrees);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7ec4\u7ec7\u6811\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            ArrayList<IMOrgTree> changedList = new ArrayList<IMOrgTree>();
            Hashtable<String, IMOrgTree> hashtable = this.imOrgTreeMap;
            synchronized (hashtable) {
                if (bFirst) {
                    this.imOrgTreeMap.clear();
                    for (IMOrgTree imOrgTree : imOrgTrees) {
                        this.imOrgTreeMap.put(imOrgTree.getIMORGTREEID(), imOrgTree);
                    }
                } else {
                    for (IMOrgTree imOrgTree : imOrgTrees) {
                        IMOrgTree imOrgTreeLast = this.imOrgTreeMap.get(imOrgTree.getIMORGTREEID());
                        if (imOrgTreeLast != null && imOrgTree.getVERSION() == imOrgTreeLast.getVERSION()) continue;
                        changedList.add(imOrgTree);
                        this.imOrgTreeMap.put(imOrgTree.getIMORGTREEID(), imOrgTree);
                    }
                }
            }
            this.lastRefreshOrgDate = curDate;
            for (IMOrgTree imOrgTree : changedList) {
                IMInformMessage imInformMessage = new IMInformMessage();
                imInformMessage.setMsgTargetType(1);
                imInformMessage.setMessageType(1008);
                imInformMessage.setParam(imOrgTree.getIMORGTREEID());
                imInformMessage.setParam2(StringHelper.Format((String)"%1$s", (Object)imOrgTree.getVERSION()));
                this.SendInformMessage(imInformMessage, false);
            }
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5237\u65b0\u7ec4\u7ec7\u6811\u4fe1\u606f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
        }
    }

    protected void StartFtpServer() throws Exception {
        if (this.imCatalogServer.isENABLEFTPSERVERNull() || !this.imCatalogServer.getENABLEFTPSERVER()) {
            return;
        }
        if (this.ftpServer != null) {
            return;
        }
        FtpServerFactory serverFactory = new FtpServerFactory();
        ListenerFactory factory = new ListenerFactory();
        int nPort = 2221;
        if (!this.imCatalogServer.isFTPPORTNull()) {
            nPort = this.imCatalogServer.getFTPPORT();
        }
        DataConnectionConfigurationFactory dataConnectionConfigurationFactory = new DataConnectionConfigurationFactory();
        if (!this.imCatalogServer.isFTPPASSIVEADDRNull()) {
            dataConnectionConfigurationFactory.setPassiveAddress(this.imCatalogServer.getFTPPASSIVEADDR());
        }
        if (!this.imCatalogServer.isFTPPASSIVEPORTNull()) {
            dataConnectionConfigurationFactory.setPassivePorts(this.imCatalogServer.getFTPPASSIVEPORT());
        }
        factory.setDataConnectionConfiguration(dataConnectionConfigurationFactory.createDataConnectionConfiguration());
        factory.setPort(nPort);
        serverFactory.addListener("default", factory.createListener());
        IMMTFtpUserManager imMTFtpUserManager = IMMTFtpUserManager.fromConfiguredCredentials();
        imMTFtpUserManager.setRootFolder(this.imCatalogServer.getFTPROOT());
        serverFactory.setUserManager((UserManager)imMTFtpUserManager);
        this.ftpServer = serverFactory.createServer();
        this.ftpServer.start();
    }

    protected void ShutdownFtpServer() throws Exception {
        if (this.ftpServer == null) {
            return;
        }
        this.ftpServer.stop();
        this.ftpServer = null;
    }

    protected void UpdateUserIcon(IMUser imUser, String strFileExt, String strFileContent) throws Exception {
        byte[] content = Base64.decode((String)strFileContent);
        String strFileName = String.valueOf(Helper.GenGuidEx()) + strFileExt;
        String strTotalFileName = this.getUserIconFolder();
        strTotalFileName = String.valueOf(strTotalFileName) + imUser.getIMUSERID();
        File file = new File(strTotalFileName = String.valueOf(strTotalFileName) + File.separator);
        if (!file.exists()) {
            file.mkdirs();
        }
        strTotalFileName = String.valueOf(strTotalFileName) + strFileName;
        FileOutputStream out = new FileOutputStream(new File(strTotalFileName));
        ((OutputStream)out).write(content);
        ((OutputStream)out).close();
        imUser.setICONPATH(strFileName);
        CallResult callResult = null;
        if (this.isLocalMode()) {
            IDEDataCtrl userDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl2("IM0070", "SYSTEM", null);
            callResult = userDataCtrl.Save(false, (BaseDataEntity)imUser);
        } else {
            IMRemoteDEDataCtrl userRemoteDataCtrl = new IMRemoteDEDataCtrl();
            userRemoteDataCtrl.Init("", "IM0070", "SYSTEM");
            callResult = userRemoteDataCtrl.Save(false, imUser);
        }
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u66f4\u65b0\u7528\u6237\u56fe\u6807\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    protected String getUserIconFolder() {
        return String.valueOf(this.getGlobalHelper().GetAppRootPath()) + "imicons" + File.separator;
    }

    protected void SendInformMessage(IMInformMessage imInformMessage, boolean bImmediately) throws Exception {
        JSONObject jo = new JSONObject();
        imInformMessage.toJSONObject(jo);
        IMRemoteAction imRemoteActionClone = new IMRemoteAction();
        imRemoteActionClone.setAction("SENDINFORMMESSAGE");
        imRemoteActionClone.setParam("MSGTYPE", "SYS");
        switch (imInformMessage.getMsgTargetType()) {
            case 1: {
                imRemoteActionClone.setParam("RECEIVERTYPE", "ALL");
                break;
            }
            case 2: {
                imRemoteActionClone.setParam("RECEIVERTYPE", "USER");
                imRemoteActionClone.setParam("RECEIVER", imInformMessage.getMsgTarget());
            }
        }
        imRemoteActionClone.setContent(jo.toString());
        this.AddRemoteActionToQueue(imRemoteActionClone, bImmediately);
    }

    protected void SendUserInformMessage(IMUserInformMessage imUserInformMessage, boolean bImmediately) throws Exception {
        JSONObject jo = new JSONObject();
        imUserInformMessage.toJSONObject(jo);
        IMRemoteAction imRemoteActionClone = new IMRemoteAction();
        imRemoteActionClone.setAction("SENDINFORMMESSAGE");
        imRemoteActionClone.setParam("MSGTYPE", "USER");
        switch (imUserInformMessage.getMsgTargetType()) {
            case 1: {
                imRemoteActionClone.setParam("RECEIVERTYPE", "ALL");
                break;
            }
            case 2: {
                imRemoteActionClone.setParam("RECEIVERTYPE", "USER");
                imRemoteActionClone.setParam("RECEIVER", imUserInformMessage.getMsgTarget());
            }
        }
        imRemoteActionClone.setContent(jo.toString());
        this.AddRemoteActionToQueue(imRemoteActionClone, bImmediately);
    }

    private class DispatchMessageThread
    extends Thread {
        protected boolean bStopFlag = false;

        private DispatchMessageThread() {
        }

        public void setStopFlag() {
            this.bStopFlag = true;
        }

        @Override
        public void run() {
            while (!this.bStopFlag) {
                try {
                    IMCatalogServerInstance.this.OnDispatchRemoteAction();
                    Thread.sleep(50L);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
