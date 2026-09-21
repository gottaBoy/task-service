/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.form.IPSDEEditForm
 *  net.ibizsys.paas.controller.IViewController
 *  net.ibizsys.paas.ctrlmodel.EditFormModelBase
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.ssdyna.ctrlmodel;

import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.form.IPSDEEditForm;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.ssdyna.ctrlmodel.DynaCtrlModelBase;
import net.ibizsys.ssdyna.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.ssdyna.view.IDynaViewModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class EditFormModelBase
extends net.ibizsys.paas.ctrlmodel.EditFormModelBase
implements IDynaCtrlModel {
    private static final Log log = LogFactory.getLog(EditFormModelBase.class);
    private IDynaViewModel iDynaViewModel = null;
    private IPSDEEditForm iPSDEEditForm = null;

    public void init(IViewController iViewController) throws Exception {
        if (iViewController instanceof IDynaViewModel) {
            this.iDynaViewModel = (IDynaViewModel)iViewController;
            IPSControl iPSControl = null;
            if (this.iDynaViewModel.getPSAppView().hasPSControl(this.getName()) && !((iPSControl = this.iDynaViewModel.getPSAppView().getPSControl(this.getName())) instanceof IPSDEEditForm)) {
                iPSControl = null;
            }
            if (this.iPSDEEditForm == null) {
                log.error((Object)StringHelper.format((String)"\u65e0\u6cd5\u4ece\u89c6\u56fe[%1$s][%2$s]\u83b7\u53d6\u8868\u5355\u5bf9\u8c61[%3$s]", (Object)iViewController.getId(), (Object)((IDynaViewModel)iViewController).getName(), (Object)this.getName()));
            }
        }
        super.init(iViewController);
    }

    @Override
    public void init(IDynaViewModel iDynaViewModel, IPSControl iPSControl) throws Exception {
        this.iDynaViewModel = iDynaViewModel;
        this.iPSDEEditForm = (IPSDEEditForm)iPSControl;
        super.init((IViewController)iDynaViewModel);
    }

    @Override
    public IPSControl getPSControl() {
        return this.iPSDEEditForm;
    }

    protected void prepareCtrlModel() throws Exception {
        if (this.getPSControl() != null && this.getPSControl().isDynamicCtrl()) {
            return;
        }
        super.prepareCtrlModel();
    }

    public IPSDEEditForm getPSDEEditForm() {
        return this.iPSDEEditForm;
    }

    @Override
    public ObjectNode toJsonObject(ObjectNode objectNode) throws Exception {
        if (objectNode == null) {
            objectNode = JsonNodeHelper.createObjectNode();
        }
        this.onFillJsonObject(objectNode);
        return objectNode;
    }

    protected void onFillJsonObject(ObjectNode objectNode) throws Exception {
        if (this.getPSControl() != null) {
            DynaCtrlModelBase.toJsonObject(objectNode, this.getPSControl());
        }
    }

    @Override
    public boolean isDynaCtrl() {
        if (this.getPSControl() != null) {
            return this.getPSControl().isDynamicCtrl();
        }
        return false;
    }

    protected boolean isOutputDynaViewContent() {
        return true;
    }
}

