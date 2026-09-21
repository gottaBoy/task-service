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
import net.ibizsys.modelapi.domain.PSDEFInputTip;
import net.ibizsys.modelapi.domain.PSDEFInputTipSet;
import net.ibizsys.modelapi.domain.PSDEGroup;
import net.ibizsys.modelapi.domain.PSDELogic;
import net.ibizsys.modelapi.domain.PSDEOPPriv;
import net.ibizsys.modelapi.domain.PSDERGroup;
import net.ibizsys.modelapi.domain.PSDEToolbar;
import net.ibizsys.modelapi.domain.PSDEUAGroup;
import net.ibizsys.modelapi.domain.PSDEUIAction;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.domain.PSLanguageItem;
import net.ibizsys.modelapi.domain.PSLanguageRes;
import net.ibizsys.modelapi.domain.PSSubSysServiceAPI;
import net.ibizsys.modelapi.domain.PSSubViewType;
import net.ibizsys.modelapi.domain.PSSysActor;
import net.ibizsys.modelapi.domain.PSSysApp;
import net.ibizsys.modelapi.domain.PSSysBDScheme;
import net.ibizsys.modelapi.domain.PSSysBIScheme;
import net.ibizsys.modelapi.domain.PSSysBackService;
import net.ibizsys.modelapi.domain.PSSysCalendar;
import net.ibizsys.modelapi.domain.PSSysCanvas;
import net.ibizsys.modelapi.domain.PSSysChartTheme;
import net.ibizsys.modelapi.domain.PSSysContentCat;
import net.ibizsys.modelapi.domain.PSSysCounter;
import net.ibizsys.modelapi.domain.PSSysCss;
import net.ibizsys.modelapi.domain.PSSysCssCat;
import net.ibizsys.modelapi.domain.PSSysDBScheme;
import net.ibizsys.modelapi.domain.PSSysDBVF;
import net.ibizsys.modelapi.domain.PSSysDELogicNode;
import net.ibizsys.modelapi.domain.PSSysDashboard;
import net.ibizsys.modelapi.domain.PSSysDataSyncAgent;
import net.ibizsys.modelapi.domain.PSSysDictCat;
import net.ibizsys.modelapi.domain.PSSysDynaModel;
import net.ibizsys.modelapi.domain.PSSysDynaModelCat;
import net.ibizsys.modelapi.domain.PSSysEAIScheme;
import net.ibizsys.modelapi.domain.PSSysERMap;
import net.ibizsys.modelapi.domain.PSSysEditorStyle;
import net.ibizsys.modelapi.domain.PSSysImage;
import net.ibizsys.modelapi.domain.PSSysMsgQueue;
import net.ibizsys.modelapi.domain.PSSysMsgTarget;
import net.ibizsys.modelapi.domain.PSSysMsgTempl;
import net.ibizsys.modelapi.domain.PSSysOPPriv;
import net.ibizsys.modelapi.domain.PSSysPDTView;
import net.ibizsys.modelapi.domain.PSSysPFPlugin;
import net.ibizsys.modelapi.domain.PSSysPortlet;
import net.ibizsys.modelapi.domain.PSSysPortletCat;
import net.ibizsys.modelapi.domain.PSSysReqItem;
import net.ibizsys.modelapi.domain.PSSysReqModule;
import net.ibizsys.modelapi.domain.PSSysResource;
import net.ibizsys.modelapi.domain.PSSysSAHandler;
import net.ibizsys.modelapi.domain.PSSysSFPlugin;
import net.ibizsys.modelapi.domain.PSSysSampleValue;
import net.ibizsys.modelapi.domain.PSSysSearchBar;
import net.ibizsys.modelapi.domain.PSSysSearchScheme;
import net.ibizsys.modelapi.domain.PSSysSequence;
import net.ibizsys.modelapi.domain.PSSysServiceAPI;
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
import net.ibizsys.modelapi.domain.PSThresholdGroup;
import net.ibizsys.modelapi.domain.PSViewMsg;
import net.ibizsys.modelapi.domain.PSViewMsgGroup;
import net.ibizsys.modelapi.domain.PSWFRole;
import net.ibizsys.modelapi.domain.PSWFWorkTime;
import net.ibizsys.modelapi.domain.PSWXAccount;
import net.ibizsys.modelapi.domain.PSWorkflow;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSModule
extends PSModelBase {
    public static final String FIELD_CLSPKGPARAMS = "clspkgparams";
    public static final String FIELD_CODENAME = "codename";
    public static final String FIELD_COLOR = "color";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DEFAULTFLAG = "defaultflag";
    public static final String FIELD_DSLINK = "dslink";
    public static final String FIELD_DTOFORMAT = "dtoformat";
    public static final String FIELD_DYNAINSTMODE = "dynainstmode";
    public static final String FIELD_DYNAINSTTAG = "dynainsttag";
    public static final String FIELD_DYNAINSTTAG2 = "dynainsttag2";
    public static final String FIELD_LANRESTAG = "lanrestag";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MODTAG = "modtag";
    public static final String FIELD_MODTAG2 = "modtag2";
    public static final String FIELD_MODTAG3 = "modtag3";
    public static final String FIELD_MODTAG4 = "modtag4";
    public static final String FIELD_MODULESN = "modulesn";
    public static final String FIELD_NOVIEWMODE = "noviewmode";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PKGCODENAME = "pkgcodename";
    public static final String FIELD_PSMODULEID = "psmoduleid";
    public static final String FIELD_PSMODULENAME = "psmodulename";
    public static final String FIELD_PSSYSMODELGROUPID = "pssysmodelgroupid";
    public static final String FIELD_PSSYSMODELGROUPNAME = "pssysmodelgroupname";
    public static final String FIELD_PSSYSREFID = "pssysrefid";
    public static final String FIELD_PSSYSREFNAME = "pssysrefname";
    public static final String FIELD_PSSYSSFPUBID = "pssyssfpubid";
    public static final String FIELD_PSSYSSFPUBNAME = "pssyssfpubname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_SERVICEAPIFLAG = "serviceapiflag";
    public static final String FIELD_SHORTTAG = "shorttag";
    public static final String FIELD_SUBSYSMODULE = "subsysmodule";
    public static final String FIELD_SYSREFTYPE = "sysreftype";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERPARAMS = "userparams";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_UTILPARAMS = "utilparams";
    public static final String FIELD_UTILTAG = "utiltag";
    public static final String FIELD_UTILTYPE = "utiltype";
    private List<PSCodeList> pscodelists;
    private List<PSDataEntity> psdataentities;
    private List<PSDEActionTempl> psdeactiontempls;
    private List<PSDEFInputTip> psdefinputtips;
    private List<PSSubSysServiceAPI> pssubsysserviceapis;
    private List<PSSubViewType> pssubviewtypes;
    private List<PSSysActor> pssysactors;
    private List<PSSysApp> pssysapps;
    private List<PSSysBackService> pssysbackservices;
    private List<PSSysBDScheme> pssysbdschemes;
    private List<PSSysCanvas> pssyscanvas;
    private List<PSSysChartTheme> pssyschartthemes;
    private List<PSSysCssCat> pssyscsscats;
    private List<PSSysCss> pssyscsses;
    private List<PSSysDataSyncAgent> pssysdatasyncagents;
    private List<PSSysDBScheme> pssysdbschemes;
    private List<PSSysDBVF> pssysdbvfs;
    private List<PSSysDELogicNode> pssysdelogicnodes;
    private List<PSSysDictCat> pssysdictcats;
    private List<PSSysDynaModelCat> pssysdynamodelcats;
    private List<PSSysDynaModel> pssysdynamodels;
    private List<PSSysEAIScheme> pssyseaischemes;
    private List<PSSysEditorStyle> pssyseditorstyles;
    private List<PSSysERMap> pssysermaps;
    private List<PSSysImage> pssysimages;
    private List<PSSysMsgQueue> pssysmsgqueues;
    private List<PSSysMsgTarget> pssysmsgtargets;
    private List<PSSysMsgTempl> pssysmsgtempls;
    private List<PSSysOPPriv> pssysopprivs;
    private List<PSSysPDTView> pssyspdtviews;
    private List<PSSysPFPlugin> pssyspfplugins;
    private List<PSSysPortletCat> pssysportletcats;
    private List<PSSysResource> pssysresources;
    private List<PSSysSAHandler> pssyssahandlers;
    private List<PSSysSampleValue> pssyssamplevalues;
    private List<PSSysSearchScheme> pssyssearchschemes;
    private List<PSSysServiceAPI> pssysserviceapis;
    private List<PSSysSFPlugin> pssyssfplugins;
    private List<PSSysUniRes> pssysunires;
    private List<PSSysUserCase> pssysusercases;
    private List<PSSysUserDR> pssysuserdrs;
    private List<PSSysUserMode> pssysusermodes;
    private List<PSSysUtilDE> pssysutildes;
    private List<PSSysValueRule> pssysvaluerules;
    private List<PSSysWFCat> pssyswfcats;
    private List<PSSysWFMode> pssyswfmodes;
    private List<PSThresholdGroup> psthresholdgroups;
    private List<PSViewMsgGroup> psviewmsggroups;
    private List<PSViewMsg> psviewmsgs;
    private List<PSWFRole> pswfroles;
    private List<PSWFWorkTime> pswfworktimes;
    private List<PSWorkflow> psworkflows;
    private List<PSWXAccount> pswxaccounts;
    private List<PSACHandler> psachandlers;
    private List<PSCtrlLogicGroup> psctrllogicgroups;
    private List<PSCtrlMsg> psctrlmsgs;
    private List<PSDEFInputTipSet> psdefinputtipsets;
    private List<PSDEGroup> psdegroups;
    private List<PSDELogic> psdelogics;
    private List<PSDERGroup> psdergroups;
    private List<PSDEToolbar> psdetoolbars;
    private List<PSSysCalendar> pssyscalendars;
    private List<PSSysContentCat> pssyscontentcats;
    private List<PSSysCounter> pssyscounters;
    private List<PSSysDashboard> pssysdashboards;
    private List<PSSysPortlet> pssysportlets;
    private List<PSSysReqItem> pssysreqitems;
    private List<PSSysReqModule> pssysreqmodules;
    private List<PSSysSearchBar> pssyssearchbars;
    private List<PSSysSequence> pssyssequences;
    private List<PSSysTestPrj> pssystestprjs;
    private List<PSSysTranslator> pssystranslators;
    private List<PSSysUCMap> pssysucmaps;
    private List<PSSysUniState> pssysunistates;
    private List<PSSysUnit> pssysunits;
    private List<PSSysUserCaseRS> pssysusercasers;
    private List<PSSysViewLogic> pssysviewlogics;
    private List<PSSysViewPanel> pssysviewpanels;
    private List<PSDEUAGroup> psdeuagroups;
    private List<PSDEUIAction> psdeuiactions;
    private List<PSSysBIScheme> pssysbischemes;
    private List<PSSysTestData> pssystestdata;
    private List<PSLanguageItem> pslanguageitems;
    private List<PSLanguageRes> pslanguageres;
    private List<PSDEOPPriv> psdeopprivs;

    @JsonIgnore
    public String getClsPkgParams() {
        Object objValue = this.get(FIELD_CLSPKGPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="clspkgparams")
    public void setClsPkgParams(String clsPkgParams) {
        this.set(FIELD_CLSPKGPARAMS, clsPkgParams);
    }

    @JsonIgnore
    public boolean isClsPkgParamsDirty() {
        return this.contains(FIELD_CLSPKGPARAMS);
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
    public Integer getDynaInstMode() {
        Object objValue = this.get(FIELD_DYNAINSTMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="dynainstmode")
    public void setDynaInstMode(Integer dynaInstMode) {
        this.set(FIELD_DYNAINSTMODE, dynaInstMode);
    }

    @JsonIgnore
    public boolean isDynaInstModeDirty() {
        return this.contains(FIELD_DYNAINSTMODE);
    }

    @JsonIgnore
    public String getDynaInstTag() {
        Object objValue = this.get(FIELD_DYNAINSTTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dynainsttag")
    public void setDynaInstTag(String dynaInstTag) {
        this.set(FIELD_DYNAINSTTAG, dynaInstTag);
    }

    @JsonIgnore
    public boolean isDynaInstTagDirty() {
        return this.contains(FIELD_DYNAINSTTAG);
    }

    @JsonIgnore
    public String getDynaInstTag2() {
        Object objValue = this.get(FIELD_DYNAINSTTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dynainsttag2")
    public void setDynaInstTag2(String dynaInstTag2) {
        this.set(FIELD_DYNAINSTTAG2, dynaInstTag2);
    }

    @JsonIgnore
    public boolean isDynaInstTag2Dirty() {
        return this.contains(FIELD_DYNAINSTTAG2);
    }

    @JsonIgnore
    public String getLanResTag() {
        Object objValue = this.get(FIELD_LANRESTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="lanrestag")
    public void setLanResTag(String lanResTag) {
        this.set(FIELD_LANRESTAG, lanResTag);
    }

    @JsonIgnore
    public boolean isLanResTagDirty() {
        return this.contains(FIELD_LANRESTAG);
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
    public String getModTag() {
        Object objValue = this.get(FIELD_MODTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="modtag")
    public void setModTag(String modTag) {
        this.set(FIELD_MODTAG, modTag);
    }

    @JsonIgnore
    public boolean isModTagDirty() {
        return this.contains(FIELD_MODTAG);
    }

    @JsonIgnore
    public String getModTag2() {
        Object objValue = this.get(FIELD_MODTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="modtag2")
    public void setModTag2(String modTag2) {
        this.set(FIELD_MODTAG2, modTag2);
    }

    @JsonIgnore
    public boolean isModTag2Dirty() {
        return this.contains(FIELD_MODTAG2);
    }

    @JsonIgnore
    public String getModTag3() {
        Object objValue = this.get(FIELD_MODTAG3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="modtag3")
    public void setModTag3(String modTag3) {
        this.set(FIELD_MODTAG3, modTag3);
    }

    @JsonIgnore
    public boolean isModTag3Dirty() {
        return this.contains(FIELD_MODTAG3);
    }

    @JsonIgnore
    public String getModTag4() {
        Object objValue = this.get(FIELD_MODTAG4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="modtag4")
    public void setModTag4(String modTag4) {
        this.set(FIELD_MODTAG4, modTag4);
    }

    @JsonIgnore
    public boolean isModTag4Dirty() {
        return this.contains(FIELD_MODTAG4);
    }

    @JsonIgnore
    public String getModuleSN() {
        Object objValue = this.get(FIELD_MODULESN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="modulesn")
    public void setModuleSN(String moduleSN) {
        this.set(FIELD_MODULESN, moduleSN);
    }

    @JsonIgnore
    public boolean isModuleSNDirty() {
        return this.contains(FIELD_MODULESN);
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
    public String getPKGCodeName() {
        Object objValue = this.get(FIELD_PKGCODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pkgcodename")
    public void setPKGCodeName(String pKGCodeName) {
        this.set(FIELD_PKGCODENAME, pKGCodeName);
    }

    @JsonIgnore
    public boolean isPKGCodeNameDirty() {
        return this.contains(FIELD_PKGCODENAME);
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
    public String getPSSysRefId() {
        Object objValue = this.get(FIELD_PSSYSREFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysrefid")
    public void setPSSysRefId(String pSSysRefId) {
        this.set(FIELD_PSSYSREFID, pSSysRefId);
    }

    @JsonIgnore
    public boolean isPSSysRefIdDirty() {
        return this.contains(FIELD_PSSYSREFID);
    }

    @JsonIgnore
    public String getPSSysRefName() {
        Object objValue = this.get(FIELD_PSSYSREFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysrefname")
    public void setPSSysRefName(String pSSysRefName) {
        this.set(FIELD_PSSYSREFNAME, pSSysRefName);
    }

    @JsonIgnore
    public boolean isPSSysRefNameDirty() {
        return this.contains(FIELD_PSSYSREFNAME);
    }

    @JsonIgnore
    public String getPSSysSFPubId() {
        Object objValue = this.get(FIELD_PSSYSSFPUBID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssfpubid")
    public void setPSSysSFPubId(String pSSysSFPubId) {
        this.set(FIELD_PSSYSSFPUBID, pSSysSFPubId);
    }

    @JsonIgnore
    public boolean isPSSysSFPubIdDirty() {
        return this.contains(FIELD_PSSYSSFPUBID);
    }

    @JsonIgnore
    public String getPSSysSFPubName() {
        Object objValue = this.get(FIELD_PSSYSSFPUBNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssfpubname")
    public void setPSSysSFPubName(String pSSysSFPubName) {
        this.set(FIELD_PSSYSSFPUBNAME, pSSysSFPubName);
    }

    @JsonIgnore
    public boolean isPSSysSFPubNameDirty() {
        return this.contains(FIELD_PSSYSSFPUBNAME);
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
    public String getShortTag() {
        Object objValue = this.get(FIELD_SHORTTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="shorttag")
    public void setShortTag(String shortTag) {
        this.set(FIELD_SHORTTAG, shortTag);
    }

    @JsonIgnore
    public boolean isShortTagDirty() {
        return this.contains(FIELD_SHORTTAG);
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
    public String getSysRefType() {
        Object objValue = this.get(FIELD_SYSREFTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="sysreftype")
    public void setSysRefType(String sysRefType) {
        this.set(FIELD_SYSREFTYPE, sysRefType);
    }

    @JsonIgnore
    public boolean isSysRefTypeDirty() {
        return this.contains(FIELD_SYSREFTYPE);
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
    public String getUtilParams() {
        Object objValue = this.get(FIELD_UTILPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilparams")
    public void setUtilParams(String utilParams) {
        this.set(FIELD_UTILPARAMS, utilParams);
    }

    @JsonIgnore
    public boolean isUtilParamsDirty() {
        return this.contains(FIELD_UTILPARAMS);
    }

    @JsonIgnore
    public String getUtilTag() {
        Object objValue = this.get(FIELD_UTILTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utiltag")
    public void setUtilTag(String utilTag) {
        this.set(FIELD_UTILTAG, utilTag);
    }

    @JsonIgnore
    public boolean isUtilTagDirty() {
        return this.contains(FIELD_UTILTAG);
    }

    @JsonIgnore
    public String getUtilType() {
        Object objValue = this.get(FIELD_UTILTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utiltype")
    public void setUtilType(String utilType) {
        this.set(FIELD_UTILTYPE, utilType);
    }

    @JsonIgnore
    public boolean isUtilTypeDirty() {
        return this.contains(FIELD_UTILTYPE);
    }

    @JsonIgnore
    public String getSrfkey() {
        return this.getPSModuleId();
    }

    public void setSrfkey(String strValue) {
        this.setPSModuleId(strValue);
    }

    public List<PSCodeList> getPscodelists() {
        return this.pscodelists;
    }

    public void setPscodelists(List<PSCodeList> pscodelists) {
        this.pscodelists = pscodelists;
    }

    public List<PSDataEntity> getPsdataentities() {
        return this.psdataentities;
    }

    public void setPsdataentities(List<PSDataEntity> psdataentities) {
        this.psdataentities = psdataentities;
    }

    public List<PSDEActionTempl> getPsdeactiontempls() {
        return this.psdeactiontempls;
    }

    public void setPsdeactiontempls(List<PSDEActionTempl> psdeactiontempls) {
        this.psdeactiontempls = psdeactiontempls;
    }

    public List<PSDEFInputTip> getPsdefinputtips() {
        return this.psdefinputtips;
    }

    public void setPsdefinputtips(List<PSDEFInputTip> psdefinputtips) {
        this.psdefinputtips = psdefinputtips;
    }

    public List<PSSubSysServiceAPI> getPssubsysserviceapis() {
        return this.pssubsysserviceapis;
    }

    public void setPssubsysserviceapis(List<PSSubSysServiceAPI> pssubsysserviceapis) {
        this.pssubsysserviceapis = pssubsysserviceapis;
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

    public List<PSSysApp> getPssysapps() {
        return this.pssysapps;
    }

    public void setPssysapps(List<PSSysApp> pssysapps) {
        this.pssysapps = pssysapps;
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

    public List<PSSysCanvas> getPssyscanvas() {
        return this.pssyscanvas;
    }

    public void setPssyscanvas(List<PSSysCanvas> pssyscanvas) {
        this.pssyscanvas = pssyscanvas;
    }

    public List<PSSysChartTheme> getPssyschartthemes() {
        return this.pssyschartthemes;
    }

    public void setPssyschartthemes(List<PSSysChartTheme> pssyschartthemes) {
        this.pssyschartthemes = pssyschartthemes;
    }

    public List<PSSysCssCat> getPssyscsscats() {
        return this.pssyscsscats;
    }

    public void setPssyscsscats(List<PSSysCssCat> pssyscsscats) {
        this.pssyscsscats = pssyscsscats;
    }

    public List<PSSysCss> getPssyscsses() {
        return this.pssyscsses;
    }

    public void setPssyscsses(List<PSSysCss> pssyscsses) {
        this.pssyscsses = pssyscsses;
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

    public List<PSSysDynaModelCat> getPssysdynamodelcats() {
        return this.pssysdynamodelcats;
    }

    public void setPssysdynamodelcats(List<PSSysDynaModelCat> pssysdynamodelcats) {
        this.pssysdynamodelcats = pssysdynamodelcats;
    }

    public List<PSSysDynaModel> getPssysdynamodels() {
        return this.pssysdynamodels;
    }

    public void setPssysdynamodels(List<PSSysDynaModel> pssysdynamodels) {
        this.pssysdynamodels = pssysdynamodels;
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

    public List<PSSysMsgTempl> getPssysmsgtempls() {
        return this.pssysmsgtempls;
    }

    public void setPssysmsgtempls(List<PSSysMsgTempl> pssysmsgtempls) {
        this.pssysmsgtempls = pssysmsgtempls;
    }

    public List<PSSysOPPriv> getPssysopprivs() {
        return this.pssysopprivs;
    }

    public void setPssysopprivs(List<PSSysOPPriv> pssysopprivs) {
        this.pssysopprivs = pssysopprivs;
    }

    public List<PSSysPDTView> getPssyspdtviews() {
        return this.pssyspdtviews;
    }

    public void setPssyspdtviews(List<PSSysPDTView> pssyspdtviews) {
        this.pssyspdtviews = pssyspdtviews;
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

    public List<PSSysResource> getPssysresources() {
        return this.pssysresources;
    }

    public void setPssysresources(List<PSSysResource> pssysresources) {
        this.pssysresources = pssysresources;
    }

    public List<PSSysSAHandler> getPssyssahandlers() {
        return this.pssyssahandlers;
    }

    public void setPssyssahandlers(List<PSSysSAHandler> pssyssahandlers) {
        this.pssyssahandlers = pssyssahandlers;
    }

    public List<PSSysSampleValue> getPssyssamplevalues() {
        return this.pssyssamplevalues;
    }

    public void setPssyssamplevalues(List<PSSysSampleValue> pssyssamplevalues) {
        this.pssyssamplevalues = pssyssamplevalues;
    }

    public List<PSSysSearchScheme> getPssyssearchschemes() {
        return this.pssyssearchschemes;
    }

    public void setPssyssearchschemes(List<PSSysSearchScheme> pssyssearchschemes) {
        this.pssyssearchschemes = pssyssearchschemes;
    }

    public List<PSSysServiceAPI> getPssysserviceapis() {
        return this.pssysserviceapis;
    }

    public void setPssysserviceapis(List<PSSysServiceAPI> pssysserviceapis) {
        this.pssysserviceapis = pssysserviceapis;
    }

    public List<PSSysSFPlugin> getPssyssfplugins() {
        return this.pssyssfplugins;
    }

    public void setPssyssfplugins(List<PSSysSFPlugin> pssyssfplugins) {
        this.pssyssfplugins = pssyssfplugins;
    }

    public List<PSSysUniRes> getPssysunires() {
        return this.pssysunires;
    }

    public void setPssysunires(List<PSSysUniRes> pssysunires) {
        this.pssysunires = pssysunires;
    }

    public List<PSSysUserCase> getPssysusercases() {
        return this.pssysusercases;
    }

    public void setPssysusercases(List<PSSysUserCase> pssysusercases) {
        this.pssysusercases = pssysusercases;
    }

    public List<PSSysUserDR> getPssysuserdrs() {
        return this.pssysuserdrs;
    }

    public void setPssysuserdrs(List<PSSysUserDR> pssysuserdrs) {
        this.pssysuserdrs = pssysuserdrs;
    }

    public List<PSSysUserMode> getPssysusermodes() {
        return this.pssysusermodes;
    }

    public void setPssysusermodes(List<PSSysUserMode> pssysusermodes) {
        this.pssysusermodes = pssysusermodes;
    }

    public List<PSSysUtilDE> getPssysutildes() {
        return this.pssysutildes;
    }

    public void setPssysutildes(List<PSSysUtilDE> pssysutildes) {
        this.pssysutildes = pssysutildes;
    }

    public List<PSSysValueRule> getPssysvaluerules() {
        return this.pssysvaluerules;
    }

    public void setPssysvaluerules(List<PSSysValueRule> pssysvaluerules) {
        this.pssysvaluerules = pssysvaluerules;
    }

    public List<PSSysWFCat> getPssyswfcats() {
        return this.pssyswfcats;
    }

    public void setPssyswfcats(List<PSSysWFCat> pssyswfcats) {
        this.pssyswfcats = pssyswfcats;
    }

    public List<PSSysWFMode> getPssyswfmodes() {
        return this.pssyswfmodes;
    }

    public void setPssyswfmodes(List<PSSysWFMode> pssyswfmodes) {
        this.pssyswfmodes = pssyswfmodes;
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

    public List<PSSysCalendar> getPssyscalendars() {
        return this.pssyscalendars;
    }

    public void setPssyscalendars(List<PSSysCalendar> pssyscalendars) {
        this.pssyscalendars = pssyscalendars;
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

    public List<PSSysDashboard> getPssysdashboards() {
        return this.pssysdashboards;
    }

    public void setPssysdashboards(List<PSSysDashboard> pssysdashboards) {
        this.pssysdashboards = pssysdashboards;
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

    public List<PSSysSearchBar> getPssyssearchbars() {
        return this.pssyssearchbars;
    }

    public void setPssyssearchbars(List<PSSysSearchBar> pssyssearchbars) {
        this.pssyssearchbars = pssyssearchbars;
    }

    public List<PSSysSequence> getPssyssequences() {
        return this.pssyssequences;
    }

    public void setPssyssequences(List<PSSysSequence> pssyssequences) {
        this.pssyssequences = pssyssequences;
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

    public List<PSSysBIScheme> getPssysbischemes() {
        return this.pssysbischemes;
    }

    public void setPssysbischemes(List<PSSysBIScheme> pssysbischemes) {
        this.pssysbischemes = pssysbischemes;
    }

    public List<PSSysTestData> getPssystestdata() {
        return this.pssystestdata;
    }

    public void setPssystestdata(List<PSSysTestData> pssystestdata) {
        this.pssystestdata = pssystestdata;
    }

    public List<PSLanguageItem> getPslanguageitems() {
        return this.pslanguageitems;
    }

    public void setPslanguageitems(List<PSLanguageItem> pslanguageitems) {
        this.pslanguageitems = pslanguageitems;
    }

    public List<PSLanguageRes> getPslanguageres() {
        return this.pslanguageres;
    }

    public void setPslanguageres(List<PSLanguageRes> pslanguageres) {
        this.pslanguageres = pslanguageres;
    }

    public List<PSDEOPPriv> getPsdeopprivs() {
        return this.psdeopprivs;
    }

    public void setPsdeopprivs(List<PSDEOPPriv> psdeopprivs) {
        this.psdeopprivs = psdeopprivs;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (bFullMode && strName.equalsIgnoreCase("pscodelists")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdataentities")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdeactiontempls")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdefinputtips")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssubsysserviceapis")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssubviewtypes")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysactors")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysapps")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysbackservices")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysbdschemes")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssyscanvas")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssyschartthemes")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssyscsscats")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssyscsses")) {
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
        if (bFullMode && strName.equalsIgnoreCase("pssysdelogicnodes")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysdictcats")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysdynamodelcats")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysdynamodels")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssyseaischemes")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssyseditorstyles")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysermaps")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysimages")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysmsgqueues")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysmsgtargets")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysmsgtempls")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysopprivs")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssyspdtviews")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssyspfplugins")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysportletcats")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysresources")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssyssahandlers")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssyssamplevalues")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssyssearchschemes")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysserviceapis")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssyssfplugins")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysunires")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysusercases")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysuserdrs")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysusermodes")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysutildes")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysvaluerules")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssyswfcats")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssyswfmodes")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psthresholdgroups")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psviewmsggroups")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psviewmsgs")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pswfroles")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pswfworktimes")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psworkflows")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pswxaccounts")) {
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
        if (bFullMode && strName.equalsIgnoreCase("pssyscalendars")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssyscontentcats")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssyscounters")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysdashboards")) {
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
        if (bFullMode && strName.equalsIgnoreCase("pssyssearchbars")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssyssequences")) {
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
        if (bFullMode && strName.equalsIgnoreCase("pssysunistates")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysunits")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysusercasers")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysviewlogics")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysviewpanels")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdeuagroups")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psdeuiactions")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysbischemes")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssystestdata")) {
            return true;
        }
        if (strName.equalsIgnoreCase("pslanguageitems")) {
            return true;
        }
        if (strName.equalsIgnoreCase("pslanguageres")) {
            return true;
        }
        if (strName.equalsIgnoreCase("psdeopprivs")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("pscodelists")) {
            this.init();
            return this.pscodelists;
        }
        if (strName.equalsIgnoreCase("psdataentities")) {
            this.init();
            return this.psdataentities;
        }
        if (strName.equalsIgnoreCase("psdeactiontempls")) {
            this.init();
            return this.psdeactiontempls;
        }
        if (strName.equalsIgnoreCase("psdefinputtips")) {
            this.init();
            return this.psdefinputtips;
        }
        if (strName.equalsIgnoreCase("pssubsysserviceapis")) {
            this.init();
            return this.pssubsysserviceapis;
        }
        if (strName.equalsIgnoreCase("pssubviewtypes")) {
            this.init();
            return this.pssubviewtypes;
        }
        if (strName.equalsIgnoreCase("pssysactors")) {
            this.init();
            return this.pssysactors;
        }
        if (strName.equalsIgnoreCase("pssysapps")) {
            this.init();
            return this.pssysapps;
        }
        if (strName.equalsIgnoreCase("pssysbackservices")) {
            this.init();
            return this.pssysbackservices;
        }
        if (strName.equalsIgnoreCase("pssysbdschemes")) {
            this.init();
            return this.pssysbdschemes;
        }
        if (strName.equalsIgnoreCase("pssyscanvas")) {
            this.init();
            return this.pssyscanvas;
        }
        if (strName.equalsIgnoreCase("pssyschartthemes")) {
            this.init();
            return this.pssyschartthemes;
        }
        if (strName.equalsIgnoreCase("pssyscsscats")) {
            this.init();
            return this.pssyscsscats;
        }
        if (strName.equalsIgnoreCase("pssyscsses")) {
            this.init();
            return this.pssyscsses;
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
        if (strName.equalsIgnoreCase("pssysdelogicnodes")) {
            this.init();
            return this.pssysdelogicnodes;
        }
        if (strName.equalsIgnoreCase("pssysdictcats")) {
            this.init();
            return this.pssysdictcats;
        }
        if (strName.equalsIgnoreCase("pssysdynamodelcats")) {
            this.init();
            return this.pssysdynamodelcats;
        }
        if (strName.equalsIgnoreCase("pssysdynamodels")) {
            this.init();
            return this.pssysdynamodels;
        }
        if (strName.equalsIgnoreCase("pssyseaischemes")) {
            this.init();
            return this.pssyseaischemes;
        }
        if (strName.equalsIgnoreCase("pssyseditorstyles")) {
            this.init();
            return this.pssyseditorstyles;
        }
        if (strName.equalsIgnoreCase("pssysermaps")) {
            this.init();
            return this.pssysermaps;
        }
        if (strName.equalsIgnoreCase("pssysimages")) {
            this.init();
            return this.pssysimages;
        }
        if (strName.equalsIgnoreCase("pssysmsgqueues")) {
            this.init();
            return this.pssysmsgqueues;
        }
        if (strName.equalsIgnoreCase("pssysmsgtargets")) {
            this.init();
            return this.pssysmsgtargets;
        }
        if (strName.equalsIgnoreCase("pssysmsgtempls")) {
            this.init();
            return this.pssysmsgtempls;
        }
        if (strName.equalsIgnoreCase("pssysopprivs")) {
            this.init();
            return this.pssysopprivs;
        }
        if (strName.equalsIgnoreCase("pssyspdtviews")) {
            this.init();
            return this.pssyspdtviews;
        }
        if (strName.equalsIgnoreCase("pssyspfplugins")) {
            this.init();
            return this.pssyspfplugins;
        }
        if (strName.equalsIgnoreCase("pssysportletcats")) {
            this.init();
            return this.pssysportletcats;
        }
        if (strName.equalsIgnoreCase("pssysresources")) {
            this.init();
            return this.pssysresources;
        }
        if (strName.equalsIgnoreCase("pssyssahandlers")) {
            this.init();
            return this.pssyssahandlers;
        }
        if (strName.equalsIgnoreCase("pssyssamplevalues")) {
            this.init();
            return this.pssyssamplevalues;
        }
        if (strName.equalsIgnoreCase("pssyssearchschemes")) {
            this.init();
            return this.pssyssearchschemes;
        }
        if (strName.equalsIgnoreCase("pssysserviceapis")) {
            this.init();
            return this.pssysserviceapis;
        }
        if (strName.equalsIgnoreCase("pssyssfplugins")) {
            this.init();
            return this.pssyssfplugins;
        }
        if (strName.equalsIgnoreCase("pssysunires")) {
            this.init();
            return this.pssysunires;
        }
        if (strName.equalsIgnoreCase("pssysusercases")) {
            this.init();
            return this.pssysusercases;
        }
        if (strName.equalsIgnoreCase("pssysuserdrs")) {
            this.init();
            return this.pssysuserdrs;
        }
        if (strName.equalsIgnoreCase("pssysusermodes")) {
            this.init();
            return this.pssysusermodes;
        }
        if (strName.equalsIgnoreCase("pssysutildes")) {
            this.init();
            return this.pssysutildes;
        }
        if (strName.equalsIgnoreCase("pssysvaluerules")) {
            this.init();
            return this.pssysvaluerules;
        }
        if (strName.equalsIgnoreCase("pssyswfcats")) {
            this.init();
            return this.pssyswfcats;
        }
        if (strName.equalsIgnoreCase("pssyswfmodes")) {
            this.init();
            return this.pssyswfmodes;
        }
        if (strName.equalsIgnoreCase("psthresholdgroups")) {
            this.init();
            return this.psthresholdgroups;
        }
        if (strName.equalsIgnoreCase("psviewmsggroups")) {
            this.init();
            return this.psviewmsggroups;
        }
        if (strName.equalsIgnoreCase("psviewmsgs")) {
            this.init();
            return this.psviewmsgs;
        }
        if (strName.equalsIgnoreCase("pswfroles")) {
            this.init();
            return this.pswfroles;
        }
        if (strName.equalsIgnoreCase("pswfworktimes")) {
            this.init();
            return this.pswfworktimes;
        }
        if (strName.equalsIgnoreCase("psworkflows")) {
            this.init();
            return this.psworkflows;
        }
        if (strName.equalsIgnoreCase("pswxaccounts")) {
            this.init();
            return this.pswxaccounts;
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
        if (strName.equalsIgnoreCase("pssyscalendars")) {
            this.init();
            return this.pssyscalendars;
        }
        if (strName.equalsIgnoreCase("pssyscontentcats")) {
            this.init();
            return this.pssyscontentcats;
        }
        if (strName.equalsIgnoreCase("pssyscounters")) {
            this.init();
            return this.pssyscounters;
        }
        if (strName.equalsIgnoreCase("pssysdashboards")) {
            this.init();
            return this.pssysdashboards;
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
        if (strName.equalsIgnoreCase("pssyssearchbars")) {
            this.init();
            return this.pssyssearchbars;
        }
        if (strName.equalsIgnoreCase("pssyssequences")) {
            this.init();
            return this.pssyssequences;
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
        if (strName.equalsIgnoreCase("pssysviewlogics")) {
            this.init();
            return this.pssysviewlogics;
        }
        if (strName.equalsIgnoreCase("pssysviewpanels")) {
            this.init();
            return this.pssysviewpanels;
        }
        if (strName.equalsIgnoreCase("psdeuagroups")) {
            this.init();
            return this.psdeuagroups;
        }
        if (strName.equalsIgnoreCase("psdeuiactions")) {
            this.init();
            return this.psdeuiactions;
        }
        if (strName.equalsIgnoreCase("pssysbischemes")) {
            this.init();
            return this.pssysbischemes;
        }
        if (strName.equalsIgnoreCase("pssystestdata")) {
            this.init();
            return this.pssystestdata;
        }
        if (strName.equalsIgnoreCase("pslanguageitems")) {
            this.init();
            return this.pslanguageitems;
        }
        if (strName.equalsIgnoreCase("pslanguageres")) {
            this.init();
            return this.pslanguageres;
        }
        if (strName.equalsIgnoreCase("psdeopprivs")) {
            this.init();
            return this.psdeopprivs;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSMODULE";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSModule item = (PSModule)MAPPER.readValue(new File(strJsonFilePath), PSModule.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSModule) {
            PSModule dst = (PSModule)target;
            if (!bSimple) {
                PSModelBase newitem;
                if (this.getPslanguageitems() != null) {
                    ArrayList<PSLanguageItem> pslanguageitems = new ArrayList<PSLanguageItem>();
                    for (PSLanguageItem pSLanguageItem : this.getPslanguageitems()) {
                        if (bDeepMode) {
                            newitem = new PSLanguageItem();
                            pSLanguageItem.to(newitem, false, bDeepMode);
                            pslanguageitems.add((PSLanguageItem)newitem);
                            continue;
                        }
                        pslanguageitems.add(pSLanguageItem);
                    }
                    dst.setPslanguageitems(pslanguageitems);
                }
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
        if (source instanceof PSModule) {
            PSModule src = (PSModule)source;
            if (!bSimple) {
                PSModelBase newItem;
                if (src.getPslanguageitems() != null) {
                    ArrayList<PSLanguageItem> pslanguageitems = new ArrayList<PSLanguageItem>();
                    for (PSLanguageItem pSLanguageItem : src.getPslanguageitems()) {
                        if (bDeepMode) {
                            newItem = new PSLanguageItem();
                            ((PSLanguageItem)newItem).from(pSLanguageItem, false, bDeepMode);
                            pslanguageitems.add((PSLanguageItem)newItem);
                            continue;
                        }
                        pslanguageitems.add(pSLanguageItem);
                    }
                    this.setPslanguageitems(pslanguageitems);
                }
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

