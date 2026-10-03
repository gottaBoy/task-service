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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEChart;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEChartAxes;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartAxesService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEChartParamBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEChartParamBase.class);
    public static final String FIELD_BARCATEGORYGAP = "BARCATEGORYGAP";
    public static final String FIELD_BARGAP = "BARGAP";
    public static final String FIELD_BARMAXWIDTH = "BARMAXWIDTH";
    public static final String FIELD_BARMINHEIGHT = "BARMINHEIGHT";
    public static final String FIELD_BARMINWIDTH = "BARMINWIDTH";
    public static final String FIELD_BARWIDTH = "BARWIDTH";
    public static final String FIELD_BOTTOMPOS = "BOTTOMPOS";
    public static final String FIELD_BOXWIDTHS = "BOXWIDTHS";
    public static final String FIELD_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String FIELD_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String FIELD_CAPTION = "CAPTION";
    public static final String FIELD_CENTER = "CENTER";
    public static final String FIELD_CHARTTYPE = "CHARTTYPE";
    public static final String FIELD_CLOCKWISE = "CLOCKWISE";
    public static final String FIELD_COORDINATESYSTEM = "COORDINATESYSTEM";
    public static final String FIELD_COORDINATESYSTEMID = "COORDINATESYSTEMID";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CSPSSYSDYNAMODELID = "CSPSSYSDYNAMODELID";
    public static final String FIELD_CSPSSYSDYNAMODELNAME = "CSPSSYSDYNAMODELNAME";
    public static final String FIELD_CSPSSYSPFPLUGINID = "CSPSSYSPFPLUGINID";
    public static final String FIELD_CSPSSYSPFPLUGINNAME = "CSPSSYSPFPLUGINNAME";
    public static final String FIELD_DATAFIELD = "DATAFIELD";
    public static final String FIELD_DYNACLASS = "DYNACLASS";
    public static final String FIELD_ENDANGLE = "ENDANGLE";
    public static final String FIELD_EXTFIELD = "EXTFIELD";
    public static final String FIELD_EXTFIELD2 = "EXTFIELD2";
    public static final String FIELD_EXTFIELD3 = "EXTFIELD3";
    public static final String FIELD_EXTFIELD4 = "EXTFIELD4";
    public static final String FIELD_FUNNELALIGN = "FUNNELALIGN";
    public static final String FIELD_HEIGHT = "HEIGHT";
    public static final String FIELD_LEFTPOS = "LEFTPOS";
    public static final String FIELD_MAPTYPE = "MAPTYPE";
    public static final String FIELD_MAXSIZE = "MAXSIZE";
    public static final String FIELD_MAXVALUE = "MAXVALUE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MINANGLE = "MINANGLE";
    public static final String FIELD_MINSHOWLABELANGLE = "MINSHOWLABELANGLE";
    public static final String FIELD_MINSIZE = "MINSIZE";
    public static final String FIELD_MINVALUE = "MINVALUE";
    public static final String FIELD_NAVVIEWFILTER = "NAVVIEWFILTER";
    public static final String FIELD_NAVVIEWPARAM = "NAVVIEWPARAM";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDECHARTID = "PSDECHARTID";
    public static final String FIELD_PSDECHARTNAME = "PSDECHARTNAME";
    public static final String FIELD_PSDECHARTPARAMID = "PSDECHARTPARAMID";
    public static final String FIELD_PSDECHARTPARAMNAME = "PSDECHARTPARAMNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDERID = "PSDERID";
    public static final String FIELD_PSDERNAME = "PSDERNAME";
    public static final String FIELD_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String FIELD_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_RADIUS = "RADIUS";
    public static final String FIELD_RIGHTPOS = "RIGHTPOS";
    public static final String FIELD_ROSETYPE = "ROSETYPE";
    public static final String FIELD_SAMPLEDATA = "SAMPLEDATA";
    public static final String FIELD_SERIESFIELD = "SERIESFIELD";
    public static final String FIELD_SERIESLAYOUTBY = "SERIESLAYOUTBY";
    public static final String FIELD_SERIESPARAM = "SERIESPARAM";
    public static final String FIELD_SERIESPARAM10 = "SERIESPARAM10";
    public static final String FIELD_SERIESPARAM11 = "SERIESPARAM11";
    public static final String FIELD_SERIESPARAM12 = "SERIESPARAM12";
    public static final String FIELD_SERIESPARAM2 = "SERIESPARAM2";
    public static final String FIELD_SERIESPARAM3 = "SERIESPARAM3";
    public static final String FIELD_SERIESPARAM4 = "SERIESPARAM4";
    public static final String FIELD_SERIESPARAM5 = "SERIESPARAM5";
    public static final String FIELD_SERIESPARAM6 = "SERIESPARAM6";
    public static final String FIELD_SERIESPARAM7 = "SERIESPARAM7";
    public static final String FIELD_SERIESPARAM8 = "SERIESPARAM8";
    public static final String FIELD_SERIESPARAM9 = "SERIESPARAM9";
    public static final String FIELD_SFPSCODELISTID = "SFPSCODELISTID";
    public static final String FIELD_SFPSCODELISTNAME = "SFPSCODELISTNAME";
    public static final String FIELD_SORTDIR = "SORTDIR";
    public static final String FIELD_SPLITNUMBER = "SPLITNUMBER";
    public static final String FIELD_STACK = "STACK";
    public static final String FIELD_STARTANGLE = "STARTANGLE";
    public static final String FIELD_STEP = "STEP";
    public static final String FIELD_TAGFIELD = "TAGFIELD";
    public static final String FIELD_TIMEGROUP = "TIMEGROUP";
    public static final String FIELD_TOPPOS = "TOPPOS";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_WIDTH = "WIDTH";
    public static final String FIELD_XFIELD = "XFIELD";
    public static final String FIELD_XFPSCODELISTID = "XFPSCODELISTID";
    public static final String FIELD_XFPSCODELISTNAME = "XFPSCODELISTNAME";
    public static final String FIELD_XPSDECHARTAXESID = "XPSDECHARTAXESID";
    public static final String FIELD_XPSDECHARTAXESNAME = "XPSDECHARTAXESNAME";
    public static final String FIELD_YFIELD = "YFIELD";
    public static final String FIELD_YPSDECHARTAXESID = "YPSDECHARTAXESID";
    public static final String FIELD_YPSDECHARTAXESNAME = "YPSDECHARTAXESNAME";
    public static final String FIELD_ZFIELD = "ZFIELD";
    private static final int INDEX_BARCATEGORYGAP = 0;
    private static final int INDEX_BARGAP = 1;
    private static final int INDEX_BARMAXWIDTH = 2;
    private static final int INDEX_BARMINHEIGHT = 3;
    private static final int INDEX_BARMINWIDTH = 4;
    private static final int INDEX_BARWIDTH = 5;
    private static final int INDEX_BOTTOMPOS = 6;
    private static final int INDEX_BOXWIDTHS = 7;
    private static final int INDEX_CAPPSLANRESID = 8;
    private static final int INDEX_CAPPSLANRESNAME = 9;
    private static final int INDEX_CAPTION = 10;
    private static final int INDEX_CENTER = 11;
    private static final int INDEX_CHARTTYPE = 12;
    private static final int INDEX_CLOCKWISE = 13;
    private static final int INDEX_COORDINATESYSTEM = 14;
    private static final int INDEX_COORDINATESYSTEMID = 15;
    private static final int INDEX_CREATEDATE = 16;
    private static final int INDEX_CREATEMAN = 17;
    private static final int INDEX_CSPSSYSDYNAMODELID = 18;
    private static final int INDEX_CSPSSYSDYNAMODELNAME = 19;
    private static final int INDEX_CSPSSYSPFPLUGINID = 20;
    private static final int INDEX_CSPSSYSPFPLUGINNAME = 21;
    private static final int INDEX_DATAFIELD = 22;
    private static final int INDEX_DYNACLASS = 23;
    private static final int INDEX_ENDANGLE = 24;
    private static final int INDEX_EXTFIELD = 25;
    private static final int INDEX_EXTFIELD2 = 26;
    private static final int INDEX_EXTFIELD3 = 27;
    private static final int INDEX_EXTFIELD4 = 28;
    private static final int INDEX_FUNNELALIGN = 29;
    private static final int INDEX_HEIGHT = 30;
    private static final int INDEX_LEFTPOS = 31;
    private static final int INDEX_MAPTYPE = 32;
    private static final int INDEX_MAXSIZE = 33;
    private static final int INDEX_MAXVALUE = 34;
    private static final int INDEX_MEMO = 35;
    private static final int INDEX_MINANGLE = 36;
    private static final int INDEX_MINSHOWLABELANGLE = 37;
    private static final int INDEX_MINSIZE = 38;
    private static final int INDEX_MINVALUE = 39;
    private static final int INDEX_NAVVIEWFILTER = 40;
    private static final int INDEX_NAVVIEWPARAM = 41;
    private static final int INDEX_ORDERVALUE = 42;
    private static final int INDEX_PSDECHARTID = 43;
    private static final int INDEX_PSDECHARTNAME = 44;
    private static final int INDEX_PSDECHARTPARAMID = 45;
    private static final int INDEX_PSDECHARTPARAMNAME = 46;
    private static final int INDEX_PSDEID = 47;
    private static final int INDEX_PSDERID = 48;
    private static final int INDEX_PSDERNAME = 49;
    private static final int INDEX_PSDEVIEWBASEID = 50;
    private static final int INDEX_PSDEVIEWBASENAME = 51;
    private static final int INDEX_PSSYSDYNAMODELID = 52;
    private static final int INDEX_PSSYSDYNAMODELNAME = 53;
    private static final int INDEX_PSSYSPFPLUGINID = 54;
    private static final int INDEX_PSSYSPFPLUGINNAME = 55;
    private static final int INDEX_RADIUS = 56;
    private static final int INDEX_RIGHTPOS = 57;
    private static final int INDEX_ROSETYPE = 58;
    private static final int INDEX_SAMPLEDATA = 59;
    private static final int INDEX_SERIESFIELD = 60;
    private static final int INDEX_SERIESLAYOUTBY = 61;
    private static final int INDEX_SERIESPARAM = 62;
    private static final int INDEX_SERIESPARAM10 = 63;
    private static final int INDEX_SERIESPARAM11 = 64;
    private static final int INDEX_SERIESPARAM12 = 65;
    private static final int INDEX_SERIESPARAM2 = 66;
    private static final int INDEX_SERIESPARAM3 = 67;
    private static final int INDEX_SERIESPARAM4 = 68;
    private static final int INDEX_SERIESPARAM5 = 69;
    private static final int INDEX_SERIESPARAM6 = 70;
    private static final int INDEX_SERIESPARAM7 = 71;
    private static final int INDEX_SERIESPARAM8 = 72;
    private static final int INDEX_SERIESPARAM9 = 73;
    private static final int INDEX_SFPSCODELISTID = 74;
    private static final int INDEX_SFPSCODELISTNAME = 75;
    private static final int INDEX_SORTDIR = 76;
    private static final int INDEX_SPLITNUMBER = 77;
    private static final int INDEX_STACK = 78;
    private static final int INDEX_STARTANGLE = 79;
    private static final int INDEX_STEP = 80;
    private static final int INDEX_TAGFIELD = 81;
    private static final int INDEX_TIMEGROUP = 82;
    private static final int INDEX_TOPPOS = 83;
    private static final int INDEX_UPDATEDATE = 84;
    private static final int INDEX_UPDATEMAN = 85;
    private static final int INDEX_USERCAT = 86;
    private static final int INDEX_USERPARAMS = 87;
    private static final int INDEX_USERTAG = 88;
    private static final int INDEX_USERTAG2 = 89;
    private static final int INDEX_USERTAG3 = 90;
    private static final int INDEX_USERTAG4 = 91;
    private static final int INDEX_WIDTH = 92;
    private static final int INDEX_XFIELD = 93;
    private static final int INDEX_XFPSCODELISTID = 94;
    private static final int INDEX_XFPSCODELISTNAME = 95;
    private static final int INDEX_XPSDECHARTAXESID = 96;
    private static final int INDEX_XPSDECHARTAXESNAME = 97;
    private static final int INDEX_YFIELD = 98;
    private static final int INDEX_YPSDECHARTAXESID = 99;
    private static final int INDEX_YPSDECHARTAXESNAME = 100;
    private static final int INDEX_ZFIELD = 101;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEChartParamBase proxyPSDEChartParamBase = null;
    private boolean barcategorygapDirtyFlag = false;
    private boolean bargapDirtyFlag = false;
    private boolean barmaxwidthDirtyFlag = false;
    private boolean barminheightDirtyFlag = false;
    private boolean barminwidthDirtyFlag = false;
    private boolean barwidthDirtyFlag = false;
    private boolean bottomposDirtyFlag = false;
    private boolean boxwidthsDirtyFlag = false;
    private boolean cappslanresidDirtyFlag = false;
    private boolean cappslanresnameDirtyFlag = false;
    private boolean captionDirtyFlag = false;
    private boolean centerDirtyFlag = false;
    private boolean charttypeDirtyFlag = false;
    private boolean clockwiseDirtyFlag = false;
    private boolean coordinatesystemDirtyFlag = false;
    private boolean coordinatesystemidDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean cspssysdynamodelidDirtyFlag = false;
    private boolean cspssysdynamodelnameDirtyFlag = false;
    private boolean cspssyspfpluginidDirtyFlag = false;
    private boolean cspssyspfpluginnameDirtyFlag = false;
    private boolean datafieldDirtyFlag = false;
    private boolean dynaclassDirtyFlag = false;
    private boolean endangleDirtyFlag = false;
    private boolean extfieldDirtyFlag = false;
    private boolean extfield2DirtyFlag = false;
    private boolean extfield3DirtyFlag = false;
    private boolean extfield4DirtyFlag = false;
    private boolean funnelalignDirtyFlag = false;
    private boolean heightDirtyFlag = false;
    private boolean leftposDirtyFlag = false;
    private boolean maptypeDirtyFlag = false;
    private boolean maxsizeDirtyFlag = false;
    private boolean maxvalueDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean minangleDirtyFlag = false;
    private boolean minshowlabelangleDirtyFlag = false;
    private boolean minsizeDirtyFlag = false;
    private boolean minvalueDirtyFlag = false;
    private boolean navviewfilterDirtyFlag = false;
    private boolean navviewparamDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdechartidDirtyFlag = false;
    private boolean psdechartnameDirtyFlag = false;
    private boolean psdechartparamidDirtyFlag = false;
    private boolean psdechartparamnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psderidDirtyFlag = false;
    private boolean psdernameDirtyFlag = false;
    private boolean psdeviewbaseidDirtyFlag = false;
    private boolean psdeviewbasenameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean radiusDirtyFlag = false;
    private boolean rightposDirtyFlag = false;
    private boolean rosetypeDirtyFlag = false;
    private boolean sampledataDirtyFlag = false;
    private boolean seriesfieldDirtyFlag = false;
    private boolean serieslayoutbyDirtyFlag = false;
    private boolean seriesparamDirtyFlag = false;
    private boolean seriesparam10DirtyFlag = false;
    private boolean seriesparam11DirtyFlag = false;
    private boolean seriesparam12DirtyFlag = false;
    private boolean seriesparam2DirtyFlag = false;
    private boolean seriesparam3DirtyFlag = false;
    private boolean seriesparam4DirtyFlag = false;
    private boolean seriesparam5DirtyFlag = false;
    private boolean seriesparam6DirtyFlag = false;
    private boolean seriesparam7DirtyFlag = false;
    private boolean seriesparam8DirtyFlag = false;
    private boolean seriesparam9DirtyFlag = false;
    private boolean sfpscodelistidDirtyFlag = false;
    private boolean sfpscodelistnameDirtyFlag = false;
    private boolean sortdirDirtyFlag = false;
    private boolean splitnumberDirtyFlag = false;
    private boolean stackDirtyFlag = false;
    private boolean startangleDirtyFlag = false;
    private boolean stepDirtyFlag = false;
    private boolean tagfieldDirtyFlag = false;
    private boolean timegroupDirtyFlag = false;
    private boolean topposDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean widthDirtyFlag = false;
    private boolean xfieldDirtyFlag = false;
    private boolean xfpscodelistidDirtyFlag = false;
    private boolean xfpscodelistnameDirtyFlag = false;
    private boolean xpsdechartaxesidDirtyFlag = false;
    private boolean xpsdechartaxesnameDirtyFlag = false;
    private boolean yfieldDirtyFlag = false;
    private boolean ypsdechartaxesidDirtyFlag = false;
    private boolean ypsdechartaxesnameDirtyFlag = false;
    private boolean zfieldDirtyFlag = false;
    @Column(name="barcategorygap")
    private String barcategorygap;
    @Column(name="bargap")
    private String bargap;
    @Column(name="barmaxwidth")
    private String barmaxwidth;
    @Column(name="barminheight")
    private String barminheight;
    @Column(name="barminwidth")
    private String barminwidth;
    @Column(name="barwidth")
    private String barwidth;
    @Column(name="bottompos")
    private String bottompos;
    @Column(name="boxwidths")
    private String boxwidths;
    @Column(name="cappslanresid")
    private String cappslanresid;
    @Column(name="cappslanresname")
    private String cappslanresname;
    @Column(name="caption")
    private String caption;
    @Column(name="center")
    private String center;
    @Column(name="charttype")
    private String charttype;
    @Column(name="clockwise")
    private Integer clockwise;
    @Column(name="coordinatesystem")
    private String coordinatesystem;
    @Column(name="coordinatesystemid")
    private Integer coordinatesystemid;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="cspssysdynamodelid")
    private String cspssysdynamodelid;
    @Column(name="cspssysdynamodelname")
    private String cspssysdynamodelname;
    @Column(name="cspssyspfpluginid")
    private String cspssyspfpluginid;
    @Column(name="cspssyspfpluginname")
    private String cspssyspfpluginname;
    @Column(name="datafield")
    private String datafield;
    @Column(name="dynaclass")
    private String dynaclass;
    @Column(name="endangle")
    private Integer endangle;
    @Column(name="extfield")
    private String extfield;
    @Column(name="extfield2")
    private String extfield2;
    @Column(name="extfield3")
    private String extfield3;
    @Column(name="extfield4")
    private String extfield4;
    @Column(name="funnelalign")
    private String funnelalign;
    @Column(name="height")
    private String height;
    @Column(name="leftpos")
    private String leftpos;
    @Column(name="maptype")
    private String maptype;
    @Column(name="maxsize")
    private String maxsize;
    @Column(name="maxvalue")
    private Integer maxvalue;
    @Column(name="memo")
    private String memo;
    @Column(name="minangle")
    private Integer minangle;
    @Column(name="minshowlabelangle")
    private Integer minshowlabelangle;
    @Column(name="minsize")
    private String minsize;
    @Column(name="minvalue")
    private Integer minvalue;
    @Column(name="navviewfilter")
    private String navviewfilter;
    @Column(name="navviewparam")
    private String navviewparam;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdechartid")
    private String psdechartid;
    @Column(name="psdechartname")
    private String psdechartname;
    @Column(name="psdechartparamid")
    private String psdechartparamid;
    @Column(name="psdechartparamname")
    private String psdechartparamname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psderid")
    private String psderid;
    @Column(name="psdername")
    private String psdername;
    @Column(name="psdeviewbaseid")
    private String psdeviewbaseid;
    @Column(name="psdeviewbasename")
    private String psdeviewbasename;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssyspfpluginid")
    private String pssyspfpluginid;
    @Column(name="pssyspfpluginname")
    private String pssyspfpluginname;
    @Column(name="radius")
    private String radius;
    @Column(name="rightpos")
    private String rightpos;
    @Column(name="rosetype")
    private String rosetype;
    @Column(name="sampledata")
    private String sampledata;
    @Column(name="seriesfield")
    private String seriesfield;
    @Column(name="serieslayoutby")
    private String serieslayoutby;
    @Column(name="seriesparam")
    private String seriesparam;
    @Column(name="seriesparam10")
    private Double seriesparam10;
    @Column(name="seriesparam11")
    private Integer seriesparam11;
    @Column(name="seriesparam12")
    private Integer seriesparam12;
    @Column(name="seriesparam2")
    private String seriesparam2;
    @Column(name="seriesparam3")
    private String seriesparam3;
    @Column(name="seriesparam4")
    private String seriesparam4;
    @Column(name="seriesparam5")
    private Integer seriesparam5;
    @Column(name="seriesparam6")
    private Integer seriesparam6;
    @Column(name="seriesparam7")
    private Integer seriesparam7;
    @Column(name="seriesparam8")
    private Integer seriesparam8;
    @Column(name="seriesparam9")
    private Double seriesparam9;
    @Column(name="sfpscodelistid")
    private String sfpscodelistid;
    @Column(name="sfpscodelistname")
    private String sfpscodelistname;
    @Column(name="sortdir")
    private String sortdir;
    @Column(name="splitnumber")
    private Integer splitnumber;
    @Column(name="stack")
    private Integer stack;
    @Column(name="startangle")
    private Integer startangle;
    @Column(name="step")
    private String step;
    @Column(name="tagfield")
    private String tagfield;
    @Column(name="timegroup")
    private String timegroup;
    @Column(name="toppos")
    private String toppos;
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
    @Column(name="width")
    private String width;
    @Column(name="xfield")
    private String xfield;
    @Column(name="xfpscodelistid")
    private String xfpscodelistid;
    @Column(name="xfpscodelistname")
    private String xfpscodelistname;
    @Column(name="xpsdechartaxesid")
    private String xpsdechartaxesid;
    @Column(name="xpsdechartaxesname")
    private String xpsdechartaxesname;
    @Column(name="yfield")
    private String yfield;
    @Column(name="ypsdechartaxesid")
    private String ypsdechartaxesid;
    @Column(name="ypsdechartaxesname")
    private String ypsdechartaxesname;
    @Column(name="zfield")
    private String zfield;
    private Integer objSFPSCodeListLock = new Integer(1);
    private PSCodeList sfpscodelist = null;
    private Integer objXFPSCodeListLock = new Integer(1);
    private PSCodeList xfpscodelist = null;
    private Integer objXPSDEChartAxesLock = new Integer(1);
    private PSDEChartAxes xpsdechartaxes = null;
    private Integer objYPSDEChartAxesLock = new Integer(1);
    private PSDEChartAxes ypsdechartaxes = null;
    private Integer objPSDEChartLock = new Integer(1);
    private PSDEChart psdechart = null;
    private Integer objPSDERLock = new Integer(1);
    private PSDER psder = null;
    private Integer objPSDEViewBaseLock = new Integer(1);
    private PSDEViewBase psdeviewbase = null;
    private Integer objCapPSLanResLock = new Integer(1);
    private PSLanguageRes cappslanres = null;
    private Integer objCSPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel cspssysdynamodel = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objCSPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin cspssyspfplugin = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;

    public void setBarCategoryGap(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBarCategoryGap(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.barcategorygap = string;
        this.barcategorygapDirtyFlag = true;
    }

    public String getBarCategoryGap() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBarCategoryGap();
        }
        return this.barcategorygap;
    }

    public boolean isBarCategoryGapDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBarCategoryGapDirty();
        }
        return this.barcategorygapDirtyFlag;
    }

    public void resetBarCategoryGap() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBarCategoryGap();
            return;
        }
        this.barcategorygapDirtyFlag = false;
        this.barcategorygap = null;
    }

    public void setBarGap(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBarGap(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bargap = string;
        this.bargapDirtyFlag = true;
    }

    public String getBarGap() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBarGap();
        }
        return this.bargap;
    }

    public boolean isBarGapDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBarGapDirty();
        }
        return this.bargapDirtyFlag;
    }

    public void resetBarGap() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBarGap();
            return;
        }
        this.bargapDirtyFlag = false;
        this.bargap = null;
    }

    public void setBarMaxWidth(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBarMaxWidth(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.barmaxwidth = string;
        this.barmaxwidthDirtyFlag = true;
    }

    public String getBarMaxWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBarMaxWidth();
        }
        return this.barmaxwidth;
    }

    public boolean isBarMaxWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBarMaxWidthDirty();
        }
        return this.barmaxwidthDirtyFlag;
    }

    public void resetBarMaxWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBarMaxWidth();
            return;
        }
        this.barmaxwidthDirtyFlag = false;
        this.barmaxwidth = null;
    }

    public void setBarMinHeight(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBarMinHeight(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.barminheight = string;
        this.barminheightDirtyFlag = true;
    }

    public String getBarMinHeight() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBarMinHeight();
        }
        return this.barminheight;
    }

    public boolean isBarMinHeightDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBarMinHeightDirty();
        }
        return this.barminheightDirtyFlag;
    }

    public void resetBarMinHeight() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBarMinHeight();
            return;
        }
        this.barminheightDirtyFlag = false;
        this.barminheight = null;
    }

    public void setBarMinWidth(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBarMinWidth(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.barminwidth = string;
        this.barminwidthDirtyFlag = true;
    }

    public String getBarMinWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBarMinWidth();
        }
        return this.barminwidth;
    }

    public boolean isBarMinWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBarMinWidthDirty();
        }
        return this.barminwidthDirtyFlag;
    }

    public void resetBarMinWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBarMinWidth();
            return;
        }
        this.barminwidthDirtyFlag = false;
        this.barminwidth = null;
    }

    public void setBarWidth(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBarWidth(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.barwidth = string;
        this.barwidthDirtyFlag = true;
    }

    public String getBarWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBarWidth();
        }
        return this.barwidth;
    }

    public boolean isBarWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBarWidthDirty();
        }
        return this.barwidthDirtyFlag;
    }

    public void resetBarWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBarWidth();
            return;
        }
        this.barwidthDirtyFlag = false;
        this.barwidth = null;
    }

    public void setBottomPos(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBottomPos(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bottompos = string;
        this.bottomposDirtyFlag = true;
    }

    public String getBottomPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBottomPos();
        }
        return this.bottompos;
    }

    public boolean isBottomPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBottomPosDirty();
        }
        return this.bottomposDirtyFlag;
    }

    public void resetBottomPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBottomPos();
            return;
        }
        this.bottomposDirtyFlag = false;
        this.bottompos = null;
    }

    public void setBoxWidths(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBoxWidths(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.boxwidths = string;
        this.boxwidthsDirtyFlag = true;
    }

    public String getBoxWidths() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBoxWidths();
        }
        return this.boxwidths;
    }

    public boolean isBoxWidthsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBoxWidthsDirty();
        }
        return this.boxwidthsDirtyFlag;
    }

    public void resetBoxWidths() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBoxWidths();
            return;
        }
        this.boxwidthsDirtyFlag = false;
        this.boxwidths = null;
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

    public void setCenter(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCenter(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.center = string;
        this.centerDirtyFlag = true;
    }

    public String getCenter() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCenter();
        }
        return this.center;
    }

    public boolean isCenterDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCenterDirty();
        }
        return this.centerDirtyFlag;
    }

    public void resetCenter() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCenter();
            return;
        }
        this.centerDirtyFlag = false;
        this.center = null;
    }

    public void setChartType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setChartType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.charttype = string;
        this.charttypeDirtyFlag = true;
    }

    public String getChartType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getChartType();
        }
        return this.charttype;
    }

    public boolean isChartTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isChartTypeDirty();
        }
        return this.charttypeDirtyFlag;
    }

    public void resetChartType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetChartType();
            return;
        }
        this.charttypeDirtyFlag = false;
        this.charttype = null;
    }

    public void setClockWise(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setClockWise(n);
            return;
        }
        this.clockwise = n;
        this.clockwiseDirtyFlag = true;
    }

    public Integer getClockWise() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getClockWise();
        }
        return this.clockwise;
    }

    public boolean isClockWiseDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isClockWiseDirty();
        }
        return this.clockwiseDirtyFlag;
    }

    public void resetClockWise() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetClockWise();
            return;
        }
        this.clockwiseDirtyFlag = false;
        this.clockwise = null;
    }

    public void setCoordinateSystem(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCoordinateSystem(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.coordinatesystem = string;
        this.coordinatesystemDirtyFlag = true;
    }

    public String getCoordinateSystem() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCoordinateSystem();
        }
        return this.coordinatesystem;
    }

    public boolean isCoordinateSystemDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCoordinateSystemDirty();
        }
        return this.coordinatesystemDirtyFlag;
    }

    public void resetCoordinateSystem() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCoordinateSystem();
            return;
        }
        this.coordinatesystemDirtyFlag = false;
        this.coordinatesystem = null;
    }

    public void setCoordinateSystemId(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCoordinateSystemId(n);
            return;
        }
        this.coordinatesystemid = n;
        this.coordinatesystemidDirtyFlag = true;
    }

    public Integer getCoordinateSystemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCoordinateSystemId();
        }
        return this.coordinatesystemid;
    }

    public boolean isCoordinateSystemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCoordinateSystemIdDirty();
        }
        return this.coordinatesystemidDirtyFlag;
    }

    public void resetCoordinateSystemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCoordinateSystemId();
            return;
        }
        this.coordinatesystemidDirtyFlag = false;
        this.coordinatesystemid = null;
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

    public void setCSPSSysDynaModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCSPSSysDynaModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cspssysdynamodelid = string;
        this.cspssysdynamodelidDirtyFlag = true;
    }

    public String getCSPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCSPSSysDynaModelId();
        }
        return this.cspssysdynamodelid;
    }

    public boolean isCSPSSysDynaModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCSPSSysDynaModelIdDirty();
        }
        return this.cspssysdynamodelidDirtyFlag;
    }

    public void resetCSPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCSPSSysDynaModelId();
            return;
        }
        this.cspssysdynamodelidDirtyFlag = false;
        this.cspssysdynamodelid = null;
    }

    public void setCSPSSysDynaModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCSPSSysDynaModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cspssysdynamodelname = string;
        this.cspssysdynamodelnameDirtyFlag = true;
    }

    public String getCSPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCSPSSysDynaModelName();
        }
        return this.cspssysdynamodelname;
    }

    public boolean isCSPSSysDynaModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCSPSSysDynaModelNameDirty();
        }
        return this.cspssysdynamodelnameDirtyFlag;
    }

    public void resetCSPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCSPSSysDynaModelName();
            return;
        }
        this.cspssysdynamodelnameDirtyFlag = false;
        this.cspssysdynamodelname = null;
    }

    public void setCSPSSysPFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCSPSSysPFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cspssyspfpluginid = string;
        this.cspssyspfpluginidDirtyFlag = true;
    }

    public String getCSPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCSPSSysPFPluginId();
        }
        return this.cspssyspfpluginid;
    }

    public boolean isCSPSSysPFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCSPSSysPFPluginIdDirty();
        }
        return this.cspssyspfpluginidDirtyFlag;
    }

    public void resetCSPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCSPSSysPFPluginId();
            return;
        }
        this.cspssyspfpluginidDirtyFlag = false;
        this.cspssyspfpluginid = null;
    }

    public void setCSPSSysPFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCSPSSysPFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cspssyspfpluginname = string;
        this.cspssyspfpluginnameDirtyFlag = true;
    }

    public String getCSPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCSPSSysPFPluginName();
        }
        return this.cspssyspfpluginname;
    }

    public boolean isCSPSSysPFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCSPSSysPFPluginNameDirty();
        }
        return this.cspssyspfpluginnameDirtyFlag;
    }

    public void resetCSPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCSPSSysPFPluginName();
            return;
        }
        this.cspssyspfpluginnameDirtyFlag = false;
        this.cspssyspfpluginname = null;
    }

    public void setDataField(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataField(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.datafield = string;
        this.datafieldDirtyFlag = true;
    }

    public String getDataField() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataField();
        }
        return this.datafield;
    }

    public boolean isDataFieldDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataFieldDirty();
        }
        return this.datafieldDirtyFlag;
    }

    public void resetDataField() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataField();
            return;
        }
        this.datafieldDirtyFlag = false;
        this.datafield = null;
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

    public void setEndAngle(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEndAngle(n);
            return;
        }
        this.endangle = n;
        this.endangleDirtyFlag = true;
    }

    public Integer getEndAngle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEndAngle();
        }
        return this.endangle;
    }

    public boolean isEndAngleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEndAngleDirty();
        }
        return this.endangleDirtyFlag;
    }

    public void resetEndAngle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEndAngle();
            return;
        }
        this.endangleDirtyFlag = false;
        this.endangle = null;
    }

    public void setExtField(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExtField(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.extfield = string;
        this.extfieldDirtyFlag = true;
    }

    public String getExtField() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExtField();
        }
        return this.extfield;
    }

    public boolean isExtFieldDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExtFieldDirty();
        }
        return this.extfieldDirtyFlag;
    }

    public void resetExtField() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExtField();
            return;
        }
        this.extfieldDirtyFlag = false;
        this.extfield = null;
    }

    public void setExtField2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExtField2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.extfield2 = string;
        this.extfield2DirtyFlag = true;
    }

    public String getExtField2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExtField2();
        }
        return this.extfield2;
    }

    public boolean isExtField2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExtField2Dirty();
        }
        return this.extfield2DirtyFlag;
    }

    public void resetExtField2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExtField2();
            return;
        }
        this.extfield2DirtyFlag = false;
        this.extfield2 = null;
    }

    public void setExtField3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExtField3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.extfield3 = string;
        this.extfield3DirtyFlag = true;
    }

    public String getExtField3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExtField3();
        }
        return this.extfield3;
    }

    public boolean isExtField3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExtField3Dirty();
        }
        return this.extfield3DirtyFlag;
    }

    public void resetExtField3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExtField3();
            return;
        }
        this.extfield3DirtyFlag = false;
        this.extfield3 = null;
    }

    public void setExtField4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExtField4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.extfield4 = string;
        this.extfield4DirtyFlag = true;
    }

    public String getExtField4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExtField4();
        }
        return this.extfield4;
    }

    public boolean isExtField4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExtField4Dirty();
        }
        return this.extfield4DirtyFlag;
    }

    public void resetExtField4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExtField4();
            return;
        }
        this.extfield4DirtyFlag = false;
        this.extfield4 = null;
    }

    public void setFunnelAlign(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFunnelAlign(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.funnelalign = string;
        this.funnelalignDirtyFlag = true;
    }

    public String getFunnelAlign() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFunnelAlign();
        }
        return this.funnelalign;
    }

    public boolean isFunnelAlignDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFunnelAlignDirty();
        }
        return this.funnelalignDirtyFlag;
    }

    public void resetFunnelAlign() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFunnelAlign();
            return;
        }
        this.funnelalignDirtyFlag = false;
        this.funnelalign = null;
    }

    public void setHeight(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHeight(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.height = string;
        this.heightDirtyFlag = true;
    }

    public String getHeight() {
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

    public void setLeftPos(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLeftPos(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.leftpos = string;
        this.leftposDirtyFlag = true;
    }

    public String getLeftPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLeftPos();
        }
        return this.leftpos;
    }

    public boolean isLeftPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLeftPosDirty();
        }
        return this.leftposDirtyFlag;
    }

    public void resetLeftPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLeftPos();
            return;
        }
        this.leftposDirtyFlag = false;
        this.leftpos = null;
    }

    public void setMapType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMapType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.maptype = string;
        this.maptypeDirtyFlag = true;
    }

    public String getMapType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMapType();
        }
        return this.maptype;
    }

    public boolean isMapTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMapTypeDirty();
        }
        return this.maptypeDirtyFlag;
    }

    public void resetMapType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMapType();
            return;
        }
        this.maptypeDirtyFlag = false;
        this.maptype = null;
    }

    public void setMaxSize(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxSize(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.maxsize = string;
        this.maxsizeDirtyFlag = true;
    }

    public String getMaxSize() {
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

    public void setMaxValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxValue(n);
            return;
        }
        this.maxvalue = n;
        this.maxvalueDirtyFlag = true;
    }

    public Integer getMaxValue() {
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

    public void setMinAngle(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinAngle(n);
            return;
        }
        this.minangle = n;
        this.minangleDirtyFlag = true;
    }

    public Integer getMinAngle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinAngle();
        }
        return this.minangle;
    }

    public boolean isMinAngleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinAngleDirty();
        }
        return this.minangleDirtyFlag;
    }

    public void resetMinAngle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinAngle();
            return;
        }
        this.minangleDirtyFlag = false;
        this.minangle = null;
    }

    public void setMinShowLabelAngle(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinShowLabelAngle(n);
            return;
        }
        this.minshowlabelangle = n;
        this.minshowlabelangleDirtyFlag = true;
    }

    public Integer getMinShowLabelAngle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinShowLabelAngle();
        }
        return this.minshowlabelangle;
    }

    public boolean isMinShowLabelAngleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinShowLabelAngleDirty();
        }
        return this.minshowlabelangleDirtyFlag;
    }

    public void resetMinShowLabelAngle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinShowLabelAngle();
            return;
        }
        this.minshowlabelangleDirtyFlag = false;
        this.minshowlabelangle = null;
    }

    public void setMinSize(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinSize(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minsize = string;
        this.minsizeDirtyFlag = true;
    }

    public String getMinSize() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinSize();
        }
        return this.minsize;
    }

    public boolean isMinSizeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinSizeDirty();
        }
        return this.minsizeDirtyFlag;
    }

    public void resetMinSize() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinSize();
            return;
        }
        this.minsizeDirtyFlag = false;
        this.minsize = null;
    }

    public void setMinValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinValue(n);
            return;
        }
        this.minvalue = n;
        this.minvalueDirtyFlag = true;
    }

    public Integer getMinValue() {
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

    public void setPSDEChartId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEChartId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdechartid = string;
        this.psdechartidDirtyFlag = true;
    }

    public String getPSDEChartId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEChartId();
        }
        return this.psdechartid;
    }

    public boolean isPSDEChartIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEChartIdDirty();
        }
        return this.psdechartidDirtyFlag;
    }

    public void resetPSDEChartId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEChartId();
            return;
        }
        this.psdechartidDirtyFlag = false;
        this.psdechartid = null;
    }

    public void setPSDEChartName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEChartName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdechartname = string;
        this.psdechartnameDirtyFlag = true;
    }

    public String getPSDEChartName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEChartName();
        }
        return this.psdechartname;
    }

    public boolean isPSDEChartNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEChartNameDirty();
        }
        return this.psdechartnameDirtyFlag;
    }

    public void resetPSDEChartName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEChartName();
            return;
        }
        this.psdechartnameDirtyFlag = false;
        this.psdechartname = null;
    }

    public void setPSDEChartParamId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEChartParamId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdechartparamid = string;
        this.psdechartparamidDirtyFlag = true;
    }

    public String getPSDEChartParamId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEChartParamId();
        }
        return this.psdechartparamid;
    }

    public boolean isPSDEChartParamIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEChartParamIdDirty();
        }
        return this.psdechartparamidDirtyFlag;
    }

    public void resetPSDEChartParamId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEChartParamId();
            return;
        }
        this.psdechartparamidDirtyFlag = false;
        this.psdechartparamid = null;
    }

    public void setPSDEChartParamName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEChartParamName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdechartparamname = string;
        this.psdechartparamnameDirtyFlag = true;
    }

    public String getPSDEChartParamName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEChartParamName();
        }
        return this.psdechartparamname;
    }

    public boolean isPSDEChartParamNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEChartParamNameDirty();
        }
        return this.psdechartparamnameDirtyFlag;
    }

    public void resetPSDEChartParamName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEChartParamName();
            return;
        }
        this.psdechartparamnameDirtyFlag = false;
        this.psdechartparamname = null;
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

    public void setRadius(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRadius(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.radius = string;
        this.radiusDirtyFlag = true;
    }

    public String getRadius() {
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

    public void setRightPos(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRightPos(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rightpos = string;
        this.rightposDirtyFlag = true;
    }

    public String getRightPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRightPos();
        }
        return this.rightpos;
    }

    public boolean isRightPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRightPosDirty();
        }
        return this.rightposDirtyFlag;
    }

    public void resetRightPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRightPos();
            return;
        }
        this.rightposDirtyFlag = false;
        this.rightpos = null;
    }

    public void setRoseType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRoseType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rosetype = string;
        this.rosetypeDirtyFlag = true;
    }

    public String getRoseType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRoseType();
        }
        return this.rosetype;
    }

    public boolean isRoseTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRoseTypeDirty();
        }
        return this.rosetypeDirtyFlag;
    }

    public void resetRoseType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRoseType();
            return;
        }
        this.rosetypeDirtyFlag = false;
        this.rosetype = null;
    }

    public void setSampleData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSampleData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sampledata = string;
        this.sampledataDirtyFlag = true;
    }

    public String getSampleData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSampleData();
        }
        return this.sampledata;
    }

    public boolean isSampleDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSampleDataDirty();
        }
        return this.sampledataDirtyFlag;
    }

    public void resetSampleData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSampleData();
            return;
        }
        this.sampledataDirtyFlag = false;
        this.sampledata = null;
    }

    public void setSeriesField(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSeriesField(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.seriesfield = string;
        this.seriesfieldDirtyFlag = true;
    }

    public String getSeriesField() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSeriesField();
        }
        return this.seriesfield;
    }

    public boolean isSeriesFieldDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSeriesFieldDirty();
        }
        return this.seriesfieldDirtyFlag;
    }

    public void resetSeriesField() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSeriesField();
            return;
        }
        this.seriesfieldDirtyFlag = false;
        this.seriesfield = null;
    }

    public void setSeriesLayoutBy(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSeriesLayoutBy(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.serieslayoutby = string;
        this.serieslayoutbyDirtyFlag = true;
    }

    public String getSeriesLayoutBy() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSeriesLayoutBy();
        }
        return this.serieslayoutby;
    }

    public boolean isSeriesLayoutByDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSeriesLayoutByDirty();
        }
        return this.serieslayoutbyDirtyFlag;
    }

    public void resetSeriesLayoutBy() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSeriesLayoutBy();
            return;
        }
        this.serieslayoutbyDirtyFlag = false;
        this.serieslayoutby = null;
    }

    public void setSeriesParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSeriesParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.seriesparam = string;
        this.seriesparamDirtyFlag = true;
    }

    public String getSeriesParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSeriesParam();
        }
        return this.seriesparam;
    }

    public boolean isSeriesParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSeriesParamDirty();
        }
        return this.seriesparamDirtyFlag;
    }

    public void resetSeriesParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSeriesParam();
            return;
        }
        this.seriesparamDirtyFlag = false;
        this.seriesparam = null;
    }

    public void setSeriesParam10(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSeriesParam10(d);
            return;
        }
        this.seriesparam10 = d;
        this.seriesparam10DirtyFlag = true;
    }

    public Double getSeriesParam10() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSeriesParam10();
        }
        return this.seriesparam10;
    }

    public boolean isSeriesParam10Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSeriesParam10Dirty();
        }
        return this.seriesparam10DirtyFlag;
    }

    public void resetSeriesParam10() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSeriesParam10();
            return;
        }
        this.seriesparam10DirtyFlag = false;
        this.seriesparam10 = null;
    }

    public void setSeriesParam11(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSeriesParam11(n);
            return;
        }
        this.seriesparam11 = n;
        this.seriesparam11DirtyFlag = true;
    }

    public Integer getSeriesParam11() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSeriesParam11();
        }
        return this.seriesparam11;
    }

    public boolean isSeriesParam11Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSeriesParam11Dirty();
        }
        return this.seriesparam11DirtyFlag;
    }

    public void resetSeriesParam11() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSeriesParam11();
            return;
        }
        this.seriesparam11DirtyFlag = false;
        this.seriesparam11 = null;
    }

    public void setSeriesParam12(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSeriesParam12(n);
            return;
        }
        this.seriesparam12 = n;
        this.seriesparam12DirtyFlag = true;
    }

    public Integer getSeriesParam12() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSeriesParam12();
        }
        return this.seriesparam12;
    }

    public boolean isSeriesParam12Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSeriesParam12Dirty();
        }
        return this.seriesparam12DirtyFlag;
    }

    public void resetSeriesParam12() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSeriesParam12();
            return;
        }
        this.seriesparam12DirtyFlag = false;
        this.seriesparam12 = null;
    }

    public void setSeriesParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSeriesParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.seriesparam2 = string;
        this.seriesparam2DirtyFlag = true;
    }

    public String getSeriesParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSeriesParam2();
        }
        return this.seriesparam2;
    }

    public boolean isSeriesParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSeriesParam2Dirty();
        }
        return this.seriesparam2DirtyFlag;
    }

    public void resetSeriesParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSeriesParam2();
            return;
        }
        this.seriesparam2DirtyFlag = false;
        this.seriesparam2 = null;
    }

    public void setSeriesParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSeriesParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.seriesparam3 = string;
        this.seriesparam3DirtyFlag = true;
    }

    public String getSeriesParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSeriesParam3();
        }
        return this.seriesparam3;
    }

    public boolean isSeriesParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSeriesParam3Dirty();
        }
        return this.seriesparam3DirtyFlag;
    }

    public void resetSeriesParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSeriesParam3();
            return;
        }
        this.seriesparam3DirtyFlag = false;
        this.seriesparam3 = null;
    }

    public void setSeriesParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSeriesParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.seriesparam4 = string;
        this.seriesparam4DirtyFlag = true;
    }

    public String getSeriesParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSeriesParam4();
        }
        return this.seriesparam4;
    }

    public boolean isSeriesParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSeriesParam4Dirty();
        }
        return this.seriesparam4DirtyFlag;
    }

    public void resetSeriesParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSeriesParam4();
            return;
        }
        this.seriesparam4DirtyFlag = false;
        this.seriesparam4 = null;
    }

    public void setSeriesParam5(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSeriesParam5(n);
            return;
        }
        this.seriesparam5 = n;
        this.seriesparam5DirtyFlag = true;
    }

    public Integer getSeriesParam5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSeriesParam5();
        }
        return this.seriesparam5;
    }

    public boolean isSeriesParam5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSeriesParam5Dirty();
        }
        return this.seriesparam5DirtyFlag;
    }

    public void resetSeriesParam5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSeriesParam5();
            return;
        }
        this.seriesparam5DirtyFlag = false;
        this.seriesparam5 = null;
    }

    public void setSeriesParam6(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSeriesParam6(n);
            return;
        }
        this.seriesparam6 = n;
        this.seriesparam6DirtyFlag = true;
    }

    public Integer getSeriesParam6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSeriesParam6();
        }
        return this.seriesparam6;
    }

    public boolean isSeriesParam6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSeriesParam6Dirty();
        }
        return this.seriesparam6DirtyFlag;
    }

    public void resetSeriesParam6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSeriesParam6();
            return;
        }
        this.seriesparam6DirtyFlag = false;
        this.seriesparam6 = null;
    }

    public void setSeriesParam7(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSeriesParam7(n);
            return;
        }
        this.seriesparam7 = n;
        this.seriesparam7DirtyFlag = true;
    }

    public Integer getSeriesParam7() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSeriesParam7();
        }
        return this.seriesparam7;
    }

    public boolean isSeriesParam7Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSeriesParam7Dirty();
        }
        return this.seriesparam7DirtyFlag;
    }

    public void resetSeriesParam7() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSeriesParam7();
            return;
        }
        this.seriesparam7DirtyFlag = false;
        this.seriesparam7 = null;
    }

    public void setSeriesParam8(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSeriesParam8(n);
            return;
        }
        this.seriesparam8 = n;
        this.seriesparam8DirtyFlag = true;
    }

    public Integer getSeriesParam8() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSeriesParam8();
        }
        return this.seriesparam8;
    }

    public boolean isSeriesParam8Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSeriesParam8Dirty();
        }
        return this.seriesparam8DirtyFlag;
    }

    public void resetSeriesParam8() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSeriesParam8();
            return;
        }
        this.seriesparam8DirtyFlag = false;
        this.seriesparam8 = null;
    }

    public void setSeriesParam9(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSeriesParam9(d);
            return;
        }
        this.seriesparam9 = d;
        this.seriesparam9DirtyFlag = true;
    }

    public Double getSeriesParam9() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSeriesParam9();
        }
        return this.seriesparam9;
    }

    public boolean isSeriesParam9Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSeriesParam9Dirty();
        }
        return this.seriesparam9DirtyFlag;
    }

    public void resetSeriesParam9() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSeriesParam9();
            return;
        }
        this.seriesparam9DirtyFlag = false;
        this.seriesparam9 = null;
    }

    public void setSFPSCodeListId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSFPSCodeListId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sfpscodelistid = string;
        this.sfpscodelistidDirtyFlag = true;
    }

    public String getSFPSCodeListId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSFPSCodeListId();
        }
        return this.sfpscodelistid;
    }

    public boolean isSFPSCodeListIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSFPSCodeListIdDirty();
        }
        return this.sfpscodelistidDirtyFlag;
    }

    public void resetSFPSCodeListId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSFPSCodeListId();
            return;
        }
        this.sfpscodelistidDirtyFlag = false;
        this.sfpscodelistid = null;
    }

    public void setSFPSCodeListName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSFPSCodeListName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sfpscodelistname = string;
        this.sfpscodelistnameDirtyFlag = true;
    }

    public String getSFPSCodeListName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSFPSCodeListName();
        }
        return this.sfpscodelistname;
    }

    public boolean isSFPSCodeListNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSFPSCodeListNameDirty();
        }
        return this.sfpscodelistnameDirtyFlag;
    }

    public void resetSFPSCodeListName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSFPSCodeListName();
            return;
        }
        this.sfpscodelistnameDirtyFlag = false;
        this.sfpscodelistname = null;
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

    public void setSplitNumber(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSplitNumber(n);
            return;
        }
        this.splitnumber = n;
        this.splitnumberDirtyFlag = true;
    }

    public Integer getSplitNumber() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSplitNumber();
        }
        return this.splitnumber;
    }

    public boolean isSplitNumberDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSplitNumberDirty();
        }
        return this.splitnumberDirtyFlag;
    }

    public void resetSplitNumber() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSplitNumber();
            return;
        }
        this.splitnumberDirtyFlag = false;
        this.splitnumber = null;
    }

    public void setStack(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStack(n);
            return;
        }
        this.stack = n;
        this.stackDirtyFlag = true;
    }

    public Integer getStack() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStack();
        }
        return this.stack;
    }

    public boolean isStackDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStackDirty();
        }
        return this.stackDirtyFlag;
    }

    public void resetStack() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStack();
            return;
        }
        this.stackDirtyFlag = false;
        this.stack = null;
    }

    public void setStartAngle(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStartAngle(n);
            return;
        }
        this.startangle = n;
        this.startangleDirtyFlag = true;
    }

    public Integer getStartAngle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStartAngle();
        }
        return this.startangle;
    }

    public boolean isStartAngleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStartAngleDirty();
        }
        return this.startangleDirtyFlag;
    }

    public void resetStartAngle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStartAngle();
            return;
        }
        this.startangleDirtyFlag = false;
        this.startangle = null;
    }

    public void setStep(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStep(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.step = string;
        this.stepDirtyFlag = true;
    }

    public String getStep() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStep();
        }
        return this.step;
    }

    public boolean isStepDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStepDirty();
        }
        return this.stepDirtyFlag;
    }

    public void resetStep() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStep();
            return;
        }
        this.stepDirtyFlag = false;
        this.step = null;
    }

    public void setTagField(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTagField(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tagfield = string;
        this.tagfieldDirtyFlag = true;
    }

    public String getTagField() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTagField();
        }
        return this.tagfield;
    }

    public boolean isTagFieldDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTagFieldDirty();
        }
        return this.tagfieldDirtyFlag;
    }

    public void resetTagField() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTagField();
            return;
        }
        this.tagfieldDirtyFlag = false;
        this.tagfield = null;
    }

    public void setTimeGroup(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTimeGroup(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.timegroup = string;
        this.timegroupDirtyFlag = true;
    }

    public String getTimeGroup() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTimeGroup();
        }
        return this.timegroup;
    }

    public boolean isTimeGroupDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTimeGroupDirty();
        }
        return this.timegroupDirtyFlag;
    }

    public void resetTimeGroup() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTimeGroup();
            return;
        }
        this.timegroupDirtyFlag = false;
        this.timegroup = null;
    }

    public void setTopPos(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTopPos(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.toppos = string;
        this.topposDirtyFlag = true;
    }

    public String getTopPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTopPos();
        }
        return this.toppos;
    }

    public boolean isTopPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTopPosDirty();
        }
        return this.topposDirtyFlag;
    }

    public void resetTopPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTopPos();
            return;
        }
        this.topposDirtyFlag = false;
        this.toppos = null;
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

    public void setWidth(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWidth(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.width = string;
        this.widthDirtyFlag = true;
    }

    public String getWidth() {
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

    public void setXField(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setXField(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.xfield = string;
        this.xfieldDirtyFlag = true;
    }

    public String getXField() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getXField();
        }
        return this.xfield;
    }

    public boolean isXFieldDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isXFieldDirty();
        }
        return this.xfieldDirtyFlag;
    }

    public void resetXField() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetXField();
            return;
        }
        this.xfieldDirtyFlag = false;
        this.xfield = null;
    }

    public void setXFPSCodeListId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setXFPSCodeListId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.xfpscodelistid = string;
        this.xfpscodelistidDirtyFlag = true;
    }

    public String getXFPSCodeListId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getXFPSCodeListId();
        }
        return this.xfpscodelistid;
    }

    public boolean isXFPSCodeListIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isXFPSCodeListIdDirty();
        }
        return this.xfpscodelistidDirtyFlag;
    }

    public void resetXFPSCodeListId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetXFPSCodeListId();
            return;
        }
        this.xfpscodelistidDirtyFlag = false;
        this.xfpscodelistid = null;
    }

    public void setXFPSCodeListName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setXFPSCodeListName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.xfpscodelistname = string;
        this.xfpscodelistnameDirtyFlag = true;
    }

    public String getXFPSCodeListName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getXFPSCodeListName();
        }
        return this.xfpscodelistname;
    }

    public boolean isXFPSCodeListNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isXFPSCodeListNameDirty();
        }
        return this.xfpscodelistnameDirtyFlag;
    }

    public void resetXFPSCodeListName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetXFPSCodeListName();
            return;
        }
        this.xfpscodelistnameDirtyFlag = false;
        this.xfpscodelistname = null;
    }

    public void setXPSDEChartAxesId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setXPSDEChartAxesId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.xpsdechartaxesid = string;
        this.xpsdechartaxesidDirtyFlag = true;
    }

    public String getXPSDEChartAxesId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getXPSDEChartAxesId();
        }
        return this.xpsdechartaxesid;
    }

    public boolean isXPSDEChartAxesIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isXPSDEChartAxesIdDirty();
        }
        return this.xpsdechartaxesidDirtyFlag;
    }

    public void resetXPSDEChartAxesId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetXPSDEChartAxesId();
            return;
        }
        this.xpsdechartaxesidDirtyFlag = false;
        this.xpsdechartaxesid = null;
    }

    public void setXPSDEChartAxesName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setXPSDEChartAxesName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.xpsdechartaxesname = string;
        this.xpsdechartaxesnameDirtyFlag = true;
    }

    public String getXPSDEChartAxesName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getXPSDEChartAxesName();
        }
        return this.xpsdechartaxesname;
    }

    public boolean isXPSDEChartAxesNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isXPSDEChartAxesNameDirty();
        }
        return this.xpsdechartaxesnameDirtyFlag;
    }

    public void resetXPSDEChartAxesName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetXPSDEChartAxesName();
            return;
        }
        this.xpsdechartaxesnameDirtyFlag = false;
        this.xpsdechartaxesname = null;
    }

    public void setYField(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setYField(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.yfield = string;
        this.yfieldDirtyFlag = true;
    }

    public String getYField() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getYField();
        }
        return this.yfield;
    }

    public boolean isYFieldDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isYFieldDirty();
        }
        return this.yfieldDirtyFlag;
    }

    public void resetYField() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetYField();
            return;
        }
        this.yfieldDirtyFlag = false;
        this.yfield = null;
    }

    public void setYPSDEChartAxesId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setYPSDEChartAxesId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ypsdechartaxesid = string;
        this.ypsdechartaxesidDirtyFlag = true;
    }

    public String getYPSDEChartAxesId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getYPSDEChartAxesId();
        }
        return this.ypsdechartaxesid;
    }

    public boolean isYPSDEChartAxesIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isYPSDEChartAxesIdDirty();
        }
        return this.ypsdechartaxesidDirtyFlag;
    }

    public void resetYPSDEChartAxesId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetYPSDEChartAxesId();
            return;
        }
        this.ypsdechartaxesidDirtyFlag = false;
        this.ypsdechartaxesid = null;
    }

    public void setYPSDEChartAxesName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setYPSDEChartAxesName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ypsdechartaxesname = string;
        this.ypsdechartaxesnameDirtyFlag = true;
    }

    public String getYPSDEChartAxesName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getYPSDEChartAxesName();
        }
        return this.ypsdechartaxesname;
    }

    public boolean isYPSDEChartAxesNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isYPSDEChartAxesNameDirty();
        }
        return this.ypsdechartaxesnameDirtyFlag;
    }

    public void resetYPSDEChartAxesName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetYPSDEChartAxesName();
            return;
        }
        this.ypsdechartaxesnameDirtyFlag = false;
        this.ypsdechartaxesname = null;
    }

    public void setZField(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setZField(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.zfield = string;
        this.zfieldDirtyFlag = true;
    }

    public String getZField() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getZField();
        }
        return this.zfield;
    }

    public boolean isZFieldDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isZFieldDirty();
        }
        return this.zfieldDirtyFlag;
    }

    public void resetZField() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetZField();
            return;
        }
        this.zfieldDirtyFlag = false;
        this.zfield = null;
    }

    protected void onReset() {
        PSDEChartParamBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEChartParamBase pSDEChartParamBase) {
        pSDEChartParamBase.resetBarCategoryGap();
        pSDEChartParamBase.resetBarGap();
        pSDEChartParamBase.resetBarMaxWidth();
        pSDEChartParamBase.resetBarMinHeight();
        pSDEChartParamBase.resetBarMinWidth();
        pSDEChartParamBase.resetBarWidth();
        pSDEChartParamBase.resetBottomPos();
        pSDEChartParamBase.resetBoxWidths();
        pSDEChartParamBase.resetCapPSLanResId();
        pSDEChartParamBase.resetCapPSLanResName();
        pSDEChartParamBase.resetCaption();
        pSDEChartParamBase.resetCenter();
        pSDEChartParamBase.resetChartType();
        pSDEChartParamBase.resetClockWise();
        pSDEChartParamBase.resetCoordinateSystem();
        pSDEChartParamBase.resetCoordinateSystemId();
        pSDEChartParamBase.resetCreateDate();
        pSDEChartParamBase.resetCreateMan();
        pSDEChartParamBase.resetCSPSSysDynaModelId();
        pSDEChartParamBase.resetCSPSSysDynaModelName();
        pSDEChartParamBase.resetCSPSSysPFPluginId();
        pSDEChartParamBase.resetCSPSSysPFPluginName();
        pSDEChartParamBase.resetDataField();
        pSDEChartParamBase.resetDynaClass();
        pSDEChartParamBase.resetEndAngle();
        pSDEChartParamBase.resetExtField();
        pSDEChartParamBase.resetExtField2();
        pSDEChartParamBase.resetExtField3();
        pSDEChartParamBase.resetExtField4();
        pSDEChartParamBase.resetFunnelAlign();
        pSDEChartParamBase.resetHeight();
        pSDEChartParamBase.resetLeftPos();
        pSDEChartParamBase.resetMapType();
        pSDEChartParamBase.resetMaxSize();
        pSDEChartParamBase.resetMaxValue();
        pSDEChartParamBase.resetMemo();
        pSDEChartParamBase.resetMinAngle();
        pSDEChartParamBase.resetMinShowLabelAngle();
        pSDEChartParamBase.resetMinSize();
        pSDEChartParamBase.resetMinValue();
        pSDEChartParamBase.resetNavViewFilter();
        pSDEChartParamBase.resetNavViewParam();
        pSDEChartParamBase.resetOrderValue();
        pSDEChartParamBase.resetPSDEChartId();
        pSDEChartParamBase.resetPSDEChartName();
        pSDEChartParamBase.resetPSDEChartParamId();
        pSDEChartParamBase.resetPSDEChartParamName();
        pSDEChartParamBase.resetPSDEId();
        pSDEChartParamBase.resetPSDERId();
        pSDEChartParamBase.resetPSDERName();
        pSDEChartParamBase.resetPSDEViewBaseId();
        pSDEChartParamBase.resetPSDEViewBaseName();
        pSDEChartParamBase.resetPSSysDynaModelId();
        pSDEChartParamBase.resetPSSysDynaModelName();
        pSDEChartParamBase.resetPSSysPFPluginId();
        pSDEChartParamBase.resetPSSysPFPluginName();
        pSDEChartParamBase.resetRadius();
        pSDEChartParamBase.resetRightPos();
        pSDEChartParamBase.resetRoseType();
        pSDEChartParamBase.resetSampleData();
        pSDEChartParamBase.resetSeriesField();
        pSDEChartParamBase.resetSeriesLayoutBy();
        pSDEChartParamBase.resetSeriesParam();
        pSDEChartParamBase.resetSeriesParam10();
        pSDEChartParamBase.resetSeriesParam11();
        pSDEChartParamBase.resetSeriesParam12();
        pSDEChartParamBase.resetSeriesParam2();
        pSDEChartParamBase.resetSeriesParam3();
        pSDEChartParamBase.resetSeriesParam4();
        pSDEChartParamBase.resetSeriesParam5();
        pSDEChartParamBase.resetSeriesParam6();
        pSDEChartParamBase.resetSeriesParam7();
        pSDEChartParamBase.resetSeriesParam8();
        pSDEChartParamBase.resetSeriesParam9();
        pSDEChartParamBase.resetSFPSCodeListId();
        pSDEChartParamBase.resetSFPSCodeListName();
        pSDEChartParamBase.resetSortDir();
        pSDEChartParamBase.resetSplitNumber();
        pSDEChartParamBase.resetStack();
        pSDEChartParamBase.resetStartAngle();
        pSDEChartParamBase.resetStep();
        pSDEChartParamBase.resetTagField();
        pSDEChartParamBase.resetTimeGroup();
        pSDEChartParamBase.resetTopPos();
        pSDEChartParamBase.resetUpdateDate();
        pSDEChartParamBase.resetUpdateMan();
        pSDEChartParamBase.resetUserCat();
        pSDEChartParamBase.resetUserParams();
        pSDEChartParamBase.resetUserTag();
        pSDEChartParamBase.resetUserTag2();
        pSDEChartParamBase.resetUserTag3();
        pSDEChartParamBase.resetUserTag4();
        pSDEChartParamBase.resetWidth();
        pSDEChartParamBase.resetXField();
        pSDEChartParamBase.resetXFPSCodeListId();
        pSDEChartParamBase.resetXFPSCodeListName();
        pSDEChartParamBase.resetXPSDEChartAxesId();
        pSDEChartParamBase.resetXPSDEChartAxesName();
        pSDEChartParamBase.resetYField();
        pSDEChartParamBase.resetYPSDEChartAxesId();
        pSDEChartParamBase.resetYPSDEChartAxesName();
        pSDEChartParamBase.resetZField();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBarCategoryGapDirty()) {
            hashMap.put(FIELD_BARCATEGORYGAP, this.getBarCategoryGap());
        }
        if (!bl || this.isBarGapDirty()) {
            hashMap.put(FIELD_BARGAP, this.getBarGap());
        }
        if (!bl || this.isBarMaxWidthDirty()) {
            hashMap.put(FIELD_BARMAXWIDTH, this.getBarMaxWidth());
        }
        if (!bl || this.isBarMinHeightDirty()) {
            hashMap.put(FIELD_BARMINHEIGHT, this.getBarMinHeight());
        }
        if (!bl || this.isBarMinWidthDirty()) {
            hashMap.put(FIELD_BARMINWIDTH, this.getBarMinWidth());
        }
        if (!bl || this.isBarWidthDirty()) {
            hashMap.put(FIELD_BARWIDTH, this.getBarWidth());
        }
        if (!bl || this.isBottomPosDirty()) {
            hashMap.put(FIELD_BOTTOMPOS, this.getBottomPos());
        }
        if (!bl || this.isBoxWidthsDirty()) {
            hashMap.put(FIELD_BOXWIDTHS, this.getBoxWidths());
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
        if (!bl || this.isCenterDirty()) {
            hashMap.put(FIELD_CENTER, this.getCenter());
        }
        if (!bl || this.isChartTypeDirty()) {
            hashMap.put(FIELD_CHARTTYPE, this.getChartType());
        }
        if (!bl || this.isClockWiseDirty()) {
            hashMap.put(FIELD_CLOCKWISE, this.getClockWise());
        }
        if (!bl || this.isCoordinateSystemDirty()) {
            hashMap.put(FIELD_COORDINATESYSTEM, this.getCoordinateSystem());
        }
        if (!bl || this.isCoordinateSystemIdDirty()) {
            hashMap.put(FIELD_COORDINATESYSTEMID, this.getCoordinateSystemId());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCSPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_CSPSSYSDYNAMODELID, this.getCSPSSysDynaModelId());
        }
        if (!bl || this.isCSPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_CSPSSYSDYNAMODELNAME, this.getCSPSSysDynaModelName());
        }
        if (!bl || this.isCSPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_CSPSSYSPFPLUGINID, this.getCSPSSysPFPluginId());
        }
        if (!bl || this.isCSPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_CSPSSYSPFPLUGINNAME, this.getCSPSSysPFPluginName());
        }
        if (!bl || this.isDataFieldDirty()) {
            hashMap.put(FIELD_DATAFIELD, this.getDataField());
        }
        if (!bl || this.isDynaClassDirty()) {
            hashMap.put(FIELD_DYNACLASS, this.getDynaClass());
        }
        if (!bl || this.isEndAngleDirty()) {
            hashMap.put(FIELD_ENDANGLE, this.getEndAngle());
        }
        if (!bl || this.isExtFieldDirty()) {
            hashMap.put(FIELD_EXTFIELD, this.getExtField());
        }
        if (!bl || this.isExtField2Dirty()) {
            hashMap.put(FIELD_EXTFIELD2, this.getExtField2());
        }
        if (!bl || this.isExtField3Dirty()) {
            hashMap.put(FIELD_EXTFIELD3, this.getExtField3());
        }
        if (!bl || this.isExtField4Dirty()) {
            hashMap.put(FIELD_EXTFIELD4, this.getExtField4());
        }
        if (!bl || this.isFunnelAlignDirty()) {
            hashMap.put(FIELD_FUNNELALIGN, this.getFunnelAlign());
        }
        if (!bl || this.isHeightDirty()) {
            hashMap.put(FIELD_HEIGHT, this.getHeight());
        }
        if (!bl || this.isLeftPosDirty()) {
            hashMap.put(FIELD_LEFTPOS, this.getLeftPos());
        }
        if (!bl || this.isMapTypeDirty()) {
            hashMap.put(FIELD_MAPTYPE, this.getMapType());
        }
        if (!bl || this.isMaxSizeDirty()) {
            hashMap.put(FIELD_MAXSIZE, this.getMaxSize());
        }
        if (!bl || this.isMaxValueDirty()) {
            hashMap.put(FIELD_MAXVALUE, this.getMaxValue());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMinAngleDirty()) {
            hashMap.put(FIELD_MINANGLE, this.getMinAngle());
        }
        if (!bl || this.isMinShowLabelAngleDirty()) {
            hashMap.put(FIELD_MINSHOWLABELANGLE, this.getMinShowLabelAngle());
        }
        if (!bl || this.isMinSizeDirty()) {
            hashMap.put(FIELD_MINSIZE, this.getMinSize());
        }
        if (!bl || this.isMinValueDirty()) {
            hashMap.put(FIELD_MINVALUE, this.getMinValue());
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
        if (!bl || this.isPSDEChartIdDirty()) {
            hashMap.put(FIELD_PSDECHARTID, this.getPSDEChartId());
        }
        if (!bl || this.isPSDEChartNameDirty()) {
            hashMap.put(FIELD_PSDECHARTNAME, this.getPSDEChartName());
        }
        if (!bl || this.isPSDEChartParamIdDirty()) {
            hashMap.put(FIELD_PSDECHARTPARAMID, this.getPSDEChartParamId());
        }
        if (!bl || this.isPSDEChartParamNameDirty()) {
            hashMap.put(FIELD_PSDECHARTPARAMNAME, this.getPSDEChartParamName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDERIdDirty()) {
            hashMap.put(FIELD_PSDERID, this.getPSDERId());
        }
        if (!bl || this.isPSDERNameDirty()) {
            hashMap.put(FIELD_PSDERNAME, this.getPSDERName());
        }
        if (!bl || this.isPSDEViewBaseIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASEID, this.getPSDEViewBaseId());
        }
        if (!bl || this.isPSDEViewBaseNameDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASENAME, this.getPSDEViewBaseName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
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
        if (!bl || this.isRightPosDirty()) {
            hashMap.put(FIELD_RIGHTPOS, this.getRightPos());
        }
        if (!bl || this.isRoseTypeDirty()) {
            hashMap.put(FIELD_ROSETYPE, this.getRoseType());
        }
        if (!bl || this.isSampleDataDirty()) {
            hashMap.put(FIELD_SAMPLEDATA, this.getSampleData());
        }
        if (!bl || this.isSeriesFieldDirty()) {
            hashMap.put(FIELD_SERIESFIELD, this.getSeriesField());
        }
        if (!bl || this.isSeriesLayoutByDirty()) {
            hashMap.put(FIELD_SERIESLAYOUTBY, this.getSeriesLayoutBy());
        }
        if (!bl || this.isSeriesParamDirty()) {
            hashMap.put(FIELD_SERIESPARAM, this.getSeriesParam());
        }
        if (!bl || this.isSeriesParam10Dirty()) {
            hashMap.put(FIELD_SERIESPARAM10, this.getSeriesParam10());
        }
        if (!bl || this.isSeriesParam11Dirty()) {
            hashMap.put(FIELD_SERIESPARAM11, this.getSeriesParam11());
        }
        if (!bl || this.isSeriesParam12Dirty()) {
            hashMap.put(FIELD_SERIESPARAM12, this.getSeriesParam12());
        }
        if (!bl || this.isSeriesParam2Dirty()) {
            hashMap.put(FIELD_SERIESPARAM2, this.getSeriesParam2());
        }
        if (!bl || this.isSeriesParam3Dirty()) {
            hashMap.put(FIELD_SERIESPARAM3, this.getSeriesParam3());
        }
        if (!bl || this.isSeriesParam4Dirty()) {
            hashMap.put(FIELD_SERIESPARAM4, this.getSeriesParam4());
        }
        if (!bl || this.isSeriesParam5Dirty()) {
            hashMap.put(FIELD_SERIESPARAM5, this.getSeriesParam5());
        }
        if (!bl || this.isSeriesParam6Dirty()) {
            hashMap.put(FIELD_SERIESPARAM6, this.getSeriesParam6());
        }
        if (!bl || this.isSeriesParam7Dirty()) {
            hashMap.put(FIELD_SERIESPARAM7, this.getSeriesParam7());
        }
        if (!bl || this.isSeriesParam8Dirty()) {
            hashMap.put(FIELD_SERIESPARAM8, this.getSeriesParam8());
        }
        if (!bl || this.isSeriesParam9Dirty()) {
            hashMap.put(FIELD_SERIESPARAM9, this.getSeriesParam9());
        }
        if (!bl || this.isSFPSCodeListIdDirty()) {
            hashMap.put(FIELD_SFPSCODELISTID, this.getSFPSCodeListId());
        }
        if (!bl || this.isSFPSCodeListNameDirty()) {
            hashMap.put(FIELD_SFPSCODELISTNAME, this.getSFPSCodeListName());
        }
        if (!bl || this.isSortDirDirty()) {
            hashMap.put(FIELD_SORTDIR, this.getSortDir());
        }
        if (!bl || this.isSplitNumberDirty()) {
            hashMap.put(FIELD_SPLITNUMBER, this.getSplitNumber());
        }
        if (!bl || this.isStackDirty()) {
            hashMap.put(FIELD_STACK, this.getStack());
        }
        if (!bl || this.isStartAngleDirty()) {
            hashMap.put(FIELD_STARTANGLE, this.getStartAngle());
        }
        if (!bl || this.isStepDirty()) {
            hashMap.put(FIELD_STEP, this.getStep());
        }
        if (!bl || this.isTagFieldDirty()) {
            hashMap.put(FIELD_TAGFIELD, this.getTagField());
        }
        if (!bl || this.isTimeGroupDirty()) {
            hashMap.put(FIELD_TIMEGROUP, this.getTimeGroup());
        }
        if (!bl || this.isTopPosDirty()) {
            hashMap.put(FIELD_TOPPOS, this.getTopPos());
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
        if (!bl || this.isWidthDirty()) {
            hashMap.put(FIELD_WIDTH, this.getWidth());
        }
        if (!bl || this.isXFieldDirty()) {
            hashMap.put(FIELD_XFIELD, this.getXField());
        }
        if (!bl || this.isXFPSCodeListIdDirty()) {
            hashMap.put(FIELD_XFPSCODELISTID, this.getXFPSCodeListId());
        }
        if (!bl || this.isXFPSCodeListNameDirty()) {
            hashMap.put(FIELD_XFPSCODELISTNAME, this.getXFPSCodeListName());
        }
        if (!bl || this.isXPSDEChartAxesIdDirty()) {
            hashMap.put(FIELD_XPSDECHARTAXESID, this.getXPSDEChartAxesId());
        }
        if (!bl || this.isXPSDEChartAxesNameDirty()) {
            hashMap.put(FIELD_XPSDECHARTAXESNAME, this.getXPSDEChartAxesName());
        }
        if (!bl || this.isYFieldDirty()) {
            hashMap.put(FIELD_YFIELD, this.getYField());
        }
        if (!bl || this.isYPSDEChartAxesIdDirty()) {
            hashMap.put(FIELD_YPSDECHARTAXESID, this.getYPSDEChartAxesId());
        }
        if (!bl || this.isYPSDEChartAxesNameDirty()) {
            hashMap.put(FIELD_YPSDECHARTAXESNAME, this.getYPSDEChartAxesName());
        }
        if (!bl || this.isZFieldDirty()) {
            hashMap.put(FIELD_ZFIELD, this.getZField());
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
        return PSDEChartParamBase.get(this, n);
    }

    private static Object get(PSDEChartParamBase pSDEChartParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEChartParamBase.getBarCategoryGap();
            }
            case 1: {
                return pSDEChartParamBase.getBarGap();
            }
            case 2: {
                return pSDEChartParamBase.getBarMaxWidth();
            }
            case 3: {
                return pSDEChartParamBase.getBarMinHeight();
            }
            case 4: {
                return pSDEChartParamBase.getBarMinWidth();
            }
            case 5: {
                return pSDEChartParamBase.getBarWidth();
            }
            case 6: {
                return pSDEChartParamBase.getBottomPos();
            }
            case 7: {
                return pSDEChartParamBase.getBoxWidths();
            }
            case 8: {
                return pSDEChartParamBase.getCapPSLanResId();
            }
            case 9: {
                return pSDEChartParamBase.getCapPSLanResName();
            }
            case 10: {
                return pSDEChartParamBase.getCaption();
            }
            case 11: {
                return pSDEChartParamBase.getCenter();
            }
            case 12: {
                return pSDEChartParamBase.getChartType();
            }
            case 13: {
                return pSDEChartParamBase.getClockWise();
            }
            case 14: {
                return pSDEChartParamBase.getCoordinateSystem();
            }
            case 15: {
                return pSDEChartParamBase.getCoordinateSystemId();
            }
            case 16: {
                return pSDEChartParamBase.getCreateDate();
            }
            case 17: {
                return pSDEChartParamBase.getCreateMan();
            }
            case 18: {
                return pSDEChartParamBase.getCSPSSysDynaModelId();
            }
            case 19: {
                return pSDEChartParamBase.getCSPSSysDynaModelName();
            }
            case 20: {
                return pSDEChartParamBase.getCSPSSysPFPluginId();
            }
            case 21: {
                return pSDEChartParamBase.getCSPSSysPFPluginName();
            }
            case 22: {
                return pSDEChartParamBase.getDataField();
            }
            case 23: {
                return pSDEChartParamBase.getDynaClass();
            }
            case 24: {
                return pSDEChartParamBase.getEndAngle();
            }
            case 25: {
                return pSDEChartParamBase.getExtField();
            }
            case 26: {
                return pSDEChartParamBase.getExtField2();
            }
            case 27: {
                return pSDEChartParamBase.getExtField3();
            }
            case 28: {
                return pSDEChartParamBase.getExtField4();
            }
            case 29: {
                return pSDEChartParamBase.getFunnelAlign();
            }
            case 30: {
                return pSDEChartParamBase.getHeight();
            }
            case 31: {
                return pSDEChartParamBase.getLeftPos();
            }
            case 32: {
                return pSDEChartParamBase.getMapType();
            }
            case 33: {
                return pSDEChartParamBase.getMaxSize();
            }
            case 34: {
                return pSDEChartParamBase.getMaxValue();
            }
            case 35: {
                return pSDEChartParamBase.getMemo();
            }
            case 36: {
                return pSDEChartParamBase.getMinAngle();
            }
            case 37: {
                return pSDEChartParamBase.getMinShowLabelAngle();
            }
            case 38: {
                return pSDEChartParamBase.getMinSize();
            }
            case 39: {
                return pSDEChartParamBase.getMinValue();
            }
            case 40: {
                return pSDEChartParamBase.getNavViewFilter();
            }
            case 41: {
                return pSDEChartParamBase.getNavViewParam();
            }
            case 42: {
                return pSDEChartParamBase.getOrderValue();
            }
            case 43: {
                return pSDEChartParamBase.getPSDEChartId();
            }
            case 44: {
                return pSDEChartParamBase.getPSDEChartName();
            }
            case 45: {
                return pSDEChartParamBase.getPSDEChartParamId();
            }
            case 46: {
                return pSDEChartParamBase.getPSDEChartParamName();
            }
            case 47: {
                return pSDEChartParamBase.getPSDEId();
            }
            case 48: {
                return pSDEChartParamBase.getPSDERId();
            }
            case 49: {
                return pSDEChartParamBase.getPSDERName();
            }
            case 50: {
                return pSDEChartParamBase.getPSDEViewBaseId();
            }
            case 51: {
                return pSDEChartParamBase.getPSDEViewBaseName();
            }
            case 52: {
                return pSDEChartParamBase.getPSSysDynaModelId();
            }
            case 53: {
                return pSDEChartParamBase.getPSSysDynaModelName();
            }
            case 54: {
                return pSDEChartParamBase.getPSSysPFPluginId();
            }
            case 55: {
                return pSDEChartParamBase.getPSSysPFPluginName();
            }
            case 56: {
                return pSDEChartParamBase.getRadius();
            }
            case 57: {
                return pSDEChartParamBase.getRightPos();
            }
            case 58: {
                return pSDEChartParamBase.getRoseType();
            }
            case 59: {
                return pSDEChartParamBase.getSampleData();
            }
            case 60: {
                return pSDEChartParamBase.getSeriesField();
            }
            case 61: {
                return pSDEChartParamBase.getSeriesLayoutBy();
            }
            case 62: {
                return pSDEChartParamBase.getSeriesParam();
            }
            case 63: {
                return pSDEChartParamBase.getSeriesParam10();
            }
            case 64: {
                return pSDEChartParamBase.getSeriesParam11();
            }
            case 65: {
                return pSDEChartParamBase.getSeriesParam12();
            }
            case 66: {
                return pSDEChartParamBase.getSeriesParam2();
            }
            case 67: {
                return pSDEChartParamBase.getSeriesParam3();
            }
            case 68: {
                return pSDEChartParamBase.getSeriesParam4();
            }
            case 69: {
                return pSDEChartParamBase.getSeriesParam5();
            }
            case 70: {
                return pSDEChartParamBase.getSeriesParam6();
            }
            case 71: {
                return pSDEChartParamBase.getSeriesParam7();
            }
            case 72: {
                return pSDEChartParamBase.getSeriesParam8();
            }
            case 73: {
                return pSDEChartParamBase.getSeriesParam9();
            }
            case 74: {
                return pSDEChartParamBase.getSFPSCodeListId();
            }
            case 75: {
                return pSDEChartParamBase.getSFPSCodeListName();
            }
            case 76: {
                return pSDEChartParamBase.getSortDir();
            }
            case 77: {
                return pSDEChartParamBase.getSplitNumber();
            }
            case 78: {
                return pSDEChartParamBase.getStack();
            }
            case 79: {
                return pSDEChartParamBase.getStartAngle();
            }
            case 80: {
                return pSDEChartParamBase.getStep();
            }
            case 81: {
                return pSDEChartParamBase.getTagField();
            }
            case 82: {
                return pSDEChartParamBase.getTimeGroup();
            }
            case 83: {
                return pSDEChartParamBase.getTopPos();
            }
            case 84: {
                return pSDEChartParamBase.getUpdateDate();
            }
            case 85: {
                return pSDEChartParamBase.getUpdateMan();
            }
            case 86: {
                return pSDEChartParamBase.getUserCat();
            }
            case 87: {
                return pSDEChartParamBase.getUserParams();
            }
            case 88: {
                return pSDEChartParamBase.getUserTag();
            }
            case 89: {
                return pSDEChartParamBase.getUserTag2();
            }
            case 90: {
                return pSDEChartParamBase.getUserTag3();
            }
            case 91: {
                return pSDEChartParamBase.getUserTag4();
            }
            case 92: {
                return pSDEChartParamBase.getWidth();
            }
            case 93: {
                return pSDEChartParamBase.getXField();
            }
            case 94: {
                return pSDEChartParamBase.getXFPSCodeListId();
            }
            case 95: {
                return pSDEChartParamBase.getXFPSCodeListName();
            }
            case 96: {
                return pSDEChartParamBase.getXPSDEChartAxesId();
            }
            case 97: {
                return pSDEChartParamBase.getXPSDEChartAxesName();
            }
            case 98: {
                return pSDEChartParamBase.getYField();
            }
            case 99: {
                return pSDEChartParamBase.getYPSDEChartAxesId();
            }
            case 100: {
                return pSDEChartParamBase.getYPSDEChartAxesName();
            }
            case 101: {
                return pSDEChartParamBase.getZField();
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
        PSDEChartParamBase.set(this, n, object);
    }

    private static void set(PSDEChartParamBase pSDEChartParamBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEChartParamBase.setBarCategoryGap(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEChartParamBase.setBarGap(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEChartParamBase.setBarMaxWidth(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEChartParamBase.setBarMinHeight(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEChartParamBase.setBarMinWidth(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEChartParamBase.setBarWidth(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEChartParamBase.setBottomPos(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEChartParamBase.setBoxWidths(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEChartParamBase.setCapPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEChartParamBase.setCapPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEChartParamBase.setCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEChartParamBase.setCenter(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEChartParamBase.setChartType(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEChartParamBase.setClockWise(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSDEChartParamBase.setCoordinateSystem(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEChartParamBase.setCoordinateSystemId(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSDEChartParamBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSDEChartParamBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEChartParamBase.setCSPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEChartParamBase.setCSPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEChartParamBase.setCSPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEChartParamBase.setCSPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEChartParamBase.setDataField(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEChartParamBase.setDynaClass(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEChartParamBase.setEndAngle(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSDEChartParamBase.setExtField(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEChartParamBase.setExtField2(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEChartParamBase.setExtField3(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEChartParamBase.setExtField4(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEChartParamBase.setFunnelAlign(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEChartParamBase.setHeight(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEChartParamBase.setLeftPos(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEChartParamBase.setMapType(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEChartParamBase.setMaxSize(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEChartParamBase.setMaxValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 35: {
                pSDEChartParamBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEChartParamBase.setMinAngle(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 37: {
                pSDEChartParamBase.setMinShowLabelAngle(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 38: {
                pSDEChartParamBase.setMinSize(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDEChartParamBase.setMinValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 40: {
                pSDEChartParamBase.setNavViewFilter(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDEChartParamBase.setNavViewParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDEChartParamBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 43: {
                pSDEChartParamBase.setPSDEChartId(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDEChartParamBase.setPSDEChartName(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDEChartParamBase.setPSDEChartParamId(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDEChartParamBase.setPSDEChartParamName(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDEChartParamBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDEChartParamBase.setPSDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDEChartParamBase.setPSDERName(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDEChartParamBase.setPSDEViewBaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSDEChartParamBase.setPSDEViewBaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSDEChartParamBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSDEChartParamBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSDEChartParamBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSDEChartParamBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSDEChartParamBase.setRadius(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSDEChartParamBase.setRightPos(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSDEChartParamBase.setRoseType(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSDEChartParamBase.setSampleData(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSDEChartParamBase.setSeriesField(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSDEChartParamBase.setSeriesLayoutBy(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSDEChartParamBase.setSeriesParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSDEChartParamBase.setSeriesParam10(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 64: {
                pSDEChartParamBase.setSeriesParam11(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 65: {
                pSDEChartParamBase.setSeriesParam12(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 66: {
                pSDEChartParamBase.setSeriesParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSDEChartParamBase.setSeriesParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSDEChartParamBase.setSeriesParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSDEChartParamBase.setSeriesParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 70: {
                pSDEChartParamBase.setSeriesParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 71: {
                pSDEChartParamBase.setSeriesParam7(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 72: {
                pSDEChartParamBase.setSeriesParam8(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 73: {
                pSDEChartParamBase.setSeriesParam9(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 74: {
                pSDEChartParamBase.setSFPSCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 75: {
                pSDEChartParamBase.setSFPSCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 76: {
                pSDEChartParamBase.setSortDir(DataObject.getStringValue((Object)object));
                return;
            }
            case 77: {
                pSDEChartParamBase.setSplitNumber(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 78: {
                pSDEChartParamBase.setStack(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 79: {
                pSDEChartParamBase.setStartAngle(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 80: {
                pSDEChartParamBase.setStep(DataObject.getStringValue((Object)object));
                return;
            }
            case 81: {
                pSDEChartParamBase.setTagField(DataObject.getStringValue((Object)object));
                return;
            }
            case 82: {
                pSDEChartParamBase.setTimeGroup(DataObject.getStringValue((Object)object));
                return;
            }
            case 83: {
                pSDEChartParamBase.setTopPos(DataObject.getStringValue((Object)object));
                return;
            }
            case 84: {
                pSDEChartParamBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 85: {
                pSDEChartParamBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 86: {
                pSDEChartParamBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 87: {
                pSDEChartParamBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 88: {
                pSDEChartParamBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 89: {
                pSDEChartParamBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 90: {
                pSDEChartParamBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 91: {
                pSDEChartParamBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 92: {
                pSDEChartParamBase.setWidth(DataObject.getStringValue((Object)object));
                return;
            }
            case 93: {
                pSDEChartParamBase.setXField(DataObject.getStringValue((Object)object));
                return;
            }
            case 94: {
                pSDEChartParamBase.setXFPSCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 95: {
                pSDEChartParamBase.setXFPSCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 96: {
                pSDEChartParamBase.setXPSDEChartAxesId(DataObject.getStringValue((Object)object));
                return;
            }
            case 97: {
                pSDEChartParamBase.setXPSDEChartAxesName(DataObject.getStringValue((Object)object));
                return;
            }
            case 98: {
                pSDEChartParamBase.setYField(DataObject.getStringValue((Object)object));
                return;
            }
            case 99: {
                pSDEChartParamBase.setYPSDEChartAxesId(DataObject.getStringValue((Object)object));
                return;
            }
            case 100: {
                pSDEChartParamBase.setYPSDEChartAxesName(DataObject.getStringValue((Object)object));
                return;
            }
            case 101: {
                pSDEChartParamBase.setZField(DataObject.getStringValue((Object)object));
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
        return PSDEChartParamBase.isNull(this, n);
    }

    private static boolean isNull(PSDEChartParamBase pSDEChartParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEChartParamBase.getBarCategoryGap() == null;
            }
            case 1: {
                return pSDEChartParamBase.getBarGap() == null;
            }
            case 2: {
                return pSDEChartParamBase.getBarMaxWidth() == null;
            }
            case 3: {
                return pSDEChartParamBase.getBarMinHeight() == null;
            }
            case 4: {
                return pSDEChartParamBase.getBarMinWidth() == null;
            }
            case 5: {
                return pSDEChartParamBase.getBarWidth() == null;
            }
            case 6: {
                return pSDEChartParamBase.getBottomPos() == null;
            }
            case 7: {
                return pSDEChartParamBase.getBoxWidths() == null;
            }
            case 8: {
                return pSDEChartParamBase.getCapPSLanResId() == null;
            }
            case 9: {
                return pSDEChartParamBase.getCapPSLanResName() == null;
            }
            case 10: {
                return pSDEChartParamBase.getCaption() == null;
            }
            case 11: {
                return pSDEChartParamBase.getCenter() == null;
            }
            case 12: {
                return pSDEChartParamBase.getChartType() == null;
            }
            case 13: {
                return pSDEChartParamBase.getClockWise() == null;
            }
            case 14: {
                return pSDEChartParamBase.getCoordinateSystem() == null;
            }
            case 15: {
                return pSDEChartParamBase.getCoordinateSystemId() == null;
            }
            case 16: {
                return pSDEChartParamBase.getCreateDate() == null;
            }
            case 17: {
                return pSDEChartParamBase.getCreateMan() == null;
            }
            case 18: {
                return pSDEChartParamBase.getCSPSSysDynaModelId() == null;
            }
            case 19: {
                return pSDEChartParamBase.getCSPSSysDynaModelName() == null;
            }
            case 20: {
                return pSDEChartParamBase.getCSPSSysPFPluginId() == null;
            }
            case 21: {
                return pSDEChartParamBase.getCSPSSysPFPluginName() == null;
            }
            case 22: {
                return pSDEChartParamBase.getDataField() == null;
            }
            case 23: {
                return pSDEChartParamBase.getDynaClass() == null;
            }
            case 24: {
                return pSDEChartParamBase.getEndAngle() == null;
            }
            case 25: {
                return pSDEChartParamBase.getExtField() == null;
            }
            case 26: {
                return pSDEChartParamBase.getExtField2() == null;
            }
            case 27: {
                return pSDEChartParamBase.getExtField3() == null;
            }
            case 28: {
                return pSDEChartParamBase.getExtField4() == null;
            }
            case 29: {
                return pSDEChartParamBase.getFunnelAlign() == null;
            }
            case 30: {
                return pSDEChartParamBase.getHeight() == null;
            }
            case 31: {
                return pSDEChartParamBase.getLeftPos() == null;
            }
            case 32: {
                return pSDEChartParamBase.getMapType() == null;
            }
            case 33: {
                return pSDEChartParamBase.getMaxSize() == null;
            }
            case 34: {
                return pSDEChartParamBase.getMaxValue() == null;
            }
            case 35: {
                return pSDEChartParamBase.getMemo() == null;
            }
            case 36: {
                return pSDEChartParamBase.getMinAngle() == null;
            }
            case 37: {
                return pSDEChartParamBase.getMinShowLabelAngle() == null;
            }
            case 38: {
                return pSDEChartParamBase.getMinSize() == null;
            }
            case 39: {
                return pSDEChartParamBase.getMinValue() == null;
            }
            case 40: {
                return pSDEChartParamBase.getNavViewFilter() == null;
            }
            case 41: {
                return pSDEChartParamBase.getNavViewParam() == null;
            }
            case 42: {
                return pSDEChartParamBase.getOrderValue() == null;
            }
            case 43: {
                return pSDEChartParamBase.getPSDEChartId() == null;
            }
            case 44: {
                return pSDEChartParamBase.getPSDEChartName() == null;
            }
            case 45: {
                return pSDEChartParamBase.getPSDEChartParamId() == null;
            }
            case 46: {
                return pSDEChartParamBase.getPSDEChartParamName() == null;
            }
            case 47: {
                return pSDEChartParamBase.getPSDEId() == null;
            }
            case 48: {
                return pSDEChartParamBase.getPSDERId() == null;
            }
            case 49: {
                return pSDEChartParamBase.getPSDERName() == null;
            }
            case 50: {
                return pSDEChartParamBase.getPSDEViewBaseId() == null;
            }
            case 51: {
                return pSDEChartParamBase.getPSDEViewBaseName() == null;
            }
            case 52: {
                return pSDEChartParamBase.getPSSysDynaModelId() == null;
            }
            case 53: {
                return pSDEChartParamBase.getPSSysDynaModelName() == null;
            }
            case 54: {
                return pSDEChartParamBase.getPSSysPFPluginId() == null;
            }
            case 55: {
                return pSDEChartParamBase.getPSSysPFPluginName() == null;
            }
            case 56: {
                return pSDEChartParamBase.getRadius() == null;
            }
            case 57: {
                return pSDEChartParamBase.getRightPos() == null;
            }
            case 58: {
                return pSDEChartParamBase.getRoseType() == null;
            }
            case 59: {
                return pSDEChartParamBase.getSampleData() == null;
            }
            case 60: {
                return pSDEChartParamBase.getSeriesField() == null;
            }
            case 61: {
                return pSDEChartParamBase.getSeriesLayoutBy() == null;
            }
            case 62: {
                return pSDEChartParamBase.getSeriesParam() == null;
            }
            case 63: {
                return pSDEChartParamBase.getSeriesParam10() == null;
            }
            case 64: {
                return pSDEChartParamBase.getSeriesParam11() == null;
            }
            case 65: {
                return pSDEChartParamBase.getSeriesParam12() == null;
            }
            case 66: {
                return pSDEChartParamBase.getSeriesParam2() == null;
            }
            case 67: {
                return pSDEChartParamBase.getSeriesParam3() == null;
            }
            case 68: {
                return pSDEChartParamBase.getSeriesParam4() == null;
            }
            case 69: {
                return pSDEChartParamBase.getSeriesParam5() == null;
            }
            case 70: {
                return pSDEChartParamBase.getSeriesParam6() == null;
            }
            case 71: {
                return pSDEChartParamBase.getSeriesParam7() == null;
            }
            case 72: {
                return pSDEChartParamBase.getSeriesParam8() == null;
            }
            case 73: {
                return pSDEChartParamBase.getSeriesParam9() == null;
            }
            case 74: {
                return pSDEChartParamBase.getSFPSCodeListId() == null;
            }
            case 75: {
                return pSDEChartParamBase.getSFPSCodeListName() == null;
            }
            case 76: {
                return pSDEChartParamBase.getSortDir() == null;
            }
            case 77: {
                return pSDEChartParamBase.getSplitNumber() == null;
            }
            case 78: {
                return pSDEChartParamBase.getStack() == null;
            }
            case 79: {
                return pSDEChartParamBase.getStartAngle() == null;
            }
            case 80: {
                return pSDEChartParamBase.getStep() == null;
            }
            case 81: {
                return pSDEChartParamBase.getTagField() == null;
            }
            case 82: {
                return pSDEChartParamBase.getTimeGroup() == null;
            }
            case 83: {
                return pSDEChartParamBase.getTopPos() == null;
            }
            case 84: {
                return pSDEChartParamBase.getUpdateDate() == null;
            }
            case 85: {
                return pSDEChartParamBase.getUpdateMan() == null;
            }
            case 86: {
                return pSDEChartParamBase.getUserCat() == null;
            }
            case 87: {
                return pSDEChartParamBase.getUserParams() == null;
            }
            case 88: {
                return pSDEChartParamBase.getUserTag() == null;
            }
            case 89: {
                return pSDEChartParamBase.getUserTag2() == null;
            }
            case 90: {
                return pSDEChartParamBase.getUserTag3() == null;
            }
            case 91: {
                return pSDEChartParamBase.getUserTag4() == null;
            }
            case 92: {
                return pSDEChartParamBase.getWidth() == null;
            }
            case 93: {
                return pSDEChartParamBase.getXField() == null;
            }
            case 94: {
                return pSDEChartParamBase.getXFPSCodeListId() == null;
            }
            case 95: {
                return pSDEChartParamBase.getXFPSCodeListName() == null;
            }
            case 96: {
                return pSDEChartParamBase.getXPSDEChartAxesId() == null;
            }
            case 97: {
                return pSDEChartParamBase.getXPSDEChartAxesName() == null;
            }
            case 98: {
                return pSDEChartParamBase.getYField() == null;
            }
            case 99: {
                return pSDEChartParamBase.getYPSDEChartAxesId() == null;
            }
            case 100: {
                return pSDEChartParamBase.getYPSDEChartAxesName() == null;
            }
            case 101: {
                return pSDEChartParamBase.getZField() == null;
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
        return PSDEChartParamBase.contains(this, n);
    }

    private static boolean contains(PSDEChartParamBase pSDEChartParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEChartParamBase.isBarCategoryGapDirty();
            }
            case 1: {
                return pSDEChartParamBase.isBarGapDirty();
            }
            case 2: {
                return pSDEChartParamBase.isBarMaxWidthDirty();
            }
            case 3: {
                return pSDEChartParamBase.isBarMinHeightDirty();
            }
            case 4: {
                return pSDEChartParamBase.isBarMinWidthDirty();
            }
            case 5: {
                return pSDEChartParamBase.isBarWidthDirty();
            }
            case 6: {
                return pSDEChartParamBase.isBottomPosDirty();
            }
            case 7: {
                return pSDEChartParamBase.isBoxWidthsDirty();
            }
            case 8: {
                return pSDEChartParamBase.isCapPSLanResIdDirty();
            }
            case 9: {
                return pSDEChartParamBase.isCapPSLanResNameDirty();
            }
            case 10: {
                return pSDEChartParamBase.isCaptionDirty();
            }
            case 11: {
                return pSDEChartParamBase.isCenterDirty();
            }
            case 12: {
                return pSDEChartParamBase.isChartTypeDirty();
            }
            case 13: {
                return pSDEChartParamBase.isClockWiseDirty();
            }
            case 14: {
                return pSDEChartParamBase.isCoordinateSystemDirty();
            }
            case 15: {
                return pSDEChartParamBase.isCoordinateSystemIdDirty();
            }
            case 16: {
                return pSDEChartParamBase.isCreateDateDirty();
            }
            case 17: {
                return pSDEChartParamBase.isCreateManDirty();
            }
            case 18: {
                return pSDEChartParamBase.isCSPSSysDynaModelIdDirty();
            }
            case 19: {
                return pSDEChartParamBase.isCSPSSysDynaModelNameDirty();
            }
            case 20: {
                return pSDEChartParamBase.isCSPSSysPFPluginIdDirty();
            }
            case 21: {
                return pSDEChartParamBase.isCSPSSysPFPluginNameDirty();
            }
            case 22: {
                return pSDEChartParamBase.isDataFieldDirty();
            }
            case 23: {
                return pSDEChartParamBase.isDynaClassDirty();
            }
            case 24: {
                return pSDEChartParamBase.isEndAngleDirty();
            }
            case 25: {
                return pSDEChartParamBase.isExtFieldDirty();
            }
            case 26: {
                return pSDEChartParamBase.isExtField2Dirty();
            }
            case 27: {
                return pSDEChartParamBase.isExtField3Dirty();
            }
            case 28: {
                return pSDEChartParamBase.isExtField4Dirty();
            }
            case 29: {
                return pSDEChartParamBase.isFunnelAlignDirty();
            }
            case 30: {
                return pSDEChartParamBase.isHeightDirty();
            }
            case 31: {
                return pSDEChartParamBase.isLeftPosDirty();
            }
            case 32: {
                return pSDEChartParamBase.isMapTypeDirty();
            }
            case 33: {
                return pSDEChartParamBase.isMaxSizeDirty();
            }
            case 34: {
                return pSDEChartParamBase.isMaxValueDirty();
            }
            case 35: {
                return pSDEChartParamBase.isMemoDirty();
            }
            case 36: {
                return pSDEChartParamBase.isMinAngleDirty();
            }
            case 37: {
                return pSDEChartParamBase.isMinShowLabelAngleDirty();
            }
            case 38: {
                return pSDEChartParamBase.isMinSizeDirty();
            }
            case 39: {
                return pSDEChartParamBase.isMinValueDirty();
            }
            case 40: {
                return pSDEChartParamBase.isNavViewFilterDirty();
            }
            case 41: {
                return pSDEChartParamBase.isNavViewParamDirty();
            }
            case 42: {
                return pSDEChartParamBase.isOrderValueDirty();
            }
            case 43: {
                return pSDEChartParamBase.isPSDEChartIdDirty();
            }
            case 44: {
                return pSDEChartParamBase.isPSDEChartNameDirty();
            }
            case 45: {
                return pSDEChartParamBase.isPSDEChartParamIdDirty();
            }
            case 46: {
                return pSDEChartParamBase.isPSDEChartParamNameDirty();
            }
            case 47: {
                return pSDEChartParamBase.isPSDEIdDirty();
            }
            case 48: {
                return pSDEChartParamBase.isPSDERIdDirty();
            }
            case 49: {
                return pSDEChartParamBase.isPSDERNameDirty();
            }
            case 50: {
                return pSDEChartParamBase.isPSDEViewBaseIdDirty();
            }
            case 51: {
                return pSDEChartParamBase.isPSDEViewBaseNameDirty();
            }
            case 52: {
                return pSDEChartParamBase.isPSSysDynaModelIdDirty();
            }
            case 53: {
                return pSDEChartParamBase.isPSSysDynaModelNameDirty();
            }
            case 54: {
                return pSDEChartParamBase.isPSSysPFPluginIdDirty();
            }
            case 55: {
                return pSDEChartParamBase.isPSSysPFPluginNameDirty();
            }
            case 56: {
                return pSDEChartParamBase.isRadiusDirty();
            }
            case 57: {
                return pSDEChartParamBase.isRightPosDirty();
            }
            case 58: {
                return pSDEChartParamBase.isRoseTypeDirty();
            }
            case 59: {
                return pSDEChartParamBase.isSampleDataDirty();
            }
            case 60: {
                return pSDEChartParamBase.isSeriesFieldDirty();
            }
            case 61: {
                return pSDEChartParamBase.isSeriesLayoutByDirty();
            }
            case 62: {
                return pSDEChartParamBase.isSeriesParamDirty();
            }
            case 63: {
                return pSDEChartParamBase.isSeriesParam10Dirty();
            }
            case 64: {
                return pSDEChartParamBase.isSeriesParam11Dirty();
            }
            case 65: {
                return pSDEChartParamBase.isSeriesParam12Dirty();
            }
            case 66: {
                return pSDEChartParamBase.isSeriesParam2Dirty();
            }
            case 67: {
                return pSDEChartParamBase.isSeriesParam3Dirty();
            }
            case 68: {
                return pSDEChartParamBase.isSeriesParam4Dirty();
            }
            case 69: {
                return pSDEChartParamBase.isSeriesParam5Dirty();
            }
            case 70: {
                return pSDEChartParamBase.isSeriesParam6Dirty();
            }
            case 71: {
                return pSDEChartParamBase.isSeriesParam7Dirty();
            }
            case 72: {
                return pSDEChartParamBase.isSeriesParam8Dirty();
            }
            case 73: {
                return pSDEChartParamBase.isSeriesParam9Dirty();
            }
            case 74: {
                return pSDEChartParamBase.isSFPSCodeListIdDirty();
            }
            case 75: {
                return pSDEChartParamBase.isSFPSCodeListNameDirty();
            }
            case 76: {
                return pSDEChartParamBase.isSortDirDirty();
            }
            case 77: {
                return pSDEChartParamBase.isSplitNumberDirty();
            }
            case 78: {
                return pSDEChartParamBase.isStackDirty();
            }
            case 79: {
                return pSDEChartParamBase.isStartAngleDirty();
            }
            case 80: {
                return pSDEChartParamBase.isStepDirty();
            }
            case 81: {
                return pSDEChartParamBase.isTagFieldDirty();
            }
            case 82: {
                return pSDEChartParamBase.isTimeGroupDirty();
            }
            case 83: {
                return pSDEChartParamBase.isTopPosDirty();
            }
            case 84: {
                return pSDEChartParamBase.isUpdateDateDirty();
            }
            case 85: {
                return pSDEChartParamBase.isUpdateManDirty();
            }
            case 86: {
                return pSDEChartParamBase.isUserCatDirty();
            }
            case 87: {
                return pSDEChartParamBase.isUserParamsDirty();
            }
            case 88: {
                return pSDEChartParamBase.isUserTagDirty();
            }
            case 89: {
                return pSDEChartParamBase.isUserTag2Dirty();
            }
            case 90: {
                return pSDEChartParamBase.isUserTag3Dirty();
            }
            case 91: {
                return pSDEChartParamBase.isUserTag4Dirty();
            }
            case 92: {
                return pSDEChartParamBase.isWidthDirty();
            }
            case 93: {
                return pSDEChartParamBase.isXFieldDirty();
            }
            case 94: {
                return pSDEChartParamBase.isXFPSCodeListIdDirty();
            }
            case 95: {
                return pSDEChartParamBase.isXFPSCodeListNameDirty();
            }
            case 96: {
                return pSDEChartParamBase.isXPSDEChartAxesIdDirty();
            }
            case 97: {
                return pSDEChartParamBase.isXPSDEChartAxesNameDirty();
            }
            case 98: {
                return pSDEChartParamBase.isYFieldDirty();
            }
            case 99: {
                return pSDEChartParamBase.isYPSDEChartAxesIdDirty();
            }
            case 100: {
                return pSDEChartParamBase.isYPSDEChartAxesNameDirty();
            }
            case 101: {
                return pSDEChartParamBase.isZFieldDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEChartParamBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEChartParamBase pSDEChartParamBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEChartParamBase.getBarCategoryGap() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"barcategorygap", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getBarCategoryGap()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getBarGap() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bargap", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getBarGap()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getBarMaxWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"barmaxwidth", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getBarMaxWidth()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getBarMinHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"barminheight", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getBarMinHeight()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getBarMinWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"barminwidth", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getBarMinWidth()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getBarWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"barwidth", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getBarWidth()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getBottomPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bottompos", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getBottomPos()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getBoxWidths() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"boxwidths", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getBoxWidths()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getCapPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresid", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getCapPSLanResId()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getCapPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresname", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getCapPSLanResName()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"caption", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getCaption()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getCenter() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"center", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getCenter()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getChartType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"charttype", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getChartType()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getClockWise() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clockwise", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getClockWise()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getCoordinateSystem() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"coordinatesystem", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getCoordinateSystem()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getCoordinateSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"coordinatesystemid", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getCoordinateSystemId()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getCSPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cspssysdynamodelid", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getCSPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getCSPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cspssysdynamodelname", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getCSPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getCSPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cspssyspfpluginid", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getCSPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getCSPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cspssyspfpluginname", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getCSPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getDataField() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"datafield", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getDataField()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getDynaClass() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynaclass", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getDynaClass()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getEndAngle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endangle", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getEndAngle()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getExtField() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extfield", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getExtField()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getExtField2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extfield2", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getExtField2()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getExtField3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extfield3", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getExtField3()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getExtField4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extfield4", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getExtField4()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getFunnelAlign() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"funnelalign", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getFunnelAlign()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"height", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getHeight()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getLeftPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"leftpos", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getLeftPos()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getMapType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maptype", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getMapType()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getMaxSize() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxsize", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getMaxSize()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getMaxValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxvalue", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getMaxValue()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getMinAngle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minangle", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getMinAngle()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getMinShowLabelAngle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minshowlabelangle", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getMinShowLabelAngle()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getMinSize() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minsize", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getMinSize()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getMinValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minvalue", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getMinValue()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getNavViewFilter() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewfilter", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getNavViewFilter()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getNavViewParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewparam", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getNavViewParam()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getPSDEChartId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdechartid", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getPSDEChartId()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getPSDEChartName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdechartname", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getPSDEChartName()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getPSDEChartParamId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdechartparamid", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getPSDEChartParamId()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getPSDEChartParamName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdechartparamname", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getPSDEChartParamName()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getPSDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psderid", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getPSDERId()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getPSDERName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdername", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getPSDERName()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getPSDEViewBaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbaseid", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getPSDEViewBaseId()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getPSDEViewBaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbasename", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getPSDEViewBaseName()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getRadius() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"radius", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getRadius()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getRightPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rightpos", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getRightPos()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getRoseType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rosetype", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getRoseType()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getSampleData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sampledata", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getSampleData()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getSeriesField() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"seriesfield", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getSeriesField()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getSeriesLayoutBy() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serieslayoutby", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getSeriesLayoutBy()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getSeriesParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"seriesparam", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getSeriesParam()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getSeriesParam10() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"seriesparam10", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getSeriesParam10()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getSeriesParam11() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"seriesparam11", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getSeriesParam11()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getSeriesParam12() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"seriesparam12", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getSeriesParam12()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getSeriesParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"seriesparam2", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getSeriesParam2()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getSeriesParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"seriesparam3", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getSeriesParam3()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getSeriesParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"seriesparam4", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getSeriesParam4()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getSeriesParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"seriesparam5", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getSeriesParam5()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getSeriesParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"seriesparam6", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getSeriesParam6()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getSeriesParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"seriesparam7", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getSeriesParam7()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getSeriesParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"seriesparam8", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getSeriesParam8()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getSeriesParam9() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"seriesparam9", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getSeriesParam9()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getSFPSCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sfpscodelistid", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getSFPSCodeListId()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getSFPSCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sfpscodelistname", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getSFPSCodeListName()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getSortDir() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sortdir", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getSortDir()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getSplitNumber() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"splitnumber", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getSplitNumber()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getStack() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"stack", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getStack()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getStartAngle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"startangle", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getStartAngle()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getStep() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"step", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getStep()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getTagField() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tagfield", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getTagField()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getTimeGroup() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timegroup", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getTimeGroup()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getTopPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"toppos", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getTopPos()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getUserParams()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"width", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getWidth()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getXField() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"xfield", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getXField()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getXFPSCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"xfpscodelistid", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getXFPSCodeListId()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getXFPSCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"xfpscodelistname", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getXFPSCodeListName()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getXPSDEChartAxesId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"xpsdechartaxesid", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getXPSDEChartAxesId()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getXPSDEChartAxesName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"xpsdechartaxesname", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getXPSDEChartAxesName()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getYField() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"yfield", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getYField()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getYPSDEChartAxesId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ypsdechartaxesid", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getYPSDEChartAxesId()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getYPSDEChartAxesName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ypsdechartaxesname", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getYPSDEChartAxesName()), (boolean)false);
        }
        if (bl || pSDEChartParamBase.getZField() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"zfield", (Object)PSDEChartParamBase.getJSONValue((Object)pSDEChartParamBase.getZField()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEChartParamBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEChartParamBase pSDEChartParamBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEChartParamBase.getBarCategoryGap() != null) {
            object = pSDEChartParamBase.getBarCategoryGap();
            xmlNode.setAttribute(FIELD_BARCATEGORYGAP, (String)(object == null ? "" : object));
        }
        if (bl || pSDEChartParamBase.getBarGap() != null) {
            object = pSDEChartParamBase.getBarGap();
            xmlNode.setAttribute(FIELD_BARGAP, (String)(object == null ? "" : object));
        }
        if (bl || pSDEChartParamBase.getBarMaxWidth() != null) {
            object = pSDEChartParamBase.getBarMaxWidth();
            xmlNode.setAttribute(FIELD_BARMAXWIDTH, (String)(object == null ? "" : object));
        }
        if (bl || pSDEChartParamBase.getBarMinHeight() != null) {
            object = pSDEChartParamBase.getBarMinHeight();
            xmlNode.setAttribute(FIELD_BARMINHEIGHT, (String)(object == null ? "" : object));
        }
        if (bl || pSDEChartParamBase.getBarMinWidth() != null) {
            object = pSDEChartParamBase.getBarMinWidth();
            xmlNode.setAttribute(FIELD_BARMINWIDTH, (String)(object == null ? "" : object));
        }
        if (bl || pSDEChartParamBase.getBarWidth() != null) {
            object = pSDEChartParamBase.getBarWidth();
            xmlNode.setAttribute(FIELD_BARWIDTH, (String)(object == null ? "" : object));
        }
        if (bl || pSDEChartParamBase.getBottomPos() != null) {
            object = pSDEChartParamBase.getBottomPos();
            xmlNode.setAttribute(FIELD_BOTTOMPOS, (String)(object == null ? "" : object));
        }
        if (bl || pSDEChartParamBase.getBoxWidths() != null) {
            object = pSDEChartParamBase.getBoxWidths();
            xmlNode.setAttribute(FIELD_BOXWIDTHS, (String)(object == null ? "" : object));
        }
        if (bl || pSDEChartParamBase.getCapPSLanResId() != null) {
            object = pSDEChartParamBase.getCapPSLanResId();
            xmlNode.setAttribute(FIELD_CAPPSLANRESID, (String)(object == null ? "" : object));
        }
        if (bl || pSDEChartParamBase.getCapPSLanResName() != null) {
            object = pSDEChartParamBase.getCapPSLanResName();
            xmlNode.setAttribute(FIELD_CAPPSLANRESNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEChartParamBase.getCaption() != null) {
            object = pSDEChartParamBase.getCaption();
            xmlNode.setAttribute(FIELD_CAPTION, (String)(object == null ? "" : object));
        }
        if (bl || pSDEChartParamBase.getCenter() != null) {
            object = pSDEChartParamBase.getCenter();
            xmlNode.setAttribute(FIELD_CENTER, (String)(object == null ? "" : object));
        }
        if (bl || pSDEChartParamBase.getChartType() != null) {
            object = pSDEChartParamBase.getChartType();
            xmlNode.setAttribute(FIELD_CHARTTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getClockWise() != null) {
            object = pSDEChartParamBase.getClockWise();
            xmlNode.setAttribute(FIELD_CLOCKWISE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEChartParamBase.getCoordinateSystem() != null) {
            object = pSDEChartParamBase.getCoordinateSystem();
            xmlNode.setAttribute(FIELD_COORDINATESYSTEM, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getCoordinateSystemId() != null) {
            object = pSDEChartParamBase.getCoordinateSystemId();
            xmlNode.setAttribute(FIELD_COORDINATESYSTEMID, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEChartParamBase.getCreateDate() != null) {
            object = pSDEChartParamBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEChartParamBase.getCreateMan() != null) {
            object = pSDEChartParamBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getCSPSSysDynaModelId() != null) {
            object = pSDEChartParamBase.getCSPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_CSPSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getCSPSSysDynaModelName() != null) {
            object = pSDEChartParamBase.getCSPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_CSPSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getCSPSSysPFPluginId() != null) {
            object = pSDEChartParamBase.getCSPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_CSPSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getCSPSSysPFPluginName() != null) {
            object = pSDEChartParamBase.getCSPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_CSPSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getDataField() != null) {
            object = pSDEChartParamBase.getDataField();
            xmlNode.setAttribute(FIELD_DATAFIELD, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getDynaClass() != null) {
            object = pSDEChartParamBase.getDynaClass();
            xmlNode.setAttribute(FIELD_DYNACLASS, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getEndAngle() != null) {
            object = pSDEChartParamBase.getEndAngle();
            xmlNode.setAttribute(FIELD_ENDANGLE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEChartParamBase.getExtField() != null) {
            object = pSDEChartParamBase.getExtField();
            xmlNode.setAttribute(FIELD_EXTFIELD, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getExtField2() != null) {
            object = pSDEChartParamBase.getExtField2();
            xmlNode.setAttribute(FIELD_EXTFIELD2, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getExtField3() != null) {
            object = pSDEChartParamBase.getExtField3();
            xmlNode.setAttribute(FIELD_EXTFIELD3, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getExtField4() != null) {
            object = pSDEChartParamBase.getExtField4();
            xmlNode.setAttribute(FIELD_EXTFIELD4, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getFunnelAlign() != null) {
            object = pSDEChartParamBase.getFunnelAlign();
            xmlNode.setAttribute(FIELD_FUNNELALIGN, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getHeight() != null) {
            object = pSDEChartParamBase.getHeight();
            xmlNode.setAttribute(FIELD_HEIGHT, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getLeftPos() != null) {
            object = pSDEChartParamBase.getLeftPos();
            xmlNode.setAttribute(FIELD_LEFTPOS, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getMapType() != null) {
            object = pSDEChartParamBase.getMapType();
            xmlNode.setAttribute(FIELD_MAPTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getMaxSize() != null) {
            object = pSDEChartParamBase.getMaxSize();
            xmlNode.setAttribute(FIELD_MAXSIZE, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getMaxValue() != null) {
            object = pSDEChartParamBase.getMaxValue();
            xmlNode.setAttribute(FIELD_MAXVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEChartParamBase.getMemo() != null) {
            object = pSDEChartParamBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getMinAngle() != null) {
            object = pSDEChartParamBase.getMinAngle();
            xmlNode.setAttribute(FIELD_MINANGLE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEChartParamBase.getMinShowLabelAngle() != null) {
            object = pSDEChartParamBase.getMinShowLabelAngle();
            xmlNode.setAttribute(FIELD_MINSHOWLABELANGLE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEChartParamBase.getMinSize() != null) {
            object = pSDEChartParamBase.getMinSize();
            xmlNode.setAttribute(FIELD_MINSIZE, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getMinValue() != null) {
            object = pSDEChartParamBase.getMinValue();
            xmlNode.setAttribute(FIELD_MINVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEChartParamBase.getNavViewFilter() != null) {
            object = pSDEChartParamBase.getNavViewFilter();
            xmlNode.setAttribute(FIELD_NAVVIEWFILTER, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getNavViewParam() != null) {
            object = pSDEChartParamBase.getNavViewParam();
            xmlNode.setAttribute(FIELD_NAVVIEWPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getOrderValue() != null) {
            object = pSDEChartParamBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEChartParamBase.getPSDEChartId() != null) {
            object = pSDEChartParamBase.getPSDEChartId();
            xmlNode.setAttribute(FIELD_PSDECHARTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getPSDEChartName() != null) {
            object = pSDEChartParamBase.getPSDEChartName();
            xmlNode.setAttribute(FIELD_PSDECHARTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getPSDEChartParamId() != null) {
            object = pSDEChartParamBase.getPSDEChartParamId();
            xmlNode.setAttribute(FIELD_PSDECHARTPARAMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getPSDEChartParamName() != null) {
            object = pSDEChartParamBase.getPSDEChartParamName();
            xmlNode.setAttribute(FIELD_PSDECHARTPARAMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getPSDEId() != null) {
            object = pSDEChartParamBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getPSDERId() != null) {
            object = pSDEChartParamBase.getPSDERId();
            xmlNode.setAttribute(FIELD_PSDERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getPSDERName() != null) {
            object = pSDEChartParamBase.getPSDERName();
            xmlNode.setAttribute(FIELD_PSDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getPSDEViewBaseId() != null) {
            object = pSDEChartParamBase.getPSDEViewBaseId();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getPSDEViewBaseName() != null) {
            object = pSDEChartParamBase.getPSDEViewBaseName();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getPSSysDynaModelId() != null) {
            object = pSDEChartParamBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getPSSysDynaModelName() != null) {
            object = pSDEChartParamBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getPSSysPFPluginId() != null) {
            object = pSDEChartParamBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getPSSysPFPluginName() != null) {
            object = pSDEChartParamBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getRadius() != null) {
            object = pSDEChartParamBase.getRadius();
            xmlNode.setAttribute(FIELD_RADIUS, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getRightPos() != null) {
            object = pSDEChartParamBase.getRightPos();
            xmlNode.setAttribute(FIELD_RIGHTPOS, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getRoseType() != null) {
            object = pSDEChartParamBase.getRoseType();
            xmlNode.setAttribute(FIELD_ROSETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getSampleData() != null) {
            object = pSDEChartParamBase.getSampleData();
            xmlNode.setAttribute(FIELD_SAMPLEDATA, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getSeriesField() != null) {
            object = pSDEChartParamBase.getSeriesField();
            xmlNode.setAttribute(FIELD_SERIESFIELD, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getSeriesLayoutBy() != null) {
            object = pSDEChartParamBase.getSeriesLayoutBy();
            xmlNode.setAttribute(FIELD_SERIESLAYOUTBY, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getSeriesParam() != null) {
            object = pSDEChartParamBase.getSeriesParam();
            xmlNode.setAttribute(FIELD_SERIESPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getSeriesParam10() != null) {
            object = pSDEChartParamBase.getSeriesParam10();
            xmlNode.setAttribute(FIELD_SERIESPARAM10, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEChartParamBase.getSeriesParam11() != null) {
            object = pSDEChartParamBase.getSeriesParam11();
            xmlNode.setAttribute(FIELD_SERIESPARAM11, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEChartParamBase.getSeriesParam12() != null) {
            object = pSDEChartParamBase.getSeriesParam12();
            xmlNode.setAttribute(FIELD_SERIESPARAM12, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEChartParamBase.getSeriesParam2() != null) {
            object = pSDEChartParamBase.getSeriesParam2();
            xmlNode.setAttribute(FIELD_SERIESPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getSeriesParam3() != null) {
            object = pSDEChartParamBase.getSeriesParam3();
            xmlNode.setAttribute(FIELD_SERIESPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getSeriesParam4() != null) {
            object = pSDEChartParamBase.getSeriesParam4();
            xmlNode.setAttribute(FIELD_SERIESPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getSeriesParam5() != null) {
            object = pSDEChartParamBase.getSeriesParam5();
            xmlNode.setAttribute(FIELD_SERIESPARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEChartParamBase.getSeriesParam6() != null) {
            object = pSDEChartParamBase.getSeriesParam6();
            xmlNode.setAttribute(FIELD_SERIESPARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEChartParamBase.getSeriesParam7() != null) {
            object = pSDEChartParamBase.getSeriesParam7();
            xmlNode.setAttribute(FIELD_SERIESPARAM7, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEChartParamBase.getSeriesParam8() != null) {
            object = pSDEChartParamBase.getSeriesParam8();
            xmlNode.setAttribute(FIELD_SERIESPARAM8, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEChartParamBase.getSeriesParam9() != null) {
            object = pSDEChartParamBase.getSeriesParam9();
            xmlNode.setAttribute(FIELD_SERIESPARAM9, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEChartParamBase.getSFPSCodeListId() != null) {
            object = pSDEChartParamBase.getSFPSCodeListId();
            xmlNode.setAttribute(FIELD_SFPSCODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getSFPSCodeListName() != null) {
            object = pSDEChartParamBase.getSFPSCodeListName();
            xmlNode.setAttribute(FIELD_SFPSCODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getSortDir() != null) {
            object = pSDEChartParamBase.getSortDir();
            xmlNode.setAttribute(FIELD_SORTDIR, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getSplitNumber() != null) {
            object = pSDEChartParamBase.getSplitNumber();
            xmlNode.setAttribute(FIELD_SPLITNUMBER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEChartParamBase.getStack() != null) {
            object = pSDEChartParamBase.getStack();
            xmlNode.setAttribute(FIELD_STACK, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEChartParamBase.getStartAngle() != null) {
            object = pSDEChartParamBase.getStartAngle();
            xmlNode.setAttribute(FIELD_STARTANGLE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEChartParamBase.getStep() != null) {
            object = pSDEChartParamBase.getStep();
            xmlNode.setAttribute(FIELD_STEP, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getTagField() != null) {
            object = pSDEChartParamBase.getTagField();
            xmlNode.setAttribute(FIELD_TAGFIELD, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getTimeGroup() != null) {
            object = pSDEChartParamBase.getTimeGroup();
            xmlNode.setAttribute(FIELD_TIMEGROUP, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getTopPos() != null) {
            object = pSDEChartParamBase.getTopPos();
            xmlNode.setAttribute(FIELD_TOPPOS, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getUpdateDate() != null) {
            object = pSDEChartParamBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEChartParamBase.getUpdateMan() != null) {
            object = pSDEChartParamBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getUserCat() != null) {
            object = pSDEChartParamBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getUserParams() != null) {
            object = pSDEChartParamBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getUserTag() != null) {
            object = pSDEChartParamBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getUserTag2() != null) {
            object = pSDEChartParamBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getUserTag3() != null) {
            object = pSDEChartParamBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getUserTag4() != null) {
            object = pSDEChartParamBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getWidth() != null) {
            object = pSDEChartParamBase.getWidth();
            xmlNode.setAttribute(FIELD_WIDTH, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getXField() != null) {
            object = pSDEChartParamBase.getXField();
            xmlNode.setAttribute(FIELD_XFIELD, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getXFPSCodeListId() != null) {
            object = pSDEChartParamBase.getXFPSCodeListId();
            xmlNode.setAttribute(FIELD_XFPSCODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getXFPSCodeListName() != null) {
            object = pSDEChartParamBase.getXFPSCodeListName();
            xmlNode.setAttribute(FIELD_XFPSCODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getXPSDEChartAxesId() != null) {
            object = pSDEChartParamBase.getXPSDEChartAxesId();
            xmlNode.setAttribute(FIELD_XPSDECHARTAXESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getXPSDEChartAxesName() != null) {
            object = pSDEChartParamBase.getXPSDEChartAxesName();
            xmlNode.setAttribute(FIELD_XPSDECHARTAXESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getYField() != null) {
            object = pSDEChartParamBase.getYField();
            xmlNode.setAttribute(FIELD_YFIELD, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getYPSDEChartAxesId() != null) {
            object = pSDEChartParamBase.getYPSDEChartAxesId();
            xmlNode.setAttribute(FIELD_YPSDECHARTAXESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getYPSDEChartAxesName() != null) {
            object = pSDEChartParamBase.getYPSDEChartAxesName();
            xmlNode.setAttribute(FIELD_YPSDECHARTAXESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartParamBase.getZField() != null) {
            object = pSDEChartParamBase.getZField();
            xmlNode.setAttribute(FIELD_ZFIELD, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEChartParamBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEChartParamBase pSDEChartParamBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEChartParamBase.isBarCategoryGapDirty() && (bl || pSDEChartParamBase.getBarCategoryGap() != null)) {
            iDataObject.set(FIELD_BARCATEGORYGAP, (Object)pSDEChartParamBase.getBarCategoryGap());
        }
        if (pSDEChartParamBase.isBarGapDirty() && (bl || pSDEChartParamBase.getBarGap() != null)) {
            iDataObject.set(FIELD_BARGAP, (Object)pSDEChartParamBase.getBarGap());
        }
        if (pSDEChartParamBase.isBarMaxWidthDirty() && (bl || pSDEChartParamBase.getBarMaxWidth() != null)) {
            iDataObject.set(FIELD_BARMAXWIDTH, (Object)pSDEChartParamBase.getBarMaxWidth());
        }
        if (pSDEChartParamBase.isBarMinHeightDirty() && (bl || pSDEChartParamBase.getBarMinHeight() != null)) {
            iDataObject.set(FIELD_BARMINHEIGHT, (Object)pSDEChartParamBase.getBarMinHeight());
        }
        if (pSDEChartParamBase.isBarMinWidthDirty() && (bl || pSDEChartParamBase.getBarMinWidth() != null)) {
            iDataObject.set(FIELD_BARMINWIDTH, (Object)pSDEChartParamBase.getBarMinWidth());
        }
        if (pSDEChartParamBase.isBarWidthDirty() && (bl || pSDEChartParamBase.getBarWidth() != null)) {
            iDataObject.set(FIELD_BARWIDTH, (Object)pSDEChartParamBase.getBarWidth());
        }
        if (pSDEChartParamBase.isBottomPosDirty() && (bl || pSDEChartParamBase.getBottomPos() != null)) {
            iDataObject.set(FIELD_BOTTOMPOS, (Object)pSDEChartParamBase.getBottomPos());
        }
        if (pSDEChartParamBase.isBoxWidthsDirty() && (bl || pSDEChartParamBase.getBoxWidths() != null)) {
            iDataObject.set(FIELD_BOXWIDTHS, (Object)pSDEChartParamBase.getBoxWidths());
        }
        if (pSDEChartParamBase.isCapPSLanResIdDirty() && (bl || pSDEChartParamBase.getCapPSLanResId() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESID, (Object)pSDEChartParamBase.getCapPSLanResId());
        }
        if (pSDEChartParamBase.isCapPSLanResNameDirty() && (bl || pSDEChartParamBase.getCapPSLanResName() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESNAME, (Object)pSDEChartParamBase.getCapPSLanResName());
        }
        if (pSDEChartParamBase.isCaptionDirty() && (bl || pSDEChartParamBase.getCaption() != null)) {
            iDataObject.set(FIELD_CAPTION, (Object)pSDEChartParamBase.getCaption());
        }
        if (pSDEChartParamBase.isCenterDirty() && (bl || pSDEChartParamBase.getCenter() != null)) {
            iDataObject.set(FIELD_CENTER, (Object)pSDEChartParamBase.getCenter());
        }
        if (pSDEChartParamBase.isChartTypeDirty() && (bl || pSDEChartParamBase.getChartType() != null)) {
            iDataObject.set(FIELD_CHARTTYPE, (Object)pSDEChartParamBase.getChartType());
        }
        if (pSDEChartParamBase.isClockWiseDirty() && (bl || pSDEChartParamBase.getClockWise() != null)) {
            iDataObject.set(FIELD_CLOCKWISE, (Object)pSDEChartParamBase.getClockWise());
        }
        if (pSDEChartParamBase.isCoordinateSystemDirty() && (bl || pSDEChartParamBase.getCoordinateSystem() != null)) {
            iDataObject.set(FIELD_COORDINATESYSTEM, (Object)pSDEChartParamBase.getCoordinateSystem());
        }
        if (pSDEChartParamBase.isCoordinateSystemIdDirty() && (bl || pSDEChartParamBase.getCoordinateSystemId() != null)) {
            iDataObject.set(FIELD_COORDINATESYSTEMID, (Object)pSDEChartParamBase.getCoordinateSystemId());
        }
        if (pSDEChartParamBase.isCreateDateDirty() && (bl || pSDEChartParamBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEChartParamBase.getCreateDate());
        }
        if (pSDEChartParamBase.isCreateManDirty() && (bl || pSDEChartParamBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEChartParamBase.getCreateMan());
        }
        if (pSDEChartParamBase.isCSPSSysDynaModelIdDirty() && (bl || pSDEChartParamBase.getCSPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_CSPSSYSDYNAMODELID, (Object)pSDEChartParamBase.getCSPSSysDynaModelId());
        }
        if (pSDEChartParamBase.isCSPSSysDynaModelNameDirty() && (bl || pSDEChartParamBase.getCSPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_CSPSSYSDYNAMODELNAME, (Object)pSDEChartParamBase.getCSPSSysDynaModelName());
        }
        if (pSDEChartParamBase.isCSPSSysPFPluginIdDirty() && (bl || pSDEChartParamBase.getCSPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_CSPSSYSPFPLUGINID, (Object)pSDEChartParamBase.getCSPSSysPFPluginId());
        }
        if (pSDEChartParamBase.isCSPSSysPFPluginNameDirty() && (bl || pSDEChartParamBase.getCSPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_CSPSSYSPFPLUGINNAME, (Object)pSDEChartParamBase.getCSPSSysPFPluginName());
        }
        if (pSDEChartParamBase.isDataFieldDirty() && (bl || pSDEChartParamBase.getDataField() != null)) {
            iDataObject.set(FIELD_DATAFIELD, (Object)pSDEChartParamBase.getDataField());
        }
        if (pSDEChartParamBase.isDynaClassDirty() && (bl || pSDEChartParamBase.getDynaClass() != null)) {
            iDataObject.set(FIELD_DYNACLASS, (Object)pSDEChartParamBase.getDynaClass());
        }
        if (pSDEChartParamBase.isEndAngleDirty() && (bl || pSDEChartParamBase.getEndAngle() != null)) {
            iDataObject.set(FIELD_ENDANGLE, (Object)pSDEChartParamBase.getEndAngle());
        }
        if (pSDEChartParamBase.isExtFieldDirty() && (bl || pSDEChartParamBase.getExtField() != null)) {
            iDataObject.set(FIELD_EXTFIELD, (Object)pSDEChartParamBase.getExtField());
        }
        if (pSDEChartParamBase.isExtField2Dirty() && (bl || pSDEChartParamBase.getExtField2() != null)) {
            iDataObject.set(FIELD_EXTFIELD2, (Object)pSDEChartParamBase.getExtField2());
        }
        if (pSDEChartParamBase.isExtField3Dirty() && (bl || pSDEChartParamBase.getExtField3() != null)) {
            iDataObject.set(FIELD_EXTFIELD3, (Object)pSDEChartParamBase.getExtField3());
        }
        if (pSDEChartParamBase.isExtField4Dirty() && (bl || pSDEChartParamBase.getExtField4() != null)) {
            iDataObject.set(FIELD_EXTFIELD4, (Object)pSDEChartParamBase.getExtField4());
        }
        if (pSDEChartParamBase.isFunnelAlignDirty() && (bl || pSDEChartParamBase.getFunnelAlign() != null)) {
            iDataObject.set(FIELD_FUNNELALIGN, (Object)pSDEChartParamBase.getFunnelAlign());
        }
        if (pSDEChartParamBase.isHeightDirty() && (bl || pSDEChartParamBase.getHeight() != null)) {
            iDataObject.set(FIELD_HEIGHT, (Object)pSDEChartParamBase.getHeight());
        }
        if (pSDEChartParamBase.isLeftPosDirty() && (bl || pSDEChartParamBase.getLeftPos() != null)) {
            iDataObject.set(FIELD_LEFTPOS, (Object)pSDEChartParamBase.getLeftPos());
        }
        if (pSDEChartParamBase.isMapTypeDirty() && (bl || pSDEChartParamBase.getMapType() != null)) {
            iDataObject.set(FIELD_MAPTYPE, (Object)pSDEChartParamBase.getMapType());
        }
        if (pSDEChartParamBase.isMaxSizeDirty() && (bl || pSDEChartParamBase.getMaxSize() != null)) {
            iDataObject.set(FIELD_MAXSIZE, (Object)pSDEChartParamBase.getMaxSize());
        }
        if (pSDEChartParamBase.isMaxValueDirty() && (bl || pSDEChartParamBase.getMaxValue() != null)) {
            iDataObject.set(FIELD_MAXVALUE, (Object)pSDEChartParamBase.getMaxValue());
        }
        if (pSDEChartParamBase.isMemoDirty() && (bl || pSDEChartParamBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEChartParamBase.getMemo());
        }
        if (pSDEChartParamBase.isMinAngleDirty() && (bl || pSDEChartParamBase.getMinAngle() != null)) {
            iDataObject.set(FIELD_MINANGLE, (Object)pSDEChartParamBase.getMinAngle());
        }
        if (pSDEChartParamBase.isMinShowLabelAngleDirty() && (bl || pSDEChartParamBase.getMinShowLabelAngle() != null)) {
            iDataObject.set(FIELD_MINSHOWLABELANGLE, (Object)pSDEChartParamBase.getMinShowLabelAngle());
        }
        if (pSDEChartParamBase.isMinSizeDirty() && (bl || pSDEChartParamBase.getMinSize() != null)) {
            iDataObject.set(FIELD_MINSIZE, (Object)pSDEChartParamBase.getMinSize());
        }
        if (pSDEChartParamBase.isMinValueDirty() && (bl || pSDEChartParamBase.getMinValue() != null)) {
            iDataObject.set(FIELD_MINVALUE, (Object)pSDEChartParamBase.getMinValue());
        }
        if (pSDEChartParamBase.isNavViewFilterDirty() && (bl || pSDEChartParamBase.getNavViewFilter() != null)) {
            iDataObject.set(FIELD_NAVVIEWFILTER, (Object)pSDEChartParamBase.getNavViewFilter());
        }
        if (pSDEChartParamBase.isNavViewParamDirty() && (bl || pSDEChartParamBase.getNavViewParam() != null)) {
            iDataObject.set(FIELD_NAVVIEWPARAM, (Object)pSDEChartParamBase.getNavViewParam());
        }
        if (pSDEChartParamBase.isOrderValueDirty() && (bl || pSDEChartParamBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEChartParamBase.getOrderValue());
        }
        if (pSDEChartParamBase.isPSDEChartIdDirty() && (bl || pSDEChartParamBase.getPSDEChartId() != null)) {
            iDataObject.set(FIELD_PSDECHARTID, (Object)pSDEChartParamBase.getPSDEChartId());
        }
        if (pSDEChartParamBase.isPSDEChartNameDirty() && (bl || pSDEChartParamBase.getPSDEChartName() != null)) {
            iDataObject.set(FIELD_PSDECHARTNAME, (Object)pSDEChartParamBase.getPSDEChartName());
        }
        if (pSDEChartParamBase.isPSDEChartParamIdDirty() && (bl || pSDEChartParamBase.getPSDEChartParamId() != null)) {
            iDataObject.set(FIELD_PSDECHARTPARAMID, (Object)pSDEChartParamBase.getPSDEChartParamId());
        }
        if (pSDEChartParamBase.isPSDEChartParamNameDirty() && (bl || pSDEChartParamBase.getPSDEChartParamName() != null)) {
            iDataObject.set(FIELD_PSDECHARTPARAMNAME, (Object)pSDEChartParamBase.getPSDEChartParamName());
        }
        if (pSDEChartParamBase.isPSDEIdDirty() && (bl || pSDEChartParamBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEChartParamBase.getPSDEId());
        }
        if (pSDEChartParamBase.isPSDERIdDirty() && (bl || pSDEChartParamBase.getPSDERId() != null)) {
            iDataObject.set(FIELD_PSDERID, (Object)pSDEChartParamBase.getPSDERId());
        }
        if (pSDEChartParamBase.isPSDERNameDirty() && (bl || pSDEChartParamBase.getPSDERName() != null)) {
            iDataObject.set(FIELD_PSDERNAME, (Object)pSDEChartParamBase.getPSDERName());
        }
        if (pSDEChartParamBase.isPSDEViewBaseIdDirty() && (bl || pSDEChartParamBase.getPSDEViewBaseId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASEID, (Object)pSDEChartParamBase.getPSDEViewBaseId());
        }
        if (pSDEChartParamBase.isPSDEViewBaseNameDirty() && (bl || pSDEChartParamBase.getPSDEViewBaseName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASENAME, (Object)pSDEChartParamBase.getPSDEViewBaseName());
        }
        if (pSDEChartParamBase.isPSSysDynaModelIdDirty() && (bl || pSDEChartParamBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSDEChartParamBase.getPSSysDynaModelId());
        }
        if (pSDEChartParamBase.isPSSysDynaModelNameDirty() && (bl || pSDEChartParamBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSDEChartParamBase.getPSSysDynaModelName());
        }
        if (pSDEChartParamBase.isPSSysPFPluginIdDirty() && (bl || pSDEChartParamBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSDEChartParamBase.getPSSysPFPluginId());
        }
        if (pSDEChartParamBase.isPSSysPFPluginNameDirty() && (bl || pSDEChartParamBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSDEChartParamBase.getPSSysPFPluginName());
        }
        if (pSDEChartParamBase.isRadiusDirty() && (bl || pSDEChartParamBase.getRadius() != null)) {
            iDataObject.set(FIELD_RADIUS, (Object)pSDEChartParamBase.getRadius());
        }
        if (pSDEChartParamBase.isRightPosDirty() && (bl || pSDEChartParamBase.getRightPos() != null)) {
            iDataObject.set(FIELD_RIGHTPOS, (Object)pSDEChartParamBase.getRightPos());
        }
        if (pSDEChartParamBase.isRoseTypeDirty() && (bl || pSDEChartParamBase.getRoseType() != null)) {
            iDataObject.set(FIELD_ROSETYPE, (Object)pSDEChartParamBase.getRoseType());
        }
        if (pSDEChartParamBase.isSampleDataDirty() && (bl || pSDEChartParamBase.getSampleData() != null)) {
            iDataObject.set(FIELD_SAMPLEDATA, (Object)pSDEChartParamBase.getSampleData());
        }
        if (pSDEChartParamBase.isSeriesFieldDirty() && (bl || pSDEChartParamBase.getSeriesField() != null)) {
            iDataObject.set(FIELD_SERIESFIELD, (Object)pSDEChartParamBase.getSeriesField());
        }
        if (pSDEChartParamBase.isSeriesLayoutByDirty() && (bl || pSDEChartParamBase.getSeriesLayoutBy() != null)) {
            iDataObject.set(FIELD_SERIESLAYOUTBY, (Object)pSDEChartParamBase.getSeriesLayoutBy());
        }
        if (pSDEChartParamBase.isSeriesParamDirty() && (bl || pSDEChartParamBase.getSeriesParam() != null)) {
            iDataObject.set(FIELD_SERIESPARAM, (Object)pSDEChartParamBase.getSeriesParam());
        }
        if (pSDEChartParamBase.isSeriesParam10Dirty() && (bl || pSDEChartParamBase.getSeriesParam10() != null)) {
            iDataObject.set(FIELD_SERIESPARAM10, (Object)pSDEChartParamBase.getSeriesParam10());
        }
        if (pSDEChartParamBase.isSeriesParam11Dirty() && (bl || pSDEChartParamBase.getSeriesParam11() != null)) {
            iDataObject.set(FIELD_SERIESPARAM11, (Object)pSDEChartParamBase.getSeriesParam11());
        }
        if (pSDEChartParamBase.isSeriesParam12Dirty() && (bl || pSDEChartParamBase.getSeriesParam12() != null)) {
            iDataObject.set(FIELD_SERIESPARAM12, (Object)pSDEChartParamBase.getSeriesParam12());
        }
        if (pSDEChartParamBase.isSeriesParam2Dirty() && (bl || pSDEChartParamBase.getSeriesParam2() != null)) {
            iDataObject.set(FIELD_SERIESPARAM2, (Object)pSDEChartParamBase.getSeriesParam2());
        }
        if (pSDEChartParamBase.isSeriesParam3Dirty() && (bl || pSDEChartParamBase.getSeriesParam3() != null)) {
            iDataObject.set(FIELD_SERIESPARAM3, (Object)pSDEChartParamBase.getSeriesParam3());
        }
        if (pSDEChartParamBase.isSeriesParam4Dirty() && (bl || pSDEChartParamBase.getSeriesParam4() != null)) {
            iDataObject.set(FIELD_SERIESPARAM4, (Object)pSDEChartParamBase.getSeriesParam4());
        }
        if (pSDEChartParamBase.isSeriesParam5Dirty() && (bl || pSDEChartParamBase.getSeriesParam5() != null)) {
            iDataObject.set(FIELD_SERIESPARAM5, (Object)pSDEChartParamBase.getSeriesParam5());
        }
        if (pSDEChartParamBase.isSeriesParam6Dirty() && (bl || pSDEChartParamBase.getSeriesParam6() != null)) {
            iDataObject.set(FIELD_SERIESPARAM6, (Object)pSDEChartParamBase.getSeriesParam6());
        }
        if (pSDEChartParamBase.isSeriesParam7Dirty() && (bl || pSDEChartParamBase.getSeriesParam7() != null)) {
            iDataObject.set(FIELD_SERIESPARAM7, (Object)pSDEChartParamBase.getSeriesParam7());
        }
        if (pSDEChartParamBase.isSeriesParam8Dirty() && (bl || pSDEChartParamBase.getSeriesParam8() != null)) {
            iDataObject.set(FIELD_SERIESPARAM8, (Object)pSDEChartParamBase.getSeriesParam8());
        }
        if (pSDEChartParamBase.isSeriesParam9Dirty() && (bl || pSDEChartParamBase.getSeriesParam9() != null)) {
            iDataObject.set(FIELD_SERIESPARAM9, (Object)pSDEChartParamBase.getSeriesParam9());
        }
        if (pSDEChartParamBase.isSFPSCodeListIdDirty() && (bl || pSDEChartParamBase.getSFPSCodeListId() != null)) {
            iDataObject.set(FIELD_SFPSCODELISTID, (Object)pSDEChartParamBase.getSFPSCodeListId());
        }
        if (pSDEChartParamBase.isSFPSCodeListNameDirty() && (bl || pSDEChartParamBase.getSFPSCodeListName() != null)) {
            iDataObject.set(FIELD_SFPSCODELISTNAME, (Object)pSDEChartParamBase.getSFPSCodeListName());
        }
        if (pSDEChartParamBase.isSortDirDirty() && (bl || pSDEChartParamBase.getSortDir() != null)) {
            iDataObject.set(FIELD_SORTDIR, (Object)pSDEChartParamBase.getSortDir());
        }
        if (pSDEChartParamBase.isSplitNumberDirty() && (bl || pSDEChartParamBase.getSplitNumber() != null)) {
            iDataObject.set(FIELD_SPLITNUMBER, (Object)pSDEChartParamBase.getSplitNumber());
        }
        if (pSDEChartParamBase.isStackDirty() && (bl || pSDEChartParamBase.getStack() != null)) {
            iDataObject.set(FIELD_STACK, (Object)pSDEChartParamBase.getStack());
        }
        if (pSDEChartParamBase.isStartAngleDirty() && (bl || pSDEChartParamBase.getStartAngle() != null)) {
            iDataObject.set(FIELD_STARTANGLE, (Object)pSDEChartParamBase.getStartAngle());
        }
        if (pSDEChartParamBase.isStepDirty() && (bl || pSDEChartParamBase.getStep() != null)) {
            iDataObject.set(FIELD_STEP, (Object)pSDEChartParamBase.getStep());
        }
        if (pSDEChartParamBase.isTagFieldDirty() && (bl || pSDEChartParamBase.getTagField() != null)) {
            iDataObject.set(FIELD_TAGFIELD, (Object)pSDEChartParamBase.getTagField());
        }
        if (pSDEChartParamBase.isTimeGroupDirty() && (bl || pSDEChartParamBase.getTimeGroup() != null)) {
            iDataObject.set(FIELD_TIMEGROUP, (Object)pSDEChartParamBase.getTimeGroup());
        }
        if (pSDEChartParamBase.isTopPosDirty() && (bl || pSDEChartParamBase.getTopPos() != null)) {
            iDataObject.set(FIELD_TOPPOS, (Object)pSDEChartParamBase.getTopPos());
        }
        if (pSDEChartParamBase.isUpdateDateDirty() && (bl || pSDEChartParamBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEChartParamBase.getUpdateDate());
        }
        if (pSDEChartParamBase.isUpdateManDirty() && (bl || pSDEChartParamBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEChartParamBase.getUpdateMan());
        }
        if (pSDEChartParamBase.isUserCatDirty() && (bl || pSDEChartParamBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEChartParamBase.getUserCat());
        }
        if (pSDEChartParamBase.isUserParamsDirty() && (bl || pSDEChartParamBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSDEChartParamBase.getUserParams());
        }
        if (pSDEChartParamBase.isUserTagDirty() && (bl || pSDEChartParamBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEChartParamBase.getUserTag());
        }
        if (pSDEChartParamBase.isUserTag2Dirty() && (bl || pSDEChartParamBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEChartParamBase.getUserTag2());
        }
        if (pSDEChartParamBase.isUserTag3Dirty() && (bl || pSDEChartParamBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEChartParamBase.getUserTag3());
        }
        if (pSDEChartParamBase.isUserTag4Dirty() && (bl || pSDEChartParamBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEChartParamBase.getUserTag4());
        }
        if (pSDEChartParamBase.isWidthDirty() && (bl || pSDEChartParamBase.getWidth() != null)) {
            iDataObject.set(FIELD_WIDTH, (Object)pSDEChartParamBase.getWidth());
        }
        if (pSDEChartParamBase.isXFieldDirty() && (bl || pSDEChartParamBase.getXField() != null)) {
            iDataObject.set(FIELD_XFIELD, (Object)pSDEChartParamBase.getXField());
        }
        if (pSDEChartParamBase.isXFPSCodeListIdDirty() && (bl || pSDEChartParamBase.getXFPSCodeListId() != null)) {
            iDataObject.set(FIELD_XFPSCODELISTID, (Object)pSDEChartParamBase.getXFPSCodeListId());
        }
        if (pSDEChartParamBase.isXFPSCodeListNameDirty() && (bl || pSDEChartParamBase.getXFPSCodeListName() != null)) {
            iDataObject.set(FIELD_XFPSCODELISTNAME, (Object)pSDEChartParamBase.getXFPSCodeListName());
        }
        if (pSDEChartParamBase.isXPSDEChartAxesIdDirty() && (bl || pSDEChartParamBase.getXPSDEChartAxesId() != null)) {
            iDataObject.set(FIELD_XPSDECHARTAXESID, (Object)pSDEChartParamBase.getXPSDEChartAxesId());
        }
        if (pSDEChartParamBase.isXPSDEChartAxesNameDirty() && (bl || pSDEChartParamBase.getXPSDEChartAxesName() != null)) {
            iDataObject.set(FIELD_XPSDECHARTAXESNAME, (Object)pSDEChartParamBase.getXPSDEChartAxesName());
        }
        if (pSDEChartParamBase.isYFieldDirty() && (bl || pSDEChartParamBase.getYField() != null)) {
            iDataObject.set(FIELD_YFIELD, (Object)pSDEChartParamBase.getYField());
        }
        if (pSDEChartParamBase.isYPSDEChartAxesIdDirty() && (bl || pSDEChartParamBase.getYPSDEChartAxesId() != null)) {
            iDataObject.set(FIELD_YPSDECHARTAXESID, (Object)pSDEChartParamBase.getYPSDEChartAxesId());
        }
        if (pSDEChartParamBase.isYPSDEChartAxesNameDirty() && (bl || pSDEChartParamBase.getYPSDEChartAxesName() != null)) {
            iDataObject.set(FIELD_YPSDECHARTAXESNAME, (Object)pSDEChartParamBase.getYPSDEChartAxesName());
        }
        if (pSDEChartParamBase.isZFieldDirty() && (bl || pSDEChartParamBase.getZField() != null)) {
            iDataObject.set(FIELD_ZFIELD, (Object)pSDEChartParamBase.getZField());
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
        return PSDEChartParamBase.remove(this, n);
    }

    private static boolean remove(PSDEChartParamBase pSDEChartParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEChartParamBase.resetBarCategoryGap();
                return true;
            }
            case 1: {
                pSDEChartParamBase.resetBarGap();
                return true;
            }
            case 2: {
                pSDEChartParamBase.resetBarMaxWidth();
                return true;
            }
            case 3: {
                pSDEChartParamBase.resetBarMinHeight();
                return true;
            }
            case 4: {
                pSDEChartParamBase.resetBarMinWidth();
                return true;
            }
            case 5: {
                pSDEChartParamBase.resetBarWidth();
                return true;
            }
            case 6: {
                pSDEChartParamBase.resetBottomPos();
                return true;
            }
            case 7: {
                pSDEChartParamBase.resetBoxWidths();
                return true;
            }
            case 8: {
                pSDEChartParamBase.resetCapPSLanResId();
                return true;
            }
            case 9: {
                pSDEChartParamBase.resetCapPSLanResName();
                return true;
            }
            case 10: {
                pSDEChartParamBase.resetCaption();
                return true;
            }
            case 11: {
                pSDEChartParamBase.resetCenter();
                return true;
            }
            case 12: {
                pSDEChartParamBase.resetChartType();
                return true;
            }
            case 13: {
                pSDEChartParamBase.resetClockWise();
                return true;
            }
            case 14: {
                pSDEChartParamBase.resetCoordinateSystem();
                return true;
            }
            case 15: {
                pSDEChartParamBase.resetCoordinateSystemId();
                return true;
            }
            case 16: {
                pSDEChartParamBase.resetCreateDate();
                return true;
            }
            case 17: {
                pSDEChartParamBase.resetCreateMan();
                return true;
            }
            case 18: {
                pSDEChartParamBase.resetCSPSSysDynaModelId();
                return true;
            }
            case 19: {
                pSDEChartParamBase.resetCSPSSysDynaModelName();
                return true;
            }
            case 20: {
                pSDEChartParamBase.resetCSPSSysPFPluginId();
                return true;
            }
            case 21: {
                pSDEChartParamBase.resetCSPSSysPFPluginName();
                return true;
            }
            case 22: {
                pSDEChartParamBase.resetDataField();
                return true;
            }
            case 23: {
                pSDEChartParamBase.resetDynaClass();
                return true;
            }
            case 24: {
                pSDEChartParamBase.resetEndAngle();
                return true;
            }
            case 25: {
                pSDEChartParamBase.resetExtField();
                return true;
            }
            case 26: {
                pSDEChartParamBase.resetExtField2();
                return true;
            }
            case 27: {
                pSDEChartParamBase.resetExtField3();
                return true;
            }
            case 28: {
                pSDEChartParamBase.resetExtField4();
                return true;
            }
            case 29: {
                pSDEChartParamBase.resetFunnelAlign();
                return true;
            }
            case 30: {
                pSDEChartParamBase.resetHeight();
                return true;
            }
            case 31: {
                pSDEChartParamBase.resetLeftPos();
                return true;
            }
            case 32: {
                pSDEChartParamBase.resetMapType();
                return true;
            }
            case 33: {
                pSDEChartParamBase.resetMaxSize();
                return true;
            }
            case 34: {
                pSDEChartParamBase.resetMaxValue();
                return true;
            }
            case 35: {
                pSDEChartParamBase.resetMemo();
                return true;
            }
            case 36: {
                pSDEChartParamBase.resetMinAngle();
                return true;
            }
            case 37: {
                pSDEChartParamBase.resetMinShowLabelAngle();
                return true;
            }
            case 38: {
                pSDEChartParamBase.resetMinSize();
                return true;
            }
            case 39: {
                pSDEChartParamBase.resetMinValue();
                return true;
            }
            case 40: {
                pSDEChartParamBase.resetNavViewFilter();
                return true;
            }
            case 41: {
                pSDEChartParamBase.resetNavViewParam();
                return true;
            }
            case 42: {
                pSDEChartParamBase.resetOrderValue();
                return true;
            }
            case 43: {
                pSDEChartParamBase.resetPSDEChartId();
                return true;
            }
            case 44: {
                pSDEChartParamBase.resetPSDEChartName();
                return true;
            }
            case 45: {
                pSDEChartParamBase.resetPSDEChartParamId();
                return true;
            }
            case 46: {
                pSDEChartParamBase.resetPSDEChartParamName();
                return true;
            }
            case 47: {
                pSDEChartParamBase.resetPSDEId();
                return true;
            }
            case 48: {
                pSDEChartParamBase.resetPSDERId();
                return true;
            }
            case 49: {
                pSDEChartParamBase.resetPSDERName();
                return true;
            }
            case 50: {
                pSDEChartParamBase.resetPSDEViewBaseId();
                return true;
            }
            case 51: {
                pSDEChartParamBase.resetPSDEViewBaseName();
                return true;
            }
            case 52: {
                pSDEChartParamBase.resetPSSysDynaModelId();
                return true;
            }
            case 53: {
                pSDEChartParamBase.resetPSSysDynaModelName();
                return true;
            }
            case 54: {
                pSDEChartParamBase.resetPSSysPFPluginId();
                return true;
            }
            case 55: {
                pSDEChartParamBase.resetPSSysPFPluginName();
                return true;
            }
            case 56: {
                pSDEChartParamBase.resetRadius();
                return true;
            }
            case 57: {
                pSDEChartParamBase.resetRightPos();
                return true;
            }
            case 58: {
                pSDEChartParamBase.resetRoseType();
                return true;
            }
            case 59: {
                pSDEChartParamBase.resetSampleData();
                return true;
            }
            case 60: {
                pSDEChartParamBase.resetSeriesField();
                return true;
            }
            case 61: {
                pSDEChartParamBase.resetSeriesLayoutBy();
                return true;
            }
            case 62: {
                pSDEChartParamBase.resetSeriesParam();
                return true;
            }
            case 63: {
                pSDEChartParamBase.resetSeriesParam10();
                return true;
            }
            case 64: {
                pSDEChartParamBase.resetSeriesParam11();
                return true;
            }
            case 65: {
                pSDEChartParamBase.resetSeriesParam12();
                return true;
            }
            case 66: {
                pSDEChartParamBase.resetSeriesParam2();
                return true;
            }
            case 67: {
                pSDEChartParamBase.resetSeriesParam3();
                return true;
            }
            case 68: {
                pSDEChartParamBase.resetSeriesParam4();
                return true;
            }
            case 69: {
                pSDEChartParamBase.resetSeriesParam5();
                return true;
            }
            case 70: {
                pSDEChartParamBase.resetSeriesParam6();
                return true;
            }
            case 71: {
                pSDEChartParamBase.resetSeriesParam7();
                return true;
            }
            case 72: {
                pSDEChartParamBase.resetSeriesParam8();
                return true;
            }
            case 73: {
                pSDEChartParamBase.resetSeriesParam9();
                return true;
            }
            case 74: {
                pSDEChartParamBase.resetSFPSCodeListId();
                return true;
            }
            case 75: {
                pSDEChartParamBase.resetSFPSCodeListName();
                return true;
            }
            case 76: {
                pSDEChartParamBase.resetSortDir();
                return true;
            }
            case 77: {
                pSDEChartParamBase.resetSplitNumber();
                return true;
            }
            case 78: {
                pSDEChartParamBase.resetStack();
                return true;
            }
            case 79: {
                pSDEChartParamBase.resetStartAngle();
                return true;
            }
            case 80: {
                pSDEChartParamBase.resetStep();
                return true;
            }
            case 81: {
                pSDEChartParamBase.resetTagField();
                return true;
            }
            case 82: {
                pSDEChartParamBase.resetTimeGroup();
                return true;
            }
            case 83: {
                pSDEChartParamBase.resetTopPos();
                return true;
            }
            case 84: {
                pSDEChartParamBase.resetUpdateDate();
                return true;
            }
            case 85: {
                pSDEChartParamBase.resetUpdateMan();
                return true;
            }
            case 86: {
                pSDEChartParamBase.resetUserCat();
                return true;
            }
            case 87: {
                pSDEChartParamBase.resetUserParams();
                return true;
            }
            case 88: {
                pSDEChartParamBase.resetUserTag();
                return true;
            }
            case 89: {
                pSDEChartParamBase.resetUserTag2();
                return true;
            }
            case 90: {
                pSDEChartParamBase.resetUserTag3();
                return true;
            }
            case 91: {
                pSDEChartParamBase.resetUserTag4();
                return true;
            }
            case 92: {
                pSDEChartParamBase.resetWidth();
                return true;
            }
            case 93: {
                pSDEChartParamBase.resetXField();
                return true;
            }
            case 94: {
                pSDEChartParamBase.resetXFPSCodeListId();
                return true;
            }
            case 95: {
                pSDEChartParamBase.resetXFPSCodeListName();
                return true;
            }
            case 96: {
                pSDEChartParamBase.resetXPSDEChartAxesId();
                return true;
            }
            case 97: {
                pSDEChartParamBase.resetXPSDEChartAxesName();
                return true;
            }
            case 98: {
                pSDEChartParamBase.resetYField();
                return true;
            }
            case 99: {
                pSDEChartParamBase.resetYPSDEChartAxesId();
                return true;
            }
            case 100: {
                pSDEChartParamBase.resetYPSDEChartAxesName();
                return true;
            }
            case 101: {
                pSDEChartParamBase.resetZField();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCodeList getSFPSCodeList() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSFPSCodeList();
        }
        if (this.getSFPSCodeListId() == null) {
            return null;
        }
        Integer n = this.objSFPSCodeListLock;
        synchronized (n) {
            if (this.sfpscodelist != null && DataTypeHelper.compare((int)25, (Object)this.getSFPSCodeListId(), (Object)this.sfpscodelist.getPSCodeListId()) != 0L) {
                this.sfpscodelist = null;
            }
            if (this.sfpscodelist == null) {
                PSCodeList pSCodeList = new PSCodeList();
                pSCodeList.setPSCodeListId(this.getSFPSCodeListId());
                PSCodeListService pSCodeListService = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
                pSCodeListService.autoGet(pSCodeList);
                this.sfpscodelist = pSCodeList;
            }
            return this.sfpscodelist;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCodeList getXFPSCodeList() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getXFPSCodeList();
        }
        if (this.getXFPSCodeListId() == null) {
            return null;
        }
        Integer n = this.objXFPSCodeListLock;
        synchronized (n) {
            if (this.xfpscodelist != null && DataTypeHelper.compare((int)25, (Object)this.getXFPSCodeListId(), (Object)this.xfpscodelist.getPSCodeListId()) != 0L) {
                this.xfpscodelist = null;
            }
            if (this.xfpscodelist == null) {
                PSCodeList pSCodeList = new PSCodeList();
                pSCodeList.setPSCodeListId(this.getXFPSCodeListId());
                PSCodeListService pSCodeListService = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
                pSCodeListService.autoGet(pSCodeList);
                this.xfpscodelist = pSCodeList;
            }
            return this.xfpscodelist;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEChartAxes getXPSDEChartAxes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getXPSDEChartAxes();
        }
        if (this.getXPSDEChartAxesId() == null) {
            return null;
        }
        Integer n = this.objXPSDEChartAxesLock;
        synchronized (n) {
            if (this.xpsdechartaxes != null && DataTypeHelper.compare((int)25, (Object)this.getXPSDEChartAxesId(), (Object)this.xpsdechartaxes.getPSDEChartAxesId()) != 0L) {
                this.xpsdechartaxes = null;
            }
            if (this.xpsdechartaxes == null) {
                PSDEChartAxes pSDEChartAxes = new PSDEChartAxes();
                pSDEChartAxes.setPSDEChartAxesId(this.getXPSDEChartAxesId());
                PSDEChartAxesService pSDEChartAxesService = (PSDEChartAxesService)ServiceGlobal.getService(PSDEChartAxesService.class, (SessionFactory)this.getSessionFactory());
                pSDEChartAxesService.autoGet(pSDEChartAxes);
                this.xpsdechartaxes = pSDEChartAxes;
            }
            return this.xpsdechartaxes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEChartAxes getYPSDEChartAxes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getYPSDEChartAxes();
        }
        if (this.getYPSDEChartAxesId() == null) {
            return null;
        }
        Integer n = this.objYPSDEChartAxesLock;
        synchronized (n) {
            if (this.ypsdechartaxes != null && DataTypeHelper.compare((int)25, (Object)this.getYPSDEChartAxesId(), (Object)this.ypsdechartaxes.getPSDEChartAxesId()) != 0L) {
                this.ypsdechartaxes = null;
            }
            if (this.ypsdechartaxes == null) {
                PSDEChartAxes pSDEChartAxes = new PSDEChartAxes();
                pSDEChartAxes.setPSDEChartAxesId(this.getYPSDEChartAxesId());
                PSDEChartAxesService pSDEChartAxesService = (PSDEChartAxesService)ServiceGlobal.getService(PSDEChartAxesService.class, (SessionFactory)this.getSessionFactory());
                pSDEChartAxesService.autoGet(pSDEChartAxes);
                this.ypsdechartaxes = pSDEChartAxes;
            }
            return this.ypsdechartaxes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEChart getPSDEChart() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEChart();
        }
        if (this.getPSDEChartId() == null) {
            return null;
        }
        Integer n = this.objPSDEChartLock;
        synchronized (n) {
            if (this.psdechart != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEChartId(), (Object)this.psdechart.getPSDEChartId()) != 0L) {
                this.psdechart = null;
            }
            if (this.psdechart == null) {
                PSDEChart pSDEChart = new PSDEChart();
                pSDEChart.setPSDEChartId(this.getPSDEChartId());
                PSDEChartService pSDEChartService = (PSDEChartService)ServiceGlobal.getService(PSDEChartService.class, (SessionFactory)this.getSessionFactory());
                pSDEChartService.autoGet(pSDEChart);
                this.psdechart = pSDEChart;
            }
            return this.psdechart;
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
    public PSSysDynaModel getCSPSSysDynaModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCSPSSysDynaModel();
        }
        if (this.getCSPSSysDynaModelId() == null) {
            return null;
        }
        Integer n = this.objCSPSSysDynaModelLock;
        synchronized (n) {
            if (this.cspssysdynamodel != null && DataTypeHelper.compare((int)25, (Object)this.getCSPSSysDynaModelId(), (Object)this.cspssysdynamodel.getPSSysDynaModelId()) != 0L) {
                this.cspssysdynamodel = null;
            }
            if (this.cspssysdynamodel == null) {
                PSSysDynaModel pSSysDynaModel = new PSSysDynaModel();
                pSSysDynaModel.setPSSysDynaModelId(this.getCSPSSysDynaModelId());
                PSSysDynaModelService pSSysDynaModelService = (PSSysDynaModelService)ServiceGlobal.getService(PSSysDynaModelService.class, (SessionFactory)this.getSessionFactory());
                pSSysDynaModelService.autoGet(pSSysDynaModel);
                this.cspssysdynamodel = pSSysDynaModel;
            }
            return this.cspssysdynamodel;
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
    public PSSysPFPlugin getCSPSSysPFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCSPSSysPFPlugin();
        }
        if (this.getCSPSSysPFPluginId() == null) {
            return null;
        }
        Integer n = this.objCSPSSysPFPluginLock;
        synchronized (n) {
            if (this.cspssyspfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getCSPSSysPFPluginId(), (Object)this.cspssyspfplugin.getPSSysPFPluginId()) != 0L) {
                this.cspssyspfplugin = null;
            }
            if (this.cspssyspfplugin == null) {
                PSSysPFPlugin pSSysPFPlugin = new PSSysPFPlugin();
                pSSysPFPlugin.setPSSysPFPluginId(this.getCSPSSysPFPluginId());
                PSSysPFPluginService pSSysPFPluginService = (PSSysPFPluginService)ServiceGlobal.getService(PSSysPFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysPFPluginService.autoGet(pSSysPFPlugin);
                this.cspssyspfplugin = pSSysPFPlugin;
            }
            return this.cspssyspfplugin;
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

    private PSDEChartParamBase getProxyEntity() {
        return this.proxyPSDEChartParamBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEChartParamBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEChartParamBase) {
            this.proxyPSDEChartParamBase = (PSDEChartParamBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEChartParamService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BARCATEGORYGAP, 0);
        fieldIndexMap.put(FIELD_BARGAP, 1);
        fieldIndexMap.put(FIELD_BARMAXWIDTH, 2);
        fieldIndexMap.put(FIELD_BARMINHEIGHT, 3);
        fieldIndexMap.put(FIELD_BARMINWIDTH, 4);
        fieldIndexMap.put(FIELD_BARWIDTH, 5);
        fieldIndexMap.put(FIELD_BOTTOMPOS, 6);
        fieldIndexMap.put(FIELD_BOXWIDTHS, 7);
        fieldIndexMap.put(FIELD_CAPPSLANRESID, 8);
        fieldIndexMap.put(FIELD_CAPPSLANRESNAME, 9);
        fieldIndexMap.put(FIELD_CAPTION, 10);
        fieldIndexMap.put(FIELD_CENTER, 11);
        fieldIndexMap.put(FIELD_CHARTTYPE, 12);
        fieldIndexMap.put(FIELD_CLOCKWISE, 13);
        fieldIndexMap.put(FIELD_COORDINATESYSTEM, 14);
        fieldIndexMap.put(FIELD_COORDINATESYSTEMID, 15);
        fieldIndexMap.put(FIELD_CREATEDATE, 16);
        fieldIndexMap.put(FIELD_CREATEMAN, 17);
        fieldIndexMap.put(FIELD_CSPSSYSDYNAMODELID, 18);
        fieldIndexMap.put(FIELD_CSPSSYSDYNAMODELNAME, 19);
        fieldIndexMap.put(FIELD_CSPSSYSPFPLUGINID, 20);
        fieldIndexMap.put(FIELD_CSPSSYSPFPLUGINNAME, 21);
        fieldIndexMap.put(FIELD_DATAFIELD, 22);
        fieldIndexMap.put(FIELD_DYNACLASS, 23);
        fieldIndexMap.put(FIELD_ENDANGLE, 24);
        fieldIndexMap.put(FIELD_EXTFIELD, 25);
        fieldIndexMap.put(FIELD_EXTFIELD2, 26);
        fieldIndexMap.put(FIELD_EXTFIELD3, 27);
        fieldIndexMap.put(FIELD_EXTFIELD4, 28);
        fieldIndexMap.put(FIELD_FUNNELALIGN, 29);
        fieldIndexMap.put(FIELD_HEIGHT, 30);
        fieldIndexMap.put(FIELD_LEFTPOS, 31);
        fieldIndexMap.put(FIELD_MAPTYPE, 32);
        fieldIndexMap.put(FIELD_MAXSIZE, 33);
        fieldIndexMap.put(FIELD_MAXVALUE, 34);
        fieldIndexMap.put(FIELD_MEMO, 35);
        fieldIndexMap.put(FIELD_MINANGLE, 36);
        fieldIndexMap.put(FIELD_MINSHOWLABELANGLE, 37);
        fieldIndexMap.put(FIELD_MINSIZE, 38);
        fieldIndexMap.put(FIELD_MINVALUE, 39);
        fieldIndexMap.put(FIELD_NAVVIEWFILTER, 40);
        fieldIndexMap.put(FIELD_NAVVIEWPARAM, 41);
        fieldIndexMap.put(FIELD_ORDERVALUE, 42);
        fieldIndexMap.put(FIELD_PSDECHARTID, 43);
        fieldIndexMap.put(FIELD_PSDECHARTNAME, 44);
        fieldIndexMap.put(FIELD_PSDECHARTPARAMID, 45);
        fieldIndexMap.put(FIELD_PSDECHARTPARAMNAME, 46);
        fieldIndexMap.put(FIELD_PSDEID, 47);
        fieldIndexMap.put(FIELD_PSDERID, 48);
        fieldIndexMap.put(FIELD_PSDERNAME, 49);
        fieldIndexMap.put(FIELD_PSDEVIEWBASEID, 50);
        fieldIndexMap.put(FIELD_PSDEVIEWBASENAME, 51);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 52);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 53);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 54);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 55);
        fieldIndexMap.put(FIELD_RADIUS, 56);
        fieldIndexMap.put(FIELD_RIGHTPOS, 57);
        fieldIndexMap.put(FIELD_ROSETYPE, 58);
        fieldIndexMap.put(FIELD_SAMPLEDATA, 59);
        fieldIndexMap.put(FIELD_SERIESFIELD, 60);
        fieldIndexMap.put(FIELD_SERIESLAYOUTBY, 61);
        fieldIndexMap.put(FIELD_SERIESPARAM, 62);
        fieldIndexMap.put(FIELD_SERIESPARAM10, 63);
        fieldIndexMap.put(FIELD_SERIESPARAM11, 64);
        fieldIndexMap.put(FIELD_SERIESPARAM12, 65);
        fieldIndexMap.put(FIELD_SERIESPARAM2, 66);
        fieldIndexMap.put(FIELD_SERIESPARAM3, 67);
        fieldIndexMap.put(FIELD_SERIESPARAM4, 68);
        fieldIndexMap.put(FIELD_SERIESPARAM5, 69);
        fieldIndexMap.put(FIELD_SERIESPARAM6, 70);
        fieldIndexMap.put(FIELD_SERIESPARAM7, 71);
        fieldIndexMap.put(FIELD_SERIESPARAM8, 72);
        fieldIndexMap.put(FIELD_SERIESPARAM9, 73);
        fieldIndexMap.put(FIELD_SFPSCODELISTID, 74);
        fieldIndexMap.put(FIELD_SFPSCODELISTNAME, 75);
        fieldIndexMap.put(FIELD_SORTDIR, 76);
        fieldIndexMap.put(FIELD_SPLITNUMBER, 77);
        fieldIndexMap.put(FIELD_STACK, 78);
        fieldIndexMap.put(FIELD_STARTANGLE, 79);
        fieldIndexMap.put(FIELD_STEP, 80);
        fieldIndexMap.put(FIELD_TAGFIELD, 81);
        fieldIndexMap.put(FIELD_TIMEGROUP, 82);
        fieldIndexMap.put(FIELD_TOPPOS, 83);
        fieldIndexMap.put(FIELD_UPDATEDATE, 84);
        fieldIndexMap.put(FIELD_UPDATEMAN, 85);
        fieldIndexMap.put(FIELD_USERCAT, 86);
        fieldIndexMap.put(FIELD_USERPARAMS, 87);
        fieldIndexMap.put(FIELD_USERTAG, 88);
        fieldIndexMap.put(FIELD_USERTAG2, 89);
        fieldIndexMap.put(FIELD_USERTAG3, 90);
        fieldIndexMap.put(FIELD_USERTAG4, 91);
        fieldIndexMap.put(FIELD_WIDTH, 92);
        fieldIndexMap.put(FIELD_XFIELD, 93);
        fieldIndexMap.put(FIELD_XFPSCODELISTID, 94);
        fieldIndexMap.put(FIELD_XFPSCODELISTNAME, 95);
        fieldIndexMap.put(FIELD_XPSDECHARTAXESID, 96);
        fieldIndexMap.put(FIELD_XPSDECHARTAXESNAME, 97);
        fieldIndexMap.put(FIELD_YFIELD, 98);
        fieldIndexMap.put(FIELD_YPSDECHARTAXESID, 99);
        fieldIndexMap.put(FIELD_YPSDECHARTAXESNAME, 100);
        fieldIndexMap.put(FIELD_ZFIELD, 101);
    }
}

