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
import net.ibizsys.modelapi.domain.PSDETreeNodeCol;
import net.ibizsys.modelapi.domain.PSDETreeNodeRV;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSDETreeNode
extends PSModelBase {
    public static final String FIELD_ACTIONPARAM = "actionparam";
    public static final String FIELD_APPENDCAPFLAG = "appendcapflag";
    public static final String FIELD_APPENDPNODEID = "appendpnodeid";
    public static final String FIELD_CAPTION = "caption";
    public static final String FIELD_CHECKED = "checked";
    public static final String FIELD_CHILDCNTPSDEFID = "childcntpsdefid";
    public static final String FIELD_CHILDCNTPSDEFNAME = "childcntpsdefname";
    public static final String FIELD_CLSPSDEFID = "clspsdefid";
    public static final String FIELD_CLSPSDEFNAME = "clspsdefname";
    public static final String FIELD_CMREFRESH = "cmrefresh";
    public static final String FIELD_CMREMOVE = "cmremove";
    public static final String FIELD_COUNTERID = "counterid";
    public static final String FIELD_COUNTERMODE = "countermode";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CUSTOMCOND = "customcond";
    public static final String FIELD_DATATYPEPSDEFID = "datatypepsdefid";
    public static final String FIELD_DATATYPEPSDEFNAME = "datatypepsdefname";
    public static final String FIELD_DISABLESELECT = "disableselect";
    public static final String FIELD_DISTINCTMODE = "distinctmode";
    public static final String FIELD_DYNACLASS = "dynaclass";
    public static final String FIELD_EDITDATAMODE = "editdatamode";
    public static final String FIELD_EDITMODE = "editmode";
    public static final String FIELD_ENABLECHECK = "enablecheck";
    public static final String FIELD_ENABLEQUICKSEARCH = "enablequicksearch";
    public static final String FIELD_ENABLEUP = "enableup";
    public static final String FIELD_ENABLEVIEWACTIONS = "enableviewactions";
    public static final String FIELD_EXPAND = "expand";
    public static final String FIELD_FILTERPSDEDSID = "filterpsdedsid";
    public static final String FIELD_FILTERPSDEDSNAME = "filterpsdedsname";
    public static final String FIELD_ICONPSDEFID = "iconpsdefid";
    public static final String FIELD_ICONPSDEFNAME = "iconpsdefname";
    public static final String FIELD_KEYPSDEFID = "keypsdefid";
    public static final String FIELD_KEYPSDEFNAME = "keypsdefname";
    public static final String FIELD_LEAFFLAGPSDEFID = "leafflagpsdefid";
    public static final String FIELD_LEAFFLAGPSDEFNAME = "leafflagpsdefname";
    public static final String FIELD_MAXSIZE = "maxsize";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MODELOBJ = "modelobj";
    public static final String FIELD_NAMEPSLANRESID = "namepslanresid";
    public static final String FIELD_NAMEPSLANRESNAME = "namepslanresname";
    public static final String FIELD_NAVVIEWFILTER = "navviewfilter";
    public static final String FIELD_NAVVIEWFILTERDESC = "navviewfilterdesc";
    public static final String FIELD_NAVVIEWPARAM = "navviewparam";
    public static final String FIELD_NEWDATAMODE = "newdatamode";
    public static final String FIELD_NO2PSDEUAGROUPID = "no2psdeuagroupid";
    public static final String FIELD_NO2PSDEUAGROUPNAME = "no2psdeuagroupname";
    public static final String FIELD_NODEACTION = "nodeaction";
    public static final String FIELD_NODEDATATYPE = "nodedatatype";
    public static final String FIELD_NODEID2PSDEFID = "nodeid2psdefid";
    public static final String FIELD_NODEID2PSDEFNAME = "nodeid2psdefname";
    public static final String FIELD_NODEID3PSDEFID = "nodeid3psdefid";
    public static final String FIELD_NODEID3PSDEFNAME = "nodeid3psdefname";
    public static final String FIELD_NODEID4PSDEFID = "nodeid4psdefid";
    public static final String FIELD_NODEID4PSDEFNAME = "nodeid4psdefname";
    public static final String FIELD_NODEIDPSDEFID = "nodeidpsdefid";
    public static final String FIELD_NODEIDPSDEFNAME = "nodeidpsdefname";
    public static final String FIELD_NODETYPE = "nodetype";
    public static final String FIELD_NODEVALUE = "nodevalue";
    public static final String FIELD_PREVENTXSS = "preventxss";
    public static final String FIELD_PSCODELISTID = "pscodelistid";
    public static final String FIELD_PSCODELISTNAME = "pscodelistname";
    public static final String FIELD_PSDEDSID = "psdedsid";
    public static final String FIELD_PSDEDSNAME = "psdedsname";
    public static final String FIELD_PSDEGRIDID = "psdegridid";
    public static final String FIELD_PSDEGRIDNAME = "psdegridname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDELOGICID = "psdelogicid";
    public static final String FIELD_PSDELOGICNAME = "psdelogicname";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSDERID = "psderid";
    public static final String FIELD_PSDERNAME = "psdername";
    public static final String FIELD_PSDETOOLBARID = "psdetoolbarid";
    public static final String FIELD_PSDETOOLBARNAME = "psdetoolbarname";
    public static final String FIELD_PSDETREENODEID = "psdetreenodeid";
    public static final String FIELD_PSDETREENODENAME = "psdetreenodename";
    public static final String FIELD_PSDETREEVIEWID = "psdetreeviewid";
    public static final String FIELD_PSDETREEVIEWNAME = "psdetreeviewname";
    public static final String FIELD_PSDEUAGROUPID = "psdeuagroupid";
    public static final String FIELD_PSDEUAGROUPNAME = "psdeuagroupname";
    public static final String FIELD_PSDEVIEWBASEID = "psdeviewbaseid";
    public static final String FIELD_PSDEVIEWBASENAME = "psdeviewbasename";
    public static final String FIELD_PSSYSCSSID = "pssyscssid";
    public static final String FIELD_PSSYSCSSNAME = "pssyscssname";
    public static final String FIELD_PSSYSIMAGEID = "pssysimageid";
    public static final String FIELD_PSSYSIMAGENAME = "pssysimagename";
    public static final String FIELD_PSSYSPFPLUGINID = "pssyspfpluginid";
    public static final String FIELD_PSSYSPFPLUGINNAME = "pssyspfpluginname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSVIEWPANELID = "pssysviewpanelid";
    public static final String FIELD_PSSYSVIEWPANELNAME = "pssysviewpanelname";
    public static final String FIELD_REMOVEPSDEACTIONID = "removepsdeactionid";
    public static final String FIELD_REMOVEPSDEACTIONNAME = "removepsdeactionname";
    public static final String FIELD_REMOVEPSDEOPPRIVID = "removepsdeopprivid";
    public static final String FIELD_REMOVEPSDEOPPRIVNAME = "removepsdeopprivname";
    public static final String FIELD_ROOTNODE = "rootnode";
    public static final String FIELD_SELECTED = "selected";
    public static final String FIELD_SORTDIR = "sortdir";
    public static final String FIELD_SORTPSDEFID = "sortpsdefid";
    public static final String FIELD_SORTPSDEFNAME = "sortpsdefname";
    public static final String FIELD_TEXTPSDEFID = "textpsdefid";
    public static final String FIELD_TEXTPSDEFNAME = "textpsdefname";
    public static final String FIELD_TIPPSLANRESID = "tippslanresid";
    public static final String FIELD_TIPPSLANRESNAME = "tippslanresname";
    public static final String FIELD_TIPSPSDEFID = "tipspsdefid";
    public static final String FIELD_TIPSPSDEFNAME = "tipspsdefname";
    public static final String FIELD_TOOLTIPINFO = "tooltipinfo";
    public static final String FIELD_TREENODETYPE = "treenodetype";
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
    public static final String FIELD_VIEWACTIONS = "viewactions";
    private List<PSDETreeNodeCol> psdetreenodecols;
    private List<PSDETreeNodeRV> psdetreenodervs;

    @JsonIgnore
    public String getActionParam() {
        Object objValue = this.get(FIELD_ACTIONPARAM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="actionparam")
    public void setActionParam(String actionParam) {
        this.set(FIELD_ACTIONPARAM, actionParam);
    }

    @JsonIgnore
    public boolean isActionParamDirty() {
        return this.contains(FIELD_ACTIONPARAM);
    }

    @JsonIgnore
    public Integer getAppendCapFlag() {
        Object objValue = this.get(FIELD_APPENDCAPFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="appendcapflag")
    public void setAppendCapFlag(Integer appendCapFlag) {
        this.set(FIELD_APPENDCAPFLAG, appendCapFlag);
    }

    @JsonIgnore
    public boolean isAppendCapFlagDirty() {
        return this.contains(FIELD_APPENDCAPFLAG);
    }

    @JsonIgnore
    public Integer getAppendPNodeId() {
        Object objValue = this.get(FIELD_APPENDPNODEID);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="appendpnodeid")
    public void setAppendPNodeId(Integer appendPNodeId) {
        this.set(FIELD_APPENDPNODEID, appendPNodeId);
    }

    @JsonIgnore
    public boolean isAppendPNodeIdDirty() {
        return this.contains(FIELD_APPENDPNODEID);
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
    public Integer getChecked() {
        Object objValue = this.get(FIELD_CHECKED);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="checked")
    public void setChecked(Integer checked) {
        this.set(FIELD_CHECKED, checked);
    }

    @JsonIgnore
    public boolean isCheckedDirty() {
        return this.contains(FIELD_CHECKED);
    }

    @JsonIgnore
    public String getChildCntPSDEFId() {
        Object objValue = this.get(FIELD_CHILDCNTPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="childcntpsdefid")
    public void setChildCntPSDEFId(String childCntPSDEFId) {
        this.set(FIELD_CHILDCNTPSDEFID, childCntPSDEFId);
    }

    @JsonIgnore
    public boolean isChildCntPSDEFIdDirty() {
        return this.contains(FIELD_CHILDCNTPSDEFID);
    }

    @JsonIgnore
    public String getChildCntPSDEFName() {
        Object objValue = this.get(FIELD_CHILDCNTPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="childcntpsdefname")
    public void setChildCntPSDEFName(String childCntPSDEFName) {
        this.set(FIELD_CHILDCNTPSDEFNAME, childCntPSDEFName);
    }

    @JsonIgnore
    public boolean isChildCntPSDEFNameDirty() {
        return this.contains(FIELD_CHILDCNTPSDEFNAME);
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
    public Integer getCMRefresh() {
        Object objValue = this.get(FIELD_CMREFRESH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="cmrefresh")
    public void setCMRefresh(Integer cMRefresh) {
        this.set(FIELD_CMREFRESH, cMRefresh);
    }

    @JsonIgnore
    public boolean isCMRefreshDirty() {
        return this.contains(FIELD_CMREFRESH);
    }

    @JsonIgnore
    public Integer getCMRemove() {
        Object objValue = this.get(FIELD_CMREMOVE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="cmremove")
    public void setCMRemove(Integer cMRemove) {
        this.set(FIELD_CMREMOVE, cMRemove);
    }

    @JsonIgnore
    public boolean isCMRemoveDirty() {
        return this.contains(FIELD_CMREMOVE);
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
    public Integer getCounterMode() {
        Object objValue = this.get(FIELD_COUNTERMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="countermode")
    public void setCounterMode(Integer counterMode) {
        this.set(FIELD_COUNTERMODE, counterMode);
    }

    @JsonIgnore
    public boolean isCounterModeDirty() {
        return this.contains(FIELD_COUNTERMODE);
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
    public String getDataTypePSDEFId() {
        Object objValue = this.get(FIELD_DATATYPEPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="datatypepsdefid")
    public void setDataTypePSDEFId(String dataTypePSDEFId) {
        this.set(FIELD_DATATYPEPSDEFID, dataTypePSDEFId);
    }

    @JsonIgnore
    public boolean isDataTypePSDEFIdDirty() {
        return this.contains(FIELD_DATATYPEPSDEFID);
    }

    @JsonIgnore
    public String getDataTypePSDEFName() {
        Object objValue = this.get(FIELD_DATATYPEPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="datatypepsdefname")
    public void setDataTypePSDEFName(String dataTypePSDEFName) {
        this.set(FIELD_DATATYPEPSDEFNAME, dataTypePSDEFName);
    }

    @JsonIgnore
    public boolean isDataTypePSDEFNameDirty() {
        return this.contains(FIELD_DATATYPEPSDEFNAME);
    }

    @JsonIgnore
    public Integer getDisableSelect() {
        Object objValue = this.get(FIELD_DISABLESELECT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="disableselect")
    public void setDisableSelect(Integer disableSelect) {
        this.set(FIELD_DISABLESELECT, disableSelect);
    }

    @JsonIgnore
    public boolean isDisableSelectDirty() {
        return this.contains(FIELD_DISABLESELECT);
    }

    @JsonIgnore
    public Integer getDistinctMode() {
        Object objValue = this.get(FIELD_DISTINCTMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="distinctmode")
    public void setDistinctMode(Integer distinctMode) {
        this.set(FIELD_DISTINCTMODE, distinctMode);
    }

    @JsonIgnore
    public boolean isDistinctModeDirty() {
        return this.contains(FIELD_DISTINCTMODE);
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
    public String getEditDataMode() {
        Object objValue = this.get(FIELD_EDITDATAMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="editdatamode")
    public void setEditDataMode(String editDataMode) {
        this.set(FIELD_EDITDATAMODE, editDataMode);
    }

    @JsonIgnore
    public boolean isEditDataModeDirty() {
        return this.contains(FIELD_EDITDATAMODE);
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
    public Integer getEnableCheck() {
        Object objValue = this.get(FIELD_ENABLECHECK);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablecheck")
    public void setEnableCheck(Integer enableCheck) {
        this.set(FIELD_ENABLECHECK, enableCheck);
    }

    @JsonIgnore
    public boolean isEnableCheckDirty() {
        return this.contains(FIELD_ENABLECHECK);
    }

    @JsonIgnore
    public Integer getEnableQuickSearch() {
        Object objValue = this.get(FIELD_ENABLEQUICKSEARCH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablequicksearch")
    public void setEnableQuickSearch(Integer enableQuickSearch) {
        this.set(FIELD_ENABLEQUICKSEARCH, enableQuickSearch);
    }

    @JsonIgnore
    public boolean isEnableQuickSearchDirty() {
        return this.contains(FIELD_ENABLEQUICKSEARCH);
    }

    @JsonIgnore
    public Integer getEnableUP() {
        Object objValue = this.get(FIELD_ENABLEUP);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enableup")
    public void setEnableUP(Integer enableUP) {
        this.set(FIELD_ENABLEUP, enableUP);
    }

    @JsonIgnore
    public boolean isEnableUPDirty() {
        return this.contains(FIELD_ENABLEUP);
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
    public Integer getExpand() {
        Object objValue = this.get(FIELD_EXPAND);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="expand")
    public void setExpand(Integer expand) {
        this.set(FIELD_EXPAND, expand);
    }

    @JsonIgnore
    public boolean isExpandDirty() {
        return this.contains(FIELD_EXPAND);
    }

    @JsonIgnore
    public String getFilterPSDEDSId() {
        Object objValue = this.get(FIELD_FILTERPSDEDSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="filterpsdedsid")
    public void setFilterPSDEDSId(String filterPSDEDSId) {
        this.set(FIELD_FILTERPSDEDSID, filterPSDEDSId);
    }

    @JsonIgnore
    public boolean isFilterPSDEDSIdDirty() {
        return this.contains(FIELD_FILTERPSDEDSID);
    }

    @JsonIgnore
    public String getFilterPSDEDSName() {
        Object objValue = this.get(FIELD_FILTERPSDEDSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="filterpsdedsname")
    public void setFilterPSDEDSName(String filterPSDEDSName) {
        this.set(FIELD_FILTERPSDEDSNAME, filterPSDEDSName);
    }

    @JsonIgnore
    public boolean isFilterPSDEDSNameDirty() {
        return this.contains(FIELD_FILTERPSDEDSNAME);
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
    public String getLeafFlagPSDEFId() {
        Object objValue = this.get(FIELD_LEAFFLAGPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="leafflagpsdefid")
    public void setLeafFlagPSDEFId(String leafFlagPSDEFId) {
        this.set(FIELD_LEAFFLAGPSDEFID, leafFlagPSDEFId);
    }

    @JsonIgnore
    public boolean isLeafFlagPSDEFIdDirty() {
        return this.contains(FIELD_LEAFFLAGPSDEFID);
    }

    @JsonIgnore
    public String getLeafFlagPSDEFName() {
        Object objValue = this.get(FIELD_LEAFFLAGPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="leafflagpsdefname")
    public void setLeafFlagPSDEFName(String leafFlagPSDEFName) {
        this.set(FIELD_LEAFFLAGPSDEFNAME, leafFlagPSDEFName);
    }

    @JsonIgnore
    public boolean isLeafFlagPSDEFNameDirty() {
        return this.contains(FIELD_LEAFFLAGPSDEFNAME);
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
    public String getNavViewFilterDesc() {
        Object objValue = this.get(FIELD_NAVVIEWFILTERDESC);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="navviewfilterdesc")
    public void setNavViewFilterDesc(String navViewFilterDesc) {
        this.set(FIELD_NAVVIEWFILTERDESC, navViewFilterDesc);
    }

    @JsonIgnore
    public boolean isNavViewFilterDescDirty() {
        return this.contains(FIELD_NAVVIEWFILTERDESC);
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
    public String getNewDataMode() {
        Object objValue = this.get(FIELD_NEWDATAMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="newdatamode")
    public void setNewDataMode(String newDataMode) {
        this.set(FIELD_NEWDATAMODE, newDataMode);
    }

    @JsonIgnore
    public boolean isNewDataModeDirty() {
        return this.contains(FIELD_NEWDATAMODE);
    }

    @JsonIgnore
    public String getNo2PSDEUAGroupId() {
        Object objValue = this.get(FIELD_NO2PSDEUAGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no2psdeuagroupid")
    public void setNo2PSDEUAGroupId(String no2PSDEUAGroupId) {
        this.set(FIELD_NO2PSDEUAGROUPID, no2PSDEUAGroupId);
    }

    @JsonIgnore
    public boolean isNo2PSDEUAGroupIdDirty() {
        return this.contains(FIELD_NO2PSDEUAGROUPID);
    }

    @JsonIgnore
    public String getNo2PSDEUAGroupName() {
        Object objValue = this.get(FIELD_NO2PSDEUAGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no2psdeuagroupname")
    public void setNo2PSDEUAGroupName(String no2PSDEUAGroupName) {
        this.set(FIELD_NO2PSDEUAGROUPNAME, no2PSDEUAGroupName);
    }

    @JsonIgnore
    public boolean isNo2PSDEUAGroupNameDirty() {
        return this.contains(FIELD_NO2PSDEUAGROUPNAME);
    }

    @JsonIgnore
    public String getNodeAction() {
        Object objValue = this.get(FIELD_NODEACTION);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="nodeaction")
    public void setNodeAction(String nodeAction) {
        this.set(FIELD_NODEACTION, nodeAction);
    }

    @JsonIgnore
    public boolean isNodeActionDirty() {
        return this.contains(FIELD_NODEACTION);
    }

    @JsonIgnore
    public String getNodeDataType() {
        Object objValue = this.get(FIELD_NODEDATATYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="nodedatatype")
    public void setNodeDataType(String nodeDataType) {
        this.set(FIELD_NODEDATATYPE, nodeDataType);
    }

    @JsonIgnore
    public boolean isNodeDataTypeDirty() {
        return this.contains(FIELD_NODEDATATYPE);
    }

    @JsonIgnore
    public String getNodeId2PSDEFId() {
        Object objValue = this.get(FIELD_NODEID2PSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="nodeid2psdefid")
    public void setNodeId2PSDEFId(String nodeId2PSDEFId) {
        this.set(FIELD_NODEID2PSDEFID, nodeId2PSDEFId);
    }

    @JsonIgnore
    public boolean isNodeId2PSDEFIdDirty() {
        return this.contains(FIELD_NODEID2PSDEFID);
    }

    @JsonIgnore
    public String getNodeId2PSDEFName() {
        Object objValue = this.get(FIELD_NODEID2PSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="nodeid2psdefname")
    public void setNodeId2PSDEFName(String nodeId2PSDEFName) {
        this.set(FIELD_NODEID2PSDEFNAME, nodeId2PSDEFName);
    }

    @JsonIgnore
    public boolean isNodeId2PSDEFNameDirty() {
        return this.contains(FIELD_NODEID2PSDEFNAME);
    }

    @JsonIgnore
    public String getNodeId3PSDEFId() {
        Object objValue = this.get(FIELD_NODEID3PSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="nodeid3psdefid")
    public void setNodeId3PSDEFId(String nodeId3PSDEFId) {
        this.set(FIELD_NODEID3PSDEFID, nodeId3PSDEFId);
    }

    @JsonIgnore
    public boolean isNodeId3PSDEFIdDirty() {
        return this.contains(FIELD_NODEID3PSDEFID);
    }

    @JsonIgnore
    public String getNodeId3PSDEFName() {
        Object objValue = this.get(FIELD_NODEID3PSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="nodeid3psdefname")
    public void setNodeId3PSDEFName(String nodeId3PSDEFName) {
        this.set(FIELD_NODEID3PSDEFNAME, nodeId3PSDEFName);
    }

    @JsonIgnore
    public boolean isNodeId3PSDEFNameDirty() {
        return this.contains(FIELD_NODEID3PSDEFNAME);
    }

    @JsonIgnore
    public String getNodeId4PSDEFId() {
        Object objValue = this.get(FIELD_NODEID4PSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="nodeid4psdefid")
    public void setNodeId4PSDEFId(String nodeId4PSDEFId) {
        this.set(FIELD_NODEID4PSDEFID, nodeId4PSDEFId);
    }

    @JsonIgnore
    public boolean isNodeId4PSDEFIdDirty() {
        return this.contains(FIELD_NODEID4PSDEFID);
    }

    @JsonIgnore
    public String getNodeId4PSDEFName() {
        Object objValue = this.get(FIELD_NODEID4PSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="nodeid4psdefname")
    public void setNodeId4PSDEFName(String nodeId4PSDEFName) {
        this.set(FIELD_NODEID4PSDEFNAME, nodeId4PSDEFName);
    }

    @JsonIgnore
    public boolean isNodeId4PSDEFNameDirty() {
        return this.contains(FIELD_NODEID4PSDEFNAME);
    }

    @JsonIgnore
    public String getNodeIdPSDEFId() {
        Object objValue = this.get(FIELD_NODEIDPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="nodeidpsdefid")
    public void setNodeIdPSDEFId(String nodeIdPSDEFId) {
        this.set(FIELD_NODEIDPSDEFID, nodeIdPSDEFId);
    }

    @JsonIgnore
    public boolean isNodeIdPSDEFIdDirty() {
        return this.contains(FIELD_NODEIDPSDEFID);
    }

    @JsonIgnore
    public String getNodeIdPSDEFName() {
        Object objValue = this.get(FIELD_NODEIDPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="nodeidpsdefname")
    public void setNodeIdPSDEFName(String nodeIdPSDEFName) {
        this.set(FIELD_NODEIDPSDEFNAME, nodeIdPSDEFName);
    }

    @JsonIgnore
    public boolean isNodeIdPSDEFNameDirty() {
        return this.contains(FIELD_NODEIDPSDEFNAME);
    }

    @JsonIgnore
    public String getNodeType() {
        Object objValue = this.get(FIELD_NODETYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="nodetype")
    public void setNodeType(String nodeType) {
        this.set(FIELD_NODETYPE, nodeType);
    }

    @JsonIgnore
    public boolean isNodeTypeDirty() {
        return this.contains(FIELD_NODETYPE);
    }

    @JsonIgnore
    public String getNodeValue() {
        Object objValue = this.get(FIELD_NODEVALUE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="nodevalue")
    public void setNodeValue(String nodeValue) {
        this.set(FIELD_NODEVALUE, nodeValue);
    }

    @JsonIgnore
    public boolean isNodeValueDirty() {
        return this.contains(FIELD_NODEVALUE);
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
    public Integer getRootNode() {
        Object objValue = this.get(FIELD_ROOTNODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="rootnode")
    public void setRootNode(Integer rootNode) {
        this.set(FIELD_ROOTNODE, rootNode);
    }

    @JsonIgnore
    public boolean isRootNodeDirty() {
        return this.contains(FIELD_ROOTNODE);
    }

    @JsonIgnore
    public Integer getSelected() {
        Object objValue = this.get(FIELD_SELECTED);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="selected")
    public void setSelected(Integer selected) {
        this.set(FIELD_SELECTED, selected);
    }

    @JsonIgnore
    public boolean isSelectedDirty() {
        return this.contains(FIELD_SELECTED);
    }

    @JsonIgnore
    public String getSortDir() {
        Object objValue = this.get(FIELD_SORTDIR);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="sortdir")
    public void setSortDir(String sortDir) {
        this.set(FIELD_SORTDIR, sortDir);
    }

    @JsonIgnore
    public boolean isSortDirDirty() {
        return this.contains(FIELD_SORTDIR);
    }

    @JsonIgnore
    public String getSortPSDEFId() {
        Object objValue = this.get(FIELD_SORTPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="sortpsdefid")
    public void setSortPSDEFId(String sortPSDEFId) {
        this.set(FIELD_SORTPSDEFID, sortPSDEFId);
    }

    @JsonIgnore
    public boolean isSortPSDEFIdDirty() {
        return this.contains(FIELD_SORTPSDEFID);
    }

    @JsonIgnore
    public String getSortPSDEFName() {
        Object objValue = this.get(FIELD_SORTPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="sortpsdefname")
    public void setSortPSDEFName(String sortPSDEFName) {
        this.set(FIELD_SORTPSDEFNAME, sortPSDEFName);
    }

    @JsonIgnore
    public boolean isSortPSDEFNameDirty() {
        return this.contains(FIELD_SORTPSDEFNAME);
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
    public String getTreeNodeType() {
        Object objValue = this.get(FIELD_TREENODETYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="treenodetype")
    public void setTreeNodeType(String treeNodeType) {
        this.set(FIELD_TREENODETYPE, treeNodeType);
    }

    @JsonIgnore
    public boolean isTreeNodeTypeDirty() {
        return this.contains(FIELD_TREENODETYPE);
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
        return this.getPSDETreeNodeId();
    }

    public void setSrfkey(String strValue) {
        this.setPSDETreeNodeId(strValue);
    }

    public List<PSDETreeNodeCol> getPsdetreenodecols() {
        return this.psdetreenodecols;
    }

    public void setPsdetreenodecols(List<PSDETreeNodeCol> psdetreenodecols) {
        this.psdetreenodecols = psdetreenodecols;
    }

    public List<PSDETreeNodeRV> getPsdetreenodervs() {
        return this.psdetreenodervs;
    }

    public void setPsdetreenodervs(List<PSDETreeNodeRV> psdetreenodervs) {
        this.psdetreenodervs = psdetreenodervs;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (strName.equalsIgnoreCase("psdetreenodecols")) {
            return true;
        }
        if (strName.equalsIgnoreCase("psdetreenodervs")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("psdetreenodecols")) {
            this.init();
            return this.psdetreenodecols;
        }
        if (strName.equalsIgnoreCase("psdetreenodervs")) {
            this.init();
            return this.psdetreenodervs;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSDETREENODE";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSDETreeNode item = (PSDETreeNode)MAPPER.readValue(new File(strJsonFilePath), PSDETreeNode.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSDETreeNode) {
            PSDETreeNode dst = (PSDETreeNode)target;
            if (!bSimple) {
                PSModelBase newitem;
                if (this.getPsdetreenodecols() != null) {
                    ArrayList<PSDETreeNodeCol> psdetreenodecols = new ArrayList<PSDETreeNodeCol>();
                    for (PSDETreeNodeCol pSDETreeNodeCol : this.getPsdetreenodecols()) {
                        if (bDeepMode) {
                            newitem = new PSDETreeNodeCol();
                            pSDETreeNodeCol.to(newitem, false, bDeepMode);
                            psdetreenodecols.add((PSDETreeNodeCol)newitem);
                            continue;
                        }
                        psdetreenodecols.add(pSDETreeNodeCol);
                    }
                    dst.setPsdetreenodecols(psdetreenodecols);
                }
                if (this.getPsdetreenodervs() != null) {
                    ArrayList<PSDETreeNodeRV> psdetreenodervs = new ArrayList<PSDETreeNodeRV>();
                    for (PSDETreeNodeRV pSDETreeNodeRV : this.getPsdetreenodervs()) {
                        if (bDeepMode) {
                            newitem = new PSDETreeNodeRV();
                            pSDETreeNodeRV.to(newitem, false, bDeepMode);
                            psdetreenodervs.add((PSDETreeNodeRV)newitem);
                            continue;
                        }
                        psdetreenodervs.add(pSDETreeNodeRV);
                    }
                    dst.setPsdetreenodervs(psdetreenodervs);
                }
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSDETreeNode) {
            PSDETreeNode src = (PSDETreeNode)source;
            if (!bSimple) {
                PSModelBase newItem;
                if (src.getPsdetreenodecols() != null) {
                    ArrayList<PSDETreeNodeCol> psdetreenodecols = new ArrayList<PSDETreeNodeCol>();
                    for (PSDETreeNodeCol pSDETreeNodeCol : src.getPsdetreenodecols()) {
                        if (bDeepMode) {
                            newItem = new PSDETreeNodeCol();
                            ((PSDETreeNodeCol)newItem).from(pSDETreeNodeCol, false, bDeepMode);
                            psdetreenodecols.add((PSDETreeNodeCol)newItem);
                            continue;
                        }
                        psdetreenodecols.add(pSDETreeNodeCol);
                    }
                    this.setPsdetreenodecols(psdetreenodecols);
                }
                if (src.getPsdetreenodervs() != null) {
                    ArrayList<PSDETreeNodeRV> psdetreenodervs = new ArrayList<PSDETreeNodeRV>();
                    for (PSDETreeNodeRV pSDETreeNodeRV : src.getPsdetreenodervs()) {
                        if (bDeepMode) {
                            newItem = new PSDETreeNodeRV();
                            ((PSDETreeNodeRV)newItem).from(pSDETreeNodeRV, false, bDeepMode);
                            psdetreenodervs.add((PSDETreeNodeRV)newItem);
                            continue;
                        }
                        psdetreenodervs.add(pSDETreeNodeRV);
                    }
                    this.setPsdetreenodervs(psdetreenodervs);
                }
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

