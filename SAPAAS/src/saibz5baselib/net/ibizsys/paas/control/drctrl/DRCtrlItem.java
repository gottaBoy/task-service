/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.control.drctrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.control.drctrl.IDRCtrlItem;
import net.ibizsys.paas.ctrlmodel.IDRCtrlModel;
import net.ibizsys.paas.security.AccessUserModes;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;

public class DRCtrlItem
implements IDRCtrlItem {
    public static final String DRCTRLITEM_COUNTERID = "counterid";
    public static final String DRCTRLITEM_COUNTERMODE = "countermode";
    public static final String DRCTRLITEM_ID = "id";
    public static final String DRCTRLITEM_PID = "pid";
    public static final String DRCTRLITEM_TEXT = "text";
    public static final String DRCTRLITEM_ICONPATH = "icon";
    public static final String DRCTRLITEM_TEXTCLS = "textcls";
    public static final String DRCTRLITEM_ICONCLS = "iconcls";
    public static final String DRCTRLITEM_ITEMS = "items";
    public static final String DRCTRLITEM_LEAF = "leaf";
    public static final String DRCTRLITEM_VIEWID = "viewid";
    public static final String DRCTRLITEM_DRITEM = "dritem";
    public static final String DRCTRLITEM_VIEWPARAM = "viewparam";
    public static final String DRCTRLITEM_EXPANDED = "expanded";
    public static final String DRCTRLITEM_ENABLED = "enabled";
    public static final String EXPBARITEM_TEXTLANRESTAG = "textlanrestag";
    public static final String DRCTRLITEM_DATATREEID = "datatreeid";
    private String strId = "";
    private String strText = "";
    private boolean bExpanded = false;
    private String strDRViewId = "";
    private int nAccUserMode = AccessUserModes.UNKNOWN;
    private String strAccessKey = null;
    private String strEnableMode = "ALL";
    private String strTestEnableDEActionName = null;
    private String strTestEnableDEOPPriv = null;
    private HashMap<String, String> viewParamMap = new HashMap();
    private String strPId = "";
    private String strTextCls = "";
    private String strIconCls = "";
    private String strIconPath = "";
    private String strIconClsX = "";
    private String strIconPathX = "";
    private String strCounterId = "";
    private String strTextLanResTag = "";
    private String strDataTreeId = "";
    private ArrayList<IDRCtrlItem> items = new ArrayList();

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
    public ArrayList<IDRCtrlItem> getItems() {
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
    public String getIconClsX() {
        return this.strIconClsX;
    }

    @Override
    public String getIconPathX() {
        return this.strIconPathX;
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

    public void setIconClsX(String strIconClsX) {
        this.strIconClsX = strIconClsX;
    }

    public void setIconPathX(String strIconPathX) {
        this.strIconPathX = strIconPathX;
    }

    public void setCounterId(String strCounterId) {
        this.strCounterId = strCounterId;
    }

    public static JSONObject toJSONObject(IDRCtrlItem iExpBarItem, JSONObject jsonObject, IDRCtrlModel iDRCtrlModel) throws Exception {
        if (jsonObject == null) {
            jsonObject = new JSONObject();
        }
        jsonObject.put(DRCTRLITEM_ID, JSONObjectHelper.stripQuotes(iExpBarItem.getId(), true));
        jsonObject.put(DRCTRLITEM_TEXT, JSONObjectHelper.stripQuotes(iExpBarItem.getText(), true));
        if (!StringHelper.isNullOrEmpty(iExpBarItem.getTextCls())) {
            jsonObject.put(DRCTRLITEM_TEXTCLS, JSONObjectHelper.stripQuotes(iExpBarItem.getTextCls(), true));
        }
        if (!StringHelper.isNullOrEmpty(iExpBarItem.getIconPath())) {
            jsonObject.put(DRCTRLITEM_ICONPATH, JSONObjectHelper.stripQuotes(iDRCtrlModel.getViewController().getAppModel().getAppPFHelper().mapImageRealUrl(iExpBarItem.getIconPath()), true));
        }
        if (!StringHelper.isNullOrEmpty(iExpBarItem.getIconCls())) {
            jsonObject.put(DRCTRLITEM_ICONCLS, JSONObjectHelper.stripQuotes(iExpBarItem.getIconCls(), true));
        }
        jsonObject.put(DRCTRLITEM_COUNTERID, JSONObjectHelper.stripQuotes(iExpBarItem.getCounterId(), true));
        jsonObject.put(DRCTRLITEM_EXPANDED, iExpBarItem.isExpanded());
        if (iDRCtrlModel != null) {
            jsonObject.put(DRCTRLITEM_ENABLED, iDRCtrlModel.testDRCtrlItemEnabled(iExpBarItem));
        }
        JSONObject drItemJO = new JSONObject();
        drItemJO.put(DRCTRLITEM_VIEWID, JSONObjectHelper.stripQuotes(iExpBarItem.getDRViewId(), true));
        JSONObject viewParamJO = new JSONObject();
        Iterator<String> viewParamKeys = iExpBarItem.getViewParamNames();
        while (viewParamKeys.hasNext()) {
            String strKey = viewParamKeys.next();
            String objValue = iExpBarItem.getViewParam(strKey);
            JSONObjectHelper.put(viewParamJO, strKey, objValue);
        }
        drItemJO.put(DRCTRLITEM_VIEWPARAM, (Object)viewParamJO);
        jsonObject.put(DRCTRLITEM_DRITEM, (Object)drItemJO);
        if (iExpBarItem.getItems().size() == 0) {
            if (StringHelper.isNullOrEmpty(iExpBarItem.getDataTreeId())) {
                jsonObject.put(DRCTRLITEM_LEAF, true);
            } else {
                jsonObject.put(DRCTRLITEM_LEAF, false);
            }
        } else {
            ArrayList<JSONObject> items = new ArrayList<JSONObject>();
            for (IDRCtrlItem childExpBarItem : iExpBarItem.getItems()) {
                JSONObject jsonItem = DRCtrlItem.toJSONObject(childExpBarItem, null, iDRCtrlModel);
                items.add(jsonItem);
            }
            jsonObject.put(DRCTRLITEM_ITEMS, (Object)items.toArray());
        }
        if (!StringHelper.isNullOrEmpty(iExpBarItem.getDataTreeId())) {
            jsonObject.put(DRCTRLITEM_DATATREEID, JSONObjectHelper.stripQuotes(iExpBarItem.getDataTreeId(), true));
        }
        return jsonObject;
    }

    @Override
    public String getDRViewId() {
        return this.strDRViewId;
    }

    public void setDRViewId(String strDRViewId) {
        this.strDRViewId = strDRViewId;
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

    public void reset() {
        this.items.clear();
        this.viewParamMap.clear();
    }

    @Override
    public String getAccessKey() {
        return this.strAccessKey;
    }

    public void setAccessKey(String strAccessKey) {
        this.strAccessKey = strAccessKey;
    }

    @Override
    public int getAccUserMode() {
        return this.nAccUserMode;
    }

    public void setAccUserMode(int nAccUserMode) {
        this.nAccUserMode = nAccUserMode;
    }

    @Override
    public String getEnableMode() {
        return this.strEnableMode;
    }

    public void setEnableMode(String strEnableMode) {
        this.strEnableMode = strEnableMode;
    }

    @Override
    public String getTestEnableDEActionName() {
        return this.strTestEnableDEActionName;
    }

    public void setTestEnableDEActionName(String strTestEnableDEActionName) {
        this.strTestEnableDEActionName = strTestEnableDEActionName;
    }

    @Override
    public String getTestEnableDEOPPriv() {
        return this.strTestEnableDEOPPriv;
    }

    public void setTestEnableDEOPPriv(String strTestEnableDEOPPriv) {
        this.strTestEnableDEOPPriv = strTestEnableDEOPPriv;
    }

    public void setTextLanResTag(String strTextLanResTag) {
        this.strTextLanResTag = strTextLanResTag;
    }

    @Override
    public String getTextLanResTag() {
        return this.strTextLanResTag;
    }

    @Override
    public String getDataTreeId() {
        return this.strDataTreeId;
    }

    public void setDataTreeId(String strDataTreeId) {
        this.strDataTreeId = strDataTreeId;
    }
}

