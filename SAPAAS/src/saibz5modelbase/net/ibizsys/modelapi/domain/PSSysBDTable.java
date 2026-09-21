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
import net.ibizsys.modelapi.domain.PSSysBDColSet;
import net.ibizsys.modelapi.domain.PSSysBDColumn;
import net.ibizsys.modelapi.domain.PSSysBDTableDE;
import net.ibizsys.modelapi.domain.PSSysBDTableDER;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSSysBDTable
extends PSModelBase {
    public static final String FIELD_BDTABLETYPE = "bdtabletype";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_INHERITPSDEID = "inheritpsdeid";
    public static final String FIELD_INHERITPSDENAME = "inheritpsdename";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_LOGICNAME = "logicname";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MINORPSDEID = "minorpsdeid";
    public static final String FIELD_MINORPSDENAME = "minorpsdename";
    public static final String FIELD_MODELVER = "modelver";
    public static final String FIELD_PICKUPDEFNAME = "pickupdefname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSDERID = "psderid";
    public static final String FIELD_PSDERNAME = "psdername";
    public static final String FIELD_PSSYSBDMODULEID = "pssysbdmoduleid";
    public static final String FIELD_PSSYSBDMODULENAME = "pssysbdmodulename";
    public static final String FIELD_PSSYSBDPARTID = "pssysbdpartid";
    public static final String FIELD_PSSYSBDPARTNAME = "pssysbdpartname";
    public static final String FIELD_PSSYSBDSCHEMEID = "pssysbdschemeid";
    public static final String FIELD_PSSYSBDSCHEMENAME = "pssysbdschemename";
    public static final String FIELD_PSSYSBDTABLEID = "pssysbdtableid";
    public static final String FIELD_PSSYSBDTABLENAME = "pssysbdtablename";
    public static final String FIELD_TYPEVALUE = "typevalue";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";
    private List<PSSysBDColSet> pssysbdcolsets;
    private List<PSSysBDTableDER> pssysbdtableders;
    private List<PSSysBDTableDE> pssysbdtabledes;
    private List<PSSysBDColumn> pssysbdcolumns;

    @JsonIgnore
    public Integer getBDTableType() {
        Object objValue = this.get(FIELD_BDTABLETYPE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="bdtabletype")
    public void setBDTableType(Integer bDTableType) {
        this.set(FIELD_BDTABLETYPE, bDTableType);
    }

    @JsonIgnore
    public boolean isBDTableTypeDirty() {
        return this.contains(FIELD_BDTABLETYPE);
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
    public String getInheritPSDEId() {
        Object objValue = this.get(FIELD_INHERITPSDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="inheritpsdeid")
    public void setInheritPSDEId(String inheritPSDEId) {
        this.set(FIELD_INHERITPSDEID, inheritPSDEId);
    }

    @JsonIgnore
    public boolean isInheritPSDEIdDirty() {
        return this.contains(FIELD_INHERITPSDEID);
    }

    @JsonIgnore
    public String getInheritPSDEName() {
        Object objValue = this.get(FIELD_INHERITPSDENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="inheritpsdename")
    public void setInheritPSDEName(String inheritPSDEName) {
        this.set(FIELD_INHERITPSDENAME, inheritPSDEName);
    }

    @JsonIgnore
    public boolean isInheritPSDENameDirty() {
        return this.contains(FIELD_INHERITPSDENAME);
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
    public String getMinorPSDEId() {
        Object objValue = this.get(FIELD_MINORPSDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="minorpsdeid")
    public void setMinorPSDEId(String minorPSDEId) {
        this.set(FIELD_MINORPSDEID, minorPSDEId);
    }

    @JsonIgnore
    public boolean isMinorPSDEIdDirty() {
        return this.contains(FIELD_MINORPSDEID);
    }

    @JsonIgnore
    public String getMinorPSDEName() {
        Object objValue = this.get(FIELD_MINORPSDENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="minorpsdename")
    public void setMinorPSDEName(String minorPSDEName) {
        this.set(FIELD_MINORPSDENAME, minorPSDEName);
    }

    @JsonIgnore
    public boolean isMinorPSDENameDirty() {
        return this.contains(FIELD_MINORPSDENAME);
    }

    @JsonIgnore
    public Integer getModelVer() {
        Object objValue = this.get(FIELD_MODELVER);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="modelver")
    public void setModelVer(Integer modelVer) {
        this.set(FIELD_MODELVER, modelVer);
    }

    @JsonIgnore
    public boolean isModelVerDirty() {
        return this.contains(FIELD_MODELVER);
    }

    @JsonIgnore
    public String getPickupDEFName() {
        Object objValue = this.get(FIELD_PICKUPDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pickupdefname")
    public void setPickupDEFName(String pickupDEFName) {
        this.set(FIELD_PICKUPDEFNAME, pickupDEFName);
    }

    @JsonIgnore
    public boolean isPickupDEFNameDirty() {
        return this.contains(FIELD_PICKUPDEFNAME);
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
    public String getPSDERId() {
        Object objValue = this.get(FIELD_PSDERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psderid")
    public void setPSDERId(String pSDERId) {
        this.set(FIELD_PSDERID, pSDERId);
    }

    @JsonIgnore
    public boolean isPSDERIdDirty() {
        return this.contains(FIELD_PSDERID);
    }

    @JsonIgnore
    public String getPSDERName() {
        Object objValue = this.get(FIELD_PSDERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdername")
    public void setPSDERName(String pSDERName) {
        this.set(FIELD_PSDERNAME, pSDERName);
    }

    @JsonIgnore
    public boolean isPSDERNameDirty() {
        return this.contains(FIELD_PSDERNAME);
    }

    @JsonIgnore
    public String getPSSysBDModuleId() {
        Object objValue = this.get(FIELD_PSSYSBDMODULEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbdmoduleid")
    public void setPSSysBDModuleId(String pSSysBDModuleId) {
        this.set(FIELD_PSSYSBDMODULEID, pSSysBDModuleId);
    }

    @JsonIgnore
    public boolean isPSSysBDModuleIdDirty() {
        return this.contains(FIELD_PSSYSBDMODULEID);
    }

    @JsonIgnore
    public String getPSSysBDModuleName() {
        Object objValue = this.get(FIELD_PSSYSBDMODULENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbdmodulename")
    public void setPSSysBDModuleName(String pSSysBDModuleName) {
        this.set(FIELD_PSSYSBDMODULENAME, pSSysBDModuleName);
    }

    @JsonIgnore
    public boolean isPSSysBDModuleNameDirty() {
        return this.contains(FIELD_PSSYSBDMODULENAME);
    }

    @JsonIgnore
    public String getPSSysBDPartId() {
        Object objValue = this.get(FIELD_PSSYSBDPARTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbdpartid")
    public void setPSSysBDPartId(String pSSysBDPartId) {
        this.set(FIELD_PSSYSBDPARTID, pSSysBDPartId);
    }

    @JsonIgnore
    public boolean isPSSysBDPartIdDirty() {
        return this.contains(FIELD_PSSYSBDPARTID);
    }

    @JsonIgnore
    public String getPSSysBDPartName() {
        Object objValue = this.get(FIELD_PSSYSBDPARTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbdpartname")
    public void setPSSysBDPartName(String pSSysBDPartName) {
        this.set(FIELD_PSSYSBDPARTNAME, pSSysBDPartName);
    }

    @JsonIgnore
    public boolean isPSSysBDPartNameDirty() {
        return this.contains(FIELD_PSSYSBDPARTNAME);
    }

    @JsonIgnore
    public String getPSSysBDSchemeId() {
        Object objValue = this.get(FIELD_PSSYSBDSCHEMEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbdschemeid")
    public void setPSSysBDSchemeId(String pSSysBDSchemeId) {
        this.set(FIELD_PSSYSBDSCHEMEID, pSSysBDSchemeId);
    }

    @JsonIgnore
    public boolean isPSSysBDSchemeIdDirty() {
        return this.contains(FIELD_PSSYSBDSCHEMEID);
    }

    @JsonIgnore
    public String getPSSysBDSchemeName() {
        Object objValue = this.get(FIELD_PSSYSBDSCHEMENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbdschemename")
    public void setPSSysBDSchemeName(String pSSysBDSchemeName) {
        this.set(FIELD_PSSYSBDSCHEMENAME, pSSysBDSchemeName);
    }

    @JsonIgnore
    public boolean isPSSysBDSchemeNameDirty() {
        return this.contains(FIELD_PSSYSBDSCHEMENAME);
    }

    @JsonIgnore
    public String getPSSysBDTableId() {
        Object objValue = this.get(FIELD_PSSYSBDTABLEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbdtableid")
    public void setPSSysBDTableId(String pSSysBDTableId) {
        this.set(FIELD_PSSYSBDTABLEID, pSSysBDTableId);
    }

    @JsonIgnore
    public boolean isPSSysBDTableIdDirty() {
        return this.contains(FIELD_PSSYSBDTABLEID);
    }

    @JsonIgnore
    public String getPSSysBDTableName() {
        Object objValue = this.get(FIELD_PSSYSBDTABLENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbdtablename")
    public void setPSSysBDTableName(String pSSysBDTableName) {
        this.set(FIELD_PSSYSBDTABLENAME, pSSysBDTableName);
    }

    @JsonIgnore
    public boolean isPSSysBDTableNameDirty() {
        return this.contains(FIELD_PSSYSBDTABLENAME);
    }

    @JsonIgnore
    public String getTypeValue() {
        Object objValue = this.get(FIELD_TYPEVALUE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="typevalue")
    public void setTypeValue(String typeValue) {
        this.set(FIELD_TYPEVALUE, typeValue);
    }

    @JsonIgnore
    public boolean isTypeValueDirty() {
        return this.contains(FIELD_TYPEVALUE);
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
        return this.getPSSysBDTableId();
    }

    public void setSrfkey(String strValue) {
        this.setPSSysBDTableId(strValue);
    }

    public List<PSSysBDColSet> getPssysbdcolsets() {
        return this.pssysbdcolsets;
    }

    public void setPssysbdcolsets(List<PSSysBDColSet> pssysbdcolsets) {
        this.pssysbdcolsets = pssysbdcolsets;
    }

    public List<PSSysBDTableDER> getPssysbdtableders() {
        return this.pssysbdtableders;
    }

    public void setPssysbdtableders(List<PSSysBDTableDER> pssysbdtableders) {
        this.pssysbdtableders = pssysbdtableders;
    }

    public List<PSSysBDTableDE> getPssysbdtabledes() {
        return this.pssysbdtabledes;
    }

    public void setPssysbdtabledes(List<PSSysBDTableDE> pssysbdtabledes) {
        this.pssysbdtabledes = pssysbdtabledes;
    }

    public List<PSSysBDColumn> getPssysbdcolumns() {
        return this.pssysbdcolumns;
    }

    public void setPssysbdcolumns(List<PSSysBDColumn> pssysbdcolumns) {
        this.pssysbdcolumns = pssysbdcolumns;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (strName.equalsIgnoreCase("pssysbdcolsets")) {
            return true;
        }
        if (strName.equalsIgnoreCase("pssysbdtableders")) {
            return true;
        }
        if (strName.equalsIgnoreCase("pssysbdtabledes")) {
            return true;
        }
        if (strName.equalsIgnoreCase("pssysbdcolumns")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("pssysbdcolsets")) {
            this.init();
            return this.pssysbdcolsets;
        }
        if (strName.equalsIgnoreCase("pssysbdtableders")) {
            this.init();
            return this.pssysbdtableders;
        }
        if (strName.equalsIgnoreCase("pssysbdtabledes")) {
            this.init();
            return this.pssysbdtabledes;
        }
        if (strName.equalsIgnoreCase("pssysbdcolumns")) {
            this.init();
            return this.pssysbdcolumns;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSSYSBDTABLE";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSSysBDTable item = (PSSysBDTable)MAPPER.readValue(new File(strJsonFilePath), PSSysBDTable.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSSysBDTable) {
            PSSysBDTable dst = (PSSysBDTable)target;
            if (!bSimple) {
                PSModelBase newitem;
                if (this.getPssysbdcolsets() != null) {
                    ArrayList<PSSysBDColSet> pssysbdcolsets = new ArrayList<PSSysBDColSet>();
                    for (PSSysBDColSet pSSysBDColSet : this.getPssysbdcolsets()) {
                        if (bDeepMode) {
                            newitem = new PSSysBDColSet();
                            pSSysBDColSet.to(newitem, false, bDeepMode);
                            pssysbdcolsets.add((PSSysBDColSet)newitem);
                            continue;
                        }
                        pssysbdcolsets.add(pSSysBDColSet);
                    }
                    dst.setPssysbdcolsets(pssysbdcolsets);
                }
                if (this.getPssysbdtableders() != null) {
                    ArrayList<PSSysBDTableDER> pssysbdtableders = new ArrayList<PSSysBDTableDER>();
                    for (PSSysBDTableDER pSSysBDTableDER : this.getPssysbdtableders()) {
                        if (bDeepMode) {
                            newitem = new PSSysBDTableDER();
                            pSSysBDTableDER.to(newitem, false, bDeepMode);
                            pssysbdtableders.add((PSSysBDTableDER)newitem);
                            continue;
                        }
                        pssysbdtableders.add(pSSysBDTableDER);
                    }
                    dst.setPssysbdtableders(pssysbdtableders);
                }
                if (this.getPssysbdtabledes() != null) {
                    ArrayList<PSSysBDTableDE> pssysbdtabledes = new ArrayList<PSSysBDTableDE>();
                    for (PSSysBDTableDE pSSysBDTableDE : this.getPssysbdtabledes()) {
                        if (bDeepMode) {
                            newitem = new PSSysBDTableDE();
                            pSSysBDTableDE.to(newitem, false, bDeepMode);
                            pssysbdtabledes.add((PSSysBDTableDE)newitem);
                            continue;
                        }
                        pssysbdtabledes.add(pSSysBDTableDE);
                    }
                    dst.setPssysbdtabledes(pssysbdtabledes);
                }
                if (this.getPssysbdcolumns() != null) {
                    ArrayList<PSSysBDColumn> pssysbdcolumns = new ArrayList<PSSysBDColumn>();
                    for (PSSysBDColumn pSSysBDColumn : this.getPssysbdcolumns()) {
                        if (bDeepMode) {
                            newitem = new PSSysBDColumn();
                            pSSysBDColumn.to(newitem, false, bDeepMode);
                            pssysbdcolumns.add((PSSysBDColumn)newitem);
                            continue;
                        }
                        pssysbdcolumns.add(pSSysBDColumn);
                    }
                    dst.setPssysbdcolumns(pssysbdcolumns);
                }
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSSysBDTable) {
            PSSysBDTable src = (PSSysBDTable)source;
            if (!bSimple) {
                PSModelBase newItem;
                if (src.getPssysbdcolsets() != null) {
                    ArrayList<PSSysBDColSet> pssysbdcolsets = new ArrayList<PSSysBDColSet>();
                    for (PSSysBDColSet pSSysBDColSet : src.getPssysbdcolsets()) {
                        if (bDeepMode) {
                            newItem = new PSSysBDColSet();
                            ((PSSysBDColSet)newItem).from(pSSysBDColSet, false, bDeepMode);
                            pssysbdcolsets.add((PSSysBDColSet)newItem);
                            continue;
                        }
                        pssysbdcolsets.add(pSSysBDColSet);
                    }
                    this.setPssysbdcolsets(pssysbdcolsets);
                }
                if (src.getPssysbdtableders() != null) {
                    ArrayList<PSSysBDTableDER> pssysbdtableders = new ArrayList<PSSysBDTableDER>();
                    for (PSSysBDTableDER pSSysBDTableDER : src.getPssysbdtableders()) {
                        if (bDeepMode) {
                            newItem = new PSSysBDTableDER();
                            ((PSSysBDTableDER)newItem).from(pSSysBDTableDER, false, bDeepMode);
                            pssysbdtableders.add((PSSysBDTableDER)newItem);
                            continue;
                        }
                        pssysbdtableders.add(pSSysBDTableDER);
                    }
                    this.setPssysbdtableders(pssysbdtableders);
                }
                if (src.getPssysbdtabledes() != null) {
                    ArrayList<PSSysBDTableDE> pssysbdtabledes = new ArrayList<PSSysBDTableDE>();
                    for (PSSysBDTableDE pSSysBDTableDE : src.getPssysbdtabledes()) {
                        if (bDeepMode) {
                            newItem = new PSSysBDTableDE();
                            ((PSSysBDTableDE)newItem).from(pSSysBDTableDE, false, bDeepMode);
                            pssysbdtabledes.add((PSSysBDTableDE)newItem);
                            continue;
                        }
                        pssysbdtabledes.add(pSSysBDTableDE);
                    }
                    this.setPssysbdtabledes(pssysbdtabledes);
                }
                if (src.getPssysbdcolumns() != null) {
                    ArrayList<PSSysBDColumn> pssysbdcolumns = new ArrayList<PSSysBDColumn>();
                    for (PSSysBDColumn pSSysBDColumn : src.getPssysbdcolumns()) {
                        if (bDeepMode) {
                            newItem = new PSSysBDColumn();
                            ((PSSysBDColumn)newItem).from(pSSysBDColumn, false, bDeepMode);
                            pssysbdcolumns.add((PSSysBDColumn)newItem);
                            continue;
                        }
                        pssysbdcolumns.add(pSSysBDColumn);
                    }
                    this.setPssysbdcolumns(pssysbdcolumns);
                }
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

