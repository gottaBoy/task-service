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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEACMode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFSFItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFUIMode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGEIUpdate;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGrid;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGridCol;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFSFItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFUIModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGEIUpdateService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDictCat;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysEditorStyle;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDictCatService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysEditorStyleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEGridColBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEGridColBase.class);
    public static final String FIELD_AGGFIELD = "AGGFIELD";
    public static final String FIELD_AGGMODE = "AGGMODE";
    public static final String FIELD_AGGVALUEFORMAT = "AGGVALUEFORMAT";
    public static final String FIELD_ALIGN = "ALIGN";
    public static final String FIELD_ALLOWEMPTY = "ALLOWEMPTY";
    public static final String FIELD_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String FIELD_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String FIELD_CAPTION = "CAPTION";
    public static final String FIELD_CELLPSSYSCSSID = "CELLPSSYSCSSID";
    public static final String FIELD_CELLPSSYSCSSNAME = "CELLPSSYSCSSNAME";
    public static final String FIELD_CLCONVERTMODE = "CLCONVERTMODE";
    public static final String FIELD_CODELISTCONFIGMODE = "CODELISTCONFIGMODE";
    public static final String FIELD_COLENABLELINK = "COLENABLELINK";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEDV = "CREATEDV";
    public static final String FIELD_CREATEDVT = "CREATEDVT";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_DATAITEMS = "DATAITEMS";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_EDITORPARAMS = "EDITORPARAMS";
    public static final String FIELD_EDITORTYPE = "EDITORTYPE";
    public static final String FIELD_EDITORTYPENAME = "EDITORTYPENAME";
    public static final String FIELD_ENABLECOND = "ENABLECOND";
    public static final String FIELD_ENABLEINPUTTIP = "ENABLEINPUTTIP";
    public static final String FIELD_ENABLEITEMPRIV = "ENABLEITEMPRIV";
    public static final String FIELD_ENABLELINK = "ENABLELINK";
    public static final String FIELD_ENABLEROWEDIT = "ENABLEROWEDIT";
    public static final String FIELD_GCRPSSYSPFPLUGINID = "GCRPSSYSPFPLUGINID";
    public static final String FIELD_GCRPSSYSPFPLUGINNAME = "GCRPSSYSPFPLUGINNAME";
    public static final String FIELD_GRIDCOLSTYLE = "GRIDCOLSTYLE";
    public static final String FIELD_GRIDCOLTYPE = "GRIDCOLTYPE";
    public static final String FIELD_GROUPITEM = "GROUPITEM";
    public static final String FIELD_HEADERPSSYSCSSID = "HEADERPSSYSCSSID";
    public static final String FIELD_HEADERPSSYSCSSNAME = "HEADERPSSYSCSSNAME";
    public static final String FIELD_HIDDENDATAITEM = "HIDDENDATAITEM";
    public static final String FIELD_HIDEDEFAULT = "HIDEDEFAULT";
    public static final String FIELD_IGNOREINPUT = "IGNOREINPUT";
    public static final String FIELD_LINKPSDEVIEWID = "LINKPSDEVIEWID";
    public static final String FIELD_LINKPSDEVIEWNAME = "LINKPSDEVIEWNAME";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODELSTATE = "MODELSTATE";
    public static final String FIELD_NEEDCODELISTCONFIG = "NEEDCODELISTCONFIG";
    public static final String FIELD_NOPRIVDM = "NOPRIVDM";
    public static final String FIELD_NOSORT = "NOSORT";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PHPSLANRESID = "PHPSLANRESID";
    public static final String FIELD_PHPSLANRESNAME = "PHPSLANRESNAME";
    public static final String FIELD_PICKUPPSDEVIEWID = "PICKUPPSDEVIEWID";
    public static final String FIELD_PICKUPPSDEVIEWNAME = "PICKUPPSDEVIEWNAME";
    public static final String FIELD_PLACEHOLDER = "PLACEHOLDER";
    public static final String FIELD_PPSDEGRIDCOLID = "PPSDEGRIDCOLID";
    public static final String FIELD_PPSDEGRIDCOLNAME = "PPSDEGRIDCOLNAME";
    public static final String FIELD_PREDEFINEDTYPE = "PREDEFINEDTYPE";
    public static final String FIELD_PREDEFINEDTYPETEXT = "PREDEFINEDTYPETEXT";
    public static final String FIELD_PREVENTXSS = "PREVENTXSS";
    public static final String FIELD_PREVIEWHTML = "PREVIEWHTML";
    public static final String FIELD_PSCODELISTID = "PSCODELISTID";
    public static final String FIELD_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String FIELD_PSDEFID = "PSDEFID";
    public static final String FIELD_PSDEFNAME = "PSDEFNAME";
    public static final String FIELD_PSDEFSFITEMID = "PSDEFSFITEMID";
    public static final String FIELD_PSDEFSFITEMNAME = "PSDEFSFITEMNAME";
    public static final String FIELD_PSDEFUIMODEID = "PSDEFUIMODEID";
    public static final String FIELD_PSDEFUIMODENAME = "PSDEFUIMODENAME";
    public static final String FIELD_PSDEGEIUPDATEID = "PSDEGEIUPDATEID";
    public static final String FIELD_PSDEGEIUPDATENAME = "PSDEGEIUPDATENAME";
    public static final String FIELD_PSDEGRIDCOLID = "PSDEGRIDCOLID";
    public static final String FIELD_PSDEGRIDCOLNAME = "PSDEGRIDCOLNAME";
    public static final String FIELD_PSDEGRIDID = "PSDEGRIDID";
    public static final String FIELD_PSDEGRIDNAME = "PSDEGRIDNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDEUAGROUPID = "PSDEUAGROUPID";
    public static final String FIELD_PSDEUAGROUPNAME = "PSDEUAGROUPNAME";
    public static final String FIELD_PSDEUIACTIONID = "PSDEUIACTIONID";
    public static final String FIELD_PSDEUIACTIONNAME = "PSDEUIACTIONNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSSYSDICTCATID = "PSSYSDICTCATID";
    public static final String FIELD_PSSYSDICTCATNAME = "PSSYSDICTCATNAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSEDITORSTYLEID = "PSSYSEDITORSTYLEID";
    public static final String FIELD_PSSYSEDITORSTYLENAME = "PSSYSEDITORSTYLENAME";
    public static final String FIELD_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String FIELD_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String FIELD_RAWSERVICEMETHOD = "RAWSERVICEMETHOD";
    public static final String FIELD_RAWSERVICEURL = "RAWSERVICEURL";
    public static final String FIELD_REFPSDEACMODEID = "REFPSDEACMODEID";
    public static final String FIELD_REFPSDEACMODENAME = "REFPSDEACMODENAME";
    public static final String FIELD_REFPSDEDATASETID = "REFPSDEDATASETID";
    public static final String FIELD_REFPSDEDATASETNAME = "REFPSDEDATASETNAME";
    public static final String FIELD_REFPSDEID = "REFPSDEID";
    public static final String FIELD_REFPSDENAME = "REFPSDENAME";
    public static final String FIELD_REFPSDERID = "REFPSDERID";
    public static final String FIELD_REFPSDERNAME = "REFPSDERNAME";
    public static final String FIELD_RENDERMODE = "RENDERMODE";
    public static final String FIELD_RENDERMODETEXT = "RENDERMODETEXT";
    public static final String FIELD_RESETITEMNAME = "RESETITEMNAME";
    public static final String FIELD_TREEITEM = "TREEITEM";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEDV = "UPDATEDV";
    public static final String FIELD_UPDATEDVT = "UPDATEDVT";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_VALUEFORMAT = "VALUEFORMAT";
    public static final String FIELD_VALUEITEMNAME = "VALUEITEMNAME";
    public static final String FIELD_WIDTH = "WIDTH";
    public static final String FIELD_WIDTHUNIT = "WIDTHUNIT";
    private static final int INDEX_AGGFIELD = 0;
    private static final int INDEX_AGGMODE = 1;
    private static final int INDEX_AGGVALUEFORMAT = 2;
    private static final int INDEX_ALIGN = 3;
    private static final int INDEX_ALLOWEMPTY = 4;
    private static final int INDEX_CAPPSLANRESID = 5;
    private static final int INDEX_CAPPSLANRESNAME = 6;
    private static final int INDEX_CAPTION = 7;
    private static final int INDEX_CELLPSSYSCSSID = 8;
    private static final int INDEX_CELLPSSYSCSSNAME = 9;
    private static final int INDEX_CLCONVERTMODE = 10;
    private static final int INDEX_CODELISTCONFIGMODE = 11;
    private static final int INDEX_COLENABLELINK = 12;
    private static final int INDEX_CREATEDATE = 13;
    private static final int INDEX_CREATEDV = 14;
    private static final int INDEX_CREATEDVT = 15;
    private static final int INDEX_CREATEMAN = 16;
    private static final int INDEX_CUSTOMCODE = 17;
    private static final int INDEX_CUSTOMMODE = 18;
    private static final int INDEX_DATAITEMS = 19;
    private static final int INDEX_DYNAMODELFLAG = 20;
    private static final int INDEX_EDITORPARAMS = 21;
    private static final int INDEX_EDITORTYPE = 22;
    private static final int INDEX_EDITORTYPENAME = 23;
    private static final int INDEX_ENABLECOND = 24;
    private static final int INDEX_ENABLEINPUTTIP = 25;
    private static final int INDEX_ENABLEITEMPRIV = 26;
    private static final int INDEX_ENABLELINK = 27;
    private static final int INDEX_ENABLEROWEDIT = 28;
    private static final int INDEX_GCRPSSYSPFPLUGINID = 29;
    private static final int INDEX_GCRPSSYSPFPLUGINNAME = 30;
    private static final int INDEX_GRIDCOLSTYLE = 31;
    private static final int INDEX_GRIDCOLTYPE = 32;
    private static final int INDEX_GROUPITEM = 33;
    private static final int INDEX_HEADERPSSYSCSSID = 34;
    private static final int INDEX_HEADERPSSYSCSSNAME = 35;
    private static final int INDEX_HIDDENDATAITEM = 36;
    private static final int INDEX_HIDEDEFAULT = 37;
    private static final int INDEX_IGNOREINPUT = 38;
    private static final int INDEX_LINKPSDEVIEWID = 39;
    private static final int INDEX_LINKPSDEVIEWNAME = 40;
    private static final int INDEX_LOGICNAME = 41;
    private static final int INDEX_MEMO = 42;
    private static final int INDEX_MODELSTATE = 43;
    private static final int INDEX_NEEDCODELISTCONFIG = 44;
    private static final int INDEX_NOPRIVDM = 45;
    private static final int INDEX_NOSORT = 46;
    private static final int INDEX_ORDERVALUE = 47;
    private static final int INDEX_PHPSLANRESID = 48;
    private static final int INDEX_PHPSLANRESNAME = 49;
    private static final int INDEX_PICKUPPSDEVIEWID = 50;
    private static final int INDEX_PICKUPPSDEVIEWNAME = 51;
    private static final int INDEX_PLACEHOLDER = 52;
    private static final int INDEX_PPSDEGRIDCOLID = 53;
    private static final int INDEX_PPSDEGRIDCOLNAME = 54;
    private static final int INDEX_PREDEFINEDTYPE = 55;
    private static final int INDEX_PREDEFINEDTYPETEXT = 56;
    private static final int INDEX_PREVENTXSS = 57;
    private static final int INDEX_PREVIEWHTML = 58;
    private static final int INDEX_PSCODELISTID = 59;
    private static final int INDEX_PSCODELISTNAME = 60;
    private static final int INDEX_PSDEFID = 61;
    private static final int INDEX_PSDEFNAME = 62;
    private static final int INDEX_PSDEFSFITEMID = 63;
    private static final int INDEX_PSDEFSFITEMNAME = 64;
    private static final int INDEX_PSDEFUIMODEID = 65;
    private static final int INDEX_PSDEFUIMODENAME = 66;
    private static final int INDEX_PSDEGEIUPDATEID = 67;
    private static final int INDEX_PSDEGEIUPDATENAME = 68;
    private static final int INDEX_PSDEGRIDCOLID = 69;
    private static final int INDEX_PSDEGRIDCOLNAME = 70;
    private static final int INDEX_PSDEGRIDID = 71;
    private static final int INDEX_PSDEGRIDNAME = 72;
    private static final int INDEX_PSDEID = 73;
    private static final int INDEX_PSDEUAGROUPID = 74;
    private static final int INDEX_PSDEUAGROUPNAME = 75;
    private static final int INDEX_PSDEUIACTIONID = 76;
    private static final int INDEX_PSDEUIACTIONNAME = 77;
    private static final int INDEX_PSDYNAINSTID = 78;
    private static final int INDEX_PSSYSDICTCATID = 79;
    private static final int INDEX_PSSYSDICTCATNAME = 80;
    private static final int INDEX_PSSYSDYNAMODELID = 81;
    private static final int INDEX_PSSYSDYNAMODELNAME = 82;
    private static final int INDEX_PSSYSEDITORSTYLEID = 83;
    private static final int INDEX_PSSYSEDITORSTYLENAME = 84;
    private static final int INDEX_PSSYSIMAGEID = 85;
    private static final int INDEX_PSSYSIMAGENAME = 86;
    private static final int INDEX_RAWSERVICEMETHOD = 87;
    private static final int INDEX_RAWSERVICEURL = 88;
    private static final int INDEX_REFPSDEACMODEID = 89;
    private static final int INDEX_REFPSDEACMODENAME = 90;
    private static final int INDEX_REFPSDEDATASETID = 91;
    private static final int INDEX_REFPSDEDATASETNAME = 92;
    private static final int INDEX_REFPSDEID = 93;
    private static final int INDEX_REFPSDENAME = 94;
    private static final int INDEX_REFPSDERID = 95;
    private static final int INDEX_REFPSDERNAME = 96;
    private static final int INDEX_RENDERMODE = 97;
    private static final int INDEX_RENDERMODETEXT = 98;
    private static final int INDEX_RESETITEMNAME = 99;
    private static final int INDEX_TREEITEM = 100;
    private static final int INDEX_UPDATEDATE = 101;
    private static final int INDEX_UPDATEDV = 102;
    private static final int INDEX_UPDATEDVT = 103;
    private static final int INDEX_UPDATEMAN = 104;
    private static final int INDEX_USERPARAMS = 105;
    private static final int INDEX_USERTAG = 106;
    private static final int INDEX_USERTAG2 = 107;
    private static final int INDEX_VALUEFORMAT = 108;
    private static final int INDEX_VALUEITEMNAME = 109;
    private static final int INDEX_WIDTH = 110;
    private static final int INDEX_WIDTHUNIT = 111;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEGridColBase proxyPSDEGridColBase = null;
    private boolean aggfieldDirtyFlag = false;
    private boolean aggmodeDirtyFlag = false;
    private boolean aggvalueformatDirtyFlag = false;
    private boolean alignDirtyFlag = false;
    private boolean allowemptyDirtyFlag = false;
    private boolean cappslanresidDirtyFlag = false;
    private boolean cappslanresnameDirtyFlag = false;
    private boolean captionDirtyFlag = false;
    private boolean cellpssyscssidDirtyFlag = false;
    private boolean cellpssyscssnameDirtyFlag = false;
    private boolean clconvertmodeDirtyFlag = false;
    private boolean codelistconfigmodeDirtyFlag = false;
    private boolean colenablelinkDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createdvDirtyFlag = false;
    private boolean createdvtDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean dataitemsDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean editorparamsDirtyFlag = false;
    private boolean editortypeDirtyFlag = false;
    private boolean editortypenameDirtyFlag = false;
    private boolean enablecondDirtyFlag = false;
    private boolean enableinputtipDirtyFlag = false;
    private boolean enableitemprivDirtyFlag = false;
    private boolean enablelinkDirtyFlag = false;
    private boolean enableroweditDirtyFlag = false;
    private boolean gcrpssyspfpluginidDirtyFlag = false;
    private boolean gcrpssyspfpluginnameDirtyFlag = false;
    private boolean gridcolstyleDirtyFlag = false;
    private boolean gridcoltypeDirtyFlag = false;
    private boolean groupitemDirtyFlag = false;
    private boolean headerpssyscssidDirtyFlag = false;
    private boolean headerpssyscssnameDirtyFlag = false;
    private boolean hiddendataitemDirtyFlag = false;
    private boolean hidedefaultDirtyFlag = false;
    private boolean ignoreinputDirtyFlag = false;
    private boolean linkpsdeviewidDirtyFlag = false;
    private boolean linkpsdeviewnameDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modelstateDirtyFlag = false;
    private boolean needcodelistconfigDirtyFlag = false;
    private boolean noprivdmDirtyFlag = false;
    private boolean nosortDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean phpslanresidDirtyFlag = false;
    private boolean phpslanresnameDirtyFlag = false;
    private boolean pickuppsdeviewidDirtyFlag = false;
    private boolean pickuppsdeviewnameDirtyFlag = false;
    private boolean placeholderDirtyFlag = false;
    private boolean ppsdegridcolidDirtyFlag = false;
    private boolean ppsdegridcolnameDirtyFlag = false;
    private boolean predefinedtypeDirtyFlag = false;
    private boolean predefinedtypetextDirtyFlag = false;
    private boolean preventxssDirtyFlag = false;
    private boolean previewhtmlDirtyFlag = false;
    private boolean pscodelistidDirtyFlag = false;
    private boolean pscodelistnameDirtyFlag = false;
    private boolean psdefidDirtyFlag = false;
    private boolean psdefnameDirtyFlag = false;
    private boolean psdefsfitemidDirtyFlag = false;
    private boolean psdefsfitemnameDirtyFlag = false;
    private boolean psdefuimodeidDirtyFlag = false;
    private boolean psdefuimodenameDirtyFlag = false;
    private boolean psdegeiupdateidDirtyFlag = false;
    private boolean psdegeiupdatenameDirtyFlag = false;
    private boolean psdegridcolidDirtyFlag = false;
    private boolean psdegridcolnameDirtyFlag = false;
    private boolean psdegrididDirtyFlag = false;
    private boolean psdegridnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdeuagroupidDirtyFlag = false;
    private boolean psdeuagroupnameDirtyFlag = false;
    private boolean psdeuiactionidDirtyFlag = false;
    private boolean psdeuiactionnameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pssysdictcatidDirtyFlag = false;
    private boolean pssysdictcatnameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssyseditorstyleidDirtyFlag = false;
    private boolean pssyseditorstylenameDirtyFlag = false;
    private boolean pssysimageidDirtyFlag = false;
    private boolean pssysimagenameDirtyFlag = false;
    private boolean rawservicemethodDirtyFlag = false;
    private boolean rawserviceurlDirtyFlag = false;
    private boolean refpsdeacmodeidDirtyFlag = false;
    private boolean refpsdeacmodenameDirtyFlag = false;
    private boolean refpsdedatasetidDirtyFlag = false;
    private boolean refpsdedatasetnameDirtyFlag = false;
    private boolean refpsdeidDirtyFlag = false;
    private boolean refpsdenameDirtyFlag = false;
    private boolean refpsderidDirtyFlag = false;
    private boolean refpsdernameDirtyFlag = false;
    private boolean rendermodeDirtyFlag = false;
    private boolean rendermodetextDirtyFlag = false;
    private boolean resetitemnameDirtyFlag = false;
    private boolean treeitemDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatedvDirtyFlag = false;
    private boolean updatedvtDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean valueformatDirtyFlag = false;
    private boolean valueitemnameDirtyFlag = false;
    private boolean widthDirtyFlag = false;
    private boolean widthunitDirtyFlag = false;
    @Column(name="aggfield")
    private String aggfield;
    @Column(name="aggmode")
    private String aggmode;
    @Column(name="aggvalueformat")
    private String aggvalueformat;
    @Column(name="align")
    private String align;
    @Column(name="allowempty")
    private Integer allowempty;
    @Column(name="cappslanresid")
    private String cappslanresid;
    @Column(name="cappslanresname")
    private String cappslanresname;
    @Column(name="caption")
    private String caption;
    @Column(name="cellpssyscssid")
    private String cellpssyscssid;
    @Column(name="cellpssyscssname")
    private String cellpssyscssname;
    @Column(name="clconvertmode")
    private String clconvertmode;
    @Column(name="codelistconfigmode")
    private Integer codelistconfigmode;
    @Column(name="colenablelink")
    private Integer colenablelink;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createdv")
    private String createdv;
    @Column(name="createdvt")
    private String createdvt;
    @Column(name="createman")
    private String createman;
    @Column(name="customcode")
    private String customcode;
    @Column(name="custommode")
    private Integer custommode;
    @Column(name="dataitems")
    private String dataitems;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="editorparams")
    private String editorparams;
    @Column(name="editortype")
    private String editortype;
    @Column(name="editortypename")
    private String editortypename;
    @Column(name="enablecond")
    private Integer enablecond;
    @Column(name="enableinputtip")
    private Integer enableinputtip;
    @Column(name="enableitempriv")
    private Integer enableitempriv;
    @Column(name="enablelink")
    private Integer enablelink;
    @Column(name="enablerowedit")
    private Integer enablerowedit;
    @Column(name="gcrpssyspfpluginid")
    private String gcrpssyspfpluginid;
    @Column(name="gcrpssyspfpluginname")
    private String gcrpssyspfpluginname;
    @Column(name="gridcolstyle")
    private String gridcolstyle;
    @Column(name="gridcoltype")
    private String gridcoltype;
    @Column(name="groupitem")
    private String groupitem;
    @Column(name="headerpssyscssid")
    private String headerpssyscssid;
    @Column(name="headerpssyscssname")
    private String headerpssyscssname;
    @Column(name="hiddendataitem")
    private Integer hiddendataitem;
    @Column(name="hidedefault")
    private Integer hidedefault;
    @Column(name="ignoreinput")
    private Integer ignoreinput;
    @Column(name="linkpsdeviewid")
    private String linkpsdeviewid;
    @Column(name="linkpsdeviewname")
    private String linkpsdeviewname;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="modelstate")
    private Integer modelstate;
    @Column(name="needcodelistconfig")
    private Integer needcodelistconfig;
    @Column(name="noprivdm")
    private Integer noprivdm;
    @Column(name="nosort")
    private Integer nosort;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="phpslanresid")
    private String phpslanresid;
    @Column(name="phpslanresname")
    private String phpslanresname;
    @Column(name="pickuppsdeviewid")
    private String pickuppsdeviewid;
    @Column(name="pickuppsdeviewname")
    private String pickuppsdeviewname;
    @Column(name="placeholder")
    private String placeholder;
    @Column(name="ppsdegridcolid")
    private String ppsdegridcolid;
    @Column(name="ppsdegridcolname")
    private String ppsdegridcolname;
    @Column(name="predefinedtype")
    private String predefinedtype;
    @Column(name="predefinedtypetext")
    private String predefinedtypetext;
    @Column(name="preventxss")
    private Integer preventxss;
    @Column(name="previewhtml")
    private String previewhtml;
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
    @Column(name="psdefuimodeid")
    private String psdefuimodeid;
    @Column(name="psdefuimodename")
    private String psdefuimodename;
    @Column(name="psdegeiupdateid")
    private String psdegeiupdateid;
    @Column(name="psdegeiupdatename")
    private String psdegeiupdatename;
    @Column(name="psdegridcolid")
    private String psdegridcolid;
    @Column(name="psdegridcolname")
    private String psdegridcolname;
    @Column(name="psdegridid")
    private String psdegridid;
    @Column(name="psdegridname")
    private String psdegridname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdeuagroupid")
    private String psdeuagroupid;
    @Column(name="psdeuagroupname")
    private String psdeuagroupname;
    @Column(name="psdeuiactionid")
    private String psdeuiactionid;
    @Column(name="psdeuiactionname")
    private String psdeuiactionname;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pssysdictcatid")
    private String pssysdictcatid;
    @Column(name="pssysdictcatname")
    private String pssysdictcatname;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssyseditorstyleid")
    private String pssyseditorstyleid;
    @Column(name="pssyseditorstylename")
    private String pssyseditorstylename;
    @Column(name="pssysimageid")
    private String pssysimageid;
    @Column(name="pssysimagename")
    private String pssysimagename;
    @Column(name="rawservicemethod")
    private String rawservicemethod;
    @Column(name="rawserviceurl")
    private String rawserviceurl;
    @Column(name="refpsdeacmodeid")
    private String refpsdeacmodeid;
    @Column(name="refpsdeacmodename")
    private String refpsdeacmodename;
    @Column(name="refpsdedatasetid")
    private String refpsdedatasetid;
    @Column(name="refpsdedatasetname")
    private String refpsdedatasetname;
    @Column(name="refpsdeid")
    private String refpsdeid;
    @Column(name="refpsdename")
    private String refpsdename;
    @Column(name="refpsderid")
    private String refpsderid;
    @Column(name="refpsdername")
    private String refpsdername;
    @Column(name="rendermode")
    private String rendermode;
    @Column(name="rendermodetext")
    private String rendermodetext;
    @Column(name="resetitemname")
    private String resetitemname;
    @Column(name="treeitem")
    private Integer treeitem;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updatedv")
    private String updatedv;
    @Column(name="updatedvt")
    private String updatedvt;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userparams")
    private String userparams;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="valueformat")
    private String valueformat;
    @Column(name="valueitemname")
    private String valueitemname;
    @Column(name="width")
    private Integer width;
    @Column(name="widthunit")
    private String widthunit;
    private Integer objPSCodeListLock = new Integer(1);
    private PSCodeList pscodelist = null;
    private Integer objRefPSDELock = new Integer(1);
    private PSDataEntity refpsde = null;
    private Integer objRefPSDEACModeLock = new Integer(1);
    private PSDEACMode refpsdeacmode = null;
    private Integer objRefPSDEDataSetLock = new Integer(1);
    private PSDEDataSet refpsdedataset = null;
    private Integer objPSDEFUIModeLock = new Integer(1);
    private PSDEFUIMode psdefuimode = null;
    private Integer objPSDEFLock = new Integer(1);
    private PSDEField psdef = null;
    private Integer objPSDEFSFItemLock = new Integer(1);
    private PSDEFSFItem psdefsfitem = null;
    private Integer objPSDEGEIUpdateLock = new Integer(1);
    private PSDEGEIUpdate psdegeiupdate = null;
    private Integer objPPSDEGridColLock = new Integer(1);
    private PSDEGridCol ppsdegridcol = null;
    private Integer objPSDEGridLock = new Integer(1);
    private PSDEGrid psdegrid = null;
    private Integer objRefPSDERLock = new Integer(1);
    private PSDER refpsder = null;
    private Integer objPSDEUAGroupLock = new Integer(1);
    private PSDEUAGroup psdeuagroup = null;
    private Integer objPSDEUIActionLock = new Integer(1);
    private PSDEUIAction psdeuiaction = null;
    private Integer objLinkPSDEViewLock = new Integer(1);
    private PSDEViewBase linkpsdeview = null;
    private Integer objPickupPSDEViewLock = new Integer(1);
    private PSDEViewBase pickuppsdeview = null;
    private Integer objCapPSLanResLock = new Integer(1);
    private PSLanguageRes cappslanres = null;
    private Integer objPHPSLanResLock = new Integer(1);
    private PSLanguageRes phpslanres = null;
    private Integer objCellPSSysCssLock = new Integer(1);
    private PSSysCss cellpssyscss = null;
    private Integer objHeaderPSSysCssLock = new Integer(1);
    private PSSysCss headerpssyscss = null;
    private Integer objPSSysDictCatLock = new Integer(1);
    private PSSysDictCat pssysdictcat = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysEditorStyleLock = new Integer(1);
    private PSSysEditorStyle pssyseditorstyle = null;
    private Integer objPSSysImageLock = new Integer(1);
    private PSSysImage pssysimage = null;
    private Integer objGCRPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin gcrpssyspfplugin = null;

    public void setAggField(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAggField(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aggfield = string;
        this.aggfieldDirtyFlag = true;
    }

    public String getAggField() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAggField();
        }
        return this.aggfield;
    }

    public boolean isAggFieldDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAggFieldDirty();
        }
        return this.aggfieldDirtyFlag;
    }

    public void resetAggField() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAggField();
            return;
        }
        this.aggfieldDirtyFlag = false;
        this.aggfield = null;
    }

    public void setAggMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAggMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aggmode = string;
        this.aggmodeDirtyFlag = true;
    }

    public String getAggMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAggMode();
        }
        return this.aggmode;
    }

    public boolean isAggModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAggModeDirty();
        }
        return this.aggmodeDirtyFlag;
    }

    public void resetAggMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAggMode();
            return;
        }
        this.aggmodeDirtyFlag = false;
        this.aggmode = null;
    }

    public void setAggValueFormat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAggValueFormat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aggvalueformat = string;
        this.aggvalueformatDirtyFlag = true;
    }

    public String getAggValueFormat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAggValueFormat();
        }
        return this.aggvalueformat;
    }

    public boolean isAggValueFormatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAggValueFormatDirty();
        }
        return this.aggvalueformatDirtyFlag;
    }

    public void resetAggValueFormat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAggValueFormat();
            return;
        }
        this.aggvalueformatDirtyFlag = false;
        this.aggvalueformat = null;
    }

    public void setAlign(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAlign(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.align = string;
        this.alignDirtyFlag = true;
    }

    public String getAlign() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAlign();
        }
        return this.align;
    }

    public boolean isAlignDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAlignDirty();
        }
        return this.alignDirtyFlag;
    }

    public void resetAlign() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAlign();
            return;
        }
        this.alignDirtyFlag = false;
        this.align = null;
    }

    public void setAllowEmpty(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAllowEmpty(n);
            return;
        }
        this.allowempty = n;
        this.allowemptyDirtyFlag = true;
    }

    public Integer getAllowEmpty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAllowEmpty();
        }
        return this.allowempty;
    }

    public boolean isAllowEmptyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAllowEmptyDirty();
        }
        return this.allowemptyDirtyFlag;
    }

    public void resetAllowEmpty() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAllowEmpty();
            return;
        }
        this.allowemptyDirtyFlag = false;
        this.allowempty = null;
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

    public void setCellPSSysCssId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCellPSSysCssId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cellpssyscssid = string;
        this.cellpssyscssidDirtyFlag = true;
    }

    public String getCellPSSysCssId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCellPSSysCssId();
        }
        return this.cellpssyscssid;
    }

    public boolean isCellPSSysCssIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCellPSSysCssIdDirty();
        }
        return this.cellpssyscssidDirtyFlag;
    }

    public void resetCellPSSysCssId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCellPSSysCssId();
            return;
        }
        this.cellpssyscssidDirtyFlag = false;
        this.cellpssyscssid = null;
    }

    public void setCellPSSysCssName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCellPSSysCssName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cellpssyscssname = string;
        this.cellpssyscssnameDirtyFlag = true;
    }

    public String getCellPSSysCssName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCellPSSysCssName();
        }
        return this.cellpssyscssname;
    }

    public boolean isCellPSSysCssNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCellPSSysCssNameDirty();
        }
        return this.cellpssyscssnameDirtyFlag;
    }

    public void resetCellPSSysCssName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCellPSSysCssName();
            return;
        }
        this.cellpssyscssnameDirtyFlag = false;
        this.cellpssyscssname = null;
    }

    public void setCLConvertMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCLConvertMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.clconvertmode = string;
        this.clconvertmodeDirtyFlag = true;
    }

    public String getCLConvertMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCLConvertMode();
        }
        return this.clconvertmode;
    }

    public boolean isCLConvertModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCLConvertModeDirty();
        }
        return this.clconvertmodeDirtyFlag;
    }

    public void resetCLConvertMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCLConvertMode();
            return;
        }
        this.clconvertmodeDirtyFlag = false;
        this.clconvertmode = null;
    }

    public void setCodeListConfigMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeListConfigMode(n);
            return;
        }
        this.codelistconfigmode = n;
        this.codelistconfigmodeDirtyFlag = true;
    }

    public Integer getCodeListConfigMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeListConfigMode();
        }
        return this.codelistconfigmode;
    }

    public boolean isCodeListConfigModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeListConfigModeDirty();
        }
        return this.codelistconfigmodeDirtyFlag;
    }

    public void resetCodeListConfigMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeListConfigMode();
            return;
        }
        this.codelistconfigmodeDirtyFlag = false;
        this.codelistconfigmode = null;
    }

    public void setColEnableLink(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setColEnableLink(n);
            return;
        }
        this.colenablelink = n;
        this.colenablelinkDirtyFlag = true;
    }

    public Integer getColEnableLink() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getColEnableLink();
        }
        return this.colenablelink;
    }

    public boolean isColEnableLinkDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isColEnableLinkDirty();
        }
        return this.colenablelinkDirtyFlag;
    }

    public void resetColEnableLink() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetColEnableLink();
            return;
        }
        this.colenablelinkDirtyFlag = false;
        this.colenablelink = null;
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

    public void setCreateDV(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDV(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createdv = string;
        this.createdvDirtyFlag = true;
    }

    public String getCreateDV() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateDV();
        }
        return this.createdv;
    }

    public boolean isCreateDVDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateDVDirty();
        }
        return this.createdvDirtyFlag;
    }

    public void resetCreateDV() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateDV();
            return;
        }
        this.createdvDirtyFlag = false;
        this.createdv = null;
    }

    public void setCreateDVT(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDVT(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createdvt = string;
        this.createdvtDirtyFlag = true;
    }

    public String getCreateDVT() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateDVT();
        }
        return this.createdvt;
    }

    public boolean isCreateDVTDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateDVTDirty();
        }
        return this.createdvtDirtyFlag;
    }

    public void resetCreateDVT() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateDVT();
            return;
        }
        this.createdvtDirtyFlag = false;
        this.createdvt = null;
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

    public void setCustomMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomMode(n);
            return;
        }
        this.custommode = n;
        this.custommodeDirtyFlag = true;
    }

    public Integer getCustomMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomMode();
        }
        return this.custommode;
    }

    public boolean isCustomModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomModeDirty();
        }
        return this.custommodeDirtyFlag;
    }

    public void resetCustomMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomMode();
            return;
        }
        this.custommodeDirtyFlag = false;
        this.custommode = null;
    }

    public void setDataItems(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataItems(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dataitems = string;
        this.dataitemsDirtyFlag = true;
    }

    public String getDataItems() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataItems();
        }
        return this.dataitems;
    }

    public boolean isDataItemsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataItemsDirty();
        }
        return this.dataitemsDirtyFlag;
    }

    public void resetDataItems() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataItems();
            return;
        }
        this.dataitemsDirtyFlag = false;
        this.dataitems = null;
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

    public void setEnableCond(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableCond(n);
            return;
        }
        this.enablecond = n;
        this.enablecondDirtyFlag = true;
    }

    public Integer getEnableCond() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableCond();
        }
        return this.enablecond;
    }

    public boolean isEnableCondDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableCondDirty();
        }
        return this.enablecondDirtyFlag;
    }

    public void resetEnableCond() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableCond();
            return;
        }
        this.enablecondDirtyFlag = false;
        this.enablecond = null;
    }

    public void setEnableInputTip(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableInputTip(n);
            return;
        }
        this.enableinputtip = n;
        this.enableinputtipDirtyFlag = true;
    }

    public Integer getEnableInputTip() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableInputTip();
        }
        return this.enableinputtip;
    }

    public boolean isEnableInputTipDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableInputTipDirty();
        }
        return this.enableinputtipDirtyFlag;
    }

    public void resetEnableInputTip() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableInputTip();
            return;
        }
        this.enableinputtipDirtyFlag = false;
        this.enableinputtip = null;
    }

    public void setEnableItemPriv(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableItemPriv(n);
            return;
        }
        this.enableitempriv = n;
        this.enableitemprivDirtyFlag = true;
    }

    public Integer getEnableItemPriv() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableItemPriv();
        }
        return this.enableitempriv;
    }

    public boolean isEnableItemPrivDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableItemPrivDirty();
        }
        return this.enableitemprivDirtyFlag;
    }

    public void resetEnableItemPriv() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableItemPriv();
            return;
        }
        this.enableitemprivDirtyFlag = false;
        this.enableitempriv = null;
    }

    public void setEnableLink(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableLink(n);
            return;
        }
        this.enablelink = n;
        this.enablelinkDirtyFlag = true;
    }

    public Integer getEnableLink() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableLink();
        }
        return this.enablelink;
    }

    public boolean isEnableLinkDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableLinkDirty();
        }
        return this.enablelinkDirtyFlag;
    }

    public void resetEnableLink() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableLink();
            return;
        }
        this.enablelinkDirtyFlag = false;
        this.enablelink = null;
    }

    public void setEnableRowEdit(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableRowEdit(n);
            return;
        }
        this.enablerowedit = n;
        this.enableroweditDirtyFlag = true;
    }

    public Integer getEnableRowEdit() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableRowEdit();
        }
        return this.enablerowedit;
    }

    public boolean isEnableRowEditDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableRowEditDirty();
        }
        return this.enableroweditDirtyFlag;
    }

    public void resetEnableRowEdit() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableRowEdit();
            return;
        }
        this.enableroweditDirtyFlag = false;
        this.enablerowedit = null;
    }

    public void setGCRPSSysPFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGCRPSSysPFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.gcrpssyspfpluginid = string;
        this.gcrpssyspfpluginidDirtyFlag = true;
    }

    public String getGCRPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGCRPSSysPFPluginId();
        }
        return this.gcrpssyspfpluginid;
    }

    public boolean isGCRPSSysPFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGCRPSSysPFPluginIdDirty();
        }
        return this.gcrpssyspfpluginidDirtyFlag;
    }

    public void resetGCRPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGCRPSSysPFPluginId();
            return;
        }
        this.gcrpssyspfpluginidDirtyFlag = false;
        this.gcrpssyspfpluginid = null;
    }

    public void setGCRPSSysPFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGCRPSSysPFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.gcrpssyspfpluginname = string;
        this.gcrpssyspfpluginnameDirtyFlag = true;
    }

    public String getGCRPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGCRPSSysPFPluginName();
        }
        return this.gcrpssyspfpluginname;
    }

    public boolean isGCRPSSysPFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGCRPSSysPFPluginNameDirty();
        }
        return this.gcrpssyspfpluginnameDirtyFlag;
    }

    public void resetGCRPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGCRPSSysPFPluginName();
            return;
        }
        this.gcrpssyspfpluginnameDirtyFlag = false;
        this.gcrpssyspfpluginname = null;
    }

    public void setGridColStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGridColStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.gridcolstyle = string;
        this.gridcolstyleDirtyFlag = true;
    }

    public String getGridColStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGridColStyle();
        }
        return this.gridcolstyle;
    }

    public boolean isGridColStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGridColStyleDirty();
        }
        return this.gridcolstyleDirtyFlag;
    }

    public void resetGridColStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGridColStyle();
            return;
        }
        this.gridcolstyleDirtyFlag = false;
        this.gridcolstyle = null;
    }

    public void setGridColType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGridColType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.gridcoltype = string;
        this.gridcoltypeDirtyFlag = true;
    }

    public String getGridColType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGridColType();
        }
        return this.gridcoltype;
    }

    public boolean isGridColTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGridColTypeDirty();
        }
        return this.gridcoltypeDirtyFlag;
    }

    public void resetGridColType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGridColType();
            return;
        }
        this.gridcoltypeDirtyFlag = false;
        this.gridcoltype = null;
    }

    public void setGroupItem(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupItem(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.groupitem = string;
        this.groupitemDirtyFlag = true;
    }

    public String getGroupItem() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupItem();
        }
        return this.groupitem;
    }

    public boolean isGroupItemDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupItemDirty();
        }
        return this.groupitemDirtyFlag;
    }

    public void resetGroupItem() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupItem();
            return;
        }
        this.groupitemDirtyFlag = false;
        this.groupitem = null;
    }

    public void setHeaderPSSysCssId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHeaderPSSysCssId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.headerpssyscssid = string;
        this.headerpssyscssidDirtyFlag = true;
    }

    public String getHeaderPSSysCssId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHeaderPSSysCssId();
        }
        return this.headerpssyscssid;
    }

    public boolean isHeaderPSSysCssIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHeaderPSSysCssIdDirty();
        }
        return this.headerpssyscssidDirtyFlag;
    }

    public void resetHeaderPSSysCssId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHeaderPSSysCssId();
            return;
        }
        this.headerpssyscssidDirtyFlag = false;
        this.headerpssyscssid = null;
    }

    public void setHeaderPSSysCssName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHeaderPSSysCssName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.headerpssyscssname = string;
        this.headerpssyscssnameDirtyFlag = true;
    }

    public String getHeaderPSSysCssName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHeaderPSSysCssName();
        }
        return this.headerpssyscssname;
    }

    public boolean isHeaderPSSysCssNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHeaderPSSysCssNameDirty();
        }
        return this.headerpssyscssnameDirtyFlag;
    }

    public void resetHeaderPSSysCssName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHeaderPSSysCssName();
            return;
        }
        this.headerpssyscssnameDirtyFlag = false;
        this.headerpssyscssname = null;
    }

    public void setHiddenDataItem(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHiddenDataItem(n);
            return;
        }
        this.hiddendataitem = n;
        this.hiddendataitemDirtyFlag = true;
    }

    public Integer getHiddenDataItem() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHiddenDataItem();
        }
        return this.hiddendataitem;
    }

    public boolean isHiddenDataItemDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHiddenDataItemDirty();
        }
        return this.hiddendataitemDirtyFlag;
    }

    public void resetHiddenDataItem() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHiddenDataItem();
            return;
        }
        this.hiddendataitemDirtyFlag = false;
        this.hiddendataitem = null;
    }

    public void setHideDefault(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHideDefault(n);
            return;
        }
        this.hidedefault = n;
        this.hidedefaultDirtyFlag = true;
    }

    public Integer getHideDefault() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHideDefault();
        }
        return this.hidedefault;
    }

    public boolean isHideDefaultDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHideDefaultDirty();
        }
        return this.hidedefaultDirtyFlag;
    }

    public void resetHideDefault() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHideDefault();
            return;
        }
        this.hidedefaultDirtyFlag = false;
        this.hidedefault = null;
    }

    public void setIgnoreInput(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIgnoreInput(n);
            return;
        }
        this.ignoreinput = n;
        this.ignoreinputDirtyFlag = true;
    }

    public Integer getIgnoreInput() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIgnoreInput();
        }
        return this.ignoreinput;
    }

    public boolean isIgnoreInputDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIgnoreInputDirty();
        }
        return this.ignoreinputDirtyFlag;
    }

    public void resetIgnoreInput() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIgnoreInput();
            return;
        }
        this.ignoreinputDirtyFlag = false;
        this.ignoreinput = null;
    }

    public void setLinkPSDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLinkPSDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.linkpsdeviewid = string;
        this.linkpsdeviewidDirtyFlag = true;
    }

    public String getLinkPSDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkPSDEViewId();
        }
        return this.linkpsdeviewid;
    }

    public boolean isLinkPSDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLinkPSDEViewIdDirty();
        }
        return this.linkpsdeviewidDirtyFlag;
    }

    public void resetLinkPSDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLinkPSDEViewId();
            return;
        }
        this.linkpsdeviewidDirtyFlag = false;
        this.linkpsdeviewid = null;
    }

    public void setLinkPSDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLinkPSDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.linkpsdeviewname = string;
        this.linkpsdeviewnameDirtyFlag = true;
    }

    public String getLinkPSDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkPSDEViewName();
        }
        return this.linkpsdeviewname;
    }

    public boolean isLinkPSDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLinkPSDEViewNameDirty();
        }
        return this.linkpsdeviewnameDirtyFlag;
    }

    public void resetLinkPSDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLinkPSDEViewName();
            return;
        }
        this.linkpsdeviewnameDirtyFlag = false;
        this.linkpsdeviewname = null;
    }

    public void setLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicname = string;
        this.logicnameDirtyFlag = true;
    }

    public String getLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicName();
        }
        return this.logicname;
    }

    public boolean isLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicNameDirty();
        }
        return this.logicnameDirtyFlag;
    }

    public void resetLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicName();
            return;
        }
        this.logicnameDirtyFlag = false;
        this.logicname = null;
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

    public void setModelState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelState(n);
            return;
        }
        this.modelstate = n;
        this.modelstateDirtyFlag = true;
    }

    public Integer getModelState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelState();
        }
        return this.modelstate;
    }

    public boolean isModelStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelStateDirty();
        }
        return this.modelstateDirtyFlag;
    }

    public void resetModelState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelState();
            return;
        }
        this.modelstateDirtyFlag = false;
        this.modelstate = null;
    }

    public void setNeedCodeListConfig(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNeedCodeListConfig(n);
            return;
        }
        this.needcodelistconfig = n;
        this.needcodelistconfigDirtyFlag = true;
    }

    public Integer getNeedCodeListConfig() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNeedCodeListConfig();
        }
        return this.needcodelistconfig;
    }

    public boolean isNeedCodeListConfigDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNeedCodeListConfigDirty();
        }
        return this.needcodelistconfigDirtyFlag;
    }

    public void resetNeedCodeListConfig() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNeedCodeListConfig();
            return;
        }
        this.needcodelistconfigDirtyFlag = false;
        this.needcodelistconfig = null;
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

    public void setNoSort(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNoSort(n);
            return;
        }
        this.nosort = n;
        this.nosortDirtyFlag = true;
    }

    public Integer getNoSort() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNoSort();
        }
        return this.nosort;
    }

    public boolean isNoSortDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNoSortDirty();
        }
        return this.nosortDirtyFlag;
    }

    public void resetNoSort() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNoSort();
            return;
        }
        this.nosortDirtyFlag = false;
        this.nosort = null;
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

    public void setPickupPSDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPickupPSDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pickuppsdeviewid = string;
        this.pickuppsdeviewidDirtyFlag = true;
    }

    public String getPickupPSDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPickupPSDEViewId();
        }
        return this.pickuppsdeviewid;
    }

    public boolean isPickupPSDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPickupPSDEViewIdDirty();
        }
        return this.pickuppsdeviewidDirtyFlag;
    }

    public void resetPickupPSDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPickupPSDEViewId();
            return;
        }
        this.pickuppsdeviewidDirtyFlag = false;
        this.pickuppsdeviewid = null;
    }

    public void setPickupPSDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPickupPSDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pickuppsdeviewname = string;
        this.pickuppsdeviewnameDirtyFlag = true;
    }

    public String getPickupPSDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPickupPSDEViewName();
        }
        return this.pickuppsdeviewname;
    }

    public boolean isPickupPSDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPickupPSDEViewNameDirty();
        }
        return this.pickuppsdeviewnameDirtyFlag;
    }

    public void resetPickupPSDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPickupPSDEViewName();
            return;
        }
        this.pickuppsdeviewnameDirtyFlag = false;
        this.pickuppsdeviewname = null;
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

    public void setPPSDEGridColId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDEGridColId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdegridcolid = string;
        this.ppsdegridcolidDirtyFlag = true;
    }

    public String getPPSDEGridColId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDEGridColId();
        }
        return this.ppsdegridcolid;
    }

    public boolean isPPSDEGridColIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDEGridColIdDirty();
        }
        return this.ppsdegridcolidDirtyFlag;
    }

    public void resetPPSDEGridColId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDEGridColId();
            return;
        }
        this.ppsdegridcolidDirtyFlag = false;
        this.ppsdegridcolid = null;
    }

    public void setPPSDEGridColName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDEGridColName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdegridcolname = string;
        this.ppsdegridcolnameDirtyFlag = true;
    }

    public String getPPSDEGridColName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDEGridColName();
        }
        return this.ppsdegridcolname;
    }

    public boolean isPPSDEGridColNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDEGridColNameDirty();
        }
        return this.ppsdegridcolnameDirtyFlag;
    }

    public void resetPPSDEGridColName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDEGridColName();
            return;
        }
        this.ppsdegridcolnameDirtyFlag = false;
        this.ppsdegridcolname = null;
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

    public void setPSDEFUIModeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFUIModeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefuimodeid = string;
        this.psdefuimodeidDirtyFlag = true;
    }

    public String getPSDEFUIModeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFUIModeId();
        }
        return this.psdefuimodeid;
    }

    public boolean isPSDEFUIModeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFUIModeIdDirty();
        }
        return this.psdefuimodeidDirtyFlag;
    }

    public void resetPSDEFUIModeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFUIModeId();
            return;
        }
        this.psdefuimodeidDirtyFlag = false;
        this.psdefuimodeid = null;
    }

    public void setPSDEFUIModeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFUIModeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefuimodename = string;
        this.psdefuimodenameDirtyFlag = true;
    }

    public String getPSDEFUIModeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFUIModeName();
        }
        return this.psdefuimodename;
    }

    public boolean isPSDEFUIModeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFUIModeNameDirty();
        }
        return this.psdefuimodenameDirtyFlag;
    }

    public void resetPSDEFUIModeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFUIModeName();
            return;
        }
        this.psdefuimodenameDirtyFlag = false;
        this.psdefuimodename = null;
    }

    public void setPSDEGEIUpdateId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGEIUpdateId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegeiupdateid = string;
        this.psdegeiupdateidDirtyFlag = true;
    }

    public String getPSDEGEIUpdateId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGEIUpdateId();
        }
        return this.psdegeiupdateid;
    }

    public boolean isPSDEGEIUpdateIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGEIUpdateIdDirty();
        }
        return this.psdegeiupdateidDirtyFlag;
    }

    public void resetPSDEGEIUpdateId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGEIUpdateId();
            return;
        }
        this.psdegeiupdateidDirtyFlag = false;
        this.psdegeiupdateid = null;
    }

    public void setPSDEGEIUpdateName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGEIUpdateName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegeiupdatename = string;
        this.psdegeiupdatenameDirtyFlag = true;
    }

    public String getPSDEGEIUpdateName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGEIUpdateName();
        }
        return this.psdegeiupdatename;
    }

    public boolean isPSDEGEIUpdateNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGEIUpdateNameDirty();
        }
        return this.psdegeiupdatenameDirtyFlag;
    }

    public void resetPSDEGEIUpdateName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGEIUpdateName();
            return;
        }
        this.psdegeiupdatenameDirtyFlag = false;
        this.psdegeiupdatename = null;
    }

    public void setPSDEGridColId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGridColId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegridcolid = string;
        this.psdegridcolidDirtyFlag = true;
    }

    public String getPSDEGridColId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGridColId();
        }
        return this.psdegridcolid;
    }

    public boolean isPSDEGridColIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGridColIdDirty();
        }
        return this.psdegridcolidDirtyFlag;
    }

    public void resetPSDEGridColId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGridColId();
            return;
        }
        this.psdegridcolidDirtyFlag = false;
        this.psdegridcolid = null;
    }

    public void setPSDEGridColName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGridColName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegridcolname = string;
        this.psdegridcolnameDirtyFlag = true;
    }

    public String getPSDEGridColName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGridColName();
        }
        return this.psdegridcolname;
    }

    public boolean isPSDEGridColNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGridColNameDirty();
        }
        return this.psdegridcolnameDirtyFlag;
    }

    public void resetPSDEGridColName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGridColName();
            return;
        }
        this.psdegridcolnameDirtyFlag = false;
        this.psdegridcolname = null;
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

    public void setPSDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynainstid = string;
        this.psdynainstidDirtyFlag = true;
    }

    public String getPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstId();
        }
        return this.psdynainstid;
    }

    public boolean isPSDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstIdDirty();
        }
        return this.psdynainstidDirtyFlag;
    }

    public void resetPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstId();
            return;
        }
        this.psdynainstidDirtyFlag = false;
        this.psdynainstid = null;
    }

    public void setPSSysDictCatId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDictCatId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdictcatid = string;
        this.pssysdictcatidDirtyFlag = true;
    }

    public String getPSSysDictCatId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDictCatId();
        }
        return this.pssysdictcatid;
    }

    public boolean isPSSysDictCatIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDictCatIdDirty();
        }
        return this.pssysdictcatidDirtyFlag;
    }

    public void resetPSSysDictCatId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDictCatId();
            return;
        }
        this.pssysdictcatidDirtyFlag = false;
        this.pssysdictcatid = null;
    }

    public void setPSSysDictCatName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDictCatName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdictcatname = string;
        this.pssysdictcatnameDirtyFlag = true;
    }

    public String getPSSysDictCatName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDictCatName();
        }
        return this.pssysdictcatname;
    }

    public boolean isPSSysDictCatNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDictCatNameDirty();
        }
        return this.pssysdictcatnameDirtyFlag;
    }

    public void resetPSSysDictCatName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDictCatName();
            return;
        }
        this.pssysdictcatnameDirtyFlag = false;
        this.pssysdictcatname = null;
    }

    public void setPSSysDynaModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelid = string;
        this.pssysdynamodelidDirtyFlag = true;
    }

    public String getPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelId();
        }
        return this.pssysdynamodelid;
    }

    public boolean isPSSysDynaModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelIdDirty();
        }
        return this.pssysdynamodelidDirtyFlag;
    }

    public void resetPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelId();
            return;
        }
        this.pssysdynamodelidDirtyFlag = false;
        this.pssysdynamodelid = null;
    }

    public void setPSSysDynaModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelname = string;
        this.pssysdynamodelnameDirtyFlag = true;
    }

    public String getPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelName();
        }
        return this.pssysdynamodelname;
    }

    public boolean isPSSysDynaModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelNameDirty();
        }
        return this.pssysdynamodelnameDirtyFlag;
    }

    public void resetPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelName();
            return;
        }
        this.pssysdynamodelnameDirtyFlag = false;
        this.pssysdynamodelname = null;
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

    public void setRefPSDEACModeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDEACModeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdeacmodeid = string;
        this.refpsdeacmodeidDirtyFlag = true;
    }

    public String getRefPSDEACModeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDEACModeId();
        }
        return this.refpsdeacmodeid;
    }

    public boolean isRefPSDEACModeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDEACModeIdDirty();
        }
        return this.refpsdeacmodeidDirtyFlag;
    }

    public void resetRefPSDEACModeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDEACModeId();
            return;
        }
        this.refpsdeacmodeidDirtyFlag = false;
        this.refpsdeacmodeid = null;
    }

    public void setRefPSDEACModeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDEACModeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdeacmodename = string;
        this.refpsdeacmodenameDirtyFlag = true;
    }

    public String getRefPSDEACModeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDEACModeName();
        }
        return this.refpsdeacmodename;
    }

    public boolean isRefPSDEACModeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDEACModeNameDirty();
        }
        return this.refpsdeacmodenameDirtyFlag;
    }

    public void resetRefPSDEACModeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDEACModeName();
            return;
        }
        this.refpsdeacmodenameDirtyFlag = false;
        this.refpsdeacmodename = null;
    }

    public void setRefPSDEDataSetId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDEDataSetId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdedatasetid = string;
        this.refpsdedatasetidDirtyFlag = true;
    }

    public String getRefPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDEDataSetId();
        }
        return this.refpsdedatasetid;
    }

    public boolean isRefPSDEDataSetIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDEDataSetIdDirty();
        }
        return this.refpsdedatasetidDirtyFlag;
    }

    public void resetRefPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDEDataSetId();
            return;
        }
        this.refpsdedatasetidDirtyFlag = false;
        this.refpsdedatasetid = null;
    }

    public void setRefPSDEDataSetName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDEDataSetName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdedatasetname = string;
        this.refpsdedatasetnameDirtyFlag = true;
    }

    public String getRefPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDEDataSetName();
        }
        return this.refpsdedatasetname;
    }

    public boolean isRefPSDEDataSetNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDEDataSetNameDirty();
        }
        return this.refpsdedatasetnameDirtyFlag;
    }

    public void resetRefPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDEDataSetName();
            return;
        }
        this.refpsdedatasetnameDirtyFlag = false;
        this.refpsdedatasetname = null;
    }

    public void setRefPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdeid = string;
        this.refpsdeidDirtyFlag = true;
    }

    public String getRefPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDEId();
        }
        return this.refpsdeid;
    }

    public boolean isRefPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDEIdDirty();
        }
        return this.refpsdeidDirtyFlag;
    }

    public void resetRefPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDEId();
            return;
        }
        this.refpsdeidDirtyFlag = false;
        this.refpsdeid = null;
    }

    public void setRefPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdename = string;
        this.refpsdenameDirtyFlag = true;
    }

    public String getRefPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDEName();
        }
        return this.refpsdename;
    }

    public boolean isRefPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDENameDirty();
        }
        return this.refpsdenameDirtyFlag;
    }

    public void resetRefPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDEName();
            return;
        }
        this.refpsdenameDirtyFlag = false;
        this.refpsdename = null;
    }

    public void setRefPSDERId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDERId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsderid = string;
        this.refpsderidDirtyFlag = true;
    }

    public String getRefPSDERId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDERId();
        }
        return this.refpsderid;
    }

    public boolean isRefPSDERIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDERIdDirty();
        }
        return this.refpsderidDirtyFlag;
    }

    public void resetRefPSDERId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDERId();
            return;
        }
        this.refpsderidDirtyFlag = false;
        this.refpsderid = null;
    }

    public void setRefPSDERName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDERName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdername = string;
        this.refpsdernameDirtyFlag = true;
    }

    public String getRefPSDERName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDERName();
        }
        return this.refpsdername;
    }

    public boolean isRefPSDERNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDERNameDirty();
        }
        return this.refpsdernameDirtyFlag;
    }

    public void resetRefPSDERName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDERName();
            return;
        }
        this.refpsdernameDirtyFlag = false;
        this.refpsdername = null;
    }

    public void setRenderMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRenderMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rendermode = string;
        this.rendermodeDirtyFlag = true;
    }

    public String getRenderMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRenderMode();
        }
        return this.rendermode;
    }

    public boolean isRenderModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRenderModeDirty();
        }
        return this.rendermodeDirtyFlag;
    }

    public void resetRenderMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRenderMode();
            return;
        }
        this.rendermodeDirtyFlag = false;
        this.rendermode = null;
    }

    public void setRenderModeText(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRenderModeText(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rendermodetext = string;
        this.rendermodetextDirtyFlag = true;
    }

    public String getRenderModeText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRenderModeText();
        }
        return this.rendermodetext;
    }

    public boolean isRenderModeTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRenderModeTextDirty();
        }
        return this.rendermodetextDirtyFlag;
    }

    public void resetRenderModeText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRenderModeText();
            return;
        }
        this.rendermodetextDirtyFlag = false;
        this.rendermodetext = null;
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

    public void setTreeItem(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTreeItem(n);
            return;
        }
        this.treeitem = n;
        this.treeitemDirtyFlag = true;
    }

    public Integer getTreeItem() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTreeItem();
        }
        return this.treeitem;
    }

    public boolean isTreeItemDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTreeItemDirty();
        }
        return this.treeitemDirtyFlag;
    }

    public void resetTreeItem() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTreeItem();
            return;
        }
        this.treeitemDirtyFlag = false;
        this.treeitem = null;
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

    public void setUpdateDV(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDV(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.updatedv = string;
        this.updatedvDirtyFlag = true;
    }

    public String getUpdateDV() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateDV();
        }
        return this.updatedv;
    }

    public boolean isUpdateDVDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateDVDirty();
        }
        return this.updatedvDirtyFlag;
    }

    public void resetUpdateDV() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateDV();
            return;
        }
        this.updatedvDirtyFlag = false;
        this.updatedv = null;
    }

    public void setUpdateDVT(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDVT(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.updatedvt = string;
        this.updatedvtDirtyFlag = true;
    }

    public String getUpdateDVT() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateDVT();
        }
        return this.updatedvt;
    }

    public boolean isUpdateDVTDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateDVTDirty();
        }
        return this.updatedvtDirtyFlag;
    }

    public void resetUpdateDVT() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateDVT();
            return;
        }
        this.updatedvtDirtyFlag = false;
        this.updatedvt = null;
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

    public void setValueFormat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValueFormat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.valueformat = string;
        this.valueformatDirtyFlag = true;
    }

    public String getValueFormat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValueFormat();
        }
        return this.valueformat;
    }

    public boolean isValueFormatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValueFormatDirty();
        }
        return this.valueformatDirtyFlag;
    }

    public void resetValueFormat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValueFormat();
            return;
        }
        this.valueformatDirtyFlag = false;
        this.valueformat = null;
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

    public void setWidthUnit(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWidthUnit(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.widthunit = string;
        this.widthunitDirtyFlag = true;
    }

    public String getWidthUnit() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWidthUnit();
        }
        return this.widthunit;
    }

    public boolean isWidthUnitDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWidthUnitDirty();
        }
        return this.widthunitDirtyFlag;
    }

    public void resetWidthUnit() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWidthUnit();
            return;
        }
        this.widthunitDirtyFlag = false;
        this.widthunit = null;
    }

    protected void onReset() {
        PSDEGridColBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEGridColBase pSDEGridColBase) {
        pSDEGridColBase.resetAggField();
        pSDEGridColBase.resetAggMode();
        pSDEGridColBase.resetAggValueFormat();
        pSDEGridColBase.resetAlign();
        pSDEGridColBase.resetAllowEmpty();
        pSDEGridColBase.resetCapPSLanResId();
        pSDEGridColBase.resetCapPSLanResName();
        pSDEGridColBase.resetCaption();
        pSDEGridColBase.resetCellPSSysCssId();
        pSDEGridColBase.resetCellPSSysCssName();
        pSDEGridColBase.resetCLConvertMode();
        pSDEGridColBase.resetCodeListConfigMode();
        pSDEGridColBase.resetColEnableLink();
        pSDEGridColBase.resetCreateDate();
        pSDEGridColBase.resetCreateDV();
        pSDEGridColBase.resetCreateDVT();
        pSDEGridColBase.resetCreateMan();
        pSDEGridColBase.resetCustomCode();
        pSDEGridColBase.resetCustomMode();
        pSDEGridColBase.resetDataItems();
        pSDEGridColBase.resetDynaModelFlag();
        pSDEGridColBase.resetEditorParams();
        pSDEGridColBase.resetEditorType();
        pSDEGridColBase.resetEditorTypeName();
        pSDEGridColBase.resetEnableCond();
        pSDEGridColBase.resetEnableInputTip();
        pSDEGridColBase.resetEnableItemPriv();
        pSDEGridColBase.resetEnableLink();
        pSDEGridColBase.resetEnableRowEdit();
        pSDEGridColBase.resetGCRPSSysPFPluginId();
        pSDEGridColBase.resetGCRPSSysPFPluginName();
        pSDEGridColBase.resetGridColStyle();
        pSDEGridColBase.resetGridColType();
        pSDEGridColBase.resetGroupItem();
        pSDEGridColBase.resetHeaderPSSysCssId();
        pSDEGridColBase.resetHeaderPSSysCssName();
        pSDEGridColBase.resetHiddenDataItem();
        pSDEGridColBase.resetHideDefault();
        pSDEGridColBase.resetIgnoreInput();
        pSDEGridColBase.resetLinkPSDEViewId();
        pSDEGridColBase.resetLinkPSDEViewName();
        pSDEGridColBase.resetLogicName();
        pSDEGridColBase.resetMemo();
        pSDEGridColBase.resetModelState();
        pSDEGridColBase.resetNeedCodeListConfig();
        pSDEGridColBase.resetNoPrivDM();
        pSDEGridColBase.resetNoSort();
        pSDEGridColBase.resetOrderValue();
        pSDEGridColBase.resetPHPSLanResId();
        pSDEGridColBase.resetPHPSLanResName();
        pSDEGridColBase.resetPickupPSDEViewId();
        pSDEGridColBase.resetPickupPSDEViewName();
        pSDEGridColBase.resetPlaceHolder();
        pSDEGridColBase.resetPPSDEGridColId();
        pSDEGridColBase.resetPPSDEGridColName();
        pSDEGridColBase.resetPredefinedType();
        pSDEGridColBase.resetPredefinedTypeText();
        pSDEGridColBase.resetPreventXSS();
        pSDEGridColBase.resetPreviewHtml();
        pSDEGridColBase.resetPSCodeListId();
        pSDEGridColBase.resetPSCodeListName();
        pSDEGridColBase.resetPSDEFId();
        pSDEGridColBase.resetPSDEFName();
        pSDEGridColBase.resetPSDEFSFItemId();
        pSDEGridColBase.resetPSDEFSFItemName();
        pSDEGridColBase.resetPSDEFUIModeId();
        pSDEGridColBase.resetPSDEFUIModeName();
        pSDEGridColBase.resetPSDEGEIUpdateId();
        pSDEGridColBase.resetPSDEGEIUpdateName();
        pSDEGridColBase.resetPSDEGridColId();
        pSDEGridColBase.resetPSDEGridColName();
        pSDEGridColBase.resetPSDEGridId();
        pSDEGridColBase.resetPSDEGridName();
        pSDEGridColBase.resetPSDEId();
        pSDEGridColBase.resetPSDEUAGroupId();
        pSDEGridColBase.resetPSDEUAGroupName();
        pSDEGridColBase.resetPSDEUIActionId();
        pSDEGridColBase.resetPSDEUIActionName();
        pSDEGridColBase.resetPSDynaInstId();
        pSDEGridColBase.resetPSSysDictCatId();
        pSDEGridColBase.resetPSSysDictCatName();
        pSDEGridColBase.resetPSSysDynaModelId();
        pSDEGridColBase.resetPSSysDynaModelName();
        pSDEGridColBase.resetPSSysEditorStyleId();
        pSDEGridColBase.resetPSSysEditorStyleName();
        pSDEGridColBase.resetPSSysImageId();
        pSDEGridColBase.resetPSSysImageName();
        pSDEGridColBase.resetRawServiceMethod();
        pSDEGridColBase.resetRawServiceUrl();
        pSDEGridColBase.resetRefPSDEACModeId();
        pSDEGridColBase.resetRefPSDEACModeName();
        pSDEGridColBase.resetRefPSDEDataSetId();
        pSDEGridColBase.resetRefPSDEDataSetName();
        pSDEGridColBase.resetRefPSDEId();
        pSDEGridColBase.resetRefPSDEName();
        pSDEGridColBase.resetRefPSDERId();
        pSDEGridColBase.resetRefPSDERName();
        pSDEGridColBase.resetRenderMode();
        pSDEGridColBase.resetRenderModeText();
        pSDEGridColBase.resetResetItemName();
        pSDEGridColBase.resetTreeItem();
        pSDEGridColBase.resetUpdateDate();
        pSDEGridColBase.resetUpdateDV();
        pSDEGridColBase.resetUpdateDVT();
        pSDEGridColBase.resetUpdateMan();
        pSDEGridColBase.resetUserParams();
        pSDEGridColBase.resetUserTag();
        pSDEGridColBase.resetUserTag2();
        pSDEGridColBase.resetValueFormat();
        pSDEGridColBase.resetValueItemName();
        pSDEGridColBase.resetWidth();
        pSDEGridColBase.resetWidthUnit();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAggFieldDirty()) {
            hashMap.put(FIELD_AGGFIELD, this.getAggField());
        }
        if (!bl || this.isAggModeDirty()) {
            hashMap.put(FIELD_AGGMODE, this.getAggMode());
        }
        if (!bl || this.isAggValueFormatDirty()) {
            hashMap.put(FIELD_AGGVALUEFORMAT, this.getAggValueFormat());
        }
        if (!bl || this.isAlignDirty()) {
            hashMap.put(FIELD_ALIGN, this.getAlign());
        }
        if (!bl || this.isAllowEmptyDirty()) {
            hashMap.put(FIELD_ALLOWEMPTY, this.getAllowEmpty());
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
        if (!bl || this.isCellPSSysCssIdDirty()) {
            hashMap.put(FIELD_CELLPSSYSCSSID, this.getCellPSSysCssId());
        }
        if (!bl || this.isCellPSSysCssNameDirty()) {
            hashMap.put(FIELD_CELLPSSYSCSSNAME, this.getCellPSSysCssName());
        }
        if (!bl || this.isCLConvertModeDirty()) {
            hashMap.put(FIELD_CLCONVERTMODE, this.getCLConvertMode());
        }
        if (!bl || this.isCodeListConfigModeDirty()) {
            hashMap.put(FIELD_CODELISTCONFIGMODE, this.getCodeListConfigMode());
        }
        if (!bl || this.isColEnableLinkDirty()) {
            hashMap.put(FIELD_COLENABLELINK, this.getColEnableLink());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateDVDirty()) {
            hashMap.put(FIELD_CREATEDV, this.getCreateDV());
        }
        if (!bl || this.isCreateDVTDirty()) {
            hashMap.put(FIELD_CREATEDVT, this.getCreateDVT());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCustomCodeDirty()) {
            hashMap.put(FIELD_CUSTOMCODE, this.getCustomCode());
        }
        if (!bl || this.isCustomModeDirty()) {
            hashMap.put(FIELD_CUSTOMMODE, this.getCustomMode());
        }
        if (!bl || this.isDataItemsDirty()) {
            hashMap.put(FIELD_DATAITEMS, this.getDataItems());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
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
        if (!bl || this.isEnableCondDirty()) {
            hashMap.put(FIELD_ENABLECOND, this.getEnableCond());
        }
        if (!bl || this.isEnableInputTipDirty()) {
            hashMap.put(FIELD_ENABLEINPUTTIP, this.getEnableInputTip());
        }
        if (!bl || this.isEnableItemPrivDirty()) {
            hashMap.put(FIELD_ENABLEITEMPRIV, this.getEnableItemPriv());
        }
        if (!bl || this.isEnableLinkDirty()) {
            hashMap.put(FIELD_ENABLELINK, this.getEnableLink());
        }
        if (!bl || this.isEnableRowEditDirty()) {
            hashMap.put(FIELD_ENABLEROWEDIT, this.getEnableRowEdit());
        }
        if (!bl || this.isGCRPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_GCRPSSYSPFPLUGINID, this.getGCRPSSysPFPluginId());
        }
        if (!bl || this.isGCRPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_GCRPSSYSPFPLUGINNAME, this.getGCRPSSysPFPluginName());
        }
        if (!bl || this.isGridColStyleDirty()) {
            hashMap.put(FIELD_GRIDCOLSTYLE, this.getGridColStyle());
        }
        if (!bl || this.isGridColTypeDirty()) {
            hashMap.put(FIELD_GRIDCOLTYPE, this.getGridColType());
        }
        if (!bl || this.isGroupItemDirty()) {
            hashMap.put(FIELD_GROUPITEM, this.getGroupItem());
        }
        if (!bl || this.isHeaderPSSysCssIdDirty()) {
            hashMap.put(FIELD_HEADERPSSYSCSSID, this.getHeaderPSSysCssId());
        }
        if (!bl || this.isHeaderPSSysCssNameDirty()) {
            hashMap.put(FIELD_HEADERPSSYSCSSNAME, this.getHeaderPSSysCssName());
        }
        if (!bl || this.isHiddenDataItemDirty()) {
            hashMap.put(FIELD_HIDDENDATAITEM, this.getHiddenDataItem());
        }
        if (!bl || this.isHideDefaultDirty()) {
            hashMap.put(FIELD_HIDEDEFAULT, this.getHideDefault());
        }
        if (!bl || this.isIgnoreInputDirty()) {
            hashMap.put(FIELD_IGNOREINPUT, this.getIgnoreInput());
        }
        if (!bl || this.isLinkPSDEViewIdDirty()) {
            hashMap.put(FIELD_LINKPSDEVIEWID, this.getLinkPSDEViewId());
        }
        if (!bl || this.isLinkPSDEViewNameDirty()) {
            hashMap.put(FIELD_LINKPSDEVIEWNAME, this.getLinkPSDEViewName());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isModelStateDirty()) {
            hashMap.put(FIELD_MODELSTATE, this.getModelState());
        }
        if (!bl || this.isNeedCodeListConfigDirty()) {
            hashMap.put(FIELD_NEEDCODELISTCONFIG, this.getNeedCodeListConfig());
        }
        if (!bl || this.isNoPrivDMDirty()) {
            hashMap.put(FIELD_NOPRIVDM, this.getNoPrivDM());
        }
        if (!bl || this.isNoSortDirty()) {
            hashMap.put(FIELD_NOSORT, this.getNoSort());
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
        if (!bl || this.isPickupPSDEViewIdDirty()) {
            hashMap.put(FIELD_PICKUPPSDEVIEWID, this.getPickupPSDEViewId());
        }
        if (!bl || this.isPickupPSDEViewNameDirty()) {
            hashMap.put(FIELD_PICKUPPSDEVIEWNAME, this.getPickupPSDEViewName());
        }
        if (!bl || this.isPlaceHolderDirty()) {
            hashMap.put(FIELD_PLACEHOLDER, this.getPlaceHolder());
        }
        if (!bl || this.isPPSDEGridColIdDirty()) {
            hashMap.put(FIELD_PPSDEGRIDCOLID, this.getPPSDEGridColId());
        }
        if (!bl || this.isPPSDEGridColNameDirty()) {
            hashMap.put(FIELD_PPSDEGRIDCOLNAME, this.getPPSDEGridColName());
        }
        if (!bl || this.isPredefinedTypeDirty()) {
            hashMap.put(FIELD_PREDEFINEDTYPE, this.getPredefinedType());
        }
        if (!bl || this.isPredefinedTypeTextDirty()) {
            hashMap.put(FIELD_PREDEFINEDTYPETEXT, this.getPredefinedTypeText());
        }
        if (!bl || this.isPreventXSSDirty()) {
            hashMap.put(FIELD_PREVENTXSS, this.getPreventXSS());
        }
        if (!bl || this.isPreviewHtmlDirty()) {
            hashMap.put(FIELD_PREVIEWHTML, this.getPreviewHtml());
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
        if (!bl || this.isPSDEFUIModeIdDirty()) {
            hashMap.put(FIELD_PSDEFUIMODEID, this.getPSDEFUIModeId());
        }
        if (!bl || this.isPSDEFUIModeNameDirty()) {
            hashMap.put(FIELD_PSDEFUIMODENAME, this.getPSDEFUIModeName());
        }
        if (!bl || this.isPSDEGEIUpdateIdDirty()) {
            hashMap.put(FIELD_PSDEGEIUPDATEID, this.getPSDEGEIUpdateId());
        }
        if (!bl || this.isPSDEGEIUpdateNameDirty()) {
            hashMap.put(FIELD_PSDEGEIUPDATENAME, this.getPSDEGEIUpdateName());
        }
        if (!bl || this.isPSDEGridColIdDirty()) {
            hashMap.put(FIELD_PSDEGRIDCOLID, this.getPSDEGridColId());
        }
        if (!bl || this.isPSDEGridColNameDirty()) {
            hashMap.put(FIELD_PSDEGRIDCOLNAME, this.getPSDEGridColName());
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
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSSysDictCatIdDirty()) {
            hashMap.put(FIELD_PSSYSDICTCATID, this.getPSSysDictCatId());
        }
        if (!bl || this.isPSSysDictCatNameDirty()) {
            hashMap.put(FIELD_PSSYSDICTCATNAME, this.getPSSysDictCatName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
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
        if (!bl || this.isRawServiceMethodDirty()) {
            hashMap.put(FIELD_RAWSERVICEMETHOD, this.getRawServiceMethod());
        }
        if (!bl || this.isRawServiceUrlDirty()) {
            hashMap.put(FIELD_RAWSERVICEURL, this.getRawServiceUrl());
        }
        if (!bl || this.isRefPSDEACModeIdDirty()) {
            hashMap.put(FIELD_REFPSDEACMODEID, this.getRefPSDEACModeId());
        }
        if (!bl || this.isRefPSDEACModeNameDirty()) {
            hashMap.put(FIELD_REFPSDEACMODENAME, this.getRefPSDEACModeName());
        }
        if (!bl || this.isRefPSDEDataSetIdDirty()) {
            hashMap.put(FIELD_REFPSDEDATASETID, this.getRefPSDEDataSetId());
        }
        if (!bl || this.isRefPSDEDataSetNameDirty()) {
            hashMap.put(FIELD_REFPSDEDATASETNAME, this.getRefPSDEDataSetName());
        }
        if (!bl || this.isRefPSDEIdDirty()) {
            hashMap.put(FIELD_REFPSDEID, this.getRefPSDEId());
        }
        if (!bl || this.isRefPSDENameDirty()) {
            hashMap.put(FIELD_REFPSDENAME, this.getRefPSDEName());
        }
        if (!bl || this.isRefPSDERIdDirty()) {
            hashMap.put(FIELD_REFPSDERID, this.getRefPSDERId());
        }
        if (!bl || this.isRefPSDERNameDirty()) {
            hashMap.put(FIELD_REFPSDERNAME, this.getRefPSDERName());
        }
        if (!bl || this.isRenderModeDirty()) {
            hashMap.put(FIELD_RENDERMODE, this.getRenderMode());
        }
        if (!bl || this.isRenderModeTextDirty()) {
            hashMap.put(FIELD_RENDERMODETEXT, this.getRenderModeText());
        }
        if (!bl || this.isResetItemNameDirty()) {
            hashMap.put(FIELD_RESETITEMNAME, this.getResetItemName());
        }
        if (!bl || this.isTreeItemDirty()) {
            hashMap.put(FIELD_TREEITEM, this.getTreeItem());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateDVDirty()) {
            hashMap.put(FIELD_UPDATEDV, this.getUpdateDV());
        }
        if (!bl || this.isUpdateDVTDirty()) {
            hashMap.put(FIELD_UPDATEDVT, this.getUpdateDVT());
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
        if (!bl || this.isValueFormatDirty()) {
            hashMap.put(FIELD_VALUEFORMAT, this.getValueFormat());
        }
        if (!bl || this.isValueItemNameDirty()) {
            hashMap.put(FIELD_VALUEITEMNAME, this.getValueItemName());
        }
        if (!bl || this.isWidthDirty()) {
            hashMap.put(FIELD_WIDTH, this.getWidth());
        }
        if (!bl || this.isWidthUnitDirty()) {
            hashMap.put(FIELD_WIDTHUNIT, this.getWidthUnit());
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
        return PSDEGridColBase.get(this, n);
    }

    private static Object get(PSDEGridColBase pSDEGridColBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEGridColBase.getAggField();
            }
            case 1: {
                return pSDEGridColBase.getAggMode();
            }
            case 2: {
                return pSDEGridColBase.getAggValueFormat();
            }
            case 3: {
                return pSDEGridColBase.getAlign();
            }
            case 4: {
                return pSDEGridColBase.getAllowEmpty();
            }
            case 5: {
                return pSDEGridColBase.getCapPSLanResId();
            }
            case 6: {
                return pSDEGridColBase.getCapPSLanResName();
            }
            case 7: {
                return pSDEGridColBase.getCaption();
            }
            case 8: {
                return pSDEGridColBase.getCellPSSysCssId();
            }
            case 9: {
                return pSDEGridColBase.getCellPSSysCssName();
            }
            case 10: {
                return pSDEGridColBase.getCLConvertMode();
            }
            case 11: {
                return pSDEGridColBase.getCodeListConfigMode();
            }
            case 12: {
                return pSDEGridColBase.getColEnableLink();
            }
            case 13: {
                return pSDEGridColBase.getCreateDate();
            }
            case 14: {
                return pSDEGridColBase.getCreateDV();
            }
            case 15: {
                return pSDEGridColBase.getCreateDVT();
            }
            case 16: {
                return pSDEGridColBase.getCreateMan();
            }
            case 17: {
                return pSDEGridColBase.getCustomCode();
            }
            case 18: {
                return pSDEGridColBase.getCustomMode();
            }
            case 19: {
                return pSDEGridColBase.getDataItems();
            }
            case 20: {
                return pSDEGridColBase.getDynaModelFlag();
            }
            case 21: {
                return pSDEGridColBase.getEditorParams();
            }
            case 22: {
                return pSDEGridColBase.getEditorType();
            }
            case 23: {
                return pSDEGridColBase.getEditorTypeName();
            }
            case 24: {
                return pSDEGridColBase.getEnableCond();
            }
            case 25: {
                return pSDEGridColBase.getEnableInputTip();
            }
            case 26: {
                return pSDEGridColBase.getEnableItemPriv();
            }
            case 27: {
                return pSDEGridColBase.getEnableLink();
            }
            case 28: {
                return pSDEGridColBase.getEnableRowEdit();
            }
            case 29: {
                return pSDEGridColBase.getGCRPSSysPFPluginId();
            }
            case 30: {
                return pSDEGridColBase.getGCRPSSysPFPluginName();
            }
            case 31: {
                return pSDEGridColBase.getGridColStyle();
            }
            case 32: {
                return pSDEGridColBase.getGridColType();
            }
            case 33: {
                return pSDEGridColBase.getGroupItem();
            }
            case 34: {
                return pSDEGridColBase.getHeaderPSSysCssId();
            }
            case 35: {
                return pSDEGridColBase.getHeaderPSSysCssName();
            }
            case 36: {
                return pSDEGridColBase.getHiddenDataItem();
            }
            case 37: {
                return pSDEGridColBase.getHideDefault();
            }
            case 38: {
                return pSDEGridColBase.getIgnoreInput();
            }
            case 39: {
                return pSDEGridColBase.getLinkPSDEViewId();
            }
            case 40: {
                return pSDEGridColBase.getLinkPSDEViewName();
            }
            case 41: {
                return pSDEGridColBase.getLogicName();
            }
            case 42: {
                return pSDEGridColBase.getMemo();
            }
            case 43: {
                return pSDEGridColBase.getModelState();
            }
            case 44: {
                return pSDEGridColBase.getNeedCodeListConfig();
            }
            case 45: {
                return pSDEGridColBase.getNoPrivDM();
            }
            case 46: {
                return pSDEGridColBase.getNoSort();
            }
            case 47: {
                return pSDEGridColBase.getOrderValue();
            }
            case 48: {
                return pSDEGridColBase.getPHPSLanResId();
            }
            case 49: {
                return pSDEGridColBase.getPHPSLanResName();
            }
            case 50: {
                return pSDEGridColBase.getPickupPSDEViewId();
            }
            case 51: {
                return pSDEGridColBase.getPickupPSDEViewName();
            }
            case 52: {
                return pSDEGridColBase.getPlaceHolder();
            }
            case 53: {
                return pSDEGridColBase.getPPSDEGridColId();
            }
            case 54: {
                return pSDEGridColBase.getPPSDEGridColName();
            }
            case 55: {
                return pSDEGridColBase.getPredefinedType();
            }
            case 56: {
                return pSDEGridColBase.getPredefinedTypeText();
            }
            case 57: {
                return pSDEGridColBase.getPreventXSS();
            }
            case 58: {
                return pSDEGridColBase.getPreviewHtml();
            }
            case 59: {
                return pSDEGridColBase.getPSCodeListId();
            }
            case 60: {
                return pSDEGridColBase.getPSCodeListName();
            }
            case 61: {
                return pSDEGridColBase.getPSDEFId();
            }
            case 62: {
                return pSDEGridColBase.getPSDEFName();
            }
            case 63: {
                return pSDEGridColBase.getPSDEFSFItemId();
            }
            case 64: {
                return pSDEGridColBase.getPSDEFSFItemName();
            }
            case 65: {
                return pSDEGridColBase.getPSDEFUIModeId();
            }
            case 66: {
                return pSDEGridColBase.getPSDEFUIModeName();
            }
            case 67: {
                return pSDEGridColBase.getPSDEGEIUpdateId();
            }
            case 68: {
                return pSDEGridColBase.getPSDEGEIUpdateName();
            }
            case 69: {
                return pSDEGridColBase.getPSDEGridColId();
            }
            case 70: {
                return pSDEGridColBase.getPSDEGridColName();
            }
            case 71: {
                return pSDEGridColBase.getPSDEGridId();
            }
            case 72: {
                return pSDEGridColBase.getPSDEGridName();
            }
            case 73: {
                return pSDEGridColBase.getPSDEId();
            }
            case 74: {
                return pSDEGridColBase.getPSDEUAGroupId();
            }
            case 75: {
                return pSDEGridColBase.getPSDEUAGroupName();
            }
            case 76: {
                return pSDEGridColBase.getPSDEUIActionId();
            }
            case 77: {
                return pSDEGridColBase.getPSDEUIActionName();
            }
            case 78: {
                return pSDEGridColBase.getPSDynaInstId();
            }
            case 79: {
                return pSDEGridColBase.getPSSysDictCatId();
            }
            case 80: {
                return pSDEGridColBase.getPSSysDictCatName();
            }
            case 81: {
                return pSDEGridColBase.getPSSysDynaModelId();
            }
            case 82: {
                return pSDEGridColBase.getPSSysDynaModelName();
            }
            case 83: {
                return pSDEGridColBase.getPSSysEditorStyleId();
            }
            case 84: {
                return pSDEGridColBase.getPSSysEditorStyleName();
            }
            case 85: {
                return pSDEGridColBase.getPSSysImageId();
            }
            case 86: {
                return pSDEGridColBase.getPSSysImageName();
            }
            case 87: {
                return pSDEGridColBase.getRawServiceMethod();
            }
            case 88: {
                return pSDEGridColBase.getRawServiceUrl();
            }
            case 89: {
                return pSDEGridColBase.getRefPSDEACModeId();
            }
            case 90: {
                return pSDEGridColBase.getRefPSDEACModeName();
            }
            case 91: {
                return pSDEGridColBase.getRefPSDEDataSetId();
            }
            case 92: {
                return pSDEGridColBase.getRefPSDEDataSetName();
            }
            case 93: {
                return pSDEGridColBase.getRefPSDEId();
            }
            case 94: {
                return pSDEGridColBase.getRefPSDEName();
            }
            case 95: {
                return pSDEGridColBase.getRefPSDERId();
            }
            case 96: {
                return pSDEGridColBase.getRefPSDERName();
            }
            case 97: {
                return pSDEGridColBase.getRenderMode();
            }
            case 98: {
                return pSDEGridColBase.getRenderModeText();
            }
            case 99: {
                return pSDEGridColBase.getResetItemName();
            }
            case 100: {
                return pSDEGridColBase.getTreeItem();
            }
            case 101: {
                return pSDEGridColBase.getUpdateDate();
            }
            case 102: {
                return pSDEGridColBase.getUpdateDV();
            }
            case 103: {
                return pSDEGridColBase.getUpdateDVT();
            }
            case 104: {
                return pSDEGridColBase.getUpdateMan();
            }
            case 105: {
                return pSDEGridColBase.getUserParams();
            }
            case 106: {
                return pSDEGridColBase.getUserTag();
            }
            case 107: {
                return pSDEGridColBase.getUserTag2();
            }
            case 108: {
                return pSDEGridColBase.getValueFormat();
            }
            case 109: {
                return pSDEGridColBase.getValueItemName();
            }
            case 110: {
                return pSDEGridColBase.getWidth();
            }
            case 111: {
                return pSDEGridColBase.getWidthUnit();
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
        PSDEGridColBase.set(this, n, object);
    }

    private static void set(PSDEGridColBase pSDEGridColBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEGridColBase.setAggField(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEGridColBase.setAggMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEGridColBase.setAggValueFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEGridColBase.setAlign(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEGridColBase.setAllowEmpty(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDEGridColBase.setCapPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEGridColBase.setCapPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEGridColBase.setCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEGridColBase.setCellPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEGridColBase.setCellPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEGridColBase.setCLConvertMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEGridColBase.setCodeListConfigMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDEGridColBase.setColEnableLink(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDEGridColBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSDEGridColBase.setCreateDV(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEGridColBase.setCreateDVT(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEGridColBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEGridColBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEGridColBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSDEGridColBase.setDataItems(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEGridColBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSDEGridColBase.setEditorParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEGridColBase.setEditorType(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEGridColBase.setEditorTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEGridColBase.setEnableCond(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSDEGridColBase.setEnableInputTip(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 26: {
                pSDEGridColBase.setEnableItemPriv(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSDEGridColBase.setEnableLink(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 28: {
                pSDEGridColBase.setEnableRowEdit(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 29: {
                pSDEGridColBase.setGCRPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEGridColBase.setGCRPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEGridColBase.setGridColStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEGridColBase.setGridColType(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEGridColBase.setGroupItem(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEGridColBase.setHeaderPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEGridColBase.setHeaderPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEGridColBase.setHiddenDataItem(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 37: {
                pSDEGridColBase.setHideDefault(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 38: {
                pSDEGridColBase.setIgnoreInput(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 39: {
                pSDEGridColBase.setLinkPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDEGridColBase.setLinkPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDEGridColBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDEGridColBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDEGridColBase.setModelState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 44: {
                pSDEGridColBase.setNeedCodeListConfig(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 45: {
                pSDEGridColBase.setNoPrivDM(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 46: {
                pSDEGridColBase.setNoSort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 47: {
                pSDEGridColBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 48: {
                pSDEGridColBase.setPHPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDEGridColBase.setPHPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDEGridColBase.setPickupPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSDEGridColBase.setPickupPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSDEGridColBase.setPlaceHolder(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSDEGridColBase.setPPSDEGridColId(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSDEGridColBase.setPPSDEGridColName(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSDEGridColBase.setPredefinedType(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSDEGridColBase.setPredefinedTypeText(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSDEGridColBase.setPreventXSS(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 58: {
                pSDEGridColBase.setPreviewHtml(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSDEGridColBase.setPSCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSDEGridColBase.setPSCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSDEGridColBase.setPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSDEGridColBase.setPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSDEGridColBase.setPSDEFSFItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSDEGridColBase.setPSDEFSFItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSDEGridColBase.setPSDEFUIModeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSDEGridColBase.setPSDEFUIModeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSDEGridColBase.setPSDEGEIUpdateId(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSDEGridColBase.setPSDEGEIUpdateName(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSDEGridColBase.setPSDEGridColId(DataObject.getStringValue((Object)object));
                return;
            }
            case 70: {
                pSDEGridColBase.setPSDEGridColName(DataObject.getStringValue((Object)object));
                return;
            }
            case 71: {
                pSDEGridColBase.setPSDEGridId(DataObject.getStringValue((Object)object));
                return;
            }
            case 72: {
                pSDEGridColBase.setPSDEGridName(DataObject.getStringValue((Object)object));
                return;
            }
            case 73: {
                pSDEGridColBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 74: {
                pSDEGridColBase.setPSDEUAGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 75: {
                pSDEGridColBase.setPSDEUAGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 76: {
                pSDEGridColBase.setPSDEUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 77: {
                pSDEGridColBase.setPSDEUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 78: {
                pSDEGridColBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 79: {
                pSDEGridColBase.setPSSysDictCatId(DataObject.getStringValue((Object)object));
                return;
            }
            case 80: {
                pSDEGridColBase.setPSSysDictCatName(DataObject.getStringValue((Object)object));
                return;
            }
            case 81: {
                pSDEGridColBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 82: {
                pSDEGridColBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 83: {
                pSDEGridColBase.setPSSysEditorStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 84: {
                pSDEGridColBase.setPSSysEditorStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 85: {
                pSDEGridColBase.setPSSysImageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 86: {
                pSDEGridColBase.setPSSysImageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 87: {
                pSDEGridColBase.setRawServiceMethod(DataObject.getStringValue((Object)object));
                return;
            }
            case 88: {
                pSDEGridColBase.setRawServiceUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 89: {
                pSDEGridColBase.setRefPSDEACModeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 90: {
                pSDEGridColBase.setRefPSDEACModeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 91: {
                pSDEGridColBase.setRefPSDEDataSetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 92: {
                pSDEGridColBase.setRefPSDEDataSetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 93: {
                pSDEGridColBase.setRefPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 94: {
                pSDEGridColBase.setRefPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 95: {
                pSDEGridColBase.setRefPSDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 96: {
                pSDEGridColBase.setRefPSDERName(DataObject.getStringValue((Object)object));
                return;
            }
            case 97: {
                pSDEGridColBase.setRenderMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 98: {
                pSDEGridColBase.setRenderModeText(DataObject.getStringValue((Object)object));
                return;
            }
            case 99: {
                pSDEGridColBase.setResetItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 100: {
                pSDEGridColBase.setTreeItem(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 101: {
                pSDEGridColBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 102: {
                pSDEGridColBase.setUpdateDV(DataObject.getStringValue((Object)object));
                return;
            }
            case 103: {
                pSDEGridColBase.setUpdateDVT(DataObject.getStringValue((Object)object));
                return;
            }
            case 104: {
                pSDEGridColBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 105: {
                pSDEGridColBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 106: {
                pSDEGridColBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 107: {
                pSDEGridColBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 108: {
                pSDEGridColBase.setValueFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 109: {
                pSDEGridColBase.setValueItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 110: {
                pSDEGridColBase.setWidth(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 111: {
                pSDEGridColBase.setWidthUnit(DataObject.getStringValue((Object)object));
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
        return PSDEGridColBase.isNull(this, n);
    }

    private static boolean isNull(PSDEGridColBase pSDEGridColBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEGridColBase.getAggField() == null;
            }
            case 1: {
                return pSDEGridColBase.getAggMode() == null;
            }
            case 2: {
                return pSDEGridColBase.getAggValueFormat() == null;
            }
            case 3: {
                return pSDEGridColBase.getAlign() == null;
            }
            case 4: {
                return pSDEGridColBase.getAllowEmpty() == null;
            }
            case 5: {
                return pSDEGridColBase.getCapPSLanResId() == null;
            }
            case 6: {
                return pSDEGridColBase.getCapPSLanResName() == null;
            }
            case 7: {
                return pSDEGridColBase.getCaption() == null;
            }
            case 8: {
                return pSDEGridColBase.getCellPSSysCssId() == null;
            }
            case 9: {
                return pSDEGridColBase.getCellPSSysCssName() == null;
            }
            case 10: {
                return pSDEGridColBase.getCLConvertMode() == null;
            }
            case 11: {
                return pSDEGridColBase.getCodeListConfigMode() == null;
            }
            case 12: {
                return pSDEGridColBase.getColEnableLink() == null;
            }
            case 13: {
                return pSDEGridColBase.getCreateDate() == null;
            }
            case 14: {
                return pSDEGridColBase.getCreateDV() == null;
            }
            case 15: {
                return pSDEGridColBase.getCreateDVT() == null;
            }
            case 16: {
                return pSDEGridColBase.getCreateMan() == null;
            }
            case 17: {
                return pSDEGridColBase.getCustomCode() == null;
            }
            case 18: {
                return pSDEGridColBase.getCustomMode() == null;
            }
            case 19: {
                return pSDEGridColBase.getDataItems() == null;
            }
            case 20: {
                return pSDEGridColBase.getDynaModelFlag() == null;
            }
            case 21: {
                return pSDEGridColBase.getEditorParams() == null;
            }
            case 22: {
                return pSDEGridColBase.getEditorType() == null;
            }
            case 23: {
                return pSDEGridColBase.getEditorTypeName() == null;
            }
            case 24: {
                return pSDEGridColBase.getEnableCond() == null;
            }
            case 25: {
                return pSDEGridColBase.getEnableInputTip() == null;
            }
            case 26: {
                return pSDEGridColBase.getEnableItemPriv() == null;
            }
            case 27: {
                return pSDEGridColBase.getEnableLink() == null;
            }
            case 28: {
                return pSDEGridColBase.getEnableRowEdit() == null;
            }
            case 29: {
                return pSDEGridColBase.getGCRPSSysPFPluginId() == null;
            }
            case 30: {
                return pSDEGridColBase.getGCRPSSysPFPluginName() == null;
            }
            case 31: {
                return pSDEGridColBase.getGridColStyle() == null;
            }
            case 32: {
                return pSDEGridColBase.getGridColType() == null;
            }
            case 33: {
                return pSDEGridColBase.getGroupItem() == null;
            }
            case 34: {
                return pSDEGridColBase.getHeaderPSSysCssId() == null;
            }
            case 35: {
                return pSDEGridColBase.getHeaderPSSysCssName() == null;
            }
            case 36: {
                return pSDEGridColBase.getHiddenDataItem() == null;
            }
            case 37: {
                return pSDEGridColBase.getHideDefault() == null;
            }
            case 38: {
                return pSDEGridColBase.getIgnoreInput() == null;
            }
            case 39: {
                return pSDEGridColBase.getLinkPSDEViewId() == null;
            }
            case 40: {
                return pSDEGridColBase.getLinkPSDEViewName() == null;
            }
            case 41: {
                return pSDEGridColBase.getLogicName() == null;
            }
            case 42: {
                return pSDEGridColBase.getMemo() == null;
            }
            case 43: {
                return pSDEGridColBase.getModelState() == null;
            }
            case 44: {
                return pSDEGridColBase.getNeedCodeListConfig() == null;
            }
            case 45: {
                return pSDEGridColBase.getNoPrivDM() == null;
            }
            case 46: {
                return pSDEGridColBase.getNoSort() == null;
            }
            case 47: {
                return pSDEGridColBase.getOrderValue() == null;
            }
            case 48: {
                return pSDEGridColBase.getPHPSLanResId() == null;
            }
            case 49: {
                return pSDEGridColBase.getPHPSLanResName() == null;
            }
            case 50: {
                return pSDEGridColBase.getPickupPSDEViewId() == null;
            }
            case 51: {
                return pSDEGridColBase.getPickupPSDEViewName() == null;
            }
            case 52: {
                return pSDEGridColBase.getPlaceHolder() == null;
            }
            case 53: {
                return pSDEGridColBase.getPPSDEGridColId() == null;
            }
            case 54: {
                return pSDEGridColBase.getPPSDEGridColName() == null;
            }
            case 55: {
                return pSDEGridColBase.getPredefinedType() == null;
            }
            case 56: {
                return pSDEGridColBase.getPredefinedTypeText() == null;
            }
            case 57: {
                return pSDEGridColBase.getPreventXSS() == null;
            }
            case 58: {
                return pSDEGridColBase.getPreviewHtml() == null;
            }
            case 59: {
                return pSDEGridColBase.getPSCodeListId() == null;
            }
            case 60: {
                return pSDEGridColBase.getPSCodeListName() == null;
            }
            case 61: {
                return pSDEGridColBase.getPSDEFId() == null;
            }
            case 62: {
                return pSDEGridColBase.getPSDEFName() == null;
            }
            case 63: {
                return pSDEGridColBase.getPSDEFSFItemId() == null;
            }
            case 64: {
                return pSDEGridColBase.getPSDEFSFItemName() == null;
            }
            case 65: {
                return pSDEGridColBase.getPSDEFUIModeId() == null;
            }
            case 66: {
                return pSDEGridColBase.getPSDEFUIModeName() == null;
            }
            case 67: {
                return pSDEGridColBase.getPSDEGEIUpdateId() == null;
            }
            case 68: {
                return pSDEGridColBase.getPSDEGEIUpdateName() == null;
            }
            case 69: {
                return pSDEGridColBase.getPSDEGridColId() == null;
            }
            case 70: {
                return pSDEGridColBase.getPSDEGridColName() == null;
            }
            case 71: {
                return pSDEGridColBase.getPSDEGridId() == null;
            }
            case 72: {
                return pSDEGridColBase.getPSDEGridName() == null;
            }
            case 73: {
                return pSDEGridColBase.getPSDEId() == null;
            }
            case 74: {
                return pSDEGridColBase.getPSDEUAGroupId() == null;
            }
            case 75: {
                return pSDEGridColBase.getPSDEUAGroupName() == null;
            }
            case 76: {
                return pSDEGridColBase.getPSDEUIActionId() == null;
            }
            case 77: {
                return pSDEGridColBase.getPSDEUIActionName() == null;
            }
            case 78: {
                return pSDEGridColBase.getPSDynaInstId() == null;
            }
            case 79: {
                return pSDEGridColBase.getPSSysDictCatId() == null;
            }
            case 80: {
                return pSDEGridColBase.getPSSysDictCatName() == null;
            }
            case 81: {
                return pSDEGridColBase.getPSSysDynaModelId() == null;
            }
            case 82: {
                return pSDEGridColBase.getPSSysDynaModelName() == null;
            }
            case 83: {
                return pSDEGridColBase.getPSSysEditorStyleId() == null;
            }
            case 84: {
                return pSDEGridColBase.getPSSysEditorStyleName() == null;
            }
            case 85: {
                return pSDEGridColBase.getPSSysImageId() == null;
            }
            case 86: {
                return pSDEGridColBase.getPSSysImageName() == null;
            }
            case 87: {
                return pSDEGridColBase.getRawServiceMethod() == null;
            }
            case 88: {
                return pSDEGridColBase.getRawServiceUrl() == null;
            }
            case 89: {
                return pSDEGridColBase.getRefPSDEACModeId() == null;
            }
            case 90: {
                return pSDEGridColBase.getRefPSDEACModeName() == null;
            }
            case 91: {
                return pSDEGridColBase.getRefPSDEDataSetId() == null;
            }
            case 92: {
                return pSDEGridColBase.getRefPSDEDataSetName() == null;
            }
            case 93: {
                return pSDEGridColBase.getRefPSDEId() == null;
            }
            case 94: {
                return pSDEGridColBase.getRefPSDEName() == null;
            }
            case 95: {
                return pSDEGridColBase.getRefPSDERId() == null;
            }
            case 96: {
                return pSDEGridColBase.getRefPSDERName() == null;
            }
            case 97: {
                return pSDEGridColBase.getRenderMode() == null;
            }
            case 98: {
                return pSDEGridColBase.getRenderModeText() == null;
            }
            case 99: {
                return pSDEGridColBase.getResetItemName() == null;
            }
            case 100: {
                return pSDEGridColBase.getTreeItem() == null;
            }
            case 101: {
                return pSDEGridColBase.getUpdateDate() == null;
            }
            case 102: {
                return pSDEGridColBase.getUpdateDV() == null;
            }
            case 103: {
                return pSDEGridColBase.getUpdateDVT() == null;
            }
            case 104: {
                return pSDEGridColBase.getUpdateMan() == null;
            }
            case 105: {
                return pSDEGridColBase.getUserParams() == null;
            }
            case 106: {
                return pSDEGridColBase.getUserTag() == null;
            }
            case 107: {
                return pSDEGridColBase.getUserTag2() == null;
            }
            case 108: {
                return pSDEGridColBase.getValueFormat() == null;
            }
            case 109: {
                return pSDEGridColBase.getValueItemName() == null;
            }
            case 110: {
                return pSDEGridColBase.getWidth() == null;
            }
            case 111: {
                return pSDEGridColBase.getWidthUnit() == null;
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
        return PSDEGridColBase.contains(this, n);
    }

    private static boolean contains(PSDEGridColBase pSDEGridColBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEGridColBase.isAggFieldDirty();
            }
            case 1: {
                return pSDEGridColBase.isAggModeDirty();
            }
            case 2: {
                return pSDEGridColBase.isAggValueFormatDirty();
            }
            case 3: {
                return pSDEGridColBase.isAlignDirty();
            }
            case 4: {
                return pSDEGridColBase.isAllowEmptyDirty();
            }
            case 5: {
                return pSDEGridColBase.isCapPSLanResIdDirty();
            }
            case 6: {
                return pSDEGridColBase.isCapPSLanResNameDirty();
            }
            case 7: {
                return pSDEGridColBase.isCaptionDirty();
            }
            case 8: {
                return pSDEGridColBase.isCellPSSysCssIdDirty();
            }
            case 9: {
                return pSDEGridColBase.isCellPSSysCssNameDirty();
            }
            case 10: {
                return pSDEGridColBase.isCLConvertModeDirty();
            }
            case 11: {
                return pSDEGridColBase.isCodeListConfigModeDirty();
            }
            case 12: {
                return pSDEGridColBase.isColEnableLinkDirty();
            }
            case 13: {
                return pSDEGridColBase.isCreateDateDirty();
            }
            case 14: {
                return pSDEGridColBase.isCreateDVDirty();
            }
            case 15: {
                return pSDEGridColBase.isCreateDVTDirty();
            }
            case 16: {
                return pSDEGridColBase.isCreateManDirty();
            }
            case 17: {
                return pSDEGridColBase.isCustomCodeDirty();
            }
            case 18: {
                return pSDEGridColBase.isCustomModeDirty();
            }
            case 19: {
                return pSDEGridColBase.isDataItemsDirty();
            }
            case 20: {
                return pSDEGridColBase.isDynaModelFlagDirty();
            }
            case 21: {
                return pSDEGridColBase.isEditorParamsDirty();
            }
            case 22: {
                return pSDEGridColBase.isEditorTypeDirty();
            }
            case 23: {
                return pSDEGridColBase.isEditorTypeNameDirty();
            }
            case 24: {
                return pSDEGridColBase.isEnableCondDirty();
            }
            case 25: {
                return pSDEGridColBase.isEnableInputTipDirty();
            }
            case 26: {
                return pSDEGridColBase.isEnableItemPrivDirty();
            }
            case 27: {
                return pSDEGridColBase.isEnableLinkDirty();
            }
            case 28: {
                return pSDEGridColBase.isEnableRowEditDirty();
            }
            case 29: {
                return pSDEGridColBase.isGCRPSSysPFPluginIdDirty();
            }
            case 30: {
                return pSDEGridColBase.isGCRPSSysPFPluginNameDirty();
            }
            case 31: {
                return pSDEGridColBase.isGridColStyleDirty();
            }
            case 32: {
                return pSDEGridColBase.isGridColTypeDirty();
            }
            case 33: {
                return pSDEGridColBase.isGroupItemDirty();
            }
            case 34: {
                return pSDEGridColBase.isHeaderPSSysCssIdDirty();
            }
            case 35: {
                return pSDEGridColBase.isHeaderPSSysCssNameDirty();
            }
            case 36: {
                return pSDEGridColBase.isHiddenDataItemDirty();
            }
            case 37: {
                return pSDEGridColBase.isHideDefaultDirty();
            }
            case 38: {
                return pSDEGridColBase.isIgnoreInputDirty();
            }
            case 39: {
                return pSDEGridColBase.isLinkPSDEViewIdDirty();
            }
            case 40: {
                return pSDEGridColBase.isLinkPSDEViewNameDirty();
            }
            case 41: {
                return pSDEGridColBase.isLogicNameDirty();
            }
            case 42: {
                return pSDEGridColBase.isMemoDirty();
            }
            case 43: {
                return pSDEGridColBase.isModelStateDirty();
            }
            case 44: {
                return pSDEGridColBase.isNeedCodeListConfigDirty();
            }
            case 45: {
                return pSDEGridColBase.isNoPrivDMDirty();
            }
            case 46: {
                return pSDEGridColBase.isNoSortDirty();
            }
            case 47: {
                return pSDEGridColBase.isOrderValueDirty();
            }
            case 48: {
                return pSDEGridColBase.isPHPSLanResIdDirty();
            }
            case 49: {
                return pSDEGridColBase.isPHPSLanResNameDirty();
            }
            case 50: {
                return pSDEGridColBase.isPickupPSDEViewIdDirty();
            }
            case 51: {
                return pSDEGridColBase.isPickupPSDEViewNameDirty();
            }
            case 52: {
                return pSDEGridColBase.isPlaceHolderDirty();
            }
            case 53: {
                return pSDEGridColBase.isPPSDEGridColIdDirty();
            }
            case 54: {
                return pSDEGridColBase.isPPSDEGridColNameDirty();
            }
            case 55: {
                return pSDEGridColBase.isPredefinedTypeDirty();
            }
            case 56: {
                return pSDEGridColBase.isPredefinedTypeTextDirty();
            }
            case 57: {
                return pSDEGridColBase.isPreventXSSDirty();
            }
            case 58: {
                return pSDEGridColBase.isPreviewHtmlDirty();
            }
            case 59: {
                return pSDEGridColBase.isPSCodeListIdDirty();
            }
            case 60: {
                return pSDEGridColBase.isPSCodeListNameDirty();
            }
            case 61: {
                return pSDEGridColBase.isPSDEFIdDirty();
            }
            case 62: {
                return pSDEGridColBase.isPSDEFNameDirty();
            }
            case 63: {
                return pSDEGridColBase.isPSDEFSFItemIdDirty();
            }
            case 64: {
                return pSDEGridColBase.isPSDEFSFItemNameDirty();
            }
            case 65: {
                return pSDEGridColBase.isPSDEFUIModeIdDirty();
            }
            case 66: {
                return pSDEGridColBase.isPSDEFUIModeNameDirty();
            }
            case 67: {
                return pSDEGridColBase.isPSDEGEIUpdateIdDirty();
            }
            case 68: {
                return pSDEGridColBase.isPSDEGEIUpdateNameDirty();
            }
            case 69: {
                return pSDEGridColBase.isPSDEGridColIdDirty();
            }
            case 70: {
                return pSDEGridColBase.isPSDEGridColNameDirty();
            }
            case 71: {
                return pSDEGridColBase.isPSDEGridIdDirty();
            }
            case 72: {
                return pSDEGridColBase.isPSDEGridNameDirty();
            }
            case 73: {
                return pSDEGridColBase.isPSDEIdDirty();
            }
            case 74: {
                return pSDEGridColBase.isPSDEUAGroupIdDirty();
            }
            case 75: {
                return pSDEGridColBase.isPSDEUAGroupNameDirty();
            }
            case 76: {
                return pSDEGridColBase.isPSDEUIActionIdDirty();
            }
            case 77: {
                return pSDEGridColBase.isPSDEUIActionNameDirty();
            }
            case 78: {
                return pSDEGridColBase.isPSDynaInstIdDirty();
            }
            case 79: {
                return pSDEGridColBase.isPSSysDictCatIdDirty();
            }
            case 80: {
                return pSDEGridColBase.isPSSysDictCatNameDirty();
            }
            case 81: {
                return pSDEGridColBase.isPSSysDynaModelIdDirty();
            }
            case 82: {
                return pSDEGridColBase.isPSSysDynaModelNameDirty();
            }
            case 83: {
                return pSDEGridColBase.isPSSysEditorStyleIdDirty();
            }
            case 84: {
                return pSDEGridColBase.isPSSysEditorStyleNameDirty();
            }
            case 85: {
                return pSDEGridColBase.isPSSysImageIdDirty();
            }
            case 86: {
                return pSDEGridColBase.isPSSysImageNameDirty();
            }
            case 87: {
                return pSDEGridColBase.isRawServiceMethodDirty();
            }
            case 88: {
                return pSDEGridColBase.isRawServiceUrlDirty();
            }
            case 89: {
                return pSDEGridColBase.isRefPSDEACModeIdDirty();
            }
            case 90: {
                return pSDEGridColBase.isRefPSDEACModeNameDirty();
            }
            case 91: {
                return pSDEGridColBase.isRefPSDEDataSetIdDirty();
            }
            case 92: {
                return pSDEGridColBase.isRefPSDEDataSetNameDirty();
            }
            case 93: {
                return pSDEGridColBase.isRefPSDEIdDirty();
            }
            case 94: {
                return pSDEGridColBase.isRefPSDENameDirty();
            }
            case 95: {
                return pSDEGridColBase.isRefPSDERIdDirty();
            }
            case 96: {
                return pSDEGridColBase.isRefPSDERNameDirty();
            }
            case 97: {
                return pSDEGridColBase.isRenderModeDirty();
            }
            case 98: {
                return pSDEGridColBase.isRenderModeTextDirty();
            }
            case 99: {
                return pSDEGridColBase.isResetItemNameDirty();
            }
            case 100: {
                return pSDEGridColBase.isTreeItemDirty();
            }
            case 101: {
                return pSDEGridColBase.isUpdateDateDirty();
            }
            case 102: {
                return pSDEGridColBase.isUpdateDVDirty();
            }
            case 103: {
                return pSDEGridColBase.isUpdateDVTDirty();
            }
            case 104: {
                return pSDEGridColBase.isUpdateManDirty();
            }
            case 105: {
                return pSDEGridColBase.isUserParamsDirty();
            }
            case 106: {
                return pSDEGridColBase.isUserTagDirty();
            }
            case 107: {
                return pSDEGridColBase.isUserTag2Dirty();
            }
            case 108: {
                return pSDEGridColBase.isValueFormatDirty();
            }
            case 109: {
                return pSDEGridColBase.isValueItemNameDirty();
            }
            case 110: {
                return pSDEGridColBase.isWidthDirty();
            }
            case 111: {
                return pSDEGridColBase.isWidthUnitDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEGridColBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEGridColBase pSDEGridColBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEGridColBase.getAggField() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aggfield", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getAggField()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getAggMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aggmode", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getAggMode()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getAggValueFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aggvalueformat", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getAggValueFormat()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getAlign() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"align", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getAlign()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getAllowEmpty() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"allowempty", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getAllowEmpty()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getCapPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresid", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getCapPSLanResId()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getCapPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresname", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getCapPSLanResName()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"caption", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getCaption()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getCellPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cellpssyscssid", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getCellPSSysCssId()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getCellPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cellpssyscssname", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getCellPSSysCssName()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getCLConvertMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clconvertmode", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getCLConvertMode()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getCodeListConfigMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codelistconfigmode", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getCodeListConfigMode()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getColEnableLink() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"colenablelink", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getColEnableLink()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getCreateDV() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdv", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getCreateDV()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getCreateDVT() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdvt", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getCreateDVT()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getDataItems() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dataitems", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getDataItems()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getEditorParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"editorparams", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getEditorParams()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getEditorType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"editortype", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getEditorType()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getEditorTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"editortypename", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getEditorTypeName()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getEnableCond() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablecond", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getEnableCond()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getEnableInputTip() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableinputtip", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getEnableInputTip()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getEnableItemPriv() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableitempriv", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getEnableItemPriv()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getEnableLink() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablelink", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getEnableLink()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getEnableRowEdit() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablerowedit", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getEnableRowEdit()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getGCRPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gcrpssyspfpluginid", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getGCRPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getGCRPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gcrpssyspfpluginname", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getGCRPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getGridColStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gridcolstyle", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getGridColStyle()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getGridColType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gridcoltype", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getGridColType()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getGroupItem() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupitem", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getGroupItem()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getHeaderPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"headerpssyscssid", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getHeaderPSSysCssId()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getHeaderPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"headerpssyscssname", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getHeaderPSSysCssName()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getHiddenDataItem() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hiddendataitem", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getHiddenDataItem()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getHideDefault() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hidedefault", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getHideDefault()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getIgnoreInput() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ignoreinput", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getIgnoreInput()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getLinkPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkpsdeviewid", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getLinkPSDEViewId()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getLinkPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkpsdeviewname", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getLinkPSDEViewName()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getLogicName()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getModelState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelstate", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getModelState()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getNeedCodeListConfig() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"needcodelistconfig", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getNeedCodeListConfig()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getNoPrivDM() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"noprivdm", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getNoPrivDM()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getNoSort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nosort", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getNoSort()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getPHPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"phpslanresid", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getPHPSLanResId()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getPHPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"phpslanresname", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getPHPSLanResName()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getPickupPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pickuppsdeviewid", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getPickupPSDEViewId()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getPickupPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pickuppsdeviewname", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getPickupPSDEViewName()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getPlaceHolder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"placeholder", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getPlaceHolder()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getPPSDEGridColId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdegridcolid", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getPPSDEGridColId()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getPPSDEGridColName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdegridcolname", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getPPSDEGridColName()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getPredefinedType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"predefinedtype", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getPredefinedType()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getPredefinedTypeText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"predefinedtypetext", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getPredefinedTypeText()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getPreventXSS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"preventxss", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getPreventXSS()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getPreviewHtml() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"previewhtml", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getPreviewHtml()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getPSCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistid", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getPSCodeListId()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getPSCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistname", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getPSCodeListName()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefid", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getPSDEFId()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefname", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getPSDEFName()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getPSDEFSFItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefsfitemid", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getPSDEFSFItemId()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getPSDEFSFItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefsfitemname", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getPSDEFSFItemName()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getPSDEFUIModeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefuimodeid", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getPSDEFUIModeId()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getPSDEFUIModeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefuimodename", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getPSDEFUIModeName()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getPSDEGEIUpdateId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegeiupdateid", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getPSDEGEIUpdateId()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getPSDEGEIUpdateName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegeiupdatename", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getPSDEGEIUpdateName()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getPSDEGridColId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegridcolid", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getPSDEGridColId()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getPSDEGridColName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegridcolname", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getPSDEGridColName()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getPSDEGridId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegridid", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getPSDEGridId()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getPSDEGridName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegridname", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getPSDEGridName()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getPSDEUAGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuagroupid", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getPSDEUAGroupId()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getPSDEUAGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuagroupname", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getPSDEUAGroupName()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getPSDEUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionid", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getPSDEUIActionId()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getPSDEUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionname", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getPSDEUIActionName()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getPSSysDictCatId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdictcatid", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getPSSysDictCatId()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getPSSysDictCatName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdictcatname", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getPSSysDictCatName()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getPSSysEditorStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseditorstyleid", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getPSSysEditorStyleId()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getPSSysEditorStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseditorstylename", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getPSSysEditorStyleName()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getPSSysImageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimageid", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getPSSysImageId()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getPSSysImageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimagename", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getPSSysImageName()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getRawServiceMethod() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rawservicemethod", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getRawServiceMethod()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getRawServiceUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rawserviceurl", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getRawServiceUrl()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getRefPSDEACModeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdeacmodeid", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getRefPSDEACModeId()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getRefPSDEACModeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdeacmodename", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getRefPSDEACModeName()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getRefPSDEDataSetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdedatasetid", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getRefPSDEDataSetId()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getRefPSDEDataSetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdedatasetname", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getRefPSDEDataSetName()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getRefPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdeid", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getRefPSDEId()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getRefPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdename", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getRefPSDEName()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getRefPSDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsderid", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getRefPSDERId()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getRefPSDERName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdername", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getRefPSDERName()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getRenderMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rendermode", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getRenderMode()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getRenderModeText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rendermodetext", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getRenderModeText()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getResetItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resetitemname", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getResetItemName()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getTreeItem() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"treeitem", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getTreeItem()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getUpdateDV() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedv", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getUpdateDV()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getUpdateDVT() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedvt", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getUpdateDVT()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getUserParams()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getValueFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valueformat", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getValueFormat()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getValueItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valueitemname", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getValueItemName()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"width", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getWidth()), (boolean)false);
        }
        if (bl || pSDEGridColBase.getWidthUnit() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"widthunit", (Object)PSDEGridColBase.getJSONValue((Object)pSDEGridColBase.getWidthUnit()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEGridColBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEGridColBase pSDEGridColBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEGridColBase.getAggField() != null) {
            object = pSDEGridColBase.getAggField();
            xmlNode.setAttribute(FIELD_AGGFIELD, (String)(object == null ? "" : object));
        }
        if (bl || pSDEGridColBase.getAggMode() != null) {
            object = pSDEGridColBase.getAggMode();
            xmlNode.setAttribute(FIELD_AGGMODE, (String)(object == null ? "" : object));
        }
        if (bl || pSDEGridColBase.getAggValueFormat() != null) {
            object = pSDEGridColBase.getAggValueFormat();
            xmlNode.setAttribute(FIELD_AGGVALUEFORMAT, (String)(object == null ? "" : object));
        }
        if (bl || pSDEGridColBase.getAlign() != null) {
            object = pSDEGridColBase.getAlign();
            xmlNode.setAttribute(FIELD_ALIGN, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getAllowEmpty() != null) {
            object = pSDEGridColBase.getAllowEmpty();
            xmlNode.setAttribute(FIELD_ALLOWEMPTY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridColBase.getCapPSLanResId() != null) {
            object = pSDEGridColBase.getCapPSLanResId();
            xmlNode.setAttribute(FIELD_CAPPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getCapPSLanResName() != null) {
            object = pSDEGridColBase.getCapPSLanResName();
            xmlNode.setAttribute(FIELD_CAPPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getCaption() != null) {
            object = pSDEGridColBase.getCaption();
            xmlNode.setAttribute(FIELD_CAPTION, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getCellPSSysCssId() != null) {
            object = pSDEGridColBase.getCellPSSysCssId();
            xmlNode.setAttribute(FIELD_CELLPSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getCellPSSysCssName() != null) {
            object = pSDEGridColBase.getCellPSSysCssName();
            xmlNode.setAttribute(FIELD_CELLPSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getCLConvertMode() != null) {
            object = pSDEGridColBase.getCLConvertMode();
            xmlNode.setAttribute(FIELD_CLCONVERTMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getCodeListConfigMode() != null) {
            object = pSDEGridColBase.getCodeListConfigMode();
            xmlNode.setAttribute(FIELD_CODELISTCONFIGMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridColBase.getColEnableLink() != null) {
            object = pSDEGridColBase.getColEnableLink();
            xmlNode.setAttribute(FIELD_COLENABLELINK, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridColBase.getCreateDate() != null) {
            object = pSDEGridColBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEGridColBase.getCreateDV() != null) {
            object = pSDEGridColBase.getCreateDV();
            xmlNode.setAttribute(FIELD_CREATEDV, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getCreateDVT() != null) {
            object = pSDEGridColBase.getCreateDVT();
            xmlNode.setAttribute(FIELD_CREATEDVT, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getCreateMan() != null) {
            object = pSDEGridColBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getCustomCode() != null) {
            object = pSDEGridColBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getCustomMode() != null) {
            object = pSDEGridColBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridColBase.getDataItems() != null) {
            object = pSDEGridColBase.getDataItems();
            xmlNode.setAttribute(FIELD_DATAITEMS, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getDynaModelFlag() != null) {
            object = pSDEGridColBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridColBase.getEditorParams() != null) {
            object = pSDEGridColBase.getEditorParams();
            xmlNode.setAttribute(FIELD_EDITORPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getEditorType() != null) {
            object = pSDEGridColBase.getEditorType();
            xmlNode.setAttribute(FIELD_EDITORTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getEditorTypeName() != null) {
            object = pSDEGridColBase.getEditorTypeName();
            xmlNode.setAttribute(FIELD_EDITORTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getEnableCond() != null) {
            object = pSDEGridColBase.getEnableCond();
            xmlNode.setAttribute(FIELD_ENABLECOND, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridColBase.getEnableInputTip() != null) {
            object = pSDEGridColBase.getEnableInputTip();
            xmlNode.setAttribute(FIELD_ENABLEINPUTTIP, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridColBase.getEnableItemPriv() != null) {
            object = pSDEGridColBase.getEnableItemPriv();
            xmlNode.setAttribute(FIELD_ENABLEITEMPRIV, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridColBase.getEnableLink() != null) {
            object = pSDEGridColBase.getEnableLink();
            xmlNode.setAttribute(FIELD_ENABLELINK, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridColBase.getEnableRowEdit() != null) {
            object = pSDEGridColBase.getEnableRowEdit();
            xmlNode.setAttribute(FIELD_ENABLEROWEDIT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridColBase.getGCRPSSysPFPluginId() != null) {
            object = pSDEGridColBase.getGCRPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_GCRPSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getGCRPSSysPFPluginName() != null) {
            object = pSDEGridColBase.getGCRPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_GCRPSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getGridColStyle() != null) {
            object = pSDEGridColBase.getGridColStyle();
            xmlNode.setAttribute(FIELD_GRIDCOLSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getGridColType() != null) {
            object = pSDEGridColBase.getGridColType();
            xmlNode.setAttribute(FIELD_GRIDCOLTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getGroupItem() != null) {
            object = pSDEGridColBase.getGroupItem();
            xmlNode.setAttribute(FIELD_GROUPITEM, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getHeaderPSSysCssId() != null) {
            object = pSDEGridColBase.getHeaderPSSysCssId();
            xmlNode.setAttribute(FIELD_HEADERPSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getHeaderPSSysCssName() != null) {
            object = pSDEGridColBase.getHeaderPSSysCssName();
            xmlNode.setAttribute(FIELD_HEADERPSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getHiddenDataItem() != null) {
            object = pSDEGridColBase.getHiddenDataItem();
            xmlNode.setAttribute(FIELD_HIDDENDATAITEM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridColBase.getHideDefault() != null) {
            object = pSDEGridColBase.getHideDefault();
            xmlNode.setAttribute(FIELD_HIDEDEFAULT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridColBase.getIgnoreInput() != null) {
            object = pSDEGridColBase.getIgnoreInput();
            xmlNode.setAttribute(FIELD_IGNOREINPUT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridColBase.getLinkPSDEViewId() != null) {
            object = pSDEGridColBase.getLinkPSDEViewId();
            xmlNode.setAttribute(FIELD_LINKPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getLinkPSDEViewName() != null) {
            object = pSDEGridColBase.getLinkPSDEViewName();
            xmlNode.setAttribute(FIELD_LINKPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getLogicName() != null) {
            object = pSDEGridColBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getMemo() != null) {
            object = pSDEGridColBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getModelState() != null) {
            object = pSDEGridColBase.getModelState();
            xmlNode.setAttribute(FIELD_MODELSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridColBase.getNeedCodeListConfig() != null) {
            object = pSDEGridColBase.getNeedCodeListConfig();
            xmlNode.setAttribute(FIELD_NEEDCODELISTCONFIG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridColBase.getNoPrivDM() != null) {
            object = pSDEGridColBase.getNoPrivDM();
            xmlNode.setAttribute(FIELD_NOPRIVDM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridColBase.getNoSort() != null) {
            object = pSDEGridColBase.getNoSort();
            xmlNode.setAttribute(FIELD_NOSORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridColBase.getOrderValue() != null) {
            object = pSDEGridColBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridColBase.getPHPSLanResId() != null) {
            object = pSDEGridColBase.getPHPSLanResId();
            xmlNode.setAttribute(FIELD_PHPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getPHPSLanResName() != null) {
            object = pSDEGridColBase.getPHPSLanResName();
            xmlNode.setAttribute(FIELD_PHPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getPickupPSDEViewId() != null) {
            object = pSDEGridColBase.getPickupPSDEViewId();
            xmlNode.setAttribute(FIELD_PICKUPPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getPickupPSDEViewName() != null) {
            object = pSDEGridColBase.getPickupPSDEViewName();
            xmlNode.setAttribute(FIELD_PICKUPPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getPlaceHolder() != null) {
            object = pSDEGridColBase.getPlaceHolder();
            xmlNode.setAttribute(FIELD_PLACEHOLDER, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getPPSDEGridColId() != null) {
            object = pSDEGridColBase.getPPSDEGridColId();
            xmlNode.setAttribute(FIELD_PPSDEGRIDCOLID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getPPSDEGridColName() != null) {
            object = pSDEGridColBase.getPPSDEGridColName();
            xmlNode.setAttribute(FIELD_PPSDEGRIDCOLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getPredefinedType() != null) {
            object = pSDEGridColBase.getPredefinedType();
            xmlNode.setAttribute(FIELD_PREDEFINEDTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getPredefinedTypeText() != null) {
            object = pSDEGridColBase.getPredefinedTypeText();
            xmlNode.setAttribute(FIELD_PREDEFINEDTYPETEXT, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getPreventXSS() != null) {
            object = pSDEGridColBase.getPreventXSS();
            xmlNode.setAttribute(FIELD_PREVENTXSS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridColBase.getPreviewHtml() != null) {
            object = pSDEGridColBase.getPreviewHtml();
            xmlNode.setAttribute(FIELD_PREVIEWHTML, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getPSCodeListId() != null) {
            object = pSDEGridColBase.getPSCodeListId();
            xmlNode.setAttribute(FIELD_PSCODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getPSCodeListName() != null) {
            object = pSDEGridColBase.getPSCodeListName();
            xmlNode.setAttribute(FIELD_PSCODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getPSDEFId() != null) {
            object = pSDEGridColBase.getPSDEFId();
            xmlNode.setAttribute(FIELD_PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getPSDEFName() != null) {
            object = pSDEGridColBase.getPSDEFName();
            xmlNode.setAttribute(FIELD_PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getPSDEFSFItemId() != null) {
            object = pSDEGridColBase.getPSDEFSFItemId();
            xmlNode.setAttribute(FIELD_PSDEFSFITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getPSDEFSFItemName() != null) {
            object = pSDEGridColBase.getPSDEFSFItemName();
            xmlNode.setAttribute(FIELD_PSDEFSFITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getPSDEFUIModeId() != null) {
            object = pSDEGridColBase.getPSDEFUIModeId();
            xmlNode.setAttribute(FIELD_PSDEFUIMODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getPSDEFUIModeName() != null) {
            object = pSDEGridColBase.getPSDEFUIModeName();
            xmlNode.setAttribute(FIELD_PSDEFUIMODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getPSDEGEIUpdateId() != null) {
            object = pSDEGridColBase.getPSDEGEIUpdateId();
            xmlNode.setAttribute(FIELD_PSDEGEIUPDATEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getPSDEGEIUpdateName() != null) {
            object = pSDEGridColBase.getPSDEGEIUpdateName();
            xmlNode.setAttribute(FIELD_PSDEGEIUPDATENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getPSDEGridColId() != null) {
            object = pSDEGridColBase.getPSDEGridColId();
            xmlNode.setAttribute(FIELD_PSDEGRIDCOLID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getPSDEGridColName() != null) {
            object = pSDEGridColBase.getPSDEGridColName();
            xmlNode.setAttribute(FIELD_PSDEGRIDCOLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getPSDEGridId() != null) {
            object = pSDEGridColBase.getPSDEGridId();
            xmlNode.setAttribute(FIELD_PSDEGRIDID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getPSDEGridName() != null) {
            object = pSDEGridColBase.getPSDEGridName();
            xmlNode.setAttribute(FIELD_PSDEGRIDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getPSDEId() != null) {
            object = pSDEGridColBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getPSDEUAGroupId() != null) {
            object = pSDEGridColBase.getPSDEUAGroupId();
            xmlNode.setAttribute(FIELD_PSDEUAGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getPSDEUAGroupName() != null) {
            object = pSDEGridColBase.getPSDEUAGroupName();
            xmlNode.setAttribute(FIELD_PSDEUAGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getPSDEUIActionId() != null) {
            object = pSDEGridColBase.getPSDEUIActionId();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getPSDEUIActionName() != null) {
            object = pSDEGridColBase.getPSDEUIActionName();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getPSDynaInstId() != null) {
            object = pSDEGridColBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getPSSysDictCatId() != null) {
            object = pSDEGridColBase.getPSSysDictCatId();
            xmlNode.setAttribute(FIELD_PSSYSDICTCATID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getPSSysDictCatName() != null) {
            object = pSDEGridColBase.getPSSysDictCatName();
            xmlNode.setAttribute(FIELD_PSSYSDICTCATNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getPSSysDynaModelId() != null) {
            object = pSDEGridColBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getPSSysDynaModelName() != null) {
            object = pSDEGridColBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getPSSysEditorStyleId() != null) {
            object = pSDEGridColBase.getPSSysEditorStyleId();
            xmlNode.setAttribute(FIELD_PSSYSEDITORSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getPSSysEditorStyleName() != null) {
            object = pSDEGridColBase.getPSSysEditorStyleName();
            xmlNode.setAttribute(FIELD_PSSYSEDITORSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getPSSysImageId() != null) {
            object = pSDEGridColBase.getPSSysImageId();
            xmlNode.setAttribute(FIELD_PSSYSIMAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getPSSysImageName() != null) {
            object = pSDEGridColBase.getPSSysImageName();
            xmlNode.setAttribute(FIELD_PSSYSIMAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getRawServiceMethod() != null) {
            object = pSDEGridColBase.getRawServiceMethod();
            xmlNode.setAttribute(FIELD_RAWSERVICEMETHOD, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getRawServiceUrl() != null) {
            object = pSDEGridColBase.getRawServiceUrl();
            xmlNode.setAttribute(FIELD_RAWSERVICEURL, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getRefPSDEACModeId() != null) {
            object = pSDEGridColBase.getRefPSDEACModeId();
            xmlNode.setAttribute(FIELD_REFPSDEACMODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getRefPSDEACModeName() != null) {
            object = pSDEGridColBase.getRefPSDEACModeName();
            xmlNode.setAttribute(FIELD_REFPSDEACMODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getRefPSDEDataSetId() != null) {
            object = pSDEGridColBase.getRefPSDEDataSetId();
            xmlNode.setAttribute(FIELD_REFPSDEDATASETID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getRefPSDEDataSetName() != null) {
            object = pSDEGridColBase.getRefPSDEDataSetName();
            xmlNode.setAttribute(FIELD_REFPSDEDATASETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getRefPSDEId() != null) {
            object = pSDEGridColBase.getRefPSDEId();
            xmlNode.setAttribute(FIELD_REFPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getRefPSDEName() != null) {
            object = pSDEGridColBase.getRefPSDEName();
            xmlNode.setAttribute(FIELD_REFPSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getRefPSDERId() != null) {
            object = pSDEGridColBase.getRefPSDERId();
            xmlNode.setAttribute(FIELD_REFPSDERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getRefPSDERName() != null) {
            object = pSDEGridColBase.getRefPSDERName();
            xmlNode.setAttribute(FIELD_REFPSDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getRenderMode() != null) {
            object = pSDEGridColBase.getRenderMode();
            xmlNode.setAttribute(FIELD_RENDERMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getRenderModeText() != null) {
            object = pSDEGridColBase.getRenderModeText();
            xmlNode.setAttribute(FIELD_RENDERMODETEXT, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getResetItemName() != null) {
            object = pSDEGridColBase.getResetItemName();
            xmlNode.setAttribute(FIELD_RESETITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getTreeItem() != null) {
            object = pSDEGridColBase.getTreeItem();
            xmlNode.setAttribute(FIELD_TREEITEM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridColBase.getUpdateDate() != null) {
            object = pSDEGridColBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEGridColBase.getUpdateDV() != null) {
            object = pSDEGridColBase.getUpdateDV();
            xmlNode.setAttribute(FIELD_UPDATEDV, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getUpdateDVT() != null) {
            object = pSDEGridColBase.getUpdateDVT();
            xmlNode.setAttribute(FIELD_UPDATEDVT, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getUpdateMan() != null) {
            object = pSDEGridColBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getUserParams() != null) {
            object = pSDEGridColBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getUserTag() != null) {
            object = pSDEGridColBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getUserTag2() != null) {
            object = pSDEGridColBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getValueFormat() != null) {
            object = pSDEGridColBase.getValueFormat();
            xmlNode.setAttribute(FIELD_VALUEFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getValueItemName() != null) {
            object = pSDEGridColBase.getValueItemName();
            xmlNode.setAttribute(FIELD_VALUEITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridColBase.getWidth() != null) {
            object = pSDEGridColBase.getWidth();
            xmlNode.setAttribute(FIELD_WIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridColBase.getWidthUnit() != null) {
            object = pSDEGridColBase.getWidthUnit();
            xmlNode.setAttribute(FIELD_WIDTHUNIT, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEGridColBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEGridColBase pSDEGridColBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEGridColBase.isAggFieldDirty() && (bl || pSDEGridColBase.getAggField() != null)) {
            iDataObject.set(FIELD_AGGFIELD, (Object)pSDEGridColBase.getAggField());
        }
        if (pSDEGridColBase.isAggModeDirty() && (bl || pSDEGridColBase.getAggMode() != null)) {
            iDataObject.set(FIELD_AGGMODE, (Object)pSDEGridColBase.getAggMode());
        }
        if (pSDEGridColBase.isAggValueFormatDirty() && (bl || pSDEGridColBase.getAggValueFormat() != null)) {
            iDataObject.set(FIELD_AGGVALUEFORMAT, (Object)pSDEGridColBase.getAggValueFormat());
        }
        if (pSDEGridColBase.isAlignDirty() && (bl || pSDEGridColBase.getAlign() != null)) {
            iDataObject.set(FIELD_ALIGN, (Object)pSDEGridColBase.getAlign());
        }
        if (pSDEGridColBase.isAllowEmptyDirty() && (bl || pSDEGridColBase.getAllowEmpty() != null)) {
            iDataObject.set(FIELD_ALLOWEMPTY, (Object)pSDEGridColBase.getAllowEmpty());
        }
        if (pSDEGridColBase.isCapPSLanResIdDirty() && (bl || pSDEGridColBase.getCapPSLanResId() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESID, (Object)pSDEGridColBase.getCapPSLanResId());
        }
        if (pSDEGridColBase.isCapPSLanResNameDirty() && (bl || pSDEGridColBase.getCapPSLanResName() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESNAME, (Object)pSDEGridColBase.getCapPSLanResName());
        }
        if (pSDEGridColBase.isCaptionDirty() && (bl || pSDEGridColBase.getCaption() != null)) {
            iDataObject.set(FIELD_CAPTION, (Object)pSDEGridColBase.getCaption());
        }
        if (pSDEGridColBase.isCellPSSysCssIdDirty() && (bl || pSDEGridColBase.getCellPSSysCssId() != null)) {
            iDataObject.set(FIELD_CELLPSSYSCSSID, (Object)pSDEGridColBase.getCellPSSysCssId());
        }
        if (pSDEGridColBase.isCellPSSysCssNameDirty() && (bl || pSDEGridColBase.getCellPSSysCssName() != null)) {
            iDataObject.set(FIELD_CELLPSSYSCSSNAME, (Object)pSDEGridColBase.getCellPSSysCssName());
        }
        if (pSDEGridColBase.isCLConvertModeDirty() && (bl || pSDEGridColBase.getCLConvertMode() != null)) {
            iDataObject.set(FIELD_CLCONVERTMODE, (Object)pSDEGridColBase.getCLConvertMode());
        }
        if (pSDEGridColBase.isCodeListConfigModeDirty() && (bl || pSDEGridColBase.getCodeListConfigMode() != null)) {
            iDataObject.set(FIELD_CODELISTCONFIGMODE, (Object)pSDEGridColBase.getCodeListConfigMode());
        }
        if (pSDEGridColBase.isColEnableLinkDirty() && (bl || pSDEGridColBase.getColEnableLink() != null)) {
            iDataObject.set(FIELD_COLENABLELINK, (Object)pSDEGridColBase.getColEnableLink());
        }
        if (pSDEGridColBase.isCreateDateDirty() && (bl || pSDEGridColBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEGridColBase.getCreateDate());
        }
        if (pSDEGridColBase.isCreateDVDirty() && (bl || pSDEGridColBase.getCreateDV() != null)) {
            iDataObject.set(FIELD_CREATEDV, (Object)pSDEGridColBase.getCreateDV());
        }
        if (pSDEGridColBase.isCreateDVTDirty() && (bl || pSDEGridColBase.getCreateDVT() != null)) {
            iDataObject.set(FIELD_CREATEDVT, (Object)pSDEGridColBase.getCreateDVT());
        }
        if (pSDEGridColBase.isCreateManDirty() && (bl || pSDEGridColBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEGridColBase.getCreateMan());
        }
        if (pSDEGridColBase.isCustomCodeDirty() && (bl || pSDEGridColBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSDEGridColBase.getCustomCode());
        }
        if (pSDEGridColBase.isCustomModeDirty() && (bl || pSDEGridColBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSDEGridColBase.getCustomMode());
        }
        if (pSDEGridColBase.isDataItemsDirty() && (bl || pSDEGridColBase.getDataItems() != null)) {
            iDataObject.set(FIELD_DATAITEMS, (Object)pSDEGridColBase.getDataItems());
        }
        if (pSDEGridColBase.isDynaModelFlagDirty() && (bl || pSDEGridColBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDEGridColBase.getDynaModelFlag());
        }
        if (pSDEGridColBase.isEditorParamsDirty() && (bl || pSDEGridColBase.getEditorParams() != null)) {
            iDataObject.set(FIELD_EDITORPARAMS, (Object)pSDEGridColBase.getEditorParams());
        }
        if (pSDEGridColBase.isEditorTypeDirty() && (bl || pSDEGridColBase.getEditorType() != null)) {
            iDataObject.set(FIELD_EDITORTYPE, (Object)pSDEGridColBase.getEditorType());
        }
        if (pSDEGridColBase.isEditorTypeNameDirty() && (bl || pSDEGridColBase.getEditorTypeName() != null)) {
            iDataObject.set(FIELD_EDITORTYPENAME, (Object)pSDEGridColBase.getEditorTypeName());
        }
        if (pSDEGridColBase.isEnableCondDirty() && (bl || pSDEGridColBase.getEnableCond() != null)) {
            iDataObject.set(FIELD_ENABLECOND, (Object)pSDEGridColBase.getEnableCond());
        }
        if (pSDEGridColBase.isEnableInputTipDirty() && (bl || pSDEGridColBase.getEnableInputTip() != null)) {
            iDataObject.set(FIELD_ENABLEINPUTTIP, (Object)pSDEGridColBase.getEnableInputTip());
        }
        if (pSDEGridColBase.isEnableItemPrivDirty() && (bl || pSDEGridColBase.getEnableItemPriv() != null)) {
            iDataObject.set(FIELD_ENABLEITEMPRIV, (Object)pSDEGridColBase.getEnableItemPriv());
        }
        if (pSDEGridColBase.isEnableLinkDirty() && (bl || pSDEGridColBase.getEnableLink() != null)) {
            iDataObject.set(FIELD_ENABLELINK, (Object)pSDEGridColBase.getEnableLink());
        }
        if (pSDEGridColBase.isEnableRowEditDirty() && (bl || pSDEGridColBase.getEnableRowEdit() != null)) {
            iDataObject.set(FIELD_ENABLEROWEDIT, (Object)pSDEGridColBase.getEnableRowEdit());
        }
        if (pSDEGridColBase.isGCRPSSysPFPluginIdDirty() && (bl || pSDEGridColBase.getGCRPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_GCRPSSYSPFPLUGINID, (Object)pSDEGridColBase.getGCRPSSysPFPluginId());
        }
        if (pSDEGridColBase.isGCRPSSysPFPluginNameDirty() && (bl || pSDEGridColBase.getGCRPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_GCRPSSYSPFPLUGINNAME, (Object)pSDEGridColBase.getGCRPSSysPFPluginName());
        }
        if (pSDEGridColBase.isGridColStyleDirty() && (bl || pSDEGridColBase.getGridColStyle() != null)) {
            iDataObject.set(FIELD_GRIDCOLSTYLE, (Object)pSDEGridColBase.getGridColStyle());
        }
        if (pSDEGridColBase.isGridColTypeDirty() && (bl || pSDEGridColBase.getGridColType() != null)) {
            iDataObject.set(FIELD_GRIDCOLTYPE, (Object)pSDEGridColBase.getGridColType());
        }
        if (pSDEGridColBase.isGroupItemDirty() && (bl || pSDEGridColBase.getGroupItem() != null)) {
            iDataObject.set(FIELD_GROUPITEM, (Object)pSDEGridColBase.getGroupItem());
        }
        if (pSDEGridColBase.isHeaderPSSysCssIdDirty() && (bl || pSDEGridColBase.getHeaderPSSysCssId() != null)) {
            iDataObject.set(FIELD_HEADERPSSYSCSSID, (Object)pSDEGridColBase.getHeaderPSSysCssId());
        }
        if (pSDEGridColBase.isHeaderPSSysCssNameDirty() && (bl || pSDEGridColBase.getHeaderPSSysCssName() != null)) {
            iDataObject.set(FIELD_HEADERPSSYSCSSNAME, (Object)pSDEGridColBase.getHeaderPSSysCssName());
        }
        if (pSDEGridColBase.isHiddenDataItemDirty() && (bl || pSDEGridColBase.getHiddenDataItem() != null)) {
            iDataObject.set(FIELD_HIDDENDATAITEM, (Object)pSDEGridColBase.getHiddenDataItem());
        }
        if (pSDEGridColBase.isHideDefaultDirty() && (bl || pSDEGridColBase.getHideDefault() != null)) {
            iDataObject.set(FIELD_HIDEDEFAULT, (Object)pSDEGridColBase.getHideDefault());
        }
        if (pSDEGridColBase.isIgnoreInputDirty() && (bl || pSDEGridColBase.getIgnoreInput() != null)) {
            iDataObject.set(FIELD_IGNOREINPUT, (Object)pSDEGridColBase.getIgnoreInput());
        }
        if (pSDEGridColBase.isLinkPSDEViewIdDirty() && (bl || pSDEGridColBase.getLinkPSDEViewId() != null)) {
            iDataObject.set(FIELD_LINKPSDEVIEWID, (Object)pSDEGridColBase.getLinkPSDEViewId());
        }
        if (pSDEGridColBase.isLinkPSDEViewNameDirty() && (bl || pSDEGridColBase.getLinkPSDEViewName() != null)) {
            iDataObject.set(FIELD_LINKPSDEVIEWNAME, (Object)pSDEGridColBase.getLinkPSDEViewName());
        }
        if (pSDEGridColBase.isLogicNameDirty() && (bl || pSDEGridColBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSDEGridColBase.getLogicName());
        }
        if (pSDEGridColBase.isMemoDirty() && (bl || pSDEGridColBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEGridColBase.getMemo());
        }
        if (pSDEGridColBase.isModelStateDirty() && (bl || pSDEGridColBase.getModelState() != null)) {
            iDataObject.set(FIELD_MODELSTATE, (Object)pSDEGridColBase.getModelState());
        }
        if (pSDEGridColBase.isNeedCodeListConfigDirty() && (bl || pSDEGridColBase.getNeedCodeListConfig() != null)) {
            iDataObject.set(FIELD_NEEDCODELISTCONFIG, (Object)pSDEGridColBase.getNeedCodeListConfig());
        }
        if (pSDEGridColBase.isNoPrivDMDirty() && (bl || pSDEGridColBase.getNoPrivDM() != null)) {
            iDataObject.set(FIELD_NOPRIVDM, (Object)pSDEGridColBase.getNoPrivDM());
        }
        if (pSDEGridColBase.isNoSortDirty() && (bl || pSDEGridColBase.getNoSort() != null)) {
            iDataObject.set(FIELD_NOSORT, (Object)pSDEGridColBase.getNoSort());
        }
        if (pSDEGridColBase.isOrderValueDirty() && (bl || pSDEGridColBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEGridColBase.getOrderValue());
        }
        if (pSDEGridColBase.isPHPSLanResIdDirty() && (bl || pSDEGridColBase.getPHPSLanResId() != null)) {
            iDataObject.set(FIELD_PHPSLANRESID, (Object)pSDEGridColBase.getPHPSLanResId());
        }
        if (pSDEGridColBase.isPHPSLanResNameDirty() && (bl || pSDEGridColBase.getPHPSLanResName() != null)) {
            iDataObject.set(FIELD_PHPSLANRESNAME, (Object)pSDEGridColBase.getPHPSLanResName());
        }
        if (pSDEGridColBase.isPickupPSDEViewIdDirty() && (bl || pSDEGridColBase.getPickupPSDEViewId() != null)) {
            iDataObject.set(FIELD_PICKUPPSDEVIEWID, (Object)pSDEGridColBase.getPickupPSDEViewId());
        }
        if (pSDEGridColBase.isPickupPSDEViewNameDirty() && (bl || pSDEGridColBase.getPickupPSDEViewName() != null)) {
            iDataObject.set(FIELD_PICKUPPSDEVIEWNAME, (Object)pSDEGridColBase.getPickupPSDEViewName());
        }
        if (pSDEGridColBase.isPlaceHolderDirty() && (bl || pSDEGridColBase.getPlaceHolder() != null)) {
            iDataObject.set(FIELD_PLACEHOLDER, (Object)pSDEGridColBase.getPlaceHolder());
        }
        if (pSDEGridColBase.isPPSDEGridColIdDirty() && (bl || pSDEGridColBase.getPPSDEGridColId() != null)) {
            iDataObject.set(FIELD_PPSDEGRIDCOLID, (Object)pSDEGridColBase.getPPSDEGridColId());
        }
        if (pSDEGridColBase.isPPSDEGridColNameDirty() && (bl || pSDEGridColBase.getPPSDEGridColName() != null)) {
            iDataObject.set(FIELD_PPSDEGRIDCOLNAME, (Object)pSDEGridColBase.getPPSDEGridColName());
        }
        if (pSDEGridColBase.isPredefinedTypeDirty() && (bl || pSDEGridColBase.getPredefinedType() != null)) {
            iDataObject.set(FIELD_PREDEFINEDTYPE, (Object)pSDEGridColBase.getPredefinedType());
        }
        if (pSDEGridColBase.isPredefinedTypeTextDirty() && (bl || pSDEGridColBase.getPredefinedTypeText() != null)) {
            iDataObject.set(FIELD_PREDEFINEDTYPETEXT, (Object)pSDEGridColBase.getPredefinedTypeText());
        }
        if (pSDEGridColBase.isPreventXSSDirty() && (bl || pSDEGridColBase.getPreventXSS() != null)) {
            iDataObject.set(FIELD_PREVENTXSS, (Object)pSDEGridColBase.getPreventXSS());
        }
        if (pSDEGridColBase.isPreviewHtmlDirty() && (bl || pSDEGridColBase.getPreviewHtml() != null)) {
            iDataObject.set(FIELD_PREVIEWHTML, (Object)pSDEGridColBase.getPreviewHtml());
        }
        if (pSDEGridColBase.isPSCodeListIdDirty() && (bl || pSDEGridColBase.getPSCodeListId() != null)) {
            iDataObject.set(FIELD_PSCODELISTID, (Object)pSDEGridColBase.getPSCodeListId());
        }
        if (pSDEGridColBase.isPSCodeListNameDirty() && (bl || pSDEGridColBase.getPSCodeListName() != null)) {
            iDataObject.set(FIELD_PSCODELISTNAME, (Object)pSDEGridColBase.getPSCodeListName());
        }
        if (pSDEGridColBase.isPSDEFIdDirty() && (bl || pSDEGridColBase.getPSDEFId() != null)) {
            iDataObject.set(FIELD_PSDEFID, (Object)pSDEGridColBase.getPSDEFId());
        }
        if (pSDEGridColBase.isPSDEFNameDirty() && (bl || pSDEGridColBase.getPSDEFName() != null)) {
            iDataObject.set(FIELD_PSDEFNAME, (Object)pSDEGridColBase.getPSDEFName());
        }
        if (pSDEGridColBase.isPSDEFSFItemIdDirty() && (bl || pSDEGridColBase.getPSDEFSFItemId() != null)) {
            iDataObject.set(FIELD_PSDEFSFITEMID, (Object)pSDEGridColBase.getPSDEFSFItemId());
        }
        if (pSDEGridColBase.isPSDEFSFItemNameDirty() && (bl || pSDEGridColBase.getPSDEFSFItemName() != null)) {
            iDataObject.set(FIELD_PSDEFSFITEMNAME, (Object)pSDEGridColBase.getPSDEFSFItemName());
        }
        if (pSDEGridColBase.isPSDEFUIModeIdDirty() && (bl || pSDEGridColBase.getPSDEFUIModeId() != null)) {
            iDataObject.set(FIELD_PSDEFUIMODEID, (Object)pSDEGridColBase.getPSDEFUIModeId());
        }
        if (pSDEGridColBase.isPSDEFUIModeNameDirty() && (bl || pSDEGridColBase.getPSDEFUIModeName() != null)) {
            iDataObject.set(FIELD_PSDEFUIMODENAME, (Object)pSDEGridColBase.getPSDEFUIModeName());
        }
        if (pSDEGridColBase.isPSDEGEIUpdateIdDirty() && (bl || pSDEGridColBase.getPSDEGEIUpdateId() != null)) {
            iDataObject.set(FIELD_PSDEGEIUPDATEID, (Object)pSDEGridColBase.getPSDEGEIUpdateId());
        }
        if (pSDEGridColBase.isPSDEGEIUpdateNameDirty() && (bl || pSDEGridColBase.getPSDEGEIUpdateName() != null)) {
            iDataObject.set(FIELD_PSDEGEIUPDATENAME, (Object)pSDEGridColBase.getPSDEGEIUpdateName());
        }
        if (pSDEGridColBase.isPSDEGridColIdDirty() && (bl || pSDEGridColBase.getPSDEGridColId() != null)) {
            iDataObject.set(FIELD_PSDEGRIDCOLID, (Object)pSDEGridColBase.getPSDEGridColId());
        }
        if (pSDEGridColBase.isPSDEGridColNameDirty() && (bl || pSDEGridColBase.getPSDEGridColName() != null)) {
            iDataObject.set(FIELD_PSDEGRIDCOLNAME, (Object)pSDEGridColBase.getPSDEGridColName());
        }
        if (pSDEGridColBase.isPSDEGridIdDirty() && (bl || pSDEGridColBase.getPSDEGridId() != null)) {
            iDataObject.set(FIELD_PSDEGRIDID, (Object)pSDEGridColBase.getPSDEGridId());
        }
        if (pSDEGridColBase.isPSDEGridNameDirty() && (bl || pSDEGridColBase.getPSDEGridName() != null)) {
            iDataObject.set(FIELD_PSDEGRIDNAME, (Object)pSDEGridColBase.getPSDEGridName());
        }
        if (pSDEGridColBase.isPSDEIdDirty() && (bl || pSDEGridColBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEGridColBase.getPSDEId());
        }
        if (pSDEGridColBase.isPSDEUAGroupIdDirty() && (bl || pSDEGridColBase.getPSDEUAGroupId() != null)) {
            iDataObject.set(FIELD_PSDEUAGROUPID, (Object)pSDEGridColBase.getPSDEUAGroupId());
        }
        if (pSDEGridColBase.isPSDEUAGroupNameDirty() && (bl || pSDEGridColBase.getPSDEUAGroupName() != null)) {
            iDataObject.set(FIELD_PSDEUAGROUPNAME, (Object)pSDEGridColBase.getPSDEUAGroupName());
        }
        if (pSDEGridColBase.isPSDEUIActionIdDirty() && (bl || pSDEGridColBase.getPSDEUIActionId() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONID, (Object)pSDEGridColBase.getPSDEUIActionId());
        }
        if (pSDEGridColBase.isPSDEUIActionNameDirty() && (bl || pSDEGridColBase.getPSDEUIActionName() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONNAME, (Object)pSDEGridColBase.getPSDEUIActionName());
        }
        if (pSDEGridColBase.isPSDynaInstIdDirty() && (bl || pSDEGridColBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDEGridColBase.getPSDynaInstId());
        }
        if (pSDEGridColBase.isPSSysDictCatIdDirty() && (bl || pSDEGridColBase.getPSSysDictCatId() != null)) {
            iDataObject.set(FIELD_PSSYSDICTCATID, (Object)pSDEGridColBase.getPSSysDictCatId());
        }
        if (pSDEGridColBase.isPSSysDictCatNameDirty() && (bl || pSDEGridColBase.getPSSysDictCatName() != null)) {
            iDataObject.set(FIELD_PSSYSDICTCATNAME, (Object)pSDEGridColBase.getPSSysDictCatName());
        }
        if (pSDEGridColBase.isPSSysDynaModelIdDirty() && (bl || pSDEGridColBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSDEGridColBase.getPSSysDynaModelId());
        }
        if (pSDEGridColBase.isPSSysDynaModelNameDirty() && (bl || pSDEGridColBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSDEGridColBase.getPSSysDynaModelName());
        }
        if (pSDEGridColBase.isPSSysEditorStyleIdDirty() && (bl || pSDEGridColBase.getPSSysEditorStyleId() != null)) {
            iDataObject.set(FIELD_PSSYSEDITORSTYLEID, (Object)pSDEGridColBase.getPSSysEditorStyleId());
        }
        if (pSDEGridColBase.isPSSysEditorStyleNameDirty() && (bl || pSDEGridColBase.getPSSysEditorStyleName() != null)) {
            iDataObject.set(FIELD_PSSYSEDITORSTYLENAME, (Object)pSDEGridColBase.getPSSysEditorStyleName());
        }
        if (pSDEGridColBase.isPSSysImageIdDirty() && (bl || pSDEGridColBase.getPSSysImageId() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGEID, (Object)pSDEGridColBase.getPSSysImageId());
        }
        if (pSDEGridColBase.isPSSysImageNameDirty() && (bl || pSDEGridColBase.getPSSysImageName() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGENAME, (Object)pSDEGridColBase.getPSSysImageName());
        }
        if (pSDEGridColBase.isRawServiceMethodDirty() && (bl || pSDEGridColBase.getRawServiceMethod() != null)) {
            iDataObject.set(FIELD_RAWSERVICEMETHOD, (Object)pSDEGridColBase.getRawServiceMethod());
        }
        if (pSDEGridColBase.isRawServiceUrlDirty() && (bl || pSDEGridColBase.getRawServiceUrl() != null)) {
            iDataObject.set(FIELD_RAWSERVICEURL, (Object)pSDEGridColBase.getRawServiceUrl());
        }
        if (pSDEGridColBase.isRefPSDEACModeIdDirty() && (bl || pSDEGridColBase.getRefPSDEACModeId() != null)) {
            iDataObject.set(FIELD_REFPSDEACMODEID, (Object)pSDEGridColBase.getRefPSDEACModeId());
        }
        if (pSDEGridColBase.isRefPSDEACModeNameDirty() && (bl || pSDEGridColBase.getRefPSDEACModeName() != null)) {
            iDataObject.set(FIELD_REFPSDEACMODENAME, (Object)pSDEGridColBase.getRefPSDEACModeName());
        }
        if (pSDEGridColBase.isRefPSDEDataSetIdDirty() && (bl || pSDEGridColBase.getRefPSDEDataSetId() != null)) {
            iDataObject.set(FIELD_REFPSDEDATASETID, (Object)pSDEGridColBase.getRefPSDEDataSetId());
        }
        if (pSDEGridColBase.isRefPSDEDataSetNameDirty() && (bl || pSDEGridColBase.getRefPSDEDataSetName() != null)) {
            iDataObject.set(FIELD_REFPSDEDATASETNAME, (Object)pSDEGridColBase.getRefPSDEDataSetName());
        }
        if (pSDEGridColBase.isRefPSDEIdDirty() && (bl || pSDEGridColBase.getRefPSDEId() != null)) {
            iDataObject.set(FIELD_REFPSDEID, (Object)pSDEGridColBase.getRefPSDEId());
        }
        if (pSDEGridColBase.isRefPSDENameDirty() && (bl || pSDEGridColBase.getRefPSDEName() != null)) {
            iDataObject.set(FIELD_REFPSDENAME, (Object)pSDEGridColBase.getRefPSDEName());
        }
        if (pSDEGridColBase.isRefPSDERIdDirty() && (bl || pSDEGridColBase.getRefPSDERId() != null)) {
            iDataObject.set(FIELD_REFPSDERID, (Object)pSDEGridColBase.getRefPSDERId());
        }
        if (pSDEGridColBase.isRefPSDERNameDirty() && (bl || pSDEGridColBase.getRefPSDERName() != null)) {
            iDataObject.set(FIELD_REFPSDERNAME, (Object)pSDEGridColBase.getRefPSDERName());
        }
        if (pSDEGridColBase.isRenderModeDirty() && (bl || pSDEGridColBase.getRenderMode() != null)) {
            iDataObject.set(FIELD_RENDERMODE, (Object)pSDEGridColBase.getRenderMode());
        }
        if (pSDEGridColBase.isRenderModeTextDirty() && (bl || pSDEGridColBase.getRenderModeText() != null)) {
            iDataObject.set(FIELD_RENDERMODETEXT, (Object)pSDEGridColBase.getRenderModeText());
        }
        if (pSDEGridColBase.isResetItemNameDirty() && (bl || pSDEGridColBase.getResetItemName() != null)) {
            iDataObject.set(FIELD_RESETITEMNAME, (Object)pSDEGridColBase.getResetItemName());
        }
        if (pSDEGridColBase.isTreeItemDirty() && (bl || pSDEGridColBase.getTreeItem() != null)) {
            iDataObject.set(FIELD_TREEITEM, (Object)pSDEGridColBase.getTreeItem());
        }
        if (pSDEGridColBase.isUpdateDateDirty() && (bl || pSDEGridColBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEGridColBase.getUpdateDate());
        }
        if (pSDEGridColBase.isUpdateDVDirty() && (bl || pSDEGridColBase.getUpdateDV() != null)) {
            iDataObject.set(FIELD_UPDATEDV, (Object)pSDEGridColBase.getUpdateDV());
        }
        if (pSDEGridColBase.isUpdateDVTDirty() && (bl || pSDEGridColBase.getUpdateDVT() != null)) {
            iDataObject.set(FIELD_UPDATEDVT, (Object)pSDEGridColBase.getUpdateDVT());
        }
        if (pSDEGridColBase.isUpdateManDirty() && (bl || pSDEGridColBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEGridColBase.getUpdateMan());
        }
        if (pSDEGridColBase.isUserParamsDirty() && (bl || pSDEGridColBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSDEGridColBase.getUserParams());
        }
        if (pSDEGridColBase.isUserTagDirty() && (bl || pSDEGridColBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEGridColBase.getUserTag());
        }
        if (pSDEGridColBase.isUserTag2Dirty() && (bl || pSDEGridColBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEGridColBase.getUserTag2());
        }
        if (pSDEGridColBase.isValueFormatDirty() && (bl || pSDEGridColBase.getValueFormat() != null)) {
            iDataObject.set(FIELD_VALUEFORMAT, (Object)pSDEGridColBase.getValueFormat());
        }
        if (pSDEGridColBase.isValueItemNameDirty() && (bl || pSDEGridColBase.getValueItemName() != null)) {
            iDataObject.set(FIELD_VALUEITEMNAME, (Object)pSDEGridColBase.getValueItemName());
        }
        if (pSDEGridColBase.isWidthDirty() && (bl || pSDEGridColBase.getWidth() != null)) {
            iDataObject.set(FIELD_WIDTH, (Object)pSDEGridColBase.getWidth());
        }
        if (pSDEGridColBase.isWidthUnitDirty() && (bl || pSDEGridColBase.getWidthUnit() != null)) {
            iDataObject.set(FIELD_WIDTHUNIT, (Object)pSDEGridColBase.getWidthUnit());
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
        return PSDEGridColBase.remove(this, n);
    }

    private static boolean remove(PSDEGridColBase pSDEGridColBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEGridColBase.resetAggField();
                return true;
            }
            case 1: {
                pSDEGridColBase.resetAggMode();
                return true;
            }
            case 2: {
                pSDEGridColBase.resetAggValueFormat();
                return true;
            }
            case 3: {
                pSDEGridColBase.resetAlign();
                return true;
            }
            case 4: {
                pSDEGridColBase.resetAllowEmpty();
                return true;
            }
            case 5: {
                pSDEGridColBase.resetCapPSLanResId();
                return true;
            }
            case 6: {
                pSDEGridColBase.resetCapPSLanResName();
                return true;
            }
            case 7: {
                pSDEGridColBase.resetCaption();
                return true;
            }
            case 8: {
                pSDEGridColBase.resetCellPSSysCssId();
                return true;
            }
            case 9: {
                pSDEGridColBase.resetCellPSSysCssName();
                return true;
            }
            case 10: {
                pSDEGridColBase.resetCLConvertMode();
                return true;
            }
            case 11: {
                pSDEGridColBase.resetCodeListConfigMode();
                return true;
            }
            case 12: {
                pSDEGridColBase.resetColEnableLink();
                return true;
            }
            case 13: {
                pSDEGridColBase.resetCreateDate();
                return true;
            }
            case 14: {
                pSDEGridColBase.resetCreateDV();
                return true;
            }
            case 15: {
                pSDEGridColBase.resetCreateDVT();
                return true;
            }
            case 16: {
                pSDEGridColBase.resetCreateMan();
                return true;
            }
            case 17: {
                pSDEGridColBase.resetCustomCode();
                return true;
            }
            case 18: {
                pSDEGridColBase.resetCustomMode();
                return true;
            }
            case 19: {
                pSDEGridColBase.resetDataItems();
                return true;
            }
            case 20: {
                pSDEGridColBase.resetDynaModelFlag();
                return true;
            }
            case 21: {
                pSDEGridColBase.resetEditorParams();
                return true;
            }
            case 22: {
                pSDEGridColBase.resetEditorType();
                return true;
            }
            case 23: {
                pSDEGridColBase.resetEditorTypeName();
                return true;
            }
            case 24: {
                pSDEGridColBase.resetEnableCond();
                return true;
            }
            case 25: {
                pSDEGridColBase.resetEnableInputTip();
                return true;
            }
            case 26: {
                pSDEGridColBase.resetEnableItemPriv();
                return true;
            }
            case 27: {
                pSDEGridColBase.resetEnableLink();
                return true;
            }
            case 28: {
                pSDEGridColBase.resetEnableRowEdit();
                return true;
            }
            case 29: {
                pSDEGridColBase.resetGCRPSSysPFPluginId();
                return true;
            }
            case 30: {
                pSDEGridColBase.resetGCRPSSysPFPluginName();
                return true;
            }
            case 31: {
                pSDEGridColBase.resetGridColStyle();
                return true;
            }
            case 32: {
                pSDEGridColBase.resetGridColType();
                return true;
            }
            case 33: {
                pSDEGridColBase.resetGroupItem();
                return true;
            }
            case 34: {
                pSDEGridColBase.resetHeaderPSSysCssId();
                return true;
            }
            case 35: {
                pSDEGridColBase.resetHeaderPSSysCssName();
                return true;
            }
            case 36: {
                pSDEGridColBase.resetHiddenDataItem();
                return true;
            }
            case 37: {
                pSDEGridColBase.resetHideDefault();
                return true;
            }
            case 38: {
                pSDEGridColBase.resetIgnoreInput();
                return true;
            }
            case 39: {
                pSDEGridColBase.resetLinkPSDEViewId();
                return true;
            }
            case 40: {
                pSDEGridColBase.resetLinkPSDEViewName();
                return true;
            }
            case 41: {
                pSDEGridColBase.resetLogicName();
                return true;
            }
            case 42: {
                pSDEGridColBase.resetMemo();
                return true;
            }
            case 43: {
                pSDEGridColBase.resetModelState();
                return true;
            }
            case 44: {
                pSDEGridColBase.resetNeedCodeListConfig();
                return true;
            }
            case 45: {
                pSDEGridColBase.resetNoPrivDM();
                return true;
            }
            case 46: {
                pSDEGridColBase.resetNoSort();
                return true;
            }
            case 47: {
                pSDEGridColBase.resetOrderValue();
                return true;
            }
            case 48: {
                pSDEGridColBase.resetPHPSLanResId();
                return true;
            }
            case 49: {
                pSDEGridColBase.resetPHPSLanResName();
                return true;
            }
            case 50: {
                pSDEGridColBase.resetPickupPSDEViewId();
                return true;
            }
            case 51: {
                pSDEGridColBase.resetPickupPSDEViewName();
                return true;
            }
            case 52: {
                pSDEGridColBase.resetPlaceHolder();
                return true;
            }
            case 53: {
                pSDEGridColBase.resetPPSDEGridColId();
                return true;
            }
            case 54: {
                pSDEGridColBase.resetPPSDEGridColName();
                return true;
            }
            case 55: {
                pSDEGridColBase.resetPredefinedType();
                return true;
            }
            case 56: {
                pSDEGridColBase.resetPredefinedTypeText();
                return true;
            }
            case 57: {
                pSDEGridColBase.resetPreventXSS();
                return true;
            }
            case 58: {
                pSDEGridColBase.resetPreviewHtml();
                return true;
            }
            case 59: {
                pSDEGridColBase.resetPSCodeListId();
                return true;
            }
            case 60: {
                pSDEGridColBase.resetPSCodeListName();
                return true;
            }
            case 61: {
                pSDEGridColBase.resetPSDEFId();
                return true;
            }
            case 62: {
                pSDEGridColBase.resetPSDEFName();
                return true;
            }
            case 63: {
                pSDEGridColBase.resetPSDEFSFItemId();
                return true;
            }
            case 64: {
                pSDEGridColBase.resetPSDEFSFItemName();
                return true;
            }
            case 65: {
                pSDEGridColBase.resetPSDEFUIModeId();
                return true;
            }
            case 66: {
                pSDEGridColBase.resetPSDEFUIModeName();
                return true;
            }
            case 67: {
                pSDEGridColBase.resetPSDEGEIUpdateId();
                return true;
            }
            case 68: {
                pSDEGridColBase.resetPSDEGEIUpdateName();
                return true;
            }
            case 69: {
                pSDEGridColBase.resetPSDEGridColId();
                return true;
            }
            case 70: {
                pSDEGridColBase.resetPSDEGridColName();
                return true;
            }
            case 71: {
                pSDEGridColBase.resetPSDEGridId();
                return true;
            }
            case 72: {
                pSDEGridColBase.resetPSDEGridName();
                return true;
            }
            case 73: {
                pSDEGridColBase.resetPSDEId();
                return true;
            }
            case 74: {
                pSDEGridColBase.resetPSDEUAGroupId();
                return true;
            }
            case 75: {
                pSDEGridColBase.resetPSDEUAGroupName();
                return true;
            }
            case 76: {
                pSDEGridColBase.resetPSDEUIActionId();
                return true;
            }
            case 77: {
                pSDEGridColBase.resetPSDEUIActionName();
                return true;
            }
            case 78: {
                pSDEGridColBase.resetPSDynaInstId();
                return true;
            }
            case 79: {
                pSDEGridColBase.resetPSSysDictCatId();
                return true;
            }
            case 80: {
                pSDEGridColBase.resetPSSysDictCatName();
                return true;
            }
            case 81: {
                pSDEGridColBase.resetPSSysDynaModelId();
                return true;
            }
            case 82: {
                pSDEGridColBase.resetPSSysDynaModelName();
                return true;
            }
            case 83: {
                pSDEGridColBase.resetPSSysEditorStyleId();
                return true;
            }
            case 84: {
                pSDEGridColBase.resetPSSysEditorStyleName();
                return true;
            }
            case 85: {
                pSDEGridColBase.resetPSSysImageId();
                return true;
            }
            case 86: {
                pSDEGridColBase.resetPSSysImageName();
                return true;
            }
            case 87: {
                pSDEGridColBase.resetRawServiceMethod();
                return true;
            }
            case 88: {
                pSDEGridColBase.resetRawServiceUrl();
                return true;
            }
            case 89: {
                pSDEGridColBase.resetRefPSDEACModeId();
                return true;
            }
            case 90: {
                pSDEGridColBase.resetRefPSDEACModeName();
                return true;
            }
            case 91: {
                pSDEGridColBase.resetRefPSDEDataSetId();
                return true;
            }
            case 92: {
                pSDEGridColBase.resetRefPSDEDataSetName();
                return true;
            }
            case 93: {
                pSDEGridColBase.resetRefPSDEId();
                return true;
            }
            case 94: {
                pSDEGridColBase.resetRefPSDEName();
                return true;
            }
            case 95: {
                pSDEGridColBase.resetRefPSDERId();
                return true;
            }
            case 96: {
                pSDEGridColBase.resetRefPSDERName();
                return true;
            }
            case 97: {
                pSDEGridColBase.resetRenderMode();
                return true;
            }
            case 98: {
                pSDEGridColBase.resetRenderModeText();
                return true;
            }
            case 99: {
                pSDEGridColBase.resetResetItemName();
                return true;
            }
            case 100: {
                pSDEGridColBase.resetTreeItem();
                return true;
            }
            case 101: {
                pSDEGridColBase.resetUpdateDate();
                return true;
            }
            case 102: {
                pSDEGridColBase.resetUpdateDV();
                return true;
            }
            case 103: {
                pSDEGridColBase.resetUpdateDVT();
                return true;
            }
            case 104: {
                pSDEGridColBase.resetUpdateMan();
                return true;
            }
            case 105: {
                pSDEGridColBase.resetUserParams();
                return true;
            }
            case 106: {
                pSDEGridColBase.resetUserTag();
                return true;
            }
            case 107: {
                pSDEGridColBase.resetUserTag2();
                return true;
            }
            case 108: {
                pSDEGridColBase.resetValueFormat();
                return true;
            }
            case 109: {
                pSDEGridColBase.resetValueItemName();
                return true;
            }
            case 110: {
                pSDEGridColBase.resetWidth();
                return true;
            }
            case 111: {
                pSDEGridColBase.resetWidthUnit();
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
    public PSDataEntity getRefPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDE();
        }
        if (this.getRefPSDEId() == null) {
            return null;
        }
        Integer n = this.objRefPSDELock;
        synchronized (n) {
            if (this.refpsde != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSDEId(), (Object)this.refpsde.getPSDataEntityId()) != 0L) {
                this.refpsde = null;
            }
            if (this.refpsde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getRefPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.refpsde = pSDataEntity;
            }
            return this.refpsde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEACMode getRefPSDEACMode() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDEACMode();
        }
        if (this.getRefPSDEACModeId() == null) {
            return null;
        }
        Integer n = this.objRefPSDEACModeLock;
        synchronized (n) {
            if (this.refpsdeacmode != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSDEACModeId(), (Object)this.refpsdeacmode.getPSDEACModeId()) != 0L) {
                this.refpsdeacmode = null;
            }
            if (this.refpsdeacmode == null) {
                PSDEACMode pSDEACMode = new PSDEACMode();
                pSDEACMode.setPSDEACModeId(this.getRefPSDEACModeId());
                PSDEACModeService pSDEACModeService = (PSDEACModeService)ServiceGlobal.getService(PSDEACModeService.class, (SessionFactory)this.getSessionFactory());
                pSDEACModeService.autoGet(pSDEACMode);
                this.refpsdeacmode = pSDEACMode;
            }
            return this.refpsdeacmode;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getRefPSDEDataSet() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDEDataSet();
        }
        if (this.getRefPSDEDataSetId() == null) {
            return null;
        }
        Integer n = this.objRefPSDEDataSetLock;
        synchronized (n) {
            if (this.refpsdedataset != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSDEDataSetId(), (Object)this.refpsdedataset.getPSDEDataSetId()) != 0L) {
                this.refpsdedataset = null;
            }
            if (this.refpsdedataset == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getRefPSDEDataSetId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet(pSDEDataSet);
                this.refpsdedataset = pSDEDataSet;
            }
            return this.refpsdedataset;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEFUIMode getPSDEFUIMode() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFUIMode();
        }
        if (this.getPSDEFUIModeId() == null) {
            return null;
        }
        Integer n = this.objPSDEFUIModeLock;
        synchronized (n) {
            if (this.psdefuimode != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFUIModeId(), (Object)this.psdefuimode.getPSDEFUIModeId()) != 0L) {
                this.psdefuimode = null;
            }
            if (this.psdefuimode == null) {
                PSDEFUIMode pSDEFUIMode = new PSDEFUIMode();
                pSDEFUIMode.setPSDEFUIModeId(this.getPSDEFUIModeId());
                PSDEFUIModeService pSDEFUIModeService = (PSDEFUIModeService)ServiceGlobal.getService(PSDEFUIModeService.class, (SessionFactory)this.getSessionFactory());
                pSDEFUIModeService.autoGet(pSDEFUIMode);
                this.psdefuimode = pSDEFUIMode;
            }
            return this.psdefuimode;
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
                pSDEFieldService.autoGet(pSDEField);
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
                pSDEFSFItemService.autoGet(pSDEFSFItem);
                this.psdefsfitem = pSDEFSFItem;
            }
            return this.psdefsfitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEGEIUpdate getPSDEGEIUpdate() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGEIUpdate();
        }
        if (this.getPSDEGEIUpdateId() == null) {
            return null;
        }
        Integer n = this.objPSDEGEIUpdateLock;
        synchronized (n) {
            if (this.psdegeiupdate != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEGEIUpdateId(), (Object)this.psdegeiupdate.getPSDEGEIUpdateId()) != 0L) {
                this.psdegeiupdate = null;
            }
            if (this.psdegeiupdate == null) {
                PSDEGEIUpdate pSDEGEIUpdate = new PSDEGEIUpdate();
                pSDEGEIUpdate.setPSDEGEIUpdateId(this.getPSDEGEIUpdateId());
                PSDEGEIUpdateService pSDEGEIUpdateService = (PSDEGEIUpdateService)ServiceGlobal.getService(PSDEGEIUpdateService.class, (SessionFactory)this.getSessionFactory());
                pSDEGEIUpdateService.autoGet(pSDEGEIUpdate);
                this.psdegeiupdate = pSDEGEIUpdate;
            }
            return this.psdegeiupdate;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEGridCol getPPSDEGridCol() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDEGridCol();
        }
        if (this.getPPSDEGridColId() == null) {
            return null;
        }
        Integer n = this.objPPSDEGridColLock;
        synchronized (n) {
            if (this.ppsdegridcol != null && DataTypeHelper.compare((int)25, (Object)this.getPPSDEGridColId(), (Object)this.ppsdegridcol.getPSDEGridColId()) != 0L) {
                this.ppsdegridcol = null;
            }
            if (this.ppsdegridcol == null) {
                PSDEGridCol pSDEGridCol = new PSDEGridCol();
                pSDEGridCol.setPSDEGridColId(this.getPPSDEGridColId());
                PSDEGridColService pSDEGridColService = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
                pSDEGridColService.autoGet(pSDEGridCol);
                this.ppsdegridcol = pSDEGridCol;
            }
            return this.ppsdegridcol;
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
    public PSDER getRefPSDER() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDER();
        }
        if (this.getRefPSDERId() == null) {
            return null;
        }
        Integer n = this.objRefPSDERLock;
        synchronized (n) {
            if (this.refpsder != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSDERId(), (Object)this.refpsder.getPSDERId()) != 0L) {
                this.refpsder = null;
            }
            if (this.refpsder == null) {
                PSDER pSDER = new PSDER();
                pSDER.setPSDERId(this.getRefPSDERId());
                PSDERService pSDERService = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
                pSDERService.autoGet(pSDER);
                this.refpsder = pSDER;
            }
            return this.refpsder;
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
    public PSDEViewBase getLinkPSDEView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkPSDEView();
        }
        if (this.getLinkPSDEViewId() == null) {
            return null;
        }
        Integer n = this.objLinkPSDEViewLock;
        synchronized (n) {
            if (this.linkpsdeview != null && DataTypeHelper.compare((int)25, (Object)this.getLinkPSDEViewId(), (Object)this.linkpsdeview.getPSDEViewBaseId()) != 0L) {
                this.linkpsdeview = null;
            }
            if (this.linkpsdeview == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getLinkPSDEViewId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet(pSDEViewBase);
                this.linkpsdeview = pSDEViewBase;
            }
            return this.linkpsdeview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getPickupPSDEView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPickupPSDEView();
        }
        if (this.getPickupPSDEViewId() == null) {
            return null;
        }
        Integer n = this.objPickupPSDEViewLock;
        synchronized (n) {
            if (this.pickuppsdeview != null && DataTypeHelper.compare((int)25, (Object)this.getPickupPSDEViewId(), (Object)this.pickuppsdeview.getPSDEViewBaseId()) != 0L) {
                this.pickuppsdeview = null;
            }
            if (this.pickuppsdeview == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getPickupPSDEViewId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet(pSDEViewBase);
                this.pickuppsdeview = pSDEViewBase;
            }
            return this.pickuppsdeview;
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
                pSLanguageResService.autoGet(pSLanguageRes);
                this.phpslanres = pSLanguageRes;
            }
            return this.phpslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysCss getCellPSSysCss() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCellPSSysCss();
        }
        if (this.getCellPSSysCssId() == null) {
            return null;
        }
        Integer n = this.objCellPSSysCssLock;
        synchronized (n) {
            if (this.cellpssyscss != null && DataTypeHelper.compare((int)25, (Object)this.getCellPSSysCssId(), (Object)this.cellpssyscss.getPSSysCssId()) != 0L) {
                this.cellpssyscss = null;
            }
            if (this.cellpssyscss == null) {
                PSSysCss pSSysCss = new PSSysCss();
                pSSysCss.setPSSysCssId(this.getCellPSSysCssId());
                PSSysCssService pSSysCssService = (PSSysCssService)ServiceGlobal.getService(PSSysCssService.class, (SessionFactory)this.getSessionFactory());
                pSSysCssService.autoGet(pSSysCss);
                this.cellpssyscss = pSSysCss;
            }
            return this.cellpssyscss;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysCss getHeaderPSSysCss() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHeaderPSSysCss();
        }
        if (this.getHeaderPSSysCssId() == null) {
            return null;
        }
        Integer n = this.objHeaderPSSysCssLock;
        synchronized (n) {
            if (this.headerpssyscss != null && DataTypeHelper.compare((int)25, (Object)this.getHeaderPSSysCssId(), (Object)this.headerpssyscss.getPSSysCssId()) != 0L) {
                this.headerpssyscss = null;
            }
            if (this.headerpssyscss == null) {
                PSSysCss pSSysCss = new PSSysCss();
                pSSysCss.setPSSysCssId(this.getHeaderPSSysCssId());
                PSSysCssService pSSysCssService = (PSSysCssService)ServiceGlobal.getService(PSSysCssService.class, (SessionFactory)this.getSessionFactory());
                pSSysCssService.autoGet(pSSysCss);
                this.headerpssyscss = pSSysCss;
            }
            return this.headerpssyscss;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDictCat getPSSysDictCat() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDictCat();
        }
        if (this.getPSSysDictCatId() == null) {
            return null;
        }
        Integer n = this.objPSSysDictCatLock;
        synchronized (n) {
            if (this.pssysdictcat != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDictCatId(), (Object)this.pssysdictcat.getPSSysDictCatId()) != 0L) {
                this.pssysdictcat = null;
            }
            if (this.pssysdictcat == null) {
                PSSysDictCat pSSysDictCat = new PSSysDictCat();
                pSSysDictCat.setPSSysDictCatId(this.getPSSysDictCatId());
                PSSysDictCatService pSSysDictCatService = (PSSysDictCatService)ServiceGlobal.getService(PSSysDictCatService.class, (SessionFactory)this.getSessionFactory());
                pSSysDictCatService.autoGet(pSSysDictCat);
                this.pssysdictcat = pSSysDictCat;
            }
            return this.pssysdictcat;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDynaModel getPSSysDynaModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModel();
        }
        if (this.getPSSysDynaModelId() == null) {
            return null;
        }
        Integer n = this.objPSSysDynaModelLock;
        synchronized (n) {
            if (this.pssysdynamodel != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDynaModelId(), (Object)this.pssysdynamodel.getPSSysDynaModelId()) != 0L) {
                this.pssysdynamodel = null;
            }
            if (this.pssysdynamodel == null) {
                PSSysDynaModel pSSysDynaModel = new PSSysDynaModel();
                pSSysDynaModel.setPSSysDynaModelId(this.getPSSysDynaModelId());
                PSSysDynaModelService pSSysDynaModelService = (PSSysDynaModelService)ServiceGlobal.getService(PSSysDynaModelService.class, (SessionFactory)this.getSessionFactory());
                pSSysDynaModelService.autoGet(pSSysDynaModel);
                this.pssysdynamodel = pSSysDynaModel;
            }
            return this.pssysdynamodel;
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
                pSSysEditorStyleService.autoGet(pSSysEditorStyle);
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
                pSSysImageService.autoGet(pSSysImage);
                this.pssysimage = pSSysImage;
            }
            return this.pssysimage;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysPFPlugin getGCRPSSysPFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGCRPSSysPFPlugin();
        }
        if (this.getGCRPSSysPFPluginId() == null) {
            return null;
        }
        Integer n = this.objGCRPSSysPFPluginLock;
        synchronized (n) {
            if (this.gcrpssyspfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getGCRPSSysPFPluginId(), (Object)this.gcrpssyspfplugin.getPSSysPFPluginId()) != 0L) {
                this.gcrpssyspfplugin = null;
            }
            if (this.gcrpssyspfplugin == null) {
                PSSysPFPlugin pSSysPFPlugin = new PSSysPFPlugin();
                pSSysPFPlugin.setPSSysPFPluginId(this.getGCRPSSysPFPluginId());
                PSSysPFPluginService pSSysPFPluginService = (PSSysPFPluginService)ServiceGlobal.getService(PSSysPFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysPFPluginService.autoGet(pSSysPFPlugin);
                this.gcrpssyspfplugin = pSSysPFPlugin;
            }
            return this.gcrpssyspfplugin;
        }
    }

    private PSDEGridColBase getProxyEntity() {
        return this.proxyPSDEGridColBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEGridColBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEGridColBase) {
            this.proxyPSDEGridColBase = (PSDEGridColBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEGridColService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_AGGFIELD, 0);
        fieldIndexMap.put(FIELD_AGGMODE, 1);
        fieldIndexMap.put(FIELD_AGGVALUEFORMAT, 2);
        fieldIndexMap.put(FIELD_ALIGN, 3);
        fieldIndexMap.put(FIELD_ALLOWEMPTY, 4);
        fieldIndexMap.put(FIELD_CAPPSLANRESID, 5);
        fieldIndexMap.put(FIELD_CAPPSLANRESNAME, 6);
        fieldIndexMap.put(FIELD_CAPTION, 7);
        fieldIndexMap.put(FIELD_CELLPSSYSCSSID, 8);
        fieldIndexMap.put(FIELD_CELLPSSYSCSSNAME, 9);
        fieldIndexMap.put(FIELD_CLCONVERTMODE, 10);
        fieldIndexMap.put(FIELD_CODELISTCONFIGMODE, 11);
        fieldIndexMap.put(FIELD_COLENABLELINK, 12);
        fieldIndexMap.put(FIELD_CREATEDATE, 13);
        fieldIndexMap.put(FIELD_CREATEDV, 14);
        fieldIndexMap.put(FIELD_CREATEDVT, 15);
        fieldIndexMap.put(FIELD_CREATEMAN, 16);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 17);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 18);
        fieldIndexMap.put(FIELD_DATAITEMS, 19);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 20);
        fieldIndexMap.put(FIELD_EDITORPARAMS, 21);
        fieldIndexMap.put(FIELD_EDITORTYPE, 22);
        fieldIndexMap.put(FIELD_EDITORTYPENAME, 23);
        fieldIndexMap.put(FIELD_ENABLECOND, 24);
        fieldIndexMap.put(FIELD_ENABLEINPUTTIP, 25);
        fieldIndexMap.put(FIELD_ENABLEITEMPRIV, 26);
        fieldIndexMap.put(FIELD_ENABLELINK, 27);
        fieldIndexMap.put(FIELD_ENABLEROWEDIT, 28);
        fieldIndexMap.put(FIELD_GCRPSSYSPFPLUGINID, 29);
        fieldIndexMap.put(FIELD_GCRPSSYSPFPLUGINNAME, 30);
        fieldIndexMap.put(FIELD_GRIDCOLSTYLE, 31);
        fieldIndexMap.put(FIELD_GRIDCOLTYPE, 32);
        fieldIndexMap.put(FIELD_GROUPITEM, 33);
        fieldIndexMap.put(FIELD_HEADERPSSYSCSSID, 34);
        fieldIndexMap.put(FIELD_HEADERPSSYSCSSNAME, 35);
        fieldIndexMap.put(FIELD_HIDDENDATAITEM, 36);
        fieldIndexMap.put(FIELD_HIDEDEFAULT, 37);
        fieldIndexMap.put(FIELD_IGNOREINPUT, 38);
        fieldIndexMap.put(FIELD_LINKPSDEVIEWID, 39);
        fieldIndexMap.put(FIELD_LINKPSDEVIEWNAME, 40);
        fieldIndexMap.put(FIELD_LOGICNAME, 41);
        fieldIndexMap.put(FIELD_MEMO, 42);
        fieldIndexMap.put(FIELD_MODELSTATE, 43);
        fieldIndexMap.put(FIELD_NEEDCODELISTCONFIG, 44);
        fieldIndexMap.put(FIELD_NOPRIVDM, 45);
        fieldIndexMap.put(FIELD_NOSORT, 46);
        fieldIndexMap.put(FIELD_ORDERVALUE, 47);
        fieldIndexMap.put(FIELD_PHPSLANRESID, 48);
        fieldIndexMap.put(FIELD_PHPSLANRESNAME, 49);
        fieldIndexMap.put(FIELD_PICKUPPSDEVIEWID, 50);
        fieldIndexMap.put(FIELD_PICKUPPSDEVIEWNAME, 51);
        fieldIndexMap.put(FIELD_PLACEHOLDER, 52);
        fieldIndexMap.put(FIELD_PPSDEGRIDCOLID, 53);
        fieldIndexMap.put(FIELD_PPSDEGRIDCOLNAME, 54);
        fieldIndexMap.put(FIELD_PREDEFINEDTYPE, 55);
        fieldIndexMap.put(FIELD_PREDEFINEDTYPETEXT, 56);
        fieldIndexMap.put(FIELD_PREVENTXSS, 57);
        fieldIndexMap.put(FIELD_PREVIEWHTML, 58);
        fieldIndexMap.put(FIELD_PSCODELISTID, 59);
        fieldIndexMap.put(FIELD_PSCODELISTNAME, 60);
        fieldIndexMap.put(FIELD_PSDEFID, 61);
        fieldIndexMap.put(FIELD_PSDEFNAME, 62);
        fieldIndexMap.put(FIELD_PSDEFSFITEMID, 63);
        fieldIndexMap.put(FIELD_PSDEFSFITEMNAME, 64);
        fieldIndexMap.put(FIELD_PSDEFUIMODEID, 65);
        fieldIndexMap.put(FIELD_PSDEFUIMODENAME, 66);
        fieldIndexMap.put(FIELD_PSDEGEIUPDATEID, 67);
        fieldIndexMap.put(FIELD_PSDEGEIUPDATENAME, 68);
        fieldIndexMap.put(FIELD_PSDEGRIDCOLID, 69);
        fieldIndexMap.put(FIELD_PSDEGRIDCOLNAME, 70);
        fieldIndexMap.put(FIELD_PSDEGRIDID, 71);
        fieldIndexMap.put(FIELD_PSDEGRIDNAME, 72);
        fieldIndexMap.put(FIELD_PSDEID, 73);
        fieldIndexMap.put(FIELD_PSDEUAGROUPID, 74);
        fieldIndexMap.put(FIELD_PSDEUAGROUPNAME, 75);
        fieldIndexMap.put(FIELD_PSDEUIACTIONID, 76);
        fieldIndexMap.put(FIELD_PSDEUIACTIONNAME, 77);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 78);
        fieldIndexMap.put(FIELD_PSSYSDICTCATID, 79);
        fieldIndexMap.put(FIELD_PSSYSDICTCATNAME, 80);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 81);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 82);
        fieldIndexMap.put(FIELD_PSSYSEDITORSTYLEID, 83);
        fieldIndexMap.put(FIELD_PSSYSEDITORSTYLENAME, 84);
        fieldIndexMap.put(FIELD_PSSYSIMAGEID, 85);
        fieldIndexMap.put(FIELD_PSSYSIMAGENAME, 86);
        fieldIndexMap.put(FIELD_RAWSERVICEMETHOD, 87);
        fieldIndexMap.put(FIELD_RAWSERVICEURL, 88);
        fieldIndexMap.put(FIELD_REFPSDEACMODEID, 89);
        fieldIndexMap.put(FIELD_REFPSDEACMODENAME, 90);
        fieldIndexMap.put(FIELD_REFPSDEDATASETID, 91);
        fieldIndexMap.put(FIELD_REFPSDEDATASETNAME, 92);
        fieldIndexMap.put(FIELD_REFPSDEID, 93);
        fieldIndexMap.put(FIELD_REFPSDENAME, 94);
        fieldIndexMap.put(FIELD_REFPSDERID, 95);
        fieldIndexMap.put(FIELD_REFPSDERNAME, 96);
        fieldIndexMap.put(FIELD_RENDERMODE, 97);
        fieldIndexMap.put(FIELD_RENDERMODETEXT, 98);
        fieldIndexMap.put(FIELD_RESETITEMNAME, 99);
        fieldIndexMap.put(FIELD_TREEITEM, 100);
        fieldIndexMap.put(FIELD_UPDATEDATE, 101);
        fieldIndexMap.put(FIELD_UPDATEDV, 102);
        fieldIndexMap.put(FIELD_UPDATEDVT, 103);
        fieldIndexMap.put(FIELD_UPDATEMAN, 104);
        fieldIndexMap.put(FIELD_USERPARAMS, 105);
        fieldIndexMap.put(FIELD_USERTAG, 106);
        fieldIndexMap.put(FIELD_USERTAG2, 107);
        fieldIndexMap.put(FIELD_VALUEFORMAT, 108);
        fieldIndexMap.put(FIELD_VALUEITEMNAME, 109);
        fieldIndexMap.put(FIELD_WIDTH, 110);
        fieldIndexMap.put(FIELD_WIDTHUNIT, 111);
    }
}

