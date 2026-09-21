/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.JsonNodeHelper
 */
package net.ibizsys.paas.ctrlmodel.form;

import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.core.DynaModelBase;
import net.ibizsys.paas.ctrlmodel.IDynaFormModel;
import net.ibizsys.paas.ctrlmodel.form.IDynaFormDetailModel;
import net.ibizsys.paas.util.JsonNodeHelper;

public abstract class DynaFormDetailModelBase
extends DynaModelBase
implements IDynaFormDetailModel {
    private IDynaFormModel iDynaFormModel = null;
    private IDynaFormDetailModel parentModel = null;
    private boolean bShowCaption = true;
    private String strCaption = null;
    private int nColXS = -1;
    private int nColSM = -1;
    private int nColMD = -1;
    private int nColLG = -1;
    private int nColXSOffset = -1;
    private int nColSMOffset = -1;
    private int nColMDOffset = -1;
    private int nColLGOffset = -1;
    protected double fContentWidth = 0.0;
    protected double fWidth = 0.0;
    protected double fContentHeight = 0.0;
    protected double fHeight = 0.0;

    @Override
    public void init(IDynaFormModel iDynaFormModel, IDynaFormDetailModel parentModel, Object modelObject) throws Exception {
        this.setFormModel(iDynaFormModel);
        this.setParentModel(parentModel);
        this.onInit();
        if (modelObject != null && modelObject instanceof ObjectNode) {
            this.loadJsonObject((ObjectNode)modelObject);
            return;
        }
    }

    @Override
    public IDynaFormModel getDynaFormModel() {
        return this.iDynaFormModel;
    }

    @Override
    public IDynaFormDetailModel getParentModel() {
        return this.parentModel;
    }

    @Override
    protected void onFillJsonObject(ObjectNode jo) throws Exception {
        super.onFillJsonObject(jo);
        DynaFormDetailModelBase.fillJsonObject(this, jo);
        if (this.getModelJsonObject() != null) {
            JsonNodeHelper.copy((ObjectNode)jo, (ObjectNode)this.getModelJsonObject(), (boolean)true, (String[])new String[]{"pages", "items"});
        }
    }

    public void setFormModel(IDynaFormModel iDynaFormModel) {
        this.iDynaFormModel = iDynaFormModel;
    }

    public void setParentModel(IDynaFormDetailModel parentModel) {
        this.parentModel = parentModel;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    @Override
    protected void onLoadJsonObject(ObjectNode jsonObject) throws Exception {
        String strName = JsonNodeHelper.getString((ObjectNode)jsonObject, (String)"name", null);
        this.setName(strName);
        super.onLoadJsonObject(jsonObject);
    }

    public static void fillJsonObject(IDynaFormDetailModel iDynaFormDetailModel, ObjectNode jo) throws Exception {
        JsonNodeHelper.put((ObjectNode)jo, (String)"type", (Object)iDynaFormDetailModel.getDetailType());
        JsonNodeHelper.put((ObjectNode)jo, (String)"name", (Object)iDynaFormDetailModel.getName());
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
    public String getCaption() {
        return this.strCaption;
    }

    @Override
    public boolean isShowCaption() {
        return this.bShowCaption;
    }

    @Override
    public double getWidth() {
        return this.fWidth;
    }

    @Override
    public double getHeight() {
        return this.fHeight;
    }

    public void setShowCaption(boolean bShowCaption) {
        this.bShowCaption = bShowCaption;
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

    public void setCaption(String strCaption) {
        this.strCaption = strCaption;
    }
}

