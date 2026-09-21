/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.controller.IPickupViewController
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.SimpleEntity
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.AjaxActionResult
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.MDAjaxActionResult
 *  net.ibizsys.paas.web.WebContext
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package net.ibizsys.ssdyna.controller;

import java.util.ArrayList;
import net.ibizsys.paas.controller.IPickupViewController;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.ssdyna.controller.ViewControllerBase;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public abstract class PickupViewControllerBase
extends ViewControllerBase
implements IPickupViewController {
    protected boolean isEnableMultiSelect() {
        return false;
    }

    protected AjaxActionResult onViewAjaxAction(String strAction) throws Exception {
        if (StringHelper.compare((String)strAction, (String)"CONVERTPICKUPDATA", (boolean)true) == 0) {
            return this.onConvertPickupData();
        }
        return super.onViewAjaxAction(strAction);
    }

    protected AjaxActionResult onConvertPickupData() throws Exception {
        MDAjaxActionResult ajaxActionResult = new MDAjaxActionResult();
        String strPostValue = WebContext.getRemoteCallArg((IWebContext)this.getWebContext());
        if (StringHelper.isNullOrEmpty((String)strPostValue)) {
            throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u63d0\u4ea4\u9009\u62e9\u8f6c\u5316\u6570\u636e"));
        }
        ArrayList entityList = new ArrayList();
        JSONArray ja = JSONArray.fromString((String)strPostValue);
        int i = 0;
        while (i < ja.length()) {
            JSONObject jo = ja.getJSONObject(i);
            SimpleEntity simpleEntity = new SimpleEntity();
            DataObject.fromJSONObject((IDataObject)simpleEntity, (JSONObject)jo);
            entityList.add(simpleEntity);
            ++i;
        }
        entityList = this.getService().convertPickupData(entityList);
        for (IEntity iEntity : entityList) {
            ajaxActionResult.getRows().add(DataObject.toJSONObject((IDataObject)iEntity, (boolean)false));
        }
        return ajaxActionResult;
    }
}

