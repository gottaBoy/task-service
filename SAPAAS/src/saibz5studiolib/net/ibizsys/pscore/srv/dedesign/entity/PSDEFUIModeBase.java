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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFInputTip;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFInputTipService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandler;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDictCat;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysEditorStyle;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUnit;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysValueRule;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDictCatService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysEditorStyleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUnitService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysValueRuleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFUIModeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEFUIModeBase.class);
    public static final String FIELD_ALLOWEMPTY = "ALLOWEMPTY";
    public static final String FIELD_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String FIELD_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String FIELD_CAPTION = "CAPTION";
    public static final String FIELD_CODELISTCONFIGMODE = "CODELISTCONFIGMODE";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CONVERTCITEXT = "CONVERTCITEXT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEDV = "CREATEDV";
    public static final String FIELD_CREATEDVT = "CREATEDVT";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_EDITORPARAMS = "EDITORPARAMS";
    public static final String FIELD_EDITORTYPE = "EDITORTYPE";
    public static final String FIELD_EDITORTYPENAME = "EDITORTYPENAME";
    public static final String FIELD_ENABLEINPUTTIP = "ENABLEINPUTTIP";
    public static final String FIELD_ENABLERESETITEMNAME = "ENABLERESETITEMNAME";
    public static final String FIELD_ENABLEUNITNAME = "ENABLEUNITNAME";
    public static final String FIELD_ENABLEVALUERULE = "ENABLEVALUERULE";
    public static final String FIELD_FTMODE = "FTMODE";
    public static final String FIELD_GCRPSSYSPFPLUGINID = "GCRPSSYSPFPLUGINID";
    public static final String FIELD_GCRPSSYSPFPLUGINNAME = "GCRPSSYSPFPLUGINNAME";
    public static final String FIELD_GRIDCOLALIGN = "GRIDCOLALIGN";
    public static final String FIELD_GRIDCOLCLMODE = "GRIDCOLCLMODE";
    public static final String FIELD_GRIDCOLWIDTH = "GRIDCOLWIDTH";
    public static final String FIELD_HEIGHT = "HEIGHT";
    public static final String FIELD_IGNOREINPUT = "IGNOREINPUT";
    public static final String FIELD_ITEMPSACHANDLERID = "ITEMPSACHANDLERID";
    public static final String FIELD_ITEMPSACHANDLERNAME = "ITEMPSACHANDLERNAME";
    public static final String FIELD_JSFORMAT = "JSFORMAT";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MAXVALUE = "MAXVALUE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MINSTRLENGTH = "MINSTRLENGTH";
    public static final String FIELD_MINVALUE = "MINVALUE";
    public static final String FIELD_NEEDCODELISTCONFIG = "NEEDCODELISTCONFIG";
    public static final String FIELD_NOSORT = "NOSORT";
    public static final String FIELD_PHPSLANRESID = "PHPSLANRESID";
    public static final String FIELD_PHPSLANRESNAME = "PHPSLANRESNAME";
    public static final String FIELD_PICKUPTEXTOPTS = "PICKUPTEXTOPTS";
    public static final String FIELD_PLACEHOLDER = "PLACEHOLDER";
    public static final String FIELD_PRECISION2 = "PRECISION2";
    public static final String FIELD_PREVENTXSS = "PREVENTXSS";
    public static final String FIELD_PSCODELISTID = "PSCODELISTID";
    public static final String FIELD_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String FIELD_PSDEFUIMODEID = "PSDEFFORMITEMID";
    public static final String FIELD_PSDEFUIMODENAME = "PSDEFFORMITEMNAME";
    public static final String FIELD_PSDEFID = "PSDEFID";
    public static final String FIELD_PSDEFINPUTTIPID = "PSDEFINPUTTIPID";
    public static final String FIELD_PSDEFINPUTTIPNAME = "PSDEFINPUTTIPNAME";
    public static final String FIELD_PSDEFNAME = "PSDEFNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_PSSYSDICTCATID = "PSSYSDICTCATID";
    public static final String FIELD_PSSYSDICTCATNAME = "PSSYSDICTCATNAME";
    public static final String FIELD_PSSYSEDITORSTYLEID = "PSSYSEDITORSTYLEID";
    public static final String FIELD_PSSYSEDITORSTYLENAME = "PSSYSEDITORSTYLENAME";
    public static final String FIELD_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String FIELD_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSUNITID = "PSSYSUNITID";
    public static final String FIELD_PSSYSUNITNAME = "PSSYSUNITNAME";
    public static final String FIELD_PSSYSVALUERULEID = "PSSYSVALUERULEID";
    public static final String FIELD_PSSYSVALUERULENAME = "PSSYSVALUERULENAME";
    public static final String FIELD_REFADPSDELOGICID = "REFADPSDELOGICID";
    public static final String FIELD_REFADPSDELOGICNAME = "REFADPSDELOGICNAME";
    public static final String FIELD_REFLINKPSDEVIEWID = "REFLINKPSDEVIEWID";
    public static final String FIELD_REFLINKPSDEVIEWNAME = "REFLINKPSDEVIEWNAME";
    public static final String FIELD_REFMPICKUPPSDEVIEWID = "REFMPICKUPPSDEVIEWID";
    public static final String FIELD_REFMPICKUPPSDEVIEWNAME = "REFMPICKUPPSDEVIEWNAME";
    public static final String FIELD_REFPICKUPPSDEVIEWID = "REFPICKUPPSDEVIEWID";
    public static final String FIELD_REFPICKUPPSDEVIEWNAME = "REFPICKUPPSDEVIEWNAME";
    public static final String FIELD_REFPSDEACMODEID = "REFPSDEACMODEID";
    public static final String FIELD_REFPSDEACMODENAME = "REFPSDEACMODENAME";
    public static final String FIELD_REFPSDEDATASETID = "REFPSDEDATASETID";
    public static final String FIELD_REFPSDEDATASETNAME = "REFPSDEDATASETNAME";
    public static final String FIELD_REFPSDEID = "REFPSDEID";
    public static final String FIELD_REFPSDENAME = "REFPSDENAME";
    public static final String FIELD_REFPSDERID = "REFPSDERID";
    public static final String FIELD_REFPSDERNAME = "REFPSDERNAME";
    public static final String FIELD_REFTEMPDATA = "REFTEMPDATA";
    public static final String FIELD_RESETITEMNAME = "RESETITEMNAME";
    public static final String FIELD_STRINGCASE = "STRINGCASE";
    public static final String FIELD_STRLENGTH = "STRLENGTH";
    public static final String FIELD_UNITNAME = "UNITNAME";
    public static final String FIELD_UNITNAMEWIDTH = "UNITNAMEWIDTH";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEDV = "UPDATEDV";
    public static final String FIELD_UPDATEDVT = "UPDATEDVT";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALUEFORMAT = "VALUEFORMAT";
    public static final String FIELD_VALUEITEMNAME = "VALUEITEMNAME";
    public static final String FIELD_WIDTH = "WIDTH";
    private static final int INDEX_ALLOWEMPTY = 0;
    private static final int INDEX_CAPPSLANRESID = 1;
    private static final int INDEX_CAPPSLANRESNAME = 2;
    private static final int INDEX_CAPTION = 3;
    private static final int INDEX_CODELISTCONFIGMODE = 4;
    private static final int INDEX_CODENAME = 5;
    private static final int INDEX_CONVERTCITEXT = 6;
    private static final int INDEX_CREATEDATE = 7;
    private static final int INDEX_CREATEDV = 8;
    private static final int INDEX_CREATEDVT = 9;
    private static final int INDEX_CREATEMAN = 10;
    private static final int INDEX_DYNAMODELFLAG = 11;
    private static final int INDEX_EDITORPARAMS = 12;
    private static final int INDEX_EDITORTYPE = 13;
    private static final int INDEX_EDITORTYPENAME = 14;
    private static final int INDEX_ENABLEINPUTTIP = 15;
    private static final int INDEX_ENABLERESETITEMNAME = 16;
    private static final int INDEX_ENABLEUNITNAME = 17;
    private static final int INDEX_ENABLEVALUERULE = 18;
    private static final int INDEX_FTMODE = 19;
    private static final int INDEX_GCRPSSYSPFPLUGINID = 20;
    private static final int INDEX_GCRPSSYSPFPLUGINNAME = 21;
    private static final int INDEX_GRIDCOLALIGN = 22;
    private static final int INDEX_GRIDCOLCLMODE = 23;
    private static final int INDEX_GRIDCOLWIDTH = 24;
    private static final int INDEX_HEIGHT = 25;
    private static final int INDEX_IGNOREINPUT = 26;
    private static final int INDEX_ITEMPSACHANDLERID = 27;
    private static final int INDEX_ITEMPSACHANDLERNAME = 28;
    private static final int INDEX_JSFORMAT = 29;
    private static final int INDEX_LOCKFLAG = 30;
    private static final int INDEX_MAXVALUE = 31;
    private static final int INDEX_MEMO = 32;
    private static final int INDEX_MINSTRLENGTH = 33;
    private static final int INDEX_MINVALUE = 34;
    private static final int INDEX_NEEDCODELISTCONFIG = 35;
    private static final int INDEX_NOSORT = 36;
    private static final int INDEX_PHPSLANRESID = 37;
    private static final int INDEX_PHPSLANRESNAME = 38;
    private static final int INDEX_PICKUPTEXTOPTS = 39;
    private static final int INDEX_PLACEHOLDER = 40;
    private static final int INDEX_PRECISION2 = 41;
    private static final int INDEX_PREVENTXSS = 42;
    private static final int INDEX_PSCODELISTID = 43;
    private static final int INDEX_PSCODELISTNAME = 44;
    private static final int INDEX_PSDEFUIMODEID = 45;
    private static final int INDEX_PSDEFUIMODENAME = 46;
    private static final int INDEX_PSDEFID = 47;
    private static final int INDEX_PSDEFINPUTTIPID = 48;
    private static final int INDEX_PSDEFINPUTTIPNAME = 49;
    private static final int INDEX_PSDEFNAME = 50;
    private static final int INDEX_PSDEID = 51;
    private static final int INDEX_PSDENAME = 52;
    private static final int INDEX_PSDYNAINSTID = 53;
    private static final int INDEX_PSSYSAPPID = 54;
    private static final int INDEX_PSSYSAPPNAME = 55;
    private static final int INDEX_PSSYSDICTCATID = 56;
    private static final int INDEX_PSSYSDICTCATNAME = 57;
    private static final int INDEX_PSSYSEDITORSTYLEID = 58;
    private static final int INDEX_PSSYSEDITORSTYLENAME = 59;
    private static final int INDEX_PSSYSIMAGEID = 60;
    private static final int INDEX_PSSYSIMAGENAME = 61;
    private static final int INDEX_PSSYSTEMID = 62;
    private static final int INDEX_PSSYSUNITID = 63;
    private static final int INDEX_PSSYSUNITNAME = 64;
    private static final int INDEX_PSSYSVALUERULEID = 65;
    private static final int INDEX_PSSYSVALUERULENAME = 66;
    private static final int INDEX_REFADPSDELOGICID = 67;
    private static final int INDEX_REFADPSDELOGICNAME = 68;
    private static final int INDEX_REFLINKPSDEVIEWID = 69;
    private static final int INDEX_REFLINKPSDEVIEWNAME = 70;
    private static final int INDEX_REFMPICKUPPSDEVIEWID = 71;
    private static final int INDEX_REFMPICKUPPSDEVIEWNAME = 72;
    private static final int INDEX_REFPICKUPPSDEVIEWID = 73;
    private static final int INDEX_REFPICKUPPSDEVIEWNAME = 74;
    private static final int INDEX_REFPSDEACMODEID = 75;
    private static final int INDEX_REFPSDEACMODENAME = 76;
    private static final int INDEX_REFPSDEDATASETID = 77;
    private static final int INDEX_REFPSDEDATASETNAME = 78;
    private static final int INDEX_REFPSDEID = 79;
    private static final int INDEX_REFPSDENAME = 80;
    private static final int INDEX_REFPSDERID = 81;
    private static final int INDEX_REFPSDERNAME = 82;
    private static final int INDEX_REFTEMPDATA = 83;
    private static final int INDEX_RESETITEMNAME = 84;
    private static final int INDEX_STRINGCASE = 85;
    private static final int INDEX_STRLENGTH = 86;
    private static final int INDEX_UNITNAME = 87;
    private static final int INDEX_UNITNAMEWIDTH = 88;
    private static final int INDEX_UPDATEDATE = 89;
    private static final int INDEX_UPDATEDV = 90;
    private static final int INDEX_UPDATEDVT = 91;
    private static final int INDEX_UPDATEMAN = 92;
    private static final int INDEX_USERCAT = 93;
    private static final int INDEX_USERPARAMS = 94;
    private static final int INDEX_USERTAG = 95;
    private static final int INDEX_USERTAG2 = 96;
    private static final int INDEX_USERTAG3 = 97;
    private static final int INDEX_USERTAG4 = 98;
    private static final int INDEX_VALUEFORMAT = 99;
    private static final int INDEX_VALUEITEMNAME = 100;
    private static final int INDEX_WIDTH = 101;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEFUIModeBase proxyPSDEFUIModeBase = null;
    private boolean allowemptyDirtyFlag = false;
    private boolean cappslanresidDirtyFlag = false;
    private boolean cappslanresnameDirtyFlag = false;
    private boolean captionDirtyFlag = false;
    private boolean codelistconfigmodeDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean convertcitextDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createdvDirtyFlag = false;
    private boolean createdvtDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean editorparamsDirtyFlag = false;
    private boolean editortypeDirtyFlag = false;
    private boolean editortypenameDirtyFlag = false;
    private boolean enableinputtipDirtyFlag = false;
    private boolean enableresetitemnameDirtyFlag = false;
    private boolean enableunitnameDirtyFlag = false;
    private boolean enablevalueruleDirtyFlag = false;
    private boolean ftmodeDirtyFlag = false;
    private boolean gcrpssyspfpluginidDirtyFlag = false;
    private boolean gcrpssyspfpluginnameDirtyFlag = false;
    private boolean gridcolalignDirtyFlag = false;
    private boolean gridcolclmodeDirtyFlag = false;
    private boolean gridcolwidthDirtyFlag = false;
    private boolean heightDirtyFlag = false;
    private boolean ignoreinputDirtyFlag = false;
    private boolean itempsachandleridDirtyFlag = false;
    private boolean itempsachandlernameDirtyFlag = false;
    private boolean jsformatDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean maxvalueDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean minstrlengthDirtyFlag = false;
    private boolean minvalueDirtyFlag = false;
    private boolean needcodelistconfigDirtyFlag = false;
    private boolean nosortDirtyFlag = false;
    private boolean phpslanresidDirtyFlag = false;
    private boolean phpslanresnameDirtyFlag = false;
    private boolean pickuptextoptsDirtyFlag = false;
    private boolean placeholderDirtyFlag = false;
    private boolean precision2DirtyFlag = false;
    private boolean preventxssDirtyFlag = false;
    private boolean pscodelistidDirtyFlag = false;
    private boolean pscodelistnameDirtyFlag = false;
    private boolean psdefuimodeidDirtyFlag = false;
    private boolean psdefuimodenameDirtyFlag = false;
    private boolean psdefidDirtyFlag = false;
    private boolean psdefinputtipidDirtyFlag = false;
    private boolean psdefinputtipnameDirtyFlag = false;
    private boolean psdefnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean pssysdictcatidDirtyFlag = false;
    private boolean pssysdictcatnameDirtyFlag = false;
    private boolean pssyseditorstyleidDirtyFlag = false;
    private boolean pssyseditorstylenameDirtyFlag = false;
    private boolean pssysimageidDirtyFlag = false;
    private boolean pssysimagenameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssysunitidDirtyFlag = false;
    private boolean pssysunitnameDirtyFlag = false;
    private boolean pssysvalueruleidDirtyFlag = false;
    private boolean pssysvaluerulenameDirtyFlag = false;
    private boolean refadpsdelogicidDirtyFlag = false;
    private boolean refadpsdelogicnameDirtyFlag = false;
    private boolean reflinkpsdeviewidDirtyFlag = false;
    private boolean reflinkpsdeviewnameDirtyFlag = false;
    private boolean refmpickuppsdeviewidDirtyFlag = false;
    private boolean refmpickuppsdeviewnameDirtyFlag = false;
    private boolean refpickuppsdeviewidDirtyFlag = false;
    private boolean refpickuppsdeviewnameDirtyFlag = false;
    private boolean refpsdeacmodeidDirtyFlag = false;
    private boolean refpsdeacmodenameDirtyFlag = false;
    private boolean refpsdedatasetidDirtyFlag = false;
    private boolean refpsdedatasetnameDirtyFlag = false;
    private boolean refpsdeidDirtyFlag = false;
    private boolean refpsdenameDirtyFlag = false;
    private boolean refpsderidDirtyFlag = false;
    private boolean refpsdernameDirtyFlag = false;
    private boolean reftempdataDirtyFlag = false;
    private boolean resetitemnameDirtyFlag = false;
    private boolean stringcaseDirtyFlag = false;
    private boolean strlengthDirtyFlag = false;
    private boolean unitnameDirtyFlag = false;
    private boolean unitnamewidthDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatedvDirtyFlag = false;
    private boolean updatedvtDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean valueformatDirtyFlag = false;
    private boolean valueitemnameDirtyFlag = false;
    private boolean widthDirtyFlag = false;
    @Column(name="allowempty")
    private Integer allowempty;
    @Column(name="cappslanresid")
    private String cappslanresid;
    @Column(name="cappslanresname")
    private String cappslanresname;
    @Column(name="caption")
    private String caption;
    @Column(name="codelistconfigmode")
    private Integer codelistconfigmode;
    @Column(name="codename")
    private String codename;
    @Column(name="convertcitext")
    private Integer convertcitext;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createdv")
    private String createdv;
    @Column(name="createdvt")
    private String createdvt;
    @Column(name="createman")
    private String createman;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="editorparams")
    private String editorparams;
    @Column(name="editortype")
    private String editortype;
    @Column(name="editortypename")
    private String editortypename;
    @Column(name="enableinputtip")
    private Integer enableinputtip;
    @Column(name="enableresetitemname")
    private Integer enableresetitemname;
    @Column(name="enableunitname")
    private Integer enableunitname;
    @Column(name="enablevaluerule")
    private Integer enablevaluerule;
    @Column(name="ftmode")
    private String ftmode;
    @Column(name="gcrpssyspfpluginid")
    private String gcrpssyspfpluginid;
    @Column(name="gcrpssyspfpluginname")
    private String gcrpssyspfpluginname;
    @Column(name="gridcolalign")
    private String gridcolalign;
    @Column(name="gridcolclmode")
    private String gridcolclmode;
    @Column(name="gridcolwidth")
    private Integer gridcolwidth;
    @Column(name="height")
    private Integer height;
    @Column(name="ignoreinput")
    private Integer ignoreinput;
    @Column(name="itempsachandlerid")
    private String itempsachandlerid;
    @Column(name="itempsachandlername")
    private String itempsachandlername;
    @Column(name="jsformat")
    private String jsformat;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="maxvalue")
    private String maxvalue;
    @Column(name="memo")
    private String memo;
    @Column(name="minstrlength")
    private Integer minstrlength;
    @Column(name="minvalue")
    private String minvalue;
    @Column(name="needcodelistconfig")
    private Integer needcodelistconfig;
    @Column(name="nosort")
    private Integer nosort;
    @Column(name="phpslanresid")
    private String phpslanresid;
    @Column(name="phpslanresname")
    private String phpslanresname;
    @Column(name="pickuptextopts")
    private Integer pickuptextopts;
    @Column(name="placeholder")
    private String placeholder;
    @Column(name="precision2")
    private Integer precision2;
    @Column(name="preventxss")
    private Integer preventxss;
    @Column(name="pscodelistid")
    private String pscodelistid;
    @Column(name="pscodelistname")
    private String pscodelistname;
    @Column(name="psdefuimodeid")
    private String psdefuimodeid;
    @Column(name="psdefuimodename")
    private String psdefuimodename;
    @Column(name="psdefid")
    private String psdefid;
    @Column(name="psdefinputtipid")
    private String psdefinputtipid;
    @Column(name="psdefinputtipname")
    private String psdefinputtipname;
    @Column(name="psdefname")
    private String psdefname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="pssysdictcatid")
    private String pssysdictcatid;
    @Column(name="pssysdictcatname")
    private String pssysdictcatname;
    @Column(name="pssyseditorstyleid")
    private String pssyseditorstyleid;
    @Column(name="pssyseditorstylename")
    private String pssyseditorstylename;
    @Column(name="pssysimageid")
    private String pssysimageid;
    @Column(name="pssysimagename")
    private String pssysimagename;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssysunitid")
    private String pssysunitid;
    @Column(name="pssysunitname")
    private String pssysunitname;
    @Column(name="pssysvalueruleid")
    private String pssysvalueruleid;
    @Column(name="pssysvaluerulename")
    private String pssysvaluerulename;
    @Column(name="refadpsdelogicid")
    private String refadpsdelogicid;
    @Column(name="refadpsdelogicname")
    private String refadpsdelogicname;
    @Column(name="reflinkpsdeviewid")
    private String reflinkpsdeviewid;
    @Column(name="reflinkpsdeviewname")
    private String reflinkpsdeviewname;
    @Column(name="refmpickuppsdeviewid")
    private String refmpickuppsdeviewid;
    @Column(name="refmpickuppsdeviewname")
    private String refmpickuppsdeviewname;
    @Column(name="refpickuppsdeviewid")
    private String refpickuppsdeviewid;
    @Column(name="refpickuppsdeviewname")
    private String refpickuppsdeviewname;
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
    @Column(name="reftempdata")
    private Integer reftempdata;
    @Column(name="resetitemname")
    private String resetitemname;
    @Column(name="stringcase")
    private String stringcase;
    @Column(name="strlength")
    private Integer strlength;
    @Column(name="unitname")
    private String unitname;
    @Column(name="unitnamewidth")
    private Integer unitnamewidth;
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
    @Column(name="valueformat")
    private String valueformat;
    @Column(name="valueitemname")
    private String valueitemname;
    @Column(name="width")
    private Integer width;
    private Integer objItemPSACHandlerLock = new Integer(1);
    private PSACHandler itempsachandler = null;
    private Integer objPSCodeListLock = new Integer(1);
    private PSCodeList pscodelist = null;
    private Integer objRefPSDELock = new Integer(1);
    private PSDataEntity refpsde = null;
    private Integer objRefPSDEACModeLock = new Integer(1);
    private PSDEACMode refpsdeacmode = null;
    private Integer objRefPSDEDataSetLock = new Integer(1);
    private PSDEDataSet refpsdedataset = null;
    private Integer objPSDEFLock = new Integer(1);
    private PSDEField psdef = null;
    private Integer objPSDEFInputTipLock = new Integer(1);
    private PSDEFInputTip psdefinputtip = null;
    private Integer objRefADPSDELogicLock = new Integer(1);
    private PSDELogic refadpsdelogic = null;
    private Integer objRefPSDERLock = new Integer(1);
    private PSDER refpsder = null;
    private Integer objRefLinkPSDEViewLock = new Integer(1);
    private PSDEViewBase reflinkpsdeview = null;
    private Integer objRefMPickupPSDEViewLock = new Integer(1);
    private PSDEViewBase refmpickuppsdeview = null;
    private Integer objRefPickupPSDEViewLock = new Integer(1);
    private PSDEViewBase refpickuppsdeview = null;
    private Integer objCapPSLanResLock = new Integer(1);
    private PSLanguageRes cappslanres = null;
    private Integer objPHPSLanResLock = new Integer(1);
    private PSLanguageRes phpslanres = null;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objPSSysDictCatLock = new Integer(1);
    private PSSysDictCat pssysdictcat = null;
    private Integer objPSSysEditorStyleLock = new Integer(1);
    private PSSysEditorStyle pssyseditorstyle = null;
    private Integer objPSSysImageLock = new Integer(1);
    private PSSysImage pssysimage = null;
    private Integer objGCRPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin gcrpssyspfplugin = null;
    private Integer objPSSysUnitLock = new Integer(1);
    private PSSysUnit pssysunit = null;
    private Integer objPSSysValueRuleLock = new Integer(1);
    private PSSysValueRule pssysvaluerule = null;

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

    public void setConvertCIText(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setConvertCIText(n);
            return;
        }
        this.convertcitext = n;
        this.convertcitextDirtyFlag = true;
    }

    public Integer getConvertCIText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getConvertCIText();
        }
        return this.convertcitext;
    }

    public boolean isConvertCITextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isConvertCITextDirty();
        }
        return this.convertcitextDirtyFlag;
    }

    public void resetConvertCIText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetConvertCIText();
            return;
        }
        this.convertcitextDirtyFlag = false;
        this.convertcitext = null;
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

    public void setEnableResetItemName(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableResetItemName(n);
            return;
        }
        this.enableresetitemname = n;
        this.enableresetitemnameDirtyFlag = true;
    }

    public Integer getEnableResetItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableResetItemName();
        }
        return this.enableresetitemname;
    }

    public boolean isEnableResetItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableResetItemNameDirty();
        }
        return this.enableresetitemnameDirtyFlag;
    }

    public void resetEnableResetItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableResetItemName();
            return;
        }
        this.enableresetitemnameDirtyFlag = false;
        this.enableresetitemname = null;
    }

    public void setEnableUnitName(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableUnitName(n);
            return;
        }
        this.enableunitname = n;
        this.enableunitnameDirtyFlag = true;
    }

    public Integer getEnableUnitName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableUnitName();
        }
        return this.enableunitname;
    }

    public boolean isEnableUnitNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableUnitNameDirty();
        }
        return this.enableunitnameDirtyFlag;
    }

    public void resetEnableUnitName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableUnitName();
            return;
        }
        this.enableunitnameDirtyFlag = false;
        this.enableunitname = null;
    }

    public void setEnableValueRule(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableValueRule(n);
            return;
        }
        this.enablevaluerule = n;
        this.enablevalueruleDirtyFlag = true;
    }

    public Integer getEnableValueRule() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableValueRule();
        }
        return this.enablevaluerule;
    }

    public boolean isEnableValueRuleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableValueRuleDirty();
        }
        return this.enablevalueruleDirtyFlag;
    }

    public void resetEnableValueRule() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableValueRule();
            return;
        }
        this.enablevalueruleDirtyFlag = false;
        this.enablevaluerule = null;
    }

    public void setFTMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFTMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ftmode = string;
        this.ftmodeDirtyFlag = true;
    }

    public String getFTMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFTMode();
        }
        return this.ftmode;
    }

    public boolean isFTModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFTModeDirty();
        }
        return this.ftmodeDirtyFlag;
    }

    public void resetFTMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFTMode();
            return;
        }
        this.ftmodeDirtyFlag = false;
        this.ftmode = null;
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

    public void setGridColAlign(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGridColAlign(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.gridcolalign = string;
        this.gridcolalignDirtyFlag = true;
    }

    public String getGridColAlign() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGridColAlign();
        }
        return this.gridcolalign;
    }

    public boolean isGridColAlignDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGridColAlignDirty();
        }
        return this.gridcolalignDirtyFlag;
    }

    public void resetGridColAlign() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGridColAlign();
            return;
        }
        this.gridcolalignDirtyFlag = false;
        this.gridcolalign = null;
    }

    public void setGridColCLMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGridColCLMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.gridcolclmode = string;
        this.gridcolclmodeDirtyFlag = true;
    }

    public String getGridColCLMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGridColCLMode();
        }
        return this.gridcolclmode;
    }

    public boolean isGridColCLModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGridColCLModeDirty();
        }
        return this.gridcolclmodeDirtyFlag;
    }

    public void resetGridColCLMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGridColCLMode();
            return;
        }
        this.gridcolclmodeDirtyFlag = false;
        this.gridcolclmode = null;
    }

    public void setGridColWidth(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGridColWidth(n);
            return;
        }
        this.gridcolwidth = n;
        this.gridcolwidthDirtyFlag = true;
    }

    public Integer getGridColWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGridColWidth();
        }
        return this.gridcolwidth;
    }

    public boolean isGridColWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGridColWidthDirty();
        }
        return this.gridcolwidthDirtyFlag;
    }

    public void resetGridColWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGridColWidth();
            return;
        }
        this.gridcolwidthDirtyFlag = false;
        this.gridcolwidth = null;
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

    public void setItemPSACHandlerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemPSACHandlerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itempsachandlerid = string;
        this.itempsachandleridDirtyFlag = true;
    }

    public String getItemPSACHandlerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemPSACHandlerId();
        }
        return this.itempsachandlerid;
    }

    public boolean isItemPSACHandlerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemPSACHandlerIdDirty();
        }
        return this.itempsachandleridDirtyFlag;
    }

    public void resetItemPSACHandlerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemPSACHandlerId();
            return;
        }
        this.itempsachandleridDirtyFlag = false;
        this.itempsachandlerid = null;
    }

    public void setItemPSACHandlerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemPSACHandlerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itempsachandlername = string;
        this.itempsachandlernameDirtyFlag = true;
    }

    public String getItemPSACHandlerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemPSACHandlerName();
        }
        return this.itempsachandlername;
    }

    public boolean isItemPSACHandlerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemPSACHandlerNameDirty();
        }
        return this.itempsachandlernameDirtyFlag;
    }

    public void resetItemPSACHandlerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemPSACHandlerName();
            return;
        }
        this.itempsachandlernameDirtyFlag = false;
        this.itempsachandlername = null;
    }

    public void setJSFormat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJSFormat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.jsformat = string;
        this.jsformatDirtyFlag = true;
    }

    public String getJSFormat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJSFormat();
        }
        return this.jsformat;
    }

    public boolean isJSFormatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJSFormatDirty();
        }
        return this.jsformatDirtyFlag;
    }

    public void resetJSFormat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJSFormat();
            return;
        }
        this.jsformatDirtyFlag = false;
        this.jsformat = null;
    }

    public void setLockFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLockFlag(n);
            return;
        }
        this.lockflag = n;
        this.lockflagDirtyFlag = true;
    }

    public Integer getLockFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLockFlag();
        }
        return this.lockflag;
    }

    public boolean isLockFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLockFlagDirty();
        }
        return this.lockflagDirtyFlag;
    }

    public void resetLockFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLockFlag();
            return;
        }
        this.lockflagDirtyFlag = false;
        this.lockflag = null;
    }

    public void setMaxValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.maxvalue = string;
        this.maxvalueDirtyFlag = true;
    }

    public String getMaxValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxValue();
        }
        return this.maxvalue;
    }

    public boolean isMaxValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxValueDirty();
        }
        return this.maxvalueDirtyFlag;
    }

    public void resetMaxValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxValue();
            return;
        }
        this.maxvalueDirtyFlag = false;
        this.maxvalue = null;
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

    public void setMinStrLength(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinStrLength(n);
            return;
        }
        this.minstrlength = n;
        this.minstrlengthDirtyFlag = true;
    }

    public Integer getMinStrLength() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinStrLength();
        }
        return this.minstrlength;
    }

    public boolean isMinStrLengthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinStrLengthDirty();
        }
        return this.minstrlengthDirtyFlag;
    }

    public void resetMinStrLength() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinStrLength();
            return;
        }
        this.minstrlengthDirtyFlag = false;
        this.minstrlength = null;
    }

    public void setMinValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minvalue = string;
        this.minvalueDirtyFlag = true;
    }

    public String getMinValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinValue();
        }
        return this.minvalue;
    }

    public boolean isMinValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinValueDirty();
        }
        return this.minvalueDirtyFlag;
    }

    public void resetMinValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinValue();
            return;
        }
        this.minvalueDirtyFlag = false;
        this.minvalue = null;
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

    public void setPickupTextOpts(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPickupTextOpts(n);
            return;
        }
        this.pickuptextopts = n;
        this.pickuptextoptsDirtyFlag = true;
    }

    public Integer getPickupTextOpts() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPickupTextOpts();
        }
        return this.pickuptextopts;
    }

    public boolean isPickupTextOptsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPickupTextOptsDirty();
        }
        return this.pickuptextoptsDirtyFlag;
    }

    public void resetPickupTextOpts() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPickupTextOpts();
            return;
        }
        this.pickuptextoptsDirtyFlag = false;
        this.pickuptextopts = null;
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

    public void setPrecision2(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrecision2(n);
            return;
        }
        this.precision2 = n;
        this.precision2DirtyFlag = true;
    }

    public Integer getPrecision2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrecision2();
        }
        return this.precision2;
    }

    public boolean isPrecision2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrecision2Dirty();
        }
        return this.precision2DirtyFlag;
    }

    public void resetPrecision2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrecision2();
            return;
        }
        this.precision2DirtyFlag = false;
        this.precision2 = null;
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

    public void setPSDEFInputTipId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFInputTipId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefinputtipid = string;
        this.psdefinputtipidDirtyFlag = true;
    }

    public String getPSDEFInputTipId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFInputTipId();
        }
        return this.psdefinputtipid;
    }

    public boolean isPSDEFInputTipIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFInputTipIdDirty();
        }
        return this.psdefinputtipidDirtyFlag;
    }

    public void resetPSDEFInputTipId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFInputTipId();
            return;
        }
        this.psdefinputtipidDirtyFlag = false;
        this.psdefinputtipid = null;
    }

    public void setPSDEFInputTipName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFInputTipName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefinputtipname = string;
        this.psdefinputtipnameDirtyFlag = true;
    }

    public String getPSDEFInputTipName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFInputTipName();
        }
        return this.psdefinputtipname;
    }

    public boolean isPSDEFInputTipNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFInputTipNameDirty();
        }
        return this.psdefinputtipnameDirtyFlag;
    }

    public void resetPSDEFInputTipName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFInputTipName();
            return;
        }
        this.psdefinputtipnameDirtyFlag = false;
        this.psdefinputtipname = null;
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

    public void setPSSysAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappname = string;
        this.pssysappnameDirtyFlag = true;
    }

    public String getPSSysAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppName();
        }
        return this.pssysappname;
    }

    public boolean isPSSysAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppNameDirty();
        }
        return this.pssysappnameDirtyFlag;
    }

    public void resetPSSysAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppName();
            return;
        }
        this.pssysappnameDirtyFlag = false;
        this.pssysappname = null;
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

    public void setPSSysUnitId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUnitId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysunitid = string;
        this.pssysunitidDirtyFlag = true;
    }

    public String getPSSysUnitId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUnitId();
        }
        return this.pssysunitid;
    }

    public boolean isPSSysUnitIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUnitIdDirty();
        }
        return this.pssysunitidDirtyFlag;
    }

    public void resetPSSysUnitId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUnitId();
            return;
        }
        this.pssysunitidDirtyFlag = false;
        this.pssysunitid = null;
    }

    public void setPSSysUnitName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUnitName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysunitname = string;
        this.pssysunitnameDirtyFlag = true;
    }

    public String getPSSysUnitName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUnitName();
        }
        return this.pssysunitname;
    }

    public boolean isPSSysUnitNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUnitNameDirty();
        }
        return this.pssysunitnameDirtyFlag;
    }

    public void resetPSSysUnitName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUnitName();
            return;
        }
        this.pssysunitnameDirtyFlag = false;
        this.pssysunitname = null;
    }

    public void setPSSysValueRuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysValueRuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysvalueruleid = string;
        this.pssysvalueruleidDirtyFlag = true;
    }

    public String getPSSysValueRuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysValueRuleId();
        }
        return this.pssysvalueruleid;
    }

    public boolean isPSSysValueRuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysValueRuleIdDirty();
        }
        return this.pssysvalueruleidDirtyFlag;
    }

    public void resetPSSysValueRuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysValueRuleId();
            return;
        }
        this.pssysvalueruleidDirtyFlag = false;
        this.pssysvalueruleid = null;
    }

    public void setPSSysValueRuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysValueRuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysvaluerulename = string;
        this.pssysvaluerulenameDirtyFlag = true;
    }

    public String getPSSysValueRuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysValueRuleName();
        }
        return this.pssysvaluerulename;
    }

    public boolean isPSSysValueRuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysValueRuleNameDirty();
        }
        return this.pssysvaluerulenameDirtyFlag;
    }

    public void resetPSSysValueRuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysValueRuleName();
            return;
        }
        this.pssysvaluerulenameDirtyFlag = false;
        this.pssysvaluerulename = null;
    }

    public void setRefADPSDELogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefADPSDELogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refadpsdelogicid = string;
        this.refadpsdelogicidDirtyFlag = true;
    }

    public String getRefADPSDELogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefADPSDELogicId();
        }
        return this.refadpsdelogicid;
    }

    public boolean isRefADPSDELogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefADPSDELogicIdDirty();
        }
        return this.refadpsdelogicidDirtyFlag;
    }

    public void resetRefADPSDELogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefADPSDELogicId();
            return;
        }
        this.refadpsdelogicidDirtyFlag = false;
        this.refadpsdelogicid = null;
    }

    public void setRefADPSDELogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefADPSDELogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refadpsdelogicname = string;
        this.refadpsdelogicnameDirtyFlag = true;
    }

    public String getRefADPSDELogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefADPSDELogicName();
        }
        return this.refadpsdelogicname;
    }

    public boolean isRefADPSDELogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefADPSDELogicNameDirty();
        }
        return this.refadpsdelogicnameDirtyFlag;
    }

    public void resetRefADPSDELogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefADPSDELogicName();
            return;
        }
        this.refadpsdelogicnameDirtyFlag = false;
        this.refadpsdelogicname = null;
    }

    public void setRefLinkPSDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefLinkPSDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.reflinkpsdeviewid = string;
        this.reflinkpsdeviewidDirtyFlag = true;
    }

    public String getRefLinkPSDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefLinkPSDEViewId();
        }
        return this.reflinkpsdeviewid;
    }

    public boolean isRefLinkPSDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefLinkPSDEViewIdDirty();
        }
        return this.reflinkpsdeviewidDirtyFlag;
    }

    public void resetRefLinkPSDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefLinkPSDEViewId();
            return;
        }
        this.reflinkpsdeviewidDirtyFlag = false;
        this.reflinkpsdeviewid = null;
    }

    public void setRefLinkPSDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefLinkPSDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.reflinkpsdeviewname = string;
        this.reflinkpsdeviewnameDirtyFlag = true;
    }

    public String getRefLinkPSDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefLinkPSDEViewName();
        }
        return this.reflinkpsdeviewname;
    }

    public boolean isRefLinkPSDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefLinkPSDEViewNameDirty();
        }
        return this.reflinkpsdeviewnameDirtyFlag;
    }

    public void resetRefLinkPSDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefLinkPSDEViewName();
            return;
        }
        this.reflinkpsdeviewnameDirtyFlag = false;
        this.reflinkpsdeviewname = null;
    }

    public void setRefMPickupPSDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefMPickupPSDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refmpickuppsdeviewid = string;
        this.refmpickuppsdeviewidDirtyFlag = true;
    }

    public String getRefMPickupPSDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefMPickupPSDEViewId();
        }
        return this.refmpickuppsdeviewid;
    }

    public boolean isRefMPickupPSDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefMPickupPSDEViewIdDirty();
        }
        return this.refmpickuppsdeviewidDirtyFlag;
    }

    public void resetRefMPickupPSDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefMPickupPSDEViewId();
            return;
        }
        this.refmpickuppsdeviewidDirtyFlag = false;
        this.refmpickuppsdeviewid = null;
    }

    public void setRefMPickupPSDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefMPickupPSDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refmpickuppsdeviewname = string;
        this.refmpickuppsdeviewnameDirtyFlag = true;
    }

    public String getRefMPickupPSDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefMPickupPSDEViewName();
        }
        return this.refmpickuppsdeviewname;
    }

    public boolean isRefMPickupPSDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefMPickupPSDEViewNameDirty();
        }
        return this.refmpickuppsdeviewnameDirtyFlag;
    }

    public void resetRefMPickupPSDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefMPickupPSDEViewName();
            return;
        }
        this.refmpickuppsdeviewnameDirtyFlag = false;
        this.refmpickuppsdeviewname = null;
    }

    public void setRefPickupPSDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPickupPSDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpickuppsdeviewid = string;
        this.refpickuppsdeviewidDirtyFlag = true;
    }

    public String getRefPickupPSDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPickupPSDEViewId();
        }
        return this.refpickuppsdeviewid;
    }

    public boolean isRefPickupPSDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPickupPSDEViewIdDirty();
        }
        return this.refpickuppsdeviewidDirtyFlag;
    }

    public void resetRefPickupPSDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPickupPSDEViewId();
            return;
        }
        this.refpickuppsdeviewidDirtyFlag = false;
        this.refpickuppsdeviewid = null;
    }

    public void setRefPickupPSDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPickupPSDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpickuppsdeviewname = string;
        this.refpickuppsdeviewnameDirtyFlag = true;
    }

    public String getRefPickupPSDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPickupPSDEViewName();
        }
        return this.refpickuppsdeviewname;
    }

    public boolean isRefPickupPSDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPickupPSDEViewNameDirty();
        }
        return this.refpickuppsdeviewnameDirtyFlag;
    }

    public void resetRefPickupPSDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPickupPSDEViewName();
            return;
        }
        this.refpickuppsdeviewnameDirtyFlag = false;
        this.refpickuppsdeviewname = null;
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

    public void setRefTempData(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefTempData(n);
            return;
        }
        this.reftempdata = n;
        this.reftempdataDirtyFlag = true;
    }

    public Integer getRefTempData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefTempData();
        }
        return this.reftempdata;
    }

    public boolean isRefTempDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefTempDataDirty();
        }
        return this.reftempdataDirtyFlag;
    }

    public void resetRefTempData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefTempData();
            return;
        }
        this.reftempdataDirtyFlag = false;
        this.reftempdata = null;
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

    public void setStringCase(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStringCase(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.stringcase = string;
        this.stringcaseDirtyFlag = true;
    }

    public String getStringCase() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStringCase();
        }
        return this.stringcase;
    }

    public boolean isStringCaseDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStringCaseDirty();
        }
        return this.stringcaseDirtyFlag;
    }

    public void resetStringCase() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStringCase();
            return;
        }
        this.stringcaseDirtyFlag = false;
        this.stringcase = null;
    }

    public void setStrLength(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStrLength(n);
            return;
        }
        this.strlength = n;
        this.strlengthDirtyFlag = true;
    }

    public Integer getStrLength() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStrLength();
        }
        return this.strlength;
    }

    public boolean isStrLengthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStrLengthDirty();
        }
        return this.strlengthDirtyFlag;
    }

    public void resetStrLength() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStrLength();
            return;
        }
        this.strlengthDirtyFlag = false;
        this.strlength = null;
    }

    public void setUnitName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUnitName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.unitname = string;
        this.unitnameDirtyFlag = true;
    }

    public String getUnitName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUnitName();
        }
        return this.unitname;
    }

    public boolean isUnitNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUnitNameDirty();
        }
        return this.unitnameDirtyFlag;
    }

    public void resetUnitName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUnitName();
            return;
        }
        this.unitnameDirtyFlag = false;
        this.unitname = null;
    }

    public void setUnitNameWidth(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUnitNameWidth(n);
            return;
        }
        this.unitnamewidth = n;
        this.unitnamewidthDirtyFlag = true;
    }

    public Integer getUnitNameWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUnitNameWidth();
        }
        return this.unitnamewidth;
    }

    public boolean isUnitNameWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUnitNameWidthDirty();
        }
        return this.unitnamewidthDirtyFlag;
    }

    public void resetUnitNameWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUnitNameWidth();
            return;
        }
        this.unitnamewidthDirtyFlag = false;
        this.unitnamewidth = null;
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

    protected void onReset() {
        PSDEFUIModeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEFUIModeBase pSDEFUIModeBase) {
        pSDEFUIModeBase.resetAllowEmpty();
        pSDEFUIModeBase.resetCapPSLanResId();
        pSDEFUIModeBase.resetCapPSLanResName();
        pSDEFUIModeBase.resetCaption();
        pSDEFUIModeBase.resetCodeListConfigMode();
        pSDEFUIModeBase.resetCodeName();
        pSDEFUIModeBase.resetConvertCIText();
        pSDEFUIModeBase.resetCreateDate();
        pSDEFUIModeBase.resetCreateDV();
        pSDEFUIModeBase.resetCreateDVT();
        pSDEFUIModeBase.resetCreateMan();
        pSDEFUIModeBase.resetDynaModelFlag();
        pSDEFUIModeBase.resetEditorParams();
        pSDEFUIModeBase.resetEditorType();
        pSDEFUIModeBase.resetEditorTypeName();
        pSDEFUIModeBase.resetEnableInputTip();
        pSDEFUIModeBase.resetEnableResetItemName();
        pSDEFUIModeBase.resetEnableUnitName();
        pSDEFUIModeBase.resetEnableValueRule();
        pSDEFUIModeBase.resetFTMode();
        pSDEFUIModeBase.resetGCRPSSysPFPluginId();
        pSDEFUIModeBase.resetGCRPSSysPFPluginName();
        pSDEFUIModeBase.resetGridColAlign();
        pSDEFUIModeBase.resetGridColCLMode();
        pSDEFUIModeBase.resetGridColWidth();
        pSDEFUIModeBase.resetHeight();
        pSDEFUIModeBase.resetIgnoreInput();
        pSDEFUIModeBase.resetItemPSACHandlerId();
        pSDEFUIModeBase.resetItemPSACHandlerName();
        pSDEFUIModeBase.resetJSFormat();
        pSDEFUIModeBase.resetLockFlag();
        pSDEFUIModeBase.resetMaxValue();
        pSDEFUIModeBase.resetMemo();
        pSDEFUIModeBase.resetMinStrLength();
        pSDEFUIModeBase.resetMinValue();
        pSDEFUIModeBase.resetNeedCodeListConfig();
        pSDEFUIModeBase.resetNoSort();
        pSDEFUIModeBase.resetPHPSLanResId();
        pSDEFUIModeBase.resetPHPSLanResName();
        pSDEFUIModeBase.resetPickupTextOpts();
        pSDEFUIModeBase.resetPlaceHolder();
        pSDEFUIModeBase.resetPrecision2();
        pSDEFUIModeBase.resetPreventXSS();
        pSDEFUIModeBase.resetPSCodeListId();
        pSDEFUIModeBase.resetPSCodeListName();
        pSDEFUIModeBase.resetPSDEFUIModeId();
        pSDEFUIModeBase.resetPSDEFUIModeName();
        pSDEFUIModeBase.resetPSDEFId();
        pSDEFUIModeBase.resetPSDEFInputTipId();
        pSDEFUIModeBase.resetPSDEFInputTipName();
        pSDEFUIModeBase.resetPSDEFName();
        pSDEFUIModeBase.resetPSDEId();
        pSDEFUIModeBase.resetPSDEName();
        pSDEFUIModeBase.resetPSDynaInstId();
        pSDEFUIModeBase.resetPSSysAppId();
        pSDEFUIModeBase.resetPSSysAppName();
        pSDEFUIModeBase.resetPSSysDictCatId();
        pSDEFUIModeBase.resetPSSysDictCatName();
        pSDEFUIModeBase.resetPSSysEditorStyleId();
        pSDEFUIModeBase.resetPSSysEditorStyleName();
        pSDEFUIModeBase.resetPSSysImageId();
        pSDEFUIModeBase.resetPSSysImageName();
        pSDEFUIModeBase.resetPSSystemId();
        pSDEFUIModeBase.resetPSSysUnitId();
        pSDEFUIModeBase.resetPSSysUnitName();
        pSDEFUIModeBase.resetPSSysValueRuleId();
        pSDEFUIModeBase.resetPSSysValueRuleName();
        pSDEFUIModeBase.resetRefADPSDELogicId();
        pSDEFUIModeBase.resetRefADPSDELogicName();
        pSDEFUIModeBase.resetRefLinkPSDEViewId();
        pSDEFUIModeBase.resetRefLinkPSDEViewName();
        pSDEFUIModeBase.resetRefMPickupPSDEViewId();
        pSDEFUIModeBase.resetRefMPickupPSDEViewName();
        pSDEFUIModeBase.resetRefPickupPSDEViewId();
        pSDEFUIModeBase.resetRefPickupPSDEViewName();
        pSDEFUIModeBase.resetRefPSDEACModeId();
        pSDEFUIModeBase.resetRefPSDEACModeName();
        pSDEFUIModeBase.resetRefPSDEDataSetId();
        pSDEFUIModeBase.resetRefPSDEDataSetName();
        pSDEFUIModeBase.resetRefPSDEId();
        pSDEFUIModeBase.resetRefPSDEName();
        pSDEFUIModeBase.resetRefPSDERId();
        pSDEFUIModeBase.resetRefPSDERName();
        pSDEFUIModeBase.resetRefTempData();
        pSDEFUIModeBase.resetResetItemName();
        pSDEFUIModeBase.resetStringCase();
        pSDEFUIModeBase.resetStrLength();
        pSDEFUIModeBase.resetUnitName();
        pSDEFUIModeBase.resetUnitNameWidth();
        pSDEFUIModeBase.resetUpdateDate();
        pSDEFUIModeBase.resetUpdateDV();
        pSDEFUIModeBase.resetUpdateDVT();
        pSDEFUIModeBase.resetUpdateMan();
        pSDEFUIModeBase.resetUserCat();
        pSDEFUIModeBase.resetUserParams();
        pSDEFUIModeBase.resetUserTag();
        pSDEFUIModeBase.resetUserTag2();
        pSDEFUIModeBase.resetUserTag3();
        pSDEFUIModeBase.resetUserTag4();
        pSDEFUIModeBase.resetValueFormat();
        pSDEFUIModeBase.resetValueItemName();
        pSDEFUIModeBase.resetWidth();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
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
        if (!bl || this.isCodeListConfigModeDirty()) {
            hashMap.put(FIELD_CODELISTCONFIGMODE, this.getCodeListConfigMode());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isConvertCITextDirty()) {
            hashMap.put(FIELD_CONVERTCITEXT, this.getConvertCIText());
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
        if (!bl || this.isEnableInputTipDirty()) {
            hashMap.put(FIELD_ENABLEINPUTTIP, this.getEnableInputTip());
        }
        if (!bl || this.isEnableResetItemNameDirty()) {
            hashMap.put(FIELD_ENABLERESETITEMNAME, this.getEnableResetItemName());
        }
        if (!bl || this.isEnableUnitNameDirty()) {
            hashMap.put(FIELD_ENABLEUNITNAME, this.getEnableUnitName());
        }
        if (!bl || this.isEnableValueRuleDirty()) {
            hashMap.put(FIELD_ENABLEVALUERULE, this.getEnableValueRule());
        }
        if (!bl || this.isFTModeDirty()) {
            hashMap.put(FIELD_FTMODE, this.getFTMode());
        }
        if (!bl || this.isGCRPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_GCRPSSYSPFPLUGINID, this.getGCRPSSysPFPluginId());
        }
        if (!bl || this.isGCRPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_GCRPSSYSPFPLUGINNAME, this.getGCRPSSysPFPluginName());
        }
        if (!bl || this.isGridColAlignDirty()) {
            hashMap.put(FIELD_GRIDCOLALIGN, this.getGridColAlign());
        }
        if (!bl || this.isGridColCLModeDirty()) {
            hashMap.put(FIELD_GRIDCOLCLMODE, this.getGridColCLMode());
        }
        if (!bl || this.isGridColWidthDirty()) {
            hashMap.put(FIELD_GRIDCOLWIDTH, this.getGridColWidth());
        }
        if (!bl || this.isHeightDirty()) {
            hashMap.put(FIELD_HEIGHT, this.getHeight());
        }
        if (!bl || this.isIgnoreInputDirty()) {
            hashMap.put(FIELD_IGNOREINPUT, this.getIgnoreInput());
        }
        if (!bl || this.isItemPSACHandlerIdDirty()) {
            hashMap.put(FIELD_ITEMPSACHANDLERID, this.getItemPSACHandlerId());
        }
        if (!bl || this.isItemPSACHandlerNameDirty()) {
            hashMap.put(FIELD_ITEMPSACHANDLERNAME, this.getItemPSACHandlerName());
        }
        if (!bl || this.isJSFormatDirty()) {
            hashMap.put(FIELD_JSFORMAT, this.getJSFormat());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMaxValueDirty()) {
            hashMap.put(FIELD_MAXVALUE, this.getMaxValue());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMinStrLengthDirty()) {
            hashMap.put(FIELD_MINSTRLENGTH, this.getMinStrLength());
        }
        if (!bl || this.isMinValueDirty()) {
            hashMap.put(FIELD_MINVALUE, this.getMinValue());
        }
        if (!bl || this.isNeedCodeListConfigDirty()) {
            hashMap.put(FIELD_NEEDCODELISTCONFIG, this.getNeedCodeListConfig());
        }
        if (!bl || this.isNoSortDirty()) {
            hashMap.put(FIELD_NOSORT, this.getNoSort());
        }
        if (!bl || this.isPHPSLanResIdDirty()) {
            hashMap.put(FIELD_PHPSLANRESID, this.getPHPSLanResId());
        }
        if (!bl || this.isPHPSLanResNameDirty()) {
            hashMap.put(FIELD_PHPSLANRESNAME, this.getPHPSLanResName());
        }
        if (!bl || this.isPickupTextOptsDirty()) {
            hashMap.put(FIELD_PICKUPTEXTOPTS, this.getPickupTextOpts());
        }
        if (!bl || this.isPlaceHolderDirty()) {
            hashMap.put(FIELD_PLACEHOLDER, this.getPlaceHolder());
        }
        if (!bl || this.isPrecision2Dirty()) {
            hashMap.put(FIELD_PRECISION2, this.getPrecision2());
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
        if (!bl || this.isPSDEFUIModeIdDirty()) {
            hashMap.put(FIELD_PSDEFUIMODEID, this.getPSDEFUIModeId());
        }
        if (!bl || this.isPSDEFUIModeNameDirty()) {
            hashMap.put(FIELD_PSDEFUIMODENAME, this.getPSDEFUIModeName());
        }
        if (!bl || this.isPSDEFIdDirty()) {
            hashMap.put(FIELD_PSDEFID, this.getPSDEFId());
        }
        if (!bl || this.isPSDEFInputTipIdDirty()) {
            hashMap.put(FIELD_PSDEFINPUTTIPID, this.getPSDEFInputTipId());
        }
        if (!bl || this.isPSDEFInputTipNameDirty()) {
            hashMap.put(FIELD_PSDEFINPUTTIPNAME, this.getPSDEFInputTipName());
        }
        if (!bl || this.isPSDEFNameDirty()) {
            hashMap.put(FIELD_PSDEFNAME, this.getPSDEFName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isPSSysDictCatIdDirty()) {
            hashMap.put(FIELD_PSSYSDICTCATID, this.getPSSysDictCatId());
        }
        if (!bl || this.isPSSysDictCatNameDirty()) {
            hashMap.put(FIELD_PSSYSDICTCATNAME, this.getPSSysDictCatName());
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
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSysUnitIdDirty()) {
            hashMap.put(FIELD_PSSYSUNITID, this.getPSSysUnitId());
        }
        if (!bl || this.isPSSysUnitNameDirty()) {
            hashMap.put(FIELD_PSSYSUNITNAME, this.getPSSysUnitName());
        }
        if (!bl || this.isPSSysValueRuleIdDirty()) {
            hashMap.put(FIELD_PSSYSVALUERULEID, this.getPSSysValueRuleId());
        }
        if (!bl || this.isPSSysValueRuleNameDirty()) {
            hashMap.put(FIELD_PSSYSVALUERULENAME, this.getPSSysValueRuleName());
        }
        if (!bl || this.isRefADPSDELogicIdDirty()) {
            hashMap.put(FIELD_REFADPSDELOGICID, this.getRefADPSDELogicId());
        }
        if (!bl || this.isRefADPSDELogicNameDirty()) {
            hashMap.put(FIELD_REFADPSDELOGICNAME, this.getRefADPSDELogicName());
        }
        if (!bl || this.isRefLinkPSDEViewIdDirty()) {
            hashMap.put(FIELD_REFLINKPSDEVIEWID, this.getRefLinkPSDEViewId());
        }
        if (!bl || this.isRefLinkPSDEViewNameDirty()) {
            hashMap.put(FIELD_REFLINKPSDEVIEWNAME, this.getRefLinkPSDEViewName());
        }
        if (!bl || this.isRefMPickupPSDEViewIdDirty()) {
            hashMap.put(FIELD_REFMPICKUPPSDEVIEWID, this.getRefMPickupPSDEViewId());
        }
        if (!bl || this.isRefMPickupPSDEViewNameDirty()) {
            hashMap.put(FIELD_REFMPICKUPPSDEVIEWNAME, this.getRefMPickupPSDEViewName());
        }
        if (!bl || this.isRefPickupPSDEViewIdDirty()) {
            hashMap.put(FIELD_REFPICKUPPSDEVIEWID, this.getRefPickupPSDEViewId());
        }
        if (!bl || this.isRefPickupPSDEViewNameDirty()) {
            hashMap.put(FIELD_REFPICKUPPSDEVIEWNAME, this.getRefPickupPSDEViewName());
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
        if (!bl || this.isRefTempDataDirty()) {
            hashMap.put(FIELD_REFTEMPDATA, this.getRefTempData());
        }
        if (!bl || this.isResetItemNameDirty()) {
            hashMap.put(FIELD_RESETITEMNAME, this.getResetItemName());
        }
        if (!bl || this.isStringCaseDirty()) {
            hashMap.put(FIELD_STRINGCASE, this.getStringCase());
        }
        if (!bl || this.isStrLengthDirty()) {
            hashMap.put(FIELD_STRLENGTH, this.getStrLength());
        }
        if (!bl || this.isUnitNameDirty()) {
            hashMap.put(FIELD_UNITNAME, this.getUnitName());
        }
        if (!bl || this.isUnitNameWidthDirty()) {
            hashMap.put(FIELD_UNITNAMEWIDTH, this.getUnitNameWidth());
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
        if (!bl || this.isValueFormatDirty()) {
            hashMap.put(FIELD_VALUEFORMAT, this.getValueFormat());
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
        return PSDEFUIModeBase.get(this, n);
    }

    private static Object get(PSDEFUIModeBase pSDEFUIModeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFUIModeBase.getAllowEmpty();
            }
            case 1: {
                return pSDEFUIModeBase.getCapPSLanResId();
            }
            case 2: {
                return pSDEFUIModeBase.getCapPSLanResName();
            }
            case 3: {
                return pSDEFUIModeBase.getCaption();
            }
            case 4: {
                return pSDEFUIModeBase.getCodeListConfigMode();
            }
            case 5: {
                return pSDEFUIModeBase.getCodeName();
            }
            case 6: {
                return pSDEFUIModeBase.getConvertCIText();
            }
            case 7: {
                return pSDEFUIModeBase.getCreateDate();
            }
            case 8: {
                return pSDEFUIModeBase.getCreateDV();
            }
            case 9: {
                return pSDEFUIModeBase.getCreateDVT();
            }
            case 10: {
                return pSDEFUIModeBase.getCreateMan();
            }
            case 11: {
                return pSDEFUIModeBase.getDynaModelFlag();
            }
            case 12: {
                return pSDEFUIModeBase.getEditorParams();
            }
            case 13: {
                return pSDEFUIModeBase.getEditorType();
            }
            case 14: {
                return pSDEFUIModeBase.getEditorTypeName();
            }
            case 15: {
                return pSDEFUIModeBase.getEnableInputTip();
            }
            case 16: {
                return pSDEFUIModeBase.getEnableResetItemName();
            }
            case 17: {
                return pSDEFUIModeBase.getEnableUnitName();
            }
            case 18: {
                return pSDEFUIModeBase.getEnableValueRule();
            }
            case 19: {
                return pSDEFUIModeBase.getFTMode();
            }
            case 20: {
                return pSDEFUIModeBase.getGCRPSSysPFPluginId();
            }
            case 21: {
                return pSDEFUIModeBase.getGCRPSSysPFPluginName();
            }
            case 22: {
                return pSDEFUIModeBase.getGridColAlign();
            }
            case 23: {
                return pSDEFUIModeBase.getGridColCLMode();
            }
            case 24: {
                return pSDEFUIModeBase.getGridColWidth();
            }
            case 25: {
                return pSDEFUIModeBase.getHeight();
            }
            case 26: {
                return pSDEFUIModeBase.getIgnoreInput();
            }
            case 27: {
                return pSDEFUIModeBase.getItemPSACHandlerId();
            }
            case 28: {
                return pSDEFUIModeBase.getItemPSACHandlerName();
            }
            case 29: {
                return pSDEFUIModeBase.getJSFormat();
            }
            case 30: {
                return pSDEFUIModeBase.getLockFlag();
            }
            case 31: {
                return pSDEFUIModeBase.getMaxValue();
            }
            case 32: {
                return pSDEFUIModeBase.getMemo();
            }
            case 33: {
                return pSDEFUIModeBase.getMinStrLength();
            }
            case 34: {
                return pSDEFUIModeBase.getMinValue();
            }
            case 35: {
                return pSDEFUIModeBase.getNeedCodeListConfig();
            }
            case 36: {
                return pSDEFUIModeBase.getNoSort();
            }
            case 37: {
                return pSDEFUIModeBase.getPHPSLanResId();
            }
            case 38: {
                return pSDEFUIModeBase.getPHPSLanResName();
            }
            case 39: {
                return pSDEFUIModeBase.getPickupTextOpts();
            }
            case 40: {
                return pSDEFUIModeBase.getPlaceHolder();
            }
            case 41: {
                return pSDEFUIModeBase.getPrecision2();
            }
            case 42: {
                return pSDEFUIModeBase.getPreventXSS();
            }
            case 43: {
                return pSDEFUIModeBase.getPSCodeListId();
            }
            case 44: {
                return pSDEFUIModeBase.getPSCodeListName();
            }
            case 45: {
                return pSDEFUIModeBase.getPSDEFUIModeId();
            }
            case 46: {
                return pSDEFUIModeBase.getPSDEFUIModeName();
            }
            case 47: {
                return pSDEFUIModeBase.getPSDEFId();
            }
            case 48: {
                return pSDEFUIModeBase.getPSDEFInputTipId();
            }
            case 49: {
                return pSDEFUIModeBase.getPSDEFInputTipName();
            }
            case 50: {
                return pSDEFUIModeBase.getPSDEFName();
            }
            case 51: {
                return pSDEFUIModeBase.getPSDEId();
            }
            case 52: {
                return pSDEFUIModeBase.getPSDEName();
            }
            case 53: {
                return pSDEFUIModeBase.getPSDynaInstId();
            }
            case 54: {
                return pSDEFUIModeBase.getPSSysAppId();
            }
            case 55: {
                return pSDEFUIModeBase.getPSSysAppName();
            }
            case 56: {
                return pSDEFUIModeBase.getPSSysDictCatId();
            }
            case 57: {
                return pSDEFUIModeBase.getPSSysDictCatName();
            }
            case 58: {
                return pSDEFUIModeBase.getPSSysEditorStyleId();
            }
            case 59: {
                return pSDEFUIModeBase.getPSSysEditorStyleName();
            }
            case 60: {
                return pSDEFUIModeBase.getPSSysImageId();
            }
            case 61: {
                return pSDEFUIModeBase.getPSSysImageName();
            }
            case 62: {
                return pSDEFUIModeBase.getPSSystemId();
            }
            case 63: {
                return pSDEFUIModeBase.getPSSysUnitId();
            }
            case 64: {
                return pSDEFUIModeBase.getPSSysUnitName();
            }
            case 65: {
                return pSDEFUIModeBase.getPSSysValueRuleId();
            }
            case 66: {
                return pSDEFUIModeBase.getPSSysValueRuleName();
            }
            case 67: {
                return pSDEFUIModeBase.getRefADPSDELogicId();
            }
            case 68: {
                return pSDEFUIModeBase.getRefADPSDELogicName();
            }
            case 69: {
                return pSDEFUIModeBase.getRefLinkPSDEViewId();
            }
            case 70: {
                return pSDEFUIModeBase.getRefLinkPSDEViewName();
            }
            case 71: {
                return pSDEFUIModeBase.getRefMPickupPSDEViewId();
            }
            case 72: {
                return pSDEFUIModeBase.getRefMPickupPSDEViewName();
            }
            case 73: {
                return pSDEFUIModeBase.getRefPickupPSDEViewId();
            }
            case 74: {
                return pSDEFUIModeBase.getRefPickupPSDEViewName();
            }
            case 75: {
                return pSDEFUIModeBase.getRefPSDEACModeId();
            }
            case 76: {
                return pSDEFUIModeBase.getRefPSDEACModeName();
            }
            case 77: {
                return pSDEFUIModeBase.getRefPSDEDataSetId();
            }
            case 78: {
                return pSDEFUIModeBase.getRefPSDEDataSetName();
            }
            case 79: {
                return pSDEFUIModeBase.getRefPSDEId();
            }
            case 80: {
                return pSDEFUIModeBase.getRefPSDEName();
            }
            case 81: {
                return pSDEFUIModeBase.getRefPSDERId();
            }
            case 82: {
                return pSDEFUIModeBase.getRefPSDERName();
            }
            case 83: {
                return pSDEFUIModeBase.getRefTempData();
            }
            case 84: {
                return pSDEFUIModeBase.getResetItemName();
            }
            case 85: {
                return pSDEFUIModeBase.getStringCase();
            }
            case 86: {
                return pSDEFUIModeBase.getStrLength();
            }
            case 87: {
                return pSDEFUIModeBase.getUnitName();
            }
            case 88: {
                return pSDEFUIModeBase.getUnitNameWidth();
            }
            case 89: {
                return pSDEFUIModeBase.getUpdateDate();
            }
            case 90: {
                return pSDEFUIModeBase.getUpdateDV();
            }
            case 91: {
                return pSDEFUIModeBase.getUpdateDVT();
            }
            case 92: {
                return pSDEFUIModeBase.getUpdateMan();
            }
            case 93: {
                return pSDEFUIModeBase.getUserCat();
            }
            case 94: {
                return pSDEFUIModeBase.getUserParams();
            }
            case 95: {
                return pSDEFUIModeBase.getUserTag();
            }
            case 96: {
                return pSDEFUIModeBase.getUserTag2();
            }
            case 97: {
                return pSDEFUIModeBase.getUserTag3();
            }
            case 98: {
                return pSDEFUIModeBase.getUserTag4();
            }
            case 99: {
                return pSDEFUIModeBase.getValueFormat();
            }
            case 100: {
                return pSDEFUIModeBase.getValueItemName();
            }
            case 101: {
                return pSDEFUIModeBase.getWidth();
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
        PSDEFUIModeBase.set(this, n, object);
    }

    private static void set(PSDEFUIModeBase pSDEFUIModeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEFUIModeBase.setAllowEmpty(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDEFUIModeBase.setCapPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEFUIModeBase.setCapPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEFUIModeBase.setCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEFUIModeBase.setCodeListConfigMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDEFUIModeBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEFUIModeBase.setConvertCIText(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDEFUIModeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSDEFUIModeBase.setCreateDV(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEFUIModeBase.setCreateDVT(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEFUIModeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEFUIModeBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDEFUIModeBase.setEditorParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEFUIModeBase.setEditorType(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEFUIModeBase.setEditorTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEFUIModeBase.setEnableInputTip(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSDEFUIModeBase.setEnableResetItemName(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSDEFUIModeBase.setEnableUnitName(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSDEFUIModeBase.setEnableValueRule(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSDEFUIModeBase.setFTMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEFUIModeBase.setGCRPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEFUIModeBase.setGCRPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEFUIModeBase.setGridColAlign(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEFUIModeBase.setGridColCLMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEFUIModeBase.setGridColWidth(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSDEFUIModeBase.setHeight(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 26: {
                pSDEFUIModeBase.setIgnoreInput(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSDEFUIModeBase.setItemPSACHandlerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEFUIModeBase.setItemPSACHandlerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEFUIModeBase.setJSFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEFUIModeBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSDEFUIModeBase.setMaxValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEFUIModeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEFUIModeBase.setMinStrLength(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 34: {
                pSDEFUIModeBase.setMinValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEFUIModeBase.setNeedCodeListConfig(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 36: {
                pSDEFUIModeBase.setNoSort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 37: {
                pSDEFUIModeBase.setPHPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEFUIModeBase.setPHPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDEFUIModeBase.setPickupTextOpts(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 40: {
                pSDEFUIModeBase.setPlaceHolder(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDEFUIModeBase.setPrecision2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 42: {
                pSDEFUIModeBase.setPreventXSS(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 43: {
                pSDEFUIModeBase.setPSCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDEFUIModeBase.setPSCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDEFUIModeBase.setPSDEFUIModeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDEFUIModeBase.setPSDEFUIModeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDEFUIModeBase.setPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDEFUIModeBase.setPSDEFInputTipId(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDEFUIModeBase.setPSDEFInputTipName(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDEFUIModeBase.setPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSDEFUIModeBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSDEFUIModeBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSDEFUIModeBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSDEFUIModeBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSDEFUIModeBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSDEFUIModeBase.setPSSysDictCatId(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSDEFUIModeBase.setPSSysDictCatName(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSDEFUIModeBase.setPSSysEditorStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSDEFUIModeBase.setPSSysEditorStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSDEFUIModeBase.setPSSysImageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSDEFUIModeBase.setPSSysImageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSDEFUIModeBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSDEFUIModeBase.setPSSysUnitId(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSDEFUIModeBase.setPSSysUnitName(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSDEFUIModeBase.setPSSysValueRuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSDEFUIModeBase.setPSSysValueRuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSDEFUIModeBase.setRefADPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSDEFUIModeBase.setRefADPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSDEFUIModeBase.setRefLinkPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 70: {
                pSDEFUIModeBase.setRefLinkPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 71: {
                pSDEFUIModeBase.setRefMPickupPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 72: {
                pSDEFUIModeBase.setRefMPickupPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 73: {
                pSDEFUIModeBase.setRefPickupPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 74: {
                pSDEFUIModeBase.setRefPickupPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 75: {
                pSDEFUIModeBase.setRefPSDEACModeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 76: {
                pSDEFUIModeBase.setRefPSDEACModeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 77: {
                pSDEFUIModeBase.setRefPSDEDataSetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 78: {
                pSDEFUIModeBase.setRefPSDEDataSetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 79: {
                pSDEFUIModeBase.setRefPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 80: {
                pSDEFUIModeBase.setRefPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 81: {
                pSDEFUIModeBase.setRefPSDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 82: {
                pSDEFUIModeBase.setRefPSDERName(DataObject.getStringValue((Object)object));
                return;
            }
            case 83: {
                pSDEFUIModeBase.setRefTempData(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 84: {
                pSDEFUIModeBase.setResetItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 85: {
                pSDEFUIModeBase.setStringCase(DataObject.getStringValue((Object)object));
                return;
            }
            case 86: {
                pSDEFUIModeBase.setStrLength(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 87: {
                pSDEFUIModeBase.setUnitName(DataObject.getStringValue((Object)object));
                return;
            }
            case 88: {
                pSDEFUIModeBase.setUnitNameWidth(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 89: {
                pSDEFUIModeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 90: {
                pSDEFUIModeBase.setUpdateDV(DataObject.getStringValue((Object)object));
                return;
            }
            case 91: {
                pSDEFUIModeBase.setUpdateDVT(DataObject.getStringValue((Object)object));
                return;
            }
            case 92: {
                pSDEFUIModeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 93: {
                pSDEFUIModeBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 94: {
                pSDEFUIModeBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 95: {
                pSDEFUIModeBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 96: {
                pSDEFUIModeBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 97: {
                pSDEFUIModeBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 98: {
                pSDEFUIModeBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 99: {
                pSDEFUIModeBase.setValueFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 100: {
                pSDEFUIModeBase.setValueItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 101: {
                pSDEFUIModeBase.setWidth(DataObject.getIntegerValue((Object)object));
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
        return PSDEFUIModeBase.isNull(this, n);
    }

    private static boolean isNull(PSDEFUIModeBase pSDEFUIModeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFUIModeBase.getAllowEmpty() == null;
            }
            case 1: {
                return pSDEFUIModeBase.getCapPSLanResId() == null;
            }
            case 2: {
                return pSDEFUIModeBase.getCapPSLanResName() == null;
            }
            case 3: {
                return pSDEFUIModeBase.getCaption() == null;
            }
            case 4: {
                return pSDEFUIModeBase.getCodeListConfigMode() == null;
            }
            case 5: {
                return pSDEFUIModeBase.getCodeName() == null;
            }
            case 6: {
                return pSDEFUIModeBase.getConvertCIText() == null;
            }
            case 7: {
                return pSDEFUIModeBase.getCreateDate() == null;
            }
            case 8: {
                return pSDEFUIModeBase.getCreateDV() == null;
            }
            case 9: {
                return pSDEFUIModeBase.getCreateDVT() == null;
            }
            case 10: {
                return pSDEFUIModeBase.getCreateMan() == null;
            }
            case 11: {
                return pSDEFUIModeBase.getDynaModelFlag() == null;
            }
            case 12: {
                return pSDEFUIModeBase.getEditorParams() == null;
            }
            case 13: {
                return pSDEFUIModeBase.getEditorType() == null;
            }
            case 14: {
                return pSDEFUIModeBase.getEditorTypeName() == null;
            }
            case 15: {
                return pSDEFUIModeBase.getEnableInputTip() == null;
            }
            case 16: {
                return pSDEFUIModeBase.getEnableResetItemName() == null;
            }
            case 17: {
                return pSDEFUIModeBase.getEnableUnitName() == null;
            }
            case 18: {
                return pSDEFUIModeBase.getEnableValueRule() == null;
            }
            case 19: {
                return pSDEFUIModeBase.getFTMode() == null;
            }
            case 20: {
                return pSDEFUIModeBase.getGCRPSSysPFPluginId() == null;
            }
            case 21: {
                return pSDEFUIModeBase.getGCRPSSysPFPluginName() == null;
            }
            case 22: {
                return pSDEFUIModeBase.getGridColAlign() == null;
            }
            case 23: {
                return pSDEFUIModeBase.getGridColCLMode() == null;
            }
            case 24: {
                return pSDEFUIModeBase.getGridColWidth() == null;
            }
            case 25: {
                return pSDEFUIModeBase.getHeight() == null;
            }
            case 26: {
                return pSDEFUIModeBase.getIgnoreInput() == null;
            }
            case 27: {
                return pSDEFUIModeBase.getItemPSACHandlerId() == null;
            }
            case 28: {
                return pSDEFUIModeBase.getItemPSACHandlerName() == null;
            }
            case 29: {
                return pSDEFUIModeBase.getJSFormat() == null;
            }
            case 30: {
                return pSDEFUIModeBase.getLockFlag() == null;
            }
            case 31: {
                return pSDEFUIModeBase.getMaxValue() == null;
            }
            case 32: {
                return pSDEFUIModeBase.getMemo() == null;
            }
            case 33: {
                return pSDEFUIModeBase.getMinStrLength() == null;
            }
            case 34: {
                return pSDEFUIModeBase.getMinValue() == null;
            }
            case 35: {
                return pSDEFUIModeBase.getNeedCodeListConfig() == null;
            }
            case 36: {
                return pSDEFUIModeBase.getNoSort() == null;
            }
            case 37: {
                return pSDEFUIModeBase.getPHPSLanResId() == null;
            }
            case 38: {
                return pSDEFUIModeBase.getPHPSLanResName() == null;
            }
            case 39: {
                return pSDEFUIModeBase.getPickupTextOpts() == null;
            }
            case 40: {
                return pSDEFUIModeBase.getPlaceHolder() == null;
            }
            case 41: {
                return pSDEFUIModeBase.getPrecision2() == null;
            }
            case 42: {
                return pSDEFUIModeBase.getPreventXSS() == null;
            }
            case 43: {
                return pSDEFUIModeBase.getPSCodeListId() == null;
            }
            case 44: {
                return pSDEFUIModeBase.getPSCodeListName() == null;
            }
            case 45: {
                return pSDEFUIModeBase.getPSDEFUIModeId() == null;
            }
            case 46: {
                return pSDEFUIModeBase.getPSDEFUIModeName() == null;
            }
            case 47: {
                return pSDEFUIModeBase.getPSDEFId() == null;
            }
            case 48: {
                return pSDEFUIModeBase.getPSDEFInputTipId() == null;
            }
            case 49: {
                return pSDEFUIModeBase.getPSDEFInputTipName() == null;
            }
            case 50: {
                return pSDEFUIModeBase.getPSDEFName() == null;
            }
            case 51: {
                return pSDEFUIModeBase.getPSDEId() == null;
            }
            case 52: {
                return pSDEFUIModeBase.getPSDEName() == null;
            }
            case 53: {
                return pSDEFUIModeBase.getPSDynaInstId() == null;
            }
            case 54: {
                return pSDEFUIModeBase.getPSSysAppId() == null;
            }
            case 55: {
                return pSDEFUIModeBase.getPSSysAppName() == null;
            }
            case 56: {
                return pSDEFUIModeBase.getPSSysDictCatId() == null;
            }
            case 57: {
                return pSDEFUIModeBase.getPSSysDictCatName() == null;
            }
            case 58: {
                return pSDEFUIModeBase.getPSSysEditorStyleId() == null;
            }
            case 59: {
                return pSDEFUIModeBase.getPSSysEditorStyleName() == null;
            }
            case 60: {
                return pSDEFUIModeBase.getPSSysImageId() == null;
            }
            case 61: {
                return pSDEFUIModeBase.getPSSysImageName() == null;
            }
            case 62: {
                return pSDEFUIModeBase.getPSSystemId() == null;
            }
            case 63: {
                return pSDEFUIModeBase.getPSSysUnitId() == null;
            }
            case 64: {
                return pSDEFUIModeBase.getPSSysUnitName() == null;
            }
            case 65: {
                return pSDEFUIModeBase.getPSSysValueRuleId() == null;
            }
            case 66: {
                return pSDEFUIModeBase.getPSSysValueRuleName() == null;
            }
            case 67: {
                return pSDEFUIModeBase.getRefADPSDELogicId() == null;
            }
            case 68: {
                return pSDEFUIModeBase.getRefADPSDELogicName() == null;
            }
            case 69: {
                return pSDEFUIModeBase.getRefLinkPSDEViewId() == null;
            }
            case 70: {
                return pSDEFUIModeBase.getRefLinkPSDEViewName() == null;
            }
            case 71: {
                return pSDEFUIModeBase.getRefMPickupPSDEViewId() == null;
            }
            case 72: {
                return pSDEFUIModeBase.getRefMPickupPSDEViewName() == null;
            }
            case 73: {
                return pSDEFUIModeBase.getRefPickupPSDEViewId() == null;
            }
            case 74: {
                return pSDEFUIModeBase.getRefPickupPSDEViewName() == null;
            }
            case 75: {
                return pSDEFUIModeBase.getRefPSDEACModeId() == null;
            }
            case 76: {
                return pSDEFUIModeBase.getRefPSDEACModeName() == null;
            }
            case 77: {
                return pSDEFUIModeBase.getRefPSDEDataSetId() == null;
            }
            case 78: {
                return pSDEFUIModeBase.getRefPSDEDataSetName() == null;
            }
            case 79: {
                return pSDEFUIModeBase.getRefPSDEId() == null;
            }
            case 80: {
                return pSDEFUIModeBase.getRefPSDEName() == null;
            }
            case 81: {
                return pSDEFUIModeBase.getRefPSDERId() == null;
            }
            case 82: {
                return pSDEFUIModeBase.getRefPSDERName() == null;
            }
            case 83: {
                return pSDEFUIModeBase.getRefTempData() == null;
            }
            case 84: {
                return pSDEFUIModeBase.getResetItemName() == null;
            }
            case 85: {
                return pSDEFUIModeBase.getStringCase() == null;
            }
            case 86: {
                return pSDEFUIModeBase.getStrLength() == null;
            }
            case 87: {
                return pSDEFUIModeBase.getUnitName() == null;
            }
            case 88: {
                return pSDEFUIModeBase.getUnitNameWidth() == null;
            }
            case 89: {
                return pSDEFUIModeBase.getUpdateDate() == null;
            }
            case 90: {
                return pSDEFUIModeBase.getUpdateDV() == null;
            }
            case 91: {
                return pSDEFUIModeBase.getUpdateDVT() == null;
            }
            case 92: {
                return pSDEFUIModeBase.getUpdateMan() == null;
            }
            case 93: {
                return pSDEFUIModeBase.getUserCat() == null;
            }
            case 94: {
                return pSDEFUIModeBase.getUserParams() == null;
            }
            case 95: {
                return pSDEFUIModeBase.getUserTag() == null;
            }
            case 96: {
                return pSDEFUIModeBase.getUserTag2() == null;
            }
            case 97: {
                return pSDEFUIModeBase.getUserTag3() == null;
            }
            case 98: {
                return pSDEFUIModeBase.getUserTag4() == null;
            }
            case 99: {
                return pSDEFUIModeBase.getValueFormat() == null;
            }
            case 100: {
                return pSDEFUIModeBase.getValueItemName() == null;
            }
            case 101: {
                return pSDEFUIModeBase.getWidth() == null;
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
        return PSDEFUIModeBase.contains(this, n);
    }

    private static boolean contains(PSDEFUIModeBase pSDEFUIModeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFUIModeBase.isAllowEmptyDirty();
            }
            case 1: {
                return pSDEFUIModeBase.isCapPSLanResIdDirty();
            }
            case 2: {
                return pSDEFUIModeBase.isCapPSLanResNameDirty();
            }
            case 3: {
                return pSDEFUIModeBase.isCaptionDirty();
            }
            case 4: {
                return pSDEFUIModeBase.isCodeListConfigModeDirty();
            }
            case 5: {
                return pSDEFUIModeBase.isCodeNameDirty();
            }
            case 6: {
                return pSDEFUIModeBase.isConvertCITextDirty();
            }
            case 7: {
                return pSDEFUIModeBase.isCreateDateDirty();
            }
            case 8: {
                return pSDEFUIModeBase.isCreateDVDirty();
            }
            case 9: {
                return pSDEFUIModeBase.isCreateDVTDirty();
            }
            case 10: {
                return pSDEFUIModeBase.isCreateManDirty();
            }
            case 11: {
                return pSDEFUIModeBase.isDynaModelFlagDirty();
            }
            case 12: {
                return pSDEFUIModeBase.isEditorParamsDirty();
            }
            case 13: {
                return pSDEFUIModeBase.isEditorTypeDirty();
            }
            case 14: {
                return pSDEFUIModeBase.isEditorTypeNameDirty();
            }
            case 15: {
                return pSDEFUIModeBase.isEnableInputTipDirty();
            }
            case 16: {
                return pSDEFUIModeBase.isEnableResetItemNameDirty();
            }
            case 17: {
                return pSDEFUIModeBase.isEnableUnitNameDirty();
            }
            case 18: {
                return pSDEFUIModeBase.isEnableValueRuleDirty();
            }
            case 19: {
                return pSDEFUIModeBase.isFTModeDirty();
            }
            case 20: {
                return pSDEFUIModeBase.isGCRPSSysPFPluginIdDirty();
            }
            case 21: {
                return pSDEFUIModeBase.isGCRPSSysPFPluginNameDirty();
            }
            case 22: {
                return pSDEFUIModeBase.isGridColAlignDirty();
            }
            case 23: {
                return pSDEFUIModeBase.isGridColCLModeDirty();
            }
            case 24: {
                return pSDEFUIModeBase.isGridColWidthDirty();
            }
            case 25: {
                return pSDEFUIModeBase.isHeightDirty();
            }
            case 26: {
                return pSDEFUIModeBase.isIgnoreInputDirty();
            }
            case 27: {
                return pSDEFUIModeBase.isItemPSACHandlerIdDirty();
            }
            case 28: {
                return pSDEFUIModeBase.isItemPSACHandlerNameDirty();
            }
            case 29: {
                return pSDEFUIModeBase.isJSFormatDirty();
            }
            case 30: {
                return pSDEFUIModeBase.isLockFlagDirty();
            }
            case 31: {
                return pSDEFUIModeBase.isMaxValueDirty();
            }
            case 32: {
                return pSDEFUIModeBase.isMemoDirty();
            }
            case 33: {
                return pSDEFUIModeBase.isMinStrLengthDirty();
            }
            case 34: {
                return pSDEFUIModeBase.isMinValueDirty();
            }
            case 35: {
                return pSDEFUIModeBase.isNeedCodeListConfigDirty();
            }
            case 36: {
                return pSDEFUIModeBase.isNoSortDirty();
            }
            case 37: {
                return pSDEFUIModeBase.isPHPSLanResIdDirty();
            }
            case 38: {
                return pSDEFUIModeBase.isPHPSLanResNameDirty();
            }
            case 39: {
                return pSDEFUIModeBase.isPickupTextOptsDirty();
            }
            case 40: {
                return pSDEFUIModeBase.isPlaceHolderDirty();
            }
            case 41: {
                return pSDEFUIModeBase.isPrecision2Dirty();
            }
            case 42: {
                return pSDEFUIModeBase.isPreventXSSDirty();
            }
            case 43: {
                return pSDEFUIModeBase.isPSCodeListIdDirty();
            }
            case 44: {
                return pSDEFUIModeBase.isPSCodeListNameDirty();
            }
            case 45: {
                return pSDEFUIModeBase.isPSDEFUIModeIdDirty();
            }
            case 46: {
                return pSDEFUIModeBase.isPSDEFUIModeNameDirty();
            }
            case 47: {
                return pSDEFUIModeBase.isPSDEFIdDirty();
            }
            case 48: {
                return pSDEFUIModeBase.isPSDEFInputTipIdDirty();
            }
            case 49: {
                return pSDEFUIModeBase.isPSDEFInputTipNameDirty();
            }
            case 50: {
                return pSDEFUIModeBase.isPSDEFNameDirty();
            }
            case 51: {
                return pSDEFUIModeBase.isPSDEIdDirty();
            }
            case 52: {
                return pSDEFUIModeBase.isPSDENameDirty();
            }
            case 53: {
                return pSDEFUIModeBase.isPSDynaInstIdDirty();
            }
            case 54: {
                return pSDEFUIModeBase.isPSSysAppIdDirty();
            }
            case 55: {
                return pSDEFUIModeBase.isPSSysAppNameDirty();
            }
            case 56: {
                return pSDEFUIModeBase.isPSSysDictCatIdDirty();
            }
            case 57: {
                return pSDEFUIModeBase.isPSSysDictCatNameDirty();
            }
            case 58: {
                return pSDEFUIModeBase.isPSSysEditorStyleIdDirty();
            }
            case 59: {
                return pSDEFUIModeBase.isPSSysEditorStyleNameDirty();
            }
            case 60: {
                return pSDEFUIModeBase.isPSSysImageIdDirty();
            }
            case 61: {
                return pSDEFUIModeBase.isPSSysImageNameDirty();
            }
            case 62: {
                return pSDEFUIModeBase.isPSSystemIdDirty();
            }
            case 63: {
                return pSDEFUIModeBase.isPSSysUnitIdDirty();
            }
            case 64: {
                return pSDEFUIModeBase.isPSSysUnitNameDirty();
            }
            case 65: {
                return pSDEFUIModeBase.isPSSysValueRuleIdDirty();
            }
            case 66: {
                return pSDEFUIModeBase.isPSSysValueRuleNameDirty();
            }
            case 67: {
                return pSDEFUIModeBase.isRefADPSDELogicIdDirty();
            }
            case 68: {
                return pSDEFUIModeBase.isRefADPSDELogicNameDirty();
            }
            case 69: {
                return pSDEFUIModeBase.isRefLinkPSDEViewIdDirty();
            }
            case 70: {
                return pSDEFUIModeBase.isRefLinkPSDEViewNameDirty();
            }
            case 71: {
                return pSDEFUIModeBase.isRefMPickupPSDEViewIdDirty();
            }
            case 72: {
                return pSDEFUIModeBase.isRefMPickupPSDEViewNameDirty();
            }
            case 73: {
                return pSDEFUIModeBase.isRefPickupPSDEViewIdDirty();
            }
            case 74: {
                return pSDEFUIModeBase.isRefPickupPSDEViewNameDirty();
            }
            case 75: {
                return pSDEFUIModeBase.isRefPSDEACModeIdDirty();
            }
            case 76: {
                return pSDEFUIModeBase.isRefPSDEACModeNameDirty();
            }
            case 77: {
                return pSDEFUIModeBase.isRefPSDEDataSetIdDirty();
            }
            case 78: {
                return pSDEFUIModeBase.isRefPSDEDataSetNameDirty();
            }
            case 79: {
                return pSDEFUIModeBase.isRefPSDEIdDirty();
            }
            case 80: {
                return pSDEFUIModeBase.isRefPSDENameDirty();
            }
            case 81: {
                return pSDEFUIModeBase.isRefPSDERIdDirty();
            }
            case 82: {
                return pSDEFUIModeBase.isRefPSDERNameDirty();
            }
            case 83: {
                return pSDEFUIModeBase.isRefTempDataDirty();
            }
            case 84: {
                return pSDEFUIModeBase.isResetItemNameDirty();
            }
            case 85: {
                return pSDEFUIModeBase.isStringCaseDirty();
            }
            case 86: {
                return pSDEFUIModeBase.isStrLengthDirty();
            }
            case 87: {
                return pSDEFUIModeBase.isUnitNameDirty();
            }
            case 88: {
                return pSDEFUIModeBase.isUnitNameWidthDirty();
            }
            case 89: {
                return pSDEFUIModeBase.isUpdateDateDirty();
            }
            case 90: {
                return pSDEFUIModeBase.isUpdateDVDirty();
            }
            case 91: {
                return pSDEFUIModeBase.isUpdateDVTDirty();
            }
            case 92: {
                return pSDEFUIModeBase.isUpdateManDirty();
            }
            case 93: {
                return pSDEFUIModeBase.isUserCatDirty();
            }
            case 94: {
                return pSDEFUIModeBase.isUserParamsDirty();
            }
            case 95: {
                return pSDEFUIModeBase.isUserTagDirty();
            }
            case 96: {
                return pSDEFUIModeBase.isUserTag2Dirty();
            }
            case 97: {
                return pSDEFUIModeBase.isUserTag3Dirty();
            }
            case 98: {
                return pSDEFUIModeBase.isUserTag4Dirty();
            }
            case 99: {
                return pSDEFUIModeBase.isValueFormatDirty();
            }
            case 100: {
                return pSDEFUIModeBase.isValueItemNameDirty();
            }
            case 101: {
                return pSDEFUIModeBase.isWidthDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEFUIModeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEFUIModeBase pSDEFUIModeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEFUIModeBase.getAllowEmpty() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"allowempty", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getAllowEmpty()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getCapPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresid", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getCapPSLanResId()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getCapPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresname", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getCapPSLanResName()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"caption", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getCaption()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getCodeListConfigMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codelistconfigmode", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getCodeListConfigMode()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getConvertCIText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"convertcitext", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getConvertCIText()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getCreateDV() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdv", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getCreateDV()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getCreateDVT() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdvt", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getCreateDVT()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getEditorParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"editorparams", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getEditorParams()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getEditorType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"editortype", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getEditorType()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getEditorTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"editortypename", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getEditorTypeName()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getEnableInputTip() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableinputtip", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getEnableInputTip()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getEnableResetItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableresetitemname", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getEnableResetItemName()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getEnableUnitName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableunitname", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getEnableUnitName()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getEnableValueRule() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablevaluerule", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getEnableValueRule()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getFTMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ftmode", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getFTMode()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getGCRPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gcrpssyspfpluginid", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getGCRPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getGCRPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gcrpssyspfpluginname", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getGCRPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getGridColAlign() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gridcolalign", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getGridColAlign()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getGridColCLMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gridcolclmode", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getGridColCLMode()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getGridColWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gridcolwidth", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getGridColWidth()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"height", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getHeight()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getIgnoreInput() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ignoreinput", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getIgnoreInput()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getItemPSACHandlerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itempsachandlerid", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getItemPSACHandlerId()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getItemPSACHandlerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itempsachandlername", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getItemPSACHandlerName()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getJSFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jsformat", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getJSFormat()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getMaxValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxvalue", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getMaxValue()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getMinStrLength() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minstrlength", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getMinStrLength()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getMinValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minvalue", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getMinValue()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getNeedCodeListConfig() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"needcodelistconfig", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getNeedCodeListConfig()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getNoSort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nosort", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getNoSort()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getPHPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"phpslanresid", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getPHPSLanResId()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getPHPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"phpslanresname", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getPHPSLanResName()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getPickupTextOpts() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pickuptextopts", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getPickupTextOpts()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getPlaceHolder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"placeholder", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getPlaceHolder()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getPrecision2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"precision2", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getPrecision2()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getPreventXSS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"preventxss", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getPreventXSS()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getPSCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistid", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getPSCodeListId()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getPSCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistname", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getPSCodeListName()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getPSDEFUIModeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefformitemid", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getPSDEFUIModeId()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getPSDEFUIModeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefformitemname", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getPSDEFUIModeName()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefid", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getPSDEFId()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getPSDEFInputTipId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefinputtipid", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getPSDEFInputTipId()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getPSDEFInputTipName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefinputtipname", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getPSDEFInputTipName()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefname", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getPSDEFName()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getPSSysDictCatId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdictcatid", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getPSSysDictCatId()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getPSSysDictCatName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdictcatname", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getPSSysDictCatName()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getPSSysEditorStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseditorstyleid", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getPSSysEditorStyleId()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getPSSysEditorStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseditorstylename", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getPSSysEditorStyleName()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getPSSysImageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimageid", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getPSSysImageId()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getPSSysImageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimagename", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getPSSysImageName()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getPSSysUnitId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysunitid", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getPSSysUnitId()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getPSSysUnitName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysunitname", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getPSSysUnitName()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getPSSysValueRuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysvalueruleid", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getPSSysValueRuleId()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getPSSysValueRuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysvaluerulename", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getPSSysValueRuleName()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getRefADPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refadpsdelogicid", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getRefADPSDELogicId()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getRefADPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refadpsdelogicname", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getRefADPSDELogicName()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getRefLinkPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reflinkpsdeviewid", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getRefLinkPSDEViewId()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getRefLinkPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reflinkpsdeviewname", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getRefLinkPSDEViewName()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getRefMPickupPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refmpickuppsdeviewid", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getRefMPickupPSDEViewId()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getRefMPickupPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refmpickuppsdeviewname", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getRefMPickupPSDEViewName()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getRefPickupPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpickuppsdeviewid", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getRefPickupPSDEViewId()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getRefPickupPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpickuppsdeviewname", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getRefPickupPSDEViewName()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getRefPSDEACModeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdeacmodeid", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getRefPSDEACModeId()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getRefPSDEACModeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdeacmodename", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getRefPSDEACModeName()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getRefPSDEDataSetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdedatasetid", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getRefPSDEDataSetId()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getRefPSDEDataSetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdedatasetname", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getRefPSDEDataSetName()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getRefPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdeid", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getRefPSDEId()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getRefPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdename", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getRefPSDEName()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getRefPSDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsderid", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getRefPSDERId()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getRefPSDERName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdername", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getRefPSDERName()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getRefTempData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reftempdata", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getRefTempData()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getResetItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resetitemname", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getResetItemName()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getStringCase() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"stringcase", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getStringCase()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getStrLength() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"strlength", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getStrLength()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getUnitName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"unitname", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getUnitName()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getUnitNameWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"unitnamewidth", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getUnitNameWidth()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getUpdateDV() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedv", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getUpdateDV()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getUpdateDVT() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedvt", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getUpdateDVT()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getUserParams()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getValueFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valueformat", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getValueFormat()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getValueItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valueitemname", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getValueItemName()), (boolean)false);
        }
        if (bl || pSDEFUIModeBase.getWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"width", (Object)PSDEFUIModeBase.getJSONValue((Object)pSDEFUIModeBase.getWidth()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEFUIModeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEFUIModeBase pSDEFUIModeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEFUIModeBase.getAllowEmpty() != null) {
            object = pSDEFUIModeBase.getAllowEmpty();
            xmlNode.setAttribute(FIELD_ALLOWEMPTY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFUIModeBase.getCapPSLanResId() != null) {
            object = pSDEFUIModeBase.getCapPSLanResId();
            xmlNode.setAttribute(FIELD_CAPPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getCapPSLanResName() != null) {
            object = pSDEFUIModeBase.getCapPSLanResName();
            xmlNode.setAttribute(FIELD_CAPPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getCaption() != null) {
            object = pSDEFUIModeBase.getCaption();
            xmlNode.setAttribute(FIELD_CAPTION, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getCodeListConfigMode() != null) {
            object = pSDEFUIModeBase.getCodeListConfigMode();
            xmlNode.setAttribute(FIELD_CODELISTCONFIGMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFUIModeBase.getCodeName() != null) {
            object = pSDEFUIModeBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getConvertCIText() != null) {
            object = pSDEFUIModeBase.getConvertCIText();
            xmlNode.setAttribute(FIELD_CONVERTCITEXT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFUIModeBase.getCreateDate() != null) {
            object = pSDEFUIModeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFUIModeBase.getCreateDV() != null) {
            object = pSDEFUIModeBase.getCreateDV();
            xmlNode.setAttribute(FIELD_CREATEDV, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getCreateDVT() != null) {
            object = pSDEFUIModeBase.getCreateDVT();
            xmlNode.setAttribute(FIELD_CREATEDVT, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getCreateMan() != null) {
            object = pSDEFUIModeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getDynaModelFlag() != null) {
            object = pSDEFUIModeBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFUIModeBase.getEditorParams() != null) {
            object = pSDEFUIModeBase.getEditorParams();
            xmlNode.setAttribute(FIELD_EDITORPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getEditorType() != null) {
            object = pSDEFUIModeBase.getEditorType();
            xmlNode.setAttribute(FIELD_EDITORTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getEditorTypeName() != null) {
            object = pSDEFUIModeBase.getEditorTypeName();
            xmlNode.setAttribute(FIELD_EDITORTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getEnableInputTip() != null) {
            object = pSDEFUIModeBase.getEnableInputTip();
            xmlNode.setAttribute(FIELD_ENABLEINPUTTIP, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFUIModeBase.getEnableResetItemName() != null) {
            object = pSDEFUIModeBase.getEnableResetItemName();
            xmlNode.setAttribute(FIELD_ENABLERESETITEMNAME, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFUIModeBase.getEnableUnitName() != null) {
            object = pSDEFUIModeBase.getEnableUnitName();
            xmlNode.setAttribute(FIELD_ENABLEUNITNAME, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFUIModeBase.getEnableValueRule() != null) {
            object = pSDEFUIModeBase.getEnableValueRule();
            xmlNode.setAttribute(FIELD_ENABLEVALUERULE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFUIModeBase.getFTMode() != null) {
            object = pSDEFUIModeBase.getFTMode();
            xmlNode.setAttribute(FIELD_FTMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getGCRPSSysPFPluginId() != null) {
            object = pSDEFUIModeBase.getGCRPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_GCRPSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getGCRPSSysPFPluginName() != null) {
            object = pSDEFUIModeBase.getGCRPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_GCRPSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getGridColAlign() != null) {
            object = pSDEFUIModeBase.getGridColAlign();
            xmlNode.setAttribute(FIELD_GRIDCOLALIGN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getGridColCLMode() != null) {
            object = pSDEFUIModeBase.getGridColCLMode();
            xmlNode.setAttribute(FIELD_GRIDCOLCLMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getGridColWidth() != null) {
            object = pSDEFUIModeBase.getGridColWidth();
            xmlNode.setAttribute(FIELD_GRIDCOLWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFUIModeBase.getHeight() != null) {
            object = pSDEFUIModeBase.getHeight();
            xmlNode.setAttribute(FIELD_HEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFUIModeBase.getIgnoreInput() != null) {
            object = pSDEFUIModeBase.getIgnoreInput();
            xmlNode.setAttribute(FIELD_IGNOREINPUT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFUIModeBase.getItemPSACHandlerId() != null) {
            object = pSDEFUIModeBase.getItemPSACHandlerId();
            xmlNode.setAttribute(FIELD_ITEMPSACHANDLERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getItemPSACHandlerName() != null) {
            object = pSDEFUIModeBase.getItemPSACHandlerName();
            xmlNode.setAttribute(FIELD_ITEMPSACHANDLERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getJSFormat() != null) {
            object = pSDEFUIModeBase.getJSFormat();
            xmlNode.setAttribute(FIELD_JSFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getLockFlag() != null) {
            object = pSDEFUIModeBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFUIModeBase.getMaxValue() != null) {
            object = pSDEFUIModeBase.getMaxValue();
            xmlNode.setAttribute(FIELD_MAXVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getMemo() != null) {
            object = pSDEFUIModeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getMinStrLength() != null) {
            object = pSDEFUIModeBase.getMinStrLength();
            xmlNode.setAttribute(FIELD_MINSTRLENGTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFUIModeBase.getMinValue() != null) {
            object = pSDEFUIModeBase.getMinValue();
            xmlNode.setAttribute(FIELD_MINVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getNeedCodeListConfig() != null) {
            object = pSDEFUIModeBase.getNeedCodeListConfig();
            xmlNode.setAttribute(FIELD_NEEDCODELISTCONFIG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFUIModeBase.getNoSort() != null) {
            object = pSDEFUIModeBase.getNoSort();
            xmlNode.setAttribute(FIELD_NOSORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFUIModeBase.getPHPSLanResId() != null) {
            object = pSDEFUIModeBase.getPHPSLanResId();
            xmlNode.setAttribute(FIELD_PHPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getPHPSLanResName() != null) {
            object = pSDEFUIModeBase.getPHPSLanResName();
            xmlNode.setAttribute(FIELD_PHPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getPickupTextOpts() != null) {
            object = pSDEFUIModeBase.getPickupTextOpts();
            xmlNode.setAttribute(FIELD_PICKUPTEXTOPTS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFUIModeBase.getPlaceHolder() != null) {
            object = pSDEFUIModeBase.getPlaceHolder();
            xmlNode.setAttribute(FIELD_PLACEHOLDER, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getPrecision2() != null) {
            object = pSDEFUIModeBase.getPrecision2();
            xmlNode.setAttribute(FIELD_PRECISION2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFUIModeBase.getPreventXSS() != null) {
            object = pSDEFUIModeBase.getPreventXSS();
            xmlNode.setAttribute(FIELD_PREVENTXSS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFUIModeBase.getPSCodeListId() != null) {
            object = pSDEFUIModeBase.getPSCodeListId();
            xmlNode.setAttribute(FIELD_PSCODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getPSCodeListName() != null) {
            object = pSDEFUIModeBase.getPSCodeListName();
            xmlNode.setAttribute(FIELD_PSCODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getPSDEFUIModeId() != null) {
            object = pSDEFUIModeBase.getPSDEFUIModeId();
            xmlNode.setAttribute("PSDEFUIMODEID", object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getPSDEFUIModeName() != null) {
            object = pSDEFUIModeBase.getPSDEFUIModeName();
            xmlNode.setAttribute("PSDEFUIMODENAME", object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getPSDEFId() != null) {
            object = pSDEFUIModeBase.getPSDEFId();
            xmlNode.setAttribute(FIELD_PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getPSDEFInputTipId() != null) {
            object = pSDEFUIModeBase.getPSDEFInputTipId();
            xmlNode.setAttribute(FIELD_PSDEFINPUTTIPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getPSDEFInputTipName() != null) {
            object = pSDEFUIModeBase.getPSDEFInputTipName();
            xmlNode.setAttribute(FIELD_PSDEFINPUTTIPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getPSDEFName() != null) {
            object = pSDEFUIModeBase.getPSDEFName();
            xmlNode.setAttribute(FIELD_PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getPSDEId() != null) {
            object = pSDEFUIModeBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getPSDEName() != null) {
            object = pSDEFUIModeBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getPSDynaInstId() != null) {
            object = pSDEFUIModeBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getPSSysAppId() != null) {
            object = pSDEFUIModeBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getPSSysAppName() != null) {
            object = pSDEFUIModeBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getPSSysDictCatId() != null) {
            object = pSDEFUIModeBase.getPSSysDictCatId();
            xmlNode.setAttribute(FIELD_PSSYSDICTCATID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getPSSysDictCatName() != null) {
            object = pSDEFUIModeBase.getPSSysDictCatName();
            xmlNode.setAttribute(FIELD_PSSYSDICTCATNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getPSSysEditorStyleId() != null) {
            object = pSDEFUIModeBase.getPSSysEditorStyleId();
            xmlNode.setAttribute(FIELD_PSSYSEDITORSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getPSSysEditorStyleName() != null) {
            object = pSDEFUIModeBase.getPSSysEditorStyleName();
            xmlNode.setAttribute(FIELD_PSSYSEDITORSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getPSSysImageId() != null) {
            object = pSDEFUIModeBase.getPSSysImageId();
            xmlNode.setAttribute(FIELD_PSSYSIMAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getPSSysImageName() != null) {
            object = pSDEFUIModeBase.getPSSysImageName();
            xmlNode.setAttribute(FIELD_PSSYSIMAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getPSSystemId() != null) {
            object = pSDEFUIModeBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getPSSysUnitId() != null) {
            object = pSDEFUIModeBase.getPSSysUnitId();
            xmlNode.setAttribute(FIELD_PSSYSUNITID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getPSSysUnitName() != null) {
            object = pSDEFUIModeBase.getPSSysUnitName();
            xmlNode.setAttribute(FIELD_PSSYSUNITNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getPSSysValueRuleId() != null) {
            object = pSDEFUIModeBase.getPSSysValueRuleId();
            xmlNode.setAttribute(FIELD_PSSYSVALUERULEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getPSSysValueRuleName() != null) {
            object = pSDEFUIModeBase.getPSSysValueRuleName();
            xmlNode.setAttribute(FIELD_PSSYSVALUERULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getRefADPSDELogicId() != null) {
            object = pSDEFUIModeBase.getRefADPSDELogicId();
            xmlNode.setAttribute(FIELD_REFADPSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getRefADPSDELogicName() != null) {
            object = pSDEFUIModeBase.getRefADPSDELogicName();
            xmlNode.setAttribute(FIELD_REFADPSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getRefLinkPSDEViewId() != null) {
            object = pSDEFUIModeBase.getRefLinkPSDEViewId();
            xmlNode.setAttribute(FIELD_REFLINKPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getRefLinkPSDEViewName() != null) {
            object = pSDEFUIModeBase.getRefLinkPSDEViewName();
            xmlNode.setAttribute(FIELD_REFLINKPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getRefMPickupPSDEViewId() != null) {
            object = pSDEFUIModeBase.getRefMPickupPSDEViewId();
            xmlNode.setAttribute(FIELD_REFMPICKUPPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getRefMPickupPSDEViewName() != null) {
            object = pSDEFUIModeBase.getRefMPickupPSDEViewName();
            xmlNode.setAttribute(FIELD_REFMPICKUPPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getRefPickupPSDEViewId() != null) {
            object = pSDEFUIModeBase.getRefPickupPSDEViewId();
            xmlNode.setAttribute(FIELD_REFPICKUPPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getRefPickupPSDEViewName() != null) {
            object = pSDEFUIModeBase.getRefPickupPSDEViewName();
            xmlNode.setAttribute(FIELD_REFPICKUPPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getRefPSDEACModeId() != null) {
            object = pSDEFUIModeBase.getRefPSDEACModeId();
            xmlNode.setAttribute(FIELD_REFPSDEACMODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getRefPSDEACModeName() != null) {
            object = pSDEFUIModeBase.getRefPSDEACModeName();
            xmlNode.setAttribute(FIELD_REFPSDEACMODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getRefPSDEDataSetId() != null) {
            object = pSDEFUIModeBase.getRefPSDEDataSetId();
            xmlNode.setAttribute(FIELD_REFPSDEDATASETID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getRefPSDEDataSetName() != null) {
            object = pSDEFUIModeBase.getRefPSDEDataSetName();
            xmlNode.setAttribute(FIELD_REFPSDEDATASETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getRefPSDEId() != null) {
            object = pSDEFUIModeBase.getRefPSDEId();
            xmlNode.setAttribute(FIELD_REFPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getRefPSDEName() != null) {
            object = pSDEFUIModeBase.getRefPSDEName();
            xmlNode.setAttribute(FIELD_REFPSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getRefPSDERId() != null) {
            object = pSDEFUIModeBase.getRefPSDERId();
            xmlNode.setAttribute(FIELD_REFPSDERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getRefPSDERName() != null) {
            object = pSDEFUIModeBase.getRefPSDERName();
            xmlNode.setAttribute(FIELD_REFPSDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getRefTempData() != null) {
            object = pSDEFUIModeBase.getRefTempData();
            xmlNode.setAttribute(FIELD_REFTEMPDATA, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFUIModeBase.getResetItemName() != null) {
            object = pSDEFUIModeBase.getResetItemName();
            xmlNode.setAttribute(FIELD_RESETITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getStringCase() != null) {
            object = pSDEFUIModeBase.getStringCase();
            xmlNode.setAttribute(FIELD_STRINGCASE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getStrLength() != null) {
            object = pSDEFUIModeBase.getStrLength();
            xmlNode.setAttribute(FIELD_STRLENGTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFUIModeBase.getUnitName() != null) {
            object = pSDEFUIModeBase.getUnitName();
            xmlNode.setAttribute(FIELD_UNITNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getUnitNameWidth() != null) {
            object = pSDEFUIModeBase.getUnitNameWidth();
            xmlNode.setAttribute(FIELD_UNITNAMEWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFUIModeBase.getUpdateDate() != null) {
            object = pSDEFUIModeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFUIModeBase.getUpdateDV() != null) {
            object = pSDEFUIModeBase.getUpdateDV();
            xmlNode.setAttribute(FIELD_UPDATEDV, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getUpdateDVT() != null) {
            object = pSDEFUIModeBase.getUpdateDVT();
            xmlNode.setAttribute(FIELD_UPDATEDVT, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getUpdateMan() != null) {
            object = pSDEFUIModeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getUserCat() != null) {
            object = pSDEFUIModeBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getUserParams() != null) {
            object = pSDEFUIModeBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getUserTag() != null) {
            object = pSDEFUIModeBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getUserTag2() != null) {
            object = pSDEFUIModeBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getUserTag3() != null) {
            object = pSDEFUIModeBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getUserTag4() != null) {
            object = pSDEFUIModeBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getValueFormat() != null) {
            object = pSDEFUIModeBase.getValueFormat();
            xmlNode.setAttribute(FIELD_VALUEFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getValueItemName() != null) {
            object = pSDEFUIModeBase.getValueItemName();
            xmlNode.setAttribute(FIELD_VALUEITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFUIModeBase.getWidth() != null) {
            object = pSDEFUIModeBase.getWidth();
            xmlNode.setAttribute(FIELD_WIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEFUIModeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEFUIModeBase pSDEFUIModeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEFUIModeBase.isAllowEmptyDirty() && (bl || pSDEFUIModeBase.getAllowEmpty() != null)) {
            iDataObject.set(FIELD_ALLOWEMPTY, (Object)pSDEFUIModeBase.getAllowEmpty());
        }
        if (pSDEFUIModeBase.isCapPSLanResIdDirty() && (bl || pSDEFUIModeBase.getCapPSLanResId() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESID, (Object)pSDEFUIModeBase.getCapPSLanResId());
        }
        if (pSDEFUIModeBase.isCapPSLanResNameDirty() && (bl || pSDEFUIModeBase.getCapPSLanResName() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESNAME, (Object)pSDEFUIModeBase.getCapPSLanResName());
        }
        if (pSDEFUIModeBase.isCaptionDirty() && (bl || pSDEFUIModeBase.getCaption() != null)) {
            iDataObject.set(FIELD_CAPTION, (Object)pSDEFUIModeBase.getCaption());
        }
        if (pSDEFUIModeBase.isCodeListConfigModeDirty() && (bl || pSDEFUIModeBase.getCodeListConfigMode() != null)) {
            iDataObject.set(FIELD_CODELISTCONFIGMODE, (Object)pSDEFUIModeBase.getCodeListConfigMode());
        }
        if (pSDEFUIModeBase.isCodeNameDirty() && (bl || pSDEFUIModeBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEFUIModeBase.getCodeName());
        }
        if (pSDEFUIModeBase.isConvertCITextDirty() && (bl || pSDEFUIModeBase.getConvertCIText() != null)) {
            iDataObject.set(FIELD_CONVERTCITEXT, (Object)pSDEFUIModeBase.getConvertCIText());
        }
        if (pSDEFUIModeBase.isCreateDateDirty() && (bl || pSDEFUIModeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEFUIModeBase.getCreateDate());
        }
        if (pSDEFUIModeBase.isCreateDVDirty() && (bl || pSDEFUIModeBase.getCreateDV() != null)) {
            iDataObject.set(FIELD_CREATEDV, (Object)pSDEFUIModeBase.getCreateDV());
        }
        if (pSDEFUIModeBase.isCreateDVTDirty() && (bl || pSDEFUIModeBase.getCreateDVT() != null)) {
            iDataObject.set(FIELD_CREATEDVT, (Object)pSDEFUIModeBase.getCreateDVT());
        }
        if (pSDEFUIModeBase.isCreateManDirty() && (bl || pSDEFUIModeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEFUIModeBase.getCreateMan());
        }
        if (pSDEFUIModeBase.isDynaModelFlagDirty() && (bl || pSDEFUIModeBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDEFUIModeBase.getDynaModelFlag());
        }
        if (pSDEFUIModeBase.isEditorParamsDirty() && (bl || pSDEFUIModeBase.getEditorParams() != null)) {
            iDataObject.set(FIELD_EDITORPARAMS, (Object)pSDEFUIModeBase.getEditorParams());
        }
        if (pSDEFUIModeBase.isEditorTypeDirty() && (bl || pSDEFUIModeBase.getEditorType() != null)) {
            iDataObject.set(FIELD_EDITORTYPE, (Object)pSDEFUIModeBase.getEditorType());
        }
        if (pSDEFUIModeBase.isEditorTypeNameDirty() && (bl || pSDEFUIModeBase.getEditorTypeName() != null)) {
            iDataObject.set(FIELD_EDITORTYPENAME, (Object)pSDEFUIModeBase.getEditorTypeName());
        }
        if (pSDEFUIModeBase.isEnableInputTipDirty() && (bl || pSDEFUIModeBase.getEnableInputTip() != null)) {
            iDataObject.set(FIELD_ENABLEINPUTTIP, (Object)pSDEFUIModeBase.getEnableInputTip());
        }
        if (pSDEFUIModeBase.isEnableResetItemNameDirty() && (bl || pSDEFUIModeBase.getEnableResetItemName() != null)) {
            iDataObject.set(FIELD_ENABLERESETITEMNAME, (Object)pSDEFUIModeBase.getEnableResetItemName());
        }
        if (pSDEFUIModeBase.isEnableUnitNameDirty() && (bl || pSDEFUIModeBase.getEnableUnitName() != null)) {
            iDataObject.set(FIELD_ENABLEUNITNAME, (Object)pSDEFUIModeBase.getEnableUnitName());
        }
        if (pSDEFUIModeBase.isEnableValueRuleDirty() && (bl || pSDEFUIModeBase.getEnableValueRule() != null)) {
            iDataObject.set(FIELD_ENABLEVALUERULE, (Object)pSDEFUIModeBase.getEnableValueRule());
        }
        if (pSDEFUIModeBase.isFTModeDirty() && (bl || pSDEFUIModeBase.getFTMode() != null)) {
            iDataObject.set(FIELD_FTMODE, (Object)pSDEFUIModeBase.getFTMode());
        }
        if (pSDEFUIModeBase.isGCRPSSysPFPluginIdDirty() && (bl || pSDEFUIModeBase.getGCRPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_GCRPSSYSPFPLUGINID, (Object)pSDEFUIModeBase.getGCRPSSysPFPluginId());
        }
        if (pSDEFUIModeBase.isGCRPSSysPFPluginNameDirty() && (bl || pSDEFUIModeBase.getGCRPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_GCRPSSYSPFPLUGINNAME, (Object)pSDEFUIModeBase.getGCRPSSysPFPluginName());
        }
        if (pSDEFUIModeBase.isGridColAlignDirty() && (bl || pSDEFUIModeBase.getGridColAlign() != null)) {
            iDataObject.set(FIELD_GRIDCOLALIGN, (Object)pSDEFUIModeBase.getGridColAlign());
        }
        if (pSDEFUIModeBase.isGridColCLModeDirty() && (bl || pSDEFUIModeBase.getGridColCLMode() != null)) {
            iDataObject.set(FIELD_GRIDCOLCLMODE, (Object)pSDEFUIModeBase.getGridColCLMode());
        }
        if (pSDEFUIModeBase.isGridColWidthDirty() && (bl || pSDEFUIModeBase.getGridColWidth() != null)) {
            iDataObject.set(FIELD_GRIDCOLWIDTH, (Object)pSDEFUIModeBase.getGridColWidth());
        }
        if (pSDEFUIModeBase.isHeightDirty() && (bl || pSDEFUIModeBase.getHeight() != null)) {
            iDataObject.set(FIELD_HEIGHT, (Object)pSDEFUIModeBase.getHeight());
        }
        if (pSDEFUIModeBase.isIgnoreInputDirty() && (bl || pSDEFUIModeBase.getIgnoreInput() != null)) {
            iDataObject.set(FIELD_IGNOREINPUT, (Object)pSDEFUIModeBase.getIgnoreInput());
        }
        if (pSDEFUIModeBase.isItemPSACHandlerIdDirty() && (bl || pSDEFUIModeBase.getItemPSACHandlerId() != null)) {
            iDataObject.set(FIELD_ITEMPSACHANDLERID, (Object)pSDEFUIModeBase.getItemPSACHandlerId());
        }
        if (pSDEFUIModeBase.isItemPSACHandlerNameDirty() && (bl || pSDEFUIModeBase.getItemPSACHandlerName() != null)) {
            iDataObject.set(FIELD_ITEMPSACHANDLERNAME, (Object)pSDEFUIModeBase.getItemPSACHandlerName());
        }
        if (pSDEFUIModeBase.isJSFormatDirty() && (bl || pSDEFUIModeBase.getJSFormat() != null)) {
            iDataObject.set(FIELD_JSFORMAT, (Object)pSDEFUIModeBase.getJSFormat());
        }
        if (pSDEFUIModeBase.isLockFlagDirty() && (bl || pSDEFUIModeBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDEFUIModeBase.getLockFlag());
        }
        if (pSDEFUIModeBase.isMaxValueDirty() && (bl || pSDEFUIModeBase.getMaxValue() != null)) {
            iDataObject.set(FIELD_MAXVALUE, (Object)pSDEFUIModeBase.getMaxValue());
        }
        if (pSDEFUIModeBase.isMemoDirty() && (bl || pSDEFUIModeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEFUIModeBase.getMemo());
        }
        if (pSDEFUIModeBase.isMinStrLengthDirty() && (bl || pSDEFUIModeBase.getMinStrLength() != null)) {
            iDataObject.set(FIELD_MINSTRLENGTH, (Object)pSDEFUIModeBase.getMinStrLength());
        }
        if (pSDEFUIModeBase.isMinValueDirty() && (bl || pSDEFUIModeBase.getMinValue() != null)) {
            iDataObject.set(FIELD_MINVALUE, (Object)pSDEFUIModeBase.getMinValue());
        }
        if (pSDEFUIModeBase.isNeedCodeListConfigDirty() && (bl || pSDEFUIModeBase.getNeedCodeListConfig() != null)) {
            iDataObject.set(FIELD_NEEDCODELISTCONFIG, (Object)pSDEFUIModeBase.getNeedCodeListConfig());
        }
        if (pSDEFUIModeBase.isNoSortDirty() && (bl || pSDEFUIModeBase.getNoSort() != null)) {
            iDataObject.set(FIELD_NOSORT, (Object)pSDEFUIModeBase.getNoSort());
        }
        if (pSDEFUIModeBase.isPHPSLanResIdDirty() && (bl || pSDEFUIModeBase.getPHPSLanResId() != null)) {
            iDataObject.set(FIELD_PHPSLANRESID, (Object)pSDEFUIModeBase.getPHPSLanResId());
        }
        if (pSDEFUIModeBase.isPHPSLanResNameDirty() && (bl || pSDEFUIModeBase.getPHPSLanResName() != null)) {
            iDataObject.set(FIELD_PHPSLANRESNAME, (Object)pSDEFUIModeBase.getPHPSLanResName());
        }
        if (pSDEFUIModeBase.isPickupTextOptsDirty() && (bl || pSDEFUIModeBase.getPickupTextOpts() != null)) {
            iDataObject.set(FIELD_PICKUPTEXTOPTS, (Object)pSDEFUIModeBase.getPickupTextOpts());
        }
        if (pSDEFUIModeBase.isPlaceHolderDirty() && (bl || pSDEFUIModeBase.getPlaceHolder() != null)) {
            iDataObject.set(FIELD_PLACEHOLDER, (Object)pSDEFUIModeBase.getPlaceHolder());
        }
        if (pSDEFUIModeBase.isPrecision2Dirty() && (bl || pSDEFUIModeBase.getPrecision2() != null)) {
            iDataObject.set(FIELD_PRECISION2, (Object)pSDEFUIModeBase.getPrecision2());
        }
        if (pSDEFUIModeBase.isPreventXSSDirty() && (bl || pSDEFUIModeBase.getPreventXSS() != null)) {
            iDataObject.set(FIELD_PREVENTXSS, (Object)pSDEFUIModeBase.getPreventXSS());
        }
        if (pSDEFUIModeBase.isPSCodeListIdDirty() && (bl || pSDEFUIModeBase.getPSCodeListId() != null)) {
            iDataObject.set(FIELD_PSCODELISTID, (Object)pSDEFUIModeBase.getPSCodeListId());
        }
        if (pSDEFUIModeBase.isPSCodeListNameDirty() && (bl || pSDEFUIModeBase.getPSCodeListName() != null)) {
            iDataObject.set(FIELD_PSCODELISTNAME, (Object)pSDEFUIModeBase.getPSCodeListName());
        }
        if (pSDEFUIModeBase.isPSDEFUIModeIdDirty() && (bl || pSDEFUIModeBase.getPSDEFUIModeId() != null)) {
            iDataObject.set(FIELD_PSDEFUIMODEID, (Object)pSDEFUIModeBase.getPSDEFUIModeId());
        }
        if (pSDEFUIModeBase.isPSDEFUIModeNameDirty() && (bl || pSDEFUIModeBase.getPSDEFUIModeName() != null)) {
            iDataObject.set(FIELD_PSDEFUIMODENAME, (Object)pSDEFUIModeBase.getPSDEFUIModeName());
        }
        if (pSDEFUIModeBase.isPSDEFIdDirty() && (bl || pSDEFUIModeBase.getPSDEFId() != null)) {
            iDataObject.set(FIELD_PSDEFID, (Object)pSDEFUIModeBase.getPSDEFId());
        }
        if (pSDEFUIModeBase.isPSDEFInputTipIdDirty() && (bl || pSDEFUIModeBase.getPSDEFInputTipId() != null)) {
            iDataObject.set(FIELD_PSDEFINPUTTIPID, (Object)pSDEFUIModeBase.getPSDEFInputTipId());
        }
        if (pSDEFUIModeBase.isPSDEFInputTipNameDirty() && (bl || pSDEFUIModeBase.getPSDEFInputTipName() != null)) {
            iDataObject.set(FIELD_PSDEFINPUTTIPNAME, (Object)pSDEFUIModeBase.getPSDEFInputTipName());
        }
        if (pSDEFUIModeBase.isPSDEFNameDirty() && (bl || pSDEFUIModeBase.getPSDEFName() != null)) {
            iDataObject.set(FIELD_PSDEFNAME, (Object)pSDEFUIModeBase.getPSDEFName());
        }
        if (pSDEFUIModeBase.isPSDEIdDirty() && (bl || pSDEFUIModeBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEFUIModeBase.getPSDEId());
        }
        if (pSDEFUIModeBase.isPSDENameDirty() && (bl || pSDEFUIModeBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEFUIModeBase.getPSDEName());
        }
        if (pSDEFUIModeBase.isPSDynaInstIdDirty() && (bl || pSDEFUIModeBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDEFUIModeBase.getPSDynaInstId());
        }
        if (pSDEFUIModeBase.isPSSysAppIdDirty() && (bl || pSDEFUIModeBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSDEFUIModeBase.getPSSysAppId());
        }
        if (pSDEFUIModeBase.isPSSysAppNameDirty() && (bl || pSDEFUIModeBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSDEFUIModeBase.getPSSysAppName());
        }
        if (pSDEFUIModeBase.isPSSysDictCatIdDirty() && (bl || pSDEFUIModeBase.getPSSysDictCatId() != null)) {
            iDataObject.set(FIELD_PSSYSDICTCATID, (Object)pSDEFUIModeBase.getPSSysDictCatId());
        }
        if (pSDEFUIModeBase.isPSSysDictCatNameDirty() && (bl || pSDEFUIModeBase.getPSSysDictCatName() != null)) {
            iDataObject.set(FIELD_PSSYSDICTCATNAME, (Object)pSDEFUIModeBase.getPSSysDictCatName());
        }
        if (pSDEFUIModeBase.isPSSysEditorStyleIdDirty() && (bl || pSDEFUIModeBase.getPSSysEditorStyleId() != null)) {
            iDataObject.set(FIELD_PSSYSEDITORSTYLEID, (Object)pSDEFUIModeBase.getPSSysEditorStyleId());
        }
        if (pSDEFUIModeBase.isPSSysEditorStyleNameDirty() && (bl || pSDEFUIModeBase.getPSSysEditorStyleName() != null)) {
            iDataObject.set(FIELD_PSSYSEDITORSTYLENAME, (Object)pSDEFUIModeBase.getPSSysEditorStyleName());
        }
        if (pSDEFUIModeBase.isPSSysImageIdDirty() && (bl || pSDEFUIModeBase.getPSSysImageId() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGEID, (Object)pSDEFUIModeBase.getPSSysImageId());
        }
        if (pSDEFUIModeBase.isPSSysImageNameDirty() && (bl || pSDEFUIModeBase.getPSSysImageName() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGENAME, (Object)pSDEFUIModeBase.getPSSysImageName());
        }
        if (pSDEFUIModeBase.isPSSystemIdDirty() && (bl || pSDEFUIModeBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSDEFUIModeBase.getPSSystemId());
        }
        if (pSDEFUIModeBase.isPSSysUnitIdDirty() && (bl || pSDEFUIModeBase.getPSSysUnitId() != null)) {
            iDataObject.set(FIELD_PSSYSUNITID, (Object)pSDEFUIModeBase.getPSSysUnitId());
        }
        if (pSDEFUIModeBase.isPSSysUnitNameDirty() && (bl || pSDEFUIModeBase.getPSSysUnitName() != null)) {
            iDataObject.set(FIELD_PSSYSUNITNAME, (Object)pSDEFUIModeBase.getPSSysUnitName());
        }
        if (pSDEFUIModeBase.isPSSysValueRuleIdDirty() && (bl || pSDEFUIModeBase.getPSSysValueRuleId() != null)) {
            iDataObject.set(FIELD_PSSYSVALUERULEID, (Object)pSDEFUIModeBase.getPSSysValueRuleId());
        }
        if (pSDEFUIModeBase.isPSSysValueRuleNameDirty() && (bl || pSDEFUIModeBase.getPSSysValueRuleName() != null)) {
            iDataObject.set(FIELD_PSSYSVALUERULENAME, (Object)pSDEFUIModeBase.getPSSysValueRuleName());
        }
        if (pSDEFUIModeBase.isRefADPSDELogicIdDirty() && (bl || pSDEFUIModeBase.getRefADPSDELogicId() != null)) {
            iDataObject.set(FIELD_REFADPSDELOGICID, (Object)pSDEFUIModeBase.getRefADPSDELogicId());
        }
        if (pSDEFUIModeBase.isRefADPSDELogicNameDirty() && (bl || pSDEFUIModeBase.getRefADPSDELogicName() != null)) {
            iDataObject.set(FIELD_REFADPSDELOGICNAME, (Object)pSDEFUIModeBase.getRefADPSDELogicName());
        }
        if (pSDEFUIModeBase.isRefLinkPSDEViewIdDirty() && (bl || pSDEFUIModeBase.getRefLinkPSDEViewId() != null)) {
            iDataObject.set(FIELD_REFLINKPSDEVIEWID, (Object)pSDEFUIModeBase.getRefLinkPSDEViewId());
        }
        if (pSDEFUIModeBase.isRefLinkPSDEViewNameDirty() && (bl || pSDEFUIModeBase.getRefLinkPSDEViewName() != null)) {
            iDataObject.set(FIELD_REFLINKPSDEVIEWNAME, (Object)pSDEFUIModeBase.getRefLinkPSDEViewName());
        }
        if (pSDEFUIModeBase.isRefMPickupPSDEViewIdDirty() && (bl || pSDEFUIModeBase.getRefMPickupPSDEViewId() != null)) {
            iDataObject.set(FIELD_REFMPICKUPPSDEVIEWID, (Object)pSDEFUIModeBase.getRefMPickupPSDEViewId());
        }
        if (pSDEFUIModeBase.isRefMPickupPSDEViewNameDirty() && (bl || pSDEFUIModeBase.getRefMPickupPSDEViewName() != null)) {
            iDataObject.set(FIELD_REFMPICKUPPSDEVIEWNAME, (Object)pSDEFUIModeBase.getRefMPickupPSDEViewName());
        }
        if (pSDEFUIModeBase.isRefPickupPSDEViewIdDirty() && (bl || pSDEFUIModeBase.getRefPickupPSDEViewId() != null)) {
            iDataObject.set(FIELD_REFPICKUPPSDEVIEWID, (Object)pSDEFUIModeBase.getRefPickupPSDEViewId());
        }
        if (pSDEFUIModeBase.isRefPickupPSDEViewNameDirty() && (bl || pSDEFUIModeBase.getRefPickupPSDEViewName() != null)) {
            iDataObject.set(FIELD_REFPICKUPPSDEVIEWNAME, (Object)pSDEFUIModeBase.getRefPickupPSDEViewName());
        }
        if (pSDEFUIModeBase.isRefPSDEACModeIdDirty() && (bl || pSDEFUIModeBase.getRefPSDEACModeId() != null)) {
            iDataObject.set(FIELD_REFPSDEACMODEID, (Object)pSDEFUIModeBase.getRefPSDEACModeId());
        }
        if (pSDEFUIModeBase.isRefPSDEACModeNameDirty() && (bl || pSDEFUIModeBase.getRefPSDEACModeName() != null)) {
            iDataObject.set(FIELD_REFPSDEACMODENAME, (Object)pSDEFUIModeBase.getRefPSDEACModeName());
        }
        if (pSDEFUIModeBase.isRefPSDEDataSetIdDirty() && (bl || pSDEFUIModeBase.getRefPSDEDataSetId() != null)) {
            iDataObject.set(FIELD_REFPSDEDATASETID, (Object)pSDEFUIModeBase.getRefPSDEDataSetId());
        }
        if (pSDEFUIModeBase.isRefPSDEDataSetNameDirty() && (bl || pSDEFUIModeBase.getRefPSDEDataSetName() != null)) {
            iDataObject.set(FIELD_REFPSDEDATASETNAME, (Object)pSDEFUIModeBase.getRefPSDEDataSetName());
        }
        if (pSDEFUIModeBase.isRefPSDEIdDirty() && (bl || pSDEFUIModeBase.getRefPSDEId() != null)) {
            iDataObject.set(FIELD_REFPSDEID, (Object)pSDEFUIModeBase.getRefPSDEId());
        }
        if (pSDEFUIModeBase.isRefPSDENameDirty() && (bl || pSDEFUIModeBase.getRefPSDEName() != null)) {
            iDataObject.set(FIELD_REFPSDENAME, (Object)pSDEFUIModeBase.getRefPSDEName());
        }
        if (pSDEFUIModeBase.isRefPSDERIdDirty() && (bl || pSDEFUIModeBase.getRefPSDERId() != null)) {
            iDataObject.set(FIELD_REFPSDERID, (Object)pSDEFUIModeBase.getRefPSDERId());
        }
        if (pSDEFUIModeBase.isRefPSDERNameDirty() && (bl || pSDEFUIModeBase.getRefPSDERName() != null)) {
            iDataObject.set(FIELD_REFPSDERNAME, (Object)pSDEFUIModeBase.getRefPSDERName());
        }
        if (pSDEFUIModeBase.isRefTempDataDirty() && (bl || pSDEFUIModeBase.getRefTempData() != null)) {
            iDataObject.set(FIELD_REFTEMPDATA, (Object)pSDEFUIModeBase.getRefTempData());
        }
        if (pSDEFUIModeBase.isResetItemNameDirty() && (bl || pSDEFUIModeBase.getResetItemName() != null)) {
            iDataObject.set(FIELD_RESETITEMNAME, (Object)pSDEFUIModeBase.getResetItemName());
        }
        if (pSDEFUIModeBase.isStringCaseDirty() && (bl || pSDEFUIModeBase.getStringCase() != null)) {
            iDataObject.set(FIELD_STRINGCASE, (Object)pSDEFUIModeBase.getStringCase());
        }
        if (pSDEFUIModeBase.isStrLengthDirty() && (bl || pSDEFUIModeBase.getStrLength() != null)) {
            iDataObject.set(FIELD_STRLENGTH, (Object)pSDEFUIModeBase.getStrLength());
        }
        if (pSDEFUIModeBase.isUnitNameDirty() && (bl || pSDEFUIModeBase.getUnitName() != null)) {
            iDataObject.set(FIELD_UNITNAME, (Object)pSDEFUIModeBase.getUnitName());
        }
        if (pSDEFUIModeBase.isUnitNameWidthDirty() && (bl || pSDEFUIModeBase.getUnitNameWidth() != null)) {
            iDataObject.set(FIELD_UNITNAMEWIDTH, (Object)pSDEFUIModeBase.getUnitNameWidth());
        }
        if (pSDEFUIModeBase.isUpdateDateDirty() && (bl || pSDEFUIModeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEFUIModeBase.getUpdateDate());
        }
        if (pSDEFUIModeBase.isUpdateDVDirty() && (bl || pSDEFUIModeBase.getUpdateDV() != null)) {
            iDataObject.set(FIELD_UPDATEDV, (Object)pSDEFUIModeBase.getUpdateDV());
        }
        if (pSDEFUIModeBase.isUpdateDVTDirty() && (bl || pSDEFUIModeBase.getUpdateDVT() != null)) {
            iDataObject.set(FIELD_UPDATEDVT, (Object)pSDEFUIModeBase.getUpdateDVT());
        }
        if (pSDEFUIModeBase.isUpdateManDirty() && (bl || pSDEFUIModeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEFUIModeBase.getUpdateMan());
        }
        if (pSDEFUIModeBase.isUserCatDirty() && (bl || pSDEFUIModeBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEFUIModeBase.getUserCat());
        }
        if (pSDEFUIModeBase.isUserParamsDirty() && (bl || pSDEFUIModeBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSDEFUIModeBase.getUserParams());
        }
        if (pSDEFUIModeBase.isUserTagDirty() && (bl || pSDEFUIModeBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEFUIModeBase.getUserTag());
        }
        if (pSDEFUIModeBase.isUserTag2Dirty() && (bl || pSDEFUIModeBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEFUIModeBase.getUserTag2());
        }
        if (pSDEFUIModeBase.isUserTag3Dirty() && (bl || pSDEFUIModeBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEFUIModeBase.getUserTag3());
        }
        if (pSDEFUIModeBase.isUserTag4Dirty() && (bl || pSDEFUIModeBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEFUIModeBase.getUserTag4());
        }
        if (pSDEFUIModeBase.isValueFormatDirty() && (bl || pSDEFUIModeBase.getValueFormat() != null)) {
            iDataObject.set(FIELD_VALUEFORMAT, (Object)pSDEFUIModeBase.getValueFormat());
        }
        if (pSDEFUIModeBase.isValueItemNameDirty() && (bl || pSDEFUIModeBase.getValueItemName() != null)) {
            iDataObject.set(FIELD_VALUEITEMNAME, (Object)pSDEFUIModeBase.getValueItemName());
        }
        if (pSDEFUIModeBase.isWidthDirty() && (bl || pSDEFUIModeBase.getWidth() != null)) {
            iDataObject.set(FIELD_WIDTH, (Object)pSDEFUIModeBase.getWidth());
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
        return PSDEFUIModeBase.remove(this, n);
    }

    private static boolean remove(PSDEFUIModeBase pSDEFUIModeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEFUIModeBase.resetAllowEmpty();
                return true;
            }
            case 1: {
                pSDEFUIModeBase.resetCapPSLanResId();
                return true;
            }
            case 2: {
                pSDEFUIModeBase.resetCapPSLanResName();
                return true;
            }
            case 3: {
                pSDEFUIModeBase.resetCaption();
                return true;
            }
            case 4: {
                pSDEFUIModeBase.resetCodeListConfigMode();
                return true;
            }
            case 5: {
                pSDEFUIModeBase.resetCodeName();
                return true;
            }
            case 6: {
                pSDEFUIModeBase.resetConvertCIText();
                return true;
            }
            case 7: {
                pSDEFUIModeBase.resetCreateDate();
                return true;
            }
            case 8: {
                pSDEFUIModeBase.resetCreateDV();
                return true;
            }
            case 9: {
                pSDEFUIModeBase.resetCreateDVT();
                return true;
            }
            case 10: {
                pSDEFUIModeBase.resetCreateMan();
                return true;
            }
            case 11: {
                pSDEFUIModeBase.resetDynaModelFlag();
                return true;
            }
            case 12: {
                pSDEFUIModeBase.resetEditorParams();
                return true;
            }
            case 13: {
                pSDEFUIModeBase.resetEditorType();
                return true;
            }
            case 14: {
                pSDEFUIModeBase.resetEditorTypeName();
                return true;
            }
            case 15: {
                pSDEFUIModeBase.resetEnableInputTip();
                return true;
            }
            case 16: {
                pSDEFUIModeBase.resetEnableResetItemName();
                return true;
            }
            case 17: {
                pSDEFUIModeBase.resetEnableUnitName();
                return true;
            }
            case 18: {
                pSDEFUIModeBase.resetEnableValueRule();
                return true;
            }
            case 19: {
                pSDEFUIModeBase.resetFTMode();
                return true;
            }
            case 20: {
                pSDEFUIModeBase.resetGCRPSSysPFPluginId();
                return true;
            }
            case 21: {
                pSDEFUIModeBase.resetGCRPSSysPFPluginName();
                return true;
            }
            case 22: {
                pSDEFUIModeBase.resetGridColAlign();
                return true;
            }
            case 23: {
                pSDEFUIModeBase.resetGridColCLMode();
                return true;
            }
            case 24: {
                pSDEFUIModeBase.resetGridColWidth();
                return true;
            }
            case 25: {
                pSDEFUIModeBase.resetHeight();
                return true;
            }
            case 26: {
                pSDEFUIModeBase.resetIgnoreInput();
                return true;
            }
            case 27: {
                pSDEFUIModeBase.resetItemPSACHandlerId();
                return true;
            }
            case 28: {
                pSDEFUIModeBase.resetItemPSACHandlerName();
                return true;
            }
            case 29: {
                pSDEFUIModeBase.resetJSFormat();
                return true;
            }
            case 30: {
                pSDEFUIModeBase.resetLockFlag();
                return true;
            }
            case 31: {
                pSDEFUIModeBase.resetMaxValue();
                return true;
            }
            case 32: {
                pSDEFUIModeBase.resetMemo();
                return true;
            }
            case 33: {
                pSDEFUIModeBase.resetMinStrLength();
                return true;
            }
            case 34: {
                pSDEFUIModeBase.resetMinValue();
                return true;
            }
            case 35: {
                pSDEFUIModeBase.resetNeedCodeListConfig();
                return true;
            }
            case 36: {
                pSDEFUIModeBase.resetNoSort();
                return true;
            }
            case 37: {
                pSDEFUIModeBase.resetPHPSLanResId();
                return true;
            }
            case 38: {
                pSDEFUIModeBase.resetPHPSLanResName();
                return true;
            }
            case 39: {
                pSDEFUIModeBase.resetPickupTextOpts();
                return true;
            }
            case 40: {
                pSDEFUIModeBase.resetPlaceHolder();
                return true;
            }
            case 41: {
                pSDEFUIModeBase.resetPrecision2();
                return true;
            }
            case 42: {
                pSDEFUIModeBase.resetPreventXSS();
                return true;
            }
            case 43: {
                pSDEFUIModeBase.resetPSCodeListId();
                return true;
            }
            case 44: {
                pSDEFUIModeBase.resetPSCodeListName();
                return true;
            }
            case 45: {
                pSDEFUIModeBase.resetPSDEFUIModeId();
                return true;
            }
            case 46: {
                pSDEFUIModeBase.resetPSDEFUIModeName();
                return true;
            }
            case 47: {
                pSDEFUIModeBase.resetPSDEFId();
                return true;
            }
            case 48: {
                pSDEFUIModeBase.resetPSDEFInputTipId();
                return true;
            }
            case 49: {
                pSDEFUIModeBase.resetPSDEFInputTipName();
                return true;
            }
            case 50: {
                pSDEFUIModeBase.resetPSDEFName();
                return true;
            }
            case 51: {
                pSDEFUIModeBase.resetPSDEId();
                return true;
            }
            case 52: {
                pSDEFUIModeBase.resetPSDEName();
                return true;
            }
            case 53: {
                pSDEFUIModeBase.resetPSDynaInstId();
                return true;
            }
            case 54: {
                pSDEFUIModeBase.resetPSSysAppId();
                return true;
            }
            case 55: {
                pSDEFUIModeBase.resetPSSysAppName();
                return true;
            }
            case 56: {
                pSDEFUIModeBase.resetPSSysDictCatId();
                return true;
            }
            case 57: {
                pSDEFUIModeBase.resetPSSysDictCatName();
                return true;
            }
            case 58: {
                pSDEFUIModeBase.resetPSSysEditorStyleId();
                return true;
            }
            case 59: {
                pSDEFUIModeBase.resetPSSysEditorStyleName();
                return true;
            }
            case 60: {
                pSDEFUIModeBase.resetPSSysImageId();
                return true;
            }
            case 61: {
                pSDEFUIModeBase.resetPSSysImageName();
                return true;
            }
            case 62: {
                pSDEFUIModeBase.resetPSSystemId();
                return true;
            }
            case 63: {
                pSDEFUIModeBase.resetPSSysUnitId();
                return true;
            }
            case 64: {
                pSDEFUIModeBase.resetPSSysUnitName();
                return true;
            }
            case 65: {
                pSDEFUIModeBase.resetPSSysValueRuleId();
                return true;
            }
            case 66: {
                pSDEFUIModeBase.resetPSSysValueRuleName();
                return true;
            }
            case 67: {
                pSDEFUIModeBase.resetRefADPSDELogicId();
                return true;
            }
            case 68: {
                pSDEFUIModeBase.resetRefADPSDELogicName();
                return true;
            }
            case 69: {
                pSDEFUIModeBase.resetRefLinkPSDEViewId();
                return true;
            }
            case 70: {
                pSDEFUIModeBase.resetRefLinkPSDEViewName();
                return true;
            }
            case 71: {
                pSDEFUIModeBase.resetRefMPickupPSDEViewId();
                return true;
            }
            case 72: {
                pSDEFUIModeBase.resetRefMPickupPSDEViewName();
                return true;
            }
            case 73: {
                pSDEFUIModeBase.resetRefPickupPSDEViewId();
                return true;
            }
            case 74: {
                pSDEFUIModeBase.resetRefPickupPSDEViewName();
                return true;
            }
            case 75: {
                pSDEFUIModeBase.resetRefPSDEACModeId();
                return true;
            }
            case 76: {
                pSDEFUIModeBase.resetRefPSDEACModeName();
                return true;
            }
            case 77: {
                pSDEFUIModeBase.resetRefPSDEDataSetId();
                return true;
            }
            case 78: {
                pSDEFUIModeBase.resetRefPSDEDataSetName();
                return true;
            }
            case 79: {
                pSDEFUIModeBase.resetRefPSDEId();
                return true;
            }
            case 80: {
                pSDEFUIModeBase.resetRefPSDEName();
                return true;
            }
            case 81: {
                pSDEFUIModeBase.resetRefPSDERId();
                return true;
            }
            case 82: {
                pSDEFUIModeBase.resetRefPSDERName();
                return true;
            }
            case 83: {
                pSDEFUIModeBase.resetRefTempData();
                return true;
            }
            case 84: {
                pSDEFUIModeBase.resetResetItemName();
                return true;
            }
            case 85: {
                pSDEFUIModeBase.resetStringCase();
                return true;
            }
            case 86: {
                pSDEFUIModeBase.resetStrLength();
                return true;
            }
            case 87: {
                pSDEFUIModeBase.resetUnitName();
                return true;
            }
            case 88: {
                pSDEFUIModeBase.resetUnitNameWidth();
                return true;
            }
            case 89: {
                pSDEFUIModeBase.resetUpdateDate();
                return true;
            }
            case 90: {
                pSDEFUIModeBase.resetUpdateDV();
                return true;
            }
            case 91: {
                pSDEFUIModeBase.resetUpdateDVT();
                return true;
            }
            case 92: {
                pSDEFUIModeBase.resetUpdateMan();
                return true;
            }
            case 93: {
                pSDEFUIModeBase.resetUserCat();
                return true;
            }
            case 94: {
                pSDEFUIModeBase.resetUserParams();
                return true;
            }
            case 95: {
                pSDEFUIModeBase.resetUserTag();
                return true;
            }
            case 96: {
                pSDEFUIModeBase.resetUserTag2();
                return true;
            }
            case 97: {
                pSDEFUIModeBase.resetUserTag3();
                return true;
            }
            case 98: {
                pSDEFUIModeBase.resetUserTag4();
                return true;
            }
            case 99: {
                pSDEFUIModeBase.resetValueFormat();
                return true;
            }
            case 100: {
                pSDEFUIModeBase.resetValueItemName();
                return true;
            }
            case 101: {
                pSDEFUIModeBase.resetWidth();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSACHandler getItemPSACHandler() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemPSACHandler();
        }
        if (this.getItemPSACHandlerId() == null) {
            return null;
        }
        Integer n = this.objItemPSACHandlerLock;
        synchronized (n) {
            if (this.itempsachandler != null && DataTypeHelper.compare((int)25, (Object)this.getItemPSACHandlerId(), (Object)this.itempsachandler.getPSACHandlerId()) != 0L) {
                this.itempsachandler = null;
            }
            if (this.itempsachandler == null) {
                PSACHandler pSACHandler = new PSACHandler();
                pSACHandler.setPSACHandlerId(this.getItemPSACHandlerId());
                PSACHandlerService pSACHandlerService = (PSACHandlerService)ServiceGlobal.getService(PSACHandlerService.class, (SessionFactory)this.getSessionFactory());
                pSACHandlerService.autoGet((IEntity)pSACHandler);
                this.itempsachandler = pSACHandler;
            }
            return this.itempsachandler;
        }
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
    public PSDEFInputTip getPSDEFInputTip() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFInputTip();
        }
        if (this.getPSDEFInputTipId() == null) {
            return null;
        }
        Integer n = this.objPSDEFInputTipLock;
        synchronized (n) {
            if (this.psdefinputtip != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFInputTipId(), (Object)this.psdefinputtip.getPSDEFInputTipId()) != 0L) {
                this.psdefinputtip = null;
            }
            if (this.psdefinputtip == null) {
                PSDEFInputTip pSDEFInputTip = new PSDEFInputTip();
                pSDEFInputTip.setPSDEFInputTipId(this.getPSDEFInputTipId());
                PSDEFInputTipService pSDEFInputTipService = (PSDEFInputTipService)ServiceGlobal.getService(PSDEFInputTipService.class, (SessionFactory)this.getSessionFactory());
                pSDEFInputTipService.autoGet((IEntity)pSDEFInputTip);
                this.psdefinputtip = pSDEFInputTip;
            }
            return this.psdefinputtip;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDELogic getRefADPSDELogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefADPSDELogic();
        }
        if (this.getRefADPSDELogicId() == null) {
            return null;
        }
        Integer n = this.objRefADPSDELogicLock;
        synchronized (n) {
            if (this.refadpsdelogic != null && DataTypeHelper.compare((int)25, (Object)this.getRefADPSDELogicId(), (Object)this.refadpsdelogic.getPSDELogicId()) != 0L) {
                this.refadpsdelogic = null;
            }
            if (this.refadpsdelogic == null) {
                PSDELogic pSDELogic = new PSDELogic();
                pSDELogic.setPSDELogicId(this.getRefADPSDELogicId());
                PSDELogicService pSDELogicService = (PSDELogicService)ServiceGlobal.getService(PSDELogicService.class, (SessionFactory)this.getSessionFactory());
                pSDELogicService.autoGet((IEntity)pSDELogic);
                this.refadpsdelogic = pSDELogic;
            }
            return this.refadpsdelogic;
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
                pSDERService.autoGet((IEntity)pSDER);
                this.refpsder = pSDER;
            }
            return this.refpsder;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getRefLinkPSDEView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefLinkPSDEView();
        }
        if (this.getRefLinkPSDEViewId() == null) {
            return null;
        }
        Integer n = this.objRefLinkPSDEViewLock;
        synchronized (n) {
            if (this.reflinkpsdeview != null && DataTypeHelper.compare((int)25, (Object)this.getRefLinkPSDEViewId(), (Object)this.reflinkpsdeview.getPSDEViewBaseId()) != 0L) {
                this.reflinkpsdeview = null;
            }
            if (this.reflinkpsdeview == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getRefLinkPSDEViewId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet((IEntity)pSDEViewBase);
                this.reflinkpsdeview = pSDEViewBase;
            }
            return this.reflinkpsdeview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getRefMPickupPSDEView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefMPickupPSDEView();
        }
        if (this.getRefMPickupPSDEViewId() == null) {
            return null;
        }
        Integer n = this.objRefMPickupPSDEViewLock;
        synchronized (n) {
            if (this.refmpickuppsdeview != null && DataTypeHelper.compare((int)25, (Object)this.getRefMPickupPSDEViewId(), (Object)this.refmpickuppsdeview.getPSDEViewBaseId()) != 0L) {
                this.refmpickuppsdeview = null;
            }
            if (this.refmpickuppsdeview == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getRefMPickupPSDEViewId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet((IEntity)pSDEViewBase);
                this.refmpickuppsdeview = pSDEViewBase;
            }
            return this.refmpickuppsdeview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getRefPickupPSDEView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPickupPSDEView();
        }
        if (this.getRefPickupPSDEViewId() == null) {
            return null;
        }
        Integer n = this.objRefPickupPSDEViewLock;
        synchronized (n) {
            if (this.refpickuppsdeview != null && DataTypeHelper.compare((int)25, (Object)this.getRefPickupPSDEViewId(), (Object)this.refpickuppsdeview.getPSDEViewBaseId()) != 0L) {
                this.refpickuppsdeview = null;
            }
            if (this.refpickuppsdeview == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getRefPickupPSDEViewId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet((IEntity)pSDEViewBase);
                this.refpickuppsdeview = pSDEViewBase;
            }
            return this.refpickuppsdeview;
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
    public PSSysApp getPSSysApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysApp();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        Integer n = this.objPSSysAppLock;
        synchronized (n) {
            if (this.pssysapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysAppId(), (Object)this.pssysapp.getPSSysAppId()) != 0L) {
                this.pssysapp = null;
            }
            if (this.pssysapp == null) {
                PSSysApp pSSysApp = new PSSysApp();
                pSSysApp.setPSSysAppId(this.getPSSysAppId());
                PSSysAppService pSSysAppService = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)this.getSessionFactory());
                pSSysAppService.autoGet((IEntity)pSSysApp);
                this.pssysapp = pSSysApp;
            }
            return this.pssysapp;
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysUnit getPSSysUnit() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUnit();
        }
        if (this.getPSSysUnitId() == null) {
            return null;
        }
        Integer n = this.objPSSysUnitLock;
        synchronized (n) {
            if (this.pssysunit != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysUnitId(), (Object)this.pssysunit.getPSSysUnitId()) != 0L) {
                this.pssysunit = null;
            }
            if (this.pssysunit == null) {
                PSSysUnit pSSysUnit = new PSSysUnit();
                pSSysUnit.setPSSysUnitId(this.getPSSysUnitId());
                PSSysUnitService pSSysUnitService = (PSSysUnitService)ServiceGlobal.getService(PSSysUnitService.class, (SessionFactory)this.getSessionFactory());
                pSSysUnitService.autoGet((IEntity)pSSysUnit);
                this.pssysunit = pSSysUnit;
            }
            return this.pssysunit;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysValueRule getPSSysValueRule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysValueRule();
        }
        if (this.getPSSysValueRuleId() == null) {
            return null;
        }
        Integer n = this.objPSSysValueRuleLock;
        synchronized (n) {
            if (this.pssysvaluerule != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysValueRuleId(), (Object)this.pssysvaluerule.getPSSysValueRuleId()) != 0L) {
                this.pssysvaluerule = null;
            }
            if (this.pssysvaluerule == null) {
                PSSysValueRule pSSysValueRule = new PSSysValueRule();
                pSSysValueRule.setPSSysValueRuleId(this.getPSSysValueRuleId());
                PSSysValueRuleService pSSysValueRuleService = (PSSysValueRuleService)ServiceGlobal.getService(PSSysValueRuleService.class, (SessionFactory)this.getSessionFactory());
                pSSysValueRuleService.autoGet((IEntity)pSSysValueRule);
                this.pssysvaluerule = pSSysValueRule;
            }
            return this.pssysvaluerule;
        }
    }

    private PSDEFUIModeBase getProxyEntity() {
        return this.proxyPSDEFUIModeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEFUIModeBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEFUIModeBase) {
            this.proxyPSDEFUIModeBase = (PSDEFUIModeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFUIModeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLOWEMPTY, 0);
        fieldIndexMap.put(FIELD_CAPPSLANRESID, 1);
        fieldIndexMap.put(FIELD_CAPPSLANRESNAME, 2);
        fieldIndexMap.put(FIELD_CAPTION, 3);
        fieldIndexMap.put(FIELD_CODELISTCONFIGMODE, 4);
        fieldIndexMap.put(FIELD_CODENAME, 5);
        fieldIndexMap.put(FIELD_CONVERTCITEXT, 6);
        fieldIndexMap.put(FIELD_CREATEDATE, 7);
        fieldIndexMap.put(FIELD_CREATEDV, 8);
        fieldIndexMap.put(FIELD_CREATEDVT, 9);
        fieldIndexMap.put(FIELD_CREATEMAN, 10);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 11);
        fieldIndexMap.put(FIELD_EDITORPARAMS, 12);
        fieldIndexMap.put(FIELD_EDITORTYPE, 13);
        fieldIndexMap.put(FIELD_EDITORTYPENAME, 14);
        fieldIndexMap.put(FIELD_ENABLEINPUTTIP, 15);
        fieldIndexMap.put(FIELD_ENABLERESETITEMNAME, 16);
        fieldIndexMap.put(FIELD_ENABLEUNITNAME, 17);
        fieldIndexMap.put(FIELD_ENABLEVALUERULE, 18);
        fieldIndexMap.put(FIELD_FTMODE, 19);
        fieldIndexMap.put(FIELD_GCRPSSYSPFPLUGINID, 20);
        fieldIndexMap.put(FIELD_GCRPSSYSPFPLUGINNAME, 21);
        fieldIndexMap.put(FIELD_GRIDCOLALIGN, 22);
        fieldIndexMap.put(FIELD_GRIDCOLCLMODE, 23);
        fieldIndexMap.put(FIELD_GRIDCOLWIDTH, 24);
        fieldIndexMap.put(FIELD_HEIGHT, 25);
        fieldIndexMap.put(FIELD_IGNOREINPUT, 26);
        fieldIndexMap.put(FIELD_ITEMPSACHANDLERID, 27);
        fieldIndexMap.put(FIELD_ITEMPSACHANDLERNAME, 28);
        fieldIndexMap.put(FIELD_JSFORMAT, 29);
        fieldIndexMap.put(FIELD_LOCKFLAG, 30);
        fieldIndexMap.put(FIELD_MAXVALUE, 31);
        fieldIndexMap.put(FIELD_MEMO, 32);
        fieldIndexMap.put(FIELD_MINSTRLENGTH, 33);
        fieldIndexMap.put(FIELD_MINVALUE, 34);
        fieldIndexMap.put(FIELD_NEEDCODELISTCONFIG, 35);
        fieldIndexMap.put(FIELD_NOSORT, 36);
        fieldIndexMap.put(FIELD_PHPSLANRESID, 37);
        fieldIndexMap.put(FIELD_PHPSLANRESNAME, 38);
        fieldIndexMap.put(FIELD_PICKUPTEXTOPTS, 39);
        fieldIndexMap.put(FIELD_PLACEHOLDER, 40);
        fieldIndexMap.put(FIELD_PRECISION2, 41);
        fieldIndexMap.put(FIELD_PREVENTXSS, 42);
        fieldIndexMap.put(FIELD_PSCODELISTID, 43);
        fieldIndexMap.put(FIELD_PSCODELISTNAME, 44);
        fieldIndexMap.put(FIELD_PSDEFUIMODEID, 45);
        fieldIndexMap.put(FIELD_PSDEFUIMODENAME, 46);
        fieldIndexMap.put(FIELD_PSDEFID, 47);
        fieldIndexMap.put(FIELD_PSDEFINPUTTIPID, 48);
        fieldIndexMap.put(FIELD_PSDEFINPUTTIPNAME, 49);
        fieldIndexMap.put(FIELD_PSDEFNAME, 50);
        fieldIndexMap.put(FIELD_PSDEID, 51);
        fieldIndexMap.put(FIELD_PSDENAME, 52);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 53);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 54);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 55);
        fieldIndexMap.put(FIELD_PSSYSDICTCATID, 56);
        fieldIndexMap.put(FIELD_PSSYSDICTCATNAME, 57);
        fieldIndexMap.put(FIELD_PSSYSEDITORSTYLEID, 58);
        fieldIndexMap.put(FIELD_PSSYSEDITORSTYLENAME, 59);
        fieldIndexMap.put(FIELD_PSSYSIMAGEID, 60);
        fieldIndexMap.put(FIELD_PSSYSIMAGENAME, 61);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 62);
        fieldIndexMap.put(FIELD_PSSYSUNITID, 63);
        fieldIndexMap.put(FIELD_PSSYSUNITNAME, 64);
        fieldIndexMap.put(FIELD_PSSYSVALUERULEID, 65);
        fieldIndexMap.put(FIELD_PSSYSVALUERULENAME, 66);
        fieldIndexMap.put(FIELD_REFADPSDELOGICID, 67);
        fieldIndexMap.put(FIELD_REFADPSDELOGICNAME, 68);
        fieldIndexMap.put(FIELD_REFLINKPSDEVIEWID, 69);
        fieldIndexMap.put(FIELD_REFLINKPSDEVIEWNAME, 70);
        fieldIndexMap.put(FIELD_REFMPICKUPPSDEVIEWID, 71);
        fieldIndexMap.put(FIELD_REFMPICKUPPSDEVIEWNAME, 72);
        fieldIndexMap.put(FIELD_REFPICKUPPSDEVIEWID, 73);
        fieldIndexMap.put(FIELD_REFPICKUPPSDEVIEWNAME, 74);
        fieldIndexMap.put(FIELD_REFPSDEACMODEID, 75);
        fieldIndexMap.put(FIELD_REFPSDEACMODENAME, 76);
        fieldIndexMap.put(FIELD_REFPSDEDATASETID, 77);
        fieldIndexMap.put(FIELD_REFPSDEDATASETNAME, 78);
        fieldIndexMap.put(FIELD_REFPSDEID, 79);
        fieldIndexMap.put(FIELD_REFPSDENAME, 80);
        fieldIndexMap.put(FIELD_REFPSDERID, 81);
        fieldIndexMap.put(FIELD_REFPSDERNAME, 82);
        fieldIndexMap.put(FIELD_REFTEMPDATA, 83);
        fieldIndexMap.put(FIELD_RESETITEMNAME, 84);
        fieldIndexMap.put(FIELD_STRINGCASE, 85);
        fieldIndexMap.put(FIELD_STRLENGTH, 86);
        fieldIndexMap.put(FIELD_UNITNAME, 87);
        fieldIndexMap.put(FIELD_UNITNAMEWIDTH, 88);
        fieldIndexMap.put(FIELD_UPDATEDATE, 89);
        fieldIndexMap.put(FIELD_UPDATEDV, 90);
        fieldIndexMap.put(FIELD_UPDATEDVT, 91);
        fieldIndexMap.put(FIELD_UPDATEMAN, 92);
        fieldIndexMap.put(FIELD_USERCAT, 93);
        fieldIndexMap.put(FIELD_USERPARAMS, 94);
        fieldIndexMap.put(FIELD_USERTAG, 95);
        fieldIndexMap.put(FIELD_USERTAG2, 96);
        fieldIndexMap.put(FIELD_USERTAG3, 97);
        fieldIndexMap.put(FIELD_USERTAG4, 98);
        fieldIndexMap.put(FIELD_VALUEFORMAT, 99);
        fieldIndexMap.put(FIELD_VALUEITEMNAME, 100);
        fieldIndexMap.put(FIELD_WIDTH, 101);
    }
}

