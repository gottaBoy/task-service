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
import net.ibizsys.pscore.srv.config.entity.PSSysResource;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.config.service.PSSysResourceService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFSFItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFSFItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounter;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysEditorStyle;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSearchBar;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysEditorStyleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysSearchBarItemBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysSearchBarItemBase.class);
    public static final String FIELD_ADDSEPARATOR = "ADDSEPARATOR";
    public static final String FIELD_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String FIELD_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String FIELD_CAPTION = "CAPTION";
    public static final String FIELD_CONTENTTYPE = "CONTENTTYPE";
    public static final String FIELD_COUNTERID = "COUNTERID";
    public static final String FIELD_COUNTERMODE = "COUNTERMODE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CTRLDYNACLASS = "CTRLDYNACLASS";
    public static final String FIELD_CTRLHEIGHT = "CTRLHEIGHT";
    public static final String FIELD_CTRLPSSYSCSSID = "CTRLPSSYSCSSID";
    public static final String FIELD_CTRLPSSYSCSSNAME = "CTRLPSSYSCSSNAME";
    public static final String FIELD_CTRLRAWCSSSTYLE = "CTRLRAWCSSSTYLE";
    public static final String FIELD_CTRLWIDTH = "CTRLWIDTH";
    public static final String FIELD_DATA = "DATA";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_DYNACLASS = "DYNACLASS";
    public static final String FIELD_EDITORPARAMS = "EDITORPARAMS";
    public static final String FIELD_EDITORTYPE = "EDITORTYPE";
    public static final String FIELD_EDITORTYPENAME = "EDITORTYPENAME";
    public static final String FIELD_FILTERPSDEDSID = "FILTERPSDEDSID";
    public static final String FIELD_FILTERPSDEDSNAME = "FILTERPSDEDSNAME";
    public static final String FIELD_HEIGHT = "HEIGHT";
    public static final String FIELD_HTMLCONTENT = "HTMLCONTENT";
    public static final String FIELD_ITEMSUBTYPE = "ITEMSUBTYPE";
    public static final String FIELD_ITEMTAG = "ITEMTAG";
    public static final String FIELD_ITEMTAG2 = "ITEMTAG2";
    public static final String FIELD_ITEMTYPE = "ITEMTYPE";
    public static final String FIELD_LABELDYNACLASS = "LABELDYNACLASS";
    public static final String FIELD_LABELPOS = "LABELPOS";
    public static final String FIELD_LABELPSSYSCSSID = "LABELPSSYSCSSID";
    public static final String FIELD_LABELPSSYSCSSNAME = "LABELPSSYSCSSNAME";
    public static final String FIELD_LABELRAWCSSSTYLE = "LABELRAWCSSSTYLE";
    public static final String FIELD_LABELWIDTH = "LABELWIDTH";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MOBFLAG = "MOBFLAG";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PHPSLANRESID = "PHPSLANRESID";
    public static final String FIELD_PHPSLANRESNAME = "PHPSLANRESNAME";
    public static final String FIELD_PLACEHOLDER = "PLACEHOLDER";
    public static final String FIELD_PSCODELISTID = "PSCODELISTID";
    public static final String FIELD_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String FIELD_PSDEFID = "PSDEFID";
    public static final String FIELD_PSDEFNAME = "PSDEFNAME";
    public static final String FIELD_PSDEFSFITEMID = "PSDEFSFITEMID";
    public static final String FIELD_PSDEFSFITEMNAME = "PSDEFSFITEMNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSSYSCOUNTERID = "PSSYSCOUNTERID";
    public static final String FIELD_PSSYSCOUNTERNAME = "PSSYSCOUNTERNAME";
    public static final String FIELD_PSSYSCSSID = "PSSYSCSSID";
    public static final String FIELD_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String FIELD_PSSYSEDITORSTYLEID = "PSSYSEDITORSTYLEID";
    public static final String FIELD_PSSYSEDITORSTYLENAME = "PSSYSEDITORSTYLENAME";
    public static final String FIELD_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String FIELD_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSRESOURCEID = "PSSYSRESOURCEID";
    public static final String FIELD_PSSYSRESOURCENAME = "PSSYSRESOURCENAME";
    public static final String FIELD_PSSYSSEARCHBARID = "PSSYSSEARCHBARID";
    public static final String FIELD_PSSYSSEARCHBARITEMID = "PSSYSSEARCHBARITEMID";
    public static final String FIELD_PSSYSSEARCHBARITEMNAME = "PSSYSSEARCHBARITEMNAME";
    public static final String FIELD_PSSYSSEARCHBARNAME = "PSSYSSEARCHBARNAME";
    public static final String FIELD_RAWCONTENT = "RAWCONTENT";
    public static final String FIELD_RAWCSSSTYLE = "RAWCSSSTYLE";
    public static final String FIELD_RAWSERVICEMETHOD = "RAWSERVICEMETHOD";
    public static final String FIELD_RAWSERVICEURL = "RAWSERVICEURL";
    public static final String FIELD_RESETITEMNAME = "RESETITEMNAME";
    public static final String FIELD_SHOWCAPTION = "SHOWCAPTION";
    public static final String FIELD_TEMPLATEMODE = "TEMPLATEMODE";
    public static final String FIELD_TIPPSLANRESID = "TIPPSLANRESID";
    public static final String FIELD_TIPPSLANRESNAME = "TIPPSLANRESNAME";
    public static final String FIELD_TOOLTIPINFO = "TOOLTIPINFO";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VALUEITEMNAME = "VALUEITEMNAME";
    public static final String FIELD_WIDTH = "WIDTH";
    private static final int INDEX_ADDSEPARATOR = 0;
    private static final int INDEX_CAPPSLANRESID = 1;
    private static final int INDEX_CAPPSLANRESNAME = 2;
    private static final int INDEX_CAPTION = 3;
    private static final int INDEX_CONTENTTYPE = 4;
    private static final int INDEX_COUNTERID = 5;
    private static final int INDEX_COUNTERMODE = 6;
    private static final int INDEX_CREATEDATE = 7;
    private static final int INDEX_CREATEMAN = 8;
    private static final int INDEX_CTRLDYNACLASS = 9;
    private static final int INDEX_CTRLHEIGHT = 10;
    private static final int INDEX_CTRLPSSYSCSSID = 11;
    private static final int INDEX_CTRLPSSYSCSSNAME = 12;
    private static final int INDEX_CTRLRAWCSSSTYLE = 13;
    private static final int INDEX_CTRLWIDTH = 14;
    private static final int INDEX_DATA = 15;
    private static final int INDEX_DEFAULTFLAG = 16;
    private static final int INDEX_DYNACLASS = 17;
    private static final int INDEX_EDITORPARAMS = 18;
    private static final int INDEX_EDITORTYPE = 19;
    private static final int INDEX_EDITORTYPENAME = 20;
    private static final int INDEX_FILTERPSDEDSID = 21;
    private static final int INDEX_FILTERPSDEDSNAME = 22;
    private static final int INDEX_HEIGHT = 23;
    private static final int INDEX_HTMLCONTENT = 24;
    private static final int INDEX_ITEMSUBTYPE = 25;
    private static final int INDEX_ITEMTAG = 26;
    private static final int INDEX_ITEMTAG2 = 27;
    private static final int INDEX_ITEMTYPE = 28;
    private static final int INDEX_LABELDYNACLASS = 29;
    private static final int INDEX_LABELPOS = 30;
    private static final int INDEX_LABELPSSYSCSSID = 31;
    private static final int INDEX_LABELPSSYSCSSNAME = 32;
    private static final int INDEX_LABELRAWCSSSTYLE = 33;
    private static final int INDEX_LABELWIDTH = 34;
    private static final int INDEX_MEMO = 35;
    private static final int INDEX_MOBFLAG = 36;
    private static final int INDEX_ORDERVALUE = 37;
    private static final int INDEX_PHPSLANRESID = 38;
    private static final int INDEX_PHPSLANRESNAME = 39;
    private static final int INDEX_PLACEHOLDER = 40;
    private static final int INDEX_PSCODELISTID = 41;
    private static final int INDEX_PSCODELISTNAME = 42;
    private static final int INDEX_PSDEFID = 43;
    private static final int INDEX_PSDEFNAME = 44;
    private static final int INDEX_PSDEFSFITEMID = 45;
    private static final int INDEX_PSDEFSFITEMNAME = 46;
    private static final int INDEX_PSDEID = 47;
    private static final int INDEX_PSSYSCOUNTERID = 48;
    private static final int INDEX_PSSYSCOUNTERNAME = 49;
    private static final int INDEX_PSSYSCSSID = 50;
    private static final int INDEX_PSSYSCSSNAME = 51;
    private static final int INDEX_PSSYSEDITORSTYLEID = 52;
    private static final int INDEX_PSSYSEDITORSTYLENAME = 53;
    private static final int INDEX_PSSYSIMAGEID = 54;
    private static final int INDEX_PSSYSIMAGENAME = 55;
    private static final int INDEX_PSSYSPFPLUGINID = 56;
    private static final int INDEX_PSSYSPFPLUGINNAME = 57;
    private static final int INDEX_PSSYSRESOURCEID = 58;
    private static final int INDEX_PSSYSRESOURCENAME = 59;
    private static final int INDEX_PSSYSSEARCHBARID = 60;
    private static final int INDEX_PSSYSSEARCHBARITEMID = 61;
    private static final int INDEX_PSSYSSEARCHBARITEMNAME = 62;
    private static final int INDEX_PSSYSSEARCHBARNAME = 63;
    private static final int INDEX_RAWCONTENT = 64;
    private static final int INDEX_RAWCSSSTYLE = 65;
    private static final int INDEX_RAWSERVICEMETHOD = 66;
    private static final int INDEX_RAWSERVICEURL = 67;
    private static final int INDEX_RESETITEMNAME = 68;
    private static final int INDEX_SHOWCAPTION = 69;
    private static final int INDEX_TEMPLATEMODE = 70;
    private static final int INDEX_TIPPSLANRESID = 71;
    private static final int INDEX_TIPPSLANRESNAME = 72;
    private static final int INDEX_TOOLTIPINFO = 73;
    private static final int INDEX_UPDATEDATE = 74;
    private static final int INDEX_UPDATEMAN = 75;
    private static final int INDEX_USERCAT = 76;
    private static final int INDEX_USERPARAMS = 77;
    private static final int INDEX_USERTAG = 78;
    private static final int INDEX_USERTAG2 = 79;
    private static final int INDEX_USERTAG3 = 80;
    private static final int INDEX_USERTAG4 = 81;
    private static final int INDEX_VALIDFLAG = 82;
    private static final int INDEX_VALUEITEMNAME = 83;
    private static final int INDEX_WIDTH = 84;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysSearchBarItemBase proxyPSSysSearchBarItemBase = null;
    private boolean addseparatorDirtyFlag = false;
    private boolean cappslanresidDirtyFlag = false;
    private boolean cappslanresnameDirtyFlag = false;
    private boolean captionDirtyFlag = false;
    private boolean contenttypeDirtyFlag = false;
    private boolean counteridDirtyFlag = false;
    private boolean countermodeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean ctrldynaclassDirtyFlag = false;
    private boolean ctrlheightDirtyFlag = false;
    private boolean ctrlpssyscssidDirtyFlag = false;
    private boolean ctrlpssyscssnameDirtyFlag = false;
    private boolean ctrlrawcssstyleDirtyFlag = false;
    private boolean ctrlwidthDirtyFlag = false;
    private boolean dataDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean dynaclassDirtyFlag = false;
    private boolean editorparamsDirtyFlag = false;
    private boolean editortypeDirtyFlag = false;
    private boolean editortypenameDirtyFlag = false;
    private boolean filterpsdedsidDirtyFlag = false;
    private boolean filterpsdedsnameDirtyFlag = false;
    private boolean heightDirtyFlag = false;
    private boolean htmlcontentDirtyFlag = false;
    private boolean itemsubtypeDirtyFlag = false;
    private boolean itemtagDirtyFlag = false;
    private boolean itemtag2DirtyFlag = false;
    private boolean itemtypeDirtyFlag = false;
    private boolean labeldynaclassDirtyFlag = false;
    private boolean labelposDirtyFlag = false;
    private boolean labelpssyscssidDirtyFlag = false;
    private boolean labelpssyscssnameDirtyFlag = false;
    private boolean labelrawcssstyleDirtyFlag = false;
    private boolean labelwidthDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean mobflagDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean phpslanresidDirtyFlag = false;
    private boolean phpslanresnameDirtyFlag = false;
    private boolean placeholderDirtyFlag = false;
    private boolean pscodelistidDirtyFlag = false;
    private boolean pscodelistnameDirtyFlag = false;
    private boolean psdefidDirtyFlag = false;
    private boolean psdefnameDirtyFlag = false;
    private boolean psdefsfitemidDirtyFlag = false;
    private boolean psdefsfitemnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean pssyscounteridDirtyFlag = false;
    private boolean pssyscounternameDirtyFlag = false;
    private boolean pssyscssidDirtyFlag = false;
    private boolean pssyscssnameDirtyFlag = false;
    private boolean pssyseditorstyleidDirtyFlag = false;
    private boolean pssyseditorstylenameDirtyFlag = false;
    private boolean pssysimageidDirtyFlag = false;
    private boolean pssysimagenameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssysresourceidDirtyFlag = false;
    private boolean pssysresourcenameDirtyFlag = false;
    private boolean pssyssearchbaridDirtyFlag = false;
    private boolean pssyssearchbaritemidDirtyFlag = false;
    private boolean pssyssearchbaritemnameDirtyFlag = false;
    private boolean pssyssearchbarnameDirtyFlag = false;
    private boolean rawcontentDirtyFlag = false;
    private boolean rawcssstyleDirtyFlag = false;
    private boolean rawservicemethodDirtyFlag = false;
    private boolean rawserviceurlDirtyFlag = false;
    private boolean resetitemnameDirtyFlag = false;
    private boolean showcaptionDirtyFlag = false;
    private boolean templatemodeDirtyFlag = false;
    private boolean tippslanresidDirtyFlag = false;
    private boolean tippslanresnameDirtyFlag = false;
    private boolean tooltipinfoDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean valueitemnameDirtyFlag = false;
    private boolean widthDirtyFlag = false;
    @Column(name="addseparator")
    private Integer addseparator;
    @Column(name="cappslanresid")
    private String cappslanresid;
    @Column(name="cappslanresname")
    private String cappslanresname;
    @Column(name="caption")
    private String caption;
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
    @Column(name="ctrldynaclass")
    private String ctrldynaclass;
    @Column(name="ctrlheight")
    private Integer ctrlheight;
    @Column(name="ctrlpssyscssid")
    private String ctrlpssyscssid;
    @Column(name="ctrlpssyscssname")
    private String ctrlpssyscssname;
    @Column(name="ctrlrawcssstyle")
    private String ctrlrawcssstyle;
    @Column(name="ctrlwidth")
    private Integer ctrlwidth;
    @Column(name="data")
    private String data;
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="dynaclass")
    private String dynaclass;
    @Column(name="editorparams")
    private String editorparams;
    @Column(name="editortype")
    private String editortype;
    @Column(name="editortypename")
    private String editortypename;
    @Column(name="filterpsdedsid")
    private String filterpsdedsid;
    @Column(name="filterpsdedsname")
    private String filterpsdedsname;
    @Column(name="height")
    private Integer height;
    @Column(name="htmlcontent")
    private String htmlcontent;
    @Column(name="itemsubtype")
    private String itemsubtype;
    @Column(name="itemtag")
    private String itemtag;
    @Column(name="itemtag2")
    private String itemtag2;
    @Column(name="itemtype")
    private String itemtype;
    @Column(name="labeldynaclass")
    private String labeldynaclass;
    @Column(name="labelpos")
    private String labelpos;
    @Column(name="labelpssyscssid")
    private String labelpssyscssid;
    @Column(name="labelpssyscssname")
    private String labelpssyscssname;
    @Column(name="labelrawcssstyle")
    private String labelrawcssstyle;
    @Column(name="labelwidth")
    private Integer labelwidth;
    @Column(name="memo")
    private String memo;
    @Column(name="mobflag")
    private Integer mobflag;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="phpslanresid")
    private String phpslanresid;
    @Column(name="phpslanresname")
    private String phpslanresname;
    @Column(name="placeholder")
    private String placeholder;
    @Column(name="pscodelistid")
    private String pscodelistid;
    @Column(name="pscodelistname")
    private String pscodelistname;
    @Column(name="psdefid")
    private String psdefid;
    @Column(name="psdefname")
    private String psdefname;
    @Column(name="psdefsfitemid")
    private String psdefsfitemid;
    @Column(name="psdefsfitemname")
    private String psdefsfitemname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="pssyscounterid")
    private String pssyscounterid;
    @Column(name="pssyscountername")
    private String pssyscountername;
    @Column(name="pssyscssid")
    private String pssyscssid;
    @Column(name="pssyscssname")
    private String pssyscssname;
    @Column(name="pssyseditorstyleid")
    private String pssyseditorstyleid;
    @Column(name="pssyseditorstylename")
    private String pssyseditorstylename;
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
    @Column(name="pssyssearchbarid")
    private String pssyssearchbarid;
    @Column(name="pssyssearchbaritemid")
    private String pssyssearchbaritemid;
    @Column(name="pssyssearchbaritemname")
    private String pssyssearchbaritemname;
    @Column(name="pssyssearchbarname")
    private String pssyssearchbarname;
    @Column(name="rawcontent")
    private String rawcontent;
    @Column(name="rawcssstyle")
    private String rawcssstyle;
    @Column(name="rawservicemethod")
    private String rawservicemethod;
    @Column(name="rawserviceurl")
    private String rawserviceurl;
    @Column(name="resetitemname")
    private String resetitemname;
    @Column(name="showcaption")
    private Integer showcaption;
    @Column(name="templatemode")
    private Integer templatemode;
    @Column(name="tippslanresid")
    private String tippslanresid;
    @Column(name="tippslanresname")
    private String tippslanresname;
    @Column(name="tooltipinfo")
    private String tooltipinfo;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="userparams")
    private String userparams;
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
    @Column(name="valueitemname")
    private String valueitemname;
    @Column(name="width")
    private Double width;
    private Integer objPSCodeListLock = new Integer(1);
    private PSCodeList pscodelist = null;
    private Integer objFilterPSDEDSLock = new Integer(1);
    private PSDEDataSet filterpsdeds = null;
    private Integer objPSDEFLock = new Integer(1);
    private PSDEField psdef = null;
    private Integer objPSDEFSFItemLock = new Integer(1);
    private PSDEFSFItem psdefsfitem = null;
    private Integer objCapPSLanResLock = new Integer(1);
    private PSLanguageRes cappslanres = null;
    private Integer objPHPSLanResLock = new Integer(1);
    private PSLanguageRes phpslanres = null;
    private Integer objTipPSLanResLock = new Integer(1);
    private PSLanguageRes tippslanres = null;
    private Integer objPSSysCounterLock = new Integer(1);
    private PSSysCounter pssyscounter = null;
    private Integer objCtrlPSSysCssLock = new Integer(1);
    private PSSysCss ctrlpssyscss = null;
    private Integer objLabelPSSysCssLock = new Integer(1);
    private PSSysCss labelpssyscss = null;
    private Integer objPSSysCssLock = new Integer(1);
    private PSSysCss pssyscss = null;
    private Integer objPSSysEditorStyleLock = new Integer(1);
    private PSSysEditorStyle pssyseditorstyle = null;
    private Integer objPSSysImageLock = new Integer(1);
    private PSSysImage pssysimage = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSSysResourceLock = new Integer(1);
    private PSSysResource pssysresource = null;
    private Integer objPSSysSearchBarLock = new Integer(1);
    private PSSysSearchBar pssyssearchbar = null;

    public void setAddSeparator(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAddSeparator(n);
            return;
        }
        this.addseparator = n;
        this.addseparatorDirtyFlag = true;
    }

    public Integer getAddSeparator() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAddSeparator();
        }
        return this.addseparator;
    }

    public boolean isAddSeparatorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAddSeparatorDirty();
        }
        return this.addseparatorDirtyFlag;
    }

    public void resetAddSeparator() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAddSeparator();
            return;
        }
        this.addseparatorDirtyFlag = false;
        this.addseparator = null;
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

    public void setCtrlDynaClass(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlDynaClass(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrldynaclass = string;
        this.ctrldynaclassDirtyFlag = true;
    }

    public String getCtrlDynaClass() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlDynaClass();
        }
        return this.ctrldynaclass;
    }

    public boolean isCtrlDynaClassDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlDynaClassDirty();
        }
        return this.ctrldynaclassDirtyFlag;
    }

    public void resetCtrlDynaClass() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlDynaClass();
            return;
        }
        this.ctrldynaclassDirtyFlag = false;
        this.ctrldynaclass = null;
    }

    public void setCtrlHeight(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlHeight(n);
            return;
        }
        this.ctrlheight = n;
        this.ctrlheightDirtyFlag = true;
    }

    public Integer getCtrlHeight() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlHeight();
        }
        return this.ctrlheight;
    }

    public boolean isCtrlHeightDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlHeightDirty();
        }
        return this.ctrlheightDirtyFlag;
    }

    public void resetCtrlHeight() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlHeight();
            return;
        }
        this.ctrlheightDirtyFlag = false;
        this.ctrlheight = null;
    }

    public void setCtrlPSSysCssId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlPSSysCssId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrlpssyscssid = string;
        this.ctrlpssyscssidDirtyFlag = true;
    }

    public String getCtrlPSSysCssId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlPSSysCssId();
        }
        return this.ctrlpssyscssid;
    }

    public boolean isCtrlPSSysCssIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlPSSysCssIdDirty();
        }
        return this.ctrlpssyscssidDirtyFlag;
    }

    public void resetCtrlPSSysCssId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlPSSysCssId();
            return;
        }
        this.ctrlpssyscssidDirtyFlag = false;
        this.ctrlpssyscssid = null;
    }

    public void setCtrlPSSysCssName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlPSSysCssName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrlpssyscssname = string;
        this.ctrlpssyscssnameDirtyFlag = true;
    }

    public String getCtrlPSSysCssName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlPSSysCssName();
        }
        return this.ctrlpssyscssname;
    }

    public boolean isCtrlPSSysCssNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlPSSysCssNameDirty();
        }
        return this.ctrlpssyscssnameDirtyFlag;
    }

    public void resetCtrlPSSysCssName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlPSSysCssName();
            return;
        }
        this.ctrlpssyscssnameDirtyFlag = false;
        this.ctrlpssyscssname = null;
    }

    public void setCtrlRawCssStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlRawCssStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrlrawcssstyle = string;
        this.ctrlrawcssstyleDirtyFlag = true;
    }

    public String getCtrlRawCssStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlRawCssStyle();
        }
        return this.ctrlrawcssstyle;
    }

    public boolean isCtrlRawCssStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlRawCssStyleDirty();
        }
        return this.ctrlrawcssstyleDirtyFlag;
    }

    public void resetCtrlRawCssStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlRawCssStyle();
            return;
        }
        this.ctrlrawcssstyleDirtyFlag = false;
        this.ctrlrawcssstyle = null;
    }

    public void setCtrlWidth(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlWidth(n);
            return;
        }
        this.ctrlwidth = n;
        this.ctrlwidthDirtyFlag = true;
    }

    public Integer getCtrlWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlWidth();
        }
        return this.ctrlwidth;
    }

    public boolean isCtrlWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlWidthDirty();
        }
        return this.ctrlwidthDirtyFlag;
    }

    public void resetCtrlWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlWidth();
            return;
        }
        this.ctrlwidthDirtyFlag = false;
        this.ctrlwidth = null;
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

    public void setEditorParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEditorParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.editorparams = string;
        this.editorparamsDirtyFlag = true;
    }

    public String getEditorParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEditorParams();
        }
        return this.editorparams;
    }

    public boolean isEditorParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEditorParamsDirty();
        }
        return this.editorparamsDirtyFlag;
    }

    public void resetEditorParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEditorParams();
            return;
        }
        this.editorparamsDirtyFlag = false;
        this.editorparams = null;
    }

    public void setEditorType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEditorType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.editortype = string;
        this.editortypeDirtyFlag = true;
    }

    public String getEditorType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEditorType();
        }
        return this.editortype;
    }

    public boolean isEditorTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEditorTypeDirty();
        }
        return this.editortypeDirtyFlag;
    }

    public void resetEditorType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEditorType();
            return;
        }
        this.editortypeDirtyFlag = false;
        this.editortype = null;
    }

    public void setEditorTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEditorTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.editortypename = string;
        this.editortypenameDirtyFlag = true;
    }

    public String getEditorTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEditorTypeName();
        }
        return this.editortypename;
    }

    public boolean isEditorTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEditorTypeNameDirty();
        }
        return this.editortypenameDirtyFlag;
    }

    public void resetEditorTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEditorTypeName();
            return;
        }
        this.editortypenameDirtyFlag = false;
        this.editortypename = null;
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

    public void setItemSubType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemSubType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemsubtype = string;
        this.itemsubtypeDirtyFlag = true;
    }

    public String getItemSubType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemSubType();
        }
        return this.itemsubtype;
    }

    public boolean isItemSubTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemSubTypeDirty();
        }
        return this.itemsubtypeDirtyFlag;
    }

    public void resetItemSubType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemSubType();
            return;
        }
        this.itemsubtypeDirtyFlag = false;
        this.itemsubtype = null;
    }

    public void setItemTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemtag = string;
        this.itemtagDirtyFlag = true;
    }

    public String getItemTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemTag();
        }
        return this.itemtag;
    }

    public boolean isItemTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemTagDirty();
        }
        return this.itemtagDirtyFlag;
    }

    public void resetItemTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemTag();
            return;
        }
        this.itemtagDirtyFlag = false;
        this.itemtag = null;
    }

    public void setItemTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemtag2 = string;
        this.itemtag2DirtyFlag = true;
    }

    public String getItemTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemTag2();
        }
        return this.itemtag2;
    }

    public boolean isItemTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemTag2Dirty();
        }
        return this.itemtag2DirtyFlag;
    }

    public void resetItemTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemTag2();
            return;
        }
        this.itemtag2DirtyFlag = false;
        this.itemtag2 = null;
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

    public void setLabelDynaClass(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLabelDynaClass(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.labeldynaclass = string;
        this.labeldynaclassDirtyFlag = true;
    }

    public String getLabelDynaClass() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLabelDynaClass();
        }
        return this.labeldynaclass;
    }

    public boolean isLabelDynaClassDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLabelDynaClassDirty();
        }
        return this.labeldynaclassDirtyFlag;
    }

    public void resetLabelDynaClass() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLabelDynaClass();
            return;
        }
        this.labeldynaclassDirtyFlag = false;
        this.labeldynaclass = null;
    }

    public void setLabelPos(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLabelPos(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.labelpos = string;
        this.labelposDirtyFlag = true;
    }

    public String getLabelPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLabelPos();
        }
        return this.labelpos;
    }

    public boolean isLabelPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLabelPosDirty();
        }
        return this.labelposDirtyFlag;
    }

    public void resetLabelPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLabelPos();
            return;
        }
        this.labelposDirtyFlag = false;
        this.labelpos = null;
    }

    public void setLabelPSSysCssId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLabelPSSysCssId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.labelpssyscssid = string;
        this.labelpssyscssidDirtyFlag = true;
    }

    public String getLabelPSSysCssId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLabelPSSysCssId();
        }
        return this.labelpssyscssid;
    }

    public boolean isLabelPSSysCssIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLabelPSSysCssIdDirty();
        }
        return this.labelpssyscssidDirtyFlag;
    }

    public void resetLabelPSSysCssId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLabelPSSysCssId();
            return;
        }
        this.labelpssyscssidDirtyFlag = false;
        this.labelpssyscssid = null;
    }

    public void setLabelPSSysCssName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLabelPSSysCssName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.labelpssyscssname = string;
        this.labelpssyscssnameDirtyFlag = true;
    }

    public String getLabelPSSysCssName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLabelPSSysCssName();
        }
        return this.labelpssyscssname;
    }

    public boolean isLabelPSSysCssNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLabelPSSysCssNameDirty();
        }
        return this.labelpssyscssnameDirtyFlag;
    }

    public void resetLabelPSSysCssName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLabelPSSysCssName();
            return;
        }
        this.labelpssyscssnameDirtyFlag = false;
        this.labelpssyscssname = null;
    }

    public void setLabelRawCssStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLabelRawCssStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.labelrawcssstyle = string;
        this.labelrawcssstyleDirtyFlag = true;
    }

    public String getLabelRawCssStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLabelRawCssStyle();
        }
        return this.labelrawcssstyle;
    }

    public boolean isLabelRawCssStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLabelRawCssStyleDirty();
        }
        return this.labelrawcssstyleDirtyFlag;
    }

    public void resetLabelRawCssStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLabelRawCssStyle();
            return;
        }
        this.labelrawcssstyleDirtyFlag = false;
        this.labelrawcssstyle = null;
    }

    public void setLabelWidth(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLabelWidth(n);
            return;
        }
        this.labelwidth = n;
        this.labelwidthDirtyFlag = true;
    }

    public Integer getLabelWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLabelWidth();
        }
        return this.labelwidth;
    }

    public boolean isLabelWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLabelWidthDirty();
        }
        return this.labelwidthDirtyFlag;
    }

    public void resetLabelWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLabelWidth();
            return;
        }
        this.labelwidthDirtyFlag = false;
        this.labelwidth = null;
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

    public void setMobFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobFlag(n);
            return;
        }
        this.mobflag = n;
        this.mobflagDirtyFlag = true;
    }

    public Integer getMobFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobFlag();
        }
        return this.mobflag;
    }

    public boolean isMobFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobFlagDirty();
        }
        return this.mobflagDirtyFlag;
    }

    public void resetMobFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobFlag();
            return;
        }
        this.mobflagDirtyFlag = false;
        this.mobflag = null;
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

    public void setPHPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPHPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.phpslanresid = string;
        this.phpslanresidDirtyFlag = true;
    }

    public String getPHPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPHPSLanResId();
        }
        return this.phpslanresid;
    }

    public boolean isPHPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPHPSLanResIdDirty();
        }
        return this.phpslanresidDirtyFlag;
    }

    public void resetPHPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPHPSLanResId();
            return;
        }
        this.phpslanresidDirtyFlag = false;
        this.phpslanresid = null;
    }

    public void setPHPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPHPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.phpslanresname = string;
        this.phpslanresnameDirtyFlag = true;
    }

    public String getPHPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPHPSLanResName();
        }
        return this.phpslanresname;
    }

    public boolean isPHPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPHPSLanResNameDirty();
        }
        return this.phpslanresnameDirtyFlag;
    }

    public void resetPHPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPHPSLanResName();
            return;
        }
        this.phpslanresnameDirtyFlag = false;
        this.phpslanresname = null;
    }

    public void setPlaceHolder(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPlaceHolder(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.placeholder = string;
        this.placeholderDirtyFlag = true;
    }

    public String getPlaceHolder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPlaceHolder();
        }
        return this.placeholder;
    }

    public boolean isPlaceHolderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPlaceHolderDirty();
        }
        return this.placeholderDirtyFlag;
    }

    public void resetPlaceHolder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPlaceHolder();
            return;
        }
        this.placeholderDirtyFlag = false;
        this.placeholder = null;
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

    public void setPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefid = string;
        this.psdefidDirtyFlag = true;
    }

    public String getPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFId();
        }
        return this.psdefid;
    }

    public boolean isPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFIdDirty();
        }
        return this.psdefidDirtyFlag;
    }

    public void resetPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFId();
            return;
        }
        this.psdefidDirtyFlag = false;
        this.psdefid = null;
    }

    public void setPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefname = string;
        this.psdefnameDirtyFlag = true;
    }

    public String getPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFName();
        }
        return this.psdefname;
    }

    public boolean isPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFNameDirty();
        }
        return this.psdefnameDirtyFlag;
    }

    public void resetPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFName();
            return;
        }
        this.psdefnameDirtyFlag = false;
        this.psdefname = null;
    }

    public void setPSDEFSFItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFSFItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefsfitemid = string;
        this.psdefsfitemidDirtyFlag = true;
    }

    public String getPSDEFSFItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFSFItemId();
        }
        return this.psdefsfitemid;
    }

    public boolean isPSDEFSFItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFSFItemIdDirty();
        }
        return this.psdefsfitemidDirtyFlag;
    }

    public void resetPSDEFSFItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFSFItemId();
            return;
        }
        this.psdefsfitemidDirtyFlag = false;
        this.psdefsfitemid = null;
    }

    public void setPSDEFSFItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFSFItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefsfitemname = string;
        this.psdefsfitemnameDirtyFlag = true;
    }

    public String getPSDEFSFItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFSFItemName();
        }
        return this.psdefsfitemname;
    }

    public boolean isPSDEFSFItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFSFItemNameDirty();
        }
        return this.psdefsfitemnameDirtyFlag;
    }

    public void resetPSDEFSFItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFSFItemName();
            return;
        }
        this.psdefsfitemnameDirtyFlag = false;
        this.psdefsfitemname = null;
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

    public void setPSSysEditorStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEditorStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseditorstyleid = string;
        this.pssyseditorstyleidDirtyFlag = true;
    }

    public String getPSSysEditorStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEditorStyleId();
        }
        return this.pssyseditorstyleid;
    }

    public boolean isPSSysEditorStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEditorStyleIdDirty();
        }
        return this.pssyseditorstyleidDirtyFlag;
    }

    public void resetPSSysEditorStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEditorStyleId();
            return;
        }
        this.pssyseditorstyleidDirtyFlag = false;
        this.pssyseditorstyleid = null;
    }

    public void setPSSysEditorStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEditorStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseditorstylename = string;
        this.pssyseditorstylenameDirtyFlag = true;
    }

    public String getPSSysEditorStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEditorStyleName();
        }
        return this.pssyseditorstylename;
    }

    public boolean isPSSysEditorStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEditorStyleNameDirty();
        }
        return this.pssyseditorstylenameDirtyFlag;
    }

    public void resetPSSysEditorStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEditorStyleName();
            return;
        }
        this.pssyseditorstylenameDirtyFlag = false;
        this.pssyseditorstylename = null;
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

    public void setPSSysSearchBarId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSearchBarId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssearchbarid = string;
        this.pssyssearchbaridDirtyFlag = true;
    }

    public String getPSSysSearchBarId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchBarId();
        }
        return this.pssyssearchbarid;
    }

    public boolean isPSSysSearchBarIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSearchBarIdDirty();
        }
        return this.pssyssearchbaridDirtyFlag;
    }

    public void resetPSSysSearchBarId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSearchBarId();
            return;
        }
        this.pssyssearchbaridDirtyFlag = false;
        this.pssyssearchbarid = null;
    }

    public void setPSSysSearchBarItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSearchBarItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssearchbaritemid = string;
        this.pssyssearchbaritemidDirtyFlag = true;
    }

    public String getPSSysSearchBarItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchBarItemId();
        }
        return this.pssyssearchbaritemid;
    }

    public boolean isPSSysSearchBarItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSearchBarItemIdDirty();
        }
        return this.pssyssearchbaritemidDirtyFlag;
    }

    public void resetPSSysSearchBarItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSearchBarItemId();
            return;
        }
        this.pssyssearchbaritemidDirtyFlag = false;
        this.pssyssearchbaritemid = null;
    }

    public void setPSSysSearchBarItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSearchBarItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssearchbaritemname = string;
        this.pssyssearchbaritemnameDirtyFlag = true;
    }

    public String getPSSysSearchBarItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchBarItemName();
        }
        return this.pssyssearchbaritemname;
    }

    public boolean isPSSysSearchBarItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSearchBarItemNameDirty();
        }
        return this.pssyssearchbaritemnameDirtyFlag;
    }

    public void resetPSSysSearchBarItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSearchBarItemName();
            return;
        }
        this.pssyssearchbaritemnameDirtyFlag = false;
        this.pssyssearchbaritemname = null;
    }

    public void setPSSysSearchBarName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSearchBarName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssearchbarname = string;
        this.pssyssearchbarnameDirtyFlag = true;
    }

    public String getPSSysSearchBarName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchBarName();
        }
        return this.pssyssearchbarname;
    }

    public boolean isPSSysSearchBarNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSearchBarNameDirty();
        }
        return this.pssyssearchbarnameDirtyFlag;
    }

    public void resetPSSysSearchBarName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSearchBarName();
            return;
        }
        this.pssyssearchbarnameDirtyFlag = false;
        this.pssyssearchbarname = null;
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

    public void setRawServiceMethod(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRawServiceMethod(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rawservicemethod = string;
        this.rawservicemethodDirtyFlag = true;
    }

    public String getRawServiceMethod() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRawServiceMethod();
        }
        return this.rawservicemethod;
    }

    public boolean isRawServiceMethodDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRawServiceMethodDirty();
        }
        return this.rawservicemethodDirtyFlag;
    }

    public void resetRawServiceMethod() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRawServiceMethod();
            return;
        }
        this.rawservicemethodDirtyFlag = false;
        this.rawservicemethod = null;
    }

    public void setRawServiceUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRawServiceUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rawserviceurl = string;
        this.rawserviceurlDirtyFlag = true;
    }

    public String getRawServiceUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRawServiceUrl();
        }
        return this.rawserviceurl;
    }

    public boolean isRawServiceUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRawServiceUrlDirty();
        }
        return this.rawserviceurlDirtyFlag;
    }

    public void resetRawServiceUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRawServiceUrl();
            return;
        }
        this.rawserviceurlDirtyFlag = false;
        this.rawserviceurl = null;
    }

    public void setResetItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResetItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.resetitemname = string;
        this.resetitemnameDirtyFlag = true;
    }

    public String getResetItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResetItemName();
        }
        return this.resetitemname;
    }

    public boolean isResetItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResetItemNameDirty();
        }
        return this.resetitemnameDirtyFlag;
    }

    public void resetResetItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResetItemName();
            return;
        }
        this.resetitemnameDirtyFlag = false;
        this.resetitemname = null;
    }

    public void setShowCaption(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setShowCaption(n);
            return;
        }
        this.showcaption = n;
        this.showcaptionDirtyFlag = true;
    }

    public Integer getShowCaption() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getShowCaption();
        }
        return this.showcaption;
    }

    public boolean isShowCaptionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isShowCaptionDirty();
        }
        return this.showcaptionDirtyFlag;
    }

    public void resetShowCaption() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetShowCaption();
            return;
        }
        this.showcaptionDirtyFlag = false;
        this.showcaption = null;
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

    public void setValueItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValueItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.valueitemname = string;
        this.valueitemnameDirtyFlag = true;
    }

    public String getValueItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValueItemName();
        }
        return this.valueitemname;
    }

    public boolean isValueItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValueItemNameDirty();
        }
        return this.valueitemnameDirtyFlag;
    }

    public void resetValueItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValueItemName();
            return;
        }
        this.valueitemnameDirtyFlag = false;
        this.valueitemname = null;
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
        PSSysSearchBarItemBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysSearchBarItemBase pSSysSearchBarItemBase) {
        pSSysSearchBarItemBase.resetAddSeparator();
        pSSysSearchBarItemBase.resetCapPSLanResId();
        pSSysSearchBarItemBase.resetCapPSLanResName();
        pSSysSearchBarItemBase.resetCaption();
        pSSysSearchBarItemBase.resetContentType();
        pSSysSearchBarItemBase.resetCounterId();
        pSSysSearchBarItemBase.resetCounterMode();
        pSSysSearchBarItemBase.resetCreateDate();
        pSSysSearchBarItemBase.resetCreateMan();
        pSSysSearchBarItemBase.resetCtrlDynaClass();
        pSSysSearchBarItemBase.resetCtrlHeight();
        pSSysSearchBarItemBase.resetCtrlPSSysCssId();
        pSSysSearchBarItemBase.resetCtrlPSSysCssName();
        pSSysSearchBarItemBase.resetCtrlRawCssStyle();
        pSSysSearchBarItemBase.resetCtrlWidth();
        pSSysSearchBarItemBase.resetData();
        pSSysSearchBarItemBase.resetDefaultFlag();
        pSSysSearchBarItemBase.resetDynaClass();
        pSSysSearchBarItemBase.resetEditorParams();
        pSSysSearchBarItemBase.resetEditorType();
        pSSysSearchBarItemBase.resetEditorTypeName();
        pSSysSearchBarItemBase.resetFilterPSDEDSId();
        pSSysSearchBarItemBase.resetFilterPSDEDSName();
        pSSysSearchBarItemBase.resetHeight();
        pSSysSearchBarItemBase.resetHtmlContent();
        pSSysSearchBarItemBase.resetItemSubType();
        pSSysSearchBarItemBase.resetItemTag();
        pSSysSearchBarItemBase.resetItemTag2();
        pSSysSearchBarItemBase.resetItemType();
        pSSysSearchBarItemBase.resetLabelDynaClass();
        pSSysSearchBarItemBase.resetLabelPos();
        pSSysSearchBarItemBase.resetLabelPSSysCssId();
        pSSysSearchBarItemBase.resetLabelPSSysCssName();
        pSSysSearchBarItemBase.resetLabelRawCssStyle();
        pSSysSearchBarItemBase.resetLabelWidth();
        pSSysSearchBarItemBase.resetMemo();
        pSSysSearchBarItemBase.resetMobFlag();
        pSSysSearchBarItemBase.resetOrderValue();
        pSSysSearchBarItemBase.resetPHPSLanResId();
        pSSysSearchBarItemBase.resetPHPSLanResName();
        pSSysSearchBarItemBase.resetPlaceHolder();
        pSSysSearchBarItemBase.resetPSCodeListId();
        pSSysSearchBarItemBase.resetPSCodeListName();
        pSSysSearchBarItemBase.resetPSDEFId();
        pSSysSearchBarItemBase.resetPSDEFName();
        pSSysSearchBarItemBase.resetPSDEFSFItemId();
        pSSysSearchBarItemBase.resetPSDEFSFItemName();
        pSSysSearchBarItemBase.resetPSDEId();
        pSSysSearchBarItemBase.resetPSSysCounterId();
        pSSysSearchBarItemBase.resetPSSysCounterName();
        pSSysSearchBarItemBase.resetPSSysCssId();
        pSSysSearchBarItemBase.resetPSSysCssName();
        pSSysSearchBarItemBase.resetPSSysEditorStyleId();
        pSSysSearchBarItemBase.resetPSSysEditorStyleName();
        pSSysSearchBarItemBase.resetPSSysImageId();
        pSSysSearchBarItemBase.resetPSSysImageName();
        pSSysSearchBarItemBase.resetPSSysPFPluginId();
        pSSysSearchBarItemBase.resetPSSysPFPluginName();
        pSSysSearchBarItemBase.resetPSSysResourceId();
        pSSysSearchBarItemBase.resetPSSysResourceName();
        pSSysSearchBarItemBase.resetPSSysSearchBarId();
        pSSysSearchBarItemBase.resetPSSysSearchBarItemId();
        pSSysSearchBarItemBase.resetPSSysSearchBarItemName();
        pSSysSearchBarItemBase.resetPSSysSearchBarName();
        pSSysSearchBarItemBase.resetRawContent();
        pSSysSearchBarItemBase.resetRawCssStyle();
        pSSysSearchBarItemBase.resetRawServiceMethod();
        pSSysSearchBarItemBase.resetRawServiceUrl();
        pSSysSearchBarItemBase.resetResetItemName();
        pSSysSearchBarItemBase.resetShowCaption();
        pSSysSearchBarItemBase.resetTemplateMode();
        pSSysSearchBarItemBase.resetTipPSLanResId();
        pSSysSearchBarItemBase.resetTipPSLanResName();
        pSSysSearchBarItemBase.resetTooltipInfo();
        pSSysSearchBarItemBase.resetUpdateDate();
        pSSysSearchBarItemBase.resetUpdateMan();
        pSSysSearchBarItemBase.resetUserCat();
        pSSysSearchBarItemBase.resetUserParams();
        pSSysSearchBarItemBase.resetUserTag();
        pSSysSearchBarItemBase.resetUserTag2();
        pSSysSearchBarItemBase.resetUserTag3();
        pSSysSearchBarItemBase.resetUserTag4();
        pSSysSearchBarItemBase.resetValidFlag();
        pSSysSearchBarItemBase.resetValueItemName();
        pSSysSearchBarItemBase.resetWidth();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAddSeparatorDirty()) {
            hashMap.put(FIELD_ADDSEPARATOR, this.getAddSeparator());
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
        if (!bl || this.isCtrlDynaClassDirty()) {
            hashMap.put(FIELD_CTRLDYNACLASS, this.getCtrlDynaClass());
        }
        if (!bl || this.isCtrlHeightDirty()) {
            hashMap.put(FIELD_CTRLHEIGHT, this.getCtrlHeight());
        }
        if (!bl || this.isCtrlPSSysCssIdDirty()) {
            hashMap.put(FIELD_CTRLPSSYSCSSID, this.getCtrlPSSysCssId());
        }
        if (!bl || this.isCtrlPSSysCssNameDirty()) {
            hashMap.put(FIELD_CTRLPSSYSCSSNAME, this.getCtrlPSSysCssName());
        }
        if (!bl || this.isCtrlRawCssStyleDirty()) {
            hashMap.put(FIELD_CTRLRAWCSSSTYLE, this.getCtrlRawCssStyle());
        }
        if (!bl || this.isCtrlWidthDirty()) {
            hashMap.put(FIELD_CTRLWIDTH, this.getCtrlWidth());
        }
        if (!bl || this.isDataDirty()) {
            hashMap.put(FIELD_DATA, this.getData());
        }
        if (!bl || this.isDefaultFlagDirty()) {
            hashMap.put(FIELD_DEFAULTFLAG, this.getDefaultFlag());
        }
        if (!bl || this.isDynaClassDirty()) {
            hashMap.put(FIELD_DYNACLASS, this.getDynaClass());
        }
        if (!bl || this.isEditorParamsDirty()) {
            hashMap.put(FIELD_EDITORPARAMS, this.getEditorParams());
        }
        if (!bl || this.isEditorTypeDirty()) {
            hashMap.put(FIELD_EDITORTYPE, this.getEditorType());
        }
        if (!bl || this.isEditorTypeNameDirty()) {
            hashMap.put(FIELD_EDITORTYPENAME, this.getEditorTypeName());
        }
        if (!bl || this.isFilterPSDEDSIdDirty()) {
            hashMap.put(FIELD_FILTERPSDEDSID, this.getFilterPSDEDSId());
        }
        if (!bl || this.isFilterPSDEDSNameDirty()) {
            hashMap.put(FIELD_FILTERPSDEDSNAME, this.getFilterPSDEDSName());
        }
        if (!bl || this.isHeightDirty()) {
            hashMap.put(FIELD_HEIGHT, this.getHeight());
        }
        if (!bl || this.isHtmlContentDirty()) {
            hashMap.put(FIELD_HTMLCONTENT, this.getHtmlContent());
        }
        if (!bl || this.isItemSubTypeDirty()) {
            hashMap.put(FIELD_ITEMSUBTYPE, this.getItemSubType());
        }
        if (!bl || this.isItemTagDirty()) {
            hashMap.put(FIELD_ITEMTAG, this.getItemTag());
        }
        if (!bl || this.isItemTag2Dirty()) {
            hashMap.put(FIELD_ITEMTAG2, this.getItemTag2());
        }
        if (!bl || this.isItemTypeDirty()) {
            hashMap.put(FIELD_ITEMTYPE, this.getItemType());
        }
        if (!bl || this.isLabelDynaClassDirty()) {
            hashMap.put(FIELD_LABELDYNACLASS, this.getLabelDynaClass());
        }
        if (!bl || this.isLabelPosDirty()) {
            hashMap.put(FIELD_LABELPOS, this.getLabelPos());
        }
        if (!bl || this.isLabelPSSysCssIdDirty()) {
            hashMap.put(FIELD_LABELPSSYSCSSID, this.getLabelPSSysCssId());
        }
        if (!bl || this.isLabelPSSysCssNameDirty()) {
            hashMap.put(FIELD_LABELPSSYSCSSNAME, this.getLabelPSSysCssName());
        }
        if (!bl || this.isLabelRawCssStyleDirty()) {
            hashMap.put(FIELD_LABELRAWCSSSTYLE, this.getLabelRawCssStyle());
        }
        if (!bl || this.isLabelWidthDirty()) {
            hashMap.put(FIELD_LABELWIDTH, this.getLabelWidth());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMobFlagDirty()) {
            hashMap.put(FIELD_MOBFLAG, this.getMobFlag());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPHPSLanResIdDirty()) {
            hashMap.put(FIELD_PHPSLANRESID, this.getPHPSLanResId());
        }
        if (!bl || this.isPHPSLanResNameDirty()) {
            hashMap.put(FIELD_PHPSLANRESNAME, this.getPHPSLanResName());
        }
        if (!bl || this.isPlaceHolderDirty()) {
            hashMap.put(FIELD_PLACEHOLDER, this.getPlaceHolder());
        }
        if (!bl || this.isPSCodeListIdDirty()) {
            hashMap.put(FIELD_PSCODELISTID, this.getPSCodeListId());
        }
        if (!bl || this.isPSCodeListNameDirty()) {
            hashMap.put(FIELD_PSCODELISTNAME, this.getPSCodeListName());
        }
        if (!bl || this.isPSDEFIdDirty()) {
            hashMap.put(FIELD_PSDEFID, this.getPSDEFId());
        }
        if (!bl || this.isPSDEFNameDirty()) {
            hashMap.put(FIELD_PSDEFNAME, this.getPSDEFName());
        }
        if (!bl || this.isPSDEFSFItemIdDirty()) {
            hashMap.put(FIELD_PSDEFSFITEMID, this.getPSDEFSFItemId());
        }
        if (!bl || this.isPSDEFSFItemNameDirty()) {
            hashMap.put(FIELD_PSDEFSFITEMNAME, this.getPSDEFSFItemName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSSysCounterIdDirty()) {
            hashMap.put(FIELD_PSSYSCOUNTERID, this.getPSSysCounterId());
        }
        if (!bl || this.isPSSysCounterNameDirty()) {
            hashMap.put(FIELD_PSSYSCOUNTERNAME, this.getPSSysCounterName());
        }
        if (!bl || this.isPSSysCssIdDirty()) {
            hashMap.put(FIELD_PSSYSCSSID, this.getPSSysCssId());
        }
        if (!bl || this.isPSSysCssNameDirty()) {
            hashMap.put(FIELD_PSSYSCSSNAME, this.getPSSysCssName());
        }
        if (!bl || this.isPSSysEditorStyleIdDirty()) {
            hashMap.put(FIELD_PSSYSEDITORSTYLEID, this.getPSSysEditorStyleId());
        }
        if (!bl || this.isPSSysEditorStyleNameDirty()) {
            hashMap.put(FIELD_PSSYSEDITORSTYLENAME, this.getPSSysEditorStyleName());
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
        if (!bl || this.isPSSysSearchBarIdDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHBARID, this.getPSSysSearchBarId());
        }
        if (!bl || this.isPSSysSearchBarItemIdDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHBARITEMID, this.getPSSysSearchBarItemId());
        }
        if (!bl || this.isPSSysSearchBarItemNameDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHBARITEMNAME, this.getPSSysSearchBarItemName());
        }
        if (!bl || this.isPSSysSearchBarNameDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHBARNAME, this.getPSSysSearchBarName());
        }
        if (!bl || this.isRawContentDirty()) {
            hashMap.put(FIELD_RAWCONTENT, this.getRawContent());
        }
        if (!bl || this.isRawCssStyleDirty()) {
            hashMap.put(FIELD_RAWCSSSTYLE, this.getRawCssStyle());
        }
        if (!bl || this.isRawServiceMethodDirty()) {
            hashMap.put(FIELD_RAWSERVICEMETHOD, this.getRawServiceMethod());
        }
        if (!bl || this.isRawServiceUrlDirty()) {
            hashMap.put(FIELD_RAWSERVICEURL, this.getRawServiceUrl());
        }
        if (!bl || this.isResetItemNameDirty()) {
            hashMap.put(FIELD_RESETITEMNAME, this.getResetItemName());
        }
        if (!bl || this.isShowCaptionDirty()) {
            hashMap.put(FIELD_SHOWCAPTION, this.getShowCaption());
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
        if (!bl || this.isTooltipInfoDirty()) {
            hashMap.put(FIELD_TOOLTIPINFO, this.getTooltipInfo());
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
        if (!bl || this.isUserParamsDirty()) {
            hashMap.put(FIELD_USERPARAMS, this.getUserParams());
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
        if (!bl || this.isValueItemNameDirty()) {
            hashMap.put(FIELD_VALUEITEMNAME, this.getValueItemName());
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
        return PSSysSearchBarItemBase.get(this, n);
    }

    private static Object get(PSSysSearchBarItemBase pSSysSearchBarItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSearchBarItemBase.getAddSeparator();
            }
            case 1: {
                return pSSysSearchBarItemBase.getCapPSLanResId();
            }
            case 2: {
                return pSSysSearchBarItemBase.getCapPSLanResName();
            }
            case 3: {
                return pSSysSearchBarItemBase.getCaption();
            }
            case 4: {
                return pSSysSearchBarItemBase.getContentType();
            }
            case 5: {
                return pSSysSearchBarItemBase.getCounterId();
            }
            case 6: {
                return pSSysSearchBarItemBase.getCounterMode();
            }
            case 7: {
                return pSSysSearchBarItemBase.getCreateDate();
            }
            case 8: {
                return pSSysSearchBarItemBase.getCreateMan();
            }
            case 9: {
                return pSSysSearchBarItemBase.getCtrlDynaClass();
            }
            case 10: {
                return pSSysSearchBarItemBase.getCtrlHeight();
            }
            case 11: {
                return pSSysSearchBarItemBase.getCtrlPSSysCssId();
            }
            case 12: {
                return pSSysSearchBarItemBase.getCtrlPSSysCssName();
            }
            case 13: {
                return pSSysSearchBarItemBase.getCtrlRawCssStyle();
            }
            case 14: {
                return pSSysSearchBarItemBase.getCtrlWidth();
            }
            case 15: {
                return pSSysSearchBarItemBase.getData();
            }
            case 16: {
                return pSSysSearchBarItemBase.getDefaultFlag();
            }
            case 17: {
                return pSSysSearchBarItemBase.getDynaClass();
            }
            case 18: {
                return pSSysSearchBarItemBase.getEditorParams();
            }
            case 19: {
                return pSSysSearchBarItemBase.getEditorType();
            }
            case 20: {
                return pSSysSearchBarItemBase.getEditorTypeName();
            }
            case 21: {
                return pSSysSearchBarItemBase.getFilterPSDEDSId();
            }
            case 22: {
                return pSSysSearchBarItemBase.getFilterPSDEDSName();
            }
            case 23: {
                return pSSysSearchBarItemBase.getHeight();
            }
            case 24: {
                return pSSysSearchBarItemBase.getHtmlContent();
            }
            case 25: {
                return pSSysSearchBarItemBase.getItemSubType();
            }
            case 26: {
                return pSSysSearchBarItemBase.getItemTag();
            }
            case 27: {
                return pSSysSearchBarItemBase.getItemTag2();
            }
            case 28: {
                return pSSysSearchBarItemBase.getItemType();
            }
            case 29: {
                return pSSysSearchBarItemBase.getLabelDynaClass();
            }
            case 30: {
                return pSSysSearchBarItemBase.getLabelPos();
            }
            case 31: {
                return pSSysSearchBarItemBase.getLabelPSSysCssId();
            }
            case 32: {
                return pSSysSearchBarItemBase.getLabelPSSysCssName();
            }
            case 33: {
                return pSSysSearchBarItemBase.getLabelRawCssStyle();
            }
            case 34: {
                return pSSysSearchBarItemBase.getLabelWidth();
            }
            case 35: {
                return pSSysSearchBarItemBase.getMemo();
            }
            case 36: {
                return pSSysSearchBarItemBase.getMobFlag();
            }
            case 37: {
                return pSSysSearchBarItemBase.getOrderValue();
            }
            case 38: {
                return pSSysSearchBarItemBase.getPHPSLanResId();
            }
            case 39: {
                return pSSysSearchBarItemBase.getPHPSLanResName();
            }
            case 40: {
                return pSSysSearchBarItemBase.getPlaceHolder();
            }
            case 41: {
                return pSSysSearchBarItemBase.getPSCodeListId();
            }
            case 42: {
                return pSSysSearchBarItemBase.getPSCodeListName();
            }
            case 43: {
                return pSSysSearchBarItemBase.getPSDEFId();
            }
            case 44: {
                return pSSysSearchBarItemBase.getPSDEFName();
            }
            case 45: {
                return pSSysSearchBarItemBase.getPSDEFSFItemId();
            }
            case 46: {
                return pSSysSearchBarItemBase.getPSDEFSFItemName();
            }
            case 47: {
                return pSSysSearchBarItemBase.getPSDEId();
            }
            case 48: {
                return pSSysSearchBarItemBase.getPSSysCounterId();
            }
            case 49: {
                return pSSysSearchBarItemBase.getPSSysCounterName();
            }
            case 50: {
                return pSSysSearchBarItemBase.getPSSysCssId();
            }
            case 51: {
                return pSSysSearchBarItemBase.getPSSysCssName();
            }
            case 52: {
                return pSSysSearchBarItemBase.getPSSysEditorStyleId();
            }
            case 53: {
                return pSSysSearchBarItemBase.getPSSysEditorStyleName();
            }
            case 54: {
                return pSSysSearchBarItemBase.getPSSysImageId();
            }
            case 55: {
                return pSSysSearchBarItemBase.getPSSysImageName();
            }
            case 56: {
                return pSSysSearchBarItemBase.getPSSysPFPluginId();
            }
            case 57: {
                return pSSysSearchBarItemBase.getPSSysPFPluginName();
            }
            case 58: {
                return pSSysSearchBarItemBase.getPSSysResourceId();
            }
            case 59: {
                return pSSysSearchBarItemBase.getPSSysResourceName();
            }
            case 60: {
                return pSSysSearchBarItemBase.getPSSysSearchBarId();
            }
            case 61: {
                return pSSysSearchBarItemBase.getPSSysSearchBarItemId();
            }
            case 62: {
                return pSSysSearchBarItemBase.getPSSysSearchBarItemName();
            }
            case 63: {
                return pSSysSearchBarItemBase.getPSSysSearchBarName();
            }
            case 64: {
                return pSSysSearchBarItemBase.getRawContent();
            }
            case 65: {
                return pSSysSearchBarItemBase.getRawCssStyle();
            }
            case 66: {
                return pSSysSearchBarItemBase.getRawServiceMethod();
            }
            case 67: {
                return pSSysSearchBarItemBase.getRawServiceUrl();
            }
            case 68: {
                return pSSysSearchBarItemBase.getResetItemName();
            }
            case 69: {
                return pSSysSearchBarItemBase.getShowCaption();
            }
            case 70: {
                return pSSysSearchBarItemBase.getTemplateMode();
            }
            case 71: {
                return pSSysSearchBarItemBase.getTipPSLanResId();
            }
            case 72: {
                return pSSysSearchBarItemBase.getTipPSLanResName();
            }
            case 73: {
                return pSSysSearchBarItemBase.getTooltipInfo();
            }
            case 74: {
                return pSSysSearchBarItemBase.getUpdateDate();
            }
            case 75: {
                return pSSysSearchBarItemBase.getUpdateMan();
            }
            case 76: {
                return pSSysSearchBarItemBase.getUserCat();
            }
            case 77: {
                return pSSysSearchBarItemBase.getUserParams();
            }
            case 78: {
                return pSSysSearchBarItemBase.getUserTag();
            }
            case 79: {
                return pSSysSearchBarItemBase.getUserTag2();
            }
            case 80: {
                return pSSysSearchBarItemBase.getUserTag3();
            }
            case 81: {
                return pSSysSearchBarItemBase.getUserTag4();
            }
            case 82: {
                return pSSysSearchBarItemBase.getValidFlag();
            }
            case 83: {
                return pSSysSearchBarItemBase.getValueItemName();
            }
            case 84: {
                return pSSysSearchBarItemBase.getWidth();
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
        PSSysSearchBarItemBase.set(this, n, object);
    }

    private static void set(PSSysSearchBarItemBase pSSysSearchBarItemBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysSearchBarItemBase.setAddSeparator(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSSysSearchBarItemBase.setCapPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysSearchBarItemBase.setCapPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysSearchBarItemBase.setCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysSearchBarItemBase.setContentType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysSearchBarItemBase.setCounterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysSearchBarItemBase.setCounterMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSSysSearchBarItemBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSSysSearchBarItemBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysSearchBarItemBase.setCtrlDynaClass(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysSearchBarItemBase.setCtrlHeight(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSSysSearchBarItemBase.setCtrlPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysSearchBarItemBase.setCtrlPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysSearchBarItemBase.setCtrlRawCssStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysSearchBarItemBase.setCtrlWidth(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSSysSearchBarItemBase.setData(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysSearchBarItemBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSSysSearchBarItemBase.setDynaClass(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysSearchBarItemBase.setEditorParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysSearchBarItemBase.setEditorType(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysSearchBarItemBase.setEditorTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysSearchBarItemBase.setFilterPSDEDSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysSearchBarItemBase.setFilterPSDEDSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysSearchBarItemBase.setHeight(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSSysSearchBarItemBase.setHtmlContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysSearchBarItemBase.setItemSubType(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysSearchBarItemBase.setItemTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysSearchBarItemBase.setItemTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysSearchBarItemBase.setItemType(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysSearchBarItemBase.setLabelDynaClass(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysSearchBarItemBase.setLabelPos(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysSearchBarItemBase.setLabelPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysSearchBarItemBase.setLabelPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysSearchBarItemBase.setLabelRawCssStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysSearchBarItemBase.setLabelWidth(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 35: {
                pSSysSearchBarItemBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysSearchBarItemBase.setMobFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 37: {
                pSSysSearchBarItemBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 38: {
                pSSysSearchBarItemBase.setPHPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysSearchBarItemBase.setPHPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSSysSearchBarItemBase.setPlaceHolder(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSSysSearchBarItemBase.setPSCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSSysSearchBarItemBase.setPSCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSSysSearchBarItemBase.setPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSSysSearchBarItemBase.setPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSSysSearchBarItemBase.setPSDEFSFItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSSysSearchBarItemBase.setPSDEFSFItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSSysSearchBarItemBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSSysSearchBarItemBase.setPSSysCounterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSSysSearchBarItemBase.setPSSysCounterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSSysSearchBarItemBase.setPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSSysSearchBarItemBase.setPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSSysSearchBarItemBase.setPSSysEditorStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSSysSearchBarItemBase.setPSSysEditorStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSSysSearchBarItemBase.setPSSysImageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSSysSearchBarItemBase.setPSSysImageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSSysSearchBarItemBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSSysSearchBarItemBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSSysSearchBarItemBase.setPSSysResourceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSSysSearchBarItemBase.setPSSysResourceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSSysSearchBarItemBase.setPSSysSearchBarId(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSSysSearchBarItemBase.setPSSysSearchBarItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSSysSearchBarItemBase.setPSSysSearchBarItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSSysSearchBarItemBase.setPSSysSearchBarName(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSSysSearchBarItemBase.setRawContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSSysSearchBarItemBase.setRawCssStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSSysSearchBarItemBase.setRawServiceMethod(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSSysSearchBarItemBase.setRawServiceUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSSysSearchBarItemBase.setResetItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSSysSearchBarItemBase.setShowCaption(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 70: {
                pSSysSearchBarItemBase.setTemplateMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 71: {
                pSSysSearchBarItemBase.setTipPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 72: {
                pSSysSearchBarItemBase.setTipPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 73: {
                pSSysSearchBarItemBase.setTooltipInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 74: {
                pSSysSearchBarItemBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 75: {
                pSSysSearchBarItemBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 76: {
                pSSysSearchBarItemBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 77: {
                pSSysSearchBarItemBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 78: {
                pSSysSearchBarItemBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 79: {
                pSSysSearchBarItemBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 80: {
                pSSysSearchBarItemBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 81: {
                pSSysSearchBarItemBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 82: {
                pSSysSearchBarItemBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 83: {
                pSSysSearchBarItemBase.setValueItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 84: {
                pSSysSearchBarItemBase.setWidth(DataObject.getDoubleValue((Object)object));
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
        return PSSysSearchBarItemBase.isNull(this, n);
    }

    private static boolean isNull(PSSysSearchBarItemBase pSSysSearchBarItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSearchBarItemBase.getAddSeparator() == null;
            }
            case 1: {
                return pSSysSearchBarItemBase.getCapPSLanResId() == null;
            }
            case 2: {
                return pSSysSearchBarItemBase.getCapPSLanResName() == null;
            }
            case 3: {
                return pSSysSearchBarItemBase.getCaption() == null;
            }
            case 4: {
                return pSSysSearchBarItemBase.getContentType() == null;
            }
            case 5: {
                return pSSysSearchBarItemBase.getCounterId() == null;
            }
            case 6: {
                return pSSysSearchBarItemBase.getCounterMode() == null;
            }
            case 7: {
                return pSSysSearchBarItemBase.getCreateDate() == null;
            }
            case 8: {
                return pSSysSearchBarItemBase.getCreateMan() == null;
            }
            case 9: {
                return pSSysSearchBarItemBase.getCtrlDynaClass() == null;
            }
            case 10: {
                return pSSysSearchBarItemBase.getCtrlHeight() == null;
            }
            case 11: {
                return pSSysSearchBarItemBase.getCtrlPSSysCssId() == null;
            }
            case 12: {
                return pSSysSearchBarItemBase.getCtrlPSSysCssName() == null;
            }
            case 13: {
                return pSSysSearchBarItemBase.getCtrlRawCssStyle() == null;
            }
            case 14: {
                return pSSysSearchBarItemBase.getCtrlWidth() == null;
            }
            case 15: {
                return pSSysSearchBarItemBase.getData() == null;
            }
            case 16: {
                return pSSysSearchBarItemBase.getDefaultFlag() == null;
            }
            case 17: {
                return pSSysSearchBarItemBase.getDynaClass() == null;
            }
            case 18: {
                return pSSysSearchBarItemBase.getEditorParams() == null;
            }
            case 19: {
                return pSSysSearchBarItemBase.getEditorType() == null;
            }
            case 20: {
                return pSSysSearchBarItemBase.getEditorTypeName() == null;
            }
            case 21: {
                return pSSysSearchBarItemBase.getFilterPSDEDSId() == null;
            }
            case 22: {
                return pSSysSearchBarItemBase.getFilterPSDEDSName() == null;
            }
            case 23: {
                return pSSysSearchBarItemBase.getHeight() == null;
            }
            case 24: {
                return pSSysSearchBarItemBase.getHtmlContent() == null;
            }
            case 25: {
                return pSSysSearchBarItemBase.getItemSubType() == null;
            }
            case 26: {
                return pSSysSearchBarItemBase.getItemTag() == null;
            }
            case 27: {
                return pSSysSearchBarItemBase.getItemTag2() == null;
            }
            case 28: {
                return pSSysSearchBarItemBase.getItemType() == null;
            }
            case 29: {
                return pSSysSearchBarItemBase.getLabelDynaClass() == null;
            }
            case 30: {
                return pSSysSearchBarItemBase.getLabelPos() == null;
            }
            case 31: {
                return pSSysSearchBarItemBase.getLabelPSSysCssId() == null;
            }
            case 32: {
                return pSSysSearchBarItemBase.getLabelPSSysCssName() == null;
            }
            case 33: {
                return pSSysSearchBarItemBase.getLabelRawCssStyle() == null;
            }
            case 34: {
                return pSSysSearchBarItemBase.getLabelWidth() == null;
            }
            case 35: {
                return pSSysSearchBarItemBase.getMemo() == null;
            }
            case 36: {
                return pSSysSearchBarItemBase.getMobFlag() == null;
            }
            case 37: {
                return pSSysSearchBarItemBase.getOrderValue() == null;
            }
            case 38: {
                return pSSysSearchBarItemBase.getPHPSLanResId() == null;
            }
            case 39: {
                return pSSysSearchBarItemBase.getPHPSLanResName() == null;
            }
            case 40: {
                return pSSysSearchBarItemBase.getPlaceHolder() == null;
            }
            case 41: {
                return pSSysSearchBarItemBase.getPSCodeListId() == null;
            }
            case 42: {
                return pSSysSearchBarItemBase.getPSCodeListName() == null;
            }
            case 43: {
                return pSSysSearchBarItemBase.getPSDEFId() == null;
            }
            case 44: {
                return pSSysSearchBarItemBase.getPSDEFName() == null;
            }
            case 45: {
                return pSSysSearchBarItemBase.getPSDEFSFItemId() == null;
            }
            case 46: {
                return pSSysSearchBarItemBase.getPSDEFSFItemName() == null;
            }
            case 47: {
                return pSSysSearchBarItemBase.getPSDEId() == null;
            }
            case 48: {
                return pSSysSearchBarItemBase.getPSSysCounterId() == null;
            }
            case 49: {
                return pSSysSearchBarItemBase.getPSSysCounterName() == null;
            }
            case 50: {
                return pSSysSearchBarItemBase.getPSSysCssId() == null;
            }
            case 51: {
                return pSSysSearchBarItemBase.getPSSysCssName() == null;
            }
            case 52: {
                return pSSysSearchBarItemBase.getPSSysEditorStyleId() == null;
            }
            case 53: {
                return pSSysSearchBarItemBase.getPSSysEditorStyleName() == null;
            }
            case 54: {
                return pSSysSearchBarItemBase.getPSSysImageId() == null;
            }
            case 55: {
                return pSSysSearchBarItemBase.getPSSysImageName() == null;
            }
            case 56: {
                return pSSysSearchBarItemBase.getPSSysPFPluginId() == null;
            }
            case 57: {
                return pSSysSearchBarItemBase.getPSSysPFPluginName() == null;
            }
            case 58: {
                return pSSysSearchBarItemBase.getPSSysResourceId() == null;
            }
            case 59: {
                return pSSysSearchBarItemBase.getPSSysResourceName() == null;
            }
            case 60: {
                return pSSysSearchBarItemBase.getPSSysSearchBarId() == null;
            }
            case 61: {
                return pSSysSearchBarItemBase.getPSSysSearchBarItemId() == null;
            }
            case 62: {
                return pSSysSearchBarItemBase.getPSSysSearchBarItemName() == null;
            }
            case 63: {
                return pSSysSearchBarItemBase.getPSSysSearchBarName() == null;
            }
            case 64: {
                return pSSysSearchBarItemBase.getRawContent() == null;
            }
            case 65: {
                return pSSysSearchBarItemBase.getRawCssStyle() == null;
            }
            case 66: {
                return pSSysSearchBarItemBase.getRawServiceMethod() == null;
            }
            case 67: {
                return pSSysSearchBarItemBase.getRawServiceUrl() == null;
            }
            case 68: {
                return pSSysSearchBarItemBase.getResetItemName() == null;
            }
            case 69: {
                return pSSysSearchBarItemBase.getShowCaption() == null;
            }
            case 70: {
                return pSSysSearchBarItemBase.getTemplateMode() == null;
            }
            case 71: {
                return pSSysSearchBarItemBase.getTipPSLanResId() == null;
            }
            case 72: {
                return pSSysSearchBarItemBase.getTipPSLanResName() == null;
            }
            case 73: {
                return pSSysSearchBarItemBase.getTooltipInfo() == null;
            }
            case 74: {
                return pSSysSearchBarItemBase.getUpdateDate() == null;
            }
            case 75: {
                return pSSysSearchBarItemBase.getUpdateMan() == null;
            }
            case 76: {
                return pSSysSearchBarItemBase.getUserCat() == null;
            }
            case 77: {
                return pSSysSearchBarItemBase.getUserParams() == null;
            }
            case 78: {
                return pSSysSearchBarItemBase.getUserTag() == null;
            }
            case 79: {
                return pSSysSearchBarItemBase.getUserTag2() == null;
            }
            case 80: {
                return pSSysSearchBarItemBase.getUserTag3() == null;
            }
            case 81: {
                return pSSysSearchBarItemBase.getUserTag4() == null;
            }
            case 82: {
                return pSSysSearchBarItemBase.getValidFlag() == null;
            }
            case 83: {
                return pSSysSearchBarItemBase.getValueItemName() == null;
            }
            case 84: {
                return pSSysSearchBarItemBase.getWidth() == null;
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
        return PSSysSearchBarItemBase.contains(this, n);
    }

    private static boolean contains(PSSysSearchBarItemBase pSSysSearchBarItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSearchBarItemBase.isAddSeparatorDirty();
            }
            case 1: {
                return pSSysSearchBarItemBase.isCapPSLanResIdDirty();
            }
            case 2: {
                return pSSysSearchBarItemBase.isCapPSLanResNameDirty();
            }
            case 3: {
                return pSSysSearchBarItemBase.isCaptionDirty();
            }
            case 4: {
                return pSSysSearchBarItemBase.isContentTypeDirty();
            }
            case 5: {
                return pSSysSearchBarItemBase.isCounterIdDirty();
            }
            case 6: {
                return pSSysSearchBarItemBase.isCounterModeDirty();
            }
            case 7: {
                return pSSysSearchBarItemBase.isCreateDateDirty();
            }
            case 8: {
                return pSSysSearchBarItemBase.isCreateManDirty();
            }
            case 9: {
                return pSSysSearchBarItemBase.isCtrlDynaClassDirty();
            }
            case 10: {
                return pSSysSearchBarItemBase.isCtrlHeightDirty();
            }
            case 11: {
                return pSSysSearchBarItemBase.isCtrlPSSysCssIdDirty();
            }
            case 12: {
                return pSSysSearchBarItemBase.isCtrlPSSysCssNameDirty();
            }
            case 13: {
                return pSSysSearchBarItemBase.isCtrlRawCssStyleDirty();
            }
            case 14: {
                return pSSysSearchBarItemBase.isCtrlWidthDirty();
            }
            case 15: {
                return pSSysSearchBarItemBase.isDataDirty();
            }
            case 16: {
                return pSSysSearchBarItemBase.isDefaultFlagDirty();
            }
            case 17: {
                return pSSysSearchBarItemBase.isDynaClassDirty();
            }
            case 18: {
                return pSSysSearchBarItemBase.isEditorParamsDirty();
            }
            case 19: {
                return pSSysSearchBarItemBase.isEditorTypeDirty();
            }
            case 20: {
                return pSSysSearchBarItemBase.isEditorTypeNameDirty();
            }
            case 21: {
                return pSSysSearchBarItemBase.isFilterPSDEDSIdDirty();
            }
            case 22: {
                return pSSysSearchBarItemBase.isFilterPSDEDSNameDirty();
            }
            case 23: {
                return pSSysSearchBarItemBase.isHeightDirty();
            }
            case 24: {
                return pSSysSearchBarItemBase.isHtmlContentDirty();
            }
            case 25: {
                return pSSysSearchBarItemBase.isItemSubTypeDirty();
            }
            case 26: {
                return pSSysSearchBarItemBase.isItemTagDirty();
            }
            case 27: {
                return pSSysSearchBarItemBase.isItemTag2Dirty();
            }
            case 28: {
                return pSSysSearchBarItemBase.isItemTypeDirty();
            }
            case 29: {
                return pSSysSearchBarItemBase.isLabelDynaClassDirty();
            }
            case 30: {
                return pSSysSearchBarItemBase.isLabelPosDirty();
            }
            case 31: {
                return pSSysSearchBarItemBase.isLabelPSSysCssIdDirty();
            }
            case 32: {
                return pSSysSearchBarItemBase.isLabelPSSysCssNameDirty();
            }
            case 33: {
                return pSSysSearchBarItemBase.isLabelRawCssStyleDirty();
            }
            case 34: {
                return pSSysSearchBarItemBase.isLabelWidthDirty();
            }
            case 35: {
                return pSSysSearchBarItemBase.isMemoDirty();
            }
            case 36: {
                return pSSysSearchBarItemBase.isMobFlagDirty();
            }
            case 37: {
                return pSSysSearchBarItemBase.isOrderValueDirty();
            }
            case 38: {
                return pSSysSearchBarItemBase.isPHPSLanResIdDirty();
            }
            case 39: {
                return pSSysSearchBarItemBase.isPHPSLanResNameDirty();
            }
            case 40: {
                return pSSysSearchBarItemBase.isPlaceHolderDirty();
            }
            case 41: {
                return pSSysSearchBarItemBase.isPSCodeListIdDirty();
            }
            case 42: {
                return pSSysSearchBarItemBase.isPSCodeListNameDirty();
            }
            case 43: {
                return pSSysSearchBarItemBase.isPSDEFIdDirty();
            }
            case 44: {
                return pSSysSearchBarItemBase.isPSDEFNameDirty();
            }
            case 45: {
                return pSSysSearchBarItemBase.isPSDEFSFItemIdDirty();
            }
            case 46: {
                return pSSysSearchBarItemBase.isPSDEFSFItemNameDirty();
            }
            case 47: {
                return pSSysSearchBarItemBase.isPSDEIdDirty();
            }
            case 48: {
                return pSSysSearchBarItemBase.isPSSysCounterIdDirty();
            }
            case 49: {
                return pSSysSearchBarItemBase.isPSSysCounterNameDirty();
            }
            case 50: {
                return pSSysSearchBarItemBase.isPSSysCssIdDirty();
            }
            case 51: {
                return pSSysSearchBarItemBase.isPSSysCssNameDirty();
            }
            case 52: {
                return pSSysSearchBarItemBase.isPSSysEditorStyleIdDirty();
            }
            case 53: {
                return pSSysSearchBarItemBase.isPSSysEditorStyleNameDirty();
            }
            case 54: {
                return pSSysSearchBarItemBase.isPSSysImageIdDirty();
            }
            case 55: {
                return pSSysSearchBarItemBase.isPSSysImageNameDirty();
            }
            case 56: {
                return pSSysSearchBarItemBase.isPSSysPFPluginIdDirty();
            }
            case 57: {
                return pSSysSearchBarItemBase.isPSSysPFPluginNameDirty();
            }
            case 58: {
                return pSSysSearchBarItemBase.isPSSysResourceIdDirty();
            }
            case 59: {
                return pSSysSearchBarItemBase.isPSSysResourceNameDirty();
            }
            case 60: {
                return pSSysSearchBarItemBase.isPSSysSearchBarIdDirty();
            }
            case 61: {
                return pSSysSearchBarItemBase.isPSSysSearchBarItemIdDirty();
            }
            case 62: {
                return pSSysSearchBarItemBase.isPSSysSearchBarItemNameDirty();
            }
            case 63: {
                return pSSysSearchBarItemBase.isPSSysSearchBarNameDirty();
            }
            case 64: {
                return pSSysSearchBarItemBase.isRawContentDirty();
            }
            case 65: {
                return pSSysSearchBarItemBase.isRawCssStyleDirty();
            }
            case 66: {
                return pSSysSearchBarItemBase.isRawServiceMethodDirty();
            }
            case 67: {
                return pSSysSearchBarItemBase.isRawServiceUrlDirty();
            }
            case 68: {
                return pSSysSearchBarItemBase.isResetItemNameDirty();
            }
            case 69: {
                return pSSysSearchBarItemBase.isShowCaptionDirty();
            }
            case 70: {
                return pSSysSearchBarItemBase.isTemplateModeDirty();
            }
            case 71: {
                return pSSysSearchBarItemBase.isTipPSLanResIdDirty();
            }
            case 72: {
                return pSSysSearchBarItemBase.isTipPSLanResNameDirty();
            }
            case 73: {
                return pSSysSearchBarItemBase.isTooltipInfoDirty();
            }
            case 74: {
                return pSSysSearchBarItemBase.isUpdateDateDirty();
            }
            case 75: {
                return pSSysSearchBarItemBase.isUpdateManDirty();
            }
            case 76: {
                return pSSysSearchBarItemBase.isUserCatDirty();
            }
            case 77: {
                return pSSysSearchBarItemBase.isUserParamsDirty();
            }
            case 78: {
                return pSSysSearchBarItemBase.isUserTagDirty();
            }
            case 79: {
                return pSSysSearchBarItemBase.isUserTag2Dirty();
            }
            case 80: {
                return pSSysSearchBarItemBase.isUserTag3Dirty();
            }
            case 81: {
                return pSSysSearchBarItemBase.isUserTag4Dirty();
            }
            case 82: {
                return pSSysSearchBarItemBase.isValidFlagDirty();
            }
            case 83: {
                return pSSysSearchBarItemBase.isValueItemNameDirty();
            }
            case 84: {
                return pSSysSearchBarItemBase.isWidthDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysSearchBarItemBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysSearchBarItemBase pSSysSearchBarItemBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysSearchBarItemBase.getAddSeparator() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"addseparator", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getAddSeparator()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getCapPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresid", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getCapPSLanResId()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getCapPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresname", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getCapPSLanResName()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"caption", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getCaption()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getContentType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contenttype", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getContentType()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getCounterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"counterid", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getCounterId()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getCounterMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"countermode", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getCounterMode()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getCtrlDynaClass() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrldynaclass", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getCtrlDynaClass()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getCtrlHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlheight", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getCtrlHeight()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getCtrlPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlpssyscssid", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getCtrlPSSysCssId()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getCtrlPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlpssyscssname", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getCtrlPSSysCssName()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getCtrlRawCssStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlrawcssstyle", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getCtrlRawCssStyle()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getCtrlWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlwidth", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getCtrlWidth()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"data", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getData()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getDynaClass() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynaclass", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getDynaClass()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getEditorParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"editorparams", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getEditorParams()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getEditorType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"editortype", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getEditorType()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getEditorTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"editortypename", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getEditorTypeName()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getFilterPSDEDSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"filterpsdedsid", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getFilterPSDEDSId()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getFilterPSDEDSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"filterpsdedsname", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getFilterPSDEDSName()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"height", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getHeight()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getHtmlContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"htmlcontent", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getHtmlContent()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getItemSubType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemsubtype", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getItemSubType()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getItemTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemtag", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getItemTag()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getItemTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemtag2", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getItemTag2()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getItemType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemtype", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getItemType()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getLabelDynaClass() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"labeldynaclass", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getLabelDynaClass()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getLabelPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"labelpos", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getLabelPos()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getLabelPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"labelpssyscssid", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getLabelPSSysCssId()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getLabelPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"labelpssyscssname", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getLabelPSSysCssName()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getLabelRawCssStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"labelrawcssstyle", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getLabelRawCssStyle()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getLabelWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"labelwidth", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getLabelWidth()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getMobFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobflag", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getMobFlag()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getPHPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"phpslanresid", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getPHPSLanResId()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getPHPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"phpslanresname", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getPHPSLanResName()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getPlaceHolder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"placeholder", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getPlaceHolder()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getPSCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistid", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getPSCodeListId()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getPSCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistname", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getPSCodeListName()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefid", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getPSDEFId()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefname", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getPSDEFName()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getPSDEFSFItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefsfitemid", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getPSDEFSFItemId()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getPSDEFSFItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefsfitemname", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getPSDEFSFItemName()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getPSSysCounterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscounterid", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getPSSysCounterId()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getPSSysCounterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscountername", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getPSSysCounterName()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssid", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getPSSysCssId()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssname", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getPSSysCssName()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getPSSysEditorStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseditorstyleid", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getPSSysEditorStyleId()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getPSSysEditorStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseditorstylename", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getPSSysEditorStyleName()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getPSSysImageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimageid", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getPSSysImageId()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getPSSysImageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimagename", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getPSSysImageName()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getPSSysResourceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysresourceid", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getPSSysResourceId()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getPSSysResourceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysresourcename", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getPSSysResourceName()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getPSSysSearchBarId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchbarid", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getPSSysSearchBarId()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getPSSysSearchBarItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchbaritemid", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getPSSysSearchBarItemId()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getPSSysSearchBarItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchbaritemname", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getPSSysSearchBarItemName()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getPSSysSearchBarName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchbarname", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getPSSysSearchBarName()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getRawContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rawcontent", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getRawContent()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getRawCssStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rawcssstyle", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getRawCssStyle()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getRawServiceMethod() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rawservicemethod", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getRawServiceMethod()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getRawServiceUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rawserviceurl", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getRawServiceUrl()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getResetItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resetitemname", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getResetItemName()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getShowCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"showcaption", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getShowCaption()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getTemplateMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templatemode", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getTemplateMode()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getTipPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tippslanresid", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getTipPSLanResId()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getTipPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tippslanresname", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getTipPSLanResName()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getTooltipInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tooltipinfo", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getTooltipInfo()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getUserParams()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getValueItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valueitemname", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getValueItemName()), (boolean)false);
        }
        if (bl || pSSysSearchBarItemBase.getWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"width", (Object)PSSysSearchBarItemBase.getJSONValue((Object)pSSysSearchBarItemBase.getWidth()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysSearchBarItemBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysSearchBarItemBase pSSysSearchBarItemBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysSearchBarItemBase.getAddSeparator() != null) {
            object = pSSysSearchBarItemBase.getAddSeparator();
            xmlNode.setAttribute(FIELD_ADDSEPARATOR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSearchBarItemBase.getCapPSLanResId() != null) {
            object = pSSysSearchBarItemBase.getCapPSLanResId();
            xmlNode.setAttribute(FIELD_CAPPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getCapPSLanResName() != null) {
            object = pSSysSearchBarItemBase.getCapPSLanResName();
            xmlNode.setAttribute(FIELD_CAPPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getCaption() != null) {
            object = pSSysSearchBarItemBase.getCaption();
            xmlNode.setAttribute(FIELD_CAPTION, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getContentType() != null) {
            object = pSSysSearchBarItemBase.getContentType();
            xmlNode.setAttribute(FIELD_CONTENTTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getCounterId() != null) {
            object = pSSysSearchBarItemBase.getCounterId();
            xmlNode.setAttribute(FIELD_COUNTERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getCounterMode() != null) {
            object = pSSysSearchBarItemBase.getCounterMode();
            xmlNode.setAttribute(FIELD_COUNTERMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSearchBarItemBase.getCreateDate() != null) {
            object = pSSysSearchBarItemBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysSearchBarItemBase.getCreateMan() != null) {
            object = pSSysSearchBarItemBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getCtrlDynaClass() != null) {
            object = pSSysSearchBarItemBase.getCtrlDynaClass();
            xmlNode.setAttribute(FIELD_CTRLDYNACLASS, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getCtrlHeight() != null) {
            object = pSSysSearchBarItemBase.getCtrlHeight();
            xmlNode.setAttribute(FIELD_CTRLHEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSearchBarItemBase.getCtrlPSSysCssId() != null) {
            object = pSSysSearchBarItemBase.getCtrlPSSysCssId();
            xmlNode.setAttribute(FIELD_CTRLPSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getCtrlPSSysCssName() != null) {
            object = pSSysSearchBarItemBase.getCtrlPSSysCssName();
            xmlNode.setAttribute(FIELD_CTRLPSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getCtrlRawCssStyle() != null) {
            object = pSSysSearchBarItemBase.getCtrlRawCssStyle();
            xmlNode.setAttribute(FIELD_CTRLRAWCSSSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getCtrlWidth() != null) {
            object = pSSysSearchBarItemBase.getCtrlWidth();
            xmlNode.setAttribute(FIELD_CTRLWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSearchBarItemBase.getData() != null) {
            object = pSSysSearchBarItemBase.getData();
            xmlNode.setAttribute(FIELD_DATA, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getDefaultFlag() != null) {
            object = pSSysSearchBarItemBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSearchBarItemBase.getDynaClass() != null) {
            object = pSSysSearchBarItemBase.getDynaClass();
            xmlNode.setAttribute(FIELD_DYNACLASS, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getEditorParams() != null) {
            object = pSSysSearchBarItemBase.getEditorParams();
            xmlNode.setAttribute(FIELD_EDITORPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getEditorType() != null) {
            object = pSSysSearchBarItemBase.getEditorType();
            xmlNode.setAttribute(FIELD_EDITORTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getEditorTypeName() != null) {
            object = pSSysSearchBarItemBase.getEditorTypeName();
            xmlNode.setAttribute(FIELD_EDITORTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getFilterPSDEDSId() != null) {
            object = pSSysSearchBarItemBase.getFilterPSDEDSId();
            xmlNode.setAttribute(FIELD_FILTERPSDEDSID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getFilterPSDEDSName() != null) {
            object = pSSysSearchBarItemBase.getFilterPSDEDSName();
            xmlNode.setAttribute(FIELD_FILTERPSDEDSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getHeight() != null) {
            object = pSSysSearchBarItemBase.getHeight();
            xmlNode.setAttribute(FIELD_HEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSearchBarItemBase.getHtmlContent() != null) {
            object = pSSysSearchBarItemBase.getHtmlContent();
            xmlNode.setAttribute(FIELD_HTMLCONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getItemSubType() != null) {
            object = pSSysSearchBarItemBase.getItemSubType();
            xmlNode.setAttribute(FIELD_ITEMSUBTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getItemTag() != null) {
            object = pSSysSearchBarItemBase.getItemTag();
            xmlNode.setAttribute(FIELD_ITEMTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getItemTag2() != null) {
            object = pSSysSearchBarItemBase.getItemTag2();
            xmlNode.setAttribute(FIELD_ITEMTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getItemType() != null) {
            object = pSSysSearchBarItemBase.getItemType();
            xmlNode.setAttribute(FIELD_ITEMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getLabelDynaClass() != null) {
            object = pSSysSearchBarItemBase.getLabelDynaClass();
            xmlNode.setAttribute(FIELD_LABELDYNACLASS, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getLabelPos() != null) {
            object = pSSysSearchBarItemBase.getLabelPos();
            xmlNode.setAttribute(FIELD_LABELPOS, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getLabelPSSysCssId() != null) {
            object = pSSysSearchBarItemBase.getLabelPSSysCssId();
            xmlNode.setAttribute(FIELD_LABELPSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getLabelPSSysCssName() != null) {
            object = pSSysSearchBarItemBase.getLabelPSSysCssName();
            xmlNode.setAttribute(FIELD_LABELPSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getLabelRawCssStyle() != null) {
            object = pSSysSearchBarItemBase.getLabelRawCssStyle();
            xmlNode.setAttribute(FIELD_LABELRAWCSSSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getLabelWidth() != null) {
            object = pSSysSearchBarItemBase.getLabelWidth();
            xmlNode.setAttribute(FIELD_LABELWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSearchBarItemBase.getMemo() != null) {
            object = pSSysSearchBarItemBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getMobFlag() != null) {
            object = pSSysSearchBarItemBase.getMobFlag();
            xmlNode.setAttribute(FIELD_MOBFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSearchBarItemBase.getOrderValue() != null) {
            object = pSSysSearchBarItemBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSearchBarItemBase.getPHPSLanResId() != null) {
            object = pSSysSearchBarItemBase.getPHPSLanResId();
            xmlNode.setAttribute(FIELD_PHPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getPHPSLanResName() != null) {
            object = pSSysSearchBarItemBase.getPHPSLanResName();
            xmlNode.setAttribute(FIELD_PHPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getPlaceHolder() != null) {
            object = pSSysSearchBarItemBase.getPlaceHolder();
            xmlNode.setAttribute(FIELD_PLACEHOLDER, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getPSCodeListId() != null) {
            object = pSSysSearchBarItemBase.getPSCodeListId();
            xmlNode.setAttribute(FIELD_PSCODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getPSCodeListName() != null) {
            object = pSSysSearchBarItemBase.getPSCodeListName();
            xmlNode.setAttribute(FIELD_PSCODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getPSDEFId() != null) {
            object = pSSysSearchBarItemBase.getPSDEFId();
            xmlNode.setAttribute(FIELD_PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getPSDEFName() != null) {
            object = pSSysSearchBarItemBase.getPSDEFName();
            xmlNode.setAttribute(FIELD_PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getPSDEFSFItemId() != null) {
            object = pSSysSearchBarItemBase.getPSDEFSFItemId();
            xmlNode.setAttribute(FIELD_PSDEFSFITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getPSDEFSFItemName() != null) {
            object = pSSysSearchBarItemBase.getPSDEFSFItemName();
            xmlNode.setAttribute(FIELD_PSDEFSFITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getPSDEId() != null) {
            object = pSSysSearchBarItemBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getPSSysCounterId() != null) {
            object = pSSysSearchBarItemBase.getPSSysCounterId();
            xmlNode.setAttribute(FIELD_PSSYSCOUNTERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getPSSysCounterName() != null) {
            object = pSSysSearchBarItemBase.getPSSysCounterName();
            xmlNode.setAttribute(FIELD_PSSYSCOUNTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getPSSysCssId() != null) {
            object = pSSysSearchBarItemBase.getPSSysCssId();
            xmlNode.setAttribute(FIELD_PSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getPSSysCssName() != null) {
            object = pSSysSearchBarItemBase.getPSSysCssName();
            xmlNode.setAttribute(FIELD_PSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getPSSysEditorStyleId() != null) {
            object = pSSysSearchBarItemBase.getPSSysEditorStyleId();
            xmlNode.setAttribute(FIELD_PSSYSEDITORSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getPSSysEditorStyleName() != null) {
            object = pSSysSearchBarItemBase.getPSSysEditorStyleName();
            xmlNode.setAttribute(FIELD_PSSYSEDITORSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getPSSysImageId() != null) {
            object = pSSysSearchBarItemBase.getPSSysImageId();
            xmlNode.setAttribute(FIELD_PSSYSIMAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getPSSysImageName() != null) {
            object = pSSysSearchBarItemBase.getPSSysImageName();
            xmlNode.setAttribute(FIELD_PSSYSIMAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getPSSysPFPluginId() != null) {
            object = pSSysSearchBarItemBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getPSSysPFPluginName() != null) {
            object = pSSysSearchBarItemBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getPSSysResourceId() != null) {
            object = pSSysSearchBarItemBase.getPSSysResourceId();
            xmlNode.setAttribute(FIELD_PSSYSRESOURCEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getPSSysResourceName() != null) {
            object = pSSysSearchBarItemBase.getPSSysResourceName();
            xmlNode.setAttribute(FIELD_PSSYSRESOURCENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getPSSysSearchBarId() != null) {
            object = pSSysSearchBarItemBase.getPSSysSearchBarId();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHBARID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getPSSysSearchBarItemId() != null) {
            object = pSSysSearchBarItemBase.getPSSysSearchBarItemId();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHBARITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getPSSysSearchBarItemName() != null) {
            object = pSSysSearchBarItemBase.getPSSysSearchBarItemName();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHBARITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getPSSysSearchBarName() != null) {
            object = pSSysSearchBarItemBase.getPSSysSearchBarName();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHBARNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getRawContent() != null) {
            object = pSSysSearchBarItemBase.getRawContent();
            xmlNode.setAttribute(FIELD_RAWCONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getRawCssStyle() != null) {
            object = pSSysSearchBarItemBase.getRawCssStyle();
            xmlNode.setAttribute(FIELD_RAWCSSSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getRawServiceMethod() != null) {
            object = pSSysSearchBarItemBase.getRawServiceMethod();
            xmlNode.setAttribute(FIELD_RAWSERVICEMETHOD, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getRawServiceUrl() != null) {
            object = pSSysSearchBarItemBase.getRawServiceUrl();
            xmlNode.setAttribute(FIELD_RAWSERVICEURL, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getResetItemName() != null) {
            object = pSSysSearchBarItemBase.getResetItemName();
            xmlNode.setAttribute(FIELD_RESETITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getShowCaption() != null) {
            object = pSSysSearchBarItemBase.getShowCaption();
            xmlNode.setAttribute(FIELD_SHOWCAPTION, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSearchBarItemBase.getTemplateMode() != null) {
            object = pSSysSearchBarItemBase.getTemplateMode();
            xmlNode.setAttribute(FIELD_TEMPLATEMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSearchBarItemBase.getTipPSLanResId() != null) {
            object = pSSysSearchBarItemBase.getTipPSLanResId();
            xmlNode.setAttribute(FIELD_TIPPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getTipPSLanResName() != null) {
            object = pSSysSearchBarItemBase.getTipPSLanResName();
            xmlNode.setAttribute(FIELD_TIPPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getTooltipInfo() != null) {
            object = pSSysSearchBarItemBase.getTooltipInfo();
            xmlNode.setAttribute(FIELD_TOOLTIPINFO, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getUpdateDate() != null) {
            object = pSSysSearchBarItemBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysSearchBarItemBase.getUpdateMan() != null) {
            object = pSSysSearchBarItemBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getUserCat() != null) {
            object = pSSysSearchBarItemBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getUserParams() != null) {
            object = pSSysSearchBarItemBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getUserTag() != null) {
            object = pSSysSearchBarItemBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getUserTag2() != null) {
            object = pSSysSearchBarItemBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getUserTag3() != null) {
            object = pSSysSearchBarItemBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getUserTag4() != null) {
            object = pSSysSearchBarItemBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getValidFlag() != null) {
            object = pSSysSearchBarItemBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSearchBarItemBase.getValueItemName() != null) {
            object = pSSysSearchBarItemBase.getValueItemName();
            xmlNode.setAttribute(FIELD_VALUEITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarItemBase.getWidth() != null) {
            object = pSSysSearchBarItemBase.getWidth();
            xmlNode.setAttribute(FIELD_WIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysSearchBarItemBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysSearchBarItemBase pSSysSearchBarItemBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysSearchBarItemBase.isAddSeparatorDirty() && (bl || pSSysSearchBarItemBase.getAddSeparator() != null)) {
            iDataObject.set(FIELD_ADDSEPARATOR, (Object)pSSysSearchBarItemBase.getAddSeparator());
        }
        if (pSSysSearchBarItemBase.isCapPSLanResIdDirty() && (bl || pSSysSearchBarItemBase.getCapPSLanResId() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESID, (Object)pSSysSearchBarItemBase.getCapPSLanResId());
        }
        if (pSSysSearchBarItemBase.isCapPSLanResNameDirty() && (bl || pSSysSearchBarItemBase.getCapPSLanResName() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESNAME, (Object)pSSysSearchBarItemBase.getCapPSLanResName());
        }
        if (pSSysSearchBarItemBase.isCaptionDirty() && (bl || pSSysSearchBarItemBase.getCaption() != null)) {
            iDataObject.set(FIELD_CAPTION, (Object)pSSysSearchBarItemBase.getCaption());
        }
        if (pSSysSearchBarItemBase.isContentTypeDirty() && (bl || pSSysSearchBarItemBase.getContentType() != null)) {
            iDataObject.set(FIELD_CONTENTTYPE, (Object)pSSysSearchBarItemBase.getContentType());
        }
        if (pSSysSearchBarItemBase.isCounterIdDirty() && (bl || pSSysSearchBarItemBase.getCounterId() != null)) {
            iDataObject.set(FIELD_COUNTERID, (Object)pSSysSearchBarItemBase.getCounterId());
        }
        if (pSSysSearchBarItemBase.isCounterModeDirty() && (bl || pSSysSearchBarItemBase.getCounterMode() != null)) {
            iDataObject.set(FIELD_COUNTERMODE, (Object)pSSysSearchBarItemBase.getCounterMode());
        }
        if (pSSysSearchBarItemBase.isCreateDateDirty() && (bl || pSSysSearchBarItemBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysSearchBarItemBase.getCreateDate());
        }
        if (pSSysSearchBarItemBase.isCreateManDirty() && (bl || pSSysSearchBarItemBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysSearchBarItemBase.getCreateMan());
        }
        if (pSSysSearchBarItemBase.isCtrlDynaClassDirty() && (bl || pSSysSearchBarItemBase.getCtrlDynaClass() != null)) {
            iDataObject.set(FIELD_CTRLDYNACLASS, (Object)pSSysSearchBarItemBase.getCtrlDynaClass());
        }
        if (pSSysSearchBarItemBase.isCtrlHeightDirty() && (bl || pSSysSearchBarItemBase.getCtrlHeight() != null)) {
            iDataObject.set(FIELD_CTRLHEIGHT, (Object)pSSysSearchBarItemBase.getCtrlHeight());
        }
        if (pSSysSearchBarItemBase.isCtrlPSSysCssIdDirty() && (bl || pSSysSearchBarItemBase.getCtrlPSSysCssId() != null)) {
            iDataObject.set(FIELD_CTRLPSSYSCSSID, (Object)pSSysSearchBarItemBase.getCtrlPSSysCssId());
        }
        if (pSSysSearchBarItemBase.isCtrlPSSysCssNameDirty() && (bl || pSSysSearchBarItemBase.getCtrlPSSysCssName() != null)) {
            iDataObject.set(FIELD_CTRLPSSYSCSSNAME, (Object)pSSysSearchBarItemBase.getCtrlPSSysCssName());
        }
        if (pSSysSearchBarItemBase.isCtrlRawCssStyleDirty() && (bl || pSSysSearchBarItemBase.getCtrlRawCssStyle() != null)) {
            iDataObject.set(FIELD_CTRLRAWCSSSTYLE, (Object)pSSysSearchBarItemBase.getCtrlRawCssStyle());
        }
        if (pSSysSearchBarItemBase.isCtrlWidthDirty() && (bl || pSSysSearchBarItemBase.getCtrlWidth() != null)) {
            iDataObject.set(FIELD_CTRLWIDTH, (Object)pSSysSearchBarItemBase.getCtrlWidth());
        }
        if (pSSysSearchBarItemBase.isDataDirty() && (bl || pSSysSearchBarItemBase.getData() != null)) {
            iDataObject.set(FIELD_DATA, (Object)pSSysSearchBarItemBase.getData());
        }
        if (pSSysSearchBarItemBase.isDefaultFlagDirty() && (bl || pSSysSearchBarItemBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSSysSearchBarItemBase.getDefaultFlag());
        }
        if (pSSysSearchBarItemBase.isDynaClassDirty() && (bl || pSSysSearchBarItemBase.getDynaClass() != null)) {
            iDataObject.set(FIELD_DYNACLASS, (Object)pSSysSearchBarItemBase.getDynaClass());
        }
        if (pSSysSearchBarItemBase.isEditorParamsDirty() && (bl || pSSysSearchBarItemBase.getEditorParams() != null)) {
            iDataObject.set(FIELD_EDITORPARAMS, (Object)pSSysSearchBarItemBase.getEditorParams());
        }
        if (pSSysSearchBarItemBase.isEditorTypeDirty() && (bl || pSSysSearchBarItemBase.getEditorType() != null)) {
            iDataObject.set(FIELD_EDITORTYPE, (Object)pSSysSearchBarItemBase.getEditorType());
        }
        if (pSSysSearchBarItemBase.isEditorTypeNameDirty() && (bl || pSSysSearchBarItemBase.getEditorTypeName() != null)) {
            iDataObject.set(FIELD_EDITORTYPENAME, (Object)pSSysSearchBarItemBase.getEditorTypeName());
        }
        if (pSSysSearchBarItemBase.isFilterPSDEDSIdDirty() && (bl || pSSysSearchBarItemBase.getFilterPSDEDSId() != null)) {
            iDataObject.set(FIELD_FILTERPSDEDSID, (Object)pSSysSearchBarItemBase.getFilterPSDEDSId());
        }
        if (pSSysSearchBarItemBase.isFilterPSDEDSNameDirty() && (bl || pSSysSearchBarItemBase.getFilterPSDEDSName() != null)) {
            iDataObject.set(FIELD_FILTERPSDEDSNAME, (Object)pSSysSearchBarItemBase.getFilterPSDEDSName());
        }
        if (pSSysSearchBarItemBase.isHeightDirty() && (bl || pSSysSearchBarItemBase.getHeight() != null)) {
            iDataObject.set(FIELD_HEIGHT, (Object)pSSysSearchBarItemBase.getHeight());
        }
        if (pSSysSearchBarItemBase.isHtmlContentDirty() && (bl || pSSysSearchBarItemBase.getHtmlContent() != null)) {
            iDataObject.set(FIELD_HTMLCONTENT, (Object)pSSysSearchBarItemBase.getHtmlContent());
        }
        if (pSSysSearchBarItemBase.isItemSubTypeDirty() && (bl || pSSysSearchBarItemBase.getItemSubType() != null)) {
            iDataObject.set(FIELD_ITEMSUBTYPE, (Object)pSSysSearchBarItemBase.getItemSubType());
        }
        if (pSSysSearchBarItemBase.isItemTagDirty() && (bl || pSSysSearchBarItemBase.getItemTag() != null)) {
            iDataObject.set(FIELD_ITEMTAG, (Object)pSSysSearchBarItemBase.getItemTag());
        }
        if (pSSysSearchBarItemBase.isItemTag2Dirty() && (bl || pSSysSearchBarItemBase.getItemTag2() != null)) {
            iDataObject.set(FIELD_ITEMTAG2, (Object)pSSysSearchBarItemBase.getItemTag2());
        }
        if (pSSysSearchBarItemBase.isItemTypeDirty() && (bl || pSSysSearchBarItemBase.getItemType() != null)) {
            iDataObject.set(FIELD_ITEMTYPE, (Object)pSSysSearchBarItemBase.getItemType());
        }
        if (pSSysSearchBarItemBase.isLabelDynaClassDirty() && (bl || pSSysSearchBarItemBase.getLabelDynaClass() != null)) {
            iDataObject.set(FIELD_LABELDYNACLASS, (Object)pSSysSearchBarItemBase.getLabelDynaClass());
        }
        if (pSSysSearchBarItemBase.isLabelPosDirty() && (bl || pSSysSearchBarItemBase.getLabelPos() != null)) {
            iDataObject.set(FIELD_LABELPOS, (Object)pSSysSearchBarItemBase.getLabelPos());
        }
        if (pSSysSearchBarItemBase.isLabelPSSysCssIdDirty() && (bl || pSSysSearchBarItemBase.getLabelPSSysCssId() != null)) {
            iDataObject.set(FIELD_LABELPSSYSCSSID, (Object)pSSysSearchBarItemBase.getLabelPSSysCssId());
        }
        if (pSSysSearchBarItemBase.isLabelPSSysCssNameDirty() && (bl || pSSysSearchBarItemBase.getLabelPSSysCssName() != null)) {
            iDataObject.set(FIELD_LABELPSSYSCSSNAME, (Object)pSSysSearchBarItemBase.getLabelPSSysCssName());
        }
        if (pSSysSearchBarItemBase.isLabelRawCssStyleDirty() && (bl || pSSysSearchBarItemBase.getLabelRawCssStyle() != null)) {
            iDataObject.set(FIELD_LABELRAWCSSSTYLE, (Object)pSSysSearchBarItemBase.getLabelRawCssStyle());
        }
        if (pSSysSearchBarItemBase.isLabelWidthDirty() && (bl || pSSysSearchBarItemBase.getLabelWidth() != null)) {
            iDataObject.set(FIELD_LABELWIDTH, (Object)pSSysSearchBarItemBase.getLabelWidth());
        }
        if (pSSysSearchBarItemBase.isMemoDirty() && (bl || pSSysSearchBarItemBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysSearchBarItemBase.getMemo());
        }
        if (pSSysSearchBarItemBase.isMobFlagDirty() && (bl || pSSysSearchBarItemBase.getMobFlag() != null)) {
            iDataObject.set(FIELD_MOBFLAG, (Object)pSSysSearchBarItemBase.getMobFlag());
        }
        if (pSSysSearchBarItemBase.isOrderValueDirty() && (bl || pSSysSearchBarItemBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysSearchBarItemBase.getOrderValue());
        }
        if (pSSysSearchBarItemBase.isPHPSLanResIdDirty() && (bl || pSSysSearchBarItemBase.getPHPSLanResId() != null)) {
            iDataObject.set(FIELD_PHPSLANRESID, (Object)pSSysSearchBarItemBase.getPHPSLanResId());
        }
        if (pSSysSearchBarItemBase.isPHPSLanResNameDirty() && (bl || pSSysSearchBarItemBase.getPHPSLanResName() != null)) {
            iDataObject.set(FIELD_PHPSLANRESNAME, (Object)pSSysSearchBarItemBase.getPHPSLanResName());
        }
        if (pSSysSearchBarItemBase.isPlaceHolderDirty() && (bl || pSSysSearchBarItemBase.getPlaceHolder() != null)) {
            iDataObject.set(FIELD_PLACEHOLDER, (Object)pSSysSearchBarItemBase.getPlaceHolder());
        }
        if (pSSysSearchBarItemBase.isPSCodeListIdDirty() && (bl || pSSysSearchBarItemBase.getPSCodeListId() != null)) {
            iDataObject.set(FIELD_PSCODELISTID, (Object)pSSysSearchBarItemBase.getPSCodeListId());
        }
        if (pSSysSearchBarItemBase.isPSCodeListNameDirty() && (bl || pSSysSearchBarItemBase.getPSCodeListName() != null)) {
            iDataObject.set(FIELD_PSCODELISTNAME, (Object)pSSysSearchBarItemBase.getPSCodeListName());
        }
        if (pSSysSearchBarItemBase.isPSDEFIdDirty() && (bl || pSSysSearchBarItemBase.getPSDEFId() != null)) {
            iDataObject.set(FIELD_PSDEFID, (Object)pSSysSearchBarItemBase.getPSDEFId());
        }
        if (pSSysSearchBarItemBase.isPSDEFNameDirty() && (bl || pSSysSearchBarItemBase.getPSDEFName() != null)) {
            iDataObject.set(FIELD_PSDEFNAME, (Object)pSSysSearchBarItemBase.getPSDEFName());
        }
        if (pSSysSearchBarItemBase.isPSDEFSFItemIdDirty() && (bl || pSSysSearchBarItemBase.getPSDEFSFItemId() != null)) {
            iDataObject.set(FIELD_PSDEFSFITEMID, (Object)pSSysSearchBarItemBase.getPSDEFSFItemId());
        }
        if (pSSysSearchBarItemBase.isPSDEFSFItemNameDirty() && (bl || pSSysSearchBarItemBase.getPSDEFSFItemName() != null)) {
            iDataObject.set(FIELD_PSDEFSFITEMNAME, (Object)pSSysSearchBarItemBase.getPSDEFSFItemName());
        }
        if (pSSysSearchBarItemBase.isPSDEIdDirty() && (bl || pSSysSearchBarItemBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysSearchBarItemBase.getPSDEId());
        }
        if (pSSysSearchBarItemBase.isPSSysCounterIdDirty() && (bl || pSSysSearchBarItemBase.getPSSysCounterId() != null)) {
            iDataObject.set(FIELD_PSSYSCOUNTERID, (Object)pSSysSearchBarItemBase.getPSSysCounterId());
        }
        if (pSSysSearchBarItemBase.isPSSysCounterNameDirty() && (bl || pSSysSearchBarItemBase.getPSSysCounterName() != null)) {
            iDataObject.set(FIELD_PSSYSCOUNTERNAME, (Object)pSSysSearchBarItemBase.getPSSysCounterName());
        }
        if (pSSysSearchBarItemBase.isPSSysCssIdDirty() && (bl || pSSysSearchBarItemBase.getPSSysCssId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSID, (Object)pSSysSearchBarItemBase.getPSSysCssId());
        }
        if (pSSysSearchBarItemBase.isPSSysCssNameDirty() && (bl || pSSysSearchBarItemBase.getPSSysCssName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSNAME, (Object)pSSysSearchBarItemBase.getPSSysCssName());
        }
        if (pSSysSearchBarItemBase.isPSSysEditorStyleIdDirty() && (bl || pSSysSearchBarItemBase.getPSSysEditorStyleId() != null)) {
            iDataObject.set(FIELD_PSSYSEDITORSTYLEID, (Object)pSSysSearchBarItemBase.getPSSysEditorStyleId());
        }
        if (pSSysSearchBarItemBase.isPSSysEditorStyleNameDirty() && (bl || pSSysSearchBarItemBase.getPSSysEditorStyleName() != null)) {
            iDataObject.set(FIELD_PSSYSEDITORSTYLENAME, (Object)pSSysSearchBarItemBase.getPSSysEditorStyleName());
        }
        if (pSSysSearchBarItemBase.isPSSysImageIdDirty() && (bl || pSSysSearchBarItemBase.getPSSysImageId() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGEID, (Object)pSSysSearchBarItemBase.getPSSysImageId());
        }
        if (pSSysSearchBarItemBase.isPSSysImageNameDirty() && (bl || pSSysSearchBarItemBase.getPSSysImageName() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGENAME, (Object)pSSysSearchBarItemBase.getPSSysImageName());
        }
        if (pSSysSearchBarItemBase.isPSSysPFPluginIdDirty() && (bl || pSSysSearchBarItemBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSSysSearchBarItemBase.getPSSysPFPluginId());
        }
        if (pSSysSearchBarItemBase.isPSSysPFPluginNameDirty() && (bl || pSSysSearchBarItemBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSSysSearchBarItemBase.getPSSysPFPluginName());
        }
        if (pSSysSearchBarItemBase.isPSSysResourceIdDirty() && (bl || pSSysSearchBarItemBase.getPSSysResourceId() != null)) {
            iDataObject.set(FIELD_PSSYSRESOURCEID, (Object)pSSysSearchBarItemBase.getPSSysResourceId());
        }
        if (pSSysSearchBarItemBase.isPSSysResourceNameDirty() && (bl || pSSysSearchBarItemBase.getPSSysResourceName() != null)) {
            iDataObject.set(FIELD_PSSYSRESOURCENAME, (Object)pSSysSearchBarItemBase.getPSSysResourceName());
        }
        if (pSSysSearchBarItemBase.isPSSysSearchBarIdDirty() && (bl || pSSysSearchBarItemBase.getPSSysSearchBarId() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHBARID, (Object)pSSysSearchBarItemBase.getPSSysSearchBarId());
        }
        if (pSSysSearchBarItemBase.isPSSysSearchBarItemIdDirty() && (bl || pSSysSearchBarItemBase.getPSSysSearchBarItemId() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHBARITEMID, (Object)pSSysSearchBarItemBase.getPSSysSearchBarItemId());
        }
        if (pSSysSearchBarItemBase.isPSSysSearchBarItemNameDirty() && (bl || pSSysSearchBarItemBase.getPSSysSearchBarItemName() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHBARITEMNAME, (Object)pSSysSearchBarItemBase.getPSSysSearchBarItemName());
        }
        if (pSSysSearchBarItemBase.isPSSysSearchBarNameDirty() && (bl || pSSysSearchBarItemBase.getPSSysSearchBarName() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHBARNAME, (Object)pSSysSearchBarItemBase.getPSSysSearchBarName());
        }
        if (pSSysSearchBarItemBase.isRawContentDirty() && (bl || pSSysSearchBarItemBase.getRawContent() != null)) {
            iDataObject.set(FIELD_RAWCONTENT, (Object)pSSysSearchBarItemBase.getRawContent());
        }
        if (pSSysSearchBarItemBase.isRawCssStyleDirty() && (bl || pSSysSearchBarItemBase.getRawCssStyle() != null)) {
            iDataObject.set(FIELD_RAWCSSSTYLE, (Object)pSSysSearchBarItemBase.getRawCssStyle());
        }
        if (pSSysSearchBarItemBase.isRawServiceMethodDirty() && (bl || pSSysSearchBarItemBase.getRawServiceMethod() != null)) {
            iDataObject.set(FIELD_RAWSERVICEMETHOD, (Object)pSSysSearchBarItemBase.getRawServiceMethod());
        }
        if (pSSysSearchBarItemBase.isRawServiceUrlDirty() && (bl || pSSysSearchBarItemBase.getRawServiceUrl() != null)) {
            iDataObject.set(FIELD_RAWSERVICEURL, (Object)pSSysSearchBarItemBase.getRawServiceUrl());
        }
        if (pSSysSearchBarItemBase.isResetItemNameDirty() && (bl || pSSysSearchBarItemBase.getResetItemName() != null)) {
            iDataObject.set(FIELD_RESETITEMNAME, (Object)pSSysSearchBarItemBase.getResetItemName());
        }
        if (pSSysSearchBarItemBase.isShowCaptionDirty() && (bl || pSSysSearchBarItemBase.getShowCaption() != null)) {
            iDataObject.set(FIELD_SHOWCAPTION, (Object)pSSysSearchBarItemBase.getShowCaption());
        }
        if (pSSysSearchBarItemBase.isTemplateModeDirty() && (bl || pSSysSearchBarItemBase.getTemplateMode() != null)) {
            iDataObject.set(FIELD_TEMPLATEMODE, (Object)pSSysSearchBarItemBase.getTemplateMode());
        }
        if (pSSysSearchBarItemBase.isTipPSLanResIdDirty() && (bl || pSSysSearchBarItemBase.getTipPSLanResId() != null)) {
            iDataObject.set(FIELD_TIPPSLANRESID, (Object)pSSysSearchBarItemBase.getTipPSLanResId());
        }
        if (pSSysSearchBarItemBase.isTipPSLanResNameDirty() && (bl || pSSysSearchBarItemBase.getTipPSLanResName() != null)) {
            iDataObject.set(FIELD_TIPPSLANRESNAME, (Object)pSSysSearchBarItemBase.getTipPSLanResName());
        }
        if (pSSysSearchBarItemBase.isTooltipInfoDirty() && (bl || pSSysSearchBarItemBase.getTooltipInfo() != null)) {
            iDataObject.set(FIELD_TOOLTIPINFO, (Object)pSSysSearchBarItemBase.getTooltipInfo());
        }
        if (pSSysSearchBarItemBase.isUpdateDateDirty() && (bl || pSSysSearchBarItemBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysSearchBarItemBase.getUpdateDate());
        }
        if (pSSysSearchBarItemBase.isUpdateManDirty() && (bl || pSSysSearchBarItemBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysSearchBarItemBase.getUpdateMan());
        }
        if (pSSysSearchBarItemBase.isUserCatDirty() && (bl || pSSysSearchBarItemBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysSearchBarItemBase.getUserCat());
        }
        if (pSSysSearchBarItemBase.isUserParamsDirty() && (bl || pSSysSearchBarItemBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSSysSearchBarItemBase.getUserParams());
        }
        if (pSSysSearchBarItemBase.isUserTagDirty() && (bl || pSSysSearchBarItemBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysSearchBarItemBase.getUserTag());
        }
        if (pSSysSearchBarItemBase.isUserTag2Dirty() && (bl || pSSysSearchBarItemBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysSearchBarItemBase.getUserTag2());
        }
        if (pSSysSearchBarItemBase.isUserTag3Dirty() && (bl || pSSysSearchBarItemBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysSearchBarItemBase.getUserTag3());
        }
        if (pSSysSearchBarItemBase.isUserTag4Dirty() && (bl || pSSysSearchBarItemBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysSearchBarItemBase.getUserTag4());
        }
        if (pSSysSearchBarItemBase.isValidFlagDirty() && (bl || pSSysSearchBarItemBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysSearchBarItemBase.getValidFlag());
        }
        if (pSSysSearchBarItemBase.isValueItemNameDirty() && (bl || pSSysSearchBarItemBase.getValueItemName() != null)) {
            iDataObject.set(FIELD_VALUEITEMNAME, (Object)pSSysSearchBarItemBase.getValueItemName());
        }
        if (pSSysSearchBarItemBase.isWidthDirty() && (bl || pSSysSearchBarItemBase.getWidth() != null)) {
            iDataObject.set(FIELD_WIDTH, (Object)pSSysSearchBarItemBase.getWidth());
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
        return PSSysSearchBarItemBase.remove(this, n);
    }

    private static boolean remove(PSSysSearchBarItemBase pSSysSearchBarItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysSearchBarItemBase.resetAddSeparator();
                return true;
            }
            case 1: {
                pSSysSearchBarItemBase.resetCapPSLanResId();
                return true;
            }
            case 2: {
                pSSysSearchBarItemBase.resetCapPSLanResName();
                return true;
            }
            case 3: {
                pSSysSearchBarItemBase.resetCaption();
                return true;
            }
            case 4: {
                pSSysSearchBarItemBase.resetContentType();
                return true;
            }
            case 5: {
                pSSysSearchBarItemBase.resetCounterId();
                return true;
            }
            case 6: {
                pSSysSearchBarItemBase.resetCounterMode();
                return true;
            }
            case 7: {
                pSSysSearchBarItemBase.resetCreateDate();
                return true;
            }
            case 8: {
                pSSysSearchBarItemBase.resetCreateMan();
                return true;
            }
            case 9: {
                pSSysSearchBarItemBase.resetCtrlDynaClass();
                return true;
            }
            case 10: {
                pSSysSearchBarItemBase.resetCtrlHeight();
                return true;
            }
            case 11: {
                pSSysSearchBarItemBase.resetCtrlPSSysCssId();
                return true;
            }
            case 12: {
                pSSysSearchBarItemBase.resetCtrlPSSysCssName();
                return true;
            }
            case 13: {
                pSSysSearchBarItemBase.resetCtrlRawCssStyle();
                return true;
            }
            case 14: {
                pSSysSearchBarItemBase.resetCtrlWidth();
                return true;
            }
            case 15: {
                pSSysSearchBarItemBase.resetData();
                return true;
            }
            case 16: {
                pSSysSearchBarItemBase.resetDefaultFlag();
                return true;
            }
            case 17: {
                pSSysSearchBarItemBase.resetDynaClass();
                return true;
            }
            case 18: {
                pSSysSearchBarItemBase.resetEditorParams();
                return true;
            }
            case 19: {
                pSSysSearchBarItemBase.resetEditorType();
                return true;
            }
            case 20: {
                pSSysSearchBarItemBase.resetEditorTypeName();
                return true;
            }
            case 21: {
                pSSysSearchBarItemBase.resetFilterPSDEDSId();
                return true;
            }
            case 22: {
                pSSysSearchBarItemBase.resetFilterPSDEDSName();
                return true;
            }
            case 23: {
                pSSysSearchBarItemBase.resetHeight();
                return true;
            }
            case 24: {
                pSSysSearchBarItemBase.resetHtmlContent();
                return true;
            }
            case 25: {
                pSSysSearchBarItemBase.resetItemSubType();
                return true;
            }
            case 26: {
                pSSysSearchBarItemBase.resetItemTag();
                return true;
            }
            case 27: {
                pSSysSearchBarItemBase.resetItemTag2();
                return true;
            }
            case 28: {
                pSSysSearchBarItemBase.resetItemType();
                return true;
            }
            case 29: {
                pSSysSearchBarItemBase.resetLabelDynaClass();
                return true;
            }
            case 30: {
                pSSysSearchBarItemBase.resetLabelPos();
                return true;
            }
            case 31: {
                pSSysSearchBarItemBase.resetLabelPSSysCssId();
                return true;
            }
            case 32: {
                pSSysSearchBarItemBase.resetLabelPSSysCssName();
                return true;
            }
            case 33: {
                pSSysSearchBarItemBase.resetLabelRawCssStyle();
                return true;
            }
            case 34: {
                pSSysSearchBarItemBase.resetLabelWidth();
                return true;
            }
            case 35: {
                pSSysSearchBarItemBase.resetMemo();
                return true;
            }
            case 36: {
                pSSysSearchBarItemBase.resetMobFlag();
                return true;
            }
            case 37: {
                pSSysSearchBarItemBase.resetOrderValue();
                return true;
            }
            case 38: {
                pSSysSearchBarItemBase.resetPHPSLanResId();
                return true;
            }
            case 39: {
                pSSysSearchBarItemBase.resetPHPSLanResName();
                return true;
            }
            case 40: {
                pSSysSearchBarItemBase.resetPlaceHolder();
                return true;
            }
            case 41: {
                pSSysSearchBarItemBase.resetPSCodeListId();
                return true;
            }
            case 42: {
                pSSysSearchBarItemBase.resetPSCodeListName();
                return true;
            }
            case 43: {
                pSSysSearchBarItemBase.resetPSDEFId();
                return true;
            }
            case 44: {
                pSSysSearchBarItemBase.resetPSDEFName();
                return true;
            }
            case 45: {
                pSSysSearchBarItemBase.resetPSDEFSFItemId();
                return true;
            }
            case 46: {
                pSSysSearchBarItemBase.resetPSDEFSFItemName();
                return true;
            }
            case 47: {
                pSSysSearchBarItemBase.resetPSDEId();
                return true;
            }
            case 48: {
                pSSysSearchBarItemBase.resetPSSysCounterId();
                return true;
            }
            case 49: {
                pSSysSearchBarItemBase.resetPSSysCounterName();
                return true;
            }
            case 50: {
                pSSysSearchBarItemBase.resetPSSysCssId();
                return true;
            }
            case 51: {
                pSSysSearchBarItemBase.resetPSSysCssName();
                return true;
            }
            case 52: {
                pSSysSearchBarItemBase.resetPSSysEditorStyleId();
                return true;
            }
            case 53: {
                pSSysSearchBarItemBase.resetPSSysEditorStyleName();
                return true;
            }
            case 54: {
                pSSysSearchBarItemBase.resetPSSysImageId();
                return true;
            }
            case 55: {
                pSSysSearchBarItemBase.resetPSSysImageName();
                return true;
            }
            case 56: {
                pSSysSearchBarItemBase.resetPSSysPFPluginId();
                return true;
            }
            case 57: {
                pSSysSearchBarItemBase.resetPSSysPFPluginName();
                return true;
            }
            case 58: {
                pSSysSearchBarItemBase.resetPSSysResourceId();
                return true;
            }
            case 59: {
                pSSysSearchBarItemBase.resetPSSysResourceName();
                return true;
            }
            case 60: {
                pSSysSearchBarItemBase.resetPSSysSearchBarId();
                return true;
            }
            case 61: {
                pSSysSearchBarItemBase.resetPSSysSearchBarItemId();
                return true;
            }
            case 62: {
                pSSysSearchBarItemBase.resetPSSysSearchBarItemName();
                return true;
            }
            case 63: {
                pSSysSearchBarItemBase.resetPSSysSearchBarName();
                return true;
            }
            case 64: {
                pSSysSearchBarItemBase.resetRawContent();
                return true;
            }
            case 65: {
                pSSysSearchBarItemBase.resetRawCssStyle();
                return true;
            }
            case 66: {
                pSSysSearchBarItemBase.resetRawServiceMethod();
                return true;
            }
            case 67: {
                pSSysSearchBarItemBase.resetRawServiceUrl();
                return true;
            }
            case 68: {
                pSSysSearchBarItemBase.resetResetItemName();
                return true;
            }
            case 69: {
                pSSysSearchBarItemBase.resetShowCaption();
                return true;
            }
            case 70: {
                pSSysSearchBarItemBase.resetTemplateMode();
                return true;
            }
            case 71: {
                pSSysSearchBarItemBase.resetTipPSLanResId();
                return true;
            }
            case 72: {
                pSSysSearchBarItemBase.resetTipPSLanResName();
                return true;
            }
            case 73: {
                pSSysSearchBarItemBase.resetTooltipInfo();
                return true;
            }
            case 74: {
                pSSysSearchBarItemBase.resetUpdateDate();
                return true;
            }
            case 75: {
                pSSysSearchBarItemBase.resetUpdateMan();
                return true;
            }
            case 76: {
                pSSysSearchBarItemBase.resetUserCat();
                return true;
            }
            case 77: {
                pSSysSearchBarItemBase.resetUserParams();
                return true;
            }
            case 78: {
                pSSysSearchBarItemBase.resetUserTag();
                return true;
            }
            case 79: {
                pSSysSearchBarItemBase.resetUserTag2();
                return true;
            }
            case 80: {
                pSSysSearchBarItemBase.resetUserTag3();
                return true;
            }
            case 81: {
                pSSysSearchBarItemBase.resetUserTag4();
                return true;
            }
            case 82: {
                pSSysSearchBarItemBase.resetValidFlag();
                return true;
            }
            case 83: {
                pSSysSearchBarItemBase.resetValueItemName();
                return true;
            }
            case 84: {
                pSSysSearchBarItemBase.resetWidth();
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
                pSCodeListService.autoGet((IEntity)pSCodeList);
                this.pscodelist = pSCodeList;
            }
            return this.pscodelist;
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
                pSDEDataSetService.autoGet((IEntity)pSDEDataSet);
                this.filterpsdeds = pSDEDataSet;
            }
            return this.filterpsdeds;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEF();
        }
        if (this.getPSDEFId() == null) {
            return null;
        }
        Integer n = this.objPSDEFLock;
        synchronized (n) {
            if (this.psdef != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFId(), (Object)this.psdef.getPSDEFieldId()) != 0L) {
                this.psdef = null;
            }
            if (this.psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.psdef = pSDEField;
            }
            return this.psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEFSFItem getPSDEFSFItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFSFItem();
        }
        if (this.getPSDEFSFItemId() == null) {
            return null;
        }
        Integer n = this.objPSDEFSFItemLock;
        synchronized (n) {
            if (this.psdefsfitem != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFSFItemId(), (Object)this.psdefsfitem.getPSDEFSFItemId()) != 0L) {
                this.psdefsfitem = null;
            }
            if (this.psdefsfitem == null) {
                PSDEFSFItem pSDEFSFItem = new PSDEFSFItem();
                pSDEFSFItem.setPSDEFSFItemId(this.getPSDEFSFItemId());
                PSDEFSFItemService pSDEFSFItemService = (PSDEFSFItemService)ServiceGlobal.getService(PSDEFSFItemService.class, (SessionFactory)this.getSessionFactory());
                pSDEFSFItemService.autoGet((IEntity)pSDEFSFItem);
                this.psdefsfitem = pSDEFSFItem;
            }
            return this.psdefsfitem;
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
    public PSLanguageRes getPHPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPHPSLanRes();
        }
        if (this.getPHPSLanResId() == null) {
            return null;
        }
        Integer n = this.objPHPSLanResLock;
        synchronized (n) {
            if (this.phpslanres != null && DataTypeHelper.compare((int)25, (Object)this.getPHPSLanResId(), (Object)this.phpslanres.getPSLanguageResId()) != 0L) {
                this.phpslanres = null;
            }
            if (this.phpslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getPHPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.phpslanres = pSLanguageRes;
            }
            return this.phpslanres;
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
                pSSysCounterService.autoGet((IEntity)pSSysCounter);
                this.pssyscounter = pSSysCounter;
            }
            return this.pssyscounter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysCss getCtrlPSSysCss() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlPSSysCss();
        }
        if (this.getCtrlPSSysCssId() == null) {
            return null;
        }
        Integer n = this.objCtrlPSSysCssLock;
        synchronized (n) {
            if (this.ctrlpssyscss != null && DataTypeHelper.compare((int)25, (Object)this.getCtrlPSSysCssId(), (Object)this.ctrlpssyscss.getPSSysCssId()) != 0L) {
                this.ctrlpssyscss = null;
            }
            if (this.ctrlpssyscss == null) {
                PSSysCss pSSysCss = new PSSysCss();
                pSSysCss.setPSSysCssId(this.getCtrlPSSysCssId());
                PSSysCssService pSSysCssService = (PSSysCssService)ServiceGlobal.getService(PSSysCssService.class, (SessionFactory)this.getSessionFactory());
                pSSysCssService.autoGet((IEntity)pSSysCss);
                this.ctrlpssyscss = pSSysCss;
            }
            return this.ctrlpssyscss;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysCss getLabelPSSysCss() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLabelPSSysCss();
        }
        if (this.getLabelPSSysCssId() == null) {
            return null;
        }
        Integer n = this.objLabelPSSysCssLock;
        synchronized (n) {
            if (this.labelpssyscss != null && DataTypeHelper.compare((int)25, (Object)this.getLabelPSSysCssId(), (Object)this.labelpssyscss.getPSSysCssId()) != 0L) {
                this.labelpssyscss = null;
            }
            if (this.labelpssyscss == null) {
                PSSysCss pSSysCss = new PSSysCss();
                pSSysCss.setPSSysCssId(this.getLabelPSSysCssId());
                PSSysCssService pSSysCssService = (PSSysCssService)ServiceGlobal.getService(PSSysCssService.class, (SessionFactory)this.getSessionFactory());
                pSSysCssService.autoGet((IEntity)pSSysCss);
                this.labelpssyscss = pSSysCss;
            }
            return this.labelpssyscss;
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
    public PSSysEditorStyle getPSSysEditorStyle() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEditorStyle();
        }
        if (this.getPSSysEditorStyleId() == null) {
            return null;
        }
        Integer n = this.objPSSysEditorStyleLock;
        synchronized (n) {
            if (this.pssyseditorstyle != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysEditorStyleId(), (Object)this.pssyseditorstyle.getPSSysEditorStyleId()) != 0L) {
                this.pssyseditorstyle = null;
            }
            if (this.pssyseditorstyle == null) {
                PSSysEditorStyle pSSysEditorStyle = new PSSysEditorStyle();
                pSSysEditorStyle.setPSSysEditorStyleId(this.getPSSysEditorStyleId());
                PSSysEditorStyleService pSSysEditorStyleService = (PSSysEditorStyleService)ServiceGlobal.getService(PSSysEditorStyleService.class, (SessionFactory)this.getSessionFactory());
                pSSysEditorStyleService.autoGet((IEntity)pSSysEditorStyle);
                this.pssyseditorstyle = pSSysEditorStyle;
            }
            return this.pssyseditorstyle;
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
    public PSSysSearchBar getPSSysSearchBar() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchBar();
        }
        if (this.getPSSysSearchBarId() == null) {
            return null;
        }
        Integer n = this.objPSSysSearchBarLock;
        synchronized (n) {
            if (this.pssyssearchbar != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSearchBarId(), (Object)this.pssyssearchbar.getPSSysSearchBarId()) != 0L) {
                this.pssyssearchbar = null;
            }
            if (this.pssyssearchbar == null) {
                PSSysSearchBar pSSysSearchBar = new PSSysSearchBar();
                pSSysSearchBar.setPSSysSearchBarId(this.getPSSysSearchBarId());
                PSSysSearchBarService pSSysSearchBarService = (PSSysSearchBarService)ServiceGlobal.getService(PSSysSearchBarService.class, (SessionFactory)this.getSessionFactory());
                pSSysSearchBarService.autoGet((IEntity)pSSysSearchBar);
                this.pssyssearchbar = pSSysSearchBar;
            }
            return this.pssyssearchbar;
        }
    }

    private PSSysSearchBarItemBase getProxyEntity() {
        return this.proxyPSSysSearchBarItemBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysSearchBarItemBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysSearchBarItemBase) {
            this.proxyPSSysSearchBarItemBase = (PSSysSearchBarItemBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarItemService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ADDSEPARATOR, 0);
        fieldIndexMap.put(FIELD_CAPPSLANRESID, 1);
        fieldIndexMap.put(FIELD_CAPPSLANRESNAME, 2);
        fieldIndexMap.put(FIELD_CAPTION, 3);
        fieldIndexMap.put(FIELD_CONTENTTYPE, 4);
        fieldIndexMap.put(FIELD_COUNTERID, 5);
        fieldIndexMap.put(FIELD_COUNTERMODE, 6);
        fieldIndexMap.put(FIELD_CREATEDATE, 7);
        fieldIndexMap.put(FIELD_CREATEMAN, 8);
        fieldIndexMap.put(FIELD_CTRLDYNACLASS, 9);
        fieldIndexMap.put(FIELD_CTRLHEIGHT, 10);
        fieldIndexMap.put(FIELD_CTRLPSSYSCSSID, 11);
        fieldIndexMap.put(FIELD_CTRLPSSYSCSSNAME, 12);
        fieldIndexMap.put(FIELD_CTRLRAWCSSSTYLE, 13);
        fieldIndexMap.put(FIELD_CTRLWIDTH, 14);
        fieldIndexMap.put(FIELD_DATA, 15);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 16);
        fieldIndexMap.put(FIELD_DYNACLASS, 17);
        fieldIndexMap.put(FIELD_EDITORPARAMS, 18);
        fieldIndexMap.put(FIELD_EDITORTYPE, 19);
        fieldIndexMap.put(FIELD_EDITORTYPENAME, 20);
        fieldIndexMap.put(FIELD_FILTERPSDEDSID, 21);
        fieldIndexMap.put(FIELD_FILTERPSDEDSNAME, 22);
        fieldIndexMap.put(FIELD_HEIGHT, 23);
        fieldIndexMap.put(FIELD_HTMLCONTENT, 24);
        fieldIndexMap.put(FIELD_ITEMSUBTYPE, 25);
        fieldIndexMap.put(FIELD_ITEMTAG, 26);
        fieldIndexMap.put(FIELD_ITEMTAG2, 27);
        fieldIndexMap.put(FIELD_ITEMTYPE, 28);
        fieldIndexMap.put(FIELD_LABELDYNACLASS, 29);
        fieldIndexMap.put(FIELD_LABELPOS, 30);
        fieldIndexMap.put(FIELD_LABELPSSYSCSSID, 31);
        fieldIndexMap.put(FIELD_LABELPSSYSCSSNAME, 32);
        fieldIndexMap.put(FIELD_LABELRAWCSSSTYLE, 33);
        fieldIndexMap.put(FIELD_LABELWIDTH, 34);
        fieldIndexMap.put(FIELD_MEMO, 35);
        fieldIndexMap.put(FIELD_MOBFLAG, 36);
        fieldIndexMap.put(FIELD_ORDERVALUE, 37);
        fieldIndexMap.put(FIELD_PHPSLANRESID, 38);
        fieldIndexMap.put(FIELD_PHPSLANRESNAME, 39);
        fieldIndexMap.put(FIELD_PLACEHOLDER, 40);
        fieldIndexMap.put(FIELD_PSCODELISTID, 41);
        fieldIndexMap.put(FIELD_PSCODELISTNAME, 42);
        fieldIndexMap.put(FIELD_PSDEFID, 43);
        fieldIndexMap.put(FIELD_PSDEFNAME, 44);
        fieldIndexMap.put(FIELD_PSDEFSFITEMID, 45);
        fieldIndexMap.put(FIELD_PSDEFSFITEMNAME, 46);
        fieldIndexMap.put(FIELD_PSDEID, 47);
        fieldIndexMap.put(FIELD_PSSYSCOUNTERID, 48);
        fieldIndexMap.put(FIELD_PSSYSCOUNTERNAME, 49);
        fieldIndexMap.put(FIELD_PSSYSCSSID, 50);
        fieldIndexMap.put(FIELD_PSSYSCSSNAME, 51);
        fieldIndexMap.put(FIELD_PSSYSEDITORSTYLEID, 52);
        fieldIndexMap.put(FIELD_PSSYSEDITORSTYLENAME, 53);
        fieldIndexMap.put(FIELD_PSSYSIMAGEID, 54);
        fieldIndexMap.put(FIELD_PSSYSIMAGENAME, 55);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 56);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 57);
        fieldIndexMap.put(FIELD_PSSYSRESOURCEID, 58);
        fieldIndexMap.put(FIELD_PSSYSRESOURCENAME, 59);
        fieldIndexMap.put(FIELD_PSSYSSEARCHBARID, 60);
        fieldIndexMap.put(FIELD_PSSYSSEARCHBARITEMID, 61);
        fieldIndexMap.put(FIELD_PSSYSSEARCHBARITEMNAME, 62);
        fieldIndexMap.put(FIELD_PSSYSSEARCHBARNAME, 63);
        fieldIndexMap.put(FIELD_RAWCONTENT, 64);
        fieldIndexMap.put(FIELD_RAWCSSSTYLE, 65);
        fieldIndexMap.put(FIELD_RAWSERVICEMETHOD, 66);
        fieldIndexMap.put(FIELD_RAWSERVICEURL, 67);
        fieldIndexMap.put(FIELD_RESETITEMNAME, 68);
        fieldIndexMap.put(FIELD_SHOWCAPTION, 69);
        fieldIndexMap.put(FIELD_TEMPLATEMODE, 70);
        fieldIndexMap.put(FIELD_TIPPSLANRESID, 71);
        fieldIndexMap.put(FIELD_TIPPSLANRESNAME, 72);
        fieldIndexMap.put(FIELD_TOOLTIPINFO, 73);
        fieldIndexMap.put(FIELD_UPDATEDATE, 74);
        fieldIndexMap.put(FIELD_UPDATEMAN, 75);
        fieldIndexMap.put(FIELD_USERCAT, 76);
        fieldIndexMap.put(FIELD_USERPARAMS, 77);
        fieldIndexMap.put(FIELD_USERTAG, 78);
        fieldIndexMap.put(FIELD_USERTAG2, 79);
        fieldIndexMap.put(FIELD_USERTAG3, 80);
        fieldIndexMap.put(FIELD_USERTAG4, 81);
        fieldIndexMap.put(FIELD_VALIDFLAG, 82);
        fieldIndexMap.put(FIELD_VALUEITEMNAME, 83);
        fieldIndexMap.put(FIELD_WIDTH, 84);
    }
}

