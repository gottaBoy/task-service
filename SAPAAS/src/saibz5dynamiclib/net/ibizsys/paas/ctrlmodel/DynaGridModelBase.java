/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.controller.IDynaViewController
 *  net.ibizsys.paas.controller.IDynaViewControllerInst
 *  net.ibizsys.paas.controller.IViewController
 *  net.ibizsys.paas.ctrlmodel.GridModelBase
 *  net.ibizsys.paas.ctrlmodel.ICtrlModel
 *  net.ibizsys.paas.ctrlmodel.IGridModel
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.ctrlmodel;

import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.controller.IDynaViewController;
import net.ibizsys.paas.controller.IDynaViewControllerInst;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.ctrlmodel.DynaCtrlModelBase;
import net.ibizsys.paas.ctrlmodel.GridModelBase;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.ctrlmodel.IDynaGridModel;
import net.ibizsys.paas.ctrlmodel.IGridModel;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class DynaGridModelBase
extends GridModelBase
implements IDynaGridModel {
    private static final Log log = LogFactory.getLog(DynaGridModelBase.class);
    private IDynaViewControllerInst iDynaViewControllerInst = null;
    private ObjectNode modelJsonObject = null;
    private IGridModel sourceGridModel = null;
    private IDynaGridModel sourceDynaGridModel = null;

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
    public IGridModel getSourceGridModel() {
        return this.sourceGridModel;
    }

    public IDynaGridModel getSourceDynaGridModel() {
        return this.sourceDynaGridModel;
    }

    @Override
    public void loadJsonObject(ObjectNode jsonObject) throws Exception {
        this.modelJsonObject = jsonObject;
        this.onLoadJsonObject(jsonObject);
    }

    protected void onLoadJsonObject(ObjectNode jsonObject) throws Exception {
        IDynaViewController iDynaViewController;
        ICtrlModel iCtrlModel;
        String strName = JsonNodeHelper.getString((ObjectNode)jsonObject, (String)"name", null);
        if (StringHelper.isNullOrEmpty((String)strName)) {
            throw new Exception("\u90e8\u4ef6\u6a21\u578b\u4e2d\u6ca1\u6709\u6307\u5b9a\u90e8\u4ef6\u540d\u79f0");
        }
        this.setName(strName);
        if (!StringHelper.isNullOrEmpty((String)this.getName()) && this.getDynaViewControllerInst() != null && (iCtrlModel = (iDynaViewController = this.getDynaViewControllerInst().getDynaViewController()).getCtrlModel(this.getName())) != null && iCtrlModel instanceof IGridModel) {
            this.sourceGridModel = (IGridModel)iCtrlModel;
            if (this.sourceGridModel instanceof IDynaGridModel) {
                this.sourceDynaGridModel = (IDynaGridModel)this.sourceGridModel;
            }
        }
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
}

