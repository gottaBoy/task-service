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
package net.ibizsys.pscore.srv.dedesign.entity;

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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewService;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysResource;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.config.service.PSSysResourceService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETBItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbar;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETBItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPDTView;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniRes;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPDTViewService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDETBItemBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDETBItemBase.class);
    public static final String FIELD_ACTIONLEVEL = "ACTIONLEVEL";
    public static final String FIELD_BORDERSTYLE = "BORDERSTYLE";
    public static final String FIELD_BTNACTIONTYPE = "BTNACTIONTYPE";
    public static final String FIELD_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String FIELD_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String FIELD_CAPTION = "CAPTION";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CONTENTTYPE = "CONTENTTYPE";
    public static final String FIELD_COUNTERID = "COUNTERID";
    public static final String FIELD_COUNTERMODE = "COUNTERMODE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CSSID = "CSSID";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_DATA = "DATA";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_DEUACAP = "DEUACAP";
    public static final String FIELD_DYNACLASS = "DYNACLASS";
    public static final String FIELD_ENABLELOGIC = "ENABLELOGIC";
    public static final String FIELD_GROUPEXTRACTMODE = "GROUPEXTRACTMODE";
    public static final String FIELD_HEIGHT = "HEIGHT";
    public static final String FIELD_HIDDENITEM = "HIDDENITEM";
    public static final String FIELD_HTMLCONTENT = "HTMLCONTENT";
    public static final String FIELD_HTMLPAGEURL = "HTMLPAGEURL";
    public static final String FIELD_ITEMSTYLE = "ITEMSTYLE";
    public static final String FIELD_ITEMSTYLETEXT = "ITEMSTYLETEXT";
    public static final String FIELD_LEVELTAG = "LEVELTAG";
    public static final String FIELD_LEVELVALUE = "LEVELVALUE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_NOPRIVDM = "NOPRIVDM";
    public static final String FIELD_OPENPSAPPVIEWID = "OPENPSAPPVIEWID";
    public static final String FIELD_OPENPSAPPVIEWNAME = "OPENPSAPPVIEWNAME";
    public static final String FIELD_OPENPSDEVIEWID = "OPENPSDEVIEWID";
    public static final String FIELD_OPENPSDEVIEWNAME = "OPENPSDEVIEWNAME";
    public static final String FIELD_OPENPSSYSPDTVIEWID = "OPENPSSYSPDTVIEWID";
    public static final String FIELD_OPENPSSYSPDTVIEWNAME = "OPENPSSYSPDTVIEWNAME";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PPSDETBITEMID = "PPSDETBITEMID";
    public static final String FIELD_PPSDETBITEMNAME = "PPSDETBITEMNAME";
    public static final String FIELD_PREDEFINEDTYPE = "PREDEFINEDTYPE";
    public static final String FIELD_PREDEFINEDTYPETEXT = "PREDEFINEDTYPETEXT";
    public static final String FIELD_PREVIEWHTML = "PREVIEWHTML";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDELOGICID = "PSDELOGICID";
    public static final String FIELD_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String FIELD_PSDETBITEMID = "PSDETBITEMID";
    public static final String FIELD_PSDETBITEMNAME = "PSDETBITEMNAME";
    public static final String FIELD_PSDETOOLBARID = "PSDETOOLBARID";
    public static final String FIELD_PSDETOOLBARNAME = "PSDETOOLBARNAME";
    public static final String FIELD_PSDEUAGROUPID = "PSDEUAGROUPID";
    public static final String FIELD_PSDEUAGROUPNAME = "PSDEUAGROUPNAME";
    public static final String FIELD_PSDEUIACTIONID = "PSDEUIACTIONID";
    public static final String FIELD_PSDEUIACTIONNAME = "PSDEUIACTIONNAME";
    public static final String FIELD_PSSYSCSSID = "PSSYSCSSID";
    public static final String FIELD_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String FIELD_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String FIELD_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSRESOURCEID = "PSSYSRESOURCEID";
    public static final String FIELD_PSSYSRESOURCENAME = "PSSYSRESOURCENAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSUNIRESID = "PSSYSUNIRESID";
    public static final String FIELD_PSSYSUNIRESNAME = "PSSYSUNIRESNAME";
    public static final String FIELD_RAWCONTENT = "RAWCONTENT";
    public static final String FIELD_RAWCSSSTYLE = "RAWCSSSTYLE";
    public static final String FIELD_SHOWMODE = "SHOWMODE";
    public static final String FIELD_SPANFLAG = "SPANFLAG";
    public static final String FIELD_TBITEMTYPE = "TBITEMTYPE";
    public static final String FIELD_TEMPLATEMODE = "TEMPLATEMODE";
    public static final String FIELD_TIPPSLANRESID = "TIPPSLANRESID";
    public static final String FIELD_TIPPSLANRESNAME = "TIPPSLANRESNAME";
    public static final String FIELD_TOGGLEMODE = "TOGGLEMODE";
    public static final String FIELD_TOOLTIPINFO = "TOOLTIPINFO";
    public static final String FIELD_UIACTIONPARAMS = "UIACTIONPARAMS";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_VISIBLELOGIC = "VISIBLELOGIC";
    public static final String FIELD_WIDTH = "WIDTH";
    private static final int INDEX_ACTIONLEVEL = 0;
    private static final int INDEX_BORDERSTYLE = 1;
    private static final int INDEX_BTNACTIONTYPE = 2;
    private static final int INDEX_CAPPSLANRESID = 3;
    private static final int INDEX_CAPPSLANRESNAME = 4;
    private static final int INDEX_CAPTION = 5;
    private static final int INDEX_CODENAME = 6;
    private static final int INDEX_CONTENTTYPE = 7;
    private static final int INDEX_COUNTERID = 8;
    private static final int INDEX_COUNTERMODE = 9;
    private static final int INDEX_CREATEDATE = 10;
    private static final int INDEX_CREATEMAN = 11;
    private static final int INDEX_CSSID = 12;
    private static final int INDEX_CUSTOMCODE = 13;
    private static final int INDEX_DATA = 14;
    private static final int INDEX_DEFAULTFLAG = 15;
    private static final int INDEX_DEUACAP = 16;
    private static final int INDEX_DYNACLASS = 17;
    private static final int INDEX_ENABLELOGIC = 18;
    private static final int INDEX_GROUPEXTRACTMODE = 19;
    private static final int INDEX_HEIGHT = 20;
    private static final int INDEX_HIDDENITEM = 21;
    private static final int INDEX_HTMLCONTENT = 22;
    private static final int INDEX_HTMLPAGEURL = 23;
    private static final int INDEX_ITEMSTYLE = 24;
    private static final int INDEX_ITEMSTYLETEXT = 25;
    private static final int INDEX_LEVELTAG = 26;
    private static final int INDEX_LEVELVALUE = 27;
    private static final int INDEX_MEMO = 28;
    private static final int INDEX_NOPRIVDM = 29;
    private static final int INDEX_OPENPSAPPVIEWID = 30;
    private static final int INDEX_OPENPSAPPVIEWNAME = 31;
    private static final int INDEX_OPENPSDEVIEWID = 32;
    private static final int INDEX_OPENPSDEVIEWNAME = 33;
    private static final int INDEX_OPENPSSYSPDTVIEWID = 34;
    private static final int INDEX_OPENPSSYSPDTVIEWNAME = 35;
    private static final int INDEX_ORDERVALUE = 36;
    private static final int INDEX_PPSDETBITEMID = 37;
    private static final int INDEX_PPSDETBITEMNAME = 38;
    private static final int INDEX_PREDEFINEDTYPE = 39;
    private static final int INDEX_PREDEFINEDTYPETEXT = 40;
    private static final int INDEX_PREVIEWHTML = 41;
    private static final int INDEX_PSDEID = 42;
    private static final int INDEX_PSDELOGICID = 43;
    private static final int INDEX_PSDELOGICNAME = 44;
    private static final int INDEX_PSDETBITEMID = 45;
    private static final int INDEX_PSDETBITEMNAME = 46;
    private static final int INDEX_PSDETOOLBARID = 47;
    private static final int INDEX_PSDETOOLBARNAME = 48;
    private static final int INDEX_PSDEUAGROUPID = 49;
    private static final int INDEX_PSDEUAGROUPNAME = 50;
    private static final int INDEX_PSDEUIACTIONID = 51;
    private static final int INDEX_PSDEUIACTIONNAME = 52;
    private static final int INDEX_PSSYSCSSID = 53;
    private static final int INDEX_PSSYSCSSNAME = 54;
    private static final int INDEX_PSSYSIMAGEID = 55;
    private static final int INDEX_PSSYSIMAGENAME = 56;
    private static final int INDEX_PSSYSPFPLUGINID = 57;
    private static final int INDEX_PSSYSPFPLUGINNAME = 58;
    private static final int INDEX_PSSYSRESOURCEID = 59;
    private static final int INDEX_PSSYSRESOURCENAME = 60;
    private static final int INDEX_PSSYSTEMID = 61;
    private static final int INDEX_PSSYSUNIRESID = 62;
    private static final int INDEX_PSSYSUNIRESNAME = 63;
    private static final int INDEX_RAWCONTENT = 64;
    private static final int INDEX_RAWCSSSTYLE = 65;
    private static final int INDEX_SHOWMODE = 66;
    private static final int INDEX_SPANFLAG = 67;
    private static final int INDEX_TBITEMTYPE = 68;
    private static final int INDEX_TEMPLATEMODE = 69;
    private static final int INDEX_TIPPSLANRESID = 70;
    private static final int INDEX_TIPPSLANRESNAME = 71;
    private static final int INDEX_TOGGLEMODE = 72;
    private static final int INDEX_TOOLTIPINFO = 73;
    private static final int INDEX_UIACTIONPARAMS = 74;
    private static final int INDEX_UPDATEDATE = 75;
    private static final int INDEX_UPDATEMAN = 76;
    private static final int INDEX_USERPARAMS = 77;
    private static final int INDEX_USERTAG = 78;
    private static final int INDEX_USERTAG2 = 79;
    private static final int INDEX_VISIBLELOGIC = 80;
    private static final int INDEX_WIDTH = 81;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDETBItemBase proxyPSDETBItemBase = null;
    private boolean actionlevelDirtyFlag = false;
    private boolean borderstyleDirtyFlag = false;
    private boolean btnactiontypeDirtyFlag = false;
    private boolean cappslanresidDirtyFlag = false;
    private boolean cappslanresnameDirtyFlag = false;
    private boolean captionDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean contenttypeDirtyFlag = false;
    private boolean counteridDirtyFlag = false;
    private boolean countermodeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean cssidDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean dataDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean deuacapDirtyFlag = false;
    private boolean dynaclassDirtyFlag = false;
    private boolean enablelogicDirtyFlag = false;
    private boolean groupextractmodeDirtyFlag = false;
    private boolean heightDirtyFlag = false;
    private boolean hiddenitemDirtyFlag = false;
    private boolean htmlcontentDirtyFlag = false;
    private boolean htmlpageurlDirtyFlag = false;
    private boolean itemstyleDirtyFlag = false;
    private boolean itemstyletextDirtyFlag = false;
    private boolean leveltagDirtyFlag = false;
    private boolean levelvalueDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean noprivdmDirtyFlag = false;
    private boolean openpsappviewidDirtyFlag = false;
    private boolean openpsappviewnameDirtyFlag = false;
    private boolean openpsdeviewidDirtyFlag = false;
    private boolean openpsdeviewnameDirtyFlag = false;
    private boolean openpssyspdtviewidDirtyFlag = false;
    private boolean openpssyspdtviewnameDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean ppsdetbitemidDirtyFlag = false;
    private boolean ppsdetbitemnameDirtyFlag = false;
    private boolean predefinedtypeDirtyFlag = false;
    private boolean predefinedtypetextDirtyFlag = false;
    private boolean previewhtmlDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdelogicidDirtyFlag = false;
    private boolean psdelogicnameDirtyFlag = false;
    private boolean psdetbitemidDirtyFlag = false;
    private boolean psdetbitemnameDirtyFlag = false;
    private boolean psdetoolbaridDirtyFlag = false;
    private boolean psdetoolbarnameDirtyFlag = false;
    private boolean psdeuagroupidDirtyFlag = false;
    private boolean psdeuagroupnameDirtyFlag = false;
    private boolean psdeuiactionidDirtyFlag = false;
    private boolean psdeuiactionnameDirtyFlag = false;
    private boolean pssyscssidDirtyFlag = false;
    private boolean pssyscssnameDirtyFlag = false;
    private boolean pssysimageidDirtyFlag = false;
    private boolean pssysimagenameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssysresourceidDirtyFlag = false;
    private boolean pssysresourcenameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssysuniresidDirtyFlag = false;
    private boolean pssysuniresnameDirtyFlag = false;
    private boolean rawcontentDirtyFlag = false;
    private boolean rawcssstyleDirtyFlag = false;
    private boolean showmodeDirtyFlag = false;
    private boolean spanflagDirtyFlag = false;
    private boolean tbitemtypeDirtyFlag = false;
    private boolean templatemodeDirtyFlag = false;
    private boolean tippslanresidDirtyFlag = false;
    private boolean tippslanresnameDirtyFlag = false;
    private boolean togglemodeDirtyFlag = false;
    private boolean tooltipinfoDirtyFlag = false;
    private boolean uiactionparamsDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean visiblelogicDirtyFlag = false;
    private boolean widthDirtyFlag = false;
    @Column(name="actionlevel")
    private Integer actionlevel;
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
    @Column(name="codename")
    private String codename;
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
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="deuacap")
    private String deuacap;
    @Column(name="dynaclass")
    private String dynaclass;
    @Column(name="enablelogic")
    private String enablelogic;
    @Column(name="groupextractmode")
    private String groupextractmode;
    @Column(name="height")
    private Double height;
    @Column(name="hiddenitem")
    private Integer hiddenitem;
    @Column(name="htmlcontent")
    private String htmlcontent;
    @Column(name="htmlpageurl")
    private String htmlpageurl;
    @Column(name="itemstyle")
    private String itemstyle;
    @Column(name="itemstyletext")
    private String itemstyletext;
    @Column(name="leveltag")
    private String leveltag;
    @Column(name="levelvalue")
    private Integer levelvalue;
    @Column(name="memo")
    private String memo;
    @Column(name="noprivdm")
    private Integer noprivdm;
    @Column(name="openpsappviewid")
    private String openpsappviewid;
    @Column(name="openpsappviewname")
    private String openpsappviewname;
    @Column(name="openpsdeviewid")
    private String openpsdeviewid;
    @Column(name="openpsdeviewname")
    private String openpsdeviewname;
    @Column(name="openpssyspdtviewid")
    private String openpssyspdtviewid;
    @Column(name="openpssyspdtviewname")
    private String openpssyspdtviewname;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="ppsdetbitemid")
    private String ppsdetbitemid;
    @Column(name="ppsdetbitemname")
    private String ppsdetbitemname;
    @Column(name="predefinedtype")
    private String predefinedtype;
    @Column(name="predefinedtypetext")
    private String predefinedtypetext;
    @Column(name="previewhtml")
    private String previewhtml;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdelogicid")
    private String psdelogicid;
    @Column(name="psdelogicname")
    private String psdelogicname;
    @Column(name="psdetbitemid")
    private String psdetbitemid;
    @Column(name="psdetbitemname")
    private String psdetbitemname;
    @Column(name="psdetoolbarid")
    private String psdetoolbarid;
    @Column(name="psdetoolbarname")
    private String psdetoolbarname;
    @Column(name="psdeuagroupid")
    private String psdeuagroupid;
    @Column(name="psdeuagroupname")
    private String psdeuagroupname;
    @Column(name="psdeuiactionid")
    private String psdeuiactionid;
    @Column(name="psdeuiactionname")
    private String psdeuiactionname;
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
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssysuniresid")
    private String pssysuniresid;
    @Column(name="pssysuniresname")
    private String pssysuniresname;
    @Column(name="rawcontent")
    private String rawcontent;
    @Column(name="rawcssstyle")
    private String rawcssstyle;
    @Column(name="showmode")
    private String showmode;
    @Column(name="spanflag")
    private Integer spanflag;
    @Column(name="tbitemtype")
    private String tbitemtype;
    @Column(name="templatemode")
    private Integer templatemode;
    @Column(name="tippslanresid")
    private String tippslanresid;
    @Column(name="tippslanresname")
    private String tippslanresname;
    @Column(name="togglemode")
    private String togglemode;
    @Column(name="tooltipinfo")
    private String tooltipinfo;
    @Column(name="uiactionparams")
    private String uiactionparams;
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
    @Column(name="visiblelogic")
    private String visiblelogic;
    @Column(name="width")
    private Double width;
    private Integer objOpenPSAppViewLock = new Integer(1);
    private PSAppView openpsappview = null;
    private Integer objPSDELogicLock = new Integer(1);
    private PSDELogic psdelogic = null;
    private Integer objPPSDETBItemLock = new Integer(1);
    private PSDETBItem ppsdetbitem = null;
    private Integer objPSDEToolbarLock = new Integer(1);
    private PSDEToolbar psdetoolbar = null;
    private Integer objPSDEUAGroupLock = new Integer(1);
    private PSDEUAGroup psdeuagroup = null;
    private Integer objPSDEUIActionLock = new Integer(1);
    private PSDEUIAction psdeuiaction = null;
    private Integer objOpenPSDEViewLock = new Integer(1);
    private PSDEViewBase openpsdeview = null;
    private Integer objCapPSLanResLock = new Integer(1);
    private PSLanguageRes cappslanres = null;
    private Integer objTipPSLanResLock = new Integer(1);
    private PSLanguageRes tippslanres = null;
    private Integer objPSSysCssLock = new Integer(1);
    private PSSysCss pssyscss = null;
    private Integer objPSSysImageLock = new Integer(1);
    private PSSysImage pssysimage = null;
    private Integer objOpenPSSysPDTViewLock = new Integer(1);
    private PSSysPDTView openpssyspdtview = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSSysResourceLock = new Integer(1);
    private PSSysResource pssysresource = null;
    private Integer objPSSysUniResLock = new Integer(1);
    private PSSysUniRes pssysunires = null;
    private Integer objPSDETBItemsLock = new Integer(1);
    private ArrayList<PSDETBItem> psdetbitems = null;

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

    public void setCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename = string;
        this.codenameDirtyFlag = true;
    }

    public String getCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName();
        }
        return this.codename;
    }

    public boolean isCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeNameDirty();
        }
        return this.codenameDirtyFlag;
    }

    public void resetCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName();
            return;
        }
        this.codenameDirtyFlag = false;
        this.codename = null;
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

    public void setDefaultFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultFlag(n);
            return;
        }
        this.defaultflag = n;
        this.defaultflagDirtyFlag = true;
    }

    public Integer getDefaultFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultFlag();
        }
        return this.defaultflag;
    }

    public boolean isDefaultFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultFlagDirty();
        }
        return this.defaultflagDirtyFlag;
    }

    public void resetDefaultFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultFlag();
            return;
        }
        this.defaultflagDirtyFlag = false;
        this.defaultflag = null;
    }

    public void setDEUACap(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEUACap(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.deuacap = string;
        this.deuacapDirtyFlag = true;
    }

    public String getDEUACap() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEUACap();
        }
        return this.deuacap;
    }

    public boolean isDEUACapDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEUACapDirty();
        }
        return this.deuacapDirtyFlag;
    }

    public void resetDEUACap() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEUACap();
            return;
        }
        this.deuacapDirtyFlag = false;
        this.deuacap = null;
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

    public void setEnableLogic(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableLogic(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.enablelogic = string;
        this.enablelogicDirtyFlag = true;
    }

    public String getEnableLogic() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableLogic();
        }
        return this.enablelogic;
    }

    public boolean isEnableLogicDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableLogicDirty();
        }
        return this.enablelogicDirtyFlag;
    }

    public void resetEnableLogic() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableLogic();
            return;
        }
        this.enablelogicDirtyFlag = false;
        this.enablelogic = null;
    }

    public void setGroupExtractMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupExtractMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.groupextractmode = string;
        this.groupextractmodeDirtyFlag = true;
    }

    public String getGroupExtractMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupExtractMode();
        }
        return this.groupextractmode;
    }

    public boolean isGroupExtractModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupExtractModeDirty();
        }
        return this.groupextractmodeDirtyFlag;
    }

    public void resetGroupExtractMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupExtractMode();
            return;
        }
        this.groupextractmodeDirtyFlag = false;
        this.groupextractmode = null;
    }

    public void setHeight(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHeight(d);
            return;
        }
        this.height = d;
        this.heightDirtyFlag = true;
    }

    public Double getHeight() {
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

    public void setNoPrivDM(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNoPrivDM(n);
            return;
        }
        this.noprivdm = n;
        this.noprivdmDirtyFlag = true;
    }

    public Integer getNoPrivDM() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNoPrivDM();
        }
        return this.noprivdm;
    }

    public boolean isNoPrivDMDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNoPrivDMDirty();
        }
        return this.noprivdmDirtyFlag;
    }

    public void resetNoPrivDM() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNoPrivDM();
            return;
        }
        this.noprivdmDirtyFlag = false;
        this.noprivdm = null;
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

    public void setOpenPSDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOpenPSDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.openpsdeviewid = string;
        this.openpsdeviewidDirtyFlag = true;
    }

    public String getOpenPSDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOpenPSDEViewId();
        }
        return this.openpsdeviewid;
    }

    public boolean isOpenPSDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOpenPSDEViewIdDirty();
        }
        return this.openpsdeviewidDirtyFlag;
    }

    public void resetOpenPSDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOpenPSDEViewId();
            return;
        }
        this.openpsdeviewidDirtyFlag = false;
        this.openpsdeviewid = null;
    }

    public void setOpenPSDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOpenPSDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.openpsdeviewname = string;
        this.openpsdeviewnameDirtyFlag = true;
    }

    public String getOpenPSDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOpenPSDEViewName();
        }
        return this.openpsdeviewname;
    }

    public boolean isOpenPSDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOpenPSDEViewNameDirty();
        }
        return this.openpsdeviewnameDirtyFlag;
    }

    public void resetOpenPSDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOpenPSDEViewName();
            return;
        }
        this.openpsdeviewnameDirtyFlag = false;
        this.openpsdeviewname = null;
    }

    public void setOpenPSSysPDTViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOpenPSSysPDTViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.openpssyspdtviewid = string;
        this.openpssyspdtviewidDirtyFlag = true;
    }

    public String getOpenPSSysPDTViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOpenPSSysPDTViewId();
        }
        return this.openpssyspdtviewid;
    }

    public boolean isOpenPSSysPDTViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOpenPSSysPDTViewIdDirty();
        }
        return this.openpssyspdtviewidDirtyFlag;
    }

    public void resetOpenPSSysPDTViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOpenPSSysPDTViewId();
            return;
        }
        this.openpssyspdtviewidDirtyFlag = false;
        this.openpssyspdtviewid = null;
    }

    public void setOpenPSSysPDTViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOpenPSSysPDTViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.openpssyspdtviewname = string;
        this.openpssyspdtviewnameDirtyFlag = true;
    }

    public String getOpenPSSysPDTViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOpenPSSysPDTViewName();
        }
        return this.openpssyspdtviewname;
    }

    public boolean isOpenPSSysPDTViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOpenPSSysPDTViewNameDirty();
        }
        return this.openpssyspdtviewnameDirtyFlag;
    }

    public void resetOpenPSSysPDTViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOpenPSSysPDTViewName();
            return;
        }
        this.openpssyspdtviewnameDirtyFlag = false;
        this.openpssyspdtviewname = null;
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

    public void setPPSDETBItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDETBItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdetbitemid = string;
        this.ppsdetbitemidDirtyFlag = true;
    }

    public String getPPSDETBItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDETBItemId();
        }
        return this.ppsdetbitemid;
    }

    public boolean isPPSDETBItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDETBItemIdDirty();
        }
        return this.ppsdetbitemidDirtyFlag;
    }

    public void resetPPSDETBItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDETBItemId();
            return;
        }
        this.ppsdetbitemidDirtyFlag = false;
        this.ppsdetbitemid = null;
    }

    public void setPPSDETBItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDETBItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdetbitemname = string;
        this.ppsdetbitemnameDirtyFlag = true;
    }

    public String getPPSDETBItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDETBItemName();
        }
        return this.ppsdetbitemname;
    }

    public boolean isPPSDETBItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDETBItemNameDirty();
        }
        return this.ppsdetbitemnameDirtyFlag;
    }

    public void resetPPSDETBItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDETBItemName();
            return;
        }
        this.ppsdetbitemnameDirtyFlag = false;
        this.ppsdetbitemname = null;
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

    public void setPSDETBItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETBItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetbitemid = string;
        this.psdetbitemidDirtyFlag = true;
    }

    public String getPSDETBItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETBItemId();
        }
        return this.psdetbitemid;
    }

    public boolean isPSDETBItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETBItemIdDirty();
        }
        return this.psdetbitemidDirtyFlag;
    }

    public void resetPSDETBItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETBItemId();
            return;
        }
        this.psdetbitemidDirtyFlag = false;
        this.psdetbitemid = null;
    }

    public void setPSDETBItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETBItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetbitemname = string;
        this.psdetbitemnameDirtyFlag = true;
    }

    public String getPSDETBItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETBItemName();
        }
        return this.psdetbitemname;
    }

    public boolean isPSDETBItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETBItemNameDirty();
        }
        return this.psdetbitemnameDirtyFlag;
    }

    public void resetPSDETBItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETBItemName();
            return;
        }
        this.psdetbitemnameDirtyFlag = false;
        this.psdetbitemname = null;
    }

    public void setPSDEToolbarId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEToolbarId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetoolbarid = string;
        this.psdetoolbaridDirtyFlag = true;
    }

    public String getPSDEToolbarId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEToolbarId();
        }
        return this.psdetoolbarid;
    }

    public boolean isPSDEToolbarIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEToolbarIdDirty();
        }
        return this.psdetoolbaridDirtyFlag;
    }

    public void resetPSDEToolbarId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEToolbarId();
            return;
        }
        this.psdetoolbaridDirtyFlag = false;
        this.psdetoolbarid = null;
    }

    public void setPSDEToolbarName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEToolbarName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetoolbarname = string;
        this.psdetoolbarnameDirtyFlag = true;
    }

    public String getPSDEToolbarName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEToolbarName();
        }
        return this.psdetoolbarname;
    }

    public boolean isPSDEToolbarNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEToolbarNameDirty();
        }
        return this.psdetoolbarnameDirtyFlag;
    }

    public void resetPSDEToolbarName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEToolbarName();
            return;
        }
        this.psdetoolbarnameDirtyFlag = false;
        this.psdetoolbarname = null;
    }

    public void setPSDEUAGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUAGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeuagroupid = string;
        this.psdeuagroupidDirtyFlag = true;
    }

    public String getPSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUAGroupId();
        }
        return this.psdeuagroupid;
    }

    public boolean isPSDEUAGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUAGroupIdDirty();
        }
        return this.psdeuagroupidDirtyFlag;
    }

    public void resetPSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUAGroupId();
            return;
        }
        this.psdeuagroupidDirtyFlag = false;
        this.psdeuagroupid = null;
    }

    public void setPSDEUAGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUAGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeuagroupname = string;
        this.psdeuagroupnameDirtyFlag = true;
    }

    public String getPSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUAGroupName();
        }
        return this.psdeuagroupname;
    }

    public boolean isPSDEUAGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUAGroupNameDirty();
        }
        return this.psdeuagroupnameDirtyFlag;
    }

    public void resetPSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUAGroupName();
            return;
        }
        this.psdeuagroupnameDirtyFlag = false;
        this.psdeuagroupname = null;
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

    public void setShowMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setShowMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.showmode = string;
        this.showmodeDirtyFlag = true;
    }

    public String getShowMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getShowMode();
        }
        return this.showmode;
    }

    public boolean isShowModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isShowModeDirty();
        }
        return this.showmodeDirtyFlag;
    }

    public void resetShowMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetShowMode();
            return;
        }
        this.showmodeDirtyFlag = false;
        this.showmode = null;
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

    public void setTBItemType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTBItemType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tbitemtype = string;
        this.tbitemtypeDirtyFlag = true;
    }

    public String getTBItemType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTBItemType();
        }
        return this.tbitemtype;
    }

    public boolean isTBItemTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTBItemTypeDirty();
        }
        return this.tbitemtypeDirtyFlag;
    }

    public void resetTBItemType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTBItemType();
            return;
        }
        this.tbitemtypeDirtyFlag = false;
        this.tbitemtype = null;
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

    public void setUIActionParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUIActionParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uiactionparams = string;
        this.uiactionparamsDirtyFlag = true;
    }

    public String getUIActionParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUIActionParams();
        }
        return this.uiactionparams;
    }

    public boolean isUIActionParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUIActionParamsDirty();
        }
        return this.uiactionparamsDirtyFlag;
    }

    public void resetUIActionParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUIActionParams();
            return;
        }
        this.uiactionparamsDirtyFlag = false;
        this.uiactionparams = null;
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

    public void setVisibleLogic(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVisibleLogic(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.visiblelogic = string;
        this.visiblelogicDirtyFlag = true;
    }

    public String getVisibleLogic() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVisibleLogic();
        }
        return this.visiblelogic;
    }

    public boolean isVisibleLogicDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVisibleLogicDirty();
        }
        return this.visiblelogicDirtyFlag;
    }

    public void resetVisibleLogic() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVisibleLogic();
            return;
        }
        this.visiblelogicDirtyFlag = false;
        this.visiblelogic = null;
    }

    public void setWidth(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWidth(d);
            return;
        }
        this.width = d;
        this.widthDirtyFlag = true;
    }

    public Double getWidth() {
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
        PSDETBItemBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDETBItemBase pSDETBItemBase) {
        pSDETBItemBase.resetActionLevel();
        pSDETBItemBase.resetBorderStyle();
        pSDETBItemBase.resetBtnActionType();
        pSDETBItemBase.resetCapPSLanResId();
        pSDETBItemBase.resetCapPSLanResName();
        pSDETBItemBase.resetCaption();
        pSDETBItemBase.resetCodeName();
        pSDETBItemBase.resetContentType();
        pSDETBItemBase.resetCounterId();
        pSDETBItemBase.resetCounterMode();
        pSDETBItemBase.resetCreateDate();
        pSDETBItemBase.resetCreateMan();
        pSDETBItemBase.resetCssId();
        pSDETBItemBase.resetCustomCode();
        pSDETBItemBase.resetData();
        pSDETBItemBase.resetDefaultFlag();
        pSDETBItemBase.resetDEUACap();
        pSDETBItemBase.resetDynaClass();
        pSDETBItemBase.resetEnableLogic();
        pSDETBItemBase.resetGroupExtractMode();
        pSDETBItemBase.resetHeight();
        pSDETBItemBase.resetHiddenItem();
        pSDETBItemBase.resetHtmlContent();
        pSDETBItemBase.resetHtmlPageUrl();
        pSDETBItemBase.resetItemStyle();
        pSDETBItemBase.resetItemStyleText();
        pSDETBItemBase.resetLevelTag();
        pSDETBItemBase.resetLevelValue();
        pSDETBItemBase.resetMemo();
        pSDETBItemBase.resetNoPrivDM();
        pSDETBItemBase.resetOpenPSAppViewId();
        pSDETBItemBase.resetOpenPSAppViewName();
        pSDETBItemBase.resetOpenPSDEViewId();
        pSDETBItemBase.resetOpenPSDEViewName();
        pSDETBItemBase.resetOpenPSSysPDTViewId();
        pSDETBItemBase.resetOpenPSSysPDTViewName();
        pSDETBItemBase.resetOrderValue();
        pSDETBItemBase.resetPPSDETBItemId();
        pSDETBItemBase.resetPPSDETBItemName();
        pSDETBItemBase.resetPredefinedType();
        pSDETBItemBase.resetPredefinedTypeText();
        pSDETBItemBase.resetPreviewHtml();
        pSDETBItemBase.resetPSDEId();
        pSDETBItemBase.resetPSDELogicId();
        pSDETBItemBase.resetPSDELogicName();
        pSDETBItemBase.resetPSDETBItemId();
        pSDETBItemBase.resetPSDETBItemName();
        pSDETBItemBase.resetPSDEToolbarId();
        pSDETBItemBase.resetPSDEToolbarName();
        pSDETBItemBase.resetPSDEUAGroupId();
        pSDETBItemBase.resetPSDEUAGroupName();
        pSDETBItemBase.resetPSDEUIActionId();
        pSDETBItemBase.resetPSDEUIActionName();
        pSDETBItemBase.resetPSSysCssId();
        pSDETBItemBase.resetPSSysCssName();
        pSDETBItemBase.resetPSSysImageId();
        pSDETBItemBase.resetPSSysImageName();
        pSDETBItemBase.resetPSSysPFPluginId();
        pSDETBItemBase.resetPSSysPFPluginName();
        pSDETBItemBase.resetPSSysResourceId();
        pSDETBItemBase.resetPSSysResourceName();
        pSDETBItemBase.resetPSSystemId();
        pSDETBItemBase.resetPSSysUniResId();
        pSDETBItemBase.resetPSSysUniResName();
        pSDETBItemBase.resetRawContent();
        pSDETBItemBase.resetRawCssStyle();
        pSDETBItemBase.resetShowMode();
        pSDETBItemBase.resetSpanFlag();
        pSDETBItemBase.resetTBItemType();
        pSDETBItemBase.resetTemplateMode();
        pSDETBItemBase.resetTipPSLanResId();
        pSDETBItemBase.resetTipPSLanResName();
        pSDETBItemBase.resetToggleMode();
        pSDETBItemBase.resetTooltipInfo();
        pSDETBItemBase.resetUIActionParams();
        pSDETBItemBase.resetUpdateDate();
        pSDETBItemBase.resetUpdateMan();
        pSDETBItemBase.resetUserParams();
        pSDETBItemBase.resetUserTag();
        pSDETBItemBase.resetUserTag2();
        pSDETBItemBase.resetVisibleLogic();
        pSDETBItemBase.resetWidth();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isActionLevelDirty()) {
            hashMap.put(FIELD_ACTIONLEVEL, this.getActionLevel());
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
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
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
        if (!bl || this.isDefaultFlagDirty()) {
            hashMap.put(FIELD_DEFAULTFLAG, this.getDefaultFlag());
        }
        if (!bl || this.isDEUACapDirty()) {
            hashMap.put(FIELD_DEUACAP, this.getDEUACap());
        }
        if (!bl || this.isDynaClassDirty()) {
            hashMap.put(FIELD_DYNACLASS, this.getDynaClass());
        }
        if (!bl || this.isEnableLogicDirty()) {
            hashMap.put(FIELD_ENABLELOGIC, this.getEnableLogic());
        }
        if (!bl || this.isGroupExtractModeDirty()) {
            hashMap.put(FIELD_GROUPEXTRACTMODE, this.getGroupExtractMode());
        }
        if (!bl || this.isHeightDirty()) {
            hashMap.put(FIELD_HEIGHT, this.getHeight());
        }
        if (!bl || this.isHiddenItemDirty()) {
            hashMap.put(FIELD_HIDDENITEM, this.getHiddenItem());
        }
        if (!bl || this.isHtmlContentDirty()) {
            hashMap.put(FIELD_HTMLCONTENT, this.getHtmlContent());
        }
        if (!bl || this.isHtmlPageUrlDirty()) {
            hashMap.put(FIELD_HTMLPAGEURL, this.getHtmlPageUrl());
        }
        if (!bl || this.isItemStyleDirty()) {
            hashMap.put(FIELD_ITEMSTYLE, this.getItemStyle());
        }
        if (!bl || this.isItemStyleTextDirty()) {
            hashMap.put(FIELD_ITEMSTYLETEXT, this.getItemStyleText());
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
        if (!bl || this.isNoPrivDMDirty()) {
            hashMap.put(FIELD_NOPRIVDM, this.getNoPrivDM());
        }
        if (!bl || this.isOpenPSAppViewIdDirty()) {
            hashMap.put(FIELD_OPENPSAPPVIEWID, this.getOpenPSAppViewId());
        }
        if (!bl || this.isOpenPSAppViewNameDirty()) {
            hashMap.put(FIELD_OPENPSAPPVIEWNAME, this.getOpenPSAppViewName());
        }
        if (!bl || this.isOpenPSDEViewIdDirty()) {
            hashMap.put(FIELD_OPENPSDEVIEWID, this.getOpenPSDEViewId());
        }
        if (!bl || this.isOpenPSDEViewNameDirty()) {
            hashMap.put(FIELD_OPENPSDEVIEWNAME, this.getOpenPSDEViewName());
        }
        if (!bl || this.isOpenPSSysPDTViewIdDirty()) {
            hashMap.put(FIELD_OPENPSSYSPDTVIEWID, this.getOpenPSSysPDTViewId());
        }
        if (!bl || this.isOpenPSSysPDTViewNameDirty()) {
            hashMap.put(FIELD_OPENPSSYSPDTVIEWNAME, this.getOpenPSSysPDTViewName());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPPSDETBItemIdDirty()) {
            hashMap.put(FIELD_PPSDETBITEMID, this.getPPSDETBItemId());
        }
        if (!bl || this.isPPSDETBItemNameDirty()) {
            hashMap.put(FIELD_PPSDETBITEMNAME, this.getPPSDETBItemName());
        }
        if (!bl || this.isPredefinedTypeDirty()) {
            hashMap.put(FIELD_PREDEFINEDTYPE, this.getPredefinedType());
        }
        if (!bl || this.isPredefinedTypeTextDirty()) {
            hashMap.put(FIELD_PREDEFINEDTYPETEXT, this.getPredefinedTypeText());
        }
        if (!bl || this.isPreviewHtmlDirty()) {
            hashMap.put(FIELD_PREVIEWHTML, this.getPreviewHtml());
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
        if (!bl || this.isPSDETBItemIdDirty()) {
            hashMap.put(FIELD_PSDETBITEMID, this.getPSDETBItemId());
        }
        if (!bl || this.isPSDETBItemNameDirty()) {
            hashMap.put(FIELD_PSDETBITEMNAME, this.getPSDETBItemName());
        }
        if (!bl || this.isPSDEToolbarIdDirty()) {
            hashMap.put(FIELD_PSDETOOLBARID, this.getPSDEToolbarId());
        }
        if (!bl || this.isPSDEToolbarNameDirty()) {
            hashMap.put(FIELD_PSDETOOLBARNAME, this.getPSDEToolbarName());
        }
        if (!bl || this.isPSDEUAGroupIdDirty()) {
            hashMap.put(FIELD_PSDEUAGROUPID, this.getPSDEUAGroupId());
        }
        if (!bl || this.isPSDEUAGroupNameDirty()) {
            hashMap.put(FIELD_PSDEUAGROUPNAME, this.getPSDEUAGroupName());
        }
        if (!bl || this.isPSDEUIActionIdDirty()) {
            hashMap.put(FIELD_PSDEUIACTIONID, this.getPSDEUIActionId());
        }
        if (!bl || this.isPSDEUIActionNameDirty()) {
            hashMap.put(FIELD_PSDEUIACTIONNAME, this.getPSDEUIActionName());
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
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
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
        if (!bl || this.isShowModeDirty()) {
            hashMap.put(FIELD_SHOWMODE, this.getShowMode());
        }
        if (!bl || this.isSpanFlagDirty()) {
            hashMap.put(FIELD_SPANFLAG, this.getSpanFlag());
        }
        if (!bl || this.isTBItemTypeDirty()) {
            hashMap.put(FIELD_TBITEMTYPE, this.getTBItemType());
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
        if (!bl || this.isToggleModeDirty()) {
            hashMap.put(FIELD_TOGGLEMODE, this.getToggleMode());
        }
        if (!bl || this.isTooltipInfoDirty()) {
            hashMap.put(FIELD_TOOLTIPINFO, this.getTooltipInfo());
        }
        if (!bl || this.isUIActionParamsDirty()) {
            hashMap.put(FIELD_UIACTIONPARAMS, this.getUIActionParams());
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
        if (!bl || this.isVisibleLogicDirty()) {
            hashMap.put(FIELD_VISIBLELOGIC, this.getVisibleLogic());
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
        return PSDETBItemBase.get(this, n);
    }

    private static Object get(PSDETBItemBase pSDETBItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDETBItemBase.getActionLevel();
            }
            case 1: {
                return pSDETBItemBase.getBorderStyle();
            }
            case 2: {
                return pSDETBItemBase.getBtnActionType();
            }
            case 3: {
                return pSDETBItemBase.getCapPSLanResId();
            }
            case 4: {
                return pSDETBItemBase.getCapPSLanResName();
            }
            case 5: {
                return pSDETBItemBase.getCaption();
            }
            case 6: {
                return pSDETBItemBase.getCodeName();
            }
            case 7: {
                return pSDETBItemBase.getContentType();
            }
            case 8: {
                return pSDETBItemBase.getCounterId();
            }
            case 9: {
                return pSDETBItemBase.getCounterMode();
            }
            case 10: {
                return pSDETBItemBase.getCreateDate();
            }
            case 11: {
                return pSDETBItemBase.getCreateMan();
            }
            case 12: {
                return pSDETBItemBase.getCssId();
            }
            case 13: {
                return pSDETBItemBase.getCustomCode();
            }
            case 14: {
                return pSDETBItemBase.getData();
            }
            case 15: {
                return pSDETBItemBase.getDefaultFlag();
            }
            case 16: {
                return pSDETBItemBase.getDEUACap();
            }
            case 17: {
                return pSDETBItemBase.getDynaClass();
            }
            case 18: {
                return pSDETBItemBase.getEnableLogic();
            }
            case 19: {
                return pSDETBItemBase.getGroupExtractMode();
            }
            case 20: {
                return pSDETBItemBase.getHeight();
            }
            case 21: {
                return pSDETBItemBase.getHiddenItem();
            }
            case 22: {
                return pSDETBItemBase.getHtmlContent();
            }
            case 23: {
                return pSDETBItemBase.getHtmlPageUrl();
            }
            case 24: {
                return pSDETBItemBase.getItemStyle();
            }
            case 25: {
                return pSDETBItemBase.getItemStyleText();
            }
            case 26: {
                return pSDETBItemBase.getLevelTag();
            }
            case 27: {
                return pSDETBItemBase.getLevelValue();
            }
            case 28: {
                return pSDETBItemBase.getMemo();
            }
            case 29: {
                return pSDETBItemBase.getNoPrivDM();
            }
            case 30: {
                return pSDETBItemBase.getOpenPSAppViewId();
            }
            case 31: {
                return pSDETBItemBase.getOpenPSAppViewName();
            }
            case 32: {
                return pSDETBItemBase.getOpenPSDEViewId();
            }
            case 33: {
                return pSDETBItemBase.getOpenPSDEViewName();
            }
            case 34: {
                return pSDETBItemBase.getOpenPSSysPDTViewId();
            }
            case 35: {
                return pSDETBItemBase.getOpenPSSysPDTViewName();
            }
            case 36: {
                return pSDETBItemBase.getOrderValue();
            }
            case 37: {
                return pSDETBItemBase.getPPSDETBItemId();
            }
            case 38: {
                return pSDETBItemBase.getPPSDETBItemName();
            }
            case 39: {
                return pSDETBItemBase.getPredefinedType();
            }
            case 40: {
                return pSDETBItemBase.getPredefinedTypeText();
            }
            case 41: {
                return pSDETBItemBase.getPreviewHtml();
            }
            case 42: {
                return pSDETBItemBase.getPSDEId();
            }
            case 43: {
                return pSDETBItemBase.getPSDELogicId();
            }
            case 44: {
                return pSDETBItemBase.getPSDELogicName();
            }
            case 45: {
                return pSDETBItemBase.getPSDETBItemId();
            }
            case 46: {
                return pSDETBItemBase.getPSDETBItemName();
            }
            case 47: {
                return pSDETBItemBase.getPSDEToolbarId();
            }
            case 48: {
                return pSDETBItemBase.getPSDEToolbarName();
            }
            case 49: {
                return pSDETBItemBase.getPSDEUAGroupId();
            }
            case 50: {
                return pSDETBItemBase.getPSDEUAGroupName();
            }
            case 51: {
                return pSDETBItemBase.getPSDEUIActionId();
            }
            case 52: {
                return pSDETBItemBase.getPSDEUIActionName();
            }
            case 53: {
                return pSDETBItemBase.getPSSysCssId();
            }
            case 54: {
                return pSDETBItemBase.getPSSysCssName();
            }
            case 55: {
                return pSDETBItemBase.getPSSysImageId();
            }
            case 56: {
                return pSDETBItemBase.getPSSysImageName();
            }
            case 57: {
                return pSDETBItemBase.getPSSysPFPluginId();
            }
            case 58: {
                return pSDETBItemBase.getPSSysPFPluginName();
            }
            case 59: {
                return pSDETBItemBase.getPSSysResourceId();
            }
            case 60: {
                return pSDETBItemBase.getPSSysResourceName();
            }
            case 61: {
                return pSDETBItemBase.getPSSystemId();
            }
            case 62: {
                return pSDETBItemBase.getPSSysUniResId();
            }
            case 63: {
                return pSDETBItemBase.getPSSysUniResName();
            }
            case 64: {
                return pSDETBItemBase.getRawContent();
            }
            case 65: {
                return pSDETBItemBase.getRawCssStyle();
            }
            case 66: {
                return pSDETBItemBase.getShowMode();
            }
            case 67: {
                return pSDETBItemBase.getSpanFlag();
            }
            case 68: {
                return pSDETBItemBase.getTBItemType();
            }
            case 69: {
                return pSDETBItemBase.getTemplateMode();
            }
            case 70: {
                return pSDETBItemBase.getTipPSLanResId();
            }
            case 71: {
                return pSDETBItemBase.getTipPSLanResName();
            }
            case 72: {
                return pSDETBItemBase.getToggleMode();
            }
            case 73: {
                return pSDETBItemBase.getTooltipInfo();
            }
            case 74: {
                return pSDETBItemBase.getUIActionParams();
            }
            case 75: {
                return pSDETBItemBase.getUpdateDate();
            }
            case 76: {
                return pSDETBItemBase.getUpdateMan();
            }
            case 77: {
                return pSDETBItemBase.getUserParams();
            }
            case 78: {
                return pSDETBItemBase.getUserTag();
            }
            case 79: {
                return pSDETBItemBase.getUserTag2();
            }
            case 80: {
                return pSDETBItemBase.getVisibleLogic();
            }
            case 81: {
                return pSDETBItemBase.getWidth();
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
        PSDETBItemBase.set(this, n, object);
    }

    private static void set(PSDETBItemBase pSDETBItemBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDETBItemBase.setActionLevel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDETBItemBase.setBorderStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDETBItemBase.setBtnActionType(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDETBItemBase.setCapPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDETBItemBase.setCapPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDETBItemBase.setCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDETBItemBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDETBItemBase.setContentType(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDETBItemBase.setCounterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDETBItemBase.setCounterMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSDETBItemBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSDETBItemBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDETBItemBase.setCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDETBItemBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDETBItemBase.setData(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDETBItemBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSDETBItemBase.setDEUACap(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDETBItemBase.setDynaClass(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDETBItemBase.setEnableLogic(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDETBItemBase.setGroupExtractMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDETBItemBase.setHeight(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 21: {
                pSDETBItemBase.setHiddenItem(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSDETBItemBase.setHtmlContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDETBItemBase.setHtmlPageUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDETBItemBase.setItemStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDETBItemBase.setItemStyleText(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDETBItemBase.setLevelTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDETBItemBase.setLevelValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 28: {
                pSDETBItemBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDETBItemBase.setNoPrivDM(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 30: {
                pSDETBItemBase.setOpenPSAppViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDETBItemBase.setOpenPSAppViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDETBItemBase.setOpenPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDETBItemBase.setOpenPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDETBItemBase.setOpenPSSysPDTViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDETBItemBase.setOpenPSSysPDTViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDETBItemBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 37: {
                pSDETBItemBase.setPPSDETBItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDETBItemBase.setPPSDETBItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDETBItemBase.setPredefinedType(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDETBItemBase.setPredefinedTypeText(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDETBItemBase.setPreviewHtml(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDETBItemBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDETBItemBase.setPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDETBItemBase.setPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDETBItemBase.setPSDETBItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDETBItemBase.setPSDETBItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDETBItemBase.setPSDEToolbarId(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDETBItemBase.setPSDEToolbarName(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDETBItemBase.setPSDEUAGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDETBItemBase.setPSDEUAGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSDETBItemBase.setPSDEUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSDETBItemBase.setPSDEUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSDETBItemBase.setPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSDETBItemBase.setPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSDETBItemBase.setPSSysImageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSDETBItemBase.setPSSysImageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSDETBItemBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSDETBItemBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSDETBItemBase.setPSSysResourceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSDETBItemBase.setPSSysResourceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSDETBItemBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSDETBItemBase.setPSSysUniResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSDETBItemBase.setPSSysUniResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSDETBItemBase.setRawContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSDETBItemBase.setRawCssStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSDETBItemBase.setShowMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSDETBItemBase.setSpanFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 68: {
                pSDETBItemBase.setTBItemType(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSDETBItemBase.setTemplateMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 70: {
                pSDETBItemBase.setTipPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 71: {
                pSDETBItemBase.setTipPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 72: {
                pSDETBItemBase.setToggleMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 73: {
                pSDETBItemBase.setTooltipInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 74: {
                pSDETBItemBase.setUIActionParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 75: {
                pSDETBItemBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 76: {
                pSDETBItemBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 77: {
                pSDETBItemBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 78: {
                pSDETBItemBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 79: {
                pSDETBItemBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 80: {
                pSDETBItemBase.setVisibleLogic(DataObject.getStringValue((Object)object));
                return;
            }
            case 81: {
                pSDETBItemBase.setWidth(DataObject.getDoubleValue((Object)object));
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
        return PSDETBItemBase.isNull(this, n);
    }

    private static boolean isNull(PSDETBItemBase pSDETBItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDETBItemBase.getActionLevel() == null;
            }
            case 1: {
                return pSDETBItemBase.getBorderStyle() == null;
            }
            case 2: {
                return pSDETBItemBase.getBtnActionType() == null;
            }
            case 3: {
                return pSDETBItemBase.getCapPSLanResId() == null;
            }
            case 4: {
                return pSDETBItemBase.getCapPSLanResName() == null;
            }
            case 5: {
                return pSDETBItemBase.getCaption() == null;
            }
            case 6: {
                return pSDETBItemBase.getCodeName() == null;
            }
            case 7: {
                return pSDETBItemBase.getContentType() == null;
            }
            case 8: {
                return pSDETBItemBase.getCounterId() == null;
            }
            case 9: {
                return pSDETBItemBase.getCounterMode() == null;
            }
            case 10: {
                return pSDETBItemBase.getCreateDate() == null;
            }
            case 11: {
                return pSDETBItemBase.getCreateMan() == null;
            }
            case 12: {
                return pSDETBItemBase.getCssId() == null;
            }
            case 13: {
                return pSDETBItemBase.getCustomCode() == null;
            }
            case 14: {
                return pSDETBItemBase.getData() == null;
            }
            case 15: {
                return pSDETBItemBase.getDefaultFlag() == null;
            }
            case 16: {
                return pSDETBItemBase.getDEUACap() == null;
            }
            case 17: {
                return pSDETBItemBase.getDynaClass() == null;
            }
            case 18: {
                return pSDETBItemBase.getEnableLogic() == null;
            }
            case 19: {
                return pSDETBItemBase.getGroupExtractMode() == null;
            }
            case 20: {
                return pSDETBItemBase.getHeight() == null;
            }
            case 21: {
                return pSDETBItemBase.getHiddenItem() == null;
            }
            case 22: {
                return pSDETBItemBase.getHtmlContent() == null;
            }
            case 23: {
                return pSDETBItemBase.getHtmlPageUrl() == null;
            }
            case 24: {
                return pSDETBItemBase.getItemStyle() == null;
            }
            case 25: {
                return pSDETBItemBase.getItemStyleText() == null;
            }
            case 26: {
                return pSDETBItemBase.getLevelTag() == null;
            }
            case 27: {
                return pSDETBItemBase.getLevelValue() == null;
            }
            case 28: {
                return pSDETBItemBase.getMemo() == null;
            }
            case 29: {
                return pSDETBItemBase.getNoPrivDM() == null;
            }
            case 30: {
                return pSDETBItemBase.getOpenPSAppViewId() == null;
            }
            case 31: {
                return pSDETBItemBase.getOpenPSAppViewName() == null;
            }
            case 32: {
                return pSDETBItemBase.getOpenPSDEViewId() == null;
            }
            case 33: {
                return pSDETBItemBase.getOpenPSDEViewName() == null;
            }
            case 34: {
                return pSDETBItemBase.getOpenPSSysPDTViewId() == null;
            }
            case 35: {
                return pSDETBItemBase.getOpenPSSysPDTViewName() == null;
            }
            case 36: {
                return pSDETBItemBase.getOrderValue() == null;
            }
            case 37: {
                return pSDETBItemBase.getPPSDETBItemId() == null;
            }
            case 38: {
                return pSDETBItemBase.getPPSDETBItemName() == null;
            }
            case 39: {
                return pSDETBItemBase.getPredefinedType() == null;
            }
            case 40: {
                return pSDETBItemBase.getPredefinedTypeText() == null;
            }
            case 41: {
                return pSDETBItemBase.getPreviewHtml() == null;
            }
            case 42: {
                return pSDETBItemBase.getPSDEId() == null;
            }
            case 43: {
                return pSDETBItemBase.getPSDELogicId() == null;
            }
            case 44: {
                return pSDETBItemBase.getPSDELogicName() == null;
            }
            case 45: {
                return pSDETBItemBase.getPSDETBItemId() == null;
            }
            case 46: {
                return pSDETBItemBase.getPSDETBItemName() == null;
            }
            case 47: {
                return pSDETBItemBase.getPSDEToolbarId() == null;
            }
            case 48: {
                return pSDETBItemBase.getPSDEToolbarName() == null;
            }
            case 49: {
                return pSDETBItemBase.getPSDEUAGroupId() == null;
            }
            case 50: {
                return pSDETBItemBase.getPSDEUAGroupName() == null;
            }
            case 51: {
                return pSDETBItemBase.getPSDEUIActionId() == null;
            }
            case 52: {
                return pSDETBItemBase.getPSDEUIActionName() == null;
            }
            case 53: {
                return pSDETBItemBase.getPSSysCssId() == null;
            }
            case 54: {
                return pSDETBItemBase.getPSSysCssName() == null;
            }
            case 55: {
                return pSDETBItemBase.getPSSysImageId() == null;
            }
            case 56: {
                return pSDETBItemBase.getPSSysImageName() == null;
            }
            case 57: {
                return pSDETBItemBase.getPSSysPFPluginId() == null;
            }
            case 58: {
                return pSDETBItemBase.getPSSysPFPluginName() == null;
            }
            case 59: {
                return pSDETBItemBase.getPSSysResourceId() == null;
            }
            case 60: {
                return pSDETBItemBase.getPSSysResourceName() == null;
            }
            case 61: {
                return pSDETBItemBase.getPSSystemId() == null;
            }
            case 62: {
                return pSDETBItemBase.getPSSysUniResId() == null;
            }
            case 63: {
                return pSDETBItemBase.getPSSysUniResName() == null;
            }
            case 64: {
                return pSDETBItemBase.getRawContent() == null;
            }
            case 65: {
                return pSDETBItemBase.getRawCssStyle() == null;
            }
            case 66: {
                return pSDETBItemBase.getShowMode() == null;
            }
            case 67: {
                return pSDETBItemBase.getSpanFlag() == null;
            }
            case 68: {
                return pSDETBItemBase.getTBItemType() == null;
            }
            case 69: {
                return pSDETBItemBase.getTemplateMode() == null;
            }
            case 70: {
                return pSDETBItemBase.getTipPSLanResId() == null;
            }
            case 71: {
                return pSDETBItemBase.getTipPSLanResName() == null;
            }
            case 72: {
                return pSDETBItemBase.getToggleMode() == null;
            }
            case 73: {
                return pSDETBItemBase.getTooltipInfo() == null;
            }
            case 74: {
                return pSDETBItemBase.getUIActionParams() == null;
            }
            case 75: {
                return pSDETBItemBase.getUpdateDate() == null;
            }
            case 76: {
                return pSDETBItemBase.getUpdateMan() == null;
            }
            case 77: {
                return pSDETBItemBase.getUserParams() == null;
            }
            case 78: {
                return pSDETBItemBase.getUserTag() == null;
            }
            case 79: {
                return pSDETBItemBase.getUserTag2() == null;
            }
            case 80: {
                return pSDETBItemBase.getVisibleLogic() == null;
            }
            case 81: {
                return pSDETBItemBase.getWidth() == null;
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
        return PSDETBItemBase.contains(this, n);
    }

    private static boolean contains(PSDETBItemBase pSDETBItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDETBItemBase.isActionLevelDirty();
            }
            case 1: {
                return pSDETBItemBase.isBorderStyleDirty();
            }
            case 2: {
                return pSDETBItemBase.isBtnActionTypeDirty();
            }
            case 3: {
                return pSDETBItemBase.isCapPSLanResIdDirty();
            }
            case 4: {
                return pSDETBItemBase.isCapPSLanResNameDirty();
            }
            case 5: {
                return pSDETBItemBase.isCaptionDirty();
            }
            case 6: {
                return pSDETBItemBase.isCodeNameDirty();
            }
            case 7: {
                return pSDETBItemBase.isContentTypeDirty();
            }
            case 8: {
                return pSDETBItemBase.isCounterIdDirty();
            }
            case 9: {
                return pSDETBItemBase.isCounterModeDirty();
            }
            case 10: {
                return pSDETBItemBase.isCreateDateDirty();
            }
            case 11: {
                return pSDETBItemBase.isCreateManDirty();
            }
            case 12: {
                return pSDETBItemBase.isCssIdDirty();
            }
            case 13: {
                return pSDETBItemBase.isCustomCodeDirty();
            }
            case 14: {
                return pSDETBItemBase.isDataDirty();
            }
            case 15: {
                return pSDETBItemBase.isDefaultFlagDirty();
            }
            case 16: {
                return pSDETBItemBase.isDEUACapDirty();
            }
            case 17: {
                return pSDETBItemBase.isDynaClassDirty();
            }
            case 18: {
                return pSDETBItemBase.isEnableLogicDirty();
            }
            case 19: {
                return pSDETBItemBase.isGroupExtractModeDirty();
            }
            case 20: {
                return pSDETBItemBase.isHeightDirty();
            }
            case 21: {
                return pSDETBItemBase.isHiddenItemDirty();
            }
            case 22: {
                return pSDETBItemBase.isHtmlContentDirty();
            }
            case 23: {
                return pSDETBItemBase.isHtmlPageUrlDirty();
            }
            case 24: {
                return pSDETBItemBase.isItemStyleDirty();
            }
            case 25: {
                return pSDETBItemBase.isItemStyleTextDirty();
            }
            case 26: {
                return pSDETBItemBase.isLevelTagDirty();
            }
            case 27: {
                return pSDETBItemBase.isLevelValueDirty();
            }
            case 28: {
                return pSDETBItemBase.isMemoDirty();
            }
            case 29: {
                return pSDETBItemBase.isNoPrivDMDirty();
            }
            case 30: {
                return pSDETBItemBase.isOpenPSAppViewIdDirty();
            }
            case 31: {
                return pSDETBItemBase.isOpenPSAppViewNameDirty();
            }
            case 32: {
                return pSDETBItemBase.isOpenPSDEViewIdDirty();
            }
            case 33: {
                return pSDETBItemBase.isOpenPSDEViewNameDirty();
            }
            case 34: {
                return pSDETBItemBase.isOpenPSSysPDTViewIdDirty();
            }
            case 35: {
                return pSDETBItemBase.isOpenPSSysPDTViewNameDirty();
            }
            case 36: {
                return pSDETBItemBase.isOrderValueDirty();
            }
            case 37: {
                return pSDETBItemBase.isPPSDETBItemIdDirty();
            }
            case 38: {
                return pSDETBItemBase.isPPSDETBItemNameDirty();
            }
            case 39: {
                return pSDETBItemBase.isPredefinedTypeDirty();
            }
            case 40: {
                return pSDETBItemBase.isPredefinedTypeTextDirty();
            }
            case 41: {
                return pSDETBItemBase.isPreviewHtmlDirty();
            }
            case 42: {
                return pSDETBItemBase.isPSDEIdDirty();
            }
            case 43: {
                return pSDETBItemBase.isPSDELogicIdDirty();
            }
            case 44: {
                return pSDETBItemBase.isPSDELogicNameDirty();
            }
            case 45: {
                return pSDETBItemBase.isPSDETBItemIdDirty();
            }
            case 46: {
                return pSDETBItemBase.isPSDETBItemNameDirty();
            }
            case 47: {
                return pSDETBItemBase.isPSDEToolbarIdDirty();
            }
            case 48: {
                return pSDETBItemBase.isPSDEToolbarNameDirty();
            }
            case 49: {
                return pSDETBItemBase.isPSDEUAGroupIdDirty();
            }
            case 50: {
                return pSDETBItemBase.isPSDEUAGroupNameDirty();
            }
            case 51: {
                return pSDETBItemBase.isPSDEUIActionIdDirty();
            }
            case 52: {
                return pSDETBItemBase.isPSDEUIActionNameDirty();
            }
            case 53: {
                return pSDETBItemBase.isPSSysCssIdDirty();
            }
            case 54: {
                return pSDETBItemBase.isPSSysCssNameDirty();
            }
            case 55: {
                return pSDETBItemBase.isPSSysImageIdDirty();
            }
            case 56: {
                return pSDETBItemBase.isPSSysImageNameDirty();
            }
            case 57: {
                return pSDETBItemBase.isPSSysPFPluginIdDirty();
            }
            case 58: {
                return pSDETBItemBase.isPSSysPFPluginNameDirty();
            }
            case 59: {
                return pSDETBItemBase.isPSSysResourceIdDirty();
            }
            case 60: {
                return pSDETBItemBase.isPSSysResourceNameDirty();
            }
            case 61: {
                return pSDETBItemBase.isPSSystemIdDirty();
            }
            case 62: {
                return pSDETBItemBase.isPSSysUniResIdDirty();
            }
            case 63: {
                return pSDETBItemBase.isPSSysUniResNameDirty();
            }
            case 64: {
                return pSDETBItemBase.isRawContentDirty();
            }
            case 65: {
                return pSDETBItemBase.isRawCssStyleDirty();
            }
            case 66: {
                return pSDETBItemBase.isShowModeDirty();
            }
            case 67: {
                return pSDETBItemBase.isSpanFlagDirty();
            }
            case 68: {
                return pSDETBItemBase.isTBItemTypeDirty();
            }
            case 69: {
                return pSDETBItemBase.isTemplateModeDirty();
            }
            case 70: {
                return pSDETBItemBase.isTipPSLanResIdDirty();
            }
            case 71: {
                return pSDETBItemBase.isTipPSLanResNameDirty();
            }
            case 72: {
                return pSDETBItemBase.isToggleModeDirty();
            }
            case 73: {
                return pSDETBItemBase.isTooltipInfoDirty();
            }
            case 74: {
                return pSDETBItemBase.isUIActionParamsDirty();
            }
            case 75: {
                return pSDETBItemBase.isUpdateDateDirty();
            }
            case 76: {
                return pSDETBItemBase.isUpdateManDirty();
            }
            case 77: {
                return pSDETBItemBase.isUserParamsDirty();
            }
            case 78: {
                return pSDETBItemBase.isUserTagDirty();
            }
            case 79: {
                return pSDETBItemBase.isUserTag2Dirty();
            }
            case 80: {
                return pSDETBItemBase.isVisibleLogicDirty();
            }
            case 81: {
                return pSDETBItemBase.isWidthDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDETBItemBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDETBItemBase pSDETBItemBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDETBItemBase.getActionLevel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionlevel", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getActionLevel()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getBorderStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"borderstyle", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getBorderStyle()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getBtnActionType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"btnactiontype", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getBtnActionType()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getCapPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresid", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getCapPSLanResId()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getCapPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresname", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getCapPSLanResName()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"caption", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getCaption()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getContentType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contenttype", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getContentType()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getCounterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"counterid", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getCounterId()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getCounterMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"countermode", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getCounterMode()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cssid", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getCssId()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"data", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getData()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getDEUACap() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deuacap", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getDEUACap()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getDynaClass() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynaclass", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getDynaClass()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getEnableLogic() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablelogic", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getEnableLogic()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getGroupExtractMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupextractmode", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getGroupExtractMode()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"height", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getHeight()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getHiddenItem() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hiddenitem", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getHiddenItem()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getHtmlContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"htmlcontent", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getHtmlContent()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getHtmlPageUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"htmlpageurl", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getHtmlPageUrl()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getItemStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemstyle", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getItemStyle()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getItemStyleText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemstyletext", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getItemStyleText()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getLevelTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"leveltag", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getLevelTag()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getLevelValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"levelvalue", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getLevelValue()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getMemo()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getNoPrivDM() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"noprivdm", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getNoPrivDM()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getOpenPSAppViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"openpsappviewid", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getOpenPSAppViewId()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getOpenPSAppViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"openpsappviewname", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getOpenPSAppViewName()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getOpenPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"openpsdeviewid", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getOpenPSDEViewId()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getOpenPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"openpsdeviewname", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getOpenPSDEViewName()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getOpenPSSysPDTViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"openpssyspdtviewid", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getOpenPSSysPDTViewId()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getOpenPSSysPDTViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"openpssyspdtviewname", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getOpenPSSysPDTViewName()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getPPSDETBItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdetbitemid", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getPPSDETBItemId()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getPPSDETBItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdetbitemname", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getPPSDETBItemName()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getPredefinedType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"predefinedtype", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getPredefinedType()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getPredefinedTypeText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"predefinedtypetext", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getPredefinedTypeText()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getPreviewHtml() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"previewhtml", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getPreviewHtml()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicid", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getPSDELogicId()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicname", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getPSDELogicName()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getPSDETBItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetbitemid", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getPSDETBItemId()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getPSDETBItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetbitemname", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getPSDETBItemName()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getPSDEToolbarId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetoolbarid", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getPSDEToolbarId()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getPSDEToolbarName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetoolbarname", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getPSDEToolbarName()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getPSDEUAGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuagroupid", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getPSDEUAGroupId()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getPSDEUAGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuagroupname", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getPSDEUAGroupName()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getPSDEUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionid", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getPSDEUIActionId()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getPSDEUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionname", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getPSDEUIActionName()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssid", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getPSSysCssId()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssname", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getPSSysCssName()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getPSSysImageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimageid", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getPSSysImageId()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getPSSysImageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimagename", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getPSSysImageName()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getPSSysResourceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysresourceid", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getPSSysResourceId()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getPSSysResourceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysresourcename", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getPSSysResourceName()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getPSSysUniResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuniresid", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getPSSysUniResId()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getPSSysUniResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuniresname", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getPSSysUniResName()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getRawContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rawcontent", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getRawContent()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getRawCssStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rawcssstyle", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getRawCssStyle()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getShowMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"showmode", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getShowMode()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getSpanFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"spanflag", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getSpanFlag()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getTBItemType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tbitemtype", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getTBItemType()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getTemplateMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templatemode", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getTemplateMode()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getTipPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tippslanresid", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getTipPSLanResId()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getTipPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tippslanresname", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getTipPSLanResName()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getToggleMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"togglemode", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getToggleMode()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getTooltipInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tooltipinfo", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getTooltipInfo()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getUIActionParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uiactionparams", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getUIActionParams()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getUserParams()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getVisibleLogic() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"visiblelogic", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getVisibleLogic()), (boolean)false);
        }
        if (bl || pSDETBItemBase.getWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"width", (Object)PSDETBItemBase.getJSONValue((Object)pSDETBItemBase.getWidth()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDETBItemBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDETBItemBase pSDETBItemBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDETBItemBase.getActionLevel() != null) {
            object = pSDETBItemBase.getActionLevel();
            xmlNode.setAttribute(FIELD_ACTIONLEVEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETBItemBase.getBorderStyle() != null) {
            object = pSDETBItemBase.getBorderStyle();
            xmlNode.setAttribute(FIELD_BORDERSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getBtnActionType() != null) {
            object = pSDETBItemBase.getBtnActionType();
            xmlNode.setAttribute(FIELD_BTNACTIONTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getCapPSLanResId() != null) {
            object = pSDETBItemBase.getCapPSLanResId();
            xmlNode.setAttribute(FIELD_CAPPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getCapPSLanResName() != null) {
            object = pSDETBItemBase.getCapPSLanResName();
            xmlNode.setAttribute(FIELD_CAPPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getCaption() != null) {
            object = pSDETBItemBase.getCaption();
            xmlNode.setAttribute(FIELD_CAPTION, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getCodeName() != null) {
            object = pSDETBItemBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getContentType() != null) {
            object = pSDETBItemBase.getContentType();
            xmlNode.setAttribute(FIELD_CONTENTTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getCounterId() != null) {
            object = pSDETBItemBase.getCounterId();
            xmlNode.setAttribute(FIELD_COUNTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getCounterMode() != null) {
            object = pSDETBItemBase.getCounterMode();
            xmlNode.setAttribute(FIELD_COUNTERMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETBItemBase.getCreateDate() != null) {
            object = pSDETBItemBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDETBItemBase.getCreateMan() != null) {
            object = pSDETBItemBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getCssId() != null) {
            object = pSDETBItemBase.getCssId();
            xmlNode.setAttribute(FIELD_CSSID, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getCustomCode() != null) {
            object = pSDETBItemBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getData() != null) {
            object = pSDETBItemBase.getData();
            xmlNode.setAttribute(FIELD_DATA, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getDefaultFlag() != null) {
            object = pSDETBItemBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETBItemBase.getDEUACap() != null) {
            object = pSDETBItemBase.getDEUACap();
            xmlNode.setAttribute(FIELD_DEUACAP, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getDynaClass() != null) {
            object = pSDETBItemBase.getDynaClass();
            xmlNode.setAttribute(FIELD_DYNACLASS, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getEnableLogic() != null) {
            object = pSDETBItemBase.getEnableLogic();
            xmlNode.setAttribute(FIELD_ENABLELOGIC, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getGroupExtractMode() != null) {
            object = pSDETBItemBase.getGroupExtractMode();
            xmlNode.setAttribute(FIELD_GROUPEXTRACTMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getHeight() != null) {
            object = pSDETBItemBase.getHeight();
            xmlNode.setAttribute(FIELD_HEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETBItemBase.getHiddenItem() != null) {
            object = pSDETBItemBase.getHiddenItem();
            xmlNode.setAttribute(FIELD_HIDDENITEM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETBItemBase.getHtmlContent() != null) {
            object = pSDETBItemBase.getHtmlContent();
            xmlNode.setAttribute(FIELD_HTMLCONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getHtmlPageUrl() != null) {
            object = pSDETBItemBase.getHtmlPageUrl();
            xmlNode.setAttribute(FIELD_HTMLPAGEURL, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getItemStyle() != null) {
            object = pSDETBItemBase.getItemStyle();
            xmlNode.setAttribute(FIELD_ITEMSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getItemStyleText() != null) {
            object = pSDETBItemBase.getItemStyleText();
            xmlNode.setAttribute(FIELD_ITEMSTYLETEXT, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getLevelTag() != null) {
            object = pSDETBItemBase.getLevelTag();
            xmlNode.setAttribute(FIELD_LEVELTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getLevelValue() != null) {
            object = pSDETBItemBase.getLevelValue();
            xmlNode.setAttribute(FIELD_LEVELVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETBItemBase.getMemo() != null) {
            object = pSDETBItemBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getNoPrivDM() != null) {
            object = pSDETBItemBase.getNoPrivDM();
            xmlNode.setAttribute(FIELD_NOPRIVDM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETBItemBase.getOpenPSAppViewId() != null) {
            object = pSDETBItemBase.getOpenPSAppViewId();
            xmlNode.setAttribute(FIELD_OPENPSAPPVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getOpenPSAppViewName() != null) {
            object = pSDETBItemBase.getOpenPSAppViewName();
            xmlNode.setAttribute(FIELD_OPENPSAPPVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getOpenPSDEViewId() != null) {
            object = pSDETBItemBase.getOpenPSDEViewId();
            xmlNode.setAttribute(FIELD_OPENPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getOpenPSDEViewName() != null) {
            object = pSDETBItemBase.getOpenPSDEViewName();
            xmlNode.setAttribute(FIELD_OPENPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getOpenPSSysPDTViewId() != null) {
            object = pSDETBItemBase.getOpenPSSysPDTViewId();
            xmlNode.setAttribute(FIELD_OPENPSSYSPDTVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getOpenPSSysPDTViewName() != null) {
            object = pSDETBItemBase.getOpenPSSysPDTViewName();
            xmlNode.setAttribute(FIELD_OPENPSSYSPDTVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getOrderValue() != null) {
            object = pSDETBItemBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETBItemBase.getPPSDETBItemId() != null) {
            object = pSDETBItemBase.getPPSDETBItemId();
            xmlNode.setAttribute(FIELD_PPSDETBITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getPPSDETBItemName() != null) {
            object = pSDETBItemBase.getPPSDETBItemName();
            xmlNode.setAttribute(FIELD_PPSDETBITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getPredefinedType() != null) {
            object = pSDETBItemBase.getPredefinedType();
            xmlNode.setAttribute(FIELD_PREDEFINEDTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getPredefinedTypeText() != null) {
            object = pSDETBItemBase.getPredefinedTypeText();
            xmlNode.setAttribute(FIELD_PREDEFINEDTYPETEXT, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getPreviewHtml() != null) {
            object = pSDETBItemBase.getPreviewHtml();
            xmlNode.setAttribute(FIELD_PREVIEWHTML, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getPSDEId() != null) {
            object = pSDETBItemBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getPSDELogicId() != null) {
            object = pSDETBItemBase.getPSDELogicId();
            xmlNode.setAttribute(FIELD_PSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getPSDELogicName() != null) {
            object = pSDETBItemBase.getPSDELogicName();
            xmlNode.setAttribute(FIELD_PSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getPSDETBItemId() != null) {
            object = pSDETBItemBase.getPSDETBItemId();
            xmlNode.setAttribute(FIELD_PSDETBITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getPSDETBItemName() != null) {
            object = pSDETBItemBase.getPSDETBItemName();
            xmlNode.setAttribute(FIELD_PSDETBITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getPSDEToolbarId() != null) {
            object = pSDETBItemBase.getPSDEToolbarId();
            xmlNode.setAttribute(FIELD_PSDETOOLBARID, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getPSDEToolbarName() != null) {
            object = pSDETBItemBase.getPSDEToolbarName();
            xmlNode.setAttribute(FIELD_PSDETOOLBARNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getPSDEUAGroupId() != null) {
            object = pSDETBItemBase.getPSDEUAGroupId();
            xmlNode.setAttribute(FIELD_PSDEUAGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getPSDEUAGroupName() != null) {
            object = pSDETBItemBase.getPSDEUAGroupName();
            xmlNode.setAttribute(FIELD_PSDEUAGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getPSDEUIActionId() != null) {
            object = pSDETBItemBase.getPSDEUIActionId();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getPSDEUIActionName() != null) {
            object = pSDETBItemBase.getPSDEUIActionName();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getPSSysCssId() != null) {
            object = pSDETBItemBase.getPSSysCssId();
            xmlNode.setAttribute(FIELD_PSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getPSSysCssName() != null) {
            object = pSDETBItemBase.getPSSysCssName();
            xmlNode.setAttribute(FIELD_PSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getPSSysImageId() != null) {
            object = pSDETBItemBase.getPSSysImageId();
            xmlNode.setAttribute(FIELD_PSSYSIMAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getPSSysImageName() != null) {
            object = pSDETBItemBase.getPSSysImageName();
            xmlNode.setAttribute(FIELD_PSSYSIMAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getPSSysPFPluginId() != null) {
            object = pSDETBItemBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getPSSysPFPluginName() != null) {
            object = pSDETBItemBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getPSSysResourceId() != null) {
            object = pSDETBItemBase.getPSSysResourceId();
            xmlNode.setAttribute(FIELD_PSSYSRESOURCEID, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getPSSysResourceName() != null) {
            object = pSDETBItemBase.getPSSysResourceName();
            xmlNode.setAttribute(FIELD_PSSYSRESOURCENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getPSSystemId() != null) {
            object = pSDETBItemBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getPSSysUniResId() != null) {
            object = pSDETBItemBase.getPSSysUniResId();
            xmlNode.setAttribute(FIELD_PSSYSUNIRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getPSSysUniResName() != null) {
            object = pSDETBItemBase.getPSSysUniResName();
            xmlNode.setAttribute(FIELD_PSSYSUNIRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getRawContent() != null) {
            object = pSDETBItemBase.getRawContent();
            xmlNode.setAttribute(FIELD_RAWCONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getRawCssStyle() != null) {
            object = pSDETBItemBase.getRawCssStyle();
            xmlNode.setAttribute(FIELD_RAWCSSSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getShowMode() != null) {
            object = pSDETBItemBase.getShowMode();
            xmlNode.setAttribute(FIELD_SHOWMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getSpanFlag() != null) {
            object = pSDETBItemBase.getSpanFlag();
            xmlNode.setAttribute(FIELD_SPANFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETBItemBase.getTBItemType() != null) {
            object = pSDETBItemBase.getTBItemType();
            xmlNode.setAttribute(FIELD_TBITEMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getTemplateMode() != null) {
            object = pSDETBItemBase.getTemplateMode();
            xmlNode.setAttribute(FIELD_TEMPLATEMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETBItemBase.getTipPSLanResId() != null) {
            object = pSDETBItemBase.getTipPSLanResId();
            xmlNode.setAttribute(FIELD_TIPPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getTipPSLanResName() != null) {
            object = pSDETBItemBase.getTipPSLanResName();
            xmlNode.setAttribute(FIELD_TIPPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getToggleMode() != null) {
            object = pSDETBItemBase.getToggleMode();
            xmlNode.setAttribute(FIELD_TOGGLEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getTooltipInfo() != null) {
            object = pSDETBItemBase.getTooltipInfo();
            xmlNode.setAttribute(FIELD_TOOLTIPINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getUIActionParams() != null) {
            object = pSDETBItemBase.getUIActionParams();
            xmlNode.setAttribute(FIELD_UIACTIONPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getUpdateDate() != null) {
            object = pSDETBItemBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDETBItemBase.getUpdateMan() != null) {
            object = pSDETBItemBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getUserParams() != null) {
            object = pSDETBItemBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getUserTag() != null) {
            object = pSDETBItemBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getUserTag2() != null) {
            object = pSDETBItemBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getVisibleLogic() != null) {
            object = pSDETBItemBase.getVisibleLogic();
            xmlNode.setAttribute(FIELD_VISIBLELOGIC, object == null ? "" : (String)object);
        }
        if (bl || pSDETBItemBase.getWidth() != null) {
            object = pSDETBItemBase.getWidth();
            xmlNode.setAttribute(FIELD_WIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDETBItemBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDETBItemBase pSDETBItemBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDETBItemBase.isActionLevelDirty() && (bl || pSDETBItemBase.getActionLevel() != null)) {
            iDataObject.set(FIELD_ACTIONLEVEL, (Object)pSDETBItemBase.getActionLevel());
        }
        if (pSDETBItemBase.isBorderStyleDirty() && (bl || pSDETBItemBase.getBorderStyle() != null)) {
            iDataObject.set(FIELD_BORDERSTYLE, (Object)pSDETBItemBase.getBorderStyle());
        }
        if (pSDETBItemBase.isBtnActionTypeDirty() && (bl || pSDETBItemBase.getBtnActionType() != null)) {
            iDataObject.set(FIELD_BTNACTIONTYPE, (Object)pSDETBItemBase.getBtnActionType());
        }
        if (pSDETBItemBase.isCapPSLanResIdDirty() && (bl || pSDETBItemBase.getCapPSLanResId() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESID, (Object)pSDETBItemBase.getCapPSLanResId());
        }
        if (pSDETBItemBase.isCapPSLanResNameDirty() && (bl || pSDETBItemBase.getCapPSLanResName() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESNAME, (Object)pSDETBItemBase.getCapPSLanResName());
        }
        if (pSDETBItemBase.isCaptionDirty() && (bl || pSDETBItemBase.getCaption() != null)) {
            iDataObject.set(FIELD_CAPTION, (Object)pSDETBItemBase.getCaption());
        }
        if (pSDETBItemBase.isCodeNameDirty() && (bl || pSDETBItemBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDETBItemBase.getCodeName());
        }
        if (pSDETBItemBase.isContentTypeDirty() && (bl || pSDETBItemBase.getContentType() != null)) {
            iDataObject.set(FIELD_CONTENTTYPE, (Object)pSDETBItemBase.getContentType());
        }
        if (pSDETBItemBase.isCounterIdDirty() && (bl || pSDETBItemBase.getCounterId() != null)) {
            iDataObject.set(FIELD_COUNTERID, (Object)pSDETBItemBase.getCounterId());
        }
        if (pSDETBItemBase.isCounterModeDirty() && (bl || pSDETBItemBase.getCounterMode() != null)) {
            iDataObject.set(FIELD_COUNTERMODE, (Object)pSDETBItemBase.getCounterMode());
        }
        if (pSDETBItemBase.isCreateDateDirty() && (bl || pSDETBItemBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDETBItemBase.getCreateDate());
        }
        if (pSDETBItemBase.isCreateManDirty() && (bl || pSDETBItemBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDETBItemBase.getCreateMan());
        }
        if (pSDETBItemBase.isCssIdDirty() && (bl || pSDETBItemBase.getCssId() != null)) {
            iDataObject.set(FIELD_CSSID, (Object)pSDETBItemBase.getCssId());
        }
        if (pSDETBItemBase.isCustomCodeDirty() && (bl || pSDETBItemBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSDETBItemBase.getCustomCode());
        }
        if (pSDETBItemBase.isDataDirty() && (bl || pSDETBItemBase.getData() != null)) {
            iDataObject.set(FIELD_DATA, (Object)pSDETBItemBase.getData());
        }
        if (pSDETBItemBase.isDefaultFlagDirty() && (bl || pSDETBItemBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSDETBItemBase.getDefaultFlag());
        }
        if (pSDETBItemBase.isDEUACapDirty() && (bl || pSDETBItemBase.getDEUACap() != null)) {
            iDataObject.set(FIELD_DEUACAP, (Object)pSDETBItemBase.getDEUACap());
        }
        if (pSDETBItemBase.isDynaClassDirty() && (bl || pSDETBItemBase.getDynaClass() != null)) {
            iDataObject.set(FIELD_DYNACLASS, (Object)pSDETBItemBase.getDynaClass());
        }
        if (pSDETBItemBase.isEnableLogicDirty() && (bl || pSDETBItemBase.getEnableLogic() != null)) {
            iDataObject.set(FIELD_ENABLELOGIC, (Object)pSDETBItemBase.getEnableLogic());
        }
        if (pSDETBItemBase.isGroupExtractModeDirty() && (bl || pSDETBItemBase.getGroupExtractMode() != null)) {
            iDataObject.set(FIELD_GROUPEXTRACTMODE, (Object)pSDETBItemBase.getGroupExtractMode());
        }
        if (pSDETBItemBase.isHeightDirty() && (bl || pSDETBItemBase.getHeight() != null)) {
            iDataObject.set(FIELD_HEIGHT, (Object)pSDETBItemBase.getHeight());
        }
        if (pSDETBItemBase.isHiddenItemDirty() && (bl || pSDETBItemBase.getHiddenItem() != null)) {
            iDataObject.set(FIELD_HIDDENITEM, (Object)pSDETBItemBase.getHiddenItem());
        }
        if (pSDETBItemBase.isHtmlContentDirty() && (bl || pSDETBItemBase.getHtmlContent() != null)) {
            iDataObject.set(FIELD_HTMLCONTENT, (Object)pSDETBItemBase.getHtmlContent());
        }
        if (pSDETBItemBase.isHtmlPageUrlDirty() && (bl || pSDETBItemBase.getHtmlPageUrl() != null)) {
            iDataObject.set(FIELD_HTMLPAGEURL, (Object)pSDETBItemBase.getHtmlPageUrl());
        }
        if (pSDETBItemBase.isItemStyleDirty() && (bl || pSDETBItemBase.getItemStyle() != null)) {
            iDataObject.set(FIELD_ITEMSTYLE, (Object)pSDETBItemBase.getItemStyle());
        }
        if (pSDETBItemBase.isItemStyleTextDirty() && (bl || pSDETBItemBase.getItemStyleText() != null)) {
            iDataObject.set(FIELD_ITEMSTYLETEXT, (Object)pSDETBItemBase.getItemStyleText());
        }
        if (pSDETBItemBase.isLevelTagDirty() && (bl || pSDETBItemBase.getLevelTag() != null)) {
            iDataObject.set(FIELD_LEVELTAG, (Object)pSDETBItemBase.getLevelTag());
        }
        if (pSDETBItemBase.isLevelValueDirty() && (bl || pSDETBItemBase.getLevelValue() != null)) {
            iDataObject.set(FIELD_LEVELVALUE, (Object)pSDETBItemBase.getLevelValue());
        }
        if (pSDETBItemBase.isMemoDirty() && (bl || pSDETBItemBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDETBItemBase.getMemo());
        }
        if (pSDETBItemBase.isNoPrivDMDirty() && (bl || pSDETBItemBase.getNoPrivDM() != null)) {
            iDataObject.set(FIELD_NOPRIVDM, (Object)pSDETBItemBase.getNoPrivDM());
        }
        if (pSDETBItemBase.isOpenPSAppViewIdDirty() && (bl || pSDETBItemBase.getOpenPSAppViewId() != null)) {
            iDataObject.set(FIELD_OPENPSAPPVIEWID, (Object)pSDETBItemBase.getOpenPSAppViewId());
        }
        if (pSDETBItemBase.isOpenPSAppViewNameDirty() && (bl || pSDETBItemBase.getOpenPSAppViewName() != null)) {
            iDataObject.set(FIELD_OPENPSAPPVIEWNAME, (Object)pSDETBItemBase.getOpenPSAppViewName());
        }
        if (pSDETBItemBase.isOpenPSDEViewIdDirty() && (bl || pSDETBItemBase.getOpenPSDEViewId() != null)) {
            iDataObject.set(FIELD_OPENPSDEVIEWID, (Object)pSDETBItemBase.getOpenPSDEViewId());
        }
        if (pSDETBItemBase.isOpenPSDEViewNameDirty() && (bl || pSDETBItemBase.getOpenPSDEViewName() != null)) {
            iDataObject.set(FIELD_OPENPSDEVIEWNAME, (Object)pSDETBItemBase.getOpenPSDEViewName());
        }
        if (pSDETBItemBase.isOpenPSSysPDTViewIdDirty() && (bl || pSDETBItemBase.getOpenPSSysPDTViewId() != null)) {
            iDataObject.set(FIELD_OPENPSSYSPDTVIEWID, (Object)pSDETBItemBase.getOpenPSSysPDTViewId());
        }
        if (pSDETBItemBase.isOpenPSSysPDTViewNameDirty() && (bl || pSDETBItemBase.getOpenPSSysPDTViewName() != null)) {
            iDataObject.set(FIELD_OPENPSSYSPDTVIEWNAME, (Object)pSDETBItemBase.getOpenPSSysPDTViewName());
        }
        if (pSDETBItemBase.isOrderValueDirty() && (bl || pSDETBItemBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDETBItemBase.getOrderValue());
        }
        if (pSDETBItemBase.isPPSDETBItemIdDirty() && (bl || pSDETBItemBase.getPPSDETBItemId() != null)) {
            iDataObject.set(FIELD_PPSDETBITEMID, (Object)pSDETBItemBase.getPPSDETBItemId());
        }
        if (pSDETBItemBase.isPPSDETBItemNameDirty() && (bl || pSDETBItemBase.getPPSDETBItemName() != null)) {
            iDataObject.set(FIELD_PPSDETBITEMNAME, (Object)pSDETBItemBase.getPPSDETBItemName());
        }
        if (pSDETBItemBase.isPredefinedTypeDirty() && (bl || pSDETBItemBase.getPredefinedType() != null)) {
            iDataObject.set(FIELD_PREDEFINEDTYPE, (Object)pSDETBItemBase.getPredefinedType());
        }
        if (pSDETBItemBase.isPredefinedTypeTextDirty() && (bl || pSDETBItemBase.getPredefinedTypeText() != null)) {
            iDataObject.set(FIELD_PREDEFINEDTYPETEXT, (Object)pSDETBItemBase.getPredefinedTypeText());
        }
        if (pSDETBItemBase.isPreviewHtmlDirty() && (bl || pSDETBItemBase.getPreviewHtml() != null)) {
            iDataObject.set(FIELD_PREVIEWHTML, (Object)pSDETBItemBase.getPreviewHtml());
        }
        if (pSDETBItemBase.isPSDEIdDirty() && (bl || pSDETBItemBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDETBItemBase.getPSDEId());
        }
        if (pSDETBItemBase.isPSDELogicIdDirty() && (bl || pSDETBItemBase.getPSDELogicId() != null)) {
            iDataObject.set(FIELD_PSDELOGICID, (Object)pSDETBItemBase.getPSDELogicId());
        }
        if (pSDETBItemBase.isPSDELogicNameDirty() && (bl || pSDETBItemBase.getPSDELogicName() != null)) {
            iDataObject.set(FIELD_PSDELOGICNAME, (Object)pSDETBItemBase.getPSDELogicName());
        }
        if (pSDETBItemBase.isPSDETBItemIdDirty() && (bl || pSDETBItemBase.getPSDETBItemId() != null)) {
            iDataObject.set(FIELD_PSDETBITEMID, (Object)pSDETBItemBase.getPSDETBItemId());
        }
        if (pSDETBItemBase.isPSDETBItemNameDirty() && (bl || pSDETBItemBase.getPSDETBItemName() != null)) {
            iDataObject.set(FIELD_PSDETBITEMNAME, (Object)pSDETBItemBase.getPSDETBItemName());
        }
        if (pSDETBItemBase.isPSDEToolbarIdDirty() && (bl || pSDETBItemBase.getPSDEToolbarId() != null)) {
            iDataObject.set(FIELD_PSDETOOLBARID, (Object)pSDETBItemBase.getPSDEToolbarId());
        }
        if (pSDETBItemBase.isPSDEToolbarNameDirty() && (bl || pSDETBItemBase.getPSDEToolbarName() != null)) {
            iDataObject.set(FIELD_PSDETOOLBARNAME, (Object)pSDETBItemBase.getPSDEToolbarName());
        }
        if (pSDETBItemBase.isPSDEUAGroupIdDirty() && (bl || pSDETBItemBase.getPSDEUAGroupId() != null)) {
            iDataObject.set(FIELD_PSDEUAGROUPID, (Object)pSDETBItemBase.getPSDEUAGroupId());
        }
        if (pSDETBItemBase.isPSDEUAGroupNameDirty() && (bl || pSDETBItemBase.getPSDEUAGroupName() != null)) {
            iDataObject.set(FIELD_PSDEUAGROUPNAME, (Object)pSDETBItemBase.getPSDEUAGroupName());
        }
        if (pSDETBItemBase.isPSDEUIActionIdDirty() && (bl || pSDETBItemBase.getPSDEUIActionId() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONID, (Object)pSDETBItemBase.getPSDEUIActionId());
        }
        if (pSDETBItemBase.isPSDEUIActionNameDirty() && (bl || pSDETBItemBase.getPSDEUIActionName() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONNAME, (Object)pSDETBItemBase.getPSDEUIActionName());
        }
        if (pSDETBItemBase.isPSSysCssIdDirty() && (bl || pSDETBItemBase.getPSSysCssId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSID, (Object)pSDETBItemBase.getPSSysCssId());
        }
        if (pSDETBItemBase.isPSSysCssNameDirty() && (bl || pSDETBItemBase.getPSSysCssName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSNAME, (Object)pSDETBItemBase.getPSSysCssName());
        }
        if (pSDETBItemBase.isPSSysImageIdDirty() && (bl || pSDETBItemBase.getPSSysImageId() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGEID, (Object)pSDETBItemBase.getPSSysImageId());
        }
        if (pSDETBItemBase.isPSSysImageNameDirty() && (bl || pSDETBItemBase.getPSSysImageName() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGENAME, (Object)pSDETBItemBase.getPSSysImageName());
        }
        if (pSDETBItemBase.isPSSysPFPluginIdDirty() && (bl || pSDETBItemBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSDETBItemBase.getPSSysPFPluginId());
        }
        if (pSDETBItemBase.isPSSysPFPluginNameDirty() && (bl || pSDETBItemBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSDETBItemBase.getPSSysPFPluginName());
        }
        if (pSDETBItemBase.isPSSysResourceIdDirty() && (bl || pSDETBItemBase.getPSSysResourceId() != null)) {
            iDataObject.set(FIELD_PSSYSRESOURCEID, (Object)pSDETBItemBase.getPSSysResourceId());
        }
        if (pSDETBItemBase.isPSSysResourceNameDirty() && (bl || pSDETBItemBase.getPSSysResourceName() != null)) {
            iDataObject.set(FIELD_PSSYSRESOURCENAME, (Object)pSDETBItemBase.getPSSysResourceName());
        }
        if (pSDETBItemBase.isPSSystemIdDirty() && (bl || pSDETBItemBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSDETBItemBase.getPSSystemId());
        }
        if (pSDETBItemBase.isPSSysUniResIdDirty() && (bl || pSDETBItemBase.getPSSysUniResId() != null)) {
            iDataObject.set(FIELD_PSSYSUNIRESID, (Object)pSDETBItemBase.getPSSysUniResId());
        }
        if (pSDETBItemBase.isPSSysUniResNameDirty() && (bl || pSDETBItemBase.getPSSysUniResName() != null)) {
            iDataObject.set(FIELD_PSSYSUNIRESNAME, (Object)pSDETBItemBase.getPSSysUniResName());
        }
        if (pSDETBItemBase.isRawContentDirty() && (bl || pSDETBItemBase.getRawContent() != null)) {
            iDataObject.set(FIELD_RAWCONTENT, (Object)pSDETBItemBase.getRawContent());
        }
        if (pSDETBItemBase.isRawCssStyleDirty() && (bl || pSDETBItemBase.getRawCssStyle() != null)) {
            iDataObject.set(FIELD_RAWCSSSTYLE, (Object)pSDETBItemBase.getRawCssStyle());
        }
        if (pSDETBItemBase.isShowModeDirty() && (bl || pSDETBItemBase.getShowMode() != null)) {
            iDataObject.set(FIELD_SHOWMODE, (Object)pSDETBItemBase.getShowMode());
        }
        if (pSDETBItemBase.isSpanFlagDirty() && (bl || pSDETBItemBase.getSpanFlag() != null)) {
            iDataObject.set(FIELD_SPANFLAG, (Object)pSDETBItemBase.getSpanFlag());
        }
        if (pSDETBItemBase.isTBItemTypeDirty() && (bl || pSDETBItemBase.getTBItemType() != null)) {
            iDataObject.set(FIELD_TBITEMTYPE, (Object)pSDETBItemBase.getTBItemType());
        }
        if (pSDETBItemBase.isTemplateModeDirty() && (bl || pSDETBItemBase.getTemplateMode() != null)) {
            iDataObject.set(FIELD_TEMPLATEMODE, (Object)pSDETBItemBase.getTemplateMode());
        }
        if (pSDETBItemBase.isTipPSLanResIdDirty() && (bl || pSDETBItemBase.getTipPSLanResId() != null)) {
            iDataObject.set(FIELD_TIPPSLANRESID, (Object)pSDETBItemBase.getTipPSLanResId());
        }
        if (pSDETBItemBase.isTipPSLanResNameDirty() && (bl || pSDETBItemBase.getTipPSLanResName() != null)) {
            iDataObject.set(FIELD_TIPPSLANRESNAME, (Object)pSDETBItemBase.getTipPSLanResName());
        }
        if (pSDETBItemBase.isToggleModeDirty() && (bl || pSDETBItemBase.getToggleMode() != null)) {
            iDataObject.set(FIELD_TOGGLEMODE, (Object)pSDETBItemBase.getToggleMode());
        }
        if (pSDETBItemBase.isTooltipInfoDirty() && (bl || pSDETBItemBase.getTooltipInfo() != null)) {
            iDataObject.set(FIELD_TOOLTIPINFO, (Object)pSDETBItemBase.getTooltipInfo());
        }
        if (pSDETBItemBase.isUIActionParamsDirty() && (bl || pSDETBItemBase.getUIActionParams() != null)) {
            iDataObject.set(FIELD_UIACTIONPARAMS, (Object)pSDETBItemBase.getUIActionParams());
        }
        if (pSDETBItemBase.isUpdateDateDirty() && (bl || pSDETBItemBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDETBItemBase.getUpdateDate());
        }
        if (pSDETBItemBase.isUpdateManDirty() && (bl || pSDETBItemBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDETBItemBase.getUpdateMan());
        }
        if (pSDETBItemBase.isUserParamsDirty() && (bl || pSDETBItemBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSDETBItemBase.getUserParams());
        }
        if (pSDETBItemBase.isUserTagDirty() && (bl || pSDETBItemBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDETBItemBase.getUserTag());
        }
        if (pSDETBItemBase.isUserTag2Dirty() && (bl || pSDETBItemBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDETBItemBase.getUserTag2());
        }
        if (pSDETBItemBase.isVisibleLogicDirty() && (bl || pSDETBItemBase.getVisibleLogic() != null)) {
            iDataObject.set(FIELD_VISIBLELOGIC, (Object)pSDETBItemBase.getVisibleLogic());
        }
        if (pSDETBItemBase.isWidthDirty() && (bl || pSDETBItemBase.getWidth() != null)) {
            iDataObject.set(FIELD_WIDTH, (Object)pSDETBItemBase.getWidth());
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
        return PSDETBItemBase.remove(this, n);
    }

    private static boolean remove(PSDETBItemBase pSDETBItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDETBItemBase.resetActionLevel();
                return true;
            }
            case 1: {
                pSDETBItemBase.resetBorderStyle();
                return true;
            }
            case 2: {
                pSDETBItemBase.resetBtnActionType();
                return true;
            }
            case 3: {
                pSDETBItemBase.resetCapPSLanResId();
                return true;
            }
            case 4: {
                pSDETBItemBase.resetCapPSLanResName();
                return true;
            }
            case 5: {
                pSDETBItemBase.resetCaption();
                return true;
            }
            case 6: {
                pSDETBItemBase.resetCodeName();
                return true;
            }
            case 7: {
                pSDETBItemBase.resetContentType();
                return true;
            }
            case 8: {
                pSDETBItemBase.resetCounterId();
                return true;
            }
            case 9: {
                pSDETBItemBase.resetCounterMode();
                return true;
            }
            case 10: {
                pSDETBItemBase.resetCreateDate();
                return true;
            }
            case 11: {
                pSDETBItemBase.resetCreateMan();
                return true;
            }
            case 12: {
                pSDETBItemBase.resetCssId();
                return true;
            }
            case 13: {
                pSDETBItemBase.resetCustomCode();
                return true;
            }
            case 14: {
                pSDETBItemBase.resetData();
                return true;
            }
            case 15: {
                pSDETBItemBase.resetDefaultFlag();
                return true;
            }
            case 16: {
                pSDETBItemBase.resetDEUACap();
                return true;
            }
            case 17: {
                pSDETBItemBase.resetDynaClass();
                return true;
            }
            case 18: {
                pSDETBItemBase.resetEnableLogic();
                return true;
            }
            case 19: {
                pSDETBItemBase.resetGroupExtractMode();
                return true;
            }
            case 20: {
                pSDETBItemBase.resetHeight();
                return true;
            }
            case 21: {
                pSDETBItemBase.resetHiddenItem();
                return true;
            }
            case 22: {
                pSDETBItemBase.resetHtmlContent();
                return true;
            }
            case 23: {
                pSDETBItemBase.resetHtmlPageUrl();
                return true;
            }
            case 24: {
                pSDETBItemBase.resetItemStyle();
                return true;
            }
            case 25: {
                pSDETBItemBase.resetItemStyleText();
                return true;
            }
            case 26: {
                pSDETBItemBase.resetLevelTag();
                return true;
            }
            case 27: {
                pSDETBItemBase.resetLevelValue();
                return true;
            }
            case 28: {
                pSDETBItemBase.resetMemo();
                return true;
            }
            case 29: {
                pSDETBItemBase.resetNoPrivDM();
                return true;
            }
            case 30: {
                pSDETBItemBase.resetOpenPSAppViewId();
                return true;
            }
            case 31: {
                pSDETBItemBase.resetOpenPSAppViewName();
                return true;
            }
            case 32: {
                pSDETBItemBase.resetOpenPSDEViewId();
                return true;
            }
            case 33: {
                pSDETBItemBase.resetOpenPSDEViewName();
                return true;
            }
            case 34: {
                pSDETBItemBase.resetOpenPSSysPDTViewId();
                return true;
            }
            case 35: {
                pSDETBItemBase.resetOpenPSSysPDTViewName();
                return true;
            }
            case 36: {
                pSDETBItemBase.resetOrderValue();
                return true;
            }
            case 37: {
                pSDETBItemBase.resetPPSDETBItemId();
                return true;
            }
            case 38: {
                pSDETBItemBase.resetPPSDETBItemName();
                return true;
            }
            case 39: {
                pSDETBItemBase.resetPredefinedType();
                return true;
            }
            case 40: {
                pSDETBItemBase.resetPredefinedTypeText();
                return true;
            }
            case 41: {
                pSDETBItemBase.resetPreviewHtml();
                return true;
            }
            case 42: {
                pSDETBItemBase.resetPSDEId();
                return true;
            }
            case 43: {
                pSDETBItemBase.resetPSDELogicId();
                return true;
            }
            case 44: {
                pSDETBItemBase.resetPSDELogicName();
                return true;
            }
            case 45: {
                pSDETBItemBase.resetPSDETBItemId();
                return true;
            }
            case 46: {
                pSDETBItemBase.resetPSDETBItemName();
                return true;
            }
            case 47: {
                pSDETBItemBase.resetPSDEToolbarId();
                return true;
            }
            case 48: {
                pSDETBItemBase.resetPSDEToolbarName();
                return true;
            }
            case 49: {
                pSDETBItemBase.resetPSDEUAGroupId();
                return true;
            }
            case 50: {
                pSDETBItemBase.resetPSDEUAGroupName();
                return true;
            }
            case 51: {
                pSDETBItemBase.resetPSDEUIActionId();
                return true;
            }
            case 52: {
                pSDETBItemBase.resetPSDEUIActionName();
                return true;
            }
            case 53: {
                pSDETBItemBase.resetPSSysCssId();
                return true;
            }
            case 54: {
                pSDETBItemBase.resetPSSysCssName();
                return true;
            }
            case 55: {
                pSDETBItemBase.resetPSSysImageId();
                return true;
            }
            case 56: {
                pSDETBItemBase.resetPSSysImageName();
                return true;
            }
            case 57: {
                pSDETBItemBase.resetPSSysPFPluginId();
                return true;
            }
            case 58: {
                pSDETBItemBase.resetPSSysPFPluginName();
                return true;
            }
            case 59: {
                pSDETBItemBase.resetPSSysResourceId();
                return true;
            }
            case 60: {
                pSDETBItemBase.resetPSSysResourceName();
                return true;
            }
            case 61: {
                pSDETBItemBase.resetPSSystemId();
                return true;
            }
            case 62: {
                pSDETBItemBase.resetPSSysUniResId();
                return true;
            }
            case 63: {
                pSDETBItemBase.resetPSSysUniResName();
                return true;
            }
            case 64: {
                pSDETBItemBase.resetRawContent();
                return true;
            }
            case 65: {
                pSDETBItemBase.resetRawCssStyle();
                return true;
            }
            case 66: {
                pSDETBItemBase.resetShowMode();
                return true;
            }
            case 67: {
                pSDETBItemBase.resetSpanFlag();
                return true;
            }
            case 68: {
                pSDETBItemBase.resetTBItemType();
                return true;
            }
            case 69: {
                pSDETBItemBase.resetTemplateMode();
                return true;
            }
            case 70: {
                pSDETBItemBase.resetTipPSLanResId();
                return true;
            }
            case 71: {
                pSDETBItemBase.resetTipPSLanResName();
                return true;
            }
            case 72: {
                pSDETBItemBase.resetToggleMode();
                return true;
            }
            case 73: {
                pSDETBItemBase.resetTooltipInfo();
                return true;
            }
            case 74: {
                pSDETBItemBase.resetUIActionParams();
                return true;
            }
            case 75: {
                pSDETBItemBase.resetUpdateDate();
                return true;
            }
            case 76: {
                pSDETBItemBase.resetUpdateMan();
                return true;
            }
            case 77: {
                pSDETBItemBase.resetUserParams();
                return true;
            }
            case 78: {
                pSDETBItemBase.resetUserTag();
                return true;
            }
            case 79: {
                pSDETBItemBase.resetUserTag2();
                return true;
            }
            case 80: {
                pSDETBItemBase.resetVisibleLogic();
                return true;
            }
            case 81: {
                pSDETBItemBase.resetWidth();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
                pSAppViewService.autoGet((IEntity)pSAppView);
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
                pSDELogicService.autoGet((IEntity)pSDELogic);
                this.psdelogic = pSDELogic;
            }
            return this.psdelogic;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDETBItem getPPSDETBItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDETBItem();
        }
        if (this.getPPSDETBItemId() == null) {
            return null;
        }
        Integer n = this.objPPSDETBItemLock;
        synchronized (n) {
            if (this.ppsdetbitem != null && DataTypeHelper.compare((int)25, (Object)this.getPPSDETBItemId(), (Object)this.ppsdetbitem.getPSDETBItemId()) != 0L) {
                this.ppsdetbitem = null;
            }
            if (this.ppsdetbitem == null) {
                PSDETBItem pSDETBItem = new PSDETBItem();
                pSDETBItem.setPSDETBItemId(this.getPPSDETBItemId());
                PSDETBItemService pSDETBItemService = (PSDETBItemService)ServiceGlobal.getService(PSDETBItemService.class, (SessionFactory)this.getSessionFactory());
                pSDETBItemService.autoGet((IEntity)pSDETBItem);
                this.ppsdetbitem = pSDETBItem;
            }
            return this.ppsdetbitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEToolbar getPSDEToolbar() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEToolbar();
        }
        if (this.getPSDEToolbarId() == null) {
            return null;
        }
        Integer n = this.objPSDEToolbarLock;
        synchronized (n) {
            if (this.psdetoolbar != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEToolbarId(), (Object)this.psdetoolbar.getPSDEToolbarId()) != 0L) {
                this.psdetoolbar = null;
            }
            if (this.psdetoolbar == null) {
                PSDEToolbar pSDEToolbar = new PSDEToolbar();
                pSDEToolbar.setPSDEToolbarId(this.getPSDEToolbarId());
                PSDEToolbarService pSDEToolbarService = (PSDEToolbarService)ServiceGlobal.getService(PSDEToolbarService.class, (SessionFactory)this.getSessionFactory());
                pSDEToolbarService.autoGet((IEntity)pSDEToolbar);
                this.psdetoolbar = pSDEToolbar;
            }
            return this.psdetoolbar;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEUAGroup getPSDEUAGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUAGroup();
        }
        if (this.getPSDEUAGroupId() == null) {
            return null;
        }
        Integer n = this.objPSDEUAGroupLock;
        synchronized (n) {
            if (this.psdeuagroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEUAGroupId(), (Object)this.psdeuagroup.getPSDEUAGroupId()) != 0L) {
                this.psdeuagroup = null;
            }
            if (this.psdeuagroup == null) {
                PSDEUAGroup pSDEUAGroup = new PSDEUAGroup();
                pSDEUAGroup.setPSDEUAGroupId(this.getPSDEUAGroupId());
                PSDEUAGroupService pSDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEUAGroupService.autoGet((IEntity)pSDEUAGroup);
                this.psdeuagroup = pSDEUAGroup;
            }
            return this.psdeuagroup;
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
                pSDEUIActionService.autoGet((IEntity)pSDEUIAction);
                this.psdeuiaction = pSDEUIAction;
            }
            return this.psdeuiaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getOpenPSDEView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOpenPSDEView();
        }
        if (this.getOpenPSDEViewId() == null) {
            return null;
        }
        Integer n = this.objOpenPSDEViewLock;
        synchronized (n) {
            if (this.openpsdeview != null && DataTypeHelper.compare((int)25, (Object)this.getOpenPSDEViewId(), (Object)this.openpsdeview.getPSDEViewBaseId()) != 0L) {
                this.openpsdeview = null;
            }
            if (this.openpsdeview == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getOpenPSDEViewId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet((IEntity)pSDEViewBase);
                this.openpsdeview = pSDEViewBase;
            }
            return this.openpsdeview;
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
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
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
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
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
    public PSSysPDTView getOpenPSSysPDTView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOpenPSSysPDTView();
        }
        if (this.getOpenPSSysPDTViewId() == null) {
            return null;
        }
        Integer n = this.objOpenPSSysPDTViewLock;
        synchronized (n) {
            if (this.openpssyspdtview != null && DataTypeHelper.compare((int)25, (Object)this.getOpenPSSysPDTViewId(), (Object)this.openpssyspdtview.getPSSysPDTViewId()) != 0L) {
                this.openpssyspdtview = null;
            }
            if (this.openpssyspdtview == null) {
                PSSysPDTView pSSysPDTView = new PSSysPDTView();
                pSSysPDTView.setPSSysPDTViewId(this.getOpenPSSysPDTViewId());
                PSSysPDTViewService pSSysPDTViewService = (PSSysPDTViewService)ServiceGlobal.getService(PSSysPDTViewService.class, (SessionFactory)this.getSessionFactory());
                pSSysPDTViewService.autoGet((IEntity)pSSysPDTView);
                this.openpssyspdtview = pSSysPDTView;
            }
            return this.openpssyspdtview;
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
    public ArrayList<PSDETBItem> getPSDETBItems() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETBItems();
        }
        if (this.getPSDETBItemId() == null) {
            return null;
        }
        PSDETBItemService pSDETBItemService = (PSDETBItemService)ServiceGlobal.getService(PSDETBItemService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDETBItemsLock;
        synchronized (n) {
            if (this.psdetbitems == null) {
                this.psdetbitems = pSDETBItemService.selectByPPSDETBItem(this);
            }
            return this.psdetbitems;
        }
    }

    private PSDETBItemBase getProxyEntity() {
        return this.proxyPSDETBItemBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDETBItemBase = null;
        if (iDataObject != null && iDataObject instanceof PSDETBItemBase) {
            this.proxyPSDETBItemBase = (PSDETBItemBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDETBItemService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACTIONLEVEL, 0);
        fieldIndexMap.put(FIELD_BORDERSTYLE, 1);
        fieldIndexMap.put(FIELD_BTNACTIONTYPE, 2);
        fieldIndexMap.put(FIELD_CAPPSLANRESID, 3);
        fieldIndexMap.put(FIELD_CAPPSLANRESNAME, 4);
        fieldIndexMap.put(FIELD_CAPTION, 5);
        fieldIndexMap.put(FIELD_CODENAME, 6);
        fieldIndexMap.put(FIELD_CONTENTTYPE, 7);
        fieldIndexMap.put(FIELD_COUNTERID, 8);
        fieldIndexMap.put(FIELD_COUNTERMODE, 9);
        fieldIndexMap.put(FIELD_CREATEDATE, 10);
        fieldIndexMap.put(FIELD_CREATEMAN, 11);
        fieldIndexMap.put(FIELD_CSSID, 12);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 13);
        fieldIndexMap.put(FIELD_DATA, 14);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 15);
        fieldIndexMap.put(FIELD_DEUACAP, 16);
        fieldIndexMap.put(FIELD_DYNACLASS, 17);
        fieldIndexMap.put(FIELD_ENABLELOGIC, 18);
        fieldIndexMap.put(FIELD_GROUPEXTRACTMODE, 19);
        fieldIndexMap.put(FIELD_HEIGHT, 20);
        fieldIndexMap.put(FIELD_HIDDENITEM, 21);
        fieldIndexMap.put(FIELD_HTMLCONTENT, 22);
        fieldIndexMap.put(FIELD_HTMLPAGEURL, 23);
        fieldIndexMap.put(FIELD_ITEMSTYLE, 24);
        fieldIndexMap.put(FIELD_ITEMSTYLETEXT, 25);
        fieldIndexMap.put(FIELD_LEVELTAG, 26);
        fieldIndexMap.put(FIELD_LEVELVALUE, 27);
        fieldIndexMap.put(FIELD_MEMO, 28);
        fieldIndexMap.put(FIELD_NOPRIVDM, 29);
        fieldIndexMap.put(FIELD_OPENPSAPPVIEWID, 30);
        fieldIndexMap.put(FIELD_OPENPSAPPVIEWNAME, 31);
        fieldIndexMap.put(FIELD_OPENPSDEVIEWID, 32);
        fieldIndexMap.put(FIELD_OPENPSDEVIEWNAME, 33);
        fieldIndexMap.put(FIELD_OPENPSSYSPDTVIEWID, 34);
        fieldIndexMap.put(FIELD_OPENPSSYSPDTVIEWNAME, 35);
        fieldIndexMap.put(FIELD_ORDERVALUE, 36);
        fieldIndexMap.put(FIELD_PPSDETBITEMID, 37);
        fieldIndexMap.put(FIELD_PPSDETBITEMNAME, 38);
        fieldIndexMap.put(FIELD_PREDEFINEDTYPE, 39);
        fieldIndexMap.put(FIELD_PREDEFINEDTYPETEXT, 40);
        fieldIndexMap.put(FIELD_PREVIEWHTML, 41);
        fieldIndexMap.put(FIELD_PSDEID, 42);
        fieldIndexMap.put(FIELD_PSDELOGICID, 43);
        fieldIndexMap.put(FIELD_PSDELOGICNAME, 44);
        fieldIndexMap.put(FIELD_PSDETBITEMID, 45);
        fieldIndexMap.put(FIELD_PSDETBITEMNAME, 46);
        fieldIndexMap.put(FIELD_PSDETOOLBARID, 47);
        fieldIndexMap.put(FIELD_PSDETOOLBARNAME, 48);
        fieldIndexMap.put(FIELD_PSDEUAGROUPID, 49);
        fieldIndexMap.put(FIELD_PSDEUAGROUPNAME, 50);
        fieldIndexMap.put(FIELD_PSDEUIACTIONID, 51);
        fieldIndexMap.put(FIELD_PSDEUIACTIONNAME, 52);
        fieldIndexMap.put(FIELD_PSSYSCSSID, 53);
        fieldIndexMap.put(FIELD_PSSYSCSSNAME, 54);
        fieldIndexMap.put(FIELD_PSSYSIMAGEID, 55);
        fieldIndexMap.put(FIELD_PSSYSIMAGENAME, 56);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 57);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 58);
        fieldIndexMap.put(FIELD_PSSYSRESOURCEID, 59);
        fieldIndexMap.put(FIELD_PSSYSRESOURCENAME, 60);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 61);
        fieldIndexMap.put(FIELD_PSSYSUNIRESID, 62);
        fieldIndexMap.put(FIELD_PSSYSUNIRESNAME, 63);
        fieldIndexMap.put(FIELD_RAWCONTENT, 64);
        fieldIndexMap.put(FIELD_RAWCSSSTYLE, 65);
        fieldIndexMap.put(FIELD_SHOWMODE, 66);
        fieldIndexMap.put(FIELD_SPANFLAG, 67);
        fieldIndexMap.put(FIELD_TBITEMTYPE, 68);
        fieldIndexMap.put(FIELD_TEMPLATEMODE, 69);
        fieldIndexMap.put(FIELD_TIPPSLANRESID, 70);
        fieldIndexMap.put(FIELD_TIPPSLANRESNAME, 71);
        fieldIndexMap.put(FIELD_TOGGLEMODE, 72);
        fieldIndexMap.put(FIELD_TOOLTIPINFO, 73);
        fieldIndexMap.put(FIELD_UIACTIONPARAMS, 74);
        fieldIndexMap.put(FIELD_UPDATEDATE, 75);
        fieldIndexMap.put(FIELD_UPDATEMAN, 76);
        fieldIndexMap.put(FIELD_USERPARAMS, 77);
        fieldIndexMap.put(FIELD_USERTAG, 78);
        fieldIndexMap.put(FIELD_USERTAG2, 79);
        fieldIndexMap.put(FIELD_VISIBLELOGIC, 80);
        fieldIndexMap.put(FIELD_WIDTH, 81);
    }
}

