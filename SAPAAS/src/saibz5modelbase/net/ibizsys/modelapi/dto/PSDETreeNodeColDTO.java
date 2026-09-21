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

public class PSDETreeNodeColDTO
extends PSModelDTOBase {
    public static final String FIELD_ALLOWEMPTY = "allowempty";
    public static final String FIELD_CLCONVERTMODE = "clconvertmode";
    public static final String FIELD_CODELISTCONFIGMODE = "codelistconfigmode";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEDV = "createdv";
    public static final String FIELD_CREATEDVT = "createdvt";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CUSTOMCODE = "customcode";
    public static final String FIELD_CUSTOMMODE = "custommode";
    public static final String FIELD_DEFAULTVALUE = "defaultvalue";
    public static final String FIELD_EDITORPARAMS = "editorparams";
    public static final String FIELD_EDITORTYPE = "editortype";
    public static final String FIELD_ENABLECOND = "enablecond";
    public static final String FIELD_ENABLEITEMPRIV = "enableitempriv";
    public static final String FIELD_ENABLEROWEDIT = "enablerowedit";
    public static final String FIELD_GROUPITEM = "groupitem";
    public static final String FIELD_HIDDENDATAITEM = "hiddendataitem";
    public static final String FIELD_IGNOREINPUT = "ignoreinput";
    public static final String FIELD_LINKPSDEVIEWID = "linkpsdeviewid";
    public static final String FIELD_LINKPSDEVIEWNAME = "linkpsdeviewname";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_NEEDCODELISTCONFIG = "needcodelistconfig";
    public static final String FIELD_PICKUPPSDEVIEWID = "pickuppsdeviewid";
    public static final String FIELD_PICKUPPSDEVIEWNAME = "pickuppsdeviewname";
    public static final String FIELD_PLACEHOLDER = "placeholder";
    public static final String FIELD_PSCODELISTID = "pscodelistid";
    public static final String FIELD_PSCODELISTNAME = "pscodelistname";
    public static final String FIELD_PSDEFID = "psdefid";
    public static final String FIELD_PSDEFNAME = "psdefname";
    public static final String FIELD_PSDETREECOLID = "psdetreecolid";
    public static final String FIELD_PSDETREECOLNAME = "psdetreecolname";
    public static final String FIELD_PSDETREENODECOLID = "psdetreenodecolid";
    public static final String FIELD_PSDETREENODECOLNAME = "psdetreenodecolname";
    public static final String FIELD_PSDETREENODEID = "psdetreenodeid";
    public static final String FIELD_PSDETREENODENAME = "psdetreenodename";
    public static final String FIELD_PSDETREEVIEWID = "psdetreeviewid";
    public static final String FIELD_PSDETREEVIEWNAME = "psdetreeviewname";
    public static final String FIELD_PSSYSDICTCATID = "pssysdictcatid";
    public static final String FIELD_PSSYSDICTCATNAME = "pssysdictcatname";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    public static final String FIELD_PSSYSEDITORSTYLEID = "pssyseditorstyleid";
    public static final String FIELD_PSSYSEDITORSTYLENAME = "pssyseditorstylename";
    public static final String FIELD_RESETITEMNAME = "resetitemname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEDV = "updatedv";
    public static final String FIELD_UPDATEDVT = "updatedvt";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_VALUEFORMAT = "valueformat";
    public static final String FIELD_VALUEITEMNAME = "valueitemname";

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
    public String getDefaultValue() {
        Object objValue = this.get(FIELD_DEFAULTVALUE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="defaultvalue")
    public void setDefaultValue(String defaultValue) {
        this.set(FIELD_DEFAULTVALUE, defaultValue);
    }

    @JsonIgnore
    public boolean isDefaultValueDirty() {
        return this.contains(FIELD_DEFAULTVALUE);
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
    public String getPSDETreeColId() {
        Object objValue = this.get(FIELD_PSDETREECOLID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdetreecolid")
    public void setPSDETreeColId(String pSDETreeColId) {
        this.set(FIELD_PSDETREECOLID, pSDETreeColId);
    }

    @JsonIgnore
    public boolean isPSDETreeColIdDirty() {
        return this.contains(FIELD_PSDETREECOLID);
    }

    @JsonIgnore
    public String getPSDETreeColName() {
        Object objValue = this.get(FIELD_PSDETREECOLNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdetreecolname")
    public void setPSDETreeColName(String pSDETreeColName) {
        this.set(FIELD_PSDETREECOLNAME, pSDETreeColName);
    }

    @JsonIgnore
    public boolean isPSDETreeColNameDirty() {
        return this.contains(FIELD_PSDETREECOLNAME);
    }

    @JsonIgnore
    public String getPSDETreeNodeColId() {
        Object objValue = this.get(FIELD_PSDETREENODECOLID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdetreenodecolid")
    public void setPSDETreeNodeColId(String pSDETreeNodeColId) {
        this.set(FIELD_PSDETREENODECOLID, pSDETreeNodeColId);
    }

    @JsonIgnore
    public boolean isPSDETreeNodeColIdDirty() {
        return this.contains(FIELD_PSDETREENODECOLID);
    }

    @JsonIgnore
    public String getPSDETreeNodeColName() {
        Object objValue = this.get(FIELD_PSDETREENODECOLNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdetreenodecolname")
    public void setPSDETreeNodeColName(String pSDETreeNodeColName) {
        this.set(FIELD_PSDETREENODECOLNAME, pSDETreeNodeColName);
    }

    @JsonIgnore
    public boolean isPSDETreeNodeColNameDirty() {
        return this.contains(FIELD_PSDETREENODECOLNAME);
    }

    @JsonIgnore
    public String getPSDETreeNodeId() {
        Object objValue = this.get(FIELD_PSDETREENODEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdetreenodeid")
    public void setPSDETreeNodeId(String pSDETreeNodeId) {
        this.set(FIELD_PSDETREENODEID, pSDETreeNodeId);
    }

    @JsonIgnore
    public boolean isPSDETreeNodeIdDirty() {
        return this.contains(FIELD_PSDETREENODEID);
    }

    @JsonIgnore
    public String getPSDETreeNodeName() {
        Object objValue = this.get(FIELD_PSDETREENODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdetreenodename")
    public void setPSDETreeNodeName(String pSDETreeNodeName) {
        this.set(FIELD_PSDETREENODENAME, pSDETreeNodeName);
    }

    @JsonIgnore
    public boolean isPSDETreeNodeNameDirty() {
        return this.contains(FIELD_PSDETREENODENAME);
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

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDETreeNodeColId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSDETreeNodeColId(strValue);
    }
}

