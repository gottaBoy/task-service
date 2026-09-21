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

public class PSDERDTO
extends PSModelDTOBase {
    public static final String FIELD_CLONEORDERVALUE = "cloneordervalue";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DEFINHERITMODE = "definheritmode";
    public static final String FIELD_DERFIELDLNAME = "derfieldlname";
    public static final String FIELD_DERFIELDNAME = "derfieldname";
    public static final String FIELD_DERSUBTYPE = "dersubtype";
    public static final String FIELD_DERTYPE = "dertype";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_ENADEFIELDWRITEBACK = "enadefieldwriteback";
    public static final String FIELD_ENAEXTRANGE = "enaextrange";
    public static final String FIELD_ENAPDEREQ = "enapdereq";
    public static final String FIELD_EXPORTMAJORMODEL = "exportmajormodel";
    public static final String FIELD_EXPORTMODEL = "exportmodel";
    public static final String FIELD_EXPORTSCOPE = "exportscope";
    public static final String FIELD_EXPORTSCOPE2 = "exportscope2";
    public static final String FIELD_EXPORTSCOPE3 = "exportscope3";
    public static final String FIELD_EXPORTSCOPE4 = "exportscope4";
    public static final String FIELD_EXPORTSCOPE5 = "exportscope5";
    public static final String FIELD_EXPORTSCOPE6 = "exportscope6";
    public static final String FIELD_EXTMAJORPSDEFID = "extmajorpsdefid";
    public static final String FIELD_EXTMAJORPSDEFNAME = "extmajorpsdefname";
    public static final String FIELD_EXTMINORPSDEFID = "extminorpsdefid";
    public static final String FIELD_EXTMINORPSDEFNAME = "extminorpsdefname";
    public static final String FIELD_FKEYNAME = "fkeyname";
    public static final String FIELD_FOREIGNKEY = "foreignkey";
    public static final String FIELD_IGNOREDEFIELDS = "ignoredefields";
    public static final String FIELD_INDEXVALUE = "indexvalue";
    public static final String FIELD_INHERITMODE = "inheritmode";
    public static final String FIELD_LINKPSDEVIEWID = "linkpsdeviewid";
    public static final String FIELD_LINKPSDEVIEWNAME = "linkpsdeviewname";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_LOGICNAME = "logicname";
    public static final String FIELD_MAJORPSDEID = "majorpsdeid";
    public static final String FIELD_MAJORPSDENAME = "majorpsdename";
    public static final String FIELD_MAJORPSDERID = "majorpsderid";
    public static final String FIELD_MAJORPSDERNAME = "majorpsdername";
    public static final String FIELD_MASTERORDERVALUE = "masterordervalue";
    public static final String FIELD_MASTERRS = "masterrs";
    public static final String FIELD_MDPSDEVIEWID = "mdpsdeviewid";
    public static final String FIELD_MDPSDEVIEWNAME = "mdpsdeviewname";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MINORCODENAME = "minorcodename";
    public static final String FIELD_MINORPSDEDSID = "minorpsdedsid";
    public static final String FIELD_MINORPSDEDSNAME = "minorpsdedsname";
    public static final String FIELD_MINORPSDEID = "minorpsdeid";
    public static final String FIELD_MINORPSDENAME = "minorpsdename";
    public static final String FIELD_MINORPSDERID = "minorpsderid";
    public static final String FIELD_MINORPSDERNAME = "minorpsdername";
    public static final String FIELD_MOBLINKPSDEVIEWID = "moblinkpsdeviewid";
    public static final String FIELD_MOBLINKPSDEVIEWNAME = "moblinkpsdeviewname";
    public static final String FIELD_MOBMDPSDEVIEWID = "mobmdpsdeviewid";
    public static final String FIELD_MOBMDPSDEVIEWNAME = "mobmdpsdeviewname";
    public static final String FIELD_MOBSDPSDEVIEWID = "mobsdpsdeviewid";
    public static final String FIELD_MOBSDPSDEVIEWNAME = "mobsdpsdeviewname";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PROPERTYMAP = "propertymap";
    public static final String FIELD_PSDEACMODEID = "psdeacmodeid";
    public static final String FIELD_PSDEACMODENAME = "psdeacmodename";
    public static final String FIELD_PSDEDATASETID = "psdedatasetid";
    public static final String FIELD_PSDEDATASETNAME = "psdedatasetname";
    public static final String FIELD_PSDERID = "psderid";
    public static final String FIELD_PSDERNAME = "psdername";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_REMOVEACTIONTYPE = "removeactiontype";
    public static final String FIELD_REMOVEORDER = "removeorder";
    public static final String FIELD_REMOVEREJECTMSG = "removerejectmsg";
    public static final String FIELD_REMOVEREJECTPSLANRESID = "removerejectpslanresid";
    public static final String FIELD_REMOVEREJECTPSLANRESNAME = "removerejectpslanresname";
    public static final String FIELD_RSPSDEVIEWID = "rspsdeviewid";
    public static final String FIELD_RSPSDEVIEWNAME = "rspsdeviewname";
    public static final String FIELD_SDPSDEVIEWID = "sdpsdeviewid";
    public static final String FIELD_SDPSDEVIEWNAME = "sdpsdeviewname";
    public static final String FIELD_SYNCEXPORTMODEL = "syncexportmodel";
    public static final String FIELD_TEMPORDERVALUE = "tempordervalue";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERPARAMS = "userparams";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";

    @JsonIgnore
    public Integer getCloneOrderValue() {
        Object objValue = this.get(FIELD_CLONEORDERVALUE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="cloneordervalue")
    public void setCloneOrderValue(Integer cloneOrderValue) {
        this.set(FIELD_CLONEORDERVALUE, cloneOrderValue);
    }

    @JsonIgnore
    public boolean isCloneOrderValueDirty() {
        return this.contains(FIELD_CLONEORDERVALUE);
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
    public Integer getDEFInheritMode() {
        Object objValue = this.get(FIELD_DEFINHERITMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="definheritmode")
    public void setDEFInheritMode(Integer dEFInheritMode) {
        this.set(FIELD_DEFINHERITMODE, dEFInheritMode);
    }

    @JsonIgnore
    public boolean isDEFInheritModeDirty() {
        return this.contains(FIELD_DEFINHERITMODE);
    }

    @JsonIgnore
    public String getDERFieldLName() {
        Object objValue = this.get(FIELD_DERFIELDLNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="derfieldlname")
    public void setDERFieldLName(String dERFieldLName) {
        this.set(FIELD_DERFIELDLNAME, dERFieldLName);
    }

    @JsonIgnore
    public boolean isDERFieldLNameDirty() {
        return this.contains(FIELD_DERFIELDLNAME);
    }

    @JsonIgnore
    public String getDERFieldName() {
        Object objValue = this.get(FIELD_DERFIELDNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="derfieldname")
    public void setDERFieldName(String dERFieldName) {
        this.set(FIELD_DERFIELDNAME, dERFieldName);
    }

    @JsonIgnore
    public boolean isDERFieldNameDirty() {
        return this.contains(FIELD_DERFIELDNAME);
    }

    @JsonIgnore
    public String getDERSubType() {
        Object objValue = this.get(FIELD_DERSUBTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dersubtype")
    public void setDERSubType(String dERSubType) {
        this.set(FIELD_DERSUBTYPE, dERSubType);
    }

    @JsonIgnore
    public boolean isDERSubTypeDirty() {
        return this.contains(FIELD_DERSUBTYPE);
    }

    @JsonIgnore
    public String getDERType() {
        Object objValue = this.get(FIELD_DERTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dertype")
    public void setDERType(String dERType) {
        this.set(FIELD_DERTYPE, dERType);
    }

    @JsonIgnore
    public boolean isDERTypeDirty() {
        return this.contains(FIELD_DERTYPE);
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
    public Integer getEnaDEFieldWriteBack() {
        Object objValue = this.get(FIELD_ENADEFIELDWRITEBACK);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enadefieldwriteback")
    public void setEnaDEFieldWriteBack(Integer enaDEFieldWriteBack) {
        this.set(FIELD_ENADEFIELDWRITEBACK, enaDEFieldWriteBack);
    }

    @JsonIgnore
    public boolean isEnaDEFieldWriteBackDirty() {
        return this.contains(FIELD_ENADEFIELDWRITEBACK);
    }

    @JsonIgnore
    public Integer getEnaExtRange() {
        Object objValue = this.get(FIELD_ENAEXTRANGE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enaextrange")
    public void setEnaExtRange(Integer enaExtRange) {
        this.set(FIELD_ENAEXTRANGE, enaExtRange);
    }

    @JsonIgnore
    public boolean isEnaExtRangeDirty() {
        return this.contains(FIELD_ENAEXTRANGE);
    }

    @JsonIgnore
    public Integer getEnaPDEREQ() {
        Object objValue = this.get(FIELD_ENAPDEREQ);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enapdereq")
    public void setEnaPDEREQ(Integer enaPDEREQ) {
        this.set(FIELD_ENAPDEREQ, enaPDEREQ);
    }

    @JsonIgnore
    public boolean isEnaPDEREQDirty() {
        return this.contains(FIELD_ENAPDEREQ);
    }

    @JsonIgnore
    public Integer getExportMajorModel() {
        Object objValue = this.get(FIELD_EXPORTMAJORMODEL);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="exportmajormodel")
    public void setExportMajorModel(Integer exportMajorModel) {
        this.set(FIELD_EXPORTMAJORMODEL, exportMajorModel);
    }

    @JsonIgnore
    public boolean isExportMajorModelDirty() {
        return this.contains(FIELD_EXPORTMAJORMODEL);
    }

    @JsonIgnore
    public Integer getExportModel() {
        Object objValue = this.get(FIELD_EXPORTMODEL);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="exportmodel")
    public void setExportModel(Integer exportModel) {
        this.set(FIELD_EXPORTMODEL, exportModel);
    }

    @JsonIgnore
    public boolean isExportModelDirty() {
        return this.contains(FIELD_EXPORTMODEL);
    }

    @JsonIgnore
    public Integer getExportScope() {
        Object objValue = this.get(FIELD_EXPORTSCOPE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="exportscope")
    public void setExportScope(Integer exportScope) {
        this.set(FIELD_EXPORTSCOPE, exportScope);
    }

    @JsonIgnore
    public boolean isExportScopeDirty() {
        return this.contains(FIELD_EXPORTSCOPE);
    }

    @JsonIgnore
    public Integer getExportScope2() {
        Object objValue = this.get(FIELD_EXPORTSCOPE2);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="exportscope2")
    public void setExportScope2(Integer exportScope2) {
        this.set(FIELD_EXPORTSCOPE2, exportScope2);
    }

    @JsonIgnore
    public boolean isExportScope2Dirty() {
        return this.contains(FIELD_EXPORTSCOPE2);
    }

    @JsonIgnore
    public Integer getExportScope3() {
        Object objValue = this.get(FIELD_EXPORTSCOPE3);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="exportscope3")
    public void setExportScope3(Integer exportScope3) {
        this.set(FIELD_EXPORTSCOPE3, exportScope3);
    }

    @JsonIgnore
    public boolean isExportScope3Dirty() {
        return this.contains(FIELD_EXPORTSCOPE3);
    }

    @JsonIgnore
    public Integer getExportScope4() {
        Object objValue = this.get(FIELD_EXPORTSCOPE4);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="exportscope4")
    public void setExportScope4(Integer exportScope4) {
        this.set(FIELD_EXPORTSCOPE4, exportScope4);
    }

    @JsonIgnore
    public boolean isExportScope4Dirty() {
        return this.contains(FIELD_EXPORTSCOPE4);
    }

    @JsonIgnore
    public Integer getExportScope5() {
        Object objValue = this.get(FIELD_EXPORTSCOPE5);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="exportscope5")
    public void setExportScope5(Integer exportScope5) {
        this.set(FIELD_EXPORTSCOPE5, exportScope5);
    }

    @JsonIgnore
    public boolean isExportScope5Dirty() {
        return this.contains(FIELD_EXPORTSCOPE5);
    }

    @JsonIgnore
    public Integer getExportScope6() {
        Object objValue = this.get(FIELD_EXPORTSCOPE6);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="exportscope6")
    public void setExportScope6(Integer exportScope6) {
        this.set(FIELD_EXPORTSCOPE6, exportScope6);
    }

    @JsonIgnore
    public boolean isExportScope6Dirty() {
        return this.contains(FIELD_EXPORTSCOPE6);
    }

    @JsonIgnore
    public String getEXTMajorPSDEFId() {
        Object objValue = this.get(FIELD_EXTMAJORPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="extmajorpsdefid")
    public void setEXTMajorPSDEFId(String eXTMajorPSDEFId) {
        this.set(FIELD_EXTMAJORPSDEFID, eXTMajorPSDEFId);
    }

    @JsonIgnore
    public boolean isEXTMajorPSDEFIdDirty() {
        return this.contains(FIELD_EXTMAJORPSDEFID);
    }

    @JsonIgnore
    public String getEXTMajorPSDEFName() {
        Object objValue = this.get(FIELD_EXTMAJORPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="extmajorpsdefname")
    public void setEXTMajorPSDEFName(String eXTMajorPSDEFName) {
        this.set(FIELD_EXTMAJORPSDEFNAME, eXTMajorPSDEFName);
    }

    @JsonIgnore
    public boolean isEXTMajorPSDEFNameDirty() {
        return this.contains(FIELD_EXTMAJORPSDEFNAME);
    }

    @JsonIgnore
    public String getEXTMinorPSDEFId() {
        Object objValue = this.get(FIELD_EXTMINORPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="extminorpsdefid")
    public void setEXTMinorPSDEFId(String eXTMinorPSDEFId) {
        this.set(FIELD_EXTMINORPSDEFID, eXTMinorPSDEFId);
    }

    @JsonIgnore
    public boolean isEXTMinorPSDEFIdDirty() {
        return this.contains(FIELD_EXTMINORPSDEFID);
    }

    @JsonIgnore
    public String getEXTMinorPSDEFName() {
        Object objValue = this.get(FIELD_EXTMINORPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="extminorpsdefname")
    public void setEXTMinorPSDEFName(String eXTMinorPSDEFName) {
        this.set(FIELD_EXTMINORPSDEFNAME, eXTMinorPSDEFName);
    }

    @JsonIgnore
    public boolean isEXTMinorPSDEFNameDirty() {
        return this.contains(FIELD_EXTMINORPSDEFNAME);
    }

    @JsonIgnore
    public String getFKeyName() {
        Object objValue = this.get(FIELD_FKEYNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="fkeyname")
    public void setFKeyName(String fKeyName) {
        this.set(FIELD_FKEYNAME, fKeyName);
    }

    @JsonIgnore
    public boolean isFKeyNameDirty() {
        return this.contains(FIELD_FKEYNAME);
    }

    @JsonIgnore
    public Integer getForeignKey() {
        Object objValue = this.get(FIELD_FOREIGNKEY);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="foreignkey")
    public void setForeignKey(Integer foreignKey) {
        this.set(FIELD_FOREIGNKEY, foreignKey);
    }

    @JsonIgnore
    public boolean isForeignKeyDirty() {
        return this.contains(FIELD_FOREIGNKEY);
    }

    @JsonIgnore
    public String getIgnoreDEFields() {
        Object objValue = this.get(FIELD_IGNOREDEFIELDS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ignoredefields")
    public void setIgnoreDEFields(String ignoreDEFields) {
        this.set(FIELD_IGNOREDEFIELDS, ignoreDEFields);
    }

    @JsonIgnore
    public boolean isIgnoreDEFieldsDirty() {
        return this.contains(FIELD_IGNOREDEFIELDS);
    }

    @JsonIgnore
    public String getIndexValue() {
        Object objValue = this.get(FIELD_INDEXVALUE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="indexvalue")
    public void setIndexValue(String indexValue) {
        this.set(FIELD_INDEXVALUE, indexValue);
    }

    @JsonIgnore
    public boolean isIndexValueDirty() {
        return this.contains(FIELD_INDEXVALUE);
    }

    @JsonIgnore
    public Integer getInheritMode() {
        Object objValue = this.get(FIELD_INHERITMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="inheritmode")
    public void setInheritMode(Integer inheritMode) {
        this.set(FIELD_INHERITMODE, inheritMode);
    }

    @JsonIgnore
    public boolean isInheritModeDirty() {
        return this.contains(FIELD_INHERITMODE);
    }

    @JsonIgnore
    public String getLinkPSDEViewId() {
        Object objValue = this.get(FIELD_LINKPSDEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="linkpsdeviewid")
    public void setLinkPSDEViewId(String linkPSDEViewId) {
        this.set(FIELD_LINKPSDEVIEWID, linkPSDEViewId);
    }

    @JsonIgnore
    public boolean isLinkPSDEViewIdDirty() {
        return this.contains(FIELD_LINKPSDEVIEWID);
    }

    @JsonIgnore
    public String getLinkPSDEViewName() {
        Object objValue = this.get(FIELD_LINKPSDEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="linkpsdeviewname")
    public void setLinkPSDEViewName(String linkPSDEViewName) {
        this.set(FIELD_LINKPSDEVIEWNAME, linkPSDEViewName);
    }

    @JsonIgnore
    public boolean isLinkPSDEViewNameDirty() {
        return this.contains(FIELD_LINKPSDEVIEWNAME);
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
    public String getMajorPSDEId() {
        Object objValue = this.get(FIELD_MAJORPSDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="majorpsdeid")
    public void setMajorPSDEId(String majorPSDEId) {
        this.set(FIELD_MAJORPSDEID, majorPSDEId);
    }

    @JsonIgnore
    public boolean isMajorPSDEIdDirty() {
        return this.contains(FIELD_MAJORPSDEID);
    }

    @JsonIgnore
    public String getMajorPSDEName() {
        Object objValue = this.get(FIELD_MAJORPSDENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="majorpsdename")
    public void setMajorPSDEName(String majorPSDEName) {
        this.set(FIELD_MAJORPSDENAME, majorPSDEName);
    }

    @JsonIgnore
    public boolean isMajorPSDENameDirty() {
        return this.contains(FIELD_MAJORPSDENAME);
    }

    @JsonIgnore
    public String getMajorPSDERId() {
        Object objValue = this.get(FIELD_MAJORPSDERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="majorpsderid")
    public void setMajorPSDERId(String majorPSDERId) {
        this.set(FIELD_MAJORPSDERID, majorPSDERId);
    }

    @JsonIgnore
    public boolean isMajorPSDERIdDirty() {
        return this.contains(FIELD_MAJORPSDERID);
    }

    @JsonIgnore
    public String getMajorPSDERName() {
        Object objValue = this.get(FIELD_MAJORPSDERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="majorpsdername")
    public void setMajorPSDERName(String majorPSDERName) {
        this.set(FIELD_MAJORPSDERNAME, majorPSDERName);
    }

    @JsonIgnore
    public boolean isMajorPSDERNameDirty() {
        return this.contains(FIELD_MAJORPSDERNAME);
    }

    @JsonIgnore
    public Integer getMasterOrderValue() {
        Object objValue = this.get(FIELD_MASTERORDERVALUE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="masterordervalue")
    public void setMasterOrderValue(Integer masterOrderValue) {
        this.set(FIELD_MASTERORDERVALUE, masterOrderValue);
    }

    @JsonIgnore
    public boolean isMasterOrderValueDirty() {
        return this.contains(FIELD_MASTERORDERVALUE);
    }

    @JsonIgnore
    public Integer getMasterRS() {
        Object objValue = this.get(FIELD_MASTERRS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="masterrs")
    public void setMasterRS(Integer masterRS) {
        this.set(FIELD_MASTERRS, masterRS);
    }

    @JsonIgnore
    public boolean isMasterRSDirty() {
        return this.contains(FIELD_MASTERRS);
    }

    @JsonIgnore
    public String getMDPSDEViewId() {
        Object objValue = this.get(FIELD_MDPSDEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mdpsdeviewid")
    public void setMDPSDEViewId(String mDPSDEViewId) {
        this.set(FIELD_MDPSDEVIEWID, mDPSDEViewId);
    }

    @JsonIgnore
    public boolean isMDPSDEViewIdDirty() {
        return this.contains(FIELD_MDPSDEVIEWID);
    }

    @JsonIgnore
    public String getMDPSDEViewName() {
        Object objValue = this.get(FIELD_MDPSDEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mdpsdeviewname")
    public void setMDPSDEViewName(String mDPSDEViewName) {
        this.set(FIELD_MDPSDEVIEWNAME, mDPSDEViewName);
    }

    @JsonIgnore
    public boolean isMDPSDEViewNameDirty() {
        return this.contains(FIELD_MDPSDEVIEWNAME);
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
    public String getMinorCodeName() {
        Object objValue = this.get(FIELD_MINORCODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="minorcodename")
    public void setMinorCodeName(String minorCodeName) {
        this.set(FIELD_MINORCODENAME, minorCodeName);
    }

    @JsonIgnore
    public boolean isMinorCodeNameDirty() {
        return this.contains(FIELD_MINORCODENAME);
    }

    @JsonIgnore
    public String getMinorPSDEDSId() {
        Object objValue = this.get(FIELD_MINORPSDEDSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="minorpsdedsid")
    public void setMinorPSDEDSId(String minorPSDEDSId) {
        this.set(FIELD_MINORPSDEDSID, minorPSDEDSId);
    }

    @JsonIgnore
    public boolean isMinorPSDEDSIdDirty() {
        return this.contains(FIELD_MINORPSDEDSID);
    }

    @JsonIgnore
    public String getMinorPSDEDSName() {
        Object objValue = this.get(FIELD_MINORPSDEDSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="minorpsdedsname")
    public void setMinorPSDEDSName(String minorPSDEDSName) {
        this.set(FIELD_MINORPSDEDSNAME, minorPSDEDSName);
    }

    @JsonIgnore
    public boolean isMinorPSDEDSNameDirty() {
        return this.contains(FIELD_MINORPSDEDSNAME);
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
    public String getMinorPSDERId() {
        Object objValue = this.get(FIELD_MINORPSDERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="minorpsderid")
    public void setMinorPSDERId(String minorPSDERId) {
        this.set(FIELD_MINORPSDERID, minorPSDERId);
    }

    @JsonIgnore
    public boolean isMinorPSDERIdDirty() {
        return this.contains(FIELD_MINORPSDERID);
    }

    @JsonIgnore
    public String getMinorPSDERName() {
        Object objValue = this.get(FIELD_MINORPSDERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="minorpsdername")
    public void setMinorPSDERName(String minorPSDERName) {
        this.set(FIELD_MINORPSDERNAME, minorPSDERName);
    }

    @JsonIgnore
    public boolean isMinorPSDERNameDirty() {
        return this.contains(FIELD_MINORPSDERNAME);
    }

    @JsonIgnore
    public String getMobLinkPSDEViewId() {
        Object objValue = this.get(FIELD_MOBLINKPSDEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="moblinkpsdeviewid")
    public void setMobLinkPSDEViewId(String mobLinkPSDEViewId) {
        this.set(FIELD_MOBLINKPSDEVIEWID, mobLinkPSDEViewId);
    }

    @JsonIgnore
    public boolean isMobLinkPSDEViewIdDirty() {
        return this.contains(FIELD_MOBLINKPSDEVIEWID);
    }

    @JsonIgnore
    public String getMobLinkPSDEViewName() {
        Object objValue = this.get(FIELD_MOBLINKPSDEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="moblinkpsdeviewname")
    public void setMobLinkPSDEViewName(String mobLinkPSDEViewName) {
        this.set(FIELD_MOBLINKPSDEVIEWNAME, mobLinkPSDEViewName);
    }

    @JsonIgnore
    public boolean isMobLinkPSDEViewNameDirty() {
        return this.contains(FIELD_MOBLINKPSDEVIEWNAME);
    }

    @JsonIgnore
    public String getMobMDPSDEViewId() {
        Object objValue = this.get(FIELD_MOBMDPSDEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobmdpsdeviewid")
    public void setMobMDPSDEViewId(String mobMDPSDEViewId) {
        this.set(FIELD_MOBMDPSDEVIEWID, mobMDPSDEViewId);
    }

    @JsonIgnore
    public boolean isMobMDPSDEViewIdDirty() {
        return this.contains(FIELD_MOBMDPSDEVIEWID);
    }

    @JsonIgnore
    public String getMobMDPSDEViewName() {
        Object objValue = this.get(FIELD_MOBMDPSDEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobmdpsdeviewname")
    public void setMobMDPSDEViewName(String mobMDPSDEViewName) {
        this.set(FIELD_MOBMDPSDEVIEWNAME, mobMDPSDEViewName);
    }

    @JsonIgnore
    public boolean isMobMDPSDEViewNameDirty() {
        return this.contains(FIELD_MOBMDPSDEVIEWNAME);
    }

    @JsonIgnore
    public String getMobSDPSDEViewId() {
        Object objValue = this.get(FIELD_MOBSDPSDEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobsdpsdeviewid")
    public void setMobSDPSDEViewId(String mobSDPSDEViewId) {
        this.set(FIELD_MOBSDPSDEVIEWID, mobSDPSDEViewId);
    }

    @JsonIgnore
    public boolean isMobSDPSDEViewIdDirty() {
        return this.contains(FIELD_MOBSDPSDEVIEWID);
    }

    @JsonIgnore
    public String getMobSDPSDEViewName() {
        Object objValue = this.get(FIELD_MOBSDPSDEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobsdpsdeviewname")
    public void setMobSDPSDEViewName(String mobSDPSDEViewName) {
        this.set(FIELD_MOBSDPSDEVIEWNAME, mobSDPSDEViewName);
    }

    @JsonIgnore
    public boolean isMobSDPSDEViewNameDirty() {
        return this.contains(FIELD_MOBSDPSDEVIEWNAME);
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
    public String getPropertyMap() {
        Object objValue = this.get(FIELD_PROPERTYMAP);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="propertymap")
    public void setPropertyMap(String propertyMap) {
        this.set(FIELD_PROPERTYMAP, propertyMap);
    }

    @JsonIgnore
    public boolean isPropertyMapDirty() {
        return this.contains(FIELD_PROPERTYMAP);
    }

    @JsonIgnore
    public String getPSDEACModeId() {
        Object objValue = this.get(FIELD_PSDEACMODEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeacmodeid")
    public void setPSDEACModeId(String pSDEACModeId) {
        this.set(FIELD_PSDEACMODEID, pSDEACModeId);
    }

    @JsonIgnore
    public boolean isPSDEACModeIdDirty() {
        return this.contains(FIELD_PSDEACMODEID);
    }

    @JsonIgnore
    public String getPSDEACModeName() {
        Object objValue = this.get(FIELD_PSDEACMODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeacmodename")
    public void setPSDEACModeName(String pSDEACModeName) {
        this.set(FIELD_PSDEACMODENAME, pSDEACModeName);
    }

    @JsonIgnore
    public boolean isPSDEACModeNameDirty() {
        return this.contains(FIELD_PSDEACMODENAME);
    }

    @JsonIgnore
    public String getPSDEDataSetId() {
        Object objValue = this.get(FIELD_PSDEDATASETID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedatasetid")
    public void setPSDEDataSetId(String pSDEDataSetId) {
        this.set(FIELD_PSDEDATASETID, pSDEDataSetId);
    }

    @JsonIgnore
    public boolean isPSDEDataSetIdDirty() {
        return this.contains(FIELD_PSDEDATASETID);
    }

    @JsonIgnore
    public String getPSDEDataSetName() {
        Object objValue = this.get(FIELD_PSDEDATASETNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedatasetname")
    public void setPSDEDataSetName(String pSDEDataSetName) {
        this.set(FIELD_PSDEDATASETNAME, pSDEDataSetName);
    }

    @JsonIgnore
    public boolean isPSDEDataSetNameDirty() {
        return this.contains(FIELD_PSDEDATASETNAME);
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
    public String getPSSystemName() {
        Object objValue = this.get(FIELD_PSSYSTEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystemname")
    public void setPSSystemName(String pSSystemName) {
        this.set(FIELD_PSSYSTEMNAME, pSSystemName);
    }

    @JsonIgnore
    public boolean isPSSystemNameDirty() {
        return this.contains(FIELD_PSSYSTEMNAME);
    }

    @JsonIgnore
    public Integer getRemoveActionType() {
        Object objValue = this.get(FIELD_REMOVEACTIONTYPE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="removeactiontype")
    public void setRemoveActionType(Integer removeActionType) {
        this.set(FIELD_REMOVEACTIONTYPE, removeActionType);
    }

    @JsonIgnore
    public boolean isRemoveActionTypeDirty() {
        return this.contains(FIELD_REMOVEACTIONTYPE);
    }

    @JsonIgnore
    public Integer getRemoveOrder() {
        Object objValue = this.get(FIELD_REMOVEORDER);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="removeorder")
    public void setRemoveOrder(Integer removeOrder) {
        this.set(FIELD_REMOVEORDER, removeOrder);
    }

    @JsonIgnore
    public boolean isRemoveOrderDirty() {
        return this.contains(FIELD_REMOVEORDER);
    }

    @JsonIgnore
    public String getRemoveRejectMsg() {
        Object objValue = this.get(FIELD_REMOVEREJECTMSG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="removerejectmsg")
    public void setRemoveRejectMsg(String removeRejectMsg) {
        this.set(FIELD_REMOVEREJECTMSG, removeRejectMsg);
    }

    @JsonIgnore
    public boolean isRemoveRejectMsgDirty() {
        return this.contains(FIELD_REMOVEREJECTMSG);
    }

    @JsonIgnore
    public String getRemoveRejectPSLanResId() {
        Object objValue = this.get(FIELD_REMOVEREJECTPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="removerejectpslanresid")
    public void setRemoveRejectPSLanResId(String removeRejectPSLanResId) {
        this.set(FIELD_REMOVEREJECTPSLANRESID, removeRejectPSLanResId);
    }

    @JsonIgnore
    public boolean isRemoveRejectPSLanResIdDirty() {
        return this.contains(FIELD_REMOVEREJECTPSLANRESID);
    }

    @JsonIgnore
    public String getRemoveRejectPSLanResName() {
        Object objValue = this.get(FIELD_REMOVEREJECTPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="removerejectpslanresname")
    public void setRemoveRejectPSLanResName(String removeRejectPSLanResName) {
        this.set(FIELD_REMOVEREJECTPSLANRESNAME, removeRejectPSLanResName);
    }

    @JsonIgnore
    public boolean isRemoveRejectPSLanResNameDirty() {
        return this.contains(FIELD_REMOVEREJECTPSLANRESNAME);
    }

    @JsonIgnore
    public String getRSPSDEViewId() {
        Object objValue = this.get(FIELD_RSPSDEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="rspsdeviewid")
    public void setRSPSDEViewId(String rSPSDEViewId) {
        this.set(FIELD_RSPSDEVIEWID, rSPSDEViewId);
    }

    @JsonIgnore
    public boolean isRSPSDEViewIdDirty() {
        return this.contains(FIELD_RSPSDEVIEWID);
    }

    @JsonIgnore
    public String getRSPSDEViewName() {
        Object objValue = this.get(FIELD_RSPSDEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="rspsdeviewname")
    public void setRSPSDEViewName(String rSPSDEViewName) {
        this.set(FIELD_RSPSDEVIEWNAME, rSPSDEViewName);
    }

    @JsonIgnore
    public boolean isRSPSDEViewNameDirty() {
        return this.contains(FIELD_RSPSDEVIEWNAME);
    }

    @JsonIgnore
    public String getSDPSDEViewID() {
        Object objValue = this.get(FIELD_SDPSDEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="sdpsdeviewid")
    public void setSDPSDEViewID(String sDPSDEViewID) {
        this.set(FIELD_SDPSDEVIEWID, sDPSDEViewID);
    }

    @JsonIgnore
    public boolean isSDPSDEViewIDDirty() {
        return this.contains(FIELD_SDPSDEVIEWID);
    }

    @JsonIgnore
    public String getSDPSDEViewName() {
        Object objValue = this.get(FIELD_SDPSDEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="sdpsdeviewname")
    public void setSDPSDEViewName(String sDPSDEViewName) {
        this.set(FIELD_SDPSDEVIEWNAME, sDPSDEViewName);
    }

    @JsonIgnore
    public boolean isSDPSDEViewNameDirty() {
        return this.contains(FIELD_SDPSDEVIEWNAME);
    }

    @JsonIgnore
    public Integer getSyncExportModel() {
        Object objValue = this.get(FIELD_SYNCEXPORTMODEL);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="syncexportmodel")
    public void setSyncExportModel(Integer syncExportModel) {
        this.set(FIELD_SYNCEXPORTMODEL, syncExportModel);
    }

    @JsonIgnore
    public boolean isSyncExportModelDirty() {
        return this.contains(FIELD_SYNCEXPORTMODEL);
    }

    @JsonIgnore
    public Integer getTempOrderValue() {
        Object objValue = this.get(FIELD_TEMPORDERVALUE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="tempordervalue")
    public void setTempOrderValue(Integer tempOrderValue) {
        this.set(FIELD_TEMPORDERVALUE, tempOrderValue);
    }

    @JsonIgnore
    public boolean isTempOrderValueDirty() {
        return this.contains(FIELD_TEMPORDERVALUE);
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

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDERId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSDERId(strValue);
    }
}

