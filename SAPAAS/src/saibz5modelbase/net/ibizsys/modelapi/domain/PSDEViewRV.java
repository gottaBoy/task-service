/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonFormat
 *  com.fasterxml.jackson.annotation.JsonIgnore
 *  com.fasterxml.jackson.annotation.JsonProperty
 */
package net.ibizsys.modelapi.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.File;
import java.sql.Timestamp;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSDEViewRV
extends PSModelBase {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DEFVIEWTYPE = "defviewtype";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_HEIGHT = "height";
    public static final String FIELD_MAJORPSDEVIEWID = "majorpsdeviewid";
    public static final String FIELD_MAJORPSDEVIEWNAME = "majorpsdeviewname";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MINORPSDEVIEWID = "minorpsdeviewid";
    public static final String FIELD_MINORPSDEVIEWNAME = "minorpsdeviewname";
    public static final String FIELD_OPENMODE = "openmode";
    public static final String FIELD_PSDEVIEWRVID = "psdeviewrvid";
    public static final String FIELD_PSDEVIEWRVNAME = "psdeviewrvname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_REFMODE = "refmode";
    public static final String FIELD_REFMODETEXT = "refmodetext";
    public static final String FIELD_REFPARAM = "refparam";
    public static final String FIELD_REFPARAMDESC = "refparamdesc";
    public static final String FIELD_TITLE = "title";
    public static final String FIELD_TITLEPSLANRESID = "titlepslanresid";
    public static final String FIELD_TITLEPSLANRESNAME = "titlepslanresname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_VIEWPARAMS = "viewparams";
    public static final String FIELD_WIDTH = "width";

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
    public String getDefViewType() {
        Object objValue = this.get(FIELD_DEFVIEWTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="defviewtype")
    public void setDefViewType(String defViewType) {
        this.set(FIELD_DEFVIEWTYPE, defViewType);
    }

    @JsonIgnore
    public boolean isDefViewTypeDirty() {
        return this.contains(FIELD_DEFVIEWTYPE);
    }

    @JsonIgnore
    public Integer getDynaModelFlag() {
        Object objValue = this.get(FIELD_DYNAMODELFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="dynamodelflag")
    public void setDynaModelFlag(Integer dynaModelFlag) {
        this.set(FIELD_DYNAMODELFLAG, dynaModelFlag);
    }

    @JsonIgnore
    public boolean isDynaModelFlagDirty() {
        return this.contains(FIELD_DYNAMODELFLAG);
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
    public String getMajorPSDEViewId() {
        Object objValue = this.get(FIELD_MAJORPSDEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="majorpsdeviewid")
    public void setMajorPSDEViewId(String majorPSDEViewId) {
        this.set(FIELD_MAJORPSDEVIEWID, majorPSDEViewId);
    }

    @JsonIgnore
    public boolean isMajorPSDEViewIdDirty() {
        return this.contains(FIELD_MAJORPSDEVIEWID);
    }

    @JsonIgnore
    public String getMajorPSDEViewName() {
        Object objValue = this.get(FIELD_MAJORPSDEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="majorpsdeviewname")
    public void setMajorPSDEViewName(String majorPSDEViewName) {
        this.set(FIELD_MAJORPSDEVIEWNAME, majorPSDEViewName);
    }

    @JsonIgnore
    public boolean isMajorPSDEViewNameDirty() {
        return this.contains(FIELD_MAJORPSDEVIEWNAME);
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
    public String getMinorPSDEViewId() {
        Object objValue = this.get(FIELD_MINORPSDEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="minorpsdeviewid")
    public void setMinorPSDEViewId(String minorPSDEViewId) {
        this.set(FIELD_MINORPSDEVIEWID, minorPSDEViewId);
    }

    @JsonIgnore
    public boolean isMinorPSDEViewIdDirty() {
        return this.contains(FIELD_MINORPSDEVIEWID);
    }

    @JsonIgnore
    public String getMinorPSDEViewName() {
        Object objValue = this.get(FIELD_MINORPSDEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="minorpsdeviewname")
    public void setMinorPSDEViewName(String minorPSDEViewName) {
        this.set(FIELD_MINORPSDEVIEWNAME, minorPSDEViewName);
    }

    @JsonIgnore
    public boolean isMinorPSDEViewNameDirty() {
        return this.contains(FIELD_MINORPSDEVIEWNAME);
    }

    @JsonIgnore
    public String getOpenMode() {
        Object objValue = this.get(FIELD_OPENMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="openmode")
    public void setOpenMode(String openMode) {
        this.set(FIELD_OPENMODE, openMode);
    }

    @JsonIgnore
    public boolean isOpenModeDirty() {
        return this.contains(FIELD_OPENMODE);
    }

    @JsonIgnore
    public String getPSDEViewRVId() {
        Object objValue = this.get(FIELD_PSDEVIEWRVID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeviewrvid")
    public void setPSDEViewRVId(String pSDEViewRVId) {
        this.set(FIELD_PSDEVIEWRVID, pSDEViewRVId);
    }

    @JsonIgnore
    public boolean isPSDEViewRVIdDirty() {
        return this.contains(FIELD_PSDEVIEWRVID);
    }

    @JsonIgnore
    public String getPSDEViewRVName() {
        Object objValue = this.get(FIELD_PSDEVIEWRVNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeviewrvname")
    public void setPSDEViewRVName(String pSDEViewRVName) {
        this.set(FIELD_PSDEVIEWRVNAME, pSDEViewRVName);
    }

    @JsonIgnore
    public boolean isPSDEViewRVNameDirty() {
        return this.contains(FIELD_PSDEVIEWRVNAME);
    }

    @JsonIgnore
    public String getPSSystemId() {
        Object objValue = this.get(FIELD_PSSYSTEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystemid")
    public void setPSSystemId(String pSSystemId) {
        this.set(FIELD_PSSYSTEMID, pSSystemId);
    }

    @JsonIgnore
    public boolean isPSSystemIdDirty() {
        return this.contains(FIELD_PSSYSTEMID);
    }

    @JsonIgnore
    public String getRefMode() {
        Object objValue = this.get(FIELD_REFMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refmode")
    public void setRefMode(String refMode) {
        this.set(FIELD_REFMODE, refMode);
    }

    @JsonIgnore
    public boolean isRefModeDirty() {
        return this.contains(FIELD_REFMODE);
    }

    @JsonIgnore
    public String getRefModeText() {
        Object objValue = this.get(FIELD_REFMODETEXT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refmodetext")
    public void setRefModeText(String refModeText) {
        this.set(FIELD_REFMODETEXT, refModeText);
    }

    @JsonIgnore
    public boolean isRefModeTextDirty() {
        return this.contains(FIELD_REFMODETEXT);
    }

    @JsonIgnore
    public String getRefParam() {
        Object objValue = this.get(FIELD_REFPARAM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refparam")
    public void setRefParam(String refParam) {
        this.set(FIELD_REFPARAM, refParam);
    }

    @JsonIgnore
    public boolean isRefParamDirty() {
        return this.contains(FIELD_REFPARAM);
    }

    @JsonIgnore
    public String getRefParamDesc() {
        Object objValue = this.get(FIELD_REFPARAMDESC);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refparamdesc")
    public void setRefParamDesc(String refParamDesc) {
        this.set(FIELD_REFPARAMDESC, refParamDesc);
    }

    @JsonIgnore
    public boolean isRefParamDescDirty() {
        return this.contains(FIELD_REFPARAMDESC);
    }

    @JsonIgnore
    public String getTitle() {
        Object objValue = this.get(FIELD_TITLE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="title")
    public void setTitle(String title) {
        this.set(FIELD_TITLE, title);
    }

    @JsonIgnore
    public boolean isTitleDirty() {
        return this.contains(FIELD_TITLE);
    }

    @JsonIgnore
    public String getTitlePSLanResId() {
        Object objValue = this.get(FIELD_TITLEPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="titlepslanresid")
    public void setTitlePSLanResId(String titlePSLanResId) {
        this.set(FIELD_TITLEPSLANRESID, titlePSLanResId);
    }

    @JsonIgnore
    public boolean isTitlePSLanResIdDirty() {
        return this.contains(FIELD_TITLEPSLANRESID);
    }

    @JsonIgnore
    public String getTitlePSLanResName() {
        Object objValue = this.get(FIELD_TITLEPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="titlepslanresname")
    public void setTitlePSLanResName(String titlePSLanResName) {
        this.set(FIELD_TITLEPSLANRESNAME, titlePSLanResName);
    }

    @JsonIgnore
    public boolean isTitlePSLanResNameDirty() {
        return this.contains(FIELD_TITLEPSLANRESNAME);
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
    public String getUserTag() {
        Object objValue = this.get(FIELD_USERTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="usertag")
    public void setUserTag(String userTag) {
        this.set(FIELD_USERTAG, userTag);
    }

    @JsonIgnore
    public boolean isUserTagDirty() {
        return this.contains(FIELD_USERTAG);
    }

    @JsonIgnore
    public String getUserTag2() {
        Object objValue = this.get(FIELD_USERTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="usertag2")
    public void setUserTag2(String userTag2) {
        this.set(FIELD_USERTAG2, userTag2);
    }

    @JsonIgnore
    public boolean isUserTag2Dirty() {
        return this.contains(FIELD_USERTAG2);
    }

    @JsonIgnore
    public String getViewParams() {
        Object objValue = this.get(FIELD_VIEWPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="viewparams")
    public void setViewParams(String viewParams) {
        this.set(FIELD_VIEWPARAMS, viewParams);
    }

    @JsonIgnore
    public boolean isViewParamsDirty() {
        return this.contains(FIELD_VIEWPARAMS);
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

    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDEViewRVId();
    }

    public void setSrfkey(String strValue) {
        this.setPSDEViewRVId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSDEVIEWRV";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSDEViewRV item = (PSDEViewRV)MAPPER.readValue(new File(strJsonFilePath), PSDEViewRV.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSDEViewRV) {
            PSDEViewRV pSDEViewRV = (PSDEViewRV)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSDEViewRV) {
            PSDEViewRV pSDEViewRV = (PSDEViewRV)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

