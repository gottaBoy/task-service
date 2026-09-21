/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.view.IPSUIAction
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.view.UIActionModelBase
 */
package net.ibizsys.ssdyna.view;

import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.model.view.IPSUIAction;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.view.UIActionModelBase;
import net.ibizsys.ssdyna.view.IDynaUIActionModel;
import net.ibizsys.ssdyna.view.IDynaViewModel;

public abstract class DynaUIActionModelBase
extends UIActionModelBase
implements IDynaUIActionModel {
    private IDynaViewModel iDynaViewModel = null;
    private IPSUIAction iPSUIAction = null;

    @Override
    public void init(IDynaViewModel iDynaViewModel, IPSUIAction iPSUIAction) throws Exception {
        this.iDynaViewModel = iDynaViewModel;
        this.iPSUIAction = iPSUIAction;
        this.strId = iPSUIAction.getId();
        this.strName = iPSUIAction.getName();
        this.onInit();
    }

    @Override
    public IDynaViewModel getDynaViewModel() {
        return this.iDynaViewModel;
    }

    @Override
    public IPSUIAction getPSUIAction() {
        return this.iPSUIAction;
    }

    public ObjectNode toJsonObject(ObjectNode objectNode) throws Exception {
        if (objectNode == null) {
            objectNode = JsonNodeHelper.createObjectNode();
        }
        this.onFillJsonObject(objectNode);
        return objectNode;
    }

    protected void onFillJsonObject(ObjectNode objectNode) throws Exception {
        if (this.getPSUIAction() != null) {
            this.getPSUIAction().toJsonObject(objectNode);
        }
    }
}

