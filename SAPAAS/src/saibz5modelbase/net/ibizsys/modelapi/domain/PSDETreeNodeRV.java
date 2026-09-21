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

public class PSDETreeNodeRV
extends PSModelBase {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSDETREENODEID = "psdetreenodeid";
    public static final String FIELD_PSDETREENODENAME = "psdetreenodename";
    public static final String FIELD_PSDETREENODERVID = "psdetreenodervid";
    public static final String FIELD_PSDETREENODERVNAME = "psdetreenodervname";
    public static final String FIELD_PSDEVIEWBASEID = "psdeviewbaseid";
    public static final String FIELD_PSDEVIEWBASENAME = "psdeviewbasename";
    public static final String FIELD_REFMODE = "refmode";
    public static final String FIELD_REFMODETEXT = "refmodetext";
    public static final String FIELD_REFPARAM = "refparam";
    public static final String FIELD_REFPARAMDESC = "refparamdesc";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VIEWPARAMS = "viewparams";

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
    public String getPSDETreeNodeId() {
        Object objValue = this.get(FIELD_PSDETREENODEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdetreenodeid")
    public void setPSDETreeNodeId(String pSDETreeNodeId) {
        this.set(FIELD_PSDETREENODEID, pSDETreeNodeId);
    }

    @JsonIgnore
    public boolean isPSDETreeNodeIdDirty() {
        return this.contains(FIELD_PSDETREENODEID);
    }

    @JsonIgnore
    public String getPSDETreeNodeName() {
        Object objValue = this.get(FIELD_PSDETREENODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdetreenodename")
    public void setPSDETreeNodeName(String pSDETreeNodeName) {
        this.set(FIELD_PSDETREENODENAME, pSDETreeNodeName);
    }

    @JsonIgnore
    public boolean isPSDETreeNodeNameDirty() {
        return this.contains(FIELD_PSDETREENODENAME);
    }

    @JsonIgnore
    public String getPSDETreeNodeRVId() {
        Object objValue = this.get(FIELD_PSDETREENODERVID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdetreenodervid")
    public void setPSDETreeNodeRVId(String pSDETreeNodeRVId) {
        this.set(FIELD_PSDETREENODERVID, pSDETreeNodeRVId);
    }

    @JsonIgnore
    public boolean isPSDETreeNodeRVIdDirty() {
        return this.contains(FIELD_PSDETREENODERVID);
    }

    @JsonIgnore
    public String getPSDETreeNodeRVName() {
        Object objValue = this.get(FIELD_PSDETREENODERVNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdetreenodervname")
    public void setPSDETreeNodeRVName(String pSDETreeNodeRVName) {
        this.set(FIELD_PSDETREENODERVNAME, pSDETreeNodeRVName);
    }

    @JsonIgnore
    public boolean isPSDETreeNodeRVNameDirty() {
        return this.contains(FIELD_PSDETREENODERVNAME);
    }

    @JsonIgnore
    public String getPSDEViewBaseId() {
        Object objValue = this.get(FIELD_PSDEVIEWBASEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeviewbaseid")
    public void setPSDEViewBaseId(String pSDEViewBaseId) {
        this.set(FIELD_PSDEVIEWBASEID, pSDEViewBaseId);
    }

    @JsonIgnore
    public boolean isPSDEViewBaseIdDirty() {
        return this.contains(FIELD_PSDEVIEWBASEID);
    }

    @JsonIgnore
    public String getPSDEViewBaseName() {
        Object objValue = this.get(FIELD_PSDEVIEWBASENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeviewbasename")
    public void setPSDEViewBaseName(String pSDEViewBaseName) {
        this.set(FIELD_PSDEVIEWBASENAME, pSDEViewBaseName);
    }

    @JsonIgnore
    public boolean isPSDEViewBaseNameDirty() {
        return this.contains(FIELD_PSDEVIEWBASENAME);
    }

    @JsonIgnore
    public String getRefMode() {
        Object objValue = this.get(FIELD_REFMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refmode")
    public void setRefMode(String refMode) {
        this.set(FIELD_REFMODE, refMode);
    }

    @JsonIgnore
    public boolean isRefModeDirty() {
        return this.contains(FIELD_REFMODE);
    }

    @JsonIgnore
    public String getRefModeText() {
        Object objValue = this.get(FIELD_REFMODETEXT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refmodetext")
    public void setRefModeText(String refModeText) {
        this.set(FIELD_REFMODETEXT, refModeText);
    }

    @JsonIgnore
    public boolean isRefModeTextDirty() {
        return this.contains(FIELD_REFMODETEXT);
    }

    @JsonIgnore
    public String getRefParam() {
        Object objValue = this.get(FIELD_REFPARAM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refparam")
    public void setRefParam(String refParam) {
        this.set(FIELD_REFPARAM, refParam);
    }

    @JsonIgnore
    public boolean isRefParamDirty() {
        return this.contains(FIELD_REFPARAM);
    }

    @JsonIgnore
    public String getRefParamDesc() {
        Object objValue = this.get(FIELD_REFPARAMDESC);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refparamdesc")
    public void setRefParamDesc(String refParamDesc) {
        this.set(FIELD_REFPARAMDESC, refParamDesc);
    }

    @JsonIgnore
    public boolean isRefParamDescDirty() {
        return this.contains(FIELD_REFPARAMDESC);
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
    public String getViewParams() {
        Object objValue = this.get(FIELD_VIEWPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="viewparams")
    public void setViewParams(String viewParams) {
        this.set(FIELD_VIEWPARAMS, viewParams);
    }

    @JsonIgnore
    public boolean isViewParamsDirty() {
        return this.contains(FIELD_VIEWPARAMS);
    }

    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDETreeNodeRVId();
    }

    public void setSrfkey(String strValue) {
        this.setPSDETreeNodeRVId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSDETREENODERV";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSDETreeNodeRV item = (PSDETreeNodeRV)MAPPER.readValue(new File(strJsonFilePath), PSDETreeNodeRV.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSDETreeNodeRV) {
            PSDETreeNodeRV pSDETreeNodeRV = (PSDETreeNodeRV)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSDETreeNodeRV) {
            PSDETreeNodeRV pSDETreeNodeRV = (PSDETreeNodeRV)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

