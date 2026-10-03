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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppFunc;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLocalDE;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenu;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenuItem;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.service.PSAppFuncService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLocalDEService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuItemService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewService;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysResource;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.config.service.PSSysResourceService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniRes;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppMenuItemBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppMenuItemBase.class);
    public static final String FIELD_ACTIONLEVEL = "ACTIONLEVEL";
    public static final String FIELD_AMITEMTYPE = "AMITEMTYPE";
    public static final String FIELD_BL_POS = "BL_POS";
    public static final String FIELD_BORDERSTYLE = "BORDERSTYLE";
    public static final String FIELD_BTNACTIONTYPE = "BTNACTIONTYPE";
    public static final String FIELD_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String FIELD_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String FIELD_CAPTION = "CAPTION";
    public static final String FIELD_COL_LG = "COL_LG";
    public static final String FIELD_COL_LG_OS = "COL_LG_OS";
    public static final String FIELD_COL_MD = "COL_MD";
    public static final String FIELD_COL_MD_OS = "COL_MD_OS";
    public static final String FIELD_COL_SM = "COL_SM";
    public static final String FIELD_COL_SM_OS = "COL_SM_OS";
    public static final String FIELD_COL_XS = "COL_XS";
    public static final String FIELD_COL_XS_OS = "COL_XS_OS";
    public static final String FIELD_CONTENTTYPE = "CONTENTTYPE";
    public static final String FIELD_COUNTERID = "COUNTERID";
    public static final String FIELD_COUNTERMODE = "COUNTERMODE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CSSID = "CSSID";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_DATA = "DATA";
    public static final String FIELD_DISABLECLOSE = "DISABLECLOSE";
    public static final String FIELD_DYNACLASS = "DYNACLASS";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_ENABLEMODE = "ENABLEMODE";
    public static final String FIELD_EXPAND = "EXPAND";
    public static final String FIELD_FILLEROBJ = "FILLEROBJ";
    public static final String FIELD_FLEXALIGN = "FLEXALIGN";
    public static final String FIELD_FLEXBASIS = "FLEXBASIS";
    public static final String FIELD_FLEXDIR = "FLEXDIR";
    public static final String FIELD_FLEXGROW = "FLEXGROW";
    public static final String FIELD_FLEXSHRINK = "FLEXSHRINK";
    public static final String FIELD_FLEXVALIGN = "FLEXVALIGN";
    public static final String FIELD_HALIGNSELF = "HALIGNSELF";
    public static final String FIELD_HEIGHT = "HEIGHT";
    public static final String FIELD_HIDDENITEM = "HIDDENITEM";
    public static final String FIELD_HIDESIDEBAR = "HIDESIDEBAR";
    public static final String FIELD_HTMLCONTENT = "HTMLCONTENT";
    public static final String FIELD_HTMLPAGEURL = "HTMLPAGEURL";
    public static final String FIELD_INFORMTAG = "INFORMTAG";
    public static final String FIELD_INFORMTAG2 = "INFORMTAG2";
    public static final String FIELD_ITEMSTYLE = "ITEMSTYLE";
    public static final String FIELD_ITEMSTYLETEXT = "ITEMSTYLETEXT";
    public static final String FIELD_LAYOUTMODE = "LAYOUTMODE";
    public static final String FIELD_LEVELTAG = "LEVELTAG";
    public static final String FIELD_LEVELVALUE = "LEVELVALUE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MENUITEMSTATE = "MENUITEMSTATE";
    public static final String FIELD_OPENDEFAULT = "OPENDEFAULT";
    public static final String FIELD_OPENPSAPPVIEWID = "OPENPSAPPVIEWID";
    public static final String FIELD_OPENPSAPPVIEWNAME = "OPENPSAPPVIEWNAME";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PPSAPPMENUITEMID = "PPSAPPMENUITEMID";
    public static final String FIELD_PPSAPPMENUITEMNAME = "PPSAPPMENUITEMNAME";
    public static final String FIELD_PREDEFINEDTYPE = "PREDEFINEDTYPE";
    public static final String FIELD_PREDEFINEDTYPEPARAM = "PREDEFINEDTYPEPARAM";
    public static final String FIELD_PREDEFINEDTYPETEXT = "PREDEFINEDTYPETEXT";
    public static final String FIELD_PREVIEWHTML = "PREVIEWHTML";
    public static final String FIELD_PSAPPFUNCID = "PSAPPFUNCID";
    public static final String FIELD_PSAPPFUNCNAME = "PSAPPFUNCNAME";
    public static final String FIELD_PSAPPLOCALDEID = "PSAPPLOCALDEID";
    public static final String FIELD_PSAPPLOCALDENAME = "PSAPPLOCALDENAME";
    public static final String FIELD_PSAPPMENUID = "PSAPPMENUID";
    public static final String FIELD_PSAPPMENUITEMID = "PSAPPMENUITEMID";
    public static final String FIELD_PSAPPMENUITEMNAME = "PSAPPMENUITEMNAME";
    public static final String FIELD_PSAPPMENUNAME = "PSAPPMENUNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDELOGICID = "PSDELOGICID";
    public static final String FIELD_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String FIELD_PSDEUIACTIONID = "PSDEUIACTIONID";
    public static final String FIELD_PSDEUIACTIONNAME = "PSDEUIACTIONNAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSCSSID = "PSSYSCSSID";
    public static final String FIELD_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String FIELD_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String FIELD_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSRESOURCEID = "PSSYSRESOURCEID";
    public static final String FIELD_PSSYSRESOURCENAME = "PSSYSRESOURCENAME";
    public static final String FIELD_PSSYSUNIRESID = "PSSYSUNIRESID";
    public static final String FIELD_PSSYSUNIRESNAME = "PSSYSUNIRESNAME";
    public static final String FIELD_RAWCONTENT = "RAWCONTENT";
    public static final String FIELD_RAWCSSSTYLE = "RAWCSSSTYLE";
    public static final String FIELD_REFPSAPPMENUID = "REFPSAPPMENUID";
    public static final String FIELD_REFPSAPPMENUNAME = "REFPSAPPMENUNAME";
    public static final String FIELD_SPANFLAG = "SPANFLAG";
    public static final String FIELD_TEMPLATEMODE = "TEMPLATEMODE";
    public static final String FIELD_TIPPSLANRESID = "TIPPSLANRESID";
    public static final String FIELD_TIPPSLANRESNAME = "TIPPSLANRESNAME";
    public static final String FIELD_TITLEBARCLOSEMODE = "TITLEBARCLOSEMODE";
    public static final String FIELD_TOGGLEMODE = "TOGGLEMODE";
    public static final String FIELD_TOOLTIPINFO = "TOOLTIPINFO";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_VALIGNSELF = "VALIGNSELF";
    public static final String FIELD_WIDTH = "WIDTH";
    private static final int INDEX_ACTIONLEVEL = 0;
    private static final int INDEX_AMITEMTYPE = 1;
    private static final int INDEX_BL_POS = 2;
    private static final int INDEX_BORDERSTYLE = 3;
    private static final int INDEX_BTNACTIONTYPE = 4;
    private static final int INDEX_CAPPSLANRESID = 5;
    private static final int INDEX_CAPPSLANRESNAME = 6;
    private static final int INDEX_CAPTION = 7;
    private static final int INDEX_COL_LG = 8;
    private static final int INDEX_COL_LG_OS = 9;
    private static final int INDEX_COL_MD = 10;
    private static final int INDEX_COL_MD_OS = 11;
    private static final int INDEX_COL_SM = 12;
    private static final int INDEX_COL_SM_OS = 13;
    private static final int INDEX_COL_XS = 14;
    private static final int INDEX_COL_XS_OS = 15;
    private static final int INDEX_CONTENTTYPE = 16;
    private static final int INDEX_COUNTERID = 17;
    private static final int INDEX_COUNTERMODE = 18;
    private static final int INDEX_CREATEDATE = 19;
    private static final int INDEX_CREATEMAN = 20;
    private static final int INDEX_CSSID = 21;
    private static final int INDEX_CUSTOMCODE = 22;
    private static final int INDEX_DATA = 23;
    private static final int INDEX_DISABLECLOSE = 24;
    private static final int INDEX_DYNACLASS = 25;
    private static final int INDEX_DYNAMODELFLAG = 26;
    private static final int INDEX_ENABLEMODE = 27;
    private static final int INDEX_EXPAND = 28;
    private static final int INDEX_FILLEROBJ = 29;
    private static final int INDEX_FLEXALIGN = 30;
    private static final int INDEX_FLEXBASIS = 31;
    private static final int INDEX_FLEXDIR = 32;
    private static final int INDEX_FLEXGROW = 33;
    private static final int INDEX_FLEXSHRINK = 34;
    private static final int INDEX_FLEXVALIGN = 35;
    private static final int INDEX_HALIGNSELF = 36;
    private static final int INDEX_HEIGHT = 37;
    private static final int INDEX_HIDDENITEM = 38;
    private static final int INDEX_HIDESIDEBAR = 39;
    private static final int INDEX_HTMLCONTENT = 40;
    private static final int INDEX_HTMLPAGEURL = 41;
    private static final int INDEX_INFORMTAG = 42;
    private static final int INDEX_INFORMTAG2 = 43;
    private static final int INDEX_ITEMSTYLE = 44;
    private static final int INDEX_ITEMSTYLETEXT = 45;
    private static final int INDEX_LAYOUTMODE = 46;
    private static final int INDEX_LEVELTAG = 47;
    private static final int INDEX_LEVELVALUE = 48;
    private static final int INDEX_MEMO = 49;
    private static final int INDEX_MENUITEMSTATE = 50;
    private static final int INDEX_OPENDEFAULT = 51;
    private static final int INDEX_OPENPSAPPVIEWID = 52;
    private static final int INDEX_OPENPSAPPVIEWNAME = 53;
    private static final int INDEX_ORDERVALUE = 54;
    private static final int INDEX_PPSAPPMENUITEMID = 55;
    private static final int INDEX_PPSAPPMENUITEMNAME = 56;
    private static final int INDEX_PREDEFINEDTYPE = 57;
    private static final int INDEX_PREDEFINEDTYPEPARAM = 58;
    private static final int INDEX_PREDEFINEDTYPETEXT = 59;
    private static final int INDEX_PREVIEWHTML = 60;
    private static final int INDEX_PSAPPFUNCID = 61;
    private static final int INDEX_PSAPPFUNCNAME = 62;
    private static final int INDEX_PSAPPLOCALDEID = 63;
    private static final int INDEX_PSAPPLOCALDENAME = 64;
    private static final int INDEX_PSAPPMENUID = 65;
    private static final int INDEX_PSAPPMENUITEMID = 66;
    private static final int INDEX_PSAPPMENUITEMNAME = 67;
    private static final int INDEX_PSAPPMENUNAME = 68;
    private static final int INDEX_PSDEID = 69;
    private static final int INDEX_PSDELOGICID = 70;
    private static final int INDEX_PSDELOGICNAME = 71;
    private static final int INDEX_PSDEUIACTIONID = 72;
    private static final int INDEX_PSDEUIACTIONNAME = 73;
    private static final int INDEX_PSSYSAPPID = 74;
    private static final int INDEX_PSSYSCSSID = 75;
    private static final int INDEX_PSSYSCSSNAME = 76;
    private static final int INDEX_PSSYSIMAGEID = 77;
    private static final int INDEX_PSSYSIMAGENAME = 78;
    private static final int INDEX_PSSYSPFPLUGINID = 79;
    private static final int INDEX_PSSYSPFPLUGINNAME = 80;
    private static final int INDEX_PSSYSRESOURCEID = 81;
    private static final int INDEX_PSSYSRESOURCENAME = 82;
    private static final int INDEX_PSSYSUNIRESID = 83;
    private static final int INDEX_PSSYSUNIRESNAME = 84;
    private static final int INDEX_RAWCONTENT = 85;
    private static final int INDEX_RAWCSSSTYLE = 86;
    private static final int INDEX_REFPSAPPMENUID = 87;
    private static final int INDEX_REFPSAPPMENUNAME = 88;
    private static final int INDEX_SPANFLAG = 89;
    private static final int INDEX_TEMPLATEMODE = 90;
    private static final int INDEX_TIPPSLANRESID = 91;
    private static final int INDEX_TIPPSLANRESNAME = 92;
    private static final int INDEX_TITLEBARCLOSEMODE = 93;
    private static final int INDEX_TOGGLEMODE = 94;
    private static final int INDEX_TOOLTIPINFO = 95;
    private static final int INDEX_UPDATEDATE = 96;
    private static final int INDEX_UPDATEMAN = 97;
    private static final int INDEX_USERPARAMS = 98;
    private static final int INDEX_USERTAG = 99;
    private static final int INDEX_USERTAG2 = 100;
    private static final int INDEX_VALIGNSELF = 101;
    private static final int INDEX_WIDTH = 102;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppMenuItemBase proxyPSAppMenuItemBase = null;
    private boolean actionlevelDirtyFlag = false;
    private boolean amitemtypeDirtyFlag = false;
    private boolean bl_posDirtyFlag = false;
    private boolean borderstyleDirtyFlag = false;
    private boolean btnactiontypeDirtyFlag = false;
    private boolean cappslanresidDirtyFlag = false;
    private boolean cappslanresnameDirtyFlag = false;
    private boolean captionDirtyFlag = false;
    private boolean col_lgDirtyFlag = false;
    private boolean col_lg_osDirtyFlag = false;
    private boolean col_mdDirtyFlag = false;
    private boolean col_md_osDirtyFlag = false;
    private boolean col_smDirtyFlag = false;
    private boolean col_sm_osDirtyFlag = false;
    private boolean col_xsDirtyFlag = false;
    private boolean col_xs_osDirtyFlag = false;
    private boolean contenttypeDirtyFlag = false;
    private boolean counteridDirtyFlag = false;
    private boolean countermodeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean cssidDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean dataDirtyFlag = false;
    private boolean disablecloseDirtyFlag = false;
    private boolean dynaclassDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean enablemodeDirtyFlag = false;
    private boolean expandDirtyFlag = false;
    private boolean fillerobjDirtyFlag = false;
    private boolean flexalignDirtyFlag = false;
    private boolean flexbasisDirtyFlag = false;
    private boolean flexdirDirtyFlag = false;
    private boolean flexgrowDirtyFlag = false;
    private boolean flexshrinkDirtyFlag = false;
    private boolean flexvalignDirtyFlag = false;
    private boolean halignselfDirtyFlag = false;
    private boolean heightDirtyFlag = false;
    private boolean hiddenitemDirtyFlag = false;
    private boolean hidesidebarDirtyFlag = false;
    private boolean htmlcontentDirtyFlag = false;
    private boolean htmlpageurlDirtyFlag = false;
    private boolean informtagDirtyFlag = false;
    private boolean informtag2DirtyFlag = false;
    private boolean itemstyleDirtyFlag = false;
    private boolean itemstyletextDirtyFlag = false;
    private boolean layoutmodeDirtyFlag = false;
    private boolean leveltagDirtyFlag = false;
    private boolean levelvalueDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean menuitemstateDirtyFlag = false;
    private boolean opendefaultDirtyFlag = false;
    private boolean openpsappviewidDirtyFlag = false;
    private boolean openpsappviewnameDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean ppsappmenuitemidDirtyFlag = false;
    private boolean ppsappmenuitemnameDirtyFlag = false;
    private boolean predefinedtypeDirtyFlag = false;
    private boolean predefinedtypeparamDirtyFlag = false;
    private boolean predefinedtypetextDirtyFlag = false;
    private boolean previewhtmlDirtyFlag = false;
    private boolean psappfuncidDirtyFlag = false;
    private boolean psappfuncnameDirtyFlag = false;
    private boolean psapplocaldeidDirtyFlag = false;
    private boolean psapplocaldenameDirtyFlag = false;
    private boolean psappmenuidDirtyFlag = false;
    private boolean psappmenuitemidDirtyFlag = false;
    private boolean psappmenuitemnameDirtyFlag = false;
    private boolean psappmenunameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdelogicidDirtyFlag = false;
    private boolean psdelogicnameDirtyFlag = false;
    private boolean psdeuiactionidDirtyFlag = false;
    private boolean psdeuiactionnameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssyscssidDirtyFlag = false;
    private boolean pssyscssnameDirtyFlag = false;
    private boolean pssysimageidDirtyFlag = false;
    private boolean pssysimagenameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssysresourceidDirtyFlag = false;
    private boolean pssysresourcenameDirtyFlag = false;
    private boolean pssysuniresidDirtyFlag = false;
    private boolean pssysuniresnameDirtyFlag = false;
    private boolean rawcontentDirtyFlag = false;
    private boolean rawcssstyleDirtyFlag = false;
    private boolean refpsappmenuidDirtyFlag = false;
    private boolean refpsappmenunameDirtyFlag = false;
    private boolean spanflagDirtyFlag = false;
    private boolean templatemodeDirtyFlag = false;
    private boolean tippslanresidDirtyFlag = false;
    private boolean tippslanresnameDirtyFlag = false;
    private boolean titlebarclosemodeDirtyFlag = false;
    private boolean togglemodeDirtyFlag = false;
    private boolean tooltipinfoDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean valignselfDirtyFlag = false;
    private boolean widthDirtyFlag = false;
    @Column(name="actionlevel")
    private Integer actionlevel;
    @Column(name="amitemtype")
    private String amitemtype;
    @Column(name="bl_pos")
    private String bl_pos;
    @Column(name="borderstyle")
    private String borderstyle;
    @Column(name="btnactiontype")
    private String btnactiontype;
    @Column(name="cappslanresid")
    private String cappslanresid;
    @Column(name="cappslanresname")
    private String cappslanresname;
    @Column(name="caption")
    private String caption;
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
    @Column(name="counterid")
    private String counterid;
    @Column(name="countermode")
    private Integer countermode;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="cssid")
    private String cssid;
    @Column(name="customcode")
    private String customcode;
    @Column(name="data")
    private String data;
    @Column(name="disableclose")
    private Integer disableclose;
    @Column(name="dynaclass")
    private String dynaclass;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="enablemode")
    private Integer enablemode;
    @Column(name="expand")
    private Integer expand;
    @Column(name="fillerobj")
    private String fillerobj;
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
    @Column(name="hiddenitem")
    private Integer hiddenitem;
    @Column(name="hidesidebar")
    private Integer hidesidebar;
    @Column(name="htmlcontent")
    private String htmlcontent;
    @Column(name="htmlpageurl")
    private String htmlpageurl;
    @Column(name="informtag")
    private String informtag;
    @Column(name="informtag2")
    private String informtag2;
    @Column(name="itemstyle")
    private String itemstyle;
    @Column(name="itemstyletext")
    private String itemstyletext;
    @Column(name="layoutmode")
    private String layoutmode;
    @Column(name="leveltag")
    private String leveltag;
    @Column(name="levelvalue")
    private Integer levelvalue;
    @Column(name="memo")
    private String memo;
    @Column(name="menuitemstate")
    private Integer menuitemstate;
    @Column(name="opendefault")
    private Integer opendefault;
    @Column(name="openpsappviewid")
    private String openpsappviewid;
    @Column(name="openpsappviewname")
    private String openpsappviewname;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="ppsappmenuitemid")
    private String ppsappmenuitemid;
    @Column(name="ppsappmenuitemname")
    private String ppsappmenuitemname;
    @Column(name="predefinedtype")
    private String predefinedtype;
    @Column(name="predefinedtypeparam")
    private String predefinedtypeparam;
    @Column(name="predefinedtypetext")
    private String predefinedtypetext;
    @Column(name="previewhtml")
    private String previewhtml;
    @Column(name="psappfuncid")
    private String psappfuncid;
    @Column(name="psappfuncname")
    private String psappfuncname;
    @Column(name="psapplocaldeid")
    private String psapplocaldeid;
    @Column(name="psapplocaldename")
    private String psapplocaldename;
    @Column(name="psappmenuid")
    private String psappmenuid;
    @Column(name="psappmenuitemid")
    private String psappmenuitemid;
    @Column(name="psappmenuitemname")
    private String psappmenuitemname;
    @Column(name="psappmenuname")
    private String psappmenuname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdelogicid")
    private String psdelogicid;
    @Column(name="psdelogicname")
    private String psdelogicname;
    @Column(name="psdeuiactionid")
    private String psdeuiactionid;
    @Column(name="psdeuiactionname")
    private String psdeuiactionname;
    @Column(name="pssysappid")
    private String pssysappid;
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
    @Column(name="pssysresourceid")
    private String pssysresourceid;
    @Column(name="pssysresourcename")
    private String pssysresourcename;
    @Column(name="pssysuniresid")
    private String pssysuniresid;
    @Column(name="pssysuniresname")
    private String pssysuniresname;
    @Column(name="rawcontent")
    private String rawcontent;
    @Column(name="rawcssstyle")
    private String rawcssstyle;
    @Column(name="refpsappmenuid")
    private String refpsappmenuid;
    @Column(name="refpsappmenuname")
    private String refpsappmenuname;
    @Column(name="spanflag")
    private Integer spanflag;
    @Column(name="templatemode")
    private Integer templatemode;
    @Column(name="tippslanresid")
    private String tippslanresid;
    @Column(name="tippslanresname")
    private String tippslanresname;
    @Column(name="titlebarclosemode")
    private Integer titlebarclosemode;
    @Column(name="togglemode")
    private String togglemode;
    @Column(name="tooltipinfo")
    private String tooltipinfo;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userparams")
    private String userparams;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="valignself")
    private String valignself;
    @Column(name="width")
    private Integer width;
    private Integer objPSAppFuncLock = new Integer(1);
    private PSAppFunc psappfunc = null;
    private Integer objPSAppLocalDELock = new Integer(1);
    private PSAppLocalDE psapplocalde = null;
    private Integer objPPSAppMenuItemLock = new Integer(1);
    private PSAppMenuItem ppsappmenuitem = null;
    private Integer objPSAppMenuLock = new Integer(1);
    private PSAppMenu psappmenu = null;
    private Integer objRefPSAppMenuLock = new Integer(1);
    private PSAppMenu refpsappmenu = null;
    private Integer objOpenPSAppViewLock = new Integer(1);
    private PSAppView openpsappview = null;
    private Integer objPSDELogicLock = new Integer(1);
    private PSDELogic psdelogic = null;
    private Integer objPSDEUIActionLock = new Integer(1);
    private PSDEUIAction psdeuiaction = null;
    private Integer objCapPSLanResLock = new Integer(1);
    private PSLanguageRes cappslanres = null;
    private Integer objTipPSLanResLock = new Integer(1);
    private PSLanguageRes tippslanres = null;
    private Integer objPSSysCssLock = new Integer(1);
    private PSSysCss pssyscss = null;
    private Integer objPSSysImageLock = new Integer(1);
    private PSSysImage pssysimage = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSSysResourceLock = new Integer(1);
    private PSSysResource pssysresource = null;
    private Integer objPSSysUniResLock = new Integer(1);
    private PSSysUniRes pssysunires = null;
    private Integer objPSAppMenuItemsLock = new Integer(1);
    private ArrayList<PSAppMenuItem> psappmenuitems = null;

    public void setActionLevel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionLevel(n);
            return;
        }
        this.actionlevel = n;
        this.actionlevelDirtyFlag = true;
    }

    public Integer getActionLevel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionLevel();
        }
        return this.actionlevel;
    }

    public boolean isActionLevelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionLevelDirty();
        }
        return this.actionlevelDirtyFlag;
    }

    public void resetActionLevel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionLevel();
            return;
        }
        this.actionlevelDirtyFlag = false;
        this.actionlevel = null;
    }

    public void setAMItemType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAMItemType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.amitemtype = string;
        this.amitemtypeDirtyFlag = true;
    }

    public String getAMItemType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAMItemType();
        }
        return this.amitemtype;
    }

    public boolean isAMItemTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAMItemTypeDirty();
        }
        return this.amitemtypeDirtyFlag;
    }

    public void resetAMItemType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAMItemType();
            return;
        }
        this.amitemtypeDirtyFlag = false;
        this.amitemtype = null;
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

    public void setBorderStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBorderStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.borderstyle = string;
        this.borderstyleDirtyFlag = true;
    }

    public String getBorderStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBorderStyle();
        }
        return this.borderstyle;
    }

    public boolean isBorderStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBorderStyleDirty();
        }
        return this.borderstyleDirtyFlag;
    }

    public void resetBorderStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBorderStyle();
            return;
        }
        this.borderstyleDirtyFlag = false;
        this.borderstyle = null;
    }

    public void setBtnActionType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBtnActionType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.btnactiontype = string;
        this.btnactiontypeDirtyFlag = true;
    }

    public String getBtnActionType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBtnActionType();
        }
        return this.btnactiontype;
    }

    public boolean isBtnActionTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBtnActionTypeDirty();
        }
        return this.btnactiontypeDirtyFlag;
    }

    public void resetBtnActionType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBtnActionType();
            return;
        }
        this.btnactiontypeDirtyFlag = false;
        this.btnactiontype = null;
    }

    public void setCapPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCapPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cappslanresid = string;
        this.cappslanresidDirtyFlag = true;
    }

    public String getCapPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCapPSLanResId();
        }
        return this.cappslanresid;
    }

    public boolean isCapPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCapPSLanResIdDirty();
        }
        return this.cappslanresidDirtyFlag;
    }

    public void resetCapPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCapPSLanResId();
            return;
        }
        this.cappslanresidDirtyFlag = false;
        this.cappslanresid = null;
    }

    public void setCapPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCapPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cappslanresname = string;
        this.cappslanresnameDirtyFlag = true;
    }

    public String getCapPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCapPSLanResName();
        }
        return this.cappslanresname;
    }

    public boolean isCapPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCapPSLanResNameDirty();
        }
        return this.cappslanresnameDirtyFlag;
    }

    public void resetCapPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCapPSLanResName();
            return;
        }
        this.cappslanresnameDirtyFlag = false;
        this.cappslanresname = null;
    }

    public void setCaption(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCaption(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.caption = string;
        this.captionDirtyFlag = true;
    }

    public String getCaption() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCaption();
        }
        return this.caption;
    }

    public boolean isCaptionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCaptionDirty();
        }
        return this.captionDirtyFlag;
    }

    public void resetCaption() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCaption();
            return;
        }
        this.captionDirtyFlag = false;
        this.caption = null;
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

    public void setCounterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCounterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.counterid = string;
        this.counteridDirtyFlag = true;
    }

    public String getCounterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCounterId();
        }
        return this.counterid;
    }

    public boolean isCounterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCounterIdDirty();
        }
        return this.counteridDirtyFlag;
    }

    public void resetCounterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCounterId();
            return;
        }
        this.counteridDirtyFlag = false;
        this.counterid = null;
    }

    public void setCounterMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCounterMode(n);
            return;
        }
        this.countermode = n;
        this.countermodeDirtyFlag = true;
    }

    public Integer getCounterMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCounterMode();
        }
        return this.countermode;
    }

    public boolean isCounterModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCounterModeDirty();
        }
        return this.countermodeDirtyFlag;
    }

    public void resetCounterMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCounterMode();
            return;
        }
        this.countermodeDirtyFlag = false;
        this.countermode = null;
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

    public void setCssId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCssId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cssid = string;
        this.cssidDirtyFlag = true;
    }

    public String getCssId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCssId();
        }
        return this.cssid;
    }

    public boolean isCssIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCssIdDirty();
        }
        return this.cssidDirtyFlag;
    }

    public void resetCssId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCssId();
            return;
        }
        this.cssidDirtyFlag = false;
        this.cssid = null;
    }

    public void setCustomCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customcode = string;
        this.customcodeDirtyFlag = true;
    }

    public String getCustomCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomCode();
        }
        return this.customcode;
    }

    public boolean isCustomCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomCodeDirty();
        }
        return this.customcodeDirtyFlag;
    }

    public void resetCustomCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomCode();
            return;
        }
        this.customcodeDirtyFlag = false;
        this.customcode = null;
    }

    public void setData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.data = string;
        this.dataDirtyFlag = true;
    }

    public String getData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getData();
        }
        return this.data;
    }

    public boolean isDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataDirty();
        }
        return this.dataDirtyFlag;
    }

    public void resetData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetData();
            return;
        }
        this.dataDirtyFlag = false;
        this.data = null;
    }

    public void setDisableClose(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDisableClose(n);
            return;
        }
        this.disableclose = n;
        this.disablecloseDirtyFlag = true;
    }

    public Integer getDisableClose() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDisableClose();
        }
        return this.disableclose;
    }

    public boolean isDisableCloseDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDisableCloseDirty();
        }
        return this.disablecloseDirtyFlag;
    }

    public void resetDisableClose() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDisableClose();
            return;
        }
        this.disablecloseDirtyFlag = false;
        this.disableclose = null;
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

    public void setDynaModelFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaModelFlag(n);
            return;
        }
        this.dynamodelflag = n;
        this.dynamodelflagDirtyFlag = true;
    }

    public Integer getDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaModelFlag();
        }
        return this.dynamodelflag;
    }

    public boolean isDynaModelFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaModelFlagDirty();
        }
        return this.dynamodelflagDirtyFlag;
    }

    public void resetDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaModelFlag();
            return;
        }
        this.dynamodelflagDirtyFlag = false;
        this.dynamodelflag = null;
    }

    public void setEnableMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableMode(n);
            return;
        }
        this.enablemode = n;
        this.enablemodeDirtyFlag = true;
    }

    public Integer getEnableMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableMode();
        }
        return this.enablemode;
    }

    public boolean isEnableModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableModeDirty();
        }
        return this.enablemodeDirtyFlag;
    }

    public void resetEnableMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableMode();
            return;
        }
        this.enablemodeDirtyFlag = false;
        this.enablemode = null;
    }

    public void setExpand(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExpand(n);
            return;
        }
        this.expand = n;
        this.expandDirtyFlag = true;
    }

    public Integer getExpand() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExpand();
        }
        return this.expand;
    }

    public boolean isExpandDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExpandDirty();
        }
        return this.expandDirtyFlag;
    }

    public void resetExpand() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExpand();
            return;
        }
        this.expandDirtyFlag = false;
        this.expand = null;
    }

    public void setFillerObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFillerObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fillerobj = string;
        this.fillerobjDirtyFlag = true;
    }

    public String getFillerObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFillerObj();
        }
        return this.fillerobj;
    }

    public boolean isFillerObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFillerObjDirty();
        }
        return this.fillerobjDirtyFlag;
    }

    public void resetFillerObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFillerObj();
            return;
        }
        this.fillerobjDirtyFlag = false;
        this.fillerobj = null;
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

    public void setHiddenItem(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHiddenItem(n);
            return;
        }
        this.hiddenitem = n;
        this.hiddenitemDirtyFlag = true;
    }

    public Integer getHiddenItem() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHiddenItem();
        }
        return this.hiddenitem;
    }

    public boolean isHiddenItemDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHiddenItemDirty();
        }
        return this.hiddenitemDirtyFlag;
    }

    public void resetHiddenItem() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHiddenItem();
            return;
        }
        this.hiddenitemDirtyFlag = false;
        this.hiddenitem = null;
    }

    public void setHIdeSideBar(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHIdeSideBar(n);
            return;
        }
        this.hidesidebar = n;
        this.hidesidebarDirtyFlag = true;
    }

    public Integer getHIdeSideBar() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHIdeSideBar();
        }
        return this.hidesidebar;
    }

    public boolean isHIdeSideBarDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHIdeSideBarDirty();
        }
        return this.hidesidebarDirtyFlag;
    }

    public void resetHIdeSideBar() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHIdeSideBar();
            return;
        }
        this.hidesidebarDirtyFlag = false;
        this.hidesidebar = null;
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

    public void setHtmlPageUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHtmlPageUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.htmlpageurl = string;
        this.htmlpageurlDirtyFlag = true;
    }

    public String getHtmlPageUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHtmlPageUrl();
        }
        return this.htmlpageurl;
    }

    public boolean isHtmlPageUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHtmlPageUrlDirty();
        }
        return this.htmlpageurlDirtyFlag;
    }

    public void resetHtmlPageUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHtmlPageUrl();
            return;
        }
        this.htmlpageurlDirtyFlag = false;
        this.htmlpageurl = null;
    }

    public void setInformTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInformTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.informtag = string;
        this.informtagDirtyFlag = true;
    }

    public String getInformTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInformTag();
        }
        return this.informtag;
    }

    public boolean isInformTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInformTagDirty();
        }
        return this.informtagDirtyFlag;
    }

    public void resetInformTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInformTag();
            return;
        }
        this.informtagDirtyFlag = false;
        this.informtag = null;
    }

    public void setInformTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInformTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.informtag2 = string;
        this.informtag2DirtyFlag = true;
    }

    public String getInformTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInformTag2();
        }
        return this.informtag2;
    }

    public boolean isInformTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInformTag2Dirty();
        }
        return this.informtag2DirtyFlag;
    }

    public void resetInformTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInformTag2();
            return;
        }
        this.informtag2DirtyFlag = false;
        this.informtag2 = null;
    }

    public void setItemStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemstyle = string;
        this.itemstyleDirtyFlag = true;
    }

    public String getItemStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemStyle();
        }
        return this.itemstyle;
    }

    public boolean isItemStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemStyleDirty();
        }
        return this.itemstyleDirtyFlag;
    }

    public void resetItemStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemStyle();
            return;
        }
        this.itemstyleDirtyFlag = false;
        this.itemstyle = null;
    }

    public void setItemStyleText(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemStyleText(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemstyletext = string;
        this.itemstyletextDirtyFlag = true;
    }

    public String getItemStyleText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemStyleText();
        }
        return this.itemstyletext;
    }

    public boolean isItemStyleTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemStyleTextDirty();
        }
        return this.itemstyletextDirtyFlag;
    }

    public void resetItemStyleText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemStyleText();
            return;
        }
        this.itemstyletextDirtyFlag = false;
        this.itemstyletext = null;
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

    public void setLevelTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLevelTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.leveltag = string;
        this.leveltagDirtyFlag = true;
    }

    public String getLevelTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLevelTag();
        }
        return this.leveltag;
    }

    public boolean isLevelTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLevelTagDirty();
        }
        return this.leveltagDirtyFlag;
    }

    public void resetLevelTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLevelTag();
            return;
        }
        this.leveltagDirtyFlag = false;
        this.leveltag = null;
    }

    public void setLevelValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLevelValue(n);
            return;
        }
        this.levelvalue = n;
        this.levelvalueDirtyFlag = true;
    }

    public Integer getLevelValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLevelValue();
        }
        return this.levelvalue;
    }

    public boolean isLevelValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLevelValueDirty();
        }
        return this.levelvalueDirtyFlag;
    }

    public void resetLevelValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLevelValue();
            return;
        }
        this.levelvalueDirtyFlag = false;
        this.levelvalue = null;
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

    public void setMenuItemState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMenuItemState(n);
            return;
        }
        this.menuitemstate = n;
        this.menuitemstateDirtyFlag = true;
    }

    public Integer getMenuItemState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMenuItemState();
        }
        return this.menuitemstate;
    }

    public boolean isMenuItemStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMenuItemStateDirty();
        }
        return this.menuitemstateDirtyFlag;
    }

    public void resetMenuItemState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMenuItemState();
            return;
        }
        this.menuitemstateDirtyFlag = false;
        this.menuitemstate = null;
    }

    public void setOpenDefault(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOpenDefault(n);
            return;
        }
        this.opendefault = n;
        this.opendefaultDirtyFlag = true;
    }

    public Integer getOpenDefault() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOpenDefault();
        }
        return this.opendefault;
    }

    public boolean isOpenDefaultDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOpenDefaultDirty();
        }
        return this.opendefaultDirtyFlag;
    }

    public void resetOpenDefault() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOpenDefault();
            return;
        }
        this.opendefaultDirtyFlag = false;
        this.opendefault = null;
    }

    public void setOpenPSAppViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOpenPSAppViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.openpsappviewid = string;
        this.openpsappviewidDirtyFlag = true;
    }

    public String getOpenPSAppViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOpenPSAppViewId();
        }
        return this.openpsappviewid;
    }

    public boolean isOpenPSAppViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOpenPSAppViewIdDirty();
        }
        return this.openpsappviewidDirtyFlag;
    }

    public void resetOpenPSAppViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOpenPSAppViewId();
            return;
        }
        this.openpsappviewidDirtyFlag = false;
        this.openpsappviewid = null;
    }

    public void setOpenPSAppViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOpenPSAppViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.openpsappviewname = string;
        this.openpsappviewnameDirtyFlag = true;
    }

    public String getOpenPSAppViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOpenPSAppViewName();
        }
        return this.openpsappviewname;
    }

    public boolean isOpenPSAppViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOpenPSAppViewNameDirty();
        }
        return this.openpsappviewnameDirtyFlag;
    }

    public void resetOpenPSAppViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOpenPSAppViewName();
            return;
        }
        this.openpsappviewnameDirtyFlag = false;
        this.openpsappviewname = null;
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

    public void setPPSAppMenuItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSAppMenuItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsappmenuitemid = string;
        this.ppsappmenuitemidDirtyFlag = true;
    }

    public String getPPSAppMenuItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSAppMenuItemId();
        }
        return this.ppsappmenuitemid;
    }

    public boolean isPPSAppMenuItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSAppMenuItemIdDirty();
        }
        return this.ppsappmenuitemidDirtyFlag;
    }

    public void resetPPSAppMenuItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSAppMenuItemId();
            return;
        }
        this.ppsappmenuitemidDirtyFlag = false;
        this.ppsappmenuitemid = null;
    }

    public void setPPSAppMenuItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSAppMenuItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsappmenuitemname = string;
        this.ppsappmenuitemnameDirtyFlag = true;
    }

    public String getPPSAppMenuItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSAppMenuItemName();
        }
        return this.ppsappmenuitemname;
    }

    public boolean isPPSAppMenuItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSAppMenuItemNameDirty();
        }
        return this.ppsappmenuitemnameDirtyFlag;
    }

    public void resetPPSAppMenuItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSAppMenuItemName();
            return;
        }
        this.ppsappmenuitemnameDirtyFlag = false;
        this.ppsappmenuitemname = null;
    }

    public void setPredefinedType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPredefinedType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.predefinedtype = string;
        this.predefinedtypeDirtyFlag = true;
    }

    public String getPredefinedType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPredefinedType();
        }
        return this.predefinedtype;
    }

    public boolean isPredefinedTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPredefinedTypeDirty();
        }
        return this.predefinedtypeDirtyFlag;
    }

    public void resetPredefinedType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPredefinedType();
            return;
        }
        this.predefinedtypeDirtyFlag = false;
        this.predefinedtype = null;
    }

    public void setPredefinedTypeParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPredefinedTypeParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.predefinedtypeparam = string;
        this.predefinedtypeparamDirtyFlag = true;
    }

    public String getPredefinedTypeParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPredefinedTypeParam();
        }
        return this.predefinedtypeparam;
    }

    public boolean isPredefinedTypeParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPredefinedTypeParamDirty();
        }
        return this.predefinedtypeparamDirtyFlag;
    }

    public void resetPredefinedTypeParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPredefinedTypeParam();
            return;
        }
        this.predefinedtypeparamDirtyFlag = false;
        this.predefinedtypeparam = null;
    }

    public void setPredefinedTypeText(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPredefinedTypeText(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.predefinedtypetext = string;
        this.predefinedtypetextDirtyFlag = true;
    }

    public String getPredefinedTypeText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPredefinedTypeText();
        }
        return this.predefinedtypetext;
    }

    public boolean isPredefinedTypeTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPredefinedTypeTextDirty();
        }
        return this.predefinedtypetextDirtyFlag;
    }

    public void resetPredefinedTypeText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPredefinedTypeText();
            return;
        }
        this.predefinedtypetextDirtyFlag = false;
        this.predefinedtypetext = null;
    }

    public void setPreviewHtml(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPreviewHtml(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.previewhtml = string;
        this.previewhtmlDirtyFlag = true;
    }

    public String getPreviewHtml() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPreviewHtml();
        }
        return this.previewhtml;
    }

    public boolean isPreviewHtmlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPreviewHtmlDirty();
        }
        return this.previewhtmlDirtyFlag;
    }

    public void resetPreviewHtml() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPreviewHtml();
            return;
        }
        this.previewhtmlDirtyFlag = false;
        this.previewhtml = null;
    }

    public void setPSAppFuncId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppFuncId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappfuncid = string;
        this.psappfuncidDirtyFlag = true;
    }

    public String getPSAppFuncId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppFuncId();
        }
        return this.psappfuncid;
    }

    public boolean isPSAppFuncIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppFuncIdDirty();
        }
        return this.psappfuncidDirtyFlag;
    }

    public void resetPSAppFuncId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppFuncId();
            return;
        }
        this.psappfuncidDirtyFlag = false;
        this.psappfuncid = null;
    }

    public void setPSAppFuncName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppFuncName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappfuncname = string;
        this.psappfuncnameDirtyFlag = true;
    }

    public String getPSAppFuncName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppFuncName();
        }
        return this.psappfuncname;
    }

    public boolean isPSAppFuncNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppFuncNameDirty();
        }
        return this.psappfuncnameDirtyFlag;
    }

    public void resetPSAppFuncName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppFuncName();
            return;
        }
        this.psappfuncnameDirtyFlag = false;
        this.psappfuncname = null;
    }

    public void setPSAppLocalDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppLocalDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapplocaldeid = string;
        this.psapplocaldeidDirtyFlag = true;
    }

    public String getPSAppLocalDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppLocalDEId();
        }
        return this.psapplocaldeid;
    }

    public boolean isPSAppLocalDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppLocalDEIdDirty();
        }
        return this.psapplocaldeidDirtyFlag;
    }

    public void resetPSAppLocalDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppLocalDEId();
            return;
        }
        this.psapplocaldeidDirtyFlag = false;
        this.psapplocaldeid = null;
    }

    public void setPSAppLocalDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppLocalDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapplocaldename = string;
        this.psapplocaldenameDirtyFlag = true;
    }

    public String getPSAppLocalDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppLocalDEName();
        }
        return this.psapplocaldename;
    }

    public boolean isPSAppLocalDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppLocalDENameDirty();
        }
        return this.psapplocaldenameDirtyFlag;
    }

    public void resetPSAppLocalDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppLocalDEName();
            return;
        }
        this.psapplocaldenameDirtyFlag = false;
        this.psapplocaldename = null;
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

    public void setPSAppMenuItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppMenuItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappmenuitemid = string;
        this.psappmenuitemidDirtyFlag = true;
    }

    public String getPSAppMenuItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppMenuItemId();
        }
        return this.psappmenuitemid;
    }

    public boolean isPSAppMenuItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppMenuItemIdDirty();
        }
        return this.psappmenuitemidDirtyFlag;
    }

    public void resetPSAppMenuItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppMenuItemId();
            return;
        }
        this.psappmenuitemidDirtyFlag = false;
        this.psappmenuitemid = null;
    }

    public void setPSAppMenuItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppMenuItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappmenuitemname = string;
        this.psappmenuitemnameDirtyFlag = true;
    }

    public String getPSAppMenuItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppMenuItemName();
        }
        return this.psappmenuitemname;
    }

    public boolean isPSAppMenuItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppMenuItemNameDirty();
        }
        return this.psappmenuitemnameDirtyFlag;
    }

    public void resetPSAppMenuItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppMenuItemName();
            return;
        }
        this.psappmenuitemnameDirtyFlag = false;
        this.psappmenuitemname = null;
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

    public void setPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeid = string;
        this.psdeidDirtyFlag = true;
    }

    public String getPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEId();
        }
        return this.psdeid;
    }

    public boolean isPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEIdDirty();
        }
        return this.psdeidDirtyFlag;
    }

    public void resetPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEId();
            return;
        }
        this.psdeidDirtyFlag = false;
        this.psdeid = null;
    }

    public void setPSDELogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDELogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelogicid = string;
        this.psdelogicidDirtyFlag = true;
    }

    public String getPSDELogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogicId();
        }
        return this.psdelogicid;
    }

    public boolean isPSDELogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDELogicIdDirty();
        }
        return this.psdelogicidDirtyFlag;
    }

    public void resetPSDELogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDELogicId();
            return;
        }
        this.psdelogicidDirtyFlag = false;
        this.psdelogicid = null;
    }

    public void setPSDELogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDELogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelogicname = string;
        this.psdelogicnameDirtyFlag = true;
    }

    public String getPSDELogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogicName();
        }
        return this.psdelogicname;
    }

    public boolean isPSDELogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDELogicNameDirty();
        }
        return this.psdelogicnameDirtyFlag;
    }

    public void resetPSDELogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDELogicName();
            return;
        }
        this.psdelogicnameDirtyFlag = false;
        this.psdelogicname = null;
    }

    public void setPSDEUIActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUIActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeuiactionid = string;
        this.psdeuiactionidDirtyFlag = true;
    }

    public String getPSDEUIActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUIActionId();
        }
        return this.psdeuiactionid;
    }

    public boolean isPSDEUIActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUIActionIdDirty();
        }
        return this.psdeuiactionidDirtyFlag;
    }

    public void resetPSDEUIActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUIActionId();
            return;
        }
        this.psdeuiactionidDirtyFlag = false;
        this.psdeuiactionid = null;
    }

    public void setPSDEUIActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUIActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeuiactionname = string;
        this.psdeuiactionnameDirtyFlag = true;
    }

    public String getPSDEUIActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUIActionName();
        }
        return this.psdeuiactionname;
    }

    public boolean isPSDEUIActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUIActionNameDirty();
        }
        return this.psdeuiactionnameDirtyFlag;
    }

    public void resetPSDEUIActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUIActionName();
            return;
        }
        this.psdeuiactionnameDirtyFlag = false;
        this.psdeuiactionname = null;
    }

    public void setPSSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappid = string;
        this.pssysappidDirtyFlag = true;
    }

    public String getPSSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppId();
        }
        return this.pssysappid;
    }

    public boolean isPSSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppIdDirty();
        }
        return this.pssysappidDirtyFlag;
    }

    public void resetPSSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppId();
            return;
        }
        this.pssysappidDirtyFlag = false;
        this.pssysappid = null;
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

    public void setRefPSAppMenuId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSAppMenuId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsappmenuid = string;
        this.refpsappmenuidDirtyFlag = true;
    }

    public String getRefPSAppMenuId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSAppMenuId();
        }
        return this.refpsappmenuid;
    }

    public boolean isRefPSAppMenuIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSAppMenuIdDirty();
        }
        return this.refpsappmenuidDirtyFlag;
    }

    public void resetRefPSAppMenuId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSAppMenuId();
            return;
        }
        this.refpsappmenuidDirtyFlag = false;
        this.refpsappmenuid = null;
    }

    public void setRefPSAppMenuName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSAppMenuName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsappmenuname = string;
        this.refpsappmenunameDirtyFlag = true;
    }

    public String getRefPSAppMenuName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSAppMenuName();
        }
        return this.refpsappmenuname;
    }

    public boolean isRefPSAppMenuNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSAppMenuNameDirty();
        }
        return this.refpsappmenunameDirtyFlag;
    }

    public void resetRefPSAppMenuName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSAppMenuName();
            return;
        }
        this.refpsappmenunameDirtyFlag = false;
        this.refpsappmenuname = null;
    }

    public void setSpanFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSpanFlag(n);
            return;
        }
        this.spanflag = n;
        this.spanflagDirtyFlag = true;
    }

    public Integer getSpanFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSpanFlag();
        }
        return this.spanflag;
    }

    public boolean isSpanFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSpanFlagDirty();
        }
        return this.spanflagDirtyFlag;
    }

    public void resetSpanFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSpanFlag();
            return;
        }
        this.spanflagDirtyFlag = false;
        this.spanflag = null;
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

    public void setTipPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTipPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tippslanresid = string;
        this.tippslanresidDirtyFlag = true;
    }

    public String getTipPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTipPSLanResId();
        }
        return this.tippslanresid;
    }

    public boolean isTipPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTipPSLanResIdDirty();
        }
        return this.tippslanresidDirtyFlag;
    }

    public void resetTipPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTipPSLanResId();
            return;
        }
        this.tippslanresidDirtyFlag = false;
        this.tippslanresid = null;
    }

    public void setTipPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTipPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tippslanresname = string;
        this.tippslanresnameDirtyFlag = true;
    }

    public String getTipPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTipPSLanResName();
        }
        return this.tippslanresname;
    }

    public boolean isTipPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTipPSLanResNameDirty();
        }
        return this.tippslanresnameDirtyFlag;
    }

    public void resetTipPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTipPSLanResName();
            return;
        }
        this.tippslanresnameDirtyFlag = false;
        this.tippslanresname = null;
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

    public void setToggleMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setToggleMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.togglemode = string;
        this.togglemodeDirtyFlag = true;
    }

    public String getToggleMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getToggleMode();
        }
        return this.togglemode;
    }

    public boolean isToggleModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isToggleModeDirty();
        }
        return this.togglemodeDirtyFlag;
    }

    public void resetToggleMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetToggleMode();
            return;
        }
        this.togglemodeDirtyFlag = false;
        this.togglemode = null;
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

    public void setUserParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userparams = string;
        this.userparamsDirtyFlag = true;
    }

    public String getUserParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserParams();
        }
        return this.userparams;
    }

    public boolean isUserParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserParamsDirty();
        }
        return this.userparamsDirtyFlag;
    }

    public void resetUserParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserParams();
            return;
        }
        this.userparamsDirtyFlag = false;
        this.userparams = null;
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
        PSAppMenuItemBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppMenuItemBase pSAppMenuItemBase) {
        pSAppMenuItemBase.resetActionLevel();
        pSAppMenuItemBase.resetAMItemType();
        pSAppMenuItemBase.resetBL_Pos();
        pSAppMenuItemBase.resetBorderStyle();
        pSAppMenuItemBase.resetBtnActionType();
        pSAppMenuItemBase.resetCapPSLanResId();
        pSAppMenuItemBase.resetCapPSLanResName();
        pSAppMenuItemBase.resetCaption();
        pSAppMenuItemBase.resetCol_LG();
        pSAppMenuItemBase.resetCol_LG_OS();
        pSAppMenuItemBase.resetCol_MD();
        pSAppMenuItemBase.resetCol_MD_OS();
        pSAppMenuItemBase.resetCol_SM();
        pSAppMenuItemBase.resetCol_SM_OS();
        pSAppMenuItemBase.resetCol_XS();
        pSAppMenuItemBase.resetCol_XS_OS();
        pSAppMenuItemBase.resetContentType();
        pSAppMenuItemBase.resetCounterId();
        pSAppMenuItemBase.resetCounterMode();
        pSAppMenuItemBase.resetCreateDate();
        pSAppMenuItemBase.resetCreateMan();
        pSAppMenuItemBase.resetCssId();
        pSAppMenuItemBase.resetCustomCode();
        pSAppMenuItemBase.resetData();
        pSAppMenuItemBase.resetDisableClose();
        pSAppMenuItemBase.resetDynaClass();
        pSAppMenuItemBase.resetDynaModelFlag();
        pSAppMenuItemBase.resetEnableMode();
        pSAppMenuItemBase.resetExpand();
        pSAppMenuItemBase.resetFillerObj();
        pSAppMenuItemBase.resetFlexAlign();
        pSAppMenuItemBase.resetFlexBasis();
        pSAppMenuItemBase.resetFlexDir();
        pSAppMenuItemBase.resetFlexGrow();
        pSAppMenuItemBase.resetFlexShrink();
        pSAppMenuItemBase.resetFlexVAlign();
        pSAppMenuItemBase.resetHAlignSelf();
        pSAppMenuItemBase.resetHeight();
        pSAppMenuItemBase.resetHiddenItem();
        pSAppMenuItemBase.resetHIdeSideBar();
        pSAppMenuItemBase.resetHtmlContent();
        pSAppMenuItemBase.resetHtmlPageUrl();
        pSAppMenuItemBase.resetInformTag();
        pSAppMenuItemBase.resetInformTag2();
        pSAppMenuItemBase.resetItemStyle();
        pSAppMenuItemBase.resetItemStyleText();
        pSAppMenuItemBase.resetLayoutMode();
        pSAppMenuItemBase.resetLevelTag();
        pSAppMenuItemBase.resetLevelValue();
        pSAppMenuItemBase.resetMemo();
        pSAppMenuItemBase.resetMenuItemState();
        pSAppMenuItemBase.resetOpenDefault();
        pSAppMenuItemBase.resetOpenPSAppViewId();
        pSAppMenuItemBase.resetOpenPSAppViewName();
        pSAppMenuItemBase.resetOrderValue();
        pSAppMenuItemBase.resetPPSAppMenuItemId();
        pSAppMenuItemBase.resetPPSAppMenuItemName();
        pSAppMenuItemBase.resetPredefinedType();
        pSAppMenuItemBase.resetPredefinedTypeParam();
        pSAppMenuItemBase.resetPredefinedTypeText();
        pSAppMenuItemBase.resetPreviewHtml();
        pSAppMenuItemBase.resetPSAppFuncId();
        pSAppMenuItemBase.resetPSAppFuncName();
        pSAppMenuItemBase.resetPSAppLocalDEId();
        pSAppMenuItemBase.resetPSAppLocalDEName();
        pSAppMenuItemBase.resetPSAppMenuId();
        pSAppMenuItemBase.resetPSAppMenuItemId();
        pSAppMenuItemBase.resetPSAppMenuItemName();
        pSAppMenuItemBase.resetPSAppMenuName();
        pSAppMenuItemBase.resetPSDEId();
        pSAppMenuItemBase.resetPSDELogicId();
        pSAppMenuItemBase.resetPSDELogicName();
        pSAppMenuItemBase.resetPSDEUIActionId();
        pSAppMenuItemBase.resetPSDEUIActionName();
        pSAppMenuItemBase.resetPSSysAppId();
        pSAppMenuItemBase.resetPSSysCssId();
        pSAppMenuItemBase.resetPSSysCssName();
        pSAppMenuItemBase.resetPSSysImageId();
        pSAppMenuItemBase.resetPSSysImageName();
        pSAppMenuItemBase.resetPSSysPFPluginId();
        pSAppMenuItemBase.resetPSSysPFPluginName();
        pSAppMenuItemBase.resetPSSysResourceId();
        pSAppMenuItemBase.resetPSSysResourceName();
        pSAppMenuItemBase.resetPSSysUniResId();
        pSAppMenuItemBase.resetPSSysUniResName();
        pSAppMenuItemBase.resetRawContent();
        pSAppMenuItemBase.resetRawCssStyle();
        pSAppMenuItemBase.resetRefPSAppMenuId();
        pSAppMenuItemBase.resetRefPSAppMenuName();
        pSAppMenuItemBase.resetSpanFlag();
        pSAppMenuItemBase.resetTemplateMode();
        pSAppMenuItemBase.resetTipPSLanResId();
        pSAppMenuItemBase.resetTipPSLanResName();
        pSAppMenuItemBase.resetTitleBarCloseMode();
        pSAppMenuItemBase.resetToggleMode();
        pSAppMenuItemBase.resetTooltipInfo();
        pSAppMenuItemBase.resetUpdateDate();
        pSAppMenuItemBase.resetUpdateMan();
        pSAppMenuItemBase.resetUserParams();
        pSAppMenuItemBase.resetUserTag();
        pSAppMenuItemBase.resetUserTag2();
        pSAppMenuItemBase.resetVAlignSelf();
        pSAppMenuItemBase.resetWidth();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isActionLevelDirty()) {
            hashMap.put(FIELD_ACTIONLEVEL, this.getActionLevel());
        }
        if (!bl || this.isAMItemTypeDirty()) {
            hashMap.put(FIELD_AMITEMTYPE, this.getAMItemType());
        }
        if (!bl || this.isBL_PosDirty()) {
            hashMap.put(FIELD_BL_POS, this.getBL_Pos());
        }
        if (!bl || this.isBorderStyleDirty()) {
            hashMap.put(FIELD_BORDERSTYLE, this.getBorderStyle());
        }
        if (!bl || this.isBtnActionTypeDirty()) {
            hashMap.put(FIELD_BTNACTIONTYPE, this.getBtnActionType());
        }
        if (!bl || this.isCapPSLanResIdDirty()) {
            hashMap.put(FIELD_CAPPSLANRESID, this.getCapPSLanResId());
        }
        if (!bl || this.isCapPSLanResNameDirty()) {
            hashMap.put(FIELD_CAPPSLANRESNAME, this.getCapPSLanResName());
        }
        if (!bl || this.isCaptionDirty()) {
            hashMap.put(FIELD_CAPTION, this.getCaption());
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
        if (!bl || this.isCounterIdDirty()) {
            hashMap.put(FIELD_COUNTERID, this.getCounterId());
        }
        if (!bl || this.isCounterModeDirty()) {
            hashMap.put(FIELD_COUNTERMODE, this.getCounterMode());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCssIdDirty()) {
            hashMap.put(FIELD_CSSID, this.getCssId());
        }
        if (!bl || this.isCustomCodeDirty()) {
            hashMap.put(FIELD_CUSTOMCODE, this.getCustomCode());
        }
        if (!bl || this.isDataDirty()) {
            hashMap.put(FIELD_DATA, this.getData());
        }
        if (!bl || this.isDisableCloseDirty()) {
            hashMap.put(FIELD_DISABLECLOSE, this.getDisableClose());
        }
        if (!bl || this.isDynaClassDirty()) {
            hashMap.put(FIELD_DYNACLASS, this.getDynaClass());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isEnableModeDirty()) {
            hashMap.put(FIELD_ENABLEMODE, this.getEnableMode());
        }
        if (!bl || this.isExpandDirty()) {
            hashMap.put(FIELD_EXPAND, this.getExpand());
        }
        if (!bl || this.isFillerObjDirty()) {
            hashMap.put(FIELD_FILLEROBJ, this.getFillerObj());
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
        if (!bl || this.isHiddenItemDirty()) {
            hashMap.put(FIELD_HIDDENITEM, this.getHiddenItem());
        }
        if (!bl || this.isHIdeSideBarDirty()) {
            hashMap.put(FIELD_HIDESIDEBAR, this.getHIdeSideBar());
        }
        if (!bl || this.isHtmlContentDirty()) {
            hashMap.put(FIELD_HTMLCONTENT, this.getHtmlContent());
        }
        if (!bl || this.isHtmlPageUrlDirty()) {
            hashMap.put(FIELD_HTMLPAGEURL, this.getHtmlPageUrl());
        }
        if (!bl || this.isInformTagDirty()) {
            hashMap.put(FIELD_INFORMTAG, this.getInformTag());
        }
        if (!bl || this.isInformTag2Dirty()) {
            hashMap.put(FIELD_INFORMTAG2, this.getInformTag2());
        }
        if (!bl || this.isItemStyleDirty()) {
            hashMap.put(FIELD_ITEMSTYLE, this.getItemStyle());
        }
        if (!bl || this.isItemStyleTextDirty()) {
            hashMap.put(FIELD_ITEMSTYLETEXT, this.getItemStyleText());
        }
        if (!bl || this.isLayoutModeDirty()) {
            hashMap.put(FIELD_LAYOUTMODE, this.getLayoutMode());
        }
        if (!bl || this.isLevelTagDirty()) {
            hashMap.put(FIELD_LEVELTAG, this.getLevelTag());
        }
        if (!bl || this.isLevelValueDirty()) {
            hashMap.put(FIELD_LEVELVALUE, this.getLevelValue());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMenuItemStateDirty()) {
            hashMap.put(FIELD_MENUITEMSTATE, this.getMenuItemState());
        }
        if (!bl || this.isOpenDefaultDirty()) {
            hashMap.put(FIELD_OPENDEFAULT, this.getOpenDefault());
        }
        if (!bl || this.isOpenPSAppViewIdDirty()) {
            hashMap.put(FIELD_OPENPSAPPVIEWID, this.getOpenPSAppViewId());
        }
        if (!bl || this.isOpenPSAppViewNameDirty()) {
            hashMap.put(FIELD_OPENPSAPPVIEWNAME, this.getOpenPSAppViewName());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPPSAppMenuItemIdDirty()) {
            hashMap.put(FIELD_PPSAPPMENUITEMID, this.getPPSAppMenuItemId());
        }
        if (!bl || this.isPPSAppMenuItemNameDirty()) {
            hashMap.put(FIELD_PPSAPPMENUITEMNAME, this.getPPSAppMenuItemName());
        }
        if (!bl || this.isPredefinedTypeDirty()) {
            hashMap.put(FIELD_PREDEFINEDTYPE, this.getPredefinedType());
        }
        if (!bl || this.isPredefinedTypeParamDirty()) {
            hashMap.put(FIELD_PREDEFINEDTYPEPARAM, this.getPredefinedTypeParam());
        }
        if (!bl || this.isPredefinedTypeTextDirty()) {
            hashMap.put(FIELD_PREDEFINEDTYPETEXT, this.getPredefinedTypeText());
        }
        if (!bl || this.isPreviewHtmlDirty()) {
            hashMap.put(FIELD_PREVIEWHTML, this.getPreviewHtml());
        }
        if (!bl || this.isPSAppFuncIdDirty()) {
            hashMap.put(FIELD_PSAPPFUNCID, this.getPSAppFuncId());
        }
        if (!bl || this.isPSAppFuncNameDirty()) {
            hashMap.put(FIELD_PSAPPFUNCNAME, this.getPSAppFuncName());
        }
        if (!bl || this.isPSAppLocalDEIdDirty()) {
            hashMap.put(FIELD_PSAPPLOCALDEID, this.getPSAppLocalDEId());
        }
        if (!bl || this.isPSAppLocalDENameDirty()) {
            hashMap.put(FIELD_PSAPPLOCALDENAME, this.getPSAppLocalDEName());
        }
        if (!bl || this.isPSAppMenuIdDirty()) {
            hashMap.put(FIELD_PSAPPMENUID, this.getPSAppMenuId());
        }
        if (!bl || this.isPSAppMenuItemIdDirty()) {
            hashMap.put(FIELD_PSAPPMENUITEMID, this.getPSAppMenuItemId());
        }
        if (!bl || this.isPSAppMenuItemNameDirty()) {
            hashMap.put(FIELD_PSAPPMENUITEMNAME, this.getPSAppMenuItemName());
        }
        if (!bl || this.isPSAppMenuNameDirty()) {
            hashMap.put(FIELD_PSAPPMENUNAME, this.getPSAppMenuName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDELogicIdDirty()) {
            hashMap.put(FIELD_PSDELOGICID, this.getPSDELogicId());
        }
        if (!bl || this.isPSDELogicNameDirty()) {
            hashMap.put(FIELD_PSDELOGICNAME, this.getPSDELogicName());
        }
        if (!bl || this.isPSDEUIActionIdDirty()) {
            hashMap.put(FIELD_PSDEUIACTIONID, this.getPSDEUIActionId());
        }
        if (!bl || this.isPSDEUIActionNameDirty()) {
            hashMap.put(FIELD_PSDEUIACTIONNAME, this.getPSDEUIActionName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
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
        if (!bl || this.isPSSysResourceIdDirty()) {
            hashMap.put(FIELD_PSSYSRESOURCEID, this.getPSSysResourceId());
        }
        if (!bl || this.isPSSysResourceNameDirty()) {
            hashMap.put(FIELD_PSSYSRESOURCENAME, this.getPSSysResourceName());
        }
        if (!bl || this.isPSSysUniResIdDirty()) {
            hashMap.put(FIELD_PSSYSUNIRESID, this.getPSSysUniResId());
        }
        if (!bl || this.isPSSysUniResNameDirty()) {
            hashMap.put(FIELD_PSSYSUNIRESNAME, this.getPSSysUniResName());
        }
        if (!bl || this.isRawContentDirty()) {
            hashMap.put(FIELD_RAWCONTENT, this.getRawContent());
        }
        if (!bl || this.isRawCssStyleDirty()) {
            hashMap.put(FIELD_RAWCSSSTYLE, this.getRawCssStyle());
        }
        if (!bl || this.isRefPSAppMenuIdDirty()) {
            hashMap.put(FIELD_REFPSAPPMENUID, this.getRefPSAppMenuId());
        }
        if (!bl || this.isRefPSAppMenuNameDirty()) {
            hashMap.put(FIELD_REFPSAPPMENUNAME, this.getRefPSAppMenuName());
        }
        if (!bl || this.isSpanFlagDirty()) {
            hashMap.put(FIELD_SPANFLAG, this.getSpanFlag());
        }
        if (!bl || this.isTemplateModeDirty()) {
            hashMap.put(FIELD_TEMPLATEMODE, this.getTemplateMode());
        }
        if (!bl || this.isTipPSLanResIdDirty()) {
            hashMap.put(FIELD_TIPPSLANRESID, this.getTipPSLanResId());
        }
        if (!bl || this.isTipPSLanResNameDirty()) {
            hashMap.put(FIELD_TIPPSLANRESNAME, this.getTipPSLanResName());
        }
        if (!bl || this.isTitleBarCloseModeDirty()) {
            hashMap.put(FIELD_TITLEBARCLOSEMODE, this.getTitleBarCloseMode());
        }
        if (!bl || this.isToggleModeDirty()) {
            hashMap.put(FIELD_TOGGLEMODE, this.getToggleMode());
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
        if (!bl || this.isUserParamsDirty()) {
            hashMap.put(FIELD_USERPARAMS, this.getUserParams());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
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
        return PSAppMenuItemBase.get(this, n);
    }

    private static Object get(PSAppMenuItemBase pSAppMenuItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppMenuItemBase.getActionLevel();
            }
            case 1: {
                return pSAppMenuItemBase.getAMItemType();
            }
            case 2: {
                return pSAppMenuItemBase.getBL_Pos();
            }
            case 3: {
                return pSAppMenuItemBase.getBorderStyle();
            }
            case 4: {
                return pSAppMenuItemBase.getBtnActionType();
            }
            case 5: {
                return pSAppMenuItemBase.getCapPSLanResId();
            }
            case 6: {
                return pSAppMenuItemBase.getCapPSLanResName();
            }
            case 7: {
                return pSAppMenuItemBase.getCaption();
            }
            case 8: {
                return pSAppMenuItemBase.getCol_LG();
            }
            case 9: {
                return pSAppMenuItemBase.getCol_LG_OS();
            }
            case 10: {
                return pSAppMenuItemBase.getCol_MD();
            }
            case 11: {
                return pSAppMenuItemBase.getCol_MD_OS();
            }
            case 12: {
                return pSAppMenuItemBase.getCol_SM();
            }
            case 13: {
                return pSAppMenuItemBase.getCol_SM_OS();
            }
            case 14: {
                return pSAppMenuItemBase.getCol_XS();
            }
            case 15: {
                return pSAppMenuItemBase.getCol_XS_OS();
            }
            case 16: {
                return pSAppMenuItemBase.getContentType();
            }
            case 17: {
                return pSAppMenuItemBase.getCounterId();
            }
            case 18: {
                return pSAppMenuItemBase.getCounterMode();
            }
            case 19: {
                return pSAppMenuItemBase.getCreateDate();
            }
            case 20: {
                return pSAppMenuItemBase.getCreateMan();
            }
            case 21: {
                return pSAppMenuItemBase.getCssId();
            }
            case 22: {
                return pSAppMenuItemBase.getCustomCode();
            }
            case 23: {
                return pSAppMenuItemBase.getData();
            }
            case 24: {
                return pSAppMenuItemBase.getDisableClose();
            }
            case 25: {
                return pSAppMenuItemBase.getDynaClass();
            }
            case 26: {
                return pSAppMenuItemBase.getDynaModelFlag();
            }
            case 27: {
                return pSAppMenuItemBase.getEnableMode();
            }
            case 28: {
                return pSAppMenuItemBase.getExpand();
            }
            case 29: {
                return pSAppMenuItemBase.getFillerObj();
            }
            case 30: {
                return pSAppMenuItemBase.getFlexAlign();
            }
            case 31: {
                return pSAppMenuItemBase.getFlexBasis();
            }
            case 32: {
                return pSAppMenuItemBase.getFlexDir();
            }
            case 33: {
                return pSAppMenuItemBase.getFlexGrow();
            }
            case 34: {
                return pSAppMenuItemBase.getFlexShrink();
            }
            case 35: {
                return pSAppMenuItemBase.getFlexVAlign();
            }
            case 36: {
                return pSAppMenuItemBase.getHAlignSelf();
            }
            case 37: {
                return pSAppMenuItemBase.getHeight();
            }
            case 38: {
                return pSAppMenuItemBase.getHiddenItem();
            }
            case 39: {
                return pSAppMenuItemBase.getHIdeSideBar();
            }
            case 40: {
                return pSAppMenuItemBase.getHtmlContent();
            }
            case 41: {
                return pSAppMenuItemBase.getHtmlPageUrl();
            }
            case 42: {
                return pSAppMenuItemBase.getInformTag();
            }
            case 43: {
                return pSAppMenuItemBase.getInformTag2();
            }
            case 44: {
                return pSAppMenuItemBase.getItemStyle();
            }
            case 45: {
                return pSAppMenuItemBase.getItemStyleText();
            }
            case 46: {
                return pSAppMenuItemBase.getLayoutMode();
            }
            case 47: {
                return pSAppMenuItemBase.getLevelTag();
            }
            case 48: {
                return pSAppMenuItemBase.getLevelValue();
            }
            case 49: {
                return pSAppMenuItemBase.getMemo();
            }
            case 50: {
                return pSAppMenuItemBase.getMenuItemState();
            }
            case 51: {
                return pSAppMenuItemBase.getOpenDefault();
            }
            case 52: {
                return pSAppMenuItemBase.getOpenPSAppViewId();
            }
            case 53: {
                return pSAppMenuItemBase.getOpenPSAppViewName();
            }
            case 54: {
                return pSAppMenuItemBase.getOrderValue();
            }
            case 55: {
                return pSAppMenuItemBase.getPPSAppMenuItemId();
            }
            case 56: {
                return pSAppMenuItemBase.getPPSAppMenuItemName();
            }
            case 57: {
                return pSAppMenuItemBase.getPredefinedType();
            }
            case 58: {
                return pSAppMenuItemBase.getPredefinedTypeParam();
            }
            case 59: {
                return pSAppMenuItemBase.getPredefinedTypeText();
            }
            case 60: {
                return pSAppMenuItemBase.getPreviewHtml();
            }
            case 61: {
                return pSAppMenuItemBase.getPSAppFuncId();
            }
            case 62: {
                return pSAppMenuItemBase.getPSAppFuncName();
            }
            case 63: {
                return pSAppMenuItemBase.getPSAppLocalDEId();
            }
            case 64: {
                return pSAppMenuItemBase.getPSAppLocalDEName();
            }
            case 65: {
                return pSAppMenuItemBase.getPSAppMenuId();
            }
            case 66: {
                return pSAppMenuItemBase.getPSAppMenuItemId();
            }
            case 67: {
                return pSAppMenuItemBase.getPSAppMenuItemName();
            }
            case 68: {
                return pSAppMenuItemBase.getPSAppMenuName();
            }
            case 69: {
                return pSAppMenuItemBase.getPSDEId();
            }
            case 70: {
                return pSAppMenuItemBase.getPSDELogicId();
            }
            case 71: {
                return pSAppMenuItemBase.getPSDELogicName();
            }
            case 72: {
                return pSAppMenuItemBase.getPSDEUIActionId();
            }
            case 73: {
                return pSAppMenuItemBase.getPSDEUIActionName();
            }
            case 74: {
                return pSAppMenuItemBase.getPSSysAppId();
            }
            case 75: {
                return pSAppMenuItemBase.getPSSysCssId();
            }
            case 76: {
                return pSAppMenuItemBase.getPSSysCssName();
            }
            case 77: {
                return pSAppMenuItemBase.getPSSysImageId();
            }
            case 78: {
                return pSAppMenuItemBase.getPSSysImageName();
            }
            case 79: {
                return pSAppMenuItemBase.getPSSysPFPluginId();
            }
            case 80: {
                return pSAppMenuItemBase.getPSSysPFPluginName();
            }
            case 81: {
                return pSAppMenuItemBase.getPSSysResourceId();
            }
            case 82: {
                return pSAppMenuItemBase.getPSSysResourceName();
            }
            case 83: {
                return pSAppMenuItemBase.getPSSysUniResId();
            }
            case 84: {
                return pSAppMenuItemBase.getPSSysUniResName();
            }
            case 85: {
                return pSAppMenuItemBase.getRawContent();
            }
            case 86: {
                return pSAppMenuItemBase.getRawCssStyle();
            }
            case 87: {
                return pSAppMenuItemBase.getRefPSAppMenuId();
            }
            case 88: {
                return pSAppMenuItemBase.getRefPSAppMenuName();
            }
            case 89: {
                return pSAppMenuItemBase.getSpanFlag();
            }
            case 90: {
                return pSAppMenuItemBase.getTemplateMode();
            }
            case 91: {
                return pSAppMenuItemBase.getTipPSLanResId();
            }
            case 92: {
                return pSAppMenuItemBase.getTipPSLanResName();
            }
            case 93: {
                return pSAppMenuItemBase.getTitleBarCloseMode();
            }
            case 94: {
                return pSAppMenuItemBase.getToggleMode();
            }
            case 95: {
                return pSAppMenuItemBase.getTooltipInfo();
            }
            case 96: {
                return pSAppMenuItemBase.getUpdateDate();
            }
            case 97: {
                return pSAppMenuItemBase.getUpdateMan();
            }
            case 98: {
                return pSAppMenuItemBase.getUserParams();
            }
            case 99: {
                return pSAppMenuItemBase.getUserTag();
            }
            case 100: {
                return pSAppMenuItemBase.getUserTag2();
            }
            case 101: {
                return pSAppMenuItemBase.getVAlignSelf();
            }
            case 102: {
                return pSAppMenuItemBase.getWidth();
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
        PSAppMenuItemBase.set(this, n, object);
    }

    private static void set(PSAppMenuItemBase pSAppMenuItemBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSAppMenuItemBase.setActionLevel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSAppMenuItemBase.setAMItemType(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSAppMenuItemBase.setBL_Pos(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSAppMenuItemBase.setBorderStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSAppMenuItemBase.setBtnActionType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSAppMenuItemBase.setCapPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSAppMenuItemBase.setCapPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSAppMenuItemBase.setCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSAppMenuItemBase.setCol_LG(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSAppMenuItemBase.setCol_LG_OS(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSAppMenuItemBase.setCol_MD(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSAppMenuItemBase.setCol_MD_OS(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSAppMenuItemBase.setCol_SM(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSAppMenuItemBase.setCol_SM_OS(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSAppMenuItemBase.setCol_XS(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSAppMenuItemBase.setCol_XS_OS(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSAppMenuItemBase.setContentType(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSAppMenuItemBase.setCounterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSAppMenuItemBase.setCounterMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSAppMenuItemBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSAppMenuItemBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSAppMenuItemBase.setCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSAppMenuItemBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSAppMenuItemBase.setData(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSAppMenuItemBase.setDisableClose(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSAppMenuItemBase.setDynaClass(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSAppMenuItemBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSAppMenuItemBase.setEnableMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 28: {
                pSAppMenuItemBase.setExpand(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 29: {
                pSAppMenuItemBase.setFillerObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSAppMenuItemBase.setFlexAlign(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSAppMenuItemBase.setFlexBasis(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 32: {
                pSAppMenuItemBase.setFlexDir(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSAppMenuItemBase.setFlexGrow(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 34: {
                pSAppMenuItemBase.setFlexShrink(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 35: {
                pSAppMenuItemBase.setFlexVAlign(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSAppMenuItemBase.setHAlignSelf(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSAppMenuItemBase.setHeight(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 38: {
                pSAppMenuItemBase.setHiddenItem(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 39: {
                pSAppMenuItemBase.setHIdeSideBar(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 40: {
                pSAppMenuItemBase.setHtmlContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSAppMenuItemBase.setHtmlPageUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSAppMenuItemBase.setInformTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSAppMenuItemBase.setInformTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSAppMenuItemBase.setItemStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSAppMenuItemBase.setItemStyleText(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSAppMenuItemBase.setLayoutMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSAppMenuItemBase.setLevelTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSAppMenuItemBase.setLevelValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 49: {
                pSAppMenuItemBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSAppMenuItemBase.setMenuItemState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 51: {
                pSAppMenuItemBase.setOpenDefault(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 52: {
                pSAppMenuItemBase.setOpenPSAppViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSAppMenuItemBase.setOpenPSAppViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSAppMenuItemBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 55: {
                pSAppMenuItemBase.setPPSAppMenuItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSAppMenuItemBase.setPPSAppMenuItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSAppMenuItemBase.setPredefinedType(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSAppMenuItemBase.setPredefinedTypeParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSAppMenuItemBase.setPredefinedTypeText(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSAppMenuItemBase.setPreviewHtml(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSAppMenuItemBase.setPSAppFuncId(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSAppMenuItemBase.setPSAppFuncName(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSAppMenuItemBase.setPSAppLocalDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSAppMenuItemBase.setPSAppLocalDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSAppMenuItemBase.setPSAppMenuId(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSAppMenuItemBase.setPSAppMenuItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSAppMenuItemBase.setPSAppMenuItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSAppMenuItemBase.setPSAppMenuName(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSAppMenuItemBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 70: {
                pSAppMenuItemBase.setPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 71: {
                pSAppMenuItemBase.setPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 72: {
                pSAppMenuItemBase.setPSDEUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 73: {
                pSAppMenuItemBase.setPSDEUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 74: {
                pSAppMenuItemBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 75: {
                pSAppMenuItemBase.setPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 76: {
                pSAppMenuItemBase.setPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 77: {
                pSAppMenuItemBase.setPSSysImageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 78: {
                pSAppMenuItemBase.setPSSysImageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 79: {
                pSAppMenuItemBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 80: {
                pSAppMenuItemBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 81: {
                pSAppMenuItemBase.setPSSysResourceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 82: {
                pSAppMenuItemBase.setPSSysResourceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 83: {
                pSAppMenuItemBase.setPSSysUniResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 84: {
                pSAppMenuItemBase.setPSSysUniResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 85: {
                pSAppMenuItemBase.setRawContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 86: {
                pSAppMenuItemBase.setRawCssStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 87: {
                pSAppMenuItemBase.setRefPSAppMenuId(DataObject.getStringValue((Object)object));
                return;
            }
            case 88: {
                pSAppMenuItemBase.setRefPSAppMenuName(DataObject.getStringValue((Object)object));
                return;
            }
            case 89: {
                pSAppMenuItemBase.setSpanFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 90: {
                pSAppMenuItemBase.setTemplateMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 91: {
                pSAppMenuItemBase.setTipPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 92: {
                pSAppMenuItemBase.setTipPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 93: {
                pSAppMenuItemBase.setTitleBarCloseMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 94: {
                pSAppMenuItemBase.setToggleMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 95: {
                pSAppMenuItemBase.setTooltipInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 96: {
                pSAppMenuItemBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 97: {
                pSAppMenuItemBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 98: {
                pSAppMenuItemBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 99: {
                pSAppMenuItemBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 100: {
                pSAppMenuItemBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 101: {
                pSAppMenuItemBase.setVAlignSelf(DataObject.getStringValue((Object)object));
                return;
            }
            case 102: {
                pSAppMenuItemBase.setWidth(DataObject.getIntegerValue((Object)object));
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
        return PSAppMenuItemBase.isNull(this, n);
    }

    private static boolean isNull(PSAppMenuItemBase pSAppMenuItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppMenuItemBase.getActionLevel() == null;
            }
            case 1: {
                return pSAppMenuItemBase.getAMItemType() == null;
            }
            case 2: {
                return pSAppMenuItemBase.getBL_Pos() == null;
            }
            case 3: {
                return pSAppMenuItemBase.getBorderStyle() == null;
            }
            case 4: {
                return pSAppMenuItemBase.getBtnActionType() == null;
            }
            case 5: {
                return pSAppMenuItemBase.getCapPSLanResId() == null;
            }
            case 6: {
                return pSAppMenuItemBase.getCapPSLanResName() == null;
            }
            case 7: {
                return pSAppMenuItemBase.getCaption() == null;
            }
            case 8: {
                return pSAppMenuItemBase.getCol_LG() == null;
            }
            case 9: {
                return pSAppMenuItemBase.getCol_LG_OS() == null;
            }
            case 10: {
                return pSAppMenuItemBase.getCol_MD() == null;
            }
            case 11: {
                return pSAppMenuItemBase.getCol_MD_OS() == null;
            }
            case 12: {
                return pSAppMenuItemBase.getCol_SM() == null;
            }
            case 13: {
                return pSAppMenuItemBase.getCol_SM_OS() == null;
            }
            case 14: {
                return pSAppMenuItemBase.getCol_XS() == null;
            }
            case 15: {
                return pSAppMenuItemBase.getCol_XS_OS() == null;
            }
            case 16: {
                return pSAppMenuItemBase.getContentType() == null;
            }
            case 17: {
                return pSAppMenuItemBase.getCounterId() == null;
            }
            case 18: {
                return pSAppMenuItemBase.getCounterMode() == null;
            }
            case 19: {
                return pSAppMenuItemBase.getCreateDate() == null;
            }
            case 20: {
                return pSAppMenuItemBase.getCreateMan() == null;
            }
            case 21: {
                return pSAppMenuItemBase.getCssId() == null;
            }
            case 22: {
                return pSAppMenuItemBase.getCustomCode() == null;
            }
            case 23: {
                return pSAppMenuItemBase.getData() == null;
            }
            case 24: {
                return pSAppMenuItemBase.getDisableClose() == null;
            }
            case 25: {
                return pSAppMenuItemBase.getDynaClass() == null;
            }
            case 26: {
                return pSAppMenuItemBase.getDynaModelFlag() == null;
            }
            case 27: {
                return pSAppMenuItemBase.getEnableMode() == null;
            }
            case 28: {
                return pSAppMenuItemBase.getExpand() == null;
            }
            case 29: {
                return pSAppMenuItemBase.getFillerObj() == null;
            }
            case 30: {
                return pSAppMenuItemBase.getFlexAlign() == null;
            }
            case 31: {
                return pSAppMenuItemBase.getFlexBasis() == null;
            }
            case 32: {
                return pSAppMenuItemBase.getFlexDir() == null;
            }
            case 33: {
                return pSAppMenuItemBase.getFlexGrow() == null;
            }
            case 34: {
                return pSAppMenuItemBase.getFlexShrink() == null;
            }
            case 35: {
                return pSAppMenuItemBase.getFlexVAlign() == null;
            }
            case 36: {
                return pSAppMenuItemBase.getHAlignSelf() == null;
            }
            case 37: {
                return pSAppMenuItemBase.getHeight() == null;
            }
            case 38: {
                return pSAppMenuItemBase.getHiddenItem() == null;
            }
            case 39: {
                return pSAppMenuItemBase.getHIdeSideBar() == null;
            }
            case 40: {
                return pSAppMenuItemBase.getHtmlContent() == null;
            }
            case 41: {
                return pSAppMenuItemBase.getHtmlPageUrl() == null;
            }
            case 42: {
                return pSAppMenuItemBase.getInformTag() == null;
            }
            case 43: {
                return pSAppMenuItemBase.getInformTag2() == null;
            }
            case 44: {
                return pSAppMenuItemBase.getItemStyle() == null;
            }
            case 45: {
                return pSAppMenuItemBase.getItemStyleText() == null;
            }
            case 46: {
                return pSAppMenuItemBase.getLayoutMode() == null;
            }
            case 47: {
                return pSAppMenuItemBase.getLevelTag() == null;
            }
            case 48: {
                return pSAppMenuItemBase.getLevelValue() == null;
            }
            case 49: {
                return pSAppMenuItemBase.getMemo() == null;
            }
            case 50: {
                return pSAppMenuItemBase.getMenuItemState() == null;
            }
            case 51: {
                return pSAppMenuItemBase.getOpenDefault() == null;
            }
            case 52: {
                return pSAppMenuItemBase.getOpenPSAppViewId() == null;
            }
            case 53: {
                return pSAppMenuItemBase.getOpenPSAppViewName() == null;
            }
            case 54: {
                return pSAppMenuItemBase.getOrderValue() == null;
            }
            case 55: {
                return pSAppMenuItemBase.getPPSAppMenuItemId() == null;
            }
            case 56: {
                return pSAppMenuItemBase.getPPSAppMenuItemName() == null;
            }
            case 57: {
                return pSAppMenuItemBase.getPredefinedType() == null;
            }
            case 58: {
                return pSAppMenuItemBase.getPredefinedTypeParam() == null;
            }
            case 59: {
                return pSAppMenuItemBase.getPredefinedTypeText() == null;
            }
            case 60: {
                return pSAppMenuItemBase.getPreviewHtml() == null;
            }
            case 61: {
                return pSAppMenuItemBase.getPSAppFuncId() == null;
            }
            case 62: {
                return pSAppMenuItemBase.getPSAppFuncName() == null;
            }
            case 63: {
                return pSAppMenuItemBase.getPSAppLocalDEId() == null;
            }
            case 64: {
                return pSAppMenuItemBase.getPSAppLocalDEName() == null;
            }
            case 65: {
                return pSAppMenuItemBase.getPSAppMenuId() == null;
            }
            case 66: {
                return pSAppMenuItemBase.getPSAppMenuItemId() == null;
            }
            case 67: {
                return pSAppMenuItemBase.getPSAppMenuItemName() == null;
            }
            case 68: {
                return pSAppMenuItemBase.getPSAppMenuName() == null;
            }
            case 69: {
                return pSAppMenuItemBase.getPSDEId() == null;
            }
            case 70: {
                return pSAppMenuItemBase.getPSDELogicId() == null;
            }
            case 71: {
                return pSAppMenuItemBase.getPSDELogicName() == null;
            }
            case 72: {
                return pSAppMenuItemBase.getPSDEUIActionId() == null;
            }
            case 73: {
                return pSAppMenuItemBase.getPSDEUIActionName() == null;
            }
            case 74: {
                return pSAppMenuItemBase.getPSSysAppId() == null;
            }
            case 75: {
                return pSAppMenuItemBase.getPSSysCssId() == null;
            }
            case 76: {
                return pSAppMenuItemBase.getPSSysCssName() == null;
            }
            case 77: {
                return pSAppMenuItemBase.getPSSysImageId() == null;
            }
            case 78: {
                return pSAppMenuItemBase.getPSSysImageName() == null;
            }
            case 79: {
                return pSAppMenuItemBase.getPSSysPFPluginId() == null;
            }
            case 80: {
                return pSAppMenuItemBase.getPSSysPFPluginName() == null;
            }
            case 81: {
                return pSAppMenuItemBase.getPSSysResourceId() == null;
            }
            case 82: {
                return pSAppMenuItemBase.getPSSysResourceName() == null;
            }
            case 83: {
                return pSAppMenuItemBase.getPSSysUniResId() == null;
            }
            case 84: {
                return pSAppMenuItemBase.getPSSysUniResName() == null;
            }
            case 85: {
                return pSAppMenuItemBase.getRawContent() == null;
            }
            case 86: {
                return pSAppMenuItemBase.getRawCssStyle() == null;
            }
            case 87: {
                return pSAppMenuItemBase.getRefPSAppMenuId() == null;
            }
            case 88: {
                return pSAppMenuItemBase.getRefPSAppMenuName() == null;
            }
            case 89: {
                return pSAppMenuItemBase.getSpanFlag() == null;
            }
            case 90: {
                return pSAppMenuItemBase.getTemplateMode() == null;
            }
            case 91: {
                return pSAppMenuItemBase.getTipPSLanResId() == null;
            }
            case 92: {
                return pSAppMenuItemBase.getTipPSLanResName() == null;
            }
            case 93: {
                return pSAppMenuItemBase.getTitleBarCloseMode() == null;
            }
            case 94: {
                return pSAppMenuItemBase.getToggleMode() == null;
            }
            case 95: {
                return pSAppMenuItemBase.getTooltipInfo() == null;
            }
            case 96: {
                return pSAppMenuItemBase.getUpdateDate() == null;
            }
            case 97: {
                return pSAppMenuItemBase.getUpdateMan() == null;
            }
            case 98: {
                return pSAppMenuItemBase.getUserParams() == null;
            }
            case 99: {
                return pSAppMenuItemBase.getUserTag() == null;
            }
            case 100: {
                return pSAppMenuItemBase.getUserTag2() == null;
            }
            case 101: {
                return pSAppMenuItemBase.getVAlignSelf() == null;
            }
            case 102: {
                return pSAppMenuItemBase.getWidth() == null;
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
        return PSAppMenuItemBase.contains(this, n);
    }

    private static boolean contains(PSAppMenuItemBase pSAppMenuItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppMenuItemBase.isActionLevelDirty();
            }
            case 1: {
                return pSAppMenuItemBase.isAMItemTypeDirty();
            }
            case 2: {
                return pSAppMenuItemBase.isBL_PosDirty();
            }
            case 3: {
                return pSAppMenuItemBase.isBorderStyleDirty();
            }
            case 4: {
                return pSAppMenuItemBase.isBtnActionTypeDirty();
            }
            case 5: {
                return pSAppMenuItemBase.isCapPSLanResIdDirty();
            }
            case 6: {
                return pSAppMenuItemBase.isCapPSLanResNameDirty();
            }
            case 7: {
                return pSAppMenuItemBase.isCaptionDirty();
            }
            case 8: {
                return pSAppMenuItemBase.isCol_LGDirty();
            }
            case 9: {
                return pSAppMenuItemBase.isCol_LG_OSDirty();
            }
            case 10: {
                return pSAppMenuItemBase.isCol_MDDirty();
            }
            case 11: {
                return pSAppMenuItemBase.isCol_MD_OSDirty();
            }
            case 12: {
                return pSAppMenuItemBase.isCol_SMDirty();
            }
            case 13: {
                return pSAppMenuItemBase.isCol_SM_OSDirty();
            }
            case 14: {
                return pSAppMenuItemBase.isCol_XSDirty();
            }
            case 15: {
                return pSAppMenuItemBase.isCol_XS_OSDirty();
            }
            case 16: {
                return pSAppMenuItemBase.isContentTypeDirty();
            }
            case 17: {
                return pSAppMenuItemBase.isCounterIdDirty();
            }
            case 18: {
                return pSAppMenuItemBase.isCounterModeDirty();
            }
            case 19: {
                return pSAppMenuItemBase.isCreateDateDirty();
            }
            case 20: {
                return pSAppMenuItemBase.isCreateManDirty();
            }
            case 21: {
                return pSAppMenuItemBase.isCssIdDirty();
            }
            case 22: {
                return pSAppMenuItemBase.isCustomCodeDirty();
            }
            case 23: {
                return pSAppMenuItemBase.isDataDirty();
            }
            case 24: {
                return pSAppMenuItemBase.isDisableCloseDirty();
            }
            case 25: {
                return pSAppMenuItemBase.isDynaClassDirty();
            }
            case 26: {
                return pSAppMenuItemBase.isDynaModelFlagDirty();
            }
            case 27: {
                return pSAppMenuItemBase.isEnableModeDirty();
            }
            case 28: {
                return pSAppMenuItemBase.isExpandDirty();
            }
            case 29: {
                return pSAppMenuItemBase.isFillerObjDirty();
            }
            case 30: {
                return pSAppMenuItemBase.isFlexAlignDirty();
            }
            case 31: {
                return pSAppMenuItemBase.isFlexBasisDirty();
            }
            case 32: {
                return pSAppMenuItemBase.isFlexDirDirty();
            }
            case 33: {
                return pSAppMenuItemBase.isFlexGrowDirty();
            }
            case 34: {
                return pSAppMenuItemBase.isFlexShrinkDirty();
            }
            case 35: {
                return pSAppMenuItemBase.isFlexVAlignDirty();
            }
            case 36: {
                return pSAppMenuItemBase.isHAlignSelfDirty();
            }
            case 37: {
                return pSAppMenuItemBase.isHeightDirty();
            }
            case 38: {
                return pSAppMenuItemBase.isHiddenItemDirty();
            }
            case 39: {
                return pSAppMenuItemBase.isHIdeSideBarDirty();
            }
            case 40: {
                return pSAppMenuItemBase.isHtmlContentDirty();
            }
            case 41: {
                return pSAppMenuItemBase.isHtmlPageUrlDirty();
            }
            case 42: {
                return pSAppMenuItemBase.isInformTagDirty();
            }
            case 43: {
                return pSAppMenuItemBase.isInformTag2Dirty();
            }
            case 44: {
                return pSAppMenuItemBase.isItemStyleDirty();
            }
            case 45: {
                return pSAppMenuItemBase.isItemStyleTextDirty();
            }
            case 46: {
                return pSAppMenuItemBase.isLayoutModeDirty();
            }
            case 47: {
                return pSAppMenuItemBase.isLevelTagDirty();
            }
            case 48: {
                return pSAppMenuItemBase.isLevelValueDirty();
            }
            case 49: {
                return pSAppMenuItemBase.isMemoDirty();
            }
            case 50: {
                return pSAppMenuItemBase.isMenuItemStateDirty();
            }
            case 51: {
                return pSAppMenuItemBase.isOpenDefaultDirty();
            }
            case 52: {
                return pSAppMenuItemBase.isOpenPSAppViewIdDirty();
            }
            case 53: {
                return pSAppMenuItemBase.isOpenPSAppViewNameDirty();
            }
            case 54: {
                return pSAppMenuItemBase.isOrderValueDirty();
            }
            case 55: {
                return pSAppMenuItemBase.isPPSAppMenuItemIdDirty();
            }
            case 56: {
                return pSAppMenuItemBase.isPPSAppMenuItemNameDirty();
            }
            case 57: {
                return pSAppMenuItemBase.isPredefinedTypeDirty();
            }
            case 58: {
                return pSAppMenuItemBase.isPredefinedTypeParamDirty();
            }
            case 59: {
                return pSAppMenuItemBase.isPredefinedTypeTextDirty();
            }
            case 60: {
                return pSAppMenuItemBase.isPreviewHtmlDirty();
            }
            case 61: {
                return pSAppMenuItemBase.isPSAppFuncIdDirty();
            }
            case 62: {
                return pSAppMenuItemBase.isPSAppFuncNameDirty();
            }
            case 63: {
                return pSAppMenuItemBase.isPSAppLocalDEIdDirty();
            }
            case 64: {
                return pSAppMenuItemBase.isPSAppLocalDENameDirty();
            }
            case 65: {
                return pSAppMenuItemBase.isPSAppMenuIdDirty();
            }
            case 66: {
                return pSAppMenuItemBase.isPSAppMenuItemIdDirty();
            }
            case 67: {
                return pSAppMenuItemBase.isPSAppMenuItemNameDirty();
            }
            case 68: {
                return pSAppMenuItemBase.isPSAppMenuNameDirty();
            }
            case 69: {
                return pSAppMenuItemBase.isPSDEIdDirty();
            }
            case 70: {
                return pSAppMenuItemBase.isPSDELogicIdDirty();
            }
            case 71: {
                return pSAppMenuItemBase.isPSDELogicNameDirty();
            }
            case 72: {
                return pSAppMenuItemBase.isPSDEUIActionIdDirty();
            }
            case 73: {
                return pSAppMenuItemBase.isPSDEUIActionNameDirty();
            }
            case 74: {
                return pSAppMenuItemBase.isPSSysAppIdDirty();
            }
            case 75: {
                return pSAppMenuItemBase.isPSSysCssIdDirty();
            }
            case 76: {
                return pSAppMenuItemBase.isPSSysCssNameDirty();
            }
            case 77: {
                return pSAppMenuItemBase.isPSSysImageIdDirty();
            }
            case 78: {
                return pSAppMenuItemBase.isPSSysImageNameDirty();
            }
            case 79: {
                return pSAppMenuItemBase.isPSSysPFPluginIdDirty();
            }
            case 80: {
                return pSAppMenuItemBase.isPSSysPFPluginNameDirty();
            }
            case 81: {
                return pSAppMenuItemBase.isPSSysResourceIdDirty();
            }
            case 82: {
                return pSAppMenuItemBase.isPSSysResourceNameDirty();
            }
            case 83: {
                return pSAppMenuItemBase.isPSSysUniResIdDirty();
            }
            case 84: {
                return pSAppMenuItemBase.isPSSysUniResNameDirty();
            }
            case 85: {
                return pSAppMenuItemBase.isRawContentDirty();
            }
            case 86: {
                return pSAppMenuItemBase.isRawCssStyleDirty();
            }
            case 87: {
                return pSAppMenuItemBase.isRefPSAppMenuIdDirty();
            }
            case 88: {
                return pSAppMenuItemBase.isRefPSAppMenuNameDirty();
            }
            case 89: {
                return pSAppMenuItemBase.isSpanFlagDirty();
            }
            case 90: {
                return pSAppMenuItemBase.isTemplateModeDirty();
            }
            case 91: {
                return pSAppMenuItemBase.isTipPSLanResIdDirty();
            }
            case 92: {
                return pSAppMenuItemBase.isTipPSLanResNameDirty();
            }
            case 93: {
                return pSAppMenuItemBase.isTitleBarCloseModeDirty();
            }
            case 94: {
                return pSAppMenuItemBase.isToggleModeDirty();
            }
            case 95: {
                return pSAppMenuItemBase.isTooltipInfoDirty();
            }
            case 96: {
                return pSAppMenuItemBase.isUpdateDateDirty();
            }
            case 97: {
                return pSAppMenuItemBase.isUpdateManDirty();
            }
            case 98: {
                return pSAppMenuItemBase.isUserParamsDirty();
            }
            case 99: {
                return pSAppMenuItemBase.isUserTagDirty();
            }
            case 100: {
                return pSAppMenuItemBase.isUserTag2Dirty();
            }
            case 101: {
                return pSAppMenuItemBase.isVAlignSelfDirty();
            }
            case 102: {
                return pSAppMenuItemBase.isWidthDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppMenuItemBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppMenuItemBase pSAppMenuItemBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppMenuItemBase.getActionLevel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionlevel", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getActionLevel()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getAMItemType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"amitemtype", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getAMItemType()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getBL_Pos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bl_pos", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getBL_Pos()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getBorderStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"borderstyle", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getBorderStyle()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getBtnActionType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"btnactiontype", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getBtnActionType()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getCapPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresid", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getCapPSLanResId()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getCapPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresname", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getCapPSLanResName()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"caption", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getCaption()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getCol_LG() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"col_lg", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getCol_LG()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getCol_LG_OS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"col_lg_os", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getCol_LG_OS()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getCol_MD() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"col_md", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getCol_MD()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getCol_MD_OS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"col_md_os", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getCol_MD_OS()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getCol_SM() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"col_sm", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getCol_SM()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getCol_SM_OS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"col_sm_os", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getCol_SM_OS()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getCol_XS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"col_xs", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getCol_XS()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getCol_XS_OS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"col_xs_os", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getCol_XS_OS()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getContentType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contenttype", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getContentType()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getCounterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"counterid", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getCounterId()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getCounterMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"countermode", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getCounterMode()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cssid", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getCssId()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"data", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getData()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getDisableClose() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"disableclose", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getDisableClose()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getDynaClass() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynaclass", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getDynaClass()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getEnableMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablemode", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getEnableMode()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getExpand() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expand", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getExpand()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getFillerObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fillerobj", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getFillerObj()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getFlexAlign() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"flexalign", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getFlexAlign()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getFlexBasis() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"flexbasis", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getFlexBasis()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getFlexDir() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"flexdir", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getFlexDir()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getFlexGrow() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"flexgrow", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getFlexGrow()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getFlexShrink() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"flexshrink", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getFlexShrink()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getFlexVAlign() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"flexvalign", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getFlexVAlign()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getHAlignSelf() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"halignself", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getHAlignSelf()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"height", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getHeight()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getHiddenItem() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hiddenitem", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getHiddenItem()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getHIdeSideBar() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hidesidebar", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getHIdeSideBar()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getHtmlContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"htmlcontent", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getHtmlContent()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getHtmlPageUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"htmlpageurl", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getHtmlPageUrl()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getInformTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"informtag", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getInformTag()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getInformTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"informtag2", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getInformTag2()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getItemStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemstyle", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getItemStyle()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getItemStyleText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemstyletext", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getItemStyleText()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getLayoutMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"layoutmode", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getLayoutMode()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getLevelTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"leveltag", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getLevelTag()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getLevelValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"levelvalue", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getLevelValue()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getMemo()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getMenuItemState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"menuitemstate", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getMenuItemState()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getOpenDefault() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"opendefault", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getOpenDefault()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getOpenPSAppViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"openpsappviewid", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getOpenPSAppViewId()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getOpenPSAppViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"openpsappviewname", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getOpenPSAppViewName()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getPPSAppMenuItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsappmenuitemid", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getPPSAppMenuItemId()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getPPSAppMenuItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsappmenuitemname", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getPPSAppMenuItemName()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getPredefinedType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"predefinedtype", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getPredefinedType()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getPredefinedTypeParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"predefinedtypeparam", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getPredefinedTypeParam()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getPredefinedTypeText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"predefinedtypetext", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getPredefinedTypeText()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getPreviewHtml() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"previewhtml", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getPreviewHtml()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getPSAppFuncId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappfuncid", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getPSAppFuncId()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getPSAppFuncName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappfuncname", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getPSAppFuncName()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getPSAppLocalDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapplocaldeid", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getPSAppLocalDEId()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getPSAppLocalDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapplocaldename", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getPSAppLocalDEName()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getPSAppMenuId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmenuid", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getPSAppMenuId()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getPSAppMenuItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmenuitemid", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getPSAppMenuItemId()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getPSAppMenuItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmenuitemname", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getPSAppMenuItemName()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getPSAppMenuName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmenuname", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getPSAppMenuName()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicid", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getPSDELogicId()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicname", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getPSDELogicName()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getPSDEUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionid", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getPSDEUIActionId()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getPSDEUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionname", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getPSDEUIActionName()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssid", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getPSSysCssId()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssname", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getPSSysCssName()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getPSSysImageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimageid", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getPSSysImageId()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getPSSysImageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimagename", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getPSSysImageName()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getPSSysResourceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysresourceid", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getPSSysResourceId()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getPSSysResourceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysresourcename", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getPSSysResourceName()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getPSSysUniResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuniresid", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getPSSysUniResId()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getPSSysUniResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuniresname", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getPSSysUniResName()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getRawContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rawcontent", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getRawContent()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getRawCssStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rawcssstyle", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getRawCssStyle()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getRefPSAppMenuId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsappmenuid", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getRefPSAppMenuId()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getRefPSAppMenuName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsappmenuname", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getRefPSAppMenuName()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getSpanFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"spanflag", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getSpanFlag()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getTemplateMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templatemode", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getTemplateMode()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getTipPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tippslanresid", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getTipPSLanResId()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getTipPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tippslanresname", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getTipPSLanResName()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getTitleBarCloseMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"titlebarclosemode", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getTitleBarCloseMode()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getToggleMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"togglemode", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getToggleMode()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getTooltipInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tooltipinfo", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getTooltipInfo()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getUserParams()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getUserTag()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getVAlignSelf() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valignself", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getVAlignSelf()), (boolean)false);
        }
        if (bl || pSAppMenuItemBase.getWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"width", (Object)PSAppMenuItemBase.getJSONValue((Object)pSAppMenuItemBase.getWidth()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppMenuItemBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppMenuItemBase pSAppMenuItemBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppMenuItemBase.getActionLevel() != null) {
            object = pSAppMenuItemBase.getActionLevel();
            xmlNode.setAttribute(FIELD_ACTIONLEVEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppMenuItemBase.getAMItemType() != null) {
            object = pSAppMenuItemBase.getAMItemType();
            xmlNode.setAttribute(FIELD_AMITEMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getBL_Pos() != null) {
            object = pSAppMenuItemBase.getBL_Pos();
            xmlNode.setAttribute(FIELD_BL_POS, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getBorderStyle() != null) {
            object = pSAppMenuItemBase.getBorderStyle();
            xmlNode.setAttribute(FIELD_BORDERSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getBtnActionType() != null) {
            object = pSAppMenuItemBase.getBtnActionType();
            xmlNode.setAttribute(FIELD_BTNACTIONTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getCapPSLanResId() != null) {
            object = pSAppMenuItemBase.getCapPSLanResId();
            xmlNode.setAttribute(FIELD_CAPPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getCapPSLanResName() != null) {
            object = pSAppMenuItemBase.getCapPSLanResName();
            xmlNode.setAttribute(FIELD_CAPPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getCaption() != null) {
            object = pSAppMenuItemBase.getCaption();
            xmlNode.setAttribute(FIELD_CAPTION, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getCol_LG() != null) {
            object = pSAppMenuItemBase.getCol_LG();
            xmlNode.setAttribute(FIELD_COL_LG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppMenuItemBase.getCol_LG_OS() != null) {
            object = pSAppMenuItemBase.getCol_LG_OS();
            xmlNode.setAttribute(FIELD_COL_LG_OS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppMenuItemBase.getCol_MD() != null) {
            object = pSAppMenuItemBase.getCol_MD();
            xmlNode.setAttribute(FIELD_COL_MD, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppMenuItemBase.getCol_MD_OS() != null) {
            object = pSAppMenuItemBase.getCol_MD_OS();
            xmlNode.setAttribute(FIELD_COL_MD_OS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppMenuItemBase.getCol_SM() != null) {
            object = pSAppMenuItemBase.getCol_SM();
            xmlNode.setAttribute(FIELD_COL_SM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppMenuItemBase.getCol_SM_OS() != null) {
            object = pSAppMenuItemBase.getCol_SM_OS();
            xmlNode.setAttribute(FIELD_COL_SM_OS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppMenuItemBase.getCol_XS() != null) {
            object = pSAppMenuItemBase.getCol_XS();
            xmlNode.setAttribute(FIELD_COL_XS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppMenuItemBase.getCol_XS_OS() != null) {
            object = pSAppMenuItemBase.getCol_XS_OS();
            xmlNode.setAttribute(FIELD_COL_XS_OS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppMenuItemBase.getContentType() != null) {
            object = pSAppMenuItemBase.getContentType();
            xmlNode.setAttribute(FIELD_CONTENTTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getCounterId() != null) {
            object = pSAppMenuItemBase.getCounterId();
            xmlNode.setAttribute(FIELD_COUNTERID, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getCounterMode() != null) {
            object = pSAppMenuItemBase.getCounterMode();
            xmlNode.setAttribute(FIELD_COUNTERMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppMenuItemBase.getCreateDate() != null) {
            object = pSAppMenuItemBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppMenuItemBase.getCreateMan() != null) {
            object = pSAppMenuItemBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getCssId() != null) {
            object = pSAppMenuItemBase.getCssId();
            xmlNode.setAttribute(FIELD_CSSID, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getCustomCode() != null) {
            object = pSAppMenuItemBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getData() != null) {
            object = pSAppMenuItemBase.getData();
            xmlNode.setAttribute(FIELD_DATA, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getDisableClose() != null) {
            object = pSAppMenuItemBase.getDisableClose();
            xmlNode.setAttribute(FIELD_DISABLECLOSE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppMenuItemBase.getDynaClass() != null) {
            object = pSAppMenuItemBase.getDynaClass();
            xmlNode.setAttribute(FIELD_DYNACLASS, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getDynaModelFlag() != null) {
            object = pSAppMenuItemBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppMenuItemBase.getEnableMode() != null) {
            object = pSAppMenuItemBase.getEnableMode();
            xmlNode.setAttribute(FIELD_ENABLEMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppMenuItemBase.getExpand() != null) {
            object = pSAppMenuItemBase.getExpand();
            xmlNode.setAttribute(FIELD_EXPAND, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppMenuItemBase.getFillerObj() != null) {
            object = pSAppMenuItemBase.getFillerObj();
            xmlNode.setAttribute(FIELD_FILLEROBJ, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getFlexAlign() != null) {
            object = pSAppMenuItemBase.getFlexAlign();
            xmlNode.setAttribute(FIELD_FLEXALIGN, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getFlexBasis() != null) {
            object = pSAppMenuItemBase.getFlexBasis();
            xmlNode.setAttribute(FIELD_FLEXBASIS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppMenuItemBase.getFlexDir() != null) {
            object = pSAppMenuItemBase.getFlexDir();
            xmlNode.setAttribute(FIELD_FLEXDIR, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getFlexGrow() != null) {
            object = pSAppMenuItemBase.getFlexGrow();
            xmlNode.setAttribute(FIELD_FLEXGROW, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppMenuItemBase.getFlexShrink() != null) {
            object = pSAppMenuItemBase.getFlexShrink();
            xmlNode.setAttribute(FIELD_FLEXSHRINK, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppMenuItemBase.getFlexVAlign() != null) {
            object = pSAppMenuItemBase.getFlexVAlign();
            xmlNode.setAttribute(FIELD_FLEXVALIGN, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getHAlignSelf() != null) {
            object = pSAppMenuItemBase.getHAlignSelf();
            xmlNode.setAttribute(FIELD_HALIGNSELF, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getHeight() != null) {
            object = pSAppMenuItemBase.getHeight();
            xmlNode.setAttribute(FIELD_HEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppMenuItemBase.getHiddenItem() != null) {
            object = pSAppMenuItemBase.getHiddenItem();
            xmlNode.setAttribute(FIELD_HIDDENITEM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppMenuItemBase.getHIdeSideBar() != null) {
            object = pSAppMenuItemBase.getHIdeSideBar();
            xmlNode.setAttribute(FIELD_HIDESIDEBAR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppMenuItemBase.getHtmlContent() != null) {
            object = pSAppMenuItemBase.getHtmlContent();
            xmlNode.setAttribute(FIELD_HTMLCONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getHtmlPageUrl() != null) {
            object = pSAppMenuItemBase.getHtmlPageUrl();
            xmlNode.setAttribute(FIELD_HTMLPAGEURL, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getInformTag() != null) {
            object = pSAppMenuItemBase.getInformTag();
            xmlNode.setAttribute(FIELD_INFORMTAG, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getInformTag2() != null) {
            object = pSAppMenuItemBase.getInformTag2();
            xmlNode.setAttribute(FIELD_INFORMTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getItemStyle() != null) {
            object = pSAppMenuItemBase.getItemStyle();
            xmlNode.setAttribute(FIELD_ITEMSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getItemStyleText() != null) {
            object = pSAppMenuItemBase.getItemStyleText();
            xmlNode.setAttribute(FIELD_ITEMSTYLETEXT, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getLayoutMode() != null) {
            object = pSAppMenuItemBase.getLayoutMode();
            xmlNode.setAttribute(FIELD_LAYOUTMODE, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getLevelTag() != null) {
            object = pSAppMenuItemBase.getLevelTag();
            xmlNode.setAttribute(FIELD_LEVELTAG, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getLevelValue() != null) {
            object = pSAppMenuItemBase.getLevelValue();
            xmlNode.setAttribute(FIELD_LEVELVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppMenuItemBase.getMemo() != null) {
            object = pSAppMenuItemBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getMenuItemState() != null) {
            object = pSAppMenuItemBase.getMenuItemState();
            xmlNode.setAttribute(FIELD_MENUITEMSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppMenuItemBase.getOpenDefault() != null) {
            object = pSAppMenuItemBase.getOpenDefault();
            xmlNode.setAttribute(FIELD_OPENDEFAULT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppMenuItemBase.getOpenPSAppViewId() != null) {
            object = pSAppMenuItemBase.getOpenPSAppViewId();
            xmlNode.setAttribute(FIELD_OPENPSAPPVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getOpenPSAppViewName() != null) {
            object = pSAppMenuItemBase.getOpenPSAppViewName();
            xmlNode.setAttribute(FIELD_OPENPSAPPVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getOrderValue() != null) {
            object = pSAppMenuItemBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppMenuItemBase.getPPSAppMenuItemId() != null) {
            object = pSAppMenuItemBase.getPPSAppMenuItemId();
            xmlNode.setAttribute(FIELD_PPSAPPMENUITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getPPSAppMenuItemName() != null) {
            object = pSAppMenuItemBase.getPPSAppMenuItemName();
            xmlNode.setAttribute(FIELD_PPSAPPMENUITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getPredefinedType() != null) {
            object = pSAppMenuItemBase.getPredefinedType();
            xmlNode.setAttribute(FIELD_PREDEFINEDTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getPredefinedTypeParam() != null) {
            object = pSAppMenuItemBase.getPredefinedTypeParam();
            xmlNode.setAttribute(FIELD_PREDEFINEDTYPEPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getPredefinedTypeText() != null) {
            object = pSAppMenuItemBase.getPredefinedTypeText();
            xmlNode.setAttribute(FIELD_PREDEFINEDTYPETEXT, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getPreviewHtml() != null) {
            object = pSAppMenuItemBase.getPreviewHtml();
            xmlNode.setAttribute(FIELD_PREVIEWHTML, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getPSAppFuncId() != null) {
            object = pSAppMenuItemBase.getPSAppFuncId();
            xmlNode.setAttribute(FIELD_PSAPPFUNCID, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getPSAppFuncName() != null) {
            object = pSAppMenuItemBase.getPSAppFuncName();
            xmlNode.setAttribute(FIELD_PSAPPFUNCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getPSAppLocalDEId() != null) {
            object = pSAppMenuItemBase.getPSAppLocalDEId();
            xmlNode.setAttribute(FIELD_PSAPPLOCALDEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getPSAppLocalDEName() != null) {
            object = pSAppMenuItemBase.getPSAppLocalDEName();
            xmlNode.setAttribute(FIELD_PSAPPLOCALDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getPSAppMenuId() != null) {
            object = pSAppMenuItemBase.getPSAppMenuId();
            xmlNode.setAttribute(FIELD_PSAPPMENUID, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getPSAppMenuItemId() != null) {
            object = pSAppMenuItemBase.getPSAppMenuItemId();
            xmlNode.setAttribute(FIELD_PSAPPMENUITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getPSAppMenuItemName() != null) {
            object = pSAppMenuItemBase.getPSAppMenuItemName();
            xmlNode.setAttribute(FIELD_PSAPPMENUITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getPSAppMenuName() != null) {
            object = pSAppMenuItemBase.getPSAppMenuName();
            xmlNode.setAttribute(FIELD_PSAPPMENUNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getPSDEId() != null) {
            object = pSAppMenuItemBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getPSDELogicId() != null) {
            object = pSAppMenuItemBase.getPSDELogicId();
            xmlNode.setAttribute(FIELD_PSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getPSDELogicName() != null) {
            object = pSAppMenuItemBase.getPSDELogicName();
            xmlNode.setAttribute(FIELD_PSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getPSDEUIActionId() != null) {
            object = pSAppMenuItemBase.getPSDEUIActionId();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getPSDEUIActionName() != null) {
            object = pSAppMenuItemBase.getPSDEUIActionName();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getPSSysAppId() != null) {
            object = pSAppMenuItemBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getPSSysCssId() != null) {
            object = pSAppMenuItemBase.getPSSysCssId();
            xmlNode.setAttribute(FIELD_PSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getPSSysCssName() != null) {
            object = pSAppMenuItemBase.getPSSysCssName();
            xmlNode.setAttribute(FIELD_PSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getPSSysImageId() != null) {
            object = pSAppMenuItemBase.getPSSysImageId();
            xmlNode.setAttribute(FIELD_PSSYSIMAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getPSSysImageName() != null) {
            object = pSAppMenuItemBase.getPSSysImageName();
            xmlNode.setAttribute(FIELD_PSSYSIMAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getPSSysPFPluginId() != null) {
            object = pSAppMenuItemBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getPSSysPFPluginName() != null) {
            object = pSAppMenuItemBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getPSSysResourceId() != null) {
            object = pSAppMenuItemBase.getPSSysResourceId();
            xmlNode.setAttribute(FIELD_PSSYSRESOURCEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getPSSysResourceName() != null) {
            object = pSAppMenuItemBase.getPSSysResourceName();
            xmlNode.setAttribute(FIELD_PSSYSRESOURCENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getPSSysUniResId() != null) {
            object = pSAppMenuItemBase.getPSSysUniResId();
            xmlNode.setAttribute(FIELD_PSSYSUNIRESID, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getPSSysUniResName() != null) {
            object = pSAppMenuItemBase.getPSSysUniResName();
            xmlNode.setAttribute(FIELD_PSSYSUNIRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getRawContent() != null) {
            object = pSAppMenuItemBase.getRawContent();
            xmlNode.setAttribute(FIELD_RAWCONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getRawCssStyle() != null) {
            object = pSAppMenuItemBase.getRawCssStyle();
            xmlNode.setAttribute(FIELD_RAWCSSSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getRefPSAppMenuId() != null) {
            object = pSAppMenuItemBase.getRefPSAppMenuId();
            xmlNode.setAttribute(FIELD_REFPSAPPMENUID, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getRefPSAppMenuName() != null) {
            object = pSAppMenuItemBase.getRefPSAppMenuName();
            xmlNode.setAttribute(FIELD_REFPSAPPMENUNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getSpanFlag() != null) {
            object = pSAppMenuItemBase.getSpanFlag();
            xmlNode.setAttribute(FIELD_SPANFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppMenuItemBase.getTemplateMode() != null) {
            object = pSAppMenuItemBase.getTemplateMode();
            xmlNode.setAttribute(FIELD_TEMPLATEMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppMenuItemBase.getTipPSLanResId() != null) {
            object = pSAppMenuItemBase.getTipPSLanResId();
            xmlNode.setAttribute(FIELD_TIPPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getTipPSLanResName() != null) {
            object = pSAppMenuItemBase.getTipPSLanResName();
            xmlNode.setAttribute(FIELD_TIPPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getTitleBarCloseMode() != null) {
            object = pSAppMenuItemBase.getTitleBarCloseMode();
            xmlNode.setAttribute(FIELD_TITLEBARCLOSEMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppMenuItemBase.getToggleMode() != null) {
            object = pSAppMenuItemBase.getToggleMode();
            xmlNode.setAttribute(FIELD_TOGGLEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getTooltipInfo() != null) {
            object = pSAppMenuItemBase.getTooltipInfo();
            xmlNode.setAttribute(FIELD_TOOLTIPINFO, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getUpdateDate() != null) {
            object = pSAppMenuItemBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppMenuItemBase.getUpdateMan() != null) {
            object = pSAppMenuItemBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getUserParams() != null) {
            object = pSAppMenuItemBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getUserTag() != null) {
            object = pSAppMenuItemBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getUserTag2() != null) {
            object = pSAppMenuItemBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getVAlignSelf() != null) {
            object = pSAppMenuItemBase.getVAlignSelf();
            xmlNode.setAttribute(FIELD_VALIGNSELF, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuItemBase.getWidth() != null) {
            object = pSAppMenuItemBase.getWidth();
            xmlNode.setAttribute(FIELD_WIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppMenuItemBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppMenuItemBase pSAppMenuItemBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppMenuItemBase.isActionLevelDirty() && (bl || pSAppMenuItemBase.getActionLevel() != null)) {
            iDataObject.set(FIELD_ACTIONLEVEL, (Object)pSAppMenuItemBase.getActionLevel());
        }
        if (pSAppMenuItemBase.isAMItemTypeDirty() && (bl || pSAppMenuItemBase.getAMItemType() != null)) {
            iDataObject.set(FIELD_AMITEMTYPE, (Object)pSAppMenuItemBase.getAMItemType());
        }
        if (pSAppMenuItemBase.isBL_PosDirty() && (bl || pSAppMenuItemBase.getBL_Pos() != null)) {
            iDataObject.set(FIELD_BL_POS, (Object)pSAppMenuItemBase.getBL_Pos());
        }
        if (pSAppMenuItemBase.isBorderStyleDirty() && (bl || pSAppMenuItemBase.getBorderStyle() != null)) {
            iDataObject.set(FIELD_BORDERSTYLE, (Object)pSAppMenuItemBase.getBorderStyle());
        }
        if (pSAppMenuItemBase.isBtnActionTypeDirty() && (bl || pSAppMenuItemBase.getBtnActionType() != null)) {
            iDataObject.set(FIELD_BTNACTIONTYPE, (Object)pSAppMenuItemBase.getBtnActionType());
        }
        if (pSAppMenuItemBase.isCapPSLanResIdDirty() && (bl || pSAppMenuItemBase.getCapPSLanResId() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESID, (Object)pSAppMenuItemBase.getCapPSLanResId());
        }
        if (pSAppMenuItemBase.isCapPSLanResNameDirty() && (bl || pSAppMenuItemBase.getCapPSLanResName() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESNAME, (Object)pSAppMenuItemBase.getCapPSLanResName());
        }
        if (pSAppMenuItemBase.isCaptionDirty() && (bl || pSAppMenuItemBase.getCaption() != null)) {
            iDataObject.set(FIELD_CAPTION, (Object)pSAppMenuItemBase.getCaption());
        }
        if (pSAppMenuItemBase.isCol_LGDirty() && (bl || pSAppMenuItemBase.getCol_LG() != null)) {
            iDataObject.set(FIELD_COL_LG, (Object)pSAppMenuItemBase.getCol_LG());
        }
        if (pSAppMenuItemBase.isCol_LG_OSDirty() && (bl || pSAppMenuItemBase.getCol_LG_OS() != null)) {
            iDataObject.set(FIELD_COL_LG_OS, (Object)pSAppMenuItemBase.getCol_LG_OS());
        }
        if (pSAppMenuItemBase.isCol_MDDirty() && (bl || pSAppMenuItemBase.getCol_MD() != null)) {
            iDataObject.set(FIELD_COL_MD, (Object)pSAppMenuItemBase.getCol_MD());
        }
        if (pSAppMenuItemBase.isCol_MD_OSDirty() && (bl || pSAppMenuItemBase.getCol_MD_OS() != null)) {
            iDataObject.set(FIELD_COL_MD_OS, (Object)pSAppMenuItemBase.getCol_MD_OS());
        }
        if (pSAppMenuItemBase.isCol_SMDirty() && (bl || pSAppMenuItemBase.getCol_SM() != null)) {
            iDataObject.set(FIELD_COL_SM, (Object)pSAppMenuItemBase.getCol_SM());
        }
        if (pSAppMenuItemBase.isCol_SM_OSDirty() && (bl || pSAppMenuItemBase.getCol_SM_OS() != null)) {
            iDataObject.set(FIELD_COL_SM_OS, (Object)pSAppMenuItemBase.getCol_SM_OS());
        }
        if (pSAppMenuItemBase.isCol_XSDirty() && (bl || pSAppMenuItemBase.getCol_XS() != null)) {
            iDataObject.set(FIELD_COL_XS, (Object)pSAppMenuItemBase.getCol_XS());
        }
        if (pSAppMenuItemBase.isCol_XS_OSDirty() && (bl || pSAppMenuItemBase.getCol_XS_OS() != null)) {
            iDataObject.set(FIELD_COL_XS_OS, (Object)pSAppMenuItemBase.getCol_XS_OS());
        }
        if (pSAppMenuItemBase.isContentTypeDirty() && (bl || pSAppMenuItemBase.getContentType() != null)) {
            iDataObject.set(FIELD_CONTENTTYPE, (Object)pSAppMenuItemBase.getContentType());
        }
        if (pSAppMenuItemBase.isCounterIdDirty() && (bl || pSAppMenuItemBase.getCounterId() != null)) {
            iDataObject.set(FIELD_COUNTERID, (Object)pSAppMenuItemBase.getCounterId());
        }
        if (pSAppMenuItemBase.isCounterModeDirty() && (bl || pSAppMenuItemBase.getCounterMode() != null)) {
            iDataObject.set(FIELD_COUNTERMODE, (Object)pSAppMenuItemBase.getCounterMode());
        }
        if (pSAppMenuItemBase.isCreateDateDirty() && (bl || pSAppMenuItemBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppMenuItemBase.getCreateDate());
        }
        if (pSAppMenuItemBase.isCreateManDirty() && (bl || pSAppMenuItemBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppMenuItemBase.getCreateMan());
        }
        if (pSAppMenuItemBase.isCssIdDirty() && (bl || pSAppMenuItemBase.getCssId() != null)) {
            iDataObject.set(FIELD_CSSID, (Object)pSAppMenuItemBase.getCssId());
        }
        if (pSAppMenuItemBase.isCustomCodeDirty() && (bl || pSAppMenuItemBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSAppMenuItemBase.getCustomCode());
        }
        if (pSAppMenuItemBase.isDataDirty() && (bl || pSAppMenuItemBase.getData() != null)) {
            iDataObject.set(FIELD_DATA, (Object)pSAppMenuItemBase.getData());
        }
        if (pSAppMenuItemBase.isDisableCloseDirty() && (bl || pSAppMenuItemBase.getDisableClose() != null)) {
            iDataObject.set(FIELD_DISABLECLOSE, (Object)pSAppMenuItemBase.getDisableClose());
        }
        if (pSAppMenuItemBase.isDynaClassDirty() && (bl || pSAppMenuItemBase.getDynaClass() != null)) {
            iDataObject.set(FIELD_DYNACLASS, (Object)pSAppMenuItemBase.getDynaClass());
        }
        if (pSAppMenuItemBase.isDynaModelFlagDirty() && (bl || pSAppMenuItemBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSAppMenuItemBase.getDynaModelFlag());
        }
        if (pSAppMenuItemBase.isEnableModeDirty() && (bl || pSAppMenuItemBase.getEnableMode() != null)) {
            iDataObject.set(FIELD_ENABLEMODE, (Object)pSAppMenuItemBase.getEnableMode());
        }
        if (pSAppMenuItemBase.isExpandDirty() && (bl || pSAppMenuItemBase.getExpand() != null)) {
            iDataObject.set(FIELD_EXPAND, (Object)pSAppMenuItemBase.getExpand());
        }
        if (pSAppMenuItemBase.isFillerObjDirty() && (bl || pSAppMenuItemBase.getFillerObj() != null)) {
            iDataObject.set(FIELD_FILLEROBJ, (Object)pSAppMenuItemBase.getFillerObj());
        }
        if (pSAppMenuItemBase.isFlexAlignDirty() && (bl || pSAppMenuItemBase.getFlexAlign() != null)) {
            iDataObject.set(FIELD_FLEXALIGN, (Object)pSAppMenuItemBase.getFlexAlign());
        }
        if (pSAppMenuItemBase.isFlexBasisDirty() && (bl || pSAppMenuItemBase.getFlexBasis() != null)) {
            iDataObject.set(FIELD_FLEXBASIS, (Object)pSAppMenuItemBase.getFlexBasis());
        }
        if (pSAppMenuItemBase.isFlexDirDirty() && (bl || pSAppMenuItemBase.getFlexDir() != null)) {
            iDataObject.set(FIELD_FLEXDIR, (Object)pSAppMenuItemBase.getFlexDir());
        }
        if (pSAppMenuItemBase.isFlexGrowDirty() && (bl || pSAppMenuItemBase.getFlexGrow() != null)) {
            iDataObject.set(FIELD_FLEXGROW, (Object)pSAppMenuItemBase.getFlexGrow());
        }
        if (pSAppMenuItemBase.isFlexShrinkDirty() && (bl || pSAppMenuItemBase.getFlexShrink() != null)) {
            iDataObject.set(FIELD_FLEXSHRINK, (Object)pSAppMenuItemBase.getFlexShrink());
        }
        if (pSAppMenuItemBase.isFlexVAlignDirty() && (bl || pSAppMenuItemBase.getFlexVAlign() != null)) {
            iDataObject.set(FIELD_FLEXVALIGN, (Object)pSAppMenuItemBase.getFlexVAlign());
        }
        if (pSAppMenuItemBase.isHAlignSelfDirty() && (bl || pSAppMenuItemBase.getHAlignSelf() != null)) {
            iDataObject.set(FIELD_HALIGNSELF, (Object)pSAppMenuItemBase.getHAlignSelf());
        }
        if (pSAppMenuItemBase.isHeightDirty() && (bl || pSAppMenuItemBase.getHeight() != null)) {
            iDataObject.set(FIELD_HEIGHT, (Object)pSAppMenuItemBase.getHeight());
        }
        if (pSAppMenuItemBase.isHiddenItemDirty() && (bl || pSAppMenuItemBase.getHiddenItem() != null)) {
            iDataObject.set(FIELD_HIDDENITEM, (Object)pSAppMenuItemBase.getHiddenItem());
        }
        if (pSAppMenuItemBase.isHIdeSideBarDirty() && (bl || pSAppMenuItemBase.getHIdeSideBar() != null)) {
            iDataObject.set(FIELD_HIDESIDEBAR, (Object)pSAppMenuItemBase.getHIdeSideBar());
        }
        if (pSAppMenuItemBase.isHtmlContentDirty() && (bl || pSAppMenuItemBase.getHtmlContent() != null)) {
            iDataObject.set(FIELD_HTMLCONTENT, (Object)pSAppMenuItemBase.getHtmlContent());
        }
        if (pSAppMenuItemBase.isHtmlPageUrlDirty() && (bl || pSAppMenuItemBase.getHtmlPageUrl() != null)) {
            iDataObject.set(FIELD_HTMLPAGEURL, (Object)pSAppMenuItemBase.getHtmlPageUrl());
        }
        if (pSAppMenuItemBase.isInformTagDirty() && (bl || pSAppMenuItemBase.getInformTag() != null)) {
            iDataObject.set(FIELD_INFORMTAG, (Object)pSAppMenuItemBase.getInformTag());
        }
        if (pSAppMenuItemBase.isInformTag2Dirty() && (bl || pSAppMenuItemBase.getInformTag2() != null)) {
            iDataObject.set(FIELD_INFORMTAG2, (Object)pSAppMenuItemBase.getInformTag2());
        }
        if (pSAppMenuItemBase.isItemStyleDirty() && (bl || pSAppMenuItemBase.getItemStyle() != null)) {
            iDataObject.set(FIELD_ITEMSTYLE, (Object)pSAppMenuItemBase.getItemStyle());
        }
        if (pSAppMenuItemBase.isItemStyleTextDirty() && (bl || pSAppMenuItemBase.getItemStyleText() != null)) {
            iDataObject.set(FIELD_ITEMSTYLETEXT, (Object)pSAppMenuItemBase.getItemStyleText());
        }
        if (pSAppMenuItemBase.isLayoutModeDirty() && (bl || pSAppMenuItemBase.getLayoutMode() != null)) {
            iDataObject.set(FIELD_LAYOUTMODE, (Object)pSAppMenuItemBase.getLayoutMode());
        }
        if (pSAppMenuItemBase.isLevelTagDirty() && (bl || pSAppMenuItemBase.getLevelTag() != null)) {
            iDataObject.set(FIELD_LEVELTAG, (Object)pSAppMenuItemBase.getLevelTag());
        }
        if (pSAppMenuItemBase.isLevelValueDirty() && (bl || pSAppMenuItemBase.getLevelValue() != null)) {
            iDataObject.set(FIELD_LEVELVALUE, (Object)pSAppMenuItemBase.getLevelValue());
        }
        if (pSAppMenuItemBase.isMemoDirty() && (bl || pSAppMenuItemBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSAppMenuItemBase.getMemo());
        }
        if (pSAppMenuItemBase.isMenuItemStateDirty() && (bl || pSAppMenuItemBase.getMenuItemState() != null)) {
            iDataObject.set(FIELD_MENUITEMSTATE, (Object)pSAppMenuItemBase.getMenuItemState());
        }
        if (pSAppMenuItemBase.isOpenDefaultDirty() && (bl || pSAppMenuItemBase.getOpenDefault() != null)) {
            iDataObject.set(FIELD_OPENDEFAULT, (Object)pSAppMenuItemBase.getOpenDefault());
        }
        if (pSAppMenuItemBase.isOpenPSAppViewIdDirty() && (bl || pSAppMenuItemBase.getOpenPSAppViewId() != null)) {
            iDataObject.set(FIELD_OPENPSAPPVIEWID, (Object)pSAppMenuItemBase.getOpenPSAppViewId());
        }
        if (pSAppMenuItemBase.isOpenPSAppViewNameDirty() && (bl || pSAppMenuItemBase.getOpenPSAppViewName() != null)) {
            iDataObject.set(FIELD_OPENPSAPPVIEWNAME, (Object)pSAppMenuItemBase.getOpenPSAppViewName());
        }
        if (pSAppMenuItemBase.isOrderValueDirty() && (bl || pSAppMenuItemBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSAppMenuItemBase.getOrderValue());
        }
        if (pSAppMenuItemBase.isPPSAppMenuItemIdDirty() && (bl || pSAppMenuItemBase.getPPSAppMenuItemId() != null)) {
            iDataObject.set(FIELD_PPSAPPMENUITEMID, (Object)pSAppMenuItemBase.getPPSAppMenuItemId());
        }
        if (pSAppMenuItemBase.isPPSAppMenuItemNameDirty() && (bl || pSAppMenuItemBase.getPPSAppMenuItemName() != null)) {
            iDataObject.set(FIELD_PPSAPPMENUITEMNAME, (Object)pSAppMenuItemBase.getPPSAppMenuItemName());
        }
        if (pSAppMenuItemBase.isPredefinedTypeDirty() && (bl || pSAppMenuItemBase.getPredefinedType() != null)) {
            iDataObject.set(FIELD_PREDEFINEDTYPE, (Object)pSAppMenuItemBase.getPredefinedType());
        }
        if (pSAppMenuItemBase.isPredefinedTypeParamDirty() && (bl || pSAppMenuItemBase.getPredefinedTypeParam() != null)) {
            iDataObject.set(FIELD_PREDEFINEDTYPEPARAM, (Object)pSAppMenuItemBase.getPredefinedTypeParam());
        }
        if (pSAppMenuItemBase.isPredefinedTypeTextDirty() && (bl || pSAppMenuItemBase.getPredefinedTypeText() != null)) {
            iDataObject.set(FIELD_PREDEFINEDTYPETEXT, (Object)pSAppMenuItemBase.getPredefinedTypeText());
        }
        if (pSAppMenuItemBase.isPreviewHtmlDirty() && (bl || pSAppMenuItemBase.getPreviewHtml() != null)) {
            iDataObject.set(FIELD_PREVIEWHTML, (Object)pSAppMenuItemBase.getPreviewHtml());
        }
        if (pSAppMenuItemBase.isPSAppFuncIdDirty() && (bl || pSAppMenuItemBase.getPSAppFuncId() != null)) {
            iDataObject.set(FIELD_PSAPPFUNCID, (Object)pSAppMenuItemBase.getPSAppFuncId());
        }
        if (pSAppMenuItemBase.isPSAppFuncNameDirty() && (bl || pSAppMenuItemBase.getPSAppFuncName() != null)) {
            iDataObject.set(FIELD_PSAPPFUNCNAME, (Object)pSAppMenuItemBase.getPSAppFuncName());
        }
        if (pSAppMenuItemBase.isPSAppLocalDEIdDirty() && (bl || pSAppMenuItemBase.getPSAppLocalDEId() != null)) {
            iDataObject.set(FIELD_PSAPPLOCALDEID, (Object)pSAppMenuItemBase.getPSAppLocalDEId());
        }
        if (pSAppMenuItemBase.isPSAppLocalDENameDirty() && (bl || pSAppMenuItemBase.getPSAppLocalDEName() != null)) {
            iDataObject.set(FIELD_PSAPPLOCALDENAME, (Object)pSAppMenuItemBase.getPSAppLocalDEName());
        }
        if (pSAppMenuItemBase.isPSAppMenuIdDirty() && (bl || pSAppMenuItemBase.getPSAppMenuId() != null)) {
            iDataObject.set(FIELD_PSAPPMENUID, (Object)pSAppMenuItemBase.getPSAppMenuId());
        }
        if (pSAppMenuItemBase.isPSAppMenuItemIdDirty() && (bl || pSAppMenuItemBase.getPSAppMenuItemId() != null)) {
            iDataObject.set(FIELD_PSAPPMENUITEMID, (Object)pSAppMenuItemBase.getPSAppMenuItemId());
        }
        if (pSAppMenuItemBase.isPSAppMenuItemNameDirty() && (bl || pSAppMenuItemBase.getPSAppMenuItemName() != null)) {
            iDataObject.set(FIELD_PSAPPMENUITEMNAME, (Object)pSAppMenuItemBase.getPSAppMenuItemName());
        }
        if (pSAppMenuItemBase.isPSAppMenuNameDirty() && (bl || pSAppMenuItemBase.getPSAppMenuName() != null)) {
            iDataObject.set(FIELD_PSAPPMENUNAME, (Object)pSAppMenuItemBase.getPSAppMenuName());
        }
        if (pSAppMenuItemBase.isPSDEIdDirty() && (bl || pSAppMenuItemBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSAppMenuItemBase.getPSDEId());
        }
        if (pSAppMenuItemBase.isPSDELogicIdDirty() && (bl || pSAppMenuItemBase.getPSDELogicId() != null)) {
            iDataObject.set(FIELD_PSDELOGICID, (Object)pSAppMenuItemBase.getPSDELogicId());
        }
        if (pSAppMenuItemBase.isPSDELogicNameDirty() && (bl || pSAppMenuItemBase.getPSDELogicName() != null)) {
            iDataObject.set(FIELD_PSDELOGICNAME, (Object)pSAppMenuItemBase.getPSDELogicName());
        }
        if (pSAppMenuItemBase.isPSDEUIActionIdDirty() && (bl || pSAppMenuItemBase.getPSDEUIActionId() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONID, (Object)pSAppMenuItemBase.getPSDEUIActionId());
        }
        if (pSAppMenuItemBase.isPSDEUIActionNameDirty() && (bl || pSAppMenuItemBase.getPSDEUIActionName() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONNAME, (Object)pSAppMenuItemBase.getPSDEUIActionName());
        }
        if (pSAppMenuItemBase.isPSSysAppIdDirty() && (bl || pSAppMenuItemBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSAppMenuItemBase.getPSSysAppId());
        }
        if (pSAppMenuItemBase.isPSSysCssIdDirty() && (bl || pSAppMenuItemBase.getPSSysCssId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSID, (Object)pSAppMenuItemBase.getPSSysCssId());
        }
        if (pSAppMenuItemBase.isPSSysCssNameDirty() && (bl || pSAppMenuItemBase.getPSSysCssName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSNAME, (Object)pSAppMenuItemBase.getPSSysCssName());
        }
        if (pSAppMenuItemBase.isPSSysImageIdDirty() && (bl || pSAppMenuItemBase.getPSSysImageId() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGEID, (Object)pSAppMenuItemBase.getPSSysImageId());
        }
        if (pSAppMenuItemBase.isPSSysImageNameDirty() && (bl || pSAppMenuItemBase.getPSSysImageName() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGENAME, (Object)pSAppMenuItemBase.getPSSysImageName());
        }
        if (pSAppMenuItemBase.isPSSysPFPluginIdDirty() && (bl || pSAppMenuItemBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSAppMenuItemBase.getPSSysPFPluginId());
        }
        if (pSAppMenuItemBase.isPSSysPFPluginNameDirty() && (bl || pSAppMenuItemBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSAppMenuItemBase.getPSSysPFPluginName());
        }
        if (pSAppMenuItemBase.isPSSysResourceIdDirty() && (bl || pSAppMenuItemBase.getPSSysResourceId() != null)) {
            iDataObject.set(FIELD_PSSYSRESOURCEID, (Object)pSAppMenuItemBase.getPSSysResourceId());
        }
        if (pSAppMenuItemBase.isPSSysResourceNameDirty() && (bl || pSAppMenuItemBase.getPSSysResourceName() != null)) {
            iDataObject.set(FIELD_PSSYSRESOURCENAME, (Object)pSAppMenuItemBase.getPSSysResourceName());
        }
        if (pSAppMenuItemBase.isPSSysUniResIdDirty() && (bl || pSAppMenuItemBase.getPSSysUniResId() != null)) {
            iDataObject.set(FIELD_PSSYSUNIRESID, (Object)pSAppMenuItemBase.getPSSysUniResId());
        }
        if (pSAppMenuItemBase.isPSSysUniResNameDirty() && (bl || pSAppMenuItemBase.getPSSysUniResName() != null)) {
            iDataObject.set(FIELD_PSSYSUNIRESNAME, (Object)pSAppMenuItemBase.getPSSysUniResName());
        }
        if (pSAppMenuItemBase.isRawContentDirty() && (bl || pSAppMenuItemBase.getRawContent() != null)) {
            iDataObject.set(FIELD_RAWCONTENT, (Object)pSAppMenuItemBase.getRawContent());
        }
        if (pSAppMenuItemBase.isRawCssStyleDirty() && (bl || pSAppMenuItemBase.getRawCssStyle() != null)) {
            iDataObject.set(FIELD_RAWCSSSTYLE, (Object)pSAppMenuItemBase.getRawCssStyle());
        }
        if (pSAppMenuItemBase.isRefPSAppMenuIdDirty() && (bl || pSAppMenuItemBase.getRefPSAppMenuId() != null)) {
            iDataObject.set(FIELD_REFPSAPPMENUID, (Object)pSAppMenuItemBase.getRefPSAppMenuId());
        }
        if (pSAppMenuItemBase.isRefPSAppMenuNameDirty() && (bl || pSAppMenuItemBase.getRefPSAppMenuName() != null)) {
            iDataObject.set(FIELD_REFPSAPPMENUNAME, (Object)pSAppMenuItemBase.getRefPSAppMenuName());
        }
        if (pSAppMenuItemBase.isSpanFlagDirty() && (bl || pSAppMenuItemBase.getSpanFlag() != null)) {
            iDataObject.set(FIELD_SPANFLAG, (Object)pSAppMenuItemBase.getSpanFlag());
        }
        if (pSAppMenuItemBase.isTemplateModeDirty() && (bl || pSAppMenuItemBase.getTemplateMode() != null)) {
            iDataObject.set(FIELD_TEMPLATEMODE, (Object)pSAppMenuItemBase.getTemplateMode());
        }
        if (pSAppMenuItemBase.isTipPSLanResIdDirty() && (bl || pSAppMenuItemBase.getTipPSLanResId() != null)) {
            iDataObject.set(FIELD_TIPPSLANRESID, (Object)pSAppMenuItemBase.getTipPSLanResId());
        }
        if (pSAppMenuItemBase.isTipPSLanResNameDirty() && (bl || pSAppMenuItemBase.getTipPSLanResName() != null)) {
            iDataObject.set(FIELD_TIPPSLANRESNAME, (Object)pSAppMenuItemBase.getTipPSLanResName());
        }
        if (pSAppMenuItemBase.isTitleBarCloseModeDirty() && (bl || pSAppMenuItemBase.getTitleBarCloseMode() != null)) {
            iDataObject.set(FIELD_TITLEBARCLOSEMODE, (Object)pSAppMenuItemBase.getTitleBarCloseMode());
        }
        if (pSAppMenuItemBase.isToggleModeDirty() && (bl || pSAppMenuItemBase.getToggleMode() != null)) {
            iDataObject.set(FIELD_TOGGLEMODE, (Object)pSAppMenuItemBase.getToggleMode());
        }
        if (pSAppMenuItemBase.isTooltipInfoDirty() && (bl || pSAppMenuItemBase.getTooltipInfo() != null)) {
            iDataObject.set(FIELD_TOOLTIPINFO, (Object)pSAppMenuItemBase.getTooltipInfo());
        }
        if (pSAppMenuItemBase.isUpdateDateDirty() && (bl || pSAppMenuItemBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppMenuItemBase.getUpdateDate());
        }
        if (pSAppMenuItemBase.isUpdateManDirty() && (bl || pSAppMenuItemBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppMenuItemBase.getUpdateMan());
        }
        if (pSAppMenuItemBase.isUserParamsDirty() && (bl || pSAppMenuItemBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSAppMenuItemBase.getUserParams());
        }
        if (pSAppMenuItemBase.isUserTagDirty() && (bl || pSAppMenuItemBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSAppMenuItemBase.getUserTag());
        }
        if (pSAppMenuItemBase.isUserTag2Dirty() && (bl || pSAppMenuItemBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSAppMenuItemBase.getUserTag2());
        }
        if (pSAppMenuItemBase.isVAlignSelfDirty() && (bl || pSAppMenuItemBase.getVAlignSelf() != null)) {
            iDataObject.set(FIELD_VALIGNSELF, (Object)pSAppMenuItemBase.getVAlignSelf());
        }
        if (pSAppMenuItemBase.isWidthDirty() && (bl || pSAppMenuItemBase.getWidth() != null)) {
            iDataObject.set(FIELD_WIDTH, (Object)pSAppMenuItemBase.getWidth());
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
        return PSAppMenuItemBase.remove(this, n);
    }

    private static boolean remove(PSAppMenuItemBase pSAppMenuItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSAppMenuItemBase.resetActionLevel();
                return true;
            }
            case 1: {
                pSAppMenuItemBase.resetAMItemType();
                return true;
            }
            case 2: {
                pSAppMenuItemBase.resetBL_Pos();
                return true;
            }
            case 3: {
                pSAppMenuItemBase.resetBorderStyle();
                return true;
            }
            case 4: {
                pSAppMenuItemBase.resetBtnActionType();
                return true;
            }
            case 5: {
                pSAppMenuItemBase.resetCapPSLanResId();
                return true;
            }
            case 6: {
                pSAppMenuItemBase.resetCapPSLanResName();
                return true;
            }
            case 7: {
                pSAppMenuItemBase.resetCaption();
                return true;
            }
            case 8: {
                pSAppMenuItemBase.resetCol_LG();
                return true;
            }
            case 9: {
                pSAppMenuItemBase.resetCol_LG_OS();
                return true;
            }
            case 10: {
                pSAppMenuItemBase.resetCol_MD();
                return true;
            }
            case 11: {
                pSAppMenuItemBase.resetCol_MD_OS();
                return true;
            }
            case 12: {
                pSAppMenuItemBase.resetCol_SM();
                return true;
            }
            case 13: {
                pSAppMenuItemBase.resetCol_SM_OS();
                return true;
            }
            case 14: {
                pSAppMenuItemBase.resetCol_XS();
                return true;
            }
            case 15: {
                pSAppMenuItemBase.resetCol_XS_OS();
                return true;
            }
            case 16: {
                pSAppMenuItemBase.resetContentType();
                return true;
            }
            case 17: {
                pSAppMenuItemBase.resetCounterId();
                return true;
            }
            case 18: {
                pSAppMenuItemBase.resetCounterMode();
                return true;
            }
            case 19: {
                pSAppMenuItemBase.resetCreateDate();
                return true;
            }
            case 20: {
                pSAppMenuItemBase.resetCreateMan();
                return true;
            }
            case 21: {
                pSAppMenuItemBase.resetCssId();
                return true;
            }
            case 22: {
                pSAppMenuItemBase.resetCustomCode();
                return true;
            }
            case 23: {
                pSAppMenuItemBase.resetData();
                return true;
            }
            case 24: {
                pSAppMenuItemBase.resetDisableClose();
                return true;
            }
            case 25: {
                pSAppMenuItemBase.resetDynaClass();
                return true;
            }
            case 26: {
                pSAppMenuItemBase.resetDynaModelFlag();
                return true;
            }
            case 27: {
                pSAppMenuItemBase.resetEnableMode();
                return true;
            }
            case 28: {
                pSAppMenuItemBase.resetExpand();
                return true;
            }
            case 29: {
                pSAppMenuItemBase.resetFillerObj();
                return true;
            }
            case 30: {
                pSAppMenuItemBase.resetFlexAlign();
                return true;
            }
            case 31: {
                pSAppMenuItemBase.resetFlexBasis();
                return true;
            }
            case 32: {
                pSAppMenuItemBase.resetFlexDir();
                return true;
            }
            case 33: {
                pSAppMenuItemBase.resetFlexGrow();
                return true;
            }
            case 34: {
                pSAppMenuItemBase.resetFlexShrink();
                return true;
            }
            case 35: {
                pSAppMenuItemBase.resetFlexVAlign();
                return true;
            }
            case 36: {
                pSAppMenuItemBase.resetHAlignSelf();
                return true;
            }
            case 37: {
                pSAppMenuItemBase.resetHeight();
                return true;
            }
            case 38: {
                pSAppMenuItemBase.resetHiddenItem();
                return true;
            }
            case 39: {
                pSAppMenuItemBase.resetHIdeSideBar();
                return true;
            }
            case 40: {
                pSAppMenuItemBase.resetHtmlContent();
                return true;
            }
            case 41: {
                pSAppMenuItemBase.resetHtmlPageUrl();
                return true;
            }
            case 42: {
                pSAppMenuItemBase.resetInformTag();
                return true;
            }
            case 43: {
                pSAppMenuItemBase.resetInformTag2();
                return true;
            }
            case 44: {
                pSAppMenuItemBase.resetItemStyle();
                return true;
            }
            case 45: {
                pSAppMenuItemBase.resetItemStyleText();
                return true;
            }
            case 46: {
                pSAppMenuItemBase.resetLayoutMode();
                return true;
            }
            case 47: {
                pSAppMenuItemBase.resetLevelTag();
                return true;
            }
            case 48: {
                pSAppMenuItemBase.resetLevelValue();
                return true;
            }
            case 49: {
                pSAppMenuItemBase.resetMemo();
                return true;
            }
            case 50: {
                pSAppMenuItemBase.resetMenuItemState();
                return true;
            }
            case 51: {
                pSAppMenuItemBase.resetOpenDefault();
                return true;
            }
            case 52: {
                pSAppMenuItemBase.resetOpenPSAppViewId();
                return true;
            }
            case 53: {
                pSAppMenuItemBase.resetOpenPSAppViewName();
                return true;
            }
            case 54: {
                pSAppMenuItemBase.resetOrderValue();
                return true;
            }
            case 55: {
                pSAppMenuItemBase.resetPPSAppMenuItemId();
                return true;
            }
            case 56: {
                pSAppMenuItemBase.resetPPSAppMenuItemName();
                return true;
            }
            case 57: {
                pSAppMenuItemBase.resetPredefinedType();
                return true;
            }
            case 58: {
                pSAppMenuItemBase.resetPredefinedTypeParam();
                return true;
            }
            case 59: {
                pSAppMenuItemBase.resetPredefinedTypeText();
                return true;
            }
            case 60: {
                pSAppMenuItemBase.resetPreviewHtml();
                return true;
            }
            case 61: {
                pSAppMenuItemBase.resetPSAppFuncId();
                return true;
            }
            case 62: {
                pSAppMenuItemBase.resetPSAppFuncName();
                return true;
            }
            case 63: {
                pSAppMenuItemBase.resetPSAppLocalDEId();
                return true;
            }
            case 64: {
                pSAppMenuItemBase.resetPSAppLocalDEName();
                return true;
            }
            case 65: {
                pSAppMenuItemBase.resetPSAppMenuId();
                return true;
            }
            case 66: {
                pSAppMenuItemBase.resetPSAppMenuItemId();
                return true;
            }
            case 67: {
                pSAppMenuItemBase.resetPSAppMenuItemName();
                return true;
            }
            case 68: {
                pSAppMenuItemBase.resetPSAppMenuName();
                return true;
            }
            case 69: {
                pSAppMenuItemBase.resetPSDEId();
                return true;
            }
            case 70: {
                pSAppMenuItemBase.resetPSDELogicId();
                return true;
            }
            case 71: {
                pSAppMenuItemBase.resetPSDELogicName();
                return true;
            }
            case 72: {
                pSAppMenuItemBase.resetPSDEUIActionId();
                return true;
            }
            case 73: {
                pSAppMenuItemBase.resetPSDEUIActionName();
                return true;
            }
            case 74: {
                pSAppMenuItemBase.resetPSSysAppId();
                return true;
            }
            case 75: {
                pSAppMenuItemBase.resetPSSysCssId();
                return true;
            }
            case 76: {
                pSAppMenuItemBase.resetPSSysCssName();
                return true;
            }
            case 77: {
                pSAppMenuItemBase.resetPSSysImageId();
                return true;
            }
            case 78: {
                pSAppMenuItemBase.resetPSSysImageName();
                return true;
            }
            case 79: {
                pSAppMenuItemBase.resetPSSysPFPluginId();
                return true;
            }
            case 80: {
                pSAppMenuItemBase.resetPSSysPFPluginName();
                return true;
            }
            case 81: {
                pSAppMenuItemBase.resetPSSysResourceId();
                return true;
            }
            case 82: {
                pSAppMenuItemBase.resetPSSysResourceName();
                return true;
            }
            case 83: {
                pSAppMenuItemBase.resetPSSysUniResId();
                return true;
            }
            case 84: {
                pSAppMenuItemBase.resetPSSysUniResName();
                return true;
            }
            case 85: {
                pSAppMenuItemBase.resetRawContent();
                return true;
            }
            case 86: {
                pSAppMenuItemBase.resetRawCssStyle();
                return true;
            }
            case 87: {
                pSAppMenuItemBase.resetRefPSAppMenuId();
                return true;
            }
            case 88: {
                pSAppMenuItemBase.resetRefPSAppMenuName();
                return true;
            }
            case 89: {
                pSAppMenuItemBase.resetSpanFlag();
                return true;
            }
            case 90: {
                pSAppMenuItemBase.resetTemplateMode();
                return true;
            }
            case 91: {
                pSAppMenuItemBase.resetTipPSLanResId();
                return true;
            }
            case 92: {
                pSAppMenuItemBase.resetTipPSLanResName();
                return true;
            }
            case 93: {
                pSAppMenuItemBase.resetTitleBarCloseMode();
                return true;
            }
            case 94: {
                pSAppMenuItemBase.resetToggleMode();
                return true;
            }
            case 95: {
                pSAppMenuItemBase.resetTooltipInfo();
                return true;
            }
            case 96: {
                pSAppMenuItemBase.resetUpdateDate();
                return true;
            }
            case 97: {
                pSAppMenuItemBase.resetUpdateMan();
                return true;
            }
            case 98: {
                pSAppMenuItemBase.resetUserParams();
                return true;
            }
            case 99: {
                pSAppMenuItemBase.resetUserTag();
                return true;
            }
            case 100: {
                pSAppMenuItemBase.resetUserTag2();
                return true;
            }
            case 101: {
                pSAppMenuItemBase.resetVAlignSelf();
                return true;
            }
            case 102: {
                pSAppMenuItemBase.resetWidth();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppFunc getPSAppFunc() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppFunc();
        }
        if (this.getPSAppFuncId() == null) {
            return null;
        }
        Integer n = this.objPSAppFuncLock;
        synchronized (n) {
            if (this.psappfunc != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppFuncId(), (Object)this.psappfunc.getPSAppFuncId()) != 0L) {
                this.psappfunc = null;
            }
            if (this.psappfunc == null) {
                PSAppFunc pSAppFunc = new PSAppFunc();
                pSAppFunc.setPSAppFuncId(this.getPSAppFuncId());
                PSAppFuncService pSAppFuncService = (PSAppFuncService)ServiceGlobal.getService(PSAppFuncService.class, (SessionFactory)this.getSessionFactory());
                pSAppFuncService.autoGet(pSAppFunc);
                this.psappfunc = pSAppFunc;
            }
            return this.psappfunc;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppLocalDE getPSAppLocalDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppLocalDE();
        }
        if (this.getPSAppLocalDEId() == null) {
            return null;
        }
        Integer n = this.objPSAppLocalDELock;
        synchronized (n) {
            if (this.psapplocalde != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppLocalDEId(), (Object)this.psapplocalde.getPSAppLocalDEId()) != 0L) {
                this.psapplocalde = null;
            }
            if (this.psapplocalde == null) {
                PSAppLocalDE pSAppLocalDE = new PSAppLocalDE();
                pSAppLocalDE.setPSAppLocalDEId(this.getPSAppLocalDEId());
                PSAppLocalDEService pSAppLocalDEService = (PSAppLocalDEService)ServiceGlobal.getService(PSAppLocalDEService.class, (SessionFactory)this.getSessionFactory());
                pSAppLocalDEService.autoGet(pSAppLocalDE);
                this.psapplocalde = pSAppLocalDE;
            }
            return this.psapplocalde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppMenuItem getPPSAppMenuItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSAppMenuItem();
        }
        if (this.getPPSAppMenuItemId() == null) {
            return null;
        }
        Integer n = this.objPPSAppMenuItemLock;
        synchronized (n) {
            if (this.ppsappmenuitem != null && DataTypeHelper.compare((int)25, (Object)this.getPPSAppMenuItemId(), (Object)this.ppsappmenuitem.getPSAppMenuItemId()) != 0L) {
                this.ppsappmenuitem = null;
            }
            if (this.ppsappmenuitem == null) {
                PSAppMenuItem pSAppMenuItem = new PSAppMenuItem();
                pSAppMenuItem.setPSAppMenuItemId(this.getPPSAppMenuItemId());
                PSAppMenuItemService pSAppMenuItemService = (PSAppMenuItemService)ServiceGlobal.getService(PSAppMenuItemService.class, (SessionFactory)this.getSessionFactory());
                pSAppMenuItemService.autoGet(pSAppMenuItem);
                this.ppsappmenuitem = pSAppMenuItem;
            }
            return this.ppsappmenuitem;
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
    public PSAppMenu getRefPSAppMenu() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSAppMenu();
        }
        if (this.getRefPSAppMenuId() == null) {
            return null;
        }
        Integer n = this.objRefPSAppMenuLock;
        synchronized (n) {
            if (this.refpsappmenu != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSAppMenuId(), (Object)this.refpsappmenu.getPSAppMenuId()) != 0L) {
                this.refpsappmenu = null;
            }
            if (this.refpsappmenu == null) {
                PSAppMenu pSAppMenu = new PSAppMenu();
                pSAppMenu.setPSAppMenuId(this.getRefPSAppMenuId());
                PSAppMenuService pSAppMenuService = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)this.getSessionFactory());
                pSAppMenuService.autoGet(pSAppMenu);
                this.refpsappmenu = pSAppMenu;
            }
            return this.refpsappmenu;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppView getOpenPSAppView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOpenPSAppView();
        }
        if (this.getOpenPSAppViewId() == null) {
            return null;
        }
        Integer n = this.objOpenPSAppViewLock;
        synchronized (n) {
            if (this.openpsappview != null && DataTypeHelper.compare((int)25, (Object)this.getOpenPSAppViewId(), (Object)this.openpsappview.getPSAppViewId()) != 0L) {
                this.openpsappview = null;
            }
            if (this.openpsappview == null) {
                PSAppView pSAppView = new PSAppView();
                pSAppView.setPSAppViewId(this.getOpenPSAppViewId());
                PSAppViewService pSAppViewService = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
                pSAppViewService.autoGet(pSAppView);
                this.openpsappview = pSAppView;
            }
            return this.openpsappview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDELogic getPSDELogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogic();
        }
        if (this.getPSDELogicId() == null) {
            return null;
        }
        Integer n = this.objPSDELogicLock;
        synchronized (n) {
            if (this.psdelogic != null && DataTypeHelper.compare((int)25, (Object)this.getPSDELogicId(), (Object)this.psdelogic.getPSDELogicId()) != 0L) {
                this.psdelogic = null;
            }
            if (this.psdelogic == null) {
                PSDELogic pSDELogic = new PSDELogic();
                pSDELogic.setPSDELogicId(this.getPSDELogicId());
                PSDELogicService pSDELogicService = (PSDELogicService)ServiceGlobal.getService(PSDELogicService.class, (SessionFactory)this.getSessionFactory());
                pSDELogicService.autoGet(pSDELogic);
                this.psdelogic = pSDELogic;
            }
            return this.psdelogic;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEUIAction getPSDEUIAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUIAction();
        }
        if (this.getPSDEUIActionId() == null) {
            return null;
        }
        Integer n = this.objPSDEUIActionLock;
        synchronized (n) {
            if (this.psdeuiaction != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEUIActionId(), (Object)this.psdeuiaction.getPSDEUIActionId()) != 0L) {
                this.psdeuiaction = null;
            }
            if (this.psdeuiaction == null) {
                PSDEUIAction pSDEUIAction = new PSDEUIAction();
                pSDEUIAction.setPSDEUIActionId(this.getPSDEUIActionId());
                PSDEUIActionService pSDEUIActionService = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEUIActionService.autoGet(pSDEUIAction);
                this.psdeuiaction = pSDEUIAction;
            }
            return this.psdeuiaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getCapPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCapPSLanRes();
        }
        if (this.getCapPSLanResId() == null) {
            return null;
        }
        Integer n = this.objCapPSLanResLock;
        synchronized (n) {
            if (this.cappslanres != null && DataTypeHelper.compare((int)25, (Object)this.getCapPSLanResId(), (Object)this.cappslanres.getPSLanguageResId()) != 0L) {
                this.cappslanres = null;
            }
            if (this.cappslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getCapPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet(pSLanguageRes);
                this.cappslanres = pSLanguageRes;
            }
            return this.cappslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getTipPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTipPSLanRes();
        }
        if (this.getTipPSLanResId() == null) {
            return null;
        }
        Integer n = this.objTipPSLanResLock;
        synchronized (n) {
            if (this.tippslanres != null && DataTypeHelper.compare((int)25, (Object)this.getTipPSLanResId(), (Object)this.tippslanres.getPSLanguageResId()) != 0L) {
                this.tippslanres = null;
            }
            if (this.tippslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getTipPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet(pSLanguageRes);
                this.tippslanres = pSLanguageRes;
            }
            return this.tippslanres;
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
                pSSysCssService.autoGet(pSSysCss);
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
                pSSysImageService.autoGet(pSSysImage);
                this.pssysimage = pSSysImage;
            }
            return this.pssysimage;
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
                pSSysPFPluginService.autoGet(pSSysPFPlugin);
                this.pssyspfplugin = pSSysPFPlugin;
            }
            return this.pssyspfplugin;
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
                pSSysResourceService.autoGet(pSSysResource);
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
                pSSysUniResService.autoGet(pSSysUniRes);
                this.pssysunires = pSSysUniRes;
            }
            return this.pssysunires;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSAppMenuItem> getPSAppMenuItems() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppMenuItems();
        }
        if (this.getPSAppMenuItemId() == null) {
            return null;
        }
        PSAppMenuItemService pSAppMenuItemService = (PSAppMenuItemService)ServiceGlobal.getService(PSAppMenuItemService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSAppMenuItemsLock;
        synchronized (n) {
            if (this.psappmenuitems == null) {
                this.psappmenuitems = pSAppMenuItemService.selectByPPSAppMenuItem(this);
            }
            return this.psappmenuitems;
        }
    }

    private PSAppMenuItemBase getProxyEntity() {
        return this.proxyPSAppMenuItemBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppMenuItemBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppMenuItemBase) {
            this.proxyPSAppMenuItemBase = (PSAppMenuItemBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppMenuItemService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACTIONLEVEL, 0);
        fieldIndexMap.put(FIELD_AMITEMTYPE, 1);
        fieldIndexMap.put(FIELD_BL_POS, 2);
        fieldIndexMap.put(FIELD_BORDERSTYLE, 3);
        fieldIndexMap.put(FIELD_BTNACTIONTYPE, 4);
        fieldIndexMap.put(FIELD_CAPPSLANRESID, 5);
        fieldIndexMap.put(FIELD_CAPPSLANRESNAME, 6);
        fieldIndexMap.put(FIELD_CAPTION, 7);
        fieldIndexMap.put(FIELD_COL_LG, 8);
        fieldIndexMap.put(FIELD_COL_LG_OS, 9);
        fieldIndexMap.put(FIELD_COL_MD, 10);
        fieldIndexMap.put(FIELD_COL_MD_OS, 11);
        fieldIndexMap.put(FIELD_COL_SM, 12);
        fieldIndexMap.put(FIELD_COL_SM_OS, 13);
        fieldIndexMap.put(FIELD_COL_XS, 14);
        fieldIndexMap.put(FIELD_COL_XS_OS, 15);
        fieldIndexMap.put(FIELD_CONTENTTYPE, 16);
        fieldIndexMap.put(FIELD_COUNTERID, 17);
        fieldIndexMap.put(FIELD_COUNTERMODE, 18);
        fieldIndexMap.put(FIELD_CREATEDATE, 19);
        fieldIndexMap.put(FIELD_CREATEMAN, 20);
        fieldIndexMap.put(FIELD_CSSID, 21);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 22);
        fieldIndexMap.put(FIELD_DATA, 23);
        fieldIndexMap.put(FIELD_DISABLECLOSE, 24);
        fieldIndexMap.put(FIELD_DYNACLASS, 25);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 26);
        fieldIndexMap.put(FIELD_ENABLEMODE, 27);
        fieldIndexMap.put(FIELD_EXPAND, 28);
        fieldIndexMap.put(FIELD_FILLEROBJ, 29);
        fieldIndexMap.put(FIELD_FLEXALIGN, 30);
        fieldIndexMap.put(FIELD_FLEXBASIS, 31);
        fieldIndexMap.put(FIELD_FLEXDIR, 32);
        fieldIndexMap.put(FIELD_FLEXGROW, 33);
        fieldIndexMap.put(FIELD_FLEXSHRINK, 34);
        fieldIndexMap.put(FIELD_FLEXVALIGN, 35);
        fieldIndexMap.put(FIELD_HALIGNSELF, 36);
        fieldIndexMap.put(FIELD_HEIGHT, 37);
        fieldIndexMap.put(FIELD_HIDDENITEM, 38);
        fieldIndexMap.put(FIELD_HIDESIDEBAR, 39);
        fieldIndexMap.put(FIELD_HTMLCONTENT, 40);
        fieldIndexMap.put(FIELD_HTMLPAGEURL, 41);
        fieldIndexMap.put(FIELD_INFORMTAG, 42);
        fieldIndexMap.put(FIELD_INFORMTAG2, 43);
        fieldIndexMap.put(FIELD_ITEMSTYLE, 44);
        fieldIndexMap.put(FIELD_ITEMSTYLETEXT, 45);
        fieldIndexMap.put(FIELD_LAYOUTMODE, 46);
        fieldIndexMap.put(FIELD_LEVELTAG, 47);
        fieldIndexMap.put(FIELD_LEVELVALUE, 48);
        fieldIndexMap.put(FIELD_MEMO, 49);
        fieldIndexMap.put(FIELD_MENUITEMSTATE, 50);
        fieldIndexMap.put(FIELD_OPENDEFAULT, 51);
        fieldIndexMap.put(FIELD_OPENPSAPPVIEWID, 52);
        fieldIndexMap.put(FIELD_OPENPSAPPVIEWNAME, 53);
        fieldIndexMap.put(FIELD_ORDERVALUE, 54);
        fieldIndexMap.put(FIELD_PPSAPPMENUITEMID, 55);
        fieldIndexMap.put(FIELD_PPSAPPMENUITEMNAME, 56);
        fieldIndexMap.put(FIELD_PREDEFINEDTYPE, 57);
        fieldIndexMap.put(FIELD_PREDEFINEDTYPEPARAM, 58);
        fieldIndexMap.put(FIELD_PREDEFINEDTYPETEXT, 59);
        fieldIndexMap.put(FIELD_PREVIEWHTML, 60);
        fieldIndexMap.put(FIELD_PSAPPFUNCID, 61);
        fieldIndexMap.put(FIELD_PSAPPFUNCNAME, 62);
        fieldIndexMap.put(FIELD_PSAPPLOCALDEID, 63);
        fieldIndexMap.put(FIELD_PSAPPLOCALDENAME, 64);
        fieldIndexMap.put(FIELD_PSAPPMENUID, 65);
        fieldIndexMap.put(FIELD_PSAPPMENUITEMID, 66);
        fieldIndexMap.put(FIELD_PSAPPMENUITEMNAME, 67);
        fieldIndexMap.put(FIELD_PSAPPMENUNAME, 68);
        fieldIndexMap.put(FIELD_PSDEID, 69);
        fieldIndexMap.put(FIELD_PSDELOGICID, 70);
        fieldIndexMap.put(FIELD_PSDELOGICNAME, 71);
        fieldIndexMap.put(FIELD_PSDEUIACTIONID, 72);
        fieldIndexMap.put(FIELD_PSDEUIACTIONNAME, 73);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 74);
        fieldIndexMap.put(FIELD_PSSYSCSSID, 75);
        fieldIndexMap.put(FIELD_PSSYSCSSNAME, 76);
        fieldIndexMap.put(FIELD_PSSYSIMAGEID, 77);
        fieldIndexMap.put(FIELD_PSSYSIMAGENAME, 78);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 79);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 80);
        fieldIndexMap.put(FIELD_PSSYSRESOURCEID, 81);
        fieldIndexMap.put(FIELD_PSSYSRESOURCENAME, 82);
        fieldIndexMap.put(FIELD_PSSYSUNIRESID, 83);
        fieldIndexMap.put(FIELD_PSSYSUNIRESNAME, 84);
        fieldIndexMap.put(FIELD_RAWCONTENT, 85);
        fieldIndexMap.put(FIELD_RAWCSSSTYLE, 86);
        fieldIndexMap.put(FIELD_REFPSAPPMENUID, 87);
        fieldIndexMap.put(FIELD_REFPSAPPMENUNAME, 88);
        fieldIndexMap.put(FIELD_SPANFLAG, 89);
        fieldIndexMap.put(FIELD_TEMPLATEMODE, 90);
        fieldIndexMap.put(FIELD_TIPPSLANRESID, 91);
        fieldIndexMap.put(FIELD_TIPPSLANRESNAME, 92);
        fieldIndexMap.put(FIELD_TITLEBARCLOSEMODE, 93);
        fieldIndexMap.put(FIELD_TOGGLEMODE, 94);
        fieldIndexMap.put(FIELD_TOOLTIPINFO, 95);
        fieldIndexMap.put(FIELD_UPDATEDATE, 96);
        fieldIndexMap.put(FIELD_UPDATEMAN, 97);
        fieldIndexMap.put(FIELD_USERPARAMS, 98);
        fieldIndexMap.put(FIELD_USERTAG, 99);
        fieldIndexMap.put(FIELD_USERTAG2, 100);
        fieldIndexMap.put(FIELD_VALIGNSELF, 101);
        fieldIndexMap.put(FIELD_WIDTH, 102);
    }
}

