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
import net.ibizsys.modelapi.domain.PSACHandler;
import net.ibizsys.modelapi.domain.PSCtrlLogicGroup;
import net.ibizsys.modelapi.domain.PSCtrlMsg;
import net.ibizsys.modelapi.domain.PSDEACMode;
import net.ibizsys.modelapi.domain.PSDEAction;
import net.ibizsys.modelapi.domain.PSDEActionGroup;
import net.ibizsys.modelapi.domain.PSDEActionLogic;
import net.ibizsys.modelapi.domain.PSDEChart;
import net.ibizsys.modelapi.domain.PSDEDBCfg;
import net.ibizsys.modelapi.domain.PSDEDBIndex;
import net.ibizsys.modelapi.domain.PSDEDRGroup;
import net.ibizsys.modelapi.domain.PSDEDRItem;
import net.ibizsys.modelapi.domain.PSDEDTSQueue;
import net.ibizsys.modelapi.domain.PSDEDataExp;
import net.ibizsys.modelapi.domain.PSDEDataImp;
import net.ibizsys.modelapi.domain.PSDEDataQuery;
import net.ibizsys.modelapi.domain.PSDEDataRelation;
import net.ibizsys.modelapi.domain.PSDEDataSet;
import net.ibizsys.modelapi.domain.PSDEDataSync;
import net.ibizsys.modelapi.domain.PSDEDataView;
import net.ibizsys.modelapi.domain.PSDEFGroup;
import net.ibizsys.modelapi.domain.PSDEFValueRule;
import net.ibizsys.modelapi.domain.PSDEField;
import net.ibizsys.modelapi.domain.PSDEForm;
import net.ibizsys.modelapi.domain.PSDEGrid;
import net.ibizsys.modelapi.domain.PSDEGroup;
import net.ibizsys.modelapi.domain.PSDEList;
import net.ibizsys.modelapi.domain.PSDELogic;
import net.ibizsys.modelapi.domain.PSDEMainState;
import net.ibizsys.modelapi.domain.PSDEMap;
import net.ibizsys.modelapi.domain.PSDENotify;
import net.ibizsys.modelapi.domain.PSDEOPPriv;
import net.ibizsys.modelapi.domain.PSDEOPPrivRole;
import net.ibizsys.modelapi.domain.PSDEPrint;
import net.ibizsys.modelapi.domain.PSDER;
import net.ibizsys.modelapi.domain.PSDERGroup;
import net.ibizsys.modelapi.domain.PSDEReport;
import net.ibizsys.modelapi.domain.PSDESampleData;
import net.ibizsys.modelapi.domain.PSDETable;
import net.ibizsys.modelapi.domain.PSDEToolbar;
import net.ibizsys.modelapi.domain.PSDETreeView;
import net.ibizsys.modelapi.domain.PSDEUAGroup;
import net.ibizsys.modelapi.domain.PSDEUIAction;
import net.ibizsys.modelapi.domain.PSDEUserRole;
import net.ibizsys.modelapi.domain.PSDEUtilDE;
import net.ibizsys.modelapi.domain.PSDEVRGroup;
import net.ibizsys.modelapi.domain.PSDEViewBase;
import net.ibizsys.modelapi.domain.PSDEWizard;
import net.ibizsys.modelapi.domain.PSSysCalendar;
import net.ibizsys.modelapi.domain.PSSysCounter;
import net.ibizsys.modelapi.domain.PSSysDMItem;
import net.ibizsys.modelapi.domain.PSSysDashboard;
import net.ibizsys.modelapi.domain.PSSysMapView;
import net.ibizsys.modelapi.domain.PSSysPortlet;
import net.ibizsys.modelapi.domain.PSSysSearchBar;
import net.ibizsys.modelapi.domain.PSSysTestCase;
import net.ibizsys.modelapi.domain.PSSysTestData;
import net.ibizsys.modelapi.domain.PSSysViewPanel;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSDataEntity
extends PSModelBase {
    public static final String FIELD_ACCCTRLARCH = "accctrlarch";
    public static final String FIELD_AUDITMODE = "auditmode";
    public static final String FIELD_BASECLSPARAMS = "baseclsparams";
    public static final String FIELD_BIZTAG = "biztag";
    public static final String FIELD_CODENAME = "codename";
    public static final String FIELD_COLOR = "color";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DATAACCMODE = "dataaccmode";
    public static final String FIELD_DATACHGLOGMODE = "datachglogmode";
    public static final String FIELD_DATAIMPEXPFLAG = "dataimpexpflag";
    public static final String FIELD_DBTABSPACE = "dbtabspace";
    public static final String FIELD_DECAT = "decat";
    public static final String FIELD_DEHOLDER = "deholder";
    public static final String FIELD_DELOCKFLAG = "delockflag";
    public static final String FIELD_DESN = "desn";
    public static final String FIELD_DETAG = "detag";
    public static final String FIELD_DETAG2 = "detag2";
    public static final String FIELD_DETYPE = "detype";
    public static final String FIELD_DSLINK = "dslink";
    public static final String FIELD_DYNAMICMODE = "dynamicmode";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_ENABLEAUDIT = "enableaudit";
    public static final String FIELD_ENABLEDATAVER = "enabledataver";
    public static final String FIELD_ENABLEDEACTION = "enabledeaction";
    public static final String FIELD_ENABLEDEDATASET = "enablededataset";
    public static final String FIELD_ENABLEDYNASYS = "enabledynasys";
    public static final String FIELD_ENABLEENTITYCACHE = "enableentitycache";
    public static final String FIELD_ENABLEMOB = "enablemob";
    public static final String FIELD_ENABLEOPNAMEMODEL = "enableopnamemodel";
    public static final String FIELD_ENABLEORGMODEL = "enableorgmodel";
    public static final String FIELD_ENABLESELECT = "enableselect";
    public static final String FIELD_ENABLEWFMODEL = "enablewfmodel";
    public static final String FIELD_ENAMULTIFORM = "enamultiform";
    public static final String FIELD_ENATEMPDATA = "enatempdata";
    public static final String FIELD_ENTITYCACHETIMEOUT = "entitycachetimeout";
    public static final String FIELD_EXISTINGMODEL = "existingmodel";
    public static final String FIELD_EXTABLENAME = "extablename";
    public static final String FIELD_INDEXDETYPE = "indexdetype";
    public static final String FIELD_KEYRULE = "keyrule";
    public static final String FIELD_LNPSLANRESID = "lnpslanresid";
    public static final String FIELD_LNPSLANRESNAME = "lnpslanresname";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_LOGICINVALIDVALUE = "logicinvalidvalue";
    public static final String FIELD_LOGICNAME = "logicname";
    public static final String FIELD_LOGICVALID = "logicvalid";
    public static final String FIELD_LOGICVALIDVALUE = "logicvalidvalue";
    public static final String FIELD_MAXENTITYCACHECNT = "maxentitycachecnt";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MODCOLOR = "modcolor";
    public static final String FIELD_MODELIMPEXPFLAG = "modelimpexpflag";
    public static final String FIELD_MODELSTATE = "modelstate";
    public static final String FIELD_MSACTIONLOGICFLAG = "msactionlogicflag";
    public static final String FIELD_NOVIEWMODE = "noviewmode";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PSDATAENTITYID = "psdataentityid";
    public static final String FIELD_PSDATAENTITYNAME = "psdataentityname";
    public static final String FIELD_PSDEFINPUTTIPSETID = "psdefinputtipsetid";
    public static final String FIELD_PSDEFINPUTTIPSETNAME = "psdefinputtipsetname";
    public static final String FIELD_PSDYNADETEMPLID = "psdynadetemplid";
    public static final String FIELD_PSDYNADETEMPLNAME = "psdynadetemplname";
    public static final String FIELD_PSHELPMODULEID = "pshelpmoduleid";
    public static final String FIELD_PSHELPMODULENAME = "pshelpmodulename";
    public static final String FIELD_PSMODULEID = "psmoduleid";
    public static final String FIELD_PSMODULENAME = "psmodulename";
    public static final String FIELD_PSSUBSYSSADEID = "pssubsyssadeid";
    public static final String FIELD_PSSUBSYSSADENAME = "pssubsyssadename";
    public static final String FIELD_PSSUBSYSSERVICEAPIID = "pssubsysserviceapiid";
    public static final String FIELD_PSSUBSYSSERVICEAPINAME = "pssubsysserviceapiname";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    public static final String FIELD_PSSYSIMAGEID = "pssysimageid";
    public static final String FIELD_PSSYSIMAGENAME = "pssysimagename";
    public static final String FIELD_PSSYSMODELGROUPID = "pssysmodelgroupid";
    public static final String FIELD_PSSYSMODELGROUPNAME = "pssysmodelgroupname";
    public static final String FIELD_PSSYSREQITEMID = "pssysreqitemid";
    public static final String FIELD_PSSYSREQITEMNAME = "pssysreqitemname";
    public static final String FIELD_PSSYSSFPLUGINID = "pssyssfpluginid";
    public static final String FIELD_PSSYSSFPLUGINNAME = "pssyssfpluginname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_READONLYMODE = "readonlymode";
    public static final String FIELD_REMOVEFLAG = "removeflag";
    public static final String FIELD_SAASMODE = "saasmode";
    public static final String FIELD_SERVICEAPIFLAG = "serviceapiflag";
    public static final String FIELD_SERVICECODENAME = "servicecodename";
    public static final String FIELD_STORAGEMODE = "storagemode";
    public static final String FIELD_SUBSYSMODULE = "subsysmodule";
    public static final String FIELD_SYSTEMFLAG = "systemflag";
    public static final String FIELD_TABLENAME = "tablename";
    public static final String FIELD_TESTCASEFLAG = "testcaseflag";
    public static final String FIELD_TODOTASK = "todotask";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERACTION = "useraction";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERPARAMS = "userparams";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";
    public static final String FIELD_VIEWLEVEL = "viewlevel";
    public static final String FIELD_VIEWNAME = "viewname";
    public static final String FIELD_VIEWNAME2 = "viewname2";
    public static final String FIELD_VIEWNAME3 = "viewname3";
    public static final String FIELD_VIEWNAME4 = "viewname4";
    public static final String FIELD_VIRTUALFLAG = "virtualflag";
    public static final String FIELD_VKEYSEPARATOR = "vkeyseparator";
    private List<PSSysTestCase> pssystestcases;
    private List<PSACHandler> psachandlers;
    private List<PSCtrlLogicGroup> psctrllogicgroups;
    private List<PSCtrlMsg> psctrlmsgs;
    private List<PSDEAction> psdeactions;
    private List<PSDEDataExp> psdedataexps;
    private List<PSDEDataImp> psdedataimps;
    private List<PSDEDataQuery> psdedataqueries;
    private List<PSDEDataRelation> psdedatarelations;
    private List<PSDEDataSet> psdedatasets;
    private List<PSDEDBIndex> psdedbindices;
    private List<PSDEDRItem> psdedritems;
    private List<PSDEGroup> psdegroups;
    private List<PSDELogic> psdelogics;
    private List<PSDEPrint> psdeprints;
    private List<PSDERGroup> psdergroups;
    private List<PSDEToolbar> psdetoolbars;
    private List<PSDEUAGroup> psdeuagroups;
    private List<PSDEUIAction> psdeuiactions;
    private List<PSDEVRGroup> psdevrgroups;
    private List<PSSysCalendar> pssyscalendars;
    private List<PSSysCounter> pssyscounters;
    private List<PSSysDashboard> pssysdashboards;
    private List<PSSysMapView> pssysmapviews;
    private List<PSSysPortlet> pssysportlets;
    private List<PSSysSearchBar> pssyssearchbars;
    private List<PSSysViewPanel> pssysviewpanels;
    private List<PSDEACMode> psdeacmodes;
    private List<PSDEDataSync> psdedatasyncs;
    private List<PSDEList> psdelists;
    private List<PSDEMainState> psdemainstates;
    private List<PSDEMap> psdemaps;
    private List<PSDENotify> psdenotifies;
    private List<PSDER> psders;
    private List<PSDETreeView> psdetreeviews;
    private List<PSSysTestData> pssystestdata;
    private List<PSDEActionGroup> psdeactiongroups;
    private List<PSDEActionLogic> psdeactionlogics;
    private List<PSDEChart> psdecharts;
    private List<PSDEDataView> psdedataviews;
    private List<PSDEDTSQueue> psdedtsqueues;
    private List<PSDEForm> psdeforms;
    private List<PSDEFValueRule> psdefvaluerules;
    private List<PSDEGrid> psdegrids;
    private List<PSDEReport> psdereports;
    private List<PSDESampleData> psdesampledata;
    private List<PSDEViewBase> psdeviewbases;
    private List<PSDEWizard> psdewizards;
    private List<PSDEDBCfg> psdedbcfgs;
    private List<PSDEDRGroup> psdedrgroups;
    private List<PSDEField> psdefields;
    private List<PSDEOPPriv> psdeopprivs;
    private List<PSDETable> psdetables;
    private List<PSDEUserRole> psdeuserroles;
    private List<PSSysDMItem> pssysdmitems;
    private List<PSDEOPPrivRole> psdeopprivroles;
    private List<PSDEUtilDE> psdeutildes;
    private List<PSDEFGroup> psdefgroups;

    @JsonIgnore
    public Integer getAccCtrlArch() {
        Object objValue = this.get(FIELD_ACCCTRLARCH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="accctrlarch")
    public void setAccCtrlArch(Integer accCtrlArch) {
        this.set(FIELD_ACCCTRLARCH, accCtrlArch);
    }

    @JsonIgnore
    public boolean isAccCtrlArchDirty() {
        return this.contains(FIELD_ACCCTRLARCH);
    }

    @JsonIgnore
    public Integer getAuditMode() {
        Object objValue = this.get(FIELD_AUDITMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="auditmode")
    public void setAuditMode(Integer auditMode) {
        this.set(FIELD_AUDITMODE, auditMode);
    }

    @JsonIgnore
    public boolean isAuditModeDirty() {
        return this.contains(FIELD_AUDITMODE);
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
    public String getBizTag() {
        Object objValue = this.get(FIELD_BIZTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="biztag")
    public void setBizTag(String bizTag) {
        this.set(FIELD_BIZTAG, bizTag);
    }

    @JsonIgnore
    public boolean isBizTagDirty() {
        return this.contains(FIELD_BIZTAG);
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
    public Integer getDataAccMode() {
        Object objValue = this.get(FIELD_DATAACCMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="dataaccmode")
    public void setDataAccMode(Integer dataAccMode) {
        this.set(FIELD_DATAACCMODE, dataAccMode);
    }

    @JsonIgnore
    public boolean isDataAccModeDirty() {
        return this.contains(FIELD_DATAACCMODE);
    }

    @JsonIgnore
    public Integer getDataChgLogMode() {
        Object objValue = this.get(FIELD_DATACHGLOGMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="datachglogmode")
    public void setDataChgLogMode(Integer dataChgLogMode) {
        this.set(FIELD_DATACHGLOGMODE, dataChgLogMode);
    }

    @JsonIgnore
    public boolean isDataChgLogModeDirty() {
        return this.contains(FIELD_DATACHGLOGMODE);
    }

    @JsonIgnore
    public Integer getDataImpExpFlag() {
        Object objValue = this.get(FIELD_DATAIMPEXPFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="dataimpexpflag")
    public void setDataImpExpFlag(Integer dataImpExpFlag) {
        this.set(FIELD_DATAIMPEXPFLAG, dataImpExpFlag);
    }

    @JsonIgnore
    public boolean isDataImpExpFlagDirty() {
        return this.contains(FIELD_DATAIMPEXPFLAG);
    }

    @JsonIgnore
    public String getDBTabSpace() {
        Object objValue = this.get(FIELD_DBTABSPACE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dbtabspace")
    public void setDBTabSpace(String dBTabSpace) {
        this.set(FIELD_DBTABSPACE, dBTabSpace);
    }

    @JsonIgnore
    public boolean isDBTabSpaceDirty() {
        return this.contains(FIELD_DBTABSPACE);
    }

    @JsonIgnore
    public String getDECat() {
        Object objValue = this.get(FIELD_DECAT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="decat")
    public void setDECat(String dECat) {
        this.set(FIELD_DECAT, dECat);
    }

    @JsonIgnore
    public boolean isDECatDirty() {
        return this.contains(FIELD_DECAT);
    }

    @JsonIgnore
    public Integer getDEHolder() {
        Object objValue = this.get(FIELD_DEHOLDER);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="deholder")
    public void setDEHolder(Integer dEHolder) {
        this.set(FIELD_DEHOLDER, dEHolder);
    }

    @JsonIgnore
    public boolean isDEHolderDirty() {
        return this.contains(FIELD_DEHOLDER);
    }

    @JsonIgnore
    public Integer getDELockFlag() {
        Object objValue = this.get(FIELD_DELOCKFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="delockflag")
    public void setDELockFlag(Integer dELockFlag) {
        this.set(FIELD_DELOCKFLAG, dELockFlag);
    }

    @JsonIgnore
    public boolean isDELockFlagDirty() {
        return this.contains(FIELD_DELOCKFLAG);
    }

    @JsonIgnore
    public String getDESN() {
        Object objValue = this.get(FIELD_DESN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="desn")
    public void setDESN(String dESN) {
        this.set(FIELD_DESN, dESN);
    }

    @JsonIgnore
    public boolean isDESNDirty() {
        return this.contains(FIELD_DESN);
    }

    @JsonIgnore
    public String getDETag() {
        Object objValue = this.get(FIELD_DETAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="detag")
    public void setDETag(String dETag) {
        this.set(FIELD_DETAG, dETag);
    }

    @JsonIgnore
    public boolean isDETagDirty() {
        return this.contains(FIELD_DETAG);
    }

    @JsonIgnore
    public String getDETag2() {
        Object objValue = this.get(FIELD_DETAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="detag2")
    public void setDETag2(String dETag2) {
        this.set(FIELD_DETAG2, dETag2);
    }

    @JsonIgnore
    public boolean isDETag2Dirty() {
        return this.contains(FIELD_DETAG2);
    }

    @JsonIgnore
    public Integer getDEType() {
        Object objValue = this.get(FIELD_DETYPE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="detype")
    public void setDEType(Integer dEType) {
        this.set(FIELD_DETYPE, dEType);
    }

    @JsonIgnore
    public boolean isDETypeDirty() {
        return this.contains(FIELD_DETYPE);
    }

    @JsonIgnore
    public String getDSLink() {
        Object objValue = this.get(FIELD_DSLINK);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dslink")
    public void setDSLink(String dSLink) {
        this.set(FIELD_DSLINK, dSLink);
    }

    @JsonIgnore
    public boolean isDSLinkDirty() {
        return this.contains(FIELD_DSLINK);
    }

    @JsonIgnore
    public Integer getDynamicMode() {
        Object objValue = this.get(FIELD_DYNAMICMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="dynamicmode")
    public void setDynamicMode(Integer dynamicMode) {
        this.set(FIELD_DYNAMICMODE, dynamicMode);
    }

    @JsonIgnore
    public boolean isDynamicModeDirty() {
        return this.contains(FIELD_DYNAMICMODE);
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
    public Integer getEnableAudit() {
        Object objValue = this.get(FIELD_ENABLEAUDIT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enableaudit")
    public void setEnableAudit(Integer enableAudit) {
        this.set(FIELD_ENABLEAUDIT, enableAudit);
    }

    @JsonIgnore
    public boolean isEnableAuditDirty() {
        return this.contains(FIELD_ENABLEAUDIT);
    }

    @JsonIgnore
    public Integer getEnableDataVer() {
        Object objValue = this.get(FIELD_ENABLEDATAVER);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enabledataver")
    public void setEnableDataVer(Integer enableDataVer) {
        this.set(FIELD_ENABLEDATAVER, enableDataVer);
    }

    @JsonIgnore
    public boolean isEnableDataVerDirty() {
        return this.contains(FIELD_ENABLEDATAVER);
    }

    @JsonIgnore
    public Integer getEnableDEAction() {
        Object objValue = this.get(FIELD_ENABLEDEACTION);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enabledeaction")
    public void setEnableDEAction(Integer enableDEAction) {
        this.set(FIELD_ENABLEDEACTION, enableDEAction);
    }

    @JsonIgnore
    public boolean isEnableDEActionDirty() {
        return this.contains(FIELD_ENABLEDEACTION);
    }

    @JsonIgnore
    public Integer getEnableDEDataSet() {
        Object objValue = this.get(FIELD_ENABLEDEDATASET);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablededataset")
    public void setEnableDEDataSet(Integer enableDEDataSet) {
        this.set(FIELD_ENABLEDEDATASET, enableDEDataSet);
    }

    @JsonIgnore
    public boolean isEnableDEDataSetDirty() {
        return this.contains(FIELD_ENABLEDEDATASET);
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
    public Integer getEnableEntityCache() {
        Object objValue = this.get(FIELD_ENABLEENTITYCACHE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enableentitycache")
    public void setEnableEntityCache(Integer enableEntityCache) {
        this.set(FIELD_ENABLEENTITYCACHE, enableEntityCache);
    }

    @JsonIgnore
    public boolean isEnableEntityCacheDirty() {
        return this.contains(FIELD_ENABLEENTITYCACHE);
    }

    @JsonIgnore
    public Integer getEnableMob() {
        Object objValue = this.get(FIELD_ENABLEMOB);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablemob")
    public void setEnableMob(Integer enableMob) {
        this.set(FIELD_ENABLEMOB, enableMob);
    }

    @JsonIgnore
    public boolean isEnableMobDirty() {
        return this.contains(FIELD_ENABLEMOB);
    }

    @JsonIgnore
    public Integer getEnableOPNameModel() {
        Object objValue = this.get(FIELD_ENABLEOPNAMEMODEL);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enableopnamemodel")
    public void setEnableOPNameModel(Integer enableOPNameModel) {
        this.set(FIELD_ENABLEOPNAMEMODEL, enableOPNameModel);
    }

    @JsonIgnore
    public boolean isEnableOPNameModelDirty() {
        return this.contains(FIELD_ENABLEOPNAMEMODEL);
    }

    @JsonIgnore
    public Integer getEnableOrgModel() {
        Object objValue = this.get(FIELD_ENABLEORGMODEL);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enableorgmodel")
    public void setEnableOrgModel(Integer enableOrgModel) {
        this.set(FIELD_ENABLEORGMODEL, enableOrgModel);
    }

    @JsonIgnore
    public boolean isEnableOrgModelDirty() {
        return this.contains(FIELD_ENABLEORGMODEL);
    }

    @JsonIgnore
    public Integer getEnableSelect() {
        Object objValue = this.get(FIELD_ENABLESELECT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enableselect")
    public void setEnableSelect(Integer enableSelect) {
        this.set(FIELD_ENABLESELECT, enableSelect);
    }

    @JsonIgnore
    public boolean isEnableSelectDirty() {
        return this.contains(FIELD_ENABLESELECT);
    }

    @JsonIgnore
    public Integer getEnableWFModel() {
        Object objValue = this.get(FIELD_ENABLEWFMODEL);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablewfmodel")
    public void setEnableWFModel(Integer enableWFModel) {
        this.set(FIELD_ENABLEWFMODEL, enableWFModel);
    }

    @JsonIgnore
    public boolean isEnableWFModelDirty() {
        return this.contains(FIELD_ENABLEWFMODEL);
    }

    @JsonIgnore
    public Integer getEnaMultiForm() {
        Object objValue = this.get(FIELD_ENAMULTIFORM);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enamultiform")
    public void setEnaMultiForm(Integer enaMultiForm) {
        this.set(FIELD_ENAMULTIFORM, enaMultiForm);
    }

    @JsonIgnore
    public boolean isEnaMultiFormDirty() {
        return this.contains(FIELD_ENAMULTIFORM);
    }

    @JsonIgnore
    public Integer getEnaTempData() {
        Object objValue = this.get(FIELD_ENATEMPDATA);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enatempdata")
    public void setEnaTempData(Integer enaTempData) {
        this.set(FIELD_ENATEMPDATA, enaTempData);
    }

    @JsonIgnore
    public boolean isEnaTempDataDirty() {
        return this.contains(FIELD_ENATEMPDATA);
    }

    @JsonIgnore
    public Integer getEntityCacheTimeout() {
        Object objValue = this.get(FIELD_ENTITYCACHETIMEOUT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="entitycachetimeout")
    public void setEntityCacheTimeout(Integer entityCacheTimeout) {
        this.set(FIELD_ENTITYCACHETIMEOUT, entityCacheTimeout);
    }

    @JsonIgnore
    public boolean isEntityCacheTimeoutDirty() {
        return this.contains(FIELD_ENTITYCACHETIMEOUT);
    }

    @JsonIgnore
    public Integer getExistingModel() {
        Object objValue = this.get(FIELD_EXISTINGMODEL);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="existingmodel")
    public void setExistingModel(Integer existingModel) {
        this.set(FIELD_EXISTINGMODEL, existingModel);
    }

    @JsonIgnore
    public boolean isExistingModelDirty() {
        return this.contains(FIELD_EXISTINGMODEL);
    }

    @JsonIgnore
    public String getExTableName() {
        Object objValue = this.get(FIELD_EXTABLENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="extablename")
    public void setExTableName(String exTableName) {
        this.set(FIELD_EXTABLENAME, exTableName);
    }

    @JsonIgnore
    public boolean isExTableNameDirty() {
        return this.contains(FIELD_EXTABLENAME);
    }

    @JsonIgnore
    public String getIndexDEType() {
        Object objValue = this.get(FIELD_INDEXDETYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="indexdetype")
    public void setIndexDEType(String indexDEType) {
        this.set(FIELD_INDEXDETYPE, indexDEType);
    }

    @JsonIgnore
    public boolean isIndexDETypeDirty() {
        return this.contains(FIELD_INDEXDETYPE);
    }

    @JsonIgnore
    public String getKeyRule() {
        Object objValue = this.get(FIELD_KEYRULE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="keyrule")
    public void setKeyRule(String keyRule) {
        this.set(FIELD_KEYRULE, keyRule);
    }

    @JsonIgnore
    public boolean isKeyRuleDirty() {
        return this.contains(FIELD_KEYRULE);
    }

    @JsonIgnore
    public String getLNPSLanResId() {
        Object objValue = this.get(FIELD_LNPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="lnpslanresid")
    public void setLNPSLanResId(String lNPSLanResId) {
        this.set(FIELD_LNPSLANRESID, lNPSLanResId);
    }

    @JsonIgnore
    public boolean isLNPSLanResIdDirty() {
        return this.contains(FIELD_LNPSLANRESID);
    }

    @JsonIgnore
    public String getLNPSLanResName() {
        Object objValue = this.get(FIELD_LNPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="lnpslanresname")
    public void setLNPSLanResName(String lNPSLanResName) {
        this.set(FIELD_LNPSLANRESNAME, lNPSLanResName);
    }

    @JsonIgnore
    public boolean isLNPSLanResNameDirty() {
        return this.contains(FIELD_LNPSLANRESNAME);
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
    public String getLogicInvalidValue() {
        Object objValue = this.get(FIELD_LOGICINVALIDVALUE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="logicinvalidvalue")
    public void setLogicInvalidValue(String logicInvalidValue) {
        this.set(FIELD_LOGICINVALIDVALUE, logicInvalidValue);
    }

    @JsonIgnore
    public boolean isLogicInvalidValueDirty() {
        return this.contains(FIELD_LOGICINVALIDVALUE);
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
    public Integer getLogicValid() {
        Object objValue = this.get(FIELD_LOGICVALID);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="logicvalid")
    public void setLogicValid(Integer logicValid) {
        this.set(FIELD_LOGICVALID, logicValid);
    }

    @JsonIgnore
    public boolean isLogicValidDirty() {
        return this.contains(FIELD_LOGICVALID);
    }

    @JsonIgnore
    public String getLogicValidValue() {
        Object objValue = this.get(FIELD_LOGICVALIDVALUE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="logicvalidvalue")
    public void setLogicValidValue(String logicValidValue) {
        this.set(FIELD_LOGICVALIDVALUE, logicValidValue);
    }

    @JsonIgnore
    public boolean isLogicValidValueDirty() {
        return this.contains(FIELD_LOGICVALIDVALUE);
    }

    @JsonIgnore
    public Integer getMaxEntityCacheCnt() {
        Object objValue = this.get(FIELD_MAXENTITYCACHECNT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="maxentitycachecnt")
    public void setMaxEntityCacheCnt(Integer maxEntityCacheCnt) {
        this.set(FIELD_MAXENTITYCACHECNT, maxEntityCacheCnt);
    }

    @JsonIgnore
    public boolean isMaxEntityCacheCntDirty() {
        return this.contains(FIELD_MAXENTITYCACHECNT);
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
    public String getModColor() {
        Object objValue = this.get(FIELD_MODCOLOR);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="modcolor")
    public void setModColor(String modColor) {
        this.set(FIELD_MODCOLOR, modColor);
    }

    @JsonIgnore
    public boolean isModColorDirty() {
        return this.contains(FIELD_MODCOLOR);
    }

    @JsonIgnore
    public Integer getModelImpExpFlag() {
        Object objValue = this.get(FIELD_MODELIMPEXPFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="modelimpexpflag")
    public void setModelImpExpFlag(Integer modelImpExpFlag) {
        this.set(FIELD_MODELIMPEXPFLAG, modelImpExpFlag);
    }

    @JsonIgnore
    public boolean isModelImpExpFlagDirty() {
        return this.contains(FIELD_MODELIMPEXPFLAG);
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
    public Integer getMSActionLogicFlag() {
        Object objValue = this.get(FIELD_MSACTIONLOGICFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="msactionlogicflag")
    public void setMSActionLogicFlag(Integer mSActionLogicFlag) {
        this.set(FIELD_MSACTIONLOGICFLAG, mSActionLogicFlag);
    }

    @JsonIgnore
    public boolean isMSActionLogicFlagDirty() {
        return this.contains(FIELD_MSACTIONLOGICFLAG);
    }

    @JsonIgnore
    public Integer getNoViewMode() {
        Object objValue = this.get(FIELD_NOVIEWMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="noviewmode")
    public void setNoViewMode(Integer noViewMode) {
        this.set(FIELD_NOVIEWMODE, noViewMode);
    }

    @JsonIgnore
    public boolean isNoViewModeDirty() {
        return this.contains(FIELD_NOVIEWMODE);
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
    public String getPSDataEntityId() {
        Object objValue = this.get(FIELD_PSDATAENTITYID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdataentityid")
    public void setPSDataEntityId(String pSDataEntityId) {
        this.set(FIELD_PSDATAENTITYID, pSDataEntityId);
    }

    @JsonIgnore
    public boolean isPSDataEntityIdDirty() {
        return this.contains(FIELD_PSDATAENTITYID);
    }

    @JsonIgnore
    public String getPSDataEntityName() {
        Object objValue = this.get(FIELD_PSDATAENTITYNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdataentityname")
    public void setPSDataEntityName(String pSDataEntityName) {
        this.set(FIELD_PSDATAENTITYNAME, pSDataEntityName);
    }

    @JsonIgnore
    public boolean isPSDataEntityNameDirty() {
        return this.contains(FIELD_PSDATAENTITYNAME);
    }

    @JsonIgnore
    public String getPSDEFInputTipSetId() {
        Object objValue = this.get(FIELD_PSDEFINPUTTIPSETID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefinputtipsetid")
    public void setPSDEFInputTipSetId(String pSDEFInputTipSetId) {
        this.set(FIELD_PSDEFINPUTTIPSETID, pSDEFInputTipSetId);
    }

    @JsonIgnore
    public boolean isPSDEFInputTipSetIdDirty() {
        return this.contains(FIELD_PSDEFINPUTTIPSETID);
    }

    @JsonIgnore
    public String getPSDEFInputTipSetName() {
        Object objValue = this.get(FIELD_PSDEFINPUTTIPSETNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefinputtipsetname")
    public void setPSDEFInputTipSetName(String pSDEFInputTipSetName) {
        this.set(FIELD_PSDEFINPUTTIPSETNAME, pSDEFInputTipSetName);
    }

    @JsonIgnore
    public boolean isPSDEFInputTipSetNameDirty() {
        return this.contains(FIELD_PSDEFINPUTTIPSETNAME);
    }

    @JsonIgnore
    public String getPSDynaDETemplId() {
        Object objValue = this.get(FIELD_PSDYNADETEMPLID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdynadetemplid")
    public void setPSDynaDETemplId(String pSDynaDETemplId) {
        this.set(FIELD_PSDYNADETEMPLID, pSDynaDETemplId);
    }

    @JsonIgnore
    public boolean isPSDynaDETemplIdDirty() {
        return this.contains(FIELD_PSDYNADETEMPLID);
    }

    @JsonIgnore
    public String getPSDynaDETemplName() {
        Object objValue = this.get(FIELD_PSDYNADETEMPLNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdynadetemplname")
    public void setPSDynaDETemplName(String pSDynaDETemplName) {
        this.set(FIELD_PSDYNADETEMPLNAME, pSDynaDETemplName);
    }

    @JsonIgnore
    public boolean isPSDynaDETemplNameDirty() {
        return this.contains(FIELD_PSDYNADETEMPLNAME);
    }

    @JsonIgnore
    public String getPSHelpModuleId() {
        Object objValue = this.get(FIELD_PSHELPMODULEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pshelpmoduleid")
    public void setPSHelpModuleId(String pSHelpModuleId) {
        this.set(FIELD_PSHELPMODULEID, pSHelpModuleId);
    }

    @JsonIgnore
    public boolean isPSHelpModuleIdDirty() {
        return this.contains(FIELD_PSHELPMODULEID);
    }

    @JsonIgnore
    public String getPSHelpModuleName() {
        Object objValue = this.get(FIELD_PSHELPMODULENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pshelpmodulename")
    public void setPSHelpModuleName(String pSHelpModuleName) {
        this.set(FIELD_PSHELPMODULENAME, pSHelpModuleName);
    }

    @JsonIgnore
    public boolean isPSHelpModuleNameDirty() {
        return this.contains(FIELD_PSHELPMODULENAME);
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
    public String getPSSubSysSADEId() {
        Object objValue = this.get(FIELD_PSSUBSYSSADEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssubsyssadeid")
    public void setPSSubSysSADEId(String pSSubSysSADEId) {
        this.set(FIELD_PSSUBSYSSADEID, pSSubSysSADEId);
    }

    @JsonIgnore
    public boolean isPSSubSysSADEIdDirty() {
        return this.contains(FIELD_PSSUBSYSSADEID);
    }

    @JsonIgnore
    public String getPSSubSysSADEName() {
        Object objValue = this.get(FIELD_PSSUBSYSSADENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssubsyssadename")
    public void setPSSubSysSADEName(String pSSubSysSADEName) {
        this.set(FIELD_PSSUBSYSSADENAME, pSSubSysSADEName);
    }

    @JsonIgnore
    public boolean isPSSubSysSADENameDirty() {
        return this.contains(FIELD_PSSUBSYSSADENAME);
    }

    @JsonIgnore
    public String getPSSubSysServiceAPIId() {
        Object objValue = this.get(FIELD_PSSUBSYSSERVICEAPIID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssubsysserviceapiid")
    public void setPSSubSysServiceAPIId(String pSSubSysServiceAPIId) {
        this.set(FIELD_PSSUBSYSSERVICEAPIID, pSSubSysServiceAPIId);
    }

    @JsonIgnore
    public boolean isPSSubSysServiceAPIIdDirty() {
        return this.contains(FIELD_PSSUBSYSSERVICEAPIID);
    }

    @JsonIgnore
    public String getPSSubSysServiceAPIName() {
        Object objValue = this.get(FIELD_PSSUBSYSSERVICEAPINAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssubsysserviceapiname")
    public void setPSSubSysServiceAPIName(String pSSubSysServiceAPIName) {
        this.set(FIELD_PSSUBSYSSERVICEAPINAME, pSSubSysServiceAPIName);
    }

    @JsonIgnore
    public boolean isPSSubSysServiceAPINameDirty() {
        return this.contains(FIELD_PSSUBSYSSERVICEAPINAME);
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
    public String getPSSysModelGroupId() {
        Object objValue = this.get(FIELD_PSSYSMODELGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysmodelgroupid")
    public void setPSSysModelGroupId(String pSSysModelGroupId) {
        this.set(FIELD_PSSYSMODELGROUPID, pSSysModelGroupId);
    }

    @JsonIgnore
    public boolean isPSSysModelGroupIdDirty() {
        return this.contains(FIELD_PSSYSMODELGROUPID);
    }

    @JsonIgnore
    public String getPSSysModelGroupName() {
        Object objValue = this.get(FIELD_PSSYSMODELGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysmodelgroupname")
    public void setPSSysModelGroupName(String pSSysModelGroupName) {
        this.set(FIELD_PSSYSMODELGROUPNAME, pSSysModelGroupName);
    }

    @JsonIgnore
    public boolean isPSSysModelGroupNameDirty() {
        return this.contains(FIELD_PSSYSMODELGROUPNAME);
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
    public String getPSSysSFPluginId() {
        Object objValue = this.get(FIELD_PSSYSSFPLUGINID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssfpluginid")
    public void setPSSysSFPluginId(String pSSysSFPluginId) {
        this.set(FIELD_PSSYSSFPLUGINID, pSSysSFPluginId);
    }

    @JsonIgnore
    public boolean isPSSysSFPluginIdDirty() {
        return this.contains(FIELD_PSSYSSFPLUGINID);
    }

    @JsonIgnore
    public String getPSSysSFPluginName() {
        Object objValue = this.get(FIELD_PSSYSSFPLUGINNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssfpluginname")
    public void setPSSysSFPluginName(String pSSysSFPluginName) {
        this.set(FIELD_PSSYSSFPLUGINNAME, pSSysSFPluginName);
    }

    @JsonIgnore
    public boolean isPSSysSFPluginNameDirty() {
        return this.contains(FIELD_PSSYSSFPLUGINNAME);
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
    public Integer getRemoveFlag() {
        Object objValue = this.get(FIELD_REMOVEFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="removeflag")
    public void setRemoveFlag(Integer removeFlag) {
        this.set(FIELD_REMOVEFLAG, removeFlag);
    }

    @JsonIgnore
    public boolean isRemoveFlagDirty() {
        return this.contains(FIELD_REMOVEFLAG);
    }

    @JsonIgnore
    public Integer getSaaSMode() {
        Object objValue = this.get(FIELD_SAASMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="saasmode")
    public void setSaaSMode(Integer saaSMode) {
        this.set(FIELD_SAASMODE, saaSMode);
    }

    @JsonIgnore
    public boolean isSaaSModeDirty() {
        return this.contains(FIELD_SAASMODE);
    }

    @JsonIgnore
    public Integer getServiceAPIFlag() {
        Object objValue = this.get(FIELD_SERVICEAPIFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="serviceapiflag")
    public void setServiceAPIFlag(Integer serviceAPIFlag) {
        this.set(FIELD_SERVICEAPIFLAG, serviceAPIFlag);
    }

    @JsonIgnore
    public boolean isServiceAPIFlagDirty() {
        return this.contains(FIELD_SERVICEAPIFLAG);
    }

    @JsonIgnore
    public String getServiceCodeName() {
        Object objValue = this.get(FIELD_SERVICECODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="servicecodename")
    public void setServiceCodeName(String serviceCodeName) {
        this.set(FIELD_SERVICECODENAME, serviceCodeName);
    }

    @JsonIgnore
    public boolean isServiceCodeNameDirty() {
        return this.contains(FIELD_SERVICECODENAME);
    }

    @JsonIgnore
    public Integer getStorageMode() {
        Object objValue = this.get(FIELD_STORAGEMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="storagemode")
    public void setStorageMode(Integer storageMode) {
        this.set(FIELD_STORAGEMODE, storageMode);
    }

    @JsonIgnore
    public boolean isStorageModeDirty() {
        return this.contains(FIELD_STORAGEMODE);
    }

    @JsonIgnore
    public Integer getSubSysModule() {
        Object objValue = this.get(FIELD_SUBSYSMODULE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="subsysmodule")
    public void setSubSysModule(Integer subSysModule) {
        this.set(FIELD_SUBSYSMODULE, subSysModule);
    }

    @JsonIgnore
    public boolean isSubSysModuleDirty() {
        return this.contains(FIELD_SUBSYSMODULE);
    }

    @JsonIgnore
    public Integer getSystemFlag() {
        Object objValue = this.get(FIELD_SYSTEMFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="systemflag")
    public void setSystemFlag(Integer systemFlag) {
        this.set(FIELD_SYSTEMFLAG, systemFlag);
    }

    @JsonIgnore
    public boolean isSystemFlagDirty() {
        return this.contains(FIELD_SYSTEMFLAG);
    }

    @JsonIgnore
    public String getTableName() {
        Object objValue = this.get(FIELD_TABLENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="tablename")
    public void setTableName(String tableName) {
        this.set(FIELD_TABLENAME, tableName);
    }

    @JsonIgnore
    public boolean isTableNameDirty() {
        return this.contains(FIELD_TABLENAME);
    }

    @JsonIgnore
    public Integer getTestCaseFlag() {
        Object objValue = this.get(FIELD_TESTCASEFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="testcaseflag")
    public void setTestCaseFlag(Integer testCaseFlag) {
        this.set(FIELD_TESTCASEFLAG, testCaseFlag);
    }

    @JsonIgnore
    public boolean isTestCaseFlagDirty() {
        return this.contains(FIELD_TESTCASEFLAG);
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
    public Integer getUserAction() {
        Object objValue = this.get(FIELD_USERACTION);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="useraction")
    public void setUserAction(Integer userAction) {
        this.set(FIELD_USERACTION, userAction);
    }

    @JsonIgnore
    public boolean isUserActionDirty() {
        return this.contains(FIELD_USERACTION);
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
    public Integer getViewLevel() {
        Object objValue = this.get(FIELD_VIEWLEVEL);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="viewlevel")
    public void setViewLevel(Integer viewLevel) {
        this.set(FIELD_VIEWLEVEL, viewLevel);
    }

    @JsonIgnore
    public boolean isViewLevelDirty() {
        return this.contains(FIELD_VIEWLEVEL);
    }

    @JsonIgnore
    public String getViewName() {
        Object objValue = this.get(FIELD_VIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="viewname")
    public void setViewName(String viewName) {
        this.set(FIELD_VIEWNAME, viewName);
    }

    @JsonIgnore
    public boolean isViewNameDirty() {
        return this.contains(FIELD_VIEWNAME);
    }

    @JsonIgnore
    public String getViewName2() {
        Object objValue = this.get(FIELD_VIEWNAME2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="viewname2")
    public void setViewName2(String viewName2) {
        this.set(FIELD_VIEWNAME2, viewName2);
    }

    @JsonIgnore
    public boolean isViewName2Dirty() {
        return this.contains(FIELD_VIEWNAME2);
    }

    @JsonIgnore
    public String getViewName3() {
        Object objValue = this.get(FIELD_VIEWNAME3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="viewname3")
    public void setViewName3(String viewName3) {
        this.set(FIELD_VIEWNAME3, viewName3);
    }

    @JsonIgnore
    public boolean isViewName3Dirty() {
        return this.contains(FIELD_VIEWNAME3);
    }

    @JsonIgnore
    public String getViewName4() {
        Object objValue = this.get(FIELD_VIEWNAME4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="viewname4")
    public void setViewName4(String viewName4) {
        this.set(FIELD_VIEWNAME4, viewName4);
    }

    @JsonIgnore
    public boolean isViewName4Dirty() {
        return this.contains(FIELD_VIEWNAME4);
    }

    @JsonIgnore
    public Integer getVirtualFlag() {
        Object objValue = this.get(FIELD_VIRTUALFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="virtualflag")
    public void setVirtualFlag(Integer virtualFlag) {
        this.set(FIELD_VIRTUALFLAG, virtualFlag);
    }

    @JsonIgnore
    public boolean isVirtualFlagDirty() {
        return this.contains(FIELD_VIRTUALFLAG);
    }

    @JsonIgnore
    public String getVKeySeparator() {
        Object objValue = this.get(FIELD_VKEYSEPARATOR);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="vkeyseparator")
    public void setVKeySeparator(String vKeySeparator) {
        this.set(FIELD_VKEYSEPARATOR, vKeySeparator);
    }

    @JsonIgnore
    public boolean isVKeySeparatorDirty() {
        return this.contains(FIELD_VKEYSEPARATOR);
    }

    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDataEntityId();
    }

    public void setSrfkey(String strValue) {
        this.setPSDataEntityId(strValue);
    }

    public List<PSSysTestCase> getPssystestcases() {
        return this.pssystestcases;
    }

    public void setPssystestcases(List<PSSysTestCase> pssystestcases) {
        this.pssystestcases = pssystestcases;
    }

    public List<PSACHandler> getPsachandlers() {
        return this.psachandlers;
    }

    public void setPsachandlers(List<PSACHandler> psachandlers) {
        this.psachandlers = psachandlers;
    }

    public List<PSCtrlLogicGroup> getPsctrllogicgroups() {
        return this.psctrllogicgroups;
    }

    public void setPsctrllogicgroups(List<PSCtrlLogicGroup> psctrllogicgroups) {
        this.psctrllogicgroups = psctrllogicgroups;
    }

    public List<PSCtrlMsg> getPsctrlmsgs() {
        return this.psctrlmsgs;
    }

    public void setPsctrlmsgs(List<PSCtrlMsg> psctrlmsgs) {
        this.psctrlmsgs = psctrlmsgs;
    }

    public List<PSDEAction> getPsdeactions() {
        return this.psdeactions;
    }

    public void setPsdeactions(List<PSDEAction> psdeactions) {
        this.psdeactions = psdeactions;
    }

    public List<PSDEDataExp> getPsdedataexps() {
        return this.psdedataexps;
    }

    public void setPsdedataexps(List<PSDEDataExp> psdedataexps) {
        this.psdedataexps = psdedataexps;
    }

    public List<PSDEDataImp> getPsdedataimps() {
        return this.psdedataimps;
    }

    public void setPsdedataimps(List<PSDEDataImp> psdedataimps) {
        this.psdedataimps = psdedataimps;
    }

    public List<PSDEDataQuery> getPsdedataqueries() {
        return this.psdedataqueries;
    }

    public void setPsdedataqueries(List<PSDEDataQuery> psdedataqueries) {
        this.psdedataqueries = psdedataqueries;
    }

    public List<PSDEDataRelation> getPsdedatarelations() {
        return this.psdedatarelations;
    }

    public void setPsdedatarelations(List<PSDEDataRelation> psdedatarelations) {
        this.psdedatarelations = psdedatarelations;
    }

    public List<PSDEDataSet> getPsdedatasets() {
        return this.psdedatasets;
    }

    public void setPsdedatasets(List<PSDEDataSet> psdedatasets) {
        this.psdedatasets = psdedatasets;
    }

    public List<PSDEDBIndex> getPsdedbindices() {
        return this.psdedbindices;
    }

    public void setPsdedbindices(List<PSDEDBIndex> psdedbindices) {
        this.psdedbindices = psdedbindices;
    }

    public List<PSDEDRItem> getPsdedritems() {
        return this.psdedritems;
    }

    public void setPsdedritems(List<PSDEDRItem> psdedritems) {
        this.psdedritems = psdedritems;
    }

    public List<PSDEGroup> getPsdegroups() {
        return this.psdegroups;
    }

    public void setPsdegroups(List<PSDEGroup> psdegroups) {
        this.psdegroups = psdegroups;
    }

    public List<PSDELogic> getPsdelogics() {
        return this.psdelogics;
    }

    public void setPsdelogics(List<PSDELogic> psdelogics) {
        this.psdelogics = psdelogics;
    }

    public List<PSDEPrint> getPsdeprints() {
        return this.psdeprints;
    }

    public void setPsdeprints(List<PSDEPrint> psdeprints) {
        this.psdeprints = psdeprints;
    }

    public List<PSDERGroup> getPsdergroups() {
        return this.psdergroups;
    }

    public void setPsdergroups(List<PSDERGroup> psdergroups) {
        this.psdergroups = psdergroups;
    }

    public List<PSDEToolbar> getPsdetoolbars() {
        return this.psdetoolbars;
    }

    public void setPsdetoolbars(List<PSDEToolbar> psdetoolbars) {
        this.psdetoolbars = psdetoolbars;
    }

    public List<PSDEUAGroup> getPsdeuagroups() {
        return this.psdeuagroups;
    }

    public void setPsdeuagroups(List<PSDEUAGroup> psdeuagroups) {
        this.psdeuagroups = psdeuagroups;
    }

    public List<PSDEUIAction> getPsdeuiactions() {
        return this.psdeuiactions;
    }

    public void setPsdeuiactions(List<PSDEUIAction> psdeuiactions) {
        this.psdeuiactions = psdeuiactions;
    }

    public List<PSDEVRGroup> getPsdevrgroups() {
        return this.psdevrgroups;
    }

    public void setPsdevrgroups(List<PSDEVRGroup> psdevrgroups) {
        this.psdevrgroups = psdevrgroups;
    }

    public List<PSSysCalendar> getPssyscalendars() {
        return this.pssyscalendars;
    }

    public void setPssyscalendars(List<PSSysCalendar> pssyscalendars) {
        this.pssyscalendars = pssyscalendars;
    }

    public List<PSSysCounter> getPssyscounters() {
        return this.pssyscounters;
    }

    public void setPssyscounters(List<PSSysCounter> pssyscounters) {
        this.pssyscounters = pssyscounters;
    }

    public List<PSSysDashboard> getPssysdashboards() {
        return this.pssysdashboards;
    }

    public void setPssysdashboards(List<PSSysDashboard> pssysdashboards) {
        this.pssysdashboards = pssysdashboards;
    }

    public List<PSSysMapView> getPssysmapviews() {
        return this.pssysmapviews;
    }

    public void setPssysmapviews(List<PSSysMapView> pssysmapviews) {
        this.pssysmapviews = pssysmapviews;
    }

    public List<PSSysPortlet> getPssysportlets() {
        return this.pssysportlets;
    }

    public void setPssysportlets(List<PSSysPortlet> pssysportlets) {
        this.pssysportlets = pssysportlets;
    }

    public List<PSSysSearchBar> getPssyssearchbars() {
        return this.pssyssearchbars;
    }

    public void setPssyssearchbars(List<PSSysSearchBar> pssyssearchbars) {
        this.pssyssearchbars = pssyssearchbars;
    }

    public List<PSSysViewPanel> getPssysviewpanels() {
        return this.pssysviewpanels;
    }

    public void setPssysviewpanels(List<PSSysViewPanel> pssysviewpanels) {
        this.pssysviewpanels = pssysviewpanels;
    }

    public List<PSDEACMode> getPsdeacmodes() {
        return this.psdeacmodes;
    }

    public void setPsdeacmodes(List<PSDEACMode> psdeacmodes) {
        this.psdeacmodes = psdeacmodes;
    }

    public List<PSDEDataSync> getPsdedatasyncs() {
        return this.psdedatasyncs;
    }

    public void setPsdedatasyncs(List<PSDEDataSync> psdedatasyncs) {
        this.psdedatasyncs = psdedatasyncs;
    }

    public List<PSDEList> getPsdelists() {
        return this.psdelists;
    }

    public void setPsdelists(List<PSDEList> psdelists) {
        this.psdelists = psdelists;
    }

    public List<PSDEMainState> getPsdemainstates() {
        return this.psdemainstates;
    }

    public void setPsdemainstates(List<PSDEMainState> psdemainstates) {
        this.psdemainstates = psdemainstates;
    }

    public List<PSDEMap> getPsdemaps() {
        return this.psdemaps;
    }

    public void setPsdemaps(List<PSDEMap> psdemaps) {
        this.psdemaps = psdemaps;
    }

    public List<PSDENotify> getPsdenotifies() {
        return this.psdenotifies;
    }

    public void setPsdenotifies(List<PSDENotify> psdenotifies) {
        this.psdenotifies = psdenotifies;
    }

    public List<PSDER> getPsders() {
        return this.psders;
    }

    public void setPsders(List<PSDER> psders) {
        this.psders = psders;
    }

    public List<PSDETreeView> getPsdetreeviews() {
        return this.psdetreeviews;
    }

    public void setPsdetreeviews(List<PSDETreeView> psdetreeviews) {
        this.psdetreeviews = psdetreeviews;
    }

    public List<PSSysTestData> getPssystestdata() {
        return this.pssystestdata;
    }

    public void setPssystestdata(List<PSSysTestData> pssystestdata) {
        this.pssystestdata = pssystestdata;
    }

    public List<PSDEActionGroup> getPsdeactiongroups() {
        return this.psdeactiongroups;
    }

    public void setPsdeactiongroups(List<PSDEActionGroup> psdeactiongroups) {
        this.psdeactiongroups = psdeactiongroups;
    }

    public List<PSDEActionLogic> getPsdeactionlogics() {
        return this.psdeactionlogics;
    }

    public void setPsdeactionlogics(List<PSDEActionLogic> psdeactionlogics) {
        this.psdeactionlogics = psdeactionlogics;
    }

    public List<PSDEChart> getPsdecharts() {
        return this.psdecharts;
    }

    public void setPsdecharts(List<PSDEChart> psdecharts) {
        this.psdecharts = psdecharts;
    }

    public List<PSDEDataView> getPsdedataviews() {
        return this.psdedataviews;
    }

    public void setPsdedataviews(List<PSDEDataView> psdedataviews) {
        this.psdedataviews = psdedataviews;
    }

    public List<PSDEDTSQueue> getPsdedtsqueues() {
        return this.psdedtsqueues;
    }

    public void setPsdedtsqueues(List<PSDEDTSQueue> psdedtsqueues) {
        this.psdedtsqueues = psdedtsqueues;
    }

    public List<PSDEForm> getPsdeforms() {
        return this.psdeforms;
    }

    public void setPsdeforms(List<PSDEForm> psdeforms) {
        this.psdeforms = psdeforms;
    }

    public List<PSDEFValueRule> getPsdefvaluerules() {
        return this.psdefvaluerules;
    }

    public void setPsdefvaluerules(List<PSDEFValueRule> psdefvaluerules) {
        this.psdefvaluerules = psdefvaluerules;
    }

    public List<PSDEGrid> getPsdegrids() {
        return this.psdegrids;
    }

    public void setPsdegrids(List<PSDEGrid> psdegrids) {
        this.psdegrids = psdegrids;
    }

    public List<PSDEReport> getPsdereports() {
        return this.psdereports;
    }

    public void setPsdereports(List<PSDEReport> psdereports) {
        this.psdereports = psdereports;
    }

    public List<PSDESampleData> getPsdesampledata() {
        return this.psdesampledata;
    }

    public void setPsdesampledata(List<PSDESampleData> psdesampledata) {
        this.psdesampledata = psdesampledata;
    }

    public List<PSDEViewBase> getPsdeviewbases() {
        return this.psdeviewbases;
    }

    public void setPsdeviewbases(List<PSDEViewBase> psdeviewbases) {
        this.psdeviewbases = psdeviewbases;
    }

    public List<PSDEWizard> getPsdewizards() {
        return this.psdewizards;
    }

    public void setPsdewizards(List<PSDEWizard> psdewizards) {
        this.psdewizards = psdewizards;
    }

    public List<PSDEDBCfg> getPsdedbcfgs() {
        return this.psdedbcfgs;
    }

    public void setPsdedbcfgs(List<PSDEDBCfg> psdedbcfgs) {
        this.psdedbcfgs = psdedbcfgs;
    }

    public List<PSDEDRGroup> getPsdedrgroups() {
        return this.psdedrgroups;
    }

    public void setPsdedrgroups(List<PSDEDRGroup> psdedrgroups) {
        this.psdedrgroups = psdedrgroups;
    }

    public List<PSDEField> getPsdefields() {
        return this.psdefields;
    }

    public void setPsdefields(List<PSDEField> psdefields) {
        this.psdefields = psdefields;
    }

    public List<PSDEOPPriv> getPsdeopprivs() {
        return this.psdeopprivs;
    }

    public void setPsdeopprivs(List<PSDEOPPriv> psdeopprivs) {
        this.psdeopprivs = psdeopprivs;
    }

    public List<PSDETable> getPsdetables() {
        return this.psdetables;
    }

    public void setPsdetables(List<PSDETable> psdetables) {
        this.psdetables = psdetables;
    }

    public List<PSDEUserRole> getPsdeuserroles() {
        return this.psdeuserroles;
    }

    public void setPsdeuserroles(List<PSDEUserRole> psdeuserroles) {
        this.psdeuserroles = psdeuserroles;
    }

    public List<PSSysDMItem> getPssysdmitems() {
        return this.pssysdmitems;
    }

    public void setPssysdmitems(List<PSSysDMItem> pssysdmitems) {
        this.pssysdmitems = pssysdmitems;
    }

    public List<PSDEOPPrivRole> getPsdeopprivroles() {
        return this.psdeopprivroles;
    }

    public void setPsdeopprivroles(List<PSDEOPPrivRole> psdeopprivroles) {
        this.psdeopprivroles = psdeopprivroles;
    }

    public List<PSDEUtilDE> getPsdeutildes() {
        return this.psdeutildes;
    }

    public void setPsdeutildes(List<PSDEUtilDE> psdeutildes) {
        this.psdeutildes = psdeutildes;
    }

    public List<PSDEFGroup> getPsdefgroups() {
        return this.psdefgroups;
    }

    public void setPsdefgroups(List<PSDEFGroup> psdefgroups) {
        this.psdefgroups = psdefgroups;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (bFullMode && strName.equalsIgnoreCase("pssystestcases")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psachandlers")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psctrllogicgroups")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psctrlmsgs")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdeactions")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdedataexps")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdedataimps")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdedataqueries")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdedatarelations")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdedatasets")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdedbindices")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdedritems")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdegroups")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdelogics")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdeprints")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdergroups")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdetoolbars")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdeuagroups")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdeuiactions")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdevrgroups")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssyscalendars")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssyscounters")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysdashboards")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysmapviews")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysportlets")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssyssearchbars")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysviewpanels")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdeacmodes")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdedatasyncs")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdelists")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdemainstates")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdemaps")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdenotifies")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psders")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdetreeviews")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssystestdata")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdeactiongroups")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdeactionlogics")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdecharts")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdedataviews")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdedtsqueues")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdeforms")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdefvaluerules")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdegrids")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdereports")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdesampledata")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdeviewbases")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdewizards")) {
            return true;
        }
        if (strName.equalsIgnoreCase("psdedbcfgs")) {
            return true;
        }
        if (strName.equalsIgnoreCase("psdedrgroups")) {
            return true;
        }
        if (strName.equalsIgnoreCase("psdefields")) {
            return true;
        }
        if (strName.equalsIgnoreCase("psdeopprivs")) {
            return true;
        }
        if (strName.equalsIgnoreCase("psdetables")) {
            return true;
        }
        if (strName.equalsIgnoreCase("psdeuserroles")) {
            return true;
        }
        if (strName.equalsIgnoreCase("pssysdmitems")) {
            return true;
        }
        if (strName.equalsIgnoreCase("psdeopprivroles")) {
            return true;
        }
        if (strName.equalsIgnoreCase("psdeutildes")) {
            return true;
        }
        if (strName.equalsIgnoreCase("psdefgroups")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("pssystestcases")) {
            this.init();
            return this.pssystestcases;
        }
        if (strName.equalsIgnoreCase("psachandlers")) {
            this.init();
            return this.psachandlers;
        }
        if (strName.equalsIgnoreCase("psctrllogicgroups")) {
            this.init();
            return this.psctrllogicgroups;
        }
        if (strName.equalsIgnoreCase("psctrlmsgs")) {
            this.init();
            return this.psctrlmsgs;
        }
        if (strName.equalsIgnoreCase("psdeactions")) {
            this.init();
            return this.psdeactions;
        }
        if (strName.equalsIgnoreCase("psdedataexps")) {
            this.init();
            return this.psdedataexps;
        }
        if (strName.equalsIgnoreCase("psdedataimps")) {
            this.init();
            return this.psdedataimps;
        }
        if (strName.equalsIgnoreCase("psdedataqueries")) {
            this.init();
            return this.psdedataqueries;
        }
        if (strName.equalsIgnoreCase("psdedatarelations")) {
            this.init();
            return this.psdedatarelations;
        }
        if (strName.equalsIgnoreCase("psdedatasets")) {
            this.init();
            return this.psdedatasets;
        }
        if (strName.equalsIgnoreCase("psdedbindices")) {
            this.init();
            return this.psdedbindices;
        }
        if (strName.equalsIgnoreCase("psdedritems")) {
            this.init();
            return this.psdedritems;
        }
        if (strName.equalsIgnoreCase("psdegroups")) {
            this.init();
            return this.psdegroups;
        }
        if (strName.equalsIgnoreCase("psdelogics")) {
            this.init();
            return this.psdelogics;
        }
        if (strName.equalsIgnoreCase("psdeprints")) {
            this.init();
            return this.psdeprints;
        }
        if (strName.equalsIgnoreCase("psdergroups")) {
            this.init();
            return this.psdergroups;
        }
        if (strName.equalsIgnoreCase("psdetoolbars")) {
            this.init();
            return this.psdetoolbars;
        }
        if (strName.equalsIgnoreCase("psdeuagroups")) {
            this.init();
            return this.psdeuagroups;
        }
        if (strName.equalsIgnoreCase("psdeuiactions")) {
            this.init();
            return this.psdeuiactions;
        }
        if (strName.equalsIgnoreCase("psdevrgroups")) {
            this.init();
            return this.psdevrgroups;
        }
        if (strName.equalsIgnoreCase("pssyscalendars")) {
            this.init();
            return this.pssyscalendars;
        }
        if (strName.equalsIgnoreCase("pssyscounters")) {
            this.init();
            return this.pssyscounters;
        }
        if (strName.equalsIgnoreCase("pssysdashboards")) {
            this.init();
            return this.pssysdashboards;
        }
        if (strName.equalsIgnoreCase("pssysmapviews")) {
            this.init();
            return this.pssysmapviews;
        }
        if (strName.equalsIgnoreCase("pssysportlets")) {
            this.init();
            return this.pssysportlets;
        }
        if (strName.equalsIgnoreCase("pssyssearchbars")) {
            this.init();
            return this.pssyssearchbars;
        }
        if (strName.equalsIgnoreCase("pssysviewpanels")) {
            this.init();
            return this.pssysviewpanels;
        }
        if (strName.equalsIgnoreCase("psdeacmodes")) {
            this.init();
            return this.psdeacmodes;
        }
        if (strName.equalsIgnoreCase("psdedatasyncs")) {
            this.init();
            return this.psdedatasyncs;
        }
        if (strName.equalsIgnoreCase("psdelists")) {
            this.init();
            return this.psdelists;
        }
        if (strName.equalsIgnoreCase("psdemainstates")) {
            this.init();
            return this.psdemainstates;
        }
        if (strName.equalsIgnoreCase("psdemaps")) {
            this.init();
            return this.psdemaps;
        }
        if (strName.equalsIgnoreCase("psdenotifies")) {
            this.init();
            return this.psdenotifies;
        }
        if (strName.equalsIgnoreCase("psders")) {
            this.init();
            return this.psders;
        }
        if (strName.equalsIgnoreCase("psdetreeviews")) {
            this.init();
            return this.psdetreeviews;
        }
        if (strName.equalsIgnoreCase("pssystestdata")) {
            this.init();
            return this.pssystestdata;
        }
        if (strName.equalsIgnoreCase("psdeactiongroups")) {
            this.init();
            return this.psdeactiongroups;
        }
        if (strName.equalsIgnoreCase("psdeactionlogics")) {
            this.init();
            return this.psdeactionlogics;
        }
        if (strName.equalsIgnoreCase("psdecharts")) {
            this.init();
            return this.psdecharts;
        }
        if (strName.equalsIgnoreCase("psdedataviews")) {
            this.init();
            return this.psdedataviews;
        }
        if (strName.equalsIgnoreCase("psdedtsqueues")) {
            this.init();
            return this.psdedtsqueues;
        }
        if (strName.equalsIgnoreCase("psdeforms")) {
            this.init();
            return this.psdeforms;
        }
        if (strName.equalsIgnoreCase("psdefvaluerules")) {
            this.init();
            return this.psdefvaluerules;
        }
        if (strName.equalsIgnoreCase("psdegrids")) {
            this.init();
            return this.psdegrids;
        }
        if (strName.equalsIgnoreCase("psdereports")) {
            this.init();
            return this.psdereports;
        }
        if (strName.equalsIgnoreCase("psdesampledata")) {
            this.init();
            return this.psdesampledata;
        }
        if (strName.equalsIgnoreCase("psdeviewbases")) {
            this.init();
            return this.psdeviewbases;
        }
        if (strName.equalsIgnoreCase("psdewizards")) {
            this.init();
            return this.psdewizards;
        }
        if (strName.equalsIgnoreCase("psdedbcfgs")) {
            this.init();
            return this.psdedbcfgs;
        }
        if (strName.equalsIgnoreCase("psdedrgroups")) {
            this.init();
            return this.psdedrgroups;
        }
        if (strName.equalsIgnoreCase("psdefields")) {
            this.init();
            return this.psdefields;
        }
        if (strName.equalsIgnoreCase("psdeopprivs")) {
            this.init();
            return this.psdeopprivs;
        }
        if (strName.equalsIgnoreCase("psdetables")) {
            this.init();
            return this.psdetables;
        }
        if (strName.equalsIgnoreCase("psdeuserroles")) {
            this.init();
            return this.psdeuserroles;
        }
        if (strName.equalsIgnoreCase("pssysdmitems")) {
            this.init();
            return this.pssysdmitems;
        }
        if (strName.equalsIgnoreCase("psdeopprivroles")) {
            this.init();
            return this.psdeopprivroles;
        }
        if (strName.equalsIgnoreCase("psdeutildes")) {
            this.init();
            return this.psdeutildes;
        }
        if (strName.equalsIgnoreCase("psdefgroups")) {
            this.init();
            return this.psdefgroups;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSDATAENTITY";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSDataEntity item = (PSDataEntity)MAPPER.readValue(new File(strJsonFilePath), PSDataEntity.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSDataEntity) {
            PSDataEntity dst = (PSDataEntity)target;
            if (!bSimple) {
                PSModelBase newitem;
                if (this.getPsdedbcfgs() != null) {
                    ArrayList<PSDEDBCfg> psdedbcfgs = new ArrayList<PSDEDBCfg>();
                    for (PSDEDBCfg pSDEDBCfg : this.getPsdedbcfgs()) {
                        if (bDeepMode) {
                            newitem = new PSDEDBCfg();
                            pSDEDBCfg.to(newitem, false, bDeepMode);
                            psdedbcfgs.add((PSDEDBCfg)newitem);
                            continue;
                        }
                        psdedbcfgs.add(pSDEDBCfg);
                    }
                    dst.setPsdedbcfgs(psdedbcfgs);
                }
                if (this.getPsdedrgroups() != null) {
                    ArrayList<PSDEDRGroup> psdedrgroups = new ArrayList<PSDEDRGroup>();
                    for (PSDEDRGroup pSDEDRGroup : this.getPsdedrgroups()) {
                        if (bDeepMode) {
                            newitem = new PSDEDRGroup();
                            pSDEDRGroup.to(newitem, false, bDeepMode);
                            psdedrgroups.add((PSDEDRGroup)newitem);
                            continue;
                        }
                        psdedrgroups.add(pSDEDRGroup);
                    }
                    dst.setPsdedrgroups(psdedrgroups);
                }
                if (this.getPsdefields() != null) {
                    ArrayList<PSDEField> psdefields = new ArrayList<PSDEField>();
                    for (PSDEField pSDEField : this.getPsdefields()) {
                        if (bDeepMode) {
                            newitem = new PSDEField();
                            pSDEField.to(newitem, false, bDeepMode);
                            psdefields.add((PSDEField)newitem);
                            continue;
                        }
                        psdefields.add(pSDEField);
                    }
                    dst.setPsdefields(psdefields);
                }
                if (this.getPsdeopprivs() != null) {
                    ArrayList<PSDEOPPriv> psdeopprivs = new ArrayList<PSDEOPPriv>();
                    for (PSDEOPPriv pSDEOPPriv : this.getPsdeopprivs()) {
                        if (bDeepMode) {
                            newitem = new PSDEOPPriv();
                            pSDEOPPriv.to(newitem, false, bDeepMode);
                            psdeopprivs.add((PSDEOPPriv)newitem);
                            continue;
                        }
                        psdeopprivs.add(pSDEOPPriv);
                    }
                    dst.setPsdeopprivs(psdeopprivs);
                }
                if (this.getPsdetables() != null) {
                    ArrayList<PSDETable> psdetables = new ArrayList<PSDETable>();
                    for (PSDETable pSDETable : this.getPsdetables()) {
                        if (bDeepMode) {
                            newitem = new PSDETable();
                            pSDETable.to(newitem, false, bDeepMode);
                            psdetables.add((PSDETable)newitem);
                            continue;
                        }
                        psdetables.add(pSDETable);
                    }
                    dst.setPsdetables(psdetables);
                }
                if (this.getPsdeuserroles() != null) {
                    ArrayList<PSDEUserRole> psdeuserroles = new ArrayList<PSDEUserRole>();
                    for (PSDEUserRole pSDEUserRole : this.getPsdeuserroles()) {
                        if (bDeepMode) {
                            newitem = new PSDEUserRole();
                            pSDEUserRole.to(newitem, false, bDeepMode);
                            psdeuserroles.add((PSDEUserRole)newitem);
                            continue;
                        }
                        psdeuserroles.add(pSDEUserRole);
                    }
                    dst.setPsdeuserroles(psdeuserroles);
                }
                if (this.getPssysdmitems() != null) {
                    ArrayList<PSSysDMItem> pssysdmitems = new ArrayList<PSSysDMItem>();
                    for (PSSysDMItem pSSysDMItem : this.getPssysdmitems()) {
                        if (bDeepMode) {
                            newitem = new PSSysDMItem();
                            pSSysDMItem.to(newitem, false, bDeepMode);
                            pssysdmitems.add((PSSysDMItem)newitem);
                            continue;
                        }
                        pssysdmitems.add(pSSysDMItem);
                    }
                    dst.setPssysdmitems(pssysdmitems);
                }
                if (this.getPsdeopprivroles() != null) {
                    ArrayList<PSDEOPPrivRole> psdeopprivroles = new ArrayList<PSDEOPPrivRole>();
                    for (PSDEOPPrivRole pSDEOPPrivRole : this.getPsdeopprivroles()) {
                        if (bDeepMode) {
                            newitem = new PSDEOPPrivRole();
                            pSDEOPPrivRole.to(newitem, false, bDeepMode);
                            psdeopprivroles.add((PSDEOPPrivRole)newitem);
                            continue;
                        }
                        psdeopprivroles.add(pSDEOPPrivRole);
                    }
                    dst.setPsdeopprivroles(psdeopprivroles);
                }
                if (this.getPsdeutildes() != null) {
                    ArrayList<PSDEUtilDE> psdeutildes = new ArrayList<PSDEUtilDE>();
                    for (PSDEUtilDE pSDEUtilDE : this.getPsdeutildes()) {
                        if (bDeepMode) {
                            newitem = new PSDEUtilDE();
                            pSDEUtilDE.to(newitem, false, bDeepMode);
                            psdeutildes.add((PSDEUtilDE)newitem);
                            continue;
                        }
                        psdeutildes.add(pSDEUtilDE);
                    }
                    dst.setPsdeutildes(psdeutildes);
                }
                if (this.getPsdefgroups() != null) {
                    ArrayList<PSDEFGroup> psdefgroups = new ArrayList<PSDEFGroup>();
                    for (PSDEFGroup pSDEFGroup : this.getPsdefgroups()) {
                        if (bDeepMode) {
                            newitem = new PSDEFGroup();
                            pSDEFGroup.to(newitem, false, bDeepMode);
                            psdefgroups.add((PSDEFGroup)newitem);
                            continue;
                        }
                        psdefgroups.add(pSDEFGroup);
                    }
                    dst.setPsdefgroups(psdefgroups);
                }
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSDataEntity) {
            PSDataEntity src = (PSDataEntity)source;
            if (!bSimple) {
                PSModelBase newItem;
                if (src.getPsdedbcfgs() != null) {
                    ArrayList<PSDEDBCfg> psdedbcfgs = new ArrayList<PSDEDBCfg>();
                    for (PSDEDBCfg pSDEDBCfg : src.getPsdedbcfgs()) {
                        if (bDeepMode) {
                            newItem = new PSDEDBCfg();
                            ((PSDEDBCfg)newItem).from(pSDEDBCfg, false, bDeepMode);
                            psdedbcfgs.add((PSDEDBCfg)newItem);
                            continue;
                        }
                        psdedbcfgs.add(pSDEDBCfg);
                    }
                    this.setPsdedbcfgs(psdedbcfgs);
                }
                if (src.getPsdedrgroups() != null) {
                    ArrayList<PSDEDRGroup> psdedrgroups = new ArrayList<PSDEDRGroup>();
                    for (PSDEDRGroup pSDEDRGroup : src.getPsdedrgroups()) {
                        if (bDeepMode) {
                            newItem = new PSDEDRGroup();
                            ((PSDEDRGroup)newItem).from(pSDEDRGroup, false, bDeepMode);
                            psdedrgroups.add((PSDEDRGroup)newItem);
                            continue;
                        }
                        psdedrgroups.add(pSDEDRGroup);
                    }
                    this.setPsdedrgroups(psdedrgroups);
                }
                if (src.getPsdefields() != null) {
                    ArrayList<PSDEField> psdefields = new ArrayList<PSDEField>();
                    for (PSDEField pSDEField : src.getPsdefields()) {
                        if (bDeepMode) {
                            newItem = new PSDEField();
                            ((PSDEField)newItem).from(pSDEField, false, bDeepMode);
                            psdefields.add((PSDEField)newItem);
                            continue;
                        }
                        psdefields.add(pSDEField);
                    }
                    this.setPsdefields(psdefields);
                }
                if (src.getPsdeopprivs() != null) {
                    ArrayList<PSDEOPPriv> psdeopprivs = new ArrayList<PSDEOPPriv>();
                    for (PSDEOPPriv pSDEOPPriv : src.getPsdeopprivs()) {
                        if (bDeepMode) {
                            newItem = new PSDEOPPriv();
                            ((PSDEOPPriv)newItem).from(pSDEOPPriv, false, bDeepMode);
                            psdeopprivs.add((PSDEOPPriv)newItem);
                            continue;
                        }
                        psdeopprivs.add(pSDEOPPriv);
                    }
                    this.setPsdeopprivs(psdeopprivs);
                }
                if (src.getPsdetables() != null) {
                    ArrayList<PSDETable> psdetables = new ArrayList<PSDETable>();
                    for (PSDETable pSDETable : src.getPsdetables()) {
                        if (bDeepMode) {
                            newItem = new PSDETable();
                            ((PSDETable)newItem).from(pSDETable, false, bDeepMode);
                            psdetables.add((PSDETable)newItem);
                            continue;
                        }
                        psdetables.add(pSDETable);
                    }
                    this.setPsdetables(psdetables);
                }
                if (src.getPsdeuserroles() != null) {
                    ArrayList<PSDEUserRole> psdeuserroles = new ArrayList<PSDEUserRole>();
                    for (PSDEUserRole pSDEUserRole : src.getPsdeuserroles()) {
                        if (bDeepMode) {
                            newItem = new PSDEUserRole();
                            ((PSDEUserRole)newItem).from(pSDEUserRole, false, bDeepMode);
                            psdeuserroles.add((PSDEUserRole)newItem);
                            continue;
                        }
                        psdeuserroles.add(pSDEUserRole);
                    }
                    this.setPsdeuserroles(psdeuserroles);
                }
                if (src.getPssysdmitems() != null) {
                    ArrayList<PSSysDMItem> pssysdmitems = new ArrayList<PSSysDMItem>();
                    for (PSSysDMItem pSSysDMItem : src.getPssysdmitems()) {
                        if (bDeepMode) {
                            newItem = new PSSysDMItem();
                            ((PSSysDMItem)newItem).from(pSSysDMItem, false, bDeepMode);
                            pssysdmitems.add((PSSysDMItem)newItem);
                            continue;
                        }
                        pssysdmitems.add(pSSysDMItem);
                    }
                    this.setPssysdmitems(pssysdmitems);
                }
                if (src.getPsdeopprivroles() != null) {
                    ArrayList<PSDEOPPrivRole> psdeopprivroles = new ArrayList<PSDEOPPrivRole>();
                    for (PSDEOPPrivRole pSDEOPPrivRole : src.getPsdeopprivroles()) {
                        if (bDeepMode) {
                            newItem = new PSDEOPPrivRole();
                            ((PSDEOPPrivRole)newItem).from(pSDEOPPrivRole, false, bDeepMode);
                            psdeopprivroles.add((PSDEOPPrivRole)newItem);
                            continue;
                        }
                        psdeopprivroles.add(pSDEOPPrivRole);
                    }
                    this.setPsdeopprivroles(psdeopprivroles);
                }
                if (src.getPsdeutildes() != null) {
                    ArrayList<PSDEUtilDE> psdeutildes = new ArrayList<PSDEUtilDE>();
                    for (PSDEUtilDE pSDEUtilDE : src.getPsdeutildes()) {
                        if (bDeepMode) {
                            newItem = new PSDEUtilDE();
                            ((PSDEUtilDE)newItem).from(pSDEUtilDE, false, bDeepMode);
                            psdeutildes.add((PSDEUtilDE)newItem);
                            continue;
                        }
                        psdeutildes.add(pSDEUtilDE);
                    }
                    this.setPsdeutildes(psdeutildes);
                }
                if (src.getPsdefgroups() != null) {
                    ArrayList<PSDEFGroup> psdefgroups = new ArrayList<PSDEFGroup>();
                    for (PSDEFGroup pSDEFGroup : src.getPsdefgroups()) {
                        if (bDeepMode) {
                            newItem = new PSDEFGroup();
                            ((PSDEFGroup)newItem).from(pSDEFGroup, false, bDeepMode);
                            psdefgroups.add((PSDEFGroup)newItem);
                            continue;
                        }
                        psdefgroups.add(pSDEFGroup);
                    }
                    this.setPsdefgroups(psdefgroups);
                }
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

