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
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEServiceAPI;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDESARSBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDESARSBase.class);
    public static final String FIELD_ACTIONRSMODE = "ACTIONRSMODE";
    public static final String FIELD_ARRAYFLAG = "ARRAYFLAG";
    public static final String FIELD_CHILDFILTER = "CHILDFILTER";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CODENAME2 = "CODENAME2";
    public static final String FIELD_CPSDEID = "CPSDEID";
    public static final String FIELD_CPSDESERVICEAPIID = "CPSDESERVICEAPIID";
    public static final String FIELD_CPSDESERVICEAPINAME = "CPSDESERVICEAPINAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DATAACCMODE = "DATAACCMODE";
    public static final String FIELD_DATARSMODE = "DATARSMODE";
    public static final String FIELD_ENABLEDATAEXPORT = "ENABLEDATAEXPORT";
    public static final String FIELD_ENABLEDATAIMPORT = "ENABLEDATAIMPORT";
    public static final String FIELD_ENABLEDEACTION = "ENABLEDEACTION";
    public static final String FIELD_ENABLEDEDATASET = "ENABLEDEDATASET";
    public static final String FIELD_ENABLESELECT = "ENABLESELECT";
    public static final String FIELD_EXPORTMODEL = "EXPORTMODEL";
    public static final String FIELD_EXPORTSCOPE = "EXPORTSCOPE";
    public static final String FIELD_EXPORTSCOPE2 = "EXPORTSCOPE2";
    public static final String FIELD_EXPORTSCOPE3 = "EXPORTSCOPE3";
    public static final String FIELD_EXPORTSCOPE4 = "EXPORTSCOPE4";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PPSDEID = "PPSDEID";
    public static final String FIELD_PPSDESERVICEAPIID = "PPSDESERVICEAPIID";
    public static final String FIELD_PPSDESERVICEAPINAME = "PPSDESERVICEAPINAME";
    public static final String FIELD_PSDERID = "PSDERID";
    public static final String FIELD_PSDERNAME = "PSDERNAME";
    public static final String FIELD_PSDESARSID = "PSDESARSID";
    public static final String FIELD_PSDESARSNAME = "PSDESARSNAME";
    public static final String FIELD_PSSYSSERVICEAPIID = "PSSYSSERVICEAPIID";
    public static final String FIELD_PSSYSSERVICEAPINAME = "PSSYSSERVICEAPINAME";
    public static final String FIELD_SYNCEXPORTMODEL = "SYNCEXPORTMODEL";
    public static final String FIELD_TEMPORDERVALUE = "TEMPORDERVALUE";
    public static final String FIELD_TYPEFILTER = "TYPEFILTER";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ACTIONRSMODE = 0;
    private static final int INDEX_ARRAYFLAG = 1;
    private static final int INDEX_CHILDFILTER = 2;
    private static final int INDEX_CODENAME = 3;
    private static final int INDEX_CODENAME2 = 4;
    private static final int INDEX_CPSDEID = 5;
    private static final int INDEX_CPSDESERVICEAPIID = 6;
    private static final int INDEX_CPSDESERVICEAPINAME = 7;
    private static final int INDEX_CREATEDATE = 8;
    private static final int INDEX_CREATEMAN = 9;
    private static final int INDEX_DATAACCMODE = 10;
    private static final int INDEX_DATARSMODE = 11;
    private static final int INDEX_ENABLEDATAEXPORT = 12;
    private static final int INDEX_ENABLEDATAIMPORT = 13;
    private static final int INDEX_ENABLEDEACTION = 14;
    private static final int INDEX_ENABLEDEDATASET = 15;
    private static final int INDEX_ENABLESELECT = 16;
    private static final int INDEX_EXPORTMODEL = 17;
    private static final int INDEX_EXPORTSCOPE = 18;
    private static final int INDEX_EXPORTSCOPE2 = 19;
    private static final int INDEX_EXPORTSCOPE3 = 20;
    private static final int INDEX_EXPORTSCOPE4 = 21;
    private static final int INDEX_MEMO = 22;
    private static final int INDEX_ORDERVALUE = 23;
    private static final int INDEX_PPSDEID = 24;
    private static final int INDEX_PPSDESERVICEAPIID = 25;
    private static final int INDEX_PPSDESERVICEAPINAME = 26;
    private static final int INDEX_PSDERID = 27;
    private static final int INDEX_PSDERNAME = 28;
    private static final int INDEX_PSDESARSID = 29;
    private static final int INDEX_PSDESARSNAME = 30;
    private static final int INDEX_PSSYSSERVICEAPIID = 31;
    private static final int INDEX_PSSYSSERVICEAPINAME = 32;
    private static final int INDEX_SYNCEXPORTMODEL = 33;
    private static final int INDEX_TEMPORDERVALUE = 34;
    private static final int INDEX_TYPEFILTER = 35;
    private static final int INDEX_UPDATEDATE = 36;
    private static final int INDEX_UPDATEMAN = 37;
    private static final int INDEX_USERCAT = 38;
    private static final int INDEX_USERTAG = 39;
    private static final int INDEX_USERTAG2 = 40;
    private static final int INDEX_USERTAG3 = 41;
    private static final int INDEX_USERTAG4 = 42;
    private static final int INDEX_VALIDFLAG = 43;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDESARSBase proxyPSDESARSBase = null;
    private boolean actionrsmodeDirtyFlag = false;
    private boolean arrayflagDirtyFlag = false;
    private boolean childfilterDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean codename2DirtyFlag = false;
    private boolean cpsdeidDirtyFlag = false;
    private boolean cpsdeserviceapiidDirtyFlag = false;
    private boolean cpsdeserviceapinameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dataaccmodeDirtyFlag = false;
    private boolean datarsmodeDirtyFlag = false;
    private boolean enabledataexportDirtyFlag = false;
    private boolean enabledataimportDirtyFlag = false;
    private boolean enabledeactionDirtyFlag = false;
    private boolean enablededatasetDirtyFlag = false;
    private boolean enableselectDirtyFlag = false;
    private boolean exportmodelDirtyFlag = false;
    private boolean exportscopeDirtyFlag = false;
    private boolean exportscope2DirtyFlag = false;
    private boolean exportscope3DirtyFlag = false;
    private boolean exportscope4DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean ppsdeidDirtyFlag = false;
    private boolean ppsdeserviceapiidDirtyFlag = false;
    private boolean ppsdeserviceapinameDirtyFlag = false;
    private boolean psderidDirtyFlag = false;
    private boolean psdernameDirtyFlag = false;
    private boolean psdesarsidDirtyFlag = false;
    private boolean psdesarsnameDirtyFlag = false;
    private boolean pssysserviceapiidDirtyFlag = false;
    private boolean pssysserviceapinameDirtyFlag = false;
    private boolean syncexportmodelDirtyFlag = false;
    private boolean tempordervalueDirtyFlag = false;
    private boolean typefilterDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="actionrsmode")
    private Integer actionrsmode;
    @Column(name="arrayflag")
    private Integer arrayflag;
    @Column(name="childfilter")
    private String childfilter;
    @Column(name="codename")
    private String codename;
    @Column(name="codename2")
    private String codename2;
    @Column(name="cpsdeid")
    private String cpsdeid;
    @Column(name="cpsdeserviceapiid")
    private String cpsdeserviceapiid;
    @Column(name="cpsdeserviceapiname")
    private String cpsdeserviceapiname;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dataaccmode")
    private Integer dataaccmode;
    @Column(name="datarsmode")
    private Integer datarsmode;
    @Column(name="enabledataexport")
    private Integer enabledataexport;
    @Column(name="enabledataimport")
    private Integer enabledataimport;
    @Column(name="enabledeaction")
    private Integer enabledeaction;
    @Column(name="enablededataset")
    private Integer enablededataset;
    @Column(name="enableselect")
    private Integer enableselect;
    @Column(name="exportmodel")
    private Integer exportmodel;
    @Column(name="exportscope")
    private Integer exportscope;
    @Column(name="exportscope2")
    private Integer exportscope2;
    @Column(name="exportscope3")
    private Integer exportscope3;
    @Column(name="exportscope4")
    private Integer exportscope4;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="ppsdeid")
    private String ppsdeid;
    @Column(name="ppsdeserviceapiid")
    private String ppsdeserviceapiid;
    @Column(name="ppsdeserviceapiname")
    private String ppsdeserviceapiname;
    @Column(name="psderid")
    private String psderid;
    @Column(name="psdername")
    private String psdername;
    @Column(name="psdesarsid")
    private String psdesarsid;
    @Column(name="psdesarsname")
    private String psdesarsname;
    @Column(name="pssysserviceapiid")
    private String pssysserviceapiid;
    @Column(name="pssysserviceapiname")
    private String pssysserviceapiname;
    @Column(name="syncexportmodel")
    private Integer syncexportmodel;
    @Column(name="tempordervalue")
    private Integer tempordervalue;
    @Column(name="typefilter")
    private String typefilter;
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
    private Integer objPSDERLock = new Integer(1);
    private PSDER psder = null;
    private Integer objCPSDEServiceAPILock = new Integer(1);
    private PSDEServiceAPI cpsdeserviceapi = null;
    private Integer objPPSDEServiceAPILock = new Integer(1);
    private PSDEServiceAPI ppsdeserviceapi = null;
    private Integer objPSSysServiceAPILock = new Integer(1);
    private PSSysServiceAPI pssysserviceapi = null;

    public void setActionRSMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionRSMode(n);
            return;
        }
        this.actionrsmode = n;
        this.actionrsmodeDirtyFlag = true;
    }

    public Integer getActionRSMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionRSMode();
        }
        return this.actionrsmode;
    }

    public boolean isActionRSModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionRSModeDirty();
        }
        return this.actionrsmodeDirtyFlag;
    }

    public void resetActionRSMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionRSMode();
            return;
        }
        this.actionrsmodeDirtyFlag = false;
        this.actionrsmode = null;
    }

    public void setArrayFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setArrayFlag(n);
            return;
        }
        this.arrayflag = n;
        this.arrayflagDirtyFlag = true;
    }

    public Integer getArrayFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getArrayFlag();
        }
        return this.arrayflag;
    }

    public boolean isArrayFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isArrayFlagDirty();
        }
        return this.arrayflagDirtyFlag;
    }

    public void resetArrayFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetArrayFlag();
            return;
        }
        this.arrayflagDirtyFlag = false;
        this.arrayflag = null;
    }

    public void setChildFilter(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setChildFilter(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.childfilter = string;
        this.childfilterDirtyFlag = true;
    }

    public String getChildFilter() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getChildFilter();
        }
        return this.childfilter;
    }

    public boolean isChildFilterDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isChildFilterDirty();
        }
        return this.childfilterDirtyFlag;
    }

    public void resetChildFilter() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetChildFilter();
            return;
        }
        this.childfilterDirtyFlag = false;
        this.childfilter = null;
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

    public void setCodeName2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename2 = string;
        this.codename2DirtyFlag = true;
    }

    public String getCodeName2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName2();
        }
        return this.codename2;
    }

    public boolean isCodeName2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeName2Dirty();
        }
        return this.codename2DirtyFlag;
    }

    public void resetCodeName2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName2();
            return;
        }
        this.codename2DirtyFlag = false;
        this.codename2 = null;
    }

    public void setCPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cpsdeid = string;
        this.cpsdeidDirtyFlag = true;
    }

    public String getCPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCPSDEId();
        }
        return this.cpsdeid;
    }

    public boolean isCPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCPSDEIdDirty();
        }
        return this.cpsdeidDirtyFlag;
    }

    public void resetCPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCPSDEId();
            return;
        }
        this.cpsdeidDirtyFlag = false;
        this.cpsdeid = null;
    }

    public void setCPSDEServiceAPIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCPSDEServiceAPIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cpsdeserviceapiid = string;
        this.cpsdeserviceapiidDirtyFlag = true;
    }

    public String getCPSDEServiceAPIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCPSDEServiceAPIId();
        }
        return this.cpsdeserviceapiid;
    }

    public boolean isCPSDEServiceAPIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCPSDEServiceAPIIdDirty();
        }
        return this.cpsdeserviceapiidDirtyFlag;
    }

    public void resetCPSDEServiceAPIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCPSDEServiceAPIId();
            return;
        }
        this.cpsdeserviceapiidDirtyFlag = false;
        this.cpsdeserviceapiid = null;
    }

    public void setCPSDEServiceAPIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCPSDEServiceAPIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cpsdeserviceapiname = string;
        this.cpsdeserviceapinameDirtyFlag = true;
    }

    public String getCPSDEServiceAPIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCPSDEServiceAPIName();
        }
        return this.cpsdeserviceapiname;
    }

    public boolean isCPSDEServiceAPINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCPSDEServiceAPINameDirty();
        }
        return this.cpsdeserviceapinameDirtyFlag;
    }

    public void resetCPSDEServiceAPIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCPSDEServiceAPIName();
            return;
        }
        this.cpsdeserviceapinameDirtyFlag = false;
        this.cpsdeserviceapiname = null;
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

    public void setDataAccMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataAccMode(n);
            return;
        }
        this.dataaccmode = n;
        this.dataaccmodeDirtyFlag = true;
    }

    public Integer getDataAccMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataAccMode();
        }
        return this.dataaccmode;
    }

    public boolean isDataAccModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataAccModeDirty();
        }
        return this.dataaccmodeDirtyFlag;
    }

    public void resetDataAccMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataAccMode();
            return;
        }
        this.dataaccmodeDirtyFlag = false;
        this.dataaccmode = null;
    }

    public void setDataRSMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataRSMode(n);
            return;
        }
        this.datarsmode = n;
        this.datarsmodeDirtyFlag = true;
    }

    public Integer getDataRSMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataRSMode();
        }
        return this.datarsmode;
    }

    public boolean isDataRSModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataRSModeDirty();
        }
        return this.datarsmodeDirtyFlag;
    }

    public void resetDataRSMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataRSMode();
            return;
        }
        this.datarsmodeDirtyFlag = false;
        this.datarsmode = null;
    }

    public void setEnableDataExport(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableDataExport(n);
            return;
        }
        this.enabledataexport = n;
        this.enabledataexportDirtyFlag = true;
    }

    public Integer getEnableDataExport() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableDataExport();
        }
        return this.enabledataexport;
    }

    public boolean isEnableDataExportDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDataExportDirty();
        }
        return this.enabledataexportDirtyFlag;
    }

    public void resetEnableDataExport() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableDataExport();
            return;
        }
        this.enabledataexportDirtyFlag = false;
        this.enabledataexport = null;
    }

    public void setEnableDataImport(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableDataImport(n);
            return;
        }
        this.enabledataimport = n;
        this.enabledataimportDirtyFlag = true;
    }

    public Integer getEnableDataImport() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableDataImport();
        }
        return this.enabledataimport;
    }

    public boolean isEnableDataImportDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDataImportDirty();
        }
        return this.enabledataimportDirtyFlag;
    }

    public void resetEnableDataImport() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableDataImport();
            return;
        }
        this.enabledataimportDirtyFlag = false;
        this.enabledataimport = null;
    }

    public void setEnableDEAction(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableDEAction(n);
            return;
        }
        this.enabledeaction = n;
        this.enabledeactionDirtyFlag = true;
    }

    public Integer getEnableDEAction() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableDEAction();
        }
        return this.enabledeaction;
    }

    public boolean isEnableDEActionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDEActionDirty();
        }
        return this.enabledeactionDirtyFlag;
    }

    public void resetEnableDEAction() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableDEAction();
            return;
        }
        this.enabledeactionDirtyFlag = false;
        this.enabledeaction = null;
    }

    public void setEnableDEDataSet(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableDEDataSet(n);
            return;
        }
        this.enablededataset = n;
        this.enablededatasetDirtyFlag = true;
    }

    public Integer getEnableDEDataSet() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableDEDataSet();
        }
        return this.enablededataset;
    }

    public boolean isEnableDEDataSetDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDEDataSetDirty();
        }
        return this.enablededatasetDirtyFlag;
    }

    public void resetEnableDEDataSet() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableDEDataSet();
            return;
        }
        this.enablededatasetDirtyFlag = false;
        this.enablededataset = null;
    }

    public void setEnableSelect(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableSelect(n);
            return;
        }
        this.enableselect = n;
        this.enableselectDirtyFlag = true;
    }

    public Integer getEnableSelect() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableSelect();
        }
        return this.enableselect;
    }

    public boolean isEnableSelectDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableSelectDirty();
        }
        return this.enableselectDirtyFlag;
    }

    public void resetEnableSelect() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableSelect();
            return;
        }
        this.enableselectDirtyFlag = false;
        this.enableselect = null;
    }

    public void setExportModel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExportModel(n);
            return;
        }
        this.exportmodel = n;
        this.exportmodelDirtyFlag = true;
    }

    public Integer getExportModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExportModel();
        }
        return this.exportmodel;
    }

    public boolean isExportModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExportModelDirty();
        }
        return this.exportmodelDirtyFlag;
    }

    public void resetExportModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExportModel();
            return;
        }
        this.exportmodelDirtyFlag = false;
        this.exportmodel = null;
    }

    public void setExportScope(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExportScope(n);
            return;
        }
        this.exportscope = n;
        this.exportscopeDirtyFlag = true;
    }

    public Integer getExportScope() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExportScope();
        }
        return this.exportscope;
    }

    public boolean isExportScopeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExportScopeDirty();
        }
        return this.exportscopeDirtyFlag;
    }

    public void resetExportScope() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExportScope();
            return;
        }
        this.exportscopeDirtyFlag = false;
        this.exportscope = null;
    }

    public void setExportScope2(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExportScope2(n);
            return;
        }
        this.exportscope2 = n;
        this.exportscope2DirtyFlag = true;
    }

    public Integer getExportScope2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExportScope2();
        }
        return this.exportscope2;
    }

    public boolean isExportScope2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExportScope2Dirty();
        }
        return this.exportscope2DirtyFlag;
    }

    public void resetExportScope2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExportScope2();
            return;
        }
        this.exportscope2DirtyFlag = false;
        this.exportscope2 = null;
    }

    public void setExportScope3(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExportScope3(n);
            return;
        }
        this.exportscope3 = n;
        this.exportscope3DirtyFlag = true;
    }

    public Integer getExportScope3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExportScope3();
        }
        return this.exportscope3;
    }

    public boolean isExportScope3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExportScope3Dirty();
        }
        return this.exportscope3DirtyFlag;
    }

    public void resetExportScope3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExportScope3();
            return;
        }
        this.exportscope3DirtyFlag = false;
        this.exportscope3 = null;
    }

    public void setExportScope4(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExportScope4(n);
            return;
        }
        this.exportscope4 = n;
        this.exportscope4DirtyFlag = true;
    }

    public Integer getExportScope4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExportScope4();
        }
        return this.exportscope4;
    }

    public boolean isExportScope4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExportScope4Dirty();
        }
        return this.exportscope4DirtyFlag;
    }

    public void resetExportScope4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExportScope4();
            return;
        }
        this.exportscope4DirtyFlag = false;
        this.exportscope4 = null;
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

    public void setPPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdeid = string;
        this.ppsdeidDirtyFlag = true;
    }

    public String getPPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDEId();
        }
        return this.ppsdeid;
    }

    public boolean isPPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDEIdDirty();
        }
        return this.ppsdeidDirtyFlag;
    }

    public void resetPPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDEId();
            return;
        }
        this.ppsdeidDirtyFlag = false;
        this.ppsdeid = null;
    }

    public void setPPSDEServiceAPIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDEServiceAPIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdeserviceapiid = string;
        this.ppsdeserviceapiidDirtyFlag = true;
    }

    public String getPPSDEServiceAPIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDEServiceAPIId();
        }
        return this.ppsdeserviceapiid;
    }

    public boolean isPPSDEServiceAPIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDEServiceAPIIdDirty();
        }
        return this.ppsdeserviceapiidDirtyFlag;
    }

    public void resetPPSDEServiceAPIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDEServiceAPIId();
            return;
        }
        this.ppsdeserviceapiidDirtyFlag = false;
        this.ppsdeserviceapiid = null;
    }

    public void setPPSDEServiceAPIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDEServiceAPIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdeserviceapiname = string;
        this.ppsdeserviceapinameDirtyFlag = true;
    }

    public String getPPSDEServiceAPIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDEServiceAPIName();
        }
        return this.ppsdeserviceapiname;
    }

    public boolean isPPSDEServiceAPINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDEServiceAPINameDirty();
        }
        return this.ppsdeserviceapinameDirtyFlag;
    }

    public void resetPPSDEServiceAPIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDEServiceAPIName();
            return;
        }
        this.ppsdeserviceapinameDirtyFlag = false;
        this.ppsdeserviceapiname = null;
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

    public void setPSDESARSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDESARSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdesarsid = string;
        this.psdesarsidDirtyFlag = true;
    }

    public String getPSDESARSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESARSId();
        }
        return this.psdesarsid;
    }

    public boolean isPSDESARSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDESARSIdDirty();
        }
        return this.psdesarsidDirtyFlag;
    }

    public void resetPSDESARSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDESARSId();
            return;
        }
        this.psdesarsidDirtyFlag = false;
        this.psdesarsid = null;
    }

    public void setPSDESARSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDESARSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdesarsname = string;
        this.psdesarsnameDirtyFlag = true;
    }

    public String getPSDESARSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESARSName();
        }
        return this.psdesarsname;
    }

    public boolean isPSDESARSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDESARSNameDirty();
        }
        return this.psdesarsnameDirtyFlag;
    }

    public void resetPSDESARSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDESARSName();
            return;
        }
        this.psdesarsnameDirtyFlag = false;
        this.psdesarsname = null;
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

    public void setSyncExportModel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSyncExportModel(n);
            return;
        }
        this.syncexportmodel = n;
        this.syncexportmodelDirtyFlag = true;
    }

    public Integer getSyncExportModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSyncExportModel();
        }
        return this.syncexportmodel;
    }

    public boolean isSyncExportModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSyncExportModelDirty();
        }
        return this.syncexportmodelDirtyFlag;
    }

    public void resetSyncExportModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSyncExportModel();
            return;
        }
        this.syncexportmodelDirtyFlag = false;
        this.syncexportmodel = null;
    }

    public void setTempOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTempOrderValue(n);
            return;
        }
        this.tempordervalue = n;
        this.tempordervalueDirtyFlag = true;
    }

    public Integer getTempOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTempOrderValue();
        }
        return this.tempordervalue;
    }

    public boolean isTempOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTempOrderValueDirty();
        }
        return this.tempordervalueDirtyFlag;
    }

    public void resetTempOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTempOrderValue();
            return;
        }
        this.tempordervalueDirtyFlag = false;
        this.tempordervalue = null;
    }

    public void setTypeFilter(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeFilter(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typefilter = string;
        this.typefilterDirtyFlag = true;
    }

    public String getTypeFilter() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeFilter();
        }
        return this.typefilter;
    }

    public boolean isTypeFilterDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeFilterDirty();
        }
        return this.typefilterDirtyFlag;
    }

    public void resetTypeFilter() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeFilter();
            return;
        }
        this.typefilterDirtyFlag = false;
        this.typefilter = null;
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

    protected void onReset() {
        PSDESARSBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDESARSBase pSDESARSBase) {
        pSDESARSBase.resetActionRSMode();
        pSDESARSBase.resetArrayFlag();
        pSDESARSBase.resetChildFilter();
        pSDESARSBase.resetCodeName();
        pSDESARSBase.resetCodeName2();
        pSDESARSBase.resetCPSDEId();
        pSDESARSBase.resetCPSDEServiceAPIId();
        pSDESARSBase.resetCPSDEServiceAPIName();
        pSDESARSBase.resetCreateDate();
        pSDESARSBase.resetCreateMan();
        pSDESARSBase.resetDataAccMode();
        pSDESARSBase.resetDataRSMode();
        pSDESARSBase.resetEnableDataExport();
        pSDESARSBase.resetEnableDataImport();
        pSDESARSBase.resetEnableDEAction();
        pSDESARSBase.resetEnableDEDataSet();
        pSDESARSBase.resetEnableSelect();
        pSDESARSBase.resetExportModel();
        pSDESARSBase.resetExportScope();
        pSDESARSBase.resetExportScope2();
        pSDESARSBase.resetExportScope3();
        pSDESARSBase.resetExportScope4();
        pSDESARSBase.resetMemo();
        pSDESARSBase.resetOrderValue();
        pSDESARSBase.resetPPSDEId();
        pSDESARSBase.resetPPSDEServiceAPIId();
        pSDESARSBase.resetPPSDEServiceAPIName();
        pSDESARSBase.resetPSDERId();
        pSDESARSBase.resetPSDERName();
        pSDESARSBase.resetPSDESARSId();
        pSDESARSBase.resetPSDESARSName();
        pSDESARSBase.resetPSSysServiceAPIId();
        pSDESARSBase.resetPSSysServiceAPIName();
        pSDESARSBase.resetSyncExportModel();
        pSDESARSBase.resetTempOrderValue();
        pSDESARSBase.resetTypeFilter();
        pSDESARSBase.resetUpdateDate();
        pSDESARSBase.resetUpdateMan();
        pSDESARSBase.resetUserCat();
        pSDESARSBase.resetUserTag();
        pSDESARSBase.resetUserTag2();
        pSDESARSBase.resetUserTag3();
        pSDESARSBase.resetUserTag4();
        pSDESARSBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isActionRSModeDirty()) {
            hashMap.put(FIELD_ACTIONRSMODE, this.getActionRSMode());
        }
        if (!bl || this.isArrayFlagDirty()) {
            hashMap.put(FIELD_ARRAYFLAG, this.getArrayFlag());
        }
        if (!bl || this.isChildFilterDirty()) {
            hashMap.put(FIELD_CHILDFILTER, this.getChildFilter());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCodeName2Dirty()) {
            hashMap.put(FIELD_CODENAME2, this.getCodeName2());
        }
        if (!bl || this.isCPSDEIdDirty()) {
            hashMap.put(FIELD_CPSDEID, this.getCPSDEId());
        }
        if (!bl || this.isCPSDEServiceAPIIdDirty()) {
            hashMap.put(FIELD_CPSDESERVICEAPIID, this.getCPSDEServiceAPIId());
        }
        if (!bl || this.isCPSDEServiceAPINameDirty()) {
            hashMap.put(FIELD_CPSDESERVICEAPINAME, this.getCPSDEServiceAPIName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDataAccModeDirty()) {
            hashMap.put(FIELD_DATAACCMODE, this.getDataAccMode());
        }
        if (!bl || this.isDataRSModeDirty()) {
            hashMap.put(FIELD_DATARSMODE, this.getDataRSMode());
        }
        if (!bl || this.isEnableDataExportDirty()) {
            hashMap.put(FIELD_ENABLEDATAEXPORT, this.getEnableDataExport());
        }
        if (!bl || this.isEnableDataImportDirty()) {
            hashMap.put(FIELD_ENABLEDATAIMPORT, this.getEnableDataImport());
        }
        if (!bl || this.isEnableDEActionDirty()) {
            hashMap.put(FIELD_ENABLEDEACTION, this.getEnableDEAction());
        }
        if (!bl || this.isEnableDEDataSetDirty()) {
            hashMap.put(FIELD_ENABLEDEDATASET, this.getEnableDEDataSet());
        }
        if (!bl || this.isEnableSelectDirty()) {
            hashMap.put(FIELD_ENABLESELECT, this.getEnableSelect());
        }
        if (!bl || this.isExportModelDirty()) {
            hashMap.put(FIELD_EXPORTMODEL, this.getExportModel());
        }
        if (!bl || this.isExportScopeDirty()) {
            hashMap.put(FIELD_EXPORTSCOPE, this.getExportScope());
        }
        if (!bl || this.isExportScope2Dirty()) {
            hashMap.put(FIELD_EXPORTSCOPE2, this.getExportScope2());
        }
        if (!bl || this.isExportScope3Dirty()) {
            hashMap.put(FIELD_EXPORTSCOPE3, this.getExportScope3());
        }
        if (!bl || this.isExportScope4Dirty()) {
            hashMap.put(FIELD_EXPORTSCOPE4, this.getExportScope4());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPPSDEIdDirty()) {
            hashMap.put(FIELD_PPSDEID, this.getPPSDEId());
        }
        if (!bl || this.isPPSDEServiceAPIIdDirty()) {
            hashMap.put(FIELD_PPSDESERVICEAPIID, this.getPPSDEServiceAPIId());
        }
        if (!bl || this.isPPSDEServiceAPINameDirty()) {
            hashMap.put(FIELD_PPSDESERVICEAPINAME, this.getPPSDEServiceAPIName());
        }
        if (!bl || this.isPSDERIdDirty()) {
            hashMap.put(FIELD_PSDERID, this.getPSDERId());
        }
        if (!bl || this.isPSDERNameDirty()) {
            hashMap.put(FIELD_PSDERNAME, this.getPSDERName());
        }
        if (!bl || this.isPSDESARSIdDirty()) {
            hashMap.put(FIELD_PSDESARSID, this.getPSDESARSId());
        }
        if (!bl || this.isPSDESARSNameDirty()) {
            hashMap.put(FIELD_PSDESARSNAME, this.getPSDESARSName());
        }
        if (!bl || this.isPSSysServiceAPIIdDirty()) {
            hashMap.put(FIELD_PSSYSSERVICEAPIID, this.getPSSysServiceAPIId());
        }
        if (!bl || this.isPSSysServiceAPINameDirty()) {
            hashMap.put(FIELD_PSSYSSERVICEAPINAME, this.getPSSysServiceAPIName());
        }
        if (!bl || this.isSyncExportModelDirty()) {
            hashMap.put(FIELD_SYNCEXPORTMODEL, this.getSyncExportModel());
        }
        if (!bl || this.isTempOrderValueDirty()) {
            hashMap.put(FIELD_TEMPORDERVALUE, this.getTempOrderValue());
        }
        if (!bl || this.isTypeFilterDirty()) {
            hashMap.put(FIELD_TYPEFILTER, this.getTypeFilter());
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
        return PSDESARSBase.get(this, n);
    }

    private static Object get(PSDESARSBase pSDESARSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDESARSBase.getActionRSMode();
            }
            case 1: {
                return pSDESARSBase.getArrayFlag();
            }
            case 2: {
                return pSDESARSBase.getChildFilter();
            }
            case 3: {
                return pSDESARSBase.getCodeName();
            }
            case 4: {
                return pSDESARSBase.getCodeName2();
            }
            case 5: {
                return pSDESARSBase.getCPSDEId();
            }
            case 6: {
                return pSDESARSBase.getCPSDEServiceAPIId();
            }
            case 7: {
                return pSDESARSBase.getCPSDEServiceAPIName();
            }
            case 8: {
                return pSDESARSBase.getCreateDate();
            }
            case 9: {
                return pSDESARSBase.getCreateMan();
            }
            case 10: {
                return pSDESARSBase.getDataAccMode();
            }
            case 11: {
                return pSDESARSBase.getDataRSMode();
            }
            case 12: {
                return pSDESARSBase.getEnableDataExport();
            }
            case 13: {
                return pSDESARSBase.getEnableDataImport();
            }
            case 14: {
                return pSDESARSBase.getEnableDEAction();
            }
            case 15: {
                return pSDESARSBase.getEnableDEDataSet();
            }
            case 16: {
                return pSDESARSBase.getEnableSelect();
            }
            case 17: {
                return pSDESARSBase.getExportModel();
            }
            case 18: {
                return pSDESARSBase.getExportScope();
            }
            case 19: {
                return pSDESARSBase.getExportScope2();
            }
            case 20: {
                return pSDESARSBase.getExportScope3();
            }
            case 21: {
                return pSDESARSBase.getExportScope4();
            }
            case 22: {
                return pSDESARSBase.getMemo();
            }
            case 23: {
                return pSDESARSBase.getOrderValue();
            }
            case 24: {
                return pSDESARSBase.getPPSDEId();
            }
            case 25: {
                return pSDESARSBase.getPPSDEServiceAPIId();
            }
            case 26: {
                return pSDESARSBase.getPPSDEServiceAPIName();
            }
            case 27: {
                return pSDESARSBase.getPSDERId();
            }
            case 28: {
                return pSDESARSBase.getPSDERName();
            }
            case 29: {
                return pSDESARSBase.getPSDESARSId();
            }
            case 30: {
                return pSDESARSBase.getPSDESARSName();
            }
            case 31: {
                return pSDESARSBase.getPSSysServiceAPIId();
            }
            case 32: {
                return pSDESARSBase.getPSSysServiceAPIName();
            }
            case 33: {
                return pSDESARSBase.getSyncExportModel();
            }
            case 34: {
                return pSDESARSBase.getTempOrderValue();
            }
            case 35: {
                return pSDESARSBase.getTypeFilter();
            }
            case 36: {
                return pSDESARSBase.getUpdateDate();
            }
            case 37: {
                return pSDESARSBase.getUpdateMan();
            }
            case 38: {
                return pSDESARSBase.getUserCat();
            }
            case 39: {
                return pSDESARSBase.getUserTag();
            }
            case 40: {
                return pSDESARSBase.getUserTag2();
            }
            case 41: {
                return pSDESARSBase.getUserTag3();
            }
            case 42: {
                return pSDESARSBase.getUserTag4();
            }
            case 43: {
                return pSDESARSBase.getValidFlag();
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
        PSDESARSBase.set(this, n, object);
    }

    private static void set(PSDESARSBase pSDESARSBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDESARSBase.setActionRSMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDESARSBase.setArrayFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSDESARSBase.setChildFilter(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDESARSBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDESARSBase.setCodeName2(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDESARSBase.setCPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDESARSBase.setCPSDEServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDESARSBase.setCPSDEServiceAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDESARSBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSDESARSBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDESARSBase.setDataAccMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSDESARSBase.setDataRSMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDESARSBase.setEnableDataExport(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDESARSBase.setEnableDataImport(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSDESARSBase.setEnableDEAction(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSDESARSBase.setEnableDEDataSet(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSDESARSBase.setEnableSelect(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSDESARSBase.setExportModel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSDESARSBase.setExportScope(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSDESARSBase.setExportScope2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSDESARSBase.setExportScope3(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSDESARSBase.setExportScope4(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSDESARSBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDESARSBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSDESARSBase.setPPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDESARSBase.setPPSDEServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDESARSBase.setPPSDEServiceAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDESARSBase.setPSDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDESARSBase.setPSDERName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDESARSBase.setPSDESARSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDESARSBase.setPSDESARSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDESARSBase.setPSSysServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDESARSBase.setPSSysServiceAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDESARSBase.setSyncExportModel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 34: {
                pSDESARSBase.setTempOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 35: {
                pSDESARSBase.setTypeFilter(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDESARSBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 37: {
                pSDESARSBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDESARSBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDESARSBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDESARSBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDESARSBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDESARSBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDESARSBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDESARSBase.isNull(this, n);
    }

    private static boolean isNull(PSDESARSBase pSDESARSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDESARSBase.getActionRSMode() == null;
            }
            case 1: {
                return pSDESARSBase.getArrayFlag() == null;
            }
            case 2: {
                return pSDESARSBase.getChildFilter() == null;
            }
            case 3: {
                return pSDESARSBase.getCodeName() == null;
            }
            case 4: {
                return pSDESARSBase.getCodeName2() == null;
            }
            case 5: {
                return pSDESARSBase.getCPSDEId() == null;
            }
            case 6: {
                return pSDESARSBase.getCPSDEServiceAPIId() == null;
            }
            case 7: {
                return pSDESARSBase.getCPSDEServiceAPIName() == null;
            }
            case 8: {
                return pSDESARSBase.getCreateDate() == null;
            }
            case 9: {
                return pSDESARSBase.getCreateMan() == null;
            }
            case 10: {
                return pSDESARSBase.getDataAccMode() == null;
            }
            case 11: {
                return pSDESARSBase.getDataRSMode() == null;
            }
            case 12: {
                return pSDESARSBase.getEnableDataExport() == null;
            }
            case 13: {
                return pSDESARSBase.getEnableDataImport() == null;
            }
            case 14: {
                return pSDESARSBase.getEnableDEAction() == null;
            }
            case 15: {
                return pSDESARSBase.getEnableDEDataSet() == null;
            }
            case 16: {
                return pSDESARSBase.getEnableSelect() == null;
            }
            case 17: {
                return pSDESARSBase.getExportModel() == null;
            }
            case 18: {
                return pSDESARSBase.getExportScope() == null;
            }
            case 19: {
                return pSDESARSBase.getExportScope2() == null;
            }
            case 20: {
                return pSDESARSBase.getExportScope3() == null;
            }
            case 21: {
                return pSDESARSBase.getExportScope4() == null;
            }
            case 22: {
                return pSDESARSBase.getMemo() == null;
            }
            case 23: {
                return pSDESARSBase.getOrderValue() == null;
            }
            case 24: {
                return pSDESARSBase.getPPSDEId() == null;
            }
            case 25: {
                return pSDESARSBase.getPPSDEServiceAPIId() == null;
            }
            case 26: {
                return pSDESARSBase.getPPSDEServiceAPIName() == null;
            }
            case 27: {
                return pSDESARSBase.getPSDERId() == null;
            }
            case 28: {
                return pSDESARSBase.getPSDERName() == null;
            }
            case 29: {
                return pSDESARSBase.getPSDESARSId() == null;
            }
            case 30: {
                return pSDESARSBase.getPSDESARSName() == null;
            }
            case 31: {
                return pSDESARSBase.getPSSysServiceAPIId() == null;
            }
            case 32: {
                return pSDESARSBase.getPSSysServiceAPIName() == null;
            }
            case 33: {
                return pSDESARSBase.getSyncExportModel() == null;
            }
            case 34: {
                return pSDESARSBase.getTempOrderValue() == null;
            }
            case 35: {
                return pSDESARSBase.getTypeFilter() == null;
            }
            case 36: {
                return pSDESARSBase.getUpdateDate() == null;
            }
            case 37: {
                return pSDESARSBase.getUpdateMan() == null;
            }
            case 38: {
                return pSDESARSBase.getUserCat() == null;
            }
            case 39: {
                return pSDESARSBase.getUserTag() == null;
            }
            case 40: {
                return pSDESARSBase.getUserTag2() == null;
            }
            case 41: {
                return pSDESARSBase.getUserTag3() == null;
            }
            case 42: {
                return pSDESARSBase.getUserTag4() == null;
            }
            case 43: {
                return pSDESARSBase.getValidFlag() == null;
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
        return PSDESARSBase.contains(this, n);
    }

    private static boolean contains(PSDESARSBase pSDESARSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDESARSBase.isActionRSModeDirty();
            }
            case 1: {
                return pSDESARSBase.isArrayFlagDirty();
            }
            case 2: {
                return pSDESARSBase.isChildFilterDirty();
            }
            case 3: {
                return pSDESARSBase.isCodeNameDirty();
            }
            case 4: {
                return pSDESARSBase.isCodeName2Dirty();
            }
            case 5: {
                return pSDESARSBase.isCPSDEIdDirty();
            }
            case 6: {
                return pSDESARSBase.isCPSDEServiceAPIIdDirty();
            }
            case 7: {
                return pSDESARSBase.isCPSDEServiceAPINameDirty();
            }
            case 8: {
                return pSDESARSBase.isCreateDateDirty();
            }
            case 9: {
                return pSDESARSBase.isCreateManDirty();
            }
            case 10: {
                return pSDESARSBase.isDataAccModeDirty();
            }
            case 11: {
                return pSDESARSBase.isDataRSModeDirty();
            }
            case 12: {
                return pSDESARSBase.isEnableDataExportDirty();
            }
            case 13: {
                return pSDESARSBase.isEnableDataImportDirty();
            }
            case 14: {
                return pSDESARSBase.isEnableDEActionDirty();
            }
            case 15: {
                return pSDESARSBase.isEnableDEDataSetDirty();
            }
            case 16: {
                return pSDESARSBase.isEnableSelectDirty();
            }
            case 17: {
                return pSDESARSBase.isExportModelDirty();
            }
            case 18: {
                return pSDESARSBase.isExportScopeDirty();
            }
            case 19: {
                return pSDESARSBase.isExportScope2Dirty();
            }
            case 20: {
                return pSDESARSBase.isExportScope3Dirty();
            }
            case 21: {
                return pSDESARSBase.isExportScope4Dirty();
            }
            case 22: {
                return pSDESARSBase.isMemoDirty();
            }
            case 23: {
                return pSDESARSBase.isOrderValueDirty();
            }
            case 24: {
                return pSDESARSBase.isPPSDEIdDirty();
            }
            case 25: {
                return pSDESARSBase.isPPSDEServiceAPIIdDirty();
            }
            case 26: {
                return pSDESARSBase.isPPSDEServiceAPINameDirty();
            }
            case 27: {
                return pSDESARSBase.isPSDERIdDirty();
            }
            case 28: {
                return pSDESARSBase.isPSDERNameDirty();
            }
            case 29: {
                return pSDESARSBase.isPSDESARSIdDirty();
            }
            case 30: {
                return pSDESARSBase.isPSDESARSNameDirty();
            }
            case 31: {
                return pSDESARSBase.isPSSysServiceAPIIdDirty();
            }
            case 32: {
                return pSDESARSBase.isPSSysServiceAPINameDirty();
            }
            case 33: {
                return pSDESARSBase.isSyncExportModelDirty();
            }
            case 34: {
                return pSDESARSBase.isTempOrderValueDirty();
            }
            case 35: {
                return pSDESARSBase.isTypeFilterDirty();
            }
            case 36: {
                return pSDESARSBase.isUpdateDateDirty();
            }
            case 37: {
                return pSDESARSBase.isUpdateManDirty();
            }
            case 38: {
                return pSDESARSBase.isUserCatDirty();
            }
            case 39: {
                return pSDESARSBase.isUserTagDirty();
            }
            case 40: {
                return pSDESARSBase.isUserTag2Dirty();
            }
            case 41: {
                return pSDESARSBase.isUserTag3Dirty();
            }
            case 42: {
                return pSDESARSBase.isUserTag4Dirty();
            }
            case 43: {
                return pSDESARSBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDESARSBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDESARSBase pSDESARSBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDESARSBase.getActionRSMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionrsmode", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getActionRSMode()), (boolean)false);
        }
        if (bl || pSDESARSBase.getArrayFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"arrayflag", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getArrayFlag()), (boolean)false);
        }
        if (bl || pSDESARSBase.getChildFilter() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"childfilter", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getChildFilter()), (boolean)false);
        }
        if (bl || pSDESARSBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDESARSBase.getCodeName2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename2", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getCodeName2()), (boolean)false);
        }
        if (bl || pSDESARSBase.getCPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cpsdeid", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getCPSDEId()), (boolean)false);
        }
        if (bl || pSDESARSBase.getCPSDEServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cpsdeserviceapiid", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getCPSDEServiceAPIId()), (boolean)false);
        }
        if (bl || pSDESARSBase.getCPSDEServiceAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cpsdeserviceapiname", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getCPSDEServiceAPIName()), (boolean)false);
        }
        if (bl || pSDESARSBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDESARSBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDESARSBase.getDataAccMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dataaccmode", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getDataAccMode()), (boolean)false);
        }
        if (bl || pSDESARSBase.getDataRSMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"datarsmode", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getDataRSMode()), (boolean)false);
        }
        if (bl || pSDESARSBase.getEnableDataExport() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enabledataexport", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getEnableDataExport()), (boolean)false);
        }
        if (bl || pSDESARSBase.getEnableDataImport() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enabledataimport", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getEnableDataImport()), (boolean)false);
        }
        if (bl || pSDESARSBase.getEnableDEAction() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enabledeaction", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getEnableDEAction()), (boolean)false);
        }
        if (bl || pSDESARSBase.getEnableDEDataSet() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablededataset", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getEnableDEDataSet()), (boolean)false);
        }
        if (bl || pSDESARSBase.getEnableSelect() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableselect", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getEnableSelect()), (boolean)false);
        }
        if (bl || pSDESARSBase.getExportModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exportmodel", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getExportModel()), (boolean)false);
        }
        if (bl || pSDESARSBase.getExportScope() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exportscope", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getExportScope()), (boolean)false);
        }
        if (bl || pSDESARSBase.getExportScope2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exportscope2", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getExportScope2()), (boolean)false);
        }
        if (bl || pSDESARSBase.getExportScope3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exportscope3", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getExportScope3()), (boolean)false);
        }
        if (bl || pSDESARSBase.getExportScope4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exportscope4", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getExportScope4()), (boolean)false);
        }
        if (bl || pSDESARSBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getMemo()), (boolean)false);
        }
        if (bl || pSDESARSBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDESARSBase.getPPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdeid", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getPPSDEId()), (boolean)false);
        }
        if (bl || pSDESARSBase.getPPSDEServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdeserviceapiid", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getPPSDEServiceAPIId()), (boolean)false);
        }
        if (bl || pSDESARSBase.getPPSDEServiceAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdeserviceapiname", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getPPSDEServiceAPIName()), (boolean)false);
        }
        if (bl || pSDESARSBase.getPSDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psderid", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getPSDERId()), (boolean)false);
        }
        if (bl || pSDESARSBase.getPSDERName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdername", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getPSDERName()), (boolean)false);
        }
        if (bl || pSDESARSBase.getPSDESARSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdesarsid", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getPSDESARSId()), (boolean)false);
        }
        if (bl || pSDESARSBase.getPSDESARSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdesarsname", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getPSDESARSName()), (boolean)false);
        }
        if (bl || pSDESARSBase.getPSSysServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysserviceapiid", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getPSSysServiceAPIId()), (boolean)false);
        }
        if (bl || pSDESARSBase.getPSSysServiceAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysserviceapiname", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getPSSysServiceAPIName()), (boolean)false);
        }
        if (bl || pSDESARSBase.getSyncExportModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syncexportmodel", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getSyncExportModel()), (boolean)false);
        }
        if (bl || pSDESARSBase.getTempOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tempordervalue", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getTempOrderValue()), (boolean)false);
        }
        if (bl || pSDESARSBase.getTypeFilter() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typefilter", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getTypeFilter()), (boolean)false);
        }
        if (bl || pSDESARSBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDESARSBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDESARSBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDESARSBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDESARSBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDESARSBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDESARSBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDESARSBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDESARSBase.getJSONValue((Object)pSDESARSBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDESARSBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDESARSBase pSDESARSBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDESARSBase.getActionRSMode() != null) {
            object = pSDESARSBase.getActionRSMode();
            xmlNode.setAttribute(FIELD_ACTIONRSMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDESARSBase.getArrayFlag() != null) {
            object = pSDESARSBase.getArrayFlag();
            xmlNode.setAttribute(FIELD_ARRAYFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDESARSBase.getChildFilter() != null) {
            object = pSDESARSBase.getChildFilter();
            xmlNode.setAttribute(FIELD_CHILDFILTER, object == null ? "" : (String)object);
        }
        if (bl || pSDESARSBase.getCodeName() != null) {
            object = pSDESARSBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDESARSBase.getCodeName2() != null) {
            object = pSDESARSBase.getCodeName2();
            xmlNode.setAttribute(FIELD_CODENAME2, object == null ? "" : (String)object);
        }
        if (bl || pSDESARSBase.getCPSDEId() != null) {
            object = pSDESARSBase.getCPSDEId();
            xmlNode.setAttribute(FIELD_CPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDESARSBase.getCPSDEServiceAPIId() != null) {
            object = pSDESARSBase.getCPSDEServiceAPIId();
            xmlNode.setAttribute(FIELD_CPSDESERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSDESARSBase.getCPSDEServiceAPIName() != null) {
            object = pSDESARSBase.getCPSDEServiceAPIName();
            xmlNode.setAttribute(FIELD_CPSDESERVICEAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSDESARSBase.getCreateDate() != null) {
            object = pSDESARSBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDESARSBase.getCreateMan() != null) {
            object = pSDESARSBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDESARSBase.getDataAccMode() != null) {
            object = pSDESARSBase.getDataAccMode();
            xmlNode.setAttribute(FIELD_DATAACCMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDESARSBase.getDataRSMode() != null) {
            object = pSDESARSBase.getDataRSMode();
            xmlNode.setAttribute(FIELD_DATARSMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDESARSBase.getEnableDataExport() != null) {
            object = pSDESARSBase.getEnableDataExport();
            xmlNode.setAttribute(FIELD_ENABLEDATAEXPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDESARSBase.getEnableDataImport() != null) {
            object = pSDESARSBase.getEnableDataImport();
            xmlNode.setAttribute(FIELD_ENABLEDATAIMPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDESARSBase.getEnableDEAction() != null) {
            object = pSDESARSBase.getEnableDEAction();
            xmlNode.setAttribute(FIELD_ENABLEDEACTION, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDESARSBase.getEnableDEDataSet() != null) {
            object = pSDESARSBase.getEnableDEDataSet();
            xmlNode.setAttribute(FIELD_ENABLEDEDATASET, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDESARSBase.getEnableSelect() != null) {
            object = pSDESARSBase.getEnableSelect();
            xmlNode.setAttribute(FIELD_ENABLESELECT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDESARSBase.getExportModel() != null) {
            object = pSDESARSBase.getExportModel();
            xmlNode.setAttribute(FIELD_EXPORTMODEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDESARSBase.getExportScope() != null) {
            object = pSDESARSBase.getExportScope();
            xmlNode.setAttribute(FIELD_EXPORTSCOPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDESARSBase.getExportScope2() != null) {
            object = pSDESARSBase.getExportScope2();
            xmlNode.setAttribute(FIELD_EXPORTSCOPE2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDESARSBase.getExportScope3() != null) {
            object = pSDESARSBase.getExportScope3();
            xmlNode.setAttribute(FIELD_EXPORTSCOPE3, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDESARSBase.getExportScope4() != null) {
            object = pSDESARSBase.getExportScope4();
            xmlNode.setAttribute(FIELD_EXPORTSCOPE4, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDESARSBase.getMemo() != null) {
            object = pSDESARSBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDESARSBase.getOrderValue() != null) {
            object = pSDESARSBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDESARSBase.getPPSDEId() != null) {
            object = pSDESARSBase.getPPSDEId();
            xmlNode.setAttribute(FIELD_PPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDESARSBase.getPPSDEServiceAPIId() != null) {
            object = pSDESARSBase.getPPSDEServiceAPIId();
            xmlNode.setAttribute(FIELD_PPSDESERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSDESARSBase.getPPSDEServiceAPIName() != null) {
            object = pSDESARSBase.getPPSDEServiceAPIName();
            xmlNode.setAttribute(FIELD_PPSDESERVICEAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSDESARSBase.getPSDERId() != null) {
            object = pSDESARSBase.getPSDERId();
            xmlNode.setAttribute(FIELD_PSDERID, object == null ? "" : (String)object);
        }
        if (bl || pSDESARSBase.getPSDERName() != null) {
            object = pSDESARSBase.getPSDERName();
            xmlNode.setAttribute(FIELD_PSDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDESARSBase.getPSDESARSId() != null) {
            object = pSDESARSBase.getPSDESARSId();
            xmlNode.setAttribute(FIELD_PSDESARSID, object == null ? "" : (String)object);
        }
        if (bl || pSDESARSBase.getPSDESARSName() != null) {
            object = pSDESARSBase.getPSDESARSName();
            xmlNode.setAttribute(FIELD_PSDESARSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDESARSBase.getPSSysServiceAPIId() != null) {
            object = pSDESARSBase.getPSSysServiceAPIId();
            xmlNode.setAttribute(FIELD_PSSYSSERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSDESARSBase.getPSSysServiceAPIName() != null) {
            object = pSDESARSBase.getPSSysServiceAPIName();
            xmlNode.setAttribute(FIELD_PSSYSSERVICEAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSDESARSBase.getSyncExportModel() != null) {
            object = pSDESARSBase.getSyncExportModel();
            xmlNode.setAttribute(FIELD_SYNCEXPORTMODEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDESARSBase.getTempOrderValue() != null) {
            object = pSDESARSBase.getTempOrderValue();
            xmlNode.setAttribute(FIELD_TEMPORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDESARSBase.getTypeFilter() != null) {
            object = pSDESARSBase.getTypeFilter();
            xmlNode.setAttribute(FIELD_TYPEFILTER, object == null ? "" : (String)object);
        }
        if (bl || pSDESARSBase.getUpdateDate() != null) {
            object = pSDESARSBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDESARSBase.getUpdateMan() != null) {
            object = pSDESARSBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDESARSBase.getUserCat() != null) {
            object = pSDESARSBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDESARSBase.getUserTag() != null) {
            object = pSDESARSBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDESARSBase.getUserTag2() != null) {
            object = pSDESARSBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDESARSBase.getUserTag3() != null) {
            object = pSDESARSBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDESARSBase.getUserTag4() != null) {
            object = pSDESARSBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDESARSBase.getValidFlag() != null) {
            object = pSDESARSBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDESARSBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDESARSBase pSDESARSBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDESARSBase.isActionRSModeDirty() && (bl || pSDESARSBase.getActionRSMode() != null)) {
            iDataObject.set(FIELD_ACTIONRSMODE, (Object)pSDESARSBase.getActionRSMode());
        }
        if (pSDESARSBase.isArrayFlagDirty() && (bl || pSDESARSBase.getArrayFlag() != null)) {
            iDataObject.set(FIELD_ARRAYFLAG, (Object)pSDESARSBase.getArrayFlag());
        }
        if (pSDESARSBase.isChildFilterDirty() && (bl || pSDESARSBase.getChildFilter() != null)) {
            iDataObject.set(FIELD_CHILDFILTER, (Object)pSDESARSBase.getChildFilter());
        }
        if (pSDESARSBase.isCodeNameDirty() && (bl || pSDESARSBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDESARSBase.getCodeName());
        }
        if (pSDESARSBase.isCodeName2Dirty() && (bl || pSDESARSBase.getCodeName2() != null)) {
            iDataObject.set(FIELD_CODENAME2, (Object)pSDESARSBase.getCodeName2());
        }
        if (pSDESARSBase.isCPSDEIdDirty() && (bl || pSDESARSBase.getCPSDEId() != null)) {
            iDataObject.set(FIELD_CPSDEID, (Object)pSDESARSBase.getCPSDEId());
        }
        if (pSDESARSBase.isCPSDEServiceAPIIdDirty() && (bl || pSDESARSBase.getCPSDEServiceAPIId() != null)) {
            iDataObject.set(FIELD_CPSDESERVICEAPIID, (Object)pSDESARSBase.getCPSDEServiceAPIId());
        }
        if (pSDESARSBase.isCPSDEServiceAPINameDirty() && (bl || pSDESARSBase.getCPSDEServiceAPIName() != null)) {
            iDataObject.set(FIELD_CPSDESERVICEAPINAME, (Object)pSDESARSBase.getCPSDEServiceAPIName());
        }
        if (pSDESARSBase.isCreateDateDirty() && (bl || pSDESARSBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDESARSBase.getCreateDate());
        }
        if (pSDESARSBase.isCreateManDirty() && (bl || pSDESARSBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDESARSBase.getCreateMan());
        }
        if (pSDESARSBase.isDataAccModeDirty() && (bl || pSDESARSBase.getDataAccMode() != null)) {
            iDataObject.set(FIELD_DATAACCMODE, (Object)pSDESARSBase.getDataAccMode());
        }
        if (pSDESARSBase.isDataRSModeDirty() && (bl || pSDESARSBase.getDataRSMode() != null)) {
            iDataObject.set(FIELD_DATARSMODE, (Object)pSDESARSBase.getDataRSMode());
        }
        if (pSDESARSBase.isEnableDataExportDirty() && (bl || pSDESARSBase.getEnableDataExport() != null)) {
            iDataObject.set(FIELD_ENABLEDATAEXPORT, (Object)pSDESARSBase.getEnableDataExport());
        }
        if (pSDESARSBase.isEnableDataImportDirty() && (bl || pSDESARSBase.getEnableDataImport() != null)) {
            iDataObject.set(FIELD_ENABLEDATAIMPORT, (Object)pSDESARSBase.getEnableDataImport());
        }
        if (pSDESARSBase.isEnableDEActionDirty() && (bl || pSDESARSBase.getEnableDEAction() != null)) {
            iDataObject.set(FIELD_ENABLEDEACTION, (Object)pSDESARSBase.getEnableDEAction());
        }
        if (pSDESARSBase.isEnableDEDataSetDirty() && (bl || pSDESARSBase.getEnableDEDataSet() != null)) {
            iDataObject.set(FIELD_ENABLEDEDATASET, (Object)pSDESARSBase.getEnableDEDataSet());
        }
        if (pSDESARSBase.isEnableSelectDirty() && (bl || pSDESARSBase.getEnableSelect() != null)) {
            iDataObject.set(FIELD_ENABLESELECT, (Object)pSDESARSBase.getEnableSelect());
        }
        if (pSDESARSBase.isExportModelDirty() && (bl || pSDESARSBase.getExportModel() != null)) {
            iDataObject.set(FIELD_EXPORTMODEL, (Object)pSDESARSBase.getExportModel());
        }
        if (pSDESARSBase.isExportScopeDirty() && (bl || pSDESARSBase.getExportScope() != null)) {
            iDataObject.set(FIELD_EXPORTSCOPE, (Object)pSDESARSBase.getExportScope());
        }
        if (pSDESARSBase.isExportScope2Dirty() && (bl || pSDESARSBase.getExportScope2() != null)) {
            iDataObject.set(FIELD_EXPORTSCOPE2, (Object)pSDESARSBase.getExportScope2());
        }
        if (pSDESARSBase.isExportScope3Dirty() && (bl || pSDESARSBase.getExportScope3() != null)) {
            iDataObject.set(FIELD_EXPORTSCOPE3, (Object)pSDESARSBase.getExportScope3());
        }
        if (pSDESARSBase.isExportScope4Dirty() && (bl || pSDESARSBase.getExportScope4() != null)) {
            iDataObject.set(FIELD_EXPORTSCOPE4, (Object)pSDESARSBase.getExportScope4());
        }
        if (pSDESARSBase.isMemoDirty() && (bl || pSDESARSBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDESARSBase.getMemo());
        }
        if (pSDESARSBase.isOrderValueDirty() && (bl || pSDESARSBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDESARSBase.getOrderValue());
        }
        if (pSDESARSBase.isPPSDEIdDirty() && (bl || pSDESARSBase.getPPSDEId() != null)) {
            iDataObject.set(FIELD_PPSDEID, (Object)pSDESARSBase.getPPSDEId());
        }
        if (pSDESARSBase.isPPSDEServiceAPIIdDirty() && (bl || pSDESARSBase.getPPSDEServiceAPIId() != null)) {
            iDataObject.set(FIELD_PPSDESERVICEAPIID, (Object)pSDESARSBase.getPPSDEServiceAPIId());
        }
        if (pSDESARSBase.isPPSDEServiceAPINameDirty() && (bl || pSDESARSBase.getPPSDEServiceAPIName() != null)) {
            iDataObject.set(FIELD_PPSDESERVICEAPINAME, (Object)pSDESARSBase.getPPSDEServiceAPIName());
        }
        if (pSDESARSBase.isPSDERIdDirty() && (bl || pSDESARSBase.getPSDERId() != null)) {
            iDataObject.set(FIELD_PSDERID, (Object)pSDESARSBase.getPSDERId());
        }
        if (pSDESARSBase.isPSDERNameDirty() && (bl || pSDESARSBase.getPSDERName() != null)) {
            iDataObject.set(FIELD_PSDERNAME, (Object)pSDESARSBase.getPSDERName());
        }
        if (pSDESARSBase.isPSDESARSIdDirty() && (bl || pSDESARSBase.getPSDESARSId() != null)) {
            iDataObject.set(FIELD_PSDESARSID, (Object)pSDESARSBase.getPSDESARSId());
        }
        if (pSDESARSBase.isPSDESARSNameDirty() && (bl || pSDESARSBase.getPSDESARSName() != null)) {
            iDataObject.set(FIELD_PSDESARSNAME, (Object)pSDESARSBase.getPSDESARSName());
        }
        if (pSDESARSBase.isPSSysServiceAPIIdDirty() && (bl || pSDESARSBase.getPSSysServiceAPIId() != null)) {
            iDataObject.set(FIELD_PSSYSSERVICEAPIID, (Object)pSDESARSBase.getPSSysServiceAPIId());
        }
        if (pSDESARSBase.isPSSysServiceAPINameDirty() && (bl || pSDESARSBase.getPSSysServiceAPIName() != null)) {
            iDataObject.set(FIELD_PSSYSSERVICEAPINAME, (Object)pSDESARSBase.getPSSysServiceAPIName());
        }
        if (pSDESARSBase.isSyncExportModelDirty() && (bl || pSDESARSBase.getSyncExportModel() != null)) {
            iDataObject.set(FIELD_SYNCEXPORTMODEL, (Object)pSDESARSBase.getSyncExportModel());
        }
        if (pSDESARSBase.isTempOrderValueDirty() && (bl || pSDESARSBase.getTempOrderValue() != null)) {
            iDataObject.set(FIELD_TEMPORDERVALUE, (Object)pSDESARSBase.getTempOrderValue());
        }
        if (pSDESARSBase.isTypeFilterDirty() && (bl || pSDESARSBase.getTypeFilter() != null)) {
            iDataObject.set(FIELD_TYPEFILTER, (Object)pSDESARSBase.getTypeFilter());
        }
        if (pSDESARSBase.isUpdateDateDirty() && (bl || pSDESARSBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDESARSBase.getUpdateDate());
        }
        if (pSDESARSBase.isUpdateManDirty() && (bl || pSDESARSBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDESARSBase.getUpdateMan());
        }
        if (pSDESARSBase.isUserCatDirty() && (bl || pSDESARSBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDESARSBase.getUserCat());
        }
        if (pSDESARSBase.isUserTagDirty() && (bl || pSDESARSBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDESARSBase.getUserTag());
        }
        if (pSDESARSBase.isUserTag2Dirty() && (bl || pSDESARSBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDESARSBase.getUserTag2());
        }
        if (pSDESARSBase.isUserTag3Dirty() && (bl || pSDESARSBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDESARSBase.getUserTag3());
        }
        if (pSDESARSBase.isUserTag4Dirty() && (bl || pSDESARSBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDESARSBase.getUserTag4());
        }
        if (pSDESARSBase.isValidFlagDirty() && (bl || pSDESARSBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDESARSBase.getValidFlag());
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
        return PSDESARSBase.remove(this, n);
    }

    private static boolean remove(PSDESARSBase pSDESARSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDESARSBase.resetActionRSMode();
                return true;
            }
            case 1: {
                pSDESARSBase.resetArrayFlag();
                return true;
            }
            case 2: {
                pSDESARSBase.resetChildFilter();
                return true;
            }
            case 3: {
                pSDESARSBase.resetCodeName();
                return true;
            }
            case 4: {
                pSDESARSBase.resetCodeName2();
                return true;
            }
            case 5: {
                pSDESARSBase.resetCPSDEId();
                return true;
            }
            case 6: {
                pSDESARSBase.resetCPSDEServiceAPIId();
                return true;
            }
            case 7: {
                pSDESARSBase.resetCPSDEServiceAPIName();
                return true;
            }
            case 8: {
                pSDESARSBase.resetCreateDate();
                return true;
            }
            case 9: {
                pSDESARSBase.resetCreateMan();
                return true;
            }
            case 10: {
                pSDESARSBase.resetDataAccMode();
                return true;
            }
            case 11: {
                pSDESARSBase.resetDataRSMode();
                return true;
            }
            case 12: {
                pSDESARSBase.resetEnableDataExport();
                return true;
            }
            case 13: {
                pSDESARSBase.resetEnableDataImport();
                return true;
            }
            case 14: {
                pSDESARSBase.resetEnableDEAction();
                return true;
            }
            case 15: {
                pSDESARSBase.resetEnableDEDataSet();
                return true;
            }
            case 16: {
                pSDESARSBase.resetEnableSelect();
                return true;
            }
            case 17: {
                pSDESARSBase.resetExportModel();
                return true;
            }
            case 18: {
                pSDESARSBase.resetExportScope();
                return true;
            }
            case 19: {
                pSDESARSBase.resetExportScope2();
                return true;
            }
            case 20: {
                pSDESARSBase.resetExportScope3();
                return true;
            }
            case 21: {
                pSDESARSBase.resetExportScope4();
                return true;
            }
            case 22: {
                pSDESARSBase.resetMemo();
                return true;
            }
            case 23: {
                pSDESARSBase.resetOrderValue();
                return true;
            }
            case 24: {
                pSDESARSBase.resetPPSDEId();
                return true;
            }
            case 25: {
                pSDESARSBase.resetPPSDEServiceAPIId();
                return true;
            }
            case 26: {
                pSDESARSBase.resetPPSDEServiceAPIName();
                return true;
            }
            case 27: {
                pSDESARSBase.resetPSDERId();
                return true;
            }
            case 28: {
                pSDESARSBase.resetPSDERName();
                return true;
            }
            case 29: {
                pSDESARSBase.resetPSDESARSId();
                return true;
            }
            case 30: {
                pSDESARSBase.resetPSDESARSName();
                return true;
            }
            case 31: {
                pSDESARSBase.resetPSSysServiceAPIId();
                return true;
            }
            case 32: {
                pSDESARSBase.resetPSSysServiceAPIName();
                return true;
            }
            case 33: {
                pSDESARSBase.resetSyncExportModel();
                return true;
            }
            case 34: {
                pSDESARSBase.resetTempOrderValue();
                return true;
            }
            case 35: {
                pSDESARSBase.resetTypeFilter();
                return true;
            }
            case 36: {
                pSDESARSBase.resetUpdateDate();
                return true;
            }
            case 37: {
                pSDESARSBase.resetUpdateMan();
                return true;
            }
            case 38: {
                pSDESARSBase.resetUserCat();
                return true;
            }
            case 39: {
                pSDESARSBase.resetUserTag();
                return true;
            }
            case 40: {
                pSDESARSBase.resetUserTag2();
                return true;
            }
            case 41: {
                pSDESARSBase.resetUserTag3();
                return true;
            }
            case 42: {
                pSDESARSBase.resetUserTag4();
                return true;
            }
            case 43: {
                pSDESARSBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
    public PSDEServiceAPI getCPSDEServiceAPI() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCPSDEServiceAPI();
        }
        if (this.getCPSDEServiceAPIId() == null) {
            return null;
        }
        Integer n = this.objCPSDEServiceAPILock;
        synchronized (n) {
            if (this.cpsdeserviceapi != null && DataTypeHelper.compare((int)25, (Object)this.getCPSDEServiceAPIId(), (Object)this.cpsdeserviceapi.getPSDEServiceAPIId()) != 0L) {
                this.cpsdeserviceapi = null;
            }
            if (this.cpsdeserviceapi == null) {
                PSDEServiceAPI pSDEServiceAPI = new PSDEServiceAPI();
                pSDEServiceAPI.setPSDEServiceAPIId(this.getCPSDEServiceAPIId());
                PSDEServiceAPIService pSDEServiceAPIService = (PSDEServiceAPIService)ServiceGlobal.getService(PSDEServiceAPIService.class, (SessionFactory)this.getSessionFactory());
                pSDEServiceAPIService.autoGet(pSDEServiceAPI);
                this.cpsdeserviceapi = pSDEServiceAPI;
            }
            return this.cpsdeserviceapi;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEServiceAPI getPPSDEServiceAPI() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDEServiceAPI();
        }
        if (this.getPPSDEServiceAPIId() == null) {
            return null;
        }
        Integer n = this.objPPSDEServiceAPILock;
        synchronized (n) {
            if (this.ppsdeserviceapi != null && DataTypeHelper.compare((int)25, (Object)this.getPPSDEServiceAPIId(), (Object)this.ppsdeserviceapi.getPSDEServiceAPIId()) != 0L) {
                this.ppsdeserviceapi = null;
            }
            if (this.ppsdeserviceapi == null) {
                PSDEServiceAPI pSDEServiceAPI = new PSDEServiceAPI();
                pSDEServiceAPI.setPSDEServiceAPIId(this.getPPSDEServiceAPIId());
                PSDEServiceAPIService pSDEServiceAPIService = (PSDEServiceAPIService)ServiceGlobal.getService(PSDEServiceAPIService.class, (SessionFactory)this.getSessionFactory());
                pSDEServiceAPIService.autoGet(pSDEServiceAPI);
                this.ppsdeserviceapi = pSDEServiceAPI;
            }
            return this.ppsdeserviceapi;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysServiceAPI getPSSysServiceAPI() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysServiceAPI();
        }
        if (this.getPSSysServiceAPIId() == null) {
            return null;
        }
        Integer n = this.objPSSysServiceAPILock;
        synchronized (n) {
            if (this.pssysserviceapi != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysServiceAPIId(), (Object)this.pssysserviceapi.getPSSysServiceAPIId()) != 0L) {
                this.pssysserviceapi = null;
            }
            if (this.pssysserviceapi == null) {
                PSSysServiceAPI pSSysServiceAPI = new PSSysServiceAPI();
                pSSysServiceAPI.setPSSysServiceAPIId(this.getPSSysServiceAPIId());
                PSSysServiceAPIService pSSysServiceAPIService = (PSSysServiceAPIService)ServiceGlobal.getService(PSSysServiceAPIService.class, (SessionFactory)this.getSessionFactory());
                pSSysServiceAPIService.autoGet(pSSysServiceAPI);
                this.pssysserviceapi = pSSysServiceAPI;
            }
            return this.pssysserviceapi;
        }
    }

    private PSDESARSBase getProxyEntity() {
        return this.proxyPSDESARSBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDESARSBase = null;
        if (iDataObject != null && iDataObject instanceof PSDESARSBase) {
            this.proxyPSDESARSBase = (PSDESARSBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDESARSService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACTIONRSMODE, 0);
        fieldIndexMap.put(FIELD_ARRAYFLAG, 1);
        fieldIndexMap.put(FIELD_CHILDFILTER, 2);
        fieldIndexMap.put(FIELD_CODENAME, 3);
        fieldIndexMap.put(FIELD_CODENAME2, 4);
        fieldIndexMap.put(FIELD_CPSDEID, 5);
        fieldIndexMap.put(FIELD_CPSDESERVICEAPIID, 6);
        fieldIndexMap.put(FIELD_CPSDESERVICEAPINAME, 7);
        fieldIndexMap.put(FIELD_CREATEDATE, 8);
        fieldIndexMap.put(FIELD_CREATEMAN, 9);
        fieldIndexMap.put(FIELD_DATAACCMODE, 10);
        fieldIndexMap.put(FIELD_DATARSMODE, 11);
        fieldIndexMap.put(FIELD_ENABLEDATAEXPORT, 12);
        fieldIndexMap.put(FIELD_ENABLEDATAIMPORT, 13);
        fieldIndexMap.put(FIELD_ENABLEDEACTION, 14);
        fieldIndexMap.put(FIELD_ENABLEDEDATASET, 15);
        fieldIndexMap.put(FIELD_ENABLESELECT, 16);
        fieldIndexMap.put(FIELD_EXPORTMODEL, 17);
        fieldIndexMap.put(FIELD_EXPORTSCOPE, 18);
        fieldIndexMap.put(FIELD_EXPORTSCOPE2, 19);
        fieldIndexMap.put(FIELD_EXPORTSCOPE3, 20);
        fieldIndexMap.put(FIELD_EXPORTSCOPE4, 21);
        fieldIndexMap.put(FIELD_MEMO, 22);
        fieldIndexMap.put(FIELD_ORDERVALUE, 23);
        fieldIndexMap.put(FIELD_PPSDEID, 24);
        fieldIndexMap.put(FIELD_PPSDESERVICEAPIID, 25);
        fieldIndexMap.put(FIELD_PPSDESERVICEAPINAME, 26);
        fieldIndexMap.put(FIELD_PSDERID, 27);
        fieldIndexMap.put(FIELD_PSDERNAME, 28);
        fieldIndexMap.put(FIELD_PSDESARSID, 29);
        fieldIndexMap.put(FIELD_PSDESARSNAME, 30);
        fieldIndexMap.put(FIELD_PSSYSSERVICEAPIID, 31);
        fieldIndexMap.put(FIELD_PSSYSSERVICEAPINAME, 32);
        fieldIndexMap.put(FIELD_SYNCEXPORTMODEL, 33);
        fieldIndexMap.put(FIELD_TEMPORDERVALUE, 34);
        fieldIndexMap.put(FIELD_TYPEFILTER, 35);
        fieldIndexMap.put(FIELD_UPDATEDATE, 36);
        fieldIndexMap.put(FIELD_UPDATEMAN, 37);
        fieldIndexMap.put(FIELD_USERCAT, 38);
        fieldIndexMap.put(FIELD_USERTAG, 39);
        fieldIndexMap.put(FIELD_USERTAG2, 40);
        fieldIndexMap.put(FIELD_USERTAG3, 41);
        fieldIndexMap.put(FIELD_USERTAG4, 42);
        fieldIndexMap.put(FIELD_VALIDFLAG, 43);
    }
}

