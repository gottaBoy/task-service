/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SRFWF.Model;

import SA.SRFramework.Utility.StringHelper;
import SRFWF.Ctrl.Data.WFAction;
import SRFWF.Ctrl.SRFWFInteractiveProcess;
import SRFWF.Model.WFBaseProcessConfig;
import SRFWF.Model.WFInteractiveActionConfig;
import SRFWF.Model.WFInteractiveActionsConfig;
import java.util.ArrayList;
import java.util.Iterator;
import org.w3c.dom.Node;

public class WFInteractiveProcessConfig
extends WFBaseProcessConfig {
    public static final String TAG_WFINTERACTIVE = "SRFEXWFINTERACTIVE";
    public static final String TIMEOUTTYPE_MINUTE = "MINUTE";
    public static final String TIMEOUTTYPE_HOUR = "HOUR";
    public static final String TIMEOUTTYPE_DAY = "DAY";
    public static final String TIMEOUTTYPE_WORKDAY = "WORKDAY";
    public static String TAG_ACTORS = "ACTORS";
    public static String TAG_UDACTORS = "UDACTORS";
    public static String TAG_TIMEOUT = "TIMEOUT";
    public static String TAG_TIMEOUTNEXT = "TIMEOUTNEXT";
    public static String TAG_TIMEOUTTYPE = "TIMEOUTTYPE";
    public static String TAG_TIMEOUTFIELD = "TIMEOUTFIELD";
    public static String TAG_WORKTIMETYPE = "WORKTIMETYPE";
    public static String TAG_USERACTIONS = "USERACTIONS";
    public static String TAG_ISSENDINFORM = "ISSENDINFORM";
    public static String TAG_MSGTEMPLATEID = "MSGTEMPLATEID";
    public static String TAG_MSGTEMPLATENAME = "MSGTEMPLATENAME";
    public static String TAG_MSGTYPE = "MSGTYPE";
    protected WFInteractiveActionsConfig iaActionsConfig = null;
    protected String strActors = "";
    protected String strUDActors = "";
    protected String strUserActions = "";
    protected int nTimeout = 0;
    protected String strTimeoutNext = "";
    protected String strTimeoutType = "";
    protected String strTimeoutField = "";
    protected String strWorktimeType = "";
    protected boolean bIsSendInform = false;
    protected String strMsgTemplateId = "";
    protected String strMsgTemplateName = "";
    protected int nMsgType = 0;
    protected ArrayList<WFAction> userActionList = null;
    protected boolean bActorIAActionControl = false;

    public WFInteractiveProcessConfig() {
        this.setObject(SRFWFInteractiveProcess.class.getName());
        this.iaActionsConfig = new WFInteractiveActionsConfig(this);
    }

    @Override
    public boolean isSuspendProcess() {
        return true;
    }

    @Override
    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)WFInteractiveActionsConfig.TAG_WFIAACTIONS, (boolean)true) == 0) {
            this.iaActionsConfig.LoadConfig(xmlNode);
            this.CalcActorIAActionControl();
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    protected void CalcActorIAActionControl() {
        this.setActorIAActionControl(false);
        Iterator iterator = this.getIAActionsConfig().iterator();
        while (iterator.hasNext()) {
            WFInteractiveActionConfig iaActionConfig = (WFInteractiveActionConfig)((Object)iterator.next());
            if (!iaActionConfig.isActorIAActionControl()) continue;
            this.setActorIAActionControl(true);
            break;
        }
    }

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_ACTORS, (boolean)true) == 0) {
            this.strActors = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_USERACTIONS, (boolean)true) == 0) {
            this.strUserActions = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_UDACTORS, (boolean)true) == 0) {
            this.strUDActors = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_TIMEOUT, (boolean)true) == 0) {
            this.setTimeout(WFInteractiveProcessConfig.GetValue((String)strValue, (int)this.nTimeout));
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_TIMEOUTNEXT, (boolean)true) == 0) {
            this.strTimeoutNext = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_TIMEOUTTYPE, (boolean)true) == 0) {
            this.strTimeoutType = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_TIMEOUTFIELD, (boolean)true) == 0) {
            this.strTimeoutField = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_WORKTIMETYPE, (boolean)true) == 0) {
            this.strWorktimeType = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ISSENDINFORM, (boolean)true) == 0) {
            this.setSendInform(WFInteractiveProcessConfig.GetValue((String)strValue, (boolean)this.isSendInform()));
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_MSGTEMPLATEID, (boolean)true) == 0) {
            this.setMsgTemplateId(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_MSGTEMPLATENAME, (boolean)true) == 0) {
            this.setMsgTemplateName(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_MSGTYPE, (boolean)true) == 0) {
            this.setMsgType(WFInteractiveProcessConfig.GetValue((String)strValue, (int)this.getMsgType()));
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public WFInteractiveActionsConfig getIAActionsConfig() {
        return this.iaActionsConfig;
    }

    public String getActors() {
        return this.strActors;
    }

    public void setActors(String strActors) {
        this.strActors = strActors;
    }

    public String getUserActions() {
        return this.strUserActions;
    }

    public void setUserActions(String strUserActions) {
        this.strUserActions = strUserActions;
    }

    public int getTimeout() {
        return this.nTimeout;
    }

    public void setTimeout(int timeout) {
        this.nTimeout = timeout;
        if (this.nTimeout < 0) {
            this.nTimeout = 0;
        }
    }

    public String getTimeoutNext() {
        return this.strTimeoutNext;
    }

    public void setTimeoutNext(String strTimeoutNext) {
        this.strTimeoutNext = strTimeoutNext;
    }

    public String getTimeoutType() {
        return this.strTimeoutType;
    }

    public void setTimeoutType(String strTimeoutType) {
        this.strTimeoutType = strTimeoutType;
    }

    public String getWorktimeType() {
        return this.strWorktimeType;
    }

    public void setWorktimeType(String strWorktimeType) {
        this.strWorktimeType = strWorktimeType;
    }

    public String getUDActors() {
        return this.strUDActors;
    }

    public void setUDActors(String strUDActors) {
        this.strUDActors = strUDActors;
    }

    public ArrayList<WFAction> getUserActionList() {
        if (this.userActionList == null) {
            this.userActionList = new ArrayList();
        }
        return this.userActionList;
    }

    public boolean isSendInform() {
        return this.bIsSendInform;
    }

    public String getMsgTemplateId() {
        return this.strMsgTemplateId;
    }

    public String getMsgTemplateName() {
        return this.strMsgTemplateName;
    }

    public int getMsgType() {
        return this.nMsgType;
    }

    public void setSendInform(boolean bIsSendInform) {
        this.bIsSendInform = bIsSendInform;
    }

    public void setMsgTemplateId(String strMsgTemplateId) {
        this.strMsgTemplateId = strMsgTemplateId;
    }

    public void setMsgTemplateName(String strMsgTemplateName) {
        this.strMsgTemplateName = strMsgTemplateName;
    }

    public void setMsgType(int nMsgType) {
        this.nMsgType = nMsgType;
    }

    public String getTimeoutField() {
        return this.strTimeoutField;
    }

    public void setTimeoutField(String strTimeoutField) {
        this.strTimeoutField = strTimeoutField;
    }

    @Override
    protected void CloneCopy(Object dst) {
        super.CloneCopy(dst);
        WFInteractiveProcessConfig wfInteractiveProcessConfig = (WFInteractiveProcessConfig)((Object)dst);
        wfInteractiveProcessConfig.setActors(this.strActors);
        wfInteractiveProcessConfig.setUserActions(this.strUserActions);
        wfInteractiveProcessConfig.setUDActors(this.strUDActors);
        wfInteractiveProcessConfig.setTimeout(this.nTimeout);
        wfInteractiveProcessConfig.setTimeoutNext(this.strTimeoutNext);
        wfInteractiveProcessConfig.setTimeoutType(this.strTimeoutType);
        wfInteractiveProcessConfig.setTimeoutField(this.strTimeoutField);
        wfInteractiveProcessConfig.setWorktimeType(this.strWorktimeType);
        wfInteractiveProcessConfig.setSendInform(this.isSendInform());
        wfInteractiveProcessConfig.setMsgTemplateId(this.getMsgTemplateId());
        wfInteractiveProcessConfig.setMsgTemplateName(this.getMsgTemplateName());
        wfInteractiveProcessConfig.setMsgType(this.getMsgType());
        if (this.iaActionsConfig != null) {
            Iterator<WFAction> iterator = this.iaActionsConfig.iterator();
            while (iterator.hasNext()) {
                WFInteractiveActionConfig wfInteractiveActionConfig = (WFInteractiveActionConfig)((Object)iterator.next());
                wfInteractiveProcessConfig.getIAActionsConfig().add((Object)wfInteractiveActionConfig);
            }
        }
        if (this.userActionList != null) {
            for (WFAction wfAction : this.userActionList) {
                wfInteractiveProcessConfig.getUserActionList().add(wfAction);
            }
        }
        wfInteractiveProcessConfig.setActorIAActionControl(this.isActorIAActionControl());
    }

    protected Object CreateCloneObject() {
        return new WFInteractiveProcessConfig();
    }

    public boolean isActorIAActionControl() {
        return this.bActorIAActionControl;
    }

    public void setActorIAActionControl(boolean bActorIAActionControl) {
        this.bActorIAActionControl = bActorIAActionControl;
    }
}

