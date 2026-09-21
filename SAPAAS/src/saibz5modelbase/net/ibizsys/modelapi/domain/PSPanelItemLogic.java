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

public class PSPanelItemLogic
extends PSModelBase {
    public static final String FIELD_CONDOP = "condop";
    public static final String FIELD_CONDVALUE = "condvalue";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CUSTOMCODE = "customcode";
    public static final String FIELD_DSTFIELDNAME = "dstfieldname";
    public static final String FIELD_DSTPSPANELMODELID = "dstpspanelmodelid";
    public static final String FIELD_DSTPSPANELMODELNAME = "dstpspanelmodelname";
    public static final String FIELD_GROUPNOTFLAG = "groupnotflag";
    public static final String FIELD_GROUPOP = "groupop";
    public static final String FIELD_LOGICCAT = "logiccat";
    public static final String FIELD_LOGICTYPE = "logictype";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PPSPANELITEMLOGICID = "ppspanelitemlogicid";
    public static final String FIELD_PPSPANELITEMLOGICNAME = "ppspanelitemlogicname";
    public static final String FIELD_PSPANELITEMLOGICID = "pspanelitemlogicid";
    public static final String FIELD_PSPANELITEMLOGICNAME = "pspanelitemlogicname";
    public static final String FIELD_PSSYSVIEWPANELID = "pssysviewpanelid";
    public static final String FIELD_PSSYSVIEWPANELITEMID = "pssysviewpanelitemid";
    public static final String FIELD_PSSYSVIEWPANELITEMNAME = "pssysviewpanelitemname";
    public static final String FIELD_PSSYSVIEWPANELNAME = "pssysviewpanelname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    private List<PSPanelItemLogic> pspanelitemlogics;

    @JsonIgnore
    public String getCondOp() {
        Object objValue = this.get(FIELD_CONDOP);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="condop")
    public void setCondOp(String condOp) {
        this.set(FIELD_CONDOP, condOp);
    }

    @JsonIgnore
    public boolean isCondOpDirty() {
        return this.contains(FIELD_CONDOP);
    }

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
    public String getDstFieldName() {
        Object objValue = this.get(FIELD_DSTFIELDNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstfieldname")
    public void setDstFieldName(String dstFieldName) {
        this.set(FIELD_DSTFIELDNAME, dstFieldName);
    }

    @JsonIgnore
    public boolean isDstFieldNameDirty() {
        return this.contains(FIELD_DSTFIELDNAME);
    }

    @JsonIgnore
    public String getDstPSPanelModelId() {
        Object objValue = this.get(FIELD_DSTPSPANELMODELID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpspanelmodelid")
    public void setDstPSPanelModelId(String dstPSPanelModelId) {
        this.set(FIELD_DSTPSPANELMODELID, dstPSPanelModelId);
    }

    @JsonIgnore
    public boolean isDstPSPanelModelIdDirty() {
        return this.contains(FIELD_DSTPSPANELMODELID);
    }

    @JsonIgnore
    public String getDstPSPanelModelName() {
        Object objValue = this.get(FIELD_DSTPSPANELMODELNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpspanelmodelname")
    public void setDstPSPanelModelName(String dstPSPanelModelName) {
        this.set(FIELD_DSTPSPANELMODELNAME, dstPSPanelModelName);
    }

    @JsonIgnore
    public boolean isDstPSPanelModelNameDirty() {
        return this.contains(FIELD_DSTPSPANELMODELNAME);
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
    public String getPPSPanelItemLogicId() {
        Object objValue = this.get(FIELD_PPSPANELITEMLOGICID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppspanelitemlogicid")
    public void setPPSPanelItemLogicId(String pPSPanelItemLogicId) {
        this.set(FIELD_PPSPANELITEMLOGICID, pPSPanelItemLogicId);
    }

    @JsonIgnore
    public boolean isPPSPanelItemLogicIdDirty() {
        return this.contains(FIELD_PPSPANELITEMLOGICID);
    }

    @JsonIgnore
    public String getPPSPanelItemLogicName() {
        Object objValue = this.get(FIELD_PPSPANELITEMLOGICNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppspanelitemlogicname")
    public void setPPSPanelItemLogicName(String pPSPanelItemLogicName) {
        this.set(FIELD_PPSPANELITEMLOGICNAME, pPSPanelItemLogicName);
    }

    @JsonIgnore
    public boolean isPPSPanelItemLogicNameDirty() {
        return this.contains(FIELD_PPSPANELITEMLOGICNAME);
    }

    @JsonIgnore
    public String getPSPanelItemLogicId() {
        Object objValue = this.get(FIELD_PSPANELITEMLOGICID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pspanelitemlogicid")
    public void setPSPanelItemLogicId(String pSPanelItemLogicId) {
        this.set(FIELD_PSPANELITEMLOGICID, pSPanelItemLogicId);
    }

    @JsonIgnore
    public boolean isPSPanelItemLogicIdDirty() {
        return this.contains(FIELD_PSPANELITEMLOGICID);
    }

    @JsonIgnore
    public String getPSPanelItemLogicName() {
        Object objValue = this.get(FIELD_PSPANELITEMLOGICNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pspanelitemlogicname")
    public void setPSPanelItemLogicName(String pSPanelItemLogicName) {
        this.set(FIELD_PSPANELITEMLOGICNAME, pSPanelItemLogicName);
    }

    @JsonIgnore
    public boolean isPSPanelItemLogicNameDirty() {
        return this.contains(FIELD_PSPANELITEMLOGICNAME);
    }

    @JsonIgnore
    public String getPSSysViewPanelId() {
        Object objValue = this.get(FIELD_PSSYSVIEWPANELID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysviewpanelid")
    public void setPSSysViewPanelId(String pSSysViewPanelId) {
        this.set(FIELD_PSSYSVIEWPANELID, pSSysViewPanelId);
    }

    @JsonIgnore
    public boolean isPSSysViewPanelIdDirty() {
        return this.contains(FIELD_PSSYSVIEWPANELID);
    }

    @JsonIgnore
    public String getPSSysViewPanelItemId() {
        Object objValue = this.get(FIELD_PSSYSVIEWPANELITEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysviewpanelitemid")
    public void setPSSysViewPanelItemId(String pSSysViewPanelItemId) {
        this.set(FIELD_PSSYSVIEWPANELITEMID, pSSysViewPanelItemId);
    }

    @JsonIgnore
    public boolean isPSSysViewPanelItemIdDirty() {
        return this.contains(FIELD_PSSYSVIEWPANELITEMID);
    }

    @JsonIgnore
    public String getPSSysViewPanelItemName() {
        Object objValue = this.get(FIELD_PSSYSVIEWPANELITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysviewpanelitemname")
    public void setPSSysViewPanelItemName(String pSSysViewPanelItemName) {
        this.set(FIELD_PSSYSVIEWPANELITEMNAME, pSSysViewPanelItemName);
    }

    @JsonIgnore
    public boolean isPSSysViewPanelItemNameDirty() {
        return this.contains(FIELD_PSSYSVIEWPANELITEMNAME);
    }

    @JsonIgnore
    public String getPSSysViewPanelName() {
        Object objValue = this.get(FIELD_PSSYSVIEWPANELNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysviewpanelname")
    public void setPSSysViewPanelName(String pSSysViewPanelName) {
        this.set(FIELD_PSSYSVIEWPANELNAME, pSSysViewPanelName);
    }

    @JsonIgnore
    public boolean isPSSysViewPanelNameDirty() {
        return this.contains(FIELD_PSSYSVIEWPANELNAME);
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
        return this.getPSPanelItemLogicId();
    }

    public void setSrfkey(String strValue) {
        this.setPSPanelItemLogicId(strValue);
    }

    public List<PSPanelItemLogic> getPspanelitemlogics() {
        return this.pspanelitemlogics;
    }

    public void setPspanelitemlogics(List<PSPanelItemLogic> pspanelitemlogics) {
        this.pspanelitemlogics = pspanelitemlogics;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (strName.equalsIgnoreCase("pspanelitemlogics")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("pspanelitemlogics")) {
            this.init();
            return this.pspanelitemlogics;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSPANELITEMLOGIC";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSPanelItemLogic item = (PSPanelItemLogic)MAPPER.readValue(new File(strJsonFilePath), PSPanelItemLogic.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSPanelItemLogic) {
            PSPanelItemLogic dst = (PSPanelItemLogic)target;
            if (!bSimple && this.getPspanelitemlogics() != null) {
                ArrayList<PSPanelItemLogic> pspanelitemlogics = new ArrayList<PSPanelItemLogic>();
                for (PSPanelItemLogic item : this.getPspanelitemlogics()) {
                    if (bDeepMode) {
                        PSPanelItemLogic newitem = new PSPanelItemLogic();
                        item.to(newitem, false, bDeepMode);
                        pspanelitemlogics.add(newitem);
                        continue;
                    }
                    pspanelitemlogics.add(item);
                }
                dst.setPspanelitemlogics(pspanelitemlogics);
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSPanelItemLogic) {
            PSPanelItemLogic src = (PSPanelItemLogic)source;
            if (!bSimple && src.getPspanelitemlogics() != null) {
                ArrayList<PSPanelItemLogic> pspanelitemlogics = new ArrayList<PSPanelItemLogic>();
                for (PSPanelItemLogic item : src.getPspanelitemlogics()) {
                    if (bDeepMode) {
                        PSPanelItemLogic newItem = new PSPanelItemLogic();
                        newItem.from(item, false, bDeepMode);
                        pspanelitemlogics.add(newItem);
                        continue;
                    }
                    pspanelitemlogics.add(item);
                }
                this.setPspanelitemlogics(pspanelitemlogics);
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

