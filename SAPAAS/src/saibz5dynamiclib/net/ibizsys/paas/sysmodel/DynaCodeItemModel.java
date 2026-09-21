/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.sysmodel.CodeItemModel
 *  net.ibizsys.paas.util.JsonNodeHelper
 */
package net.ibizsys.paas.sysmodel;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.sysmodel.CodeItemModel;
import net.ibizsys.paas.sysmodel.IDynaCodeItemModel;
import net.ibizsys.paas.sysmodel.IDynaCodeListModel;
import net.ibizsys.paas.util.JsonNodeHelper;

public class DynaCodeItemModel
extends CodeItemModel
implements IDynaCodeItemModel {
    private ObjectNode modelJsonObject = null;
    private IDynaCodeListModel iDynaCodeListModel;
    private IDynaCodeItemModel parentModel;

    @Override
    public void init(IDynaCodeListModel iDynaCodeListModel, IDynaCodeItemModel parentModel, Object modelObject) throws Exception {
        this.iDynaCodeListModel = iDynaCodeListModel;
        this.parentModel = parentModel;
        this.iCodeList = this.iDynaCodeListModel;
        this.parentCodeItem = parentModel;
        this.onInit();
        if (modelObject != null && modelObject instanceof ObjectNode) {
            this.loadJsonObject((ObjectNode)modelObject);
            return;
        }
    }

    @Override
    public IDynaCodeListModel getDynaCodeListModel() {
        return this.iDynaCodeListModel;
    }

    @Override
    public IDynaCodeItemModel getParentModel() {
        return this.parentModel;
    }

    @Override
    public void loadJsonObject(ObjectNode jsonObject) throws Exception {
        this.modelJsonObject = jsonObject;
        this.onLoadJsonObject(jsonObject);
    }

    protected void onLoadJsonObject(ObjectNode jsonObject) throws Exception {
        this.setValue(JsonNodeHelper.getString((ObjectNode)jsonObject, (String)"value", (String)this.getValue()));
        this.setText(JsonNodeHelper.getString((ObjectNode)jsonObject, (String)"text", (String)this.getText()));
        this.setRealText(JsonNodeHelper.getString((ObjectNode)jsonObject, (String)"realtext", (String)this.getRealText()));
        this.setParentValue(JsonNodeHelper.getString((ObjectNode)jsonObject, (String)"parentvalue", (String)this.getParentValue()));
        this.setIconCls(JsonNodeHelper.getString((ObjectNode)jsonObject, (String)"iconcls", (String)this.getIconCls()));
        this.setIconClsX(JsonNodeHelper.getString((ObjectNode)jsonObject, (String)"iconclsx", (String)this.getIconClsX()));
        this.setIconPath(JsonNodeHelper.getString((ObjectNode)jsonObject, (String)"iconpath", (String)this.getIconPath()));
        this.setIconPathX(JsonNodeHelper.getString((ObjectNode)jsonObject, (String)"iconpathx", (String)this.getIconPathX()));
        this.setDisableSelect(JsonNodeHelper.getBoolean((ObjectNode)jsonObject, (String)"disableselect", (boolean)this.isDisableSelect()));
        this.setUserData(JsonNodeHelper.getString((ObjectNode)jsonObject, (String)"userdata", (String)this.getUserData()));
        this.setUserData2(JsonNodeHelper.getString((ObjectNode)jsonObject, (String)"userdata2", (String)this.getUserData2()));
        ArrayNode arrayNode = JsonNodeHelper.getArray((ObjectNode)jsonObject, (String)"items");
        if (arrayNode != null) {
            int nSize = arrayNode.size();
            int i = 0;
            while (i < nSize) {
                ObjectNode itemNode = (ObjectNode)arrayNode.get(i);
                DynaCodeItemModel iDynaCodeItemModel = new DynaCodeItemModel();
                iDynaCodeItemModel.init(this.getDynaCodeListModel(), this, itemNode);
                this.registerChildCodeItemModel(iDynaCodeItemModel);
                ++i;
            }
        }
    }

    protected ObjectNode getModelJsonObject() {
        return this.modelJsonObject;
    }
}

