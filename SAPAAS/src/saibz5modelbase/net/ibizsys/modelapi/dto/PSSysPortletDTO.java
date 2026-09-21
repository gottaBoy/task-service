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

public class PSSysPortletDTO
extends PSModelDTOBase {
    public static final String FIELD_ADPSDELOGICID = "adpsdelogicid";
    public static final String FIELD_ADPSDELOGICNAME = "adpsdelogicname";
    public static final String FIELD_BASECLSPARAMS = "baseclsparams";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DASHBOARDSCOPE = "dashboardscope";
    public static final String FIELD_EMPTYTEXT = "emptytext";
    public static final String FIELD_EMPTYTEXTPSLANRESID = "emptytextpslanresid";
    public static final String FIELD_EMPTYTEXTPSLANRESNAME = "emptytextpslanresname";
    public static final String FIELD_GROUPEXTRACTMODE = "groupextractmode";
    public static final String FIELD_HEIGHT = "height";
    public static final String FIELD_HTMLSHOWMODE = "htmlshowmode";
    public static final String FIELD_HTMLURL = "htmlurl";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_LOGICNAME = "logicname";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PORTLETPARAMS = "portletparams";
    public static final String FIELD_PORTLETSTYLE = "portletstyle";
    public static final String FIELD_PORTLETTYPE = "portlettype";
    public static final String FIELD_PSACHANDLERID = "psachandlerid";
    public static final String FIELD_PSACHANDLERNAME = "psachandlername";
    public static final String FIELD_PSAPPMENUID = "psappmenuid";
    public static final String FIELD_PSAPPMENUNAME = "psappmenuname";
    public static final String FIELD_PSAPPVIEWID = "psappviewid";
    public static final String FIELD_PSAPPVIEWNAME = "psappviewname";
    public static final String FIELD_PSDECHARTID = "psdechartid";
    public static final String FIELD_PSDECHARTNAME = "psdechartname";
    public static final String FIELD_PSDEDSID = "psdedsid";
    public static final String FIELD_PSDEDSNAME = "psdedsname";
    public static final String FIELD_PSDEFORMID = "psdeformid";
    public static final String FIELD_PSDEFORMNAME = "psdeformname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDELISTID = "psdelistid";
    public static final String FIELD_PSDELISTNAME = "psdelistname";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSDEREPORTID = "psdereportid";
    public static final String FIELD_PSDEREPORTNAME = "psdereportname";
    public static final String FIELD_PSDETOOLBARID = "psdetoolbarid";
    public static final String FIELD_PSDETOOLBARNAME = "psdetoolbarname";
    public static final String FIELD_PSDEUAGROUPID = "psdeuagroupid";
    public static final String FIELD_PSDEUAGROUPNAME = "psdeuagroupname";
    public static final String FIELD_PSDEVIEWID = "psdeviewid";
    public static final String FIELD_PSDEVIEWNAME = "psdeviewname";
    public static final String FIELD_PSMODULEID = "psmoduleid";
    public static final String FIELD_PSMODULENAME = "psmodulename";
    public static final String FIELD_PSPORTLETID = "psportletid";
    public static final String FIELD_PSPORTLETNAME = "psportletname";
    public static final String FIELD_PSSYSAPPNAME = "pssysappname";
    public static final String FIELD_PSSYSCSSID = "pssyscssid";
    public static final String FIELD_PSSYSCSSNAME = "pssyscssname";
    public static final String FIELD_PSSYSIMAGEID = "pssysimageid";
    public static final String FIELD_PSSYSIMAGENAME = "pssysimagename";
    public static final String FIELD_PSSYSPFPLUGINID = "pssyspfpluginid";
    public static final String FIELD_PSSYSPFPLUGINNAME = "pssyspfpluginname";
    public static final String FIELD_PSSYSPORTLETCATID = "pssysportletcatid";
    public static final String FIELD_PSSYSPORTLETCATNAME = "pssysportletcatname";
    public static final String FIELD_PSSYSPORTLETID = "pssysportletid";
    public static final String FIELD_PSSYSPORTLETNAME = "pssysportletname";
    public static final String FIELD_PSSYSREQITEMID = "pssysreqitemid";
    public static final String FIELD_PSSYSREQITEMNAME = "pssysreqitemname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_PSSYSUNIRESID = "pssysuniresid";
    public static final String FIELD_PSSYSUNIRESNAME = "pssysuniresname";
    public static final String FIELD_RELOADTIMER = "reloadtimer";
    public static final String FIELD_SHOWTITLEBAR = "showtitlebar";
    public static final String FIELD_TEMPLENGINE = "templengine";
    public static final String FIELD_TITLEPSLANRESID = "titlepslanresid";
    public static final String FIELD_TITLEPSLANRESNAME = "titlepslanresname";
    public static final String FIELD_TITLEPSSYSPFPLUGINID = "titlepssyspfpluginid";
    public static final String FIELD_TITLEPSSYSPFPLUGINNAME = "titlepssyspfpluginname";
    public static final String FIELD_TODOTASK = "todotask";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";

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
    public String getBaseClsParams() {
        Object objValue = this.get(FIELD_BASECLSPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="baseclsparams")
    public void setBaseClsParams(String baseClsParams) {
        this.set(FIELD_BASECLSPARAMS, baseClsParams);
    }

    @JsonIgnore
    public boolean isBaseClsParamsDirty() {
        return this.contains(FIELD_BASECLSPARAMS);
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
    public Integer getDashboardScope() {
        Object objValue = this.get(FIELD_DASHBOARDSCOPE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="dashboardscope")
    public void setDashboardScope(Integer dashboardScope) {
        this.set(FIELD_DASHBOARDSCOPE, dashboardScope);
    }

    @JsonIgnore
    public boolean isDashboardScopeDirty() {
        return this.contains(FIELD_DASHBOARDSCOPE);
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
    public String getGroupExtractMode() {
        Object objValue = this.get(FIELD_GROUPEXTRACTMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="groupextractmode")
    public void setGroupExtractMode(String groupExtractMode) {
        this.set(FIELD_GROUPEXTRACTMODE, groupExtractMode);
    }

    @JsonIgnore
    public boolean isGroupExtractModeDirty() {
        return this.contains(FIELD_GROUPEXTRACTMODE);
    }

    @JsonIgnore
    public Integer getHeight() {
        Object objValue = this.get(FIELD_HEIGHT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="height")
    public void setHeight(Integer height) {
        this.set(FIELD_HEIGHT, height);
    }

    @JsonIgnore
    public boolean isHeightDirty() {
        return this.contains(FIELD_HEIGHT);
    }

    @JsonIgnore
    public String getHtmlShowMode() {
        Object objValue = this.get(FIELD_HTMLSHOWMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="htmlshowmode")
    public void setHtmlShowMode(String htmlShowMode) {
        this.set(FIELD_HTMLSHOWMODE, htmlShowMode);
    }

    @JsonIgnore
    public boolean isHtmlShowModeDirty() {
        return this.contains(FIELD_HTMLSHOWMODE);
    }

    @JsonIgnore
    public String getHtmlUrl() {
        Object objValue = this.get(FIELD_HTMLURL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="htmlurl")
    public void setHtmlUrl(String htmlUrl) {
        this.set(FIELD_HTMLURL, htmlUrl);
    }

    @JsonIgnore
    public boolean isHtmlUrlDirty() {
        return this.contains(FIELD_HTMLURL);
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
    public String getPortletParams() {
        Object objValue = this.get(FIELD_PORTLETPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="portletparams")
    public void setPortletParams(String portletParams) {
        this.set(FIELD_PORTLETPARAMS, portletParams);
    }

    @JsonIgnore
    public boolean isPortletParamsDirty() {
        return this.contains(FIELD_PORTLETPARAMS);
    }

    @JsonIgnore
    public String getPortletStyle() {
        Object objValue = this.get(FIELD_PORTLETSTYLE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="portletstyle")
    public void setPortletStyle(String portletStyle) {
        this.set(FIELD_PORTLETSTYLE, portletStyle);
    }

    @JsonIgnore
    public boolean isPortletStyleDirty() {
        return this.contains(FIELD_PORTLETSTYLE);
    }

    @JsonIgnore
    public String getPortletType() {
        Object objValue = this.get(FIELD_PORTLETTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="portlettype")
    public void setPortletType(String portletType) {
        this.set(FIELD_PORTLETTYPE, portletType);
    }

    @JsonIgnore
    public boolean isPortletTypeDirty() {
        return this.contains(FIELD_PORTLETTYPE);
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
    public String getPSAppMenuId() {
        Object objValue = this.get(FIELD_PSAPPMENUID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappmenuid")
    public void setPSAppMenuId(String pSAppMenuId) {
        this.set(FIELD_PSAPPMENUID, pSAppMenuId);
    }

    @JsonIgnore
    public boolean isPSAppMenuIdDirty() {
        return this.contains(FIELD_PSAPPMENUID);
    }

    @JsonIgnore
    public String getPSAppMenuName() {
        Object objValue = this.get(FIELD_PSAPPMENUNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappmenuname")
    public void setPSAppMenuName(String pSAppMenuName) {
        this.set(FIELD_PSAPPMENUNAME, pSAppMenuName);
    }

    @JsonIgnore
    public boolean isPSAppMenuNameDirty() {
        return this.contains(FIELD_PSAPPMENUNAME);
    }

    @JsonIgnore
    public String getPSAppViewId() {
        Object objValue = this.get(FIELD_PSAPPVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappviewid")
    public void setPSAppViewId(String pSAppViewId) {
        this.set(FIELD_PSAPPVIEWID, pSAppViewId);
    }

    @JsonIgnore
    public boolean isPSAppViewIdDirty() {
        return this.contains(FIELD_PSAPPVIEWID);
    }

    @JsonIgnore
    public String getPSAppViewName() {
        Object objValue = this.get(FIELD_PSAPPVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappviewname")
    public void setPSAppViewName(String pSAppViewName) {
        this.set(FIELD_PSAPPVIEWNAME, pSAppViewName);
    }

    @JsonIgnore
    public boolean isPSAppViewNameDirty() {
        return this.contains(FIELD_PSAPPVIEWNAME);
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
    public String getPSDEDSId() {
        Object objValue = this.get(FIELD_PSDEDSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedsid")
    public void setPSDEDSId(String pSDEDSId) {
        this.set(FIELD_PSDEDSID, pSDEDSId);
    }

    @JsonIgnore
    public boolean isPSDEDSIdDirty() {
        return this.contains(FIELD_PSDEDSID);
    }

    @JsonIgnore
    public String getPSDEDSName() {
        Object objValue = this.get(FIELD_PSDEDSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedsname")
    public void setPSDEDSName(String pSDEDSName) {
        this.set(FIELD_PSDEDSNAME, pSDEDSName);
    }

    @JsonIgnore
    public boolean isPSDEDSNameDirty() {
        return this.contains(FIELD_PSDEDSNAME);
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
    public String getPSPortletId() {
        Object objValue = this.get(FIELD_PSPORTLETID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psportletid")
    public void setPSPortletId(String pSPortletId) {
        this.set(FIELD_PSPORTLETID, pSPortletId);
    }

    @JsonIgnore
    public boolean isPSPortletIdDirty() {
        return this.contains(FIELD_PSPORTLETID);
    }

    @JsonIgnore
    public String getPSPortletName() {
        Object objValue = this.get(FIELD_PSPORTLETNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psportletname")
    public void setPSPortletName(String pSPortletName) {
        this.set(FIELD_PSPORTLETNAME, pSPortletName);
    }

    @JsonIgnore
    public boolean isPSPortletNameDirty() {
        return this.contains(FIELD_PSPORTLETNAME);
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
    public String getPSSysPortletCatId() {
        Object objValue = this.get(FIELD_PSSYSPORTLETCATID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysportletcatid")
    public void setPSSysPortletCatId(String pSSysPortletCatId) {
        this.set(FIELD_PSSYSPORTLETCATID, pSSysPortletCatId);
    }

    @JsonIgnore
    public boolean isPSSysPortletCatIdDirty() {
        return this.contains(FIELD_PSSYSPORTLETCATID);
    }

    @JsonIgnore
    public String getPSSysPortletCatName() {
        Object objValue = this.get(FIELD_PSSYSPORTLETCATNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysportletcatname")
    public void setPSSysPortletCatName(String pSSysPortletCatName) {
        this.set(FIELD_PSSYSPORTLETCATNAME, pSSysPortletCatName);
    }

    @JsonIgnore
    public boolean isPSSysPortletCatNameDirty() {
        return this.contains(FIELD_PSSYSPORTLETCATNAME);
    }

    @JsonIgnore
    public String getPSSysPortletId() {
        Object objValue = this.get(FIELD_PSSYSPORTLETID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysportletid")
    public void setPSSysPortletId(String pSSysPortletId) {
        this.set(FIELD_PSSYSPORTLETID, pSSysPortletId);
    }

    @JsonIgnore
    public boolean isPSSysPortletIdDirty() {
        return this.contains(FIELD_PSSYSPORTLETID);
    }

    @JsonIgnore
    public String getPSSysPortletName() {
        Object objValue = this.get(FIELD_PSSYSPORTLETNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysportletname")
    public void setPSSysPortletName(String pSSysPortletName) {
        this.set(FIELD_PSSYSPORTLETNAME, pSSysPortletName);
    }

    @JsonIgnore
    public boolean isPSSysPortletNameDirty() {
        return this.contains(FIELD_PSSYSPORTLETNAME);
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
    public String getPSSysUniResId() {
        Object objValue = this.get(FIELD_PSSYSUNIRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysuniresid")
    public void setPSSysUniResId(String pSSysUniResId) {
        this.set(FIELD_PSSYSUNIRESID, pSSysUniResId);
    }

    @JsonIgnore
    public boolean isPSSysUniResIdDirty() {
        return this.contains(FIELD_PSSYSUNIRESID);
    }

    @JsonIgnore
    public String getPSSysUniResName() {
        Object objValue = this.get(FIELD_PSSYSUNIRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysuniresname")
    public void setPSSysUniResName(String pSSysUniResName) {
        this.set(FIELD_PSSYSUNIRESNAME, pSSysUniResName);
    }

    @JsonIgnore
    public boolean isPSSysUniResNameDirty() {
        return this.contains(FIELD_PSSYSUNIRESNAME);
    }

    @JsonIgnore
    public Integer getReloadTimer() {
        Object objValue = this.get(FIELD_RELOADTIMER);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="reloadtimer")
    public void setReloadTimer(Integer reloadTimer) {
        this.set(FIELD_RELOADTIMER, reloadTimer);
    }

    @JsonIgnore
    public boolean isReloadTimerDirty() {
        return this.contains(FIELD_RELOADTIMER);
    }

    @JsonIgnore
    public Integer getShowTitleBar() {
        Object objValue = this.get(FIELD_SHOWTITLEBAR);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="showtitlebar")
    public void setShowTitleBar(Integer showTitleBar) {
        this.set(FIELD_SHOWTITLEBAR, showTitleBar);
    }

    @JsonIgnore
    public boolean isShowTitleBarDirty() {
        return this.contains(FIELD_SHOWTITLEBAR);
    }

    @JsonIgnore
    public String getTemplEngine() {
        Object objValue = this.get(FIELD_TEMPLENGINE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="templengine")
    public void setTemplEngine(String templEngine) {
        this.set(FIELD_TEMPLENGINE, templEngine);
    }

    @JsonIgnore
    public boolean isTemplEngineDirty() {
        return this.contains(FIELD_TEMPLENGINE);
    }

    @JsonIgnore
    public String getTitlePSLanResId() {
        Object objValue = this.get(FIELD_TITLEPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="titlepslanresid")
    public void setTitlePSLanResId(String titlePSLanResId) {
        this.set(FIELD_TITLEPSLANRESID, titlePSLanResId);
    }

    @JsonIgnore
    public boolean isTitlePSLanResIdDirty() {
        return this.contains(FIELD_TITLEPSLANRESID);
    }

    @JsonIgnore
    public String getTitlePSLanResName() {
        Object objValue = this.get(FIELD_TITLEPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="titlepslanresname")
    public void setTitlePSLanResName(String titlePSLanResName) {
        this.set(FIELD_TITLEPSLANRESNAME, titlePSLanResName);
    }

    @JsonIgnore
    public boolean isTitlePSLanResNameDirty() {
        return this.contains(FIELD_TITLEPSLANRESNAME);
    }

    @JsonIgnore
    public String getTitlePSSysPFPluginId() {
        Object objValue = this.get(FIELD_TITLEPSSYSPFPLUGINID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="titlepssyspfpluginid")
    public void setTitlePSSysPFPluginId(String titlePSSysPFPluginId) {
        this.set(FIELD_TITLEPSSYSPFPLUGINID, titlePSSysPFPluginId);
    }

    @JsonIgnore
    public boolean isTitlePSSysPFPluginIdDirty() {
        return this.contains(FIELD_TITLEPSSYSPFPLUGINID);
    }

    @JsonIgnore
    public String getTitlePSSysPFPluginName() {
        Object objValue = this.get(FIELD_TITLEPSSYSPFPLUGINNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="titlepssyspfpluginname")
    public void setTitlePSSysPFPluginName(String titlePSSysPFPluginName) {
        this.set(FIELD_TITLEPSSYSPFPLUGINNAME, titlePSSysPFPluginName);
    }

    @JsonIgnore
    public boolean isTitlePSSysPFPluginNameDirty() {
        return this.contains(FIELD_TITLEPSSYSPFPLUGINNAME);
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

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSSysPortletId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSSysPortletId(strValue);
    }
}

