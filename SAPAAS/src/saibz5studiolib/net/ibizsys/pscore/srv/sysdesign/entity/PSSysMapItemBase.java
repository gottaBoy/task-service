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
package net.ibizsys.pscore.srv.sysdesign.entity;

import java.io.Serializable;
import java.sql.Timestamp;
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
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbar;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMapView;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapViewService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysMapItemBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysMapItemBase.class);
    public static final String FIELD_ALTPSDEFID = "ALTPSDEFID";
    public static final String FIELD_ALTPSDEFNAME = "ALTPSDEFNAME";
    public static final String FIELD_ASYNCPSDEDSID = "ASYNCPSDEDSID";
    public static final String FIELD_ASYNCPSDEDSNAME = "ASYNCPSDEDSNAME";
    public static final String FIELD_BKCOLOR = "BKCOLOR";
    public static final String FIELD_BKCOLORPSDEFID = "BKCOLORPSDEFID";
    public static final String FIELD_BKCOLORPSDEFNAME = "BKCOLORPSDEFNAME";
    public static final String FIELD_BORDERCOLOR = "BORDERCOLOR";
    public static final String FIELD_BORDERWIDTH = "BORDERWIDTH";
    public static final String FIELD_CLSPSDEFID = "CLSPSDEFID";
    public static final String FIELD_CLSPSDEFNAME = "CLSPSDEFNAME";
    public static final String FIELD_COLOR = "COLOR";
    public static final String FIELD_COLORPSDEFID = "COLORPSDEFID";
    public static final String FIELD_COLORPSDEFNAME = "COLORPSDEFNAME";
    public static final String FIELD_CONTENTPSDEFID = "CONTENTPSDEFID";
    public static final String FIELD_CONTENTPSDEFNAME = "CONTENTPSDEFNAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCOND = "CUSTOMCOND";
    public static final String FIELD_CUSTOMTYPE = "CUSTOMTYPE";
    public static final String FIELD_DATA2PSDEFID = "DATA2PSDEFID";
    public static final String FIELD_DATA2PSDEFNAME = "DATA2PSDEFNAME";
    public static final String FIELD_DATAPSDEFID = "DATAPSDEFID";
    public static final String FIELD_DATAPSDEFNAME = "DATAPSDEFNAME";
    public static final String FIELD_DYNACLASS = "DYNACLASS";
    public static final String FIELD_GROUPPSDEFID = "GROUPPSDEFID";
    public static final String FIELD_GROUPPSDEFNAME = "GROUPPSDEFNAME";
    public static final String FIELD_GROUPPSDEUAGROUPID = "GROUPPSDEUAGROUPID";
    public static final String FIELD_GROUPPSDEUAGROUPNAME = "GROUPPSDEUAGROUPNAME";
    public static final String FIELD_ICONPSDEFID = "ICONPSDEFID";
    public static final String FIELD_ICONPSDEFNAME = "ICONPSDEFNAME";
    public static final String FIELD_ITEMSTYLE = "ITEMSTYLE";
    public static final String FIELD_ITEMSTYLETEXT = "ITEMSTYLETEXT";
    public static final String FIELD_ITEMTYPE = "ITEMTYPE";
    public static final String FIELD_KEYPSDEFID = "KEYPSDEFID";
    public static final String FIELD_KEYPSDEFNAME = "KEYPSDEFNAME";
    public static final String FIELD_LATPSDEFID = "LATPSDEFID";
    public static final String FIELD_LATPSDEFNAME = "LATPSDEFNAME";
    public static final String FIELD_LINKPSDEFID = "LINKPSDEFID";
    public static final String FIELD_LINKPSDEFNAME = "LINKPSDEFNAME";
    public static final String FIELD_LONGPSDEFID = "LONGPSDEFID";
    public static final String FIELD_LONGPSDEFNAME = "LONGPSDEFNAME";
    public static final String FIELD_MAXSIZE = "MAXSIZE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODELOBJ = "MODELOBJ";
    public static final String FIELD_MOVEPSDEACTIONID = "MOVEPSDEACTIONID";
    public static final String FIELD_MOVEPSDEACTIONNAME = "MOVEPSDEACTIONNAME";
    public static final String FIELD_MOVEPSDEOPPRIVID = "MOVEPSDEOPPRIVID";
    public static final String FIELD_MOVEPSDEOPPRIVNAME = "MOVEPSDEOPPRIVNAME";
    public static final String FIELD_NAMEPSLANRESID = "NAMEPSLANRESID";
    public static final String FIELD_NAMEPSLANRESNAME = "NAMEPSLANRESNAME";
    public static final String FIELD_NAVVIEWFILTER = "NAVVIEWFILTER";
    public static final String FIELD_NAVVIEWPARAM = "NAVVIEWPARAM";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_ORDERVALUEPSDEFID = "ORDERVALUEPSDEFID";
    public static final String FIELD_ORDERVALUEPSDEFNAME = "ORDERVALUEPSDEFNAME";
    public static final String FIELD_PSDEDSID = "PSDEDSID";
    public static final String FIELD_PSDEDSNAME = "PSDEDSNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDELOGICID = "PSDELOGICID";
    public static final String FIELD_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDERID = "PSDERID";
    public static final String FIELD_PSDERNAME = "PSDERNAME";
    public static final String FIELD_PSDETOOLBARID = "PSDETOOLBARID";
    public static final String FIELD_PSDETOOLBARNAME = "PSDETOOLBARNAME";
    public static final String FIELD_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String FIELD_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String FIELD_PSSYSCSSID = "PSSYSCSSID";
    public static final String FIELD_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String FIELD_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String FIELD_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String FIELD_PSSYSMAPITEMID = "PSSYSMAPITEMID";
    public static final String FIELD_PSSYSMAPITEMNAME = "PSSYSMAPITEMNAME";
    public static final String FIELD_PSSYSMAPVIEWID = "PSSYSMAPVIEWID";
    public static final String FIELD_PSSYSMAPVIEWNAME = "PSSYSMAPVIEWNAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_RADIUS = "RADIUS";
    public static final String FIELD_REMOVEPSDEACTIONID = "REMOVEPSDEACTIONID";
    public static final String FIELD_REMOVEPSDEACTIONNAME = "REMOVEPSDEACTIONNAME";
    public static final String FIELD_REMOVEPSDEOPPRIVID = "REMOVEPSDEOPPRIVID";
    public static final String FIELD_REMOVEPSDEOPPRIVNAME = "REMOVEPSDEOPPRIVNAME";
    public static final String FIELD_SHAPECLSPSDEFID = "SHAPECLSPSDEFID";
    public static final String FIELD_SHAPECLSPSDEFNAME = "SHAPECLSPSDEFNAME";
    public static final String FIELD_SHAPEDYNACLASS = "SHAPEDYNACLASS";
    public static final String FIELD_SHAPEPSSYSCSSID = "SHAPEPSSYSCSSID";
    public static final String FIELD_SHAPEPSSYSCSSNAME = "SHAPEPSSYSCSSNAME";
    public static final String FIELD_TAG2PSDEFID = "TAG2PSDEFID";
    public static final String FIELD_TAG2PSDEFNAME = "TAG2PSDEFNAME";
    public static final String FIELD_TAGPSDEFID = "TAGPSDEFID";
    public static final String FIELD_TAGPSDEFNAME = "TAGPSDEFNAME";
    public static final String FIELD_TEXTPSDEFID = "TEXTPSDEFID";
    public static final String FIELD_TEXTPSDEFNAME = "TEXTPSDEFNAME";
    public static final String FIELD_TIMEPSDEFID = "TIMEPSDEFID";
    public static final String FIELD_TIMEPSDEFNAME = "TIMEPSDEFNAME";
    public static final String FIELD_TIPSPSDEFID = "TIPSPSDEFID";
    public static final String FIELD_TIPSPSDEFNAME = "TIPSPSDEFNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ALTPSDEFID = 0;
    private static final int INDEX_ALTPSDEFNAME = 1;
    private static final int INDEX_ASYNCPSDEDSID = 2;
    private static final int INDEX_ASYNCPSDEDSNAME = 3;
    private static final int INDEX_BKCOLOR = 4;
    private static final int INDEX_BKCOLORPSDEFID = 5;
    private static final int INDEX_BKCOLORPSDEFNAME = 6;
    private static final int INDEX_BORDERCOLOR = 7;
    private static final int INDEX_BORDERWIDTH = 8;
    private static final int INDEX_CLSPSDEFID = 9;
    private static final int INDEX_CLSPSDEFNAME = 10;
    private static final int INDEX_COLOR = 11;
    private static final int INDEX_COLORPSDEFID = 12;
    private static final int INDEX_COLORPSDEFNAME = 13;
    private static final int INDEX_CONTENTPSDEFID = 14;
    private static final int INDEX_CONTENTPSDEFNAME = 15;
    private static final int INDEX_CREATEDATE = 16;
    private static final int INDEX_CREATEMAN = 17;
    private static final int INDEX_CUSTOMCOND = 18;
    private static final int INDEX_CUSTOMTYPE = 19;
    private static final int INDEX_DATA2PSDEFID = 20;
    private static final int INDEX_DATA2PSDEFNAME = 21;
    private static final int INDEX_DATAPSDEFID = 22;
    private static final int INDEX_DATAPSDEFNAME = 23;
    private static final int INDEX_DYNACLASS = 24;
    private static final int INDEX_GROUPPSDEFID = 25;
    private static final int INDEX_GROUPPSDEFNAME = 26;
    private static final int INDEX_GROUPPSDEUAGROUPID = 27;
    private static final int INDEX_GROUPPSDEUAGROUPNAME = 28;
    private static final int INDEX_ICONPSDEFID = 29;
    private static final int INDEX_ICONPSDEFNAME = 30;
    private static final int INDEX_ITEMSTYLE = 31;
    private static final int INDEX_ITEMSTYLETEXT = 32;
    private static final int INDEX_ITEMTYPE = 33;
    private static final int INDEX_KEYPSDEFID = 34;
    private static final int INDEX_KEYPSDEFNAME = 35;
    private static final int INDEX_LATPSDEFID = 36;
    private static final int INDEX_LATPSDEFNAME = 37;
    private static final int INDEX_LINKPSDEFID = 38;
    private static final int INDEX_LINKPSDEFNAME = 39;
    private static final int INDEX_LONGPSDEFID = 40;
    private static final int INDEX_LONGPSDEFNAME = 41;
    private static final int INDEX_MAXSIZE = 42;
    private static final int INDEX_MEMO = 43;
    private static final int INDEX_MODELOBJ = 44;
    private static final int INDEX_MOVEPSDEACTIONID = 45;
    private static final int INDEX_MOVEPSDEACTIONNAME = 46;
    private static final int INDEX_MOVEPSDEOPPRIVID = 47;
    private static final int INDEX_MOVEPSDEOPPRIVNAME = 48;
    private static final int INDEX_NAMEPSLANRESID = 49;
    private static final int INDEX_NAMEPSLANRESNAME = 50;
    private static final int INDEX_NAVVIEWFILTER = 51;
    private static final int INDEX_NAVVIEWPARAM = 52;
    private static final int INDEX_ORDERVALUE = 53;
    private static final int INDEX_ORDERVALUEPSDEFID = 54;
    private static final int INDEX_ORDERVALUEPSDEFNAME = 55;
    private static final int INDEX_PSDEDSID = 56;
    private static final int INDEX_PSDEDSNAME = 57;
    private static final int INDEX_PSDEID = 58;
    private static final int INDEX_PSDELOGICID = 59;
    private static final int INDEX_PSDELOGICNAME = 60;
    private static final int INDEX_PSDENAME = 61;
    private static final int INDEX_PSDERID = 62;
    private static final int INDEX_PSDERNAME = 63;
    private static final int INDEX_PSDETOOLBARID = 64;
    private static final int INDEX_PSDETOOLBARNAME = 65;
    private static final int INDEX_PSDEVIEWBASEID = 66;
    private static final int INDEX_PSDEVIEWBASENAME = 67;
    private static final int INDEX_PSSYSCSSID = 68;
    private static final int INDEX_PSSYSCSSNAME = 69;
    private static final int INDEX_PSSYSIMAGEID = 70;
    private static final int INDEX_PSSYSIMAGENAME = 71;
    private static final int INDEX_PSSYSMAPITEMID = 72;
    private static final int INDEX_PSSYSMAPITEMNAME = 73;
    private static final int INDEX_PSSYSMAPVIEWID = 74;
    private static final int INDEX_PSSYSMAPVIEWNAME = 75;
    private static final int INDEX_PSSYSPFPLUGINID = 76;
    private static final int INDEX_PSSYSPFPLUGINNAME = 77;
    private static final int INDEX_RADIUS = 78;
    private static final int INDEX_REMOVEPSDEACTIONID = 79;
    private static final int INDEX_REMOVEPSDEACTIONNAME = 80;
    private static final int INDEX_REMOVEPSDEOPPRIVID = 81;
    private static final int INDEX_REMOVEPSDEOPPRIVNAME = 82;
    private static final int INDEX_SHAPECLSPSDEFID = 83;
    private static final int INDEX_SHAPECLSPSDEFNAME = 84;
    private static final int INDEX_SHAPEDYNACLASS = 85;
    private static final int INDEX_SHAPEPSSYSCSSID = 86;
    private static final int INDEX_SHAPEPSSYSCSSNAME = 87;
    private static final int INDEX_TAG2PSDEFID = 88;
    private static final int INDEX_TAG2PSDEFNAME = 89;
    private static final int INDEX_TAGPSDEFID = 90;
    private static final int INDEX_TAGPSDEFNAME = 91;
    private static final int INDEX_TEXTPSDEFID = 92;
    private static final int INDEX_TEXTPSDEFNAME = 93;
    private static final int INDEX_TIMEPSDEFID = 94;
    private static final int INDEX_TIMEPSDEFNAME = 95;
    private static final int INDEX_TIPSPSDEFID = 96;
    private static final int INDEX_TIPSPSDEFNAME = 97;
    private static final int INDEX_UPDATEDATE = 98;
    private static final int INDEX_UPDATEMAN = 99;
    private static final int INDEX_USERCAT = 100;
    private static final int INDEX_USERTAG = 101;
    private static final int INDEX_USERTAG2 = 102;
    private static final int INDEX_USERTAG3 = 103;
    private static final int INDEX_USERTAG4 = 104;
    private static final int INDEX_VALIDFLAG = 105;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysMapItemBase proxyPSSysMapItemBase = null;
    private boolean altpsdefidDirtyFlag = false;
    private boolean altpsdefnameDirtyFlag = false;
    private boolean asyncpsdedsidDirtyFlag = false;
    private boolean asyncpsdedsnameDirtyFlag = false;
    private boolean bkcolorDirtyFlag = false;
    private boolean bkcolorpsdefidDirtyFlag = false;
    private boolean bkcolorpsdefnameDirtyFlag = false;
    private boolean bordercolorDirtyFlag = false;
    private boolean borderwidthDirtyFlag = false;
    private boolean clspsdefidDirtyFlag = false;
    private boolean clspsdefnameDirtyFlag = false;
    private boolean colorDirtyFlag = false;
    private boolean colorpsdefidDirtyFlag = false;
    private boolean colorpsdefnameDirtyFlag = false;
    private boolean contentpsdefidDirtyFlag = false;
    private boolean contentpsdefnameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcondDirtyFlag = false;
    private boolean customtypeDirtyFlag = false;
    private boolean data2psdefidDirtyFlag = false;
    private boolean data2psdefnameDirtyFlag = false;
    private boolean datapsdefidDirtyFlag = false;
    private boolean datapsdefnameDirtyFlag = false;
    private boolean dynaclassDirtyFlag = false;
    private boolean grouppsdefidDirtyFlag = false;
    private boolean grouppsdefnameDirtyFlag = false;
    private boolean grouppsdeuagroupidDirtyFlag = false;
    private boolean grouppsdeuagroupnameDirtyFlag = false;
    private boolean iconpsdefidDirtyFlag = false;
    private boolean iconpsdefnameDirtyFlag = false;
    private boolean itemstyleDirtyFlag = false;
    private boolean itemstyletextDirtyFlag = false;
    private boolean itemtypeDirtyFlag = false;
    private boolean keypsdefidDirtyFlag = false;
    private boolean keypsdefnameDirtyFlag = false;
    private boolean latpsdefidDirtyFlag = false;
    private boolean latpsdefnameDirtyFlag = false;
    private boolean linkpsdefidDirtyFlag = false;
    private boolean linkpsdefnameDirtyFlag = false;
    private boolean longpsdefidDirtyFlag = false;
    private boolean longpsdefnameDirtyFlag = false;
    private boolean maxsizeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modelobjDirtyFlag = false;
    private boolean movepsdeactionidDirtyFlag = false;
    private boolean movepsdeactionnameDirtyFlag = false;
    private boolean movepsdeopprividDirtyFlag = false;
    private boolean movepsdeopprivnameDirtyFlag = false;
    private boolean namepslanresidDirtyFlag = false;
    private boolean namepslanresnameDirtyFlag = false;
    private boolean navviewfilterDirtyFlag = false;
    private boolean navviewparamDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean ordervaluepsdefidDirtyFlag = false;
    private boolean ordervaluepsdefnameDirtyFlag = false;
    private boolean psdedsidDirtyFlag = false;
    private boolean psdedsnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdelogicidDirtyFlag = false;
    private boolean psdelogicnameDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psderidDirtyFlag = false;
    private boolean psdernameDirtyFlag = false;
    private boolean psdetoolbaridDirtyFlag = false;
    private boolean psdetoolbarnameDirtyFlag = false;
    private boolean psdeviewbaseidDirtyFlag = false;
    private boolean psdeviewbasenameDirtyFlag = false;
    private boolean pssyscssidDirtyFlag = false;
    private boolean pssyscssnameDirtyFlag = false;
    private boolean pssysimageidDirtyFlag = false;
    private boolean pssysimagenameDirtyFlag = false;
    private boolean pssysmapitemidDirtyFlag = false;
    private boolean pssysmapitemnameDirtyFlag = false;
    private boolean pssysmapviewidDirtyFlag = false;
    private boolean pssysmapviewnameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean radiusDirtyFlag = false;
    private boolean removepsdeactionidDirtyFlag = false;
    private boolean removepsdeactionnameDirtyFlag = false;
    private boolean removepsdeopprividDirtyFlag = false;
    private boolean removepsdeopprivnameDirtyFlag = false;
    private boolean shapeclspsdefidDirtyFlag = false;
    private boolean shapeclspsdefnameDirtyFlag = false;
    private boolean shapedynaclassDirtyFlag = false;
    private boolean shapepssyscssidDirtyFlag = false;
    private boolean shapepssyscssnameDirtyFlag = false;
    private boolean tag2psdefidDirtyFlag = false;
    private boolean tag2psdefnameDirtyFlag = false;
    private boolean tagpsdefidDirtyFlag = false;
    private boolean tagpsdefnameDirtyFlag = false;
    private boolean textpsdefidDirtyFlag = false;
    private boolean textpsdefnameDirtyFlag = false;
    private boolean timepsdefidDirtyFlag = false;
    private boolean timepsdefnameDirtyFlag = false;
    private boolean tipspsdefidDirtyFlag = false;
    private boolean tipspsdefnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="altpsdefid")
    private String altpsdefid;
    @Column(name="altpsdefname")
    private String altpsdefname;
    @Column(name="asyncpsdedsid")
    private String asyncpsdedsid;
    @Column(name="asyncpsdedsname")
    private String asyncpsdedsname;
    @Column(name="bkcolor")
    private String bkcolor;
    @Column(name="bkcolorpsdefid")
    private String bkcolorpsdefid;
    @Column(name="bkcolorpsdefname")
    private String bkcolorpsdefname;
    @Column(name="bordercolor")
    private String bordercolor;
    @Column(name="borderwidth")
    private Integer borderwidth;
    @Column(name="clspsdefid")
    private String clspsdefid;
    @Column(name="clspsdefname")
    private String clspsdefname;
    @Column(name="color")
    private String color;
    @Column(name="colorpsdefid")
    private String colorpsdefid;
    @Column(name="colorpsdefname")
    private String colorpsdefname;
    @Column(name="contentpsdefid")
    private String contentpsdefid;
    @Column(name="contentpsdefname")
    private String contentpsdefname;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcond")
    private String customcond;
    @Column(name="customtype")
    private String customtype;
    @Column(name="data2psdefid")
    private String data2psdefid;
    @Column(name="data2psdefname")
    private String data2psdefname;
    @Column(name="datapsdefid")
    private String datapsdefid;
    @Column(name="datapsdefname")
    private String datapsdefname;
    @Column(name="dynaclass")
    private String dynaclass;
    @Column(name="grouppsdefid")
    private String grouppsdefid;
    @Column(name="grouppsdefname")
    private String grouppsdefname;
    @Column(name="grouppsdeuagroupid")
    private String grouppsdeuagroupid;
    @Column(name="grouppsdeuagroupname")
    private String grouppsdeuagroupname;
    @Column(name="iconpsdefid")
    private String iconpsdefid;
    @Column(name="iconpsdefname")
    private String iconpsdefname;
    @Column(name="itemstyle")
    private String itemstyle;
    @Column(name="itemstyletext")
    private String itemstyletext;
    @Column(name="itemtype")
    private String itemtype;
    @Column(name="keypsdefid")
    private String keypsdefid;
    @Column(name="keypsdefname")
    private String keypsdefname;
    @Column(name="latpsdefid")
    private String latpsdefid;
    @Column(name="latpsdefname")
    private String latpsdefname;
    @Column(name="linkpsdefid")
    private String linkpsdefid;
    @Column(name="linkpsdefname")
    private String linkpsdefname;
    @Column(name="longpsdefid")
    private String longpsdefid;
    @Column(name="longpsdefname")
    private String longpsdefname;
    @Column(name="maxsize")
    private Integer maxsize;
    @Column(name="memo")
    private String memo;
    @Column(name="modelobj")
    private String modelobj;
    @Column(name="movepsdeactionid")
    private String movepsdeactionid;
    @Column(name="movepsdeactionname")
    private String movepsdeactionname;
    @Column(name="movepsdeopprivid")
    private String movepsdeopprivid;
    @Column(name="movepsdeopprivname")
    private String movepsdeopprivname;
    @Column(name="namepslanresid")
    private String namepslanresid;
    @Column(name="namepslanresname")
    private String namepslanresname;
    @Column(name="navviewfilter")
    private String navviewfilter;
    @Column(name="navviewparam")
    private String navviewparam;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="ordervaluepsdefid")
    private String ordervaluepsdefid;
    @Column(name="ordervaluepsdefname")
    private String ordervaluepsdefname;
    @Column(name="psdedsid")
    private String psdedsid;
    @Column(name="psdedsname")
    private String psdedsname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdelogicid")
    private String psdelogicid;
    @Column(name="psdelogicname")
    private String psdelogicname;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psderid")
    private String psderid;
    @Column(name="psdername")
    private String psdername;
    @Column(name="psdetoolbarid")
    private String psdetoolbarid;
    @Column(name="psdetoolbarname")
    private String psdetoolbarname;
    @Column(name="psdeviewbaseid")
    private String psdeviewbaseid;
    @Column(name="psdeviewbasename")
    private String psdeviewbasename;
    @Column(name="pssyscssid")
    private String pssyscssid;
    @Column(name="pssyscssname")
    private String pssyscssname;
    @Column(name="pssysimageid")
    private String pssysimageid;
    @Column(name="pssysimagename")
    private String pssysimagename;
    @Column(name="pssysmapitemid")
    private String pssysmapitemid;
    @Column(name="pssysmapitemname")
    private String pssysmapitemname;
    @Column(name="pssysmapviewid")
    private String pssysmapviewid;
    @Column(name="pssysmapviewname")
    private String pssysmapviewname;
    @Column(name="pssyspfpluginid")
    private String pssyspfpluginid;
    @Column(name="pssyspfpluginname")
    private String pssyspfpluginname;
    @Column(name="radius")
    private Integer radius;
    @Column(name="removepsdeactionid")
    private String removepsdeactionid;
    @Column(name="removepsdeactionname")
    private String removepsdeactionname;
    @Column(name="removepsdeopprivid")
    private String removepsdeopprivid;
    @Column(name="removepsdeopprivname")
    private String removepsdeopprivname;
    @Column(name="shapeclspsdefid")
    private String shapeclspsdefid;
    @Column(name="shapeclspsdefname")
    private String shapeclspsdefname;
    @Column(name="shapedynaclass")
    private String shapedynaclass;
    @Column(name="shapepssyscssid")
    private String shapepssyscssid;
    @Column(name="shapepssyscssname")
    private String shapepssyscssname;
    @Column(name="tag2psdefid")
    private String tag2psdefid;
    @Column(name="tag2psdefname")
    private String tag2psdefname;
    @Column(name="tagpsdefid")
    private String tagpsdefid;
    @Column(name="tagpsdefname")
    private String tagpsdefname;
    @Column(name="textpsdefid")
    private String textpsdefid;
    @Column(name="textpsdefname")
    private String textpsdefname;
    @Column(name="timepsdefid")
    private String timepsdefid;
    @Column(name="timepsdefname")
    private String timepsdefname;
    @Column(name="tipspsdefid")
    private String tipspsdefid;
    @Column(name="tipspsdefname")
    private String tipspsdefname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objMovePSDEActionLock = new Integer(1);
    private PSDEAction movepsdeaction = null;
    private Integer objRemovePSDEActionLock = new Integer(1);
    private PSDEAction removepsdeaction = null;
    private Integer objAsyncPSDEDSLock = new Integer(1);
    private PSDEDataSet asyncpsdeds = null;
    private Integer objPSDEDSLock = new Integer(1);
    private PSDEDataSet psdeds = null;
    private Integer objAltPSDEFLock = new Integer(1);
    private PSDEField altpsdef = null;
    private Integer objBKColorPSDEFLock = new Integer(1);
    private PSDEField bkcolorpsdef = null;
    private Integer objClsPSDEFLock = new Integer(1);
    private PSDEField clspsdef = null;
    private Integer objColorPSDEFLock = new Integer(1);
    private PSDEField colorpsdef = null;
    private Integer objContentPSDEFLock = new Integer(1);
    private PSDEField contentpsdef = null;
    private Integer objData2PSDEFLock = new Integer(1);
    private PSDEField data2psdef = null;
    private Integer objDataPSDEFLock = new Integer(1);
    private PSDEField datapsdef = null;
    private Integer objGroupPSDEFLock = new Integer(1);
    private PSDEField grouppsdef = null;
    private Integer objIconPSDEFLock = new Integer(1);
    private PSDEField iconpsdef = null;
    private Integer objKeyPSDEFLock = new Integer(1);
    private PSDEField keypsdef = null;
    private Integer objLatPSDEFLock = new Integer(1);
    private PSDEField latpsdef = null;
    private Integer objLinkPSDEFLock = new Integer(1);
    private PSDEField linkpsdef = null;
    private Integer objLongPSDEFLock = new Integer(1);
    private PSDEField longpsdef = null;
    private Integer objOrderValuePSDEFLock = new Integer(1);
    private PSDEField ordervaluepsdef = null;
    private Integer objShapeClsPSDEFLock = new Integer(1);
    private PSDEField shapeclspsdef = null;
    private Integer objTag2PSDEFLock = new Integer(1);
    private PSDEField tag2psdef = null;
    private Integer objTagPSDEFLock = new Integer(1);
    private PSDEField tagpsdef = null;
    private Integer objTextPSDEFLock = new Integer(1);
    private PSDEField textpsdef = null;
    private Integer objTimePSDEFLock = new Integer(1);
    private PSDEField timepsdef = null;
    private Integer objTipsPSDEFLock = new Integer(1);
    private PSDEField tipspsdef = null;
    private Integer objPSDELogicLock = new Integer(1);
    private PSDELogic psdelogic = null;
    private Integer objMovePSDEOPPrivLock = new Integer(1);
    private PSDEOPPriv movepsdeoppriv = null;
    private Integer objRemovePSDEOPPrivLock = new Integer(1);
    private PSDEOPPriv removepsdeoppriv = null;
    private Integer objPSDERLock = new Integer(1);
    private PSDER psder = null;
    private Integer objPSDEToolbarLock = new Integer(1);
    private PSDEToolbar psdetoolbar = null;
    private Integer objGroupPSDEUAGroupLock = new Integer(1);
    private PSDEUAGroup grouppsdeuagroup = null;
    private Integer objPSDEViewBaseLock = new Integer(1);
    private PSDEViewBase psdeviewbase = null;
    private Integer objNamePSLanResLock = new Integer(1);
    private PSLanguageRes namepslanres = null;
    private Integer objPSSysCssLock = new Integer(1);
    private PSSysCss pssyscss = null;
    private Integer objShapePSSysCssLock = new Integer(1);
    private PSSysCss shapepssyscss = null;
    private Integer objPSSysImageLock = new Integer(1);
    private PSSysImage pssysimage = null;
    private Integer objPSSysMapViewLock = new Integer(1);
    private PSSysMapView pssysmapview = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;

    public void setAltPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAltPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.altpsdefid = string;
        this.altpsdefidDirtyFlag = true;
    }

    public String getAltPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAltPSDEFId();
        }
        return this.altpsdefid;
    }

    public boolean isAltPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAltPSDEFIdDirty();
        }
        return this.altpsdefidDirtyFlag;
    }

    public void resetAltPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAltPSDEFId();
            return;
        }
        this.altpsdefidDirtyFlag = false;
        this.altpsdefid = null;
    }

    public void setAltPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAltPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.altpsdefname = string;
        this.altpsdefnameDirtyFlag = true;
    }

    public String getAltPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAltPSDEFName();
        }
        return this.altpsdefname;
    }

    public boolean isAltPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAltPSDEFNameDirty();
        }
        return this.altpsdefnameDirtyFlag;
    }

    public void resetAltPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAltPSDEFName();
            return;
        }
        this.altpsdefnameDirtyFlag = false;
        this.altpsdefname = null;
    }

    public void setAsyncPSDEDSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAsyncPSDEDSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.asyncpsdedsid = string;
        this.asyncpsdedsidDirtyFlag = true;
    }

    public String getAsyncPSDEDSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAsyncPSDEDSId();
        }
        return this.asyncpsdedsid;
    }

    public boolean isAsyncPSDEDSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAsyncPSDEDSIdDirty();
        }
        return this.asyncpsdedsidDirtyFlag;
    }

    public void resetAsyncPSDEDSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAsyncPSDEDSId();
            return;
        }
        this.asyncpsdedsidDirtyFlag = false;
        this.asyncpsdedsid = null;
    }

    public void setAsyncPSDEDSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAsyncPSDEDSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.asyncpsdedsname = string;
        this.asyncpsdedsnameDirtyFlag = true;
    }

    public String getAsyncPSDEDSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAsyncPSDEDSName();
        }
        return this.asyncpsdedsname;
    }

    public boolean isAsyncPSDEDSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAsyncPSDEDSNameDirty();
        }
        return this.asyncpsdedsnameDirtyFlag;
    }

    public void resetAsyncPSDEDSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAsyncPSDEDSName();
            return;
        }
        this.asyncpsdedsnameDirtyFlag = false;
        this.asyncpsdedsname = null;
    }

    public void setBKColor(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBKColor(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bkcolor = string;
        this.bkcolorDirtyFlag = true;
    }

    public String getBKColor() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBKColor();
        }
        return this.bkcolor;
    }

    public boolean isBKColorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBKColorDirty();
        }
        return this.bkcolorDirtyFlag;
    }

    public void resetBKColor() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBKColor();
            return;
        }
        this.bkcolorDirtyFlag = false;
        this.bkcolor = null;
    }

    public void setBKColorPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBKColorPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bkcolorpsdefid = string;
        this.bkcolorpsdefidDirtyFlag = true;
    }

    public String getBKColorPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBKColorPSDEFId();
        }
        return this.bkcolorpsdefid;
    }

    public boolean isBKColorPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBKColorPSDEFIdDirty();
        }
        return this.bkcolorpsdefidDirtyFlag;
    }

    public void resetBKColorPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBKColorPSDEFId();
            return;
        }
        this.bkcolorpsdefidDirtyFlag = false;
        this.bkcolorpsdefid = null;
    }

    public void setBKColorPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBKColorPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bkcolorpsdefname = string;
        this.bkcolorpsdefnameDirtyFlag = true;
    }

    public String getBKColorPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBKColorPSDEFName();
        }
        return this.bkcolorpsdefname;
    }

    public boolean isBKColorPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBKColorPSDEFNameDirty();
        }
        return this.bkcolorpsdefnameDirtyFlag;
    }

    public void resetBKColorPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBKColorPSDEFName();
            return;
        }
        this.bkcolorpsdefnameDirtyFlag = false;
        this.bkcolorpsdefname = null;
    }

    public void setBorderColor(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBorderColor(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bordercolor = string;
        this.bordercolorDirtyFlag = true;
    }

    public String getBorderColor() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBorderColor();
        }
        return this.bordercolor;
    }

    public boolean isBorderColorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBorderColorDirty();
        }
        return this.bordercolorDirtyFlag;
    }

    public void resetBorderColor() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBorderColor();
            return;
        }
        this.bordercolorDirtyFlag = false;
        this.bordercolor = null;
    }

    public void setBorderWidth(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBorderWidth(n);
            return;
        }
        this.borderwidth = n;
        this.borderwidthDirtyFlag = true;
    }

    public Integer getBorderWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBorderWidth();
        }
        return this.borderwidth;
    }

    public boolean isBorderWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBorderWidthDirty();
        }
        return this.borderwidthDirtyFlag;
    }

    public void resetBorderWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBorderWidth();
            return;
        }
        this.borderwidthDirtyFlag = false;
        this.borderwidth = null;
    }

    public void setClsPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setClsPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.clspsdefid = string;
        this.clspsdefidDirtyFlag = true;
    }

    public String getClsPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getClsPSDEFId();
        }
        return this.clspsdefid;
    }

    public boolean isClsPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isClsPSDEFIdDirty();
        }
        return this.clspsdefidDirtyFlag;
    }

    public void resetClsPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetClsPSDEFId();
            return;
        }
        this.clspsdefidDirtyFlag = false;
        this.clspsdefid = null;
    }

    public void setClsPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setClsPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.clspsdefname = string;
        this.clspsdefnameDirtyFlag = true;
    }

    public String getClsPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getClsPSDEFName();
        }
        return this.clspsdefname;
    }

    public boolean isClsPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isClsPSDEFNameDirty();
        }
        return this.clspsdefnameDirtyFlag;
    }

    public void resetClsPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetClsPSDEFName();
            return;
        }
        this.clspsdefnameDirtyFlag = false;
        this.clspsdefname = null;
    }

    public void setColor(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setColor(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.color = string;
        this.colorDirtyFlag = true;
    }

    public String getColor() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getColor();
        }
        return this.color;
    }

    public boolean isColorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isColorDirty();
        }
        return this.colorDirtyFlag;
    }

    public void resetColor() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetColor();
            return;
        }
        this.colorDirtyFlag = false;
        this.color = null;
    }

    public void setColorPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setColorPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.colorpsdefid = string;
        this.colorpsdefidDirtyFlag = true;
    }

    public String getColorPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getColorPSDEFId();
        }
        return this.colorpsdefid;
    }

    public boolean isColorPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isColorPSDEFIdDirty();
        }
        return this.colorpsdefidDirtyFlag;
    }

    public void resetColorPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetColorPSDEFId();
            return;
        }
        this.colorpsdefidDirtyFlag = false;
        this.colorpsdefid = null;
    }

    public void setColorPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setColorPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.colorpsdefname = string;
        this.colorpsdefnameDirtyFlag = true;
    }

    public String getColorPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getColorPSDEFName();
        }
        return this.colorpsdefname;
    }

    public boolean isColorPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isColorPSDEFNameDirty();
        }
        return this.colorpsdefnameDirtyFlag;
    }

    public void resetColorPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetColorPSDEFName();
            return;
        }
        this.colorpsdefnameDirtyFlag = false;
        this.colorpsdefname = null;
    }

    public void setContentPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContentPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.contentpsdefid = string;
        this.contentpsdefidDirtyFlag = true;
    }

    public String getContentPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentPSDEFId();
        }
        return this.contentpsdefid;
    }

    public boolean isContentPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentPSDEFIdDirty();
        }
        return this.contentpsdefidDirtyFlag;
    }

    public void resetContentPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContentPSDEFId();
            return;
        }
        this.contentpsdefidDirtyFlag = false;
        this.contentpsdefid = null;
    }

    public void setContentPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContentPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.contentpsdefname = string;
        this.contentpsdefnameDirtyFlag = true;
    }

    public String getContentPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentPSDEFName();
        }
        return this.contentpsdefname;
    }

    public boolean isContentPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentPSDEFNameDirty();
        }
        return this.contentpsdefnameDirtyFlag;
    }

    public void resetContentPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContentPSDEFName();
            return;
        }
        this.contentpsdefnameDirtyFlag = false;
        this.contentpsdefname = null;
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

    public void setCustomCond(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomCond(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customcond = string;
        this.customcondDirtyFlag = true;
    }

    public String getCustomCond() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomCond();
        }
        return this.customcond;
    }

    public boolean isCustomCondDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomCondDirty();
        }
        return this.customcondDirtyFlag;
    }

    public void resetCustomCond() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomCond();
            return;
        }
        this.customcondDirtyFlag = false;
        this.customcond = null;
    }

    public void setCustomType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customtype = string;
        this.customtypeDirtyFlag = true;
    }

    public String getCustomType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomType();
        }
        return this.customtype;
    }

    public boolean isCustomTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomTypeDirty();
        }
        return this.customtypeDirtyFlag;
    }

    public void resetCustomType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomType();
            return;
        }
        this.customtypeDirtyFlag = false;
        this.customtype = null;
    }

    public void setData2PSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setData2PSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.data2psdefid = string;
        this.data2psdefidDirtyFlag = true;
    }

    public String getData2PSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getData2PSDEFId();
        }
        return this.data2psdefid;
    }

    public boolean isData2PSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isData2PSDEFIdDirty();
        }
        return this.data2psdefidDirtyFlag;
    }

    public void resetData2PSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetData2PSDEFId();
            return;
        }
        this.data2psdefidDirtyFlag = false;
        this.data2psdefid = null;
    }

    public void setData2PSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setData2PSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.data2psdefname = string;
        this.data2psdefnameDirtyFlag = true;
    }

    public String getData2PSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getData2PSDEFName();
        }
        return this.data2psdefname;
    }

    public boolean isData2PSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isData2PSDEFNameDirty();
        }
        return this.data2psdefnameDirtyFlag;
    }

    public void resetData2PSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetData2PSDEFName();
            return;
        }
        this.data2psdefnameDirtyFlag = false;
        this.data2psdefname = null;
    }

    public void setDataPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.datapsdefid = string;
        this.datapsdefidDirtyFlag = true;
    }

    public String getDataPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataPSDEFId();
        }
        return this.datapsdefid;
    }

    public boolean isDataPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataPSDEFIdDirty();
        }
        return this.datapsdefidDirtyFlag;
    }

    public void resetDataPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataPSDEFId();
            return;
        }
        this.datapsdefidDirtyFlag = false;
        this.datapsdefid = null;
    }

    public void setDataPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.datapsdefname = string;
        this.datapsdefnameDirtyFlag = true;
    }

    public String getDataPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataPSDEFName();
        }
        return this.datapsdefname;
    }

    public boolean isDataPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataPSDEFNameDirty();
        }
        return this.datapsdefnameDirtyFlag;
    }

    public void resetDataPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataPSDEFName();
            return;
        }
        this.datapsdefnameDirtyFlag = false;
        this.datapsdefname = null;
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

    public void setGroupPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouppsdefid = string;
        this.grouppsdefidDirtyFlag = true;
    }

    public String getGroupPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupPSDEFId();
        }
        return this.grouppsdefid;
    }

    public boolean isGroupPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupPSDEFIdDirty();
        }
        return this.grouppsdefidDirtyFlag;
    }

    public void resetGroupPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupPSDEFId();
            return;
        }
        this.grouppsdefidDirtyFlag = false;
        this.grouppsdefid = null;
    }

    public void setGroupPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouppsdefname = string;
        this.grouppsdefnameDirtyFlag = true;
    }

    public String getGroupPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupPSDEFName();
        }
        return this.grouppsdefname;
    }

    public boolean isGroupPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupPSDEFNameDirty();
        }
        return this.grouppsdefnameDirtyFlag;
    }

    public void resetGroupPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupPSDEFName();
            return;
        }
        this.grouppsdefnameDirtyFlag = false;
        this.grouppsdefname = null;
    }

    public void setGroupPSDEUAGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupPSDEUAGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouppsdeuagroupid = string;
        this.grouppsdeuagroupidDirtyFlag = true;
    }

    public String getGroupPSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupPSDEUAGroupId();
        }
        return this.grouppsdeuagroupid;
    }

    public boolean isGroupPSDEUAGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupPSDEUAGroupIdDirty();
        }
        return this.grouppsdeuagroupidDirtyFlag;
    }

    public void resetGroupPSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupPSDEUAGroupId();
            return;
        }
        this.grouppsdeuagroupidDirtyFlag = false;
        this.grouppsdeuagroupid = null;
    }

    public void setGroupPSDEUAGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupPSDEUAGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouppsdeuagroupname = string;
        this.grouppsdeuagroupnameDirtyFlag = true;
    }

    public String getGroupPSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupPSDEUAGroupName();
        }
        return this.grouppsdeuagroupname;
    }

    public boolean isGroupPSDEUAGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupPSDEUAGroupNameDirty();
        }
        return this.grouppsdeuagroupnameDirtyFlag;
    }

    public void resetGroupPSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupPSDEUAGroupName();
            return;
        }
        this.grouppsdeuagroupnameDirtyFlag = false;
        this.grouppsdeuagroupname = null;
    }

    public void setIconPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIconPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.iconpsdefid = string;
        this.iconpsdefidDirtyFlag = true;
    }

    public String getIconPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIconPSDEFId();
        }
        return this.iconpsdefid;
    }

    public boolean isIconPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIconPSDEFIdDirty();
        }
        return this.iconpsdefidDirtyFlag;
    }

    public void resetIconPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIconPSDEFId();
            return;
        }
        this.iconpsdefidDirtyFlag = false;
        this.iconpsdefid = null;
    }

    public void setIconPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIconPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.iconpsdefname = string;
        this.iconpsdefnameDirtyFlag = true;
    }

    public String getIconPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIconPSDEFName();
        }
        return this.iconpsdefname;
    }

    public boolean isIconPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIconPSDEFNameDirty();
        }
        return this.iconpsdefnameDirtyFlag;
    }

    public void resetIconPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIconPSDEFName();
            return;
        }
        this.iconpsdefnameDirtyFlag = false;
        this.iconpsdefname = null;
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

    public void setItemType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemtype = string;
        this.itemtypeDirtyFlag = true;
    }

    public String getItemType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemType();
        }
        return this.itemtype;
    }

    public boolean isItemTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemTypeDirty();
        }
        return this.itemtypeDirtyFlag;
    }

    public void resetItemType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemType();
            return;
        }
        this.itemtypeDirtyFlag = false;
        this.itemtype = null;
    }

    public void setKeyPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKeyPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.keypsdefid = string;
        this.keypsdefidDirtyFlag = true;
    }

    public String getKeyPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKeyPSDEFId();
        }
        return this.keypsdefid;
    }

    public boolean isKeyPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKeyPSDEFIdDirty();
        }
        return this.keypsdefidDirtyFlag;
    }

    public void resetKeyPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKeyPSDEFId();
            return;
        }
        this.keypsdefidDirtyFlag = false;
        this.keypsdefid = null;
    }

    public void setKeyPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKeyPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.keypsdefname = string;
        this.keypsdefnameDirtyFlag = true;
    }

    public String getKeyPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKeyPSDEFName();
        }
        return this.keypsdefname;
    }

    public boolean isKeyPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKeyPSDEFNameDirty();
        }
        return this.keypsdefnameDirtyFlag;
    }

    public void resetKeyPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKeyPSDEFName();
            return;
        }
        this.keypsdefnameDirtyFlag = false;
        this.keypsdefname = null;
    }

    public void setLatPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLatPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.latpsdefid = string;
        this.latpsdefidDirtyFlag = true;
    }

    public String getLatPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLatPSDEFId();
        }
        return this.latpsdefid;
    }

    public boolean isLatPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLatPSDEFIdDirty();
        }
        return this.latpsdefidDirtyFlag;
    }

    public void resetLatPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLatPSDEFId();
            return;
        }
        this.latpsdefidDirtyFlag = false;
        this.latpsdefid = null;
    }

    public void setLatPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLatPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.latpsdefname = string;
        this.latpsdefnameDirtyFlag = true;
    }

    public String getLatPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLatPSDEFName();
        }
        return this.latpsdefname;
    }

    public boolean isLatPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLatPSDEFNameDirty();
        }
        return this.latpsdefnameDirtyFlag;
    }

    public void resetLatPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLatPSDEFName();
            return;
        }
        this.latpsdefnameDirtyFlag = false;
        this.latpsdefname = null;
    }

    public void setLinkPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLinkPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.linkpsdefid = string;
        this.linkpsdefidDirtyFlag = true;
    }

    public String getLinkPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkPSDEFId();
        }
        return this.linkpsdefid;
    }

    public boolean isLinkPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLinkPSDEFIdDirty();
        }
        return this.linkpsdefidDirtyFlag;
    }

    public void resetLinkPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLinkPSDEFId();
            return;
        }
        this.linkpsdefidDirtyFlag = false;
        this.linkpsdefid = null;
    }

    public void setLinkPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLinkPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.linkpsdefname = string;
        this.linkpsdefnameDirtyFlag = true;
    }

    public String getLinkPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkPSDEFName();
        }
        return this.linkpsdefname;
    }

    public boolean isLinkPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLinkPSDEFNameDirty();
        }
        return this.linkpsdefnameDirtyFlag;
    }

    public void resetLinkPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLinkPSDEFName();
            return;
        }
        this.linkpsdefnameDirtyFlag = false;
        this.linkpsdefname = null;
    }

    public void setLongPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLongPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.longpsdefid = string;
        this.longpsdefidDirtyFlag = true;
    }

    public String getLongPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLongPSDEFId();
        }
        return this.longpsdefid;
    }

    public boolean isLongPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLongPSDEFIdDirty();
        }
        return this.longpsdefidDirtyFlag;
    }

    public void resetLongPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLongPSDEFId();
            return;
        }
        this.longpsdefidDirtyFlag = false;
        this.longpsdefid = null;
    }

    public void setLongPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLongPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.longpsdefname = string;
        this.longpsdefnameDirtyFlag = true;
    }

    public String getLongPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLongPSDEFName();
        }
        return this.longpsdefname;
    }

    public boolean isLongPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLongPSDEFNameDirty();
        }
        return this.longpsdefnameDirtyFlag;
    }

    public void resetLongPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLongPSDEFName();
            return;
        }
        this.longpsdefnameDirtyFlag = false;
        this.longpsdefname = null;
    }

    public void setMaxSize(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxSize(n);
            return;
        }
        this.maxsize = n;
        this.maxsizeDirtyFlag = true;
    }

    public Integer getMaxSize() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxSize();
        }
        return this.maxsize;
    }

    public boolean isMaxSizeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxSizeDirty();
        }
        return this.maxsizeDirtyFlag;
    }

    public void resetMaxSize() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxSize();
            return;
        }
        this.maxsizeDirtyFlag = false;
        this.maxsize = null;
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

    public void setModelObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modelobj = string;
        this.modelobjDirtyFlag = true;
    }

    public String getModelObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelObj();
        }
        return this.modelobj;
    }

    public boolean isModelObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelObjDirty();
        }
        return this.modelobjDirtyFlag;
    }

    public void resetModelObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelObj();
            return;
        }
        this.modelobjDirtyFlag = false;
        this.modelobj = null;
    }

    public void setMovePSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMovePSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.movepsdeactionid = string;
        this.movepsdeactionidDirtyFlag = true;
    }

    public String getMovePSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMovePSDEActionId();
        }
        return this.movepsdeactionid;
    }

    public boolean isMovePSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMovePSDEActionIdDirty();
        }
        return this.movepsdeactionidDirtyFlag;
    }

    public void resetMovePSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMovePSDEActionId();
            return;
        }
        this.movepsdeactionidDirtyFlag = false;
        this.movepsdeactionid = null;
    }

    public void setMovePSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMovePSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.movepsdeactionname = string;
        this.movepsdeactionnameDirtyFlag = true;
    }

    public String getMovePSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMovePSDEActionName();
        }
        return this.movepsdeactionname;
    }

    public boolean isMovePSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMovePSDEActionNameDirty();
        }
        return this.movepsdeactionnameDirtyFlag;
    }

    public void resetMovePSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMovePSDEActionName();
            return;
        }
        this.movepsdeactionnameDirtyFlag = false;
        this.movepsdeactionname = null;
    }

    public void setMovePSDEOPPrivId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMovePSDEOPPrivId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.movepsdeopprivid = string;
        this.movepsdeopprividDirtyFlag = true;
    }

    public String getMovePSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMovePSDEOPPrivId();
        }
        return this.movepsdeopprivid;
    }

    public boolean isMovePSDEOPPrivIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMovePSDEOPPrivIdDirty();
        }
        return this.movepsdeopprividDirtyFlag;
    }

    public void resetMovePSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMovePSDEOPPrivId();
            return;
        }
        this.movepsdeopprividDirtyFlag = false;
        this.movepsdeopprivid = null;
    }

    public void setMovePSDEOPPrivName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMovePSDEOPPrivName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.movepsdeopprivname = string;
        this.movepsdeopprivnameDirtyFlag = true;
    }

    public String getMovePSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMovePSDEOPPrivName();
        }
        return this.movepsdeopprivname;
    }

    public boolean isMovePSDEOPPrivNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMovePSDEOPPrivNameDirty();
        }
        return this.movepsdeopprivnameDirtyFlag;
    }

    public void resetMovePSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMovePSDEOPPrivName();
            return;
        }
        this.movepsdeopprivnameDirtyFlag = false;
        this.movepsdeopprivname = null;
    }

    public void setNamePSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNamePSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.namepslanresid = string;
        this.namepslanresidDirtyFlag = true;
    }

    public String getNamePSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNamePSLanResId();
        }
        return this.namepslanresid;
    }

    public boolean isNamePSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNamePSLanResIdDirty();
        }
        return this.namepslanresidDirtyFlag;
    }

    public void resetNamePSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNamePSLanResId();
            return;
        }
        this.namepslanresidDirtyFlag = false;
        this.namepslanresid = null;
    }

    public void setNamePSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNamePSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.namepslanresname = string;
        this.namepslanresnameDirtyFlag = true;
    }

    public String getNamePSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNamePSLanResName();
        }
        return this.namepslanresname;
    }

    public boolean isNamePSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNamePSLanResNameDirty();
        }
        return this.namepslanresnameDirtyFlag;
    }

    public void resetNamePSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNamePSLanResName();
            return;
        }
        this.namepslanresnameDirtyFlag = false;
        this.namepslanresname = null;
    }

    public void setNavViewFilter(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNavViewFilter(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.navviewfilter = string;
        this.navviewfilterDirtyFlag = true;
    }

    public String getNavViewFilter() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNavViewFilter();
        }
        return this.navviewfilter;
    }

    public boolean isNavViewFilterDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNavViewFilterDirty();
        }
        return this.navviewfilterDirtyFlag;
    }

    public void resetNavViewFilter() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNavViewFilter();
            return;
        }
        this.navviewfilterDirtyFlag = false;
        this.navviewfilter = null;
    }

    public void setNavViewParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNavViewParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.navviewparam = string;
        this.navviewparamDirtyFlag = true;
    }

    public String getNavViewParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNavViewParam();
        }
        return this.navviewparam;
    }

    public boolean isNavViewParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNavViewParamDirty();
        }
        return this.navviewparamDirtyFlag;
    }

    public void resetNavViewParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNavViewParam();
            return;
        }
        this.navviewparamDirtyFlag = false;
        this.navviewparam = null;
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

    public void setOrderValuePSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderValuePSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ordervaluepsdefid = string;
        this.ordervaluepsdefidDirtyFlag = true;
    }

    public String getOrderValuePSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValuePSDEFId();
        }
        return this.ordervaluepsdefid;
    }

    public boolean isOrderValuePSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderValuePSDEFIdDirty();
        }
        return this.ordervaluepsdefidDirtyFlag;
    }

    public void resetOrderValuePSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderValuePSDEFId();
            return;
        }
        this.ordervaluepsdefidDirtyFlag = false;
        this.ordervaluepsdefid = null;
    }

    public void setOrderValuePSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderValuePSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ordervaluepsdefname = string;
        this.ordervaluepsdefnameDirtyFlag = true;
    }

    public String getOrderValuePSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValuePSDEFName();
        }
        return this.ordervaluepsdefname;
    }

    public boolean isOrderValuePSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderValuePSDEFNameDirty();
        }
        return this.ordervaluepsdefnameDirtyFlag;
    }

    public void resetOrderValuePSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderValuePSDEFName();
            return;
        }
        this.ordervaluepsdefnameDirtyFlag = false;
        this.ordervaluepsdefname = null;
    }

    public void setPSDEDSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedsid = string;
        this.psdedsidDirtyFlag = true;
    }

    public String getPSDEDSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDSId();
        }
        return this.psdedsid;
    }

    public boolean isPSDEDSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDSIdDirty();
        }
        return this.psdedsidDirtyFlag;
    }

    public void resetPSDEDSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDSId();
            return;
        }
        this.psdedsidDirtyFlag = false;
        this.psdedsid = null;
    }

    public void setPSDEDSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedsname = string;
        this.psdedsnameDirtyFlag = true;
    }

    public String getPSDEDSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDSName();
        }
        return this.psdedsname;
    }

    public boolean isPSDEDSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDSNameDirty();
        }
        return this.psdedsnameDirtyFlag;
    }

    public void resetPSDEDSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDSName();
            return;
        }
        this.psdedsnameDirtyFlag = false;
        this.psdedsname = null;
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

    public void setPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdename = string;
        this.psdenameDirtyFlag = true;
    }

    public String getPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEName();
        }
        return this.psdename;
    }

    public boolean isPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDENameDirty();
        }
        return this.psdenameDirtyFlag;
    }

    public void resetPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEName();
            return;
        }
        this.psdenameDirtyFlag = false;
        this.psdename = null;
    }

    public void setPSDERId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDERId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psderid = string;
        this.psderidDirtyFlag = true;
    }

    public String getPSDERId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERId();
        }
        return this.psderid;
    }

    public boolean isPSDERIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDERIdDirty();
        }
        return this.psderidDirtyFlag;
    }

    public void resetPSDERId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDERId();
            return;
        }
        this.psderidDirtyFlag = false;
        this.psderid = null;
    }

    public void setPSDERName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDERName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdername = string;
        this.psdernameDirtyFlag = true;
    }

    public String getPSDERName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERName();
        }
        return this.psdername;
    }

    public boolean isPSDERNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDERNameDirty();
        }
        return this.psdernameDirtyFlag;
    }

    public void resetPSDERName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDERName();
            return;
        }
        this.psdernameDirtyFlag = false;
        this.psdername = null;
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

    public void setPSDEViewBaseId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewBaseId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewbaseid = string;
        this.psdeviewbaseidDirtyFlag = true;
    }

    public String getPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBaseId();
        }
        return this.psdeviewbaseid;
    }

    public boolean isPSDEViewBaseIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewBaseIdDirty();
        }
        return this.psdeviewbaseidDirtyFlag;
    }

    public void resetPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewBaseId();
            return;
        }
        this.psdeviewbaseidDirtyFlag = false;
        this.psdeviewbaseid = null;
    }

    public void setPSDEViewBaseName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewBaseName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewbasename = string;
        this.psdeviewbasenameDirtyFlag = true;
    }

    public String getPSDEViewBaseName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBaseName();
        }
        return this.psdeviewbasename;
    }

    public boolean isPSDEViewBaseNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewBaseNameDirty();
        }
        return this.psdeviewbasenameDirtyFlag;
    }

    public void resetPSDEViewBaseName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewBaseName();
            return;
        }
        this.psdeviewbasenameDirtyFlag = false;
        this.psdeviewbasename = null;
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

    public void setPSSysMapItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysMapItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmapitemid = string;
        this.pssysmapitemidDirtyFlag = true;
    }

    public String getPSSysMapItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMapItemId();
        }
        return this.pssysmapitemid;
    }

    public boolean isPSSysMapItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysMapItemIdDirty();
        }
        return this.pssysmapitemidDirtyFlag;
    }

    public void resetPSSysMapItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysMapItemId();
            return;
        }
        this.pssysmapitemidDirtyFlag = false;
        this.pssysmapitemid = null;
    }

    public void setPSSysMapItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysMapItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmapitemname = string;
        this.pssysmapitemnameDirtyFlag = true;
    }

    public String getPSSysMapItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMapItemName();
        }
        return this.pssysmapitemname;
    }

    public boolean isPSSysMapItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysMapItemNameDirty();
        }
        return this.pssysmapitemnameDirtyFlag;
    }

    public void resetPSSysMapItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysMapItemName();
            return;
        }
        this.pssysmapitemnameDirtyFlag = false;
        this.pssysmapitemname = null;
    }

    public void setPSSysMapViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysMapViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmapviewid = string;
        this.pssysmapviewidDirtyFlag = true;
    }

    public String getPSSysMapViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMapViewId();
        }
        return this.pssysmapviewid;
    }

    public boolean isPSSysMapViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysMapViewIdDirty();
        }
        return this.pssysmapviewidDirtyFlag;
    }

    public void resetPSSysMapViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysMapViewId();
            return;
        }
        this.pssysmapviewidDirtyFlag = false;
        this.pssysmapviewid = null;
    }

    public void setPSSysMapViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysMapViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmapviewname = string;
        this.pssysmapviewnameDirtyFlag = true;
    }

    public String getPSSysMapViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMapViewName();
        }
        return this.pssysmapviewname;
    }

    public boolean isPSSysMapViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysMapViewNameDirty();
        }
        return this.pssysmapviewnameDirtyFlag;
    }

    public void resetPSSysMapViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysMapViewName();
            return;
        }
        this.pssysmapviewnameDirtyFlag = false;
        this.pssysmapviewname = null;
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

    public void setRadius(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRadius(n);
            return;
        }
        this.radius = n;
        this.radiusDirtyFlag = true;
    }

    public Integer getRadius() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRadius();
        }
        return this.radius;
    }

    public boolean isRadiusDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRadiusDirty();
        }
        return this.radiusDirtyFlag;
    }

    public void resetRadius() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRadius();
            return;
        }
        this.radiusDirtyFlag = false;
        this.radius = null;
    }

    public void setRemovePSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRemovePSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.removepsdeactionid = string;
        this.removepsdeactionidDirtyFlag = true;
    }

    public String getRemovePSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemovePSDEActionId();
        }
        return this.removepsdeactionid;
    }

    public boolean isRemovePSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRemovePSDEActionIdDirty();
        }
        return this.removepsdeactionidDirtyFlag;
    }

    public void resetRemovePSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRemovePSDEActionId();
            return;
        }
        this.removepsdeactionidDirtyFlag = false;
        this.removepsdeactionid = null;
    }

    public void setRemovePSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRemovePSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.removepsdeactionname = string;
        this.removepsdeactionnameDirtyFlag = true;
    }

    public String getRemovePSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemovePSDEActionName();
        }
        return this.removepsdeactionname;
    }

    public boolean isRemovePSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRemovePSDEActionNameDirty();
        }
        return this.removepsdeactionnameDirtyFlag;
    }

    public void resetRemovePSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRemovePSDEActionName();
            return;
        }
        this.removepsdeactionnameDirtyFlag = false;
        this.removepsdeactionname = null;
    }

    public void setRemovePSDEOPPrivId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRemovePSDEOPPrivId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.removepsdeopprivid = string;
        this.removepsdeopprividDirtyFlag = true;
    }

    public String getRemovePSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemovePSDEOPPrivId();
        }
        return this.removepsdeopprivid;
    }

    public boolean isRemovePSDEOPPrivIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRemovePSDEOPPrivIdDirty();
        }
        return this.removepsdeopprividDirtyFlag;
    }

    public void resetRemovePSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRemovePSDEOPPrivId();
            return;
        }
        this.removepsdeopprividDirtyFlag = false;
        this.removepsdeopprivid = null;
    }

    public void setRemovePSDEOPPrivName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRemovePSDEOPPrivName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.removepsdeopprivname = string;
        this.removepsdeopprivnameDirtyFlag = true;
    }

    public String getRemovePSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemovePSDEOPPrivName();
        }
        return this.removepsdeopprivname;
    }

    public boolean isRemovePSDEOPPrivNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRemovePSDEOPPrivNameDirty();
        }
        return this.removepsdeopprivnameDirtyFlag;
    }

    public void resetRemovePSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRemovePSDEOPPrivName();
            return;
        }
        this.removepsdeopprivnameDirtyFlag = false;
        this.removepsdeopprivname = null;
    }

    public void setShapeClsPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setShapeClsPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.shapeclspsdefid = string;
        this.shapeclspsdefidDirtyFlag = true;
    }

    public String getShapeClsPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getShapeClsPSDEFId();
        }
        return this.shapeclspsdefid;
    }

    public boolean isShapeClsPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isShapeClsPSDEFIdDirty();
        }
        return this.shapeclspsdefidDirtyFlag;
    }

    public void resetShapeClsPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetShapeClsPSDEFId();
            return;
        }
        this.shapeclspsdefidDirtyFlag = false;
        this.shapeclspsdefid = null;
    }

    public void setShapeClsPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setShapeClsPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.shapeclspsdefname = string;
        this.shapeclspsdefnameDirtyFlag = true;
    }

    public String getShapeClsPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getShapeClsPSDEFName();
        }
        return this.shapeclspsdefname;
    }

    public boolean isShapeClsPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isShapeClsPSDEFNameDirty();
        }
        return this.shapeclspsdefnameDirtyFlag;
    }

    public void resetShapeClsPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetShapeClsPSDEFName();
            return;
        }
        this.shapeclspsdefnameDirtyFlag = false;
        this.shapeclspsdefname = null;
    }

    public void setShapeDynaClass(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setShapeDynaClass(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.shapedynaclass = string;
        this.shapedynaclassDirtyFlag = true;
    }

    public String getShapeDynaClass() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getShapeDynaClass();
        }
        return this.shapedynaclass;
    }

    public boolean isShapeDynaClassDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isShapeDynaClassDirty();
        }
        return this.shapedynaclassDirtyFlag;
    }

    public void resetShapeDynaClass() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetShapeDynaClass();
            return;
        }
        this.shapedynaclassDirtyFlag = false;
        this.shapedynaclass = null;
    }

    public void setShapePSSysCssId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setShapePSSysCssId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.shapepssyscssid = string;
        this.shapepssyscssidDirtyFlag = true;
    }

    public String getShapePSSysCssId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getShapePSSysCssId();
        }
        return this.shapepssyscssid;
    }

    public boolean isShapePSSysCssIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isShapePSSysCssIdDirty();
        }
        return this.shapepssyscssidDirtyFlag;
    }

    public void resetShapePSSysCssId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetShapePSSysCssId();
            return;
        }
        this.shapepssyscssidDirtyFlag = false;
        this.shapepssyscssid = null;
    }

    public void setShapePSSysCssName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setShapePSSysCssName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.shapepssyscssname = string;
        this.shapepssyscssnameDirtyFlag = true;
    }

    public String getShapePSSysCssName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getShapePSSysCssName();
        }
        return this.shapepssyscssname;
    }

    public boolean isShapePSSysCssNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isShapePSSysCssNameDirty();
        }
        return this.shapepssyscssnameDirtyFlag;
    }

    public void resetShapePSSysCssName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetShapePSSysCssName();
            return;
        }
        this.shapepssyscssnameDirtyFlag = false;
        this.shapepssyscssname = null;
    }

    public void setTag2PSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTag2PSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tag2psdefid = string;
        this.tag2psdefidDirtyFlag = true;
    }

    public String getTag2PSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTag2PSDEFId();
        }
        return this.tag2psdefid;
    }

    public boolean isTag2PSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTag2PSDEFIdDirty();
        }
        return this.tag2psdefidDirtyFlag;
    }

    public void resetTag2PSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTag2PSDEFId();
            return;
        }
        this.tag2psdefidDirtyFlag = false;
        this.tag2psdefid = null;
    }

    public void setTag2PSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTag2PSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tag2psdefname = string;
        this.tag2psdefnameDirtyFlag = true;
    }

    public String getTag2PSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTag2PSDEFName();
        }
        return this.tag2psdefname;
    }

    public boolean isTag2PSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTag2PSDEFNameDirty();
        }
        return this.tag2psdefnameDirtyFlag;
    }

    public void resetTag2PSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTag2PSDEFName();
            return;
        }
        this.tag2psdefnameDirtyFlag = false;
        this.tag2psdefname = null;
    }

    public void setTagPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTagPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tagpsdefid = string;
        this.tagpsdefidDirtyFlag = true;
    }

    public String getTagPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTagPSDEFId();
        }
        return this.tagpsdefid;
    }

    public boolean isTagPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTagPSDEFIdDirty();
        }
        return this.tagpsdefidDirtyFlag;
    }

    public void resetTagPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTagPSDEFId();
            return;
        }
        this.tagpsdefidDirtyFlag = false;
        this.tagpsdefid = null;
    }

    public void setTagPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTagPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tagpsdefname = string;
        this.tagpsdefnameDirtyFlag = true;
    }

    public String getTagPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTagPSDEFName();
        }
        return this.tagpsdefname;
    }

    public boolean isTagPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTagPSDEFNameDirty();
        }
        return this.tagpsdefnameDirtyFlag;
    }

    public void resetTagPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTagPSDEFName();
            return;
        }
        this.tagpsdefnameDirtyFlag = false;
        this.tagpsdefname = null;
    }

    public void setTextPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTextPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.textpsdefid = string;
        this.textpsdefidDirtyFlag = true;
    }

    public String getTextPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTextPSDEFId();
        }
        return this.textpsdefid;
    }

    public boolean isTextPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTextPSDEFIdDirty();
        }
        return this.textpsdefidDirtyFlag;
    }

    public void resetTextPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTextPSDEFId();
            return;
        }
        this.textpsdefidDirtyFlag = false;
        this.textpsdefid = null;
    }

    public void setTextPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTextPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.textpsdefname = string;
        this.textpsdefnameDirtyFlag = true;
    }

    public String getTextPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTextPSDEFName();
        }
        return this.textpsdefname;
    }

    public boolean isTextPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTextPSDEFNameDirty();
        }
        return this.textpsdefnameDirtyFlag;
    }

    public void resetTextPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTextPSDEFName();
            return;
        }
        this.textpsdefnameDirtyFlag = false;
        this.textpsdefname = null;
    }

    public void setTimePSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTimePSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.timepsdefid = string;
        this.timepsdefidDirtyFlag = true;
    }

    public String getTimePSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTimePSDEFId();
        }
        return this.timepsdefid;
    }

    public boolean isTimePSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTimePSDEFIdDirty();
        }
        return this.timepsdefidDirtyFlag;
    }

    public void resetTimePSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTimePSDEFId();
            return;
        }
        this.timepsdefidDirtyFlag = false;
        this.timepsdefid = null;
    }

    public void setTimePSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTimePSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.timepsdefname = string;
        this.timepsdefnameDirtyFlag = true;
    }

    public String getTimePSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTimePSDEFName();
        }
        return this.timepsdefname;
    }

    public boolean isTimePSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTimePSDEFNameDirty();
        }
        return this.timepsdefnameDirtyFlag;
    }

    public void resetTimePSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTimePSDEFName();
            return;
        }
        this.timepsdefnameDirtyFlag = false;
        this.timepsdefname = null;
    }

    public void setTipsPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTipsPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tipspsdefid = string;
        this.tipspsdefidDirtyFlag = true;
    }

    public String getTipsPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTipsPSDEFId();
        }
        return this.tipspsdefid;
    }

    public boolean isTipsPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTipsPSDEFIdDirty();
        }
        return this.tipspsdefidDirtyFlag;
    }

    public void resetTipsPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTipsPSDEFId();
            return;
        }
        this.tipspsdefidDirtyFlag = false;
        this.tipspsdefid = null;
    }

    public void setTipsPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTipsPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tipspsdefname = string;
        this.tipspsdefnameDirtyFlag = true;
    }

    public String getTipsPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTipsPSDEFName();
        }
        return this.tipspsdefname;
    }

    public boolean isTipsPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTipsPSDEFNameDirty();
        }
        return this.tipspsdefnameDirtyFlag;
    }

    public void resetTipsPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTipsPSDEFName();
            return;
        }
        this.tipspsdefnameDirtyFlag = false;
        this.tipspsdefname = null;
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

    public void setUserCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usercat = string;
        this.usercatDirtyFlag = true;
    }

    public String getUserCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserCat();
        }
        return this.usercat;
    }

    public boolean isUserCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserCatDirty();
        }
        return this.usercatDirtyFlag;
    }

    public void resetUserCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserCat();
            return;
        }
        this.usercatDirtyFlag = false;
        this.usercat = null;
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

    public void setUserTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag3 = string;
        this.usertag3DirtyFlag = true;
    }

    public String getUserTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag3();
        }
        return this.usertag3;
    }

    public boolean isUserTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag3Dirty();
        }
        return this.usertag3DirtyFlag;
    }

    public void resetUserTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag3();
            return;
        }
        this.usertag3DirtyFlag = false;
        this.usertag3 = null;
    }

    public void setUserTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag4 = string;
        this.usertag4DirtyFlag = true;
    }

    public String getUserTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag4();
        }
        return this.usertag4;
    }

    public boolean isUserTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag4Dirty();
        }
        return this.usertag4DirtyFlag;
    }

    public void resetUserTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag4();
            return;
        }
        this.usertag4DirtyFlag = false;
        this.usertag4 = null;
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

    protected void onReset() {
        PSSysMapItemBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysMapItemBase pSSysMapItemBase) {
        pSSysMapItemBase.resetAltPSDEFId();
        pSSysMapItemBase.resetAltPSDEFName();
        pSSysMapItemBase.resetAsyncPSDEDSId();
        pSSysMapItemBase.resetAsyncPSDEDSName();
        pSSysMapItemBase.resetBKColor();
        pSSysMapItemBase.resetBKColorPSDEFId();
        pSSysMapItemBase.resetBKColorPSDEFName();
        pSSysMapItemBase.resetBorderColor();
        pSSysMapItemBase.resetBorderWidth();
        pSSysMapItemBase.resetClsPSDEFId();
        pSSysMapItemBase.resetClsPSDEFName();
        pSSysMapItemBase.resetColor();
        pSSysMapItemBase.resetColorPSDEFId();
        pSSysMapItemBase.resetColorPSDEFName();
        pSSysMapItemBase.resetContentPSDEFId();
        pSSysMapItemBase.resetContentPSDEFName();
        pSSysMapItemBase.resetCreateDate();
        pSSysMapItemBase.resetCreateMan();
        pSSysMapItemBase.resetCustomCond();
        pSSysMapItemBase.resetCustomType();
        pSSysMapItemBase.resetData2PSDEFId();
        pSSysMapItemBase.resetData2PSDEFName();
        pSSysMapItemBase.resetDataPSDEFId();
        pSSysMapItemBase.resetDataPSDEFName();
        pSSysMapItemBase.resetDynaClass();
        pSSysMapItemBase.resetGroupPSDEFId();
        pSSysMapItemBase.resetGroupPSDEFName();
        pSSysMapItemBase.resetGroupPSDEUAGroupId();
        pSSysMapItemBase.resetGroupPSDEUAGroupName();
        pSSysMapItemBase.resetIconPSDEFId();
        pSSysMapItemBase.resetIconPSDEFName();
        pSSysMapItemBase.resetItemStyle();
        pSSysMapItemBase.resetItemStyleText();
        pSSysMapItemBase.resetItemType();
        pSSysMapItemBase.resetKeyPSDEFId();
        pSSysMapItemBase.resetKeyPSDEFName();
        pSSysMapItemBase.resetLatPSDEFId();
        pSSysMapItemBase.resetLatPSDEFName();
        pSSysMapItemBase.resetLinkPSDEFId();
        pSSysMapItemBase.resetLinkPSDEFName();
        pSSysMapItemBase.resetLongPSDEFId();
        pSSysMapItemBase.resetLongPSDEFName();
        pSSysMapItemBase.resetMaxSize();
        pSSysMapItemBase.resetMemo();
        pSSysMapItemBase.resetModelObj();
        pSSysMapItemBase.resetMovePSDEActionId();
        pSSysMapItemBase.resetMovePSDEActionName();
        pSSysMapItemBase.resetMovePSDEOPPrivId();
        pSSysMapItemBase.resetMovePSDEOPPrivName();
        pSSysMapItemBase.resetNamePSLanResId();
        pSSysMapItemBase.resetNamePSLanResName();
        pSSysMapItemBase.resetNavViewFilter();
        pSSysMapItemBase.resetNavViewParam();
        pSSysMapItemBase.resetOrderValue();
        pSSysMapItemBase.resetOrderValuePSDEFId();
        pSSysMapItemBase.resetOrderValuePSDEFName();
        pSSysMapItemBase.resetPSDEDSId();
        pSSysMapItemBase.resetPSDEDSName();
        pSSysMapItemBase.resetPSDEId();
        pSSysMapItemBase.resetPSDELogicId();
        pSSysMapItemBase.resetPSDELogicName();
        pSSysMapItemBase.resetPSDEName();
        pSSysMapItemBase.resetPSDERId();
        pSSysMapItemBase.resetPSDERName();
        pSSysMapItemBase.resetPSDEToolbarId();
        pSSysMapItemBase.resetPSDEToolbarName();
        pSSysMapItemBase.resetPSDEViewBaseId();
        pSSysMapItemBase.resetPSDEViewBaseName();
        pSSysMapItemBase.resetPSSysCssId();
        pSSysMapItemBase.resetPSSysCssName();
        pSSysMapItemBase.resetPSSysImageId();
        pSSysMapItemBase.resetPSSysImageName();
        pSSysMapItemBase.resetPSSysMapItemId();
        pSSysMapItemBase.resetPSSysMapItemName();
        pSSysMapItemBase.resetPSSysMapViewId();
        pSSysMapItemBase.resetPSSysMapViewName();
        pSSysMapItemBase.resetPSSysPFPluginId();
        pSSysMapItemBase.resetPSSysPFPluginName();
        pSSysMapItemBase.resetRadius();
        pSSysMapItemBase.resetRemovePSDEActionId();
        pSSysMapItemBase.resetRemovePSDEActionName();
        pSSysMapItemBase.resetRemovePSDEOPPrivId();
        pSSysMapItemBase.resetRemovePSDEOPPrivName();
        pSSysMapItemBase.resetShapeClsPSDEFId();
        pSSysMapItemBase.resetShapeClsPSDEFName();
        pSSysMapItemBase.resetShapeDynaClass();
        pSSysMapItemBase.resetShapePSSysCssId();
        pSSysMapItemBase.resetShapePSSysCssName();
        pSSysMapItemBase.resetTag2PSDEFId();
        pSSysMapItemBase.resetTag2PSDEFName();
        pSSysMapItemBase.resetTagPSDEFId();
        pSSysMapItemBase.resetTagPSDEFName();
        pSSysMapItemBase.resetTextPSDEFId();
        pSSysMapItemBase.resetTextPSDEFName();
        pSSysMapItemBase.resetTimePSDEFId();
        pSSysMapItemBase.resetTimePSDEFName();
        pSSysMapItemBase.resetTipsPSDEFId();
        pSSysMapItemBase.resetTipsPSDEFName();
        pSSysMapItemBase.resetUpdateDate();
        pSSysMapItemBase.resetUpdateMan();
        pSSysMapItemBase.resetUserCat();
        pSSysMapItemBase.resetUserTag();
        pSSysMapItemBase.resetUserTag2();
        pSSysMapItemBase.resetUserTag3();
        pSSysMapItemBase.resetUserTag4();
        pSSysMapItemBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAltPSDEFIdDirty()) {
            hashMap.put(FIELD_ALTPSDEFID, this.getAltPSDEFId());
        }
        if (!bl || this.isAltPSDEFNameDirty()) {
            hashMap.put(FIELD_ALTPSDEFNAME, this.getAltPSDEFName());
        }
        if (!bl || this.isAsyncPSDEDSIdDirty()) {
            hashMap.put(FIELD_ASYNCPSDEDSID, this.getAsyncPSDEDSId());
        }
        if (!bl || this.isAsyncPSDEDSNameDirty()) {
            hashMap.put(FIELD_ASYNCPSDEDSNAME, this.getAsyncPSDEDSName());
        }
        if (!bl || this.isBKColorDirty()) {
            hashMap.put(FIELD_BKCOLOR, this.getBKColor());
        }
        if (!bl || this.isBKColorPSDEFIdDirty()) {
            hashMap.put(FIELD_BKCOLORPSDEFID, this.getBKColorPSDEFId());
        }
        if (!bl || this.isBKColorPSDEFNameDirty()) {
            hashMap.put(FIELD_BKCOLORPSDEFNAME, this.getBKColorPSDEFName());
        }
        if (!bl || this.isBorderColorDirty()) {
            hashMap.put(FIELD_BORDERCOLOR, this.getBorderColor());
        }
        if (!bl || this.isBorderWidthDirty()) {
            hashMap.put(FIELD_BORDERWIDTH, this.getBorderWidth());
        }
        if (!bl || this.isClsPSDEFIdDirty()) {
            hashMap.put(FIELD_CLSPSDEFID, this.getClsPSDEFId());
        }
        if (!bl || this.isClsPSDEFNameDirty()) {
            hashMap.put(FIELD_CLSPSDEFNAME, this.getClsPSDEFName());
        }
        if (!bl || this.isColorDirty()) {
            hashMap.put(FIELD_COLOR, this.getColor());
        }
        if (!bl || this.isColorPSDEFIdDirty()) {
            hashMap.put(FIELD_COLORPSDEFID, this.getColorPSDEFId());
        }
        if (!bl || this.isColorPSDEFNameDirty()) {
            hashMap.put(FIELD_COLORPSDEFNAME, this.getColorPSDEFName());
        }
        if (!bl || this.isContentPSDEFIdDirty()) {
            hashMap.put(FIELD_CONTENTPSDEFID, this.getContentPSDEFId());
        }
        if (!bl || this.isContentPSDEFNameDirty()) {
            hashMap.put(FIELD_CONTENTPSDEFNAME, this.getContentPSDEFName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCustomCondDirty()) {
            hashMap.put(FIELD_CUSTOMCOND, this.getCustomCond());
        }
        if (!bl || this.isCustomTypeDirty()) {
            hashMap.put(FIELD_CUSTOMTYPE, this.getCustomType());
        }
        if (!bl || this.isData2PSDEFIdDirty()) {
            hashMap.put(FIELD_DATA2PSDEFID, this.getData2PSDEFId());
        }
        if (!bl || this.isData2PSDEFNameDirty()) {
            hashMap.put(FIELD_DATA2PSDEFNAME, this.getData2PSDEFName());
        }
        if (!bl || this.isDataPSDEFIdDirty()) {
            hashMap.put(FIELD_DATAPSDEFID, this.getDataPSDEFId());
        }
        if (!bl || this.isDataPSDEFNameDirty()) {
            hashMap.put(FIELD_DATAPSDEFNAME, this.getDataPSDEFName());
        }
        if (!bl || this.isDynaClassDirty()) {
            hashMap.put(FIELD_DYNACLASS, this.getDynaClass());
        }
        if (!bl || this.isGroupPSDEFIdDirty()) {
            hashMap.put(FIELD_GROUPPSDEFID, this.getGroupPSDEFId());
        }
        if (!bl || this.isGroupPSDEFNameDirty()) {
            hashMap.put(FIELD_GROUPPSDEFNAME, this.getGroupPSDEFName());
        }
        if (!bl || this.isGroupPSDEUAGroupIdDirty()) {
            hashMap.put(FIELD_GROUPPSDEUAGROUPID, this.getGroupPSDEUAGroupId());
        }
        if (!bl || this.isGroupPSDEUAGroupNameDirty()) {
            hashMap.put(FIELD_GROUPPSDEUAGROUPNAME, this.getGroupPSDEUAGroupName());
        }
        if (!bl || this.isIconPSDEFIdDirty()) {
            hashMap.put(FIELD_ICONPSDEFID, this.getIconPSDEFId());
        }
        if (!bl || this.isIconPSDEFNameDirty()) {
            hashMap.put(FIELD_ICONPSDEFNAME, this.getIconPSDEFName());
        }
        if (!bl || this.isItemStyleDirty()) {
            hashMap.put(FIELD_ITEMSTYLE, this.getItemStyle());
        }
        if (!bl || this.isItemStyleTextDirty()) {
            hashMap.put(FIELD_ITEMSTYLETEXT, this.getItemStyleText());
        }
        if (!bl || this.isItemTypeDirty()) {
            hashMap.put(FIELD_ITEMTYPE, this.getItemType());
        }
        if (!bl || this.isKeyPSDEFIdDirty()) {
            hashMap.put(FIELD_KEYPSDEFID, this.getKeyPSDEFId());
        }
        if (!bl || this.isKeyPSDEFNameDirty()) {
            hashMap.put(FIELD_KEYPSDEFNAME, this.getKeyPSDEFName());
        }
        if (!bl || this.isLatPSDEFIdDirty()) {
            hashMap.put(FIELD_LATPSDEFID, this.getLatPSDEFId());
        }
        if (!bl || this.isLatPSDEFNameDirty()) {
            hashMap.put(FIELD_LATPSDEFNAME, this.getLatPSDEFName());
        }
        if (!bl || this.isLinkPSDEFIdDirty()) {
            hashMap.put(FIELD_LINKPSDEFID, this.getLinkPSDEFId());
        }
        if (!bl || this.isLinkPSDEFNameDirty()) {
            hashMap.put(FIELD_LINKPSDEFNAME, this.getLinkPSDEFName());
        }
        if (!bl || this.isLongPSDEFIdDirty()) {
            hashMap.put(FIELD_LONGPSDEFID, this.getLongPSDEFId());
        }
        if (!bl || this.isLongPSDEFNameDirty()) {
            hashMap.put(FIELD_LONGPSDEFNAME, this.getLongPSDEFName());
        }
        if (!bl || this.isMaxSizeDirty()) {
            hashMap.put(FIELD_MAXSIZE, this.getMaxSize());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isModelObjDirty()) {
            hashMap.put(FIELD_MODELOBJ, this.getModelObj());
        }
        if (!bl || this.isMovePSDEActionIdDirty()) {
            hashMap.put(FIELD_MOVEPSDEACTIONID, this.getMovePSDEActionId());
        }
        if (!bl || this.isMovePSDEActionNameDirty()) {
            hashMap.put(FIELD_MOVEPSDEACTIONNAME, this.getMovePSDEActionName());
        }
        if (!bl || this.isMovePSDEOPPrivIdDirty()) {
            hashMap.put(FIELD_MOVEPSDEOPPRIVID, this.getMovePSDEOPPrivId());
        }
        if (!bl || this.isMovePSDEOPPrivNameDirty()) {
            hashMap.put(FIELD_MOVEPSDEOPPRIVNAME, this.getMovePSDEOPPrivName());
        }
        if (!bl || this.isNamePSLanResIdDirty()) {
            hashMap.put(FIELD_NAMEPSLANRESID, this.getNamePSLanResId());
        }
        if (!bl || this.isNamePSLanResNameDirty()) {
            hashMap.put(FIELD_NAMEPSLANRESNAME, this.getNamePSLanResName());
        }
        if (!bl || this.isNavViewFilterDirty()) {
            hashMap.put(FIELD_NAVVIEWFILTER, this.getNavViewFilter());
        }
        if (!bl || this.isNavViewParamDirty()) {
            hashMap.put(FIELD_NAVVIEWPARAM, this.getNavViewParam());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isOrderValuePSDEFIdDirty()) {
            hashMap.put(FIELD_ORDERVALUEPSDEFID, this.getOrderValuePSDEFId());
        }
        if (!bl || this.isOrderValuePSDEFNameDirty()) {
            hashMap.put(FIELD_ORDERVALUEPSDEFNAME, this.getOrderValuePSDEFName());
        }
        if (!bl || this.isPSDEDSIdDirty()) {
            hashMap.put(FIELD_PSDEDSID, this.getPSDEDSId());
        }
        if (!bl || this.isPSDEDSNameDirty()) {
            hashMap.put(FIELD_PSDEDSNAME, this.getPSDEDSName());
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
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDERIdDirty()) {
            hashMap.put(FIELD_PSDERID, this.getPSDERId());
        }
        if (!bl || this.isPSDERNameDirty()) {
            hashMap.put(FIELD_PSDERNAME, this.getPSDERName());
        }
        if (!bl || this.isPSDEToolbarIdDirty()) {
            hashMap.put(FIELD_PSDETOOLBARID, this.getPSDEToolbarId());
        }
        if (!bl || this.isPSDEToolbarNameDirty()) {
            hashMap.put(FIELD_PSDETOOLBARNAME, this.getPSDEToolbarName());
        }
        if (!bl || this.isPSDEViewBaseIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASEID, this.getPSDEViewBaseId());
        }
        if (!bl || this.isPSDEViewBaseNameDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASENAME, this.getPSDEViewBaseName());
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
        if (!bl || this.isPSSysMapItemIdDirty()) {
            hashMap.put(FIELD_PSSYSMAPITEMID, this.getPSSysMapItemId());
        }
        if (!bl || this.isPSSysMapItemNameDirty()) {
            hashMap.put(FIELD_PSSYSMAPITEMNAME, this.getPSSysMapItemName());
        }
        if (!bl || this.isPSSysMapViewIdDirty()) {
            hashMap.put(FIELD_PSSYSMAPVIEWID, this.getPSSysMapViewId());
        }
        if (!bl || this.isPSSysMapViewNameDirty()) {
            hashMap.put(FIELD_PSSYSMAPVIEWNAME, this.getPSSysMapViewName());
        }
        if (!bl || this.isPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINID, this.getPSSysPFPluginId());
        }
        if (!bl || this.isPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINNAME, this.getPSSysPFPluginName());
        }
        if (!bl || this.isRadiusDirty()) {
            hashMap.put(FIELD_RADIUS, this.getRadius());
        }
        if (!bl || this.isRemovePSDEActionIdDirty()) {
            hashMap.put(FIELD_REMOVEPSDEACTIONID, this.getRemovePSDEActionId());
        }
        if (!bl || this.isRemovePSDEActionNameDirty()) {
            hashMap.put(FIELD_REMOVEPSDEACTIONNAME, this.getRemovePSDEActionName());
        }
        if (!bl || this.isRemovePSDEOPPrivIdDirty()) {
            hashMap.put(FIELD_REMOVEPSDEOPPRIVID, this.getRemovePSDEOPPrivId());
        }
        if (!bl || this.isRemovePSDEOPPrivNameDirty()) {
            hashMap.put(FIELD_REMOVEPSDEOPPRIVNAME, this.getRemovePSDEOPPrivName());
        }
        if (!bl || this.isShapeClsPSDEFIdDirty()) {
            hashMap.put(FIELD_SHAPECLSPSDEFID, this.getShapeClsPSDEFId());
        }
        if (!bl || this.isShapeClsPSDEFNameDirty()) {
            hashMap.put(FIELD_SHAPECLSPSDEFNAME, this.getShapeClsPSDEFName());
        }
        if (!bl || this.isShapeDynaClassDirty()) {
            hashMap.put(FIELD_SHAPEDYNACLASS, this.getShapeDynaClass());
        }
        if (!bl || this.isShapePSSysCssIdDirty()) {
            hashMap.put(FIELD_SHAPEPSSYSCSSID, this.getShapePSSysCssId());
        }
        if (!bl || this.isShapePSSysCssNameDirty()) {
            hashMap.put(FIELD_SHAPEPSSYSCSSNAME, this.getShapePSSysCssName());
        }
        if (!bl || this.isTag2PSDEFIdDirty()) {
            hashMap.put(FIELD_TAG2PSDEFID, this.getTag2PSDEFId());
        }
        if (!bl || this.isTag2PSDEFNameDirty()) {
            hashMap.put(FIELD_TAG2PSDEFNAME, this.getTag2PSDEFName());
        }
        if (!bl || this.isTagPSDEFIdDirty()) {
            hashMap.put(FIELD_TAGPSDEFID, this.getTagPSDEFId());
        }
        if (!bl || this.isTagPSDEFNameDirty()) {
            hashMap.put(FIELD_TAGPSDEFNAME, this.getTagPSDEFName());
        }
        if (!bl || this.isTextPSDEFIdDirty()) {
            hashMap.put(FIELD_TEXTPSDEFID, this.getTextPSDEFId());
        }
        if (!bl || this.isTextPSDEFNameDirty()) {
            hashMap.put(FIELD_TEXTPSDEFNAME, this.getTextPSDEFName());
        }
        if (!bl || this.isTimePSDEFIdDirty()) {
            hashMap.put(FIELD_TIMEPSDEFID, this.getTimePSDEFId());
        }
        if (!bl || this.isTimePSDEFNameDirty()) {
            hashMap.put(FIELD_TIMEPSDEFNAME, this.getTimePSDEFName());
        }
        if (!bl || this.isTipsPSDEFIdDirty()) {
            hashMap.put(FIELD_TIPSPSDEFID, this.getTipsPSDEFId());
        }
        if (!bl || this.isTipsPSDEFNameDirty()) {
            hashMap.put(FIELD_TIPSPSDEFNAME, this.getTipsPSDEFName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserCatDirty()) {
            hashMap.put(FIELD_USERCAT, this.getUserCat());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
        }
        if (!bl || this.isUserTag3Dirty()) {
            hashMap.put(FIELD_USERTAG3, this.getUserTag3());
        }
        if (!bl || this.isUserTag4Dirty()) {
            hashMap.put(FIELD_USERTAG4, this.getUserTag4());
        }
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
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
        return PSSysMapItemBase.get(this, n);
    }

    private static Object get(PSSysMapItemBase pSSysMapItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysMapItemBase.getAltPSDEFId();
            }
            case 1: {
                return pSSysMapItemBase.getAltPSDEFName();
            }
            case 2: {
                return pSSysMapItemBase.getAsyncPSDEDSId();
            }
            case 3: {
                return pSSysMapItemBase.getAsyncPSDEDSName();
            }
            case 4: {
                return pSSysMapItemBase.getBKColor();
            }
            case 5: {
                return pSSysMapItemBase.getBKColorPSDEFId();
            }
            case 6: {
                return pSSysMapItemBase.getBKColorPSDEFName();
            }
            case 7: {
                return pSSysMapItemBase.getBorderColor();
            }
            case 8: {
                return pSSysMapItemBase.getBorderWidth();
            }
            case 9: {
                return pSSysMapItemBase.getClsPSDEFId();
            }
            case 10: {
                return pSSysMapItemBase.getClsPSDEFName();
            }
            case 11: {
                return pSSysMapItemBase.getColor();
            }
            case 12: {
                return pSSysMapItemBase.getColorPSDEFId();
            }
            case 13: {
                return pSSysMapItemBase.getColorPSDEFName();
            }
            case 14: {
                return pSSysMapItemBase.getContentPSDEFId();
            }
            case 15: {
                return pSSysMapItemBase.getContentPSDEFName();
            }
            case 16: {
                return pSSysMapItemBase.getCreateDate();
            }
            case 17: {
                return pSSysMapItemBase.getCreateMan();
            }
            case 18: {
                return pSSysMapItemBase.getCustomCond();
            }
            case 19: {
                return pSSysMapItemBase.getCustomType();
            }
            case 20: {
                return pSSysMapItemBase.getData2PSDEFId();
            }
            case 21: {
                return pSSysMapItemBase.getData2PSDEFName();
            }
            case 22: {
                return pSSysMapItemBase.getDataPSDEFId();
            }
            case 23: {
                return pSSysMapItemBase.getDataPSDEFName();
            }
            case 24: {
                return pSSysMapItemBase.getDynaClass();
            }
            case 25: {
                return pSSysMapItemBase.getGroupPSDEFId();
            }
            case 26: {
                return pSSysMapItemBase.getGroupPSDEFName();
            }
            case 27: {
                return pSSysMapItemBase.getGroupPSDEUAGroupId();
            }
            case 28: {
                return pSSysMapItemBase.getGroupPSDEUAGroupName();
            }
            case 29: {
                return pSSysMapItemBase.getIconPSDEFId();
            }
            case 30: {
                return pSSysMapItemBase.getIconPSDEFName();
            }
            case 31: {
                return pSSysMapItemBase.getItemStyle();
            }
            case 32: {
                return pSSysMapItemBase.getItemStyleText();
            }
            case 33: {
                return pSSysMapItemBase.getItemType();
            }
            case 34: {
                return pSSysMapItemBase.getKeyPSDEFId();
            }
            case 35: {
                return pSSysMapItemBase.getKeyPSDEFName();
            }
            case 36: {
                return pSSysMapItemBase.getLatPSDEFId();
            }
            case 37: {
                return pSSysMapItemBase.getLatPSDEFName();
            }
            case 38: {
                return pSSysMapItemBase.getLinkPSDEFId();
            }
            case 39: {
                return pSSysMapItemBase.getLinkPSDEFName();
            }
            case 40: {
                return pSSysMapItemBase.getLongPSDEFId();
            }
            case 41: {
                return pSSysMapItemBase.getLongPSDEFName();
            }
            case 42: {
                return pSSysMapItemBase.getMaxSize();
            }
            case 43: {
                return pSSysMapItemBase.getMemo();
            }
            case 44: {
                return pSSysMapItemBase.getModelObj();
            }
            case 45: {
                return pSSysMapItemBase.getMovePSDEActionId();
            }
            case 46: {
                return pSSysMapItemBase.getMovePSDEActionName();
            }
            case 47: {
                return pSSysMapItemBase.getMovePSDEOPPrivId();
            }
            case 48: {
                return pSSysMapItemBase.getMovePSDEOPPrivName();
            }
            case 49: {
                return pSSysMapItemBase.getNamePSLanResId();
            }
            case 50: {
                return pSSysMapItemBase.getNamePSLanResName();
            }
            case 51: {
                return pSSysMapItemBase.getNavViewFilter();
            }
            case 52: {
                return pSSysMapItemBase.getNavViewParam();
            }
            case 53: {
                return pSSysMapItemBase.getOrderValue();
            }
            case 54: {
                return pSSysMapItemBase.getOrderValuePSDEFId();
            }
            case 55: {
                return pSSysMapItemBase.getOrderValuePSDEFName();
            }
            case 56: {
                return pSSysMapItemBase.getPSDEDSId();
            }
            case 57: {
                return pSSysMapItemBase.getPSDEDSName();
            }
            case 58: {
                return pSSysMapItemBase.getPSDEId();
            }
            case 59: {
                return pSSysMapItemBase.getPSDELogicId();
            }
            case 60: {
                return pSSysMapItemBase.getPSDELogicName();
            }
            case 61: {
                return pSSysMapItemBase.getPSDEName();
            }
            case 62: {
                return pSSysMapItemBase.getPSDERId();
            }
            case 63: {
                return pSSysMapItemBase.getPSDERName();
            }
            case 64: {
                return pSSysMapItemBase.getPSDEToolbarId();
            }
            case 65: {
                return pSSysMapItemBase.getPSDEToolbarName();
            }
            case 66: {
                return pSSysMapItemBase.getPSDEViewBaseId();
            }
            case 67: {
                return pSSysMapItemBase.getPSDEViewBaseName();
            }
            case 68: {
                return pSSysMapItemBase.getPSSysCssId();
            }
            case 69: {
                return pSSysMapItemBase.getPSSysCssName();
            }
            case 70: {
                return pSSysMapItemBase.getPSSysImageId();
            }
            case 71: {
                return pSSysMapItemBase.getPSSysImageName();
            }
            case 72: {
                return pSSysMapItemBase.getPSSysMapItemId();
            }
            case 73: {
                return pSSysMapItemBase.getPSSysMapItemName();
            }
            case 74: {
                return pSSysMapItemBase.getPSSysMapViewId();
            }
            case 75: {
                return pSSysMapItemBase.getPSSysMapViewName();
            }
            case 76: {
                return pSSysMapItemBase.getPSSysPFPluginId();
            }
            case 77: {
                return pSSysMapItemBase.getPSSysPFPluginName();
            }
            case 78: {
                return pSSysMapItemBase.getRadius();
            }
            case 79: {
                return pSSysMapItemBase.getRemovePSDEActionId();
            }
            case 80: {
                return pSSysMapItemBase.getRemovePSDEActionName();
            }
            case 81: {
                return pSSysMapItemBase.getRemovePSDEOPPrivId();
            }
            case 82: {
                return pSSysMapItemBase.getRemovePSDEOPPrivName();
            }
            case 83: {
                return pSSysMapItemBase.getShapeClsPSDEFId();
            }
            case 84: {
                return pSSysMapItemBase.getShapeClsPSDEFName();
            }
            case 85: {
                return pSSysMapItemBase.getShapeDynaClass();
            }
            case 86: {
                return pSSysMapItemBase.getShapePSSysCssId();
            }
            case 87: {
                return pSSysMapItemBase.getShapePSSysCssName();
            }
            case 88: {
                return pSSysMapItemBase.getTag2PSDEFId();
            }
            case 89: {
                return pSSysMapItemBase.getTag2PSDEFName();
            }
            case 90: {
                return pSSysMapItemBase.getTagPSDEFId();
            }
            case 91: {
                return pSSysMapItemBase.getTagPSDEFName();
            }
            case 92: {
                return pSSysMapItemBase.getTextPSDEFId();
            }
            case 93: {
                return pSSysMapItemBase.getTextPSDEFName();
            }
            case 94: {
                return pSSysMapItemBase.getTimePSDEFId();
            }
            case 95: {
                return pSSysMapItemBase.getTimePSDEFName();
            }
            case 96: {
                return pSSysMapItemBase.getTipsPSDEFId();
            }
            case 97: {
                return pSSysMapItemBase.getTipsPSDEFName();
            }
            case 98: {
                return pSSysMapItemBase.getUpdateDate();
            }
            case 99: {
                return pSSysMapItemBase.getUpdateMan();
            }
            case 100: {
                return pSSysMapItemBase.getUserCat();
            }
            case 101: {
                return pSSysMapItemBase.getUserTag();
            }
            case 102: {
                return pSSysMapItemBase.getUserTag2();
            }
            case 103: {
                return pSSysMapItemBase.getUserTag3();
            }
            case 104: {
                return pSSysMapItemBase.getUserTag4();
            }
            case 105: {
                return pSSysMapItemBase.getValidFlag();
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
        PSSysMapItemBase.set(this, n, object);
    }

    private static void set(PSSysMapItemBase pSSysMapItemBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysMapItemBase.setAltPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysMapItemBase.setAltPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysMapItemBase.setAsyncPSDEDSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysMapItemBase.setAsyncPSDEDSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysMapItemBase.setBKColor(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysMapItemBase.setBKColorPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysMapItemBase.setBKColorPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysMapItemBase.setBorderColor(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysMapItemBase.setBorderWidth(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSSysMapItemBase.setClsPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysMapItemBase.setClsPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysMapItemBase.setColor(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysMapItemBase.setColorPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysMapItemBase.setColorPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysMapItemBase.setContentPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysMapItemBase.setContentPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysMapItemBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSSysMapItemBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysMapItemBase.setCustomCond(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysMapItemBase.setCustomType(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysMapItemBase.setData2PSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysMapItemBase.setData2PSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysMapItemBase.setDataPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysMapItemBase.setDataPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysMapItemBase.setDynaClass(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysMapItemBase.setGroupPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysMapItemBase.setGroupPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysMapItemBase.setGroupPSDEUAGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysMapItemBase.setGroupPSDEUAGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysMapItemBase.setIconPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysMapItemBase.setIconPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysMapItemBase.setItemStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysMapItemBase.setItemStyleText(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysMapItemBase.setItemType(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysMapItemBase.setKeyPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysMapItemBase.setKeyPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysMapItemBase.setLatPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysMapItemBase.setLatPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSysMapItemBase.setLinkPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysMapItemBase.setLinkPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSSysMapItemBase.setLongPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSSysMapItemBase.setLongPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSSysMapItemBase.setMaxSize(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 43: {
                pSSysMapItemBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSSysMapItemBase.setModelObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSSysMapItemBase.setMovePSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSSysMapItemBase.setMovePSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSSysMapItemBase.setMovePSDEOPPrivId(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSSysMapItemBase.setMovePSDEOPPrivName(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSSysMapItemBase.setNamePSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSSysMapItemBase.setNamePSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSSysMapItemBase.setNavViewFilter(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSSysMapItemBase.setNavViewParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSSysMapItemBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 54: {
                pSSysMapItemBase.setOrderValuePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSSysMapItemBase.setOrderValuePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSSysMapItemBase.setPSDEDSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSSysMapItemBase.setPSDEDSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSSysMapItemBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSSysMapItemBase.setPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSSysMapItemBase.setPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSSysMapItemBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSSysMapItemBase.setPSDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSSysMapItemBase.setPSDERName(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSSysMapItemBase.setPSDEToolbarId(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSSysMapItemBase.setPSDEToolbarName(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSSysMapItemBase.setPSDEViewBaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSSysMapItemBase.setPSDEViewBaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSSysMapItemBase.setPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSSysMapItemBase.setPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 70: {
                pSSysMapItemBase.setPSSysImageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 71: {
                pSSysMapItemBase.setPSSysImageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 72: {
                pSSysMapItemBase.setPSSysMapItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 73: {
                pSSysMapItemBase.setPSSysMapItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 74: {
                pSSysMapItemBase.setPSSysMapViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 75: {
                pSSysMapItemBase.setPSSysMapViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 76: {
                pSSysMapItemBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 77: {
                pSSysMapItemBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 78: {
                pSSysMapItemBase.setRadius(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 79: {
                pSSysMapItemBase.setRemovePSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 80: {
                pSSysMapItemBase.setRemovePSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 81: {
                pSSysMapItemBase.setRemovePSDEOPPrivId(DataObject.getStringValue((Object)object));
                return;
            }
            case 82: {
                pSSysMapItemBase.setRemovePSDEOPPrivName(DataObject.getStringValue((Object)object));
                return;
            }
            case 83: {
                pSSysMapItemBase.setShapeClsPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 84: {
                pSSysMapItemBase.setShapeClsPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 85: {
                pSSysMapItemBase.setShapeDynaClass(DataObject.getStringValue((Object)object));
                return;
            }
            case 86: {
                pSSysMapItemBase.setShapePSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 87: {
                pSSysMapItemBase.setShapePSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 88: {
                pSSysMapItemBase.setTag2PSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 89: {
                pSSysMapItemBase.setTag2PSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 90: {
                pSSysMapItemBase.setTagPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 91: {
                pSSysMapItemBase.setTagPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 92: {
                pSSysMapItemBase.setTextPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 93: {
                pSSysMapItemBase.setTextPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 94: {
                pSSysMapItemBase.setTimePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 95: {
                pSSysMapItemBase.setTimePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 96: {
                pSSysMapItemBase.setTipsPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 97: {
                pSSysMapItemBase.setTipsPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 98: {
                pSSysMapItemBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 99: {
                pSSysMapItemBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 100: {
                pSSysMapItemBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 101: {
                pSSysMapItemBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 102: {
                pSSysMapItemBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 103: {
                pSSysMapItemBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 104: {
                pSSysMapItemBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 105: {
                pSSysMapItemBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysMapItemBase.isNull(this, n);
    }

    private static boolean isNull(PSSysMapItemBase pSSysMapItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysMapItemBase.getAltPSDEFId() == null;
            }
            case 1: {
                return pSSysMapItemBase.getAltPSDEFName() == null;
            }
            case 2: {
                return pSSysMapItemBase.getAsyncPSDEDSId() == null;
            }
            case 3: {
                return pSSysMapItemBase.getAsyncPSDEDSName() == null;
            }
            case 4: {
                return pSSysMapItemBase.getBKColor() == null;
            }
            case 5: {
                return pSSysMapItemBase.getBKColorPSDEFId() == null;
            }
            case 6: {
                return pSSysMapItemBase.getBKColorPSDEFName() == null;
            }
            case 7: {
                return pSSysMapItemBase.getBorderColor() == null;
            }
            case 8: {
                return pSSysMapItemBase.getBorderWidth() == null;
            }
            case 9: {
                return pSSysMapItemBase.getClsPSDEFId() == null;
            }
            case 10: {
                return pSSysMapItemBase.getClsPSDEFName() == null;
            }
            case 11: {
                return pSSysMapItemBase.getColor() == null;
            }
            case 12: {
                return pSSysMapItemBase.getColorPSDEFId() == null;
            }
            case 13: {
                return pSSysMapItemBase.getColorPSDEFName() == null;
            }
            case 14: {
                return pSSysMapItemBase.getContentPSDEFId() == null;
            }
            case 15: {
                return pSSysMapItemBase.getContentPSDEFName() == null;
            }
            case 16: {
                return pSSysMapItemBase.getCreateDate() == null;
            }
            case 17: {
                return pSSysMapItemBase.getCreateMan() == null;
            }
            case 18: {
                return pSSysMapItemBase.getCustomCond() == null;
            }
            case 19: {
                return pSSysMapItemBase.getCustomType() == null;
            }
            case 20: {
                return pSSysMapItemBase.getData2PSDEFId() == null;
            }
            case 21: {
                return pSSysMapItemBase.getData2PSDEFName() == null;
            }
            case 22: {
                return pSSysMapItemBase.getDataPSDEFId() == null;
            }
            case 23: {
                return pSSysMapItemBase.getDataPSDEFName() == null;
            }
            case 24: {
                return pSSysMapItemBase.getDynaClass() == null;
            }
            case 25: {
                return pSSysMapItemBase.getGroupPSDEFId() == null;
            }
            case 26: {
                return pSSysMapItemBase.getGroupPSDEFName() == null;
            }
            case 27: {
                return pSSysMapItemBase.getGroupPSDEUAGroupId() == null;
            }
            case 28: {
                return pSSysMapItemBase.getGroupPSDEUAGroupName() == null;
            }
            case 29: {
                return pSSysMapItemBase.getIconPSDEFId() == null;
            }
            case 30: {
                return pSSysMapItemBase.getIconPSDEFName() == null;
            }
            case 31: {
                return pSSysMapItemBase.getItemStyle() == null;
            }
            case 32: {
                return pSSysMapItemBase.getItemStyleText() == null;
            }
            case 33: {
                return pSSysMapItemBase.getItemType() == null;
            }
            case 34: {
                return pSSysMapItemBase.getKeyPSDEFId() == null;
            }
            case 35: {
                return pSSysMapItemBase.getKeyPSDEFName() == null;
            }
            case 36: {
                return pSSysMapItemBase.getLatPSDEFId() == null;
            }
            case 37: {
                return pSSysMapItemBase.getLatPSDEFName() == null;
            }
            case 38: {
                return pSSysMapItemBase.getLinkPSDEFId() == null;
            }
            case 39: {
                return pSSysMapItemBase.getLinkPSDEFName() == null;
            }
            case 40: {
                return pSSysMapItemBase.getLongPSDEFId() == null;
            }
            case 41: {
                return pSSysMapItemBase.getLongPSDEFName() == null;
            }
            case 42: {
                return pSSysMapItemBase.getMaxSize() == null;
            }
            case 43: {
                return pSSysMapItemBase.getMemo() == null;
            }
            case 44: {
                return pSSysMapItemBase.getModelObj() == null;
            }
            case 45: {
                return pSSysMapItemBase.getMovePSDEActionId() == null;
            }
            case 46: {
                return pSSysMapItemBase.getMovePSDEActionName() == null;
            }
            case 47: {
                return pSSysMapItemBase.getMovePSDEOPPrivId() == null;
            }
            case 48: {
                return pSSysMapItemBase.getMovePSDEOPPrivName() == null;
            }
            case 49: {
                return pSSysMapItemBase.getNamePSLanResId() == null;
            }
            case 50: {
                return pSSysMapItemBase.getNamePSLanResName() == null;
            }
            case 51: {
                return pSSysMapItemBase.getNavViewFilter() == null;
            }
            case 52: {
                return pSSysMapItemBase.getNavViewParam() == null;
            }
            case 53: {
                return pSSysMapItemBase.getOrderValue() == null;
            }
            case 54: {
                return pSSysMapItemBase.getOrderValuePSDEFId() == null;
            }
            case 55: {
                return pSSysMapItemBase.getOrderValuePSDEFName() == null;
            }
            case 56: {
                return pSSysMapItemBase.getPSDEDSId() == null;
            }
            case 57: {
                return pSSysMapItemBase.getPSDEDSName() == null;
            }
            case 58: {
                return pSSysMapItemBase.getPSDEId() == null;
            }
            case 59: {
                return pSSysMapItemBase.getPSDELogicId() == null;
            }
            case 60: {
                return pSSysMapItemBase.getPSDELogicName() == null;
            }
            case 61: {
                return pSSysMapItemBase.getPSDEName() == null;
            }
            case 62: {
                return pSSysMapItemBase.getPSDERId() == null;
            }
            case 63: {
                return pSSysMapItemBase.getPSDERName() == null;
            }
            case 64: {
                return pSSysMapItemBase.getPSDEToolbarId() == null;
            }
            case 65: {
                return pSSysMapItemBase.getPSDEToolbarName() == null;
            }
            case 66: {
                return pSSysMapItemBase.getPSDEViewBaseId() == null;
            }
            case 67: {
                return pSSysMapItemBase.getPSDEViewBaseName() == null;
            }
            case 68: {
                return pSSysMapItemBase.getPSSysCssId() == null;
            }
            case 69: {
                return pSSysMapItemBase.getPSSysCssName() == null;
            }
            case 70: {
                return pSSysMapItemBase.getPSSysImageId() == null;
            }
            case 71: {
                return pSSysMapItemBase.getPSSysImageName() == null;
            }
            case 72: {
                return pSSysMapItemBase.getPSSysMapItemId() == null;
            }
            case 73: {
                return pSSysMapItemBase.getPSSysMapItemName() == null;
            }
            case 74: {
                return pSSysMapItemBase.getPSSysMapViewId() == null;
            }
            case 75: {
                return pSSysMapItemBase.getPSSysMapViewName() == null;
            }
            case 76: {
                return pSSysMapItemBase.getPSSysPFPluginId() == null;
            }
            case 77: {
                return pSSysMapItemBase.getPSSysPFPluginName() == null;
            }
            case 78: {
                return pSSysMapItemBase.getRadius() == null;
            }
            case 79: {
                return pSSysMapItemBase.getRemovePSDEActionId() == null;
            }
            case 80: {
                return pSSysMapItemBase.getRemovePSDEActionName() == null;
            }
            case 81: {
                return pSSysMapItemBase.getRemovePSDEOPPrivId() == null;
            }
            case 82: {
                return pSSysMapItemBase.getRemovePSDEOPPrivName() == null;
            }
            case 83: {
                return pSSysMapItemBase.getShapeClsPSDEFId() == null;
            }
            case 84: {
                return pSSysMapItemBase.getShapeClsPSDEFName() == null;
            }
            case 85: {
                return pSSysMapItemBase.getShapeDynaClass() == null;
            }
            case 86: {
                return pSSysMapItemBase.getShapePSSysCssId() == null;
            }
            case 87: {
                return pSSysMapItemBase.getShapePSSysCssName() == null;
            }
            case 88: {
                return pSSysMapItemBase.getTag2PSDEFId() == null;
            }
            case 89: {
                return pSSysMapItemBase.getTag2PSDEFName() == null;
            }
            case 90: {
                return pSSysMapItemBase.getTagPSDEFId() == null;
            }
            case 91: {
                return pSSysMapItemBase.getTagPSDEFName() == null;
            }
            case 92: {
                return pSSysMapItemBase.getTextPSDEFId() == null;
            }
            case 93: {
                return pSSysMapItemBase.getTextPSDEFName() == null;
            }
            case 94: {
                return pSSysMapItemBase.getTimePSDEFId() == null;
            }
            case 95: {
                return pSSysMapItemBase.getTimePSDEFName() == null;
            }
            case 96: {
                return pSSysMapItemBase.getTipsPSDEFId() == null;
            }
            case 97: {
                return pSSysMapItemBase.getTipsPSDEFName() == null;
            }
            case 98: {
                return pSSysMapItemBase.getUpdateDate() == null;
            }
            case 99: {
                return pSSysMapItemBase.getUpdateMan() == null;
            }
            case 100: {
                return pSSysMapItemBase.getUserCat() == null;
            }
            case 101: {
                return pSSysMapItemBase.getUserTag() == null;
            }
            case 102: {
                return pSSysMapItemBase.getUserTag2() == null;
            }
            case 103: {
                return pSSysMapItemBase.getUserTag3() == null;
            }
            case 104: {
                return pSSysMapItemBase.getUserTag4() == null;
            }
            case 105: {
                return pSSysMapItemBase.getValidFlag() == null;
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
        return PSSysMapItemBase.contains(this, n);
    }

    private static boolean contains(PSSysMapItemBase pSSysMapItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysMapItemBase.isAltPSDEFIdDirty();
            }
            case 1: {
                return pSSysMapItemBase.isAltPSDEFNameDirty();
            }
            case 2: {
                return pSSysMapItemBase.isAsyncPSDEDSIdDirty();
            }
            case 3: {
                return pSSysMapItemBase.isAsyncPSDEDSNameDirty();
            }
            case 4: {
                return pSSysMapItemBase.isBKColorDirty();
            }
            case 5: {
                return pSSysMapItemBase.isBKColorPSDEFIdDirty();
            }
            case 6: {
                return pSSysMapItemBase.isBKColorPSDEFNameDirty();
            }
            case 7: {
                return pSSysMapItemBase.isBorderColorDirty();
            }
            case 8: {
                return pSSysMapItemBase.isBorderWidthDirty();
            }
            case 9: {
                return pSSysMapItemBase.isClsPSDEFIdDirty();
            }
            case 10: {
                return pSSysMapItemBase.isClsPSDEFNameDirty();
            }
            case 11: {
                return pSSysMapItemBase.isColorDirty();
            }
            case 12: {
                return pSSysMapItemBase.isColorPSDEFIdDirty();
            }
            case 13: {
                return pSSysMapItemBase.isColorPSDEFNameDirty();
            }
            case 14: {
                return pSSysMapItemBase.isContentPSDEFIdDirty();
            }
            case 15: {
                return pSSysMapItemBase.isContentPSDEFNameDirty();
            }
            case 16: {
                return pSSysMapItemBase.isCreateDateDirty();
            }
            case 17: {
                return pSSysMapItemBase.isCreateManDirty();
            }
            case 18: {
                return pSSysMapItemBase.isCustomCondDirty();
            }
            case 19: {
                return pSSysMapItemBase.isCustomTypeDirty();
            }
            case 20: {
                return pSSysMapItemBase.isData2PSDEFIdDirty();
            }
            case 21: {
                return pSSysMapItemBase.isData2PSDEFNameDirty();
            }
            case 22: {
                return pSSysMapItemBase.isDataPSDEFIdDirty();
            }
            case 23: {
                return pSSysMapItemBase.isDataPSDEFNameDirty();
            }
            case 24: {
                return pSSysMapItemBase.isDynaClassDirty();
            }
            case 25: {
                return pSSysMapItemBase.isGroupPSDEFIdDirty();
            }
            case 26: {
                return pSSysMapItemBase.isGroupPSDEFNameDirty();
            }
            case 27: {
                return pSSysMapItemBase.isGroupPSDEUAGroupIdDirty();
            }
            case 28: {
                return pSSysMapItemBase.isGroupPSDEUAGroupNameDirty();
            }
            case 29: {
                return pSSysMapItemBase.isIconPSDEFIdDirty();
            }
            case 30: {
                return pSSysMapItemBase.isIconPSDEFNameDirty();
            }
            case 31: {
                return pSSysMapItemBase.isItemStyleDirty();
            }
            case 32: {
                return pSSysMapItemBase.isItemStyleTextDirty();
            }
            case 33: {
                return pSSysMapItemBase.isItemTypeDirty();
            }
            case 34: {
                return pSSysMapItemBase.isKeyPSDEFIdDirty();
            }
            case 35: {
                return pSSysMapItemBase.isKeyPSDEFNameDirty();
            }
            case 36: {
                return pSSysMapItemBase.isLatPSDEFIdDirty();
            }
            case 37: {
                return pSSysMapItemBase.isLatPSDEFNameDirty();
            }
            case 38: {
                return pSSysMapItemBase.isLinkPSDEFIdDirty();
            }
            case 39: {
                return pSSysMapItemBase.isLinkPSDEFNameDirty();
            }
            case 40: {
                return pSSysMapItemBase.isLongPSDEFIdDirty();
            }
            case 41: {
                return pSSysMapItemBase.isLongPSDEFNameDirty();
            }
            case 42: {
                return pSSysMapItemBase.isMaxSizeDirty();
            }
            case 43: {
                return pSSysMapItemBase.isMemoDirty();
            }
            case 44: {
                return pSSysMapItemBase.isModelObjDirty();
            }
            case 45: {
                return pSSysMapItemBase.isMovePSDEActionIdDirty();
            }
            case 46: {
                return pSSysMapItemBase.isMovePSDEActionNameDirty();
            }
            case 47: {
                return pSSysMapItemBase.isMovePSDEOPPrivIdDirty();
            }
            case 48: {
                return pSSysMapItemBase.isMovePSDEOPPrivNameDirty();
            }
            case 49: {
                return pSSysMapItemBase.isNamePSLanResIdDirty();
            }
            case 50: {
                return pSSysMapItemBase.isNamePSLanResNameDirty();
            }
            case 51: {
                return pSSysMapItemBase.isNavViewFilterDirty();
            }
            case 52: {
                return pSSysMapItemBase.isNavViewParamDirty();
            }
            case 53: {
                return pSSysMapItemBase.isOrderValueDirty();
            }
            case 54: {
                return pSSysMapItemBase.isOrderValuePSDEFIdDirty();
            }
            case 55: {
                return pSSysMapItemBase.isOrderValuePSDEFNameDirty();
            }
            case 56: {
                return pSSysMapItemBase.isPSDEDSIdDirty();
            }
            case 57: {
                return pSSysMapItemBase.isPSDEDSNameDirty();
            }
            case 58: {
                return pSSysMapItemBase.isPSDEIdDirty();
            }
            case 59: {
                return pSSysMapItemBase.isPSDELogicIdDirty();
            }
            case 60: {
                return pSSysMapItemBase.isPSDELogicNameDirty();
            }
            case 61: {
                return pSSysMapItemBase.isPSDENameDirty();
            }
            case 62: {
                return pSSysMapItemBase.isPSDERIdDirty();
            }
            case 63: {
                return pSSysMapItemBase.isPSDERNameDirty();
            }
            case 64: {
                return pSSysMapItemBase.isPSDEToolbarIdDirty();
            }
            case 65: {
                return pSSysMapItemBase.isPSDEToolbarNameDirty();
            }
            case 66: {
                return pSSysMapItemBase.isPSDEViewBaseIdDirty();
            }
            case 67: {
                return pSSysMapItemBase.isPSDEViewBaseNameDirty();
            }
            case 68: {
                return pSSysMapItemBase.isPSSysCssIdDirty();
            }
            case 69: {
                return pSSysMapItemBase.isPSSysCssNameDirty();
            }
            case 70: {
                return pSSysMapItemBase.isPSSysImageIdDirty();
            }
            case 71: {
                return pSSysMapItemBase.isPSSysImageNameDirty();
            }
            case 72: {
                return pSSysMapItemBase.isPSSysMapItemIdDirty();
            }
            case 73: {
                return pSSysMapItemBase.isPSSysMapItemNameDirty();
            }
            case 74: {
                return pSSysMapItemBase.isPSSysMapViewIdDirty();
            }
            case 75: {
                return pSSysMapItemBase.isPSSysMapViewNameDirty();
            }
            case 76: {
                return pSSysMapItemBase.isPSSysPFPluginIdDirty();
            }
            case 77: {
                return pSSysMapItemBase.isPSSysPFPluginNameDirty();
            }
            case 78: {
                return pSSysMapItemBase.isRadiusDirty();
            }
            case 79: {
                return pSSysMapItemBase.isRemovePSDEActionIdDirty();
            }
            case 80: {
                return pSSysMapItemBase.isRemovePSDEActionNameDirty();
            }
            case 81: {
                return pSSysMapItemBase.isRemovePSDEOPPrivIdDirty();
            }
            case 82: {
                return pSSysMapItemBase.isRemovePSDEOPPrivNameDirty();
            }
            case 83: {
                return pSSysMapItemBase.isShapeClsPSDEFIdDirty();
            }
            case 84: {
                return pSSysMapItemBase.isShapeClsPSDEFNameDirty();
            }
            case 85: {
                return pSSysMapItemBase.isShapeDynaClassDirty();
            }
            case 86: {
                return pSSysMapItemBase.isShapePSSysCssIdDirty();
            }
            case 87: {
                return pSSysMapItemBase.isShapePSSysCssNameDirty();
            }
            case 88: {
                return pSSysMapItemBase.isTag2PSDEFIdDirty();
            }
            case 89: {
                return pSSysMapItemBase.isTag2PSDEFNameDirty();
            }
            case 90: {
                return pSSysMapItemBase.isTagPSDEFIdDirty();
            }
            case 91: {
                return pSSysMapItemBase.isTagPSDEFNameDirty();
            }
            case 92: {
                return pSSysMapItemBase.isTextPSDEFIdDirty();
            }
            case 93: {
                return pSSysMapItemBase.isTextPSDEFNameDirty();
            }
            case 94: {
                return pSSysMapItemBase.isTimePSDEFIdDirty();
            }
            case 95: {
                return pSSysMapItemBase.isTimePSDEFNameDirty();
            }
            case 96: {
                return pSSysMapItemBase.isTipsPSDEFIdDirty();
            }
            case 97: {
                return pSSysMapItemBase.isTipsPSDEFNameDirty();
            }
            case 98: {
                return pSSysMapItemBase.isUpdateDateDirty();
            }
            case 99: {
                return pSSysMapItemBase.isUpdateManDirty();
            }
            case 100: {
                return pSSysMapItemBase.isUserCatDirty();
            }
            case 101: {
                return pSSysMapItemBase.isUserTagDirty();
            }
            case 102: {
                return pSSysMapItemBase.isUserTag2Dirty();
            }
            case 103: {
                return pSSysMapItemBase.isUserTag3Dirty();
            }
            case 104: {
                return pSSysMapItemBase.isUserTag4Dirty();
            }
            case 105: {
                return pSSysMapItemBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysMapItemBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysMapItemBase pSSysMapItemBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysMapItemBase.getAltPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"altpsdefid", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getAltPSDEFId()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getAltPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"altpsdefname", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getAltPSDEFName()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getAsyncPSDEDSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"asyncpsdedsid", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getAsyncPSDEDSId()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getAsyncPSDEDSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"asyncpsdedsname", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getAsyncPSDEDSName()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getBKColor() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bkcolor", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getBKColor()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getBKColorPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bkcolorpsdefid", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getBKColorPSDEFId()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getBKColorPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bkcolorpsdefname", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getBKColorPSDEFName()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getBorderColor() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bordercolor", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getBorderColor()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getBorderWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"borderwidth", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getBorderWidth()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getClsPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clspsdefid", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getClsPSDEFId()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getClsPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clspsdefname", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getClsPSDEFName()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getColor() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"color", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getColor()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getColorPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"colorpsdefid", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getColorPSDEFId()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getColorPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"colorpsdefname", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getColorPSDEFName()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getContentPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contentpsdefid", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getContentPSDEFId()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getContentPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contentpsdefname", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getContentPSDEFName()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getCustomCond() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcond", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getCustomCond()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getCustomType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customtype", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getCustomType()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getData2PSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"data2psdefid", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getData2PSDEFId()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getData2PSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"data2psdefname", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getData2PSDEFName()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getDataPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"datapsdefid", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getDataPSDEFId()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getDataPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"datapsdefname", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getDataPSDEFName()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getDynaClass() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynaclass", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getDynaClass()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getGroupPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppsdefid", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getGroupPSDEFId()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getGroupPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppsdefname", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getGroupPSDEFName()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getGroupPSDEUAGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppsdeuagroupid", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getGroupPSDEUAGroupId()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getGroupPSDEUAGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppsdeuagroupname", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getGroupPSDEUAGroupName()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getIconPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconpsdefid", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getIconPSDEFId()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getIconPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconpsdefname", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getIconPSDEFName()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getItemStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemstyle", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getItemStyle()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getItemStyleText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemstyletext", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getItemStyleText()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getItemType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemtype", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getItemType()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getKeyPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"keypsdefid", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getKeyPSDEFId()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getKeyPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"keypsdefname", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getKeyPSDEFName()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getLatPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"latpsdefid", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getLatPSDEFId()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getLatPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"latpsdefname", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getLatPSDEFName()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getLinkPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkpsdefid", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getLinkPSDEFId()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getLinkPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkpsdefname", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getLinkPSDEFName()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getLongPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"longpsdefid", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getLongPSDEFId()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getLongPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"longpsdefname", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getLongPSDEFName()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getMaxSize() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxsize", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getMaxSize()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getModelObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelobj", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getModelObj()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getMovePSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"movepsdeactionid", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getMovePSDEActionId()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getMovePSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"movepsdeactionname", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getMovePSDEActionName()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getMovePSDEOPPrivId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"movepsdeopprivid", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getMovePSDEOPPrivId()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getMovePSDEOPPrivName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"movepsdeopprivname", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getMovePSDEOPPrivName()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getNamePSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"namepslanresid", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getNamePSLanResId()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getNamePSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"namepslanresname", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getNamePSLanResName()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getNavViewFilter() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewfilter", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getNavViewFilter()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getNavViewParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewparam", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getNavViewParam()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getOrderValuePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervaluepsdefid", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getOrderValuePSDEFId()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getOrderValuePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervaluepsdefname", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getOrderValuePSDEFName()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getPSDEDSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsid", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getPSDEDSId()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getPSDEDSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsname", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getPSDEDSName()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicid", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getPSDELogicId()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicname", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getPSDELogicName()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getPSDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psderid", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getPSDERId()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getPSDERName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdername", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getPSDERName()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getPSDEToolbarId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetoolbarid", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getPSDEToolbarId()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getPSDEToolbarName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetoolbarname", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getPSDEToolbarName()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getPSDEViewBaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbaseid", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getPSDEViewBaseId()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getPSDEViewBaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbasename", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getPSDEViewBaseName()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssid", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getPSSysCssId()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssname", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getPSSysCssName()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getPSSysImageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimageid", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getPSSysImageId()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getPSSysImageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimagename", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getPSSysImageName()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getPSSysMapItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmapitemid", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getPSSysMapItemId()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getPSSysMapItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmapitemname", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getPSSysMapItemName()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getPSSysMapViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmapviewid", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getPSSysMapViewId()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getPSSysMapViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmapviewname", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getPSSysMapViewName()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getRadius() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"radius", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getRadius()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getRemovePSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"removepsdeactionid", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getRemovePSDEActionId()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getRemovePSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"removepsdeactionname", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getRemovePSDEActionName()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getRemovePSDEOPPrivId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"removepsdeopprivid", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getRemovePSDEOPPrivId()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getRemovePSDEOPPrivName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"removepsdeopprivname", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getRemovePSDEOPPrivName()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getShapeClsPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"shapeclspsdefid", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getShapeClsPSDEFId()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getShapeClsPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"shapeclspsdefname", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getShapeClsPSDEFName()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getShapeDynaClass() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"shapedynaclass", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getShapeDynaClass()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getShapePSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"shapepssyscssid", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getShapePSSysCssId()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getShapePSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"shapepssyscssname", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getShapePSSysCssName()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getTag2PSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tag2psdefid", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getTag2PSDEFId()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getTag2PSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tag2psdefname", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getTag2PSDEFName()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getTagPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tagpsdefid", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getTagPSDEFId()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getTagPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tagpsdefname", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getTagPSDEFName()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getTextPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"textpsdefid", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getTextPSDEFId()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getTextPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"textpsdefname", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getTextPSDEFName()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getTimePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timepsdefid", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getTimePSDEFId()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getTimePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timepsdefname", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getTimePSDEFName()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getTipsPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tipspsdefid", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getTipsPSDEFId()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getTipsPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tipspsdefname", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getTipsPSDEFName()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysMapItemBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysMapItemBase.getJSONValue((Object)pSSysMapItemBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysMapItemBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysMapItemBase pSSysMapItemBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysMapItemBase.getAltPSDEFId() != null) {
            object = pSSysMapItemBase.getAltPSDEFId();
            xmlNode.setAttribute(FIELD_ALTPSDEFID, (String)(object == null ? "" : object));
        }
        if (bl || pSSysMapItemBase.getAltPSDEFName() != null) {
            object = pSSysMapItemBase.getAltPSDEFName();
            xmlNode.setAttribute(FIELD_ALTPSDEFNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSSysMapItemBase.getAsyncPSDEDSId() != null) {
            object = pSSysMapItemBase.getAsyncPSDEDSId();
            xmlNode.setAttribute(FIELD_ASYNCPSDEDSID, (String)(object == null ? "" : object));
        }
        if (bl || pSSysMapItemBase.getAsyncPSDEDSName() != null) {
            object = pSSysMapItemBase.getAsyncPSDEDSName();
            xmlNode.setAttribute(FIELD_ASYNCPSDEDSNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSSysMapItemBase.getBKColor() != null) {
            object = pSSysMapItemBase.getBKColor();
            xmlNode.setAttribute(FIELD_BKCOLOR, (String)(object == null ? "" : object));
        }
        if (bl || pSSysMapItemBase.getBKColorPSDEFId() != null) {
            object = pSSysMapItemBase.getBKColorPSDEFId();
            xmlNode.setAttribute(FIELD_BKCOLORPSDEFID, (String)(object == null ? "" : object));
        }
        if (bl || pSSysMapItemBase.getBKColorPSDEFName() != null) {
            object = pSSysMapItemBase.getBKColorPSDEFName();
            xmlNode.setAttribute(FIELD_BKCOLORPSDEFNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSSysMapItemBase.getBorderColor() != null) {
            object = pSSysMapItemBase.getBorderColor();
            xmlNode.setAttribute(FIELD_BORDERCOLOR, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getBorderWidth() != null) {
            object = pSSysMapItemBase.getBorderWidth();
            xmlNode.setAttribute(FIELD_BORDERWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysMapItemBase.getClsPSDEFId() != null) {
            object = pSSysMapItemBase.getClsPSDEFId();
            xmlNode.setAttribute(FIELD_CLSPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getClsPSDEFName() != null) {
            object = pSSysMapItemBase.getClsPSDEFName();
            xmlNode.setAttribute(FIELD_CLSPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getColor() != null) {
            object = pSSysMapItemBase.getColor();
            xmlNode.setAttribute(FIELD_COLOR, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getColorPSDEFId() != null) {
            object = pSSysMapItemBase.getColorPSDEFId();
            xmlNode.setAttribute(FIELD_COLORPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getColorPSDEFName() != null) {
            object = pSSysMapItemBase.getColorPSDEFName();
            xmlNode.setAttribute(FIELD_COLORPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getContentPSDEFId() != null) {
            object = pSSysMapItemBase.getContentPSDEFId();
            xmlNode.setAttribute(FIELD_CONTENTPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getContentPSDEFName() != null) {
            object = pSSysMapItemBase.getContentPSDEFName();
            xmlNode.setAttribute(FIELD_CONTENTPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getCreateDate() != null) {
            object = pSSysMapItemBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysMapItemBase.getCreateMan() != null) {
            object = pSSysMapItemBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getCustomCond() != null) {
            object = pSSysMapItemBase.getCustomCond();
            xmlNode.setAttribute(FIELD_CUSTOMCOND, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getCustomType() != null) {
            object = pSSysMapItemBase.getCustomType();
            xmlNode.setAttribute(FIELD_CUSTOMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getData2PSDEFId() != null) {
            object = pSSysMapItemBase.getData2PSDEFId();
            xmlNode.setAttribute(FIELD_DATA2PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getData2PSDEFName() != null) {
            object = pSSysMapItemBase.getData2PSDEFName();
            xmlNode.setAttribute(FIELD_DATA2PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getDataPSDEFId() != null) {
            object = pSSysMapItemBase.getDataPSDEFId();
            xmlNode.setAttribute(FIELD_DATAPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getDataPSDEFName() != null) {
            object = pSSysMapItemBase.getDataPSDEFName();
            xmlNode.setAttribute(FIELD_DATAPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getDynaClass() != null) {
            object = pSSysMapItemBase.getDynaClass();
            xmlNode.setAttribute(FIELD_DYNACLASS, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getGroupPSDEFId() != null) {
            object = pSSysMapItemBase.getGroupPSDEFId();
            xmlNode.setAttribute(FIELD_GROUPPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getGroupPSDEFName() != null) {
            object = pSSysMapItemBase.getGroupPSDEFName();
            xmlNode.setAttribute(FIELD_GROUPPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getGroupPSDEUAGroupId() != null) {
            object = pSSysMapItemBase.getGroupPSDEUAGroupId();
            xmlNode.setAttribute(FIELD_GROUPPSDEUAGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getGroupPSDEUAGroupName() != null) {
            object = pSSysMapItemBase.getGroupPSDEUAGroupName();
            xmlNode.setAttribute(FIELD_GROUPPSDEUAGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getIconPSDEFId() != null) {
            object = pSSysMapItemBase.getIconPSDEFId();
            xmlNode.setAttribute(FIELD_ICONPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getIconPSDEFName() != null) {
            object = pSSysMapItemBase.getIconPSDEFName();
            xmlNode.setAttribute(FIELD_ICONPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getItemStyle() != null) {
            object = pSSysMapItemBase.getItemStyle();
            xmlNode.setAttribute(FIELD_ITEMSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getItemStyleText() != null) {
            object = pSSysMapItemBase.getItemStyleText();
            xmlNode.setAttribute(FIELD_ITEMSTYLETEXT, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getItemType() != null) {
            object = pSSysMapItemBase.getItemType();
            xmlNode.setAttribute(FIELD_ITEMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getKeyPSDEFId() != null) {
            object = pSSysMapItemBase.getKeyPSDEFId();
            xmlNode.setAttribute(FIELD_KEYPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getKeyPSDEFName() != null) {
            object = pSSysMapItemBase.getKeyPSDEFName();
            xmlNode.setAttribute(FIELD_KEYPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getLatPSDEFId() != null) {
            object = pSSysMapItemBase.getLatPSDEFId();
            xmlNode.setAttribute(FIELD_LATPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getLatPSDEFName() != null) {
            object = pSSysMapItemBase.getLatPSDEFName();
            xmlNode.setAttribute(FIELD_LATPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getLinkPSDEFId() != null) {
            object = pSSysMapItemBase.getLinkPSDEFId();
            xmlNode.setAttribute(FIELD_LINKPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getLinkPSDEFName() != null) {
            object = pSSysMapItemBase.getLinkPSDEFName();
            xmlNode.setAttribute(FIELD_LINKPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getLongPSDEFId() != null) {
            object = pSSysMapItemBase.getLongPSDEFId();
            xmlNode.setAttribute(FIELD_LONGPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getLongPSDEFName() != null) {
            object = pSSysMapItemBase.getLongPSDEFName();
            xmlNode.setAttribute(FIELD_LONGPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getMaxSize() != null) {
            object = pSSysMapItemBase.getMaxSize();
            xmlNode.setAttribute(FIELD_MAXSIZE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysMapItemBase.getMemo() != null) {
            object = pSSysMapItemBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getModelObj() != null) {
            object = pSSysMapItemBase.getModelObj();
            xmlNode.setAttribute(FIELD_MODELOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getMovePSDEActionId() != null) {
            object = pSSysMapItemBase.getMovePSDEActionId();
            xmlNode.setAttribute(FIELD_MOVEPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getMovePSDEActionName() != null) {
            object = pSSysMapItemBase.getMovePSDEActionName();
            xmlNode.setAttribute(FIELD_MOVEPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getMovePSDEOPPrivId() != null) {
            object = pSSysMapItemBase.getMovePSDEOPPrivId();
            xmlNode.setAttribute(FIELD_MOVEPSDEOPPRIVID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getMovePSDEOPPrivName() != null) {
            object = pSSysMapItemBase.getMovePSDEOPPrivName();
            xmlNode.setAttribute(FIELD_MOVEPSDEOPPRIVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getNamePSLanResId() != null) {
            object = pSSysMapItemBase.getNamePSLanResId();
            xmlNode.setAttribute(FIELD_NAMEPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getNamePSLanResName() != null) {
            object = pSSysMapItemBase.getNamePSLanResName();
            xmlNode.setAttribute(FIELD_NAMEPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getNavViewFilter() != null) {
            object = pSSysMapItemBase.getNavViewFilter();
            xmlNode.setAttribute(FIELD_NAVVIEWFILTER, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getNavViewParam() != null) {
            object = pSSysMapItemBase.getNavViewParam();
            xmlNode.setAttribute(FIELD_NAVVIEWPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getOrderValue() != null) {
            object = pSSysMapItemBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysMapItemBase.getOrderValuePSDEFId() != null) {
            object = pSSysMapItemBase.getOrderValuePSDEFId();
            xmlNode.setAttribute(FIELD_ORDERVALUEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getOrderValuePSDEFName() != null) {
            object = pSSysMapItemBase.getOrderValuePSDEFName();
            xmlNode.setAttribute(FIELD_ORDERVALUEPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getPSDEDSId() != null) {
            object = pSSysMapItemBase.getPSDEDSId();
            xmlNode.setAttribute(FIELD_PSDEDSID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getPSDEDSName() != null) {
            object = pSSysMapItemBase.getPSDEDSName();
            xmlNode.setAttribute(FIELD_PSDEDSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getPSDEId() != null) {
            object = pSSysMapItemBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getPSDELogicId() != null) {
            object = pSSysMapItemBase.getPSDELogicId();
            xmlNode.setAttribute(FIELD_PSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getPSDELogicName() != null) {
            object = pSSysMapItemBase.getPSDELogicName();
            xmlNode.setAttribute(FIELD_PSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getPSDEName() != null) {
            object = pSSysMapItemBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getPSDERId() != null) {
            object = pSSysMapItemBase.getPSDERId();
            xmlNode.setAttribute(FIELD_PSDERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getPSDERName() != null) {
            object = pSSysMapItemBase.getPSDERName();
            xmlNode.setAttribute(FIELD_PSDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getPSDEToolbarId() != null) {
            object = pSSysMapItemBase.getPSDEToolbarId();
            xmlNode.setAttribute(FIELD_PSDETOOLBARID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getPSDEToolbarName() != null) {
            object = pSSysMapItemBase.getPSDEToolbarName();
            xmlNode.setAttribute(FIELD_PSDETOOLBARNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getPSDEViewBaseId() != null) {
            object = pSSysMapItemBase.getPSDEViewBaseId();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getPSDEViewBaseName() != null) {
            object = pSSysMapItemBase.getPSDEViewBaseName();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getPSSysCssId() != null) {
            object = pSSysMapItemBase.getPSSysCssId();
            xmlNode.setAttribute(FIELD_PSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getPSSysCssName() != null) {
            object = pSSysMapItemBase.getPSSysCssName();
            xmlNode.setAttribute(FIELD_PSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getPSSysImageId() != null) {
            object = pSSysMapItemBase.getPSSysImageId();
            xmlNode.setAttribute(FIELD_PSSYSIMAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getPSSysImageName() != null) {
            object = pSSysMapItemBase.getPSSysImageName();
            xmlNode.setAttribute(FIELD_PSSYSIMAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getPSSysMapItemId() != null) {
            object = pSSysMapItemBase.getPSSysMapItemId();
            xmlNode.setAttribute(FIELD_PSSYSMAPITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getPSSysMapItemName() != null) {
            object = pSSysMapItemBase.getPSSysMapItemName();
            xmlNode.setAttribute(FIELD_PSSYSMAPITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getPSSysMapViewId() != null) {
            object = pSSysMapItemBase.getPSSysMapViewId();
            xmlNode.setAttribute(FIELD_PSSYSMAPVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getPSSysMapViewName() != null) {
            object = pSSysMapItemBase.getPSSysMapViewName();
            xmlNode.setAttribute(FIELD_PSSYSMAPVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getPSSysPFPluginId() != null) {
            object = pSSysMapItemBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getPSSysPFPluginName() != null) {
            object = pSSysMapItemBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getRadius() != null) {
            object = pSSysMapItemBase.getRadius();
            xmlNode.setAttribute(FIELD_RADIUS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysMapItemBase.getRemovePSDEActionId() != null) {
            object = pSSysMapItemBase.getRemovePSDEActionId();
            xmlNode.setAttribute(FIELD_REMOVEPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getRemovePSDEActionName() != null) {
            object = pSSysMapItemBase.getRemovePSDEActionName();
            xmlNode.setAttribute(FIELD_REMOVEPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getRemovePSDEOPPrivId() != null) {
            object = pSSysMapItemBase.getRemovePSDEOPPrivId();
            xmlNode.setAttribute(FIELD_REMOVEPSDEOPPRIVID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getRemovePSDEOPPrivName() != null) {
            object = pSSysMapItemBase.getRemovePSDEOPPrivName();
            xmlNode.setAttribute(FIELD_REMOVEPSDEOPPRIVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getShapeClsPSDEFId() != null) {
            object = pSSysMapItemBase.getShapeClsPSDEFId();
            xmlNode.setAttribute(FIELD_SHAPECLSPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getShapeClsPSDEFName() != null) {
            object = pSSysMapItemBase.getShapeClsPSDEFName();
            xmlNode.setAttribute(FIELD_SHAPECLSPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getShapeDynaClass() != null) {
            object = pSSysMapItemBase.getShapeDynaClass();
            xmlNode.setAttribute(FIELD_SHAPEDYNACLASS, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getShapePSSysCssId() != null) {
            object = pSSysMapItemBase.getShapePSSysCssId();
            xmlNode.setAttribute(FIELD_SHAPEPSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getShapePSSysCssName() != null) {
            object = pSSysMapItemBase.getShapePSSysCssName();
            xmlNode.setAttribute(FIELD_SHAPEPSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getTag2PSDEFId() != null) {
            object = pSSysMapItemBase.getTag2PSDEFId();
            xmlNode.setAttribute(FIELD_TAG2PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getTag2PSDEFName() != null) {
            object = pSSysMapItemBase.getTag2PSDEFName();
            xmlNode.setAttribute(FIELD_TAG2PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getTagPSDEFId() != null) {
            object = pSSysMapItemBase.getTagPSDEFId();
            xmlNode.setAttribute(FIELD_TAGPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getTagPSDEFName() != null) {
            object = pSSysMapItemBase.getTagPSDEFName();
            xmlNode.setAttribute(FIELD_TAGPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getTextPSDEFId() != null) {
            object = pSSysMapItemBase.getTextPSDEFId();
            xmlNode.setAttribute(FIELD_TEXTPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getTextPSDEFName() != null) {
            object = pSSysMapItemBase.getTextPSDEFName();
            xmlNode.setAttribute(FIELD_TEXTPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getTimePSDEFId() != null) {
            object = pSSysMapItemBase.getTimePSDEFId();
            xmlNode.setAttribute(FIELD_TIMEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getTimePSDEFName() != null) {
            object = pSSysMapItemBase.getTimePSDEFName();
            xmlNode.setAttribute(FIELD_TIMEPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getTipsPSDEFId() != null) {
            object = pSSysMapItemBase.getTipsPSDEFId();
            xmlNode.setAttribute(FIELD_TIPSPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getTipsPSDEFName() != null) {
            object = pSSysMapItemBase.getTipsPSDEFName();
            xmlNode.setAttribute(FIELD_TIPSPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getUpdateDate() != null) {
            object = pSSysMapItemBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysMapItemBase.getUpdateMan() != null) {
            object = pSSysMapItemBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getUserCat() != null) {
            object = pSSysMapItemBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getUserTag() != null) {
            object = pSSysMapItemBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getUserTag2() != null) {
            object = pSSysMapItemBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getUserTag3() != null) {
            object = pSSysMapItemBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getUserTag4() != null) {
            object = pSSysMapItemBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapItemBase.getValidFlag() != null) {
            object = pSSysMapItemBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysMapItemBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysMapItemBase pSSysMapItemBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysMapItemBase.isAltPSDEFIdDirty() && (bl || pSSysMapItemBase.getAltPSDEFId() != null)) {
            iDataObject.set(FIELD_ALTPSDEFID, (Object)pSSysMapItemBase.getAltPSDEFId());
        }
        if (pSSysMapItemBase.isAltPSDEFNameDirty() && (bl || pSSysMapItemBase.getAltPSDEFName() != null)) {
            iDataObject.set(FIELD_ALTPSDEFNAME, (Object)pSSysMapItemBase.getAltPSDEFName());
        }
        if (pSSysMapItemBase.isAsyncPSDEDSIdDirty() && (bl || pSSysMapItemBase.getAsyncPSDEDSId() != null)) {
            iDataObject.set(FIELD_ASYNCPSDEDSID, (Object)pSSysMapItemBase.getAsyncPSDEDSId());
        }
        if (pSSysMapItemBase.isAsyncPSDEDSNameDirty() && (bl || pSSysMapItemBase.getAsyncPSDEDSName() != null)) {
            iDataObject.set(FIELD_ASYNCPSDEDSNAME, (Object)pSSysMapItemBase.getAsyncPSDEDSName());
        }
        if (pSSysMapItemBase.isBKColorDirty() && (bl || pSSysMapItemBase.getBKColor() != null)) {
            iDataObject.set(FIELD_BKCOLOR, (Object)pSSysMapItemBase.getBKColor());
        }
        if (pSSysMapItemBase.isBKColorPSDEFIdDirty() && (bl || pSSysMapItemBase.getBKColorPSDEFId() != null)) {
            iDataObject.set(FIELD_BKCOLORPSDEFID, (Object)pSSysMapItemBase.getBKColorPSDEFId());
        }
        if (pSSysMapItemBase.isBKColorPSDEFNameDirty() && (bl || pSSysMapItemBase.getBKColorPSDEFName() != null)) {
            iDataObject.set(FIELD_BKCOLORPSDEFNAME, (Object)pSSysMapItemBase.getBKColorPSDEFName());
        }
        if (pSSysMapItemBase.isBorderColorDirty() && (bl || pSSysMapItemBase.getBorderColor() != null)) {
            iDataObject.set(FIELD_BORDERCOLOR, (Object)pSSysMapItemBase.getBorderColor());
        }
        if (pSSysMapItemBase.isBorderWidthDirty() && (bl || pSSysMapItemBase.getBorderWidth() != null)) {
            iDataObject.set(FIELD_BORDERWIDTH, (Object)pSSysMapItemBase.getBorderWidth());
        }
        if (pSSysMapItemBase.isClsPSDEFIdDirty() && (bl || pSSysMapItemBase.getClsPSDEFId() != null)) {
            iDataObject.set(FIELD_CLSPSDEFID, (Object)pSSysMapItemBase.getClsPSDEFId());
        }
        if (pSSysMapItemBase.isClsPSDEFNameDirty() && (bl || pSSysMapItemBase.getClsPSDEFName() != null)) {
            iDataObject.set(FIELD_CLSPSDEFNAME, (Object)pSSysMapItemBase.getClsPSDEFName());
        }
        if (pSSysMapItemBase.isColorDirty() && (bl || pSSysMapItemBase.getColor() != null)) {
            iDataObject.set(FIELD_COLOR, (Object)pSSysMapItemBase.getColor());
        }
        if (pSSysMapItemBase.isColorPSDEFIdDirty() && (bl || pSSysMapItemBase.getColorPSDEFId() != null)) {
            iDataObject.set(FIELD_COLORPSDEFID, (Object)pSSysMapItemBase.getColorPSDEFId());
        }
        if (pSSysMapItemBase.isColorPSDEFNameDirty() && (bl || pSSysMapItemBase.getColorPSDEFName() != null)) {
            iDataObject.set(FIELD_COLORPSDEFNAME, (Object)pSSysMapItemBase.getColorPSDEFName());
        }
        if (pSSysMapItemBase.isContentPSDEFIdDirty() && (bl || pSSysMapItemBase.getContentPSDEFId() != null)) {
            iDataObject.set(FIELD_CONTENTPSDEFID, (Object)pSSysMapItemBase.getContentPSDEFId());
        }
        if (pSSysMapItemBase.isContentPSDEFNameDirty() && (bl || pSSysMapItemBase.getContentPSDEFName() != null)) {
            iDataObject.set(FIELD_CONTENTPSDEFNAME, (Object)pSSysMapItemBase.getContentPSDEFName());
        }
        if (pSSysMapItemBase.isCreateDateDirty() && (bl || pSSysMapItemBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysMapItemBase.getCreateDate());
        }
        if (pSSysMapItemBase.isCreateManDirty() && (bl || pSSysMapItemBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysMapItemBase.getCreateMan());
        }
        if (pSSysMapItemBase.isCustomCondDirty() && (bl || pSSysMapItemBase.getCustomCond() != null)) {
            iDataObject.set(FIELD_CUSTOMCOND, (Object)pSSysMapItemBase.getCustomCond());
        }
        if (pSSysMapItemBase.isCustomTypeDirty() && (bl || pSSysMapItemBase.getCustomType() != null)) {
            iDataObject.set(FIELD_CUSTOMTYPE, (Object)pSSysMapItemBase.getCustomType());
        }
        if (pSSysMapItemBase.isData2PSDEFIdDirty() && (bl || pSSysMapItemBase.getData2PSDEFId() != null)) {
            iDataObject.set(FIELD_DATA2PSDEFID, (Object)pSSysMapItemBase.getData2PSDEFId());
        }
        if (pSSysMapItemBase.isData2PSDEFNameDirty() && (bl || pSSysMapItemBase.getData2PSDEFName() != null)) {
            iDataObject.set(FIELD_DATA2PSDEFNAME, (Object)pSSysMapItemBase.getData2PSDEFName());
        }
        if (pSSysMapItemBase.isDataPSDEFIdDirty() && (bl || pSSysMapItemBase.getDataPSDEFId() != null)) {
            iDataObject.set(FIELD_DATAPSDEFID, (Object)pSSysMapItemBase.getDataPSDEFId());
        }
        if (pSSysMapItemBase.isDataPSDEFNameDirty() && (bl || pSSysMapItemBase.getDataPSDEFName() != null)) {
            iDataObject.set(FIELD_DATAPSDEFNAME, (Object)pSSysMapItemBase.getDataPSDEFName());
        }
        if (pSSysMapItemBase.isDynaClassDirty() && (bl || pSSysMapItemBase.getDynaClass() != null)) {
            iDataObject.set(FIELD_DYNACLASS, (Object)pSSysMapItemBase.getDynaClass());
        }
        if (pSSysMapItemBase.isGroupPSDEFIdDirty() && (bl || pSSysMapItemBase.getGroupPSDEFId() != null)) {
            iDataObject.set(FIELD_GROUPPSDEFID, (Object)pSSysMapItemBase.getGroupPSDEFId());
        }
        if (pSSysMapItemBase.isGroupPSDEFNameDirty() && (bl || pSSysMapItemBase.getGroupPSDEFName() != null)) {
            iDataObject.set(FIELD_GROUPPSDEFNAME, (Object)pSSysMapItemBase.getGroupPSDEFName());
        }
        if (pSSysMapItemBase.isGroupPSDEUAGroupIdDirty() && (bl || pSSysMapItemBase.getGroupPSDEUAGroupId() != null)) {
            iDataObject.set(FIELD_GROUPPSDEUAGROUPID, (Object)pSSysMapItemBase.getGroupPSDEUAGroupId());
        }
        if (pSSysMapItemBase.isGroupPSDEUAGroupNameDirty() && (bl || pSSysMapItemBase.getGroupPSDEUAGroupName() != null)) {
            iDataObject.set(FIELD_GROUPPSDEUAGROUPNAME, (Object)pSSysMapItemBase.getGroupPSDEUAGroupName());
        }
        if (pSSysMapItemBase.isIconPSDEFIdDirty() && (bl || pSSysMapItemBase.getIconPSDEFId() != null)) {
            iDataObject.set(FIELD_ICONPSDEFID, (Object)pSSysMapItemBase.getIconPSDEFId());
        }
        if (pSSysMapItemBase.isIconPSDEFNameDirty() && (bl || pSSysMapItemBase.getIconPSDEFName() != null)) {
            iDataObject.set(FIELD_ICONPSDEFNAME, (Object)pSSysMapItemBase.getIconPSDEFName());
        }
        if (pSSysMapItemBase.isItemStyleDirty() && (bl || pSSysMapItemBase.getItemStyle() != null)) {
            iDataObject.set(FIELD_ITEMSTYLE, (Object)pSSysMapItemBase.getItemStyle());
        }
        if (pSSysMapItemBase.isItemStyleTextDirty() && (bl || pSSysMapItemBase.getItemStyleText() != null)) {
            iDataObject.set(FIELD_ITEMSTYLETEXT, (Object)pSSysMapItemBase.getItemStyleText());
        }
        if (pSSysMapItemBase.isItemTypeDirty() && (bl || pSSysMapItemBase.getItemType() != null)) {
            iDataObject.set(FIELD_ITEMTYPE, (Object)pSSysMapItemBase.getItemType());
        }
        if (pSSysMapItemBase.isKeyPSDEFIdDirty() && (bl || pSSysMapItemBase.getKeyPSDEFId() != null)) {
            iDataObject.set(FIELD_KEYPSDEFID, (Object)pSSysMapItemBase.getKeyPSDEFId());
        }
        if (pSSysMapItemBase.isKeyPSDEFNameDirty() && (bl || pSSysMapItemBase.getKeyPSDEFName() != null)) {
            iDataObject.set(FIELD_KEYPSDEFNAME, (Object)pSSysMapItemBase.getKeyPSDEFName());
        }
        if (pSSysMapItemBase.isLatPSDEFIdDirty() && (bl || pSSysMapItemBase.getLatPSDEFId() != null)) {
            iDataObject.set(FIELD_LATPSDEFID, (Object)pSSysMapItemBase.getLatPSDEFId());
        }
        if (pSSysMapItemBase.isLatPSDEFNameDirty() && (bl || pSSysMapItemBase.getLatPSDEFName() != null)) {
            iDataObject.set(FIELD_LATPSDEFNAME, (Object)pSSysMapItemBase.getLatPSDEFName());
        }
        if (pSSysMapItemBase.isLinkPSDEFIdDirty() && (bl || pSSysMapItemBase.getLinkPSDEFId() != null)) {
            iDataObject.set(FIELD_LINKPSDEFID, (Object)pSSysMapItemBase.getLinkPSDEFId());
        }
        if (pSSysMapItemBase.isLinkPSDEFNameDirty() && (bl || pSSysMapItemBase.getLinkPSDEFName() != null)) {
            iDataObject.set(FIELD_LINKPSDEFNAME, (Object)pSSysMapItemBase.getLinkPSDEFName());
        }
        if (pSSysMapItemBase.isLongPSDEFIdDirty() && (bl || pSSysMapItemBase.getLongPSDEFId() != null)) {
            iDataObject.set(FIELD_LONGPSDEFID, (Object)pSSysMapItemBase.getLongPSDEFId());
        }
        if (pSSysMapItemBase.isLongPSDEFNameDirty() && (bl || pSSysMapItemBase.getLongPSDEFName() != null)) {
            iDataObject.set(FIELD_LONGPSDEFNAME, (Object)pSSysMapItemBase.getLongPSDEFName());
        }
        if (pSSysMapItemBase.isMaxSizeDirty() && (bl || pSSysMapItemBase.getMaxSize() != null)) {
            iDataObject.set(FIELD_MAXSIZE, (Object)pSSysMapItemBase.getMaxSize());
        }
        if (pSSysMapItemBase.isMemoDirty() && (bl || pSSysMapItemBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysMapItemBase.getMemo());
        }
        if (pSSysMapItemBase.isModelObjDirty() && (bl || pSSysMapItemBase.getModelObj() != null)) {
            iDataObject.set(FIELD_MODELOBJ, (Object)pSSysMapItemBase.getModelObj());
        }
        if (pSSysMapItemBase.isMovePSDEActionIdDirty() && (bl || pSSysMapItemBase.getMovePSDEActionId() != null)) {
            iDataObject.set(FIELD_MOVEPSDEACTIONID, (Object)pSSysMapItemBase.getMovePSDEActionId());
        }
        if (pSSysMapItemBase.isMovePSDEActionNameDirty() && (bl || pSSysMapItemBase.getMovePSDEActionName() != null)) {
            iDataObject.set(FIELD_MOVEPSDEACTIONNAME, (Object)pSSysMapItemBase.getMovePSDEActionName());
        }
        if (pSSysMapItemBase.isMovePSDEOPPrivIdDirty() && (bl || pSSysMapItemBase.getMovePSDEOPPrivId() != null)) {
            iDataObject.set(FIELD_MOVEPSDEOPPRIVID, (Object)pSSysMapItemBase.getMovePSDEOPPrivId());
        }
        if (pSSysMapItemBase.isMovePSDEOPPrivNameDirty() && (bl || pSSysMapItemBase.getMovePSDEOPPrivName() != null)) {
            iDataObject.set(FIELD_MOVEPSDEOPPRIVNAME, (Object)pSSysMapItemBase.getMovePSDEOPPrivName());
        }
        if (pSSysMapItemBase.isNamePSLanResIdDirty() && (bl || pSSysMapItemBase.getNamePSLanResId() != null)) {
            iDataObject.set(FIELD_NAMEPSLANRESID, (Object)pSSysMapItemBase.getNamePSLanResId());
        }
        if (pSSysMapItemBase.isNamePSLanResNameDirty() && (bl || pSSysMapItemBase.getNamePSLanResName() != null)) {
            iDataObject.set(FIELD_NAMEPSLANRESNAME, (Object)pSSysMapItemBase.getNamePSLanResName());
        }
        if (pSSysMapItemBase.isNavViewFilterDirty() && (bl || pSSysMapItemBase.getNavViewFilter() != null)) {
            iDataObject.set(FIELD_NAVVIEWFILTER, (Object)pSSysMapItemBase.getNavViewFilter());
        }
        if (pSSysMapItemBase.isNavViewParamDirty() && (bl || pSSysMapItemBase.getNavViewParam() != null)) {
            iDataObject.set(FIELD_NAVVIEWPARAM, (Object)pSSysMapItemBase.getNavViewParam());
        }
        if (pSSysMapItemBase.isOrderValueDirty() && (bl || pSSysMapItemBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysMapItemBase.getOrderValue());
        }
        if (pSSysMapItemBase.isOrderValuePSDEFIdDirty() && (bl || pSSysMapItemBase.getOrderValuePSDEFId() != null)) {
            iDataObject.set(FIELD_ORDERVALUEPSDEFID, (Object)pSSysMapItemBase.getOrderValuePSDEFId());
        }
        if (pSSysMapItemBase.isOrderValuePSDEFNameDirty() && (bl || pSSysMapItemBase.getOrderValuePSDEFName() != null)) {
            iDataObject.set(FIELD_ORDERVALUEPSDEFNAME, (Object)pSSysMapItemBase.getOrderValuePSDEFName());
        }
        if (pSSysMapItemBase.isPSDEDSIdDirty() && (bl || pSSysMapItemBase.getPSDEDSId() != null)) {
            iDataObject.set(FIELD_PSDEDSID, (Object)pSSysMapItemBase.getPSDEDSId());
        }
        if (pSSysMapItemBase.isPSDEDSNameDirty() && (bl || pSSysMapItemBase.getPSDEDSName() != null)) {
            iDataObject.set(FIELD_PSDEDSNAME, (Object)pSSysMapItemBase.getPSDEDSName());
        }
        if (pSSysMapItemBase.isPSDEIdDirty() && (bl || pSSysMapItemBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysMapItemBase.getPSDEId());
        }
        if (pSSysMapItemBase.isPSDELogicIdDirty() && (bl || pSSysMapItemBase.getPSDELogicId() != null)) {
            iDataObject.set(FIELD_PSDELOGICID, (Object)pSSysMapItemBase.getPSDELogicId());
        }
        if (pSSysMapItemBase.isPSDELogicNameDirty() && (bl || pSSysMapItemBase.getPSDELogicName() != null)) {
            iDataObject.set(FIELD_PSDELOGICNAME, (Object)pSSysMapItemBase.getPSDELogicName());
        }
        if (pSSysMapItemBase.isPSDENameDirty() && (bl || pSSysMapItemBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysMapItemBase.getPSDEName());
        }
        if (pSSysMapItemBase.isPSDERIdDirty() && (bl || pSSysMapItemBase.getPSDERId() != null)) {
            iDataObject.set(FIELD_PSDERID, (Object)pSSysMapItemBase.getPSDERId());
        }
        if (pSSysMapItemBase.isPSDERNameDirty() && (bl || pSSysMapItemBase.getPSDERName() != null)) {
            iDataObject.set(FIELD_PSDERNAME, (Object)pSSysMapItemBase.getPSDERName());
        }
        if (pSSysMapItemBase.isPSDEToolbarIdDirty() && (bl || pSSysMapItemBase.getPSDEToolbarId() != null)) {
            iDataObject.set(FIELD_PSDETOOLBARID, (Object)pSSysMapItemBase.getPSDEToolbarId());
        }
        if (pSSysMapItemBase.isPSDEToolbarNameDirty() && (bl || pSSysMapItemBase.getPSDEToolbarName() != null)) {
            iDataObject.set(FIELD_PSDETOOLBARNAME, (Object)pSSysMapItemBase.getPSDEToolbarName());
        }
        if (pSSysMapItemBase.isPSDEViewBaseIdDirty() && (bl || pSSysMapItemBase.getPSDEViewBaseId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASEID, (Object)pSSysMapItemBase.getPSDEViewBaseId());
        }
        if (pSSysMapItemBase.isPSDEViewBaseNameDirty() && (bl || pSSysMapItemBase.getPSDEViewBaseName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASENAME, (Object)pSSysMapItemBase.getPSDEViewBaseName());
        }
        if (pSSysMapItemBase.isPSSysCssIdDirty() && (bl || pSSysMapItemBase.getPSSysCssId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSID, (Object)pSSysMapItemBase.getPSSysCssId());
        }
        if (pSSysMapItemBase.isPSSysCssNameDirty() && (bl || pSSysMapItemBase.getPSSysCssName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSNAME, (Object)pSSysMapItemBase.getPSSysCssName());
        }
        if (pSSysMapItemBase.isPSSysImageIdDirty() && (bl || pSSysMapItemBase.getPSSysImageId() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGEID, (Object)pSSysMapItemBase.getPSSysImageId());
        }
        if (pSSysMapItemBase.isPSSysImageNameDirty() && (bl || pSSysMapItemBase.getPSSysImageName() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGENAME, (Object)pSSysMapItemBase.getPSSysImageName());
        }
        if (pSSysMapItemBase.isPSSysMapItemIdDirty() && (bl || pSSysMapItemBase.getPSSysMapItemId() != null)) {
            iDataObject.set(FIELD_PSSYSMAPITEMID, (Object)pSSysMapItemBase.getPSSysMapItemId());
        }
        if (pSSysMapItemBase.isPSSysMapItemNameDirty() && (bl || pSSysMapItemBase.getPSSysMapItemName() != null)) {
            iDataObject.set(FIELD_PSSYSMAPITEMNAME, (Object)pSSysMapItemBase.getPSSysMapItemName());
        }
        if (pSSysMapItemBase.isPSSysMapViewIdDirty() && (bl || pSSysMapItemBase.getPSSysMapViewId() != null)) {
            iDataObject.set(FIELD_PSSYSMAPVIEWID, (Object)pSSysMapItemBase.getPSSysMapViewId());
        }
        if (pSSysMapItemBase.isPSSysMapViewNameDirty() && (bl || pSSysMapItemBase.getPSSysMapViewName() != null)) {
            iDataObject.set(FIELD_PSSYSMAPVIEWNAME, (Object)pSSysMapItemBase.getPSSysMapViewName());
        }
        if (pSSysMapItemBase.isPSSysPFPluginIdDirty() && (bl || pSSysMapItemBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSSysMapItemBase.getPSSysPFPluginId());
        }
        if (pSSysMapItemBase.isPSSysPFPluginNameDirty() && (bl || pSSysMapItemBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSSysMapItemBase.getPSSysPFPluginName());
        }
        if (pSSysMapItemBase.isRadiusDirty() && (bl || pSSysMapItemBase.getRadius() != null)) {
            iDataObject.set(FIELD_RADIUS, (Object)pSSysMapItemBase.getRadius());
        }
        if (pSSysMapItemBase.isRemovePSDEActionIdDirty() && (bl || pSSysMapItemBase.getRemovePSDEActionId() != null)) {
            iDataObject.set(FIELD_REMOVEPSDEACTIONID, (Object)pSSysMapItemBase.getRemovePSDEActionId());
        }
        if (pSSysMapItemBase.isRemovePSDEActionNameDirty() && (bl || pSSysMapItemBase.getRemovePSDEActionName() != null)) {
            iDataObject.set(FIELD_REMOVEPSDEACTIONNAME, (Object)pSSysMapItemBase.getRemovePSDEActionName());
        }
        if (pSSysMapItemBase.isRemovePSDEOPPrivIdDirty() && (bl || pSSysMapItemBase.getRemovePSDEOPPrivId() != null)) {
            iDataObject.set(FIELD_REMOVEPSDEOPPRIVID, (Object)pSSysMapItemBase.getRemovePSDEOPPrivId());
        }
        if (pSSysMapItemBase.isRemovePSDEOPPrivNameDirty() && (bl || pSSysMapItemBase.getRemovePSDEOPPrivName() != null)) {
            iDataObject.set(FIELD_REMOVEPSDEOPPRIVNAME, (Object)pSSysMapItemBase.getRemovePSDEOPPrivName());
        }
        if (pSSysMapItemBase.isShapeClsPSDEFIdDirty() && (bl || pSSysMapItemBase.getShapeClsPSDEFId() != null)) {
            iDataObject.set(FIELD_SHAPECLSPSDEFID, (Object)pSSysMapItemBase.getShapeClsPSDEFId());
        }
        if (pSSysMapItemBase.isShapeClsPSDEFNameDirty() && (bl || pSSysMapItemBase.getShapeClsPSDEFName() != null)) {
            iDataObject.set(FIELD_SHAPECLSPSDEFNAME, (Object)pSSysMapItemBase.getShapeClsPSDEFName());
        }
        if (pSSysMapItemBase.isShapeDynaClassDirty() && (bl || pSSysMapItemBase.getShapeDynaClass() != null)) {
            iDataObject.set(FIELD_SHAPEDYNACLASS, (Object)pSSysMapItemBase.getShapeDynaClass());
        }
        if (pSSysMapItemBase.isShapePSSysCssIdDirty() && (bl || pSSysMapItemBase.getShapePSSysCssId() != null)) {
            iDataObject.set(FIELD_SHAPEPSSYSCSSID, (Object)pSSysMapItemBase.getShapePSSysCssId());
        }
        if (pSSysMapItemBase.isShapePSSysCssNameDirty() && (bl || pSSysMapItemBase.getShapePSSysCssName() != null)) {
            iDataObject.set(FIELD_SHAPEPSSYSCSSNAME, (Object)pSSysMapItemBase.getShapePSSysCssName());
        }
        if (pSSysMapItemBase.isTag2PSDEFIdDirty() && (bl || pSSysMapItemBase.getTag2PSDEFId() != null)) {
            iDataObject.set(FIELD_TAG2PSDEFID, (Object)pSSysMapItemBase.getTag2PSDEFId());
        }
        if (pSSysMapItemBase.isTag2PSDEFNameDirty() && (bl || pSSysMapItemBase.getTag2PSDEFName() != null)) {
            iDataObject.set(FIELD_TAG2PSDEFNAME, (Object)pSSysMapItemBase.getTag2PSDEFName());
        }
        if (pSSysMapItemBase.isTagPSDEFIdDirty() && (bl || pSSysMapItemBase.getTagPSDEFId() != null)) {
            iDataObject.set(FIELD_TAGPSDEFID, (Object)pSSysMapItemBase.getTagPSDEFId());
        }
        if (pSSysMapItemBase.isTagPSDEFNameDirty() && (bl || pSSysMapItemBase.getTagPSDEFName() != null)) {
            iDataObject.set(FIELD_TAGPSDEFNAME, (Object)pSSysMapItemBase.getTagPSDEFName());
        }
        if (pSSysMapItemBase.isTextPSDEFIdDirty() && (bl || pSSysMapItemBase.getTextPSDEFId() != null)) {
            iDataObject.set(FIELD_TEXTPSDEFID, (Object)pSSysMapItemBase.getTextPSDEFId());
        }
        if (pSSysMapItemBase.isTextPSDEFNameDirty() && (bl || pSSysMapItemBase.getTextPSDEFName() != null)) {
            iDataObject.set(FIELD_TEXTPSDEFNAME, (Object)pSSysMapItemBase.getTextPSDEFName());
        }
        if (pSSysMapItemBase.isTimePSDEFIdDirty() && (bl || pSSysMapItemBase.getTimePSDEFId() != null)) {
            iDataObject.set(FIELD_TIMEPSDEFID, (Object)pSSysMapItemBase.getTimePSDEFId());
        }
        if (pSSysMapItemBase.isTimePSDEFNameDirty() && (bl || pSSysMapItemBase.getTimePSDEFName() != null)) {
            iDataObject.set(FIELD_TIMEPSDEFNAME, (Object)pSSysMapItemBase.getTimePSDEFName());
        }
        if (pSSysMapItemBase.isTipsPSDEFIdDirty() && (bl || pSSysMapItemBase.getTipsPSDEFId() != null)) {
            iDataObject.set(FIELD_TIPSPSDEFID, (Object)pSSysMapItemBase.getTipsPSDEFId());
        }
        if (pSSysMapItemBase.isTipsPSDEFNameDirty() && (bl || pSSysMapItemBase.getTipsPSDEFName() != null)) {
            iDataObject.set(FIELD_TIPSPSDEFNAME, (Object)pSSysMapItemBase.getTipsPSDEFName());
        }
        if (pSSysMapItemBase.isUpdateDateDirty() && (bl || pSSysMapItemBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysMapItemBase.getUpdateDate());
        }
        if (pSSysMapItemBase.isUpdateManDirty() && (bl || pSSysMapItemBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysMapItemBase.getUpdateMan());
        }
        if (pSSysMapItemBase.isUserCatDirty() && (bl || pSSysMapItemBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysMapItemBase.getUserCat());
        }
        if (pSSysMapItemBase.isUserTagDirty() && (bl || pSSysMapItemBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysMapItemBase.getUserTag());
        }
        if (pSSysMapItemBase.isUserTag2Dirty() && (bl || pSSysMapItemBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysMapItemBase.getUserTag2());
        }
        if (pSSysMapItemBase.isUserTag3Dirty() && (bl || pSSysMapItemBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysMapItemBase.getUserTag3());
        }
        if (pSSysMapItemBase.isUserTag4Dirty() && (bl || pSSysMapItemBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysMapItemBase.getUserTag4());
        }
        if (pSSysMapItemBase.isValidFlagDirty() && (bl || pSSysMapItemBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysMapItemBase.getValidFlag());
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
        return PSSysMapItemBase.remove(this, n);
    }

    private static boolean remove(PSSysMapItemBase pSSysMapItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysMapItemBase.resetAltPSDEFId();
                return true;
            }
            case 1: {
                pSSysMapItemBase.resetAltPSDEFName();
                return true;
            }
            case 2: {
                pSSysMapItemBase.resetAsyncPSDEDSId();
                return true;
            }
            case 3: {
                pSSysMapItemBase.resetAsyncPSDEDSName();
                return true;
            }
            case 4: {
                pSSysMapItemBase.resetBKColor();
                return true;
            }
            case 5: {
                pSSysMapItemBase.resetBKColorPSDEFId();
                return true;
            }
            case 6: {
                pSSysMapItemBase.resetBKColorPSDEFName();
                return true;
            }
            case 7: {
                pSSysMapItemBase.resetBorderColor();
                return true;
            }
            case 8: {
                pSSysMapItemBase.resetBorderWidth();
                return true;
            }
            case 9: {
                pSSysMapItemBase.resetClsPSDEFId();
                return true;
            }
            case 10: {
                pSSysMapItemBase.resetClsPSDEFName();
                return true;
            }
            case 11: {
                pSSysMapItemBase.resetColor();
                return true;
            }
            case 12: {
                pSSysMapItemBase.resetColorPSDEFId();
                return true;
            }
            case 13: {
                pSSysMapItemBase.resetColorPSDEFName();
                return true;
            }
            case 14: {
                pSSysMapItemBase.resetContentPSDEFId();
                return true;
            }
            case 15: {
                pSSysMapItemBase.resetContentPSDEFName();
                return true;
            }
            case 16: {
                pSSysMapItemBase.resetCreateDate();
                return true;
            }
            case 17: {
                pSSysMapItemBase.resetCreateMan();
                return true;
            }
            case 18: {
                pSSysMapItemBase.resetCustomCond();
                return true;
            }
            case 19: {
                pSSysMapItemBase.resetCustomType();
                return true;
            }
            case 20: {
                pSSysMapItemBase.resetData2PSDEFId();
                return true;
            }
            case 21: {
                pSSysMapItemBase.resetData2PSDEFName();
                return true;
            }
            case 22: {
                pSSysMapItemBase.resetDataPSDEFId();
                return true;
            }
            case 23: {
                pSSysMapItemBase.resetDataPSDEFName();
                return true;
            }
            case 24: {
                pSSysMapItemBase.resetDynaClass();
                return true;
            }
            case 25: {
                pSSysMapItemBase.resetGroupPSDEFId();
                return true;
            }
            case 26: {
                pSSysMapItemBase.resetGroupPSDEFName();
                return true;
            }
            case 27: {
                pSSysMapItemBase.resetGroupPSDEUAGroupId();
                return true;
            }
            case 28: {
                pSSysMapItemBase.resetGroupPSDEUAGroupName();
                return true;
            }
            case 29: {
                pSSysMapItemBase.resetIconPSDEFId();
                return true;
            }
            case 30: {
                pSSysMapItemBase.resetIconPSDEFName();
                return true;
            }
            case 31: {
                pSSysMapItemBase.resetItemStyle();
                return true;
            }
            case 32: {
                pSSysMapItemBase.resetItemStyleText();
                return true;
            }
            case 33: {
                pSSysMapItemBase.resetItemType();
                return true;
            }
            case 34: {
                pSSysMapItemBase.resetKeyPSDEFId();
                return true;
            }
            case 35: {
                pSSysMapItemBase.resetKeyPSDEFName();
                return true;
            }
            case 36: {
                pSSysMapItemBase.resetLatPSDEFId();
                return true;
            }
            case 37: {
                pSSysMapItemBase.resetLatPSDEFName();
                return true;
            }
            case 38: {
                pSSysMapItemBase.resetLinkPSDEFId();
                return true;
            }
            case 39: {
                pSSysMapItemBase.resetLinkPSDEFName();
                return true;
            }
            case 40: {
                pSSysMapItemBase.resetLongPSDEFId();
                return true;
            }
            case 41: {
                pSSysMapItemBase.resetLongPSDEFName();
                return true;
            }
            case 42: {
                pSSysMapItemBase.resetMaxSize();
                return true;
            }
            case 43: {
                pSSysMapItemBase.resetMemo();
                return true;
            }
            case 44: {
                pSSysMapItemBase.resetModelObj();
                return true;
            }
            case 45: {
                pSSysMapItemBase.resetMovePSDEActionId();
                return true;
            }
            case 46: {
                pSSysMapItemBase.resetMovePSDEActionName();
                return true;
            }
            case 47: {
                pSSysMapItemBase.resetMovePSDEOPPrivId();
                return true;
            }
            case 48: {
                pSSysMapItemBase.resetMovePSDEOPPrivName();
                return true;
            }
            case 49: {
                pSSysMapItemBase.resetNamePSLanResId();
                return true;
            }
            case 50: {
                pSSysMapItemBase.resetNamePSLanResName();
                return true;
            }
            case 51: {
                pSSysMapItemBase.resetNavViewFilter();
                return true;
            }
            case 52: {
                pSSysMapItemBase.resetNavViewParam();
                return true;
            }
            case 53: {
                pSSysMapItemBase.resetOrderValue();
                return true;
            }
            case 54: {
                pSSysMapItemBase.resetOrderValuePSDEFId();
                return true;
            }
            case 55: {
                pSSysMapItemBase.resetOrderValuePSDEFName();
                return true;
            }
            case 56: {
                pSSysMapItemBase.resetPSDEDSId();
                return true;
            }
            case 57: {
                pSSysMapItemBase.resetPSDEDSName();
                return true;
            }
            case 58: {
                pSSysMapItemBase.resetPSDEId();
                return true;
            }
            case 59: {
                pSSysMapItemBase.resetPSDELogicId();
                return true;
            }
            case 60: {
                pSSysMapItemBase.resetPSDELogicName();
                return true;
            }
            case 61: {
                pSSysMapItemBase.resetPSDEName();
                return true;
            }
            case 62: {
                pSSysMapItemBase.resetPSDERId();
                return true;
            }
            case 63: {
                pSSysMapItemBase.resetPSDERName();
                return true;
            }
            case 64: {
                pSSysMapItemBase.resetPSDEToolbarId();
                return true;
            }
            case 65: {
                pSSysMapItemBase.resetPSDEToolbarName();
                return true;
            }
            case 66: {
                pSSysMapItemBase.resetPSDEViewBaseId();
                return true;
            }
            case 67: {
                pSSysMapItemBase.resetPSDEViewBaseName();
                return true;
            }
            case 68: {
                pSSysMapItemBase.resetPSSysCssId();
                return true;
            }
            case 69: {
                pSSysMapItemBase.resetPSSysCssName();
                return true;
            }
            case 70: {
                pSSysMapItemBase.resetPSSysImageId();
                return true;
            }
            case 71: {
                pSSysMapItemBase.resetPSSysImageName();
                return true;
            }
            case 72: {
                pSSysMapItemBase.resetPSSysMapItemId();
                return true;
            }
            case 73: {
                pSSysMapItemBase.resetPSSysMapItemName();
                return true;
            }
            case 74: {
                pSSysMapItemBase.resetPSSysMapViewId();
                return true;
            }
            case 75: {
                pSSysMapItemBase.resetPSSysMapViewName();
                return true;
            }
            case 76: {
                pSSysMapItemBase.resetPSSysPFPluginId();
                return true;
            }
            case 77: {
                pSSysMapItemBase.resetPSSysPFPluginName();
                return true;
            }
            case 78: {
                pSSysMapItemBase.resetRadius();
                return true;
            }
            case 79: {
                pSSysMapItemBase.resetRemovePSDEActionId();
                return true;
            }
            case 80: {
                pSSysMapItemBase.resetRemovePSDEActionName();
                return true;
            }
            case 81: {
                pSSysMapItemBase.resetRemovePSDEOPPrivId();
                return true;
            }
            case 82: {
                pSSysMapItemBase.resetRemovePSDEOPPrivName();
                return true;
            }
            case 83: {
                pSSysMapItemBase.resetShapeClsPSDEFId();
                return true;
            }
            case 84: {
                pSSysMapItemBase.resetShapeClsPSDEFName();
                return true;
            }
            case 85: {
                pSSysMapItemBase.resetShapeDynaClass();
                return true;
            }
            case 86: {
                pSSysMapItemBase.resetShapePSSysCssId();
                return true;
            }
            case 87: {
                pSSysMapItemBase.resetShapePSSysCssName();
                return true;
            }
            case 88: {
                pSSysMapItemBase.resetTag2PSDEFId();
                return true;
            }
            case 89: {
                pSSysMapItemBase.resetTag2PSDEFName();
                return true;
            }
            case 90: {
                pSSysMapItemBase.resetTagPSDEFId();
                return true;
            }
            case 91: {
                pSSysMapItemBase.resetTagPSDEFName();
                return true;
            }
            case 92: {
                pSSysMapItemBase.resetTextPSDEFId();
                return true;
            }
            case 93: {
                pSSysMapItemBase.resetTextPSDEFName();
                return true;
            }
            case 94: {
                pSSysMapItemBase.resetTimePSDEFId();
                return true;
            }
            case 95: {
                pSSysMapItemBase.resetTimePSDEFName();
                return true;
            }
            case 96: {
                pSSysMapItemBase.resetTipsPSDEFId();
                return true;
            }
            case 97: {
                pSSysMapItemBase.resetTipsPSDEFName();
                return true;
            }
            case 98: {
                pSSysMapItemBase.resetUpdateDate();
                return true;
            }
            case 99: {
                pSSysMapItemBase.resetUpdateMan();
                return true;
            }
            case 100: {
                pSSysMapItemBase.resetUserCat();
                return true;
            }
            case 101: {
                pSSysMapItemBase.resetUserTag();
                return true;
            }
            case 102: {
                pSSysMapItemBase.resetUserTag2();
                return true;
            }
            case 103: {
                pSSysMapItemBase.resetUserTag3();
                return true;
            }
            case 104: {
                pSSysMapItemBase.resetUserTag4();
                return true;
            }
            case 105: {
                pSSysMapItemBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDE();
        }
        if (this.getPSDEId() == null) {
            return null;
        }
        Integer n = this.objPSDELock;
        synchronized (n) {
            if (this.psde != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEId(), (Object)this.psde.getPSDataEntityId()) != 0L) {
                this.psde = null;
            }
            if (this.psde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getMovePSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMovePSDEAction();
        }
        if (this.getMovePSDEActionId() == null) {
            return null;
        }
        Integer n = this.objMovePSDEActionLock;
        synchronized (n) {
            if (this.movepsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getMovePSDEActionId(), (Object)this.movepsdeaction.getPSDEActionId()) != 0L) {
                this.movepsdeaction = null;
            }
            if (this.movepsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getMovePSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.movepsdeaction = pSDEAction;
            }
            return this.movepsdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getRemovePSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemovePSDEAction();
        }
        if (this.getRemovePSDEActionId() == null) {
            return null;
        }
        Integer n = this.objRemovePSDEActionLock;
        synchronized (n) {
            if (this.removepsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getRemovePSDEActionId(), (Object)this.removepsdeaction.getPSDEActionId()) != 0L) {
                this.removepsdeaction = null;
            }
            if (this.removepsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getRemovePSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.removepsdeaction = pSDEAction;
            }
            return this.removepsdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getAsyncPSDEDS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAsyncPSDEDS();
        }
        if (this.getAsyncPSDEDSId() == null) {
            return null;
        }
        Integer n = this.objAsyncPSDEDSLock;
        synchronized (n) {
            if (this.asyncpsdeds != null && DataTypeHelper.compare((int)25, (Object)this.getAsyncPSDEDSId(), (Object)this.asyncpsdeds.getPSDEDataSetId()) != 0L) {
                this.asyncpsdeds = null;
            }
            if (this.asyncpsdeds == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getAsyncPSDEDSId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet((IEntity)pSDEDataSet);
                this.asyncpsdeds = pSDEDataSet;
            }
            return this.asyncpsdeds;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getPSDEDS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDS();
        }
        if (this.getPSDEDSId() == null) {
            return null;
        }
        Integer n = this.objPSDEDSLock;
        synchronized (n) {
            if (this.psdeds != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDSId(), (Object)this.psdeds.getPSDEDataSetId()) != 0L) {
                this.psdeds = null;
            }
            if (this.psdeds == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getPSDEDSId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet((IEntity)pSDEDataSet);
                this.psdeds = pSDEDataSet;
            }
            return this.psdeds;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getAltPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAltPSDEF();
        }
        if (this.getAltPSDEFId() == null) {
            return null;
        }
        Integer n = this.objAltPSDEFLock;
        synchronized (n) {
            if (this.altpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getAltPSDEFId(), (Object)this.altpsdef.getPSDEFieldId()) != 0L) {
                this.altpsdef = null;
            }
            if (this.altpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getAltPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.altpsdef = pSDEField;
            }
            return this.altpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getBKColorPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBKColorPSDEF();
        }
        if (this.getBKColorPSDEFId() == null) {
            return null;
        }
        Integer n = this.objBKColorPSDEFLock;
        synchronized (n) {
            if (this.bkcolorpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getBKColorPSDEFId(), (Object)this.bkcolorpsdef.getPSDEFieldId()) != 0L) {
                this.bkcolorpsdef = null;
            }
            if (this.bkcolorpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getBKColorPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.bkcolorpsdef = pSDEField;
            }
            return this.bkcolorpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getClsPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getClsPSDEF();
        }
        if (this.getClsPSDEFId() == null) {
            return null;
        }
        Integer n = this.objClsPSDEFLock;
        synchronized (n) {
            if (this.clspsdef != null && DataTypeHelper.compare((int)25, (Object)this.getClsPSDEFId(), (Object)this.clspsdef.getPSDEFieldId()) != 0L) {
                this.clspsdef = null;
            }
            if (this.clspsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getClsPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.clspsdef = pSDEField;
            }
            return this.clspsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getColorPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getColorPSDEF();
        }
        if (this.getColorPSDEFId() == null) {
            return null;
        }
        Integer n = this.objColorPSDEFLock;
        synchronized (n) {
            if (this.colorpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getColorPSDEFId(), (Object)this.colorpsdef.getPSDEFieldId()) != 0L) {
                this.colorpsdef = null;
            }
            if (this.colorpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getColorPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.colorpsdef = pSDEField;
            }
            return this.colorpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getContentPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentPSDEF();
        }
        if (this.getContentPSDEFId() == null) {
            return null;
        }
        Integer n = this.objContentPSDEFLock;
        synchronized (n) {
            if (this.contentpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getContentPSDEFId(), (Object)this.contentpsdef.getPSDEFieldId()) != 0L) {
                this.contentpsdef = null;
            }
            if (this.contentpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getContentPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.contentpsdef = pSDEField;
            }
            return this.contentpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getData2PSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getData2PSDEF();
        }
        if (this.getData2PSDEFId() == null) {
            return null;
        }
        Integer n = this.objData2PSDEFLock;
        synchronized (n) {
            if (this.data2psdef != null && DataTypeHelper.compare((int)25, (Object)this.getData2PSDEFId(), (Object)this.data2psdef.getPSDEFieldId()) != 0L) {
                this.data2psdef = null;
            }
            if (this.data2psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getData2PSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.data2psdef = pSDEField;
            }
            return this.data2psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getDataPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataPSDEF();
        }
        if (this.getDataPSDEFId() == null) {
            return null;
        }
        Integer n = this.objDataPSDEFLock;
        synchronized (n) {
            if (this.datapsdef != null && DataTypeHelper.compare((int)25, (Object)this.getDataPSDEFId(), (Object)this.datapsdef.getPSDEFieldId()) != 0L) {
                this.datapsdef = null;
            }
            if (this.datapsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getDataPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.datapsdef = pSDEField;
            }
            return this.datapsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getGroupPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupPSDEF();
        }
        if (this.getGroupPSDEFId() == null) {
            return null;
        }
        Integer n = this.objGroupPSDEFLock;
        synchronized (n) {
            if (this.grouppsdef != null && DataTypeHelper.compare((int)25, (Object)this.getGroupPSDEFId(), (Object)this.grouppsdef.getPSDEFieldId()) != 0L) {
                this.grouppsdef = null;
            }
            if (this.grouppsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getGroupPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.grouppsdef = pSDEField;
            }
            return this.grouppsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getIconPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIconPSDEF();
        }
        if (this.getIconPSDEFId() == null) {
            return null;
        }
        Integer n = this.objIconPSDEFLock;
        synchronized (n) {
            if (this.iconpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getIconPSDEFId(), (Object)this.iconpsdef.getPSDEFieldId()) != 0L) {
                this.iconpsdef = null;
            }
            if (this.iconpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getIconPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.iconpsdef = pSDEField;
            }
            return this.iconpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getKeyPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKeyPSDEF();
        }
        if (this.getKeyPSDEFId() == null) {
            return null;
        }
        Integer n = this.objKeyPSDEFLock;
        synchronized (n) {
            if (this.keypsdef != null && DataTypeHelper.compare((int)25, (Object)this.getKeyPSDEFId(), (Object)this.keypsdef.getPSDEFieldId()) != 0L) {
                this.keypsdef = null;
            }
            if (this.keypsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getKeyPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.keypsdef = pSDEField;
            }
            return this.keypsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getLatPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLatPSDEF();
        }
        if (this.getLatPSDEFId() == null) {
            return null;
        }
        Integer n = this.objLatPSDEFLock;
        synchronized (n) {
            if (this.latpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getLatPSDEFId(), (Object)this.latpsdef.getPSDEFieldId()) != 0L) {
                this.latpsdef = null;
            }
            if (this.latpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getLatPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.latpsdef = pSDEField;
            }
            return this.latpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getLinkPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkPSDEF();
        }
        if (this.getLinkPSDEFId() == null) {
            return null;
        }
        Integer n = this.objLinkPSDEFLock;
        synchronized (n) {
            if (this.linkpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getLinkPSDEFId(), (Object)this.linkpsdef.getPSDEFieldId()) != 0L) {
                this.linkpsdef = null;
            }
            if (this.linkpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getLinkPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.linkpsdef = pSDEField;
            }
            return this.linkpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getLongPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLongPSDEF();
        }
        if (this.getLongPSDEFId() == null) {
            return null;
        }
        Integer n = this.objLongPSDEFLock;
        synchronized (n) {
            if (this.longpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getLongPSDEFId(), (Object)this.longpsdef.getPSDEFieldId()) != 0L) {
                this.longpsdef = null;
            }
            if (this.longpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getLongPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.longpsdef = pSDEField;
            }
            return this.longpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getOrderValuePSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValuePSDEF();
        }
        if (this.getOrderValuePSDEFId() == null) {
            return null;
        }
        Integer n = this.objOrderValuePSDEFLock;
        synchronized (n) {
            if (this.ordervaluepsdef != null && DataTypeHelper.compare((int)25, (Object)this.getOrderValuePSDEFId(), (Object)this.ordervaluepsdef.getPSDEFieldId()) != 0L) {
                this.ordervaluepsdef = null;
            }
            if (this.ordervaluepsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getOrderValuePSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.ordervaluepsdef = pSDEField;
            }
            return this.ordervaluepsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getShapeClsPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getShapeClsPSDEF();
        }
        if (this.getShapeClsPSDEFId() == null) {
            return null;
        }
        Integer n = this.objShapeClsPSDEFLock;
        synchronized (n) {
            if (this.shapeclspsdef != null && DataTypeHelper.compare((int)25, (Object)this.getShapeClsPSDEFId(), (Object)this.shapeclspsdef.getPSDEFieldId()) != 0L) {
                this.shapeclspsdef = null;
            }
            if (this.shapeclspsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getShapeClsPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.shapeclspsdef = pSDEField;
            }
            return this.shapeclspsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getTag2PSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTag2PSDEF();
        }
        if (this.getTag2PSDEFId() == null) {
            return null;
        }
        Integer n = this.objTag2PSDEFLock;
        synchronized (n) {
            if (this.tag2psdef != null && DataTypeHelper.compare((int)25, (Object)this.getTag2PSDEFId(), (Object)this.tag2psdef.getPSDEFieldId()) != 0L) {
                this.tag2psdef = null;
            }
            if (this.tag2psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getTag2PSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.tag2psdef = pSDEField;
            }
            return this.tag2psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getTagPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTagPSDEF();
        }
        if (this.getTagPSDEFId() == null) {
            return null;
        }
        Integer n = this.objTagPSDEFLock;
        synchronized (n) {
            if (this.tagpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getTagPSDEFId(), (Object)this.tagpsdef.getPSDEFieldId()) != 0L) {
                this.tagpsdef = null;
            }
            if (this.tagpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getTagPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.tagpsdef = pSDEField;
            }
            return this.tagpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getTextPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTextPSDEF();
        }
        if (this.getTextPSDEFId() == null) {
            return null;
        }
        Integer n = this.objTextPSDEFLock;
        synchronized (n) {
            if (this.textpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getTextPSDEFId(), (Object)this.textpsdef.getPSDEFieldId()) != 0L) {
                this.textpsdef = null;
            }
            if (this.textpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getTextPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.textpsdef = pSDEField;
            }
            return this.textpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getTimePSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTimePSDEF();
        }
        if (this.getTimePSDEFId() == null) {
            return null;
        }
        Integer n = this.objTimePSDEFLock;
        synchronized (n) {
            if (this.timepsdef != null && DataTypeHelper.compare((int)25, (Object)this.getTimePSDEFId(), (Object)this.timepsdef.getPSDEFieldId()) != 0L) {
                this.timepsdef = null;
            }
            if (this.timepsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getTimePSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.timepsdef = pSDEField;
            }
            return this.timepsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getTipsPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTipsPSDEF();
        }
        if (this.getTipsPSDEFId() == null) {
            return null;
        }
        Integer n = this.objTipsPSDEFLock;
        synchronized (n) {
            if (this.tipspsdef != null && DataTypeHelper.compare((int)25, (Object)this.getTipsPSDEFId(), (Object)this.tipspsdef.getPSDEFieldId()) != 0L) {
                this.tipspsdef = null;
            }
            if (this.tipspsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getTipsPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.tipspsdef = pSDEField;
            }
            return this.tipspsdef;
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
    public PSDEOPPriv getMovePSDEOPPriv() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMovePSDEOPPriv();
        }
        if (this.getMovePSDEOPPrivId() == null) {
            return null;
        }
        Integer n = this.objMovePSDEOPPrivLock;
        synchronized (n) {
            if (this.movepsdeoppriv != null && DataTypeHelper.compare((int)25, (Object)this.getMovePSDEOPPrivId(), (Object)this.movepsdeoppriv.getPSDEOPPrivId()) != 0L) {
                this.movepsdeoppriv = null;
            }
            if (this.movepsdeoppriv == null) {
                PSDEOPPriv pSDEOPPriv = new PSDEOPPriv();
                pSDEOPPriv.setPSDEOPPrivId(this.getMovePSDEOPPrivId());
                PSDEOPPrivService pSDEOPPrivService = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
                pSDEOPPrivService.autoGet((IEntity)pSDEOPPriv);
                this.movepsdeoppriv = pSDEOPPriv;
            }
            return this.movepsdeoppriv;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEOPPriv getRemovePSDEOPPriv() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemovePSDEOPPriv();
        }
        if (this.getRemovePSDEOPPrivId() == null) {
            return null;
        }
        Integer n = this.objRemovePSDEOPPrivLock;
        synchronized (n) {
            if (this.removepsdeoppriv != null && DataTypeHelper.compare((int)25, (Object)this.getRemovePSDEOPPrivId(), (Object)this.removepsdeoppriv.getPSDEOPPrivId()) != 0L) {
                this.removepsdeoppriv = null;
            }
            if (this.removepsdeoppriv == null) {
                PSDEOPPriv pSDEOPPriv = new PSDEOPPriv();
                pSDEOPPriv.setPSDEOPPrivId(this.getRemovePSDEOPPrivId());
                PSDEOPPrivService pSDEOPPrivService = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
                pSDEOPPrivService.autoGet((IEntity)pSDEOPPriv);
                this.removepsdeoppriv = pSDEOPPriv;
            }
            return this.removepsdeoppriv;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDER getPSDER() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDER();
        }
        if (this.getPSDERId() == null) {
            return null;
        }
        Integer n = this.objPSDERLock;
        synchronized (n) {
            if (this.psder != null && DataTypeHelper.compare((int)25, (Object)this.getPSDERId(), (Object)this.psder.getPSDERId()) != 0L) {
                this.psder = null;
            }
            if (this.psder == null) {
                PSDER pSDER = new PSDER();
                pSDER.setPSDERId(this.getPSDERId());
                PSDERService pSDERService = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
                pSDERService.autoGet((IEntity)pSDER);
                this.psder = pSDER;
            }
            return this.psder;
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
    public PSDEUAGroup getGroupPSDEUAGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupPSDEUAGroup();
        }
        if (this.getGroupPSDEUAGroupId() == null) {
            return null;
        }
        Integer n = this.objGroupPSDEUAGroupLock;
        synchronized (n) {
            if (this.grouppsdeuagroup != null && DataTypeHelper.compare((int)25, (Object)this.getGroupPSDEUAGroupId(), (Object)this.grouppsdeuagroup.getPSDEUAGroupId()) != 0L) {
                this.grouppsdeuagroup = null;
            }
            if (this.grouppsdeuagroup == null) {
                PSDEUAGroup pSDEUAGroup = new PSDEUAGroup();
                pSDEUAGroup.setPSDEUAGroupId(this.getGroupPSDEUAGroupId());
                PSDEUAGroupService pSDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEUAGroupService.autoGet((IEntity)pSDEUAGroup);
                this.grouppsdeuagroup = pSDEUAGroup;
            }
            return this.grouppsdeuagroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getPSDEViewBase() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBase();
        }
        if (this.getPSDEViewBaseId() == null) {
            return null;
        }
        Integer n = this.objPSDEViewBaseLock;
        synchronized (n) {
            if (this.psdeviewbase != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEViewBaseId(), (Object)this.psdeviewbase.getPSDEViewBaseId()) != 0L) {
                this.psdeviewbase = null;
            }
            if (this.psdeviewbase == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getPSDEViewBaseId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet((IEntity)pSDEViewBase);
                this.psdeviewbase = pSDEViewBase;
            }
            return this.psdeviewbase;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getNamePSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNamePSLanRes();
        }
        if (this.getNamePSLanResId() == null) {
            return null;
        }
        Integer n = this.objNamePSLanResLock;
        synchronized (n) {
            if (this.namepslanres != null && DataTypeHelper.compare((int)25, (Object)this.getNamePSLanResId(), (Object)this.namepslanres.getPSLanguageResId()) != 0L) {
                this.namepslanres = null;
            }
            if (this.namepslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getNamePSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.namepslanres = pSLanguageRes;
            }
            return this.namepslanres;
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
    public PSSysCss getShapePSSysCss() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getShapePSSysCss();
        }
        if (this.getShapePSSysCssId() == null) {
            return null;
        }
        Integer n = this.objShapePSSysCssLock;
        synchronized (n) {
            if (this.shapepssyscss != null && DataTypeHelper.compare((int)25, (Object)this.getShapePSSysCssId(), (Object)this.shapepssyscss.getPSSysCssId()) != 0L) {
                this.shapepssyscss = null;
            }
            if (this.shapepssyscss == null) {
                PSSysCss pSSysCss = new PSSysCss();
                pSSysCss.setPSSysCssId(this.getShapePSSysCssId());
                PSSysCssService pSSysCssService = (PSSysCssService)ServiceGlobal.getService(PSSysCssService.class, (SessionFactory)this.getSessionFactory());
                pSSysCssService.autoGet((IEntity)pSSysCss);
                this.shapepssyscss = pSSysCss;
            }
            return this.shapepssyscss;
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
    public PSSysMapView getPSSysMapView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMapView();
        }
        if (this.getPSSysMapViewId() == null) {
            return null;
        }
        Integer n = this.objPSSysMapViewLock;
        synchronized (n) {
            if (this.pssysmapview != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysMapViewId(), (Object)this.pssysmapview.getPSSysMapViewId()) != 0L) {
                this.pssysmapview = null;
            }
            if (this.pssysmapview == null) {
                PSSysMapView pSSysMapView = new PSSysMapView();
                pSSysMapView.setPSSysMapViewId(this.getPSSysMapViewId());
                PSSysMapViewService pSSysMapViewService = (PSSysMapViewService)ServiceGlobal.getService(PSSysMapViewService.class, (SessionFactory)this.getSessionFactory());
                pSSysMapViewService.autoGet((IEntity)pSSysMapView);
                this.pssysmapview = pSSysMapView;
            }
            return this.pssysmapview;
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

    private PSSysMapItemBase getProxyEntity() {
        return this.proxyPSSysMapItemBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysMapItemBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysMapItemBase) {
            this.proxyPSSysMapItemBase = (PSSysMapItemBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysMapItemService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALTPSDEFID, 0);
        fieldIndexMap.put(FIELD_ALTPSDEFNAME, 1);
        fieldIndexMap.put(FIELD_ASYNCPSDEDSID, 2);
        fieldIndexMap.put(FIELD_ASYNCPSDEDSNAME, 3);
        fieldIndexMap.put(FIELD_BKCOLOR, 4);
        fieldIndexMap.put(FIELD_BKCOLORPSDEFID, 5);
        fieldIndexMap.put(FIELD_BKCOLORPSDEFNAME, 6);
        fieldIndexMap.put(FIELD_BORDERCOLOR, 7);
        fieldIndexMap.put(FIELD_BORDERWIDTH, 8);
        fieldIndexMap.put(FIELD_CLSPSDEFID, 9);
        fieldIndexMap.put(FIELD_CLSPSDEFNAME, 10);
        fieldIndexMap.put(FIELD_COLOR, 11);
        fieldIndexMap.put(FIELD_COLORPSDEFID, 12);
        fieldIndexMap.put(FIELD_COLORPSDEFNAME, 13);
        fieldIndexMap.put(FIELD_CONTENTPSDEFID, 14);
        fieldIndexMap.put(FIELD_CONTENTPSDEFNAME, 15);
        fieldIndexMap.put(FIELD_CREATEDATE, 16);
        fieldIndexMap.put(FIELD_CREATEMAN, 17);
        fieldIndexMap.put(FIELD_CUSTOMCOND, 18);
        fieldIndexMap.put(FIELD_CUSTOMTYPE, 19);
        fieldIndexMap.put(FIELD_DATA2PSDEFID, 20);
        fieldIndexMap.put(FIELD_DATA2PSDEFNAME, 21);
        fieldIndexMap.put(FIELD_DATAPSDEFID, 22);
        fieldIndexMap.put(FIELD_DATAPSDEFNAME, 23);
        fieldIndexMap.put(FIELD_DYNACLASS, 24);
        fieldIndexMap.put(FIELD_GROUPPSDEFID, 25);
        fieldIndexMap.put(FIELD_GROUPPSDEFNAME, 26);
        fieldIndexMap.put(FIELD_GROUPPSDEUAGROUPID, 27);
        fieldIndexMap.put(FIELD_GROUPPSDEUAGROUPNAME, 28);
        fieldIndexMap.put(FIELD_ICONPSDEFID, 29);
        fieldIndexMap.put(FIELD_ICONPSDEFNAME, 30);
        fieldIndexMap.put(FIELD_ITEMSTYLE, 31);
        fieldIndexMap.put(FIELD_ITEMSTYLETEXT, 32);
        fieldIndexMap.put(FIELD_ITEMTYPE, 33);
        fieldIndexMap.put(FIELD_KEYPSDEFID, 34);
        fieldIndexMap.put(FIELD_KEYPSDEFNAME, 35);
        fieldIndexMap.put(FIELD_LATPSDEFID, 36);
        fieldIndexMap.put(FIELD_LATPSDEFNAME, 37);
        fieldIndexMap.put(FIELD_LINKPSDEFID, 38);
        fieldIndexMap.put(FIELD_LINKPSDEFNAME, 39);
        fieldIndexMap.put(FIELD_LONGPSDEFID, 40);
        fieldIndexMap.put(FIELD_LONGPSDEFNAME, 41);
        fieldIndexMap.put(FIELD_MAXSIZE, 42);
        fieldIndexMap.put(FIELD_MEMO, 43);
        fieldIndexMap.put(FIELD_MODELOBJ, 44);
        fieldIndexMap.put(FIELD_MOVEPSDEACTIONID, 45);
        fieldIndexMap.put(FIELD_MOVEPSDEACTIONNAME, 46);
        fieldIndexMap.put(FIELD_MOVEPSDEOPPRIVID, 47);
        fieldIndexMap.put(FIELD_MOVEPSDEOPPRIVNAME, 48);
        fieldIndexMap.put(FIELD_NAMEPSLANRESID, 49);
        fieldIndexMap.put(FIELD_NAMEPSLANRESNAME, 50);
        fieldIndexMap.put(FIELD_NAVVIEWFILTER, 51);
        fieldIndexMap.put(FIELD_NAVVIEWPARAM, 52);
        fieldIndexMap.put(FIELD_ORDERVALUE, 53);
        fieldIndexMap.put(FIELD_ORDERVALUEPSDEFID, 54);
        fieldIndexMap.put(FIELD_ORDERVALUEPSDEFNAME, 55);
        fieldIndexMap.put(FIELD_PSDEDSID, 56);
        fieldIndexMap.put(FIELD_PSDEDSNAME, 57);
        fieldIndexMap.put(FIELD_PSDEID, 58);
        fieldIndexMap.put(FIELD_PSDELOGICID, 59);
        fieldIndexMap.put(FIELD_PSDELOGICNAME, 60);
        fieldIndexMap.put(FIELD_PSDENAME, 61);
        fieldIndexMap.put(FIELD_PSDERID, 62);
        fieldIndexMap.put(FIELD_PSDERNAME, 63);
        fieldIndexMap.put(FIELD_PSDETOOLBARID, 64);
        fieldIndexMap.put(FIELD_PSDETOOLBARNAME, 65);
        fieldIndexMap.put(FIELD_PSDEVIEWBASEID, 66);
        fieldIndexMap.put(FIELD_PSDEVIEWBASENAME, 67);
        fieldIndexMap.put(FIELD_PSSYSCSSID, 68);
        fieldIndexMap.put(FIELD_PSSYSCSSNAME, 69);
        fieldIndexMap.put(FIELD_PSSYSIMAGEID, 70);
        fieldIndexMap.put(FIELD_PSSYSIMAGENAME, 71);
        fieldIndexMap.put(FIELD_PSSYSMAPITEMID, 72);
        fieldIndexMap.put(FIELD_PSSYSMAPITEMNAME, 73);
        fieldIndexMap.put(FIELD_PSSYSMAPVIEWID, 74);
        fieldIndexMap.put(FIELD_PSSYSMAPVIEWNAME, 75);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 76);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 77);
        fieldIndexMap.put(FIELD_RADIUS, 78);
        fieldIndexMap.put(FIELD_REMOVEPSDEACTIONID, 79);
        fieldIndexMap.put(FIELD_REMOVEPSDEACTIONNAME, 80);
        fieldIndexMap.put(FIELD_REMOVEPSDEOPPRIVID, 81);
        fieldIndexMap.put(FIELD_REMOVEPSDEOPPRIVNAME, 82);
        fieldIndexMap.put(FIELD_SHAPECLSPSDEFID, 83);
        fieldIndexMap.put(FIELD_SHAPECLSPSDEFNAME, 84);
        fieldIndexMap.put(FIELD_SHAPEDYNACLASS, 85);
        fieldIndexMap.put(FIELD_SHAPEPSSYSCSSID, 86);
        fieldIndexMap.put(FIELD_SHAPEPSSYSCSSNAME, 87);
        fieldIndexMap.put(FIELD_TAG2PSDEFID, 88);
        fieldIndexMap.put(FIELD_TAG2PSDEFNAME, 89);
        fieldIndexMap.put(FIELD_TAGPSDEFID, 90);
        fieldIndexMap.put(FIELD_TAGPSDEFNAME, 91);
        fieldIndexMap.put(FIELD_TEXTPSDEFID, 92);
        fieldIndexMap.put(FIELD_TEXTPSDEFNAME, 93);
        fieldIndexMap.put(FIELD_TIMEPSDEFID, 94);
        fieldIndexMap.put(FIELD_TIMEPSDEFNAME, 95);
        fieldIndexMap.put(FIELD_TIPSPSDEFID, 96);
        fieldIndexMap.put(FIELD_TIPSPSDEFNAME, 97);
        fieldIndexMap.put(FIELD_UPDATEDATE, 98);
        fieldIndexMap.put(FIELD_UPDATEMAN, 99);
        fieldIndexMap.put(FIELD_USERCAT, 100);
        fieldIndexMap.put(FIELD_USERTAG, 101);
        fieldIndexMap.put(FIELD_USERTAG2, 102);
        fieldIndexMap.put(FIELD_USERTAG3, 103);
        fieldIndexMap.put(FIELD_USERTAG4, 104);
        fieldIndexMap.put(FIELD_VALIDFLAG, 105);
    }
}

