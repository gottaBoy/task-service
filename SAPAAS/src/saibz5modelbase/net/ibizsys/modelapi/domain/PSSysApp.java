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
import net.ibizsys.modelapi.domain.PSAppFunc;
import net.ibizsys.modelapi.domain.PSAppLan;
import net.ibizsys.modelapi.domain.PSAppLocalDE;
import net.ibizsys.modelapi.domain.PSAppLogic;
import net.ibizsys.modelapi.domain.PSAppMenu;
import net.ibizsys.modelapi.domain.PSAppModule;
import net.ibizsys.modelapi.domain.PSAppPDTView;
import net.ibizsys.modelapi.domain.PSAppPkg;
import net.ibizsys.modelapi.domain.PSAppPortlet;
import net.ibizsys.modelapi.domain.PSAppResource;
import net.ibizsys.modelapi.domain.PSAppStoryBoard;
import net.ibizsys.modelapi.domain.PSAppTitleBar;
import net.ibizsys.modelapi.domain.PSAppUIStyle;
import net.ibizsys.modelapi.domain.PSAppUITheme;
import net.ibizsys.modelapi.domain.PSAppUserMode;
import net.ibizsys.modelapi.domain.PSAppUtil;
import net.ibizsys.modelapi.domain.PSAppUtilPage;
import net.ibizsys.modelapi.domain.PSAppView;
import net.ibizsys.modelapi.domain.PSAppWF;
import net.ibizsys.modelapi.domain.PSMobAppPack;
import net.ibizsys.modelapi.domain.PSMobAppStartPage;
import net.ibizsys.modelapi.domain.PSSysTestPrj;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSSysApp
extends PSModelBase {
    public static final String FIELD_ACMINCHARS = "acminchars";
    public static final String FIELD_APPFOLDER = "appfolder";
    public static final String FIELD_APPMODE = "appmode";
    public static final String FIELD_APPPKGNAME = "apppkgname";
    public static final String FIELD_APPSN = "appsn";
    public static final String FIELD_APPTAG = "apptag";
    public static final String FIELD_APPTAG2 = "apptag2";
    public static final String FIELD_APPTAG3 = "apptag3";
    public static final String FIELD_APPTAG4 = "apptag4";
    public static final String FIELD_AUTOADDAPPVIEW = "autoaddappview";
    public static final String FIELD_BOTTOMINFO = "bottominfo";
    public static final String FIELD_BTNNOPRIVDM = "btnnoprivdm";
    public static final String FIELD_CAPTION = "caption";
    public static final String FIELD_CODEFOLDER = "codefolder";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DEFAULTPORT = "defaultport";
    public static final String FIELD_DEFAULTPUB = "defaultpub";
    public static final String FIELD_DEPSSYSSFPLUGINID = "depssyssfpluginid";
    public static final String FIELD_DEPSSYSSFPLUGINNAME = "depssyssfpluginname";
    public static final String FIELD_ENABLEC12TOC24 = "enablec12toc24";
    public static final String FIELD_ENABLEDYNASYS = "enabledynasys";
    public static final String FIELD_ENABLESTORYBOARD = "enablestoryboard";
    public static final String FIELD_ENALOCALSERVICE = "enalocalservice";
    public static final String FIELD_FIEMPTYTEXT = "fiemptytext";
    public static final String FIELD_FINOPRIVDM = "finoprivdm";
    public static final String FIELD_FIUPDATEPRIVTAG = "fiupdateprivtag";
    public static final String FIELD_GCNOPRIVDM = "gcnoprivdm";
    public static final String FIELD_GRIDCOLENABLEFILTER = "gridcolenablefilter";
    public static final String FIELD_GRIDCOLENABLELINK = "gridcolenablelink";
    public static final String FIELD_GRIDENABLECUSTOMIZED = "gridenablecustomized";
    public static final String FIELD_GRIDFORCEFIT = "gridforcefit";
    public static final String FIELD_GRIDROWACTIVEMODE = "gridrowactivemode";
    public static final String FIELD_HEADERINFO = "headerinfo";
    public static final String FIELD_ICONFILE = "iconfile";
    public static final String FIELD_LOGICNAME = "logicname";
    public static final String FIELD_MAINMENUSIDE = "mainmenuside";
    public static final String FIELD_MDCTRLEMPTYTEXT = "mdctrlemptytext";
    public static final String FIELD_MDCTRLEMPTYTEXTPSLANRESID = "mdctrlemptytextpslanresid";
    public static final String FIELD_MDCTRLEMPTYTEXTPSLANRESNAME = "mdctrlemptytextpslanresname";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORIENTATIONMODE = "orientationmode";
    public static final String FIELD_PFSTYLEPARAM = "pfstyleparam";
    public static final String FIELD_PREVENTXSS = "preventxss";
    public static final String FIELD_PSAPPTYPEID = "psapptypeid";
    public static final String FIELD_PSAPPTYPENAME = "psapptypename";
    public static final String FIELD_PSCTRLLOGICGROUPID = "psctrllogicgroupid";
    public static final String FIELD_PSCTRLLOGICGROUPNAME = "psctrllogicgroupname";
    public static final String FIELD_PSMODULEID = "psmoduleid";
    public static final String FIELD_PSMODULENAME = "psmodulename";
    public static final String FIELD_PSPFCDNID = "pspfcdnid";
    public static final String FIELD_PSPFCDNNAME = "pspfcdnname";
    public static final String FIELD_PSPFID = "pspfid";
    public static final String FIELD_PSPFNAME = "pspfname";
    public static final String FIELD_PSPFSTYLEID = "pspfstyleid";
    public static final String FIELD_PSPFSTYLENAME = "pspfstylename";
    public static final String FIELD_PSSTUDIOTHEMEID = "psstudiothemeid";
    public static final String FIELD_PSSTUDIOTHEMENAME = "psstudiothemename";
    public static final String FIELD_PSSYSAPPID = "pssysappid";
    public static final String FIELD_PSSYSAPPNAME = "pssysappname";
    public static final String FIELD_PSSYSCSSID = "pssyscssid";
    public static final String FIELD_PSSYSCSSNAME = "pssyscssname";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    public static final String FIELD_PSSYSIMAGEID = "pssysimageid";
    public static final String FIELD_PSSYSIMAGENAME = "pssysimagename";
    public static final String FIELD_PSSYSSERVICEAPIID = "pssysserviceapiid";
    public static final String FIELD_PSSYSSERVICEAPINAME = "pssysserviceapiname";
    public static final String FIELD_PSSYSSFPLUGINID = "pssyssfpluginid";
    public static final String FIELD_PSSYSSFPLUGINNAME = "pssyssfpluginname";
    public static final String FIELD_PSSYSSFPUBID = "pssyssfpubid";
    public static final String FIELD_PSSYSSFPUBNAME = "pssyssfpubname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_PSVIEWMSGGROUPID = "psviewmsggroupid";
    public static final String FIELD_PSVIEWMSGGROUPNAME = "psviewmsggroupname";
    public static final String FIELD_PUBREFVIEWONLY = "pubrefviewonly";
    public static final String FIELD_PUBSYSREFVIEWONLY = "pubsysrefviewonly";
    public static final String FIELD_REMOVEFLAG = "removeflag";
    public static final String FIELD_SERVICECODENAME = "servicecodename";
    public static final String FIELD_STARTPAGEFILE = "startpagefile";
    public static final String FIELD_SUBCAPTION = "subcaption";
    public static final String FIELD_TITLE = "title";
    public static final String FIELD_UACLOGIN = "uaclogin";
    public static final String FIELD_UISTYLE = "uistyle";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERPARAMS = "userparams";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";
    private List<PSAppModule> psappmodules;
    private List<PSSysTestPrj> pssystestprjs;
    private List<PSAppLocalDE> psapplocaldes;
    private List<PSAppMenu> psappmenus;
    private List<PSAppResource> psappresources;
    private List<PSAppStoryBoard> psappstoryboards;
    private List<PSAppTitleBar> psapptitlebars;
    private List<PSAppView> psappviews;
    private List<PSAppFunc> psappfuncs;
    private List<PSAppLan> psapplans;
    private List<PSAppPDTView> psapppdtviews;
    private List<PSAppPortlet> psappportlets;
    private List<PSAppUIStyle> psappuistyles;
    private List<PSAppUITheme> psappuithemes;
    private List<PSAppUserMode> psappusermodes;
    private List<PSAppUtilPage> psapputilpages;
    private List<PSMobAppPack> psmobapppacks;
    private List<PSMobAppStartPage> psmobappstartpages;
    private List<PSAppLogic> psapplogics;
    private List<PSAppPkg> psapppkgs;
    private List<PSAppUtil> psapputils;
    private List<PSAppWF> psappwfs;

    @JsonIgnore
    public Integer getACMinChars() {
        Object objValue = this.get(FIELD_ACMINCHARS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="acminchars")
    public void setACMinChars(Integer aCMinChars) {
        this.set(FIELD_ACMINCHARS, aCMinChars);
    }

    @JsonIgnore
    public boolean isACMinCharsDirty() {
        return this.contains(FIELD_ACMINCHARS);
    }

    @JsonIgnore
    public String getAppFolder() {
        Object objValue = this.get(FIELD_APPFOLDER);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="appfolder")
    public void setAppFolder(String appFolder) {
        this.set(FIELD_APPFOLDER, appFolder);
    }

    @JsonIgnore
    public boolean isAppFolderDirty() {
        return this.contains(FIELD_APPFOLDER);
    }

    @JsonIgnore
    public String getAppMode() {
        Object objValue = this.get(FIELD_APPMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="appmode")
    public void setAppMode(String appMode) {
        this.set(FIELD_APPMODE, appMode);
    }

    @JsonIgnore
    public boolean isAppModeDirty() {
        return this.contains(FIELD_APPMODE);
    }

    @JsonIgnore
    public String getAppPKGName() {
        Object objValue = this.get(FIELD_APPPKGNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="apppkgname")
    public void setAppPKGName(String appPKGName) {
        this.set(FIELD_APPPKGNAME, appPKGName);
    }

    @JsonIgnore
    public boolean isAppPKGNameDirty() {
        return this.contains(FIELD_APPPKGNAME);
    }

    @JsonIgnore
    public String getAppSN() {
        Object objValue = this.get(FIELD_APPSN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="appsn")
    public void setAppSN(String appSN) {
        this.set(FIELD_APPSN, appSN);
    }

    @JsonIgnore
    public boolean isAppSNDirty() {
        return this.contains(FIELD_APPSN);
    }

    @JsonIgnore
    public String getAppTag() {
        Object objValue = this.get(FIELD_APPTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="apptag")
    public void setAppTag(String appTag) {
        this.set(FIELD_APPTAG, appTag);
    }

    @JsonIgnore
    public boolean isAppTagDirty() {
        return this.contains(FIELD_APPTAG);
    }

    @JsonIgnore
    public String getAppTag2() {
        Object objValue = this.get(FIELD_APPTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="apptag2")
    public void setAppTag2(String appTag2) {
        this.set(FIELD_APPTAG2, appTag2);
    }

    @JsonIgnore
    public boolean isAppTag2Dirty() {
        return this.contains(FIELD_APPTAG2);
    }

    @JsonIgnore
    public String getAppTag3() {
        Object objValue = this.get(FIELD_APPTAG3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="apptag3")
    public void setAppTag3(String appTag3) {
        this.set(FIELD_APPTAG3, appTag3);
    }

    @JsonIgnore
    public boolean isAppTag3Dirty() {
        return this.contains(FIELD_APPTAG3);
    }

    @JsonIgnore
    public String getAppTag4() {
        Object objValue = this.get(FIELD_APPTAG4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="apptag4")
    public void setAppTag4(String appTag4) {
        this.set(FIELD_APPTAG4, appTag4);
    }

    @JsonIgnore
    public boolean isAppTag4Dirty() {
        return this.contains(FIELD_APPTAG4);
    }

    @JsonIgnore
    public Integer getAutoAddAppView() {
        Object objValue = this.get(FIELD_AUTOADDAPPVIEW);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="autoaddappview")
    public void setAutoAddAppView(Integer autoAddAppView) {
        this.set(FIELD_AUTOADDAPPVIEW, autoAddAppView);
    }

    @JsonIgnore
    public boolean isAutoAddAppViewDirty() {
        return this.contains(FIELD_AUTOADDAPPVIEW);
    }

    @JsonIgnore
    public String getBottomInfo() {
        Object objValue = this.get(FIELD_BOTTOMINFO);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="bottominfo")
    public void setBottomInfo(String bottomInfo) {
        this.set(FIELD_BOTTOMINFO, bottomInfo);
    }

    @JsonIgnore
    public boolean isBottomInfoDirty() {
        return this.contains(FIELD_BOTTOMINFO);
    }

    @JsonIgnore
    public Integer getBtnNoPrivDM() {
        Object objValue = this.get(FIELD_BTNNOPRIVDM);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="btnnoprivdm")
    public void setBtnNoPrivDM(Integer btnNoPrivDM) {
        this.set(FIELD_BTNNOPRIVDM, btnNoPrivDM);
    }

    @JsonIgnore
    public boolean isBtnNoPrivDMDirty() {
        return this.contains(FIELD_BTNNOPRIVDM);
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
    public String getCodeFolder() {
        Object objValue = this.get(FIELD_CODEFOLDER);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="codefolder")
    public void setCodeFolder(String codeFolder) {
        this.set(FIELD_CODEFOLDER, codeFolder);
    }

    @JsonIgnore
    public boolean isCodeFolderDirty() {
        return this.contains(FIELD_CODEFOLDER);
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
    public Integer getDefaultPort() {
        Object objValue = this.get(FIELD_DEFAULTPORT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="defaultport")
    public void setDefaultPort(Integer defaultPort) {
        this.set(FIELD_DEFAULTPORT, defaultPort);
    }

    @JsonIgnore
    public boolean isDefaultPortDirty() {
        return this.contains(FIELD_DEFAULTPORT);
    }

    @JsonIgnore
    public Integer getDefaultPub() {
        Object objValue = this.get(FIELD_DEFAULTPUB);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="defaultpub")
    public void setDefaultPub(Integer defaultPub) {
        this.set(FIELD_DEFAULTPUB, defaultPub);
    }

    @JsonIgnore
    public boolean isDefaultPubDirty() {
        return this.contains(FIELD_DEFAULTPUB);
    }

    @JsonIgnore
    public String getDEPSSysSFPluginId() {
        Object objValue = this.get(FIELD_DEPSSYSSFPLUGINID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="depssyssfpluginid")
    public void setDEPSSysSFPluginId(String dEPSSysSFPluginId) {
        this.set(FIELD_DEPSSYSSFPLUGINID, dEPSSysSFPluginId);
    }

    @JsonIgnore
    public boolean isDEPSSysSFPluginIdDirty() {
        return this.contains(FIELD_DEPSSYSSFPLUGINID);
    }

    @JsonIgnore
    public String getDEPSSysSFPluginName() {
        Object objValue = this.get(FIELD_DEPSSYSSFPLUGINNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="depssyssfpluginname")
    public void setDEPSSysSFPluginName(String dEPSSysSFPluginName) {
        this.set(FIELD_DEPSSYSSFPLUGINNAME, dEPSSysSFPluginName);
    }

    @JsonIgnore
    public boolean isDEPSSysSFPluginNameDirty() {
        return this.contains(FIELD_DEPSSYSSFPLUGINNAME);
    }

    @JsonIgnore
    public Integer getEnableC12ToC24() {
        Object objValue = this.get(FIELD_ENABLEC12TOC24);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablec12toc24")
    public void setEnableC12ToC24(Integer enableC12ToC24) {
        this.set(FIELD_ENABLEC12TOC24, enableC12ToC24);
    }

    @JsonIgnore
    public boolean isEnableC12ToC24Dirty() {
        return this.contains(FIELD_ENABLEC12TOC24);
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
    public Integer getEnableStoryBoard() {
        Object objValue = this.get(FIELD_ENABLESTORYBOARD);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablestoryboard")
    public void setEnableStoryBoard(Integer enableStoryBoard) {
        this.set(FIELD_ENABLESTORYBOARD, enableStoryBoard);
    }

    @JsonIgnore
    public boolean isEnableStoryBoardDirty() {
        return this.contains(FIELD_ENABLESTORYBOARD);
    }

    @JsonIgnore
    public Integer getEnaLocalService() {
        Object objValue = this.get(FIELD_ENALOCALSERVICE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enalocalservice")
    public void setEnaLocalService(Integer enaLocalService) {
        this.set(FIELD_ENALOCALSERVICE, enaLocalService);
    }

    @JsonIgnore
    public boolean isEnaLocalServiceDirty() {
        return this.contains(FIELD_ENALOCALSERVICE);
    }

    @JsonIgnore
    public String getFIEmptyText() {
        Object objValue = this.get(FIELD_FIEMPTYTEXT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="fiemptytext")
    public void setFIEmptyText(String fIEmptyText) {
        this.set(FIELD_FIEMPTYTEXT, fIEmptyText);
    }

    @JsonIgnore
    public boolean isFIEmptyTextDirty() {
        return this.contains(FIELD_FIEMPTYTEXT);
    }

    @JsonIgnore
    public Integer getFINoPrivDM() {
        Object objValue = this.get(FIELD_FINOPRIVDM);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="finoprivdm")
    public void setFINoPrivDM(Integer fINoPrivDM) {
        this.set(FIELD_FINOPRIVDM, fINoPrivDM);
    }

    @JsonIgnore
    public boolean isFINoPrivDMDirty() {
        return this.contains(FIELD_FINOPRIVDM);
    }

    @JsonIgnore
    public Integer getFIUpdatePrivTag() {
        Object objValue = this.get(FIELD_FIUPDATEPRIVTAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="fiupdateprivtag")
    public void setFIUpdatePrivTag(Integer fIUpdatePrivTag) {
        this.set(FIELD_FIUPDATEPRIVTAG, fIUpdatePrivTag);
    }

    @JsonIgnore
    public boolean isFIUpdatePrivTagDirty() {
        return this.contains(FIELD_FIUPDATEPRIVTAG);
    }

    @JsonIgnore
    public Integer getGCNoPrivDM() {
        Object objValue = this.get(FIELD_GCNOPRIVDM);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="gcnoprivdm")
    public void setGCNoPrivDM(Integer gCNoPrivDM) {
        this.set(FIELD_GCNOPRIVDM, gCNoPrivDM);
    }

    @JsonIgnore
    public boolean isGCNoPrivDMDirty() {
        return this.contains(FIELD_GCNOPRIVDM);
    }

    @JsonIgnore
    public Integer getGridColEnableFilter() {
        Object objValue = this.get(FIELD_GRIDCOLENABLEFILTER);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="gridcolenablefilter")
    public void setGridColEnableFilter(Integer gridColEnableFilter) {
        this.set(FIELD_GRIDCOLENABLEFILTER, gridColEnableFilter);
    }

    @JsonIgnore
    public boolean isGridColEnableFilterDirty() {
        return this.contains(FIELD_GRIDCOLENABLEFILTER);
    }

    @JsonIgnore
    public Integer getGridColEnableLink() {
        Object objValue = this.get(FIELD_GRIDCOLENABLELINK);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="gridcolenablelink")
    public void setGridColEnableLink(Integer gridColEnableLink) {
        this.set(FIELD_GRIDCOLENABLELINK, gridColEnableLink);
    }

    @JsonIgnore
    public boolean isGridColEnableLinkDirty() {
        return this.contains(FIELD_GRIDCOLENABLELINK);
    }

    @JsonIgnore
    public Integer getGridEnableCustomized() {
        Object objValue = this.get(FIELD_GRIDENABLECUSTOMIZED);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="gridenablecustomized")
    public void setGridEnableCustomized(Integer gridEnableCustomized) {
        this.set(FIELD_GRIDENABLECUSTOMIZED, gridEnableCustomized);
    }

    @JsonIgnore
    public boolean isGridEnableCustomizedDirty() {
        return this.contains(FIELD_GRIDENABLECUSTOMIZED);
    }

    @JsonIgnore
    public Integer getGridForceFit() {
        Object objValue = this.get(FIELD_GRIDFORCEFIT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="gridforcefit")
    public void setGridForceFit(Integer gridForceFit) {
        this.set(FIELD_GRIDFORCEFIT, gridForceFit);
    }

    @JsonIgnore
    public boolean isGridForceFitDirty() {
        return this.contains(FIELD_GRIDFORCEFIT);
    }

    @JsonIgnore
    public Integer getGridRowActiveMode() {
        Object objValue = this.get(FIELD_GRIDROWACTIVEMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="gridrowactivemode")
    public void setGridRowActiveMode(Integer gridRowActiveMode) {
        this.set(FIELD_GRIDROWACTIVEMODE, gridRowActiveMode);
    }

    @JsonIgnore
    public boolean isGridRowActiveModeDirty() {
        return this.contains(FIELD_GRIDROWACTIVEMODE);
    }

    @JsonIgnore
    public String getHeaderInfo() {
        Object objValue = this.get(FIELD_HEADERINFO);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="headerinfo")
    public void setHeaderInfo(String headerInfo) {
        this.set(FIELD_HEADERINFO, headerInfo);
    }

    @JsonIgnore
    public boolean isHeaderInfoDirty() {
        return this.contains(FIELD_HEADERINFO);
    }

    @JsonIgnore
    public String getIconFile() {
        Object objValue = this.get(FIELD_ICONFILE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="iconfile")
    public void setIconFile(String iconFile) {
        this.set(FIELD_ICONFILE, iconFile);
    }

    @JsonIgnore
    public boolean isIconFileDirty() {
        return this.contains(FIELD_ICONFILE);
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
    public String getMainMenuSide() {
        Object objValue = this.get(FIELD_MAINMENUSIDE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mainmenuside")
    public void setMainMenuSide(String mainMenuSide) {
        this.set(FIELD_MAINMENUSIDE, mainMenuSide);
    }

    @JsonIgnore
    public boolean isMainMenuSideDirty() {
        return this.contains(FIELD_MAINMENUSIDE);
    }

    @JsonIgnore
    public String getMDCtrlEmptyText() {
        Object objValue = this.get(FIELD_MDCTRLEMPTYTEXT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mdctrlemptytext")
    public void setMDCtrlEmptyText(String mDCtrlEmptyText) {
        this.set(FIELD_MDCTRLEMPTYTEXT, mDCtrlEmptyText);
    }

    @JsonIgnore
    public boolean isMDCtrlEmptyTextDirty() {
        return this.contains(FIELD_MDCTRLEMPTYTEXT);
    }

    @JsonIgnore
    public String getMDCtrlEmptyTextPSLanResId() {
        Object objValue = this.get(FIELD_MDCTRLEMPTYTEXTPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mdctrlemptytextpslanresid")
    public void setMDCtrlEmptyTextPSLanResId(String mDCtrlEmptyTextPSLanResId) {
        this.set(FIELD_MDCTRLEMPTYTEXTPSLANRESID, mDCtrlEmptyTextPSLanResId);
    }

    @JsonIgnore
    public boolean isMDCtrlEmptyTextPSLanResIdDirty() {
        return this.contains(FIELD_MDCTRLEMPTYTEXTPSLANRESID);
    }

    @JsonIgnore
    public String getMDCtrlEmptyTextPSLanResName() {
        Object objValue = this.get(FIELD_MDCTRLEMPTYTEXTPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mdctrlemptytextpslanresname")
    public void setMDCtrlEmptyTextPSLanResName(String mDCtrlEmptyTextPSLanResName) {
        this.set(FIELD_MDCTRLEMPTYTEXTPSLANRESNAME, mDCtrlEmptyTextPSLanResName);
    }

    @JsonIgnore
    public boolean isMDCtrlEmptyTextPSLanResNameDirty() {
        return this.contains(FIELD_MDCTRLEMPTYTEXTPSLANRESNAME);
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
    public String getOrientationMode() {
        Object objValue = this.get(FIELD_ORIENTATIONMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="orientationmode")
    public void setOrientationMode(String orientationMode) {
        this.set(FIELD_ORIENTATIONMODE, orientationMode);
    }

    @JsonIgnore
    public boolean isOrientationModeDirty() {
        return this.contains(FIELD_ORIENTATIONMODE);
    }

    @JsonIgnore
    public String getPFStyleParam() {
        Object objValue = this.get(FIELD_PFSTYLEPARAM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pfstyleparam")
    public void setPFStyleParam(String pFStyleParam) {
        this.set(FIELD_PFSTYLEPARAM, pFStyleParam);
    }

    @JsonIgnore
    public boolean isPFStyleParamDirty() {
        return this.contains(FIELD_PFSTYLEPARAM);
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
    public String getPSAppTypeId() {
        Object objValue = this.get(FIELD_PSAPPTYPEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psapptypeid")
    public void setPSAppTypeId(String pSAppTypeId) {
        this.set(FIELD_PSAPPTYPEID, pSAppTypeId);
    }

    @JsonIgnore
    public boolean isPSAppTypeIdDirty() {
        return this.contains(FIELD_PSAPPTYPEID);
    }

    @JsonIgnore
    public String getPSAppTypeName() {
        Object objValue = this.get(FIELD_PSAPPTYPENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psapptypename")
    public void setPSAppTypeName(String pSAppTypeName) {
        this.set(FIELD_PSAPPTYPENAME, pSAppTypeName);
    }

    @JsonIgnore
    public boolean isPSAppTypeNameDirty() {
        return this.contains(FIELD_PSAPPTYPENAME);
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
    public String getPSPFCDNId() {
        Object objValue = this.get(FIELD_PSPFCDNID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pspfcdnid")
    public void setPSPFCDNId(String pSPFCDNId) {
        this.set(FIELD_PSPFCDNID, pSPFCDNId);
    }

    @JsonIgnore
    public boolean isPSPFCDNIdDirty() {
        return this.contains(FIELD_PSPFCDNID);
    }

    @JsonIgnore
    public String getPSPFCDNName() {
        Object objValue = this.get(FIELD_PSPFCDNNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pspfcdnname")
    public void setPSPFCDNName(String pSPFCDNName) {
        this.set(FIELD_PSPFCDNNAME, pSPFCDNName);
    }

    @JsonIgnore
    public boolean isPSPFCDNNameDirty() {
        return this.contains(FIELD_PSPFCDNNAME);
    }

    @JsonIgnore
    public String getPSPFId() {
        Object objValue = this.get(FIELD_PSPFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pspfid")
    public void setPSPFId(String pSPFId) {
        this.set(FIELD_PSPFID, pSPFId);
    }

    @JsonIgnore
    public boolean isPSPFIdDirty() {
        return this.contains(FIELD_PSPFID);
    }

    @JsonIgnore
    public String getPSPFName() {
        Object objValue = this.get(FIELD_PSPFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pspfname")
    public void setPSPFName(String pSPFName) {
        this.set(FIELD_PSPFNAME, pSPFName);
    }

    @JsonIgnore
    public boolean isPSPFNameDirty() {
        return this.contains(FIELD_PSPFNAME);
    }

    @JsonIgnore
    public String getPSPFStyleId() {
        Object objValue = this.get(FIELD_PSPFSTYLEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pspfstyleid")
    public void setPSPFStyleId(String pSPFStyleId) {
        this.set(FIELD_PSPFSTYLEID, pSPFStyleId);
    }

    @JsonIgnore
    public boolean isPSPFStyleIdDirty() {
        return this.contains(FIELD_PSPFSTYLEID);
    }

    @JsonIgnore
    public String getPSPFStyleName() {
        Object objValue = this.get(FIELD_PSPFSTYLENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pspfstylename")
    public void setPSPFStyleName(String pSPFStyleName) {
        this.set(FIELD_PSPFSTYLENAME, pSPFStyleName);
    }

    @JsonIgnore
    public boolean isPSPFStyleNameDirty() {
        return this.contains(FIELD_PSPFSTYLENAME);
    }

    @JsonIgnore
    public String getPSStudioThemeId() {
        Object objValue = this.get(FIELD_PSSTUDIOTHEMEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psstudiothemeid")
    public void setPSStudioThemeId(String pSStudioThemeId) {
        this.set(FIELD_PSSTUDIOTHEMEID, pSStudioThemeId);
    }

    @JsonIgnore
    public boolean isPSStudioThemeIdDirty() {
        return this.contains(FIELD_PSSTUDIOTHEMEID);
    }

    @JsonIgnore
    public String getPSStudioThemeName() {
        Object objValue = this.get(FIELD_PSSTUDIOTHEMENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psstudiothemename")
    public void setPSStudioThemeName(String pSStudioThemeName) {
        this.set(FIELD_PSSTUDIOTHEMENAME, pSStudioThemeName);
    }

    @JsonIgnore
    public boolean isPSStudioThemeNameDirty() {
        return this.contains(FIELD_PSSTUDIOTHEMENAME);
    }

    @JsonIgnore
    public String getPSSysAppId() {
        Object objValue = this.get(FIELD_PSSYSAPPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysappid")
    public void setPSSysAppId(String pSSysAppId) {
        this.set(FIELD_PSSYSAPPID, pSSysAppId);
    }

    @JsonIgnore
    public boolean isPSSysAppIdDirty() {
        return this.contains(FIELD_PSSYSAPPID);
    }

    @JsonIgnore
    public String getPSSysAppName() {
        Object objValue = this.get(FIELD_PSSYSAPPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysappname")
    public void setPSSysAppName(String pSSysAppName) {
        this.set(FIELD_PSSYSAPPNAME, pSSysAppName);
    }

    @JsonIgnore
    public boolean isPSSysAppNameDirty() {
        return this.contains(FIELD_PSSYSAPPNAME);
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
    public String getPSSysServiceAPIId() {
        Object objValue = this.get(FIELD_PSSYSSERVICEAPIID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysserviceapiid")
    public void setPSSysServiceAPIId(String pSSysServiceAPIId) {
        this.set(FIELD_PSSYSSERVICEAPIID, pSSysServiceAPIId);
    }

    @JsonIgnore
    public boolean isPSSysServiceAPIIdDirty() {
        return this.contains(FIELD_PSSYSSERVICEAPIID);
    }

    @JsonIgnore
    public String getPSSysServiceAPIName() {
        Object objValue = this.get(FIELD_PSSYSSERVICEAPINAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysserviceapiname")
    public void setPSSysServiceAPIName(String pSSysServiceAPIName) {
        this.set(FIELD_PSSYSSERVICEAPINAME, pSSysServiceAPIName);
    }

    @JsonIgnore
    public boolean isPSSysServiceAPINameDirty() {
        return this.contains(FIELD_PSSYSSERVICEAPINAME);
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
    public String getPSViewMsgGroupId() {
        Object objValue = this.get(FIELD_PSVIEWMSGGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psviewmsggroupid")
    public void setPSViewMsgGroupId(String pSViewMsgGroupId) {
        this.set(FIELD_PSVIEWMSGGROUPID, pSViewMsgGroupId);
    }

    @JsonIgnore
    public boolean isPSViewMsgGroupIdDirty() {
        return this.contains(FIELD_PSVIEWMSGGROUPID);
    }

    @JsonIgnore
    public String getPSViewMsgGroupName() {
        Object objValue = this.get(FIELD_PSVIEWMSGGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psviewmsggroupname")
    public void setPSViewMsgGroupName(String pSViewMsgGroupName) {
        this.set(FIELD_PSVIEWMSGGROUPNAME, pSViewMsgGroupName);
    }

    @JsonIgnore
    public boolean isPSViewMsgGroupNameDirty() {
        return this.contains(FIELD_PSVIEWMSGGROUPNAME);
    }

    @JsonIgnore
    public Integer getPubRefViewOnly() {
        Object objValue = this.get(FIELD_PUBREFVIEWONLY);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="pubrefviewonly")
    public void setPubRefViewOnly(Integer pubRefViewOnly) {
        this.set(FIELD_PUBREFVIEWONLY, pubRefViewOnly);
    }

    @JsonIgnore
    public boolean isPubRefViewOnlyDirty() {
        return this.contains(FIELD_PUBREFVIEWONLY);
    }

    @JsonIgnore
    public Integer getPubSysRefViewOnly() {
        Object objValue = this.get(FIELD_PUBSYSREFVIEWONLY);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="pubsysrefviewonly")
    public void setPubSysRefViewOnly(Integer pubSysRefViewOnly) {
        this.set(FIELD_PUBSYSREFVIEWONLY, pubSysRefViewOnly);
    }

    @JsonIgnore
    public boolean isPubSysRefViewOnlyDirty() {
        return this.contains(FIELD_PUBSYSREFVIEWONLY);
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
    public String getStartPageFile() {
        Object objValue = this.get(FIELD_STARTPAGEFILE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="startpagefile")
    public void setStartPageFile(String startPageFile) {
        this.set(FIELD_STARTPAGEFILE, startPageFile);
    }

    @JsonIgnore
    public boolean isStartPageFileDirty() {
        return this.contains(FIELD_STARTPAGEFILE);
    }

    @JsonIgnore
    public String getSubCaption() {
        Object objValue = this.get(FIELD_SUBCAPTION);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="subcaption")
    public void setSubCaption(String subCaption) {
        this.set(FIELD_SUBCAPTION, subCaption);
    }

    @JsonIgnore
    public boolean isSubCaptionDirty() {
        return this.contains(FIELD_SUBCAPTION);
    }

    @JsonIgnore
    public String getTitle() {
        Object objValue = this.get(FIELD_TITLE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="title")
    public void setTitle(String title) {
        this.set(FIELD_TITLE, title);
    }

    @JsonIgnore
    public boolean isTitleDirty() {
        return this.contains(FIELD_TITLE);
    }

    @JsonIgnore
    public Integer getUACLogin() {
        Object objValue = this.get(FIELD_UACLOGIN);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="uaclogin")
    public void setUACLogin(Integer uACLogin) {
        this.set(FIELD_UACLOGIN, uACLogin);
    }

    @JsonIgnore
    public boolean isUACLoginDirty() {
        return this.contains(FIELD_UACLOGIN);
    }

    @JsonIgnore
    public String getUIStyle() {
        Object objValue = this.get(FIELD_UISTYLE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="uistyle")
    public void setUIStyle(String uIStyle) {
        this.set(FIELD_UISTYLE, uIStyle);
    }

    @JsonIgnore
    public boolean isUIStyleDirty() {
        return this.contains(FIELD_UISTYLE);
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
    public String getSrfkey() {
        return this.getPSSysAppId();
    }

    public void setSrfkey(String strValue) {
        this.setPSSysAppId(strValue);
    }

    public List<PSAppModule> getPsappmodules() {
        return this.psappmodules;
    }

    public void setPsappmodules(List<PSAppModule> psappmodules) {
        this.psappmodules = psappmodules;
    }

    public List<PSSysTestPrj> getPssystestprjs() {
        return this.pssystestprjs;
    }

    public void setPssystestprjs(List<PSSysTestPrj> pssystestprjs) {
        this.pssystestprjs = pssystestprjs;
    }

    public List<PSAppLocalDE> getPsapplocaldes() {
        return this.psapplocaldes;
    }

    public void setPsapplocaldes(List<PSAppLocalDE> psapplocaldes) {
        this.psapplocaldes = psapplocaldes;
    }

    public List<PSAppMenu> getPsappmenus() {
        return this.psappmenus;
    }

    public void setPsappmenus(List<PSAppMenu> psappmenus) {
        this.psappmenus = psappmenus;
    }

    public List<PSAppResource> getPsappresources() {
        return this.psappresources;
    }

    public void setPsappresources(List<PSAppResource> psappresources) {
        this.psappresources = psappresources;
    }

    public List<PSAppStoryBoard> getPsappstoryboards() {
        return this.psappstoryboards;
    }

    public void setPsappstoryboards(List<PSAppStoryBoard> psappstoryboards) {
        this.psappstoryboards = psappstoryboards;
    }

    public List<PSAppTitleBar> getPsapptitlebars() {
        return this.psapptitlebars;
    }

    public void setPsapptitlebars(List<PSAppTitleBar> psapptitlebars) {
        this.psapptitlebars = psapptitlebars;
    }

    public List<PSAppView> getPsappviews() {
        return this.psappviews;
    }

    public void setPsappviews(List<PSAppView> psappviews) {
        this.psappviews = psappviews;
    }

    public List<PSAppFunc> getPsappfuncs() {
        return this.psappfuncs;
    }

    public void setPsappfuncs(List<PSAppFunc> psappfuncs) {
        this.psappfuncs = psappfuncs;
    }

    public List<PSAppLan> getPsapplans() {
        return this.psapplans;
    }

    public void setPsapplans(List<PSAppLan> psapplans) {
        this.psapplans = psapplans;
    }

    public List<PSAppPDTView> getPsapppdtviews() {
        return this.psapppdtviews;
    }

    public void setPsapppdtviews(List<PSAppPDTView> psapppdtviews) {
        this.psapppdtviews = psapppdtviews;
    }

    public List<PSAppPortlet> getPsappportlets() {
        return this.psappportlets;
    }

    public void setPsappportlets(List<PSAppPortlet> psappportlets) {
        this.psappportlets = psappportlets;
    }

    public List<PSAppUIStyle> getPsappuistyles() {
        return this.psappuistyles;
    }

    public void setPsappuistyles(List<PSAppUIStyle> psappuistyles) {
        this.psappuistyles = psappuistyles;
    }

    public List<PSAppUITheme> getPsappuithemes() {
        return this.psappuithemes;
    }

    public void setPsappuithemes(List<PSAppUITheme> psappuithemes) {
        this.psappuithemes = psappuithemes;
    }

    public List<PSAppUserMode> getPsappusermodes() {
        return this.psappusermodes;
    }

    public void setPsappusermodes(List<PSAppUserMode> psappusermodes) {
        this.psappusermodes = psappusermodes;
    }

    public List<PSAppUtilPage> getPsapputilpages() {
        return this.psapputilpages;
    }

    public void setPsapputilpages(List<PSAppUtilPage> psapputilpages) {
        this.psapputilpages = psapputilpages;
    }

    public List<PSMobAppPack> getPsmobapppacks() {
        return this.psmobapppacks;
    }

    public void setPsmobapppacks(List<PSMobAppPack> psmobapppacks) {
        this.psmobapppacks = psmobapppacks;
    }

    public List<PSMobAppStartPage> getPsmobappstartpages() {
        return this.psmobappstartpages;
    }

    public void setPsmobappstartpages(List<PSMobAppStartPage> psmobappstartpages) {
        this.psmobappstartpages = psmobappstartpages;
    }

    public List<PSAppLogic> getPsapplogics() {
        return this.psapplogics;
    }

    public void setPsapplogics(List<PSAppLogic> psapplogics) {
        this.psapplogics = psapplogics;
    }

    public List<PSAppPkg> getPsapppkgs() {
        return this.psapppkgs;
    }

    public void setPsapppkgs(List<PSAppPkg> psapppkgs) {
        this.psapppkgs = psapppkgs;
    }

    public List<PSAppUtil> getPsapputils() {
        return this.psapputils;
    }

    public void setPsapputils(List<PSAppUtil> psapputils) {
        this.psapputils = psapputils;
    }

    public List<PSAppWF> getPsappwfs() {
        return this.psappwfs;
    }

    public void setPsappwfs(List<PSAppWF> psappwfs) {
        this.psappwfs = psappwfs;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (bFullMode && strName.equalsIgnoreCase("psappmodules")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssystestprjs")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psapplocaldes")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psappmenus")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psappresources")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psappstoryboards")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psapptitlebars")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("psappviews")) {
            return true;
        }
        if (strName.equalsIgnoreCase("psappfuncs")) {
            return true;
        }
        if (strName.equalsIgnoreCase("psapplans")) {
            return true;
        }
        if (strName.equalsIgnoreCase("psapppdtviews")) {
            return true;
        }
        if (strName.equalsIgnoreCase("psappportlets")) {
            return true;
        }
        if (strName.equalsIgnoreCase("psappuistyles")) {
            return true;
        }
        if (strName.equalsIgnoreCase("psappuithemes")) {
            return true;
        }
        if (strName.equalsIgnoreCase("psappusermodes")) {
            return true;
        }
        if (strName.equalsIgnoreCase("psapputilpages")) {
            return true;
        }
        if (strName.equalsIgnoreCase("psmobapppacks")) {
            return true;
        }
        if (strName.equalsIgnoreCase("psmobappstartpages")) {
            return true;
        }
        if (strName.equalsIgnoreCase("psapplogics")) {
            return true;
        }
        if (strName.equalsIgnoreCase("psapppkgs")) {
            return true;
        }
        if (strName.equalsIgnoreCase("psapputils")) {
            return true;
        }
        if (strName.equalsIgnoreCase("psappwfs")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("psappmodules")) {
            this.init();
            return this.psappmodules;
        }
        if (strName.equalsIgnoreCase("pssystestprjs")) {
            this.init();
            return this.pssystestprjs;
        }
        if (strName.equalsIgnoreCase("psapplocaldes")) {
            this.init();
            return this.psapplocaldes;
        }
        if (strName.equalsIgnoreCase("psappmenus")) {
            this.init();
            return this.psappmenus;
        }
        if (strName.equalsIgnoreCase("psappresources")) {
            this.init();
            return this.psappresources;
        }
        if (strName.equalsIgnoreCase("psappstoryboards")) {
            this.init();
            return this.psappstoryboards;
        }
        if (strName.equalsIgnoreCase("psapptitlebars")) {
            this.init();
            return this.psapptitlebars;
        }
        if (strName.equalsIgnoreCase("psappviews")) {
            this.init();
            return this.psappviews;
        }
        if (strName.equalsIgnoreCase("psappfuncs")) {
            this.init();
            return this.psappfuncs;
        }
        if (strName.equalsIgnoreCase("psapplans")) {
            this.init();
            return this.psapplans;
        }
        if (strName.equalsIgnoreCase("psapppdtviews")) {
            this.init();
            return this.psapppdtviews;
        }
        if (strName.equalsIgnoreCase("psappportlets")) {
            this.init();
            return this.psappportlets;
        }
        if (strName.equalsIgnoreCase("psappuistyles")) {
            this.init();
            return this.psappuistyles;
        }
        if (strName.equalsIgnoreCase("psappuithemes")) {
            this.init();
            return this.psappuithemes;
        }
        if (strName.equalsIgnoreCase("psappusermodes")) {
            this.init();
            return this.psappusermodes;
        }
        if (strName.equalsIgnoreCase("psapputilpages")) {
            this.init();
            return this.psapputilpages;
        }
        if (strName.equalsIgnoreCase("psmobapppacks")) {
            this.init();
            return this.psmobapppacks;
        }
        if (strName.equalsIgnoreCase("psmobappstartpages")) {
            this.init();
            return this.psmobappstartpages;
        }
        if (strName.equalsIgnoreCase("psapplogics")) {
            this.init();
            return this.psapplogics;
        }
        if (strName.equalsIgnoreCase("psapppkgs")) {
            this.init();
            return this.psapppkgs;
        }
        if (strName.equalsIgnoreCase("psapputils")) {
            this.init();
            return this.psapputils;
        }
        if (strName.equalsIgnoreCase("psappwfs")) {
            this.init();
            return this.psappwfs;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSSYSAPP";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSSysApp item = (PSSysApp)MAPPER.readValue(new File(strJsonFilePath), PSSysApp.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSSysApp) {
            PSSysApp dst = (PSSysApp)target;
            if (!bSimple) {
                PSModelBase newitem;
                if (this.getPsappfuncs() != null) {
                    ArrayList<PSAppFunc> psappfuncs = new ArrayList<PSAppFunc>();
                    for (PSAppFunc pSAppFunc : this.getPsappfuncs()) {
                        if (bDeepMode) {
                            newitem = new PSAppFunc();
                            pSAppFunc.to(newitem, false, bDeepMode);
                            psappfuncs.add((PSAppFunc)newitem);
                            continue;
                        }
                        psappfuncs.add(pSAppFunc);
                    }
                    dst.setPsappfuncs(psappfuncs);
                }
                if (this.getPsapplans() != null) {
                    ArrayList<PSAppLan> psapplans = new ArrayList<PSAppLan>();
                    for (PSAppLan pSAppLan : this.getPsapplans()) {
                        if (bDeepMode) {
                            newitem = new PSAppLan();
                            pSAppLan.to(newitem, false, bDeepMode);
                            psapplans.add((PSAppLan)newitem);
                            continue;
                        }
                        psapplans.add(pSAppLan);
                    }
                    dst.setPsapplans(psapplans);
                }
                if (this.getPsapppdtviews() != null) {
                    ArrayList<PSAppPDTView> psapppdtviews = new ArrayList<PSAppPDTView>();
                    for (PSAppPDTView pSAppPDTView : this.getPsapppdtviews()) {
                        if (bDeepMode) {
                            newitem = new PSAppPDTView();
                            pSAppPDTView.to(newitem, false, bDeepMode);
                            psapppdtviews.add((PSAppPDTView)newitem);
                            continue;
                        }
                        psapppdtviews.add(pSAppPDTView);
                    }
                    dst.setPsapppdtviews(psapppdtviews);
                }
                if (this.getPsappportlets() != null) {
                    ArrayList<PSAppPortlet> psappportlets = new ArrayList<PSAppPortlet>();
                    for (PSAppPortlet pSAppPortlet : this.getPsappportlets()) {
                        if (bDeepMode) {
                            newitem = new PSAppPortlet();
                            pSAppPortlet.to(newitem, false, bDeepMode);
                            psappportlets.add((PSAppPortlet)newitem);
                            continue;
                        }
                        psappportlets.add(pSAppPortlet);
                    }
                    dst.setPsappportlets(psappportlets);
                }
                if (this.getPsappuistyles() != null) {
                    ArrayList<PSAppUIStyle> psappuistyles = new ArrayList<PSAppUIStyle>();
                    for (PSAppUIStyle pSAppUIStyle : this.getPsappuistyles()) {
                        if (bDeepMode) {
                            newitem = new PSAppUIStyle();
                            pSAppUIStyle.to(newitem, false, bDeepMode);
                            psappuistyles.add((PSAppUIStyle)newitem);
                            continue;
                        }
                        psappuistyles.add(pSAppUIStyle);
                    }
                    dst.setPsappuistyles(psappuistyles);
                }
                if (this.getPsappuithemes() != null) {
                    ArrayList<PSAppUITheme> psappuithemes = new ArrayList<PSAppUITheme>();
                    for (PSAppUITheme pSAppUITheme : this.getPsappuithemes()) {
                        if (bDeepMode) {
                            newitem = new PSAppUITheme();
                            pSAppUITheme.to(newitem, false, bDeepMode);
                            psappuithemes.add((PSAppUITheme)newitem);
                            continue;
                        }
                        psappuithemes.add(pSAppUITheme);
                    }
                    dst.setPsappuithemes(psappuithemes);
                }
                if (this.getPsappusermodes() != null) {
                    ArrayList<PSAppUserMode> psappusermodes = new ArrayList<PSAppUserMode>();
                    for (PSAppUserMode pSAppUserMode : this.getPsappusermodes()) {
                        if (bDeepMode) {
                            newitem = new PSAppUserMode();
                            pSAppUserMode.to(newitem, false, bDeepMode);
                            psappusermodes.add((PSAppUserMode)newitem);
                            continue;
                        }
                        psappusermodes.add(pSAppUserMode);
                    }
                    dst.setPsappusermodes(psappusermodes);
                }
                if (this.getPsapputilpages() != null) {
                    ArrayList<PSAppUtilPage> psapputilpages = new ArrayList<PSAppUtilPage>();
                    for (PSAppUtilPage pSAppUtilPage : this.getPsapputilpages()) {
                        if (bDeepMode) {
                            newitem = new PSAppUtilPage();
                            pSAppUtilPage.to(newitem, false, bDeepMode);
                            psapputilpages.add((PSAppUtilPage)newitem);
                            continue;
                        }
                        psapputilpages.add(pSAppUtilPage);
                    }
                    dst.setPsapputilpages(psapputilpages);
                }
                if (this.getPsmobapppacks() != null) {
                    ArrayList<PSMobAppPack> psmobapppacks = new ArrayList<PSMobAppPack>();
                    for (PSMobAppPack pSMobAppPack : this.getPsmobapppacks()) {
                        if (bDeepMode) {
                            newitem = new PSMobAppPack();
                            pSMobAppPack.to(newitem, false, bDeepMode);
                            psmobapppacks.add((PSMobAppPack)newitem);
                            continue;
                        }
                        psmobapppacks.add(pSMobAppPack);
                    }
                    dst.setPsmobapppacks(psmobapppacks);
                }
                if (this.getPsmobappstartpages() != null) {
                    ArrayList<PSMobAppStartPage> psmobappstartpages = new ArrayList<PSMobAppStartPage>();
                    for (PSMobAppStartPage pSMobAppStartPage : this.getPsmobappstartpages()) {
                        if (bDeepMode) {
                            newitem = new PSMobAppStartPage();
                            pSMobAppStartPage.to(newitem, false, bDeepMode);
                            psmobappstartpages.add((PSMobAppStartPage)newitem);
                            continue;
                        }
                        psmobappstartpages.add(pSMobAppStartPage);
                    }
                    dst.setPsmobappstartpages(psmobappstartpages);
                }
                if (this.getPsapplogics() != null) {
                    ArrayList<PSAppLogic> psapplogics = new ArrayList<PSAppLogic>();
                    for (PSAppLogic pSAppLogic : this.getPsapplogics()) {
                        if (bDeepMode) {
                            newitem = new PSAppLogic();
                            pSAppLogic.to(newitem, false, bDeepMode);
                            psapplogics.add((PSAppLogic)newitem);
                            continue;
                        }
                        psapplogics.add(pSAppLogic);
                    }
                    dst.setPsapplogics(psapplogics);
                }
                if (this.getPsapppkgs() != null) {
                    ArrayList<PSAppPkg> psapppkgs = new ArrayList<PSAppPkg>();
                    for (PSAppPkg pSAppPkg : this.getPsapppkgs()) {
                        if (bDeepMode) {
                            newitem = new PSAppPkg();
                            pSAppPkg.to(newitem, false, bDeepMode);
                            psapppkgs.add((PSAppPkg)newitem);
                            continue;
                        }
                        psapppkgs.add(pSAppPkg);
                    }
                    dst.setPsapppkgs(psapppkgs);
                }
                if (this.getPsapputils() != null) {
                    ArrayList<PSAppUtil> psapputils = new ArrayList<PSAppUtil>();
                    for (PSAppUtil pSAppUtil : this.getPsapputils()) {
                        if (bDeepMode) {
                            newitem = new PSAppUtil();
                            pSAppUtil.to(newitem, false, bDeepMode);
                            psapputils.add((PSAppUtil)newitem);
                            continue;
                        }
                        psapputils.add(pSAppUtil);
                    }
                    dst.setPsapputils(psapputils);
                }
                if (this.getPsappwfs() != null) {
                    ArrayList<PSAppWF> psappwfs = new ArrayList<PSAppWF>();
                    for (PSAppWF pSAppWF : this.getPsappwfs()) {
                        if (bDeepMode) {
                            newitem = new PSAppWF();
                            pSAppWF.to(newitem, false, bDeepMode);
                            psappwfs.add((PSAppWF)newitem);
                            continue;
                        }
                        psappwfs.add(pSAppWF);
                    }
                    dst.setPsappwfs(psappwfs);
                }
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSSysApp) {
            PSSysApp src = (PSSysApp)source;
            if (!bSimple) {
                PSModelBase newItem;
                if (src.getPsappfuncs() != null) {
                    ArrayList<PSAppFunc> psappfuncs = new ArrayList<PSAppFunc>();
                    for (PSAppFunc pSAppFunc : src.getPsappfuncs()) {
                        if (bDeepMode) {
                            newItem = new PSAppFunc();
                            ((PSAppFunc)newItem).from(pSAppFunc, false, bDeepMode);
                            psappfuncs.add((PSAppFunc)newItem);
                            continue;
                        }
                        psappfuncs.add(pSAppFunc);
                    }
                    this.setPsappfuncs(psappfuncs);
                }
                if (src.getPsapplans() != null) {
                    ArrayList<PSAppLan> psapplans = new ArrayList<PSAppLan>();
                    for (PSAppLan pSAppLan : src.getPsapplans()) {
                        if (bDeepMode) {
                            newItem = new PSAppLan();
                            ((PSAppLan)newItem).from(pSAppLan, false, bDeepMode);
                            psapplans.add((PSAppLan)newItem);
                            continue;
                        }
                        psapplans.add(pSAppLan);
                    }
                    this.setPsapplans(psapplans);
                }
                if (src.getPsapppdtviews() != null) {
                    ArrayList<PSAppPDTView> psapppdtviews = new ArrayList<PSAppPDTView>();
                    for (PSAppPDTView pSAppPDTView : src.getPsapppdtviews()) {
                        if (bDeepMode) {
                            newItem = new PSAppPDTView();
                            ((PSAppPDTView)newItem).from(pSAppPDTView, false, bDeepMode);
                            psapppdtviews.add((PSAppPDTView)newItem);
                            continue;
                        }
                        psapppdtviews.add(pSAppPDTView);
                    }
                    this.setPsapppdtviews(psapppdtviews);
                }
                if (src.getPsappportlets() != null) {
                    ArrayList<PSAppPortlet> psappportlets = new ArrayList<PSAppPortlet>();
                    for (PSAppPortlet pSAppPortlet : src.getPsappportlets()) {
                        if (bDeepMode) {
                            newItem = new PSAppPortlet();
                            ((PSAppPortlet)newItem).from(pSAppPortlet, false, bDeepMode);
                            psappportlets.add((PSAppPortlet)newItem);
                            continue;
                        }
                        psappportlets.add(pSAppPortlet);
                    }
                    this.setPsappportlets(psappportlets);
                }
                if (src.getPsappuistyles() != null) {
                    ArrayList<PSAppUIStyle> psappuistyles = new ArrayList<PSAppUIStyle>();
                    for (PSAppUIStyle pSAppUIStyle : src.getPsappuistyles()) {
                        if (bDeepMode) {
                            newItem = new PSAppUIStyle();
                            ((PSAppUIStyle)newItem).from(pSAppUIStyle, false, bDeepMode);
                            psappuistyles.add((PSAppUIStyle)newItem);
                            continue;
                        }
                        psappuistyles.add(pSAppUIStyle);
                    }
                    this.setPsappuistyles(psappuistyles);
                }
                if (src.getPsappuithemes() != null) {
                    ArrayList<PSAppUITheme> psappuithemes = new ArrayList<PSAppUITheme>();
                    for (PSAppUITheme pSAppUITheme : src.getPsappuithemes()) {
                        if (bDeepMode) {
                            newItem = new PSAppUITheme();
                            ((PSAppUITheme)newItem).from(pSAppUITheme, false, bDeepMode);
                            psappuithemes.add((PSAppUITheme)newItem);
                            continue;
                        }
                        psappuithemes.add(pSAppUITheme);
                    }
                    this.setPsappuithemes(psappuithemes);
                }
                if (src.getPsappusermodes() != null) {
                    ArrayList<PSAppUserMode> psappusermodes = new ArrayList<PSAppUserMode>();
                    for (PSAppUserMode pSAppUserMode : src.getPsappusermodes()) {
                        if (bDeepMode) {
                            newItem = new PSAppUserMode();
                            ((PSAppUserMode)newItem).from(pSAppUserMode, false, bDeepMode);
                            psappusermodes.add((PSAppUserMode)newItem);
                            continue;
                        }
                        psappusermodes.add(pSAppUserMode);
                    }
                    this.setPsappusermodes(psappusermodes);
                }
                if (src.getPsapputilpages() != null) {
                    ArrayList<PSAppUtilPage> psapputilpages = new ArrayList<PSAppUtilPage>();
                    for (PSAppUtilPage pSAppUtilPage : src.getPsapputilpages()) {
                        if (bDeepMode) {
                            newItem = new PSAppUtilPage();
                            ((PSAppUtilPage)newItem).from(pSAppUtilPage, false, bDeepMode);
                            psapputilpages.add((PSAppUtilPage)newItem);
                            continue;
                        }
                        psapputilpages.add(pSAppUtilPage);
                    }
                    this.setPsapputilpages(psapputilpages);
                }
                if (src.getPsmobapppacks() != null) {
                    ArrayList<PSMobAppPack> psmobapppacks = new ArrayList<PSMobAppPack>();
                    for (PSMobAppPack pSMobAppPack : src.getPsmobapppacks()) {
                        if (bDeepMode) {
                            newItem = new PSMobAppPack();
                            ((PSMobAppPack)newItem).from(pSMobAppPack, false, bDeepMode);
                            psmobapppacks.add((PSMobAppPack)newItem);
                            continue;
                        }
                        psmobapppacks.add(pSMobAppPack);
                    }
                    this.setPsmobapppacks(psmobapppacks);
                }
                if (src.getPsmobappstartpages() != null) {
                    ArrayList<PSMobAppStartPage> psmobappstartpages = new ArrayList<PSMobAppStartPage>();
                    for (PSMobAppStartPage pSMobAppStartPage : src.getPsmobappstartpages()) {
                        if (bDeepMode) {
                            newItem = new PSMobAppStartPage();
                            ((PSMobAppStartPage)newItem).from(pSMobAppStartPage, false, bDeepMode);
                            psmobappstartpages.add((PSMobAppStartPage)newItem);
                            continue;
                        }
                        psmobappstartpages.add(pSMobAppStartPage);
                    }
                    this.setPsmobappstartpages(psmobappstartpages);
                }
                if (src.getPsapplogics() != null) {
                    ArrayList<PSAppLogic> psapplogics = new ArrayList<PSAppLogic>();
                    for (PSAppLogic pSAppLogic : src.getPsapplogics()) {
                        if (bDeepMode) {
                            newItem = new PSAppLogic();
                            ((PSAppLogic)newItem).from(pSAppLogic, false, bDeepMode);
                            psapplogics.add((PSAppLogic)newItem);
                            continue;
                        }
                        psapplogics.add(pSAppLogic);
                    }
                    this.setPsapplogics(psapplogics);
                }
                if (src.getPsapppkgs() != null) {
                    ArrayList<PSAppPkg> psapppkgs = new ArrayList<PSAppPkg>();
                    for (PSAppPkg pSAppPkg : src.getPsapppkgs()) {
                        if (bDeepMode) {
                            newItem = new PSAppPkg();
                            ((PSAppPkg)newItem).from(pSAppPkg, false, bDeepMode);
                            psapppkgs.add((PSAppPkg)newItem);
                            continue;
                        }
                        psapppkgs.add(pSAppPkg);
                    }
                    this.setPsapppkgs(psapppkgs);
                }
                if (src.getPsapputils() != null) {
                    ArrayList<PSAppUtil> psapputils = new ArrayList<PSAppUtil>();
                    for (PSAppUtil pSAppUtil : src.getPsapputils()) {
                        if (bDeepMode) {
                            newItem = new PSAppUtil();
                            ((PSAppUtil)newItem).from(pSAppUtil, false, bDeepMode);
                            psapputils.add((PSAppUtil)newItem);
                            continue;
                        }
                        psapputils.add(pSAppUtil);
                    }
                    this.setPsapputils(psapputils);
                }
                if (src.getPsappwfs() != null) {
                    ArrayList<PSAppWF> psappwfs = new ArrayList<PSAppWF>();
                    for (PSAppWF pSAppWF : src.getPsappwfs()) {
                        if (bDeepMode) {
                            newItem = new PSAppWF();
                            ((PSAppWF)newItem).from(pSAppWF, false, bDeepMode);
                            psappwfs.add((PSAppWF)newItem);
                            continue;
                        }
                        psappwfs.add(pSAppWF);
                    }
                    this.setPsappwfs(psappwfs);
                }
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

