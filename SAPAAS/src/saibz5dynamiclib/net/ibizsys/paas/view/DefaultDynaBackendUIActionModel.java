/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.paas.view;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.DynaUIActionModelBase;
import net.ibizsys.paas.view.IDynaBackendUIActionModel;

public class DefaultDynaBackendUIActionModel
extends DynaUIActionModelBase
implements IDynaBackendUIActionModel {
    private boolean bReloadData = false;
    private String strSuccessMsg = null;
    private String strDataAccessAction = null;

    @Override
    public boolean isReloadData() {
        return this.bReloadData;
    }

    public void setReloadData(boolean bReloadData) {
        this.bReloadData = bReloadData;
    }

    @Override
    public String getSuccessMsg() {
        return this.strSuccessMsg;
    }

    public void setSuccessMsg(String strSuccessMsg) {
        this.strSuccessMsg = strSuccessMsg;
    }

    @Override
    public String getDataAccessAction() {
        if (!StringHelper.isNullOrEmpty((String)this.strDataAccessAction)) {
            return this.strDataAccessAction;
        }
        if (StringHelper.compare((String)this.getActionTarget(), (String)"NONE", (boolean)true) == 0) {
            return "";
        }
        return "UPDATE";
    }

    public void setDataAccessAction(String strDataAccessAction) {
        this.strDataAccessAction = strDataAccessAction;
    }

    @Override
    public boolean isCloseEditView() {
        return this.isClosePopupView();
    }

    public void setCloseEditView(boolean bCloseEditView) {
        this.setClosePopupView(bCloseEditView);
    }
}

