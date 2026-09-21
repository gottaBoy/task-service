/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.web;

import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UIActionModelAjaxActionResult
extends AjaxActionResult {
    private static final Log log = LogFactory.getLog(UIActionModelAjaxActionResult.class);
    public static final String ATTR_UIACTIONMODEL = "uiactionmodel";
    public static final String ATTR_UIACTIONPARAM = "uiactionparam";
    protected JSONObject uiActionParamJO = null;
    private String strUIActionMode = null;
    private String strUIActionTag = null;
    private String strUIActionTarget = null;
    private String strUIActionConfirmMsg = null;
    private String strUIActionFrontType = null;
    private String strUIActionFrontViewTag = null;
    private String strUIActionFrontViewTitle = null;
    private String strUIActionFrontViewOpenMode = null;

    public void setUIActionMode(String strUIActionMode) {
        this.strUIActionMode = strUIActionMode;
    }

    public String getUIActionMode() {
        return this.strUIActionMode;
    }

    public void setUIActionTag(String strUIActionTag) {
        this.strUIActionTag = strUIActionTag;
    }

    public String getUIActionTag() {
        return this.strUIActionTag;
    }

    public void setUIActionTarget(String strUIActionTarget) {
        this.strUIActionTarget = strUIActionTarget;
    }

    public String getUIActionTarget() {
        return this.strUIActionTarget;
    }

    public void setUIActionConfirmMsg(String strUIActionConfirmMsg) {
        this.strUIActionConfirmMsg = strUIActionConfirmMsg;
    }

    public String getUIActionConfirmMsg() {
        return this.strUIActionConfirmMsg;
    }

    public void setUIActionFrontType(String strUIActionFrontType) {
        this.strUIActionFrontType = strUIActionFrontType;
    }

    public String getUIActionFrontType() {
        return this.strUIActionFrontType;
    }

    public void setUIActionFrontViewTag(String strUIActionFrontViewTag) {
        this.strUIActionFrontViewTag = strUIActionFrontViewTag;
    }

    public String getUIActionFrontViewTag() {
        return this.strUIActionFrontViewTag;
    }

    public void setUIActionFrontViewTitle(String strUIActionFrontViewTitle) {
        this.strUIActionFrontViewTitle = strUIActionFrontViewTitle;
    }

    public String getUIActionFrontViewTitle() {
        return this.strUIActionFrontViewTitle;
    }

    public void setUIActionFrontViewOpenMode(String strUIActionFrontViewOpenMode) {
        this.strUIActionFrontViewOpenMode = strUIActionFrontViewOpenMode;
    }

    public String getUIActionFrontViewOpenMode() {
        return this.strUIActionFrontViewOpenMode;
    }

    public JSONObject getUIActionParam(boolean bCreate) {
        if (this.uiActionParamJO != null) {
            return this.uiActionParamJO;
        }
        if (bCreate) {
            this.uiActionParamJO = new JSONObject();
        }
        return this.uiActionParamJO;
    }

    @Override
    protected void fillJSONObject(JSONObject objJSON) {
        super.fillJSONObject(objJSON);
        try {
            JSONObject uiactionJO = new JSONObject();
            JSONObjectHelper.putRaw(uiactionJO, "actionmode", this.getUIActionMode());
            JSONObjectHelper.putRaw(uiactionJO, "tag", this.getUIActionTag());
            JSONObjectHelper.putRaw(uiactionJO, "type", "DEUIACTION");
            if (!StringHelper.isNullOrEmpty(this.getUIActionTarget())) {
                JSONObjectHelper.putRaw(uiactionJO, "actiontarget", this.getUIActionTarget());
            }
            if (!(StringHelper.compare(this.getUIActionMode(), "BACKEND", true) != 0 && StringHelper.compare(this.getUIActionMode(), "WFBACKEND", true) != 0 || StringHelper.isNullOrEmpty(this.getUIActionConfirmMsg()))) {
                JSONObjectHelper.putRaw(uiactionJO, "confirmmsg", this.getUIActionConfirmMsg());
            }
            if (StringHelper.compare(this.getUIActionMode(), "FRONT", true) == 0 || StringHelper.compare(this.getUIActionMode(), "WFFRONT", true) == 0) {
                if (!StringHelper.isNullOrEmpty(this.getUIActionFrontType())) {
                    JSONObjectHelper.putRaw(uiactionJO, "fronttype", this.getUIActionFrontType());
                }
                if (StringHelper.compare(this.getUIActionFrontType(), "WIZARD", false) == 0) {
                    JSONObject frontViewNode = new JSONObject();
                    JSONObjectHelper.putRaw(frontViewNode, "classname", this.getUIActionFrontViewTag());
                    JSONObjectHelper.putRaw(frontViewNode, "title", this.getUIActionFrontViewTitle());
                    if (!StringHelper.isNullOrEmpty(this.getUIActionFrontViewOpenMode())) {
                        JSONObjectHelper.putRaw(frontViewNode, "openmode", this.getUIActionFrontViewOpenMode());
                    }
                    JSONObjectHelper.putRaw(uiactionJO, "frontview", frontViewNode);
                }
            }
            JSONObjectHelper.putRaw(objJSON, ATTR_UIACTIONMODEL, uiactionJO);
            if (this.getUIActionParam(false) != null) {
                JSONObjectHelper.putRaw(objJSON, ATTR_UIACTIONPARAM, this.getUIActionParam(true));
            }
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format("\u586b\u5145\u754c\u9762\u884c\u4e3a\u8fd0\u884c\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()), (Throwable)ex);
        }
    }
}

