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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADEField;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADERS;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADetail;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADEFieldService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADERSService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADetailService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSubSysSADEBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSubSysSADEBase.class);
    public static final String FIELD_BASECLSPARAMS = "BASECLSPARAMS";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CODENAME2 = "CODENAME2";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_DEPARAMS = "DEPARAMS";
    public static final String FIELD_DETAG = "DETAG";
    public static final String FIELD_DETAG2 = "DETAG2";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MAJORFLAG = "MAJORFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_METHODCODE = "METHODCODE";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PREDEFINEDTYPE = "PREDEFINEDTYPE";
    public static final String FIELD_PSSUBSYSSADEID = "PSSUBSYSSADEID";
    public static final String FIELD_PSSUBSYSSADENAME = "PSSUBSYSSADENAME";
    public static final String FIELD_PSSUBSYSSERVICEAPIID = "PSSUBSYSSERVICEAPIID";
    public static final String FIELD_PSSUBSYSSERVICEAPINAME = "PSSUBSYSSERVICEAPINAME";
    public static final String FIELD_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String FIELD_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_SERVICEPARAM = "SERVICEPARAM";
    public static final String FIELD_SERVICEPARAM2 = "SERVICEPARAM2";
    public static final String FIELD_SYNCMODELMODE = "SYNCMODELMODE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_BASECLSPARAMS = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CODENAME2 = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_CUSTOMCODE = 5;
    private static final int INDEX_CUSTOMMODE = 6;
    private static final int INDEX_DEPARAMS = 7;
    private static final int INDEX_DETAG = 8;
    private static final int INDEX_DETAG2 = 9;
    private static final int INDEX_LOGICNAME = 10;
    private static final int INDEX_MAJORFLAG = 11;
    private static final int INDEX_MEMO = 12;
    private static final int INDEX_METHODCODE = 13;
    private static final int INDEX_ORDERVALUE = 14;
    private static final int INDEX_PREDEFINEDTYPE = 15;
    private static final int INDEX_PSSUBSYSSADEID = 16;
    private static final int INDEX_PSSUBSYSSADENAME = 17;
    private static final int INDEX_PSSUBSYSSERVICEAPIID = 18;
    private static final int INDEX_PSSUBSYSSERVICEAPINAME = 19;
    private static final int INDEX_PSSYSREQITEMID = 20;
    private static final int INDEX_PSSYSREQITEMNAME = 21;
    private static final int INDEX_PSSYSSFPLUGINID = 22;
    private static final int INDEX_PSSYSSFPLUGINNAME = 23;
    private static final int INDEX_SERVICEPARAM = 24;
    private static final int INDEX_SERVICEPARAM2 = 25;
    private static final int INDEX_SYNCMODELMODE = 26;
    private static final int INDEX_UPDATEDATE = 27;
    private static final int INDEX_UPDATEMAN = 28;
    private static final int INDEX_USERCAT = 29;
    private static final int INDEX_USERTAG = 30;
    private static final int INDEX_USERTAG2 = 31;
    private static final int INDEX_USERTAG3 = 32;
    private static final int INDEX_USERTAG4 = 33;
    private static final int INDEX_VALIDFLAG = 34;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSubSysSADEBase proxyPSSubSysSADEBase = null;
    private boolean baseclsparamsDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean codename2DirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean deparamsDirtyFlag = false;
    private boolean detagDirtyFlag = false;
    private boolean detag2DirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean majorflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean methodcodeDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean predefinedtypeDirtyFlag = false;
    private boolean pssubsyssadeidDirtyFlag = false;
    private boolean pssubsyssadenameDirtyFlag = false;
    private boolean pssubsysserviceapiidDirtyFlag = false;
    private boolean pssubsysserviceapinameDirtyFlag = false;
    private boolean pssysreqitemidDirtyFlag = false;
    private boolean pssysreqitemnameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean serviceparamDirtyFlag = false;
    private boolean serviceparam2DirtyFlag = false;
    private boolean syncmodelmodeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="baseclsparams")
    private String baseclsparams;
    @Column(name="codename")
    private String codename;
    @Column(name="codename2")
    private String codename2;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcode")
    private String customcode;
    @Column(name="custommode")
    private Integer custommode;
    @Column(name="deparams")
    private String deparams;
    @Column(name="detag")
    private String detag;
    @Column(name="detag2")
    private String detag2;
    @Column(name="logicname")
    private String logicname;
    @Column(name="majorflag")
    private Integer majorflag;
    @Column(name="memo")
    private String memo;
    @Column(name="methodcode")
    private String methodcode;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="predefinedtype")
    private String predefinedtype;
    @Column(name="pssubsyssadeid")
    private String pssubsyssadeid;
    @Column(name="pssubsyssadename")
    private String pssubsyssadename;
    @Column(name="pssubsysserviceapiid")
    private String pssubsysserviceapiid;
    @Column(name="pssubsysserviceapiname")
    private String pssubsysserviceapiname;
    @Column(name="pssysreqitemid")
    private String pssysreqitemid;
    @Column(name="pssysreqitemname")
    private String pssysreqitemname;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="serviceparam")
    private String serviceparam;
    @Column(name="serviceparam2")
    private String serviceparam2;
    @Column(name="syncmodelmode")
    private String syncmodelmode;
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
    private Integer objPSSubSysServiceAPILock = new Integer(1);
    private PSSubSysServiceAPI pssubsysserviceapi = null;
    private Integer objPSSysReqItemLock = new Integer(1);
    private PSSysReqItem pssysreqitem = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSubSysSADEFieldsLock = new Integer(1);
    private ArrayList<PSSubSysSADEField> pssubsyssadefields = null;
    private Integer objMinorPSSubSysSADERSsLock = new Integer(1);
    private ArrayList<PSSubSysSADERS> minorpssubsyssaderss = null;
    private Integer objMajorPSSubSysSADERSsLock = new Integer(1);
    private ArrayList<PSSubSysSADERS> majorpssubsyssaderss = null;
    private Integer objPSSubSysSADetailsLock = new Integer(1);
    private ArrayList<PSSubSysSADetail> pssubsyssadetails = null;

    public void setBaseClsParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBaseClsParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.baseclsparams = string;
        this.baseclsparamsDirtyFlag = true;
    }

    public String getBaseClsParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBaseClsParams();
        }
        return this.baseclsparams;
    }

    public boolean isBaseClsParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBaseClsParamsDirty();
        }
        return this.baseclsparamsDirtyFlag;
    }

    public void resetBaseClsParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBaseClsParams();
            return;
        }
        this.baseclsparamsDirtyFlag = false;
        this.baseclsparams = null;
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

    public void setDEParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.deparams = string;
        this.deparamsDirtyFlag = true;
    }

    public String getDEParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEParams();
        }
        return this.deparams;
    }

    public boolean isDEParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEParamsDirty();
        }
        return this.deparamsDirtyFlag;
    }

    public void resetDEParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEParams();
            return;
        }
        this.deparamsDirtyFlag = false;
        this.deparams = null;
    }

    public void setDETag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDETag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.detag = string;
        this.detagDirtyFlag = true;
    }

    public String getDETag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDETag();
        }
        return this.detag;
    }

    public boolean isDETagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDETagDirty();
        }
        return this.detagDirtyFlag;
    }

    public void resetDETag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDETag();
            return;
        }
        this.detagDirtyFlag = false;
        this.detag = null;
    }

    public void setDETag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDETag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.detag2 = string;
        this.detag2DirtyFlag = true;
    }

    public String getDETag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDETag2();
        }
        return this.detag2;
    }

    public boolean isDETag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDETag2Dirty();
        }
        return this.detag2DirtyFlag;
    }

    public void resetDETag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDETag2();
            return;
        }
        this.detag2DirtyFlag = false;
        this.detag2 = null;
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

    public void setMajorFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMajorFlag(n);
            return;
        }
        this.majorflag = n;
        this.majorflagDirtyFlag = true;
    }

    public Integer getMajorFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorFlag();
        }
        return this.majorflag;
    }

    public boolean isMajorFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMajorFlagDirty();
        }
        return this.majorflagDirtyFlag;
    }

    public void resetMajorFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMajorFlag();
            return;
        }
        this.majorflagDirtyFlag = false;
        this.majorflag = null;
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

    public void setMethodCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMethodCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.methodcode = string;
        this.methodcodeDirtyFlag = true;
    }

    public String getMethodCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMethodCode();
        }
        return this.methodcode;
    }

    public boolean isMethodCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMethodCodeDirty();
        }
        return this.methodcodeDirtyFlag;
    }

    public void resetMethodCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMethodCode();
            return;
        }
        this.methodcodeDirtyFlag = false;
        this.methodcode = null;
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
        if (string != null) {
            string = string.toUpperCase();
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

    public void setPSSysReqItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreqitemid = string;
        this.pssysreqitemidDirtyFlag = true;
    }

    public String getPSSysReqItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemId();
        }
        return this.pssysreqitemid;
    }

    public boolean isPSSysReqItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqItemIdDirty();
        }
        return this.pssysreqitemidDirtyFlag;
    }

    public void resetPSSysReqItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqItemId();
            return;
        }
        this.pssysreqitemidDirtyFlag = false;
        this.pssysreqitemid = null;
    }

    public void setPSSysReqItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreqitemname = string;
        this.pssysreqitemnameDirtyFlag = true;
    }

    public String getPSSysReqItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemName();
        }
        return this.pssysreqitemname;
    }

    public boolean isPSSysReqItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqItemNameDirty();
        }
        return this.pssysreqitemnameDirtyFlag;
    }

    public void resetPSSysReqItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqItemName();
            return;
        }
        this.pssysreqitemnameDirtyFlag = false;
        this.pssysreqitemname = null;
    }

    public void setPSSysSFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginid = string;
        this.pssyssfpluginidDirtyFlag = true;
    }

    public String getPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginId();
        }
        return this.pssyssfpluginid;
    }

    public boolean isPSSysSFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginIdDirty();
        }
        return this.pssyssfpluginidDirtyFlag;
    }

    public void resetPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginId();
            return;
        }
        this.pssyssfpluginidDirtyFlag = false;
        this.pssyssfpluginid = null;
    }

    public void setPSSysSFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginname = string;
        this.pssyssfpluginnameDirtyFlag = true;
    }

    public String getPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginName();
        }
        return this.pssyssfpluginname;
    }

    public boolean isPSSysSFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginNameDirty();
        }
        return this.pssyssfpluginnameDirtyFlag;
    }

    public void resetPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginName();
            return;
        }
        this.pssyssfpluginnameDirtyFlag = false;
        this.pssyssfpluginname = null;
    }

    public void setServiceParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.serviceparam = string;
        this.serviceparamDirtyFlag = true;
    }

    public String getServiceParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceParam();
        }
        return this.serviceparam;
    }

    public boolean isServiceParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceParamDirty();
        }
        return this.serviceparamDirtyFlag;
    }

    public void resetServiceParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceParam();
            return;
        }
        this.serviceparamDirtyFlag = false;
        this.serviceparam = null;
    }

    public void setServiceParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.serviceparam2 = string;
        this.serviceparam2DirtyFlag = true;
    }

    public String getServiceParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceParam2();
        }
        return this.serviceparam2;
    }

    public boolean isServiceParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceParam2Dirty();
        }
        return this.serviceparam2DirtyFlag;
    }

    public void resetServiceParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceParam2();
            return;
        }
        this.serviceparam2DirtyFlag = false;
        this.serviceparam2 = null;
    }

    public void setSyncModelMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSyncModelMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.syncmodelmode = string;
        this.syncmodelmodeDirtyFlag = true;
    }

    public String getSyncModelMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSyncModelMode();
        }
        return this.syncmodelmode;
    }

    public boolean isSyncModelModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSyncModelModeDirty();
        }
        return this.syncmodelmodeDirtyFlag;
    }

    public void resetSyncModelMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSyncModelMode();
            return;
        }
        this.syncmodelmodeDirtyFlag = false;
        this.syncmodelmode = null;
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
        PSSubSysSADEBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSubSysSADEBase pSSubSysSADEBase) {
        pSSubSysSADEBase.resetBaseClsParams();
        pSSubSysSADEBase.resetCodeName();
        pSSubSysSADEBase.resetCodeName2();
        pSSubSysSADEBase.resetCreateDate();
        pSSubSysSADEBase.resetCreateMan();
        pSSubSysSADEBase.resetCustomCode();
        pSSubSysSADEBase.resetCustomMode();
        pSSubSysSADEBase.resetDEParams();
        pSSubSysSADEBase.resetDETag();
        pSSubSysSADEBase.resetDETag2();
        pSSubSysSADEBase.resetLogicName();
        pSSubSysSADEBase.resetMajorFlag();
        pSSubSysSADEBase.resetMemo();
        pSSubSysSADEBase.resetMethodCode();
        pSSubSysSADEBase.resetOrderValue();
        pSSubSysSADEBase.resetPredefinedType();
        pSSubSysSADEBase.resetPSSubSysSADEId();
        pSSubSysSADEBase.resetPSSubSysSADEName();
        pSSubSysSADEBase.resetPSSubSysServiceAPIId();
        pSSubSysSADEBase.resetPSSubSysServiceAPIName();
        pSSubSysSADEBase.resetPSSysReqItemId();
        pSSubSysSADEBase.resetPSSysReqItemName();
        pSSubSysSADEBase.resetPSSysSFPluginId();
        pSSubSysSADEBase.resetPSSysSFPluginName();
        pSSubSysSADEBase.resetServiceParam();
        pSSubSysSADEBase.resetServiceParam2();
        pSSubSysSADEBase.resetSyncModelMode();
        pSSubSysSADEBase.resetUpdateDate();
        pSSubSysSADEBase.resetUpdateMan();
        pSSubSysSADEBase.resetUserCat();
        pSSubSysSADEBase.resetUserTag();
        pSSubSysSADEBase.resetUserTag2();
        pSSubSysSADEBase.resetUserTag3();
        pSSubSysSADEBase.resetUserTag4();
        pSSubSysSADEBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBaseClsParamsDirty()) {
            hashMap.put(FIELD_BASECLSPARAMS, this.getBaseClsParams());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCodeName2Dirty()) {
            hashMap.put(FIELD_CODENAME2, this.getCodeName2());
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
        if (!bl || this.isCustomModeDirty()) {
            hashMap.put(FIELD_CUSTOMMODE, this.getCustomMode());
        }
        if (!bl || this.isDEParamsDirty()) {
            hashMap.put(FIELD_DEPARAMS, this.getDEParams());
        }
        if (!bl || this.isDETagDirty()) {
            hashMap.put(FIELD_DETAG, this.getDETag());
        }
        if (!bl || this.isDETag2Dirty()) {
            hashMap.put(FIELD_DETAG2, this.getDETag2());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMajorFlagDirty()) {
            hashMap.put(FIELD_MAJORFLAG, this.getMajorFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMethodCodeDirty()) {
            hashMap.put(FIELD_METHODCODE, this.getMethodCode());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPredefinedTypeDirty()) {
            hashMap.put(FIELD_PREDEFINEDTYPE, this.getPredefinedType());
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
        if (!bl || this.isPSSysReqItemIdDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMID, this.getPSSysReqItemId());
        }
        if (!bl || this.isPSSysReqItemNameDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMNAME, this.getPSSysReqItemName());
        }
        if (!bl || this.isPSSysSFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINID, this.getPSSysSFPluginId());
        }
        if (!bl || this.isPSSysSFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINNAME, this.getPSSysSFPluginName());
        }
        if (!bl || this.isServiceParamDirty()) {
            hashMap.put(FIELD_SERVICEPARAM, this.getServiceParam());
        }
        if (!bl || this.isServiceParam2Dirty()) {
            hashMap.put(FIELD_SERVICEPARAM2, this.getServiceParam2());
        }
        if (!bl || this.isSyncModelModeDirty()) {
            hashMap.put(FIELD_SYNCMODELMODE, this.getSyncModelMode());
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
        return PSSubSysSADEBase.get(this, n);
    }

    private static Object get(PSSubSysSADEBase pSSubSysSADEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubSysSADEBase.getBaseClsParams();
            }
            case 1: {
                return pSSubSysSADEBase.getCodeName();
            }
            case 2: {
                return pSSubSysSADEBase.getCodeName2();
            }
            case 3: {
                return pSSubSysSADEBase.getCreateDate();
            }
            case 4: {
                return pSSubSysSADEBase.getCreateMan();
            }
            case 5: {
                return pSSubSysSADEBase.getCustomCode();
            }
            case 6: {
                return pSSubSysSADEBase.getCustomMode();
            }
            case 7: {
                return pSSubSysSADEBase.getDEParams();
            }
            case 8: {
                return pSSubSysSADEBase.getDETag();
            }
            case 9: {
                return pSSubSysSADEBase.getDETag2();
            }
            case 10: {
                return pSSubSysSADEBase.getLogicName();
            }
            case 11: {
                return pSSubSysSADEBase.getMajorFlag();
            }
            case 12: {
                return pSSubSysSADEBase.getMemo();
            }
            case 13: {
                return pSSubSysSADEBase.getMethodCode();
            }
            case 14: {
                return pSSubSysSADEBase.getOrderValue();
            }
            case 15: {
                return pSSubSysSADEBase.getPredefinedType();
            }
            case 16: {
                return pSSubSysSADEBase.getPSSubSysSADEId();
            }
            case 17: {
                return pSSubSysSADEBase.getPSSubSysSADEName();
            }
            case 18: {
                return pSSubSysSADEBase.getPSSubSysServiceAPIId();
            }
            case 19: {
                return pSSubSysSADEBase.getPSSubSysServiceAPIName();
            }
            case 20: {
                return pSSubSysSADEBase.getPSSysReqItemId();
            }
            case 21: {
                return pSSubSysSADEBase.getPSSysReqItemName();
            }
            case 22: {
                return pSSubSysSADEBase.getPSSysSFPluginId();
            }
            case 23: {
                return pSSubSysSADEBase.getPSSysSFPluginName();
            }
            case 24: {
                return pSSubSysSADEBase.getServiceParam();
            }
            case 25: {
                return pSSubSysSADEBase.getServiceParam2();
            }
            case 26: {
                return pSSubSysSADEBase.getSyncModelMode();
            }
            case 27: {
                return pSSubSysSADEBase.getUpdateDate();
            }
            case 28: {
                return pSSubSysSADEBase.getUpdateMan();
            }
            case 29: {
                return pSSubSysSADEBase.getUserCat();
            }
            case 30: {
                return pSSubSysSADEBase.getUserTag();
            }
            case 31: {
                return pSSubSysSADEBase.getUserTag2();
            }
            case 32: {
                return pSSubSysSADEBase.getUserTag3();
            }
            case 33: {
                return pSSubSysSADEBase.getUserTag4();
            }
            case 34: {
                return pSSubSysSADEBase.getValidFlag();
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
        PSSubSysSADEBase.set(this, n, object);
    }

    private static void set(PSSubSysSADEBase pSSubSysSADEBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSubSysSADEBase.setBaseClsParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSubSysSADEBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSubSysSADEBase.setCodeName2(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSubSysSADEBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSSubSysSADEBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSubSysSADEBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSubSysSADEBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSSubSysSADEBase.setDEParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSubSysSADEBase.setDETag(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSubSysSADEBase.setDETag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSubSysSADEBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSubSysSADEBase.setMajorFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSSubSysSADEBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSubSysSADEBase.setMethodCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSubSysSADEBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSSubSysSADEBase.setPredefinedType(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSubSysSADEBase.setPSSubSysSADEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSubSysSADEBase.setPSSubSysSADEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSubSysSADEBase.setPSSubSysServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSubSysSADEBase.setPSSubSysServiceAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSubSysSADEBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSubSysSADEBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSubSysSADEBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSubSysSADEBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSubSysSADEBase.setServiceParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSubSysSADEBase.setServiceParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSubSysSADEBase.setSyncModelMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSubSysSADEBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 28: {
                pSSubSysSADEBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSubSysSADEBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSubSysSADEBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSubSysSADEBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSubSysSADEBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSubSysSADEBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSubSysSADEBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSubSysSADEBase.isNull(this, n);
    }

    private static boolean isNull(PSSubSysSADEBase pSSubSysSADEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubSysSADEBase.getBaseClsParams() == null;
            }
            case 1: {
                return pSSubSysSADEBase.getCodeName() == null;
            }
            case 2: {
                return pSSubSysSADEBase.getCodeName2() == null;
            }
            case 3: {
                return pSSubSysSADEBase.getCreateDate() == null;
            }
            case 4: {
                return pSSubSysSADEBase.getCreateMan() == null;
            }
            case 5: {
                return pSSubSysSADEBase.getCustomCode() == null;
            }
            case 6: {
                return pSSubSysSADEBase.getCustomMode() == null;
            }
            case 7: {
                return pSSubSysSADEBase.getDEParams() == null;
            }
            case 8: {
                return pSSubSysSADEBase.getDETag() == null;
            }
            case 9: {
                return pSSubSysSADEBase.getDETag2() == null;
            }
            case 10: {
                return pSSubSysSADEBase.getLogicName() == null;
            }
            case 11: {
                return pSSubSysSADEBase.getMajorFlag() == null;
            }
            case 12: {
                return pSSubSysSADEBase.getMemo() == null;
            }
            case 13: {
                return pSSubSysSADEBase.getMethodCode() == null;
            }
            case 14: {
                return pSSubSysSADEBase.getOrderValue() == null;
            }
            case 15: {
                return pSSubSysSADEBase.getPredefinedType() == null;
            }
            case 16: {
                return pSSubSysSADEBase.getPSSubSysSADEId() == null;
            }
            case 17: {
                return pSSubSysSADEBase.getPSSubSysSADEName() == null;
            }
            case 18: {
                return pSSubSysSADEBase.getPSSubSysServiceAPIId() == null;
            }
            case 19: {
                return pSSubSysSADEBase.getPSSubSysServiceAPIName() == null;
            }
            case 20: {
                return pSSubSysSADEBase.getPSSysReqItemId() == null;
            }
            case 21: {
                return pSSubSysSADEBase.getPSSysReqItemName() == null;
            }
            case 22: {
                return pSSubSysSADEBase.getPSSysSFPluginId() == null;
            }
            case 23: {
                return pSSubSysSADEBase.getPSSysSFPluginName() == null;
            }
            case 24: {
                return pSSubSysSADEBase.getServiceParam() == null;
            }
            case 25: {
                return pSSubSysSADEBase.getServiceParam2() == null;
            }
            case 26: {
                return pSSubSysSADEBase.getSyncModelMode() == null;
            }
            case 27: {
                return pSSubSysSADEBase.getUpdateDate() == null;
            }
            case 28: {
                return pSSubSysSADEBase.getUpdateMan() == null;
            }
            case 29: {
                return pSSubSysSADEBase.getUserCat() == null;
            }
            case 30: {
                return pSSubSysSADEBase.getUserTag() == null;
            }
            case 31: {
                return pSSubSysSADEBase.getUserTag2() == null;
            }
            case 32: {
                return pSSubSysSADEBase.getUserTag3() == null;
            }
            case 33: {
                return pSSubSysSADEBase.getUserTag4() == null;
            }
            case 34: {
                return pSSubSysSADEBase.getValidFlag() == null;
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
        return PSSubSysSADEBase.contains(this, n);
    }

    private static boolean contains(PSSubSysSADEBase pSSubSysSADEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubSysSADEBase.isBaseClsParamsDirty();
            }
            case 1: {
                return pSSubSysSADEBase.isCodeNameDirty();
            }
            case 2: {
                return pSSubSysSADEBase.isCodeName2Dirty();
            }
            case 3: {
                return pSSubSysSADEBase.isCreateDateDirty();
            }
            case 4: {
                return pSSubSysSADEBase.isCreateManDirty();
            }
            case 5: {
                return pSSubSysSADEBase.isCustomCodeDirty();
            }
            case 6: {
                return pSSubSysSADEBase.isCustomModeDirty();
            }
            case 7: {
                return pSSubSysSADEBase.isDEParamsDirty();
            }
            case 8: {
                return pSSubSysSADEBase.isDETagDirty();
            }
            case 9: {
                return pSSubSysSADEBase.isDETag2Dirty();
            }
            case 10: {
                return pSSubSysSADEBase.isLogicNameDirty();
            }
            case 11: {
                return pSSubSysSADEBase.isMajorFlagDirty();
            }
            case 12: {
                return pSSubSysSADEBase.isMemoDirty();
            }
            case 13: {
                return pSSubSysSADEBase.isMethodCodeDirty();
            }
            case 14: {
                return pSSubSysSADEBase.isOrderValueDirty();
            }
            case 15: {
                return pSSubSysSADEBase.isPredefinedTypeDirty();
            }
            case 16: {
                return pSSubSysSADEBase.isPSSubSysSADEIdDirty();
            }
            case 17: {
                return pSSubSysSADEBase.isPSSubSysSADENameDirty();
            }
            case 18: {
                return pSSubSysSADEBase.isPSSubSysServiceAPIIdDirty();
            }
            case 19: {
                return pSSubSysSADEBase.isPSSubSysServiceAPINameDirty();
            }
            case 20: {
                return pSSubSysSADEBase.isPSSysReqItemIdDirty();
            }
            case 21: {
                return pSSubSysSADEBase.isPSSysReqItemNameDirty();
            }
            case 22: {
                return pSSubSysSADEBase.isPSSysSFPluginIdDirty();
            }
            case 23: {
                return pSSubSysSADEBase.isPSSysSFPluginNameDirty();
            }
            case 24: {
                return pSSubSysSADEBase.isServiceParamDirty();
            }
            case 25: {
                return pSSubSysSADEBase.isServiceParam2Dirty();
            }
            case 26: {
                return pSSubSysSADEBase.isSyncModelModeDirty();
            }
            case 27: {
                return pSSubSysSADEBase.isUpdateDateDirty();
            }
            case 28: {
                return pSSubSysSADEBase.isUpdateManDirty();
            }
            case 29: {
                return pSSubSysSADEBase.isUserCatDirty();
            }
            case 30: {
                return pSSubSysSADEBase.isUserTagDirty();
            }
            case 31: {
                return pSSubSysSADEBase.isUserTag2Dirty();
            }
            case 32: {
                return pSSubSysSADEBase.isUserTag3Dirty();
            }
            case 33: {
                return pSSubSysSADEBase.isUserTag4Dirty();
            }
            case 34: {
                return pSSubSysSADEBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSubSysSADEBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSubSysSADEBase pSSubSysSADEBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSubSysSADEBase.getBaseClsParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"baseclsparams", (Object)PSSubSysSADEBase.getJSONValue((Object)pSSubSysSADEBase.getBaseClsParams()), (boolean)false);
        }
        if (bl || pSSubSysSADEBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSubSysSADEBase.getJSONValue((Object)pSSubSysSADEBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSubSysSADEBase.getCodeName2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename2", (Object)PSSubSysSADEBase.getJSONValue((Object)pSSubSysSADEBase.getCodeName2()), (boolean)false);
        }
        if (bl || pSSubSysSADEBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSubSysSADEBase.getJSONValue((Object)pSSubSysSADEBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSubSysSADEBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSubSysSADEBase.getJSONValue((Object)pSSubSysSADEBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSubSysSADEBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSSubSysSADEBase.getJSONValue((Object)pSSubSysSADEBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSSubSysSADEBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSSubSysSADEBase.getJSONValue((Object)pSSubSysSADEBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSSubSysSADEBase.getDEParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deparams", (Object)PSSubSysSADEBase.getJSONValue((Object)pSSubSysSADEBase.getDEParams()), (boolean)false);
        }
        if (bl || pSSubSysSADEBase.getDETag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detag", (Object)PSSubSysSADEBase.getJSONValue((Object)pSSubSysSADEBase.getDETag()), (boolean)false);
        }
        if (bl || pSSubSysSADEBase.getDETag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detag2", (Object)PSSubSysSADEBase.getJSONValue((Object)pSSubSysSADEBase.getDETag2()), (boolean)false);
        }
        if (bl || pSSubSysSADEBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSSubSysSADEBase.getJSONValue((Object)pSSubSysSADEBase.getLogicName()), (boolean)false);
        }
        if (bl || pSSubSysSADEBase.getMajorFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"majorflag", (Object)PSSubSysSADEBase.getJSONValue((Object)pSSubSysSADEBase.getMajorFlag()), (boolean)false);
        }
        if (bl || pSSubSysSADEBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSubSysSADEBase.getJSONValue((Object)pSSubSysSADEBase.getMemo()), (boolean)false);
        }
        if (bl || pSSubSysSADEBase.getMethodCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"methodcode", (Object)PSSubSysSADEBase.getJSONValue((Object)pSSubSysSADEBase.getMethodCode()), (boolean)false);
        }
        if (bl || pSSubSysSADEBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSubSysSADEBase.getJSONValue((Object)pSSubSysSADEBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSubSysSADEBase.getPredefinedType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"predefinedtype", (Object)PSSubSysSADEBase.getJSONValue((Object)pSSubSysSADEBase.getPredefinedType()), (boolean)false);
        }
        if (bl || pSSubSysSADEBase.getPSSubSysSADEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsyssadeid", (Object)PSSubSysSADEBase.getJSONValue((Object)pSSubSysSADEBase.getPSSubSysSADEId()), (boolean)false);
        }
        if (bl || pSSubSysSADEBase.getPSSubSysSADEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsyssadename", (Object)PSSubSysSADEBase.getJSONValue((Object)pSSubSysSADEBase.getPSSubSysSADEName()), (boolean)false);
        }
        if (bl || pSSubSysSADEBase.getPSSubSysServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysserviceapiid", (Object)PSSubSysSADEBase.getJSONValue((Object)pSSubSysSADEBase.getPSSubSysServiceAPIId()), (boolean)false);
        }
        if (bl || pSSubSysSADEBase.getPSSubSysServiceAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysserviceapiname", (Object)PSSubSysSADEBase.getJSONValue((Object)pSSubSysSADEBase.getPSSubSysServiceAPIName()), (boolean)false);
        }
        if (bl || pSSubSysSADEBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSSubSysSADEBase.getJSONValue((Object)pSSubSysSADEBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSSubSysSADEBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSSubSysSADEBase.getJSONValue((Object)pSSubSysSADEBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSSubSysSADEBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSSubSysSADEBase.getJSONValue((Object)pSSubSysSADEBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSSubSysSADEBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSSubSysSADEBase.getJSONValue((Object)pSSubSysSADEBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSSubSysSADEBase.getServiceParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceparam", (Object)PSSubSysSADEBase.getJSONValue((Object)pSSubSysSADEBase.getServiceParam()), (boolean)false);
        }
        if (bl || pSSubSysSADEBase.getServiceParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceparam2", (Object)PSSubSysSADEBase.getJSONValue((Object)pSSubSysSADEBase.getServiceParam2()), (boolean)false);
        }
        if (bl || pSSubSysSADEBase.getSyncModelMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syncmodelmode", (Object)PSSubSysSADEBase.getJSONValue((Object)pSSubSysSADEBase.getSyncModelMode()), (boolean)false);
        }
        if (bl || pSSubSysSADEBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSubSysSADEBase.getJSONValue((Object)pSSubSysSADEBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSubSysSADEBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSubSysSADEBase.getJSONValue((Object)pSSubSysSADEBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSubSysSADEBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSubSysSADEBase.getJSONValue((Object)pSSubSysSADEBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSubSysSADEBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSubSysSADEBase.getJSONValue((Object)pSSubSysSADEBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSubSysSADEBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSubSysSADEBase.getJSONValue((Object)pSSubSysSADEBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSubSysSADEBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSubSysSADEBase.getJSONValue((Object)pSSubSysSADEBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSubSysSADEBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSubSysSADEBase.getJSONValue((Object)pSSubSysSADEBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSubSysSADEBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSubSysSADEBase.getJSONValue((Object)pSSubSysSADEBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSubSysSADEBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSubSysSADEBase pSSubSysSADEBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSubSysSADEBase.getBaseClsParams() != null) {
            object = pSSubSysSADEBase.getBaseClsParams();
            xmlNode.setAttribute(FIELD_BASECLSPARAMS, (String)(object == null ? "" : object));
        }
        if (bl || pSSubSysSADEBase.getCodeName() != null) {
            object = pSSubSysSADEBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSSubSysSADEBase.getCodeName2() != null) {
            object = pSSubSysSADEBase.getCodeName2();
            xmlNode.setAttribute(FIELD_CODENAME2, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEBase.getCreateDate() != null) {
            object = pSSubSysSADEBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSubSysSADEBase.getCreateMan() != null) {
            object = pSSubSysSADEBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEBase.getCustomCode() != null) {
            object = pSSubSysSADEBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEBase.getCustomMode() != null) {
            object = pSSubSysSADEBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSubSysSADEBase.getDEParams() != null) {
            object = pSSubSysSADEBase.getDEParams();
            xmlNode.setAttribute(FIELD_DEPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEBase.getDETag() != null) {
            object = pSSubSysSADEBase.getDETag();
            xmlNode.setAttribute(FIELD_DETAG, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEBase.getDETag2() != null) {
            object = pSSubSysSADEBase.getDETag2();
            xmlNode.setAttribute(FIELD_DETAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEBase.getLogicName() != null) {
            object = pSSubSysSADEBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEBase.getMajorFlag() != null) {
            object = pSSubSysSADEBase.getMajorFlag();
            xmlNode.setAttribute(FIELD_MAJORFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSubSysSADEBase.getMemo() != null) {
            object = pSSubSysSADEBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEBase.getMethodCode() != null) {
            object = pSSubSysSADEBase.getMethodCode();
            xmlNode.setAttribute(FIELD_METHODCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEBase.getOrderValue() != null) {
            object = pSSubSysSADEBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSubSysSADEBase.getPredefinedType() != null) {
            object = pSSubSysSADEBase.getPredefinedType();
            xmlNode.setAttribute(FIELD_PREDEFINEDTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEBase.getPSSubSysSADEId() != null) {
            object = pSSubSysSADEBase.getPSSubSysSADEId();
            xmlNode.setAttribute(FIELD_PSSUBSYSSADEID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEBase.getPSSubSysSADEName() != null) {
            object = pSSubSysSADEBase.getPSSubSysSADEName();
            xmlNode.setAttribute(FIELD_PSSUBSYSSADENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEBase.getPSSubSysServiceAPIId() != null) {
            object = pSSubSysSADEBase.getPSSubSysServiceAPIId();
            xmlNode.setAttribute(FIELD_PSSUBSYSSERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEBase.getPSSubSysServiceAPIName() != null) {
            object = pSSubSysSADEBase.getPSSubSysServiceAPIName();
            xmlNode.setAttribute(FIELD_PSSUBSYSSERVICEAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEBase.getPSSysReqItemId() != null) {
            object = pSSubSysSADEBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEBase.getPSSysReqItemName() != null) {
            object = pSSubSysSADEBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEBase.getPSSysSFPluginId() != null) {
            object = pSSubSysSADEBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEBase.getPSSysSFPluginName() != null) {
            object = pSSubSysSADEBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEBase.getServiceParam() != null) {
            object = pSSubSysSADEBase.getServiceParam();
            xmlNode.setAttribute(FIELD_SERVICEPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEBase.getServiceParam2() != null) {
            object = pSSubSysSADEBase.getServiceParam2();
            xmlNode.setAttribute(FIELD_SERVICEPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEBase.getSyncModelMode() != null) {
            object = pSSubSysSADEBase.getSyncModelMode();
            xmlNode.setAttribute(FIELD_SYNCMODELMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEBase.getUpdateDate() != null) {
            object = pSSubSysSADEBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSubSysSADEBase.getUpdateMan() != null) {
            object = pSSubSysSADEBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEBase.getUserCat() != null) {
            object = pSSubSysSADEBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEBase.getUserTag() != null) {
            object = pSSubSysSADEBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEBase.getUserTag2() != null) {
            object = pSSubSysSADEBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEBase.getUserTag3() != null) {
            object = pSSubSysSADEBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEBase.getUserTag4() != null) {
            object = pSSubSysSADEBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEBase.getValidFlag() != null) {
            object = pSSubSysSADEBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSubSysSADEBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSubSysSADEBase pSSubSysSADEBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSubSysSADEBase.isBaseClsParamsDirty() && (bl || pSSubSysSADEBase.getBaseClsParams() != null)) {
            iDataObject.set(FIELD_BASECLSPARAMS, (Object)pSSubSysSADEBase.getBaseClsParams());
        }
        if (pSSubSysSADEBase.isCodeNameDirty() && (bl || pSSubSysSADEBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSubSysSADEBase.getCodeName());
        }
        if (pSSubSysSADEBase.isCodeName2Dirty() && (bl || pSSubSysSADEBase.getCodeName2() != null)) {
            iDataObject.set(FIELD_CODENAME2, (Object)pSSubSysSADEBase.getCodeName2());
        }
        if (pSSubSysSADEBase.isCreateDateDirty() && (bl || pSSubSysSADEBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSubSysSADEBase.getCreateDate());
        }
        if (pSSubSysSADEBase.isCreateManDirty() && (bl || pSSubSysSADEBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSubSysSADEBase.getCreateMan());
        }
        if (pSSubSysSADEBase.isCustomCodeDirty() && (bl || pSSubSysSADEBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSSubSysSADEBase.getCustomCode());
        }
        if (pSSubSysSADEBase.isCustomModeDirty() && (bl || pSSubSysSADEBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSSubSysSADEBase.getCustomMode());
        }
        if (pSSubSysSADEBase.isDEParamsDirty() && (bl || pSSubSysSADEBase.getDEParams() != null)) {
            iDataObject.set(FIELD_DEPARAMS, (Object)pSSubSysSADEBase.getDEParams());
        }
        if (pSSubSysSADEBase.isDETagDirty() && (bl || pSSubSysSADEBase.getDETag() != null)) {
            iDataObject.set(FIELD_DETAG, (Object)pSSubSysSADEBase.getDETag());
        }
        if (pSSubSysSADEBase.isDETag2Dirty() && (bl || pSSubSysSADEBase.getDETag2() != null)) {
            iDataObject.set(FIELD_DETAG2, (Object)pSSubSysSADEBase.getDETag2());
        }
        if (pSSubSysSADEBase.isLogicNameDirty() && (bl || pSSubSysSADEBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSSubSysSADEBase.getLogicName());
        }
        if (pSSubSysSADEBase.isMajorFlagDirty() && (bl || pSSubSysSADEBase.getMajorFlag() != null)) {
            iDataObject.set(FIELD_MAJORFLAG, (Object)pSSubSysSADEBase.getMajorFlag());
        }
        if (pSSubSysSADEBase.isMemoDirty() && (bl || pSSubSysSADEBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSubSysSADEBase.getMemo());
        }
        if (pSSubSysSADEBase.isMethodCodeDirty() && (bl || pSSubSysSADEBase.getMethodCode() != null)) {
            iDataObject.set(FIELD_METHODCODE, (Object)pSSubSysSADEBase.getMethodCode());
        }
        if (pSSubSysSADEBase.isOrderValueDirty() && (bl || pSSubSysSADEBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSubSysSADEBase.getOrderValue());
        }
        if (pSSubSysSADEBase.isPredefinedTypeDirty() && (bl || pSSubSysSADEBase.getPredefinedType() != null)) {
            iDataObject.set(FIELD_PREDEFINEDTYPE, (Object)pSSubSysSADEBase.getPredefinedType());
        }
        if (pSSubSysSADEBase.isPSSubSysSADEIdDirty() && (bl || pSSubSysSADEBase.getPSSubSysSADEId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSADEID, (Object)pSSubSysSADEBase.getPSSubSysSADEId());
        }
        if (pSSubSysSADEBase.isPSSubSysSADENameDirty() && (bl || pSSubSysSADEBase.getPSSubSysSADEName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSADENAME, (Object)pSSubSysSADEBase.getPSSubSysSADEName());
        }
        if (pSSubSysSADEBase.isPSSubSysServiceAPIIdDirty() && (bl || pSSubSysSADEBase.getPSSubSysServiceAPIId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSERVICEAPIID, (Object)pSSubSysSADEBase.getPSSubSysServiceAPIId());
        }
        if (pSSubSysSADEBase.isPSSubSysServiceAPINameDirty() && (bl || pSSubSysSADEBase.getPSSubSysServiceAPIName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSERVICEAPINAME, (Object)pSSubSysSADEBase.getPSSubSysServiceAPIName());
        }
        if (pSSubSysSADEBase.isPSSysReqItemIdDirty() && (bl || pSSubSysSADEBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSSubSysSADEBase.getPSSysReqItemId());
        }
        if (pSSubSysSADEBase.isPSSysReqItemNameDirty() && (bl || pSSubSysSADEBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSSubSysSADEBase.getPSSysReqItemName());
        }
        if (pSSubSysSADEBase.isPSSysSFPluginIdDirty() && (bl || pSSubSysSADEBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSSubSysSADEBase.getPSSysSFPluginId());
        }
        if (pSSubSysSADEBase.isPSSysSFPluginNameDirty() && (bl || pSSubSysSADEBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSSubSysSADEBase.getPSSysSFPluginName());
        }
        if (pSSubSysSADEBase.isServiceParamDirty() && (bl || pSSubSysSADEBase.getServiceParam() != null)) {
            iDataObject.set(FIELD_SERVICEPARAM, (Object)pSSubSysSADEBase.getServiceParam());
        }
        if (pSSubSysSADEBase.isServiceParam2Dirty() && (bl || pSSubSysSADEBase.getServiceParam2() != null)) {
            iDataObject.set(FIELD_SERVICEPARAM2, (Object)pSSubSysSADEBase.getServiceParam2());
        }
        if (pSSubSysSADEBase.isSyncModelModeDirty() && (bl || pSSubSysSADEBase.getSyncModelMode() != null)) {
            iDataObject.set(FIELD_SYNCMODELMODE, (Object)pSSubSysSADEBase.getSyncModelMode());
        }
        if (pSSubSysSADEBase.isUpdateDateDirty() && (bl || pSSubSysSADEBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSubSysSADEBase.getUpdateDate());
        }
        if (pSSubSysSADEBase.isUpdateManDirty() && (bl || pSSubSysSADEBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSubSysSADEBase.getUpdateMan());
        }
        if (pSSubSysSADEBase.isUserCatDirty() && (bl || pSSubSysSADEBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSubSysSADEBase.getUserCat());
        }
        if (pSSubSysSADEBase.isUserTagDirty() && (bl || pSSubSysSADEBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSubSysSADEBase.getUserTag());
        }
        if (pSSubSysSADEBase.isUserTag2Dirty() && (bl || pSSubSysSADEBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSubSysSADEBase.getUserTag2());
        }
        if (pSSubSysSADEBase.isUserTag3Dirty() && (bl || pSSubSysSADEBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSubSysSADEBase.getUserTag3());
        }
        if (pSSubSysSADEBase.isUserTag4Dirty() && (bl || pSSubSysSADEBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSubSysSADEBase.getUserTag4());
        }
        if (pSSubSysSADEBase.isValidFlagDirty() && (bl || pSSubSysSADEBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSubSysSADEBase.getValidFlag());
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
        return PSSubSysSADEBase.remove(this, n);
    }

    private static boolean remove(PSSubSysSADEBase pSSubSysSADEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSubSysSADEBase.resetBaseClsParams();
                return true;
            }
            case 1: {
                pSSubSysSADEBase.resetCodeName();
                return true;
            }
            case 2: {
                pSSubSysSADEBase.resetCodeName2();
                return true;
            }
            case 3: {
                pSSubSysSADEBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSSubSysSADEBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSSubSysSADEBase.resetCustomCode();
                return true;
            }
            case 6: {
                pSSubSysSADEBase.resetCustomMode();
                return true;
            }
            case 7: {
                pSSubSysSADEBase.resetDEParams();
                return true;
            }
            case 8: {
                pSSubSysSADEBase.resetDETag();
                return true;
            }
            case 9: {
                pSSubSysSADEBase.resetDETag2();
                return true;
            }
            case 10: {
                pSSubSysSADEBase.resetLogicName();
                return true;
            }
            case 11: {
                pSSubSysSADEBase.resetMajorFlag();
                return true;
            }
            case 12: {
                pSSubSysSADEBase.resetMemo();
                return true;
            }
            case 13: {
                pSSubSysSADEBase.resetMethodCode();
                return true;
            }
            case 14: {
                pSSubSysSADEBase.resetOrderValue();
                return true;
            }
            case 15: {
                pSSubSysSADEBase.resetPredefinedType();
                return true;
            }
            case 16: {
                pSSubSysSADEBase.resetPSSubSysSADEId();
                return true;
            }
            case 17: {
                pSSubSysSADEBase.resetPSSubSysSADEName();
                return true;
            }
            case 18: {
                pSSubSysSADEBase.resetPSSubSysServiceAPIId();
                return true;
            }
            case 19: {
                pSSubSysSADEBase.resetPSSubSysServiceAPIName();
                return true;
            }
            case 20: {
                pSSubSysSADEBase.resetPSSysReqItemId();
                return true;
            }
            case 21: {
                pSSubSysSADEBase.resetPSSysReqItemName();
                return true;
            }
            case 22: {
                pSSubSysSADEBase.resetPSSysSFPluginId();
                return true;
            }
            case 23: {
                pSSubSysSADEBase.resetPSSysSFPluginName();
                return true;
            }
            case 24: {
                pSSubSysSADEBase.resetServiceParam();
                return true;
            }
            case 25: {
                pSSubSysSADEBase.resetServiceParam2();
                return true;
            }
            case 26: {
                pSSubSysSADEBase.resetSyncModelMode();
                return true;
            }
            case 27: {
                pSSubSysSADEBase.resetUpdateDate();
                return true;
            }
            case 28: {
                pSSubSysSADEBase.resetUpdateMan();
                return true;
            }
            case 29: {
                pSSubSysSADEBase.resetUserCat();
                return true;
            }
            case 30: {
                pSSubSysSADEBase.resetUserTag();
                return true;
            }
            case 31: {
                pSSubSysSADEBase.resetUserTag2();
                return true;
            }
            case 32: {
                pSSubSysSADEBase.resetUserTag3();
                return true;
            }
            case 33: {
                pSSubSysSADEBase.resetUserTag4();
                return true;
            }
            case 34: {
                pSSubSysSADEBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
    public PSSysReqItem getPSSysReqItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItem();
        }
        if (this.getPSSysReqItemId() == null) {
            return null;
        }
        Integer n = this.objPSSysReqItemLock;
        synchronized (n) {
            if (this.pssysreqitem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysReqItemId(), (Object)this.pssysreqitem.getPSSysReqItemId()) != 0L) {
                this.pssysreqitem = null;
            }
            if (this.pssysreqitem == null) {
                PSSysReqItem pSSysReqItem = new PSSysReqItem();
                pSSysReqItem.setPSSysReqItemId(this.getPSSysReqItemId());
                PSSysReqItemService pSSysReqItemService = (PSSysReqItemService)ServiceGlobal.getService(PSSysReqItemService.class, (SessionFactory)this.getSessionFactory());
                pSSysReqItemService.autoGet(pSSysReqItem);
                this.pssysreqitem = pSSysReqItem;
            }
            return this.pssysreqitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSFPlugin getPSSysSFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPlugin();
        }
        if (this.getPSSysSFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSSysSFPluginLock;
        synchronized (n) {
            if (this.pssyssfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSFPluginId(), (Object)this.pssyssfplugin.getPSSysSFPluginId()) != 0L) {
                this.pssyssfplugin = null;
            }
            if (this.pssyssfplugin == null) {
                PSSysSFPlugin pSSysSFPlugin = new PSSysSFPlugin();
                pSSysSFPlugin.setPSSysSFPluginId(this.getPSSysSFPluginId());
                PSSysSFPluginService pSSysSFPluginService = (PSSysSFPluginService)ServiceGlobal.getService(PSSysSFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysSFPluginService.autoGet(pSSysSFPlugin);
                this.pssyssfplugin = pSSysSFPlugin;
            }
            return this.pssyssfplugin;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSubSysSADEField> getPSSubSysSADEFields() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysSADEFields();
        }
        if (this.getPSSubSysSADEId() == null) {
            return null;
        }
        PSSubSysSADEFieldService pSSubSysSADEFieldService = (PSSubSysSADEFieldService)ServiceGlobal.getService(PSSubSysSADEFieldService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSubSysSADEFieldsLock;
        synchronized (n) {
            if (this.pssubsyssadefields == null) {
                this.pssubsyssadefields = pSSubSysSADEFieldService.selectByPSSubSysSADE(this);
            }
            return this.pssubsyssadefields;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSubSysSADERS> getMinorPSSubSysSADERSs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSSubSysSADERSs();
        }
        if (this.getPSSubSysSADEId() == null) {
            return null;
        }
        PSSubSysSADERSService pSSubSysSADERSService = (PSSubSysSADERSService)ServiceGlobal.getService(PSSubSysSADERSService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objMinorPSSubSysSADERSsLock;
        synchronized (n) {
            if (this.minorpssubsyssaderss == null) {
                this.minorpssubsyssaderss = pSSubSysSADERSService.selectByCPSSubSysSADE(this);
            }
            return this.minorpssubsyssaderss;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSubSysSADERS> getMajorPSSubSysSADERSs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSSubSysSADERSs();
        }
        if (this.getPSSubSysSADEId() == null) {
            return null;
        }
        PSSubSysSADERSService pSSubSysSADERSService = (PSSubSysSADERSService)ServiceGlobal.getService(PSSubSysSADERSService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objMajorPSSubSysSADERSsLock;
        synchronized (n) {
            if (this.majorpssubsyssaderss == null) {
                this.majorpssubsyssaderss = pSSubSysSADERSService.selectByPPSSubSysSADE(this);
            }
            return this.majorpssubsyssaderss;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSubSysSADetail> getPSSubSysSADetails() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysSADetails();
        }
        if (this.getPSSubSysSADEId() == null) {
            return null;
        }
        PSSubSysSADetailService pSSubSysSADetailService = (PSSubSysSADetailService)ServiceGlobal.getService(PSSubSysSADetailService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSubSysSADetailsLock;
        synchronized (n) {
            if (this.pssubsyssadetails == null) {
                this.pssubsyssadetails = pSSubSysSADetailService.selectByPSSubSysSADE(this);
            }
            return this.pssubsyssadetails;
        }
    }

    private PSSubSysSADEBase getProxyEntity() {
        return this.proxyPSSubSysSADEBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSubSysSADEBase = null;
        if (iDataObject != null && iDataObject instanceof PSSubSysSADEBase) {
            this.proxyPSSubSysSADEBase = (PSSubSysSADEBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADEService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BASECLSPARAMS, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CODENAME2, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 5);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 6);
        fieldIndexMap.put(FIELD_DEPARAMS, 7);
        fieldIndexMap.put(FIELD_DETAG, 8);
        fieldIndexMap.put(FIELD_DETAG2, 9);
        fieldIndexMap.put(FIELD_LOGICNAME, 10);
        fieldIndexMap.put(FIELD_MAJORFLAG, 11);
        fieldIndexMap.put(FIELD_MEMO, 12);
        fieldIndexMap.put(FIELD_METHODCODE, 13);
        fieldIndexMap.put(FIELD_ORDERVALUE, 14);
        fieldIndexMap.put(FIELD_PREDEFINEDTYPE, 15);
        fieldIndexMap.put(FIELD_PSSUBSYSSADEID, 16);
        fieldIndexMap.put(FIELD_PSSUBSYSSADENAME, 17);
        fieldIndexMap.put(FIELD_PSSUBSYSSERVICEAPIID, 18);
        fieldIndexMap.put(FIELD_PSSUBSYSSERVICEAPINAME, 19);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 20);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 21);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 22);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 23);
        fieldIndexMap.put(FIELD_SERVICEPARAM, 24);
        fieldIndexMap.put(FIELD_SERVICEPARAM2, 25);
        fieldIndexMap.put(FIELD_SYNCMODELMODE, 26);
        fieldIndexMap.put(FIELD_UPDATEDATE, 27);
        fieldIndexMap.put(FIELD_UPDATEMAN, 28);
        fieldIndexMap.put(FIELD_USERCAT, 29);
        fieldIndexMap.put(FIELD_USERTAG, 30);
        fieldIndexMap.put(FIELD_USERTAG2, 31);
        fieldIndexMap.put(FIELD_USERTAG3, 32);
        fieldIndexMap.put(FIELD_USERTAG4, 33);
        fieldIndexMap.put(FIELD_VALIDFLAG, 34);
    }
}

