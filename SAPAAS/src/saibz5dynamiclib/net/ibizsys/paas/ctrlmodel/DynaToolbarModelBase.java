/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.paas.ctrlmodel;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.ctrlmodel.DynaCtrlModelBase;
import net.ibizsys.paas.ctrlmodel.IDynaToolbarModel;
import net.ibizsys.paas.ctrlmodel.toolbar.DynaToolbarItemsModel;
import net.ibizsys.paas.ctrlmodel.toolbar.DynaToolbarSeparatorModel;
import net.ibizsys.paas.ctrlmodel.toolbar.DynaToolbarUIActionItemModel;
import net.ibizsys.paas.ctrlmodel.toolbar.IDynaToolbarItemModel;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;

public abstract class DynaToolbarModelBase
extends DynaCtrlModelBase
implements IDynaToolbarModel {
    private ArrayList<IDynaToolbarItemModel> dynaToolbarItemModelList = new ArrayList();

    public String getControlType() {
        return "TOOLBAR";
    }

    protected void registerItemModel(IDynaToolbarItemModel iDynaToolbarItemModel) throws Exception {
        this.dynaToolbarItemModelList.add(iDynaToolbarItemModel);
    }

    @Override
    public Iterator<IDynaToolbarItemModel> getItemModels() {
        if (this.dynaToolbarItemModelList.size() == 0) {
            return null;
        }
        return this.dynaToolbarItemModelList.iterator();
    }

    @Override
    protected void onLoadJsonObject(ObjectNode jsonObject) throws Exception {
        this.dynaToolbarItemModelList.clear();
        super.onLoadJsonObject(jsonObject);
        ArrayNode arrayNode = JsonNodeHelper.getArray((ObjectNode)jsonObject, (String)"items");
        if (arrayNode != null) {
            int nSize = arrayNode.size();
            int i = 0;
            while (i < nSize) {
                ObjectNode itemNode = (ObjectNode)arrayNode.get(i);
                this.dynaToolbarItemModelList.add(this.loadToolbarItemModel(itemNode));
                ++i;
            }
        }
    }

    protected IDynaToolbarItemModel loadToolbarItemModel(ObjectNode tbItemModelNode) throws Exception {
        String strItemType = JsonNodeHelper.getString((ObjectNode)tbItemModelNode, (String)"type", null);
        if (StringHelper.isNullOrEmpty((String)strItemType)) {
            throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u5de5\u5177\u680f\u7c7b\u578b"));
        }
        IDynaToolbarItemModel iDynaToolbarItemModel = this.createDynaToolbarItemModel(strItemType);
        iDynaToolbarItemModel.init(this, null, tbItemModelNode);
        return iDynaToolbarItemModel;
    }

    @Override
    public IDynaToolbarItemModel createDynaToolbarItemModel(String strType) throws Exception {
        if (StringHelper.compare((String)strType, (String)"UIACTION", (boolean)true) == 0) {
            return new DynaToolbarUIActionItemModel();
        }
        if (StringHelper.compare((String)strType, (String)"SEPARATOR", (boolean)true) == 0) {
            return new DynaToolbarSeparatorModel();
        }
        if (StringHelper.compare((String)strType, (String)"ITEMS", (boolean)true) == 0) {
            return new DynaToolbarItemsModel();
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u5de5\u5177\u680f\u9879\u7c7b\u578b[%1$s]", (Object)strType));
    }

    @Override
    protected void onFillJsonObject(ObjectNode jo) throws Exception {
        super.onFillJsonObject(jo);
        if (this.dynaToolbarItemModelList.size() > 0) {
            ArrayList<ObjectNode> objectNodeList = new ArrayList<ObjectNode>();
            for (IDynaToolbarItemModel iDynaToolbarItemModel : this.dynaToolbarItemModelList) {
                ObjectNode objectNode = iDynaToolbarItemModel.toJsonObject(null);
                objectNodeList.add(objectNode);
            }
            JsonNodeHelper.put((ObjectNode)jo, (String)"items", objectNodeList);
        }
    }
}

