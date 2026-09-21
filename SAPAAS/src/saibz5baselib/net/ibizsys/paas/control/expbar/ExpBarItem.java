/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.control.expbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.control.expbar.IExpBarItem;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.sf.json.JSONObject;

public class ExpBarItem
implements IExpBarItem {
    public static final String EXPBARITEM_COUNTERID = "counterid";
    public static final String EXPBARITEM_COUNTERMODE = "countermode";
    public static final String EXPBARITEM_ID = "id";
    public static final String EXPBARITEM_PID = "pid";
    public static final String EXPBARITEM_TEXT = "text";
    public static final String EXPBARITEM_ICONPATH = "icon";
    public static final String EXPBARITEM_TEXTCLS = "textcls";
    public static final String EXPBARITEM_ICONCLS = "iconcls";
    public static final String EXPBARITEM_ITEMS = "items";
    public static final String EXPBARITEM_LEAF = "leaf";
    public static final String EXPBARITEM_VIEWID = "viewid";
    public static final String EXPBARITEM_EXPITEM = "expitem";
    public static final String EXPBARITEM_VIEWPARAM = "viewparam";
    public static final String EXPBARITEM_EXPANDED = "expanded";
    public static final String EXPBARITEM_TEXTLANRESTAG = "textlanrestag";
    private String strId = "";
    private String strText = "";
    private boolean bExpanded = false;
    private String strExpViewId = "";
    private HashMap<String, String> viewParamMap = new HashMap();
    private String strPId = "";
    private String strTextCls = "";
    private String strIconCls = "";
    private String strIconPath = "";
    private String strCounterId = "";
    private int nCounterMode = 0;
    private String strTextLanResTag = "";
    private ArrayList<IExpBarItem> items = new ArrayList();

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
    public ArrayList<IExpBarItem> getItems() {
        return this.items;
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
    public int getCounterMode() {
        return this.nCounterMode;
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

    public void setCounterMode(int nCounterMode) {
        this.nCounterMode = nCounterMode;
    }

    public static JSONObject toJSONObject(IExpBarItem iExpBarItem, JSONObject jsonObject) throws Exception {
        if (jsonObject == null) {
            jsonObject = new JSONObject();
        }
        jsonObject.put(EXPBARITEM_ID, JSONObjectHelper.stripQuotes(iExpBarItem.getId(), true));
        jsonObject.put(EXPBARITEM_TEXT, JSONObjectHelper.stripQuotes(iExpBarItem.getText(), true));
        jsonObject.put(EXPBARITEM_TEXTCLS, JSONObjectHelper.stripQuotes(iExpBarItem.getTextCls(), true));
        jsonObject.put(EXPBARITEM_ICONPATH, JSONObjectHelper.stripQuotes(iExpBarItem.getIconPath(), true));
        jsonObject.put(EXPBARITEM_ICONCLS, JSONObjectHelper.stripQuotes(iExpBarItem.getIconCls(), true));
        jsonObject.put(EXPBARITEM_COUNTERID, JSONObjectHelper.stripQuotes(iExpBarItem.getCounterId(), true));
        if (iExpBarItem.getCounterMode() != 0) {
            jsonObject.put(EXPBARITEM_COUNTERMODE, iExpBarItem.getCounterMode());
        }
        jsonObject.put(EXPBARITEM_EXPANDED, iExpBarItem.isExpanded());
        JSONObject expItemJO = new JSONObject();
        expItemJO.put(EXPBARITEM_VIEWID, JSONObjectHelper.stripQuotes(iExpBarItem.getExpViewId(), true));
        JSONObject viewParamJO = new JSONObject();
        Iterator<String> viewParamKeys = iExpBarItem.getViewParamNames();
        while (viewParamKeys.hasNext()) {
            String strKey = viewParamKeys.next();
            String objValue = iExpBarItem.getViewParam(strKey);
            JSONObjectHelper.put(viewParamJO, strKey, objValue);
        }
        expItemJO.put(EXPBARITEM_VIEWPARAM, (Object)viewParamJO);
        jsonObject.put(EXPBARITEM_EXPITEM, (Object)expItemJO);
        if (iExpBarItem.getItems().size() == 0) {
            jsonObject.put(EXPBARITEM_LEAF, true);
        } else {
            ArrayList<JSONObject> items = new ArrayList<JSONObject>();
            for (IExpBarItem childExpBarItem : iExpBarItem.getItems()) {
                JSONObject jsonItem = ExpBarItem.toJSONObject(childExpBarItem, null);
                items.add(jsonItem);
            }
            jsonObject.put(EXPBARITEM_ITEMS, (Object)items.toArray());
        }
        return jsonObject;
    }

    @Override
    public String getExpViewId() {
        return this.strExpViewId;
    }

    public void setExpViewId(String strExpViewId) {
        this.strExpViewId = strExpViewId;
    }

    @Override
    public void setViewParam(String strKey, String objValue) {
        if (objValue == null) {
            this.viewParamMap.remove(strKey.toLowerCase());
        } else {
            this.viewParamMap.put(strKey.toLowerCase(), objValue);
        }
    }

    @Override
    public String getViewParam(String strKey) {
        return this.viewParamMap.get(strKey.toLowerCase());
    }

    @Override
    public Iterator<String> getViewParamNames() {
        return this.viewParamMap.keySet().iterator();
    }

    public void setTextLanResTag(String strTextLanResTag) {
        this.strTextLanResTag = strTextLanResTag;
    }

    @Override
    public String getTextLanResTag() {
        return this.strTextLanResTag;
    }
}

