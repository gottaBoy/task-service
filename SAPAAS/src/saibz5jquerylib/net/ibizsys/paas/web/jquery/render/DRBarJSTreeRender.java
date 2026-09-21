/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.drctrl.IDRCtrlItem
 *  net.ibizsys.paas.ctrlhandler.IDRBarRender
 *  net.ibizsys.paas.ctrlmodel.IDRBarModel
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.MDAjaxActionResult
 *  net.ibizsys.paas.web.WebContext
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.web.jquery.render;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.control.drctrl.IDRCtrlItem;
import net.ibizsys.paas.ctrlhandler.IDRBarRender;
import net.ibizsys.paas.ctrlmodel.IDRBarModel;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.paas.web.jquery.render.JSTreeRenderBase;
import net.sf.json.JSONObject;

public class DRBarJSTreeRender
extends JSTreeRenderBase
implements IDRBarRender {
    public void fillFetchResult(IDRBarModel iDRBarModel, MDAjaxActionResult fetchResult) throws Exception {
        fetchResult.setArrayMode(true);
        for (IDRCtrlItem iDRBarItem : iDRBarModel.getRootItem().getItems()) {
            JSONObject jo = DRBarJSTreeRender.toJSONObject(iDRBarModel, iDRBarItem, null);
            if (jo == null) continue;
            fetchResult.getRows().add(jo);
        }
    }

    public static JSONObject toJSONObject(IDRBarModel iDRBarModel, IDRCtrlItem iExpBarItem, JSONObject jsonObject) throws Exception {
        if (!iDRBarModel.testDRCtrlItemEnabled(iExpBarItem)) {
            return null;
        }
        if (jsonObject == null) {
            jsonObject = new JSONObject();
        }
        jsonObject.put("id", JSONObjectHelper.stripQuotes((String)iExpBarItem.getId()));
        String strText = iExpBarItem.getText();
        String strTextLanResTag = iExpBarItem.getTextLanResTag();
        if (!StringHelper.isNullOrEmpty((String)strTextLanResTag)) {
            strText = WebContext.getCurrent().getLocalization(strTextLanResTag, strText);
        }
        jsonObject.put("text", JSONObjectHelper.stripQuotes((String)strText));
        jsonObject.put("textcls", JSONObjectHelper.stripQuotes((String)iExpBarItem.getTextCls()));
        if (!StringHelper.isNullOrEmpty((String)iExpBarItem.getIconCls())) {
            jsonObject.put("icon", JSONObjectHelper.stripQuotes((String)iExpBarItem.getIconCls()));
        } else if (!StringHelper.isNullOrEmpty((String)iExpBarItem.getIconPath())) {
            jsonObject.put("icon", JSONObjectHelper.stripQuotes((String)iExpBarItem.getIconPath()));
        }
        jsonObject.put("counterid", JSONObjectHelper.stripQuotes((String)iExpBarItem.getCounterId()));
        JSONObject stateJO = new JSONObject();
        stateJO.put("opened", iExpBarItem.isExpanded());
        jsonObject.put("state", (Object)stateJO);
        JSONObject drItemJO = new JSONObject();
        drItemJO.put("viewid", JSONObjectHelper.stripQuotes((String)iExpBarItem.getDRViewId()));
        JSONObject viewParamJO = new JSONObject();
        Iterator viewParamKeys = iExpBarItem.getViewParamNames();
        while (viewParamKeys.hasNext()) {
            String strKey = (String)viewParamKeys.next();
            String objValue = iExpBarItem.getViewParam(strKey);
            JSONObjectHelper.put((JSONObject)viewParamJO, (String)strKey, (Object)objValue);
        }
        drItemJO.put("viewparam", (Object)viewParamJO);
        jsonObject.put("dritem", (Object)drItemJO);
        if (iExpBarItem.getItems().size() == 0) {
            jsonObject.put("children", false);
        } else {
            ArrayList<JSONObject> items = new ArrayList<JSONObject>();
            for (IDRCtrlItem childExpBarItem : iExpBarItem.getItems()) {
                JSONObject jsonItem = DRBarJSTreeRender.toJSONObject(iDRBarModel, childExpBarItem, null);
                if (jsonItem == null) continue;
                items.add(jsonItem);
            }
            if (items.size() == 0) {
                jsonObject.put("children", false);
            } else {
                jsonObject.put("children", (Object)items.toArray());
            }
        }
        return jsonObject;
    }
}

