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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDRItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataRelation;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeView;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataRelationService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewService;
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

public abstract class PSDEDRDetailBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEDRDetailBase.class);
    public static final String FIELD_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String FIELD_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String FIELD_CAPTION = "CAPTION";
    public static final String FIELD_COUNTERID = "COUNTERID";
    public static final String FIELD_COUNTERMODE = "COUNTERMODE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DATA = "DATA";
    public static final String FIELD_DETAILTAG = "DETAILTAG";
    public static final String FIELD_DETAILTAG2 = "DETAILTAG2";
    public static final String FIELD_DETAILTYPE = "DETAILTYPE";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_ENABLEMODE = "ENABLEMODE";
    public static final String FIELD_GROUPORDERVALUE = "GROUPORDERVALUE";
    public static final String FIELD_HEADERPSSYSPFPLUGINID = "HEADERPSSYSPFPLUGINID";
    public static final String FIELD_HEADERPSSYSPFPLUGINNAME = "HEADERPSSYSPFPLUGINNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_NAVVIEWFILTER = "NAVVIEWFILTER";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEDRDETAILID = "PSDEDRDETAILID";
    public static final String FIELD_PSDEDRDETAILNAME = "PSDEDRDETAILNAME";
    public static final String FIELD_PSDEDRGROUPID = "PSDEDRGROUPID";
    public static final String FIELD_PSDEDRGROUPNAME = "PSDEDRGROUPNAME";
    public static final String FIELD_PSDEDRID = "PSDEDRID";
    public static final String FIELD_PSDEDRITEMID = "PSDEDRITEMID";
    public static final String FIELD_PSDEDRITEMNAME = "PSDEDRITEMNAME";
    public static final String FIELD_PSDEDRNAME = "PSDEDRNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDEOPPRIVID = "PSDEOPPRIVID";
    public static final String FIELD_PSDEOPPRIVNAME = "PSDEOPPRIVNAME";
    public static final String FIELD_PSDETREEVIEWID = "PSDETREEVIEWID";
    public static final String FIELD_PSDETREEVIEWNAME = "PSDETREEVIEWNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSSYSCSSID = "PSSYSCSSID";
    public static final String FIELD_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String FIELD_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String FIELD_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String FIELD_PSSYSPDTVIEWID = "PSSYSPDTVIEWID";
    public static final String FIELD_PSSYSPDTVIEWNAME = "PSSYSPDTVIEWNAME";
    public static final String FIELD_PSSYSUNIRESID = "PSSYSUNIRESID";
    public static final String FIELD_PSSYSUNIRESNAME = "PSSYSUNIRESNAME";
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
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VIEWPARAMS = "VIEWPARAMS";
    private static final int INDEX_CAPPSLANRESID = 0;
    private static final int INDEX_CAPPSLANRESNAME = 1;
    private static final int INDEX_CAPTION = 2;
    private static final int INDEX_COUNTERID = 3;
    private static final int INDEX_COUNTERMODE = 4;
    private static final int INDEX_CREATEDATE = 5;
    private static final int INDEX_CREATEMAN = 6;
    private static final int INDEX_DATA = 7;
    private static final int INDEX_DETAILTAG = 8;
    private static final int INDEX_DETAILTAG2 = 9;
    private static final int INDEX_DETAILTYPE = 10;
    private static final int INDEX_DYNAMODELFLAG = 11;
    private static final int INDEX_ENABLEMODE = 12;
    private static final int INDEX_GROUPORDERVALUE = 13;
    private static final int INDEX_HEADERPSSYSPFPLUGINID = 14;
    private static final int INDEX_HEADERPSSYSPFPLUGINNAME = 15;
    private static final int INDEX_MEMO = 16;
    private static final int INDEX_NAVVIEWFILTER = 17;
    private static final int INDEX_ORDERVALUE = 18;
    private static final int INDEX_PSDEDRDETAILID = 19;
    private static final int INDEX_PSDEDRDETAILNAME = 20;
    private static final int INDEX_PSDEDRGROUPID = 21;
    private static final int INDEX_PSDEDRGROUPNAME = 22;
    private static final int INDEX_PSDEDRID = 23;
    private static final int INDEX_PSDEDRITEMID = 24;
    private static final int INDEX_PSDEDRITEMNAME = 25;
    private static final int INDEX_PSDEDRNAME = 26;
    private static final int INDEX_PSDEID = 27;
    private static final int INDEX_PSDEOPPRIVID = 28;
    private static final int INDEX_PSDEOPPRIVNAME = 29;
    private static final int INDEX_PSDETREEVIEWID = 30;
    private static final int INDEX_PSDETREEVIEWNAME = 31;
    private static final int INDEX_PSDYNAINSTID = 32;
    private static final int INDEX_PSSYSCSSID = 33;
    private static final int INDEX_PSSYSCSSNAME = 34;
    private static final int INDEX_PSSYSIMAGEID = 35;
    private static final int INDEX_PSSYSIMAGENAME = 36;
    private static final int INDEX_PSSYSPDTVIEWID = 37;
    private static final int INDEX_PSSYSPDTVIEWNAME = 38;
    private static final int INDEX_PSSYSUNIRESID = 39;
    private static final int INDEX_PSSYSUNIRESNAME = 40;
    private static final int INDEX_TESTCUSTOMCODE = 41;
    private static final int INDEX_TESTCUSTOMMODE = 42;
    private static final int INDEX_TESTPSDEACTIONID = 43;
    private static final int INDEX_TESTPSDEACTIONNAME = 44;
    private static final int INDEX_TESTPSDELOGICID = 45;
    private static final int INDEX_TESTPSDELOGICNAME = 46;
    private static final int INDEX_TIPPSLANRESID = 47;
    private static final int INDEX_TIPPSLANRESNAME = 48;
    private static final int INDEX_TOOLTIPINFO = 49;
    private static final int INDEX_UPDATEDATE = 50;
    private static final int INDEX_UPDATEMAN = 51;
    private static final int INDEX_USERCAT = 52;
    private static final int INDEX_USERTAG = 53;
    private static final int INDEX_USERTAG2 = 54;
    private static final int INDEX_USERTAG3 = 55;
    private static final int INDEX_USERTAG4 = 56;
    private static final int INDEX_VALIDFLAG = 57;
    private static final int INDEX_VIEWPARAMS = 58;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEDRDetailBase proxyPSDEDRDetailBase = null;
    private boolean cappslanresidDirtyFlag = false;
    private boolean cappslanresnameDirtyFlag = false;
    private boolean captionDirtyFlag = false;
    private boolean counteridDirtyFlag = false;
    private boolean countermodeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dataDirtyFlag = false;
    private boolean detailtagDirtyFlag = false;
    private boolean detailtag2DirtyFlag = false;
    private boolean detailtypeDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean enablemodeDirtyFlag = false;
    private boolean groupordervalueDirtyFlag = false;
    private boolean headerpssyspfpluginidDirtyFlag = false;
    private boolean headerpssyspfpluginnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean navviewfilterDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdedrdetailidDirtyFlag = false;
    private boolean psdedrdetailnameDirtyFlag = false;
    private boolean psdedrgroupidDirtyFlag = false;
    private boolean psdedrgroupnameDirtyFlag = false;
    private boolean psdedridDirtyFlag = false;
    private boolean psdedritemidDirtyFlag = false;
    private boolean psdedritemnameDirtyFlag = false;
    private boolean psdedrnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdeopprividDirtyFlag = false;
    private boolean psdeopprivnameDirtyFlag = false;
    private boolean psdetreeviewidDirtyFlag = false;
    private boolean psdetreeviewnameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pssyscssidDirtyFlag = false;
    private boolean pssyscssnameDirtyFlag = false;
    private boolean pssysimageidDirtyFlag = false;
    private boolean pssysimagenameDirtyFlag = false;
    private boolean pssyspdtviewidDirtyFlag = false;
    private boolean pssyspdtviewnameDirtyFlag = false;
    private boolean pssysuniresidDirtyFlag = false;
    private boolean pssysuniresnameDirtyFlag = false;
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
    private boolean validflagDirtyFlag = false;
    private boolean viewparamsDirtyFlag = false;
    @Column(name="cappslanresid")
    private String cappslanresid;
    @Column(name="cappslanresname")
    private String cappslanresname;
    @Column(name="caption")
    private String caption;
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
    @Column(name="detailtag")
    private String detailtag;
    @Column(name="detailtag2")
    private String detailtag2;
    @Column(name="detailtype")
    private String detailtype;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="enablemode")
    private String enablemode;
    @Column(name="groupordervalue")
    private Integer groupordervalue;
    @Column(name="headerpssyspfpluginid")
    private String headerpssyspfpluginid;
    @Column(name="headerpssyspfpluginname")
    private String headerpssyspfpluginname;
    @Column(name="memo")
    private String memo;
    @Column(name="navviewfilter")
    private String navviewfilter;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdedrdetailid")
    private String psdedrdetailid;
    @Column(name="psdedrdetailname")
    private String psdedrdetailname;
    @Column(name="psdedrgroupid")
    private String psdedrgroupid;
    @Column(name="psdedrgroupname")
    private String psdedrgroupname;
    @Column(name="psdedrid")
    private String psdedrid;
    @Column(name="psdedritemid")
    private String psdedritemid;
    @Column(name="psdedritemname")
    private String psdedritemname;
    @Column(name="psdedrname")
    private String psdedrname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdeopprivid")
    private String psdeopprivid;
    @Column(name="psdeopprivname")
    private String psdeopprivname;
    @Column(name="psdetreeviewid")
    private String psdetreeviewid;
    @Column(name="psdetreeviewname")
    private String psdetreeviewname;
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
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="viewparams")
    private String viewparams;
    private Integer objTestPSDEActionLock = new Integer(1);
    private PSDEAction testpsdeaction = null;
    private Integer objPSDEDRLock = new Integer(1);
    private PSDEDataRelation psdedr = null;
    private Integer objPSDEDRGroupLock = new Integer(1);
    private PSDEDRGroup psdedrgroup = null;
    private Integer objPSDEDRItemLock = new Integer(1);
    private PSDEDRItem psdedritem = null;
    private Integer objTestPSDELogicLock = new Integer(1);
    private PSDELogic testpsdelogic = null;
    private Integer objPSDEOPPrivLock = new Integer(1);
    private PSDEOPPriv psdeoppriv = null;
    private Integer objPSDETreeViewLock = new Integer(1);
    private PSDETreeView psdetreeview = null;
    private Integer objCapPSLanResLock = new Integer(1);
    private PSLanguageRes cappslanres = null;
    private Integer objTipPSLanResLock = new Integer(1);
    private PSLanguageRes tippslanres = null;
    private Integer objPSSysCssLock = new Integer(1);
    private PSSysCss pssyscss = null;
    private Integer objPSSysImageLock = new Integer(1);
    private PSSysImage pssysimage = null;
    private Integer objPSSysPDTViewLock = new Integer(1);
    private PSSysPDTView pssyspdtview = null;
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

    public void setDetailTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDetailTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.detailtag = string;
        this.detailtagDirtyFlag = true;
    }

    public String getDetailTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDetailTag();
        }
        return this.detailtag;
    }

    public boolean isDetailTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDetailTagDirty();
        }
        return this.detailtagDirtyFlag;
    }

    public void resetDetailTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDetailTag();
            return;
        }
        this.detailtagDirtyFlag = false;
        this.detailtag = null;
    }

    public void setDetailTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDetailTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.detailtag2 = string;
        this.detailtag2DirtyFlag = true;
    }

    public String getDetailTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDetailTag2();
        }
        return this.detailtag2;
    }

    public boolean isDetailTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDetailTag2Dirty();
        }
        return this.detailtag2DirtyFlag;
    }

    public void resetDetailTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDetailTag2();
            return;
        }
        this.detailtag2DirtyFlag = false;
        this.detailtag2 = null;
    }

    public void setDetailType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDetailType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.detailtype = string;
        this.detailtypeDirtyFlag = true;
    }

    public String getDetailType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDetailType();
        }
        return this.detailtype;
    }

    public boolean isDetailTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDetailTypeDirty();
        }
        return this.detailtypeDirtyFlag;
    }

    public void resetDetailType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDetailType();
            return;
        }
        this.detailtypeDirtyFlag = false;
        this.detailtype = null;
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

    public void setGroupOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupOrderValue(n);
            return;
        }
        this.groupordervalue = n;
        this.groupordervalueDirtyFlag = true;
    }

    public Integer getGroupOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupOrderValue();
        }
        return this.groupordervalue;
    }

    public boolean isGroupOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupOrderValueDirty();
        }
        return this.groupordervalueDirtyFlag;
    }

    public void resetGroupOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupOrderValue();
            return;
        }
        this.groupordervalueDirtyFlag = false;
        this.groupordervalue = null;
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

    public void setPSDEDRDetailId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDRDetailId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedrdetailid = string;
        this.psdedrdetailidDirtyFlag = true;
    }

    public String getPSDEDRDetailId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDRDetailId();
        }
        return this.psdedrdetailid;
    }

    public boolean isPSDEDRDetailIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDRDetailIdDirty();
        }
        return this.psdedrdetailidDirtyFlag;
    }

    public void resetPSDEDRDetailId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDRDetailId();
            return;
        }
        this.psdedrdetailidDirtyFlag = false;
        this.psdedrdetailid = null;
    }

    public void setPSDEDRDetailName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDRDetailName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        if (string != null) {
            string = string.toLowerCase();
        }
        this.psdedrdetailname = string;
        this.psdedrdetailnameDirtyFlag = true;
    }

    public String getPSDEDRDetailName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDRDetailName();
        }
        return this.psdedrdetailname;
    }

    public boolean isPSDEDRDetailNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDRDetailNameDirty();
        }
        return this.psdedrdetailnameDirtyFlag;
    }

    public void resetPSDEDRDetailName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDRDetailName();
            return;
        }
        this.psdedrdetailnameDirtyFlag = false;
        this.psdedrdetailname = null;
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

    public void setPSDEDRId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDRId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedrid = string;
        this.psdedridDirtyFlag = true;
    }

    public String getPSDEDRId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDRId();
        }
        return this.psdedrid;
    }

    public boolean isPSDEDRIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDRIdDirty();
        }
        return this.psdedridDirtyFlag;
    }

    public void resetPSDEDRId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDRId();
            return;
        }
        this.psdedridDirtyFlag = false;
        this.psdedrid = null;
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

    public void setPSDEDRName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDRName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedrname = string;
        this.psdedrnameDirtyFlag = true;
    }

    public String getPSDEDRName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDRName();
        }
        return this.psdedrname;
    }

    public boolean isPSDEDRNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDRNameDirty();
        }
        return this.psdedrnameDirtyFlag;
    }

    public void resetPSDEDRName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDRName();
            return;
        }
        this.psdedrnameDirtyFlag = false;
        this.psdedrname = null;
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

    protected void onReset() {
        PSDEDRDetailBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEDRDetailBase pSDEDRDetailBase) {
        pSDEDRDetailBase.resetCapPSLanResId();
        pSDEDRDetailBase.resetCapPSLanResName();
        pSDEDRDetailBase.resetCaption();
        pSDEDRDetailBase.resetCounterId();
        pSDEDRDetailBase.resetCounterMode();
        pSDEDRDetailBase.resetCreateDate();
        pSDEDRDetailBase.resetCreateMan();
        pSDEDRDetailBase.resetData();
        pSDEDRDetailBase.resetDetailTag();
        pSDEDRDetailBase.resetDetailTag2();
        pSDEDRDetailBase.resetDetailType();
        pSDEDRDetailBase.resetDynaModelFlag();
        pSDEDRDetailBase.resetEnableMode();
        pSDEDRDetailBase.resetGroupOrderValue();
        pSDEDRDetailBase.resetHeaderPSSysPFPluginId();
        pSDEDRDetailBase.resetHeaderPSSysPFPluginName();
        pSDEDRDetailBase.resetMemo();
        pSDEDRDetailBase.resetNavViewFilter();
        pSDEDRDetailBase.resetOrderValue();
        pSDEDRDetailBase.resetPSDEDRDetailId();
        pSDEDRDetailBase.resetPSDEDRDetailName();
        pSDEDRDetailBase.resetPSDEDRGroupId();
        pSDEDRDetailBase.resetPSDEDRGroupName();
        pSDEDRDetailBase.resetPSDEDRId();
        pSDEDRDetailBase.resetPSDEDRItemId();
        pSDEDRDetailBase.resetPSDEDRItemName();
        pSDEDRDetailBase.resetPSDEDRName();
        pSDEDRDetailBase.resetPSDEId();
        pSDEDRDetailBase.resetPSDEOPPrivId();
        pSDEDRDetailBase.resetPSDEOPPrivName();
        pSDEDRDetailBase.resetPSDETreeViewId();
        pSDEDRDetailBase.resetPSDETreeViewName();
        pSDEDRDetailBase.resetPSDynaInstId();
        pSDEDRDetailBase.resetPSSysCssId();
        pSDEDRDetailBase.resetPSSysCssName();
        pSDEDRDetailBase.resetPSSysImageId();
        pSDEDRDetailBase.resetPSSysImageName();
        pSDEDRDetailBase.resetPSSysPDTViewId();
        pSDEDRDetailBase.resetPSSysPDTViewName();
        pSDEDRDetailBase.resetPSSysUniResId();
        pSDEDRDetailBase.resetPSSysUniResName();
        pSDEDRDetailBase.resetTestCustomCode();
        pSDEDRDetailBase.resetTestCustomMode();
        pSDEDRDetailBase.resetTestPSDEActionId();
        pSDEDRDetailBase.resetTestPSDEActionName();
        pSDEDRDetailBase.resetTestPSDELogicId();
        pSDEDRDetailBase.resetTestPSDELogicName();
        pSDEDRDetailBase.resetTipPSLanResId();
        pSDEDRDetailBase.resetTipPSLanResName();
        pSDEDRDetailBase.resetTooltipInfo();
        pSDEDRDetailBase.resetUpdateDate();
        pSDEDRDetailBase.resetUpdateMan();
        pSDEDRDetailBase.resetUserCat();
        pSDEDRDetailBase.resetUserTag();
        pSDEDRDetailBase.resetUserTag2();
        pSDEDRDetailBase.resetUserTag3();
        pSDEDRDetailBase.resetUserTag4();
        pSDEDRDetailBase.resetValidFlag();
        pSDEDRDetailBase.resetViewParams();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCapPSLanResIdDirty()) {
            hashMap.put(FIELD_CAPPSLANRESID, this.getCapPSLanResId());
        }
        if (!bl || this.isCapPSLanResNameDirty()) {
            hashMap.put(FIELD_CAPPSLANRESNAME, this.getCapPSLanResName());
        }
        if (!bl || this.isCaptionDirty()) {
            hashMap.put(FIELD_CAPTION, this.getCaption());
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
        if (!bl || this.isDetailTagDirty()) {
            hashMap.put(FIELD_DETAILTAG, this.getDetailTag());
        }
        if (!bl || this.isDetailTag2Dirty()) {
            hashMap.put(FIELD_DETAILTAG2, this.getDetailTag2());
        }
        if (!bl || this.isDetailTypeDirty()) {
            hashMap.put(FIELD_DETAILTYPE, this.getDetailType());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isEnableModeDirty()) {
            hashMap.put(FIELD_ENABLEMODE, this.getEnableMode());
        }
        if (!bl || this.isGroupOrderValueDirty()) {
            hashMap.put(FIELD_GROUPORDERVALUE, this.getGroupOrderValue());
        }
        if (!bl || this.isHeaderPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_HEADERPSSYSPFPLUGINID, this.getHeaderPSSysPFPluginId());
        }
        if (!bl || this.isHeaderPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_HEADERPSSYSPFPLUGINNAME, this.getHeaderPSSysPFPluginName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isNavViewFilterDirty()) {
            hashMap.put(FIELD_NAVVIEWFILTER, this.getNavViewFilter());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDEDRDetailIdDirty()) {
            hashMap.put(FIELD_PSDEDRDETAILID, this.getPSDEDRDetailId());
        }
        if (!bl || this.isPSDEDRDetailNameDirty()) {
            hashMap.put(FIELD_PSDEDRDETAILNAME, this.getPSDEDRDetailName());
        }
        if (!bl || this.isPSDEDRGroupIdDirty()) {
            hashMap.put(FIELD_PSDEDRGROUPID, this.getPSDEDRGroupId());
        }
        if (!bl || this.isPSDEDRGroupNameDirty()) {
            hashMap.put(FIELD_PSDEDRGROUPNAME, this.getPSDEDRGroupName());
        }
        if (!bl || this.isPSDEDRIdDirty()) {
            hashMap.put(FIELD_PSDEDRID, this.getPSDEDRId());
        }
        if (!bl || this.isPSDEDRItemIdDirty()) {
            hashMap.put(FIELD_PSDEDRITEMID, this.getPSDEDRItemId());
        }
        if (!bl || this.isPSDEDRItemNameDirty()) {
            hashMap.put(FIELD_PSDEDRITEMNAME, this.getPSDEDRItemName());
        }
        if (!bl || this.isPSDEDRNameDirty()) {
            hashMap.put(FIELD_PSDEDRNAME, this.getPSDEDRName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDEOPPrivIdDirty()) {
            hashMap.put(FIELD_PSDEOPPRIVID, this.getPSDEOPPrivId());
        }
        if (!bl || this.isPSDEOPPrivNameDirty()) {
            hashMap.put(FIELD_PSDEOPPRIVNAME, this.getPSDEOPPrivName());
        }
        if (!bl || this.isPSDETreeViewIdDirty()) {
            hashMap.put(FIELD_PSDETREEVIEWID, this.getPSDETreeViewId());
        }
        if (!bl || this.isPSDETreeViewNameDirty()) {
            hashMap.put(FIELD_PSDETREEVIEWNAME, this.getPSDETreeViewName());
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
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
        }
        if (!bl || this.isViewParamsDirty()) {
            hashMap.put(FIELD_VIEWPARAMS, this.getViewParams());
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
        return PSDEDRDetailBase.get(this, n);
    }

    private static Object get(PSDEDRDetailBase pSDEDRDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDRDetailBase.getCapPSLanResId();
            }
            case 1: {
                return pSDEDRDetailBase.getCapPSLanResName();
            }
            case 2: {
                return pSDEDRDetailBase.getCaption();
            }
            case 3: {
                return pSDEDRDetailBase.getCounterId();
            }
            case 4: {
                return pSDEDRDetailBase.getCounterMode();
            }
            case 5: {
                return pSDEDRDetailBase.getCreateDate();
            }
            case 6: {
                return pSDEDRDetailBase.getCreateMan();
            }
            case 7: {
                return pSDEDRDetailBase.getData();
            }
            case 8: {
                return pSDEDRDetailBase.getDetailTag();
            }
            case 9: {
                return pSDEDRDetailBase.getDetailTag2();
            }
            case 10: {
                return pSDEDRDetailBase.getDetailType();
            }
            case 11: {
                return pSDEDRDetailBase.getDynaModelFlag();
            }
            case 12: {
                return pSDEDRDetailBase.getEnableMode();
            }
            case 13: {
                return pSDEDRDetailBase.getGroupOrderValue();
            }
            case 14: {
                return pSDEDRDetailBase.getHeaderPSSysPFPluginId();
            }
            case 15: {
                return pSDEDRDetailBase.getHeaderPSSysPFPluginName();
            }
            case 16: {
                return pSDEDRDetailBase.getMemo();
            }
            case 17: {
                return pSDEDRDetailBase.getNavViewFilter();
            }
            case 18: {
                return pSDEDRDetailBase.getOrderValue();
            }
            case 19: {
                return pSDEDRDetailBase.getPSDEDRDetailId();
            }
            case 20: {
                return pSDEDRDetailBase.getPSDEDRDetailName();
            }
            case 21: {
                return pSDEDRDetailBase.getPSDEDRGroupId();
            }
            case 22: {
                return pSDEDRDetailBase.getPSDEDRGroupName();
            }
            case 23: {
                return pSDEDRDetailBase.getPSDEDRId();
            }
            case 24: {
                return pSDEDRDetailBase.getPSDEDRItemId();
            }
            case 25: {
                return pSDEDRDetailBase.getPSDEDRItemName();
            }
            case 26: {
                return pSDEDRDetailBase.getPSDEDRName();
            }
            case 27: {
                return pSDEDRDetailBase.getPSDEId();
            }
            case 28: {
                return pSDEDRDetailBase.getPSDEOPPrivId();
            }
            case 29: {
                return pSDEDRDetailBase.getPSDEOPPrivName();
            }
            case 30: {
                return pSDEDRDetailBase.getPSDETreeViewId();
            }
            case 31: {
                return pSDEDRDetailBase.getPSDETreeViewName();
            }
            case 32: {
                return pSDEDRDetailBase.getPSDynaInstId();
            }
            case 33: {
                return pSDEDRDetailBase.getPSSysCssId();
            }
            case 34: {
                return pSDEDRDetailBase.getPSSysCssName();
            }
            case 35: {
                return pSDEDRDetailBase.getPSSysImageId();
            }
            case 36: {
                return pSDEDRDetailBase.getPSSysImageName();
            }
            case 37: {
                return pSDEDRDetailBase.getPSSysPDTViewId();
            }
            case 38: {
                return pSDEDRDetailBase.getPSSysPDTViewName();
            }
            case 39: {
                return pSDEDRDetailBase.getPSSysUniResId();
            }
            case 40: {
                return pSDEDRDetailBase.getPSSysUniResName();
            }
            case 41: {
                return pSDEDRDetailBase.getTestCustomCode();
            }
            case 42: {
                return pSDEDRDetailBase.getTestCustomMode();
            }
            case 43: {
                return pSDEDRDetailBase.getTestPSDEActionId();
            }
            case 44: {
                return pSDEDRDetailBase.getTestPSDEActionName();
            }
            case 45: {
                return pSDEDRDetailBase.getTestPSDELogicId();
            }
            case 46: {
                return pSDEDRDetailBase.getTestPSDELogicName();
            }
            case 47: {
                return pSDEDRDetailBase.getTipPSLanResId();
            }
            case 48: {
                return pSDEDRDetailBase.getTipPSLanResName();
            }
            case 49: {
                return pSDEDRDetailBase.getTooltipInfo();
            }
            case 50: {
                return pSDEDRDetailBase.getUpdateDate();
            }
            case 51: {
                return pSDEDRDetailBase.getUpdateMan();
            }
            case 52: {
                return pSDEDRDetailBase.getUserCat();
            }
            case 53: {
                return pSDEDRDetailBase.getUserTag();
            }
            case 54: {
                return pSDEDRDetailBase.getUserTag2();
            }
            case 55: {
                return pSDEDRDetailBase.getUserTag3();
            }
            case 56: {
                return pSDEDRDetailBase.getUserTag4();
            }
            case 57: {
                return pSDEDRDetailBase.getValidFlag();
            }
            case 58: {
                return pSDEDRDetailBase.getViewParams();
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
        PSDEDRDetailBase.set(this, n, object);
    }

    private static void set(PSDEDRDetailBase pSDEDRDetailBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEDRDetailBase.setCapPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEDRDetailBase.setCapPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEDRDetailBase.setCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEDRDetailBase.setCounterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEDRDetailBase.setCounterMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDEDRDetailBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSDEDRDetailBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEDRDetailBase.setData(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEDRDetailBase.setDetailTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEDRDetailBase.setDetailTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEDRDetailBase.setDetailType(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEDRDetailBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDEDRDetailBase.setEnableMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEDRDetailBase.setGroupOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSDEDRDetailBase.setHeaderPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEDRDetailBase.setHeaderPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEDRDetailBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEDRDetailBase.setNavViewFilter(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEDRDetailBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSDEDRDetailBase.setPSDEDRDetailId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEDRDetailBase.setPSDEDRDetailName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEDRDetailBase.setPSDEDRGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEDRDetailBase.setPSDEDRGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEDRDetailBase.setPSDEDRId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEDRDetailBase.setPSDEDRItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEDRDetailBase.setPSDEDRItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEDRDetailBase.setPSDEDRName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEDRDetailBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEDRDetailBase.setPSDEOPPrivId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEDRDetailBase.setPSDEOPPrivName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEDRDetailBase.setPSDETreeViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEDRDetailBase.setPSDETreeViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEDRDetailBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEDRDetailBase.setPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEDRDetailBase.setPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEDRDetailBase.setPSSysImageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEDRDetailBase.setPSSysImageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDEDRDetailBase.setPSSysPDTViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEDRDetailBase.setPSSysPDTViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDEDRDetailBase.setPSSysUniResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDEDRDetailBase.setPSSysUniResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDEDRDetailBase.setTestCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDEDRDetailBase.setTestCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 43: {
                pSDEDRDetailBase.setTestPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDEDRDetailBase.setTestPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDEDRDetailBase.setTestPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDEDRDetailBase.setTestPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDEDRDetailBase.setTipPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDEDRDetailBase.setTipPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDEDRDetailBase.setTooltipInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDEDRDetailBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 51: {
                pSDEDRDetailBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSDEDRDetailBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSDEDRDetailBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSDEDRDetailBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSDEDRDetailBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSDEDRDetailBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSDEDRDetailBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 58: {
                pSDEDRDetailBase.setViewParams(DataObject.getStringValue((Object)object));
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
        return PSDEDRDetailBase.isNull(this, n);
    }

    private static boolean isNull(PSDEDRDetailBase pSDEDRDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDRDetailBase.getCapPSLanResId() == null;
            }
            case 1: {
                return pSDEDRDetailBase.getCapPSLanResName() == null;
            }
            case 2: {
                return pSDEDRDetailBase.getCaption() == null;
            }
            case 3: {
                return pSDEDRDetailBase.getCounterId() == null;
            }
            case 4: {
                return pSDEDRDetailBase.getCounterMode() == null;
            }
            case 5: {
                return pSDEDRDetailBase.getCreateDate() == null;
            }
            case 6: {
                return pSDEDRDetailBase.getCreateMan() == null;
            }
            case 7: {
                return pSDEDRDetailBase.getData() == null;
            }
            case 8: {
                return pSDEDRDetailBase.getDetailTag() == null;
            }
            case 9: {
                return pSDEDRDetailBase.getDetailTag2() == null;
            }
            case 10: {
                return pSDEDRDetailBase.getDetailType() == null;
            }
            case 11: {
                return pSDEDRDetailBase.getDynaModelFlag() == null;
            }
            case 12: {
                return pSDEDRDetailBase.getEnableMode() == null;
            }
            case 13: {
                return pSDEDRDetailBase.getGroupOrderValue() == null;
            }
            case 14: {
                return pSDEDRDetailBase.getHeaderPSSysPFPluginId() == null;
            }
            case 15: {
                return pSDEDRDetailBase.getHeaderPSSysPFPluginName() == null;
            }
            case 16: {
                return pSDEDRDetailBase.getMemo() == null;
            }
            case 17: {
                return pSDEDRDetailBase.getNavViewFilter() == null;
            }
            case 18: {
                return pSDEDRDetailBase.getOrderValue() == null;
            }
            case 19: {
                return pSDEDRDetailBase.getPSDEDRDetailId() == null;
            }
            case 20: {
                return pSDEDRDetailBase.getPSDEDRDetailName() == null;
            }
            case 21: {
                return pSDEDRDetailBase.getPSDEDRGroupId() == null;
            }
            case 22: {
                return pSDEDRDetailBase.getPSDEDRGroupName() == null;
            }
            case 23: {
                return pSDEDRDetailBase.getPSDEDRId() == null;
            }
            case 24: {
                return pSDEDRDetailBase.getPSDEDRItemId() == null;
            }
            case 25: {
                return pSDEDRDetailBase.getPSDEDRItemName() == null;
            }
            case 26: {
                return pSDEDRDetailBase.getPSDEDRName() == null;
            }
            case 27: {
                return pSDEDRDetailBase.getPSDEId() == null;
            }
            case 28: {
                return pSDEDRDetailBase.getPSDEOPPrivId() == null;
            }
            case 29: {
                return pSDEDRDetailBase.getPSDEOPPrivName() == null;
            }
            case 30: {
                return pSDEDRDetailBase.getPSDETreeViewId() == null;
            }
            case 31: {
                return pSDEDRDetailBase.getPSDETreeViewName() == null;
            }
            case 32: {
                return pSDEDRDetailBase.getPSDynaInstId() == null;
            }
            case 33: {
                return pSDEDRDetailBase.getPSSysCssId() == null;
            }
            case 34: {
                return pSDEDRDetailBase.getPSSysCssName() == null;
            }
            case 35: {
                return pSDEDRDetailBase.getPSSysImageId() == null;
            }
            case 36: {
                return pSDEDRDetailBase.getPSSysImageName() == null;
            }
            case 37: {
                return pSDEDRDetailBase.getPSSysPDTViewId() == null;
            }
            case 38: {
                return pSDEDRDetailBase.getPSSysPDTViewName() == null;
            }
            case 39: {
                return pSDEDRDetailBase.getPSSysUniResId() == null;
            }
            case 40: {
                return pSDEDRDetailBase.getPSSysUniResName() == null;
            }
            case 41: {
                return pSDEDRDetailBase.getTestCustomCode() == null;
            }
            case 42: {
                return pSDEDRDetailBase.getTestCustomMode() == null;
            }
            case 43: {
                return pSDEDRDetailBase.getTestPSDEActionId() == null;
            }
            case 44: {
                return pSDEDRDetailBase.getTestPSDEActionName() == null;
            }
            case 45: {
                return pSDEDRDetailBase.getTestPSDELogicId() == null;
            }
            case 46: {
                return pSDEDRDetailBase.getTestPSDELogicName() == null;
            }
            case 47: {
                return pSDEDRDetailBase.getTipPSLanResId() == null;
            }
            case 48: {
                return pSDEDRDetailBase.getTipPSLanResName() == null;
            }
            case 49: {
                return pSDEDRDetailBase.getTooltipInfo() == null;
            }
            case 50: {
                return pSDEDRDetailBase.getUpdateDate() == null;
            }
            case 51: {
                return pSDEDRDetailBase.getUpdateMan() == null;
            }
            case 52: {
                return pSDEDRDetailBase.getUserCat() == null;
            }
            case 53: {
                return pSDEDRDetailBase.getUserTag() == null;
            }
            case 54: {
                return pSDEDRDetailBase.getUserTag2() == null;
            }
            case 55: {
                return pSDEDRDetailBase.getUserTag3() == null;
            }
            case 56: {
                return pSDEDRDetailBase.getUserTag4() == null;
            }
            case 57: {
                return pSDEDRDetailBase.getValidFlag() == null;
            }
            case 58: {
                return pSDEDRDetailBase.getViewParams() == null;
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
        return PSDEDRDetailBase.contains(this, n);
    }

    private static boolean contains(PSDEDRDetailBase pSDEDRDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDRDetailBase.isCapPSLanResIdDirty();
            }
            case 1: {
                return pSDEDRDetailBase.isCapPSLanResNameDirty();
            }
            case 2: {
                return pSDEDRDetailBase.isCaptionDirty();
            }
            case 3: {
                return pSDEDRDetailBase.isCounterIdDirty();
            }
            case 4: {
                return pSDEDRDetailBase.isCounterModeDirty();
            }
            case 5: {
                return pSDEDRDetailBase.isCreateDateDirty();
            }
            case 6: {
                return pSDEDRDetailBase.isCreateManDirty();
            }
            case 7: {
                return pSDEDRDetailBase.isDataDirty();
            }
            case 8: {
                return pSDEDRDetailBase.isDetailTagDirty();
            }
            case 9: {
                return pSDEDRDetailBase.isDetailTag2Dirty();
            }
            case 10: {
                return pSDEDRDetailBase.isDetailTypeDirty();
            }
            case 11: {
                return pSDEDRDetailBase.isDynaModelFlagDirty();
            }
            case 12: {
                return pSDEDRDetailBase.isEnableModeDirty();
            }
            case 13: {
                return pSDEDRDetailBase.isGroupOrderValueDirty();
            }
            case 14: {
                return pSDEDRDetailBase.isHeaderPSSysPFPluginIdDirty();
            }
            case 15: {
                return pSDEDRDetailBase.isHeaderPSSysPFPluginNameDirty();
            }
            case 16: {
                return pSDEDRDetailBase.isMemoDirty();
            }
            case 17: {
                return pSDEDRDetailBase.isNavViewFilterDirty();
            }
            case 18: {
                return pSDEDRDetailBase.isOrderValueDirty();
            }
            case 19: {
                return pSDEDRDetailBase.isPSDEDRDetailIdDirty();
            }
            case 20: {
                return pSDEDRDetailBase.isPSDEDRDetailNameDirty();
            }
            case 21: {
                return pSDEDRDetailBase.isPSDEDRGroupIdDirty();
            }
            case 22: {
                return pSDEDRDetailBase.isPSDEDRGroupNameDirty();
            }
            case 23: {
                return pSDEDRDetailBase.isPSDEDRIdDirty();
            }
            case 24: {
                return pSDEDRDetailBase.isPSDEDRItemIdDirty();
            }
            case 25: {
                return pSDEDRDetailBase.isPSDEDRItemNameDirty();
            }
            case 26: {
                return pSDEDRDetailBase.isPSDEDRNameDirty();
            }
            case 27: {
                return pSDEDRDetailBase.isPSDEIdDirty();
            }
            case 28: {
                return pSDEDRDetailBase.isPSDEOPPrivIdDirty();
            }
            case 29: {
                return pSDEDRDetailBase.isPSDEOPPrivNameDirty();
            }
            case 30: {
                return pSDEDRDetailBase.isPSDETreeViewIdDirty();
            }
            case 31: {
                return pSDEDRDetailBase.isPSDETreeViewNameDirty();
            }
            case 32: {
                return pSDEDRDetailBase.isPSDynaInstIdDirty();
            }
            case 33: {
                return pSDEDRDetailBase.isPSSysCssIdDirty();
            }
            case 34: {
                return pSDEDRDetailBase.isPSSysCssNameDirty();
            }
            case 35: {
                return pSDEDRDetailBase.isPSSysImageIdDirty();
            }
            case 36: {
                return pSDEDRDetailBase.isPSSysImageNameDirty();
            }
            case 37: {
                return pSDEDRDetailBase.isPSSysPDTViewIdDirty();
            }
            case 38: {
                return pSDEDRDetailBase.isPSSysPDTViewNameDirty();
            }
            case 39: {
                return pSDEDRDetailBase.isPSSysUniResIdDirty();
            }
            case 40: {
                return pSDEDRDetailBase.isPSSysUniResNameDirty();
            }
            case 41: {
                return pSDEDRDetailBase.isTestCustomCodeDirty();
            }
            case 42: {
                return pSDEDRDetailBase.isTestCustomModeDirty();
            }
            case 43: {
                return pSDEDRDetailBase.isTestPSDEActionIdDirty();
            }
            case 44: {
                return pSDEDRDetailBase.isTestPSDEActionNameDirty();
            }
            case 45: {
                return pSDEDRDetailBase.isTestPSDELogicIdDirty();
            }
            case 46: {
                return pSDEDRDetailBase.isTestPSDELogicNameDirty();
            }
            case 47: {
                return pSDEDRDetailBase.isTipPSLanResIdDirty();
            }
            case 48: {
                return pSDEDRDetailBase.isTipPSLanResNameDirty();
            }
            case 49: {
                return pSDEDRDetailBase.isTooltipInfoDirty();
            }
            case 50: {
                return pSDEDRDetailBase.isUpdateDateDirty();
            }
            case 51: {
                return pSDEDRDetailBase.isUpdateManDirty();
            }
            case 52: {
                return pSDEDRDetailBase.isUserCatDirty();
            }
            case 53: {
                return pSDEDRDetailBase.isUserTagDirty();
            }
            case 54: {
                return pSDEDRDetailBase.isUserTag2Dirty();
            }
            case 55: {
                return pSDEDRDetailBase.isUserTag3Dirty();
            }
            case 56: {
                return pSDEDRDetailBase.isUserTag4Dirty();
            }
            case 57: {
                return pSDEDRDetailBase.isValidFlagDirty();
            }
            case 58: {
                return pSDEDRDetailBase.isViewParamsDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEDRDetailBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEDRDetailBase pSDEDRDetailBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEDRDetailBase.getCapPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresid", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getCapPSLanResId()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getCapPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresname", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getCapPSLanResName()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"caption", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getCaption()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getCounterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"counterid", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getCounterId()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getCounterMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"countermode", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getCounterMode()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"data", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getData()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getDetailTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detailtag", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getDetailTag()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getDetailTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detailtag2", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getDetailTag2()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getDetailType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detailtype", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getDetailType()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getEnableMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablemode", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getEnableMode()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getGroupOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupordervalue", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getGroupOrderValue()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getHeaderPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"headerpssyspfpluginid", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getHeaderPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getHeaderPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"headerpssyspfpluginname", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getHeaderPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getNavViewFilter() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewfilter", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getNavViewFilter()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getPSDEDRDetailId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedrdetailid", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getPSDEDRDetailId()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getPSDEDRDetailName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedrdetailname", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getPSDEDRDetailName()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getPSDEDRGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedrgroupid", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getPSDEDRGroupId()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getPSDEDRGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedrgroupname", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getPSDEDRGroupName()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getPSDEDRId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedrid", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getPSDEDRId()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getPSDEDRItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedritemid", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getPSDEDRItemId()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getPSDEDRItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedritemname", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getPSDEDRItemName()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getPSDEDRName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedrname", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getPSDEDRName()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getPSDEOPPrivId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeopprivid", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getPSDEOPPrivId()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getPSDEOPPrivName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeopprivname", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getPSDEOPPrivName()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getPSDETreeViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreeviewid", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getPSDETreeViewId()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getPSDETreeViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreeviewname", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getPSDETreeViewName()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssid", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getPSSysCssId()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssname", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getPSSysCssName()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getPSSysImageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimageid", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getPSSysImageId()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getPSSysImageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimagename", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getPSSysImageName()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getPSSysPDTViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspdtviewid", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getPSSysPDTViewId()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getPSSysPDTViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspdtviewname", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getPSSysPDTViewName()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getPSSysUniResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuniresid", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getPSSysUniResId()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getPSSysUniResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuniresname", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getPSSysUniResName()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getTestCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"testcustomcode", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getTestCustomCode()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getTestCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"testcustommode", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getTestCustomMode()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getTestPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"testpsdeactionid", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getTestPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getTestPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"testpsdeactionname", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getTestPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getTestPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"testpsdelogicid", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getTestPSDELogicId()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getTestPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"testpsdelogicname", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getTestPSDELogicName()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getTipPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tippslanresid", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getTipPSLanResId()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getTipPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tippslanresname", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getTipPSLanResName()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getTooltipInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tooltipinfo", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getTooltipInfo()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSDEDRDetailBase.getViewParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparams", (Object)PSDEDRDetailBase.getJSONValue((Object)pSDEDRDetailBase.getViewParams()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEDRDetailBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEDRDetailBase pSDEDRDetailBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEDRDetailBase.getCapPSLanResId() != null) {
            object = pSDEDRDetailBase.getCapPSLanResId();
            xmlNode.setAttribute(FIELD_CAPPSLANRESID, (String)(object == null ? "" : object));
        }
        if (bl || pSDEDRDetailBase.getCapPSLanResName() != null) {
            object = pSDEDRDetailBase.getCapPSLanResName();
            xmlNode.setAttribute(FIELD_CAPPSLANRESNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEDRDetailBase.getCaption() != null) {
            object = pSDEDRDetailBase.getCaption();
            xmlNode.setAttribute(FIELD_CAPTION, (String)(object == null ? "" : object));
        }
        if (bl || pSDEDRDetailBase.getCounterId() != null) {
            object = pSDEDRDetailBase.getCounterId();
            xmlNode.setAttribute(FIELD_COUNTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getCounterMode() != null) {
            object = pSDEDRDetailBase.getCounterMode();
            xmlNode.setAttribute(FIELD_COUNTERMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDRDetailBase.getCreateDate() != null) {
            object = pSDEDRDetailBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDRDetailBase.getCreateMan() != null) {
            object = pSDEDRDetailBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getData() != null) {
            object = pSDEDRDetailBase.getData();
            xmlNode.setAttribute(FIELD_DATA, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getDetailTag() != null) {
            object = pSDEDRDetailBase.getDetailTag();
            xmlNode.setAttribute(FIELD_DETAILTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getDetailTag2() != null) {
            object = pSDEDRDetailBase.getDetailTag2();
            xmlNode.setAttribute(FIELD_DETAILTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getDetailType() != null) {
            object = pSDEDRDetailBase.getDetailType();
            xmlNode.setAttribute(FIELD_DETAILTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getDynaModelFlag() != null) {
            object = pSDEDRDetailBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDRDetailBase.getEnableMode() != null) {
            object = pSDEDRDetailBase.getEnableMode();
            xmlNode.setAttribute(FIELD_ENABLEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getGroupOrderValue() != null) {
            object = pSDEDRDetailBase.getGroupOrderValue();
            xmlNode.setAttribute(FIELD_GROUPORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDRDetailBase.getHeaderPSSysPFPluginId() != null) {
            object = pSDEDRDetailBase.getHeaderPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_HEADERPSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getHeaderPSSysPFPluginName() != null) {
            object = pSDEDRDetailBase.getHeaderPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_HEADERPSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getMemo() != null) {
            object = pSDEDRDetailBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getNavViewFilter() != null) {
            object = pSDEDRDetailBase.getNavViewFilter();
            xmlNode.setAttribute(FIELD_NAVVIEWFILTER, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getOrderValue() != null) {
            object = pSDEDRDetailBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDRDetailBase.getPSDEDRDetailId() != null) {
            object = pSDEDRDetailBase.getPSDEDRDetailId();
            xmlNode.setAttribute(FIELD_PSDEDRDETAILID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getPSDEDRDetailName() != null) {
            object = pSDEDRDetailBase.getPSDEDRDetailName();
            xmlNode.setAttribute(FIELD_PSDEDRDETAILNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getPSDEDRGroupId() != null) {
            object = pSDEDRDetailBase.getPSDEDRGroupId();
            xmlNode.setAttribute(FIELD_PSDEDRGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getPSDEDRGroupName() != null) {
            object = pSDEDRDetailBase.getPSDEDRGroupName();
            xmlNode.setAttribute(FIELD_PSDEDRGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getPSDEDRId() != null) {
            object = pSDEDRDetailBase.getPSDEDRId();
            xmlNode.setAttribute(FIELD_PSDEDRID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getPSDEDRItemId() != null) {
            object = pSDEDRDetailBase.getPSDEDRItemId();
            xmlNode.setAttribute(FIELD_PSDEDRITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getPSDEDRItemName() != null) {
            object = pSDEDRDetailBase.getPSDEDRItemName();
            xmlNode.setAttribute(FIELD_PSDEDRITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getPSDEDRName() != null) {
            object = pSDEDRDetailBase.getPSDEDRName();
            xmlNode.setAttribute(FIELD_PSDEDRNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getPSDEId() != null) {
            object = pSDEDRDetailBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getPSDEOPPrivId() != null) {
            object = pSDEDRDetailBase.getPSDEOPPrivId();
            xmlNode.setAttribute(FIELD_PSDEOPPRIVID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getPSDEOPPrivName() != null) {
            object = pSDEDRDetailBase.getPSDEOPPrivName();
            xmlNode.setAttribute(FIELD_PSDEOPPRIVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getPSDETreeViewId() != null) {
            object = pSDEDRDetailBase.getPSDETreeViewId();
            xmlNode.setAttribute(FIELD_PSDETREEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getPSDETreeViewName() != null) {
            object = pSDEDRDetailBase.getPSDETreeViewName();
            xmlNode.setAttribute(FIELD_PSDETREEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getPSDynaInstId() != null) {
            object = pSDEDRDetailBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getPSSysCssId() != null) {
            object = pSDEDRDetailBase.getPSSysCssId();
            xmlNode.setAttribute(FIELD_PSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getPSSysCssName() != null) {
            object = pSDEDRDetailBase.getPSSysCssName();
            xmlNode.setAttribute(FIELD_PSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getPSSysImageId() != null) {
            object = pSDEDRDetailBase.getPSSysImageId();
            xmlNode.setAttribute(FIELD_PSSYSIMAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getPSSysImageName() != null) {
            object = pSDEDRDetailBase.getPSSysImageName();
            xmlNode.setAttribute(FIELD_PSSYSIMAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getPSSysPDTViewId() != null) {
            object = pSDEDRDetailBase.getPSSysPDTViewId();
            xmlNode.setAttribute(FIELD_PSSYSPDTVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getPSSysPDTViewName() != null) {
            object = pSDEDRDetailBase.getPSSysPDTViewName();
            xmlNode.setAttribute(FIELD_PSSYSPDTVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getPSSysUniResId() != null) {
            object = pSDEDRDetailBase.getPSSysUniResId();
            xmlNode.setAttribute(FIELD_PSSYSUNIRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getPSSysUniResName() != null) {
            object = pSDEDRDetailBase.getPSSysUniResName();
            xmlNode.setAttribute(FIELD_PSSYSUNIRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getTestCustomCode() != null) {
            object = pSDEDRDetailBase.getTestCustomCode();
            xmlNode.setAttribute(FIELD_TESTCUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getTestCustomMode() != null) {
            object = pSDEDRDetailBase.getTestCustomMode();
            xmlNode.setAttribute(FIELD_TESTCUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDRDetailBase.getTestPSDEActionId() != null) {
            object = pSDEDRDetailBase.getTestPSDEActionId();
            xmlNode.setAttribute(FIELD_TESTPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getTestPSDEActionName() != null) {
            object = pSDEDRDetailBase.getTestPSDEActionName();
            xmlNode.setAttribute(FIELD_TESTPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getTestPSDELogicId() != null) {
            object = pSDEDRDetailBase.getTestPSDELogicId();
            xmlNode.setAttribute(FIELD_TESTPSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getTestPSDELogicName() != null) {
            object = pSDEDRDetailBase.getTestPSDELogicName();
            xmlNode.setAttribute(FIELD_TESTPSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getTipPSLanResId() != null) {
            object = pSDEDRDetailBase.getTipPSLanResId();
            xmlNode.setAttribute(FIELD_TIPPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getTipPSLanResName() != null) {
            object = pSDEDRDetailBase.getTipPSLanResName();
            xmlNode.setAttribute(FIELD_TIPPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getTooltipInfo() != null) {
            object = pSDEDRDetailBase.getTooltipInfo();
            xmlNode.setAttribute(FIELD_TOOLTIPINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getUpdateDate() != null) {
            object = pSDEDRDetailBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDRDetailBase.getUpdateMan() != null) {
            object = pSDEDRDetailBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getUserCat() != null) {
            object = pSDEDRDetailBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getUserTag() != null) {
            object = pSDEDRDetailBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getUserTag2() != null) {
            object = pSDEDRDetailBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getUserTag3() != null) {
            object = pSDEDRDetailBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getUserTag4() != null) {
            object = pSDEDRDetailBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRDetailBase.getValidFlag() != null) {
            object = pSDEDRDetailBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDRDetailBase.getViewParams() != null) {
            object = pSDEDRDetailBase.getViewParams();
            xmlNode.setAttribute(FIELD_VIEWPARAMS, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEDRDetailBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEDRDetailBase pSDEDRDetailBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEDRDetailBase.isCapPSLanResIdDirty() && (bl || pSDEDRDetailBase.getCapPSLanResId() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESID, (Object)pSDEDRDetailBase.getCapPSLanResId());
        }
        if (pSDEDRDetailBase.isCapPSLanResNameDirty() && (bl || pSDEDRDetailBase.getCapPSLanResName() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESNAME, (Object)pSDEDRDetailBase.getCapPSLanResName());
        }
        if (pSDEDRDetailBase.isCaptionDirty() && (bl || pSDEDRDetailBase.getCaption() != null)) {
            iDataObject.set(FIELD_CAPTION, (Object)pSDEDRDetailBase.getCaption());
        }
        if (pSDEDRDetailBase.isCounterIdDirty() && (bl || pSDEDRDetailBase.getCounterId() != null)) {
            iDataObject.set(FIELD_COUNTERID, (Object)pSDEDRDetailBase.getCounterId());
        }
        if (pSDEDRDetailBase.isCounterModeDirty() && (bl || pSDEDRDetailBase.getCounterMode() != null)) {
            iDataObject.set(FIELD_COUNTERMODE, (Object)pSDEDRDetailBase.getCounterMode());
        }
        if (pSDEDRDetailBase.isCreateDateDirty() && (bl || pSDEDRDetailBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEDRDetailBase.getCreateDate());
        }
        if (pSDEDRDetailBase.isCreateManDirty() && (bl || pSDEDRDetailBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEDRDetailBase.getCreateMan());
        }
        if (pSDEDRDetailBase.isDataDirty() && (bl || pSDEDRDetailBase.getData() != null)) {
            iDataObject.set(FIELD_DATA, (Object)pSDEDRDetailBase.getData());
        }
        if (pSDEDRDetailBase.isDetailTagDirty() && (bl || pSDEDRDetailBase.getDetailTag() != null)) {
            iDataObject.set(FIELD_DETAILTAG, (Object)pSDEDRDetailBase.getDetailTag());
        }
        if (pSDEDRDetailBase.isDetailTag2Dirty() && (bl || pSDEDRDetailBase.getDetailTag2() != null)) {
            iDataObject.set(FIELD_DETAILTAG2, (Object)pSDEDRDetailBase.getDetailTag2());
        }
        if (pSDEDRDetailBase.isDetailTypeDirty() && (bl || pSDEDRDetailBase.getDetailType() != null)) {
            iDataObject.set(FIELD_DETAILTYPE, (Object)pSDEDRDetailBase.getDetailType());
        }
        if (pSDEDRDetailBase.isDynaModelFlagDirty() && (bl || pSDEDRDetailBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDEDRDetailBase.getDynaModelFlag());
        }
        if (pSDEDRDetailBase.isEnableModeDirty() && (bl || pSDEDRDetailBase.getEnableMode() != null)) {
            iDataObject.set(FIELD_ENABLEMODE, (Object)pSDEDRDetailBase.getEnableMode());
        }
        if (pSDEDRDetailBase.isGroupOrderValueDirty() && (bl || pSDEDRDetailBase.getGroupOrderValue() != null)) {
            iDataObject.set(FIELD_GROUPORDERVALUE, (Object)pSDEDRDetailBase.getGroupOrderValue());
        }
        if (pSDEDRDetailBase.isHeaderPSSysPFPluginIdDirty() && (bl || pSDEDRDetailBase.getHeaderPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_HEADERPSSYSPFPLUGINID, (Object)pSDEDRDetailBase.getHeaderPSSysPFPluginId());
        }
        if (pSDEDRDetailBase.isHeaderPSSysPFPluginNameDirty() && (bl || pSDEDRDetailBase.getHeaderPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_HEADERPSSYSPFPLUGINNAME, (Object)pSDEDRDetailBase.getHeaderPSSysPFPluginName());
        }
        if (pSDEDRDetailBase.isMemoDirty() && (bl || pSDEDRDetailBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEDRDetailBase.getMemo());
        }
        if (pSDEDRDetailBase.isNavViewFilterDirty() && (bl || pSDEDRDetailBase.getNavViewFilter() != null)) {
            iDataObject.set(FIELD_NAVVIEWFILTER, (Object)pSDEDRDetailBase.getNavViewFilter());
        }
        if (pSDEDRDetailBase.isOrderValueDirty() && (bl || pSDEDRDetailBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEDRDetailBase.getOrderValue());
        }
        if (pSDEDRDetailBase.isPSDEDRDetailIdDirty() && (bl || pSDEDRDetailBase.getPSDEDRDetailId() != null)) {
            iDataObject.set(FIELD_PSDEDRDETAILID, (Object)pSDEDRDetailBase.getPSDEDRDetailId());
        }
        if (pSDEDRDetailBase.isPSDEDRDetailNameDirty() && (bl || pSDEDRDetailBase.getPSDEDRDetailName() != null)) {
            iDataObject.set(FIELD_PSDEDRDETAILNAME, (Object)pSDEDRDetailBase.getPSDEDRDetailName());
        }
        if (pSDEDRDetailBase.isPSDEDRGroupIdDirty() && (bl || pSDEDRDetailBase.getPSDEDRGroupId() != null)) {
            iDataObject.set(FIELD_PSDEDRGROUPID, (Object)pSDEDRDetailBase.getPSDEDRGroupId());
        }
        if (pSDEDRDetailBase.isPSDEDRGroupNameDirty() && (bl || pSDEDRDetailBase.getPSDEDRGroupName() != null)) {
            iDataObject.set(FIELD_PSDEDRGROUPNAME, (Object)pSDEDRDetailBase.getPSDEDRGroupName());
        }
        if (pSDEDRDetailBase.isPSDEDRIdDirty() && (bl || pSDEDRDetailBase.getPSDEDRId() != null)) {
            iDataObject.set(FIELD_PSDEDRID, (Object)pSDEDRDetailBase.getPSDEDRId());
        }
        if (pSDEDRDetailBase.isPSDEDRItemIdDirty() && (bl || pSDEDRDetailBase.getPSDEDRItemId() != null)) {
            iDataObject.set(FIELD_PSDEDRITEMID, (Object)pSDEDRDetailBase.getPSDEDRItemId());
        }
        if (pSDEDRDetailBase.isPSDEDRItemNameDirty() && (bl || pSDEDRDetailBase.getPSDEDRItemName() != null)) {
            iDataObject.set(FIELD_PSDEDRITEMNAME, (Object)pSDEDRDetailBase.getPSDEDRItemName());
        }
        if (pSDEDRDetailBase.isPSDEDRNameDirty() && (bl || pSDEDRDetailBase.getPSDEDRName() != null)) {
            iDataObject.set(FIELD_PSDEDRNAME, (Object)pSDEDRDetailBase.getPSDEDRName());
        }
        if (pSDEDRDetailBase.isPSDEIdDirty() && (bl || pSDEDRDetailBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEDRDetailBase.getPSDEId());
        }
        if (pSDEDRDetailBase.isPSDEOPPrivIdDirty() && (bl || pSDEDRDetailBase.getPSDEOPPrivId() != null)) {
            iDataObject.set(FIELD_PSDEOPPRIVID, (Object)pSDEDRDetailBase.getPSDEOPPrivId());
        }
        if (pSDEDRDetailBase.isPSDEOPPrivNameDirty() && (bl || pSDEDRDetailBase.getPSDEOPPrivName() != null)) {
            iDataObject.set(FIELD_PSDEOPPRIVNAME, (Object)pSDEDRDetailBase.getPSDEOPPrivName());
        }
        if (pSDEDRDetailBase.isPSDETreeViewIdDirty() && (bl || pSDEDRDetailBase.getPSDETreeViewId() != null)) {
            iDataObject.set(FIELD_PSDETREEVIEWID, (Object)pSDEDRDetailBase.getPSDETreeViewId());
        }
        if (pSDEDRDetailBase.isPSDETreeViewNameDirty() && (bl || pSDEDRDetailBase.getPSDETreeViewName() != null)) {
            iDataObject.set(FIELD_PSDETREEVIEWNAME, (Object)pSDEDRDetailBase.getPSDETreeViewName());
        }
        if (pSDEDRDetailBase.isPSDynaInstIdDirty() && (bl || pSDEDRDetailBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDEDRDetailBase.getPSDynaInstId());
        }
        if (pSDEDRDetailBase.isPSSysCssIdDirty() && (bl || pSDEDRDetailBase.getPSSysCssId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSID, (Object)pSDEDRDetailBase.getPSSysCssId());
        }
        if (pSDEDRDetailBase.isPSSysCssNameDirty() && (bl || pSDEDRDetailBase.getPSSysCssName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSNAME, (Object)pSDEDRDetailBase.getPSSysCssName());
        }
        if (pSDEDRDetailBase.isPSSysImageIdDirty() && (bl || pSDEDRDetailBase.getPSSysImageId() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGEID, (Object)pSDEDRDetailBase.getPSSysImageId());
        }
        if (pSDEDRDetailBase.isPSSysImageNameDirty() && (bl || pSDEDRDetailBase.getPSSysImageName() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGENAME, (Object)pSDEDRDetailBase.getPSSysImageName());
        }
        if (pSDEDRDetailBase.isPSSysPDTViewIdDirty() && (bl || pSDEDRDetailBase.getPSSysPDTViewId() != null)) {
            iDataObject.set(FIELD_PSSYSPDTVIEWID, (Object)pSDEDRDetailBase.getPSSysPDTViewId());
        }
        if (pSDEDRDetailBase.isPSSysPDTViewNameDirty() && (bl || pSDEDRDetailBase.getPSSysPDTViewName() != null)) {
            iDataObject.set(FIELD_PSSYSPDTVIEWNAME, (Object)pSDEDRDetailBase.getPSSysPDTViewName());
        }
        if (pSDEDRDetailBase.isPSSysUniResIdDirty() && (bl || pSDEDRDetailBase.getPSSysUniResId() != null)) {
            iDataObject.set(FIELD_PSSYSUNIRESID, (Object)pSDEDRDetailBase.getPSSysUniResId());
        }
        if (pSDEDRDetailBase.isPSSysUniResNameDirty() && (bl || pSDEDRDetailBase.getPSSysUniResName() != null)) {
            iDataObject.set(FIELD_PSSYSUNIRESNAME, (Object)pSDEDRDetailBase.getPSSysUniResName());
        }
        if (pSDEDRDetailBase.isTestCustomCodeDirty() && (bl || pSDEDRDetailBase.getTestCustomCode() != null)) {
            iDataObject.set(FIELD_TESTCUSTOMCODE, (Object)pSDEDRDetailBase.getTestCustomCode());
        }
        if (pSDEDRDetailBase.isTestCustomModeDirty() && (bl || pSDEDRDetailBase.getTestCustomMode() != null)) {
            iDataObject.set(FIELD_TESTCUSTOMMODE, (Object)pSDEDRDetailBase.getTestCustomMode());
        }
        if (pSDEDRDetailBase.isTestPSDEActionIdDirty() && (bl || pSDEDRDetailBase.getTestPSDEActionId() != null)) {
            iDataObject.set(FIELD_TESTPSDEACTIONID, (Object)pSDEDRDetailBase.getTestPSDEActionId());
        }
        if (pSDEDRDetailBase.isTestPSDEActionNameDirty() && (bl || pSDEDRDetailBase.getTestPSDEActionName() != null)) {
            iDataObject.set(FIELD_TESTPSDEACTIONNAME, (Object)pSDEDRDetailBase.getTestPSDEActionName());
        }
        if (pSDEDRDetailBase.isTestPSDELogicIdDirty() && (bl || pSDEDRDetailBase.getTestPSDELogicId() != null)) {
            iDataObject.set(FIELD_TESTPSDELOGICID, (Object)pSDEDRDetailBase.getTestPSDELogicId());
        }
        if (pSDEDRDetailBase.isTestPSDELogicNameDirty() && (bl || pSDEDRDetailBase.getTestPSDELogicName() != null)) {
            iDataObject.set(FIELD_TESTPSDELOGICNAME, (Object)pSDEDRDetailBase.getTestPSDELogicName());
        }
        if (pSDEDRDetailBase.isTipPSLanResIdDirty() && (bl || pSDEDRDetailBase.getTipPSLanResId() != null)) {
            iDataObject.set(FIELD_TIPPSLANRESID, (Object)pSDEDRDetailBase.getTipPSLanResId());
        }
        if (pSDEDRDetailBase.isTipPSLanResNameDirty() && (bl || pSDEDRDetailBase.getTipPSLanResName() != null)) {
            iDataObject.set(FIELD_TIPPSLANRESNAME, (Object)pSDEDRDetailBase.getTipPSLanResName());
        }
        if (pSDEDRDetailBase.isTooltipInfoDirty() && (bl || pSDEDRDetailBase.getTooltipInfo() != null)) {
            iDataObject.set(FIELD_TOOLTIPINFO, (Object)pSDEDRDetailBase.getTooltipInfo());
        }
        if (pSDEDRDetailBase.isUpdateDateDirty() && (bl || pSDEDRDetailBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEDRDetailBase.getUpdateDate());
        }
        if (pSDEDRDetailBase.isUpdateManDirty() && (bl || pSDEDRDetailBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEDRDetailBase.getUpdateMan());
        }
        if (pSDEDRDetailBase.isUserCatDirty() && (bl || pSDEDRDetailBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEDRDetailBase.getUserCat());
        }
        if (pSDEDRDetailBase.isUserTagDirty() && (bl || pSDEDRDetailBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEDRDetailBase.getUserTag());
        }
        if (pSDEDRDetailBase.isUserTag2Dirty() && (bl || pSDEDRDetailBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEDRDetailBase.getUserTag2());
        }
        if (pSDEDRDetailBase.isUserTag3Dirty() && (bl || pSDEDRDetailBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEDRDetailBase.getUserTag3());
        }
        if (pSDEDRDetailBase.isUserTag4Dirty() && (bl || pSDEDRDetailBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEDRDetailBase.getUserTag4());
        }
        if (pSDEDRDetailBase.isValidFlagDirty() && (bl || pSDEDRDetailBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEDRDetailBase.getValidFlag());
        }
        if (pSDEDRDetailBase.isViewParamsDirty() && (bl || pSDEDRDetailBase.getViewParams() != null)) {
            iDataObject.set(FIELD_VIEWPARAMS, (Object)pSDEDRDetailBase.getViewParams());
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
        return PSDEDRDetailBase.remove(this, n);
    }

    private static boolean remove(PSDEDRDetailBase pSDEDRDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEDRDetailBase.resetCapPSLanResId();
                return true;
            }
            case 1: {
                pSDEDRDetailBase.resetCapPSLanResName();
                return true;
            }
            case 2: {
                pSDEDRDetailBase.resetCaption();
                return true;
            }
            case 3: {
                pSDEDRDetailBase.resetCounterId();
                return true;
            }
            case 4: {
                pSDEDRDetailBase.resetCounterMode();
                return true;
            }
            case 5: {
                pSDEDRDetailBase.resetCreateDate();
                return true;
            }
            case 6: {
                pSDEDRDetailBase.resetCreateMan();
                return true;
            }
            case 7: {
                pSDEDRDetailBase.resetData();
                return true;
            }
            case 8: {
                pSDEDRDetailBase.resetDetailTag();
                return true;
            }
            case 9: {
                pSDEDRDetailBase.resetDetailTag2();
                return true;
            }
            case 10: {
                pSDEDRDetailBase.resetDetailType();
                return true;
            }
            case 11: {
                pSDEDRDetailBase.resetDynaModelFlag();
                return true;
            }
            case 12: {
                pSDEDRDetailBase.resetEnableMode();
                return true;
            }
            case 13: {
                pSDEDRDetailBase.resetGroupOrderValue();
                return true;
            }
            case 14: {
                pSDEDRDetailBase.resetHeaderPSSysPFPluginId();
                return true;
            }
            case 15: {
                pSDEDRDetailBase.resetHeaderPSSysPFPluginName();
                return true;
            }
            case 16: {
                pSDEDRDetailBase.resetMemo();
                return true;
            }
            case 17: {
                pSDEDRDetailBase.resetNavViewFilter();
                return true;
            }
            case 18: {
                pSDEDRDetailBase.resetOrderValue();
                return true;
            }
            case 19: {
                pSDEDRDetailBase.resetPSDEDRDetailId();
                return true;
            }
            case 20: {
                pSDEDRDetailBase.resetPSDEDRDetailName();
                return true;
            }
            case 21: {
                pSDEDRDetailBase.resetPSDEDRGroupId();
                return true;
            }
            case 22: {
                pSDEDRDetailBase.resetPSDEDRGroupName();
                return true;
            }
            case 23: {
                pSDEDRDetailBase.resetPSDEDRId();
                return true;
            }
            case 24: {
                pSDEDRDetailBase.resetPSDEDRItemId();
                return true;
            }
            case 25: {
                pSDEDRDetailBase.resetPSDEDRItemName();
                return true;
            }
            case 26: {
                pSDEDRDetailBase.resetPSDEDRName();
                return true;
            }
            case 27: {
                pSDEDRDetailBase.resetPSDEId();
                return true;
            }
            case 28: {
                pSDEDRDetailBase.resetPSDEOPPrivId();
                return true;
            }
            case 29: {
                pSDEDRDetailBase.resetPSDEOPPrivName();
                return true;
            }
            case 30: {
                pSDEDRDetailBase.resetPSDETreeViewId();
                return true;
            }
            case 31: {
                pSDEDRDetailBase.resetPSDETreeViewName();
                return true;
            }
            case 32: {
                pSDEDRDetailBase.resetPSDynaInstId();
                return true;
            }
            case 33: {
                pSDEDRDetailBase.resetPSSysCssId();
                return true;
            }
            case 34: {
                pSDEDRDetailBase.resetPSSysCssName();
                return true;
            }
            case 35: {
                pSDEDRDetailBase.resetPSSysImageId();
                return true;
            }
            case 36: {
                pSDEDRDetailBase.resetPSSysImageName();
                return true;
            }
            case 37: {
                pSDEDRDetailBase.resetPSSysPDTViewId();
                return true;
            }
            case 38: {
                pSDEDRDetailBase.resetPSSysPDTViewName();
                return true;
            }
            case 39: {
                pSDEDRDetailBase.resetPSSysUniResId();
                return true;
            }
            case 40: {
                pSDEDRDetailBase.resetPSSysUniResName();
                return true;
            }
            case 41: {
                pSDEDRDetailBase.resetTestCustomCode();
                return true;
            }
            case 42: {
                pSDEDRDetailBase.resetTestCustomMode();
                return true;
            }
            case 43: {
                pSDEDRDetailBase.resetTestPSDEActionId();
                return true;
            }
            case 44: {
                pSDEDRDetailBase.resetTestPSDEActionName();
                return true;
            }
            case 45: {
                pSDEDRDetailBase.resetTestPSDELogicId();
                return true;
            }
            case 46: {
                pSDEDRDetailBase.resetTestPSDELogicName();
                return true;
            }
            case 47: {
                pSDEDRDetailBase.resetTipPSLanResId();
                return true;
            }
            case 48: {
                pSDEDRDetailBase.resetTipPSLanResName();
                return true;
            }
            case 49: {
                pSDEDRDetailBase.resetTooltipInfo();
                return true;
            }
            case 50: {
                pSDEDRDetailBase.resetUpdateDate();
                return true;
            }
            case 51: {
                pSDEDRDetailBase.resetUpdateMan();
                return true;
            }
            case 52: {
                pSDEDRDetailBase.resetUserCat();
                return true;
            }
            case 53: {
                pSDEDRDetailBase.resetUserTag();
                return true;
            }
            case 54: {
                pSDEDRDetailBase.resetUserTag2();
                return true;
            }
            case 55: {
                pSDEDRDetailBase.resetUserTag3();
                return true;
            }
            case 56: {
                pSDEDRDetailBase.resetUserTag4();
                return true;
            }
            case 57: {
                pSDEDRDetailBase.resetValidFlag();
                return true;
            }
            case 58: {
                pSDEDRDetailBase.resetViewParams();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.testpsdeaction = pSDEAction;
            }
            return this.testpsdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataRelation getPSDEDR() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDR();
        }
        if (this.getPSDEDRId() == null) {
            return null;
        }
        Integer n = this.objPSDEDRLock;
        synchronized (n) {
            if (this.psdedr != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDRId(), (Object)this.psdedr.getPSDEDataRelationId()) != 0L) {
                this.psdedr = null;
            }
            if (this.psdedr == null) {
                PSDEDataRelation pSDEDataRelation = new PSDEDataRelation();
                pSDEDataRelation.setPSDEDataRelationId(this.getPSDEDRId());
                PSDEDataRelationService pSDEDataRelationService = (PSDEDataRelationService)ServiceGlobal.getService(PSDEDataRelationService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataRelationService.autoGet((IEntity)pSDEDataRelation);
                this.psdedr = pSDEDataRelation;
            }
            return this.psdedr;
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
                pSDEDRGroupService.autoGet((IEntity)pSDEDRGroup);
                this.psdedrgroup = pSDEDRGroup;
            }
            return this.psdedrgroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDRItem getPSDEDRItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDRItem();
        }
        if (this.getPSDEDRItemId() == null) {
            return null;
        }
        Integer n = this.objPSDEDRItemLock;
        synchronized (n) {
            if (this.psdedritem != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDRItemId(), (Object)this.psdedritem.getPSDEDRItemId()) != 0L) {
                this.psdedritem = null;
            }
            if (this.psdedritem == null) {
                PSDEDRItem pSDEDRItem = new PSDEDRItem();
                pSDEDRItem.setPSDEDRItemId(this.getPSDEDRItemId());
                PSDEDRItemService pSDEDRItemService = (PSDEDRItemService)ServiceGlobal.getService(PSDEDRItemService.class, (SessionFactory)this.getSessionFactory());
                pSDEDRItemService.autoGet((IEntity)pSDEDRItem);
                this.psdedritem = pSDEDRItem;
            }
            return this.psdedritem;
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
                pSDELogicService.autoGet((IEntity)pSDELogic);
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
                pSDEOPPrivService.autoGet((IEntity)pSDEOPPriv);
                this.psdeoppriv = pSDEOPPriv;
            }
            return this.psdeoppriv;
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
    public PSSysPDTView getPSSysPDTView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPDTView();
        }
        if (this.getPSSysPDTViewId() == null) {
            return null;
        }
        Integer n = this.objPSSysPDTViewLock;
        synchronized (n) {
            if (this.pssyspdtview != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysPDTViewId(), (Object)this.pssyspdtview.getPSSysPDTViewId()) != 0L) {
                this.pssyspdtview = null;
            }
            if (this.pssyspdtview == null) {
                PSSysPDTView pSSysPDTView = new PSSysPDTView();
                pSSysPDTView.setPSSysPDTViewId(this.getPSSysPDTViewId());
                PSSysPDTViewService pSSysPDTViewService = (PSSysPDTViewService)ServiceGlobal.getService(PSSysPDTViewService.class, (SessionFactory)this.getSessionFactory());
                pSSysPDTViewService.autoGet((IEntity)pSSysPDTView);
                this.pssyspdtview = pSSysPDTView;
            }
            return this.pssyspdtview;
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
                pSSysPFPluginService.autoGet((IEntity)pSSysPFPlugin);
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
                pSSysUniResService.autoGet((IEntity)pSSysUniRes);
                this.pssysunires = pSSysUniRes;
            }
            return this.pssysunires;
        }
    }

    private PSDEDRDetailBase getProxyEntity() {
        return this.proxyPSDEDRDetailBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEDRDetailBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEDRDetailBase) {
            this.proxyPSDEDRDetailBase = (PSDEDRDetailBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDRDetailService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CAPPSLANRESID, 0);
        fieldIndexMap.put(FIELD_CAPPSLANRESNAME, 1);
        fieldIndexMap.put(FIELD_CAPTION, 2);
        fieldIndexMap.put(FIELD_COUNTERID, 3);
        fieldIndexMap.put(FIELD_COUNTERMODE, 4);
        fieldIndexMap.put(FIELD_CREATEDATE, 5);
        fieldIndexMap.put(FIELD_CREATEMAN, 6);
        fieldIndexMap.put(FIELD_DATA, 7);
        fieldIndexMap.put(FIELD_DETAILTAG, 8);
        fieldIndexMap.put(FIELD_DETAILTAG2, 9);
        fieldIndexMap.put(FIELD_DETAILTYPE, 10);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 11);
        fieldIndexMap.put(FIELD_ENABLEMODE, 12);
        fieldIndexMap.put(FIELD_GROUPORDERVALUE, 13);
        fieldIndexMap.put(FIELD_HEADERPSSYSPFPLUGINID, 14);
        fieldIndexMap.put(FIELD_HEADERPSSYSPFPLUGINNAME, 15);
        fieldIndexMap.put(FIELD_MEMO, 16);
        fieldIndexMap.put(FIELD_NAVVIEWFILTER, 17);
        fieldIndexMap.put(FIELD_ORDERVALUE, 18);
        fieldIndexMap.put(FIELD_PSDEDRDETAILID, 19);
        fieldIndexMap.put(FIELD_PSDEDRDETAILNAME, 20);
        fieldIndexMap.put(FIELD_PSDEDRGROUPID, 21);
        fieldIndexMap.put(FIELD_PSDEDRGROUPNAME, 22);
        fieldIndexMap.put(FIELD_PSDEDRID, 23);
        fieldIndexMap.put(FIELD_PSDEDRITEMID, 24);
        fieldIndexMap.put(FIELD_PSDEDRITEMNAME, 25);
        fieldIndexMap.put(FIELD_PSDEDRNAME, 26);
        fieldIndexMap.put(FIELD_PSDEID, 27);
        fieldIndexMap.put(FIELD_PSDEOPPRIVID, 28);
        fieldIndexMap.put(FIELD_PSDEOPPRIVNAME, 29);
        fieldIndexMap.put(FIELD_PSDETREEVIEWID, 30);
        fieldIndexMap.put(FIELD_PSDETREEVIEWNAME, 31);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 32);
        fieldIndexMap.put(FIELD_PSSYSCSSID, 33);
        fieldIndexMap.put(FIELD_PSSYSCSSNAME, 34);
        fieldIndexMap.put(FIELD_PSSYSIMAGEID, 35);
        fieldIndexMap.put(FIELD_PSSYSIMAGENAME, 36);
        fieldIndexMap.put(FIELD_PSSYSPDTVIEWID, 37);
        fieldIndexMap.put(FIELD_PSSYSPDTVIEWNAME, 38);
        fieldIndexMap.put(FIELD_PSSYSUNIRESID, 39);
        fieldIndexMap.put(FIELD_PSSYSUNIRESNAME, 40);
        fieldIndexMap.put(FIELD_TESTCUSTOMCODE, 41);
        fieldIndexMap.put(FIELD_TESTCUSTOMMODE, 42);
        fieldIndexMap.put(FIELD_TESTPSDEACTIONID, 43);
        fieldIndexMap.put(FIELD_TESTPSDEACTIONNAME, 44);
        fieldIndexMap.put(FIELD_TESTPSDELOGICID, 45);
        fieldIndexMap.put(FIELD_TESTPSDELOGICNAME, 46);
        fieldIndexMap.put(FIELD_TIPPSLANRESID, 47);
        fieldIndexMap.put(FIELD_TIPPSLANRESNAME, 48);
        fieldIndexMap.put(FIELD_TOOLTIPINFO, 49);
        fieldIndexMap.put(FIELD_UPDATEDATE, 50);
        fieldIndexMap.put(FIELD_UPDATEMAN, 51);
        fieldIndexMap.put(FIELD_USERCAT, 52);
        fieldIndexMap.put(FIELD_USERTAG, 53);
        fieldIndexMap.put(FIELD_USERTAG2, 54);
        fieldIndexMap.put(FIELD_USERTAG3, 55);
        fieldIndexMap.put(FIELD_USERTAG4, 56);
        fieldIndexMap.put(FIELD_VALIDFLAG, 57);
        fieldIndexMap.put(FIELD_VIEWPARAMS, 58);
    }
}

