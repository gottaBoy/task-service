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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDRGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
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

public abstract class PSDEDRItemBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEDRItemBase.class);
    public static final String FIELD_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String FIELD_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_COUNTERID = "COUNTERID";
    public static final String FIELD_COUNTERMODE = "COUNTERMODE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DATA = "DATA";
    public static final String FIELD_DRITEMTYPE = "DRITEMTYPE";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_ENABLEMODE = "ENABLEMODE";
    public static final String FIELD_HEADERPSSYSPFPLUGINID = "HEADERPSSYSPFPLUGINID";
    public static final String FIELD_HEADERPSSYSPFPLUGINNAME = "HEADERPSSYSPFPLUGINNAME";
    public static final String FIELD_ITEMTAG = "ITEMTAG";
    public static final String FIELD_ITEMTAG2 = "ITEMTAG2";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MINORPSDEID = "MINORPSDEID";
    public static final String FIELD_NAVVIEWFILTER = "NAVVIEWFILTER";
    public static final String FIELD_NAVVIEWFILTERDESC = "NAVVIEWFILTERDESC";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PDTVIEWFLAG = "PDTVIEWFLAG";
    public static final String FIELD_PSDEDRGROUPID = "PSDEDRGROUPID";
    public static final String FIELD_PSDEDRGROUPNAME = "PSDEDRGROUPNAME";
    public static final String FIELD_PSDEDRITEMID = "PSDEDRITEMID";
    public static final String FIELD_PSDEDRITEMNAME = "PSDEDRITEMNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDEOPPRIVID = "PSDEOPPRIVID";
    public static final String FIELD_PSDEOPPRIVNAME = "PSDEOPPRIVNAME";
    public static final String FIELD_PSDERID = "PSDERID";
    public static final String FIELD_PSDERNAME = "PSDERNAME";
    public static final String FIELD_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String FIELD_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSSYSCSSID = "PSSYSCSSID";
    public static final String FIELD_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String FIELD_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String FIELD_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String FIELD_PSSYSPDTVIEWID = "PSSYSPDTVIEWID";
    public static final String FIELD_PSSYSPDTVIEWNAME = "PSSYSPDTVIEWNAME";
    public static final String FIELD_PSSYSUNIRESID = "PSSYSUNIRESID";
    public static final String FIELD_PSSYSUNIRESNAME = "PSSYSUNIRESNAME";
    public static final String FIELD_SRFSYSPUB = "SRFSYSPUB";
    public static final String FIELD_TESTCUSTOMCODE = "TESTCUSTOMCODE";
    public static final String FIELD_TESTCUSTOMMODE = "TESTCUSTOMMODE";
    public static final String FIELD_TESTPSDEACTIONID = "TESTPSDEACTIONID";
    public static final String FIELD_TESTPSDEACTIONNAME = "TESTPSDEACTIONNAME";
    public static final String FIELD_TESTPSDELOGICID = "TESTPSDELOGICID";
    public static final String FIELD_TESTPSDELOGICNAME = "TESTPSDELOGICNAME";
    public static final String FIELD_TIPPSLANRESID = "TIPPSLANRESID";
    public static final String FIELD_TIPPSLANRESNAME = "TIPPSLANRESNAME";
    public static final String FIELD_TOOLTIPINFO = "TOOLTIPINFO";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VIEWCODENAME = "VIEWCODENAME";
    public static final String FIELD_VIEWPARAMS = "VIEWPARAMS";
    public static final String FIELD_VIEWPSDEID = "VIEWPSDEID";
    private static final int INDEX_CAPPSLANRESID = 0;
    private static final int INDEX_CAPPSLANRESNAME = 1;
    private static final int INDEX_CODENAME = 2;
    private static final int INDEX_COUNTERID = 3;
    private static final int INDEX_COUNTERMODE = 4;
    private static final int INDEX_CREATEDATE = 5;
    private static final int INDEX_CREATEMAN = 6;
    private static final int INDEX_DATA = 7;
    private static final int INDEX_DRITEMTYPE = 8;
    private static final int INDEX_DYNAMODELFLAG = 9;
    private static final int INDEX_ENABLEMODE = 10;
    private static final int INDEX_HEADERPSSYSPFPLUGINID = 11;
    private static final int INDEX_HEADERPSSYSPFPLUGINNAME = 12;
    private static final int INDEX_ITEMTAG = 13;
    private static final int INDEX_ITEMTAG2 = 14;
    private static final int INDEX_LOCKFLAG = 15;
    private static final int INDEX_MEMO = 16;
    private static final int INDEX_MINORPSDEID = 17;
    private static final int INDEX_NAVVIEWFILTER = 18;
    private static final int INDEX_NAVVIEWFILTERDESC = 19;
    private static final int INDEX_ORDERVALUE = 20;
    private static final int INDEX_PDTVIEWFLAG = 21;
    private static final int INDEX_PSDEDRGROUPID = 22;
    private static final int INDEX_PSDEDRGROUPNAME = 23;
    private static final int INDEX_PSDEDRITEMID = 24;
    private static final int INDEX_PSDEDRITEMNAME = 25;
    private static final int INDEX_PSDEID = 26;
    private static final int INDEX_PSDENAME = 27;
    private static final int INDEX_PSDEOPPRIVID = 28;
    private static final int INDEX_PSDEOPPRIVNAME = 29;
    private static final int INDEX_PSDERID = 30;
    private static final int INDEX_PSDERNAME = 31;
    private static final int INDEX_PSDEVIEWBASEID = 32;
    private static final int INDEX_PSDEVIEWBASENAME = 33;
    private static final int INDEX_PSDYNAINSTID = 34;
    private static final int INDEX_PSSYSCSSID = 35;
    private static final int INDEX_PSSYSCSSNAME = 36;
    private static final int INDEX_PSSYSIMAGEID = 37;
    private static final int INDEX_PSSYSIMAGENAME = 38;
    private static final int INDEX_PSSYSPDTVIEWID = 39;
    private static final int INDEX_PSSYSPDTVIEWNAME = 40;
    private static final int INDEX_PSSYSUNIRESID = 41;
    private static final int INDEX_PSSYSUNIRESNAME = 42;
    private static final int INDEX_SRFSYSPUB = 43;
    private static final int INDEX_TESTCUSTOMCODE = 44;
    private static final int INDEX_TESTCUSTOMMODE = 45;
    private static final int INDEX_TESTPSDEACTIONID = 46;
    private static final int INDEX_TESTPSDEACTIONNAME = 47;
    private static final int INDEX_TESTPSDELOGICID = 48;
    private static final int INDEX_TESTPSDELOGICNAME = 49;
    private static final int INDEX_TIPPSLANRESID = 50;
    private static final int INDEX_TIPPSLANRESNAME = 51;
    private static final int INDEX_TOOLTIPINFO = 52;
    private static final int INDEX_UPDATEDATE = 53;
    private static final int INDEX_UPDATEMAN = 54;
    private static final int INDEX_USERCAT = 55;
    private static final int INDEX_USERTAG = 56;
    private static final int INDEX_USERTAG2 = 57;
    private static final int INDEX_USERTAG3 = 58;
    private static final int INDEX_USERTAG4 = 59;
    private static final int INDEX_VIEWCODENAME = 60;
    private static final int INDEX_VIEWPARAMS = 61;
    private static final int INDEX_VIEWPSDEID = 62;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEDRItemBase proxyPSDEDRItemBase = null;
    private boolean cappslanresidDirtyFlag = false;
    private boolean cappslanresnameDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean counteridDirtyFlag = false;
    private boolean countermodeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dataDirtyFlag = false;
    private boolean dritemtypeDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean enablemodeDirtyFlag = false;
    private boolean headerpssyspfpluginidDirtyFlag = false;
    private boolean headerpssyspfpluginnameDirtyFlag = false;
    private boolean itemtagDirtyFlag = false;
    private boolean itemtag2DirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean minorpsdeidDirtyFlag = false;
    private boolean navviewfilterDirtyFlag = false;
    private boolean navviewfilterdescDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean pdtviewflagDirtyFlag = false;
    private boolean psdedrgroupidDirtyFlag = false;
    private boolean psdedrgroupnameDirtyFlag = false;
    private boolean psdedritemidDirtyFlag = false;
    private boolean psdedritemnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdeopprividDirtyFlag = false;
    private boolean psdeopprivnameDirtyFlag = false;
    private boolean psderidDirtyFlag = false;
    private boolean psdernameDirtyFlag = false;
    private boolean psdeviewbaseidDirtyFlag = false;
    private boolean psdeviewbasenameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pssyscssidDirtyFlag = false;
    private boolean pssyscssnameDirtyFlag = false;
    private boolean pssysimageidDirtyFlag = false;
    private boolean pssysimagenameDirtyFlag = false;
    private boolean pssyspdtviewidDirtyFlag = false;
    private boolean pssyspdtviewnameDirtyFlag = false;
    private boolean pssysuniresidDirtyFlag = false;
    private boolean pssysuniresnameDirtyFlag = false;
    private boolean srfsyspubDirtyFlag = false;
    private boolean testcustomcodeDirtyFlag = false;
    private boolean testcustommodeDirtyFlag = false;
    private boolean testpsdeactionidDirtyFlag = false;
    private boolean testpsdeactionnameDirtyFlag = false;
    private boolean testpsdelogicidDirtyFlag = false;
    private boolean testpsdelogicnameDirtyFlag = false;
    private boolean tippslanresidDirtyFlag = false;
    private boolean tippslanresnameDirtyFlag = false;
    private boolean tooltipinfoDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean viewcodenameDirtyFlag = false;
    private boolean viewparamsDirtyFlag = false;
    private boolean viewpsdeidDirtyFlag = false;
    @Column(name="cappslanresid")
    private String cappslanresid;
    @Column(name="cappslanresname")
    private String cappslanresname;
    @Column(name="codename")
    private String codename;
    @Column(name="counterid")
    private String counterid;
    @Column(name="countermode")
    private Integer countermode;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="data")
    private String data;
    @Column(name="dritemtype")
    private String dritemtype;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="enablemode")
    private String enablemode;
    @Column(name="headerpssyspfpluginid")
    private String headerpssyspfpluginid;
    @Column(name="headerpssyspfpluginname")
    private String headerpssyspfpluginname;
    @Column(name="itemtag")
    private String itemtag;
    @Column(name="itemtag2")
    private String itemtag2;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="minorpsdeid")
    private String minorpsdeid;
    @Column(name="navviewfilter")
    private String navviewfilter;
    @Column(name="navviewfilterdesc")
    private String navviewfilterdesc;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="pdtviewflag")
    private Integer pdtviewflag;
    @Column(name="psdedrgroupid")
    private String psdedrgroupid;
    @Column(name="psdedrgroupname")
    private String psdedrgroupname;
    @Column(name="psdedritemid")
    private String psdedritemid;
    @Column(name="psdedritemname")
    private String psdedritemname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdeopprivid")
    private String psdeopprivid;
    @Column(name="psdeopprivname")
    private String psdeopprivname;
    @Column(name="psderid")
    private String psderid;
    @Column(name="psdername")
    private String psdername;
    @Column(name="psdeviewbaseid")
    private String psdeviewbaseid;
    @Column(name="psdeviewbasename")
    private String psdeviewbasename;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pssyscssid")
    private String pssyscssid;
    @Column(name="pssyscssname")
    private String pssyscssname;
    @Column(name="pssysimageid")
    private String pssysimageid;
    @Column(name="pssysimagename")
    private String pssysimagename;
    @Column(name="pssyspdtviewid")
    private String pssyspdtviewid;
    @Column(name="pssyspdtviewname")
    private String pssyspdtviewname;
    @Column(name="pssysuniresid")
    private String pssysuniresid;
    @Column(name="pssysuniresname")
    private String pssysuniresname;
    @Column(name="srfsyspub")
    private Integer srfsyspub;
    @Column(name="testcustomcode")
    private String testcustomcode;
    @Column(name="testcustommode")
    private Integer testcustommode;
    @Column(name="testpsdeactionid")
    private String testpsdeactionid;
    @Column(name="testpsdeactionname")
    private String testpsdeactionname;
    @Column(name="testpsdelogicid")
    private String testpsdelogicid;
    @Column(name="testpsdelogicname")
    private String testpsdelogicname;
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
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    @Column(name="viewcodename")
    private String viewcodename;
    @Column(name="viewparams")
    private String viewparams;
    @Column(name="viewpsdeid")
    private String viewpsdeid;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objTestPSDEActionLock = new Integer(1);
    private PSDEAction testpsdeaction = null;
    private Integer objPSDEDRGroupLock = new Integer(1);
    private PSDEDRGroup psdedrgroup = null;
    private Integer objTestPSDELogicLock = new Integer(1);
    private PSDELogic testpsdelogic = null;
    private Integer objPSDEOPPrivLock = new Integer(1);
    private PSDEOPPriv psdeoppriv = null;
    private Integer objPSDERLock = new Integer(1);
    private PSDER psder = null;
    private Integer objPSDEViewBaseLock = new Integer(1);
    private PSDEViewBase psdeviewbase = null;
    private Integer objCapPSLanResLock = new Integer(1);
    private PSLanguageRes cappslanres = null;
    private Integer objTipPSLanResLock = new Integer(1);
    private PSLanguageRes tippslanres = null;
    private Integer objPSSysCssLock = new Integer(1);
    private PSSysCss pssyscss = null;
    private Integer objPSSysImageLock = new Integer(1);
    private PSSysImage pssysimage = null;
    private Integer objPSSysPTDViewLock = new Integer(1);
    private PSSysPDTView pssysptdview = null;
    private Integer objHeaderPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin headerpssyspfplugin = null;
    private Integer objPSSysUniResLock = new Integer(1);
    private PSSysUniRes pssysunires = null;

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

    public void setDRItemType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDRItemType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dritemtype = string;
        this.dritemtypeDirtyFlag = true;
    }

    public String getDRItemType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDRItemType();
        }
        return this.dritemtype;
    }

    public boolean isDRItemTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDRItemTypeDirty();
        }
        return this.dritemtypeDirtyFlag;
    }

    public void resetDRItemType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDRItemType();
            return;
        }
        this.dritemtypeDirtyFlag = false;
        this.dritemtype = null;
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

    public void setEnableMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.enablemode = string;
        this.enablemodeDirtyFlag = true;
    }

    public String getEnableMode() {
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

    public void setHeaderPSSysPFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHeaderPSSysPFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.headerpssyspfpluginid = string;
        this.headerpssyspfpluginidDirtyFlag = true;
    }

    public String getHeaderPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHeaderPSSysPFPluginId();
        }
        return this.headerpssyspfpluginid;
    }

    public boolean isHeaderPSSysPFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHeaderPSSysPFPluginIdDirty();
        }
        return this.headerpssyspfpluginidDirtyFlag;
    }

    public void resetHeaderPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHeaderPSSysPFPluginId();
            return;
        }
        this.headerpssyspfpluginidDirtyFlag = false;
        this.headerpssyspfpluginid = null;
    }

    public void setHeaderPSSysPFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHeaderPSSysPFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.headerpssyspfpluginname = string;
        this.headerpssyspfpluginnameDirtyFlag = true;
    }

    public String getHeaderPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHeaderPSSysPFPluginName();
        }
        return this.headerpssyspfpluginname;
    }

    public boolean isHeaderPSSysPFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHeaderPSSysPFPluginNameDirty();
        }
        return this.headerpssyspfpluginnameDirtyFlag;
    }

    public void resetHeaderPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHeaderPSSysPFPluginName();
            return;
        }
        this.headerpssyspfpluginnameDirtyFlag = false;
        this.headerpssyspfpluginname = null;
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

    public void setMinorPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorpsdeid = string;
        this.minorpsdeidDirtyFlag = true;
    }

    public String getMinorPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSDEId();
        }
        return this.minorpsdeid;
    }

    public boolean isMinorPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorPSDEIdDirty();
        }
        return this.minorpsdeidDirtyFlag;
    }

    public void resetMinorPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorPSDEId();
            return;
        }
        this.minorpsdeidDirtyFlag = false;
        this.minorpsdeid = null;
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

    public void setPDTViewFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPDTViewFlag(n);
            return;
        }
        this.pdtviewflag = n;
        this.pdtviewflagDirtyFlag = true;
    }

    public Integer getPDTViewFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPDTViewFlag();
        }
        return this.pdtviewflag;
    }

    public boolean isPDTViewFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPDTViewFlagDirty();
        }
        return this.pdtviewflagDirtyFlag;
    }

    public void resetPDTViewFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPDTViewFlag();
            return;
        }
        this.pdtviewflagDirtyFlag = false;
        this.pdtviewflag = null;
    }

    public void setPSDEDRGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDRGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedrgroupid = string;
        this.psdedrgroupidDirtyFlag = true;
    }

    public String getPSDEDRGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDRGroupId();
        }
        return this.psdedrgroupid;
    }

    public boolean isPSDEDRGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDRGroupIdDirty();
        }
        return this.psdedrgroupidDirtyFlag;
    }

    public void resetPSDEDRGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDRGroupId();
            return;
        }
        this.psdedrgroupidDirtyFlag = false;
        this.psdedrgroupid = null;
    }

    public void setPSDEDRGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDRGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedrgroupname = string;
        this.psdedrgroupnameDirtyFlag = true;
    }

    public String getPSDEDRGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDRGroupName();
        }
        return this.psdedrgroupname;
    }

    public boolean isPSDEDRGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDRGroupNameDirty();
        }
        return this.psdedrgroupnameDirtyFlag;
    }

    public void resetPSDEDRGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDRGroupName();
            return;
        }
        this.psdedrgroupnameDirtyFlag = false;
        this.psdedrgroupname = null;
    }

    public void setPSDEDRItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDRItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedritemid = string;
        this.psdedritemidDirtyFlag = true;
    }

    public String getPSDEDRItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDRItemId();
        }
        return this.psdedritemid;
    }

    public boolean isPSDEDRItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDRItemIdDirty();
        }
        return this.psdedritemidDirtyFlag;
    }

    public void resetPSDEDRItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDRItemId();
            return;
        }
        this.psdedritemidDirtyFlag = false;
        this.psdedritemid = null;
    }

    public void setPSDEDRItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDRItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedritemname = string;
        this.psdedritemnameDirtyFlag = true;
    }

    public String getPSDEDRItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDRItemName();
        }
        return this.psdedritemname;
    }

    public boolean isPSDEDRItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDRItemNameDirty();
        }
        return this.psdedritemnameDirtyFlag;
    }

    public void resetPSDEDRItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDRItemName();
            return;
        }
        this.psdedritemnameDirtyFlag = false;
        this.psdedritemname = null;
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

    public void setPSDEOPPrivId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEOPPrivId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeopprivid = string;
        this.psdeopprividDirtyFlag = true;
    }

    public String getPSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEOPPrivId();
        }
        return this.psdeopprivid;
    }

    public boolean isPSDEOPPrivIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEOPPrivIdDirty();
        }
        return this.psdeopprividDirtyFlag;
    }

    public void resetPSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEOPPrivId();
            return;
        }
        this.psdeopprividDirtyFlag = false;
        this.psdeopprivid = null;
    }

    public void setPSDEOPPrivName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEOPPrivName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeopprivname = string;
        this.psdeopprivnameDirtyFlag = true;
    }

    public String getPSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEOPPrivName();
        }
        return this.psdeopprivname;
    }

    public boolean isPSDEOPPrivNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEOPPrivNameDirty();
        }
        return this.psdeopprivnameDirtyFlag;
    }

    public void resetPSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEOPPrivName();
            return;
        }
        this.psdeopprivnameDirtyFlag = false;
        this.psdeopprivname = null;
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

    public void setPSSysPDTViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPDTViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspdtviewid = string;
        this.pssyspdtviewidDirtyFlag = true;
    }

    public String getPSSysPDTViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPDTViewId();
        }
        return this.pssyspdtviewid;
    }

    public boolean isPSSysPDTViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPDTViewIdDirty();
        }
        return this.pssyspdtviewidDirtyFlag;
    }

    public void resetPSSysPDTViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPDTViewId();
            return;
        }
        this.pssyspdtviewidDirtyFlag = false;
        this.pssyspdtviewid = null;
    }

    public void setPSSysPDTViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPDTViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspdtviewname = string;
        this.pssyspdtviewnameDirtyFlag = true;
    }

    public String getPSSysPDTViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPDTViewName();
        }
        return this.pssyspdtviewname;
    }

    public boolean isPSSysPDTViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPDTViewNameDirty();
        }
        return this.pssyspdtviewnameDirtyFlag;
    }

    public void resetPSSysPDTViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPDTViewName();
            return;
        }
        this.pssyspdtviewnameDirtyFlag = false;
        this.pssyspdtviewname = null;
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

    public void setSRFSysPub(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSRFSysPub(n);
            return;
        }
        this.srfsyspub = n;
        this.srfsyspubDirtyFlag = true;
    }

    public Integer getSRFSysPub() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSRFSysPub();
        }
        return this.srfsyspub;
    }

    public boolean isSRFSysPubDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSRFSysPubDirty();
        }
        return this.srfsyspubDirtyFlag;
    }

    public void resetSRFSysPub() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSRFSysPub();
            return;
        }
        this.srfsyspubDirtyFlag = false;
        this.srfsyspub = null;
    }

    public void setTestCustomCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTestCustomCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.testcustomcode = string;
        this.testcustomcodeDirtyFlag = true;
    }

    public String getTestCustomCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTestCustomCode();
        }
        return this.testcustomcode;
    }

    public boolean isTestCustomCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTestCustomCodeDirty();
        }
        return this.testcustomcodeDirtyFlag;
    }

    public void resetTestCustomCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTestCustomCode();
            return;
        }
        this.testcustomcodeDirtyFlag = false;
        this.testcustomcode = null;
    }

    public void setTestCustomMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTestCustomMode(n);
            return;
        }
        this.testcustommode = n;
        this.testcustommodeDirtyFlag = true;
    }

    public Integer getTestCustomMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTestCustomMode();
        }
        return this.testcustommode;
    }

    public boolean isTestCustomModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTestCustomModeDirty();
        }
        return this.testcustommodeDirtyFlag;
    }

    public void resetTestCustomMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTestCustomMode();
            return;
        }
        this.testcustommodeDirtyFlag = false;
        this.testcustommode = null;
    }

    public void setTestPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTestPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.testpsdeactionid = string;
        this.testpsdeactionidDirtyFlag = true;
    }

    public String getTestPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTestPSDEActionId();
        }
        return this.testpsdeactionid;
    }

    public boolean isTestPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTestPSDEActionIdDirty();
        }
        return this.testpsdeactionidDirtyFlag;
    }

    public void resetTestPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTestPSDEActionId();
            return;
        }
        this.testpsdeactionidDirtyFlag = false;
        this.testpsdeactionid = null;
    }

    public void setTestPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTestPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.testpsdeactionname = string;
        this.testpsdeactionnameDirtyFlag = true;
    }

    public String getTestPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTestPSDEActionName();
        }
        return this.testpsdeactionname;
    }

    public boolean isTestPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTestPSDEActionNameDirty();
        }
        return this.testpsdeactionnameDirtyFlag;
    }

    public void resetTestPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTestPSDEActionName();
            return;
        }
        this.testpsdeactionnameDirtyFlag = false;
        this.testpsdeactionname = null;
    }

    public void setTestPSDELogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTestPSDELogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.testpsdelogicid = string;
        this.testpsdelogicidDirtyFlag = true;
    }

    public String getTestPSDELogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTestPSDELogicId();
        }
        return this.testpsdelogicid;
    }

    public boolean isTestPSDELogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTestPSDELogicIdDirty();
        }
        return this.testpsdelogicidDirtyFlag;
    }

    public void resetTestPSDELogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTestPSDELogicId();
            return;
        }
        this.testpsdelogicidDirtyFlag = false;
        this.testpsdelogicid = null;
    }

    public void setTestPSDELogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTestPSDELogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.testpsdelogicname = string;
        this.testpsdelogicnameDirtyFlag = true;
    }

    public String getTestPSDELogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTestPSDELogicName();
        }
        return this.testpsdelogicname;
    }

    public boolean isTestPSDELogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTestPSDELogicNameDirty();
        }
        return this.testpsdelogicnameDirtyFlag;
    }

    public void resetTestPSDELogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTestPSDELogicName();
            return;
        }
        this.testpsdelogicnameDirtyFlag = false;
        this.testpsdelogicname = null;
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

    public void setViewCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewcodename = string;
        this.viewcodenameDirtyFlag = true;
    }

    public String getViewCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewCodeName();
        }
        return this.viewcodename;
    }

    public boolean isViewCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewCodeNameDirty();
        }
        return this.viewcodenameDirtyFlag;
    }

    public void resetViewCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewCodeName();
            return;
        }
        this.viewcodenameDirtyFlag = false;
        this.viewcodename = null;
    }

    public void setViewParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewparams = string;
        this.viewparamsDirtyFlag = true;
    }

    public String getViewParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewParams();
        }
        return this.viewparams;
    }

    public boolean isViewParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewParamsDirty();
        }
        return this.viewparamsDirtyFlag;
    }

    public void resetViewParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewParams();
            return;
        }
        this.viewparamsDirtyFlag = false;
        this.viewparams = null;
    }

    public void setViewPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewpsdeid = string;
        this.viewpsdeidDirtyFlag = true;
    }

    public String getViewPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewPSDEId();
        }
        return this.viewpsdeid;
    }

    public boolean isViewPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewPSDEIdDirty();
        }
        return this.viewpsdeidDirtyFlag;
    }

    public void resetViewPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewPSDEId();
            return;
        }
        this.viewpsdeidDirtyFlag = false;
        this.viewpsdeid = null;
    }

    protected void onReset() {
        PSDEDRItemBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEDRItemBase pSDEDRItemBase) {
        pSDEDRItemBase.resetCapPSLanResId();
        pSDEDRItemBase.resetCapPSLanResName();
        pSDEDRItemBase.resetCodeName();
        pSDEDRItemBase.resetCounterId();
        pSDEDRItemBase.resetCounterMode();
        pSDEDRItemBase.resetCreateDate();
        pSDEDRItemBase.resetCreateMan();
        pSDEDRItemBase.resetData();
        pSDEDRItemBase.resetDRItemType();
        pSDEDRItemBase.resetDynaModelFlag();
        pSDEDRItemBase.resetEnableMode();
        pSDEDRItemBase.resetHeaderPSSysPFPluginId();
        pSDEDRItemBase.resetHeaderPSSysPFPluginName();
        pSDEDRItemBase.resetItemTag();
        pSDEDRItemBase.resetItemTag2();
        pSDEDRItemBase.resetLockFlag();
        pSDEDRItemBase.resetMemo();
        pSDEDRItemBase.resetMinorPSDEId();
        pSDEDRItemBase.resetNavViewFilter();
        pSDEDRItemBase.resetNavViewFilterDesc();
        pSDEDRItemBase.resetOrderValue();
        pSDEDRItemBase.resetPDTViewFlag();
        pSDEDRItemBase.resetPSDEDRGroupId();
        pSDEDRItemBase.resetPSDEDRGroupName();
        pSDEDRItemBase.resetPSDEDRItemId();
        pSDEDRItemBase.resetPSDEDRItemName();
        pSDEDRItemBase.resetPSDEId();
        pSDEDRItemBase.resetPSDEName();
        pSDEDRItemBase.resetPSDEOPPrivId();
        pSDEDRItemBase.resetPSDEOPPrivName();
        pSDEDRItemBase.resetPSDERId();
        pSDEDRItemBase.resetPSDERName();
        pSDEDRItemBase.resetPSDEViewBaseId();
        pSDEDRItemBase.resetPSDEViewBaseName();
        pSDEDRItemBase.resetPSDynaInstId();
        pSDEDRItemBase.resetPSSysCssId();
        pSDEDRItemBase.resetPSSysCssName();
        pSDEDRItemBase.resetPSSysImageId();
        pSDEDRItemBase.resetPSSysImageName();
        pSDEDRItemBase.resetPSSysPDTViewId();
        pSDEDRItemBase.resetPSSysPDTViewName();
        pSDEDRItemBase.resetPSSysUniResId();
        pSDEDRItemBase.resetPSSysUniResName();
        pSDEDRItemBase.resetSRFSysPub();
        pSDEDRItemBase.resetTestCustomCode();
        pSDEDRItemBase.resetTestCustomMode();
        pSDEDRItemBase.resetTestPSDEActionId();
        pSDEDRItemBase.resetTestPSDEActionName();
        pSDEDRItemBase.resetTestPSDELogicId();
        pSDEDRItemBase.resetTestPSDELogicName();
        pSDEDRItemBase.resetTipPSLanResId();
        pSDEDRItemBase.resetTipPSLanResName();
        pSDEDRItemBase.resetTooltipInfo();
        pSDEDRItemBase.resetUpdateDate();
        pSDEDRItemBase.resetUpdateMan();
        pSDEDRItemBase.resetUserCat();
        pSDEDRItemBase.resetUserTag();
        pSDEDRItemBase.resetUserTag2();
        pSDEDRItemBase.resetUserTag3();
        pSDEDRItemBase.resetUserTag4();
        pSDEDRItemBase.resetViewCodeName();
        pSDEDRItemBase.resetViewParams();
        pSDEDRItemBase.resetViewPSDEId();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCapPSLanResIdDirty()) {
            hashMap.put(FIELD_CAPPSLANRESID, this.getCapPSLanResId());
        }
        if (!bl || this.isCapPSLanResNameDirty()) {
            hashMap.put(FIELD_CAPPSLANRESNAME, this.getCapPSLanResName());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
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
        if (!bl || this.isDataDirty()) {
            hashMap.put(FIELD_DATA, this.getData());
        }
        if (!bl || this.isDRItemTypeDirty()) {
            hashMap.put(FIELD_DRITEMTYPE, this.getDRItemType());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isEnableModeDirty()) {
            hashMap.put(FIELD_ENABLEMODE, this.getEnableMode());
        }
        if (!bl || this.isHeaderPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_HEADERPSSYSPFPLUGINID, this.getHeaderPSSysPFPluginId());
        }
        if (!bl || this.isHeaderPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_HEADERPSSYSPFPLUGINNAME, this.getHeaderPSSysPFPluginName());
        }
        if (!bl || this.isItemTagDirty()) {
            hashMap.put(FIELD_ITEMTAG, this.getItemTag());
        }
        if (!bl || this.isItemTag2Dirty()) {
            hashMap.put(FIELD_ITEMTAG2, this.getItemTag2());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMinorPSDEIdDirty()) {
            hashMap.put(FIELD_MINORPSDEID, this.getMinorPSDEId());
        }
        if (!bl || this.isNavViewFilterDirty()) {
            hashMap.put(FIELD_NAVVIEWFILTER, this.getNavViewFilter());
        }
        if (!bl || this.isNavViewFilterDescDirty()) {
            hashMap.put(FIELD_NAVVIEWFILTERDESC, this.getNavViewFilterDesc());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPDTViewFlagDirty()) {
            hashMap.put(FIELD_PDTVIEWFLAG, this.getPDTViewFlag());
        }
        if (!bl || this.isPSDEDRGroupIdDirty()) {
            hashMap.put(FIELD_PSDEDRGROUPID, this.getPSDEDRGroupId());
        }
        if (!bl || this.isPSDEDRGroupNameDirty()) {
            hashMap.put(FIELD_PSDEDRGROUPNAME, this.getPSDEDRGroupName());
        }
        if (!bl || this.isPSDEDRItemIdDirty()) {
            hashMap.put(FIELD_PSDEDRITEMID, this.getPSDEDRItemId());
        }
        if (!bl || this.isPSDEDRItemNameDirty()) {
            hashMap.put(FIELD_PSDEDRITEMNAME, this.getPSDEDRItemName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDEOPPrivIdDirty()) {
            hashMap.put(FIELD_PSDEOPPRIVID, this.getPSDEOPPrivId());
        }
        if (!bl || this.isPSDEOPPrivNameDirty()) {
            hashMap.put(FIELD_PSDEOPPRIVNAME, this.getPSDEOPPrivName());
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
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
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
        if (!bl || this.isPSSysPDTViewIdDirty()) {
            hashMap.put(FIELD_PSSYSPDTVIEWID, this.getPSSysPDTViewId());
        }
        if (!bl || this.isPSSysPDTViewNameDirty()) {
            hashMap.put(FIELD_PSSYSPDTVIEWNAME, this.getPSSysPDTViewName());
        }
        if (!bl || this.isPSSysUniResIdDirty()) {
            hashMap.put(FIELD_PSSYSUNIRESID, this.getPSSysUniResId());
        }
        if (!bl || this.isPSSysUniResNameDirty()) {
            hashMap.put(FIELD_PSSYSUNIRESNAME, this.getPSSysUniResName());
        }
        if (!bl || this.isSRFSysPubDirty()) {
            hashMap.put(FIELD_SRFSYSPUB, this.getSRFSysPub());
        }
        if (!bl || this.isTestCustomCodeDirty()) {
            hashMap.put(FIELD_TESTCUSTOMCODE, this.getTestCustomCode());
        }
        if (!bl || this.isTestCustomModeDirty()) {
            hashMap.put(FIELD_TESTCUSTOMMODE, this.getTestCustomMode());
        }
        if (!bl || this.isTestPSDEActionIdDirty()) {
            hashMap.put(FIELD_TESTPSDEACTIONID, this.getTestPSDEActionId());
        }
        if (!bl || this.isTestPSDEActionNameDirty()) {
            hashMap.put(FIELD_TESTPSDEACTIONNAME, this.getTestPSDEActionName());
        }
        if (!bl || this.isTestPSDELogicIdDirty()) {
            hashMap.put(FIELD_TESTPSDELOGICID, this.getTestPSDELogicId());
        }
        if (!bl || this.isTestPSDELogicNameDirty()) {
            hashMap.put(FIELD_TESTPSDELOGICNAME, this.getTestPSDELogicName());
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
        if (!bl || this.isViewCodeNameDirty()) {
            hashMap.put(FIELD_VIEWCODENAME, this.getViewCodeName());
        }
        if (!bl || this.isViewParamsDirty()) {
            hashMap.put(FIELD_VIEWPARAMS, this.getViewParams());
        }
        if (!bl || this.isViewPSDEIdDirty()) {
            hashMap.put(FIELD_VIEWPSDEID, this.getViewPSDEId());
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
        return PSDEDRItemBase.get(this, n);
    }

    private static Object get(PSDEDRItemBase pSDEDRItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDRItemBase.getCapPSLanResId();
            }
            case 1: {
                return pSDEDRItemBase.getCapPSLanResName();
            }
            case 2: {
                return pSDEDRItemBase.getCodeName();
            }
            case 3: {
                return pSDEDRItemBase.getCounterId();
            }
            case 4: {
                return pSDEDRItemBase.getCounterMode();
            }
            case 5: {
                return pSDEDRItemBase.getCreateDate();
            }
            case 6: {
                return pSDEDRItemBase.getCreateMan();
            }
            case 7: {
                return pSDEDRItemBase.getData();
            }
            case 8: {
                return pSDEDRItemBase.getDRItemType();
            }
            case 9: {
                return pSDEDRItemBase.getDynaModelFlag();
            }
            case 10: {
                return pSDEDRItemBase.getEnableMode();
            }
            case 11: {
                return pSDEDRItemBase.getHeaderPSSysPFPluginId();
            }
            case 12: {
                return pSDEDRItemBase.getHeaderPSSysPFPluginName();
            }
            case 13: {
                return pSDEDRItemBase.getItemTag();
            }
            case 14: {
                return pSDEDRItemBase.getItemTag2();
            }
            case 15: {
                return pSDEDRItemBase.getLockFlag();
            }
            case 16: {
                return pSDEDRItemBase.getMemo();
            }
            case 17: {
                return pSDEDRItemBase.getMinorPSDEId();
            }
            case 18: {
                return pSDEDRItemBase.getNavViewFilter();
            }
            case 19: {
                return pSDEDRItemBase.getNavViewFilterDesc();
            }
            case 20: {
                return pSDEDRItemBase.getOrderValue();
            }
            case 21: {
                return pSDEDRItemBase.getPDTViewFlag();
            }
            case 22: {
                return pSDEDRItemBase.getPSDEDRGroupId();
            }
            case 23: {
                return pSDEDRItemBase.getPSDEDRGroupName();
            }
            case 24: {
                return pSDEDRItemBase.getPSDEDRItemId();
            }
            case 25: {
                return pSDEDRItemBase.getPSDEDRItemName();
            }
            case 26: {
                return pSDEDRItemBase.getPSDEId();
            }
            case 27: {
                return pSDEDRItemBase.getPSDEName();
            }
            case 28: {
                return pSDEDRItemBase.getPSDEOPPrivId();
            }
            case 29: {
                return pSDEDRItemBase.getPSDEOPPrivName();
            }
            case 30: {
                return pSDEDRItemBase.getPSDERId();
            }
            case 31: {
                return pSDEDRItemBase.getPSDERName();
            }
            case 32: {
                return pSDEDRItemBase.getPSDEViewBaseId();
            }
            case 33: {
                return pSDEDRItemBase.getPSDEViewBaseName();
            }
            case 34: {
                return pSDEDRItemBase.getPSDynaInstId();
            }
            case 35: {
                return pSDEDRItemBase.getPSSysCssId();
            }
            case 36: {
                return pSDEDRItemBase.getPSSysCssName();
            }
            case 37: {
                return pSDEDRItemBase.getPSSysImageId();
            }
            case 38: {
                return pSDEDRItemBase.getPSSysImageName();
            }
            case 39: {
                return pSDEDRItemBase.getPSSysPDTViewId();
            }
            case 40: {
                return pSDEDRItemBase.getPSSysPDTViewName();
            }
            case 41: {
                return pSDEDRItemBase.getPSSysUniResId();
            }
            case 42: {
                return pSDEDRItemBase.getPSSysUniResName();
            }
            case 43: {
                return pSDEDRItemBase.getSRFSysPub();
            }
            case 44: {
                return pSDEDRItemBase.getTestCustomCode();
            }
            case 45: {
                return pSDEDRItemBase.getTestCustomMode();
            }
            case 46: {
                return pSDEDRItemBase.getTestPSDEActionId();
            }
            case 47: {
                return pSDEDRItemBase.getTestPSDEActionName();
            }
            case 48: {
                return pSDEDRItemBase.getTestPSDELogicId();
            }
            case 49: {
                return pSDEDRItemBase.getTestPSDELogicName();
            }
            case 50: {
                return pSDEDRItemBase.getTipPSLanResId();
            }
            case 51: {
                return pSDEDRItemBase.getTipPSLanResName();
            }
            case 52: {
                return pSDEDRItemBase.getTooltipInfo();
            }
            case 53: {
                return pSDEDRItemBase.getUpdateDate();
            }
            case 54: {
                return pSDEDRItemBase.getUpdateMan();
            }
            case 55: {
                return pSDEDRItemBase.getUserCat();
            }
            case 56: {
                return pSDEDRItemBase.getUserTag();
            }
            case 57: {
                return pSDEDRItemBase.getUserTag2();
            }
            case 58: {
                return pSDEDRItemBase.getUserTag3();
            }
            case 59: {
                return pSDEDRItemBase.getUserTag4();
            }
            case 60: {
                return pSDEDRItemBase.getViewCodeName();
            }
            case 61: {
                return pSDEDRItemBase.getViewParams();
            }
            case 62: {
                return pSDEDRItemBase.getViewPSDEId();
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
        PSDEDRItemBase.set(this, n, object);
    }

    private static void set(PSDEDRItemBase pSDEDRItemBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEDRItemBase.setCapPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEDRItemBase.setCapPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEDRItemBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEDRItemBase.setCounterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEDRItemBase.setCounterMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDEDRItemBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSDEDRItemBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEDRItemBase.setData(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEDRItemBase.setDRItemType(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEDRItemBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSDEDRItemBase.setEnableMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEDRItemBase.setHeaderPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEDRItemBase.setHeaderPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEDRItemBase.setItemTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEDRItemBase.setItemTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEDRItemBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSDEDRItemBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEDRItemBase.setMinorPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEDRItemBase.setNavViewFilter(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEDRItemBase.setNavViewFilterDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEDRItemBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSDEDRItemBase.setPDTViewFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSDEDRItemBase.setPSDEDRGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEDRItemBase.setPSDEDRGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEDRItemBase.setPSDEDRItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEDRItemBase.setPSDEDRItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEDRItemBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEDRItemBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEDRItemBase.setPSDEOPPrivId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEDRItemBase.setPSDEOPPrivName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEDRItemBase.setPSDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEDRItemBase.setPSDERName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEDRItemBase.setPSDEViewBaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEDRItemBase.setPSDEViewBaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEDRItemBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEDRItemBase.setPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEDRItemBase.setPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDEDRItemBase.setPSSysImageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEDRItemBase.setPSSysImageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDEDRItemBase.setPSSysPDTViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDEDRItemBase.setPSSysPDTViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDEDRItemBase.setPSSysUniResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDEDRItemBase.setPSSysUniResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDEDRItemBase.setSRFSysPub(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 44: {
                pSDEDRItemBase.setTestCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDEDRItemBase.setTestCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 46: {
                pSDEDRItemBase.setTestPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDEDRItemBase.setTestPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDEDRItemBase.setTestPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDEDRItemBase.setTestPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDEDRItemBase.setTipPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSDEDRItemBase.setTipPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSDEDRItemBase.setTooltipInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSDEDRItemBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 54: {
                pSDEDRItemBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSDEDRItemBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSDEDRItemBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSDEDRItemBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSDEDRItemBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSDEDRItemBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSDEDRItemBase.setViewCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSDEDRItemBase.setViewParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSDEDRItemBase.setViewPSDEId(DataObject.getStringValue((Object)object));
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
        return PSDEDRItemBase.isNull(this, n);
    }

    private static boolean isNull(PSDEDRItemBase pSDEDRItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDRItemBase.getCapPSLanResId() == null;
            }
            case 1: {
                return pSDEDRItemBase.getCapPSLanResName() == null;
            }
            case 2: {
                return pSDEDRItemBase.getCodeName() == null;
            }
            case 3: {
                return pSDEDRItemBase.getCounterId() == null;
            }
            case 4: {
                return pSDEDRItemBase.getCounterMode() == null;
            }
            case 5: {
                return pSDEDRItemBase.getCreateDate() == null;
            }
            case 6: {
                return pSDEDRItemBase.getCreateMan() == null;
            }
            case 7: {
                return pSDEDRItemBase.getData() == null;
            }
            case 8: {
                return pSDEDRItemBase.getDRItemType() == null;
            }
            case 9: {
                return pSDEDRItemBase.getDynaModelFlag() == null;
            }
            case 10: {
                return pSDEDRItemBase.getEnableMode() == null;
            }
            case 11: {
                return pSDEDRItemBase.getHeaderPSSysPFPluginId() == null;
            }
            case 12: {
                return pSDEDRItemBase.getHeaderPSSysPFPluginName() == null;
            }
            case 13: {
                return pSDEDRItemBase.getItemTag() == null;
            }
            case 14: {
                return pSDEDRItemBase.getItemTag2() == null;
            }
            case 15: {
                return pSDEDRItemBase.getLockFlag() == null;
            }
            case 16: {
                return pSDEDRItemBase.getMemo() == null;
            }
            case 17: {
                return pSDEDRItemBase.getMinorPSDEId() == null;
            }
            case 18: {
                return pSDEDRItemBase.getNavViewFilter() == null;
            }
            case 19: {
                return pSDEDRItemBase.getNavViewFilterDesc() == null;
            }
            case 20: {
                return pSDEDRItemBase.getOrderValue() == null;
            }
            case 21: {
                return pSDEDRItemBase.getPDTViewFlag() == null;
            }
            case 22: {
                return pSDEDRItemBase.getPSDEDRGroupId() == null;
            }
            case 23: {
                return pSDEDRItemBase.getPSDEDRGroupName() == null;
            }
            case 24: {
                return pSDEDRItemBase.getPSDEDRItemId() == null;
            }
            case 25: {
                return pSDEDRItemBase.getPSDEDRItemName() == null;
            }
            case 26: {
                return pSDEDRItemBase.getPSDEId() == null;
            }
            case 27: {
                return pSDEDRItemBase.getPSDEName() == null;
            }
            case 28: {
                return pSDEDRItemBase.getPSDEOPPrivId() == null;
            }
            case 29: {
                return pSDEDRItemBase.getPSDEOPPrivName() == null;
            }
            case 30: {
                return pSDEDRItemBase.getPSDERId() == null;
            }
            case 31: {
                return pSDEDRItemBase.getPSDERName() == null;
            }
            case 32: {
                return pSDEDRItemBase.getPSDEViewBaseId() == null;
            }
            case 33: {
                return pSDEDRItemBase.getPSDEViewBaseName() == null;
            }
            case 34: {
                return pSDEDRItemBase.getPSDynaInstId() == null;
            }
            case 35: {
                return pSDEDRItemBase.getPSSysCssId() == null;
            }
            case 36: {
                return pSDEDRItemBase.getPSSysCssName() == null;
            }
            case 37: {
                return pSDEDRItemBase.getPSSysImageId() == null;
            }
            case 38: {
                return pSDEDRItemBase.getPSSysImageName() == null;
            }
            case 39: {
                return pSDEDRItemBase.getPSSysPDTViewId() == null;
            }
            case 40: {
                return pSDEDRItemBase.getPSSysPDTViewName() == null;
            }
            case 41: {
                return pSDEDRItemBase.getPSSysUniResId() == null;
            }
            case 42: {
                return pSDEDRItemBase.getPSSysUniResName() == null;
            }
            case 43: {
                return pSDEDRItemBase.getSRFSysPub() == null;
            }
            case 44: {
                return pSDEDRItemBase.getTestCustomCode() == null;
            }
            case 45: {
                return pSDEDRItemBase.getTestCustomMode() == null;
            }
            case 46: {
                return pSDEDRItemBase.getTestPSDEActionId() == null;
            }
            case 47: {
                return pSDEDRItemBase.getTestPSDEActionName() == null;
            }
            case 48: {
                return pSDEDRItemBase.getTestPSDELogicId() == null;
            }
            case 49: {
                return pSDEDRItemBase.getTestPSDELogicName() == null;
            }
            case 50: {
                return pSDEDRItemBase.getTipPSLanResId() == null;
            }
            case 51: {
                return pSDEDRItemBase.getTipPSLanResName() == null;
            }
            case 52: {
                return pSDEDRItemBase.getTooltipInfo() == null;
            }
            case 53: {
                return pSDEDRItemBase.getUpdateDate() == null;
            }
            case 54: {
                return pSDEDRItemBase.getUpdateMan() == null;
            }
            case 55: {
                return pSDEDRItemBase.getUserCat() == null;
            }
            case 56: {
                return pSDEDRItemBase.getUserTag() == null;
            }
            case 57: {
                return pSDEDRItemBase.getUserTag2() == null;
            }
            case 58: {
                return pSDEDRItemBase.getUserTag3() == null;
            }
            case 59: {
                return pSDEDRItemBase.getUserTag4() == null;
            }
            case 60: {
                return pSDEDRItemBase.getViewCodeName() == null;
            }
            case 61: {
                return pSDEDRItemBase.getViewParams() == null;
            }
            case 62: {
                return pSDEDRItemBase.getViewPSDEId() == null;
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
        return PSDEDRItemBase.contains(this, n);
    }

    private static boolean contains(PSDEDRItemBase pSDEDRItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDRItemBase.isCapPSLanResIdDirty();
            }
            case 1: {
                return pSDEDRItemBase.isCapPSLanResNameDirty();
            }
            case 2: {
                return pSDEDRItemBase.isCodeNameDirty();
            }
            case 3: {
                return pSDEDRItemBase.isCounterIdDirty();
            }
            case 4: {
                return pSDEDRItemBase.isCounterModeDirty();
            }
            case 5: {
                return pSDEDRItemBase.isCreateDateDirty();
            }
            case 6: {
                return pSDEDRItemBase.isCreateManDirty();
            }
            case 7: {
                return pSDEDRItemBase.isDataDirty();
            }
            case 8: {
                return pSDEDRItemBase.isDRItemTypeDirty();
            }
            case 9: {
                return pSDEDRItemBase.isDynaModelFlagDirty();
            }
            case 10: {
                return pSDEDRItemBase.isEnableModeDirty();
            }
            case 11: {
                return pSDEDRItemBase.isHeaderPSSysPFPluginIdDirty();
            }
            case 12: {
                return pSDEDRItemBase.isHeaderPSSysPFPluginNameDirty();
            }
            case 13: {
                return pSDEDRItemBase.isItemTagDirty();
            }
            case 14: {
                return pSDEDRItemBase.isItemTag2Dirty();
            }
            case 15: {
                return pSDEDRItemBase.isLockFlagDirty();
            }
            case 16: {
                return pSDEDRItemBase.isMemoDirty();
            }
            case 17: {
                return pSDEDRItemBase.isMinorPSDEIdDirty();
            }
            case 18: {
                return pSDEDRItemBase.isNavViewFilterDirty();
            }
            case 19: {
                return pSDEDRItemBase.isNavViewFilterDescDirty();
            }
            case 20: {
                return pSDEDRItemBase.isOrderValueDirty();
            }
            case 21: {
                return pSDEDRItemBase.isPDTViewFlagDirty();
            }
            case 22: {
                return pSDEDRItemBase.isPSDEDRGroupIdDirty();
            }
            case 23: {
                return pSDEDRItemBase.isPSDEDRGroupNameDirty();
            }
            case 24: {
                return pSDEDRItemBase.isPSDEDRItemIdDirty();
            }
            case 25: {
                return pSDEDRItemBase.isPSDEDRItemNameDirty();
            }
            case 26: {
                return pSDEDRItemBase.isPSDEIdDirty();
            }
            case 27: {
                return pSDEDRItemBase.isPSDENameDirty();
            }
            case 28: {
                return pSDEDRItemBase.isPSDEOPPrivIdDirty();
            }
            case 29: {
                return pSDEDRItemBase.isPSDEOPPrivNameDirty();
            }
            case 30: {
                return pSDEDRItemBase.isPSDERIdDirty();
            }
            case 31: {
                return pSDEDRItemBase.isPSDERNameDirty();
            }
            case 32: {
                return pSDEDRItemBase.isPSDEViewBaseIdDirty();
            }
            case 33: {
                return pSDEDRItemBase.isPSDEViewBaseNameDirty();
            }
            case 34: {
                return pSDEDRItemBase.isPSDynaInstIdDirty();
            }
            case 35: {
                return pSDEDRItemBase.isPSSysCssIdDirty();
            }
            case 36: {
                return pSDEDRItemBase.isPSSysCssNameDirty();
            }
            case 37: {
                return pSDEDRItemBase.isPSSysImageIdDirty();
            }
            case 38: {
                return pSDEDRItemBase.isPSSysImageNameDirty();
            }
            case 39: {
                return pSDEDRItemBase.isPSSysPDTViewIdDirty();
            }
            case 40: {
                return pSDEDRItemBase.isPSSysPDTViewNameDirty();
            }
            case 41: {
                return pSDEDRItemBase.isPSSysUniResIdDirty();
            }
            case 42: {
                return pSDEDRItemBase.isPSSysUniResNameDirty();
            }
            case 43: {
                return pSDEDRItemBase.isSRFSysPubDirty();
            }
            case 44: {
                return pSDEDRItemBase.isTestCustomCodeDirty();
            }
            case 45: {
                return pSDEDRItemBase.isTestCustomModeDirty();
            }
            case 46: {
                return pSDEDRItemBase.isTestPSDEActionIdDirty();
            }
            case 47: {
                return pSDEDRItemBase.isTestPSDEActionNameDirty();
            }
            case 48: {
                return pSDEDRItemBase.isTestPSDELogicIdDirty();
            }
            case 49: {
                return pSDEDRItemBase.isTestPSDELogicNameDirty();
            }
            case 50: {
                return pSDEDRItemBase.isTipPSLanResIdDirty();
            }
            case 51: {
                return pSDEDRItemBase.isTipPSLanResNameDirty();
            }
            case 52: {
                return pSDEDRItemBase.isTooltipInfoDirty();
            }
            case 53: {
                return pSDEDRItemBase.isUpdateDateDirty();
            }
            case 54: {
                return pSDEDRItemBase.isUpdateManDirty();
            }
            case 55: {
                return pSDEDRItemBase.isUserCatDirty();
            }
            case 56: {
                return pSDEDRItemBase.isUserTagDirty();
            }
            case 57: {
                return pSDEDRItemBase.isUserTag2Dirty();
            }
            case 58: {
                return pSDEDRItemBase.isUserTag3Dirty();
            }
            case 59: {
                return pSDEDRItemBase.isUserTag4Dirty();
            }
            case 60: {
                return pSDEDRItemBase.isViewCodeNameDirty();
            }
            case 61: {
                return pSDEDRItemBase.isViewParamsDirty();
            }
            case 62: {
                return pSDEDRItemBase.isViewPSDEIdDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEDRItemBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEDRItemBase pSDEDRItemBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEDRItemBase.getCapPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresid", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getCapPSLanResId()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getCapPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresname", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getCapPSLanResName()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getCounterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"counterid", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getCounterId()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getCounterMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"countermode", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getCounterMode()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"data", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getData()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getDRItemType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dritemtype", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getDRItemType()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getEnableMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablemode", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getEnableMode()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getHeaderPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"headerpssyspfpluginid", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getHeaderPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getHeaderPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"headerpssyspfpluginname", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getHeaderPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getItemTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemtag", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getItemTag()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getItemTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemtag2", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getItemTag2()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getMinorPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorpsdeid", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getMinorPSDEId()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getNavViewFilter() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewfilter", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getNavViewFilter()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getNavViewFilterDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewfilterdesc", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getNavViewFilterDesc()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getPDTViewFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pdtviewflag", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getPDTViewFlag()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getPSDEDRGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedrgroupid", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getPSDEDRGroupId()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getPSDEDRGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedrgroupname", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getPSDEDRGroupName()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getPSDEDRItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedritemid", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getPSDEDRItemId()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getPSDEDRItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedritemname", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getPSDEDRItemName()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getPSDEOPPrivId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeopprivid", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getPSDEOPPrivId()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getPSDEOPPrivName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeopprivname", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getPSDEOPPrivName()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getPSDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psderid", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getPSDERId()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getPSDERName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdername", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getPSDERName()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getPSDEViewBaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbaseid", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getPSDEViewBaseId()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getPSDEViewBaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbasename", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getPSDEViewBaseName()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssid", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getPSSysCssId()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssname", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getPSSysCssName()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getPSSysImageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimageid", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getPSSysImageId()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getPSSysImageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimagename", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getPSSysImageName()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getPSSysPDTViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspdtviewid", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getPSSysPDTViewId()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getPSSysPDTViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspdtviewname", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getPSSysPDTViewName()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getPSSysUniResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuniresid", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getPSSysUniResId()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getPSSysUniResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuniresname", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getPSSysUniResName()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getSRFSysPub() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srfsyspub", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getSRFSysPub()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getTestCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"testcustomcode", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getTestCustomCode()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getTestCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"testcustommode", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getTestCustomMode()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getTestPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"testpsdeactionid", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getTestPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getTestPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"testpsdeactionname", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getTestPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getTestPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"testpsdelogicid", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getTestPSDELogicId()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getTestPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"testpsdelogicname", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getTestPSDELogicName()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getTipPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tippslanresid", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getTipPSLanResId()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getTipPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tippslanresname", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getTipPSLanResName()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getTooltipInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tooltipinfo", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getTooltipInfo()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getViewCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewcodename", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getViewCodeName()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getViewParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparams", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getViewParams()), (boolean)false);
        }
        if (bl || pSDEDRItemBase.getViewPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewpsdeid", (Object)PSDEDRItemBase.getJSONValue((Object)pSDEDRItemBase.getViewPSDEId()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEDRItemBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEDRItemBase pSDEDRItemBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEDRItemBase.getCapPSLanResId() != null) {
            object = pSDEDRItemBase.getCapPSLanResId();
            xmlNode.setAttribute(FIELD_CAPPSLANRESID, (String)(object == null ? "" : object));
        }
        if (bl || pSDEDRItemBase.getCapPSLanResName() != null) {
            object = pSDEDRItemBase.getCapPSLanResName();
            xmlNode.setAttribute(FIELD_CAPPSLANRESNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEDRItemBase.getCodeName() != null) {
            object = pSDEDRItemBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEDRItemBase.getCounterId() != null) {
            object = pSDEDRItemBase.getCounterId();
            xmlNode.setAttribute(FIELD_COUNTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getCounterMode() != null) {
            object = pSDEDRItemBase.getCounterMode();
            xmlNode.setAttribute(FIELD_COUNTERMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDRItemBase.getCreateDate() != null) {
            object = pSDEDRItemBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDRItemBase.getCreateMan() != null) {
            object = pSDEDRItemBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getData() != null) {
            object = pSDEDRItemBase.getData();
            xmlNode.setAttribute(FIELD_DATA, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getDRItemType() != null) {
            object = pSDEDRItemBase.getDRItemType();
            xmlNode.setAttribute(FIELD_DRITEMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getDynaModelFlag() != null) {
            object = pSDEDRItemBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDRItemBase.getEnableMode() != null) {
            object = pSDEDRItemBase.getEnableMode();
            xmlNode.setAttribute(FIELD_ENABLEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getHeaderPSSysPFPluginId() != null) {
            object = pSDEDRItemBase.getHeaderPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_HEADERPSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getHeaderPSSysPFPluginName() != null) {
            object = pSDEDRItemBase.getHeaderPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_HEADERPSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getItemTag() != null) {
            object = pSDEDRItemBase.getItemTag();
            xmlNode.setAttribute(FIELD_ITEMTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getItemTag2() != null) {
            object = pSDEDRItemBase.getItemTag2();
            xmlNode.setAttribute(FIELD_ITEMTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getLockFlag() != null) {
            object = pSDEDRItemBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDRItemBase.getMemo() != null) {
            object = pSDEDRItemBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getMinorPSDEId() != null) {
            object = pSDEDRItemBase.getMinorPSDEId();
            xmlNode.setAttribute(FIELD_MINORPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getNavViewFilter() != null) {
            object = pSDEDRItemBase.getNavViewFilter();
            xmlNode.setAttribute(FIELD_NAVVIEWFILTER, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getNavViewFilterDesc() != null) {
            object = pSDEDRItemBase.getNavViewFilterDesc();
            xmlNode.setAttribute(FIELD_NAVVIEWFILTERDESC, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getOrderValue() != null) {
            object = pSDEDRItemBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDRItemBase.getPDTViewFlag() != null) {
            object = pSDEDRItemBase.getPDTViewFlag();
            xmlNode.setAttribute(FIELD_PDTVIEWFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDRItemBase.getPSDEDRGroupId() != null) {
            object = pSDEDRItemBase.getPSDEDRGroupId();
            xmlNode.setAttribute(FIELD_PSDEDRGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getPSDEDRGroupName() != null) {
            object = pSDEDRItemBase.getPSDEDRGroupName();
            xmlNode.setAttribute(FIELD_PSDEDRGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getPSDEDRItemId() != null) {
            object = pSDEDRItemBase.getPSDEDRItemId();
            xmlNode.setAttribute(FIELD_PSDEDRITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getPSDEDRItemName() != null) {
            object = pSDEDRItemBase.getPSDEDRItemName();
            xmlNode.setAttribute(FIELD_PSDEDRITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getPSDEId() != null) {
            object = pSDEDRItemBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getPSDEName() != null) {
            object = pSDEDRItemBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getPSDEOPPrivId() != null) {
            object = pSDEDRItemBase.getPSDEOPPrivId();
            xmlNode.setAttribute(FIELD_PSDEOPPRIVID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getPSDEOPPrivName() != null) {
            object = pSDEDRItemBase.getPSDEOPPrivName();
            xmlNode.setAttribute(FIELD_PSDEOPPRIVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getPSDERId() != null) {
            object = pSDEDRItemBase.getPSDERId();
            xmlNode.setAttribute(FIELD_PSDERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getPSDERName() != null) {
            object = pSDEDRItemBase.getPSDERName();
            xmlNode.setAttribute(FIELD_PSDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getPSDEViewBaseId() != null) {
            object = pSDEDRItemBase.getPSDEViewBaseId();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getPSDEViewBaseName() != null) {
            object = pSDEDRItemBase.getPSDEViewBaseName();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getPSDynaInstId() != null) {
            object = pSDEDRItemBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getPSSysCssId() != null) {
            object = pSDEDRItemBase.getPSSysCssId();
            xmlNode.setAttribute(FIELD_PSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getPSSysCssName() != null) {
            object = pSDEDRItemBase.getPSSysCssName();
            xmlNode.setAttribute(FIELD_PSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getPSSysImageId() != null) {
            object = pSDEDRItemBase.getPSSysImageId();
            xmlNode.setAttribute(FIELD_PSSYSIMAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getPSSysImageName() != null) {
            object = pSDEDRItemBase.getPSSysImageName();
            xmlNode.setAttribute(FIELD_PSSYSIMAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getPSSysPDTViewId() != null) {
            object = pSDEDRItemBase.getPSSysPDTViewId();
            xmlNode.setAttribute(FIELD_PSSYSPDTVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getPSSysPDTViewName() != null) {
            object = pSDEDRItemBase.getPSSysPDTViewName();
            xmlNode.setAttribute(FIELD_PSSYSPDTVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getPSSysUniResId() != null) {
            object = pSDEDRItemBase.getPSSysUniResId();
            xmlNode.setAttribute(FIELD_PSSYSUNIRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getPSSysUniResName() != null) {
            object = pSDEDRItemBase.getPSSysUniResName();
            xmlNode.setAttribute(FIELD_PSSYSUNIRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getSRFSysPub() != null) {
            object = pSDEDRItemBase.getSRFSysPub();
            xmlNode.setAttribute(FIELD_SRFSYSPUB, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDRItemBase.getTestCustomCode() != null) {
            object = pSDEDRItemBase.getTestCustomCode();
            xmlNode.setAttribute(FIELD_TESTCUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getTestCustomMode() != null) {
            object = pSDEDRItemBase.getTestCustomMode();
            xmlNode.setAttribute(FIELD_TESTCUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDRItemBase.getTestPSDEActionId() != null) {
            object = pSDEDRItemBase.getTestPSDEActionId();
            xmlNode.setAttribute(FIELD_TESTPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getTestPSDEActionName() != null) {
            object = pSDEDRItemBase.getTestPSDEActionName();
            xmlNode.setAttribute(FIELD_TESTPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getTestPSDELogicId() != null) {
            object = pSDEDRItemBase.getTestPSDELogicId();
            xmlNode.setAttribute(FIELD_TESTPSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getTestPSDELogicName() != null) {
            object = pSDEDRItemBase.getTestPSDELogicName();
            xmlNode.setAttribute(FIELD_TESTPSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getTipPSLanResId() != null) {
            object = pSDEDRItemBase.getTipPSLanResId();
            xmlNode.setAttribute(FIELD_TIPPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getTipPSLanResName() != null) {
            object = pSDEDRItemBase.getTipPSLanResName();
            xmlNode.setAttribute(FIELD_TIPPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getTooltipInfo() != null) {
            object = pSDEDRItemBase.getTooltipInfo();
            xmlNode.setAttribute(FIELD_TOOLTIPINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getUpdateDate() != null) {
            object = pSDEDRItemBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDRItemBase.getUpdateMan() != null) {
            object = pSDEDRItemBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getUserCat() != null) {
            object = pSDEDRItemBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getUserTag() != null) {
            object = pSDEDRItemBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getUserTag2() != null) {
            object = pSDEDRItemBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getUserTag3() != null) {
            object = pSDEDRItemBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getUserTag4() != null) {
            object = pSDEDRItemBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getViewCodeName() != null) {
            object = pSDEDRItemBase.getViewCodeName();
            xmlNode.setAttribute(FIELD_VIEWCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getViewParams() != null) {
            object = pSDEDRItemBase.getViewParams();
            xmlNode.setAttribute(FIELD_VIEWPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRItemBase.getViewPSDEId() != null) {
            object = pSDEDRItemBase.getViewPSDEId();
            xmlNode.setAttribute(FIELD_VIEWPSDEID, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEDRItemBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEDRItemBase pSDEDRItemBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEDRItemBase.isCapPSLanResIdDirty() && (bl || pSDEDRItemBase.getCapPSLanResId() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESID, (Object)pSDEDRItemBase.getCapPSLanResId());
        }
        if (pSDEDRItemBase.isCapPSLanResNameDirty() && (bl || pSDEDRItemBase.getCapPSLanResName() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESNAME, (Object)pSDEDRItemBase.getCapPSLanResName());
        }
        if (pSDEDRItemBase.isCodeNameDirty() && (bl || pSDEDRItemBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEDRItemBase.getCodeName());
        }
        if (pSDEDRItemBase.isCounterIdDirty() && (bl || pSDEDRItemBase.getCounterId() != null)) {
            iDataObject.set(FIELD_COUNTERID, (Object)pSDEDRItemBase.getCounterId());
        }
        if (pSDEDRItemBase.isCounterModeDirty() && (bl || pSDEDRItemBase.getCounterMode() != null)) {
            iDataObject.set(FIELD_COUNTERMODE, (Object)pSDEDRItemBase.getCounterMode());
        }
        if (pSDEDRItemBase.isCreateDateDirty() && (bl || pSDEDRItemBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEDRItemBase.getCreateDate());
        }
        if (pSDEDRItemBase.isCreateManDirty() && (bl || pSDEDRItemBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEDRItemBase.getCreateMan());
        }
        if (pSDEDRItemBase.isDataDirty() && (bl || pSDEDRItemBase.getData() != null)) {
            iDataObject.set(FIELD_DATA, (Object)pSDEDRItemBase.getData());
        }
        if (pSDEDRItemBase.isDRItemTypeDirty() && (bl || pSDEDRItemBase.getDRItemType() != null)) {
            iDataObject.set(FIELD_DRITEMTYPE, (Object)pSDEDRItemBase.getDRItemType());
        }
        if (pSDEDRItemBase.isDynaModelFlagDirty() && (bl || pSDEDRItemBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDEDRItemBase.getDynaModelFlag());
        }
        if (pSDEDRItemBase.isEnableModeDirty() && (bl || pSDEDRItemBase.getEnableMode() != null)) {
            iDataObject.set(FIELD_ENABLEMODE, (Object)pSDEDRItemBase.getEnableMode());
        }
        if (pSDEDRItemBase.isHeaderPSSysPFPluginIdDirty() && (bl || pSDEDRItemBase.getHeaderPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_HEADERPSSYSPFPLUGINID, (Object)pSDEDRItemBase.getHeaderPSSysPFPluginId());
        }
        if (pSDEDRItemBase.isHeaderPSSysPFPluginNameDirty() && (bl || pSDEDRItemBase.getHeaderPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_HEADERPSSYSPFPLUGINNAME, (Object)pSDEDRItemBase.getHeaderPSSysPFPluginName());
        }
        if (pSDEDRItemBase.isItemTagDirty() && (bl || pSDEDRItemBase.getItemTag() != null)) {
            iDataObject.set(FIELD_ITEMTAG, (Object)pSDEDRItemBase.getItemTag());
        }
        if (pSDEDRItemBase.isItemTag2Dirty() && (bl || pSDEDRItemBase.getItemTag2() != null)) {
            iDataObject.set(FIELD_ITEMTAG2, (Object)pSDEDRItemBase.getItemTag2());
        }
        if (pSDEDRItemBase.isLockFlagDirty() && (bl || pSDEDRItemBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDEDRItemBase.getLockFlag());
        }
        if (pSDEDRItemBase.isMemoDirty() && (bl || pSDEDRItemBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEDRItemBase.getMemo());
        }
        if (pSDEDRItemBase.isMinorPSDEIdDirty() && (bl || pSDEDRItemBase.getMinorPSDEId() != null)) {
            iDataObject.set(FIELD_MINORPSDEID, (Object)pSDEDRItemBase.getMinorPSDEId());
        }
        if (pSDEDRItemBase.isNavViewFilterDirty() && (bl || pSDEDRItemBase.getNavViewFilter() != null)) {
            iDataObject.set(FIELD_NAVVIEWFILTER, (Object)pSDEDRItemBase.getNavViewFilter());
        }
        if (pSDEDRItemBase.isNavViewFilterDescDirty() && (bl || pSDEDRItemBase.getNavViewFilterDesc() != null)) {
            iDataObject.set(FIELD_NAVVIEWFILTERDESC, (Object)pSDEDRItemBase.getNavViewFilterDesc());
        }
        if (pSDEDRItemBase.isOrderValueDirty() && (bl || pSDEDRItemBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEDRItemBase.getOrderValue());
        }
        if (pSDEDRItemBase.isPDTViewFlagDirty() && (bl || pSDEDRItemBase.getPDTViewFlag() != null)) {
            iDataObject.set(FIELD_PDTVIEWFLAG, (Object)pSDEDRItemBase.getPDTViewFlag());
        }
        if (pSDEDRItemBase.isPSDEDRGroupIdDirty() && (bl || pSDEDRItemBase.getPSDEDRGroupId() != null)) {
            iDataObject.set(FIELD_PSDEDRGROUPID, (Object)pSDEDRItemBase.getPSDEDRGroupId());
        }
        if (pSDEDRItemBase.isPSDEDRGroupNameDirty() && (bl || pSDEDRItemBase.getPSDEDRGroupName() != null)) {
            iDataObject.set(FIELD_PSDEDRGROUPNAME, (Object)pSDEDRItemBase.getPSDEDRGroupName());
        }
        if (pSDEDRItemBase.isPSDEDRItemIdDirty() && (bl || pSDEDRItemBase.getPSDEDRItemId() != null)) {
            iDataObject.set(FIELD_PSDEDRITEMID, (Object)pSDEDRItemBase.getPSDEDRItemId());
        }
        if (pSDEDRItemBase.isPSDEDRItemNameDirty() && (bl || pSDEDRItemBase.getPSDEDRItemName() != null)) {
            iDataObject.set(FIELD_PSDEDRITEMNAME, (Object)pSDEDRItemBase.getPSDEDRItemName());
        }
        if (pSDEDRItemBase.isPSDEIdDirty() && (bl || pSDEDRItemBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEDRItemBase.getPSDEId());
        }
        if (pSDEDRItemBase.isPSDENameDirty() && (bl || pSDEDRItemBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEDRItemBase.getPSDEName());
        }
        if (pSDEDRItemBase.isPSDEOPPrivIdDirty() && (bl || pSDEDRItemBase.getPSDEOPPrivId() != null)) {
            iDataObject.set(FIELD_PSDEOPPRIVID, (Object)pSDEDRItemBase.getPSDEOPPrivId());
        }
        if (pSDEDRItemBase.isPSDEOPPrivNameDirty() && (bl || pSDEDRItemBase.getPSDEOPPrivName() != null)) {
            iDataObject.set(FIELD_PSDEOPPRIVNAME, (Object)pSDEDRItemBase.getPSDEOPPrivName());
        }
        if (pSDEDRItemBase.isPSDERIdDirty() && (bl || pSDEDRItemBase.getPSDERId() != null)) {
            iDataObject.set(FIELD_PSDERID, (Object)pSDEDRItemBase.getPSDERId());
        }
        if (pSDEDRItemBase.isPSDERNameDirty() && (bl || pSDEDRItemBase.getPSDERName() != null)) {
            iDataObject.set(FIELD_PSDERNAME, (Object)pSDEDRItemBase.getPSDERName());
        }
        if (pSDEDRItemBase.isPSDEViewBaseIdDirty() && (bl || pSDEDRItemBase.getPSDEViewBaseId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASEID, (Object)pSDEDRItemBase.getPSDEViewBaseId());
        }
        if (pSDEDRItemBase.isPSDEViewBaseNameDirty() && (bl || pSDEDRItemBase.getPSDEViewBaseName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASENAME, (Object)pSDEDRItemBase.getPSDEViewBaseName());
        }
        if (pSDEDRItemBase.isPSDynaInstIdDirty() && (bl || pSDEDRItemBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDEDRItemBase.getPSDynaInstId());
        }
        if (pSDEDRItemBase.isPSSysCssIdDirty() && (bl || pSDEDRItemBase.getPSSysCssId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSID, (Object)pSDEDRItemBase.getPSSysCssId());
        }
        if (pSDEDRItemBase.isPSSysCssNameDirty() && (bl || pSDEDRItemBase.getPSSysCssName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSNAME, (Object)pSDEDRItemBase.getPSSysCssName());
        }
        if (pSDEDRItemBase.isPSSysImageIdDirty() && (bl || pSDEDRItemBase.getPSSysImageId() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGEID, (Object)pSDEDRItemBase.getPSSysImageId());
        }
        if (pSDEDRItemBase.isPSSysImageNameDirty() && (bl || pSDEDRItemBase.getPSSysImageName() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGENAME, (Object)pSDEDRItemBase.getPSSysImageName());
        }
        if (pSDEDRItemBase.isPSSysPDTViewIdDirty() && (bl || pSDEDRItemBase.getPSSysPDTViewId() != null)) {
            iDataObject.set(FIELD_PSSYSPDTVIEWID, (Object)pSDEDRItemBase.getPSSysPDTViewId());
        }
        if (pSDEDRItemBase.isPSSysPDTViewNameDirty() && (bl || pSDEDRItemBase.getPSSysPDTViewName() != null)) {
            iDataObject.set(FIELD_PSSYSPDTVIEWNAME, (Object)pSDEDRItemBase.getPSSysPDTViewName());
        }
        if (pSDEDRItemBase.isPSSysUniResIdDirty() && (bl || pSDEDRItemBase.getPSSysUniResId() != null)) {
            iDataObject.set(FIELD_PSSYSUNIRESID, (Object)pSDEDRItemBase.getPSSysUniResId());
        }
        if (pSDEDRItemBase.isPSSysUniResNameDirty() && (bl || pSDEDRItemBase.getPSSysUniResName() != null)) {
            iDataObject.set(FIELD_PSSYSUNIRESNAME, (Object)pSDEDRItemBase.getPSSysUniResName());
        }
        if (pSDEDRItemBase.isSRFSysPubDirty() && (bl || pSDEDRItemBase.getSRFSysPub() != null)) {
            iDataObject.set(FIELD_SRFSYSPUB, (Object)pSDEDRItemBase.getSRFSysPub());
        }
        if (pSDEDRItemBase.isTestCustomCodeDirty() && (bl || pSDEDRItemBase.getTestCustomCode() != null)) {
            iDataObject.set(FIELD_TESTCUSTOMCODE, (Object)pSDEDRItemBase.getTestCustomCode());
        }
        if (pSDEDRItemBase.isTestCustomModeDirty() && (bl || pSDEDRItemBase.getTestCustomMode() != null)) {
            iDataObject.set(FIELD_TESTCUSTOMMODE, (Object)pSDEDRItemBase.getTestCustomMode());
        }
        if (pSDEDRItemBase.isTestPSDEActionIdDirty() && (bl || pSDEDRItemBase.getTestPSDEActionId() != null)) {
            iDataObject.set(FIELD_TESTPSDEACTIONID, (Object)pSDEDRItemBase.getTestPSDEActionId());
        }
        if (pSDEDRItemBase.isTestPSDEActionNameDirty() && (bl || pSDEDRItemBase.getTestPSDEActionName() != null)) {
            iDataObject.set(FIELD_TESTPSDEACTIONNAME, (Object)pSDEDRItemBase.getTestPSDEActionName());
        }
        if (pSDEDRItemBase.isTestPSDELogicIdDirty() && (bl || pSDEDRItemBase.getTestPSDELogicId() != null)) {
            iDataObject.set(FIELD_TESTPSDELOGICID, (Object)pSDEDRItemBase.getTestPSDELogicId());
        }
        if (pSDEDRItemBase.isTestPSDELogicNameDirty() && (bl || pSDEDRItemBase.getTestPSDELogicName() != null)) {
            iDataObject.set(FIELD_TESTPSDELOGICNAME, (Object)pSDEDRItemBase.getTestPSDELogicName());
        }
        if (pSDEDRItemBase.isTipPSLanResIdDirty() && (bl || pSDEDRItemBase.getTipPSLanResId() != null)) {
            iDataObject.set(FIELD_TIPPSLANRESID, (Object)pSDEDRItemBase.getTipPSLanResId());
        }
        if (pSDEDRItemBase.isTipPSLanResNameDirty() && (bl || pSDEDRItemBase.getTipPSLanResName() != null)) {
            iDataObject.set(FIELD_TIPPSLANRESNAME, (Object)pSDEDRItemBase.getTipPSLanResName());
        }
        if (pSDEDRItemBase.isTooltipInfoDirty() && (bl || pSDEDRItemBase.getTooltipInfo() != null)) {
            iDataObject.set(FIELD_TOOLTIPINFO, (Object)pSDEDRItemBase.getTooltipInfo());
        }
        if (pSDEDRItemBase.isUpdateDateDirty() && (bl || pSDEDRItemBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEDRItemBase.getUpdateDate());
        }
        if (pSDEDRItemBase.isUpdateManDirty() && (bl || pSDEDRItemBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEDRItemBase.getUpdateMan());
        }
        if (pSDEDRItemBase.isUserCatDirty() && (bl || pSDEDRItemBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEDRItemBase.getUserCat());
        }
        if (pSDEDRItemBase.isUserTagDirty() && (bl || pSDEDRItemBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEDRItemBase.getUserTag());
        }
        if (pSDEDRItemBase.isUserTag2Dirty() && (bl || pSDEDRItemBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEDRItemBase.getUserTag2());
        }
        if (pSDEDRItemBase.isUserTag3Dirty() && (bl || pSDEDRItemBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEDRItemBase.getUserTag3());
        }
        if (pSDEDRItemBase.isUserTag4Dirty() && (bl || pSDEDRItemBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEDRItemBase.getUserTag4());
        }
        if (pSDEDRItemBase.isViewCodeNameDirty() && (bl || pSDEDRItemBase.getViewCodeName() != null)) {
            iDataObject.set(FIELD_VIEWCODENAME, (Object)pSDEDRItemBase.getViewCodeName());
        }
        if (pSDEDRItemBase.isViewParamsDirty() && (bl || pSDEDRItemBase.getViewParams() != null)) {
            iDataObject.set(FIELD_VIEWPARAMS, (Object)pSDEDRItemBase.getViewParams());
        }
        if (pSDEDRItemBase.isViewPSDEIdDirty() && (bl || pSDEDRItemBase.getViewPSDEId() != null)) {
            iDataObject.set(FIELD_VIEWPSDEID, (Object)pSDEDRItemBase.getViewPSDEId());
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
        return PSDEDRItemBase.remove(this, n);
    }

    private static boolean remove(PSDEDRItemBase pSDEDRItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEDRItemBase.resetCapPSLanResId();
                return true;
            }
            case 1: {
                pSDEDRItemBase.resetCapPSLanResName();
                return true;
            }
            case 2: {
                pSDEDRItemBase.resetCodeName();
                return true;
            }
            case 3: {
                pSDEDRItemBase.resetCounterId();
                return true;
            }
            case 4: {
                pSDEDRItemBase.resetCounterMode();
                return true;
            }
            case 5: {
                pSDEDRItemBase.resetCreateDate();
                return true;
            }
            case 6: {
                pSDEDRItemBase.resetCreateMan();
                return true;
            }
            case 7: {
                pSDEDRItemBase.resetData();
                return true;
            }
            case 8: {
                pSDEDRItemBase.resetDRItemType();
                return true;
            }
            case 9: {
                pSDEDRItemBase.resetDynaModelFlag();
                return true;
            }
            case 10: {
                pSDEDRItemBase.resetEnableMode();
                return true;
            }
            case 11: {
                pSDEDRItemBase.resetHeaderPSSysPFPluginId();
                return true;
            }
            case 12: {
                pSDEDRItemBase.resetHeaderPSSysPFPluginName();
                return true;
            }
            case 13: {
                pSDEDRItemBase.resetItemTag();
                return true;
            }
            case 14: {
                pSDEDRItemBase.resetItemTag2();
                return true;
            }
            case 15: {
                pSDEDRItemBase.resetLockFlag();
                return true;
            }
            case 16: {
                pSDEDRItemBase.resetMemo();
                return true;
            }
            case 17: {
                pSDEDRItemBase.resetMinorPSDEId();
                return true;
            }
            case 18: {
                pSDEDRItemBase.resetNavViewFilter();
                return true;
            }
            case 19: {
                pSDEDRItemBase.resetNavViewFilterDesc();
                return true;
            }
            case 20: {
                pSDEDRItemBase.resetOrderValue();
                return true;
            }
            case 21: {
                pSDEDRItemBase.resetPDTViewFlag();
                return true;
            }
            case 22: {
                pSDEDRItemBase.resetPSDEDRGroupId();
                return true;
            }
            case 23: {
                pSDEDRItemBase.resetPSDEDRGroupName();
                return true;
            }
            case 24: {
                pSDEDRItemBase.resetPSDEDRItemId();
                return true;
            }
            case 25: {
                pSDEDRItemBase.resetPSDEDRItemName();
                return true;
            }
            case 26: {
                pSDEDRItemBase.resetPSDEId();
                return true;
            }
            case 27: {
                pSDEDRItemBase.resetPSDEName();
                return true;
            }
            case 28: {
                pSDEDRItemBase.resetPSDEOPPrivId();
                return true;
            }
            case 29: {
                pSDEDRItemBase.resetPSDEOPPrivName();
                return true;
            }
            case 30: {
                pSDEDRItemBase.resetPSDERId();
                return true;
            }
            case 31: {
                pSDEDRItemBase.resetPSDERName();
                return true;
            }
            case 32: {
                pSDEDRItemBase.resetPSDEViewBaseId();
                return true;
            }
            case 33: {
                pSDEDRItemBase.resetPSDEViewBaseName();
                return true;
            }
            case 34: {
                pSDEDRItemBase.resetPSDynaInstId();
                return true;
            }
            case 35: {
                pSDEDRItemBase.resetPSSysCssId();
                return true;
            }
            case 36: {
                pSDEDRItemBase.resetPSSysCssName();
                return true;
            }
            case 37: {
                pSDEDRItemBase.resetPSSysImageId();
                return true;
            }
            case 38: {
                pSDEDRItemBase.resetPSSysImageName();
                return true;
            }
            case 39: {
                pSDEDRItemBase.resetPSSysPDTViewId();
                return true;
            }
            case 40: {
                pSDEDRItemBase.resetPSSysPDTViewName();
                return true;
            }
            case 41: {
                pSDEDRItemBase.resetPSSysUniResId();
                return true;
            }
            case 42: {
                pSDEDRItemBase.resetPSSysUniResName();
                return true;
            }
            case 43: {
                pSDEDRItemBase.resetSRFSysPub();
                return true;
            }
            case 44: {
                pSDEDRItemBase.resetTestCustomCode();
                return true;
            }
            case 45: {
                pSDEDRItemBase.resetTestCustomMode();
                return true;
            }
            case 46: {
                pSDEDRItemBase.resetTestPSDEActionId();
                return true;
            }
            case 47: {
                pSDEDRItemBase.resetTestPSDEActionName();
                return true;
            }
            case 48: {
                pSDEDRItemBase.resetTestPSDELogicId();
                return true;
            }
            case 49: {
                pSDEDRItemBase.resetTestPSDELogicName();
                return true;
            }
            case 50: {
                pSDEDRItemBase.resetTipPSLanResId();
                return true;
            }
            case 51: {
                pSDEDRItemBase.resetTipPSLanResName();
                return true;
            }
            case 52: {
                pSDEDRItemBase.resetTooltipInfo();
                return true;
            }
            case 53: {
                pSDEDRItemBase.resetUpdateDate();
                return true;
            }
            case 54: {
                pSDEDRItemBase.resetUpdateMan();
                return true;
            }
            case 55: {
                pSDEDRItemBase.resetUserCat();
                return true;
            }
            case 56: {
                pSDEDRItemBase.resetUserTag();
                return true;
            }
            case 57: {
                pSDEDRItemBase.resetUserTag2();
                return true;
            }
            case 58: {
                pSDEDRItemBase.resetUserTag3();
                return true;
            }
            case 59: {
                pSDEDRItemBase.resetUserTag4();
                return true;
            }
            case 60: {
                pSDEDRItemBase.resetViewCodeName();
                return true;
            }
            case 61: {
                pSDEDRItemBase.resetViewParams();
                return true;
            }
            case 62: {
                pSDEDRItemBase.resetViewPSDEId();
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
    public PSDEAction getTestPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTestPSDEAction();
        }
        if (this.getTestPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objTestPSDEActionLock;
        synchronized (n) {
            if (this.testpsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getTestPSDEActionId(), (Object)this.testpsdeaction.getPSDEActionId()) != 0L) {
                this.testpsdeaction = null;
            }
            if (this.testpsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getTestPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet(pSDEAction);
                this.testpsdeaction = pSDEAction;
            }
            return this.testpsdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDRGroup getPSDEDRGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDRGroup();
        }
        if (this.getPSDEDRGroupId() == null) {
            return null;
        }
        Integer n = this.objPSDEDRGroupLock;
        synchronized (n) {
            if (this.psdedrgroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDRGroupId(), (Object)this.psdedrgroup.getPSDEDRGroupId()) != 0L) {
                this.psdedrgroup = null;
            }
            if (this.psdedrgroup == null) {
                PSDEDRGroup pSDEDRGroup = new PSDEDRGroup();
                pSDEDRGroup.setPSDEDRGroupId(this.getPSDEDRGroupId());
                PSDEDRGroupService pSDEDRGroupService = (PSDEDRGroupService)ServiceGlobal.getService(PSDEDRGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEDRGroupService.autoGet(pSDEDRGroup);
                this.psdedrgroup = pSDEDRGroup;
            }
            return this.psdedrgroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDELogic getTestPSDELogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTestPSDELogic();
        }
        if (this.getTestPSDELogicId() == null) {
            return null;
        }
        Integer n = this.objTestPSDELogicLock;
        synchronized (n) {
            if (this.testpsdelogic != null && DataTypeHelper.compare((int)25, (Object)this.getTestPSDELogicId(), (Object)this.testpsdelogic.getPSDELogicId()) != 0L) {
                this.testpsdelogic = null;
            }
            if (this.testpsdelogic == null) {
                PSDELogic pSDELogic = new PSDELogic();
                pSDELogic.setPSDELogicId(this.getTestPSDELogicId());
                PSDELogicService pSDELogicService = (PSDELogicService)ServiceGlobal.getService(PSDELogicService.class, (SessionFactory)this.getSessionFactory());
                pSDELogicService.autoGet(pSDELogic);
                this.testpsdelogic = pSDELogic;
            }
            return this.testpsdelogic;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEOPPriv getPSDEOPPriv() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEOPPriv();
        }
        if (this.getPSDEOPPrivId() == null) {
            return null;
        }
        Integer n = this.objPSDEOPPrivLock;
        synchronized (n) {
            if (this.psdeoppriv != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEOPPrivId(), (Object)this.psdeoppriv.getPSDEOPPrivId()) != 0L) {
                this.psdeoppriv = null;
            }
            if (this.psdeoppriv == null) {
                PSDEOPPriv pSDEOPPriv = new PSDEOPPriv();
                pSDEOPPriv.setPSDEOPPrivId(this.getPSDEOPPrivId());
                PSDEOPPrivService pSDEOPPrivService = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
                pSDEOPPrivService.autoGet(pSDEOPPriv);
                this.psdeoppriv = pSDEOPPriv;
            }
            return this.psdeoppriv;
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
    public PSSysPDTView getPSSysPTDView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPTDView();
        }
        if (this.getPSSysPDTViewId() == null) {
            return null;
        }
        Integer n = this.objPSSysPTDViewLock;
        synchronized (n) {
            if (this.pssysptdview != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysPDTViewId(), (Object)this.pssysptdview.getPSSysPDTViewId()) != 0L) {
                this.pssysptdview = null;
            }
            if (this.pssysptdview == null) {
                PSSysPDTView pSSysPDTView = new PSSysPDTView();
                pSSysPDTView.setPSSysPDTViewId(this.getPSSysPDTViewId());
                PSSysPDTViewService pSSysPDTViewService = (PSSysPDTViewService)ServiceGlobal.getService(PSSysPDTViewService.class, (SessionFactory)this.getSessionFactory());
                pSSysPDTViewService.autoGet(pSSysPDTView);
                this.pssysptdview = pSSysPDTView;
            }
            return this.pssysptdview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysPFPlugin getHeaderPSSysPFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHeaderPSSysPFPlugin();
        }
        if (this.getHeaderPSSysPFPluginId() == null) {
            return null;
        }
        Integer n = this.objHeaderPSSysPFPluginLock;
        synchronized (n) {
            if (this.headerpssyspfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getHeaderPSSysPFPluginId(), (Object)this.headerpssyspfplugin.getPSSysPFPluginId()) != 0L) {
                this.headerpssyspfplugin = null;
            }
            if (this.headerpssyspfplugin == null) {
                PSSysPFPlugin pSSysPFPlugin = new PSSysPFPlugin();
                pSSysPFPlugin.setPSSysPFPluginId(this.getHeaderPSSysPFPluginId());
                PSSysPFPluginService pSSysPFPluginService = (PSSysPFPluginService)ServiceGlobal.getService(PSSysPFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysPFPluginService.autoGet(pSSysPFPlugin);
                this.headerpssyspfplugin = pSSysPFPlugin;
            }
            return this.headerpssyspfplugin;
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

    private PSDEDRItemBase getProxyEntity() {
        return this.proxyPSDEDRItemBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEDRItemBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEDRItemBase) {
            this.proxyPSDEDRItemBase = (PSDEDRItemBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDRItemService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CAPPSLANRESID, 0);
        fieldIndexMap.put(FIELD_CAPPSLANRESNAME, 1);
        fieldIndexMap.put(FIELD_CODENAME, 2);
        fieldIndexMap.put(FIELD_COUNTERID, 3);
        fieldIndexMap.put(FIELD_COUNTERMODE, 4);
        fieldIndexMap.put(FIELD_CREATEDATE, 5);
        fieldIndexMap.put(FIELD_CREATEMAN, 6);
        fieldIndexMap.put(FIELD_DATA, 7);
        fieldIndexMap.put(FIELD_DRITEMTYPE, 8);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 9);
        fieldIndexMap.put(FIELD_ENABLEMODE, 10);
        fieldIndexMap.put(FIELD_HEADERPSSYSPFPLUGINID, 11);
        fieldIndexMap.put(FIELD_HEADERPSSYSPFPLUGINNAME, 12);
        fieldIndexMap.put(FIELD_ITEMTAG, 13);
        fieldIndexMap.put(FIELD_ITEMTAG2, 14);
        fieldIndexMap.put(FIELD_LOCKFLAG, 15);
        fieldIndexMap.put(FIELD_MEMO, 16);
        fieldIndexMap.put(FIELD_MINORPSDEID, 17);
        fieldIndexMap.put(FIELD_NAVVIEWFILTER, 18);
        fieldIndexMap.put(FIELD_NAVVIEWFILTERDESC, 19);
        fieldIndexMap.put(FIELD_ORDERVALUE, 20);
        fieldIndexMap.put(FIELD_PDTVIEWFLAG, 21);
        fieldIndexMap.put(FIELD_PSDEDRGROUPID, 22);
        fieldIndexMap.put(FIELD_PSDEDRGROUPNAME, 23);
        fieldIndexMap.put(FIELD_PSDEDRITEMID, 24);
        fieldIndexMap.put(FIELD_PSDEDRITEMNAME, 25);
        fieldIndexMap.put(FIELD_PSDEID, 26);
        fieldIndexMap.put(FIELD_PSDENAME, 27);
        fieldIndexMap.put(FIELD_PSDEOPPRIVID, 28);
        fieldIndexMap.put(FIELD_PSDEOPPRIVNAME, 29);
        fieldIndexMap.put(FIELD_PSDERID, 30);
        fieldIndexMap.put(FIELD_PSDERNAME, 31);
        fieldIndexMap.put(FIELD_PSDEVIEWBASEID, 32);
        fieldIndexMap.put(FIELD_PSDEVIEWBASENAME, 33);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 34);
        fieldIndexMap.put(FIELD_PSSYSCSSID, 35);
        fieldIndexMap.put(FIELD_PSSYSCSSNAME, 36);
        fieldIndexMap.put(FIELD_PSSYSIMAGEID, 37);
        fieldIndexMap.put(FIELD_PSSYSIMAGENAME, 38);
        fieldIndexMap.put(FIELD_PSSYSPDTVIEWID, 39);
        fieldIndexMap.put(FIELD_PSSYSPDTVIEWNAME, 40);
        fieldIndexMap.put(FIELD_PSSYSUNIRESID, 41);
        fieldIndexMap.put(FIELD_PSSYSUNIRESNAME, 42);
        fieldIndexMap.put(FIELD_SRFSYSPUB, 43);
        fieldIndexMap.put(FIELD_TESTCUSTOMCODE, 44);
        fieldIndexMap.put(FIELD_TESTCUSTOMMODE, 45);
        fieldIndexMap.put(FIELD_TESTPSDEACTIONID, 46);
        fieldIndexMap.put(FIELD_TESTPSDEACTIONNAME, 47);
        fieldIndexMap.put(FIELD_TESTPSDELOGICID, 48);
        fieldIndexMap.put(FIELD_TESTPSDELOGICNAME, 49);
        fieldIndexMap.put(FIELD_TIPPSLANRESID, 50);
        fieldIndexMap.put(FIELD_TIPPSLANRESNAME, 51);
        fieldIndexMap.put(FIELD_TOOLTIPINFO, 52);
        fieldIndexMap.put(FIELD_UPDATEDATE, 53);
        fieldIndexMap.put(FIELD_UPDATEMAN, 54);
        fieldIndexMap.put(FIELD_USERCAT, 55);
        fieldIndexMap.put(FIELD_USERTAG, 56);
        fieldIndexMap.put(FIELD_USERTAG2, 57);
        fieldIndexMap.put(FIELD_USERTAG3, 58);
        fieldIndexMap.put(FIELD_USERTAG4, 59);
        fieldIndexMap.put(FIELD_VIEWCODENAME, 60);
        fieldIndexMap.put(FIELD_VIEWPARAMS, 61);
        fieldIndexMap.put(FIELD_VIEWPSDEID, 62);
    }
}

