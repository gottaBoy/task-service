/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.paas.ctrlmodel.form;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.ctrlmodel.form.DynaFormDetailModelBase;
import net.ibizsys.paas.ctrlmodel.form.IDynaFormDetailModel;
import net.ibizsys.paas.ctrlmodel.form.IDynaFormGroupModelBase;
import net.ibizsys.paas.ctrlmodel.form.IDynaFormItemModel;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;

public abstract class DynaFormGroupModelBase
extends DynaFormDetailModelBase
implements IDynaFormGroupModelBase {
    protected ArrayList<IDynaFormDetailModel> itemModelList = new ArrayList();

    public void addItemModel(IDynaFormDetailModel iDynaFormDetailModel) {
        this.itemModelList.add(iDynaFormDetailModel);
    }

    @Override
    protected void onLoadJsonObject(ObjectNode jsonObject) throws Exception {
        super.onLoadJsonObject(jsonObject);
        ArrayNode arrayNode = JsonNodeHelper.getArray((ObjectNode)jsonObject, (String)"items");
        if (arrayNode != null) {
            int nSize = arrayNode.size();
            int i = 0;
            while (i < nSize) {
                ObjectNode itemNode = (ObjectNode)arrayNode.get(i);
                IDynaFormDetailModel iDynaFormDetailModel = this.loadFormDetailModel(itemNode);
                this.addItemModel(iDynaFormDetailModel);
                ++i;
            }
        }
    }

    @Override
    public Iterator<IDynaFormDetailModel> getItemModels() {
        if (this.itemModelList.size() == 0) {
            return null;
        }
        return this.itemModelList.iterator();
    }

    @Override
    protected void onFillJsonObject(ObjectNode jo) throws Exception {
        super.onFillJsonObject(jo);
        if (this.itemModelList.size() > 0) {
            ArrayList<ObjectNode> objectNodeList = new ArrayList<ObjectNode>();
            for (IDynaFormDetailModel iDynaFormDetailModel : this.itemModelList) {
                ObjectNode objectNode = iDynaFormDetailModel.toJsonObject(null);
                objectNodeList.add(objectNode);
            }
            JsonNodeHelper.put((ObjectNode)jo, (String)"items", objectNodeList);
        }
    }

    protected IDynaFormDetailModel loadFormDetailModel(ObjectNode tbItemModelNode) throws Exception {
        String strItemType = JsonNodeHelper.getString((ObjectNode)tbItemModelNode, (String)"type", null);
        if (StringHelper.isNullOrEmpty((String)strItemType)) {
            throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u8868\u5355\u6210\u5458\u7c7b\u578b"));
        }
        IDynaFormDetailModel iDynaFormDetailModel = this.getDynaFormModel().createDynaFormDetailModel(strItemType);
        iDynaFormDetailModel.init(this.getDynaFormModel(), this.getParentModel(), tbItemModelNode);
        return iDynaFormDetailModel;
    }

    @Override
    public void fillDynaFormItemModels(ArrayList<IDynaFormItemModel> dynaFormItemModelList) throws Exception {
        for (IDynaFormDetailModel iDynaFormDetailModel : this.itemModelList) {
            if (iDynaFormDetailModel instanceof IDynaFormItemModel) {
                dynaFormItemModelList.add((IDynaFormItemModel)iDynaFormDetailModel);
                continue;
            }
            if (!(iDynaFormDetailModel instanceof IDynaFormGroupModelBase)) continue;
            IDynaFormGroupModelBase iDynaFormGroupModelBase = (IDynaFormGroupModelBase)iDynaFormDetailModel;
            iDynaFormGroupModelBase.fillDynaFormItemModels(dynaFormItemModelList);
        }
    }
}

