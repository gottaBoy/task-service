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

public class PSDEFieldDTO
extends PSModelDTOBase {
    public static final String FIELD_ALLOWEMPTY = "allowempty";
    public static final String FIELD_AUDITINFOFORMAT = "auditinfoformat";
    public static final String FIELD_BIZTAG = "biztag";
    public static final String FIELD_CHECKRECURSION = "checkrecursion";
    public static final String FIELD_CODENAME = "codename";
    public static final String FIELD_COMPUTEEXP = "computeexp";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CUSTOMEXPORTSCOPE = "customexportscope";
    public static final String FIELD_DBVALUEMODE = "dbvaluemode";
    public static final String FIELD_DBVALUEMODE2 = "dbvaluemode2";
    public static final String FIELD_DEFAULTVALUE = "defaultvalue";
    public static final String FIELD_DEFTYPE = "deftype";
    public static final String FIELD_DERPSDEFID = "derpsdefid";
    public static final String FIELD_DERPSDEFNAME = "derpsdefname";
    public static final String FIELD_DUPCHECKMODE = "dupcheckmode";
    public static final String FIELD_DUPCHECKVALUES = "dupcheckvalues";
    public static final String FIELD_DUPCHECKPSDEFID = "dupchkpsdefid";
    public static final String FIELD_DUPCHECKPSDEFNAME = "dupchkpsdefname";
    public static final String FIELD_DEFAULTVALUETYPE = "dvt";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_ENABLEAUDIT = "enableaudit";
    public static final String FIELD_ENABLECOLPRIV = "enablecolpriv";
    public static final String FIELD_ENABLEQS = "enableqs";
    public static final String FIELD_ENABLETEMPDATA = "enabletempdata";
    public static final String FIELD_ENABLEUSERINPUT = "enableuserinput";
    public static final String FIELD_ENAWRITEBACK = "enawriteback";
    public static final String FIELD_EXPORTSCOPE = "exportscope";
    public static final String FIELD_EXTENDMODE = "extendmode";
    public static final String FIELD_FIELDHOLDER = "fieldholder";
    public static final String FIELD_FIELDTAG = "fieldtag";
    public static final String FIELD_FIELDTAG2 = "fieldtag2";
    public static final String FIELD_FKEY = "fkey";
    public static final String FIELD_FORMULAFIELDS = "formulafields";
    public static final String FIELD_FORMULAFORMAT = "formulaformat";
    public static final String FIELD_IMPORTKEY = "importkey";
    public static final String FIELD_IMPORTORDER = "importorder";
    public static final String FIELD_IMPORTTAG = "importtag";
    public static final String FIELD_INDEXTYPE = "indextype";
    public static final String FIELD_JSFORMAT = "jsformat";
    public static final String FIELD_JSONFORMAT = "jsonformat";
    public static final String FIELD_LENGTH = "length";
    public static final String FIELD_LNPSLANRESID = "lnpslanresid";
    public static final String FIELD_LNPSLANRESNAME = "lnpslanresname";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_LOGICNAME = "logicname";
    public static final String FIELD_MAJORFIELD = "majorfield";
    public static final String FIELD_MAXVALUE = "maxvalue";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MINSTRLENGTH = "minstrlength";
    public static final String FIELD_MINVALUE = "minvalue";
    public static final String FIELD_MULTIFORMFIELD = "multiformfield";
    public static final String FIELD_NO2DUPCHKPSDEFID = "no2dupchkpsdefid";
    public static final String FIELD_NO2DUPCHKPSDEFNAME = "no2dupchkpsdefname";
    public static final String FIELD_NO3DUPCHKPSDEFID = "no3dupchkpsdefid";
    public static final String FIELD_NO3DUPCHKPSDEFNAME = "no3dupchkpsdefname";
    public static final String FIELD_NULLVALORDER = "nullvalorder";
    public static final String FIELD_O2MPSDERID = "o2mpsderid";
    public static final String FIELD_O2MPSDERNAME = "o2mpsdername";
    public static final String FIELD_O2OPSDERID = "o2opsderid";
    public static final String FIELD_O2OPSDERNAME = "o2opsdername";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PASTERESET = "pastereset";
    public static final String FIELD_PHYSICALFIELD = "physicalfield";
    public static final String FIELD_PKEY = "pkey";
    public static final String FIELD_PRECISION2 = "precision2";
    public static final String FIELD_PREDEFINETYPE = "predefinetype";
    public static final String FIELD_PSCODELISTID = "pscodelistid";
    public static final String FIELD_PSCODELISTNAME = "pscodelistname";
    public static final String FIELD_PSDATATYPEID = "psdatatypeid";
    public static final String FIELD_PSDATATYPENAME = "psdatatypename";
    public static final String FIELD_PSDEFIELDID = "psdefieldid";
    public static final String FIELD_PSDEFIELDNAME = "psdefieldname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSDERID = "psderid";
    public static final String FIELD_PSDERNAME = "psdername";
    public static final String FIELD_PSDETABLEID = "psdetableid";
    public static final String FIELD_PSSUBSYSSADEFIELDID = "pssubsyssadefieldid";
    public static final String FIELD_PSSUBSYSSADEFIELDNAME = "pssubsyssadefieldname";
    public static final String FIELD_PSSUBSYSSADEID = "pssubsyssadeid";
    public static final String FIELD_PSSYSDBCOLUMNID = "pssysdbcolumnid";
    public static final String FIELD_PSSYSSAMPLEVALUEID = "pssyssamplevalueid";
    public static final String FIELD_PSSYSSAMPLEVALUENAME = "pssyssamplevaluename";
    public static final String FIELD_PSSYSSEQUENCEID = "pssyssequenceid";
    public static final String FIELD_PSSYSSEQUENCENAME = "pssyssequencename";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTRANSLATORID = "pssystranslatorid";
    public static final String FIELD_PSSYSTRANSLATORNAME = "pssystranslatorname";
    public static final String FIELD_PSSYSUNITID = "pssysunitid";
    public static final String FIELD_PSSYSUNITNAME = "pssysunitname";
    public static final String FIELD_PSSYSVALUERULEID = "pssysvalueruleid";
    public static final String FIELD_PSSYSVALUERULENAME = "pssysvaluerulename";
    public static final String FIELD_QUERYCOLUMN = "querycolumn";
    public static final String FIELD_QUERYCS = "querycs";
    public static final String FIELD_READONLYMODE = "readonlymode";
    public static final String FIELD_REFPSSYSDYNAMODELID = "refpssysdynamodelid";
    public static final String FIELD_REFPSSYSDYNAMODELNAME = "refpssysdynamodelname";
    public static final String FIELD_RESTRICTEDPSDEFID = "restrictedpsdefid";
    public static final String FIELD_RESTRICTEDPSDEFNAME = "restrictedpsdefname";
    public static final String FIELD_SEQUENCEMODE = "sequencemode";
    public static final String FIELD_SERVICECODENAME = "servicecodename";
    public static final String FIELD_STATEFIELD = "statefield";
    public static final String FIELD_STDDATATYPE = "stddatatype";
    public static final String FIELD_STRINGCASE = "stringcase";
    public static final String FIELD_STRLENGTH = "strlength";
    public static final String FIELD_TABLENAME = "tablename";
    public static final String FIELD_TABLESCOPE = "tablescope";
    public static final String FIELD_TESTDATA = "testdata";
    public static final String FIELD_TRANSLATORMODE = "translatormode";
    public static final String FIELD_UNICODECHAR = "unicodechar";
    public static final String FIELD_UNIONKEYVALUE = "unionkeyvalue";
    public static final String FIELD_UNIT = "unit";
    public static final String FIELD_UNITWIDTH = "unitwidth";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_UPDATEOVMODE = "updateovmode";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERPARAMS = "userparams";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";
    public static final String FIELD_VALUEFORMAT = "valueformat";
    public static final String FIELD_VALUEPSDEFID = "valuepsdefid";
    public static final String FIELD_VALUEPSDEFNAME = "valuepsdefname";
    public static final String FIELD_VIEWCOLLEVEL = "viewcollevel";

    @JsonIgnore
    public Integer getAllowEmpty() {
        Object objValue = this.get(FIELD_ALLOWEMPTY);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="allowempty")
    public void setAllowEmpty(Integer allowEmpty) {
        this.set(FIELD_ALLOWEMPTY, allowEmpty);
    }

    @JsonIgnore
    public boolean isAllowEmptyDirty() {
        return this.contains(FIELD_ALLOWEMPTY);
    }

    @JsonIgnore
    public String getAuditInfoFormat() {
        Object objValue = this.get(FIELD_AUDITINFOFORMAT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="auditinfoformat")
    public void setAuditInfoFormat(String auditInfoFormat) {
        this.set(FIELD_AUDITINFOFORMAT, auditInfoFormat);
    }

    @JsonIgnore
    public boolean isAuditInfoFormatDirty() {
        return this.contains(FIELD_AUDITINFOFORMAT);
    }

    @JsonIgnore
    public String getBizTag() {
        Object objValue = this.get(FIELD_BIZTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="biztag")
    public void setBizTag(String bizTag) {
        this.set(FIELD_BIZTAG, bizTag);
    }

    @JsonIgnore
    public boolean isBizTagDirty() {
        return this.contains(FIELD_BIZTAG);
    }

    @JsonIgnore
    public Integer getCheckRecursion() {
        Object objValue = this.get(FIELD_CHECKRECURSION);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="checkrecursion")
    public void setCheckRecursion(Integer checkRecursion) {
        this.set(FIELD_CHECKRECURSION, checkRecursion);
    }

    @JsonIgnore
    public boolean isCheckRecursionDirty() {
        return this.contains(FIELD_CHECKRECURSION);
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
    public String getComputeExp() {
        Object objValue = this.get(FIELD_COMPUTEEXP);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="computeexp")
    public void setComputeExp(String computeExp) {
        this.set(FIELD_COMPUTEEXP, computeExp);
    }

    @JsonIgnore
    public boolean isComputeExpDirty() {
        return this.contains(FIELD_COMPUTEEXP);
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
    public Integer getCustomExportScope() {
        Object objValue = this.get(FIELD_CUSTOMEXPORTSCOPE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="customexportscope")
    public void setCustomExportScope(Integer customExportScope) {
        this.set(FIELD_CUSTOMEXPORTSCOPE, customExportScope);
    }

    @JsonIgnore
    public boolean isCustomExportScopeDirty() {
        return this.contains(FIELD_CUSTOMEXPORTSCOPE);
    }

    @JsonIgnore
    public String getDBValueMode() {
        Object objValue = this.get(FIELD_DBVALUEMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dbvaluemode")
    public void setDBValueMode(String dBValueMode) {
        this.set(FIELD_DBVALUEMODE, dBValueMode);
    }

    @JsonIgnore
    public boolean isDBValueModeDirty() {
        return this.contains(FIELD_DBVALUEMODE);
    }

    @JsonIgnore
    public String getDBValueMode2() {
        Object objValue = this.get(FIELD_DBVALUEMODE2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dbvaluemode2")
    public void setDBValueMode2(String dBValueMode2) {
        this.set(FIELD_DBVALUEMODE2, dBValueMode2);
    }

    @JsonIgnore
    public boolean isDBValueMode2Dirty() {
        return this.contains(FIELD_DBVALUEMODE2);
    }

    @JsonIgnore
    public String getDefaultValue() {
        Object objValue = this.get(FIELD_DEFAULTVALUE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="defaultvalue")
    public void setDefaultValue(String defaultValue) {
        this.set(FIELD_DEFAULTVALUE, defaultValue);
    }

    @JsonIgnore
    public boolean isDefaultValueDirty() {
        return this.contains(FIELD_DEFAULTVALUE);
    }

    @JsonIgnore
    public Integer getDEFType() {
        Object objValue = this.get(FIELD_DEFTYPE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="deftype")
    public void setDEFType(Integer dEFType) {
        this.set(FIELD_DEFTYPE, dEFType);
    }

    @JsonIgnore
    public boolean isDEFTypeDirty() {
        return this.contains(FIELD_DEFTYPE);
    }

    @JsonIgnore
    public String getDERPSDEFId() {
        Object objValue = this.get(FIELD_DERPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="derpsdefid")
    public void setDERPSDEFId(String dERPSDEFId) {
        this.set(FIELD_DERPSDEFID, dERPSDEFId);
    }

    @JsonIgnore
    public boolean isDERPSDEFIdDirty() {
        return this.contains(FIELD_DERPSDEFID);
    }

    @JsonIgnore
    public String getDERPSDEFName() {
        Object objValue = this.get(FIELD_DERPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="derpsdefname")
    public void setDERPSDEFName(String dERPSDEFName) {
        this.set(FIELD_DERPSDEFNAME, dERPSDEFName);
    }

    @JsonIgnore
    public boolean isDERPSDEFNameDirty() {
        return this.contains(FIELD_DERPSDEFNAME);
    }

    @JsonIgnore
    public String getDupCheckMode() {
        Object objValue = this.get(FIELD_DUPCHECKMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dupcheckmode")
    public void setDupCheckMode(String dupCheckMode) {
        this.set(FIELD_DUPCHECKMODE, dupCheckMode);
    }

    @JsonIgnore
    public boolean isDupCheckModeDirty() {
        return this.contains(FIELD_DUPCHECKMODE);
    }

    @JsonIgnore
    public String getDupCheckValues() {
        Object objValue = this.get(FIELD_DUPCHECKVALUES);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dupcheckvalues")
    public void setDupCheckValues(String dupCheckValues) {
        this.set(FIELD_DUPCHECKVALUES, dupCheckValues);
    }

    @JsonIgnore
    public boolean isDupCheckValuesDirty() {
        return this.contains(FIELD_DUPCHECKVALUES);
    }

    @JsonIgnore
    public String getDupCheckPSDEFId() {
        Object objValue = this.get(FIELD_DUPCHECKPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dupchkpsdefid")
    public void setDupCheckPSDEFId(String dupCheckPSDEFId) {
        this.set(FIELD_DUPCHECKPSDEFID, dupCheckPSDEFId);
    }

    @JsonIgnore
    public boolean isDupCheckPSDEFIdDirty() {
        return this.contains(FIELD_DUPCHECKPSDEFID);
    }

    @JsonIgnore
    public String getDupCheckPSDEFName() {
        Object objValue = this.get(FIELD_DUPCHECKPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dupchkpsdefname")
    public void setDupCheckPSDEFName(String dupCheckPSDEFName) {
        this.set(FIELD_DUPCHECKPSDEFNAME, dupCheckPSDEFName);
    }

    @JsonIgnore
    public boolean isDupCheckPSDEFNameDirty() {
        return this.contains(FIELD_DUPCHECKPSDEFNAME);
    }

    @JsonIgnore
    public String getDefaultValueType() {
        Object objValue = this.get(FIELD_DEFAULTVALUETYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dvt")
    public void setDefaultValueType(String defaultValueType) {
        this.set(FIELD_DEFAULTVALUETYPE, defaultValueType);
    }

    @JsonIgnore
    public boolean isDefaultValueTypeDirty() {
        return this.contains(FIELD_DEFAULTVALUETYPE);
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
    public Integer getEnableAudit() {
        Object objValue = this.get(FIELD_ENABLEAUDIT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enableaudit")
    public void setEnableAudit(Integer enableAudit) {
        this.set(FIELD_ENABLEAUDIT, enableAudit);
    }

    @JsonIgnore
    public boolean isEnableAuditDirty() {
        return this.contains(FIELD_ENABLEAUDIT);
    }

    @JsonIgnore
    public Integer getEnableColPriv() {
        Object objValue = this.get(FIELD_ENABLECOLPRIV);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablecolpriv")
    public void setEnableColPriv(Integer enableColPriv) {
        this.set(FIELD_ENABLECOLPRIV, enableColPriv);
    }

    @JsonIgnore
    public boolean isEnableColPrivDirty() {
        return this.contains(FIELD_ENABLECOLPRIV);
    }

    @JsonIgnore
    public Integer getEnableQS() {
        Object objValue = this.get(FIELD_ENABLEQS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enableqs")
    public void setEnableQS(Integer enableQS) {
        this.set(FIELD_ENABLEQS, enableQS);
    }

    @JsonIgnore
    public boolean isEnableQSDirty() {
        return this.contains(FIELD_ENABLEQS);
    }

    @JsonIgnore
    public Integer getEnableTempData() {
        Object objValue = this.get(FIELD_ENABLETEMPDATA);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enabletempdata")
    public void setEnableTempData(Integer enableTempData) {
        this.set(FIELD_ENABLETEMPDATA, enableTempData);
    }

    @JsonIgnore
    public boolean isEnableTempDataDirty() {
        return this.contains(FIELD_ENABLETEMPDATA);
    }

    @JsonIgnore
    public Integer getEnableUserInput() {
        Object objValue = this.get(FIELD_ENABLEUSERINPUT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enableuserinput")
    public void setEnableUserInput(Integer enableUserInput) {
        this.set(FIELD_ENABLEUSERINPUT, enableUserInput);
    }

    @JsonIgnore
    public boolean isEnableUserInputDirty() {
        return this.contains(FIELD_ENABLEUSERINPUT);
    }

    @JsonIgnore
    public Integer getEnaWriteBack() {
        Object objValue = this.get(FIELD_ENAWRITEBACK);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enawriteback")
    public void setEnaWriteBack(Integer enaWriteBack) {
        this.set(FIELD_ENAWRITEBACK, enaWriteBack);
    }

    @JsonIgnore
    public boolean isEnaWriteBackDirty() {
        return this.contains(FIELD_ENAWRITEBACK);
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
    public Integer getExtendMode() {
        Object objValue = this.get(FIELD_EXTENDMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="extendmode")
    public void setExtendMode(Integer extendMode) {
        this.set(FIELD_EXTENDMODE, extendMode);
    }

    @JsonIgnore
    public boolean isExtendModeDirty() {
        return this.contains(FIELD_EXTENDMODE);
    }

    @JsonIgnore
    public Integer getFieldHolder() {
        Object objValue = this.get(FIELD_FIELDHOLDER);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="fieldholder")
    public void setFieldHolder(Integer fieldHolder) {
        this.set(FIELD_FIELDHOLDER, fieldHolder);
    }

    @JsonIgnore
    public boolean isFieldHolderDirty() {
        return this.contains(FIELD_FIELDHOLDER);
    }

    @JsonIgnore
    public String getFieldTag() {
        Object objValue = this.get(FIELD_FIELDTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="fieldtag")
    public void setFieldTag(String fieldTag) {
        this.set(FIELD_FIELDTAG, fieldTag);
    }

    @JsonIgnore
    public boolean isFieldTagDirty() {
        return this.contains(FIELD_FIELDTAG);
    }

    @JsonIgnore
    public String getFieldTag2() {
        Object objValue = this.get(FIELD_FIELDTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="fieldtag2")
    public void setFieldTag2(String fieldTag2) {
        this.set(FIELD_FIELDTAG2, fieldTag2);
    }

    @JsonIgnore
    public boolean isFieldTag2Dirty() {
        return this.contains(FIELD_FIELDTAG2);
    }

    @JsonIgnore
    public Integer getFKey() {
        Object objValue = this.get(FIELD_FKEY);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="fkey")
    public void setFKey(Integer fKey) {
        this.set(FIELD_FKEY, fKey);
    }

    @JsonIgnore
    public boolean isFKeyDirty() {
        return this.contains(FIELD_FKEY);
    }

    @JsonIgnore
    public String getFormulaFields() {
        Object objValue = this.get(FIELD_FORMULAFIELDS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="formulafields")
    public void setFormulaFields(String formulaFields) {
        this.set(FIELD_FORMULAFIELDS, formulaFields);
    }

    @JsonIgnore
    public boolean isFormulaFieldsDirty() {
        return this.contains(FIELD_FORMULAFIELDS);
    }

    @JsonIgnore
    public String getFormulaFormat() {
        Object objValue = this.get(FIELD_FORMULAFORMAT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="formulaformat")
    public void setFormulaFormat(String formulaFormat) {
        this.set(FIELD_FORMULAFORMAT, formulaFormat);
    }

    @JsonIgnore
    public boolean isFormulaFormatDirty() {
        return this.contains(FIELD_FORMULAFORMAT);
    }

    @JsonIgnore
    public Integer getImportKey() {
        Object objValue = this.get(FIELD_IMPORTKEY);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="importkey")
    public void setImportKey(Integer importKey) {
        this.set(FIELD_IMPORTKEY, importKey);
    }

    @JsonIgnore
    public boolean isImportKeyDirty() {
        return this.contains(FIELD_IMPORTKEY);
    }

    @JsonIgnore
    public Integer getImportOrder() {
        Object objValue = this.get(FIELD_IMPORTORDER);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="importorder")
    public void setImportOrder(Integer importOrder) {
        this.set(FIELD_IMPORTORDER, importOrder);
    }

    @JsonIgnore
    public boolean isImportOrderDirty() {
        return this.contains(FIELD_IMPORTORDER);
    }

    @JsonIgnore
    public String getImportTag() {
        Object objValue = this.get(FIELD_IMPORTTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="importtag")
    public void setImportTag(String importTag) {
        this.set(FIELD_IMPORTTAG, importTag);
    }

    @JsonIgnore
    public boolean isImportTagDirty() {
        return this.contains(FIELD_IMPORTTAG);
    }

    @JsonIgnore
    public Integer getIndexType() {
        Object objValue = this.get(FIELD_INDEXTYPE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="indextype")
    public void setIndexType(Integer indexType) {
        this.set(FIELD_INDEXTYPE, indexType);
    }

    @JsonIgnore
    public boolean isIndexTypeDirty() {
        return this.contains(FIELD_INDEXTYPE);
    }

    @JsonIgnore
    public String getJSFormat() {
        Object objValue = this.get(FIELD_JSFORMAT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="jsformat")
    public void setJSFormat(String jSFormat) {
        this.set(FIELD_JSFORMAT, jSFormat);
    }

    @JsonIgnore
    public boolean isJSFormatDirty() {
        return this.contains(FIELD_JSFORMAT);
    }

    @JsonIgnore
    public String getJsonFormat() {
        Object objValue = this.get(FIELD_JSONFORMAT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="jsonformat")
    public void setJsonFormat(String jsonFormat) {
        this.set(FIELD_JSONFORMAT, jsonFormat);
    }

    @JsonIgnore
    public boolean isJsonFormatDirty() {
        return this.contains(FIELD_JSONFORMAT);
    }

    @JsonIgnore
    public Integer getLength() {
        Object objValue = this.get(FIELD_LENGTH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="length")
    public void setLength(Integer length) {
        this.set(FIELD_LENGTH, length);
    }

    @JsonIgnore
    public boolean isLengthDirty() {
        return this.contains(FIELD_LENGTH);
    }

    @JsonIgnore
    public String getLNPSLanResId() {
        Object objValue = this.get(FIELD_LNPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="lnpslanresid")
    public void setLNPSLanResId(String lNPSLanResId) {
        this.set(FIELD_LNPSLANRESID, lNPSLanResId);
    }

    @JsonIgnore
    public boolean isLNPSLanResIdDirty() {
        return this.contains(FIELD_LNPSLANRESID);
    }

    @JsonIgnore
    public String getLNPSLanResName() {
        Object objValue = this.get(FIELD_LNPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="lnpslanresname")
    public void setLNPSLanResName(String lNPSLanResName) {
        this.set(FIELD_LNPSLANRESNAME, lNPSLanResName);
    }

    @JsonIgnore
    public boolean isLNPSLanResNameDirty() {
        return this.contains(FIELD_LNPSLANRESNAME);
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
    public Integer getMajorField() {
        Object objValue = this.get(FIELD_MAJORFIELD);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="majorfield")
    public void setMajorField(Integer majorField) {
        this.set(FIELD_MAJORFIELD, majorField);
    }

    @JsonIgnore
    public boolean isMajorFieldDirty() {
        return this.contains(FIELD_MAJORFIELD);
    }

    @JsonIgnore
    public String getMaxValue() {
        Object objValue = this.get(FIELD_MAXVALUE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="maxvalue")
    public void setMaxValue(String maxValue) {
        this.set(FIELD_MAXVALUE, maxValue);
    }

    @JsonIgnore
    public boolean isMaxValueDirty() {
        return this.contains(FIELD_MAXVALUE);
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
    public Integer getMinStrLength() {
        Object objValue = this.get(FIELD_MINSTRLENGTH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="minstrlength")
    public void setMinStrLength(Integer minStrLength) {
        this.set(FIELD_MINSTRLENGTH, minStrLength);
    }

    @JsonIgnore
    public boolean isMinStrLengthDirty() {
        return this.contains(FIELD_MINSTRLENGTH);
    }

    @JsonIgnore
    public String getMinValue() {
        Object objValue = this.get(FIELD_MINVALUE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="minvalue")
    public void setMinValue(String minValue) {
        this.set(FIELD_MINVALUE, minValue);
    }

    @JsonIgnore
    public boolean isMinValueDirty() {
        return this.contains(FIELD_MINVALUE);
    }

    @JsonIgnore
    public Integer getMultiFormField() {
        Object objValue = this.get(FIELD_MULTIFORMFIELD);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="multiformfield")
    public void setMultiFormField(Integer multiFormField) {
        this.set(FIELD_MULTIFORMFIELD, multiFormField);
    }

    @JsonIgnore
    public boolean isMultiFormFieldDirty() {
        return this.contains(FIELD_MULTIFORMFIELD);
    }

    @JsonIgnore
    public String getNo2DupChkPSDEFId() {
        Object objValue = this.get(FIELD_NO2DUPCHKPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no2dupchkpsdefid")
    public void setNo2DupChkPSDEFId(String no2DupChkPSDEFId) {
        this.set(FIELD_NO2DUPCHKPSDEFID, no2DupChkPSDEFId);
    }

    @JsonIgnore
    public boolean isNo2DupChkPSDEFIdDirty() {
        return this.contains(FIELD_NO2DUPCHKPSDEFID);
    }

    @JsonIgnore
    public String getNo2DupChkPSDEFName() {
        Object objValue = this.get(FIELD_NO2DUPCHKPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no2dupchkpsdefname")
    public void setNo2DupChkPSDEFName(String no2DupChkPSDEFName) {
        this.set(FIELD_NO2DUPCHKPSDEFNAME, no2DupChkPSDEFName);
    }

    @JsonIgnore
    public boolean isNo2DupChkPSDEFNameDirty() {
        return this.contains(FIELD_NO2DUPCHKPSDEFNAME);
    }

    @JsonIgnore
    public String getNo3DupChkPSDEFId() {
        Object objValue = this.get(FIELD_NO3DUPCHKPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no3dupchkpsdefid")
    public void setNo3DupChkPSDEFId(String no3DupChkPSDEFId) {
        this.set(FIELD_NO3DUPCHKPSDEFID, no3DupChkPSDEFId);
    }

    @JsonIgnore
    public boolean isNo3DupChkPSDEFIdDirty() {
        return this.contains(FIELD_NO3DUPCHKPSDEFID);
    }

    @JsonIgnore
    public String getNo3DupChkPSDEFName() {
        Object objValue = this.get(FIELD_NO3DUPCHKPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no3dupchkpsdefname")
    public void setNo3DupChkPSDEFName(String no3DupChkPSDEFName) {
        this.set(FIELD_NO3DUPCHKPSDEFNAME, no3DupChkPSDEFName);
    }

    @JsonIgnore
    public boolean isNo3DupChkPSDEFNameDirty() {
        return this.contains(FIELD_NO3DUPCHKPSDEFNAME);
    }

    @JsonIgnore
    public String getNullValOrder() {
        Object objValue = this.get(FIELD_NULLVALORDER);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="nullvalorder")
    public void setNullValOrder(String nullValOrder) {
        this.set(FIELD_NULLVALORDER, nullValOrder);
    }

    @JsonIgnore
    public boolean isNullValOrderDirty() {
        return this.contains(FIELD_NULLVALORDER);
    }

    @JsonIgnore
    public String getO2MPSDERId() {
        Object objValue = this.get(FIELD_O2MPSDERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="o2mpsderid")
    public void setO2MPSDERId(String o2MPSDERId) {
        this.set(FIELD_O2MPSDERID, o2MPSDERId);
    }

    @JsonIgnore
    public boolean isO2MPSDERIdDirty() {
        return this.contains(FIELD_O2MPSDERID);
    }

    @JsonIgnore
    public String getO2MPSDERName() {
        Object objValue = this.get(FIELD_O2MPSDERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="o2mpsdername")
    public void setO2MPSDERName(String o2MPSDERName) {
        this.set(FIELD_O2MPSDERNAME, o2MPSDERName);
    }

    @JsonIgnore
    public boolean isO2MPSDERNameDirty() {
        return this.contains(FIELD_O2MPSDERNAME);
    }

    @JsonIgnore
    public String getO2OPSDERId() {
        Object objValue = this.get(FIELD_O2OPSDERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="o2opsderid")
    public void setO2OPSDERId(String o2OPSDERId) {
        this.set(FIELD_O2OPSDERID, o2OPSDERId);
    }

    @JsonIgnore
    public boolean isO2OPSDERIdDirty() {
        return this.contains(FIELD_O2OPSDERID);
    }

    @JsonIgnore
    public String getO2OPSDERName() {
        Object objValue = this.get(FIELD_O2OPSDERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="o2opsdername")
    public void setO2OPSDERName(String o2OPSDERName) {
        this.set(FIELD_O2OPSDERNAME, o2OPSDERName);
    }

    @JsonIgnore
    public boolean isO2OPSDERNameDirty() {
        return this.contains(FIELD_O2OPSDERNAME);
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
    public Integer getPasteReset() {
        Object objValue = this.get(FIELD_PASTERESET);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="pastereset")
    public void setPasteReset(Integer pasteReset) {
        this.set(FIELD_PASTERESET, pasteReset);
    }

    @JsonIgnore
    public boolean isPasteResetDirty() {
        return this.contains(FIELD_PASTERESET);
    }

    @JsonIgnore
    public Integer getPhysicalField() {
        Object objValue = this.get(FIELD_PHYSICALFIELD);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="physicalfield")
    public void setPhysicalField(Integer physicalField) {
        this.set(FIELD_PHYSICALFIELD, physicalField);
    }

    @JsonIgnore
    public boolean isPhysicalFieldDirty() {
        return this.contains(FIELD_PHYSICALFIELD);
    }

    @JsonIgnore
    public Integer getPKey() {
        Object objValue = this.get(FIELD_PKEY);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="pkey")
    public void setPKey(Integer pKey) {
        this.set(FIELD_PKEY, pKey);
    }

    @JsonIgnore
    public boolean isPKeyDirty() {
        return this.contains(FIELD_PKEY);
    }

    @JsonIgnore
    public Integer getPrecision2() {
        Object objValue = this.get(FIELD_PRECISION2);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="precision2")
    public void setPrecision2(Integer precision2) {
        this.set(FIELD_PRECISION2, precision2);
    }

    @JsonIgnore
    public boolean isPrecision2Dirty() {
        return this.contains(FIELD_PRECISION2);
    }

    @JsonIgnore
    public String getPreDefineType() {
        Object objValue = this.get(FIELD_PREDEFINETYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="predefinetype")
    public void setPreDefineType(String preDefineType) {
        this.set(FIELD_PREDEFINETYPE, preDefineType);
    }

    @JsonIgnore
    public boolean isPreDefineTypeDirty() {
        return this.contains(FIELD_PREDEFINETYPE);
    }

    @JsonIgnore
    public String getPSCodeListId() {
        Object objValue = this.get(FIELD_PSCODELISTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pscodelistid")
    public void setPSCodeListId(String pSCodeListId) {
        this.set(FIELD_PSCODELISTID, pSCodeListId);
    }

    @JsonIgnore
    public boolean isPSCodeListIdDirty() {
        return this.contains(FIELD_PSCODELISTID);
    }

    @JsonIgnore
    public String getPSCodeListName() {
        Object objValue = this.get(FIELD_PSCODELISTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pscodelistname")
    public void setPSCodeListName(String pSCodeListName) {
        this.set(FIELD_PSCODELISTNAME, pSCodeListName);
    }

    @JsonIgnore
    public boolean isPSCodeListNameDirty() {
        return this.contains(FIELD_PSCODELISTNAME);
    }

    @JsonIgnore
    public String getPSDataTypeId() {
        Object objValue = this.get(FIELD_PSDATATYPEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdatatypeid")
    public void setPSDataTypeId(String pSDataTypeId) {
        this.set(FIELD_PSDATATYPEID, pSDataTypeId);
    }

    @JsonIgnore
    public boolean isPSDataTypeIdDirty() {
        return this.contains(FIELD_PSDATATYPEID);
    }

    @JsonIgnore
    public String getPSDataTypeName() {
        Object objValue = this.get(FIELD_PSDATATYPENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdatatypename")
    public void setPSDataTypeName(String pSDataTypeName) {
        this.set(FIELD_PSDATATYPENAME, pSDataTypeName);
    }

    @JsonIgnore
    public boolean isPSDataTypeNameDirty() {
        return this.contains(FIELD_PSDATATYPENAME);
    }

    @JsonIgnore
    public String getPSDEFieldId() {
        Object objValue = this.get(FIELD_PSDEFIELDID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefieldid")
    public void setPSDEFieldId(String pSDEFieldId) {
        this.set(FIELD_PSDEFIELDID, pSDEFieldId);
    }

    @JsonIgnore
    public boolean isPSDEFieldIdDirty() {
        return this.contains(FIELD_PSDEFIELDID);
    }

    @JsonIgnore
    public String getPSDEFieldName() {
        Object objValue = this.get(FIELD_PSDEFIELDNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefieldname")
    public void setPSDEFieldName(String pSDEFieldName) {
        this.set(FIELD_PSDEFIELDNAME, pSDEFieldName);
    }

    @JsonIgnore
    public boolean isPSDEFieldNameDirty() {
        return this.contains(FIELD_PSDEFIELDNAME);
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
    public String getPSDETableId() {
        Object objValue = this.get(FIELD_PSDETABLEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdetableid")
    public void setPSDETableId(String pSDETableId) {
        this.set(FIELD_PSDETABLEID, pSDETableId);
    }

    @JsonIgnore
    public boolean isPSDETableIdDirty() {
        return this.contains(FIELD_PSDETABLEID);
    }

    @JsonIgnore
    public String getPSSubSysSADEFieldId() {
        Object objValue = this.get(FIELD_PSSUBSYSSADEFIELDID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssubsyssadefieldid")
    public void setPSSubSysSADEFieldId(String pSSubSysSADEFieldId) {
        this.set(FIELD_PSSUBSYSSADEFIELDID, pSSubSysSADEFieldId);
    }

    @JsonIgnore
    public boolean isPSSubSysSADEFieldIdDirty() {
        return this.contains(FIELD_PSSUBSYSSADEFIELDID);
    }

    @JsonIgnore
    public String getPSSubSysSADEFieldName() {
        Object objValue = this.get(FIELD_PSSUBSYSSADEFIELDNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssubsyssadefieldname")
    public void setPSSubSysSADEFieldName(String pSSubSysSADEFieldName) {
        this.set(FIELD_PSSUBSYSSADEFIELDNAME, pSSubSysSADEFieldName);
    }

    @JsonIgnore
    public boolean isPSSubSysSADEFieldNameDirty() {
        return this.contains(FIELD_PSSUBSYSSADEFIELDNAME);
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
    public String getPSSysDBColumnId() {
        Object objValue = this.get(FIELD_PSSYSDBCOLUMNID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdbcolumnid")
    public void setPSSysDBColumnId(String pSSysDBColumnId) {
        this.set(FIELD_PSSYSDBCOLUMNID, pSSysDBColumnId);
    }

    @JsonIgnore
    public boolean isPSSysDBColumnIdDirty() {
        return this.contains(FIELD_PSSYSDBCOLUMNID);
    }

    @JsonIgnore
    public String getPSSysSampleValueId() {
        Object objValue = this.get(FIELD_PSSYSSAMPLEVALUEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssamplevalueid")
    public void setPSSysSampleValueId(String pSSysSampleValueId) {
        this.set(FIELD_PSSYSSAMPLEVALUEID, pSSysSampleValueId);
    }

    @JsonIgnore
    public boolean isPSSysSampleValueIdDirty() {
        return this.contains(FIELD_PSSYSSAMPLEVALUEID);
    }

    @JsonIgnore
    public String getPSSysSampleValueName() {
        Object objValue = this.get(FIELD_PSSYSSAMPLEVALUENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssamplevaluename")
    public void setPSSysSampleValueName(String pSSysSampleValueName) {
        this.set(FIELD_PSSYSSAMPLEVALUENAME, pSSysSampleValueName);
    }

    @JsonIgnore
    public boolean isPSSysSampleValueNameDirty() {
        return this.contains(FIELD_PSSYSSAMPLEVALUENAME);
    }

    @JsonIgnore
    public String getPSSysSequenceId() {
        Object objValue = this.get(FIELD_PSSYSSEQUENCEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssequenceid")
    public void setPSSysSequenceId(String pSSysSequenceId) {
        this.set(FIELD_PSSYSSEQUENCEID, pSSysSequenceId);
    }

    @JsonIgnore
    public boolean isPSSysSequenceIdDirty() {
        return this.contains(FIELD_PSSYSSEQUENCEID);
    }

    @JsonIgnore
    public String getPSSysSequenceName() {
        Object objValue = this.get(FIELD_PSSYSSEQUENCENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssequencename")
    public void setPSSysSequenceName(String pSSysSequenceName) {
        this.set(FIELD_PSSYSSEQUENCENAME, pSSysSequenceName);
    }

    @JsonIgnore
    public boolean isPSSysSequenceNameDirty() {
        return this.contains(FIELD_PSSYSSEQUENCENAME);
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
    public String getPSSysTranslatorId() {
        Object objValue = this.get(FIELD_PSSYSTRANSLATORID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystranslatorid")
    public void setPSSysTranslatorId(String pSSysTranslatorId) {
        this.set(FIELD_PSSYSTRANSLATORID, pSSysTranslatorId);
    }

    @JsonIgnore
    public boolean isPSSysTranslatorIdDirty() {
        return this.contains(FIELD_PSSYSTRANSLATORID);
    }

    @JsonIgnore
    public String getPSSysTranslatorName() {
        Object objValue = this.get(FIELD_PSSYSTRANSLATORNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystranslatorname")
    public void setPSSysTranslatorName(String pSSysTranslatorName) {
        this.set(FIELD_PSSYSTRANSLATORNAME, pSSysTranslatorName);
    }

    @JsonIgnore
    public boolean isPSSysTranslatorNameDirty() {
        return this.contains(FIELD_PSSYSTRANSLATORNAME);
    }

    @JsonIgnore
    public String getPSSysUnitId() {
        Object objValue = this.get(FIELD_PSSYSUNITID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysunitid")
    public void setPSSysUnitId(String pSSysUnitId) {
        this.set(FIELD_PSSYSUNITID, pSSysUnitId);
    }

    @JsonIgnore
    public boolean isPSSysUnitIdDirty() {
        return this.contains(FIELD_PSSYSUNITID);
    }

    @JsonIgnore
    public String getPSSysUnitName() {
        Object objValue = this.get(FIELD_PSSYSUNITNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysunitname")
    public void setPSSysUnitName(String pSSysUnitName) {
        this.set(FIELD_PSSYSUNITNAME, pSSysUnitName);
    }

    @JsonIgnore
    public boolean isPSSysUnitNameDirty() {
        return this.contains(FIELD_PSSYSUNITNAME);
    }

    @JsonIgnore
    public String getPSSysValueRuleId() {
        Object objValue = this.get(FIELD_PSSYSVALUERULEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysvalueruleid")
    public void setPSSysValueRuleId(String pSSysValueRuleId) {
        this.set(FIELD_PSSYSVALUERULEID, pSSysValueRuleId);
    }

    @JsonIgnore
    public boolean isPSSysValueRuleIdDirty() {
        return this.contains(FIELD_PSSYSVALUERULEID);
    }

    @JsonIgnore
    public String getPSSysValueRuleName() {
        Object objValue = this.get(FIELD_PSSYSVALUERULENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysvaluerulename")
    public void setPSSysValueRuleName(String pSSysValueRuleName) {
        this.set(FIELD_PSSYSVALUERULENAME, pSSysValueRuleName);
    }

    @JsonIgnore
    public boolean isPSSysValueRuleNameDirty() {
        return this.contains(FIELD_PSSYSVALUERULENAME);
    }

    @JsonIgnore
    public Integer getQueryColumn() {
        Object objValue = this.get(FIELD_QUERYCOLUMN);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="querycolumn")
    public void setQueryColumn(Integer queryColumn) {
        this.set(FIELD_QUERYCOLUMN, queryColumn);
    }

    @JsonIgnore
    public boolean isQueryColumnDirty() {
        return this.contains(FIELD_QUERYCOLUMN);
    }

    @JsonIgnore
    public String getQueryCS() {
        Object objValue = this.get(FIELD_QUERYCS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="querycs")
    public void setQueryCS(String queryCS) {
        this.set(FIELD_QUERYCS, queryCS);
    }

    @JsonIgnore
    public boolean isQueryCSDirty() {
        return this.contains(FIELD_QUERYCS);
    }

    @JsonIgnore
    public Integer getReadOnlyMode() {
        Object objValue = this.get(FIELD_READONLYMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="readonlymode")
    public void setReadOnlyMode(Integer readOnlyMode) {
        this.set(FIELD_READONLYMODE, readOnlyMode);
    }

    @JsonIgnore
    public boolean isReadOnlyModeDirty() {
        return this.contains(FIELD_READONLYMODE);
    }

    @JsonIgnore
    public String getRefPSSysDynaModelId() {
        Object objValue = this.get(FIELD_REFPSSYSDYNAMODELID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpssysdynamodelid")
    public void setRefPSSysDynaModelId(String refPSSysDynaModelId) {
        this.set(FIELD_REFPSSYSDYNAMODELID, refPSSysDynaModelId);
    }

    @JsonIgnore
    public boolean isRefPSSysDynaModelIdDirty() {
        return this.contains(FIELD_REFPSSYSDYNAMODELID);
    }

    @JsonIgnore
    public String getRefPSSysDynaModelName() {
        Object objValue = this.get(FIELD_REFPSSYSDYNAMODELNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpssysdynamodelname")
    public void setRefPSSysDynaModelName(String refPSSysDynaModelName) {
        this.set(FIELD_REFPSSYSDYNAMODELNAME, refPSSysDynaModelName);
    }

    @JsonIgnore
    public boolean isRefPSSysDynaModelNameDirty() {
        return this.contains(FIELD_REFPSSYSDYNAMODELNAME);
    }

    @JsonIgnore
    public String getRestrictedPSDEFId() {
        Object objValue = this.get(FIELD_RESTRICTEDPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="restrictedpsdefid")
    public void setRestrictedPSDEFId(String restrictedPSDEFId) {
        this.set(FIELD_RESTRICTEDPSDEFID, restrictedPSDEFId);
    }

    @JsonIgnore
    public boolean isRestrictedPSDEFIdDirty() {
        return this.contains(FIELD_RESTRICTEDPSDEFID);
    }

    @JsonIgnore
    public String getRestrictedPSDEFName() {
        Object objValue = this.get(FIELD_RESTRICTEDPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="restrictedpsdefname")
    public void setRestrictedPSDEFName(String restrictedPSDEFName) {
        this.set(FIELD_RESTRICTEDPSDEFNAME, restrictedPSDEFName);
    }

    @JsonIgnore
    public boolean isRestrictedPSDEFNameDirty() {
        return this.contains(FIELD_RESTRICTEDPSDEFNAME);
    }

    @JsonIgnore
    public String getSequenceMode() {
        Object objValue = this.get(FIELD_SEQUENCEMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="sequencemode")
    public void setSequenceMode(String sequenceMode) {
        this.set(FIELD_SEQUENCEMODE, sequenceMode);
    }

    @JsonIgnore
    public boolean isSequenceModeDirty() {
        return this.contains(FIELD_SEQUENCEMODE);
    }

    @JsonIgnore
    public String getServiceCodeName() {
        Object objValue = this.get(FIELD_SERVICECODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="servicecodename")
    public void setServiceCodeName(String serviceCodeName) {
        this.set(FIELD_SERVICECODENAME, serviceCodeName);
    }

    @JsonIgnore
    public boolean isServiceCodeNameDirty() {
        return this.contains(FIELD_SERVICECODENAME);
    }

    @JsonIgnore
    public String getStateField() {
        Object objValue = this.get(FIELD_STATEFIELD);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="statefield")
    public void setStateField(String stateField) {
        this.set(FIELD_STATEFIELD, stateField);
    }

    @JsonIgnore
    public boolean isStateFieldDirty() {
        return this.contains(FIELD_STATEFIELD);
    }

    @JsonIgnore
    public Integer getStdDataType() {
        Object objValue = this.get(FIELD_STDDATATYPE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="stddatatype")
    public void setStdDataType(Integer stdDataType) {
        this.set(FIELD_STDDATATYPE, stdDataType);
    }

    @JsonIgnore
    public boolean isStdDataTypeDirty() {
        return this.contains(FIELD_STDDATATYPE);
    }

    @JsonIgnore
    public String getStringCase() {
        Object objValue = this.get(FIELD_STRINGCASE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="stringcase")
    public void setStringCase(String stringCase) {
        this.set(FIELD_STRINGCASE, stringCase);
    }

    @JsonIgnore
    public boolean isStringCaseDirty() {
        return this.contains(FIELD_STRINGCASE);
    }

    @JsonIgnore
    public Integer getStrLength() {
        Object objValue = this.get(FIELD_STRLENGTH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="strlength")
    public void setStrLength(Integer strLength) {
        this.set(FIELD_STRLENGTH, strLength);
    }

    @JsonIgnore
    public boolean isStrLengthDirty() {
        return this.contains(FIELD_STRLENGTH);
    }

    @JsonIgnore
    public String getTableName() {
        Object objValue = this.get(FIELD_TABLENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="tablename")
    public void setTableName(String tableName) {
        this.set(FIELD_TABLENAME, tableName);
    }

    @JsonIgnore
    public boolean isTableNameDirty() {
        return this.contains(FIELD_TABLENAME);
    }

    @JsonIgnore
    public String getTableScope() {
        Object objValue = this.get(FIELD_TABLESCOPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="tablescope")
    public void setTableScope(String tableScope) {
        this.set(FIELD_TABLESCOPE, tableScope);
    }

    @JsonIgnore
    public boolean isTableScopeDirty() {
        return this.contains(FIELD_TABLESCOPE);
    }

    @JsonIgnore
    public String getTestData() {
        Object objValue = this.get(FIELD_TESTDATA);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="testdata")
    public void setTestData(String testData) {
        this.set(FIELD_TESTDATA, testData);
    }

    @JsonIgnore
    public boolean isTestDataDirty() {
        return this.contains(FIELD_TESTDATA);
    }

    @JsonIgnore
    public String getTranslatorMode() {
        Object objValue = this.get(FIELD_TRANSLATORMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="translatormode")
    public void setTranslatorMode(String translatorMode) {
        this.set(FIELD_TRANSLATORMODE, translatorMode);
    }

    @JsonIgnore
    public boolean isTranslatorModeDirty() {
        return this.contains(FIELD_TRANSLATORMODE);
    }

    @JsonIgnore
    public Integer getUnicodeChar() {
        Object objValue = this.get(FIELD_UNICODECHAR);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="unicodechar")
    public void setUnicodeChar(Integer unicodeChar) {
        this.set(FIELD_UNICODECHAR, unicodeChar);
    }

    @JsonIgnore
    public boolean isUnicodeCharDirty() {
        return this.contains(FIELD_UNICODECHAR);
    }

    @JsonIgnore
    public String getUnionKeyValue() {
        Object objValue = this.get(FIELD_UNIONKEYVALUE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="unionkeyvalue")
    public void setUnionKeyValue(String unionKeyValue) {
        this.set(FIELD_UNIONKEYVALUE, unionKeyValue);
    }

    @JsonIgnore
    public boolean isUnionKeyValueDirty() {
        return this.contains(FIELD_UNIONKEYVALUE);
    }

    @JsonIgnore
    public String getUnit() {
        Object objValue = this.get(FIELD_UNIT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="unit")
    public void setUnit(String unit) {
        this.set(FIELD_UNIT, unit);
    }

    @JsonIgnore
    public boolean isUnitDirty() {
        return this.contains(FIELD_UNIT);
    }

    @JsonIgnore
    public Integer getUnitWidth() {
        Object objValue = this.get(FIELD_UNITWIDTH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="unitwidth")
    public void setUnitWidth(Integer unitWidth) {
        this.set(FIELD_UNITWIDTH, unitWidth);
    }

    @JsonIgnore
    public boolean isUnitWidthDirty() {
        return this.contains(FIELD_UNITWIDTH);
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
    public String getUpdateOVMode() {
        Object objValue = this.get(FIELD_UPDATEOVMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="updateovmode")
    public void setUpdateOVMode(String updateOVMode) {
        this.set(FIELD_UPDATEOVMODE, updateOVMode);
    }

    @JsonIgnore
    public boolean isUpdateOVModeDirty() {
        return this.contains(FIELD_UPDATEOVMODE);
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

    @JsonIgnore
    public String getValueFormat() {
        Object objValue = this.get(FIELD_VALUEFORMAT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="valueformat")
    public void setValueFormat(String valueFormat) {
        this.set(FIELD_VALUEFORMAT, valueFormat);
    }

    @JsonIgnore
    public boolean isValueFormatDirty() {
        return this.contains(FIELD_VALUEFORMAT);
    }

    @JsonIgnore
    public String getValuePSDEFId() {
        Object objValue = this.get(FIELD_VALUEPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="valuepsdefid")
    public void setValuePSDEFId(String valuePSDEFId) {
        this.set(FIELD_VALUEPSDEFID, valuePSDEFId);
    }

    @JsonIgnore
    public boolean isValuePSDEFIdDirty() {
        return this.contains(FIELD_VALUEPSDEFID);
    }

    @JsonIgnore
    public String getValuePSDEFName() {
        Object objValue = this.get(FIELD_VALUEPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="valuepsdefname")
    public void setValuePSDEFName(String valuePSDEFName) {
        this.set(FIELD_VALUEPSDEFNAME, valuePSDEFName);
    }

    @JsonIgnore
    public boolean isValuePSDEFNameDirty() {
        return this.contains(FIELD_VALUEPSDEFNAME);
    }

    @JsonIgnore
    public Integer getViewColLevel() {
        Object objValue = this.get(FIELD_VIEWCOLLEVEL);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="viewcollevel")
    public void setViewColLevel(Integer viewColLevel) {
        this.set(FIELD_VIEWCOLLEVEL, viewColLevel);
    }

    @JsonIgnore
    public boolean isViewColLevelDirty() {
        return this.contains(FIELD_VIEWCOLLEVEL);
    }

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDEFieldId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSDEFieldId(strValue);
    }
}

