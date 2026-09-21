/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
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
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppPortalViewBase
extends PSAppView {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppPortalViewBase.class);
    public static final String FIELD_COLMODEL = "COLMODEL";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DASHBOARDNAVBAR = "DASHBOARDNAVBAR";
    public static final String FIELD_DASHBOARDSTYLE = "DASHBOARDSTYLE";
    public static final String FIELD_DASHBOARDTAG = "DASHBOARDTAG";
    public static final String FIELD_DASHBOARDTAG2 = "DASHBOARDTAG2";
    public static final String FIELD_DBMODEL = "DBMODEL";
    public static final String FIELD_DEFAULTPAGE = "DEFAULTPAGE";
    public static final String FIELD_ENABLECUSTOMIZE = "ENABLECUSTOMIZE";
    public static final String FIELD_FLEXALIGN = "FLEXALIGN";
    public static final String FIELD_FLEXDIR = "FLEXDIR";
    public static final String FIELD_FLEXVALIGN = "FLEXVALIGN";
    public static final String FIELD_LAYOUTMODE = "LAYOUTMODE";
    public static final String FIELD_NAVBARHEIGHT = "NAVBARHEIGHT";
    public static final String FIELD_NAVBARPOS = "NAVBARPOS";
    public static final String FIELD_NAVBARSTYLE = "NAVBARSTYLE";
    public static final String FIELD_NAVBARWIDTH = "NAVBARWIDTH";
    public static final String FIELD_PSAPPPORTALVIEWID = "PSAPPPORTALVIEWID";
    public static final String FIELD_PSAPPPORTALVIEWNAME = "PSAPPPORTALVIEWNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_COLMODEL = 6;
    private static final int INDEX_CREATEDATE = 8;
    private static final int INDEX_CREATEMAN = 9;
    private static final int INDEX_DASHBOARDNAVBAR = 10;
    private static final int INDEX_DASHBOARDSTYLE = 11;
    private static final int INDEX_DASHBOARDTAG = 12;
    private static final int INDEX_DASHBOARDTAG2 = 13;
    private static final int INDEX_DBMODEL = 14;
    private static final int INDEX_DEFAULTPAGE = 15;
    private static final int INDEX_ENABLECUSTOMIZE = 18;
    private static final int INDEX_FLEXALIGN = 20;
    private static final int INDEX_FLEXDIR = 21;
    private static final int INDEX_FLEXVALIGN = 22;
    private static final int INDEX_LAYOUTMODE = 23;
    private static final int INDEX_NAVBARHEIGHT = 27;
    private static final int INDEX_NAVBARPOS = 28;
    private static final int INDEX_NAVBARSTYLE = 29;
    private static final int INDEX_NAVBARWIDTH = 30;
    private static final int INDEX_PSAPPPORTALVIEWID = 38;
    private static final int INDEX_PSAPPPORTALVIEWNAME = 39;
    private static final int INDEX_UPDATEDATE = 94;
    private static final int INDEX_UPDATEMAN = 95;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppPortalViewBase proxyPSAppPortalViewBase = null;
    private boolean colmodelDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dashboardnavbarDirtyFlag = false;
    private boolean dashboardstyleDirtyFlag = false;
    private boolean dashboardtagDirtyFlag = false;
    private boolean dashboardtag2DirtyFlag = false;
    private boolean dbmodelDirtyFlag = false;
    private boolean defaultpageDirtyFlag = false;
    private boolean enablecustomizeDirtyFlag = false;
    private boolean flexalignDirtyFlag = false;
    private boolean flexdirDirtyFlag = false;
    private boolean flexvalignDirtyFlag = false;
    private boolean layoutmodeDirtyFlag = false;
    private boolean navbarheightDirtyFlag = false;
    private boolean navbarposDirtyFlag = false;
    private boolean navbarstyleDirtyFlag = false;
    private boolean navbarwidthDirtyFlag = false;
    private boolean psappportalviewidDirtyFlag = false;
    private boolean psappportalviewnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="colmodel")
    private String colmodel;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dashboardnavbar")
    private Integer dashboardnavbar;
    @Column(name="dashboardstyle")
    private String dashboardstyle;
    @Column(name="dashboardtag")
    private String dashboardtag;
    @Column(name="dashboardtag2")
    private String dashboardtag2;
    @Column(name="dbmodel")
    private String dbmodel;
    @Column(name="defaultpage")
    private Integer defaultpage;
    @Column(name="enablecustomize")
    private Integer enablecustomize;
    @Column(name="flexalign")
    private String flexalign;
    @Column(name="flexdir")
    private String flexdir;
    @Column(name="flexvalign")
    private String flexvalign;
    @Column(name="layoutmode")
    private String layoutmode;
    @Column(name="navbarheight")
    private Integer navbarheight;
    @Column(name="navbarpos")
    private String navbarpos;
    @Column(name="navbarstyle")
    private String navbarstyle;
    @Column(name="navbarwidth")
    private Integer navbarwidth;
    @Column(name="psappportalviewid")
    private String psappportalviewid;
    @Column(name="psappportalviewname")
    private String psappportalviewname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

    public PSAppPortalViewBase() {
        try {
            this.set("PSAPPVIEWTYPE", "APPPORTALVIEW");
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void setColModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setColModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.colmodel = string;
        this.colmodelDirtyFlag = true;
    }

    public String getColModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getColModel();
        }
        return this.colmodel;
    }

    public boolean isColModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isColModelDirty();
        }
        return this.colmodelDirtyFlag;
    }

    public void resetColModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetColModel();
            return;
        }
        this.colmodelDirtyFlag = false;
        this.colmodel = null;
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

    public void setDashboardNavBar(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDashboardNavBar(n);
            return;
        }
        this.dashboardnavbar = n;
        this.dashboardnavbarDirtyFlag = true;
    }

    public Integer getDashboardNavBar() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDashboardNavBar();
        }
        return this.dashboardnavbar;
    }

    public boolean isDashboardNavBarDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDashboardNavBarDirty();
        }
        return this.dashboardnavbarDirtyFlag;
    }

    public void resetDashboardNavBar() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDashboardNavBar();
            return;
        }
        this.dashboardnavbarDirtyFlag = false;
        this.dashboardnavbar = null;
    }

    public void setDashboardStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDashboardStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dashboardstyle = string;
        this.dashboardstyleDirtyFlag = true;
    }

    public String getDashboardStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDashboardStyle();
        }
        return this.dashboardstyle;
    }

    public boolean isDashboardStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDashboardStyleDirty();
        }
        return this.dashboardstyleDirtyFlag;
    }

    public void resetDashboardStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDashboardStyle();
            return;
        }
        this.dashboardstyleDirtyFlag = false;
        this.dashboardstyle = null;
    }

    public void setDashboardTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDashboardTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dashboardtag = string;
        this.dashboardtagDirtyFlag = true;
    }

    public String getDashboardTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDashboardTag();
        }
        return this.dashboardtag;
    }

    public boolean isDashboardTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDashboardTagDirty();
        }
        return this.dashboardtagDirtyFlag;
    }

    public void resetDashboardTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDashboardTag();
            return;
        }
        this.dashboardtagDirtyFlag = false;
        this.dashboardtag = null;
    }

    public void setDashboardTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDashboardTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dashboardtag2 = string;
        this.dashboardtag2DirtyFlag = true;
    }

    public String getDashboardTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDashboardTag2();
        }
        return this.dashboardtag2;
    }

    public boolean isDashboardTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDashboardTag2Dirty();
        }
        return this.dashboardtag2DirtyFlag;
    }

    public void resetDashboardTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDashboardTag2();
            return;
        }
        this.dashboardtag2DirtyFlag = false;
        this.dashboardtag2 = null;
    }

    public void setDBModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDBModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dbmodel = string;
        this.dbmodelDirtyFlag = true;
    }

    public String getDBModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDBModel();
        }
        return this.dbmodel;
    }

    public boolean isDBModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDBModelDirty();
        }
        return this.dbmodelDirtyFlag;
    }

    public void resetDBModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDBModel();
            return;
        }
        this.dbmodelDirtyFlag = false;
        this.dbmodel = null;
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

    public void setEnableCustomize(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableCustomize(n);
            return;
        }
        this.enablecustomize = n;
        this.enablecustomizeDirtyFlag = true;
    }

    public Integer getEnableCustomize() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableCustomize();
        }
        return this.enablecustomize;
    }

    public boolean isEnableCustomizeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableCustomizeDirty();
        }
        return this.enablecustomizeDirtyFlag;
    }

    public void resetEnableCustomize() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableCustomize();
            return;
        }
        this.enablecustomizeDirtyFlag = false;
        this.enablecustomize = null;
    }

    public void setFlexAlign(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFlexAlign(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.flexalign = string;
        this.flexalignDirtyFlag = true;
    }

    public String getFlexAlign() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFlexAlign();
        }
        return this.flexalign;
    }

    public boolean isFlexAlignDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFlexAlignDirty();
        }
        return this.flexalignDirtyFlag;
    }

    public void resetFlexAlign() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFlexAlign();
            return;
        }
        this.flexalignDirtyFlag = false;
        this.flexalign = null;
    }

    public void setFlexDir(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFlexDir(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.flexdir = string;
        this.flexdirDirtyFlag = true;
    }

    public String getFlexDir() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFlexDir();
        }
        return this.flexdir;
    }

    public boolean isFlexDirDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFlexDirDirty();
        }
        return this.flexdirDirtyFlag;
    }

    public void resetFlexDir() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFlexDir();
            return;
        }
        this.flexdirDirtyFlag = false;
        this.flexdir = null;
    }

    public void setFlexVAlign(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFlexVAlign(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.flexvalign = string;
        this.flexvalignDirtyFlag = true;
    }

    public String getFlexVAlign() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFlexVAlign();
        }
        return this.flexvalign;
    }

    public boolean isFlexVAlignDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFlexVAlignDirty();
        }
        return this.flexvalignDirtyFlag;
    }

    public void resetFlexVAlign() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFlexVAlign();
            return;
        }
        this.flexvalignDirtyFlag = false;
        this.flexvalign = null;
    }

    public void setLayoutMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLayoutMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.layoutmode = string;
        this.layoutmodeDirtyFlag = true;
    }

    public String getLayoutMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLayoutMode();
        }
        return this.layoutmode;
    }

    public boolean isLayoutModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLayoutModeDirty();
        }
        return this.layoutmodeDirtyFlag;
    }

    public void resetLayoutMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLayoutMode();
            return;
        }
        this.layoutmodeDirtyFlag = false;
        this.layoutmode = null;
    }

    public void setNavBarHeight(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNavBarHeight(n);
            return;
        }
        this.navbarheight = n;
        this.navbarheightDirtyFlag = true;
    }

    public Integer getNavBarHeight() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNavBarHeight();
        }
        return this.navbarheight;
    }

    public boolean isNavBarHeightDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNavBarHeightDirty();
        }
        return this.navbarheightDirtyFlag;
    }

    public void resetNavBarHeight() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNavBarHeight();
            return;
        }
        this.navbarheightDirtyFlag = false;
        this.navbarheight = null;
    }

    public void setNavBarPos(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNavBarPos(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.navbarpos = string;
        this.navbarposDirtyFlag = true;
    }

    public String getNavBarPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNavBarPos();
        }
        return this.navbarpos;
    }

    public boolean isNavBarPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNavBarPosDirty();
        }
        return this.navbarposDirtyFlag;
    }

    public void resetNavBarPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNavBarPos();
            return;
        }
        this.navbarposDirtyFlag = false;
        this.navbarpos = null;
    }

    public void setNavBarStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNavBarStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.navbarstyle = string;
        this.navbarstyleDirtyFlag = true;
    }

    public String getNavBarStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNavBarStyle();
        }
        return this.navbarstyle;
    }

    public boolean isNavBarStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNavBarStyleDirty();
        }
        return this.navbarstyleDirtyFlag;
    }

    public void resetNavBarStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNavBarStyle();
            return;
        }
        this.navbarstyleDirtyFlag = false;
        this.navbarstyle = null;
    }

    public void setNavBarWidth(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNavBarWidth(n);
            return;
        }
        this.navbarwidth = n;
        this.navbarwidthDirtyFlag = true;
    }

    public Integer getNavBarWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNavBarWidth();
        }
        return this.navbarwidth;
    }

    public boolean isNavBarWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNavBarWidthDirty();
        }
        return this.navbarwidthDirtyFlag;
    }

    public void resetNavBarWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNavBarWidth();
            return;
        }
        this.navbarwidthDirtyFlag = false;
        this.navbarwidth = null;
    }

    public void setPSAppPortalViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppPortalViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappportalviewid = string;
        this.psappportalviewidDirtyFlag = true;
        super.setPSAppViewId(string);
    }

    public String getPSAppPortalViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppPortalViewId();
        }
        return this.psappportalviewid;
    }

    public boolean isPSAppPortalViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppPortalViewIdDirty();
        }
        return this.psappportalviewidDirtyFlag;
    }

    public void resetPSAppPortalViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppPortalViewId();
            return;
        }
        this.psappportalviewidDirtyFlag = false;
        this.psappportalviewid = null;
        super.resetPSAppViewId();
    }

    public void setPSAppPortalViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppPortalViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappportalviewname = string;
        this.psappportalviewnameDirtyFlag = true;
        super.setPSAppViewName(string);
    }

    public String getPSAppPortalViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppPortalViewName();
        }
        return this.psappportalviewname;
    }

    public boolean isPSAppPortalViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppPortalViewNameDirty();
        }
        return this.psappportalviewnameDirtyFlag;
    }

    public void resetPSAppPortalViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppPortalViewName();
            return;
        }
        this.psappportalviewnameDirtyFlag = false;
        this.psappportalviewname = null;
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
        PSAppPortalViewBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppPortalViewBase pSAppPortalViewBase) {
        pSAppPortalViewBase.resetColModel();
        pSAppPortalViewBase.resetCreateDate();
        pSAppPortalViewBase.resetCreateMan();
        pSAppPortalViewBase.resetDashboardNavBar();
        pSAppPortalViewBase.resetDashboardStyle();
        pSAppPortalViewBase.resetDashboardTag();
        pSAppPortalViewBase.resetDashboardTag2();
        pSAppPortalViewBase.resetDBModel();
        pSAppPortalViewBase.resetDefaultPage();
        pSAppPortalViewBase.resetEnableCustomize();
        pSAppPortalViewBase.resetFlexAlign();
        pSAppPortalViewBase.resetFlexDir();
        pSAppPortalViewBase.resetFlexVAlign();
        pSAppPortalViewBase.resetLayoutMode();
        pSAppPortalViewBase.resetNavBarHeight();
        pSAppPortalViewBase.resetNavBarPos();
        pSAppPortalViewBase.resetNavBarStyle();
        pSAppPortalViewBase.resetNavBarWidth();
        pSAppPortalViewBase.resetPSAppPortalViewId();
        pSAppPortalViewBase.resetPSAppPortalViewName();
        pSAppPortalViewBase.resetUpdateDate();
        pSAppPortalViewBase.resetUpdateMan();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isColModelDirty()) {
            hashMap.put(FIELD_COLMODEL, this.getColModel());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDashboardNavBarDirty()) {
            hashMap.put(FIELD_DASHBOARDNAVBAR, this.getDashboardNavBar());
        }
        if (!bl || this.isDashboardStyleDirty()) {
            hashMap.put(FIELD_DASHBOARDSTYLE, this.getDashboardStyle());
        }
        if (!bl || this.isDashboardTagDirty()) {
            hashMap.put(FIELD_DASHBOARDTAG, this.getDashboardTag());
        }
        if (!bl || this.isDashboardTag2Dirty()) {
            hashMap.put(FIELD_DASHBOARDTAG2, this.getDashboardTag2());
        }
        if (!bl || this.isDBModelDirty()) {
            hashMap.put(FIELD_DBMODEL, this.getDBModel());
        }
        if (!bl || this.isDefaultPageDirty()) {
            hashMap.put(FIELD_DEFAULTPAGE, this.getDefaultPage());
        }
        if (!bl || this.isEnableCustomizeDirty()) {
            hashMap.put(FIELD_ENABLECUSTOMIZE, this.getEnableCustomize());
        }
        if (!bl || this.isFlexAlignDirty()) {
            hashMap.put(FIELD_FLEXALIGN, this.getFlexAlign());
        }
        if (!bl || this.isFlexDirDirty()) {
            hashMap.put(FIELD_FLEXDIR, this.getFlexDir());
        }
        if (!bl || this.isFlexVAlignDirty()) {
            hashMap.put(FIELD_FLEXVALIGN, this.getFlexVAlign());
        }
        if (!bl || this.isLayoutModeDirty()) {
            hashMap.put(FIELD_LAYOUTMODE, this.getLayoutMode());
        }
        if (!bl || this.isNavBarHeightDirty()) {
            hashMap.put(FIELD_NAVBARHEIGHT, this.getNavBarHeight());
        }
        if (!bl || this.isNavBarPosDirty()) {
            hashMap.put(FIELD_NAVBARPOS, this.getNavBarPos());
        }
        if (!bl || this.isNavBarStyleDirty()) {
            hashMap.put(FIELD_NAVBARSTYLE, this.getNavBarStyle());
        }
        if (!bl || this.isNavBarWidthDirty()) {
            hashMap.put(FIELD_NAVBARWIDTH, this.getNavBarWidth());
        }
        if (!bl || this.isPSAppPortalViewIdDirty()) {
            hashMap.put(FIELD_PSAPPPORTALVIEWID, this.getPSAppPortalViewId());
        }
        if (!bl || this.isPSAppPortalViewNameDirty()) {
            hashMap.put(FIELD_PSAPPPORTALVIEWNAME, this.getPSAppPortalViewName());
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
        return PSAppPortalViewBase.get(this, n);
    }

    private static Object get(PSAppPortalViewBase pSAppPortalViewBase, int n) throws Exception {
        switch (n) {
            case 6: {
                return pSAppPortalViewBase.getColModel();
            }
            case 8: {
                return pSAppPortalViewBase.getCreateDate();
            }
            case 9: {
                return pSAppPortalViewBase.getCreateMan();
            }
            case 10: {
                return pSAppPortalViewBase.getDashboardNavBar();
            }
            case 11: {
                return pSAppPortalViewBase.getDashboardStyle();
            }
            case 12: {
                return pSAppPortalViewBase.getDashboardTag();
            }
            case 13: {
                return pSAppPortalViewBase.getDashboardTag2();
            }
            case 14: {
                return pSAppPortalViewBase.getDBModel();
            }
            case 15: {
                return pSAppPortalViewBase.getDefaultPage();
            }
            case 18: {
                return pSAppPortalViewBase.getEnableCustomize();
            }
            case 20: {
                return pSAppPortalViewBase.getFlexAlign();
            }
            case 21: {
                return pSAppPortalViewBase.getFlexDir();
            }
            case 22: {
                return pSAppPortalViewBase.getFlexVAlign();
            }
            case 23: {
                return pSAppPortalViewBase.getLayoutMode();
            }
            case 27: {
                return pSAppPortalViewBase.getNavBarHeight();
            }
            case 28: {
                return pSAppPortalViewBase.getNavBarPos();
            }
            case 29: {
                return pSAppPortalViewBase.getNavBarStyle();
            }
            case 30: {
                return pSAppPortalViewBase.getNavBarWidth();
            }
            case 38: {
                return pSAppPortalViewBase.getPSAppPortalViewId();
            }
            case 39: {
                return pSAppPortalViewBase.getPSAppPortalViewName();
            }
            case 94: {
                return pSAppPortalViewBase.getUpdateDate();
            }
            case 95: {
                return pSAppPortalViewBase.getUpdateMan();
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
        PSAppPortalViewBase.set(this, n, object);
    }

    private static void set(PSAppPortalViewBase pSAppPortalViewBase, int n, Object object) throws Exception {
        switch (n) {
            case 6: {
                pSAppPortalViewBase.setColModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSAppPortalViewBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSAppPortalViewBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSAppPortalViewBase.setDashboardNavBar(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSAppPortalViewBase.setDashboardStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSAppPortalViewBase.setDashboardTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSAppPortalViewBase.setDashboardTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSAppPortalViewBase.setDBModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSAppPortalViewBase.setDefaultPage(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSAppPortalViewBase.setEnableCustomize(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSAppPortalViewBase.setFlexAlign(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSAppPortalViewBase.setFlexDir(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSAppPortalViewBase.setFlexVAlign(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSAppPortalViewBase.setLayoutMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSAppPortalViewBase.setNavBarHeight(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 28: {
                pSAppPortalViewBase.setNavBarPos(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSAppPortalViewBase.setNavBarStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSAppPortalViewBase.setNavBarWidth(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 38: {
                pSAppPortalViewBase.setPSAppPortalViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSAppPortalViewBase.setPSAppPortalViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 94: {
                pSAppPortalViewBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 95: {
                pSAppPortalViewBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSAppPortalViewBase.isNull(this, n);
    }

    private static boolean isNull(PSAppPortalViewBase pSAppPortalViewBase, int n) throws Exception {
        switch (n) {
            case 6: {
                return pSAppPortalViewBase.getColModel() == null;
            }
            case 8: {
                return pSAppPortalViewBase.getCreateDate() == null;
            }
            case 9: {
                return pSAppPortalViewBase.getCreateMan() == null;
            }
            case 10: {
                return pSAppPortalViewBase.getDashboardNavBar() == null;
            }
            case 11: {
                return pSAppPortalViewBase.getDashboardStyle() == null;
            }
            case 12: {
                return pSAppPortalViewBase.getDashboardTag() == null;
            }
            case 13: {
                return pSAppPortalViewBase.getDashboardTag2() == null;
            }
            case 14: {
                return pSAppPortalViewBase.getDBModel() == null;
            }
            case 15: {
                return pSAppPortalViewBase.getDefaultPage() == null;
            }
            case 18: {
                return pSAppPortalViewBase.getEnableCustomize() == null;
            }
            case 20: {
                return pSAppPortalViewBase.getFlexAlign() == null;
            }
            case 21: {
                return pSAppPortalViewBase.getFlexDir() == null;
            }
            case 22: {
                return pSAppPortalViewBase.getFlexVAlign() == null;
            }
            case 23: {
                return pSAppPortalViewBase.getLayoutMode() == null;
            }
            case 27: {
                return pSAppPortalViewBase.getNavBarHeight() == null;
            }
            case 28: {
                return pSAppPortalViewBase.getNavBarPos() == null;
            }
            case 29: {
                return pSAppPortalViewBase.getNavBarStyle() == null;
            }
            case 30: {
                return pSAppPortalViewBase.getNavBarWidth() == null;
            }
            case 38: {
                return pSAppPortalViewBase.getPSAppPortalViewId() == null;
            }
            case 39: {
                return pSAppPortalViewBase.getPSAppPortalViewName() == null;
            }
            case 94: {
                return pSAppPortalViewBase.getUpdateDate() == null;
            }
            case 95: {
                return pSAppPortalViewBase.getUpdateMan() == null;
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
        return PSAppPortalViewBase.contains(this, n);
    }

    private static boolean contains(PSAppPortalViewBase pSAppPortalViewBase, int n) throws Exception {
        switch (n) {
            case 6: {
                return pSAppPortalViewBase.isColModelDirty();
            }
            case 8: {
                return pSAppPortalViewBase.isCreateDateDirty();
            }
            case 9: {
                return pSAppPortalViewBase.isCreateManDirty();
            }
            case 10: {
                return pSAppPortalViewBase.isDashboardNavBarDirty();
            }
            case 11: {
                return pSAppPortalViewBase.isDashboardStyleDirty();
            }
            case 12: {
                return pSAppPortalViewBase.isDashboardTagDirty();
            }
            case 13: {
                return pSAppPortalViewBase.isDashboardTag2Dirty();
            }
            case 14: {
                return pSAppPortalViewBase.isDBModelDirty();
            }
            case 15: {
                return pSAppPortalViewBase.isDefaultPageDirty();
            }
            case 18: {
                return pSAppPortalViewBase.isEnableCustomizeDirty();
            }
            case 20: {
                return pSAppPortalViewBase.isFlexAlignDirty();
            }
            case 21: {
                return pSAppPortalViewBase.isFlexDirDirty();
            }
            case 22: {
                return pSAppPortalViewBase.isFlexVAlignDirty();
            }
            case 23: {
                return pSAppPortalViewBase.isLayoutModeDirty();
            }
            case 27: {
                return pSAppPortalViewBase.isNavBarHeightDirty();
            }
            case 28: {
                return pSAppPortalViewBase.isNavBarPosDirty();
            }
            case 29: {
                return pSAppPortalViewBase.isNavBarStyleDirty();
            }
            case 30: {
                return pSAppPortalViewBase.isNavBarWidthDirty();
            }
            case 38: {
                return pSAppPortalViewBase.isPSAppPortalViewIdDirty();
            }
            case 39: {
                return pSAppPortalViewBase.isPSAppPortalViewNameDirty();
            }
            case 94: {
                return pSAppPortalViewBase.isUpdateDateDirty();
            }
            case 95: {
                return pSAppPortalViewBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppPortalViewBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppPortalViewBase pSAppPortalViewBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppPortalViewBase.getColModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"colmodel", (Object)PSAppPortalViewBase.getJSONValue((Object)pSAppPortalViewBase.getColModel()), (boolean)false);
        }
        if (bl || pSAppPortalViewBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppPortalViewBase.getJSONValue((Object)pSAppPortalViewBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppPortalViewBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppPortalViewBase.getJSONValue((Object)pSAppPortalViewBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppPortalViewBase.getDashboardNavBar() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dashboardnavbar", (Object)PSAppPortalViewBase.getJSONValue((Object)pSAppPortalViewBase.getDashboardNavBar()), (boolean)false);
        }
        if (bl || pSAppPortalViewBase.getDashboardStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dashboardstyle", (Object)PSAppPortalViewBase.getJSONValue((Object)pSAppPortalViewBase.getDashboardStyle()), (boolean)false);
        }
        if (bl || pSAppPortalViewBase.getDashboardTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dashboardtag", (Object)PSAppPortalViewBase.getJSONValue((Object)pSAppPortalViewBase.getDashboardTag()), (boolean)false);
        }
        if (bl || pSAppPortalViewBase.getDashboardTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dashboardtag2", (Object)PSAppPortalViewBase.getJSONValue((Object)pSAppPortalViewBase.getDashboardTag2()), (boolean)false);
        }
        if (bl || pSAppPortalViewBase.getDBModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbmodel", (Object)PSAppPortalViewBase.getJSONValue((Object)pSAppPortalViewBase.getDBModel()), (boolean)false);
        }
        if (bl || pSAppPortalViewBase.getDefaultPage() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultpage", (Object)PSAppPortalViewBase.getJSONValue((Object)pSAppPortalViewBase.getDefaultPage()), (boolean)false);
        }
        if (bl || pSAppPortalViewBase.getEnableCustomize() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablecustomize", (Object)PSAppPortalViewBase.getJSONValue((Object)pSAppPortalViewBase.getEnableCustomize()), (boolean)false);
        }
        if (bl || pSAppPortalViewBase.getFlexAlign() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"flexalign", (Object)PSAppPortalViewBase.getJSONValue((Object)pSAppPortalViewBase.getFlexAlign()), (boolean)false);
        }
        if (bl || pSAppPortalViewBase.getFlexDir() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"flexdir", (Object)PSAppPortalViewBase.getJSONValue((Object)pSAppPortalViewBase.getFlexDir()), (boolean)false);
        }
        if (bl || pSAppPortalViewBase.getFlexVAlign() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"flexvalign", (Object)PSAppPortalViewBase.getJSONValue((Object)pSAppPortalViewBase.getFlexVAlign()), (boolean)false);
        }
        if (bl || pSAppPortalViewBase.getLayoutMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"layoutmode", (Object)PSAppPortalViewBase.getJSONValue((Object)pSAppPortalViewBase.getLayoutMode()), (boolean)false);
        }
        if (bl || pSAppPortalViewBase.getNavBarHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navbarheight", (Object)PSAppPortalViewBase.getJSONValue((Object)pSAppPortalViewBase.getNavBarHeight()), (boolean)false);
        }
        if (bl || pSAppPortalViewBase.getNavBarPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navbarpos", (Object)PSAppPortalViewBase.getJSONValue((Object)pSAppPortalViewBase.getNavBarPos()), (boolean)false);
        }
        if (bl || pSAppPortalViewBase.getNavBarStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navbarstyle", (Object)PSAppPortalViewBase.getJSONValue((Object)pSAppPortalViewBase.getNavBarStyle()), (boolean)false);
        }
        if (bl || pSAppPortalViewBase.getNavBarWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navbarwidth", (Object)PSAppPortalViewBase.getJSONValue((Object)pSAppPortalViewBase.getNavBarWidth()), (boolean)false);
        }
        if (bl || pSAppPortalViewBase.getPSAppPortalViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappportalviewid", (Object)PSAppPortalViewBase.getJSONValue((Object)pSAppPortalViewBase.getPSAppPortalViewId()), (boolean)false);
        }
        if (bl || pSAppPortalViewBase.getPSAppPortalViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappportalviewname", (Object)PSAppPortalViewBase.getJSONValue((Object)pSAppPortalViewBase.getPSAppPortalViewName()), (boolean)false);
        }
        if (bl || pSAppPortalViewBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppPortalViewBase.getJSONValue((Object)pSAppPortalViewBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppPortalViewBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppPortalViewBase.getJSONValue((Object)pSAppPortalViewBase.getUpdateMan()), (boolean)false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppPortalViewBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppPortalViewBase pSAppPortalViewBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppPortalViewBase.getColModel() != null) {
            object = pSAppPortalViewBase.getColModel();
            xmlNode.setAttribute(FIELD_COLMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSAppPortalViewBase.getCreateDate() != null) {
            object = pSAppPortalViewBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppPortalViewBase.getCreateMan() != null) {
            object = pSAppPortalViewBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppPortalViewBase.getDashboardNavBar() != null) {
            object = pSAppPortalViewBase.getDashboardNavBar();
            xmlNode.setAttribute(FIELD_DASHBOARDNAVBAR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppPortalViewBase.getDashboardStyle() != null) {
            object = pSAppPortalViewBase.getDashboardStyle();
            xmlNode.setAttribute(FIELD_DASHBOARDSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSAppPortalViewBase.getDashboardTag() != null) {
            object = pSAppPortalViewBase.getDashboardTag();
            xmlNode.setAttribute(FIELD_DASHBOARDTAG, object == null ? "" : (String)object);
        }
        if (bl || pSAppPortalViewBase.getDashboardTag2() != null) {
            object = pSAppPortalViewBase.getDashboardTag2();
            xmlNode.setAttribute(FIELD_DASHBOARDTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSAppPortalViewBase.getDBModel() != null) {
            object = pSAppPortalViewBase.getDBModel();
            xmlNode.setAttribute(FIELD_DBMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSAppPortalViewBase.getDefaultPage() != null) {
            object = pSAppPortalViewBase.getDefaultPage();
            xmlNode.setAttribute(FIELD_DEFAULTPAGE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppPortalViewBase.getEnableCustomize() != null) {
            object = pSAppPortalViewBase.getEnableCustomize();
            xmlNode.setAttribute(FIELD_ENABLECUSTOMIZE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppPortalViewBase.getFlexAlign() != null) {
            object = pSAppPortalViewBase.getFlexAlign();
            xmlNode.setAttribute(FIELD_FLEXALIGN, object == null ? "" : (String)object);
        }
        if (bl || pSAppPortalViewBase.getFlexDir() != null) {
            object = pSAppPortalViewBase.getFlexDir();
            xmlNode.setAttribute(FIELD_FLEXDIR, object == null ? "" : (String)object);
        }
        if (bl || pSAppPortalViewBase.getFlexVAlign() != null) {
            object = pSAppPortalViewBase.getFlexVAlign();
            xmlNode.setAttribute(FIELD_FLEXVALIGN, object == null ? "" : (String)object);
        }
        if (bl || pSAppPortalViewBase.getLayoutMode() != null) {
            object = pSAppPortalViewBase.getLayoutMode();
            xmlNode.setAttribute(FIELD_LAYOUTMODE, object == null ? "" : (String)object);
        }
        if (bl || pSAppPortalViewBase.getNavBarHeight() != null) {
            object = pSAppPortalViewBase.getNavBarHeight();
            xmlNode.setAttribute(FIELD_NAVBARHEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppPortalViewBase.getNavBarPos() != null) {
            object = pSAppPortalViewBase.getNavBarPos();
            xmlNode.setAttribute(FIELD_NAVBARPOS, object == null ? "" : (String)object);
        }
        if (bl || pSAppPortalViewBase.getNavBarStyle() != null) {
            object = pSAppPortalViewBase.getNavBarStyle();
            xmlNode.setAttribute(FIELD_NAVBARSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSAppPortalViewBase.getNavBarWidth() != null) {
            object = pSAppPortalViewBase.getNavBarWidth();
            xmlNode.setAttribute(FIELD_NAVBARWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppPortalViewBase.getPSAppPortalViewId() != null) {
            object = pSAppPortalViewBase.getPSAppPortalViewId();
            xmlNode.setAttribute(FIELD_PSAPPPORTALVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSAppPortalViewBase.getPSAppPortalViewName() != null) {
            object = pSAppPortalViewBase.getPSAppPortalViewName();
            xmlNode.setAttribute(FIELD_PSAPPPORTALVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppPortalViewBase.getUpdateDate() != null) {
            object = pSAppPortalViewBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppPortalViewBase.getUpdateMan() != null) {
            object = pSAppPortalViewBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    @Override
    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppPortalViewBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppPortalViewBase pSAppPortalViewBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppPortalViewBase.isColModelDirty() && (bl || pSAppPortalViewBase.getColModel() != null)) {
            iDataObject.set(FIELD_COLMODEL, (Object)pSAppPortalViewBase.getColModel());
        }
        if (pSAppPortalViewBase.isCreateDateDirty() && (bl || pSAppPortalViewBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppPortalViewBase.getCreateDate());
        }
        if (pSAppPortalViewBase.isCreateManDirty() && (bl || pSAppPortalViewBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppPortalViewBase.getCreateMan());
        }
        if (pSAppPortalViewBase.isDashboardNavBarDirty() && (bl || pSAppPortalViewBase.getDashboardNavBar() != null)) {
            iDataObject.set(FIELD_DASHBOARDNAVBAR, (Object)pSAppPortalViewBase.getDashboardNavBar());
        }
        if (pSAppPortalViewBase.isDashboardStyleDirty() && (bl || pSAppPortalViewBase.getDashboardStyle() != null)) {
            iDataObject.set(FIELD_DASHBOARDSTYLE, (Object)pSAppPortalViewBase.getDashboardStyle());
        }
        if (pSAppPortalViewBase.isDashboardTagDirty() && (bl || pSAppPortalViewBase.getDashboardTag() != null)) {
            iDataObject.set(FIELD_DASHBOARDTAG, (Object)pSAppPortalViewBase.getDashboardTag());
        }
        if (pSAppPortalViewBase.isDashboardTag2Dirty() && (bl || pSAppPortalViewBase.getDashboardTag2() != null)) {
            iDataObject.set(FIELD_DASHBOARDTAG2, (Object)pSAppPortalViewBase.getDashboardTag2());
        }
        if (pSAppPortalViewBase.isDBModelDirty() && (bl || pSAppPortalViewBase.getDBModel() != null)) {
            iDataObject.set(FIELD_DBMODEL, (Object)pSAppPortalViewBase.getDBModel());
        }
        if (pSAppPortalViewBase.isDefaultPageDirty() && (bl || pSAppPortalViewBase.getDefaultPage() != null)) {
            iDataObject.set(FIELD_DEFAULTPAGE, (Object)pSAppPortalViewBase.getDefaultPage());
        }
        if (pSAppPortalViewBase.isEnableCustomizeDirty() && (bl || pSAppPortalViewBase.getEnableCustomize() != null)) {
            iDataObject.set(FIELD_ENABLECUSTOMIZE, (Object)pSAppPortalViewBase.getEnableCustomize());
        }
        if (pSAppPortalViewBase.isFlexAlignDirty() && (bl || pSAppPortalViewBase.getFlexAlign() != null)) {
            iDataObject.set(FIELD_FLEXALIGN, (Object)pSAppPortalViewBase.getFlexAlign());
        }
        if (pSAppPortalViewBase.isFlexDirDirty() && (bl || pSAppPortalViewBase.getFlexDir() != null)) {
            iDataObject.set(FIELD_FLEXDIR, (Object)pSAppPortalViewBase.getFlexDir());
        }
        if (pSAppPortalViewBase.isFlexVAlignDirty() && (bl || pSAppPortalViewBase.getFlexVAlign() != null)) {
            iDataObject.set(FIELD_FLEXVALIGN, (Object)pSAppPortalViewBase.getFlexVAlign());
        }
        if (pSAppPortalViewBase.isLayoutModeDirty() && (bl || pSAppPortalViewBase.getLayoutMode() != null)) {
            iDataObject.set(FIELD_LAYOUTMODE, (Object)pSAppPortalViewBase.getLayoutMode());
        }
        if (pSAppPortalViewBase.isNavBarHeightDirty() && (bl || pSAppPortalViewBase.getNavBarHeight() != null)) {
            iDataObject.set(FIELD_NAVBARHEIGHT, (Object)pSAppPortalViewBase.getNavBarHeight());
        }
        if (pSAppPortalViewBase.isNavBarPosDirty() && (bl || pSAppPortalViewBase.getNavBarPos() != null)) {
            iDataObject.set(FIELD_NAVBARPOS, (Object)pSAppPortalViewBase.getNavBarPos());
        }
        if (pSAppPortalViewBase.isNavBarStyleDirty() && (bl || pSAppPortalViewBase.getNavBarStyle() != null)) {
            iDataObject.set(FIELD_NAVBARSTYLE, (Object)pSAppPortalViewBase.getNavBarStyle());
        }
        if (pSAppPortalViewBase.isNavBarWidthDirty() && (bl || pSAppPortalViewBase.getNavBarWidth() != null)) {
            iDataObject.set(FIELD_NAVBARWIDTH, (Object)pSAppPortalViewBase.getNavBarWidth());
        }
        if (pSAppPortalViewBase.isPSAppPortalViewIdDirty() && (bl || pSAppPortalViewBase.getPSAppPortalViewId() != null)) {
            iDataObject.set(FIELD_PSAPPPORTALVIEWID, (Object)pSAppPortalViewBase.getPSAppPortalViewId());
        }
        if (pSAppPortalViewBase.isPSAppPortalViewNameDirty() && (bl || pSAppPortalViewBase.getPSAppPortalViewName() != null)) {
            iDataObject.set(FIELD_PSAPPPORTALVIEWNAME, (Object)pSAppPortalViewBase.getPSAppPortalViewName());
        }
        if (pSAppPortalViewBase.isUpdateDateDirty() && (bl || pSAppPortalViewBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppPortalViewBase.getUpdateDate());
        }
        if (pSAppPortalViewBase.isUpdateManDirty() && (bl || pSAppPortalViewBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppPortalViewBase.getUpdateMan());
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
        return PSAppPortalViewBase.remove(this, n);
    }

    private static boolean remove(PSAppPortalViewBase pSAppPortalViewBase, int n) throws Exception {
        switch (n) {
            case 6: {
                pSAppPortalViewBase.resetColModel();
                return true;
            }
            case 8: {
                pSAppPortalViewBase.resetCreateDate();
                return true;
            }
            case 9: {
                pSAppPortalViewBase.resetCreateMan();
                return true;
            }
            case 10: {
                pSAppPortalViewBase.resetDashboardNavBar();
                return true;
            }
            case 11: {
                pSAppPortalViewBase.resetDashboardStyle();
                return true;
            }
            case 12: {
                pSAppPortalViewBase.resetDashboardTag();
                return true;
            }
            case 13: {
                pSAppPortalViewBase.resetDashboardTag2();
                return true;
            }
            case 14: {
                pSAppPortalViewBase.resetDBModel();
                return true;
            }
            case 15: {
                pSAppPortalViewBase.resetDefaultPage();
                return true;
            }
            case 18: {
                pSAppPortalViewBase.resetEnableCustomize();
                return true;
            }
            case 20: {
                pSAppPortalViewBase.resetFlexAlign();
                return true;
            }
            case 21: {
                pSAppPortalViewBase.resetFlexDir();
                return true;
            }
            case 22: {
                pSAppPortalViewBase.resetFlexVAlign();
                return true;
            }
            case 23: {
                pSAppPortalViewBase.resetLayoutMode();
                return true;
            }
            case 27: {
                pSAppPortalViewBase.resetNavBarHeight();
                return true;
            }
            case 28: {
                pSAppPortalViewBase.resetNavBarPos();
                return true;
            }
            case 29: {
                pSAppPortalViewBase.resetNavBarStyle();
                return true;
            }
            case 30: {
                pSAppPortalViewBase.resetNavBarWidth();
                return true;
            }
            case 38: {
                pSAppPortalViewBase.resetPSAppPortalViewId();
                return true;
            }
            case 39: {
                pSAppPortalViewBase.resetPSAppPortalViewName();
                return true;
            }
            case 94: {
                pSAppPortalViewBase.resetUpdateDate();
                return true;
            }
            case 95: {
                pSAppPortalViewBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSAppPortalViewBase getProxyEntity() {
        return this.proxyPSAppPortalViewBase;
    }

    @Override
    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppPortalViewBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppPortalViewBase) {
            this.proxyPSAppPortalViewBase = (PSAppPortalViewBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppPortalViewService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_COLMODEL, 6);
        fieldIndexMap.put(FIELD_CREATEDATE, 8);
        fieldIndexMap.put(FIELD_CREATEMAN, 9);
        fieldIndexMap.put(FIELD_DASHBOARDNAVBAR, 10);
        fieldIndexMap.put(FIELD_DASHBOARDSTYLE, 11);
        fieldIndexMap.put(FIELD_DASHBOARDTAG, 12);
        fieldIndexMap.put(FIELD_DASHBOARDTAG2, 13);
        fieldIndexMap.put(FIELD_DBMODEL, 14);
        fieldIndexMap.put(FIELD_DEFAULTPAGE, 15);
        fieldIndexMap.put(FIELD_ENABLECUSTOMIZE, 18);
        fieldIndexMap.put(FIELD_FLEXALIGN, 20);
        fieldIndexMap.put(FIELD_FLEXDIR, 21);
        fieldIndexMap.put(FIELD_FLEXVALIGN, 22);
        fieldIndexMap.put(FIELD_LAYOUTMODE, 23);
        fieldIndexMap.put(FIELD_NAVBARHEIGHT, 27);
        fieldIndexMap.put(FIELD_NAVBARPOS, 28);
        fieldIndexMap.put(FIELD_NAVBARSTYLE, 29);
        fieldIndexMap.put(FIELD_NAVBARWIDTH, 30);
        fieldIndexMap.put(FIELD_PSAPPPORTALVIEWID, 38);
        fieldIndexMap.put(FIELD_PSAPPPORTALVIEWNAME, 39);
        fieldIndexMap.put(FIELD_UPDATEDATE, 94);
        fieldIndexMap.put(FIELD_UPDATEMAN, 95);
    }
}

