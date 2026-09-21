/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.IM.Ctrl;

import SA.IM.Ctrl.DEDataCtrl.IMRemoteDEDataCtrl;
import SA.IM.Ctrl.Data.IMFile;
import SA.IM.Ctrl.Data.IMMeeting;
import SA.IM.Ctrl.Data.IMMessageLog;
import SA.IM.Ctrl.Data.IMParticipant;
import SA.IM.Ctrl.Data.IMUserFile;
import SA.IM.Ctrl.Data.IMUserMessage;
import SA.IM.Ctrl.IIMCometEvent;
import SA.IM.Ctrl.IIMMeetingContext;
import SA.IM.Ctrl.IIMMeetingInstance;
import SA.IM.Ctrl.IIMMeetingServerContext;
import SA.IM.Ctrl.IIMParticipantInstance;
import SA.IM.Ctrl.IIMRemoteAction;
import SA.IM.Ctrl.IMException;
import SA.IM.Ctrl.IMMessageBase;
import SA.IM.Ctrl.IMMessagePackage;
import SA.IM.Ctrl.IMObjectBase;
import SA.IM.Ctrl.IMParticipantInstance;
import SA.IM.Ctrl.IMRemoteAction;
import SA.IM.Ctrl.IMUserSessionInstance;
import SA.IM.Ctrl.Message.IMMeetingMessage;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Hashtable;
import java.util.Vector;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IMMeetingInstance
extends IMObjectBase
implements IIMMeetingInstance,
IIMMeetingContext {
    public static final int TALKSTATE_CLOSE = 0;
    public static final int TALKSTATE_CALLING = 1;
    public static final int TALKSTATE_TALKING = 2;
    protected IMMeeting imMeeting = null;
    protected Hashtable<String, IIMParticipantInstance> imParticipantMap = new Hashtable();
    private static final Log log = LogFactory.getLog(IMUserSessionInstance.class);
    protected Vector<IMMessageLog> imMessageLogLast = new Vector();
    protected Vector<IMFile> imFileLast = new Vector();
    protected String strActiveTalkId = "";
    protected Date dtTalkTime = null;
    protected Integer nTalkState = 0;
    protected String strTalkStartUserId = "";
    protected Vector<IMMessageBase> imMessageList = new Vector();
    protected IIMMeetingServerContext imMeetingServerContext = null;
    protected boolean bTalking = false;
    private Date activeDate = null;
    private boolean bNotifyClose = false;
    private Vector<BaseDataEntity> saveDataList = new Vector();
    private Hashtable<String, String> fileNameMap = new Hashtable();
    private Hashtable<String, String> welcomeMessageMap = new Hashtable();
    private IMMessageLog imMessageLogLastOne = null;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, IIMMeetingServerContext imMeetingServerContext, IMMeeting imMeeting) throws Exception {
        this.setGlobalHelper(iDAGlobalHelper);
        this.imMeeting = imMeeting;
        this.imMeetingServerContext = imMeetingServerContext;
        this.activeDate = new Date();
        this.OnPrepareParticipants();
        this.OnInit();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void OnPrepareParticipants() throws Exception {
        Vector<IMParticipant> imParticipants = new Vector<IMParticipant>();
        CallResult callResult = this.getIMModelHelper().GetIMParticipants(this.getMeetingId(), imParticipants);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u4f1a\u8bae\u53c2\u4e0e\u4eba\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        Hashtable<String, IIMParticipantInstance> hashtable = this.imParticipantMap;
        synchronized (hashtable) {
            this.imParticipantMap.clear();
            for (IMParticipant imParticipant : imParticipants) {
                IIMParticipantInstance imParticipantInstance = this.OnCreateParticipantInstance(imParticipant);
                imParticipantInstance.Init(this.iDAGlobalHelper, this, imParticipant);
                this.imParticipantMap.put(imParticipantInstance.getUserId(), imParticipantInstance);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void SendWelcomeMessage(String strUserId) throws Exception {
        Vector<IIMParticipantInstance> list = new Vector<IIMParticipantInstance>();
        Hashtable<String, IIMParticipantInstance> hashtable = this.imParticipantMap;
        synchronized (hashtable) {
            list.addAll(this.imParticipantMap.values());
        }
        for (IIMParticipantInstance imParticipantInstance : list) {
            if (StringHelper.Compare((String)imParticipantInstance.getUserId(), (String)strUserId, (boolean)true) == 0) continue;
            imParticipantInstance.SendWelcomeMessage();
        }
    }

    protected IIMParticipantInstance OnCreateParticipantInstance(IMParticipant imParticipant) throws Exception {
        IIMParticipantInstance imParticipantInstance = null;
        String strParticipantObj = imParticipant.GetParamStringValue("PARTICIPANTOBJ", "");
        if (StringHelper.IsNullOrEmpty((String)strParticipantObj)) {
            imParticipantInstance = new IMParticipantInstance();
        } else {
            Object objIMParticipantInstance = ObjectHelper.Create((String)strParticipantObj);
            if (objIMParticipantInstance == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u5bf9\u8c61[%1$s]", (Object)strParticipantObj));
            }
            if (!(objIMParticipantInstance instanceof IIMParticipantInstance)) {
                throw new Exception(StringHelper.Format((String)"\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strParticipantObj));
            }
            imParticipantInstance = (IIMParticipantInstance)objIMParticipantInstance;
        }
        return imParticipantInstance;
    }

    protected void OnInit() throws Exception {
    }

    @Override
    public String getMeetingId() {
        return this.imMeeting.getIMMEETINGID();
    }

    @Override
    public int getMeetingType() {
        if (this.imMeeting.isMEETINGTYPENull()) {
            return 1;
        }
        return this.imMeeting.getMEETINGTYPE();
    }

    @Override
    public IMMessagePackage ProcessRemoteAction(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        return this.OnProcessRemoteAction(iIMRemoteActionContext);
    }

    protected IMMessagePackage OnProcessRemoteAction(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"MEETINGATTEND", (boolean)true) == 0) {
            return this.OnMeetingAttend(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"MEETINGACTIVE", (boolean)true) == 0) {
            return this.OnMeetingActive(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"MEETINGQUIT", (boolean)true) == 0) {
            return this.OnMeetingQuit(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"MEETINGINVITE", (boolean)true) == 0) {
            return this.OnMeetingInvite(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"MEETINGKICKEDOUT", (boolean)true) == 0) {
            return this.OnMeetingKickedOut(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"MEETINGMESSAGE", (boolean)true) == 0) {
            return this.OnMeetingMessage(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"MEETINGMESSAGECONFIRM", (boolean)true) == 0) {
            return this.OnMeetingMessageConfirm(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"MEETINGKEYDOWN", (boolean)true) == 0) {
            return this.OnMeetingKeydown(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"MEETINGFILEUPLOAD", (boolean)true) == 0) {
            return this.OnMeetingFileUpload(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"MEETINGFILEUPLOADED", (boolean)true) == 0) {
            return this.OnMeetingFileUploaded(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"MEETINGFILEDOWNLOADING", (boolean)true) == 0) {
            return this.OnMeetingFileDownloading(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"MEETINGFILEDOWNLOADED", (boolean)true) == 0) {
            return this.OnMeetingFileDownloaded(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"MEETINGTALKCALL", (boolean)true) == 0) {
            return this.OnMeetingTalkCall(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"MEETINGTALKANSWER", (boolean)true) == 0) {
            return this.OnMeetingTalkAnswer(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"MEETINGTALKREJECT", (boolean)true) == 0) {
            return this.OnMeetingTalkReject(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"MEETINGTALKBUSY", (boolean)true) == 0) {
            return this.OnMeetingTalkBusy(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"MEETINGTALKSYNC", (boolean)true) == 0) {
            return this.OnMeetingTalkSync(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"MEETINGTALKCLOSE", (boolean)true) == 0) {
            return this.OnMeetingTalkClose(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"USERSESSIONLOGIN", (boolean)true) == 0) {
            return this.OnUserSessionLogin(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"USERSESSIONLOGOUT", (boolean)true) == 0) {
            return this.OnUserSessionLogout(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"MEETINGRENAME", (boolean)true) == 0) {
            return this.OnMeetingRename(iIMRemoteActionContext);
        }
        throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u5904\u7406\u7684\u8fdc\u7a0b\u8bf7\u6c42[%1$s]", (Object)iIMRemoteActionContext.getAction()));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected IMMessagePackage OnMeetingAttend(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        String strUserId = iIMRemoteActionContext.getParam("USERID", "");
        if (StringHelper.IsNullOrEmpty((String)strUserId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7528\u6237\u6807\u8bc6");
        }
        String strUserSessionId = iIMRemoteActionContext.getParam("USERSESSIONID", "");
        if (StringHelper.IsNullOrEmpty((String)strUserSessionId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7528\u6237\u4f1a\u8bdd\u6807\u8bc6");
        }
        IIMParticipantInstance imParticipantInstance = this.GetParticipantInstance(strUserId, strUserSessionId, true);
        imParticipantInstance.Attend(strUserSessionId, iIMRemoteActionContext);
        String strName = "";
        Hashtable<String, IIMParticipantInstance> hashtable = this.imParticipantMap;
        synchronized (hashtable) {
            int nIndex = 2;
            for (IIMParticipantInstance imParticipantInstanceOther : this.imParticipantMap.values()) {
                if (imParticipantInstanceOther == imParticipantInstance) {
                    imMessagePackage.setExtInfo(StringHelper.Format((String)"USERID", (Object)nIndex), imParticipantInstanceOther.getUserId());
                    imMessagePackage.setExtInfo(StringHelper.Format((String)"USERNAME", (Object)nIndex), imParticipantInstanceOther.getUserName());
                    imMessagePackage.setExtInfo(StringHelper.Format((String)"ISADMIN", (Object)nIndex), imParticipantInstanceOther.isAdmin());
                    continue;
                }
                imMessagePackage.setExtInfo(StringHelper.Format((String)"USERID%1$s", (Object)nIndex), imParticipantInstanceOther.getUserId());
                imMessagePackage.setExtInfo(StringHelper.Format((String)"USERNAME%1$s", (Object)nIndex), imParticipantInstanceOther.getUserName());
                imMessagePackage.setExtInfo(StringHelper.Format((String)"ISADMIN%1$s", (Object)nIndex), imParticipantInstanceOther.isAdmin());
                ++nIndex;
                if (!StringHelper.IsNullOrEmpty((String)strName)) {
                    strName = String.valueOf(strName) + ",";
                }
                strName = String.valueOf(strName) + imParticipantInstanceOther.getUserName();
            }
        }
        if (this.imMessageLogLastOne != null) {
            imMessagePackage.setExtInfo("LASTMESSAGE", this.imMessageLogLastOne.getMESSAGE());
        } else {
            imMessagePackage.setExtInfo("LASTMESSAGE", this.imMeeting.getLASTMESSAGE());
        }
        int nMeetingType = this.imMeeting.getMEETINGTYPE();
        if (nMeetingType <= 0) {
            nMeetingType = 1;
        }
        imMessagePackage.setExtInfo("MEETINGTYPE", StringHelper.Format((String)"%1$s", (Object)nMeetingType));
        if (nMeetingType == 1) {
            imMessagePackage.setExtInfo("MEETINGNAME", strName);
        }
        if (!this.bNotifyClose && imParticipantInstance.getChatWindow()) {
            this.SendWelcomeMessage(strUserId);
        }
        return imMessagePackage;
    }

    protected IMMessagePackage OnMeetingQuit(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        String strUserId = iIMRemoteActionContext.getParam("USERID", "");
        if (StringHelper.IsNullOrEmpty((String)strUserId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7528\u6237\u6807\u8bc6");
        }
        String strUserSessionId = iIMRemoteActionContext.getParam("USERSESSIONID", "");
        if (StringHelper.IsNullOrEmpty((String)strUserSessionId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7528\u6237\u4f1a\u8bdd\u6807\u8bc6");
        }
        IIMParticipantInstance imParticipantInstance = this.GetParticipantInstance(strUserId, strUserSessionId);
        imParticipantInstance.Quit();
        return imMessagePackage;
    }

    protected IMMessagePackage OnMeetingActive(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        String strUserId = iIMRemoteActionContext.getParam("USERID", "");
        if (StringHelper.IsNullOrEmpty((String)strUserId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7528\u6237\u6807\u8bc6");
        }
        String strUserSessionId = iIMRemoteActionContext.getParam("USERSESSIONID", "");
        if (StringHelper.IsNullOrEmpty((String)strUserSessionId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7528\u6237\u4f1a\u8bdd\u6807\u8bc6");
        }
        IIMParticipantInstance imParticipantInstance = this.GetParticipantInstance(strUserId, strUserSessionId);
        this.Active();
        imParticipantInstance.Active();
        return imMessagePackage;
    }

    protected IMMessagePackage OnMeetingMessageConfirm(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        String[] messageIds;
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        String strUserId = iIMRemoteActionContext.getParam("USERID", "");
        if (StringHelper.IsNullOrEmpty((String)strUserId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7528\u6237\u6807\u8bc6");
        }
        String strUserSessionId = iIMRemoteActionContext.getParam("USERSESSIONID", "");
        if (StringHelper.IsNullOrEmpty((String)strUserSessionId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7528\u6237\u4f1a\u8bdd\u6807\u8bc6");
        }
        IIMParticipantInstance imParticipantInstance = this.GetParticipantInstance(strUserId, strUserSessionId);
        String strMessageLogIds = iIMRemoteActionContext.getParam("MESSAGELOGID", "");
        if (StringHelper.IsNullOrEmpty((String)strMessageLogIds) && StringHelper.IsNullOrEmpty((String)(strMessageLogIds = iIMRemoteActionContext.getContent()))) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u4f1a\u8bae\u6d88\u606f\u6807\u8bc6");
        }
        String[] stringArray = messageIds = strMessageLogIds.split("[;]");
        int n = messageIds.length;
        int n2 = 0;
        while (n2 < n) {
            String strMessageLogId = stringArray[n2];
            if (!StringHelper.IsNullOrEmpty((String)strMessageLogId)) {
                IMUserMessage imUserMessage = new IMUserMessage();
                imUserMessage.setIMUSERMESSAGEID(StringHelper.Format((String)"%1$s_%2$s", (Object)strMessageLogId, (Object)imParticipantInstance.getUserId()));
                imUserMessage.setRECVFLAG(true);
                this.AsyncSaveData(false, imUserMessage);
            }
            ++n2;
        }
        IMMeetingMessage imMeetingMessage = new IMMeetingMessage();
        imMeetingMessage.setMessageType(1010);
        imMeetingMessage.setMessageId(strMessageLogIds);
        imMeetingMessage.setFromUserId(imParticipantInstance.getUserId());
        imMeetingMessage.setFromUserName(imParticipantInstance.getUserName());
        imMeetingMessage.setMsgTargetType(3);
        imMeetingMessage.setMsgTarget(imParticipantInstance.getUserId());
        imMeetingMessage.setTime(StringHelper.Format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)new Date()));
        this.AddMessageToQueue(imMeetingMessage);
        this.Active();
        return imMessagePackage;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected IMMessagePackage OnMeetingMessage(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        String strUserId = iIMRemoteActionContext.getParam("USERID", "");
        if (StringHelper.IsNullOrEmpty((String)strUserId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7528\u6237\u6807\u8bc6");
        }
        String strUserSessionId = iIMRemoteActionContext.getParam("USERSESSIONID", "");
        if (StringHelper.IsNullOrEmpty((String)strUserSessionId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7528\u6237\u4f1a\u8bdd\u6807\u8bc6");
        }
        IIMParticipantInstance imParticipantInstance = this.GetParticipantInstance(strUserId, strUserSessionId);
        IMMessageLog imMessageLog = new IMMessageLog();
        imMessageLog.setIMMEETINGID(this.getMeetingId());
        imMessageLog.setIMUSERID(imParticipantInstance.getUserId());
        imMessageLog.setIMUSERNAME(imParticipantInstance.getUserName());
        imMessageLog.setCONTENT(iIMRemoteActionContext.getContent());
        JSONObject contentJO = null;
        if (!StringHelper.IsNullOrEmpty((String)iIMRemoteActionContext.getContent()) && (contentJO = JSONObject.fromString((String)iIMRemoteActionContext.getContent())).has("message")) {
            imMessageLog.setMESSAGE(contentJO.getString("message"));
        }
        this.OnCreateMessageLog(imMessageLog);
        Vector<IMMessageLog> vector = this.imMessageLogLast;
        synchronized (vector) {
            if (this.imMessageLogLast.size() > 250) {
                this.imMessageLogLast.remove(0);
            }
            this.imMessageLogLast.add(imMessageLog);
        }
        this.imMessageLogLastOne = imMessageLog;
        IMMeetingMessage imMeetingMessage = new IMMeetingMessage();
        imMeetingMessage.setMessageId(imMessageLog.getIMMESSAGELOGID());
        imMeetingMessage.setContent(imMessageLog.getCONTENT());
        imMeetingMessage.setFromUserId(imMessageLog.getIMUSERID());
        imMeetingMessage.setFromUserName(imMessageLog.getIMUSERNAME());
        imMeetingMessage.setMessageType(1000);
        imMeetingMessage.setMsgTargetType(3);
        imMeetingMessage.setMsgTarget(imMessageLog.getIMUSERID());
        imMeetingMessage.setTime(StringHelper.Format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)imMessageLog.getSENDTIME()));
        imMeetingMessage.setContentObject(contentJO);
        imMeetingMessage.setMessage(imMessageLog.getMESSAGE());
        this.AddMessageToQueue(imMeetingMessage);
        this.Active();
        imMessagePackage.setExtInfo("MESSAGELOGID", imMessageLog.getIMMESSAGELOGID());
        return imMessagePackage;
    }

    protected boolean isTalking() {
        return this.bTalking;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected IMMessagePackage OnMeetingTalkCall(IIMRemoteAction iIMRemoteActionContext) throws Exception {
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
        Serializable serializable = this.imParticipantMap;
        synchronized (serializable) {
            imParticipantInstance = this.imParticipantMap.get(strUserId);
        }
        if (imParticipantInstance == null) {
            throw new IMException(10004);
        }
        if (StringHelper.IsNullOrEmpty((String)imParticipantInstance.getUserSessionId())) {
            imParticipantInstance.setUserSessionId(strUserSessionId);
        } else if (StringHelper.Compare((String)strUserSessionId, (String)imParticipantInstance.getUserSessionId(), (boolean)true) != 0) {
            throw new IMException(10001);
        }
        if (this.imParticipantMap.size() > 2) {
            throw new Exception("\u4f1a\u8bdd\u4eba\u6570\u5927\u4e8e2\u4eba\uff0c\u65e0\u6cd5\u8fdb\u884c\u8bed\u97f3\u6216\u89c6\u9891\u4ea4\u8c08");
        }
        serializable = this.nTalkState;
        synchronized (serializable) {
            switch (this.nTalkState) {
                case 1: {
                    if (StringHelper.Compare((String)strUserId, (String)this.strTalkStartUserId, (boolean)true) == 0) {
                        throw new Exception("\u6b63\u5728\u547c\u53eb\u5bf9\u65b9");
                    }
                    throw new Exception("\u5bf9\u65b9\u6b63\u5728\u547c\u53eb");
                }
                case 2: {
                    throw new Exception("\u4ea4\u8c08\u8fc7\u7a0b\u4e2d\uff0c\u65e0\u6cd5\u7ee7\u7eed\u547c\u53eb");
                }
                case 0: {
                    this.strTalkStartUserId = strUserId;
                    this.nTalkState = 1;
                    this.dtTalkTime = new Date();
                }
            }
        }
        String strVideo = iIMRemoteActionContext.getParam("VIDEO", "");
        boolean bVideo = StringHelper.Compare((String)strVideo, (String)"TRUE", (boolean)true) == 0;
        String strTalkId = bVideo ? "VIDEOTALK_" : "VOICETALK_";
        strTalkId = String.valueOf(strTalkId) + Helper.GenGuidEx();
        imMessagePackage.setExtInfo("TALKID", strTalkId);
        IMMeetingMessage imMeetingMessage = new IMMeetingMessage();
        imMeetingMessage.setMessageType(1002);
        imMeetingMessage.setFromUserId(strUserId);
        imMeetingMessage.setFromUserName(imParticipantInstance.getUserName());
        imMeetingMessage.setTalkId(strTalkId);
        imMeetingMessage.setVideo(bVideo);
        imMeetingMessage.setMsgTargetType(3);
        imMeetingMessage.setMsgTarget(strUserId);
        imMeetingMessage.setTime(StringHelper.Format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)this.dtTalkTime));
        this.AddMessageToQueue(imMeetingMessage);
        return imMessagePackage;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected IMMessagePackage OnMeetingTalkAnswer(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        String strUserId = iIMRemoteActionContext.getParam("USERID", "");
        if (StringHelper.IsNullOrEmpty((String)strUserId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7528\u6237\u6807\u8bc6");
        }
        IIMParticipantInstance imParticipantInstance = null;
        Serializable serializable = this.imParticipantMap;
        synchronized (serializable) {
            imParticipantInstance = this.imParticipantMap.get(strUserId);
        }
        if (imParticipantInstance == null) {
            throw new IMException(10004);
        }
        if (this.imParticipantMap.size() > 2) {
            throw new Exception("\u4f1a\u8bdd\u4eba\u6570\u5bf9\u4e8e2\u4eba\uff0c\u65e0\u6cd5\u8fdb\u884c\u8bed\u97f3\u6216\u89c6\u9891\u4ea4\u8c08");
        }
        serializable = this.nTalkState;
        synchronized (serializable) {
            switch (this.nTalkState) {
                case 1: {
                    if (StringHelper.Compare((String)strUserId, (String)this.strTalkStartUserId, (boolean)true) == 0) {
                        throw new Exception("\u65e0\u6548\u5e94\u7b54");
                    }
                    this.nTalkState = 2;
                    Hashtable<String, IIMParticipantInstance> hashtable = this.imParticipantMap;
                    synchronized (hashtable) {
                        for (IIMParticipantInstance item : this.imParticipantMap.values()) {
                            item.ActiveTalking();
                        }
                        break;
                    }
                }
                case 2: {
                    throw new Exception("\u4ea4\u8c08\u8fc7\u7a0b\u4e2d\uff0c\u65e0\u6cd5\u5e94\u7b54");
                }
                case 0: {
                    throw new Exception("\u65e0\u6548\u5e94\u7b54");
                }
            }
        }
        IMMeetingMessage imMeetingMessage = new IMMeetingMessage();
        imMeetingMessage.setMessageType(1003);
        imMeetingMessage.setFromUserId(strUserId);
        imMeetingMessage.setFromUserName(imParticipantInstance.getUserName());
        imMeetingMessage.setTalkId(this.strActiveTalkId);
        imMeetingMessage.setMsgTargetType(3);
        imMeetingMessage.setMsgTarget(strUserId);
        this.AddMessageToQueue(imMeetingMessage);
        return imMessagePackage;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected IMMessagePackage OnMeetingTalkReject(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        String strUserId = iIMRemoteActionContext.getParam("USERID", "");
        if (StringHelper.IsNullOrEmpty((String)strUserId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7528\u6237\u6807\u8bc6");
        }
        String strUserSessionId = iIMRemoteActionContext.getParam("USERSESSIONID", "");
        if (StringHelper.IsNullOrEmpty((String)strUserSessionId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7528\u6237\u4f1a\u8bdd\u6807\u8bc6");
        }
        IIMParticipantInstance imParticipantInstance = this.GetParticipantInstance(strUserId, strUserSessionId);
        if (this.imParticipantMap.size() > 2) {
            throw new Exception("\u4f1a\u8bdd\u4eba\u6570\u5927\u4e8e2\u4eba\uff0c\u65e0\u6cd5\u8fdb\u884c\u8bed\u97f3\u6216\u89c6\u9891\u4ea4\u8c08");
        }
        Integer n = this.nTalkState;
        synchronized (n) {
            switch (this.nTalkState) {
                case 1: {
                    if (StringHelper.Compare((String)strUserId, (String)this.strTalkStartUserId, (boolean)true) == 0) {
                        throw new Exception("\u65e0\u6548\u62d2\u7edd");
                    }
                    this.nTalkState = 0;
                    break;
                }
                case 2: {
                    throw new Exception("\u4ea4\u8c08\u8fc7\u7a0b\u4e2d\uff0c\u65e0\u6cd5\u62d2\u7edd");
                }
                case 0: {
                    throw new Exception("\u65e0\u6548\u62d2\u7edd");
                }
            }
        }
        IMMeetingMessage imMeetingMessage = new IMMeetingMessage();
        imMeetingMessage.setMessageType(1004);
        imMeetingMessage.setFromUserId(strUserId);
        imMeetingMessage.setFromUserName(imParticipantInstance.getUserName());
        imMeetingMessage.setTalkId(this.strActiveTalkId);
        imMeetingMessage.setMsgTargetType(3);
        imMeetingMessage.setMsgTarget(strUserId);
        this.AddMessageToQueue(imMeetingMessage);
        this.strActiveTalkId = "";
        return imMessagePackage;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected IMMessagePackage OnMeetingTalkBusy(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        String strUserId = iIMRemoteActionContext.getParam("USERID", "");
        if (StringHelper.IsNullOrEmpty((String)strUserId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7528\u6237\u6807\u8bc6");
        }
        String strUserSessionId = iIMRemoteActionContext.getParam("USERSESSIONID", "");
        if (StringHelper.IsNullOrEmpty((String)strUserSessionId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7528\u6237\u4f1a\u8bdd\u6807\u8bc6");
        }
        IIMParticipantInstance imParticipantInstance = this.GetParticipantInstance(strUserId, strUserSessionId);
        if (this.imParticipantMap.size() > 2) {
            throw new Exception("\u4f1a\u8bdd\u4eba\u6570\u5927\u4e8e2\u4eba\uff0c\u65e0\u6cd5\u8fdb\u884c\u8bed\u97f3\u6216\u89c6\u9891\u4ea4\u8c08");
        }
        Integer n = this.nTalkState;
        synchronized (n) {
            switch (this.nTalkState) {
                case 1: {
                    if (StringHelper.Compare((String)strUserId, (String)this.strTalkStartUserId, (boolean)true) == 0) {
                        throw new Exception("\u65e0\u6548\u62d2\u7edd");
                    }
                    this.nTalkState = 0;
                    break;
                }
                case 2: {
                    throw new Exception("\u4ea4\u8c08\u8fc7\u7a0b\u4e2d\uff0c\u65e0\u6cd5\u63a7\u5236");
                }
                case 0: {
                    throw new Exception("\u65e0\u6cd5\u63a7\u5236");
                }
            }
        }
        IMMeetingMessage imMeetingMessage = new IMMeetingMessage();
        imMeetingMessage.setMessageType(1009);
        imMeetingMessage.setFromUserId(strUserId);
        imMeetingMessage.setFromUserName(imParticipantInstance.getUserName());
        imMeetingMessage.setTalkId(this.strActiveTalkId);
        imMeetingMessage.setMsgTargetType(3);
        imMeetingMessage.setMsgTarget(strUserId);
        this.AddMessageToQueue(imMeetingMessage);
        this.strActiveTalkId = "";
        return imMessagePackage;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected IMMessagePackage OnMeetingTalkSync(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        String strUserId = iIMRemoteActionContext.getParam("USERID", "");
        if (StringHelper.IsNullOrEmpty((String)strUserId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7528\u6237\u6807\u8bc6");
        }
        IIMParticipantInstance imParticipantInstance = null;
        Serializable serializable = this.imParticipantMap;
        synchronized (serializable) {
            imParticipantInstance = this.imParticipantMap.get(strUserId);
        }
        if (imParticipantInstance == null) {
            throw new IMException(10004);
        }
        if (this.imParticipantMap.size() > 2) {
            throw new Exception("\u4f1a\u8bdd\u4eba\u6570\u5927\u4e8e2\u4eba\uff0c\u65e0\u6cd5\u8fdb\u884c\u8bed\u97f3\u6216\u89c6\u9891\u4ea4\u8c08");
        }
        serializable = this.nTalkState;
        synchronized (serializable) {
            switch (this.nTalkState) {
                case 1: {
                    throw new Exception("\u65e0\u6548\u4f1a\u8bdd\u63a7\u5236");
                }
                case 2: {
                    imParticipantInstance.ActiveTalking();
                    break;
                }
                case 0: {
                    throw new Exception("\u65e0\u6548\u4f1a\u8bdd\u63a7\u5236");
                }
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)iIMRemoteActionContext.getContent())) {
            IMMeetingMessage imMeetingMessage = new IMMeetingMessage();
            imMeetingMessage.setMessageType(1006);
            imMeetingMessage.setFromUserId(strUserId);
            imMeetingMessage.setFromUserName(imParticipantInstance.getUserName());
            imMeetingMessage.setTalkId(this.strActiveTalkId);
            imMeetingMessage.setMsgTargetType(3);
            imMeetingMessage.setMsgTarget(strUserId);
            imMeetingMessage.setContent(iIMRemoteActionContext.getContent());
            this.AddMessageToQueue(imMeetingMessage);
        }
        return imMessagePackage;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected IMMessagePackage OnMeetingTalkClose(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        String strUserId = iIMRemoteActionContext.getParam("USERID", "");
        if (StringHelper.IsNullOrEmpty((String)strUserId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7528\u6237\u6807\u8bc6");
        }
        IIMParticipantInstance imParticipantInstance = null;
        Serializable serializable = this.imParticipantMap;
        synchronized (serializable) {
            imParticipantInstance = this.imParticipantMap.get(strUserId);
        }
        if (imParticipantInstance == null) {
            throw new IMException(10004);
        }
        if (this.imParticipantMap.size() > 2) {
            throw new Exception("\u4f1a\u8bdd\u4eba\u6570\u5927\u4e8e2\u4eba\uff0c\u65e0\u6cd5\u8fdb\u884c\u8bed\u97f3\u6216\u89c6\u9891\u4ea4\u8c08");
        }
        serializable = this.nTalkState;
        synchronized (serializable) {
            switch (this.nTalkState) {
                case 1: {
                    if (StringHelper.Compare((String)strUserId, (String)this.strTalkStartUserId, (boolean)true) == 0) {
                        this.nTalkState = 0;
                        break;
                    }
                    throw new Exception("\u65e0\u6548\u4f1a\u8bdd\u63a7\u5236");
                }
                case 2: {
                    this.nTalkState = 0;
                    break;
                }
                case 0: {
                    throw new Exception("\u65e0\u6548\u4f1a\u8bdd\u63a7\u5236");
                }
            }
        }
        IMMeetingMessage imMeetingMessage = new IMMeetingMessage();
        imMeetingMessage.setMessageType(1005);
        imMeetingMessage.setFromUserId(strUserId);
        imMeetingMessage.setFromUserName(imParticipantInstance.getUserName());
        imMeetingMessage.setTalkId(this.strActiveTalkId);
        imMeetingMessage.setMsgTargetType(1);
        imMeetingMessage.setContent(iIMRemoteActionContext.getContent());
        this.AddMessageToQueue(imMeetingMessage);
        this.strActiveTalkId = "";
        return imMessagePackage;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected IMMessagePackage OnMeetingFileUpload(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        String strUserId = iIMRemoteActionContext.getParam("USERID", "");
        if (StringHelper.IsNullOrEmpty((String)strUserId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7528\u6237\u6807\u8bc6");
        }
        IIMParticipantInstance imParticipantInstance = null;
        Hashtable<String, IIMParticipantInstance> hashtable = this.imParticipantMap;
        synchronized (hashtable) {
            imParticipantInstance = this.imParticipantMap.get(strUserId);
        }
        if (imParticipantInstance == null) {
            throw new IMException(10004);
        }
        String strFileName = iIMRemoteActionContext.getParam("FILENAME", "");
        if (StringHelper.IsNullOrEmpty((String)strFileName)) {
            throw new IMException(10005);
        }
        if (!this.imMeetingServerContext.isLocalMode()) {
            IMRemoteAction imRemoteAction = (IMRemoteAction)iIMRemoteActionContext;
            imRemoteAction.setParam("IMMEETINGID", this.getMeetingId());
            IMMessagePackage imMsgPackage = this.imMeetingServerContext.SendRemoteAction((IMRemoteAction)iIMRemoteActionContext);
            IMFile imFile = new IMFile();
            String strFileId = imMsgPackage.getExtInfo("FILEID", "");
            imFile.setIMFILEID(strFileId);
            imFile.setIMFILENAME(strFileName);
            Hashtable<String, String> hashtable2 = this.fileNameMap;
            synchronized (hashtable2) {
                this.fileNameMap.put(imFile.getIMFILEID(), strFileName);
            }
            this.Active();
            return imMsgPackage;
        }
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        IMFile imFile = new IMFile();
        imFile.setIMMEETINGID(this.getMeetingId());
        imFile.setIMFILENAME(strFileName);
        imFile.setIMUSERID(strUserId);
        imFile.setIMMTSERVERID(this.imMeetingServerContext.getServerId());
        this.OnCreateFile(imFile);
        Hashtable<String, String> hashtable3 = this.fileNameMap;
        synchronized (hashtable3) {
            this.fileNameMap.put(imFile.getIMFILEID(), strFileName);
        }
        this.Active();
        imMessagePackage.setExtInfo("FILEID", imFile.getIMFILEID());
        imMessagePackage.setExtInfo("SERVERPATH", this.imMeetingServerContext.getFtpServerPath());
        imMessagePackage.setExtInfo("LOGINNAME", imFile.getIMFILEID());
        return imMessagePackage;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected IMMessagePackage OnMeetingFileUploaded(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        String strUserId = iIMRemoteActionContext.getParam("USERID", "");
        if (StringHelper.IsNullOrEmpty((String)strUserId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7528\u6237\u6807\u8bc6");
        }
        IIMParticipantInstance imParticipantInstance = null;
        Hashtable<String, IIMParticipantInstance> hashtable = this.imParticipantMap;
        synchronized (hashtable) {
            imParticipantInstance = this.imParticipantMap.get(strUserId);
        }
        if (imParticipantInstance == null) {
            throw new IMException(10004);
        }
        String strFileId = iIMRemoteActionContext.getParam("FILEID", "");
        if (StringHelper.IsNullOrEmpty((String)strFileId)) {
            throw new IMException(10005);
        }
        Date date = new Date();
        IMFile imFile = new IMFile();
        imFile.setIMFILEID(strFileId);
        imFile.setUPLOADFINISH(true);
        imFile.SetParamValue("SENDTIME", new Timestamp(date.getTime()));
        this.OnUpdateFile(imFile);
        Vector<IMFile> vector = this.imFileLast;
        synchronized (vector) {
            if (this.imFileLast.size() > 100) {
                this.imFileLast.remove(0);
            }
            this.imFileLast.add(imFile);
        }
        this.Active();
        String strFileName = "";
        Hashtable<String, String> hashtable2 = this.fileNameMap;
        synchronized (hashtable2) {
            strFileName = this.fileNameMap.get(strFileId);
        }
        IMMessageLog imMessageLog = new IMMessageLog();
        imMessageLog.setIMMESSAGELOGID(strFileId);
        imMessageLog.setIMMEETINGID(this.getMeetingId());
        imMessageLog.setIMUSERID(imParticipantInstance.getUserId());
        imMessageLog.setIMUSERNAME(imParticipantInstance.getUserName());
        imMessageLog.setCONTENT(StringHelper.Format((String)"%1$s\u53d1\u9001\u6587\u4ef6%2$s", (Object)imParticipantInstance.getUserName(), (Object)strFileName));
        imMessageLog.setMESSAGE(StringHelper.Format((String)"%1$s\u53d1\u9001\u6587\u4ef6%2$s", (Object)imParticipantInstance.getUserName(), (Object)strFileName));
        imMessageLog.setFILEID(strFileId);
        imMessageLog.setFILENAME(strFileName);
        this.OnCreateMessageLog(imMessageLog);
        Vector<IMMessageLog> vector2 = this.imMessageLogLast;
        synchronized (vector2) {
            if (this.imMessageLogLast.size() > 250) {
                this.imMessageLogLast.remove(0);
            }
            this.imMessageLogLast.add(imMessageLog);
        }
        IMMeetingMessage imMeetingMessage = new IMMeetingMessage();
        imMeetingMessage.setFileId(imFile.getIMFILEID());
        imMeetingMessage.setFileName(strFileName);
        imMeetingMessage.setFromUserId(imParticipantInstance.getUserId());
        imMeetingMessage.setFromUserName(imParticipantInstance.getUserName());
        imMeetingMessage.setMessageType(1001);
        imMeetingMessage.setMsgTargetType(3);
        imMeetingMessage.setMsgTarget(imParticipantInstance.getUserId());
        imMeetingMessage.setTime(StringHelper.Format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)imFile.getUPDATEDATE()));
        this.AddMessageToQueue(imMeetingMessage);
        imMessagePackage.setExtInfo("MESSAGELOGID", imMessageLog.getIMMESSAGELOGID());
        return imMessagePackage;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected IMMessagePackage OnMeetingFileDownloaded(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        String strUserId = iIMRemoteActionContext.getParam("USERID", "");
        if (StringHelper.IsNullOrEmpty((String)strUserId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7528\u6237\u6807\u8bc6");
        }
        IIMParticipantInstance imParticipantInstance = null;
        Hashtable<String, IIMParticipantInstance> hashtable = this.imParticipantMap;
        synchronized (hashtable) {
            imParticipantInstance = this.imParticipantMap.get(strUserId);
        }
        if (imParticipantInstance == null) {
            throw new IMException(10004);
        }
        this.Active();
        IMMessageLog imMessageLog = new IMMessageLog();
        imMessageLog.setIMMEETINGID(this.getMeetingId());
        imMessageLog.setIMUSERID(imParticipantInstance.getUserId());
        imMessageLog.setIMUSERNAME(imParticipantInstance.getUserName());
        imMessageLog.setCONTENT(iIMRemoteActionContext.getContent());
        imMessageLog.setMESSAGE(iIMRemoteActionContext.getContent());
        this.OnCreateMessageLog(imMessageLog);
        Vector<IMMessageLog> vector = this.imMessageLogLast;
        synchronized (vector) {
            if (this.imMessageLogLast.size() > 250) {
                this.imMessageLogLast.remove(0);
            }
            this.imMessageLogLast.add(imMessageLog);
        }
        imMessagePackage.setExtInfo("MESSAGELOGID", imMessageLog.getIMMESSAGELOGID());
        return imMessagePackage;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected IMMessagePackage OnMeetingKeydown(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        String strUserId = iIMRemoteActionContext.getParam("USERID", "");
        if (StringHelper.IsNullOrEmpty((String)strUserId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7528\u6237\u6807\u8bc6");
        }
        IIMParticipantInstance imParticipantInstance = null;
        Hashtable<String, IIMParticipantInstance> hashtable = this.imParticipantMap;
        synchronized (hashtable) {
            imParticipantInstance = this.imParticipantMap.get(strUserId);
        }
        if (imParticipantInstance == null) {
            throw new IMException(10004);
        }
        this.Active();
        IMMeetingMessage imMeetingMessage = new IMMeetingMessage();
        imMeetingMessage.setFromUserId(imParticipantInstance.getUserId());
        imMeetingMessage.setFromUserName(imParticipantInstance.getUserName());
        imMeetingMessage.setMessageType(1008);
        imMeetingMessage.setMsgTargetType(3);
        imMeetingMessage.setMsgTarget(imParticipantInstance.getUserId());
        this.AddMessageToQueue(imMeetingMessage);
        return imMessagePackage;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected IMMessagePackage OnMeetingFileDownloading(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        String strUserId = iIMRemoteActionContext.getParam("USERID", "");
        if (StringHelper.IsNullOrEmpty((String)strUserId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7528\u6237\u6807\u8bc6");
        }
        IIMParticipantInstance imParticipantInstance = null;
        Hashtable<String, IIMParticipantInstance> hashtable = this.imParticipantMap;
        synchronized (hashtable) {
            imParticipantInstance = this.imParticipantMap.get(strUserId);
        }
        if (imParticipantInstance == null) {
            throw new IMException(10004);
        }
        String strFileId = iIMRemoteActionContext.getParam("FILEID", "");
        String strFileName = "";
        Hashtable<String, String> hashtable2 = this.fileNameMap;
        synchronized (hashtable2) {
            strFileName = this.fileNameMap.get(strFileId);
        }
        IMMessageLog imMessageLog = new IMMessageLog();
        imMessageLog.setIMMEETINGID(this.getMeetingId());
        imMessageLog.setIMUSERID(imParticipantInstance.getUserId());
        imMessageLog.setIMUSERNAME(imParticipantInstance.getUserName());
        imMessageLog.setCONTENT(StringHelper.Format((String)"%1$s\u53d1\u9001\u6587\u4ef6%2$s", (Object)imParticipantInstance.getUserName(), (Object)strFileName));
        imMessageLog.setMESSAGE(StringHelper.Format((String)"%1$s\u53d1\u9001\u6587\u4ef6%2$s", (Object)imParticipantInstance.getUserName(), (Object)strFileName));
        this.OnCreateMessageLog(imMessageLog);
        Vector<IMMessageLog> vector = this.imMessageLogLast;
        synchronized (vector) {
            if (this.imMessageLogLast.size() > 250) {
                this.imMessageLogLast.remove(0);
            }
            this.imMessageLogLast.add(imMessageLog);
        }
        this.Active();
        return imMessagePackage;
    }

    protected void OnCreateMessageLog(IMMessageLog imMessageLog) throws Exception {
        Date date = new Date();
        if (StringHelper.IsNullOrEmpty((String)imMessageLog.getIMMESSAGELOGID())) {
            imMessageLog.setIMMESSAGELOGID(Helper.GenGuidEx());
        }
        imMessageLog.SetParamValue("SENDTIME", new Timestamp(date.getTime()));
        this.AsyncSaveData(true, imMessageLog);
        IMUserMessage imUserMessage = new IMUserMessage();
        imUserMessage.setIMUSERMESSAGEID(StringHelper.Format((String)"%1$s_%2$s", (Object)imMessageLog.getIMMESSAGELOGID(), (Object)imMessageLog.getIMUSERID()));
        imUserMessage.setSENDERFLAG(true);
        imUserMessage.setIMMESSAGELOGID(imMessageLog.getIMMESSAGELOGID());
        imUserMessage.setIMUSERID(imMessageLog.getIMUSERID());
        this.AsyncSaveData(true, imUserMessage);
    }

    protected void OnCreateFile(IMFile imFile) throws Exception {
        Date date = new Date();
        if (StringHelper.IsNullOrEmpty((String)imFile.getIMFILEID())) {
            imFile.setIMFILEID(Helper.GenGuidEx());
        }
        imFile.SetParamValue("SENDTIME", new Timestamp(date.getTime()));
        this.AsyncSaveData(true, imFile);
        IMUserFile imUserFile = new IMUserFile();
        imUserFile.setIMFILEID(StringHelper.Format((String)"%1$s_%2$s", (Object)imFile.getIMFILEID(), (Object)imFile.getIMUSERID()));
        imUserFile.setSENDERFLAG(true);
        imUserFile.setIMFILEID(imFile.getIMFILEID());
        imUserFile.setIMUSERID(imFile.getIMUSERID());
        this.AsyncSaveData(true, imUserFile);
    }

    protected void OnUpdateFile(IMFile imFile) throws Exception {
        this.AsyncSaveData(false, imFile);
    }

    protected void OnCreateParticipant(IMParticipant imParticipant) throws Exception {
        CallResult callResult = null;
        if (this.imMeetingServerContext.isLocalMode()) {
            IDEDataCtrl participantDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl2("IM0081", "SYSTEM", null);
            callResult = participantDataCtrl.Save(true, (BaseDataEntity)imParticipant);
        } else {
            IMRemoteDEDataCtrl participantDataCtrl = new IMRemoteDEDataCtrl();
            participantDataCtrl.Init("", "IM0081", "SYSTEM");
            callResult = participantDataCtrl.Save(true, imParticipant);
        }
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u4f1a\u8bae\u53c2\u4e0e\u4eba\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        callResult = this.getIMModelHelper().GetIMParticipant(imParticipant.getIMPARTICIPANTID(), imParticipant);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u4f1a\u8bae\u53c2\u4e0e\u4eba\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
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
            Hashtable<String, IIMParticipantInstance> hashtable = this.imParticipantMap;
            synchronized (hashtable) {
                imParticipantInstance = this.imParticipantMap.get(strUserId);
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
                Hashtable<String, IIMParticipantInstance> hashtable2 = this.imParticipantMap;
                synchronized (hashtable2) {
                    imParticipantInstanceInvite = this.imParticipantMap.get(strInviteUserId);
                }
                if (imParticipantInstanceInvite == null) {
                    IMParticipant imParticipant = new IMParticipant();
                    imParticipant.setIMMEETINGID(this.imMeeting.getIMMEETINGID());
                    imParticipant.setIMUSERID(strInviteUserId);
                    this.OnCreateParticipant(imParticipant);
                    imParticipantInstanceInvite = this.OnCreateParticipantInstance(imParticipant);
                    imParticipantInstanceInvite.Init(this.iDAGlobalHelper, this, imParticipant);
                    Hashtable<String, IIMParticipantInstance> hashtable3 = this.imParticipantMap;
                    synchronized (hashtable3) {
                        this.imParticipantMap.put(imParticipantInstanceInvite.getUserId(), imParticipantInstanceInvite);
                    }
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
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
            Hashtable<String, IIMParticipantInstance> hashtable = this.imParticipantMap;
            synchronized (hashtable) {
                imParticipantInstance = this.imParticipantMap.get(strUserId);
                imParticipantInstanceKickedOut = this.imParticipantMap.get(strKickedOutUserId);
            }
            if (imParticipantInstance == null) {
                throw new IMException(10004);
            }
            if (StringHelper.IsNullOrEmpty((String)imParticipantInstance.getUserSessionId())) {
                imParticipantInstance.setUserSessionId(strUserSessionId);
            } else if (StringHelper.Compare((String)strUserSessionId, (String)imParticipantInstance.getUserSessionId(), (boolean)true) != 0) {
                throw new IMException(10001);
            }
            if (imParticipantInstanceKickedOut != null) {
                this.imParticipantMap.remove(imParticipantInstanceKickedOut.getUserId());
                IMMeetingMessage imMeetingMessage = new IMMeetingMessage();
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

    protected void SendInviteMessageToParticipant(IIMParticipantInstance imParticipantInstance) throws Exception {
        IMRemoteAction imRemoteAction = new IMRemoteAction();
        imRemoteAction.setAction("MEETINGINVITE");
        imRemoteAction.setParam("MEETINGID", this.getMeetingId());
        imRemoteAction.setParam("MEETINGTYPE", StringHelper.Format((String)"%1$s", (Object)this.getMeetingType()));
        imRemoteAction.setParam("USERID", imParticipantInstance.getUserId());
        imRemoteAction.setParam("SERVERPATH", this.imMeetingServerContext.getServerPath());
        imRemoteAction.setParam("SERVERCOMETPATH", this.imMeetingServerContext.getServerCometPath());
        this.imMeetingServerContext.SendRemoteAction(imRemoteAction);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void SendLastMessageToParticipant(IIMParticipantInstance imParticipantInstance) throws Exception {
        Vector<IMMessageLog> vector = this.imMessageLogLast;
        synchronized (vector) {
            if (this.imMessageLogLast.size() == 0) {
                return;
            }
        }
        vector = this.imMessageLogLast;
        synchronized (vector) {
            for (IMMessageLog imMessageLog : this.imMessageLogLast) {
                IMMeetingMessage imMeetingMessage = new IMMeetingMessage();
                imMeetingMessage.setMessageId(imMessageLog.getIMMESSAGELOGID());
                imMeetingMessage.setContent(imMessageLog.getCONTENT());
                imMeetingMessage.setFromUserId(imMessageLog.getIMUSERID());
                imMeetingMessage.setFromUserName(imMessageLog.getIMUSERNAME());
                imMeetingMessage.setMessageType(1000);
                imMeetingMessage.setMsgTargetType(3);
                imMeetingMessage.setMsgTarget(imMessageLog.getIMUSERID());
                imMeetingMessage.setTime(StringHelper.Format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)imMessageLog.getCREATEDATE()));
                IMUserMessage imUserMessage = new IMUserMessage();
                imUserMessage.setIMUSERMESSAGEID(StringHelper.Format((String)"%1$s_%2$s", (Object)imMeetingMessage.getMessageId(), (Object)imParticipantInstance.getUserId()));
                imUserMessage.setSENDERFLAG(false);
                imUserMessage.setIMMESSAGELOGID(imMeetingMessage.getMessageId());
                imUserMessage.setIMUSERID(imParticipantInstance.getUserId());
                this.AsyncSaveData(true, imUserMessage);
                imParticipantInstance.AddMessageToQueue(imMeetingMessage);
            }
        }
        if (!imParticipantInstance.isAttend()) {
            imParticipantInstance.Active();
            this.SendInviteMessageToParticipant(imParticipantInstance);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
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
            Hashtable<String, IIMParticipantInstance> hashtable = this.imParticipantMap;
            synchronized (hashtable) {
                imParticipantInstance = this.imParticipantMap.get(strUserId);
            }
            if (imParticipantInstance == null) {
                throw new IMException(10004);
            }
            if (StringHelper.IsNullOrEmpty((String)imParticipantInstance.getUserSessionId())) {
                imParticipantInstance.setUserSessionId(strUserSessionId);
            } else if (StringHelper.Compare((String)strUserSessionId, (String)imParticipantInstance.getUserSessionId(), (boolean)true) != 0) {
                throw new IMException(10001);
            }
        }
        return imMessagePackage;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected IMMessagePackage OnUserSessionLogin(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        if (iIMRemoteActionContext.isFromServer()) {
            String strUserId = iIMRemoteActionContext.getParam("USERID", "");
            String strUserSessionId = iIMRemoteActionContext.getParam("USERSESSIONID", "");
            IIMParticipantInstance imParticipantInstance = null;
            Hashtable<String, IIMParticipantInstance> hashtable = this.imParticipantMap;
            synchronized (hashtable) {
                imParticipantInstance = this.imParticipantMap.get(strUserId);
            }
            if (imParticipantInstance != null) {
                imParticipantInstance.setUserSessionId(strUserSessionId);
                log.debug((Object)StringHelper.Format((String)"\u4f1a\u8bae[%1$s]\u53c2\u4e0e\u4eba[%2$s]\u66f4\u65b0\u4f1a\u8bdd\u6807\u8bc6[%3$s]", (Object)this.getMeetingId(), (Object)strUserId, (Object)strUserSessionId));
            }
        }
        return new IMMessagePackage();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected IMMessagePackage OnUserSessionLogout(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        if (iIMRemoteActionContext.isFromServer()) {
            String strUserId = iIMRemoteActionContext.getParam("USERID", "");
            String strUserSessionId = iIMRemoteActionContext.getParam("USERSESSIONID", "");
            IIMParticipantInstance imParticipantInstance = null;
            Hashtable<String, IIMParticipantInstance> hashtable = this.imParticipantMap;
            synchronized (hashtable) {
                imParticipantInstance = this.imParticipantMap.get(strUserId);
            }
            if (imParticipantInstance != null && StringHelper.Compare((String)imParticipantInstance.getUserSessionId(), (String)strUserSessionId, (boolean)true) == 0) {
                imParticipantInstance.setUserSessionId("");
                log.debug((Object)StringHelper.Format((String)"\u4f1a\u8bae[%1$s]\u53c2\u4e0e\u4eba[%2$s]\u6ce8\u9500\u4f1a\u8bdd\u6807\u8bc6[%3$s]", (Object)this.getMeetingId(), (Object)strUserId, (Object)strUserSessionId));
            }
        }
        return new IMMessagePackage();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void RegisterUserConnection(String strUserId, String strUserSessionId, IIMCometEvent cometEvent) throws IMException {
        IIMParticipantInstance imParticipantInstance = null;
        Hashtable<String, IIMParticipantInstance> hashtable = this.imParticipantMap;
        synchronized (hashtable) {
            imParticipantInstance = this.imParticipantMap.get(strUserId);
        }
        if (imParticipantInstance == null) {
            throw new IMException(10004);
        }
        String strChatWindow = cometEvent.getHttpServletRequest().getParameter("CHATWINDOW");
        if (StringHelper.Compare((String)strChatWindow, (String)"TRUE", (boolean)true) == 0) {
            imParticipantInstance.setChatWindow(true);
            this.Active();
        }
        if (StringHelper.IsNullOrEmpty((String)imParticipantInstance.getUserSessionId())) {
            imParticipantInstance.setUserSessionId(strUserSessionId);
            imParticipantInstance.RegisterUserConnection(cometEvent);
            return;
        }
        if (StringHelper.Compare((String)strUserSessionId, (String)imParticipantInstance.getUserSessionId(), (boolean)true) == 0) {
            imParticipantInstance.RegisterUserConnection(cometEvent);
            return;
        }
        log.debug((Object)StringHelper.Format((String)"\u65e0\u6548\u7684\u5ba2\u6237\u7aef\u6ce8\u518c[%1$s][%2$s]", (Object)strUserId, (Object)strUserSessionId));
        throw new IMException(10001);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void UnregisterUserConnection(String strUserId) throws IMException {
        IIMParticipantInstance imParticipantInstance = null;
        Hashtable<String, IIMParticipantInstance> hashtable = this.imParticipantMap;
        synchronized (hashtable) {
            imParticipantInstance = this.imParticipantMap.get(strUserId);
        }
        if (imParticipantInstance == null) {
            throw new IMException(10004);
        }
        imParticipantInstance.UnregisterUserConnection();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void AddMessageToQueue(IMMessageBase imMessageBase) {
        Vector<IMMessageBase> vector = this.imMessageList;
        synchronized (vector) {
            if (log.isDebugEnabled()) {
                log.debug((Object)StringHelper.Format((String)"\u4f1a\u8bae[%1$s]\u589e\u52a0\u6d88\u606f\u5230\u4f1a\u8bae\u6d3e\u9001\u961f\u5217\r\n%2$s", (Object)this.getMeetingId(), (Object)imMessageBase.getDebugInfo()));
            }
            this.imMessageList.add(imMessageBase);
        }
    }

    @Override
    public void DispatchMessage() {
        this.OnDispatchMessage();
    }

    @Override
    public void TestTimeout() {
        this.OnTestTimeout();
    }

    protected void OnTestTimeout() {
        this.OnTestTalkTimeout();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void OnTestTalkTimeout() {
        boolean bTimeout = false;
        Integer n = this.nTalkState;
        synchronized (n) {
            switch (this.nTalkState) {
                case 1: {
                    Cloneable dtCur = new Date();
                    if (((Date)dtCur).getTime() - this.dtTalkTime.getTime() <= 20000L) break;
                    bTimeout = true;
                    break;
                }
                case 2: {
                    Cloneable dtCur = this.imParticipantMap;
                    synchronized (dtCur) {
                        for (IIMParticipantInstance item : this.imParticipantMap.values()) {
                            if (item.isTalking()) continue;
                            bTimeout = true;
                            break;
                        }
                        break;
                    }
                }
            }
            if (bTimeout) {
                IMMeetingMessage imMeetingMessage = new IMMeetingMessage();
                imMeetingMessage.setMessageType(1007);
                imMeetingMessage.setTalkId(this.strActiveTalkId);
                imMeetingMessage.setMsgTargetType(1);
                this.AddMessageToQueue(imMeetingMessage);
                this.nTalkState = 0;
                this.strActiveTalkId = "";
                this.strTalkStartUserId = "";
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     */
    protected void OnDispatchMessage() {
        imParticipantInstanceList = new Vector<Object>();
        block14: while (true) {
            imMessageBase = null;
            var3_3 = this.imMessageList;
            synchronized (var3_3) {
                if (this.imMessageList.size() > 0) {
                    imMessageBase = this.imMessageList.remove(0);
                }
            }
            if (imMessageBase == null) break;
            imParticipantInstanceList.clear();
            if (imMessageBase.getMsgTargetType() == 2) {
                imParticipantInstance = null;
                var4_4 = this.imParticipantMap;
                synchronized (var4_4) {
                    imParticipantInstance = this.imParticipantMap.get(imMessageBase.getMsgTarget());
                }
                if (imParticipantInstance != null) {
                    imParticipantInstanceList.add(imParticipantInstance);
                }
            } else if (imMessageBase.getMsgTargetType() == 1) {
                imParticipantInstance = this.imParticipantMap;
                synchronized (imParticipantInstance) {
                    for (IIMParticipantInstance imParticipantInstance : this.imParticipantMap.values()) {
                        imParticipantInstanceList.add(imParticipantInstance);
                    }
                }
            } else if (imMessageBase.getMsgTargetType() == 3) {
                imParticipantInstance = this.imParticipantMap;
                synchronized (imParticipantInstance) {
                    for (IIMParticipantInstance imParticipantInstance : this.imParticipantMap.values()) {
                        if (StringHelper.Compare((String)imParticipantInstance.getUserId(), (String)imMessageBase.getMsgTarget(), (boolean)true) == 0) continue;
                        imParticipantInstanceList.add(imParticipantInstance);
                    }
                }
            } else {
                IMMeetingInstance.log.error((Object)StringHelper.Format((String)"\u672a\u77e5\u7684\u6d88\u606f\u76ee\u6807\u7c7b\u578b[%1$s]", (Object)imMessageBase.getMsgTargetType()));
                continue;
            }
            imMeetingMessage = null;
            if (imMessageBase instanceof IMMeetingMessage) {
                imMeetingMessage = (IMMeetingMessage)imMessageBase;
            }
            var5_5 = imParticipantInstanceList.iterator();
            while (true) {
                if (var5_5.hasNext()) ** break;
                continue block14;
                imParticipantInstance = var5_5.next();
                if (imMeetingMessage != null) {
                    if (imMeetingMessage.getMessageType() == 1000 && !StringHelper.IsNullOrEmpty((String)imMeetingMessage.getMessageId())) {
                        imUserMessage = new IMUserMessage();
                        imUserMessage.setIMUSERMESSAGEID(StringHelper.Format((String)"%1$s_%2$s", (Object)imMeetingMessage.getMessageId(), (Object)imParticipantInstance.getUserId()));
                        imUserMessage.setSENDERFLAG(false);
                        imUserMessage.setIMMESSAGELOGID(imMeetingMessage.getMessageId());
                        imUserMessage.setIMUSERID(imParticipantInstance.getUserId());
                        this.AsyncSaveData(true, imUserMessage);
                    }
                    if (imMeetingMessage.getMessageType() == 1001 && !StringHelper.IsNullOrEmpty((String)imMeetingMessage.getFileId())) {
                        imUserFile = new IMUserFile();
                        imUserFile.setIMUSERFILEID(StringHelper.Format((String)"%1$s_%2$s", (Object)imMeetingMessage.getFileId(), (Object)imParticipantInstance.getUserId()));
                        imUserFile.setSENDERFLAG(false);
                        imUserFile.setIMFILEID(imMeetingMessage.getFileId());
                        imUserFile.setIMUSERID(imParticipantInstance.getUserId());
                        this.AsyncSaveData(true, imUserFile);
                        imUserMessage = new IMUserMessage();
                        imUserMessage.setIMUSERMESSAGEID(StringHelper.Format((String)"%1$s_%2$s", (Object)imMeetingMessage.getFileId(), (Object)imParticipantInstance.getUserId()));
                        imUserMessage.setSENDERFLAG(false);
                        imUserMessage.setRECVFLAG(true);
                        imUserMessage.setIMMESSAGELOGID(imMeetingMessage.getFileId());
                        imUserMessage.setIMUSERID(imParticipantInstance.getUserId());
                        this.AsyncSaveData(true, imUserMessage);
                    }
                }
                imParticipantInstance.AddMessageToQueue(imMessageBase);
                if (imParticipantInstance.isAttend()) continue;
                imParticipantInstance.Active();
                try {
                    this.SendInviteMessageToParticipant(imParticipantInstance);
                }
                catch (Exception ex) {
                    IMMeetingInstance.log.error((Object)StringHelper.Format((String)"\u53d1\u9001\u4f1a\u8bae\u9080\u8bf7\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
                }
            }
            break;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public boolean isTimeout() {
        boolean bl;
        Integer n = this.nTalkState;
        synchronized (n) {
            if (this.nTalkState != 0) {
                return false;
            }
        }
        Vector<BaseDataEntity> vector = this.saveDataList;
        synchronized (vector) {
            if (this.saveDataList.size() > 0) {
                return false;
            }
        }
        boolean bl2 = false;
        Date curDate = new Date();
        Date date = this.activeDate;
        synchronized (date) {
            if (curDate.getTime() - this.activeDate.getTime() >= 900000L) {
                return true;
            }
            if (curDate.getTime() - this.activeDate.getTime() >= 600000L && !this.bNotifyClose) {
                this.bNotifyClose = true;
                bl = true;
            }
        }
        if (bl) {
            log.debug((Object)StringHelper.Format((String)"\u4f1a\u8bae[%1$s]\u53d1\u9001\u4f1a\u8bae\u5173\u95ed\u901a\u77e5", (Object)this.getMeetingId()));
            IMMeetingMessage imMeetingMessage = new IMMeetingMessage();
            imMeetingMessage.setMessageType(1101);
            imMeetingMessage.setMsgTargetType(1);
            imMeetingMessage.setTime(StringHelper.Format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)curDate));
            this.AddMessageToQueue(imMeetingMessage);
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void Active() {
        Date date = this.activeDate;
        synchronized (date) {
            this.activeDate = new Date();
            this.bNotifyClose = false;
        }
    }

    @Override
    public void Close() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected IIMParticipantInstance GetParticipantInstance(String strUserId, String strUserSessionId, boolean bAttend) throws Exception {
        IIMParticipantInstance imParticipantInstance = null;
        Hashtable<String, IIMParticipantInstance> hashtable = this.imParticipantMap;
        synchronized (hashtable) {
            imParticipantInstance = this.imParticipantMap.get(strUserId);
        }
        if (imParticipantInstance == null) {
            throw new IMException(10004);
        }
        if (StringHelper.IsNullOrEmpty((String)imParticipantInstance.getUserSessionId()) || bAttend && !imParticipantInstance.isAttend()) {
            imParticipantInstance.setUserSessionId(strUserSessionId);
        } else if (StringHelper.Compare((String)strUserSessionId, (String)imParticipantInstance.getUserSessionId(), (boolean)true) != 0) {
            if (!imParticipantInstance.isAttend()) {
                imParticipantInstance.setUserSessionId(strUserSessionId);
                return imParticipantInstance;
            }
            throw new IMException(10001);
        }
        return imParticipantInstance;
    }

    protected IIMParticipantInstance GetParticipantInstance(String strUserId, String strUserSessionId) throws Exception {
        return this.GetParticipantInstance(strUserId, strUserSessionId, false);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void AsyncSaveData(boolean bInsert, BaseDataEntity data) {
        Date date = new Date();
        if (!bInsert) {
            data.SetParamValue("SRF_UPDATEMODE", (Object)1);
            data.SetParamValue("UPDATEDATE", (Object)new Timestamp(date.getTime()));
        } else {
            data.SetParamValue("CREATEDATE", (Object)new Timestamp(date.getTime()));
            data.SetParamValue("UPDATEDATE", (Object)new Timestamp(date.getTime()));
        }
        Vector<BaseDataEntity> vector = this.saveDataList;
        synchronized (vector) {
            this.saveDataList.add(data);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void FillSaveDatas(Vector<BaseDataEntity> datas) {
        Vector<BaseDataEntity> vector = this.saveDataList;
        synchronized (vector) {
            datas.addAll(this.saveDataList);
            this.saveDataList.clear();
        }
    }
}

