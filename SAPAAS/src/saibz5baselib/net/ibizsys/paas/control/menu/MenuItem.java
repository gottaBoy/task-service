/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.control.menu;

import net.ibizsys.paas.control.menu.IMenuItem;
import net.ibizsys.paas.control.menu.IMenuItemFiller;
import net.ibizsys.paas.security.AccessUserModes;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;

public class MenuItem
implements IMenuItem {
    public static final String MENUITEM_COUNTERID = "counterid";
    public static final String MENUITEM_ID = "id";
    public static final String MENUITEM_PID = "pid";
    public static final String MENUITEM_TEXT = "text";
    public static final String MENUITEM_ICONPATH = "icon";
    public static final String MENUITEM_TEXTCLS = "textcls";
    public static final String MENUITEM_ICONCLS = "iconcls";
    public static final String MENUITEM_ITEMS = "items";
    public static final String MENUITEM_LEAF = "leaf";
    public static final String MENUITEM_EXPANDED = "expanded";
    public static final String MENUITEM_TOOLTIP = "tooltip";
    public static final String MENUITEM_TOOLTIPLANRESTAG = "tooltiplanrestag";
    public static final String MENUITEM_TEXTLANRESTAG = "textlanrestag";
    public static final String MENUITEM_ACCESSKEY = "accesskey";
    public static final String MENUITEM_ACCUSERMODE = "accusermode";
    private String strId = "";
    private String strText = "";
    private boolean bExpanded = false;
    private String strItemType = null;
    private int nAccUserMode = AccessUserModes.UNKNOWN;
    private String strAccessKey = null;
    private boolean bHidden = false;
    private String strPId = "";
    private String strTextCls = "";
    private String strIconCls = "";
    private String strIconPath = "";
    private String strCounterId = "";
    private String strTextLanResTag = "";
    private String strTooltip = "";
    private String strTooltipLanResTag = "";
    private String strFillerObj = null;
    private IMenuItemFiller iMenuItemFiller = null;

    @Override
    public String getId() {
        return this.strId;
    }

    @Override
    public String getText() {
        return this.strText;
    }

    @Override
    public boolean isExpanded() {
        return this.bExpanded;
    }

    @Override
    public String getPId() {
        return this.strPId;
    }

    @Override
    public String getTextCls() {
        return this.strTextCls;
    }

    @Override
    public String getIconCls() {
        return this.strIconCls;
    }

    @Override
    public String getIconPath() {
        return this.strIconPath;
    }

    @Override
    public String getCounterId() {
        return this.strCounterId;
    }

    @Override
    public void setAttribute(String strName, Object objValue) {
    }

    @Override
    public Object getAttribute(String strName) {
        return null;
    }

    public void setId(String strId) {
        this.strId = strId;
    }

    public void setText(String strText) {
        this.strText = strText;
    }

    public void setExpanded(boolean bExpanded) {
        this.bExpanded = bExpanded;
    }

    public void setPId(String strPId) {
        this.strPId = strPId;
    }

    public void setTextCls(String strTextCls) {
        this.strTextCls = strTextCls;
    }

    public void setIconCls(String strIconCls) {
        this.strIconCls = strIconCls;
    }

    public void setIconPath(String strIconPath) {
        this.strIconPath = strIconPath;
    }

    public void setCounterId(String strCounterId) {
        this.strCounterId = strCounterId;
    }

    @Override
    public String getItemType() {
        return this.strItemType;
    }

    public void setItemType(String strItemType) {
        this.strItemType = strItemType;
    }

    @Override
    public String getAccessKey() {
        return this.strAccessKey;
    }

    public void setAccessKey(String strAccessKey) {
        this.strAccessKey = strAccessKey;
    }

    public static JSONObject toJSONObject(IMenuItem iMenuItem, JSONObject jsonObject) throws Exception {
        if (jsonObject == null) {
            jsonObject = new JSONObject();
        }
        jsonObject.put(MENUITEM_ID, JSONObjectHelper.stripQuotes(iMenuItem.getId(), true));
        IWebContext iWebContext = WebContext.getCurrent();
        if (iWebContext == null) {
            jsonObject.put(MENUITEM_TEXT, JSONObjectHelper.stripQuotes(iMenuItem.getText(), true));
            jsonObject.put(MENUITEM_TOOLTIP, JSONObjectHelper.stripQuotes(iMenuItem.getTooltip(), true));
        } else {
            if (!StringHelper.isNullOrEmpty(iMenuItem.getTextLanResTag())) {
                jsonObject.put(MENUITEM_TEXT, JSONObjectHelper.stripQuotes(iWebContext.getLocalization(iMenuItem.getTextLanResTag(), iMenuItem.getText()), true));
            } else {
                jsonObject.put(MENUITEM_TEXT, JSONObjectHelper.stripQuotes(iMenuItem.getText(), true));
            }
            if (!StringHelper.isNullOrEmpty(iMenuItem.getTooltipLanResTag())) {
                jsonObject.put(MENUITEM_TOOLTIP, JSONObjectHelper.stripQuotes(iWebContext.getLocalization(iMenuItem.getTooltipLanResTag(), iMenuItem.getTooltip()), true));
            } else {
                jsonObject.put(MENUITEM_TOOLTIP, JSONObjectHelper.stripQuotes(iMenuItem.getTooltip(), true));
            }
        }
        jsonObject.put(MENUITEM_TEXTCLS, JSONObjectHelper.stripQuotes(iMenuItem.getTextCls(), true));
        jsonObject.put(MENUITEM_ICONPATH, JSONObjectHelper.stripQuotes(iMenuItem.getIconPath(), true));
        jsonObject.put(MENUITEM_ICONCLS, JSONObjectHelper.stripQuotes(iMenuItem.getIconCls(), true));
        jsonObject.put(MENUITEM_COUNTERID, JSONObjectHelper.stripQuotes(iMenuItem.getCounterId(), true));
        jsonObject.put(MENUITEM_EXPANDED, iMenuItem.isExpanded());
        return jsonObject;
    }

    @Override
    public int getAccUserMode() {
        return this.nAccUserMode;
    }

    public void setAccUserMode(int nAccUserMode) {
        this.nAccUserMode = nAccUserMode;
    }

    @Override
    public String getTextLanResTag() {
        return this.strTextLanResTag;
    }

    public void setTextLanResTag(String strTextLanResTag) {
        this.strTextLanResTag = strTextLanResTag;
    }

    @Override
    public String getTooltip() {
        return this.strTooltip;
    }

    public void setTooltip(String strTooltip) {
        this.strTooltip = strTooltip;
    }

    @Override
    public String getTooltipLanResTag() {
        return this.strTooltipLanResTag;
    }

    public void setTooltipLanResTag(String strTooltipLanResTag) {
        this.strTooltipLanResTag = strTooltipLanResTag;
    }

    @Override
    public boolean isHidden() {
        return this.bHidden;
    }

    public void setHidden(boolean bHidden) {
        this.bHidden = bHidden;
    }

    @Override
    public String getFillerObj() {
        return this.strFillerObj;
    }

    public void setFillerObj(String strFillerObj) {
        this.strFillerObj = strFillerObj;
    }

    @Override
    public IMenuItemFiller getFiller() throws Exception {
        if (StringHelper.isNullOrEmpty(this.getFillerObj())) {
            return null;
        }
        if (this.iMenuItemFiller == null) {
            this.iMenuItemFiller = (IMenuItemFiller)ObjectHelper.create(this.getFillerObj());
        }
        return this.iMenuItemFiller;
    }
}

