/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import java.util.ArrayList;
import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.core.IDEDataSetCond;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.ctrlhandler.GridHandlerBase;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.ctrlmodel.ITreeGridModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;

public abstract class TreeGridHandlerBase
extends GridHandlerBase {
    protected ITreeGridModel getTreeGridModel() {
        return (ITreeGridModel)this.getGridModel();
    }

    @Override
    public ICtrlModel getCtrlModel() {
        return this.getTreeGridModel();
    }

    @Override
    protected void onFillFetchParentCondition(ArrayList<IDEDataSetCond> userConditions) throws Exception {
        super.onFillFetchParentCondition(userConditions);
        String strParentKey2 = WebContext.getParentKey2(this.getWebContext());
        if (!StringHelper.isNullOrEmpty(strParentKey2)) {
            IDEField iDEFieldModel = this.getDEModel().getDEField(this.getTreeGridModel().getParentDEField(), false);
            DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
            deDataSetCondImpl.setCondType("DEFIELD");
            deDataSetCondImpl.setCondOp("EQ");
            deDataSetCondImpl.setDEFName(iDEFieldModel.getName());
            deDataSetCondImpl.setCondValue(strParentKey2);
            userConditions.add(deDataSetCondImpl);
        }
    }
}

