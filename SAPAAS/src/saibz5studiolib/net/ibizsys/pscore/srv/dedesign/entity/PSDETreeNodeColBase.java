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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFUIMode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETEIUpdate;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeCol;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeNode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeView;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFUIModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETEIUpdateService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDictCat;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysEditorStyle;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDictCatService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysEditorStyleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDETreeNodeColBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDETreeNodeColBase.class);
    public static final String FIELD_ALLOWEMPTY = "ALLOWEMPTY";
    public static final String FIELD_CELLPSSYSCSSID = "CELLPSSYSCSSID";
    public static final String FIELD_CELLPSSYSCSSNAME = "CELLPSSYSCSSNAME";
    public static final String FIELD_CLCONVERTMODE = "CLCONVERTMODE";
    public static final String FIELD_CODELISTCONFIGMODE = "CODELISTCONFIGMODE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEDV = "CREATEDV";
    public static final String FIELD_CREATEDVT = "CREATEDVT";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_DEFAULTVALUE = "DEFAULTVALUE";
    public static final String FIELD_EDITORPARAMS = "EDITORPARAMS";
    public static final String FIELD_EDITORTYPE = "EDITORTYPE";
    public static final String FIELD_ENABLECOND = "ENABLECOND";
    public static final String FIELD_ENABLEITEMPRIV = "ENABLEITEMPRIV";
    public static final String FIELD_ENABLELINK = "ENABLELINK";
    public static final String FIELD_ENABLEROWEDIT = "ENABLEROWEDIT";
    public static final String FIELD_GCRPSSYSPFPLUGINID = "GCRPSSYSPFPLUGINID";
    public static final String FIELD_GCRPSSYSPFPLUGINNAME = "GCRPSSYSPFPLUGINNAME";
    public static final String FIELD_GRIDCOLSTYLE = "GRIDCOLSTYLE";
    public static final String FIELD_GRIDCOLTYPE = "GRIDCOLTYPE";
    public static final String FIELD_GROUPITEM = "GROUPITEM";
    public static final String FIELD_HIDDENDATAITEM = "HIDDENDATAITEM";
    public static final String FIELD_IGNOREINPUT = "IGNOREINPUT";
    public static final String FIELD_LINKPSDEVIEWID = "LINKPSDEVIEWID";
    public static final String FIELD_LINKPSDEVIEWNAME = "LINKPSDEVIEWNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_NEEDCODELISTCONFIG = "NEEDCODELISTCONFIG";
    public static final String FIELD_NOPRIVDM = "NOPRIVDM";
    public static final String FIELD_PICKUPPSDEVIEWID = "PICKUPPSDEVIEWID";
    public static final String FIELD_PICKUPPSDEVIEWNAME = "PICKUPPSDEVIEWNAME";
    public static final String FIELD_PLACEHOLDER = "PLACEHOLDER";
    public static final String FIELD_PSCODELISTID = "PSCODELISTID";
    public static final String FIELD_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String FIELD_PSDEFID = "PSDEFID";
    public static final String FIELD_PSDEFNAME = "PSDEFNAME";
    public static final String FIELD_PSDEFUIMODEID = "PSDEFUIMODEID";
    public static final String FIELD_PSDEFUIMODENAME = "PSDEFUIMODENAME";
    public static final String FIELD_PSDETEIUPDATEID = "PSDETEIUPDATEID";
    public static final String FIELD_PSDETEIUPDATENAME = "PSDETEIUPDATENAME";
    public static final String FIELD_PSDETREECOLID = "PSDETREECOLID";
    public static final String FIELD_PSDETREECOLNAME = "PSDETREECOLNAME";
    public static final String FIELD_PSDETREENODECOLID = "PSDETREENODECOLID";
    public static final String FIELD_PSDETREENODECOLNAME = "PSDETREENODECOLNAME";
    public static final String FIELD_PSDETREENODEID = "PSDETREENODEID";
    public static final String FIELD_PSDETREENODENAME = "PSDETREENODENAME";
    public static final String FIELD_PSDETREEVIEWID = "PSDETREEVIEWID";
    public static final String FIELD_PSDETREEVIEWNAME = "PSDETREEVIEWNAME";
    public static final String FIELD_PSDEUAGROUPID = "PSDEUAGROUPID";
    public static final String FIELD_PSDEUAGROUPNAME = "PSDEUAGROUPNAME";
    public static final String FIELD_PSDEUIACTIONID = "PSDEUIACTIONID";
    public static final String FIELD_PSDEUIACTIONNAME = "PSDEUIACTIONNAME";
    public static final String FIELD_PSSYSDICTCATID = "PSSYSDICTCATID";
    public static final String FIELD_PSSYSDICTCATNAME = "PSSYSDICTCATNAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSEDITORSTYLEID = "PSSYSEDITORSTYLEID";
    public static final String FIELD_PSSYSEDITORSTYLENAME = "PSSYSEDITORSTYLENAME";
    public static final String FIELD_REFPSDEACMODEID = "REFPSDEACMODEID";
    public static final String FIELD_REFPSDEACMODENAME = "REFPSDEACMODENAME";
    public static final String FIELD_REFPSDEDATASETID = "REFPSDEDATASETID";
    public static final String FIELD_REFPSDEDATASETNAME = "REFPSDEDATASETNAME";
    public static final String FIELD_REFPSDEID = "REFPSDEID";
    public static final String FIELD_REFPSDENAME = "REFPSDENAME";
    public static final String FIELD_RESETITEMNAME = "RESETITEMNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEDV = "UPDATEDV";
    public static final String FIELD_UPDATEDVT = "UPDATEDVT";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_VALUEFORMAT = "VALUEFORMAT";
    public static final String FIELD_VALUEITEMNAME = "VALUEITEMNAME";
    private static final int INDEX_ALLOWEMPTY = 0;
    private static final int INDEX_CELLPSSYSCSSID = 1;
    private static final int INDEX_CELLPSSYSCSSNAME = 2;
    private static final int INDEX_CLCONVERTMODE = 3;
    private static final int INDEX_CODELISTCONFIGMODE = 4;
    private static final int INDEX_CREATEDATE = 5;
    private static final int INDEX_CREATEDV = 6;
    private static final int INDEX_CREATEDVT = 7;
    private static final int INDEX_CREATEMAN = 8;
    private static final int INDEX_CUSTOMCODE = 9;
    private static final int INDEX_CUSTOMMODE = 10;
    private static final int INDEX_DEFAULTVALUE = 11;
    private static final int INDEX_EDITORPARAMS = 12;
    private static final int INDEX_EDITORTYPE = 13;
    private static final int INDEX_ENABLECOND = 14;
    private static final int INDEX_ENABLEITEMPRIV = 15;
    private static final int INDEX_ENABLELINK = 16;
    private static final int INDEX_ENABLEROWEDIT = 17;
    private static final int INDEX_GCRPSSYSPFPLUGINID = 18;
    private static final int INDEX_GCRPSSYSPFPLUGINNAME = 19;
    private static final int INDEX_GRIDCOLSTYLE = 20;
    private static final int INDEX_GRIDCOLTYPE = 21;
    private static final int INDEX_GROUPITEM = 22;
    private static final int INDEX_HIDDENDATAITEM = 23;
    private static final int INDEX_IGNOREINPUT = 24;
    private static final int INDEX_LINKPSDEVIEWID = 25;
    private static final int INDEX_LINKPSDEVIEWNAME = 26;
    private static final int INDEX_MEMO = 27;
    private static final int INDEX_NEEDCODELISTCONFIG = 28;
    private static final int INDEX_NOPRIVDM = 29;
    private static final int INDEX_PICKUPPSDEVIEWID = 30;
    private static final int INDEX_PICKUPPSDEVIEWNAME = 31;
    private static final int INDEX_PLACEHOLDER = 32;
    private static final int INDEX_PSCODELISTID = 33;
    private static final int INDEX_PSCODELISTNAME = 34;
    private static final int INDEX_PSDEFID = 35;
    private static final int INDEX_PSDEFNAME = 36;
    private static final int INDEX_PSDEFUIMODEID = 37;
    private static final int INDEX_PSDEFUIMODENAME = 38;
    private static final int INDEX_PSDETEIUPDATEID = 39;
    private static final int INDEX_PSDETEIUPDATENAME = 40;
    private static final int INDEX_PSDETREECOLID = 41;
    private static final int INDEX_PSDETREECOLNAME = 42;
    private static final int INDEX_PSDETREENODECOLID = 43;
    private static final int INDEX_PSDETREENODECOLNAME = 44;
    private static final int INDEX_PSDETREENODEID = 45;
    private static final int INDEX_PSDETREENODENAME = 46;
    private static final int INDEX_PSDETREEVIEWID = 47;
    private static final int INDEX_PSDETREEVIEWNAME = 48;
    private static final int INDEX_PSDEUAGROUPID = 49;
    private static final int INDEX_PSDEUAGROUPNAME = 50;
    private static final int INDEX_PSDEUIACTIONID = 51;
    private static final int INDEX_PSDEUIACTIONNAME = 52;
    private static final int INDEX_PSSYSDICTCATID = 53;
    private static final int INDEX_PSSYSDICTCATNAME = 54;
    private static final int INDEX_PSSYSDYNAMODELID = 55;
    private static final int INDEX_PSSYSDYNAMODELNAME = 56;
    private static final int INDEX_PSSYSEDITORSTYLEID = 57;
    private static final int INDEX_PSSYSEDITORSTYLENAME = 58;
    private static final int INDEX_REFPSDEACMODEID = 59;
    private static final int INDEX_REFPSDEACMODENAME = 60;
    private static final int INDEX_REFPSDEDATASETID = 61;
    private static final int INDEX_REFPSDEDATASETNAME = 62;
    private static final int INDEX_REFPSDEID = 63;
    private static final int INDEX_REFPSDENAME = 64;
    private static final int INDEX_RESETITEMNAME = 65;
    private static final int INDEX_UPDATEDATE = 66;
    private static final int INDEX_UPDATEDV = 67;
    private static final int INDEX_UPDATEDVT = 68;
    private static final int INDEX_UPDATEMAN = 69;
    private static final int INDEX_USERCAT = 70;
    private static final int INDEX_USERTAG = 71;
    private static final int INDEX_USERTAG2 = 72;
    private static final int INDEX_VALUEFORMAT = 73;
    private static final int INDEX_VALUEITEMNAME = 74;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDETreeNodeColBase proxyPSDETreeNodeColBase = null;
    private boolean allowemptyDirtyFlag = false;
    private boolean cellpssyscssidDirtyFlag = false;
    private boolean cellpssyscssnameDirtyFlag = false;
    private boolean clconvertmodeDirtyFlag = false;
    private boolean codelistconfigmodeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createdvDirtyFlag = false;
    private boolean createdvtDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean defaultvalueDirtyFlag = false;
    private boolean editorparamsDirtyFlag = false;
    private boolean editortypeDirtyFlag = false;
    private boolean enablecondDirtyFlag = false;
    private boolean enableitemprivDirtyFlag = false;
    private boolean enablelinkDirtyFlag = false;
    private boolean enableroweditDirtyFlag = false;
    private boolean gcrpssyspfpluginidDirtyFlag = false;
    private boolean gcrpssyspfpluginnameDirtyFlag = false;
    private boolean gridcolstyleDirtyFlag = false;
    private boolean gridcoltypeDirtyFlag = false;
    private boolean groupitemDirtyFlag = false;
    private boolean hiddendataitemDirtyFlag = false;
    private boolean ignoreinputDirtyFlag = false;
    private boolean linkpsdeviewidDirtyFlag = false;
    private boolean linkpsdeviewnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean needcodelistconfigDirtyFlag = false;
    private boolean noprivdmDirtyFlag = false;
    private boolean pickuppsdeviewidDirtyFlag = false;
    private boolean pickuppsdeviewnameDirtyFlag = false;
    private boolean placeholderDirtyFlag = false;
    private boolean pscodelistidDirtyFlag = false;
    private boolean pscodelistnameDirtyFlag = false;
    private boolean psdefidDirtyFlag = false;
    private boolean psdefnameDirtyFlag = false;
    private boolean psdefuimodeidDirtyFlag = false;
    private boolean psdefuimodenameDirtyFlag = false;
    private boolean psdeteiupdateidDirtyFlag = false;
    private boolean psdeteiupdatenameDirtyFlag = false;
    private boolean psdetreecolidDirtyFlag = false;
    private boolean psdetreecolnameDirtyFlag = false;
    private boolean psdetreenodecolidDirtyFlag = false;
    private boolean psdetreenodecolnameDirtyFlag = false;
    private boolean psdetreenodeidDirtyFlag = false;
    private boolean psdetreenodenameDirtyFlag = false;
    private boolean psdetreeviewidDirtyFlag = false;
    private boolean psdetreeviewnameDirtyFlag = false;
    private boolean psdeuagroupidDirtyFlag = false;
    private boolean psdeuagroupnameDirtyFlag = false;
    private boolean psdeuiactionidDirtyFlag = false;
    private boolean psdeuiactionnameDirtyFlag = false;
    private boolean pssysdictcatidDirtyFlag = false;
    private boolean pssysdictcatnameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssyseditorstyleidDirtyFlag = false;
    private boolean pssyseditorstylenameDirtyFlag = false;
    private boolean refpsdeacmodeidDirtyFlag = false;
    private boolean refpsdeacmodenameDirtyFlag = false;
    private boolean refpsdedatasetidDirtyFlag = false;
    private boolean refpsdedatasetnameDirtyFlag = false;
    private boolean refpsdeidDirtyFlag = false;
    private boolean refpsdenameDirtyFlag = false;
    private boolean resetitemnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatedvDirtyFlag = false;
    private boolean updatedvtDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean valueformatDirtyFlag = false;
    private boolean valueitemnameDirtyFlag = false;
    @Column(name="allowempty")
    private Integer allowempty;
    @Column(name="cellpssyscssid")
    private String cellpssyscssid;
    @Column(name="cellpssyscssname")
    private String cellpssyscssname;
    @Column(name="clconvertmode")
    private String clconvertmode;
    @Column(name="codelistconfigmode")
    private Integer codelistconfigmode;
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
    @Column(name="defaultvalue")
    private String defaultvalue;
    @Column(name="editorparams")
    private String editorparams;
    @Column(name="editortype")
    private String editortype;
    @Column(name="enablecond")
    private Integer enablecond;
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
    @Column(name="hiddendataitem")
    private Integer hiddendataitem;
    @Column(name="ignoreinput")
    private Integer ignoreinput;
    @Column(name="linkpsdeviewid")
    private String linkpsdeviewid;
    @Column(name="linkpsdeviewname")
    private String linkpsdeviewname;
    @Column(name="memo")
    private String memo;
    @Column(name="needcodelistconfig")
    private Integer needcodelistconfig;
    @Column(name="noprivdm")
    private Integer noprivdm;
    @Column(name="pickuppsdeviewid")
    private String pickuppsdeviewid;
    @Column(name="pickuppsdeviewname")
    private String pickuppsdeviewname;
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
    @Column(name="psdefuimodeid")
    private String psdefuimodeid;
    @Column(name="psdefuimodename")
    private String psdefuimodename;
    @Column(name="psdeteiupdateid")
    private String psdeteiupdateid;
    @Column(name="psdeteiupdatename")
    private String psdeteiupdatename;
    @Column(name="psdetreecolid")
    private String psdetreecolid;
    @Column(name="psdetreecolname")
    private String psdetreecolname;
    @Column(name="psdetreenodecolid")
    private String psdetreenodecolid;
    @Column(name="psdetreenodecolname")
    private String psdetreenodecolname;
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
    @Column(name="psdeuiactionid")
    private String psdeuiactionid;
    @Column(name="psdeuiactionname")
    private String psdeuiactionname;
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
    @Column(name="resetitemname")
    private String resetitemname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updatedv")
    private String updatedv;
    @Column(name="updatedvt")
    private String updatedvt;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="valueformat")
    private String valueformat;
    @Column(name="valueitemname")
    private String valueitemname;
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
    private Integer objPSDETEIUpdateLock = new Integer(1);
    private PSDETEIUpdate psdeteiupdate = null;
    private Integer objPSDETreeColLock = new Integer(1);
    private PSDETreeCol psdetreecol = null;
    private Integer objPSDETreeNodeLock = new Integer(1);
    private PSDETreeNode psdetreenode = null;
    private Integer objPSDETreeViewLock = new Integer(1);
    private PSDETreeView psdetreeview = null;
    private Integer objPSDEUAGroupLock = new Integer(1);
    private PSDEUAGroup psdeuagroup = null;
    private Integer objPSDEUIActionLock = new Integer(1);
    private PSDEUIAction psdeuiaction = null;
    private Integer objLinkPSDEViewLock = new Integer(1);
    private PSDEViewBase linkpsdeview = null;
    private Integer objPickupPSDEViewLock = new Integer(1);
    private PSDEViewBase pickuppsdeview = null;
    private Integer objCellPSSysCssLock = new Integer(1);
    private PSSysCss cellpssyscss = null;
    private Integer objPSSysDictCatLock = new Integer(1);
    private PSSysDictCat pssysdictcat = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysEditorStyleLock = new Integer(1);
    private PSSysEditorStyle pssyseditorstyle = null;
    private Integer objGCRPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin gcrpssyspfplugin = null;

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

    public void setDefaultValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defaultvalue = string;
        this.defaultvalueDirtyFlag = true;
    }

    public String getDefaultValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultValue();
        }
        return this.defaultvalue;
    }

    public boolean isDefaultValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultValueDirty();
        }
        return this.defaultvalueDirtyFlag;
    }

    public void resetDefaultValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultValue();
            return;
        }
        this.defaultvalueDirtyFlag = false;
        this.defaultvalue = null;
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

    public void setPSDETEIUpdateId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETEIUpdateId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeteiupdateid = string;
        this.psdeteiupdateidDirtyFlag = true;
    }

    public String getPSDETEIUpdateId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETEIUpdateId();
        }
        return this.psdeteiupdateid;
    }

    public boolean isPSDETEIUpdateIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETEIUpdateIdDirty();
        }
        return this.psdeteiupdateidDirtyFlag;
    }

    public void resetPSDETEIUpdateId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETEIUpdateId();
            return;
        }
        this.psdeteiupdateidDirtyFlag = false;
        this.psdeteiupdateid = null;
    }

    public void setPSDETEIUpdateName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETEIUpdateName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeteiupdatename = string;
        this.psdeteiupdatenameDirtyFlag = true;
    }

    public String getPSDETEIUpdateName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETEIUpdateName();
        }
        return this.psdeteiupdatename;
    }

    public boolean isPSDETEIUpdateNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETEIUpdateNameDirty();
        }
        return this.psdeteiupdatenameDirtyFlag;
    }

    public void resetPSDETEIUpdateName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETEIUpdateName();
            return;
        }
        this.psdeteiupdatenameDirtyFlag = false;
        this.psdeteiupdatename = null;
    }

    public void setPSDETreeColId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETreeColId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetreecolid = string;
        this.psdetreecolidDirtyFlag = true;
    }

    public String getPSDETreeColId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeColId();
        }
        return this.psdetreecolid;
    }

    public boolean isPSDETreeColIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETreeColIdDirty();
        }
        return this.psdetreecolidDirtyFlag;
    }

    public void resetPSDETreeColId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETreeColId();
            return;
        }
        this.psdetreecolidDirtyFlag = false;
        this.psdetreecolid = null;
    }

    public void setPSDETreeColName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETreeColName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetreecolname = string;
        this.psdetreecolnameDirtyFlag = true;
    }

    public String getPSDETreeColName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeColName();
        }
        return this.psdetreecolname;
    }

    public boolean isPSDETreeColNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETreeColNameDirty();
        }
        return this.psdetreecolnameDirtyFlag;
    }

    public void resetPSDETreeColName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETreeColName();
            return;
        }
        this.psdetreecolnameDirtyFlag = false;
        this.psdetreecolname = null;
    }

    public void setPSDETreeNodeColId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETreeNodeColId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetreenodecolid = string;
        this.psdetreenodecolidDirtyFlag = true;
    }

    public String getPSDETreeNodeColId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeNodeColId();
        }
        return this.psdetreenodecolid;
    }

    public boolean isPSDETreeNodeColIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETreeNodeColIdDirty();
        }
        return this.psdetreenodecolidDirtyFlag;
    }

    public void resetPSDETreeNodeColId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETreeNodeColId();
            return;
        }
        this.psdetreenodecolidDirtyFlag = false;
        this.psdetreenodecolid = null;
    }

    public void setPSDETreeNodeColName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETreeNodeColName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetreenodecolname = string;
        this.psdetreenodecolnameDirtyFlag = true;
    }

    public String getPSDETreeNodeColName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeNodeColName();
        }
        return this.psdetreenodecolname;
    }

    public boolean isPSDETreeNodeColNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETreeNodeColNameDirty();
        }
        return this.psdetreenodecolnameDirtyFlag;
    }

    public void resetPSDETreeNodeColName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETreeNodeColName();
            return;
        }
        this.psdetreenodecolnameDirtyFlag = false;
        this.psdetreenodecolname = null;
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

    protected void onReset() {
        PSDETreeNodeColBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDETreeNodeColBase pSDETreeNodeColBase) {
        pSDETreeNodeColBase.resetAllowEmpty();
        pSDETreeNodeColBase.resetCellPSSysCssId();
        pSDETreeNodeColBase.resetCellPSSysCssName();
        pSDETreeNodeColBase.resetCLConvertMode();
        pSDETreeNodeColBase.resetCodeListConfigMode();
        pSDETreeNodeColBase.resetCreateDate();
        pSDETreeNodeColBase.resetCreateDV();
        pSDETreeNodeColBase.resetCreateDVT();
        pSDETreeNodeColBase.resetCreateMan();
        pSDETreeNodeColBase.resetCustomCode();
        pSDETreeNodeColBase.resetCustomMode();
        pSDETreeNodeColBase.resetDefaultValue();
        pSDETreeNodeColBase.resetEditorParams();
        pSDETreeNodeColBase.resetEditorType();
        pSDETreeNodeColBase.resetEnableCond();
        pSDETreeNodeColBase.resetEnableItemPriv();
        pSDETreeNodeColBase.resetEnableLink();
        pSDETreeNodeColBase.resetEnableRowEdit();
        pSDETreeNodeColBase.resetGCRPSSysPFPluginId();
        pSDETreeNodeColBase.resetGCRPSSysPFPluginName();
        pSDETreeNodeColBase.resetGridColStyle();
        pSDETreeNodeColBase.resetGridColType();
        pSDETreeNodeColBase.resetGroupItem();
        pSDETreeNodeColBase.resetHiddenDataItem();
        pSDETreeNodeColBase.resetIgnoreInput();
        pSDETreeNodeColBase.resetLinkPSDEViewId();
        pSDETreeNodeColBase.resetLinkPSDEViewName();
        pSDETreeNodeColBase.resetMemo();
        pSDETreeNodeColBase.resetNeedCodeListConfig();
        pSDETreeNodeColBase.resetNoPrivDM();
        pSDETreeNodeColBase.resetPickupPSDEViewId();
        pSDETreeNodeColBase.resetPickupPSDEViewName();
        pSDETreeNodeColBase.resetPlaceHolder();
        pSDETreeNodeColBase.resetPSCodeListId();
        pSDETreeNodeColBase.resetPSCodeListName();
        pSDETreeNodeColBase.resetPSDEFId();
        pSDETreeNodeColBase.resetPSDEFName();
        pSDETreeNodeColBase.resetPSDEFUIModeId();
        pSDETreeNodeColBase.resetPSDEFUIModeName();
        pSDETreeNodeColBase.resetPSDETEIUpdateId();
        pSDETreeNodeColBase.resetPSDETEIUpdateName();
        pSDETreeNodeColBase.resetPSDETreeColId();
        pSDETreeNodeColBase.resetPSDETreeColName();
        pSDETreeNodeColBase.resetPSDETreeNodeColId();
        pSDETreeNodeColBase.resetPSDETreeNodeColName();
        pSDETreeNodeColBase.resetPSDETreeNodeId();
        pSDETreeNodeColBase.resetPSDETreeNodeName();
        pSDETreeNodeColBase.resetPSDETreeViewId();
        pSDETreeNodeColBase.resetPSDETreeViewName();
        pSDETreeNodeColBase.resetPSDEUAGroupId();
        pSDETreeNodeColBase.resetPSDEUAGroupName();
        pSDETreeNodeColBase.resetPSDEUIActionId();
        pSDETreeNodeColBase.resetPSDEUIActionName();
        pSDETreeNodeColBase.resetPSSysDictCatId();
        pSDETreeNodeColBase.resetPSSysDictCatName();
        pSDETreeNodeColBase.resetPSSysDynaModelId();
        pSDETreeNodeColBase.resetPSSysDynaModelName();
        pSDETreeNodeColBase.resetPSSysEditorStyleId();
        pSDETreeNodeColBase.resetPSSysEditorStyleName();
        pSDETreeNodeColBase.resetRefPSDEACModeId();
        pSDETreeNodeColBase.resetRefPSDEACModeName();
        pSDETreeNodeColBase.resetRefPSDEDataSetId();
        pSDETreeNodeColBase.resetRefPSDEDataSetName();
        pSDETreeNodeColBase.resetRefPSDEId();
        pSDETreeNodeColBase.resetRefPSDEName();
        pSDETreeNodeColBase.resetResetItemName();
        pSDETreeNodeColBase.resetUpdateDate();
        pSDETreeNodeColBase.resetUpdateDV();
        pSDETreeNodeColBase.resetUpdateDVT();
        pSDETreeNodeColBase.resetUpdateMan();
        pSDETreeNodeColBase.resetUserCat();
        pSDETreeNodeColBase.resetUserTag();
        pSDETreeNodeColBase.resetUserTag2();
        pSDETreeNodeColBase.resetValueFormat();
        pSDETreeNodeColBase.resetValueItemName();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAllowEmptyDirty()) {
            hashMap.put(FIELD_ALLOWEMPTY, this.getAllowEmpty());
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
        if (!bl || this.isDefaultValueDirty()) {
            hashMap.put(FIELD_DEFAULTVALUE, this.getDefaultValue());
        }
        if (!bl || this.isEditorParamsDirty()) {
            hashMap.put(FIELD_EDITORPARAMS, this.getEditorParams());
        }
        if (!bl || this.isEditorTypeDirty()) {
            hashMap.put(FIELD_EDITORTYPE, this.getEditorType());
        }
        if (!bl || this.isEnableCondDirty()) {
            hashMap.put(FIELD_ENABLECOND, this.getEnableCond());
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
        if (!bl || this.isHiddenDataItemDirty()) {
            hashMap.put(FIELD_HIDDENDATAITEM, this.getHiddenDataItem());
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
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isNeedCodeListConfigDirty()) {
            hashMap.put(FIELD_NEEDCODELISTCONFIG, this.getNeedCodeListConfig());
        }
        if (!bl || this.isNoPrivDMDirty()) {
            hashMap.put(FIELD_NOPRIVDM, this.getNoPrivDM());
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
        if (!bl || this.isPSDEFUIModeIdDirty()) {
            hashMap.put(FIELD_PSDEFUIMODEID, this.getPSDEFUIModeId());
        }
        if (!bl || this.isPSDEFUIModeNameDirty()) {
            hashMap.put(FIELD_PSDEFUIMODENAME, this.getPSDEFUIModeName());
        }
        if (!bl || this.isPSDETEIUpdateIdDirty()) {
            hashMap.put(FIELD_PSDETEIUPDATEID, this.getPSDETEIUpdateId());
        }
        if (!bl || this.isPSDETEIUpdateNameDirty()) {
            hashMap.put(FIELD_PSDETEIUPDATENAME, this.getPSDETEIUpdateName());
        }
        if (!bl || this.isPSDETreeColIdDirty()) {
            hashMap.put(FIELD_PSDETREECOLID, this.getPSDETreeColId());
        }
        if (!bl || this.isPSDETreeColNameDirty()) {
            hashMap.put(FIELD_PSDETREECOLNAME, this.getPSDETreeColName());
        }
        if (!bl || this.isPSDETreeNodeColIdDirty()) {
            hashMap.put(FIELD_PSDETREENODECOLID, this.getPSDETreeNodeColId());
        }
        if (!bl || this.isPSDETreeNodeColNameDirty()) {
            hashMap.put(FIELD_PSDETREENODECOLNAME, this.getPSDETreeNodeColName());
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
        if (!bl || this.isPSDEUIActionIdDirty()) {
            hashMap.put(FIELD_PSDEUIACTIONID, this.getPSDEUIActionId());
        }
        if (!bl || this.isPSDEUIActionNameDirty()) {
            hashMap.put(FIELD_PSDEUIACTIONNAME, this.getPSDEUIActionName());
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
        if (!bl || this.isResetItemNameDirty()) {
            hashMap.put(FIELD_RESETITEMNAME, this.getResetItemName());
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
        if (!bl || this.isUserCatDirty()) {
            hashMap.put(FIELD_USERCAT, this.getUserCat());
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
        return PSDETreeNodeColBase.get(this, n);
    }

    private static Object get(PSDETreeNodeColBase pSDETreeNodeColBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDETreeNodeColBase.getAllowEmpty();
            }
            case 1: {
                return pSDETreeNodeColBase.getCellPSSysCssId();
            }
            case 2: {
                return pSDETreeNodeColBase.getCellPSSysCssName();
            }
            case 3: {
                return pSDETreeNodeColBase.getCLConvertMode();
            }
            case 4: {
                return pSDETreeNodeColBase.getCodeListConfigMode();
            }
            case 5: {
                return pSDETreeNodeColBase.getCreateDate();
            }
            case 6: {
                return pSDETreeNodeColBase.getCreateDV();
            }
            case 7: {
                return pSDETreeNodeColBase.getCreateDVT();
            }
            case 8: {
                return pSDETreeNodeColBase.getCreateMan();
            }
            case 9: {
                return pSDETreeNodeColBase.getCustomCode();
            }
            case 10: {
                return pSDETreeNodeColBase.getCustomMode();
            }
            case 11: {
                return pSDETreeNodeColBase.getDefaultValue();
            }
            case 12: {
                return pSDETreeNodeColBase.getEditorParams();
            }
            case 13: {
                return pSDETreeNodeColBase.getEditorType();
            }
            case 14: {
                return pSDETreeNodeColBase.getEnableCond();
            }
            case 15: {
                return pSDETreeNodeColBase.getEnableItemPriv();
            }
            case 16: {
                return pSDETreeNodeColBase.getEnableLink();
            }
            case 17: {
                return pSDETreeNodeColBase.getEnableRowEdit();
            }
            case 18: {
                return pSDETreeNodeColBase.getGCRPSSysPFPluginId();
            }
            case 19: {
                return pSDETreeNodeColBase.getGCRPSSysPFPluginName();
            }
            case 20: {
                return pSDETreeNodeColBase.getGridColStyle();
            }
            case 21: {
                return pSDETreeNodeColBase.getGridColType();
            }
            case 22: {
                return pSDETreeNodeColBase.getGroupItem();
            }
            case 23: {
                return pSDETreeNodeColBase.getHiddenDataItem();
            }
            case 24: {
                return pSDETreeNodeColBase.getIgnoreInput();
            }
            case 25: {
                return pSDETreeNodeColBase.getLinkPSDEViewId();
            }
            case 26: {
                return pSDETreeNodeColBase.getLinkPSDEViewName();
            }
            case 27: {
                return pSDETreeNodeColBase.getMemo();
            }
            case 28: {
                return pSDETreeNodeColBase.getNeedCodeListConfig();
            }
            case 29: {
                return pSDETreeNodeColBase.getNoPrivDM();
            }
            case 30: {
                return pSDETreeNodeColBase.getPickupPSDEViewId();
            }
            case 31: {
                return pSDETreeNodeColBase.getPickupPSDEViewName();
            }
            case 32: {
                return pSDETreeNodeColBase.getPlaceHolder();
            }
            case 33: {
                return pSDETreeNodeColBase.getPSCodeListId();
            }
            case 34: {
                return pSDETreeNodeColBase.getPSCodeListName();
            }
            case 35: {
                return pSDETreeNodeColBase.getPSDEFId();
            }
            case 36: {
                return pSDETreeNodeColBase.getPSDEFName();
            }
            case 37: {
                return pSDETreeNodeColBase.getPSDEFUIModeId();
            }
            case 38: {
                return pSDETreeNodeColBase.getPSDEFUIModeName();
            }
            case 39: {
                return pSDETreeNodeColBase.getPSDETEIUpdateId();
            }
            case 40: {
                return pSDETreeNodeColBase.getPSDETEIUpdateName();
            }
            case 41: {
                return pSDETreeNodeColBase.getPSDETreeColId();
            }
            case 42: {
                return pSDETreeNodeColBase.getPSDETreeColName();
            }
            case 43: {
                return pSDETreeNodeColBase.getPSDETreeNodeColId();
            }
            case 44: {
                return pSDETreeNodeColBase.getPSDETreeNodeColName();
            }
            case 45: {
                return pSDETreeNodeColBase.getPSDETreeNodeId();
            }
            case 46: {
                return pSDETreeNodeColBase.getPSDETreeNodeName();
            }
            case 47: {
                return pSDETreeNodeColBase.getPSDETreeViewId();
            }
            case 48: {
                return pSDETreeNodeColBase.getPSDETreeViewName();
            }
            case 49: {
                return pSDETreeNodeColBase.getPSDEUAGroupId();
            }
            case 50: {
                return pSDETreeNodeColBase.getPSDEUAGroupName();
            }
            case 51: {
                return pSDETreeNodeColBase.getPSDEUIActionId();
            }
            case 52: {
                return pSDETreeNodeColBase.getPSDEUIActionName();
            }
            case 53: {
                return pSDETreeNodeColBase.getPSSysDictCatId();
            }
            case 54: {
                return pSDETreeNodeColBase.getPSSysDictCatName();
            }
            case 55: {
                return pSDETreeNodeColBase.getPSSysDynaModelId();
            }
            case 56: {
                return pSDETreeNodeColBase.getPSSysDynaModelName();
            }
            case 57: {
                return pSDETreeNodeColBase.getPSSysEditorStyleId();
            }
            case 58: {
                return pSDETreeNodeColBase.getPSSysEditorStyleName();
            }
            case 59: {
                return pSDETreeNodeColBase.getRefPSDEACModeId();
            }
            case 60: {
                return pSDETreeNodeColBase.getRefPSDEACModeName();
            }
            case 61: {
                return pSDETreeNodeColBase.getRefPSDEDataSetId();
            }
            case 62: {
                return pSDETreeNodeColBase.getRefPSDEDataSetName();
            }
            case 63: {
                return pSDETreeNodeColBase.getRefPSDEId();
            }
            case 64: {
                return pSDETreeNodeColBase.getRefPSDEName();
            }
            case 65: {
                return pSDETreeNodeColBase.getResetItemName();
            }
            case 66: {
                return pSDETreeNodeColBase.getUpdateDate();
            }
            case 67: {
                return pSDETreeNodeColBase.getUpdateDV();
            }
            case 68: {
                return pSDETreeNodeColBase.getUpdateDVT();
            }
            case 69: {
                return pSDETreeNodeColBase.getUpdateMan();
            }
            case 70: {
                return pSDETreeNodeColBase.getUserCat();
            }
            case 71: {
                return pSDETreeNodeColBase.getUserTag();
            }
            case 72: {
                return pSDETreeNodeColBase.getUserTag2();
            }
            case 73: {
                return pSDETreeNodeColBase.getValueFormat();
            }
            case 74: {
                return pSDETreeNodeColBase.getValueItemName();
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
        PSDETreeNodeColBase.set(this, n, object);
    }

    private static void set(PSDETreeNodeColBase pSDETreeNodeColBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDETreeNodeColBase.setAllowEmpty(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDETreeNodeColBase.setCellPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDETreeNodeColBase.setCellPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDETreeNodeColBase.setCLConvertMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDETreeNodeColBase.setCodeListConfigMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDETreeNodeColBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSDETreeNodeColBase.setCreateDV(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDETreeNodeColBase.setCreateDVT(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDETreeNodeColBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDETreeNodeColBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDETreeNodeColBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSDETreeNodeColBase.setDefaultValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDETreeNodeColBase.setEditorParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDETreeNodeColBase.setEditorType(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDETreeNodeColBase.setEnableCond(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSDETreeNodeColBase.setEnableItemPriv(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSDETreeNodeColBase.setEnableLink(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSDETreeNodeColBase.setEnableRowEdit(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSDETreeNodeColBase.setGCRPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDETreeNodeColBase.setGCRPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDETreeNodeColBase.setGridColStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDETreeNodeColBase.setGridColType(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDETreeNodeColBase.setGroupItem(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDETreeNodeColBase.setHiddenDataItem(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSDETreeNodeColBase.setIgnoreInput(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSDETreeNodeColBase.setLinkPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDETreeNodeColBase.setLinkPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDETreeNodeColBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDETreeNodeColBase.setNeedCodeListConfig(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 29: {
                pSDETreeNodeColBase.setNoPrivDM(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 30: {
                pSDETreeNodeColBase.setPickupPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDETreeNodeColBase.setPickupPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDETreeNodeColBase.setPlaceHolder(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDETreeNodeColBase.setPSCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDETreeNodeColBase.setPSCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDETreeNodeColBase.setPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDETreeNodeColBase.setPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDETreeNodeColBase.setPSDEFUIModeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDETreeNodeColBase.setPSDEFUIModeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDETreeNodeColBase.setPSDETEIUpdateId(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDETreeNodeColBase.setPSDETEIUpdateName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDETreeNodeColBase.setPSDETreeColId(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDETreeNodeColBase.setPSDETreeColName(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDETreeNodeColBase.setPSDETreeNodeColId(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDETreeNodeColBase.setPSDETreeNodeColName(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDETreeNodeColBase.setPSDETreeNodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDETreeNodeColBase.setPSDETreeNodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDETreeNodeColBase.setPSDETreeViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDETreeNodeColBase.setPSDETreeViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDETreeNodeColBase.setPSDEUAGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDETreeNodeColBase.setPSDEUAGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSDETreeNodeColBase.setPSDEUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSDETreeNodeColBase.setPSDEUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSDETreeNodeColBase.setPSSysDictCatId(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSDETreeNodeColBase.setPSSysDictCatName(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSDETreeNodeColBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSDETreeNodeColBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSDETreeNodeColBase.setPSSysEditorStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSDETreeNodeColBase.setPSSysEditorStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSDETreeNodeColBase.setRefPSDEACModeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSDETreeNodeColBase.setRefPSDEACModeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSDETreeNodeColBase.setRefPSDEDataSetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSDETreeNodeColBase.setRefPSDEDataSetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSDETreeNodeColBase.setRefPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSDETreeNodeColBase.setRefPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSDETreeNodeColBase.setResetItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSDETreeNodeColBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 67: {
                pSDETreeNodeColBase.setUpdateDV(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSDETreeNodeColBase.setUpdateDVT(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSDETreeNodeColBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 70: {
                pSDETreeNodeColBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 71: {
                pSDETreeNodeColBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 72: {
                pSDETreeNodeColBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 73: {
                pSDETreeNodeColBase.setValueFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 74: {
                pSDETreeNodeColBase.setValueItemName(DataObject.getStringValue((Object)object));
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
        return PSDETreeNodeColBase.isNull(this, n);
    }

    private static boolean isNull(PSDETreeNodeColBase pSDETreeNodeColBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDETreeNodeColBase.getAllowEmpty() == null;
            }
            case 1: {
                return pSDETreeNodeColBase.getCellPSSysCssId() == null;
            }
            case 2: {
                return pSDETreeNodeColBase.getCellPSSysCssName() == null;
            }
            case 3: {
                return pSDETreeNodeColBase.getCLConvertMode() == null;
            }
            case 4: {
                return pSDETreeNodeColBase.getCodeListConfigMode() == null;
            }
            case 5: {
                return pSDETreeNodeColBase.getCreateDate() == null;
            }
            case 6: {
                return pSDETreeNodeColBase.getCreateDV() == null;
            }
            case 7: {
                return pSDETreeNodeColBase.getCreateDVT() == null;
            }
            case 8: {
                return pSDETreeNodeColBase.getCreateMan() == null;
            }
            case 9: {
                return pSDETreeNodeColBase.getCustomCode() == null;
            }
            case 10: {
                return pSDETreeNodeColBase.getCustomMode() == null;
            }
            case 11: {
                return pSDETreeNodeColBase.getDefaultValue() == null;
            }
            case 12: {
                return pSDETreeNodeColBase.getEditorParams() == null;
            }
            case 13: {
                return pSDETreeNodeColBase.getEditorType() == null;
            }
            case 14: {
                return pSDETreeNodeColBase.getEnableCond() == null;
            }
            case 15: {
                return pSDETreeNodeColBase.getEnableItemPriv() == null;
            }
            case 16: {
                return pSDETreeNodeColBase.getEnableLink() == null;
            }
            case 17: {
                return pSDETreeNodeColBase.getEnableRowEdit() == null;
            }
            case 18: {
                return pSDETreeNodeColBase.getGCRPSSysPFPluginId() == null;
            }
            case 19: {
                return pSDETreeNodeColBase.getGCRPSSysPFPluginName() == null;
            }
            case 20: {
                return pSDETreeNodeColBase.getGridColStyle() == null;
            }
            case 21: {
                return pSDETreeNodeColBase.getGridColType() == null;
            }
            case 22: {
                return pSDETreeNodeColBase.getGroupItem() == null;
            }
            case 23: {
                return pSDETreeNodeColBase.getHiddenDataItem() == null;
            }
            case 24: {
                return pSDETreeNodeColBase.getIgnoreInput() == null;
            }
            case 25: {
                return pSDETreeNodeColBase.getLinkPSDEViewId() == null;
            }
            case 26: {
                return pSDETreeNodeColBase.getLinkPSDEViewName() == null;
            }
            case 27: {
                return pSDETreeNodeColBase.getMemo() == null;
            }
            case 28: {
                return pSDETreeNodeColBase.getNeedCodeListConfig() == null;
            }
            case 29: {
                return pSDETreeNodeColBase.getNoPrivDM() == null;
            }
            case 30: {
                return pSDETreeNodeColBase.getPickupPSDEViewId() == null;
            }
            case 31: {
                return pSDETreeNodeColBase.getPickupPSDEViewName() == null;
            }
            case 32: {
                return pSDETreeNodeColBase.getPlaceHolder() == null;
            }
            case 33: {
                return pSDETreeNodeColBase.getPSCodeListId() == null;
            }
            case 34: {
                return pSDETreeNodeColBase.getPSCodeListName() == null;
            }
            case 35: {
                return pSDETreeNodeColBase.getPSDEFId() == null;
            }
            case 36: {
                return pSDETreeNodeColBase.getPSDEFName() == null;
            }
            case 37: {
                return pSDETreeNodeColBase.getPSDEFUIModeId() == null;
            }
            case 38: {
                return pSDETreeNodeColBase.getPSDEFUIModeName() == null;
            }
            case 39: {
                return pSDETreeNodeColBase.getPSDETEIUpdateId() == null;
            }
            case 40: {
                return pSDETreeNodeColBase.getPSDETEIUpdateName() == null;
            }
            case 41: {
                return pSDETreeNodeColBase.getPSDETreeColId() == null;
            }
            case 42: {
                return pSDETreeNodeColBase.getPSDETreeColName() == null;
            }
            case 43: {
                return pSDETreeNodeColBase.getPSDETreeNodeColId() == null;
            }
            case 44: {
                return pSDETreeNodeColBase.getPSDETreeNodeColName() == null;
            }
            case 45: {
                return pSDETreeNodeColBase.getPSDETreeNodeId() == null;
            }
            case 46: {
                return pSDETreeNodeColBase.getPSDETreeNodeName() == null;
            }
            case 47: {
                return pSDETreeNodeColBase.getPSDETreeViewId() == null;
            }
            case 48: {
                return pSDETreeNodeColBase.getPSDETreeViewName() == null;
            }
            case 49: {
                return pSDETreeNodeColBase.getPSDEUAGroupId() == null;
            }
            case 50: {
                return pSDETreeNodeColBase.getPSDEUAGroupName() == null;
            }
            case 51: {
                return pSDETreeNodeColBase.getPSDEUIActionId() == null;
            }
            case 52: {
                return pSDETreeNodeColBase.getPSDEUIActionName() == null;
            }
            case 53: {
                return pSDETreeNodeColBase.getPSSysDictCatId() == null;
            }
            case 54: {
                return pSDETreeNodeColBase.getPSSysDictCatName() == null;
            }
            case 55: {
                return pSDETreeNodeColBase.getPSSysDynaModelId() == null;
            }
            case 56: {
                return pSDETreeNodeColBase.getPSSysDynaModelName() == null;
            }
            case 57: {
                return pSDETreeNodeColBase.getPSSysEditorStyleId() == null;
            }
            case 58: {
                return pSDETreeNodeColBase.getPSSysEditorStyleName() == null;
            }
            case 59: {
                return pSDETreeNodeColBase.getRefPSDEACModeId() == null;
            }
            case 60: {
                return pSDETreeNodeColBase.getRefPSDEACModeName() == null;
            }
            case 61: {
                return pSDETreeNodeColBase.getRefPSDEDataSetId() == null;
            }
            case 62: {
                return pSDETreeNodeColBase.getRefPSDEDataSetName() == null;
            }
            case 63: {
                return pSDETreeNodeColBase.getRefPSDEId() == null;
            }
            case 64: {
                return pSDETreeNodeColBase.getRefPSDEName() == null;
            }
            case 65: {
                return pSDETreeNodeColBase.getResetItemName() == null;
            }
            case 66: {
                return pSDETreeNodeColBase.getUpdateDate() == null;
            }
            case 67: {
                return pSDETreeNodeColBase.getUpdateDV() == null;
            }
            case 68: {
                return pSDETreeNodeColBase.getUpdateDVT() == null;
            }
            case 69: {
                return pSDETreeNodeColBase.getUpdateMan() == null;
            }
            case 70: {
                return pSDETreeNodeColBase.getUserCat() == null;
            }
            case 71: {
                return pSDETreeNodeColBase.getUserTag() == null;
            }
            case 72: {
                return pSDETreeNodeColBase.getUserTag2() == null;
            }
            case 73: {
                return pSDETreeNodeColBase.getValueFormat() == null;
            }
            case 74: {
                return pSDETreeNodeColBase.getValueItemName() == null;
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
        return PSDETreeNodeColBase.contains(this, n);
    }

    private static boolean contains(PSDETreeNodeColBase pSDETreeNodeColBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDETreeNodeColBase.isAllowEmptyDirty();
            }
            case 1: {
                return pSDETreeNodeColBase.isCellPSSysCssIdDirty();
            }
            case 2: {
                return pSDETreeNodeColBase.isCellPSSysCssNameDirty();
            }
            case 3: {
                return pSDETreeNodeColBase.isCLConvertModeDirty();
            }
            case 4: {
                return pSDETreeNodeColBase.isCodeListConfigModeDirty();
            }
            case 5: {
                return pSDETreeNodeColBase.isCreateDateDirty();
            }
            case 6: {
                return pSDETreeNodeColBase.isCreateDVDirty();
            }
            case 7: {
                return pSDETreeNodeColBase.isCreateDVTDirty();
            }
            case 8: {
                return pSDETreeNodeColBase.isCreateManDirty();
            }
            case 9: {
                return pSDETreeNodeColBase.isCustomCodeDirty();
            }
            case 10: {
                return pSDETreeNodeColBase.isCustomModeDirty();
            }
            case 11: {
                return pSDETreeNodeColBase.isDefaultValueDirty();
            }
            case 12: {
                return pSDETreeNodeColBase.isEditorParamsDirty();
            }
            case 13: {
                return pSDETreeNodeColBase.isEditorTypeDirty();
            }
            case 14: {
                return pSDETreeNodeColBase.isEnableCondDirty();
            }
            case 15: {
                return pSDETreeNodeColBase.isEnableItemPrivDirty();
            }
            case 16: {
                return pSDETreeNodeColBase.isEnableLinkDirty();
            }
            case 17: {
                return pSDETreeNodeColBase.isEnableRowEditDirty();
            }
            case 18: {
                return pSDETreeNodeColBase.isGCRPSSysPFPluginIdDirty();
            }
            case 19: {
                return pSDETreeNodeColBase.isGCRPSSysPFPluginNameDirty();
            }
            case 20: {
                return pSDETreeNodeColBase.isGridColStyleDirty();
            }
            case 21: {
                return pSDETreeNodeColBase.isGridColTypeDirty();
            }
            case 22: {
                return pSDETreeNodeColBase.isGroupItemDirty();
            }
            case 23: {
                return pSDETreeNodeColBase.isHiddenDataItemDirty();
            }
            case 24: {
                return pSDETreeNodeColBase.isIgnoreInputDirty();
            }
            case 25: {
                return pSDETreeNodeColBase.isLinkPSDEViewIdDirty();
            }
            case 26: {
                return pSDETreeNodeColBase.isLinkPSDEViewNameDirty();
            }
            case 27: {
                return pSDETreeNodeColBase.isMemoDirty();
            }
            case 28: {
                return pSDETreeNodeColBase.isNeedCodeListConfigDirty();
            }
            case 29: {
                return pSDETreeNodeColBase.isNoPrivDMDirty();
            }
            case 30: {
                return pSDETreeNodeColBase.isPickupPSDEViewIdDirty();
            }
            case 31: {
                return pSDETreeNodeColBase.isPickupPSDEViewNameDirty();
            }
            case 32: {
                return pSDETreeNodeColBase.isPlaceHolderDirty();
            }
            case 33: {
                return pSDETreeNodeColBase.isPSCodeListIdDirty();
            }
            case 34: {
                return pSDETreeNodeColBase.isPSCodeListNameDirty();
            }
            case 35: {
                return pSDETreeNodeColBase.isPSDEFIdDirty();
            }
            case 36: {
                return pSDETreeNodeColBase.isPSDEFNameDirty();
            }
            case 37: {
                return pSDETreeNodeColBase.isPSDEFUIModeIdDirty();
            }
            case 38: {
                return pSDETreeNodeColBase.isPSDEFUIModeNameDirty();
            }
            case 39: {
                return pSDETreeNodeColBase.isPSDETEIUpdateIdDirty();
            }
            case 40: {
                return pSDETreeNodeColBase.isPSDETEIUpdateNameDirty();
            }
            case 41: {
                return pSDETreeNodeColBase.isPSDETreeColIdDirty();
            }
            case 42: {
                return pSDETreeNodeColBase.isPSDETreeColNameDirty();
            }
            case 43: {
                return pSDETreeNodeColBase.isPSDETreeNodeColIdDirty();
            }
            case 44: {
                return pSDETreeNodeColBase.isPSDETreeNodeColNameDirty();
            }
            case 45: {
                return pSDETreeNodeColBase.isPSDETreeNodeIdDirty();
            }
            case 46: {
                return pSDETreeNodeColBase.isPSDETreeNodeNameDirty();
            }
            case 47: {
                return pSDETreeNodeColBase.isPSDETreeViewIdDirty();
            }
            case 48: {
                return pSDETreeNodeColBase.isPSDETreeViewNameDirty();
            }
            case 49: {
                return pSDETreeNodeColBase.isPSDEUAGroupIdDirty();
            }
            case 50: {
                return pSDETreeNodeColBase.isPSDEUAGroupNameDirty();
            }
            case 51: {
                return pSDETreeNodeColBase.isPSDEUIActionIdDirty();
            }
            case 52: {
                return pSDETreeNodeColBase.isPSDEUIActionNameDirty();
            }
            case 53: {
                return pSDETreeNodeColBase.isPSSysDictCatIdDirty();
            }
            case 54: {
                return pSDETreeNodeColBase.isPSSysDictCatNameDirty();
            }
            case 55: {
                return pSDETreeNodeColBase.isPSSysDynaModelIdDirty();
            }
            case 56: {
                return pSDETreeNodeColBase.isPSSysDynaModelNameDirty();
            }
            case 57: {
                return pSDETreeNodeColBase.isPSSysEditorStyleIdDirty();
            }
            case 58: {
                return pSDETreeNodeColBase.isPSSysEditorStyleNameDirty();
            }
            case 59: {
                return pSDETreeNodeColBase.isRefPSDEACModeIdDirty();
            }
            case 60: {
                return pSDETreeNodeColBase.isRefPSDEACModeNameDirty();
            }
            case 61: {
                return pSDETreeNodeColBase.isRefPSDEDataSetIdDirty();
            }
            case 62: {
                return pSDETreeNodeColBase.isRefPSDEDataSetNameDirty();
            }
            case 63: {
                return pSDETreeNodeColBase.isRefPSDEIdDirty();
            }
            case 64: {
                return pSDETreeNodeColBase.isRefPSDENameDirty();
            }
            case 65: {
                return pSDETreeNodeColBase.isResetItemNameDirty();
            }
            case 66: {
                return pSDETreeNodeColBase.isUpdateDateDirty();
            }
            case 67: {
                return pSDETreeNodeColBase.isUpdateDVDirty();
            }
            case 68: {
                return pSDETreeNodeColBase.isUpdateDVTDirty();
            }
            case 69: {
                return pSDETreeNodeColBase.isUpdateManDirty();
            }
            case 70: {
                return pSDETreeNodeColBase.isUserCatDirty();
            }
            case 71: {
                return pSDETreeNodeColBase.isUserTagDirty();
            }
            case 72: {
                return pSDETreeNodeColBase.isUserTag2Dirty();
            }
            case 73: {
                return pSDETreeNodeColBase.isValueFormatDirty();
            }
            case 74: {
                return pSDETreeNodeColBase.isValueItemNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDETreeNodeColBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDETreeNodeColBase pSDETreeNodeColBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDETreeNodeColBase.getAllowEmpty() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"allowempty", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getAllowEmpty()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getCellPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cellpssyscssid", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getCellPSSysCssId()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getCellPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cellpssyscssname", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getCellPSSysCssName()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getCLConvertMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clconvertmode", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getCLConvertMode()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getCodeListConfigMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codelistconfigmode", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getCodeListConfigMode()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getCreateDV() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdv", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getCreateDV()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getCreateDVT() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdvt", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getCreateDVT()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getDefaultValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultvalue", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getDefaultValue()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getEditorParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"editorparams", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getEditorParams()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getEditorType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"editortype", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getEditorType()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getEnableCond() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablecond", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getEnableCond()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getEnableItemPriv() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableitempriv", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getEnableItemPriv()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getEnableLink() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablelink", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getEnableLink()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getEnableRowEdit() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablerowedit", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getEnableRowEdit()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getGCRPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gcrpssyspfpluginid", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getGCRPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getGCRPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gcrpssyspfpluginname", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getGCRPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getGridColStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gridcolstyle", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getGridColStyle()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getGridColType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gridcoltype", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getGridColType()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getGroupItem() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupitem", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getGroupItem()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getHiddenDataItem() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hiddendataitem", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getHiddenDataItem()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getIgnoreInput() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ignoreinput", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getIgnoreInput()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getLinkPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkpsdeviewid", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getLinkPSDEViewId()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getLinkPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkpsdeviewname", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getLinkPSDEViewName()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getMemo()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getNeedCodeListConfig() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"needcodelistconfig", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getNeedCodeListConfig()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getNoPrivDM() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"noprivdm", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getNoPrivDM()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getPickupPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pickuppsdeviewid", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getPickupPSDEViewId()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getPickupPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pickuppsdeviewname", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getPickupPSDEViewName()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getPlaceHolder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"placeholder", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getPlaceHolder()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getPSCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistid", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getPSCodeListId()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getPSCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistname", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getPSCodeListName()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefid", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getPSDEFId()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefname", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getPSDEFName()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getPSDEFUIModeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefuimodeid", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getPSDEFUIModeId()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getPSDEFUIModeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefuimodename", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getPSDEFUIModeName()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getPSDETEIUpdateId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeteiupdateid", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getPSDETEIUpdateId()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getPSDETEIUpdateName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeteiupdatename", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getPSDETEIUpdateName()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getPSDETreeColId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreecolid", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getPSDETreeColId()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getPSDETreeColName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreecolname", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getPSDETreeColName()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getPSDETreeNodeColId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreenodecolid", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getPSDETreeNodeColId()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getPSDETreeNodeColName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreenodecolname", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getPSDETreeNodeColName()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getPSDETreeNodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreenodeid", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getPSDETreeNodeId()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getPSDETreeNodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreenodename", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getPSDETreeNodeName()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getPSDETreeViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreeviewid", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getPSDETreeViewId()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getPSDETreeViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreeviewname", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getPSDETreeViewName()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getPSDEUAGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuagroupid", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getPSDEUAGroupId()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getPSDEUAGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuagroupname", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getPSDEUAGroupName()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getPSDEUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionid", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getPSDEUIActionId()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getPSDEUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionname", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getPSDEUIActionName()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getPSSysDictCatId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdictcatid", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getPSSysDictCatId()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getPSSysDictCatName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdictcatname", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getPSSysDictCatName()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getPSSysEditorStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseditorstyleid", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getPSSysEditorStyleId()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getPSSysEditorStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseditorstylename", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getPSSysEditorStyleName()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getRefPSDEACModeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdeacmodeid", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getRefPSDEACModeId()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getRefPSDEACModeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdeacmodename", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getRefPSDEACModeName()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getRefPSDEDataSetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdedatasetid", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getRefPSDEDataSetId()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getRefPSDEDataSetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdedatasetname", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getRefPSDEDataSetName()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getRefPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdeid", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getRefPSDEId()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getRefPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdename", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getRefPSDEName()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getResetItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resetitemname", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getResetItemName()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getUpdateDV() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedv", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getUpdateDV()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getUpdateDVT() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedvt", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getUpdateDVT()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getValueFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valueformat", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getValueFormat()), (boolean)false);
        }
        if (bl || pSDETreeNodeColBase.getValueItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valueitemname", (Object)PSDETreeNodeColBase.getJSONValue((Object)pSDETreeNodeColBase.getValueItemName()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDETreeNodeColBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDETreeNodeColBase pSDETreeNodeColBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDETreeNodeColBase.getAllowEmpty() != null) {
            object = pSDETreeNodeColBase.getAllowEmpty();
            xmlNode.setAttribute(FIELD_ALLOWEMPTY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeNodeColBase.getCellPSSysCssId() != null) {
            object = pSDETreeNodeColBase.getCellPSSysCssId();
            xmlNode.setAttribute(FIELD_CELLPSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getCellPSSysCssName() != null) {
            object = pSDETreeNodeColBase.getCellPSSysCssName();
            xmlNode.setAttribute(FIELD_CELLPSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getCLConvertMode() != null) {
            object = pSDETreeNodeColBase.getCLConvertMode();
            xmlNode.setAttribute(FIELD_CLCONVERTMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getCodeListConfigMode() != null) {
            object = pSDETreeNodeColBase.getCodeListConfigMode();
            xmlNode.setAttribute(FIELD_CODELISTCONFIGMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeNodeColBase.getCreateDate() != null) {
            object = pSDETreeNodeColBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDETreeNodeColBase.getCreateDV() != null) {
            object = pSDETreeNodeColBase.getCreateDV();
            xmlNode.setAttribute(FIELD_CREATEDV, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getCreateDVT() != null) {
            object = pSDETreeNodeColBase.getCreateDVT();
            xmlNode.setAttribute(FIELD_CREATEDVT, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getCreateMan() != null) {
            object = pSDETreeNodeColBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getCustomCode() != null) {
            object = pSDETreeNodeColBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getCustomMode() != null) {
            object = pSDETreeNodeColBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeNodeColBase.getDefaultValue() != null) {
            object = pSDETreeNodeColBase.getDefaultValue();
            xmlNode.setAttribute(FIELD_DEFAULTVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getEditorParams() != null) {
            object = pSDETreeNodeColBase.getEditorParams();
            xmlNode.setAttribute(FIELD_EDITORPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getEditorType() != null) {
            object = pSDETreeNodeColBase.getEditorType();
            xmlNode.setAttribute(FIELD_EDITORTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getEnableCond() != null) {
            object = pSDETreeNodeColBase.getEnableCond();
            xmlNode.setAttribute(FIELD_ENABLECOND, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeNodeColBase.getEnableItemPriv() != null) {
            object = pSDETreeNodeColBase.getEnableItemPriv();
            xmlNode.setAttribute(FIELD_ENABLEITEMPRIV, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeNodeColBase.getEnableLink() != null) {
            object = pSDETreeNodeColBase.getEnableLink();
            xmlNode.setAttribute(FIELD_ENABLELINK, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeNodeColBase.getEnableRowEdit() != null) {
            object = pSDETreeNodeColBase.getEnableRowEdit();
            xmlNode.setAttribute(FIELD_ENABLEROWEDIT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeNodeColBase.getGCRPSSysPFPluginId() != null) {
            object = pSDETreeNodeColBase.getGCRPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_GCRPSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getGCRPSSysPFPluginName() != null) {
            object = pSDETreeNodeColBase.getGCRPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_GCRPSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getGridColStyle() != null) {
            object = pSDETreeNodeColBase.getGridColStyle();
            xmlNode.setAttribute(FIELD_GRIDCOLSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getGridColType() != null) {
            object = pSDETreeNodeColBase.getGridColType();
            xmlNode.setAttribute(FIELD_GRIDCOLTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getGroupItem() != null) {
            object = pSDETreeNodeColBase.getGroupItem();
            xmlNode.setAttribute(FIELD_GROUPITEM, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getHiddenDataItem() != null) {
            object = pSDETreeNodeColBase.getHiddenDataItem();
            xmlNode.setAttribute(FIELD_HIDDENDATAITEM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeNodeColBase.getIgnoreInput() != null) {
            object = pSDETreeNodeColBase.getIgnoreInput();
            xmlNode.setAttribute(FIELD_IGNOREINPUT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeNodeColBase.getLinkPSDEViewId() != null) {
            object = pSDETreeNodeColBase.getLinkPSDEViewId();
            xmlNode.setAttribute(FIELD_LINKPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getLinkPSDEViewName() != null) {
            object = pSDETreeNodeColBase.getLinkPSDEViewName();
            xmlNode.setAttribute(FIELD_LINKPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getMemo() != null) {
            object = pSDETreeNodeColBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getNeedCodeListConfig() != null) {
            object = pSDETreeNodeColBase.getNeedCodeListConfig();
            xmlNode.setAttribute(FIELD_NEEDCODELISTCONFIG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeNodeColBase.getNoPrivDM() != null) {
            object = pSDETreeNodeColBase.getNoPrivDM();
            xmlNode.setAttribute(FIELD_NOPRIVDM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeNodeColBase.getPickupPSDEViewId() != null) {
            object = pSDETreeNodeColBase.getPickupPSDEViewId();
            xmlNode.setAttribute(FIELD_PICKUPPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getPickupPSDEViewName() != null) {
            object = pSDETreeNodeColBase.getPickupPSDEViewName();
            xmlNode.setAttribute(FIELD_PICKUPPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getPlaceHolder() != null) {
            object = pSDETreeNodeColBase.getPlaceHolder();
            xmlNode.setAttribute(FIELD_PLACEHOLDER, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getPSCodeListId() != null) {
            object = pSDETreeNodeColBase.getPSCodeListId();
            xmlNode.setAttribute(FIELD_PSCODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getPSCodeListName() != null) {
            object = pSDETreeNodeColBase.getPSCodeListName();
            xmlNode.setAttribute(FIELD_PSCODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getPSDEFId() != null) {
            object = pSDETreeNodeColBase.getPSDEFId();
            xmlNode.setAttribute(FIELD_PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getPSDEFName() != null) {
            object = pSDETreeNodeColBase.getPSDEFName();
            xmlNode.setAttribute(FIELD_PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getPSDEFUIModeId() != null) {
            object = pSDETreeNodeColBase.getPSDEFUIModeId();
            xmlNode.setAttribute(FIELD_PSDEFUIMODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getPSDEFUIModeName() != null) {
            object = pSDETreeNodeColBase.getPSDEFUIModeName();
            xmlNode.setAttribute(FIELD_PSDEFUIMODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getPSDETEIUpdateId() != null) {
            object = pSDETreeNodeColBase.getPSDETEIUpdateId();
            xmlNode.setAttribute(FIELD_PSDETEIUPDATEID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getPSDETEIUpdateName() != null) {
            object = pSDETreeNodeColBase.getPSDETEIUpdateName();
            xmlNode.setAttribute(FIELD_PSDETEIUPDATENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getPSDETreeColId() != null) {
            object = pSDETreeNodeColBase.getPSDETreeColId();
            xmlNode.setAttribute(FIELD_PSDETREECOLID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getPSDETreeColName() != null) {
            object = pSDETreeNodeColBase.getPSDETreeColName();
            xmlNode.setAttribute(FIELD_PSDETREECOLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getPSDETreeNodeColId() != null) {
            object = pSDETreeNodeColBase.getPSDETreeNodeColId();
            xmlNode.setAttribute(FIELD_PSDETREENODECOLID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getPSDETreeNodeColName() != null) {
            object = pSDETreeNodeColBase.getPSDETreeNodeColName();
            xmlNode.setAttribute(FIELD_PSDETREENODECOLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getPSDETreeNodeId() != null) {
            object = pSDETreeNodeColBase.getPSDETreeNodeId();
            xmlNode.setAttribute(FIELD_PSDETREENODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getPSDETreeNodeName() != null) {
            object = pSDETreeNodeColBase.getPSDETreeNodeName();
            xmlNode.setAttribute(FIELD_PSDETREENODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getPSDETreeViewId() != null) {
            object = pSDETreeNodeColBase.getPSDETreeViewId();
            xmlNode.setAttribute(FIELD_PSDETREEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getPSDETreeViewName() != null) {
            object = pSDETreeNodeColBase.getPSDETreeViewName();
            xmlNode.setAttribute(FIELD_PSDETREEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getPSDEUAGroupId() != null) {
            object = pSDETreeNodeColBase.getPSDEUAGroupId();
            xmlNode.setAttribute(FIELD_PSDEUAGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getPSDEUAGroupName() != null) {
            object = pSDETreeNodeColBase.getPSDEUAGroupName();
            xmlNode.setAttribute(FIELD_PSDEUAGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getPSDEUIActionId() != null) {
            object = pSDETreeNodeColBase.getPSDEUIActionId();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getPSDEUIActionName() != null) {
            object = pSDETreeNodeColBase.getPSDEUIActionName();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getPSSysDictCatId() != null) {
            object = pSDETreeNodeColBase.getPSSysDictCatId();
            xmlNode.setAttribute(FIELD_PSSYSDICTCATID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getPSSysDictCatName() != null) {
            object = pSDETreeNodeColBase.getPSSysDictCatName();
            xmlNode.setAttribute(FIELD_PSSYSDICTCATNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getPSSysDynaModelId() != null) {
            object = pSDETreeNodeColBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getPSSysDynaModelName() != null) {
            object = pSDETreeNodeColBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getPSSysEditorStyleId() != null) {
            object = pSDETreeNodeColBase.getPSSysEditorStyleId();
            xmlNode.setAttribute(FIELD_PSSYSEDITORSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getPSSysEditorStyleName() != null) {
            object = pSDETreeNodeColBase.getPSSysEditorStyleName();
            xmlNode.setAttribute(FIELD_PSSYSEDITORSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getRefPSDEACModeId() != null) {
            object = pSDETreeNodeColBase.getRefPSDEACModeId();
            xmlNode.setAttribute(FIELD_REFPSDEACMODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getRefPSDEACModeName() != null) {
            object = pSDETreeNodeColBase.getRefPSDEACModeName();
            xmlNode.setAttribute(FIELD_REFPSDEACMODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getRefPSDEDataSetId() != null) {
            object = pSDETreeNodeColBase.getRefPSDEDataSetId();
            xmlNode.setAttribute(FIELD_REFPSDEDATASETID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getRefPSDEDataSetName() != null) {
            object = pSDETreeNodeColBase.getRefPSDEDataSetName();
            xmlNode.setAttribute(FIELD_REFPSDEDATASETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getRefPSDEId() != null) {
            object = pSDETreeNodeColBase.getRefPSDEId();
            xmlNode.setAttribute(FIELD_REFPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getRefPSDEName() != null) {
            object = pSDETreeNodeColBase.getRefPSDEName();
            xmlNode.setAttribute(FIELD_REFPSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getResetItemName() != null) {
            object = pSDETreeNodeColBase.getResetItemName();
            xmlNode.setAttribute(FIELD_RESETITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getUpdateDate() != null) {
            object = pSDETreeNodeColBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDETreeNodeColBase.getUpdateDV() != null) {
            object = pSDETreeNodeColBase.getUpdateDV();
            xmlNode.setAttribute(FIELD_UPDATEDV, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getUpdateDVT() != null) {
            object = pSDETreeNodeColBase.getUpdateDVT();
            xmlNode.setAttribute(FIELD_UPDATEDVT, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getUpdateMan() != null) {
            object = pSDETreeNodeColBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getUserCat() != null) {
            object = pSDETreeNodeColBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getUserTag() != null) {
            object = pSDETreeNodeColBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getUserTag2() != null) {
            object = pSDETreeNodeColBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getValueFormat() != null) {
            object = pSDETreeNodeColBase.getValueFormat();
            xmlNode.setAttribute(FIELD_VALUEFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeColBase.getValueItemName() != null) {
            object = pSDETreeNodeColBase.getValueItemName();
            xmlNode.setAttribute(FIELD_VALUEITEMNAME, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDETreeNodeColBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDETreeNodeColBase pSDETreeNodeColBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDETreeNodeColBase.isAllowEmptyDirty() && (bl || pSDETreeNodeColBase.getAllowEmpty() != null)) {
            iDataObject.set(FIELD_ALLOWEMPTY, (Object)pSDETreeNodeColBase.getAllowEmpty());
        }
        if (pSDETreeNodeColBase.isCellPSSysCssIdDirty() && (bl || pSDETreeNodeColBase.getCellPSSysCssId() != null)) {
            iDataObject.set(FIELD_CELLPSSYSCSSID, (Object)pSDETreeNodeColBase.getCellPSSysCssId());
        }
        if (pSDETreeNodeColBase.isCellPSSysCssNameDirty() && (bl || pSDETreeNodeColBase.getCellPSSysCssName() != null)) {
            iDataObject.set(FIELD_CELLPSSYSCSSNAME, (Object)pSDETreeNodeColBase.getCellPSSysCssName());
        }
        if (pSDETreeNodeColBase.isCLConvertModeDirty() && (bl || pSDETreeNodeColBase.getCLConvertMode() != null)) {
            iDataObject.set(FIELD_CLCONVERTMODE, (Object)pSDETreeNodeColBase.getCLConvertMode());
        }
        if (pSDETreeNodeColBase.isCodeListConfigModeDirty() && (bl || pSDETreeNodeColBase.getCodeListConfigMode() != null)) {
            iDataObject.set(FIELD_CODELISTCONFIGMODE, (Object)pSDETreeNodeColBase.getCodeListConfigMode());
        }
        if (pSDETreeNodeColBase.isCreateDateDirty() && (bl || pSDETreeNodeColBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDETreeNodeColBase.getCreateDate());
        }
        if (pSDETreeNodeColBase.isCreateDVDirty() && (bl || pSDETreeNodeColBase.getCreateDV() != null)) {
            iDataObject.set(FIELD_CREATEDV, (Object)pSDETreeNodeColBase.getCreateDV());
        }
        if (pSDETreeNodeColBase.isCreateDVTDirty() && (bl || pSDETreeNodeColBase.getCreateDVT() != null)) {
            iDataObject.set(FIELD_CREATEDVT, (Object)pSDETreeNodeColBase.getCreateDVT());
        }
        if (pSDETreeNodeColBase.isCreateManDirty() && (bl || pSDETreeNodeColBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDETreeNodeColBase.getCreateMan());
        }
        if (pSDETreeNodeColBase.isCustomCodeDirty() && (bl || pSDETreeNodeColBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSDETreeNodeColBase.getCustomCode());
        }
        if (pSDETreeNodeColBase.isCustomModeDirty() && (bl || pSDETreeNodeColBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSDETreeNodeColBase.getCustomMode());
        }
        if (pSDETreeNodeColBase.isDefaultValueDirty() && (bl || pSDETreeNodeColBase.getDefaultValue() != null)) {
            iDataObject.set(FIELD_DEFAULTVALUE, (Object)pSDETreeNodeColBase.getDefaultValue());
        }
        if (pSDETreeNodeColBase.isEditorParamsDirty() && (bl || pSDETreeNodeColBase.getEditorParams() != null)) {
            iDataObject.set(FIELD_EDITORPARAMS, (Object)pSDETreeNodeColBase.getEditorParams());
        }
        if (pSDETreeNodeColBase.isEditorTypeDirty() && (bl || pSDETreeNodeColBase.getEditorType() != null)) {
            iDataObject.set(FIELD_EDITORTYPE, (Object)pSDETreeNodeColBase.getEditorType());
        }
        if (pSDETreeNodeColBase.isEnableCondDirty() && (bl || pSDETreeNodeColBase.getEnableCond() != null)) {
            iDataObject.set(FIELD_ENABLECOND, (Object)pSDETreeNodeColBase.getEnableCond());
        }
        if (pSDETreeNodeColBase.isEnableItemPrivDirty() && (bl || pSDETreeNodeColBase.getEnableItemPriv() != null)) {
            iDataObject.set(FIELD_ENABLEITEMPRIV, (Object)pSDETreeNodeColBase.getEnableItemPriv());
        }
        if (pSDETreeNodeColBase.isEnableLinkDirty() && (bl || pSDETreeNodeColBase.getEnableLink() != null)) {
            iDataObject.set(FIELD_ENABLELINK, (Object)pSDETreeNodeColBase.getEnableLink());
        }
        if (pSDETreeNodeColBase.isEnableRowEditDirty() && (bl || pSDETreeNodeColBase.getEnableRowEdit() != null)) {
            iDataObject.set(FIELD_ENABLEROWEDIT, (Object)pSDETreeNodeColBase.getEnableRowEdit());
        }
        if (pSDETreeNodeColBase.isGCRPSSysPFPluginIdDirty() && (bl || pSDETreeNodeColBase.getGCRPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_GCRPSSYSPFPLUGINID, (Object)pSDETreeNodeColBase.getGCRPSSysPFPluginId());
        }
        if (pSDETreeNodeColBase.isGCRPSSysPFPluginNameDirty() && (bl || pSDETreeNodeColBase.getGCRPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_GCRPSSYSPFPLUGINNAME, (Object)pSDETreeNodeColBase.getGCRPSSysPFPluginName());
        }
        if (pSDETreeNodeColBase.isGridColStyleDirty() && (bl || pSDETreeNodeColBase.getGridColStyle() != null)) {
            iDataObject.set(FIELD_GRIDCOLSTYLE, (Object)pSDETreeNodeColBase.getGridColStyle());
        }
        if (pSDETreeNodeColBase.isGridColTypeDirty() && (bl || pSDETreeNodeColBase.getGridColType() != null)) {
            iDataObject.set(FIELD_GRIDCOLTYPE, (Object)pSDETreeNodeColBase.getGridColType());
        }
        if (pSDETreeNodeColBase.isGroupItemDirty() && (bl || pSDETreeNodeColBase.getGroupItem() != null)) {
            iDataObject.set(FIELD_GROUPITEM, (Object)pSDETreeNodeColBase.getGroupItem());
        }
        if (pSDETreeNodeColBase.isHiddenDataItemDirty() && (bl || pSDETreeNodeColBase.getHiddenDataItem() != null)) {
            iDataObject.set(FIELD_HIDDENDATAITEM, (Object)pSDETreeNodeColBase.getHiddenDataItem());
        }
        if (pSDETreeNodeColBase.isIgnoreInputDirty() && (bl || pSDETreeNodeColBase.getIgnoreInput() != null)) {
            iDataObject.set(FIELD_IGNOREINPUT, (Object)pSDETreeNodeColBase.getIgnoreInput());
        }
        if (pSDETreeNodeColBase.isLinkPSDEViewIdDirty() && (bl || pSDETreeNodeColBase.getLinkPSDEViewId() != null)) {
            iDataObject.set(FIELD_LINKPSDEVIEWID, (Object)pSDETreeNodeColBase.getLinkPSDEViewId());
        }
        if (pSDETreeNodeColBase.isLinkPSDEViewNameDirty() && (bl || pSDETreeNodeColBase.getLinkPSDEViewName() != null)) {
            iDataObject.set(FIELD_LINKPSDEVIEWNAME, (Object)pSDETreeNodeColBase.getLinkPSDEViewName());
        }
        if (pSDETreeNodeColBase.isMemoDirty() && (bl || pSDETreeNodeColBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDETreeNodeColBase.getMemo());
        }
        if (pSDETreeNodeColBase.isNeedCodeListConfigDirty() && (bl || pSDETreeNodeColBase.getNeedCodeListConfig() != null)) {
            iDataObject.set(FIELD_NEEDCODELISTCONFIG, (Object)pSDETreeNodeColBase.getNeedCodeListConfig());
        }
        if (pSDETreeNodeColBase.isNoPrivDMDirty() && (bl || pSDETreeNodeColBase.getNoPrivDM() != null)) {
            iDataObject.set(FIELD_NOPRIVDM, (Object)pSDETreeNodeColBase.getNoPrivDM());
        }
        if (pSDETreeNodeColBase.isPickupPSDEViewIdDirty() && (bl || pSDETreeNodeColBase.getPickupPSDEViewId() != null)) {
            iDataObject.set(FIELD_PICKUPPSDEVIEWID, (Object)pSDETreeNodeColBase.getPickupPSDEViewId());
        }
        if (pSDETreeNodeColBase.isPickupPSDEViewNameDirty() && (bl || pSDETreeNodeColBase.getPickupPSDEViewName() != null)) {
            iDataObject.set(FIELD_PICKUPPSDEVIEWNAME, (Object)pSDETreeNodeColBase.getPickupPSDEViewName());
        }
        if (pSDETreeNodeColBase.isPlaceHolderDirty() && (bl || pSDETreeNodeColBase.getPlaceHolder() != null)) {
            iDataObject.set(FIELD_PLACEHOLDER, (Object)pSDETreeNodeColBase.getPlaceHolder());
        }
        if (pSDETreeNodeColBase.isPSCodeListIdDirty() && (bl || pSDETreeNodeColBase.getPSCodeListId() != null)) {
            iDataObject.set(FIELD_PSCODELISTID, (Object)pSDETreeNodeColBase.getPSCodeListId());
        }
        if (pSDETreeNodeColBase.isPSCodeListNameDirty() && (bl || pSDETreeNodeColBase.getPSCodeListName() != null)) {
            iDataObject.set(FIELD_PSCODELISTNAME, (Object)pSDETreeNodeColBase.getPSCodeListName());
        }
        if (pSDETreeNodeColBase.isPSDEFIdDirty() && (bl || pSDETreeNodeColBase.getPSDEFId() != null)) {
            iDataObject.set(FIELD_PSDEFID, (Object)pSDETreeNodeColBase.getPSDEFId());
        }
        if (pSDETreeNodeColBase.isPSDEFNameDirty() && (bl || pSDETreeNodeColBase.getPSDEFName() != null)) {
            iDataObject.set(FIELD_PSDEFNAME, (Object)pSDETreeNodeColBase.getPSDEFName());
        }
        if (pSDETreeNodeColBase.isPSDEFUIModeIdDirty() && (bl || pSDETreeNodeColBase.getPSDEFUIModeId() != null)) {
            iDataObject.set(FIELD_PSDEFUIMODEID, (Object)pSDETreeNodeColBase.getPSDEFUIModeId());
        }
        if (pSDETreeNodeColBase.isPSDEFUIModeNameDirty() && (bl || pSDETreeNodeColBase.getPSDEFUIModeName() != null)) {
            iDataObject.set(FIELD_PSDEFUIMODENAME, (Object)pSDETreeNodeColBase.getPSDEFUIModeName());
        }
        if (pSDETreeNodeColBase.isPSDETEIUpdateIdDirty() && (bl || pSDETreeNodeColBase.getPSDETEIUpdateId() != null)) {
            iDataObject.set(FIELD_PSDETEIUPDATEID, (Object)pSDETreeNodeColBase.getPSDETEIUpdateId());
        }
        if (pSDETreeNodeColBase.isPSDETEIUpdateNameDirty() && (bl || pSDETreeNodeColBase.getPSDETEIUpdateName() != null)) {
            iDataObject.set(FIELD_PSDETEIUPDATENAME, (Object)pSDETreeNodeColBase.getPSDETEIUpdateName());
        }
        if (pSDETreeNodeColBase.isPSDETreeColIdDirty() && (bl || pSDETreeNodeColBase.getPSDETreeColId() != null)) {
            iDataObject.set(FIELD_PSDETREECOLID, (Object)pSDETreeNodeColBase.getPSDETreeColId());
        }
        if (pSDETreeNodeColBase.isPSDETreeColNameDirty() && (bl || pSDETreeNodeColBase.getPSDETreeColName() != null)) {
            iDataObject.set(FIELD_PSDETREECOLNAME, (Object)pSDETreeNodeColBase.getPSDETreeColName());
        }
        if (pSDETreeNodeColBase.isPSDETreeNodeColIdDirty() && (bl || pSDETreeNodeColBase.getPSDETreeNodeColId() != null)) {
            iDataObject.set(FIELD_PSDETREENODECOLID, (Object)pSDETreeNodeColBase.getPSDETreeNodeColId());
        }
        if (pSDETreeNodeColBase.isPSDETreeNodeColNameDirty() && (bl || pSDETreeNodeColBase.getPSDETreeNodeColName() != null)) {
            iDataObject.set(FIELD_PSDETREENODECOLNAME, (Object)pSDETreeNodeColBase.getPSDETreeNodeColName());
        }
        if (pSDETreeNodeColBase.isPSDETreeNodeIdDirty() && (bl || pSDETreeNodeColBase.getPSDETreeNodeId() != null)) {
            iDataObject.set(FIELD_PSDETREENODEID, (Object)pSDETreeNodeColBase.getPSDETreeNodeId());
        }
        if (pSDETreeNodeColBase.isPSDETreeNodeNameDirty() && (bl || pSDETreeNodeColBase.getPSDETreeNodeName() != null)) {
            iDataObject.set(FIELD_PSDETREENODENAME, (Object)pSDETreeNodeColBase.getPSDETreeNodeName());
        }
        if (pSDETreeNodeColBase.isPSDETreeViewIdDirty() && (bl || pSDETreeNodeColBase.getPSDETreeViewId() != null)) {
            iDataObject.set(FIELD_PSDETREEVIEWID, (Object)pSDETreeNodeColBase.getPSDETreeViewId());
        }
        if (pSDETreeNodeColBase.isPSDETreeViewNameDirty() && (bl || pSDETreeNodeColBase.getPSDETreeViewName() != null)) {
            iDataObject.set(FIELD_PSDETREEVIEWNAME, (Object)pSDETreeNodeColBase.getPSDETreeViewName());
        }
        if (pSDETreeNodeColBase.isPSDEUAGroupIdDirty() && (bl || pSDETreeNodeColBase.getPSDEUAGroupId() != null)) {
            iDataObject.set(FIELD_PSDEUAGROUPID, (Object)pSDETreeNodeColBase.getPSDEUAGroupId());
        }
        if (pSDETreeNodeColBase.isPSDEUAGroupNameDirty() && (bl || pSDETreeNodeColBase.getPSDEUAGroupName() != null)) {
            iDataObject.set(FIELD_PSDEUAGROUPNAME, (Object)pSDETreeNodeColBase.getPSDEUAGroupName());
        }
        if (pSDETreeNodeColBase.isPSDEUIActionIdDirty() && (bl || pSDETreeNodeColBase.getPSDEUIActionId() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONID, (Object)pSDETreeNodeColBase.getPSDEUIActionId());
        }
        if (pSDETreeNodeColBase.isPSDEUIActionNameDirty() && (bl || pSDETreeNodeColBase.getPSDEUIActionName() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONNAME, (Object)pSDETreeNodeColBase.getPSDEUIActionName());
        }
        if (pSDETreeNodeColBase.isPSSysDictCatIdDirty() && (bl || pSDETreeNodeColBase.getPSSysDictCatId() != null)) {
            iDataObject.set(FIELD_PSSYSDICTCATID, (Object)pSDETreeNodeColBase.getPSSysDictCatId());
        }
        if (pSDETreeNodeColBase.isPSSysDictCatNameDirty() && (bl || pSDETreeNodeColBase.getPSSysDictCatName() != null)) {
            iDataObject.set(FIELD_PSSYSDICTCATNAME, (Object)pSDETreeNodeColBase.getPSSysDictCatName());
        }
        if (pSDETreeNodeColBase.isPSSysDynaModelIdDirty() && (bl || pSDETreeNodeColBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSDETreeNodeColBase.getPSSysDynaModelId());
        }
        if (pSDETreeNodeColBase.isPSSysDynaModelNameDirty() && (bl || pSDETreeNodeColBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSDETreeNodeColBase.getPSSysDynaModelName());
        }
        if (pSDETreeNodeColBase.isPSSysEditorStyleIdDirty() && (bl || pSDETreeNodeColBase.getPSSysEditorStyleId() != null)) {
            iDataObject.set(FIELD_PSSYSEDITORSTYLEID, (Object)pSDETreeNodeColBase.getPSSysEditorStyleId());
        }
        if (pSDETreeNodeColBase.isPSSysEditorStyleNameDirty() && (bl || pSDETreeNodeColBase.getPSSysEditorStyleName() != null)) {
            iDataObject.set(FIELD_PSSYSEDITORSTYLENAME, (Object)pSDETreeNodeColBase.getPSSysEditorStyleName());
        }
        if (pSDETreeNodeColBase.isRefPSDEACModeIdDirty() && (bl || pSDETreeNodeColBase.getRefPSDEACModeId() != null)) {
            iDataObject.set(FIELD_REFPSDEACMODEID, (Object)pSDETreeNodeColBase.getRefPSDEACModeId());
        }
        if (pSDETreeNodeColBase.isRefPSDEACModeNameDirty() && (bl || pSDETreeNodeColBase.getRefPSDEACModeName() != null)) {
            iDataObject.set(FIELD_REFPSDEACMODENAME, (Object)pSDETreeNodeColBase.getRefPSDEACModeName());
        }
        if (pSDETreeNodeColBase.isRefPSDEDataSetIdDirty() && (bl || pSDETreeNodeColBase.getRefPSDEDataSetId() != null)) {
            iDataObject.set(FIELD_REFPSDEDATASETID, (Object)pSDETreeNodeColBase.getRefPSDEDataSetId());
        }
        if (pSDETreeNodeColBase.isRefPSDEDataSetNameDirty() && (bl || pSDETreeNodeColBase.getRefPSDEDataSetName() != null)) {
            iDataObject.set(FIELD_REFPSDEDATASETNAME, (Object)pSDETreeNodeColBase.getRefPSDEDataSetName());
        }
        if (pSDETreeNodeColBase.isRefPSDEIdDirty() && (bl || pSDETreeNodeColBase.getRefPSDEId() != null)) {
            iDataObject.set(FIELD_REFPSDEID, (Object)pSDETreeNodeColBase.getRefPSDEId());
        }
        if (pSDETreeNodeColBase.isRefPSDENameDirty() && (bl || pSDETreeNodeColBase.getRefPSDEName() != null)) {
            iDataObject.set(FIELD_REFPSDENAME, (Object)pSDETreeNodeColBase.getRefPSDEName());
        }
        if (pSDETreeNodeColBase.isResetItemNameDirty() && (bl || pSDETreeNodeColBase.getResetItemName() != null)) {
            iDataObject.set(FIELD_RESETITEMNAME, (Object)pSDETreeNodeColBase.getResetItemName());
        }
        if (pSDETreeNodeColBase.isUpdateDateDirty() && (bl || pSDETreeNodeColBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDETreeNodeColBase.getUpdateDate());
        }
        if (pSDETreeNodeColBase.isUpdateDVDirty() && (bl || pSDETreeNodeColBase.getUpdateDV() != null)) {
            iDataObject.set(FIELD_UPDATEDV, (Object)pSDETreeNodeColBase.getUpdateDV());
        }
        if (pSDETreeNodeColBase.isUpdateDVTDirty() && (bl || pSDETreeNodeColBase.getUpdateDVT() != null)) {
            iDataObject.set(FIELD_UPDATEDVT, (Object)pSDETreeNodeColBase.getUpdateDVT());
        }
        if (pSDETreeNodeColBase.isUpdateManDirty() && (bl || pSDETreeNodeColBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDETreeNodeColBase.getUpdateMan());
        }
        if (pSDETreeNodeColBase.isUserCatDirty() && (bl || pSDETreeNodeColBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDETreeNodeColBase.getUserCat());
        }
        if (pSDETreeNodeColBase.isUserTagDirty() && (bl || pSDETreeNodeColBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDETreeNodeColBase.getUserTag());
        }
        if (pSDETreeNodeColBase.isUserTag2Dirty() && (bl || pSDETreeNodeColBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDETreeNodeColBase.getUserTag2());
        }
        if (pSDETreeNodeColBase.isValueFormatDirty() && (bl || pSDETreeNodeColBase.getValueFormat() != null)) {
            iDataObject.set(FIELD_VALUEFORMAT, (Object)pSDETreeNodeColBase.getValueFormat());
        }
        if (pSDETreeNodeColBase.isValueItemNameDirty() && (bl || pSDETreeNodeColBase.getValueItemName() != null)) {
            iDataObject.set(FIELD_VALUEITEMNAME, (Object)pSDETreeNodeColBase.getValueItemName());
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
        return PSDETreeNodeColBase.remove(this, n);
    }

    private static boolean remove(PSDETreeNodeColBase pSDETreeNodeColBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDETreeNodeColBase.resetAllowEmpty();
                return true;
            }
            case 1: {
                pSDETreeNodeColBase.resetCellPSSysCssId();
                return true;
            }
            case 2: {
                pSDETreeNodeColBase.resetCellPSSysCssName();
                return true;
            }
            case 3: {
                pSDETreeNodeColBase.resetCLConvertMode();
                return true;
            }
            case 4: {
                pSDETreeNodeColBase.resetCodeListConfigMode();
                return true;
            }
            case 5: {
                pSDETreeNodeColBase.resetCreateDate();
                return true;
            }
            case 6: {
                pSDETreeNodeColBase.resetCreateDV();
                return true;
            }
            case 7: {
                pSDETreeNodeColBase.resetCreateDVT();
                return true;
            }
            case 8: {
                pSDETreeNodeColBase.resetCreateMan();
                return true;
            }
            case 9: {
                pSDETreeNodeColBase.resetCustomCode();
                return true;
            }
            case 10: {
                pSDETreeNodeColBase.resetCustomMode();
                return true;
            }
            case 11: {
                pSDETreeNodeColBase.resetDefaultValue();
                return true;
            }
            case 12: {
                pSDETreeNodeColBase.resetEditorParams();
                return true;
            }
            case 13: {
                pSDETreeNodeColBase.resetEditorType();
                return true;
            }
            case 14: {
                pSDETreeNodeColBase.resetEnableCond();
                return true;
            }
            case 15: {
                pSDETreeNodeColBase.resetEnableItemPriv();
                return true;
            }
            case 16: {
                pSDETreeNodeColBase.resetEnableLink();
                return true;
            }
            case 17: {
                pSDETreeNodeColBase.resetEnableRowEdit();
                return true;
            }
            case 18: {
                pSDETreeNodeColBase.resetGCRPSSysPFPluginId();
                return true;
            }
            case 19: {
                pSDETreeNodeColBase.resetGCRPSSysPFPluginName();
                return true;
            }
            case 20: {
                pSDETreeNodeColBase.resetGridColStyle();
                return true;
            }
            case 21: {
                pSDETreeNodeColBase.resetGridColType();
                return true;
            }
            case 22: {
                pSDETreeNodeColBase.resetGroupItem();
                return true;
            }
            case 23: {
                pSDETreeNodeColBase.resetHiddenDataItem();
                return true;
            }
            case 24: {
                pSDETreeNodeColBase.resetIgnoreInput();
                return true;
            }
            case 25: {
                pSDETreeNodeColBase.resetLinkPSDEViewId();
                return true;
            }
            case 26: {
                pSDETreeNodeColBase.resetLinkPSDEViewName();
                return true;
            }
            case 27: {
                pSDETreeNodeColBase.resetMemo();
                return true;
            }
            case 28: {
                pSDETreeNodeColBase.resetNeedCodeListConfig();
                return true;
            }
            case 29: {
                pSDETreeNodeColBase.resetNoPrivDM();
                return true;
            }
            case 30: {
                pSDETreeNodeColBase.resetPickupPSDEViewId();
                return true;
            }
            case 31: {
                pSDETreeNodeColBase.resetPickupPSDEViewName();
                return true;
            }
            case 32: {
                pSDETreeNodeColBase.resetPlaceHolder();
                return true;
            }
            case 33: {
                pSDETreeNodeColBase.resetPSCodeListId();
                return true;
            }
            case 34: {
                pSDETreeNodeColBase.resetPSCodeListName();
                return true;
            }
            case 35: {
                pSDETreeNodeColBase.resetPSDEFId();
                return true;
            }
            case 36: {
                pSDETreeNodeColBase.resetPSDEFName();
                return true;
            }
            case 37: {
                pSDETreeNodeColBase.resetPSDEFUIModeId();
                return true;
            }
            case 38: {
                pSDETreeNodeColBase.resetPSDEFUIModeName();
                return true;
            }
            case 39: {
                pSDETreeNodeColBase.resetPSDETEIUpdateId();
                return true;
            }
            case 40: {
                pSDETreeNodeColBase.resetPSDETEIUpdateName();
                return true;
            }
            case 41: {
                pSDETreeNodeColBase.resetPSDETreeColId();
                return true;
            }
            case 42: {
                pSDETreeNodeColBase.resetPSDETreeColName();
                return true;
            }
            case 43: {
                pSDETreeNodeColBase.resetPSDETreeNodeColId();
                return true;
            }
            case 44: {
                pSDETreeNodeColBase.resetPSDETreeNodeColName();
                return true;
            }
            case 45: {
                pSDETreeNodeColBase.resetPSDETreeNodeId();
                return true;
            }
            case 46: {
                pSDETreeNodeColBase.resetPSDETreeNodeName();
                return true;
            }
            case 47: {
                pSDETreeNodeColBase.resetPSDETreeViewId();
                return true;
            }
            case 48: {
                pSDETreeNodeColBase.resetPSDETreeViewName();
                return true;
            }
            case 49: {
                pSDETreeNodeColBase.resetPSDEUAGroupId();
                return true;
            }
            case 50: {
                pSDETreeNodeColBase.resetPSDEUAGroupName();
                return true;
            }
            case 51: {
                pSDETreeNodeColBase.resetPSDEUIActionId();
                return true;
            }
            case 52: {
                pSDETreeNodeColBase.resetPSDEUIActionName();
                return true;
            }
            case 53: {
                pSDETreeNodeColBase.resetPSSysDictCatId();
                return true;
            }
            case 54: {
                pSDETreeNodeColBase.resetPSSysDictCatName();
                return true;
            }
            case 55: {
                pSDETreeNodeColBase.resetPSSysDynaModelId();
                return true;
            }
            case 56: {
                pSDETreeNodeColBase.resetPSSysDynaModelName();
                return true;
            }
            case 57: {
                pSDETreeNodeColBase.resetPSSysEditorStyleId();
                return true;
            }
            case 58: {
                pSDETreeNodeColBase.resetPSSysEditorStyleName();
                return true;
            }
            case 59: {
                pSDETreeNodeColBase.resetRefPSDEACModeId();
                return true;
            }
            case 60: {
                pSDETreeNodeColBase.resetRefPSDEACModeName();
                return true;
            }
            case 61: {
                pSDETreeNodeColBase.resetRefPSDEDataSetId();
                return true;
            }
            case 62: {
                pSDETreeNodeColBase.resetRefPSDEDataSetName();
                return true;
            }
            case 63: {
                pSDETreeNodeColBase.resetRefPSDEId();
                return true;
            }
            case 64: {
                pSDETreeNodeColBase.resetRefPSDEName();
                return true;
            }
            case 65: {
                pSDETreeNodeColBase.resetResetItemName();
                return true;
            }
            case 66: {
                pSDETreeNodeColBase.resetUpdateDate();
                return true;
            }
            case 67: {
                pSDETreeNodeColBase.resetUpdateDV();
                return true;
            }
            case 68: {
                pSDETreeNodeColBase.resetUpdateDVT();
                return true;
            }
            case 69: {
                pSDETreeNodeColBase.resetUpdateMan();
                return true;
            }
            case 70: {
                pSDETreeNodeColBase.resetUserCat();
                return true;
            }
            case 71: {
                pSDETreeNodeColBase.resetUserTag();
                return true;
            }
            case 72: {
                pSDETreeNodeColBase.resetUserTag2();
                return true;
            }
            case 73: {
                pSDETreeNodeColBase.resetValueFormat();
                return true;
            }
            case 74: {
                pSDETreeNodeColBase.resetValueItemName();
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
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
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
                pSDEACModeService.autoGet((IEntity)pSDEACMode);
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
                pSDEDataSetService.autoGet((IEntity)pSDEDataSet);
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
                pSDEFUIModeService.autoGet((IEntity)pSDEFUIMode);
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
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.psdef = pSDEField;
            }
            return this.psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDETEIUpdate getPSDETEIUpdate() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETEIUpdate();
        }
        if (this.getPSDETEIUpdateId() == null) {
            return null;
        }
        Integer n = this.objPSDETEIUpdateLock;
        synchronized (n) {
            if (this.psdeteiupdate != null && DataTypeHelper.compare((int)25, (Object)this.getPSDETEIUpdateId(), (Object)this.psdeteiupdate.getPSDETEIUpdateId()) != 0L) {
                this.psdeteiupdate = null;
            }
            if (this.psdeteiupdate == null) {
                PSDETEIUpdate pSDETEIUpdate = new PSDETEIUpdate();
                pSDETEIUpdate.setPSDETEIUpdateId(this.getPSDETEIUpdateId());
                PSDETEIUpdateService pSDETEIUpdateService = (PSDETEIUpdateService)ServiceGlobal.getService(PSDETEIUpdateService.class, (SessionFactory)this.getSessionFactory());
                pSDETEIUpdateService.autoGet((IEntity)pSDETEIUpdate);
                this.psdeteiupdate = pSDETEIUpdate;
            }
            return this.psdeteiupdate;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDETreeCol getPSDETreeCol() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeCol();
        }
        if (this.getPSDETreeColId() == null) {
            return null;
        }
        Integer n = this.objPSDETreeColLock;
        synchronized (n) {
            if (this.psdetreecol != null && DataTypeHelper.compare((int)25, (Object)this.getPSDETreeColId(), (Object)this.psdetreecol.getPSDETreeColId()) != 0L) {
                this.psdetreecol = null;
            }
            if (this.psdetreecol == null) {
                PSDETreeCol pSDETreeCol = new PSDETreeCol();
                pSDETreeCol.setPSDETreeColId(this.getPSDETreeColId());
                PSDETreeColService pSDETreeColService = (PSDETreeColService)ServiceGlobal.getService(PSDETreeColService.class, (SessionFactory)this.getSessionFactory());
                pSDETreeColService.autoGet((IEntity)pSDETreeCol);
                this.psdetreecol = pSDETreeCol;
            }
            return this.psdetreecol;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDETreeNode getPSDETreeNode() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeNode();
        }
        if (this.getPSDETreeNodeId() == null) {
            return null;
        }
        Integer n = this.objPSDETreeNodeLock;
        synchronized (n) {
            if (this.psdetreenode != null && DataTypeHelper.compare((int)25, (Object)this.getPSDETreeNodeId(), (Object)this.psdetreenode.getPSDETreeNodeId()) != 0L) {
                this.psdetreenode = null;
            }
            if (this.psdetreenode == null) {
                PSDETreeNode pSDETreeNode = new PSDETreeNode();
                pSDETreeNode.setPSDETreeNodeId(this.getPSDETreeNodeId());
                PSDETreeNodeService pSDETreeNodeService = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
                pSDETreeNodeService.autoGet((IEntity)pSDETreeNode);
                this.psdetreenode = pSDETreeNode;
            }
            return this.psdetreenode;
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
                pSDETreeViewService.autoGet((IEntity)pSDETreeView);
                this.psdetreeview = pSDETreeView;
            }
            return this.psdetreeview;
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
                pSDEViewBaseService.autoGet((IEntity)pSDEViewBase);
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
                pSDEViewBaseService.autoGet((IEntity)pSDEViewBase);
                this.pickuppsdeview = pSDEViewBase;
            }
            return this.pickuppsdeview;
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
                pSSysCssService.autoGet((IEntity)pSSysCss);
                this.cellpssyscss = pSSysCss;
            }
            return this.cellpssyscss;
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
                pSSysDictCatService.autoGet((IEntity)pSSysDictCat);
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
                pSSysDynaModelService.autoGet((IEntity)pSSysDynaModel);
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
                pSSysEditorStyleService.autoGet((IEntity)pSSysEditorStyle);
                this.pssyseditorstyle = pSSysEditorStyle;
            }
            return this.pssyseditorstyle;
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
                pSSysPFPluginService.autoGet((IEntity)pSSysPFPlugin);
                this.gcrpssyspfplugin = pSSysPFPlugin;
            }
            return this.gcrpssyspfplugin;
        }
    }

    private PSDETreeNodeColBase getProxyEntity() {
        return this.proxyPSDETreeNodeColBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDETreeNodeColBase = null;
        if (iDataObject != null && iDataObject instanceof PSDETreeNodeColBase) {
            this.proxyPSDETreeNodeColBase = (PSDETreeNodeColBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeColService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLOWEMPTY, 0);
        fieldIndexMap.put(FIELD_CELLPSSYSCSSID, 1);
        fieldIndexMap.put(FIELD_CELLPSSYSCSSNAME, 2);
        fieldIndexMap.put(FIELD_CLCONVERTMODE, 3);
        fieldIndexMap.put(FIELD_CODELISTCONFIGMODE, 4);
        fieldIndexMap.put(FIELD_CREATEDATE, 5);
        fieldIndexMap.put(FIELD_CREATEDV, 6);
        fieldIndexMap.put(FIELD_CREATEDVT, 7);
        fieldIndexMap.put(FIELD_CREATEMAN, 8);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 9);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 10);
        fieldIndexMap.put(FIELD_DEFAULTVALUE, 11);
        fieldIndexMap.put(FIELD_EDITORPARAMS, 12);
        fieldIndexMap.put(FIELD_EDITORTYPE, 13);
        fieldIndexMap.put(FIELD_ENABLECOND, 14);
        fieldIndexMap.put(FIELD_ENABLEITEMPRIV, 15);
        fieldIndexMap.put(FIELD_ENABLELINK, 16);
        fieldIndexMap.put(FIELD_ENABLEROWEDIT, 17);
        fieldIndexMap.put(FIELD_GCRPSSYSPFPLUGINID, 18);
        fieldIndexMap.put(FIELD_GCRPSSYSPFPLUGINNAME, 19);
        fieldIndexMap.put(FIELD_GRIDCOLSTYLE, 20);
        fieldIndexMap.put(FIELD_GRIDCOLTYPE, 21);
        fieldIndexMap.put(FIELD_GROUPITEM, 22);
        fieldIndexMap.put(FIELD_HIDDENDATAITEM, 23);
        fieldIndexMap.put(FIELD_IGNOREINPUT, 24);
        fieldIndexMap.put(FIELD_LINKPSDEVIEWID, 25);
        fieldIndexMap.put(FIELD_LINKPSDEVIEWNAME, 26);
        fieldIndexMap.put(FIELD_MEMO, 27);
        fieldIndexMap.put(FIELD_NEEDCODELISTCONFIG, 28);
        fieldIndexMap.put(FIELD_NOPRIVDM, 29);
        fieldIndexMap.put(FIELD_PICKUPPSDEVIEWID, 30);
        fieldIndexMap.put(FIELD_PICKUPPSDEVIEWNAME, 31);
        fieldIndexMap.put(FIELD_PLACEHOLDER, 32);
        fieldIndexMap.put(FIELD_PSCODELISTID, 33);
        fieldIndexMap.put(FIELD_PSCODELISTNAME, 34);
        fieldIndexMap.put(FIELD_PSDEFID, 35);
        fieldIndexMap.put(FIELD_PSDEFNAME, 36);
        fieldIndexMap.put(FIELD_PSDEFUIMODEID, 37);
        fieldIndexMap.put(FIELD_PSDEFUIMODENAME, 38);
        fieldIndexMap.put(FIELD_PSDETEIUPDATEID, 39);
        fieldIndexMap.put(FIELD_PSDETEIUPDATENAME, 40);
        fieldIndexMap.put(FIELD_PSDETREECOLID, 41);
        fieldIndexMap.put(FIELD_PSDETREECOLNAME, 42);
        fieldIndexMap.put(FIELD_PSDETREENODECOLID, 43);
        fieldIndexMap.put(FIELD_PSDETREENODECOLNAME, 44);
        fieldIndexMap.put(FIELD_PSDETREENODEID, 45);
        fieldIndexMap.put(FIELD_PSDETREENODENAME, 46);
        fieldIndexMap.put(FIELD_PSDETREEVIEWID, 47);
        fieldIndexMap.put(FIELD_PSDETREEVIEWNAME, 48);
        fieldIndexMap.put(FIELD_PSDEUAGROUPID, 49);
        fieldIndexMap.put(FIELD_PSDEUAGROUPNAME, 50);
        fieldIndexMap.put(FIELD_PSDEUIACTIONID, 51);
        fieldIndexMap.put(FIELD_PSDEUIACTIONNAME, 52);
        fieldIndexMap.put(FIELD_PSSYSDICTCATID, 53);
        fieldIndexMap.put(FIELD_PSSYSDICTCATNAME, 54);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 55);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 56);
        fieldIndexMap.put(FIELD_PSSYSEDITORSTYLEID, 57);
        fieldIndexMap.put(FIELD_PSSYSEDITORSTYLENAME, 58);
        fieldIndexMap.put(FIELD_REFPSDEACMODEID, 59);
        fieldIndexMap.put(FIELD_REFPSDEACMODENAME, 60);
        fieldIndexMap.put(FIELD_REFPSDEDATASETID, 61);
        fieldIndexMap.put(FIELD_REFPSDEDATASETNAME, 62);
        fieldIndexMap.put(FIELD_REFPSDEID, 63);
        fieldIndexMap.put(FIELD_REFPSDENAME, 64);
        fieldIndexMap.put(FIELD_RESETITEMNAME, 65);
        fieldIndexMap.put(FIELD_UPDATEDATE, 66);
        fieldIndexMap.put(FIELD_UPDATEDV, 67);
        fieldIndexMap.put(FIELD_UPDATEDVT, 68);
        fieldIndexMap.put(FIELD_UPDATEMAN, 69);
        fieldIndexMap.put(FIELD_USERCAT, 70);
        fieldIndexMap.put(FIELD_USERTAG, 71);
        fieldIndexMap.put(FIELD_USERTAG2, 72);
        fieldIndexMap.put(FIELD_VALUEFORMAT, 73);
        fieldIndexMap.put(FIELD_VALUEITEMNAME, 74);
    }
}

