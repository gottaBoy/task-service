/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.list.IList;
import net.ibizsys.paas.control.list.IListDataItem;
import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.datamodel.DataItemModel;
import net.ibizsys.paas.demodel.IDataEntityModel;

public class ListDataItemModel
extends DataItemModel
implements IListDataItem {
    protected IList iList = null;
    private String strPrivilegeId = null;

    public void init(IList iList) throws Exception {
        this.setList(iList);
        this.onInit();
    }

    protected IList getList() {
        return this.iList;
    }

    protected void setList(IList iList) {
        this.iList = iList;
    }

    @Override
    public ISystem getCurSystem(IActionContext iActionContext) throws Exception {
        return this.getList().getDataEntity().getSystem();
    }

    @Override
    public String getPrivilegeId() {
        return this.strPrivilegeId;
    }

    public void setPrivilegeId(String strPrivilegeId) {
        this.strPrivilegeId = strPrivilegeId;
    }

    @Override
    protected IDataEntityModel getDEModel() throws Exception {
        return (IDataEntityModel)this.getList().getDataEntity();
    }
}

