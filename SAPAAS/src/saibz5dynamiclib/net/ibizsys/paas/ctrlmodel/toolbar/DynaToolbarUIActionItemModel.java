/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.ctrlmodel.toolbar;

import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.ctrlmodel.toolbar.DynaToolbarItemModelBase;
import net.ibizsys.paas.ctrlmodel.toolbar.IDynaToolbarUIActionItemModel;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.view.DefaultDynaFrontUIActionModel;
import net.ibizsys.paas.view.IDynaUIActionModel;
import net.sf.json.JSONObject;

public class DynaToolbarUIActionItemModel
extends DynaToolbarItemModelBase
implements IDynaToolbarUIActionItemModel {
    public static final String MODEL_ATTR_UIACTION = "uiaction";
    private IDynaUIActionModel iUIActionModel = null;
    private JSONObject uiActionParam = null;

    @Override
    protected void onLoadJsonObject(ObjectNode jsonObject) throws Exception {
        ObjectNode uiActionModelObject = JsonNodeHelper.getObject((ObjectNode)jsonObject, (String)MODEL_ATTR_UIACTION);
        if (uiActionModelObject != null) {
            DefaultDynaFrontUIActionModel defaultDynaUIActionModel = new DefaultDynaFrontUIActionModel();
            defaultDynaUIActionModel.init(this.getDynaToolbarModel().getViewController().getDEModel(), uiActionModelObject);
            this.iUIActionModel = defaultDynaUIActionModel;
        }
        super.onLoadJsonObject(jsonObject);
    }

    @Override
    public String getItemType() {
        return "UIACTION";
    }

    @Override
    public IDynaUIActionModel getUIActionModel() {
        return this.iUIActionModel;
    }

    public void setUIActionModel(IDynaUIActionModel iUIActionModel) {
        this.iUIActionModel = iUIActionModel;
    }

    public void setUIActionParam(JSONObject uiActionParam) {
        this.uiActionParam = uiActionParam;
    }

    @Override
    public boolean isEnableToggleMode() {
        return false;
    }

    @Override
    public boolean isHiddenItem() {
        return false;
    }

    @Override
    public int getNoPrivDisplayMode() {
        return 0;
    }

    @Override
    public JSONObject getUIActionParam() {
        return this.uiActionParam;
    }
}

