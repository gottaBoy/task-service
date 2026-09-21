/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.IM.Ctrl;

import SA.IM.Ctrl.IMException;
import SA.IM.Ctrl.IMMessageBase;
import SA.IM.Ctrl.IMMessagePackage;
import SA.IM.Ctrl.IMParticipantInstance;
import SA.IM.Ctrl.IMRemoteAction;
import SA.IM.Ctrl.Message.IMMeetingMessage;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import net.sf.json.JSONObject;

public abstract class IMRobotParticipantInstance
extends IMParticipantInstance {
    @Override
    protected void OnInit() throws Exception {
        super.OnInit();
        this.setUserSessionId(Helper.GenGuidEx());
    }

    protected String OnGetWelcomeMessage() {
        return "";
    }

    @Override
    protected void PrepareOfflineMessage() throws Exception {
    }

    @Override
    public void AddMessageToQueue(IMMessageBase imMessageBase) {
        if (imMessageBase instanceof IMMeetingMessage) {
            IMMeetingMessage imMeetingMessage = (IMMeetingMessage)imMessageBase;
            if (imMeetingMessage.getMessageType() == 1000) {
                this.OnMeetingMessageIncoming(imMeetingMessage);
                return;
            }
            if (imMeetingMessage.getMessageType() == 1001) {
                this.OnMeetingFileIncoming(imMeetingMessage);
                return;
            }
        }
    }

    protected void OnMeetingMessageIncoming(IMMeetingMessage imMeetingMessage) {
    }

    protected void OnMeetingFileIncoming(IMMeetingMessage imMeetingMessage) {
    }

    protected void SendMeetingMessage(String strDstUserId, String strMessage) throws Exception {
        IMRemoteAction iIMRemoteActionContext = new IMRemoteAction();
        iIMRemoteActionContext.setAction("MEETINGMESSAGE");
        iIMRemoteActionContext.setParam("USERID", this.getUserId());
        iIMRemoteActionContext.setParam("USERSESSIONID", this.getUserSessionId());
        JSONObject jo = new JSONObject();
        jo.put("message", (Object)strMessage);
        iIMRemoteActionContext.setContent(jo.toString());
        IMMessagePackage imMessagePackage = this.imMeetingContext.ProcessRemoteAction(iIMRemoteActionContext);
        if (imMessagePackage.getRetCode() != 0) {
            throw new IMException(imMessagePackage.getRetCode(), imMessagePackage.getRetInfo());
        }
    }

    protected void SendMeetingMessageEx(String strDstUserId, String strMessage) throws Exception {
        IMRemoteAction iIMRemoteActionContext = new IMRemoteAction();
        iIMRemoteActionContext.setAction("MEETINGMESSAGE");
        iIMRemoteActionContext.setParam("USERID", this.getUserId());
        iIMRemoteActionContext.setParam("USERSESSIONID", this.getUserSessionId());
        iIMRemoteActionContext.setContent(strMessage);
        IMMessagePackage imMessagePackage = this.imMeetingContext.ProcessRemoteAction(iIMRemoteActionContext);
        if (imMessagePackage.getRetCode() != 0) {
            throw new IMException(imMessagePackage.getRetCode(), imMessagePackage.getRetInfo());
        }
    }

    protected void SendMeetingFile(String strDstUserId, String strFilePath) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u53d1\u9001\u4f1a\u8bae\u7684\u65b9\u6cd5");
    }

    @Override
    protected void OnSendWelcomeMessage() throws Exception {
        super.OnSendWelcomeMessage();
        String strMessage = this.OnGetWelcomeMessage();
        if (!StringHelper.IsNullOrEmpty((String)strMessage)) {
            this.SendMeetingMessage("", strMessage);
        }
    }

    @Override
    public boolean isRobot() {
        return true;
    }

    @Override
    public boolean isEnableVoiceTalk() {
        return false;
    }

    @Override
    public boolean isEnableVideoTalk() {
        return false;
    }

    @Override
    public boolean isAttend() {
        return true;
    }
}

