/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.controller.IDynaViewControllerInst
 *  net.ibizsys.paas.controller.IViewController
 *  net.ibizsys.paas.ctrlmodel.CtrlModelBase
 *  net.ibizsys.paas.ctrlmodel.IDynaCtrlModel
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.paas.ctrlmodel;

import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.controller.IDynaViewControllerInst;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.IDynaModelJsonExporter;
import net.ibizsys.paas.core.IDynaModelJsonLoader;
import net.ibizsys.paas.ctrlmodel.CtrlModelBase;
import net.ibizsys.paas.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;

public abstract class DynaCtrlModelBase
extends CtrlModelBase
implements IDynaCtrlModel,
IDynaModelJsonExporter,
IDynaModelJsonLoader {
    private IDynaViewControllerInst iDynaViewControllerInst = null;
    private ObjectNode modelJsonObject = null;

    public void init(IDynaViewControllerInst iDynaViewControllerInst, Object modelObject) throws Exception {
        this.setEnableDynaCtrl(true);
        super.init((IViewController)iDynaViewControllerInst);
        if (modelObject != null && modelObject instanceof ObjectNode) {
            this.loadJsonObject((ObjectNode)modelObject);
        }
    }

    protected void onInit() throws Exception {
        if (this.getViewController() instanceof IDynaViewControllerInst) {
            this.iDynaViewControllerInst = (IDynaViewControllerInst)this.getViewController();
        }
        super.onInit();
    }

    public IDynaViewControllerInst getDynaViewControllerInst() {
        return this.iDynaViewControllerInst;
    }

    @Override
    public ObjectNode toJsonObject(ObjectNode jo) throws Exception {
        if (jo == null) {
            jo = JsonNodeHelper.createObjectNode();
        }
        DynaCtrlModelBase.fillJsonObject(this, jo);
        this.onFillJsonObject(jo);
        return jo;
    }

    protected void onFillJsonObject(ObjectNode jo) throws Exception {
    }

    public static void fillJsonObject(IDynaCtrlModel iDynaCtrlModel, ObjectNode jo) throws Exception {
        JsonNodeHelper.put((ObjectNode)jo, (String)"type", (Object)iDynaCtrlModel.getControlType());
        JsonNodeHelper.put((ObjectNode)jo, (String)"name", (Object)iDynaCtrlModel.getName());
    }

    @Override
    public void loadJsonObject(ObjectNode jsonObject) throws Exception {
        this.modelJsonObject = jsonObject;
        this.onLoadJsonObject(jsonObject);
    }

    protected void onLoadJsonObject(ObjectNode jsonObject) throws Exception {
        String strName = JsonNodeHelper.getString((ObjectNode)jsonObject, (String)"name", null);
        if (StringHelper.isNullOrEmpty((String)strName)) {
            throw new Exception("\u90e8\u4ef6\u6a21\u578b\u4e2d\u6ca1\u6709\u6307\u5b9a\u90e8\u4ef6\u540d\u79f0");
        }
        this.setName(strName);
    }

    protected ObjectNode getModelJsonObject() {
        return this.modelJsonObject;
    }
}

