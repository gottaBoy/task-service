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
import net.ibizsys.modelapi.util.PSModelDTOBase;

public class PSDETBItemDTO
extends PSModelDTOBase {
    public static final String FIELD_ACTIONLEVEL = "actionlevel";
    public static final String FIELD_BORDERSTYLE = "borderstyle";
    public static final String FIELD_BTNACTIONTYPE = "btnactiontype";
    public static final String FIELD_CAPPSLANRESID = "cappslanresid";
    public static final String FIELD_CAPPSLANRESNAME = "cappslanresname";
    public static final String FIELD_CAPTION = "caption";
    public static final String FIELD_CODENAME = "codename";
    public static final String FIELD_CONTENTTYPE = "contenttype";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CUSTOMCODE = "customcode";
    public static final String FIELD_DATA = "data";
    public static final String FIELD_DEFAULTFLAG = "defaultflag";
    public static final String FIELD_DEUACAP = "deuacap";
    public static final String FIELD_DYNACLASS = "dynaclass";
    public static final String FIELD_GROUPEXTRACTMODE = "groupextractmode";
    public static final String FIELD_HEIGHT = "height";
    public static final String FIELD_HIDDENITEM = "hiddenitem";
    public static final String FIELD_HTMLCONTENT = "htmlcontent";
    public static final String FIELD_HTMLPAGEURL = "htmlpageurl";
    public static final String FIELD_ITEMSTYLE = "itemstyle";
    public static final String FIELD_ITEMSTYLETEXT = "itemstyletext";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_NOPRIVDM = "noprivdm";
    public static final String FIELD_OPENPSAPPVIEWID = "openpsappviewid";
    public static final String FIELD_OPENPSAPPVIEWNAME = "openpsappviewname";
    public static final String FIELD_OPENPSDEVIEWID = "openpsdeviewid";
    public static final String FIELD_OPENPSDEVIEWNAME = "openpsdeviewname";
    public static final String FIELD_OPENPSSYSPDTVIEWID = "openpssyspdtviewid";
    public static final String FIELD_OPENPSSYSPDTVIEWNAME = "openpssyspdtviewname";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PPSDETBITEMID = "ppsdetbitemid";
    public static final String FIELD_PPSDETBITEMNAME = "ppsdetbitemname";
    public static final String FIELD_PREDEFINEDTYPE = "predefinedtype";
    public static final String FIELD_PREDEFINEDTYPETEXT = "predefinedtypetext";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDELOGICID = "psdelogicid";
    public static final String FIELD_PSDELOGICNAME = "psdelogicname";
    public static final String FIELD_PSDETBITEMID = "psdetbitemid";
    public static final String FIELD_PSDETBITEMNAME = "psdetbitemname";
    public static final String FIELD_PSDETOOLBARID = "psdetoolbarid";
    public static final String FIELD_PSDETOOLBARNAME = "psdetoolbarname";
    public static final String FIELD_PSDEUIACTIONID = "psdeuiactionid";
    public static final String FIELD_PSDEUIACTIONNAME = "psdeuiactionname";
    public static final String FIELD_PSSYSCSSID = "pssyscssid";
    public static final String FIELD_PSSYSCSSNAME = "pssyscssname";
    public static final String FIELD_PSSYSIMAGEID = "pssysimageid";
    public static final String FIELD_PSSYSIMAGENAME = "pssysimagename";
    public static final String FIELD_PSSYSPFPLUGINID = "pssyspfpluginid";
    public static final String FIELD_PSSYSPFPLUGINNAME = "pssyspfpluginname";
    public static final String FIELD_PSSYSRESOURCEID = "pssysresourceid";
    public static final String FIELD_PSSYSRESOURCENAME = "pssysresourcename";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_RAWCONTENT = "rawcontent";
    public static final String FIELD_RAWCSSSTYLE = "rawcssstyle";
    public static final String FIELD_SHOWMODE = "showmode";
    public static final String FIELD_SPANFLAG = "spanflag";
    public static final String FIELD_TBITEMTYPE = "tbitemtype";
    public static final String FIELD_TIPPSLANRESID = "tippslanresid";
    public static final String FIELD_TIPPSLANRESNAME = "tippslanresname";
    public static final String FIELD_TOGGLEMODE = "togglemode";
    public static final String FIELD_TOOLTIPINFO = "tooltipinfo";
    public static final String FIELD_UIACTIONPARAMS = "uiactionparams";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERPARAMS = "userparams";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_WIDTH = "width";
    private List<PSDETBItemDTO> psdetbitems;

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
    public String getBorderStyle() {
        Object objValue = this.get(FIELD_BORDERSTYLE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="borderstyle")
    public void setBorderStyle(String borderStyle) {
        this.set(FIELD_BORDERSTYLE, borderStyle);
    }

    @JsonIgnore
    public boolean isBorderStyleDirty() {
        return this.contains(FIELD_BORDERSTYLE);
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
    public String getContentType() {
        Object objValue = this.get(FIELD_CONTENTTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="contenttype")
    public void setContentType(String contentType) {
        this.set(FIELD_CONTENTTYPE, contentType);
    }

    @JsonIgnore
    public boolean isContentTypeDirty() {
        return this.contains(FIELD_CONTENTTYPE);
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
    public String getData() {
        Object objValue = this.get(FIELD_DATA);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="data")
    public void setData(String data) {
        this.set(FIELD_DATA, data);
    }

    @JsonIgnore
    public boolean isDataDirty() {
        return this.contains(FIELD_DATA);
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
    public String getDEUACap() {
        Object objValue = this.get(FIELD_DEUACAP);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="deuacap")
    public void setDEUACap(String dEUACap) {
        this.set(FIELD_DEUACAP, dEUACap);
    }

    @JsonIgnore
    public boolean isDEUACapDirty() {
        return this.contains(FIELD_DEUACAP);
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
    public Integer getHiddenItem() {
        Object objValue = this.get(FIELD_HIDDENITEM);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="hiddenitem")
    public void setHiddenItem(Integer hiddenItem) {
        this.set(FIELD_HIDDENITEM, hiddenItem);
    }

    @JsonIgnore
    public boolean isHiddenItemDirty() {
        return this.contains(FIELD_HIDDENITEM);
    }

    @JsonIgnore
    public String getHtmlContent() {
        Object objValue = this.get(FIELD_HTMLCONTENT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="htmlcontent")
    public void setHtmlContent(String htmlContent) {
        this.set(FIELD_HTMLCONTENT, htmlContent);
    }

    @JsonIgnore
    public boolean isHtmlContentDirty() {
        return this.contains(FIELD_HTMLCONTENT);
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
    public String getOpenPSAppViewId() {
        Object objValue = this.get(FIELD_OPENPSAPPVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="openpsappviewid")
    public void setOpenPSAppViewId(String openPSAppViewId) {
        this.set(FIELD_OPENPSAPPVIEWID, openPSAppViewId);
    }

    @JsonIgnore
    public boolean isOpenPSAppViewIdDirty() {
        return this.contains(FIELD_OPENPSAPPVIEWID);
    }

    @JsonIgnore
    public String getOpenPSAppViewName() {
        Object objValue = this.get(FIELD_OPENPSAPPVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="openpsappviewname")
    public void setOpenPSAppViewName(String openPSAppViewName) {
        this.set(FIELD_OPENPSAPPVIEWNAME, openPSAppViewName);
    }

    @JsonIgnore
    public boolean isOpenPSAppViewNameDirty() {
        return this.contains(FIELD_OPENPSAPPVIEWNAME);
    }

    @JsonIgnore
    public String getOpenPSDEViewId() {
        Object objValue = this.get(FIELD_OPENPSDEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="openpsdeviewid")
    public void setOpenPSDEViewId(String openPSDEViewId) {
        this.set(FIELD_OPENPSDEVIEWID, openPSDEViewId);
    }

    @JsonIgnore
    public boolean isOpenPSDEViewIdDirty() {
        return this.contains(FIELD_OPENPSDEVIEWID);
    }

    @JsonIgnore
    public String getOpenPSDEViewName() {
        Object objValue = this.get(FIELD_OPENPSDEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="openpsdeviewname")
    public void setOpenPSDEViewName(String openPSDEViewName) {
        this.set(FIELD_OPENPSDEVIEWNAME, openPSDEViewName);
    }

    @JsonIgnore
    public boolean isOpenPSDEViewNameDirty() {
        return this.contains(FIELD_OPENPSDEVIEWNAME);
    }

    @JsonIgnore
    public String getOpenPSSysPDTViewId() {
        Object objValue = this.get(FIELD_OPENPSSYSPDTVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="openpssyspdtviewid")
    public void setOpenPSSysPDTViewId(String openPSSysPDTViewId) {
        this.set(FIELD_OPENPSSYSPDTVIEWID, openPSSysPDTViewId);
    }

    @JsonIgnore
    public boolean isOpenPSSysPDTViewIdDirty() {
        return this.contains(FIELD_OPENPSSYSPDTVIEWID);
    }

    @JsonIgnore
    public String getOpenPSSysPDTViewName() {
        Object objValue = this.get(FIELD_OPENPSSYSPDTVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="openpssyspdtviewname")
    public void setOpenPSSysPDTViewName(String openPSSysPDTViewName) {
        this.set(FIELD_OPENPSSYSPDTVIEWNAME, openPSSysPDTViewName);
    }

    @JsonIgnore
    public boolean isOpenPSSysPDTViewNameDirty() {
        return this.contains(FIELD_OPENPSSYSPDTVIEWNAME);
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
    public String getPPSDETBItemId() {
        Object objValue = this.get(FIELD_PPSDETBITEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppsdetbitemid")
    public void setPPSDETBItemId(String pPSDETBItemId) {
        this.set(FIELD_PPSDETBITEMID, pPSDETBItemId);
    }

    @JsonIgnore
    public boolean isPPSDETBItemIdDirty() {
        return this.contains(FIELD_PPSDETBITEMID);
    }

    @JsonIgnore
    public String getPPSDETBItemName() {
        Object objValue = this.get(FIELD_PPSDETBITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppsdetbitemname")
    public void setPPSDETBItemName(String pPSDETBItemName) {
        this.set(FIELD_PPSDETBITEMNAME, pPSDETBItemName);
    }

    @JsonIgnore
    public boolean isPPSDETBItemNameDirty() {
        return this.contains(FIELD_PPSDETBITEMNAME);
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
    public String getPSDETBItemId() {
        Object objValue = this.get(FIELD_PSDETBITEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdetbitemid")
    public void setPSDETBItemId(String pSDETBItemId) {
        this.set(FIELD_PSDETBITEMID, pSDETBItemId);
    }

    @JsonIgnore
    public boolean isPSDETBItemIdDirty() {
        return this.contains(FIELD_PSDETBITEMID);
    }

    @JsonIgnore
    public String getPSDETBItemName() {
        Object objValue = this.get(FIELD_PSDETBITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdetbitemname")
    public void setPSDETBItemName(String pSDETBItemName) {
        this.set(FIELD_PSDETBITEMNAME, pSDETBItemName);
    }

    @JsonIgnore
    public boolean isPSDETBItemNameDirty() {
        return this.contains(FIELD_PSDETBITEMNAME);
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
    public String getPSSysResourceId() {
        Object objValue = this.get(FIELD_PSSYSRESOURCEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysresourceid")
    public void setPSSysResourceId(String pSSysResourceId) {
        this.set(FIELD_PSSYSRESOURCEID, pSSysResourceId);
    }

    @JsonIgnore
    public boolean isPSSysResourceIdDirty() {
        return this.contains(FIELD_PSSYSRESOURCEID);
    }

    @JsonIgnore
    public String getPSSysResourceName() {
        Object objValue = this.get(FIELD_PSSYSRESOURCENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysresourcename")
    public void setPSSysResourceName(String pSSysResourceName) {
        this.set(FIELD_PSSYSRESOURCENAME, pSSysResourceName);
    }

    @JsonIgnore
    public boolean isPSSysResourceNameDirty() {
        return this.contains(FIELD_PSSYSRESOURCENAME);
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
    public String getRawContent() {
        Object objValue = this.get(FIELD_RAWCONTENT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="rawcontent")
    public void setRawContent(String rawContent) {
        this.set(FIELD_RAWCONTENT, rawContent);
    }

    @JsonIgnore
    public boolean isRawContentDirty() {
        return this.contains(FIELD_RAWCONTENT);
    }

    @JsonIgnore
    public String getRawCssStyle() {
        Object objValue = this.get(FIELD_RAWCSSSTYLE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="rawcssstyle")
    public void setRawCssStyle(String rawCssStyle) {
        this.set(FIELD_RAWCSSSTYLE, rawCssStyle);
    }

    @JsonIgnore
    public boolean isRawCssStyleDirty() {
        return this.contains(FIELD_RAWCSSSTYLE);
    }

    @JsonIgnore
    public String getShowMode() {
        Object objValue = this.get(FIELD_SHOWMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="showmode")
    public void setShowMode(String showMode) {
        this.set(FIELD_SHOWMODE, showMode);
    }

    @JsonIgnore
    public boolean isShowModeDirty() {
        return this.contains(FIELD_SHOWMODE);
    }

    @JsonIgnore
    public Integer getSpanFlag() {
        Object objValue = this.get(FIELD_SPANFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="spanflag")
    public void setSpanFlag(Integer spanFlag) {
        this.set(FIELD_SPANFLAG, spanFlag);
    }

    @JsonIgnore
    public boolean isSpanFlagDirty() {
        return this.contains(FIELD_SPANFLAG);
    }

    @JsonIgnore
    public String getTBItemType() {
        Object objValue = this.get(FIELD_TBITEMTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="tbitemtype")
    public void setTBItemType(String tBItemType) {
        this.set(FIELD_TBITEMTYPE, tBItemType);
    }

    @JsonIgnore
    public boolean isTBItemTypeDirty() {
        return this.contains(FIELD_TBITEMTYPE);
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
    public String getToggleMode() {
        Object objValue = this.get(FIELD_TOGGLEMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="togglemode")
    public void setToggleMode(String toggleMode) {
        this.set(FIELD_TOGGLEMODE, toggleMode);
    }

    @JsonIgnore
    public boolean isToggleModeDirty() {
        return this.contains(FIELD_TOGGLEMODE);
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
        return this.getPSDETBItemId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSDETBItemId(strValue);
    }

    @JsonProperty(value="psdetbitems")
    public List<PSDETBItemDTO> getPsdetbitems() {
        return this.psdetbitems;
    }

    @JsonProperty(value="psdetbitems")
    public void setPsdetbitems(List<PSDETBItemDTO> psdetbitems) {
        this.psdetbitems = psdetbitems;
    }
}

