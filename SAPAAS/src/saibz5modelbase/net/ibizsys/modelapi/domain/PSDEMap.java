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
import net.ibizsys.modelapi.domain.PSDEMapAction;
import net.ibizsys.modelapi.domain.PSDEMapDQ;
import net.ibizsys.modelapi.domain.PSDEMapDS;
import net.ibizsys.modelapi.domain.PSDEMapDetail;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSDEMap
extends PSModelBase {
    public static final String FIELD_AUTODEACTIONMAP = "autodeactionmap";
    public static final String FIELD_AUTODEDQMAP = "autodedqmap";
    public static final String FIELD_AUTODEDSMAP = "autodedsmap";
    public static final String FIELD_AUTODEFIELDMAP = "autodefieldmap";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DEFAULTMODE = "defaultmode";
    public static final String FIELD_DSTPSDEID = "dstpsdeid";
    public static final String FIELD_DSTPSDENAME = "dstpsdename";
    public static final String FIELD_DSTPSSYSREFDEID = "dstpssysrefdeid";
    public static final String FIELD_DSTPSSYSREFDENAME = "dstpssysrefdename";
    public static final String FIELD_LOGICNAME = "logicname";
    public static final String FIELD_MAPMODE = "mapmode";
    public static final String FIELD_MAPTARGET = "maptarget";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDEMAPID = "psdemapid";
    public static final String FIELD_PSDEMAPNAME = "psdemapname";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    public static final String FIELD_PSSYSREFID = "pssysrefid";
    public static final String FIELD_PSSYSREFNAME = "pssysrefname";
    public static final String FIELD_PSSYSSFPLUGINID = "pssyssfpluginid";
    public static final String FIELD_PSSYSSFPLUGINNAME = "pssyssfpluginname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";
    private List<PSDEMapAction> psdemapactions;
    private List<PSDEMapDetail> psdemapdetails;
    private List<PSDEMapDQ> psdemapdqs;
    private List<PSDEMapDS> psdemapds;

    @JsonIgnore
    public Integer getAutoDEActionMap() {
        Object objValue = this.get(FIELD_AUTODEACTIONMAP);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="autodeactionmap")
    public void setAutoDEActionMap(Integer autoDEActionMap) {
        this.set(FIELD_AUTODEACTIONMAP, autoDEActionMap);
    }

    @JsonIgnore
    public boolean isAutoDEActionMapDirty() {
        return this.contains(FIELD_AUTODEACTIONMAP);
    }

    @JsonIgnore
    public Integer getAutoDEDQMap() {
        Object objValue = this.get(FIELD_AUTODEDQMAP);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="autodedqmap")
    public void setAutoDEDQMap(Integer autoDEDQMap) {
        this.set(FIELD_AUTODEDQMAP, autoDEDQMap);
    }

    @JsonIgnore
    public boolean isAutoDEDQMapDirty() {
        return this.contains(FIELD_AUTODEDQMAP);
    }

    @JsonIgnore
    public Integer getAutoDEDSMap() {
        Object objValue = this.get(FIELD_AUTODEDSMAP);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="autodedsmap")
    public void setAutoDEDSMap(Integer autoDEDSMap) {
        this.set(FIELD_AUTODEDSMAP, autoDEDSMap);
    }

    @JsonIgnore
    public boolean isAutoDEDSMapDirty() {
        return this.contains(FIELD_AUTODEDSMAP);
    }

    @JsonIgnore
    public Integer getAutoDEFieldMap() {
        Object objValue = this.get(FIELD_AUTODEFIELDMAP);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="autodefieldmap")
    public void setAutoDEFieldMap(Integer autoDEFieldMap) {
        this.set(FIELD_AUTODEFIELDMAP, autoDEFieldMap);
    }

    @JsonIgnore
    public boolean isAutoDEFieldMapDirty() {
        return this.contains(FIELD_AUTODEFIELDMAP);
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
    public Integer getDefaultMode() {
        Object objValue = this.get(FIELD_DEFAULTMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="defaultmode")
    public void setDefaultMode(Integer defaultMode) {
        this.set(FIELD_DEFAULTMODE, defaultMode);
    }

    @JsonIgnore
    public boolean isDefaultModeDirty() {
        return this.contains(FIELD_DEFAULTMODE);
    }

    @JsonIgnore
    public String getDSTPSDEId() {
        Object objValue = this.get(FIELD_DSTPSDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdeid")
    public void setDSTPSDEId(String dSTPSDEId) {
        this.set(FIELD_DSTPSDEID, dSTPSDEId);
    }

    @JsonIgnore
    public boolean isDSTPSDEIdDirty() {
        return this.contains(FIELD_DSTPSDEID);
    }

    @JsonIgnore
    public String getDSTPSDEName() {
        Object objValue = this.get(FIELD_DSTPSDENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdename")
    public void setDSTPSDEName(String dSTPSDEName) {
        this.set(FIELD_DSTPSDENAME, dSTPSDEName);
    }

    @JsonIgnore
    public boolean isDSTPSDENameDirty() {
        return this.contains(FIELD_DSTPSDENAME);
    }

    @JsonIgnore
    public String getDstPSSysRefDEId() {
        Object objValue = this.get(FIELD_DSTPSSYSREFDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpssysrefdeid")
    public void setDstPSSysRefDEId(String dstPSSysRefDEId) {
        this.set(FIELD_DSTPSSYSREFDEID, dstPSSysRefDEId);
    }

    @JsonIgnore
    public boolean isDstPSSysRefDEIdDirty() {
        return this.contains(FIELD_DSTPSSYSREFDEID);
    }

    @JsonIgnore
    public String getDstPSSysRefDEName() {
        Object objValue = this.get(FIELD_DSTPSSYSREFDENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpssysrefdename")
    public void setDstPSSysRefDEName(String dstPSSysRefDEName) {
        this.set(FIELD_DSTPSSYSREFDENAME, dstPSSysRefDEName);
    }

    @JsonIgnore
    public boolean isDstPSSysRefDENameDirty() {
        return this.contains(FIELD_DSTPSSYSREFDENAME);
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
    public String getMapMode() {
        Object objValue = this.get(FIELD_MAPMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mapmode")
    public void setMapMode(String mapMode) {
        this.set(FIELD_MAPMODE, mapMode);
    }

    @JsonIgnore
    public boolean isMapModeDirty() {
        return this.contains(FIELD_MAPMODE);
    }

    @JsonIgnore
    public String getMapTarget() {
        Object objValue = this.get(FIELD_MAPTARGET);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="maptarget")
    public void setMapTarget(String mapTarget) {
        this.set(FIELD_MAPTARGET, mapTarget);
    }

    @JsonIgnore
    public boolean isMapTargetDirty() {
        return this.contains(FIELD_MAPTARGET);
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
    public String getPSDEMapId() {
        Object objValue = this.get(FIELD_PSDEMAPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdemapid")
    public void setPSDEMapId(String pSDEMapId) {
        this.set(FIELD_PSDEMAPID, pSDEMapId);
    }

    @JsonIgnore
    public boolean isPSDEMapIdDirty() {
        return this.contains(FIELD_PSDEMAPID);
    }

    @JsonIgnore
    public String getPSDEMapName() {
        Object objValue = this.get(FIELD_PSDEMAPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdemapname")
    public void setPSDEMapName(String pSDEMapName) {
        this.set(FIELD_PSDEMAPNAME, pSDEMapName);
    }

    @JsonIgnore
    public boolean isPSDEMapNameDirty() {
        return this.contains(FIELD_PSDEMAPNAME);
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
    public String getPSSysDynaModelId() {
        Object objValue = this.get(FIELD_PSSYSDYNAMODELID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdynamodelid")
    public void setPSSysDynaModelId(String pSSysDynaModelId) {
        this.set(FIELD_PSSYSDYNAMODELID, pSSysDynaModelId);
    }

    @JsonIgnore
    public boolean isPSSysDynaModelIdDirty() {
        return this.contains(FIELD_PSSYSDYNAMODELID);
    }

    @JsonIgnore
    public String getPSSysDynaModelName() {
        Object objValue = this.get(FIELD_PSSYSDYNAMODELNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdynamodelname")
    public void setPSSysDynaModelName(String pSSysDynaModelName) {
        this.set(FIELD_PSSYSDYNAMODELNAME, pSSysDynaModelName);
    }

    @JsonIgnore
    public boolean isPSSysDynaModelNameDirty() {
        return this.contains(FIELD_PSSYSDYNAMODELNAME);
    }

    @JsonIgnore
    public String getPSSysRefId() {
        Object objValue = this.get(FIELD_PSSYSREFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysrefid")
    public void setPSSysRefId(String pSSysRefId) {
        this.set(FIELD_PSSYSREFID, pSSysRefId);
    }

    @JsonIgnore
    public boolean isPSSysRefIdDirty() {
        return this.contains(FIELD_PSSYSREFID);
    }

    @JsonIgnore
    public String getPSSysRefName() {
        Object objValue = this.get(FIELD_PSSYSREFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysrefname")
    public void setPSSysRefName(String pSSysRefName) {
        this.set(FIELD_PSSYSREFNAME, pSSysRefName);
    }

    @JsonIgnore
    public boolean isPSSysRefNameDirty() {
        return this.contains(FIELD_PSSYSREFNAME);
    }

    @JsonIgnore
    public String getPSSysSFPluginId() {
        Object objValue = this.get(FIELD_PSSYSSFPLUGINID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssfpluginid")
    public void setPSSysSFPluginId(String pSSysSFPluginId) {
        this.set(FIELD_PSSYSSFPLUGINID, pSSysSFPluginId);
    }

    @JsonIgnore
    public boolean isPSSysSFPluginIdDirty() {
        return this.contains(FIELD_PSSYSSFPLUGINID);
    }

    @JsonIgnore
    public String getPSSysSFPluginName() {
        Object objValue = this.get(FIELD_PSSYSSFPLUGINNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssfpluginname")
    public void setPSSysSFPluginName(String pSSysSFPluginName) {
        this.set(FIELD_PSSYSSFPLUGINNAME, pSSysSFPluginName);
    }

    @JsonIgnore
    public boolean isPSSysSFPluginNameDirty() {
        return this.contains(FIELD_PSSYSSFPLUGINNAME);
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
    public String getSrfkey() {
        return this.getPSDEMapId();
    }

    public void setSrfkey(String strValue) {
        this.setPSDEMapId(strValue);
    }

    public List<PSDEMapAction> getPsdemapactions() {
        return this.psdemapactions;
    }

    public void setPsdemapactions(List<PSDEMapAction> psdemapactions) {
        this.psdemapactions = psdemapactions;
    }

    public List<PSDEMapDetail> getPsdemapdetails() {
        return this.psdemapdetails;
    }

    public void setPsdemapdetails(List<PSDEMapDetail> psdemapdetails) {
        this.psdemapdetails = psdemapdetails;
    }

    public List<PSDEMapDQ> getPsdemapdqs() {
        return this.psdemapdqs;
    }

    public void setPsdemapdqs(List<PSDEMapDQ> psdemapdqs) {
        this.psdemapdqs = psdemapdqs;
    }

    public List<PSDEMapDS> getPsdemapds() {
        return this.psdemapds;
    }

    public void setPsdemapds(List<PSDEMapDS> psdemapds) {
        this.psdemapds = psdemapds;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (strName.equalsIgnoreCase("psdemapactions")) {
            return true;
        }
        if (strName.equalsIgnoreCase("psdemapdetails")) {
            return true;
        }
        if (strName.equalsIgnoreCase("psdemapdqs")) {
            return true;
        }
        if (strName.equalsIgnoreCase("psdemapds")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("psdemapactions")) {
            this.init();
            return this.psdemapactions;
        }
        if (strName.equalsIgnoreCase("psdemapdetails")) {
            this.init();
            return this.psdemapdetails;
        }
        if (strName.equalsIgnoreCase("psdemapdqs")) {
            this.init();
            return this.psdemapdqs;
        }
        if (strName.equalsIgnoreCase("psdemapds")) {
            this.init();
            return this.psdemapds;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSDEMAP";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSDEMap item = (PSDEMap)MAPPER.readValue(new File(strJsonFilePath), PSDEMap.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSDEMap) {
            PSDEMap dst = (PSDEMap)target;
            if (!bSimple) {
                PSModelBase newitem;
                if (this.getPsdemapactions() != null) {
                    ArrayList<PSDEMapAction> psdemapactions = new ArrayList<PSDEMapAction>();
                    for (PSDEMapAction pSDEMapAction : this.getPsdemapactions()) {
                        if (bDeepMode) {
                            newitem = new PSDEMapAction();
                            pSDEMapAction.to(newitem, false, bDeepMode);
                            psdemapactions.add((PSDEMapAction)newitem);
                            continue;
                        }
                        psdemapactions.add(pSDEMapAction);
                    }
                    dst.setPsdemapactions(psdemapactions);
                }
                if (this.getPsdemapdetails() != null) {
                    ArrayList<PSDEMapDetail> psdemapdetails = new ArrayList<PSDEMapDetail>();
                    for (PSDEMapDetail pSDEMapDetail : this.getPsdemapdetails()) {
                        if (bDeepMode) {
                            newitem = new PSDEMapDetail();
                            pSDEMapDetail.to(newitem, false, bDeepMode);
                            psdemapdetails.add((PSDEMapDetail)newitem);
                            continue;
                        }
                        psdemapdetails.add(pSDEMapDetail);
                    }
                    dst.setPsdemapdetails(psdemapdetails);
                }
                if (this.getPsdemapdqs() != null) {
                    ArrayList<PSDEMapDQ> psdemapdqs = new ArrayList<PSDEMapDQ>();
                    for (PSDEMapDQ pSDEMapDQ : this.getPsdemapdqs()) {
                        if (bDeepMode) {
                            newitem = new PSDEMapDQ();
                            pSDEMapDQ.to(newitem, false, bDeepMode);
                            psdemapdqs.add((PSDEMapDQ)newitem);
                            continue;
                        }
                        psdemapdqs.add(pSDEMapDQ);
                    }
                    dst.setPsdemapdqs(psdemapdqs);
                }
                if (this.getPsdemapds() != null) {
                    ArrayList<PSDEMapDS> psdemapds = new ArrayList<PSDEMapDS>();
                    for (PSDEMapDS pSDEMapDS : this.getPsdemapds()) {
                        if (bDeepMode) {
                            newitem = new PSDEMapDS();
                            pSDEMapDS.to(newitem, false, bDeepMode);
                            psdemapds.add((PSDEMapDS)newitem);
                            continue;
                        }
                        psdemapds.add(pSDEMapDS);
                    }
                    dst.setPsdemapds(psdemapds);
                }
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSDEMap) {
            PSDEMap src = (PSDEMap)source;
            if (!bSimple) {
                PSModelBase newItem;
                if (src.getPsdemapactions() != null) {
                    ArrayList<PSDEMapAction> psdemapactions = new ArrayList<PSDEMapAction>();
                    for (PSDEMapAction pSDEMapAction : src.getPsdemapactions()) {
                        if (bDeepMode) {
                            newItem = new PSDEMapAction();
                            ((PSDEMapAction)newItem).from(pSDEMapAction, false, bDeepMode);
                            psdemapactions.add((PSDEMapAction)newItem);
                            continue;
                        }
                        psdemapactions.add(pSDEMapAction);
                    }
                    this.setPsdemapactions(psdemapactions);
                }
                if (src.getPsdemapdetails() != null) {
                    ArrayList<PSDEMapDetail> psdemapdetails = new ArrayList<PSDEMapDetail>();
                    for (PSDEMapDetail pSDEMapDetail : src.getPsdemapdetails()) {
                        if (bDeepMode) {
                            newItem = new PSDEMapDetail();
                            ((PSDEMapDetail)newItem).from(pSDEMapDetail, false, bDeepMode);
                            psdemapdetails.add((PSDEMapDetail)newItem);
                            continue;
                        }
                        psdemapdetails.add(pSDEMapDetail);
                    }
                    this.setPsdemapdetails(psdemapdetails);
                }
                if (src.getPsdemapdqs() != null) {
                    ArrayList<PSDEMapDQ> psdemapdqs = new ArrayList<PSDEMapDQ>();
                    for (PSDEMapDQ pSDEMapDQ : src.getPsdemapdqs()) {
                        if (bDeepMode) {
                            newItem = new PSDEMapDQ();
                            ((PSDEMapDQ)newItem).from(pSDEMapDQ, false, bDeepMode);
                            psdemapdqs.add((PSDEMapDQ)newItem);
                            continue;
                        }
                        psdemapdqs.add(pSDEMapDQ);
                    }
                    this.setPsdemapdqs(psdemapdqs);
                }
                if (src.getPsdemapds() != null) {
                    ArrayList<PSDEMapDS> psdemapds = new ArrayList<PSDEMapDS>();
                    for (PSDEMapDS pSDEMapDS : src.getPsdemapds()) {
                        if (bDeepMode) {
                            newItem = new PSDEMapDS();
                            ((PSDEMapDS)newItem).from(pSDEMapDS, false, bDeepMode);
                            psdemapds.add((PSDEMapDS)newItem);
                            continue;
                        }
                        psdemapds.add(pSDEMapDS);
                    }
                    this.setPsdemapds(psdemapds);
                }
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

