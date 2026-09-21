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
import java.util.ArrayList;
import java.util.List;
import net.ibizsys.modelapi.domain.PSSubSysSADEField;
import net.ibizsys.modelapi.domain.PSSubSysSADetail;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSSubSysSADE
extends PSModelBase {
    public static final String FIELD_BASECLSPARAMS = "baseclsparams";
    public static final String FIELD_CODENAME = "codename";
    public static final String FIELD_CODENAME2 = "codename2";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DEPARAMS = "deparams";
    public static final String FIELD_DETAG = "detag";
    public static final String FIELD_DETAG2 = "detag2";
    public static final String FIELD_LOGICNAME = "logicname";
    public static final String FIELD_MAJORFLAG = "majorflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_METHODCODE = "methodcode";
    public static final String FIELD_PREDEFINEDTYPE = "predefinedtype";
    public static final String FIELD_PSSUBSYSSADEID = "pssubsyssadeid";
    public static final String FIELD_PSSUBSYSSADENAME = "pssubsyssadename";
    public static final String FIELD_PSSUBSYSSERVICEAPIID = "pssubsysserviceapiid";
    public static final String FIELD_PSSUBSYSSERVICEAPINAME = "pssubsysserviceapiname";
    public static final String FIELD_PSSYSSFPLUGINID = "pssyssfpluginid";
    public static final String FIELD_PSSYSSFPLUGINNAME = "pssyssfpluginname";
    public static final String FIELD_SYNCMODELMODE = "syncmodelmode";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";
    private List<PSSubSysSADEField> pssubsyssadefields;
    private List<PSSubSysSADetail> pssubsyssadetails;

    @JsonIgnore
    public String getBaseClsParams() {
        Object objValue = this.get(FIELD_BASECLSPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="baseclsparams")
    public void setBaseClsParams(String baseClsParams) {
        this.set(FIELD_BASECLSPARAMS, baseClsParams);
    }

    @JsonIgnore
    public boolean isBaseClsParamsDirty() {
        return this.contains(FIELD_BASECLSPARAMS);
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
    public String getCodeName2() {
        Object objValue = this.get(FIELD_CODENAME2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="codename2")
    public void setCodeName2(String codeName2) {
        this.set(FIELD_CODENAME2, codeName2);
    }

    @JsonIgnore
    public boolean isCodeName2Dirty() {
        return this.contains(FIELD_CODENAME2);
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
    public String getDEParams() {
        Object objValue = this.get(FIELD_DEPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="deparams")
    public void setDEParams(String dEParams) {
        this.set(FIELD_DEPARAMS, dEParams);
    }

    @JsonIgnore
    public boolean isDEParamsDirty() {
        return this.contains(FIELD_DEPARAMS);
    }

    @JsonIgnore
    public String getDETag() {
        Object objValue = this.get(FIELD_DETAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="detag")
    public void setDETag(String dETag) {
        this.set(FIELD_DETAG, dETag);
    }

    @JsonIgnore
    public boolean isDETagDirty() {
        return this.contains(FIELD_DETAG);
    }

    @JsonIgnore
    public String getDETag2() {
        Object objValue = this.get(FIELD_DETAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="detag2")
    public void setDETag2(String dETag2) {
        this.set(FIELD_DETAG2, dETag2);
    }

    @JsonIgnore
    public boolean isDETag2Dirty() {
        return this.contains(FIELD_DETAG2);
    }

    @JsonIgnore
    public String getLogicName() {
        Object objValue = this.get(FIELD_LOGICNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="logicname")
    public void setLogicName(String logicName) {
        this.set(FIELD_LOGICNAME, logicName);
    }

    @JsonIgnore
    public boolean isLogicNameDirty() {
        return this.contains(FIELD_LOGICNAME);
    }

    @JsonIgnore
    public Integer getMajorFlag() {
        Object objValue = this.get(FIELD_MAJORFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="majorflag")
    public void setMajorFlag(Integer majorFlag) {
        this.set(FIELD_MAJORFLAG, majorFlag);
    }

    @JsonIgnore
    public boolean isMajorFlagDirty() {
        return this.contains(FIELD_MAJORFLAG);
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
    public String getMethodCode() {
        Object objValue = this.get(FIELD_METHODCODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="methodcode")
    public void setMethodCode(String methodCode) {
        this.set(FIELD_METHODCODE, methodCode);
    }

    @JsonIgnore
    public boolean isMethodCodeDirty() {
        return this.contains(FIELD_METHODCODE);
    }

    @JsonIgnore
    public String getPredefinedType() {
        Object objValue = this.get(FIELD_PREDEFINEDTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="predefinedtype")
    public void setPredefinedType(String predefinedType) {
        this.set(FIELD_PREDEFINEDTYPE, predefinedType);
    }

    @JsonIgnore
    public boolean isPredefinedTypeDirty() {
        return this.contains(FIELD_PREDEFINEDTYPE);
    }

    @JsonIgnore
    public String getPSSubSysSADEId() {
        Object objValue = this.get(FIELD_PSSUBSYSSADEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssubsyssadeid")
    public void setPSSubSysSADEId(String pSSubSysSADEId) {
        this.set(FIELD_PSSUBSYSSADEID, pSSubSysSADEId);
    }

    @JsonIgnore
    public boolean isPSSubSysSADEIdDirty() {
        return this.contains(FIELD_PSSUBSYSSADEID);
    }

    @JsonIgnore
    public String getPSSubSysSADEName() {
        Object objValue = this.get(FIELD_PSSUBSYSSADENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssubsyssadename")
    public void setPSSubSysSADEName(String pSSubSysSADEName) {
        this.set(FIELD_PSSUBSYSSADENAME, pSSubSysSADEName);
    }

    @JsonIgnore
    public boolean isPSSubSysSADENameDirty() {
        return this.contains(FIELD_PSSUBSYSSADENAME);
    }

    @JsonIgnore
    public String getPSSubSysServiceAPIId() {
        Object objValue = this.get(FIELD_PSSUBSYSSERVICEAPIID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssubsysserviceapiid")
    public void setPSSubSysServiceAPIId(String pSSubSysServiceAPIId) {
        this.set(FIELD_PSSUBSYSSERVICEAPIID, pSSubSysServiceAPIId);
    }

    @JsonIgnore
    public boolean isPSSubSysServiceAPIIdDirty() {
        return this.contains(FIELD_PSSUBSYSSERVICEAPIID);
    }

    @JsonIgnore
    public String getPSSubSysServiceAPIName() {
        Object objValue = this.get(FIELD_PSSUBSYSSERVICEAPINAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssubsysserviceapiname")
    public void setPSSubSysServiceAPIName(String pSSubSysServiceAPIName) {
        this.set(FIELD_PSSUBSYSSERVICEAPINAME, pSSubSysServiceAPIName);
    }

    @JsonIgnore
    public boolean isPSSubSysServiceAPINameDirty() {
        return this.contains(FIELD_PSSUBSYSSERVICEAPINAME);
    }

    @JsonIgnore
    public String getPSSysSFPluginId() {
        Object objValue = this.get(FIELD_PSSYSSFPLUGINID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssfpluginid")
    public void setPSSysSFPluginId(String pSSysSFPluginId) {
        this.set(FIELD_PSSYSSFPLUGINID, pSSysSFPluginId);
    }

    @JsonIgnore
    public boolean isPSSysSFPluginIdDirty() {
        return this.contains(FIELD_PSSYSSFPLUGINID);
    }

    @JsonIgnore
    public String getPSSysSFPluginName() {
        Object objValue = this.get(FIELD_PSSYSSFPLUGINNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssfpluginname")
    public void setPSSysSFPluginName(String pSSysSFPluginName) {
        this.set(FIELD_PSSYSSFPLUGINNAME, pSSysSFPluginName);
    }

    @JsonIgnore
    public boolean isPSSysSFPluginNameDirty() {
        return this.contains(FIELD_PSSYSSFPLUGINNAME);
    }

    @JsonIgnore
    public String getSyncModelMode() {
        Object objValue = this.get(FIELD_SYNCMODELMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="syncmodelmode")
    public void setSyncModelMode(String syncModelMode) {
        this.set(FIELD_SYNCMODELMODE, syncModelMode);
    }

    @JsonIgnore
    public boolean isSyncModelModeDirty() {
        return this.contains(FIELD_SYNCMODELMODE);
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
    public String getSrfkey() {
        return this.getPSSubSysSADEId();
    }

    public void setSrfkey(String strValue) {
        this.setPSSubSysSADEId(strValue);
    }

    public List<PSSubSysSADEField> getPssubsyssadefields() {
        return this.pssubsyssadefields;
    }

    public void setPssubsyssadefields(List<PSSubSysSADEField> pssubsyssadefields) {
        this.pssubsyssadefields = pssubsyssadefields;
    }

    public List<PSSubSysSADetail> getPssubsyssadetails() {
        return this.pssubsyssadetails;
    }

    public void setPssubsyssadetails(List<PSSubSysSADetail> pssubsyssadetails) {
        this.pssubsyssadetails = pssubsyssadetails;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (strName.equalsIgnoreCase("pssubsyssadefields")) {
            return true;
        }
        if (strName.equalsIgnoreCase("pssubsyssadetails")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("pssubsyssadefields")) {
            this.init();
            return this.pssubsyssadefields;
        }
        if (strName.equalsIgnoreCase("pssubsyssadetails")) {
            this.init();
            return this.pssubsyssadetails;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSSUBSYSSADE";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSSubSysSADE item = (PSSubSysSADE)MAPPER.readValue(new File(strJsonFilePath), PSSubSysSADE.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSSubSysSADE) {
            PSSubSysSADE dst = (PSSubSysSADE)target;
            if (!bSimple) {
                PSModelBase newitem;
                if (this.getPssubsyssadefields() != null) {
                    ArrayList<PSSubSysSADEField> pssubsyssadefields = new ArrayList<PSSubSysSADEField>();
                    for (PSSubSysSADEField pSSubSysSADEField : this.getPssubsyssadefields()) {
                        if (bDeepMode) {
                            newitem = new PSSubSysSADEField();
                            pSSubSysSADEField.to(newitem, false, bDeepMode);
                            pssubsyssadefields.add((PSSubSysSADEField)newitem);
                            continue;
                        }
                        pssubsyssadefields.add(pSSubSysSADEField);
                    }
                    dst.setPssubsyssadefields(pssubsyssadefields);
                }
                if (this.getPssubsyssadetails() != null) {
                    ArrayList<PSSubSysSADetail> pssubsyssadetails = new ArrayList<PSSubSysSADetail>();
                    for (PSSubSysSADetail pSSubSysSADetail : this.getPssubsyssadetails()) {
                        if (bDeepMode) {
                            newitem = new PSSubSysSADetail();
                            pSSubSysSADetail.to(newitem, false, bDeepMode);
                            pssubsyssadetails.add((PSSubSysSADetail)newitem);
                            continue;
                        }
                        pssubsyssadetails.add(pSSubSysSADetail);
                    }
                    dst.setPssubsyssadetails(pssubsyssadetails);
                }
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSSubSysSADE) {
            PSSubSysSADE src = (PSSubSysSADE)source;
            if (!bSimple) {
                PSModelBase newItem;
                if (src.getPssubsyssadefields() != null) {
                    ArrayList<PSSubSysSADEField> pssubsyssadefields = new ArrayList<PSSubSysSADEField>();
                    for (PSSubSysSADEField pSSubSysSADEField : src.getPssubsyssadefields()) {
                        if (bDeepMode) {
                            newItem = new PSSubSysSADEField();
                            ((PSSubSysSADEField)newItem).from(pSSubSysSADEField, false, bDeepMode);
                            pssubsyssadefields.add((PSSubSysSADEField)newItem);
                            continue;
                        }
                        pssubsyssadefields.add(pSSubSysSADEField);
                    }
                    this.setPssubsyssadefields(pssubsyssadefields);
                }
                if (src.getPssubsyssadetails() != null) {
                    ArrayList<PSSubSysSADetail> pssubsyssadetails = new ArrayList<PSSubSysSADetail>();
                    for (PSSubSysSADetail pSSubSysSADetail : src.getPssubsyssadetails()) {
                        if (bDeepMode) {
                            newItem = new PSSubSysSADetail();
                            ((PSSubSysSADetail)newItem).from(pSSubSysSADetail, false, bDeepMode);
                            pssubsyssadetails.add((PSSubSysSADetail)newItem);
                            continue;
                        }
                        pssubsyssadetails.add(pSSubSysSADetail);
                    }
                    this.setPssubsyssadetails(pssubsyssadetails);
                }
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

