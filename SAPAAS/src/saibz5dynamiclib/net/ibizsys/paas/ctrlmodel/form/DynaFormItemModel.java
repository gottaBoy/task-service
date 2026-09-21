/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.control.form.IForm
 *  net.ibizsys.paas.control.form.IFormItem
 *  net.ibizsys.paas.ctrlmodel.FormItemModel
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.paas.ctrlmodel.form;

import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.control.form.IForm;
import net.ibizsys.paas.control.form.IFormItem;
import net.ibizsys.paas.ctrlmodel.FormItemModel;
import net.ibizsys.paas.ctrlmodel.IDynaFormModel;
import net.ibizsys.paas.ctrlmodel.form.DynaFormDetailModelBase;
import net.ibizsys.paas.ctrlmodel.form.IDynaFormDetailModel;
import net.ibizsys.paas.ctrlmodel.form.IDynaFormItemModel;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;

public class DynaFormItemModel
extends FormItemModel
implements IDynaFormItemModel {
    private IDynaFormModel iDynaFormModel = null;
    private IDynaFormDetailModel parentModel = null;
    private ObjectNode modelJsonObject = null;
    private IDynaFormItemModel sourceDynaFormItemModel = null;
    private boolean bShowCaption = true;
    private int nColXS = -1;
    private int nColSM = -1;
    private int nColMD = -1;
    private int nColLG = -1;
    private int nColXSOffset = -1;
    private int nColSMOffset = -1;
    private int nColMDOffset = -1;
    private int nColLGOffset = -1;
    protected double fContentWidth = -1.0;
    protected double fWidth = -1.0;
    protected double fContentHeight = -1.0;
    protected double fHeight = -1.0;
    private boolean bEditable = true;
    protected String strEditorType = "";
    protected String strEditorStyle = "";
    protected boolean bHidden = false;
    protected String strLabelPos = "LEFT";
    protected double fEditorWidth = -1.0;
    protected double fEditorHeight = -1.0;
    private boolean bEmptyCaption = false;
    private int nLabelWidth = -1;
    private String strPlaceHolder = null;

    @Override
    public void init(IDynaFormModel iDynaFormModel, IDynaFormDetailModel parentModel, Object modelObject) throws Exception {
        this.iDynaFormModel = iDynaFormModel;
        this.parentModel = parentModel;
        this.setForm((IForm)iDynaFormModel);
        if (modelObject != null && modelObject instanceof ObjectNode) {
            this.loadJsonObject((ObjectNode)modelObject);
        }
    }

    @Override
    public String getDetailType() {
        return "FORMITEM";
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
    public void loadJsonObject(ObjectNode jsonObject) throws Exception {
        this.modelJsonObject = jsonObject;
        this.onLoadJsonObject(jsonObject);
    }

    protected void onLoadJsonObject(ObjectNode jsonObject) throws Exception {
        String strEditorStyle;
        String strEditorType;
        IFormItem iFormItem;
        String strName = JsonNodeHelper.getString((ObjectNode)jsonObject, (String)"name", null);
        if (StringHelper.isNullOrEmpty((String)strName)) {
            throw new Exception("\u8868\u5355\u9879\u6a21\u578b\u4e2d\u6ca1\u6709\u6307\u5b9a\u8868\u5355\u9879\u540d\u79f0");
        }
        this.setName(strName);
        if (!StringHelper.isNullOrEmpty((String)this.getName()) && this.getDynaFormModel().getSourceFormModel() != null && (iFormItem = this.getDynaFormModel().getSourceFormModel().getFormItem(this.getName(), true)) != null && iFormItem instanceof IDynaFormItemModel) {
            this.sourceDynaFormItemModel = (IDynaFormItemModel)iFormItem;
        }
        if (!StringHelper.isNullOrEmpty((String)(strEditorType = JsonNodeHelper.getString((ObjectNode)jsonObject, (String)"editortype", null)))) {
            this.setEditorType(strEditorType);
        }
        if (!StringHelper.isNullOrEmpty((String)(strEditorStyle = JsonNodeHelper.getString((ObjectNode)jsonObject, (String)"editorstyle", null)))) {
            this.setEditorStyle(strEditorStyle);
        }
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
        DynaFormDetailModelBase.fillJsonObject(this, jo);
        if (this.getModelJsonObject() != null) {
            JsonNodeHelper.copy((ObjectNode)jo, (ObjectNode)this.getModelJsonObject(), (boolean)true);
        }
        if (jo.has("editortype")) {
            if (StringHelper.isNullOrEmpty((String)jo.get("editortype").asText()) && !StringHelper.isNullOrEmpty((String)this.getEditorType())) {
                JsonNodeHelper.put((ObjectNode)jo, (String)"editortype", (Object)this.getEditorType());
            }
        } else if (!StringHelper.isNullOrEmpty((String)this.getEditorType())) {
            JsonNodeHelper.put((ObjectNode)jo, (String)"editortype", (Object)this.getEditorType());
        }
        if (jo.has("editorstyle")) {
            if (StringHelper.isNullOrEmpty((String)jo.get("editorstyle").asText()) && !StringHelper.isNullOrEmpty((String)this.getEditorStyle())) {
                JsonNodeHelper.put((ObjectNode)jo, (String)"editorstyle", (Object)this.getEditorStyle());
            }
        } else if (!StringHelper.isNullOrEmpty((String)this.getEditorStyle())) {
            JsonNodeHelper.put((ObjectNode)jo, (String)"editorstyle", (Object)this.getEditorStyle());
        }
        if (jo.has("caption")) {
            if (StringHelper.isNullOrEmpty((String)jo.get("caption").asText()) && !StringHelper.isNullOrEmpty((String)this.getCaption())) {
                JsonNodeHelper.put((ObjectNode)jo, (String)"caption", (Object)this.getCaption());
            }
        } else if (!StringHelper.isNullOrEmpty((String)this.getCaption())) {
            JsonNodeHelper.put((ObjectNode)jo, (String)"caption", (Object)this.getCaption());
        }
    }

    protected IDynaFormItemModel getSourceDynaFormItemModel() {
        return this.sourceDynaFormItemModel;
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

    @Override
    public double getEditorWidth() {
        return this.fEditorWidth;
    }

    @Override
    public double getEditorHeight() {
        return this.fEditorHeight;
    }

    @Override
    public boolean isAllowEmpty() {
        if (this.isEditable()) {
            return super.isAllowEmpty();
        }
        return true;
    }

    @Override
    public boolean isEditable() {
        return this.bEditable;
    }

    @Override
    public String getLabelPos() {
        return this.strLabelPos;
    }

    @Override
    public int getLabelWidth() {
        if (this.isShowCaption()) {
            return this.nLabelWidth;
        }
        return 0;
    }

    @Override
    public boolean isHidden() {
        return this.bHidden;
    }

    @Override
    public String getEditorType() {
        if (StringHelper.isNullOrEmpty((String)this.strEditorType) && this.getSourceDynaFormItemModel() != null) {
            return this.getSourceDynaFormItemModel().getEditorType();
        }
        return this.strEditorType;
    }

    @Override
    public String getEditorStyle() {
        if (StringHelper.isNullOrEmpty((String)this.strEditorStyle) && this.getSourceDynaFormItemModel() != null) {
            return this.getSourceDynaFormItemModel().getEditorStyle();
        }
        return this.strEditorStyle;
    }

    @Override
    public String getCaption() {
        if (StringHelper.isNullOrEmpty((String)super.getCaption()) && this.getSourceDynaFormItemModel() != null) {
            return this.getSourceDynaFormItemModel().getCaption();
        }
        return super.getCaption();
    }

    @Override
    public boolean isEmptyCaption() {
        return this.bEmptyCaption;
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

    public void setEditable(boolean bEditable) {
        this.bEditable = bEditable;
    }

    public void setEditorType(String strEditorType) {
        this.strEditorType = strEditorType;
    }

    public void setEditorStyle(String strEditorStyle) {
        this.strEditorStyle = strEditorStyle;
    }

    public void setHidden(boolean bHidden) {
        this.bHidden = bHidden;
    }

    public void setLabelPos(String strLabelPos) {
        this.strLabelPos = strLabelPos;
    }

    public void setEditorWidth(double fEditorWidth) {
        this.fEditorWidth = fEditorWidth;
    }

    public void setEditorHeight(double fEditorHeight) {
        this.fEditorHeight = fEditorHeight;
    }

    public void setEmptyCaption(boolean bEmptyCaption) {
        this.bEmptyCaption = bEmptyCaption;
    }

    public void setLabelWidth(int nLabelWidth) {
        this.nLabelWidth = nLabelWidth;
    }

    public void setPlaceHolder(String strPlaceHolder) {
        this.strPlaceHolder = strPlaceHolder;
    }

    protected ObjectNode getModelJsonObject() {
        return this.modelJsonObject;
    }

    @Override
    public String getPlaceHolder() {
        return this.strPlaceHolder;
    }
}

