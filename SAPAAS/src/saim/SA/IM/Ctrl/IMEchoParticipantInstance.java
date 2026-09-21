/*
 * Decompiled with CFR 0.152.
 */
package SA.IM.Ctrl;

import SA.IM.Ctrl.IMRobotParticipantInstance;
import SA.IM.Ctrl.Message.IMMeetingMessage;

public class IMEchoParticipantInstance
extends IMRobotParticipantInstance {
    @Override
    protected String OnGetWelcomeMessage() {
        return "\u60a8\u597d";
    }

    @Override
    protected void OnMeetingFileIncoming(IMMeetingMessage imMeetingMessage) {
    }

    @Override
    protected void OnMeetingMessageIncoming(IMMeetingMessage imMeetingMessage) {
        String strContent = imMeetingMessage.getMessage();
        try {
            this.SendMeetingMessage("", strContent);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

