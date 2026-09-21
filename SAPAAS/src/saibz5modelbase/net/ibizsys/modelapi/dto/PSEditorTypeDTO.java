/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonFormat
 *  com.fasterxml.jackson.annotation.JsonIgnore
 *  com.fasterxml.jackson.annotation.JsonProperty
 */
package net.ibizsys.modelapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Timestamp;
import net.ibizsys.modelapi.util.PSModelDTOBase;

public class PSEditorTypeDTO
extends PSModelDTOBase {
    public static final String FIELD_AJAXHANDLER = "ajaxhandler";
    public static final String FIELD_CONVERTCITEXT = "convertcitext";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CTRLOBJ = "ctrlobj";
    public static final String FIELD_DOTNETFORMAT = "dotnetformat";
    public static final String FIELD_EDITABLE = "editable";
    public static final String FIELD_EDITORCODE = "editorcode";
    public static final String FIELD_EDITORPARAM = "editorparam";
    public static final String FIELD_FIEDITOR = "fieditor";
    public static final String FIELD_GCEDITOR = "gceditor";
    public static final String FIELD_HEIGHT = "height";
    public static final String FIELD_ICONPATH = "iconpath";
    public static final String FIELD_JAVAFORMAT = "javaformat";
    public static final String FIELD_LINKVIEWSHOWMODE = "linkviewshowmode";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MOBFIEDITOR = "mobfieditor";
    public static final String FIELD_NEEDCODELISTCONFIG = "needcodelistconfig";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PSEDITORTYPEID = "pseditortypeid";
    public static final String FIELD_PSEDITORTYPENAME = "pseditortypename";
    public static final String FIELD_REFVIEWSHOWMODE = "refviewshowmode";
    public static final String FIELD_SBEDITOR = "sbeditor";
    public static final String FIELD_STANDARDEDITOR = "standardeditor";
    public static final String FIELD_STANDARDTYPE = "standardtype";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_VALIDFLAG = "validflag";
    public static final String FIELD_VALUEPROCESSOR = "valueprocessor";
    public static final String FIELD_WIDTH = "width";

    @JsonIgnore
    public String getAjaxHandler() {
        Object objValue = this.get(FIELD_AJAXHANDLER);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ajaxhandler")
    public void setAjaxHandler(String ajaxHandler) {
        this.set(FIELD_AJAXHANDLER, ajaxHandler);
    }

    @JsonIgnore
    public boolean isAjaxHandlerDirty() {
        return this.contains(FIELD_AJAXHANDLER);
    }

    @JsonIgnore
    public Integer getConvertCIText() {
        Object objValue = this.get(FIELD_CONVERTCITEXT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="convertcitext")
    public void setConvertCIText(Integer convertCIText) {
        this.set(FIELD_CONVERTCITEXT, convertCIText);
    }

    @JsonIgnore
    public boolean isConvertCITextDirty() {
        return this.contains(FIELD_CONVERTCITEXT);
    }

    @JsonIgnore
    public Timestamp getCreateDate() {
        Object objValue = this.get(FIELD_CREATEDATE);
        if (objValue == null) {
            return null;
        }
        return (Timestamp)objValue;
    }

    @JsonProperty(value="createdate")
    public void setCreateDate(Timestamp createDate) {
        this.set(FIELD_CREATEDATE, createDate);
    }

    @JsonIgnore
    public boolean isCreateDateDirty() {
        return this.contains(FIELD_CREATEDATE);
    }

    @JsonIgnore
    public String getCreateMan() {
        Object objValue = this.get(FIELD_CREATEMAN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="createman")
    public void setCreateMan(String createMan) {
        this.set(FIELD_CREATEMAN, createMan);
    }

    @JsonIgnore
    public boolean isCreateManDirty() {
        return this.contains(FIELD_CREATEMAN);
    }

    @JsonIgnore
    public String getCtrlObj() {
        Object objValue = this.get(FIELD_CTRLOBJ);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ctrlobj")
    public void setCtrlObj(String ctrlObj) {
        this.set(FIELD_CTRLOBJ, ctrlObj);
    }

    @JsonIgnore
    public boolean isCtrlObjDirty() {
        return this.contains(FIELD_CTRLOBJ);
    }

    @JsonIgnore
    public String getDotNETFormat() {
        Object objValue = this.get(FIELD_DOTNETFORMAT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dotnetformat")
    public void setDotNETFormat(String dotNETFormat) {
        this.set(FIELD_DOTNETFORMAT, dotNETFormat);
    }

    @JsonIgnore
    public boolean isDotNETFormatDirty() {
        return this.contains(FIELD_DOTNETFORMAT);
    }

    @JsonIgnore
    public Integer getEditable() {
        Object objValue = this.get(FIELD_EDITABLE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="editable")
    public void setEditable(Integer editable) {
        this.set(FIELD_EDITABLE, editable);
    }

    @JsonIgnore
    public boolean isEditableDirty() {
        return this.contains(FIELD_EDITABLE);
    }

    @JsonIgnore
    public String getEditorCode() {
        Object objValue = this.get(FIELD_EDITORCODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="editorcode")
    public void setEditorCode(String editorCode) {
        this.set(FIELD_EDITORCODE, editorCode);
    }

    @JsonIgnore
    public boolean isEditorCodeDirty() {
        return this.contains(FIELD_EDITORCODE);
    }

    @JsonIgnore
    public String getEditorParam() {
        Object objValue = this.get(FIELD_EDITORPARAM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="editorparam")
    public void setEditorParam(String editorParam) {
        this.set(FIELD_EDITORPARAM, editorParam);
    }

    @JsonIgnore
    public boolean isEditorParamDirty() {
        return this.contains(FIELD_EDITORPARAM);
    }

    @JsonIgnore
    public Integer getFIEditor() {
        Object objValue = this.get(FIELD_FIEDITOR);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="fieditor")
    public void setFIEditor(Integer fIEditor) {
        this.set(FIELD_FIEDITOR, fIEditor);
    }

    @JsonIgnore
    public boolean isFIEditorDirty() {
        return this.contains(FIELD_FIEDITOR);
    }

    @JsonIgnore
    public Integer getGCEditor() {
        Object objValue = this.get(FIELD_GCEDITOR);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="gceditor")
    public void setGCEditor(Integer gCEditor) {
        this.set(FIELD_GCEDITOR, gCEditor);
    }

    @JsonIgnore
    public boolean isGCEditorDirty() {
        return this.contains(FIELD_GCEDITOR);
    }

    @JsonIgnore
    public Integer getHeight() {
        Object objValue = this.get(FIELD_HEIGHT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="height")
    public void setHeight(Integer height) {
        this.set(FIELD_HEIGHT, height);
    }

    @JsonIgnore
    public boolean isHeightDirty() {
        return this.contains(FIELD_HEIGHT);
    }

    @JsonIgnore
    public String getIconPath() {
        Object objValue = this.get(FIELD_ICONPATH);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="iconpath")
    public void setIconPath(String iconPath) {
        this.set(FIELD_ICONPATH, iconPath);
    }

    @JsonIgnore
    public boolean isIconPathDirty() {
        return this.contains(FIELD_ICONPATH);
    }

    @JsonIgnore
    public String getJavaFormat() {
        Object objValue = this.get(FIELD_JAVAFORMAT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="javaformat")
    public void setJavaFormat(String javaFormat) {
        this.set(FIELD_JAVAFORMAT, javaFormat);
    }

    @JsonIgnore
    public boolean isJavaFormatDirty() {
        return this.contains(FIELD_JAVAFORMAT);
    }

    @JsonIgnore
    public String getLinkViewShowMode() {
        Object objValue = this.get(FIELD_LINKVIEWSHOWMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="linkviewshowmode")
    public void setLinkViewShowMode(String linkViewShowMode) {
        this.set(FIELD_LINKVIEWSHOWMODE, linkViewShowMode);
    }

    @JsonIgnore
    public boolean isLinkViewShowModeDirty() {
        return this.contains(FIELD_LINKVIEWSHOWMODE);
    }

    @JsonIgnore
    public String getMemo() {
        Object objValue = this.get(FIELD_MEMO);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="memo")
    public void setMemo(String memo) {
        this.set(FIELD_MEMO, memo);
    }

    @JsonIgnore
    public boolean isMemoDirty() {
        return this.contains(FIELD_MEMO);
    }

    @JsonIgnore
    public Integer getMobFIEditor() {
        Object objValue = this.get(FIELD_MOBFIEDITOR);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="mobfieditor")
    public void setMobFIEditor(Integer mobFIEditor) {
        this.set(FIELD_MOBFIEDITOR, mobFIEditor);
    }

    @JsonIgnore
    public boolean isMobFIEditorDirty() {
        return this.contains(FIELD_MOBFIEDITOR);
    }

    @JsonIgnore
    public Integer getNeedCodeListConfig() {
        Object objValue = this.get(FIELD_NEEDCODELISTCONFIG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="needcodelistconfig")
    public void setNeedCodeListConfig(Integer needCodeListConfig) {
        this.set(FIELD_NEEDCODELISTCONFIG, needCodeListConfig);
    }

    @JsonIgnore
    public boolean isNeedCodeListConfigDirty() {
        return this.contains(FIELD_NEEDCODELISTCONFIG);
    }

    @JsonIgnore
    public Integer getOrderValue() {
        Object objValue = this.get(FIELD_ORDERVALUE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="ordervalue")
    public void setOrderValue(Integer orderValue) {
        this.set(FIELD_ORDERVALUE, orderValue);
    }

    @JsonIgnore
    public boolean isOrderValueDirty() {
        return this.contains(FIELD_ORDERVALUE);
    }

    @JsonIgnore
    public String getPSEditorTypeId() {
        Object objValue = this.get(FIELD_PSEDITORTYPEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pseditortypeid")
    public void setPSEditorTypeId(String pSEditorTypeId) {
        this.set(FIELD_PSEDITORTYPEID, pSEditorTypeId);
    }

    @JsonIgnore
    public boolean isPSEditorTypeIdDirty() {
        return this.contains(FIELD_PSEDITORTYPEID);
    }

    @JsonIgnore
    public String getPSEditorTypeName() {
        Object objValue = this.get(FIELD_PSEDITORTYPENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pseditortypename")
    public void setPSEditorTypeName(String pSEditorTypeName) {
        this.set(FIELD_PSEDITORTYPENAME, pSEditorTypeName);
    }

    @JsonIgnore
    public boolean isPSEditorTypeNameDirty() {
        return this.contains(FIELD_PSEDITORTYPENAME);
    }

    @JsonIgnore
    public String getRefViewShowMode() {
        Object objValue = this.get(FIELD_REFVIEWSHOWMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refviewshowmode")
    public void setRefViewShowMode(String refViewShowMode) {
        this.set(FIELD_REFVIEWSHOWMODE, refViewShowMode);
    }

    @JsonIgnore
    public boolean isRefViewShowModeDirty() {
        return this.contains(FIELD_REFVIEWSHOWMODE);
    }

    @JsonIgnore
    public Integer getSBEditor() {
        Object objValue = this.get(FIELD_SBEDITOR);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="sbeditor")
    public void setSBEditor(Integer sBEditor) {
        this.set(FIELD_SBEDITOR, sBEditor);
    }

    @JsonIgnore
    public boolean isSBEditorDirty() {
        return this.contains(FIELD_SBEDITOR);
    }

    @JsonIgnore
    public String getStandardEditor() {
        Object objValue = this.get(FIELD_STANDARDEDITOR);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="standardeditor")
    public void setStandardEditor(String standardEditor) {
        this.set(FIELD_STANDARDEDITOR, standardEditor);
    }

    @JsonIgnore
    public boolean isStandardEditorDirty() {
        return this.contains(FIELD_STANDARDEDITOR);
    }

    @JsonIgnore
    public Integer getStandardType() {
        Object objValue = this.get(FIELD_STANDARDTYPE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="standardtype")
    public void setStandardType(Integer standardType) {
        this.set(FIELD_STANDARDTYPE, standardType);
    }

    @JsonIgnore
    public boolean isStandardTypeDirty() {
        return this.contains(FIELD_STANDARDTYPE);
    }

    @JsonIgnore
    public Timestamp getUpdateDate() {
        Object objValue = this.get(FIELD_UPDATEDATE);
        if (objValue == null) {
            return null;
        }
        return (Timestamp)objValue;
    }

    @JsonProperty(value="updatedate")
    public void setUpdateDate(Timestamp updateDate) {
        this.set(FIELD_UPDATEDATE, updateDate);
    }

    @JsonIgnore
    public boolean isUpdateDateDirty() {
        return this.contains(FIELD_UPDATEDATE);
    }

    @JsonIgnore
    public String getUpdateMan() {
        Object objValue = this.get(FIELD_UPDATEMAN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="updateman")
    public void setUpdateMan(String updateMan) {
        this.set(FIELD_UPDATEMAN, updateMan);
    }

    @JsonIgnore
    public boolean isUpdateManDirty() {
        return this.contains(FIELD_UPDATEMAN);
    }

    @JsonIgnore
    public Integer getValidFlag() {
        Object objValue = this.get(FIELD_VALIDFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="validflag")
    public void setValidFlag(Integer validFlag) {
        this.set(FIELD_VALIDFLAG, validFlag);
    }

    @JsonIgnore
    public boolean isValidFlagDirty() {
        return this.contains(FIELD_VALIDFLAG);
    }

    @JsonIgnore
    public String getValueProcessor() {
        Object objValue = this.get(FIELD_VALUEPROCESSOR);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="valueprocessor")
    public void setValueProcessor(String valueProcessor) {
        this.set(FIELD_VALUEPROCESSOR, valueProcessor);
    }

    @JsonIgnore
    public boolean isValueProcessorDirty() {
        return this.contains(FIELD_VALUEPROCESSOR);
    }

    @JsonIgnore
    public Integer getWidth() {
        Object objValue = this.get(FIELD_WIDTH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="width")
    public void setWidth(Integer width) {
        this.set(FIELD_WIDTH, width);
    }

    @JsonIgnore
    public boolean isWidthDirty() {
        return this.contains(FIELD_WIDTH);
    }

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSEditorTypeId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSEditorTypeId(strValue);
    }
}

