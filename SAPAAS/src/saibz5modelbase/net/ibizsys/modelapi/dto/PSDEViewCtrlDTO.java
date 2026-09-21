/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonFormat
 *  com.fasterxml.jackson.annotation.JsonIgnore
 *  com.fasterxml.jackson.annotation.JsonProperty
 */
package net.ibizsys.modelapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Timestamp;
import net.ibizsys.modelapi.util.PSModelDTOBase;

public class PSDEViewCtrlDTO
extends PSModelDTOBase {
    public static final String FIELD_ADPSDELOGICID = "adpsdelogicid";
    public static final String FIELD_ADPSDELOGICNAME = "adpsdelogicname";
    public static final String FIELD_BOTTOMPOS = "bottompos";
    public static final String FIELD_BTNACTIONTYPE = "btnactiontype";
    public static final String FIELD_BUSYINDICATOR = "busyindicator";
    public static final String FIELD_CAPPSLANRESID = "cappslanresid";
    public static final String FIELD_CAPPSLANRESNAME = "cappslanresname";
    public static final String FIELD_CAPTION = "caption";
    public static final String FIELD_CONFIGINFO = "configinfo";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CTRLPARAM = "ctrlparam";
    public static final String FIELD_CTRLPARAM10 = "ctrlparam10";
    public static final String FIELD_CTRLPARAM11 = "ctrlparam11";
    public static final String FIELD_CTRLPARAM12 = "ctrlparam12";
    public static final String FIELD_CTRLPARAM2 = "ctrlparam2";
    public static final String FIELD_CTRLPARAM3 = "ctrlparam3";
    public static final String FIELD_CTRLPARAM4 = "ctrlparam4";
    public static final String FIELD_CTRLPARAM5 = "ctrlparam5";
    public static final String FIELD_CTRLPARAM6 = "ctrlparam6";
    public static final String FIELD_CTRLPARAM7 = "ctrlparam7";
    public static final String FIELD_CTRLPARAM8 = "ctrlparam8";
    public static final String FIELD_CTRLPARAM9 = "ctrlparam9";
    public static final String FIELD_CTRLPARAMS = "ctrlparams";
    public static final String FIELD_CUSTOMCOND = "customcond";
    public static final String FIELD_DEFAULTFLAG = "defaultflag";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_ENABLEDYNASYS = "enabledynasys";
    public static final String FIELD_ENABLEITEMPRIV = "enableitempriv";
    public static final String FIELD_ENABLEVIEWACTIONS = "enableviewactions";
    public static final String FIELD_HEIGHT = "height";
    public static final String FIELD_LEFTPOS = "leftpos";
    public static final String FIELD_LOCALMODE = "localmode";
    public static final String FIELD_MARGIN = "margin";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MULTISELECT = "multiselect";
    public static final String FIELD_NO2PSDEUAGROUPID = "no2psdeuagroupid";
    public static final String FIELD_NO2PSDEUAGROUPNAME = "no2psdeuagroupname";
    public static final String FIELD_NO3PSDEUAGROUPID = "no3psdeuagroupid";
    public static final String FIELD_NO3PSDEUAGROUPNAME = "no3psdeuagroupname";
    public static final String FIELD_NO4PSDEUAGROUPID = "no4psdeuagroupid";
    public static final String FIELD_NO4PSDEUAGROUPNAME = "no4psdeuagroupname";
    public static final String FIELD_NO5PSDEUAGROUPID = "no5psdeuagroupid";
    public static final String FIELD_NO5PSDEUAGROUPNAME = "no5psdeuagroupname";
    public static final String FIELD_NO6PSDEUAGROUPID = "no6psdeuagroupid";
    public static final String FIELD_NO6PSDEUAGROUPNAME = "no6psdeuagroupname";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PADDING = "padding";
    public static final String FIELD_PREDEFINEDTYPE = "predefinedtype";
    public static final String FIELD_PREDEFINEDTYPETEXT = "predefinedtypetext";
    public static final String FIELD_PSACHANDLERID = "psachandlerid";
    public static final String FIELD_PSACHANDLERNAME = "psachandlername";
    public static final String FIELD_PSCTRLLOGICGROUPID = "psctrllogicgroupid";
    public static final String FIELD_PSCTRLLOGICGROUPNAME = "psctrllogicgroupname";
    public static final String FIELD_PSCTRLMSGID = "psctrlmsgid";
    public static final String FIELD_PSCTRLMSGNAME = "psctrlmsgname";
    public static final String FIELD_PSDEACTIONID = "psdeactionid";
    public static final String FIELD_PSDEACTIONNAME = "psdeactionname";
    public static final String FIELD_PSDECHARTID = "psdechartid";
    public static final String FIELD_PSDECHARTNAME = "psdechartname";
    public static final String FIELD_PSDEDATAEXPID = "psdedataexpid";
    public static final String FIELD_PSDEDATAEXPNAME = "psdedataexpname";
    public static final String FIELD_PSDEDATAIMPID = "psdedataimpid";
    public static final String FIELD_PSDEDATAIMPNAME = "psdedataimpname";
    public static final String FIELD_PSDEDATASETID = "psdedatasetid";
    public static final String FIELD_PSDEDATASETNAME = "psdedatasetname";
    public static final String FIELD_PSDEDATAVIEWID = "psdedataviewid";
    public static final String FIELD_PSDEDATAVIEWNAME = "psdedataviewname";
    public static final String FIELD_PSDEDRID = "psdedrid";
    public static final String FIELD_PSDEDRNAME = "psdedrname";
    public static final String FIELD_PSDEFORMID = "psdeformid";
    public static final String FIELD_PSDEFORMNAME = "psdeformname";
    public static final String FIELD_PSDEGRIDID = "psdegridid";
    public static final String FIELD_PSDEGRIDNAME = "psdegridname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDELISTID = "psdelistid";
    public static final String FIELD_PSDELISTNAME = "psdelistname";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSDEOPPRIVID = "psdeopprivid";
    public static final String FIELD_PSDEOPPRIVNAME = "psdeopprivname";
    public static final String FIELD_PSDEREPORTID = "psdereportid";
    public static final String FIELD_PSDEREPORTNAME = "psdereportname";
    public static final String FIELD_PSDETOOLBARID = "psdetoolbarid";
    public static final String FIELD_PSDETOOLBARNAME = "psdetoolbarname";
    public static final String FIELD_PSDETREEVIEWID = "psdetreeviewid";
    public static final String FIELD_PSDETREEVIEWNAME = "psdetreeviewname";
    public static final String FIELD_PSDEUAGROUPID = "psdeuagroupid";
    public static final String FIELD_PSDEUAGROUPNAME = "psdeuagroupname";
    public static final String FIELD_PSDEVIEWBASEID = "psdeviewbaseid";
    public static final String FIELD_PSDEVIEWBASENAME = "psdeviewbasename";
    public static final String FIELD_PSDEVIEWCTRLID = "psdeviewctrlid";
    public static final String FIELD_PSDEVIEWCTRLNAME = "psdeviewctrlname";
    public static final String FIELD_PSDEVIEWCTRLTYPE = "psdeviewctrltype";
    public static final String FIELD_PSDEVIEWID = "psdeviewid";
    public static final String FIELD_PSDEVIEWNAME = "psdeviewname";
    public static final String FIELD_PSDEWIZARDID = "psdewizardid";
    public static final String FIELD_PSDEWIZARDNAME = "psdewizardname";
    public static final String FIELD_PSPFID = "pspfid";
    public static final String FIELD_PSPFNAME = "pspfname";
    public static final String FIELD_PSSYSCALENDARID = "pssyscalendarid";
    public static final String FIELD_PSSYSCALENDARNAME = "pssyscalendarname";
    public static final String FIELD_PSSYSCOUNTERID = "pssyscounterid";
    public static final String FIELD_PSSYSCOUNTERNAME = "pssyscountername";
    public static final String FIELD_PSSYSCSSID = "pssyscssid";
    public static final String FIELD_PSSYSCSSNAME = "pssyscssname";
    public static final String FIELD_PSSYSDASHBOARDID = "pssysdashboardid";
    public static final String FIELD_PSSYSDASHBOARDNAME = "pssysdashboardname";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    public static final String FIELD_PSSYSIMAGEID = "pssysimageid";
    public static final String FIELD_PSSYSIMAGENAME = "pssysimagename";
    public static final String FIELD_PSSYSMAPVIEWID = "pssysmapviewid";
    public static final String FIELD_PSSYSMAPVIEWNAME = "pssysmapviewname";
    public static final String FIELD_PSSYSMSGTEMPLID = "pssysmsgtemplid";
    public static final String FIELD_PSSYSMSGTEMPLNAME = "pssysmsgtemplname";
    public static final String FIELD_PSSYSPFPLUGINID = "pssyspfpluginid";
    public static final String FIELD_PSSYSPFPLUGINNAME = "pssyspfpluginname";
    public static final String FIELD_PSSYSSEARCHBARID = "pssyssearchbarid";
    public static final String FIELD_PSSYSSEARCHBARNAME = "pssyssearchbarname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSVIEWPANELID = "pssysviewpanelid";
    public static final String FIELD_PSSYSVIEWPANELNAME = "pssysviewpanelname";
    public static final String FIELD_READONLYMODE = "readonlymode";
    public static final String FIELD_REFCTRL2NAME = "refctrl2name";
    public static final String FIELD_REFCTRL2USAGE = "refctrl2usage";
    public static final String FIELD_REFCTRL2USAGETEXT = "refctrl2usagetext";
    public static final String FIELD_REFCTRLNAME = "refctrlname";
    public static final String FIELD_REFCTRLUSAGE = "refctrlusage";
    public static final String FIELD_REFCTRLUSAGETEXT = "refctrlusagetext";
    public static final String FIELD_RIGHTPOS = "rightpos";
    public static final String FIELD_SUBPSACHANDLERID = "subpsachandlerid";
    public static final String FIELD_SUBPSACHANDLERNAME = "subpsachandlername";
    public static final String FIELD_TOPPOS = "toppos";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_VALIDFLAG = "validflag";
    public static final String FIELD_WIDTH = "width";

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
    public Integer getBottomPos() {
        Object objValue = this.get(FIELD_BOTTOMPOS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="bottompos")
    public void setBottomPos(Integer bottomPos) {
        this.set(FIELD_BOTTOMPOS, bottomPos);
    }

    @JsonIgnore
    public boolean isBottomPosDirty() {
        return this.contains(FIELD_BOTTOMPOS);
    }

    @JsonIgnore
    public String getBtnActionType() {
        Object objValue = this.get(FIELD_BTNACTIONTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="btnactiontype")
    public void setBtnActionType(String btnActionType) {
        this.set(FIELD_BTNACTIONTYPE, btnActionType);
    }

    @JsonIgnore
    public boolean isBtnActionTypeDirty() {
        return this.contains(FIELD_BTNACTIONTYPE);
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
    public String getConfigInfo() {
        Object objValue = this.get(FIELD_CONFIGINFO);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="configinfo")
    public void setConfigInfo(String configInfo) {
        this.set(FIELD_CONFIGINFO, configInfo);
    }

    @JsonIgnore
    public boolean isConfigInfoDirty() {
        return this.contains(FIELD_CONFIGINFO);
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
    public String getCtrlParam() {
        Object objValue = this.get(FIELD_CTRLPARAM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ctrlparam")
    public void setCtrlParam(String ctrlParam) {
        this.set(FIELD_CTRLPARAM, ctrlParam);
    }

    @JsonIgnore
    public boolean isCtrlParamDirty() {
        return this.contains(FIELD_CTRLPARAM);
    }

    @JsonIgnore
    public Double getCtrlParam10() {
        Object objValue = this.get(FIELD_CTRLPARAM10);
        if (objValue == null) {
            return null;
        }
        return (Double)objValue;
    }

    @JsonProperty(value="ctrlparam10")
    public void setCtrlParam10(Double ctrlParam10) {
        this.set(FIELD_CTRLPARAM10, ctrlParam10);
    }

    @JsonIgnore
    public boolean isCtrlParam10Dirty() {
        return this.contains(FIELD_CTRLPARAM10);
    }

    @JsonIgnore
    public Integer getCtrlParam11() {
        Object objValue = this.get(FIELD_CTRLPARAM11);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="ctrlparam11")
    public void setCtrlParam11(Integer ctrlParam11) {
        this.set(FIELD_CTRLPARAM11, ctrlParam11);
    }

    @JsonIgnore
    public boolean isCtrlParam11Dirty() {
        return this.contains(FIELD_CTRLPARAM11);
    }

    @JsonIgnore
    public Integer getCtrlParam12() {
        Object objValue = this.get(FIELD_CTRLPARAM12);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="ctrlparam12")
    public void setCtrlParam12(Integer ctrlParam12) {
        this.set(FIELD_CTRLPARAM12, ctrlParam12);
    }

    @JsonIgnore
    public boolean isCtrlParam12Dirty() {
        return this.contains(FIELD_CTRLPARAM12);
    }

    @JsonIgnore
    public String getCtrlParam2() {
        Object objValue = this.get(FIELD_CTRLPARAM2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ctrlparam2")
    public void setCtrlParam2(String ctrlParam2) {
        this.set(FIELD_CTRLPARAM2, ctrlParam2);
    }

    @JsonIgnore
    public boolean isCtrlParam2Dirty() {
        return this.contains(FIELD_CTRLPARAM2);
    }

    @JsonIgnore
    public String getCtrlParam3() {
        Object objValue = this.get(FIELD_CTRLPARAM3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ctrlparam3")
    public void setCtrlParam3(String ctrlParam3) {
        this.set(FIELD_CTRLPARAM3, ctrlParam3);
    }

    @JsonIgnore
    public boolean isCtrlParam3Dirty() {
        return this.contains(FIELD_CTRLPARAM3);
    }

    @JsonIgnore
    public String getCtrlParam4() {
        Object objValue = this.get(FIELD_CTRLPARAM4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ctrlparam4")
    public void setCtrlParam4(String ctrlParam4) {
        this.set(FIELD_CTRLPARAM4, ctrlParam4);
    }

    @JsonIgnore
    public boolean isCtrlParam4Dirty() {
        return this.contains(FIELD_CTRLPARAM4);
    }

    @JsonIgnore
    public Integer getCtrlParam5() {
        Object objValue = this.get(FIELD_CTRLPARAM5);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="ctrlparam5")
    public void setCtrlParam5(Integer ctrlParam5) {
        this.set(FIELD_CTRLPARAM5, ctrlParam5);
    }

    @JsonIgnore
    public boolean isCtrlParam5Dirty() {
        return this.contains(FIELD_CTRLPARAM5);
    }

    @JsonIgnore
    public Integer getCtrlParam6() {
        Object objValue = this.get(FIELD_CTRLPARAM6);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="ctrlparam6")
    public void setCtrlParam6(Integer ctrlParam6) {
        this.set(FIELD_CTRLPARAM6, ctrlParam6);
    }

    @JsonIgnore
    public boolean isCtrlParam6Dirty() {
        return this.contains(FIELD_CTRLPARAM6);
    }

    @JsonIgnore
    public Integer getCtrlParam7() {
        Object objValue = this.get(FIELD_CTRLPARAM7);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="ctrlparam7")
    public void setCtrlParam7(Integer ctrlParam7) {
        this.set(FIELD_CTRLPARAM7, ctrlParam7);
    }

    @JsonIgnore
    public boolean isCtrlParam7Dirty() {
        return this.contains(FIELD_CTRLPARAM7);
    }

    @JsonIgnore
    public Integer getCtrlParam8() {
        Object objValue = this.get(FIELD_CTRLPARAM8);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="ctrlparam8")
    public void setCtrlParam8(Integer ctrlParam8) {
        this.set(FIELD_CTRLPARAM8, ctrlParam8);
    }

    @JsonIgnore
    public boolean isCtrlParam8Dirty() {
        return this.contains(FIELD_CTRLPARAM8);
    }

    @JsonIgnore
    public Double getCtrlParam9() {
        Object objValue = this.get(FIELD_CTRLPARAM9);
        if (objValue == null) {
            return null;
        }
        return (Double)objValue;
    }

    @JsonProperty(value="ctrlparam9")
    public void setCtrlParam9(Double ctrlParam9) {
        this.set(FIELD_CTRLPARAM9, ctrlParam9);
    }

    @JsonIgnore
    public boolean isCtrlParam9Dirty() {
        return this.contains(FIELD_CTRLPARAM9);
    }

    @JsonIgnore
    public String getCtrlParams() {
        Object objValue = this.get(FIELD_CTRLPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ctrlparams")
    public void setCtrlParams(String ctrlParams) {
        this.set(FIELD_CTRLPARAMS, ctrlParams);
    }

    @JsonIgnore
    public boolean isCtrlParamsDirty() {
        return this.contains(FIELD_CTRLPARAMS);
    }

    @JsonIgnore
    public String getCustomCond() {
        Object objValue = this.get(FIELD_CUSTOMCOND);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="customcond")
    public void setCustomCond(String customCond) {
        this.set(FIELD_CUSTOMCOND, customCond);
    }

    @JsonIgnore
    public boolean isCustomCondDirty() {
        return this.contains(FIELD_CUSTOMCOND);
    }

    @JsonIgnore
    public Integer getDefaultFlag() {
        Object objValue = this.get(FIELD_DEFAULTFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="defaultflag")
    public void setDefaultFlag(Integer defaultFlag) {
        this.set(FIELD_DEFAULTFLAG, defaultFlag);
    }

    @JsonIgnore
    public boolean isDefaultFlagDirty() {
        return this.contains(FIELD_DEFAULTFLAG);
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
    public Integer getEnableDynaSys() {
        Object objValue = this.get(FIELD_ENABLEDYNASYS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enabledynasys")
    public void setEnableDynaSys(Integer enableDynaSys) {
        this.set(FIELD_ENABLEDYNASYS, enableDynaSys);
    }

    @JsonIgnore
    public boolean isEnableDynaSysDirty() {
        return this.contains(FIELD_ENABLEDYNASYS);
    }

    @JsonIgnore
    public Integer getEnableItemPriv() {
        Object objValue = this.get(FIELD_ENABLEITEMPRIV);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enableitempriv")
    public void setEnableItemPriv(Integer enableItemPriv) {
        this.set(FIELD_ENABLEITEMPRIV, enableItemPriv);
    }

    @JsonIgnore
    public boolean isEnableItemPrivDirty() {
        return this.contains(FIELD_ENABLEITEMPRIV);
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
    public Double getHeight() {
        Object objValue = this.get(FIELD_HEIGHT);
        if (objValue == null) {
            return null;
        }
        return (Double)objValue;
    }

    @JsonProperty(value="height")
    public void setHeight(Double height) {
        this.set(FIELD_HEIGHT, height);
    }

    @JsonIgnore
    public boolean isHeightDirty() {
        return this.contains(FIELD_HEIGHT);
    }

    @JsonIgnore
    public Integer getLeftPos() {
        Object objValue = this.get(FIELD_LEFTPOS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="leftpos")
    public void setLeftPos(Integer leftPos) {
        this.set(FIELD_LEFTPOS, leftPos);
    }

    @JsonIgnore
    public boolean isLeftPosDirty() {
        return this.contains(FIELD_LEFTPOS);
    }

    @JsonIgnore
    public Integer getLocalMode() {
        Object objValue = this.get(FIELD_LOCALMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="localmode")
    public void setLocalMode(Integer localMode) {
        this.set(FIELD_LOCALMODE, localMode);
    }

    @JsonIgnore
    public boolean isLocalModeDirty() {
        return this.contains(FIELD_LOCALMODE);
    }

    @JsonIgnore
    public String getMargin() {
        Object objValue = this.get(FIELD_MARGIN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="margin")
    public void setMargin(String margin) {
        this.set(FIELD_MARGIN, margin);
    }

    @JsonIgnore
    public boolean isMarginDirty() {
        return this.contains(FIELD_MARGIN);
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
    public Integer getMultiSelect() {
        Object objValue = this.get(FIELD_MULTISELECT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="multiselect")
    public void setMultiSelect(Integer multiSelect) {
        this.set(FIELD_MULTISELECT, multiSelect);
    }

    @JsonIgnore
    public boolean isMultiSelectDirty() {
        return this.contains(FIELD_MULTISELECT);
    }

    @JsonIgnore
    public String getNO2PSDEUAGroupId() {
        Object objValue = this.get(FIELD_NO2PSDEUAGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no2psdeuagroupid")
    public void setNO2PSDEUAGroupId(String nO2PSDEUAGroupId) {
        this.set(FIELD_NO2PSDEUAGROUPID, nO2PSDEUAGroupId);
    }

    @JsonIgnore
    public boolean isNO2PSDEUAGroupIdDirty() {
        return this.contains(FIELD_NO2PSDEUAGROUPID);
    }

    @JsonIgnore
    public String getNO2PSDEUAGroupName() {
        Object objValue = this.get(FIELD_NO2PSDEUAGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no2psdeuagroupname")
    public void setNO2PSDEUAGroupName(String nO2PSDEUAGroupName) {
        this.set(FIELD_NO2PSDEUAGROUPNAME, nO2PSDEUAGroupName);
    }

    @JsonIgnore
    public boolean isNO2PSDEUAGroupNameDirty() {
        return this.contains(FIELD_NO2PSDEUAGROUPNAME);
    }

    @JsonIgnore
    public String getNO3PSDEUAGroupId() {
        Object objValue = this.get(FIELD_NO3PSDEUAGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no3psdeuagroupid")
    public void setNO3PSDEUAGroupId(String nO3PSDEUAGroupId) {
        this.set(FIELD_NO3PSDEUAGROUPID, nO3PSDEUAGroupId);
    }

    @JsonIgnore
    public boolean isNO3PSDEUAGroupIdDirty() {
        return this.contains(FIELD_NO3PSDEUAGROUPID);
    }

    @JsonIgnore
    public String getNO3PSDEUAGroupName() {
        Object objValue = this.get(FIELD_NO3PSDEUAGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no3psdeuagroupname")
    public void setNO3PSDEUAGroupName(String nO3PSDEUAGroupName) {
        this.set(FIELD_NO3PSDEUAGROUPNAME, nO3PSDEUAGroupName);
    }

    @JsonIgnore
    public boolean isNO3PSDEUAGroupNameDirty() {
        return this.contains(FIELD_NO3PSDEUAGROUPNAME);
    }

    @JsonIgnore
    public String getNO4PSDEUAGroupId() {
        Object objValue = this.get(FIELD_NO4PSDEUAGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no4psdeuagroupid")
    public void setNO4PSDEUAGroupId(String nO4PSDEUAGroupId) {
        this.set(FIELD_NO4PSDEUAGROUPID, nO4PSDEUAGroupId);
    }

    @JsonIgnore
    public boolean isNO4PSDEUAGroupIdDirty() {
        return this.contains(FIELD_NO4PSDEUAGROUPID);
    }

    @JsonIgnore
    public String getNO4PSDEUAGroupName() {
        Object objValue = this.get(FIELD_NO4PSDEUAGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no4psdeuagroupname")
    public void setNO4PSDEUAGroupName(String nO4PSDEUAGroupName) {
        this.set(FIELD_NO4PSDEUAGROUPNAME, nO4PSDEUAGroupName);
    }

    @JsonIgnore
    public boolean isNO4PSDEUAGroupNameDirty() {
        return this.contains(FIELD_NO4PSDEUAGROUPNAME);
    }

    @JsonIgnore
    public String getNO5PSDEUAGroupId() {
        Object objValue = this.get(FIELD_NO5PSDEUAGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no5psdeuagroupid")
    public void setNO5PSDEUAGroupId(String nO5PSDEUAGroupId) {
        this.set(FIELD_NO5PSDEUAGROUPID, nO5PSDEUAGroupId);
    }

    @JsonIgnore
    public boolean isNO5PSDEUAGroupIdDirty() {
        return this.contains(FIELD_NO5PSDEUAGROUPID);
    }

    @JsonIgnore
    public String getNO5PSDEUAGroupName() {
        Object objValue = this.get(FIELD_NO5PSDEUAGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no5psdeuagroupname")
    public void setNO5PSDEUAGroupName(String nO5PSDEUAGroupName) {
        this.set(FIELD_NO5PSDEUAGROUPNAME, nO5PSDEUAGroupName);
    }

    @JsonIgnore
    public boolean isNO5PSDEUAGroupNameDirty() {
        return this.contains(FIELD_NO5PSDEUAGROUPNAME);
    }

    @JsonIgnore
    public String getNO6PSDEUAGroupId() {
        Object objValue = this.get(FIELD_NO6PSDEUAGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no6psdeuagroupid")
    public void setNO6PSDEUAGroupId(String nO6PSDEUAGroupId) {
        this.set(FIELD_NO6PSDEUAGROUPID, nO6PSDEUAGroupId);
    }

    @JsonIgnore
    public boolean isNO6PSDEUAGroupIdDirty() {
        return this.contains(FIELD_NO6PSDEUAGROUPID);
    }

    @JsonIgnore
    public String getNO6PSDEUAGroupName() {
        Object objValue = this.get(FIELD_NO6PSDEUAGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no6psdeuagroupname")
    public void setNO6PSDEUAGroupName(String nO6PSDEUAGroupName) {
        this.set(FIELD_NO6PSDEUAGROUPNAME, nO6PSDEUAGroupName);
    }

    @JsonIgnore
    public boolean isNO6PSDEUAGroupNameDirty() {
        return this.contains(FIELD_NO6PSDEUAGROUPNAME);
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
    public String getPadding() {
        Object objValue = this.get(FIELD_PADDING);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="padding")
    public void setPadding(String padding) {
        this.set(FIELD_PADDING, padding);
    }

    @JsonIgnore
    public boolean isPaddingDirty() {
        return this.contains(FIELD_PADDING);
    }

    @JsonIgnore
    public String getPredefinedType() {
        Object objValue = this.get(FIELD_PREDEFINEDTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="predefinedtype")
    public void setPredefinedType(String predefinedType) {
        this.set(FIELD_PREDEFINEDTYPE, predefinedType);
    }

    @JsonIgnore
    public boolean isPredefinedTypeDirty() {
        return this.contains(FIELD_PREDEFINEDTYPE);
    }

    @JsonIgnore
    public String getPredefinedTypeText() {
        Object objValue = this.get(FIELD_PREDEFINEDTYPETEXT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="predefinedtypetext")
    public void setPredefinedTypeText(String predefinedTypeText) {
        this.set(FIELD_PREDEFINEDTYPETEXT, predefinedTypeText);
    }

    @JsonIgnore
    public boolean isPredefinedTypeTextDirty() {
        return this.contains(FIELD_PREDEFINEDTYPETEXT);
    }

    @JsonIgnore
    public String getPSACHandlerId() {
        Object objValue = this.get(FIELD_PSACHANDLERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psachandlerid")
    public void setPSACHandlerId(String pSACHandlerId) {
        this.set(FIELD_PSACHANDLERID, pSACHandlerId);
    }

    @JsonIgnore
    public boolean isPSACHandlerIdDirty() {
        return this.contains(FIELD_PSACHANDLERID);
    }

    @JsonIgnore
    public String getPSACHandlerName() {
        Object objValue = this.get(FIELD_PSACHANDLERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psachandlername")
    public void setPSACHandlerName(String pSACHandlerName) {
        this.set(FIELD_PSACHANDLERNAME, pSACHandlerName);
    }

    @JsonIgnore
    public boolean isPSACHandlerNameDirty() {
        return this.contains(FIELD_PSACHANDLERNAME);
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
    public String getPSDEChartId() {
        Object objValue = this.get(FIELD_PSDECHARTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdechartid")
    public void setPSDEChartId(String pSDEChartId) {
        this.set(FIELD_PSDECHARTID, pSDEChartId);
    }

    @JsonIgnore
    public boolean isPSDEChartIdDirty() {
        return this.contains(FIELD_PSDECHARTID);
    }

    @JsonIgnore
    public String getPSDEChartName() {
        Object objValue = this.get(FIELD_PSDECHARTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdechartname")
    public void setPSDEChartName(String pSDEChartName) {
        this.set(FIELD_PSDECHARTNAME, pSDEChartName);
    }

    @JsonIgnore
    public boolean isPSDEChartNameDirty() {
        return this.contains(FIELD_PSDECHARTNAME);
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
    public String getPSDEDataExpName() {
        Object objValue = this.get(FIELD_PSDEDATAEXPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedataexpname")
    public void setPSDEDataExpName(String pSDEDataExpName) {
        this.set(FIELD_PSDEDATAEXPNAME, pSDEDataExpName);
    }

    @JsonIgnore
    public boolean isPSDEDataExpNameDirty() {
        return this.contains(FIELD_PSDEDATAEXPNAME);
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
    public String getPSDEDataSetId() {
        Object objValue = this.get(FIELD_PSDEDATASETID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedatasetid")
    public void setPSDEDataSetId(String pSDEDataSetId) {
        this.set(FIELD_PSDEDATASETID, pSDEDataSetId);
    }

    @JsonIgnore
    public boolean isPSDEDataSetIdDirty() {
        return this.contains(FIELD_PSDEDATASETID);
    }

    @JsonIgnore
    public String getPSDEDataSetName() {
        Object objValue = this.get(FIELD_PSDEDATASETNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedatasetname")
    public void setPSDEDataSetName(String pSDEDataSetName) {
        this.set(FIELD_PSDEDATASETNAME, pSDEDataSetName);
    }

    @JsonIgnore
    public boolean isPSDEDataSetNameDirty() {
        return this.contains(FIELD_PSDEDATASETNAME);
    }

    @JsonIgnore
    public String getPSDEDataViewId() {
        Object objValue = this.get(FIELD_PSDEDATAVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedataviewid")
    public void setPSDEDataViewId(String pSDEDataViewId) {
        this.set(FIELD_PSDEDATAVIEWID, pSDEDataViewId);
    }

    @JsonIgnore
    public boolean isPSDEDataViewIdDirty() {
        return this.contains(FIELD_PSDEDATAVIEWID);
    }

    @JsonIgnore
    public String getPSDEDataViewName() {
        Object objValue = this.get(FIELD_PSDEDATAVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedataviewname")
    public void setPSDEDataViewName(String pSDEDataViewName) {
        this.set(FIELD_PSDEDATAVIEWNAME, pSDEDataViewName);
    }

    @JsonIgnore
    public boolean isPSDEDataViewNameDirty() {
        return this.contains(FIELD_PSDEDATAVIEWNAME);
    }

    @JsonIgnore
    public String getPSDEDRId() {
        Object objValue = this.get(FIELD_PSDEDRID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedrid")
    public void setPSDEDRId(String pSDEDRId) {
        this.set(FIELD_PSDEDRID, pSDEDRId);
    }

    @JsonIgnore
    public boolean isPSDEDRIdDirty() {
        return this.contains(FIELD_PSDEDRID);
    }

    @JsonIgnore
    public String getPSDEDRName() {
        Object objValue = this.get(FIELD_PSDEDRNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedrname")
    public void setPSDEDRName(String pSDEDRName) {
        this.set(FIELD_PSDEDRNAME, pSDEDRName);
    }

    @JsonIgnore
    public boolean isPSDEDRNameDirty() {
        return this.contains(FIELD_PSDEDRNAME);
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
    public String getPSDEGridId() {
        Object objValue = this.get(FIELD_PSDEGRIDID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdegridid")
    public void setPSDEGridId(String pSDEGridId) {
        this.set(FIELD_PSDEGRIDID, pSDEGridId);
    }

    @JsonIgnore
    public boolean isPSDEGridIdDirty() {
        return this.contains(FIELD_PSDEGRIDID);
    }

    @JsonIgnore
    public String getPSDEGridName() {
        Object objValue = this.get(FIELD_PSDEGRIDNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdegridname")
    public void setPSDEGridName(String pSDEGridName) {
        this.set(FIELD_PSDEGRIDNAME, pSDEGridName);
    }

    @JsonIgnore
    public boolean isPSDEGridNameDirty() {
        return this.contains(FIELD_PSDEGRIDNAME);
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
    public String getPSDEListId() {
        Object objValue = this.get(FIELD_PSDELISTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdelistid")
    public void setPSDEListId(String pSDEListId) {
        this.set(FIELD_PSDELISTID, pSDEListId);
    }

    @JsonIgnore
    public boolean isPSDEListIdDirty() {
        return this.contains(FIELD_PSDELISTID);
    }

    @JsonIgnore
    public String getPSDEListName() {
        Object objValue = this.get(FIELD_PSDELISTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdelistname")
    public void setPSDEListName(String pSDEListName) {
        this.set(FIELD_PSDELISTNAME, pSDEListName);
    }

    @JsonIgnore
    public boolean isPSDEListNameDirty() {
        return this.contains(FIELD_PSDELISTNAME);
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
    public String getPSDEReportId() {
        Object objValue = this.get(FIELD_PSDEREPORTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdereportid")
    public void setPSDEReportId(String pSDEReportId) {
        this.set(FIELD_PSDEREPORTID, pSDEReportId);
    }

    @JsonIgnore
    public boolean isPSDEReportIdDirty() {
        return this.contains(FIELD_PSDEREPORTID);
    }

    @JsonIgnore
    public String getPSDEReportName() {
        Object objValue = this.get(FIELD_PSDEREPORTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdereportname")
    public void setPSDEReportName(String pSDEReportName) {
        this.set(FIELD_PSDEREPORTNAME, pSDEReportName);
    }

    @JsonIgnore
    public boolean isPSDEReportNameDirty() {
        return this.contains(FIELD_PSDEREPORTNAME);
    }

    @JsonIgnore
    public String getPSDEToolbarId() {
        Object objValue = this.get(FIELD_PSDETOOLBARID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdetoolbarid")
    public void setPSDEToolbarId(String pSDEToolbarId) {
        this.set(FIELD_PSDETOOLBARID, pSDEToolbarId);
    }

    @JsonIgnore
    public boolean isPSDEToolbarIdDirty() {
        return this.contains(FIELD_PSDETOOLBARID);
    }

    @JsonIgnore
    public String getPSDEToolbarName() {
        Object objValue = this.get(FIELD_PSDETOOLBARNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdetoolbarname")
    public void setPSDEToolbarName(String pSDEToolbarName) {
        this.set(FIELD_PSDETOOLBARNAME, pSDEToolbarName);
    }

    @JsonIgnore
    public boolean isPSDEToolbarNameDirty() {
        return this.contains(FIELD_PSDETOOLBARNAME);
    }

    @JsonIgnore
    public String getPSDETreeViewId() {
        Object objValue = this.get(FIELD_PSDETREEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdetreeviewid")
    public void setPSDETreeViewId(String pSDETreeViewId) {
        this.set(FIELD_PSDETREEVIEWID, pSDETreeViewId);
    }

    @JsonIgnore
    public boolean isPSDETreeViewIdDirty() {
        return this.contains(FIELD_PSDETREEVIEWID);
    }

    @JsonIgnore
    public String getPSDETreeViewName() {
        Object objValue = this.get(FIELD_PSDETREEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdetreeviewname")
    public void setPSDETreeViewName(String pSDETreeViewName) {
        this.set(FIELD_PSDETREEVIEWNAME, pSDETreeViewName);
    }

    @JsonIgnore
    public boolean isPSDETreeViewNameDirty() {
        return this.contains(FIELD_PSDETREEVIEWNAME);
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
    public String getPSDEViewCtrlId() {
        Object objValue = this.get(FIELD_PSDEVIEWCTRLID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeviewctrlid")
    public void setPSDEViewCtrlId(String pSDEViewCtrlId) {
        this.set(FIELD_PSDEVIEWCTRLID, pSDEViewCtrlId);
    }

    @JsonIgnore
    public boolean isPSDEViewCtrlIdDirty() {
        return this.contains(FIELD_PSDEVIEWCTRLID);
    }

    @JsonIgnore
    public String getPSDEViewCtrlName() {
        Object objValue = this.get(FIELD_PSDEVIEWCTRLNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeviewctrlname")
    public void setPSDEViewCtrlName(String pSDEViewCtrlName) {
        this.set(FIELD_PSDEVIEWCTRLNAME, pSDEViewCtrlName);
    }

    @JsonIgnore
    public boolean isPSDEViewCtrlNameDirty() {
        return this.contains(FIELD_PSDEVIEWCTRLNAME);
    }

    @JsonIgnore
    public String getPSDEViewCtrlType() {
        Object objValue = this.get(FIELD_PSDEVIEWCTRLTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeviewctrltype")
    public void setPSDEViewCtrlType(String pSDEViewCtrlType) {
        this.set(FIELD_PSDEVIEWCTRLTYPE, pSDEViewCtrlType);
    }

    @JsonIgnore
    public boolean isPSDEViewCtrlTypeDirty() {
        return this.contains(FIELD_PSDEVIEWCTRLTYPE);
    }

    @JsonIgnore
    public String getPSDEViewId() {
        Object objValue = this.get(FIELD_PSDEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeviewid")
    public void setPSDEViewId(String pSDEViewId) {
        this.set(FIELD_PSDEVIEWID, pSDEViewId);
    }

    @JsonIgnore
    public boolean isPSDEViewIdDirty() {
        return this.contains(FIELD_PSDEVIEWID);
    }

    @JsonIgnore
    public String getPSDEViewName() {
        Object objValue = this.get(FIELD_PSDEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeviewname")
    public void setPSDEViewName(String pSDEViewName) {
        this.set(FIELD_PSDEVIEWNAME, pSDEViewName);
    }

    @JsonIgnore
    public boolean isPSDEViewNameDirty() {
        return this.contains(FIELD_PSDEVIEWNAME);
    }

    @JsonIgnore
    public String getPSDEWizardId() {
        Object objValue = this.get(FIELD_PSDEWIZARDID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdewizardid")
    public void setPSDEWizardId(String pSDEWizardId) {
        this.set(FIELD_PSDEWIZARDID, pSDEWizardId);
    }

    @JsonIgnore
    public boolean isPSDEWizardIdDirty() {
        return this.contains(FIELD_PSDEWIZARDID);
    }

    @JsonIgnore
    public String getPSDEWizardName() {
        Object objValue = this.get(FIELD_PSDEWIZARDNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdewizardname")
    public void setPSDEWizardName(String pSDEWizardName) {
        this.set(FIELD_PSDEWIZARDNAME, pSDEWizardName);
    }

    @JsonIgnore
    public boolean isPSDEWizardNameDirty() {
        return this.contains(FIELD_PSDEWIZARDNAME);
    }

    @JsonIgnore
    public String getPSPFId() {
        Object objValue = this.get(FIELD_PSPFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pspfid")
    public void setPSPFId(String pSPFId) {
        this.set(FIELD_PSPFID, pSPFId);
    }

    @JsonIgnore
    public boolean isPSPFIdDirty() {
        return this.contains(FIELD_PSPFID);
    }

    @JsonIgnore
    public String getPSPFName() {
        Object objValue = this.get(FIELD_PSPFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pspfname")
    public void setPSPFName(String pSPFName) {
        this.set(FIELD_PSPFNAME, pSPFName);
    }

    @JsonIgnore
    public boolean isPSPFNameDirty() {
        return this.contains(FIELD_PSPFNAME);
    }

    @JsonIgnore
    public String getPSSysCalendarId() {
        Object objValue = this.get(FIELD_PSSYSCALENDARID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscalendarid")
    public void setPSSysCalendarId(String pSSysCalendarId) {
        this.set(FIELD_PSSYSCALENDARID, pSSysCalendarId);
    }

    @JsonIgnore
    public boolean isPSSysCalendarIdDirty() {
        return this.contains(FIELD_PSSYSCALENDARID);
    }

    @JsonIgnore
    public String getPSSysCalendarName() {
        Object objValue = this.get(FIELD_PSSYSCALENDARNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscalendarname")
    public void setPSSysCalendarName(String pSSysCalendarName) {
        this.set(FIELD_PSSYSCALENDARNAME, pSSysCalendarName);
    }

    @JsonIgnore
    public boolean isPSSysCalendarNameDirty() {
        return this.contains(FIELD_PSSYSCALENDARNAME);
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
    public String getPSSysMsgTemplId() {
        Object objValue = this.get(FIELD_PSSYSMSGTEMPLID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysmsgtemplid")
    public void setPSSysMsgTemplId(String pSSysMsgTemplId) {
        this.set(FIELD_PSSYSMSGTEMPLID, pSSysMsgTemplId);
    }

    @JsonIgnore
    public boolean isPSSysMsgTemplIdDirty() {
        return this.contains(FIELD_PSSYSMSGTEMPLID);
    }

    @JsonIgnore
    public String getPSSysMsgTemplName() {
        Object objValue = this.get(FIELD_PSSYSMSGTEMPLNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysmsgtemplname")
    public void setPSSysMsgTemplName(String pSSysMsgTemplName) {
        this.set(FIELD_PSSYSMSGTEMPLNAME, pSSysMsgTemplName);
    }

    @JsonIgnore
    public boolean isPSSysMsgTemplNameDirty() {
        return this.contains(FIELD_PSSYSMSGTEMPLNAME);
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
    public String getPSSysSearchBarId() {
        Object objValue = this.get(FIELD_PSSYSSEARCHBARID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssearchbarid")
    public void setPSSysSearchBarId(String pSSysSearchBarId) {
        this.set(FIELD_PSSYSSEARCHBARID, pSSysSearchBarId);
    }

    @JsonIgnore
    public boolean isPSSysSearchBarIdDirty() {
        return this.contains(FIELD_PSSYSSEARCHBARID);
    }

    @JsonIgnore
    public String getPSSysSearchBarName() {
        Object objValue = this.get(FIELD_PSSYSSEARCHBARNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssearchbarname")
    public void setPSSysSearchBarName(String pSSysSearchBarName) {
        this.set(FIELD_PSSYSSEARCHBARNAME, pSSysSearchBarName);
    }

    @JsonIgnore
    public boolean isPSSysSearchBarNameDirty() {
        return this.contains(FIELD_PSSYSSEARCHBARNAME);
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
    public Integer getReadOnlyMode() {
        Object objValue = this.get(FIELD_READONLYMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="readonlymode")
    public void setReadOnlyMode(Integer readOnlyMode) {
        this.set(FIELD_READONLYMODE, readOnlyMode);
    }

    @JsonIgnore
    public boolean isReadOnlyModeDirty() {
        return this.contains(FIELD_READONLYMODE);
    }

    @JsonIgnore
    public String getRefCtrl2Name() {
        Object objValue = this.get(FIELD_REFCTRL2NAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refctrl2name")
    public void setRefCtrl2Name(String refCtrl2Name) {
        this.set(FIELD_REFCTRL2NAME, refCtrl2Name);
    }

    @JsonIgnore
    public boolean isRefCtrl2NameDirty() {
        return this.contains(FIELD_REFCTRL2NAME);
    }

    @JsonIgnore
    public String getRefCtrl2Usage() {
        Object objValue = this.get(FIELD_REFCTRL2USAGE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refctrl2usage")
    public void setRefCtrl2Usage(String refCtrl2Usage) {
        this.set(FIELD_REFCTRL2USAGE, refCtrl2Usage);
    }

    @JsonIgnore
    public boolean isRefCtrl2UsageDirty() {
        return this.contains(FIELD_REFCTRL2USAGE);
    }

    @JsonIgnore
    public String getRefCtrl2UsageText() {
        Object objValue = this.get(FIELD_REFCTRL2USAGETEXT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refctrl2usagetext")
    public void setRefCtrl2UsageText(String refCtrl2UsageText) {
        this.set(FIELD_REFCTRL2USAGETEXT, refCtrl2UsageText);
    }

    @JsonIgnore
    public boolean isRefCtrl2UsageTextDirty() {
        return this.contains(FIELD_REFCTRL2USAGETEXT);
    }

    @JsonIgnore
    public String getRefCtrlName() {
        Object objValue = this.get(FIELD_REFCTRLNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refctrlname")
    public void setRefCtrlName(String refCtrlName) {
        this.set(FIELD_REFCTRLNAME, refCtrlName);
    }

    @JsonIgnore
    public boolean isRefCtrlNameDirty() {
        return this.contains(FIELD_REFCTRLNAME);
    }

    @JsonIgnore
    public String getRefCtrlUsage() {
        Object objValue = this.get(FIELD_REFCTRLUSAGE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refctrlusage")
    public void setRefCtrlUsage(String refCtrlUsage) {
        this.set(FIELD_REFCTRLUSAGE, refCtrlUsage);
    }

    @JsonIgnore
    public boolean isRefCtrlUsageDirty() {
        return this.contains(FIELD_REFCTRLUSAGE);
    }

    @JsonIgnore
    public String getRefCtrlUsageText() {
        Object objValue = this.get(FIELD_REFCTRLUSAGETEXT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refctrlusagetext")
    public void setRefCtrlUsageText(String refCtrlUsageText) {
        this.set(FIELD_REFCTRLUSAGETEXT, refCtrlUsageText);
    }

    @JsonIgnore
    public boolean isRefCtrlUsageTextDirty() {
        return this.contains(FIELD_REFCTRLUSAGETEXT);
    }

    @JsonIgnore
    public Integer getRightPos() {
        Object objValue = this.get(FIELD_RIGHTPOS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="rightpos")
    public void setRightPos(Integer rightPos) {
        this.set(FIELD_RIGHTPOS, rightPos);
    }

    @JsonIgnore
    public boolean isRightPosDirty() {
        return this.contains(FIELD_RIGHTPOS);
    }

    @JsonIgnore
    public String getSubPSACHandlerId() {
        Object objValue = this.get(FIELD_SUBPSACHANDLERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="subpsachandlerid")
    public void setSubPSACHandlerId(String subPSACHandlerId) {
        this.set(FIELD_SUBPSACHANDLERID, subPSACHandlerId);
    }

    @JsonIgnore
    public boolean isSubPSACHandlerIdDirty() {
        return this.contains(FIELD_SUBPSACHANDLERID);
    }

    @JsonIgnore
    public String getSubPSACHandlerName() {
        Object objValue = this.get(FIELD_SUBPSACHANDLERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="subpsachandlername")
    public void setSubPSACHandlerName(String subPSACHandlerName) {
        this.set(FIELD_SUBPSACHANDLERNAME, subPSACHandlerName);
    }

    @JsonIgnore
    public boolean isSubPSACHandlerNameDirty() {
        return this.contains(FIELD_SUBPSACHANDLERNAME);
    }

    @JsonIgnore
    public Integer getTopPos() {
        Object objValue = this.get(FIELD_TOPPOS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="toppos")
    public void setTopPos(Integer topPos) {
        this.set(FIELD_TOPPOS, topPos);
    }

    @JsonIgnore
    public boolean isTopPosDirty() {
        return this.contains(FIELD_TOPPOS);
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
    public Double getWidth() {
        Object objValue = this.get(FIELD_WIDTH);
        if (objValue == null) {
            return null;
        }
        return (Double)objValue;
    }

    @JsonProperty(value="width")
    public void setWidth(Double width) {
        this.set(FIELD_WIDTH, width);
    }

    @JsonIgnore
    public boolean isWidthDirty() {
        return this.contains(FIELD_WIDTH);
    }

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDEViewCtrlId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSDEViewCtrlId(strValue);
    }
}

