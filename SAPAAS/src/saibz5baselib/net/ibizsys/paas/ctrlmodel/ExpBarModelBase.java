/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.expbar.ExpBarItem;
import net.ibizsys.paas.control.expbar.ExpBarRootItem;
import net.ibizsys.paas.control.expbar.IExpBarItem;
import net.ibizsys.paas.ctrlmodel.CtrlModelBase;
import net.ibizsys.paas.ctrlmodel.IExpBarModel;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.sf.json.JSONObject;

public abstract class ExpBarModelBase
extends CtrlModelBase
implements IExpBarModel {
    protected ExpBarRootItem expBarRootItem = new ExpBarRootItem();

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.onPrepareRootItem(this.getRootItem());
    }

    @Override
    public String getControlType() {
        return "EXPBAR";
    }

    protected void onPrepareRootItem(ExpBarRootItem expBarRootItem) throws Exception {
    }

    @Override
    public void fillFetchResult(MDAjaxActionResult fetchResult) throws Exception {
        for (IExpBarItem iExpBarItem : this.getRootItem().getItems()) {
            JSONObject jo = ExpBarItem.toJSONObject(iExpBarItem, null);
            fetchResult.getRows().add(jo);
        }
    }

    @Override
    public ExpBarRootItem getRootItem() {
        return this.expBarRootItem;
    }
}

