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

public class PSDELNParam
extends PSModelBase {
    public static final String FIELD_AGGMODE = "aggmode";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CUSTOMDSTPARAM = "customdstparam";
    public static final String FIELD_CUSTOMSRCPARAM = "customsrcparam";
    public static final String FIELD_DIRECTCODE = "directcode";
    public static final String FIELD_DSTINDEX = "dstindex";
    public static final String FIELD_DSTPARAMPSDEID = "dstparampsdeid";
    public static final String FIELD_DSTPSDEFID = "dstpsdefid";
    public static final String FIELD_DSTPSDEFNAME = "dstpsdefname";
    public static final String FIELD_DSTPSDLPARAMID = "dstpsdlparamid";
    public static final String FIELD_DSTPSDLPARAMNAME = "dstpsdlparamname";
    public static final String FIELD_DSTSORTDIR = "dstsortdir";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_INOUTFLAG = "inoutflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PARAMTAG = "paramtag";
    public static final String FIELD_PARAMTAG2 = "paramtag2";
    public static final String FIELD_PARAMTYPE = "paramtype";
    public static final String FIELD_PARAMTYPETEXT = "paramtypetext";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDELNPARAMID = "psdelnparamid";
    public static final String FIELD_PSDELNPARAMNAME = "psdelnparamname";
    public static final String FIELD_PSDELOGICNODEID = "psdelogicnodeid";
    public static final String FIELD_PSDELOGICNODENAME = "psdelogicnodename";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSOBJDATA = "psobjdata";
    public static final String FIELD_PSOBJDATA2 = "psobjdata2";
    public static final String FIELD_PSOBJID = "psobjid";
    public static final String FIELD_PSOBJNAME = "psobjname";
    public static final String FIELD_PSOBJTYPE = "psobjtype";
    public static final String FIELD_PSOBJTYPENAME = "psobjtypename";
    public static final String FIELD_PSSYSSEQUENCEID = "pssyssequenceid";
    public static final String FIELD_PSSYSSEQUENCENAME = "pssyssequencename";
    public static final String FIELD_PSSYSTRANSLATORID = "pssystranslatorid";
    public static final String FIELD_PSSYSTRANSLATORNAME = "pssystranslatorname";
    public static final String FIELD_SRCINDEX = "srcindex";
    public static final String FIELD_SRCPARAMPSDEID = "srcparampsdeid";
    public static final String FIELD_SRCPSDEFID = "srcpsdefid";
    public static final String FIELD_SRCPSDEFNAME = "srcpsdefname";
    public static final String FIELD_SRCPSDLPARAMID = "srcpsdlparamid";
    public static final String FIELD_SRCPSDLPARAMNAME = "srcpsdlparamname";
    public static final String FIELD_SRCSIZE = "srcsize";
    public static final String FIELD_SRCVALUE = "srcvalue";
    public static final String FIELD_SRCVALUESTDDATATYPE = "srcvaluestddatatype";
    public static final String FIELD_SRCVALUETYPE = "srcvaluetype";
    public static final String FIELD_SRCVALUETYPETEXT = "srcvaluetypetext";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";

    @JsonIgnore
    public String getAggMode() {
        Object objValue = this.get(FIELD_AGGMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="aggmode")
    public void setAggMode(String aggMode) {
        this.set(FIELD_AGGMODE, aggMode);
    }

    @JsonIgnore
    public boolean isAggModeDirty() {
        return this.contains(FIELD_AGGMODE);
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
    public String getCustomDstParam() {
        Object objValue = this.get(FIELD_CUSTOMDSTPARAM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="customdstparam")
    public void setCustomDstParam(String customDstParam) {
        this.set(FIELD_CUSTOMDSTPARAM, customDstParam);
    }

    @JsonIgnore
    public boolean isCustomDstParamDirty() {
        return this.contains(FIELD_CUSTOMDSTPARAM);
    }

    @JsonIgnore
    public String getCustomSrcParam() {
        Object objValue = this.get(FIELD_CUSTOMSRCPARAM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="customsrcparam")
    public void setCustomSrcParam(String customSrcParam) {
        this.set(FIELD_CUSTOMSRCPARAM, customSrcParam);
    }

    @JsonIgnore
    public boolean isCustomSrcParamDirty() {
        return this.contains(FIELD_CUSTOMSRCPARAM);
    }

    @JsonIgnore
    public String getDirectCode() {
        Object objValue = this.get(FIELD_DIRECTCODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="directcode")
    public void setDirectCode(String directCode) {
        this.set(FIELD_DIRECTCODE, directCode);
    }

    @JsonIgnore
    public boolean isDirectCodeDirty() {
        return this.contains(FIELD_DIRECTCODE);
    }

    @JsonIgnore
    public Integer getDstIndex() {
        Object objValue = this.get(FIELD_DSTINDEX);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="dstindex")
    public void setDstIndex(Integer dstIndex) {
        this.set(FIELD_DSTINDEX, dstIndex);
    }

    @JsonIgnore
    public boolean isDstIndexDirty() {
        return this.contains(FIELD_DSTINDEX);
    }

    @JsonIgnore
    public String getDstParamPSDEId() {
        Object objValue = this.get(FIELD_DSTPARAMPSDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstparampsdeid")
    public void setDstParamPSDEId(String dstParamPSDEId) {
        this.set(FIELD_DSTPARAMPSDEID, dstParamPSDEId);
    }

    @JsonIgnore
    public boolean isDstParamPSDEIdDirty() {
        return this.contains(FIELD_DSTPARAMPSDEID);
    }

    @JsonIgnore
    public String getDstPSDEFId() {
        Object objValue = this.get(FIELD_DSTPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdefid")
    public void setDstPSDEFId(String dstPSDEFId) {
        this.set(FIELD_DSTPSDEFID, dstPSDEFId);
    }

    @JsonIgnore
    public boolean isDstPSDEFIdDirty() {
        return this.contains(FIELD_DSTPSDEFID);
    }

    @JsonIgnore
    public String getDstPSDEFName() {
        Object objValue = this.get(FIELD_DSTPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdefname")
    public void setDstPSDEFName(String dstPSDEFName) {
        this.set(FIELD_DSTPSDEFNAME, dstPSDEFName);
    }

    @JsonIgnore
    public boolean isDstPSDEFNameDirty() {
        return this.contains(FIELD_DSTPSDEFNAME);
    }

    @JsonIgnore
    public String getDstPSDLParamId() {
        Object objValue = this.get(FIELD_DSTPSDLPARAMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdlparamid")
    public void setDstPSDLParamId(String dstPSDLParamId) {
        this.set(FIELD_DSTPSDLPARAMID, dstPSDLParamId);
    }

    @JsonIgnore
    public boolean isDstPSDLParamIdDirty() {
        return this.contains(FIELD_DSTPSDLPARAMID);
    }

    @JsonIgnore
    public String getDstPSDLParamName() {
        Object objValue = this.get(FIELD_DSTPSDLPARAMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdlparamname")
    public void setDstPSDLParamName(String dstPSDLParamName) {
        this.set(FIELD_DSTPSDLPARAMNAME, dstPSDLParamName);
    }

    @JsonIgnore
    public boolean isDstPSDLParamNameDirty() {
        return this.contains(FIELD_DSTPSDLPARAMNAME);
    }

    @JsonIgnore
    public String getDstSortDir() {
        Object objValue = this.get(FIELD_DSTSORTDIR);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstsortdir")
    public void setDstSortDir(String dstSortDir) {
        this.set(FIELD_DSTSORTDIR, dstSortDir);
    }

    @JsonIgnore
    public boolean isDstSortDirDirty() {
        return this.contains(FIELD_DSTSORTDIR);
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
    public Integer getInOutFlag() {
        Object objValue = this.get(FIELD_INOUTFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="inoutflag")
    public void setInOutFlag(Integer inOutFlag) {
        this.set(FIELD_INOUTFLAG, inOutFlag);
    }

    @JsonIgnore
    public boolean isInOutFlagDirty() {
        return this.contains(FIELD_INOUTFLAG);
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
    public String getParamTag() {
        Object objValue = this.get(FIELD_PARAMTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="paramtag")
    public void setParamTag(String paramTag) {
        this.set(FIELD_PARAMTAG, paramTag);
    }

    @JsonIgnore
    public boolean isParamTagDirty() {
        return this.contains(FIELD_PARAMTAG);
    }

    @JsonIgnore
    public String getParamTag2() {
        Object objValue = this.get(FIELD_PARAMTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="paramtag2")
    public void setParamTag2(String paramTag2) {
        this.set(FIELD_PARAMTAG2, paramTag2);
    }

    @JsonIgnore
    public boolean isParamTag2Dirty() {
        return this.contains(FIELD_PARAMTAG2);
    }

    @JsonIgnore
    public String getParamType() {
        Object objValue = this.get(FIELD_PARAMTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="paramtype")
    public void setParamType(String paramType) {
        this.set(FIELD_PARAMTYPE, paramType);
    }

    @JsonIgnore
    public boolean isParamTypeDirty() {
        return this.contains(FIELD_PARAMTYPE);
    }

    @JsonIgnore
    public String getParamTypeText() {
        Object objValue = this.get(FIELD_PARAMTYPETEXT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="paramtypetext")
    public void setParamTypeText(String paramTypeText) {
        this.set(FIELD_PARAMTYPETEXT, paramTypeText);
    }

    @JsonIgnore
    public boolean isParamTypeTextDirty() {
        return this.contains(FIELD_PARAMTYPETEXT);
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
    public String getPSDELNParamId() {
        Object objValue = this.get(FIELD_PSDELNPARAMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdelnparamid")
    public void setPSDELNParamId(String pSDELNParamId) {
        this.set(FIELD_PSDELNPARAMID, pSDELNParamId);
    }

    @JsonIgnore
    public boolean isPSDELNParamIdDirty() {
        return this.contains(FIELD_PSDELNPARAMID);
    }

    @JsonIgnore
    public String getPSDELNParamName() {
        Object objValue = this.get(FIELD_PSDELNPARAMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdelnparamname")
    public void setPSDELNParamName(String pSDELNParamName) {
        this.set(FIELD_PSDELNPARAMNAME, pSDELNParamName);
    }

    @JsonIgnore
    public boolean isPSDELNParamNameDirty() {
        return this.contains(FIELD_PSDELNPARAMNAME);
    }

    @JsonIgnore
    public String getPSDELogicNodeId() {
        Object objValue = this.get(FIELD_PSDELOGICNODEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdelogicnodeid")
    public void setPSDELogicNodeId(String pSDELogicNodeId) {
        this.set(FIELD_PSDELOGICNODEID, pSDELogicNodeId);
    }

    @JsonIgnore
    public boolean isPSDELogicNodeIdDirty() {
        return this.contains(FIELD_PSDELOGICNODEID);
    }

    @JsonIgnore
    public String getPSDELogicNodeName() {
        Object objValue = this.get(FIELD_PSDELOGICNODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdelogicnodename")
    public void setPSDELogicNodeName(String pSDELogicNodeName) {
        this.set(FIELD_PSDELOGICNODENAME, pSDELogicNodeName);
    }

    @JsonIgnore
    public boolean isPSDELogicNodeNameDirty() {
        return this.contains(FIELD_PSDELOGICNODENAME);
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
    public String getPSObjData() {
        Object objValue = this.get(FIELD_PSOBJDATA);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psobjdata")
    public void setPSObjData(String pSObjData) {
        this.set(FIELD_PSOBJDATA, pSObjData);
    }

    @JsonIgnore
    public boolean isPSObjDataDirty() {
        return this.contains(FIELD_PSOBJDATA);
    }

    @JsonIgnore
    public String getPSObjData2() {
        Object objValue = this.get(FIELD_PSOBJDATA2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psobjdata2")
    public void setPSObjData2(String pSObjData2) {
        this.set(FIELD_PSOBJDATA2, pSObjData2);
    }

    @JsonIgnore
    public boolean isPSObjData2Dirty() {
        return this.contains(FIELD_PSOBJDATA2);
    }

    @JsonIgnore
    public String getPSObjId() {
        Object objValue = this.get(FIELD_PSOBJID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psobjid")
    public void setPSObjId(String pSObjId) {
        this.set(FIELD_PSOBJID, pSObjId);
    }

    @JsonIgnore
    public boolean isPSObjIdDirty() {
        return this.contains(FIELD_PSOBJID);
    }

    @JsonIgnore
    public String getPSObjName() {
        Object objValue = this.get(FIELD_PSOBJNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psobjname")
    public void setPSObjName(String pSObjName) {
        this.set(FIELD_PSOBJNAME, pSObjName);
    }

    @JsonIgnore
    public boolean isPSObjNameDirty() {
        return this.contains(FIELD_PSOBJNAME);
    }

    @JsonIgnore
    public String getPSObjType() {
        Object objValue = this.get(FIELD_PSOBJTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psobjtype")
    public void setPSObjType(String pSObjType) {
        this.set(FIELD_PSOBJTYPE, pSObjType);
    }

    @JsonIgnore
    public boolean isPSObjTypeDirty() {
        return this.contains(FIELD_PSOBJTYPE);
    }

    @JsonIgnore
    public String getPSObjTypeName() {
        Object objValue = this.get(FIELD_PSOBJTYPENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psobjtypename")
    public void setPSObjTypeName(String pSObjTypeName) {
        this.set(FIELD_PSOBJTYPENAME, pSObjTypeName);
    }

    @JsonIgnore
    public boolean isPSObjTypeNameDirty() {
        return this.contains(FIELD_PSOBJTYPENAME);
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
    public Integer getSrcIndex() {
        Object objValue = this.get(FIELD_SRCINDEX);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="srcindex")
    public void setSrcIndex(Integer srcIndex) {
        this.set(FIELD_SRCINDEX, srcIndex);
    }

    @JsonIgnore
    public boolean isSrcIndexDirty() {
        return this.contains(FIELD_SRCINDEX);
    }

    @JsonIgnore
    public String getSrcParamPSDEId() {
        Object objValue = this.get(FIELD_SRCPARAMPSDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="srcparampsdeid")
    public void setSrcParamPSDEId(String srcParamPSDEId) {
        this.set(FIELD_SRCPARAMPSDEID, srcParamPSDEId);
    }

    @JsonIgnore
    public boolean isSrcParamPSDEIdDirty() {
        return this.contains(FIELD_SRCPARAMPSDEID);
    }

    @JsonIgnore
    public String getSrcPSDEFId() {
        Object objValue = this.get(FIELD_SRCPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="srcpsdefid")
    public void setSrcPSDEFId(String srcPSDEFId) {
        this.set(FIELD_SRCPSDEFID, srcPSDEFId);
    }

    @JsonIgnore
    public boolean isSrcPSDEFIdDirty() {
        return this.contains(FIELD_SRCPSDEFID);
    }

    @JsonIgnore
    public String getSrcPSDEFName() {
        Object objValue = this.get(FIELD_SRCPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="srcpsdefname")
    public void setSrcPSDEFName(String srcPSDEFName) {
        this.set(FIELD_SRCPSDEFNAME, srcPSDEFName);
    }

    @JsonIgnore
    public boolean isSrcPSDEFNameDirty() {
        return this.contains(FIELD_SRCPSDEFNAME);
    }

    @JsonIgnore
    public String getSrcPSDLParamId() {
        Object objValue = this.get(FIELD_SRCPSDLPARAMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="srcpsdlparamid")
    public void setSrcPSDLParamId(String srcPSDLParamId) {
        this.set(FIELD_SRCPSDLPARAMID, srcPSDLParamId);
    }

    @JsonIgnore
    public boolean isSrcPSDLParamIdDirty() {
        return this.contains(FIELD_SRCPSDLPARAMID);
    }

    @JsonIgnore
    public String getSrcPSDLParamName() {
        Object objValue = this.get(FIELD_SRCPSDLPARAMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="srcpsdlparamname")
    public void setSrcPSDLParamName(String srcPSDLParamName) {
        this.set(FIELD_SRCPSDLPARAMNAME, srcPSDLParamName);
    }

    @JsonIgnore
    public boolean isSrcPSDLParamNameDirty() {
        return this.contains(FIELD_SRCPSDLPARAMNAME);
    }

    @JsonIgnore
    public Integer getSrcSize() {
        Object objValue = this.get(FIELD_SRCSIZE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="srcsize")
    public void setSrcSize(Integer srcSize) {
        this.set(FIELD_SRCSIZE, srcSize);
    }

    @JsonIgnore
    public boolean isSrcSizeDirty() {
        return this.contains(FIELD_SRCSIZE);
    }

    @JsonIgnore
    public String getSrcValue() {
        Object objValue = this.get(FIELD_SRCVALUE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="srcvalue")
    public void setSrcValue(String srcValue) {
        this.set(FIELD_SRCVALUE, srcValue);
    }

    @JsonIgnore
    public boolean isSrcValueDirty() {
        return this.contains(FIELD_SRCVALUE);
    }

    @JsonIgnore
    public Integer getSrcValueStdDataType() {
        Object objValue = this.get(FIELD_SRCVALUESTDDATATYPE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="srcvaluestddatatype")
    public void setSrcValueStdDataType(Integer srcValueStdDataType) {
        this.set(FIELD_SRCVALUESTDDATATYPE, srcValueStdDataType);
    }

    @JsonIgnore
    public boolean isSrcValueStdDataTypeDirty() {
        return this.contains(FIELD_SRCVALUESTDDATATYPE);
    }

    @JsonIgnore
    public String getSrcValueType() {
        Object objValue = this.get(FIELD_SRCVALUETYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="srcvaluetype")
    public void setSrcValueType(String srcValueType) {
        this.set(FIELD_SRCVALUETYPE, srcValueType);
    }

    @JsonIgnore
    public boolean isSrcValueTypeDirty() {
        return this.contains(FIELD_SRCVALUETYPE);
    }

    @JsonIgnore
    public String getSrcValueTypeText() {
        Object objValue = this.get(FIELD_SRCVALUETYPETEXT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="srcvaluetypetext")
    public void setSrcValueTypeText(String srcValueTypeText) {
        this.set(FIELD_SRCVALUETYPETEXT, srcValueTypeText);
    }

    @JsonIgnore
    public boolean isSrcValueTypeTextDirty() {
        return this.contains(FIELD_SRCVALUETYPETEXT);
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
    public String getSrfkey() {
        return this.getPSDELNParamId();
    }

    public void setSrfkey(String strValue) {
        this.setPSDELNParamId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSDELNPARAM";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSDELNParam item = (PSDELNParam)MAPPER.readValue(new File(strJsonFilePath), PSDELNParam.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSDELNParam) {
            PSDELNParam pSDELNParam = (PSDELNParam)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSDELNParam) {
            PSDELNParam pSDELNParam = (PSDELNParam)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

