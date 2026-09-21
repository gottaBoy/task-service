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

public class PSDEGridColDTO
extends PSModelDTOBase {
    public static final String FIELD_AGGFIELD = "aggfield";
    public static final String FIELD_AGGMODE = "aggmode";
    public static final String FIELD_AGGVALUEFORMAT = "aggvalueformat";
    public static final String FIELD_ALIGN = "align";
    public static final String FIELD_ALLOWEMPTY = "allowempty";
    public static final String FIELD_CAPPSLANRESID = "cappslanresid";
    public static final String FIELD_CAPPSLANRESNAME = "cappslanresname";
    public static final String FIELD_CAPTION = "caption";
    public static final String FIELD_CELLPSSYSCSSID = "cellpssyscssid";
    public static final String FIELD_CELLPSSYSCSSNAME = "cellpssyscssname";
    public static final String FIELD_CLCONVERTMODE = "clconvertmode";
    public static final String FIELD_CODELISTCONFIGMODE = "codelistconfigmode";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEDV = "createdv";
    public static final String FIELD_CREATEDVT = "createdvt";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CUSTOMCODE = "customcode";
    public static final String FIELD_CUSTOMMODE = "custommode";
    public static final String FIELD_DATAITEMS = "dataitems";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_EDITORPARAMS = "editorparams";
    public static final String FIELD_EDITORTYPE = "editortype";
    public static final String FIELD_EDITORTYPENAME = "editortypename";
    public static final String FIELD_ENABLECOND = "enablecond";
    public static final String FIELD_ENABLEITEMPRIV = "enableitempriv";
    public static final String FIELD_ENABLELINK = "enablelink";
    public static final String FIELD_ENABLEROWEDIT = "enablerowedit";
    public static final String FIELD_GCRPSSYSPFPLUGINID = "gcrpssyspfpluginid";
    public static final String FIELD_GCRPSSYSPFPLUGINNAME = "gcrpssyspfpluginname";
    public static final String FIELD_GRIDCOLSTYLE = "gridcolstyle";
    public static final String FIELD_GRIDCOLTYPE = "gridcoltype";
    public static final String FIELD_GROUPITEM = "groupitem";
    public static final String FIELD_HEADERPSSYSCSSID = "headerpssyscssid";
    public static final String FIELD_HEADERPSSYSCSSNAME = "headerpssyscssname";
    public static final String FIELD_HIDDENDATAITEM = "hiddendataitem";
    public static final String FIELD_HIDEDEFAULT = "hidedefault";
    public static final String FIELD_IGNOREINPUT = "ignoreinput";
    public static final String FIELD_LINKPSDEVIEWID = "linkpsdeviewid";
    public static final String FIELD_LINKPSDEVIEWNAME = "linkpsdeviewname";
    public static final String FIELD_LOGICNAME = "logicname";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MODELSTATE = "modelstate";
    public static final String FIELD_NEEDCODELISTCONFIG = "needcodelistconfig";
    public static final String FIELD_NOPRIVDM = "noprivdm";
    public static final String FIELD_NOSORT = "nosort";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PHPSLANRESID = "phpslanresid";
    public static final String FIELD_PHPSLANRESNAME = "phpslanresname";
    public static final String FIELD_PICKUPPSDEVIEWID = "pickuppsdeviewid";
    public static final String FIELD_PICKUPPSDEVIEWNAME = "pickuppsdeviewname";
    public static final String FIELD_PLACEHOLDER = "placeholder";
    public static final String FIELD_PPSDEGRIDCOLID = "ppsdegridcolid";
    public static final String FIELD_PPSDEGRIDCOLNAME = "ppsdegridcolname";
    public static final String FIELD_PREVENTXSS = "preventxss";
    public static final String FIELD_PSCODELISTID = "pscodelistid";
    public static final String FIELD_PSCODELISTNAME = "pscodelistname";
    public static final String FIELD_PSDEFID = "psdefid";
    public static final String FIELD_PSDEFNAME = "psdefname";
    public static final String FIELD_PSDEFSFITEMID = "psdefsfitemid";
    public static final String FIELD_PSDEFSFITEMNAME = "psdefsfitemname";
    public static final String FIELD_PSDEFUIMODEID = "psdefuimodeid";
    public static final String FIELD_PSDEFUIMODENAME = "psdefuimodename";
    public static final String FIELD_PSDEGEIUPDATEID = "psdegeiupdateid";
    public static final String FIELD_PSDEGEIUPDATENAME = "psdegeiupdatename";
    public static final String FIELD_PSDEGRIDCOLID = "psdegridcolid";
    public static final String FIELD_PSDEGRIDCOLNAME = "psdegridcolname";
    public static final String FIELD_PSDEGRIDID = "psdegridid";
    public static final String FIELD_PSDEGRIDNAME = "psdegridname";
    public static final String FIELD_PSDEUAGROUPID = "psdeuagroupid";
    public static final String FIELD_PSDEUAGROUPNAME = "psdeuagroupname";
    public static final String FIELD_PSDEUIACTIONID = "psdeuiactionid";
    public static final String FIELD_PSDEUIACTIONNAME = "psdeuiactionname";
    public static final String FIELD_PSSYSDICTCATID = "pssysdictcatid";
    public static final String FIELD_PSSYSDICTCATNAME = "pssysdictcatname";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    public static final String FIELD_PSSYSEDITORSTYLEID = "pssyseditorstyleid";
    public static final String FIELD_PSSYSEDITORSTYLENAME = "pssyseditorstylename";
    public static final String FIELD_PSSYSIMAGEID = "pssysimageid";
    public static final String FIELD_PSSYSIMAGENAME = "pssysimagename";
    public static final String FIELD_RAWSERVICEMETHOD = "rawservicemethod";
    public static final String FIELD_RAWSERVICEURL = "rawserviceurl";
    public static final String FIELD_REFPSDEACMODEID = "refpsdeacmodeid";
    public static final String FIELD_REFPSDEACMODENAME = "refpsdeacmodename";
    public static final String FIELD_REFPSDEDATASETID = "refpsdedatasetid";
    public static final String FIELD_REFPSDEDATASETNAME = "refpsdedatasetname";
    public static final String FIELD_REFPSDEID = "refpsdeid";
    public static final String FIELD_REFPSDENAME = "refpsdename";
    public static final String FIELD_REFPSDERID = "refpsderid";
    public static final String FIELD_REFPSDERNAME = "refpsdername";
    public static final String FIELD_RESETITEMNAME = "resetitemname";
    public static final String FIELD_TREEITEM = "treeitem";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEDV = "updatedv";
    public static final String FIELD_UPDATEDVT = "updatedvt";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERPARAMS = "userparams";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_VALUEFORMAT = "valueformat";
    public static final String FIELD_VALUEITEMNAME = "valueitemname";
    public static final String FIELD_WIDTH = "width";
    public static final String FIELD_WIDTHUNIT = "widthunit";
    private List<PSDEGridColDTO> psdegridcols;

    @JsonIgnore
    public String getAggField() {
        Object objValue = this.get(FIELD_AGGFIELD);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="aggfield")
    public void setAggField(String aggField) {
        this.set(FIELD_AGGFIELD, aggField);
    }

    @JsonIgnore
    public boolean isAggFieldDirty() {
        return this.contains(FIELD_AGGFIELD);
    }

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
    public String getAggValueFormat() {
        Object objValue = this.get(FIELD_AGGVALUEFORMAT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="aggvalueformat")
    public void setAggValueFormat(String aggValueFormat) {
        this.set(FIELD_AGGVALUEFORMAT, aggValueFormat);
    }

    @JsonIgnore
    public boolean isAggValueFormatDirty() {
        return this.contains(FIELD_AGGVALUEFORMAT);
    }

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
    public Integer getAllowEmpty() {
        Object objValue = this.get(FIELD_ALLOWEMPTY);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="allowempty")
    public void setAllowEmpty(Integer allowEmpty) {
        this.set(FIELD_ALLOWEMPTY, allowEmpty);
    }

    @JsonIgnore
    public boolean isAllowEmptyDirty() {
        return this.contains(FIELD_ALLOWEMPTY);
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
    public String getCellPSSysCssId() {
        Object objValue = this.get(FIELD_CELLPSSYSCSSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cellpssyscssid")
    public void setCellPSSysCssId(String cellPSSysCssId) {
        this.set(FIELD_CELLPSSYSCSSID, cellPSSysCssId);
    }

    @JsonIgnore
    public boolean isCellPSSysCssIdDirty() {
        return this.contains(FIELD_CELLPSSYSCSSID);
    }

    @JsonIgnore
    public String getCellPSSysCssName() {
        Object objValue = this.get(FIELD_CELLPSSYSCSSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cellpssyscssname")
    public void setCellPSSysCssName(String cellPSSysCssName) {
        this.set(FIELD_CELLPSSYSCSSNAME, cellPSSysCssName);
    }

    @JsonIgnore
    public boolean isCellPSSysCssNameDirty() {
        return this.contains(FIELD_CELLPSSYSCSSNAME);
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
    public Integer getCodeListConfigMode() {
        Object objValue = this.get(FIELD_CODELISTCONFIGMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="codelistconfigmode")
    public void setCodeListConfigMode(Integer codeListConfigMode) {
        this.set(FIELD_CODELISTCONFIGMODE, codeListConfigMode);
    }

    @JsonIgnore
    public boolean isCodeListConfigModeDirty() {
        return this.contains(FIELD_CODELISTCONFIGMODE);
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
    public String getCreateDV() {
        Object objValue = this.get(FIELD_CREATEDV);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="createdv")
    public void setCreateDV(String createDV) {
        this.set(FIELD_CREATEDV, createDV);
    }

    @JsonIgnore
    public boolean isCreateDVDirty() {
        return this.contains(FIELD_CREATEDV);
    }

    @JsonIgnore
    public String getCreateDVT() {
        Object objValue = this.get(FIELD_CREATEDVT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="createdvt")
    public void setCreateDVT(String createDVT) {
        this.set(FIELD_CREATEDVT, createDVT);
    }

    @JsonIgnore
    public boolean isCreateDVTDirty() {
        return this.contains(FIELD_CREATEDVT);
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
    public String getEditorParams() {
        Object objValue = this.get(FIELD_EDITORPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="editorparams")
    public void setEditorParams(String editorParams) {
        this.set(FIELD_EDITORPARAMS, editorParams);
    }

    @JsonIgnore
    public boolean isEditorParamsDirty() {
        return this.contains(FIELD_EDITORPARAMS);
    }

    @JsonIgnore
    public String getEditorType() {
        Object objValue = this.get(FIELD_EDITORTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="editortype")
    public void setEditorType(String editorType) {
        this.set(FIELD_EDITORTYPE, editorType);
    }

    @JsonIgnore
    public boolean isEditorTypeDirty() {
        return this.contains(FIELD_EDITORTYPE);
    }

    @JsonIgnore
    public String getEditorTypeName() {
        Object objValue = this.get(FIELD_EDITORTYPENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="editortypename")
    public void setEditorTypeName(String editorTypeName) {
        this.set(FIELD_EDITORTYPENAME, editorTypeName);
    }

    @JsonIgnore
    public boolean isEditorTypeNameDirty() {
        return this.contains(FIELD_EDITORTYPENAME);
    }

    @JsonIgnore
    public Integer getEnableCond() {
        Object objValue = this.get(FIELD_ENABLECOND);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablecond")
    public void setEnableCond(Integer enableCond) {
        this.set(FIELD_ENABLECOND, enableCond);
    }

    @JsonIgnore
    public boolean isEnableCondDirty() {
        return this.contains(FIELD_ENABLECOND);
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
    public Integer getEnableLink() {
        Object objValue = this.get(FIELD_ENABLELINK);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablelink")
    public void setEnableLink(Integer enableLink) {
        this.set(FIELD_ENABLELINK, enableLink);
    }

    @JsonIgnore
    public boolean isEnableLinkDirty() {
        return this.contains(FIELD_ENABLELINK);
    }

    @JsonIgnore
    public Integer getEnableRowEdit() {
        Object objValue = this.get(FIELD_ENABLEROWEDIT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablerowedit")
    public void setEnableRowEdit(Integer enableRowEdit) {
        this.set(FIELD_ENABLEROWEDIT, enableRowEdit);
    }

    @JsonIgnore
    public boolean isEnableRowEditDirty() {
        return this.contains(FIELD_ENABLEROWEDIT);
    }

    @JsonIgnore
    public String getGCRPSSysPFPluginId() {
        Object objValue = this.get(FIELD_GCRPSSYSPFPLUGINID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="gcrpssyspfpluginid")
    public void setGCRPSSysPFPluginId(String gCRPSSysPFPluginId) {
        this.set(FIELD_GCRPSSYSPFPLUGINID, gCRPSSysPFPluginId);
    }

    @JsonIgnore
    public boolean isGCRPSSysPFPluginIdDirty() {
        return this.contains(FIELD_GCRPSSYSPFPLUGINID);
    }

    @JsonIgnore
    public String getGCRPSSysPFPluginName() {
        Object objValue = this.get(FIELD_GCRPSSYSPFPLUGINNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="gcrpssyspfpluginname")
    public void setGCRPSSysPFPluginName(String gCRPSSysPFPluginName) {
        this.set(FIELD_GCRPSSYSPFPLUGINNAME, gCRPSSysPFPluginName);
    }

    @JsonIgnore
    public boolean isGCRPSSysPFPluginNameDirty() {
        return this.contains(FIELD_GCRPSSYSPFPLUGINNAME);
    }

    @JsonIgnore
    public String getGridColStyle() {
        Object objValue = this.get(FIELD_GRIDCOLSTYLE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="gridcolstyle")
    public void setGridColStyle(String gridColStyle) {
        this.set(FIELD_GRIDCOLSTYLE, gridColStyle);
    }

    @JsonIgnore
    public boolean isGridColStyleDirty() {
        return this.contains(FIELD_GRIDCOLSTYLE);
    }

    @JsonIgnore
    public String getGridColType() {
        Object objValue = this.get(FIELD_GRIDCOLTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="gridcoltype")
    public void setGridColType(String gridColType) {
        this.set(FIELD_GRIDCOLTYPE, gridColType);
    }

    @JsonIgnore
    public boolean isGridColTypeDirty() {
        return this.contains(FIELD_GRIDCOLTYPE);
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
    public String getHeaderPSSysCssId() {
        Object objValue = this.get(FIELD_HEADERPSSYSCSSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="headerpssyscssid")
    public void setHeaderPSSysCssId(String headerPSSysCssId) {
        this.set(FIELD_HEADERPSSYSCSSID, headerPSSysCssId);
    }

    @JsonIgnore
    public boolean isHeaderPSSysCssIdDirty() {
        return this.contains(FIELD_HEADERPSSYSCSSID);
    }

    @JsonIgnore
    public String getHeaderPSSysCssName() {
        Object objValue = this.get(FIELD_HEADERPSSYSCSSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="headerpssyscssname")
    public void setHeaderPSSysCssName(String headerPSSysCssName) {
        this.set(FIELD_HEADERPSSYSCSSNAME, headerPSSysCssName);
    }

    @JsonIgnore
    public boolean isHeaderPSSysCssNameDirty() {
        return this.contains(FIELD_HEADERPSSYSCSSNAME);
    }

    @JsonIgnore
    public Integer getHiddenDataItem() {
        Object objValue = this.get(FIELD_HIDDENDATAITEM);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="hiddendataitem")
    public void setHiddenDataItem(Integer hiddenDataItem) {
        this.set(FIELD_HIDDENDATAITEM, hiddenDataItem);
    }

    @JsonIgnore
    public boolean isHiddenDataItemDirty() {
        return this.contains(FIELD_HIDDENDATAITEM);
    }

    @JsonIgnore
    public Integer getHideDefault() {
        Object objValue = this.get(FIELD_HIDEDEFAULT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="hidedefault")
    public void setHideDefault(Integer hideDefault) {
        this.set(FIELD_HIDEDEFAULT, hideDefault);
    }

    @JsonIgnore
    public boolean isHideDefaultDirty() {
        return this.contains(FIELD_HIDEDEFAULT);
    }

    @JsonIgnore
    public Integer getIgnoreInput() {
        Object objValue = this.get(FIELD_IGNOREINPUT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="ignoreinput")
    public void setIgnoreInput(Integer ignoreInput) {
        this.set(FIELD_IGNOREINPUT, ignoreInput);
    }

    @JsonIgnore
    public boolean isIgnoreInputDirty() {
        return this.contains(FIELD_IGNOREINPUT);
    }

    @JsonIgnore
    public String getLinkPSDEViewId() {
        Object objValue = this.get(FIELD_LINKPSDEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="linkpsdeviewid")
    public void setLinkPSDEViewId(String linkPSDEViewId) {
        this.set(FIELD_LINKPSDEVIEWID, linkPSDEViewId);
    }

    @JsonIgnore
    public boolean isLinkPSDEViewIdDirty() {
        return this.contains(FIELD_LINKPSDEVIEWID);
    }

    @JsonIgnore
    public String getLinkPSDEViewName() {
        Object objValue = this.get(FIELD_LINKPSDEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="linkpsdeviewname")
    public void setLinkPSDEViewName(String linkPSDEViewName) {
        this.set(FIELD_LINKPSDEVIEWNAME, linkPSDEViewName);
    }

    @JsonIgnore
    public boolean isLinkPSDEViewNameDirty() {
        return this.contains(FIELD_LINKPSDEVIEWNAME);
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
    public Integer getModelState() {
        Object objValue = this.get(FIELD_MODELSTATE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="modelstate")
    public void setModelState(Integer modelState) {
        this.set(FIELD_MODELSTATE, modelState);
    }

    @JsonIgnore
    public boolean isModelStateDirty() {
        return this.contains(FIELD_MODELSTATE);
    }

    @JsonIgnore
    public Integer getNeedCodeListConfig() {
        Object objValue = this.get(FIELD_NEEDCODELISTCONFIG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="needcodelistconfig")
    public void setNeedCodeListConfig(Integer needCodeListConfig) {
        this.set(FIELD_NEEDCODELISTCONFIG, needCodeListConfig);
    }

    @JsonIgnore
    public boolean isNeedCodeListConfigDirty() {
        return this.contains(FIELD_NEEDCODELISTCONFIG);
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
    public String getPHPSLanResId() {
        Object objValue = this.get(FIELD_PHPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="phpslanresid")
    public void setPHPSLanResId(String pHPSLanResId) {
        this.set(FIELD_PHPSLANRESID, pHPSLanResId);
    }

    @JsonIgnore
    public boolean isPHPSLanResIdDirty() {
        return this.contains(FIELD_PHPSLANRESID);
    }

    @JsonIgnore
    public String getPHPSLanResName() {
        Object objValue = this.get(FIELD_PHPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="phpslanresname")
    public void setPHPSLanResName(String pHPSLanResName) {
        this.set(FIELD_PHPSLANRESNAME, pHPSLanResName);
    }

    @JsonIgnore
    public boolean isPHPSLanResNameDirty() {
        return this.contains(FIELD_PHPSLANRESNAME);
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
    public String getPlaceHolder() {
        Object objValue = this.get(FIELD_PLACEHOLDER);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="placeholder")
    public void setPlaceHolder(String placeHolder) {
        this.set(FIELD_PLACEHOLDER, placeHolder);
    }

    @JsonIgnore
    public boolean isPlaceHolderDirty() {
        return this.contains(FIELD_PLACEHOLDER);
    }

    @JsonIgnore
    public String getPPSDEGridColId() {
        Object objValue = this.get(FIELD_PPSDEGRIDCOLID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppsdegridcolid")
    public void setPPSDEGridColId(String pPSDEGridColId) {
        this.set(FIELD_PPSDEGRIDCOLID, pPSDEGridColId);
    }

    @JsonIgnore
    public boolean isPPSDEGridColIdDirty() {
        return this.contains(FIELD_PPSDEGRIDCOLID);
    }

    @JsonIgnore
    public String getPPSDEGridColName() {
        Object objValue = this.get(FIELD_PPSDEGRIDCOLNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppsdegridcolname")
    public void setPPSDEGridColName(String pPSDEGridColName) {
        this.set(FIELD_PPSDEGRIDCOLNAME, pPSDEGridColName);
    }

    @JsonIgnore
    public boolean isPPSDEGridColNameDirty() {
        return this.contains(FIELD_PPSDEGRIDCOLNAME);
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
    public String getPSDEFId() {
        Object objValue = this.get(FIELD_PSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefid")
    public void setPSDEFId(String pSDEFId) {
        this.set(FIELD_PSDEFID, pSDEFId);
    }

    @JsonIgnore
    public boolean isPSDEFIdDirty() {
        return this.contains(FIELD_PSDEFID);
    }

    @JsonIgnore
    public String getPSDEFName() {
        Object objValue = this.get(FIELD_PSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefname")
    public void setPSDEFName(String pSDEFName) {
        this.set(FIELD_PSDEFNAME, pSDEFName);
    }

    @JsonIgnore
    public boolean isPSDEFNameDirty() {
        return this.contains(FIELD_PSDEFNAME);
    }

    @JsonIgnore
    public String getPSDEFSFItemId() {
        Object objValue = this.get(FIELD_PSDEFSFITEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefsfitemid")
    public void setPSDEFSFItemId(String pSDEFSFItemId) {
        this.set(FIELD_PSDEFSFITEMID, pSDEFSFItemId);
    }

    @JsonIgnore
    public boolean isPSDEFSFItemIdDirty() {
        return this.contains(FIELD_PSDEFSFITEMID);
    }

    @JsonIgnore
    public String getPSDEFSFItemName() {
        Object objValue = this.get(FIELD_PSDEFSFITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefsfitemname")
    public void setPSDEFSFItemName(String pSDEFSFItemName) {
        this.set(FIELD_PSDEFSFITEMNAME, pSDEFSFItemName);
    }

    @JsonIgnore
    public boolean isPSDEFSFItemNameDirty() {
        return this.contains(FIELD_PSDEFSFITEMNAME);
    }

    @JsonIgnore
    public String getPSDEFUIModeId() {
        Object objValue = this.get(FIELD_PSDEFUIMODEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefuimodeid")
    public void setPSDEFUIModeId(String pSDEFUIModeId) {
        this.set(FIELD_PSDEFUIMODEID, pSDEFUIModeId);
    }

    @JsonIgnore
    public boolean isPSDEFUIModeIdDirty() {
        return this.contains(FIELD_PSDEFUIMODEID);
    }

    @JsonIgnore
    public String getPSDEFUIModeName() {
        Object objValue = this.get(FIELD_PSDEFUIMODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefuimodename")
    public void setPSDEFUIModeName(String pSDEFUIModeName) {
        this.set(FIELD_PSDEFUIMODENAME, pSDEFUIModeName);
    }

    @JsonIgnore
    public boolean isPSDEFUIModeNameDirty() {
        return this.contains(FIELD_PSDEFUIMODENAME);
    }

    @JsonIgnore
    public String getPSDEGEIUpdateId() {
        Object objValue = this.get(FIELD_PSDEGEIUPDATEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdegeiupdateid")
    public void setPSDEGEIUpdateId(String pSDEGEIUpdateId) {
        this.set(FIELD_PSDEGEIUPDATEID, pSDEGEIUpdateId);
    }

    @JsonIgnore
    public boolean isPSDEGEIUpdateIdDirty() {
        return this.contains(FIELD_PSDEGEIUPDATEID);
    }

    @JsonIgnore
    public String getPSDEGEIUpdateName() {
        Object objValue = this.get(FIELD_PSDEGEIUPDATENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdegeiupdatename")
    public void setPSDEGEIUpdateName(String pSDEGEIUpdateName) {
        this.set(FIELD_PSDEGEIUPDATENAME, pSDEGEIUpdateName);
    }

    @JsonIgnore
    public boolean isPSDEGEIUpdateNameDirty() {
        return this.contains(FIELD_PSDEGEIUPDATENAME);
    }

    @JsonIgnore
    public String getPSDEGridColId() {
        Object objValue = this.get(FIELD_PSDEGRIDCOLID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdegridcolid")
    public void setPSDEGridColId(String pSDEGridColId) {
        this.set(FIELD_PSDEGRIDCOLID, pSDEGridColId);
    }

    @JsonIgnore
    public boolean isPSDEGridColIdDirty() {
        return this.contains(FIELD_PSDEGRIDCOLID);
    }

    @JsonIgnore
    public String getPSDEGridColName() {
        Object objValue = this.get(FIELD_PSDEGRIDCOLNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdegridcolname")
    public void setPSDEGridColName(String pSDEGridColName) {
        this.set(FIELD_PSDEGRIDCOLNAME, pSDEGridColName);
    }

    @JsonIgnore
    public boolean isPSDEGridColNameDirty() {
        return this.contains(FIELD_PSDEGRIDCOLNAME);
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
    public String getPSSysDictCatId() {
        Object objValue = this.get(FIELD_PSSYSDICTCATID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdictcatid")
    public void setPSSysDictCatId(String pSSysDictCatId) {
        this.set(FIELD_PSSYSDICTCATID, pSSysDictCatId);
    }

    @JsonIgnore
    public boolean isPSSysDictCatIdDirty() {
        return this.contains(FIELD_PSSYSDICTCATID);
    }

    @JsonIgnore
    public String getPSSysDictCatName() {
        Object objValue = this.get(FIELD_PSSYSDICTCATNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdictcatname")
    public void setPSSysDictCatName(String pSSysDictCatName) {
        this.set(FIELD_PSSYSDICTCATNAME, pSSysDictCatName);
    }

    @JsonIgnore
    public boolean isPSSysDictCatNameDirty() {
        return this.contains(FIELD_PSSYSDICTCATNAME);
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
    public String getPSSysEditorStyleId() {
        Object objValue = this.get(FIELD_PSSYSEDITORSTYLEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyseditorstyleid")
    public void setPSSysEditorStyleId(String pSSysEditorStyleId) {
        this.set(FIELD_PSSYSEDITORSTYLEID, pSSysEditorStyleId);
    }

    @JsonIgnore
    public boolean isPSSysEditorStyleIdDirty() {
        return this.contains(FIELD_PSSYSEDITORSTYLEID);
    }

    @JsonIgnore
    public String getPSSysEditorStyleName() {
        Object objValue = this.get(FIELD_PSSYSEDITORSTYLENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyseditorstylename")
    public void setPSSysEditorStyleName(String pSSysEditorStyleName) {
        this.set(FIELD_PSSYSEDITORSTYLENAME, pSSysEditorStyleName);
    }

    @JsonIgnore
    public boolean isPSSysEditorStyleNameDirty() {
        return this.contains(FIELD_PSSYSEDITORSTYLENAME);
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
    public String getRawServiceMethod() {
        Object objValue = this.get(FIELD_RAWSERVICEMETHOD);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="rawservicemethod")
    public void setRawServiceMethod(String rawServiceMethod) {
        this.set(FIELD_RAWSERVICEMETHOD, rawServiceMethod);
    }

    @JsonIgnore
    public boolean isRawServiceMethodDirty() {
        return this.contains(FIELD_RAWSERVICEMETHOD);
    }

    @JsonIgnore
    public String getRawServiceUrl() {
        Object objValue = this.get(FIELD_RAWSERVICEURL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="rawserviceurl")
    public void setRawServiceUrl(String rawServiceUrl) {
        this.set(FIELD_RAWSERVICEURL, rawServiceUrl);
    }

    @JsonIgnore
    public boolean isRawServiceUrlDirty() {
        return this.contains(FIELD_RAWSERVICEURL);
    }

    @JsonIgnore
    public String getRefPSDEACModeId() {
        Object objValue = this.get(FIELD_REFPSDEACMODEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsdeacmodeid")
    public void setRefPSDEACModeId(String refPSDEACModeId) {
        this.set(FIELD_REFPSDEACMODEID, refPSDEACModeId);
    }

    @JsonIgnore
    public boolean isRefPSDEACModeIdDirty() {
        return this.contains(FIELD_REFPSDEACMODEID);
    }

    @JsonIgnore
    public String getRefPSDEACModeName() {
        Object objValue = this.get(FIELD_REFPSDEACMODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsdeacmodename")
    public void setRefPSDEACModeName(String refPSDEACModeName) {
        this.set(FIELD_REFPSDEACMODENAME, refPSDEACModeName);
    }

    @JsonIgnore
    public boolean isRefPSDEACModeNameDirty() {
        return this.contains(FIELD_REFPSDEACMODENAME);
    }

    @JsonIgnore
    public String getRefPSDEDataSetId() {
        Object objValue = this.get(FIELD_REFPSDEDATASETID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsdedatasetid")
    public void setRefPSDEDataSetId(String refPSDEDataSetId) {
        this.set(FIELD_REFPSDEDATASETID, refPSDEDataSetId);
    }

    @JsonIgnore
    public boolean isRefPSDEDataSetIdDirty() {
        return this.contains(FIELD_REFPSDEDATASETID);
    }

    @JsonIgnore
    public String getRefPSDEDataSetName() {
        Object objValue = this.get(FIELD_REFPSDEDATASETNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsdedatasetname")
    public void setRefPSDEDataSetName(String refPSDEDataSetName) {
        this.set(FIELD_REFPSDEDATASETNAME, refPSDEDataSetName);
    }

    @JsonIgnore
    public boolean isRefPSDEDataSetNameDirty() {
        return this.contains(FIELD_REFPSDEDATASETNAME);
    }

    @JsonIgnore
    public String getRefPSDEId() {
        Object objValue = this.get(FIELD_REFPSDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsdeid")
    public void setRefPSDEId(String refPSDEId) {
        this.set(FIELD_REFPSDEID, refPSDEId);
    }

    @JsonIgnore
    public boolean isRefPSDEIdDirty() {
        return this.contains(FIELD_REFPSDEID);
    }

    @JsonIgnore
    public String getRefPSDEName() {
        Object objValue = this.get(FIELD_REFPSDENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsdename")
    public void setRefPSDEName(String refPSDEName) {
        this.set(FIELD_REFPSDENAME, refPSDEName);
    }

    @JsonIgnore
    public boolean isRefPSDENameDirty() {
        return this.contains(FIELD_REFPSDENAME);
    }

    @JsonIgnore
    public String getRefPSDERId() {
        Object objValue = this.get(FIELD_REFPSDERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsderid")
    public void setRefPSDERId(String refPSDERId) {
        this.set(FIELD_REFPSDERID, refPSDERId);
    }

    @JsonIgnore
    public boolean isRefPSDERIdDirty() {
        return this.contains(FIELD_REFPSDERID);
    }

    @JsonIgnore
    public String getRefPSDERName() {
        Object objValue = this.get(FIELD_REFPSDERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsdername")
    public void setRefPSDERName(String refPSDERName) {
        this.set(FIELD_REFPSDERNAME, refPSDERName);
    }

    @JsonIgnore
    public boolean isRefPSDERNameDirty() {
        return this.contains(FIELD_REFPSDERNAME);
    }

    @JsonIgnore
    public String getResetItemName() {
        Object objValue = this.get(FIELD_RESETITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="resetitemname")
    public void setResetItemName(String resetItemName) {
        this.set(FIELD_RESETITEMNAME, resetItemName);
    }

    @JsonIgnore
    public boolean isResetItemNameDirty() {
        return this.contains(FIELD_RESETITEMNAME);
    }

    @JsonIgnore
    public Integer getTreeItem() {
        Object objValue = this.get(FIELD_TREEITEM);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="treeitem")
    public void setTreeItem(Integer treeItem) {
        this.set(FIELD_TREEITEM, treeItem);
    }

    @JsonIgnore
    public boolean isTreeItemDirty() {
        return this.contains(FIELD_TREEITEM);
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
    public String getUpdateDV() {
        Object objValue = this.get(FIELD_UPDATEDV);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="updatedv")
    public void setUpdateDV(String updateDV) {
        this.set(FIELD_UPDATEDV, updateDV);
    }

    @JsonIgnore
    public boolean isUpdateDVDirty() {
        return this.contains(FIELD_UPDATEDV);
    }

    @JsonIgnore
    public String getUpdateDVT() {
        Object objValue = this.get(FIELD_UPDATEDVT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="updatedvt")
    public void setUpdateDVT(String updateDVT) {
        this.set(FIELD_UPDATEDVT, updateDVT);
    }

    @JsonIgnore
    public boolean isUpdateDVTDirty() {
        return this.contains(FIELD_UPDATEDVT);
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
    public String getValueItemName() {
        Object objValue = this.get(FIELD_VALUEITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="valueitemname")
    public void setValueItemName(String valueItemName) {
        this.set(FIELD_VALUEITEMNAME, valueItemName);
    }

    @JsonIgnore
    public boolean isValueItemNameDirty() {
        return this.contains(FIELD_VALUEITEMNAME);
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
        return this.getPSDEGridColId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSDEGridColId(strValue);
    }

    @JsonProperty(value="psdegridcols")
    public List<PSDEGridColDTO> getPsdegridcols() {
        return this.psdegridcols;
    }

    @JsonProperty(value="psdegridcols")
    public void setPsdegridcols(List<PSDEGridColDTO> psdegridcols) {
        this.psdegridcols = psdegridcols;
    }
}

