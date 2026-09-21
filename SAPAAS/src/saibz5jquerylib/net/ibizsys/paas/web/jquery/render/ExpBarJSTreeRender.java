/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.expbar.IExpBarItem
 *  net.ibizsys.paas.control.tree.ITreeNode
 *  net.ibizsys.paas.ctrlhandler.IExpBarRender
 *  net.ibizsys.paas.ctrlmodel.IExpBarModel
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.MDAjaxActionResult
 *  net.ibizsys.paas.web.WebContext
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.web.jquery.render;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.control.expbar.IExpBarItem;
import net.ibizsys.paas.control.tree.ITreeNode;
import net.ibizsys.paas.ctrlhandler.IExpBarRender;
import net.ibizsys.paas.ctrlmodel.IExpBarModel;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.paas.web.jquery.render.JSTreeRenderBase;
import net.sf.json.JSONObject;

public class ExpBarJSTreeRender
extends JSTreeRenderBase
implements IExpBarRender {
    public static final String EXPBARITEM_COUNTERID = "counterid";
    public static final String EXPBARITEM_COUNTERMODE = "countermode";
    public static final String EXPBARITEM_ID = "id";
    public static final String EXPBARITEM_PID = "pid";
    public static final String EXPBARITEM_TEXT = "text";
    public static final String EXPBARITEM_ICONPATH = "icon";
    public static final String EXPBARITEM_TEXTCLS = "textcls";
    public static final String EXPBARITEM_ICONCLS = "iconcls";
    public static final String EXPBARITEM_ITEMS = "children";
    public static final String EXPBARITEM_LEAF = "leaf";
    public static final String EXPBARITEM_VIEWID = "viewid";
    public static final String EXPBARITEM_EXPITEM = "expitem";
    public static final String EXPBARITEM_VIEWPARAM = "viewparam";
    public static final String EXPBARITEM_EXPANDED = "opened";
    public static final String EXPBARITEM_STATE = "state";

    public void fillFetchResult(IExpBarModel iExpBarModel, MDAjaxActionResult fetchResult) throws Exception {
        fetchResult.setArrayMode(this.isFetchResultArrayMode());
        for (IExpBarItem iExpBarItem : iExpBarModel.getRootItem().getItems()) {
            JSONObject jo = ExpBarJSTreeRender.toJSONObject(iExpBarItem, null);
            fetchResult.getRows().add(jo);
        }
    }

    public static JSONObject toJSONObject(IExpBarItem iExpBarItem, JSONObject jsonObject) throws Exception {
        if (jsonObject == null) {
            jsonObject = new JSONObject();
        }
        String strText = iExpBarItem.getText();
        String strTextLanResTag = iExpBarItem.getTextLanResTag();
        if (!StringHelper.isNullOrEmpty((String)strTextLanResTag)) {
            strText = WebContext.getCurrent().getLocalization(strTextLanResTag, strText);
        }
        jsonObject.put(EXPBARITEM_ID, JSONObjectHelper.stripQuotes((String)iExpBarItem.getId()));
        jsonObject.put(EXPBARITEM_TEXT, JSONObjectHelper.stripQuotes((String)strText));
        jsonObject.put(EXPBARITEM_TEXTCLS, JSONObjectHelper.stripQuotes((String)iExpBarItem.getTextCls()));
        jsonObject.put(EXPBARITEM_ICONPATH, JSONObjectHelper.stripQuotes((String)iExpBarItem.getIconPath()));
        jsonObject.put(EXPBARITEM_COUNTERID, JSONObjectHelper.stripQuotes((String)iExpBarItem.getCounterId()));
        if (iExpBarItem.getCounterMode() != 0) {
            jsonObject.put(EXPBARITEM_COUNTERMODE, iExpBarItem.getCounterMode());
        }
        JSONObject stateJO = new JSONObject();
        stateJO.put(EXPBARITEM_EXPANDED, iExpBarItem.isExpanded());
        jsonObject.put(EXPBARITEM_STATE, (Object)stateJO);
        JSONObject drItemJO = new JSONObject();
        drItemJO.put(EXPBARITEM_VIEWID, JSONObjectHelper.stripQuotes((String)iExpBarItem.getExpViewId()));
        JSONObject viewParamJO = new JSONObject();
        Iterator viewParamKeys = iExpBarItem.getViewParamNames();
        while (viewParamKeys.hasNext()) {
            String strKey = (String)viewParamKeys.next();
            String objValue = iExpBarItem.getViewParam(strKey);
            JSONObjectHelper.put((JSONObject)viewParamJO, (String)strKey, (Object)objValue);
        }
        drItemJO.put(EXPBARITEM_VIEWPARAM, (Object)viewParamJO);
        jsonObject.put(EXPBARITEM_EXPITEM, (Object)drItemJO);
        if (iExpBarItem.getItems().size() == 0) {
            jsonObject.put(EXPBARITEM_ITEMS, false);
        } else {
            ArrayList<JSONObject> items = new ArrayList<JSONObject>();
            for (IExpBarItem childExpBarItem : iExpBarItem.getItems()) {
                JSONObject jsonItem = ExpBarJSTreeRender.toJSONObject(childExpBarItem, null);
                items.add(jsonItem);
            }
            jsonObject.put(EXPBARITEM_ITEMS, (Object)items.toArray());
        }
        return jsonObject;
    }

    public static JSONObject toJSONObject(ITreeNode iTreeNode, JSONObject jsonObject) throws Exception {
        if (jsonObject == null) {
            jsonObject = new JSONObject();
        }
        jsonObject.put(EXPBARITEM_ID, JSONObjectHelper.stripQuotes((String)iTreeNode.getId()));
        jsonObject.put(EXPBARITEM_TEXT, JSONObjectHelper.stripQuotes((String)iTreeNode.getText()));
        jsonObject.put(EXPBARITEM_TEXTCLS, JSONObjectHelper.stripQuotes((String)iTreeNode.getCssClass()));
        jsonObject.put(EXPBARITEM_ICONPATH, JSONObjectHelper.stripQuotes((String)iTreeNode.getIcon()));
        jsonObject.put(EXPBARITEM_ICONCLS, JSONObjectHelper.stripQuotes((String)iTreeNode.getIconCssClass()));
        jsonObject.put(EXPBARITEM_COUNTERID, JSONObjectHelper.stripQuotes((String)iTreeNode.getCounterId()));
        if (iTreeNode.getCounterMode() != 0) {
            jsonObject.put(EXPBARITEM_COUNTERMODE, iTreeNode.getCounterMode());
        }
        JSONObject stateJO = new JSONObject();
        stateJO.put(EXPBARITEM_EXPANDED, iTreeNode.isExpanded());
        jsonObject.put(EXPBARITEM_STATE, (Object)stateJO);
        JSONObject drItemJO = new JSONObject();
        drItemJO.put(EXPBARITEM_VIEWID, (Object)iTreeNode.getTreeNodeType());
        JSONObject viewParamJO = new JSONObject();
        drItemJO.put(EXPBARITEM_VIEWPARAM, (Object)viewParamJO);
        jsonObject.put(EXPBARITEM_EXPITEM, (Object)drItemJO);
        if (iTreeNode.getChildNodes() == null) {
            jsonObject.put(EXPBARITEM_ITEMS, false);
        } else {
            ArrayList<JSONObject> items = new ArrayList<JSONObject>();
            Iterator treeNodes = iTreeNode.getChildNodes();
            while (treeNodes.hasNext()) {
                ITreeNode childTreeNode = (ITreeNode)treeNodes.next();
                JSONObject jsonItem = ExpBarJSTreeRender.toJSONObject(childTreeNode, null);
                items.add(jsonItem);
            }
            jsonObject.put(EXPBARITEM_ITEMS, (Object)items.toArray());
        }
        return jsonObject;
    }

    public void fillFetchResult(ArrayList<ITreeNode> treeNodeList, MDAjaxActionResult fetchResult) throws Exception {
        fetchResult.setArrayMode(this.isFetchResultArrayMode());
        for (ITreeNode iTreeNode : treeNodeList) {
            JSONObject jo = ExpBarJSTreeRender.toJSONObject(iTreeNode, null);
            fetchResult.getRows().add(jo);
        }
    }
}

