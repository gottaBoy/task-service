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

public class PSDEListItemDTO
extends PSModelDTOBase {
    public static final String FIELD_ALIGN = "align";
    public static final String FIELD_CAPPSLANRESID = "cappslanresid";
    public static final String FIELD_CAPPSLANRESNAME = "cappslanresname";
    public static final String FIELD_CAPTION = "caption";
    public static final String FIELD_CLCONVERTMODE = "clconvertmode";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CUSTOMCODE = "customcode";
    public static final String FIELD_CUSTOMMODE = "custommode";
    public static final String FIELD_DATAITEMS = "dataitems";
    public static final String FIELD_DATAVIEWPSDEID = "dataviewpsdeid";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_ENABLEITEMPRIV = "enableitempriv";
    public static final String FIELD_GROUPITEM = "groupitem";
    public static final String FIELD_ITEMTYPE = "itemtype";
    public static final String FIELD_LCRPSSYSPFPLUGINID = "lcrpssyspfpluginid";
    public static final String FIELD_LCRPSSYSPFPLUGINNAME = "lcrpssyspfpluginname";
    public static final String FIELD_LISTPSDEID = "listpsdeid";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_NOSORT = "nosort";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PREVENTXSS = "preventxss";
    public static final String FIELD_PSCODELISTID = "pscodelistid";
    public static final String FIELD_PSCODELISTNAME = "pscodelistname";
    public static final String FIELD_PSDEDATAVIEWID = "psdedataviewid";
    public static final String FIELD_PSDEDATAVIEWNAME = "psdedataviewname";
    public static final String FIELD_PSDELISTID = "psdelistid";
    public static final String FIELD_PSDELISTITEMID = "psdelistitemid";
    public static final String FIELD_PSDELISTITEMNAME = "psdelistitemname";
    public static final String FIELD_PSDELISTNAME = "psdelistname";
    public static final String FIELD_PSDEUAGROUPID = "psdeuagroupid";
    public static final String FIELD_PSDEUAGROUPNAME = "psdeuagroupname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_VALUEFORMAT = "valueformat";
    public static final String FIELD_WIDTH = "width";
    public static final String FIELD_WIDTHUNIT = "widthunit";

    @JsonIgnore
    public String getAlign() {
        Object objValue = this.get(FIELD_ALIGN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="align")
    public void setAlign(String align) {
        this.set(FIELD_ALIGN, align);
    }

    @JsonIgnore
    public boolean isAlignDirty() {
        return this.contains(FIELD_ALIGN);
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
    public String getCLConvertMode() {
        Object objValue = this.get(FIELD_CLCONVERTMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="clconvertmode")
    public void setCLConvertMode(String cLConvertMode) {
        this.set(FIELD_CLCONVERTMODE, cLConvertMode);
    }

    @JsonIgnore
    public boolean isCLConvertModeDirty() {
        return this.contains(FIELD_CLCONVERTMODE);
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
    public Integer getCustomMode() {
        Object objValue = this.get(FIELD_CUSTOMMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="custommode")
    public void setCustomMode(Integer customMode) {
        this.set(FIELD_CUSTOMMODE, customMode);
    }

    @JsonIgnore
    public boolean isCustomModeDirty() {
        return this.contains(FIELD_CUSTOMMODE);
    }

    @JsonIgnore
    public String getDataItems() {
        Object objValue = this.get(FIELD_DATAITEMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dataitems")
    public void setDataItems(String dataItems) {
        this.set(FIELD_DATAITEMS, dataItems);
    }

    @JsonIgnore
    public boolean isDataItemsDirty() {
        return this.contains(FIELD_DATAITEMS);
    }

    @JsonIgnore
    public String getDataViewPSDEId() {
        Object objValue = this.get(FIELD_DATAVIEWPSDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dataviewpsdeid")
    public void setDataViewPSDEId(String dataViewPSDEId) {
        this.set(FIELD_DATAVIEWPSDEID, dataViewPSDEId);
    }

    @JsonIgnore
    public boolean isDataViewPSDEIdDirty() {
        return this.contains(FIELD_DATAVIEWPSDEID);
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
    public String getGroupItem() {
        Object objValue = this.get(FIELD_GROUPITEM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="groupitem")
    public void setGroupItem(String groupItem) {
        this.set(FIELD_GROUPITEM, groupItem);
    }

    @JsonIgnore
    public boolean isGroupItemDirty() {
        return this.contains(FIELD_GROUPITEM);
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
    public String getLCRPSSysPFPluginId() {
        Object objValue = this.get(FIELD_LCRPSSYSPFPLUGINID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="lcrpssyspfpluginid")
    public void setLCRPSSysPFPluginId(String lCRPSSysPFPluginId) {
        this.set(FIELD_LCRPSSYSPFPLUGINID, lCRPSSysPFPluginId);
    }

    @JsonIgnore
    public boolean isLCRPSSysPFPluginIdDirty() {
        return this.contains(FIELD_LCRPSSYSPFPLUGINID);
    }

    @JsonIgnore
    public String getLCRPSSysPFPluginName() {
        Object objValue = this.get(FIELD_LCRPSSYSPFPLUGINNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="lcrpssyspfpluginname")
    public void setLCRPSSysPFPluginName(String lCRPSSysPFPluginName) {
        this.set(FIELD_LCRPSSYSPFPLUGINNAME, lCRPSSysPFPluginName);
    }

    @JsonIgnore
    public boolean isLCRPSSysPFPluginNameDirty() {
        return this.contains(FIELD_LCRPSSYSPFPLUGINNAME);
    }

    @JsonIgnore
    public String getListPSDEId() {
        Object objValue = this.get(FIELD_LISTPSDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="listpsdeid")
    public void setListPSDEId(String listPSDEId) {
        this.set(FIELD_LISTPSDEID, listPSDEId);
    }

    @JsonIgnore
    public boolean isListPSDEIdDirty() {
        return this.contains(FIELD_LISTPSDEID);
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
    public Integer getPreventXSS() {
        Object objValue = this.get(FIELD_PREVENTXSS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="preventxss")
    public void setPreventXSS(Integer preventXSS) {
        this.set(FIELD_PREVENTXSS, preventXSS);
    }

    @JsonIgnore
    public boolean isPreventXSSDirty() {
        return this.contains(FIELD_PREVENTXSS);
    }

    @JsonIgnore
    public String getPSCodeListId() {
        Object objValue = this.get(FIELD_PSCODELISTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pscodelistid")
    public void setPSCodeListId(String pSCodeListId) {
        this.set(FIELD_PSCODELISTID, pSCodeListId);
    }

    @JsonIgnore
    public boolean isPSCodeListIdDirty() {
        return this.contains(FIELD_PSCODELISTID);
    }

    @JsonIgnore
    public String getPSCodeListName() {
        Object objValue = this.get(FIELD_PSCODELISTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pscodelistname")
    public void setPSCodeListName(String pSCodeListName) {
        this.set(FIELD_PSCODELISTNAME, pSCodeListName);
    }

    @JsonIgnore
    public boolean isPSCodeListNameDirty() {
        return this.contains(FIELD_PSCODELISTNAME);
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
    public String getPSDEListItemId() {
        Object objValue = this.get(FIELD_PSDELISTITEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdelistitemid")
    public void setPSDEListItemId(String pSDEListItemId) {
        this.set(FIELD_PSDELISTITEMID, pSDEListItemId);
    }

    @JsonIgnore
    public boolean isPSDEListItemIdDirty() {
        return this.contains(FIELD_PSDELISTITEMID);
    }

    @JsonIgnore
    public String getPSDEListItemName() {
        Object objValue = this.get(FIELD_PSDELISTITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdelistitemname")
    public void setPSDEListItemName(String pSDEListItemName) {
        this.set(FIELD_PSDELISTITEMNAME, pSDEListItemName);
    }

    @JsonIgnore
    public boolean isPSDEListItemNameDirty() {
        return this.contains(FIELD_PSDELISTITEMNAME);
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
    public String getValueFormat() {
        Object objValue = this.get(FIELD_VALUEFORMAT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="valueformat")
    public void setValueFormat(String valueFormat) {
        this.set(FIELD_VALUEFORMAT, valueFormat);
    }

    @JsonIgnore
    public boolean isValueFormatDirty() {
        return this.contains(FIELD_VALUEFORMAT);
    }

    @JsonIgnore
    public Integer getWidth() {
        Object objValue = this.get(FIELD_WIDTH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="width")
    public void setWidth(Integer width) {
        this.set(FIELD_WIDTH, width);
    }

    @JsonIgnore
    public boolean isWidthDirty() {
        return this.contains(FIELD_WIDTH);
    }

    @JsonIgnore
    public String getWidthUnit() {
        Object objValue = this.get(FIELD_WIDTHUNIT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="widthunit")
    public void setWidthUnit(String widthUnit) {
        this.set(FIELD_WIDTHUNIT, widthUnit);
    }

    @JsonIgnore
    public boolean isWidthUnitDirty() {
        return this.contains(FIELD_WIDTHUNIT);
    }

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDEListItemId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSDEListItemId(strValue);
    }
}

