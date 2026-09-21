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
import net.ibizsys.modelapi.domain.PSDEACModeItem;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSDEACMode
extends PSModelBase {
    public static final String FIELD_ACIPSSYSPFPLUGINID = "acipssyspfpluginid";
    public static final String FIELD_ACIPSSYSPFPLUGINNAME = "acipssyspfpluginname";
    public static final String FIELD_ADPSDELOGICID = "adpsdelogicid";
    public static final String FIELD_ADPSDELOGICNAME = "adpsdelogicname";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DEFAULTMODE = "defaultmode";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_EMPTYTEXT = "emptytext";
    public static final String FIELD_EMPTYTEXTPSLANRESID = "emptytextpslanresid";
    public static final String FIELD_EMPTYTEXTPSLANRESNAME = "emptytextpslanresname";
    public static final String FIELD_ENABLEPAGINGBAR = "enablepagingbar";
    public static final String FIELD_EXTENDMODE = "extendmode";
    public static final String FIELD_FILLEROBJ = "fillerobj";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_LOGICNAME = "logicname";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MINORSORTDIR = "minorsortdir";
    public static final String FIELD_MINORSORTPSDEFID = "minorsortpsdefid";
    public static final String FIELD_MINORSORTPSDEFNAME = "minorsortpsdefname";
    public static final String FIELD_PAGINGSIZE = "pagingsize";
    public static final String FIELD_PICKUPPSDEVIEWID = "pickuppsdeviewid";
    public static final String FIELD_PICKUPPSDEVIEWNAME = "pickuppsdeviewname";
    public static final String FIELD_PSDEACMODEID = "psdeacmodeid";
    public static final String FIELD_PSDEACMODENAME = "psdeacmodename";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSDEUAGROUPID = "psdeuagroupid";
    public static final String FIELD_PSDEUAGROUPNAME = "psdeuagroupname";
    public static final String FIELD_TEXTPSDEFID = "textpsdefid";
    public static final String FIELD_TEXTPSDEFNAME = "textpsdefname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALUEPSDEFID = "valuepsdefid";
    public static final String FIELD_VALUEPSDEFNAME = "valuepsdefname";
    private List<PSDEACModeItem> psdeacmodeitems;

    @JsonIgnore
    public String getACIPSSysPFPluginId() {
        Object objValue = this.get(FIELD_ACIPSSYSPFPLUGINID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="acipssyspfpluginid")
    public void setACIPSSysPFPluginId(String aCIPSSysPFPluginId) {
        this.set(FIELD_ACIPSSYSPFPLUGINID, aCIPSSysPFPluginId);
    }

    @JsonIgnore
    public boolean isACIPSSysPFPluginIdDirty() {
        return this.contains(FIELD_ACIPSSYSPFPLUGINID);
    }

    @JsonIgnore
    public String getACIPSSysPFPluginName() {
        Object objValue = this.get(FIELD_ACIPSSYSPFPLUGINNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="acipssyspfpluginname")
    public void setACIPSSysPFPluginName(String aCIPSSysPFPluginName) {
        this.set(FIELD_ACIPSSYSPFPLUGINNAME, aCIPSSysPFPluginName);
    }

    @JsonIgnore
    public boolean isACIPSSysPFPluginNameDirty() {
        return this.contains(FIELD_ACIPSSYSPFPLUGINNAME);
    }

    @JsonIgnore
    public String getADPSDELogicId() {
        Object objValue = this.get(FIELD_ADPSDELOGICID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="adpsdelogicid")
    public void setADPSDELogicId(String aDPSDELogicId) {
        this.set(FIELD_ADPSDELOGICID, aDPSDELogicId);
    }

    @JsonIgnore
    public boolean isADPSDELogicIdDirty() {
        return this.contains(FIELD_ADPSDELOGICID);
    }

    @JsonIgnore
    public String getADPSDELogicName() {
        Object objValue = this.get(FIELD_ADPSDELOGICNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="adpsdelogicname")
    public void setADPSDELogicName(String aDPSDELogicName) {
        this.set(FIELD_ADPSDELOGICNAME, aDPSDELogicName);
    }

    @JsonIgnore
    public boolean isADPSDELogicNameDirty() {
        return this.contains(FIELD_ADPSDELOGICNAME);
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
    public Integer getEnablePagingBar() {
        Object objValue = this.get(FIELD_ENABLEPAGINGBAR);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablepagingbar")
    public void setEnablePagingBar(Integer enablePagingBar) {
        this.set(FIELD_ENABLEPAGINGBAR, enablePagingBar);
    }

    @JsonIgnore
    public boolean isEnablePagingBarDirty() {
        return this.contains(FIELD_ENABLEPAGINGBAR);
    }

    @JsonIgnore
    public Integer getExtendMode() {
        Object objValue = this.get(FIELD_EXTENDMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="extendmode")
    public void setExtendMode(Integer extendMode) {
        this.set(FIELD_EXTENDMODE, extendMode);
    }

    @JsonIgnore
    public boolean isExtendModeDirty() {
        return this.contains(FIELD_EXTENDMODE);
    }

    @JsonIgnore
    public String getFillerObj() {
        Object objValue = this.get(FIELD_FILLEROBJ);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="fillerobj")
    public void setFillerObj(String fillerObj) {
        this.set(FIELD_FILLEROBJ, fillerObj);
    }

    @JsonIgnore
    public boolean isFillerObjDirty() {
        return this.contains(FIELD_FILLEROBJ);
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
    public String getMinorSortDir() {
        Object objValue = this.get(FIELD_MINORSORTDIR);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="minorsortdir")
    public void setMinorSortDir(String minorSortDir) {
        this.set(FIELD_MINORSORTDIR, minorSortDir);
    }

    @JsonIgnore
    public boolean isMinorSortDirDirty() {
        return this.contains(FIELD_MINORSORTDIR);
    }

    @JsonIgnore
    public String getMinorSortPSDEFId() {
        Object objValue = this.get(FIELD_MINORSORTPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="minorsortpsdefid")
    public void setMinorSortPSDEFId(String minorSortPSDEFId) {
        this.set(FIELD_MINORSORTPSDEFID, minorSortPSDEFId);
    }

    @JsonIgnore
    public boolean isMinorSortPSDEFIdDirty() {
        return this.contains(FIELD_MINORSORTPSDEFID);
    }

    @JsonIgnore
    public String getMinorSortPSDEFName() {
        Object objValue = this.get(FIELD_MINORSORTPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="minorsortpsdefname")
    public void setMinorSortPSDEFName(String minorSortPSDEFName) {
        this.set(FIELD_MINORSORTPSDEFNAME, minorSortPSDEFName);
    }

    @JsonIgnore
    public boolean isMinorSortPSDEFNameDirty() {
        return this.contains(FIELD_MINORSORTPSDEFNAME);
    }

    @JsonIgnore
    public Integer getPagingSize() {
        Object objValue = this.get(FIELD_PAGINGSIZE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="pagingsize")
    public void setPagingSize(Integer pagingSize) {
        this.set(FIELD_PAGINGSIZE, pagingSize);
    }

    @JsonIgnore
    public boolean isPagingSizeDirty() {
        return this.contains(FIELD_PAGINGSIZE);
    }

    @JsonIgnore
    public String getPickupPSDEViewId() {
        Object objValue = this.get(FIELD_PICKUPPSDEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pickuppsdeviewid")
    public void setPickupPSDEViewId(String pickupPSDEViewId) {
        this.set(FIELD_PICKUPPSDEVIEWID, pickupPSDEViewId);
    }

    @JsonIgnore
    public boolean isPickupPSDEViewIdDirty() {
        return this.contains(FIELD_PICKUPPSDEVIEWID);
    }

    @JsonIgnore
    public String getPickupPSDEViewName() {
        Object objValue = this.get(FIELD_PICKUPPSDEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pickuppsdeviewname")
    public void setPickupPSDEViewName(String pickupPSDEViewName) {
        this.set(FIELD_PICKUPPSDEVIEWNAME, pickupPSDEViewName);
    }

    @JsonIgnore
    public boolean isPickupPSDEViewNameDirty() {
        return this.contains(FIELD_PICKUPPSDEVIEWNAME);
    }

    @JsonIgnore
    public String getPSDEACModeId() {
        Object objValue = this.get(FIELD_PSDEACMODEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeacmodeid")
    public void setPSDEACModeId(String pSDEACModeId) {
        this.set(FIELD_PSDEACMODEID, pSDEACModeId);
    }

    @JsonIgnore
    public boolean isPSDEACModeIdDirty() {
        return this.contains(FIELD_PSDEACMODEID);
    }

    @JsonIgnore
    public String getPSDEACModeName() {
        Object objValue = this.get(FIELD_PSDEACMODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeacmodename")
    public void setPSDEACModeName(String pSDEACModeName) {
        this.set(FIELD_PSDEACMODENAME, pSDEACModeName);
    }

    @JsonIgnore
    public boolean isPSDEACModeNameDirty() {
        return this.contains(FIELD_PSDEACMODENAME);
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
    public String getPSDEUAGroupId() {
        Object objValue = this.get(FIELD_PSDEUAGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeuagroupid")
    public void setPSDEUAGroupId(String pSDEUAGroupId) {
        this.set(FIELD_PSDEUAGROUPID, pSDEUAGroupId);
    }

    @JsonIgnore
    public boolean isPSDEUAGroupIdDirty() {
        return this.contains(FIELD_PSDEUAGROUPID);
    }

    @JsonIgnore
    public String getPSDEUAGroupName() {
        Object objValue = this.get(FIELD_PSDEUAGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeuagroupname")
    public void setPSDEUAGroupName(String pSDEUAGroupName) {
        this.set(FIELD_PSDEUAGROUPNAME, pSDEUAGroupName);
    }

    @JsonIgnore
    public boolean isPSDEUAGroupNameDirty() {
        return this.contains(FIELD_PSDEUAGROUPNAME);
    }

    @JsonIgnore
    public String getTextPSDEFId() {
        Object objValue = this.get(FIELD_TEXTPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="textpsdefid")
    public void setTextPSDEFId(String textPSDEFId) {
        this.set(FIELD_TEXTPSDEFID, textPSDEFId);
    }

    @JsonIgnore
    public boolean isTextPSDEFIdDirty() {
        return this.contains(FIELD_TEXTPSDEFID);
    }

    @JsonIgnore
    public String getTextPSDEFName() {
        Object objValue = this.get(FIELD_TEXTPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="textpsdefname")
    public void setTextPSDEFName(String textPSDEFName) {
        this.set(FIELD_TEXTPSDEFNAME, textPSDEFName);
    }

    @JsonIgnore
    public boolean isTextPSDEFNameDirty() {
        return this.contains(FIELD_TEXTPSDEFNAME);
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
    public String getValuePSDEFId() {
        Object objValue = this.get(FIELD_VALUEPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="valuepsdefid")
    public void setValuePSDEFId(String valuePSDEFId) {
        this.set(FIELD_VALUEPSDEFID, valuePSDEFId);
    }

    @JsonIgnore
    public boolean isValuePSDEFIdDirty() {
        return this.contains(FIELD_VALUEPSDEFID);
    }

    @JsonIgnore
    public String getValuePSDEFName() {
        Object objValue = this.get(FIELD_VALUEPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="valuepsdefname")
    public void setValuePSDEFName(String valuePSDEFName) {
        this.set(FIELD_VALUEPSDEFNAME, valuePSDEFName);
    }

    @JsonIgnore
    public boolean isValuePSDEFNameDirty() {
        return this.contains(FIELD_VALUEPSDEFNAME);
    }

    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDEACModeId();
    }

    public void setSrfkey(String strValue) {
        this.setPSDEACModeId(strValue);
    }

    public List<PSDEACModeItem> getPsdeacmodeitems() {
        return this.psdeacmodeitems;
    }

    public void setPsdeacmodeitems(List<PSDEACModeItem> psdeacmodeitems) {
        this.psdeacmodeitems = psdeacmodeitems;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (strName.equalsIgnoreCase("psdeacmodeitems")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("psdeacmodeitems")) {
            this.init();
            return this.psdeacmodeitems;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSDEACMODE";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSDEACMode item = (PSDEACMode)MAPPER.readValue(new File(strJsonFilePath), PSDEACMode.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSDEACMode) {
            PSDEACMode dst = (PSDEACMode)target;
            if (!bSimple && this.getPsdeacmodeitems() != null) {
                ArrayList<PSDEACModeItem> psdeacmodeitems = new ArrayList<PSDEACModeItem>();
                for (PSDEACModeItem item : this.getPsdeacmodeitems()) {
                    if (bDeepMode) {
                        PSDEACModeItem newitem = new PSDEACModeItem();
                        item.to(newitem, false, bDeepMode);
                        psdeacmodeitems.add(newitem);
                        continue;
                    }
                    psdeacmodeitems.add(item);
                }
                dst.setPsdeacmodeitems(psdeacmodeitems);
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSDEACMode) {
            PSDEACMode src = (PSDEACMode)source;
            if (!bSimple && src.getPsdeacmodeitems() != null) {
                ArrayList<PSDEACModeItem> psdeacmodeitems = new ArrayList<PSDEACModeItem>();
                for (PSDEACModeItem item : src.getPsdeacmodeitems()) {
                    if (bDeepMode) {
                        PSDEACModeItem newItem = new PSDEACModeItem();
                        newItem.from(item, false, bDeepMode);
                        psdeacmodeitems.add(newItem);
                        continue;
                    }
                    psdeacmodeitems.add(item);
                }
                this.setPsdeacmodeitems(psdeacmodeitems);
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

