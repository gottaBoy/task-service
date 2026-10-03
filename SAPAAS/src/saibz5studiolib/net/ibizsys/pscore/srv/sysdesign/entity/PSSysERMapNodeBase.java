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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLocalDE;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLocalDEService;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDScheme;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTable;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDSchemeService;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEServiceAPI;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEServiceAPIService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchDoc;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchScheme;
import net.ibizsys.pscore.srv.search.service.PSSysSearchDocService;
import net.ibizsys.pscore.srv.search.service.PSSysSearchSchemeService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADE;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBScheme;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBTable;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysERMap;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADEService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBSchemeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBTableService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysERMapService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysERMapNodeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysERMapNodeBase.class);
    public static final String FIELD_COLOR = "COLOR";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DETAILMODE = "DETAILMODE";
    public static final String FIELD_LEFTPOS = "LEFTPOS";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODCOLOR = "MODCOLOR";
    public static final String FIELD_NODETAG = "NODETAG";
    public static final String FIELD_NODETAG2 = "NODETAG2";
    public static final String FIELD_NODETYPE = "NODETYPE";
    public static final String FIELD_PSAPPLOCALDEID = "PSAPPLOCALDEID";
    public static final String FIELD_PSAPPLOCALDENAME = "PSAPPLOCALDENAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDESERVICEAPIID = "PSDESERVICEAPIID";
    public static final String FIELD_PSDESERVICEAPINAME = "PSDESERVICEAPINAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSUBSYSSADEID = "PSSUBSYSSADEID";
    public static final String FIELD_PSSUBSYSSADENAME = "PSSUBSYSSADENAME";
    public static final String FIELD_PSSUBSYSSERVICEAPIID = "PSSUBSYSSERVICEAPIID";
    public static final String FIELD_PSSUBSYSSERVICEAPINAME = "PSSUBSYSSERVICEAPINAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_PSSYSBDSCHEMEID = "PSSYSBDSCHEMEID";
    public static final String FIELD_PSSYSBDSCHEMENAME = "PSSYSBDSCHEMENAME";
    public static final String FIELD_PSSYSBDTABLEID = "PSSYSBDTABLEID";
    public static final String FIELD_PSSYSBDTABLENAME = "PSSYSBDTABLENAME";
    public static final String FIELD_PSSYSDBSCHEMEID = "PSSYSDBSCHEMEID";
    public static final String FIELD_PSSYSDBSCHEMENAME = "PSSYSDBSCHEMENAME";
    public static final String FIELD_PSSYSDBTABLEID = "PSSYSDBTABLEID";
    public static final String FIELD_PSSYSDBTABLENAME = "PSSYSDBTABLENAME";
    public static final String FIELD_PSSYSERMAPID = "PSSYSERMAPID";
    public static final String FIELD_PSSYSERMAPNAME = "PSSYSERMAPNAME";
    public static final String FIELD_PSSYSERMAPNODEID = "PSSYSERMAPNODEID";
    public static final String FIELD_PSSYSERMAPNODENAME = "PSSYSERMAPNODENAME";
    public static final String FIELD_PSSYSSEARCHDOCID = "PSSYSSEARCHDOCID";
    public static final String FIELD_PSSYSSEARCHDOCNAME = "PSSYSSEARCHDOCNAME";
    public static final String FIELD_PSSYSSEARCHSCHEMEID = "PSSYSSEARCHSCHEMEID";
    public static final String FIELD_PSSYSSEARCHSCHEMENAME = "PSSYSSEARCHSCHEMENAME";
    public static final String FIELD_PSSYSSERVICEAPIID = "PSSYSSERVICEAPIID";
    public static final String FIELD_PSSYSSERVICEAPINAME = "PSSYSSERVICEAPINAME";
    public static final String FIELD_REFPSSYSDYNAMODELID = "REFPSSYSDYNAMODELID";
    public static final String FIELD_REFPSSYSDYNAMODELNAME = "REFPSSYSDYNAMODELNAME";
    public static final String FIELD_SHAPEPARAMS = "SHAPEPARAMS";
    public static final String FIELD_SHOWDEFIELDS = "SHOWDEFIELDS";
    public static final String FIELD_TOPPOS = "TOPPOS";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_COLOR = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DETAILMODE = 3;
    private static final int INDEX_LEFTPOS = 4;
    private static final int INDEX_LOGICNAME = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_MODCOLOR = 7;
    private static final int INDEX_NODETAG = 8;
    private static final int INDEX_NODETAG2 = 9;
    private static final int INDEX_NODETYPE = 10;
    private static final int INDEX_PSAPPLOCALDEID = 11;
    private static final int INDEX_PSAPPLOCALDENAME = 12;
    private static final int INDEX_PSDEID = 13;
    private static final int INDEX_PSDENAME = 14;
    private static final int INDEX_PSDESERVICEAPIID = 15;
    private static final int INDEX_PSDESERVICEAPINAME = 16;
    private static final int INDEX_PSMODULEID = 17;
    private static final int INDEX_PSMODULENAME = 18;
    private static final int INDEX_PSSUBSYSSADEID = 19;
    private static final int INDEX_PSSUBSYSSADENAME = 20;
    private static final int INDEX_PSSUBSYSSERVICEAPIID = 21;
    private static final int INDEX_PSSUBSYSSERVICEAPINAME = 22;
    private static final int INDEX_PSSYSAPPID = 23;
    private static final int INDEX_PSSYSAPPNAME = 24;
    private static final int INDEX_PSSYSBDSCHEMEID = 25;
    private static final int INDEX_PSSYSBDSCHEMENAME = 26;
    private static final int INDEX_PSSYSBDTABLEID = 27;
    private static final int INDEX_PSSYSBDTABLENAME = 28;
    private static final int INDEX_PSSYSDBSCHEMEID = 29;
    private static final int INDEX_PSSYSDBSCHEMENAME = 30;
    private static final int INDEX_PSSYSDBTABLEID = 31;
    private static final int INDEX_PSSYSDBTABLENAME = 32;
    private static final int INDEX_PSSYSERMAPID = 33;
    private static final int INDEX_PSSYSERMAPNAME = 34;
    private static final int INDEX_PSSYSERMAPNODEID = 35;
    private static final int INDEX_PSSYSERMAPNODENAME = 36;
    private static final int INDEX_PSSYSSEARCHDOCID = 37;
    private static final int INDEX_PSSYSSEARCHDOCNAME = 38;
    private static final int INDEX_PSSYSSEARCHSCHEMEID = 39;
    private static final int INDEX_PSSYSSEARCHSCHEMENAME = 40;
    private static final int INDEX_PSSYSSERVICEAPIID = 41;
    private static final int INDEX_PSSYSSERVICEAPINAME = 42;
    private static final int INDEX_REFPSSYSDYNAMODELID = 43;
    private static final int INDEX_REFPSSYSDYNAMODELNAME = 44;
    private static final int INDEX_SHAPEPARAMS = 45;
    private static final int INDEX_SHOWDEFIELDS = 46;
    private static final int INDEX_TOPPOS = 47;
    private static final int INDEX_UPDATEDATE = 48;
    private static final int INDEX_UPDATEMAN = 49;
    private static final int INDEX_USERCAT = 50;
    private static final int INDEX_USERTAG = 51;
    private static final int INDEX_USERTAG2 = 52;
    private static final int INDEX_USERTAG3 = 53;
    private static final int INDEX_USERTAG4 = 54;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysERMapNodeBase proxyPSSysERMapNodeBase = null;
    private boolean colorDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean detailmodeDirtyFlag = false;
    private boolean leftposDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modcolorDirtyFlag = false;
    private boolean nodetagDirtyFlag = false;
    private boolean nodetag2DirtyFlag = false;
    private boolean nodetypeDirtyFlag = false;
    private boolean psapplocaldeidDirtyFlag = false;
    private boolean psapplocaldenameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdeserviceapiidDirtyFlag = false;
    private boolean psdeserviceapinameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssubsyssadeidDirtyFlag = false;
    private boolean pssubsyssadenameDirtyFlag = false;
    private boolean pssubsysserviceapiidDirtyFlag = false;
    private boolean pssubsysserviceapinameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean pssysbdschemeidDirtyFlag = false;
    private boolean pssysbdschemenameDirtyFlag = false;
    private boolean pssysbdtableidDirtyFlag = false;
    private boolean pssysbdtablenameDirtyFlag = false;
    private boolean pssysdbschemeidDirtyFlag = false;
    private boolean pssysdbschemenameDirtyFlag = false;
    private boolean pssysdbtableidDirtyFlag = false;
    private boolean pssysdbtablenameDirtyFlag = false;
    private boolean pssysermapidDirtyFlag = false;
    private boolean pssysermapnameDirtyFlag = false;
    private boolean pssysermapnodeidDirtyFlag = false;
    private boolean pssysermapnodenameDirtyFlag = false;
    private boolean pssyssearchdocidDirtyFlag = false;
    private boolean pssyssearchdocnameDirtyFlag = false;
    private boolean pssyssearchschemeidDirtyFlag = false;
    private boolean pssyssearchschemenameDirtyFlag = false;
    private boolean pssysserviceapiidDirtyFlag = false;
    private boolean pssysserviceapinameDirtyFlag = false;
    private boolean refpssysdynamodelidDirtyFlag = false;
    private boolean refpssysdynamodelnameDirtyFlag = false;
    private boolean shapeparamsDirtyFlag = false;
    private boolean showdefieldsDirtyFlag = false;
    private boolean topposDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="color")
    private String color;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="detailmode")
    private Integer detailmode;
    @Column(name="leftpos")
    private Integer leftpos;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="modcolor")
    private String modcolor;
    @Column(name="nodetag")
    private String nodetag;
    @Column(name="nodetag2")
    private String nodetag2;
    @Column(name="nodetype")
    private String nodetype;
    @Column(name="psapplocaldeid")
    private String psapplocaldeid;
    @Column(name="psapplocaldename")
    private String psapplocaldename;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdeserviceapiid")
    private String psdeserviceapiid;
    @Column(name="psdeserviceapiname")
    private String psdeserviceapiname;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssubsyssadeid")
    private String pssubsyssadeid;
    @Column(name="pssubsyssadename")
    private String pssubsyssadename;
    @Column(name="pssubsysserviceapiid")
    private String pssubsysserviceapiid;
    @Column(name="pssubsysserviceapiname")
    private String pssubsysserviceapiname;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="pssysbdschemeid")
    private String pssysbdschemeid;
    @Column(name="pssysbdschemename")
    private String pssysbdschemename;
    @Column(name="pssysbdtableid")
    private String pssysbdtableid;
    @Column(name="pssysbdtablename")
    private String pssysbdtablename;
    @Column(name="pssysdbschemeid")
    private String pssysdbschemeid;
    @Column(name="pssysdbschemename")
    private String pssysdbschemename;
    @Column(name="pssysdbtableid")
    private String pssysdbtableid;
    @Column(name="pssysdbtablename")
    private String pssysdbtablename;
    @Column(name="pssysermapid")
    private String pssysermapid;
    @Column(name="pssysermapname")
    private String pssysermapname;
    @Column(name="pssysermapnodeid")
    private String pssysermapnodeid;
    @Column(name="pssysermapnodename")
    private String pssysermapnodename;
    @Column(name="pssyssearchdocid")
    private String pssyssearchdocid;
    @Column(name="pssyssearchdocname")
    private String pssyssearchdocname;
    @Column(name="pssyssearchschemeid")
    private String pssyssearchschemeid;
    @Column(name="pssyssearchschemename")
    private String pssyssearchschemename;
    @Column(name="pssysserviceapiid")
    private String pssysserviceapiid;
    @Column(name="pssysserviceapiname")
    private String pssysserviceapiname;
    @Column(name="refpssysdynamodelid")
    private String refpssysdynamodelid;
    @Column(name="refpssysdynamodelname")
    private String refpssysdynamodelname;
    @Column(name="shapeparams")
    private String shapeparams;
    @Column(name="showdefields")
    private String showdefields;
    @Column(name="toppos")
    private Integer toppos;
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
    private Integer objPSAppLocalDELock = new Integer(1);
    private PSAppLocalDE psapplocalde = null;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEServiceAPILock = new Integer(1);
    private PSDEServiceAPI psdeserviceapi = null;
    private Integer objPSSubSysSADELock = new Integer(1);
    private PSSubSysSADE pssubsyssade = null;
    private Integer objPSSubSysServiceAPILock = new Integer(1);
    private PSSubSysServiceAPI pssubsysserviceapi = null;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objPSSysBDSchemeLock = new Integer(1);
    private PSSysBDScheme pssysbdscheme = null;
    private Integer objPSSysBDTableLock = new Integer(1);
    private PSSysBDTable pssysbdtable = null;
    private Integer objPSSysDBSchemeLock = new Integer(1);
    private PSSysDBScheme pssysdbscheme = null;
    private Integer objPSSysDBTableLock = new Integer(1);
    private PSSysDBTable pssysdbtable = null;
    private Integer objRefPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel refpssysdynamodel = null;
    private Integer objPSSysERMapLock = new Integer(1);
    private PSSysERMap pssysermap = null;
    private Integer objPSSysSearchDocLock = new Integer(1);
    private PSSysSearchDoc pssyssearchdoc = null;
    private Integer objPSSysSearchSchemeLock = new Integer(1);
    private PSSysSearchScheme pssyssearchscheme = null;
    private Integer objPSSysSerrviceAPILock = new Integer(1);
    private PSSysServiceAPI pssysserrviceapi = null;

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

    public void setDetailMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDetailMode(n);
            return;
        }
        this.detailmode = n;
        this.detailmodeDirtyFlag = true;
    }

    public Integer getDetailMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDetailMode();
        }
        return this.detailmode;
    }

    public boolean isDetailModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDetailModeDirty();
        }
        return this.detailmodeDirtyFlag;
    }

    public void resetDetailMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDetailMode();
            return;
        }
        this.detailmodeDirtyFlag = false;
        this.detailmode = null;
    }

    public void setLeftPos(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLeftPos(n);
            return;
        }
        this.leftpos = n;
        this.leftposDirtyFlag = true;
    }

    public Integer getLeftPos() {
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

    public void setModColor(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModColor(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modcolor = string;
        this.modcolorDirtyFlag = true;
    }

    public String getModColor() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModColor();
        }
        return this.modcolor;
    }

    public boolean isModColorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModColorDirty();
        }
        return this.modcolorDirtyFlag;
    }

    public void resetModColor() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModColor();
            return;
        }
        this.modcolorDirtyFlag = false;
        this.modcolor = null;
    }

    public void setNodeTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNodeTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.nodetag = string;
        this.nodetagDirtyFlag = true;
    }

    public String getNodeTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNodeTag();
        }
        return this.nodetag;
    }

    public boolean isNodeTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNodeTagDirty();
        }
        return this.nodetagDirtyFlag;
    }

    public void resetNodeTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNodeTag();
            return;
        }
        this.nodetagDirtyFlag = false;
        this.nodetag = null;
    }

    public void setNodeTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNodeTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.nodetag2 = string;
        this.nodetag2DirtyFlag = true;
    }

    public String getNodeTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNodeTag2();
        }
        return this.nodetag2;
    }

    public boolean isNodeTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNodeTag2Dirty();
        }
        return this.nodetag2DirtyFlag;
    }

    public void resetNodeTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNodeTag2();
            return;
        }
        this.nodetag2DirtyFlag = false;
        this.nodetag2 = null;
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

    public void setPSAppLocalDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppLocalDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapplocaldeid = string;
        this.psapplocaldeidDirtyFlag = true;
    }

    public String getPSAppLocalDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppLocalDEId();
        }
        return this.psapplocaldeid;
    }

    public boolean isPSAppLocalDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppLocalDEIdDirty();
        }
        return this.psapplocaldeidDirtyFlag;
    }

    public void resetPSAppLocalDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppLocalDEId();
            return;
        }
        this.psapplocaldeidDirtyFlag = false;
        this.psapplocaldeid = null;
    }

    public void setPSAppLocalDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppLocalDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapplocaldename = string;
        this.psapplocaldenameDirtyFlag = true;
    }

    public String getPSAppLocalDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppLocalDEName();
        }
        return this.psapplocaldename;
    }

    public boolean isPSAppLocalDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppLocalDENameDirty();
        }
        return this.psapplocaldenameDirtyFlag;
    }

    public void resetPSAppLocalDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppLocalDEName();
            return;
        }
        this.psapplocaldenameDirtyFlag = false;
        this.psapplocaldename = null;
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

    public void setPSDEServiceAPIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEServiceAPIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeserviceapiid = string;
        this.psdeserviceapiidDirtyFlag = true;
    }

    public String getPSDEServiceAPIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEServiceAPIId();
        }
        return this.psdeserviceapiid;
    }

    public boolean isPSDEServiceAPIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEServiceAPIIdDirty();
        }
        return this.psdeserviceapiidDirtyFlag;
    }

    public void resetPSDEServiceAPIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEServiceAPIId();
            return;
        }
        this.psdeserviceapiidDirtyFlag = false;
        this.psdeserviceapiid = null;
    }

    public void setPSDEServiceAPIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEServiceAPIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeserviceapiname = string;
        this.psdeserviceapinameDirtyFlag = true;
    }

    public String getPSDEServiceAPIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEServiceAPIName();
        }
        return this.psdeserviceapiname;
    }

    public boolean isPSDEServiceAPINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEServiceAPINameDirty();
        }
        return this.psdeserviceapinameDirtyFlag;
    }

    public void resetPSDEServiceAPIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEServiceAPIName();
            return;
        }
        this.psdeserviceapinameDirtyFlag = false;
        this.psdeserviceapiname = null;
    }

    public void setPSModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmoduleid = string;
        this.psmoduleidDirtyFlag = true;
    }

    public String getPSModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleId();
        }
        return this.psmoduleid;
    }

    public boolean isPSModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleIdDirty();
        }
        return this.psmoduleidDirtyFlag;
    }

    public void resetPSModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleId();
            return;
        }
        this.psmoduleidDirtyFlag = false;
        this.psmoduleid = null;
    }

    public void setPSModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodulename = string;
        this.psmodulenameDirtyFlag = true;
    }

    public String getPSModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleName();
        }
        return this.psmodulename;
    }

    public boolean isPSModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleNameDirty();
        }
        return this.psmodulenameDirtyFlag;
    }

    public void resetPSModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleName();
            return;
        }
        this.psmodulenameDirtyFlag = false;
        this.psmodulename = null;
    }

    public void setPSSubSysSADEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysSADEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsyssadeid = string;
        this.pssubsyssadeidDirtyFlag = true;
    }

    public String getPSSubSysSADEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysSADEId();
        }
        return this.pssubsyssadeid;
    }

    public boolean isPSSubSysSADEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysSADEIdDirty();
        }
        return this.pssubsyssadeidDirtyFlag;
    }

    public void resetPSSubSysSADEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysSADEId();
            return;
        }
        this.pssubsyssadeidDirtyFlag = false;
        this.pssubsyssadeid = null;
    }

    public void setPSSubSysSADEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysSADEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsyssadename = string;
        this.pssubsyssadenameDirtyFlag = true;
    }

    public String getPSSubSysSADEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysSADEName();
        }
        return this.pssubsyssadename;
    }

    public boolean isPSSubSysSADENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysSADENameDirty();
        }
        return this.pssubsyssadenameDirtyFlag;
    }

    public void resetPSSubSysSADEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysSADEName();
            return;
        }
        this.pssubsyssadenameDirtyFlag = false;
        this.pssubsyssadename = null;
    }

    public void setPSSubSysServiceAPIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysServiceAPIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsysserviceapiid = string;
        this.pssubsysserviceapiidDirtyFlag = true;
    }

    public String getPSSubSysServiceAPIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysServiceAPIId();
        }
        return this.pssubsysserviceapiid;
    }

    public boolean isPSSubSysServiceAPIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysServiceAPIIdDirty();
        }
        return this.pssubsysserviceapiidDirtyFlag;
    }

    public void resetPSSubSysServiceAPIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysServiceAPIId();
            return;
        }
        this.pssubsysserviceapiidDirtyFlag = false;
        this.pssubsysserviceapiid = null;
    }

    public void setPSSubSysServiceAPIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysServiceAPIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsysserviceapiname = string;
        this.pssubsysserviceapinameDirtyFlag = true;
    }

    public String getPSSubSysServiceAPIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysServiceAPIName();
        }
        return this.pssubsysserviceapiname;
    }

    public boolean isPSSubSysServiceAPINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysServiceAPINameDirty();
        }
        return this.pssubsysserviceapinameDirtyFlag;
    }

    public void resetPSSubSysServiceAPIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysServiceAPIName();
            return;
        }
        this.pssubsysserviceapinameDirtyFlag = false;
        this.pssubsysserviceapiname = null;
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

    public void setPSSysBDSchemeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDSchemeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbdschemeid = string;
        this.pssysbdschemeidDirtyFlag = true;
    }

    public String getPSSysBDSchemeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDSchemeId();
        }
        return this.pssysbdschemeid;
    }

    public boolean isPSSysBDSchemeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDSchemeIdDirty();
        }
        return this.pssysbdschemeidDirtyFlag;
    }

    public void resetPSSysBDSchemeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDSchemeId();
            return;
        }
        this.pssysbdschemeidDirtyFlag = false;
        this.pssysbdschemeid = null;
    }

    public void setPSSysBDSchemeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDSchemeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbdschemename = string;
        this.pssysbdschemenameDirtyFlag = true;
    }

    public String getPSSysBDSchemeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDSchemeName();
        }
        return this.pssysbdschemename;
    }

    public boolean isPSSysBDSchemeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDSchemeNameDirty();
        }
        return this.pssysbdschemenameDirtyFlag;
    }

    public void resetPSSysBDSchemeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDSchemeName();
            return;
        }
        this.pssysbdschemenameDirtyFlag = false;
        this.pssysbdschemename = null;
    }

    public void setPSSysBDTableId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDTableId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbdtableid = string;
        this.pssysbdtableidDirtyFlag = true;
    }

    public String getPSSysBDTableId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDTableId();
        }
        return this.pssysbdtableid;
    }

    public boolean isPSSysBDTableIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDTableIdDirty();
        }
        return this.pssysbdtableidDirtyFlag;
    }

    public void resetPSSysBDTableId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDTableId();
            return;
        }
        this.pssysbdtableidDirtyFlag = false;
        this.pssysbdtableid = null;
    }

    public void setPSSysBDTableName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDTableName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbdtablename = string;
        this.pssysbdtablenameDirtyFlag = true;
    }

    public String getPSSysBDTableName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDTableName();
        }
        return this.pssysbdtablename;
    }

    public boolean isPSSysBDTableNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDTableNameDirty();
        }
        return this.pssysbdtablenameDirtyFlag;
    }

    public void resetPSSysBDTableName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDTableName();
            return;
        }
        this.pssysbdtablenameDirtyFlag = false;
        this.pssysbdtablename = null;
    }

    public void setPSSysDBSchemeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBSchemeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbschemeid = string;
        this.pssysdbschemeidDirtyFlag = true;
    }

    public String getPSSysDBSchemeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBSchemeId();
        }
        return this.pssysdbschemeid;
    }

    public boolean isPSSysDBSchemeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBSchemeIdDirty();
        }
        return this.pssysdbschemeidDirtyFlag;
    }

    public void resetPSSysDBSchemeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBSchemeId();
            return;
        }
        this.pssysdbschemeidDirtyFlag = false;
        this.pssysdbschemeid = null;
    }

    public void setPSSysDBSchemeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBSchemeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbschemename = string;
        this.pssysdbschemenameDirtyFlag = true;
    }

    public String getPSSysDBSchemeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBSchemeName();
        }
        return this.pssysdbschemename;
    }

    public boolean isPSSysDBSchemeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBSchemeNameDirty();
        }
        return this.pssysdbschemenameDirtyFlag;
    }

    public void resetPSSysDBSchemeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBSchemeName();
            return;
        }
        this.pssysdbschemenameDirtyFlag = false;
        this.pssysdbschemename = null;
    }

    public void setPSSysDBTableId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBTableId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbtableid = string;
        this.pssysdbtableidDirtyFlag = true;
    }

    public String getPSSysDBTableId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBTableId();
        }
        return this.pssysdbtableid;
    }

    public boolean isPSSysDBTableIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBTableIdDirty();
        }
        return this.pssysdbtableidDirtyFlag;
    }

    public void resetPSSysDBTableId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBTableId();
            return;
        }
        this.pssysdbtableidDirtyFlag = false;
        this.pssysdbtableid = null;
    }

    public void setPSSysDBTableName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBTableName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbtablename = string;
        this.pssysdbtablenameDirtyFlag = true;
    }

    public String getPSSysDBTableName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBTableName();
        }
        return this.pssysdbtablename;
    }

    public boolean isPSSysDBTableNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBTableNameDirty();
        }
        return this.pssysdbtablenameDirtyFlag;
    }

    public void resetPSSysDBTableName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBTableName();
            return;
        }
        this.pssysdbtablenameDirtyFlag = false;
        this.pssysdbtablename = null;
    }

    public void setPSSysERMapId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysERMapId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysermapid = string;
        this.pssysermapidDirtyFlag = true;
    }

    public String getPSSysERMapId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysERMapId();
        }
        return this.pssysermapid;
    }

    public boolean isPSSysERMapIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysERMapIdDirty();
        }
        return this.pssysermapidDirtyFlag;
    }

    public void resetPSSysERMapId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysERMapId();
            return;
        }
        this.pssysermapidDirtyFlag = false;
        this.pssysermapid = null;
    }

    public void setPSSysERMapName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysERMapName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysermapname = string;
        this.pssysermapnameDirtyFlag = true;
    }

    public String getPSSysERMapName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysERMapName();
        }
        return this.pssysermapname;
    }

    public boolean isPSSysERMapNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysERMapNameDirty();
        }
        return this.pssysermapnameDirtyFlag;
    }

    public void resetPSSysERMapName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysERMapName();
            return;
        }
        this.pssysermapnameDirtyFlag = false;
        this.pssysermapname = null;
    }

    public void setPSSysERMapNodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysERMapNodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysermapnodeid = string;
        this.pssysermapnodeidDirtyFlag = true;
    }

    public String getPSSysERMapNodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysERMapNodeId();
        }
        return this.pssysermapnodeid;
    }

    public boolean isPSSysERMapNodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysERMapNodeIdDirty();
        }
        return this.pssysermapnodeidDirtyFlag;
    }

    public void resetPSSysERMapNodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysERMapNodeId();
            return;
        }
        this.pssysermapnodeidDirtyFlag = false;
        this.pssysermapnodeid = null;
    }

    public void setPSSysERMapNodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysERMapNodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysermapnodename = string;
        this.pssysermapnodenameDirtyFlag = true;
    }

    public String getPSSysERMapNodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysERMapNodeName();
        }
        return this.pssysermapnodename;
    }

    public boolean isPSSysERMapNodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysERMapNodeNameDirty();
        }
        return this.pssysermapnodenameDirtyFlag;
    }

    public void resetPSSysERMapNodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysERMapNodeName();
            return;
        }
        this.pssysermapnodenameDirtyFlag = false;
        this.pssysermapnodename = null;
    }

    public void setPSSysSearchDocId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSearchDocId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssearchdocid = string;
        this.pssyssearchdocidDirtyFlag = true;
    }

    public String getPSSysSearchDocId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchDocId();
        }
        return this.pssyssearchdocid;
    }

    public boolean isPSSysSearchDocIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSearchDocIdDirty();
        }
        return this.pssyssearchdocidDirtyFlag;
    }

    public void resetPSSysSearchDocId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSearchDocId();
            return;
        }
        this.pssyssearchdocidDirtyFlag = false;
        this.pssyssearchdocid = null;
    }

    public void setPSSysSearchDocName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSearchDocName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssearchdocname = string;
        this.pssyssearchdocnameDirtyFlag = true;
    }

    public String getPSSysSearchDocName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchDocName();
        }
        return this.pssyssearchdocname;
    }

    public boolean isPSSysSearchDocNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSearchDocNameDirty();
        }
        return this.pssyssearchdocnameDirtyFlag;
    }

    public void resetPSSysSearchDocName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSearchDocName();
            return;
        }
        this.pssyssearchdocnameDirtyFlag = false;
        this.pssyssearchdocname = null;
    }

    public void setPSSysSearchSchemeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSearchSchemeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssearchschemeid = string;
        this.pssyssearchschemeidDirtyFlag = true;
    }

    public String getPSSysSearchSchemeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchSchemeId();
        }
        return this.pssyssearchschemeid;
    }

    public boolean isPSSysSearchSchemeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSearchSchemeIdDirty();
        }
        return this.pssyssearchschemeidDirtyFlag;
    }

    public void resetPSSysSearchSchemeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSearchSchemeId();
            return;
        }
        this.pssyssearchschemeidDirtyFlag = false;
        this.pssyssearchschemeid = null;
    }

    public void setPSSysSearchSchemeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSearchSchemeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssearchschemename = string;
        this.pssyssearchschemenameDirtyFlag = true;
    }

    public String getPSSysSearchSchemeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchSchemeName();
        }
        return this.pssyssearchschemename;
    }

    public boolean isPSSysSearchSchemeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSearchSchemeNameDirty();
        }
        return this.pssyssearchschemenameDirtyFlag;
    }

    public void resetPSSysSearchSchemeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSearchSchemeName();
            return;
        }
        this.pssyssearchschemenameDirtyFlag = false;
        this.pssyssearchschemename = null;
    }

    public void setPSSysServiceAPIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysServiceAPIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysserviceapiid = string;
        this.pssysserviceapiidDirtyFlag = true;
    }

    public String getPSSysServiceAPIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysServiceAPIId();
        }
        return this.pssysserviceapiid;
    }

    public boolean isPSSysServiceAPIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysServiceAPIIdDirty();
        }
        return this.pssysserviceapiidDirtyFlag;
    }

    public void resetPSSysServiceAPIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysServiceAPIId();
            return;
        }
        this.pssysserviceapiidDirtyFlag = false;
        this.pssysserviceapiid = null;
    }

    public void setPSSysServiceAPIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysServiceAPIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysserviceapiname = string;
        this.pssysserviceapinameDirtyFlag = true;
    }

    public String getPSSysServiceAPIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysServiceAPIName();
        }
        return this.pssysserviceapiname;
    }

    public boolean isPSSysServiceAPINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysServiceAPINameDirty();
        }
        return this.pssysserviceapinameDirtyFlag;
    }

    public void resetPSSysServiceAPIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysServiceAPIName();
            return;
        }
        this.pssysserviceapinameDirtyFlag = false;
        this.pssysserviceapiname = null;
    }

    public void setRefPSSysDynaModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSSysDynaModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpssysdynamodelid = string;
        this.refpssysdynamodelidDirtyFlag = true;
    }

    public String getRefPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSSysDynaModelId();
        }
        return this.refpssysdynamodelid;
    }

    public boolean isRefPSSysDynaModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSSysDynaModelIdDirty();
        }
        return this.refpssysdynamodelidDirtyFlag;
    }

    public void resetRefPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSSysDynaModelId();
            return;
        }
        this.refpssysdynamodelidDirtyFlag = false;
        this.refpssysdynamodelid = null;
    }

    public void setRefPSSysDynaModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSSysDynaModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpssysdynamodelname = string;
        this.refpssysdynamodelnameDirtyFlag = true;
    }

    public String getRefPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSSysDynaModelName();
        }
        return this.refpssysdynamodelname;
    }

    public boolean isRefPSSysDynaModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSSysDynaModelNameDirty();
        }
        return this.refpssysdynamodelnameDirtyFlag;
    }

    public void resetRefPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSSysDynaModelName();
            return;
        }
        this.refpssysdynamodelnameDirtyFlag = false;
        this.refpssysdynamodelname = null;
    }

    public void setShapeParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setShapeParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.shapeparams = string;
        this.shapeparamsDirtyFlag = true;
    }

    public String getShapeParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getShapeParams();
        }
        return this.shapeparams;
    }

    public boolean isShapeParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isShapeParamsDirty();
        }
        return this.shapeparamsDirtyFlag;
    }

    public void resetShapeParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetShapeParams();
            return;
        }
        this.shapeparamsDirtyFlag = false;
        this.shapeparams = null;
    }

    public void setShowDEFields(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setShowDEFields(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.showdefields = string;
        this.showdefieldsDirtyFlag = true;
    }

    public String getShowDEFields() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getShowDEFields();
        }
        return this.showdefields;
    }

    public boolean isShowDEFieldsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isShowDEFieldsDirty();
        }
        return this.showdefieldsDirtyFlag;
    }

    public void resetShowDEFields() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetShowDEFields();
            return;
        }
        this.showdefieldsDirtyFlag = false;
        this.showdefields = null;
    }

    public void setTopPos(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTopPos(n);
            return;
        }
        this.toppos = n;
        this.topposDirtyFlag = true;
    }

    public Integer getTopPos() {
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

    protected void onReset() {
        PSSysERMapNodeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysERMapNodeBase pSSysERMapNodeBase) {
        pSSysERMapNodeBase.resetColor();
        pSSysERMapNodeBase.resetCreateDate();
        pSSysERMapNodeBase.resetCreateMan();
        pSSysERMapNodeBase.resetDetailMode();
        pSSysERMapNodeBase.resetLeftPos();
        pSSysERMapNodeBase.resetLogicName();
        pSSysERMapNodeBase.resetMemo();
        pSSysERMapNodeBase.resetModColor();
        pSSysERMapNodeBase.resetNodeTag();
        pSSysERMapNodeBase.resetNodeTag2();
        pSSysERMapNodeBase.resetNodeType();
        pSSysERMapNodeBase.resetPSAppLocalDEId();
        pSSysERMapNodeBase.resetPSAppLocalDEName();
        pSSysERMapNodeBase.resetPSDEId();
        pSSysERMapNodeBase.resetPSDEName();
        pSSysERMapNodeBase.resetPSDEServiceAPIId();
        pSSysERMapNodeBase.resetPSDEServiceAPIName();
        pSSysERMapNodeBase.resetPSModuleId();
        pSSysERMapNodeBase.resetPSModuleName();
        pSSysERMapNodeBase.resetPSSubSysSADEId();
        pSSysERMapNodeBase.resetPSSubSysSADEName();
        pSSysERMapNodeBase.resetPSSubSysServiceAPIId();
        pSSysERMapNodeBase.resetPSSubSysServiceAPIName();
        pSSysERMapNodeBase.resetPSSysAppId();
        pSSysERMapNodeBase.resetPSSysAppName();
        pSSysERMapNodeBase.resetPSSysBDSchemeId();
        pSSysERMapNodeBase.resetPSSysBDSchemeName();
        pSSysERMapNodeBase.resetPSSysBDTableId();
        pSSysERMapNodeBase.resetPSSysBDTableName();
        pSSysERMapNodeBase.resetPSSysDBSchemeId();
        pSSysERMapNodeBase.resetPSSysDBSchemeName();
        pSSysERMapNodeBase.resetPSSysDBTableId();
        pSSysERMapNodeBase.resetPSSysDBTableName();
        pSSysERMapNodeBase.resetPSSysERMapId();
        pSSysERMapNodeBase.resetPSSysERMapName();
        pSSysERMapNodeBase.resetPSSysERMapNodeId();
        pSSysERMapNodeBase.resetPSSysERMapNodeName();
        pSSysERMapNodeBase.resetPSSysSearchDocId();
        pSSysERMapNodeBase.resetPSSysSearchDocName();
        pSSysERMapNodeBase.resetPSSysSearchSchemeId();
        pSSysERMapNodeBase.resetPSSysSearchSchemeName();
        pSSysERMapNodeBase.resetPSSysServiceAPIId();
        pSSysERMapNodeBase.resetPSSysServiceAPIName();
        pSSysERMapNodeBase.resetRefPSSysDynaModelId();
        pSSysERMapNodeBase.resetRefPSSysDynaModelName();
        pSSysERMapNodeBase.resetShapeParams();
        pSSysERMapNodeBase.resetShowDEFields();
        pSSysERMapNodeBase.resetTopPos();
        pSSysERMapNodeBase.resetUpdateDate();
        pSSysERMapNodeBase.resetUpdateMan();
        pSSysERMapNodeBase.resetUserCat();
        pSSysERMapNodeBase.resetUserTag();
        pSSysERMapNodeBase.resetUserTag2();
        pSSysERMapNodeBase.resetUserTag3();
        pSSysERMapNodeBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isColorDirty()) {
            hashMap.put(FIELD_COLOR, this.getColor());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDetailModeDirty()) {
            hashMap.put(FIELD_DETAILMODE, this.getDetailMode());
        }
        if (!bl || this.isLeftPosDirty()) {
            hashMap.put(FIELD_LEFTPOS, this.getLeftPos());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isModColorDirty()) {
            hashMap.put(FIELD_MODCOLOR, this.getModColor());
        }
        if (!bl || this.isNodeTagDirty()) {
            hashMap.put(FIELD_NODETAG, this.getNodeTag());
        }
        if (!bl || this.isNodeTag2Dirty()) {
            hashMap.put(FIELD_NODETAG2, this.getNodeTag2());
        }
        if (!bl || this.isNodeTypeDirty()) {
            hashMap.put(FIELD_NODETYPE, this.getNodeType());
        }
        if (!bl || this.isPSAppLocalDEIdDirty()) {
            hashMap.put(FIELD_PSAPPLOCALDEID, this.getPSAppLocalDEId());
        }
        if (!bl || this.isPSAppLocalDENameDirty()) {
            hashMap.put(FIELD_PSAPPLOCALDENAME, this.getPSAppLocalDEName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDEServiceAPIIdDirty()) {
            hashMap.put(FIELD_PSDESERVICEAPIID, this.getPSDEServiceAPIId());
        }
        if (!bl || this.isPSDEServiceAPINameDirty()) {
            hashMap.put(FIELD_PSDESERVICEAPINAME, this.getPSDEServiceAPIName());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSubSysSADEIdDirty()) {
            hashMap.put(FIELD_PSSUBSYSSADEID, this.getPSSubSysSADEId());
        }
        if (!bl || this.isPSSubSysSADENameDirty()) {
            hashMap.put(FIELD_PSSUBSYSSADENAME, this.getPSSubSysSADEName());
        }
        if (!bl || this.isPSSubSysServiceAPIIdDirty()) {
            hashMap.put(FIELD_PSSUBSYSSERVICEAPIID, this.getPSSubSysServiceAPIId());
        }
        if (!bl || this.isPSSubSysServiceAPINameDirty()) {
            hashMap.put(FIELD_PSSUBSYSSERVICEAPINAME, this.getPSSubSysServiceAPIName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isPSSysBDSchemeIdDirty()) {
            hashMap.put(FIELD_PSSYSBDSCHEMEID, this.getPSSysBDSchemeId());
        }
        if (!bl || this.isPSSysBDSchemeNameDirty()) {
            hashMap.put(FIELD_PSSYSBDSCHEMENAME, this.getPSSysBDSchemeName());
        }
        if (!bl || this.isPSSysBDTableIdDirty()) {
            hashMap.put(FIELD_PSSYSBDTABLEID, this.getPSSysBDTableId());
        }
        if (!bl || this.isPSSysBDTableNameDirty()) {
            hashMap.put(FIELD_PSSYSBDTABLENAME, this.getPSSysBDTableName());
        }
        if (!bl || this.isPSSysDBSchemeIdDirty()) {
            hashMap.put(FIELD_PSSYSDBSCHEMEID, this.getPSSysDBSchemeId());
        }
        if (!bl || this.isPSSysDBSchemeNameDirty()) {
            hashMap.put(FIELD_PSSYSDBSCHEMENAME, this.getPSSysDBSchemeName());
        }
        if (!bl || this.isPSSysDBTableIdDirty()) {
            hashMap.put(FIELD_PSSYSDBTABLEID, this.getPSSysDBTableId());
        }
        if (!bl || this.isPSSysDBTableNameDirty()) {
            hashMap.put(FIELD_PSSYSDBTABLENAME, this.getPSSysDBTableName());
        }
        if (!bl || this.isPSSysERMapIdDirty()) {
            hashMap.put(FIELD_PSSYSERMAPID, this.getPSSysERMapId());
        }
        if (!bl || this.isPSSysERMapNameDirty()) {
            hashMap.put(FIELD_PSSYSERMAPNAME, this.getPSSysERMapName());
        }
        if (!bl || this.isPSSysERMapNodeIdDirty()) {
            hashMap.put(FIELD_PSSYSERMAPNODEID, this.getPSSysERMapNodeId());
        }
        if (!bl || this.isPSSysERMapNodeNameDirty()) {
            hashMap.put(FIELD_PSSYSERMAPNODENAME, this.getPSSysERMapNodeName());
        }
        if (!bl || this.isPSSysSearchDocIdDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHDOCID, this.getPSSysSearchDocId());
        }
        if (!bl || this.isPSSysSearchDocNameDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHDOCNAME, this.getPSSysSearchDocName());
        }
        if (!bl || this.isPSSysSearchSchemeIdDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHSCHEMEID, this.getPSSysSearchSchemeId());
        }
        if (!bl || this.isPSSysSearchSchemeNameDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHSCHEMENAME, this.getPSSysSearchSchemeName());
        }
        if (!bl || this.isPSSysServiceAPIIdDirty()) {
            hashMap.put(FIELD_PSSYSSERVICEAPIID, this.getPSSysServiceAPIId());
        }
        if (!bl || this.isPSSysServiceAPINameDirty()) {
            hashMap.put(FIELD_PSSYSSERVICEAPINAME, this.getPSSysServiceAPIName());
        }
        if (!bl || this.isRefPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_REFPSSYSDYNAMODELID, this.getRefPSSysDynaModelId());
        }
        if (!bl || this.isRefPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_REFPSSYSDYNAMODELNAME, this.getRefPSSysDynaModelName());
        }
        if (!bl || this.isShapeParamsDirty()) {
            hashMap.put(FIELD_SHAPEPARAMS, this.getShapeParams());
        }
        if (!bl || this.isShowDEFieldsDirty()) {
            hashMap.put(FIELD_SHOWDEFIELDS, this.getShowDEFields());
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
        return PSSysERMapNodeBase.get(this, n);
    }

    private static Object get(PSSysERMapNodeBase pSSysERMapNodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysERMapNodeBase.getColor();
            }
            case 1: {
                return pSSysERMapNodeBase.getCreateDate();
            }
            case 2: {
                return pSSysERMapNodeBase.getCreateMan();
            }
            case 3: {
                return pSSysERMapNodeBase.getDetailMode();
            }
            case 4: {
                return pSSysERMapNodeBase.getLeftPos();
            }
            case 5: {
                return pSSysERMapNodeBase.getLogicName();
            }
            case 6: {
                return pSSysERMapNodeBase.getMemo();
            }
            case 7: {
                return pSSysERMapNodeBase.getModColor();
            }
            case 8: {
                return pSSysERMapNodeBase.getNodeTag();
            }
            case 9: {
                return pSSysERMapNodeBase.getNodeTag2();
            }
            case 10: {
                return pSSysERMapNodeBase.getNodeType();
            }
            case 11: {
                return pSSysERMapNodeBase.getPSAppLocalDEId();
            }
            case 12: {
                return pSSysERMapNodeBase.getPSAppLocalDEName();
            }
            case 13: {
                return pSSysERMapNodeBase.getPSDEId();
            }
            case 14: {
                return pSSysERMapNodeBase.getPSDEName();
            }
            case 15: {
                return pSSysERMapNodeBase.getPSDEServiceAPIId();
            }
            case 16: {
                return pSSysERMapNodeBase.getPSDEServiceAPIName();
            }
            case 17: {
                return pSSysERMapNodeBase.getPSModuleId();
            }
            case 18: {
                return pSSysERMapNodeBase.getPSModuleName();
            }
            case 19: {
                return pSSysERMapNodeBase.getPSSubSysSADEId();
            }
            case 20: {
                return pSSysERMapNodeBase.getPSSubSysSADEName();
            }
            case 21: {
                return pSSysERMapNodeBase.getPSSubSysServiceAPIId();
            }
            case 22: {
                return pSSysERMapNodeBase.getPSSubSysServiceAPIName();
            }
            case 23: {
                return pSSysERMapNodeBase.getPSSysAppId();
            }
            case 24: {
                return pSSysERMapNodeBase.getPSSysAppName();
            }
            case 25: {
                return pSSysERMapNodeBase.getPSSysBDSchemeId();
            }
            case 26: {
                return pSSysERMapNodeBase.getPSSysBDSchemeName();
            }
            case 27: {
                return pSSysERMapNodeBase.getPSSysBDTableId();
            }
            case 28: {
                return pSSysERMapNodeBase.getPSSysBDTableName();
            }
            case 29: {
                return pSSysERMapNodeBase.getPSSysDBSchemeId();
            }
            case 30: {
                return pSSysERMapNodeBase.getPSSysDBSchemeName();
            }
            case 31: {
                return pSSysERMapNodeBase.getPSSysDBTableId();
            }
            case 32: {
                return pSSysERMapNodeBase.getPSSysDBTableName();
            }
            case 33: {
                return pSSysERMapNodeBase.getPSSysERMapId();
            }
            case 34: {
                return pSSysERMapNodeBase.getPSSysERMapName();
            }
            case 35: {
                return pSSysERMapNodeBase.getPSSysERMapNodeId();
            }
            case 36: {
                return pSSysERMapNodeBase.getPSSysERMapNodeName();
            }
            case 37: {
                return pSSysERMapNodeBase.getPSSysSearchDocId();
            }
            case 38: {
                return pSSysERMapNodeBase.getPSSysSearchDocName();
            }
            case 39: {
                return pSSysERMapNodeBase.getPSSysSearchSchemeId();
            }
            case 40: {
                return pSSysERMapNodeBase.getPSSysSearchSchemeName();
            }
            case 41: {
                return pSSysERMapNodeBase.getPSSysServiceAPIId();
            }
            case 42: {
                return pSSysERMapNodeBase.getPSSysServiceAPIName();
            }
            case 43: {
                return pSSysERMapNodeBase.getRefPSSysDynaModelId();
            }
            case 44: {
                return pSSysERMapNodeBase.getRefPSSysDynaModelName();
            }
            case 45: {
                return pSSysERMapNodeBase.getShapeParams();
            }
            case 46: {
                return pSSysERMapNodeBase.getShowDEFields();
            }
            case 47: {
                return pSSysERMapNodeBase.getTopPos();
            }
            case 48: {
                return pSSysERMapNodeBase.getUpdateDate();
            }
            case 49: {
                return pSSysERMapNodeBase.getUpdateMan();
            }
            case 50: {
                return pSSysERMapNodeBase.getUserCat();
            }
            case 51: {
                return pSSysERMapNodeBase.getUserTag();
            }
            case 52: {
                return pSSysERMapNodeBase.getUserTag2();
            }
            case 53: {
                return pSSysERMapNodeBase.getUserTag3();
            }
            case 54: {
                return pSSysERMapNodeBase.getUserTag4();
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
        PSSysERMapNodeBase.set(this, n, object);
    }

    private static void set(PSSysERMapNodeBase pSSysERMapNodeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysERMapNodeBase.setColor(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysERMapNodeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysERMapNodeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysERMapNodeBase.setDetailMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSSysERMapNodeBase.setLeftPos(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSSysERMapNodeBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysERMapNodeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysERMapNodeBase.setModColor(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysERMapNodeBase.setNodeTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysERMapNodeBase.setNodeTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysERMapNodeBase.setNodeType(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysERMapNodeBase.setPSAppLocalDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysERMapNodeBase.setPSAppLocalDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysERMapNodeBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysERMapNodeBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysERMapNodeBase.setPSDEServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysERMapNodeBase.setPSDEServiceAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysERMapNodeBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysERMapNodeBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysERMapNodeBase.setPSSubSysSADEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysERMapNodeBase.setPSSubSysSADEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysERMapNodeBase.setPSSubSysServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysERMapNodeBase.setPSSubSysServiceAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysERMapNodeBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysERMapNodeBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysERMapNodeBase.setPSSysBDSchemeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysERMapNodeBase.setPSSysBDSchemeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysERMapNodeBase.setPSSysBDTableId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysERMapNodeBase.setPSSysBDTableName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysERMapNodeBase.setPSSysDBSchemeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysERMapNodeBase.setPSSysDBSchemeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysERMapNodeBase.setPSSysDBTableId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysERMapNodeBase.setPSSysDBTableName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysERMapNodeBase.setPSSysERMapId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysERMapNodeBase.setPSSysERMapName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysERMapNodeBase.setPSSysERMapNodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysERMapNodeBase.setPSSysERMapNodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysERMapNodeBase.setPSSysSearchDocId(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSysERMapNodeBase.setPSSysSearchDocName(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysERMapNodeBase.setPSSysSearchSchemeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSSysERMapNodeBase.setPSSysSearchSchemeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSSysERMapNodeBase.setPSSysServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSSysERMapNodeBase.setPSSysServiceAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSSysERMapNodeBase.setRefPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSSysERMapNodeBase.setRefPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSSysERMapNodeBase.setShapeParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSSysERMapNodeBase.setShowDEFields(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSSysERMapNodeBase.setTopPos(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 48: {
                pSSysERMapNodeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 49: {
                pSSysERMapNodeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSSysERMapNodeBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSSysERMapNodeBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSSysERMapNodeBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSSysERMapNodeBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSSysERMapNodeBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysERMapNodeBase.isNull(this, n);
    }

    private static boolean isNull(PSSysERMapNodeBase pSSysERMapNodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysERMapNodeBase.getColor() == null;
            }
            case 1: {
                return pSSysERMapNodeBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysERMapNodeBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysERMapNodeBase.getDetailMode() == null;
            }
            case 4: {
                return pSSysERMapNodeBase.getLeftPos() == null;
            }
            case 5: {
                return pSSysERMapNodeBase.getLogicName() == null;
            }
            case 6: {
                return pSSysERMapNodeBase.getMemo() == null;
            }
            case 7: {
                return pSSysERMapNodeBase.getModColor() == null;
            }
            case 8: {
                return pSSysERMapNodeBase.getNodeTag() == null;
            }
            case 9: {
                return pSSysERMapNodeBase.getNodeTag2() == null;
            }
            case 10: {
                return pSSysERMapNodeBase.getNodeType() == null;
            }
            case 11: {
                return pSSysERMapNodeBase.getPSAppLocalDEId() == null;
            }
            case 12: {
                return pSSysERMapNodeBase.getPSAppLocalDEName() == null;
            }
            case 13: {
                return pSSysERMapNodeBase.getPSDEId() == null;
            }
            case 14: {
                return pSSysERMapNodeBase.getPSDEName() == null;
            }
            case 15: {
                return pSSysERMapNodeBase.getPSDEServiceAPIId() == null;
            }
            case 16: {
                return pSSysERMapNodeBase.getPSDEServiceAPIName() == null;
            }
            case 17: {
                return pSSysERMapNodeBase.getPSModuleId() == null;
            }
            case 18: {
                return pSSysERMapNodeBase.getPSModuleName() == null;
            }
            case 19: {
                return pSSysERMapNodeBase.getPSSubSysSADEId() == null;
            }
            case 20: {
                return pSSysERMapNodeBase.getPSSubSysSADEName() == null;
            }
            case 21: {
                return pSSysERMapNodeBase.getPSSubSysServiceAPIId() == null;
            }
            case 22: {
                return pSSysERMapNodeBase.getPSSubSysServiceAPIName() == null;
            }
            case 23: {
                return pSSysERMapNodeBase.getPSSysAppId() == null;
            }
            case 24: {
                return pSSysERMapNodeBase.getPSSysAppName() == null;
            }
            case 25: {
                return pSSysERMapNodeBase.getPSSysBDSchemeId() == null;
            }
            case 26: {
                return pSSysERMapNodeBase.getPSSysBDSchemeName() == null;
            }
            case 27: {
                return pSSysERMapNodeBase.getPSSysBDTableId() == null;
            }
            case 28: {
                return pSSysERMapNodeBase.getPSSysBDTableName() == null;
            }
            case 29: {
                return pSSysERMapNodeBase.getPSSysDBSchemeId() == null;
            }
            case 30: {
                return pSSysERMapNodeBase.getPSSysDBSchemeName() == null;
            }
            case 31: {
                return pSSysERMapNodeBase.getPSSysDBTableId() == null;
            }
            case 32: {
                return pSSysERMapNodeBase.getPSSysDBTableName() == null;
            }
            case 33: {
                return pSSysERMapNodeBase.getPSSysERMapId() == null;
            }
            case 34: {
                return pSSysERMapNodeBase.getPSSysERMapName() == null;
            }
            case 35: {
                return pSSysERMapNodeBase.getPSSysERMapNodeId() == null;
            }
            case 36: {
                return pSSysERMapNodeBase.getPSSysERMapNodeName() == null;
            }
            case 37: {
                return pSSysERMapNodeBase.getPSSysSearchDocId() == null;
            }
            case 38: {
                return pSSysERMapNodeBase.getPSSysSearchDocName() == null;
            }
            case 39: {
                return pSSysERMapNodeBase.getPSSysSearchSchemeId() == null;
            }
            case 40: {
                return pSSysERMapNodeBase.getPSSysSearchSchemeName() == null;
            }
            case 41: {
                return pSSysERMapNodeBase.getPSSysServiceAPIId() == null;
            }
            case 42: {
                return pSSysERMapNodeBase.getPSSysServiceAPIName() == null;
            }
            case 43: {
                return pSSysERMapNodeBase.getRefPSSysDynaModelId() == null;
            }
            case 44: {
                return pSSysERMapNodeBase.getRefPSSysDynaModelName() == null;
            }
            case 45: {
                return pSSysERMapNodeBase.getShapeParams() == null;
            }
            case 46: {
                return pSSysERMapNodeBase.getShowDEFields() == null;
            }
            case 47: {
                return pSSysERMapNodeBase.getTopPos() == null;
            }
            case 48: {
                return pSSysERMapNodeBase.getUpdateDate() == null;
            }
            case 49: {
                return pSSysERMapNodeBase.getUpdateMan() == null;
            }
            case 50: {
                return pSSysERMapNodeBase.getUserCat() == null;
            }
            case 51: {
                return pSSysERMapNodeBase.getUserTag() == null;
            }
            case 52: {
                return pSSysERMapNodeBase.getUserTag2() == null;
            }
            case 53: {
                return pSSysERMapNodeBase.getUserTag3() == null;
            }
            case 54: {
                return pSSysERMapNodeBase.getUserTag4() == null;
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
        return PSSysERMapNodeBase.contains(this, n);
    }

    private static boolean contains(PSSysERMapNodeBase pSSysERMapNodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysERMapNodeBase.isColorDirty();
            }
            case 1: {
                return pSSysERMapNodeBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysERMapNodeBase.isCreateManDirty();
            }
            case 3: {
                return pSSysERMapNodeBase.isDetailModeDirty();
            }
            case 4: {
                return pSSysERMapNodeBase.isLeftPosDirty();
            }
            case 5: {
                return pSSysERMapNodeBase.isLogicNameDirty();
            }
            case 6: {
                return pSSysERMapNodeBase.isMemoDirty();
            }
            case 7: {
                return pSSysERMapNodeBase.isModColorDirty();
            }
            case 8: {
                return pSSysERMapNodeBase.isNodeTagDirty();
            }
            case 9: {
                return pSSysERMapNodeBase.isNodeTag2Dirty();
            }
            case 10: {
                return pSSysERMapNodeBase.isNodeTypeDirty();
            }
            case 11: {
                return pSSysERMapNodeBase.isPSAppLocalDEIdDirty();
            }
            case 12: {
                return pSSysERMapNodeBase.isPSAppLocalDENameDirty();
            }
            case 13: {
                return pSSysERMapNodeBase.isPSDEIdDirty();
            }
            case 14: {
                return pSSysERMapNodeBase.isPSDENameDirty();
            }
            case 15: {
                return pSSysERMapNodeBase.isPSDEServiceAPIIdDirty();
            }
            case 16: {
                return pSSysERMapNodeBase.isPSDEServiceAPINameDirty();
            }
            case 17: {
                return pSSysERMapNodeBase.isPSModuleIdDirty();
            }
            case 18: {
                return pSSysERMapNodeBase.isPSModuleNameDirty();
            }
            case 19: {
                return pSSysERMapNodeBase.isPSSubSysSADEIdDirty();
            }
            case 20: {
                return pSSysERMapNodeBase.isPSSubSysSADENameDirty();
            }
            case 21: {
                return pSSysERMapNodeBase.isPSSubSysServiceAPIIdDirty();
            }
            case 22: {
                return pSSysERMapNodeBase.isPSSubSysServiceAPINameDirty();
            }
            case 23: {
                return pSSysERMapNodeBase.isPSSysAppIdDirty();
            }
            case 24: {
                return pSSysERMapNodeBase.isPSSysAppNameDirty();
            }
            case 25: {
                return pSSysERMapNodeBase.isPSSysBDSchemeIdDirty();
            }
            case 26: {
                return pSSysERMapNodeBase.isPSSysBDSchemeNameDirty();
            }
            case 27: {
                return pSSysERMapNodeBase.isPSSysBDTableIdDirty();
            }
            case 28: {
                return pSSysERMapNodeBase.isPSSysBDTableNameDirty();
            }
            case 29: {
                return pSSysERMapNodeBase.isPSSysDBSchemeIdDirty();
            }
            case 30: {
                return pSSysERMapNodeBase.isPSSysDBSchemeNameDirty();
            }
            case 31: {
                return pSSysERMapNodeBase.isPSSysDBTableIdDirty();
            }
            case 32: {
                return pSSysERMapNodeBase.isPSSysDBTableNameDirty();
            }
            case 33: {
                return pSSysERMapNodeBase.isPSSysERMapIdDirty();
            }
            case 34: {
                return pSSysERMapNodeBase.isPSSysERMapNameDirty();
            }
            case 35: {
                return pSSysERMapNodeBase.isPSSysERMapNodeIdDirty();
            }
            case 36: {
                return pSSysERMapNodeBase.isPSSysERMapNodeNameDirty();
            }
            case 37: {
                return pSSysERMapNodeBase.isPSSysSearchDocIdDirty();
            }
            case 38: {
                return pSSysERMapNodeBase.isPSSysSearchDocNameDirty();
            }
            case 39: {
                return pSSysERMapNodeBase.isPSSysSearchSchemeIdDirty();
            }
            case 40: {
                return pSSysERMapNodeBase.isPSSysSearchSchemeNameDirty();
            }
            case 41: {
                return pSSysERMapNodeBase.isPSSysServiceAPIIdDirty();
            }
            case 42: {
                return pSSysERMapNodeBase.isPSSysServiceAPINameDirty();
            }
            case 43: {
                return pSSysERMapNodeBase.isRefPSSysDynaModelIdDirty();
            }
            case 44: {
                return pSSysERMapNodeBase.isRefPSSysDynaModelNameDirty();
            }
            case 45: {
                return pSSysERMapNodeBase.isShapeParamsDirty();
            }
            case 46: {
                return pSSysERMapNodeBase.isShowDEFieldsDirty();
            }
            case 47: {
                return pSSysERMapNodeBase.isTopPosDirty();
            }
            case 48: {
                return pSSysERMapNodeBase.isUpdateDateDirty();
            }
            case 49: {
                return pSSysERMapNodeBase.isUpdateManDirty();
            }
            case 50: {
                return pSSysERMapNodeBase.isUserCatDirty();
            }
            case 51: {
                return pSSysERMapNodeBase.isUserTagDirty();
            }
            case 52: {
                return pSSysERMapNodeBase.isUserTag2Dirty();
            }
            case 53: {
                return pSSysERMapNodeBase.isUserTag3Dirty();
            }
            case 54: {
                return pSSysERMapNodeBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysERMapNodeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysERMapNodeBase pSSysERMapNodeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysERMapNodeBase.getColor() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"color", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getColor()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getDetailMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detailmode", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getDetailMode()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getLeftPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"leftpos", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getLeftPos()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getLogicName()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getModColor() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modcolor", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getModColor()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getNodeTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nodetag", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getNodeTag()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getNodeTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nodetag2", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getNodeTag2()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getNodeType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nodetype", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getNodeType()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getPSAppLocalDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapplocaldeid", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getPSAppLocalDEId()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getPSAppLocalDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapplocaldename", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getPSAppLocalDEName()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getPSDEServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeserviceapiid", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getPSDEServiceAPIId()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getPSDEServiceAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeserviceapiname", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getPSDEServiceAPIName()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getPSSubSysSADEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsyssadeid", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getPSSubSysSADEId()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getPSSubSysSADEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsyssadename", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getPSSubSysSADEName()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getPSSubSysServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysserviceapiid", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getPSSubSysServiceAPIId()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getPSSubSysServiceAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysserviceapiname", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getPSSubSysServiceAPIName()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getPSSysBDSchemeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdschemeid", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getPSSysBDSchemeId()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getPSSysBDSchemeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdschemename", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getPSSysBDSchemeName()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getPSSysBDTableId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdtableid", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getPSSysBDTableId()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getPSSysBDTableName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdtablename", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getPSSysBDTableName()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getPSSysDBSchemeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbschemeid", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getPSSysDBSchemeId()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getPSSysDBSchemeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbschemename", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getPSSysDBSchemeName()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getPSSysDBTableId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbtableid", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getPSSysDBTableId()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getPSSysDBTableName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbtablename", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getPSSysDBTableName()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getPSSysERMapId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysermapid", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getPSSysERMapId()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getPSSysERMapName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysermapname", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getPSSysERMapName()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getPSSysERMapNodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysermapnodeid", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getPSSysERMapNodeId()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getPSSysERMapNodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysermapnodename", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getPSSysERMapNodeName()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getPSSysSearchDocId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchdocid", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getPSSysSearchDocId()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getPSSysSearchDocName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchdocname", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getPSSysSearchDocName()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getPSSysSearchSchemeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchschemeid", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getPSSysSearchSchemeId()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getPSSysSearchSchemeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchschemename", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getPSSysSearchSchemeName()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getPSSysServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysserviceapiid", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getPSSysServiceAPIId()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getPSSysServiceAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysserviceapiname", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getPSSysServiceAPIName()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getRefPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpssysdynamodelid", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getRefPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getRefPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpssysdynamodelname", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getRefPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getShapeParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"shapeparams", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getShapeParams()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getShowDEFields() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"showdefields", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getShowDEFields()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getTopPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"toppos", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getTopPos()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysERMapNodeBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysERMapNodeBase.getJSONValue((Object)pSSysERMapNodeBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysERMapNodeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysERMapNodeBase pSSysERMapNodeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysERMapNodeBase.getColor() != null) {
            object = pSSysERMapNodeBase.getColor();
            xmlNode.setAttribute(FIELD_COLOR, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getCreateDate() != null) {
            object = pSSysERMapNodeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysERMapNodeBase.getCreateMan() != null) {
            object = pSSysERMapNodeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getDetailMode() != null) {
            object = pSSysERMapNodeBase.getDetailMode();
            xmlNode.setAttribute(FIELD_DETAILMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysERMapNodeBase.getLeftPos() != null) {
            object = pSSysERMapNodeBase.getLeftPos();
            xmlNode.setAttribute(FIELD_LEFTPOS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysERMapNodeBase.getLogicName() != null) {
            object = pSSysERMapNodeBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getMemo() != null) {
            object = pSSysERMapNodeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getModColor() != null) {
            object = pSSysERMapNodeBase.getModColor();
            xmlNode.setAttribute(FIELD_MODCOLOR, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getNodeTag() != null) {
            object = pSSysERMapNodeBase.getNodeTag();
            xmlNode.setAttribute(FIELD_NODETAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getNodeTag2() != null) {
            object = pSSysERMapNodeBase.getNodeTag2();
            xmlNode.setAttribute(FIELD_NODETAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getNodeType() != null) {
            object = pSSysERMapNodeBase.getNodeType();
            xmlNode.setAttribute(FIELD_NODETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getPSAppLocalDEId() != null) {
            object = pSSysERMapNodeBase.getPSAppLocalDEId();
            xmlNode.setAttribute(FIELD_PSAPPLOCALDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getPSAppLocalDEName() != null) {
            object = pSSysERMapNodeBase.getPSAppLocalDEName();
            xmlNode.setAttribute(FIELD_PSAPPLOCALDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getPSDEId() != null) {
            object = pSSysERMapNodeBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getPSDEName() != null) {
            object = pSSysERMapNodeBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getPSDEServiceAPIId() != null) {
            object = pSSysERMapNodeBase.getPSDEServiceAPIId();
            xmlNode.setAttribute(FIELD_PSDESERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getPSDEServiceAPIName() != null) {
            object = pSSysERMapNodeBase.getPSDEServiceAPIName();
            xmlNode.setAttribute(FIELD_PSDESERVICEAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getPSModuleId() != null) {
            object = pSSysERMapNodeBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getPSModuleName() != null) {
            object = pSSysERMapNodeBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getPSSubSysSADEId() != null) {
            object = pSSysERMapNodeBase.getPSSubSysSADEId();
            xmlNode.setAttribute(FIELD_PSSUBSYSSADEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getPSSubSysSADEName() != null) {
            object = pSSysERMapNodeBase.getPSSubSysSADEName();
            xmlNode.setAttribute(FIELD_PSSUBSYSSADENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getPSSubSysServiceAPIId() != null) {
            object = pSSysERMapNodeBase.getPSSubSysServiceAPIId();
            xmlNode.setAttribute(FIELD_PSSUBSYSSERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getPSSubSysServiceAPIName() != null) {
            object = pSSysERMapNodeBase.getPSSubSysServiceAPIName();
            xmlNode.setAttribute(FIELD_PSSUBSYSSERVICEAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getPSSysAppId() != null) {
            object = pSSysERMapNodeBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getPSSysAppName() != null) {
            object = pSSysERMapNodeBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getPSSysBDSchemeId() != null) {
            object = pSSysERMapNodeBase.getPSSysBDSchemeId();
            xmlNode.setAttribute(FIELD_PSSYSBDSCHEMEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getPSSysBDSchemeName() != null) {
            object = pSSysERMapNodeBase.getPSSysBDSchemeName();
            xmlNode.setAttribute(FIELD_PSSYSBDSCHEMENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getPSSysBDTableId() != null) {
            object = pSSysERMapNodeBase.getPSSysBDTableId();
            xmlNode.setAttribute(FIELD_PSSYSBDTABLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getPSSysBDTableName() != null) {
            object = pSSysERMapNodeBase.getPSSysBDTableName();
            xmlNode.setAttribute(FIELD_PSSYSBDTABLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getPSSysDBSchemeId() != null) {
            object = pSSysERMapNodeBase.getPSSysDBSchemeId();
            xmlNode.setAttribute(FIELD_PSSYSDBSCHEMEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getPSSysDBSchemeName() != null) {
            object = pSSysERMapNodeBase.getPSSysDBSchemeName();
            xmlNode.setAttribute(FIELD_PSSYSDBSCHEMENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getPSSysDBTableId() != null) {
            object = pSSysERMapNodeBase.getPSSysDBTableId();
            xmlNode.setAttribute(FIELD_PSSYSDBTABLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getPSSysDBTableName() != null) {
            object = pSSysERMapNodeBase.getPSSysDBTableName();
            xmlNode.setAttribute(FIELD_PSSYSDBTABLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getPSSysERMapId() != null) {
            object = pSSysERMapNodeBase.getPSSysERMapId();
            xmlNode.setAttribute(FIELD_PSSYSERMAPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getPSSysERMapName() != null) {
            object = pSSysERMapNodeBase.getPSSysERMapName();
            xmlNode.setAttribute(FIELD_PSSYSERMAPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getPSSysERMapNodeId() != null) {
            object = pSSysERMapNodeBase.getPSSysERMapNodeId();
            xmlNode.setAttribute(FIELD_PSSYSERMAPNODEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getPSSysERMapNodeName() != null) {
            object = pSSysERMapNodeBase.getPSSysERMapNodeName();
            xmlNode.setAttribute(FIELD_PSSYSERMAPNODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getPSSysSearchDocId() != null) {
            object = pSSysERMapNodeBase.getPSSysSearchDocId();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHDOCID, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getPSSysSearchDocName() != null) {
            object = pSSysERMapNodeBase.getPSSysSearchDocName();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHDOCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getPSSysSearchSchemeId() != null) {
            object = pSSysERMapNodeBase.getPSSysSearchSchemeId();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHSCHEMEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getPSSysSearchSchemeName() != null) {
            object = pSSysERMapNodeBase.getPSSysSearchSchemeName();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHSCHEMENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getPSSysServiceAPIId() != null) {
            object = pSSysERMapNodeBase.getPSSysServiceAPIId();
            xmlNode.setAttribute(FIELD_PSSYSSERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getPSSysServiceAPIName() != null) {
            object = pSSysERMapNodeBase.getPSSysServiceAPIName();
            xmlNode.setAttribute(FIELD_PSSYSSERVICEAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getRefPSSysDynaModelId() != null) {
            object = pSSysERMapNodeBase.getRefPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_REFPSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getRefPSSysDynaModelName() != null) {
            object = pSSysERMapNodeBase.getRefPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_REFPSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getShapeParams() != null) {
            object = pSSysERMapNodeBase.getShapeParams();
            xmlNode.setAttribute(FIELD_SHAPEPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getShowDEFields() != null) {
            object = pSSysERMapNodeBase.getShowDEFields();
            xmlNode.setAttribute(FIELD_SHOWDEFIELDS, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getTopPos() != null) {
            object = pSSysERMapNodeBase.getTopPos();
            xmlNode.setAttribute(FIELD_TOPPOS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysERMapNodeBase.getUpdateDate() != null) {
            object = pSSysERMapNodeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysERMapNodeBase.getUpdateMan() != null) {
            object = pSSysERMapNodeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getUserCat() != null) {
            object = pSSysERMapNodeBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getUserTag() != null) {
            object = pSSysERMapNodeBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getUserTag2() != null) {
            object = pSSysERMapNodeBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getUserTag3() != null) {
            object = pSSysERMapNodeBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapNodeBase.getUserTag4() != null) {
            object = pSSysERMapNodeBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysERMapNodeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysERMapNodeBase pSSysERMapNodeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysERMapNodeBase.isColorDirty() && (bl || pSSysERMapNodeBase.getColor() != null)) {
            iDataObject.set(FIELD_COLOR, (Object)pSSysERMapNodeBase.getColor());
        }
        if (pSSysERMapNodeBase.isCreateDateDirty() && (bl || pSSysERMapNodeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysERMapNodeBase.getCreateDate());
        }
        if (pSSysERMapNodeBase.isCreateManDirty() && (bl || pSSysERMapNodeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysERMapNodeBase.getCreateMan());
        }
        if (pSSysERMapNodeBase.isDetailModeDirty() && (bl || pSSysERMapNodeBase.getDetailMode() != null)) {
            iDataObject.set(FIELD_DETAILMODE, (Object)pSSysERMapNodeBase.getDetailMode());
        }
        if (pSSysERMapNodeBase.isLeftPosDirty() && (bl || pSSysERMapNodeBase.getLeftPos() != null)) {
            iDataObject.set(FIELD_LEFTPOS, (Object)pSSysERMapNodeBase.getLeftPos());
        }
        if (pSSysERMapNodeBase.isLogicNameDirty() && (bl || pSSysERMapNodeBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSSysERMapNodeBase.getLogicName());
        }
        if (pSSysERMapNodeBase.isMemoDirty() && (bl || pSSysERMapNodeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysERMapNodeBase.getMemo());
        }
        if (pSSysERMapNodeBase.isModColorDirty() && (bl || pSSysERMapNodeBase.getModColor() != null)) {
            iDataObject.set(FIELD_MODCOLOR, (Object)pSSysERMapNodeBase.getModColor());
        }
        if (pSSysERMapNodeBase.isNodeTagDirty() && (bl || pSSysERMapNodeBase.getNodeTag() != null)) {
            iDataObject.set(FIELD_NODETAG, (Object)pSSysERMapNodeBase.getNodeTag());
        }
        if (pSSysERMapNodeBase.isNodeTag2Dirty() && (bl || pSSysERMapNodeBase.getNodeTag2() != null)) {
            iDataObject.set(FIELD_NODETAG2, (Object)pSSysERMapNodeBase.getNodeTag2());
        }
        if (pSSysERMapNodeBase.isNodeTypeDirty() && (bl || pSSysERMapNodeBase.getNodeType() != null)) {
            iDataObject.set(FIELD_NODETYPE, (Object)pSSysERMapNodeBase.getNodeType());
        }
        if (pSSysERMapNodeBase.isPSAppLocalDEIdDirty() && (bl || pSSysERMapNodeBase.getPSAppLocalDEId() != null)) {
            iDataObject.set(FIELD_PSAPPLOCALDEID, (Object)pSSysERMapNodeBase.getPSAppLocalDEId());
        }
        if (pSSysERMapNodeBase.isPSAppLocalDENameDirty() && (bl || pSSysERMapNodeBase.getPSAppLocalDEName() != null)) {
            iDataObject.set(FIELD_PSAPPLOCALDENAME, (Object)pSSysERMapNodeBase.getPSAppLocalDEName());
        }
        if (pSSysERMapNodeBase.isPSDEIdDirty() && (bl || pSSysERMapNodeBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysERMapNodeBase.getPSDEId());
        }
        if (pSSysERMapNodeBase.isPSDENameDirty() && (bl || pSSysERMapNodeBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysERMapNodeBase.getPSDEName());
        }
        if (pSSysERMapNodeBase.isPSDEServiceAPIIdDirty() && (bl || pSSysERMapNodeBase.getPSDEServiceAPIId() != null)) {
            iDataObject.set(FIELD_PSDESERVICEAPIID, (Object)pSSysERMapNodeBase.getPSDEServiceAPIId());
        }
        if (pSSysERMapNodeBase.isPSDEServiceAPINameDirty() && (bl || pSSysERMapNodeBase.getPSDEServiceAPIName() != null)) {
            iDataObject.set(FIELD_PSDESERVICEAPINAME, (Object)pSSysERMapNodeBase.getPSDEServiceAPIName());
        }
        if (pSSysERMapNodeBase.isPSModuleIdDirty() && (bl || pSSysERMapNodeBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysERMapNodeBase.getPSModuleId());
        }
        if (pSSysERMapNodeBase.isPSModuleNameDirty() && (bl || pSSysERMapNodeBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysERMapNodeBase.getPSModuleName());
        }
        if (pSSysERMapNodeBase.isPSSubSysSADEIdDirty() && (bl || pSSysERMapNodeBase.getPSSubSysSADEId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSADEID, (Object)pSSysERMapNodeBase.getPSSubSysSADEId());
        }
        if (pSSysERMapNodeBase.isPSSubSysSADENameDirty() && (bl || pSSysERMapNodeBase.getPSSubSysSADEName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSADENAME, (Object)pSSysERMapNodeBase.getPSSubSysSADEName());
        }
        if (pSSysERMapNodeBase.isPSSubSysServiceAPIIdDirty() && (bl || pSSysERMapNodeBase.getPSSubSysServiceAPIId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSERVICEAPIID, (Object)pSSysERMapNodeBase.getPSSubSysServiceAPIId());
        }
        if (pSSysERMapNodeBase.isPSSubSysServiceAPINameDirty() && (bl || pSSysERMapNodeBase.getPSSubSysServiceAPIName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSERVICEAPINAME, (Object)pSSysERMapNodeBase.getPSSubSysServiceAPIName());
        }
        if (pSSysERMapNodeBase.isPSSysAppIdDirty() && (bl || pSSysERMapNodeBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSSysERMapNodeBase.getPSSysAppId());
        }
        if (pSSysERMapNodeBase.isPSSysAppNameDirty() && (bl || pSSysERMapNodeBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSSysERMapNodeBase.getPSSysAppName());
        }
        if (pSSysERMapNodeBase.isPSSysBDSchemeIdDirty() && (bl || pSSysERMapNodeBase.getPSSysBDSchemeId() != null)) {
            iDataObject.set(FIELD_PSSYSBDSCHEMEID, (Object)pSSysERMapNodeBase.getPSSysBDSchemeId());
        }
        if (pSSysERMapNodeBase.isPSSysBDSchemeNameDirty() && (bl || pSSysERMapNodeBase.getPSSysBDSchemeName() != null)) {
            iDataObject.set(FIELD_PSSYSBDSCHEMENAME, (Object)pSSysERMapNodeBase.getPSSysBDSchemeName());
        }
        if (pSSysERMapNodeBase.isPSSysBDTableIdDirty() && (bl || pSSysERMapNodeBase.getPSSysBDTableId() != null)) {
            iDataObject.set(FIELD_PSSYSBDTABLEID, (Object)pSSysERMapNodeBase.getPSSysBDTableId());
        }
        if (pSSysERMapNodeBase.isPSSysBDTableNameDirty() && (bl || pSSysERMapNodeBase.getPSSysBDTableName() != null)) {
            iDataObject.set(FIELD_PSSYSBDTABLENAME, (Object)pSSysERMapNodeBase.getPSSysBDTableName());
        }
        if (pSSysERMapNodeBase.isPSSysDBSchemeIdDirty() && (bl || pSSysERMapNodeBase.getPSSysDBSchemeId() != null)) {
            iDataObject.set(FIELD_PSSYSDBSCHEMEID, (Object)pSSysERMapNodeBase.getPSSysDBSchemeId());
        }
        if (pSSysERMapNodeBase.isPSSysDBSchemeNameDirty() && (bl || pSSysERMapNodeBase.getPSSysDBSchemeName() != null)) {
            iDataObject.set(FIELD_PSSYSDBSCHEMENAME, (Object)pSSysERMapNodeBase.getPSSysDBSchemeName());
        }
        if (pSSysERMapNodeBase.isPSSysDBTableIdDirty() && (bl || pSSysERMapNodeBase.getPSSysDBTableId() != null)) {
            iDataObject.set(FIELD_PSSYSDBTABLEID, (Object)pSSysERMapNodeBase.getPSSysDBTableId());
        }
        if (pSSysERMapNodeBase.isPSSysDBTableNameDirty() && (bl || pSSysERMapNodeBase.getPSSysDBTableName() != null)) {
            iDataObject.set(FIELD_PSSYSDBTABLENAME, (Object)pSSysERMapNodeBase.getPSSysDBTableName());
        }
        if (pSSysERMapNodeBase.isPSSysERMapIdDirty() && (bl || pSSysERMapNodeBase.getPSSysERMapId() != null)) {
            iDataObject.set(FIELD_PSSYSERMAPID, (Object)pSSysERMapNodeBase.getPSSysERMapId());
        }
        if (pSSysERMapNodeBase.isPSSysERMapNameDirty() && (bl || pSSysERMapNodeBase.getPSSysERMapName() != null)) {
            iDataObject.set(FIELD_PSSYSERMAPNAME, (Object)pSSysERMapNodeBase.getPSSysERMapName());
        }
        if (pSSysERMapNodeBase.isPSSysERMapNodeIdDirty() && (bl || pSSysERMapNodeBase.getPSSysERMapNodeId() != null)) {
            iDataObject.set(FIELD_PSSYSERMAPNODEID, (Object)pSSysERMapNodeBase.getPSSysERMapNodeId());
        }
        if (pSSysERMapNodeBase.isPSSysERMapNodeNameDirty() && (bl || pSSysERMapNodeBase.getPSSysERMapNodeName() != null)) {
            iDataObject.set(FIELD_PSSYSERMAPNODENAME, (Object)pSSysERMapNodeBase.getPSSysERMapNodeName());
        }
        if (pSSysERMapNodeBase.isPSSysSearchDocIdDirty() && (bl || pSSysERMapNodeBase.getPSSysSearchDocId() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHDOCID, (Object)pSSysERMapNodeBase.getPSSysSearchDocId());
        }
        if (pSSysERMapNodeBase.isPSSysSearchDocNameDirty() && (bl || pSSysERMapNodeBase.getPSSysSearchDocName() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHDOCNAME, (Object)pSSysERMapNodeBase.getPSSysSearchDocName());
        }
        if (pSSysERMapNodeBase.isPSSysSearchSchemeIdDirty() && (bl || pSSysERMapNodeBase.getPSSysSearchSchemeId() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHSCHEMEID, (Object)pSSysERMapNodeBase.getPSSysSearchSchemeId());
        }
        if (pSSysERMapNodeBase.isPSSysSearchSchemeNameDirty() && (bl || pSSysERMapNodeBase.getPSSysSearchSchemeName() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHSCHEMENAME, (Object)pSSysERMapNodeBase.getPSSysSearchSchemeName());
        }
        if (pSSysERMapNodeBase.isPSSysServiceAPIIdDirty() && (bl || pSSysERMapNodeBase.getPSSysServiceAPIId() != null)) {
            iDataObject.set(FIELD_PSSYSSERVICEAPIID, (Object)pSSysERMapNodeBase.getPSSysServiceAPIId());
        }
        if (pSSysERMapNodeBase.isPSSysServiceAPINameDirty() && (bl || pSSysERMapNodeBase.getPSSysServiceAPIName() != null)) {
            iDataObject.set(FIELD_PSSYSSERVICEAPINAME, (Object)pSSysERMapNodeBase.getPSSysServiceAPIName());
        }
        if (pSSysERMapNodeBase.isRefPSSysDynaModelIdDirty() && (bl || pSSysERMapNodeBase.getRefPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_REFPSSYSDYNAMODELID, (Object)pSSysERMapNodeBase.getRefPSSysDynaModelId());
        }
        if (pSSysERMapNodeBase.isRefPSSysDynaModelNameDirty() && (bl || pSSysERMapNodeBase.getRefPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_REFPSSYSDYNAMODELNAME, (Object)pSSysERMapNodeBase.getRefPSSysDynaModelName());
        }
        if (pSSysERMapNodeBase.isShapeParamsDirty() && (bl || pSSysERMapNodeBase.getShapeParams() != null)) {
            iDataObject.set(FIELD_SHAPEPARAMS, (Object)pSSysERMapNodeBase.getShapeParams());
        }
        if (pSSysERMapNodeBase.isShowDEFieldsDirty() && (bl || pSSysERMapNodeBase.getShowDEFields() != null)) {
            iDataObject.set(FIELD_SHOWDEFIELDS, (Object)pSSysERMapNodeBase.getShowDEFields());
        }
        if (pSSysERMapNodeBase.isTopPosDirty() && (bl || pSSysERMapNodeBase.getTopPos() != null)) {
            iDataObject.set(FIELD_TOPPOS, (Object)pSSysERMapNodeBase.getTopPos());
        }
        if (pSSysERMapNodeBase.isUpdateDateDirty() && (bl || pSSysERMapNodeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysERMapNodeBase.getUpdateDate());
        }
        if (pSSysERMapNodeBase.isUpdateManDirty() && (bl || pSSysERMapNodeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysERMapNodeBase.getUpdateMan());
        }
        if (pSSysERMapNodeBase.isUserCatDirty() && (bl || pSSysERMapNodeBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysERMapNodeBase.getUserCat());
        }
        if (pSSysERMapNodeBase.isUserTagDirty() && (bl || pSSysERMapNodeBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysERMapNodeBase.getUserTag());
        }
        if (pSSysERMapNodeBase.isUserTag2Dirty() && (bl || pSSysERMapNodeBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysERMapNodeBase.getUserTag2());
        }
        if (pSSysERMapNodeBase.isUserTag3Dirty() && (bl || pSSysERMapNodeBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysERMapNodeBase.getUserTag3());
        }
        if (pSSysERMapNodeBase.isUserTag4Dirty() && (bl || pSSysERMapNodeBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysERMapNodeBase.getUserTag4());
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
        return PSSysERMapNodeBase.remove(this, n);
    }

    private static boolean remove(PSSysERMapNodeBase pSSysERMapNodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysERMapNodeBase.resetColor();
                return true;
            }
            case 1: {
                pSSysERMapNodeBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysERMapNodeBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysERMapNodeBase.resetDetailMode();
                return true;
            }
            case 4: {
                pSSysERMapNodeBase.resetLeftPos();
                return true;
            }
            case 5: {
                pSSysERMapNodeBase.resetLogicName();
                return true;
            }
            case 6: {
                pSSysERMapNodeBase.resetMemo();
                return true;
            }
            case 7: {
                pSSysERMapNodeBase.resetModColor();
                return true;
            }
            case 8: {
                pSSysERMapNodeBase.resetNodeTag();
                return true;
            }
            case 9: {
                pSSysERMapNodeBase.resetNodeTag2();
                return true;
            }
            case 10: {
                pSSysERMapNodeBase.resetNodeType();
                return true;
            }
            case 11: {
                pSSysERMapNodeBase.resetPSAppLocalDEId();
                return true;
            }
            case 12: {
                pSSysERMapNodeBase.resetPSAppLocalDEName();
                return true;
            }
            case 13: {
                pSSysERMapNodeBase.resetPSDEId();
                return true;
            }
            case 14: {
                pSSysERMapNodeBase.resetPSDEName();
                return true;
            }
            case 15: {
                pSSysERMapNodeBase.resetPSDEServiceAPIId();
                return true;
            }
            case 16: {
                pSSysERMapNodeBase.resetPSDEServiceAPIName();
                return true;
            }
            case 17: {
                pSSysERMapNodeBase.resetPSModuleId();
                return true;
            }
            case 18: {
                pSSysERMapNodeBase.resetPSModuleName();
                return true;
            }
            case 19: {
                pSSysERMapNodeBase.resetPSSubSysSADEId();
                return true;
            }
            case 20: {
                pSSysERMapNodeBase.resetPSSubSysSADEName();
                return true;
            }
            case 21: {
                pSSysERMapNodeBase.resetPSSubSysServiceAPIId();
                return true;
            }
            case 22: {
                pSSysERMapNodeBase.resetPSSubSysServiceAPIName();
                return true;
            }
            case 23: {
                pSSysERMapNodeBase.resetPSSysAppId();
                return true;
            }
            case 24: {
                pSSysERMapNodeBase.resetPSSysAppName();
                return true;
            }
            case 25: {
                pSSysERMapNodeBase.resetPSSysBDSchemeId();
                return true;
            }
            case 26: {
                pSSysERMapNodeBase.resetPSSysBDSchemeName();
                return true;
            }
            case 27: {
                pSSysERMapNodeBase.resetPSSysBDTableId();
                return true;
            }
            case 28: {
                pSSysERMapNodeBase.resetPSSysBDTableName();
                return true;
            }
            case 29: {
                pSSysERMapNodeBase.resetPSSysDBSchemeId();
                return true;
            }
            case 30: {
                pSSysERMapNodeBase.resetPSSysDBSchemeName();
                return true;
            }
            case 31: {
                pSSysERMapNodeBase.resetPSSysDBTableId();
                return true;
            }
            case 32: {
                pSSysERMapNodeBase.resetPSSysDBTableName();
                return true;
            }
            case 33: {
                pSSysERMapNodeBase.resetPSSysERMapId();
                return true;
            }
            case 34: {
                pSSysERMapNodeBase.resetPSSysERMapName();
                return true;
            }
            case 35: {
                pSSysERMapNodeBase.resetPSSysERMapNodeId();
                return true;
            }
            case 36: {
                pSSysERMapNodeBase.resetPSSysERMapNodeName();
                return true;
            }
            case 37: {
                pSSysERMapNodeBase.resetPSSysSearchDocId();
                return true;
            }
            case 38: {
                pSSysERMapNodeBase.resetPSSysSearchDocName();
                return true;
            }
            case 39: {
                pSSysERMapNodeBase.resetPSSysSearchSchemeId();
                return true;
            }
            case 40: {
                pSSysERMapNodeBase.resetPSSysSearchSchemeName();
                return true;
            }
            case 41: {
                pSSysERMapNodeBase.resetPSSysServiceAPIId();
                return true;
            }
            case 42: {
                pSSysERMapNodeBase.resetPSSysServiceAPIName();
                return true;
            }
            case 43: {
                pSSysERMapNodeBase.resetRefPSSysDynaModelId();
                return true;
            }
            case 44: {
                pSSysERMapNodeBase.resetRefPSSysDynaModelName();
                return true;
            }
            case 45: {
                pSSysERMapNodeBase.resetShapeParams();
                return true;
            }
            case 46: {
                pSSysERMapNodeBase.resetShowDEFields();
                return true;
            }
            case 47: {
                pSSysERMapNodeBase.resetTopPos();
                return true;
            }
            case 48: {
                pSSysERMapNodeBase.resetUpdateDate();
                return true;
            }
            case 49: {
                pSSysERMapNodeBase.resetUpdateMan();
                return true;
            }
            case 50: {
                pSSysERMapNodeBase.resetUserCat();
                return true;
            }
            case 51: {
                pSSysERMapNodeBase.resetUserTag();
                return true;
            }
            case 52: {
                pSSysERMapNodeBase.resetUserTag2();
                return true;
            }
            case 53: {
                pSSysERMapNodeBase.resetUserTag3();
                return true;
            }
            case 54: {
                pSSysERMapNodeBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppLocalDE getPSAppLocalDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppLocalDE();
        }
        if (this.getPSAppLocalDEId() == null) {
            return null;
        }
        Integer n = this.objPSAppLocalDELock;
        synchronized (n) {
            if (this.psapplocalde != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppLocalDEId(), (Object)this.psapplocalde.getPSAppLocalDEId()) != 0L) {
                this.psapplocalde = null;
            }
            if (this.psapplocalde == null) {
                PSAppLocalDE pSAppLocalDE = new PSAppLocalDE();
                pSAppLocalDE.setPSAppLocalDEId(this.getPSAppLocalDEId());
                PSAppLocalDEService pSAppLocalDEService = (PSAppLocalDEService)ServiceGlobal.getService(PSAppLocalDEService.class, (SessionFactory)this.getSessionFactory());
                pSAppLocalDEService.autoGet(pSAppLocalDE);
                this.psapplocalde = pSAppLocalDE;
            }
            return this.psapplocalde;
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
    public PSDEServiceAPI getPSDEServiceAPI() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEServiceAPI();
        }
        if (this.getPSDEServiceAPIId() == null) {
            return null;
        }
        Integer n = this.objPSDEServiceAPILock;
        synchronized (n) {
            if (this.psdeserviceapi != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEServiceAPIId(), (Object)this.psdeserviceapi.getPSDEServiceAPIId()) != 0L) {
                this.psdeserviceapi = null;
            }
            if (this.psdeserviceapi == null) {
                PSDEServiceAPI pSDEServiceAPI = new PSDEServiceAPI();
                pSDEServiceAPI.setPSDEServiceAPIId(this.getPSDEServiceAPIId());
                PSDEServiceAPIService pSDEServiceAPIService = (PSDEServiceAPIService)ServiceGlobal.getService(PSDEServiceAPIService.class, (SessionFactory)this.getSessionFactory());
                pSDEServiceAPIService.autoGet(pSDEServiceAPI);
                this.psdeserviceapi = pSDEServiceAPI;
            }
            return this.psdeserviceapi;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSubSysSADE getPSSubSysSADE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysSADE();
        }
        if (this.getPSSubSysSADEId() == null) {
            return null;
        }
        Integer n = this.objPSSubSysSADELock;
        synchronized (n) {
            if (this.pssubsyssade != null && DataTypeHelper.compare((int)25, (Object)this.getPSSubSysSADEId(), (Object)this.pssubsyssade.getPSSubSysSADEId()) != 0L) {
                this.pssubsyssade = null;
            }
            if (this.pssubsyssade == null) {
                PSSubSysSADE pSSubSysSADE = new PSSubSysSADE();
                pSSubSysSADE.setPSSubSysSADEId(this.getPSSubSysSADEId());
                PSSubSysSADEService pSSubSysSADEService = (PSSubSysSADEService)ServiceGlobal.getService(PSSubSysSADEService.class, (SessionFactory)this.getSessionFactory());
                pSSubSysSADEService.autoGet(pSSubSysSADE);
                this.pssubsyssade = pSSubSysSADE;
            }
            return this.pssubsyssade;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSubSysServiceAPI getPSSubSysServiceAPI() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysServiceAPI();
        }
        if (this.getPSSubSysServiceAPIId() == null) {
            return null;
        }
        Integer n = this.objPSSubSysServiceAPILock;
        synchronized (n) {
            if (this.pssubsysserviceapi != null && DataTypeHelper.compare((int)25, (Object)this.getPSSubSysServiceAPIId(), (Object)this.pssubsysserviceapi.getPSSubSysServiceAPIId()) != 0L) {
                this.pssubsysserviceapi = null;
            }
            if (this.pssubsysserviceapi == null) {
                PSSubSysServiceAPI pSSubSysServiceAPI = new PSSubSysServiceAPI();
                pSSubSysServiceAPI.setPSSubSysServiceAPIId(this.getPSSubSysServiceAPIId());
                PSSubSysServiceAPIService pSSubSysServiceAPIService = (PSSubSysServiceAPIService)ServiceGlobal.getService(PSSubSysServiceAPIService.class, (SessionFactory)this.getSessionFactory());
                pSSubSysServiceAPIService.autoGet(pSSubSysServiceAPI);
                this.pssubsysserviceapi = pSSubSysServiceAPI;
            }
            return this.pssubsysserviceapi;
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
                pSSysAppService.autoGet(pSSysApp);
                this.pssysapp = pSSysApp;
            }
            return this.pssysapp;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBDScheme getPSSysBDScheme() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDScheme();
        }
        if (this.getPSSysBDSchemeId() == null) {
            return null;
        }
        Integer n = this.objPSSysBDSchemeLock;
        synchronized (n) {
            if (this.pssysbdscheme != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysBDSchemeId(), (Object)this.pssysbdscheme.getPSSysBDSchemeId()) != 0L) {
                this.pssysbdscheme = null;
            }
            if (this.pssysbdscheme == null) {
                PSSysBDScheme pSSysBDScheme = new PSSysBDScheme();
                pSSysBDScheme.setPSSysBDSchemeId(this.getPSSysBDSchemeId());
                PSSysBDSchemeService pSSysBDSchemeService = (PSSysBDSchemeService)ServiceGlobal.getService(PSSysBDSchemeService.class, (SessionFactory)this.getSessionFactory());
                pSSysBDSchemeService.autoGet(pSSysBDScheme);
                this.pssysbdscheme = pSSysBDScheme;
            }
            return this.pssysbdscheme;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBDTable getPSSysBDTable() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDTable();
        }
        if (this.getPSSysBDTableId() == null) {
            return null;
        }
        Integer n = this.objPSSysBDTableLock;
        synchronized (n) {
            if (this.pssysbdtable != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysBDTableId(), (Object)this.pssysbdtable.getPSSysBDTableId()) != 0L) {
                this.pssysbdtable = null;
            }
            if (this.pssysbdtable == null) {
                PSSysBDTable pSSysBDTable = new PSSysBDTable();
                pSSysBDTable.setPSSysBDTableId(this.getPSSysBDTableId());
                PSSysBDTableService pSSysBDTableService = (PSSysBDTableService)ServiceGlobal.getService(PSSysBDTableService.class, (SessionFactory)this.getSessionFactory());
                pSSysBDTableService.autoGet(pSSysBDTable);
                this.pssysbdtable = pSSysBDTable;
            }
            return this.pssysbdtable;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDBScheme getPSSysDBScheme() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBScheme();
        }
        if (this.getPSSysDBSchemeId() == null) {
            return null;
        }
        Integer n = this.objPSSysDBSchemeLock;
        synchronized (n) {
            if (this.pssysdbscheme != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDBSchemeId(), (Object)this.pssysdbscheme.getPSSysDBSchemeId()) != 0L) {
                this.pssysdbscheme = null;
            }
            if (this.pssysdbscheme == null) {
                PSSysDBScheme pSSysDBScheme = new PSSysDBScheme();
                pSSysDBScheme.setPSSysDBSchemeId(this.getPSSysDBSchemeId());
                PSSysDBSchemeService pSSysDBSchemeService = (PSSysDBSchemeService)ServiceGlobal.getService(PSSysDBSchemeService.class, (SessionFactory)this.getSessionFactory());
                pSSysDBSchemeService.autoGet(pSSysDBScheme);
                this.pssysdbscheme = pSSysDBScheme;
            }
            return this.pssysdbscheme;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDBTable getPSSysDBTable() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBTable();
        }
        if (this.getPSSysDBTableId() == null) {
            return null;
        }
        Integer n = this.objPSSysDBTableLock;
        synchronized (n) {
            if (this.pssysdbtable != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDBTableId(), (Object)this.pssysdbtable.getPSSysDBTableId()) != 0L) {
                this.pssysdbtable = null;
            }
            if (this.pssysdbtable == null) {
                PSSysDBTable pSSysDBTable = new PSSysDBTable();
                pSSysDBTable.setPSSysDBTableId(this.getPSSysDBTableId());
                PSSysDBTableService pSSysDBTableService = (PSSysDBTableService)ServiceGlobal.getService(PSSysDBTableService.class, (SessionFactory)this.getSessionFactory());
                pSSysDBTableService.autoGet(pSSysDBTable);
                this.pssysdbtable = pSSysDBTable;
            }
            return this.pssysdbtable;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDynaModel getRefPSSysDynaModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSSysDynaModel();
        }
        if (this.getRefPSSysDynaModelId() == null) {
            return null;
        }
        Integer n = this.objRefPSSysDynaModelLock;
        synchronized (n) {
            if (this.refpssysdynamodel != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSSysDynaModelId(), (Object)this.refpssysdynamodel.getPSSysDynaModelId()) != 0L) {
                this.refpssysdynamodel = null;
            }
            if (this.refpssysdynamodel == null) {
                PSSysDynaModel pSSysDynaModel = new PSSysDynaModel();
                pSSysDynaModel.setPSSysDynaModelId(this.getRefPSSysDynaModelId());
                PSSysDynaModelService pSSysDynaModelService = (PSSysDynaModelService)ServiceGlobal.getService(PSSysDynaModelService.class, (SessionFactory)this.getSessionFactory());
                pSSysDynaModelService.autoGet(pSSysDynaModel);
                this.refpssysdynamodel = pSSysDynaModel;
            }
            return this.refpssysdynamodel;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysERMap getPSSysERMap() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysERMap();
        }
        if (this.getPSSysERMapId() == null) {
            return null;
        }
        Integer n = this.objPSSysERMapLock;
        synchronized (n) {
            if (this.pssysermap != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysERMapId(), (Object)this.pssysermap.getPSSysERMapId()) != 0L) {
                this.pssysermap = null;
            }
            if (this.pssysermap == null) {
                PSSysERMap pSSysERMap = new PSSysERMap();
                pSSysERMap.setPSSysERMapId(this.getPSSysERMapId());
                PSSysERMapService pSSysERMapService = (PSSysERMapService)ServiceGlobal.getService(PSSysERMapService.class, (SessionFactory)this.getSessionFactory());
                pSSysERMapService.autoGet(pSSysERMap);
                this.pssysermap = pSSysERMap;
            }
            return this.pssysermap;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSearchDoc getPSSysSearchDoc() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchDoc();
        }
        if (this.getPSSysSearchDocId() == null) {
            return null;
        }
        Integer n = this.objPSSysSearchDocLock;
        synchronized (n) {
            if (this.pssyssearchdoc != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSearchDocId(), (Object)this.pssyssearchdoc.getPSSysSearchDocId()) != 0L) {
                this.pssyssearchdoc = null;
            }
            if (this.pssyssearchdoc == null) {
                PSSysSearchDoc pSSysSearchDoc = new PSSysSearchDoc();
                pSSysSearchDoc.setPSSysSearchDocId(this.getPSSysSearchDocId());
                PSSysSearchDocService pSSysSearchDocService = (PSSysSearchDocService)ServiceGlobal.getService(PSSysSearchDocService.class, (SessionFactory)this.getSessionFactory());
                pSSysSearchDocService.autoGet(pSSysSearchDoc);
                this.pssyssearchdoc = pSSysSearchDoc;
            }
            return this.pssyssearchdoc;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSearchScheme getPSSysSearchScheme() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchScheme();
        }
        if (this.getPSSysSearchSchemeId() == null) {
            return null;
        }
        Integer n = this.objPSSysSearchSchemeLock;
        synchronized (n) {
            if (this.pssyssearchscheme != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSearchSchemeId(), (Object)this.pssyssearchscheme.getPSSysSearchSchemeId()) != 0L) {
                this.pssyssearchscheme = null;
            }
            if (this.pssyssearchscheme == null) {
                PSSysSearchScheme pSSysSearchScheme = new PSSysSearchScheme();
                pSSysSearchScheme.setPSSysSearchSchemeId(this.getPSSysSearchSchemeId());
                PSSysSearchSchemeService pSSysSearchSchemeService = (PSSysSearchSchemeService)ServiceGlobal.getService(PSSysSearchSchemeService.class, (SessionFactory)this.getSessionFactory());
                pSSysSearchSchemeService.autoGet(pSSysSearchScheme);
                this.pssyssearchscheme = pSSysSearchScheme;
            }
            return this.pssyssearchscheme;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysServiceAPI getPSSysSerrviceAPI() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSerrviceAPI();
        }
        if (this.getPSSysServiceAPIId() == null) {
            return null;
        }
        Integer n = this.objPSSysSerrviceAPILock;
        synchronized (n) {
            if (this.pssysserrviceapi != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysServiceAPIId(), (Object)this.pssysserrviceapi.getPSSysServiceAPIId()) != 0L) {
                this.pssysserrviceapi = null;
            }
            if (this.pssysserrviceapi == null) {
                PSSysServiceAPI pSSysServiceAPI = new PSSysServiceAPI();
                pSSysServiceAPI.setPSSysServiceAPIId(this.getPSSysServiceAPIId());
                PSSysServiceAPIService pSSysServiceAPIService = (PSSysServiceAPIService)ServiceGlobal.getService(PSSysServiceAPIService.class, (SessionFactory)this.getSessionFactory());
                pSSysServiceAPIService.autoGet(pSSysServiceAPI);
                this.pssysserrviceapi = pSSysServiceAPI;
            }
            return this.pssysserrviceapi;
        }
    }

    private PSSysERMapNodeBase getProxyEntity() {
        return this.proxyPSSysERMapNodeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysERMapNodeBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysERMapNodeBase) {
            this.proxyPSSysERMapNodeBase = (PSSysERMapNodeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysERMapNodeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_COLOR, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DETAILMODE, 3);
        fieldIndexMap.put(FIELD_LEFTPOS, 4);
        fieldIndexMap.put(FIELD_LOGICNAME, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_MODCOLOR, 7);
        fieldIndexMap.put(FIELD_NODETAG, 8);
        fieldIndexMap.put(FIELD_NODETAG2, 9);
        fieldIndexMap.put(FIELD_NODETYPE, 10);
        fieldIndexMap.put(FIELD_PSAPPLOCALDEID, 11);
        fieldIndexMap.put(FIELD_PSAPPLOCALDENAME, 12);
        fieldIndexMap.put(FIELD_PSDEID, 13);
        fieldIndexMap.put(FIELD_PSDENAME, 14);
        fieldIndexMap.put(FIELD_PSDESERVICEAPIID, 15);
        fieldIndexMap.put(FIELD_PSDESERVICEAPINAME, 16);
        fieldIndexMap.put(FIELD_PSMODULEID, 17);
        fieldIndexMap.put(FIELD_PSMODULENAME, 18);
        fieldIndexMap.put(FIELD_PSSUBSYSSADEID, 19);
        fieldIndexMap.put(FIELD_PSSUBSYSSADENAME, 20);
        fieldIndexMap.put(FIELD_PSSUBSYSSERVICEAPIID, 21);
        fieldIndexMap.put(FIELD_PSSUBSYSSERVICEAPINAME, 22);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 23);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 24);
        fieldIndexMap.put(FIELD_PSSYSBDSCHEMEID, 25);
        fieldIndexMap.put(FIELD_PSSYSBDSCHEMENAME, 26);
        fieldIndexMap.put(FIELD_PSSYSBDTABLEID, 27);
        fieldIndexMap.put(FIELD_PSSYSBDTABLENAME, 28);
        fieldIndexMap.put(FIELD_PSSYSDBSCHEMEID, 29);
        fieldIndexMap.put(FIELD_PSSYSDBSCHEMENAME, 30);
        fieldIndexMap.put(FIELD_PSSYSDBTABLEID, 31);
        fieldIndexMap.put(FIELD_PSSYSDBTABLENAME, 32);
        fieldIndexMap.put(FIELD_PSSYSERMAPID, 33);
        fieldIndexMap.put(FIELD_PSSYSERMAPNAME, 34);
        fieldIndexMap.put(FIELD_PSSYSERMAPNODEID, 35);
        fieldIndexMap.put(FIELD_PSSYSERMAPNODENAME, 36);
        fieldIndexMap.put(FIELD_PSSYSSEARCHDOCID, 37);
        fieldIndexMap.put(FIELD_PSSYSSEARCHDOCNAME, 38);
        fieldIndexMap.put(FIELD_PSSYSSEARCHSCHEMEID, 39);
        fieldIndexMap.put(FIELD_PSSYSSEARCHSCHEMENAME, 40);
        fieldIndexMap.put(FIELD_PSSYSSERVICEAPIID, 41);
        fieldIndexMap.put(FIELD_PSSYSSERVICEAPINAME, 42);
        fieldIndexMap.put(FIELD_REFPSSYSDYNAMODELID, 43);
        fieldIndexMap.put(FIELD_REFPSSYSDYNAMODELNAME, 44);
        fieldIndexMap.put(FIELD_SHAPEPARAMS, 45);
        fieldIndexMap.put(FIELD_SHOWDEFIELDS, 46);
        fieldIndexMap.put(FIELD_TOPPOS, 47);
        fieldIndexMap.put(FIELD_UPDATEDATE, 48);
        fieldIndexMap.put(FIELD_UPDATEMAN, 49);
        fieldIndexMap.put(FIELD_USERCAT, 50);
        fieldIndexMap.put(FIELD_USERTAG, 51);
        fieldIndexMap.put(FIELD_USERTAG2, 52);
        fieldIndexMap.put(FIELD_USERTAG3, 53);
        fieldIndexMap.put(FIELD_USERTAG4, 54);
    }
}

