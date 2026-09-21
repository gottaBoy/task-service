/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.JsonNodeHelper
 */
package net.ibizsys.paas.ctrlmodel.toolbar;

import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.core.DynaModelBase;
import net.ibizsys.paas.ctrlmodel.IDynaToolbarModel;
import net.ibizsys.paas.ctrlmodel.toolbar.IDynaToolbarItemModel;
import net.ibizsys.paas.util.JsonNodeHelper;

public abstract class DynaToolbarItemModelBase
extends DynaModelBase
implements IDynaToolbarItemModel {
    private IDynaToolbarModel iDynaToolbarModel = null;
    private IDynaToolbarItemModel parentModel = null;
    private String strShowMode = null;
    private String strCaption = null;
    private String strCapLanResTag = null;
    private String strTooltip = null;
    private String strTooltipLanResTag = null;

    @Override
    public void init(IDynaToolbarModel iDynaToolbarModel, IDynaToolbarItemModel parentModel, Object modelObject) throws Exception {
        this.setToolbarModel(iDynaToolbarModel);
        this.setParentModel(parentModel);
        this.onInit();
        if (modelObject != null && modelObject instanceof ObjectNode) {
            this.loadJsonObject((ObjectNode)modelObject);
            return;
        }
    }

    @Override
    public IDynaToolbarModel getDynaToolbarModel() {
        return this.iDynaToolbarModel;
    }

    @Override
    public IDynaToolbarItemModel getParentModel() {
        return this.parentModel;
    }

    @Override
    protected void onLoadJsonObject(ObjectNode jsonObject) throws Exception {
        String strName = JsonNodeHelper.getString((ObjectNode)jsonObject, (String)"name", (String)"");
        this.setName(strName);
        super.onLoadJsonObject(jsonObject);
    }

    @Override
    protected void onFillJsonObject(ObjectNode jo) throws Exception {
        super.onFillJsonObject(jo);
        JsonNodeHelper.put((ObjectNode)jo, (String)"type", (Object)this.getItemType());
        JsonNodeHelper.put((ObjectNode)jo, (String)"name", (Object)this.getName());
        if (this.getModelJsonObject() != null) {
            JsonNodeHelper.copy((ObjectNode)jo, (ObjectNode)this.getModelJsonObject(), (boolean)true, (String[])new String[]{"items"});
        }
    }

    public void setToolbarModel(IDynaToolbarModel iDynaToolbarModel) {
        this.iDynaToolbarModel = iDynaToolbarModel;
    }

    public void setParentModel(IDynaToolbarItemModel parentModel) {
        this.parentModel = parentModel;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    public void setShowMode(String strShowMode) {
        this.strShowMode = strShowMode;
    }

    public String getShowMode() {
        return this.strShowMode;
    }

    public String getCaption() {
        return this.strCaption;
    }

    public void setCaption(String strCaption) {
        this.strCaption = strCaption;
    }

    public String getCapLanResTag() {
        return this.strCapLanResTag;
    }

    public void setCapLanResTag(String strCapLanResTag) {
        this.strCapLanResTag = strCapLanResTag;
    }

    public String getTooltip() {
        return this.strTooltip;
    }

    public void setTooltip(String strTooltip) {
        this.strTooltip = strTooltip;
    }

    public String getTooltipLanResTag() {
        return this.strTooltipLanResTag;
    }

    public void setTooltipLanResTag(String strTooltipLanResTag) {
        this.strTooltipLanResTag = strTooltipLanResTag;
    }
}

