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
import net.ibizsys.modelapi.domain.PSSysCanvasModel;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSSysCanvas
extends PSModelBase {
    public static final String FIELD_CANVASMODEL = "canvasmodel";
    public static final String FIELD_CANVASTAG = "canvastag";
    public static final String FIELD_CANVASTAG2 = "canvastag2";
    public static final String FIELD_CANVASTAG3 = "canvastag3";
    public static final String FIELD_CANVASTAG4 = "canvastag4";
    public static final String FIELD_CANVASTYPE = "canvastype";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSMODULEID = "psmoduleid";
    public static final String FIELD_PSMODULENAME = "psmodulename";
    public static final String FIELD_PSSYSCANVASID = "pssyscanvasid";
    public static final String FIELD_PSSYSCANVASNAME = "pssyscanvasname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    private List<PSSysCanvasModel> pssyscanvasmodels;

    @JsonIgnore
    public String getCanvasModel() {
        Object objValue = this.get(FIELD_CANVASMODEL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="canvasmodel")
    public void setCanvasModel(String canvasModel) {
        this.set(FIELD_CANVASMODEL, canvasModel);
    }

    @JsonIgnore
    public boolean isCanvasModelDirty() {
        return this.contains(FIELD_CANVASMODEL);
    }

    @JsonIgnore
    public String getCanvasTag() {
        Object objValue = this.get(FIELD_CANVASTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="canvastag")
    public void setCanvasTag(String canvasTag) {
        this.set(FIELD_CANVASTAG, canvasTag);
    }

    @JsonIgnore
    public boolean isCanvasTagDirty() {
        return this.contains(FIELD_CANVASTAG);
    }

    @JsonIgnore
    public String getCanvasTag2() {
        Object objValue = this.get(FIELD_CANVASTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="canvastag2")
    public void setCanvasTag2(String canvasTag2) {
        this.set(FIELD_CANVASTAG2, canvasTag2);
    }

    @JsonIgnore
    public boolean isCanvasTag2Dirty() {
        return this.contains(FIELD_CANVASTAG2);
    }

    @JsonIgnore
    public String getCanvasTag3() {
        Object objValue = this.get(FIELD_CANVASTAG3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="canvastag3")
    public void setCanvasTag3(String canvasTag3) {
        this.set(FIELD_CANVASTAG3, canvasTag3);
    }

    @JsonIgnore
    public boolean isCanvasTag3Dirty() {
        return this.contains(FIELD_CANVASTAG3);
    }

    @JsonIgnore
    public String getCanvasTag4() {
        Object objValue = this.get(FIELD_CANVASTAG4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="canvastag4")
    public void setCanvasTag4(String canvasTag4) {
        this.set(FIELD_CANVASTAG4, canvasTag4);
    }

    @JsonIgnore
    public boolean isCanvasTag4Dirty() {
        return this.contains(FIELD_CANVASTAG4);
    }

    @JsonIgnore
    public String getCanvasType() {
        Object objValue = this.get(FIELD_CANVASTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="canvastype")
    public void setCanvasType(String canvasType) {
        this.set(FIELD_CANVASTYPE, canvasType);
    }

    @JsonIgnore
    public boolean isCanvasTypeDirty() {
        return this.contains(FIELD_CANVASTYPE);
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
    public String getPSModuleId() {
        Object objValue = this.get(FIELD_PSMODULEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psmoduleid")
    public void setPSModuleId(String pSModuleId) {
        this.set(FIELD_PSMODULEID, pSModuleId);
    }

    @JsonIgnore
    public boolean isPSModuleIdDirty() {
        return this.contains(FIELD_PSMODULEID);
    }

    @JsonIgnore
    public String getPSModuleName() {
        Object objValue = this.get(FIELD_PSMODULENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psmodulename")
    public void setPSModuleName(String pSModuleName) {
        this.set(FIELD_PSMODULENAME, pSModuleName);
    }

    @JsonIgnore
    public boolean isPSModuleNameDirty() {
        return this.contains(FIELD_PSMODULENAME);
    }

    @JsonIgnore
    public String getPSSysCanvasId() {
        Object objValue = this.get(FIELD_PSSYSCANVASID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscanvasid")
    public void setPSSysCanvasId(String pSSysCanvasId) {
        this.set(FIELD_PSSYSCANVASID, pSSysCanvasId);
    }

    @JsonIgnore
    public boolean isPSSysCanvasIdDirty() {
        return this.contains(FIELD_PSSYSCANVASID);
    }

    @JsonIgnore
    public String getPSSysCanvasName() {
        Object objValue = this.get(FIELD_PSSYSCANVASNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscanvasname")
    public void setPSSysCanvasName(String pSSysCanvasName) {
        this.set(FIELD_PSSYSCANVASNAME, pSSysCanvasName);
    }

    @JsonIgnore
    public boolean isPSSysCanvasNameDirty() {
        return this.contains(FIELD_PSSYSCANVASNAME);
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
        return this.getPSSysCanvasId();
    }

    public void setSrfkey(String strValue) {
        this.setPSSysCanvasId(strValue);
    }

    public List<PSSysCanvasModel> getPssyscanvasmodels() {
        return this.pssyscanvasmodels;
    }

    public void setPssyscanvasmodels(List<PSSysCanvasModel> pssyscanvasmodels) {
        this.pssyscanvasmodels = pssyscanvasmodels;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (strName.equalsIgnoreCase("pssyscanvasmodels")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("pssyscanvasmodels")) {
            this.init();
            return this.pssyscanvasmodels;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSSYSCANVAS";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSSysCanvas item = (PSSysCanvas)MAPPER.readValue(new File(strJsonFilePath), PSSysCanvas.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSSysCanvas) {
            PSSysCanvas dst = (PSSysCanvas)target;
            if (!bSimple && this.getPssyscanvasmodels() != null) {
                ArrayList<PSSysCanvasModel> pssyscanvasmodels = new ArrayList<PSSysCanvasModel>();
                for (PSSysCanvasModel item : this.getPssyscanvasmodels()) {
                    if (bDeepMode) {
                        PSSysCanvasModel newitem = new PSSysCanvasModel();
                        item.to(newitem, false, bDeepMode);
                        pssyscanvasmodels.add(newitem);
                        continue;
                    }
                    pssyscanvasmodels.add(item);
                }
                dst.setPssyscanvasmodels(pssyscanvasmodels);
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSSysCanvas) {
            PSSysCanvas src = (PSSysCanvas)source;
            if (!bSimple && src.getPssyscanvasmodels() != null) {
                ArrayList<PSSysCanvasModel> pssyscanvasmodels = new ArrayList<PSSysCanvasModel>();
                for (PSSysCanvasModel item : src.getPssyscanvasmodels()) {
                    if (bDeepMode) {
                        PSSysCanvasModel newItem = new PSSysCanvasModel();
                        newItem.from(item, false, bDeepMode);
                        pssyscanvasmodels.add(newItem);
                        continue;
                    }
                    pssyscanvasmodels.add(item);
                }
                this.setPssyscanvasmodels(pssyscanvasmodels);
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

