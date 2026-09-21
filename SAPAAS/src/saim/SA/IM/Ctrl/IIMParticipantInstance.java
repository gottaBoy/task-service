/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.IM.Ctrl;

import SA.IM.Ctrl.Data.IMParticipant;
import SA.IM.Ctrl.IIMCometEvent;
import SA.IM.Ctrl.IIMMeetingContext;
import SA.IM.Ctrl.IIMObjectHelper;
import SA.IM.Ctrl.IIMRemoteAction;
import SA.IM.Ctrl.IMMessageBase;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IIMParticipantInstance
extends IIMObjectHelper {
    public void Init(ISRFDAGlobalHelper var1, IIMMeetingContext var2, IMParticipant var3) throws Exception;

    public String getUserId();

    public String getUserName();

    public String getUserSessionId();

    public void setUserSessionId(String var1);

    public void AddMessageToQueue(IMMessageBase var1);

    public void RegisterUserConnection(IIMCometEvent var1);

    public void UnregisterUserConnection();

    public boolean isAttend();

    public void Active();

    public void ActiveTalking();

    public boolean isTalking();

    public void SendWelcomeMessage() throws Exception;

    public boolean isRobot();

    public boolean isEnableVoiceTalk();

    public boolean isEnableVideoTalk();

    public void Attend(String var1, IIMRemoteAction var2) throws Exception;

    public void Quit() throws Exception;

    public void setChatWindow(boolean var1);

    public boolean getChatWindow();

    public boolean isAdmin();
}

