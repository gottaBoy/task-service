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
import net.ibizsys.modelapi.domain.PSCodeList;
import net.ibizsys.modelapi.domain.PSCtrlLogicGroup;
import net.ibizsys.modelapi.domain.PSCtrlMsg;
import net.ibizsys.modelapi.domain.PSDEActionTempl;
import net.ibizsys.modelapi.domain.PSDEFInputTipSet;
import net.ibizsys.modelapi.domain.PSDEGroup;
import net.ibizsys.modelapi.domain.PSDELogic;
import net.ibizsys.modelapi.domain.PSDEOPPriv;
import net.ibizsys.modelapi.domain.PSDERGroup;
import net.ibizsys.modelapi.domain.PSDEToolbar;
import net.ibizsys.modelapi.domain.PSDETreeView;
import net.ibizsys.modelapi.domain.PSDEUAGroup;
import net.ibizsys.modelapi.domain.PSDEUIAction;
import net.ibizsys.modelapi.domain.PSLanguage;
import net.ibizsys.modelapi.domain.PSLanguageRes;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSubSysServiceAPI;
import net.ibizsys.modelapi.domain.PSSubViewType;
import net.ibizsys.modelapi.domain.PSSysActor;
import net.ibizsys.modelapi.domain.PSSysApp;
import net.ibizsys.modelapi.domain.PSSysBDInstCfg;
import net.ibizsys.modelapi.domain.PSSysBDScheme;
import net.ibizsys.modelapi.domain.PSSysBIScheme;
import net.ibizsys.modelapi.domain.PSSysBackService;
import net.ibizsys.modelapi.domain.PSSysCalendar;
import net.ibizsys.modelapi.domain.PSSysCanvas;
import net.ibizsys.modelapi.domain.PSSysChartTheme;
import net.ibizsys.modelapi.domain.PSSysCodeSnippet;
import net.ibizsys.modelapi.domain.PSSysContentCat;
import net.ibizsys.modelapi.domain.PSSysCounter;
import net.ibizsys.modelapi.domain.PSSysCss;
import net.ibizsys.modelapi.domain.PSSysCssCat;
import net.ibizsys.modelapi.domain.PSSysDBScheme;
import net.ibizsys.modelapi.domain.PSSysDBVF;
import net.ibizsys.modelapi.domain.PSSysDEFType;
import net.ibizsys.modelapi.domain.PSSysDELogicNode;
import net.ibizsys.modelapi.domain.PSSysDMVer;
import net.ibizsys.modelapi.domain.PSSysDashboard;
import net.ibizsys.modelapi.domain.PSSysDataSyncAgent;
import net.ibizsys.modelapi.domain.PSSysDictCat;
import net.ibizsys.modelapi.domain.PSSysDynaModel;
import net.ibizsys.modelapi.domain.PSSysDynaModelCat;
import net.ibizsys.modelapi.domain.PSSysEAIScheme;
import net.ibizsys.modelapi.domain.PSSysERMap;
import net.ibizsys.modelapi.domain.PSSysEditorStyle;
import net.ibizsys.modelapi.domain.PSSysImage;
import net.ibizsys.modelapi.domain.PSSysModelGroup;
import net.ibizsys.modelapi.domain.PSSysMsgQueue;
import net.ibizsys.modelapi.domain.PSSysMsgTarget;
import net.ibizsys.modelapi.domain.PSSysMsgTempl;
import net.ibizsys.modelapi.domain.PSSysOPPriv;
import net.ibizsys.modelapi.domain.PSSysPDTView;
import net.ibizsys.modelapi.domain.PSSysPFPlugin;
import net.ibizsys.modelapi.domain.PSSysPortlet;
import net.ibizsys.modelapi.domain.PSSysPortletCat;
import net.ibizsys.modelapi.domain.PSSysRef;
import net.ibizsys.modelapi.domain.PSSysReqItem;
import net.ibizsys.modelapi.domain.PSSysReqModule;
import net.ibizsys.modelapi.domain.PSSysResource;
import net.ibizsys.modelapi.domain.PSSysSAHandler;
import net.ibizsys.modelapi.domain.PSSysSFPlugin;
import net.ibizsys.modelapi.domain.PSSysSFPub;
import net.ibizsys.modelapi.domain.PSSysSampleValue;
import net.ibizsys.modelapi.domain.PSSysSearchBar;
import net.ibizsys.modelapi.domain.PSSysSearchScheme;
import net.ibizsys.modelapi.domain.PSSysSequence;
import net.ibizsys.modelapi.domain.PSSysServiceAPI;
import net.ibizsys.modelapi.domain.PSSysTestCase;
import net.ibizsys.modelapi.domain.PSSysTestData;
import net.ibizsys.modelapi.domain.PSSysTestPrj;
import net.ibizsys.modelapi.domain.PSSysTranslator;
import net.ibizsys.modelapi.domain.PSSysUCMap;
import net.ibizsys.modelapi.domain.PSSysUniRes;
import net.ibizsys.modelapi.domain.PSSysUniState;
import net.ibizsys.modelapi.domain.PSSysUnit;
import net.ibizsys.modelapi.domain.PSSysUserCase;
import net.ibizsys.modelapi.domain.PSSysUserCaseRS;
import net.ibizsys.modelapi.domain.PSSysUserDR;
import net.ibizsys.modelapi.domain.PSSysUserMode;
import net.ibizsys.modelapi.domain.PSSysUtilDE;
import net.ibizsys.modelapi.domain.PSSysValueRule;
import net.ibizsys.modelapi.domain.PSSysViewLogic;
import net.ibizsys.modelapi.domain.PSSysViewPanel;
import net.ibizsys.modelapi.domain.PSSysWFCat;
import net.ibizsys.modelapi.domain.PSSysWFMode;
import net.ibizsys.modelapi.domain.PSSysWFSetting;
import net.ibizsys.modelapi.domain.PSSystemDBCfg;
import net.ibizsys.modelapi.domain.PSSystemRun;
import net.ibizsys.modelapi.domain.PSThresholdGroup;
import net.ibizsys.modelapi.domain.PSViewMsg;
import net.ibizsys.modelapi.domain.PSViewMsgGroup;
import net.ibizsys.modelapi.domain.PSWFRole;
import net.ibizsys.modelapi.domain.PSWFWorkTime;
import net.ibizsys.modelapi.domain.PSWXAccount;
import net.ibizsys.modelapi.domain.PSWorkflow;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSSystem
extends PSModelBase {
    public static final String FIELD_ACCCTRLARCH = "accctrlarch";
    public static final String FIELD_AUTOCALCDERER = "autocalcderer";
    public static final String FIELD_BUGFIXS = "bugfixs";
    public static final String FIELD_CHECKMODELVER = "checkmodelver";
    public static final String FIELD_CLEMPTYTEXT = "clemptytext";
    public static final String FIELD_CLEMPTYTEXTPSLANRESID = "clemptytextpslanresid";
    public static final String FIELD_CLEMPTYTEXTPSLANRESNAME = "clemptytextpslanresname";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CTRLAPPENDDEITEMS = "ctrlappenddeitems";
    public static final String FIELD_DBTYPES = "dbtypes";
    public static final String FIELD_DEEXPMAXROWCNT = "deexpmaxrowcnt";
    public static final String FIELD_DEFPSSYSDEPLOYID = "defpssysdeployid";
    public static final String FIELD_DEFSFITEMWIDTH = "defsfitemwidth";
    public static final String FIELD_DEFSORTMODE = "defsortmode";
    public static final String FIELD_DEMSACTIONLOGICFLAG = "demsactionlogicflag";
    public static final String FIELD_DOMAINNAME = "domainname";
    public static final String FIELD_DTOFORMAT = "dtoformat";
    public static final String FIELD_ENABLEDBVALUEMODE = "enabledbvaluemode";
    public static final String FIELD_ENABLEDEDATAVER = "enablededataver";
    public static final String FIELD_ENABLEDEFRESTRICTEDUI = "enabledefrestrictedui";
    public static final String FIELD_ENABLEDERFKEY = "enablederfkey";
    public static final String FIELD_ENABLEDYNASYS = "enabledynasys";
    public static final String FIELD_ENABLEMULTILAN = "enablemultilan";
    public static final String FIELD_ENABLEOPNAMEMODEL = "enableopnamemodel";
    public static final String FIELD_ENADEFLANRESCONTENT = "enadeflanrescontent";
    public static final String FIELD_EXTRACTDEFAULT = "extractdefault";
    public static final String FIELD_INITDEDEFAULT = "initdedefault";
    public static final String FIELD_LANRESMAXTAG = "lanresmaxtag";
    public static final String FIELD_LOGICNAME = "logicname";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MODELV2EXPMODE = "modelv2expmode";
    public static final String FIELD_NOVIEWMODE = "noviewmode";
    public static final String FIELD_PIAUTOSHOWCAPTION = "piautoshowcaption";
    public static final String FIELD_PSLANGUAGEID = "pslanguageid";
    public static final String FIELD_PSLANGUAGENAME = "pslanguagename";
    public static final String FIELD_PSSFID = "pssfid";
    public static final String FIELD_PSSFNAME = "pssfname";
    public static final String FIELD_PSSYSENGINECFGID = "pssysenginecfgid";
    public static final String FIELD_PSSYSENGINECFGNAME = "pssysenginecfgname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_PUBDBMODELFLAG = "pubdbmodelflag";
    public static final String FIELD_SAASMODE = "saasmode";
    public static final String FIELD_SERVICEAPIFLAG = "serviceapiflag";
    public static final String FIELD_SIMACTIONLOGICS = "simactionlogics";
    public static final String FIELD_SRCPSSYSTEMID = "srcpssystemid";
    public static final String FIELD_SRCPSSYSTEMNAME = "srcpssystemname";
    public static final String FIELD_SSDEMSACTIONLOGICFLAG = "ssdemsactionlogicflag";
    public static final String FIELD_SYSFOLDER = "sysfolder";
    public static final String FIELD_SYSROWKEY = "sysrowkey";
    public static final String FIELD_SYSTYPE = "systype";
    public static final String FIELD_SYSVER = "sysver";
    public static final String FIELD_TEMPLENGINE = "templengine";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERPARAMS = "userparams";
    public static final String FIELD_VIEWUAREGMODE = "viewuaregmode";
    private List<PSSysModelGroup> pssysmodelgroups;
    private List<PSSysRef> pssysrefs;
    private List<PSLanguage> pslanguages;
    private List<PSModule> psmodules;
    private List<PSSubSysServiceAPI> pssubsysserviceapis;
    private List<PSSysBDInstCfg> pssysbdinstcfgs;
    private List<PSSysCanvas> pssyscanvas;
    private List<PSSysCss> pssyscsses;
    private List<PSSysDELogicNode> pssysdelogicnodes;
    private List<PSSysDictCat> pssysdictcats;
    private List<PSSysDynaModel> pssysdynamodels;
    private List<PSSysERMap> pssysermaps;
    private List<PSSysImage> pssysimages;
    private List<PSSysMsgTempl> pssysmsgtempls;
    private List<PSSysPDTView> pssyspdtviews;
    private List<PSSysSAHandler> pssyssahandlers;
    private List<PSSysServiceAPI> pssysserviceapis;
    private List<PSSysSFPub> pssyssfpubs;
    private List<PSSysUserDR> pssysuserdrs;
    private List<PSSysWFMode> pssyswfmodes;
    private List<PSSysWFSetting> pssyswfsettings;
    private List<PSViewMsg> psviewmsgs;
    private List<PSWFRole> pswfroles;
    private List<PSWXAccount> pswxaccounts;
    private List<PSACHandler> psachandlers;
    private List<PSCodeList> pscodelists;
    private List<PSCtrlLogicGroup> psctrllogicgroups;
    private List<PSCtrlMsg> psctrlmsgs;
    private List<PSDEActionTempl> psdeactiontempls;
    private List<PSDEFInputTipSet> psdefinputtipsets;
    private List<PSDEGroup> psdegroups;
    private List<PSDELogic> psdelogics;
    private List<PSDERGroup> psdergroups;
    private List<PSDEToolbar> psdetoolbars;
    private List<PSDETreeView> psdetreeviews;
    private List<PSSubViewType> pssubviewtypes;
    private List<PSSysActor> pssysactors;
    private List<PSSysBackService> pssysbackservices;
    private List<PSSysBDScheme> pssysbdschemes;
    private List<PSSysBIScheme> pssysbischemes;
    private List<PSSysCalendar> pssyscalendars;
    private List<PSSysChartTheme> pssyschartthemes;
    private List<PSSysCodeSnippet> pssyscodesnippets;
    private List<PSSysContentCat> pssyscontentcats;
    private List<PSSysCounter> pssyscounters;
    private List<PSSysCssCat> pssyscsscats;
    private List<PSSysDashboard> pssysdashboards;
    private List<PSSysDataSyncAgent> pssysdatasyncagents;
    private List<PSSysDBScheme> pssysdbschemes;
    private List<PSSysDBVF> pssysdbvfs;
    private List<PSSysDEFType> pssysdeftypes;
    private List<PSSysDMVer> pssysdmvers;
    private List<PSSysDynaModelCat> pssysdynamodelcats;
    private List<PSSysEAIScheme> pssyseaischemes;
    private List<PSSysEditorStyle> pssyseditorstyles;
    private List<PSSysMsgQueue> pssysmsgqueues;
    private List<PSSysMsgTarget> pssysmsgtargets;
    private List<PSSysOPPriv> pssysopprivs;
    private List<PSSysPFPlugin> pssyspfplugins;
    private List<PSSysPortletCat> pssysportletcats;
    private List<PSSysPortlet> pssysportlets;
    private List<PSSysReqItem> pssysreqitems;
    private List<PSSysReqModule> pssysreqmodules;
    private List<PSSysResource> pssysresources;
    private List<PSSysSampleValue> pssyssamplevalues;
    private List<PSSysSearchBar> pssyssearchbars;
    private List<PSSysSearchScheme> pssyssearchschemes;
    private List<PSSysSequence> pssyssequences;
    private List<PSSysSFPlugin> pssyssfplugins;
    private List<PSSystemDBCfg> pssystemdbcfgs;
    private List<PSSysTestPrj> pssystestprjs;
    private List<PSSysTranslator> pssystranslators;
    private List<PSSysUCMap> pssysucmaps;
    private List<PSSysUniRes> pssysunires;
    private List<PSSysUniState> pssysunistates;
    private List<PSSysUnit> pssysunits;
    private List<PSSysUserCaseRS> pssysusercasers;
    private List<PSSysUserCase> pssysusercases;
    private List<PSSysUserMode> pssysusermodes;
    private List<PSSysValueRule> pssysvaluerules;
    private List<PSSysViewLogic> pssysviewlogics;
    private List<PSSysViewPanel> pssysviewpanels;
    private List<PSSysWFCat> pssyswfcats;
    private List<PSThresholdGroup> psthresholdgroups;
    private List<PSViewMsgGroup> psviewmsggroups;
    private List<PSWFWorkTime> pswfworktimes;
    private List<PSWorkflow> psworkflows;
    private List<PSDEUAGroup> psdeuagroups;
    private List<PSDEUIAction> psdeuiactions;
    private List<PSSysApp> pssysapps;
    private List<PSSysTestCase> pssystestcases;
    private List<PSSysTestData> pssystestdata;
    private List<PSSysUtilDE> pssysutildes;
    private List<PSLanguageRes> pslanguageres;
    private List<PSSystemRun> pssystemruns;
    private List<PSDEOPPriv> psdeopprivs;

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
    public Integer getAutoCalcDERER() {
        Object objValue = this.get(FIELD_AUTOCALCDERER);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="autocalcderer")
    public void setAutoCalcDERER(Integer autoCalcDERER) {
        this.set(FIELD_AUTOCALCDERER, autoCalcDERER);
    }

    @JsonIgnore
    public boolean isAutoCalcDERERDirty() {
        return this.contains(FIELD_AUTOCALCDERER);
    }

    @JsonIgnore
    public Integer getBugFixs() {
        Object objValue = this.get(FIELD_BUGFIXS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="bugfixs")
    public void setBugFixs(Integer bugFixs) {
        this.set(FIELD_BUGFIXS, bugFixs);
    }

    @JsonIgnore
    public boolean isBugFixsDirty() {
        return this.contains(FIELD_BUGFIXS);
    }

    @JsonIgnore
    public Integer getCheckModelVer() {
        Object objValue = this.get(FIELD_CHECKMODELVER);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="checkmodelver")
    public void setCheckModelVer(Integer checkModelVer) {
        this.set(FIELD_CHECKMODELVER, checkModelVer);
    }

    @JsonIgnore
    public boolean isCheckModelVerDirty() {
        return this.contains(FIELD_CHECKMODELVER);
    }

    @JsonIgnore
    public String getCLEmptyText() {
        Object objValue = this.get(FIELD_CLEMPTYTEXT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="clemptytext")
    public void setCLEmptyText(String cLEmptyText) {
        this.set(FIELD_CLEMPTYTEXT, cLEmptyText);
    }

    @JsonIgnore
    public boolean isCLEmptyTextDirty() {
        return this.contains(FIELD_CLEMPTYTEXT);
    }

    @JsonIgnore
    public String getCLEmptyTextPSLanResId() {
        Object objValue = this.get(FIELD_CLEMPTYTEXTPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="clemptytextpslanresid")
    public void setCLEmptyTextPSLanResId(String cLEmptyTextPSLanResId) {
        this.set(FIELD_CLEMPTYTEXTPSLANRESID, cLEmptyTextPSLanResId);
    }

    @JsonIgnore
    public boolean isCLEmptyTextPSLanResIdDirty() {
        return this.contains(FIELD_CLEMPTYTEXTPSLANRESID);
    }

    @JsonIgnore
    public String getCLEmptyTextPSLanResName() {
        Object objValue = this.get(FIELD_CLEMPTYTEXTPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="clemptytextpslanresname")
    public void setCLEmptyTextPSLanResName(String cLEmptyTextPSLanResName) {
        this.set(FIELD_CLEMPTYTEXTPSLANRESNAME, cLEmptyTextPSLanResName);
    }

    @JsonIgnore
    public boolean isCLEmptyTextPSLanResNameDirty() {
        return this.contains(FIELD_CLEMPTYTEXTPSLANRESNAME);
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
    public Integer getCtrlAppendDEItems() {
        Object objValue = this.get(FIELD_CTRLAPPENDDEITEMS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="ctrlappenddeitems")
    public void setCtrlAppendDEItems(Integer ctrlAppendDEItems) {
        this.set(FIELD_CTRLAPPENDDEITEMS, ctrlAppendDEItems);
    }

    @JsonIgnore
    public boolean isCtrlAppendDEItemsDirty() {
        return this.contains(FIELD_CTRLAPPENDDEITEMS);
    }

    @JsonIgnore
    public String getDBTypes() {
        Object objValue = this.get(FIELD_DBTYPES);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dbtypes")
    public void setDBTypes(String dBTypes) {
        this.set(FIELD_DBTYPES, dBTypes);
    }

    @JsonIgnore
    public boolean isDBTypesDirty() {
        return this.contains(FIELD_DBTYPES);
    }

    @JsonIgnore
    public Integer getDEExpMaxRowCnt() {
        Object objValue = this.get(FIELD_DEEXPMAXROWCNT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="deexpmaxrowcnt")
    public void setDEExpMaxRowCnt(Integer dEExpMaxRowCnt) {
        this.set(FIELD_DEEXPMAXROWCNT, dEExpMaxRowCnt);
    }

    @JsonIgnore
    public boolean isDEExpMaxRowCntDirty() {
        return this.contains(FIELD_DEEXPMAXROWCNT);
    }

    @JsonIgnore
    public String getDEFPSSysDeployId() {
        Object objValue = this.get(FIELD_DEFPSSYSDEPLOYID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="defpssysdeployid")
    public void setDEFPSSysDeployId(String dEFPSSysDeployId) {
        this.set(FIELD_DEFPSSYSDEPLOYID, dEFPSSysDeployId);
    }

    @JsonIgnore
    public boolean isDEFPSSysDeployIdDirty() {
        return this.contains(FIELD_DEFPSSYSDEPLOYID);
    }

    @JsonIgnore
    public Integer getDEFSFItemWidth() {
        Object objValue = this.get(FIELD_DEFSFITEMWIDTH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="defsfitemwidth")
    public void setDEFSFItemWidth(Integer dEFSFItemWidth) {
        this.set(FIELD_DEFSFITEMWIDTH, dEFSFItemWidth);
    }

    @JsonIgnore
    public boolean isDEFSFItemWidthDirty() {
        return this.contains(FIELD_DEFSFITEMWIDTH);
    }

    @JsonIgnore
    public String getDEFSortMode() {
        Object objValue = this.get(FIELD_DEFSORTMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="defsortmode")
    public void setDEFSortMode(String dEFSortMode) {
        this.set(FIELD_DEFSORTMODE, dEFSortMode);
    }

    @JsonIgnore
    public boolean isDEFSortModeDirty() {
        return this.contains(FIELD_DEFSORTMODE);
    }

    @JsonIgnore
    public Integer getDEMSActionLogicFlag() {
        Object objValue = this.get(FIELD_DEMSACTIONLOGICFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="demsactionlogicflag")
    public void setDEMSActionLogicFlag(Integer dEMSActionLogicFlag) {
        this.set(FIELD_DEMSACTIONLOGICFLAG, dEMSActionLogicFlag);
    }

    @JsonIgnore
    public boolean isDEMSActionLogicFlagDirty() {
        return this.contains(FIELD_DEMSACTIONLOGICFLAG);
    }

    @JsonIgnore
    public String getDomainName() {
        Object objValue = this.get(FIELD_DOMAINNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="domainname")
    public void setDomainName(String domainName) {
        this.set(FIELD_DOMAINNAME, domainName);
    }

    @JsonIgnore
    public boolean isDomainNameDirty() {
        return this.contains(FIELD_DOMAINNAME);
    }

    @JsonIgnore
    public String getDTOFormat() {
        Object objValue = this.get(FIELD_DTOFORMAT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dtoformat")
    public void setDTOFormat(String dTOFormat) {
        this.set(FIELD_DTOFORMAT, dTOFormat);
    }

    @JsonIgnore
    public boolean isDTOFormatDirty() {
        return this.contains(FIELD_DTOFORMAT);
    }

    @JsonIgnore
    public Integer getEnableDBValueMode() {
        Object objValue = this.get(FIELD_ENABLEDBVALUEMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enabledbvaluemode")
    public void setEnableDBValueMode(Integer enableDBValueMode) {
        this.set(FIELD_ENABLEDBVALUEMODE, enableDBValueMode);
    }

    @JsonIgnore
    public boolean isEnableDBValueModeDirty() {
        return this.contains(FIELD_ENABLEDBVALUEMODE);
    }

    @JsonIgnore
    public Integer getEnableDEDataVer() {
        Object objValue = this.get(FIELD_ENABLEDEDATAVER);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablededataver")
    public void setEnableDEDataVer(Integer enableDEDataVer) {
        this.set(FIELD_ENABLEDEDATAVER, enableDEDataVer);
    }

    @JsonIgnore
    public boolean isEnableDEDataVerDirty() {
        return this.contains(FIELD_ENABLEDEDATAVER);
    }

    @JsonIgnore
    public Integer getEnableDEFRestrictedUI() {
        Object objValue = this.get(FIELD_ENABLEDEFRESTRICTEDUI);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enabledefrestrictedui")
    public void setEnableDEFRestrictedUI(Integer enableDEFRestrictedUI) {
        this.set(FIELD_ENABLEDEFRESTRICTEDUI, enableDEFRestrictedUI);
    }

    @JsonIgnore
    public boolean isEnableDEFRestrictedUIDirty() {
        return this.contains(FIELD_ENABLEDEFRESTRICTEDUI);
    }

    @JsonIgnore
    public Integer getEnableDERFKey() {
        Object objValue = this.get(FIELD_ENABLEDERFKEY);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablederfkey")
    public void setEnableDERFKey(Integer enableDERFKey) {
        this.set(FIELD_ENABLEDERFKEY, enableDERFKey);
    }

    @JsonIgnore
    public boolean isEnableDERFKeyDirty() {
        return this.contains(FIELD_ENABLEDERFKEY);
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
    public Integer getEnableMultiLan() {
        Object objValue = this.get(FIELD_ENABLEMULTILAN);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablemultilan")
    public void setEnableMultiLan(Integer enableMultiLan) {
        this.set(FIELD_ENABLEMULTILAN, enableMultiLan);
    }

    @JsonIgnore
    public boolean isEnableMultiLanDirty() {
        return this.contains(FIELD_ENABLEMULTILAN);
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
    public Integer getEnaDefLanResContent() {
        Object objValue = this.get(FIELD_ENADEFLANRESCONTENT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enadeflanrescontent")
    public void setEnaDefLanResContent(Integer enaDefLanResContent) {
        this.set(FIELD_ENADEFLANRESCONTENT, enaDefLanResContent);
    }

    @JsonIgnore
    public boolean isEnaDefLanResContentDirty() {
        return this.contains(FIELD_ENADEFLANRESCONTENT);
    }

    @JsonIgnore
    public Integer getExtractDefault() {
        Object objValue = this.get(FIELD_EXTRACTDEFAULT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="extractdefault")
    public void setExtractDefault(Integer extractDefault) {
        this.set(FIELD_EXTRACTDEFAULT, extractDefault);
    }

    @JsonIgnore
    public boolean isExtractDefaultDirty() {
        return this.contains(FIELD_EXTRACTDEFAULT);
    }

    @JsonIgnore
    public Integer getInitDEDefault() {
        Object objValue = this.get(FIELD_INITDEDEFAULT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="initdedefault")
    public void setInitDEDefault(Integer initDEDefault) {
        this.set(FIELD_INITDEDEFAULT, initDEDefault);
    }

    @JsonIgnore
    public boolean isInitDEDefaultDirty() {
        return this.contains(FIELD_INITDEDEFAULT);
    }

    @JsonIgnore
    public Integer getLanResMaxTag() {
        Object objValue = this.get(FIELD_LANRESMAXTAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="lanresmaxtag")
    public void setLanResMaxTag(Integer lanResMaxTag) {
        this.set(FIELD_LANRESMAXTAG, lanResMaxTag);
    }

    @JsonIgnore
    public boolean isLanResMaxTagDirty() {
        return this.contains(FIELD_LANRESMAXTAG);
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
    public Integer getModelV2ExpMode() {
        Object objValue = this.get(FIELD_MODELV2EXPMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="modelv2expmode")
    public void setModelV2ExpMode(Integer modelV2ExpMode) {
        this.set(FIELD_MODELV2EXPMODE, modelV2ExpMode);
    }

    @JsonIgnore
    public boolean isModelV2ExpModeDirty() {
        return this.contains(FIELD_MODELV2EXPMODE);
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
    public Integer getPIAutoShowCaption() {
        Object objValue = this.get(FIELD_PIAUTOSHOWCAPTION);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="piautoshowcaption")
    public void setPIAutoShowCaption(Integer pIAutoShowCaption) {
        this.set(FIELD_PIAUTOSHOWCAPTION, pIAutoShowCaption);
    }

    @JsonIgnore
    public boolean isPIAutoShowCaptionDirty() {
        return this.contains(FIELD_PIAUTOSHOWCAPTION);
    }

    @JsonIgnore
    public String getPSLanguageId() {
        Object objValue = this.get(FIELD_PSLANGUAGEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pslanguageid")
    public void setPSLanguageId(String pSLanguageId) {
        this.set(FIELD_PSLANGUAGEID, pSLanguageId);
    }

    @JsonIgnore
    public boolean isPSLanguageIdDirty() {
        return this.contains(FIELD_PSLANGUAGEID);
    }

    @JsonIgnore
    public String getPSLanguageName() {
        Object objValue = this.get(FIELD_PSLANGUAGENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pslanguagename")
    public void setPSLanguageName(String pSLanguageName) {
        this.set(FIELD_PSLANGUAGENAME, pSLanguageName);
    }

    @JsonIgnore
    public boolean isPSLanguageNameDirty() {
        return this.contains(FIELD_PSLANGUAGENAME);
    }

    @JsonIgnore
    public String getPSSFId() {
        Object objValue = this.get(FIELD_PSSFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssfid")
    public void setPSSFId(String pSSFId) {
        this.set(FIELD_PSSFID, pSSFId);
    }

    @JsonIgnore
    public boolean isPSSFIdDirty() {
        return this.contains(FIELD_PSSFID);
    }

    @JsonIgnore
    public String getPSSFName() {
        Object objValue = this.get(FIELD_PSSFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssfname")
    public void setPSSFName(String pSSFName) {
        this.set(FIELD_PSSFNAME, pSSFName);
    }

    @JsonIgnore
    public boolean isPSSFNameDirty() {
        return this.contains(FIELD_PSSFNAME);
    }

    @JsonIgnore
    public String getPSSysEngineCfgId() {
        Object objValue = this.get(FIELD_PSSYSENGINECFGID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysenginecfgid")
    public void setPSSysEngineCfgId(String pSSysEngineCfgId) {
        this.set(FIELD_PSSYSENGINECFGID, pSSysEngineCfgId);
    }

    @JsonIgnore
    public boolean isPSSysEngineCfgIdDirty() {
        return this.contains(FIELD_PSSYSENGINECFGID);
    }

    @JsonIgnore
    public String getPSSysEngineCfgName() {
        Object objValue = this.get(FIELD_PSSYSENGINECFGNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysenginecfgname")
    public void setPSSysEngineCfgName(String pSSysEngineCfgName) {
        this.set(FIELD_PSSYSENGINECFGNAME, pSSysEngineCfgName);
    }

    @JsonIgnore
    public boolean isPSSysEngineCfgNameDirty() {
        return this.contains(FIELD_PSSYSENGINECFGNAME);
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
    public Integer getPubDBModelFlag() {
        Object objValue = this.get(FIELD_PUBDBMODELFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="pubdbmodelflag")
    public void setPubDBModelFlag(Integer pubDBModelFlag) {
        this.set(FIELD_PUBDBMODELFLAG, pubDBModelFlag);
    }

    @JsonIgnore
    public boolean isPubDBModelFlagDirty() {
        return this.contains(FIELD_PUBDBMODELFLAG);
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
    public Integer getSimActionLogics() {
        Object objValue = this.get(FIELD_SIMACTIONLOGICS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="simactionlogics")
    public void setSimActionLogics(Integer simActionLogics) {
        this.set(FIELD_SIMACTIONLOGICS, simActionLogics);
    }

    @JsonIgnore
    public boolean isSimActionLogicsDirty() {
        return this.contains(FIELD_SIMACTIONLOGICS);
    }

    @JsonIgnore
    public String getSrcPSSystemId() {
        Object objValue = this.get(FIELD_SRCPSSYSTEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="srcpssystemid")
    public void setSrcPSSystemId(String srcPSSystemId) {
        this.set(FIELD_SRCPSSYSTEMID, srcPSSystemId);
    }

    @JsonIgnore
    public boolean isSrcPSSystemIdDirty() {
        return this.contains(FIELD_SRCPSSYSTEMID);
    }

    @JsonIgnore
    public String getSrcPSSystemName() {
        Object objValue = this.get(FIELD_SRCPSSYSTEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="srcpssystemname")
    public void setSrcPSSystemName(String srcPSSystemName) {
        this.set(FIELD_SRCPSSYSTEMNAME, srcPSSystemName);
    }

    @JsonIgnore
    public boolean isSrcPSSystemNameDirty() {
        return this.contains(FIELD_SRCPSSYSTEMNAME);
    }

    @JsonIgnore
    public Integer getSSDEMSActionLogicFlag() {
        Object objValue = this.get(FIELD_SSDEMSACTIONLOGICFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="ssdemsactionlogicflag")
    public void setSSDEMSActionLogicFlag(Integer sSDEMSActionLogicFlag) {
        this.set(FIELD_SSDEMSACTIONLOGICFLAG, sSDEMSActionLogicFlag);
    }

    @JsonIgnore
    public boolean isSSDEMSActionLogicFlagDirty() {
        return this.contains(FIELD_SSDEMSACTIONLOGICFLAG);
    }

    @JsonIgnore
    public String getSysFolder() {
        Object objValue = this.get(FIELD_SYSFOLDER);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="sysfolder")
    public void setSysFolder(String sysFolder) {
        this.set(FIELD_SYSFOLDER, sysFolder);
    }

    @JsonIgnore
    public boolean isSysFolderDirty() {
        return this.contains(FIELD_SYSFOLDER);
    }

    @JsonIgnore
    public String getSysRowKey() {
        Object objValue = this.get(FIELD_SYSROWKEY);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="sysrowkey")
    public void setSysRowKey(String sysRowKey) {
        this.set(FIELD_SYSROWKEY, sysRowKey);
    }

    @JsonIgnore
    public boolean isSysRowKeyDirty() {
        return this.contains(FIELD_SYSROWKEY);
    }

    @JsonIgnore
    public String getSysType() {
        Object objValue = this.get(FIELD_SYSTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="systype")
    public void setSysType(String sysType) {
        this.set(FIELD_SYSTYPE, sysType);
    }

    @JsonIgnore
    public boolean isSysTypeDirty() {
        return this.contains(FIELD_SYSTYPE);
    }

    @JsonIgnore
    public String getSysVer() {
        Object objValue = this.get(FIELD_SYSVER);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="sysver")
    public void setSysVer(String sysVer) {
        this.set(FIELD_SYSVER, sysVer);
    }

    @JsonIgnore
    public boolean isSysVerDirty() {
        return this.contains(FIELD_SYSVER);
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
    public Integer getViewUARegMode() {
        Object objValue = this.get(FIELD_VIEWUAREGMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="viewuaregmode")
    public void setViewUARegMode(Integer viewUARegMode) {
        this.set(FIELD_VIEWUAREGMODE, viewUARegMode);
    }

    @JsonIgnore
    public boolean isViewUARegModeDirty() {
        return this.contains(FIELD_VIEWUAREGMODE);
    }

    @JsonIgnore
    public String getSrfkey() {
        return this.getPSSystemId();
    }

    public void setSrfkey(String strValue) {
        this.setPSSystemId(strValue);
    }

    public List<PSSysModelGroup> getPssysmodelgroups() {
        return this.pssysmodelgroups;
    }

    public void setPssysmodelgroups(List<PSSysModelGroup> pssysmodelgroups) {
        this.pssysmodelgroups = pssysmodelgroups;
    }

    public List<PSSysRef> getPssysrefs() {
        return this.pssysrefs;
    }

    public void setPssysrefs(List<PSSysRef> pssysrefs) {
        this.pssysrefs = pssysrefs;
    }

    public List<PSLanguage> getPslanguages() {
        return this.pslanguages;
    }

    public void setPslanguages(List<PSLanguage> pslanguages) {
        this.pslanguages = pslanguages;
    }

    public List<PSModule> getPsmodules() {
        return this.psmodules;
    }

    public void setPsmodules(List<PSModule> psmodules) {
        this.psmodules = psmodules;
    }

    public List<PSSubSysServiceAPI> getPssubsysserviceapis() {
        return this.pssubsysserviceapis;
    }

    public void setPssubsysserviceapis(List<PSSubSysServiceAPI> pssubsysserviceapis) {
        this.pssubsysserviceapis = pssubsysserviceapis;
    }

    public List<PSSysBDInstCfg> getPssysbdinstcfgs() {
        return this.pssysbdinstcfgs;
    }

    public void setPssysbdinstcfgs(List<PSSysBDInstCfg> pssysbdinstcfgs) {
        this.pssysbdinstcfgs = pssysbdinstcfgs;
    }

    public List<PSSysCanvas> getPssyscanvas() {
        return this.pssyscanvas;
    }

    public void setPssyscanvas(List<PSSysCanvas> pssyscanvas) {
        this.pssyscanvas = pssyscanvas;
    }

    public List<PSSysCss> getPssyscsses() {
        return this.pssyscsses;
    }

    public void setPssyscsses(List<PSSysCss> pssyscsses) {
        this.pssyscsses = pssyscsses;
    }

    public List<PSSysDELogicNode> getPssysdelogicnodes() {
        return this.pssysdelogicnodes;
    }

    public void setPssysdelogicnodes(List<PSSysDELogicNode> pssysdelogicnodes) {
        this.pssysdelogicnodes = pssysdelogicnodes;
    }

    public List<PSSysDictCat> getPssysdictcats() {
        return this.pssysdictcats;
    }

    public void setPssysdictcats(List<PSSysDictCat> pssysdictcats) {
        this.pssysdictcats = pssysdictcats;
    }

    public List<PSSysDynaModel> getPssysdynamodels() {
        return this.pssysdynamodels;
    }

    public void setPssysdynamodels(List<PSSysDynaModel> pssysdynamodels) {
        this.pssysdynamodels = pssysdynamodels;
    }

    public List<PSSysERMap> getPssysermaps() {
        return this.pssysermaps;
    }

    public void setPssysermaps(List<PSSysERMap> pssysermaps) {
        this.pssysermaps = pssysermaps;
    }

    public List<PSSysImage> getPssysimages() {
        return this.pssysimages;
    }

    public void setPssysimages(List<PSSysImage> pssysimages) {
        this.pssysimages = pssysimages;
    }

    public List<PSSysMsgTempl> getPssysmsgtempls() {
        return this.pssysmsgtempls;
    }

    public void setPssysmsgtempls(List<PSSysMsgTempl> pssysmsgtempls) {
        this.pssysmsgtempls = pssysmsgtempls;
    }

    public List<PSSysPDTView> getPssyspdtviews() {
        return this.pssyspdtviews;
    }

    public void setPssyspdtviews(List<PSSysPDTView> pssyspdtviews) {
        this.pssyspdtviews = pssyspdtviews;
    }

    public List<PSSysSAHandler> getPssyssahandlers() {
        return this.pssyssahandlers;
    }

    public void setPssyssahandlers(List<PSSysSAHandler> pssyssahandlers) {
        this.pssyssahandlers = pssyssahandlers;
    }

    public List<PSSysServiceAPI> getPssysserviceapis() {
        return this.pssysserviceapis;
    }

    public void setPssysserviceapis(List<PSSysServiceAPI> pssysserviceapis) {
        this.pssysserviceapis = pssysserviceapis;
    }

    public List<PSSysSFPub> getPssyssfpubs() {
        return this.pssyssfpubs;
    }

    public void setPssyssfpubs(List<PSSysSFPub> pssyssfpubs) {
        this.pssyssfpubs = pssyssfpubs;
    }

    public List<PSSysUserDR> getPssysuserdrs() {
        return this.pssysuserdrs;
    }

    public void setPssysuserdrs(List<PSSysUserDR> pssysuserdrs) {
        this.pssysuserdrs = pssysuserdrs;
    }

    public List<PSSysWFMode> getPssyswfmodes() {
        return this.pssyswfmodes;
    }

    public void setPssyswfmodes(List<PSSysWFMode> pssyswfmodes) {
        this.pssyswfmodes = pssyswfmodes;
    }

    public List<PSSysWFSetting> getPssyswfsettings() {
        return this.pssyswfsettings;
    }

    public void setPssyswfsettings(List<PSSysWFSetting> pssyswfsettings) {
        this.pssyswfsettings = pssyswfsettings;
    }

    public List<PSViewMsg> getPsviewmsgs() {
        return this.psviewmsgs;
    }

    public void setPsviewmsgs(List<PSViewMsg> psviewmsgs) {
        this.psviewmsgs = psviewmsgs;
    }

    public List<PSWFRole> getPswfroles() {
        return this.pswfroles;
    }

    public void setPswfroles(List<PSWFRole> pswfroles) {
        this.pswfroles = pswfroles;
    }

    public List<PSWXAccount> getPswxaccounts() {
        return this.pswxaccounts;
    }

    public void setPswxaccounts(List<PSWXAccount> pswxaccounts) {
        this.pswxaccounts = pswxaccounts;
    }

    public List<PSACHandler> getPsachandlers() {
        return this.psachandlers;
    }

    public void setPsachandlers(List<PSACHandler> psachandlers) {
        this.psachandlers = psachandlers;
    }

    public List<PSCodeList> getPscodelists() {
        return this.pscodelists;
    }

    public void setPscodelists(List<PSCodeList> pscodelists) {
        this.pscodelists = pscodelists;
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

    public List<PSDEActionTempl> getPsdeactiontempls() {
        return this.psdeactiontempls;
    }

    public void setPsdeactiontempls(List<PSDEActionTempl> psdeactiontempls) {
        this.psdeactiontempls = psdeactiontempls;
    }

    public List<PSDEFInputTipSet> getPsdefinputtipsets() {
        return this.psdefinputtipsets;
    }

    public void setPsdefinputtipsets(List<PSDEFInputTipSet> psdefinputtipsets) {
        this.psdefinputtipsets = psdefinputtipsets;
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

    public List<PSDETreeView> getPsdetreeviews() {
        return this.psdetreeviews;
    }

    public void setPsdetreeviews(List<PSDETreeView> psdetreeviews) {
        this.psdetreeviews = psdetreeviews;
    }

    public List<PSSubViewType> getPssubviewtypes() {
        return this.pssubviewtypes;
    }

    public void setPssubviewtypes(List<PSSubViewType> pssubviewtypes) {
        this.pssubviewtypes = pssubviewtypes;
    }

    public List<PSSysActor> getPssysactors() {
        return this.pssysactors;
    }

    public void setPssysactors(List<PSSysActor> pssysactors) {
        this.pssysactors = pssysactors;
    }

    public List<PSSysBackService> getPssysbackservices() {
        return this.pssysbackservices;
    }

    public void setPssysbackservices(List<PSSysBackService> pssysbackservices) {
        this.pssysbackservices = pssysbackservices;
    }

    public List<PSSysBDScheme> getPssysbdschemes() {
        return this.pssysbdschemes;
    }

    public void setPssysbdschemes(List<PSSysBDScheme> pssysbdschemes) {
        this.pssysbdschemes = pssysbdschemes;
    }

    public List<PSSysBIScheme> getPssysbischemes() {
        return this.pssysbischemes;
    }

    public void setPssysbischemes(List<PSSysBIScheme> pssysbischemes) {
        this.pssysbischemes = pssysbischemes;
    }

    public List<PSSysCalendar> getPssyscalendars() {
        return this.pssyscalendars;
    }

    public void setPssyscalendars(List<PSSysCalendar> pssyscalendars) {
        this.pssyscalendars = pssyscalendars;
    }

    public List<PSSysChartTheme> getPssyschartthemes() {
        return this.pssyschartthemes;
    }

    public void setPssyschartthemes(List<PSSysChartTheme> pssyschartthemes) {
        this.pssyschartthemes = pssyschartthemes;
    }

    public List<PSSysCodeSnippet> getPssyscodesnippets() {
        return this.pssyscodesnippets;
    }

    public void setPssyscodesnippets(List<PSSysCodeSnippet> pssyscodesnippets) {
        this.pssyscodesnippets = pssyscodesnippets;
    }

    public List<PSSysContentCat> getPssyscontentcats() {
        return this.pssyscontentcats;
    }

    public void setPssyscontentcats(List<PSSysContentCat> pssyscontentcats) {
        this.pssyscontentcats = pssyscontentcats;
    }

    public List<PSSysCounter> getPssyscounters() {
        return this.pssyscounters;
    }

    public void setPssyscounters(List<PSSysCounter> pssyscounters) {
        this.pssyscounters = pssyscounters;
    }

    public List<PSSysCssCat> getPssyscsscats() {
        return this.pssyscsscats;
    }

    public void setPssyscsscats(List<PSSysCssCat> pssyscsscats) {
        this.pssyscsscats = pssyscsscats;
    }

    public List<PSSysDashboard> getPssysdashboards() {
        return this.pssysdashboards;
    }

    public void setPssysdashboards(List<PSSysDashboard> pssysdashboards) {
        this.pssysdashboards = pssysdashboards;
    }

    public List<PSSysDataSyncAgent> getPssysdatasyncagents() {
        return this.pssysdatasyncagents;
    }

    public void setPssysdatasyncagents(List<PSSysDataSyncAgent> pssysdatasyncagents) {
        this.pssysdatasyncagents = pssysdatasyncagents;
    }

    public List<PSSysDBScheme> getPssysdbschemes() {
        return this.pssysdbschemes;
    }

    public void setPssysdbschemes(List<PSSysDBScheme> pssysdbschemes) {
        this.pssysdbschemes = pssysdbschemes;
    }

    public List<PSSysDBVF> getPssysdbvfs() {
        return this.pssysdbvfs;
    }

    public void setPssysdbvfs(List<PSSysDBVF> pssysdbvfs) {
        this.pssysdbvfs = pssysdbvfs;
    }

    public List<PSSysDEFType> getPssysdeftypes() {
        return this.pssysdeftypes;
    }

    public void setPssysdeftypes(List<PSSysDEFType> pssysdeftypes) {
        this.pssysdeftypes = pssysdeftypes;
    }

    public List<PSSysDMVer> getPssysdmvers() {
        return this.pssysdmvers;
    }

    public void setPssysdmvers(List<PSSysDMVer> pssysdmvers) {
        this.pssysdmvers = pssysdmvers;
    }

    public List<PSSysDynaModelCat> getPssysdynamodelcats() {
        return this.pssysdynamodelcats;
    }

    public void setPssysdynamodelcats(List<PSSysDynaModelCat> pssysdynamodelcats) {
        this.pssysdynamodelcats = pssysdynamodelcats;
    }

    public List<PSSysEAIScheme> getPssyseaischemes() {
        return this.pssyseaischemes;
    }

    public void setPssyseaischemes(List<PSSysEAIScheme> pssyseaischemes) {
        this.pssyseaischemes = pssyseaischemes;
    }

    public List<PSSysEditorStyle> getPssyseditorstyles() {
        return this.pssyseditorstyles;
    }

    public void setPssyseditorstyles(List<PSSysEditorStyle> pssyseditorstyles) {
        this.pssyseditorstyles = pssyseditorstyles;
    }

    public List<PSSysMsgQueue> getPssysmsgqueues() {
        return this.pssysmsgqueues;
    }

    public void setPssysmsgqueues(List<PSSysMsgQueue> pssysmsgqueues) {
        this.pssysmsgqueues = pssysmsgqueues;
    }

    public List<PSSysMsgTarget> getPssysmsgtargets() {
        return this.pssysmsgtargets;
    }

    public void setPssysmsgtargets(List<PSSysMsgTarget> pssysmsgtargets) {
        this.pssysmsgtargets = pssysmsgtargets;
    }

    public List<PSSysOPPriv> getPssysopprivs() {
        return this.pssysopprivs;
    }

    public void setPssysopprivs(List<PSSysOPPriv> pssysopprivs) {
        this.pssysopprivs = pssysopprivs;
    }

    public List<PSSysPFPlugin> getPssyspfplugins() {
        return this.pssyspfplugins;
    }

    public void setPssyspfplugins(List<PSSysPFPlugin> pssyspfplugins) {
        this.pssyspfplugins = pssyspfplugins;
    }

    public List<PSSysPortletCat> getPssysportletcats() {
        return this.pssysportletcats;
    }

    public void setPssysportletcats(List<PSSysPortletCat> pssysportletcats) {
        this.pssysportletcats = pssysportletcats;
    }

    public List<PSSysPortlet> getPssysportlets() {
        return this.pssysportlets;
    }

    public void setPssysportlets(List<PSSysPortlet> pssysportlets) {
        this.pssysportlets = pssysportlets;
    }

    public List<PSSysReqItem> getPssysreqitems() {
        return this.pssysreqitems;
    }

    public void setPssysreqitems(List<PSSysReqItem> pssysreqitems) {
        this.pssysreqitems = pssysreqitems;
    }

    public List<PSSysReqModule> getPssysreqmodules() {
        return this.pssysreqmodules;
    }

    public void setPssysreqmodules(List<PSSysReqModule> pssysreqmodules) {
        this.pssysreqmodules = pssysreqmodules;
    }

    public List<PSSysResource> getPssysresources() {
        return this.pssysresources;
    }

    public void setPssysresources(List<PSSysResource> pssysresources) {
        this.pssysresources = pssysresources;
    }

    public List<PSSysSampleValue> getPssyssamplevalues() {
        return this.pssyssamplevalues;
    }

    public void setPssyssamplevalues(List<PSSysSampleValue> pssyssamplevalues) {
        this.pssyssamplevalues = pssyssamplevalues;
    }

    public List<PSSysSearchBar> getPssyssearchbars() {
        return this.pssyssearchbars;
    }

    public void setPssyssearchbars(List<PSSysSearchBar> pssyssearchbars) {
        this.pssyssearchbars = pssyssearchbars;
    }

    public List<PSSysSearchScheme> getPssyssearchschemes() {
        return this.pssyssearchschemes;
    }

    public void setPssyssearchschemes(List<PSSysSearchScheme> pssyssearchschemes) {
        this.pssyssearchschemes = pssyssearchschemes;
    }

    public List<PSSysSequence> getPssyssequences() {
        return this.pssyssequences;
    }

    public void setPssyssequences(List<PSSysSequence> pssyssequences) {
        this.pssyssequences = pssyssequences;
    }

    public List<PSSysSFPlugin> getPssyssfplugins() {
        return this.pssyssfplugins;
    }

    public void setPssyssfplugins(List<PSSysSFPlugin> pssyssfplugins) {
        this.pssyssfplugins = pssyssfplugins;
    }

    public List<PSSystemDBCfg> getPssystemdbcfgs() {
        return this.pssystemdbcfgs;
    }

    public void setPssystemdbcfgs(List<PSSystemDBCfg> pssystemdbcfgs) {
        this.pssystemdbcfgs = pssystemdbcfgs;
    }

    public List<PSSysTestPrj> getPssystestprjs() {
        return this.pssystestprjs;
    }

    public void setPssystestprjs(List<PSSysTestPrj> pssystestprjs) {
        this.pssystestprjs = pssystestprjs;
    }

    public List<PSSysTranslator> getPssystranslators() {
        return this.pssystranslators;
    }

    public void setPssystranslators(List<PSSysTranslator> pssystranslators) {
        this.pssystranslators = pssystranslators;
    }

    public List<PSSysUCMap> getPssysucmaps() {
        return this.pssysucmaps;
    }

    public void setPssysucmaps(List<PSSysUCMap> pssysucmaps) {
        this.pssysucmaps = pssysucmaps;
    }

    public List<PSSysUniRes> getPssysunires() {
        return this.pssysunires;
    }

    public void setPssysunires(List<PSSysUniRes> pssysunires) {
        this.pssysunires = pssysunires;
    }

    public List<PSSysUniState> getPssysunistates() {
        return this.pssysunistates;
    }

    public void setPssysunistates(List<PSSysUniState> pssysunistates) {
        this.pssysunistates = pssysunistates;
    }

    public List<PSSysUnit> getPssysunits() {
        return this.pssysunits;
    }

    public void setPssysunits(List<PSSysUnit> pssysunits) {
        this.pssysunits = pssysunits;
    }

    public List<PSSysUserCaseRS> getPssysusercasers() {
        return this.pssysusercasers;
    }

    public void setPssysusercasers(List<PSSysUserCaseRS> pssysusercasers) {
        this.pssysusercasers = pssysusercasers;
    }

    public List<PSSysUserCase> getPssysusercases() {
        return this.pssysusercases;
    }

    public void setPssysusercases(List<PSSysUserCase> pssysusercases) {
        this.pssysusercases = pssysusercases;
    }

    public List<PSSysUserMode> getPssysusermodes() {
        return this.pssysusermodes;
    }

    public void setPssysusermodes(List<PSSysUserMode> pssysusermodes) {
        this.pssysusermodes = pssysusermodes;
    }

    public List<PSSysValueRule> getPssysvaluerules() {
        return this.pssysvaluerules;
    }

    public void setPssysvaluerules(List<PSSysValueRule> pssysvaluerules) {
        this.pssysvaluerules = pssysvaluerules;
    }

    public List<PSSysViewLogic> getPssysviewlogics() {
        return this.pssysviewlogics;
    }

    public void setPssysviewlogics(List<PSSysViewLogic> pssysviewlogics) {
        this.pssysviewlogics = pssysviewlogics;
    }

    public List<PSSysViewPanel> getPssysviewpanels() {
        return this.pssysviewpanels;
    }

    public void setPssysviewpanels(List<PSSysViewPanel> pssysviewpanels) {
        this.pssysviewpanels = pssysviewpanels;
    }

    public List<PSSysWFCat> getPssyswfcats() {
        return this.pssyswfcats;
    }

    public void setPssyswfcats(List<PSSysWFCat> pssyswfcats) {
        this.pssyswfcats = pssyswfcats;
    }

    public List<PSThresholdGroup> getPsthresholdgroups() {
        return this.psthresholdgroups;
    }

    public void setPsthresholdgroups(List<PSThresholdGroup> psthresholdgroups) {
        this.psthresholdgroups = psthresholdgroups;
    }

    public List<PSViewMsgGroup> getPsviewmsggroups() {
        return this.psviewmsggroups;
    }

    public void setPsviewmsggroups(List<PSViewMsgGroup> psviewmsggroups) {
        this.psviewmsggroups = psviewmsggroups;
    }

    public List<PSWFWorkTime> getPswfworktimes() {
        return this.pswfworktimes;
    }

    public void setPswfworktimes(List<PSWFWorkTime> pswfworktimes) {
        this.pswfworktimes = pswfworktimes;
    }

    public List<PSWorkflow> getPsworkflows() {
        return this.psworkflows;
    }

    public void setPsworkflows(List<PSWorkflow> psworkflows) {
        this.psworkflows = psworkflows;
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

    public List<PSSysApp> getPssysapps() {
        return this.pssysapps;
    }

    public void setPssysapps(List<PSSysApp> pssysapps) {
        this.pssysapps = pssysapps;
    }

    public List<PSSysTestCase> getPssystestcases() {
        return this.pssystestcases;
    }

    public void setPssystestcases(List<PSSysTestCase> pssystestcases) {
        this.pssystestcases = pssystestcases;
    }

    public List<PSSysTestData> getPssystestdata() {
        return this.pssystestdata;
    }

    public void setPssystestdata(List<PSSysTestData> pssystestdata) {
        this.pssystestdata = pssystestdata;
    }

    public List<PSSysUtilDE> getPssysutildes() {
        return this.pssysutildes;
    }

    public void setPssysutildes(List<PSSysUtilDE> pssysutildes) {
        this.pssysutildes = pssysutildes;
    }

    public List<PSLanguageRes> getPslanguageres() {
        return this.pslanguageres;
    }

    public void setPslanguageres(List<PSLanguageRes> pslanguageres) {
        this.pslanguageres = pslanguageres;
    }

    public List<PSSystemRun> getPssystemruns() {
        return this.pssystemruns;
    }

    public void setPssystemruns(List<PSSystemRun> pssystemruns) {
        this.pssystemruns = pssystemruns;
    }

    public List<PSDEOPPriv> getPsdeopprivs() {
        return this.psdeopprivs;
    }

    public void setPsdeopprivs(List<PSDEOPPriv> psdeopprivs) {
        this.psdeopprivs = psdeopprivs;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (bFullMode && strName.equalsIgnoreCase("pssysmodelgroups")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysrefs")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pslanguages")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psmodules")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssubsysserviceapis")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysbdinstcfgs")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssyscanvas")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssyscsses")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysdelogicnodes")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysdictcats")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysdynamodels")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysermaps")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysimages")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysmsgtempls")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssyspdtviews")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssyssahandlers")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysserviceapis")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssyssfpubs")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysuserdrs")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssyswfmodes")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssyswfsettings")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psviewmsgs")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pswfroles")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pswxaccounts")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psachandlers")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pscodelists")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psctrllogicgroups")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psctrlmsgs")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdeactiontempls")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdefinputtipsets")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdegroups")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdelogics")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdergroups")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdetoolbars")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdetreeviews")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssubviewtypes")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysactors")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysbackservices")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysbdschemes")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysbischemes")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssyscalendars")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssyschartthemes")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssyscodesnippets")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssyscontentcats")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssyscounters")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssyscsscats")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysdashboards")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysdatasyncagents")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysdbschemes")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysdbvfs")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysdeftypes")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysdmvers")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysdynamodelcats")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssyseaischemes")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssyseditorstyles")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysmsgqueues")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysmsgtargets")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysopprivs")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssyspfplugins")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysportletcats")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysportlets")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysreqitems")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysreqmodules")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysresources")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssyssamplevalues")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssyssearchbars")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssyssearchschemes")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssyssequences")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssyssfplugins")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssystemdbcfgs")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssystestprjs")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssystranslators")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysucmaps")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysunires")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysunistates")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysunits")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysusercasers")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysusercases")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysusermodes")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysvaluerules")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysviewlogics")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysviewpanels")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssyswfcats")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psthresholdgroups")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psviewmsggroups")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pswfworktimes")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psworkflows")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdeuagroups")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdeuiactions")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysapps")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssystestcases")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssystestdata")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysutildes")) {
            return true;
        }
        if (strName.equalsIgnoreCase("pslanguageres")) {
            return true;
        }
        if (strName.equalsIgnoreCase("pssystemruns")) {
            return true;
        }
        if (strName.equalsIgnoreCase("psdeopprivs")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("pssysmodelgroups")) {
            this.init();
            return this.pssysmodelgroups;
        }
        if (strName.equalsIgnoreCase("pssysrefs")) {
            this.init();
            return this.pssysrefs;
        }
        if (strName.equalsIgnoreCase("pslanguages")) {
            this.init();
            return this.pslanguages;
        }
        if (strName.equalsIgnoreCase("psmodules")) {
            this.init();
            return this.psmodules;
        }
        if (strName.equalsIgnoreCase("pssubsysserviceapis")) {
            this.init();
            return this.pssubsysserviceapis;
        }
        if (strName.equalsIgnoreCase("pssysbdinstcfgs")) {
            this.init();
            return this.pssysbdinstcfgs;
        }
        if (strName.equalsIgnoreCase("pssyscanvas")) {
            this.init();
            return this.pssyscanvas;
        }
        if (strName.equalsIgnoreCase("pssyscsses")) {
            this.init();
            return this.pssyscsses;
        }
        if (strName.equalsIgnoreCase("pssysdelogicnodes")) {
            this.init();
            return this.pssysdelogicnodes;
        }
        if (strName.equalsIgnoreCase("pssysdictcats")) {
            this.init();
            return this.pssysdictcats;
        }
        if (strName.equalsIgnoreCase("pssysdynamodels")) {
            this.init();
            return this.pssysdynamodels;
        }
        if (strName.equalsIgnoreCase("pssysermaps")) {
            this.init();
            return this.pssysermaps;
        }
        if (strName.equalsIgnoreCase("pssysimages")) {
            this.init();
            return this.pssysimages;
        }
        if (strName.equalsIgnoreCase("pssysmsgtempls")) {
            this.init();
            return this.pssysmsgtempls;
        }
        if (strName.equalsIgnoreCase("pssyspdtviews")) {
            this.init();
            return this.pssyspdtviews;
        }
        if (strName.equalsIgnoreCase("pssyssahandlers")) {
            this.init();
            return this.pssyssahandlers;
        }
        if (strName.equalsIgnoreCase("pssysserviceapis")) {
            this.init();
            return this.pssysserviceapis;
        }
        if (strName.equalsIgnoreCase("pssyssfpubs")) {
            this.init();
            return this.pssyssfpubs;
        }
        if (strName.equalsIgnoreCase("pssysuserdrs")) {
            this.init();
            return this.pssysuserdrs;
        }
        if (strName.equalsIgnoreCase("pssyswfmodes")) {
            this.init();
            return this.pssyswfmodes;
        }
        if (strName.equalsIgnoreCase("pssyswfsettings")) {
            this.init();
            return this.pssyswfsettings;
        }
        if (strName.equalsIgnoreCase("psviewmsgs")) {
            this.init();
            return this.psviewmsgs;
        }
        if (strName.equalsIgnoreCase("pswfroles")) {
            this.init();
            return this.pswfroles;
        }
        if (strName.equalsIgnoreCase("pswxaccounts")) {
            this.init();
            return this.pswxaccounts;
        }
        if (strName.equalsIgnoreCase("psachandlers")) {
            this.init();
            return this.psachandlers;
        }
        if (strName.equalsIgnoreCase("pscodelists")) {
            this.init();
            return this.pscodelists;
        }
        if (strName.equalsIgnoreCase("psctrllogicgroups")) {
            this.init();
            return this.psctrllogicgroups;
        }
        if (strName.equalsIgnoreCase("psctrlmsgs")) {
            this.init();
            return this.psctrlmsgs;
        }
        if (strName.equalsIgnoreCase("psdeactiontempls")) {
            this.init();
            return this.psdeactiontempls;
        }
        if (strName.equalsIgnoreCase("psdefinputtipsets")) {
            this.init();
            return this.psdefinputtipsets;
        }
        if (strName.equalsIgnoreCase("psdegroups")) {
            this.init();
            return this.psdegroups;
        }
        if (strName.equalsIgnoreCase("psdelogics")) {
            this.init();
            return this.psdelogics;
        }
        if (strName.equalsIgnoreCase("psdergroups")) {
            this.init();
            return this.psdergroups;
        }
        if (strName.equalsIgnoreCase("psdetoolbars")) {
            this.init();
            return this.psdetoolbars;
        }
        if (strName.equalsIgnoreCase("psdetreeviews")) {
            this.init();
            return this.psdetreeviews;
        }
        if (strName.equalsIgnoreCase("pssubviewtypes")) {
            this.init();
            return this.pssubviewtypes;
        }
        if (strName.equalsIgnoreCase("pssysactors")) {
            this.init();
            return this.pssysactors;
        }
        if (strName.equalsIgnoreCase("pssysbackservices")) {
            this.init();
            return this.pssysbackservices;
        }
        if (strName.equalsIgnoreCase("pssysbdschemes")) {
            this.init();
            return this.pssysbdschemes;
        }
        if (strName.equalsIgnoreCase("pssysbischemes")) {
            this.init();
            return this.pssysbischemes;
        }
        if (strName.equalsIgnoreCase("pssyscalendars")) {
            this.init();
            return this.pssyscalendars;
        }
        if (strName.equalsIgnoreCase("pssyschartthemes")) {
            this.init();
            return this.pssyschartthemes;
        }
        if (strName.equalsIgnoreCase("pssyscodesnippets")) {
            this.init();
            return this.pssyscodesnippets;
        }
        if (strName.equalsIgnoreCase("pssyscontentcats")) {
            this.init();
            return this.pssyscontentcats;
        }
        if (strName.equalsIgnoreCase("pssyscounters")) {
            this.init();
            return this.pssyscounters;
        }
        if (strName.equalsIgnoreCase("pssyscsscats")) {
            this.init();
            return this.pssyscsscats;
        }
        if (strName.equalsIgnoreCase("pssysdashboards")) {
            this.init();
            return this.pssysdashboards;
        }
        if (strName.equalsIgnoreCase("pssysdatasyncagents")) {
            this.init();
            return this.pssysdatasyncagents;
        }
        if (strName.equalsIgnoreCase("pssysdbschemes")) {
            this.init();
            return this.pssysdbschemes;
        }
        if (strName.equalsIgnoreCase("pssysdbvfs")) {
            this.init();
            return this.pssysdbvfs;
        }
        if (strName.equalsIgnoreCase("pssysdeftypes")) {
            this.init();
            return this.pssysdeftypes;
        }
        if (strName.equalsIgnoreCase("pssysdmvers")) {
            this.init();
            return this.pssysdmvers;
        }
        if (strName.equalsIgnoreCase("pssysdynamodelcats")) {
            this.init();
            return this.pssysdynamodelcats;
        }
        if (strName.equalsIgnoreCase("pssyseaischemes")) {
            this.init();
            return this.pssyseaischemes;
        }
        if (strName.equalsIgnoreCase("pssyseditorstyles")) {
            this.init();
            return this.pssyseditorstyles;
        }
        if (strName.equalsIgnoreCase("pssysmsgqueues")) {
            this.init();
            return this.pssysmsgqueues;
        }
        if (strName.equalsIgnoreCase("pssysmsgtargets")) {
            this.init();
            return this.pssysmsgtargets;
        }
        if (strName.equalsIgnoreCase("pssysopprivs")) {
            this.init();
            return this.pssysopprivs;
        }
        if (strName.equalsIgnoreCase("pssyspfplugins")) {
            this.init();
            return this.pssyspfplugins;
        }
        if (strName.equalsIgnoreCase("pssysportletcats")) {
            this.init();
            return this.pssysportletcats;
        }
        if (strName.equalsIgnoreCase("pssysportlets")) {
            this.init();
            return this.pssysportlets;
        }
        if (strName.equalsIgnoreCase("pssysreqitems")) {
            this.init();
            return this.pssysreqitems;
        }
        if (strName.equalsIgnoreCase("pssysreqmodules")) {
            this.init();
            return this.pssysreqmodules;
        }
        if (strName.equalsIgnoreCase("pssysresources")) {
            this.init();
            return this.pssysresources;
        }
        if (strName.equalsIgnoreCase("pssyssamplevalues")) {
            this.init();
            return this.pssyssamplevalues;
        }
        if (strName.equalsIgnoreCase("pssyssearchbars")) {
            this.init();
            return this.pssyssearchbars;
        }
        if (strName.equalsIgnoreCase("pssyssearchschemes")) {
            this.init();
            return this.pssyssearchschemes;
        }
        if (strName.equalsIgnoreCase("pssyssequences")) {
            this.init();
            return this.pssyssequences;
        }
        if (strName.equalsIgnoreCase("pssyssfplugins")) {
            this.init();
            return this.pssyssfplugins;
        }
        if (strName.equalsIgnoreCase("pssystemdbcfgs")) {
            this.init();
            return this.pssystemdbcfgs;
        }
        if (strName.equalsIgnoreCase("pssystestprjs")) {
            this.init();
            return this.pssystestprjs;
        }
        if (strName.equalsIgnoreCase("pssystranslators")) {
            this.init();
            return this.pssystranslators;
        }
        if (strName.equalsIgnoreCase("pssysucmaps")) {
            this.init();
            return this.pssysucmaps;
        }
        if (strName.equalsIgnoreCase("pssysunires")) {
            this.init();
            return this.pssysunires;
        }
        if (strName.equalsIgnoreCase("pssysunistates")) {
            this.init();
            return this.pssysunistates;
        }
        if (strName.equalsIgnoreCase("pssysunits")) {
            this.init();
            return this.pssysunits;
        }
        if (strName.equalsIgnoreCase("pssysusercasers")) {
            this.init();
            return this.pssysusercasers;
        }
        if (strName.equalsIgnoreCase("pssysusercases")) {
            this.init();
            return this.pssysusercases;
        }
        if (strName.equalsIgnoreCase("pssysusermodes")) {
            this.init();
            return this.pssysusermodes;
        }
        if (strName.equalsIgnoreCase("pssysvaluerules")) {
            this.init();
            return this.pssysvaluerules;
        }
        if (strName.equalsIgnoreCase("pssysviewlogics")) {
            this.init();
            return this.pssysviewlogics;
        }
        if (strName.equalsIgnoreCase("pssysviewpanels")) {
            this.init();
            return this.pssysviewpanels;
        }
        if (strName.equalsIgnoreCase("pssyswfcats")) {
            this.init();
            return this.pssyswfcats;
        }
        if (strName.equalsIgnoreCase("psthresholdgroups")) {
            this.init();
            return this.psthresholdgroups;
        }
        if (strName.equalsIgnoreCase("psviewmsggroups")) {
            this.init();
            return this.psviewmsggroups;
        }
        if (strName.equalsIgnoreCase("pswfworktimes")) {
            this.init();
            return this.pswfworktimes;
        }
        if (strName.equalsIgnoreCase("psworkflows")) {
            this.init();
            return this.psworkflows;
        }
        if (strName.equalsIgnoreCase("psdeuagroups")) {
            this.init();
            return this.psdeuagroups;
        }
        if (strName.equalsIgnoreCase("psdeuiactions")) {
            this.init();
            return this.psdeuiactions;
        }
        if (strName.equalsIgnoreCase("pssysapps")) {
            this.init();
            return this.pssysapps;
        }
        if (strName.equalsIgnoreCase("pssystestcases")) {
            this.init();
            return this.pssystestcases;
        }
        if (strName.equalsIgnoreCase("pssystestdata")) {
            this.init();
            return this.pssystestdata;
        }
        if (strName.equalsIgnoreCase("pssysutildes")) {
            this.init();
            return this.pssysutildes;
        }
        if (strName.equalsIgnoreCase("pslanguageres")) {
            this.init();
            return this.pslanguageres;
        }
        if (strName.equalsIgnoreCase("pssystemruns")) {
            this.init();
            return this.pssystemruns;
        }
        if (strName.equalsIgnoreCase("psdeopprivs")) {
            this.init();
            return this.psdeopprivs;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSSYSTEM";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSSystem item = (PSSystem)MAPPER.readValue(new File(strJsonFilePath), PSSystem.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSSystem) {
            PSSystem dst = (PSSystem)target;
            if (!bSimple) {
                PSModelBase newitem;
                if (this.getPslanguageres() != null) {
                    ArrayList<PSLanguageRes> pslanguageres = new ArrayList<PSLanguageRes>();
                    for (PSLanguageRes pSLanguageRes : this.getPslanguageres()) {
                        if (bDeepMode) {
                            newitem = new PSLanguageRes();
                            pSLanguageRes.to(newitem, false, bDeepMode);
                            pslanguageres.add((PSLanguageRes)newitem);
                            continue;
                        }
                        pslanguageres.add(pSLanguageRes);
                    }
                    dst.setPslanguageres(pslanguageres);
                }
                if (this.getPssystemruns() != null) {
                    ArrayList<PSSystemRun> pssystemruns = new ArrayList<PSSystemRun>();
                    for (PSSystemRun pSSystemRun : this.getPssystemruns()) {
                        if (bDeepMode) {
                            newitem = new PSSystemRun();
                            pSSystemRun.to(newitem, false, bDeepMode);
                            pssystemruns.add((PSSystemRun)newitem);
                            continue;
                        }
                        pssystemruns.add(pSSystemRun);
                    }
                    dst.setPssystemruns(pssystemruns);
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
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSSystem) {
            PSSystem src = (PSSystem)source;
            if (!bSimple) {
                PSModelBase newItem;
                if (src.getPslanguageres() != null) {
                    ArrayList<PSLanguageRes> pslanguageres = new ArrayList<PSLanguageRes>();
                    for (PSLanguageRes pSLanguageRes : src.getPslanguageres()) {
                        if (bDeepMode) {
                            newItem = new PSLanguageRes();
                            ((PSLanguageRes)newItem).from(pSLanguageRes, false, bDeepMode);
                            pslanguageres.add((PSLanguageRes)newItem);
                            continue;
                        }
                        pslanguageres.add(pSLanguageRes);
                    }
                    this.setPslanguageres(pslanguageres);
                }
                if (src.getPssystemruns() != null) {
                    ArrayList<PSSystemRun> pssystemruns = new ArrayList<PSSystemRun>();
                    for (PSSystemRun pSSystemRun : src.getPssystemruns()) {
                        if (bDeepMode) {
                            newItem = new PSSystemRun();
                            ((PSSystemRun)newItem).from(pSSystemRun, false, bDeepMode);
                            pssystemruns.add((PSSystemRun)newItem);
                            continue;
                        }
                        pssystemruns.add(pSSystemRun);
                    }
                    this.setPssystemruns(pssystemruns);
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
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

