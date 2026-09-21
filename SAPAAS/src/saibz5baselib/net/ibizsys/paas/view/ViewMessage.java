/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.view;

import net.ibizsys.paas.core.ModelBase2Impl;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.view.IViewMessage;
import net.sf.json.JSONObject;

public class ViewMessage
extends ModelBase2Impl
implements IViewMessage {
    public static final String TITLE = "title";
    public static final String POS = "pos";
    public static final String TYPE = "type";
    public static final String MESSAGE = "msg";
    public static final String REMOVE = "remove";
    private String strPosition = null;
    private String strMessage = null;
    private String strMessageType = null;
    private String strTitle = null;
    private boolean bEnableRemove = false;

    @Override
    public String getPosition() {
        return this.strPosition;
    }

    @Override
    public String getMessage() {
        return this.strMessage;
    }

    @Override
    public String getMessageType() {
        return this.strMessageType;
    }

    @Override
    public String getTitle() {
        return this.strTitle;
    }

    public void setPosition(String strPosition) {
        this.strPosition = strPosition;
    }

    public void setMessage(String strMessage) {
        this.strMessage = strMessage;
    }

    public void setMessageType(String strMessageType) {
        this.strMessageType = strMessageType;
    }

    public void setTitle(String strTitle) {
        this.strTitle = strTitle;
    }

    public void setId(String strId) {
        this.strId = strId;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    @Override
    public boolean isEnableRemove() {
        return this.bEnableRemove;
    }

    public void setEnableRemove(boolean bEnableRemove) {
        this.bEnableRemove = bEnableRemove;
    }

    public static JSONObject toJSONObject(JSONObject jsonObject, IViewMessage iViewMessage) throws Exception {
        if (jsonObject == null) {
            jsonObject = new JSONObject();
        }
        jsonObject.put(TITLE, JSONObjectHelper.stripQuotes(iViewMessage.getTitle(), true));
        jsonObject.put(POS, JSONObjectHelper.stripQuotes(iViewMessage.getPosition(), true));
        jsonObject.put(TYPE, JSONObjectHelper.stripQuotes(iViewMessage.getMessageType(), true));
        jsonObject.put(MESSAGE, JSONObjectHelper.stripQuotes(iViewMessage.getMessage(), true));
        jsonObject.put(REMOVE, iViewMessage.isEnableRemove());
        return jsonObject;
    }
}

