/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.view.UIActionModelBase
 */
package net.ibizsys.paas.view;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.view.IDynaUIActionModel;
import net.ibizsys.paas.view.UIActionModelBase;

public abstract class DynaUIActionModelBase
extends UIActionModelBase
implements IDynaUIActionModel {
    private ObjectNode modelJsonObject = null;
    private IDataEntityModel iDataEntityModel = null;

    @Override
    public void init(IDataEntityModel iDataEntityModel, Object modelObject) throws Exception {
        this.iDataEntityModel = iDataEntityModel;
        if (modelObject != null && modelObject instanceof ObjectNode) {
            this.loadJsonObject((ObjectNode)modelObject);
        }
    }

    public void setId(String strId) {
        this.strId = strId;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    @Override
    public void loadJsonObject(ObjectNode jsonObject) throws Exception {
        this.modelJsonObject = jsonObject;
        this.onLoadJsonObject(jsonObject);
    }

    protected void onLoadJsonObject(ObjectNode jsonObject) throws Exception {
    }

    @Override
    public ObjectNode toJsonObject(ObjectNode jo) throws Exception {
        if (jo == null) {
            jo = JsonNodeHelper.createObjectNode();
        }
        this.onFillJsonObject(jo);
        return jo;
    }

    protected void onFillJsonObject(ObjectNode jo) throws Exception {
        if (this.modelJsonObject != null) {
            ObjectNode objectNode = this.modelJsonObject.deepCopy();
            Iterator names = objectNode.fieldNames();
            while (names.hasNext()) {
                String strName = (String)names.next();
                jo.put(strName, objectNode.get(strName));
            }
        }
    }
}

