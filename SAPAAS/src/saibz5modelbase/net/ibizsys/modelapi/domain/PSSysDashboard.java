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
import net.ibizsys.modelapi.domain.PSSysDBPart;
import net.ibizsys.modelapi.domain.PSSysDashboardLogic;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSSysDashboard
extends PSModelBase {
    public static final String FIELD_CODENAME = "codename";
    public static final String FIELD_COLMODEL = "colmodel";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_FLEXALIGN = "flexalign";
    public static final String FIELD_FLEXDIR = "flexdir";
    public static final String FIELD_FLEXVALIGN = "flexvalign";
    public static final String FIELD_LAYOUTMODE = "layoutmode";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSCTRLLOGICGROUPID = "psctrllogicgroupid";
    public static final String FIELD_PSCTRLLOGICGROUPNAME = "psctrllogicgroupname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSMODULEID = "psmoduleid";
    public static final String FIELD_PSMODULENAME = "psmodulename";
    public static final String FIELD_PSSYSAPPNAME = "pssysappname";
    public static final String FIELD_PSSYSCSSID = "pssyscssid";
    public static final String FIELD_PSSYSCSSNAME = "pssyscssname";
    public static final String FIELD_PSSYSDASHBOARDID = "pssysdashboardid";
    public static final String FIELD_PSSYSDASHBOARDNAME = "pssysdashboardname";
    public static final String FIELD_PSSYSPFPLUGINID = "pssyspfpluginid";
    public static final String FIELD_PSSYSPFPLUGINNAME = "pssyspfpluginname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    private List<PSSysDashboardLogic> pssysdashboardlogics;
    private List<PSSysDBPart> pssysdbparts;

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
    public String getColModel() {
        Object objValue = this.get(FIELD_COLMODEL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="colmodel")
    public void setColModel(String colModel) {
        this.set(FIELD_COLMODEL, colModel);
    }

    @JsonIgnore
    public boolean isColModelDirty() {
        return this.contains(FIELD_COLMODEL);
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
    public String getFlexAlign() {
        Object objValue = this.get(FIELD_FLEXALIGN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="flexalign")
    public void setFlexAlign(String flexAlign) {
        this.set(FIELD_FLEXALIGN, flexAlign);
    }

    @JsonIgnore
    public boolean isFlexAlignDirty() {
        return this.contains(FIELD_FLEXALIGN);
    }

    @JsonIgnore
    public String getFlexDir() {
        Object objValue = this.get(FIELD_FLEXDIR);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="flexdir")
    public void setFlexDir(String flexDir) {
        this.set(FIELD_FLEXDIR, flexDir);
    }

    @JsonIgnore
    public boolean isFlexDirDirty() {
        return this.contains(FIELD_FLEXDIR);
    }

    @JsonIgnore
    public String getFlexVAlign() {
        Object objValue = this.get(FIELD_FLEXVALIGN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="flexvalign")
    public void setFlexVAlign(String flexVAlign) {
        this.set(FIELD_FLEXVALIGN, flexVAlign);
    }

    @JsonIgnore
    public boolean isFlexVAlignDirty() {
        return this.contains(FIELD_FLEXVALIGN);
    }

    @JsonIgnore
    public String getLayoutMode() {
        Object objValue = this.get(FIELD_LAYOUTMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="layoutmode")
    public void setLayoutMode(String layoutMode) {
        this.set(FIELD_LAYOUTMODE, layoutMode);
    }

    @JsonIgnore
    public boolean isLayoutModeDirty() {
        return this.contains(FIELD_LAYOUTMODE);
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
    public String getPSCtrlLogicGroupId() {
        Object objValue = this.get(FIELD_PSCTRLLOGICGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psctrllogicgroupid")
    public void setPSCtrlLogicGroupId(String pSCtrlLogicGroupId) {
        this.set(FIELD_PSCTRLLOGICGROUPID, pSCtrlLogicGroupId);
    }

    @JsonIgnore
    public boolean isPSCtrlLogicGroupIdDirty() {
        return this.contains(FIELD_PSCTRLLOGICGROUPID);
    }

    @JsonIgnore
    public String getPSCtrlLogicGroupName() {
        Object objValue = this.get(FIELD_PSCTRLLOGICGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psctrllogicgroupname")
    public void setPSCtrlLogicGroupName(String pSCtrlLogicGroupName) {
        this.set(FIELD_PSCTRLLOGICGROUPNAME, pSCtrlLogicGroupName);
    }

    @JsonIgnore
    public boolean isPSCtrlLogicGroupNameDirty() {
        return this.contains(FIELD_PSCTRLLOGICGROUPNAME);
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
    public String getPSSysAppName() {
        Object objValue = this.get(FIELD_PSSYSAPPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysappname")
    public void setPSSysAppName(String pSSysAppName) {
        this.set(FIELD_PSSYSAPPNAME, pSSysAppName);
    }

    @JsonIgnore
    public boolean isPSSysAppNameDirty() {
        return this.contains(FIELD_PSSYSAPPNAME);
    }

    @JsonIgnore
    public String getPSSysCssId() {
        Object objValue = this.get(FIELD_PSSYSCSSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscssid")
    public void setPSSysCssId(String pSSysCssId) {
        this.set(FIELD_PSSYSCSSID, pSSysCssId);
    }

    @JsonIgnore
    public boolean isPSSysCssIdDirty() {
        return this.contains(FIELD_PSSYSCSSID);
    }

    @JsonIgnore
    public String getPSSysCssName() {
        Object objValue = this.get(FIELD_PSSYSCSSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscssname")
    public void setPSSysCssName(String pSSysCssName) {
        this.set(FIELD_PSSYSCSSNAME, pSSysCssName);
    }

    @JsonIgnore
    public boolean isPSSysCssNameDirty() {
        return this.contains(FIELD_PSSYSCSSNAME);
    }

    @JsonIgnore
    public String getPSSysDashboardId() {
        Object objValue = this.get(FIELD_PSSYSDASHBOARDID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdashboardid")
    public void setPSSysDashboardId(String pSSysDashboardId) {
        this.set(FIELD_PSSYSDASHBOARDID, pSSysDashboardId);
    }

    @JsonIgnore
    public boolean isPSSysDashboardIdDirty() {
        return this.contains(FIELD_PSSYSDASHBOARDID);
    }

    @JsonIgnore
    public String getPSSysDashboardName() {
        Object objValue = this.get(FIELD_PSSYSDASHBOARDNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdashboardname")
    public void setPSSysDashboardName(String pSSysDashboardName) {
        this.set(FIELD_PSSYSDASHBOARDNAME, pSSysDashboardName);
    }

    @JsonIgnore
    public boolean isPSSysDashboardNameDirty() {
        return this.contains(FIELD_PSSYSDASHBOARDNAME);
    }

    @JsonIgnore
    public String getPSSysPFPluginId() {
        Object objValue = this.get(FIELD_PSSYSPFPLUGINID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyspfpluginid")
    public void setPSSysPFPluginId(String pSSysPFPluginId) {
        this.set(FIELD_PSSYSPFPLUGINID, pSSysPFPluginId);
    }

    @JsonIgnore
    public boolean isPSSysPFPluginIdDirty() {
        return this.contains(FIELD_PSSYSPFPLUGINID);
    }

    @JsonIgnore
    public String getPSSysPFPluginName() {
        Object objValue = this.get(FIELD_PSSYSPFPLUGINNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyspfpluginname")
    public void setPSSysPFPluginName(String pSSysPFPluginName) {
        this.set(FIELD_PSSYSPFPLUGINNAME, pSSysPFPluginName);
    }

    @JsonIgnore
    public boolean isPSSysPFPluginNameDirty() {
        return this.contains(FIELD_PSSYSPFPLUGINNAME);
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
    public String getSrfkey() {
        return this.getPSSysDashboardId();
    }

    public void setSrfkey(String strValue) {
        this.setPSSysDashboardId(strValue);
    }

    public List<PSSysDashboardLogic> getPssysdashboardlogics() {
        return this.pssysdashboardlogics;
    }

    public void setPssysdashboardlogics(List<PSSysDashboardLogic> pssysdashboardlogics) {
        this.pssysdashboardlogics = pssysdashboardlogics;
    }

    public List<PSSysDBPart> getPssysdbparts() {
        return this.pssysdbparts;
    }

    public void setPssysdbparts(List<PSSysDBPart> pssysdbparts) {
        this.pssysdbparts = pssysdbparts;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (strName.equalsIgnoreCase("pssysdashboardlogics")) {
            return true;
        }
        if (strName.equalsIgnoreCase("pssysdbparts")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("pssysdashboardlogics")) {
            this.init();
            return this.pssysdashboardlogics;
        }
        if (strName.equalsIgnoreCase("pssysdbparts")) {
            this.init();
            return this.pssysdbparts;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSSYSDASHBOARD";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSSysDashboard item = (PSSysDashboard)MAPPER.readValue(new File(strJsonFilePath), PSSysDashboard.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSSysDashboard) {
            PSSysDashboard dst = (PSSysDashboard)target;
            if (!bSimple) {
                PSModelBase newitem;
                if (this.getPssysdashboardlogics() != null) {
                    ArrayList<PSSysDashboardLogic> pssysdashboardlogics = new ArrayList<PSSysDashboardLogic>();
                    for (PSSysDashboardLogic pSSysDashboardLogic : this.getPssysdashboardlogics()) {
                        if (bDeepMode) {
                            newitem = new PSSysDashboardLogic();
                            pSSysDashboardLogic.to(newitem, false, bDeepMode);
                            pssysdashboardlogics.add((PSSysDashboardLogic)newitem);
                            continue;
                        }
                        pssysdashboardlogics.add(pSSysDashboardLogic);
                    }
                    dst.setPssysdashboardlogics(pssysdashboardlogics);
                }
                if (this.getPssysdbparts() != null) {
                    ArrayList<PSSysDBPart> pssysdbparts = new ArrayList<PSSysDBPart>();
                    for (PSSysDBPart pSSysDBPart : this.getPssysdbparts()) {
                        if (bDeepMode) {
                            newitem = new PSSysDBPart();
                            pSSysDBPart.to(newitem, false, bDeepMode);
                            pssysdbparts.add((PSSysDBPart)newitem);
                            continue;
                        }
                        pssysdbparts.add(pSSysDBPart);
                    }
                    dst.setPssysdbparts(pssysdbparts);
                }
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSSysDashboard) {
            PSSysDashboard src = (PSSysDashboard)source;
            if (!bSimple) {
                PSModelBase newItem;
                if (src.getPssysdashboardlogics() != null) {
                    ArrayList<PSSysDashboardLogic> pssysdashboardlogics = new ArrayList<PSSysDashboardLogic>();
                    for (PSSysDashboardLogic pSSysDashboardLogic : src.getPssysdashboardlogics()) {
                        if (bDeepMode) {
                            newItem = new PSSysDashboardLogic();
                            ((PSSysDashboardLogic)newItem).from(pSSysDashboardLogic, false, bDeepMode);
                            pssysdashboardlogics.add((PSSysDashboardLogic)newItem);
                            continue;
                        }
                        pssysdashboardlogics.add(pSSysDashboardLogic);
                    }
                    this.setPssysdashboardlogics(pssysdashboardlogics);
                }
                if (src.getPssysdbparts() != null) {
                    ArrayList<PSSysDBPart> pssysdbparts = new ArrayList<PSSysDBPart>();
                    for (PSSysDBPart pSSysDBPart : src.getPssysdbparts()) {
                        if (bDeepMode) {
                            newItem = new PSSysDBPart();
                            ((PSSysDBPart)newItem).from(pSSysDBPart, false, bDeepMode);
                            pssysdbparts.add((PSSysDBPart)newItem);
                            continue;
                        }
                        pssysdbparts.add(pSSysDBPart);
                    }
                    this.setPssysdbparts(pssysdbparts);
                }
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

