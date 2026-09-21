/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.core.IDynaModel
 *  net.ibizsys.paas.core.ModelBase3Impl
 *  net.ibizsys.paas.util.JsonNodeHelper
 */
package net.ibizsys.paas.core;

import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.core.IDynaModel;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.util.JsonNodeHelper;

public abstract class DynaModelBase
extends ModelBase3Impl
implements IDynaModel {
    private ObjectNode modelJsonObject = null;

    public void loadJsonObject(ObjectNode jsonObject) throws Exception {
        this.modelJsonObject = jsonObject;
        this.onLoadJsonObject(jsonObject);
    }

    protected void onLoadJsonObject(ObjectNode jsonObject) throws Exception {
    }

    protected ObjectNode getModelJsonObject() {
        return this.modelJsonObject;
    }

    public ObjectNode toJsonObject(ObjectNode jo) throws Exception {
        if (jo == null) {
            jo = JsonNodeHelper.createObjectNode();
        }
        this.onFillJsonObject(jo);
        return jo;
    }

    protected void onFillJsonObject(ObjectNode jo) throws Exception {
    }
}

