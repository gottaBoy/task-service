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
import net.ibizsys.modelapi.domain.PSSysCalendarItemRV;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSSysCalendarItem
extends PSModelBase {
    public static final String FIELD_BEGINPSDEFID = "beginpsdefid";
    public static final String FIELD_BEGINPSDEFNAME = "beginpsdefname";
    public static final String FIELD_BKCOLOR = "bkcolor";
    public static final String FIELD_BKCOLORPSDEFID = "bkcolorpsdefid";
    public static final String FIELD_BKCOLORPSDEFNAME = "bkcolorpsdefname";
    public static final String FIELD_CLSPSDEFID = "clspsdefid";
    public static final String FIELD_CLSPSDEFNAME = "clspsdefname";
    public static final String FIELD_COLOR = "color";
    public static final String FIELD_COLORPSDEFID = "colorpsdefid";
    public static final String FIELD_COLORPSDEFNAME = "colorpsdefname";
    public static final String FIELD_CONTENTPSDEFID = "contentpsdefid";
    public static final String FIELD_CONTENTPSDEFNAME = "contentpsdefname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CREATEPSDEACTIONID = "createpsdeactionid";
    public static final String FIELD_CREATEPSDEACTIONNAME = "createpsdeactionname";
    public static final String FIELD_CREATEPSDEOPPRIVID = "createpsdeopprivid";
    public static final String FIELD_CREATEPSDEOPPRIVNAME = "createpsdeopprivname";
    public static final String FIELD_CUSTOMCOND = "customcond";
    public static final String FIELD_DATA2PSDEFID = "data2psdefid";
    public static final String FIELD_DATA2PSDEFNAME = "data2psdefname";
    public static final String FIELD_DATAPSDEFID = "datapsdefid";
    public static final String FIELD_DATAPSDEFNAME = "datapsdefname";
    public static final String FIELD_DYNACLASS = "dynaclass";
    public static final String FIELD_EDITMODE = "editmode";
    public static final String FIELD_ENABLEVIEWACTIONS = "enableviewactions";
    public static final String FIELD_ENDPSDEFID = "endpsdefid";
    public static final String FIELD_ENDPSDEFNAME = "endpsdefname";
    public static final String FIELD_FINISHPSDEFID = "finishpsdefid";
    public static final String FIELD_FINISHPSDEFNAME = "finishpsdefname";
    public static final String FIELD_GANTTPSSYSPFPLUGINID = "ganttpssyspfpluginid";
    public static final String FIELD_GANTTPSSYSPFPLUGINNAME = "ganttpssyspfpluginname";
    public static final String FIELD_ICONPSDEFID = "iconpsdefid";
    public static final String FIELD_ICONPSDEFNAME = "iconpsdefname";
    public static final String FIELD_ITEMSTYLE = "itemstyle";
    public static final String FIELD_ITEMSTYLETEXT = "itemstyletext";
    public static final String FIELD_ITEMTYPE = "itemtype";
    public static final String FIELD_KEYPSDEFID = "keypsdefid";
    public static final String FIELD_KEYPSDEFNAME = "keypsdefname";
    public static final String FIELD_LEVELPSDEFID = "levelpsdefid";
    public static final String FIELD_LEVELPSDEFNAME = "levelpsdefname";
    public static final String FIELD_MAXSIZE = "maxsize";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MODELOBJ = "modelobj";
    public static final String FIELD_NAMEPSLANRESID = "namepslanresid";
    public static final String FIELD_NAMEPSLANRESNAME = "namepslanresname";
    public static final String FIELD_NAVVIEWFILTER = "navviewfilter";
    public static final String FIELD_NAVVIEWPARAM = "navviewparam";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_ORDERVALUEPSDEFID = "ordervaluepsdefid";
    public static final String FIELD_ORDERVALUEPSDEFNAME = "ordervaluepsdefname";
    public static final String FIELD_PKEYPSDEFID = "pkeypsdefid";
    public static final String FIELD_PKEYPSDEFNAME = "pkeypsdefname";
    public static final String FIELD_PSDEDSID = "psdedsid";
    public static final String FIELD_PSDEDSNAME = "psdedsname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDELOGICID = "psdelogicid";
    public static final String FIELD_PSDELOGICNAME = "psdelogicname";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSDERID = "psderid";
    public static final String FIELD_PSDERNAME = "psdername";
    public static final String FIELD_PSDETOOLBARID = "psdetoolbarid";
    public static final String FIELD_PSDETOOLBARNAME = "psdetoolbarname";
    public static final String FIELD_PSDEVIEWBASEID = "psdeviewbaseid";
    public static final String FIELD_PSDEVIEWBASENAME = "psdeviewbasename";
    public static final String FIELD_PSSYSCALENDARID = "pssyscalendarid";
    public static final String FIELD_PSSYSCALENDARITEMID = "pssyscalendaritemid";
    public static final String FIELD_PSSYSCALENDARITEMNAME = "pssyscalendaritemname";
    public static final String FIELD_PSSYSCALENDARNAME = "pssyscalendarname";
    public static final String FIELD_PSSYSCSSID = "pssyscssid";
    public static final String FIELD_PSSYSCSSNAME = "pssyscssname";
    public static final String FIELD_PSSYSIMAGEID = "pssysimageid";
    public static final String FIELD_PSSYSIMAGENAME = "pssysimagename";
    public static final String FIELD_PSSYSPFPLUGINID = "pssyspfpluginid";
    public static final String FIELD_PSSYSPFPLUGINNAME = "pssyspfpluginname";
    public static final String FIELD_PSSYSVIEWPANELID = "pssysviewpanelid";
    public static final String FIELD_PSSYSVIEWPANELNAME = "pssysviewpanelname";
    public static final String FIELD_REMOVEPSDEACTIONID = "removepsdeactionid";
    public static final String FIELD_REMOVEPSDEACTIONNAME = "removepsdeactionname";
    public static final String FIELD_REMOVEPSDEOPPRIVID = "removepsdeopprivid";
    public static final String FIELD_REMOVEPSDEOPPRIVNAME = "removepsdeopprivname";
    public static final String FIELD_TAG2PSDEFID = "tag2psdefid";
    public static final String FIELD_TAG2PSDEFNAME = "tag2psdefname";
    public static final String FIELD_TAGPSDEFID = "tagpsdefid";
    public static final String FIELD_TAGPSDEFNAME = "tagpsdefname";
    public static final String FIELD_TEXTPSDEFID = "textpsdefid";
    public static final String FIELD_TEXTPSDEFNAME = "textpsdefname";
    public static final String FIELD_TIPSPSDEFID = "tipspsdefid";
    public static final String FIELD_TIPSPSDEFNAME = "tipspsdefname";
    public static final String FIELD_TOTALPSDEFID = "totalpsdefid";
    public static final String FIELD_TOTALPSDEFNAME = "totalpsdefname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_UPDATEPSDEACTIONID = "updatepsdeactionid";
    public static final String FIELD_UPDATEPSDEACTIONNAME = "updatepsdeactionname";
    public static final String FIELD_UPDATEPSDEOPPRIVID = "updatepsdeopprivid";
    public static final String FIELD_UPDATEPSDEOPPRIVNAME = "updatepsdeopprivname";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";
    public static final String FIELD_VIEWACTIONS = "viewactions";
    private List<PSSysCalendarItemRV> pssyscalendaritemrvs;

    @JsonIgnore
    public String getBeginPSDEFId() {
        Object objValue = this.get(FIELD_BEGINPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="beginpsdefid")
    public void setBeginPSDEFId(String beginPSDEFId) {
        this.set(FIELD_BEGINPSDEFID, beginPSDEFId);
    }

    @JsonIgnore
    public boolean isBeginPSDEFIdDirty() {
        return this.contains(FIELD_BEGINPSDEFID);
    }

    @JsonIgnore
    public String getBeginPSDEFName() {
        Object objValue = this.get(FIELD_BEGINPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="beginpsdefname")
    public void setBeginPSDEFName(String beginPSDEFName) {
        this.set(FIELD_BEGINPSDEFNAME, beginPSDEFName);
    }

    @JsonIgnore
    public boolean isBeginPSDEFNameDirty() {
        return this.contains(FIELD_BEGINPSDEFNAME);
    }

    @JsonIgnore
    public String getBKColor() {
        Object objValue = this.get(FIELD_BKCOLOR);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="bkcolor")
    public void setBKColor(String bKColor) {
        this.set(FIELD_BKCOLOR, bKColor);
    }

    @JsonIgnore
    public boolean isBKColorDirty() {
        return this.contains(FIELD_BKCOLOR);
    }

    @JsonIgnore
    public String getBKColorPSDEFId() {
        Object objValue = this.get(FIELD_BKCOLORPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="bkcolorpsdefid")
    public void setBKColorPSDEFId(String bKColorPSDEFId) {
        this.set(FIELD_BKCOLORPSDEFID, bKColorPSDEFId);
    }

    @JsonIgnore
    public boolean isBKColorPSDEFIdDirty() {
        return this.contains(FIELD_BKCOLORPSDEFID);
    }

    @JsonIgnore
    public String getBKColorPSDEFName() {
        Object objValue = this.get(FIELD_BKCOLORPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="bkcolorpsdefname")
    public void setBKColorPSDEFName(String bKColorPSDEFName) {
        this.set(FIELD_BKCOLORPSDEFNAME, bKColorPSDEFName);
    }

    @JsonIgnore
    public boolean isBKColorPSDEFNameDirty() {
        return this.contains(FIELD_BKCOLORPSDEFNAME);
    }

    @JsonIgnore
    public String getClsPSDEFId() {
        Object objValue = this.get(FIELD_CLSPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="clspsdefid")
    public void setClsPSDEFId(String clsPSDEFId) {
        this.set(FIELD_CLSPSDEFID, clsPSDEFId);
    }

    @JsonIgnore
    public boolean isClsPSDEFIdDirty() {
        return this.contains(FIELD_CLSPSDEFID);
    }

    @JsonIgnore
    public String getClsPSDEFName() {
        Object objValue = this.get(FIELD_CLSPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="clspsdefname")
    public void setClsPSDEFName(String clsPSDEFName) {
        this.set(FIELD_CLSPSDEFNAME, clsPSDEFName);
    }

    @JsonIgnore
    public boolean isClsPSDEFNameDirty() {
        return this.contains(FIELD_CLSPSDEFNAME);
    }

    @JsonIgnore
    public String getColor() {
        Object objValue = this.get(FIELD_COLOR);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="color")
    public void setColor(String color) {
        this.set(FIELD_COLOR, color);
    }

    @JsonIgnore
    public boolean isColorDirty() {
        return this.contains(FIELD_COLOR);
    }

    @JsonIgnore
    public String getColorPSDEFId() {
        Object objValue = this.get(FIELD_COLORPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="colorpsdefid")
    public void setColorPSDEFId(String colorPSDEFId) {
        this.set(FIELD_COLORPSDEFID, colorPSDEFId);
    }

    @JsonIgnore
    public boolean isColorPSDEFIdDirty() {
        return this.contains(FIELD_COLORPSDEFID);
    }

    @JsonIgnore
    public String getColorPSDEFName() {
        Object objValue = this.get(FIELD_COLORPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="colorpsdefname")
    public void setColorPSDEFName(String colorPSDEFName) {
        this.set(FIELD_COLORPSDEFNAME, colorPSDEFName);
    }

    @JsonIgnore
    public boolean isColorPSDEFNameDirty() {
        return this.contains(FIELD_COLORPSDEFNAME);
    }

    @JsonIgnore
    public String getContentPSDEFId() {
        Object objValue = this.get(FIELD_CONTENTPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="contentpsdefid")
    public void setContentPSDEFId(String contentPSDEFId) {
        this.set(FIELD_CONTENTPSDEFID, contentPSDEFId);
    }

    @JsonIgnore
    public boolean isContentPSDEFIdDirty() {
        return this.contains(FIELD_CONTENTPSDEFID);
    }

    @JsonIgnore
    public String getContentPSDEFName() {
        Object objValue = this.get(FIELD_CONTENTPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="contentpsdefname")
    public void setContentPSDEFName(String contentPSDEFName) {
        this.set(FIELD_CONTENTPSDEFNAME, contentPSDEFName);
    }

    @JsonIgnore
    public boolean isContentPSDEFNameDirty() {
        return this.contains(FIELD_CONTENTPSDEFNAME);
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
    public String getCreatePSDEOPPrivId() {
        Object objValue = this.get(FIELD_CREATEPSDEOPPRIVID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="createpsdeopprivid")
    public void setCreatePSDEOPPrivId(String createPSDEOPPrivId) {
        this.set(FIELD_CREATEPSDEOPPRIVID, createPSDEOPPrivId);
    }

    @JsonIgnore
    public boolean isCreatePSDEOPPrivIdDirty() {
        return this.contains(FIELD_CREATEPSDEOPPRIVID);
    }

    @JsonIgnore
    public String getCreatePSDEOPPrivName() {
        Object objValue = this.get(FIELD_CREATEPSDEOPPRIVNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="createpsdeopprivname")
    public void setCreatePSDEOPPrivName(String createPSDEOPPrivName) {
        this.set(FIELD_CREATEPSDEOPPRIVNAME, createPSDEOPPrivName);
    }

    @JsonIgnore
    public boolean isCreatePSDEOPPrivNameDirty() {
        return this.contains(FIELD_CREATEPSDEOPPRIVNAME);
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
    public String getData2PSDEFId() {
        Object objValue = this.get(FIELD_DATA2PSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="data2psdefid")
    public void setData2PSDEFId(String data2PSDEFId) {
        this.set(FIELD_DATA2PSDEFID, data2PSDEFId);
    }

    @JsonIgnore
    public boolean isData2PSDEFIdDirty() {
        return this.contains(FIELD_DATA2PSDEFID);
    }

    @JsonIgnore
    public String getData2PSDEFName() {
        Object objValue = this.get(FIELD_DATA2PSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="data2psdefname")
    public void setData2PSDEFName(String data2PSDEFName) {
        this.set(FIELD_DATA2PSDEFNAME, data2PSDEFName);
    }

    @JsonIgnore
    public boolean isData2PSDEFNameDirty() {
        return this.contains(FIELD_DATA2PSDEFNAME);
    }

    @JsonIgnore
    public String getDataPSDEFId() {
        Object objValue = this.get(FIELD_DATAPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="datapsdefid")
    public void setDataPSDEFId(String dataPSDEFId) {
        this.set(FIELD_DATAPSDEFID, dataPSDEFId);
    }

    @JsonIgnore
    public boolean isDataPSDEFIdDirty() {
        return this.contains(FIELD_DATAPSDEFID);
    }

    @JsonIgnore
    public String getDataPSDEFName() {
        Object objValue = this.get(FIELD_DATAPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="datapsdefname")
    public void setDataPSDEFName(String dataPSDEFName) {
        this.set(FIELD_DATAPSDEFNAME, dataPSDEFName);
    }

    @JsonIgnore
    public boolean isDataPSDEFNameDirty() {
        return this.contains(FIELD_DATAPSDEFNAME);
    }

    @JsonIgnore
    public String getDynaClass() {
        Object objValue = this.get(FIELD_DYNACLASS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dynaclass")
    public void setDynaClass(String dynaClass) {
        this.set(FIELD_DYNACLASS, dynaClass);
    }

    @JsonIgnore
    public boolean isDynaClassDirty() {
        return this.contains(FIELD_DYNACLASS);
    }

    @JsonIgnore
    public Integer getEditMode() {
        Object objValue = this.get(FIELD_EDITMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="editmode")
    public void setEditMode(Integer editMode) {
        this.set(FIELD_EDITMODE, editMode);
    }

    @JsonIgnore
    public boolean isEditModeDirty() {
        return this.contains(FIELD_EDITMODE);
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
    public String getEndPSDEFId() {
        Object objValue = this.get(FIELD_ENDPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="endpsdefid")
    public void setEndPSDEFId(String endPSDEFId) {
        this.set(FIELD_ENDPSDEFID, endPSDEFId);
    }

    @JsonIgnore
    public boolean isEndPSDEFIdDirty() {
        return this.contains(FIELD_ENDPSDEFID);
    }

    @JsonIgnore
    public String getEndPSDEFName() {
        Object objValue = this.get(FIELD_ENDPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="endpsdefname")
    public void setEndPSDEFName(String endPSDEFName) {
        this.set(FIELD_ENDPSDEFNAME, endPSDEFName);
    }

    @JsonIgnore
    public boolean isEndPSDEFNameDirty() {
        return this.contains(FIELD_ENDPSDEFNAME);
    }

    @JsonIgnore
    public String getFinishPSDEFId() {
        Object objValue = this.get(FIELD_FINISHPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="finishpsdefid")
    public void setFinishPSDEFId(String finishPSDEFId) {
        this.set(FIELD_FINISHPSDEFID, finishPSDEFId);
    }

    @JsonIgnore
    public boolean isFinishPSDEFIdDirty() {
        return this.contains(FIELD_FINISHPSDEFID);
    }

    @JsonIgnore
    public String getFinishPSDEFName() {
        Object objValue = this.get(FIELD_FINISHPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="finishpsdefname")
    public void setFinishPSDEFName(String finishPSDEFName) {
        this.set(FIELD_FINISHPSDEFNAME, finishPSDEFName);
    }

    @JsonIgnore
    public boolean isFinishPSDEFNameDirty() {
        return this.contains(FIELD_FINISHPSDEFNAME);
    }

    @JsonIgnore
    public String getGanttPSSysPFPluginId() {
        Object objValue = this.get(FIELD_GANTTPSSYSPFPLUGINID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ganttpssyspfpluginid")
    public void setGanttPSSysPFPluginId(String ganttPSSysPFPluginId) {
        this.set(FIELD_GANTTPSSYSPFPLUGINID, ganttPSSysPFPluginId);
    }

    @JsonIgnore
    public boolean isGanttPSSysPFPluginIdDirty() {
        return this.contains(FIELD_GANTTPSSYSPFPLUGINID);
    }

    @JsonIgnore
    public String getGanttPSSysPFPluginName() {
        Object objValue = this.get(FIELD_GANTTPSSYSPFPLUGINNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ganttpssyspfpluginname")
    public void setGanttPSSysPFPluginName(String ganttPSSysPFPluginName) {
        this.set(FIELD_GANTTPSSYSPFPLUGINNAME, ganttPSSysPFPluginName);
    }

    @JsonIgnore
    public boolean isGanttPSSysPFPluginNameDirty() {
        return this.contains(FIELD_GANTTPSSYSPFPLUGINNAME);
    }

    @JsonIgnore
    public String getIconPSDEFId() {
        Object objValue = this.get(FIELD_ICONPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="iconpsdefid")
    public void setIconPSDEFId(String iconPSDEFId) {
        this.set(FIELD_ICONPSDEFID, iconPSDEFId);
    }

    @JsonIgnore
    public boolean isIconPSDEFIdDirty() {
        return this.contains(FIELD_ICONPSDEFID);
    }

    @JsonIgnore
    public String getIconPSDEFName() {
        Object objValue = this.get(FIELD_ICONPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="iconpsdefname")
    public void setIconPSDEFName(String iconPSDEFName) {
        this.set(FIELD_ICONPSDEFNAME, iconPSDEFName);
    }

    @JsonIgnore
    public boolean isIconPSDEFNameDirty() {
        return this.contains(FIELD_ICONPSDEFNAME);
    }

    @JsonIgnore
    public String getItemStyle() {
        Object objValue = this.get(FIELD_ITEMSTYLE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="itemstyle")
    public void setItemStyle(String itemStyle) {
        this.set(FIELD_ITEMSTYLE, itemStyle);
    }

    @JsonIgnore
    public boolean isItemStyleDirty() {
        return this.contains(FIELD_ITEMSTYLE);
    }

    @JsonIgnore
    public String getItemStyleText() {
        Object objValue = this.get(FIELD_ITEMSTYLETEXT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="itemstyletext")
    public void setItemStyleText(String itemStyleText) {
        this.set(FIELD_ITEMSTYLETEXT, itemStyleText);
    }

    @JsonIgnore
    public boolean isItemStyleTextDirty() {
        return this.contains(FIELD_ITEMSTYLETEXT);
    }

    @JsonIgnore
    public String getItemType() {
        Object objValue = this.get(FIELD_ITEMTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="itemtype")
    public void setItemType(String itemType) {
        this.set(FIELD_ITEMTYPE, itemType);
    }

    @JsonIgnore
    public boolean isItemTypeDirty() {
        return this.contains(FIELD_ITEMTYPE);
    }

    @JsonIgnore
    public String getKeyPSDEFId() {
        Object objValue = this.get(FIELD_KEYPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="keypsdefid")
    public void setKeyPSDEFId(String keyPSDEFId) {
        this.set(FIELD_KEYPSDEFID, keyPSDEFId);
    }

    @JsonIgnore
    public boolean isKeyPSDEFIdDirty() {
        return this.contains(FIELD_KEYPSDEFID);
    }

    @JsonIgnore
    public String getKeyPSDEFName() {
        Object objValue = this.get(FIELD_KEYPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="keypsdefname")
    public void setKeyPSDEFName(String keyPSDEFName) {
        this.set(FIELD_KEYPSDEFNAME, keyPSDEFName);
    }

    @JsonIgnore
    public boolean isKeyPSDEFNameDirty() {
        return this.contains(FIELD_KEYPSDEFNAME);
    }

    @JsonIgnore
    public String getLevelPSDEFId() {
        Object objValue = this.get(FIELD_LEVELPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="levelpsdefid")
    public void setLevelPSDEFId(String levelPSDEFId) {
        this.set(FIELD_LEVELPSDEFID, levelPSDEFId);
    }

    @JsonIgnore
    public boolean isLevelPSDEFIdDirty() {
        return this.contains(FIELD_LEVELPSDEFID);
    }

    @JsonIgnore
    public String getLevelPSDEFName() {
        Object objValue = this.get(FIELD_LEVELPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="levelpsdefname")
    public void setLevelPSDEFName(String levelPSDEFName) {
        this.set(FIELD_LEVELPSDEFNAME, levelPSDEFName);
    }

    @JsonIgnore
    public boolean isLevelPSDEFNameDirty() {
        return this.contains(FIELD_LEVELPSDEFNAME);
    }

    @JsonIgnore
    public Integer getMaxSize() {
        Object objValue = this.get(FIELD_MAXSIZE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="maxsize")
    public void setMaxSize(Integer maxSize) {
        this.set(FIELD_MAXSIZE, maxSize);
    }

    @JsonIgnore
    public boolean isMaxSizeDirty() {
        return this.contains(FIELD_MAXSIZE);
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
    public String getModelObj() {
        Object objValue = this.get(FIELD_MODELOBJ);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="modelobj")
    public void setModelObj(String modelObj) {
        this.set(FIELD_MODELOBJ, modelObj);
    }

    @JsonIgnore
    public boolean isModelObjDirty() {
        return this.contains(FIELD_MODELOBJ);
    }

    @JsonIgnore
    public String getNamePSLanResId() {
        Object objValue = this.get(FIELD_NAMEPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="namepslanresid")
    public void setNamePSLanResId(String namePSLanResId) {
        this.set(FIELD_NAMEPSLANRESID, namePSLanResId);
    }

    @JsonIgnore
    public boolean isNamePSLanResIdDirty() {
        return this.contains(FIELD_NAMEPSLANRESID);
    }

    @JsonIgnore
    public String getNamePSLanResName() {
        Object objValue = this.get(FIELD_NAMEPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="namepslanresname")
    public void setNamePSLanResName(String namePSLanResName) {
        this.set(FIELD_NAMEPSLANRESNAME, namePSLanResName);
    }

    @JsonIgnore
    public boolean isNamePSLanResNameDirty() {
        return this.contains(FIELD_NAMEPSLANRESNAME);
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
    public String getPKeyPSDEFId() {
        Object objValue = this.get(FIELD_PKEYPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pkeypsdefid")
    public void setPKeyPSDEFId(String pKeyPSDEFId) {
        this.set(FIELD_PKEYPSDEFID, pKeyPSDEFId);
    }

    @JsonIgnore
    public boolean isPKeyPSDEFIdDirty() {
        return this.contains(FIELD_PKEYPSDEFID);
    }

    @JsonIgnore
    public String getPKeyPSDEFName() {
        Object objValue = this.get(FIELD_PKEYPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pkeypsdefname")
    public void setPKeyPSDEFName(String pKeyPSDEFName) {
        this.set(FIELD_PKEYPSDEFNAME, pKeyPSDEFName);
    }

    @JsonIgnore
    public boolean isPKeyPSDEFNameDirty() {
        return this.contains(FIELD_PKEYPSDEFNAME);
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
    public String getPSDELogicId() {
        Object objValue = this.get(FIELD_PSDELOGICID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdelogicid")
    public void setPSDELogicId(String pSDELogicId) {
        this.set(FIELD_PSDELOGICID, pSDELogicId);
    }

    @JsonIgnore
    public boolean isPSDELogicIdDirty() {
        return this.contains(FIELD_PSDELOGICID);
    }

    @JsonIgnore
    public String getPSDELogicName() {
        Object objValue = this.get(FIELD_PSDELOGICNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdelogicname")
    public void setPSDELogicName(String pSDELogicName) {
        this.set(FIELD_PSDELOGICNAME, pSDELogicName);
    }

    @JsonIgnore
    public boolean isPSDELogicNameDirty() {
        return this.contains(FIELD_PSDELOGICNAME);
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
    public String getPSDERId() {
        Object objValue = this.get(FIELD_PSDERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psderid")
    public void setPSDERId(String pSDERId) {
        this.set(FIELD_PSDERID, pSDERId);
    }

    @JsonIgnore
    public boolean isPSDERIdDirty() {
        return this.contains(FIELD_PSDERID);
    }

    @JsonIgnore
    public String getPSDERName() {
        Object objValue = this.get(FIELD_PSDERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdername")
    public void setPSDERName(String pSDERName) {
        this.set(FIELD_PSDERNAME, pSDERName);
    }

    @JsonIgnore
    public boolean isPSDERNameDirty() {
        return this.contains(FIELD_PSDERNAME);
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
    public String getPSSysCalendarItemId() {
        Object objValue = this.get(FIELD_PSSYSCALENDARITEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscalendaritemid")
    public void setPSSysCalendarItemId(String pSSysCalendarItemId) {
        this.set(FIELD_PSSYSCALENDARITEMID, pSSysCalendarItemId);
    }

    @JsonIgnore
    public boolean isPSSysCalendarItemIdDirty() {
        return this.contains(FIELD_PSSYSCALENDARITEMID);
    }

    @JsonIgnore
    public String getPSSysCalendarItemName() {
        Object objValue = this.get(FIELD_PSSYSCALENDARITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscalendaritemname")
    public void setPSSysCalendarItemName(String pSSysCalendarItemName) {
        this.set(FIELD_PSSYSCALENDARITEMNAME, pSSysCalendarItemName);
    }

    @JsonIgnore
    public boolean isPSSysCalendarItemNameDirty() {
        return this.contains(FIELD_PSSYSCALENDARITEMNAME);
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
    public String getRemovePSDEOPPrivId() {
        Object objValue = this.get(FIELD_REMOVEPSDEOPPRIVID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="removepsdeopprivid")
    public void setRemovePSDEOPPrivId(String removePSDEOPPrivId) {
        this.set(FIELD_REMOVEPSDEOPPRIVID, removePSDEOPPrivId);
    }

    @JsonIgnore
    public boolean isRemovePSDEOPPrivIdDirty() {
        return this.contains(FIELD_REMOVEPSDEOPPRIVID);
    }

    @JsonIgnore
    public String getRemovePSDEOPPrivName() {
        Object objValue = this.get(FIELD_REMOVEPSDEOPPRIVNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="removepsdeopprivname")
    public void setRemovePSDEOPPrivName(String removePSDEOPPrivName) {
        this.set(FIELD_REMOVEPSDEOPPRIVNAME, removePSDEOPPrivName);
    }

    @JsonIgnore
    public boolean isRemovePSDEOPPrivNameDirty() {
        return this.contains(FIELD_REMOVEPSDEOPPRIVNAME);
    }

    @JsonIgnore
    public String getTag2PSDEFId() {
        Object objValue = this.get(FIELD_TAG2PSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="tag2psdefid")
    public void setTag2PSDEFId(String tag2PSDEFId) {
        this.set(FIELD_TAG2PSDEFID, tag2PSDEFId);
    }

    @JsonIgnore
    public boolean isTag2PSDEFIdDirty() {
        return this.contains(FIELD_TAG2PSDEFID);
    }

    @JsonIgnore
    public String getTag2PSDEFName() {
        Object objValue = this.get(FIELD_TAG2PSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="tag2psdefname")
    public void setTag2PSDEFName(String tag2PSDEFName) {
        this.set(FIELD_TAG2PSDEFNAME, tag2PSDEFName);
    }

    @JsonIgnore
    public boolean isTag2PSDEFNameDirty() {
        return this.contains(FIELD_TAG2PSDEFNAME);
    }

    @JsonIgnore
    public String getTagPSDEFId() {
        Object objValue = this.get(FIELD_TAGPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="tagpsdefid")
    public void setTagPSDEFId(String tagPSDEFId) {
        this.set(FIELD_TAGPSDEFID, tagPSDEFId);
    }

    @JsonIgnore
    public boolean isTagPSDEFIdDirty() {
        return this.contains(FIELD_TAGPSDEFID);
    }

    @JsonIgnore
    public String getTagPSDEFName() {
        Object objValue = this.get(FIELD_TAGPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="tagpsdefname")
    public void setTagPSDEFName(String tagPSDEFName) {
        this.set(FIELD_TAGPSDEFNAME, tagPSDEFName);
    }

    @JsonIgnore
    public boolean isTagPSDEFNameDirty() {
        return this.contains(FIELD_TAGPSDEFNAME);
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
    public String getTipsPSDEFId() {
        Object objValue = this.get(FIELD_TIPSPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="tipspsdefid")
    public void setTipsPSDEFId(String tipsPSDEFId) {
        this.set(FIELD_TIPSPSDEFID, tipsPSDEFId);
    }

    @JsonIgnore
    public boolean isTipsPSDEFIdDirty() {
        return this.contains(FIELD_TIPSPSDEFID);
    }

    @JsonIgnore
    public String getTipsPSDEFName() {
        Object objValue = this.get(FIELD_TIPSPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="tipspsdefname")
    public void setTipsPSDEFName(String tipsPSDEFName) {
        this.set(FIELD_TIPSPSDEFNAME, tipsPSDEFName);
    }

    @JsonIgnore
    public boolean isTipsPSDEFNameDirty() {
        return this.contains(FIELD_TIPSPSDEFNAME);
    }

    @JsonIgnore
    public String getTotalPSDEFId() {
        Object objValue = this.get(FIELD_TOTALPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="totalpsdefid")
    public void setTotalPSDEFId(String totalPSDEFId) {
        this.set(FIELD_TOTALPSDEFID, totalPSDEFId);
    }

    @JsonIgnore
    public boolean isTotalPSDEFIdDirty() {
        return this.contains(FIELD_TOTALPSDEFID);
    }

    @JsonIgnore
    public String getTotalPSDEFName() {
        Object objValue = this.get(FIELD_TOTALPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="totalpsdefname")
    public void setTotalPSDEFName(String totalPSDEFName) {
        this.set(FIELD_TOTALPSDEFNAME, totalPSDEFName);
    }

    @JsonIgnore
    public boolean isTotalPSDEFNameDirty() {
        return this.contains(FIELD_TOTALPSDEFNAME);
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
    public String getUpdatePSDEOPPrivId() {
        Object objValue = this.get(FIELD_UPDATEPSDEOPPRIVID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="updatepsdeopprivid")
    public void setUpdatePSDEOPPrivId(String updatePSDEOPPrivId) {
        this.set(FIELD_UPDATEPSDEOPPRIVID, updatePSDEOPPrivId);
    }

    @JsonIgnore
    public boolean isUpdatePSDEOPPrivIdDirty() {
        return this.contains(FIELD_UPDATEPSDEOPPRIVID);
    }

    @JsonIgnore
    public String getUpdatePSDEOPPrivName() {
        Object objValue = this.get(FIELD_UPDATEPSDEOPPRIVNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="updatepsdeopprivname")
    public void setUpdatePSDEOPPrivName(String updatePSDEOPPrivName) {
        this.set(FIELD_UPDATEPSDEOPPRIVNAME, updatePSDEOPPrivName);
    }

    @JsonIgnore
    public boolean isUpdatePSDEOPPrivNameDirty() {
        return this.contains(FIELD_UPDATEPSDEOPPRIVNAME);
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
    public String getSrfkey() {
        return this.getPSSysCalendarItemId();
    }

    public void setSrfkey(String strValue) {
        this.setPSSysCalendarItemId(strValue);
    }

    public List<PSSysCalendarItemRV> getPssyscalendaritemrvs() {
        return this.pssyscalendaritemrvs;
    }

    public void setPssyscalendaritemrvs(List<PSSysCalendarItemRV> pssyscalendaritemrvs) {
        this.pssyscalendaritemrvs = pssyscalendaritemrvs;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (strName.equalsIgnoreCase("pssyscalendaritemrvs")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("pssyscalendaritemrvs")) {
            this.init();
            return this.pssyscalendaritemrvs;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSSYSCALENDARITEM";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSSysCalendarItem item = (PSSysCalendarItem)MAPPER.readValue(new File(strJsonFilePath), PSSysCalendarItem.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSSysCalendarItem) {
            PSSysCalendarItem dst = (PSSysCalendarItem)target;
            if (!bSimple && this.getPssyscalendaritemrvs() != null) {
                ArrayList<PSSysCalendarItemRV> pssyscalendaritemrvs = new ArrayList<PSSysCalendarItemRV>();
                for (PSSysCalendarItemRV item : this.getPssyscalendaritemrvs()) {
                    if (bDeepMode) {
                        PSSysCalendarItemRV newitem = new PSSysCalendarItemRV();
                        item.to(newitem, false, bDeepMode);
                        pssyscalendaritemrvs.add(newitem);
                        continue;
                    }
                    pssyscalendaritemrvs.add(item);
                }
                dst.setPssyscalendaritemrvs(pssyscalendaritemrvs);
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSSysCalendarItem) {
            PSSysCalendarItem src = (PSSysCalendarItem)source;
            if (!bSimple && src.getPssyscalendaritemrvs() != null) {
                ArrayList<PSSysCalendarItemRV> pssyscalendaritemrvs = new ArrayList<PSSysCalendarItemRV>();
                for (PSSysCalendarItemRV item : src.getPssyscalendaritemrvs()) {
                    if (bDeepMode) {
                        PSSysCalendarItemRV newItem = new PSSysCalendarItemRV();
                        newItem.from(item, false, bDeepMode);
                        pssyscalendaritemrvs.add(newItem);
                        continue;
                    }
                    pssyscalendaritemrvs.add(item);
                }
                this.setPssyscalendaritemrvs(pssyscalendaritemrvs);
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

