/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Base64
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.IM.Ctrl;

import SA.IM.Ctrl.DEDataCtrl.IMRemoteDEDataCtrl;
import SA.IM.Ctrl.Data.IMUser;
import SA.IM.Ctrl.Data.IMUserSession;
import SA.IM.Ctrl.IIMCometEvent;
import SA.IM.Ctrl.IIMRemoteAction;
import SA.IM.Ctrl.IIMStateServerContext;
import SA.IM.Ctrl.IIMStateServerInstance;
import SA.IM.Ctrl.IIMUserSessionInstance;
import SA.IM.Ctrl.IMException;
import SA.IM.Ctrl.IMFuncServerInstance;
import SA.IM.Ctrl.IMMessageBase;
import SA.IM.Ctrl.IMMessagePackage;
import SA.IM.Ctrl.IMRemoteAction;
import SA.IM.Ctrl.IMUserSessionInstance;
import SA.IM.Ctrl.Message.IMInformMessage;
import SA.IM.Ctrl.Message.IMUserInformMessage;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Base64;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Hashtable;
import java.util.Vector;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IMStateServerInstance
extends IMFuncServerInstance
implements IIMStateServerInstance,
IIMStateServerContext {
    private static final Log log = LogFactory.getLog(IMStateServerInstance.class);
    protected Hashtable<String, IMUser> imUserMap = null;
    protected Hashtable<String, IIMUserSessionInstance> imUserSessionInstanceMap = new Hashtable();
    protected Vector<IMMessageBase> imMessageList = new Vector();
    protected Vector<IMMessageBase> imMessageList2 = new Vector();
    private Vector<WorkThread> workThreads = new Vector();

    @Override
    protected IMMessagePackage OnProcessRemoteAction(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"USERSESSIONLOGIN", (boolean)true) == 0) {
            return this.OnUserSessionLogin(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"USERSESSIONLOGOUT", (boolean)true) == 0) {
            return this.OnUserSessionLogout(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"USERINFOSYNC", (boolean)true) == 0) {
            return this.OnUserInfoSync(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"USERICONSYNC", (boolean)true) == 0) {
            return this.OnUserIconSync(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"USERRESETRECENT", (boolean)true) == 0) {
            return this.OnUserResetRecentFromTime(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"USERFULLINFOSYNC", (boolean)true) == 0) {
            return this.OnUserFullInfoSync(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"SENDINFORMMESSAGE", (boolean)true) == 0) {
            return this.OnSendInformMessage(iIMRemoteActionContext);
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
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"USERGROUPCREATE", (boolean)true) == 0 || StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"USERGROUPREMOVE", (boolean)true) == 0 || StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"USERGROUPRENAME", (boolean)true) == 0 || StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"USERGROUPDETAILCREATE", (boolean)true) == 0 || StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"USERGROUPDETAILREMOVE", (boolean)true) == 0 || StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"USERGROUPREORDER", (boolean)true) == 0 || StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"USERGROUPDETAILREORDER", (boolean)true) == 0 || StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"USERGROUPRESET", (boolean)true) == 0) {
            return this.OnUserGroupAction(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"DISGROUPCREATE", (boolean)true) == 0 || StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"DISGROUPREMOVE", (boolean)true) == 0 || StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"DISGROUPRENAME", (boolean)true) == 0 || StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"DISGROUPDETAILCREATE", (boolean)true) == 0 || StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"DISGROUPDETAILREMOVE", (boolean)true) == 0 || StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"DISGROUPREORDER", (boolean)true) == 0 || StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"DISGROUPDETAILREORDER", (boolean)true) == 0) {
            return this.OnDisGroupAction(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"DISGROUPINVITE", (boolean)true) == 0) {
            return this.OnDisGroupInvite(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"DISGROUPQUIT", (boolean)true) == 0) {
            return this.OnDisGroupQuit(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"USERDISGROUPLIST", (boolean)true) == 0) {
            return this.OnUserDisGroupList(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"USERINFORM", (boolean)true) == 0) {
            return this.OnUserInform(iIMRemoteActionContext);
        }
        return super.OnProcessRemoteAction(iIMRemoteActionContext);
    }

    protected IMMessagePackage OnUserGroupAction(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        String strUserSessionId = iIMRemoteActionContext.getParam("USERSESSIONID", "");
        String strUserId = iIMRemoteActionContext.getParam("USERID", "");
        IIMUserSessionInstance iIMUserSessionInstance = this.GetUserSessionInstance(strUserId, strUserSessionId);
        return iIMUserSessionInstance.ProcessRemoteAction(iIMRemoteActionContext);
    }

    protected IMMessagePackage OnDisGroupAction(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        String strUserSessionId = iIMRemoteActionContext.getParam("USERSESSIONID", "");
        String strUserId = iIMRemoteActionContext.getParam("USERID", "");
        IIMUserSessionInstance iIMUserSessionInstance = this.GetUserSessionInstance(strUserId, strUserSessionId);
        return iIMUserSessionInstance.ProcessRemoteAction(iIMRemoteActionContext);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected IMMessagePackage OnUserSessionLogin(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMUser imUser;
        if (!iIMRemoteActionContext.isFromServer()) {
            IMUser imUser2;
            String strUserSessionId = iIMRemoteActionContext.getParam("USERSESSIONID", "");
            IMUserSession imUserSession = new IMUserSession();
            CallResult callResult = this.getIMModelHelper().GetIMUserSession(strUserSessionId, imUserSession);
            if (callResult.IsError()) {
                if (callResult.getRetCode() == 3 || callResult.getRetCode() == 1003) {
                    throw new IMException(10001);
                }
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u7528\u6237\u4f1a\u8bdd\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            if (!imUserSession.isLOGINTIMENull()) {
                log.error((Object)StringHelper.Format((String)"\u6307\u5b9a\u7684\u4f1a\u8bdd\u5df2\u7ecf\u5931\u6548"));
                throw new IMException(10001, "\u6307\u5b9a\u7684\u4f1a\u8bdd\u5df2\u7ecf\u5931\u6548");
            }
            this.UpdateUserSessionState(imUserSession, true);
            IIMUserSessionInstance imUserSessionInstance = this.OnCreateUserSessionInstance(imUserSession);
            IIMUserSessionInstance imUserSessionLast2 = null;
            Hashtable<String, IIMUserSessionInstance> hashtable = this.imUserSessionInstanceMap;
            synchronized (hashtable) {
                imUserSessionLast2 = this.imUserSessionInstanceMap.get(imUserSessionInstance.getUserId());
                this.imUserSessionInstanceMap.put(imUserSessionInstance.getUserId(), imUserSessionInstance);
            }
            if (imUserSessionLast2 != null) {
                IMUserSession imUserSessionClone = new IMUserSession();
                imUserSessionClone.setIMUSERSESSIONID(imUserSessionLast2.getUserSessionId());
                this.UpdateUserSessionState(imUserSessionClone, false);
                imUserSessionLast2.Close();
            }
            IMUser iMUser = imUser2 = this.GetUser(imUserSession.getIMUSERID());
            synchronized (iMUser) {
                imUser2.setONLINEFLAG(true);
                imUser2.setIMUSERSESSIONID(strUserSessionId);
                imUser2.setONLINESTATE(imUserSession.GetParamStringValue("ONLINESTATE", ""));
                imUser2.setNICKNAME(imUserSession.GetParamStringValue("NICKNAME", ""));
                imUser2.setUSERINFO(imUserSession.GetParamStringValue("USERINFO", ""));
                imUser2.setICONPATH(imUserSession.GetParamStringValue("ICONPATH", ""));
            }
            IMRemoteAction serverActionContext = new IMRemoteAction();
            serverActionContext.setAction("USERSESSIONLOGIN");
            serverActionContext.setParam("USERID", imUserSessionInstance.getUserId());
            serverActionContext.setParam("USERSESSIONID", imUserSessionInstance.getUserSessionId());
            serverActionContext.setParam("ONLINESTATE", imUserSession.GetParamStringValue("ONLINESTATE", ""));
            serverActionContext.setParam("ONLINESTATEINFO", imUserSession.GetParamStringValue("ONLINESTATEINFO", ""));
            serverActionContext.setParam("NICKNAME", imUserSession.GetParamStringValue("NICKNAME", ""));
            serverActionContext.setParam("USERINFO", imUserSession.GetParamStringValue("USERINFO", ""));
            serverActionContext.setParam("USERICON", imUserSession.GetParamStringValue("ICONPATH", ""));
            this.AddRemoteActionToQueue(serverActionContext);
            IMInformMessage imInformMessage = new IMInformMessage();
            imInformMessage.setMessageType(1000);
            imInformMessage.setUserId(imUserSessionInstance.getUserId());
            imInformMessage.setOnlineState(imUserSession.GetParamStringValue("ONLINESTATE", ""));
            imInformMessage.setOnlineStateInfo(imUserSession.GetParamStringValue("ONLINESTATEINFO", ""));
            imInformMessage.setNickName(imUserSession.GetParamStringValue("NICKNAME", ""));
            imInformMessage.setUserInfo(imUserSession.GetParamStringValue("USERINFO", ""));
            imInformMessage.setUserIcon(imUserSession.GetParamStringValue("ICONPATH", ""));
            imInformMessage.setMsgTargetType(3);
            imInformMessage.setMsgTarget(imUserSessionInstance.getUserId());
            imInformMessage.setIMDomain(imUser2.getIMDOMAIN());
            this.AddMessageToQueue(imInformMessage, false);
            return imUserSessionInstance.ProcessRemoteAction(iIMRemoteActionContext);
        }
        String strUserId = iIMRemoteActionContext.getParam("USERID", "");
        String strUserSessionId = iIMRemoteActionContext.getParam("USERSESSIONID", "");
        IIMUserSessionInstance imUserSessionLast = null;
        Hashtable<String, IIMUserSessionInstance> imUserSessionInstance = this.imUserSessionInstanceMap;
        synchronized (imUserSessionInstance) {
            imUserSessionLast = this.imUserSessionInstanceMap.get(strUserId);
            if (imUserSessionLast != null) {
                if (StringHelper.Compare((String)imUserSessionLast.getUserSessionId(), (String)strUserSessionId, (boolean)true) != 0) {
                    this.imUserSessionInstanceMap.remove(strUserId);
                } else {
                    imUserSessionLast = null;
                }
            }
        }
        if (imUserSessionLast != null) {
            IMUserSession imUserSessionClone = new IMUserSession();
            imUserSessionClone.setIMUSERSESSIONID(imUserSessionLast.getUserSessionId());
            this.UpdateUserSessionState(imUserSessionClone, false);
            imUserSessionLast.Close();
        }
        IMUser imUserSessionLast2 = imUser = this.GetUser(strUserId);
        synchronized (imUserSessionLast2) {
            imUser.setONLINEFLAG(true);
            imUser.setIMUSERSESSIONID(strUserSessionId);
            imUser.setONLINESTATE(iIMRemoteActionContext.getParam("ONLINESTATE", ""));
            imUser.setONLINESTATEINFO(iIMRemoteActionContext.getParam("ONLINESTATEINFO", ""));
            imUser.setNICKNAME(iIMRemoteActionContext.getParam("NICKNAME", ""));
            imUser.setUSERINFO(iIMRemoteActionContext.getParam("USERINFO", ""));
            imUser.setICONPATH(iIMRemoteActionContext.getParam("USERICON", ""));
        }
        IMInformMessage imInformMessage = new IMInformMessage();
        imInformMessage.setMessageType(1000);
        imInformMessage.setUserId(strUserId);
        imInformMessage.setOnlineState(iIMRemoteActionContext.getParam("ONLINESTATE", ""));
        imInformMessage.setOnlineStateInfo(iIMRemoteActionContext.getParam("ONLINESTATEINFO", ""));
        imInformMessage.setNickName(iIMRemoteActionContext.getParam("NICKNAME", ""));
        imInformMessage.setUserInfo(iIMRemoteActionContext.getParam("USERINFO", ""));
        imInformMessage.setUserIcon(iIMRemoteActionContext.getParam("USERICON", ""));
        imInformMessage.setMsgTargetType(3);
        imInformMessage.setMsgTarget(strUserId);
        imInformMessage.setIMDomain(imUser.getIMDOMAIN());
        this.AddMessageToQueue(imInformMessage, false);
        return new IMMessagePackage();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected IMMessagePackage OnUserInfoSync(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMUser imUser;
        if (!iIMRemoteActionContext.isFromServer()) {
            IMUser imUser2;
            String strUserSessionId = iIMRemoteActionContext.getParam("USERSESSIONID", "");
            String strUserId = iIMRemoteActionContext.getParam("USERID", "");
            IIMUserSessionInstance imUserSessionInstance = this.GetUserSessionInstance(strUserId, strUserSessionId);
            boolean bNoUpdate = false;
            String strNoUpdate = iIMRemoteActionContext.getParam("NOUPDATE", "");
            if (!StringHelper.IsNullOrEmpty((String)strNoUpdate)) {
                bNoUpdate = StringHelper.Compare((String)strNoUpdate, (String)"TRUE", (boolean)true) == 0;
            }
            String strOnlineState = iIMRemoteActionContext.getParam("ONLINESTATE", "");
            String strOnlineStateInfo = iIMRemoteActionContext.getParam("ONLINESTATEINFO", "");
            String strNickName2 = iIMRemoteActionContext.getParam("NICKNAME", "");
            String strUserInfo = iIMRemoteActionContext.getParam("USERINFO", "");
            IMUser imUser3 = new IMUser();
            imUser3.setIMUSERID(imUserSessionInstance.getUserId());
            if (bNoUpdate) {
                IMUser iMUser = imUser3 = this.GetUser(imUserSessionInstance.getUserId());
                synchronized (iMUser) {
                    imUser3.setONLINESTATE(strOnlineState);
                    imUser3.setONLINESTATEINFO(strOnlineStateInfo);
                }
            }
            imUser3.setUSERINFO(strUserInfo);
            imUser3.setNICKNAME(strNickName2);
            imUser3.setONLINESTATE(strOnlineState);
            imUser3.setONLINESTATEINFO(strOnlineStateInfo);
            this.UpdateUserInfo(imUser3);
            IMUser iMUser = imUser2 = this.GetUser(imUserSessionInstance.getUserId());
            synchronized (iMUser) {
                imUser2.setUSERINFO(imUser3.getUSERINFO());
                imUser2.setNICKNAME(imUser3.getNICKNAME());
                imUser2.setONLINESTATE(imUser3.getONLINESTATE());
            }
            IMRemoteAction serverActionContext = new IMRemoteAction();
            serverActionContext.setAction("USERINFOSYNC");
            serverActionContext.setParam("USERID", imUserSessionInstance.getUserId());
            serverActionContext.setParam("ONLINESTATE", imUser3.getONLINESTATE());
            serverActionContext.setParam("ONLINESTATEINFO", imUser3.getONLINESTATEINFO());
            serverActionContext.setParam("USERINFO", imUser3.getUSERINFO());
            serverActionContext.setParam("NICKNAME", imUser3.getNICKNAME());
            serverActionContext.setParam("USERICON", imUser3.getICONPATH());
            this.AddRemoteActionToQueue(serverActionContext);
            IMInformMessage imInformMessage = new IMInformMessage();
            imInformMessage.setMessageType(1002);
            imInformMessage.setOnlineState(imUser3.getONLINESTATE());
            imInformMessage.setOnlineStateInfo(imUser3.getONLINESTATEINFO());
            imInformMessage.setNickName(imUser3.getNICKNAME());
            imInformMessage.setUserInfo(imUser3.getUSERINFO());
            imInformMessage.setUserId(strUserId);
            imInformMessage.setUserIcon(imUser3.getICONPATH());
            imInformMessage.setMsgTargetType(3);
            imInformMessage.setMsgTarget(strUserId);
            imInformMessage.setIMDomain(imUser3.getIMDOMAIN());
            this.AddMessageToQueue(imInformMessage, false);
            return imUserSessionInstance.ProcessRemoteAction(iIMRemoteActionContext);
        }
        String strUserId = iIMRemoteActionContext.getParam("USERID", "");
        String strOnlineState = iIMRemoteActionContext.getParam("ONLINESTATE", "");
        String strOnlineStateInfo = iIMRemoteActionContext.getParam("ONLINESTATEINFO", "");
        String strNickName = iIMRemoteActionContext.getParam("NICKNAME", "");
        String strUserInfo = iIMRemoteActionContext.getParam("USERINFO", "");
        String strUserIcon = iIMRemoteActionContext.getParam("USERICON", "");
        IMUser strNickName2 = imUser = this.GetUser(strUserId);
        synchronized (strNickName2) {
            imUser.setONLINESTATE(strOnlineState);
            imUser.setONLINESTATEINFO(strOnlineStateInfo);
            imUser.setNICKNAME(strNickName);
            imUser.setUSERINFO(strUserInfo);
            imUser.setICONPATH(strUserIcon);
        }
        IMInformMessage imInformMessage = new IMInformMessage();
        imInformMessage.setMessageType(1002);
        imInformMessage.setOnlineState(strOnlineState);
        imInformMessage.setOnlineStateInfo(strOnlineStateInfo);
        imInformMessage.setNickName(strNickName);
        imInformMessage.setUserInfo(strUserInfo);
        imInformMessage.setUserId(strUserId);
        imInformMessage.setUserIcon(strUserIcon);
        imInformMessage.setMsgTargetType(3);
        imInformMessage.setMsgTarget(strUserId);
        imInformMessage.setIMDomain(imUser.getIMDOMAIN());
        this.AddMessageToQueue(imInformMessage, false);
        return new IMMessagePackage();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected IMMessagePackage OnUserFullInfoSync(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMUser imUser;
        if (!iIMRemoteActionContext.isFromServer()) {
            IMUser imUser2;
            String strUserSessionId = iIMRemoteActionContext.getParam("USERSESSIONID", "");
            String strUserId = iIMRemoteActionContext.getParam("USERID", "");
            IIMUserSessionInstance imUserSessionInstance = this.GetUserSessionInstance(strUserId, strUserSessionId);
            String strContent = iIMRemoteActionContext.getContent();
            if (StringHelper.IsNullOrEmpty((String)strContent)) {
                return new IMMessagePackage();
            }
            byte[] orgData2 = strContent.getBytes();
            strContent = new String(orgData2, "UTF8");
            JSONObject jo = JSONObject.fromString((String)strContent);
            IMUser imUser3 = new IMUser();
            imUser3 = (IMUser)BaseDataEntity.FromJSONObject((BaseDataEntity)imUser3, (JSONObject)jo);
            imUser3.setIMUSERID(imUserSessionInstance.getUserId());
            this.UpdateUserInfo(imUser3);
            IMUser imUser32 = new IMUser();
            imUser3.CopyTo(imUser32, "NICKNAME|IMUSERID|PHONE|OFFICEPHONE|SEX|SHORTPHONE|SHORTPHONE2|EMAIL|DUTY|DUTYLEVEL|WORKPLACE|HOLIDAYSTATE|BIRTHDAY|USERDATA|USERDATA2|USERDATA3|USERDATA4|USERDATA5|USERDATA6|USERDATA7|USERDATA8|USERDATA9|USERDATA10", false);
            String strUserFullInfo = imUser32.ToJSONString();
            IMUser iMUser = imUser2 = this.GetUser(imUserSessionInstance.getUserId());
            synchronized (iMUser) {
                imUser2.SetParamValue("USERFULLINFO", strUserFullInfo);
            }
            IMRemoteAction serverActionContext = new IMRemoteAction();
            serverActionContext.setAction("USERFULLINFOSYNC");
            serverActionContext.setParam("USERID", imUserSessionInstance.getUserId());
            serverActionContext.setContent(strUserFullInfo);
            this.AddRemoteActionToQueue(serverActionContext);
            IMInformMessage imInformMessage = new IMInformMessage();
            imInformMessage.setMessageType(1007);
            imInformMessage.setMsgTargetType(3);
            imInformMessage.setUserId(strUserId);
            imInformMessage.setParam(strUserFullInfo);
            this.AddMessageToQueue(imInformMessage, false);
            return new IMMessagePackage();
        }
        String strUserId = iIMRemoteActionContext.getParam("USERID", "");
        String strUserFullInfo = iIMRemoteActionContext.getContent();
        if (StringHelper.IsNullOrEmpty((String)strUserFullInfo)) {
            return new IMMessagePackage();
        }
        byte[] orgData = strUserFullInfo.getBytes();
        strUserFullInfo = new String(orgData, "UTF8");
        IMUser orgData2 = imUser = this.GetUser(strUserId);
        synchronized (orgData2) {
            imUser.SetParamValue("USERFULLINFO", strUserFullInfo);
        }
        IMInformMessage imInformMessage = new IMInformMessage();
        imInformMessage.setMessageType(1007);
        imInformMessage.setMsgTargetType(3);
        imInformMessage.setUserId(strUserId);
        imInformMessage.setParam(strUserFullInfo);
        this.AddMessageToQueue(imInformMessage, false);
        return new IMMessagePackage();
    }

    protected IMMessagePackage OnSendInformMessage(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        if (!iIMRemoteActionContext.isFromServer()) {
            return new IMMessagePackage();
        }
        String strMessageType = iIMRemoteActionContext.getParam("MSGTYPE", "");
        String strMessage = iIMRemoteActionContext.getContent();
        if (StringHelper.IsNullOrEmpty((String)strMessage)) {
            return new IMMessagePackage();
        }
        String strSender = iIMRemoteActionContext.getParam("SENDER", "");
        String strReceiverType = iIMRemoteActionContext.getParam("RECEIVERTYPE", "");
        String strReceiver = iIMRemoteActionContext.getParam("RECEIVER", "");
        byte[] orgData = strMessage.getBytes();
        strMessage = new String(orgData, "UTF8");
        JSONObject jo = JSONObject.fromString((String)strMessage);
        IMMessageBase imMessageBase = null;
        if (StringHelper.Compare((String)strMessageType, (String)"SYS", (boolean)true) == 0) {
            IMInformMessage imInformMessage = new IMInformMessage();
            imInformMessage.FromJSONObject(jo);
            imMessageBase = imInformMessage;
        } else if (StringHelper.Compare((String)strMessageType, (String)"USER", (boolean)true) == 0) {
            IMUserInformMessage imUserInformMessage = new IMUserInformMessage();
            imUserInformMessage.FromJSONObject(jo);
            imMessageBase = imUserInformMessage;
        }
        if (imMessageBase != null) {
            if (StringHelper.Compare((String)strReceiverType, (String)"USER", (boolean)true) == 0) {
                imMessageBase.setMsgTargetType(2);
                imMessageBase.setMsgTarget(strReceiver);
            } else {
                imMessageBase.setMsgTargetType(1);
                imMessageBase.setMsgTarget(strReceiver);
            }
            this.AddMessageToQueue(imMessageBase, false);
        }
        return new IMMessagePackage();
    }

    protected IMMessagePackage OnUserResetRecentFromTime(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        if (!iIMRemoteActionContext.isFromServer()) {
            String strUserSessionId = iIMRemoteActionContext.getParam("USERSESSIONID", "");
            String strUserId = iIMRemoteActionContext.getParam("USERID", "");
            IIMUserSessionInstance imUserSessionInstance = this.GetUserSessionInstance(strUserId, strUserSessionId);
            IMUser imUser = new IMUser();
            imUser.setIMUSERID(imUserSessionInstance.getUserId());
            imUser.setRECENTFROMTIME(new Timestamp(new Date().getTime()));
            this.UpdateUserInfo(imUser);
            return imUserSessionInstance.ProcessRemoteAction(iIMRemoteActionContext);
        }
        return new IMMessagePackage();
    }

    protected IMMessagePackage OnUserIconSync(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        if (!iIMRemoteActionContext.isFromServer()) {
            String strUserSessionId = iIMRemoteActionContext.getParam("USERSESSIONID", "");
            String strUserId = iIMRemoteActionContext.getParam("USERID", "");
            IIMUserSessionInstance imUserSessionInstance = this.GetUserSessionInstance(strUserId, strUserSessionId);
            String strFileExt = iIMRemoteActionContext.getParam("FILENAME", "");
            String strContent = iIMRemoteActionContext.getContent();
            if (StringHelper.IsNullOrEmpty((String)strContent)) {
                throw new Exception("\u6ca1\u6709\u4e0a\u4f20\u56fe\u7247\u5185\u5bb9");
            }
            IMMessagePackage iMMessagePackage = this.iIMCatalogServerStub.SendRemoteAction(iIMRemoteActionContext);
            String strFileName = iMMessagePackage.getExtInfo("filename", "");
            IMUser imUser = this.GetUser(strUserId);
            imUser.setICONPATH(strFileName);
            IMRemoteAction serverActionContext = new IMRemoteAction();
            serverActionContext.setAction("USERINFOSYNC");
            serverActionContext.setParam("USERID", imUserSessionInstance.getUserId());
            serverActionContext.setParam("ONLINESTATE", imUser.getONLINESTATE());
            serverActionContext.setParam("ONLINESTATEINFO", imUser.getONLINESTATEINFO());
            serverActionContext.setParam("USERINFO", imUser.getUSERINFO());
            serverActionContext.setParam("NICKNAME", imUser.getNICKNAME());
            serverActionContext.setParam("USERICON", imUser.getICONPATH());
            this.AddRemoteActionToQueue(serverActionContext);
            IMInformMessage imInformMessage = new IMInformMessage();
            imInformMessage.setMessageType(1002);
            imInformMessage.setOnlineState(imUser.getONLINESTATE());
            imInformMessage.setOnlineStateInfo(imUser.getONLINESTATEINFO());
            imInformMessage.setNickName(imUser.getNICKNAME());
            imInformMessage.setUserInfo(imUser.getUSERINFO());
            imInformMessage.setUserId(strUserId);
            imInformMessage.setUserIcon(imUser.getICONPATH());
            imInformMessage.setMsgTargetType(3);
            imInformMessage.setMsgTarget(strUserId);
            imInformMessage.setIMDomain(imUser.getIMDOMAIN());
            this.AddMessageToQueue(imInformMessage, false);
            IMMessagePackage imMessagePackage = imUserSessionInstance.ProcessRemoteAction(iIMRemoteActionContext);
            if (imMessagePackage.getRetCode() == 0) {
                imMessagePackage.setExtInfo("filename", imUser.getICONPATH());
            }
            return imMessagePackage;
        }
        return new IMMessagePackage();
    }

    protected IMMessagePackage OnUserDisGroupList(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        if (!iIMRemoteActionContext.isFromServer()) {
            String strUserSessionId = iIMRemoteActionContext.getParam("USERSESSIONID", "");
            String strUserId = iIMRemoteActionContext.getParam("USERID", "");
            IIMUserSessionInstance imUserSessionInstance = this.GetUserSessionInstance(strUserId, strUserSessionId);
            return imUserSessionInstance.ProcessRemoteAction(iIMRemoteActionContext);
        }
        return new IMMessagePackage();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected IIMUserSessionInstance GetUserSessionInstance(String strUserId, String strUserSessionId) throws Exception {
        if (StringHelper.IsNullOrEmpty((String)strUserId)) {
            throw new IMException(10001);
        }
        IIMUserSessionInstance imUserSessionInstance = null;
        Hashtable<String, IIMUserSessionInstance> hashtable = this.imUserSessionInstanceMap;
        synchronized (hashtable) {
            if (this.imUserSessionInstanceMap.containsKey(strUserId)) {
                imUserSessionInstance = this.imUserSessionInstanceMap.get(strUserId);
            }
        }
        if (imUserSessionInstance == null) {
            throw new IMException(10001);
        }
        if (StringHelper.Compare((String)imUserSessionInstance.getUserSessionId(), (String)strUserSessionId, (boolean)true) != 0) {
            throw new IMException(10008);
        }
        return imUserSessionInstance;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected IMMessagePackage OnUserSessionLogout(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMUser imUser;
        if (!iIMRemoteActionContext.isFromServer()) {
            IMUser imUser2;
            String strUserSessionId = iIMRemoteActionContext.getParam("USERSESSIONID", "");
            String strUserId = iIMRemoteActionContext.getParam("USERID", "");
            IIMUserSessionInstance imUserSessionInstance = null;
            Hashtable<String, IIMUserSessionInstance> hashtable = this.imUserSessionInstanceMap;
            synchronized (hashtable) {
                if (this.imUserSessionInstanceMap.containsKey(strUserId)) {
                    imUserSessionInstance = this.imUserSessionInstanceMap.get(strUserId);
                    this.imUserSessionInstanceMap.remove(strUserId);
                }
            }
            if (imUserSessionInstance == null) {
                throw new IMException(10001, "\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7684\u4f1a\u8bdd");
            }
            if (StringHelper.Compare((String)imUserSessionInstance.getUserSessionId(), (String)strUserSessionId, (boolean)true) != 0) {
                throw new IMException(10001, "\u6307\u5b9a\u4f1a\u8bdd\u4e0e\u5f53\u524d\u7528\u6237\u4e0d\u4e00\u81f4");
            }
            IMUserSession imUserSession = new IMUserSession();
            imUserSession.setIMUSERSESSIONID(imUserSessionInstance.getUserSessionId());
            imUserSession.setIMUSERID(imUserSessionInstance.getUserId());
            this.UpdateUserSessionState(imUserSession, false);
            IMUser iMUser = imUser2 = this.GetUser(strUserId);
            synchronized (iMUser) {
                imUser2.setONLINEFLAG(false);
                imUser2.setIMUSERSESSIONID("");
                imUser2.setONLINESTATE(null);
            }
            IMRemoteAction serverActionContext = new IMRemoteAction();
            serverActionContext.setAction("USERSESSIONLOGOUT");
            serverActionContext.setParam("USERID", imUserSessionInstance.getUserId());
            serverActionContext.setParam("USERSESSIONID", imUserSessionInstance.getUserSessionId());
            this.AddRemoteActionToQueue(serverActionContext);
            IMInformMessage imInformMessage = new IMInformMessage();
            imInformMessage.setMessageType(1001);
            imInformMessage.setUserId(imUserSessionInstance.getUserId());
            imInformMessage.setMsgTargetType(3);
            imInformMessage.setMsgTarget(imUserSessionInstance.getUserId());
            this.AddMessageToQueue(imInformMessage, false);
            return imUserSessionInstance.ProcessRemoteAction(iIMRemoteActionContext);
        }
        String strUserId = iIMRemoteActionContext.getParam("USERID", "");
        IMUser imUserSessionInstance = imUser = this.GetUser(strUserId);
        synchronized (imUserSessionInstance) {
            imUser.setONLINEFLAG(false);
            imUser.setIMUSERSESSIONID("");
            imUser.setONLINESTATE(null);
        }
        IMInformMessage imInformMessage = new IMInformMessage();
        imInformMessage.setMessageType(1001);
        imInformMessage.setUserId(strUserId);
        imInformMessage.setMsgTargetType(3);
        imInformMessage.setMsgTarget(strUserId);
        this.AddMessageToQueue(imInformMessage, false);
        return new IMMessagePackage();
    }

    protected void UpdateUserSessionState(IMUserSession imUserSession, boolean bLogin) throws Exception {
        String strSessionObj = imUserSession.GetParamStringValue("SESSIONOBJ", "");
        IMUserSession imUserSessionClone = new IMUserSession();
        imUserSessionClone.setIMUSERSESSIONID(imUserSession.getIMUSERSESSIONID());
        if (bLogin) {
            imUserSessionClone.setIMSTATESERVERID(this.getServerId());
            imUserSessionClone.SetParamValue("LOGINTIME", new Timestamp(new Date().getTime()));
        } else {
            imUserSessionClone.SetParamValue("LOGOUTTIME", new Timestamp(new Date().getTime()));
        }
        IDEDataCtrl userSessionDataCtrl = null;
        IDEDataCtrl userDataCtrl = null;
        IMRemoteDEDataCtrl userSessionRemoteDataCtrl = null;
        IMRemoteDEDataCtrl userRemoteDataCtrl = null;
        if (this.getCatalogServerStub().isLocalMode()) {
            userSessionDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl2("IM0071", "SYSTEM", null);
            userDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl2("IM0070", "SYSTEM", null);
        } else {
            userSessionRemoteDataCtrl = new IMRemoteDEDataCtrl();
            userSessionRemoteDataCtrl.Init("", "IM0071", "SYSTEM");
            userRemoteDataCtrl = new IMRemoteDEDataCtrl();
            userRemoteDataCtrl.Init("", "IM0070", "SYSTEM");
        }
        BaseDEDataCtrl.SetCallParamCheckKey((BaseDataEntity)imUserSessionClone, (boolean)false);
        BaseDEDataCtrl.SetCallParamDALog((BaseDataEntity)imUserSessionClone, (boolean)false);
        CallResult callResult = null;
        callResult = this.getCatalogServerStub().isLocalMode() ? userSessionDataCtrl.Save(false, (BaseDataEntity)imUserSessionClone) : userSessionRemoteDataCtrl.Save(false, imUserSessionClone);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u66f4\u65b0\u7528\u6237\u4f1a\u8bdd\u72b6\u6001\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        IMUser imUser = new IMUser();
        imUser.setIMUSERID(imUserSessionClone.getIMUSERID());
        if (!bLogin) {
            callResult = this.getCatalogServerStub().isLocalMode() ? userDataCtrl.Get((BaseDataEntity)imUser) : userRemoteDataCtrl.Get(imUser);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u7528\u6237\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            if (StringHelper.Compare((String)imUser.getIMUSERSESSIONID(), (String)imUserSession.getIMUSERSESSIONID(), (boolean)true) == 0) {
                imUser.Reset();
                imUser.setIMUSERID(imUserSessionClone.getIMUSERID());
                imUser.setONLINEFLAG(false);
                imUser.setONLINESTATE(null);
                imUser.setONLINESTATEINFO(null);
                imUser.setIMUSERSESSIONID(null);
                BaseDEDataCtrl.SetCallParamCheckKey((BaseDataEntity)imUser, (boolean)false);
                BaseDEDataCtrl.SetCallParamDALog((BaseDataEntity)imUser, (boolean)false);
                BaseDEDataCtrl.SetCallParamRetData((BaseDataEntity)imUser, (boolean)false);
                callResult = this.getCatalogServerStub().isLocalMode() ? userDataCtrl.Save(false, (BaseDataEntity)imUser) : userRemoteDataCtrl.Save(false, imUser);
                if (callResult.IsError()) {
                    throw new Exception(StringHelper.Format((String)"\u66f4\u65b0\u7528\u6237\u72b6\u6001\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
            }
        } else {
            imUser.setONLINEFLAG(true);
            imUser.setIMUSERSESSIONID(imUserSessionClone.getIMUSERSESSIONID());
            BaseDEDataCtrl.SetCallParamCheckKey((BaseDataEntity)imUser, (boolean)false);
            BaseDEDataCtrl.SetCallParamDALog((BaseDataEntity)imUser, (boolean)false);
            callResult = this.getCatalogServerStub().isLocalMode() ? userDataCtrl.Save(false, (BaseDataEntity)imUser) : userRemoteDataCtrl.Save(false, imUser);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u66f4\u65b0\u7528\u6237\u72b6\u6001\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            imUserSessionClone.SetParamValue("ONLINESTATE", imUser.getONLINESTATE());
            imUserSessionClone.SetParamValue("ONLINESTATEINFO", imUser.getONLINESTATEINFO());
            imUserSessionClone.SetParamValue("USERINFO", imUser.getUSERINFO());
            imUserSessionClone.SetParamValue("NICKNAME", imUser.getNICKNAME());
            imUserSessionClone.SetParamValue("ICONPATH", imUser.getICONPATH());
        }
        imUserSessionClone.CopyTo(imUserSession, true);
        imUserSession.SetParamValue("SESSIONOBJ", strSessionObj);
    }

    protected void UpdateUserInfo(IMUser imUser) throws Exception {
        CallResult callResult = null;
        if (this.getCatalogServerStub().isLocalMode()) {
            IDEDataCtrl userDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl2("IM0070", "SYSTEM", null);
            callResult = userDataCtrl.Save(false, (BaseDataEntity)imUser);
        } else {
            IMRemoteDEDataCtrl userRemoteDataCtrl = new IMRemoteDEDataCtrl();
            userRemoteDataCtrl.Init("", "IM0070", "SYSTEM");
            callResult = userRemoteDataCtrl.CustomCall("FULLINFOMODE", imUser);
        }
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u66f4\u65b0\u7528\u6237\u72b6\u6001\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
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
        if (this.getCatalogServerStub().isLocalMode()) {
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

    protected IIMUserSessionInstance OnCreateUserSessionInstance(IMUserSession imUserSession) throws Exception {
        IIMUserSessionInstance imUserSessionInstance = null;
        String strSessionObj = imUserSession.GetParamStringValue("SESSIONOBJ", "");
        if (StringHelper.IsNullOrEmpty((String)strSessionObj)) {
            imUserSessionInstance = new IMUserSessionInstance();
        } else {
            Object objIMUserSessionInstance = ObjectHelper.Create((String)strSessionObj);
            if (objIMUserSessionInstance == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u5bf9\u8c61[%1$s]", (Object)strSessionObj));
            }
            if (!(objIMUserSessionInstance instanceof IIMUserSessionInstance)) {
                throw new Exception(StringHelper.Format((String)"\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strSessionObj));
            }
            imUserSessionInstance = (IIMUserSessionInstance)objIMUserSessionInstance;
        }
        imUserSessionInstance.Init(this.iDAGlobalHelper, this, imUserSession);
        return imUserSessionInstance;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void AddMessageToQueue(IMMessageBase imMessageBase, boolean bImmediately) {
        if (bImmediately) {
            Vector<IMMessageBase> vector = this.imMessageList2;
            synchronized (vector) {
                this.imMessageList2.add(imMessageBase);
            }
        }
        Vector<IMMessageBase> vector = this.imMessageList;
        synchronized (vector) {
            this.imMessageList.add(imMessageBase);
        }
    }

    protected void OnDispatchMessage() {
        Vector<IIMUserSessionInstance> imUserSessionInstanceList = new Vector<IIMUserSessionInstance>();
        while (true) {
            IMMessageBase imMessageBase = null;
            boolean bImmediately = false;
            synchronized (this.imMessageList2) {
                if (this.imMessageList2.size() > 0) {
                    imMessageBase = this.imMessageList2.remove(0);
                    bImmediately = true;
                }
            }
            if (imMessageBase == null) {
                synchronized (this.imMessageList) {
                    if (this.imMessageList.size() > 0) {
                        imMessageBase = this.imMessageList.remove(0);
                        bImmediately = false;
                    }
                }
            }

            if (imMessageBase == null) {
                return;
            }

            imUserSessionInstanceList.clear();
            if (imMessageBase.getMsgTargetType() == 2) {
                IIMUserSessionInstance imUserSessionInstance = null;
                synchronized (this.imUserSessionInstanceMap) {
                    imUserSessionInstance = this.imUserSessionInstanceMap.get(imMessageBase.getMsgTarget());
                }
                if (imUserSessionInstance != null) {
                    imUserSessionInstanceList.add(imUserSessionInstance);
                }
            } else if (imMessageBase.getMsgTargetType() == 1) {
                synchronized (this.imUserSessionInstanceMap) {
                    for (IIMUserSessionInstance item : this.imUserSessionInstanceMap.values()) {
                        imUserSessionInstanceList.add(item);
                    }
                }
            } else if (imMessageBase.getMsgTargetType() == 3) {
                synchronized (this.imUserSessionInstanceMap) {
                    for (IIMUserSessionInstance item : this.imUserSessionInstanceMap.values()) {
                        if (StringHelper.Compare((String)item.getUserId(), (String)imMessageBase.getMsgTarget(), (boolean)true) != 0) {
                            imUserSessionInstanceList.add(item);
                        }
                    }
                }
            } else {
                IMStateServerInstance.log.error((Object)StringHelper.Format((String)"\u672a\u77e5\u7684\u6d88\u606f\u76ee\u6807\u7c7b\u578b[%1$s]", (Object)imMessageBase.getMsgTargetType()));
                continue;
            }

            for (IIMUserSessionInstance imUserSessionInstance : imUserSessionInstanceList) {
                imUserSessionInstance.AddMessageToQueue(imMessageBase, bImmediately);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean RegisterUserConnection(String strUserId, String strUserSessionId, IIMCometEvent cometEvent) throws Exception {
        if (this.isServerShuttingDown()) {
            throw new IMException(10007);
        }
        IIMUserSessionInstance imUserSessionInstance = null;
        Hashtable<String, IIMUserSessionInstance> hashtable = this.imUserSessionInstanceMap;
        synchronized (hashtable) {
            imUserSessionInstance = this.imUserSessionInstanceMap.get(strUserId);
        }
        if (imUserSessionInstance == null) {
            throw new IMException(10001);
        }
        if (StringHelper.Compare((String)imUserSessionInstance.getUserSessionId(), (String)strUserSessionId, (boolean)true) != 0) {
            throw new IMException(10008);
        }
        imUserSessionInstance.RegisterUserConnection(cometEvent);
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void UnregisterUserConnection(String strUserId, String strUserSessionId) {
        IIMUserSessionInstance imUserSessionInstance = null;
        Hashtable<String, IIMUserSessionInstance> hashtable = this.imUserSessionInstanceMap;
        synchronized (hashtable) {
            imUserSessionInstance = this.imUserSessionInstanceMap.get(strUserId);
        }
        if (imUserSessionInstance == null) {
            return;
        }
        if (StringHelper.Compare((String)imUserSessionInstance.getUserSessionId(), (String)strUserSessionId, (boolean)true) != 0) {
            return;
        }
        imUserSessionInstance.UnregisterUserConnection();
    }

    protected IMMessagePackage OnMeetingInvite(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        if (iIMRemoteActionContext.isFromServer()) {
            IMInformMessage imInformMessage = new IMInformMessage();
            imInformMessage.setMessageType(1100);
            imInformMessage.setMsgTargetType(2);
            imInformMessage.setMsgTarget(iIMRemoteActionContext.getParam("USERID", ""));
            imInformMessage.setMeetingId(iIMRemoteActionContext.getParam("MEETINGID", ""));
            imInformMessage.setMeetingName(iIMRemoteActionContext.getParam("MEETINGNAME", ""));
            imInformMessage.setMeetingType(Integer.parseInt(iIMRemoteActionContext.getParam("MEETINGTYPE", "1")));
            imInformMessage.setParam(iIMRemoteActionContext.getParam("SERVERPATH", ""));
            imInformMessage.setParam2(iIMRemoteActionContext.getParam("SERVERCOMETPATH", ""));
            imInformMessage.setParam3(iIMRemoteActionContext.getParam("FROMUSERID", ""));
            imInformMessage.setParam4(iIMRemoteActionContext.getParam("FROMUSERNAME", ""));
            this.AddMessageToQueue(imInformMessage, true);
        }
        return new IMMessagePackage();
    }

    protected IMMessagePackage OnDisGroupInvite(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        if (iIMRemoteActionContext.isFromServer()) {
            IMInformMessage imInformMessage = new IMInformMessage();
            imInformMessage.setMessageType(1103);
            imInformMessage.setMsgTargetType(2);
            imInformMessage.setMsgTarget(iIMRemoteActionContext.getParam("USERID", ""));
            imInformMessage.setMeetingId(iIMRemoteActionContext.getParam("MEETINGID", ""));
            imInformMessage.setMeetingName(iIMRemoteActionContext.getParam("MEETINGNAME", ""));
            imInformMessage.setMeetingType(Integer.parseInt(iIMRemoteActionContext.getParam("MEETINGTYPE", "1")));
            imInformMessage.setParam(iIMRemoteActionContext.getParam("SERVERPATH", ""));
            imInformMessage.setParam2(iIMRemoteActionContext.getParam("SERVERCOMETPATH", ""));
            imInformMessage.setParam3(iIMRemoteActionContext.getParam("FROMUSERID", ""));
            imInformMessage.setParam4(iIMRemoteActionContext.getParam("FROMUSERNAME", ""));
            imInformMessage.setContent(iIMRemoteActionContext.getContent());
            this.AddMessageToQueue(imInformMessage, true);
        }
        return new IMMessagePackage();
    }

    protected IMMessagePackage OnDisGroupQuit(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        if (iIMRemoteActionContext.isFromServer()) {
            IMInformMessage imInformMessage = new IMInformMessage();
            imInformMessage.setMessageType(1104);
            imInformMessage.setMsgTargetType(2);
            imInformMessage.setMsgTarget(iIMRemoteActionContext.getParam("USERID", ""));
            imInformMessage.setMeetingId(iIMRemoteActionContext.getParam("MEETINGID", ""));
            imInformMessage.setMeetingName(iIMRemoteActionContext.getParam("MEETINGNAME", ""));
            imInformMessage.setContent(iIMRemoteActionContext.getContent());
            this.AddMessageToQueue(imInformMessage, true);
        }
        return new IMMessagePackage();
    }

    protected IMMessagePackage OnMeetingKickedOut(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        return new IMMessagePackage();
    }

    protected IMMessagePackage OnMeetingOpen(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        String strUserSessionId = iIMRemoteActionContext.getParam("USERSESSIONID", "");
        String strUserId = iIMRemoteActionContext.getParam("USERID", "");
        IIMUserSessionInstance iIMUserSessionInstance = this.GetUserSessionInstance(strUserId, strUserSessionId);
        IMRemoteAction imRemoteActionServer = new IMRemoteAction();
        imRemoteActionServer.FromRemoteAction(iIMRemoteActionContext);
        imRemoteActionServer.setFromServer(true);
        imRemoteActionServer.setParam("FROMSERVERID", this.getServerId());
        IMMessagePackage imMessagePackageServer = this.getCatalogServerStub().SendRemoteAction(imRemoteActionServer);
        if (imMessagePackageServer.getRetCode() == 0) {
            return imMessagePackageServer;
        }
        log.error((Object)StringHelper.Format((String)"\u7528\u6237\u4f1a\u8bdd\u5f00\u542f\u4f1a\u8bae\u5931\u8d25\uff0c%1$s", (Object)imMessagePackageServer.getRetCode()));
        return imMessagePackageServer;
    }

    protected IMMessagePackage OnMeetingReopen(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        String strUserSessionId = iIMRemoteActionContext.getParam("USERSESSIONID", "");
        String strUserId = iIMRemoteActionContext.getParam("USERID", "");
        IIMUserSessionInstance iIMUserSessionInstance = this.GetUserSessionInstance(strUserId, strUserSessionId);
        IMRemoteAction imRemoteActionServer = new IMRemoteAction();
        imRemoteActionServer.FromRemoteAction(iIMRemoteActionContext);
        imRemoteActionServer.setFromServer(true);
        imRemoteActionServer.setParam("FROMSERVERID", this.getServerId());
        IMMessagePackage imMessagePackageServer = this.getCatalogServerStub().SendRemoteAction(imRemoteActionServer);
        if (imMessagePackageServer.getRetCode() == 0) {
            return imMessagePackageServer;
        }
        log.error((Object)StringHelper.Format((String)"\u7528\u6237\u4f1a\u8bdd\u5f00\u542f\u4f1a\u8bae\u5931\u8d25\uff0c%1$s", (Object)imMessagePackageServer.getRetCode()));
        return imMessagePackageServer;
    }

    @Override
    protected void OnShutdownServer() throws Exception {
        this.OnTestSessionTimeout(true);
        for (WorkThread workThread : this.workThreads) {
            workThread.setStopFlag();
        }
        for (WorkThread workThread : this.workThreads) {
            while (workThread.isAlive()) {
                Thread.sleep(100L);
            }
        }
        super.OnShutdownServer();
    }

    @Override
    protected void OnStartServer() throws Exception {
        super.OnStartServer();
        this.OnLoadUsers();
        this.OnCheckThread();
    }

    protected void OnLoadUsers() throws Exception {
        CallResult callResult = this.getIMModelHelper().ResetIMUserOnlineStateByStateServer(this.getServerId());
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u91cd\u7f6e\u7528\u6237\u5728\u7ebf\u72b6\u6001\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        Vector<IMUser> imUsers = new Vector<IMUser>();
        callResult = this.getIMModelHelper().GetIMContacts(imUsers);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7528\u6237\u5217\u8868\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        this.imUserMap = new Hashtable();
        for (IMUser imUser : imUsers) {
            IMUser imUser2 = new IMUser();
            imUser.CopyTo(imUser2, "NICKNAME|IMUSERID|PHONE|OFFICEPHONE|SEX|SHORTPHONE|SHORTPHONE2|EMAIL|DUTY|DUTYLEVEL|WORKPLACE|HOLIDAYSTATE|BIRTHDAY|USERDATA|USERDATA2|USERDATA3|USERDATA4|USERDATA5|USERDATA6|USERDATA7|USERDATA8|USERDATA9|USERDATA10", false);
            imUser.SetParamValue("USERFULLINFO", imUser2.ToJSONString());
            this.imUserMap.put(imUser.getIMUSERID(), imUser);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected IMUser GetUser(String strIMUserId) throws Exception {
        IMUser imUser = null;
        imUser = this.imUserMap.get(strIMUserId);
        if (imUser != null) {
            return imUser;
        }
        imUser = new IMUser();
        CallResult callResult = this.getIMModelHelper().GetIMUser(strIMUserId, imUser);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7528\u6237[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strIMUserId, (Object)callResult.getErrorInfo()));
        }
        Hashtable<String, IMUser> hashtable = this.imUserMap;
        synchronized (hashtable) {
            if (this.imUserMap.containsKey(strIMUserId)) {
                return this.imUserMap.get(strIMUserId);
            }
            this.imUserMap.put(strIMUserId, imUser);
            return imUser;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void ListUsers(Vector<IMUser> imUsers) {
        Hashtable<String, IMUser> hashtable = this.imUserMap;
        synchronized (hashtable) {
            imUsers.addAll(this.imUserMap.values());
        }
    }

    @Override
    protected void OnServerTimer() {
        super.OnServerTimer();
        this.OnServerSync();
        this.OnCheckThread();
    }

    protected void OnServerSync() {
        IMRemoteAction imRemoteAction = new IMRemoteAction();
        imRemoteAction.setAction("SERVERSYNC");
        imRemoteAction.setParam("USERSESSIONCOUNT", StringHelper.Format((String)"%1$s", (Object)this.imUserSessionInstanceMap.size()));
        this.AddRemoteActionToQueue(imRemoteAction);
    }

    protected void OnTestSessionTimeout() {
        this.OnTestSessionTimeout(false);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void OnTestSessionTimeout(boolean bTimeoutAll) {
        Vector<IIMUserSessionInstance> imUserSessionInstanceList = new Vector<IIMUserSessionInstance>();
        Hashtable<String, IIMUserSessionInstance> hashtable = this.imUserSessionInstanceMap;
        synchronized (hashtable) {
            for (IIMUserSessionInstance imUserSessionInstance : this.imUserSessionInstanceMap.values()) {
                imUserSessionInstanceList.add(imUserSessionInstance);
            }
        }
        for (IIMUserSessionInstance imUserSessionInstance : imUserSessionInstanceList) {
            if (!imUserSessionInstance.isTimeout() && !bTimeoutAll) continue;
            log.debug((Object)StringHelper.Format((String)"\u7528\u6237[%1$s]\u4f1a\u8bdd[%2$s]\u8d85\u65f6", (Object)imUserSessionInstance.getUserId(), (Object)imUserSessionInstance.getUserSessionId()));
            Hashtable<String, IIMUserSessionInstance> hashtable2 = this.imUserSessionInstanceMap;
            synchronized (hashtable2) {
                this.imUserSessionInstanceMap.remove(imUserSessionInstance.getUserId());
            }
            imUserSessionInstance.Close();
            try {
                IMUserSession imUserSession = new IMUserSession();
                imUserSession.setIMUSERSESSIONID(imUserSessionInstance.getUserSessionId());
                imUserSession.setIMUSERID(imUserSessionInstance.getUserId());
                this.UpdateUserSessionState(imUserSession, false);
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u66f4\u65b0\u7528\u6237\u4f1a\u8bdd\u72b6\u6001\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            }
            try {
                IMUser imUser;
                IMUser iMUser = imUser = this.GetUser(imUserSessionInstance.getUserId());
                synchronized (iMUser) {
                    imUser.setONLINEFLAG(false);
                    imUser.setIMUSERSESSIONID("");
                    imUser.setONLINESTATE(null);
                }
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u66f4\u65b0\u7528\u6237\u4f1a\u8bdd\u72b6\u6001\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            }
            IMRemoteAction serverActionContext = new IMRemoteAction();
            serverActionContext.setAction("USERSESSIONLOGOUT");
            serverActionContext.setParam("USERID", imUserSessionInstance.getUserId());
            this.AddRemoteActionToQueue(serverActionContext);
            if (bTimeoutAll) continue;
            IMInformMessage imInformMessage = new IMInformMessage();
            imInformMessage.setMessageType(1001);
            imInformMessage.setUserId(imUserSessionInstance.getUserId());
            imInformMessage.setMsgTargetType(3);
            imInformMessage.setMsgTarget(imUserSessionInstance.getUserId());
            this.AddMessageToQueue(imInformMessage, false);
        }
    }

    protected int getDispatchMessageThreadCount() {
        return 20;
    }

    protected int getTimeoutThreadCount() {
        return 2;
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
                    if (workThread2.getWorkType() != 2) continue;
                    ++nTimeoutCnt;
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
            }
        }
        catch (Exception ex) {
            log.debug((Object)ex);
        }
    }

    @Override
    protected void OnServerShuttingDown() throws Exception {
        super.OnServerShuttingDown();
    }

    protected IMMessagePackage OnUserInform(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        if (iIMRemoteActionContext.isFromServer()) {
            String strInformTime;
            String strSender = iIMRemoteActionContext.getParam("SENDER", "");
            String strReceiverType = iIMRemoteActionContext.getParam("RECEIVERTYPE", "");
            String strReceiver = iIMRemoteActionContext.getParam("RECEIVER", "");
            IMUserInformMessage imUserInformMessage = new IMUserInformMessage();
            imUserInformMessage.setSender(strSender);
            String strInformType = iIMRemoteActionContext.getParam("INFORMTYPE", "");
            if (!StringHelper.IsNullOrEmpty((String)strInformType)) {
                imUserInformMessage.setMessageType(Integer.parseInt(strInformType));
            }
            if (!StringHelper.IsNullOrEmpty((String)(strInformTime = iIMRemoteActionContext.getParam("INFORMTIME", "")))) {
                imUserInformMessage.setInformTime(new Timestamp(DateParser.Parse((String)strInformTime).getTime()));
            }
            if (StringHelper.Compare((String)strReceiverType, (String)"USER", (boolean)true) == 0) {
                imUserInformMessage.setMsgTargetType(2);
                imUserInformMessage.setMsgTarget(strReceiver);
            } else {
                imUserInformMessage.setMsgTargetType(1);
                imUserInformMessage.setMsgTarget(strReceiver);
            }
            JSONObject contentJO = null;
            if (!StringHelper.IsNullOrEmpty((String)iIMRemoteActionContext.getContent())) {
                contentJO = JSONObject.fromString((String)iIMRemoteActionContext.getContent());
                if (contentJO.has("subject")) {
                    imUserInformMessage.setSubject(contentJO.getString("subject"));
                }
                if (contentJO.has("content")) {
                    imUserInformMessage.setContent(contentJO.getString("content"));
                }
                if (contentJO.has("richcontent")) {
                    imUserInformMessage.setRichContent(contentJO.getString("richcontent"));
                }
                if (contentJO.has("url")) {
                    imUserInformMessage.setUrl(contentJO.getString("url"));
                }
            }
            this.AddMessageToQueue(imUserInformMessage, false);
        }
        return imMessagePackage;
    }

    @Override
    public boolean isLocalMode() {
        return this.getCatalogServerStub().isLocalMode();
    }

    private class WorkThread
    extends Thread {
        public static final int WORK_DISPATCHMESSAGE = 1;
        public static final int WORK_TIMEOUT = 2;
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
                            IMStateServerInstance.this.OnDispatchMessage();
                            break;
                        }
                        case 2: {
                            IMStateServerInstance.this.OnTestSessionTimeout();
                        }
                    }
                    Thread.sleep(100L);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
