/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SRFWF.Model;

import SA.SRFramework.Utility.StringHelper;
import SRFWF.Ctrl.SRFWFWorkflowProcess;
import SRFWF.Model.WFBaseProcessConfig;
import SRFWF.Model.WFEmbedWFReturnsConfig;
import org.w3c.dom.Node;

public abstract class WFBaseEmbedWFConfig
extends WFBaseProcessConfig {
    public static final String TAG_TIMEOUT = "TIMEOUT";
    public static final String TAG_TIMEOUTNEXT = "TIMEOUTNEXT";
    public static String TAG_TIMEOUTTYPE = "TIMEOUTTYPE";
    public static String TAG_TIMEOUTFIELD = "TIMEOUTFIELD";
    public static String TAG_WORKTIMETYPE = "WORKTIMETYPE";
    protected int nTimeout = 0;
    protected String strTimeoutNext = "";
    protected String strTimeoutType = "";
    protected String strTimeoutField = "";
    protected String strWorktimeType = "";
    protected WFEmbedWFReturnsConfig returnsConfig = null;

    public WFBaseEmbedWFConfig() {
        this.setObject(SRFWFWorkflowProcess.class.getName());
        this.returnsConfig = new WFEmbedWFReturnsConfig(this);
    }

    @Override
    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXWFEMBEDWFRETURNS", (boolean)true) == 0) {
            this.returnsConfig.LoadConfig(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public WFEmbedWFReturnsConfig getEmbedWFReturnsConfig() {
        return this.returnsConfig;
    }

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_TIMEOUT, (boolean)true) == 0) {
            this.setTimeout(WFBaseEmbedWFConfig.GetValue((String)strValue, (int)this.nTimeout));
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
        super.OnSetProperty(strName, strValue);
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

    @Override
    public boolean isSuspendProcess() {
        return true;
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

    public String getTimeoutField() {
        return this.strTimeoutField;
    }

    public void setTimeoutField(String strTimeoutField) {
        this.strTimeoutField = strTimeoutField;
    }
}

