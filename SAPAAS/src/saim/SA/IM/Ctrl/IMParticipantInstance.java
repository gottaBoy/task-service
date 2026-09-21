/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.IM.Ctrl;

import SA.IM.Ctrl.Data.IMFile;
import SA.IM.Ctrl.Data.IMMessageLog;
import SA.IM.Ctrl.Data.IMParticipant;
import SA.IM.Ctrl.Data.IMUserFile;
import SA.IM.Ctrl.IIMCometEvent;
import SA.IM.Ctrl.IIMMeetingContext;
import SA.IM.Ctrl.IIMParticipantInstance;
import SA.IM.Ctrl.IIMRemoteAction;
import SA.IM.Ctrl.IMBaseObject;
import SA.IM.Ctrl.IMMessageBase;
import SA.IM.Ctrl.IMMessagePackage;
import SA.IM.Ctrl.Message.IMMeetingMessage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.io.IOException;
import java.util.Date;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IMParticipantInstance
extends IMBaseObject
implements IIMParticipantInstance {
    protected Vector<IMMessageBase> imMessageList = new Vector();
    protected IMParticipant imParticipant = null;
    protected IIMCometEvent cometEvent = null;
    protected String strUserSessionId = "";
    private static final Log log = LogFactory.getLog(IMParticipantInstance.class);
    private Date activeDate = null;
    private Date activeTalkingDate = null;
    private Object cometEventLock = new Object();
    private Object activeDateLock = new Object();
    private Object activeTalkingDateLock = new Object();
    protected IIMMeetingContext imMeetingContext = null;
    private boolean bIsAttend = false;
    private boolean bChatWindow = false;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, IIMMeetingContext imMeetingContext, IMParticipant imParticipant) throws Exception {
        this.imParticipant = imParticipant;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.imMeetingContext = imMeetingContext;
        this.setId(this.imParticipant.getIMPARTICIPANTID());
        this.setName(this.imParticipant.getIMPARTICIPANTNAME());
        this.OnInit();
    }

    @Override
    protected void OnInit() throws Exception {
        this.PrepareOfflineMessage();
    }

    @Override
    public void SendWelcomeMessage() throws Exception {
        this.OnSendWelcomeMessage();
    }

    protected void OnSendWelcomeMessage() throws Exception {
    }

    protected void PrepareOfflineMessage() throws Exception {
        Vector<IMMessageLog> imMessageLogs = new Vector<IMMessageLog>();
        CallResult callResult = this.getIMModelHelper().GetUnsendIMMessageLogs(this.imMeetingContext.getMeetingId(), this.getUserId(), imMessageLogs);
        if (!callResult.IsError()) {
            for (IMMessageLog imMessageLog : imMessageLogs) {
                IMMeetingMessage imMeetingMessage = new IMMeetingMessage();
                imMeetingMessage.setMessageId(imMessageLog.getIMMESSAGELOGID());
                imMeetingMessage.setContent(imMessageLog.getCONTENT());
                imMeetingMessage.setFromUserId(imMessageLog.getIMUSERID());
                imMeetingMessage.setFromUserName(imMessageLog.getIMUSERNAME());
                imMeetingMessage.setMessageType(1000);
                imMeetingMessage.setMsgTargetType(3);
                imMeetingMessage.setMsgTarget(imMessageLog.getIMUSERID());
                imMeetingMessage.setTime(StringHelper.Format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)imMessageLog.getSENDTIME()));
                imMeetingMessage.setOffline(true);
                this.AddMessageToQueue(imMeetingMessage);
            }
        } else {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u7528\u6237\u4f1a\u8bae\u79bb\u7ebf\u6d88\u606f\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        Vector<IMFile> imFiles = new Vector<IMFile>();
        callResult = this.getIMModelHelper().GetUnsendIMFiles(this.imMeetingContext.getMeetingId(), this.getUserId(), imFiles);
        if (!callResult.IsError()) {
            for (IMFile imFile : imFiles) {
                IMMeetingMessage imMeetingMessage = new IMMeetingMessage();
                imMeetingMessage.setFileId(imFile.getIMFILEID());
                imMeetingMessage.setFileName(imFile.getIMFILENAME());
                imMeetingMessage.setFromUserId(imFile.getIMUSERID());
                imMeetingMessage.setFromUserName(imFile.getIMUSERNAME());
                imMeetingMessage.setMessageType(1001);
                imMeetingMessage.setMsgTargetType(3);
                imMeetingMessage.setMsgTarget(imFile.getIMUSERID());
                imMeetingMessage.setTime(StringHelper.Format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)imFile.getSENDTIME()));
                this.AddMessageToQueue(imMeetingMessage);
            }
        } else {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u7528\u6237\u4f1a\u8bae\u79bb\u7ebf\u6587\u4ef6\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void AddMessageToQueue(IMMessageBase imMessageBase) {
        if (!this.OnTestAddMessageToQueue(imMessageBase)) {
            return;
        }
        if (log.isDebugEnabled()) {
            log.debug((Object)StringHelper.Format((String)"\u4f1a\u8bae[%1$s]\u53c2\u4e0e\u8005[%2$s]\u589e\u52a0\u6d88\u606f\u5230\u6d3e\u9001\u961f\u5217\r\n%3$s", (Object)this.imMeetingContext.getMeetingId(), (Object)this.getUserId(), (Object)imMessageBase.getDebugInfo()));
        }
        Vector<IMMessageBase> vector = this.imMessageList;
        synchronized (vector) {
            this.imMessageList.add(imMessageBase);
        }
        this.SendMessageToClient();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    protected void SendMessageToClient() {
        if (!this.isAttend()) {
            return;
        }
        Object object = this.cometEventLock;
        synchronized (object) {
            block22: {
                if (this.cometEvent == null) {
                    return;
                }
                Vector<Object> sendList = null;
                Vector<IMMessageBase> vector = this.imMessageList;
                synchronized (vector) {
                    if (this.imMessageList.size() > 0) {
                        void var4_5;
                        sendList = new Vector<Object>();
                        boolean bl = false;
                        while (this.imMessageList.size() > 0 && var4_5 < 50) {
                            IMMessageBase imMessageBase = this.imMessageList.remove(0);
                            sendList.add(imMessageBase);
                            ++var4_5;
                        }
                    }
                }
                if (sendList == null) {
                    return;
                }
                IMMessagePackage imMessagePackage = new IMMessagePackage();
                for (IMMessageBase iMMessageBase : sendList) {
                    imMessagePackage.AddMessage(iMMessageBase);
                }
                try {
                    String string = imMessagePackage.toJSONString();
                    this.cometEvent.getHttpServletResponse().getWriter().print(string);
                    this.cometEvent.getHttpServletResponse().getWriter().flush();
                    int i = 0;
                    while (i < sendList.size()) {
                        IMMeetingMessage imMeetingMessage;
                        IMMessageBase imMessageBase = (IMMessageBase)sendList.get(i);
                        log.debug((Object)StringHelper.Format((String)"\u4f1a\u8bae[%1$s]\u53c2\u4e0e\u8005[%2$s]\u6d88\u606f\u6d3e\u53d1\u6210\u529f\r\n%3$s", (Object)this.imMeetingContext.getMeetingId(), (Object)this.getUserId(), (Object)imMessageBase.getDebugInfo()));
                        if (imMessageBase instanceof IMMeetingMessage && ((imMeetingMessage = (IMMeetingMessage)imMessageBase).getMessageType() != 1000 || StringHelper.IsNullOrEmpty((String)imMeetingMessage.getMessageId())) && imMeetingMessage.getMessageType() == 1001 && !StringHelper.IsNullOrEmpty((String)imMeetingMessage.getFileId())) {
                            IMUserFile imUserFile = new IMUserFile();
                            imUserFile.setIMUSERFILEID(StringHelper.Format((String)"%1$s_%2$s", (Object)imMeetingMessage.getFileId(), (Object)this.getUserId()));
                            imUserFile.setRECVFLAG(true);
                            this.imMeetingContext.AsyncSaveData(false, imUserFile);
                        }
                        ++i;
                    }
                    break block22;
                }
                catch (Exception exception) {
                    Vector<IMMessageBase> vector2 = this.imMessageList;
                    synchronized (vector2) {
                        int i = 0;
                        while (i < sendList.size()) {
                            IMMessageBase imMessageBase = (IMMessageBase)sendList.get(i);
                            this.imMessageList.add(i, imMessageBase);
                            ++i;
                        }
                    }
                }
                log.error((Object)StringHelper.Format((String)"\u53d1\u751f\u6d88\u606f\u5230\u7528\u6237\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
            }
            try {
                this.cometEvent.close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
            this.cometEvent = null;
        }
    }

    protected boolean OnTestAddMessageToQueue(IMMessageBase imMessageBase) {
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void RegisterUserConnection(IIMCometEvent cometEvent) {
        Object object = this.cometEventLock;
        synchronized (object) {
            this.cometEvent = cometEvent;
            if (this.cometEvent != null) {
                this.Active();
            }
        }
        this.SendMessageToClient();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void UnregisterUserConnection() {
        Object object = this.cometEventLock;
        synchronized (object) {
            this.cometEvent = null;
        }
    }

    @Override
    public String getUserId() {
        return this.imParticipant.getIMUSERID();
    }

    @Override
    public String getUserName() {
        return this.imParticipant.getIMUSERNAME();
    }

    @Override
    public void Attend(String strUserSessionId, IIMRemoteAction iIMRemoteActionContext) throws Exception {
        this.Active();
        this.bIsAttend = true;
        this.strUserSessionId = strUserSessionId;
        String strChatWindow = iIMRemoteActionContext.getParam("CHATWINDOW", "");
        if (StringHelper.Compare((String)strChatWindow, (String)"TRUE", (boolean)true) == 0) {
            this.setChatWindow(true);
        } else {
            this.setChatWindow(false);
        }
        this.OnAttend(iIMRemoteActionContext);
    }

    protected void OnAttend(IIMRemoteAction iIMRemoteActionContext) throws Exception {
    }

    @Override
    public void Quit() throws Exception {
        this.bIsAttend = false;
        this.strUserSessionId = "";
        this.OnQuit();
    }

    protected void OnQuit() throws Exception {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean isAttend() {
        if (!this.bIsAttend) {
            return false;
        }
        if (this.cometEvent != null) {
            return true;
        }
        Object object = this.activeDateLock;
        synchronized (object) {
            block8: {
                block7: {
                    if (this.activeDate != null) break block7;
                    return false;
                }
                Date curDate = new Date();
                if (curDate.getTime() - this.activeDate.getTime() < 10000L) break block8;
                return false;
            }
            return true;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void Active() {
        Object object = this.activeDateLock;
        synchronized (object) {
            this.activeDate = new Date();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void ActiveTalking() {
        Object object = this.activeTalkingDateLock;
        synchronized (object) {
            this.activeTalkingDate = new Date();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean isTalking() {
        Object object = this.activeTalkingDateLock;
        synchronized (object) {
            block6: {
                block5: {
                    if (this.activeTalkingDate != null) break block5;
                    return false;
                }
                Date curDate = new Date();
                if (curDate.getTime() - this.activeTalkingDate.getTime() < 10000L) break block6;
                return false;
            }
            return true;
        }
    }

    @Override
    public String getUserSessionId() {
        return this.strUserSessionId;
    }

    @Override
    public void setUserSessionId(String strUserSessionId) {
        this.strUserSessionId = strUserSessionId;
    }

    @Override
    public boolean isRobot() {
        return false;
    }

    @Override
    public boolean isEnableVoiceTalk() {
        return true;
    }

    @Override
    public boolean isEnableVideoTalk() {
        return true;
    }

    @Override
    public void setChatWindow(boolean bChatWindow) {
        this.bChatWindow = bChatWindow;
    }

    @Override
    public boolean getChatWindow() {
        return this.bChatWindow;
    }

    @Override
    public boolean isAdmin() {
        return this.imParticipant.getADMINFLAG();
    }
}

