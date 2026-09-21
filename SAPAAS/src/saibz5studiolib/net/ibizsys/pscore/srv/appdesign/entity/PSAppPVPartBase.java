/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
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

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenu;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPVPart;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPortalView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppUtilView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPVPartService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPortalViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppUtilViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewService;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysResource;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.config.service.PSSysResourceService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPortlet;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniRes;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppPVPartBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppPVPartBase.class);
    public static final String FIELD_AMPSSYSPFPLUGINID = "AMPSSYSPFPLUGINID";
    public static final String FIELD_AMPSSYSPFPLUGINNAME = "AMPSSYSPFPLUGINNAME";
    public static final String FIELD_BL_POS = "BL_POS";
    public static final String FIELD_COLID = "COLID";
    public static final String FIELD_COLSPAN = "COLSPAN";
    public static final String FIELD_COL_LG = "COL_LG";
    public static final String FIELD_COL_LG_OS = "COL_LG_OS";
    public static final String FIELD_COL_MD = "COL_MD";
    public static final String FIELD_COL_MD_OS = "COL_MD_OS";
    public static final String FIELD_COL_SM = "COL_SM";
    public static final String FIELD_COL_SM_OS = "COL_SM_OS";
    public static final String FIELD_COL_XS = "COL_XS";
    public static final String FIELD_COL_XS_OS = "COL_XS_OS";
    public static final String FIELD_CONTENTTYPE = "CONTENTTYPE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DYNACLASS = "DYNACLASS";
    public static final String FIELD_ENABLEANCHOR = "ENABLEANCHOR";
    public static final String FIELD_ENABLECUSTOMMENU = "ENABLECUSTOMMENU";
    public static final String FIELD_FLEXALIGN = "FLEXALIGN";
    public static final String FIELD_FLEXBASIS = "FLEXBASIS";
    public static final String FIELD_FLEXDIR = "FLEXDIR";
    public static final String FIELD_FLEXGROW = "FLEXGROW";
    public static final String FIELD_FLEXSHRINK = "FLEXSHRINK";
    public static final String FIELD_FLEXVALIGN = "FLEXVALIGN";
    public static final String FIELD_HALIGNSELF = "HALIGNSELF";
    public static final String FIELD_HEIGHT = "HEIGHT";
    public static final String FIELD_HTMLCONTENT = "HTMLCONTENT";
    public static final String FIELD_LAYOUTMODE = "LAYOUTMODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MENUPSAPPUTILVIEWID = "MENUPSAPPUTILVIEWID";
    public static final String FIELD_MENUPSAPPUTILVIEWNAME = "MENUPSAPPUTILVIEWNAME";
    public static final String FIELD_MOBAMSTYLE = "MOBAMTYLE";
    public static final String FIELD_NEWROWMODE = "NEWROWMODE";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PARTPARAMS = "PARTPARAMS";
    public static final String FIELD_PARTSTYLE = "PARTSTYLE";
    public static final String FIELD_PORTLETTYPE = "PORTLETTYPE";
    public static final String FIELD_POSINFO = "POSINFO";
    public static final String FIELD_PPSAPPPVPARTID = "PPSAPPPVPARTID";
    public static final String FIELD_PPSAPPPVPARTNAME = "PPSAPPPVPARTNAME";
    public static final String FIELD_PSAPPMENUID = "PSAPPMENUID";
    public static final String FIELD_PSAPPMENUNAME = "PSAPPMENUNAME";
    public static final String FIELD_PSAPPPORTALVIEWID = "PSAPPPORTALVIEWID";
    public static final String FIELD_PSAPPPORTALVIEWNAME = "PSAPPPORTALVIEWNAME";
    public static final String FIELD_PSAPPPVPARTID = "PSAPPPVPARTID";
    public static final String FIELD_PSAPPPVPARTNAME = "PSAPPPVPARTNAME";
    public static final String FIELD_PSAPPVIEWID = "PSAPPVIEWID";
    public static final String FIELD_PSAPPVIEWNAME = "PSAPPVIEWNAME";
    public static final String FIELD_PSSYSCSSID = "PSSYSCSSID";
    public static final String FIELD_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String FIELD_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String FIELD_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSPORTLETID = "PSSYSPORTLETID";
    public static final String FIELD_PSSYSPORTLETNAME = "PSSYSPORTLETNAME";
    public static final String FIELD_PSSYSRESOURCEID = "PSSYSRESOURCEID";
    public static final String FIELD_PSSYSRESOURCENAME = "PSSYSRESOURCENAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSUNIRESID = "PSSYSUNIRESID";
    public static final String FIELD_PSSYSUNIRESNAME = "PSSYSUNIRESNAME";
    public static final String FIELD_PVPARTTYPE = "PVPARTTYPE";
    public static final String FIELD_RAWCONTENT = "RAWCONTENT";
    public static final String FIELD_RAWCSSSTYLE = "RAWCSSSTYLE";
    public static final String FIELD_SHOWTITLEBAR = "SHOWTITLEBAR";
    public static final String FIELD_SWAPMODE = "SWAPMODE";
    public static final String FIELD_TEMPLATEMODE = "TEMPLATEMODE";
    public static final String FIELD_TITLE = "TITLE";
    public static final String FIELD_TITLEBARCLOSEMODE = "TITLEBARCLOSEMODE";
    public static final String FIELD_TITLEPSLANRESID = "TITLEPSLANRESID";
    public static final String FIELD_TITLEPSLANRESNAME = "TITLEPSLANRESNAME";
    public static final String FIELD_TOOLTIPINFO = "TOOLTIPINFO";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VALIGNSELF = "VALIGNSELF";
    public static final String FIELD_WIDTH = "WIDTH";
    private static final int INDEX_AMPSSYSPFPLUGINID = 0;
    private static final int INDEX_AMPSSYSPFPLUGINNAME = 1;
    private static final int INDEX_BL_POS = 2;
    private static final int INDEX_COLID = 3;
    private static final int INDEX_COLSPAN = 4;
    private static final int INDEX_COL_LG = 5;
    private static final int INDEX_COL_LG_OS = 6;
    private static final int INDEX_COL_MD = 7;
    private static final int INDEX_COL_MD_OS = 8;
    private static final int INDEX_COL_SM = 9;
    private static final int INDEX_COL_SM_OS = 10;
    private static final int INDEX_COL_XS = 11;
    private static final int INDEX_COL_XS_OS = 12;
    private static final int INDEX_CONTENTTYPE = 13;
    private static final int INDEX_CREATEDATE = 14;
    private static final int INDEX_CREATEMAN = 15;
    private static final int INDEX_DYNACLASS = 16;
    private static final int INDEX_ENABLEANCHOR = 17;
    private static final int INDEX_ENABLECUSTOMMENU = 18;
    private static final int INDEX_FLEXALIGN = 19;
    private static final int INDEX_FLEXBASIS = 20;
    private static final int INDEX_FLEXDIR = 21;
    private static final int INDEX_FLEXGROW = 22;
    private static final int INDEX_FLEXSHRINK = 23;
    private static final int INDEX_FLEXVALIGN = 24;
    private static final int INDEX_HALIGNSELF = 25;
    private static final int INDEX_HEIGHT = 26;
    private static final int INDEX_HTMLCONTENT = 27;
    private static final int INDEX_LAYOUTMODE = 28;
    private static final int INDEX_MEMO = 29;
    private static final int INDEX_MENUPSAPPUTILVIEWID = 30;
    private static final int INDEX_MENUPSAPPUTILVIEWNAME = 31;
    private static final int INDEX_MOBAMSTYLE = 32;
    private static final int INDEX_NEWROWMODE = 33;
    private static final int INDEX_ORDERVALUE = 34;
    private static final int INDEX_PARTPARAMS = 35;
    private static final int INDEX_PARTSTYLE = 36;
    private static final int INDEX_PORTLETTYPE = 37;
    private static final int INDEX_POSINFO = 38;
    private static final int INDEX_PPSAPPPVPARTID = 39;
    private static final int INDEX_PPSAPPPVPARTNAME = 40;
    private static final int INDEX_PSAPPMENUID = 41;
    private static final int INDEX_PSAPPMENUNAME = 42;
    private static final int INDEX_PSAPPPORTALVIEWID = 43;
    private static final int INDEX_PSAPPPORTALVIEWNAME = 44;
    private static final int INDEX_PSAPPPVPARTID = 45;
    private static final int INDEX_PSAPPPVPARTNAME = 46;
    private static final int INDEX_PSAPPVIEWID = 47;
    private static final int INDEX_PSAPPVIEWNAME = 48;
    private static final int INDEX_PSSYSCSSID = 49;
    private static final int INDEX_PSSYSCSSNAME = 50;
    private static final int INDEX_PSSYSIMAGEID = 51;
    private static final int INDEX_PSSYSIMAGENAME = 52;
    private static final int INDEX_PSSYSPFPLUGINID = 53;
    private static final int INDEX_PSSYSPFPLUGINNAME = 54;
    private static final int INDEX_PSSYSPORTLETID = 55;
    private static final int INDEX_PSSYSPORTLETNAME = 56;
    private static final int INDEX_PSSYSRESOURCEID = 57;
    private static final int INDEX_PSSYSRESOURCENAME = 58;
    private static final int INDEX_PSSYSTEMID = 59;
    private static final int INDEX_PSSYSUNIRESID = 60;
    private static final int INDEX_PSSYSUNIRESNAME = 61;
    private static final int INDEX_PVPARTTYPE = 62;
    private static final int INDEX_RAWCONTENT = 63;
    private static final int INDEX_RAWCSSSTYLE = 64;
    private static final int INDEX_SHOWTITLEBAR = 65;
    private static final int INDEX_SWAPMODE = 66;
    private static final int INDEX_TEMPLATEMODE = 67;
    private static final int INDEX_TITLE = 68;
    private static final int INDEX_TITLEBARCLOSEMODE = 69;
    private static final int INDEX_TITLEPSLANRESID = 70;
    private static final int INDEX_TITLEPSLANRESNAME = 71;
    private static final int INDEX_TOOLTIPINFO = 72;
    private static final int INDEX_UPDATEDATE = 73;
    private static final int INDEX_UPDATEMAN = 74;
    private static final int INDEX_USERTAG = 75;
    private static final int INDEX_USERTAG2 = 76;
    private static final int INDEX_VALIDFLAG = 77;
    private static final int INDEX_VALIGNSELF = 78;
    private static final int INDEX_WIDTH = 79;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppPVPartBase proxyPSAppPVPartBase = null;
    private boolean ampssyspfpluginidDirtyFlag = false;
    private boolean ampssyspfpluginnameDirtyFlag = false;
    private boolean bl_posDirtyFlag = false;
    private boolean colidDirtyFlag = false;
    private boolean colspanDirtyFlag = false;
    private boolean col_lgDirtyFlag = false;
    private boolean col_lg_osDirtyFlag = false;
    private boolean col_mdDirtyFlag = false;
    private boolean col_md_osDirtyFlag = false;
    private boolean col_smDirtyFlag = false;
    private boolean col_sm_osDirtyFlag = false;
    private boolean col_xsDirtyFlag = false;
    private boolean col_xs_osDirtyFlag = false;
    private boolean contenttypeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dynaclassDirtyFlag = false;
    private boolean enableanchorDirtyFlag = false;
    private boolean enablecustommenuDirtyFlag = false;
    private boolean flexalignDirtyFlag = false;
    private boolean flexbasisDirtyFlag = false;
    private boolean flexdirDirtyFlag = false;
    private boolean flexgrowDirtyFlag = false;
    private boolean flexshrinkDirtyFlag = false;
    private boolean flexvalignDirtyFlag = false;
    private boolean halignselfDirtyFlag = false;
    private boolean heightDirtyFlag = false;
    private boolean htmlcontentDirtyFlag = false;
    private boolean layoutmodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean menupsapputilviewidDirtyFlag = false;
    private boolean menupsapputilviewnameDirtyFlag = false;
    private boolean mobamstyleDirtyFlag = false;
    private boolean newrowmodeDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean partparamsDirtyFlag = false;
    private boolean partstyleDirtyFlag = false;
    private boolean portlettypeDirtyFlag = false;
    private boolean posinfoDirtyFlag = false;
    private boolean ppsapppvpartidDirtyFlag = false;
    private boolean ppsapppvpartnameDirtyFlag = false;
    private boolean psappmenuidDirtyFlag = false;
    private boolean psappmenunameDirtyFlag = false;
    private boolean psappportalviewidDirtyFlag = false;
    private boolean psappportalviewnameDirtyFlag = false;
    private boolean psapppvpartidDirtyFlag = false;
    private boolean psapppvpartnameDirtyFlag = false;
    private boolean psappviewidDirtyFlag = false;
    private boolean psappviewnameDirtyFlag = false;
    private boolean pssyscssidDirtyFlag = false;
    private boolean pssyscssnameDirtyFlag = false;
    private boolean pssysimageidDirtyFlag = false;
    private boolean pssysimagenameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssysportletidDirtyFlag = false;
    private boolean pssysportletnameDirtyFlag = false;
    private boolean pssysresourceidDirtyFlag = false;
    private boolean pssysresourcenameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssysuniresidDirtyFlag = false;
    private boolean pssysuniresnameDirtyFlag = false;
    private boolean pvparttypeDirtyFlag = false;
    private boolean rawcontentDirtyFlag = false;
    private boolean rawcssstyleDirtyFlag = false;
    private boolean showtitlebarDirtyFlag = false;
    private boolean swapmodeDirtyFlag = false;
    private boolean templatemodeDirtyFlag = false;
    private boolean titleDirtyFlag = false;
    private boolean titlebarclosemodeDirtyFlag = false;
    private boolean titlepslanresidDirtyFlag = false;
    private boolean titlepslanresnameDirtyFlag = false;
    private boolean tooltipinfoDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean valignselfDirtyFlag = false;
    private boolean widthDirtyFlag = false;
    @Column(name="ampssyspfpluginid")
    private String ampssyspfpluginid;
    @Column(name="ampssyspfpluginname")
    private String ampssyspfpluginname;
    @Column(name="bl_pos")
    private String bl_pos;
    @Column(name="colid")
    private Integer colid;
    @Column(name="colspan")
    private Integer colspan;
    @Column(name="col_lg")
    private Integer col_lg;
    @Column(name="col_lg_os")
    private Integer col_lg_os;
    @Column(name="col_md")
    private Integer col_md;
    @Column(name="col_md_os")
    private Integer col_md_os;
    @Column(name="col_sm")
    private Integer col_sm;
    @Column(name="col_sm_os")
    private Integer col_sm_os;
    @Column(name="col_xs")
    private Integer col_xs;
    @Column(name="col_xs_os")
    private Integer col_xs_os;
    @Column(name="contenttype")
    private String contenttype;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dynaclass")
    private String dynaclass;
    @Column(name="enableanchor")
    private Integer enableanchor;
    @Column(name="enablecustommenu")
    private Integer enablecustommenu;
    @Column(name="flexalign")
    private String flexalign;
    @Column(name="flexbasis")
    private Integer flexbasis;
    @Column(name="flexdir")
    private String flexdir;
    @Column(name="flexgrow")
    private Integer flexgrow;
    @Column(name="flexshrink")
    private Integer flexshrink;
    @Column(name="flexvalign")
    private String flexvalign;
    @Column(name="halignself")
    private String halignself;
    @Column(name="height")
    private Integer height;
    @Column(name="htmlcontent")
    private String htmlcontent;
    @Column(name="layoutmode")
    private String layoutmode;
    @Column(name="memo")
    private String memo;
    @Column(name="menupsapputilviewid")
    private String menupsapputilviewid;
    @Column(name="menupsapputilviewname")
    private String menupsapputilviewname;
    @Column(name="mobamstyle")
    private String mobamstyle;
    @Column(name="newrowmode")
    private Integer newrowmode;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="partparams")
    private String partparams;
    @Column(name="partstyle")
    private String partstyle;
    @Column(name="portlettype")
    private String portlettype;
    @Column(name="posinfo")
    private String posinfo;
    @Column(name="ppsapppvpartid")
    private String ppsapppvpartid;
    @Column(name="ppsapppvpartname")
    private String ppsapppvpartname;
    @Column(name="psappmenuid")
    private String psappmenuid;
    @Column(name="psappmenuname")
    private String psappmenuname;
    @Column(name="psappportalviewid")
    private String psappportalviewid;
    @Column(name="psappportalviewname")
    private String psappportalviewname;
    @Column(name="psapppvpartid")
    private String psapppvpartid;
    @Column(name="psapppvpartname")
    private String psapppvpartname;
    @Column(name="psappviewid")
    private String psappviewid;
    @Column(name="psappviewname")
    private String psappviewname;
    @Column(name="pssyscssid")
    private String pssyscssid;
    @Column(name="pssyscssname")
    private String pssyscssname;
    @Column(name="pssysimageid")
    private String pssysimageid;
    @Column(name="pssysimagename")
    private String pssysimagename;
    @Column(name="pssyspfpluginid")
    private String pssyspfpluginid;
    @Column(name="pssyspfpluginname")
    private String pssyspfpluginname;
    @Column(name="pssysportletid")
    private String pssysportletid;
    @Column(name="pssysportletname")
    private String pssysportletname;
    @Column(name="pssysresourceid")
    private String pssysresourceid;
    @Column(name="pssysresourcename")
    private String pssysresourcename;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssysuniresid")
    private String pssysuniresid;
    @Column(name="pssysuniresname")
    private String pssysuniresname;
    @Column(name="pvparttype")
    private String pvparttype;
    @Column(name="rawcontent")
    private String rawcontent;
    @Column(name="rawcssstyle")
    private String rawcssstyle;
    @Column(name="showtitlebar")
    private Integer showtitlebar;
    @Column(name="swapmode")
    private String swapmode;
    @Column(name="templatemode")
    private Integer templatemode;
    @Column(name="title")
    private String title;
    @Column(name="titlebarclosemode")
    private Integer titlebarclosemode;
    @Column(name="titlepslanresid")
    private String titlepslanresid;
    @Column(name="titlepslanresname")
    private String titlepslanresname;
    @Column(name="tooltipinfo")
    private String tooltipinfo;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="valignself")
    private String valignself;
    @Column(name="width")
    private Integer width;
    private Integer objPSAppMenuLock = new Integer(1);
    private PSAppMenu psappmenu = null;
    private Integer objPSAppPortalViewLock = new Integer(1);
    private PSAppPortalView psappportalview = null;
    private Integer objPPSAppPVPartLock = new Integer(1);
    private PSAppPVPart ppsapppvpart = null;
    private Integer objMenuPSAppUtilViewLock = new Integer(1);
    private PSAppUtilView menupsapputilview = null;
    private Integer objPSAppViewLock = new Integer(1);
    private PSAppView psappview = null;
    private Integer objTitlePSLanResLock = new Integer(1);
    private PSLanguageRes titlepslanres = null;
    private Integer objPSSysCssLock = new Integer(1);
    private PSSysCss pssyscss = null;
    private Integer objPSSysImageLock = new Integer(1);
    private PSSysImage pssysimage = null;
    private Integer objAMPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin ampssyspfplugin = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSSysPortletLock = new Integer(1);
    private PSSysPortlet pssysportlet = null;
    private Integer objPSSysResourceLock = new Integer(1);
    private PSSysResource pssysresource = null;
    private Integer objPSSysUniResLock = new Integer(1);
    private PSSysUniRes pssysunires = null;
    private Integer objPSAppPVPartsLock = new Integer(1);
    private ArrayList<PSAppPVPart> psapppvparts = null;

    public void setAMPSSysPFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAMPSSysPFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ampssyspfpluginid = string;
        this.ampssyspfpluginidDirtyFlag = true;
    }

    public String getAMPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAMPSSysPFPluginId();
        }
        return this.ampssyspfpluginid;
    }

    public boolean isAMPSSysPFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAMPSSysPFPluginIdDirty();
        }
        return this.ampssyspfpluginidDirtyFlag;
    }

    public void resetAMPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAMPSSysPFPluginId();
            return;
        }
        this.ampssyspfpluginidDirtyFlag = false;
        this.ampssyspfpluginid = null;
    }

    public void setAMPSSysPFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAMPSSysPFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ampssyspfpluginname = string;
        this.ampssyspfpluginnameDirtyFlag = true;
    }

    public String getAMPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAMPSSysPFPluginName();
        }
        return this.ampssyspfpluginname;
    }

    public boolean isAMPSSysPFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAMPSSysPFPluginNameDirty();
        }
        return this.ampssyspfpluginnameDirtyFlag;
    }

    public void resetAMPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAMPSSysPFPluginName();
            return;
        }
        this.ampssyspfpluginnameDirtyFlag = false;
        this.ampssyspfpluginname = null;
    }

    public void setBL_Pos(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBL_Pos(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bl_pos = string;
        this.bl_posDirtyFlag = true;
    }

    public String getBL_Pos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBL_Pos();
        }
        return this.bl_pos;
    }

    public boolean isBL_PosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBL_PosDirty();
        }
        return this.bl_posDirtyFlag;
    }

    public void resetBL_Pos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBL_Pos();
            return;
        }
        this.bl_posDirtyFlag = false;
        this.bl_pos = null;
    }

    public void setColId(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setColId(n);
            return;
        }
        this.colid = n;
        this.colidDirtyFlag = true;
    }

    public Integer getColId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getColId();
        }
        return this.colid;
    }

    public boolean isColIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isColIdDirty();
        }
        return this.colidDirtyFlag;
    }

    public void resetColId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetColId();
            return;
        }
        this.colidDirtyFlag = false;
        this.colid = null;
    }

    public void setColSpan(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setColSpan(n);
            return;
        }
        this.colspan = n;
        this.colspanDirtyFlag = true;
    }

    public Integer getColSpan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getColSpan();
        }
        return this.colspan;
    }

    public boolean isColSpanDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isColSpanDirty();
        }
        return this.colspanDirtyFlag;
    }

    public void resetColSpan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetColSpan();
            return;
        }
        this.colspanDirtyFlag = false;
        this.colspan = null;
    }

    public void setCol_LG(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCol_LG(n);
            return;
        }
        this.col_lg = n;
        this.col_lgDirtyFlag = true;
    }

    public Integer getCol_LG() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCol_LG();
        }
        return this.col_lg;
    }

    public boolean isCol_LGDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCol_LGDirty();
        }
        return this.col_lgDirtyFlag;
    }

    public void resetCol_LG() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCol_LG();
            return;
        }
        this.col_lgDirtyFlag = false;
        this.col_lg = null;
    }

    public void setCol_LG_OS(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCol_LG_OS(n);
            return;
        }
        this.col_lg_os = n;
        this.col_lg_osDirtyFlag = true;
    }

    public Integer getCol_LG_OS() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCol_LG_OS();
        }
        return this.col_lg_os;
    }

    public boolean isCol_LG_OSDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCol_LG_OSDirty();
        }
        return this.col_lg_osDirtyFlag;
    }

    public void resetCol_LG_OS() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCol_LG_OS();
            return;
        }
        this.col_lg_osDirtyFlag = false;
        this.col_lg_os = null;
    }

    public void setCol_MD(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCol_MD(n);
            return;
        }
        this.col_md = n;
        this.col_mdDirtyFlag = true;
    }

    public Integer getCol_MD() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCol_MD();
        }
        return this.col_md;
    }

    public boolean isCol_MDDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCol_MDDirty();
        }
        return this.col_mdDirtyFlag;
    }

    public void resetCol_MD() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCol_MD();
            return;
        }
        this.col_mdDirtyFlag = false;
        this.col_md = null;
    }

    public void setCol_MD_OS(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCol_MD_OS(n);
            return;
        }
        this.col_md_os = n;
        this.col_md_osDirtyFlag = true;
    }

    public Integer getCol_MD_OS() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCol_MD_OS();
        }
        return this.col_md_os;
    }

    public boolean isCol_MD_OSDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCol_MD_OSDirty();
        }
        return this.col_md_osDirtyFlag;
    }

    public void resetCol_MD_OS() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCol_MD_OS();
            return;
        }
        this.col_md_osDirtyFlag = false;
        this.col_md_os = null;
    }

    public void setCol_SM(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCol_SM(n);
            return;
        }
        this.col_sm = n;
        this.col_smDirtyFlag = true;
    }

    public Integer getCol_SM() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCol_SM();
        }
        return this.col_sm;
    }

    public boolean isCol_SMDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCol_SMDirty();
        }
        return this.col_smDirtyFlag;
    }

    public void resetCol_SM() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCol_SM();
            return;
        }
        this.col_smDirtyFlag = false;
        this.col_sm = null;
    }

    public void setCol_SM_OS(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCol_SM_OS(n);
            return;
        }
        this.col_sm_os = n;
        this.col_sm_osDirtyFlag = true;
    }

    public Integer getCol_SM_OS() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCol_SM_OS();
        }
        return this.col_sm_os;
    }

    public boolean isCol_SM_OSDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCol_SM_OSDirty();
        }
        return this.col_sm_osDirtyFlag;
    }

    public void resetCol_SM_OS() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCol_SM_OS();
            return;
        }
        this.col_sm_osDirtyFlag = false;
        this.col_sm_os = null;
    }

    public void setCol_XS(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCol_XS(n);
            return;
        }
        this.col_xs = n;
        this.col_xsDirtyFlag = true;
    }

    public Integer getCol_XS() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCol_XS();
        }
        return this.col_xs;
    }

    public boolean isCol_XSDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCol_XSDirty();
        }
        return this.col_xsDirtyFlag;
    }

    public void resetCol_XS() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCol_XS();
            return;
        }
        this.col_xsDirtyFlag = false;
        this.col_xs = null;
    }

    public void setCol_XS_OS(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCol_XS_OS(n);
            return;
        }
        this.col_xs_os = n;
        this.col_xs_osDirtyFlag = true;
    }

    public Integer getCol_XS_OS() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCol_XS_OS();
        }
        return this.col_xs_os;
    }

    public boolean isCol_XS_OSDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCol_XS_OSDirty();
        }
        return this.col_xs_osDirtyFlag;
    }

    public void resetCol_XS_OS() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCol_XS_OS();
            return;
        }
        this.col_xs_osDirtyFlag = false;
        this.col_xs_os = null;
    }

    public void setContentType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContentType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.contenttype = string;
        this.contenttypeDirtyFlag = true;
    }

    public String getContentType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentType();
        }
        return this.contenttype;
    }

    public boolean isContentTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentTypeDirty();
        }
        return this.contenttypeDirtyFlag;
    }

    public void resetContentType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContentType();
            return;
        }
        this.contenttypeDirtyFlag = false;
        this.contenttype = null;
    }

    public void setCreateDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDate(timestamp);
            return;
        }
        this.createdate = timestamp;
        this.createdateDirtyFlag = true;
    }

    public Timestamp getCreateDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateDate();
        }
        return this.createdate;
    }

    public boolean isCreateDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateDateDirty();
        }
        return this.createdateDirtyFlag;
    }

    public void resetCreateDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateDate();
            return;
        }
        this.createdateDirtyFlag = false;
        this.createdate = null;
    }

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

    public String getCreateMan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateMan();
        }
        return this.createman;
    }

    public boolean isCreateManDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateManDirty();
        }
        return this.createmanDirtyFlag;
    }

    public void resetCreateMan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateMan();
            return;
        }
        this.createmanDirtyFlag = false;
        this.createman = null;
    }

    public void setDynaClass(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaClass(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dynaclass = string;
        this.dynaclassDirtyFlag = true;
    }

    public String getDynaClass() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaClass();
        }
        return this.dynaclass;
    }

    public boolean isDynaClassDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaClassDirty();
        }
        return this.dynaclassDirtyFlag;
    }

    public void resetDynaClass() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaClass();
            return;
        }
        this.dynaclassDirtyFlag = false;
        this.dynaclass = null;
    }

    public void setEnableAnchor(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableAnchor(n);
            return;
        }
        this.enableanchor = n;
        this.enableanchorDirtyFlag = true;
    }

    public Integer getEnableAnchor() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableAnchor();
        }
        return this.enableanchor;
    }

    public boolean isEnableAnchorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableAnchorDirty();
        }
        return this.enableanchorDirtyFlag;
    }

    public void resetEnableAnchor() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableAnchor();
            return;
        }
        this.enableanchorDirtyFlag = false;
        this.enableanchor = null;
    }

    public void setEnableCustomMenu(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableCustomMenu(n);
            return;
        }
        this.enablecustommenu = n;
        this.enablecustommenuDirtyFlag = true;
    }

    public Integer getEnableCustomMenu() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableCustomMenu();
        }
        return this.enablecustommenu;
    }

    public boolean isEnableCustomMenuDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableCustomMenuDirty();
        }
        return this.enablecustommenuDirtyFlag;
    }

    public void resetEnableCustomMenu() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableCustomMenu();
            return;
        }
        this.enablecustommenuDirtyFlag = false;
        this.enablecustommenu = null;
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

    public void setFlexBasis(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFlexBasis(n);
            return;
        }
        this.flexbasis = n;
        this.flexbasisDirtyFlag = true;
    }

    public Integer getFlexBasis() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFlexBasis();
        }
        return this.flexbasis;
    }

    public boolean isFlexBasisDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFlexBasisDirty();
        }
        return this.flexbasisDirtyFlag;
    }

    public void resetFlexBasis() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFlexBasis();
            return;
        }
        this.flexbasisDirtyFlag = false;
        this.flexbasis = null;
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

    public void setFlexGrow(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFlexGrow(n);
            return;
        }
        this.flexgrow = n;
        this.flexgrowDirtyFlag = true;
    }

    public Integer getFlexGrow() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFlexGrow();
        }
        return this.flexgrow;
    }

    public boolean isFlexGrowDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFlexGrowDirty();
        }
        return this.flexgrowDirtyFlag;
    }

    public void resetFlexGrow() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFlexGrow();
            return;
        }
        this.flexgrowDirtyFlag = false;
        this.flexgrow = null;
    }

    public void setFlexShrink(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFlexShrink(n);
            return;
        }
        this.flexshrink = n;
        this.flexshrinkDirtyFlag = true;
    }

    public Integer getFlexShrink() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFlexShrink();
        }
        return this.flexshrink;
    }

    public boolean isFlexShrinkDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFlexShrinkDirty();
        }
        return this.flexshrinkDirtyFlag;
    }

    public void resetFlexShrink() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFlexShrink();
            return;
        }
        this.flexshrinkDirtyFlag = false;
        this.flexshrink = null;
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

    public void setHAlignSelf(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHAlignSelf(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.halignself = string;
        this.halignselfDirtyFlag = true;
    }

    public String getHAlignSelf() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHAlignSelf();
        }
        return this.halignself;
    }

    public boolean isHAlignSelfDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHAlignSelfDirty();
        }
        return this.halignselfDirtyFlag;
    }

    public void resetHAlignSelf() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHAlignSelf();
            return;
        }
        this.halignselfDirtyFlag = false;
        this.halignself = null;
    }

    public void setHeight(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHeight(n);
            return;
        }
        this.height = n;
        this.heightDirtyFlag = true;
    }

    public Integer getHeight() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHeight();
        }
        return this.height;
    }

    public boolean isHeightDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHeightDirty();
        }
        return this.heightDirtyFlag;
    }

    public void resetHeight() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHeight();
            return;
        }
        this.heightDirtyFlag = false;
        this.height = null;
    }

    public void setHtmlContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHtmlContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.htmlcontent = string;
        this.htmlcontentDirtyFlag = true;
    }

    public String getHtmlContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHtmlContent();
        }
        return this.htmlcontent;
    }

    public boolean isHtmlContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHtmlContentDirty();
        }
        return this.htmlcontentDirtyFlag;
    }

    public void resetHtmlContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHtmlContent();
            return;
        }
        this.htmlcontentDirtyFlag = false;
        this.htmlcontent = null;
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

    public void setMemo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMemo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.memo = string;
        this.memoDirtyFlag = true;
    }

    public String getMemo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMemo();
        }
        return this.memo;
    }

    public boolean isMemoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMemoDirty();
        }
        return this.memoDirtyFlag;
    }

    public void resetMemo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMemo();
            return;
        }
        this.memoDirtyFlag = false;
        this.memo = null;
    }

    public void setMenuPSAppUtilViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMenuPSAppUtilViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.menupsapputilviewid = string;
        this.menupsapputilviewidDirtyFlag = true;
    }

    public String getMenuPSAppUtilViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMenuPSAppUtilViewId();
        }
        return this.menupsapputilviewid;
    }

    public boolean isMenuPSAppUtilViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMenuPSAppUtilViewIdDirty();
        }
        return this.menupsapputilviewidDirtyFlag;
    }

    public void resetMenuPSAppUtilViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMenuPSAppUtilViewId();
            return;
        }
        this.menupsapputilviewidDirtyFlag = false;
        this.menupsapputilviewid = null;
    }

    public void setMenuPSAppUtilViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMenuPSAppUtilViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.menupsapputilviewname = string;
        this.menupsapputilviewnameDirtyFlag = true;
    }

    public String getMenuPSAppUtilViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMenuPSAppUtilViewName();
        }
        return this.menupsapputilviewname;
    }

    public boolean isMenuPSAppUtilViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMenuPSAppUtilViewNameDirty();
        }
        return this.menupsapputilviewnameDirtyFlag;
    }

    public void resetMenuPSAppUtilViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMenuPSAppUtilViewName();
            return;
        }
        this.menupsapputilviewnameDirtyFlag = false;
        this.menupsapputilviewname = null;
    }

    public void setMOBAMStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMOBAMStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobamstyle = string;
        this.mobamstyleDirtyFlag = true;
    }

    public String getMOBAMStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMOBAMStyle();
        }
        return this.mobamstyle;
    }

    public boolean isMOBAMStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMOBAMStyleDirty();
        }
        return this.mobamstyleDirtyFlag;
    }

    public void resetMOBAMStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMOBAMStyle();
            return;
        }
        this.mobamstyleDirtyFlag = false;
        this.mobamstyle = null;
    }

    public void setNewRowMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNewRowMode(n);
            return;
        }
        this.newrowmode = n;
        this.newrowmodeDirtyFlag = true;
    }

    public Integer getNewRowMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNewRowMode();
        }
        return this.newrowmode;
    }

    public boolean isNewRowModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNewRowModeDirty();
        }
        return this.newrowmodeDirtyFlag;
    }

    public void resetNewRowMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNewRowMode();
            return;
        }
        this.newrowmodeDirtyFlag = false;
        this.newrowmode = null;
    }

    public void setOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderValue(n);
            return;
        }
        this.ordervalue = n;
        this.ordervalueDirtyFlag = true;
    }

    public Integer getOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValue();
        }
        return this.ordervalue;
    }

    public boolean isOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderValueDirty();
        }
        return this.ordervalueDirtyFlag;
    }

    public void resetOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderValue();
            return;
        }
        this.ordervalueDirtyFlag = false;
        this.ordervalue = null;
    }

    public void setPartParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPartParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.partparams = string;
        this.partparamsDirtyFlag = true;
    }

    public String getPartParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPartParams();
        }
        return this.partparams;
    }

    public boolean isPartParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPartParamsDirty();
        }
        return this.partparamsDirtyFlag;
    }

    public void resetPartParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPartParams();
            return;
        }
        this.partparamsDirtyFlag = false;
        this.partparams = null;
    }

    public void setPartStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPartStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.partstyle = string;
        this.partstyleDirtyFlag = true;
    }

    public String getPartStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPartStyle();
        }
        return this.partstyle;
    }

    public boolean isPartStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPartStyleDirty();
        }
        return this.partstyleDirtyFlag;
    }

    public void resetPartStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPartStyle();
            return;
        }
        this.partstyleDirtyFlag = false;
        this.partstyle = null;
    }

    public void setPortletType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPortletType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.portlettype = string;
        this.portlettypeDirtyFlag = true;
    }

    public String getPortletType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPortletType();
        }
        return this.portlettype;
    }

    public boolean isPortletTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPortletTypeDirty();
        }
        return this.portlettypeDirtyFlag;
    }

    public void resetPortletType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPortletType();
            return;
        }
        this.portlettypeDirtyFlag = false;
        this.portlettype = null;
    }

    public void setPosInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPosInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.posinfo = string;
        this.posinfoDirtyFlag = true;
    }

    public String getPosInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPosInfo();
        }
        return this.posinfo;
    }

    public boolean isPosInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPosInfoDirty();
        }
        return this.posinfoDirtyFlag;
    }

    public void resetPosInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPosInfo();
            return;
        }
        this.posinfoDirtyFlag = false;
        this.posinfo = null;
    }

    public void setPPSAppPVPartId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSAppPVPartId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsapppvpartid = string;
        this.ppsapppvpartidDirtyFlag = true;
    }

    public String getPPSAppPVPartId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSAppPVPartId();
        }
        return this.ppsapppvpartid;
    }

    public boolean isPPSAppPVPartIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSAppPVPartIdDirty();
        }
        return this.ppsapppvpartidDirtyFlag;
    }

    public void resetPPSAppPVPartId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSAppPVPartId();
            return;
        }
        this.ppsapppvpartidDirtyFlag = false;
        this.ppsapppvpartid = null;
    }

    public void setPPSAppPVPartName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSAppPVPartName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsapppvpartname = string;
        this.ppsapppvpartnameDirtyFlag = true;
    }

    public String getPPSAppPVPartName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSAppPVPartName();
        }
        return this.ppsapppvpartname;
    }

    public boolean isPPSAppPVPartNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSAppPVPartNameDirty();
        }
        return this.ppsapppvpartnameDirtyFlag;
    }

    public void resetPPSAppPVPartName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSAppPVPartName();
            return;
        }
        this.ppsapppvpartnameDirtyFlag = false;
        this.ppsapppvpartname = null;
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

    public void setPSAppPVPartId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppPVPartId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapppvpartid = string;
        this.psapppvpartidDirtyFlag = true;
    }

    public String getPSAppPVPartId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppPVPartId();
        }
        return this.psapppvpartid;
    }

    public boolean isPSAppPVPartIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppPVPartIdDirty();
        }
        return this.psapppvpartidDirtyFlag;
    }

    public void resetPSAppPVPartId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppPVPartId();
            return;
        }
        this.psapppvpartidDirtyFlag = false;
        this.psapppvpartid = null;
    }

    public void setPSAppPVPartName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppPVPartName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        if (string != null) {
            string = string.toLowerCase();
        }
        this.psapppvpartname = string;
        this.psapppvpartnameDirtyFlag = true;
    }

    public String getPSAppPVPartName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppPVPartName();
        }
        return this.psapppvpartname;
    }

    public boolean isPSAppPVPartNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppPVPartNameDirty();
        }
        return this.psapppvpartnameDirtyFlag;
    }

    public void resetPSAppPVPartName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppPVPartName();
            return;
        }
        this.psapppvpartnameDirtyFlag = false;
        this.psapppvpartname = null;
    }

    public void setPSAppViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewid = string;
        this.psappviewidDirtyFlag = true;
    }

    public String getPSAppViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewId();
        }
        return this.psappviewid;
    }

    public boolean isPSAppViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewIdDirty();
        }
        return this.psappviewidDirtyFlag;
    }

    public void resetPSAppViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewId();
            return;
        }
        this.psappviewidDirtyFlag = false;
        this.psappviewid = null;
    }

    public void setPSAppViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewname = string;
        this.psappviewnameDirtyFlag = true;
    }

    public String getPSAppViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewName();
        }
        return this.psappviewname;
    }

    public boolean isPSAppViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewNameDirty();
        }
        return this.psappviewnameDirtyFlag;
    }

    public void resetPSAppViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewName();
            return;
        }
        this.psappviewnameDirtyFlag = false;
        this.psappviewname = null;
    }

    public void setPSSysCssId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCssId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscssid = string;
        this.pssyscssidDirtyFlag = true;
    }

    public String getPSSysCssId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCssId();
        }
        return this.pssyscssid;
    }

    public boolean isPSSysCssIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCssIdDirty();
        }
        return this.pssyscssidDirtyFlag;
    }

    public void resetPSSysCssId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCssId();
            return;
        }
        this.pssyscssidDirtyFlag = false;
        this.pssyscssid = null;
    }

    public void setPSSysCssName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCssName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscssname = string;
        this.pssyscssnameDirtyFlag = true;
    }

    public String getPSSysCssName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCssName();
        }
        return this.pssyscssname;
    }

    public boolean isPSSysCssNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCssNameDirty();
        }
        return this.pssyscssnameDirtyFlag;
    }

    public void resetPSSysCssName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCssName();
            return;
        }
        this.pssyscssnameDirtyFlag = false;
        this.pssyscssname = null;
    }

    public void setPSSysImageId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysImageId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysimageid = string;
        this.pssysimageidDirtyFlag = true;
    }

    public String getPSSysImageId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysImageId();
        }
        return this.pssysimageid;
    }

    public boolean isPSSysImageIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysImageIdDirty();
        }
        return this.pssysimageidDirtyFlag;
    }

    public void resetPSSysImageId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysImageId();
            return;
        }
        this.pssysimageidDirtyFlag = false;
        this.pssysimageid = null;
    }

    public void setPSSysImageName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysImageName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysimagename = string;
        this.pssysimagenameDirtyFlag = true;
    }

    public String getPSSysImageName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysImageName();
        }
        return this.pssysimagename;
    }

    public boolean isPSSysImageNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysImageNameDirty();
        }
        return this.pssysimagenameDirtyFlag;
    }

    public void resetPSSysImageName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysImageName();
            return;
        }
        this.pssysimagenameDirtyFlag = false;
        this.pssysimagename = null;
    }

    public void setPSSysPFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspfpluginid = string;
        this.pssyspfpluginidDirtyFlag = true;
    }

    public String getPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPluginId();
        }
        return this.pssyspfpluginid;
    }

    public boolean isPSSysPFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPFPluginIdDirty();
        }
        return this.pssyspfpluginidDirtyFlag;
    }

    public void resetPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPFPluginId();
            return;
        }
        this.pssyspfpluginidDirtyFlag = false;
        this.pssyspfpluginid = null;
    }

    public void setPSSysPFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspfpluginname = string;
        this.pssyspfpluginnameDirtyFlag = true;
    }

    public String getPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPluginName();
        }
        return this.pssyspfpluginname;
    }

    public boolean isPSSysPFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPFPluginNameDirty();
        }
        return this.pssyspfpluginnameDirtyFlag;
    }

    public void resetPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPFPluginName();
            return;
        }
        this.pssyspfpluginnameDirtyFlag = false;
        this.pssyspfpluginname = null;
    }

    public void setPSSysPortletId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPortletId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysportletid = string;
        this.pssysportletidDirtyFlag = true;
    }

    public String getPSSysPortletId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPortletId();
        }
        return this.pssysportletid;
    }

    public boolean isPSSysPortletIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPortletIdDirty();
        }
        return this.pssysportletidDirtyFlag;
    }

    public void resetPSSysPortletId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPortletId();
            return;
        }
        this.pssysportletidDirtyFlag = false;
        this.pssysportletid = null;
    }

    public void setPSSysPortletName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPortletName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysportletname = string;
        this.pssysportletnameDirtyFlag = true;
    }

    public String getPSSysPortletName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPortletName();
        }
        return this.pssysportletname;
    }

    public boolean isPSSysPortletNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPortletNameDirty();
        }
        return this.pssysportletnameDirtyFlag;
    }

    public void resetPSSysPortletName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPortletName();
            return;
        }
        this.pssysportletnameDirtyFlag = false;
        this.pssysportletname = null;
    }

    public void setPSSysResourceId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysResourceId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysresourceid = string;
        this.pssysresourceidDirtyFlag = true;
    }

    public String getPSSysResourceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysResourceId();
        }
        return this.pssysresourceid;
    }

    public boolean isPSSysResourceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysResourceIdDirty();
        }
        return this.pssysresourceidDirtyFlag;
    }

    public void resetPSSysResourceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysResourceId();
            return;
        }
        this.pssysresourceidDirtyFlag = false;
        this.pssysresourceid = null;
    }

    public void setPSSysResourceName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysResourceName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysresourcename = string;
        this.pssysresourcenameDirtyFlag = true;
    }

    public String getPSSysResourceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysResourceName();
        }
        return this.pssysresourcename;
    }

    public boolean isPSSysResourceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysResourceNameDirty();
        }
        return this.pssysresourcenameDirtyFlag;
    }

    public void resetPSSysResourceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysResourceName();
            return;
        }
        this.pssysresourcenameDirtyFlag = false;
        this.pssysresourcename = null;
    }

    public void setPSSystemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemid = string;
        this.pssystemidDirtyFlag = true;
    }

    public String getPSSystemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemId();
        }
        return this.pssystemid;
    }

    public boolean isPSSystemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemIdDirty();
        }
        return this.pssystemidDirtyFlag;
    }

    public void resetPSSystemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemId();
            return;
        }
        this.pssystemidDirtyFlag = false;
        this.pssystemid = null;
    }

    public void setPSSysUniResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUniResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysuniresid = string;
        this.pssysuniresidDirtyFlag = true;
    }

    public String getPSSysUniResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUniResId();
        }
        return this.pssysuniresid;
    }

    public boolean isPSSysUniResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUniResIdDirty();
        }
        return this.pssysuniresidDirtyFlag;
    }

    public void resetPSSysUniResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUniResId();
            return;
        }
        this.pssysuniresidDirtyFlag = false;
        this.pssysuniresid = null;
    }

    public void setPSSysUniResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUniResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysuniresname = string;
        this.pssysuniresnameDirtyFlag = true;
    }

    public String getPSSysUniResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUniResName();
        }
        return this.pssysuniresname;
    }

    public boolean isPSSysUniResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUniResNameDirty();
        }
        return this.pssysuniresnameDirtyFlag;
    }

    public void resetPSSysUniResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUniResName();
            return;
        }
        this.pssysuniresnameDirtyFlag = false;
        this.pssysuniresname = null;
    }

    public void setPVPartType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPVPartType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pvparttype = string;
        this.pvparttypeDirtyFlag = true;
    }

    public String getPVPartType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPVPartType();
        }
        return this.pvparttype;
    }

    public boolean isPVPartTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPVPartTypeDirty();
        }
        return this.pvparttypeDirtyFlag;
    }

    public void resetPVPartType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPVPartType();
            return;
        }
        this.pvparttypeDirtyFlag = false;
        this.pvparttype = null;
    }

    public void setRawContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRawContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rawcontent = string;
        this.rawcontentDirtyFlag = true;
    }

    public String getRawContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRawContent();
        }
        return this.rawcontent;
    }

    public boolean isRawContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRawContentDirty();
        }
        return this.rawcontentDirtyFlag;
    }

    public void resetRawContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRawContent();
            return;
        }
        this.rawcontentDirtyFlag = false;
        this.rawcontent = null;
    }

    public void setRawCssStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRawCssStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rawcssstyle = string;
        this.rawcssstyleDirtyFlag = true;
    }

    public String getRawCssStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRawCssStyle();
        }
        return this.rawcssstyle;
    }

    public boolean isRawCssStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRawCssStyleDirty();
        }
        return this.rawcssstyleDirtyFlag;
    }

    public void resetRawCssStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRawCssStyle();
            return;
        }
        this.rawcssstyleDirtyFlag = false;
        this.rawcssstyle = null;
    }

    public void setShowTitleBar(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setShowTitleBar(n);
            return;
        }
        this.showtitlebar = n;
        this.showtitlebarDirtyFlag = true;
    }

    public Integer getShowTitleBar() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getShowTitleBar();
        }
        return this.showtitlebar;
    }

    public boolean isShowTitleBarDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isShowTitleBarDirty();
        }
        return this.showtitlebarDirtyFlag;
    }

    public void resetShowTitleBar() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetShowTitleBar();
            return;
        }
        this.showtitlebarDirtyFlag = false;
        this.showtitlebar = null;
    }

    public void setSwapMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSwapMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.swapmode = string;
        this.swapmodeDirtyFlag = true;
    }

    public String getSwapMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSwapMode();
        }
        return this.swapmode;
    }

    public boolean isSwapModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSwapModeDirty();
        }
        return this.swapmodeDirtyFlag;
    }

    public void resetSwapMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSwapMode();
            return;
        }
        this.swapmodeDirtyFlag = false;
        this.swapmode = null;
    }

    public void setTemplateMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplateMode(n);
            return;
        }
        this.templatemode = n;
        this.templatemodeDirtyFlag = true;
    }

    public Integer getTemplateMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplateMode();
        }
        return this.templatemode;
    }

    public boolean isTemplateModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplateModeDirty();
        }
        return this.templatemodeDirtyFlag;
    }

    public void resetTemplateMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplateMode();
            return;
        }
        this.templatemodeDirtyFlag = false;
        this.templatemode = null;
    }

    public void setTitle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTitle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.title = string;
        this.titleDirtyFlag = true;
    }

    public String getTitle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitle();
        }
        return this.title;
    }

    public boolean isTitleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTitleDirty();
        }
        return this.titleDirtyFlag;
    }

    public void resetTitle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTitle();
            return;
        }
        this.titleDirtyFlag = false;
        this.title = null;
    }

    public void setTitleBarCloseMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTitleBarCloseMode(n);
            return;
        }
        this.titlebarclosemode = n;
        this.titlebarclosemodeDirtyFlag = true;
    }

    public Integer getTitleBarCloseMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitleBarCloseMode();
        }
        return this.titlebarclosemode;
    }

    public boolean isTitleBarCloseModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTitleBarCloseModeDirty();
        }
        return this.titlebarclosemodeDirtyFlag;
    }

    public void resetTitleBarCloseMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTitleBarCloseMode();
            return;
        }
        this.titlebarclosemodeDirtyFlag = false;
        this.titlebarclosemode = null;
    }

    public void setTitlePSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTitlePSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.titlepslanresid = string;
        this.titlepslanresidDirtyFlag = true;
    }

    public String getTitlePSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitlePSLanResId();
        }
        return this.titlepslanresid;
    }

    public boolean isTitlePSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTitlePSLanResIdDirty();
        }
        return this.titlepslanresidDirtyFlag;
    }

    public void resetTitlePSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTitlePSLanResId();
            return;
        }
        this.titlepslanresidDirtyFlag = false;
        this.titlepslanresid = null;
    }

    public void setTitlePSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTitlePSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.titlepslanresname = string;
        this.titlepslanresnameDirtyFlag = true;
    }

    public String getTitlePSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitlePSLanResName();
        }
        return this.titlepslanresname;
    }

    public boolean isTitlePSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTitlePSLanResNameDirty();
        }
        return this.titlepslanresnameDirtyFlag;
    }

    public void resetTitlePSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTitlePSLanResName();
            return;
        }
        this.titlepslanresnameDirtyFlag = false;
        this.titlepslanresname = null;
    }

    public void setTooltipInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTooltipInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tooltipinfo = string;
        this.tooltipinfoDirtyFlag = true;
    }

    public String getTooltipInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTooltipInfo();
        }
        return this.tooltipinfo;
    }

    public boolean isTooltipInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTooltipInfoDirty();
        }
        return this.tooltipinfoDirtyFlag;
    }

    public void resetTooltipInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTooltipInfo();
            return;
        }
        this.tooltipinfoDirtyFlag = false;
        this.tooltipinfo = null;
    }

    public void setUpdateDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDate(timestamp);
            return;
        }
        this.updatedate = timestamp;
        this.updatedateDirtyFlag = true;
    }

    public Timestamp getUpdateDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateDate();
        }
        return this.updatedate;
    }

    public boolean isUpdateDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateDateDirty();
        }
        return this.updatedateDirtyFlag;
    }

    public void resetUpdateDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateDate();
            return;
        }
        this.updatedateDirtyFlag = false;
        this.updatedate = null;
    }

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

    public String getUpdateMan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateMan();
        }
        return this.updateman;
    }

    public boolean isUpdateManDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateManDirty();
        }
        return this.updatemanDirtyFlag;
    }

    public void resetUpdateMan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateMan();
            return;
        }
        this.updatemanDirtyFlag = false;
        this.updateman = null;
    }

    public void setUserTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag = string;
        this.usertagDirtyFlag = true;
    }

    public String getUserTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag();
        }
        return this.usertag;
    }

    public boolean isUserTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTagDirty();
        }
        return this.usertagDirtyFlag;
    }

    public void resetUserTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag();
            return;
        }
        this.usertagDirtyFlag = false;
        this.usertag = null;
    }

    public void setUserTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag2 = string;
        this.usertag2DirtyFlag = true;
    }

    public String getUserTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag2();
        }
        return this.usertag2;
    }

    public boolean isUserTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag2Dirty();
        }
        return this.usertag2DirtyFlag;
    }

    public void resetUserTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag2();
            return;
        }
        this.usertag2DirtyFlag = false;
        this.usertag2 = null;
    }

    public void setValidFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValidFlag(n);
            return;
        }
        this.validflag = n;
        this.validflagDirtyFlag = true;
    }

    public Integer getValidFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValidFlag();
        }
        return this.validflag;
    }

    public boolean isValidFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValidFlagDirty();
        }
        return this.validflagDirtyFlag;
    }

    public void resetValidFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValidFlag();
            return;
        }
        this.validflagDirtyFlag = false;
        this.validflag = null;
    }

    public void setVAlignSelf(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVAlignSelf(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.valignself = string;
        this.valignselfDirtyFlag = true;
    }

    public String getVAlignSelf() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVAlignSelf();
        }
        return this.valignself;
    }

    public boolean isVAlignSelfDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVAlignSelfDirty();
        }
        return this.valignselfDirtyFlag;
    }

    public void resetVAlignSelf() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVAlignSelf();
            return;
        }
        this.valignselfDirtyFlag = false;
        this.valignself = null;
    }

    public void setWidth(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWidth(n);
            return;
        }
        this.width = n;
        this.widthDirtyFlag = true;
    }

    public Integer getWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWidth();
        }
        return this.width;
    }

    public boolean isWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWidthDirty();
        }
        return this.widthDirtyFlag;
    }

    public void resetWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWidth();
            return;
        }
        this.widthDirtyFlag = false;
        this.width = null;
    }

    protected void onReset() {
        PSAppPVPartBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppPVPartBase pSAppPVPartBase) {
        pSAppPVPartBase.resetAMPSSysPFPluginId();
        pSAppPVPartBase.resetAMPSSysPFPluginName();
        pSAppPVPartBase.resetBL_Pos();
        pSAppPVPartBase.resetColId();
        pSAppPVPartBase.resetColSpan();
        pSAppPVPartBase.resetCol_LG();
        pSAppPVPartBase.resetCol_LG_OS();
        pSAppPVPartBase.resetCol_MD();
        pSAppPVPartBase.resetCol_MD_OS();
        pSAppPVPartBase.resetCol_SM();
        pSAppPVPartBase.resetCol_SM_OS();
        pSAppPVPartBase.resetCol_XS();
        pSAppPVPartBase.resetCol_XS_OS();
        pSAppPVPartBase.resetContentType();
        pSAppPVPartBase.resetCreateDate();
        pSAppPVPartBase.resetCreateMan();
        pSAppPVPartBase.resetDynaClass();
        pSAppPVPartBase.resetEnableAnchor();
        pSAppPVPartBase.resetEnableCustomMenu();
        pSAppPVPartBase.resetFlexAlign();
        pSAppPVPartBase.resetFlexBasis();
        pSAppPVPartBase.resetFlexDir();
        pSAppPVPartBase.resetFlexGrow();
        pSAppPVPartBase.resetFlexShrink();
        pSAppPVPartBase.resetFlexVAlign();
        pSAppPVPartBase.resetHAlignSelf();
        pSAppPVPartBase.resetHeight();
        pSAppPVPartBase.resetHtmlContent();
        pSAppPVPartBase.resetLayoutMode();
        pSAppPVPartBase.resetMemo();
        pSAppPVPartBase.resetMenuPSAppUtilViewId();
        pSAppPVPartBase.resetMenuPSAppUtilViewName();
        pSAppPVPartBase.resetMOBAMStyle();
        pSAppPVPartBase.resetNewRowMode();
        pSAppPVPartBase.resetOrderValue();
        pSAppPVPartBase.resetPartParams();
        pSAppPVPartBase.resetPartStyle();
        pSAppPVPartBase.resetPortletType();
        pSAppPVPartBase.resetPosInfo();
        pSAppPVPartBase.resetPPSAppPVPartId();
        pSAppPVPartBase.resetPPSAppPVPartName();
        pSAppPVPartBase.resetPSAppMenuId();
        pSAppPVPartBase.resetPSAppMenuName();
        pSAppPVPartBase.resetPSAppPortalViewId();
        pSAppPVPartBase.resetPSAppPortalViewName();
        pSAppPVPartBase.resetPSAppPVPartId();
        pSAppPVPartBase.resetPSAppPVPartName();
        pSAppPVPartBase.resetPSAppViewId();
        pSAppPVPartBase.resetPSAppViewName();
        pSAppPVPartBase.resetPSSysCssId();
        pSAppPVPartBase.resetPSSysCssName();
        pSAppPVPartBase.resetPSSysImageId();
        pSAppPVPartBase.resetPSSysImageName();
        pSAppPVPartBase.resetPSSysPFPluginId();
        pSAppPVPartBase.resetPSSysPFPluginName();
        pSAppPVPartBase.resetPSSysPortletId();
        pSAppPVPartBase.resetPSSysPortletName();
        pSAppPVPartBase.resetPSSysResourceId();
        pSAppPVPartBase.resetPSSysResourceName();
        pSAppPVPartBase.resetPSSystemId();
        pSAppPVPartBase.resetPSSysUniResId();
        pSAppPVPartBase.resetPSSysUniResName();
        pSAppPVPartBase.resetPVPartType();
        pSAppPVPartBase.resetRawContent();
        pSAppPVPartBase.resetRawCssStyle();
        pSAppPVPartBase.resetShowTitleBar();
        pSAppPVPartBase.resetSwapMode();
        pSAppPVPartBase.resetTemplateMode();
        pSAppPVPartBase.resetTitle();
        pSAppPVPartBase.resetTitleBarCloseMode();
        pSAppPVPartBase.resetTitlePSLanResId();
        pSAppPVPartBase.resetTitlePSLanResName();
        pSAppPVPartBase.resetTooltipInfo();
        pSAppPVPartBase.resetUpdateDate();
        pSAppPVPartBase.resetUpdateMan();
        pSAppPVPartBase.resetUserTag();
        pSAppPVPartBase.resetUserTag2();
        pSAppPVPartBase.resetValidFlag();
        pSAppPVPartBase.resetVAlignSelf();
        pSAppPVPartBase.resetWidth();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAMPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_AMPSSYSPFPLUGINID, this.getAMPSSysPFPluginId());
        }
        if (!bl || this.isAMPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_AMPSSYSPFPLUGINNAME, this.getAMPSSysPFPluginName());
        }
        if (!bl || this.isBL_PosDirty()) {
            hashMap.put(FIELD_BL_POS, this.getBL_Pos());
        }
        if (!bl || this.isColIdDirty()) {
            hashMap.put(FIELD_COLID, this.getColId());
        }
        if (!bl || this.isColSpanDirty()) {
            hashMap.put(FIELD_COLSPAN, this.getColSpan());
        }
        if (!bl || this.isCol_LGDirty()) {
            hashMap.put(FIELD_COL_LG, this.getCol_LG());
        }
        if (!bl || this.isCol_LG_OSDirty()) {
            hashMap.put(FIELD_COL_LG_OS, this.getCol_LG_OS());
        }
        if (!bl || this.isCol_MDDirty()) {
            hashMap.put(FIELD_COL_MD, this.getCol_MD());
        }
        if (!bl || this.isCol_MD_OSDirty()) {
            hashMap.put(FIELD_COL_MD_OS, this.getCol_MD_OS());
        }
        if (!bl || this.isCol_SMDirty()) {
            hashMap.put(FIELD_COL_SM, this.getCol_SM());
        }
        if (!bl || this.isCol_SM_OSDirty()) {
            hashMap.put(FIELD_COL_SM_OS, this.getCol_SM_OS());
        }
        if (!bl || this.isCol_XSDirty()) {
            hashMap.put(FIELD_COL_XS, this.getCol_XS());
        }
        if (!bl || this.isCol_XS_OSDirty()) {
            hashMap.put(FIELD_COL_XS_OS, this.getCol_XS_OS());
        }
        if (!bl || this.isContentTypeDirty()) {
            hashMap.put(FIELD_CONTENTTYPE, this.getContentType());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDynaClassDirty()) {
            hashMap.put(FIELD_DYNACLASS, this.getDynaClass());
        }
        if (!bl || this.isEnableAnchorDirty()) {
            hashMap.put(FIELD_ENABLEANCHOR, this.getEnableAnchor());
        }
        if (!bl || this.isEnableCustomMenuDirty()) {
            hashMap.put(FIELD_ENABLECUSTOMMENU, this.getEnableCustomMenu());
        }
        if (!bl || this.isFlexAlignDirty()) {
            hashMap.put(FIELD_FLEXALIGN, this.getFlexAlign());
        }
        if (!bl || this.isFlexBasisDirty()) {
            hashMap.put(FIELD_FLEXBASIS, this.getFlexBasis());
        }
        if (!bl || this.isFlexDirDirty()) {
            hashMap.put(FIELD_FLEXDIR, this.getFlexDir());
        }
        if (!bl || this.isFlexGrowDirty()) {
            hashMap.put(FIELD_FLEXGROW, this.getFlexGrow());
        }
        if (!bl || this.isFlexShrinkDirty()) {
            hashMap.put(FIELD_FLEXSHRINK, this.getFlexShrink());
        }
        if (!bl || this.isFlexVAlignDirty()) {
            hashMap.put(FIELD_FLEXVALIGN, this.getFlexVAlign());
        }
        if (!bl || this.isHAlignSelfDirty()) {
            hashMap.put(FIELD_HALIGNSELF, this.getHAlignSelf());
        }
        if (!bl || this.isHeightDirty()) {
            hashMap.put(FIELD_HEIGHT, this.getHeight());
        }
        if (!bl || this.isHtmlContentDirty()) {
            hashMap.put(FIELD_HTMLCONTENT, this.getHtmlContent());
        }
        if (!bl || this.isLayoutModeDirty()) {
            hashMap.put(FIELD_LAYOUTMODE, this.getLayoutMode());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMenuPSAppUtilViewIdDirty()) {
            hashMap.put(FIELD_MENUPSAPPUTILVIEWID, this.getMenuPSAppUtilViewId());
        }
        if (!bl || this.isMenuPSAppUtilViewNameDirty()) {
            hashMap.put(FIELD_MENUPSAPPUTILVIEWNAME, this.getMenuPSAppUtilViewName());
        }
        if (!bl || this.isMOBAMStyleDirty()) {
            hashMap.put(FIELD_MOBAMSTYLE, this.getMOBAMStyle());
        }
        if (!bl || this.isNewRowModeDirty()) {
            hashMap.put(FIELD_NEWROWMODE, this.getNewRowMode());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPartParamsDirty()) {
            hashMap.put(FIELD_PARTPARAMS, this.getPartParams());
        }
        if (!bl || this.isPartStyleDirty()) {
            hashMap.put(FIELD_PARTSTYLE, this.getPartStyle());
        }
        if (!bl || this.isPortletTypeDirty()) {
            hashMap.put(FIELD_PORTLETTYPE, this.getPortletType());
        }
        if (!bl || this.isPosInfoDirty()) {
            hashMap.put(FIELD_POSINFO, this.getPosInfo());
        }
        if (!bl || this.isPPSAppPVPartIdDirty()) {
            hashMap.put(FIELD_PPSAPPPVPARTID, this.getPPSAppPVPartId());
        }
        if (!bl || this.isPPSAppPVPartNameDirty()) {
            hashMap.put(FIELD_PPSAPPPVPARTNAME, this.getPPSAppPVPartName());
        }
        if (!bl || this.isPSAppMenuIdDirty()) {
            hashMap.put(FIELD_PSAPPMENUID, this.getPSAppMenuId());
        }
        if (!bl || this.isPSAppMenuNameDirty()) {
            hashMap.put(FIELD_PSAPPMENUNAME, this.getPSAppMenuName());
        }
        if (!bl || this.isPSAppPortalViewIdDirty()) {
            hashMap.put(FIELD_PSAPPPORTALVIEWID, this.getPSAppPortalViewId());
        }
        if (!bl || this.isPSAppPortalViewNameDirty()) {
            hashMap.put(FIELD_PSAPPPORTALVIEWNAME, this.getPSAppPortalViewName());
        }
        if (!bl || this.isPSAppPVPartIdDirty()) {
            hashMap.put(FIELD_PSAPPPVPARTID, this.getPSAppPVPartId());
        }
        if (!bl || this.isPSAppPVPartNameDirty()) {
            hashMap.put(FIELD_PSAPPPVPARTNAME, this.getPSAppPVPartName());
        }
        if (!bl || this.isPSAppViewIdDirty()) {
            hashMap.put(FIELD_PSAPPVIEWID, this.getPSAppViewId());
        }
        if (!bl || this.isPSAppViewNameDirty()) {
            hashMap.put(FIELD_PSAPPVIEWNAME, this.getPSAppViewName());
        }
        if (!bl || this.isPSSysCssIdDirty()) {
            hashMap.put(FIELD_PSSYSCSSID, this.getPSSysCssId());
        }
        if (!bl || this.isPSSysCssNameDirty()) {
            hashMap.put(FIELD_PSSYSCSSNAME, this.getPSSysCssName());
        }
        if (!bl || this.isPSSysImageIdDirty()) {
            hashMap.put(FIELD_PSSYSIMAGEID, this.getPSSysImageId());
        }
        if (!bl || this.isPSSysImageNameDirty()) {
            hashMap.put(FIELD_PSSYSIMAGENAME, this.getPSSysImageName());
        }
        if (!bl || this.isPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINID, this.getPSSysPFPluginId());
        }
        if (!bl || this.isPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINNAME, this.getPSSysPFPluginName());
        }
        if (!bl || this.isPSSysPortletIdDirty()) {
            hashMap.put(FIELD_PSSYSPORTLETID, this.getPSSysPortletId());
        }
        if (!bl || this.isPSSysPortletNameDirty()) {
            hashMap.put(FIELD_PSSYSPORTLETNAME, this.getPSSysPortletName());
        }
        if (!bl || this.isPSSysResourceIdDirty()) {
            hashMap.put(FIELD_PSSYSRESOURCEID, this.getPSSysResourceId());
        }
        if (!bl || this.isPSSysResourceNameDirty()) {
            hashMap.put(FIELD_PSSYSRESOURCENAME, this.getPSSysResourceName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSysUniResIdDirty()) {
            hashMap.put(FIELD_PSSYSUNIRESID, this.getPSSysUniResId());
        }
        if (!bl || this.isPSSysUniResNameDirty()) {
            hashMap.put(FIELD_PSSYSUNIRESNAME, this.getPSSysUniResName());
        }
        if (!bl || this.isPVPartTypeDirty()) {
            hashMap.put(FIELD_PVPARTTYPE, this.getPVPartType());
        }
        if (!bl || this.isRawContentDirty()) {
            hashMap.put(FIELD_RAWCONTENT, this.getRawContent());
        }
        if (!bl || this.isRawCssStyleDirty()) {
            hashMap.put(FIELD_RAWCSSSTYLE, this.getRawCssStyle());
        }
        if (!bl || this.isShowTitleBarDirty()) {
            hashMap.put(FIELD_SHOWTITLEBAR, this.getShowTitleBar());
        }
        if (!bl || this.isSwapModeDirty()) {
            hashMap.put(FIELD_SWAPMODE, this.getSwapMode());
        }
        if (!bl || this.isTemplateModeDirty()) {
            hashMap.put(FIELD_TEMPLATEMODE, this.getTemplateMode());
        }
        if (!bl || this.isTitleDirty()) {
            hashMap.put(FIELD_TITLE, this.getTitle());
        }
        if (!bl || this.isTitleBarCloseModeDirty()) {
            hashMap.put(FIELD_TITLEBARCLOSEMODE, this.getTitleBarCloseMode());
        }
        if (!bl || this.isTitlePSLanResIdDirty()) {
            hashMap.put(FIELD_TITLEPSLANRESID, this.getTitlePSLanResId());
        }
        if (!bl || this.isTitlePSLanResNameDirty()) {
            hashMap.put(FIELD_TITLEPSLANRESNAME, this.getTitlePSLanResName());
        }
        if (!bl || this.isTooltipInfoDirty()) {
            hashMap.put(FIELD_TOOLTIPINFO, this.getTooltipInfo());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
        }
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
        }
        if (!bl || this.isVAlignSelfDirty()) {
            hashMap.put(FIELD_VALIGNSELF, this.getVAlignSelf());
        }
        if (!bl || this.isWidthDirty()) {
            hashMap.put(FIELD_WIDTH, this.getWidth());
        }
        super.onFillMap(hashMap, bl);
    }

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
        return PSAppPVPartBase.get(this, n);
    }

    private static Object get(PSAppPVPartBase pSAppPVPartBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppPVPartBase.getAMPSSysPFPluginId();
            }
            case 1: {
                return pSAppPVPartBase.getAMPSSysPFPluginName();
            }
            case 2: {
                return pSAppPVPartBase.getBL_Pos();
            }
            case 3: {
                return pSAppPVPartBase.getColId();
            }
            case 4: {
                return pSAppPVPartBase.getColSpan();
            }
            case 5: {
                return pSAppPVPartBase.getCol_LG();
            }
            case 6: {
                return pSAppPVPartBase.getCol_LG_OS();
            }
            case 7: {
                return pSAppPVPartBase.getCol_MD();
            }
            case 8: {
                return pSAppPVPartBase.getCol_MD_OS();
            }
            case 9: {
                return pSAppPVPartBase.getCol_SM();
            }
            case 10: {
                return pSAppPVPartBase.getCol_SM_OS();
            }
            case 11: {
                return pSAppPVPartBase.getCol_XS();
            }
            case 12: {
                return pSAppPVPartBase.getCol_XS_OS();
            }
            case 13: {
                return pSAppPVPartBase.getContentType();
            }
            case 14: {
                return pSAppPVPartBase.getCreateDate();
            }
            case 15: {
                return pSAppPVPartBase.getCreateMan();
            }
            case 16: {
                return pSAppPVPartBase.getDynaClass();
            }
            case 17: {
                return pSAppPVPartBase.getEnableAnchor();
            }
            case 18: {
                return pSAppPVPartBase.getEnableCustomMenu();
            }
            case 19: {
                return pSAppPVPartBase.getFlexAlign();
            }
            case 20: {
                return pSAppPVPartBase.getFlexBasis();
            }
            case 21: {
                return pSAppPVPartBase.getFlexDir();
            }
            case 22: {
                return pSAppPVPartBase.getFlexGrow();
            }
            case 23: {
                return pSAppPVPartBase.getFlexShrink();
            }
            case 24: {
                return pSAppPVPartBase.getFlexVAlign();
            }
            case 25: {
                return pSAppPVPartBase.getHAlignSelf();
            }
            case 26: {
                return pSAppPVPartBase.getHeight();
            }
            case 27: {
                return pSAppPVPartBase.getHtmlContent();
            }
            case 28: {
                return pSAppPVPartBase.getLayoutMode();
            }
            case 29: {
                return pSAppPVPartBase.getMemo();
            }
            case 30: {
                return pSAppPVPartBase.getMenuPSAppUtilViewId();
            }
            case 31: {
                return pSAppPVPartBase.getMenuPSAppUtilViewName();
            }
            case 32: {
                return pSAppPVPartBase.getMOBAMStyle();
            }
            case 33: {
                return pSAppPVPartBase.getNewRowMode();
            }
            case 34: {
                return pSAppPVPartBase.getOrderValue();
            }
            case 35: {
                return pSAppPVPartBase.getPartParams();
            }
            case 36: {
                return pSAppPVPartBase.getPartStyle();
            }
            case 37: {
                return pSAppPVPartBase.getPortletType();
            }
            case 38: {
                return pSAppPVPartBase.getPosInfo();
            }
            case 39: {
                return pSAppPVPartBase.getPPSAppPVPartId();
            }
            case 40: {
                return pSAppPVPartBase.getPPSAppPVPartName();
            }
            case 41: {
                return pSAppPVPartBase.getPSAppMenuId();
            }
            case 42: {
                return pSAppPVPartBase.getPSAppMenuName();
            }
            case 43: {
                return pSAppPVPartBase.getPSAppPortalViewId();
            }
            case 44: {
                return pSAppPVPartBase.getPSAppPortalViewName();
            }
            case 45: {
                return pSAppPVPartBase.getPSAppPVPartId();
            }
            case 46: {
                return pSAppPVPartBase.getPSAppPVPartName();
            }
            case 47: {
                return pSAppPVPartBase.getPSAppViewId();
            }
            case 48: {
                return pSAppPVPartBase.getPSAppViewName();
            }
            case 49: {
                return pSAppPVPartBase.getPSSysCssId();
            }
            case 50: {
                return pSAppPVPartBase.getPSSysCssName();
            }
            case 51: {
                return pSAppPVPartBase.getPSSysImageId();
            }
            case 52: {
                return pSAppPVPartBase.getPSSysImageName();
            }
            case 53: {
                return pSAppPVPartBase.getPSSysPFPluginId();
            }
            case 54: {
                return pSAppPVPartBase.getPSSysPFPluginName();
            }
            case 55: {
                return pSAppPVPartBase.getPSSysPortletId();
            }
            case 56: {
                return pSAppPVPartBase.getPSSysPortletName();
            }
            case 57: {
                return pSAppPVPartBase.getPSSysResourceId();
            }
            case 58: {
                return pSAppPVPartBase.getPSSysResourceName();
            }
            case 59: {
                return pSAppPVPartBase.getPSSystemId();
            }
            case 60: {
                return pSAppPVPartBase.getPSSysUniResId();
            }
            case 61: {
                return pSAppPVPartBase.getPSSysUniResName();
            }
            case 62: {
                return pSAppPVPartBase.getPVPartType();
            }
            case 63: {
                return pSAppPVPartBase.getRawContent();
            }
            case 64: {
                return pSAppPVPartBase.getRawCssStyle();
            }
            case 65: {
                return pSAppPVPartBase.getShowTitleBar();
            }
            case 66: {
                return pSAppPVPartBase.getSwapMode();
            }
            case 67: {
                return pSAppPVPartBase.getTemplateMode();
            }
            case 68: {
                return pSAppPVPartBase.getTitle();
            }
            case 69: {
                return pSAppPVPartBase.getTitleBarCloseMode();
            }
            case 70: {
                return pSAppPVPartBase.getTitlePSLanResId();
            }
            case 71: {
                return pSAppPVPartBase.getTitlePSLanResName();
            }
            case 72: {
                return pSAppPVPartBase.getTooltipInfo();
            }
            case 73: {
                return pSAppPVPartBase.getUpdateDate();
            }
            case 74: {
                return pSAppPVPartBase.getUpdateMan();
            }
            case 75: {
                return pSAppPVPartBase.getUserTag();
            }
            case 76: {
                return pSAppPVPartBase.getUserTag2();
            }
            case 77: {
                return pSAppPVPartBase.getValidFlag();
            }
            case 78: {
                return pSAppPVPartBase.getVAlignSelf();
            }
            case 79: {
                return pSAppPVPartBase.getWidth();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

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
        PSAppPVPartBase.set(this, n, object);
    }

    private static void set(PSAppPVPartBase pSAppPVPartBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSAppPVPartBase.setAMPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSAppPVPartBase.setAMPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSAppPVPartBase.setBL_Pos(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSAppPVPartBase.setColId(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSAppPVPartBase.setColSpan(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSAppPVPartBase.setCol_LG(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSAppPVPartBase.setCol_LG_OS(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSAppPVPartBase.setCol_MD(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSAppPVPartBase.setCol_MD_OS(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSAppPVPartBase.setCol_SM(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSAppPVPartBase.setCol_SM_OS(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSAppPVPartBase.setCol_XS(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSAppPVPartBase.setCol_XS_OS(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSAppPVPartBase.setContentType(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSAppPVPartBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSAppPVPartBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSAppPVPartBase.setDynaClass(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSAppPVPartBase.setEnableAnchor(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSAppPVPartBase.setEnableCustomMenu(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSAppPVPartBase.setFlexAlign(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSAppPVPartBase.setFlexBasis(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSAppPVPartBase.setFlexDir(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSAppPVPartBase.setFlexGrow(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSAppPVPartBase.setFlexShrink(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSAppPVPartBase.setFlexVAlign(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSAppPVPartBase.setHAlignSelf(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSAppPVPartBase.setHeight(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSAppPVPartBase.setHtmlContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSAppPVPartBase.setLayoutMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSAppPVPartBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSAppPVPartBase.setMenuPSAppUtilViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSAppPVPartBase.setMenuPSAppUtilViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSAppPVPartBase.setMOBAMStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSAppPVPartBase.setNewRowMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 34: {
                pSAppPVPartBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 35: {
                pSAppPVPartBase.setPartParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSAppPVPartBase.setPartStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSAppPVPartBase.setPortletType(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSAppPVPartBase.setPosInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSAppPVPartBase.setPPSAppPVPartId(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSAppPVPartBase.setPPSAppPVPartName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSAppPVPartBase.setPSAppMenuId(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSAppPVPartBase.setPSAppMenuName(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSAppPVPartBase.setPSAppPortalViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSAppPVPartBase.setPSAppPortalViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSAppPVPartBase.setPSAppPVPartId(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSAppPVPartBase.setPSAppPVPartName(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSAppPVPartBase.setPSAppViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSAppPVPartBase.setPSAppViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSAppPVPartBase.setPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSAppPVPartBase.setPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSAppPVPartBase.setPSSysImageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSAppPVPartBase.setPSSysImageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSAppPVPartBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSAppPVPartBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSAppPVPartBase.setPSSysPortletId(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSAppPVPartBase.setPSSysPortletName(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSAppPVPartBase.setPSSysResourceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSAppPVPartBase.setPSSysResourceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSAppPVPartBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSAppPVPartBase.setPSSysUniResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSAppPVPartBase.setPSSysUniResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSAppPVPartBase.setPVPartType(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSAppPVPartBase.setRawContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSAppPVPartBase.setRawCssStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSAppPVPartBase.setShowTitleBar(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 66: {
                pSAppPVPartBase.setSwapMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSAppPVPartBase.setTemplateMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 68: {
                pSAppPVPartBase.setTitle(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSAppPVPartBase.setTitleBarCloseMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 70: {
                pSAppPVPartBase.setTitlePSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 71: {
                pSAppPVPartBase.setTitlePSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 72: {
                pSAppPVPartBase.setTooltipInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 73: {
                pSAppPVPartBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 74: {
                pSAppPVPartBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 75: {
                pSAppPVPartBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 76: {
                pSAppPVPartBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 77: {
                pSAppPVPartBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 78: {
                pSAppPVPartBase.setVAlignSelf(DataObject.getStringValue((Object)object));
                return;
            }
            case 79: {
                pSAppPVPartBase.setWidth(DataObject.getIntegerValue((Object)object));
                return;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

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
        return PSAppPVPartBase.isNull(this, n);
    }

    private static boolean isNull(PSAppPVPartBase pSAppPVPartBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppPVPartBase.getAMPSSysPFPluginId() == null;
            }
            case 1: {
                return pSAppPVPartBase.getAMPSSysPFPluginName() == null;
            }
            case 2: {
                return pSAppPVPartBase.getBL_Pos() == null;
            }
            case 3: {
                return pSAppPVPartBase.getColId() == null;
            }
            case 4: {
                return pSAppPVPartBase.getColSpan() == null;
            }
            case 5: {
                return pSAppPVPartBase.getCol_LG() == null;
            }
            case 6: {
                return pSAppPVPartBase.getCol_LG_OS() == null;
            }
            case 7: {
                return pSAppPVPartBase.getCol_MD() == null;
            }
            case 8: {
                return pSAppPVPartBase.getCol_MD_OS() == null;
            }
            case 9: {
                return pSAppPVPartBase.getCol_SM() == null;
            }
            case 10: {
                return pSAppPVPartBase.getCol_SM_OS() == null;
            }
            case 11: {
                return pSAppPVPartBase.getCol_XS() == null;
            }
            case 12: {
                return pSAppPVPartBase.getCol_XS_OS() == null;
            }
            case 13: {
                return pSAppPVPartBase.getContentType() == null;
            }
            case 14: {
                return pSAppPVPartBase.getCreateDate() == null;
            }
            case 15: {
                return pSAppPVPartBase.getCreateMan() == null;
            }
            case 16: {
                return pSAppPVPartBase.getDynaClass() == null;
            }
            case 17: {
                return pSAppPVPartBase.getEnableAnchor() == null;
            }
            case 18: {
                return pSAppPVPartBase.getEnableCustomMenu() == null;
            }
            case 19: {
                return pSAppPVPartBase.getFlexAlign() == null;
            }
            case 20: {
                return pSAppPVPartBase.getFlexBasis() == null;
            }
            case 21: {
                return pSAppPVPartBase.getFlexDir() == null;
            }
            case 22: {
                return pSAppPVPartBase.getFlexGrow() == null;
            }
            case 23: {
                return pSAppPVPartBase.getFlexShrink() == null;
            }
            case 24: {
                return pSAppPVPartBase.getFlexVAlign() == null;
            }
            case 25: {
                return pSAppPVPartBase.getHAlignSelf() == null;
            }
            case 26: {
                return pSAppPVPartBase.getHeight() == null;
            }
            case 27: {
                return pSAppPVPartBase.getHtmlContent() == null;
            }
            case 28: {
                return pSAppPVPartBase.getLayoutMode() == null;
            }
            case 29: {
                return pSAppPVPartBase.getMemo() == null;
            }
            case 30: {
                return pSAppPVPartBase.getMenuPSAppUtilViewId() == null;
            }
            case 31: {
                return pSAppPVPartBase.getMenuPSAppUtilViewName() == null;
            }
            case 32: {
                return pSAppPVPartBase.getMOBAMStyle() == null;
            }
            case 33: {
                return pSAppPVPartBase.getNewRowMode() == null;
            }
            case 34: {
                return pSAppPVPartBase.getOrderValue() == null;
            }
            case 35: {
                return pSAppPVPartBase.getPartParams() == null;
            }
            case 36: {
                return pSAppPVPartBase.getPartStyle() == null;
            }
            case 37: {
                return pSAppPVPartBase.getPortletType() == null;
            }
            case 38: {
                return pSAppPVPartBase.getPosInfo() == null;
            }
            case 39: {
                return pSAppPVPartBase.getPPSAppPVPartId() == null;
            }
            case 40: {
                return pSAppPVPartBase.getPPSAppPVPartName() == null;
            }
            case 41: {
                return pSAppPVPartBase.getPSAppMenuId() == null;
            }
            case 42: {
                return pSAppPVPartBase.getPSAppMenuName() == null;
            }
            case 43: {
                return pSAppPVPartBase.getPSAppPortalViewId() == null;
            }
            case 44: {
                return pSAppPVPartBase.getPSAppPortalViewName() == null;
            }
            case 45: {
                return pSAppPVPartBase.getPSAppPVPartId() == null;
            }
            case 46: {
                return pSAppPVPartBase.getPSAppPVPartName() == null;
            }
            case 47: {
                return pSAppPVPartBase.getPSAppViewId() == null;
            }
            case 48: {
                return pSAppPVPartBase.getPSAppViewName() == null;
            }
            case 49: {
                return pSAppPVPartBase.getPSSysCssId() == null;
            }
            case 50: {
                return pSAppPVPartBase.getPSSysCssName() == null;
            }
            case 51: {
                return pSAppPVPartBase.getPSSysImageId() == null;
            }
            case 52: {
                return pSAppPVPartBase.getPSSysImageName() == null;
            }
            case 53: {
                return pSAppPVPartBase.getPSSysPFPluginId() == null;
            }
            case 54: {
                return pSAppPVPartBase.getPSSysPFPluginName() == null;
            }
            case 55: {
                return pSAppPVPartBase.getPSSysPortletId() == null;
            }
            case 56: {
                return pSAppPVPartBase.getPSSysPortletName() == null;
            }
            case 57: {
                return pSAppPVPartBase.getPSSysResourceId() == null;
            }
            case 58: {
                return pSAppPVPartBase.getPSSysResourceName() == null;
            }
            case 59: {
                return pSAppPVPartBase.getPSSystemId() == null;
            }
            case 60: {
                return pSAppPVPartBase.getPSSysUniResId() == null;
            }
            case 61: {
                return pSAppPVPartBase.getPSSysUniResName() == null;
            }
            case 62: {
                return pSAppPVPartBase.getPVPartType() == null;
            }
            case 63: {
                return pSAppPVPartBase.getRawContent() == null;
            }
            case 64: {
                return pSAppPVPartBase.getRawCssStyle() == null;
            }
            case 65: {
                return pSAppPVPartBase.getShowTitleBar() == null;
            }
            case 66: {
                return pSAppPVPartBase.getSwapMode() == null;
            }
            case 67: {
                return pSAppPVPartBase.getTemplateMode() == null;
            }
            case 68: {
                return pSAppPVPartBase.getTitle() == null;
            }
            case 69: {
                return pSAppPVPartBase.getTitleBarCloseMode() == null;
            }
            case 70: {
                return pSAppPVPartBase.getTitlePSLanResId() == null;
            }
            case 71: {
                return pSAppPVPartBase.getTitlePSLanResName() == null;
            }
            case 72: {
                return pSAppPVPartBase.getTooltipInfo() == null;
            }
            case 73: {
                return pSAppPVPartBase.getUpdateDate() == null;
            }
            case 74: {
                return pSAppPVPartBase.getUpdateMan() == null;
            }
            case 75: {
                return pSAppPVPartBase.getUserTag() == null;
            }
            case 76: {
                return pSAppPVPartBase.getUserTag2() == null;
            }
            case 77: {
                return pSAppPVPartBase.getValidFlag() == null;
            }
            case 78: {
                return pSAppPVPartBase.getVAlignSelf() == null;
            }
            case 79: {
                return pSAppPVPartBase.getWidth() == null;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

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
        return PSAppPVPartBase.contains(this, n);
    }

    private static boolean contains(PSAppPVPartBase pSAppPVPartBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppPVPartBase.isAMPSSysPFPluginIdDirty();
            }
            case 1: {
                return pSAppPVPartBase.isAMPSSysPFPluginNameDirty();
            }
            case 2: {
                return pSAppPVPartBase.isBL_PosDirty();
            }
            case 3: {
                return pSAppPVPartBase.isColIdDirty();
            }
            case 4: {
                return pSAppPVPartBase.isColSpanDirty();
            }
            case 5: {
                return pSAppPVPartBase.isCol_LGDirty();
            }
            case 6: {
                return pSAppPVPartBase.isCol_LG_OSDirty();
            }
            case 7: {
                return pSAppPVPartBase.isCol_MDDirty();
            }
            case 8: {
                return pSAppPVPartBase.isCol_MD_OSDirty();
            }
            case 9: {
                return pSAppPVPartBase.isCol_SMDirty();
            }
            case 10: {
                return pSAppPVPartBase.isCol_SM_OSDirty();
            }
            case 11: {
                return pSAppPVPartBase.isCol_XSDirty();
            }
            case 12: {
                return pSAppPVPartBase.isCol_XS_OSDirty();
            }
            case 13: {
                return pSAppPVPartBase.isContentTypeDirty();
            }
            case 14: {
                return pSAppPVPartBase.isCreateDateDirty();
            }
            case 15: {
                return pSAppPVPartBase.isCreateManDirty();
            }
            case 16: {
                return pSAppPVPartBase.isDynaClassDirty();
            }
            case 17: {
                return pSAppPVPartBase.isEnableAnchorDirty();
            }
            case 18: {
                return pSAppPVPartBase.isEnableCustomMenuDirty();
            }
            case 19: {
                return pSAppPVPartBase.isFlexAlignDirty();
            }
            case 20: {
                return pSAppPVPartBase.isFlexBasisDirty();
            }
            case 21: {
                return pSAppPVPartBase.isFlexDirDirty();
            }
            case 22: {
                return pSAppPVPartBase.isFlexGrowDirty();
            }
            case 23: {
                return pSAppPVPartBase.isFlexShrinkDirty();
            }
            case 24: {
                return pSAppPVPartBase.isFlexVAlignDirty();
            }
            case 25: {
                return pSAppPVPartBase.isHAlignSelfDirty();
            }
            case 26: {
                return pSAppPVPartBase.isHeightDirty();
            }
            case 27: {
                return pSAppPVPartBase.isHtmlContentDirty();
            }
            case 28: {
                return pSAppPVPartBase.isLayoutModeDirty();
            }
            case 29: {
                return pSAppPVPartBase.isMemoDirty();
            }
            case 30: {
                return pSAppPVPartBase.isMenuPSAppUtilViewIdDirty();
            }
            case 31: {
                return pSAppPVPartBase.isMenuPSAppUtilViewNameDirty();
            }
            case 32: {
                return pSAppPVPartBase.isMOBAMStyleDirty();
            }
            case 33: {
                return pSAppPVPartBase.isNewRowModeDirty();
            }
            case 34: {
                return pSAppPVPartBase.isOrderValueDirty();
            }
            case 35: {
                return pSAppPVPartBase.isPartParamsDirty();
            }
            case 36: {
                return pSAppPVPartBase.isPartStyleDirty();
            }
            case 37: {
                return pSAppPVPartBase.isPortletTypeDirty();
            }
            case 38: {
                return pSAppPVPartBase.isPosInfoDirty();
            }
            case 39: {
                return pSAppPVPartBase.isPPSAppPVPartIdDirty();
            }
            case 40: {
                return pSAppPVPartBase.isPPSAppPVPartNameDirty();
            }
            case 41: {
                return pSAppPVPartBase.isPSAppMenuIdDirty();
            }
            case 42: {
                return pSAppPVPartBase.isPSAppMenuNameDirty();
            }
            case 43: {
                return pSAppPVPartBase.isPSAppPortalViewIdDirty();
            }
            case 44: {
                return pSAppPVPartBase.isPSAppPortalViewNameDirty();
            }
            case 45: {
                return pSAppPVPartBase.isPSAppPVPartIdDirty();
            }
            case 46: {
                return pSAppPVPartBase.isPSAppPVPartNameDirty();
            }
            case 47: {
                return pSAppPVPartBase.isPSAppViewIdDirty();
            }
            case 48: {
                return pSAppPVPartBase.isPSAppViewNameDirty();
            }
            case 49: {
                return pSAppPVPartBase.isPSSysCssIdDirty();
            }
            case 50: {
                return pSAppPVPartBase.isPSSysCssNameDirty();
            }
            case 51: {
                return pSAppPVPartBase.isPSSysImageIdDirty();
            }
            case 52: {
                return pSAppPVPartBase.isPSSysImageNameDirty();
            }
            case 53: {
                return pSAppPVPartBase.isPSSysPFPluginIdDirty();
            }
            case 54: {
                return pSAppPVPartBase.isPSSysPFPluginNameDirty();
            }
            case 55: {
                return pSAppPVPartBase.isPSSysPortletIdDirty();
            }
            case 56: {
                return pSAppPVPartBase.isPSSysPortletNameDirty();
            }
            case 57: {
                return pSAppPVPartBase.isPSSysResourceIdDirty();
            }
            case 58: {
                return pSAppPVPartBase.isPSSysResourceNameDirty();
            }
            case 59: {
                return pSAppPVPartBase.isPSSystemIdDirty();
            }
            case 60: {
                return pSAppPVPartBase.isPSSysUniResIdDirty();
            }
            case 61: {
                return pSAppPVPartBase.isPSSysUniResNameDirty();
            }
            case 62: {
                return pSAppPVPartBase.isPVPartTypeDirty();
            }
            case 63: {
                return pSAppPVPartBase.isRawContentDirty();
            }
            case 64: {
                return pSAppPVPartBase.isRawCssStyleDirty();
            }
            case 65: {
                return pSAppPVPartBase.isShowTitleBarDirty();
            }
            case 66: {
                return pSAppPVPartBase.isSwapModeDirty();
            }
            case 67: {
                return pSAppPVPartBase.isTemplateModeDirty();
            }
            case 68: {
                return pSAppPVPartBase.isTitleDirty();
            }
            case 69: {
                return pSAppPVPartBase.isTitleBarCloseModeDirty();
            }
            case 70: {
                return pSAppPVPartBase.isTitlePSLanResIdDirty();
            }
            case 71: {
                return pSAppPVPartBase.isTitlePSLanResNameDirty();
            }
            case 72: {
                return pSAppPVPartBase.isTooltipInfoDirty();
            }
            case 73: {
                return pSAppPVPartBase.isUpdateDateDirty();
            }
            case 74: {
                return pSAppPVPartBase.isUpdateManDirty();
            }
            case 75: {
                return pSAppPVPartBase.isUserTagDirty();
            }
            case 76: {
                return pSAppPVPartBase.isUserTag2Dirty();
            }
            case 77: {
                return pSAppPVPartBase.isValidFlagDirty();
            }
            case 78: {
                return pSAppPVPartBase.isVAlignSelfDirty();
            }
            case 79: {
                return pSAppPVPartBase.isWidthDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppPVPartBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppPVPartBase pSAppPVPartBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppPVPartBase.getAMPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ampssyspfpluginid", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getAMPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getAMPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ampssyspfpluginname", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getAMPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getBL_Pos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bl_pos", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getBL_Pos()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getColId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"colid", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getColId()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getColSpan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"colspan", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getColSpan()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getCol_LG() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"col_lg", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getCol_LG()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getCol_LG_OS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"col_lg_os", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getCol_LG_OS()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getCol_MD() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"col_md", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getCol_MD()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getCol_MD_OS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"col_md_os", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getCol_MD_OS()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getCol_SM() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"col_sm", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getCol_SM()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getCol_SM_OS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"col_sm_os", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getCol_SM_OS()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getCol_XS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"col_xs", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getCol_XS()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getCol_XS_OS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"col_xs_os", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getCol_XS_OS()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getContentType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contenttype", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getContentType()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getDynaClass() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynaclass", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getDynaClass()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getEnableAnchor() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableanchor", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getEnableAnchor()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getEnableCustomMenu() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablecustommenu", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getEnableCustomMenu()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getFlexAlign() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"flexalign", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getFlexAlign()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getFlexBasis() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"flexbasis", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getFlexBasis()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getFlexDir() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"flexdir", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getFlexDir()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getFlexGrow() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"flexgrow", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getFlexGrow()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getFlexShrink() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"flexshrink", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getFlexShrink()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getFlexVAlign() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"flexvalign", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getFlexVAlign()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getHAlignSelf() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"halignself", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getHAlignSelf()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"height", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getHeight()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getHtmlContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"htmlcontent", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getHtmlContent()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getLayoutMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"layoutmode", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getLayoutMode()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getMemo()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getMenuPSAppUtilViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"menupsapputilviewid", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getMenuPSAppUtilViewId()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getMenuPSAppUtilViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"menupsapputilviewname", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getMenuPSAppUtilViewName()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getMOBAMStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobamtyle", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getMOBAMStyle()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getNewRowMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"newrowmode", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getNewRowMode()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getPartParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"partparams", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getPartParams()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getPartStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"partstyle", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getPartStyle()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getPortletType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"portlettype", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getPortletType()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getPosInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"posinfo", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getPosInfo()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getPPSAppPVPartId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsapppvpartid", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getPPSAppPVPartId()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getPPSAppPVPartName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsapppvpartname", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getPPSAppPVPartName()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getPSAppMenuId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmenuid", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getPSAppMenuId()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getPSAppMenuName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmenuname", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getPSAppMenuName()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getPSAppPortalViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappportalviewid", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getPSAppPortalViewId()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getPSAppPortalViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappportalviewname", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getPSAppPortalViewName()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getPSAppPVPartId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapppvpartid", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getPSAppPVPartId()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getPSAppPVPartName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapppvpartname", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getPSAppPVPartName()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getPSAppViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewid", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getPSAppViewId()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getPSAppViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewname", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getPSAppViewName()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssid", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getPSSysCssId()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssname", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getPSSysCssName()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getPSSysImageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimageid", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getPSSysImageId()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getPSSysImageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimagename", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getPSSysImageName()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getPSSysPortletId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysportletid", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getPSSysPortletId()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getPSSysPortletName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysportletname", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getPSSysPortletName()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getPSSysResourceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysresourceid", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getPSSysResourceId()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getPSSysResourceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysresourcename", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getPSSysResourceName()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getPSSysUniResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuniresid", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getPSSysUniResId()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getPSSysUniResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuniresname", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getPSSysUniResName()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getPVPartType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pvparttype", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getPVPartType()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getRawContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rawcontent", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getRawContent()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getRawCssStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rawcssstyle", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getRawCssStyle()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getShowTitleBar() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"showtitlebar", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getShowTitleBar()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getSwapMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"swapmode", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getSwapMode()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getTemplateMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templatemode", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getTemplateMode()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getTitle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"title", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getTitle()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getTitleBarCloseMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"titlebarclosemode", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getTitleBarCloseMode()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getTitlePSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"titlepslanresid", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getTitlePSLanResId()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getTitlePSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"titlepslanresname", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getTitlePSLanResName()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getTooltipInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tooltipinfo", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getTooltipInfo()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getUserTag()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getVAlignSelf() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valignself", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getVAlignSelf()), (boolean)false);
        }
        if (bl || pSAppPVPartBase.getWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"width", (Object)PSAppPVPartBase.getJSONValue((Object)pSAppPVPartBase.getWidth()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppPVPartBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppPVPartBase pSAppPVPartBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppPVPartBase.getAMPSSysPFPluginId() != null) {
            object = pSAppPVPartBase.getAMPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_AMPSSYSPFPLUGINID, (String)(object == null ? "" : object));
        }
        if (bl || pSAppPVPartBase.getAMPSSysPFPluginName() != null) {
            object = pSAppPVPartBase.getAMPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_AMPSSYSPFPLUGINNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSAppPVPartBase.getBL_Pos() != null) {
            object = pSAppPVPartBase.getBL_Pos();
            xmlNode.setAttribute(FIELD_BL_POS, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getColId() != null) {
            object = pSAppPVPartBase.getColId();
            xmlNode.setAttribute(FIELD_COLID, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppPVPartBase.getColSpan() != null) {
            object = pSAppPVPartBase.getColSpan();
            xmlNode.setAttribute(FIELD_COLSPAN, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppPVPartBase.getCol_LG() != null) {
            object = pSAppPVPartBase.getCol_LG();
            xmlNode.setAttribute(FIELD_COL_LG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppPVPartBase.getCol_LG_OS() != null) {
            object = pSAppPVPartBase.getCol_LG_OS();
            xmlNode.setAttribute(FIELD_COL_LG_OS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppPVPartBase.getCol_MD() != null) {
            object = pSAppPVPartBase.getCol_MD();
            xmlNode.setAttribute(FIELD_COL_MD, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppPVPartBase.getCol_MD_OS() != null) {
            object = pSAppPVPartBase.getCol_MD_OS();
            xmlNode.setAttribute(FIELD_COL_MD_OS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppPVPartBase.getCol_SM() != null) {
            object = pSAppPVPartBase.getCol_SM();
            xmlNode.setAttribute(FIELD_COL_SM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppPVPartBase.getCol_SM_OS() != null) {
            object = pSAppPVPartBase.getCol_SM_OS();
            xmlNode.setAttribute(FIELD_COL_SM_OS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppPVPartBase.getCol_XS() != null) {
            object = pSAppPVPartBase.getCol_XS();
            xmlNode.setAttribute(FIELD_COL_XS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppPVPartBase.getCol_XS_OS() != null) {
            object = pSAppPVPartBase.getCol_XS_OS();
            xmlNode.setAttribute(FIELD_COL_XS_OS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppPVPartBase.getContentType() != null) {
            object = pSAppPVPartBase.getContentType();
            xmlNode.setAttribute(FIELD_CONTENTTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getCreateDate() != null) {
            object = pSAppPVPartBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppPVPartBase.getCreateMan() != null) {
            object = pSAppPVPartBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getDynaClass() != null) {
            object = pSAppPVPartBase.getDynaClass();
            xmlNode.setAttribute(FIELD_DYNACLASS, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getEnableAnchor() != null) {
            object = pSAppPVPartBase.getEnableAnchor();
            xmlNode.setAttribute(FIELD_ENABLEANCHOR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppPVPartBase.getEnableCustomMenu() != null) {
            object = pSAppPVPartBase.getEnableCustomMenu();
            xmlNode.setAttribute(FIELD_ENABLECUSTOMMENU, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppPVPartBase.getFlexAlign() != null) {
            object = pSAppPVPartBase.getFlexAlign();
            xmlNode.setAttribute(FIELD_FLEXALIGN, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getFlexBasis() != null) {
            object = pSAppPVPartBase.getFlexBasis();
            xmlNode.setAttribute(FIELD_FLEXBASIS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppPVPartBase.getFlexDir() != null) {
            object = pSAppPVPartBase.getFlexDir();
            xmlNode.setAttribute(FIELD_FLEXDIR, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getFlexGrow() != null) {
            object = pSAppPVPartBase.getFlexGrow();
            xmlNode.setAttribute(FIELD_FLEXGROW, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppPVPartBase.getFlexShrink() != null) {
            object = pSAppPVPartBase.getFlexShrink();
            xmlNode.setAttribute(FIELD_FLEXSHRINK, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppPVPartBase.getFlexVAlign() != null) {
            object = pSAppPVPartBase.getFlexVAlign();
            xmlNode.setAttribute(FIELD_FLEXVALIGN, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getHAlignSelf() != null) {
            object = pSAppPVPartBase.getHAlignSelf();
            xmlNode.setAttribute(FIELD_HALIGNSELF, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getHeight() != null) {
            object = pSAppPVPartBase.getHeight();
            xmlNode.setAttribute(FIELD_HEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppPVPartBase.getHtmlContent() != null) {
            object = pSAppPVPartBase.getHtmlContent();
            xmlNode.setAttribute(FIELD_HTMLCONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getLayoutMode() != null) {
            object = pSAppPVPartBase.getLayoutMode();
            xmlNode.setAttribute(FIELD_LAYOUTMODE, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getMemo() != null) {
            object = pSAppPVPartBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getMenuPSAppUtilViewId() != null) {
            object = pSAppPVPartBase.getMenuPSAppUtilViewId();
            xmlNode.setAttribute(FIELD_MENUPSAPPUTILVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getMenuPSAppUtilViewName() != null) {
            object = pSAppPVPartBase.getMenuPSAppUtilViewName();
            xmlNode.setAttribute(FIELD_MENUPSAPPUTILVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getMOBAMStyle() != null) {
            object = pSAppPVPartBase.getMOBAMStyle();
            xmlNode.setAttribute("MOBAMSTYLE", object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getNewRowMode() != null) {
            object = pSAppPVPartBase.getNewRowMode();
            xmlNode.setAttribute(FIELD_NEWROWMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppPVPartBase.getOrderValue() != null) {
            object = pSAppPVPartBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppPVPartBase.getPartParams() != null) {
            object = pSAppPVPartBase.getPartParams();
            xmlNode.setAttribute(FIELD_PARTPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getPartStyle() != null) {
            object = pSAppPVPartBase.getPartStyle();
            xmlNode.setAttribute(FIELD_PARTSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getPortletType() != null) {
            object = pSAppPVPartBase.getPortletType();
            xmlNode.setAttribute(FIELD_PORTLETTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getPosInfo() != null) {
            object = pSAppPVPartBase.getPosInfo();
            xmlNode.setAttribute(FIELD_POSINFO, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getPPSAppPVPartId() != null) {
            object = pSAppPVPartBase.getPPSAppPVPartId();
            xmlNode.setAttribute(FIELD_PPSAPPPVPARTID, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getPPSAppPVPartName() != null) {
            object = pSAppPVPartBase.getPPSAppPVPartName();
            xmlNode.setAttribute(FIELD_PPSAPPPVPARTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getPSAppMenuId() != null) {
            object = pSAppPVPartBase.getPSAppMenuId();
            xmlNode.setAttribute(FIELD_PSAPPMENUID, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getPSAppMenuName() != null) {
            object = pSAppPVPartBase.getPSAppMenuName();
            xmlNode.setAttribute(FIELD_PSAPPMENUNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getPSAppPortalViewId() != null) {
            object = pSAppPVPartBase.getPSAppPortalViewId();
            xmlNode.setAttribute(FIELD_PSAPPPORTALVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getPSAppPortalViewName() != null) {
            object = pSAppPVPartBase.getPSAppPortalViewName();
            xmlNode.setAttribute(FIELD_PSAPPPORTALVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getPSAppPVPartId() != null) {
            object = pSAppPVPartBase.getPSAppPVPartId();
            xmlNode.setAttribute(FIELD_PSAPPPVPARTID, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getPSAppPVPartName() != null) {
            object = pSAppPVPartBase.getPSAppPVPartName();
            xmlNode.setAttribute(FIELD_PSAPPPVPARTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getPSAppViewId() != null) {
            object = pSAppPVPartBase.getPSAppViewId();
            xmlNode.setAttribute(FIELD_PSAPPVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getPSAppViewName() != null) {
            object = pSAppPVPartBase.getPSAppViewName();
            xmlNode.setAttribute(FIELD_PSAPPVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getPSSysCssId() != null) {
            object = pSAppPVPartBase.getPSSysCssId();
            xmlNode.setAttribute(FIELD_PSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getPSSysCssName() != null) {
            object = pSAppPVPartBase.getPSSysCssName();
            xmlNode.setAttribute(FIELD_PSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getPSSysImageId() != null) {
            object = pSAppPVPartBase.getPSSysImageId();
            xmlNode.setAttribute(FIELD_PSSYSIMAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getPSSysImageName() != null) {
            object = pSAppPVPartBase.getPSSysImageName();
            xmlNode.setAttribute(FIELD_PSSYSIMAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getPSSysPFPluginId() != null) {
            object = pSAppPVPartBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getPSSysPFPluginName() != null) {
            object = pSAppPVPartBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getPSSysPortletId() != null) {
            object = pSAppPVPartBase.getPSSysPortletId();
            xmlNode.setAttribute(FIELD_PSSYSPORTLETID, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getPSSysPortletName() != null) {
            object = pSAppPVPartBase.getPSSysPortletName();
            xmlNode.setAttribute(FIELD_PSSYSPORTLETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getPSSysResourceId() != null) {
            object = pSAppPVPartBase.getPSSysResourceId();
            xmlNode.setAttribute(FIELD_PSSYSRESOURCEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getPSSysResourceName() != null) {
            object = pSAppPVPartBase.getPSSysResourceName();
            xmlNode.setAttribute(FIELD_PSSYSRESOURCENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getPSSystemId() != null) {
            object = pSAppPVPartBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getPSSysUniResId() != null) {
            object = pSAppPVPartBase.getPSSysUniResId();
            xmlNode.setAttribute(FIELD_PSSYSUNIRESID, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getPSSysUniResName() != null) {
            object = pSAppPVPartBase.getPSSysUniResName();
            xmlNode.setAttribute(FIELD_PSSYSUNIRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getPVPartType() != null) {
            object = pSAppPVPartBase.getPVPartType();
            xmlNode.setAttribute(FIELD_PVPARTTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getRawContent() != null) {
            object = pSAppPVPartBase.getRawContent();
            xmlNode.setAttribute(FIELD_RAWCONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getRawCssStyle() != null) {
            object = pSAppPVPartBase.getRawCssStyle();
            xmlNode.setAttribute(FIELD_RAWCSSSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getShowTitleBar() != null) {
            object = pSAppPVPartBase.getShowTitleBar();
            xmlNode.setAttribute(FIELD_SHOWTITLEBAR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppPVPartBase.getSwapMode() != null) {
            object = pSAppPVPartBase.getSwapMode();
            xmlNode.setAttribute(FIELD_SWAPMODE, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getTemplateMode() != null) {
            object = pSAppPVPartBase.getTemplateMode();
            xmlNode.setAttribute(FIELD_TEMPLATEMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppPVPartBase.getTitle() != null) {
            object = pSAppPVPartBase.getTitle();
            xmlNode.setAttribute(FIELD_TITLE, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getTitleBarCloseMode() != null) {
            object = pSAppPVPartBase.getTitleBarCloseMode();
            xmlNode.setAttribute(FIELD_TITLEBARCLOSEMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppPVPartBase.getTitlePSLanResId() != null) {
            object = pSAppPVPartBase.getTitlePSLanResId();
            xmlNode.setAttribute(FIELD_TITLEPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getTitlePSLanResName() != null) {
            object = pSAppPVPartBase.getTitlePSLanResName();
            xmlNode.setAttribute(FIELD_TITLEPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getTooltipInfo() != null) {
            object = pSAppPVPartBase.getTooltipInfo();
            xmlNode.setAttribute(FIELD_TOOLTIPINFO, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getUpdateDate() != null) {
            object = pSAppPVPartBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppPVPartBase.getUpdateMan() != null) {
            object = pSAppPVPartBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getUserTag() != null) {
            object = pSAppPVPartBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getUserTag2() != null) {
            object = pSAppPVPartBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getValidFlag() != null) {
            object = pSAppPVPartBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppPVPartBase.getVAlignSelf() != null) {
            object = pSAppPVPartBase.getVAlignSelf();
            xmlNode.setAttribute(FIELD_VALIGNSELF, object == null ? "" : (String)object);
        }
        if (bl || pSAppPVPartBase.getWidth() != null) {
            object = pSAppPVPartBase.getWidth();
            xmlNode.setAttribute(FIELD_WIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppPVPartBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppPVPartBase pSAppPVPartBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppPVPartBase.isAMPSSysPFPluginIdDirty() && (bl || pSAppPVPartBase.getAMPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_AMPSSYSPFPLUGINID, (Object)pSAppPVPartBase.getAMPSSysPFPluginId());
        }
        if (pSAppPVPartBase.isAMPSSysPFPluginNameDirty() && (bl || pSAppPVPartBase.getAMPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_AMPSSYSPFPLUGINNAME, (Object)pSAppPVPartBase.getAMPSSysPFPluginName());
        }
        if (pSAppPVPartBase.isBL_PosDirty() && (bl || pSAppPVPartBase.getBL_Pos() != null)) {
            iDataObject.set(FIELD_BL_POS, (Object)pSAppPVPartBase.getBL_Pos());
        }
        if (pSAppPVPartBase.isColIdDirty() && (bl || pSAppPVPartBase.getColId() != null)) {
            iDataObject.set(FIELD_COLID, (Object)pSAppPVPartBase.getColId());
        }
        if (pSAppPVPartBase.isColSpanDirty() && (bl || pSAppPVPartBase.getColSpan() != null)) {
            iDataObject.set(FIELD_COLSPAN, (Object)pSAppPVPartBase.getColSpan());
        }
        if (pSAppPVPartBase.isCol_LGDirty() && (bl || pSAppPVPartBase.getCol_LG() != null)) {
            iDataObject.set(FIELD_COL_LG, (Object)pSAppPVPartBase.getCol_LG());
        }
        if (pSAppPVPartBase.isCol_LG_OSDirty() && (bl || pSAppPVPartBase.getCol_LG_OS() != null)) {
            iDataObject.set(FIELD_COL_LG_OS, (Object)pSAppPVPartBase.getCol_LG_OS());
        }
        if (pSAppPVPartBase.isCol_MDDirty() && (bl || pSAppPVPartBase.getCol_MD() != null)) {
            iDataObject.set(FIELD_COL_MD, (Object)pSAppPVPartBase.getCol_MD());
        }
        if (pSAppPVPartBase.isCol_MD_OSDirty() && (bl || pSAppPVPartBase.getCol_MD_OS() != null)) {
            iDataObject.set(FIELD_COL_MD_OS, (Object)pSAppPVPartBase.getCol_MD_OS());
        }
        if (pSAppPVPartBase.isCol_SMDirty() && (bl || pSAppPVPartBase.getCol_SM() != null)) {
            iDataObject.set(FIELD_COL_SM, (Object)pSAppPVPartBase.getCol_SM());
        }
        if (pSAppPVPartBase.isCol_SM_OSDirty() && (bl || pSAppPVPartBase.getCol_SM_OS() != null)) {
            iDataObject.set(FIELD_COL_SM_OS, (Object)pSAppPVPartBase.getCol_SM_OS());
        }
        if (pSAppPVPartBase.isCol_XSDirty() && (bl || pSAppPVPartBase.getCol_XS() != null)) {
            iDataObject.set(FIELD_COL_XS, (Object)pSAppPVPartBase.getCol_XS());
        }
        if (pSAppPVPartBase.isCol_XS_OSDirty() && (bl || pSAppPVPartBase.getCol_XS_OS() != null)) {
            iDataObject.set(FIELD_COL_XS_OS, (Object)pSAppPVPartBase.getCol_XS_OS());
        }
        if (pSAppPVPartBase.isContentTypeDirty() && (bl || pSAppPVPartBase.getContentType() != null)) {
            iDataObject.set(FIELD_CONTENTTYPE, (Object)pSAppPVPartBase.getContentType());
        }
        if (pSAppPVPartBase.isCreateDateDirty() && (bl || pSAppPVPartBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppPVPartBase.getCreateDate());
        }
        if (pSAppPVPartBase.isCreateManDirty() && (bl || pSAppPVPartBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppPVPartBase.getCreateMan());
        }
        if (pSAppPVPartBase.isDynaClassDirty() && (bl || pSAppPVPartBase.getDynaClass() != null)) {
            iDataObject.set(FIELD_DYNACLASS, (Object)pSAppPVPartBase.getDynaClass());
        }
        if (pSAppPVPartBase.isEnableAnchorDirty() && (bl || pSAppPVPartBase.getEnableAnchor() != null)) {
            iDataObject.set(FIELD_ENABLEANCHOR, (Object)pSAppPVPartBase.getEnableAnchor());
        }
        if (pSAppPVPartBase.isEnableCustomMenuDirty() && (bl || pSAppPVPartBase.getEnableCustomMenu() != null)) {
            iDataObject.set(FIELD_ENABLECUSTOMMENU, (Object)pSAppPVPartBase.getEnableCustomMenu());
        }
        if (pSAppPVPartBase.isFlexAlignDirty() && (bl || pSAppPVPartBase.getFlexAlign() != null)) {
            iDataObject.set(FIELD_FLEXALIGN, (Object)pSAppPVPartBase.getFlexAlign());
        }
        if (pSAppPVPartBase.isFlexBasisDirty() && (bl || pSAppPVPartBase.getFlexBasis() != null)) {
            iDataObject.set(FIELD_FLEXBASIS, (Object)pSAppPVPartBase.getFlexBasis());
        }
        if (pSAppPVPartBase.isFlexDirDirty() && (bl || pSAppPVPartBase.getFlexDir() != null)) {
            iDataObject.set(FIELD_FLEXDIR, (Object)pSAppPVPartBase.getFlexDir());
        }
        if (pSAppPVPartBase.isFlexGrowDirty() && (bl || pSAppPVPartBase.getFlexGrow() != null)) {
            iDataObject.set(FIELD_FLEXGROW, (Object)pSAppPVPartBase.getFlexGrow());
        }
        if (pSAppPVPartBase.isFlexShrinkDirty() && (bl || pSAppPVPartBase.getFlexShrink() != null)) {
            iDataObject.set(FIELD_FLEXSHRINK, (Object)pSAppPVPartBase.getFlexShrink());
        }
        if (pSAppPVPartBase.isFlexVAlignDirty() && (bl || pSAppPVPartBase.getFlexVAlign() != null)) {
            iDataObject.set(FIELD_FLEXVALIGN, (Object)pSAppPVPartBase.getFlexVAlign());
        }
        if (pSAppPVPartBase.isHAlignSelfDirty() && (bl || pSAppPVPartBase.getHAlignSelf() != null)) {
            iDataObject.set(FIELD_HALIGNSELF, (Object)pSAppPVPartBase.getHAlignSelf());
        }
        if (pSAppPVPartBase.isHeightDirty() && (bl || pSAppPVPartBase.getHeight() != null)) {
            iDataObject.set(FIELD_HEIGHT, (Object)pSAppPVPartBase.getHeight());
        }
        if (pSAppPVPartBase.isHtmlContentDirty() && (bl || pSAppPVPartBase.getHtmlContent() != null)) {
            iDataObject.set(FIELD_HTMLCONTENT, (Object)pSAppPVPartBase.getHtmlContent());
        }
        if (pSAppPVPartBase.isLayoutModeDirty() && (bl || pSAppPVPartBase.getLayoutMode() != null)) {
            iDataObject.set(FIELD_LAYOUTMODE, (Object)pSAppPVPartBase.getLayoutMode());
        }
        if (pSAppPVPartBase.isMemoDirty() && (bl || pSAppPVPartBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSAppPVPartBase.getMemo());
        }
        if (pSAppPVPartBase.isMenuPSAppUtilViewIdDirty() && (bl || pSAppPVPartBase.getMenuPSAppUtilViewId() != null)) {
            iDataObject.set(FIELD_MENUPSAPPUTILVIEWID, (Object)pSAppPVPartBase.getMenuPSAppUtilViewId());
        }
        if (pSAppPVPartBase.isMenuPSAppUtilViewNameDirty() && (bl || pSAppPVPartBase.getMenuPSAppUtilViewName() != null)) {
            iDataObject.set(FIELD_MENUPSAPPUTILVIEWNAME, (Object)pSAppPVPartBase.getMenuPSAppUtilViewName());
        }
        if (pSAppPVPartBase.isMOBAMStyleDirty() && (bl || pSAppPVPartBase.getMOBAMStyle() != null)) {
            iDataObject.set(FIELD_MOBAMSTYLE, (Object)pSAppPVPartBase.getMOBAMStyle());
        }
        if (pSAppPVPartBase.isNewRowModeDirty() && (bl || pSAppPVPartBase.getNewRowMode() != null)) {
            iDataObject.set(FIELD_NEWROWMODE, (Object)pSAppPVPartBase.getNewRowMode());
        }
        if (pSAppPVPartBase.isOrderValueDirty() && (bl || pSAppPVPartBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSAppPVPartBase.getOrderValue());
        }
        if (pSAppPVPartBase.isPartParamsDirty() && (bl || pSAppPVPartBase.getPartParams() != null)) {
            iDataObject.set(FIELD_PARTPARAMS, (Object)pSAppPVPartBase.getPartParams());
        }
        if (pSAppPVPartBase.isPartStyleDirty() && (bl || pSAppPVPartBase.getPartStyle() != null)) {
            iDataObject.set(FIELD_PARTSTYLE, (Object)pSAppPVPartBase.getPartStyle());
        }
        if (pSAppPVPartBase.isPortletTypeDirty() && (bl || pSAppPVPartBase.getPortletType() != null)) {
            iDataObject.set(FIELD_PORTLETTYPE, (Object)pSAppPVPartBase.getPortletType());
        }
        if (pSAppPVPartBase.isPosInfoDirty() && (bl || pSAppPVPartBase.getPosInfo() != null)) {
            iDataObject.set(FIELD_POSINFO, (Object)pSAppPVPartBase.getPosInfo());
        }
        if (pSAppPVPartBase.isPPSAppPVPartIdDirty() && (bl || pSAppPVPartBase.getPPSAppPVPartId() != null)) {
            iDataObject.set(FIELD_PPSAPPPVPARTID, (Object)pSAppPVPartBase.getPPSAppPVPartId());
        }
        if (pSAppPVPartBase.isPPSAppPVPartNameDirty() && (bl || pSAppPVPartBase.getPPSAppPVPartName() != null)) {
            iDataObject.set(FIELD_PPSAPPPVPARTNAME, (Object)pSAppPVPartBase.getPPSAppPVPartName());
        }
        if (pSAppPVPartBase.isPSAppMenuIdDirty() && (bl || pSAppPVPartBase.getPSAppMenuId() != null)) {
            iDataObject.set(FIELD_PSAPPMENUID, (Object)pSAppPVPartBase.getPSAppMenuId());
        }
        if (pSAppPVPartBase.isPSAppMenuNameDirty() && (bl || pSAppPVPartBase.getPSAppMenuName() != null)) {
            iDataObject.set(FIELD_PSAPPMENUNAME, (Object)pSAppPVPartBase.getPSAppMenuName());
        }
        if (pSAppPVPartBase.isPSAppPortalViewIdDirty() && (bl || pSAppPVPartBase.getPSAppPortalViewId() != null)) {
            iDataObject.set(FIELD_PSAPPPORTALVIEWID, (Object)pSAppPVPartBase.getPSAppPortalViewId());
        }
        if (pSAppPVPartBase.isPSAppPortalViewNameDirty() && (bl || pSAppPVPartBase.getPSAppPortalViewName() != null)) {
            iDataObject.set(FIELD_PSAPPPORTALVIEWNAME, (Object)pSAppPVPartBase.getPSAppPortalViewName());
        }
        if (pSAppPVPartBase.isPSAppPVPartIdDirty() && (bl || pSAppPVPartBase.getPSAppPVPartId() != null)) {
            iDataObject.set(FIELD_PSAPPPVPARTID, (Object)pSAppPVPartBase.getPSAppPVPartId());
        }
        if (pSAppPVPartBase.isPSAppPVPartNameDirty() && (bl || pSAppPVPartBase.getPSAppPVPartName() != null)) {
            iDataObject.set(FIELD_PSAPPPVPARTNAME, (Object)pSAppPVPartBase.getPSAppPVPartName());
        }
        if (pSAppPVPartBase.isPSAppViewIdDirty() && (bl || pSAppPVPartBase.getPSAppViewId() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWID, (Object)pSAppPVPartBase.getPSAppViewId());
        }
        if (pSAppPVPartBase.isPSAppViewNameDirty() && (bl || pSAppPVPartBase.getPSAppViewName() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWNAME, (Object)pSAppPVPartBase.getPSAppViewName());
        }
        if (pSAppPVPartBase.isPSSysCssIdDirty() && (bl || pSAppPVPartBase.getPSSysCssId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSID, (Object)pSAppPVPartBase.getPSSysCssId());
        }
        if (pSAppPVPartBase.isPSSysCssNameDirty() && (bl || pSAppPVPartBase.getPSSysCssName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSNAME, (Object)pSAppPVPartBase.getPSSysCssName());
        }
        if (pSAppPVPartBase.isPSSysImageIdDirty() && (bl || pSAppPVPartBase.getPSSysImageId() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGEID, (Object)pSAppPVPartBase.getPSSysImageId());
        }
        if (pSAppPVPartBase.isPSSysImageNameDirty() && (bl || pSAppPVPartBase.getPSSysImageName() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGENAME, (Object)pSAppPVPartBase.getPSSysImageName());
        }
        if (pSAppPVPartBase.isPSSysPFPluginIdDirty() && (bl || pSAppPVPartBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSAppPVPartBase.getPSSysPFPluginId());
        }
        if (pSAppPVPartBase.isPSSysPFPluginNameDirty() && (bl || pSAppPVPartBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSAppPVPartBase.getPSSysPFPluginName());
        }
        if (pSAppPVPartBase.isPSSysPortletIdDirty() && (bl || pSAppPVPartBase.getPSSysPortletId() != null)) {
            iDataObject.set(FIELD_PSSYSPORTLETID, (Object)pSAppPVPartBase.getPSSysPortletId());
        }
        if (pSAppPVPartBase.isPSSysPortletNameDirty() && (bl || pSAppPVPartBase.getPSSysPortletName() != null)) {
            iDataObject.set(FIELD_PSSYSPORTLETNAME, (Object)pSAppPVPartBase.getPSSysPortletName());
        }
        if (pSAppPVPartBase.isPSSysResourceIdDirty() && (bl || pSAppPVPartBase.getPSSysResourceId() != null)) {
            iDataObject.set(FIELD_PSSYSRESOURCEID, (Object)pSAppPVPartBase.getPSSysResourceId());
        }
        if (pSAppPVPartBase.isPSSysResourceNameDirty() && (bl || pSAppPVPartBase.getPSSysResourceName() != null)) {
            iDataObject.set(FIELD_PSSYSRESOURCENAME, (Object)pSAppPVPartBase.getPSSysResourceName());
        }
        if (pSAppPVPartBase.isPSSystemIdDirty() && (bl || pSAppPVPartBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSAppPVPartBase.getPSSystemId());
        }
        if (pSAppPVPartBase.isPSSysUniResIdDirty() && (bl || pSAppPVPartBase.getPSSysUniResId() != null)) {
            iDataObject.set(FIELD_PSSYSUNIRESID, (Object)pSAppPVPartBase.getPSSysUniResId());
        }
        if (pSAppPVPartBase.isPSSysUniResNameDirty() && (bl || pSAppPVPartBase.getPSSysUniResName() != null)) {
            iDataObject.set(FIELD_PSSYSUNIRESNAME, (Object)pSAppPVPartBase.getPSSysUniResName());
        }
        if (pSAppPVPartBase.isPVPartTypeDirty() && (bl || pSAppPVPartBase.getPVPartType() != null)) {
            iDataObject.set(FIELD_PVPARTTYPE, (Object)pSAppPVPartBase.getPVPartType());
        }
        if (pSAppPVPartBase.isRawContentDirty() && (bl || pSAppPVPartBase.getRawContent() != null)) {
            iDataObject.set(FIELD_RAWCONTENT, (Object)pSAppPVPartBase.getRawContent());
        }
        if (pSAppPVPartBase.isRawCssStyleDirty() && (bl || pSAppPVPartBase.getRawCssStyle() != null)) {
            iDataObject.set(FIELD_RAWCSSSTYLE, (Object)pSAppPVPartBase.getRawCssStyle());
        }
        if (pSAppPVPartBase.isShowTitleBarDirty() && (bl || pSAppPVPartBase.getShowTitleBar() != null)) {
            iDataObject.set(FIELD_SHOWTITLEBAR, (Object)pSAppPVPartBase.getShowTitleBar());
        }
        if (pSAppPVPartBase.isSwapModeDirty() && (bl || pSAppPVPartBase.getSwapMode() != null)) {
            iDataObject.set(FIELD_SWAPMODE, (Object)pSAppPVPartBase.getSwapMode());
        }
        if (pSAppPVPartBase.isTemplateModeDirty() && (bl || pSAppPVPartBase.getTemplateMode() != null)) {
            iDataObject.set(FIELD_TEMPLATEMODE, (Object)pSAppPVPartBase.getTemplateMode());
        }
        if (pSAppPVPartBase.isTitleDirty() && (bl || pSAppPVPartBase.getTitle() != null)) {
            iDataObject.set(FIELD_TITLE, (Object)pSAppPVPartBase.getTitle());
        }
        if (pSAppPVPartBase.isTitleBarCloseModeDirty() && (bl || pSAppPVPartBase.getTitleBarCloseMode() != null)) {
            iDataObject.set(FIELD_TITLEBARCLOSEMODE, (Object)pSAppPVPartBase.getTitleBarCloseMode());
        }
        if (pSAppPVPartBase.isTitlePSLanResIdDirty() && (bl || pSAppPVPartBase.getTitlePSLanResId() != null)) {
            iDataObject.set(FIELD_TITLEPSLANRESID, (Object)pSAppPVPartBase.getTitlePSLanResId());
        }
        if (pSAppPVPartBase.isTitlePSLanResNameDirty() && (bl || pSAppPVPartBase.getTitlePSLanResName() != null)) {
            iDataObject.set(FIELD_TITLEPSLANRESNAME, (Object)pSAppPVPartBase.getTitlePSLanResName());
        }
        if (pSAppPVPartBase.isTooltipInfoDirty() && (bl || pSAppPVPartBase.getTooltipInfo() != null)) {
            iDataObject.set(FIELD_TOOLTIPINFO, (Object)pSAppPVPartBase.getTooltipInfo());
        }
        if (pSAppPVPartBase.isUpdateDateDirty() && (bl || pSAppPVPartBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppPVPartBase.getUpdateDate());
        }
        if (pSAppPVPartBase.isUpdateManDirty() && (bl || pSAppPVPartBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppPVPartBase.getUpdateMan());
        }
        if (pSAppPVPartBase.isUserTagDirty() && (bl || pSAppPVPartBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSAppPVPartBase.getUserTag());
        }
        if (pSAppPVPartBase.isUserTag2Dirty() && (bl || pSAppPVPartBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSAppPVPartBase.getUserTag2());
        }
        if (pSAppPVPartBase.isValidFlagDirty() && (bl || pSAppPVPartBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSAppPVPartBase.getValidFlag());
        }
        if (pSAppPVPartBase.isVAlignSelfDirty() && (bl || pSAppPVPartBase.getVAlignSelf() != null)) {
            iDataObject.set(FIELD_VALIGNSELF, (Object)pSAppPVPartBase.getVAlignSelf());
        }
        if (pSAppPVPartBase.isWidthDirty() && (bl || pSAppPVPartBase.getWidth() != null)) {
            iDataObject.set(FIELD_WIDTH, (Object)pSAppPVPartBase.getWidth());
        }
    }

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
        return PSAppPVPartBase.remove(this, n);
    }

    private static boolean remove(PSAppPVPartBase pSAppPVPartBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSAppPVPartBase.resetAMPSSysPFPluginId();
                return true;
            }
            case 1: {
                pSAppPVPartBase.resetAMPSSysPFPluginName();
                return true;
            }
            case 2: {
                pSAppPVPartBase.resetBL_Pos();
                return true;
            }
            case 3: {
                pSAppPVPartBase.resetColId();
                return true;
            }
            case 4: {
                pSAppPVPartBase.resetColSpan();
                return true;
            }
            case 5: {
                pSAppPVPartBase.resetCol_LG();
                return true;
            }
            case 6: {
                pSAppPVPartBase.resetCol_LG_OS();
                return true;
            }
            case 7: {
                pSAppPVPartBase.resetCol_MD();
                return true;
            }
            case 8: {
                pSAppPVPartBase.resetCol_MD_OS();
                return true;
            }
            case 9: {
                pSAppPVPartBase.resetCol_SM();
                return true;
            }
            case 10: {
                pSAppPVPartBase.resetCol_SM_OS();
                return true;
            }
            case 11: {
                pSAppPVPartBase.resetCol_XS();
                return true;
            }
            case 12: {
                pSAppPVPartBase.resetCol_XS_OS();
                return true;
            }
            case 13: {
                pSAppPVPartBase.resetContentType();
                return true;
            }
            case 14: {
                pSAppPVPartBase.resetCreateDate();
                return true;
            }
            case 15: {
                pSAppPVPartBase.resetCreateMan();
                return true;
            }
            case 16: {
                pSAppPVPartBase.resetDynaClass();
                return true;
            }
            case 17: {
                pSAppPVPartBase.resetEnableAnchor();
                return true;
            }
            case 18: {
                pSAppPVPartBase.resetEnableCustomMenu();
                return true;
            }
            case 19: {
                pSAppPVPartBase.resetFlexAlign();
                return true;
            }
            case 20: {
                pSAppPVPartBase.resetFlexBasis();
                return true;
            }
            case 21: {
                pSAppPVPartBase.resetFlexDir();
                return true;
            }
            case 22: {
                pSAppPVPartBase.resetFlexGrow();
                return true;
            }
            case 23: {
                pSAppPVPartBase.resetFlexShrink();
                return true;
            }
            case 24: {
                pSAppPVPartBase.resetFlexVAlign();
                return true;
            }
            case 25: {
                pSAppPVPartBase.resetHAlignSelf();
                return true;
            }
            case 26: {
                pSAppPVPartBase.resetHeight();
                return true;
            }
            case 27: {
                pSAppPVPartBase.resetHtmlContent();
                return true;
            }
            case 28: {
                pSAppPVPartBase.resetLayoutMode();
                return true;
            }
            case 29: {
                pSAppPVPartBase.resetMemo();
                return true;
            }
            case 30: {
                pSAppPVPartBase.resetMenuPSAppUtilViewId();
                return true;
            }
            case 31: {
                pSAppPVPartBase.resetMenuPSAppUtilViewName();
                return true;
            }
            case 32: {
                pSAppPVPartBase.resetMOBAMStyle();
                return true;
            }
            case 33: {
                pSAppPVPartBase.resetNewRowMode();
                return true;
            }
            case 34: {
                pSAppPVPartBase.resetOrderValue();
                return true;
            }
            case 35: {
                pSAppPVPartBase.resetPartParams();
                return true;
            }
            case 36: {
                pSAppPVPartBase.resetPartStyle();
                return true;
            }
            case 37: {
                pSAppPVPartBase.resetPortletType();
                return true;
            }
            case 38: {
                pSAppPVPartBase.resetPosInfo();
                return true;
            }
            case 39: {
                pSAppPVPartBase.resetPPSAppPVPartId();
                return true;
            }
            case 40: {
                pSAppPVPartBase.resetPPSAppPVPartName();
                return true;
            }
            case 41: {
                pSAppPVPartBase.resetPSAppMenuId();
                return true;
            }
            case 42: {
                pSAppPVPartBase.resetPSAppMenuName();
                return true;
            }
            case 43: {
                pSAppPVPartBase.resetPSAppPortalViewId();
                return true;
            }
            case 44: {
                pSAppPVPartBase.resetPSAppPortalViewName();
                return true;
            }
            case 45: {
                pSAppPVPartBase.resetPSAppPVPartId();
                return true;
            }
            case 46: {
                pSAppPVPartBase.resetPSAppPVPartName();
                return true;
            }
            case 47: {
                pSAppPVPartBase.resetPSAppViewId();
                return true;
            }
            case 48: {
                pSAppPVPartBase.resetPSAppViewName();
                return true;
            }
            case 49: {
                pSAppPVPartBase.resetPSSysCssId();
                return true;
            }
            case 50: {
                pSAppPVPartBase.resetPSSysCssName();
                return true;
            }
            case 51: {
                pSAppPVPartBase.resetPSSysImageId();
                return true;
            }
            case 52: {
                pSAppPVPartBase.resetPSSysImageName();
                return true;
            }
            case 53: {
                pSAppPVPartBase.resetPSSysPFPluginId();
                return true;
            }
            case 54: {
                pSAppPVPartBase.resetPSSysPFPluginName();
                return true;
            }
            case 55: {
                pSAppPVPartBase.resetPSSysPortletId();
                return true;
            }
            case 56: {
                pSAppPVPartBase.resetPSSysPortletName();
                return true;
            }
            case 57: {
                pSAppPVPartBase.resetPSSysResourceId();
                return true;
            }
            case 58: {
                pSAppPVPartBase.resetPSSysResourceName();
                return true;
            }
            case 59: {
                pSAppPVPartBase.resetPSSystemId();
                return true;
            }
            case 60: {
                pSAppPVPartBase.resetPSSysUniResId();
                return true;
            }
            case 61: {
                pSAppPVPartBase.resetPSSysUniResName();
                return true;
            }
            case 62: {
                pSAppPVPartBase.resetPVPartType();
                return true;
            }
            case 63: {
                pSAppPVPartBase.resetRawContent();
                return true;
            }
            case 64: {
                pSAppPVPartBase.resetRawCssStyle();
                return true;
            }
            case 65: {
                pSAppPVPartBase.resetShowTitleBar();
                return true;
            }
            case 66: {
                pSAppPVPartBase.resetSwapMode();
                return true;
            }
            case 67: {
                pSAppPVPartBase.resetTemplateMode();
                return true;
            }
            case 68: {
                pSAppPVPartBase.resetTitle();
                return true;
            }
            case 69: {
                pSAppPVPartBase.resetTitleBarCloseMode();
                return true;
            }
            case 70: {
                pSAppPVPartBase.resetTitlePSLanResId();
                return true;
            }
            case 71: {
                pSAppPVPartBase.resetTitlePSLanResName();
                return true;
            }
            case 72: {
                pSAppPVPartBase.resetTooltipInfo();
                return true;
            }
            case 73: {
                pSAppPVPartBase.resetUpdateDate();
                return true;
            }
            case 74: {
                pSAppPVPartBase.resetUpdateMan();
                return true;
            }
            case 75: {
                pSAppPVPartBase.resetUserTag();
                return true;
            }
            case 76: {
                pSAppPVPartBase.resetUserTag2();
                return true;
            }
            case 77: {
                pSAppPVPartBase.resetValidFlag();
                return true;
            }
            case 78: {
                pSAppPVPartBase.resetVAlignSelf();
                return true;
            }
            case 79: {
                pSAppPVPartBase.resetWidth();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
                pSAppMenuService.autoGet((IEntity)pSAppMenu);
                this.psappmenu = pSAppMenu;
            }
            return this.psappmenu;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppPortalView getPSAppPortalView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppPortalView();
        }
        if (this.getPSAppPortalViewId() == null) {
            return null;
        }
        Integer n = this.objPSAppPortalViewLock;
        synchronized (n) {
            if (this.psappportalview != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppPortalViewId(), (Object)this.psappportalview.getPSAppPortalViewId()) != 0L) {
                this.psappportalview = null;
            }
            if (this.psappportalview == null) {
                PSAppPortalView pSAppPortalView = new PSAppPortalView();
                pSAppPortalView.setPSAppPortalViewId(this.getPSAppPortalViewId());
                PSAppPortalViewService pSAppPortalViewService = (PSAppPortalViewService)ServiceGlobal.getService(PSAppPortalViewService.class, (SessionFactory)this.getSessionFactory());
                pSAppPortalViewService.autoGet((IEntity)pSAppPortalView);
                this.psappportalview = pSAppPortalView;
            }
            return this.psappportalview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppPVPart getPPSAppPVPart() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSAppPVPart();
        }
        if (this.getPPSAppPVPartId() == null) {
            return null;
        }
        Integer n = this.objPPSAppPVPartLock;
        synchronized (n) {
            if (this.ppsapppvpart != null && DataTypeHelper.compare((int)25, (Object)this.getPPSAppPVPartId(), (Object)this.ppsapppvpart.getPSAppPVPartId()) != 0L) {
                this.ppsapppvpart = null;
            }
            if (this.ppsapppvpart == null) {
                PSAppPVPart pSAppPVPart = new PSAppPVPart();
                pSAppPVPart.setPSAppPVPartId(this.getPPSAppPVPartId());
                PSAppPVPartService pSAppPVPartService = (PSAppPVPartService)ServiceGlobal.getService(PSAppPVPartService.class, (SessionFactory)this.getSessionFactory());
                pSAppPVPartService.autoGet((IEntity)pSAppPVPart);
                this.ppsapppvpart = pSAppPVPart;
            }
            return this.ppsapppvpart;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppUtilView getMenuPSAppUtilView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMenuPSAppUtilView();
        }
        if (this.getMenuPSAppUtilViewId() == null) {
            return null;
        }
        Integer n = this.objMenuPSAppUtilViewLock;
        synchronized (n) {
            if (this.menupsapputilview != null && DataTypeHelper.compare((int)25, (Object)this.getMenuPSAppUtilViewId(), (Object)this.menupsapputilview.getPSAppUtilViewId()) != 0L) {
                this.menupsapputilview = null;
            }
            if (this.menupsapputilview == null) {
                PSAppUtilView pSAppUtilView = new PSAppUtilView();
                pSAppUtilView.setPSAppUtilViewId(this.getMenuPSAppUtilViewId());
                PSAppUtilViewService pSAppUtilViewService = (PSAppUtilViewService)ServiceGlobal.getService(PSAppUtilViewService.class, (SessionFactory)this.getSessionFactory());
                pSAppUtilViewService.autoGet((IEntity)pSAppUtilView);
                this.menupsapputilview = pSAppUtilView;
            }
            return this.menupsapputilview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppView getPSAppView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppView();
        }
        if (this.getPSAppViewId() == null) {
            return null;
        }
        Integer n = this.objPSAppViewLock;
        synchronized (n) {
            if (this.psappview != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppViewId(), (Object)this.psappview.getPSAppViewId()) != 0L) {
                this.psappview = null;
            }
            if (this.psappview == null) {
                PSAppView pSAppView = new PSAppView();
                pSAppView.setPSAppViewId(this.getPSAppViewId());
                PSAppViewService pSAppViewService = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
                pSAppViewService.autoGet((IEntity)pSAppView);
                this.psappview = pSAppView;
            }
            return this.psappview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getTitlePSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitlePSLanRes();
        }
        if (this.getTitlePSLanResId() == null) {
            return null;
        }
        Integer n = this.objTitlePSLanResLock;
        synchronized (n) {
            if (this.titlepslanres != null && DataTypeHelper.compare((int)25, (Object)this.getTitlePSLanResId(), (Object)this.titlepslanres.getPSLanguageResId()) != 0L) {
                this.titlepslanres = null;
            }
            if (this.titlepslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getTitlePSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.titlepslanres = pSLanguageRes;
            }
            return this.titlepslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysCss getPSSysCss() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCss();
        }
        if (this.getPSSysCssId() == null) {
            return null;
        }
        Integer n = this.objPSSysCssLock;
        synchronized (n) {
            if (this.pssyscss != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysCssId(), (Object)this.pssyscss.getPSSysCssId()) != 0L) {
                this.pssyscss = null;
            }
            if (this.pssyscss == null) {
                PSSysCss pSSysCss = new PSSysCss();
                pSSysCss.setPSSysCssId(this.getPSSysCssId());
                PSSysCssService pSSysCssService = (PSSysCssService)ServiceGlobal.getService(PSSysCssService.class, (SessionFactory)this.getSessionFactory());
                pSSysCssService.autoGet((IEntity)pSSysCss);
                this.pssyscss = pSSysCss;
            }
            return this.pssyscss;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysImage getPSSysImage() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysImage();
        }
        if (this.getPSSysImageId() == null) {
            return null;
        }
        Integer n = this.objPSSysImageLock;
        synchronized (n) {
            if (this.pssysimage != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysImageId(), (Object)this.pssysimage.getPSSysImageId()) != 0L) {
                this.pssysimage = null;
            }
            if (this.pssysimage == null) {
                PSSysImage pSSysImage = new PSSysImage();
                pSSysImage.setPSSysImageId(this.getPSSysImageId());
                PSSysImageService pSSysImageService = (PSSysImageService)ServiceGlobal.getService(PSSysImageService.class, (SessionFactory)this.getSessionFactory());
                pSSysImageService.autoGet((IEntity)pSSysImage);
                this.pssysimage = pSSysImage;
            }
            return this.pssysimage;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysPFPlugin getAMPSSysPFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAMPSSysPFPlugin();
        }
        if (this.getAMPSSysPFPluginId() == null) {
            return null;
        }
        Integer n = this.objAMPSSysPFPluginLock;
        synchronized (n) {
            if (this.ampssyspfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getAMPSSysPFPluginId(), (Object)this.ampssyspfplugin.getPSSysPFPluginId()) != 0L) {
                this.ampssyspfplugin = null;
            }
            if (this.ampssyspfplugin == null) {
                PSSysPFPlugin pSSysPFPlugin = new PSSysPFPlugin();
                pSSysPFPlugin.setPSSysPFPluginId(this.getAMPSSysPFPluginId());
                PSSysPFPluginService pSSysPFPluginService = (PSSysPFPluginService)ServiceGlobal.getService(PSSysPFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysPFPluginService.autoGet((IEntity)pSSysPFPlugin);
                this.ampssyspfplugin = pSSysPFPlugin;
            }
            return this.ampssyspfplugin;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysPFPlugin getPSSysPFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPlugin();
        }
        if (this.getPSSysPFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSSysPFPluginLock;
        synchronized (n) {
            if (this.pssyspfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysPFPluginId(), (Object)this.pssyspfplugin.getPSSysPFPluginId()) != 0L) {
                this.pssyspfplugin = null;
            }
            if (this.pssyspfplugin == null) {
                PSSysPFPlugin pSSysPFPlugin = new PSSysPFPlugin();
                pSSysPFPlugin.setPSSysPFPluginId(this.getPSSysPFPluginId());
                PSSysPFPluginService pSSysPFPluginService = (PSSysPFPluginService)ServiceGlobal.getService(PSSysPFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysPFPluginService.autoGet((IEntity)pSSysPFPlugin);
                this.pssyspfplugin = pSSysPFPlugin;
            }
            return this.pssyspfplugin;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysPortlet getPSSysPortlet() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPortlet();
        }
        if (this.getPSSysPortletId() == null) {
            return null;
        }
        Integer n = this.objPSSysPortletLock;
        synchronized (n) {
            if (this.pssysportlet != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysPortletId(), (Object)this.pssysportlet.getPSSysPortletId()) != 0L) {
                this.pssysportlet = null;
            }
            if (this.pssysportlet == null) {
                PSSysPortlet pSSysPortlet = new PSSysPortlet();
                pSSysPortlet.setPSSysPortletId(this.getPSSysPortletId());
                PSSysPortletService pSSysPortletService = (PSSysPortletService)ServiceGlobal.getService(PSSysPortletService.class, (SessionFactory)this.getSessionFactory());
                pSSysPortletService.autoGet((IEntity)pSSysPortlet);
                this.pssysportlet = pSSysPortlet;
            }
            return this.pssysportlet;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysResource getPSSysResource() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysResource();
        }
        if (this.getPSSysResourceId() == null) {
            return null;
        }
        Integer n = this.objPSSysResourceLock;
        synchronized (n) {
            if (this.pssysresource != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysResourceId(), (Object)this.pssysresource.getPSSysResourceId()) != 0L) {
                this.pssysresource = null;
            }
            if (this.pssysresource == null) {
                PSSysResource pSSysResource = new PSSysResource();
                pSSysResource.setPSSysResourceId(this.getPSSysResourceId());
                PSSysResourceService pSSysResourceService = (PSSysResourceService)ServiceGlobal.getService(PSSysResourceService.class, (SessionFactory)this.getSessionFactory());
                pSSysResourceService.autoGet((IEntity)pSSysResource);
                this.pssysresource = pSSysResource;
            }
            return this.pssysresource;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysUniRes getPSSysUniRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUniRes();
        }
        if (this.getPSSysUniResId() == null) {
            return null;
        }
        Integer n = this.objPSSysUniResLock;
        synchronized (n) {
            if (this.pssysunires != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysUniResId(), (Object)this.pssysunires.getPSSysUniResId()) != 0L) {
                this.pssysunires = null;
            }
            if (this.pssysunires == null) {
                PSSysUniRes pSSysUniRes = new PSSysUniRes();
                pSSysUniRes.setPSSysUniResId(this.getPSSysUniResId());
                PSSysUniResService pSSysUniResService = (PSSysUniResService)ServiceGlobal.getService(PSSysUniResService.class, (SessionFactory)this.getSessionFactory());
                pSSysUniResService.autoGet((IEntity)pSSysUniRes);
                this.pssysunires = pSSysUniRes;
            }
            return this.pssysunires;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSAppPVPart> getPSAppPVParts() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppPVParts();
        }
        if (this.getPSAppPVPartId() == null) {
            return null;
        }
        PSAppPVPartService pSAppPVPartService = (PSAppPVPartService)ServiceGlobal.getService(PSAppPVPartService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSAppPVPartsLock;
        synchronized (n) {
            if (this.psapppvparts == null) {
                this.psapppvparts = pSAppPVPartService.selectByPPSAppPVPart(this);
            }
            return this.psapppvparts;
        }
    }

    private PSAppPVPartBase getProxyEntity() {
        return this.proxyPSAppPVPartBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppPVPartBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppPVPartBase) {
            this.proxyPSAppPVPartBase = (PSAppPVPartBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppPVPartService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_AMPSSYSPFPLUGINID, 0);
        fieldIndexMap.put(FIELD_AMPSSYSPFPLUGINNAME, 1);
        fieldIndexMap.put(FIELD_BL_POS, 2);
        fieldIndexMap.put(FIELD_COLID, 3);
        fieldIndexMap.put(FIELD_COLSPAN, 4);
        fieldIndexMap.put(FIELD_COL_LG, 5);
        fieldIndexMap.put(FIELD_COL_LG_OS, 6);
        fieldIndexMap.put(FIELD_COL_MD, 7);
        fieldIndexMap.put(FIELD_COL_MD_OS, 8);
        fieldIndexMap.put(FIELD_COL_SM, 9);
        fieldIndexMap.put(FIELD_COL_SM_OS, 10);
        fieldIndexMap.put(FIELD_COL_XS, 11);
        fieldIndexMap.put(FIELD_COL_XS_OS, 12);
        fieldIndexMap.put(FIELD_CONTENTTYPE, 13);
        fieldIndexMap.put(FIELD_CREATEDATE, 14);
        fieldIndexMap.put(FIELD_CREATEMAN, 15);
        fieldIndexMap.put(FIELD_DYNACLASS, 16);
        fieldIndexMap.put(FIELD_ENABLEANCHOR, 17);
        fieldIndexMap.put(FIELD_ENABLECUSTOMMENU, 18);
        fieldIndexMap.put(FIELD_FLEXALIGN, 19);
        fieldIndexMap.put(FIELD_FLEXBASIS, 20);
        fieldIndexMap.put(FIELD_FLEXDIR, 21);
        fieldIndexMap.put(FIELD_FLEXGROW, 22);
        fieldIndexMap.put(FIELD_FLEXSHRINK, 23);
        fieldIndexMap.put(FIELD_FLEXVALIGN, 24);
        fieldIndexMap.put(FIELD_HALIGNSELF, 25);
        fieldIndexMap.put(FIELD_HEIGHT, 26);
        fieldIndexMap.put(FIELD_HTMLCONTENT, 27);
        fieldIndexMap.put(FIELD_LAYOUTMODE, 28);
        fieldIndexMap.put(FIELD_MEMO, 29);
        fieldIndexMap.put(FIELD_MENUPSAPPUTILVIEWID, 30);
        fieldIndexMap.put(FIELD_MENUPSAPPUTILVIEWNAME, 31);
        fieldIndexMap.put(FIELD_MOBAMSTYLE, 32);
        fieldIndexMap.put(FIELD_NEWROWMODE, 33);
        fieldIndexMap.put(FIELD_ORDERVALUE, 34);
        fieldIndexMap.put(FIELD_PARTPARAMS, 35);
        fieldIndexMap.put(FIELD_PARTSTYLE, 36);
        fieldIndexMap.put(FIELD_PORTLETTYPE, 37);
        fieldIndexMap.put(FIELD_POSINFO, 38);
        fieldIndexMap.put(FIELD_PPSAPPPVPARTID, 39);
        fieldIndexMap.put(FIELD_PPSAPPPVPARTNAME, 40);
        fieldIndexMap.put(FIELD_PSAPPMENUID, 41);
        fieldIndexMap.put(FIELD_PSAPPMENUNAME, 42);
        fieldIndexMap.put(FIELD_PSAPPPORTALVIEWID, 43);
        fieldIndexMap.put(FIELD_PSAPPPORTALVIEWNAME, 44);
        fieldIndexMap.put(FIELD_PSAPPPVPARTID, 45);
        fieldIndexMap.put(FIELD_PSAPPPVPARTNAME, 46);
        fieldIndexMap.put(FIELD_PSAPPVIEWID, 47);
        fieldIndexMap.put(FIELD_PSAPPVIEWNAME, 48);
        fieldIndexMap.put(FIELD_PSSYSCSSID, 49);
        fieldIndexMap.put(FIELD_PSSYSCSSNAME, 50);
        fieldIndexMap.put(FIELD_PSSYSIMAGEID, 51);
        fieldIndexMap.put(FIELD_PSSYSIMAGENAME, 52);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 53);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 54);
        fieldIndexMap.put(FIELD_PSSYSPORTLETID, 55);
        fieldIndexMap.put(FIELD_PSSYSPORTLETNAME, 56);
        fieldIndexMap.put(FIELD_PSSYSRESOURCEID, 57);
        fieldIndexMap.put(FIELD_PSSYSRESOURCENAME, 58);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 59);
        fieldIndexMap.put(FIELD_PSSYSUNIRESID, 60);
        fieldIndexMap.put(FIELD_PSSYSUNIRESNAME, 61);
        fieldIndexMap.put(FIELD_PVPARTTYPE, 62);
        fieldIndexMap.put(FIELD_RAWCONTENT, 63);
        fieldIndexMap.put(FIELD_RAWCSSSTYLE, 64);
        fieldIndexMap.put(FIELD_SHOWTITLEBAR, 65);
        fieldIndexMap.put(FIELD_SWAPMODE, 66);
        fieldIndexMap.put(FIELD_TEMPLATEMODE, 67);
        fieldIndexMap.put(FIELD_TITLE, 68);
        fieldIndexMap.put(FIELD_TITLEBARCLOSEMODE, 69);
        fieldIndexMap.put(FIELD_TITLEPSLANRESID, 70);
        fieldIndexMap.put(FIELD_TITLEPSLANRESNAME, 71);
        fieldIndexMap.put(FIELD_TOOLTIPINFO, 72);
        fieldIndexMap.put(FIELD_UPDATEDATE, 73);
        fieldIndexMap.put(FIELD_UPDATEMAN, 74);
        fieldIndexMap.put(FIELD_USERTAG, 75);
        fieldIndexMap.put(FIELD_USERTAG2, 76);
        fieldIndexMap.put(FIELD_VALIDFLAG, 77);
        fieldIndexMap.put(FIELD_VALIGNSELF, 78);
        fieldIndexMap.put(FIELD_WIDTH, 79);
    }
}

