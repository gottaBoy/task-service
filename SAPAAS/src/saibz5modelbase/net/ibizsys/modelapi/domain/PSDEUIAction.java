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

public class PSDEUIAction
extends PSModelBase {
    public static final String FIELD_ACTIONLEVEL = "actionlevel";
    public static final String FIELD_ACTIONTARGET = "actiontarget";
    public static final String FIELD_BUSYINDICATOR = "busyindicator";
    public static final String FIELD_CAPPSLANRESID = "cappslanresid";
    public static final String FIELD_CAPPSLANRESNAME = "cappslanresname";
    public static final String FIELD_CAPTION = "caption";
    public static final String FIELD_CLOSEEDITVIEW = "closeeditview";
    public static final String FIELD_CMPSLANRESID = "cmpslanresid";
    public static final String FIELD_CMPSLANRESNAME = "cmpslanresname";
    public static final String FIELD_CODENAME = "codename";
    public static final String FIELD_CONFIRMINFO = "confirminfo";
    public static final String FIELD_COUNTERID = "counterid";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CUSTOMCODE = "customcode";
    public static final String FIELD_DATAITEM = "dataitem";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_ENABLERTMODEL = "enablertmodel";
    public static final String FIELD_ENABLEVIEWACTIONS = "enableviewactions";
    public static final String FIELD_EXTENDMODE = "extendmode";
    public static final String FIELD_FRONTPROTYPE = "frontprotype";
    public static final String FIELD_GLOBALFLAG = "globalflag";
    public static final String FIELD_HTMLPAGEURL = "htmlpageurl";
    public static final String FIELD_ITEMOBJ = "itemobj";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MOBPSDEVIEWID = "mobpsdeviewid";
    public static final String FIELD_MOBPSDEVIEWNAME = "mobpsdeviewname";
    public static final String FIELD_NEXTPSDEUIACTIONID = "nextpsdeuiactionid";
    public static final String FIELD_NEXTPSDEUIACTIONNAME = "nextpsdeuiactionname";
    public static final String FIELD_NO2PSDEDATAEXPID = "no2psdedataexpid";
    public static final String FIELD_NO2PSDEDATAEXPNAME = "no2psdedataexpname";
    public static final String FIELD_NOPRIVDM = "noprivdm";
    public static final String FIELD_PARAMITEM = "paramitem";
    public static final String FIELD_PDTVIEWFLAG = "pdtviewflag";
    public static final String FIELD_PSDEACTIONID = "psdeactionid";
    public static final String FIELD_PSDEACTIONNAME = "psdeactionname";
    public static final String FIELD_PSDEDATAEXPID = "psdedataexpid";
    public static final String FIELD_PSDEDATAIMPID = "psdedataimpid";
    public static final String FIELD_PSDEDATAIMPNAME = "psdedataimpname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSDEOPPRIVID = "psdeopprivid";
    public static final String FIELD_PSDEOPPRIVNAME = "psdeopprivname";
    public static final String FIELD_PSDEPRINTID = "psdeprintid";
    public static final String FIELD_PSDEPRINTNAME = "psdeprintname";
    public static final String FIELD_PSDEUIACTIONID = "psdeuiactionid";
    public static final String FIELD_PSDEUIACTIONNAME = "psdeuiactionname";
    public static final String FIELD_PSDEVIEWBASEID = "psdeviewbaseid";
    public static final String FIELD_PSDEVIEWBASENAME = "psdeviewbasename";
    public static final String FIELD_PSDEVIEWLOGICID = "psdeviewlogicid";
    public static final String FIELD_PSDEVIEWLOGICNAME = "psdeviewlogicname";
    public static final String FIELD_PSMODULEID = "psmoduleid";
    public static final String FIELD_PSMODULENAME = "psmodulename";
    public static final String FIELD_PSSYSCOUNTERID = "pssyscounterid";
    public static final String FIELD_PSSYSCOUNTERNAME = "pssyscountername";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    public static final String FIELD_PSSYSIMAGEID = "pssysimageid";
    public static final String FIELD_PSSYSIMAGENAME = "pssysimagename";
    public static final String FIELD_PSSYSPDTVIEWID = "pssyspdtviewid";
    public static final String FIELD_PSSYSPDTVIEWNAME = "pssyspdtviewname";
    public static final String FIELD_PSSYSPFPLUGINID = "pssyspfpluginid";
    public static final String FIELD_PSSYSPFPLUGINNAME = "pssyspfpluginname";
    public static final String FIELD_PSSYSREQITEMID = "pssysreqitemid";
    public static final String FIELD_PSSYSREQITEMNAME = "pssysreqitemname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_PSSYSUIACTIONID = "pssysuiactionid";
    public static final String FIELD_PSSYSUIACTIONNAME = "pssysuiactionname";
    public static final String FIELD_PSSYSVIEWLOGICID = "pssysviewlogicid";
    public static final String FIELD_PSSYSVIEWLOGICNAME = "pssysviewlogicname";
    public static final String FIELD_PSWFID = "pswfid";
    public static final String FIELD_PSWFNAME = "pswfname";
    public static final String FIELD_PSWFLINKID = "pswfplinkid";
    public static final String FIELD_PSWFLINKNAME = "pswfplinkname";
    public static final String FIELD_PSWFPROCESSID = "pswfprocessid";
    public static final String FIELD_PSWFPROCESSNAME = "pswfprocessname";
    public static final String FIELD_PSWFVERSIONID = "pswfversionid";
    public static final String FIELD_PSWFVERSIONNAME = "pswfversionname";
    public static final String FIELD_RELOADDATA = "reloaddata";
    public static final String FIELD_REPPSSYSUIACTIONID = "reppssysuiactionid";
    public static final String FIELD_REPPSSYSUIACTIONNAME = "reppssysuiactionname";
    public static final String FIELD_SMPSLANRESID = "smpslanresid";
    public static final String FIELD_SMPSLANRESNAME = "smpslanresname";
    public static final String FIELD_SUCCESSINFO = "successinfo";
    public static final String FIELD_SYSITEMOBJ = "sysitemobj";
    public static final String FIELD_TEMPLMODE = "templmode";
    public static final String FIELD_TEXTITEM = "textitem";
    public static final String FIELD_TIMEOUT = "timeout";
    public static final String FIELD_TIPPSLANRESID = "tippslanresid";
    public static final String FIELD_TIPPSLANRESNAME = "tippslanresname";
    public static final String FIELD_TODOTASK = "todotask";
    public static final String FIELD_TOOLTIPINFO = "tooltipinfo";
    public static final String FIELD_UATAG = "uatag";
    public static final String FIELD_UATAG2 = "uatag2";
    public static final String FIELD_UATAG3 = "uatag3";
    public static final String FIELD_UATAG4 = "uatag4";
    public static final String FIELD_UIACTIONCODE = "uiactioncode";
    public static final String FIELD_UIACTIONPARAM = "uiactionparam";
    public static final String FIELD_UIACTIONPARAM10 = "uiactionparam10";
    public static final String FIELD_UIACTIONPARAM11 = "uiactionparam11";
    public static final String FIELD_UIACTIONPARAM12 = "uiactionparam12";
    public static final String FIELD_UIACTIONPARAM2 = "uiactionparam2";
    public static final String FIELD_UIACTIONPARAM3 = "uiactionparam3";
    public static final String FIELD_UIACTIONPARAM4 = "uiactionparam4";
    public static final String FIELD_UIACTIONPARAM5 = "uiactionparam5";
    public static final String FIELD_UIACTIONPARAM6 = "uiactionparam6";
    public static final String FIELD_UIACTIONPARAM7 = "uiactionparam7";
    public static final String FIELD_UIACTIONPARAM8 = "uiactionparam8";
    public static final String FIELD_UIACTIONPARAM9 = "uiactionparam9";
    public static final String FIELD_UIACTIONPARAMS = "uiactionparams";
    public static final String FIELD_UIACTIONTYPE = "uiactiontype";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERCONFIRM = "userconfirm";
    public static final String FIELD_USERPARAMS = "userparams";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VIEWACTIONS = "viewactions";
    public static final String FIELD_VIEWLOGICTYPE = "viewlogictype";
    public static final String FIELD_VLEXECMODE = "vlexecmode";

    @JsonIgnore
    public Integer getActionLevel() {
        Object objValue = this.get(FIELD_ACTIONLEVEL);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="actionlevel")
    public void setActionLevel(Integer actionLevel) {
        this.set(FIELD_ACTIONLEVEL, actionLevel);
    }

    @JsonIgnore
    public boolean isActionLevelDirty() {
        return this.contains(FIELD_ACTIONLEVEL);
    }

    @JsonIgnore
    public String getActionTarget() {
        Object objValue = this.get(FIELD_ACTIONTARGET);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="actiontarget")
    public void setActionTarget(String actionTarget) {
        this.set(FIELD_ACTIONTARGET, actionTarget);
    }

    @JsonIgnore
    public boolean isActionTargetDirty() {
        return this.contains(FIELD_ACTIONTARGET);
    }

    @JsonIgnore
    public Integer getBusyIndicator() {
        Object objValue = this.get(FIELD_BUSYINDICATOR);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="busyindicator")
    public void setBusyIndicator(Integer busyIndicator) {
        this.set(FIELD_BUSYINDICATOR, busyIndicator);
    }

    @JsonIgnore
    public boolean isBusyIndicatorDirty() {
        return this.contains(FIELD_BUSYINDICATOR);
    }

    @JsonIgnore
    public String getCapPSLanResId() {
        Object objValue = this.get(FIELD_CAPPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cappslanresid")
    public void setCapPSLanResId(String capPSLanResId) {
        this.set(FIELD_CAPPSLANRESID, capPSLanResId);
    }

    @JsonIgnore
    public boolean isCapPSLanResIdDirty() {
        return this.contains(FIELD_CAPPSLANRESID);
    }

    @JsonIgnore
    public String getCapPSLanResName() {
        Object objValue = this.get(FIELD_CAPPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cappslanresname")
    public void setCapPSLanResName(String capPSLanResName) {
        this.set(FIELD_CAPPSLANRESNAME, capPSLanResName);
    }

    @JsonIgnore
    public boolean isCapPSLanResNameDirty() {
        return this.contains(FIELD_CAPPSLANRESNAME);
    }

    @JsonIgnore
    public String getCaption() {
        Object objValue = this.get(FIELD_CAPTION);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="caption")
    public void setCaption(String caption) {
        this.set(FIELD_CAPTION, caption);
    }

    @JsonIgnore
    public boolean isCaptionDirty() {
        return this.contains(FIELD_CAPTION);
    }

    @JsonIgnore
    public Integer getCloseEditView() {
        Object objValue = this.get(FIELD_CLOSEEDITVIEW);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="closeeditview")
    public void setCloseEditView(Integer closeEditView) {
        this.set(FIELD_CLOSEEDITVIEW, closeEditView);
    }

    @JsonIgnore
    public boolean isCloseEditViewDirty() {
        return this.contains(FIELD_CLOSEEDITVIEW);
    }

    @JsonIgnore
    public String getCMPSLanResId() {
        Object objValue = this.get(FIELD_CMPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cmpslanresid")
    public void setCMPSLanResId(String cMPSLanResId) {
        this.set(FIELD_CMPSLANRESID, cMPSLanResId);
    }

    @JsonIgnore
    public boolean isCMPSLanResIdDirty() {
        return this.contains(FIELD_CMPSLANRESID);
    }

    @JsonIgnore
    public String getCMPSLanResName() {
        Object objValue = this.get(FIELD_CMPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cmpslanresname")
    public void setCMPSLanResName(String cMPSLanResName) {
        this.set(FIELD_CMPSLANRESNAME, cMPSLanResName);
    }

    @JsonIgnore
    public boolean isCMPSLanResNameDirty() {
        return this.contains(FIELD_CMPSLANRESNAME);
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
    public String getConfirmInfo() {
        Object objValue = this.get(FIELD_CONFIRMINFO);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="confirminfo")
    public void setConfirmInfo(String confirmInfo) {
        this.set(FIELD_CONFIRMINFO, confirmInfo);
    }

    @JsonIgnore
    public boolean isConfirmInfoDirty() {
        return this.contains(FIELD_CONFIRMINFO);
    }

    @JsonIgnore
    public String getCounterId() {
        Object objValue = this.get(FIELD_COUNTERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="counterid")
    public void setCounterId(String counterId) {
        this.set(FIELD_COUNTERID, counterId);
    }

    @JsonIgnore
    public boolean isCounterIdDirty() {
        return this.contains(FIELD_COUNTERID);
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
    public String getDataItem() {
        Object objValue = this.get(FIELD_DATAITEM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dataitem")
    public void setDataItem(String dataItem) {
        this.set(FIELD_DATAITEM, dataItem);
    }

    @JsonIgnore
    public boolean isDataItemDirty() {
        return this.contains(FIELD_DATAITEM);
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
    public Integer getEnableRTModel() {
        Object objValue = this.get(FIELD_ENABLERTMODEL);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablertmodel")
    public void setEnableRTModel(Integer enableRTModel) {
        this.set(FIELD_ENABLERTMODEL, enableRTModel);
    }

    @JsonIgnore
    public boolean isEnableRTModelDirty() {
        return this.contains(FIELD_ENABLERTMODEL);
    }

    @JsonIgnore
    public Integer getEnableViewActions() {
        Object objValue = this.get(FIELD_ENABLEVIEWACTIONS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enableviewactions")
    public void setEnableViewActions(Integer enableViewActions) {
        this.set(FIELD_ENABLEVIEWACTIONS, enableViewActions);
    }

    @JsonIgnore
    public boolean isEnableViewActionsDirty() {
        return this.contains(FIELD_ENABLEVIEWACTIONS);
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
    public String getFrontProType() {
        Object objValue = this.get(FIELD_FRONTPROTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="frontprotype")
    public void setFrontProType(String frontProType) {
        this.set(FIELD_FRONTPROTYPE, frontProType);
    }

    @JsonIgnore
    public boolean isFrontProTypeDirty() {
        return this.contains(FIELD_FRONTPROTYPE);
    }

    @JsonIgnore
    public Integer getGlobalFlag() {
        Object objValue = this.get(FIELD_GLOBALFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="globalflag")
    public void setGlobalFlag(Integer globalFlag) {
        this.set(FIELD_GLOBALFLAG, globalFlag);
    }

    @JsonIgnore
    public boolean isGlobalFlagDirty() {
        return this.contains(FIELD_GLOBALFLAG);
    }

    @JsonIgnore
    public String getHtmlPageUrl() {
        Object objValue = this.get(FIELD_HTMLPAGEURL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="htmlpageurl")
    public void setHtmlPageUrl(String htmlPageUrl) {
        this.set(FIELD_HTMLPAGEURL, htmlPageUrl);
    }

    @JsonIgnore
    public boolean isHtmlPageUrlDirty() {
        return this.contains(FIELD_HTMLPAGEURL);
    }

    @JsonIgnore
    public String getItemObj() {
        Object objValue = this.get(FIELD_ITEMOBJ);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="itemobj")
    public void setItemObj(String itemObj) {
        this.set(FIELD_ITEMOBJ, itemObj);
    }

    @JsonIgnore
    public boolean isItemObjDirty() {
        return this.contains(FIELD_ITEMOBJ);
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
    public String getMobPSDEViewId() {
        Object objValue = this.get(FIELD_MOBPSDEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobpsdeviewid")
    public void setMobPSDEViewId(String mobPSDEViewId) {
        this.set(FIELD_MOBPSDEVIEWID, mobPSDEViewId);
    }

    @JsonIgnore
    public boolean isMobPSDEViewIdDirty() {
        return this.contains(FIELD_MOBPSDEVIEWID);
    }

    @JsonIgnore
    public String getMobPSDEViewName() {
        Object objValue = this.get(FIELD_MOBPSDEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobpsdeviewname")
    public void setMobPSDEViewName(String mobPSDEViewName) {
        this.set(FIELD_MOBPSDEVIEWNAME, mobPSDEViewName);
    }

    @JsonIgnore
    public boolean isMobPSDEViewNameDirty() {
        return this.contains(FIELD_MOBPSDEVIEWNAME);
    }

    @JsonIgnore
    public String getNextPSDEUIActionId() {
        Object objValue = this.get(FIELD_NEXTPSDEUIACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="nextpsdeuiactionid")
    public void setNextPSDEUIActionId(String nextPSDEUIActionId) {
        this.set(FIELD_NEXTPSDEUIACTIONID, nextPSDEUIActionId);
    }

    @JsonIgnore
    public boolean isNextPSDEUIActionIdDirty() {
        return this.contains(FIELD_NEXTPSDEUIACTIONID);
    }

    @JsonIgnore
    public String getNextPSDEUIActionName() {
        Object objValue = this.get(FIELD_NEXTPSDEUIACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="nextpsdeuiactionname")
    public void setNextPSDEUIActionName(String nextPSDEUIActionName) {
        this.set(FIELD_NEXTPSDEUIACTIONNAME, nextPSDEUIActionName);
    }

    @JsonIgnore
    public boolean isNextPSDEUIActionNameDirty() {
        return this.contains(FIELD_NEXTPSDEUIACTIONNAME);
    }

    @JsonIgnore
    public String getNo2PSDEDataExpId() {
        Object objValue = this.get(FIELD_NO2PSDEDATAEXPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no2psdedataexpid")
    public void setNo2PSDEDataExpId(String no2PSDEDataExpId) {
        this.set(FIELD_NO2PSDEDATAEXPID, no2PSDEDataExpId);
    }

    @JsonIgnore
    public boolean isNo2PSDEDataExpIdDirty() {
        return this.contains(FIELD_NO2PSDEDATAEXPID);
    }

    @JsonIgnore
    public String getNo2PSDEDataExpName() {
        Object objValue = this.get(FIELD_NO2PSDEDATAEXPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no2psdedataexpname")
    public void setNo2PSDEDataExpName(String no2PSDEDataExpName) {
        this.set(FIELD_NO2PSDEDATAEXPNAME, no2PSDEDataExpName);
    }

    @JsonIgnore
    public boolean isNo2PSDEDataExpNameDirty() {
        return this.contains(FIELD_NO2PSDEDATAEXPNAME);
    }

    @JsonIgnore
    public Integer getNoPrivDM() {
        Object objValue = this.get(FIELD_NOPRIVDM);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="noprivdm")
    public void setNoPrivDM(Integer noPrivDM) {
        this.set(FIELD_NOPRIVDM, noPrivDM);
    }

    @JsonIgnore
    public boolean isNoPrivDMDirty() {
        return this.contains(FIELD_NOPRIVDM);
    }

    @JsonIgnore
    public String getParamItem() {
        Object objValue = this.get(FIELD_PARAMITEM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="paramitem")
    public void setParamItem(String paramItem) {
        this.set(FIELD_PARAMITEM, paramItem);
    }

    @JsonIgnore
    public boolean isParamItemDirty() {
        return this.contains(FIELD_PARAMITEM);
    }

    @JsonIgnore
    public Integer getPDTViewFlag() {
        Object objValue = this.get(FIELD_PDTVIEWFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="pdtviewflag")
    public void setPDTViewFlag(Integer pDTViewFlag) {
        this.set(FIELD_PDTVIEWFLAG, pDTViewFlag);
    }

    @JsonIgnore
    public boolean isPDTViewFlagDirty() {
        return this.contains(FIELD_PDTVIEWFLAG);
    }

    @JsonIgnore
    public String getPSDEActionId() {
        Object objValue = this.get(FIELD_PSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeactionid")
    public void setPSDEActionId(String pSDEActionId) {
        this.set(FIELD_PSDEACTIONID, pSDEActionId);
    }

    @JsonIgnore
    public boolean isPSDEActionIdDirty() {
        return this.contains(FIELD_PSDEACTIONID);
    }

    @JsonIgnore
    public String getPSDEActionName() {
        Object objValue = this.get(FIELD_PSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeactionname")
    public void setPSDEActionName(String pSDEActionName) {
        this.set(FIELD_PSDEACTIONNAME, pSDEActionName);
    }

    @JsonIgnore
    public boolean isPSDEActionNameDirty() {
        return this.contains(FIELD_PSDEACTIONNAME);
    }

    @JsonIgnore
    public String getPSDEDataExpId() {
        Object objValue = this.get(FIELD_PSDEDATAEXPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedataexpid")
    public void setPSDEDataExpId(String pSDEDataExpId) {
        this.set(FIELD_PSDEDATAEXPID, pSDEDataExpId);
    }

    @JsonIgnore
    public boolean isPSDEDataExpIdDirty() {
        return this.contains(FIELD_PSDEDATAEXPID);
    }

    @JsonIgnore
    public String getPSDEDataImpId() {
        Object objValue = this.get(FIELD_PSDEDATAIMPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedataimpid")
    public void setPSDEDataImpId(String pSDEDataImpId) {
        this.set(FIELD_PSDEDATAIMPID, pSDEDataImpId);
    }

    @JsonIgnore
    public boolean isPSDEDataImpIdDirty() {
        return this.contains(FIELD_PSDEDATAIMPID);
    }

    @JsonIgnore
    public String getPSDEDataImpName() {
        Object objValue = this.get(FIELD_PSDEDATAIMPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedataimpname")
    public void setPSDEDataImpName(String pSDEDataImpName) {
        this.set(FIELD_PSDEDATAIMPNAME, pSDEDataImpName);
    }

    @JsonIgnore
    public boolean isPSDEDataImpNameDirty() {
        return this.contains(FIELD_PSDEDATAIMPNAME);
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
    public String getPSDEOPPrivId() {
        Object objValue = this.get(FIELD_PSDEOPPRIVID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeopprivid")
    public void setPSDEOPPrivId(String pSDEOPPrivId) {
        this.set(FIELD_PSDEOPPRIVID, pSDEOPPrivId);
    }

    @JsonIgnore
    public boolean isPSDEOPPrivIdDirty() {
        return this.contains(FIELD_PSDEOPPRIVID);
    }

    @JsonIgnore
    public String getPSDEOPPrivName() {
        Object objValue = this.get(FIELD_PSDEOPPRIVNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeopprivname")
    public void setPSDEOPPrivName(String pSDEOPPrivName) {
        this.set(FIELD_PSDEOPPRIVNAME, pSDEOPPrivName);
    }

    @JsonIgnore
    public boolean isPSDEOPPrivNameDirty() {
        return this.contains(FIELD_PSDEOPPRIVNAME);
    }

    @JsonIgnore
    public String getPSDEPrintId() {
        Object objValue = this.get(FIELD_PSDEPRINTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeprintid")
    public void setPSDEPrintId(String pSDEPrintId) {
        this.set(FIELD_PSDEPRINTID, pSDEPrintId);
    }

    @JsonIgnore
    public boolean isPSDEPrintIdDirty() {
        return this.contains(FIELD_PSDEPRINTID);
    }

    @JsonIgnore
    public String getPSDEPrintName() {
        Object objValue = this.get(FIELD_PSDEPRINTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeprintname")
    public void setPSDEPrintName(String pSDEPrintName) {
        this.set(FIELD_PSDEPRINTNAME, pSDEPrintName);
    }

    @JsonIgnore
    public boolean isPSDEPrintNameDirty() {
        return this.contains(FIELD_PSDEPRINTNAME);
    }

    @JsonIgnore
    public String getPSDEUIActionId() {
        Object objValue = this.get(FIELD_PSDEUIACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeuiactionid")
    public void setPSDEUIActionId(String pSDEUIActionId) {
        this.set(FIELD_PSDEUIACTIONID, pSDEUIActionId);
    }

    @JsonIgnore
    public boolean isPSDEUIActionIdDirty() {
        return this.contains(FIELD_PSDEUIACTIONID);
    }

    @JsonIgnore
    public String getPSDEUIActionName() {
        Object objValue = this.get(FIELD_PSDEUIACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeuiactionname")
    public void setPSDEUIActionName(String pSDEUIActionName) {
        this.set(FIELD_PSDEUIACTIONNAME, pSDEUIActionName);
    }

    @JsonIgnore
    public boolean isPSDEUIActionNameDirty() {
        return this.contains(FIELD_PSDEUIACTIONNAME);
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
    public String getPSDEViewLogicId() {
        Object objValue = this.get(FIELD_PSDEVIEWLOGICID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeviewlogicid")
    public void setPSDEViewLogicId(String pSDEViewLogicId) {
        this.set(FIELD_PSDEVIEWLOGICID, pSDEViewLogicId);
    }

    @JsonIgnore
    public boolean isPSDEViewLogicIdDirty() {
        return this.contains(FIELD_PSDEVIEWLOGICID);
    }

    @JsonIgnore
    public String getPSDEViewLogicName() {
        Object objValue = this.get(FIELD_PSDEVIEWLOGICNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeviewlogicname")
    public void setPSDEViewLogicName(String pSDEViewLogicName) {
        this.set(FIELD_PSDEVIEWLOGICNAME, pSDEViewLogicName);
    }

    @JsonIgnore
    public boolean isPSDEViewLogicNameDirty() {
        return this.contains(FIELD_PSDEVIEWLOGICNAME);
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
    public String getPSSysCounterId() {
        Object objValue = this.get(FIELD_PSSYSCOUNTERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscounterid")
    public void setPSSysCounterId(String pSSysCounterId) {
        this.set(FIELD_PSSYSCOUNTERID, pSSysCounterId);
    }

    @JsonIgnore
    public boolean isPSSysCounterIdDirty() {
        return this.contains(FIELD_PSSYSCOUNTERID);
    }

    @JsonIgnore
    public String getPSSysCounterName() {
        Object objValue = this.get(FIELD_PSSYSCOUNTERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscountername")
    public void setPSSysCounterName(String pSSysCounterName) {
        this.set(FIELD_PSSYSCOUNTERNAME, pSSysCounterName);
    }

    @JsonIgnore
    public boolean isPSSysCounterNameDirty() {
        return this.contains(FIELD_PSSYSCOUNTERNAME);
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
    public String getPSSysImageId() {
        Object objValue = this.get(FIELD_PSSYSIMAGEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysimageid")
    public void setPSSysImageId(String pSSysImageId) {
        this.set(FIELD_PSSYSIMAGEID, pSSysImageId);
    }

    @JsonIgnore
    public boolean isPSSysImageIdDirty() {
        return this.contains(FIELD_PSSYSIMAGEID);
    }

    @JsonIgnore
    public String getPSSysImageName() {
        Object objValue = this.get(FIELD_PSSYSIMAGENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysimagename")
    public void setPSSysImageName(String pSSysImageName) {
        this.set(FIELD_PSSYSIMAGENAME, pSSysImageName);
    }

    @JsonIgnore
    public boolean isPSSysImageNameDirty() {
        return this.contains(FIELD_PSSYSIMAGENAME);
    }

    @JsonIgnore
    public String getPSSysPDTViewId() {
        Object objValue = this.get(FIELD_PSSYSPDTVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyspdtviewid")
    public void setPSSysPDTViewId(String pSSysPDTViewId) {
        this.set(FIELD_PSSYSPDTVIEWID, pSSysPDTViewId);
    }

    @JsonIgnore
    public boolean isPSSysPDTViewIdDirty() {
        return this.contains(FIELD_PSSYSPDTVIEWID);
    }

    @JsonIgnore
    public String getPSSysPDTViewName() {
        Object objValue = this.get(FIELD_PSSYSPDTVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyspdtviewname")
    public void setPSSysPDTViewName(String pSSysPDTViewName) {
        this.set(FIELD_PSSYSPDTVIEWNAME, pSSysPDTViewName);
    }

    @JsonIgnore
    public boolean isPSSysPDTViewNameDirty() {
        return this.contains(FIELD_PSSYSPDTVIEWNAME);
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
    public String getPSSysReqItemId() {
        Object objValue = this.get(FIELD_PSSYSREQITEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysreqitemid")
    public void setPSSysReqItemId(String pSSysReqItemId) {
        this.set(FIELD_PSSYSREQITEMID, pSSysReqItemId);
    }

    @JsonIgnore
    public boolean isPSSysReqItemIdDirty() {
        return this.contains(FIELD_PSSYSREQITEMID);
    }

    @JsonIgnore
    public String getPSSysReqItemName() {
        Object objValue = this.get(FIELD_PSSYSREQITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysreqitemname")
    public void setPSSysReqItemName(String pSSysReqItemName) {
        this.set(FIELD_PSSYSREQITEMNAME, pSSysReqItemName);
    }

    @JsonIgnore
    public boolean isPSSysReqItemNameDirty() {
        return this.contains(FIELD_PSSYSREQITEMNAME);
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
    public String getPSSysUIActionId() {
        Object objValue = this.get(FIELD_PSSYSUIACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysuiactionid")
    public void setPSSysUIActionId(String pSSysUIActionId) {
        this.set(FIELD_PSSYSUIACTIONID, pSSysUIActionId);
    }

    @JsonIgnore
    public boolean isPSSysUIActionIdDirty() {
        return this.contains(FIELD_PSSYSUIACTIONID);
    }

    @JsonIgnore
    public String getPSSysUIActionName() {
        Object objValue = this.get(FIELD_PSSYSUIACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysuiactionname")
    public void setPSSysUIActionName(String pSSysUIActionName) {
        this.set(FIELD_PSSYSUIACTIONNAME, pSSysUIActionName);
    }

    @JsonIgnore
    public boolean isPSSysUIActionNameDirty() {
        return this.contains(FIELD_PSSYSUIACTIONNAME);
    }

    @JsonIgnore
    public String getPSSysViewLogicId() {
        Object objValue = this.get(FIELD_PSSYSVIEWLOGICID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysviewlogicid")
    public void setPSSysViewLogicId(String pSSysViewLogicId) {
        this.set(FIELD_PSSYSVIEWLOGICID, pSSysViewLogicId);
    }

    @JsonIgnore
    public boolean isPSSysViewLogicIdDirty() {
        return this.contains(FIELD_PSSYSVIEWLOGICID);
    }

    @JsonIgnore
    public String getPSSysViewLogicName() {
        Object objValue = this.get(FIELD_PSSYSVIEWLOGICNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysviewlogicname")
    public void setPSSysViewLogicName(String pSSysViewLogicName) {
        this.set(FIELD_PSSYSVIEWLOGICNAME, pSSysViewLogicName);
    }

    @JsonIgnore
    public boolean isPSSysViewLogicNameDirty() {
        return this.contains(FIELD_PSSYSVIEWLOGICNAME);
    }

    @JsonIgnore
    public String getPSWFId() {
        Object objValue = this.get(FIELD_PSWFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswfid")
    public void setPSWFId(String pSWFId) {
        this.set(FIELD_PSWFID, pSWFId);
    }

    @JsonIgnore
    public boolean isPSWFIdDirty() {
        return this.contains(FIELD_PSWFID);
    }

    @JsonIgnore
    public String getPSWFName() {
        Object objValue = this.get(FIELD_PSWFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswfname")
    public void setPSWFName(String pSWFName) {
        this.set(FIELD_PSWFNAME, pSWFName);
    }

    @JsonIgnore
    public boolean isPSWFNameDirty() {
        return this.contains(FIELD_PSWFNAME);
    }

    @JsonIgnore
    public String getPSWFLinkId() {
        Object objValue = this.get(FIELD_PSWFLINKID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswfplinkid")
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

    @JsonProperty(value="pswfplinkname")
    public void setPSWFLinkName(String pSWFLinkName) {
        this.set(FIELD_PSWFLINKNAME, pSWFLinkName);
    }

    @JsonIgnore
    public boolean isPSWFLinkNameDirty() {
        return this.contains(FIELD_PSWFLINKNAME);
    }

    @JsonIgnore
    public String getPSWFProcessId() {
        Object objValue = this.get(FIELD_PSWFPROCESSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswfprocessid")
    public void setPSWFProcessId(String pSWFProcessId) {
        this.set(FIELD_PSWFPROCESSID, pSWFProcessId);
    }

    @JsonIgnore
    public boolean isPSWFProcessIdDirty() {
        return this.contains(FIELD_PSWFPROCESSID);
    }

    @JsonIgnore
    public String getPSWFProcessName() {
        Object objValue = this.get(FIELD_PSWFPROCESSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswfprocessname")
    public void setPSWFProcessName(String pSWFProcessName) {
        this.set(FIELD_PSWFPROCESSNAME, pSWFProcessName);
    }

    @JsonIgnore
    public boolean isPSWFProcessNameDirty() {
        return this.contains(FIELD_PSWFPROCESSNAME);
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
    public Integer getReloadData() {
        Object objValue = this.get(FIELD_RELOADDATA);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="reloaddata")
    public void setReloadData(Integer reloadData) {
        this.set(FIELD_RELOADDATA, reloadData);
    }

    @JsonIgnore
    public boolean isReloadDataDirty() {
        return this.contains(FIELD_RELOADDATA);
    }

    @JsonIgnore
    public String getRepPSSysUIActionId() {
        Object objValue = this.get(FIELD_REPPSSYSUIACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="reppssysuiactionid")
    public void setRepPSSysUIActionId(String repPSSysUIActionId) {
        this.set(FIELD_REPPSSYSUIACTIONID, repPSSysUIActionId);
    }

    @JsonIgnore
    public boolean isRepPSSysUIActionIdDirty() {
        return this.contains(FIELD_REPPSSYSUIACTIONID);
    }

    @JsonIgnore
    public String getRepPSSysUIActionName() {
        Object objValue = this.get(FIELD_REPPSSYSUIACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="reppssysuiactionname")
    public void setRepPSSysUIActionName(String repPSSysUIActionName) {
        this.set(FIELD_REPPSSYSUIACTIONNAME, repPSSysUIActionName);
    }

    @JsonIgnore
    public boolean isRepPSSysUIActionNameDirty() {
        return this.contains(FIELD_REPPSSYSUIACTIONNAME);
    }

    @JsonIgnore
    public String getSMPSLanResId() {
        Object objValue = this.get(FIELD_SMPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="smpslanresid")
    public void setSMPSLanResId(String sMPSLanResId) {
        this.set(FIELD_SMPSLANRESID, sMPSLanResId);
    }

    @JsonIgnore
    public boolean isSMPSLanResIdDirty() {
        return this.contains(FIELD_SMPSLANRESID);
    }

    @JsonIgnore
    public String getSMPSLanResName() {
        Object objValue = this.get(FIELD_SMPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="smpslanresname")
    public void setSMPSLanResName(String sMPSLanResName) {
        this.set(FIELD_SMPSLANRESNAME, sMPSLanResName);
    }

    @JsonIgnore
    public boolean isSMPSLanResNameDirty() {
        return this.contains(FIELD_SMPSLANRESNAME);
    }

    @JsonIgnore
    public String getSuccessInfo() {
        Object objValue = this.get(FIELD_SUCCESSINFO);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="successinfo")
    public void setSuccessInfo(String successInfo) {
        this.set(FIELD_SUCCESSINFO, successInfo);
    }

    @JsonIgnore
    public boolean isSuccessInfoDirty() {
        return this.contains(FIELD_SUCCESSINFO);
    }

    @JsonIgnore
    public String getSysItemObj() {
        Object objValue = this.get(FIELD_SYSITEMOBJ);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="sysitemobj")
    public void setSysItemObj(String sysItemObj) {
        this.set(FIELD_SYSITEMOBJ, sysItemObj);
    }

    @JsonIgnore
    public boolean isSysItemObjDirty() {
        return this.contains(FIELD_SYSITEMOBJ);
    }

    @JsonIgnore
    public Integer getTemplMode() {
        Object objValue = this.get(FIELD_TEMPLMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="templmode")
    public void setTemplMode(Integer templMode) {
        this.set(FIELD_TEMPLMODE, templMode);
    }

    @JsonIgnore
    public boolean isTemplModeDirty() {
        return this.contains(FIELD_TEMPLMODE);
    }

    @JsonIgnore
    public String getTextItem() {
        Object objValue = this.get(FIELD_TEXTITEM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="textitem")
    public void setTextItem(String textItem) {
        this.set(FIELD_TEXTITEM, textItem);
    }

    @JsonIgnore
    public boolean isTextItemDirty() {
        return this.contains(FIELD_TEXTITEM);
    }

    @JsonIgnore
    public Integer getTimeout() {
        Object objValue = this.get(FIELD_TIMEOUT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="timeout")
    public void setTimeout(Integer timeout) {
        this.set(FIELD_TIMEOUT, timeout);
    }

    @JsonIgnore
    public boolean isTimeoutDirty() {
        return this.contains(FIELD_TIMEOUT);
    }

    @JsonIgnore
    public String getTipPSLanResId() {
        Object objValue = this.get(FIELD_TIPPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="tippslanresid")
    public void setTipPSLanResId(String tipPSLanResId) {
        this.set(FIELD_TIPPSLANRESID, tipPSLanResId);
    }

    @JsonIgnore
    public boolean isTipPSLanResIdDirty() {
        return this.contains(FIELD_TIPPSLANRESID);
    }

    @JsonIgnore
    public String getTipPSLanResName() {
        Object objValue = this.get(FIELD_TIPPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="tippslanresname")
    public void setTipPSLanResName(String tipPSLanResName) {
        this.set(FIELD_TIPPSLANRESNAME, tipPSLanResName);
    }

    @JsonIgnore
    public boolean isTipPSLanResNameDirty() {
        return this.contains(FIELD_TIPPSLANRESNAME);
    }

    @JsonIgnore
    public String getToDoTask() {
        Object objValue = this.get(FIELD_TODOTASK);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="todotask")
    public void setToDoTask(String toDoTask) {
        this.set(FIELD_TODOTASK, toDoTask);
    }

    @JsonIgnore
    public boolean isToDoTaskDirty() {
        return this.contains(FIELD_TODOTASK);
    }

    @JsonIgnore
    public String getTooltipInfo() {
        Object objValue = this.get(FIELD_TOOLTIPINFO);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="tooltipinfo")
    public void setTooltipInfo(String tooltipInfo) {
        this.set(FIELD_TOOLTIPINFO, tooltipInfo);
    }

    @JsonIgnore
    public boolean isTooltipInfoDirty() {
        return this.contains(FIELD_TOOLTIPINFO);
    }

    @JsonIgnore
    public String getUATag() {
        Object objValue = this.get(FIELD_UATAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="uatag")
    public void setUATag(String uATag) {
        this.set(FIELD_UATAG, uATag);
    }

    @JsonIgnore
    public boolean isUATagDirty() {
        return this.contains(FIELD_UATAG);
    }

    @JsonIgnore
    public String getUATag2() {
        Object objValue = this.get(FIELD_UATAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="uatag2")
    public void setUATag2(String uATag2) {
        this.set(FIELD_UATAG2, uATag2);
    }

    @JsonIgnore
    public boolean isUATag2Dirty() {
        return this.contains(FIELD_UATAG2);
    }

    @JsonIgnore
    public String getUATag3() {
        Object objValue = this.get(FIELD_UATAG3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="uatag3")
    public void setUATag3(String uATag3) {
        this.set(FIELD_UATAG3, uATag3);
    }

    @JsonIgnore
    public boolean isUATag3Dirty() {
        return this.contains(FIELD_UATAG3);
    }

    @JsonIgnore
    public String getUATag4() {
        Object objValue = this.get(FIELD_UATAG4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="uatag4")
    public void setUATag4(String uATag4) {
        this.set(FIELD_UATAG4, uATag4);
    }

    @JsonIgnore
    public boolean isUATag4Dirty() {
        return this.contains(FIELD_UATAG4);
    }

    @JsonIgnore
    public String getUIActionCode() {
        Object objValue = this.get(FIELD_UIACTIONCODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="uiactioncode")
    public void setUIActionCode(String uIActionCode) {
        this.set(FIELD_UIACTIONCODE, uIActionCode);
    }

    @JsonIgnore
    public boolean isUIActionCodeDirty() {
        return this.contains(FIELD_UIACTIONCODE);
    }

    @JsonIgnore
    public String getUIActionParam() {
        Object objValue = this.get(FIELD_UIACTIONPARAM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="uiactionparam")
    public void setUIActionParam(String uIActionParam) {
        this.set(FIELD_UIACTIONPARAM, uIActionParam);
    }

    @JsonIgnore
    public boolean isUIActionParamDirty() {
        return this.contains(FIELD_UIACTIONPARAM);
    }

    @JsonIgnore
    public Double getUIActionParam10() {
        Object objValue = this.get(FIELD_UIACTIONPARAM10);
        if (objValue == null) {
            return null;
        }
        return (Double)objValue;
    }

    @JsonProperty(value="uiactionparam10")
    public void setUIActionParam10(Double uIActionParam10) {
        this.set(FIELD_UIACTIONPARAM10, uIActionParam10);
    }

    @JsonIgnore
    public boolean isUIActionParam10Dirty() {
        return this.contains(FIELD_UIACTIONPARAM10);
    }

    @JsonIgnore
    public Integer getUIActionParam11() {
        Object objValue = this.get(FIELD_UIACTIONPARAM11);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="uiactionparam11")
    public void setUIActionParam11(Integer uIActionParam11) {
        this.set(FIELD_UIACTIONPARAM11, uIActionParam11);
    }

    @JsonIgnore
    public boolean isUIActionParam11Dirty() {
        return this.contains(FIELD_UIACTIONPARAM11);
    }

    @JsonIgnore
    public Integer getUIActionParam12() {
        Object objValue = this.get(FIELD_UIACTIONPARAM12);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="uiactionparam12")
    public void setUIActionParam12(Integer uIActionParam12) {
        this.set(FIELD_UIACTIONPARAM12, uIActionParam12);
    }

    @JsonIgnore
    public boolean isUIActionParam12Dirty() {
        return this.contains(FIELD_UIACTIONPARAM12);
    }

    @JsonIgnore
    public String getUIActionParam2() {
        Object objValue = this.get(FIELD_UIACTIONPARAM2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="uiactionparam2")
    public void setUIActionParam2(String uIActionParam2) {
        this.set(FIELD_UIACTIONPARAM2, uIActionParam2);
    }

    @JsonIgnore
    public boolean isUIActionParam2Dirty() {
        return this.contains(FIELD_UIACTIONPARAM2);
    }

    @JsonIgnore
    public String getUIActionParam3() {
        Object objValue = this.get(FIELD_UIACTIONPARAM3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="uiactionparam3")
    public void setUIActionParam3(String uIActionParam3) {
        this.set(FIELD_UIACTIONPARAM3, uIActionParam3);
    }

    @JsonIgnore
    public boolean isUIActionParam3Dirty() {
        return this.contains(FIELD_UIACTIONPARAM3);
    }

    @JsonIgnore
    public String getUIActionParam4() {
        Object objValue = this.get(FIELD_UIACTIONPARAM4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="uiactionparam4")
    public void setUIActionParam4(String uIActionParam4) {
        this.set(FIELD_UIACTIONPARAM4, uIActionParam4);
    }

    @JsonIgnore
    public boolean isUIActionParam4Dirty() {
        return this.contains(FIELD_UIACTIONPARAM4);
    }

    @JsonIgnore
    public Integer getUIActionParam5() {
        Object objValue = this.get(FIELD_UIACTIONPARAM5);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="uiactionparam5")
    public void setUIActionParam5(Integer uIActionParam5) {
        this.set(FIELD_UIACTIONPARAM5, uIActionParam5);
    }

    @JsonIgnore
    public boolean isUIActionParam5Dirty() {
        return this.contains(FIELD_UIACTIONPARAM5);
    }

    @JsonIgnore
    public Integer getUIActionParam6() {
        Object objValue = this.get(FIELD_UIACTIONPARAM6);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="uiactionparam6")
    public void setUIActionParam6(Integer uIActionParam6) {
        this.set(FIELD_UIACTIONPARAM6, uIActionParam6);
    }

    @JsonIgnore
    public boolean isUIActionParam6Dirty() {
        return this.contains(FIELD_UIACTIONPARAM6);
    }

    @JsonIgnore
    public Integer getUIActionParam7() {
        Object objValue = this.get(FIELD_UIACTIONPARAM7);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="uiactionparam7")
    public void setUIActionParam7(Integer uIActionParam7) {
        this.set(FIELD_UIACTIONPARAM7, uIActionParam7);
    }

    @JsonIgnore
    public boolean isUIActionParam7Dirty() {
        return this.contains(FIELD_UIACTIONPARAM7);
    }

    @JsonIgnore
    public Integer getUIActionParam8() {
        Object objValue = this.get(FIELD_UIACTIONPARAM8);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="uiactionparam8")
    public void setUIActionParam8(Integer uIActionParam8) {
        this.set(FIELD_UIACTIONPARAM8, uIActionParam8);
    }

    @JsonIgnore
    public boolean isUIActionParam8Dirty() {
        return this.contains(FIELD_UIACTIONPARAM8);
    }

    @JsonIgnore
    public Double getUIActionParam9() {
        Object objValue = this.get(FIELD_UIACTIONPARAM9);
        if (objValue == null) {
            return null;
        }
        return (Double)objValue;
    }

    @JsonProperty(value="uiactionparam9")
    public void setUIActionParam9(Double uIActionParam9) {
        this.set(FIELD_UIACTIONPARAM9, uIActionParam9);
    }

    @JsonIgnore
    public boolean isUIActionParam9Dirty() {
        return this.contains(FIELD_UIACTIONPARAM9);
    }

    @JsonIgnore
    public String getUIActionParams() {
        Object objValue = this.get(FIELD_UIACTIONPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="uiactionparams")
    public void setUIActionParams(String uIActionParams) {
        this.set(FIELD_UIACTIONPARAMS, uIActionParams);
    }

    @JsonIgnore
    public boolean isUIActionParamsDirty() {
        return this.contains(FIELD_UIACTIONPARAMS);
    }

    @JsonIgnore
    public String getUIActionType() {
        Object objValue = this.get(FIELD_UIACTIONTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="uiactiontype")
    public void setUIActionType(String uIActionType) {
        this.set(FIELD_UIACTIONTYPE, uIActionType);
    }

    @JsonIgnore
    public boolean isUIActionTypeDirty() {
        return this.contains(FIELD_UIACTIONTYPE);
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
    public Integer getUserConfirm() {
        Object objValue = this.get(FIELD_USERCONFIRM);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="userconfirm")
    public void setUserConfirm(Integer userConfirm) {
        this.set(FIELD_USERCONFIRM, userConfirm);
    }

    @JsonIgnore
    public boolean isUserConfirmDirty() {
        return this.contains(FIELD_USERCONFIRM);
    }

    @JsonIgnore
    public String getUserParams() {
        Object objValue = this.get(FIELD_USERPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="userparams")
    public void setUserParams(String userParams) {
        this.set(FIELD_USERPARAMS, userParams);
    }

    @JsonIgnore
    public boolean isUserParamsDirty() {
        return this.contains(FIELD_USERPARAMS);
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
    public Integer getViewActions() {
        Object objValue = this.get(FIELD_VIEWACTIONS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="viewactions")
    public void setViewActions(Integer viewActions) {
        this.set(FIELD_VIEWACTIONS, viewActions);
    }

    @JsonIgnore
    public boolean isViewActionsDirty() {
        return this.contains(FIELD_VIEWACTIONS);
    }

    @JsonIgnore
    public String getViewLogicType() {
        Object objValue = this.get(FIELD_VIEWLOGICTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="viewlogictype")
    public void setViewLogicType(String viewLogicType) {
        this.set(FIELD_VIEWLOGICTYPE, viewLogicType);
    }

    @JsonIgnore
    public boolean isViewLogicTypeDirty() {
        return this.contains(FIELD_VIEWLOGICTYPE);
    }

    @JsonIgnore
    public String getVLExecMode() {
        Object objValue = this.get(FIELD_VLEXECMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="vlexecmode")
    public void setVLExecMode(String vLExecMode) {
        this.set(FIELD_VLEXECMODE, vLExecMode);
    }

    @JsonIgnore
    public boolean isVLExecModeDirty() {
        return this.contains(FIELD_VLEXECMODE);
    }

    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDEUIActionId();
    }

    public void setSrfkey(String strValue) {
        this.setPSDEUIActionId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSDEUIACTION";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSDEUIAction item = (PSDEUIAction)MAPPER.readValue(new File(strJsonFilePath), PSDEUIAction.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSDEUIAction) {
            PSDEUIAction pSDEUIAction = (PSDEUIAction)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSDEUIAction) {
            PSDEUIAction pSDEUIAction = (PSDEUIAction)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

