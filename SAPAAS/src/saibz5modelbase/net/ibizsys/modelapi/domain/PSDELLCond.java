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
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSDELLCond
extends PSModelBase {
    public static final String FIELD_CONDVALUE = "condvalue";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CUSTOMDSTPARAM = "customdstparam";
    public static final String FIELD_DSTPARAMPSDEID = "dstparampsdeid";
    public static final String FIELD_DSTPSDEFID = "dstpsdefid";
    public static final String FIELD_DSTPSDEFNAME = "dstpsdefname";
    public static final String FIELD_DSTPSDLPARAMID = "dstpsdlparamid";
    public static final String FIELD_DSTPSDLPARAMNAME = "dstpsdlparamname";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_GROUPNOTFLAG = "groupnotflag";
    public static final String FIELD_GROUPOP = "groupop";
    public static final String FIELD_LOGICTYPE = "logictype";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PARAMTYPE = "paramtype";
    public static final String FIELD_PPSDELLCONDID = "ppsdellcondid";
    public static final String FIELD_PPSDELLCONDNAME = "ppsdellcondname";
    public static final String FIELD_PSDBVALUEOPID = "psdbvalueopid";
    public static final String FIELD_PSDBVALUEOPNAME = "psdbvalueopname";
    public static final String FIELD_PSDELLCONDID = "psdellcondid";
    public static final String FIELD_PSDELLCONDNAME = "psdellcondname";
    public static final String FIELD_PSDELOGICID = "psdelogicid";
    public static final String FIELD_PSDELOGICLINKID = "psdelogiclinkid";
    public static final String FIELD_PSDELOGICLINKNAME = "psdelogiclinkname";
    public static final String FIELD_SRCPSDLPARAMID = "srcpsdlparamid";
    public static final String FIELD_SRCPSDLPARAMNAME = "srcpsdlparamname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    private List<PSDELLCond> psdellconds;

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
    public String getPPSDELLCondId() {
        Object objValue = this.get(FIELD_PPSDELLCONDID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppsdellcondid")
    public void setPPSDELLCondId(String pPSDELLCondId) {
        this.set(FIELD_PPSDELLCONDID, pPSDELLCondId);
    }

    @JsonIgnore
    public boolean isPPSDELLCondIdDirty() {
        return this.contains(FIELD_PPSDELLCONDID);
    }

    @JsonIgnore
    public String getPPSDELLCondName() {
        Object objValue = this.get(FIELD_PPSDELLCONDNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppsdellcondname")
    public void setPPSDELLCondName(String pPSDELLCondName) {
        this.set(FIELD_PPSDELLCONDNAME, pPSDELLCondName);
    }

    @JsonIgnore
    public boolean isPPSDELLCondNameDirty() {
        return this.contains(FIELD_PPSDELLCONDNAME);
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
    public String getPSDELLCondId() {
        Object objValue = this.get(FIELD_PSDELLCONDID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdellcondid")
    public void setPSDELLCondId(String pSDELLCondId) {
        this.set(FIELD_PSDELLCONDID, pSDELLCondId);
    }

    @JsonIgnore
    public boolean isPSDELLCondIdDirty() {
        return this.contains(FIELD_PSDELLCONDID);
    }

    @JsonIgnore
    public String getPSDELLCondName() {
        Object objValue = this.get(FIELD_PSDELLCONDNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdellcondname")
    public void setPSDELLCondName(String pSDELLCondName) {
        this.set(FIELD_PSDELLCONDNAME, pSDELLCondName);
    }

    @JsonIgnore
    public boolean isPSDELLCondNameDirty() {
        return this.contains(FIELD_PSDELLCONDNAME);
    }

    @JsonIgnore
    public String getPSDElogicId() {
        Object objValue = this.get(FIELD_PSDELOGICID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdelogicid")
    public void setPSDElogicId(String pSDElogicId) {
        this.set(FIELD_PSDELOGICID, pSDElogicId);
    }

    @JsonIgnore
    public boolean isPSDElogicIdDirty() {
        return this.contains(FIELD_PSDELOGICID);
    }

    @JsonIgnore
    public String getPSDELogicLinkId() {
        Object objValue = this.get(FIELD_PSDELOGICLINKID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdelogiclinkid")
    public void setPSDELogicLinkId(String pSDELogicLinkId) {
        this.set(FIELD_PSDELOGICLINKID, pSDELogicLinkId);
    }

    @JsonIgnore
    public boolean isPSDELogicLinkIdDirty() {
        return this.contains(FIELD_PSDELOGICLINKID);
    }

    @JsonIgnore
    public String getPSDELogicLinkName() {
        Object objValue = this.get(FIELD_PSDELOGICLINKNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdelogiclinkname")
    public void setPSDELogicLinkName(String pSDELogicLinkName) {
        this.set(FIELD_PSDELOGICLINKNAME, pSDELogicLinkName);
    }

    @JsonIgnore
    public boolean isPSDELogicLinkNameDirty() {
        return this.contains(FIELD_PSDELOGICLINKNAME);
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
        return this.getPSDELLCondId();
    }

    public void setSrfkey(String strValue) {
        this.setPSDELLCondId(strValue);
    }

    public List<PSDELLCond> getPsdellconds() {
        return this.psdellconds;
    }

    public void setPsdellconds(List<PSDELLCond> psdellconds) {
        this.psdellconds = psdellconds;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (strName.equalsIgnoreCase("psdellconds")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("psdellconds")) {
            this.init();
            return this.psdellconds;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSDELLCOND";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSDELLCond item = (PSDELLCond)MAPPER.readValue(new File(strJsonFilePath), PSDELLCond.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSDELLCond) {
            PSDELLCond dst = (PSDELLCond)target;
            if (!bSimple && this.getPsdellconds() != null) {
                ArrayList<PSDELLCond> psdellconds = new ArrayList<PSDELLCond>();
                for (PSDELLCond item : this.getPsdellconds()) {
                    if (bDeepMode) {
                        PSDELLCond newitem = new PSDELLCond();
                        item.to(newitem, false, bDeepMode);
                        psdellconds.add(newitem);
                        continue;
                    }
                    psdellconds.add(item);
                }
                dst.setPsdellconds(psdellconds);
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSDELLCond) {
            PSDELLCond src = (PSDELLCond)source;
            if (!bSimple && src.getPsdellconds() != null) {
                ArrayList<PSDELLCond> psdellconds = new ArrayList<PSDELLCond>();
                for (PSDELLCond item : src.getPsdellconds()) {
                    if (bDeepMode) {
                        PSDELLCond newItem = new PSDELLCond();
                        newItem.from(item, false, bDeepMode);
                        psdellconds.add(newItem);
                        continue;
                    }
                    psdellconds.add(item);
                }
                this.setPsdellconds(psdellconds);
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

