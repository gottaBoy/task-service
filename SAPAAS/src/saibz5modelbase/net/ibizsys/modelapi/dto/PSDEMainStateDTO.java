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
import java.util.List;
import net.ibizsys.modelapi.dto.PSDEMSActionDTO;
import net.ibizsys.modelapi.dto.PSDEMSOPPrivDTO;
import net.ibizsys.modelapi.dto.PSDEMainStateRSDTO;
import net.ibizsys.modelapi.util.PSModelDTOBase;

public class PSDEMainStateDTO
extends PSModelDTOBase {
    public static final String FIELD_ALLOWMODE = "allowmode";
    public static final String FIELD_CODENAME = "codename";
    public static final String FIELD_COLOR = "color";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DEACTIONDENYMSG = "deactiondenymsg";
    public static final String FIELD_DEACTIONDMPSLANRESID = "deactiondmpslanresid";
    public static final String FIELD_DEACTIONDMPSLANRESNAME = "deactiondmpslanresname";
    public static final String FIELD_DEFAULTMODE = "defaultmode";
    public static final String FIELD_DEOPPRIVDENYMSG = "deopprivdenymsg";
    public static final String FIELD_DEOPPRIVDMPSLANRESID = "deopprivdmpslanresid";
    public static final String FIELD_DEOPPRIVDMPSLANRESNAME = "deopprivdmpslanresname";
    public static final String FIELD_EDITVIEWTYPE = "editviewtype";
    public static final String FIELD_ENABLEVIEWACTIONS = "enableviewactions";
    public static final String FIELD_ENTERPSDEACTIONID = "enterpsdeactionid";
    public static final String FIELD_ENTERPSDEACTIONNAME = "enterpsdeactionname";
    public static final String FIELD_ENTERSTATEMODE = "enterstatemode";
    public static final String FIELD_FIELDALLOWMODE = "fieldallowmode";
    public static final String FIELD_FORMCODENAME = "formcodename";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MOBEDITVIEWTYPE = "mobeditviewtype";
    public static final String FIELD_MOBFORMCODENAME = "mobformcodename";
    public static final String FIELD_MOBPSDEFORMID = "mobpsdeformid";
    public static final String FIELD_MOBPSDEFORMNAME = "mobpsdeformname";
    public static final String FIELD_MOBQUICKFORMCODENAME = "mobquickformcodename";
    public static final String FIELD_MOBQUICKPSDEFORMID = "mobquickpsdeformid";
    public static final String FIELD_MOBQUICKPSDEFORMNAME = "mobquickpsdeformname";
    public static final String FIELD_MOBUTILFORMCODENAME = "mobutilformcodename";
    public static final String FIELD_MOBUTILPSDEFORMID = "mobutilpsdeformid";
    public static final String FIELD_MOBUTILPSDEFORMNAME = "mobutilpsdeformname";
    public static final String FIELD_MSTAG = "mstag";
    public static final String FIELD_MSVALUE = "msvalue";
    public static final String FIELD_MSVALUE2 = "msvalue2";
    public static final String FIELD_MSVALUE2TEXT = "msvalue2text";
    public static final String FIELD_MSVALUE3 = "msvalue3";
    public static final String FIELD_MSVALUE3TEXT = "msvalue3text";
    public static final String FIELD_MSVALUETEXT = "msvaluetext";
    public static final String FIELD_OPPRIVALLOWMODE = "opprivallowmode";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PSDEDQID = "psdedqid";
    public static final String FIELD_PSDEDQNAME = "psdedqname";
    public static final String FIELD_PSDEFORMID = "psdeformid";
    public static final String FIELD_PSDEFORMNAME = "psdeformname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDEMAINSTATEID = "psdemainstateid";
    public static final String FIELD_PSDEMAINSTATENAME = "psdemainstatename";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSSYSCSSID = "pssyscssid";
    public static final String FIELD_PSSYSCSSNAME = "pssyscssname";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    public static final String FIELD_PSSYSIMAGEID = "pssysimageid";
    public static final String FIELD_PSSYSIMAGENAME = "pssysimagename";
    public static final String FIELD_QUICKFORMCODENAME = "quickformcodename";
    public static final String FIELD_QUICKPSDEFORMID = "quickpsdeformid";
    public static final String FIELD_QUICKPSDEFORMNAME = "quickpsdeformname";
    public static final String FIELD_TEXTPSLANRESID = "textpslanresid";
    public static final String FIELD_TEXTPSLANRESNAME = "textpslanresname";
    public static final String FIELD_TIPPSLANRESID = "tippslanresid";
    public static final String FIELD_TIPPSLANRESNAME = "tippslanresname";
    public static final String FIELD_TODOTASK = "todotask";
    public static final String FIELD_TOOLTIPINFO = "tooltipinfo";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_UTILFORMCODENAME = "utilformcodename";
    public static final String FIELD_UTILPSDEFORMID = "utilpsdeformid";
    public static final String FIELD_UTILPSDEFORMNAME = "utilpsdeformname";
    public static final String FIELD_VIEWACTIONS = "viewactions";
    public static final String FIELD_WFSTATEMODE = "wfstatemode";
    private List<PSDEMSOPPrivDTO> psdemsopprivs;
    private List<PSDEMSActionDTO> psdemsactions;
    private List<PSDEMainStateRSDTO> psdemainstaters;

    @JsonIgnore
    public String getAllowMode() {
        Object objValue = this.get(FIELD_ALLOWMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="allowmode")
    public void setAllowMode(String allowMode) {
        this.set(FIELD_ALLOWMODE, allowMode);
    }

    @JsonIgnore
    public boolean isAllowModeDirty() {
        return this.contains(FIELD_ALLOWMODE);
    }

    @JsonIgnore
    public String getCodeName() {
        Object objValue = this.get(FIELD_CODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="codename")
    public void setCodeName(String codeName) {
        this.set(FIELD_CODENAME, codeName);
    }

    @JsonIgnore
    public boolean isCodeNameDirty() {
        return this.contains(FIELD_CODENAME);
    }

    @JsonIgnore
    public String getColor() {
        Object objValue = this.get(FIELD_COLOR);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="color")
    public void setColor(String color) {
        this.set(FIELD_COLOR, color);
    }

    @JsonIgnore
    public boolean isColorDirty() {
        return this.contains(FIELD_COLOR);
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
    public String getDEActionDenyMsg() {
        Object objValue = this.get(FIELD_DEACTIONDENYMSG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="deactiondenymsg")
    public void setDEActionDenyMsg(String dEActionDenyMsg) {
        this.set(FIELD_DEACTIONDENYMSG, dEActionDenyMsg);
    }

    @JsonIgnore
    public boolean isDEActionDenyMsgDirty() {
        return this.contains(FIELD_DEACTIONDENYMSG);
    }

    @JsonIgnore
    public String getDEActionDMPSLanResId() {
        Object objValue = this.get(FIELD_DEACTIONDMPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="deactiondmpslanresid")
    public void setDEActionDMPSLanResId(String dEActionDMPSLanResId) {
        this.set(FIELD_DEACTIONDMPSLANRESID, dEActionDMPSLanResId);
    }

    @JsonIgnore
    public boolean isDEActionDMPSLanResIdDirty() {
        return this.contains(FIELD_DEACTIONDMPSLANRESID);
    }

    @JsonIgnore
    public String getDEActionDMPSLanResName() {
        Object objValue = this.get(FIELD_DEACTIONDMPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="deactiondmpslanresname")
    public void setDEActionDMPSLanResName(String dEActionDMPSLanResName) {
        this.set(FIELD_DEACTIONDMPSLANRESNAME, dEActionDMPSLanResName);
    }

    @JsonIgnore
    public boolean isDEActionDMPSLanResNameDirty() {
        return this.contains(FIELD_DEACTIONDMPSLANRESNAME);
    }

    @JsonIgnore
    public Integer getDefaultMode() {
        Object objValue = this.get(FIELD_DEFAULTMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="defaultmode")
    public void setDefaultMode(Integer defaultMode) {
        this.set(FIELD_DEFAULTMODE, defaultMode);
    }

    @JsonIgnore
    public boolean isDefaultModeDirty() {
        return this.contains(FIELD_DEFAULTMODE);
    }

    @JsonIgnore
    public String getDEOPPrivDenyMsg() {
        Object objValue = this.get(FIELD_DEOPPRIVDENYMSG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="deopprivdenymsg")
    public void setDEOPPrivDenyMsg(String dEOPPrivDenyMsg) {
        this.set(FIELD_DEOPPRIVDENYMSG, dEOPPrivDenyMsg);
    }

    @JsonIgnore
    public boolean isDEOPPrivDenyMsgDirty() {
        return this.contains(FIELD_DEOPPRIVDENYMSG);
    }

    @JsonIgnore
    public String getDEOPPrivDMPSLanResId() {
        Object objValue = this.get(FIELD_DEOPPRIVDMPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="deopprivdmpslanresid")
    public void setDEOPPrivDMPSLanResId(String dEOPPrivDMPSLanResId) {
        this.set(FIELD_DEOPPRIVDMPSLANRESID, dEOPPrivDMPSLanResId);
    }

    @JsonIgnore
    public boolean isDEOPPrivDMPSLanResIdDirty() {
        return this.contains(FIELD_DEOPPRIVDMPSLANRESID);
    }

    @JsonIgnore
    public String getDEOPPrivDMPSLanResName() {
        Object objValue = this.get(FIELD_DEOPPRIVDMPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="deopprivdmpslanresname")
    public void setDEOPPrivDMPSLanResName(String dEOPPrivDMPSLanResName) {
        this.set(FIELD_DEOPPRIVDMPSLANRESNAME, dEOPPrivDMPSLanResName);
    }

    @JsonIgnore
    public boolean isDEOPPrivDMPSLanResNameDirty() {
        return this.contains(FIELD_DEOPPRIVDMPSLANRESNAME);
    }

    @JsonIgnore
    public String getEditViewType() {
        Object objValue = this.get(FIELD_EDITVIEWTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="editviewtype")
    public void setEditViewType(String editViewType) {
        this.set(FIELD_EDITVIEWTYPE, editViewType);
    }

    @JsonIgnore
    public boolean isEditViewTypeDirty() {
        return this.contains(FIELD_EDITVIEWTYPE);
    }

    @JsonIgnore
    public Integer getEnableViewActions() {
        Object objValue = this.get(FIELD_ENABLEVIEWACTIONS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enableviewactions")
    public void setEnableViewActions(Integer enableViewActions) {
        this.set(FIELD_ENABLEVIEWACTIONS, enableViewActions);
    }

    @JsonIgnore
    public boolean isEnableViewActionsDirty() {
        return this.contains(FIELD_ENABLEVIEWACTIONS);
    }

    @JsonIgnore
    public String getEnterPSDEActionId() {
        Object objValue = this.get(FIELD_ENTERPSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="enterpsdeactionid")
    public void setEnterPSDEActionId(String enterPSDEActionId) {
        this.set(FIELD_ENTERPSDEACTIONID, enterPSDEActionId);
    }

    @JsonIgnore
    public boolean isEnterPSDEActionIdDirty() {
        return this.contains(FIELD_ENTERPSDEACTIONID);
    }

    @JsonIgnore
    public String getEnterPSDEActionName() {
        Object objValue = this.get(FIELD_ENTERPSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="enterpsdeactionname")
    public void setEnterPSDEActionName(String enterPSDEActionName) {
        this.set(FIELD_ENTERPSDEACTIONNAME, enterPSDEActionName);
    }

    @JsonIgnore
    public boolean isEnterPSDEActionNameDirty() {
        return this.contains(FIELD_ENTERPSDEACTIONNAME);
    }

    @JsonIgnore
    public String getEnterStateMode() {
        Object objValue = this.get(FIELD_ENTERSTATEMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="enterstatemode")
    public void setEnterStateMode(String enterStateMode) {
        this.set(FIELD_ENTERSTATEMODE, enterStateMode);
    }

    @JsonIgnore
    public boolean isEnterStateModeDirty() {
        return this.contains(FIELD_ENTERSTATEMODE);
    }

    @JsonIgnore
    public String getFieldAllowMode() {
        Object objValue = this.get(FIELD_FIELDALLOWMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="fieldallowmode")
    public void setFieldAllowMode(String fieldAllowMode) {
        this.set(FIELD_FIELDALLOWMODE, fieldAllowMode);
    }

    @JsonIgnore
    public boolean isFieldAllowModeDirty() {
        return this.contains(FIELD_FIELDALLOWMODE);
    }

    @JsonIgnore
    public String getFormCodeName() {
        Object objValue = this.get(FIELD_FORMCODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="formcodename")
    public void setFormCodeName(String formCodeName) {
        this.set(FIELD_FORMCODENAME, formCodeName);
    }

    @JsonIgnore
    public boolean isFormCodeNameDirty() {
        return this.contains(FIELD_FORMCODENAME);
    }

    @JsonIgnore
    public Integer getLockFlag() {
        Object objValue = this.get(FIELD_LOCKFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="lockflag")
    public void setLockFlag(Integer lockFlag) {
        this.set(FIELD_LOCKFLAG, lockFlag);
    }

    @JsonIgnore
    public boolean isLockFlagDirty() {
        return this.contains(FIELD_LOCKFLAG);
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
    public String getMobEditViewType() {
        Object objValue = this.get(FIELD_MOBEDITVIEWTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobeditviewtype")
    public void setMobEditViewType(String mobEditViewType) {
        this.set(FIELD_MOBEDITVIEWTYPE, mobEditViewType);
    }

    @JsonIgnore
    public boolean isMobEditViewTypeDirty() {
        return this.contains(FIELD_MOBEDITVIEWTYPE);
    }

    @JsonIgnore
    public String getMobFormCodeName() {
        Object objValue = this.get(FIELD_MOBFORMCODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobformcodename")
    public void setMobFormCodeName(String mobFormCodeName) {
        this.set(FIELD_MOBFORMCODENAME, mobFormCodeName);
    }

    @JsonIgnore
    public boolean isMobFormCodeNameDirty() {
        return this.contains(FIELD_MOBFORMCODENAME);
    }

    @JsonIgnore
    public String getMobPSDEFormId() {
        Object objValue = this.get(FIELD_MOBPSDEFORMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobpsdeformid")
    public void setMobPSDEFormId(String mobPSDEFormId) {
        this.set(FIELD_MOBPSDEFORMID, mobPSDEFormId);
    }

    @JsonIgnore
    public boolean isMobPSDEFormIdDirty() {
        return this.contains(FIELD_MOBPSDEFORMID);
    }

    @JsonIgnore
    public String getMobPSDEFormName() {
        Object objValue = this.get(FIELD_MOBPSDEFORMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobpsdeformname")
    public void setMobPSDEFormName(String mobPSDEFormName) {
        this.set(FIELD_MOBPSDEFORMNAME, mobPSDEFormName);
    }

    @JsonIgnore
    public boolean isMobPSDEFormNameDirty() {
        return this.contains(FIELD_MOBPSDEFORMNAME);
    }

    @JsonIgnore
    public String getMobQuickFormCodeName() {
        Object objValue = this.get(FIELD_MOBQUICKFORMCODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobquickformcodename")
    public void setMobQuickFormCodeName(String mobQuickFormCodeName) {
        this.set(FIELD_MOBQUICKFORMCODENAME, mobQuickFormCodeName);
    }

    @JsonIgnore
    public boolean isMobQuickFormCodeNameDirty() {
        return this.contains(FIELD_MOBQUICKFORMCODENAME);
    }

    @JsonIgnore
    public String getMobQuickPSDEFormId() {
        Object objValue = this.get(FIELD_MOBQUICKPSDEFORMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobquickpsdeformid")
    public void setMobQuickPSDEFormId(String mobQuickPSDEFormId) {
        this.set(FIELD_MOBQUICKPSDEFORMID, mobQuickPSDEFormId);
    }

    @JsonIgnore
    public boolean isMobQuickPSDEFormIdDirty() {
        return this.contains(FIELD_MOBQUICKPSDEFORMID);
    }

    @JsonIgnore
    public String getMobQuickPSDEFormName() {
        Object objValue = this.get(FIELD_MOBQUICKPSDEFORMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobquickpsdeformname")
    public void setMobQuickPSDEFormName(String mobQuickPSDEFormName) {
        this.set(FIELD_MOBQUICKPSDEFORMNAME, mobQuickPSDEFormName);
    }

    @JsonIgnore
    public boolean isMobQuickPSDEFormNameDirty() {
        return this.contains(FIELD_MOBQUICKPSDEFORMNAME);
    }

    @JsonIgnore
    public String getMobUtilFormCodeName() {
        Object objValue = this.get(FIELD_MOBUTILFORMCODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobutilformcodename")
    public void setMobUtilFormCodeName(String mobUtilFormCodeName) {
        this.set(FIELD_MOBUTILFORMCODENAME, mobUtilFormCodeName);
    }

    @JsonIgnore
    public boolean isMobUtilFormCodeNameDirty() {
        return this.contains(FIELD_MOBUTILFORMCODENAME);
    }

    @JsonIgnore
    public String getMobUtilPSDEFormId() {
        Object objValue = this.get(FIELD_MOBUTILPSDEFORMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobutilpsdeformid")
    public void setMobUtilPSDEFormId(String mobUtilPSDEFormId) {
        this.set(FIELD_MOBUTILPSDEFORMID, mobUtilPSDEFormId);
    }

    @JsonIgnore
    public boolean isMobUtilPSDEFormIdDirty() {
        return this.contains(FIELD_MOBUTILPSDEFORMID);
    }

    @JsonIgnore
    public String getMobUtilPSDEFormName() {
        Object objValue = this.get(FIELD_MOBUTILPSDEFORMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobutilpsdeformname")
    public void setMobUtilPSDEFormName(String mobUtilPSDEFormName) {
        this.set(FIELD_MOBUTILPSDEFORMNAME, mobUtilPSDEFormName);
    }

    @JsonIgnore
    public boolean isMobUtilPSDEFormNameDirty() {
        return this.contains(FIELD_MOBUTILPSDEFORMNAME);
    }

    @JsonIgnore
    public String getMSTag() {
        Object objValue = this.get(FIELD_MSTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mstag")
    public void setMSTag(String mSTag) {
        this.set(FIELD_MSTAG, mSTag);
    }

    @JsonIgnore
    public boolean isMSTagDirty() {
        return this.contains(FIELD_MSTAG);
    }

    @JsonIgnore
    public String getMSValue() {
        Object objValue = this.get(FIELD_MSVALUE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="msvalue")
    public void setMSValue(String mSValue) {
        this.set(FIELD_MSVALUE, mSValue);
    }

    @JsonIgnore
    public boolean isMSValueDirty() {
        return this.contains(FIELD_MSVALUE);
    }

    @JsonIgnore
    public String getMSValue2() {
        Object objValue = this.get(FIELD_MSVALUE2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="msvalue2")
    public void setMSValue2(String mSValue2) {
        this.set(FIELD_MSVALUE2, mSValue2);
    }

    @JsonIgnore
    public boolean isMSValue2Dirty() {
        return this.contains(FIELD_MSVALUE2);
    }

    @JsonIgnore
    public String getMSValue2Text() {
        Object objValue = this.get(FIELD_MSVALUE2TEXT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="msvalue2text")
    public void setMSValue2Text(String mSValue2Text) {
        this.set(FIELD_MSVALUE2TEXT, mSValue2Text);
    }

    @JsonIgnore
    public boolean isMSValue2TextDirty() {
        return this.contains(FIELD_MSVALUE2TEXT);
    }

    @JsonIgnore
    public String getMSValue3() {
        Object objValue = this.get(FIELD_MSVALUE3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="msvalue3")
    public void setMSValue3(String mSValue3) {
        this.set(FIELD_MSVALUE3, mSValue3);
    }

    @JsonIgnore
    public boolean isMSValue3Dirty() {
        return this.contains(FIELD_MSVALUE3);
    }

    @JsonIgnore
    public String getMSValue3Text() {
        Object objValue = this.get(FIELD_MSVALUE3TEXT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="msvalue3text")
    public void setMSValue3Text(String mSValue3Text) {
        this.set(FIELD_MSVALUE3TEXT, mSValue3Text);
    }

    @JsonIgnore
    public boolean isMSValue3TextDirty() {
        return this.contains(FIELD_MSVALUE3TEXT);
    }

    @JsonIgnore
    public String getMSValueText() {
        Object objValue = this.get(FIELD_MSVALUETEXT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="msvaluetext")
    public void setMSValueText(String mSValueText) {
        this.set(FIELD_MSVALUETEXT, mSValueText);
    }

    @JsonIgnore
    public boolean isMSValueTextDirty() {
        return this.contains(FIELD_MSVALUETEXT);
    }

    @JsonIgnore
    public String getOPPrivAllowMode() {
        Object objValue = this.get(FIELD_OPPRIVALLOWMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="opprivallowmode")
    public void setOPPrivAllowMode(String oPPrivAllowMode) {
        this.set(FIELD_OPPRIVALLOWMODE, oPPrivAllowMode);
    }

    @JsonIgnore
    public boolean isOPPrivAllowModeDirty() {
        return this.contains(FIELD_OPPRIVALLOWMODE);
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
    public String getPSDEDQId() {
        Object objValue = this.get(FIELD_PSDEDQID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedqid")
    public void setPSDEDQId(String pSDEDQId) {
        this.set(FIELD_PSDEDQID, pSDEDQId);
    }

    @JsonIgnore
    public boolean isPSDEDQIdDirty() {
        return this.contains(FIELD_PSDEDQID);
    }

    @JsonIgnore
    public String getPSDEDQName() {
        Object objValue = this.get(FIELD_PSDEDQNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedqname")
    public void setPSDEDQName(String pSDEDQName) {
        this.set(FIELD_PSDEDQNAME, pSDEDQName);
    }

    @JsonIgnore
    public boolean isPSDEDQNameDirty() {
        return this.contains(FIELD_PSDEDQNAME);
    }

    @JsonIgnore
    public String getPSDEFormId() {
        Object objValue = this.get(FIELD_PSDEFORMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeformid")
    public void setPSDEFormId(String pSDEFormId) {
        this.set(FIELD_PSDEFORMID, pSDEFormId);
    }

    @JsonIgnore
    public boolean isPSDEFormIdDirty() {
        return this.contains(FIELD_PSDEFORMID);
    }

    @JsonIgnore
    public String getPSDEFormName() {
        Object objValue = this.get(FIELD_PSDEFORMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeformname")
    public void setPSDEFormName(String pSDEFormName) {
        this.set(FIELD_PSDEFORMNAME, pSDEFormName);
    }

    @JsonIgnore
    public boolean isPSDEFormNameDirty() {
        return this.contains(FIELD_PSDEFORMNAME);
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
    public String getPSDEMainStateId() {
        Object objValue = this.get(FIELD_PSDEMAINSTATEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdemainstateid")
    public void setPSDEMainStateId(String pSDEMainStateId) {
        this.set(FIELD_PSDEMAINSTATEID, pSDEMainStateId);
    }

    @JsonIgnore
    public boolean isPSDEMainStateIdDirty() {
        return this.contains(FIELD_PSDEMAINSTATEID);
    }

    @JsonIgnore
    public String getPSDEMainStateName() {
        Object objValue = this.get(FIELD_PSDEMAINSTATENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdemainstatename")
    public void setPSDEMainStateName(String pSDEMainStateName) {
        this.set(FIELD_PSDEMAINSTATENAME, pSDEMainStateName);
    }

    @JsonIgnore
    public boolean isPSDEMainStateNameDirty() {
        return this.contains(FIELD_PSDEMAINSTATENAME);
    }

    @JsonIgnore
    public String getPSDEName() {
        Object objValue = this.get(FIELD_PSDENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdename")
    public void setPSDEName(String pSDEName) {
        this.set(FIELD_PSDENAME, pSDEName);
    }

    @JsonIgnore
    public boolean isPSDENameDirty() {
        return this.contains(FIELD_PSDENAME);
    }

    @JsonIgnore
    public String getPSSysCssId() {
        Object objValue = this.get(FIELD_PSSYSCSSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscssid")
    public void setPSSysCssId(String pSSysCssId) {
        this.set(FIELD_PSSYSCSSID, pSSysCssId);
    }

    @JsonIgnore
    public boolean isPSSysCssIdDirty() {
        return this.contains(FIELD_PSSYSCSSID);
    }

    @JsonIgnore
    public String getPSSysCssName() {
        Object objValue = this.get(FIELD_PSSYSCSSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscssname")
    public void setPSSysCssName(String pSSysCssName) {
        this.set(FIELD_PSSYSCSSNAME, pSSysCssName);
    }

    @JsonIgnore
    public boolean isPSSysCssNameDirty() {
        return this.contains(FIELD_PSSYSCSSNAME);
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
    public String getPSSysImageId() {
        Object objValue = this.get(FIELD_PSSYSIMAGEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysimageid")
    public void setPSSysImageId(String pSSysImageId) {
        this.set(FIELD_PSSYSIMAGEID, pSSysImageId);
    }

    @JsonIgnore
    public boolean isPSSysImageIdDirty() {
        return this.contains(FIELD_PSSYSIMAGEID);
    }

    @JsonIgnore
    public String getPSSysImageName() {
        Object objValue = this.get(FIELD_PSSYSIMAGENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysimagename")
    public void setPSSysImageName(String pSSysImageName) {
        this.set(FIELD_PSSYSIMAGENAME, pSSysImageName);
    }

    @JsonIgnore
    public boolean isPSSysImageNameDirty() {
        return this.contains(FIELD_PSSYSIMAGENAME);
    }

    @JsonIgnore
    public String getQuickFormCodeName() {
        Object objValue = this.get(FIELD_QUICKFORMCODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="quickformcodename")
    public void setQuickFormCodeName(String quickFormCodeName) {
        this.set(FIELD_QUICKFORMCODENAME, quickFormCodeName);
    }

    @JsonIgnore
    public boolean isQuickFormCodeNameDirty() {
        return this.contains(FIELD_QUICKFORMCODENAME);
    }

    @JsonIgnore
    public String getQuickPSDEFormId() {
        Object objValue = this.get(FIELD_QUICKPSDEFORMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="quickpsdeformid")
    public void setQuickPSDEFormId(String quickPSDEFormId) {
        this.set(FIELD_QUICKPSDEFORMID, quickPSDEFormId);
    }

    @JsonIgnore
    public boolean isQuickPSDEFormIdDirty() {
        return this.contains(FIELD_QUICKPSDEFORMID);
    }

    @JsonIgnore
    public String getQuickPSDEFormName() {
        Object objValue = this.get(FIELD_QUICKPSDEFORMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="quickpsdeformname")
    public void setQuickPSDEFormName(String quickPSDEFormName) {
        this.set(FIELD_QUICKPSDEFORMNAME, quickPSDEFormName);
    }

    @JsonIgnore
    public boolean isQuickPSDEFormNameDirty() {
        return this.contains(FIELD_QUICKPSDEFORMNAME);
    }

    @JsonIgnore
    public String getTextPSLanResId() {
        Object objValue = this.get(FIELD_TEXTPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="textpslanresid")
    public void setTextPSLanResId(String textPSLanResId) {
        this.set(FIELD_TEXTPSLANRESID, textPSLanResId);
    }

    @JsonIgnore
    public boolean isTextPSLanResIdDirty() {
        return this.contains(FIELD_TEXTPSLANRESID);
    }

    @JsonIgnore
    public String getTextPSLanResName() {
        Object objValue = this.get(FIELD_TEXTPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="textpslanresname")
    public void setTextPSLanResName(String textPSLanResName) {
        this.set(FIELD_TEXTPSLANRESNAME, textPSLanResName);
    }

    @JsonIgnore
    public boolean isTextPSLanResNameDirty() {
        return this.contains(FIELD_TEXTPSLANRESNAME);
    }

    @JsonIgnore
    public String getTipPSLanResId() {
        Object objValue = this.get(FIELD_TIPPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="tippslanresid")
    public void setTipPSLanResId(String tipPSLanResId) {
        this.set(FIELD_TIPPSLANRESID, tipPSLanResId);
    }

    @JsonIgnore
    public boolean isTipPSLanResIdDirty() {
        return this.contains(FIELD_TIPPSLANRESID);
    }

    @JsonIgnore
    public String getTipPSLanResName() {
        Object objValue = this.get(FIELD_TIPPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="tippslanresname")
    public void setTipPSLanResName(String tipPSLanResName) {
        this.set(FIELD_TIPPSLANRESNAME, tipPSLanResName);
    }

    @JsonIgnore
    public boolean isTipPSLanResNameDirty() {
        return this.contains(FIELD_TIPPSLANRESNAME);
    }

    @JsonIgnore
    public String getToDoTask() {
        Object objValue = this.get(FIELD_TODOTASK);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="todotask")
    public void setToDoTask(String toDoTask) {
        this.set(FIELD_TODOTASK, toDoTask);
    }

    @JsonIgnore
    public boolean isToDoTaskDirty() {
        return this.contains(FIELD_TODOTASK);
    }

    @JsonIgnore
    public String getTooltipInfo() {
        Object objValue = this.get(FIELD_TOOLTIPINFO);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="tooltipinfo")
    public void setTooltipInfo(String tooltipInfo) {
        this.set(FIELD_TOOLTIPINFO, tooltipInfo);
    }

    @JsonIgnore
    public boolean isTooltipInfoDirty() {
        return this.contains(FIELD_TOOLTIPINFO);
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
    public String getUtilFormCodeName() {
        Object objValue = this.get(FIELD_UTILFORMCODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilformcodename")
    public void setUtilFormCodeName(String utilFormCodeName) {
        this.set(FIELD_UTILFORMCODENAME, utilFormCodeName);
    }

    @JsonIgnore
    public boolean isUtilFormCodeNameDirty() {
        return this.contains(FIELD_UTILFORMCODENAME);
    }

    @JsonIgnore
    public String getUtilPSDEFormId() {
        Object objValue = this.get(FIELD_UTILPSDEFORMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsdeformid")
    public void setUtilPSDEFormId(String utilPSDEFormId) {
        this.set(FIELD_UTILPSDEFORMID, utilPSDEFormId);
    }

    @JsonIgnore
    public boolean isUtilPSDEFormIdDirty() {
        return this.contains(FIELD_UTILPSDEFORMID);
    }

    @JsonIgnore
    public String getUtilPSDEFormName() {
        Object objValue = this.get(FIELD_UTILPSDEFORMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsdeformname")
    public void setUtilPSDEFormName(String utilPSDEFormName) {
        this.set(FIELD_UTILPSDEFORMNAME, utilPSDEFormName);
    }

    @JsonIgnore
    public boolean isUtilPSDEFormNameDirty() {
        return this.contains(FIELD_UTILPSDEFORMNAME);
    }

    @JsonIgnore
    public Integer getViewActions() {
        Object objValue = this.get(FIELD_VIEWACTIONS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="viewactions")
    public void setViewActions(Integer viewActions) {
        this.set(FIELD_VIEWACTIONS, viewActions);
    }

    @JsonIgnore
    public boolean isViewActionsDirty() {
        return this.contains(FIELD_VIEWACTIONS);
    }

    @JsonIgnore
    public Integer getWFStateMode() {
        Object objValue = this.get(FIELD_WFSTATEMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="wfstatemode")
    public void setWFStateMode(Integer wFStateMode) {
        this.set(FIELD_WFSTATEMODE, wFStateMode);
    }

    @JsonIgnore
    public boolean isWFStateModeDirty() {
        return this.contains(FIELD_WFSTATEMODE);
    }

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDEMainStateId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSDEMainStateId(strValue);
    }

    @JsonProperty(value="psdemsopprivs")
    public List<PSDEMSOPPrivDTO> getPsdemsopprivs() {
        return this.psdemsopprivs;
    }

    @JsonProperty(value="psdemsopprivs")
    public void setPsdemsopprivs(List<PSDEMSOPPrivDTO> psdemsopprivs) {
        this.psdemsopprivs = psdemsopprivs;
    }

    @JsonProperty(value="psdemsactions")
    public List<PSDEMSActionDTO> getPsdemsactions() {
        return this.psdemsactions;
    }

    @JsonProperty(value="psdemsactions")
    public void setPsdemsactions(List<PSDEMSActionDTO> psdemsactions) {
        this.psdemsactions = psdemsactions;
    }

    @JsonProperty(value="psdemainstaters")
    public List<PSDEMainStateRSDTO> getPsdemainstaters() {
        return this.psdemainstaters;
    }

    @JsonProperty(value="psdemainstaters")
    public void setPsdemainstaters(List<PSDEMainStateRSDTO> psdemainstaters) {
        this.psdemainstaters = psdemainstaters;
    }
}

