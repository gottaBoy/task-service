/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.IM.Ctrl;

import SA.IM.Ctrl.DEDataCtrl.IMRemoteDEDataCtrl;
import SA.IM.Ctrl.Data.IMDisGroup;
import SA.IM.Ctrl.Data.IMDisGroupDetail;
import SA.IM.Ctrl.Data.IMParticipant;
import SA.IM.Ctrl.Data.IMSysInform;
import SA.IM.Ctrl.IIMParticipantInstance;
import SA.IM.Ctrl.IIMRemoteAction;
import SA.IM.Ctrl.IMException;
import SA.IM.Ctrl.IMMeetingInstance;
import SA.IM.Ctrl.IMMessagePackage;
import SA.IM.Ctrl.IMRemoteAction;
import SA.IM.Ctrl.IMUserSessionInstance;
import SA.IM.Ctrl.Message.IMMeetingMessage;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IMDisGroupMeetingInstance
extends IMMeetingInstance {
    private IMDisGroup imDisGroup = new IMDisGroup();
    long nLastRefreshTime = -1L;
    private static final Log log = LogFactory.getLog(IMUserSessionInstance.class);
    private boolean bValidFlag = true;
    private boolean bRemoveDisGroup = false;
    private boolean bTimeout = false;

    @Override
    protected void OnInit() throws Exception {
        super.OnInit();
        CallResult callResult = this.getIMModelHelper().GetIMDisGroup(this.getMeetingId(), this.imDisGroup);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u8ba8\u8bba\u7ec4[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)this.getMeetingId(), (Object)callResult.getErrorInfo()));
        }
        this.nLastRefreshTime = System.currentTimeMillis();
        this.bValidFlag = this.imDisGroup.getVALIDFLAG();
    }

    @Override
    protected void OnPrepareParticipants() throws Exception {
        Vector<IMDisGroupDetail> imDisGroupDetails = new Vector<IMDisGroupDetail>();
        CallResult callResult = this.getIMModelHelper().GetIMDisGroupDetails(this.getMeetingId(), imDisGroupDetails);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u4f1a\u8bae\u53c2\u4e0e\u4eba\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (IMDisGroupDetail imDisGroupDetail : imDisGroupDetails) {
            IMParticipant imParticipant = new IMParticipant();
            imDisGroupDetail.CopyTo(imParticipant, false);
            imParticipant.setIMPARTICIPANTID(imDisGroupDetail.getIMDISGRPDETAILID());
            imParticipant.setIMPARTICIPANTNAME(imDisGroupDetail.getIMDISGRPDETAILNAME());
            imParticipant.setADMINFLAG(imDisGroupDetail.getADMINFLAG());
            IIMParticipantInstance imParticipantInstance = this.OnCreateParticipantInstance(imParticipant);
            imParticipantInstance.Init(this.iDAGlobalHelper, this, imParticipant);
            this.imParticipantMap.put(imParticipantInstance.getUserId(), imParticipantInstance);
        }
    }

    @Override
    public boolean isTimeout() {
        return this.bTimeout;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected IMMessagePackage OnMeetingAttend(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMMessagePackage iMMessagePackage = super.OnMeetingAttend(iIMRemoteActionContext);
        JSONObject joUserGroup = new JSONObject();
        IMDisGroup iMDisGroup = this.imDisGroup;
        synchronized (iMDisGroup) {
            joUserGroup.put("id", (Object)this.imDisGroup.getIMDISGROUPID());
            joUserGroup.put("name", (Object)this.imDisGroup.getIMDISGROUPNAME());
            joUserGroup.put("memo", (Object)this.imDisGroup.getMEMO());
            joUserGroup.put("orderflag", this.imDisGroup.getORDERFLAG());
            joUserGroup.put("ownerid", (Object)this.imDisGroup.getIMUSERID());
        }
        iMMessagePackage.setExtInfo("DISGROUP", joUserGroup);
        iMMessagePackage.setExtInfo("MEETINGNAME", this.imDisGroup.getIMDISGROUPNAME());
        return iMMessagePackage;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void OnTestTimeout() {
        super.OnTestTimeout();
        if (System.currentTimeMillis() - this.nLastRefreshTime >= 20000L) {
            try {
                IMMeetingMessage imMeetingMessage;
                IMDisGroup imDisGroup = new IMDisGroup();
                CallResult callResult = this.getIMModelHelper().GetIMDisGroup(this.getMeetingId(), imDisGroup);
                if (callResult.IsError()) {
                    throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u8ba8\u8bba\u7ec4[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)this.getMeetingId(), (Object)callResult.getErrorInfo()));
                }
                this.nLastRefreshTime = System.currentTimeMillis();
                IMDisGroup iMDisGroup = this.imDisGroup;
                synchronized (iMDisGroup) {
                    if (this.imDisGroup.getVERSION() == imDisGroup.getVERSION()) {
                        return;
                    }
                    imDisGroup.CopyTo(this.imDisGroup, true);
                    this.bValidFlag = imDisGroup.getVALIDFLAG();
                }
                HashMap<String, IIMParticipantInstance> currentMap = new HashMap<String, IIMParticipantInstance>();
                Hashtable hashtable = this.imParticipantMap;
                synchronized (hashtable) {
                    currentMap.putAll(this.imParticipantMap);
                }
                Vector<IMDisGroupDetail> imDisGroupDetails = new Vector<IMDisGroupDetail>();
                callResult = this.getIMModelHelper().GetIMDisGroupDetails(this.getMeetingId(), imDisGroupDetails);
                if (callResult.IsError()) {
                    throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u4f1a\u8bae\u53c2\u4e0e\u4eba\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                ArrayList<IMDisGroupDetail> newList = new ArrayList<IMDisGroupDetail>();
                for (IMDisGroupDetail imDisGroupDetail : imDisGroupDetails) {
                    if (currentMap.containsKey(imDisGroupDetail.getIMUSERID())) {
                        currentMap.remove(imDisGroupDetail.getIMUSERID());
                        continue;
                    }
                    newList.add(imDisGroupDetail);
                }
                if (newList.size() > 0) {
                    log.debug((Object)StringHelper.Format((String)"\u8ba8\u8bba\u7ec4[%1$s]\u6709\u65b0\u4eba\u52a0\u5165", (Object)imDisGroup.getIMDISGROUPNAME()));
                    for (IMDisGroupDetail imDisGroupDetail : newList) {
                        imMeetingMessage = new IMMeetingMessage();
                        imMeetingMessage.setMessageType(1100);
                        imMeetingMessage.setMsgTargetType(1);
                        imMeetingMessage.setParam(imDisGroupDetail.getIMUSERID());
                        imMeetingMessage.setParam2(imDisGroupDetail.getIMUSERNAME());
                        imMeetingMessage.setTime(StringHelper.Format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)new Date()));
                        this.AddMessageToQueue(imMeetingMessage);
                        IMParticipant imParticipant = new IMParticipant();
                        imDisGroupDetail.CopyTo(imParticipant, false);
                        imParticipant.setIMPARTICIPANTID(imDisGroupDetail.getIMDISGRPDETAILID());
                        imParticipant.setIMPARTICIPANTNAME(imDisGroupDetail.getIMDISGRPDETAILNAME());
                        IIMParticipantInstance imParticipantInstance = this.OnCreateParticipantInstance(imParticipant);
                        imParticipantInstance.Init(this.iDAGlobalHelper, this, imParticipant);
                        Hashtable hashtable2 = this.imParticipantMap;
                        synchronized (hashtable2) {
                            this.imParticipantMap.put(imParticipantInstance.getUserId(), imParticipantInstance);
                        }
                    }
                    for (IMDisGroupDetail imDisGroupDetail : newList) {
                        imMeetingMessage = new IMMeetingMessage();
                        imMeetingMessage.setMessageType(1103);
                        imMeetingMessage.setMsgTargetType(3);
                        imMeetingMessage.setMsgTarget(imDisGroupDetail.getIMUSERID());
                        imMeetingMessage.setMessage(StringHelper.Format((String)"%1$s \u52a0\u5165\u7fa4\u3002", (Object)imDisGroupDetail.getIMUSERNAME()));
                        imMeetingMessage.setTime(StringHelper.Format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)new Date()));
                        this.AddMessageToQueue(imMeetingMessage);
                    }
                }
                if (currentMap.size() > 0) {
                    for (IIMParticipantInstance iIMParticipantInstance : currentMap.values()) {
                        imMeetingMessage = new IMMeetingMessage();
                        imMeetingMessage.setMessageType(1103);
                        imMeetingMessage.setMsgTargetType(3);
                        imMeetingMessage.setMsgTarget(iIMParticipantInstance.getUserId());
                        imMeetingMessage.setMessage(StringHelper.Format((String)"%1$s \u79bb\u5f00\u7fa4\u3002", (Object)iIMParticipantInstance.getUserName()));
                        imMeetingMessage.setTime(StringHelper.Format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)new Date()));
                        this.AddMessageToQueue(imMeetingMessage);
                    }
                    for (IIMParticipantInstance iIMParticipantInstance : currentMap.values()) {
                        imMeetingMessage = new IMMeetingMessage();
                        imMeetingMessage.setMessageType(1102);
                        imMeetingMessage.setMsgTargetType(1);
                        imMeetingMessage.setParam(iIMParticipantInstance.getUserId());
                        imMeetingMessage.setParam2(iIMParticipantInstance.getUserName());
                        imMeetingMessage.setTime(StringHelper.Format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)new Date()));
                        this.AddMessageToQueue(imMeetingMessage);
                    }
                    for (IIMParticipantInstance iIMParticipantInstance : currentMap.values()) {
                        Hashtable hashtable3 = this.imParticipantMap;
                        synchronized (hashtable3) {
                            this.imParticipantMap.remove(iIMParticipantInstance.getUserId());
                        }
                    }
                }
                this.nLastRefreshTime = System.currentTimeMillis();
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u5237\u65b0\u8ba8\u8bba\u7ec4\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected IMMessagePackage OnMeetingInvite(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        if (!iIMRemoteActionContext.isFromServer()) {
            String[] inviteuserids;
            String strUserId = iIMRemoteActionContext.getParam("USERID", "");
            if (StringHelper.IsNullOrEmpty((String)strUserId)) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7528\u6237\u6807\u8bc6");
            }
            String strUserSessionId = iIMRemoteActionContext.getParam("USERSESSIONID", "");
            if (StringHelper.IsNullOrEmpty((String)strUserSessionId)) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7528\u6237\u4f1a\u8bdd\u6807\u8bc6");
            }
            String strInviteUserIds = iIMRemoteActionContext.getParam(StringHelper.Format((String)"%1$s", (Object)"INVITEUSERID"), "");
            if (StringHelper.IsNullOrEmpty((String)strInviteUserIds) && StringHelper.IsNullOrEmpty((String)(strInviteUserIds = iIMRemoteActionContext.getParam(StringHelper.Format((String)"%1$s", (Object)"INVITEUSERIDS"), "")))) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u9080\u8bf7\u7528\u6237\u6807\u8bc6");
            }
            IIMParticipantInstance imParticipantInstance = null;
            Hashtable hashtable = this.imParticipantMap;
            synchronized (hashtable) {
                imParticipantInstance = (IIMParticipantInstance)this.imParticipantMap.get(strUserId);
            }
            if (imParticipantInstance == null) {
                throw new IMException(10004);
            }
            if (StringHelper.IsNullOrEmpty((String)imParticipantInstance.getUserSessionId())) {
                imParticipantInstance.setUserSessionId(strUserSessionId);
            } else if (StringHelper.Compare((String)strUserSessionId, (String)imParticipantInstance.getUserSessionId(), (boolean)true) != 0) {
                throw new IMException(10001);
            }
            String[] stringArray = inviteuserids = strInviteUserIds.split("[;]");
            int n = inviteuserids.length;
            int n2 = 0;
            while (n2 < n) {
                String strInviteUserId = stringArray[n2];
                IIMParticipantInstance imParticipantInstanceInvite = null;
                Hashtable hashtable2 = this.imParticipantMap;
                synchronized (hashtable2) {
                    imParticipantInstanceInvite = (IIMParticipantInstance)this.imParticipantMap.get(strInviteUserId);
                }
                if (imParticipantInstanceInvite == null) {
                    IMDisGroupDetail imDisGroupDetail = new IMDisGroupDetail();
                    imDisGroupDetail.setIMDISGROUPID(this.imMeeting.getIMMEETINGID());
                    imDisGroupDetail.setIMUSERID(strInviteUserId);
                    this.OnCreateDisGroupDetail(imDisGroupDetail);
                    IMParticipant imParticipant = new IMParticipant();
                    imDisGroupDetail.CopyTo(imParticipant, false);
                    imParticipant.setIMPARTICIPANTID(imDisGroupDetail.getIMDISGRPDETAILID());
                    imParticipant.setIMPARTICIPANTNAME(imDisGroupDetail.getIMDISGRPDETAILNAME());
                    imParticipant.setADMINFLAG(imDisGroupDetail.getADMINFLAG());
                    imParticipantInstanceInvite = this.OnCreateParticipantInstance(imParticipant);
                    imParticipantInstanceInvite.Init(this.iDAGlobalHelper, this, imParticipant);
                    this.imParticipantMap.put(imParticipantInstanceInvite.getUserId(), imParticipantInstanceInvite);
                    this.SendInviteMessageToParticipant(imParticipantInstance, imParticipantInstanceInvite);
                    IMSysInform imSysInform = new IMSysInform();
                    imSysInform.setIMSYSINFORMNAME(StringHelper.Format((String)"\u7fa4\u9080\u8bf7\u6d88\u606f"));
                    imSysInform.setRECEIVERTYPE("USER");
                    imSysInform.setRECEIVER(imParticipantInstanceInvite.getUserId());
                    imSysInform.setCONTENT(StringHelper.Format((String)"%1$s\u9080\u8bf7\u60a8\u52a0\u5165\u7fa4[%2$s]", (Object)imParticipantInstance.getUserName(), (Object)this.imDisGroup.getIMDISGROUPNAME()));
                    imSysInform.setINFORMTIME(new Timestamp(new Date().getTime()));
                    this.AsyncSaveData(true, imSysInform);
                    IMMeetingMessage imMeetingMessage = new IMMeetingMessage();
                    imMeetingMessage.setMsgTargetType(3);
                    imMeetingMessage.setMsgTarget(imParticipantInstanceInvite.getUserId());
                    imMeetingMessage.setMessageType(1100);
                    imMeetingMessage.setFromUserId(strUserId);
                    imMeetingMessage.setParam(imParticipantInstanceInvite.getUserId());
                    imMeetingMessage.setParam2(imParticipantInstanceInvite.getUserName());
                    this.AddMessageToQueue(imMeetingMessage);
                    this.SendLastMessageToParticipant(imParticipantInstanceInvite);
                }
                ++n2;
            }
        }
        return imMessagePackage;
    }

    protected void SendInviteMessageToParticipant(IIMParticipantInstance imParticipantInstance, IIMParticipantInstance imParticipantInstanceInvite) throws Exception {
        IMRemoteAction imRemoteAction = new IMRemoteAction();
        imRemoteAction.setAction("DISGROUPINVITE");
        imRemoteAction.setParam("MEETINGID", this.getMeetingId());
        imRemoteAction.setParam("MEETINGNAME", this.imDisGroup.getIMDISGROUPNAME());
        imRemoteAction.setParam("MEETINGTYPE", StringHelper.Format((String)"%1$s", (Object)this.getMeetingType()));
        imRemoteAction.setParam("USERID", imParticipantInstanceInvite.getUserId());
        imRemoteAction.setParam("SERVERPATH", this.imMeetingServerContext.getServerPath());
        imRemoteAction.setParam("SERVERCOMETPATH", this.imMeetingServerContext.getServerCometPath());
        imRemoteAction.setParam("FROMUSERID", imParticipantInstance.getUserId());
        imRemoteAction.setParam("FROMUSERNAME", imParticipantInstance.getUserName());
        imRemoteAction.setContent(StringHelper.Format((String)"%1$s\u9080\u8bf7\u60a8\u52a0\u5165\u7fa4[%2$s]", (Object)imParticipantInstance.getUserName(), (Object)this.imDisGroup.getIMDISGROUPNAME()));
        this.imMeetingServerContext.SendRemoteAction(imRemoteAction);
    }

    protected void SendQuitMessageToParticipant(IIMParticipantInstance imParticipantInstance, IIMParticipantInstance imParticipantInstanceKickedOut, String strContent) throws Exception {
        IMRemoteAction imRemoteAction = new IMRemoteAction();
        imRemoteAction.setAction("DISGROUPQUIT");
        imRemoteAction.setParam("MEETINGID", this.getMeetingId());
        imRemoteAction.setParam("MEETINGNAME", this.imDisGroup.getIMDISGROUPNAME());
        imRemoteAction.setParam("USERID", imParticipantInstanceKickedOut.getUserId());
        imRemoteAction.setParam("FROMUSERID", imParticipantInstance.getUserId());
        imRemoteAction.setParam("FROMUSERNAME", imParticipantInstance.getUserName());
        imRemoteAction.setContent(strContent);
        this.imMeetingServerContext.SendRemoteAction(imRemoteAction);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected IMMessagePackage OnMeetingKickedOut(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        if (!iIMRemoteActionContext.isFromServer()) {
            String strUserId = iIMRemoteActionContext.getParam("USERID", "");
            if (StringHelper.IsNullOrEmpty((String)strUserId)) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7528\u6237\u6807\u8bc6");
            }
            String strUserSessionId = iIMRemoteActionContext.getParam("USERSESSIONID", "");
            if (StringHelper.IsNullOrEmpty((String)strUserSessionId)) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7528\u6237\u4f1a\u8bdd\u6807\u8bc6");
            }
            String strKickedOutUserId = iIMRemoteActionContext.getParam(StringHelper.Format((String)"%1$s", (Object)"KICKEDOUTUSERID"), "");
            if (StringHelper.IsNullOrEmpty((String)strKickedOutUserId)) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u8e22\u51fa\u7528\u6237\u6807\u8bc6");
            }
            IIMParticipantInstance imParticipantInstance = null;
            IIMParticipantInstance imParticipantInstanceKickedOut = null;
            Hashtable hashtable = this.imParticipantMap;
            synchronized (hashtable) {
                imParticipantInstance = (IIMParticipantInstance)this.imParticipantMap.get(strUserId);
                imParticipantInstanceKickedOut = (IIMParticipantInstance)this.imParticipantMap.get(strKickedOutUserId);
            }
            if (imParticipantInstance == null) {
                throw new IMException(10004);
            }
            if (StringHelper.IsNullOrEmpty((String)imParticipantInstance.getUserSessionId())) {
                imParticipantInstance.setUserSessionId(strUserSessionId);
            } else if (StringHelper.Compare((String)strUserSessionId, (String)imParticipantInstance.getUserSessionId(), (boolean)true) != 0) {
                throw new IMException(10001);
            }
            if (!imParticipantInstance.isAdmin()) {
                throw new Exception(StringHelper.Format((String)"\u975e\u7ba1\u7406\u5458\u4e0d\u80fd\u79fb\u51fa\u8ba8\u8bba\u7ec4\u7528\u6237"));
            }
            if (imParticipantInstanceKickedOut != null) {
                if (StringHelper.Compare((String)imParticipantInstanceKickedOut.getUserId(), (String)imParticipantInstance.getUserId(), (boolean)true) == 0) {
                    throw new Exception(StringHelper.Format((String)"\u81ea\u5df1\u4e0d\u80fd\u79fb\u51fa\u81ea\u5df1"));
                }
                IMDisGroupDetail imDisGroupDetail = new IMDisGroupDetail();
                imDisGroupDetail.setIMDISGRPDETAILID(imParticipantInstanceKickedOut.getId());
                this.OnRemoveDisGroupDetail(imDisGroupDetail);
                this.imParticipantMap.remove(imParticipantInstanceKickedOut.getUserId());
                String strContent = StringHelper.Format((String)"%1$s\u8ba9\u60a8\u79bb\u5f00\u7fa4[%2$s]", (Object)imParticipantInstance.getUserName(), (Object)this.imDisGroup.getIMDISGROUPNAME());
                this.SendQuitMessageToParticipant(imParticipantInstance, imParticipantInstanceKickedOut, strContent);
                IMSysInform imSysInform = new IMSysInform();
                imSysInform.setIMSYSINFORMNAME(StringHelper.Format((String)"\u7fa4\u9000\u51fa\u6d88\u606f"));
                imSysInform.setRECEIVERTYPE("USER");
                imSysInform.setRECEIVER(imParticipantInstanceKickedOut.getUserId());
                imSysInform.setCONTENT(strContent);
                imSysInform.setINFORMTIME(new Timestamp(new Date().getTime()));
                this.AsyncSaveData(true, imSysInform);
                IMMeetingMessage imMeetingMessage = new IMMeetingMessage();
                imMeetingMessage.setMessageType(1103);
                imMeetingMessage.setMsgTargetType(3);
                imMeetingMessage.setMsgTarget(imDisGroupDetail.getIMUSERID());
                imMeetingMessage.setMessage(StringHelper.Format((String)"%1$s \u79bb\u5f00\u7fa4\u3002", (Object)imDisGroupDetail.getIMUSERNAME()));
                imMeetingMessage.setTime(StringHelper.Format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)new Date()));
                this.AddMessageToQueue(imMeetingMessage);
                imMeetingMessage = new IMMeetingMessage();
                imMeetingMessage.setMsgTargetType(3);
                imMeetingMessage.setMsgTarget(imParticipantInstanceKickedOut.getUserId());
                imMeetingMessage.setMessageType(1102);
                imMeetingMessage.setFromUserId(strUserId);
                imMeetingMessage.setParam(imParticipantInstanceKickedOut.getUserId());
                imMeetingMessage.setParam2(imParticipantInstanceKickedOut.getUserName());
                this.AddMessageToQueue(imMeetingMessage);
                imMessagePackage.AddMessage(imMeetingMessage);
            }
        }
        return imMessagePackage;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected IMMessagePackage OnMeetingQuit(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        if (iIMRemoteActionContext.isFromServer()) {
            return super.OnMeetingQuit(iIMRemoteActionContext);
        }
        String strRemoveFlag = iIMRemoteActionContext.getParam("REMOVE", "");
        if (StringHelper.Compare((String)strRemoveFlag, (String)"TRUE", (boolean)true) != 0) {
            return super.OnMeetingQuit(iIMRemoteActionContext);
        }
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        String strUserId = iIMRemoteActionContext.getParam("USERID", "");
        if (StringHelper.IsNullOrEmpty((String)strUserId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7528\u6237\u6807\u8bc6");
        }
        String strUserSessionId = iIMRemoteActionContext.getParam("USERSESSIONID", "");
        if (StringHelper.IsNullOrEmpty((String)strUserSessionId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7528\u6237\u4f1a\u8bdd\u6807\u8bc6");
        }
        IIMParticipantInstance imParticipantInstance = null;
        Hashtable hashtable = this.imParticipantMap;
        synchronized (hashtable) {
            imParticipantInstance = (IIMParticipantInstance)this.imParticipantMap.get(strUserId);
        }
        if (imParticipantInstance == null) {
            throw new IMException(10004);
        }
        if (StringHelper.IsNullOrEmpty((String)imParticipantInstance.getUserSessionId())) {
            imParticipantInstance.setUserSessionId(strUserSessionId);
        } else if (StringHelper.Compare((String)strUserSessionId, (String)imParticipantInstance.getUserSessionId(), (boolean)true) != 0) {
            throw new IMException(10001);
        }
        if (StringHelper.Compare((String)this.imDisGroup.getIMUSERID(), (String)imParticipantInstance.getUserId(), (boolean)false) == 0) {
            this.bRemoveDisGroup = true;
        }
        if (this.bRemoveDisGroup) {
            IMMeetingMessage imMeetingMessage = new IMMeetingMessage();
            imMeetingMessage.setMessageType(1103);
            imMeetingMessage.setMsgTargetType(3);
            imMeetingMessage.setMsgTarget(imParticipantInstance.getId());
            imMeetingMessage.setMessage(StringHelper.Format((String)"%1$s \u5173\u95ed\u7fa4\u3002", (Object)imParticipantInstance.getUserName()));
            imMeetingMessage.setTime(StringHelper.Format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)new Date()));
            this.AddMessageToQueue(imMeetingMessage);
            for (IIMParticipantInstance imParticipantInstanceKickedOut : this.imParticipantMap.values()) {
                imParticipantInstanceKickedOut.Quit();
                IMDisGroupDetail imDisGroupDetail = new IMDisGroupDetail();
                imDisGroupDetail.setIMDISGRPDETAILID(imParticipantInstanceKickedOut.getId());
                this.OnRemoveDisGroupDetail(imDisGroupDetail);
                if (StringHelper.Compare((String)imParticipantInstance.getUserId(), (String)imParticipantInstanceKickedOut.getUserId(), (boolean)true) != 0) {
                    String strContent = StringHelper.Format((String)"%1$s\u89e3\u6563\u7fa4[%2$s]", (Object)imParticipantInstance.getUserName(), (Object)this.imDisGroup.getIMDISGROUPNAME());
                    this.SendQuitMessageToParticipant(imParticipantInstance, imParticipantInstanceKickedOut, strContent);
                }
                IMMeetingMessage imMeetingMessage2 = new IMMeetingMessage();
                imMeetingMessage2.setMsgTargetType(2);
                imMeetingMessage2.setMsgTarget(imParticipantInstanceKickedOut.getUserId());
                imMeetingMessage2.setMessageType(1105);
                imMeetingMessage2.setFromUserId(strUserId);
                imMeetingMessage2.setParam(imParticipantInstanceKickedOut.getUserId());
                imMeetingMessage2.setParam2(imParticipantInstanceKickedOut.getUserName());
                this.AddMessageToQueue(imMeetingMessage2);
                imMessagePackage.AddMessage(imMeetingMessage2);
            }
            this.imParticipantMap.clear();
            this.OnRemoveDisGroup(this.imDisGroup);
            this.bTimeout = true;
        } else {
            imParticipantInstance.Quit();
            IMDisGroupDetail imDisGroupDetail = new IMDisGroupDetail();
            imDisGroupDetail.setIMDISGRPDETAILID(imParticipantInstance.getId());
            this.OnRemoveDisGroupDetail(imDisGroupDetail);
            this.imParticipantMap.remove(imParticipantInstance.getUserId());
            IMMeetingMessage imMeetingMessage = new IMMeetingMessage();
            imMeetingMessage.setMessageType(1103);
            imMeetingMessage.setMsgTargetType(3);
            imMeetingMessage.setMsgTarget(imDisGroupDetail.getIMUSERID());
            imMeetingMessage.setMessage(StringHelper.Format((String)"%1$s \u79bb\u5f00\u7fa4\u3002", (Object)imDisGroupDetail.getIMUSERNAME()));
            imMeetingMessage.setTime(StringHelper.Format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)new Date()));
            this.AddMessageToQueue(imMeetingMessage);
            imMeetingMessage = new IMMeetingMessage();
            imMeetingMessage.setMsgTargetType(3);
            imMeetingMessage.setMsgTarget(imParticipantInstance.getUserId());
            imMeetingMessage.setMessageType(1105);
            imMeetingMessage.setFromUserId(strUserId);
            this.AddMessageToQueue(imMeetingMessage);
            imMessagePackage.AddMessage(imMeetingMessage);
        }
        return imMessagePackage;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected IMMessagePackage OnMeetingRename(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        if (!iIMRemoteActionContext.isFromServer()) {
            String strUserId = iIMRemoteActionContext.getParam("USERID", "");
            if (StringHelper.IsNullOrEmpty((String)strUserId)) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7528\u6237\u6807\u8bc6");
            }
            String strUserSessionId = iIMRemoteActionContext.getParam("USERSESSIONID", "");
            if (StringHelper.IsNullOrEmpty((String)strUserSessionId)) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7528\u6237\u4f1a\u8bdd\u6807\u8bc6");
            }
            IIMParticipantInstance imParticipantInstance = null;
            Hashtable hashtable = this.imParticipantMap;
            synchronized (hashtable) {
                imParticipantInstance = (IIMParticipantInstance)this.imParticipantMap.get(strUserId);
            }
            if (imParticipantInstance == null) {
                throw new IMException(10004);
            }
            if (StringHelper.IsNullOrEmpty((String)imParticipantInstance.getUserSessionId())) {
                imParticipantInstance.setUserSessionId(strUserSessionId);
            } else if (StringHelper.Compare((String)strUserSessionId, (String)imParticipantInstance.getUserSessionId(), (boolean)true) != 0) {
                throw new IMException(10001);
            }
            if (!imParticipantInstance.isAdmin()) {
                throw new Exception(StringHelper.Format((String)"\u975e\u7ba1\u7406\u5458\u4e0d\u80fd\u4fee\u6539\u8ba8\u8bba\u7ec4\u540d\u79f0"));
            }
            String strNewName = iIMRemoteActionContext.getParam("MEETINGNAME", "");
            if (StringHelper.IsNullOrEmpty((String)strNewName)) {
                return imMessagePackage;
            }
            IMDisGroup imDisGroup = new IMDisGroup();
            imDisGroup.setIMDISGROUPID(this.imDisGroup.getIMDISGROUPID());
            imDisGroup.setIMDISGROUPNAME(strNewName);
            this.OnUpdateDisGroup(imDisGroup);
            imDisGroup.CopyTo(this.imDisGroup, true);
            IMMeetingMessage imMeetingMessage = new IMMeetingMessage();
            imMeetingMessage.setMessageType(1106);
            imMeetingMessage.setMsgTargetType(3);
            imMeetingMessage.setMsgTarget(strUserId);
            imMeetingMessage.setParam(strNewName);
            this.AddMessageToQueue(imMeetingMessage);
        }
        return imMessagePackage;
    }

    protected void OnCreateDisGroupDetail(IMDisGroupDetail imDisGroupDetail) throws Exception {
        CallResult callResult = null;
        if (this.imMeetingServerContext.isLocalMode()) {
            IDEDataCtrl imDisGroupDetailDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl2("IM0098", "SYSTEM", null);
            callResult = imDisGroupDetailDataCtrl.Save(true, (BaseDataEntity)imDisGroupDetail);
        } else {
            IMRemoteDEDataCtrl imDisGroupDetailDataCtrl = new IMRemoteDEDataCtrl();
            imDisGroupDetailDataCtrl.Init("", "IM0098", "SYSTEM");
            callResult = imDisGroupDetailDataCtrl.Save(true, imDisGroupDetail);
        }
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u8ba8\u8bba\u7ec4\u53c2\u4e0e\u4eba\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        callResult = this.getIMModelHelper().GetIMDisGroupDetail(imDisGroupDetail.getIMDISGRPDETAILID(), imDisGroupDetail);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u8ba8\u8bba\u7ec4\u53c2\u4e0e\u4eba\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    protected void OnRemoveDisGroupDetail(IMDisGroupDetail imDisGroupDetail) throws Exception {
        CallResult callResult = null;
        if (this.imMeetingServerContext.isLocalMode()) {
            IDEDataCtrl imDisGroupDetailDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl2("IM0098", "SYSTEM", null);
            callResult = imDisGroupDetailDataCtrl.Remove((BaseDataEntity)imDisGroupDetail);
        } else {
            IMRemoteDEDataCtrl imDisGroupDetailDataCtrl = new IMRemoteDEDataCtrl();
            imDisGroupDetailDataCtrl.Init("", "IM0098", "SYSTEM");
            callResult = imDisGroupDetailDataCtrl.Remove(imDisGroupDetail);
        }
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u5220\u9664\u8ba8\u8bba\u7ec4\u53c2\u4e0e\u4eba\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    protected void OnRemoveDisGroup(IMDisGroup imDisGroup) throws Exception {
        CallResult callResult = null;
        if (this.imMeetingServerContext.isLocalMode()) {
            IDEDataCtrl imDisGroupDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl2("IM0097", "SYSTEM", null);
            callResult = imDisGroupDataCtrl.Remove((BaseDataEntity)imDisGroup);
        } else {
            IMRemoteDEDataCtrl imDisGroupDataCtrl = new IMRemoteDEDataCtrl();
            imDisGroupDataCtrl.Init("", "IM0097", "SYSTEM");
            callResult = imDisGroupDataCtrl.Remove(imDisGroup);
        }
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u5220\u9664\u8ba8\u8bba\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    protected void OnUpdateDisGroup(IMDisGroup imDisGroup) throws Exception {
        CallResult callResult = null;
        if (this.imMeetingServerContext.isLocalMode()) {
            IDEDataCtrl imDisGroupDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl2("IM0097", "SYSTEM", null);
            callResult = imDisGroupDataCtrl.Save(false, (BaseDataEntity)imDisGroup);
        } else {
            IMRemoteDEDataCtrl imDisGroupDataCtrl = new IMRemoteDEDataCtrl();
            imDisGroupDataCtrl.Init("", "IM0097", "SYSTEM");
            callResult = imDisGroupDataCtrl.Save(false, imDisGroup);
        }
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u66f4\u65b0\u8ba8\u8bba\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }
}

