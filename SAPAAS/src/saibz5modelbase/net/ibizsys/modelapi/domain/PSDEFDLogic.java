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

public class PSDEFDLogic
extends PSModelBase {
    public static final String FIELD_CONDVALUE = "condvalue";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CUSTOMCODE = "customcode";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_FDNAME = "fdname";
    public static final String FIELD_GROUPNOTFLAG = "groupnotflag";
    public static final String FIELD_GROUPOP = "groupop";
    public static final String FIELD_LOGICCAT = "logiccat";
    public static final String FIELD_LOGICTYPE = "logictype";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PPSDEFDLOGICID = "ppsdefdlogicid";
    public static final String FIELD_PPSDEFDLOGICNAME = "ppsdefdlogicname";
    public static final String FIELD_PSDBVALUEOPID = "psdbvalueopid";
    public static final String FIELD_PSDBVALUEOPNAME = "psdbvalueopname";
    public static final String FIELD_PSDEFDLOGICID = "psdefdlogicid";
    public static final String FIELD_PSDEFDLOGICNAME = "psdefdlogicname";
    public static final String FIELD_PSDEFORMDETAILID = "psdeformdetailid";
    public static final String FIELD_PSDEFORMDETAILNAME = "psdeformdetailname";
    public static final String FIELD_PSDEFORMID = "psdeformid";
    public static final String FIELD_PSDEFORMNAME = "psdeformname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    private List<PSDEFDLogic> psdefdlogics;

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
    public String getCustomCode() {
        Object objValue = this.get(FIELD_CUSTOMCODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="customcode")
    public void setCustomCode(String customCode) {
        this.set(FIELD_CUSTOMCODE, customCode);
    }

    @JsonIgnore
    public boolean isCustomCodeDirty() {
        return this.contains(FIELD_CUSTOMCODE);
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
    public String getFDName() {
        Object objValue = this.get(FIELD_FDNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="fdname")
    public void setFDName(String fDName) {
        this.set(FIELD_FDNAME, fDName);
    }

    @JsonIgnore
    public boolean isFDNameDirty() {
        return this.contains(FIELD_FDNAME);
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
    public String getLogicCat() {
        Object objValue = this.get(FIELD_LOGICCAT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="logiccat")
    public void setLogicCat(String logicCat) {
        this.set(FIELD_LOGICCAT, logicCat);
    }

    @JsonIgnore
    public boolean isLogicCatDirty() {
        return this.contains(FIELD_LOGICCAT);
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
    public String getPPSDEFDLogicId() {
        Object objValue = this.get(FIELD_PPSDEFDLOGICID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppsdefdlogicid")
    public void setPPSDEFDLogicId(String pPSDEFDLogicId) {
        this.set(FIELD_PPSDEFDLOGICID, pPSDEFDLogicId);
    }

    @JsonIgnore
    public boolean isPPSDEFDLogicIdDirty() {
        return this.contains(FIELD_PPSDEFDLOGICID);
    }

    @JsonIgnore
    public String getPPSDEFDLogicName() {
        Object objValue = this.get(FIELD_PPSDEFDLOGICNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppsdefdlogicname")
    public void setPPSDEFDLogicName(String pPSDEFDLogicName) {
        this.set(FIELD_PPSDEFDLOGICNAME, pPSDEFDLogicName);
    }

    @JsonIgnore
    public boolean isPPSDEFDLogicNameDirty() {
        return this.contains(FIELD_PPSDEFDLOGICNAME);
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
    public String getPSDEFDLogicId() {
        Object objValue = this.get(FIELD_PSDEFDLOGICID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefdlogicid")
    public void setPSDEFDLogicId(String pSDEFDLogicId) {
        this.set(FIELD_PSDEFDLOGICID, pSDEFDLogicId);
    }

    @JsonIgnore
    public boolean isPSDEFDLogicIdDirty() {
        return this.contains(FIELD_PSDEFDLOGICID);
    }

    @JsonIgnore
    public String getPSDEFDLogicName() {
        Object objValue = this.get(FIELD_PSDEFDLOGICNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefdlogicname")
    public void setPSDEFDLogicName(String pSDEFDLogicName) {
        this.set(FIELD_PSDEFDLOGICNAME, pSDEFDLogicName);
    }

    @JsonIgnore
    public boolean isPSDEFDLogicNameDirty() {
        return this.contains(FIELD_PSDEFDLOGICNAME);
    }

    @JsonIgnore
    public String getPSDEFormDetailId() {
        Object objValue = this.get(FIELD_PSDEFORMDETAILID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeformdetailid")
    public void setPSDEFormDetailId(String pSDEFormDetailId) {
        this.set(FIELD_PSDEFORMDETAILID, pSDEFormDetailId);
    }

    @JsonIgnore
    public boolean isPSDEFormDetailIdDirty() {
        return this.contains(FIELD_PSDEFORMDETAILID);
    }

    @JsonIgnore
    public String getPSDEFormDetailName() {
        Object objValue = this.get(FIELD_PSDEFORMDETAILNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeformdetailname")
    public void setPSDEFormDetailName(String pSDEFormDetailName) {
        this.set(FIELD_PSDEFORMDETAILNAME, pSDEFormDetailName);
    }

    @JsonIgnore
    public boolean isPSDEFormDetailNameDirty() {
        return this.contains(FIELD_PSDEFORMDETAILNAME);
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
    public String getSrfkey() {
        return this.getPSDEFDLogicId();
    }

    public void setSrfkey(String strValue) {
        this.setPSDEFDLogicId(strValue);
    }

    public List<PSDEFDLogic> getPsdefdlogics() {
        return this.psdefdlogics;
    }

    public void setPsdefdlogics(List<PSDEFDLogic> psdefdlogics) {
        this.psdefdlogics = psdefdlogics;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (strName.equalsIgnoreCase("psdefdlogics")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("psdefdlogics")) {
            this.init();
            return this.psdefdlogics;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSDEFDLOGIC";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSDEFDLogic item = (PSDEFDLogic)MAPPER.readValue(new File(strJsonFilePath), PSDEFDLogic.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSDEFDLogic) {
            PSDEFDLogic dst = (PSDEFDLogic)target;
            if (!bSimple && this.getPsdefdlogics() != null) {
                ArrayList<PSDEFDLogic> psdefdlogics = new ArrayList<PSDEFDLogic>();
                for (PSDEFDLogic item : this.getPsdefdlogics()) {
                    if (bDeepMode) {
                        PSDEFDLogic newitem = new PSDEFDLogic();
                        item.to(newitem, false, bDeepMode);
                        psdefdlogics.add(newitem);
                        continue;
                    }
                    psdefdlogics.add(item);
                }
                dst.setPsdefdlogics(psdefdlogics);
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSDEFDLogic) {
            PSDEFDLogic src = (PSDEFDLogic)source;
            if (!bSimple && src.getPsdefdlogics() != null) {
                ArrayList<PSDEFDLogic> psdefdlogics = new ArrayList<PSDEFDLogic>();
                for (PSDEFDLogic item : src.getPsdefdlogics()) {
                    if (bDeepMode) {
                        PSDEFDLogic newItem = new PSDEFDLogic();
                        newItem.from(item, false, bDeepMode);
                        psdefdlogics.add(newItem);
                        continue;
                    }
                    psdefdlogics.add(item);
                }
                this.setPsdefdlogics(psdefdlogics);
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

