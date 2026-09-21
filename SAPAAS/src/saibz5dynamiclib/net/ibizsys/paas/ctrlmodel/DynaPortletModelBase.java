/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.controller.IDynaViewControllerInst
 *  net.ibizsys.paas.controller.IViewController
 *  net.ibizsys.paas.ctrlmodel.IDynaCtrlModel
 *  net.ibizsys.paas.ctrlmodel.PortletModelBase
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.paas.ctrlmodel;

import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.controller.IDynaViewControllerInst;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.paas.ctrlmodel.IDynaPortletModel;
import net.ibizsys.paas.ctrlmodel.PortletModelBase;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;

public abstract class DynaPortletModelBase
extends PortletModelBase
implements IDynaPortletModel {
    private int nColXS = -1;
    private int nColSM = -1;
    private int nColMD = -1;
    private int nColLG = -1;
    private int nColXSOffset = -1;
    private int nColSMOffset = -1;
    private int nColMDOffset = -1;
    private int nColLGOffset = -1;
    protected double fWidth = 0.0;
    protected double fHeight = 0.0;
    private boolean bShowTitle = true;
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
        DynaPortletModelBase.fillJsonObject(this, jo);
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

    @Override
    public int getColXS() {
        return this.nColXS;
    }

    @Override
    public int getColSM() {
        return this.nColSM;
    }

    @Override
    public int getColMD() {
        return this.nColMD;
    }

    @Override
    public int getColLG() {
        return this.nColLG;
    }

    @Override
    public int getColXSOffset() {
        return this.nColXSOffset;
    }

    @Override
    public int getColSMOffset() {
        return this.nColSMOffset;
    }

    @Override
    public int getColMDOffset() {
        return this.nColMDOffset;
    }

    @Override
    public int getColLGOffset() {
        return this.nColLGOffset;
    }

    @Override
    public boolean isShowTitle() {
        return this.bShowTitle;
    }

    @Override
    public double getWidth() {
        return this.fWidth;
    }

    @Override
    public double getHeight() {
        return this.fHeight;
    }

    public void setShowTitle(boolean bShowTitle) {
        this.bShowTitle = bShowTitle;
    }

    public void setColXS(int nColXS) {
        this.nColXS = nColXS;
    }

    public void setColSM(int nColSM) {
        this.nColSM = nColSM;
    }

    public void setColMD(int nColMD) {
        this.nColMD = nColMD;
    }

    public void setColLG(int nColLG) {
        this.nColLG = nColLG;
    }

    public void setColXSOffset(int nColXSOffset) {
        this.nColXSOffset = nColXSOffset;
    }

    public void setColSMOffset(int nColSMOffset) {
        this.nColSMOffset = nColSMOffset;
    }

    public void setColMDOffset(int nColMDOffset) {
        this.nColMDOffset = nColMDOffset;
    }

    public void setColLGOffset(int nColLGOffset) {
        this.nColLGOffset = nColLGOffset;
    }

    public void setWidth(double fWidth) {
        this.fWidth = fWidth;
    }

    public void setHeight(double fHeight) {
        this.fHeight = fHeight;
    }
}

