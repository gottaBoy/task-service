/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.paas.ctrlmodel.toolbar;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.ctrlmodel.toolbar.DynaToolbarItemModelBase;
import net.ibizsys.paas.ctrlmodel.toolbar.IDynaToolbarItemModel;
import net.ibizsys.paas.ctrlmodel.toolbar.IDynaToolbarItemsModel;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;

public class DynaToolbarItemsModel
extends DynaToolbarItemModelBase
implements IDynaToolbarItemsModel {
    protected ArrayList<IDynaToolbarItemModel> toolbarItemModelList = new ArrayList();

    @Override
    public String getItemType() {
        return "ITEMS";
    }

    @Override
    public Iterator<IDynaToolbarItemModel> getItemModels() {
        if (this.toolbarItemModelList.size() == 0) {
            return null;
        }
        return this.toolbarItemModelList.iterator();
    }

    public void registerItemModel(IDynaToolbarItemModel iDynaToolbarItemModel) throws Exception {
        this.toolbarItemModelList.add(iDynaToolbarItemModel);
    }

    @Override
    protected void onLoadJsonObject(ObjectNode jsonObject) throws Exception {
        super.onLoadJsonObject(jsonObject);
        ArrayNode itemsNode = JsonNodeHelper.getArray((ObjectNode)jsonObject, (String)"items");
        if (itemsNode != null) {
            int nSize = itemsNode.size();
            int i = 0;
            while (i < nSize) {
                ObjectNode itemNode = (ObjectNode)itemsNode.get(i);
                this.toolbarItemModelList.add(this.loadToolbarItemModel(itemNode));
                ++i;
            }
        }
    }

    protected IDynaToolbarItemModel loadToolbarItemModel(ObjectNode tbItemModelNode) throws Exception {
        String strItemType = JsonNodeHelper.getString((ObjectNode)tbItemModelNode, (String)"type", null);
        if (StringHelper.isNullOrEmpty((String)strItemType)) {
            throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u5de5\u5177\u680f\u7c7b\u578b"));
        }
        IDynaToolbarItemModel iDynaToolbarItemModel = this.getDynaToolbarModel().createDynaToolbarItemModel(strItemType);
        iDynaToolbarItemModel.init(this.getDynaToolbarModel(), this, tbItemModelNode);
        return iDynaToolbarItemModel;
    }

    @Override
    protected void onFillJsonObject(ObjectNode jo) throws Exception {
        super.onFillJsonObject(jo);
        if (this.toolbarItemModelList.size() > 0) {
            ArrayList<ObjectNode> objectNodeList = new ArrayList<ObjectNode>();
            for (IDynaToolbarItemModel iDynaToolbarItemModel : this.toolbarItemModelList) {
                ObjectNode objectNode = iDynaToolbarItemModel.toJsonObject(null);
                objectNodeList.add(objectNode);
            }
            JsonNodeHelper.put((ObjectNode)jo, (String)"items", objectNodeList);
        }
    }
}

