/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.ctrlhandler;

import java.util.Iterator;
import net.ibizsys.paas.ctrlhandler.CounterHandlerBase;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;

public abstract class DRCounterHandlerBase
extends CounterHandlerBase {
    protected abstract IDataEntityModel getDEModel() throws Exception;

    protected IService getService() throws Exception {
        return this.getDEModel().getService(this.getViewController().getSessionFactory());
    }

    @Override
    protected AjaxActionResult onFetch() throws Exception {
        MDAjaxActionResult mdAjaxActionResult = new MDAjaxActionResult();
        String strKey = WebContext.getKey(this.getWebContext());
        if (StringHelper.isNullOrEmpty(strKey)) {
            strKey = WebContext.getKeys(this.getWebContext());
        }
        if (StringHelper.isNullOrEmpty(strKey) || strKey.indexOf("SRFTEMPKEY:") == 0) {
            JSONObject dataObject = mdAjaxActionResult.getData(true);
            Iterator<String> counterItems = this.getCounterItems();
            while (counterItems.hasNext()) {
                dataObject.put(counterItems.next(), 0);
            }
        } else {
            Object iEntity = this.getService().getDEModel().createEntity();
            iEntity.set(this.getDEModel().getKeyDEField().getName(), strKey);
            this.getService().get(iEntity);
            JSONObject dataObject = mdAjaxActionResult.getData(true);
            Iterator<String> counterItems = this.getCounterItems();
            while (counterItems.hasNext()) {
                String strItemName = counterItems.next();
                int nCount = DataObject.getIntegerValue(iEntity, strItemName, 0);
                dataObject.put(strItemName, nCount);
            }
        }
        return mdAjaxActionResult;
    }
}

