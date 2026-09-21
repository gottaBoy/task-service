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
import java.math.BigDecimal;
import java.sql.Timestamp;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSDEChartAxes
extends PSModelBase {
    public static final String FIELD_AXESDATA = "axesdata";
    public static final String FIELD_AXESDATA2 = "axesdata2";
    public static final String FIELD_AXESMAXVALUE = "axesmaxvalue";
    public static final String FIELD_AXESMINVALUE = "axesminvalue";
    public static final String FIELD_AXESPOS = "axespos";
    public static final String FIELD_AXESTYPE = "axestype";
    public static final String FIELD_CAPPSLANRESID = "cappslanresid";
    public static final String FIELD_CAPPSLANRESNAME = "cappslanresname";
    public static final String FIELD_CAPTION = "caption";
    public static final String FIELD_COORDINATESYSTEMID = "coordinatesystemid";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DATASHOWMODE = "datashowmode";
    public static final String FIELD_DYNACLASS = "dynaclass";
    public static final String FIELD_FIELDS = "fields";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PSDECHARTAXESID = "psdechartaxesid";
    public static final String FIELD_PSDECHARTAXESNAME = "psdechartaxesname";
    public static final String FIELD_PSDECHARTID = "psdechartid";
    public static final String FIELD_PSDECHARTNAME = "psdechartname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    public static final String FIELD_PSSYSPFPLUGINID = "pssyspfpluginid";
    public static final String FIELD_PSSYSPFPLUGINNAME = "pssyspfpluginname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERPARAMS = "userparams";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";

    @JsonIgnore
    public String getAxesData() {
        Object objValue = this.get(FIELD_AXESDATA);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="axesdata")
    public void setAxesData(String axesData) {
        this.set(FIELD_AXESDATA, axesData);
    }

    @JsonIgnore
    public boolean isAxesDataDirty() {
        return this.contains(FIELD_AXESDATA);
    }

    @JsonIgnore
    public String getAxesData2() {
        Object objValue = this.get(FIELD_AXESDATA2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="axesdata2")
    public void setAxesData2(String axesData2) {
        this.set(FIELD_AXESDATA2, axesData2);
    }

    @JsonIgnore
    public boolean isAxesData2Dirty() {
        return this.contains(FIELD_AXESDATA2);
    }

    @JsonIgnore
    public BigDecimal getAxesMaxValue() {
        Object objValue = this.get(FIELD_AXESMAXVALUE);
        if (objValue == null) {
            return null;
        }
        return (BigDecimal)objValue;
    }

    @JsonProperty(value="axesmaxvalue")
    public void setAxesMaxValue(BigDecimal axesMaxValue) {
        this.set(FIELD_AXESMAXVALUE, axesMaxValue);
    }

    @JsonIgnore
    public boolean isAxesMaxValueDirty() {
        return this.contains(FIELD_AXESMAXVALUE);
    }

    @JsonIgnore
    public BigDecimal getAxesMinValue() {
        Object objValue = this.get(FIELD_AXESMINVALUE);
        if (objValue == null) {
            return null;
        }
        return (BigDecimal)objValue;
    }

    @JsonProperty(value="axesminvalue")
    public void setAxesMinValue(BigDecimal axesMinValue) {
        this.set(FIELD_AXESMINVALUE, axesMinValue);
    }

    @JsonIgnore
    public boolean isAxesMinValueDirty() {
        return this.contains(FIELD_AXESMINVALUE);
    }

    @JsonIgnore
    public String getAxesPos() {
        Object objValue = this.get(FIELD_AXESPOS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="axespos")
    public void setAxesPos(String axesPos) {
        this.set(FIELD_AXESPOS, axesPos);
    }

    @JsonIgnore
    public boolean isAxesPosDirty() {
        return this.contains(FIELD_AXESPOS);
    }

    @JsonIgnore
    public String getAxesType() {
        Object objValue = this.get(FIELD_AXESTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="axestype")
    public void setAxesType(String axesType) {
        this.set(FIELD_AXESTYPE, axesType);
    }

    @JsonIgnore
    public boolean isAxesTypeDirty() {
        return this.contains(FIELD_AXESTYPE);
    }

    @JsonIgnore
    public String getCapPSLanResId() {
        Object objValue = this.get(FIELD_CAPPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cappslanresid")
    public void setCapPSLanResId(String capPSLanResId) {
        this.set(FIELD_CAPPSLANRESID, capPSLanResId);
    }

    @JsonIgnore
    public boolean isCapPSLanResIdDirty() {
        return this.contains(FIELD_CAPPSLANRESID);
    }

    @JsonIgnore
    public String getCapPSLanResName() {
        Object objValue = this.get(FIELD_CAPPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cappslanresname")
    public void setCapPSLanResName(String capPSLanResName) {
        this.set(FIELD_CAPPSLANRESNAME, capPSLanResName);
    }

    @JsonIgnore
    public boolean isCapPSLanResNameDirty() {
        return this.contains(FIELD_CAPPSLANRESNAME);
    }

    @JsonIgnore
    public String getCaption() {
        Object objValue = this.get(FIELD_CAPTION);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="caption")
    public void setCaption(String caption) {
        this.set(FIELD_CAPTION, caption);
    }

    @JsonIgnore
    public boolean isCaptionDirty() {
        return this.contains(FIELD_CAPTION);
    }

    @JsonIgnore
    public Integer getCoordinateSystemId() {
        Object objValue = this.get(FIELD_COORDINATESYSTEMID);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="coordinatesystemid")
    public void setCoordinateSystemId(Integer coordinateSystemId) {
        this.set(FIELD_COORDINATESYSTEMID, coordinateSystemId);
    }

    @JsonIgnore
    public boolean isCoordinateSystemIdDirty() {
        return this.contains(FIELD_COORDINATESYSTEMID);
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
    public Integer getDataShowMode() {
        Object objValue = this.get(FIELD_DATASHOWMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="datashowmode")
    public void setDataShowMode(Integer dataShowMode) {
        this.set(FIELD_DATASHOWMODE, dataShowMode);
    }

    @JsonIgnore
    public boolean isDataShowModeDirty() {
        return this.contains(FIELD_DATASHOWMODE);
    }

    @JsonIgnore
    public String getDynaClass() {
        Object objValue = this.get(FIELD_DYNACLASS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dynaclass")
    public void setDynaClass(String dynaClass) {
        this.set(FIELD_DYNACLASS, dynaClass);
    }

    @JsonIgnore
    public boolean isDynaClassDirty() {
        return this.contains(FIELD_DYNACLASS);
    }

    @JsonIgnore
    public String getFields() {
        Object objValue = this.get(FIELD_FIELDS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="fields")
    public void setFields(String fields) {
        this.set(FIELD_FIELDS, fields);
    }

    @JsonIgnore
    public boolean isFieldsDirty() {
        return this.contains(FIELD_FIELDS);
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
    public String getPSDEChartAxesId() {
        Object objValue = this.get(FIELD_PSDECHARTAXESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdechartaxesid")
    public void setPSDEChartAxesId(String pSDEChartAxesId) {
        this.set(FIELD_PSDECHARTAXESID, pSDEChartAxesId);
    }

    @JsonIgnore
    public boolean isPSDEChartAxesIdDirty() {
        return this.contains(FIELD_PSDECHARTAXESID);
    }

    @JsonIgnore
    public String getPSDEChartAxesName() {
        Object objValue = this.get(FIELD_PSDECHARTAXESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdechartaxesname")
    public void setPSDEChartAxesName(String pSDEChartAxesName) {
        this.set(FIELD_PSDECHARTAXESNAME, pSDEChartAxesName);
    }

    @JsonIgnore
    public boolean isPSDEChartAxesNameDirty() {
        return this.contains(FIELD_PSDECHARTAXESNAME);
    }

    @JsonIgnore
    public String getPSDEChartId() {
        Object objValue = this.get(FIELD_PSDECHARTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdechartid")
    public void setPSDEChartId(String pSDEChartId) {
        this.set(FIELD_PSDECHARTID, pSDEChartId);
    }

    @JsonIgnore
    public boolean isPSDEChartIdDirty() {
        return this.contains(FIELD_PSDECHARTID);
    }

    @JsonIgnore
    public String getPSDEChartName() {
        Object objValue = this.get(FIELD_PSDECHARTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdechartname")
    public void setPSDEChartName(String pSDEChartName) {
        this.set(FIELD_PSDECHARTNAME, pSDEChartName);
    }

    @JsonIgnore
    public boolean isPSDEChartNameDirty() {
        return this.contains(FIELD_PSDECHARTNAME);
    }

    @JsonIgnore
    public String getPSDEId() {
        Object objValue = this.get(FIELD_PSDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeid")
    public void setPSDEId(String pSDEId) {
        this.set(FIELD_PSDEID, pSDEId);
    }

    @JsonIgnore
    public boolean isPSDEIdDirty() {
        return this.contains(FIELD_PSDEID);
    }

    @JsonIgnore
    public String getPSSysDynaModelId() {
        Object objValue = this.get(FIELD_PSSYSDYNAMODELID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdynamodelid")
    public void setPSSysDynaModelId(String pSSysDynaModelId) {
        this.set(FIELD_PSSYSDYNAMODELID, pSSysDynaModelId);
    }

    @JsonIgnore
    public boolean isPSSysDynaModelIdDirty() {
        return this.contains(FIELD_PSSYSDYNAMODELID);
    }

    @JsonIgnore
    public String getPSSysDynaModelName() {
        Object objValue = this.get(FIELD_PSSYSDYNAMODELNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdynamodelname")
    public void setPSSysDynaModelName(String pSSysDynaModelName) {
        this.set(FIELD_PSSYSDYNAMODELNAME, pSSysDynaModelName);
    }

    @JsonIgnore
    public boolean isPSSysDynaModelNameDirty() {
        return this.contains(FIELD_PSSYSDYNAMODELNAME);
    }

    @JsonIgnore
    public String getPSSysPFPluginId() {
        Object objValue = this.get(FIELD_PSSYSPFPLUGINID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyspfpluginid")
    public void setPSSysPFPluginId(String pSSysPFPluginId) {
        this.set(FIELD_PSSYSPFPLUGINID, pSSysPFPluginId);
    }

    @JsonIgnore
    public boolean isPSSysPFPluginIdDirty() {
        return this.contains(FIELD_PSSYSPFPLUGINID);
    }

    @JsonIgnore
    public String getPSSysPFPluginName() {
        Object objValue = this.get(FIELD_PSSYSPFPLUGINNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyspfpluginname")
    public void setPSSysPFPluginName(String pSSysPFPluginName) {
        this.set(FIELD_PSSYSPFPLUGINNAME, pSSysPFPluginName);
    }

    @JsonIgnore
    public boolean isPSSysPFPluginNameDirty() {
        return this.contains(FIELD_PSSYSPFPLUGINNAME);
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
    public String getUserCat() {
        Object objValue = this.get(FIELD_USERCAT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="usercat")
    public void setUserCat(String userCat) {
        this.set(FIELD_USERCAT, userCat);
    }

    @JsonIgnore
    public boolean isUserCatDirty() {
        return this.contains(FIELD_USERCAT);
    }

    @JsonIgnore
    public String getUserParams() {
        Object objValue = this.get(FIELD_USERPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="userparams")
    public void setUserParams(String userParams) {
        this.set(FIELD_USERPARAMS, userParams);
    }

    @JsonIgnore
    public boolean isUserParamsDirty() {
        return this.contains(FIELD_USERPARAMS);
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
    public String getUserTag3() {
        Object objValue = this.get(FIELD_USERTAG3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="usertag3")
    public void setUserTag3(String userTag3) {
        this.set(FIELD_USERTAG3, userTag3);
    }

    @JsonIgnore
    public boolean isUserTag3Dirty() {
        return this.contains(FIELD_USERTAG3);
    }

    @JsonIgnore
    public String getUserTag4() {
        Object objValue = this.get(FIELD_USERTAG4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="usertag4")
    public void setUserTag4(String userTag4) {
        this.set(FIELD_USERTAG4, userTag4);
    }

    @JsonIgnore
    public boolean isUserTag4Dirty() {
        return this.contains(FIELD_USERTAG4);
    }

    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDEChartAxesId();
    }

    public void setSrfkey(String strValue) {
        this.setPSDEChartAxesId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSDECHARTAXES";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSDEChartAxes item = (PSDEChartAxes)MAPPER.readValue(new File(strJsonFilePath), PSDEChartAxes.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSDEChartAxes) {
            PSDEChartAxes pSDEChartAxes = (PSDEChartAxes)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSDEChartAxes) {
            PSDEChartAxes pSDEChartAxes = (PSDEChartAxes)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

