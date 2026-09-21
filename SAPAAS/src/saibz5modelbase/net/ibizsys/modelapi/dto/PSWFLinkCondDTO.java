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
import net.ibizsys.modelapi.util.PSModelDTOBase;

public class PSWFLinkCondDTO
extends PSModelDTOBase {
    public static final String FIELD_CONDVALUE = "condvalue";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CUSTOMDSTPARAM = "customdstparam";
    public static final String FIELD_DSTPSDEFID = "dstpsdefid";
    public static final String FIELD_DSTPSDEFNAME = "dstpsdefname";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_GROUPNOTFLAG = "groupnotflag";
    public static final String FIELD_GROUPOP = "groupop";
    public static final String FIELD_LOGICTYPE = "logictype";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PARAMTYPE = "paramtype";
    public static final String FIELD_PPSWFLINKCONDID = "ppswflinkcondid";
    public static final String FIELD_PPSWFLINKCONDNAME = "ppswflinkcondname";
    public static final String FIELD_PSDBVALUEOPID = "psdbvalueopid";
    public static final String FIELD_PSDBVALUEOPNAME = "psdbvalueopname";
    public static final String FIELD_PSWFLINKCONDID = "pswflinkcondid";
    public static final String FIELD_PSWFLINKCONDNAME = "pswflinkcondname";
    public static final String FIELD_PSWFLINKID = "pswflinkid";
    public static final String FIELD_PSWFLINKNAME = "pswflinkname";
    public static final String FIELD_PSWFVERSIONID = "pswfversionid";
    public static final String FIELD_PSWFVERSIONNAME = "pswfversionname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    private List<PSWFLinkCondDTO> pswflinkconds;

    @JsonIgnore
    public String getCondValue() {
        Object objValue = this.get(FIELD_CONDVALUE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="condvalue")
    public void setCondValue(String condValue) {
        this.set(FIELD_CONDVALUE, condValue);
    }

    @JsonIgnore
    public boolean isCondValueDirty() {
        return this.contains(FIELD_CONDVALUE);
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
    public String getCustomDSTParam() {
        Object objValue = this.get(FIELD_CUSTOMDSTPARAM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="customdstparam")
    public void setCustomDSTParam(String customDSTParam) {
        this.set(FIELD_CUSTOMDSTPARAM, customDSTParam);
    }

    @JsonIgnore
    public boolean isCustomDSTParamDirty() {
        return this.contains(FIELD_CUSTOMDSTPARAM);
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
    public Integer getGroupNotFlag() {
        Object objValue = this.get(FIELD_GROUPNOTFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="groupnotflag")
    public void setGroupNotFlag(Integer groupNotFlag) {
        this.set(FIELD_GROUPNOTFLAG, groupNotFlag);
    }

    @JsonIgnore
    public boolean isGroupNotFlagDirty() {
        return this.contains(FIELD_GROUPNOTFLAG);
    }

    @JsonIgnore
    public String getGroupOP() {
        Object objValue = this.get(FIELD_GROUPOP);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="groupop")
    public void setGroupOP(String groupOP) {
        this.set(FIELD_GROUPOP, groupOP);
    }

    @JsonIgnore
    public boolean isGroupOPDirty() {
        return this.contains(FIELD_GROUPOP);
    }

    @JsonIgnore
    public String getLogicType() {
        Object objValue = this.get(FIELD_LOGICTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="logictype")
    public void setLogicType(String logicType) {
        this.set(FIELD_LOGICTYPE, logicType);
    }

    @JsonIgnore
    public boolean isLogicTypeDirty() {
        return this.contains(FIELD_LOGICTYPE);
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
    public String getPPSWFLinkCondId() {
        Object objValue = this.get(FIELD_PPSWFLINKCONDID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppswflinkcondid")
    public void setPPSWFLinkCondId(String pPSWFLinkCondId) {
        this.set(FIELD_PPSWFLINKCONDID, pPSWFLinkCondId);
    }

    @JsonIgnore
    public boolean isPPSWFLinkCondIdDirty() {
        return this.contains(FIELD_PPSWFLINKCONDID);
    }

    @JsonIgnore
    public String getPPSWFLinkCondName() {
        Object objValue = this.get(FIELD_PPSWFLINKCONDNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppswflinkcondname")
    public void setPPSWFLinkCondName(String pPSWFLinkCondName) {
        this.set(FIELD_PPSWFLINKCONDNAME, pPSWFLinkCondName);
    }

    @JsonIgnore
    public boolean isPPSWFLinkCondNameDirty() {
        return this.contains(FIELD_PPSWFLINKCONDNAME);
    }

    @JsonIgnore
    public String getPSDBValueOPId() {
        Object objValue = this.get(FIELD_PSDBVALUEOPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdbvalueopid")
    public void setPSDBValueOPId(String pSDBValueOPId) {
        this.set(FIELD_PSDBVALUEOPID, pSDBValueOPId);
    }

    @JsonIgnore
    public boolean isPSDBValueOPIdDirty() {
        return this.contains(FIELD_PSDBVALUEOPID);
    }

    @JsonIgnore
    public String getPSDBValueOPName() {
        Object objValue = this.get(FIELD_PSDBVALUEOPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdbvalueopname")
    public void setPSDBValueOPName(String pSDBValueOPName) {
        this.set(FIELD_PSDBVALUEOPNAME, pSDBValueOPName);
    }

    @JsonIgnore
    public boolean isPSDBValueOPNameDirty() {
        return this.contains(FIELD_PSDBVALUEOPNAME);
    }

    @JsonIgnore
    public String getPSWFLinkCondId() {
        Object objValue = this.get(FIELD_PSWFLINKCONDID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswflinkcondid")
    public void setPSWFLinkCondId(String pSWFLinkCondId) {
        this.set(FIELD_PSWFLINKCONDID, pSWFLinkCondId);
    }

    @JsonIgnore
    public boolean isPSWFLinkCondIdDirty() {
        return this.contains(FIELD_PSWFLINKCONDID);
    }

    @JsonIgnore
    public String getPSWFLinkCondName() {
        Object objValue = this.get(FIELD_PSWFLINKCONDNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswflinkcondname")
    public void setPSWFLinkCondName(String pSWFLinkCondName) {
        this.set(FIELD_PSWFLINKCONDNAME, pSWFLinkCondName);
    }

    @JsonIgnore
    public boolean isPSWFLinkCondNameDirty() {
        return this.contains(FIELD_PSWFLINKCONDNAME);
    }

    @JsonIgnore
    public String getPSWFLinkId() {
        Object objValue = this.get(FIELD_PSWFLINKID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswflinkid")
    public void setPSWFLinkId(String pSWFLinkId) {
        this.set(FIELD_PSWFLINKID, pSWFLinkId);
    }

    @JsonIgnore
    public boolean isPSWFLinkIdDirty() {
        return this.contains(FIELD_PSWFLINKID);
    }

    @JsonIgnore
    public String getPSWFLinkName() {
        Object objValue = this.get(FIELD_PSWFLINKNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswflinkname")
    public void setPSWFLinkName(String pSWFLinkName) {
        this.set(FIELD_PSWFLINKNAME, pSWFLinkName);
    }

    @JsonIgnore
    public boolean isPSWFLinkNameDirty() {
        return this.contains(FIELD_PSWFLINKNAME);
    }

    @JsonIgnore
    public String getPSWFVersionId() {
        Object objValue = this.get(FIELD_PSWFVERSIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswfversionid")
    public void setPSWFVersionId(String pSWFVersionId) {
        this.set(FIELD_PSWFVERSIONID, pSWFVersionId);
    }

    @JsonIgnore
    public boolean isPSWFVersionIdDirty() {
        return this.contains(FIELD_PSWFVERSIONID);
    }

    @JsonIgnore
    public String getPSWFVersionName() {
        Object objValue = this.get(FIELD_PSWFVERSIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswfversionname")
    public void setPSWFVersionName(String pSWFVersionName) {
        this.set(FIELD_PSWFVERSIONNAME, pSWFVersionName);
    }

    @JsonIgnore
    public boolean isPSWFVersionNameDirty() {
        return this.contains(FIELD_PSWFVERSIONNAME);
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

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSWFLinkCondId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSWFLinkCondId(strValue);
    }

    @JsonProperty(value="pswflinkconds")
    public List<PSWFLinkCondDTO> getPswflinkconds() {
        return this.pswflinkconds;
    }

    @JsonProperty(value="pswflinkconds")
    public void setPswflinkconds(List<PSWFLinkCondDTO> pswflinkconds) {
        this.pswflinkconds = pswflinkconds;
    }
}

