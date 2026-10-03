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
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbar;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCalendar;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCalendarItemRV;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarItemRVService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysCalendarItemBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysCalendarItemBase.class);
    public static final String FIELD_ASYNCPSDEDSID = "ASYNCPSDEDSID";
    public static final String FIELD_ASYNCPSDEDSNAME = "ASYNCPSDEDSNAME";
    public static final String FIELD_BEGINPSDEFID = "BEGINPSDEFID";
    public static final String FIELD_BEGINPSDEFNAME = "BEGINPSDEFNAME";
    public static final String FIELD_BKCOLOR = "BKCOLOR";
    public static final String FIELD_BKCOLORPSDEFID = "BKCOLORPSDEFID";
    public static final String FIELD_BKCOLORPSDEFNAME = "BKCOLORPSDEFNAME";
    public static final String FIELD_CLSPSDEFID = "CLSPSDEFID";
    public static final String FIELD_CLSPSDEFNAME = "CLSPSDEFNAME";
    public static final String FIELD_COLOR = "COLOR";
    public static final String FIELD_COLORPSDEFID = "COLORPSDEFID";
    public static final String FIELD_COLORPSDEFNAME = "COLORPSDEFNAME";
    public static final String FIELD_CONTENTPSDEFID = "CONTENTPSDEFID";
    public static final String FIELD_CONTENTPSDEFNAME = "CONTENTPSDEFNAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CREATEPSDEACTIONID = "CREATEPSDEACTIONID";
    public static final String FIELD_CREATEPSDEACTIONNAME = "CREATEPSDEACTIONNAME";
    public static final String FIELD_CREATEPSDEOPPRIVID = "CREATEPSDEOPPRIVID";
    public static final String FIELD_CREATEPSDEOPPRIVNAME = "CREATEPSDEOPPRIVNAME";
    public static final String FIELD_CUSTOMCOND = "CUSTOMCOND";
    public static final String FIELD_CUSTOMTYPE = "CUSTOMTYPE";
    public static final String FIELD_DATA2PSDEFID = "DATA2PSDEFID";
    public static final String FIELD_DATA2PSDEFNAME = "DATA2PSDEFNAME";
    public static final String FIELD_DATAPSDEFID = "DATAPSDEFID";
    public static final String FIELD_DATAPSDEFNAME = "DATAPSDEFNAME";
    public static final String FIELD_DYNACLASS = "DYNACLASS";
    public static final String FIELD_EDITMODE = "EDITMODE";
    public static final String FIELD_ENABLEVIEWACTIONS = "ENABLEVIEWACTIONS";
    public static final String FIELD_ENDPSDEFID = "ENDPSDEFID";
    public static final String FIELD_ENDPSDEFNAME = "ENDPSDEFNAME";
    public static final String FIELD_FINISHPSDEFID = "FINISHPSDEFID";
    public static final String FIELD_FINISHPSDEFNAME = "FINISHPSDEFNAME";
    public static final String FIELD_GANTTPSSYSPFPLUGINID = "GANTTPSSYSPFPLUGINID";
    public static final String FIELD_GANTTPSSYSPFPLUGINNAME = "GANTTPSSYSPFPLUGINNAME";
    public static final String FIELD_ICONPSDEFID = "ICONPSDEFID";
    public static final String FIELD_ICONPSDEFNAME = "ICONPSDEFNAME";
    public static final String FIELD_ITEMSTYLE = "ITEMSTYLE";
    public static final String FIELD_ITEMSTYLETEXT = "ITEMSTYLETEXT";
    public static final String FIELD_ITEMTYPE = "ITEMTYPE";
    public static final String FIELD_KEYPSDEFID = "KEYPSDEFID";
    public static final String FIELD_KEYPSDEFNAME = "KEYPSDEFNAME";
    public static final String FIELD_LEVELPSDEFID = "LEVELPSDEFID";
    public static final String FIELD_LEVELPSDEFNAME = "LEVELPSDEFNAME";
    public static final String FIELD_LINKPSDEFID = "LINKPSDEFID";
    public static final String FIELD_LINKPSDEFNAME = "LINKPSDEFNAME";
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
    public static final String FIELD_PKEYPSDEFID = "PKEYPSDEFID";
    public static final String FIELD_PKEYPSDEFNAME = "PKEYPSDEFNAME";
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
    public static final String FIELD_PSSYSCALENDARID = "PSSYSCALENDARID";
    public static final String FIELD_PSSYSCALENDARITEMID = "PSSYSCALENDARITEMID";
    public static final String FIELD_PSSYSCALENDARITEMNAME = "PSSYSCALENDARITEMNAME";
    public static final String FIELD_PSSYSCALENDARNAME = "PSSYSCALENDARNAME";
    public static final String FIELD_PSSYSCSSID = "PSSYSCSSID";
    public static final String FIELD_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String FIELD_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String FIELD_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String FIELD_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String FIELD_REMOVEPSDEACTIONID = "REMOVEPSDEACTIONID";
    public static final String FIELD_REMOVEPSDEACTIONNAME = "REMOVEPSDEACTIONNAME";
    public static final String FIELD_REMOVEPSDEOPPRIVID = "REMOVEPSDEOPPRIVID";
    public static final String FIELD_REMOVEPSDEOPPRIVNAME = "REMOVEPSDEOPPRIVNAME";
    public static final String FIELD_TAG2PSDEFID = "TAG2PSDEFID";
    public static final String FIELD_TAG2PSDEFNAME = "TAG2PSDEFNAME";
    public static final String FIELD_TAGPSDEFID = "TAGPSDEFID";
    public static final String FIELD_TAGPSDEFNAME = "TAGPSDEFNAME";
    public static final String FIELD_TEXTPSDEFID = "TEXTPSDEFID";
    public static final String FIELD_TEXTPSDEFNAME = "TEXTPSDEFNAME";
    public static final String FIELD_TIPSPSDEFID = "TIPSPSDEFID";
    public static final String FIELD_TIPSPSDEFNAME = "TIPSPSDEFNAME";
    public static final String FIELD_TOTALPSDEFID = "TOTALPSDEFID";
    public static final String FIELD_TOTALPSDEFNAME = "TOTALPSDEFNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_UPDATEPSDEACTIONID = "UPDATEPSDEACTIONID";
    public static final String FIELD_UPDATEPSDEACTIONNAME = "UPDATEPSDEACTIONNAME";
    public static final String FIELD_UPDATEPSDEOPPRIVID = "UPDATEPSDEOPPRIVID";
    public static final String FIELD_UPDATEPSDEOPPRIVNAME = "UPDATEPSDEOPPRIVNAME";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VIEWACTIONS = "VIEWACTIONS";
    private static final int INDEX_ASYNCPSDEDSID = 0;
    private static final int INDEX_ASYNCPSDEDSNAME = 1;
    private static final int INDEX_BEGINPSDEFID = 2;
    private static final int INDEX_BEGINPSDEFNAME = 3;
    private static final int INDEX_BKCOLOR = 4;
    private static final int INDEX_BKCOLORPSDEFID = 5;
    private static final int INDEX_BKCOLORPSDEFNAME = 6;
    private static final int INDEX_CLSPSDEFID = 7;
    private static final int INDEX_CLSPSDEFNAME = 8;
    private static final int INDEX_COLOR = 9;
    private static final int INDEX_COLORPSDEFID = 10;
    private static final int INDEX_COLORPSDEFNAME = 11;
    private static final int INDEX_CONTENTPSDEFID = 12;
    private static final int INDEX_CONTENTPSDEFNAME = 13;
    private static final int INDEX_CREATEDATE = 14;
    private static final int INDEX_CREATEMAN = 15;
    private static final int INDEX_CREATEPSDEACTIONID = 16;
    private static final int INDEX_CREATEPSDEACTIONNAME = 17;
    private static final int INDEX_CREATEPSDEOPPRIVID = 18;
    private static final int INDEX_CREATEPSDEOPPRIVNAME = 19;
    private static final int INDEX_CUSTOMCOND = 20;
    private static final int INDEX_CUSTOMTYPE = 21;
    private static final int INDEX_DATA2PSDEFID = 22;
    private static final int INDEX_DATA2PSDEFNAME = 23;
    private static final int INDEX_DATAPSDEFID = 24;
    private static final int INDEX_DATAPSDEFNAME = 25;
    private static final int INDEX_DYNACLASS = 26;
    private static final int INDEX_EDITMODE = 27;
    private static final int INDEX_ENABLEVIEWACTIONS = 28;
    private static final int INDEX_ENDPSDEFID = 29;
    private static final int INDEX_ENDPSDEFNAME = 30;
    private static final int INDEX_FINISHPSDEFID = 31;
    private static final int INDEX_FINISHPSDEFNAME = 32;
    private static final int INDEX_GANTTPSSYSPFPLUGINID = 33;
    private static final int INDEX_GANTTPSSYSPFPLUGINNAME = 34;
    private static final int INDEX_ICONPSDEFID = 35;
    private static final int INDEX_ICONPSDEFNAME = 36;
    private static final int INDEX_ITEMSTYLE = 37;
    private static final int INDEX_ITEMSTYLETEXT = 38;
    private static final int INDEX_ITEMTYPE = 39;
    private static final int INDEX_KEYPSDEFID = 40;
    private static final int INDEX_KEYPSDEFNAME = 41;
    private static final int INDEX_LEVELPSDEFID = 42;
    private static final int INDEX_LEVELPSDEFNAME = 43;
    private static final int INDEX_LINKPSDEFID = 44;
    private static final int INDEX_LINKPSDEFNAME = 45;
    private static final int INDEX_MAXSIZE = 46;
    private static final int INDEX_MEMO = 47;
    private static final int INDEX_MODELOBJ = 48;
    private static final int INDEX_MOVEPSDEACTIONID = 49;
    private static final int INDEX_MOVEPSDEACTIONNAME = 50;
    private static final int INDEX_MOVEPSDEOPPRIVID = 51;
    private static final int INDEX_MOVEPSDEOPPRIVNAME = 52;
    private static final int INDEX_NAMEPSLANRESID = 53;
    private static final int INDEX_NAMEPSLANRESNAME = 54;
    private static final int INDEX_NAVVIEWFILTER = 55;
    private static final int INDEX_NAVVIEWPARAM = 56;
    private static final int INDEX_ORDERVALUE = 57;
    private static final int INDEX_ORDERVALUEPSDEFID = 58;
    private static final int INDEX_ORDERVALUEPSDEFNAME = 59;
    private static final int INDEX_PKEYPSDEFID = 60;
    private static final int INDEX_PKEYPSDEFNAME = 61;
    private static final int INDEX_PSDEDSID = 62;
    private static final int INDEX_PSDEDSNAME = 63;
    private static final int INDEX_PSDEID = 64;
    private static final int INDEX_PSDELOGICID = 65;
    private static final int INDEX_PSDELOGICNAME = 66;
    private static final int INDEX_PSDENAME = 67;
    private static final int INDEX_PSDERID = 68;
    private static final int INDEX_PSDERNAME = 69;
    private static final int INDEX_PSDETOOLBARID = 70;
    private static final int INDEX_PSDETOOLBARNAME = 71;
    private static final int INDEX_PSDEVIEWBASEID = 72;
    private static final int INDEX_PSDEVIEWBASENAME = 73;
    private static final int INDEX_PSSYSCALENDARID = 74;
    private static final int INDEX_PSSYSCALENDARITEMID = 75;
    private static final int INDEX_PSSYSCALENDARITEMNAME = 76;
    private static final int INDEX_PSSYSCALENDARNAME = 77;
    private static final int INDEX_PSSYSCSSID = 78;
    private static final int INDEX_PSSYSCSSNAME = 79;
    private static final int INDEX_PSSYSIMAGEID = 80;
    private static final int INDEX_PSSYSIMAGENAME = 81;
    private static final int INDEX_PSSYSPFPLUGINID = 82;
    private static final int INDEX_PSSYSPFPLUGINNAME = 83;
    private static final int INDEX_PSSYSVIEWPANELID = 84;
    private static final int INDEX_PSSYSVIEWPANELNAME = 85;
    private static final int INDEX_REMOVEPSDEACTIONID = 86;
    private static final int INDEX_REMOVEPSDEACTIONNAME = 87;
    private static final int INDEX_REMOVEPSDEOPPRIVID = 88;
    private static final int INDEX_REMOVEPSDEOPPRIVNAME = 89;
    private static final int INDEX_TAG2PSDEFID = 90;
    private static final int INDEX_TAG2PSDEFNAME = 91;
    private static final int INDEX_TAGPSDEFID = 92;
    private static final int INDEX_TAGPSDEFNAME = 93;
    private static final int INDEX_TEXTPSDEFID = 94;
    private static final int INDEX_TEXTPSDEFNAME = 95;
    private static final int INDEX_TIPSPSDEFID = 96;
    private static final int INDEX_TIPSPSDEFNAME = 97;
    private static final int INDEX_TOTALPSDEFID = 98;
    private static final int INDEX_TOTALPSDEFNAME = 99;
    private static final int INDEX_UPDATEDATE = 100;
    private static final int INDEX_UPDATEMAN = 101;
    private static final int INDEX_UPDATEPSDEACTIONID = 102;
    private static final int INDEX_UPDATEPSDEACTIONNAME = 103;
    private static final int INDEX_UPDATEPSDEOPPRIVID = 104;
    private static final int INDEX_UPDATEPSDEOPPRIVNAME = 105;
    private static final int INDEX_USERCAT = 106;
    private static final int INDEX_USERTAG = 107;
    private static final int INDEX_USERTAG2 = 108;
    private static final int INDEX_USERTAG3 = 109;
    private static final int INDEX_USERTAG4 = 110;
    private static final int INDEX_VALIDFLAG = 111;
    private static final int INDEX_VIEWACTIONS = 112;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysCalendarItemBase proxyPSSysCalendarItemBase = null;
    private boolean asyncpsdedsidDirtyFlag = false;
    private boolean asyncpsdedsnameDirtyFlag = false;
    private boolean beginpsdefidDirtyFlag = false;
    private boolean beginpsdefnameDirtyFlag = false;
    private boolean bkcolorDirtyFlag = false;
    private boolean bkcolorpsdefidDirtyFlag = false;
    private boolean bkcolorpsdefnameDirtyFlag = false;
    private boolean clspsdefidDirtyFlag = false;
    private boolean clspsdefnameDirtyFlag = false;
    private boolean colorDirtyFlag = false;
    private boolean colorpsdefidDirtyFlag = false;
    private boolean colorpsdefnameDirtyFlag = false;
    private boolean contentpsdefidDirtyFlag = false;
    private boolean contentpsdefnameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean createpsdeactionidDirtyFlag = false;
    private boolean createpsdeactionnameDirtyFlag = false;
    private boolean createpsdeopprividDirtyFlag = false;
    private boolean createpsdeopprivnameDirtyFlag = false;
    private boolean customcondDirtyFlag = false;
    private boolean customtypeDirtyFlag = false;
    private boolean data2psdefidDirtyFlag = false;
    private boolean data2psdefnameDirtyFlag = false;
    private boolean datapsdefidDirtyFlag = false;
    private boolean datapsdefnameDirtyFlag = false;
    private boolean dynaclassDirtyFlag = false;
    private boolean editmodeDirtyFlag = false;
    private boolean enableviewactionsDirtyFlag = false;
    private boolean endpsdefidDirtyFlag = false;
    private boolean endpsdefnameDirtyFlag = false;
    private boolean finishpsdefidDirtyFlag = false;
    private boolean finishpsdefnameDirtyFlag = false;
    private boolean ganttpssyspfpluginidDirtyFlag = false;
    private boolean ganttpssyspfpluginnameDirtyFlag = false;
    private boolean iconpsdefidDirtyFlag = false;
    private boolean iconpsdefnameDirtyFlag = false;
    private boolean itemstyleDirtyFlag = false;
    private boolean itemstyletextDirtyFlag = false;
    private boolean itemtypeDirtyFlag = false;
    private boolean keypsdefidDirtyFlag = false;
    private boolean keypsdefnameDirtyFlag = false;
    private boolean levelpsdefidDirtyFlag = false;
    private boolean levelpsdefnameDirtyFlag = false;
    private boolean linkpsdefidDirtyFlag = false;
    private boolean linkpsdefnameDirtyFlag = false;
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
    private boolean pkeypsdefidDirtyFlag = false;
    private boolean pkeypsdefnameDirtyFlag = false;
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
    private boolean pssyscalendaridDirtyFlag = false;
    private boolean pssyscalendaritemidDirtyFlag = false;
    private boolean pssyscalendaritemnameDirtyFlag = false;
    private boolean pssyscalendarnameDirtyFlag = false;
    private boolean pssyscssidDirtyFlag = false;
    private boolean pssyscssnameDirtyFlag = false;
    private boolean pssysimageidDirtyFlag = false;
    private boolean pssysimagenameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssysviewpanelidDirtyFlag = false;
    private boolean pssysviewpanelnameDirtyFlag = false;
    private boolean removepsdeactionidDirtyFlag = false;
    private boolean removepsdeactionnameDirtyFlag = false;
    private boolean removepsdeopprividDirtyFlag = false;
    private boolean removepsdeopprivnameDirtyFlag = false;
    private boolean tag2psdefidDirtyFlag = false;
    private boolean tag2psdefnameDirtyFlag = false;
    private boolean tagpsdefidDirtyFlag = false;
    private boolean tagpsdefnameDirtyFlag = false;
    private boolean textpsdefidDirtyFlag = false;
    private boolean textpsdefnameDirtyFlag = false;
    private boolean tipspsdefidDirtyFlag = false;
    private boolean tipspsdefnameDirtyFlag = false;
    private boolean totalpsdefidDirtyFlag = false;
    private boolean totalpsdefnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean updatepsdeactionidDirtyFlag = false;
    private boolean updatepsdeactionnameDirtyFlag = false;
    private boolean updatepsdeopprividDirtyFlag = false;
    private boolean updatepsdeopprivnameDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean viewactionsDirtyFlag = false;
    @Column(name="asyncpsdedsid")
    private String asyncpsdedsid;
    @Column(name="asyncpsdedsname")
    private String asyncpsdedsname;
    @Column(name="beginpsdefid")
    private String beginpsdefid;
    @Column(name="beginpsdefname")
    private String beginpsdefname;
    @Column(name="bkcolor")
    private String bkcolor;
    @Column(name="bkcolorpsdefid")
    private String bkcolorpsdefid;
    @Column(name="bkcolorpsdefname")
    private String bkcolorpsdefname;
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
    @Column(name="createpsdeactionid")
    private String createpsdeactionid;
    @Column(name="createpsdeactionname")
    private String createpsdeactionname;
    @Column(name="createpsdeopprivid")
    private String createpsdeopprivid;
    @Column(name="createpsdeopprivname")
    private String createpsdeopprivname;
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
    @Column(name="editmode")
    private Integer editmode;
    @Column(name="enableviewactions")
    private Integer enableviewactions;
    @Column(name="endpsdefid")
    private String endpsdefid;
    @Column(name="endpsdefname")
    private String endpsdefname;
    @Column(name="finishpsdefid")
    private String finishpsdefid;
    @Column(name="finishpsdefname")
    private String finishpsdefname;
    @Column(name="ganttpssyspfpluginid")
    private String ganttpssyspfpluginid;
    @Column(name="ganttpssyspfpluginname")
    private String ganttpssyspfpluginname;
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
    @Column(name="levelpsdefid")
    private String levelpsdefid;
    @Column(name="levelpsdefname")
    private String levelpsdefname;
    @Column(name="linkpsdefid")
    private String linkpsdefid;
    @Column(name="linkpsdefname")
    private String linkpsdefname;
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
    @Column(name="pkeypsdefid")
    private String pkeypsdefid;
    @Column(name="pkeypsdefname")
    private String pkeypsdefname;
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
    @Column(name="pssyscalendarid")
    private String pssyscalendarid;
    @Column(name="pssyscalendaritemid")
    private String pssyscalendaritemid;
    @Column(name="pssyscalendaritemname")
    private String pssyscalendaritemname;
    @Column(name="pssyscalendarname")
    private String pssyscalendarname;
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
    @Column(name="pssysviewpanelid")
    private String pssysviewpanelid;
    @Column(name="pssysviewpanelname")
    private String pssysviewpanelname;
    @Column(name="removepsdeactionid")
    private String removepsdeactionid;
    @Column(name="removepsdeactionname")
    private String removepsdeactionname;
    @Column(name="removepsdeopprivid")
    private String removepsdeopprivid;
    @Column(name="removepsdeopprivname")
    private String removepsdeopprivname;
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
    @Column(name="tipspsdefid")
    private String tipspsdefid;
    @Column(name="tipspsdefname")
    private String tipspsdefname;
    @Column(name="totalpsdefid")
    private String totalpsdefid;
    @Column(name="totalpsdefname")
    private String totalpsdefname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="updatepsdeactionid")
    private String updatepsdeactionid;
    @Column(name="updatepsdeactionname")
    private String updatepsdeactionname;
    @Column(name="updatepsdeopprivid")
    private String updatepsdeopprivid;
    @Column(name="updatepsdeopprivname")
    private String updatepsdeopprivname;
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
    @Column(name="viewactions")
    private Integer viewactions;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objCreatePSDEActionLock = new Integer(1);
    private PSDEAction createpsdeaction = null;
    private Integer objMovePSDEActionLock = new Integer(1);
    private PSDEAction movepsdeaction = null;
    private Integer objRemovePSDEActionLock = new Integer(1);
    private PSDEAction removepsdeaction = null;
    private Integer objUpdatePSDEActionLock = new Integer(1);
    private PSDEAction updatepsdeaction = null;
    private Integer objAsyncPSDEDSLock = new Integer(1);
    private PSDEDataSet asyncpsdeds = null;
    private Integer objPSDEDSLock = new Integer(1);
    private PSDEDataSet psdeds = null;
    private Integer objBeginPSDEFLock = new Integer(1);
    private PSDEField beginpsdef = null;
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
    private Integer objEndPSDEFLock = new Integer(1);
    private PSDEField endpsdef = null;
    private Integer objFinishPSDEFLock = new Integer(1);
    private PSDEField finishpsdef = null;
    private Integer objIconPSDEFLock = new Integer(1);
    private PSDEField iconpsdef = null;
    private Integer objKeyPSDEFLock = new Integer(1);
    private PSDEField keypsdef = null;
    private Integer objLevelPSDEFLock = new Integer(1);
    private PSDEField levelpsdef = null;
    private Integer objLinkPSDEFLock = new Integer(1);
    private PSDEField linkpsdef = null;
    private Integer objOrderValuePSDEFLock = new Integer(1);
    private PSDEField ordervaluepsdef = null;
    private Integer objPKeyPSDEFLock = new Integer(1);
    private PSDEField pkeypsdef = null;
    private Integer objTag2PSDEFLock = new Integer(1);
    private PSDEField tag2psdef = null;
    private Integer objTagPSDEFLock = new Integer(1);
    private PSDEField tagpsdef = null;
    private Integer objTextPSDEFLock = new Integer(1);
    private PSDEField textpsdef = null;
    private Integer objTipsPSDEFLock = new Integer(1);
    private PSDEField tipspsdef = null;
    private Integer objTotalPSDEFLock = new Integer(1);
    private PSDEField totalpsdef = null;
    private Integer objPSDELogicLock = new Integer(1);
    private PSDELogic psdelogic = null;
    private Integer objCreatePSDEOPPrivLock = new Integer(1);
    private PSDEOPPriv createpsdeoppriv = null;
    private Integer objMovePSDEOPPrivLock = new Integer(1);
    private PSDEOPPriv movepsdeoppriv = null;
    private Integer objRemovePSDEOPPrivLock = new Integer(1);
    private PSDEOPPriv removepsdeoppriv = null;
    private Integer objUpdatePSDEOPPrivLock = new Integer(1);
    private PSDEOPPriv updatepsdeoppriv = null;
    private Integer objPSDERLock = new Integer(1);
    private PSDER psder = null;
    private Integer objPSDEToolbarLock = new Integer(1);
    private PSDEToolbar psdetoolbar = null;
    private Integer objPSDEViewBaseLock = new Integer(1);
    private PSDEViewBase psdeviewbase = null;
    private Integer objNamePSLanResLock = new Integer(1);
    private PSLanguageRes namepslanres = null;
    private Integer objPSSysCalendarLock = new Integer(1);
    private PSSysCalendar pssyscalendar = null;
    private Integer objPSSysCssLock = new Integer(1);
    private PSSysCss pssyscss = null;
    private Integer objPSSysImageLock = new Integer(1);
    private PSSysImage pssysimage = null;
    private Integer objGanttPSSysPFPluinLock = new Integer(1);
    private PSSysPFPlugin ganttpssyspfpluin = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSSysViewPanelLock = new Integer(1);
    private PSSysViewPanel pssysviewpanel = null;
    private Integer objPSSysCalendarItemRVsLock = new Integer(1);
    private ArrayList<PSSysCalendarItemRV> pssyscalendaritemrvs = null;

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

    public void setBeginPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBeginPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.beginpsdefid = string;
        this.beginpsdefidDirtyFlag = true;
    }

    public String getBeginPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeginPSDEFId();
        }
        return this.beginpsdefid;
    }

    public boolean isBeginPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBeginPSDEFIdDirty();
        }
        return this.beginpsdefidDirtyFlag;
    }

    public void resetBeginPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBeginPSDEFId();
            return;
        }
        this.beginpsdefidDirtyFlag = false;
        this.beginpsdefid = null;
    }

    public void setBeginPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBeginPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.beginpsdefname = string;
        this.beginpsdefnameDirtyFlag = true;
    }

    public String getBeginPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeginPSDEFName();
        }
        return this.beginpsdefname;
    }

    public boolean isBeginPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBeginPSDEFNameDirty();
        }
        return this.beginpsdefnameDirtyFlag;
    }

    public void resetBeginPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBeginPSDEFName();
            return;
        }
        this.beginpsdefnameDirtyFlag = false;
        this.beginpsdefname = null;
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

    public void setCreatePSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreatePSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createpsdeactionid = string;
        this.createpsdeactionidDirtyFlag = true;
    }

    public String getCreatePSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreatePSDEActionId();
        }
        return this.createpsdeactionid;
    }

    public boolean isCreatePSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreatePSDEActionIdDirty();
        }
        return this.createpsdeactionidDirtyFlag;
    }

    public void resetCreatePSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreatePSDEActionId();
            return;
        }
        this.createpsdeactionidDirtyFlag = false;
        this.createpsdeactionid = null;
    }

    public void setCreatePSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreatePSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createpsdeactionname = string;
        this.createpsdeactionnameDirtyFlag = true;
    }

    public String getCreatePSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreatePSDEActionName();
        }
        return this.createpsdeactionname;
    }

    public boolean isCreatePSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreatePSDEActionNameDirty();
        }
        return this.createpsdeactionnameDirtyFlag;
    }

    public void resetCreatePSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreatePSDEActionName();
            return;
        }
        this.createpsdeactionnameDirtyFlag = false;
        this.createpsdeactionname = null;
    }

    public void setCreatePSDEOPPrivId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreatePSDEOPPrivId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createpsdeopprivid = string;
        this.createpsdeopprividDirtyFlag = true;
    }

    public String getCreatePSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreatePSDEOPPrivId();
        }
        return this.createpsdeopprivid;
    }

    public boolean isCreatePSDEOPPrivIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreatePSDEOPPrivIdDirty();
        }
        return this.createpsdeopprividDirtyFlag;
    }

    public void resetCreatePSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreatePSDEOPPrivId();
            return;
        }
        this.createpsdeopprividDirtyFlag = false;
        this.createpsdeopprivid = null;
    }

    public void setCreatePSDEOPPrivName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreatePSDEOPPrivName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createpsdeopprivname = string;
        this.createpsdeopprivnameDirtyFlag = true;
    }

    public String getCreatePSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreatePSDEOPPrivName();
        }
        return this.createpsdeopprivname;
    }

    public boolean isCreatePSDEOPPrivNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreatePSDEOPPrivNameDirty();
        }
        return this.createpsdeopprivnameDirtyFlag;
    }

    public void resetCreatePSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreatePSDEOPPrivName();
            return;
        }
        this.createpsdeopprivnameDirtyFlag = false;
        this.createpsdeopprivname = null;
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

    public void setEditMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEditMode(n);
            return;
        }
        this.editmode = n;
        this.editmodeDirtyFlag = true;
    }

    public Integer getEditMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEditMode();
        }
        return this.editmode;
    }

    public boolean isEditModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEditModeDirty();
        }
        return this.editmodeDirtyFlag;
    }

    public void resetEditMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEditMode();
            return;
        }
        this.editmodeDirtyFlag = false;
        this.editmode = null;
    }

    public void setEnableViewActions(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableViewActions(n);
            return;
        }
        this.enableviewactions = n;
        this.enableviewactionsDirtyFlag = true;
    }

    public Integer getEnableViewActions() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableViewActions();
        }
        return this.enableviewactions;
    }

    public boolean isEnableViewActionsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableViewActionsDirty();
        }
        return this.enableviewactionsDirtyFlag;
    }

    public void resetEnableViewActions() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableViewActions();
            return;
        }
        this.enableviewactionsDirtyFlag = false;
        this.enableviewactions = null;
    }

    public void setEndPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEndPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.endpsdefid = string;
        this.endpsdefidDirtyFlag = true;
    }

    public String getEndPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEndPSDEFId();
        }
        return this.endpsdefid;
    }

    public boolean isEndPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEndPSDEFIdDirty();
        }
        return this.endpsdefidDirtyFlag;
    }

    public void resetEndPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEndPSDEFId();
            return;
        }
        this.endpsdefidDirtyFlag = false;
        this.endpsdefid = null;
    }

    public void setEndPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEndPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.endpsdefname = string;
        this.endpsdefnameDirtyFlag = true;
    }

    public String getEndPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEndPSDEFName();
        }
        return this.endpsdefname;
    }

    public boolean isEndPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEndPSDEFNameDirty();
        }
        return this.endpsdefnameDirtyFlag;
    }

    public void resetEndPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEndPSDEFName();
            return;
        }
        this.endpsdefnameDirtyFlag = false;
        this.endpsdefname = null;
    }

    public void setFinishPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFinishPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.finishpsdefid = string;
        this.finishpsdefidDirtyFlag = true;
    }

    public String getFinishPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFinishPSDEFId();
        }
        return this.finishpsdefid;
    }

    public boolean isFinishPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFinishPSDEFIdDirty();
        }
        return this.finishpsdefidDirtyFlag;
    }

    public void resetFinishPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFinishPSDEFId();
            return;
        }
        this.finishpsdefidDirtyFlag = false;
        this.finishpsdefid = null;
    }

    public void setFinishPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFinishPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.finishpsdefname = string;
        this.finishpsdefnameDirtyFlag = true;
    }

    public String getFinishPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFinishPSDEFName();
        }
        return this.finishpsdefname;
    }

    public boolean isFinishPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFinishPSDEFNameDirty();
        }
        return this.finishpsdefnameDirtyFlag;
    }

    public void resetFinishPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFinishPSDEFName();
            return;
        }
        this.finishpsdefnameDirtyFlag = false;
        this.finishpsdefname = null;
    }

    public void setGanttPSSysPFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGanttPSSysPFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ganttpssyspfpluginid = string;
        this.ganttpssyspfpluginidDirtyFlag = true;
    }

    public String getGanttPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGanttPSSysPFPluginId();
        }
        return this.ganttpssyspfpluginid;
    }

    public boolean isGanttPSSysPFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGanttPSSysPFPluginIdDirty();
        }
        return this.ganttpssyspfpluginidDirtyFlag;
    }

    public void resetGanttPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGanttPSSysPFPluginId();
            return;
        }
        this.ganttpssyspfpluginidDirtyFlag = false;
        this.ganttpssyspfpluginid = null;
    }

    public void setGanttPSSysPFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGanttPSSysPFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ganttpssyspfpluginname = string;
        this.ganttpssyspfpluginnameDirtyFlag = true;
    }

    public String getGanttPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGanttPSSysPFPluginName();
        }
        return this.ganttpssyspfpluginname;
    }

    public boolean isGanttPSSysPFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGanttPSSysPFPluginNameDirty();
        }
        return this.ganttpssyspfpluginnameDirtyFlag;
    }

    public void resetGanttPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGanttPSSysPFPluginName();
            return;
        }
        this.ganttpssyspfpluginnameDirtyFlag = false;
        this.ganttpssyspfpluginname = null;
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

    public void setLevelPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLevelPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.levelpsdefid = string;
        this.levelpsdefidDirtyFlag = true;
    }

    public String getLevelPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLevelPSDEFId();
        }
        return this.levelpsdefid;
    }

    public boolean isLevelPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLevelPSDEFIdDirty();
        }
        return this.levelpsdefidDirtyFlag;
    }

    public void resetLevelPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLevelPSDEFId();
            return;
        }
        this.levelpsdefidDirtyFlag = false;
        this.levelpsdefid = null;
    }

    public void setLevelPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLevelPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.levelpsdefname = string;
        this.levelpsdefnameDirtyFlag = true;
    }

    public String getLevelPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLevelPSDEFName();
        }
        return this.levelpsdefname;
    }

    public boolean isLevelPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLevelPSDEFNameDirty();
        }
        return this.levelpsdefnameDirtyFlag;
    }

    public void resetLevelPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLevelPSDEFName();
            return;
        }
        this.levelpsdefnameDirtyFlag = false;
        this.levelpsdefname = null;
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

    public void setPKeyPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPKeyPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pkeypsdefid = string;
        this.pkeypsdefidDirtyFlag = true;
    }

    public String getPKeyPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPKeyPSDEFId();
        }
        return this.pkeypsdefid;
    }

    public boolean isPKeyPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPKeyPSDEFIdDirty();
        }
        return this.pkeypsdefidDirtyFlag;
    }

    public void resetPKeyPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPKeyPSDEFId();
            return;
        }
        this.pkeypsdefidDirtyFlag = false;
        this.pkeypsdefid = null;
    }

    public void setPKeyPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPKeyPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pkeypsdefname = string;
        this.pkeypsdefnameDirtyFlag = true;
    }

    public String getPKeyPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPKeyPSDEFName();
        }
        return this.pkeypsdefname;
    }

    public boolean isPKeyPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPKeyPSDEFNameDirty();
        }
        return this.pkeypsdefnameDirtyFlag;
    }

    public void resetPKeyPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPKeyPSDEFName();
            return;
        }
        this.pkeypsdefnameDirtyFlag = false;
        this.pkeypsdefname = null;
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

    public void setPSSysCalendarId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCalendarId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscalendarid = string;
        this.pssyscalendaridDirtyFlag = true;
    }

    public String getPSSysCalendarId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCalendarId();
        }
        return this.pssyscalendarid;
    }

    public boolean isPSSysCalendarIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCalendarIdDirty();
        }
        return this.pssyscalendaridDirtyFlag;
    }

    public void resetPSSysCalendarId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCalendarId();
            return;
        }
        this.pssyscalendaridDirtyFlag = false;
        this.pssyscalendarid = null;
    }

    public void setPSSysCalendarItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCalendarItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscalendaritemid = string;
        this.pssyscalendaritemidDirtyFlag = true;
    }

    public String getPSSysCalendarItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCalendarItemId();
        }
        return this.pssyscalendaritemid;
    }

    public boolean isPSSysCalendarItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCalendarItemIdDirty();
        }
        return this.pssyscalendaritemidDirtyFlag;
    }

    public void resetPSSysCalendarItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCalendarItemId();
            return;
        }
        this.pssyscalendaritemidDirtyFlag = false;
        this.pssyscalendaritemid = null;
    }

    public void setPSSysCalendarItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCalendarItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscalendaritemname = string;
        this.pssyscalendaritemnameDirtyFlag = true;
    }

    public String getPSSysCalendarItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCalendarItemName();
        }
        return this.pssyscalendaritemname;
    }

    public boolean isPSSysCalendarItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCalendarItemNameDirty();
        }
        return this.pssyscalendaritemnameDirtyFlag;
    }

    public void resetPSSysCalendarItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCalendarItemName();
            return;
        }
        this.pssyscalendaritemnameDirtyFlag = false;
        this.pssyscalendaritemname = null;
    }

    public void setPSSysCalendarName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCalendarName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscalendarname = string;
        this.pssyscalendarnameDirtyFlag = true;
    }

    public String getPSSysCalendarName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCalendarName();
        }
        return this.pssyscalendarname;
    }

    public boolean isPSSysCalendarNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCalendarNameDirty();
        }
        return this.pssyscalendarnameDirtyFlag;
    }

    public void resetPSSysCalendarName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCalendarName();
            return;
        }
        this.pssyscalendarnameDirtyFlag = false;
        this.pssyscalendarname = null;
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

    public void setPSSysViewPanelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewPanelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewpanelid = string;
        this.pssysviewpanelidDirtyFlag = true;
    }

    public String getPSSysViewPanelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelId();
        }
        return this.pssysviewpanelid;
    }

    public boolean isPSSysViewPanelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewPanelIdDirty();
        }
        return this.pssysviewpanelidDirtyFlag;
    }

    public void resetPSSysViewPanelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewPanelId();
            return;
        }
        this.pssysviewpanelidDirtyFlag = false;
        this.pssysviewpanelid = null;
    }

    public void setPSSysViewPanelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewPanelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewpanelname = string;
        this.pssysviewpanelnameDirtyFlag = true;
    }

    public String getPSSysViewPanelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelName();
        }
        return this.pssysviewpanelname;
    }

    public boolean isPSSysViewPanelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewPanelNameDirty();
        }
        return this.pssysviewpanelnameDirtyFlag;
    }

    public void resetPSSysViewPanelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewPanelName();
            return;
        }
        this.pssysviewpanelnameDirtyFlag = false;
        this.pssysviewpanelname = null;
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

    public void setTotalPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTotalPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.totalpsdefid = string;
        this.totalpsdefidDirtyFlag = true;
    }

    public String getTotalPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTotalPSDEFId();
        }
        return this.totalpsdefid;
    }

    public boolean isTotalPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTotalPSDEFIdDirty();
        }
        return this.totalpsdefidDirtyFlag;
    }

    public void resetTotalPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTotalPSDEFId();
            return;
        }
        this.totalpsdefidDirtyFlag = false;
        this.totalpsdefid = null;
    }

    public void setTotalPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTotalPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.totalpsdefname = string;
        this.totalpsdefnameDirtyFlag = true;
    }

    public String getTotalPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTotalPSDEFName();
        }
        return this.totalpsdefname;
    }

    public boolean isTotalPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTotalPSDEFNameDirty();
        }
        return this.totalpsdefnameDirtyFlag;
    }

    public void resetTotalPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTotalPSDEFName();
            return;
        }
        this.totalpsdefnameDirtyFlag = false;
        this.totalpsdefname = null;
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

    public void setUpdatePSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdatePSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.updatepsdeactionid = string;
        this.updatepsdeactionidDirtyFlag = true;
    }

    public String getUpdatePSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdatePSDEActionId();
        }
        return this.updatepsdeactionid;
    }

    public boolean isUpdatePSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdatePSDEActionIdDirty();
        }
        return this.updatepsdeactionidDirtyFlag;
    }

    public void resetUpdatePSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdatePSDEActionId();
            return;
        }
        this.updatepsdeactionidDirtyFlag = false;
        this.updatepsdeactionid = null;
    }

    public void setUpdatePSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdatePSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.updatepsdeactionname = string;
        this.updatepsdeactionnameDirtyFlag = true;
    }

    public String getUpdatePSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdatePSDEActionName();
        }
        return this.updatepsdeactionname;
    }

    public boolean isUpdatePSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdatePSDEActionNameDirty();
        }
        return this.updatepsdeactionnameDirtyFlag;
    }

    public void resetUpdatePSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdatePSDEActionName();
            return;
        }
        this.updatepsdeactionnameDirtyFlag = false;
        this.updatepsdeactionname = null;
    }

    public void setUpdatePSDEOPPrivId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdatePSDEOPPrivId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.updatepsdeopprivid = string;
        this.updatepsdeopprividDirtyFlag = true;
    }

    public String getUpdatePSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdatePSDEOPPrivId();
        }
        return this.updatepsdeopprivid;
    }

    public boolean isUpdatePSDEOPPrivIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdatePSDEOPPrivIdDirty();
        }
        return this.updatepsdeopprividDirtyFlag;
    }

    public void resetUpdatePSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdatePSDEOPPrivId();
            return;
        }
        this.updatepsdeopprividDirtyFlag = false;
        this.updatepsdeopprivid = null;
    }

    public void setUpdatePSDEOPPrivName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdatePSDEOPPrivName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.updatepsdeopprivname = string;
        this.updatepsdeopprivnameDirtyFlag = true;
    }

    public String getUpdatePSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdatePSDEOPPrivName();
        }
        return this.updatepsdeopprivname;
    }

    public boolean isUpdatePSDEOPPrivNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdatePSDEOPPrivNameDirty();
        }
        return this.updatepsdeopprivnameDirtyFlag;
    }

    public void resetUpdatePSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdatePSDEOPPrivName();
            return;
        }
        this.updatepsdeopprivnameDirtyFlag = false;
        this.updatepsdeopprivname = null;
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

    public void setViewActions(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewActions(n);
            return;
        }
        this.viewactions = n;
        this.viewactionsDirtyFlag = true;
    }

    public Integer getViewActions() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewActions();
        }
        return this.viewactions;
    }

    public boolean isViewActionsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewActionsDirty();
        }
        return this.viewactionsDirtyFlag;
    }

    public void resetViewActions() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewActions();
            return;
        }
        this.viewactionsDirtyFlag = false;
        this.viewactions = null;
    }

    protected void onReset() {
        PSSysCalendarItemBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysCalendarItemBase pSSysCalendarItemBase) {
        pSSysCalendarItemBase.resetAsyncPSDEDSId();
        pSSysCalendarItemBase.resetAsyncPSDEDSName();
        pSSysCalendarItemBase.resetBeginPSDEFId();
        pSSysCalendarItemBase.resetBeginPSDEFName();
        pSSysCalendarItemBase.resetBKColor();
        pSSysCalendarItemBase.resetBKColorPSDEFId();
        pSSysCalendarItemBase.resetBKColorPSDEFName();
        pSSysCalendarItemBase.resetClsPSDEFId();
        pSSysCalendarItemBase.resetClsPSDEFName();
        pSSysCalendarItemBase.resetColor();
        pSSysCalendarItemBase.resetColorPSDEFId();
        pSSysCalendarItemBase.resetColorPSDEFName();
        pSSysCalendarItemBase.resetContentPSDEFId();
        pSSysCalendarItemBase.resetContentPSDEFName();
        pSSysCalendarItemBase.resetCreateDate();
        pSSysCalendarItemBase.resetCreateMan();
        pSSysCalendarItemBase.resetCreatePSDEActionId();
        pSSysCalendarItemBase.resetCreatePSDEActionName();
        pSSysCalendarItemBase.resetCreatePSDEOPPrivId();
        pSSysCalendarItemBase.resetCreatePSDEOPPrivName();
        pSSysCalendarItemBase.resetCustomCond();
        pSSysCalendarItemBase.resetCustomType();
        pSSysCalendarItemBase.resetData2PSDEFId();
        pSSysCalendarItemBase.resetData2PSDEFName();
        pSSysCalendarItemBase.resetDataPSDEFId();
        pSSysCalendarItemBase.resetDataPSDEFName();
        pSSysCalendarItemBase.resetDynaClass();
        pSSysCalendarItemBase.resetEditMode();
        pSSysCalendarItemBase.resetEnableViewActions();
        pSSysCalendarItemBase.resetEndPSDEFId();
        pSSysCalendarItemBase.resetEndPSDEFName();
        pSSysCalendarItemBase.resetFinishPSDEFId();
        pSSysCalendarItemBase.resetFinishPSDEFName();
        pSSysCalendarItemBase.resetGanttPSSysPFPluginId();
        pSSysCalendarItemBase.resetGanttPSSysPFPluginName();
        pSSysCalendarItemBase.resetIconPSDEFId();
        pSSysCalendarItemBase.resetIconPSDEFName();
        pSSysCalendarItemBase.resetItemStyle();
        pSSysCalendarItemBase.resetItemStyleText();
        pSSysCalendarItemBase.resetItemType();
        pSSysCalendarItemBase.resetKeyPSDEFId();
        pSSysCalendarItemBase.resetKeyPSDEFName();
        pSSysCalendarItemBase.resetLevelPSDEFId();
        pSSysCalendarItemBase.resetLevelPSDEFName();
        pSSysCalendarItemBase.resetLinkPSDEFId();
        pSSysCalendarItemBase.resetLinkPSDEFName();
        pSSysCalendarItemBase.resetMaxSize();
        pSSysCalendarItemBase.resetMemo();
        pSSysCalendarItemBase.resetModelObj();
        pSSysCalendarItemBase.resetMovePSDEActionId();
        pSSysCalendarItemBase.resetMovePSDEActionName();
        pSSysCalendarItemBase.resetMovePSDEOPPrivId();
        pSSysCalendarItemBase.resetMovePSDEOPPrivName();
        pSSysCalendarItemBase.resetNamePSLanResId();
        pSSysCalendarItemBase.resetNamePSLanResName();
        pSSysCalendarItemBase.resetNavViewFilter();
        pSSysCalendarItemBase.resetNavViewParam();
        pSSysCalendarItemBase.resetOrderValue();
        pSSysCalendarItemBase.resetOrderValuePSDEFId();
        pSSysCalendarItemBase.resetOrderValuePSDEFName();
        pSSysCalendarItemBase.resetPKeyPSDEFId();
        pSSysCalendarItemBase.resetPKeyPSDEFName();
        pSSysCalendarItemBase.resetPSDEDSId();
        pSSysCalendarItemBase.resetPSDEDSName();
        pSSysCalendarItemBase.resetPSDEId();
        pSSysCalendarItemBase.resetPSDELogicId();
        pSSysCalendarItemBase.resetPSDELogicName();
        pSSysCalendarItemBase.resetPSDEName();
        pSSysCalendarItemBase.resetPSDERId();
        pSSysCalendarItemBase.resetPSDERName();
        pSSysCalendarItemBase.resetPSDEToolbarId();
        pSSysCalendarItemBase.resetPSDEToolbarName();
        pSSysCalendarItemBase.resetPSDEViewBaseId();
        pSSysCalendarItemBase.resetPSDEViewBaseName();
        pSSysCalendarItemBase.resetPSSysCalendarId();
        pSSysCalendarItemBase.resetPSSysCalendarItemId();
        pSSysCalendarItemBase.resetPSSysCalendarItemName();
        pSSysCalendarItemBase.resetPSSysCalendarName();
        pSSysCalendarItemBase.resetPSSysCssId();
        pSSysCalendarItemBase.resetPSSysCssName();
        pSSysCalendarItemBase.resetPSSysImageId();
        pSSysCalendarItemBase.resetPSSysImageName();
        pSSysCalendarItemBase.resetPSSysPFPluginId();
        pSSysCalendarItemBase.resetPSSysPFPluginName();
        pSSysCalendarItemBase.resetPSSysViewPanelId();
        pSSysCalendarItemBase.resetPSSysViewPanelName();
        pSSysCalendarItemBase.resetRemovePSDEActionId();
        pSSysCalendarItemBase.resetRemovePSDEActionName();
        pSSysCalendarItemBase.resetRemovePSDEOPPrivId();
        pSSysCalendarItemBase.resetRemovePSDEOPPrivName();
        pSSysCalendarItemBase.resetTag2PSDEFId();
        pSSysCalendarItemBase.resetTag2PSDEFName();
        pSSysCalendarItemBase.resetTagPSDEFId();
        pSSysCalendarItemBase.resetTagPSDEFName();
        pSSysCalendarItemBase.resetTextPSDEFId();
        pSSysCalendarItemBase.resetTextPSDEFName();
        pSSysCalendarItemBase.resetTipsPSDEFId();
        pSSysCalendarItemBase.resetTipsPSDEFName();
        pSSysCalendarItemBase.resetTotalPSDEFId();
        pSSysCalendarItemBase.resetTotalPSDEFName();
        pSSysCalendarItemBase.resetUpdateDate();
        pSSysCalendarItemBase.resetUpdateMan();
        pSSysCalendarItemBase.resetUpdatePSDEActionId();
        pSSysCalendarItemBase.resetUpdatePSDEActionName();
        pSSysCalendarItemBase.resetUpdatePSDEOPPrivId();
        pSSysCalendarItemBase.resetUpdatePSDEOPPrivName();
        pSSysCalendarItemBase.resetUserCat();
        pSSysCalendarItemBase.resetUserTag();
        pSSysCalendarItemBase.resetUserTag2();
        pSSysCalendarItemBase.resetUserTag3();
        pSSysCalendarItemBase.resetUserTag4();
        pSSysCalendarItemBase.resetValidFlag();
        pSSysCalendarItemBase.resetViewActions();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAsyncPSDEDSIdDirty()) {
            hashMap.put(FIELD_ASYNCPSDEDSID, this.getAsyncPSDEDSId());
        }
        if (!bl || this.isAsyncPSDEDSNameDirty()) {
            hashMap.put(FIELD_ASYNCPSDEDSNAME, this.getAsyncPSDEDSName());
        }
        if (!bl || this.isBeginPSDEFIdDirty()) {
            hashMap.put(FIELD_BEGINPSDEFID, this.getBeginPSDEFId());
        }
        if (!bl || this.isBeginPSDEFNameDirty()) {
            hashMap.put(FIELD_BEGINPSDEFNAME, this.getBeginPSDEFName());
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
        if (!bl || this.isCreatePSDEActionIdDirty()) {
            hashMap.put(FIELD_CREATEPSDEACTIONID, this.getCreatePSDEActionId());
        }
        if (!bl || this.isCreatePSDEActionNameDirty()) {
            hashMap.put(FIELD_CREATEPSDEACTIONNAME, this.getCreatePSDEActionName());
        }
        if (!bl || this.isCreatePSDEOPPrivIdDirty()) {
            hashMap.put(FIELD_CREATEPSDEOPPRIVID, this.getCreatePSDEOPPrivId());
        }
        if (!bl || this.isCreatePSDEOPPrivNameDirty()) {
            hashMap.put(FIELD_CREATEPSDEOPPRIVNAME, this.getCreatePSDEOPPrivName());
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
        if (!bl || this.isEditModeDirty()) {
            hashMap.put(FIELD_EDITMODE, this.getEditMode());
        }
        if (!bl || this.isEnableViewActionsDirty()) {
            hashMap.put(FIELD_ENABLEVIEWACTIONS, this.getEnableViewActions());
        }
        if (!bl || this.isEndPSDEFIdDirty()) {
            hashMap.put(FIELD_ENDPSDEFID, this.getEndPSDEFId());
        }
        if (!bl || this.isEndPSDEFNameDirty()) {
            hashMap.put(FIELD_ENDPSDEFNAME, this.getEndPSDEFName());
        }
        if (!bl || this.isFinishPSDEFIdDirty()) {
            hashMap.put(FIELD_FINISHPSDEFID, this.getFinishPSDEFId());
        }
        if (!bl || this.isFinishPSDEFNameDirty()) {
            hashMap.put(FIELD_FINISHPSDEFNAME, this.getFinishPSDEFName());
        }
        if (!bl || this.isGanttPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_GANTTPSSYSPFPLUGINID, this.getGanttPSSysPFPluginId());
        }
        if (!bl || this.isGanttPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_GANTTPSSYSPFPLUGINNAME, this.getGanttPSSysPFPluginName());
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
        if (!bl || this.isLevelPSDEFIdDirty()) {
            hashMap.put(FIELD_LEVELPSDEFID, this.getLevelPSDEFId());
        }
        if (!bl || this.isLevelPSDEFNameDirty()) {
            hashMap.put(FIELD_LEVELPSDEFNAME, this.getLevelPSDEFName());
        }
        if (!bl || this.isLinkPSDEFIdDirty()) {
            hashMap.put(FIELD_LINKPSDEFID, this.getLinkPSDEFId());
        }
        if (!bl || this.isLinkPSDEFNameDirty()) {
            hashMap.put(FIELD_LINKPSDEFNAME, this.getLinkPSDEFName());
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
        if (!bl || this.isPKeyPSDEFIdDirty()) {
            hashMap.put(FIELD_PKEYPSDEFID, this.getPKeyPSDEFId());
        }
        if (!bl || this.isPKeyPSDEFNameDirty()) {
            hashMap.put(FIELD_PKEYPSDEFNAME, this.getPKeyPSDEFName());
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
        if (!bl || this.isPSSysCalendarIdDirty()) {
            hashMap.put(FIELD_PSSYSCALENDARID, this.getPSSysCalendarId());
        }
        if (!bl || this.isPSSysCalendarItemIdDirty()) {
            hashMap.put(FIELD_PSSYSCALENDARITEMID, this.getPSSysCalendarItemId());
        }
        if (!bl || this.isPSSysCalendarItemNameDirty()) {
            hashMap.put(FIELD_PSSYSCALENDARITEMNAME, this.getPSSysCalendarItemName());
        }
        if (!bl || this.isPSSysCalendarNameDirty()) {
            hashMap.put(FIELD_PSSYSCALENDARNAME, this.getPSSysCalendarName());
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
        if (!bl || this.isPSSysViewPanelIdDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELID, this.getPSSysViewPanelId());
        }
        if (!bl || this.isPSSysViewPanelNameDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELNAME, this.getPSSysViewPanelName());
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
        if (!bl || this.isTipsPSDEFIdDirty()) {
            hashMap.put(FIELD_TIPSPSDEFID, this.getTipsPSDEFId());
        }
        if (!bl || this.isTipsPSDEFNameDirty()) {
            hashMap.put(FIELD_TIPSPSDEFNAME, this.getTipsPSDEFName());
        }
        if (!bl || this.isTotalPSDEFIdDirty()) {
            hashMap.put(FIELD_TOTALPSDEFID, this.getTotalPSDEFId());
        }
        if (!bl || this.isTotalPSDEFNameDirty()) {
            hashMap.put(FIELD_TOTALPSDEFNAME, this.getTotalPSDEFName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUpdatePSDEActionIdDirty()) {
            hashMap.put(FIELD_UPDATEPSDEACTIONID, this.getUpdatePSDEActionId());
        }
        if (!bl || this.isUpdatePSDEActionNameDirty()) {
            hashMap.put(FIELD_UPDATEPSDEACTIONNAME, this.getUpdatePSDEActionName());
        }
        if (!bl || this.isUpdatePSDEOPPrivIdDirty()) {
            hashMap.put(FIELD_UPDATEPSDEOPPRIVID, this.getUpdatePSDEOPPrivId());
        }
        if (!bl || this.isUpdatePSDEOPPrivNameDirty()) {
            hashMap.put(FIELD_UPDATEPSDEOPPRIVNAME, this.getUpdatePSDEOPPrivName());
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
        if (!bl || this.isViewActionsDirty()) {
            hashMap.put(FIELD_VIEWACTIONS, this.getViewActions());
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
        return PSSysCalendarItemBase.get(this, n);
    }

    private static Object get(PSSysCalendarItemBase pSSysCalendarItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysCalendarItemBase.getAsyncPSDEDSId();
            }
            case 1: {
                return pSSysCalendarItemBase.getAsyncPSDEDSName();
            }
            case 2: {
                return pSSysCalendarItemBase.getBeginPSDEFId();
            }
            case 3: {
                return pSSysCalendarItemBase.getBeginPSDEFName();
            }
            case 4: {
                return pSSysCalendarItemBase.getBKColor();
            }
            case 5: {
                return pSSysCalendarItemBase.getBKColorPSDEFId();
            }
            case 6: {
                return pSSysCalendarItemBase.getBKColorPSDEFName();
            }
            case 7: {
                return pSSysCalendarItemBase.getClsPSDEFId();
            }
            case 8: {
                return pSSysCalendarItemBase.getClsPSDEFName();
            }
            case 9: {
                return pSSysCalendarItemBase.getColor();
            }
            case 10: {
                return pSSysCalendarItemBase.getColorPSDEFId();
            }
            case 11: {
                return pSSysCalendarItemBase.getColorPSDEFName();
            }
            case 12: {
                return pSSysCalendarItemBase.getContentPSDEFId();
            }
            case 13: {
                return pSSysCalendarItemBase.getContentPSDEFName();
            }
            case 14: {
                return pSSysCalendarItemBase.getCreateDate();
            }
            case 15: {
                return pSSysCalendarItemBase.getCreateMan();
            }
            case 16: {
                return pSSysCalendarItemBase.getCreatePSDEActionId();
            }
            case 17: {
                return pSSysCalendarItemBase.getCreatePSDEActionName();
            }
            case 18: {
                return pSSysCalendarItemBase.getCreatePSDEOPPrivId();
            }
            case 19: {
                return pSSysCalendarItemBase.getCreatePSDEOPPrivName();
            }
            case 20: {
                return pSSysCalendarItemBase.getCustomCond();
            }
            case 21: {
                return pSSysCalendarItemBase.getCustomType();
            }
            case 22: {
                return pSSysCalendarItemBase.getData2PSDEFId();
            }
            case 23: {
                return pSSysCalendarItemBase.getData2PSDEFName();
            }
            case 24: {
                return pSSysCalendarItemBase.getDataPSDEFId();
            }
            case 25: {
                return pSSysCalendarItemBase.getDataPSDEFName();
            }
            case 26: {
                return pSSysCalendarItemBase.getDynaClass();
            }
            case 27: {
                return pSSysCalendarItemBase.getEditMode();
            }
            case 28: {
                return pSSysCalendarItemBase.getEnableViewActions();
            }
            case 29: {
                return pSSysCalendarItemBase.getEndPSDEFId();
            }
            case 30: {
                return pSSysCalendarItemBase.getEndPSDEFName();
            }
            case 31: {
                return pSSysCalendarItemBase.getFinishPSDEFId();
            }
            case 32: {
                return pSSysCalendarItemBase.getFinishPSDEFName();
            }
            case 33: {
                return pSSysCalendarItemBase.getGanttPSSysPFPluginId();
            }
            case 34: {
                return pSSysCalendarItemBase.getGanttPSSysPFPluginName();
            }
            case 35: {
                return pSSysCalendarItemBase.getIconPSDEFId();
            }
            case 36: {
                return pSSysCalendarItemBase.getIconPSDEFName();
            }
            case 37: {
                return pSSysCalendarItemBase.getItemStyle();
            }
            case 38: {
                return pSSysCalendarItemBase.getItemStyleText();
            }
            case 39: {
                return pSSysCalendarItemBase.getItemType();
            }
            case 40: {
                return pSSysCalendarItemBase.getKeyPSDEFId();
            }
            case 41: {
                return pSSysCalendarItemBase.getKeyPSDEFName();
            }
            case 42: {
                return pSSysCalendarItemBase.getLevelPSDEFId();
            }
            case 43: {
                return pSSysCalendarItemBase.getLevelPSDEFName();
            }
            case 44: {
                return pSSysCalendarItemBase.getLinkPSDEFId();
            }
            case 45: {
                return pSSysCalendarItemBase.getLinkPSDEFName();
            }
            case 46: {
                return pSSysCalendarItemBase.getMaxSize();
            }
            case 47: {
                return pSSysCalendarItemBase.getMemo();
            }
            case 48: {
                return pSSysCalendarItemBase.getModelObj();
            }
            case 49: {
                return pSSysCalendarItemBase.getMovePSDEActionId();
            }
            case 50: {
                return pSSysCalendarItemBase.getMovePSDEActionName();
            }
            case 51: {
                return pSSysCalendarItemBase.getMovePSDEOPPrivId();
            }
            case 52: {
                return pSSysCalendarItemBase.getMovePSDEOPPrivName();
            }
            case 53: {
                return pSSysCalendarItemBase.getNamePSLanResId();
            }
            case 54: {
                return pSSysCalendarItemBase.getNamePSLanResName();
            }
            case 55: {
                return pSSysCalendarItemBase.getNavViewFilter();
            }
            case 56: {
                return pSSysCalendarItemBase.getNavViewParam();
            }
            case 57: {
                return pSSysCalendarItemBase.getOrderValue();
            }
            case 58: {
                return pSSysCalendarItemBase.getOrderValuePSDEFId();
            }
            case 59: {
                return pSSysCalendarItemBase.getOrderValuePSDEFName();
            }
            case 60: {
                return pSSysCalendarItemBase.getPKeyPSDEFId();
            }
            case 61: {
                return pSSysCalendarItemBase.getPKeyPSDEFName();
            }
            case 62: {
                return pSSysCalendarItemBase.getPSDEDSId();
            }
            case 63: {
                return pSSysCalendarItemBase.getPSDEDSName();
            }
            case 64: {
                return pSSysCalendarItemBase.getPSDEId();
            }
            case 65: {
                return pSSysCalendarItemBase.getPSDELogicId();
            }
            case 66: {
                return pSSysCalendarItemBase.getPSDELogicName();
            }
            case 67: {
                return pSSysCalendarItemBase.getPSDEName();
            }
            case 68: {
                return pSSysCalendarItemBase.getPSDERId();
            }
            case 69: {
                return pSSysCalendarItemBase.getPSDERName();
            }
            case 70: {
                return pSSysCalendarItemBase.getPSDEToolbarId();
            }
            case 71: {
                return pSSysCalendarItemBase.getPSDEToolbarName();
            }
            case 72: {
                return pSSysCalendarItemBase.getPSDEViewBaseId();
            }
            case 73: {
                return pSSysCalendarItemBase.getPSDEViewBaseName();
            }
            case 74: {
                return pSSysCalendarItemBase.getPSSysCalendarId();
            }
            case 75: {
                return pSSysCalendarItemBase.getPSSysCalendarItemId();
            }
            case 76: {
                return pSSysCalendarItemBase.getPSSysCalendarItemName();
            }
            case 77: {
                return pSSysCalendarItemBase.getPSSysCalendarName();
            }
            case 78: {
                return pSSysCalendarItemBase.getPSSysCssId();
            }
            case 79: {
                return pSSysCalendarItemBase.getPSSysCssName();
            }
            case 80: {
                return pSSysCalendarItemBase.getPSSysImageId();
            }
            case 81: {
                return pSSysCalendarItemBase.getPSSysImageName();
            }
            case 82: {
                return pSSysCalendarItemBase.getPSSysPFPluginId();
            }
            case 83: {
                return pSSysCalendarItemBase.getPSSysPFPluginName();
            }
            case 84: {
                return pSSysCalendarItemBase.getPSSysViewPanelId();
            }
            case 85: {
                return pSSysCalendarItemBase.getPSSysViewPanelName();
            }
            case 86: {
                return pSSysCalendarItemBase.getRemovePSDEActionId();
            }
            case 87: {
                return pSSysCalendarItemBase.getRemovePSDEActionName();
            }
            case 88: {
                return pSSysCalendarItemBase.getRemovePSDEOPPrivId();
            }
            case 89: {
                return pSSysCalendarItemBase.getRemovePSDEOPPrivName();
            }
            case 90: {
                return pSSysCalendarItemBase.getTag2PSDEFId();
            }
            case 91: {
                return pSSysCalendarItemBase.getTag2PSDEFName();
            }
            case 92: {
                return pSSysCalendarItemBase.getTagPSDEFId();
            }
            case 93: {
                return pSSysCalendarItemBase.getTagPSDEFName();
            }
            case 94: {
                return pSSysCalendarItemBase.getTextPSDEFId();
            }
            case 95: {
                return pSSysCalendarItemBase.getTextPSDEFName();
            }
            case 96: {
                return pSSysCalendarItemBase.getTipsPSDEFId();
            }
            case 97: {
                return pSSysCalendarItemBase.getTipsPSDEFName();
            }
            case 98: {
                return pSSysCalendarItemBase.getTotalPSDEFId();
            }
            case 99: {
                return pSSysCalendarItemBase.getTotalPSDEFName();
            }
            case 100: {
                return pSSysCalendarItemBase.getUpdateDate();
            }
            case 101: {
                return pSSysCalendarItemBase.getUpdateMan();
            }
            case 102: {
                return pSSysCalendarItemBase.getUpdatePSDEActionId();
            }
            case 103: {
                return pSSysCalendarItemBase.getUpdatePSDEActionName();
            }
            case 104: {
                return pSSysCalendarItemBase.getUpdatePSDEOPPrivId();
            }
            case 105: {
                return pSSysCalendarItemBase.getUpdatePSDEOPPrivName();
            }
            case 106: {
                return pSSysCalendarItemBase.getUserCat();
            }
            case 107: {
                return pSSysCalendarItemBase.getUserTag();
            }
            case 108: {
                return pSSysCalendarItemBase.getUserTag2();
            }
            case 109: {
                return pSSysCalendarItemBase.getUserTag3();
            }
            case 110: {
                return pSSysCalendarItemBase.getUserTag4();
            }
            case 111: {
                return pSSysCalendarItemBase.getValidFlag();
            }
            case 112: {
                return pSSysCalendarItemBase.getViewActions();
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
        PSSysCalendarItemBase.set(this, n, object);
    }

    private static void set(PSSysCalendarItemBase pSSysCalendarItemBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysCalendarItemBase.setAsyncPSDEDSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysCalendarItemBase.setAsyncPSDEDSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysCalendarItemBase.setBeginPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysCalendarItemBase.setBeginPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysCalendarItemBase.setBKColor(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysCalendarItemBase.setBKColorPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysCalendarItemBase.setBKColorPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysCalendarItemBase.setClsPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysCalendarItemBase.setClsPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysCalendarItemBase.setColor(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysCalendarItemBase.setColorPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysCalendarItemBase.setColorPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysCalendarItemBase.setContentPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysCalendarItemBase.setContentPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysCalendarItemBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSSysCalendarItemBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysCalendarItemBase.setCreatePSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysCalendarItemBase.setCreatePSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysCalendarItemBase.setCreatePSDEOPPrivId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysCalendarItemBase.setCreatePSDEOPPrivName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysCalendarItemBase.setCustomCond(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysCalendarItemBase.setCustomType(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysCalendarItemBase.setData2PSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysCalendarItemBase.setData2PSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysCalendarItemBase.setDataPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysCalendarItemBase.setDataPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysCalendarItemBase.setDynaClass(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysCalendarItemBase.setEditMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 28: {
                pSSysCalendarItemBase.setEnableViewActions(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 29: {
                pSSysCalendarItemBase.setEndPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysCalendarItemBase.setEndPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysCalendarItemBase.setFinishPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysCalendarItemBase.setFinishPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysCalendarItemBase.setGanttPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysCalendarItemBase.setGanttPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysCalendarItemBase.setIconPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysCalendarItemBase.setIconPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysCalendarItemBase.setItemStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSysCalendarItemBase.setItemStyleText(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysCalendarItemBase.setItemType(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSSysCalendarItemBase.setKeyPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSSysCalendarItemBase.setKeyPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSSysCalendarItemBase.setLevelPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSSysCalendarItemBase.setLevelPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSSysCalendarItemBase.setLinkPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSSysCalendarItemBase.setLinkPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSSysCalendarItemBase.setMaxSize(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 47: {
                pSSysCalendarItemBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSSysCalendarItemBase.setModelObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSSysCalendarItemBase.setMovePSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSSysCalendarItemBase.setMovePSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSSysCalendarItemBase.setMovePSDEOPPrivId(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSSysCalendarItemBase.setMovePSDEOPPrivName(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSSysCalendarItemBase.setNamePSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSSysCalendarItemBase.setNamePSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSSysCalendarItemBase.setNavViewFilter(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSSysCalendarItemBase.setNavViewParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSSysCalendarItemBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 58: {
                pSSysCalendarItemBase.setOrderValuePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSSysCalendarItemBase.setOrderValuePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSSysCalendarItemBase.setPKeyPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSSysCalendarItemBase.setPKeyPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSSysCalendarItemBase.setPSDEDSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSSysCalendarItemBase.setPSDEDSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSSysCalendarItemBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSSysCalendarItemBase.setPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSSysCalendarItemBase.setPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSSysCalendarItemBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSSysCalendarItemBase.setPSDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSSysCalendarItemBase.setPSDERName(DataObject.getStringValue((Object)object));
                return;
            }
            case 70: {
                pSSysCalendarItemBase.setPSDEToolbarId(DataObject.getStringValue((Object)object));
                return;
            }
            case 71: {
                pSSysCalendarItemBase.setPSDEToolbarName(DataObject.getStringValue((Object)object));
                return;
            }
            case 72: {
                pSSysCalendarItemBase.setPSDEViewBaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 73: {
                pSSysCalendarItemBase.setPSDEViewBaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 74: {
                pSSysCalendarItemBase.setPSSysCalendarId(DataObject.getStringValue((Object)object));
                return;
            }
            case 75: {
                pSSysCalendarItemBase.setPSSysCalendarItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 76: {
                pSSysCalendarItemBase.setPSSysCalendarItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 77: {
                pSSysCalendarItemBase.setPSSysCalendarName(DataObject.getStringValue((Object)object));
                return;
            }
            case 78: {
                pSSysCalendarItemBase.setPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 79: {
                pSSysCalendarItemBase.setPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 80: {
                pSSysCalendarItemBase.setPSSysImageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 81: {
                pSSysCalendarItemBase.setPSSysImageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 82: {
                pSSysCalendarItemBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 83: {
                pSSysCalendarItemBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 84: {
                pSSysCalendarItemBase.setPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 85: {
                pSSysCalendarItemBase.setPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 86: {
                pSSysCalendarItemBase.setRemovePSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 87: {
                pSSysCalendarItemBase.setRemovePSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 88: {
                pSSysCalendarItemBase.setRemovePSDEOPPrivId(DataObject.getStringValue((Object)object));
                return;
            }
            case 89: {
                pSSysCalendarItemBase.setRemovePSDEOPPrivName(DataObject.getStringValue((Object)object));
                return;
            }
            case 90: {
                pSSysCalendarItemBase.setTag2PSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 91: {
                pSSysCalendarItemBase.setTag2PSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 92: {
                pSSysCalendarItemBase.setTagPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 93: {
                pSSysCalendarItemBase.setTagPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 94: {
                pSSysCalendarItemBase.setTextPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 95: {
                pSSysCalendarItemBase.setTextPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 96: {
                pSSysCalendarItemBase.setTipsPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 97: {
                pSSysCalendarItemBase.setTipsPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 98: {
                pSSysCalendarItemBase.setTotalPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 99: {
                pSSysCalendarItemBase.setTotalPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 100: {
                pSSysCalendarItemBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 101: {
                pSSysCalendarItemBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 102: {
                pSSysCalendarItemBase.setUpdatePSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 103: {
                pSSysCalendarItemBase.setUpdatePSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 104: {
                pSSysCalendarItemBase.setUpdatePSDEOPPrivId(DataObject.getStringValue((Object)object));
                return;
            }
            case 105: {
                pSSysCalendarItemBase.setUpdatePSDEOPPrivName(DataObject.getStringValue((Object)object));
                return;
            }
            case 106: {
                pSSysCalendarItemBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 107: {
                pSSysCalendarItemBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 108: {
                pSSysCalendarItemBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 109: {
                pSSysCalendarItemBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 110: {
                pSSysCalendarItemBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 111: {
                pSSysCalendarItemBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 112: {
                pSSysCalendarItemBase.setViewActions(DataObject.getIntegerValue((Object)object));
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
        return PSSysCalendarItemBase.isNull(this, n);
    }

    private static boolean isNull(PSSysCalendarItemBase pSSysCalendarItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysCalendarItemBase.getAsyncPSDEDSId() == null;
            }
            case 1: {
                return pSSysCalendarItemBase.getAsyncPSDEDSName() == null;
            }
            case 2: {
                return pSSysCalendarItemBase.getBeginPSDEFId() == null;
            }
            case 3: {
                return pSSysCalendarItemBase.getBeginPSDEFName() == null;
            }
            case 4: {
                return pSSysCalendarItemBase.getBKColor() == null;
            }
            case 5: {
                return pSSysCalendarItemBase.getBKColorPSDEFId() == null;
            }
            case 6: {
                return pSSysCalendarItemBase.getBKColorPSDEFName() == null;
            }
            case 7: {
                return pSSysCalendarItemBase.getClsPSDEFId() == null;
            }
            case 8: {
                return pSSysCalendarItemBase.getClsPSDEFName() == null;
            }
            case 9: {
                return pSSysCalendarItemBase.getColor() == null;
            }
            case 10: {
                return pSSysCalendarItemBase.getColorPSDEFId() == null;
            }
            case 11: {
                return pSSysCalendarItemBase.getColorPSDEFName() == null;
            }
            case 12: {
                return pSSysCalendarItemBase.getContentPSDEFId() == null;
            }
            case 13: {
                return pSSysCalendarItemBase.getContentPSDEFName() == null;
            }
            case 14: {
                return pSSysCalendarItemBase.getCreateDate() == null;
            }
            case 15: {
                return pSSysCalendarItemBase.getCreateMan() == null;
            }
            case 16: {
                return pSSysCalendarItemBase.getCreatePSDEActionId() == null;
            }
            case 17: {
                return pSSysCalendarItemBase.getCreatePSDEActionName() == null;
            }
            case 18: {
                return pSSysCalendarItemBase.getCreatePSDEOPPrivId() == null;
            }
            case 19: {
                return pSSysCalendarItemBase.getCreatePSDEOPPrivName() == null;
            }
            case 20: {
                return pSSysCalendarItemBase.getCustomCond() == null;
            }
            case 21: {
                return pSSysCalendarItemBase.getCustomType() == null;
            }
            case 22: {
                return pSSysCalendarItemBase.getData2PSDEFId() == null;
            }
            case 23: {
                return pSSysCalendarItemBase.getData2PSDEFName() == null;
            }
            case 24: {
                return pSSysCalendarItemBase.getDataPSDEFId() == null;
            }
            case 25: {
                return pSSysCalendarItemBase.getDataPSDEFName() == null;
            }
            case 26: {
                return pSSysCalendarItemBase.getDynaClass() == null;
            }
            case 27: {
                return pSSysCalendarItemBase.getEditMode() == null;
            }
            case 28: {
                return pSSysCalendarItemBase.getEnableViewActions() == null;
            }
            case 29: {
                return pSSysCalendarItemBase.getEndPSDEFId() == null;
            }
            case 30: {
                return pSSysCalendarItemBase.getEndPSDEFName() == null;
            }
            case 31: {
                return pSSysCalendarItemBase.getFinishPSDEFId() == null;
            }
            case 32: {
                return pSSysCalendarItemBase.getFinishPSDEFName() == null;
            }
            case 33: {
                return pSSysCalendarItemBase.getGanttPSSysPFPluginId() == null;
            }
            case 34: {
                return pSSysCalendarItemBase.getGanttPSSysPFPluginName() == null;
            }
            case 35: {
                return pSSysCalendarItemBase.getIconPSDEFId() == null;
            }
            case 36: {
                return pSSysCalendarItemBase.getIconPSDEFName() == null;
            }
            case 37: {
                return pSSysCalendarItemBase.getItemStyle() == null;
            }
            case 38: {
                return pSSysCalendarItemBase.getItemStyleText() == null;
            }
            case 39: {
                return pSSysCalendarItemBase.getItemType() == null;
            }
            case 40: {
                return pSSysCalendarItemBase.getKeyPSDEFId() == null;
            }
            case 41: {
                return pSSysCalendarItemBase.getKeyPSDEFName() == null;
            }
            case 42: {
                return pSSysCalendarItemBase.getLevelPSDEFId() == null;
            }
            case 43: {
                return pSSysCalendarItemBase.getLevelPSDEFName() == null;
            }
            case 44: {
                return pSSysCalendarItemBase.getLinkPSDEFId() == null;
            }
            case 45: {
                return pSSysCalendarItemBase.getLinkPSDEFName() == null;
            }
            case 46: {
                return pSSysCalendarItemBase.getMaxSize() == null;
            }
            case 47: {
                return pSSysCalendarItemBase.getMemo() == null;
            }
            case 48: {
                return pSSysCalendarItemBase.getModelObj() == null;
            }
            case 49: {
                return pSSysCalendarItemBase.getMovePSDEActionId() == null;
            }
            case 50: {
                return pSSysCalendarItemBase.getMovePSDEActionName() == null;
            }
            case 51: {
                return pSSysCalendarItemBase.getMovePSDEOPPrivId() == null;
            }
            case 52: {
                return pSSysCalendarItemBase.getMovePSDEOPPrivName() == null;
            }
            case 53: {
                return pSSysCalendarItemBase.getNamePSLanResId() == null;
            }
            case 54: {
                return pSSysCalendarItemBase.getNamePSLanResName() == null;
            }
            case 55: {
                return pSSysCalendarItemBase.getNavViewFilter() == null;
            }
            case 56: {
                return pSSysCalendarItemBase.getNavViewParam() == null;
            }
            case 57: {
                return pSSysCalendarItemBase.getOrderValue() == null;
            }
            case 58: {
                return pSSysCalendarItemBase.getOrderValuePSDEFId() == null;
            }
            case 59: {
                return pSSysCalendarItemBase.getOrderValuePSDEFName() == null;
            }
            case 60: {
                return pSSysCalendarItemBase.getPKeyPSDEFId() == null;
            }
            case 61: {
                return pSSysCalendarItemBase.getPKeyPSDEFName() == null;
            }
            case 62: {
                return pSSysCalendarItemBase.getPSDEDSId() == null;
            }
            case 63: {
                return pSSysCalendarItemBase.getPSDEDSName() == null;
            }
            case 64: {
                return pSSysCalendarItemBase.getPSDEId() == null;
            }
            case 65: {
                return pSSysCalendarItemBase.getPSDELogicId() == null;
            }
            case 66: {
                return pSSysCalendarItemBase.getPSDELogicName() == null;
            }
            case 67: {
                return pSSysCalendarItemBase.getPSDEName() == null;
            }
            case 68: {
                return pSSysCalendarItemBase.getPSDERId() == null;
            }
            case 69: {
                return pSSysCalendarItemBase.getPSDERName() == null;
            }
            case 70: {
                return pSSysCalendarItemBase.getPSDEToolbarId() == null;
            }
            case 71: {
                return pSSysCalendarItemBase.getPSDEToolbarName() == null;
            }
            case 72: {
                return pSSysCalendarItemBase.getPSDEViewBaseId() == null;
            }
            case 73: {
                return pSSysCalendarItemBase.getPSDEViewBaseName() == null;
            }
            case 74: {
                return pSSysCalendarItemBase.getPSSysCalendarId() == null;
            }
            case 75: {
                return pSSysCalendarItemBase.getPSSysCalendarItemId() == null;
            }
            case 76: {
                return pSSysCalendarItemBase.getPSSysCalendarItemName() == null;
            }
            case 77: {
                return pSSysCalendarItemBase.getPSSysCalendarName() == null;
            }
            case 78: {
                return pSSysCalendarItemBase.getPSSysCssId() == null;
            }
            case 79: {
                return pSSysCalendarItemBase.getPSSysCssName() == null;
            }
            case 80: {
                return pSSysCalendarItemBase.getPSSysImageId() == null;
            }
            case 81: {
                return pSSysCalendarItemBase.getPSSysImageName() == null;
            }
            case 82: {
                return pSSysCalendarItemBase.getPSSysPFPluginId() == null;
            }
            case 83: {
                return pSSysCalendarItemBase.getPSSysPFPluginName() == null;
            }
            case 84: {
                return pSSysCalendarItemBase.getPSSysViewPanelId() == null;
            }
            case 85: {
                return pSSysCalendarItemBase.getPSSysViewPanelName() == null;
            }
            case 86: {
                return pSSysCalendarItemBase.getRemovePSDEActionId() == null;
            }
            case 87: {
                return pSSysCalendarItemBase.getRemovePSDEActionName() == null;
            }
            case 88: {
                return pSSysCalendarItemBase.getRemovePSDEOPPrivId() == null;
            }
            case 89: {
                return pSSysCalendarItemBase.getRemovePSDEOPPrivName() == null;
            }
            case 90: {
                return pSSysCalendarItemBase.getTag2PSDEFId() == null;
            }
            case 91: {
                return pSSysCalendarItemBase.getTag2PSDEFName() == null;
            }
            case 92: {
                return pSSysCalendarItemBase.getTagPSDEFId() == null;
            }
            case 93: {
                return pSSysCalendarItemBase.getTagPSDEFName() == null;
            }
            case 94: {
                return pSSysCalendarItemBase.getTextPSDEFId() == null;
            }
            case 95: {
                return pSSysCalendarItemBase.getTextPSDEFName() == null;
            }
            case 96: {
                return pSSysCalendarItemBase.getTipsPSDEFId() == null;
            }
            case 97: {
                return pSSysCalendarItemBase.getTipsPSDEFName() == null;
            }
            case 98: {
                return pSSysCalendarItemBase.getTotalPSDEFId() == null;
            }
            case 99: {
                return pSSysCalendarItemBase.getTotalPSDEFName() == null;
            }
            case 100: {
                return pSSysCalendarItemBase.getUpdateDate() == null;
            }
            case 101: {
                return pSSysCalendarItemBase.getUpdateMan() == null;
            }
            case 102: {
                return pSSysCalendarItemBase.getUpdatePSDEActionId() == null;
            }
            case 103: {
                return pSSysCalendarItemBase.getUpdatePSDEActionName() == null;
            }
            case 104: {
                return pSSysCalendarItemBase.getUpdatePSDEOPPrivId() == null;
            }
            case 105: {
                return pSSysCalendarItemBase.getUpdatePSDEOPPrivName() == null;
            }
            case 106: {
                return pSSysCalendarItemBase.getUserCat() == null;
            }
            case 107: {
                return pSSysCalendarItemBase.getUserTag() == null;
            }
            case 108: {
                return pSSysCalendarItemBase.getUserTag2() == null;
            }
            case 109: {
                return pSSysCalendarItemBase.getUserTag3() == null;
            }
            case 110: {
                return pSSysCalendarItemBase.getUserTag4() == null;
            }
            case 111: {
                return pSSysCalendarItemBase.getValidFlag() == null;
            }
            case 112: {
                return pSSysCalendarItemBase.getViewActions() == null;
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
        return PSSysCalendarItemBase.contains(this, n);
    }

    private static boolean contains(PSSysCalendarItemBase pSSysCalendarItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysCalendarItemBase.isAsyncPSDEDSIdDirty();
            }
            case 1: {
                return pSSysCalendarItemBase.isAsyncPSDEDSNameDirty();
            }
            case 2: {
                return pSSysCalendarItemBase.isBeginPSDEFIdDirty();
            }
            case 3: {
                return pSSysCalendarItemBase.isBeginPSDEFNameDirty();
            }
            case 4: {
                return pSSysCalendarItemBase.isBKColorDirty();
            }
            case 5: {
                return pSSysCalendarItemBase.isBKColorPSDEFIdDirty();
            }
            case 6: {
                return pSSysCalendarItemBase.isBKColorPSDEFNameDirty();
            }
            case 7: {
                return pSSysCalendarItemBase.isClsPSDEFIdDirty();
            }
            case 8: {
                return pSSysCalendarItemBase.isClsPSDEFNameDirty();
            }
            case 9: {
                return pSSysCalendarItemBase.isColorDirty();
            }
            case 10: {
                return pSSysCalendarItemBase.isColorPSDEFIdDirty();
            }
            case 11: {
                return pSSysCalendarItemBase.isColorPSDEFNameDirty();
            }
            case 12: {
                return pSSysCalendarItemBase.isContentPSDEFIdDirty();
            }
            case 13: {
                return pSSysCalendarItemBase.isContentPSDEFNameDirty();
            }
            case 14: {
                return pSSysCalendarItemBase.isCreateDateDirty();
            }
            case 15: {
                return pSSysCalendarItemBase.isCreateManDirty();
            }
            case 16: {
                return pSSysCalendarItemBase.isCreatePSDEActionIdDirty();
            }
            case 17: {
                return pSSysCalendarItemBase.isCreatePSDEActionNameDirty();
            }
            case 18: {
                return pSSysCalendarItemBase.isCreatePSDEOPPrivIdDirty();
            }
            case 19: {
                return pSSysCalendarItemBase.isCreatePSDEOPPrivNameDirty();
            }
            case 20: {
                return pSSysCalendarItemBase.isCustomCondDirty();
            }
            case 21: {
                return pSSysCalendarItemBase.isCustomTypeDirty();
            }
            case 22: {
                return pSSysCalendarItemBase.isData2PSDEFIdDirty();
            }
            case 23: {
                return pSSysCalendarItemBase.isData2PSDEFNameDirty();
            }
            case 24: {
                return pSSysCalendarItemBase.isDataPSDEFIdDirty();
            }
            case 25: {
                return pSSysCalendarItemBase.isDataPSDEFNameDirty();
            }
            case 26: {
                return pSSysCalendarItemBase.isDynaClassDirty();
            }
            case 27: {
                return pSSysCalendarItemBase.isEditModeDirty();
            }
            case 28: {
                return pSSysCalendarItemBase.isEnableViewActionsDirty();
            }
            case 29: {
                return pSSysCalendarItemBase.isEndPSDEFIdDirty();
            }
            case 30: {
                return pSSysCalendarItemBase.isEndPSDEFNameDirty();
            }
            case 31: {
                return pSSysCalendarItemBase.isFinishPSDEFIdDirty();
            }
            case 32: {
                return pSSysCalendarItemBase.isFinishPSDEFNameDirty();
            }
            case 33: {
                return pSSysCalendarItemBase.isGanttPSSysPFPluginIdDirty();
            }
            case 34: {
                return pSSysCalendarItemBase.isGanttPSSysPFPluginNameDirty();
            }
            case 35: {
                return pSSysCalendarItemBase.isIconPSDEFIdDirty();
            }
            case 36: {
                return pSSysCalendarItemBase.isIconPSDEFNameDirty();
            }
            case 37: {
                return pSSysCalendarItemBase.isItemStyleDirty();
            }
            case 38: {
                return pSSysCalendarItemBase.isItemStyleTextDirty();
            }
            case 39: {
                return pSSysCalendarItemBase.isItemTypeDirty();
            }
            case 40: {
                return pSSysCalendarItemBase.isKeyPSDEFIdDirty();
            }
            case 41: {
                return pSSysCalendarItemBase.isKeyPSDEFNameDirty();
            }
            case 42: {
                return pSSysCalendarItemBase.isLevelPSDEFIdDirty();
            }
            case 43: {
                return pSSysCalendarItemBase.isLevelPSDEFNameDirty();
            }
            case 44: {
                return pSSysCalendarItemBase.isLinkPSDEFIdDirty();
            }
            case 45: {
                return pSSysCalendarItemBase.isLinkPSDEFNameDirty();
            }
            case 46: {
                return pSSysCalendarItemBase.isMaxSizeDirty();
            }
            case 47: {
                return pSSysCalendarItemBase.isMemoDirty();
            }
            case 48: {
                return pSSysCalendarItemBase.isModelObjDirty();
            }
            case 49: {
                return pSSysCalendarItemBase.isMovePSDEActionIdDirty();
            }
            case 50: {
                return pSSysCalendarItemBase.isMovePSDEActionNameDirty();
            }
            case 51: {
                return pSSysCalendarItemBase.isMovePSDEOPPrivIdDirty();
            }
            case 52: {
                return pSSysCalendarItemBase.isMovePSDEOPPrivNameDirty();
            }
            case 53: {
                return pSSysCalendarItemBase.isNamePSLanResIdDirty();
            }
            case 54: {
                return pSSysCalendarItemBase.isNamePSLanResNameDirty();
            }
            case 55: {
                return pSSysCalendarItemBase.isNavViewFilterDirty();
            }
            case 56: {
                return pSSysCalendarItemBase.isNavViewParamDirty();
            }
            case 57: {
                return pSSysCalendarItemBase.isOrderValueDirty();
            }
            case 58: {
                return pSSysCalendarItemBase.isOrderValuePSDEFIdDirty();
            }
            case 59: {
                return pSSysCalendarItemBase.isOrderValuePSDEFNameDirty();
            }
            case 60: {
                return pSSysCalendarItemBase.isPKeyPSDEFIdDirty();
            }
            case 61: {
                return pSSysCalendarItemBase.isPKeyPSDEFNameDirty();
            }
            case 62: {
                return pSSysCalendarItemBase.isPSDEDSIdDirty();
            }
            case 63: {
                return pSSysCalendarItemBase.isPSDEDSNameDirty();
            }
            case 64: {
                return pSSysCalendarItemBase.isPSDEIdDirty();
            }
            case 65: {
                return pSSysCalendarItemBase.isPSDELogicIdDirty();
            }
            case 66: {
                return pSSysCalendarItemBase.isPSDELogicNameDirty();
            }
            case 67: {
                return pSSysCalendarItemBase.isPSDENameDirty();
            }
            case 68: {
                return pSSysCalendarItemBase.isPSDERIdDirty();
            }
            case 69: {
                return pSSysCalendarItemBase.isPSDERNameDirty();
            }
            case 70: {
                return pSSysCalendarItemBase.isPSDEToolbarIdDirty();
            }
            case 71: {
                return pSSysCalendarItemBase.isPSDEToolbarNameDirty();
            }
            case 72: {
                return pSSysCalendarItemBase.isPSDEViewBaseIdDirty();
            }
            case 73: {
                return pSSysCalendarItemBase.isPSDEViewBaseNameDirty();
            }
            case 74: {
                return pSSysCalendarItemBase.isPSSysCalendarIdDirty();
            }
            case 75: {
                return pSSysCalendarItemBase.isPSSysCalendarItemIdDirty();
            }
            case 76: {
                return pSSysCalendarItemBase.isPSSysCalendarItemNameDirty();
            }
            case 77: {
                return pSSysCalendarItemBase.isPSSysCalendarNameDirty();
            }
            case 78: {
                return pSSysCalendarItemBase.isPSSysCssIdDirty();
            }
            case 79: {
                return pSSysCalendarItemBase.isPSSysCssNameDirty();
            }
            case 80: {
                return pSSysCalendarItemBase.isPSSysImageIdDirty();
            }
            case 81: {
                return pSSysCalendarItemBase.isPSSysImageNameDirty();
            }
            case 82: {
                return pSSysCalendarItemBase.isPSSysPFPluginIdDirty();
            }
            case 83: {
                return pSSysCalendarItemBase.isPSSysPFPluginNameDirty();
            }
            case 84: {
                return pSSysCalendarItemBase.isPSSysViewPanelIdDirty();
            }
            case 85: {
                return pSSysCalendarItemBase.isPSSysViewPanelNameDirty();
            }
            case 86: {
                return pSSysCalendarItemBase.isRemovePSDEActionIdDirty();
            }
            case 87: {
                return pSSysCalendarItemBase.isRemovePSDEActionNameDirty();
            }
            case 88: {
                return pSSysCalendarItemBase.isRemovePSDEOPPrivIdDirty();
            }
            case 89: {
                return pSSysCalendarItemBase.isRemovePSDEOPPrivNameDirty();
            }
            case 90: {
                return pSSysCalendarItemBase.isTag2PSDEFIdDirty();
            }
            case 91: {
                return pSSysCalendarItemBase.isTag2PSDEFNameDirty();
            }
            case 92: {
                return pSSysCalendarItemBase.isTagPSDEFIdDirty();
            }
            case 93: {
                return pSSysCalendarItemBase.isTagPSDEFNameDirty();
            }
            case 94: {
                return pSSysCalendarItemBase.isTextPSDEFIdDirty();
            }
            case 95: {
                return pSSysCalendarItemBase.isTextPSDEFNameDirty();
            }
            case 96: {
                return pSSysCalendarItemBase.isTipsPSDEFIdDirty();
            }
            case 97: {
                return pSSysCalendarItemBase.isTipsPSDEFNameDirty();
            }
            case 98: {
                return pSSysCalendarItemBase.isTotalPSDEFIdDirty();
            }
            case 99: {
                return pSSysCalendarItemBase.isTotalPSDEFNameDirty();
            }
            case 100: {
                return pSSysCalendarItemBase.isUpdateDateDirty();
            }
            case 101: {
                return pSSysCalendarItemBase.isUpdateManDirty();
            }
            case 102: {
                return pSSysCalendarItemBase.isUpdatePSDEActionIdDirty();
            }
            case 103: {
                return pSSysCalendarItemBase.isUpdatePSDEActionNameDirty();
            }
            case 104: {
                return pSSysCalendarItemBase.isUpdatePSDEOPPrivIdDirty();
            }
            case 105: {
                return pSSysCalendarItemBase.isUpdatePSDEOPPrivNameDirty();
            }
            case 106: {
                return pSSysCalendarItemBase.isUserCatDirty();
            }
            case 107: {
                return pSSysCalendarItemBase.isUserTagDirty();
            }
            case 108: {
                return pSSysCalendarItemBase.isUserTag2Dirty();
            }
            case 109: {
                return pSSysCalendarItemBase.isUserTag3Dirty();
            }
            case 110: {
                return pSSysCalendarItemBase.isUserTag4Dirty();
            }
            case 111: {
                return pSSysCalendarItemBase.isValidFlagDirty();
            }
            case 112: {
                return pSSysCalendarItemBase.isViewActionsDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysCalendarItemBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysCalendarItemBase pSSysCalendarItemBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysCalendarItemBase.getAsyncPSDEDSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"asyncpsdedsid", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getAsyncPSDEDSId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getAsyncPSDEDSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"asyncpsdedsname", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getAsyncPSDEDSName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getBeginPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"beginpsdefid", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getBeginPSDEFId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getBeginPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"beginpsdefname", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getBeginPSDEFName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getBKColor() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bkcolor", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getBKColor()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getBKColorPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bkcolorpsdefid", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getBKColorPSDEFId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getBKColorPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bkcolorpsdefname", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getBKColorPSDEFName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getClsPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clspsdefid", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getClsPSDEFId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getClsPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clspsdefname", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getClsPSDEFName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getColor() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"color", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getColor()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getColorPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"colorpsdefid", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getColorPSDEFId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getColorPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"colorpsdefname", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getColorPSDEFName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getContentPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contentpsdefid", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getContentPSDEFId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getContentPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contentpsdefname", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getContentPSDEFName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getCreatePSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createpsdeactionid", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getCreatePSDEActionId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getCreatePSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createpsdeactionname", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getCreatePSDEActionName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getCreatePSDEOPPrivId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createpsdeopprivid", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getCreatePSDEOPPrivId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getCreatePSDEOPPrivName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createpsdeopprivname", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getCreatePSDEOPPrivName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getCustomCond() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcond", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getCustomCond()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getCustomType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customtype", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getCustomType()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getData2PSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"data2psdefid", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getData2PSDEFId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getData2PSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"data2psdefname", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getData2PSDEFName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getDataPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"datapsdefid", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getDataPSDEFId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getDataPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"datapsdefname", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getDataPSDEFName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getDynaClass() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynaclass", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getDynaClass()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getEditMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"editmode", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getEditMode()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getEnableViewActions() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableviewactions", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getEnableViewActions()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getEndPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endpsdefid", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getEndPSDEFId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getEndPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endpsdefname", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getEndPSDEFName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getFinishPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"finishpsdefid", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getFinishPSDEFId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getFinishPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"finishpsdefname", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getFinishPSDEFName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getGanttPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ganttpssyspfpluginid", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getGanttPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getGanttPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ganttpssyspfpluginname", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getGanttPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getIconPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconpsdefid", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getIconPSDEFId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getIconPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconpsdefname", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getIconPSDEFName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getItemStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemstyle", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getItemStyle()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getItemStyleText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemstyletext", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getItemStyleText()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getItemType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemtype", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getItemType()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getKeyPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"keypsdefid", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getKeyPSDEFId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getKeyPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"keypsdefname", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getKeyPSDEFName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getLevelPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"levelpsdefid", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getLevelPSDEFId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getLevelPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"levelpsdefname", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getLevelPSDEFName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getLinkPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkpsdefid", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getLinkPSDEFId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getLinkPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkpsdefname", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getLinkPSDEFName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getMaxSize() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxsize", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getMaxSize()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getModelObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelobj", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getModelObj()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getMovePSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"movepsdeactionid", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getMovePSDEActionId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getMovePSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"movepsdeactionname", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getMovePSDEActionName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getMovePSDEOPPrivId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"movepsdeopprivid", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getMovePSDEOPPrivId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getMovePSDEOPPrivName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"movepsdeopprivname", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getMovePSDEOPPrivName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getNamePSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"namepslanresid", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getNamePSLanResId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getNamePSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"namepslanresname", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getNamePSLanResName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getNavViewFilter() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewfilter", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getNavViewFilter()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getNavViewParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewparam", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getNavViewParam()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getOrderValuePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervaluepsdefid", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getOrderValuePSDEFId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getOrderValuePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervaluepsdefname", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getOrderValuePSDEFName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getPKeyPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkeypsdefid", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getPKeyPSDEFId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getPKeyPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkeypsdefname", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getPKeyPSDEFName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getPSDEDSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsid", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getPSDEDSId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getPSDEDSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsname", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getPSDEDSName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicid", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getPSDELogicId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicname", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getPSDELogicName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getPSDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psderid", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getPSDERId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getPSDERName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdername", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getPSDERName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getPSDEToolbarId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetoolbarid", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getPSDEToolbarId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getPSDEToolbarName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetoolbarname", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getPSDEToolbarName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getPSDEViewBaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbaseid", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getPSDEViewBaseId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getPSDEViewBaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbasename", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getPSDEViewBaseName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getPSSysCalendarId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscalendarid", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getPSSysCalendarId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getPSSysCalendarItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscalendaritemid", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getPSSysCalendarItemId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getPSSysCalendarItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscalendaritemname", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getPSSysCalendarItemName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getPSSysCalendarName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscalendarname", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getPSSysCalendarName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssid", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getPSSysCssId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssname", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getPSSysCssName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getPSSysImageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimageid", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getPSSysImageId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getPSSysImageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimagename", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getPSSysImageName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelid", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelname", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getRemovePSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"removepsdeactionid", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getRemovePSDEActionId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getRemovePSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"removepsdeactionname", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getRemovePSDEActionName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getRemovePSDEOPPrivId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"removepsdeopprivid", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getRemovePSDEOPPrivId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getRemovePSDEOPPrivName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"removepsdeopprivname", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getRemovePSDEOPPrivName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getTag2PSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tag2psdefid", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getTag2PSDEFId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getTag2PSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tag2psdefname", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getTag2PSDEFName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getTagPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tagpsdefid", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getTagPSDEFId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getTagPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tagpsdefname", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getTagPSDEFName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getTextPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"textpsdefid", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getTextPSDEFId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getTextPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"textpsdefname", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getTextPSDEFName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getTipsPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tipspsdefid", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getTipsPSDEFId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getTipsPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tipspsdefname", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getTipsPSDEFName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getTotalPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"totalpsdefid", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getTotalPSDEFId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getTotalPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"totalpsdefname", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getTotalPSDEFName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getUpdatePSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatepsdeactionid", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getUpdatePSDEActionId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getUpdatePSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatepsdeactionname", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getUpdatePSDEActionName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getUpdatePSDEOPPrivId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatepsdeopprivid", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getUpdatePSDEOPPrivId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getUpdatePSDEOPPrivName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatepsdeopprivname", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getUpdatePSDEOPPrivName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSSysCalendarItemBase.getViewActions() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewactions", (Object)PSSysCalendarItemBase.getJSONValue((Object)pSSysCalendarItemBase.getViewActions()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysCalendarItemBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysCalendarItemBase pSSysCalendarItemBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysCalendarItemBase.getAsyncPSDEDSId() != null) {
            object = pSSysCalendarItemBase.getAsyncPSDEDSId();
            xmlNode.setAttribute(FIELD_ASYNCPSDEDSID, (String)(object == null ? "" : object));
        }
        if (bl || pSSysCalendarItemBase.getAsyncPSDEDSName() != null) {
            object = pSSysCalendarItemBase.getAsyncPSDEDSName();
            xmlNode.setAttribute(FIELD_ASYNCPSDEDSNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSSysCalendarItemBase.getBeginPSDEFId() != null) {
            object = pSSysCalendarItemBase.getBeginPSDEFId();
            xmlNode.setAttribute(FIELD_BEGINPSDEFID, (String)(object == null ? "" : object));
        }
        if (bl || pSSysCalendarItemBase.getBeginPSDEFName() != null) {
            object = pSSysCalendarItemBase.getBeginPSDEFName();
            xmlNode.setAttribute(FIELD_BEGINPSDEFNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSSysCalendarItemBase.getBKColor() != null) {
            object = pSSysCalendarItemBase.getBKColor();
            xmlNode.setAttribute(FIELD_BKCOLOR, (String)(object == null ? "" : object));
        }
        if (bl || pSSysCalendarItemBase.getBKColorPSDEFId() != null) {
            object = pSSysCalendarItemBase.getBKColorPSDEFId();
            xmlNode.setAttribute(FIELD_BKCOLORPSDEFID, (String)(object == null ? "" : object));
        }
        if (bl || pSSysCalendarItemBase.getBKColorPSDEFName() != null) {
            object = pSSysCalendarItemBase.getBKColorPSDEFName();
            xmlNode.setAttribute(FIELD_BKCOLORPSDEFNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSSysCalendarItemBase.getClsPSDEFId() != null) {
            object = pSSysCalendarItemBase.getClsPSDEFId();
            xmlNode.setAttribute(FIELD_CLSPSDEFID, (String)(object == null ? "" : object));
        }
        if (bl || pSSysCalendarItemBase.getClsPSDEFName() != null) {
            object = pSSysCalendarItemBase.getClsPSDEFName();
            xmlNode.setAttribute(FIELD_CLSPSDEFNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSSysCalendarItemBase.getColor() != null) {
            object = pSSysCalendarItemBase.getColor();
            xmlNode.setAttribute(FIELD_COLOR, (String)(object == null ? "" : object));
        }
        if (bl || pSSysCalendarItemBase.getColorPSDEFId() != null) {
            object = pSSysCalendarItemBase.getColorPSDEFId();
            xmlNode.setAttribute(FIELD_COLORPSDEFID, (String)(object == null ? "" : object));
        }
        if (bl || pSSysCalendarItemBase.getColorPSDEFName() != null) {
            object = pSSysCalendarItemBase.getColorPSDEFName();
            xmlNode.setAttribute(FIELD_COLORPSDEFNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSSysCalendarItemBase.getContentPSDEFId() != null) {
            object = pSSysCalendarItemBase.getContentPSDEFId();
            xmlNode.setAttribute(FIELD_CONTENTPSDEFID, (String)(object == null ? "" : object));
        }
        if (bl || pSSysCalendarItemBase.getContentPSDEFName() != null) {
            object = pSSysCalendarItemBase.getContentPSDEFName();
            xmlNode.setAttribute(FIELD_CONTENTPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getCreateDate() != null) {
            object = pSSysCalendarItemBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysCalendarItemBase.getCreateMan() != null) {
            object = pSSysCalendarItemBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getCreatePSDEActionId() != null) {
            object = pSSysCalendarItemBase.getCreatePSDEActionId();
            xmlNode.setAttribute(FIELD_CREATEPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getCreatePSDEActionName() != null) {
            object = pSSysCalendarItemBase.getCreatePSDEActionName();
            xmlNode.setAttribute(FIELD_CREATEPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getCreatePSDEOPPrivId() != null) {
            object = pSSysCalendarItemBase.getCreatePSDEOPPrivId();
            xmlNode.setAttribute(FIELD_CREATEPSDEOPPRIVID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getCreatePSDEOPPrivName() != null) {
            object = pSSysCalendarItemBase.getCreatePSDEOPPrivName();
            xmlNode.setAttribute(FIELD_CREATEPSDEOPPRIVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getCustomCond() != null) {
            object = pSSysCalendarItemBase.getCustomCond();
            xmlNode.setAttribute(FIELD_CUSTOMCOND, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getCustomType() != null) {
            object = pSSysCalendarItemBase.getCustomType();
            xmlNode.setAttribute(FIELD_CUSTOMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getData2PSDEFId() != null) {
            object = pSSysCalendarItemBase.getData2PSDEFId();
            xmlNode.setAttribute(FIELD_DATA2PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getData2PSDEFName() != null) {
            object = pSSysCalendarItemBase.getData2PSDEFName();
            xmlNode.setAttribute(FIELD_DATA2PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getDataPSDEFId() != null) {
            object = pSSysCalendarItemBase.getDataPSDEFId();
            xmlNode.setAttribute(FIELD_DATAPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getDataPSDEFName() != null) {
            object = pSSysCalendarItemBase.getDataPSDEFName();
            xmlNode.setAttribute(FIELD_DATAPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getDynaClass() != null) {
            object = pSSysCalendarItemBase.getDynaClass();
            xmlNode.setAttribute(FIELD_DYNACLASS, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getEditMode() != null) {
            object = pSSysCalendarItemBase.getEditMode();
            xmlNode.setAttribute(FIELD_EDITMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysCalendarItemBase.getEnableViewActions() != null) {
            object = pSSysCalendarItemBase.getEnableViewActions();
            xmlNode.setAttribute(FIELD_ENABLEVIEWACTIONS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysCalendarItemBase.getEndPSDEFId() != null) {
            object = pSSysCalendarItemBase.getEndPSDEFId();
            xmlNode.setAttribute(FIELD_ENDPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getEndPSDEFName() != null) {
            object = pSSysCalendarItemBase.getEndPSDEFName();
            xmlNode.setAttribute(FIELD_ENDPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getFinishPSDEFId() != null) {
            object = pSSysCalendarItemBase.getFinishPSDEFId();
            xmlNode.setAttribute(FIELD_FINISHPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getFinishPSDEFName() != null) {
            object = pSSysCalendarItemBase.getFinishPSDEFName();
            xmlNode.setAttribute(FIELD_FINISHPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getGanttPSSysPFPluginId() != null) {
            object = pSSysCalendarItemBase.getGanttPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_GANTTPSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getGanttPSSysPFPluginName() != null) {
            object = pSSysCalendarItemBase.getGanttPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_GANTTPSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getIconPSDEFId() != null) {
            object = pSSysCalendarItemBase.getIconPSDEFId();
            xmlNode.setAttribute(FIELD_ICONPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getIconPSDEFName() != null) {
            object = pSSysCalendarItemBase.getIconPSDEFName();
            xmlNode.setAttribute(FIELD_ICONPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getItemStyle() != null) {
            object = pSSysCalendarItemBase.getItemStyle();
            xmlNode.setAttribute(FIELD_ITEMSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getItemStyleText() != null) {
            object = pSSysCalendarItemBase.getItemStyleText();
            xmlNode.setAttribute(FIELD_ITEMSTYLETEXT, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getItemType() != null) {
            object = pSSysCalendarItemBase.getItemType();
            xmlNode.setAttribute(FIELD_ITEMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getKeyPSDEFId() != null) {
            object = pSSysCalendarItemBase.getKeyPSDEFId();
            xmlNode.setAttribute(FIELD_KEYPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getKeyPSDEFName() != null) {
            object = pSSysCalendarItemBase.getKeyPSDEFName();
            xmlNode.setAttribute(FIELD_KEYPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getLevelPSDEFId() != null) {
            object = pSSysCalendarItemBase.getLevelPSDEFId();
            xmlNode.setAttribute(FIELD_LEVELPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getLevelPSDEFName() != null) {
            object = pSSysCalendarItemBase.getLevelPSDEFName();
            xmlNode.setAttribute(FIELD_LEVELPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getLinkPSDEFId() != null) {
            object = pSSysCalendarItemBase.getLinkPSDEFId();
            xmlNode.setAttribute(FIELD_LINKPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getLinkPSDEFName() != null) {
            object = pSSysCalendarItemBase.getLinkPSDEFName();
            xmlNode.setAttribute(FIELD_LINKPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getMaxSize() != null) {
            object = pSSysCalendarItemBase.getMaxSize();
            xmlNode.setAttribute(FIELD_MAXSIZE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysCalendarItemBase.getMemo() != null) {
            object = pSSysCalendarItemBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getModelObj() != null) {
            object = pSSysCalendarItemBase.getModelObj();
            xmlNode.setAttribute(FIELD_MODELOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getMovePSDEActionId() != null) {
            object = pSSysCalendarItemBase.getMovePSDEActionId();
            xmlNode.setAttribute(FIELD_MOVEPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getMovePSDEActionName() != null) {
            object = pSSysCalendarItemBase.getMovePSDEActionName();
            xmlNode.setAttribute(FIELD_MOVEPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getMovePSDEOPPrivId() != null) {
            object = pSSysCalendarItemBase.getMovePSDEOPPrivId();
            xmlNode.setAttribute(FIELD_MOVEPSDEOPPRIVID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getMovePSDEOPPrivName() != null) {
            object = pSSysCalendarItemBase.getMovePSDEOPPrivName();
            xmlNode.setAttribute(FIELD_MOVEPSDEOPPRIVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getNamePSLanResId() != null) {
            object = pSSysCalendarItemBase.getNamePSLanResId();
            xmlNode.setAttribute(FIELD_NAMEPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getNamePSLanResName() != null) {
            object = pSSysCalendarItemBase.getNamePSLanResName();
            xmlNode.setAttribute(FIELD_NAMEPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getNavViewFilter() != null) {
            object = pSSysCalendarItemBase.getNavViewFilter();
            xmlNode.setAttribute(FIELD_NAVVIEWFILTER, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getNavViewParam() != null) {
            object = pSSysCalendarItemBase.getNavViewParam();
            xmlNode.setAttribute(FIELD_NAVVIEWPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getOrderValue() != null) {
            object = pSSysCalendarItemBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysCalendarItemBase.getOrderValuePSDEFId() != null) {
            object = pSSysCalendarItemBase.getOrderValuePSDEFId();
            xmlNode.setAttribute(FIELD_ORDERVALUEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getOrderValuePSDEFName() != null) {
            object = pSSysCalendarItemBase.getOrderValuePSDEFName();
            xmlNode.setAttribute(FIELD_ORDERVALUEPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getPKeyPSDEFId() != null) {
            object = pSSysCalendarItemBase.getPKeyPSDEFId();
            xmlNode.setAttribute(FIELD_PKEYPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getPKeyPSDEFName() != null) {
            object = pSSysCalendarItemBase.getPKeyPSDEFName();
            xmlNode.setAttribute(FIELD_PKEYPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getPSDEDSId() != null) {
            object = pSSysCalendarItemBase.getPSDEDSId();
            xmlNode.setAttribute(FIELD_PSDEDSID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getPSDEDSName() != null) {
            object = pSSysCalendarItemBase.getPSDEDSName();
            xmlNode.setAttribute(FIELD_PSDEDSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getPSDEId() != null) {
            object = pSSysCalendarItemBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getPSDELogicId() != null) {
            object = pSSysCalendarItemBase.getPSDELogicId();
            xmlNode.setAttribute(FIELD_PSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getPSDELogicName() != null) {
            object = pSSysCalendarItemBase.getPSDELogicName();
            xmlNode.setAttribute(FIELD_PSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getPSDEName() != null) {
            object = pSSysCalendarItemBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getPSDERId() != null) {
            object = pSSysCalendarItemBase.getPSDERId();
            xmlNode.setAttribute(FIELD_PSDERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getPSDERName() != null) {
            object = pSSysCalendarItemBase.getPSDERName();
            xmlNode.setAttribute(FIELD_PSDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getPSDEToolbarId() != null) {
            object = pSSysCalendarItemBase.getPSDEToolbarId();
            xmlNode.setAttribute(FIELD_PSDETOOLBARID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getPSDEToolbarName() != null) {
            object = pSSysCalendarItemBase.getPSDEToolbarName();
            xmlNode.setAttribute(FIELD_PSDETOOLBARNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getPSDEViewBaseId() != null) {
            object = pSSysCalendarItemBase.getPSDEViewBaseId();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getPSDEViewBaseName() != null) {
            object = pSSysCalendarItemBase.getPSDEViewBaseName();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getPSSysCalendarId() != null) {
            object = pSSysCalendarItemBase.getPSSysCalendarId();
            xmlNode.setAttribute(FIELD_PSSYSCALENDARID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getPSSysCalendarItemId() != null) {
            object = pSSysCalendarItemBase.getPSSysCalendarItemId();
            xmlNode.setAttribute(FIELD_PSSYSCALENDARITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getPSSysCalendarItemName() != null) {
            object = pSSysCalendarItemBase.getPSSysCalendarItemName();
            xmlNode.setAttribute(FIELD_PSSYSCALENDARITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getPSSysCalendarName() != null) {
            object = pSSysCalendarItemBase.getPSSysCalendarName();
            xmlNode.setAttribute(FIELD_PSSYSCALENDARNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getPSSysCssId() != null) {
            object = pSSysCalendarItemBase.getPSSysCssId();
            xmlNode.setAttribute(FIELD_PSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getPSSysCssName() != null) {
            object = pSSysCalendarItemBase.getPSSysCssName();
            xmlNode.setAttribute(FIELD_PSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getPSSysImageId() != null) {
            object = pSSysCalendarItemBase.getPSSysImageId();
            xmlNode.setAttribute(FIELD_PSSYSIMAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getPSSysImageName() != null) {
            object = pSSysCalendarItemBase.getPSSysImageName();
            xmlNode.setAttribute(FIELD_PSSYSIMAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getPSSysPFPluginId() != null) {
            object = pSSysCalendarItemBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getPSSysPFPluginName() != null) {
            object = pSSysCalendarItemBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getPSSysViewPanelId() != null) {
            object = pSSysCalendarItemBase.getPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getPSSysViewPanelName() != null) {
            object = pSSysCalendarItemBase.getPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getRemovePSDEActionId() != null) {
            object = pSSysCalendarItemBase.getRemovePSDEActionId();
            xmlNode.setAttribute(FIELD_REMOVEPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getRemovePSDEActionName() != null) {
            object = pSSysCalendarItemBase.getRemovePSDEActionName();
            xmlNode.setAttribute(FIELD_REMOVEPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getRemovePSDEOPPrivId() != null) {
            object = pSSysCalendarItemBase.getRemovePSDEOPPrivId();
            xmlNode.setAttribute(FIELD_REMOVEPSDEOPPRIVID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getRemovePSDEOPPrivName() != null) {
            object = pSSysCalendarItemBase.getRemovePSDEOPPrivName();
            xmlNode.setAttribute(FIELD_REMOVEPSDEOPPRIVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getTag2PSDEFId() != null) {
            object = pSSysCalendarItemBase.getTag2PSDEFId();
            xmlNode.setAttribute(FIELD_TAG2PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getTag2PSDEFName() != null) {
            object = pSSysCalendarItemBase.getTag2PSDEFName();
            xmlNode.setAttribute(FIELD_TAG2PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getTagPSDEFId() != null) {
            object = pSSysCalendarItemBase.getTagPSDEFId();
            xmlNode.setAttribute(FIELD_TAGPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getTagPSDEFName() != null) {
            object = pSSysCalendarItemBase.getTagPSDEFName();
            xmlNode.setAttribute(FIELD_TAGPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getTextPSDEFId() != null) {
            object = pSSysCalendarItemBase.getTextPSDEFId();
            xmlNode.setAttribute(FIELD_TEXTPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getTextPSDEFName() != null) {
            object = pSSysCalendarItemBase.getTextPSDEFName();
            xmlNode.setAttribute(FIELD_TEXTPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getTipsPSDEFId() != null) {
            object = pSSysCalendarItemBase.getTipsPSDEFId();
            xmlNode.setAttribute(FIELD_TIPSPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getTipsPSDEFName() != null) {
            object = pSSysCalendarItemBase.getTipsPSDEFName();
            xmlNode.setAttribute(FIELD_TIPSPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getTotalPSDEFId() != null) {
            object = pSSysCalendarItemBase.getTotalPSDEFId();
            xmlNode.setAttribute(FIELD_TOTALPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getTotalPSDEFName() != null) {
            object = pSSysCalendarItemBase.getTotalPSDEFName();
            xmlNode.setAttribute(FIELD_TOTALPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getUpdateDate() != null) {
            object = pSSysCalendarItemBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysCalendarItemBase.getUpdateMan() != null) {
            object = pSSysCalendarItemBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getUpdatePSDEActionId() != null) {
            object = pSSysCalendarItemBase.getUpdatePSDEActionId();
            xmlNode.setAttribute(FIELD_UPDATEPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getUpdatePSDEActionName() != null) {
            object = pSSysCalendarItemBase.getUpdatePSDEActionName();
            xmlNode.setAttribute(FIELD_UPDATEPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getUpdatePSDEOPPrivId() != null) {
            object = pSSysCalendarItemBase.getUpdatePSDEOPPrivId();
            xmlNode.setAttribute(FIELD_UPDATEPSDEOPPRIVID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getUpdatePSDEOPPrivName() != null) {
            object = pSSysCalendarItemBase.getUpdatePSDEOPPrivName();
            xmlNode.setAttribute(FIELD_UPDATEPSDEOPPRIVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getUserCat() != null) {
            object = pSSysCalendarItemBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getUserTag() != null) {
            object = pSSysCalendarItemBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getUserTag2() != null) {
            object = pSSysCalendarItemBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getUserTag3() != null) {
            object = pSSysCalendarItemBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getUserTag4() != null) {
            object = pSSysCalendarItemBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemBase.getValidFlag() != null) {
            object = pSSysCalendarItemBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysCalendarItemBase.getViewActions() != null) {
            object = pSSysCalendarItemBase.getViewActions();
            xmlNode.setAttribute(FIELD_VIEWACTIONS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysCalendarItemBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysCalendarItemBase pSSysCalendarItemBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysCalendarItemBase.isAsyncPSDEDSIdDirty() && (bl || pSSysCalendarItemBase.getAsyncPSDEDSId() != null)) {
            iDataObject.set(FIELD_ASYNCPSDEDSID, (Object)pSSysCalendarItemBase.getAsyncPSDEDSId());
        }
        if (pSSysCalendarItemBase.isAsyncPSDEDSNameDirty() && (bl || pSSysCalendarItemBase.getAsyncPSDEDSName() != null)) {
            iDataObject.set(FIELD_ASYNCPSDEDSNAME, (Object)pSSysCalendarItemBase.getAsyncPSDEDSName());
        }
        if (pSSysCalendarItemBase.isBeginPSDEFIdDirty() && (bl || pSSysCalendarItemBase.getBeginPSDEFId() != null)) {
            iDataObject.set(FIELD_BEGINPSDEFID, (Object)pSSysCalendarItemBase.getBeginPSDEFId());
        }
        if (pSSysCalendarItemBase.isBeginPSDEFNameDirty() && (bl || pSSysCalendarItemBase.getBeginPSDEFName() != null)) {
            iDataObject.set(FIELD_BEGINPSDEFNAME, (Object)pSSysCalendarItemBase.getBeginPSDEFName());
        }
        if (pSSysCalendarItemBase.isBKColorDirty() && (bl || pSSysCalendarItemBase.getBKColor() != null)) {
            iDataObject.set(FIELD_BKCOLOR, (Object)pSSysCalendarItemBase.getBKColor());
        }
        if (pSSysCalendarItemBase.isBKColorPSDEFIdDirty() && (bl || pSSysCalendarItemBase.getBKColorPSDEFId() != null)) {
            iDataObject.set(FIELD_BKCOLORPSDEFID, (Object)pSSysCalendarItemBase.getBKColorPSDEFId());
        }
        if (pSSysCalendarItemBase.isBKColorPSDEFNameDirty() && (bl || pSSysCalendarItemBase.getBKColorPSDEFName() != null)) {
            iDataObject.set(FIELD_BKCOLORPSDEFNAME, (Object)pSSysCalendarItemBase.getBKColorPSDEFName());
        }
        if (pSSysCalendarItemBase.isClsPSDEFIdDirty() && (bl || pSSysCalendarItemBase.getClsPSDEFId() != null)) {
            iDataObject.set(FIELD_CLSPSDEFID, (Object)pSSysCalendarItemBase.getClsPSDEFId());
        }
        if (pSSysCalendarItemBase.isClsPSDEFNameDirty() && (bl || pSSysCalendarItemBase.getClsPSDEFName() != null)) {
            iDataObject.set(FIELD_CLSPSDEFNAME, (Object)pSSysCalendarItemBase.getClsPSDEFName());
        }
        if (pSSysCalendarItemBase.isColorDirty() && (bl || pSSysCalendarItemBase.getColor() != null)) {
            iDataObject.set(FIELD_COLOR, (Object)pSSysCalendarItemBase.getColor());
        }
        if (pSSysCalendarItemBase.isColorPSDEFIdDirty() && (bl || pSSysCalendarItemBase.getColorPSDEFId() != null)) {
            iDataObject.set(FIELD_COLORPSDEFID, (Object)pSSysCalendarItemBase.getColorPSDEFId());
        }
        if (pSSysCalendarItemBase.isColorPSDEFNameDirty() && (bl || pSSysCalendarItemBase.getColorPSDEFName() != null)) {
            iDataObject.set(FIELD_COLORPSDEFNAME, (Object)pSSysCalendarItemBase.getColorPSDEFName());
        }
        if (pSSysCalendarItemBase.isContentPSDEFIdDirty() && (bl || pSSysCalendarItemBase.getContentPSDEFId() != null)) {
            iDataObject.set(FIELD_CONTENTPSDEFID, (Object)pSSysCalendarItemBase.getContentPSDEFId());
        }
        if (pSSysCalendarItemBase.isContentPSDEFNameDirty() && (bl || pSSysCalendarItemBase.getContentPSDEFName() != null)) {
            iDataObject.set(FIELD_CONTENTPSDEFNAME, (Object)pSSysCalendarItemBase.getContentPSDEFName());
        }
        if (pSSysCalendarItemBase.isCreateDateDirty() && (bl || pSSysCalendarItemBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysCalendarItemBase.getCreateDate());
        }
        if (pSSysCalendarItemBase.isCreateManDirty() && (bl || pSSysCalendarItemBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysCalendarItemBase.getCreateMan());
        }
        if (pSSysCalendarItemBase.isCreatePSDEActionIdDirty() && (bl || pSSysCalendarItemBase.getCreatePSDEActionId() != null)) {
            iDataObject.set(FIELD_CREATEPSDEACTIONID, (Object)pSSysCalendarItemBase.getCreatePSDEActionId());
        }
        if (pSSysCalendarItemBase.isCreatePSDEActionNameDirty() && (bl || pSSysCalendarItemBase.getCreatePSDEActionName() != null)) {
            iDataObject.set(FIELD_CREATEPSDEACTIONNAME, (Object)pSSysCalendarItemBase.getCreatePSDEActionName());
        }
        if (pSSysCalendarItemBase.isCreatePSDEOPPrivIdDirty() && (bl || pSSysCalendarItemBase.getCreatePSDEOPPrivId() != null)) {
            iDataObject.set(FIELD_CREATEPSDEOPPRIVID, (Object)pSSysCalendarItemBase.getCreatePSDEOPPrivId());
        }
        if (pSSysCalendarItemBase.isCreatePSDEOPPrivNameDirty() && (bl || pSSysCalendarItemBase.getCreatePSDEOPPrivName() != null)) {
            iDataObject.set(FIELD_CREATEPSDEOPPRIVNAME, (Object)pSSysCalendarItemBase.getCreatePSDEOPPrivName());
        }
        if (pSSysCalendarItemBase.isCustomCondDirty() && (bl || pSSysCalendarItemBase.getCustomCond() != null)) {
            iDataObject.set(FIELD_CUSTOMCOND, (Object)pSSysCalendarItemBase.getCustomCond());
        }
        if (pSSysCalendarItemBase.isCustomTypeDirty() && (bl || pSSysCalendarItemBase.getCustomType() != null)) {
            iDataObject.set(FIELD_CUSTOMTYPE, (Object)pSSysCalendarItemBase.getCustomType());
        }
        if (pSSysCalendarItemBase.isData2PSDEFIdDirty() && (bl || pSSysCalendarItemBase.getData2PSDEFId() != null)) {
            iDataObject.set(FIELD_DATA2PSDEFID, (Object)pSSysCalendarItemBase.getData2PSDEFId());
        }
        if (pSSysCalendarItemBase.isData2PSDEFNameDirty() && (bl || pSSysCalendarItemBase.getData2PSDEFName() != null)) {
            iDataObject.set(FIELD_DATA2PSDEFNAME, (Object)pSSysCalendarItemBase.getData2PSDEFName());
        }
        if (pSSysCalendarItemBase.isDataPSDEFIdDirty() && (bl || pSSysCalendarItemBase.getDataPSDEFId() != null)) {
            iDataObject.set(FIELD_DATAPSDEFID, (Object)pSSysCalendarItemBase.getDataPSDEFId());
        }
        if (pSSysCalendarItemBase.isDataPSDEFNameDirty() && (bl || pSSysCalendarItemBase.getDataPSDEFName() != null)) {
            iDataObject.set(FIELD_DATAPSDEFNAME, (Object)pSSysCalendarItemBase.getDataPSDEFName());
        }
        if (pSSysCalendarItemBase.isDynaClassDirty() && (bl || pSSysCalendarItemBase.getDynaClass() != null)) {
            iDataObject.set(FIELD_DYNACLASS, (Object)pSSysCalendarItemBase.getDynaClass());
        }
        if (pSSysCalendarItemBase.isEditModeDirty() && (bl || pSSysCalendarItemBase.getEditMode() != null)) {
            iDataObject.set(FIELD_EDITMODE, (Object)pSSysCalendarItemBase.getEditMode());
        }
        if (pSSysCalendarItemBase.isEnableViewActionsDirty() && (bl || pSSysCalendarItemBase.getEnableViewActions() != null)) {
            iDataObject.set(FIELD_ENABLEVIEWACTIONS, (Object)pSSysCalendarItemBase.getEnableViewActions());
        }
        if (pSSysCalendarItemBase.isEndPSDEFIdDirty() && (bl || pSSysCalendarItemBase.getEndPSDEFId() != null)) {
            iDataObject.set(FIELD_ENDPSDEFID, (Object)pSSysCalendarItemBase.getEndPSDEFId());
        }
        if (pSSysCalendarItemBase.isEndPSDEFNameDirty() && (bl || pSSysCalendarItemBase.getEndPSDEFName() != null)) {
            iDataObject.set(FIELD_ENDPSDEFNAME, (Object)pSSysCalendarItemBase.getEndPSDEFName());
        }
        if (pSSysCalendarItemBase.isFinishPSDEFIdDirty() && (bl || pSSysCalendarItemBase.getFinishPSDEFId() != null)) {
            iDataObject.set(FIELD_FINISHPSDEFID, (Object)pSSysCalendarItemBase.getFinishPSDEFId());
        }
        if (pSSysCalendarItemBase.isFinishPSDEFNameDirty() && (bl || pSSysCalendarItemBase.getFinishPSDEFName() != null)) {
            iDataObject.set(FIELD_FINISHPSDEFNAME, (Object)pSSysCalendarItemBase.getFinishPSDEFName());
        }
        if (pSSysCalendarItemBase.isGanttPSSysPFPluginIdDirty() && (bl || pSSysCalendarItemBase.getGanttPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_GANTTPSSYSPFPLUGINID, (Object)pSSysCalendarItemBase.getGanttPSSysPFPluginId());
        }
        if (pSSysCalendarItemBase.isGanttPSSysPFPluginNameDirty() && (bl || pSSysCalendarItemBase.getGanttPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_GANTTPSSYSPFPLUGINNAME, (Object)pSSysCalendarItemBase.getGanttPSSysPFPluginName());
        }
        if (pSSysCalendarItemBase.isIconPSDEFIdDirty() && (bl || pSSysCalendarItemBase.getIconPSDEFId() != null)) {
            iDataObject.set(FIELD_ICONPSDEFID, (Object)pSSysCalendarItemBase.getIconPSDEFId());
        }
        if (pSSysCalendarItemBase.isIconPSDEFNameDirty() && (bl || pSSysCalendarItemBase.getIconPSDEFName() != null)) {
            iDataObject.set(FIELD_ICONPSDEFNAME, (Object)pSSysCalendarItemBase.getIconPSDEFName());
        }
        if (pSSysCalendarItemBase.isItemStyleDirty() && (bl || pSSysCalendarItemBase.getItemStyle() != null)) {
            iDataObject.set(FIELD_ITEMSTYLE, (Object)pSSysCalendarItemBase.getItemStyle());
        }
        if (pSSysCalendarItemBase.isItemStyleTextDirty() && (bl || pSSysCalendarItemBase.getItemStyleText() != null)) {
            iDataObject.set(FIELD_ITEMSTYLETEXT, (Object)pSSysCalendarItemBase.getItemStyleText());
        }
        if (pSSysCalendarItemBase.isItemTypeDirty() && (bl || pSSysCalendarItemBase.getItemType() != null)) {
            iDataObject.set(FIELD_ITEMTYPE, (Object)pSSysCalendarItemBase.getItemType());
        }
        if (pSSysCalendarItemBase.isKeyPSDEFIdDirty() && (bl || pSSysCalendarItemBase.getKeyPSDEFId() != null)) {
            iDataObject.set(FIELD_KEYPSDEFID, (Object)pSSysCalendarItemBase.getKeyPSDEFId());
        }
        if (pSSysCalendarItemBase.isKeyPSDEFNameDirty() && (bl || pSSysCalendarItemBase.getKeyPSDEFName() != null)) {
            iDataObject.set(FIELD_KEYPSDEFNAME, (Object)pSSysCalendarItemBase.getKeyPSDEFName());
        }
        if (pSSysCalendarItemBase.isLevelPSDEFIdDirty() && (bl || pSSysCalendarItemBase.getLevelPSDEFId() != null)) {
            iDataObject.set(FIELD_LEVELPSDEFID, (Object)pSSysCalendarItemBase.getLevelPSDEFId());
        }
        if (pSSysCalendarItemBase.isLevelPSDEFNameDirty() && (bl || pSSysCalendarItemBase.getLevelPSDEFName() != null)) {
            iDataObject.set(FIELD_LEVELPSDEFNAME, (Object)pSSysCalendarItemBase.getLevelPSDEFName());
        }
        if (pSSysCalendarItemBase.isLinkPSDEFIdDirty() && (bl || pSSysCalendarItemBase.getLinkPSDEFId() != null)) {
            iDataObject.set(FIELD_LINKPSDEFID, (Object)pSSysCalendarItemBase.getLinkPSDEFId());
        }
        if (pSSysCalendarItemBase.isLinkPSDEFNameDirty() && (bl || pSSysCalendarItemBase.getLinkPSDEFName() != null)) {
            iDataObject.set(FIELD_LINKPSDEFNAME, (Object)pSSysCalendarItemBase.getLinkPSDEFName());
        }
        if (pSSysCalendarItemBase.isMaxSizeDirty() && (bl || pSSysCalendarItemBase.getMaxSize() != null)) {
            iDataObject.set(FIELD_MAXSIZE, (Object)pSSysCalendarItemBase.getMaxSize());
        }
        if (pSSysCalendarItemBase.isMemoDirty() && (bl || pSSysCalendarItemBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysCalendarItemBase.getMemo());
        }
        if (pSSysCalendarItemBase.isModelObjDirty() && (bl || pSSysCalendarItemBase.getModelObj() != null)) {
            iDataObject.set(FIELD_MODELOBJ, (Object)pSSysCalendarItemBase.getModelObj());
        }
        if (pSSysCalendarItemBase.isMovePSDEActionIdDirty() && (bl || pSSysCalendarItemBase.getMovePSDEActionId() != null)) {
            iDataObject.set(FIELD_MOVEPSDEACTIONID, (Object)pSSysCalendarItemBase.getMovePSDEActionId());
        }
        if (pSSysCalendarItemBase.isMovePSDEActionNameDirty() && (bl || pSSysCalendarItemBase.getMovePSDEActionName() != null)) {
            iDataObject.set(FIELD_MOVEPSDEACTIONNAME, (Object)pSSysCalendarItemBase.getMovePSDEActionName());
        }
        if (pSSysCalendarItemBase.isMovePSDEOPPrivIdDirty() && (bl || pSSysCalendarItemBase.getMovePSDEOPPrivId() != null)) {
            iDataObject.set(FIELD_MOVEPSDEOPPRIVID, (Object)pSSysCalendarItemBase.getMovePSDEOPPrivId());
        }
        if (pSSysCalendarItemBase.isMovePSDEOPPrivNameDirty() && (bl || pSSysCalendarItemBase.getMovePSDEOPPrivName() != null)) {
            iDataObject.set(FIELD_MOVEPSDEOPPRIVNAME, (Object)pSSysCalendarItemBase.getMovePSDEOPPrivName());
        }
        if (pSSysCalendarItemBase.isNamePSLanResIdDirty() && (bl || pSSysCalendarItemBase.getNamePSLanResId() != null)) {
            iDataObject.set(FIELD_NAMEPSLANRESID, (Object)pSSysCalendarItemBase.getNamePSLanResId());
        }
        if (pSSysCalendarItemBase.isNamePSLanResNameDirty() && (bl || pSSysCalendarItemBase.getNamePSLanResName() != null)) {
            iDataObject.set(FIELD_NAMEPSLANRESNAME, (Object)pSSysCalendarItemBase.getNamePSLanResName());
        }
        if (pSSysCalendarItemBase.isNavViewFilterDirty() && (bl || pSSysCalendarItemBase.getNavViewFilter() != null)) {
            iDataObject.set(FIELD_NAVVIEWFILTER, (Object)pSSysCalendarItemBase.getNavViewFilter());
        }
        if (pSSysCalendarItemBase.isNavViewParamDirty() && (bl || pSSysCalendarItemBase.getNavViewParam() != null)) {
            iDataObject.set(FIELD_NAVVIEWPARAM, (Object)pSSysCalendarItemBase.getNavViewParam());
        }
        if (pSSysCalendarItemBase.isOrderValueDirty() && (bl || pSSysCalendarItemBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysCalendarItemBase.getOrderValue());
        }
        if (pSSysCalendarItemBase.isOrderValuePSDEFIdDirty() && (bl || pSSysCalendarItemBase.getOrderValuePSDEFId() != null)) {
            iDataObject.set(FIELD_ORDERVALUEPSDEFID, (Object)pSSysCalendarItemBase.getOrderValuePSDEFId());
        }
        if (pSSysCalendarItemBase.isOrderValuePSDEFNameDirty() && (bl || pSSysCalendarItemBase.getOrderValuePSDEFName() != null)) {
            iDataObject.set(FIELD_ORDERVALUEPSDEFNAME, (Object)pSSysCalendarItemBase.getOrderValuePSDEFName());
        }
        if (pSSysCalendarItemBase.isPKeyPSDEFIdDirty() && (bl || pSSysCalendarItemBase.getPKeyPSDEFId() != null)) {
            iDataObject.set(FIELD_PKEYPSDEFID, (Object)pSSysCalendarItemBase.getPKeyPSDEFId());
        }
        if (pSSysCalendarItemBase.isPKeyPSDEFNameDirty() && (bl || pSSysCalendarItemBase.getPKeyPSDEFName() != null)) {
            iDataObject.set(FIELD_PKEYPSDEFNAME, (Object)pSSysCalendarItemBase.getPKeyPSDEFName());
        }
        if (pSSysCalendarItemBase.isPSDEDSIdDirty() && (bl || pSSysCalendarItemBase.getPSDEDSId() != null)) {
            iDataObject.set(FIELD_PSDEDSID, (Object)pSSysCalendarItemBase.getPSDEDSId());
        }
        if (pSSysCalendarItemBase.isPSDEDSNameDirty() && (bl || pSSysCalendarItemBase.getPSDEDSName() != null)) {
            iDataObject.set(FIELD_PSDEDSNAME, (Object)pSSysCalendarItemBase.getPSDEDSName());
        }
        if (pSSysCalendarItemBase.isPSDEIdDirty() && (bl || pSSysCalendarItemBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysCalendarItemBase.getPSDEId());
        }
        if (pSSysCalendarItemBase.isPSDELogicIdDirty() && (bl || pSSysCalendarItemBase.getPSDELogicId() != null)) {
            iDataObject.set(FIELD_PSDELOGICID, (Object)pSSysCalendarItemBase.getPSDELogicId());
        }
        if (pSSysCalendarItemBase.isPSDELogicNameDirty() && (bl || pSSysCalendarItemBase.getPSDELogicName() != null)) {
            iDataObject.set(FIELD_PSDELOGICNAME, (Object)pSSysCalendarItemBase.getPSDELogicName());
        }
        if (pSSysCalendarItemBase.isPSDENameDirty() && (bl || pSSysCalendarItemBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysCalendarItemBase.getPSDEName());
        }
        if (pSSysCalendarItemBase.isPSDERIdDirty() && (bl || pSSysCalendarItemBase.getPSDERId() != null)) {
            iDataObject.set(FIELD_PSDERID, (Object)pSSysCalendarItemBase.getPSDERId());
        }
        if (pSSysCalendarItemBase.isPSDERNameDirty() && (bl || pSSysCalendarItemBase.getPSDERName() != null)) {
            iDataObject.set(FIELD_PSDERNAME, (Object)pSSysCalendarItemBase.getPSDERName());
        }
        if (pSSysCalendarItemBase.isPSDEToolbarIdDirty() && (bl || pSSysCalendarItemBase.getPSDEToolbarId() != null)) {
            iDataObject.set(FIELD_PSDETOOLBARID, (Object)pSSysCalendarItemBase.getPSDEToolbarId());
        }
        if (pSSysCalendarItemBase.isPSDEToolbarNameDirty() && (bl || pSSysCalendarItemBase.getPSDEToolbarName() != null)) {
            iDataObject.set(FIELD_PSDETOOLBARNAME, (Object)pSSysCalendarItemBase.getPSDEToolbarName());
        }
        if (pSSysCalendarItemBase.isPSDEViewBaseIdDirty() && (bl || pSSysCalendarItemBase.getPSDEViewBaseId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASEID, (Object)pSSysCalendarItemBase.getPSDEViewBaseId());
        }
        if (pSSysCalendarItemBase.isPSDEViewBaseNameDirty() && (bl || pSSysCalendarItemBase.getPSDEViewBaseName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASENAME, (Object)pSSysCalendarItemBase.getPSDEViewBaseName());
        }
        if (pSSysCalendarItemBase.isPSSysCalendarIdDirty() && (bl || pSSysCalendarItemBase.getPSSysCalendarId() != null)) {
            iDataObject.set(FIELD_PSSYSCALENDARID, (Object)pSSysCalendarItemBase.getPSSysCalendarId());
        }
        if (pSSysCalendarItemBase.isPSSysCalendarItemIdDirty() && (bl || pSSysCalendarItemBase.getPSSysCalendarItemId() != null)) {
            iDataObject.set(FIELD_PSSYSCALENDARITEMID, (Object)pSSysCalendarItemBase.getPSSysCalendarItemId());
        }
        if (pSSysCalendarItemBase.isPSSysCalendarItemNameDirty() && (bl || pSSysCalendarItemBase.getPSSysCalendarItemName() != null)) {
            iDataObject.set(FIELD_PSSYSCALENDARITEMNAME, (Object)pSSysCalendarItemBase.getPSSysCalendarItemName());
        }
        if (pSSysCalendarItemBase.isPSSysCalendarNameDirty() && (bl || pSSysCalendarItemBase.getPSSysCalendarName() != null)) {
            iDataObject.set(FIELD_PSSYSCALENDARNAME, (Object)pSSysCalendarItemBase.getPSSysCalendarName());
        }
        if (pSSysCalendarItemBase.isPSSysCssIdDirty() && (bl || pSSysCalendarItemBase.getPSSysCssId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSID, (Object)pSSysCalendarItemBase.getPSSysCssId());
        }
        if (pSSysCalendarItemBase.isPSSysCssNameDirty() && (bl || pSSysCalendarItemBase.getPSSysCssName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSNAME, (Object)pSSysCalendarItemBase.getPSSysCssName());
        }
        if (pSSysCalendarItemBase.isPSSysImageIdDirty() && (bl || pSSysCalendarItemBase.getPSSysImageId() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGEID, (Object)pSSysCalendarItemBase.getPSSysImageId());
        }
        if (pSSysCalendarItemBase.isPSSysImageNameDirty() && (bl || pSSysCalendarItemBase.getPSSysImageName() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGENAME, (Object)pSSysCalendarItemBase.getPSSysImageName());
        }
        if (pSSysCalendarItemBase.isPSSysPFPluginIdDirty() && (bl || pSSysCalendarItemBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSSysCalendarItemBase.getPSSysPFPluginId());
        }
        if (pSSysCalendarItemBase.isPSSysPFPluginNameDirty() && (bl || pSSysCalendarItemBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSSysCalendarItemBase.getPSSysPFPluginName());
        }
        if (pSSysCalendarItemBase.isPSSysViewPanelIdDirty() && (bl || pSSysCalendarItemBase.getPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELID, (Object)pSSysCalendarItemBase.getPSSysViewPanelId());
        }
        if (pSSysCalendarItemBase.isPSSysViewPanelNameDirty() && (bl || pSSysCalendarItemBase.getPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELNAME, (Object)pSSysCalendarItemBase.getPSSysViewPanelName());
        }
        if (pSSysCalendarItemBase.isRemovePSDEActionIdDirty() && (bl || pSSysCalendarItemBase.getRemovePSDEActionId() != null)) {
            iDataObject.set(FIELD_REMOVEPSDEACTIONID, (Object)pSSysCalendarItemBase.getRemovePSDEActionId());
        }
        if (pSSysCalendarItemBase.isRemovePSDEActionNameDirty() && (bl || pSSysCalendarItemBase.getRemovePSDEActionName() != null)) {
            iDataObject.set(FIELD_REMOVEPSDEACTIONNAME, (Object)pSSysCalendarItemBase.getRemovePSDEActionName());
        }
        if (pSSysCalendarItemBase.isRemovePSDEOPPrivIdDirty() && (bl || pSSysCalendarItemBase.getRemovePSDEOPPrivId() != null)) {
            iDataObject.set(FIELD_REMOVEPSDEOPPRIVID, (Object)pSSysCalendarItemBase.getRemovePSDEOPPrivId());
        }
        if (pSSysCalendarItemBase.isRemovePSDEOPPrivNameDirty() && (bl || pSSysCalendarItemBase.getRemovePSDEOPPrivName() != null)) {
            iDataObject.set(FIELD_REMOVEPSDEOPPRIVNAME, (Object)pSSysCalendarItemBase.getRemovePSDEOPPrivName());
        }
        if (pSSysCalendarItemBase.isTag2PSDEFIdDirty() && (bl || pSSysCalendarItemBase.getTag2PSDEFId() != null)) {
            iDataObject.set(FIELD_TAG2PSDEFID, (Object)pSSysCalendarItemBase.getTag2PSDEFId());
        }
        if (pSSysCalendarItemBase.isTag2PSDEFNameDirty() && (bl || pSSysCalendarItemBase.getTag2PSDEFName() != null)) {
            iDataObject.set(FIELD_TAG2PSDEFNAME, (Object)pSSysCalendarItemBase.getTag2PSDEFName());
        }
        if (pSSysCalendarItemBase.isTagPSDEFIdDirty() && (bl || pSSysCalendarItemBase.getTagPSDEFId() != null)) {
            iDataObject.set(FIELD_TAGPSDEFID, (Object)pSSysCalendarItemBase.getTagPSDEFId());
        }
        if (pSSysCalendarItemBase.isTagPSDEFNameDirty() && (bl || pSSysCalendarItemBase.getTagPSDEFName() != null)) {
            iDataObject.set(FIELD_TAGPSDEFNAME, (Object)pSSysCalendarItemBase.getTagPSDEFName());
        }
        if (pSSysCalendarItemBase.isTextPSDEFIdDirty() && (bl || pSSysCalendarItemBase.getTextPSDEFId() != null)) {
            iDataObject.set(FIELD_TEXTPSDEFID, (Object)pSSysCalendarItemBase.getTextPSDEFId());
        }
        if (pSSysCalendarItemBase.isTextPSDEFNameDirty() && (bl || pSSysCalendarItemBase.getTextPSDEFName() != null)) {
            iDataObject.set(FIELD_TEXTPSDEFNAME, (Object)pSSysCalendarItemBase.getTextPSDEFName());
        }
        if (pSSysCalendarItemBase.isTipsPSDEFIdDirty() && (bl || pSSysCalendarItemBase.getTipsPSDEFId() != null)) {
            iDataObject.set(FIELD_TIPSPSDEFID, (Object)pSSysCalendarItemBase.getTipsPSDEFId());
        }
        if (pSSysCalendarItemBase.isTipsPSDEFNameDirty() && (bl || pSSysCalendarItemBase.getTipsPSDEFName() != null)) {
            iDataObject.set(FIELD_TIPSPSDEFNAME, (Object)pSSysCalendarItemBase.getTipsPSDEFName());
        }
        if (pSSysCalendarItemBase.isTotalPSDEFIdDirty() && (bl || pSSysCalendarItemBase.getTotalPSDEFId() != null)) {
            iDataObject.set(FIELD_TOTALPSDEFID, (Object)pSSysCalendarItemBase.getTotalPSDEFId());
        }
        if (pSSysCalendarItemBase.isTotalPSDEFNameDirty() && (bl || pSSysCalendarItemBase.getTotalPSDEFName() != null)) {
            iDataObject.set(FIELD_TOTALPSDEFNAME, (Object)pSSysCalendarItemBase.getTotalPSDEFName());
        }
        if (pSSysCalendarItemBase.isUpdateDateDirty() && (bl || pSSysCalendarItemBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysCalendarItemBase.getUpdateDate());
        }
        if (pSSysCalendarItemBase.isUpdateManDirty() && (bl || pSSysCalendarItemBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysCalendarItemBase.getUpdateMan());
        }
        if (pSSysCalendarItemBase.isUpdatePSDEActionIdDirty() && (bl || pSSysCalendarItemBase.getUpdatePSDEActionId() != null)) {
            iDataObject.set(FIELD_UPDATEPSDEACTIONID, (Object)pSSysCalendarItemBase.getUpdatePSDEActionId());
        }
        if (pSSysCalendarItemBase.isUpdatePSDEActionNameDirty() && (bl || pSSysCalendarItemBase.getUpdatePSDEActionName() != null)) {
            iDataObject.set(FIELD_UPDATEPSDEACTIONNAME, (Object)pSSysCalendarItemBase.getUpdatePSDEActionName());
        }
        if (pSSysCalendarItemBase.isUpdatePSDEOPPrivIdDirty() && (bl || pSSysCalendarItemBase.getUpdatePSDEOPPrivId() != null)) {
            iDataObject.set(FIELD_UPDATEPSDEOPPRIVID, (Object)pSSysCalendarItemBase.getUpdatePSDEOPPrivId());
        }
        if (pSSysCalendarItemBase.isUpdatePSDEOPPrivNameDirty() && (bl || pSSysCalendarItemBase.getUpdatePSDEOPPrivName() != null)) {
            iDataObject.set(FIELD_UPDATEPSDEOPPRIVNAME, (Object)pSSysCalendarItemBase.getUpdatePSDEOPPrivName());
        }
        if (pSSysCalendarItemBase.isUserCatDirty() && (bl || pSSysCalendarItemBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysCalendarItemBase.getUserCat());
        }
        if (pSSysCalendarItemBase.isUserTagDirty() && (bl || pSSysCalendarItemBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysCalendarItemBase.getUserTag());
        }
        if (pSSysCalendarItemBase.isUserTag2Dirty() && (bl || pSSysCalendarItemBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysCalendarItemBase.getUserTag2());
        }
        if (pSSysCalendarItemBase.isUserTag3Dirty() && (bl || pSSysCalendarItemBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysCalendarItemBase.getUserTag3());
        }
        if (pSSysCalendarItemBase.isUserTag4Dirty() && (bl || pSSysCalendarItemBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysCalendarItemBase.getUserTag4());
        }
        if (pSSysCalendarItemBase.isValidFlagDirty() && (bl || pSSysCalendarItemBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysCalendarItemBase.getValidFlag());
        }
        if (pSSysCalendarItemBase.isViewActionsDirty() && (bl || pSSysCalendarItemBase.getViewActions() != null)) {
            iDataObject.set(FIELD_VIEWACTIONS, (Object)pSSysCalendarItemBase.getViewActions());
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
        return PSSysCalendarItemBase.remove(this, n);
    }

    private static boolean remove(PSSysCalendarItemBase pSSysCalendarItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysCalendarItemBase.resetAsyncPSDEDSId();
                return true;
            }
            case 1: {
                pSSysCalendarItemBase.resetAsyncPSDEDSName();
                return true;
            }
            case 2: {
                pSSysCalendarItemBase.resetBeginPSDEFId();
                return true;
            }
            case 3: {
                pSSysCalendarItemBase.resetBeginPSDEFName();
                return true;
            }
            case 4: {
                pSSysCalendarItemBase.resetBKColor();
                return true;
            }
            case 5: {
                pSSysCalendarItemBase.resetBKColorPSDEFId();
                return true;
            }
            case 6: {
                pSSysCalendarItemBase.resetBKColorPSDEFName();
                return true;
            }
            case 7: {
                pSSysCalendarItemBase.resetClsPSDEFId();
                return true;
            }
            case 8: {
                pSSysCalendarItemBase.resetClsPSDEFName();
                return true;
            }
            case 9: {
                pSSysCalendarItemBase.resetColor();
                return true;
            }
            case 10: {
                pSSysCalendarItemBase.resetColorPSDEFId();
                return true;
            }
            case 11: {
                pSSysCalendarItemBase.resetColorPSDEFName();
                return true;
            }
            case 12: {
                pSSysCalendarItemBase.resetContentPSDEFId();
                return true;
            }
            case 13: {
                pSSysCalendarItemBase.resetContentPSDEFName();
                return true;
            }
            case 14: {
                pSSysCalendarItemBase.resetCreateDate();
                return true;
            }
            case 15: {
                pSSysCalendarItemBase.resetCreateMan();
                return true;
            }
            case 16: {
                pSSysCalendarItemBase.resetCreatePSDEActionId();
                return true;
            }
            case 17: {
                pSSysCalendarItemBase.resetCreatePSDEActionName();
                return true;
            }
            case 18: {
                pSSysCalendarItemBase.resetCreatePSDEOPPrivId();
                return true;
            }
            case 19: {
                pSSysCalendarItemBase.resetCreatePSDEOPPrivName();
                return true;
            }
            case 20: {
                pSSysCalendarItemBase.resetCustomCond();
                return true;
            }
            case 21: {
                pSSysCalendarItemBase.resetCustomType();
                return true;
            }
            case 22: {
                pSSysCalendarItemBase.resetData2PSDEFId();
                return true;
            }
            case 23: {
                pSSysCalendarItemBase.resetData2PSDEFName();
                return true;
            }
            case 24: {
                pSSysCalendarItemBase.resetDataPSDEFId();
                return true;
            }
            case 25: {
                pSSysCalendarItemBase.resetDataPSDEFName();
                return true;
            }
            case 26: {
                pSSysCalendarItemBase.resetDynaClass();
                return true;
            }
            case 27: {
                pSSysCalendarItemBase.resetEditMode();
                return true;
            }
            case 28: {
                pSSysCalendarItemBase.resetEnableViewActions();
                return true;
            }
            case 29: {
                pSSysCalendarItemBase.resetEndPSDEFId();
                return true;
            }
            case 30: {
                pSSysCalendarItemBase.resetEndPSDEFName();
                return true;
            }
            case 31: {
                pSSysCalendarItemBase.resetFinishPSDEFId();
                return true;
            }
            case 32: {
                pSSysCalendarItemBase.resetFinishPSDEFName();
                return true;
            }
            case 33: {
                pSSysCalendarItemBase.resetGanttPSSysPFPluginId();
                return true;
            }
            case 34: {
                pSSysCalendarItemBase.resetGanttPSSysPFPluginName();
                return true;
            }
            case 35: {
                pSSysCalendarItemBase.resetIconPSDEFId();
                return true;
            }
            case 36: {
                pSSysCalendarItemBase.resetIconPSDEFName();
                return true;
            }
            case 37: {
                pSSysCalendarItemBase.resetItemStyle();
                return true;
            }
            case 38: {
                pSSysCalendarItemBase.resetItemStyleText();
                return true;
            }
            case 39: {
                pSSysCalendarItemBase.resetItemType();
                return true;
            }
            case 40: {
                pSSysCalendarItemBase.resetKeyPSDEFId();
                return true;
            }
            case 41: {
                pSSysCalendarItemBase.resetKeyPSDEFName();
                return true;
            }
            case 42: {
                pSSysCalendarItemBase.resetLevelPSDEFId();
                return true;
            }
            case 43: {
                pSSysCalendarItemBase.resetLevelPSDEFName();
                return true;
            }
            case 44: {
                pSSysCalendarItemBase.resetLinkPSDEFId();
                return true;
            }
            case 45: {
                pSSysCalendarItemBase.resetLinkPSDEFName();
                return true;
            }
            case 46: {
                pSSysCalendarItemBase.resetMaxSize();
                return true;
            }
            case 47: {
                pSSysCalendarItemBase.resetMemo();
                return true;
            }
            case 48: {
                pSSysCalendarItemBase.resetModelObj();
                return true;
            }
            case 49: {
                pSSysCalendarItemBase.resetMovePSDEActionId();
                return true;
            }
            case 50: {
                pSSysCalendarItemBase.resetMovePSDEActionName();
                return true;
            }
            case 51: {
                pSSysCalendarItemBase.resetMovePSDEOPPrivId();
                return true;
            }
            case 52: {
                pSSysCalendarItemBase.resetMovePSDEOPPrivName();
                return true;
            }
            case 53: {
                pSSysCalendarItemBase.resetNamePSLanResId();
                return true;
            }
            case 54: {
                pSSysCalendarItemBase.resetNamePSLanResName();
                return true;
            }
            case 55: {
                pSSysCalendarItemBase.resetNavViewFilter();
                return true;
            }
            case 56: {
                pSSysCalendarItemBase.resetNavViewParam();
                return true;
            }
            case 57: {
                pSSysCalendarItemBase.resetOrderValue();
                return true;
            }
            case 58: {
                pSSysCalendarItemBase.resetOrderValuePSDEFId();
                return true;
            }
            case 59: {
                pSSysCalendarItemBase.resetOrderValuePSDEFName();
                return true;
            }
            case 60: {
                pSSysCalendarItemBase.resetPKeyPSDEFId();
                return true;
            }
            case 61: {
                pSSysCalendarItemBase.resetPKeyPSDEFName();
                return true;
            }
            case 62: {
                pSSysCalendarItemBase.resetPSDEDSId();
                return true;
            }
            case 63: {
                pSSysCalendarItemBase.resetPSDEDSName();
                return true;
            }
            case 64: {
                pSSysCalendarItemBase.resetPSDEId();
                return true;
            }
            case 65: {
                pSSysCalendarItemBase.resetPSDELogicId();
                return true;
            }
            case 66: {
                pSSysCalendarItemBase.resetPSDELogicName();
                return true;
            }
            case 67: {
                pSSysCalendarItemBase.resetPSDEName();
                return true;
            }
            case 68: {
                pSSysCalendarItemBase.resetPSDERId();
                return true;
            }
            case 69: {
                pSSysCalendarItemBase.resetPSDERName();
                return true;
            }
            case 70: {
                pSSysCalendarItemBase.resetPSDEToolbarId();
                return true;
            }
            case 71: {
                pSSysCalendarItemBase.resetPSDEToolbarName();
                return true;
            }
            case 72: {
                pSSysCalendarItemBase.resetPSDEViewBaseId();
                return true;
            }
            case 73: {
                pSSysCalendarItemBase.resetPSDEViewBaseName();
                return true;
            }
            case 74: {
                pSSysCalendarItemBase.resetPSSysCalendarId();
                return true;
            }
            case 75: {
                pSSysCalendarItemBase.resetPSSysCalendarItemId();
                return true;
            }
            case 76: {
                pSSysCalendarItemBase.resetPSSysCalendarItemName();
                return true;
            }
            case 77: {
                pSSysCalendarItemBase.resetPSSysCalendarName();
                return true;
            }
            case 78: {
                pSSysCalendarItemBase.resetPSSysCssId();
                return true;
            }
            case 79: {
                pSSysCalendarItemBase.resetPSSysCssName();
                return true;
            }
            case 80: {
                pSSysCalendarItemBase.resetPSSysImageId();
                return true;
            }
            case 81: {
                pSSysCalendarItemBase.resetPSSysImageName();
                return true;
            }
            case 82: {
                pSSysCalendarItemBase.resetPSSysPFPluginId();
                return true;
            }
            case 83: {
                pSSysCalendarItemBase.resetPSSysPFPluginName();
                return true;
            }
            case 84: {
                pSSysCalendarItemBase.resetPSSysViewPanelId();
                return true;
            }
            case 85: {
                pSSysCalendarItemBase.resetPSSysViewPanelName();
                return true;
            }
            case 86: {
                pSSysCalendarItemBase.resetRemovePSDEActionId();
                return true;
            }
            case 87: {
                pSSysCalendarItemBase.resetRemovePSDEActionName();
                return true;
            }
            case 88: {
                pSSysCalendarItemBase.resetRemovePSDEOPPrivId();
                return true;
            }
            case 89: {
                pSSysCalendarItemBase.resetRemovePSDEOPPrivName();
                return true;
            }
            case 90: {
                pSSysCalendarItemBase.resetTag2PSDEFId();
                return true;
            }
            case 91: {
                pSSysCalendarItemBase.resetTag2PSDEFName();
                return true;
            }
            case 92: {
                pSSysCalendarItemBase.resetTagPSDEFId();
                return true;
            }
            case 93: {
                pSSysCalendarItemBase.resetTagPSDEFName();
                return true;
            }
            case 94: {
                pSSysCalendarItemBase.resetTextPSDEFId();
                return true;
            }
            case 95: {
                pSSysCalendarItemBase.resetTextPSDEFName();
                return true;
            }
            case 96: {
                pSSysCalendarItemBase.resetTipsPSDEFId();
                return true;
            }
            case 97: {
                pSSysCalendarItemBase.resetTipsPSDEFName();
                return true;
            }
            case 98: {
                pSSysCalendarItemBase.resetTotalPSDEFId();
                return true;
            }
            case 99: {
                pSSysCalendarItemBase.resetTotalPSDEFName();
                return true;
            }
            case 100: {
                pSSysCalendarItemBase.resetUpdateDate();
                return true;
            }
            case 101: {
                pSSysCalendarItemBase.resetUpdateMan();
                return true;
            }
            case 102: {
                pSSysCalendarItemBase.resetUpdatePSDEActionId();
                return true;
            }
            case 103: {
                pSSysCalendarItemBase.resetUpdatePSDEActionName();
                return true;
            }
            case 104: {
                pSSysCalendarItemBase.resetUpdatePSDEOPPrivId();
                return true;
            }
            case 105: {
                pSSysCalendarItemBase.resetUpdatePSDEOPPrivName();
                return true;
            }
            case 106: {
                pSSysCalendarItemBase.resetUserCat();
                return true;
            }
            case 107: {
                pSSysCalendarItemBase.resetUserTag();
                return true;
            }
            case 108: {
                pSSysCalendarItemBase.resetUserTag2();
                return true;
            }
            case 109: {
                pSSysCalendarItemBase.resetUserTag3();
                return true;
            }
            case 110: {
                pSSysCalendarItemBase.resetUserTag4();
                return true;
            }
            case 111: {
                pSSysCalendarItemBase.resetValidFlag();
                return true;
            }
            case 112: {
                pSSysCalendarItemBase.resetViewActions();
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
                pSDataEntityService.autoGet(pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getCreatePSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreatePSDEAction();
        }
        if (this.getCreatePSDEActionId() == null) {
            return null;
        }
        Integer n = this.objCreatePSDEActionLock;
        synchronized (n) {
            if (this.createpsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getCreatePSDEActionId(), (Object)this.createpsdeaction.getPSDEActionId()) != 0L) {
                this.createpsdeaction = null;
            }
            if (this.createpsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getCreatePSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet(pSDEAction);
                this.createpsdeaction = pSDEAction;
            }
            return this.createpsdeaction;
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
                pSDEActionService.autoGet(pSDEAction);
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
                pSDEActionService.autoGet(pSDEAction);
                this.removepsdeaction = pSDEAction;
            }
            return this.removepsdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getUpdatePSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdatePSDEAction();
        }
        if (this.getUpdatePSDEActionId() == null) {
            return null;
        }
        Integer n = this.objUpdatePSDEActionLock;
        synchronized (n) {
            if (this.updatepsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getUpdatePSDEActionId(), (Object)this.updatepsdeaction.getPSDEActionId()) != 0L) {
                this.updatepsdeaction = null;
            }
            if (this.updatepsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getUpdatePSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet(pSDEAction);
                this.updatepsdeaction = pSDEAction;
            }
            return this.updatepsdeaction;
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
                pSDEDataSetService.autoGet(pSDEDataSet);
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
                pSDEDataSetService.autoGet(pSDEDataSet);
                this.psdeds = pSDEDataSet;
            }
            return this.psdeds;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getBeginPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeginPSDEF();
        }
        if (this.getBeginPSDEFId() == null) {
            return null;
        }
        Integer n = this.objBeginPSDEFLock;
        synchronized (n) {
            if (this.beginpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getBeginPSDEFId(), (Object)this.beginpsdef.getPSDEFieldId()) != 0L) {
                this.beginpsdef = null;
            }
            if (this.beginpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getBeginPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.beginpsdef = pSDEField;
            }
            return this.beginpsdef;
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
                pSDEFieldService.autoGet(pSDEField);
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
                pSDEFieldService.autoGet(pSDEField);
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
                pSDEFieldService.autoGet(pSDEField);
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
                pSDEFieldService.autoGet(pSDEField);
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
                pSDEFieldService.autoGet(pSDEField);
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
                pSDEFieldService.autoGet(pSDEField);
                this.datapsdef = pSDEField;
            }
            return this.datapsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getEndPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEndPSDEF();
        }
        if (this.getEndPSDEFId() == null) {
            return null;
        }
        Integer n = this.objEndPSDEFLock;
        synchronized (n) {
            if (this.endpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getEndPSDEFId(), (Object)this.endpsdef.getPSDEFieldId()) != 0L) {
                this.endpsdef = null;
            }
            if (this.endpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getEndPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.endpsdef = pSDEField;
            }
            return this.endpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getFinishPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFinishPSDEF();
        }
        if (this.getFinishPSDEFId() == null) {
            return null;
        }
        Integer n = this.objFinishPSDEFLock;
        synchronized (n) {
            if (this.finishpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getFinishPSDEFId(), (Object)this.finishpsdef.getPSDEFieldId()) != 0L) {
                this.finishpsdef = null;
            }
            if (this.finishpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getFinishPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.finishpsdef = pSDEField;
            }
            return this.finishpsdef;
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
                pSDEFieldService.autoGet(pSDEField);
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
                pSDEFieldService.autoGet(pSDEField);
                this.keypsdef = pSDEField;
            }
            return this.keypsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getLevelPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLevelPSDEF();
        }
        if (this.getLevelPSDEFId() == null) {
            return null;
        }
        Integer n = this.objLevelPSDEFLock;
        synchronized (n) {
            if (this.levelpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getLevelPSDEFId(), (Object)this.levelpsdef.getPSDEFieldId()) != 0L) {
                this.levelpsdef = null;
            }
            if (this.levelpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getLevelPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.levelpsdef = pSDEField;
            }
            return this.levelpsdef;
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
                pSDEFieldService.autoGet(pSDEField);
                this.linkpsdef = pSDEField;
            }
            return this.linkpsdef;
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
                pSDEFieldService.autoGet(pSDEField);
                this.ordervaluepsdef = pSDEField;
            }
            return this.ordervaluepsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getPKeyPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPKeyPSDEF();
        }
        if (this.getPKeyPSDEFId() == null) {
            return null;
        }
        Integer n = this.objPKeyPSDEFLock;
        synchronized (n) {
            if (this.pkeypsdef != null && DataTypeHelper.compare((int)25, (Object)this.getPKeyPSDEFId(), (Object)this.pkeypsdef.getPSDEFieldId()) != 0L) {
                this.pkeypsdef = null;
            }
            if (this.pkeypsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getPKeyPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.pkeypsdef = pSDEField;
            }
            return this.pkeypsdef;
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
                pSDEFieldService.autoGet(pSDEField);
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
                pSDEFieldService.autoGet(pSDEField);
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
                pSDEFieldService.autoGet(pSDEField);
                this.textpsdef = pSDEField;
            }
            return this.textpsdef;
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
                pSDEFieldService.autoGet(pSDEField);
                this.tipspsdef = pSDEField;
            }
            return this.tipspsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getTotalPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTotalPSDEF();
        }
        if (this.getTotalPSDEFId() == null) {
            return null;
        }
        Integer n = this.objTotalPSDEFLock;
        synchronized (n) {
            if (this.totalpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getTotalPSDEFId(), (Object)this.totalpsdef.getPSDEFieldId()) != 0L) {
                this.totalpsdef = null;
            }
            if (this.totalpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getTotalPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.totalpsdef = pSDEField;
            }
            return this.totalpsdef;
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
    public PSDEOPPriv getCreatePSDEOPPriv() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreatePSDEOPPriv();
        }
        if (this.getCreatePSDEOPPrivId() == null) {
            return null;
        }
        Integer n = this.objCreatePSDEOPPrivLock;
        synchronized (n) {
            if (this.createpsdeoppriv != null && DataTypeHelper.compare((int)25, (Object)this.getCreatePSDEOPPrivId(), (Object)this.createpsdeoppriv.getPSDEOPPrivId()) != 0L) {
                this.createpsdeoppriv = null;
            }
            if (this.createpsdeoppriv == null) {
                PSDEOPPriv pSDEOPPriv = new PSDEOPPriv();
                pSDEOPPriv.setPSDEOPPrivId(this.getCreatePSDEOPPrivId());
                PSDEOPPrivService pSDEOPPrivService = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
                pSDEOPPrivService.autoGet(pSDEOPPriv);
                this.createpsdeoppriv = pSDEOPPriv;
            }
            return this.createpsdeoppriv;
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
                pSDEOPPrivService.autoGet(pSDEOPPriv);
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
                pSDEOPPrivService.autoGet(pSDEOPPriv);
                this.removepsdeoppriv = pSDEOPPriv;
            }
            return this.removepsdeoppriv;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEOPPriv getUpdatePSDEOPPriv() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdatePSDEOPPriv();
        }
        if (this.getUpdatePSDEOPPrivId() == null) {
            return null;
        }
        Integer n = this.objUpdatePSDEOPPrivLock;
        synchronized (n) {
            if (this.updatepsdeoppriv != null && DataTypeHelper.compare((int)25, (Object)this.getUpdatePSDEOPPrivId(), (Object)this.updatepsdeoppriv.getPSDEOPPrivId()) != 0L) {
                this.updatepsdeoppriv = null;
            }
            if (this.updatepsdeoppriv == null) {
                PSDEOPPriv pSDEOPPriv = new PSDEOPPriv();
                pSDEOPPriv.setPSDEOPPrivId(this.getUpdatePSDEOPPrivId());
                PSDEOPPrivService pSDEOPPrivService = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
                pSDEOPPrivService.autoGet(pSDEOPPriv);
                this.updatepsdeoppriv = pSDEOPPriv;
            }
            return this.updatepsdeoppriv;
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
                pSDERService.autoGet(pSDER);
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
                pSDEToolbarService.autoGet(pSDEToolbar);
                this.psdetoolbar = pSDEToolbar;
            }
            return this.psdetoolbar;
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
                pSDEViewBaseService.autoGet(pSDEViewBase);
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
                pSLanguageResService.autoGet(pSLanguageRes);
                this.namepslanres = pSLanguageRes;
            }
            return this.namepslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysCalendar getPSSysCalendar() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCalendar();
        }
        if (this.getPSSysCalendarId() == null) {
            return null;
        }
        Integer n = this.objPSSysCalendarLock;
        synchronized (n) {
            if (this.pssyscalendar != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysCalendarId(), (Object)this.pssyscalendar.getPSSysCalendarId()) != 0L) {
                this.pssyscalendar = null;
            }
            if (this.pssyscalendar == null) {
                PSSysCalendar pSSysCalendar = new PSSysCalendar();
                pSSysCalendar.setPSSysCalendarId(this.getPSSysCalendarId());
                PSSysCalendarService pSSysCalendarService = (PSSysCalendarService)ServiceGlobal.getService(PSSysCalendarService.class, (SessionFactory)this.getSessionFactory());
                pSSysCalendarService.autoGet(pSSysCalendar);
                this.pssyscalendar = pSSysCalendar;
            }
            return this.pssyscalendar;
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
    public PSSysPFPlugin getGanttPSSysPFPluin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGanttPSSysPFPluin();
        }
        if (this.getGanttPSSysPFPluginId() == null) {
            return null;
        }
        Integer n = this.objGanttPSSysPFPluinLock;
        synchronized (n) {
            if (this.ganttpssyspfpluin != null && DataTypeHelper.compare((int)25, (Object)this.getGanttPSSysPFPluginId(), (Object)this.ganttpssyspfpluin.getPSSysPFPluginId()) != 0L) {
                this.ganttpssyspfpluin = null;
            }
            if (this.ganttpssyspfpluin == null) {
                PSSysPFPlugin pSSysPFPlugin = new PSSysPFPlugin();
                pSSysPFPlugin.setPSSysPFPluginId(this.getGanttPSSysPFPluginId());
                PSSysPFPluginService pSSysPFPluginService = (PSSysPFPluginService)ServiceGlobal.getService(PSSysPFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysPFPluginService.autoGet(pSSysPFPlugin);
                this.ganttpssyspfpluin = pSSysPFPlugin;
            }
            return this.ganttpssyspfpluin;
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
    public PSSysViewPanel getPSSysViewPanel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanel();
        }
        if (this.getPSSysViewPanelId() == null) {
            return null;
        }
        Integer n = this.objPSSysViewPanelLock;
        synchronized (n) {
            if (this.pssysviewpanel != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysViewPanelId(), (Object)this.pssysviewpanel.getPSSysViewPanelId()) != 0L) {
                this.pssysviewpanel = null;
            }
            if (this.pssysviewpanel == null) {
                PSSysViewPanel pSSysViewPanel = new PSSysViewPanel();
                pSSysViewPanel.setPSSysViewPanelId(this.getPSSysViewPanelId());
                PSSysViewPanelService pSSysViewPanelService = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)this.getSessionFactory());
                pSSysViewPanelService.autoGet(pSSysViewPanel);
                this.pssysviewpanel = pSSysViewPanel;
            }
            return this.pssysviewpanel;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysCalendarItemRV> getPSSysCalendarItemRVs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCalendarItemRVs();
        }
        if (this.getPSSysCalendarItemId() == null) {
            return null;
        }
        PSSysCalendarItemService pSSysCalendarItemService = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        PSSysCalendarItemRVService pSSysCalendarItemRVService = (PSSysCalendarItemRVService)ServiceGlobal.getService(PSSysCalendarItemRVService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysCalendarItemRVsLock;
        synchronized (n) {
            if (this.pssyscalendaritemrvs == null) {
                this.pssyscalendaritemrvs = pSSysCalendarItemService.isTempData(this) ? pSSysCalendarItemRVService.selectTempByPSSysCalendarItem(this) : pSSysCalendarItemRVService.selectByPSSysCalendarItem(this);
            }
            return this.pssyscalendaritemrvs;
        }
    }

    private PSSysCalendarItemBase getProxyEntity() {
        return this.proxyPSSysCalendarItemBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysCalendarItemBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysCalendarItemBase) {
            this.proxyPSSysCalendarItemBase = (PSSysCalendarItemBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarItemService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ASYNCPSDEDSID, 0);
        fieldIndexMap.put(FIELD_ASYNCPSDEDSNAME, 1);
        fieldIndexMap.put(FIELD_BEGINPSDEFID, 2);
        fieldIndexMap.put(FIELD_BEGINPSDEFNAME, 3);
        fieldIndexMap.put(FIELD_BKCOLOR, 4);
        fieldIndexMap.put(FIELD_BKCOLORPSDEFID, 5);
        fieldIndexMap.put(FIELD_BKCOLORPSDEFNAME, 6);
        fieldIndexMap.put(FIELD_CLSPSDEFID, 7);
        fieldIndexMap.put(FIELD_CLSPSDEFNAME, 8);
        fieldIndexMap.put(FIELD_COLOR, 9);
        fieldIndexMap.put(FIELD_COLORPSDEFID, 10);
        fieldIndexMap.put(FIELD_COLORPSDEFNAME, 11);
        fieldIndexMap.put(FIELD_CONTENTPSDEFID, 12);
        fieldIndexMap.put(FIELD_CONTENTPSDEFNAME, 13);
        fieldIndexMap.put(FIELD_CREATEDATE, 14);
        fieldIndexMap.put(FIELD_CREATEMAN, 15);
        fieldIndexMap.put(FIELD_CREATEPSDEACTIONID, 16);
        fieldIndexMap.put(FIELD_CREATEPSDEACTIONNAME, 17);
        fieldIndexMap.put(FIELD_CREATEPSDEOPPRIVID, 18);
        fieldIndexMap.put(FIELD_CREATEPSDEOPPRIVNAME, 19);
        fieldIndexMap.put(FIELD_CUSTOMCOND, 20);
        fieldIndexMap.put(FIELD_CUSTOMTYPE, 21);
        fieldIndexMap.put(FIELD_DATA2PSDEFID, 22);
        fieldIndexMap.put(FIELD_DATA2PSDEFNAME, 23);
        fieldIndexMap.put(FIELD_DATAPSDEFID, 24);
        fieldIndexMap.put(FIELD_DATAPSDEFNAME, 25);
        fieldIndexMap.put(FIELD_DYNACLASS, 26);
        fieldIndexMap.put(FIELD_EDITMODE, 27);
        fieldIndexMap.put(FIELD_ENABLEVIEWACTIONS, 28);
        fieldIndexMap.put(FIELD_ENDPSDEFID, 29);
        fieldIndexMap.put(FIELD_ENDPSDEFNAME, 30);
        fieldIndexMap.put(FIELD_FINISHPSDEFID, 31);
        fieldIndexMap.put(FIELD_FINISHPSDEFNAME, 32);
        fieldIndexMap.put(FIELD_GANTTPSSYSPFPLUGINID, 33);
        fieldIndexMap.put(FIELD_GANTTPSSYSPFPLUGINNAME, 34);
        fieldIndexMap.put(FIELD_ICONPSDEFID, 35);
        fieldIndexMap.put(FIELD_ICONPSDEFNAME, 36);
        fieldIndexMap.put(FIELD_ITEMSTYLE, 37);
        fieldIndexMap.put(FIELD_ITEMSTYLETEXT, 38);
        fieldIndexMap.put(FIELD_ITEMTYPE, 39);
        fieldIndexMap.put(FIELD_KEYPSDEFID, 40);
        fieldIndexMap.put(FIELD_KEYPSDEFNAME, 41);
        fieldIndexMap.put(FIELD_LEVELPSDEFID, 42);
        fieldIndexMap.put(FIELD_LEVELPSDEFNAME, 43);
        fieldIndexMap.put(FIELD_LINKPSDEFID, 44);
        fieldIndexMap.put(FIELD_LINKPSDEFNAME, 45);
        fieldIndexMap.put(FIELD_MAXSIZE, 46);
        fieldIndexMap.put(FIELD_MEMO, 47);
        fieldIndexMap.put(FIELD_MODELOBJ, 48);
        fieldIndexMap.put(FIELD_MOVEPSDEACTIONID, 49);
        fieldIndexMap.put(FIELD_MOVEPSDEACTIONNAME, 50);
        fieldIndexMap.put(FIELD_MOVEPSDEOPPRIVID, 51);
        fieldIndexMap.put(FIELD_MOVEPSDEOPPRIVNAME, 52);
        fieldIndexMap.put(FIELD_NAMEPSLANRESID, 53);
        fieldIndexMap.put(FIELD_NAMEPSLANRESNAME, 54);
        fieldIndexMap.put(FIELD_NAVVIEWFILTER, 55);
        fieldIndexMap.put(FIELD_NAVVIEWPARAM, 56);
        fieldIndexMap.put(FIELD_ORDERVALUE, 57);
        fieldIndexMap.put(FIELD_ORDERVALUEPSDEFID, 58);
        fieldIndexMap.put(FIELD_ORDERVALUEPSDEFNAME, 59);
        fieldIndexMap.put(FIELD_PKEYPSDEFID, 60);
        fieldIndexMap.put(FIELD_PKEYPSDEFNAME, 61);
        fieldIndexMap.put(FIELD_PSDEDSID, 62);
        fieldIndexMap.put(FIELD_PSDEDSNAME, 63);
        fieldIndexMap.put(FIELD_PSDEID, 64);
        fieldIndexMap.put(FIELD_PSDELOGICID, 65);
        fieldIndexMap.put(FIELD_PSDELOGICNAME, 66);
        fieldIndexMap.put(FIELD_PSDENAME, 67);
        fieldIndexMap.put(FIELD_PSDERID, 68);
        fieldIndexMap.put(FIELD_PSDERNAME, 69);
        fieldIndexMap.put(FIELD_PSDETOOLBARID, 70);
        fieldIndexMap.put(FIELD_PSDETOOLBARNAME, 71);
        fieldIndexMap.put(FIELD_PSDEVIEWBASEID, 72);
        fieldIndexMap.put(FIELD_PSDEVIEWBASENAME, 73);
        fieldIndexMap.put(FIELD_PSSYSCALENDARID, 74);
        fieldIndexMap.put(FIELD_PSSYSCALENDARITEMID, 75);
        fieldIndexMap.put(FIELD_PSSYSCALENDARITEMNAME, 76);
        fieldIndexMap.put(FIELD_PSSYSCALENDARNAME, 77);
        fieldIndexMap.put(FIELD_PSSYSCSSID, 78);
        fieldIndexMap.put(FIELD_PSSYSCSSNAME, 79);
        fieldIndexMap.put(FIELD_PSSYSIMAGEID, 80);
        fieldIndexMap.put(FIELD_PSSYSIMAGENAME, 81);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 82);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 83);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELID, 84);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELNAME, 85);
        fieldIndexMap.put(FIELD_REMOVEPSDEACTIONID, 86);
        fieldIndexMap.put(FIELD_REMOVEPSDEACTIONNAME, 87);
        fieldIndexMap.put(FIELD_REMOVEPSDEOPPRIVID, 88);
        fieldIndexMap.put(FIELD_REMOVEPSDEOPPRIVNAME, 89);
        fieldIndexMap.put(FIELD_TAG2PSDEFID, 90);
        fieldIndexMap.put(FIELD_TAG2PSDEFNAME, 91);
        fieldIndexMap.put(FIELD_TAGPSDEFID, 92);
        fieldIndexMap.put(FIELD_TAGPSDEFNAME, 93);
        fieldIndexMap.put(FIELD_TEXTPSDEFID, 94);
        fieldIndexMap.put(FIELD_TEXTPSDEFNAME, 95);
        fieldIndexMap.put(FIELD_TIPSPSDEFID, 96);
        fieldIndexMap.put(FIELD_TIPSPSDEFNAME, 97);
        fieldIndexMap.put(FIELD_TOTALPSDEFID, 98);
        fieldIndexMap.put(FIELD_TOTALPSDEFNAME, 99);
        fieldIndexMap.put(FIELD_UPDATEDATE, 100);
        fieldIndexMap.put(FIELD_UPDATEMAN, 101);
        fieldIndexMap.put(FIELD_UPDATEPSDEACTIONID, 102);
        fieldIndexMap.put(FIELD_UPDATEPSDEACTIONNAME, 103);
        fieldIndexMap.put(FIELD_UPDATEPSDEOPPRIVID, 104);
        fieldIndexMap.put(FIELD_UPDATEPSDEOPPRIVNAME, 105);
        fieldIndexMap.put(FIELD_USERCAT, 106);
        fieldIndexMap.put(FIELD_USERTAG, 107);
        fieldIndexMap.put(FIELD_USERTAG2, 108);
        fieldIndexMap.put(FIELD_USERTAG3, 109);
        fieldIndexMap.put(FIELD_USERTAG4, 110);
        fieldIndexMap.put(FIELD_VALIDFLAG, 111);
        fieldIndexMap.put(FIELD_VIEWACTIONS, 112);
    }
}

