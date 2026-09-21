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
import net.ibizsys.modelapi.domain.PSSysMapItem;
import net.ibizsys.modelapi.domain.PSSysMapLogic;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSSysMapView
extends PSModelBase {
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_EMPTYTEXT = "emptytext";
    public static final String FIELD_EMPTYTEXTPSLANRESID = "emptytextpslanresid";
    public static final String FIELD_EMPTYTEXTPSLANRESNAME = "emptytextpslanresname";
    public static final String FIELD_LOGICNAME = "logicname";
    public static final String FIELD_MAPVIEWSTYLE = "mapviewstyle";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSCTRLLOGICGROUPID = "psctrllogicgroupid";
    public static final String FIELD_PSCTRLLOGICGROUPNAME = "psctrllogicgroupname";
    public static final String FIELD_PSCTRLMSGID = "psctrlmsgid";
    public static final String FIELD_PSCTRLMSGNAME = "psctrlmsgname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSSYSCSSID = "pssyscssid";
    public static final String FIELD_PSSYSCSSNAME = "pssyscssname";
    public static final String FIELD_PSSYSMAPVIEWID = "pssysmapviewid";
    public static final String FIELD_PSSYSMAPVIEWNAME = "pssysmapviewname";
    public static final String FIELD_PSSYSPFPLUGINID = "pssyspfpluginid";
    public static final String FIELD_PSSYSPFPLUGINNAME = "pssyspfpluginname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    private List<PSSysMapItem> pssysmapitems;
    private List<PSSysMapLogic> pssysmaplogics;

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
    public String getEmptyText() {
        Object objValue = this.get(FIELD_EMPTYTEXT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="emptytext")
    public void setEmptyText(String emptyText) {
        this.set(FIELD_EMPTYTEXT, emptyText);
    }

    @JsonIgnore
    public boolean isEmptyTextDirty() {
        return this.contains(FIELD_EMPTYTEXT);
    }

    @JsonIgnore
    public String getEmptyTextPSLanResId() {
        Object objValue = this.get(FIELD_EMPTYTEXTPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="emptytextpslanresid")
    public void setEmptyTextPSLanResId(String emptyTextPSLanResId) {
        this.set(FIELD_EMPTYTEXTPSLANRESID, emptyTextPSLanResId);
    }

    @JsonIgnore
    public boolean isEmptyTextPSLanResIdDirty() {
        return this.contains(FIELD_EMPTYTEXTPSLANRESID);
    }

    @JsonIgnore
    public String getEmptyTextPSLanResName() {
        Object objValue = this.get(FIELD_EMPTYTEXTPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="emptytextpslanresname")
    public void setEmptyTextPSLanResName(String emptyTextPSLanResName) {
        this.set(FIELD_EMPTYTEXTPSLANRESNAME, emptyTextPSLanResName);
    }

    @JsonIgnore
    public boolean isEmptyTextPSLanResNameDirty() {
        return this.contains(FIELD_EMPTYTEXTPSLANRESNAME);
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
    public String getMapViewStyle() {
        Object objValue = this.get(FIELD_MAPVIEWSTYLE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mapviewstyle")
    public void setMapViewStyle(String mapViewStyle) {
        this.set(FIELD_MAPVIEWSTYLE, mapViewStyle);
    }

    @JsonIgnore
    public boolean isMapViewStyleDirty() {
        return this.contains(FIELD_MAPVIEWSTYLE);
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
    public String getPSCtrlMsgId() {
        Object objValue = this.get(FIELD_PSCTRLMSGID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psctrlmsgid")
    public void setPSCtrlMsgId(String pSCtrlMsgId) {
        this.set(FIELD_PSCTRLMSGID, pSCtrlMsgId);
    }

    @JsonIgnore
    public boolean isPSCtrlMsgIdDirty() {
        return this.contains(FIELD_PSCTRLMSGID);
    }

    @JsonIgnore
    public String getPSCtrlMsgName() {
        Object objValue = this.get(FIELD_PSCTRLMSGNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psctrlmsgname")
    public void setPSCtrlMsgName(String pSCtrlMsgName) {
        this.set(FIELD_PSCTRLMSGNAME, pSCtrlMsgName);
    }

    @JsonIgnore
    public boolean isPSCtrlMsgNameDirty() {
        return this.contains(FIELD_PSCTRLMSGNAME);
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
    public String getPSSysMapViewId() {
        Object objValue = this.get(FIELD_PSSYSMAPVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysmapviewid")
    public void setPSSysMapViewId(String pSSysMapViewId) {
        this.set(FIELD_PSSYSMAPVIEWID, pSSysMapViewId);
    }

    @JsonIgnore
    public boolean isPSSysMapViewIdDirty() {
        return this.contains(FIELD_PSSYSMAPVIEWID);
    }

    @JsonIgnore
    public String getPSSysMapViewName() {
        Object objValue = this.get(FIELD_PSSYSMAPVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysmapviewname")
    public void setPSSysMapViewName(String pSSysMapViewName) {
        this.set(FIELD_PSSYSMAPVIEWNAME, pSSysMapViewName);
    }

    @JsonIgnore
    public boolean isPSSysMapViewNameDirty() {
        return this.contains(FIELD_PSSYSMAPVIEWNAME);
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
        return this.getPSSysMapViewId();
    }

    public void setSrfkey(String strValue) {
        this.setPSSysMapViewId(strValue);
    }

    public List<PSSysMapItem> getPssysmapitems() {
        return this.pssysmapitems;
    }

    public void setPssysmapitems(List<PSSysMapItem> pssysmapitems) {
        this.pssysmapitems = pssysmapitems;
    }

    public List<PSSysMapLogic> getPssysmaplogics() {
        return this.pssysmaplogics;
    }

    public void setPssysmaplogics(List<PSSysMapLogic> pssysmaplogics) {
        this.pssysmaplogics = pssysmaplogics;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (strName.equalsIgnoreCase("pssysmapitems")) {
            return true;
        }
        if (strName.equalsIgnoreCase("pssysmaplogics")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("pssysmapitems")) {
            this.init();
            return this.pssysmapitems;
        }
        if (strName.equalsIgnoreCase("pssysmaplogics")) {
            this.init();
            return this.pssysmaplogics;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSSYSMAPVIEW";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSSysMapView item = (PSSysMapView)MAPPER.readValue(new File(strJsonFilePath), PSSysMapView.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSSysMapView) {
            PSSysMapView dst = (PSSysMapView)target;
            if (!bSimple) {
                PSModelBase newitem;
                if (this.getPssysmapitems() != null) {
                    ArrayList<PSSysMapItem> pssysmapitems = new ArrayList<PSSysMapItem>();
                    for (PSSysMapItem pSSysMapItem : this.getPssysmapitems()) {
                        if (bDeepMode) {
                            newitem = new PSSysMapItem();
                            pSSysMapItem.to(newitem, false, bDeepMode);
                            pssysmapitems.add((PSSysMapItem)newitem);
                            continue;
                        }
                        pssysmapitems.add(pSSysMapItem);
                    }
                    dst.setPssysmapitems(pssysmapitems);
                }
                if (this.getPssysmaplogics() != null) {
                    ArrayList<PSSysMapLogic> pssysmaplogics = new ArrayList<PSSysMapLogic>();
                    for (PSSysMapLogic pSSysMapLogic : this.getPssysmaplogics()) {
                        if (bDeepMode) {
                            newitem = new PSSysMapLogic();
                            pSSysMapLogic.to(newitem, false, bDeepMode);
                            pssysmaplogics.add((PSSysMapLogic)newitem);
                            continue;
                        }
                        pssysmaplogics.add(pSSysMapLogic);
                    }
                    dst.setPssysmaplogics(pssysmaplogics);
                }
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSSysMapView) {
            PSSysMapView src = (PSSysMapView)source;
            if (!bSimple) {
                PSModelBase newItem;
                if (src.getPssysmapitems() != null) {
                    ArrayList<PSSysMapItem> pssysmapitems = new ArrayList<PSSysMapItem>();
                    for (PSSysMapItem pSSysMapItem : src.getPssysmapitems()) {
                        if (bDeepMode) {
                            newItem = new PSSysMapItem();
                            ((PSSysMapItem)newItem).from(pSSysMapItem, false, bDeepMode);
                            pssysmapitems.add((PSSysMapItem)newItem);
                            continue;
                        }
                        pssysmapitems.add(pSSysMapItem);
                    }
                    this.setPssysmapitems(pssysmapitems);
                }
                if (src.getPssysmaplogics() != null) {
                    ArrayList<PSSysMapLogic> pssysmaplogics = new ArrayList<PSSysMapLogic>();
                    for (PSSysMapLogic pSSysMapLogic : src.getPssysmaplogics()) {
                        if (bDeepMode) {
                            newItem = new PSSysMapLogic();
                            ((PSSysMapLogic)newItem).from(pSSysMapLogic, false, bDeepMode);
                            pssysmaplogics.add((PSSysMapLogic)newItem);
                            continue;
                        }
                        pssysmaplogics.add(pSSysMapLogic);
                    }
                    this.setPssysmaplogics(pssysmaplogics);
                }
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

