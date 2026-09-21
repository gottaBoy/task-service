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
import java.util.List;
import net.ibizsys.modelapi.dto.PSDEGEIUpdateDTO;
import net.ibizsys.modelapi.dto.PSDEGEIVRDTO;
import net.ibizsys.modelapi.dto.PSDEGridColDTO;
import net.ibizsys.modelapi.dto.PSDEGridLogicDTO;
import net.ibizsys.modelapi.util.PSModelDTOBase;

public class PSDEGridDTO
extends PSModelDTOBase {
    public static final String FIELD_AGGMODE = "aggmode";
    public static final String FIELD_AGGPSDEACTIONID = "aggpsdeactionid";
    public static final String FIELD_AGGPSDEACTIONNAME = "aggpsdeactionname";
    public static final String FIELD_AGGPSDEDSID = "aggpsdedsid";
    public static final String FIELD_AGGPSDEDSNAME = "aggpsdedsname";
    public static final String FIELD_AGGPSDEID = "aggpsdeid";
    public static final String FIELD_AGGPSDENAME = "aggpsdename";
    public static final String FIELD_AGGPSSYSVIEWPANELID = "aggpssysviewpanelid";
    public static final String FIELD_AGGPSSYSVIEWPANELNAME = "aggpssysviewpanelname";
    public static final String FIELD_BATPSDETOOLBARID = "batpsdetoolbarid";
    public static final String FIELD_BATPSDETOOLBARNAME = "batpsdetoolbarname";
    public static final String FIELD_BUFFERRENDERERMODE = "bufferrenderermode";
    public static final String FIELD_CODENAME = "codename";
    public static final String FIELD_COLENABLEFILTER = "colenablefilter";
    public static final String FIELD_COLENABLELINK = "colenablelink";
    public static final String FIELD_COPYPSDEACTIONID = "copypsdeactionid";
    public static final String FIELD_COPYPSDEACTIONNAME = "copypsdeactionname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CREATEPSDEACTIONID = "createpsdeactionid";
    public static final String FIELD_CREATEPSDEACTIONNAME = "createpsdeactionname";
    public static final String FIELD_CUSTOMCOND = "customcond";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_EMPTYTEXT = "emptytext";
    public static final String FIELD_EMPTYTEXTPSLANRESID = "emptytextpslanresid";
    public static final String FIELD_EMPTYTEXTPSLANRESNAME = "emptytextpslanresname";
    public static final String FIELD_ENABLEPAGINGBAR = "enablepagingbar";
    public static final String FIELD_FORCEFIT = "forcefit";
    public static final String FIELD_GETDRAFTPSDEACTIONID = "getdraftpsdeactionid";
    public static final String FIELD_GETDRAFTPSDEACTIONNAME = "getdraftpsdeactionname";
    public static final String FIELD_GETPSDEACTIONID = "getpsdeactionid";
    public static final String FIELD_GETPSDEACTIONNAME = "getpsdeactionname";
    public static final String FIELD_GRIDSN = "gridsn";
    public static final String FIELD_GRIDSTYLE = "gridstyle";
    public static final String FIELD_GROUPMODE = "groupmode";
    public static final String FIELD_GROUPPSCODELISTID = "grouppscodelistid";
    public static final String FIELD_GROUPPSCODELISTNAME = "grouppscodelistname";
    public static final String FIELD_GROUPPSDEFID = "grouppsdefid";
    public static final String FIELD_GROUPPSDEFNAME = "grouppsdefname";
    public static final String FIELD_GROUPPSDEUAGROUPID = "grouppsdeuagroupid";
    public static final String FIELD_GROUPPSDEUAGROUPNAME = "grouppsdeuagroupname";
    public static final String FIELD_GROUPPSSYSCSSID = "grouppssyscssid";
    public static final String FIELD_GROUPPSSYSCSSNAME = "grouppssyscssname";
    public static final String FIELD_GROUPPSSYSPFPLUGINID = "grouppssyspfpluginid";
    public static final String FIELD_GROUPPSSYSPFPLUGINNAME = "grouppssyspfpluginname";
    public static final String FIELD_IGNOREDSITEM = "ignoredsitem";
    public static final String FIELD_ITEMPSSYSCSSID = "itempssyscssid";
    public static final String FIELD_ITEMPSSYSCSSNAME = "itempssyscssname";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MINORSORTDIR = "minorsortdir";
    public static final String FIELD_MINORSORTPSDEFID = "minorsortpsdefid";
    public static final String FIELD_MINORSORTPSDEFNAME = "minorsortpsdefname";
    public static final String FIELD_NAVPSDERID = "navpsderid";
    public static final String FIELD_NAVPSDERNAME = "navpsdername";
    public static final String FIELD_NAVPSDEVIEWBASEID = "navpsdeviewbaseid";
    public static final String FIELD_NAVPSDEVIEWBASENAME = "navpsdeviewbasename";
    public static final String FIELD_NAVVIEWFILTER = "navviewfilter";
    public static final String FIELD_NAVVIEWPARAM = "navviewparam";
    public static final String FIELD_NOSORT = "nosort";
    public static final String FIELD_ORDERVALUEPSDEFID = "ordervaluepsdefid";
    public static final String FIELD_ORDERVALUEPSDEFNAME = "ordervaluepsdefname";
    public static final String FIELD_PAGINGSIZE = "pagingsize";
    public static final String FIELD_PSACHANDLERID = "psachandlerid";
    public static final String FIELD_PSACHANDLERNAME = "psachandlername";
    public static final String FIELD_PSCTRLLOGICGROUPID = "psctrllogicgroupid";
    public static final String FIELD_PSCTRLLOGICGROUPNAME = "psctrllogicgroupname";
    public static final String FIELD_PSCTRLMSGID = "psctrlmsgid";
    public static final String FIELD_PSCTRLMSGNAME = "psctrlmsgname";
    public static final String FIELD_PSDEDATASETID = "psdedatasetid";
    public static final String FIELD_PSDEDATASETNAME = "psdedatasetname";
    public static final String FIELD_PSDEGRIDID = "psdegridid";
    public static final String FIELD_PSDEGRIDNAME = "psdegridname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSSYSCSSID = "pssyscssid";
    public static final String FIELD_PSSYSCSSNAME = "pssyscssname";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    public static final String FIELD_PSSYSPFPLUGINID = "pssyspfpluginid";
    public static final String FIELD_PSSYSPFPLUGINNAME = "pssyspfpluginname";
    public static final String FIELD_PSSYSREQITEMID = "pssysreqitemid";
    public static final String FIELD_PSSYSREQITEMNAME = "pssysreqitemname";
    public static final String FIELD_QUICKPSDETOOLBARID = "quickpsdetoolbarid";
    public static final String FIELD_QUICKPSDETOOLBARNAME = "quickpsdetoolbarname";
    public static final String FIELD_REMOVEPSDEACTIONID = "removepsdeactionid";
    public static final String FIELD_REMOVEPSDEACTIONNAME = "removepsdeactionname";
    public static final String FIELD_SHOWHEADER = "showheader";
    public static final String FIELD_SORTMODE = "sortmode";
    public static final String FIELD_TODOTASK = "todotask";
    public static final String FIELD_TREEPPSDEFID = "treeppsdefid";
    public static final String FIELD_TREEPPSDEFNAME = "treeppsdefname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_UPDATEPSDEACTIONID = "updatepsdeactionid";
    public static final String FIELD_UPDATEPSDEACTIONNAME = "updatepsdeactionname";
    public static final String FIELD_USER2PSDEACTIONID = "user2psdeactionid";
    public static final String FIELD_USER2PSDEACTIONNAME = "user2psdeactionname";
    public static final String FIELD_USERPARAMS = "userparams";
    public static final String FIELD_USERPSDEACTIONID = "userpsdeactionid";
    public static final String FIELD_USERPSDEACTIONNAME = "userpsdeactionname";
    private List<PSDEGridColDTO> psdegridcols;
    private List<PSDEGEIUpdateDTO> psdegeiupdates;
    private List<PSDEGEIVRDTO> psdegeivrs;
    private List<PSDEGridLogicDTO> psdegridlogics;

    @JsonIgnore
    public String getAggMode() {
        Object objValue = this.get(FIELD_AGGMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="aggmode")
    public void setAggMode(String aggMode) {
        this.set(FIELD_AGGMODE, aggMode);
    }

    @JsonIgnore
    public boolean isAggModeDirty() {
        return this.contains(FIELD_AGGMODE);
    }

    @JsonIgnore
    public String getAggPSDEActionId() {
        Object objValue = this.get(FIELD_AGGPSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="aggpsdeactionid")
    public void setAggPSDEActionId(String aggPSDEActionId) {
        this.set(FIELD_AGGPSDEACTIONID, aggPSDEActionId);
    }

    @JsonIgnore
    public boolean isAggPSDEActionIdDirty() {
        return this.contains(FIELD_AGGPSDEACTIONID);
    }

    @JsonIgnore
    public String getAggPSDEActionName() {
        Object objValue = this.get(FIELD_AGGPSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="aggpsdeactionname")
    public void setAggPSDEActionName(String aggPSDEActionName) {
        this.set(FIELD_AGGPSDEACTIONNAME, aggPSDEActionName);
    }

    @JsonIgnore
    public boolean isAggPSDEActionNameDirty() {
        return this.contains(FIELD_AGGPSDEACTIONNAME);
    }

    @JsonIgnore
    public String getAggPSDEDSId() {
        Object objValue = this.get(FIELD_AGGPSDEDSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="aggpsdedsid")
    public void setAggPSDEDSId(String aggPSDEDSId) {
        this.set(FIELD_AGGPSDEDSID, aggPSDEDSId);
    }

    @JsonIgnore
    public boolean isAggPSDEDSIdDirty() {
        return this.contains(FIELD_AGGPSDEDSID);
    }

    @JsonIgnore
    public String getAggPSDEDSName() {
        Object objValue = this.get(FIELD_AGGPSDEDSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="aggpsdedsname")
    public void setAggPSDEDSName(String aggPSDEDSName) {
        this.set(FIELD_AGGPSDEDSNAME, aggPSDEDSName);
    }

    @JsonIgnore
    public boolean isAggPSDEDSNameDirty() {
        return this.contains(FIELD_AGGPSDEDSNAME);
    }

    @JsonIgnore
    public String getAggPSDEId() {
        Object objValue = this.get(FIELD_AGGPSDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="aggpsdeid")
    public void setAggPSDEId(String aggPSDEId) {
        this.set(FIELD_AGGPSDEID, aggPSDEId);
    }

    @JsonIgnore
    public boolean isAggPSDEIdDirty() {
        return this.contains(FIELD_AGGPSDEID);
    }

    @JsonIgnore
    public String getAggPSDEName() {
        Object objValue = this.get(FIELD_AGGPSDENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="aggpsdename")
    public void setAggPSDEName(String aggPSDEName) {
        this.set(FIELD_AGGPSDENAME, aggPSDEName);
    }

    @JsonIgnore
    public boolean isAggPSDENameDirty() {
        return this.contains(FIELD_AGGPSDENAME);
    }

    @JsonIgnore
    public String getAggPSSysViewPanelId() {
        Object objValue = this.get(FIELD_AGGPSSYSVIEWPANELID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="aggpssysviewpanelid")
    public void setAggPSSysViewPanelId(String aggPSSysViewPanelId) {
        this.set(FIELD_AGGPSSYSVIEWPANELID, aggPSSysViewPanelId);
    }

    @JsonIgnore
    public boolean isAggPSSysViewPanelIdDirty() {
        return this.contains(FIELD_AGGPSSYSVIEWPANELID);
    }

    @JsonIgnore
    public String getAggPSSysViewPanelName() {
        Object objValue = this.get(FIELD_AGGPSSYSVIEWPANELNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="aggpssysviewpanelname")
    public void setAggPSSysViewPanelName(String aggPSSysViewPanelName) {
        this.set(FIELD_AGGPSSYSVIEWPANELNAME, aggPSSysViewPanelName);
    }

    @JsonIgnore
    public boolean isAggPSSysViewPanelNameDirty() {
        return this.contains(FIELD_AGGPSSYSVIEWPANELNAME);
    }

    @JsonIgnore
    public String getBatPSDEToolbarId() {
        Object objValue = this.get(FIELD_BATPSDETOOLBARID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="batpsdetoolbarid")
    public void setBatPSDEToolbarId(String batPSDEToolbarId) {
        this.set(FIELD_BATPSDETOOLBARID, batPSDEToolbarId);
    }

    @JsonIgnore
    public boolean isBatPSDEToolbarIdDirty() {
        return this.contains(FIELD_BATPSDETOOLBARID);
    }

    @JsonIgnore
    public String getBatPSDEToolbarName() {
        Object objValue = this.get(FIELD_BATPSDETOOLBARNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="batpsdetoolbarname")
    public void setBatPSDEToolbarName(String batPSDEToolbarName) {
        this.set(FIELD_BATPSDETOOLBARNAME, batPSDEToolbarName);
    }

    @JsonIgnore
    public boolean isBatPSDEToolbarNameDirty() {
        return this.contains(FIELD_BATPSDETOOLBARNAME);
    }

    @JsonIgnore
    public Integer getBufferRendererMode() {
        Object objValue = this.get(FIELD_BUFFERRENDERERMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="bufferrenderermode")
    public void setBufferRendererMode(Integer bufferRendererMode) {
        this.set(FIELD_BUFFERRENDERERMODE, bufferRendererMode);
    }

    @JsonIgnore
    public boolean isBufferRendererModeDirty() {
        return this.contains(FIELD_BUFFERRENDERERMODE);
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
    public Integer getColEnableFilter() {
        Object objValue = this.get(FIELD_COLENABLEFILTER);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="colenablefilter")
    public void setColEnableFilter(Integer colEnableFilter) {
        this.set(FIELD_COLENABLEFILTER, colEnableFilter);
    }

    @JsonIgnore
    public boolean isColEnableFilterDirty() {
        return this.contains(FIELD_COLENABLEFILTER);
    }

    @JsonIgnore
    public Integer getColEnableLink() {
        Object objValue = this.get(FIELD_COLENABLELINK);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="colenablelink")
    public void setColEnableLink(Integer colEnableLink) {
        this.set(FIELD_COLENABLELINK, colEnableLink);
    }

    @JsonIgnore
    public boolean isColEnableLinkDirty() {
        return this.contains(FIELD_COLENABLELINK);
    }

    @JsonIgnore
    public String getCopyPSDEActionId() {
        Object objValue = this.get(FIELD_COPYPSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="copypsdeactionid")
    public void setCopyPSDEActionId(String copyPSDEActionId) {
        this.set(FIELD_COPYPSDEACTIONID, copyPSDEActionId);
    }

    @JsonIgnore
    public boolean isCopyPSDEActionIdDirty() {
        return this.contains(FIELD_COPYPSDEACTIONID);
    }

    @JsonIgnore
    public String getCopyPSDEActionName() {
        Object objValue = this.get(FIELD_COPYPSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="copypsdeactionname")
    public void setCopyPSDEActionName(String copyPSDEActionName) {
        this.set(FIELD_COPYPSDEACTIONNAME, copyPSDEActionName);
    }

    @JsonIgnore
    public boolean isCopyPSDEActionNameDirty() {
        return this.contains(FIELD_COPYPSDEACTIONNAME);
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
    public String getCreatePSDEActionId() {
        Object objValue = this.get(FIELD_CREATEPSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="createpsdeactionid")
    public void setCreatePSDEActionId(String createPSDEActionId) {
        this.set(FIELD_CREATEPSDEACTIONID, createPSDEActionId);
    }

    @JsonIgnore
    public boolean isCreatePSDEActionIdDirty() {
        return this.contains(FIELD_CREATEPSDEACTIONID);
    }

    @JsonIgnore
    public String getCreatePSDEActionName() {
        Object objValue = this.get(FIELD_CREATEPSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="createpsdeactionname")
    public void setCreatePSDEActionName(String createPSDEActionName) {
        this.set(FIELD_CREATEPSDEACTIONNAME, createPSDEActionName);
    }

    @JsonIgnore
    public boolean isCreatePSDEActionNameDirty() {
        return this.contains(FIELD_CREATEPSDEACTIONNAME);
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
    public Integer getForceFit() {
        Object objValue = this.get(FIELD_FORCEFIT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="forcefit")
    public void setForceFit(Integer forceFit) {
        this.set(FIELD_FORCEFIT, forceFit);
    }

    @JsonIgnore
    public boolean isForceFitDirty() {
        return this.contains(FIELD_FORCEFIT);
    }

    @JsonIgnore
    public String getGetDraftPSDEActionId() {
        Object objValue = this.get(FIELD_GETDRAFTPSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="getdraftpsdeactionid")
    public void setGetDraftPSDEActionId(String getDraftPSDEActionId) {
        this.set(FIELD_GETDRAFTPSDEACTIONID, getDraftPSDEActionId);
    }

    @JsonIgnore
    public boolean isGetDraftPSDEActionIdDirty() {
        return this.contains(FIELD_GETDRAFTPSDEACTIONID);
    }

    @JsonIgnore
    public String getGetDraftPSDEActionName() {
        Object objValue = this.get(FIELD_GETDRAFTPSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="getdraftpsdeactionname")
    public void setGetDraftPSDEActionName(String getDraftPSDEActionName) {
        this.set(FIELD_GETDRAFTPSDEACTIONNAME, getDraftPSDEActionName);
    }

    @JsonIgnore
    public boolean isGetDraftPSDEActionNameDirty() {
        return this.contains(FIELD_GETDRAFTPSDEACTIONNAME);
    }

    @JsonIgnore
    public String getGetPSDEActionId() {
        Object objValue = this.get(FIELD_GETPSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="getpsdeactionid")
    public void setGetPSDEActionId(String getPSDEActionId) {
        this.set(FIELD_GETPSDEACTIONID, getPSDEActionId);
    }

    @JsonIgnore
    public boolean isGetPSDEActionIdDirty() {
        return this.contains(FIELD_GETPSDEACTIONID);
    }

    @JsonIgnore
    public String getGetPSDEActionName() {
        Object objValue = this.get(FIELD_GETPSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="getpsdeactionname")
    public void setGetPSDEActionName(String getPSDEActionName) {
        this.set(FIELD_GETPSDEACTIONNAME, getPSDEActionName);
    }

    @JsonIgnore
    public boolean isGetPSDEActionNameDirty() {
        return this.contains(FIELD_GETPSDEACTIONNAME);
    }

    @JsonIgnore
    public String getGridSN() {
        Object objValue = this.get(FIELD_GRIDSN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="gridsn")
    public void setGridSN(String gridSN) {
        this.set(FIELD_GRIDSN, gridSN);
    }

    @JsonIgnore
    public boolean isGridSNDirty() {
        return this.contains(FIELD_GRIDSN);
    }

    @JsonIgnore
    public String getGridStyle() {
        Object objValue = this.get(FIELD_GRIDSTYLE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="gridstyle")
    public void setGridStyle(String gridStyle) {
        this.set(FIELD_GRIDSTYLE, gridStyle);
    }

    @JsonIgnore
    public boolean isGridStyleDirty() {
        return this.contains(FIELD_GRIDSTYLE);
    }

    @JsonIgnore
    public String getGroupMode() {
        Object objValue = this.get(FIELD_GROUPMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="groupmode")
    public void setGroupMode(String groupMode) {
        this.set(FIELD_GROUPMODE, groupMode);
    }

    @JsonIgnore
    public boolean isGroupModeDirty() {
        return this.contains(FIELD_GROUPMODE);
    }

    @JsonIgnore
    public String getGroupPSCodeListId() {
        Object objValue = this.get(FIELD_GROUPPSCODELISTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="grouppscodelistid")
    public void setGroupPSCodeListId(String groupPSCodeListId) {
        this.set(FIELD_GROUPPSCODELISTID, groupPSCodeListId);
    }

    @JsonIgnore
    public boolean isGroupPSCodeListIdDirty() {
        return this.contains(FIELD_GROUPPSCODELISTID);
    }

    @JsonIgnore
    public String getGroupPSCodeListName() {
        Object objValue = this.get(FIELD_GROUPPSCODELISTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="grouppscodelistname")
    public void setGroupPSCodeListName(String groupPSCodeListName) {
        this.set(FIELD_GROUPPSCODELISTNAME, groupPSCodeListName);
    }

    @JsonIgnore
    public boolean isGroupPSCodeListNameDirty() {
        return this.contains(FIELD_GROUPPSCODELISTNAME);
    }

    @JsonIgnore
    public String getGroupPSDEFId() {
        Object objValue = this.get(FIELD_GROUPPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="grouppsdefid")
    public void setGroupPSDEFId(String groupPSDEFId) {
        this.set(FIELD_GROUPPSDEFID, groupPSDEFId);
    }

    @JsonIgnore
    public boolean isGroupPSDEFIdDirty() {
        return this.contains(FIELD_GROUPPSDEFID);
    }

    @JsonIgnore
    public String getGroupPSDEFName() {
        Object objValue = this.get(FIELD_GROUPPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="grouppsdefname")
    public void setGroupPSDEFName(String groupPSDEFName) {
        this.set(FIELD_GROUPPSDEFNAME, groupPSDEFName);
    }

    @JsonIgnore
    public boolean isGroupPSDEFNameDirty() {
        return this.contains(FIELD_GROUPPSDEFNAME);
    }

    @JsonIgnore
    public String getGroupPSDEUAGroupId() {
        Object objValue = this.get(FIELD_GROUPPSDEUAGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="grouppsdeuagroupid")
    public void setGroupPSDEUAGroupId(String groupPSDEUAGroupId) {
        this.set(FIELD_GROUPPSDEUAGROUPID, groupPSDEUAGroupId);
    }

    @JsonIgnore
    public boolean isGroupPSDEUAGroupIdDirty() {
        return this.contains(FIELD_GROUPPSDEUAGROUPID);
    }

    @JsonIgnore
    public String getGroupPSDEUAGroupName() {
        Object objValue = this.get(FIELD_GROUPPSDEUAGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="grouppsdeuagroupname")
    public void setGroupPSDEUAGroupName(String groupPSDEUAGroupName) {
        this.set(FIELD_GROUPPSDEUAGROUPNAME, groupPSDEUAGroupName);
    }

    @JsonIgnore
    public boolean isGroupPSDEUAGroupNameDirty() {
        return this.contains(FIELD_GROUPPSDEUAGROUPNAME);
    }

    @JsonIgnore
    public String getGroupPSSysCssId() {
        Object objValue = this.get(FIELD_GROUPPSSYSCSSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="grouppssyscssid")
    public void setGroupPSSysCssId(String groupPSSysCssId) {
        this.set(FIELD_GROUPPSSYSCSSID, groupPSSysCssId);
    }

    @JsonIgnore
    public boolean isGroupPSSysCssIdDirty() {
        return this.contains(FIELD_GROUPPSSYSCSSID);
    }

    @JsonIgnore
    public String getGroupPSSysCssName() {
        Object objValue = this.get(FIELD_GROUPPSSYSCSSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="grouppssyscssname")
    public void setGroupPSSysCssName(String groupPSSysCssName) {
        this.set(FIELD_GROUPPSSYSCSSNAME, groupPSSysCssName);
    }

    @JsonIgnore
    public boolean isGroupPSSysCssNameDirty() {
        return this.contains(FIELD_GROUPPSSYSCSSNAME);
    }

    @JsonIgnore
    public String getGroupPSSysPFPluginId() {
        Object objValue = this.get(FIELD_GROUPPSSYSPFPLUGINID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="grouppssyspfpluginid")
    public void setGroupPSSysPFPluginId(String groupPSSysPFPluginId) {
        this.set(FIELD_GROUPPSSYSPFPLUGINID, groupPSSysPFPluginId);
    }

    @JsonIgnore
    public boolean isGroupPSSysPFPluginIdDirty() {
        return this.contains(FIELD_GROUPPSSYSPFPLUGINID);
    }

    @JsonIgnore
    public String getGroupPSSysPFPluginName() {
        Object objValue = this.get(FIELD_GROUPPSSYSPFPLUGINNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="grouppssyspfpluginname")
    public void setGroupPSSysPFPluginName(String groupPSSysPFPluginName) {
        this.set(FIELD_GROUPPSSYSPFPLUGINNAME, groupPSSysPFPluginName);
    }

    @JsonIgnore
    public boolean isGroupPSSysPFPluginNameDirty() {
        return this.contains(FIELD_GROUPPSSYSPFPLUGINNAME);
    }

    @JsonIgnore
    public Integer getIgnoreDSItem() {
        Object objValue = this.get(FIELD_IGNOREDSITEM);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="ignoredsitem")
    public void setIgnoreDSItem(Integer ignoreDSItem) {
        this.set(FIELD_IGNOREDSITEM, ignoreDSItem);
    }

    @JsonIgnore
    public boolean isIgnoreDSItemDirty() {
        return this.contains(FIELD_IGNOREDSITEM);
    }

    @JsonIgnore
    public String getItemPSSysCssId() {
        Object objValue = this.get(FIELD_ITEMPSSYSCSSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="itempssyscssid")
    public void setItemPSSysCssId(String itemPSSysCssId) {
        this.set(FIELD_ITEMPSSYSCSSID, itemPSSysCssId);
    }

    @JsonIgnore
    public boolean isItemPSSysCssIdDirty() {
        return this.contains(FIELD_ITEMPSSYSCSSID);
    }

    @JsonIgnore
    public String getItemPSSysCssName() {
        Object objValue = this.get(FIELD_ITEMPSSYSCSSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="itempssyscssname")
    public void setItemPSSysCssName(String itemPSSysCssName) {
        this.set(FIELD_ITEMPSSYSCSSNAME, itemPSSysCssName);
    }

    @JsonIgnore
    public boolean isItemPSSysCssNameDirty() {
        return this.contains(FIELD_ITEMPSSYSCSSNAME);
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
    public String getNavPSDERId() {
        Object objValue = this.get(FIELD_NAVPSDERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="navpsderid")
    public void setNavPSDERId(String navPSDERId) {
        this.set(FIELD_NAVPSDERID, navPSDERId);
    }

    @JsonIgnore
    public boolean isNavPSDERIdDirty() {
        return this.contains(FIELD_NAVPSDERID);
    }

    @JsonIgnore
    public String getNavPSDERName() {
        Object objValue = this.get(FIELD_NAVPSDERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="navpsdername")
    public void setNavPSDERName(String navPSDERName) {
        this.set(FIELD_NAVPSDERNAME, navPSDERName);
    }

    @JsonIgnore
    public boolean isNavPSDERNameDirty() {
        return this.contains(FIELD_NAVPSDERNAME);
    }

    @JsonIgnore
    public String getNavPSDEViewBaseId() {
        Object objValue = this.get(FIELD_NAVPSDEVIEWBASEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="navpsdeviewbaseid")
    public void setNavPSDEViewBaseId(String navPSDEViewBaseId) {
        this.set(FIELD_NAVPSDEVIEWBASEID, navPSDEViewBaseId);
    }

    @JsonIgnore
    public boolean isNavPSDEViewBaseIdDirty() {
        return this.contains(FIELD_NAVPSDEVIEWBASEID);
    }

    @JsonIgnore
    public String getNavPSDEViewBaseName() {
        Object objValue = this.get(FIELD_NAVPSDEVIEWBASENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="navpsdeviewbasename")
    public void setNavPSDEViewBaseName(String navPSDEViewBaseName) {
        this.set(FIELD_NAVPSDEVIEWBASENAME, navPSDEViewBaseName);
    }

    @JsonIgnore
    public boolean isNavPSDEViewBaseNameDirty() {
        return this.contains(FIELD_NAVPSDEVIEWBASENAME);
    }

    @JsonIgnore
    public String getNavViewFilter() {
        Object objValue = this.get(FIELD_NAVVIEWFILTER);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="navviewfilter")
    public void setNavViewFilter(String navViewFilter) {
        this.set(FIELD_NAVVIEWFILTER, navViewFilter);
    }

    @JsonIgnore
    public boolean isNavViewFilterDirty() {
        return this.contains(FIELD_NAVVIEWFILTER);
    }

    @JsonIgnore
    public String getNavViewParam() {
        Object objValue = this.get(FIELD_NAVVIEWPARAM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="navviewparam")
    public void setNavViewParam(String navViewParam) {
        this.set(FIELD_NAVVIEWPARAM, navViewParam);
    }

    @JsonIgnore
    public boolean isNavViewParamDirty() {
        return this.contains(FIELD_NAVVIEWPARAM);
    }

    @JsonIgnore
    public Integer getNoSort() {
        Object objValue = this.get(FIELD_NOSORT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="nosort")
    public void setNoSort(Integer noSort) {
        this.set(FIELD_NOSORT, noSort);
    }

    @JsonIgnore
    public boolean isNoSortDirty() {
        return this.contains(FIELD_NOSORT);
    }

    @JsonIgnore
    public String getOrderValuePSDEFId() {
        Object objValue = this.get(FIELD_ORDERVALUEPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ordervaluepsdefid")
    public void setOrderValuePSDEFId(String orderValuePSDEFId) {
        this.set(FIELD_ORDERVALUEPSDEFID, orderValuePSDEFId);
    }

    @JsonIgnore
    public boolean isOrderValuePSDEFIdDirty() {
        return this.contains(FIELD_ORDERVALUEPSDEFID);
    }

    @JsonIgnore
    public String getOrderValuePSDEFName() {
        Object objValue = this.get(FIELD_ORDERVALUEPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ordervaluepsdefname")
    public void setOrderValuePSDEFName(String orderValuePSDEFName) {
        this.set(FIELD_ORDERVALUEPSDEFNAME, orderValuePSDEFName);
    }

    @JsonIgnore
    public boolean isOrderValuePSDEFNameDirty() {
        return this.contains(FIELD_ORDERVALUEPSDEFNAME);
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
    public String getQuickPSDEToolbarId() {
        Object objValue = this.get(FIELD_QUICKPSDETOOLBARID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="quickpsdetoolbarid")
    public void setQuickPSDEToolbarId(String quickPSDEToolbarId) {
        this.set(FIELD_QUICKPSDETOOLBARID, quickPSDEToolbarId);
    }

    @JsonIgnore
    public boolean isQuickPSDEToolbarIdDirty() {
        return this.contains(FIELD_QUICKPSDETOOLBARID);
    }

    @JsonIgnore
    public String getQuickPSDEToolbarName() {
        Object objValue = this.get(FIELD_QUICKPSDETOOLBARNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="quickpsdetoolbarname")
    public void setQuickPSDEToolbarName(String quickPSDEToolbarName) {
        this.set(FIELD_QUICKPSDETOOLBARNAME, quickPSDEToolbarName);
    }

    @JsonIgnore
    public boolean isQuickPSDEToolbarNameDirty() {
        return this.contains(FIELD_QUICKPSDETOOLBARNAME);
    }

    @JsonIgnore
    public String getRemovePSDEActionId() {
        Object objValue = this.get(FIELD_REMOVEPSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="removepsdeactionid")
    public void setRemovePSDEActionId(String removePSDEActionId) {
        this.set(FIELD_REMOVEPSDEACTIONID, removePSDEActionId);
    }

    @JsonIgnore
    public boolean isRemovePSDEActionIdDirty() {
        return this.contains(FIELD_REMOVEPSDEACTIONID);
    }

    @JsonIgnore
    public String getRemovePSDEActionName() {
        Object objValue = this.get(FIELD_REMOVEPSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="removepsdeactionname")
    public void setRemovePSDEActionName(String removePSDEActionName) {
        this.set(FIELD_REMOVEPSDEACTIONNAME, removePSDEActionName);
    }

    @JsonIgnore
    public boolean isRemovePSDEActionNameDirty() {
        return this.contains(FIELD_REMOVEPSDEACTIONNAME);
    }

    @JsonIgnore
    public Integer getShowHeader() {
        Object objValue = this.get(FIELD_SHOWHEADER);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="showheader")
    public void setShowHeader(Integer showHeader) {
        this.set(FIELD_SHOWHEADER, showHeader);
    }

    @JsonIgnore
    public boolean isShowHeaderDirty() {
        return this.contains(FIELD_SHOWHEADER);
    }

    @JsonIgnore
    public String getSortMode() {
        Object objValue = this.get(FIELD_SORTMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="sortmode")
    public void setSortMode(String sortMode) {
        this.set(FIELD_SORTMODE, sortMode);
    }

    @JsonIgnore
    public boolean isSortModeDirty() {
        return this.contains(FIELD_SORTMODE);
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
    public String getTreePPSDEFId() {
        Object objValue = this.get(FIELD_TREEPPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="treeppsdefid")
    public void setTreePPSDEFId(String treePPSDEFId) {
        this.set(FIELD_TREEPPSDEFID, treePPSDEFId);
    }

    @JsonIgnore
    public boolean isTreePPSDEFIdDirty() {
        return this.contains(FIELD_TREEPPSDEFID);
    }

    @JsonIgnore
    public String getTreePPSDEFName() {
        Object objValue = this.get(FIELD_TREEPPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="treeppsdefname")
    public void setTreePPSDEFName(String treePPSDEFName) {
        this.set(FIELD_TREEPPSDEFNAME, treePPSDEFName);
    }

    @JsonIgnore
    public boolean isTreePPSDEFNameDirty() {
        return this.contains(FIELD_TREEPPSDEFNAME);
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
    public String getUpdatePSDEActionId() {
        Object objValue = this.get(FIELD_UPDATEPSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="updatepsdeactionid")
    public void setUpdatePSDEActionId(String updatePSDEActionId) {
        this.set(FIELD_UPDATEPSDEACTIONID, updatePSDEActionId);
    }

    @JsonIgnore
    public boolean isUpdatePSDEActionIdDirty() {
        return this.contains(FIELD_UPDATEPSDEACTIONID);
    }

    @JsonIgnore
    public String getUpdatePSDEActionName() {
        Object objValue = this.get(FIELD_UPDATEPSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="updatepsdeactionname")
    public void setUpdatePSDEActionName(String updatePSDEActionName) {
        this.set(FIELD_UPDATEPSDEACTIONNAME, updatePSDEActionName);
    }

    @JsonIgnore
    public boolean isUpdatePSDEActionNameDirty() {
        return this.contains(FIELD_UPDATEPSDEACTIONNAME);
    }

    @JsonIgnore
    public String getUser2PSDEActionId() {
        Object objValue = this.get(FIELD_USER2PSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="user2psdeactionid")
    public void setUser2PSDEActionId(String user2PSDEActionId) {
        this.set(FIELD_USER2PSDEACTIONID, user2PSDEActionId);
    }

    @JsonIgnore
    public boolean isUser2PSDEActionIdDirty() {
        return this.contains(FIELD_USER2PSDEACTIONID);
    }

    @JsonIgnore
    public String getUser2PSDEActionName() {
        Object objValue = this.get(FIELD_USER2PSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="user2psdeactionname")
    public void setUser2PSDEActionName(String user2PSDEActionName) {
        this.set(FIELD_USER2PSDEACTIONNAME, user2PSDEActionName);
    }

    @JsonIgnore
    public boolean isUser2PSDEActionNameDirty() {
        return this.contains(FIELD_USER2PSDEACTIONNAME);
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
    public String getUserPSDEActionId() {
        Object objValue = this.get(FIELD_USERPSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="userpsdeactionid")
    public void setUserPSDEActionId(String userPSDEActionId) {
        this.set(FIELD_USERPSDEACTIONID, userPSDEActionId);
    }

    @JsonIgnore
    public boolean isUserPSDEActionIdDirty() {
        return this.contains(FIELD_USERPSDEACTIONID);
    }

    @JsonIgnore
    public String getUserPSDEActionName() {
        Object objValue = this.get(FIELD_USERPSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="userpsdeactionname")
    public void setUserPSDEActionName(String userPSDEActionName) {
        this.set(FIELD_USERPSDEACTIONNAME, userPSDEActionName);
    }

    @JsonIgnore
    public boolean isUserPSDEActionNameDirty() {
        return this.contains(FIELD_USERPSDEACTIONNAME);
    }

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDEGridId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSDEGridId(strValue);
    }

    @JsonProperty(value="psdegridcols")
    public List<PSDEGridColDTO> getPsdegridcols() {
        return this.psdegridcols;
    }

    @JsonProperty(value="psdegridcols")
    public void setPsdegridcols(List<PSDEGridColDTO> psdegridcols) {
        this.psdegridcols = psdegridcols;
    }

    @JsonProperty(value="psdegeiupdates")
    public List<PSDEGEIUpdateDTO> getPsdegeiupdates() {
        return this.psdegeiupdates;
    }

    @JsonProperty(value="psdegeiupdates")
    public void setPsdegeiupdates(List<PSDEGEIUpdateDTO> psdegeiupdates) {
        this.psdegeiupdates = psdegeiupdates;
    }

    @JsonProperty(value="psdegeivrs")
    public List<PSDEGEIVRDTO> getPsdegeivrs() {
        return this.psdegeivrs;
    }

    @JsonProperty(value="psdegeivrs")
    public void setPsdegeivrs(List<PSDEGEIVRDTO> psdegeivrs) {
        this.psdegeivrs = psdegeivrs;
    }

    @JsonProperty(value="psdegridlogics")
    public List<PSDEGridLogicDTO> getPsdegridlogics() {
        return this.psdegridlogics;
    }

    @JsonProperty(value="psdegridlogics")
    public void setPsdegridlogics(List<PSDEGridLogicDTO> psdegridlogics) {
        this.psdegridlogics = psdegridlogics;
    }
}

