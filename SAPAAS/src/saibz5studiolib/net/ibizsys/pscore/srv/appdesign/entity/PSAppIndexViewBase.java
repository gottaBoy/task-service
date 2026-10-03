/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.appdesign.entity;

import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenu;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounter;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppIndexViewBase
extends PSAppView {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppIndexViewBase.class);
    public static final String FIELD_APPICONPATH = "APPICONPATH";
    public static final String FIELD_APPICONPATH2 = "APPICONPATH2";
    public static final String FIELD_APPSWITCHMODE = "APPSWITCHMODE";
    public static final String FIELD_BLANKMODE = "BLANKMODE";
    public static final String FIELD_BOTTOMSIDEPSAPPMENUID = "BOTTOMSIDEPSAPPMENUID";
    public static final String FIELD_BOTTOMSIDEPSAPPMENUNAME = "BOTTOMSIDEPSAPPMENUNAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTPAGE = "DEFAULTPAGE";
    public static final String FIELD_DEFPSAPPVIEWID = "DEFPSAPPVIEWID";
    public static final String FIELD_DEFPSAPPVIEWNAME = "DEFPSAPPVIEWNAME";
    public static final String FIELD_ENABLECOUNTER = "ENABLECOUNTER";
    public static final String FIELD_LEFTSIDEPSAPPMENUID = "LEFTSIDEPSAPPMENUID";
    public static final String FIELD_LEFTSIDEPSAPPMENUNAME = "LEFTSIDEPSAPPMENUNAME";
    public static final String FIELD_MAINMENUSIDE = "MAINMENUSIDE";
    public static final String FIELD_MENUMODEL = "MENUMODEL";
    public static final String FIELD_PSAPPINDEXVIEWID = "PSAPPINDEXVIEWID";
    public static final String FIELD_PSAPPINDEXVIEWNAME = "PSAPPINDEXVIEWNAME";
    public static final String FIELD_PSAPPMENUID = "PSAPPMENUID";
    public static final String FIELD_PSAPPMENUNAME = "PSAPPMENUNAME";
    public static final String FIELD_PSSYSCOUNTERID = "PSSYSCOUNTERID";
    public static final String FIELD_PSSYSCOUNTERNAME = "PSSYSCOUNTERNAME";
    public static final String FIELD_RIGHTSIDEPSAPPMENUID = "RIGHTSIDEPSAPPMENUID";
    public static final String FIELD_RIGHTSIDEPSAPPMENUNAME = "RIGHTSIDEPSAPPMENUNAME";
    public static final String FIELD_TOPSIDEPSAPPMENUID = "TOPSIDEPSAPPMENUID";
    public static final String FIELD_TOPSIDEPSAPPMENUNAME = "TOPSIDEPSAPPMENUNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_APPICONPATH = 1;
    private static final int INDEX_APPICONPATH2 = 2;
    private static final int INDEX_APPSWITCHMODE = 3;
    private static final int INDEX_BLANKMODE = 6;
    private static final int INDEX_BOTTOMSIDEPSAPPMENUID = 7;
    private static final int INDEX_BOTTOMSIDEPSAPPMENUNAME = 8;
    private static final int INDEX_CREATEDATE = 13;
    private static final int INDEX_CREATEMAN = 14;
    private static final int INDEX_DEFAULTPAGE = 15;
    private static final int INDEX_DEFPSAPPVIEWID = 16;
    private static final int INDEX_DEFPSAPPVIEWNAME = 17;
    private static final int INDEX_ENABLECOUNTER = 20;
    private static final int INDEX_LEFTSIDEPSAPPMENUID = 23;
    private static final int INDEX_LEFTSIDEPSAPPMENUNAME = 24;
    private static final int INDEX_MAINMENUSIDE = 25;
    private static final int INDEX_MENUMODEL = 27;
    private static final int INDEX_PSAPPINDEXVIEWID = 32;
    private static final int INDEX_PSAPPINDEXVIEWNAME = 33;
    private static final int INDEX_PSAPPMENUID = 36;
    private static final int INDEX_PSAPPMENUNAME = 37;
    private static final int INDEX_PSSYSCOUNTERID = 64;
    private static final int INDEX_PSSYSCOUNTERNAME = 65;
    private static final int INDEX_RIGHTSIDEPSAPPMENUID = 85;
    private static final int INDEX_RIGHTSIDEPSAPPMENUNAME = 86;
    private static final int INDEX_TOPSIDEPSAPPMENUID = 97;
    private static final int INDEX_TOPSIDEPSAPPMENUNAME = 98;
    private static final int INDEX_UPDATEDATE = 100;
    private static final int INDEX_UPDATEMAN = 101;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppIndexViewBase proxyPSAppIndexViewBase = null;
    private boolean appiconpathDirtyFlag = false;
    private boolean appiconpath2DirtyFlag = false;
    private boolean appswitchmodeDirtyFlag = false;
    private boolean blankmodeDirtyFlag = false;
    private boolean bottomsidepsappmenuidDirtyFlag = false;
    private boolean bottomsidepsappmenunameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultpageDirtyFlag = false;
    private boolean defpsappviewidDirtyFlag = false;
    private boolean defpsappviewnameDirtyFlag = false;
    private boolean enablecounterDirtyFlag = false;
    private boolean leftsidepsappmenuidDirtyFlag = false;
    private boolean leftsidepsappmenunameDirtyFlag = false;
    private boolean mainmenusideDirtyFlag = false;
    private boolean menumodelDirtyFlag = false;
    private boolean psappindexviewidDirtyFlag = false;
    private boolean psappindexviewnameDirtyFlag = false;
    private boolean psappmenuidDirtyFlag = false;
    private boolean psappmenunameDirtyFlag = false;
    private boolean pssyscounteridDirtyFlag = false;
    private boolean pssyscounternameDirtyFlag = false;
    private boolean rightsidepsappmenuidDirtyFlag = false;
    private boolean rightsidepsappmenunameDirtyFlag = false;
    private boolean topsidepsappmenuidDirtyFlag = false;
    private boolean topsidepsappmenunameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="appiconpath")
    private String appiconpath;
    @Column(name="appiconpath2")
    private String appiconpath2;
    @Column(name="appswitchmode")
    private Integer appswitchmode;
    @Column(name="blankmode")
    private Integer blankmode;
    @Column(name="bottomsidepsappmenuid")
    private String bottomsidepsappmenuid;
    @Column(name="bottomsidepsappmenuname")
    private String bottomsidepsappmenuname;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defaultpage")
    private Integer defaultpage;
    @Column(name="defpsappviewid")
    private String defpsappviewid;
    @Column(name="defpsappviewname")
    private String defpsappviewname;
    @Column(name="enablecounter")
    private Integer enablecounter;
    @Column(name="leftsidepsappmenuid")
    private String leftsidepsappmenuid;
    @Column(name="leftsidepsappmenuname")
    private String leftsidepsappmenuname;
    @Column(name="mainmenuside")
    private String mainmenuside;
    @Column(name="menumodel")
    private String menumodel;
    @Column(name="psappindexviewid")
    private String psappindexviewid;
    @Column(name="psappindexviewname")
    private String psappindexviewname;
    @Column(name="psappmenuid")
    private String psappmenuid;
    @Column(name="psappmenuname")
    private String psappmenuname;
    @Column(name="pssyscounterid")
    private String pssyscounterid;
    @Column(name="pssyscountername")
    private String pssyscountername;
    @Column(name="rightsidepsappmenuid")
    private String rightsidepsappmenuid;
    @Column(name="rightsidepsappmenuname")
    private String rightsidepsappmenuname;
    @Column(name="topsidepsappmenuid")
    private String topsidepsappmenuid;
    @Column(name="topsidepsappmenuname")
    private String topsidepsappmenuname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objBottomSidePSAppMenuLock = new Integer(1);
    private PSAppMenu bottomsidepsappmenu = null;
    private Integer objLeftSidePSAppMenuLock = new Integer(1);
    private PSAppMenu leftsidepsappmenu = null;
    private Integer objPSAppMenuLock = new Integer(1);
    private PSAppMenu psappmenu = null;
    private Integer objRightSidePSAppMenuLock = new Integer(1);
    private PSAppMenu rightsidepsappmenu = null;
    private Integer objTopSidePSAppMenuLock = new Integer(1);
    private PSAppMenu topsidepsappmenu = null;
    private Integer objDefPSAppViewLock = new Integer(1);
    private PSAppView defpsappview = null;
    private Integer objPSSysCounterLock = new Integer(1);
    private PSSysCounter pssyscounter = null;

    public PSAppIndexViewBase() {
        try {
            this.set("PSAPPVIEWTYPE", "APPINDEXVIEW");
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void setAppIconPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppIconPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.appiconpath = string;
        this.appiconpathDirtyFlag = true;
    }

    public String getAppIconPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppIconPath();
        }
        return this.appiconpath;
    }

    public boolean isAppIconPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppIconPathDirty();
        }
        return this.appiconpathDirtyFlag;
    }

    public void resetAppIconPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppIconPath();
            return;
        }
        this.appiconpathDirtyFlag = false;
        this.appiconpath = null;
    }

    public void setAppIconPath2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppIconPath2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.appiconpath2 = string;
        this.appiconpath2DirtyFlag = true;
    }

    public String getAppIconPath2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppIconPath2();
        }
        return this.appiconpath2;
    }

    public boolean isAppIconPath2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppIconPath2Dirty();
        }
        return this.appiconpath2DirtyFlag;
    }

    public void resetAppIconPath2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppIconPath2();
            return;
        }
        this.appiconpath2DirtyFlag = false;
        this.appiconpath2 = null;
    }

    public void setAppSwitchMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppSwitchMode(n);
            return;
        }
        this.appswitchmode = n;
        this.appswitchmodeDirtyFlag = true;
    }

    public Integer getAppSwitchMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppSwitchMode();
        }
        return this.appswitchmode;
    }

    public boolean isAppSwitchModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppSwitchModeDirty();
        }
        return this.appswitchmodeDirtyFlag;
    }

    public void resetAppSwitchMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppSwitchMode();
            return;
        }
        this.appswitchmodeDirtyFlag = false;
        this.appswitchmode = null;
    }

    public void setBlankMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBlankMode(n);
            return;
        }
        this.blankmode = n;
        this.blankmodeDirtyFlag = true;
    }

    public Integer getBlankMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBlankMode();
        }
        return this.blankmode;
    }

    public boolean isBlankModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBlankModeDirty();
        }
        return this.blankmodeDirtyFlag;
    }

    public void resetBlankMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBlankMode();
            return;
        }
        this.blankmodeDirtyFlag = false;
        this.blankmode = null;
    }

    public void setBottomSidePSAppMenuId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBottomSidePSAppMenuId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bottomsidepsappmenuid = string;
        this.bottomsidepsappmenuidDirtyFlag = true;
    }

    public String getBottomSidePSAppMenuId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBottomSidePSAppMenuId();
        }
        return this.bottomsidepsappmenuid;
    }

    public boolean isBottomSidePSAppMenuIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBottomSidePSAppMenuIdDirty();
        }
        return this.bottomsidepsappmenuidDirtyFlag;
    }

    public void resetBottomSidePSAppMenuId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBottomSidePSAppMenuId();
            return;
        }
        this.bottomsidepsappmenuidDirtyFlag = false;
        this.bottomsidepsappmenuid = null;
    }

    public void setBottomSidePSAppMenuName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBottomSidePSAppMenuName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bottomsidepsappmenuname = string;
        this.bottomsidepsappmenunameDirtyFlag = true;
    }

    public String getBottomSidePSAppMenuName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBottomSidePSAppMenuName();
        }
        return this.bottomsidepsappmenuname;
    }

    public boolean isBottomSidePSAppMenuNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBottomSidePSAppMenuNameDirty();
        }
        return this.bottomsidepsappmenunameDirtyFlag;
    }

    public void resetBottomSidePSAppMenuName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBottomSidePSAppMenuName();
            return;
        }
        this.bottomsidepsappmenunameDirtyFlag = false;
        this.bottomsidepsappmenuname = null;
    }

    @Override
    public void setCreateDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDate(timestamp);
            return;
        }
        this.createdate = timestamp;
        this.createdateDirtyFlag = true;
    }

    @Override
    public Timestamp getCreateDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateDate();
        }
        return this.createdate;
    }

    @Override
    public boolean isCreateDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateDateDirty();
        }
        return this.createdateDirtyFlag;
    }

    @Override
    public void resetCreateDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateDate();
            return;
        }
        this.createdateDirtyFlag = false;
        this.createdate = null;
    }

    @Override
    public void setCreateMan(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateMan(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createman = string;
        this.createmanDirtyFlag = true;
    }

    @Override
    public String getCreateMan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateMan();
        }
        return this.createman;
    }

    @Override
    public boolean isCreateManDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateManDirty();
        }
        return this.createmanDirtyFlag;
    }

    @Override
    public void resetCreateMan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateMan();
            return;
        }
        this.createmanDirtyFlag = false;
        this.createman = null;
    }

    public void setDefaultPage(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultPage(n);
            return;
        }
        this.defaultpage = n;
        this.defaultpageDirtyFlag = true;
    }

    public Integer getDefaultPage() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultPage();
        }
        return this.defaultpage;
    }

    public boolean isDefaultPageDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultPageDirty();
        }
        return this.defaultpageDirtyFlag;
    }

    public void resetDefaultPage() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultPage();
            return;
        }
        this.defaultpageDirtyFlag = false;
        this.defaultpage = null;
    }

    public void setDefPSAppViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefPSAppViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defpsappviewid = string;
        this.defpsappviewidDirtyFlag = true;
    }

    public String getDefPSAppViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefPSAppViewId();
        }
        return this.defpsappviewid;
    }

    public boolean isDefPSAppViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefPSAppViewIdDirty();
        }
        return this.defpsappviewidDirtyFlag;
    }

    public void resetDefPSAppViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefPSAppViewId();
            return;
        }
        this.defpsappviewidDirtyFlag = false;
        this.defpsappviewid = null;
    }

    public void setDefPSAppViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefPSAppViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defpsappviewname = string;
        this.defpsappviewnameDirtyFlag = true;
    }

    public String getDefPSAppViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefPSAppViewName();
        }
        return this.defpsappviewname;
    }

    public boolean isDefPSAppViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefPSAppViewNameDirty();
        }
        return this.defpsappviewnameDirtyFlag;
    }

    public void resetDefPSAppViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefPSAppViewName();
            return;
        }
        this.defpsappviewnameDirtyFlag = false;
        this.defpsappviewname = null;
    }

    public void setEnableCounter(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableCounter(n);
            return;
        }
        this.enablecounter = n;
        this.enablecounterDirtyFlag = true;
    }

    public Integer getEnableCounter() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableCounter();
        }
        return this.enablecounter;
    }

    public boolean isEnableCounterDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableCounterDirty();
        }
        return this.enablecounterDirtyFlag;
    }

    public void resetEnableCounter() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableCounter();
            return;
        }
        this.enablecounterDirtyFlag = false;
        this.enablecounter = null;
    }

    public void setLeftSidePSAppMenuId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLeftSidePSAppMenuId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.leftsidepsappmenuid = string;
        this.leftsidepsappmenuidDirtyFlag = true;
    }

    public String getLeftSidePSAppMenuId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLeftSidePSAppMenuId();
        }
        return this.leftsidepsappmenuid;
    }

    public boolean isLeftSidePSAppMenuIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLeftSidePSAppMenuIdDirty();
        }
        return this.leftsidepsappmenuidDirtyFlag;
    }

    public void resetLeftSidePSAppMenuId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLeftSidePSAppMenuId();
            return;
        }
        this.leftsidepsappmenuidDirtyFlag = false;
        this.leftsidepsappmenuid = null;
    }

    public void setLeftSidePSAppMenuName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLeftSidePSAppMenuName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.leftsidepsappmenuname = string;
        this.leftsidepsappmenunameDirtyFlag = true;
    }

    public String getLeftSidePSAppMenuName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLeftSidePSAppMenuName();
        }
        return this.leftsidepsappmenuname;
    }

    public boolean isLeftSidePSAppMenuNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLeftSidePSAppMenuNameDirty();
        }
        return this.leftsidepsappmenunameDirtyFlag;
    }

    public void resetLeftSidePSAppMenuName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLeftSidePSAppMenuName();
            return;
        }
        this.leftsidepsappmenunameDirtyFlag = false;
        this.leftsidepsappmenuname = null;
    }

    public void setMainMenuSide(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMainMenuSide(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mainmenuside = string;
        this.mainmenusideDirtyFlag = true;
    }

    public String getMainMenuSide() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMainMenuSide();
        }
        return this.mainmenuside;
    }

    public boolean isMainMenuSideDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMainMenuSideDirty();
        }
        return this.mainmenusideDirtyFlag;
    }

    public void resetMainMenuSide() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMainMenuSide();
            return;
        }
        this.mainmenusideDirtyFlag = false;
        this.mainmenuside = null;
    }

    public void setMenuModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMenuModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.menumodel = string;
        this.menumodelDirtyFlag = true;
    }

    public String getMenuModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMenuModel();
        }
        return this.menumodel;
    }

    public boolean isMenuModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMenuModelDirty();
        }
        return this.menumodelDirtyFlag;
    }

    public void resetMenuModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMenuModel();
            return;
        }
        this.menumodelDirtyFlag = false;
        this.menumodel = null;
    }

    public void setPSAppIndexViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppIndexViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappindexviewid = string;
        this.psappindexviewidDirtyFlag = true;
        super.setPSAppViewId(string);
    }

    public String getPSAppIndexViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppIndexViewId();
        }
        return this.psappindexviewid;
    }

    public boolean isPSAppIndexViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppIndexViewIdDirty();
        }
        return this.psappindexviewidDirtyFlag;
    }

    public void resetPSAppIndexViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppIndexViewId();
            return;
        }
        this.psappindexviewidDirtyFlag = false;
        this.psappindexviewid = null;
        super.resetPSAppViewId();
    }

    public void setPSAppIndexViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppIndexViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappindexviewname = string;
        this.psappindexviewnameDirtyFlag = true;
        super.setPSAppViewName(string);
    }

    public String getPSAppIndexViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppIndexViewName();
        }
        return this.psappindexviewname;
    }

    public boolean isPSAppIndexViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppIndexViewNameDirty();
        }
        return this.psappindexviewnameDirtyFlag;
    }

    public void resetPSAppIndexViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppIndexViewName();
            return;
        }
        this.psappindexviewnameDirtyFlag = false;
        this.psappindexviewname = null;
    }

    public void setPSAppMenuId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppMenuId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappmenuid = string;
        this.psappmenuidDirtyFlag = true;
    }

    public String getPSAppMenuId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppMenuId();
        }
        return this.psappmenuid;
    }

    public boolean isPSAppMenuIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppMenuIdDirty();
        }
        return this.psappmenuidDirtyFlag;
    }

    public void resetPSAppMenuId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppMenuId();
            return;
        }
        this.psappmenuidDirtyFlag = false;
        this.psappmenuid = null;
    }

    public void setPSAppMenuName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppMenuName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappmenuname = string;
        this.psappmenunameDirtyFlag = true;
    }

    public String getPSAppMenuName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppMenuName();
        }
        return this.psappmenuname;
    }

    public boolean isPSAppMenuNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppMenuNameDirty();
        }
        return this.psappmenunameDirtyFlag;
    }

    public void resetPSAppMenuName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppMenuName();
            return;
        }
        this.psappmenunameDirtyFlag = false;
        this.psappmenuname = null;
    }

    public void setPSSysCounterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCounterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscounterid = string;
        this.pssyscounteridDirtyFlag = true;
    }

    public String getPSSysCounterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCounterId();
        }
        return this.pssyscounterid;
    }

    public boolean isPSSysCounterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCounterIdDirty();
        }
        return this.pssyscounteridDirtyFlag;
    }

    public void resetPSSysCounterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCounterId();
            return;
        }
        this.pssyscounteridDirtyFlag = false;
        this.pssyscounterid = null;
    }

    public void setPSSysCounterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCounterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscountername = string;
        this.pssyscounternameDirtyFlag = true;
    }

    public String getPSSysCounterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCounterName();
        }
        return this.pssyscountername;
    }

    public boolean isPSSysCounterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCounterNameDirty();
        }
        return this.pssyscounternameDirtyFlag;
    }

    public void resetPSSysCounterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCounterName();
            return;
        }
        this.pssyscounternameDirtyFlag = false;
        this.pssyscountername = null;
    }

    public void setRightSidePSAppMenuId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRightSidePSAppMenuId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rightsidepsappmenuid = string;
        this.rightsidepsappmenuidDirtyFlag = true;
    }

    public String getRightSidePSAppMenuId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRightSidePSAppMenuId();
        }
        return this.rightsidepsappmenuid;
    }

    public boolean isRightSidePSAppMenuIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRightSidePSAppMenuIdDirty();
        }
        return this.rightsidepsappmenuidDirtyFlag;
    }

    public void resetRightSidePSAppMenuId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRightSidePSAppMenuId();
            return;
        }
        this.rightsidepsappmenuidDirtyFlag = false;
        this.rightsidepsappmenuid = null;
    }

    public void setRightSidePSAppMenuName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRightSidePSAppMenuName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rightsidepsappmenuname = string;
        this.rightsidepsappmenunameDirtyFlag = true;
    }

    public String getRightSidePSAppMenuName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRightSidePSAppMenuName();
        }
        return this.rightsidepsappmenuname;
    }

    public boolean isRightSidePSAppMenuNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRightSidePSAppMenuNameDirty();
        }
        return this.rightsidepsappmenunameDirtyFlag;
    }

    public void resetRightSidePSAppMenuName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRightSidePSAppMenuName();
            return;
        }
        this.rightsidepsappmenunameDirtyFlag = false;
        this.rightsidepsappmenuname = null;
    }

    public void setTopSidePSAppMenuId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTopSidePSAppMenuId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.topsidepsappmenuid = string;
        this.topsidepsappmenuidDirtyFlag = true;
    }

    public String getTopSidePSAppMenuId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTopSidePSAppMenuId();
        }
        return this.topsidepsappmenuid;
    }

    public boolean isTopSidePSAppMenuIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTopSidePSAppMenuIdDirty();
        }
        return this.topsidepsappmenuidDirtyFlag;
    }

    public void resetTopSidePSAppMenuId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTopSidePSAppMenuId();
            return;
        }
        this.topsidepsappmenuidDirtyFlag = false;
        this.topsidepsappmenuid = null;
    }

    public void setTopSidePSAppMenuName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTopSidePSAppMenuName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.topsidepsappmenuname = string;
        this.topsidepsappmenunameDirtyFlag = true;
    }

    public String getTopSidePSAppMenuName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTopSidePSAppMenuName();
        }
        return this.topsidepsappmenuname;
    }

    public boolean isTopSidePSAppMenuNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTopSidePSAppMenuNameDirty();
        }
        return this.topsidepsappmenunameDirtyFlag;
    }

    public void resetTopSidePSAppMenuName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTopSidePSAppMenuName();
            return;
        }
        this.topsidepsappmenunameDirtyFlag = false;
        this.topsidepsappmenuname = null;
    }

    @Override
    public void setUpdateDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDate(timestamp);
            return;
        }
        this.updatedate = timestamp;
        this.updatedateDirtyFlag = true;
    }

    @Override
    public Timestamp getUpdateDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateDate();
        }
        return this.updatedate;
    }

    @Override
    public boolean isUpdateDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateDateDirty();
        }
        return this.updatedateDirtyFlag;
    }

    @Override
    public void resetUpdateDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateDate();
            return;
        }
        this.updatedateDirtyFlag = false;
        this.updatedate = null;
    }

    @Override
    public void setUpdateMan(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateMan(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.updateman = string;
        this.updatemanDirtyFlag = true;
    }

    @Override
    public String getUpdateMan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateMan();
        }
        return this.updateman;
    }

    @Override
    public boolean isUpdateManDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateManDirty();
        }
        return this.updatemanDirtyFlag;
    }

    @Override
    public void resetUpdateMan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateMan();
            return;
        }
        this.updatemanDirtyFlag = false;
        this.updateman = null;
    }

    @Override
    protected void onReset() {
        PSAppIndexViewBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppIndexViewBase pSAppIndexViewBase) {
        pSAppIndexViewBase.resetAppIconPath();
        pSAppIndexViewBase.resetAppIconPath2();
        pSAppIndexViewBase.resetAppSwitchMode();
        pSAppIndexViewBase.resetBlankMode();
        pSAppIndexViewBase.resetBottomSidePSAppMenuId();
        pSAppIndexViewBase.resetBottomSidePSAppMenuName();
        pSAppIndexViewBase.resetCreateDate();
        pSAppIndexViewBase.resetCreateMan();
        pSAppIndexViewBase.resetDefaultPage();
        pSAppIndexViewBase.resetDefPSAppViewId();
        pSAppIndexViewBase.resetDefPSAppViewName();
        pSAppIndexViewBase.resetEnableCounter();
        pSAppIndexViewBase.resetLeftSidePSAppMenuId();
        pSAppIndexViewBase.resetLeftSidePSAppMenuName();
        pSAppIndexViewBase.resetMainMenuSide();
        pSAppIndexViewBase.resetMenuModel();
        pSAppIndexViewBase.resetPSAppIndexViewId();
        pSAppIndexViewBase.resetPSAppIndexViewName();
        pSAppIndexViewBase.resetPSAppMenuId();
        pSAppIndexViewBase.resetPSAppMenuName();
        pSAppIndexViewBase.resetPSSysCounterId();
        pSAppIndexViewBase.resetPSSysCounterName();
        pSAppIndexViewBase.resetRightSidePSAppMenuId();
        pSAppIndexViewBase.resetRightSidePSAppMenuName();
        pSAppIndexViewBase.resetTopSidePSAppMenuId();
        pSAppIndexViewBase.resetTopSidePSAppMenuName();
        pSAppIndexViewBase.resetUpdateDate();
        pSAppIndexViewBase.resetUpdateMan();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAppIconPathDirty()) {
            hashMap.put(FIELD_APPICONPATH, this.getAppIconPath());
        }
        if (!bl || this.isAppIconPath2Dirty()) {
            hashMap.put(FIELD_APPICONPATH2, this.getAppIconPath2());
        }
        if (!bl || this.isAppSwitchModeDirty()) {
            hashMap.put(FIELD_APPSWITCHMODE, this.getAppSwitchMode());
        }
        if (!bl || this.isBlankModeDirty()) {
            hashMap.put(FIELD_BLANKMODE, this.getBlankMode());
        }
        if (!bl || this.isBottomSidePSAppMenuIdDirty()) {
            hashMap.put(FIELD_BOTTOMSIDEPSAPPMENUID, this.getBottomSidePSAppMenuId());
        }
        if (!bl || this.isBottomSidePSAppMenuNameDirty()) {
            hashMap.put(FIELD_BOTTOMSIDEPSAPPMENUNAME, this.getBottomSidePSAppMenuName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDefaultPageDirty()) {
            hashMap.put(FIELD_DEFAULTPAGE, this.getDefaultPage());
        }
        if (!bl || this.isDefPSAppViewIdDirty()) {
            hashMap.put(FIELD_DEFPSAPPVIEWID, this.getDefPSAppViewId());
        }
        if (!bl || this.isDefPSAppViewNameDirty()) {
            hashMap.put(FIELD_DEFPSAPPVIEWNAME, this.getDefPSAppViewName());
        }
        if (!bl || this.isEnableCounterDirty()) {
            hashMap.put(FIELD_ENABLECOUNTER, this.getEnableCounter());
        }
        if (!bl || this.isLeftSidePSAppMenuIdDirty()) {
            hashMap.put(FIELD_LEFTSIDEPSAPPMENUID, this.getLeftSidePSAppMenuId());
        }
        if (!bl || this.isLeftSidePSAppMenuNameDirty()) {
            hashMap.put(FIELD_LEFTSIDEPSAPPMENUNAME, this.getLeftSidePSAppMenuName());
        }
        if (!bl || this.isMainMenuSideDirty()) {
            hashMap.put(FIELD_MAINMENUSIDE, this.getMainMenuSide());
        }
        if (!bl || this.isMenuModelDirty()) {
            hashMap.put(FIELD_MENUMODEL, this.getMenuModel());
        }
        if (!bl || this.isPSAppIndexViewIdDirty()) {
            hashMap.put(FIELD_PSAPPINDEXVIEWID, this.getPSAppIndexViewId());
        }
        if (!bl || this.isPSAppIndexViewNameDirty()) {
            hashMap.put(FIELD_PSAPPINDEXVIEWNAME, this.getPSAppIndexViewName());
        }
        if (!bl || this.isPSAppMenuIdDirty()) {
            hashMap.put(FIELD_PSAPPMENUID, this.getPSAppMenuId());
        }
        if (!bl || this.isPSAppMenuNameDirty()) {
            hashMap.put(FIELD_PSAPPMENUNAME, this.getPSAppMenuName());
        }
        if (!bl || this.isPSSysCounterIdDirty()) {
            hashMap.put(FIELD_PSSYSCOUNTERID, this.getPSSysCounterId());
        }
        if (!bl || this.isPSSysCounterNameDirty()) {
            hashMap.put(FIELD_PSSYSCOUNTERNAME, this.getPSSysCounterName());
        }
        if (!bl || this.isRightSidePSAppMenuIdDirty()) {
            hashMap.put(FIELD_RIGHTSIDEPSAPPMENUID, this.getRightSidePSAppMenuId());
        }
        if (!bl || this.isRightSidePSAppMenuNameDirty()) {
            hashMap.put(FIELD_RIGHTSIDEPSAPPMENUNAME, this.getRightSidePSAppMenuName());
        }
        if (!bl || this.isTopSidePSAppMenuIdDirty()) {
            hashMap.put(FIELD_TOPSIDEPSAPPMENUID, this.getTopSidePSAppMenuId());
        }
        if (!bl || this.isTopSidePSAppMenuNameDirty()) {
            hashMap.put(FIELD_TOPSIDEPSAPPMENUNAME, this.getTopSidePSAppMenuName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        super.onFillMap(hashMap, bl);
    }

    @Override
    public Object get(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().get(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.get(string);
        }
        return PSAppIndexViewBase.get(this, n);
    }

    private static Object get(PSAppIndexViewBase pSAppIndexViewBase, int n) throws Exception {
        switch (n) {
            case 1: {
                return pSAppIndexViewBase.getAppIconPath();
            }
            case 2: {
                return pSAppIndexViewBase.getAppIconPath2();
            }
            case 3: {
                return pSAppIndexViewBase.getAppSwitchMode();
            }
            case 6: {
                return pSAppIndexViewBase.getBlankMode();
            }
            case 7: {
                return pSAppIndexViewBase.getBottomSidePSAppMenuId();
            }
            case 8: {
                return pSAppIndexViewBase.getBottomSidePSAppMenuName();
            }
            case 13: {
                return pSAppIndexViewBase.getCreateDate();
            }
            case 14: {
                return pSAppIndexViewBase.getCreateMan();
            }
            case 15: {
                return pSAppIndexViewBase.getDefaultPage();
            }
            case 16: {
                return pSAppIndexViewBase.getDefPSAppViewId();
            }
            case 17: {
                return pSAppIndexViewBase.getDefPSAppViewName();
            }
            case 20: {
                return pSAppIndexViewBase.getEnableCounter();
            }
            case 23: {
                return pSAppIndexViewBase.getLeftSidePSAppMenuId();
            }
            case 24: {
                return pSAppIndexViewBase.getLeftSidePSAppMenuName();
            }
            case 25: {
                return pSAppIndexViewBase.getMainMenuSide();
            }
            case 27: {
                return pSAppIndexViewBase.getMenuModel();
            }
            case 32: {
                return pSAppIndexViewBase.getPSAppIndexViewId();
            }
            case 33: {
                return pSAppIndexViewBase.getPSAppIndexViewName();
            }
            case 36: {
                return pSAppIndexViewBase.getPSAppMenuId();
            }
            case 37: {
                return pSAppIndexViewBase.getPSAppMenuName();
            }
            case 64: {
                return pSAppIndexViewBase.getPSSysCounterId();
            }
            case 65: {
                return pSAppIndexViewBase.getPSSysCounterName();
            }
            case 85: {
                return pSAppIndexViewBase.getRightSidePSAppMenuId();
            }
            case 86: {
                return pSAppIndexViewBase.getRightSidePSAppMenuName();
            }
            case 97: {
                return pSAppIndexViewBase.getTopSidePSAppMenuId();
            }
            case 98: {
                return pSAppIndexViewBase.getTopSidePSAppMenuName();
            }
            case 100: {
                return pSAppIndexViewBase.getUpdateDate();
            }
            case 101: {
                return pSAppIndexViewBase.getUpdateMan();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public void set(String string, Object object) throws Exception {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().set(string, object);
            return;
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            super.set(string, object);
            return;
        }
        PSAppIndexViewBase.set(this, n, object);
    }

    private static void set(PSAppIndexViewBase pSAppIndexViewBase, int n, Object object) throws Exception {
        switch (n) {
            case 1: {
                pSAppIndexViewBase.setAppIconPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSAppIndexViewBase.setAppIconPath2(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSAppIndexViewBase.setAppSwitchMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSAppIndexViewBase.setBlankMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSAppIndexViewBase.setBottomSidePSAppMenuId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSAppIndexViewBase.setBottomSidePSAppMenuName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSAppIndexViewBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSAppIndexViewBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSAppIndexViewBase.setDefaultPage(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSAppIndexViewBase.setDefPSAppViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSAppIndexViewBase.setDefPSAppViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSAppIndexViewBase.setEnableCounter(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSAppIndexViewBase.setLeftSidePSAppMenuId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSAppIndexViewBase.setLeftSidePSAppMenuName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSAppIndexViewBase.setMainMenuSide(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSAppIndexViewBase.setMenuModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSAppIndexViewBase.setPSAppIndexViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSAppIndexViewBase.setPSAppIndexViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSAppIndexViewBase.setPSAppMenuId(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSAppIndexViewBase.setPSAppMenuName(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSAppIndexViewBase.setPSSysCounterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSAppIndexViewBase.setPSSysCounterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 85: {
                pSAppIndexViewBase.setRightSidePSAppMenuId(DataObject.getStringValue((Object)object));
                return;
            }
            case 86: {
                pSAppIndexViewBase.setRightSidePSAppMenuName(DataObject.getStringValue((Object)object));
                return;
            }
            case 97: {
                pSAppIndexViewBase.setTopSidePSAppMenuId(DataObject.getStringValue((Object)object));
                return;
            }
            case 98: {
                pSAppIndexViewBase.setTopSidePSAppMenuName(DataObject.getStringValue((Object)object));
                return;
            }
            case 100: {
                pSAppIndexViewBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 101: {
                pSAppIndexViewBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public boolean isNull(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNull(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.isNull(string);
        }
        return PSAppIndexViewBase.isNull(this, n);
    }

    private static boolean isNull(PSAppIndexViewBase pSAppIndexViewBase, int n) throws Exception {
        switch (n) {
            case 1: {
                return pSAppIndexViewBase.getAppIconPath() == null;
            }
            case 2: {
                return pSAppIndexViewBase.getAppIconPath2() == null;
            }
            case 3: {
                return pSAppIndexViewBase.getAppSwitchMode() == null;
            }
            case 6: {
                return pSAppIndexViewBase.getBlankMode() == null;
            }
            case 7: {
                return pSAppIndexViewBase.getBottomSidePSAppMenuId() == null;
            }
            case 8: {
                return pSAppIndexViewBase.getBottomSidePSAppMenuName() == null;
            }
            case 13: {
                return pSAppIndexViewBase.getCreateDate() == null;
            }
            case 14: {
                return pSAppIndexViewBase.getCreateMan() == null;
            }
            case 15: {
                return pSAppIndexViewBase.getDefaultPage() == null;
            }
            case 16: {
                return pSAppIndexViewBase.getDefPSAppViewId() == null;
            }
            case 17: {
                return pSAppIndexViewBase.getDefPSAppViewName() == null;
            }
            case 20: {
                return pSAppIndexViewBase.getEnableCounter() == null;
            }
            case 23: {
                return pSAppIndexViewBase.getLeftSidePSAppMenuId() == null;
            }
            case 24: {
                return pSAppIndexViewBase.getLeftSidePSAppMenuName() == null;
            }
            case 25: {
                return pSAppIndexViewBase.getMainMenuSide() == null;
            }
            case 27: {
                return pSAppIndexViewBase.getMenuModel() == null;
            }
            case 32: {
                return pSAppIndexViewBase.getPSAppIndexViewId() == null;
            }
            case 33: {
                return pSAppIndexViewBase.getPSAppIndexViewName() == null;
            }
            case 36: {
                return pSAppIndexViewBase.getPSAppMenuId() == null;
            }
            case 37: {
                return pSAppIndexViewBase.getPSAppMenuName() == null;
            }
            case 64: {
                return pSAppIndexViewBase.getPSSysCounterId() == null;
            }
            case 65: {
                return pSAppIndexViewBase.getPSSysCounterName() == null;
            }
            case 85: {
                return pSAppIndexViewBase.getRightSidePSAppMenuId() == null;
            }
            case 86: {
                return pSAppIndexViewBase.getRightSidePSAppMenuName() == null;
            }
            case 97: {
                return pSAppIndexViewBase.getTopSidePSAppMenuId() == null;
            }
            case 98: {
                return pSAppIndexViewBase.getTopSidePSAppMenuName() == null;
            }
            case 100: {
                return pSAppIndexViewBase.getUpdateDate() == null;
            }
            case 101: {
                return pSAppIndexViewBase.getUpdateMan() == null;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public boolean contains(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().contains(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.contains(string);
        }
        return PSAppIndexViewBase.contains(this, n);
    }

    private static boolean contains(PSAppIndexViewBase pSAppIndexViewBase, int n) throws Exception {
        switch (n) {
            case 1: {
                return pSAppIndexViewBase.isAppIconPathDirty();
            }
            case 2: {
                return pSAppIndexViewBase.isAppIconPath2Dirty();
            }
            case 3: {
                return pSAppIndexViewBase.isAppSwitchModeDirty();
            }
            case 6: {
                return pSAppIndexViewBase.isBlankModeDirty();
            }
            case 7: {
                return pSAppIndexViewBase.isBottomSidePSAppMenuIdDirty();
            }
            case 8: {
                return pSAppIndexViewBase.isBottomSidePSAppMenuNameDirty();
            }
            case 13: {
                return pSAppIndexViewBase.isCreateDateDirty();
            }
            case 14: {
                return pSAppIndexViewBase.isCreateManDirty();
            }
            case 15: {
                return pSAppIndexViewBase.isDefaultPageDirty();
            }
            case 16: {
                return pSAppIndexViewBase.isDefPSAppViewIdDirty();
            }
            case 17: {
                return pSAppIndexViewBase.isDefPSAppViewNameDirty();
            }
            case 20: {
                return pSAppIndexViewBase.isEnableCounterDirty();
            }
            case 23: {
                return pSAppIndexViewBase.isLeftSidePSAppMenuIdDirty();
            }
            case 24: {
                return pSAppIndexViewBase.isLeftSidePSAppMenuNameDirty();
            }
            case 25: {
                return pSAppIndexViewBase.isMainMenuSideDirty();
            }
            case 27: {
                return pSAppIndexViewBase.isMenuModelDirty();
            }
            case 32: {
                return pSAppIndexViewBase.isPSAppIndexViewIdDirty();
            }
            case 33: {
                return pSAppIndexViewBase.isPSAppIndexViewNameDirty();
            }
            case 36: {
                return pSAppIndexViewBase.isPSAppMenuIdDirty();
            }
            case 37: {
                return pSAppIndexViewBase.isPSAppMenuNameDirty();
            }
            case 64: {
                return pSAppIndexViewBase.isPSSysCounterIdDirty();
            }
            case 65: {
                return pSAppIndexViewBase.isPSSysCounterNameDirty();
            }
            case 85: {
                return pSAppIndexViewBase.isRightSidePSAppMenuIdDirty();
            }
            case 86: {
                return pSAppIndexViewBase.isRightSidePSAppMenuNameDirty();
            }
            case 97: {
                return pSAppIndexViewBase.isTopSidePSAppMenuIdDirty();
            }
            case 98: {
                return pSAppIndexViewBase.isTopSidePSAppMenuNameDirty();
            }
            case 100: {
                return pSAppIndexViewBase.isUpdateDateDirty();
            }
            case 101: {
                return pSAppIndexViewBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppIndexViewBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppIndexViewBase pSAppIndexViewBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppIndexViewBase.getAppIconPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"appiconpath", (Object)PSAppIndexViewBase.getJSONValue((Object)pSAppIndexViewBase.getAppIconPath()), (boolean)false);
        }
        if (bl || pSAppIndexViewBase.getAppIconPath2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"appiconpath2", (Object)PSAppIndexViewBase.getJSONValue((Object)pSAppIndexViewBase.getAppIconPath2()), (boolean)false);
        }
        if (bl || pSAppIndexViewBase.getAppSwitchMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"appswitchmode", (Object)PSAppIndexViewBase.getJSONValue((Object)pSAppIndexViewBase.getAppSwitchMode()), (boolean)false);
        }
        if (bl || pSAppIndexViewBase.getBlankMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"blankmode", (Object)PSAppIndexViewBase.getJSONValue((Object)pSAppIndexViewBase.getBlankMode()), (boolean)false);
        }
        if (bl || pSAppIndexViewBase.getBottomSidePSAppMenuId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bottomsidepsappmenuid", (Object)PSAppIndexViewBase.getJSONValue((Object)pSAppIndexViewBase.getBottomSidePSAppMenuId()), (boolean)false);
        }
        if (bl || pSAppIndexViewBase.getBottomSidePSAppMenuName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bottomsidepsappmenuname", (Object)PSAppIndexViewBase.getJSONValue((Object)pSAppIndexViewBase.getBottomSidePSAppMenuName()), (boolean)false);
        }
        if (bl || pSAppIndexViewBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppIndexViewBase.getJSONValue((Object)pSAppIndexViewBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppIndexViewBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppIndexViewBase.getJSONValue((Object)pSAppIndexViewBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppIndexViewBase.getDefaultPage() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultpage", (Object)PSAppIndexViewBase.getJSONValue((Object)pSAppIndexViewBase.getDefaultPage()), (boolean)false);
        }
        if (bl || pSAppIndexViewBase.getDefPSAppViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defpsappviewid", (Object)PSAppIndexViewBase.getJSONValue((Object)pSAppIndexViewBase.getDefPSAppViewId()), (boolean)false);
        }
        if (bl || pSAppIndexViewBase.getDefPSAppViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defpsappviewname", (Object)PSAppIndexViewBase.getJSONValue((Object)pSAppIndexViewBase.getDefPSAppViewName()), (boolean)false);
        }
        if (bl || pSAppIndexViewBase.getEnableCounter() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablecounter", (Object)PSAppIndexViewBase.getJSONValue((Object)pSAppIndexViewBase.getEnableCounter()), (boolean)false);
        }
        if (bl || pSAppIndexViewBase.getLeftSidePSAppMenuId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"leftsidepsappmenuid", (Object)PSAppIndexViewBase.getJSONValue((Object)pSAppIndexViewBase.getLeftSidePSAppMenuId()), (boolean)false);
        }
        if (bl || pSAppIndexViewBase.getLeftSidePSAppMenuName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"leftsidepsappmenuname", (Object)PSAppIndexViewBase.getJSONValue((Object)pSAppIndexViewBase.getLeftSidePSAppMenuName()), (boolean)false);
        }
        if (bl || pSAppIndexViewBase.getMainMenuSide() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mainmenuside", (Object)PSAppIndexViewBase.getJSONValue((Object)pSAppIndexViewBase.getMainMenuSide()), (boolean)false);
        }
        if (bl || pSAppIndexViewBase.getMenuModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"menumodel", (Object)PSAppIndexViewBase.getJSONValue((Object)pSAppIndexViewBase.getMenuModel()), (boolean)false);
        }
        if (bl || pSAppIndexViewBase.getPSAppIndexViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappindexviewid", (Object)PSAppIndexViewBase.getJSONValue((Object)pSAppIndexViewBase.getPSAppIndexViewId()), (boolean)false);
        }
        if (bl || pSAppIndexViewBase.getPSAppIndexViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappindexviewname", (Object)PSAppIndexViewBase.getJSONValue((Object)pSAppIndexViewBase.getPSAppIndexViewName()), (boolean)false);
        }
        if (bl || pSAppIndexViewBase.getPSAppMenuId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmenuid", (Object)PSAppIndexViewBase.getJSONValue((Object)pSAppIndexViewBase.getPSAppMenuId()), (boolean)false);
        }
        if (bl || pSAppIndexViewBase.getPSAppMenuName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmenuname", (Object)PSAppIndexViewBase.getJSONValue((Object)pSAppIndexViewBase.getPSAppMenuName()), (boolean)false);
        }
        if (bl || pSAppIndexViewBase.getPSSysCounterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscounterid", (Object)PSAppIndexViewBase.getJSONValue((Object)pSAppIndexViewBase.getPSSysCounterId()), (boolean)false);
        }
        if (bl || pSAppIndexViewBase.getPSSysCounterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscountername", (Object)PSAppIndexViewBase.getJSONValue((Object)pSAppIndexViewBase.getPSSysCounterName()), (boolean)false);
        }
        if (bl || pSAppIndexViewBase.getRightSidePSAppMenuId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rightsidepsappmenuid", (Object)PSAppIndexViewBase.getJSONValue((Object)pSAppIndexViewBase.getRightSidePSAppMenuId()), (boolean)false);
        }
        if (bl || pSAppIndexViewBase.getRightSidePSAppMenuName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rightsidepsappmenuname", (Object)PSAppIndexViewBase.getJSONValue((Object)pSAppIndexViewBase.getRightSidePSAppMenuName()), (boolean)false);
        }
        if (bl || pSAppIndexViewBase.getTopSidePSAppMenuId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"topsidepsappmenuid", (Object)PSAppIndexViewBase.getJSONValue((Object)pSAppIndexViewBase.getTopSidePSAppMenuId()), (boolean)false);
        }
        if (bl || pSAppIndexViewBase.getTopSidePSAppMenuName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"topsidepsappmenuname", (Object)PSAppIndexViewBase.getJSONValue((Object)pSAppIndexViewBase.getTopSidePSAppMenuName()), (boolean)false);
        }
        if (bl || pSAppIndexViewBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppIndexViewBase.getJSONValue((Object)pSAppIndexViewBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppIndexViewBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppIndexViewBase.getJSONValue((Object)pSAppIndexViewBase.getUpdateMan()), (boolean)false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppIndexViewBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppIndexViewBase pSAppIndexViewBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppIndexViewBase.getAppIconPath() != null) {
            object = pSAppIndexViewBase.getAppIconPath();
            xmlNode.setAttribute(FIELD_APPICONPATH, (String)(object == null ? "" : object));
        }
        if (bl || pSAppIndexViewBase.getAppIconPath2() != null) {
            object = pSAppIndexViewBase.getAppIconPath2();
            xmlNode.setAttribute(FIELD_APPICONPATH2, object == null ? "" : (String)object);
        }
        if (bl || pSAppIndexViewBase.getAppSwitchMode() != null) {
            object = pSAppIndexViewBase.getAppSwitchMode();
            xmlNode.setAttribute(FIELD_APPSWITCHMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppIndexViewBase.getBlankMode() != null) {
            object = pSAppIndexViewBase.getBlankMode();
            xmlNode.setAttribute(FIELD_BLANKMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppIndexViewBase.getBottomSidePSAppMenuId() != null) {
            object = pSAppIndexViewBase.getBottomSidePSAppMenuId();
            xmlNode.setAttribute(FIELD_BOTTOMSIDEPSAPPMENUID, object == null ? "" : (String)object);
        }
        if (bl || pSAppIndexViewBase.getBottomSidePSAppMenuName() != null) {
            object = pSAppIndexViewBase.getBottomSidePSAppMenuName();
            xmlNode.setAttribute(FIELD_BOTTOMSIDEPSAPPMENUNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppIndexViewBase.getCreateDate() != null) {
            object = pSAppIndexViewBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppIndexViewBase.getCreateMan() != null) {
            object = pSAppIndexViewBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppIndexViewBase.getDefaultPage() != null) {
            object = pSAppIndexViewBase.getDefaultPage();
            xmlNode.setAttribute(FIELD_DEFAULTPAGE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppIndexViewBase.getDefPSAppViewId() != null) {
            object = pSAppIndexViewBase.getDefPSAppViewId();
            xmlNode.setAttribute(FIELD_DEFPSAPPVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSAppIndexViewBase.getDefPSAppViewName() != null) {
            object = pSAppIndexViewBase.getDefPSAppViewName();
            xmlNode.setAttribute(FIELD_DEFPSAPPVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppIndexViewBase.getEnableCounter() != null) {
            object = pSAppIndexViewBase.getEnableCounter();
            xmlNode.setAttribute(FIELD_ENABLECOUNTER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppIndexViewBase.getLeftSidePSAppMenuId() != null) {
            object = pSAppIndexViewBase.getLeftSidePSAppMenuId();
            xmlNode.setAttribute(FIELD_LEFTSIDEPSAPPMENUID, object == null ? "" : (String)object);
        }
        if (bl || pSAppIndexViewBase.getLeftSidePSAppMenuName() != null) {
            object = pSAppIndexViewBase.getLeftSidePSAppMenuName();
            xmlNode.setAttribute(FIELD_LEFTSIDEPSAPPMENUNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppIndexViewBase.getMainMenuSide() != null) {
            object = pSAppIndexViewBase.getMainMenuSide();
            xmlNode.setAttribute(FIELD_MAINMENUSIDE, object == null ? "" : (String)object);
        }
        if (bl || pSAppIndexViewBase.getMenuModel() != null) {
            object = pSAppIndexViewBase.getMenuModel();
            xmlNode.setAttribute(FIELD_MENUMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSAppIndexViewBase.getPSAppIndexViewId() != null) {
            object = pSAppIndexViewBase.getPSAppIndexViewId();
            xmlNode.setAttribute(FIELD_PSAPPINDEXVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSAppIndexViewBase.getPSAppIndexViewName() != null) {
            object = pSAppIndexViewBase.getPSAppIndexViewName();
            xmlNode.setAttribute(FIELD_PSAPPINDEXVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppIndexViewBase.getPSAppMenuId() != null) {
            object = pSAppIndexViewBase.getPSAppMenuId();
            xmlNode.setAttribute(FIELD_PSAPPMENUID, object == null ? "" : (String)object);
        }
        if (bl || pSAppIndexViewBase.getPSAppMenuName() != null) {
            object = pSAppIndexViewBase.getPSAppMenuName();
            xmlNode.setAttribute(FIELD_PSAPPMENUNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppIndexViewBase.getPSSysCounterId() != null) {
            object = pSAppIndexViewBase.getPSSysCounterId();
            xmlNode.setAttribute(FIELD_PSSYSCOUNTERID, object == null ? "" : (String)object);
        }
        if (bl || pSAppIndexViewBase.getPSSysCounterName() != null) {
            object = pSAppIndexViewBase.getPSSysCounterName();
            xmlNode.setAttribute(FIELD_PSSYSCOUNTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppIndexViewBase.getRightSidePSAppMenuId() != null) {
            object = pSAppIndexViewBase.getRightSidePSAppMenuId();
            xmlNode.setAttribute(FIELD_RIGHTSIDEPSAPPMENUID, object == null ? "" : (String)object);
        }
        if (bl || pSAppIndexViewBase.getRightSidePSAppMenuName() != null) {
            object = pSAppIndexViewBase.getRightSidePSAppMenuName();
            xmlNode.setAttribute(FIELD_RIGHTSIDEPSAPPMENUNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppIndexViewBase.getTopSidePSAppMenuId() != null) {
            object = pSAppIndexViewBase.getTopSidePSAppMenuId();
            xmlNode.setAttribute(FIELD_TOPSIDEPSAPPMENUID, object == null ? "" : (String)object);
        }
        if (bl || pSAppIndexViewBase.getTopSidePSAppMenuName() != null) {
            object = pSAppIndexViewBase.getTopSidePSAppMenuName();
            xmlNode.setAttribute(FIELD_TOPSIDEPSAPPMENUNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppIndexViewBase.getUpdateDate() != null) {
            object = pSAppIndexViewBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppIndexViewBase.getUpdateMan() != null) {
            object = pSAppIndexViewBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    @Override
    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppIndexViewBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppIndexViewBase pSAppIndexViewBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppIndexViewBase.isAppIconPathDirty() && (bl || pSAppIndexViewBase.getAppIconPath() != null)) {
            iDataObject.set(FIELD_APPICONPATH, (Object)pSAppIndexViewBase.getAppIconPath());
        }
        if (pSAppIndexViewBase.isAppIconPath2Dirty() && (bl || pSAppIndexViewBase.getAppIconPath2() != null)) {
            iDataObject.set(FIELD_APPICONPATH2, (Object)pSAppIndexViewBase.getAppIconPath2());
        }
        if (pSAppIndexViewBase.isAppSwitchModeDirty() && (bl || pSAppIndexViewBase.getAppSwitchMode() != null)) {
            iDataObject.set(FIELD_APPSWITCHMODE, (Object)pSAppIndexViewBase.getAppSwitchMode());
        }
        if (pSAppIndexViewBase.isBlankModeDirty() && (bl || pSAppIndexViewBase.getBlankMode() != null)) {
            iDataObject.set(FIELD_BLANKMODE, (Object)pSAppIndexViewBase.getBlankMode());
        }
        if (pSAppIndexViewBase.isBottomSidePSAppMenuIdDirty() && (bl || pSAppIndexViewBase.getBottomSidePSAppMenuId() != null)) {
            iDataObject.set(FIELD_BOTTOMSIDEPSAPPMENUID, (Object)pSAppIndexViewBase.getBottomSidePSAppMenuId());
        }
        if (pSAppIndexViewBase.isBottomSidePSAppMenuNameDirty() && (bl || pSAppIndexViewBase.getBottomSidePSAppMenuName() != null)) {
            iDataObject.set(FIELD_BOTTOMSIDEPSAPPMENUNAME, (Object)pSAppIndexViewBase.getBottomSidePSAppMenuName());
        }
        if (pSAppIndexViewBase.isCreateDateDirty() && (bl || pSAppIndexViewBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppIndexViewBase.getCreateDate());
        }
        if (pSAppIndexViewBase.isCreateManDirty() && (bl || pSAppIndexViewBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppIndexViewBase.getCreateMan());
        }
        if (pSAppIndexViewBase.isDefaultPageDirty() && (bl || pSAppIndexViewBase.getDefaultPage() != null)) {
            iDataObject.set(FIELD_DEFAULTPAGE, (Object)pSAppIndexViewBase.getDefaultPage());
        }
        if (pSAppIndexViewBase.isDefPSAppViewIdDirty() && (bl || pSAppIndexViewBase.getDefPSAppViewId() != null)) {
            iDataObject.set(FIELD_DEFPSAPPVIEWID, (Object)pSAppIndexViewBase.getDefPSAppViewId());
        }
        if (pSAppIndexViewBase.isDefPSAppViewNameDirty() && (bl || pSAppIndexViewBase.getDefPSAppViewName() != null)) {
            iDataObject.set(FIELD_DEFPSAPPVIEWNAME, (Object)pSAppIndexViewBase.getDefPSAppViewName());
        }
        if (pSAppIndexViewBase.isEnableCounterDirty() && (bl || pSAppIndexViewBase.getEnableCounter() != null)) {
            iDataObject.set(FIELD_ENABLECOUNTER, (Object)pSAppIndexViewBase.getEnableCounter());
        }
        if (pSAppIndexViewBase.isLeftSidePSAppMenuIdDirty() && (bl || pSAppIndexViewBase.getLeftSidePSAppMenuId() != null)) {
            iDataObject.set(FIELD_LEFTSIDEPSAPPMENUID, (Object)pSAppIndexViewBase.getLeftSidePSAppMenuId());
        }
        if (pSAppIndexViewBase.isLeftSidePSAppMenuNameDirty() && (bl || pSAppIndexViewBase.getLeftSidePSAppMenuName() != null)) {
            iDataObject.set(FIELD_LEFTSIDEPSAPPMENUNAME, (Object)pSAppIndexViewBase.getLeftSidePSAppMenuName());
        }
        if (pSAppIndexViewBase.isMainMenuSideDirty() && (bl || pSAppIndexViewBase.getMainMenuSide() != null)) {
            iDataObject.set(FIELD_MAINMENUSIDE, (Object)pSAppIndexViewBase.getMainMenuSide());
        }
        if (pSAppIndexViewBase.isMenuModelDirty() && (bl || pSAppIndexViewBase.getMenuModel() != null)) {
            iDataObject.set(FIELD_MENUMODEL, (Object)pSAppIndexViewBase.getMenuModel());
        }
        if (pSAppIndexViewBase.isPSAppIndexViewIdDirty() && (bl || pSAppIndexViewBase.getPSAppIndexViewId() != null)) {
            iDataObject.set(FIELD_PSAPPINDEXVIEWID, (Object)pSAppIndexViewBase.getPSAppIndexViewId());
        }
        if (pSAppIndexViewBase.isPSAppIndexViewNameDirty() && (bl || pSAppIndexViewBase.getPSAppIndexViewName() != null)) {
            iDataObject.set(FIELD_PSAPPINDEXVIEWNAME, (Object)pSAppIndexViewBase.getPSAppIndexViewName());
        }
        if (pSAppIndexViewBase.isPSAppMenuIdDirty() && (bl || pSAppIndexViewBase.getPSAppMenuId() != null)) {
            iDataObject.set(FIELD_PSAPPMENUID, (Object)pSAppIndexViewBase.getPSAppMenuId());
        }
        if (pSAppIndexViewBase.isPSAppMenuNameDirty() && (bl || pSAppIndexViewBase.getPSAppMenuName() != null)) {
            iDataObject.set(FIELD_PSAPPMENUNAME, (Object)pSAppIndexViewBase.getPSAppMenuName());
        }
        if (pSAppIndexViewBase.isPSSysCounterIdDirty() && (bl || pSAppIndexViewBase.getPSSysCounterId() != null)) {
            iDataObject.set(FIELD_PSSYSCOUNTERID, (Object)pSAppIndexViewBase.getPSSysCounterId());
        }
        if (pSAppIndexViewBase.isPSSysCounterNameDirty() && (bl || pSAppIndexViewBase.getPSSysCounterName() != null)) {
            iDataObject.set(FIELD_PSSYSCOUNTERNAME, (Object)pSAppIndexViewBase.getPSSysCounterName());
        }
        if (pSAppIndexViewBase.isRightSidePSAppMenuIdDirty() && (bl || pSAppIndexViewBase.getRightSidePSAppMenuId() != null)) {
            iDataObject.set(FIELD_RIGHTSIDEPSAPPMENUID, (Object)pSAppIndexViewBase.getRightSidePSAppMenuId());
        }
        if (pSAppIndexViewBase.isRightSidePSAppMenuNameDirty() && (bl || pSAppIndexViewBase.getRightSidePSAppMenuName() != null)) {
            iDataObject.set(FIELD_RIGHTSIDEPSAPPMENUNAME, (Object)pSAppIndexViewBase.getRightSidePSAppMenuName());
        }
        if (pSAppIndexViewBase.isTopSidePSAppMenuIdDirty() && (bl || pSAppIndexViewBase.getTopSidePSAppMenuId() != null)) {
            iDataObject.set(FIELD_TOPSIDEPSAPPMENUID, (Object)pSAppIndexViewBase.getTopSidePSAppMenuId());
        }
        if (pSAppIndexViewBase.isTopSidePSAppMenuNameDirty() && (bl || pSAppIndexViewBase.getTopSidePSAppMenuName() != null)) {
            iDataObject.set(FIELD_TOPSIDEPSAPPMENUNAME, (Object)pSAppIndexViewBase.getTopSidePSAppMenuName());
        }
        if (pSAppIndexViewBase.isUpdateDateDirty() && (bl || pSAppIndexViewBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppIndexViewBase.getUpdateDate());
        }
        if (pSAppIndexViewBase.isUpdateManDirty() && (bl || pSAppIndexViewBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppIndexViewBase.getUpdateMan());
        }
    }

    @Override
    public boolean remove(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().remove(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.remove(string);
        }
        return PSAppIndexViewBase.remove(this, n);
    }

    private static boolean remove(PSAppIndexViewBase pSAppIndexViewBase, int n) throws Exception {
        switch (n) {
            case 1: {
                pSAppIndexViewBase.resetAppIconPath();
                return true;
            }
            case 2: {
                pSAppIndexViewBase.resetAppIconPath2();
                return true;
            }
            case 3: {
                pSAppIndexViewBase.resetAppSwitchMode();
                return true;
            }
            case 6: {
                pSAppIndexViewBase.resetBlankMode();
                return true;
            }
            case 7: {
                pSAppIndexViewBase.resetBottomSidePSAppMenuId();
                return true;
            }
            case 8: {
                pSAppIndexViewBase.resetBottomSidePSAppMenuName();
                return true;
            }
            case 13: {
                pSAppIndexViewBase.resetCreateDate();
                return true;
            }
            case 14: {
                pSAppIndexViewBase.resetCreateMan();
                return true;
            }
            case 15: {
                pSAppIndexViewBase.resetDefaultPage();
                return true;
            }
            case 16: {
                pSAppIndexViewBase.resetDefPSAppViewId();
                return true;
            }
            case 17: {
                pSAppIndexViewBase.resetDefPSAppViewName();
                return true;
            }
            case 20: {
                pSAppIndexViewBase.resetEnableCounter();
                return true;
            }
            case 23: {
                pSAppIndexViewBase.resetLeftSidePSAppMenuId();
                return true;
            }
            case 24: {
                pSAppIndexViewBase.resetLeftSidePSAppMenuName();
                return true;
            }
            case 25: {
                pSAppIndexViewBase.resetMainMenuSide();
                return true;
            }
            case 27: {
                pSAppIndexViewBase.resetMenuModel();
                return true;
            }
            case 32: {
                pSAppIndexViewBase.resetPSAppIndexViewId();
                return true;
            }
            case 33: {
                pSAppIndexViewBase.resetPSAppIndexViewName();
                return true;
            }
            case 36: {
                pSAppIndexViewBase.resetPSAppMenuId();
                return true;
            }
            case 37: {
                pSAppIndexViewBase.resetPSAppMenuName();
                return true;
            }
            case 64: {
                pSAppIndexViewBase.resetPSSysCounterId();
                return true;
            }
            case 65: {
                pSAppIndexViewBase.resetPSSysCounterName();
                return true;
            }
            case 85: {
                pSAppIndexViewBase.resetRightSidePSAppMenuId();
                return true;
            }
            case 86: {
                pSAppIndexViewBase.resetRightSidePSAppMenuName();
                return true;
            }
            case 97: {
                pSAppIndexViewBase.resetTopSidePSAppMenuId();
                return true;
            }
            case 98: {
                pSAppIndexViewBase.resetTopSidePSAppMenuName();
                return true;
            }
            case 100: {
                pSAppIndexViewBase.resetUpdateDate();
                return true;
            }
            case 101: {
                pSAppIndexViewBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppMenu getBottomSidePSAppMenu() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBottomSidePSAppMenu();
        }
        if (this.getBottomSidePSAppMenuId() == null) {
            return null;
        }
        Integer n = this.objBottomSidePSAppMenuLock;
        synchronized (n) {
            if (this.bottomsidepsappmenu != null && DataTypeHelper.compare((int)25, (Object)this.getBottomSidePSAppMenuId(), (Object)this.bottomsidepsappmenu.getPSAppMenuId()) != 0L) {
                this.bottomsidepsappmenu = null;
            }
            if (this.bottomsidepsappmenu == null) {
                PSAppMenu pSAppMenu = new PSAppMenu();
                pSAppMenu.setPSAppMenuId(this.getBottomSidePSAppMenuId());
                PSAppMenuService pSAppMenuService = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)this.getSessionFactory());
                pSAppMenuService.autoGet(pSAppMenu);
                this.bottomsidepsappmenu = pSAppMenu;
            }
            return this.bottomsidepsappmenu;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppMenu getLeftSidePSAppMenu() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLeftSidePSAppMenu();
        }
        if (this.getLeftSidePSAppMenuId() == null) {
            return null;
        }
        Integer n = this.objLeftSidePSAppMenuLock;
        synchronized (n) {
            if (this.leftsidepsappmenu != null && DataTypeHelper.compare((int)25, (Object)this.getLeftSidePSAppMenuId(), (Object)this.leftsidepsappmenu.getPSAppMenuId()) != 0L) {
                this.leftsidepsappmenu = null;
            }
            if (this.leftsidepsappmenu == null) {
                PSAppMenu pSAppMenu = new PSAppMenu();
                pSAppMenu.setPSAppMenuId(this.getLeftSidePSAppMenuId());
                PSAppMenuService pSAppMenuService = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)this.getSessionFactory());
                pSAppMenuService.autoGet(pSAppMenu);
                this.leftsidepsappmenu = pSAppMenu;
            }
            return this.leftsidepsappmenu;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppMenu getPSAppMenu() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppMenu();
        }
        if (this.getPSAppMenuId() == null) {
            return null;
        }
        Integer n = this.objPSAppMenuLock;
        synchronized (n) {
            if (this.psappmenu != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppMenuId(), (Object)this.psappmenu.getPSAppMenuId()) != 0L) {
                this.psappmenu = null;
            }
            if (this.psappmenu == null) {
                PSAppMenu pSAppMenu = new PSAppMenu();
                pSAppMenu.setPSAppMenuId(this.getPSAppMenuId());
                PSAppMenuService pSAppMenuService = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)this.getSessionFactory());
                pSAppMenuService.autoGet(pSAppMenu);
                this.psappmenu = pSAppMenu;
            }
            return this.psappmenu;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppMenu getRightSidePSAppMenu() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRightSidePSAppMenu();
        }
        if (this.getRightSidePSAppMenuId() == null) {
            return null;
        }
        Integer n = this.objRightSidePSAppMenuLock;
        synchronized (n) {
            if (this.rightsidepsappmenu != null && DataTypeHelper.compare((int)25, (Object)this.getRightSidePSAppMenuId(), (Object)this.rightsidepsappmenu.getPSAppMenuId()) != 0L) {
                this.rightsidepsappmenu = null;
            }
            if (this.rightsidepsappmenu == null) {
                PSAppMenu pSAppMenu = new PSAppMenu();
                pSAppMenu.setPSAppMenuId(this.getRightSidePSAppMenuId());
                PSAppMenuService pSAppMenuService = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)this.getSessionFactory());
                pSAppMenuService.autoGet(pSAppMenu);
                this.rightsidepsappmenu = pSAppMenu;
            }
            return this.rightsidepsappmenu;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppMenu getTopSidePSAppMenu() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTopSidePSAppMenu();
        }
        if (this.getTopSidePSAppMenuId() == null) {
            return null;
        }
        Integer n = this.objTopSidePSAppMenuLock;
        synchronized (n) {
            if (this.topsidepsappmenu != null && DataTypeHelper.compare((int)25, (Object)this.getTopSidePSAppMenuId(), (Object)this.topsidepsappmenu.getPSAppMenuId()) != 0L) {
                this.topsidepsappmenu = null;
            }
            if (this.topsidepsappmenu == null) {
                PSAppMenu pSAppMenu = new PSAppMenu();
                pSAppMenu.setPSAppMenuId(this.getTopSidePSAppMenuId());
                PSAppMenuService pSAppMenuService = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)this.getSessionFactory());
                pSAppMenuService.autoGet(pSAppMenu);
                this.topsidepsappmenu = pSAppMenu;
            }
            return this.topsidepsappmenu;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppView getDefPSAppView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefPSAppView();
        }
        if (this.getDefPSAppViewId() == null) {
            return null;
        }
        Integer n = this.objDefPSAppViewLock;
        synchronized (n) {
            if (this.defpsappview != null && DataTypeHelper.compare((int)25, (Object)this.getDefPSAppViewId(), (Object)this.defpsappview.getPSAppViewId()) != 0L) {
                this.defpsappview = null;
            }
            if (this.defpsappview == null) {
                PSAppView pSAppView = new PSAppView();
                pSAppView.setPSAppViewId(this.getDefPSAppViewId());
                PSAppViewService pSAppViewService = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
                pSAppViewService.autoGet(pSAppView);
                this.defpsappview = pSAppView;
            }
            return this.defpsappview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysCounter getPSSysCounter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCounter();
        }
        if (this.getPSSysCounterId() == null) {
            return null;
        }
        Integer n = this.objPSSysCounterLock;
        synchronized (n) {
            if (this.pssyscounter != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysCounterId(), (Object)this.pssyscounter.getPSSysCounterId()) != 0L) {
                this.pssyscounter = null;
            }
            if (this.pssyscounter == null) {
                PSSysCounter pSSysCounter = new PSSysCounter();
                pSSysCounter.setPSSysCounterId(this.getPSSysCounterId());
                PSSysCounterService pSSysCounterService = (PSSysCounterService)ServiceGlobal.getService(PSSysCounterService.class, (SessionFactory)this.getSessionFactory());
                pSSysCounterService.autoGet(pSSysCounter);
                this.pssyscounter = pSSysCounter;
            }
            return this.pssyscounter;
        }
    }

    private PSAppIndexViewBase getProxyEntity() {
        return this.proxyPSAppIndexViewBase;
    }

    @Override
    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppIndexViewBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppIndexViewBase) {
            this.proxyPSAppIndexViewBase = (PSAppIndexViewBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppIndexViewService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_APPICONPATH, 1);
        fieldIndexMap.put(FIELD_APPICONPATH2, 2);
        fieldIndexMap.put(FIELD_APPSWITCHMODE, 3);
        fieldIndexMap.put(FIELD_BLANKMODE, 6);
        fieldIndexMap.put(FIELD_BOTTOMSIDEPSAPPMENUID, 7);
        fieldIndexMap.put(FIELD_BOTTOMSIDEPSAPPMENUNAME, 8);
        fieldIndexMap.put(FIELD_CREATEDATE, 13);
        fieldIndexMap.put(FIELD_CREATEMAN, 14);
        fieldIndexMap.put(FIELD_DEFAULTPAGE, 15);
        fieldIndexMap.put(FIELD_DEFPSAPPVIEWID, 16);
        fieldIndexMap.put(FIELD_DEFPSAPPVIEWNAME, 17);
        fieldIndexMap.put(FIELD_ENABLECOUNTER, 20);
        fieldIndexMap.put(FIELD_LEFTSIDEPSAPPMENUID, 23);
        fieldIndexMap.put(FIELD_LEFTSIDEPSAPPMENUNAME, 24);
        fieldIndexMap.put(FIELD_MAINMENUSIDE, 25);
        fieldIndexMap.put(FIELD_MENUMODEL, 27);
        fieldIndexMap.put(FIELD_PSAPPINDEXVIEWID, 32);
        fieldIndexMap.put(FIELD_PSAPPINDEXVIEWNAME, 33);
        fieldIndexMap.put(FIELD_PSAPPMENUID, 36);
        fieldIndexMap.put(FIELD_PSAPPMENUNAME, 37);
        fieldIndexMap.put(FIELD_PSSYSCOUNTERID, 64);
        fieldIndexMap.put(FIELD_PSSYSCOUNTERNAME, 65);
        fieldIndexMap.put(FIELD_RIGHTSIDEPSAPPMENUID, 85);
        fieldIndexMap.put(FIELD_RIGHTSIDEPSAPPMENUNAME, 86);
        fieldIndexMap.put(FIELD_TOPSIDEPSAPPMENUID, 97);
        fieldIndexMap.put(FIELD_TOPSIDEPSAPPMENUNAME, 98);
        fieldIndexMap.put(FIELD_UPDATEDATE, 100);
        fieldIndexMap.put(FIELD_UPDATEMAN, 101);
    }
}

