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
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGrid;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETEIUpdate;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbar;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeNodeCol;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeView;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETEIUpdateService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDETreeNodeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDETreeNodeBase.class);
    public static final String FIELD_ACTIONPARAM = "ACTIONPARAM";
    public static final String FIELD_APPENDCAPFLAG = "APPENDCAPFLAG";
    public static final String FIELD_APPENDPNODEID = "APPENDPNODEID";
    public static final String FIELD_CAPTION = "CAPTION";
    public static final String FIELD_CHECKED = "CHECKED";
    public static final String FIELD_CHILDCNTPSDEFID = "CHILDCNTPSDEFID";
    public static final String FIELD_CHILDCNTPSDEFNAME = "CHILDCNTPSDEFNAME";
    public static final String FIELD_CLSPSDEFID = "CLSPSDEFID";
    public static final String FIELD_CLSPSDEFNAME = "CLSPSDEFNAME";
    public static final String FIELD_CMREFRESH = "CMREFRESH";
    public static final String FIELD_CMREMOVE = "CMREMOVE";
    public static final String FIELD_COUNTERID = "COUNTERID";
    public static final String FIELD_COUNTERMODE = "COUNTERMODE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMCOND = "CUSTOMCOND";
    public static final String FIELD_CUSTOMTYPE = "CUSTOMTYPE";
    public static final String FIELD_DATA2PSDEFID = "DATA2PSDEFID";
    public static final String FIELD_DATA2PSDEFNAME = "DATA2PSDEFNAME";
    public static final String FIELD_DATAPSDEFID = "DATAPSDEFID";
    public static final String FIELD_DATAPSDEFNAME = "DATAPSDEFNAME";
    public static final String FIELD_DATASOURCE = "DATASOURCE";
    public static final String FIELD_DATATYPEPSDEFID = "DATATYPEPSDEFID";
    public static final String FIELD_DATATYPEPSDEFNAME = "DATATYPEPSDEFNAME";
    public static final String FIELD_DISABLESELECT = "DISABLESELECT";
    public static final String FIELD_DISTINCTMODE = "DISTINCTMODE";
    public static final String FIELD_DYNACLASS = "DYNACLASS";
    public static final String FIELD_EDITDATAMODE = "EDITDATAMODE";
    public static final String FIELD_EDITMODE = "EDITMODE";
    public static final String FIELD_ENABLECHECK = "ENABLECHECK";
    public static final String FIELD_ENABLEPAGING = "ENABLEPAGING";
    public static final String FIELD_ENABLEQUICKSEARCH = "ENABLEQUICKSEARCH";
    public static final String FIELD_ENABLEUP = "ENABLEUP";
    public static final String FIELD_ENABLEVIEWACTIONS = "ENABLEVIEWACTIONS";
    public static final String FIELD_EXPAND = "EXPAND";
    public static final String FIELD_FIELDNAME = "FIELDNAME";
    public static final String FIELD_FILTERPSDEDSID = "FILTERPSDEDSID";
    public static final String FIELD_FILTERPSDEDSNAME = "FILTERPSDEDSNAME";
    public static final String FIELD_ICONPSDEFID = "ICONPSDEFID";
    public static final String FIELD_ICONPSDEFNAME = "ICONPSDEFNAME";
    public static final String FIELD_KEYPSDEFID = "KEYPSDEFID";
    public static final String FIELD_KEYPSDEFNAME = "KEYPSDEFNAME";
    public static final String FIELD_LEAFFLAGPSDEFID = "LEAFFLAGPSDEFID";
    public static final String FIELD_LEAFFLAGPSDEFNAME = "LEAFFLAGPSDEFNAME";
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
    public static final String FIELD_NAVVIEWFILTERDESC = "NAVVIEWFILTERDESC";
    public static final String FIELD_NAVVIEWPARAM = "NAVVIEWPARAM";
    public static final String FIELD_NEWDATAMODE = "NEWDATAMODE";
    public static final String FIELD_NO2PSDEUAGROUPID = "NO2PSDEUAGROUPID";
    public static final String FIELD_NO2PSDEUAGROUPNAME = "NO2PSDEUAGROUPNAME";
    public static final String FIELD_NODEACTION = "NODEACTION";
    public static final String FIELD_NODEDATATYPE = "NODEDATATYPE";
    public static final String FIELD_NODEID2PSDEFID = "NODEID2PSDEFID";
    public static final String FIELD_NODEID2PSDEFNAME = "NODEID2PSDEFNAME";
    public static final String FIELD_NODEID3PSDEFID = "NODEID3PSDEFID";
    public static final String FIELD_NODEID3PSDEFNAME = "NODEID3PSDEFNAME";
    public static final String FIELD_NODEID4PSDEFID = "NODEID4PSDEFID";
    public static final String FIELD_NODEID4PSDEFNAME = "NODEID4PSDEFNAME";
    public static final String FIELD_NODEIDPSDEFID = "NODEIDPSDEFID";
    public static final String FIELD_NODEIDPSDEFNAME = "NODEIDPSDEFNAME";
    public static final String FIELD_NODETYPE = "NODETYPE";
    public static final String FIELD_NODEVALUE = "NODEVALUE";
    public static final String FIELD_PAGESIZE = "PAGESIZE";
    public static final String FIELD_PREVENTXSS = "PREVENTXSS";
    public static final String FIELD_PSCODELISTID = "PSCODELISTID";
    public static final String FIELD_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String FIELD_PSDEACTIONID = "PSDEACTIONID";
    public static final String FIELD_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String FIELD_PSDEDSID = "PSDEDSID";
    public static final String FIELD_PSDEDSNAME = "PSDEDSNAME";
    public static final String FIELD_PSDEGRIDID = "PSDEGRIDID";
    public static final String FIELD_PSDEGRIDNAME = "PSDEGRIDNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDELOGICID = "PSDELOGICID";
    public static final String FIELD_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDERID = "PSDERID";
    public static final String FIELD_PSDERNAME = "PSDERNAME";
    public static final String FIELD_PSDETOOLBARID = "PSDETOOLBARID";
    public static final String FIELD_PSDETOOLBARNAME = "PSDETOOLBARNAME";
    public static final String FIELD_PSDETREENODEID = "PSDETREENODEID";
    public static final String FIELD_PSDETREENODENAME = "PSDETREENODENAME";
    public static final String FIELD_PSDETREEVIEWID = "PSDETREEVIEWID";
    public static final String FIELD_PSDETREEVIEWNAME = "PSDETREEVIEWNAME";
    public static final String FIELD_PSDEUAGROUPID = "PSDEUAGROUPID";
    public static final String FIELD_PSDEUAGROUPNAME = "PSDEUAGROUPNAME";
    public static final String FIELD_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String FIELD_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String FIELD_PSSYSCSSID = "PSSYSCSSID";
    public static final String FIELD_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String FIELD_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String FIELD_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSUNIRESID = "PSSYSUNIRESID";
    public static final String FIELD_PSSYSUNIRESNAME = "PSSYSUNIRESNAME";
    public static final String FIELD_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String FIELD_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String FIELD_REMOVEPSDEACTIONID = "REMOVEPSDEACTIONID";
    public static final String FIELD_REMOVEPSDEACTIONNAME = "REMOVEPSDEACTIONNAME";
    public static final String FIELD_REMOVEPSDEOPPRIVID = "REMOVEPSDEOPPRIVID";
    public static final String FIELD_REMOVEPSDEOPPRIVNAME = "REMOVEPSDEOPPRIVNAME";
    public static final String FIELD_ROOTNODE = "ROOTNODE";
    public static final String FIELD_SELECTED = "SELECTED";
    public static final String FIELD_SHAPECLSPSDEFID = "SHAPECLSPSDEFID";
    public static final String FIELD_SHAPECLSPSDEFNAME = "SHAPECLSPSDEFNAME";
    public static final String FIELD_SHAPEDYNACLASS = "SHAPEDYNACLASS";
    public static final String FIELD_SHAPEPSSYSCSSID = "SHAPEPSSYSCSSID";
    public static final String FIELD_SHAPEPSSYSCSSNAME = "SHAPEPSSYSCSSNAME";
    public static final String FIELD_SORTDIR = "SORTDIR";
    public static final String FIELD_SORTPSDEFID = "SORTPSDEFID";
    public static final String FIELD_SORTPSDEFNAME = "SORTPSDEFNAME";
    public static final String FIELD_TEXTPSDEFID = "TEXTPSDEFID";
    public static final String FIELD_TEXTPSDEFNAME = "TEXTPSDEFNAME";
    public static final String FIELD_TIPPSLANRESID = "TIPPSLANRESID";
    public static final String FIELD_TIPPSLANRESNAME = "TIPPSLANRESNAME";
    public static final String FIELD_TIPSPSDEFID = "TIPSPSDEFID";
    public static final String FIELD_TIPSPSDEFNAME = "TIPSPSDEFNAME";
    public static final String FIELD_TOOLTIPINFO = "TOOLTIPINFO";
    public static final String FIELD_TREENODETYPE = "TREENODETYPE";
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
    public static final String FIELD_VIEWACTIONS = "VIEWACTIONS";
    private static final int INDEX_ACTIONPARAM = 0;
    private static final int INDEX_APPENDCAPFLAG = 1;
    private static final int INDEX_APPENDPNODEID = 2;
    private static final int INDEX_CAPTION = 3;
    private static final int INDEX_CHECKED = 4;
    private static final int INDEX_CHILDCNTPSDEFID = 5;
    private static final int INDEX_CHILDCNTPSDEFNAME = 6;
    private static final int INDEX_CLSPSDEFID = 7;
    private static final int INDEX_CLSPSDEFNAME = 8;
    private static final int INDEX_CMREFRESH = 9;
    private static final int INDEX_CMREMOVE = 10;
    private static final int INDEX_COUNTERID = 11;
    private static final int INDEX_COUNTERMODE = 12;
    private static final int INDEX_CREATEDATE = 13;
    private static final int INDEX_CREATEMAN = 14;
    private static final int INDEX_CUSTOMCODE = 15;
    private static final int INDEX_CUSTOMCOND = 16;
    private static final int INDEX_CUSTOMTYPE = 17;
    private static final int INDEX_DATA2PSDEFID = 18;
    private static final int INDEX_DATA2PSDEFNAME = 19;
    private static final int INDEX_DATAPSDEFID = 20;
    private static final int INDEX_DATAPSDEFNAME = 21;
    private static final int INDEX_DATASOURCE = 22;
    private static final int INDEX_DATATYPEPSDEFID = 23;
    private static final int INDEX_DATATYPEPSDEFNAME = 24;
    private static final int INDEX_DISABLESELECT = 25;
    private static final int INDEX_DISTINCTMODE = 26;
    private static final int INDEX_DYNACLASS = 27;
    private static final int INDEX_EDITDATAMODE = 28;
    private static final int INDEX_EDITMODE = 29;
    private static final int INDEX_ENABLECHECK = 30;
    private static final int INDEX_ENABLEPAGING = 31;
    private static final int INDEX_ENABLEQUICKSEARCH = 32;
    private static final int INDEX_ENABLEUP = 33;
    private static final int INDEX_ENABLEVIEWACTIONS = 34;
    private static final int INDEX_EXPAND = 35;
    private static final int INDEX_FIELDNAME = 36;
    private static final int INDEX_FILTERPSDEDSID = 37;
    private static final int INDEX_FILTERPSDEDSNAME = 38;
    private static final int INDEX_ICONPSDEFID = 39;
    private static final int INDEX_ICONPSDEFNAME = 40;
    private static final int INDEX_KEYPSDEFID = 41;
    private static final int INDEX_KEYPSDEFNAME = 42;
    private static final int INDEX_LEAFFLAGPSDEFID = 43;
    private static final int INDEX_LEAFFLAGPSDEFNAME = 44;
    private static final int INDEX_LINKPSDEFID = 45;
    private static final int INDEX_LINKPSDEFNAME = 46;
    private static final int INDEX_MAXSIZE = 47;
    private static final int INDEX_MEMO = 48;
    private static final int INDEX_MODELOBJ = 49;
    private static final int INDEX_MOVEPSDEACTIONID = 50;
    private static final int INDEX_MOVEPSDEACTIONNAME = 51;
    private static final int INDEX_MOVEPSDEOPPRIVID = 52;
    private static final int INDEX_MOVEPSDEOPPRIVNAME = 53;
    private static final int INDEX_NAMEPSLANRESID = 54;
    private static final int INDEX_NAMEPSLANRESNAME = 55;
    private static final int INDEX_NAVVIEWFILTER = 56;
    private static final int INDEX_NAVVIEWFILTERDESC = 57;
    private static final int INDEX_NAVVIEWPARAM = 58;
    private static final int INDEX_NEWDATAMODE = 59;
    private static final int INDEX_NO2PSDEUAGROUPID = 60;
    private static final int INDEX_NO2PSDEUAGROUPNAME = 61;
    private static final int INDEX_NODEACTION = 62;
    private static final int INDEX_NODEDATATYPE = 63;
    private static final int INDEX_NODEID2PSDEFID = 64;
    private static final int INDEX_NODEID2PSDEFNAME = 65;
    private static final int INDEX_NODEID3PSDEFID = 66;
    private static final int INDEX_NODEID3PSDEFNAME = 67;
    private static final int INDEX_NODEID4PSDEFID = 68;
    private static final int INDEX_NODEID4PSDEFNAME = 69;
    private static final int INDEX_NODEIDPSDEFID = 70;
    private static final int INDEX_NODEIDPSDEFNAME = 71;
    private static final int INDEX_NODETYPE = 72;
    private static final int INDEX_NODEVALUE = 73;
    private static final int INDEX_PAGESIZE = 74;
    private static final int INDEX_PREVENTXSS = 75;
    private static final int INDEX_PSCODELISTID = 76;
    private static final int INDEX_PSCODELISTNAME = 77;
    private static final int INDEX_PSDEACTIONID = 78;
    private static final int INDEX_PSDEACTIONNAME = 79;
    private static final int INDEX_PSDEDSID = 80;
    private static final int INDEX_PSDEDSNAME = 81;
    private static final int INDEX_PSDEGRIDID = 82;
    private static final int INDEX_PSDEGRIDNAME = 83;
    private static final int INDEX_PSDEID = 84;
    private static final int INDEX_PSDELOGICID = 85;
    private static final int INDEX_PSDELOGICNAME = 86;
    private static final int INDEX_PSDENAME = 87;
    private static final int INDEX_PSDERID = 88;
    private static final int INDEX_PSDERNAME = 89;
    private static final int INDEX_PSDETOOLBARID = 90;
    private static final int INDEX_PSDETOOLBARNAME = 91;
    private static final int INDEX_PSDETREENODEID = 92;
    private static final int INDEX_PSDETREENODENAME = 93;
    private static final int INDEX_PSDETREEVIEWID = 94;
    private static final int INDEX_PSDETREEVIEWNAME = 95;
    private static final int INDEX_PSDEUAGROUPID = 96;
    private static final int INDEX_PSDEUAGROUPNAME = 97;
    private static final int INDEX_PSDEVIEWBASEID = 98;
    private static final int INDEX_PSDEVIEWBASENAME = 99;
    private static final int INDEX_PSSYSCSSID = 100;
    private static final int INDEX_PSSYSCSSNAME = 101;
    private static final int INDEX_PSSYSIMAGEID = 102;
    private static final int INDEX_PSSYSIMAGENAME = 103;
    private static final int INDEX_PSSYSPFPLUGINID = 104;
    private static final int INDEX_PSSYSPFPLUGINNAME = 105;
    private static final int INDEX_PSSYSTEMID = 106;
    private static final int INDEX_PSSYSUNIRESID = 107;
    private static final int INDEX_PSSYSUNIRESNAME = 108;
    private static final int INDEX_PSSYSVIEWPANELID = 109;
    private static final int INDEX_PSSYSVIEWPANELNAME = 110;
    private static final int INDEX_REMOVEPSDEACTIONID = 111;
    private static final int INDEX_REMOVEPSDEACTIONNAME = 112;
    private static final int INDEX_REMOVEPSDEOPPRIVID = 113;
    private static final int INDEX_REMOVEPSDEOPPRIVNAME = 114;
    private static final int INDEX_ROOTNODE = 115;
    private static final int INDEX_SELECTED = 116;
    private static final int INDEX_SHAPECLSPSDEFID = 117;
    private static final int INDEX_SHAPECLSPSDEFNAME = 118;
    private static final int INDEX_SHAPEDYNACLASS = 119;
    private static final int INDEX_SHAPEPSSYSCSSID = 120;
    private static final int INDEX_SHAPEPSSYSCSSNAME = 121;
    private static final int INDEX_SORTDIR = 122;
    private static final int INDEX_SORTPSDEFID = 123;
    private static final int INDEX_SORTPSDEFNAME = 124;
    private static final int INDEX_TEXTPSDEFID = 125;
    private static final int INDEX_TEXTPSDEFNAME = 126;
    private static final int INDEX_TIPPSLANRESID = 127;
    private static final int INDEX_TIPPSLANRESNAME = 128;
    private static final int INDEX_TIPSPSDEFID = 129;
    private static final int INDEX_TIPSPSDEFNAME = 130;
    private static final int INDEX_TOOLTIPINFO = 131;
    private static final int INDEX_TREENODETYPE = 132;
    private static final int INDEX_UPDATEDATE = 133;
    private static final int INDEX_UPDATEMAN = 134;
    private static final int INDEX_UPDATEPSDEACTIONID = 135;
    private static final int INDEX_UPDATEPSDEACTIONNAME = 136;
    private static final int INDEX_UPDATEPSDEOPPRIVID = 137;
    private static final int INDEX_UPDATEPSDEOPPRIVNAME = 138;
    private static final int INDEX_USERCAT = 139;
    private static final int INDEX_USERTAG = 140;
    private static final int INDEX_USERTAG2 = 141;
    private static final int INDEX_USERTAG3 = 142;
    private static final int INDEX_USERTAG4 = 143;
    private static final int INDEX_VIEWACTIONS = 144;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDETreeNodeBase proxyPSDETreeNodeBase = null;
    private boolean actionparamDirtyFlag = false;
    private boolean appendcapflagDirtyFlag = false;
    private boolean appendpnodeidDirtyFlag = false;
    private boolean captionDirtyFlag = false;
    private boolean checkedDirtyFlag = false;
    private boolean childcntpsdefidDirtyFlag = false;
    private boolean childcntpsdefnameDirtyFlag = false;
    private boolean clspsdefidDirtyFlag = false;
    private boolean clspsdefnameDirtyFlag = false;
    private boolean cmrefreshDirtyFlag = false;
    private boolean cmremoveDirtyFlag = false;
    private boolean counteridDirtyFlag = false;
    private boolean countermodeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean customcondDirtyFlag = false;
    private boolean customtypeDirtyFlag = false;
    private boolean data2psdefidDirtyFlag = false;
    private boolean data2psdefnameDirtyFlag = false;
    private boolean datapsdefidDirtyFlag = false;
    private boolean datapsdefnameDirtyFlag = false;
    private boolean datasourceDirtyFlag = false;
    private boolean datatypepsdefidDirtyFlag = false;
    private boolean datatypepsdefnameDirtyFlag = false;
    private boolean disableselectDirtyFlag = false;
    private boolean distinctmodeDirtyFlag = false;
    private boolean dynaclassDirtyFlag = false;
    private boolean editdatamodeDirtyFlag = false;
    private boolean editmodeDirtyFlag = false;
    private boolean enablecheckDirtyFlag = false;
    private boolean enablepagingDirtyFlag = false;
    private boolean enablequicksearchDirtyFlag = false;
    private boolean enableupDirtyFlag = false;
    private boolean enableviewactionsDirtyFlag = false;
    private boolean expandDirtyFlag = false;
    private boolean fieldnameDirtyFlag = false;
    private boolean filterpsdedsidDirtyFlag = false;
    private boolean filterpsdedsnameDirtyFlag = false;
    private boolean iconpsdefidDirtyFlag = false;
    private boolean iconpsdefnameDirtyFlag = false;
    private boolean keypsdefidDirtyFlag = false;
    private boolean keypsdefnameDirtyFlag = false;
    private boolean leafflagpsdefidDirtyFlag = false;
    private boolean leafflagpsdefnameDirtyFlag = false;
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
    private boolean navviewfilterdescDirtyFlag = false;
    private boolean navviewparamDirtyFlag = false;
    private boolean newdatamodeDirtyFlag = false;
    private boolean no2psdeuagroupidDirtyFlag = false;
    private boolean no2psdeuagroupnameDirtyFlag = false;
    private boolean nodeactionDirtyFlag = false;
    private boolean nodedatatypeDirtyFlag = false;
    private boolean nodeid2psdefidDirtyFlag = false;
    private boolean nodeid2psdefnameDirtyFlag = false;
    private boolean nodeid3psdefidDirtyFlag = false;
    private boolean nodeid3psdefnameDirtyFlag = false;
    private boolean nodeid4psdefidDirtyFlag = false;
    private boolean nodeid4psdefnameDirtyFlag = false;
    private boolean nodeidpsdefidDirtyFlag = false;
    private boolean nodeidpsdefnameDirtyFlag = false;
    private boolean nodetypeDirtyFlag = false;
    private boolean nodevalueDirtyFlag = false;
    private boolean pagesizeDirtyFlag = false;
    private boolean preventxssDirtyFlag = false;
    private boolean pscodelistidDirtyFlag = false;
    private boolean pscodelistnameDirtyFlag = false;
    private boolean psdeactionidDirtyFlag = false;
    private boolean psdeactionnameDirtyFlag = false;
    private boolean psdedsidDirtyFlag = false;
    private boolean psdedsnameDirtyFlag = false;
    private boolean psdegrididDirtyFlag = false;
    private boolean psdegridnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdelogicidDirtyFlag = false;
    private boolean psdelogicnameDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psderidDirtyFlag = false;
    private boolean psdernameDirtyFlag = false;
    private boolean psdetoolbaridDirtyFlag = false;
    private boolean psdetoolbarnameDirtyFlag = false;
    private boolean psdetreenodeidDirtyFlag = false;
    private boolean psdetreenodenameDirtyFlag = false;
    private boolean psdetreeviewidDirtyFlag = false;
    private boolean psdetreeviewnameDirtyFlag = false;
    private boolean psdeuagroupidDirtyFlag = false;
    private boolean psdeuagroupnameDirtyFlag = false;
    private boolean psdeviewbaseidDirtyFlag = false;
    private boolean psdeviewbasenameDirtyFlag = false;
    private boolean pssyscssidDirtyFlag = false;
    private boolean pssyscssnameDirtyFlag = false;
    private boolean pssysimageidDirtyFlag = false;
    private boolean pssysimagenameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssysuniresidDirtyFlag = false;
    private boolean pssysuniresnameDirtyFlag = false;
    private boolean pssysviewpanelidDirtyFlag = false;
    private boolean pssysviewpanelnameDirtyFlag = false;
    private boolean removepsdeactionidDirtyFlag = false;
    private boolean removepsdeactionnameDirtyFlag = false;
    private boolean removepsdeopprividDirtyFlag = false;
    private boolean removepsdeopprivnameDirtyFlag = false;
    private boolean rootnodeDirtyFlag = false;
    private boolean selectedDirtyFlag = false;
    private boolean shapeclspsdefidDirtyFlag = false;
    private boolean shapeclspsdefnameDirtyFlag = false;
    private boolean shapedynaclassDirtyFlag = false;
    private boolean shapepssyscssidDirtyFlag = false;
    private boolean shapepssyscssnameDirtyFlag = false;
    private boolean sortdirDirtyFlag = false;
    private boolean sortpsdefidDirtyFlag = false;
    private boolean sortpsdefnameDirtyFlag = false;
    private boolean textpsdefidDirtyFlag = false;
    private boolean textpsdefnameDirtyFlag = false;
    private boolean tippslanresidDirtyFlag = false;
    private boolean tippslanresnameDirtyFlag = false;
    private boolean tipspsdefidDirtyFlag = false;
    private boolean tipspsdefnameDirtyFlag = false;
    private boolean tooltipinfoDirtyFlag = false;
    private boolean treenodetypeDirtyFlag = false;
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
    private boolean viewactionsDirtyFlag = false;
    @Column(name="actionparam")
    private String actionparam;
    @Column(name="appendcapflag")
    private Integer appendcapflag;
    @Column(name="appendpnodeid")
    private Integer appendpnodeid;
    @Column(name="caption")
    private String caption;
    @Column(name="checked")
    private Integer checked;
    @Column(name="childcntpsdefid")
    private String childcntpsdefid;
    @Column(name="childcntpsdefname")
    private String childcntpsdefname;
    @Column(name="clspsdefid")
    private String clspsdefid;
    @Column(name="clspsdefname")
    private String clspsdefname;
    @Column(name="cmrefresh")
    private Integer cmrefresh;
    @Column(name="cmremove")
    private Integer cmremove;
    @Column(name="counterid")
    private String counterid;
    @Column(name="countermode")
    private Integer countermode;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcode")
    private String customcode;
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
    @Column(name="datasource")
    private String datasource;
    @Column(name="datatypepsdefid")
    private String datatypepsdefid;
    @Column(name="datatypepsdefname")
    private String datatypepsdefname;
    @Column(name="disableselect")
    private Integer disableselect;
    @Column(name="distinctmode")
    private Integer distinctmode;
    @Column(name="dynaclass")
    private String dynaclass;
    @Column(name="editdatamode")
    private String editdatamode;
    @Column(name="editmode")
    private Integer editmode;
    @Column(name="enablecheck")
    private Integer enablecheck;
    @Column(name="enablepaging")
    private Integer enablepaging;
    @Column(name="enablequicksearch")
    private Integer enablequicksearch;
    @Column(name="enableup")
    private Integer enableup;
    @Column(name="enableviewactions")
    private Integer enableviewactions;
    @Column(name="expand")
    private Integer expand;
    @Column(name="fieldname")
    private String fieldname;
    @Column(name="filterpsdedsid")
    private String filterpsdedsid;
    @Column(name="filterpsdedsname")
    private String filterpsdedsname;
    @Column(name="iconpsdefid")
    private String iconpsdefid;
    @Column(name="iconpsdefname")
    private String iconpsdefname;
    @Column(name="keypsdefid")
    private String keypsdefid;
    @Column(name="keypsdefname")
    private String keypsdefname;
    @Column(name="leafflagpsdefid")
    private String leafflagpsdefid;
    @Column(name="leafflagpsdefname")
    private String leafflagpsdefname;
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
    @Column(name="navviewfilterdesc")
    private String navviewfilterdesc;
    @Column(name="navviewparam")
    private String navviewparam;
    @Column(name="newdatamode")
    private String newdatamode;
    @Column(name="no2psdeuagroupid")
    private String no2psdeuagroupid;
    @Column(name="no2psdeuagroupname")
    private String no2psdeuagroupname;
    @Column(name="nodeaction")
    private String nodeaction;
    @Column(name="nodedatatype")
    private String nodedatatype;
    @Column(name="nodeid2psdefid")
    private String nodeid2psdefid;
    @Column(name="nodeid2psdefname")
    private String nodeid2psdefname;
    @Column(name="nodeid3psdefid")
    private String nodeid3psdefid;
    @Column(name="nodeid3psdefname")
    private String nodeid3psdefname;
    @Column(name="nodeid4psdefid")
    private String nodeid4psdefid;
    @Column(name="nodeid4psdefname")
    private String nodeid4psdefname;
    @Column(name="nodeidpsdefid")
    private String nodeidpsdefid;
    @Column(name="nodeidpsdefname")
    private String nodeidpsdefname;
    @Column(name="nodetype")
    private String nodetype;
    @Column(name="nodevalue")
    private String nodevalue;
    @Column(name="pagesize")
    private Integer pagesize;
    @Column(name="preventxss")
    private Integer preventxss;
    @Column(name="pscodelistid")
    private String pscodelistid;
    @Column(name="pscodelistname")
    private String pscodelistname;
    @Column(name="psdeactionid")
    private String psdeactionid;
    @Column(name="psdeactionname")
    private String psdeactionname;
    @Column(name="psdedsid")
    private String psdedsid;
    @Column(name="psdedsname")
    private String psdedsname;
    @Column(name="psdegridid")
    private String psdegridid;
    @Column(name="psdegridname")
    private String psdegridname;
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
    @Column(name="psdetreenodeid")
    private String psdetreenodeid;
    @Column(name="psdetreenodename")
    private String psdetreenodename;
    @Column(name="psdetreeviewid")
    private String psdetreeviewid;
    @Column(name="psdetreeviewname")
    private String psdetreeviewname;
    @Column(name="psdeuagroupid")
    private String psdeuagroupid;
    @Column(name="psdeuagroupname")
    private String psdeuagroupname;
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
    @Column(name="pssyspfpluginid")
    private String pssyspfpluginid;
    @Column(name="pssyspfpluginname")
    private String pssyspfpluginname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssysuniresid")
    private String pssysuniresid;
    @Column(name="pssysuniresname")
    private String pssysuniresname;
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
    @Column(name="rootnode")
    private Integer rootnode;
    @Column(name="selected")
    private Integer selected;
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
    @Column(name="sortdir")
    private String sortdir;
    @Column(name="sortpsdefid")
    private String sortpsdefid;
    @Column(name="sortpsdefname")
    private String sortpsdefname;
    @Column(name="textpsdefid")
    private String textpsdefid;
    @Column(name="textpsdefname")
    private String textpsdefname;
    @Column(name="tippslanresid")
    private String tippslanresid;
    @Column(name="tippslanresname")
    private String tippslanresname;
    @Column(name="tipspsdefid")
    private String tipspsdefid;
    @Column(name="tipspsdefname")
    private String tipspsdefname;
    @Column(name="tooltipinfo")
    private String tooltipinfo;
    @Column(name="treenodetype")
    private String treenodetype;
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
    @Column(name="viewactions")
    private Integer viewactions;
    private Integer objPSCodeListLock = new Integer(1);
    private PSCodeList pscodelist = null;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objMovePSDEActionLock = new Integer(1);
    private PSDEAction movepsdeaction = null;
    private Integer objPSDEActionLock = new Integer(1);
    private PSDEAction psdeaction = null;
    private Integer objRemovePSDEActionLock = new Integer(1);
    private PSDEAction removepsdeaction = null;
    private Integer objUpdatePSDEActionLock = new Integer(1);
    private PSDEAction updatepsdeaction = null;
    private Integer objFilterPSDEDSLock = new Integer(1);
    private PSDEDataSet filterpsdeds = null;
    private Integer objPSDEDSLock = new Integer(1);
    private PSDEDataSet psdeds = null;
    private Integer objChildCntPSDEFLock = new Integer(1);
    private PSDEField childcntpsdef = null;
    private Integer objClsPSDEFLock = new Integer(1);
    private PSDEField clspsdef = null;
    private Integer objData2PSDEFLock = new Integer(1);
    private PSDEField data2psdef = null;
    private Integer objDataPSDEFLock = new Integer(1);
    private PSDEField datapsdef = null;
    private Integer objDataTypePSDEFLock = new Integer(1);
    private PSDEField datatypepsdef = null;
    private Integer objIconPSDEFLock = new Integer(1);
    private PSDEField iconpsdef = null;
    private Integer objKeyPSDEFLock = new Integer(1);
    private PSDEField keypsdef = null;
    private Integer objLeafFlagPSDEFLock = new Integer(1);
    private PSDEField leafflagpsdef = null;
    private Integer objLinkPSDEFLock = new Integer(1);
    private PSDEField linkpsdef = null;
    private Integer objNodeId2PSDEFLock = new Integer(1);
    private PSDEField nodeid2psdef = null;
    private Integer objNodeId3PSDEFLock = new Integer(1);
    private PSDEField nodeid3psdef = null;
    private Integer objNodeId4PSDEFLock = new Integer(1);
    private PSDEField nodeid4psdef = null;
    private Integer objNodeIdPSDEFLock = new Integer(1);
    private PSDEField nodeidpsdef = null;
    private Integer objShapeClsPSDEFLock = new Integer(1);
    private PSDEField shapeclspsdef = null;
    private Integer objSortPSDEFLock = new Integer(1);
    private PSDEField sortpsdef = null;
    private Integer objTextPSDEFLock = new Integer(1);
    private PSDEField textpsdef = null;
    private Integer objTipsPSDEFLock = new Integer(1);
    private PSDEField tipspsdef = null;
    private Integer objPSDEGridLock = new Integer(1);
    private PSDEGrid psdegrid = null;
    private Integer objPSDELogicLock = new Integer(1);
    private PSDELogic psdelogic = null;
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
    private Integer objPSDETreeViewLock = new Integer(1);
    private PSDETreeView psdetreeview = null;
    private Integer objNo2PSDEUAGroupLock = new Integer(1);
    private PSDEUAGroup no2psdeuagroup = null;
    private Integer objPSDEUAGroupLock = new Integer(1);
    private PSDEUAGroup psdeuagroup = null;
    private Integer objPSDEViewBaseLock = new Integer(1);
    private PSDEViewBase psdeviewbase = null;
    private Integer objNamePSLanResLock = new Integer(1);
    private PSLanguageRes namepslanres = null;
    private Integer objTipPSLanResLock = new Integer(1);
    private PSLanguageRes tippslanres = null;
    private Integer objPSSysCssLock = new Integer(1);
    private PSSysCss pssyscss = null;
    private Integer objShapePSSysCssLock = new Integer(1);
    private PSSysCss shapepssyscss = null;
    private Integer objPSSysImageLock = new Integer(1);
    private PSSysImage pssysimage = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSSysUniResLock = new Integer(1);
    private PSSysUniRes pssysunires = null;
    private Integer objPSSysViewPanelLock = new Integer(1);
    private PSSysViewPanel pssysviewpanel = null;
    private Integer objPSDETEIUpdatesLock = new Integer(1);
    private ArrayList<PSDETEIUpdate> psdeteiupdates = null;
    private Integer objPSDETreeNodeColsLock = new Integer(1);
    private ArrayList<PSDETreeNodeCol> psdetreenodecols = null;

    public void setActionParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionparam = string;
        this.actionparamDirtyFlag = true;
    }

    public String getActionParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionParam();
        }
        return this.actionparam;
    }

    public boolean isActionParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionParamDirty();
        }
        return this.actionparamDirtyFlag;
    }

    public void resetActionParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionParam();
            return;
        }
        this.actionparamDirtyFlag = false;
        this.actionparam = null;
    }

    public void setAppendCapFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppendCapFlag(n);
            return;
        }
        this.appendcapflag = n;
        this.appendcapflagDirtyFlag = true;
    }

    public Integer getAppendCapFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppendCapFlag();
        }
        return this.appendcapflag;
    }

    public boolean isAppendCapFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppendCapFlagDirty();
        }
        return this.appendcapflagDirtyFlag;
    }

    public void resetAppendCapFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppendCapFlag();
            return;
        }
        this.appendcapflagDirtyFlag = false;
        this.appendcapflag = null;
    }

    public void setAppendPNodeId(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppendPNodeId(n);
            return;
        }
        this.appendpnodeid = n;
        this.appendpnodeidDirtyFlag = true;
    }

    public Integer getAppendPNodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppendPNodeId();
        }
        return this.appendpnodeid;
    }

    public boolean isAppendPNodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppendPNodeIdDirty();
        }
        return this.appendpnodeidDirtyFlag;
    }

    public void resetAppendPNodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppendPNodeId();
            return;
        }
        this.appendpnodeidDirtyFlag = false;
        this.appendpnodeid = null;
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

    public void setChecked(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setChecked(n);
            return;
        }
        this.checked = n;
        this.checkedDirtyFlag = true;
    }

    public Integer getChecked() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getChecked();
        }
        return this.checked;
    }

    public boolean isCheckedDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCheckedDirty();
        }
        return this.checkedDirtyFlag;
    }

    public void resetChecked() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetChecked();
            return;
        }
        this.checkedDirtyFlag = false;
        this.checked = null;
    }

    public void setChildCntPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setChildCntPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.childcntpsdefid = string;
        this.childcntpsdefidDirtyFlag = true;
    }

    public String getChildCntPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getChildCntPSDEFId();
        }
        return this.childcntpsdefid;
    }

    public boolean isChildCntPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isChildCntPSDEFIdDirty();
        }
        return this.childcntpsdefidDirtyFlag;
    }

    public void resetChildCntPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetChildCntPSDEFId();
            return;
        }
        this.childcntpsdefidDirtyFlag = false;
        this.childcntpsdefid = null;
    }

    public void setChildCntPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setChildCntPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.childcntpsdefname = string;
        this.childcntpsdefnameDirtyFlag = true;
    }

    public String getChildCntPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getChildCntPSDEFName();
        }
        return this.childcntpsdefname;
    }

    public boolean isChildCntPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isChildCntPSDEFNameDirty();
        }
        return this.childcntpsdefnameDirtyFlag;
    }

    public void resetChildCntPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetChildCntPSDEFName();
            return;
        }
        this.childcntpsdefnameDirtyFlag = false;
        this.childcntpsdefname = null;
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

    public void setCMRefresh(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCMRefresh(n);
            return;
        }
        this.cmrefresh = n;
        this.cmrefreshDirtyFlag = true;
    }

    public Integer getCMRefresh() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCMRefresh();
        }
        return this.cmrefresh;
    }

    public boolean isCMRefreshDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCMRefreshDirty();
        }
        return this.cmrefreshDirtyFlag;
    }

    public void resetCMRefresh() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCMRefresh();
            return;
        }
        this.cmrefreshDirtyFlag = false;
        this.cmrefresh = null;
    }

    public void setCMRemove(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCMRemove(n);
            return;
        }
        this.cmremove = n;
        this.cmremoveDirtyFlag = true;
    }

    public Integer getCMRemove() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCMRemove();
        }
        return this.cmremove;
    }

    public boolean isCMRemoveDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCMRemoveDirty();
        }
        return this.cmremoveDirtyFlag;
    }

    public void resetCMRemove() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCMRemove();
            return;
        }
        this.cmremoveDirtyFlag = false;
        this.cmremove = null;
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

    public void setDataSource(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataSource(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.datasource = string;
        this.datasourceDirtyFlag = true;
    }

    public String getDataSource() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataSource();
        }
        return this.datasource;
    }

    public boolean isDataSourceDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataSourceDirty();
        }
        return this.datasourceDirtyFlag;
    }

    public void resetDataSource() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataSource();
            return;
        }
        this.datasourceDirtyFlag = false;
        this.datasource = null;
    }

    public void setDataTypePSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataTypePSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.datatypepsdefid = string;
        this.datatypepsdefidDirtyFlag = true;
    }

    public String getDataTypePSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataTypePSDEFId();
        }
        return this.datatypepsdefid;
    }

    public boolean isDataTypePSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataTypePSDEFIdDirty();
        }
        return this.datatypepsdefidDirtyFlag;
    }

    public void resetDataTypePSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataTypePSDEFId();
            return;
        }
        this.datatypepsdefidDirtyFlag = false;
        this.datatypepsdefid = null;
    }

    public void setDataTypePSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataTypePSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.datatypepsdefname = string;
        this.datatypepsdefnameDirtyFlag = true;
    }

    public String getDataTypePSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataTypePSDEFName();
        }
        return this.datatypepsdefname;
    }

    public boolean isDataTypePSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataTypePSDEFNameDirty();
        }
        return this.datatypepsdefnameDirtyFlag;
    }

    public void resetDataTypePSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataTypePSDEFName();
            return;
        }
        this.datatypepsdefnameDirtyFlag = false;
        this.datatypepsdefname = null;
    }

    public void setDisableSelect(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDisableSelect(n);
            return;
        }
        this.disableselect = n;
        this.disableselectDirtyFlag = true;
    }

    public Integer getDisableSelect() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDisableSelect();
        }
        return this.disableselect;
    }

    public boolean isDisableSelectDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDisableSelectDirty();
        }
        return this.disableselectDirtyFlag;
    }

    public void resetDisableSelect() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDisableSelect();
            return;
        }
        this.disableselectDirtyFlag = false;
        this.disableselect = null;
    }

    public void setDistinctMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDistinctMode(n);
            return;
        }
        this.distinctmode = n;
        this.distinctmodeDirtyFlag = true;
    }

    public Integer getDistinctMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDistinctMode();
        }
        return this.distinctmode;
    }

    public boolean isDistinctModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDistinctModeDirty();
        }
        return this.distinctmodeDirtyFlag;
    }

    public void resetDistinctMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDistinctMode();
            return;
        }
        this.distinctmodeDirtyFlag = false;
        this.distinctmode = null;
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

    public void setEditDataMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEditDataMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.editdatamode = string;
        this.editdatamodeDirtyFlag = true;
    }

    public String getEditDataMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEditDataMode();
        }
        return this.editdatamode;
    }

    public boolean isEditDataModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEditDataModeDirty();
        }
        return this.editdatamodeDirtyFlag;
    }

    public void resetEditDataMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEditDataMode();
            return;
        }
        this.editdatamodeDirtyFlag = false;
        this.editdatamode = null;
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

    public void setEnableCheck(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableCheck(n);
            return;
        }
        this.enablecheck = n;
        this.enablecheckDirtyFlag = true;
    }

    public Integer getEnableCheck() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableCheck();
        }
        return this.enablecheck;
    }

    public boolean isEnableCheckDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableCheckDirty();
        }
        return this.enablecheckDirtyFlag;
    }

    public void resetEnableCheck() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableCheck();
            return;
        }
        this.enablecheckDirtyFlag = false;
        this.enablecheck = null;
    }

    public void setEnablePaging(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnablePaging(n);
            return;
        }
        this.enablepaging = n;
        this.enablepagingDirtyFlag = true;
    }

    public Integer getEnablePaging() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnablePaging();
        }
        return this.enablepaging;
    }

    public boolean isEnablePagingDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnablePagingDirty();
        }
        return this.enablepagingDirtyFlag;
    }

    public void resetEnablePaging() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnablePaging();
            return;
        }
        this.enablepagingDirtyFlag = false;
        this.enablepaging = null;
    }

    public void setEnableQuickSearch(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableQuickSearch(n);
            return;
        }
        this.enablequicksearch = n;
        this.enablequicksearchDirtyFlag = true;
    }

    public Integer getEnableQuickSearch() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableQuickSearch();
        }
        return this.enablequicksearch;
    }

    public boolean isEnableQuickSearchDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableQuickSearchDirty();
        }
        return this.enablequicksearchDirtyFlag;
    }

    public void resetEnableQuickSearch() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableQuickSearch();
            return;
        }
        this.enablequicksearchDirtyFlag = false;
        this.enablequicksearch = null;
    }

    public void setEnableUP(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableUP(n);
            return;
        }
        this.enableup = n;
        this.enableupDirtyFlag = true;
    }

    public Integer getEnableUP() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableUP();
        }
        return this.enableup;
    }

    public boolean isEnableUPDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableUPDirty();
        }
        return this.enableupDirtyFlag;
    }

    public void resetEnableUP() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableUP();
            return;
        }
        this.enableupDirtyFlag = false;
        this.enableup = null;
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

    public void setFieldName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFieldName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fieldname = string;
        this.fieldnameDirtyFlag = true;
    }

    public String getFieldName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFieldName();
        }
        return this.fieldname;
    }

    public boolean isFieldNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFieldNameDirty();
        }
        return this.fieldnameDirtyFlag;
    }

    public void resetFieldName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFieldName();
            return;
        }
        this.fieldnameDirtyFlag = false;
        this.fieldname = null;
    }

    public void setFilterPSDEDSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFilterPSDEDSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.filterpsdedsid = string;
        this.filterpsdedsidDirtyFlag = true;
    }

    public String getFilterPSDEDSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFilterPSDEDSId();
        }
        return this.filterpsdedsid;
    }

    public boolean isFilterPSDEDSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFilterPSDEDSIdDirty();
        }
        return this.filterpsdedsidDirtyFlag;
    }

    public void resetFilterPSDEDSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFilterPSDEDSId();
            return;
        }
        this.filterpsdedsidDirtyFlag = false;
        this.filterpsdedsid = null;
    }

    public void setFilterPSDEDSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFilterPSDEDSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.filterpsdedsname = string;
        this.filterpsdedsnameDirtyFlag = true;
    }

    public String getFilterPSDEDSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFilterPSDEDSName();
        }
        return this.filterpsdedsname;
    }

    public boolean isFilterPSDEDSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFilterPSDEDSNameDirty();
        }
        return this.filterpsdedsnameDirtyFlag;
    }

    public void resetFilterPSDEDSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFilterPSDEDSName();
            return;
        }
        this.filterpsdedsnameDirtyFlag = false;
        this.filterpsdedsname = null;
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

    public void setLeafFlagPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLeafFlagPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.leafflagpsdefid = string;
        this.leafflagpsdefidDirtyFlag = true;
    }

    public String getLeafFlagPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLeafFlagPSDEFId();
        }
        return this.leafflagpsdefid;
    }

    public boolean isLeafFlagPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLeafFlagPSDEFIdDirty();
        }
        return this.leafflagpsdefidDirtyFlag;
    }

    public void resetLeafFlagPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLeafFlagPSDEFId();
            return;
        }
        this.leafflagpsdefidDirtyFlag = false;
        this.leafflagpsdefid = null;
    }

    public void setLeafFlagPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLeafFlagPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.leafflagpsdefname = string;
        this.leafflagpsdefnameDirtyFlag = true;
    }

    public String getLeafFlagPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLeafFlagPSDEFName();
        }
        return this.leafflagpsdefname;
    }

    public boolean isLeafFlagPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLeafFlagPSDEFNameDirty();
        }
        return this.leafflagpsdefnameDirtyFlag;
    }

    public void resetLeafFlagPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLeafFlagPSDEFName();
            return;
        }
        this.leafflagpsdefnameDirtyFlag = false;
        this.leafflagpsdefname = null;
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

    public void setNavViewFilterDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNavViewFilterDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.navviewfilterdesc = string;
        this.navviewfilterdescDirtyFlag = true;
    }

    public String getNavViewFilterDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNavViewFilterDesc();
        }
        return this.navviewfilterdesc;
    }

    public boolean isNavViewFilterDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNavViewFilterDescDirty();
        }
        return this.navviewfilterdescDirtyFlag;
    }

    public void resetNavViewFilterDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNavViewFilterDesc();
            return;
        }
        this.navviewfilterdescDirtyFlag = false;
        this.navviewfilterdesc = null;
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

    public void setNewDataMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNewDataMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.newdatamode = string;
        this.newdatamodeDirtyFlag = true;
    }

    public String getNewDataMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNewDataMode();
        }
        return this.newdatamode;
    }

    public boolean isNewDataModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNewDataModeDirty();
        }
        return this.newdatamodeDirtyFlag;
    }

    public void resetNewDataMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNewDataMode();
            return;
        }
        this.newdatamodeDirtyFlag = false;
        this.newdatamode = null;
    }

    public void setNo2PSDEUAGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo2PSDEUAGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no2psdeuagroupid = string;
        this.no2psdeuagroupidDirtyFlag = true;
    }

    public String getNo2PSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2PSDEUAGroupId();
        }
        return this.no2psdeuagroupid;
    }

    public boolean isNo2PSDEUAGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo2PSDEUAGroupIdDirty();
        }
        return this.no2psdeuagroupidDirtyFlag;
    }

    public void resetNo2PSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo2PSDEUAGroupId();
            return;
        }
        this.no2psdeuagroupidDirtyFlag = false;
        this.no2psdeuagroupid = null;
    }

    public void setNo2PSDEUAGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo2PSDEUAGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no2psdeuagroupname = string;
        this.no2psdeuagroupnameDirtyFlag = true;
    }

    public String getNo2PSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2PSDEUAGroupName();
        }
        return this.no2psdeuagroupname;
    }

    public boolean isNo2PSDEUAGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo2PSDEUAGroupNameDirty();
        }
        return this.no2psdeuagroupnameDirtyFlag;
    }

    public void resetNo2PSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo2PSDEUAGroupName();
            return;
        }
        this.no2psdeuagroupnameDirtyFlag = false;
        this.no2psdeuagroupname = null;
    }

    public void setNodeAction(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNodeAction(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.nodeaction = string;
        this.nodeactionDirtyFlag = true;
    }

    public String getNodeAction() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNodeAction();
        }
        return this.nodeaction;
    }

    public boolean isNodeActionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNodeActionDirty();
        }
        return this.nodeactionDirtyFlag;
    }

    public void resetNodeAction() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNodeAction();
            return;
        }
        this.nodeactionDirtyFlag = false;
        this.nodeaction = null;
    }

    public void setNodeDataType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNodeDataType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.nodedatatype = string;
        this.nodedatatypeDirtyFlag = true;
    }

    public String getNodeDataType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNodeDataType();
        }
        return this.nodedatatype;
    }

    public boolean isNodeDataTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNodeDataTypeDirty();
        }
        return this.nodedatatypeDirtyFlag;
    }

    public void resetNodeDataType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNodeDataType();
            return;
        }
        this.nodedatatypeDirtyFlag = false;
        this.nodedatatype = null;
    }

    public void setNodeId2PSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNodeId2PSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.nodeid2psdefid = string;
        this.nodeid2psdefidDirtyFlag = true;
    }

    public String getNodeId2PSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNodeId2PSDEFId();
        }
        return this.nodeid2psdefid;
    }

    public boolean isNodeId2PSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNodeId2PSDEFIdDirty();
        }
        return this.nodeid2psdefidDirtyFlag;
    }

    public void resetNodeId2PSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNodeId2PSDEFId();
            return;
        }
        this.nodeid2psdefidDirtyFlag = false;
        this.nodeid2psdefid = null;
    }

    public void setNodeId2PSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNodeId2PSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.nodeid2psdefname = string;
        this.nodeid2psdefnameDirtyFlag = true;
    }

    public String getNodeId2PSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNodeId2PSDEFName();
        }
        return this.nodeid2psdefname;
    }

    public boolean isNodeId2PSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNodeId2PSDEFNameDirty();
        }
        return this.nodeid2psdefnameDirtyFlag;
    }

    public void resetNodeId2PSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNodeId2PSDEFName();
            return;
        }
        this.nodeid2psdefnameDirtyFlag = false;
        this.nodeid2psdefname = null;
    }

    public void setNodeId3PSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNodeId3PSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.nodeid3psdefid = string;
        this.nodeid3psdefidDirtyFlag = true;
    }

    public String getNodeId3PSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNodeId3PSDEFId();
        }
        return this.nodeid3psdefid;
    }

    public boolean isNodeId3PSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNodeId3PSDEFIdDirty();
        }
        return this.nodeid3psdefidDirtyFlag;
    }

    public void resetNodeId3PSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNodeId3PSDEFId();
            return;
        }
        this.nodeid3psdefidDirtyFlag = false;
        this.nodeid3psdefid = null;
    }

    public void setNodeId3PSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNodeId3PSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.nodeid3psdefname = string;
        this.nodeid3psdefnameDirtyFlag = true;
    }

    public String getNodeId3PSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNodeId3PSDEFName();
        }
        return this.nodeid3psdefname;
    }

    public boolean isNodeId3PSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNodeId3PSDEFNameDirty();
        }
        return this.nodeid3psdefnameDirtyFlag;
    }

    public void resetNodeId3PSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNodeId3PSDEFName();
            return;
        }
        this.nodeid3psdefnameDirtyFlag = false;
        this.nodeid3psdefname = null;
    }

    public void setNodeId4PSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNodeId4PSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.nodeid4psdefid = string;
        this.nodeid4psdefidDirtyFlag = true;
    }

    public String getNodeId4PSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNodeId4PSDEFId();
        }
        return this.nodeid4psdefid;
    }

    public boolean isNodeId4PSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNodeId4PSDEFIdDirty();
        }
        return this.nodeid4psdefidDirtyFlag;
    }

    public void resetNodeId4PSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNodeId4PSDEFId();
            return;
        }
        this.nodeid4psdefidDirtyFlag = false;
        this.nodeid4psdefid = null;
    }

    public void setNodeId4PSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNodeId4PSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.nodeid4psdefname = string;
        this.nodeid4psdefnameDirtyFlag = true;
    }

    public String getNodeId4PSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNodeId4PSDEFName();
        }
        return this.nodeid4psdefname;
    }

    public boolean isNodeId4PSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNodeId4PSDEFNameDirty();
        }
        return this.nodeid4psdefnameDirtyFlag;
    }

    public void resetNodeId4PSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNodeId4PSDEFName();
            return;
        }
        this.nodeid4psdefnameDirtyFlag = false;
        this.nodeid4psdefname = null;
    }

    public void setNodeIdPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNodeIdPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.nodeidpsdefid = string;
        this.nodeidpsdefidDirtyFlag = true;
    }

    public String getNodeIdPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNodeIdPSDEFId();
        }
        return this.nodeidpsdefid;
    }

    public boolean isNodeIdPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNodeIdPSDEFIdDirty();
        }
        return this.nodeidpsdefidDirtyFlag;
    }

    public void resetNodeIdPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNodeIdPSDEFId();
            return;
        }
        this.nodeidpsdefidDirtyFlag = false;
        this.nodeidpsdefid = null;
    }

    public void setNodeIdPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNodeIdPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.nodeidpsdefname = string;
        this.nodeidpsdefnameDirtyFlag = true;
    }

    public String getNodeIdPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNodeIdPSDEFName();
        }
        return this.nodeidpsdefname;
    }

    public boolean isNodeIdPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNodeIdPSDEFNameDirty();
        }
        return this.nodeidpsdefnameDirtyFlag;
    }

    public void resetNodeIdPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNodeIdPSDEFName();
            return;
        }
        this.nodeidpsdefnameDirtyFlag = false;
        this.nodeidpsdefname = null;
    }

    public void setNodeType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNodeType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.nodetype = string;
        this.nodetypeDirtyFlag = true;
    }

    public String getNodeType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNodeType();
        }
        return this.nodetype;
    }

    public boolean isNodeTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNodeTypeDirty();
        }
        return this.nodetypeDirtyFlag;
    }

    public void resetNodeType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNodeType();
            return;
        }
        this.nodetypeDirtyFlag = false;
        this.nodetype = null;
    }

    public void setNodeValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNodeValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.nodevalue = string;
        this.nodevalueDirtyFlag = true;
    }

    public String getNodeValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNodeValue();
        }
        return this.nodevalue;
    }

    public boolean isNodeValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNodeValueDirty();
        }
        return this.nodevalueDirtyFlag;
    }

    public void resetNodeValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNodeValue();
            return;
        }
        this.nodevalueDirtyFlag = false;
        this.nodevalue = null;
    }

    public void setPageSize(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPageSize(n);
            return;
        }
        this.pagesize = n;
        this.pagesizeDirtyFlag = true;
    }

    public Integer getPageSize() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPageSize();
        }
        return this.pagesize;
    }

    public boolean isPageSizeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPageSizeDirty();
        }
        return this.pagesizeDirtyFlag;
    }

    public void resetPageSize() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPageSize();
            return;
        }
        this.pagesizeDirtyFlag = false;
        this.pagesize = null;
    }

    public void setPreventXSS(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPreventXSS(n);
            return;
        }
        this.preventxss = n;
        this.preventxssDirtyFlag = true;
    }

    public Integer getPreventXSS() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPreventXSS();
        }
        return this.preventxss;
    }

    public boolean isPreventXSSDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPreventXSSDirty();
        }
        return this.preventxssDirtyFlag;
    }

    public void resetPreventXSS() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPreventXSS();
            return;
        }
        this.preventxssDirtyFlag = false;
        this.preventxss = null;
    }

    public void setPSCodeListId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCodeListId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscodelistid = string;
        this.pscodelistidDirtyFlag = true;
    }

    public String getPSCodeListId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeListId();
        }
        return this.pscodelistid;
    }

    public boolean isPSCodeListIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCodeListIdDirty();
        }
        return this.pscodelistidDirtyFlag;
    }

    public void resetPSCodeListId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCodeListId();
            return;
        }
        this.pscodelistidDirtyFlag = false;
        this.pscodelistid = null;
    }

    public void setPSCodeListName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCodeListName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscodelistname = string;
        this.pscodelistnameDirtyFlag = true;
    }

    public String getPSCodeListName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeListName();
        }
        return this.pscodelistname;
    }

    public boolean isPSCodeListNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCodeListNameDirty();
        }
        return this.pscodelistnameDirtyFlag;
    }

    public void resetPSCodeListName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCodeListName();
            return;
        }
        this.pscodelistnameDirtyFlag = false;
        this.pscodelistname = null;
    }

    public void setPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactionid = string;
        this.psdeactionidDirtyFlag = true;
    }

    public String getPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionId();
        }
        return this.psdeactionid;
    }

    public boolean isPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionIdDirty();
        }
        return this.psdeactionidDirtyFlag;
    }

    public void resetPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionId();
            return;
        }
        this.psdeactionidDirtyFlag = false;
        this.psdeactionid = null;
    }

    public void setPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactionname = string;
        this.psdeactionnameDirtyFlag = true;
    }

    public String getPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionName();
        }
        return this.psdeactionname;
    }

    public boolean isPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionNameDirty();
        }
        return this.psdeactionnameDirtyFlag;
    }

    public void resetPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionName();
            return;
        }
        this.psdeactionnameDirtyFlag = false;
        this.psdeactionname = null;
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

    public void setPSDEGridId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGridId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegridid = string;
        this.psdegrididDirtyFlag = true;
    }

    public String getPSDEGridId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGridId();
        }
        return this.psdegridid;
    }

    public boolean isPSDEGridIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGridIdDirty();
        }
        return this.psdegrididDirtyFlag;
    }

    public void resetPSDEGridId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGridId();
            return;
        }
        this.psdegrididDirtyFlag = false;
        this.psdegridid = null;
    }

    public void setPSDEGridName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGridName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegridname = string;
        this.psdegridnameDirtyFlag = true;
    }

    public String getPSDEGridName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGridName();
        }
        return this.psdegridname;
    }

    public boolean isPSDEGridNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGridNameDirty();
        }
        return this.psdegridnameDirtyFlag;
    }

    public void resetPSDEGridName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGridName();
            return;
        }
        this.psdegridnameDirtyFlag = false;
        this.psdegridname = null;
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

    public void setPSDETreeNodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETreeNodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetreenodeid = string;
        this.psdetreenodeidDirtyFlag = true;
    }

    public String getPSDETreeNodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeNodeId();
        }
        return this.psdetreenodeid;
    }

    public boolean isPSDETreeNodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETreeNodeIdDirty();
        }
        return this.psdetreenodeidDirtyFlag;
    }

    public void resetPSDETreeNodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETreeNodeId();
            return;
        }
        this.psdetreenodeidDirtyFlag = false;
        this.psdetreenodeid = null;
    }

    public void setPSDETreeNodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETreeNodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetreenodename = string;
        this.psdetreenodenameDirtyFlag = true;
    }

    public String getPSDETreeNodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeNodeName();
        }
        return this.psdetreenodename;
    }

    public boolean isPSDETreeNodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETreeNodeNameDirty();
        }
        return this.psdetreenodenameDirtyFlag;
    }

    public void resetPSDETreeNodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETreeNodeName();
            return;
        }
        this.psdetreenodenameDirtyFlag = false;
        this.psdetreenodename = null;
    }

    public void setPSDETreeViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETreeViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetreeviewid = string;
        this.psdetreeviewidDirtyFlag = true;
    }

    public String getPSDETreeViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeViewId();
        }
        return this.psdetreeviewid;
    }

    public boolean isPSDETreeViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETreeViewIdDirty();
        }
        return this.psdetreeviewidDirtyFlag;
    }

    public void resetPSDETreeViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETreeViewId();
            return;
        }
        this.psdetreeviewidDirtyFlag = false;
        this.psdetreeviewid = null;
    }

    public void setPSDETreeViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETreeViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetreeviewname = string;
        this.psdetreeviewnameDirtyFlag = true;
    }

    public String getPSDETreeViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeViewName();
        }
        return this.psdetreeviewname;
    }

    public boolean isPSDETreeViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETreeViewNameDirty();
        }
        return this.psdetreeviewnameDirtyFlag;
    }

    public void resetPSDETreeViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETreeViewName();
            return;
        }
        this.psdetreeviewnameDirtyFlag = false;
        this.psdetreeviewname = null;
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

    public void setRootNode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRootNode(n);
            return;
        }
        this.rootnode = n;
        this.rootnodeDirtyFlag = true;
    }

    public Integer getRootNode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRootNode();
        }
        return this.rootnode;
    }

    public boolean isRootNodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRootNodeDirty();
        }
        return this.rootnodeDirtyFlag;
    }

    public void resetRootNode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRootNode();
            return;
        }
        this.rootnodeDirtyFlag = false;
        this.rootnode = null;
    }

    public void setSelected(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSelected(n);
            return;
        }
        this.selected = n;
        this.selectedDirtyFlag = true;
    }

    public Integer getSelected() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSelected();
        }
        return this.selected;
    }

    public boolean isSelectedDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSelectedDirty();
        }
        return this.selectedDirtyFlag;
    }

    public void resetSelected() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSelected();
            return;
        }
        this.selectedDirtyFlag = false;
        this.selected = null;
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

    public void setSortDir(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSortDir(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sortdir = string;
        this.sortdirDirtyFlag = true;
    }

    public String getSortDir() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSortDir();
        }
        return this.sortdir;
    }

    public boolean isSortDirDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSortDirDirty();
        }
        return this.sortdirDirtyFlag;
    }

    public void resetSortDir() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSortDir();
            return;
        }
        this.sortdirDirtyFlag = false;
        this.sortdir = null;
    }

    public void setSortPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSortPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sortpsdefid = string;
        this.sortpsdefidDirtyFlag = true;
    }

    public String getSortPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSortPSDEFId();
        }
        return this.sortpsdefid;
    }

    public boolean isSortPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSortPSDEFIdDirty();
        }
        return this.sortpsdefidDirtyFlag;
    }

    public void resetSortPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSortPSDEFId();
            return;
        }
        this.sortpsdefidDirtyFlag = false;
        this.sortpsdefid = null;
    }

    public void setSortPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSortPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sortpsdefname = string;
        this.sortpsdefnameDirtyFlag = true;
    }

    public String getSortPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSortPSDEFName();
        }
        return this.sortpsdefname;
    }

    public boolean isSortPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSortPSDEFNameDirty();
        }
        return this.sortpsdefnameDirtyFlag;
    }

    public void resetSortPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSortPSDEFName();
            return;
        }
        this.sortpsdefnameDirtyFlag = false;
        this.sortpsdefname = null;
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

    public void setTreeNodeType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTreeNodeType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.treenodetype = string;
        this.treenodetypeDirtyFlag = true;
    }

    public String getTreeNodeType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTreeNodeType();
        }
        return this.treenodetype;
    }

    public boolean isTreeNodeTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTreeNodeTypeDirty();
        }
        return this.treenodetypeDirtyFlag;
    }

    public void resetTreeNodeType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTreeNodeType();
            return;
        }
        this.treenodetypeDirtyFlag = false;
        this.treenodetype = null;
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
        PSDETreeNodeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDETreeNodeBase pSDETreeNodeBase) {
        pSDETreeNodeBase.resetActionParam();
        pSDETreeNodeBase.resetAppendCapFlag();
        pSDETreeNodeBase.resetAppendPNodeId();
        pSDETreeNodeBase.resetCaption();
        pSDETreeNodeBase.resetChecked();
        pSDETreeNodeBase.resetChildCntPSDEFId();
        pSDETreeNodeBase.resetChildCntPSDEFName();
        pSDETreeNodeBase.resetClsPSDEFId();
        pSDETreeNodeBase.resetClsPSDEFName();
        pSDETreeNodeBase.resetCMRefresh();
        pSDETreeNodeBase.resetCMRemove();
        pSDETreeNodeBase.resetCounterId();
        pSDETreeNodeBase.resetCounterMode();
        pSDETreeNodeBase.resetCreateDate();
        pSDETreeNodeBase.resetCreateMan();
        pSDETreeNodeBase.resetCustomCode();
        pSDETreeNodeBase.resetCustomCond();
        pSDETreeNodeBase.resetCustomType();
        pSDETreeNodeBase.resetData2PSDEFId();
        pSDETreeNodeBase.resetData2PSDEFName();
        pSDETreeNodeBase.resetDataPSDEFId();
        pSDETreeNodeBase.resetDataPSDEFName();
        pSDETreeNodeBase.resetDataSource();
        pSDETreeNodeBase.resetDataTypePSDEFId();
        pSDETreeNodeBase.resetDataTypePSDEFName();
        pSDETreeNodeBase.resetDisableSelect();
        pSDETreeNodeBase.resetDistinctMode();
        pSDETreeNodeBase.resetDynaClass();
        pSDETreeNodeBase.resetEditDataMode();
        pSDETreeNodeBase.resetEditMode();
        pSDETreeNodeBase.resetEnableCheck();
        pSDETreeNodeBase.resetEnablePaging();
        pSDETreeNodeBase.resetEnableQuickSearch();
        pSDETreeNodeBase.resetEnableUP();
        pSDETreeNodeBase.resetEnableViewActions();
        pSDETreeNodeBase.resetExpand();
        pSDETreeNodeBase.resetFieldName();
        pSDETreeNodeBase.resetFilterPSDEDSId();
        pSDETreeNodeBase.resetFilterPSDEDSName();
        pSDETreeNodeBase.resetIconPSDEFId();
        pSDETreeNodeBase.resetIconPSDEFName();
        pSDETreeNodeBase.resetKeyPSDEFId();
        pSDETreeNodeBase.resetKeyPSDEFName();
        pSDETreeNodeBase.resetLeafFlagPSDEFId();
        pSDETreeNodeBase.resetLeafFlagPSDEFName();
        pSDETreeNodeBase.resetLinkPSDEFId();
        pSDETreeNodeBase.resetLinkPSDEFName();
        pSDETreeNodeBase.resetMaxSize();
        pSDETreeNodeBase.resetMemo();
        pSDETreeNodeBase.resetModelObj();
        pSDETreeNodeBase.resetMovePSDEActionId();
        pSDETreeNodeBase.resetMovePSDEActionName();
        pSDETreeNodeBase.resetMovePSDEOPPrivId();
        pSDETreeNodeBase.resetMovePSDEOPPrivName();
        pSDETreeNodeBase.resetNamePSLanResId();
        pSDETreeNodeBase.resetNamePSLanResName();
        pSDETreeNodeBase.resetNavViewFilter();
        pSDETreeNodeBase.resetNavViewFilterDesc();
        pSDETreeNodeBase.resetNavViewParam();
        pSDETreeNodeBase.resetNewDataMode();
        pSDETreeNodeBase.resetNo2PSDEUAGroupId();
        pSDETreeNodeBase.resetNo2PSDEUAGroupName();
        pSDETreeNodeBase.resetNodeAction();
        pSDETreeNodeBase.resetNodeDataType();
        pSDETreeNodeBase.resetNodeId2PSDEFId();
        pSDETreeNodeBase.resetNodeId2PSDEFName();
        pSDETreeNodeBase.resetNodeId3PSDEFId();
        pSDETreeNodeBase.resetNodeId3PSDEFName();
        pSDETreeNodeBase.resetNodeId4PSDEFId();
        pSDETreeNodeBase.resetNodeId4PSDEFName();
        pSDETreeNodeBase.resetNodeIdPSDEFId();
        pSDETreeNodeBase.resetNodeIdPSDEFName();
        pSDETreeNodeBase.resetNodeType();
        pSDETreeNodeBase.resetNodeValue();
        pSDETreeNodeBase.resetPageSize();
        pSDETreeNodeBase.resetPreventXSS();
        pSDETreeNodeBase.resetPSCodeListId();
        pSDETreeNodeBase.resetPSCodeListName();
        pSDETreeNodeBase.resetPSDEActionId();
        pSDETreeNodeBase.resetPSDEActionName();
        pSDETreeNodeBase.resetPSDEDSId();
        pSDETreeNodeBase.resetPSDEDSName();
        pSDETreeNodeBase.resetPSDEGridId();
        pSDETreeNodeBase.resetPSDEGridName();
        pSDETreeNodeBase.resetPSDEId();
        pSDETreeNodeBase.resetPSDELogicId();
        pSDETreeNodeBase.resetPSDELogicName();
        pSDETreeNodeBase.resetPSDEName();
        pSDETreeNodeBase.resetPSDERId();
        pSDETreeNodeBase.resetPSDERName();
        pSDETreeNodeBase.resetPSDEToolbarId();
        pSDETreeNodeBase.resetPSDEToolbarName();
        pSDETreeNodeBase.resetPSDETreeNodeId();
        pSDETreeNodeBase.resetPSDETreeNodeName();
        pSDETreeNodeBase.resetPSDETreeViewId();
        pSDETreeNodeBase.resetPSDETreeViewName();
        pSDETreeNodeBase.resetPSDEUAGroupId();
        pSDETreeNodeBase.resetPSDEUAGroupName();
        pSDETreeNodeBase.resetPSDEViewBaseId();
        pSDETreeNodeBase.resetPSDEViewBaseName();
        pSDETreeNodeBase.resetPSSysCssId();
        pSDETreeNodeBase.resetPSSysCssName();
        pSDETreeNodeBase.resetPSSysImageId();
        pSDETreeNodeBase.resetPSSysImageName();
        pSDETreeNodeBase.resetPSSysPFPluginId();
        pSDETreeNodeBase.resetPSSysPFPluginName();
        pSDETreeNodeBase.resetPSSystemId();
        pSDETreeNodeBase.resetPSSysUniResId();
        pSDETreeNodeBase.resetPSSysUniResName();
        pSDETreeNodeBase.resetPSSysViewPanelId();
        pSDETreeNodeBase.resetPSSysViewPanelName();
        pSDETreeNodeBase.resetRemovePSDEActionId();
        pSDETreeNodeBase.resetRemovePSDEActionName();
        pSDETreeNodeBase.resetRemovePSDEOPPrivId();
        pSDETreeNodeBase.resetRemovePSDEOPPrivName();
        pSDETreeNodeBase.resetRootNode();
        pSDETreeNodeBase.resetSelected();
        pSDETreeNodeBase.resetShapeClsPSDEFId();
        pSDETreeNodeBase.resetShapeClsPSDEFName();
        pSDETreeNodeBase.resetShapeDynaClass();
        pSDETreeNodeBase.resetShapePSSysCssId();
        pSDETreeNodeBase.resetShapePSSysCssName();
        pSDETreeNodeBase.resetSortDir();
        pSDETreeNodeBase.resetSortPSDEFId();
        pSDETreeNodeBase.resetSortPSDEFName();
        pSDETreeNodeBase.resetTextPSDEFId();
        pSDETreeNodeBase.resetTextPSDEFName();
        pSDETreeNodeBase.resetTipPSLanResId();
        pSDETreeNodeBase.resetTipPSLanResName();
        pSDETreeNodeBase.resetTipsPSDEFId();
        pSDETreeNodeBase.resetTipsPSDEFName();
        pSDETreeNodeBase.resetTooltipInfo();
        pSDETreeNodeBase.resetTreeNodeType();
        pSDETreeNodeBase.resetUpdateDate();
        pSDETreeNodeBase.resetUpdateMan();
        pSDETreeNodeBase.resetUpdatePSDEActionId();
        pSDETreeNodeBase.resetUpdatePSDEActionName();
        pSDETreeNodeBase.resetUpdatePSDEOPPrivId();
        pSDETreeNodeBase.resetUpdatePSDEOPPrivName();
        pSDETreeNodeBase.resetUserCat();
        pSDETreeNodeBase.resetUserTag();
        pSDETreeNodeBase.resetUserTag2();
        pSDETreeNodeBase.resetUserTag3();
        pSDETreeNodeBase.resetUserTag4();
        pSDETreeNodeBase.resetViewActions();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isActionParamDirty()) {
            hashMap.put(FIELD_ACTIONPARAM, this.getActionParam());
        }
        if (!bl || this.isAppendCapFlagDirty()) {
            hashMap.put(FIELD_APPENDCAPFLAG, this.getAppendCapFlag());
        }
        if (!bl || this.isAppendPNodeIdDirty()) {
            hashMap.put(FIELD_APPENDPNODEID, this.getAppendPNodeId());
        }
        if (!bl || this.isCaptionDirty()) {
            hashMap.put(FIELD_CAPTION, this.getCaption());
        }
        if (!bl || this.isCheckedDirty()) {
            hashMap.put(FIELD_CHECKED, this.getChecked());
        }
        if (!bl || this.isChildCntPSDEFIdDirty()) {
            hashMap.put(FIELD_CHILDCNTPSDEFID, this.getChildCntPSDEFId());
        }
        if (!bl || this.isChildCntPSDEFNameDirty()) {
            hashMap.put(FIELD_CHILDCNTPSDEFNAME, this.getChildCntPSDEFName());
        }
        if (!bl || this.isClsPSDEFIdDirty()) {
            hashMap.put(FIELD_CLSPSDEFID, this.getClsPSDEFId());
        }
        if (!bl || this.isClsPSDEFNameDirty()) {
            hashMap.put(FIELD_CLSPSDEFNAME, this.getClsPSDEFName());
        }
        if (!bl || this.isCMRefreshDirty()) {
            hashMap.put(FIELD_CMREFRESH, this.getCMRefresh());
        }
        if (!bl || this.isCMRemoveDirty()) {
            hashMap.put(FIELD_CMREMOVE, this.getCMRemove());
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
        if (!bl || this.isCustomCodeDirty()) {
            hashMap.put(FIELD_CUSTOMCODE, this.getCustomCode());
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
        if (!bl || this.isDataSourceDirty()) {
            hashMap.put(FIELD_DATASOURCE, this.getDataSource());
        }
        if (!bl || this.isDataTypePSDEFIdDirty()) {
            hashMap.put(FIELD_DATATYPEPSDEFID, this.getDataTypePSDEFId());
        }
        if (!bl || this.isDataTypePSDEFNameDirty()) {
            hashMap.put(FIELD_DATATYPEPSDEFNAME, this.getDataTypePSDEFName());
        }
        if (!bl || this.isDisableSelectDirty()) {
            hashMap.put(FIELD_DISABLESELECT, this.getDisableSelect());
        }
        if (!bl || this.isDistinctModeDirty()) {
            hashMap.put(FIELD_DISTINCTMODE, this.getDistinctMode());
        }
        if (!bl || this.isDynaClassDirty()) {
            hashMap.put(FIELD_DYNACLASS, this.getDynaClass());
        }
        if (!bl || this.isEditDataModeDirty()) {
            hashMap.put(FIELD_EDITDATAMODE, this.getEditDataMode());
        }
        if (!bl || this.isEditModeDirty()) {
            hashMap.put(FIELD_EDITMODE, this.getEditMode());
        }
        if (!bl || this.isEnableCheckDirty()) {
            hashMap.put(FIELD_ENABLECHECK, this.getEnableCheck());
        }
        if (!bl || this.isEnablePagingDirty()) {
            hashMap.put(FIELD_ENABLEPAGING, this.getEnablePaging());
        }
        if (!bl || this.isEnableQuickSearchDirty()) {
            hashMap.put(FIELD_ENABLEQUICKSEARCH, this.getEnableQuickSearch());
        }
        if (!bl || this.isEnableUPDirty()) {
            hashMap.put(FIELD_ENABLEUP, this.getEnableUP());
        }
        if (!bl || this.isEnableViewActionsDirty()) {
            hashMap.put(FIELD_ENABLEVIEWACTIONS, this.getEnableViewActions());
        }
        if (!bl || this.isExpandDirty()) {
            hashMap.put(FIELD_EXPAND, this.getExpand());
        }
        if (!bl || this.isFieldNameDirty()) {
            hashMap.put(FIELD_FIELDNAME, this.getFieldName());
        }
        if (!bl || this.isFilterPSDEDSIdDirty()) {
            hashMap.put(FIELD_FILTERPSDEDSID, this.getFilterPSDEDSId());
        }
        if (!bl || this.isFilterPSDEDSNameDirty()) {
            hashMap.put(FIELD_FILTERPSDEDSNAME, this.getFilterPSDEDSName());
        }
        if (!bl || this.isIconPSDEFIdDirty()) {
            hashMap.put(FIELD_ICONPSDEFID, this.getIconPSDEFId());
        }
        if (!bl || this.isIconPSDEFNameDirty()) {
            hashMap.put(FIELD_ICONPSDEFNAME, this.getIconPSDEFName());
        }
        if (!bl || this.isKeyPSDEFIdDirty()) {
            hashMap.put(FIELD_KEYPSDEFID, this.getKeyPSDEFId());
        }
        if (!bl || this.isKeyPSDEFNameDirty()) {
            hashMap.put(FIELD_KEYPSDEFNAME, this.getKeyPSDEFName());
        }
        if (!bl || this.isLeafFlagPSDEFIdDirty()) {
            hashMap.put(FIELD_LEAFFLAGPSDEFID, this.getLeafFlagPSDEFId());
        }
        if (!bl || this.isLeafFlagPSDEFNameDirty()) {
            hashMap.put(FIELD_LEAFFLAGPSDEFNAME, this.getLeafFlagPSDEFName());
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
        if (!bl || this.isNavViewFilterDescDirty()) {
            hashMap.put(FIELD_NAVVIEWFILTERDESC, this.getNavViewFilterDesc());
        }
        if (!bl || this.isNavViewParamDirty()) {
            hashMap.put(FIELD_NAVVIEWPARAM, this.getNavViewParam());
        }
        if (!bl || this.isNewDataModeDirty()) {
            hashMap.put(FIELD_NEWDATAMODE, this.getNewDataMode());
        }
        if (!bl || this.isNo2PSDEUAGroupIdDirty()) {
            hashMap.put(FIELD_NO2PSDEUAGROUPID, this.getNo2PSDEUAGroupId());
        }
        if (!bl || this.isNo2PSDEUAGroupNameDirty()) {
            hashMap.put(FIELD_NO2PSDEUAGROUPNAME, this.getNo2PSDEUAGroupName());
        }
        if (!bl || this.isNodeActionDirty()) {
            hashMap.put(FIELD_NODEACTION, this.getNodeAction());
        }
        if (!bl || this.isNodeDataTypeDirty()) {
            hashMap.put(FIELD_NODEDATATYPE, this.getNodeDataType());
        }
        if (!bl || this.isNodeId2PSDEFIdDirty()) {
            hashMap.put(FIELD_NODEID2PSDEFID, this.getNodeId2PSDEFId());
        }
        if (!bl || this.isNodeId2PSDEFNameDirty()) {
            hashMap.put(FIELD_NODEID2PSDEFNAME, this.getNodeId2PSDEFName());
        }
        if (!bl || this.isNodeId3PSDEFIdDirty()) {
            hashMap.put(FIELD_NODEID3PSDEFID, this.getNodeId3PSDEFId());
        }
        if (!bl || this.isNodeId3PSDEFNameDirty()) {
            hashMap.put(FIELD_NODEID3PSDEFNAME, this.getNodeId3PSDEFName());
        }
        if (!bl || this.isNodeId4PSDEFIdDirty()) {
            hashMap.put(FIELD_NODEID4PSDEFID, this.getNodeId4PSDEFId());
        }
        if (!bl || this.isNodeId4PSDEFNameDirty()) {
            hashMap.put(FIELD_NODEID4PSDEFNAME, this.getNodeId4PSDEFName());
        }
        if (!bl || this.isNodeIdPSDEFIdDirty()) {
            hashMap.put(FIELD_NODEIDPSDEFID, this.getNodeIdPSDEFId());
        }
        if (!bl || this.isNodeIdPSDEFNameDirty()) {
            hashMap.put(FIELD_NODEIDPSDEFNAME, this.getNodeIdPSDEFName());
        }
        if (!bl || this.isNodeTypeDirty()) {
            hashMap.put(FIELD_NODETYPE, this.getNodeType());
        }
        if (!bl || this.isNodeValueDirty()) {
            hashMap.put(FIELD_NODEVALUE, this.getNodeValue());
        }
        if (!bl || this.isPageSizeDirty()) {
            hashMap.put(FIELD_PAGESIZE, this.getPageSize());
        }
        if (!bl || this.isPreventXSSDirty()) {
            hashMap.put(FIELD_PREVENTXSS, this.getPreventXSS());
        }
        if (!bl || this.isPSCodeListIdDirty()) {
            hashMap.put(FIELD_PSCODELISTID, this.getPSCodeListId());
        }
        if (!bl || this.isPSCodeListNameDirty()) {
            hashMap.put(FIELD_PSCODELISTNAME, this.getPSCodeListName());
        }
        if (!bl || this.isPSDEActionIdDirty()) {
            hashMap.put(FIELD_PSDEACTIONID, this.getPSDEActionId());
        }
        if (!bl || this.isPSDEActionNameDirty()) {
            hashMap.put(FIELD_PSDEACTIONNAME, this.getPSDEActionName());
        }
        if (!bl || this.isPSDEDSIdDirty()) {
            hashMap.put(FIELD_PSDEDSID, this.getPSDEDSId());
        }
        if (!bl || this.isPSDEDSNameDirty()) {
            hashMap.put(FIELD_PSDEDSNAME, this.getPSDEDSName());
        }
        if (!bl || this.isPSDEGridIdDirty()) {
            hashMap.put(FIELD_PSDEGRIDID, this.getPSDEGridId());
        }
        if (!bl || this.isPSDEGridNameDirty()) {
            hashMap.put(FIELD_PSDEGRIDNAME, this.getPSDEGridName());
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
        if (!bl || this.isPSDETreeNodeIdDirty()) {
            hashMap.put(FIELD_PSDETREENODEID, this.getPSDETreeNodeId());
        }
        if (!bl || this.isPSDETreeNodeNameDirty()) {
            hashMap.put(FIELD_PSDETREENODENAME, this.getPSDETreeNodeName());
        }
        if (!bl || this.isPSDETreeViewIdDirty()) {
            hashMap.put(FIELD_PSDETREEVIEWID, this.getPSDETreeViewId());
        }
        if (!bl || this.isPSDETreeViewNameDirty()) {
            hashMap.put(FIELD_PSDETREEVIEWNAME, this.getPSDETreeViewName());
        }
        if (!bl || this.isPSDEUAGroupIdDirty()) {
            hashMap.put(FIELD_PSDEUAGROUPID, this.getPSDEUAGroupId());
        }
        if (!bl || this.isPSDEUAGroupNameDirty()) {
            hashMap.put(FIELD_PSDEUAGROUPNAME, this.getPSDEUAGroupName());
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
        if (!bl || this.isPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINID, this.getPSSysPFPluginId());
        }
        if (!bl || this.isPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINNAME, this.getPSSysPFPluginName());
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
        if (!bl || this.isRootNodeDirty()) {
            hashMap.put(FIELD_ROOTNODE, this.getRootNode());
        }
        if (!bl || this.isSelectedDirty()) {
            hashMap.put(FIELD_SELECTED, this.getSelected());
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
        if (!bl || this.isSortDirDirty()) {
            hashMap.put(FIELD_SORTDIR, this.getSortDir());
        }
        if (!bl || this.isSortPSDEFIdDirty()) {
            hashMap.put(FIELD_SORTPSDEFID, this.getSortPSDEFId());
        }
        if (!bl || this.isSortPSDEFNameDirty()) {
            hashMap.put(FIELD_SORTPSDEFNAME, this.getSortPSDEFName());
        }
        if (!bl || this.isTextPSDEFIdDirty()) {
            hashMap.put(FIELD_TEXTPSDEFID, this.getTextPSDEFId());
        }
        if (!bl || this.isTextPSDEFNameDirty()) {
            hashMap.put(FIELD_TEXTPSDEFNAME, this.getTextPSDEFName());
        }
        if (!bl || this.isTipPSLanResIdDirty()) {
            hashMap.put(FIELD_TIPPSLANRESID, this.getTipPSLanResId());
        }
        if (!bl || this.isTipPSLanResNameDirty()) {
            hashMap.put(FIELD_TIPPSLANRESNAME, this.getTipPSLanResName());
        }
        if (!bl || this.isTipsPSDEFIdDirty()) {
            hashMap.put(FIELD_TIPSPSDEFID, this.getTipsPSDEFId());
        }
        if (!bl || this.isTipsPSDEFNameDirty()) {
            hashMap.put(FIELD_TIPSPSDEFNAME, this.getTipsPSDEFName());
        }
        if (!bl || this.isTooltipInfoDirty()) {
            hashMap.put(FIELD_TOOLTIPINFO, this.getTooltipInfo());
        }
        if (!bl || this.isTreeNodeTypeDirty()) {
            hashMap.put(FIELD_TREENODETYPE, this.getTreeNodeType());
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
        return PSDETreeNodeBase.get(this, n);
    }

    private static Object get(PSDETreeNodeBase pSDETreeNodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDETreeNodeBase.getActionParam();
            }
            case 1: {
                return pSDETreeNodeBase.getAppendCapFlag();
            }
            case 2: {
                return pSDETreeNodeBase.getAppendPNodeId();
            }
            case 3: {
                return pSDETreeNodeBase.getCaption();
            }
            case 4: {
                return pSDETreeNodeBase.getChecked();
            }
            case 5: {
                return pSDETreeNodeBase.getChildCntPSDEFId();
            }
            case 6: {
                return pSDETreeNodeBase.getChildCntPSDEFName();
            }
            case 7: {
                return pSDETreeNodeBase.getClsPSDEFId();
            }
            case 8: {
                return pSDETreeNodeBase.getClsPSDEFName();
            }
            case 9: {
                return pSDETreeNodeBase.getCMRefresh();
            }
            case 10: {
                return pSDETreeNodeBase.getCMRemove();
            }
            case 11: {
                return pSDETreeNodeBase.getCounterId();
            }
            case 12: {
                return pSDETreeNodeBase.getCounterMode();
            }
            case 13: {
                return pSDETreeNodeBase.getCreateDate();
            }
            case 14: {
                return pSDETreeNodeBase.getCreateMan();
            }
            case 15: {
                return pSDETreeNodeBase.getCustomCode();
            }
            case 16: {
                return pSDETreeNodeBase.getCustomCond();
            }
            case 17: {
                return pSDETreeNodeBase.getCustomType();
            }
            case 18: {
                return pSDETreeNodeBase.getData2PSDEFId();
            }
            case 19: {
                return pSDETreeNodeBase.getData2PSDEFName();
            }
            case 20: {
                return pSDETreeNodeBase.getDataPSDEFId();
            }
            case 21: {
                return pSDETreeNodeBase.getDataPSDEFName();
            }
            case 22: {
                return pSDETreeNodeBase.getDataSource();
            }
            case 23: {
                return pSDETreeNodeBase.getDataTypePSDEFId();
            }
            case 24: {
                return pSDETreeNodeBase.getDataTypePSDEFName();
            }
            case 25: {
                return pSDETreeNodeBase.getDisableSelect();
            }
            case 26: {
                return pSDETreeNodeBase.getDistinctMode();
            }
            case 27: {
                return pSDETreeNodeBase.getDynaClass();
            }
            case 28: {
                return pSDETreeNodeBase.getEditDataMode();
            }
            case 29: {
                return pSDETreeNodeBase.getEditMode();
            }
            case 30: {
                return pSDETreeNodeBase.getEnableCheck();
            }
            case 31: {
                return pSDETreeNodeBase.getEnablePaging();
            }
            case 32: {
                return pSDETreeNodeBase.getEnableQuickSearch();
            }
            case 33: {
                return pSDETreeNodeBase.getEnableUP();
            }
            case 34: {
                return pSDETreeNodeBase.getEnableViewActions();
            }
            case 35: {
                return pSDETreeNodeBase.getExpand();
            }
            case 36: {
                return pSDETreeNodeBase.getFieldName();
            }
            case 37: {
                return pSDETreeNodeBase.getFilterPSDEDSId();
            }
            case 38: {
                return pSDETreeNodeBase.getFilterPSDEDSName();
            }
            case 39: {
                return pSDETreeNodeBase.getIconPSDEFId();
            }
            case 40: {
                return pSDETreeNodeBase.getIconPSDEFName();
            }
            case 41: {
                return pSDETreeNodeBase.getKeyPSDEFId();
            }
            case 42: {
                return pSDETreeNodeBase.getKeyPSDEFName();
            }
            case 43: {
                return pSDETreeNodeBase.getLeafFlagPSDEFId();
            }
            case 44: {
                return pSDETreeNodeBase.getLeafFlagPSDEFName();
            }
            case 45: {
                return pSDETreeNodeBase.getLinkPSDEFId();
            }
            case 46: {
                return pSDETreeNodeBase.getLinkPSDEFName();
            }
            case 47: {
                return pSDETreeNodeBase.getMaxSize();
            }
            case 48: {
                return pSDETreeNodeBase.getMemo();
            }
            case 49: {
                return pSDETreeNodeBase.getModelObj();
            }
            case 50: {
                return pSDETreeNodeBase.getMovePSDEActionId();
            }
            case 51: {
                return pSDETreeNodeBase.getMovePSDEActionName();
            }
            case 52: {
                return pSDETreeNodeBase.getMovePSDEOPPrivId();
            }
            case 53: {
                return pSDETreeNodeBase.getMovePSDEOPPrivName();
            }
            case 54: {
                return pSDETreeNodeBase.getNamePSLanResId();
            }
            case 55: {
                return pSDETreeNodeBase.getNamePSLanResName();
            }
            case 56: {
                return pSDETreeNodeBase.getNavViewFilter();
            }
            case 57: {
                return pSDETreeNodeBase.getNavViewFilterDesc();
            }
            case 58: {
                return pSDETreeNodeBase.getNavViewParam();
            }
            case 59: {
                return pSDETreeNodeBase.getNewDataMode();
            }
            case 60: {
                return pSDETreeNodeBase.getNo2PSDEUAGroupId();
            }
            case 61: {
                return pSDETreeNodeBase.getNo2PSDEUAGroupName();
            }
            case 62: {
                return pSDETreeNodeBase.getNodeAction();
            }
            case 63: {
                return pSDETreeNodeBase.getNodeDataType();
            }
            case 64: {
                return pSDETreeNodeBase.getNodeId2PSDEFId();
            }
            case 65: {
                return pSDETreeNodeBase.getNodeId2PSDEFName();
            }
            case 66: {
                return pSDETreeNodeBase.getNodeId3PSDEFId();
            }
            case 67: {
                return pSDETreeNodeBase.getNodeId3PSDEFName();
            }
            case 68: {
                return pSDETreeNodeBase.getNodeId4PSDEFId();
            }
            case 69: {
                return pSDETreeNodeBase.getNodeId4PSDEFName();
            }
            case 70: {
                return pSDETreeNodeBase.getNodeIdPSDEFId();
            }
            case 71: {
                return pSDETreeNodeBase.getNodeIdPSDEFName();
            }
            case 72: {
                return pSDETreeNodeBase.getNodeType();
            }
            case 73: {
                return pSDETreeNodeBase.getNodeValue();
            }
            case 74: {
                return pSDETreeNodeBase.getPageSize();
            }
            case 75: {
                return pSDETreeNodeBase.getPreventXSS();
            }
            case 76: {
                return pSDETreeNodeBase.getPSCodeListId();
            }
            case 77: {
                return pSDETreeNodeBase.getPSCodeListName();
            }
            case 78: {
                return pSDETreeNodeBase.getPSDEActionId();
            }
            case 79: {
                return pSDETreeNodeBase.getPSDEActionName();
            }
            case 80: {
                return pSDETreeNodeBase.getPSDEDSId();
            }
            case 81: {
                return pSDETreeNodeBase.getPSDEDSName();
            }
            case 82: {
                return pSDETreeNodeBase.getPSDEGridId();
            }
            case 83: {
                return pSDETreeNodeBase.getPSDEGridName();
            }
            case 84: {
                return pSDETreeNodeBase.getPSDEId();
            }
            case 85: {
                return pSDETreeNodeBase.getPSDELogicId();
            }
            case 86: {
                return pSDETreeNodeBase.getPSDELogicName();
            }
            case 87: {
                return pSDETreeNodeBase.getPSDEName();
            }
            case 88: {
                return pSDETreeNodeBase.getPSDERId();
            }
            case 89: {
                return pSDETreeNodeBase.getPSDERName();
            }
            case 90: {
                return pSDETreeNodeBase.getPSDEToolbarId();
            }
            case 91: {
                return pSDETreeNodeBase.getPSDEToolbarName();
            }
            case 92: {
                return pSDETreeNodeBase.getPSDETreeNodeId();
            }
            case 93: {
                return pSDETreeNodeBase.getPSDETreeNodeName();
            }
            case 94: {
                return pSDETreeNodeBase.getPSDETreeViewId();
            }
            case 95: {
                return pSDETreeNodeBase.getPSDETreeViewName();
            }
            case 96: {
                return pSDETreeNodeBase.getPSDEUAGroupId();
            }
            case 97: {
                return pSDETreeNodeBase.getPSDEUAGroupName();
            }
            case 98: {
                return pSDETreeNodeBase.getPSDEViewBaseId();
            }
            case 99: {
                return pSDETreeNodeBase.getPSDEViewBaseName();
            }
            case 100: {
                return pSDETreeNodeBase.getPSSysCssId();
            }
            case 101: {
                return pSDETreeNodeBase.getPSSysCssName();
            }
            case 102: {
                return pSDETreeNodeBase.getPSSysImageId();
            }
            case 103: {
                return pSDETreeNodeBase.getPSSysImageName();
            }
            case 104: {
                return pSDETreeNodeBase.getPSSysPFPluginId();
            }
            case 105: {
                return pSDETreeNodeBase.getPSSysPFPluginName();
            }
            case 106: {
                return pSDETreeNodeBase.getPSSystemId();
            }
            case 107: {
                return pSDETreeNodeBase.getPSSysUniResId();
            }
            case 108: {
                return pSDETreeNodeBase.getPSSysUniResName();
            }
            case 109: {
                return pSDETreeNodeBase.getPSSysViewPanelId();
            }
            case 110: {
                return pSDETreeNodeBase.getPSSysViewPanelName();
            }
            case 111: {
                return pSDETreeNodeBase.getRemovePSDEActionId();
            }
            case 112: {
                return pSDETreeNodeBase.getRemovePSDEActionName();
            }
            case 113: {
                return pSDETreeNodeBase.getRemovePSDEOPPrivId();
            }
            case 114: {
                return pSDETreeNodeBase.getRemovePSDEOPPrivName();
            }
            case 115: {
                return pSDETreeNodeBase.getRootNode();
            }
            case 116: {
                return pSDETreeNodeBase.getSelected();
            }
            case 117: {
                return pSDETreeNodeBase.getShapeClsPSDEFId();
            }
            case 118: {
                return pSDETreeNodeBase.getShapeClsPSDEFName();
            }
            case 119: {
                return pSDETreeNodeBase.getShapeDynaClass();
            }
            case 120: {
                return pSDETreeNodeBase.getShapePSSysCssId();
            }
            case 121: {
                return pSDETreeNodeBase.getShapePSSysCssName();
            }
            case 122: {
                return pSDETreeNodeBase.getSortDir();
            }
            case 123: {
                return pSDETreeNodeBase.getSortPSDEFId();
            }
            case 124: {
                return pSDETreeNodeBase.getSortPSDEFName();
            }
            case 125: {
                return pSDETreeNodeBase.getTextPSDEFId();
            }
            case 126: {
                return pSDETreeNodeBase.getTextPSDEFName();
            }
            case 127: {
                return pSDETreeNodeBase.getTipPSLanResId();
            }
            case 128: {
                return pSDETreeNodeBase.getTipPSLanResName();
            }
            case 129: {
                return pSDETreeNodeBase.getTipsPSDEFId();
            }
            case 130: {
                return pSDETreeNodeBase.getTipsPSDEFName();
            }
            case 131: {
                return pSDETreeNodeBase.getTooltipInfo();
            }
            case 132: {
                return pSDETreeNodeBase.getTreeNodeType();
            }
            case 133: {
                return pSDETreeNodeBase.getUpdateDate();
            }
            case 134: {
                return pSDETreeNodeBase.getUpdateMan();
            }
            case 135: {
                return pSDETreeNodeBase.getUpdatePSDEActionId();
            }
            case 136: {
                return pSDETreeNodeBase.getUpdatePSDEActionName();
            }
            case 137: {
                return pSDETreeNodeBase.getUpdatePSDEOPPrivId();
            }
            case 138: {
                return pSDETreeNodeBase.getUpdatePSDEOPPrivName();
            }
            case 139: {
                return pSDETreeNodeBase.getUserCat();
            }
            case 140: {
                return pSDETreeNodeBase.getUserTag();
            }
            case 141: {
                return pSDETreeNodeBase.getUserTag2();
            }
            case 142: {
                return pSDETreeNodeBase.getUserTag3();
            }
            case 143: {
                return pSDETreeNodeBase.getUserTag4();
            }
            case 144: {
                return pSDETreeNodeBase.getViewActions();
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
        PSDETreeNodeBase.set(this, n, object);
    }

    private static void set(PSDETreeNodeBase pSDETreeNodeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDETreeNodeBase.setActionParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDETreeNodeBase.setAppendCapFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSDETreeNodeBase.setAppendPNodeId(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSDETreeNodeBase.setCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDETreeNodeBase.setChecked(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDETreeNodeBase.setChildCntPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDETreeNodeBase.setChildCntPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDETreeNodeBase.setClsPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDETreeNodeBase.setClsPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDETreeNodeBase.setCMRefresh(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSDETreeNodeBase.setCMRemove(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSDETreeNodeBase.setCounterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDETreeNodeBase.setCounterMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDETreeNodeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSDETreeNodeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDETreeNodeBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDETreeNodeBase.setCustomCond(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDETreeNodeBase.setCustomType(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDETreeNodeBase.setData2PSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDETreeNodeBase.setData2PSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDETreeNodeBase.setDataPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDETreeNodeBase.setDataPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDETreeNodeBase.setDataSource(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDETreeNodeBase.setDataTypePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDETreeNodeBase.setDataTypePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDETreeNodeBase.setDisableSelect(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 26: {
                pSDETreeNodeBase.setDistinctMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSDETreeNodeBase.setDynaClass(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDETreeNodeBase.setEditDataMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDETreeNodeBase.setEditMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 30: {
                pSDETreeNodeBase.setEnableCheck(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSDETreeNodeBase.setEnablePaging(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 32: {
                pSDETreeNodeBase.setEnableQuickSearch(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 33: {
                pSDETreeNodeBase.setEnableUP(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 34: {
                pSDETreeNodeBase.setEnableViewActions(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 35: {
                pSDETreeNodeBase.setExpand(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 36: {
                pSDETreeNodeBase.setFieldName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDETreeNodeBase.setFilterPSDEDSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDETreeNodeBase.setFilterPSDEDSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDETreeNodeBase.setIconPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDETreeNodeBase.setIconPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDETreeNodeBase.setKeyPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDETreeNodeBase.setKeyPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDETreeNodeBase.setLeafFlagPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDETreeNodeBase.setLeafFlagPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDETreeNodeBase.setLinkPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDETreeNodeBase.setLinkPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDETreeNodeBase.setMaxSize(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 48: {
                pSDETreeNodeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDETreeNodeBase.setModelObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDETreeNodeBase.setMovePSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSDETreeNodeBase.setMovePSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSDETreeNodeBase.setMovePSDEOPPrivId(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSDETreeNodeBase.setMovePSDEOPPrivName(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSDETreeNodeBase.setNamePSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSDETreeNodeBase.setNamePSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSDETreeNodeBase.setNavViewFilter(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSDETreeNodeBase.setNavViewFilterDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSDETreeNodeBase.setNavViewParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSDETreeNodeBase.setNewDataMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSDETreeNodeBase.setNo2PSDEUAGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSDETreeNodeBase.setNo2PSDEUAGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSDETreeNodeBase.setNodeAction(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSDETreeNodeBase.setNodeDataType(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSDETreeNodeBase.setNodeId2PSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSDETreeNodeBase.setNodeId2PSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSDETreeNodeBase.setNodeId3PSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSDETreeNodeBase.setNodeId3PSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSDETreeNodeBase.setNodeId4PSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSDETreeNodeBase.setNodeId4PSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 70: {
                pSDETreeNodeBase.setNodeIdPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 71: {
                pSDETreeNodeBase.setNodeIdPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 72: {
                pSDETreeNodeBase.setNodeType(DataObject.getStringValue((Object)object));
                return;
            }
            case 73: {
                pSDETreeNodeBase.setNodeValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 74: {
                pSDETreeNodeBase.setPageSize(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 75: {
                pSDETreeNodeBase.setPreventXSS(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 76: {
                pSDETreeNodeBase.setPSCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 77: {
                pSDETreeNodeBase.setPSCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 78: {
                pSDETreeNodeBase.setPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 79: {
                pSDETreeNodeBase.setPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 80: {
                pSDETreeNodeBase.setPSDEDSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 81: {
                pSDETreeNodeBase.setPSDEDSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 82: {
                pSDETreeNodeBase.setPSDEGridId(DataObject.getStringValue((Object)object));
                return;
            }
            case 83: {
                pSDETreeNodeBase.setPSDEGridName(DataObject.getStringValue((Object)object));
                return;
            }
            case 84: {
                pSDETreeNodeBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 85: {
                pSDETreeNodeBase.setPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 86: {
                pSDETreeNodeBase.setPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 87: {
                pSDETreeNodeBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 88: {
                pSDETreeNodeBase.setPSDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 89: {
                pSDETreeNodeBase.setPSDERName(DataObject.getStringValue((Object)object));
                return;
            }
            case 90: {
                pSDETreeNodeBase.setPSDEToolbarId(DataObject.getStringValue((Object)object));
                return;
            }
            case 91: {
                pSDETreeNodeBase.setPSDEToolbarName(DataObject.getStringValue((Object)object));
                return;
            }
            case 92: {
                pSDETreeNodeBase.setPSDETreeNodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 93: {
                pSDETreeNodeBase.setPSDETreeNodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 94: {
                pSDETreeNodeBase.setPSDETreeViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 95: {
                pSDETreeNodeBase.setPSDETreeViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 96: {
                pSDETreeNodeBase.setPSDEUAGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 97: {
                pSDETreeNodeBase.setPSDEUAGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 98: {
                pSDETreeNodeBase.setPSDEViewBaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 99: {
                pSDETreeNodeBase.setPSDEViewBaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 100: {
                pSDETreeNodeBase.setPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 101: {
                pSDETreeNodeBase.setPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 102: {
                pSDETreeNodeBase.setPSSysImageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 103: {
                pSDETreeNodeBase.setPSSysImageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 104: {
                pSDETreeNodeBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 105: {
                pSDETreeNodeBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 106: {
                pSDETreeNodeBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 107: {
                pSDETreeNodeBase.setPSSysUniResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 108: {
                pSDETreeNodeBase.setPSSysUniResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 109: {
                pSDETreeNodeBase.setPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 110: {
                pSDETreeNodeBase.setPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 111: {
                pSDETreeNodeBase.setRemovePSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 112: {
                pSDETreeNodeBase.setRemovePSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 113: {
                pSDETreeNodeBase.setRemovePSDEOPPrivId(DataObject.getStringValue((Object)object));
                return;
            }
            case 114: {
                pSDETreeNodeBase.setRemovePSDEOPPrivName(DataObject.getStringValue((Object)object));
                return;
            }
            case 115: {
                pSDETreeNodeBase.setRootNode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 116: {
                pSDETreeNodeBase.setSelected(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 117: {
                pSDETreeNodeBase.setShapeClsPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 118: {
                pSDETreeNodeBase.setShapeClsPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 119: {
                pSDETreeNodeBase.setShapeDynaClass(DataObject.getStringValue((Object)object));
                return;
            }
            case 120: {
                pSDETreeNodeBase.setShapePSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 121: {
                pSDETreeNodeBase.setShapePSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 122: {
                pSDETreeNodeBase.setSortDir(DataObject.getStringValue((Object)object));
                return;
            }
            case 123: {
                pSDETreeNodeBase.setSortPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 124: {
                pSDETreeNodeBase.setSortPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 125: {
                pSDETreeNodeBase.setTextPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 126: {
                pSDETreeNodeBase.setTextPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 127: {
                pSDETreeNodeBase.setTipPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 128: {
                pSDETreeNodeBase.setTipPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 129: {
                pSDETreeNodeBase.setTipsPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 130: {
                pSDETreeNodeBase.setTipsPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 131: {
                pSDETreeNodeBase.setTooltipInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 132: {
                pSDETreeNodeBase.setTreeNodeType(DataObject.getStringValue((Object)object));
                return;
            }
            case 133: {
                pSDETreeNodeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 134: {
                pSDETreeNodeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 135: {
                pSDETreeNodeBase.setUpdatePSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 136: {
                pSDETreeNodeBase.setUpdatePSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 137: {
                pSDETreeNodeBase.setUpdatePSDEOPPrivId(DataObject.getStringValue((Object)object));
                return;
            }
            case 138: {
                pSDETreeNodeBase.setUpdatePSDEOPPrivName(DataObject.getStringValue((Object)object));
                return;
            }
            case 139: {
                pSDETreeNodeBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 140: {
                pSDETreeNodeBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 141: {
                pSDETreeNodeBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 142: {
                pSDETreeNodeBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 143: {
                pSDETreeNodeBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 144: {
                pSDETreeNodeBase.setViewActions(DataObject.getIntegerValue((Object)object));
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
        return PSDETreeNodeBase.isNull(this, n);
    }

    private static boolean isNull(PSDETreeNodeBase pSDETreeNodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDETreeNodeBase.getActionParam() == null;
            }
            case 1: {
                return pSDETreeNodeBase.getAppendCapFlag() == null;
            }
            case 2: {
                return pSDETreeNodeBase.getAppendPNodeId() == null;
            }
            case 3: {
                return pSDETreeNodeBase.getCaption() == null;
            }
            case 4: {
                return pSDETreeNodeBase.getChecked() == null;
            }
            case 5: {
                return pSDETreeNodeBase.getChildCntPSDEFId() == null;
            }
            case 6: {
                return pSDETreeNodeBase.getChildCntPSDEFName() == null;
            }
            case 7: {
                return pSDETreeNodeBase.getClsPSDEFId() == null;
            }
            case 8: {
                return pSDETreeNodeBase.getClsPSDEFName() == null;
            }
            case 9: {
                return pSDETreeNodeBase.getCMRefresh() == null;
            }
            case 10: {
                return pSDETreeNodeBase.getCMRemove() == null;
            }
            case 11: {
                return pSDETreeNodeBase.getCounterId() == null;
            }
            case 12: {
                return pSDETreeNodeBase.getCounterMode() == null;
            }
            case 13: {
                return pSDETreeNodeBase.getCreateDate() == null;
            }
            case 14: {
                return pSDETreeNodeBase.getCreateMan() == null;
            }
            case 15: {
                return pSDETreeNodeBase.getCustomCode() == null;
            }
            case 16: {
                return pSDETreeNodeBase.getCustomCond() == null;
            }
            case 17: {
                return pSDETreeNodeBase.getCustomType() == null;
            }
            case 18: {
                return pSDETreeNodeBase.getData2PSDEFId() == null;
            }
            case 19: {
                return pSDETreeNodeBase.getData2PSDEFName() == null;
            }
            case 20: {
                return pSDETreeNodeBase.getDataPSDEFId() == null;
            }
            case 21: {
                return pSDETreeNodeBase.getDataPSDEFName() == null;
            }
            case 22: {
                return pSDETreeNodeBase.getDataSource() == null;
            }
            case 23: {
                return pSDETreeNodeBase.getDataTypePSDEFId() == null;
            }
            case 24: {
                return pSDETreeNodeBase.getDataTypePSDEFName() == null;
            }
            case 25: {
                return pSDETreeNodeBase.getDisableSelect() == null;
            }
            case 26: {
                return pSDETreeNodeBase.getDistinctMode() == null;
            }
            case 27: {
                return pSDETreeNodeBase.getDynaClass() == null;
            }
            case 28: {
                return pSDETreeNodeBase.getEditDataMode() == null;
            }
            case 29: {
                return pSDETreeNodeBase.getEditMode() == null;
            }
            case 30: {
                return pSDETreeNodeBase.getEnableCheck() == null;
            }
            case 31: {
                return pSDETreeNodeBase.getEnablePaging() == null;
            }
            case 32: {
                return pSDETreeNodeBase.getEnableQuickSearch() == null;
            }
            case 33: {
                return pSDETreeNodeBase.getEnableUP() == null;
            }
            case 34: {
                return pSDETreeNodeBase.getEnableViewActions() == null;
            }
            case 35: {
                return pSDETreeNodeBase.getExpand() == null;
            }
            case 36: {
                return pSDETreeNodeBase.getFieldName() == null;
            }
            case 37: {
                return pSDETreeNodeBase.getFilterPSDEDSId() == null;
            }
            case 38: {
                return pSDETreeNodeBase.getFilterPSDEDSName() == null;
            }
            case 39: {
                return pSDETreeNodeBase.getIconPSDEFId() == null;
            }
            case 40: {
                return pSDETreeNodeBase.getIconPSDEFName() == null;
            }
            case 41: {
                return pSDETreeNodeBase.getKeyPSDEFId() == null;
            }
            case 42: {
                return pSDETreeNodeBase.getKeyPSDEFName() == null;
            }
            case 43: {
                return pSDETreeNodeBase.getLeafFlagPSDEFId() == null;
            }
            case 44: {
                return pSDETreeNodeBase.getLeafFlagPSDEFName() == null;
            }
            case 45: {
                return pSDETreeNodeBase.getLinkPSDEFId() == null;
            }
            case 46: {
                return pSDETreeNodeBase.getLinkPSDEFName() == null;
            }
            case 47: {
                return pSDETreeNodeBase.getMaxSize() == null;
            }
            case 48: {
                return pSDETreeNodeBase.getMemo() == null;
            }
            case 49: {
                return pSDETreeNodeBase.getModelObj() == null;
            }
            case 50: {
                return pSDETreeNodeBase.getMovePSDEActionId() == null;
            }
            case 51: {
                return pSDETreeNodeBase.getMovePSDEActionName() == null;
            }
            case 52: {
                return pSDETreeNodeBase.getMovePSDEOPPrivId() == null;
            }
            case 53: {
                return pSDETreeNodeBase.getMovePSDEOPPrivName() == null;
            }
            case 54: {
                return pSDETreeNodeBase.getNamePSLanResId() == null;
            }
            case 55: {
                return pSDETreeNodeBase.getNamePSLanResName() == null;
            }
            case 56: {
                return pSDETreeNodeBase.getNavViewFilter() == null;
            }
            case 57: {
                return pSDETreeNodeBase.getNavViewFilterDesc() == null;
            }
            case 58: {
                return pSDETreeNodeBase.getNavViewParam() == null;
            }
            case 59: {
                return pSDETreeNodeBase.getNewDataMode() == null;
            }
            case 60: {
                return pSDETreeNodeBase.getNo2PSDEUAGroupId() == null;
            }
            case 61: {
                return pSDETreeNodeBase.getNo2PSDEUAGroupName() == null;
            }
            case 62: {
                return pSDETreeNodeBase.getNodeAction() == null;
            }
            case 63: {
                return pSDETreeNodeBase.getNodeDataType() == null;
            }
            case 64: {
                return pSDETreeNodeBase.getNodeId2PSDEFId() == null;
            }
            case 65: {
                return pSDETreeNodeBase.getNodeId2PSDEFName() == null;
            }
            case 66: {
                return pSDETreeNodeBase.getNodeId3PSDEFId() == null;
            }
            case 67: {
                return pSDETreeNodeBase.getNodeId3PSDEFName() == null;
            }
            case 68: {
                return pSDETreeNodeBase.getNodeId4PSDEFId() == null;
            }
            case 69: {
                return pSDETreeNodeBase.getNodeId4PSDEFName() == null;
            }
            case 70: {
                return pSDETreeNodeBase.getNodeIdPSDEFId() == null;
            }
            case 71: {
                return pSDETreeNodeBase.getNodeIdPSDEFName() == null;
            }
            case 72: {
                return pSDETreeNodeBase.getNodeType() == null;
            }
            case 73: {
                return pSDETreeNodeBase.getNodeValue() == null;
            }
            case 74: {
                return pSDETreeNodeBase.getPageSize() == null;
            }
            case 75: {
                return pSDETreeNodeBase.getPreventXSS() == null;
            }
            case 76: {
                return pSDETreeNodeBase.getPSCodeListId() == null;
            }
            case 77: {
                return pSDETreeNodeBase.getPSCodeListName() == null;
            }
            case 78: {
                return pSDETreeNodeBase.getPSDEActionId() == null;
            }
            case 79: {
                return pSDETreeNodeBase.getPSDEActionName() == null;
            }
            case 80: {
                return pSDETreeNodeBase.getPSDEDSId() == null;
            }
            case 81: {
                return pSDETreeNodeBase.getPSDEDSName() == null;
            }
            case 82: {
                return pSDETreeNodeBase.getPSDEGridId() == null;
            }
            case 83: {
                return pSDETreeNodeBase.getPSDEGridName() == null;
            }
            case 84: {
                return pSDETreeNodeBase.getPSDEId() == null;
            }
            case 85: {
                return pSDETreeNodeBase.getPSDELogicId() == null;
            }
            case 86: {
                return pSDETreeNodeBase.getPSDELogicName() == null;
            }
            case 87: {
                return pSDETreeNodeBase.getPSDEName() == null;
            }
            case 88: {
                return pSDETreeNodeBase.getPSDERId() == null;
            }
            case 89: {
                return pSDETreeNodeBase.getPSDERName() == null;
            }
            case 90: {
                return pSDETreeNodeBase.getPSDEToolbarId() == null;
            }
            case 91: {
                return pSDETreeNodeBase.getPSDEToolbarName() == null;
            }
            case 92: {
                return pSDETreeNodeBase.getPSDETreeNodeId() == null;
            }
            case 93: {
                return pSDETreeNodeBase.getPSDETreeNodeName() == null;
            }
            case 94: {
                return pSDETreeNodeBase.getPSDETreeViewId() == null;
            }
            case 95: {
                return pSDETreeNodeBase.getPSDETreeViewName() == null;
            }
            case 96: {
                return pSDETreeNodeBase.getPSDEUAGroupId() == null;
            }
            case 97: {
                return pSDETreeNodeBase.getPSDEUAGroupName() == null;
            }
            case 98: {
                return pSDETreeNodeBase.getPSDEViewBaseId() == null;
            }
            case 99: {
                return pSDETreeNodeBase.getPSDEViewBaseName() == null;
            }
            case 100: {
                return pSDETreeNodeBase.getPSSysCssId() == null;
            }
            case 101: {
                return pSDETreeNodeBase.getPSSysCssName() == null;
            }
            case 102: {
                return pSDETreeNodeBase.getPSSysImageId() == null;
            }
            case 103: {
                return pSDETreeNodeBase.getPSSysImageName() == null;
            }
            case 104: {
                return pSDETreeNodeBase.getPSSysPFPluginId() == null;
            }
            case 105: {
                return pSDETreeNodeBase.getPSSysPFPluginName() == null;
            }
            case 106: {
                return pSDETreeNodeBase.getPSSystemId() == null;
            }
            case 107: {
                return pSDETreeNodeBase.getPSSysUniResId() == null;
            }
            case 108: {
                return pSDETreeNodeBase.getPSSysUniResName() == null;
            }
            case 109: {
                return pSDETreeNodeBase.getPSSysViewPanelId() == null;
            }
            case 110: {
                return pSDETreeNodeBase.getPSSysViewPanelName() == null;
            }
            case 111: {
                return pSDETreeNodeBase.getRemovePSDEActionId() == null;
            }
            case 112: {
                return pSDETreeNodeBase.getRemovePSDEActionName() == null;
            }
            case 113: {
                return pSDETreeNodeBase.getRemovePSDEOPPrivId() == null;
            }
            case 114: {
                return pSDETreeNodeBase.getRemovePSDEOPPrivName() == null;
            }
            case 115: {
                return pSDETreeNodeBase.getRootNode() == null;
            }
            case 116: {
                return pSDETreeNodeBase.getSelected() == null;
            }
            case 117: {
                return pSDETreeNodeBase.getShapeClsPSDEFId() == null;
            }
            case 118: {
                return pSDETreeNodeBase.getShapeClsPSDEFName() == null;
            }
            case 119: {
                return pSDETreeNodeBase.getShapeDynaClass() == null;
            }
            case 120: {
                return pSDETreeNodeBase.getShapePSSysCssId() == null;
            }
            case 121: {
                return pSDETreeNodeBase.getShapePSSysCssName() == null;
            }
            case 122: {
                return pSDETreeNodeBase.getSortDir() == null;
            }
            case 123: {
                return pSDETreeNodeBase.getSortPSDEFId() == null;
            }
            case 124: {
                return pSDETreeNodeBase.getSortPSDEFName() == null;
            }
            case 125: {
                return pSDETreeNodeBase.getTextPSDEFId() == null;
            }
            case 126: {
                return pSDETreeNodeBase.getTextPSDEFName() == null;
            }
            case 127: {
                return pSDETreeNodeBase.getTipPSLanResId() == null;
            }
            case 128: {
                return pSDETreeNodeBase.getTipPSLanResName() == null;
            }
            case 129: {
                return pSDETreeNodeBase.getTipsPSDEFId() == null;
            }
            case 130: {
                return pSDETreeNodeBase.getTipsPSDEFName() == null;
            }
            case 131: {
                return pSDETreeNodeBase.getTooltipInfo() == null;
            }
            case 132: {
                return pSDETreeNodeBase.getTreeNodeType() == null;
            }
            case 133: {
                return pSDETreeNodeBase.getUpdateDate() == null;
            }
            case 134: {
                return pSDETreeNodeBase.getUpdateMan() == null;
            }
            case 135: {
                return pSDETreeNodeBase.getUpdatePSDEActionId() == null;
            }
            case 136: {
                return pSDETreeNodeBase.getUpdatePSDEActionName() == null;
            }
            case 137: {
                return pSDETreeNodeBase.getUpdatePSDEOPPrivId() == null;
            }
            case 138: {
                return pSDETreeNodeBase.getUpdatePSDEOPPrivName() == null;
            }
            case 139: {
                return pSDETreeNodeBase.getUserCat() == null;
            }
            case 140: {
                return pSDETreeNodeBase.getUserTag() == null;
            }
            case 141: {
                return pSDETreeNodeBase.getUserTag2() == null;
            }
            case 142: {
                return pSDETreeNodeBase.getUserTag3() == null;
            }
            case 143: {
                return pSDETreeNodeBase.getUserTag4() == null;
            }
            case 144: {
                return pSDETreeNodeBase.getViewActions() == null;
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
        return PSDETreeNodeBase.contains(this, n);
    }

    private static boolean contains(PSDETreeNodeBase pSDETreeNodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDETreeNodeBase.isActionParamDirty();
            }
            case 1: {
                return pSDETreeNodeBase.isAppendCapFlagDirty();
            }
            case 2: {
                return pSDETreeNodeBase.isAppendPNodeIdDirty();
            }
            case 3: {
                return pSDETreeNodeBase.isCaptionDirty();
            }
            case 4: {
                return pSDETreeNodeBase.isCheckedDirty();
            }
            case 5: {
                return pSDETreeNodeBase.isChildCntPSDEFIdDirty();
            }
            case 6: {
                return pSDETreeNodeBase.isChildCntPSDEFNameDirty();
            }
            case 7: {
                return pSDETreeNodeBase.isClsPSDEFIdDirty();
            }
            case 8: {
                return pSDETreeNodeBase.isClsPSDEFNameDirty();
            }
            case 9: {
                return pSDETreeNodeBase.isCMRefreshDirty();
            }
            case 10: {
                return pSDETreeNodeBase.isCMRemoveDirty();
            }
            case 11: {
                return pSDETreeNodeBase.isCounterIdDirty();
            }
            case 12: {
                return pSDETreeNodeBase.isCounterModeDirty();
            }
            case 13: {
                return pSDETreeNodeBase.isCreateDateDirty();
            }
            case 14: {
                return pSDETreeNodeBase.isCreateManDirty();
            }
            case 15: {
                return pSDETreeNodeBase.isCustomCodeDirty();
            }
            case 16: {
                return pSDETreeNodeBase.isCustomCondDirty();
            }
            case 17: {
                return pSDETreeNodeBase.isCustomTypeDirty();
            }
            case 18: {
                return pSDETreeNodeBase.isData2PSDEFIdDirty();
            }
            case 19: {
                return pSDETreeNodeBase.isData2PSDEFNameDirty();
            }
            case 20: {
                return pSDETreeNodeBase.isDataPSDEFIdDirty();
            }
            case 21: {
                return pSDETreeNodeBase.isDataPSDEFNameDirty();
            }
            case 22: {
                return pSDETreeNodeBase.isDataSourceDirty();
            }
            case 23: {
                return pSDETreeNodeBase.isDataTypePSDEFIdDirty();
            }
            case 24: {
                return pSDETreeNodeBase.isDataTypePSDEFNameDirty();
            }
            case 25: {
                return pSDETreeNodeBase.isDisableSelectDirty();
            }
            case 26: {
                return pSDETreeNodeBase.isDistinctModeDirty();
            }
            case 27: {
                return pSDETreeNodeBase.isDynaClassDirty();
            }
            case 28: {
                return pSDETreeNodeBase.isEditDataModeDirty();
            }
            case 29: {
                return pSDETreeNodeBase.isEditModeDirty();
            }
            case 30: {
                return pSDETreeNodeBase.isEnableCheckDirty();
            }
            case 31: {
                return pSDETreeNodeBase.isEnablePagingDirty();
            }
            case 32: {
                return pSDETreeNodeBase.isEnableQuickSearchDirty();
            }
            case 33: {
                return pSDETreeNodeBase.isEnableUPDirty();
            }
            case 34: {
                return pSDETreeNodeBase.isEnableViewActionsDirty();
            }
            case 35: {
                return pSDETreeNodeBase.isExpandDirty();
            }
            case 36: {
                return pSDETreeNodeBase.isFieldNameDirty();
            }
            case 37: {
                return pSDETreeNodeBase.isFilterPSDEDSIdDirty();
            }
            case 38: {
                return pSDETreeNodeBase.isFilterPSDEDSNameDirty();
            }
            case 39: {
                return pSDETreeNodeBase.isIconPSDEFIdDirty();
            }
            case 40: {
                return pSDETreeNodeBase.isIconPSDEFNameDirty();
            }
            case 41: {
                return pSDETreeNodeBase.isKeyPSDEFIdDirty();
            }
            case 42: {
                return pSDETreeNodeBase.isKeyPSDEFNameDirty();
            }
            case 43: {
                return pSDETreeNodeBase.isLeafFlagPSDEFIdDirty();
            }
            case 44: {
                return pSDETreeNodeBase.isLeafFlagPSDEFNameDirty();
            }
            case 45: {
                return pSDETreeNodeBase.isLinkPSDEFIdDirty();
            }
            case 46: {
                return pSDETreeNodeBase.isLinkPSDEFNameDirty();
            }
            case 47: {
                return pSDETreeNodeBase.isMaxSizeDirty();
            }
            case 48: {
                return pSDETreeNodeBase.isMemoDirty();
            }
            case 49: {
                return pSDETreeNodeBase.isModelObjDirty();
            }
            case 50: {
                return pSDETreeNodeBase.isMovePSDEActionIdDirty();
            }
            case 51: {
                return pSDETreeNodeBase.isMovePSDEActionNameDirty();
            }
            case 52: {
                return pSDETreeNodeBase.isMovePSDEOPPrivIdDirty();
            }
            case 53: {
                return pSDETreeNodeBase.isMovePSDEOPPrivNameDirty();
            }
            case 54: {
                return pSDETreeNodeBase.isNamePSLanResIdDirty();
            }
            case 55: {
                return pSDETreeNodeBase.isNamePSLanResNameDirty();
            }
            case 56: {
                return pSDETreeNodeBase.isNavViewFilterDirty();
            }
            case 57: {
                return pSDETreeNodeBase.isNavViewFilterDescDirty();
            }
            case 58: {
                return pSDETreeNodeBase.isNavViewParamDirty();
            }
            case 59: {
                return pSDETreeNodeBase.isNewDataModeDirty();
            }
            case 60: {
                return pSDETreeNodeBase.isNo2PSDEUAGroupIdDirty();
            }
            case 61: {
                return pSDETreeNodeBase.isNo2PSDEUAGroupNameDirty();
            }
            case 62: {
                return pSDETreeNodeBase.isNodeActionDirty();
            }
            case 63: {
                return pSDETreeNodeBase.isNodeDataTypeDirty();
            }
            case 64: {
                return pSDETreeNodeBase.isNodeId2PSDEFIdDirty();
            }
            case 65: {
                return pSDETreeNodeBase.isNodeId2PSDEFNameDirty();
            }
            case 66: {
                return pSDETreeNodeBase.isNodeId3PSDEFIdDirty();
            }
            case 67: {
                return pSDETreeNodeBase.isNodeId3PSDEFNameDirty();
            }
            case 68: {
                return pSDETreeNodeBase.isNodeId4PSDEFIdDirty();
            }
            case 69: {
                return pSDETreeNodeBase.isNodeId4PSDEFNameDirty();
            }
            case 70: {
                return pSDETreeNodeBase.isNodeIdPSDEFIdDirty();
            }
            case 71: {
                return pSDETreeNodeBase.isNodeIdPSDEFNameDirty();
            }
            case 72: {
                return pSDETreeNodeBase.isNodeTypeDirty();
            }
            case 73: {
                return pSDETreeNodeBase.isNodeValueDirty();
            }
            case 74: {
                return pSDETreeNodeBase.isPageSizeDirty();
            }
            case 75: {
                return pSDETreeNodeBase.isPreventXSSDirty();
            }
            case 76: {
                return pSDETreeNodeBase.isPSCodeListIdDirty();
            }
            case 77: {
                return pSDETreeNodeBase.isPSCodeListNameDirty();
            }
            case 78: {
                return pSDETreeNodeBase.isPSDEActionIdDirty();
            }
            case 79: {
                return pSDETreeNodeBase.isPSDEActionNameDirty();
            }
            case 80: {
                return pSDETreeNodeBase.isPSDEDSIdDirty();
            }
            case 81: {
                return pSDETreeNodeBase.isPSDEDSNameDirty();
            }
            case 82: {
                return pSDETreeNodeBase.isPSDEGridIdDirty();
            }
            case 83: {
                return pSDETreeNodeBase.isPSDEGridNameDirty();
            }
            case 84: {
                return pSDETreeNodeBase.isPSDEIdDirty();
            }
            case 85: {
                return pSDETreeNodeBase.isPSDELogicIdDirty();
            }
            case 86: {
                return pSDETreeNodeBase.isPSDELogicNameDirty();
            }
            case 87: {
                return pSDETreeNodeBase.isPSDENameDirty();
            }
            case 88: {
                return pSDETreeNodeBase.isPSDERIdDirty();
            }
            case 89: {
                return pSDETreeNodeBase.isPSDERNameDirty();
            }
            case 90: {
                return pSDETreeNodeBase.isPSDEToolbarIdDirty();
            }
            case 91: {
                return pSDETreeNodeBase.isPSDEToolbarNameDirty();
            }
            case 92: {
                return pSDETreeNodeBase.isPSDETreeNodeIdDirty();
            }
            case 93: {
                return pSDETreeNodeBase.isPSDETreeNodeNameDirty();
            }
            case 94: {
                return pSDETreeNodeBase.isPSDETreeViewIdDirty();
            }
            case 95: {
                return pSDETreeNodeBase.isPSDETreeViewNameDirty();
            }
            case 96: {
                return pSDETreeNodeBase.isPSDEUAGroupIdDirty();
            }
            case 97: {
                return pSDETreeNodeBase.isPSDEUAGroupNameDirty();
            }
            case 98: {
                return pSDETreeNodeBase.isPSDEViewBaseIdDirty();
            }
            case 99: {
                return pSDETreeNodeBase.isPSDEViewBaseNameDirty();
            }
            case 100: {
                return pSDETreeNodeBase.isPSSysCssIdDirty();
            }
            case 101: {
                return pSDETreeNodeBase.isPSSysCssNameDirty();
            }
            case 102: {
                return pSDETreeNodeBase.isPSSysImageIdDirty();
            }
            case 103: {
                return pSDETreeNodeBase.isPSSysImageNameDirty();
            }
            case 104: {
                return pSDETreeNodeBase.isPSSysPFPluginIdDirty();
            }
            case 105: {
                return pSDETreeNodeBase.isPSSysPFPluginNameDirty();
            }
            case 106: {
                return pSDETreeNodeBase.isPSSystemIdDirty();
            }
            case 107: {
                return pSDETreeNodeBase.isPSSysUniResIdDirty();
            }
            case 108: {
                return pSDETreeNodeBase.isPSSysUniResNameDirty();
            }
            case 109: {
                return pSDETreeNodeBase.isPSSysViewPanelIdDirty();
            }
            case 110: {
                return pSDETreeNodeBase.isPSSysViewPanelNameDirty();
            }
            case 111: {
                return pSDETreeNodeBase.isRemovePSDEActionIdDirty();
            }
            case 112: {
                return pSDETreeNodeBase.isRemovePSDEActionNameDirty();
            }
            case 113: {
                return pSDETreeNodeBase.isRemovePSDEOPPrivIdDirty();
            }
            case 114: {
                return pSDETreeNodeBase.isRemovePSDEOPPrivNameDirty();
            }
            case 115: {
                return pSDETreeNodeBase.isRootNodeDirty();
            }
            case 116: {
                return pSDETreeNodeBase.isSelectedDirty();
            }
            case 117: {
                return pSDETreeNodeBase.isShapeClsPSDEFIdDirty();
            }
            case 118: {
                return pSDETreeNodeBase.isShapeClsPSDEFNameDirty();
            }
            case 119: {
                return pSDETreeNodeBase.isShapeDynaClassDirty();
            }
            case 120: {
                return pSDETreeNodeBase.isShapePSSysCssIdDirty();
            }
            case 121: {
                return pSDETreeNodeBase.isShapePSSysCssNameDirty();
            }
            case 122: {
                return pSDETreeNodeBase.isSortDirDirty();
            }
            case 123: {
                return pSDETreeNodeBase.isSortPSDEFIdDirty();
            }
            case 124: {
                return pSDETreeNodeBase.isSortPSDEFNameDirty();
            }
            case 125: {
                return pSDETreeNodeBase.isTextPSDEFIdDirty();
            }
            case 126: {
                return pSDETreeNodeBase.isTextPSDEFNameDirty();
            }
            case 127: {
                return pSDETreeNodeBase.isTipPSLanResIdDirty();
            }
            case 128: {
                return pSDETreeNodeBase.isTipPSLanResNameDirty();
            }
            case 129: {
                return pSDETreeNodeBase.isTipsPSDEFIdDirty();
            }
            case 130: {
                return pSDETreeNodeBase.isTipsPSDEFNameDirty();
            }
            case 131: {
                return pSDETreeNodeBase.isTooltipInfoDirty();
            }
            case 132: {
                return pSDETreeNodeBase.isTreeNodeTypeDirty();
            }
            case 133: {
                return pSDETreeNodeBase.isUpdateDateDirty();
            }
            case 134: {
                return pSDETreeNodeBase.isUpdateManDirty();
            }
            case 135: {
                return pSDETreeNodeBase.isUpdatePSDEActionIdDirty();
            }
            case 136: {
                return pSDETreeNodeBase.isUpdatePSDEActionNameDirty();
            }
            case 137: {
                return pSDETreeNodeBase.isUpdatePSDEOPPrivIdDirty();
            }
            case 138: {
                return pSDETreeNodeBase.isUpdatePSDEOPPrivNameDirty();
            }
            case 139: {
                return pSDETreeNodeBase.isUserCatDirty();
            }
            case 140: {
                return pSDETreeNodeBase.isUserTagDirty();
            }
            case 141: {
                return pSDETreeNodeBase.isUserTag2Dirty();
            }
            case 142: {
                return pSDETreeNodeBase.isUserTag3Dirty();
            }
            case 143: {
                return pSDETreeNodeBase.isUserTag4Dirty();
            }
            case 144: {
                return pSDETreeNodeBase.isViewActionsDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDETreeNodeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDETreeNodeBase pSDETreeNodeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDETreeNodeBase.getActionParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getActionParam()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getAppendCapFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"appendcapflag", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getAppendCapFlag()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getAppendPNodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"appendpnodeid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getAppendPNodeId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"caption", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getCaption()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getChecked() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"checked", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getChecked()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getChildCntPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"childcntpsdefid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getChildCntPSDEFId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getChildCntPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"childcntpsdefname", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getChildCntPSDEFName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getClsPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clspsdefid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getClsPSDEFId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getClsPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clspsdefname", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getClsPSDEFName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getCMRefresh() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cmrefresh", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getCMRefresh()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getCMRemove() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cmremove", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getCMRemove()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getCounterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"counterid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getCounterId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getCounterMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"countermode", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getCounterMode()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getCustomCond() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcond", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getCustomCond()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getCustomType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customtype", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getCustomType()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getData2PSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"data2psdefid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getData2PSDEFId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getData2PSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"data2psdefname", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getData2PSDEFName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getDataPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"datapsdefid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getDataPSDEFId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getDataPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"datapsdefname", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getDataPSDEFName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getDataSource() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"datasource", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getDataSource()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getDataTypePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"datatypepsdefid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getDataTypePSDEFId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getDataTypePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"datatypepsdefname", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getDataTypePSDEFName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getDisableSelect() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"disableselect", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getDisableSelect()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getDistinctMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"distinctmode", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getDistinctMode()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getDynaClass() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynaclass", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getDynaClass()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getEditDataMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"editdatamode", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getEditDataMode()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getEditMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"editmode", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getEditMode()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getEnableCheck() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablecheck", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getEnableCheck()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getEnablePaging() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablepaging", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getEnablePaging()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getEnableQuickSearch() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablequicksearch", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getEnableQuickSearch()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getEnableUP() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableup", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getEnableUP()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getEnableViewActions() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableviewactions", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getEnableViewActions()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getExpand() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expand", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getExpand()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getFieldName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fieldname", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getFieldName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getFilterPSDEDSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"filterpsdedsid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getFilterPSDEDSId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getFilterPSDEDSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"filterpsdedsname", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getFilterPSDEDSName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getIconPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconpsdefid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getIconPSDEFId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getIconPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconpsdefname", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getIconPSDEFName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getKeyPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"keypsdefid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getKeyPSDEFId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getKeyPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"keypsdefname", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getKeyPSDEFName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getLeafFlagPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"leafflagpsdefid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getLeafFlagPSDEFId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getLeafFlagPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"leafflagpsdefname", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getLeafFlagPSDEFName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getLinkPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkpsdefid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getLinkPSDEFId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getLinkPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkpsdefname", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getLinkPSDEFName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getMaxSize() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxsize", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getMaxSize()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getMemo()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getModelObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelobj", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getModelObj()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getMovePSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"movepsdeactionid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getMovePSDEActionId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getMovePSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"movepsdeactionname", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getMovePSDEActionName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getMovePSDEOPPrivId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"movepsdeopprivid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getMovePSDEOPPrivId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getMovePSDEOPPrivName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"movepsdeopprivname", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getMovePSDEOPPrivName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getNamePSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"namepslanresid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getNamePSLanResId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getNamePSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"namepslanresname", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getNamePSLanResName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getNavViewFilter() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewfilter", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getNavViewFilter()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getNavViewFilterDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewfilterdesc", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getNavViewFilterDesc()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getNavViewParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewparam", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getNavViewParam()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getNewDataMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"newdatamode", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getNewDataMode()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getNo2PSDEUAGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no2psdeuagroupid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getNo2PSDEUAGroupId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getNo2PSDEUAGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no2psdeuagroupname", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getNo2PSDEUAGroupName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getNodeAction() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nodeaction", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getNodeAction()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getNodeDataType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nodedatatype", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getNodeDataType()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getNodeId2PSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nodeid2psdefid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getNodeId2PSDEFId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getNodeId2PSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nodeid2psdefname", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getNodeId2PSDEFName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getNodeId3PSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nodeid3psdefid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getNodeId3PSDEFId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getNodeId3PSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nodeid3psdefname", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getNodeId3PSDEFName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getNodeId4PSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nodeid4psdefid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getNodeId4PSDEFId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getNodeId4PSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nodeid4psdefname", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getNodeId4PSDEFName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getNodeIdPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nodeidpsdefid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getNodeIdPSDEFId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getNodeIdPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nodeidpsdefname", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getNodeIdPSDEFName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getNodeType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nodetype", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getNodeType()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getNodeValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nodevalue", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getNodeValue()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getPageSize() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pagesize", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getPageSize()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getPreventXSS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"preventxss", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getPreventXSS()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getPSCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getPSCodeListId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getPSCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistname", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getPSCodeListName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getPSDEActionId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionname", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getPSDEActionName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getPSDEDSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getPSDEDSId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getPSDEDSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsname", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getPSDEDSName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getPSDEGridId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegridid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getPSDEGridId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getPSDEGridName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegridname", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getPSDEGridName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getPSDELogicId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicname", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getPSDELogicName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getPSDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psderid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getPSDERId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getPSDERName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdername", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getPSDERName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getPSDEToolbarId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetoolbarid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getPSDEToolbarId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getPSDEToolbarName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetoolbarname", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getPSDEToolbarName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getPSDETreeNodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreenodeid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getPSDETreeNodeId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getPSDETreeNodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreenodename", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getPSDETreeNodeName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getPSDETreeViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreeviewid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getPSDETreeViewId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getPSDETreeViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreeviewname", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getPSDETreeViewName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getPSDEUAGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuagroupid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getPSDEUAGroupId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getPSDEUAGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuagroupname", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getPSDEUAGroupName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getPSDEViewBaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbaseid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getPSDEViewBaseId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getPSDEViewBaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbasename", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getPSDEViewBaseName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getPSSysCssId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssname", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getPSSysCssName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getPSSysImageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimageid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getPSSysImageId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getPSSysImageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimagename", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getPSSysImageName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getPSSysUniResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuniresid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getPSSysUniResId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getPSSysUniResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuniresname", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getPSSysUniResName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelname", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getRemovePSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"removepsdeactionid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getRemovePSDEActionId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getRemovePSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"removepsdeactionname", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getRemovePSDEActionName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getRemovePSDEOPPrivId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"removepsdeopprivid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getRemovePSDEOPPrivId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getRemovePSDEOPPrivName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"removepsdeopprivname", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getRemovePSDEOPPrivName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getRootNode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rootnode", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getRootNode()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getSelected() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"selected", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getSelected()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getShapeClsPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"shapeclspsdefid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getShapeClsPSDEFId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getShapeClsPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"shapeclspsdefname", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getShapeClsPSDEFName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getShapeDynaClass() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"shapedynaclass", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getShapeDynaClass()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getShapePSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"shapepssyscssid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getShapePSSysCssId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getShapePSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"shapepssyscssname", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getShapePSSysCssName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getSortDir() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sortdir", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getSortDir()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getSortPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sortpsdefid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getSortPSDEFId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getSortPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sortpsdefname", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getSortPSDEFName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getTextPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"textpsdefid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getTextPSDEFId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getTextPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"textpsdefname", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getTextPSDEFName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getTipPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tippslanresid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getTipPSLanResId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getTipPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tippslanresname", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getTipPSLanResName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getTipsPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tipspsdefid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getTipsPSDEFId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getTipsPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tipspsdefname", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getTipsPSDEFName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getTooltipInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tooltipinfo", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getTooltipInfo()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getTreeNodeType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"treenodetype", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getTreeNodeType()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getUpdatePSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatepsdeactionid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getUpdatePSDEActionId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getUpdatePSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatepsdeactionname", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getUpdatePSDEActionName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getUpdatePSDEOPPrivId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatepsdeopprivid", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getUpdatePSDEOPPrivId()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getUpdatePSDEOPPrivName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatepsdeopprivname", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getUpdatePSDEOPPrivName()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDETreeNodeBase.getViewActions() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewactions", (Object)PSDETreeNodeBase.getJSONValue((Object)pSDETreeNodeBase.getViewActions()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDETreeNodeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDETreeNodeBase pSDETreeNodeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDETreeNodeBase.getActionParam() != null) {
            object = pSDETreeNodeBase.getActionParam();
            xmlNode.setAttribute(FIELD_ACTIONPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getAppendCapFlag() != null) {
            object = pSDETreeNodeBase.getAppendCapFlag();
            xmlNode.setAttribute(FIELD_APPENDCAPFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeNodeBase.getAppendPNodeId() != null) {
            object = pSDETreeNodeBase.getAppendPNodeId();
            xmlNode.setAttribute(FIELD_APPENDPNODEID, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeNodeBase.getCaption() != null) {
            object = pSDETreeNodeBase.getCaption();
            xmlNode.setAttribute(FIELD_CAPTION, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getChecked() != null) {
            object = pSDETreeNodeBase.getChecked();
            xmlNode.setAttribute(FIELD_CHECKED, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeNodeBase.getChildCntPSDEFId() != null) {
            object = pSDETreeNodeBase.getChildCntPSDEFId();
            xmlNode.setAttribute(FIELD_CHILDCNTPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getChildCntPSDEFName() != null) {
            object = pSDETreeNodeBase.getChildCntPSDEFName();
            xmlNode.setAttribute(FIELD_CHILDCNTPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getClsPSDEFId() != null) {
            object = pSDETreeNodeBase.getClsPSDEFId();
            xmlNode.setAttribute(FIELD_CLSPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getClsPSDEFName() != null) {
            object = pSDETreeNodeBase.getClsPSDEFName();
            xmlNode.setAttribute(FIELD_CLSPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getCMRefresh() != null) {
            object = pSDETreeNodeBase.getCMRefresh();
            xmlNode.setAttribute(FIELD_CMREFRESH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeNodeBase.getCMRemove() != null) {
            object = pSDETreeNodeBase.getCMRemove();
            xmlNode.setAttribute(FIELD_CMREMOVE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeNodeBase.getCounterId() != null) {
            object = pSDETreeNodeBase.getCounterId();
            xmlNode.setAttribute(FIELD_COUNTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getCounterMode() != null) {
            object = pSDETreeNodeBase.getCounterMode();
            xmlNode.setAttribute(FIELD_COUNTERMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeNodeBase.getCreateDate() != null) {
            object = pSDETreeNodeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDETreeNodeBase.getCreateMan() != null) {
            object = pSDETreeNodeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getCustomCode() != null) {
            object = pSDETreeNodeBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getCustomCond() != null) {
            object = pSDETreeNodeBase.getCustomCond();
            xmlNode.setAttribute(FIELD_CUSTOMCOND, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getCustomType() != null) {
            object = pSDETreeNodeBase.getCustomType();
            xmlNode.setAttribute(FIELD_CUSTOMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getData2PSDEFId() != null) {
            object = pSDETreeNodeBase.getData2PSDEFId();
            xmlNode.setAttribute(FIELD_DATA2PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getData2PSDEFName() != null) {
            object = pSDETreeNodeBase.getData2PSDEFName();
            xmlNode.setAttribute(FIELD_DATA2PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getDataPSDEFId() != null) {
            object = pSDETreeNodeBase.getDataPSDEFId();
            xmlNode.setAttribute(FIELD_DATAPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getDataPSDEFName() != null) {
            object = pSDETreeNodeBase.getDataPSDEFName();
            xmlNode.setAttribute(FIELD_DATAPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getDataSource() != null) {
            object = pSDETreeNodeBase.getDataSource();
            xmlNode.setAttribute(FIELD_DATASOURCE, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getDataTypePSDEFId() != null) {
            object = pSDETreeNodeBase.getDataTypePSDEFId();
            xmlNode.setAttribute(FIELD_DATATYPEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getDataTypePSDEFName() != null) {
            object = pSDETreeNodeBase.getDataTypePSDEFName();
            xmlNode.setAttribute(FIELD_DATATYPEPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getDisableSelect() != null) {
            object = pSDETreeNodeBase.getDisableSelect();
            xmlNode.setAttribute(FIELD_DISABLESELECT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeNodeBase.getDistinctMode() != null) {
            object = pSDETreeNodeBase.getDistinctMode();
            xmlNode.setAttribute(FIELD_DISTINCTMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeNodeBase.getDynaClass() != null) {
            object = pSDETreeNodeBase.getDynaClass();
            xmlNode.setAttribute(FIELD_DYNACLASS, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getEditDataMode() != null) {
            object = pSDETreeNodeBase.getEditDataMode();
            xmlNode.setAttribute(FIELD_EDITDATAMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getEditMode() != null) {
            object = pSDETreeNodeBase.getEditMode();
            xmlNode.setAttribute(FIELD_EDITMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeNodeBase.getEnableCheck() != null) {
            object = pSDETreeNodeBase.getEnableCheck();
            xmlNode.setAttribute(FIELD_ENABLECHECK, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeNodeBase.getEnablePaging() != null) {
            object = pSDETreeNodeBase.getEnablePaging();
            xmlNode.setAttribute(FIELD_ENABLEPAGING, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeNodeBase.getEnableQuickSearch() != null) {
            object = pSDETreeNodeBase.getEnableQuickSearch();
            xmlNode.setAttribute(FIELD_ENABLEQUICKSEARCH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeNodeBase.getEnableUP() != null) {
            object = pSDETreeNodeBase.getEnableUP();
            xmlNode.setAttribute(FIELD_ENABLEUP, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeNodeBase.getEnableViewActions() != null) {
            object = pSDETreeNodeBase.getEnableViewActions();
            xmlNode.setAttribute(FIELD_ENABLEVIEWACTIONS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeNodeBase.getExpand() != null) {
            object = pSDETreeNodeBase.getExpand();
            xmlNode.setAttribute(FIELD_EXPAND, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeNodeBase.getFieldName() != null) {
            object = pSDETreeNodeBase.getFieldName();
            xmlNode.setAttribute(FIELD_FIELDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getFilterPSDEDSId() != null) {
            object = pSDETreeNodeBase.getFilterPSDEDSId();
            xmlNode.setAttribute(FIELD_FILTERPSDEDSID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getFilterPSDEDSName() != null) {
            object = pSDETreeNodeBase.getFilterPSDEDSName();
            xmlNode.setAttribute(FIELD_FILTERPSDEDSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getIconPSDEFId() != null) {
            object = pSDETreeNodeBase.getIconPSDEFId();
            xmlNode.setAttribute(FIELD_ICONPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getIconPSDEFName() != null) {
            object = pSDETreeNodeBase.getIconPSDEFName();
            xmlNode.setAttribute(FIELD_ICONPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getKeyPSDEFId() != null) {
            object = pSDETreeNodeBase.getKeyPSDEFId();
            xmlNode.setAttribute(FIELD_KEYPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getKeyPSDEFName() != null) {
            object = pSDETreeNodeBase.getKeyPSDEFName();
            xmlNode.setAttribute(FIELD_KEYPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getLeafFlagPSDEFId() != null) {
            object = pSDETreeNodeBase.getLeafFlagPSDEFId();
            xmlNode.setAttribute(FIELD_LEAFFLAGPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getLeafFlagPSDEFName() != null) {
            object = pSDETreeNodeBase.getLeafFlagPSDEFName();
            xmlNode.setAttribute(FIELD_LEAFFLAGPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getLinkPSDEFId() != null) {
            object = pSDETreeNodeBase.getLinkPSDEFId();
            xmlNode.setAttribute(FIELD_LINKPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getLinkPSDEFName() != null) {
            object = pSDETreeNodeBase.getLinkPSDEFName();
            xmlNode.setAttribute(FIELD_LINKPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getMaxSize() != null) {
            object = pSDETreeNodeBase.getMaxSize();
            xmlNode.setAttribute(FIELD_MAXSIZE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeNodeBase.getMemo() != null) {
            object = pSDETreeNodeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getModelObj() != null) {
            object = pSDETreeNodeBase.getModelObj();
            xmlNode.setAttribute(FIELD_MODELOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getMovePSDEActionId() != null) {
            object = pSDETreeNodeBase.getMovePSDEActionId();
            xmlNode.setAttribute(FIELD_MOVEPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getMovePSDEActionName() != null) {
            object = pSDETreeNodeBase.getMovePSDEActionName();
            xmlNode.setAttribute(FIELD_MOVEPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getMovePSDEOPPrivId() != null) {
            object = pSDETreeNodeBase.getMovePSDEOPPrivId();
            xmlNode.setAttribute(FIELD_MOVEPSDEOPPRIVID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getMovePSDEOPPrivName() != null) {
            object = pSDETreeNodeBase.getMovePSDEOPPrivName();
            xmlNode.setAttribute(FIELD_MOVEPSDEOPPRIVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getNamePSLanResId() != null) {
            object = pSDETreeNodeBase.getNamePSLanResId();
            xmlNode.setAttribute(FIELD_NAMEPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getNamePSLanResName() != null) {
            object = pSDETreeNodeBase.getNamePSLanResName();
            xmlNode.setAttribute(FIELD_NAMEPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getNavViewFilter() != null) {
            object = pSDETreeNodeBase.getNavViewFilter();
            xmlNode.setAttribute(FIELD_NAVVIEWFILTER, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getNavViewFilterDesc() != null) {
            object = pSDETreeNodeBase.getNavViewFilterDesc();
            xmlNode.setAttribute(FIELD_NAVVIEWFILTERDESC, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getNavViewParam() != null) {
            object = pSDETreeNodeBase.getNavViewParam();
            xmlNode.setAttribute(FIELD_NAVVIEWPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getNewDataMode() != null) {
            object = pSDETreeNodeBase.getNewDataMode();
            xmlNode.setAttribute(FIELD_NEWDATAMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getNo2PSDEUAGroupId() != null) {
            object = pSDETreeNodeBase.getNo2PSDEUAGroupId();
            xmlNode.setAttribute(FIELD_NO2PSDEUAGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getNo2PSDEUAGroupName() != null) {
            object = pSDETreeNodeBase.getNo2PSDEUAGroupName();
            xmlNode.setAttribute(FIELD_NO2PSDEUAGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getNodeAction() != null) {
            object = pSDETreeNodeBase.getNodeAction();
            xmlNode.setAttribute(FIELD_NODEACTION, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getNodeDataType() != null) {
            object = pSDETreeNodeBase.getNodeDataType();
            xmlNode.setAttribute(FIELD_NODEDATATYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getNodeId2PSDEFId() != null) {
            object = pSDETreeNodeBase.getNodeId2PSDEFId();
            xmlNode.setAttribute(FIELD_NODEID2PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getNodeId2PSDEFName() != null) {
            object = pSDETreeNodeBase.getNodeId2PSDEFName();
            xmlNode.setAttribute(FIELD_NODEID2PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getNodeId3PSDEFId() != null) {
            object = pSDETreeNodeBase.getNodeId3PSDEFId();
            xmlNode.setAttribute(FIELD_NODEID3PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getNodeId3PSDEFName() != null) {
            object = pSDETreeNodeBase.getNodeId3PSDEFName();
            xmlNode.setAttribute(FIELD_NODEID3PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getNodeId4PSDEFId() != null) {
            object = pSDETreeNodeBase.getNodeId4PSDEFId();
            xmlNode.setAttribute(FIELD_NODEID4PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getNodeId4PSDEFName() != null) {
            object = pSDETreeNodeBase.getNodeId4PSDEFName();
            xmlNode.setAttribute(FIELD_NODEID4PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getNodeIdPSDEFId() != null) {
            object = pSDETreeNodeBase.getNodeIdPSDEFId();
            xmlNode.setAttribute(FIELD_NODEIDPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getNodeIdPSDEFName() != null) {
            object = pSDETreeNodeBase.getNodeIdPSDEFName();
            xmlNode.setAttribute(FIELD_NODEIDPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getNodeType() != null) {
            object = pSDETreeNodeBase.getNodeType();
            xmlNode.setAttribute(FIELD_NODETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getNodeValue() != null) {
            object = pSDETreeNodeBase.getNodeValue();
            xmlNode.setAttribute(FIELD_NODEVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getPageSize() != null) {
            object = pSDETreeNodeBase.getPageSize();
            xmlNode.setAttribute(FIELD_PAGESIZE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeNodeBase.getPreventXSS() != null) {
            object = pSDETreeNodeBase.getPreventXSS();
            xmlNode.setAttribute(FIELD_PREVENTXSS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeNodeBase.getPSCodeListId() != null) {
            object = pSDETreeNodeBase.getPSCodeListId();
            xmlNode.setAttribute(FIELD_PSCODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getPSCodeListName() != null) {
            object = pSDETreeNodeBase.getPSCodeListName();
            xmlNode.setAttribute(FIELD_PSCODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getPSDEActionId() != null) {
            object = pSDETreeNodeBase.getPSDEActionId();
            xmlNode.setAttribute(FIELD_PSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getPSDEActionName() != null) {
            object = pSDETreeNodeBase.getPSDEActionName();
            xmlNode.setAttribute(FIELD_PSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getPSDEDSId() != null) {
            object = pSDETreeNodeBase.getPSDEDSId();
            xmlNode.setAttribute(FIELD_PSDEDSID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getPSDEDSName() != null) {
            object = pSDETreeNodeBase.getPSDEDSName();
            xmlNode.setAttribute(FIELD_PSDEDSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getPSDEGridId() != null) {
            object = pSDETreeNodeBase.getPSDEGridId();
            xmlNode.setAttribute(FIELD_PSDEGRIDID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getPSDEGridName() != null) {
            object = pSDETreeNodeBase.getPSDEGridName();
            xmlNode.setAttribute(FIELD_PSDEGRIDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getPSDEId() != null) {
            object = pSDETreeNodeBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getPSDELogicId() != null) {
            object = pSDETreeNodeBase.getPSDELogicId();
            xmlNode.setAttribute(FIELD_PSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getPSDELogicName() != null) {
            object = pSDETreeNodeBase.getPSDELogicName();
            xmlNode.setAttribute(FIELD_PSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getPSDEName() != null) {
            object = pSDETreeNodeBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getPSDERId() != null) {
            object = pSDETreeNodeBase.getPSDERId();
            xmlNode.setAttribute(FIELD_PSDERID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getPSDERName() != null) {
            object = pSDETreeNodeBase.getPSDERName();
            xmlNode.setAttribute(FIELD_PSDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getPSDEToolbarId() != null) {
            object = pSDETreeNodeBase.getPSDEToolbarId();
            xmlNode.setAttribute(FIELD_PSDETOOLBARID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getPSDEToolbarName() != null) {
            object = pSDETreeNodeBase.getPSDEToolbarName();
            xmlNode.setAttribute(FIELD_PSDETOOLBARNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getPSDETreeNodeId() != null) {
            object = pSDETreeNodeBase.getPSDETreeNodeId();
            xmlNode.setAttribute(FIELD_PSDETREENODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getPSDETreeNodeName() != null) {
            object = pSDETreeNodeBase.getPSDETreeNodeName();
            xmlNode.setAttribute(FIELD_PSDETREENODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getPSDETreeViewId() != null) {
            object = pSDETreeNodeBase.getPSDETreeViewId();
            xmlNode.setAttribute(FIELD_PSDETREEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getPSDETreeViewName() != null) {
            object = pSDETreeNodeBase.getPSDETreeViewName();
            xmlNode.setAttribute(FIELD_PSDETREEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getPSDEUAGroupId() != null) {
            object = pSDETreeNodeBase.getPSDEUAGroupId();
            xmlNode.setAttribute(FIELD_PSDEUAGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getPSDEUAGroupName() != null) {
            object = pSDETreeNodeBase.getPSDEUAGroupName();
            xmlNode.setAttribute(FIELD_PSDEUAGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getPSDEViewBaseId() != null) {
            object = pSDETreeNodeBase.getPSDEViewBaseId();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASEID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getPSDEViewBaseName() != null) {
            object = pSDETreeNodeBase.getPSDEViewBaseName();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getPSSysCssId() != null) {
            object = pSDETreeNodeBase.getPSSysCssId();
            xmlNode.setAttribute(FIELD_PSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getPSSysCssName() != null) {
            object = pSDETreeNodeBase.getPSSysCssName();
            xmlNode.setAttribute(FIELD_PSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getPSSysImageId() != null) {
            object = pSDETreeNodeBase.getPSSysImageId();
            xmlNode.setAttribute(FIELD_PSSYSIMAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getPSSysImageName() != null) {
            object = pSDETreeNodeBase.getPSSysImageName();
            xmlNode.setAttribute(FIELD_PSSYSIMAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getPSSysPFPluginId() != null) {
            object = pSDETreeNodeBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getPSSysPFPluginName() != null) {
            object = pSDETreeNodeBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getPSSystemId() != null) {
            object = pSDETreeNodeBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getPSSysUniResId() != null) {
            object = pSDETreeNodeBase.getPSSysUniResId();
            xmlNode.setAttribute(FIELD_PSSYSUNIRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getPSSysUniResName() != null) {
            object = pSDETreeNodeBase.getPSSysUniResName();
            xmlNode.setAttribute(FIELD_PSSYSUNIRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getPSSysViewPanelId() != null) {
            object = pSDETreeNodeBase.getPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getPSSysViewPanelName() != null) {
            object = pSDETreeNodeBase.getPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getRemovePSDEActionId() != null) {
            object = pSDETreeNodeBase.getRemovePSDEActionId();
            xmlNode.setAttribute(FIELD_REMOVEPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getRemovePSDEActionName() != null) {
            object = pSDETreeNodeBase.getRemovePSDEActionName();
            xmlNode.setAttribute(FIELD_REMOVEPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getRemovePSDEOPPrivId() != null) {
            object = pSDETreeNodeBase.getRemovePSDEOPPrivId();
            xmlNode.setAttribute(FIELD_REMOVEPSDEOPPRIVID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getRemovePSDEOPPrivName() != null) {
            object = pSDETreeNodeBase.getRemovePSDEOPPrivName();
            xmlNode.setAttribute(FIELD_REMOVEPSDEOPPRIVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getRootNode() != null) {
            object = pSDETreeNodeBase.getRootNode();
            xmlNode.setAttribute(FIELD_ROOTNODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeNodeBase.getSelected() != null) {
            object = pSDETreeNodeBase.getSelected();
            xmlNode.setAttribute(FIELD_SELECTED, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeNodeBase.getShapeClsPSDEFId() != null) {
            object = pSDETreeNodeBase.getShapeClsPSDEFId();
            xmlNode.setAttribute(FIELD_SHAPECLSPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getShapeClsPSDEFName() != null) {
            object = pSDETreeNodeBase.getShapeClsPSDEFName();
            xmlNode.setAttribute(FIELD_SHAPECLSPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getShapeDynaClass() != null) {
            object = pSDETreeNodeBase.getShapeDynaClass();
            xmlNode.setAttribute(FIELD_SHAPEDYNACLASS, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getShapePSSysCssId() != null) {
            object = pSDETreeNodeBase.getShapePSSysCssId();
            xmlNode.setAttribute(FIELD_SHAPEPSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getShapePSSysCssName() != null) {
            object = pSDETreeNodeBase.getShapePSSysCssName();
            xmlNode.setAttribute(FIELD_SHAPEPSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getSortDir() != null) {
            object = pSDETreeNodeBase.getSortDir();
            xmlNode.setAttribute(FIELD_SORTDIR, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getSortPSDEFId() != null) {
            object = pSDETreeNodeBase.getSortPSDEFId();
            xmlNode.setAttribute(FIELD_SORTPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getSortPSDEFName() != null) {
            object = pSDETreeNodeBase.getSortPSDEFName();
            xmlNode.setAttribute(FIELD_SORTPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getTextPSDEFId() != null) {
            object = pSDETreeNodeBase.getTextPSDEFId();
            xmlNode.setAttribute(FIELD_TEXTPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getTextPSDEFName() != null) {
            object = pSDETreeNodeBase.getTextPSDEFName();
            xmlNode.setAttribute(FIELD_TEXTPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getTipPSLanResId() != null) {
            object = pSDETreeNodeBase.getTipPSLanResId();
            xmlNode.setAttribute(FIELD_TIPPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getTipPSLanResName() != null) {
            object = pSDETreeNodeBase.getTipPSLanResName();
            xmlNode.setAttribute(FIELD_TIPPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getTipsPSDEFId() != null) {
            object = pSDETreeNodeBase.getTipsPSDEFId();
            xmlNode.setAttribute(FIELD_TIPSPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getTipsPSDEFName() != null) {
            object = pSDETreeNodeBase.getTipsPSDEFName();
            xmlNode.setAttribute(FIELD_TIPSPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getTooltipInfo() != null) {
            object = pSDETreeNodeBase.getTooltipInfo();
            xmlNode.setAttribute(FIELD_TOOLTIPINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getTreeNodeType() != null) {
            object = pSDETreeNodeBase.getTreeNodeType();
            xmlNode.setAttribute(FIELD_TREENODETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getUpdateDate() != null) {
            object = pSDETreeNodeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDETreeNodeBase.getUpdateMan() != null) {
            object = pSDETreeNodeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getUpdatePSDEActionId() != null) {
            object = pSDETreeNodeBase.getUpdatePSDEActionId();
            xmlNode.setAttribute(FIELD_UPDATEPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getUpdatePSDEActionName() != null) {
            object = pSDETreeNodeBase.getUpdatePSDEActionName();
            xmlNode.setAttribute(FIELD_UPDATEPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getUpdatePSDEOPPrivId() != null) {
            object = pSDETreeNodeBase.getUpdatePSDEOPPrivId();
            xmlNode.setAttribute(FIELD_UPDATEPSDEOPPRIVID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getUpdatePSDEOPPrivName() != null) {
            object = pSDETreeNodeBase.getUpdatePSDEOPPrivName();
            xmlNode.setAttribute(FIELD_UPDATEPSDEOPPRIVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getUserCat() != null) {
            object = pSDETreeNodeBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getUserTag() != null) {
            object = pSDETreeNodeBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getUserTag2() != null) {
            object = pSDETreeNodeBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getUserTag3() != null) {
            object = pSDETreeNodeBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getUserTag4() != null) {
            object = pSDETreeNodeBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeBase.getViewActions() != null) {
            object = pSDETreeNodeBase.getViewActions();
            xmlNode.setAttribute(FIELD_VIEWACTIONS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDETreeNodeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDETreeNodeBase pSDETreeNodeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDETreeNodeBase.isActionParamDirty() && (bl || pSDETreeNodeBase.getActionParam() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM, (Object)pSDETreeNodeBase.getActionParam());
        }
        if (pSDETreeNodeBase.isAppendCapFlagDirty() && (bl || pSDETreeNodeBase.getAppendCapFlag() != null)) {
            iDataObject.set(FIELD_APPENDCAPFLAG, (Object)pSDETreeNodeBase.getAppendCapFlag());
        }
        if (pSDETreeNodeBase.isAppendPNodeIdDirty() && (bl || pSDETreeNodeBase.getAppendPNodeId() != null)) {
            iDataObject.set(FIELD_APPENDPNODEID, (Object)pSDETreeNodeBase.getAppendPNodeId());
        }
        if (pSDETreeNodeBase.isCaptionDirty() && (bl || pSDETreeNodeBase.getCaption() != null)) {
            iDataObject.set(FIELD_CAPTION, (Object)pSDETreeNodeBase.getCaption());
        }
        if (pSDETreeNodeBase.isCheckedDirty() && (bl || pSDETreeNodeBase.getChecked() != null)) {
            iDataObject.set(FIELD_CHECKED, (Object)pSDETreeNodeBase.getChecked());
        }
        if (pSDETreeNodeBase.isChildCntPSDEFIdDirty() && (bl || pSDETreeNodeBase.getChildCntPSDEFId() != null)) {
            iDataObject.set(FIELD_CHILDCNTPSDEFID, (Object)pSDETreeNodeBase.getChildCntPSDEFId());
        }
        if (pSDETreeNodeBase.isChildCntPSDEFNameDirty() && (bl || pSDETreeNodeBase.getChildCntPSDEFName() != null)) {
            iDataObject.set(FIELD_CHILDCNTPSDEFNAME, (Object)pSDETreeNodeBase.getChildCntPSDEFName());
        }
        if (pSDETreeNodeBase.isClsPSDEFIdDirty() && (bl || pSDETreeNodeBase.getClsPSDEFId() != null)) {
            iDataObject.set(FIELD_CLSPSDEFID, (Object)pSDETreeNodeBase.getClsPSDEFId());
        }
        if (pSDETreeNodeBase.isClsPSDEFNameDirty() && (bl || pSDETreeNodeBase.getClsPSDEFName() != null)) {
            iDataObject.set(FIELD_CLSPSDEFNAME, (Object)pSDETreeNodeBase.getClsPSDEFName());
        }
        if (pSDETreeNodeBase.isCMRefreshDirty() && (bl || pSDETreeNodeBase.getCMRefresh() != null)) {
            iDataObject.set(FIELD_CMREFRESH, (Object)pSDETreeNodeBase.getCMRefresh());
        }
        if (pSDETreeNodeBase.isCMRemoveDirty() && (bl || pSDETreeNodeBase.getCMRemove() != null)) {
            iDataObject.set(FIELD_CMREMOVE, (Object)pSDETreeNodeBase.getCMRemove());
        }
        if (pSDETreeNodeBase.isCounterIdDirty() && (bl || pSDETreeNodeBase.getCounterId() != null)) {
            iDataObject.set(FIELD_COUNTERID, (Object)pSDETreeNodeBase.getCounterId());
        }
        if (pSDETreeNodeBase.isCounterModeDirty() && (bl || pSDETreeNodeBase.getCounterMode() != null)) {
            iDataObject.set(FIELD_COUNTERMODE, (Object)pSDETreeNodeBase.getCounterMode());
        }
        if (pSDETreeNodeBase.isCreateDateDirty() && (bl || pSDETreeNodeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDETreeNodeBase.getCreateDate());
        }
        if (pSDETreeNodeBase.isCreateManDirty() && (bl || pSDETreeNodeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDETreeNodeBase.getCreateMan());
        }
        if (pSDETreeNodeBase.isCustomCodeDirty() && (bl || pSDETreeNodeBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSDETreeNodeBase.getCustomCode());
        }
        if (pSDETreeNodeBase.isCustomCondDirty() && (bl || pSDETreeNodeBase.getCustomCond() != null)) {
            iDataObject.set(FIELD_CUSTOMCOND, (Object)pSDETreeNodeBase.getCustomCond());
        }
        if (pSDETreeNodeBase.isCustomTypeDirty() && (bl || pSDETreeNodeBase.getCustomType() != null)) {
            iDataObject.set(FIELD_CUSTOMTYPE, (Object)pSDETreeNodeBase.getCustomType());
        }
        if (pSDETreeNodeBase.isData2PSDEFIdDirty() && (bl || pSDETreeNodeBase.getData2PSDEFId() != null)) {
            iDataObject.set(FIELD_DATA2PSDEFID, (Object)pSDETreeNodeBase.getData2PSDEFId());
        }
        if (pSDETreeNodeBase.isData2PSDEFNameDirty() && (bl || pSDETreeNodeBase.getData2PSDEFName() != null)) {
            iDataObject.set(FIELD_DATA2PSDEFNAME, (Object)pSDETreeNodeBase.getData2PSDEFName());
        }
        if (pSDETreeNodeBase.isDataPSDEFIdDirty() && (bl || pSDETreeNodeBase.getDataPSDEFId() != null)) {
            iDataObject.set(FIELD_DATAPSDEFID, (Object)pSDETreeNodeBase.getDataPSDEFId());
        }
        if (pSDETreeNodeBase.isDataPSDEFNameDirty() && (bl || pSDETreeNodeBase.getDataPSDEFName() != null)) {
            iDataObject.set(FIELD_DATAPSDEFNAME, (Object)pSDETreeNodeBase.getDataPSDEFName());
        }
        if (pSDETreeNodeBase.isDataSourceDirty() && (bl || pSDETreeNodeBase.getDataSource() != null)) {
            iDataObject.set(FIELD_DATASOURCE, (Object)pSDETreeNodeBase.getDataSource());
        }
        if (pSDETreeNodeBase.isDataTypePSDEFIdDirty() && (bl || pSDETreeNodeBase.getDataTypePSDEFId() != null)) {
            iDataObject.set(FIELD_DATATYPEPSDEFID, (Object)pSDETreeNodeBase.getDataTypePSDEFId());
        }
        if (pSDETreeNodeBase.isDataTypePSDEFNameDirty() && (bl || pSDETreeNodeBase.getDataTypePSDEFName() != null)) {
            iDataObject.set(FIELD_DATATYPEPSDEFNAME, (Object)pSDETreeNodeBase.getDataTypePSDEFName());
        }
        if (pSDETreeNodeBase.isDisableSelectDirty() && (bl || pSDETreeNodeBase.getDisableSelect() != null)) {
            iDataObject.set(FIELD_DISABLESELECT, (Object)pSDETreeNodeBase.getDisableSelect());
        }
        if (pSDETreeNodeBase.isDistinctModeDirty() && (bl || pSDETreeNodeBase.getDistinctMode() != null)) {
            iDataObject.set(FIELD_DISTINCTMODE, (Object)pSDETreeNodeBase.getDistinctMode());
        }
        if (pSDETreeNodeBase.isDynaClassDirty() && (bl || pSDETreeNodeBase.getDynaClass() != null)) {
            iDataObject.set(FIELD_DYNACLASS, (Object)pSDETreeNodeBase.getDynaClass());
        }
        if (pSDETreeNodeBase.isEditDataModeDirty() && (bl || pSDETreeNodeBase.getEditDataMode() != null)) {
            iDataObject.set(FIELD_EDITDATAMODE, (Object)pSDETreeNodeBase.getEditDataMode());
        }
        if (pSDETreeNodeBase.isEditModeDirty() && (bl || pSDETreeNodeBase.getEditMode() != null)) {
            iDataObject.set(FIELD_EDITMODE, (Object)pSDETreeNodeBase.getEditMode());
        }
        if (pSDETreeNodeBase.isEnableCheckDirty() && (bl || pSDETreeNodeBase.getEnableCheck() != null)) {
            iDataObject.set(FIELD_ENABLECHECK, (Object)pSDETreeNodeBase.getEnableCheck());
        }
        if (pSDETreeNodeBase.isEnablePagingDirty() && (bl || pSDETreeNodeBase.getEnablePaging() != null)) {
            iDataObject.set(FIELD_ENABLEPAGING, (Object)pSDETreeNodeBase.getEnablePaging());
        }
        if (pSDETreeNodeBase.isEnableQuickSearchDirty() && (bl || pSDETreeNodeBase.getEnableQuickSearch() != null)) {
            iDataObject.set(FIELD_ENABLEQUICKSEARCH, (Object)pSDETreeNodeBase.getEnableQuickSearch());
        }
        if (pSDETreeNodeBase.isEnableUPDirty() && (bl || pSDETreeNodeBase.getEnableUP() != null)) {
            iDataObject.set(FIELD_ENABLEUP, (Object)pSDETreeNodeBase.getEnableUP());
        }
        if (pSDETreeNodeBase.isEnableViewActionsDirty() && (bl || pSDETreeNodeBase.getEnableViewActions() != null)) {
            iDataObject.set(FIELD_ENABLEVIEWACTIONS, (Object)pSDETreeNodeBase.getEnableViewActions());
        }
        if (pSDETreeNodeBase.isExpandDirty() && (bl || pSDETreeNodeBase.getExpand() != null)) {
            iDataObject.set(FIELD_EXPAND, (Object)pSDETreeNodeBase.getExpand());
        }
        if (pSDETreeNodeBase.isFieldNameDirty() && (bl || pSDETreeNodeBase.getFieldName() != null)) {
            iDataObject.set(FIELD_FIELDNAME, (Object)pSDETreeNodeBase.getFieldName());
        }
        if (pSDETreeNodeBase.isFilterPSDEDSIdDirty() && (bl || pSDETreeNodeBase.getFilterPSDEDSId() != null)) {
            iDataObject.set(FIELD_FILTERPSDEDSID, (Object)pSDETreeNodeBase.getFilterPSDEDSId());
        }
        if (pSDETreeNodeBase.isFilterPSDEDSNameDirty() && (bl || pSDETreeNodeBase.getFilterPSDEDSName() != null)) {
            iDataObject.set(FIELD_FILTERPSDEDSNAME, (Object)pSDETreeNodeBase.getFilterPSDEDSName());
        }
        if (pSDETreeNodeBase.isIconPSDEFIdDirty() && (bl || pSDETreeNodeBase.getIconPSDEFId() != null)) {
            iDataObject.set(FIELD_ICONPSDEFID, (Object)pSDETreeNodeBase.getIconPSDEFId());
        }
        if (pSDETreeNodeBase.isIconPSDEFNameDirty() && (bl || pSDETreeNodeBase.getIconPSDEFName() != null)) {
            iDataObject.set(FIELD_ICONPSDEFNAME, (Object)pSDETreeNodeBase.getIconPSDEFName());
        }
        if (pSDETreeNodeBase.isKeyPSDEFIdDirty() && (bl || pSDETreeNodeBase.getKeyPSDEFId() != null)) {
            iDataObject.set(FIELD_KEYPSDEFID, (Object)pSDETreeNodeBase.getKeyPSDEFId());
        }
        if (pSDETreeNodeBase.isKeyPSDEFNameDirty() && (bl || pSDETreeNodeBase.getKeyPSDEFName() != null)) {
            iDataObject.set(FIELD_KEYPSDEFNAME, (Object)pSDETreeNodeBase.getKeyPSDEFName());
        }
        if (pSDETreeNodeBase.isLeafFlagPSDEFIdDirty() && (bl || pSDETreeNodeBase.getLeafFlagPSDEFId() != null)) {
            iDataObject.set(FIELD_LEAFFLAGPSDEFID, (Object)pSDETreeNodeBase.getLeafFlagPSDEFId());
        }
        if (pSDETreeNodeBase.isLeafFlagPSDEFNameDirty() && (bl || pSDETreeNodeBase.getLeafFlagPSDEFName() != null)) {
            iDataObject.set(FIELD_LEAFFLAGPSDEFNAME, (Object)pSDETreeNodeBase.getLeafFlagPSDEFName());
        }
        if (pSDETreeNodeBase.isLinkPSDEFIdDirty() && (bl || pSDETreeNodeBase.getLinkPSDEFId() != null)) {
            iDataObject.set(FIELD_LINKPSDEFID, (Object)pSDETreeNodeBase.getLinkPSDEFId());
        }
        if (pSDETreeNodeBase.isLinkPSDEFNameDirty() && (bl || pSDETreeNodeBase.getLinkPSDEFName() != null)) {
            iDataObject.set(FIELD_LINKPSDEFNAME, (Object)pSDETreeNodeBase.getLinkPSDEFName());
        }
        if (pSDETreeNodeBase.isMaxSizeDirty() && (bl || pSDETreeNodeBase.getMaxSize() != null)) {
            iDataObject.set(FIELD_MAXSIZE, (Object)pSDETreeNodeBase.getMaxSize());
        }
        if (pSDETreeNodeBase.isMemoDirty() && (bl || pSDETreeNodeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDETreeNodeBase.getMemo());
        }
        if (pSDETreeNodeBase.isModelObjDirty() && (bl || pSDETreeNodeBase.getModelObj() != null)) {
            iDataObject.set(FIELD_MODELOBJ, (Object)pSDETreeNodeBase.getModelObj());
        }
        if (pSDETreeNodeBase.isMovePSDEActionIdDirty() && (bl || pSDETreeNodeBase.getMovePSDEActionId() != null)) {
            iDataObject.set(FIELD_MOVEPSDEACTIONID, (Object)pSDETreeNodeBase.getMovePSDEActionId());
        }
        if (pSDETreeNodeBase.isMovePSDEActionNameDirty() && (bl || pSDETreeNodeBase.getMovePSDEActionName() != null)) {
            iDataObject.set(FIELD_MOVEPSDEACTIONNAME, (Object)pSDETreeNodeBase.getMovePSDEActionName());
        }
        if (pSDETreeNodeBase.isMovePSDEOPPrivIdDirty() && (bl || pSDETreeNodeBase.getMovePSDEOPPrivId() != null)) {
            iDataObject.set(FIELD_MOVEPSDEOPPRIVID, (Object)pSDETreeNodeBase.getMovePSDEOPPrivId());
        }
        if (pSDETreeNodeBase.isMovePSDEOPPrivNameDirty() && (bl || pSDETreeNodeBase.getMovePSDEOPPrivName() != null)) {
            iDataObject.set(FIELD_MOVEPSDEOPPRIVNAME, (Object)pSDETreeNodeBase.getMovePSDEOPPrivName());
        }
        if (pSDETreeNodeBase.isNamePSLanResIdDirty() && (bl || pSDETreeNodeBase.getNamePSLanResId() != null)) {
            iDataObject.set(FIELD_NAMEPSLANRESID, (Object)pSDETreeNodeBase.getNamePSLanResId());
        }
        if (pSDETreeNodeBase.isNamePSLanResNameDirty() && (bl || pSDETreeNodeBase.getNamePSLanResName() != null)) {
            iDataObject.set(FIELD_NAMEPSLANRESNAME, (Object)pSDETreeNodeBase.getNamePSLanResName());
        }
        if (pSDETreeNodeBase.isNavViewFilterDirty() && (bl || pSDETreeNodeBase.getNavViewFilter() != null)) {
            iDataObject.set(FIELD_NAVVIEWFILTER, (Object)pSDETreeNodeBase.getNavViewFilter());
        }
        if (pSDETreeNodeBase.isNavViewFilterDescDirty() && (bl || pSDETreeNodeBase.getNavViewFilterDesc() != null)) {
            iDataObject.set(FIELD_NAVVIEWFILTERDESC, (Object)pSDETreeNodeBase.getNavViewFilterDesc());
        }
        if (pSDETreeNodeBase.isNavViewParamDirty() && (bl || pSDETreeNodeBase.getNavViewParam() != null)) {
            iDataObject.set(FIELD_NAVVIEWPARAM, (Object)pSDETreeNodeBase.getNavViewParam());
        }
        if (pSDETreeNodeBase.isNewDataModeDirty() && (bl || pSDETreeNodeBase.getNewDataMode() != null)) {
            iDataObject.set(FIELD_NEWDATAMODE, (Object)pSDETreeNodeBase.getNewDataMode());
        }
        if (pSDETreeNodeBase.isNo2PSDEUAGroupIdDirty() && (bl || pSDETreeNodeBase.getNo2PSDEUAGroupId() != null)) {
            iDataObject.set(FIELD_NO2PSDEUAGROUPID, (Object)pSDETreeNodeBase.getNo2PSDEUAGroupId());
        }
        if (pSDETreeNodeBase.isNo2PSDEUAGroupNameDirty() && (bl || pSDETreeNodeBase.getNo2PSDEUAGroupName() != null)) {
            iDataObject.set(FIELD_NO2PSDEUAGROUPNAME, (Object)pSDETreeNodeBase.getNo2PSDEUAGroupName());
        }
        if (pSDETreeNodeBase.isNodeActionDirty() && (bl || pSDETreeNodeBase.getNodeAction() != null)) {
            iDataObject.set(FIELD_NODEACTION, (Object)pSDETreeNodeBase.getNodeAction());
        }
        if (pSDETreeNodeBase.isNodeDataTypeDirty() && (bl || pSDETreeNodeBase.getNodeDataType() != null)) {
            iDataObject.set(FIELD_NODEDATATYPE, (Object)pSDETreeNodeBase.getNodeDataType());
        }
        if (pSDETreeNodeBase.isNodeId2PSDEFIdDirty() && (bl || pSDETreeNodeBase.getNodeId2PSDEFId() != null)) {
            iDataObject.set(FIELD_NODEID2PSDEFID, (Object)pSDETreeNodeBase.getNodeId2PSDEFId());
        }
        if (pSDETreeNodeBase.isNodeId2PSDEFNameDirty() && (bl || pSDETreeNodeBase.getNodeId2PSDEFName() != null)) {
            iDataObject.set(FIELD_NODEID2PSDEFNAME, (Object)pSDETreeNodeBase.getNodeId2PSDEFName());
        }
        if (pSDETreeNodeBase.isNodeId3PSDEFIdDirty() && (bl || pSDETreeNodeBase.getNodeId3PSDEFId() != null)) {
            iDataObject.set(FIELD_NODEID3PSDEFID, (Object)pSDETreeNodeBase.getNodeId3PSDEFId());
        }
        if (pSDETreeNodeBase.isNodeId3PSDEFNameDirty() && (bl || pSDETreeNodeBase.getNodeId3PSDEFName() != null)) {
            iDataObject.set(FIELD_NODEID3PSDEFNAME, (Object)pSDETreeNodeBase.getNodeId3PSDEFName());
        }
        if (pSDETreeNodeBase.isNodeId4PSDEFIdDirty() && (bl || pSDETreeNodeBase.getNodeId4PSDEFId() != null)) {
            iDataObject.set(FIELD_NODEID4PSDEFID, (Object)pSDETreeNodeBase.getNodeId4PSDEFId());
        }
        if (pSDETreeNodeBase.isNodeId4PSDEFNameDirty() && (bl || pSDETreeNodeBase.getNodeId4PSDEFName() != null)) {
            iDataObject.set(FIELD_NODEID4PSDEFNAME, (Object)pSDETreeNodeBase.getNodeId4PSDEFName());
        }
        if (pSDETreeNodeBase.isNodeIdPSDEFIdDirty() && (bl || pSDETreeNodeBase.getNodeIdPSDEFId() != null)) {
            iDataObject.set(FIELD_NODEIDPSDEFID, (Object)pSDETreeNodeBase.getNodeIdPSDEFId());
        }
        if (pSDETreeNodeBase.isNodeIdPSDEFNameDirty() && (bl || pSDETreeNodeBase.getNodeIdPSDEFName() != null)) {
            iDataObject.set(FIELD_NODEIDPSDEFNAME, (Object)pSDETreeNodeBase.getNodeIdPSDEFName());
        }
        if (pSDETreeNodeBase.isNodeTypeDirty() && (bl || pSDETreeNodeBase.getNodeType() != null)) {
            iDataObject.set(FIELD_NODETYPE, (Object)pSDETreeNodeBase.getNodeType());
        }
        if (pSDETreeNodeBase.isNodeValueDirty() && (bl || pSDETreeNodeBase.getNodeValue() != null)) {
            iDataObject.set(FIELD_NODEVALUE, (Object)pSDETreeNodeBase.getNodeValue());
        }
        if (pSDETreeNodeBase.isPageSizeDirty() && (bl || pSDETreeNodeBase.getPageSize() != null)) {
            iDataObject.set(FIELD_PAGESIZE, (Object)pSDETreeNodeBase.getPageSize());
        }
        if (pSDETreeNodeBase.isPreventXSSDirty() && (bl || pSDETreeNodeBase.getPreventXSS() != null)) {
            iDataObject.set(FIELD_PREVENTXSS, (Object)pSDETreeNodeBase.getPreventXSS());
        }
        if (pSDETreeNodeBase.isPSCodeListIdDirty() && (bl || pSDETreeNodeBase.getPSCodeListId() != null)) {
            iDataObject.set(FIELD_PSCODELISTID, (Object)pSDETreeNodeBase.getPSCodeListId());
        }
        if (pSDETreeNodeBase.isPSCodeListNameDirty() && (bl || pSDETreeNodeBase.getPSCodeListName() != null)) {
            iDataObject.set(FIELD_PSCODELISTNAME, (Object)pSDETreeNodeBase.getPSCodeListName());
        }
        if (pSDETreeNodeBase.isPSDEActionIdDirty() && (bl || pSDETreeNodeBase.getPSDEActionId() != null)) {
            iDataObject.set(FIELD_PSDEACTIONID, (Object)pSDETreeNodeBase.getPSDEActionId());
        }
        if (pSDETreeNodeBase.isPSDEActionNameDirty() && (bl || pSDETreeNodeBase.getPSDEActionName() != null)) {
            iDataObject.set(FIELD_PSDEACTIONNAME, (Object)pSDETreeNodeBase.getPSDEActionName());
        }
        if (pSDETreeNodeBase.isPSDEDSIdDirty() && (bl || pSDETreeNodeBase.getPSDEDSId() != null)) {
            iDataObject.set(FIELD_PSDEDSID, (Object)pSDETreeNodeBase.getPSDEDSId());
        }
        if (pSDETreeNodeBase.isPSDEDSNameDirty() && (bl || pSDETreeNodeBase.getPSDEDSName() != null)) {
            iDataObject.set(FIELD_PSDEDSNAME, (Object)pSDETreeNodeBase.getPSDEDSName());
        }
        if (pSDETreeNodeBase.isPSDEGridIdDirty() && (bl || pSDETreeNodeBase.getPSDEGridId() != null)) {
            iDataObject.set(FIELD_PSDEGRIDID, (Object)pSDETreeNodeBase.getPSDEGridId());
        }
        if (pSDETreeNodeBase.isPSDEGridNameDirty() && (bl || pSDETreeNodeBase.getPSDEGridName() != null)) {
            iDataObject.set(FIELD_PSDEGRIDNAME, (Object)pSDETreeNodeBase.getPSDEGridName());
        }
        if (pSDETreeNodeBase.isPSDEIdDirty() && (bl || pSDETreeNodeBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDETreeNodeBase.getPSDEId());
        }
        if (pSDETreeNodeBase.isPSDELogicIdDirty() && (bl || pSDETreeNodeBase.getPSDELogicId() != null)) {
            iDataObject.set(FIELD_PSDELOGICID, (Object)pSDETreeNodeBase.getPSDELogicId());
        }
        if (pSDETreeNodeBase.isPSDELogicNameDirty() && (bl || pSDETreeNodeBase.getPSDELogicName() != null)) {
            iDataObject.set(FIELD_PSDELOGICNAME, (Object)pSDETreeNodeBase.getPSDELogicName());
        }
        if (pSDETreeNodeBase.isPSDENameDirty() && (bl || pSDETreeNodeBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDETreeNodeBase.getPSDEName());
        }
        if (pSDETreeNodeBase.isPSDERIdDirty() && (bl || pSDETreeNodeBase.getPSDERId() != null)) {
            iDataObject.set(FIELD_PSDERID, (Object)pSDETreeNodeBase.getPSDERId());
        }
        if (pSDETreeNodeBase.isPSDERNameDirty() && (bl || pSDETreeNodeBase.getPSDERName() != null)) {
            iDataObject.set(FIELD_PSDERNAME, (Object)pSDETreeNodeBase.getPSDERName());
        }
        if (pSDETreeNodeBase.isPSDEToolbarIdDirty() && (bl || pSDETreeNodeBase.getPSDEToolbarId() != null)) {
            iDataObject.set(FIELD_PSDETOOLBARID, (Object)pSDETreeNodeBase.getPSDEToolbarId());
        }
        if (pSDETreeNodeBase.isPSDEToolbarNameDirty() && (bl || pSDETreeNodeBase.getPSDEToolbarName() != null)) {
            iDataObject.set(FIELD_PSDETOOLBARNAME, (Object)pSDETreeNodeBase.getPSDEToolbarName());
        }
        if (pSDETreeNodeBase.isPSDETreeNodeIdDirty() && (bl || pSDETreeNodeBase.getPSDETreeNodeId() != null)) {
            iDataObject.set(FIELD_PSDETREENODEID, (Object)pSDETreeNodeBase.getPSDETreeNodeId());
        }
        if (pSDETreeNodeBase.isPSDETreeNodeNameDirty() && (bl || pSDETreeNodeBase.getPSDETreeNodeName() != null)) {
            iDataObject.set(FIELD_PSDETREENODENAME, (Object)pSDETreeNodeBase.getPSDETreeNodeName());
        }
        if (pSDETreeNodeBase.isPSDETreeViewIdDirty() && (bl || pSDETreeNodeBase.getPSDETreeViewId() != null)) {
            iDataObject.set(FIELD_PSDETREEVIEWID, (Object)pSDETreeNodeBase.getPSDETreeViewId());
        }
        if (pSDETreeNodeBase.isPSDETreeViewNameDirty() && (bl || pSDETreeNodeBase.getPSDETreeViewName() != null)) {
            iDataObject.set(FIELD_PSDETREEVIEWNAME, (Object)pSDETreeNodeBase.getPSDETreeViewName());
        }
        if (pSDETreeNodeBase.isPSDEUAGroupIdDirty() && (bl || pSDETreeNodeBase.getPSDEUAGroupId() != null)) {
            iDataObject.set(FIELD_PSDEUAGROUPID, (Object)pSDETreeNodeBase.getPSDEUAGroupId());
        }
        if (pSDETreeNodeBase.isPSDEUAGroupNameDirty() && (bl || pSDETreeNodeBase.getPSDEUAGroupName() != null)) {
            iDataObject.set(FIELD_PSDEUAGROUPNAME, (Object)pSDETreeNodeBase.getPSDEUAGroupName());
        }
        if (pSDETreeNodeBase.isPSDEViewBaseIdDirty() && (bl || pSDETreeNodeBase.getPSDEViewBaseId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASEID, (Object)pSDETreeNodeBase.getPSDEViewBaseId());
        }
        if (pSDETreeNodeBase.isPSDEViewBaseNameDirty() && (bl || pSDETreeNodeBase.getPSDEViewBaseName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASENAME, (Object)pSDETreeNodeBase.getPSDEViewBaseName());
        }
        if (pSDETreeNodeBase.isPSSysCssIdDirty() && (bl || pSDETreeNodeBase.getPSSysCssId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSID, (Object)pSDETreeNodeBase.getPSSysCssId());
        }
        if (pSDETreeNodeBase.isPSSysCssNameDirty() && (bl || pSDETreeNodeBase.getPSSysCssName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSNAME, (Object)pSDETreeNodeBase.getPSSysCssName());
        }
        if (pSDETreeNodeBase.isPSSysImageIdDirty() && (bl || pSDETreeNodeBase.getPSSysImageId() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGEID, (Object)pSDETreeNodeBase.getPSSysImageId());
        }
        if (pSDETreeNodeBase.isPSSysImageNameDirty() && (bl || pSDETreeNodeBase.getPSSysImageName() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGENAME, (Object)pSDETreeNodeBase.getPSSysImageName());
        }
        if (pSDETreeNodeBase.isPSSysPFPluginIdDirty() && (bl || pSDETreeNodeBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSDETreeNodeBase.getPSSysPFPluginId());
        }
        if (pSDETreeNodeBase.isPSSysPFPluginNameDirty() && (bl || pSDETreeNodeBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSDETreeNodeBase.getPSSysPFPluginName());
        }
        if (pSDETreeNodeBase.isPSSystemIdDirty() && (bl || pSDETreeNodeBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSDETreeNodeBase.getPSSystemId());
        }
        if (pSDETreeNodeBase.isPSSysUniResIdDirty() && (bl || pSDETreeNodeBase.getPSSysUniResId() != null)) {
            iDataObject.set(FIELD_PSSYSUNIRESID, (Object)pSDETreeNodeBase.getPSSysUniResId());
        }
        if (pSDETreeNodeBase.isPSSysUniResNameDirty() && (bl || pSDETreeNodeBase.getPSSysUniResName() != null)) {
            iDataObject.set(FIELD_PSSYSUNIRESNAME, (Object)pSDETreeNodeBase.getPSSysUniResName());
        }
        if (pSDETreeNodeBase.isPSSysViewPanelIdDirty() && (bl || pSDETreeNodeBase.getPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELID, (Object)pSDETreeNodeBase.getPSSysViewPanelId());
        }
        if (pSDETreeNodeBase.isPSSysViewPanelNameDirty() && (bl || pSDETreeNodeBase.getPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELNAME, (Object)pSDETreeNodeBase.getPSSysViewPanelName());
        }
        if (pSDETreeNodeBase.isRemovePSDEActionIdDirty() && (bl || pSDETreeNodeBase.getRemovePSDEActionId() != null)) {
            iDataObject.set(FIELD_REMOVEPSDEACTIONID, (Object)pSDETreeNodeBase.getRemovePSDEActionId());
        }
        if (pSDETreeNodeBase.isRemovePSDEActionNameDirty() && (bl || pSDETreeNodeBase.getRemovePSDEActionName() != null)) {
            iDataObject.set(FIELD_REMOVEPSDEACTIONNAME, (Object)pSDETreeNodeBase.getRemovePSDEActionName());
        }
        if (pSDETreeNodeBase.isRemovePSDEOPPrivIdDirty() && (bl || pSDETreeNodeBase.getRemovePSDEOPPrivId() != null)) {
            iDataObject.set(FIELD_REMOVEPSDEOPPRIVID, (Object)pSDETreeNodeBase.getRemovePSDEOPPrivId());
        }
        if (pSDETreeNodeBase.isRemovePSDEOPPrivNameDirty() && (bl || pSDETreeNodeBase.getRemovePSDEOPPrivName() != null)) {
            iDataObject.set(FIELD_REMOVEPSDEOPPRIVNAME, (Object)pSDETreeNodeBase.getRemovePSDEOPPrivName());
        }
        if (pSDETreeNodeBase.isRootNodeDirty() && (bl || pSDETreeNodeBase.getRootNode() != null)) {
            iDataObject.set(FIELD_ROOTNODE, (Object)pSDETreeNodeBase.getRootNode());
        }
        if (pSDETreeNodeBase.isSelectedDirty() && (bl || pSDETreeNodeBase.getSelected() != null)) {
            iDataObject.set(FIELD_SELECTED, (Object)pSDETreeNodeBase.getSelected());
        }
        if (pSDETreeNodeBase.isShapeClsPSDEFIdDirty() && (bl || pSDETreeNodeBase.getShapeClsPSDEFId() != null)) {
            iDataObject.set(FIELD_SHAPECLSPSDEFID, (Object)pSDETreeNodeBase.getShapeClsPSDEFId());
        }
        if (pSDETreeNodeBase.isShapeClsPSDEFNameDirty() && (bl || pSDETreeNodeBase.getShapeClsPSDEFName() != null)) {
            iDataObject.set(FIELD_SHAPECLSPSDEFNAME, (Object)pSDETreeNodeBase.getShapeClsPSDEFName());
        }
        if (pSDETreeNodeBase.isShapeDynaClassDirty() && (bl || pSDETreeNodeBase.getShapeDynaClass() != null)) {
            iDataObject.set(FIELD_SHAPEDYNACLASS, (Object)pSDETreeNodeBase.getShapeDynaClass());
        }
        if (pSDETreeNodeBase.isShapePSSysCssIdDirty() && (bl || pSDETreeNodeBase.getShapePSSysCssId() != null)) {
            iDataObject.set(FIELD_SHAPEPSSYSCSSID, (Object)pSDETreeNodeBase.getShapePSSysCssId());
        }
        if (pSDETreeNodeBase.isShapePSSysCssNameDirty() && (bl || pSDETreeNodeBase.getShapePSSysCssName() != null)) {
            iDataObject.set(FIELD_SHAPEPSSYSCSSNAME, (Object)pSDETreeNodeBase.getShapePSSysCssName());
        }
        if (pSDETreeNodeBase.isSortDirDirty() && (bl || pSDETreeNodeBase.getSortDir() != null)) {
            iDataObject.set(FIELD_SORTDIR, (Object)pSDETreeNodeBase.getSortDir());
        }
        if (pSDETreeNodeBase.isSortPSDEFIdDirty() && (bl || pSDETreeNodeBase.getSortPSDEFId() != null)) {
            iDataObject.set(FIELD_SORTPSDEFID, (Object)pSDETreeNodeBase.getSortPSDEFId());
        }
        if (pSDETreeNodeBase.isSortPSDEFNameDirty() && (bl || pSDETreeNodeBase.getSortPSDEFName() != null)) {
            iDataObject.set(FIELD_SORTPSDEFNAME, (Object)pSDETreeNodeBase.getSortPSDEFName());
        }
        if (pSDETreeNodeBase.isTextPSDEFIdDirty() && (bl || pSDETreeNodeBase.getTextPSDEFId() != null)) {
            iDataObject.set(FIELD_TEXTPSDEFID, (Object)pSDETreeNodeBase.getTextPSDEFId());
        }
        if (pSDETreeNodeBase.isTextPSDEFNameDirty() && (bl || pSDETreeNodeBase.getTextPSDEFName() != null)) {
            iDataObject.set(FIELD_TEXTPSDEFNAME, (Object)pSDETreeNodeBase.getTextPSDEFName());
        }
        if (pSDETreeNodeBase.isTipPSLanResIdDirty() && (bl || pSDETreeNodeBase.getTipPSLanResId() != null)) {
            iDataObject.set(FIELD_TIPPSLANRESID, (Object)pSDETreeNodeBase.getTipPSLanResId());
        }
        if (pSDETreeNodeBase.isTipPSLanResNameDirty() && (bl || pSDETreeNodeBase.getTipPSLanResName() != null)) {
            iDataObject.set(FIELD_TIPPSLANRESNAME, (Object)pSDETreeNodeBase.getTipPSLanResName());
        }
        if (pSDETreeNodeBase.isTipsPSDEFIdDirty() && (bl || pSDETreeNodeBase.getTipsPSDEFId() != null)) {
            iDataObject.set(FIELD_TIPSPSDEFID, (Object)pSDETreeNodeBase.getTipsPSDEFId());
        }
        if (pSDETreeNodeBase.isTipsPSDEFNameDirty() && (bl || pSDETreeNodeBase.getTipsPSDEFName() != null)) {
            iDataObject.set(FIELD_TIPSPSDEFNAME, (Object)pSDETreeNodeBase.getTipsPSDEFName());
        }
        if (pSDETreeNodeBase.isTooltipInfoDirty() && (bl || pSDETreeNodeBase.getTooltipInfo() != null)) {
            iDataObject.set(FIELD_TOOLTIPINFO, (Object)pSDETreeNodeBase.getTooltipInfo());
        }
        if (pSDETreeNodeBase.isTreeNodeTypeDirty() && (bl || pSDETreeNodeBase.getTreeNodeType() != null)) {
            iDataObject.set(FIELD_TREENODETYPE, (Object)pSDETreeNodeBase.getTreeNodeType());
        }
        if (pSDETreeNodeBase.isUpdateDateDirty() && (bl || pSDETreeNodeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDETreeNodeBase.getUpdateDate());
        }
        if (pSDETreeNodeBase.isUpdateManDirty() && (bl || pSDETreeNodeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDETreeNodeBase.getUpdateMan());
        }
        if (pSDETreeNodeBase.isUpdatePSDEActionIdDirty() && (bl || pSDETreeNodeBase.getUpdatePSDEActionId() != null)) {
            iDataObject.set(FIELD_UPDATEPSDEACTIONID, (Object)pSDETreeNodeBase.getUpdatePSDEActionId());
        }
        if (pSDETreeNodeBase.isUpdatePSDEActionNameDirty() && (bl || pSDETreeNodeBase.getUpdatePSDEActionName() != null)) {
            iDataObject.set(FIELD_UPDATEPSDEACTIONNAME, (Object)pSDETreeNodeBase.getUpdatePSDEActionName());
        }
        if (pSDETreeNodeBase.isUpdatePSDEOPPrivIdDirty() && (bl || pSDETreeNodeBase.getUpdatePSDEOPPrivId() != null)) {
            iDataObject.set(FIELD_UPDATEPSDEOPPRIVID, (Object)pSDETreeNodeBase.getUpdatePSDEOPPrivId());
        }
        if (pSDETreeNodeBase.isUpdatePSDEOPPrivNameDirty() && (bl || pSDETreeNodeBase.getUpdatePSDEOPPrivName() != null)) {
            iDataObject.set(FIELD_UPDATEPSDEOPPRIVNAME, (Object)pSDETreeNodeBase.getUpdatePSDEOPPrivName());
        }
        if (pSDETreeNodeBase.isUserCatDirty() && (bl || pSDETreeNodeBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDETreeNodeBase.getUserCat());
        }
        if (pSDETreeNodeBase.isUserTagDirty() && (bl || pSDETreeNodeBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDETreeNodeBase.getUserTag());
        }
        if (pSDETreeNodeBase.isUserTag2Dirty() && (bl || pSDETreeNodeBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDETreeNodeBase.getUserTag2());
        }
        if (pSDETreeNodeBase.isUserTag3Dirty() && (bl || pSDETreeNodeBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDETreeNodeBase.getUserTag3());
        }
        if (pSDETreeNodeBase.isUserTag4Dirty() && (bl || pSDETreeNodeBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDETreeNodeBase.getUserTag4());
        }
        if (pSDETreeNodeBase.isViewActionsDirty() && (bl || pSDETreeNodeBase.getViewActions() != null)) {
            iDataObject.set(FIELD_VIEWACTIONS, (Object)pSDETreeNodeBase.getViewActions());
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
        return PSDETreeNodeBase.remove(this, n);
    }

    private static boolean remove(PSDETreeNodeBase pSDETreeNodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDETreeNodeBase.resetActionParam();
                return true;
            }
            case 1: {
                pSDETreeNodeBase.resetAppendCapFlag();
                return true;
            }
            case 2: {
                pSDETreeNodeBase.resetAppendPNodeId();
                return true;
            }
            case 3: {
                pSDETreeNodeBase.resetCaption();
                return true;
            }
            case 4: {
                pSDETreeNodeBase.resetChecked();
                return true;
            }
            case 5: {
                pSDETreeNodeBase.resetChildCntPSDEFId();
                return true;
            }
            case 6: {
                pSDETreeNodeBase.resetChildCntPSDEFName();
                return true;
            }
            case 7: {
                pSDETreeNodeBase.resetClsPSDEFId();
                return true;
            }
            case 8: {
                pSDETreeNodeBase.resetClsPSDEFName();
                return true;
            }
            case 9: {
                pSDETreeNodeBase.resetCMRefresh();
                return true;
            }
            case 10: {
                pSDETreeNodeBase.resetCMRemove();
                return true;
            }
            case 11: {
                pSDETreeNodeBase.resetCounterId();
                return true;
            }
            case 12: {
                pSDETreeNodeBase.resetCounterMode();
                return true;
            }
            case 13: {
                pSDETreeNodeBase.resetCreateDate();
                return true;
            }
            case 14: {
                pSDETreeNodeBase.resetCreateMan();
                return true;
            }
            case 15: {
                pSDETreeNodeBase.resetCustomCode();
                return true;
            }
            case 16: {
                pSDETreeNodeBase.resetCustomCond();
                return true;
            }
            case 17: {
                pSDETreeNodeBase.resetCustomType();
                return true;
            }
            case 18: {
                pSDETreeNodeBase.resetData2PSDEFId();
                return true;
            }
            case 19: {
                pSDETreeNodeBase.resetData2PSDEFName();
                return true;
            }
            case 20: {
                pSDETreeNodeBase.resetDataPSDEFId();
                return true;
            }
            case 21: {
                pSDETreeNodeBase.resetDataPSDEFName();
                return true;
            }
            case 22: {
                pSDETreeNodeBase.resetDataSource();
                return true;
            }
            case 23: {
                pSDETreeNodeBase.resetDataTypePSDEFId();
                return true;
            }
            case 24: {
                pSDETreeNodeBase.resetDataTypePSDEFName();
                return true;
            }
            case 25: {
                pSDETreeNodeBase.resetDisableSelect();
                return true;
            }
            case 26: {
                pSDETreeNodeBase.resetDistinctMode();
                return true;
            }
            case 27: {
                pSDETreeNodeBase.resetDynaClass();
                return true;
            }
            case 28: {
                pSDETreeNodeBase.resetEditDataMode();
                return true;
            }
            case 29: {
                pSDETreeNodeBase.resetEditMode();
                return true;
            }
            case 30: {
                pSDETreeNodeBase.resetEnableCheck();
                return true;
            }
            case 31: {
                pSDETreeNodeBase.resetEnablePaging();
                return true;
            }
            case 32: {
                pSDETreeNodeBase.resetEnableQuickSearch();
                return true;
            }
            case 33: {
                pSDETreeNodeBase.resetEnableUP();
                return true;
            }
            case 34: {
                pSDETreeNodeBase.resetEnableViewActions();
                return true;
            }
            case 35: {
                pSDETreeNodeBase.resetExpand();
                return true;
            }
            case 36: {
                pSDETreeNodeBase.resetFieldName();
                return true;
            }
            case 37: {
                pSDETreeNodeBase.resetFilterPSDEDSId();
                return true;
            }
            case 38: {
                pSDETreeNodeBase.resetFilterPSDEDSName();
                return true;
            }
            case 39: {
                pSDETreeNodeBase.resetIconPSDEFId();
                return true;
            }
            case 40: {
                pSDETreeNodeBase.resetIconPSDEFName();
                return true;
            }
            case 41: {
                pSDETreeNodeBase.resetKeyPSDEFId();
                return true;
            }
            case 42: {
                pSDETreeNodeBase.resetKeyPSDEFName();
                return true;
            }
            case 43: {
                pSDETreeNodeBase.resetLeafFlagPSDEFId();
                return true;
            }
            case 44: {
                pSDETreeNodeBase.resetLeafFlagPSDEFName();
                return true;
            }
            case 45: {
                pSDETreeNodeBase.resetLinkPSDEFId();
                return true;
            }
            case 46: {
                pSDETreeNodeBase.resetLinkPSDEFName();
                return true;
            }
            case 47: {
                pSDETreeNodeBase.resetMaxSize();
                return true;
            }
            case 48: {
                pSDETreeNodeBase.resetMemo();
                return true;
            }
            case 49: {
                pSDETreeNodeBase.resetModelObj();
                return true;
            }
            case 50: {
                pSDETreeNodeBase.resetMovePSDEActionId();
                return true;
            }
            case 51: {
                pSDETreeNodeBase.resetMovePSDEActionName();
                return true;
            }
            case 52: {
                pSDETreeNodeBase.resetMovePSDEOPPrivId();
                return true;
            }
            case 53: {
                pSDETreeNodeBase.resetMovePSDEOPPrivName();
                return true;
            }
            case 54: {
                pSDETreeNodeBase.resetNamePSLanResId();
                return true;
            }
            case 55: {
                pSDETreeNodeBase.resetNamePSLanResName();
                return true;
            }
            case 56: {
                pSDETreeNodeBase.resetNavViewFilter();
                return true;
            }
            case 57: {
                pSDETreeNodeBase.resetNavViewFilterDesc();
                return true;
            }
            case 58: {
                pSDETreeNodeBase.resetNavViewParam();
                return true;
            }
            case 59: {
                pSDETreeNodeBase.resetNewDataMode();
                return true;
            }
            case 60: {
                pSDETreeNodeBase.resetNo2PSDEUAGroupId();
                return true;
            }
            case 61: {
                pSDETreeNodeBase.resetNo2PSDEUAGroupName();
                return true;
            }
            case 62: {
                pSDETreeNodeBase.resetNodeAction();
                return true;
            }
            case 63: {
                pSDETreeNodeBase.resetNodeDataType();
                return true;
            }
            case 64: {
                pSDETreeNodeBase.resetNodeId2PSDEFId();
                return true;
            }
            case 65: {
                pSDETreeNodeBase.resetNodeId2PSDEFName();
                return true;
            }
            case 66: {
                pSDETreeNodeBase.resetNodeId3PSDEFId();
                return true;
            }
            case 67: {
                pSDETreeNodeBase.resetNodeId3PSDEFName();
                return true;
            }
            case 68: {
                pSDETreeNodeBase.resetNodeId4PSDEFId();
                return true;
            }
            case 69: {
                pSDETreeNodeBase.resetNodeId4PSDEFName();
                return true;
            }
            case 70: {
                pSDETreeNodeBase.resetNodeIdPSDEFId();
                return true;
            }
            case 71: {
                pSDETreeNodeBase.resetNodeIdPSDEFName();
                return true;
            }
            case 72: {
                pSDETreeNodeBase.resetNodeType();
                return true;
            }
            case 73: {
                pSDETreeNodeBase.resetNodeValue();
                return true;
            }
            case 74: {
                pSDETreeNodeBase.resetPageSize();
                return true;
            }
            case 75: {
                pSDETreeNodeBase.resetPreventXSS();
                return true;
            }
            case 76: {
                pSDETreeNodeBase.resetPSCodeListId();
                return true;
            }
            case 77: {
                pSDETreeNodeBase.resetPSCodeListName();
                return true;
            }
            case 78: {
                pSDETreeNodeBase.resetPSDEActionId();
                return true;
            }
            case 79: {
                pSDETreeNodeBase.resetPSDEActionName();
                return true;
            }
            case 80: {
                pSDETreeNodeBase.resetPSDEDSId();
                return true;
            }
            case 81: {
                pSDETreeNodeBase.resetPSDEDSName();
                return true;
            }
            case 82: {
                pSDETreeNodeBase.resetPSDEGridId();
                return true;
            }
            case 83: {
                pSDETreeNodeBase.resetPSDEGridName();
                return true;
            }
            case 84: {
                pSDETreeNodeBase.resetPSDEId();
                return true;
            }
            case 85: {
                pSDETreeNodeBase.resetPSDELogicId();
                return true;
            }
            case 86: {
                pSDETreeNodeBase.resetPSDELogicName();
                return true;
            }
            case 87: {
                pSDETreeNodeBase.resetPSDEName();
                return true;
            }
            case 88: {
                pSDETreeNodeBase.resetPSDERId();
                return true;
            }
            case 89: {
                pSDETreeNodeBase.resetPSDERName();
                return true;
            }
            case 90: {
                pSDETreeNodeBase.resetPSDEToolbarId();
                return true;
            }
            case 91: {
                pSDETreeNodeBase.resetPSDEToolbarName();
                return true;
            }
            case 92: {
                pSDETreeNodeBase.resetPSDETreeNodeId();
                return true;
            }
            case 93: {
                pSDETreeNodeBase.resetPSDETreeNodeName();
                return true;
            }
            case 94: {
                pSDETreeNodeBase.resetPSDETreeViewId();
                return true;
            }
            case 95: {
                pSDETreeNodeBase.resetPSDETreeViewName();
                return true;
            }
            case 96: {
                pSDETreeNodeBase.resetPSDEUAGroupId();
                return true;
            }
            case 97: {
                pSDETreeNodeBase.resetPSDEUAGroupName();
                return true;
            }
            case 98: {
                pSDETreeNodeBase.resetPSDEViewBaseId();
                return true;
            }
            case 99: {
                pSDETreeNodeBase.resetPSDEViewBaseName();
                return true;
            }
            case 100: {
                pSDETreeNodeBase.resetPSSysCssId();
                return true;
            }
            case 101: {
                pSDETreeNodeBase.resetPSSysCssName();
                return true;
            }
            case 102: {
                pSDETreeNodeBase.resetPSSysImageId();
                return true;
            }
            case 103: {
                pSDETreeNodeBase.resetPSSysImageName();
                return true;
            }
            case 104: {
                pSDETreeNodeBase.resetPSSysPFPluginId();
                return true;
            }
            case 105: {
                pSDETreeNodeBase.resetPSSysPFPluginName();
                return true;
            }
            case 106: {
                pSDETreeNodeBase.resetPSSystemId();
                return true;
            }
            case 107: {
                pSDETreeNodeBase.resetPSSysUniResId();
                return true;
            }
            case 108: {
                pSDETreeNodeBase.resetPSSysUniResName();
                return true;
            }
            case 109: {
                pSDETreeNodeBase.resetPSSysViewPanelId();
                return true;
            }
            case 110: {
                pSDETreeNodeBase.resetPSSysViewPanelName();
                return true;
            }
            case 111: {
                pSDETreeNodeBase.resetRemovePSDEActionId();
                return true;
            }
            case 112: {
                pSDETreeNodeBase.resetRemovePSDEActionName();
                return true;
            }
            case 113: {
                pSDETreeNodeBase.resetRemovePSDEOPPrivId();
                return true;
            }
            case 114: {
                pSDETreeNodeBase.resetRemovePSDEOPPrivName();
                return true;
            }
            case 115: {
                pSDETreeNodeBase.resetRootNode();
                return true;
            }
            case 116: {
                pSDETreeNodeBase.resetSelected();
                return true;
            }
            case 117: {
                pSDETreeNodeBase.resetShapeClsPSDEFId();
                return true;
            }
            case 118: {
                pSDETreeNodeBase.resetShapeClsPSDEFName();
                return true;
            }
            case 119: {
                pSDETreeNodeBase.resetShapeDynaClass();
                return true;
            }
            case 120: {
                pSDETreeNodeBase.resetShapePSSysCssId();
                return true;
            }
            case 121: {
                pSDETreeNodeBase.resetShapePSSysCssName();
                return true;
            }
            case 122: {
                pSDETreeNodeBase.resetSortDir();
                return true;
            }
            case 123: {
                pSDETreeNodeBase.resetSortPSDEFId();
                return true;
            }
            case 124: {
                pSDETreeNodeBase.resetSortPSDEFName();
                return true;
            }
            case 125: {
                pSDETreeNodeBase.resetTextPSDEFId();
                return true;
            }
            case 126: {
                pSDETreeNodeBase.resetTextPSDEFName();
                return true;
            }
            case 127: {
                pSDETreeNodeBase.resetTipPSLanResId();
                return true;
            }
            case 128: {
                pSDETreeNodeBase.resetTipPSLanResName();
                return true;
            }
            case 129: {
                pSDETreeNodeBase.resetTipsPSDEFId();
                return true;
            }
            case 130: {
                pSDETreeNodeBase.resetTipsPSDEFName();
                return true;
            }
            case 131: {
                pSDETreeNodeBase.resetTooltipInfo();
                return true;
            }
            case 132: {
                pSDETreeNodeBase.resetTreeNodeType();
                return true;
            }
            case 133: {
                pSDETreeNodeBase.resetUpdateDate();
                return true;
            }
            case 134: {
                pSDETreeNodeBase.resetUpdateMan();
                return true;
            }
            case 135: {
                pSDETreeNodeBase.resetUpdatePSDEActionId();
                return true;
            }
            case 136: {
                pSDETreeNodeBase.resetUpdatePSDEActionName();
                return true;
            }
            case 137: {
                pSDETreeNodeBase.resetUpdatePSDEOPPrivId();
                return true;
            }
            case 138: {
                pSDETreeNodeBase.resetUpdatePSDEOPPrivName();
                return true;
            }
            case 139: {
                pSDETreeNodeBase.resetUserCat();
                return true;
            }
            case 140: {
                pSDETreeNodeBase.resetUserTag();
                return true;
            }
            case 141: {
                pSDETreeNodeBase.resetUserTag2();
                return true;
            }
            case 142: {
                pSDETreeNodeBase.resetUserTag3();
                return true;
            }
            case 143: {
                pSDETreeNodeBase.resetUserTag4();
                return true;
            }
            case 144: {
                pSDETreeNodeBase.resetViewActions();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCodeList getPSCodeList() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeList();
        }
        if (this.getPSCodeListId() == null) {
            return null;
        }
        Integer n = this.objPSCodeListLock;
        synchronized (n) {
            if (this.pscodelist != null && DataTypeHelper.compare((int)25, (Object)this.getPSCodeListId(), (Object)this.pscodelist.getPSCodeListId()) != 0L) {
                this.pscodelist = null;
            }
            if (this.pscodelist == null) {
                PSCodeList pSCodeList = new PSCodeList();
                pSCodeList.setPSCodeListId(this.getPSCodeListId());
                PSCodeListService pSCodeListService = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
                pSCodeListService.autoGet(pSCodeList);
                this.pscodelist = pSCodeList;
            }
            return this.pscodelist;
        }
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
    public PSDEAction getPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEAction();
        }
        if (this.getPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objPSDEActionLock;
        synchronized (n) {
            if (this.psdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEActionId(), (Object)this.psdeaction.getPSDEActionId()) != 0L) {
                this.psdeaction = null;
            }
            if (this.psdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet(pSDEAction);
                this.psdeaction = pSDEAction;
            }
            return this.psdeaction;
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
    public PSDEDataSet getFilterPSDEDS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFilterPSDEDS();
        }
        if (this.getFilterPSDEDSId() == null) {
            return null;
        }
        Integer n = this.objFilterPSDEDSLock;
        synchronized (n) {
            if (this.filterpsdeds != null && DataTypeHelper.compare((int)25, (Object)this.getFilterPSDEDSId(), (Object)this.filterpsdeds.getPSDEDataSetId()) != 0L) {
                this.filterpsdeds = null;
            }
            if (this.filterpsdeds == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getFilterPSDEDSId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet(pSDEDataSet);
                this.filterpsdeds = pSDEDataSet;
            }
            return this.filterpsdeds;
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
    public PSDEField getChildCntPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getChildCntPSDEF();
        }
        if (this.getChildCntPSDEFId() == null) {
            return null;
        }
        Integer n = this.objChildCntPSDEFLock;
        synchronized (n) {
            if (this.childcntpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getChildCntPSDEFId(), (Object)this.childcntpsdef.getPSDEFieldId()) != 0L) {
                this.childcntpsdef = null;
            }
            if (this.childcntpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getChildCntPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.childcntpsdef = pSDEField;
            }
            return this.childcntpsdef;
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
    public PSDEField getDataTypePSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataTypePSDEF();
        }
        if (this.getDataTypePSDEFId() == null) {
            return null;
        }
        Integer n = this.objDataTypePSDEFLock;
        synchronized (n) {
            if (this.datatypepsdef != null && DataTypeHelper.compare((int)25, (Object)this.getDataTypePSDEFId(), (Object)this.datatypepsdef.getPSDEFieldId()) != 0L) {
                this.datatypepsdef = null;
            }
            if (this.datatypepsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getDataTypePSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.datatypepsdef = pSDEField;
            }
            return this.datatypepsdef;
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
    public PSDEField getLeafFlagPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLeafFlagPSDEF();
        }
        if (this.getLeafFlagPSDEFId() == null) {
            return null;
        }
        Integer n = this.objLeafFlagPSDEFLock;
        synchronized (n) {
            if (this.leafflagpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getLeafFlagPSDEFId(), (Object)this.leafflagpsdef.getPSDEFieldId()) != 0L) {
                this.leafflagpsdef = null;
            }
            if (this.leafflagpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getLeafFlagPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.leafflagpsdef = pSDEField;
            }
            return this.leafflagpsdef;
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
    public PSDEField getNodeId2PSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNodeId2PSDEF();
        }
        if (this.getNodeId2PSDEFId() == null) {
            return null;
        }
        Integer n = this.objNodeId2PSDEFLock;
        synchronized (n) {
            if (this.nodeid2psdef != null && DataTypeHelper.compare((int)25, (Object)this.getNodeId2PSDEFId(), (Object)this.nodeid2psdef.getPSDEFieldId()) != 0L) {
                this.nodeid2psdef = null;
            }
            if (this.nodeid2psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getNodeId2PSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.nodeid2psdef = pSDEField;
            }
            return this.nodeid2psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getNodeId3PSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNodeId3PSDEF();
        }
        if (this.getNodeId3PSDEFId() == null) {
            return null;
        }
        Integer n = this.objNodeId3PSDEFLock;
        synchronized (n) {
            if (this.nodeid3psdef != null && DataTypeHelper.compare((int)25, (Object)this.getNodeId3PSDEFId(), (Object)this.nodeid3psdef.getPSDEFieldId()) != 0L) {
                this.nodeid3psdef = null;
            }
            if (this.nodeid3psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getNodeId3PSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.nodeid3psdef = pSDEField;
            }
            return this.nodeid3psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getNodeId4PSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNodeId4PSDEF();
        }
        if (this.getNodeId4PSDEFId() == null) {
            return null;
        }
        Integer n = this.objNodeId4PSDEFLock;
        synchronized (n) {
            if (this.nodeid4psdef != null && DataTypeHelper.compare((int)25, (Object)this.getNodeId4PSDEFId(), (Object)this.nodeid4psdef.getPSDEFieldId()) != 0L) {
                this.nodeid4psdef = null;
            }
            if (this.nodeid4psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getNodeId4PSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.nodeid4psdef = pSDEField;
            }
            return this.nodeid4psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getNodeIdPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNodeIdPSDEF();
        }
        if (this.getNodeIdPSDEFId() == null) {
            return null;
        }
        Integer n = this.objNodeIdPSDEFLock;
        synchronized (n) {
            if (this.nodeidpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getNodeIdPSDEFId(), (Object)this.nodeidpsdef.getPSDEFieldId()) != 0L) {
                this.nodeidpsdef = null;
            }
            if (this.nodeidpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getNodeIdPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.nodeidpsdef = pSDEField;
            }
            return this.nodeidpsdef;
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
                pSDEFieldService.autoGet(pSDEField);
                this.shapeclspsdef = pSDEField;
            }
            return this.shapeclspsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getSortPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSortPSDEF();
        }
        if (this.getSortPSDEFId() == null) {
            return null;
        }
        Integer n = this.objSortPSDEFLock;
        synchronized (n) {
            if (this.sortpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getSortPSDEFId(), (Object)this.sortpsdef.getPSDEFieldId()) != 0L) {
                this.sortpsdef = null;
            }
            if (this.sortpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getSortPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.sortpsdef = pSDEField;
            }
            return this.sortpsdef;
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
    public PSDEGrid getPSDEGrid() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGrid();
        }
        if (this.getPSDEGridId() == null) {
            return null;
        }
        Integer n = this.objPSDEGridLock;
        synchronized (n) {
            if (this.psdegrid != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEGridId(), (Object)this.psdegrid.getPSDEGridId()) != 0L) {
                this.psdegrid = null;
            }
            if (this.psdegrid == null) {
                PSDEGrid pSDEGrid = new PSDEGrid();
                pSDEGrid.setPSDEGridId(this.getPSDEGridId());
                PSDEGridService pSDEGridService = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
                pSDEGridService.autoGet(pSDEGrid);
                this.psdegrid = pSDEGrid;
            }
            return this.psdegrid;
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
    public PSDETreeView getPSDETreeView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeView();
        }
        if (this.getPSDETreeViewId() == null) {
            return null;
        }
        Integer n = this.objPSDETreeViewLock;
        synchronized (n) {
            if (this.psdetreeview != null && DataTypeHelper.compare((int)25, (Object)this.getPSDETreeViewId(), (Object)this.psdetreeview.getPSDETreeViewId()) != 0L) {
                this.psdetreeview = null;
            }
            if (this.psdetreeview == null) {
                PSDETreeView pSDETreeView = new PSDETreeView();
                pSDETreeView.setPSDETreeViewId(this.getPSDETreeViewId());
                PSDETreeViewService pSDETreeViewService = (PSDETreeViewService)ServiceGlobal.getService(PSDETreeViewService.class, (SessionFactory)this.getSessionFactory());
                pSDETreeViewService.autoGet(pSDETreeView);
                this.psdetreeview = pSDETreeView;
            }
            return this.psdetreeview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEUAGroup getNo2PSDEUAGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2PSDEUAGroup();
        }
        if (this.getNo2PSDEUAGroupId() == null) {
            return null;
        }
        Integer n = this.objNo2PSDEUAGroupLock;
        synchronized (n) {
            if (this.no2psdeuagroup != null && DataTypeHelper.compare((int)25, (Object)this.getNo2PSDEUAGroupId(), (Object)this.no2psdeuagroup.getPSDEUAGroupId()) != 0L) {
                this.no2psdeuagroup = null;
            }
            if (this.no2psdeuagroup == null) {
                PSDEUAGroup pSDEUAGroup = new PSDEUAGroup();
                pSDEUAGroup.setPSDEUAGroupId(this.getNo2PSDEUAGroupId());
                PSDEUAGroupService pSDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEUAGroupService.autoGet(pSDEUAGroup);
                this.no2psdeuagroup = pSDEUAGroup;
            }
            return this.no2psdeuagroup;
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
                pSDEUAGroupService.autoGet(pSDEUAGroup);
                this.psdeuagroup = pSDEUAGroup;
            }
            return this.psdeuagroup;
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
                pSSysCssService.autoGet(pSSysCss);
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
    public ArrayList<PSDETEIUpdate> getPSDETEIUpdates() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETEIUpdates();
        }
        if (this.getPSDETreeNodeId() == null) {
            return null;
        }
        PSDETEIUpdateService pSDETEIUpdateService = (PSDETEIUpdateService)ServiceGlobal.getService(PSDETEIUpdateService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDETEIUpdatesLock;
        synchronized (n) {
            if (this.psdeteiupdates == null) {
                this.psdeteiupdates = pSDETEIUpdateService.selectByPSDETreeNode(this);
            }
            return this.psdeteiupdates;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDETreeNodeCol> getPSDETreeNodeCols() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeNodeCols();
        }
        if (this.getPSDETreeNodeId() == null) {
            return null;
        }
        PSDETreeNodeColService pSDETreeNodeColService = (PSDETreeNodeColService)ServiceGlobal.getService(PSDETreeNodeColService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDETreeNodeColsLock;
        synchronized (n) {
            if (this.psdetreenodecols == null) {
                this.psdetreenodecols = pSDETreeNodeColService.selectByPSDETreeNode(this);
            }
            return this.psdetreenodecols;
        }
    }

    private PSDETreeNodeBase getProxyEntity() {
        return this.proxyPSDETreeNodeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDETreeNodeBase = null;
        if (iDataObject != null && iDataObject instanceof PSDETreeNodeBase) {
            this.proxyPSDETreeNodeBase = (PSDETreeNodeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACTIONPARAM, 0);
        fieldIndexMap.put(FIELD_APPENDCAPFLAG, 1);
        fieldIndexMap.put(FIELD_APPENDPNODEID, 2);
        fieldIndexMap.put(FIELD_CAPTION, 3);
        fieldIndexMap.put(FIELD_CHECKED, 4);
        fieldIndexMap.put(FIELD_CHILDCNTPSDEFID, 5);
        fieldIndexMap.put(FIELD_CHILDCNTPSDEFNAME, 6);
        fieldIndexMap.put(FIELD_CLSPSDEFID, 7);
        fieldIndexMap.put(FIELD_CLSPSDEFNAME, 8);
        fieldIndexMap.put(FIELD_CMREFRESH, 9);
        fieldIndexMap.put(FIELD_CMREMOVE, 10);
        fieldIndexMap.put(FIELD_COUNTERID, 11);
        fieldIndexMap.put(FIELD_COUNTERMODE, 12);
        fieldIndexMap.put(FIELD_CREATEDATE, 13);
        fieldIndexMap.put(FIELD_CREATEMAN, 14);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 15);
        fieldIndexMap.put(FIELD_CUSTOMCOND, 16);
        fieldIndexMap.put(FIELD_CUSTOMTYPE, 17);
        fieldIndexMap.put(FIELD_DATA2PSDEFID, 18);
        fieldIndexMap.put(FIELD_DATA2PSDEFNAME, 19);
        fieldIndexMap.put(FIELD_DATAPSDEFID, 20);
        fieldIndexMap.put(FIELD_DATAPSDEFNAME, 21);
        fieldIndexMap.put(FIELD_DATASOURCE, 22);
        fieldIndexMap.put(FIELD_DATATYPEPSDEFID, 23);
        fieldIndexMap.put(FIELD_DATATYPEPSDEFNAME, 24);
        fieldIndexMap.put(FIELD_DISABLESELECT, 25);
        fieldIndexMap.put(FIELD_DISTINCTMODE, 26);
        fieldIndexMap.put(FIELD_DYNACLASS, 27);
        fieldIndexMap.put(FIELD_EDITDATAMODE, 28);
        fieldIndexMap.put(FIELD_EDITMODE, 29);
        fieldIndexMap.put(FIELD_ENABLECHECK, 30);
        fieldIndexMap.put(FIELD_ENABLEPAGING, 31);
        fieldIndexMap.put(FIELD_ENABLEQUICKSEARCH, 32);
        fieldIndexMap.put(FIELD_ENABLEUP, 33);
        fieldIndexMap.put(FIELD_ENABLEVIEWACTIONS, 34);
        fieldIndexMap.put(FIELD_EXPAND, 35);
        fieldIndexMap.put(FIELD_FIELDNAME, 36);
        fieldIndexMap.put(FIELD_FILTERPSDEDSID, 37);
        fieldIndexMap.put(FIELD_FILTERPSDEDSNAME, 38);
        fieldIndexMap.put(FIELD_ICONPSDEFID, 39);
        fieldIndexMap.put(FIELD_ICONPSDEFNAME, 40);
        fieldIndexMap.put(FIELD_KEYPSDEFID, 41);
        fieldIndexMap.put(FIELD_KEYPSDEFNAME, 42);
        fieldIndexMap.put(FIELD_LEAFFLAGPSDEFID, 43);
        fieldIndexMap.put(FIELD_LEAFFLAGPSDEFNAME, 44);
        fieldIndexMap.put(FIELD_LINKPSDEFID, 45);
        fieldIndexMap.put(FIELD_LINKPSDEFNAME, 46);
        fieldIndexMap.put(FIELD_MAXSIZE, 47);
        fieldIndexMap.put(FIELD_MEMO, 48);
        fieldIndexMap.put(FIELD_MODELOBJ, 49);
        fieldIndexMap.put(FIELD_MOVEPSDEACTIONID, 50);
        fieldIndexMap.put(FIELD_MOVEPSDEACTIONNAME, 51);
        fieldIndexMap.put(FIELD_MOVEPSDEOPPRIVID, 52);
        fieldIndexMap.put(FIELD_MOVEPSDEOPPRIVNAME, 53);
        fieldIndexMap.put(FIELD_NAMEPSLANRESID, 54);
        fieldIndexMap.put(FIELD_NAMEPSLANRESNAME, 55);
        fieldIndexMap.put(FIELD_NAVVIEWFILTER, 56);
        fieldIndexMap.put(FIELD_NAVVIEWFILTERDESC, 57);
        fieldIndexMap.put(FIELD_NAVVIEWPARAM, 58);
        fieldIndexMap.put(FIELD_NEWDATAMODE, 59);
        fieldIndexMap.put(FIELD_NO2PSDEUAGROUPID, 60);
        fieldIndexMap.put(FIELD_NO2PSDEUAGROUPNAME, 61);
        fieldIndexMap.put(FIELD_NODEACTION, 62);
        fieldIndexMap.put(FIELD_NODEDATATYPE, 63);
        fieldIndexMap.put(FIELD_NODEID2PSDEFID, 64);
        fieldIndexMap.put(FIELD_NODEID2PSDEFNAME, 65);
        fieldIndexMap.put(FIELD_NODEID3PSDEFID, 66);
        fieldIndexMap.put(FIELD_NODEID3PSDEFNAME, 67);
        fieldIndexMap.put(FIELD_NODEID4PSDEFID, 68);
        fieldIndexMap.put(FIELD_NODEID4PSDEFNAME, 69);
        fieldIndexMap.put(FIELD_NODEIDPSDEFID, 70);
        fieldIndexMap.put(FIELD_NODEIDPSDEFNAME, 71);
        fieldIndexMap.put(FIELD_NODETYPE, 72);
        fieldIndexMap.put(FIELD_NODEVALUE, 73);
        fieldIndexMap.put(FIELD_PAGESIZE, 74);
        fieldIndexMap.put(FIELD_PREVENTXSS, 75);
        fieldIndexMap.put(FIELD_PSCODELISTID, 76);
        fieldIndexMap.put(FIELD_PSCODELISTNAME, 77);
        fieldIndexMap.put(FIELD_PSDEACTIONID, 78);
        fieldIndexMap.put(FIELD_PSDEACTIONNAME, 79);
        fieldIndexMap.put(FIELD_PSDEDSID, 80);
        fieldIndexMap.put(FIELD_PSDEDSNAME, 81);
        fieldIndexMap.put(FIELD_PSDEGRIDID, 82);
        fieldIndexMap.put(FIELD_PSDEGRIDNAME, 83);
        fieldIndexMap.put(FIELD_PSDEID, 84);
        fieldIndexMap.put(FIELD_PSDELOGICID, 85);
        fieldIndexMap.put(FIELD_PSDELOGICNAME, 86);
        fieldIndexMap.put(FIELD_PSDENAME, 87);
        fieldIndexMap.put(FIELD_PSDERID, 88);
        fieldIndexMap.put(FIELD_PSDERNAME, 89);
        fieldIndexMap.put(FIELD_PSDETOOLBARID, 90);
        fieldIndexMap.put(FIELD_PSDETOOLBARNAME, 91);
        fieldIndexMap.put(FIELD_PSDETREENODEID, 92);
        fieldIndexMap.put(FIELD_PSDETREENODENAME, 93);
        fieldIndexMap.put(FIELD_PSDETREEVIEWID, 94);
        fieldIndexMap.put(FIELD_PSDETREEVIEWNAME, 95);
        fieldIndexMap.put(FIELD_PSDEUAGROUPID, 96);
        fieldIndexMap.put(FIELD_PSDEUAGROUPNAME, 97);
        fieldIndexMap.put(FIELD_PSDEVIEWBASEID, 98);
        fieldIndexMap.put(FIELD_PSDEVIEWBASENAME, 99);
        fieldIndexMap.put(FIELD_PSSYSCSSID, 100);
        fieldIndexMap.put(FIELD_PSSYSCSSNAME, 101);
        fieldIndexMap.put(FIELD_PSSYSIMAGEID, 102);
        fieldIndexMap.put(FIELD_PSSYSIMAGENAME, 103);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 104);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 105);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 106);
        fieldIndexMap.put(FIELD_PSSYSUNIRESID, 107);
        fieldIndexMap.put(FIELD_PSSYSUNIRESNAME, 108);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELID, 109);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELNAME, 110);
        fieldIndexMap.put(FIELD_REMOVEPSDEACTIONID, 111);
        fieldIndexMap.put(FIELD_REMOVEPSDEACTIONNAME, 112);
        fieldIndexMap.put(FIELD_REMOVEPSDEOPPRIVID, 113);
        fieldIndexMap.put(FIELD_REMOVEPSDEOPPRIVNAME, 114);
        fieldIndexMap.put(FIELD_ROOTNODE, 115);
        fieldIndexMap.put(FIELD_SELECTED, 116);
        fieldIndexMap.put(FIELD_SHAPECLSPSDEFID, 117);
        fieldIndexMap.put(FIELD_SHAPECLSPSDEFNAME, 118);
        fieldIndexMap.put(FIELD_SHAPEDYNACLASS, 119);
        fieldIndexMap.put(FIELD_SHAPEPSSYSCSSID, 120);
        fieldIndexMap.put(FIELD_SHAPEPSSYSCSSNAME, 121);
        fieldIndexMap.put(FIELD_SORTDIR, 122);
        fieldIndexMap.put(FIELD_SORTPSDEFID, 123);
        fieldIndexMap.put(FIELD_SORTPSDEFNAME, 124);
        fieldIndexMap.put(FIELD_TEXTPSDEFID, 125);
        fieldIndexMap.put(FIELD_TEXTPSDEFNAME, 126);
        fieldIndexMap.put(FIELD_TIPPSLANRESID, 127);
        fieldIndexMap.put(FIELD_TIPPSLANRESNAME, 128);
        fieldIndexMap.put(FIELD_TIPSPSDEFID, 129);
        fieldIndexMap.put(FIELD_TIPSPSDEFNAME, 130);
        fieldIndexMap.put(FIELD_TOOLTIPINFO, 131);
        fieldIndexMap.put(FIELD_TREENODETYPE, 132);
        fieldIndexMap.put(FIELD_UPDATEDATE, 133);
        fieldIndexMap.put(FIELD_UPDATEMAN, 134);
        fieldIndexMap.put(FIELD_UPDATEPSDEACTIONID, 135);
        fieldIndexMap.put(FIELD_UPDATEPSDEACTIONNAME, 136);
        fieldIndexMap.put(FIELD_UPDATEPSDEOPPRIVID, 137);
        fieldIndexMap.put(FIELD_UPDATEPSDEOPPRIVNAME, 138);
        fieldIndexMap.put(FIELD_USERCAT, 139);
        fieldIndexMap.put(FIELD_USERTAG, 140);
        fieldIndexMap.put(FIELD_USERTAG2, 141);
        fieldIndexMap.put(FIELD_USERTAG3, 142);
        fieldIndexMap.put(FIELD_USERTAG4, 143);
        fieldIndexMap.put(FIELD_VIEWACTIONS, 144);
    }
}

